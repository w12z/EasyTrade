package iyuwu.EasyTrade;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;

import java.io.File;

public class CmdListener implements CommandExecutor {
    public File Folder= new File(System.getProperty("user.dir")+"/plugins/EasyTrade/TradeList");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args == null || args.length==0) {
            sender.sendMessage("/trade create|info|del|edit|list");
            return true;
        }
        if (args[0].equals("create")){
            if(args.length==1){
                sender.sendMessage("/trade create <name>");
                return true;
            }
            else{
                Player p = (Player)sender;
                Inventory inv = Bukkit.createInventory(p,45,"Create "+args[1]);
                new SetGUI().CreateGUI(inv);
                p.openInventory(inv);
            }
        }
        if(args[0].equals("list")){
            File[] FilesF=Folder.listFiles();
            if(FilesF!=null) {
                sender.sendMessage("交易列表:\n");
                for(File i:FilesF) {
                    String s = String.valueOf(i);
                    sender.sendMessage("        " + s.substring(52, s.length() - 4));
                }
            }
            else{
                sender.sendMessage("交易列表为空");
            }
        }
        if(args[0].equals("info")){
            if(args.length==1){
                sender.sendMessage("/trade info <name>");
                return true;
            }
            else{
                File invFile=new File(String.valueOf(Folder)+"/"+args[1]+".yml");
                sender.sendMessage(String.valueOf(invFile));
                YamlConfiguration yml=YamlConfiguration.loadConfiguration(invFile);
                if(!invFile.exists()){
                    sender.sendMessage("没有这个名称的交易");
                    return true;
                }
                else{
                    String Owner=yml.getString("Owner");
                    Player p=(Player)sender;
                    Inventory invInfo=Bukkit.createInventory(p,54,"Info "+args[1]);
                    new SetGUI().InfoGUI(invInfo);
                    ConfigurationSection ymlSection=yml.getConfigurationSection("sale");
                    if(yml.contains("sale")){
                        for(String index:ymlSection.getKeys(false)){
                            invInfo.setItem(10+Integer.parseInt(index),ymlSection.getItemStack(index));
                        }
                    }
                    ymlSection=yml.getConfigurationSection("want");
                    if(yml.contains("want")){
                        for(String index:ymlSection.getKeys(false)){
                            invInfo.setItem(28+Integer.parseInt(index),ymlSection.getItemStack(index));
                        }
                    }
                    ((Player) sender).openInventory(invInfo);
                }

            }
        }
        return true;
    }
}