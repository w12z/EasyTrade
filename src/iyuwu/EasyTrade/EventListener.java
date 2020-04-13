package iyuwu.EasyTrade;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class EventListener implements Listener {
    public File Folder= new File(System.getProperty("user.dir")+"/plugins/EasyTrade/TradeList");
    final int[] UnMoveAble={0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44,19,20,21,22,23,24,25,45,53};
    final int[] UnMoveAbleInfo={10,11,12,13,14,15,16,28,29,30,31,32,33,34};
    public boolean contains(int[] a,int b){
        for(int i : a){
            if(i==b)return true;//数组a里是否含有b
        }
        return false;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getWhoClicked().getOpenInventory().getTitle().contains("Create")&&contains(UnMoveAble,e.getRawSlot())) {
            e.setCancelled(true);
            if(e.getRawSlot()==22){
                ArrayList<ItemStack> sale = new ArrayList<>();
                for(int i=10;i<=16;i++){
                    if(e.getWhoClicked().getOpenInventory().getItem(i)!=null)
                        sale.add(e.getWhoClicked().getOpenInventory().getItem(i));
                }
                ArrayList<ItemStack> want = new ArrayList<>();
                for(int i=28;i<=34;i++){
                    if(e.getWhoClicked().getOpenInventory().getItem(i)!=null)
                        want.add(e.getWhoClicked().getOpenInventory().getItem(i));
                        e.getWhoClicked().getInventory().addItem(e.getWhoClicked().getOpenInventory().getItem(i));
                }
                YamlConfiguration yml = YamlConfiguration.loadConfiguration(new File(this.Folder+"/"+e.getWhoClicked().getOpenInventory().getTitle().substring(7)+".yml"));
                yml.set("sale",null);
                yml.set("Owner",e.getWhoClicked().getOpenInventory().getPlayer().getName());
                for(int index=0;index<sale.size();index++){
                    if(sale.get(index).getType()!= Material.AIR && sale.get(index) !=null){
                        yml.set("sale."+index, sale.get(index));
                    }
                }
                yml.set("want",null);
                for(int index=0;index<want.size();index++){
                    if(want.get(index).getType()!= Material.AIR && want.get(index) !=null){
                        yml.set("want."+index, want.get(index));
                    }
                }
                try {
                    yml.save(this.Folder+"/"+e.getWhoClicked().getOpenInventory().getTitle().substring(7)+".yml");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Collection<? extends Player> p=Bukkit.getOnlinePlayers();
                for(Player i:p){
                    i.sendMessage("玩家 "+e.getWhoClicked().getName()+" 创建了交易 "+e.getWhoClicked().getOpenInventory().getTitle().substring(7));
                }
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage("交易保存成功");
            }
        }
        if(e.getWhoClicked().getOpenInventory().getTitle().contains("Info") &&(contains(UnMoveAble,e.getRawSlot()) || contains(UnMoveAbleInfo,e.getRawSlot()))){
            e.setCancelled(true);
            if(e.getRawSlot()==22){
                boolean IsOk=true;
                for(int i=1;i<=7;i++){
                    if(e.getWhoClicked().getOpenInventory().getItem(i+9) != e.getWhoClicked().getOpenInventory().getItem(i+45)){
                        e.getWhoClicked().sendMessage("放置的物品与所需要的不同");
                        IsOk=false;
                        break;
                    }
                }
                if(IsOk){
                    for(int i=1;i<=7;i++){
                        e.getWhoClicked().getInventory().addItem(e.getWhoClicked().getOpenInventory().getItem(i+27));
                        e.getWhoClicked().closeInventory();
                        e.getWhoClicked().sendMessage("交易成功");
                    }
                }
            }
        }
        //玩家点击GUI之外不是格子的地方也会触发InventoryClickEvent, 处理
        if(e.getRawSlot()<0 || e.getRawSlot()>e.getInventory().getSize() || e.getInventory()==null)
            return;
    }
}
