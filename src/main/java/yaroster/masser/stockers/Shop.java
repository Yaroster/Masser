package yaroster.masser.stockers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Shop extends Canstock {
    public Ownable ownable;

    public Pricable pricable;

    public boolean diminuates;

    public Material material;

    public Location position;

    public int quantity;

    public int sells;

    public short data;

    public int reserve;

    public Shop(int id, Ownable ownable, Pricable pricable, boolean diminuates, Material material, int quantity, Location position, int sells, short data) {
        this.id = id;

        this.ownable = ownable;

        this.pricable = pricable;

        this.diminuates = diminuates;

        this.material = material;

        this.quantity = quantity;

        this.position = position;

        this.inDatabase = true;

        this.hasChanged = false;

        this.data = data;

        this.reserve = 0;
    }

    public Shop(Ownable ownable, boolean diminuates, Location position) {
        if (diminuates) {
            this.ownable = ownable;
        } else {
            this.ownable = new Ownable("#noowner#");
        }

        this.diminuates = diminuates;

        this.position = position;

        this.pricable = new Pricable(0);

        this.material = Material.AIR; //bug?

        this.quantity = 0;

        this.data = 0;

        this.sells = 0;

        this.id = 0;

        this.inDatabase = false;

        this.hasChanged = false;

        this.reserve = 0;
    }

    public ItemStack get() {
        ItemStack item = new ItemStack(this.material, 1);

        ItemMeta meta = item.getItemMeta();
        if (meta instanceof Damageable) {
            ((Damageable) meta).setDamage(this.data);
            item.setItemMeta(meta);
        }

        return item;
    }


    public ItemStack getTotal() {
        ItemStack item = new ItemStack(this.material, this.quantity);

        ItemMeta meta = item.getItemMeta();
        if (meta instanceof Damageable) {
            ((Damageable) meta).setDamage(this.data);
            item.setItemMeta(meta);
        }

        return item;
    }


    public void update(ItemStack item) {
        this.hasChanged = true;

        if (this.material == null || this.quantity == 0) {
            this.material = item.getType();
            this.data = (short) ((item.getItemMeta() instanceof Damageable) ? ((Damageable) item.getItemMeta()).getDamage() : 0);
            this.quantity = item.getAmount();
        } else if (this.quantity > 0) {
            if (this.material != item.getType()) {
                if (this.material != Material.AIR) {
                    Objects.requireNonNull(this.position.getWorld()).dropItem(this.position, new ItemStack(this.material, this.quantity));
                }

                this.material = item.getType();
                this.data = (short) ((item.getItemMeta() instanceof Damageable) ? ((Damageable) item.getItemMeta()).getDamage() : 0);
                this.quantity = item.getAmount();
            } else {
                this.quantity += item.getAmount();
            }
        }
    }
}
