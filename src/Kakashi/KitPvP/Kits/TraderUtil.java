package Kakashi.KitPvP.Kits;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Kakashi.KitPvP.Sistemas.*;

public class TraderUtil
{
    public static void MsgSemTrader(final Player p) {
        p.sendMessage(String.valueOf(API.preffix) + "§7Voc\u00ea n\u00e3o possui coins trader suficiente");
    }
    
    public static void darItemTroca(final Player p, final Material mat, final int modo) {
        final ItemStack item = new ItemStack(mat, 1, (short)modo);
        final ItemMeta itemm = item.getItemMeta();
        item.setItemMeta(itemm);
        p.getInventory().addItem(new ItemStack[] { item });
        p.updateInventory();
    }
}
