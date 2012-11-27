package me.gomeow.hostilepigmen;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

	List<World> worlds;
	int Task;
	@Override
	public void onEnable() {
		worlds = Bukkit.getServer().getWorlds();
		this.getServer().getPluginManager().registerEvents(this, this);
		Task = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				for(World world : worlds) {
				List<Entity> entities = world.getEntities();
				 	for(Entity e : entities) {
				 		if(e instanceof PigZombie) {
				 			PigZombie pz = (PigZombie) e;
				 			pz.setAnger(10);
				 		}
				 	}
				}
			}
			
		}, 1L, 120L);
		
	}
	
	@Override
	public void onDisable() {
		Bukkit.getScheduler().cancelTask(Task);
	}
	
	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent event) {
		if(event.getEntity() instanceof PigZombie) {
			PigZombie pz = (PigZombie) event.getEntity();
			pz.setAnger(10);
		}
	}
	
}
