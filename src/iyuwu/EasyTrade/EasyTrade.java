package iyuwu.EasyTrade;
import javafx.event.Event;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class EasyTrade extends JavaPlugin{
    final public File Folder = this.getDataFolder();
    public void onEnable() {
        this.getLogger().info("EasyTrade is enabled");
        saveDefaultConfig();
        EventListener e=new EventListener();
        CmdListener c=new CmdListener();
        Bukkit.getPluginManager().registerEvents(e, this);
        Bukkit.getPluginCommand("trade").setExecutor(c);
    }
    public void onDisable(){
        this.getLogger().info("EasyTrade is disabled");
    }
}
