package Kakashi.KitPvP.Guis;

import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Kakashi.KitPvP.Sistemas.API;

import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class GuiLoja implements Listener
{
    public static String semxp;
    
    static {
        GuiLoja.semxp = String.valueOf(API.preffix) + "§cVoc\u00ea n\u00e3o tem xp suficiente §4✗";
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void GuiLojaKit(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 18, "§4§lLoja De Kits");
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
        final ItemMeta vidrom = vidro.getItemMeta();
        vidrom.setDisplayName("§7Vidro");
        vidro.setItemMeta(vidrom);
        if (!p.hasPermission("kit.gaara")) {
            final ItemStack gaara = new ItemStack(Material.SAND);
            final ItemMeta gaaram = gaara.getItemMeta();
            gaaram.setDisplayName("§7Kit §4Gaara");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l30.000XP");
            desc.add("§7§lPrenda os players no caix\u00e3o de areia");
            gaaram.setLore((List)desc);
            gaara.setItemMeta(gaaram);
            inv.setItem(9, gaara);
        }
        else if (p.hasPermission("kit.gaara")) {
            final ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta gaaram = gaara.getItemMeta();
            gaaram.setDisplayName("§7Kit §4Gaara");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            gaaram.setLore((List)desc);
            gaara.setItemMeta(gaaram);
            inv.setItem(9, gaara);
        }
        if (!p.hasPermission("kit.magma")) {
            final ItemStack magma = new ItemStack(Material.LAVA_BUCKET);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§7Kit §4Magma");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l15.000XP");
            desc.add("§7§lSeja imune a lava");
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(11, magma);
        }
        else if (p.hasPermission("kit.magma")) {
            final ItemStack magma = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§7Kit §4Magma");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(11, magma);
        }
        if (!p.hasPermission("kit.avatar")) {
            final ItemStack avatar = new ItemStack(Material.BEACON);
            final ItemMeta avatarm = avatar.getItemMeta();
            avatarm.setDisplayName("§7Kit §4Avatar");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l10.000XP");
            desc.add("§7§lDomine os quatro elementos");
            avatarm.setLore((List)desc);
            avatar.setItemMeta(avatarm);
            inv.setItem(13, avatar);
        }
        else if (p.hasPermission("kit.avatar")) {
            final ItemStack avatar = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta avatarm = avatar.getItemMeta();
            avatarm.setDisplayName("§7Kit §4Avatar");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            avatarm.setLore((List)desc);
            avatar.setItemMeta(avatarm);
            inv.setItem(13, avatar);
        }
        if (!p.hasPermission("kit.shooter")) {
            final ItemStack shooter = new ItemStack(Material.BONE);
            final ItemMeta shooterm = shooter.getItemMeta();
            shooterm.setDisplayName("§7Kit §4Shooter");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l14.000XP");
            desc.add("§7§lQuando acerta uma flecha d\u00ea muito dano");
            shooterm.setLore((List)desc);
            shooter.setItemMeta(shooterm);
            inv.setItem(15, shooter);
        }
        else if (p.hasPermission("kit.shooter")) {
            final ItemStack shooter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta shooterm = shooter.getItemMeta();
            shooterm.setDisplayName("§7Kit §4Shooter");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            shooterm.setLore((List)desc);
            shooter.setItemMeta(shooterm);
            inv.setItem(15, shooter);
        }
        if (!p.hasPermission("kit.hotpotato")) {
            final ItemStack hotpotato = new ItemStack(Material.BAKED_POTATO);
            final ItemMeta hotpotatom = hotpotato.getItemMeta();
            hotpotatom.setDisplayName("§7Kit §4HotPotato");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l30.000XP");
            desc.add("§7§lExploda a cabe\u00e7a dos players");
            hotpotatom.setLore((List)desc);
            hotpotato.setItemMeta(hotpotatom);
            inv.setItem(17, hotpotato);
        }
        else if (p.hasPermission("kit.hotpotato")) {
            final ItemStack hotpotato = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta hotpotatom = hotpotato.getItemMeta();
            hotpotatom.setDisplayName("§7Kit §4HotPotato");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            hotpotatom.setLore((List)desc);
            hotpotato.setItemMeta(hotpotatom);
            inv.setItem(17, hotpotato);
            
        }
        if (!p.hasPermission("kit.gladiator")) {
            final ItemStack Gladiator = new ItemStack(Material.IRON_FENCE);
            final ItemMeta Gladiatotom = Gladiator.getItemMeta();
            Gladiatotom.setDisplayName("§7Kit §4Gladiator");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l15.000XP");
            desc.add("§7§lPuxa O Player Para O 1v1");
            Gladiatotom.setLore((List)desc);
            Gladiator.setItemMeta(Gladiatotom);
            inv.setItem(1, Gladiator);
        }
        else if (p.hasPermission("kit.gladiator")) {
            final ItemStack Gladiator = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta Gladiatotom = Gladiator.getItemMeta();
            Gladiatotom.setDisplayName("§7Kit §4gladiator");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            Gladiatotom.setLore((List)desc);
            Gladiator.setItemMeta(Gladiatotom);
            inv.setItem(1, Gladiator);
        }
        if (!p.hasPermission("kit.grappler")) {
            final ItemStack grappler = new ItemStack(Material.LEASH);
            final ItemMeta grapplertom = grappler.getItemMeta();
            grapplertom.setDisplayName("§7Kit §4Grappler");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l20.000XP");
            desc.add("§7§lTipo Homem Aranha");
            grapplertom.setLore((List)desc);
            grappler.setItemMeta(grapplertom);
            inv.setItem(0, grappler);
        }
        else if (p.hasPermission("kit.grappler")) {
            final ItemStack grappler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta grapplertom = grappler.getItemMeta();
            grapplertom.setDisplayName("§7Kit §4Grappler");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            grapplertom.setLore((List)desc);
            grappler.setItemMeta(grapplertom);
            inv.setItem(0, grappler);
        }
        if (!p.hasPermission("kit.viking")) {
            final ItemStack viking = new ItemStack(Material.STONE_AXE);
            final ItemMeta vikingtom = viking.getItemMeta();
            vikingtom.setDisplayName("§7Kit §4Viking");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l25.000XP");
            desc.add("§7O dano fica maior com um machado de viking");
            vikingtom.setLore((List)desc);
            viking.setItemMeta(vikingtom);
            inv.setItem(2, viking);
        }
        else if (p.hasPermission("kit.Viking")) {
            final ItemStack viking = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta vikingtom = viking.getItemMeta();
            vikingtom.setDisplayName("§7Kit §4Viking");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            vikingtom.setLore((List)desc);
            viking.setItemMeta(vikingtom);
            inv.setItem(2, viking);
        }
        if (!p.hasPermission("kit.stomper")) {
            final ItemStack stomper = new ItemStack(Material.IRON_BOOTS);
            final ItemMeta stompertom = stomper.getItemMeta();
            stompertom.setDisplayName("§7Kit §4Stomper");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l17.000XP");
            desc.add("§7Esmague os players perto de voc\u00ea");
            stompertom.setLore((List)desc);
            stomper.setItemMeta(stompertom);
            inv.setItem(3, stomper);
        }
        else if (p.hasPermission("kit.stomper")) {
            final ItemStack stomper = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta stompertom = stomper.getItemMeta();
            stompertom.setDisplayName("§7Kit §4Stomper");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            stompertom.setLore((List)desc);
            stomper.setItemMeta(stompertom);
            inv.setItem(3, stomper);
        }
        if (!p.hasPermission("kit.hack")) {
            final ItemStack hack = new ItemStack(Material.NAME_TAG);
            final ItemMeta hacktom = hack.getItemMeta();
            hacktom.setDisplayName("§7Kit §4hack");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l30.000XP");
            desc.add("§7Ao usar o kit fique com poderes hack");
            hacktom.setLore((List)desc);
            hack.setItemMeta(hacktom);
            inv.setItem(4, hack);
        }
        else if (p.hasPermission("kit.hack")) {
            final ItemStack hack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta hacktom = hack.getItemMeta();
            hacktom.setDisplayName("§7Kit §4hack");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            hacktom.setLore((List)desc);
            hack.setItemMeta(hacktom);
            inv.setItem(4, hack);
        }
        if (!p.hasPermission("kit.antistomper")) {
            final ItemStack antistomper = new ItemStack(Material.DIAMOND_BOOTS);
            final ItemMeta antistompertom = antistomper.getItemMeta();
            antistompertom.setDisplayName("§7Kit §4Antistomper");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l25.000XP");
            desc.add("§7N\u00e3o tome dano para stomper");
            antistompertom.setLore((List)desc);
            antistomper.setItemMeta(antistompertom);
            inv.setItem(5, antistomper);
        }
        else if (p.hasPermission("kit.antistomper")) {
            final ItemStack antistomper = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta antistompertom = antistomper.getItemMeta();
            antistompertom.setDisplayName("§7Kit §4AntiStomper");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            antistompertom.setLore((List)desc);
            antistomper.setItemMeta(antistompertom);
            inv.setItem(5, antistomper);
        }
        if (!p.hasPermission("kit.thor")) {
            final ItemStack thor = new ItemStack(Material.GOLD_AXE);
            final ItemMeta thortom = thor.getItemMeta();
            thortom.setDisplayName("§7Kit §4Thor");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l25.000XP");
            desc.add("§7Solte raios em seus inimigos");
            thortom.setLore((List)desc);
            thor.setItemMeta(thortom);
            inv.setItem(6, thor);
        }
        else if (p.hasPermission("kit.thor")) {
            final ItemStack thor = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta thortom = thor.getItemMeta();
            thortom.setDisplayName("§7Kit §4Thor");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            thortom.setLore((List)desc);
            thor.setItemMeta(thortom);
            inv.setItem(6, thor);
        }
        if (!p.hasPermission("kit.terrorista")) {
            final ItemStack terrorista = new ItemStack(Material.TNT);
            final ItemMeta terroristatom = terrorista.getItemMeta();
            terroristatom.setDisplayName("§7Kit §4Terrorista");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l15.000XP");
            desc.add("§7Ao cair exploda seus inimigos");
            terroristatom.setLore((List)desc);
            terrorista.setItemMeta(terroristatom);
            inv.setItem(7, terrorista);
        }
        else if (p.hasPermission("kit.terrorista")) {
            final ItemStack terrorista = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta terroristatom = terrorista.getItemMeta();
            terroristatom.setDisplayName("§7Kit §4Terrorista");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            terroristatom.setLore((List)desc);
            terrorista.setItemMeta(terroristatom);
            inv.setItem(7, terrorista);
        }
        if (!p.hasPermission("kit.goku")) {
            final ItemStack goku = new ItemStack(Material.GOLD_NUGGET);
            final ItemMeta gokutom = goku.getItemMeta();
            gokutom.setDisplayName("§7Kit §4Goku");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l15.000XP");
            desc.add("§7Se transforme em sayajin");
            gokutom.setLore((List)desc);
            goku.setItemMeta(gokutom);
            inv.setItem(8, goku);
        }
        else if (p.hasPermission("kit.goku")) {
            final ItemStack goku = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta gokutom = goku.getItemMeta();
            gokutom.setDisplayName("§7Kit §4Goku");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            gokutom.setLore((List)desc);
            goku.setItemMeta(gokutom);
            inv.setItem(8, goku);
        }
        if (!p.hasPermission("kit.timelord")) {
            final ItemStack timelord = new ItemStack(Material.WATCH);
            final ItemMeta timelordtom = timelord.getItemMeta();
            timelordtom.setDisplayName("§7Kit §4Timelord");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l15.000XP");
            desc.add("§7Congele os players perto de voce");
            timelordtom.setLore((List)desc);
            timelord.setItemMeta(timelordtom);
            inv.setItem(10, timelord);
        }
        else if (p.hasPermission("kit.timelord")) {
            final ItemStack timelord = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta timelordtom = timelord.getItemMeta();
            timelordtom.setDisplayName("§7Kit §4Timelord");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            timelordtom.setLore((List)desc);
            timelord.setItemMeta(timelordtom);
            inv.setItem(10, timelord);
        }
        if (!p.hasPermission("kit.c4")) {
            final ItemStack c4 = new ItemStack(Material.SLIME_BALL);
            final ItemMeta c4tom = c4.getItemMeta();
            c4tom.setDisplayName("§7Kit §4c4");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l20.000XP");
            desc.add("§7Exploda seus inimigos com sua bomba");
            c4tom.setLore((List)desc);
            c4.setItemMeta(c4tom);
            inv.setItem(12, c4);
        }
        else if (p.hasPermission("kit.c4")) {
            final ItemStack c4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta c4tom = c4.getItemMeta();
            c4tom.setDisplayName("§7Kit §4c4");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            c4tom.setLore((List)desc);
            c4.setItemMeta(c4tom);
            inv.setItem(12, c4);
        }
        if (!p.hasPermission("kit.ironman")) {
            final ItemStack ironman = new ItemStack(Material.IRON_INGOT);
            final ItemMeta ironmantom = ironman.getItemMeta();
            ironmantom.setDisplayName("§7Kit §4ironman");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l20.000XP");
            desc.add("§7Ao matar ganhe ferros para craftar");
            ironmantom.setLore((List)desc);
            ironman.setItemMeta(ironmantom);
            inv.setItem(14, ironman);
        }
        else if (p.hasPermission("kit.ironman")) {
            final ItemStack ironman = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta ironmantom = ironman.getItemMeta();
            ironmantom.setDisplayName("§7Kit §4ironman");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            ironmantom.setLore((List)desc);
            ironman.setItemMeta(ironmantom);
            inv.setItem(14, ironman);
        }
        if (!p.hasPermission("kit.infernor")) {
            final ItemStack infernor = new ItemStack(Material.NETHER_FENCE);
            final ItemMeta infernortom = infernor.getItemMeta();
            infernortom.setDisplayName("§7Kit §4infernor");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§a§lPre\u00e7o: §2§l20.000XP");
            desc.add("§7Puxe os players para um 1v1 no c\u00e9u com for\u00e7a");
            infernortom.setLore((List)desc);
            infernor.setItemMeta(infernortom);
            inv.setItem(16, infernor);
        }
        else if (p.hasPermission("kit.infernor")) {
            final ItemStack infernor = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta infernortom = infernor.getItemMeta();
            infernortom.setDisplayName("§7Kit §4infernor");
            final ArrayList<String> desc = new ArrayList<String>();
            desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
            infernortom.setLore((List)desc);
            infernor.setItemMeta(infernortom);
            inv.setItem(16, infernor);
        }
        p.openInventory(inv);
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void inventarioKit(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§4§lLoja De Kits") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            API.venderItem(e, p, Material.SAND, 30000, "§7Voc\u00ea comprou o kit: §4Gaara", "kit.gaara");
            API.venderItem(e, p, Material.LAVA_BUCKET, 15000, "§7Voc\u00ea comprou o kit: §4Magma", "kit.magma");
            API.venderItem(e, p, Material.BEACON, 10000, "§7Voc\u00ea comprou o kit: §4Avatar", "kit.avatar");
            API.venderItem(e, p, Material.BONE, 14000, "§7Voc\u00ea comprou o kit: §4Shooter", "kit.shooter");
            API.venderItem(e, p, Material.BAKED_POTATO, 30000, "§7Voc\u00ea comprou o kit: §4HotPotato", "kit.hotpotato");
            API.venderItem(e, p, Material.IRON_FENCE, 15000, "§7Voc\u00ea comprou o kit: §4Gladiator", "kit.gladiator");
            API.venderItem(e, p, Material.LEASH, 20000, "§7Voc\u00ea comprou o kit: §4Grappler", "kit.grappler");
            API.venderItem(e, p, Material.STONE_AXE, 25000, "§7Voc\u00ea comprou o kit: §4Viking", "kit.viking");
            API.venderItem(e, p, Material.IRON_BOOTS, 17000, "§7Voc\u00ea comprou o kit: §4Stomper", "kit.stomper");
            API.venderItem(e, p, Material.NAME_TAG, 30000, "§7Voc\u00ea comprou o kit: §4Hack", "kit.hack");
            API.venderItem(e, p, Material.DIAMOND_BOOTS, 25000, "§7Voc\u00ea comprou o kit: §4AntiStomper", "kit.antistomper");
            API.venderItem(e, p, Material.GOLD_AXE, 25000, "§7Voc\u00ea comprou o kit: §4Thor", "kit.thor");
            API.venderItem(e, p, Material.TNT, 15000, "§7Voc\u00ea comprou o kit: §4Terrorista", "kit.terrorista");
            API.venderItem(e, p, Material.GOLD_NUGGET, 15000, "§7Voc\u00ea comprou o kit: §4Goku", "kit.goku");
            API.venderItem(e, p, Material.WATCH, 15000, "§7Voc\u00ea comprou o kit: §4Timelord", "kit.timelord");
            API.venderItem(e, p, Material.SLIME_BALL, 20000, "§7Voc\u00ea comprou o kit: §4C4", "kit.c4");
            API.venderItem(e, p, Material.IRON_INGOT, 20000, "§7Voc\u00ea comprou o kit: §4IronMan", "kit.ironman");
            API.venderItem(e, p, Material.NETHER_FENCE, 20000, "§7Voc\u00ea comprou o kit: §4infernor", "kit.infernor");
            
        }
        
    }
}
    
        
    

