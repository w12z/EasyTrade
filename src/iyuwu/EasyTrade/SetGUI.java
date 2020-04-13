package iyuwu.EasyTrade;
import org.bukkit.Material;
import org.bukkit.inventory.*;
public class SetGUI {//GUI的列表
    final ItemStack item_gl = new ItemStack(Material.STAINED_GLASS_PANE,1);
    final ItemStack item_bk=new ItemStack(Material.DIAMOND);
    public void CreateGUI(Inventory tmp){//设置创建交易的GUI
        //交易上方是卖的东西，下方是想要获得的东西
        tmp.setItem(0,item_bk);//如果上方缺省，那么就是求购，下方缺省，就是拍卖
        tmp.setItem(1,item_bk);
        tmp.setItem(2,item_bk);
        tmp.setItem(3,item_bk);
        tmp.setItem(4,item_bk);
        tmp.setItem(5,item_bk);
        tmp.setItem(6,item_bk);
        tmp.setItem(7,item_bk);
        tmp.setItem(8,item_bk);
        tmp.setItem(9,item_bk);
        tmp.setItem(17,item_bk);//要什么枚举，打表是个好东西
        tmp.setItem(18,item_bk);
        tmp.setItem(26,item_bk);
        tmp.setItem(27,item_bk);
        tmp.setItem(35,item_bk);
        tmp.setItem(36,item_bk);
        tmp.setItem(37,item_bk);
        tmp.setItem(38,item_bk);
        tmp.setItem(39,item_bk);
        tmp.setItem(40,item_bk);
        tmp.setItem(41,item_bk);
        tmp.setItem(42,item_bk);
        tmp.setItem(43,item_bk);
        tmp.setItem(44,item_bk);
        ItemStack item_gl = new ItemStack(Material.STAINED_GLASS_PANE,1);
        tmp.setItem(19,item_gl);
        tmp.setItem(20,item_gl);
        tmp.setItem(21,item_gl);
        tmp.setItem(22,new ItemStack(Material.GOLD_INGOT));
        tmp.setItem(23,item_gl);
        tmp.setItem(24,item_gl);
        tmp.setItem(25,item_gl);
    }
    public void InfoGUI(Inventory tmp){//交易上方是卖的东西，下方是想要获得的东西
        tmp.setItem(0,item_bk);      //如果上方缺省，那么就是求购，下方缺省，就是拍卖
        tmp.setItem(1,item_bk);
        tmp.setItem(2,item_bk);
        tmp.setItem(3,item_bk);
        tmp.setItem(4,item_bk);
        tmp.setItem(5,item_bk);
        tmp.setItem(6,item_bk);
        tmp.setItem(7,item_bk);
        tmp.setItem(8,item_bk);
        tmp.setItem(9,item_bk);
        tmp.setItem(17,item_bk);//要什么枚举，打表是个好东西
        tmp.setItem(18,item_bk);
        tmp.setItem(26,item_bk);
        tmp.setItem(27,item_bk);
        tmp.setItem(35,item_bk);
        tmp.setItem(36,item_bk);
        tmp.setItem(37,item_bk);
        tmp.setItem(38,item_bk);
        tmp.setItem(39,item_bk);
        tmp.setItem(40,item_bk);
        tmp.setItem(41,item_bk);
        tmp.setItem(42,item_bk);
        tmp.setItem(43,item_bk);
        tmp.setItem(44,item_bk);
        tmp.setItem(45,item_bk);
        tmp.setItem(53,item_bk);
        tmp.setItem(19,item_gl);
        tmp.setItem(20,item_gl);
        tmp.setItem(21,item_gl);
        tmp.setItem(22,new ItemStack(Material.GOLD_INGOT));
        tmp.setItem(23,item_gl);
        tmp.setItem(24,item_gl);
        tmp.setItem(25,item_gl);
    }
}
