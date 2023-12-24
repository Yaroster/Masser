package yaroster.masser.stockers;

import org.bukkit.Location;
import yaroster.masser.Masser;

import java.util.Map;

public class Prison extends Canstock
{
	Masser main;
	
	public String variable;
	
	public Location spawn, exit;
	
	public int counter;
	
	public Plot plot;
	
	public Prison(Masser main, String variable, Plot plot)
	{
		this.main = main;
		
		this.variable = variable;
		
		this.plot = plot;
		
		this.spawn = null;
		
		this.exit = null;
		
		this.counter = 0;
		
		this.id = 0;
		
		this.hasChanged = false;
		
		this.inDatabase = false;
	}
	
	public Prison(Masser main, int id, String variable, Plot plot, Location spawn, Location exit, int counter)
	{
		this.main = main;
		
		this.id = id;
		
		this.variable = variable;
		
		this.plot = plot;
		
		this.spawn = spawn;
		
		this.exit = exit;
		
		this.counter = counter;
		
		this.hasChanged = false;
		
		this.inDatabase = true;
	}
	
	public String getAbbreviation()
	{
		return "prisons.name." + this.variable;
	}
	
	public void clearChests()
	{
		for (Map.Entry<Location, Prische> entry : this.main.prisches.entrySet())
        {
			if (entry.getValue().prison.id == this.id)
			{
				entry.getValue().clear();
			}
        }
	}
	
	public int countPlayers()
	{
		return this.main.countGamersOfPrison(this);
	}
}
