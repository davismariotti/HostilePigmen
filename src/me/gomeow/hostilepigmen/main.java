package me.gomeow.hostilepigmen;

import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent event) {
		if(event.getEntity() instanceof PigZombie) {
			PigZombie pz = (PigZombie) event.getEntity();
			pz.setAngry(true);
		}
	}
	
}
