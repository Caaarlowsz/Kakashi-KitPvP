package Kakashi.KitPvP;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;

import Kakashi.KitPvP.Comandos.Admin;
import Kakashi.KitPvP.Comandos.Aplicar;
import Kakashi.KitPvP.Comandos.Aviso;
import Kakashi.KitPvP.Comandos.Build;
import Kakashi.KitPvP.Comandos.Ajuda;
import Kakashi.KitPvP.Comandos.Chat;
import Kakashi.KitPvP.Comandos.ClearChat;
import Kakashi.KitPvP.Comandos.ClickTest;
import Kakashi.KitPvP.Comandos.Congelar;
import Kakashi.KitPvP.Comandos.DarKit;
import Kakashi.KitPvP.Comandos.Fake;
import Kakashi.KitPvP.Comandos.Fly;
import Kakashi.KitPvP.Comandos.Gamemode;
import Kakashi.KitPvP.Comandos.Head;
import Kakashi.KitPvP.Comandos.Kills;
import Kakashi.KitPvP.Comandos.Kit;
import Kakashi.KitPvP.Comandos.Report;
import Kakashi.KitPvP.Comandos.ResetKit;
import Kakashi.KitPvP.Comandos.Score;
import Kakashi.KitPvP.Comandos.SetArena;
import Kakashi.KitPvP.Comandos.Spawn;
import Kakashi.KitPvP.Comandos.StaffChat;
import Kakashi.KitPvP.Comandos.Status;
import Kakashi.KitPvP.Comandos.Tag;
import Kakashi.KitPvP.Comandos.Tell;
import Kakashi.KitPvP.Comandos.TogglePvP;
import Kakashi.KitPvP.Comandos.Tp;
import Kakashi.KitPvP.Comandos.UnCage;
import Kakashi.KitPvP.Comandos.Ver;
import Kakashi.KitPvP.Comandos.Xp;
import Kakashi.KitPvP.Comandos.Youtuber;
import Kakashi.KitPvP.Eventos.BarKit;
import Kakashi.KitPvP.Eventos.Bussola;
import Kakashi.KitPvP.Eventos.CombatLog;
import Kakashi.KitPvP.Eventos.DropEventos;
import Kakashi.KitPvP.Eventos.MorteEventos;
import Kakashi.KitPvP.Eventos.Naturais;
import Kakashi.KitPvP.Eventos.Nerfs;
import Kakashi.KitPvP.Eventos.PlayerEventos;
import Kakashi.KitPvP.Guis.EventosGuis;
import Kakashi.KitPvP.Guis.GuiKits;
import Kakashi.KitPvP.Guis.GuiLoja;
import Kakashi.KitPvP.Guis.GuiWarps;
import Kakashi.KitPvP.Kits.Anchor;
import Kakashi.KitPvP.Kits.Avatar;
import Kakashi.KitPvP.Kits.Bombeiro;
import Kakashi.KitPvP.Kits.Bruxa;
import Kakashi.KitPvP.Kits.C4;
import Kakashi.KitPvP.Kits.Confusão;
import Kakashi.KitPvP.Kits.FisherMan;
import Kakashi.KitPvP.Kits.Flash;
import Kakashi.KitPvP.Kits.FlashBack;
import Kakashi.KitPvP.Kits.Gaara;
import Kakashi.KitPvP.Kits.Gladiator;
import Kakashi.KitPvP.Kits.Goku;
import Kakashi.KitPvP.Kits.Grappler;
import Kakashi.KitPvP.Kits.Gun;
import Kakashi.KitPvP.Kits.Hack;
import Kakashi.KitPvP.Kits.HotPotato;
import Kakashi.KitPvP.Kits.Infernor;
import Kakashi.KitPvP.Kits.IronMan;
import Kakashi.KitPvP.Kits.JellyFish;
import Kakashi.KitPvP.Kits.Jumper;
import Kakashi.KitPvP.Kits.Kangaroo;
import Kakashi.KitPvP.Kits.Magma;
import Kakashi.KitPvP.Kits.Monk;
import Kakashi.KitPvP.Kits.Phantom;
import Kakashi.KitPvP.Kits.Poseidon;
import Kakashi.KitPvP.Kits.Shooter;
import Kakashi.KitPvP.Kits.Stomper;
import Kakashi.KitPvP.Kits.Teleporter;
import Kakashi.KitPvP.Kits.Terrorista;
import Kakashi.KitPvP.Kits.Thor;
import Kakashi.KitPvP.Kits.TimeLord;
import Kakashi.KitPvP.Kits.Trader;
import Kakashi.KitPvP.Kits.Viking;
import Kakashi.KitPvP.ScoreBoard.ScoreBoard;
import Kakashi.KitPvP.Sistemas.API;
import Kakashi.KitPvP.Sistemas.AutoMensagem;
import Kakashi.KitPvP.Sistemas.BlocosJump;
import Kakashi.KitPvP.Sistemas.PlacaDeRecraft;
import Kakashi.KitPvP.Sistemas.PlacaDeSopa;
import Kakashi.KitPvP.Sistemas.Plugins;
import Kakashi.KitPvP.Warps.SetWarp;
import Kakashi.KitPvP.Warps.irWarp;



@SuppressWarnings({"all"})
public class Main extends JavaPlugin
{
    public static Plugin plugin;
    public static Main instance;
    public static Integer score;
	public static String semperm;
    private AutoMensagem AutoMessanger;
    public File statusfile;
    public YamlConfiguration status;
    public File warpsfile;
    public YamlConfiguration warps;
    public File arenasfile;
    public YamlConfiguration arenas;
    
    static {
        Main.score = null;
    }
    
    public void onLoad() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            ArrayList<String> msg = new ArrayList<>();
            msg.add("               §4§lKitPvP             ");
            msg.add("§cServidor reiniciado para melhorar sua jogabilidade");
            todos.kickPlayer(String.valueOf(msg));
        }
    }
    
    public void onEnable() {
        Main.plugin = (Plugin)this;
        Main.instance = this;
        final File status = new File(this.getDataFolder(), "status.yml");
        if (!status.exists()) {
            this.saveResource("status.yml", false);
        }
        this.statusfile = new File(this.getDataFolder(), "status.yml");
        this.status = YamlConfiguration.loadConfiguration(this.statusfile);
        final File warps = new File(this.getDataFolder(), "warps.yml");
        if (!warps.exists()) {
            this.saveResource("warps.yml", false);
        }
        this.warpsfile = new File(this.getDataFolder(), "warps.yml");
        this.warps = YamlConfiguration.loadConfiguration(this.warpsfile);
        final File arenas = new File(this.getDataFolder(), "arenas.yml");
        if (!arenas.exists()) {
            this.saveResource("arenas.yml", false);
        }
        this.arenasfile = new File(this.getDataFolder(), "arenas.yml");
        this.arenas = YamlConfiguration.loadConfiguration(this.arenasfile);
        this.AutoMessanger = new AutoMensagem();
        AutoMensagem.start();
        this.save();
        this.Eventos();
        this.Comandos();
        this.Kits();
        this.Guis();
        this.saveDefaultConfig();
        API.novaReceita();
        Bukkit.getConsoleSender().sendMessage("§2§lPlugin Iniciado ");
        Main.score = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                Player[] arrayOfPlayer;
                for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                    final Player p = arrayOfPlayer[i];
                    if (Score.ntemscore.contains(p.getName())) {
                        ScoreBoard.KitPvPScore(p);
                    }
                    if (Score.temscore.contains(p.getName())) {
                        p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
                    }
                }
            }
        }, 0L, 10L);
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§4§lPlugin Desativado");
    }
    
    public void Eventos() {
        final PluginManager evento = Bukkit.getPluginManager();
        evento.registerEvents((Listener)new MorteEventos(), (Plugin)this);
        evento.registerEvents((Listener)new Naturais(), (Plugin)this);
        evento.registerEvents((Listener)new Nerfs(), (Plugin)this);
        evento.registerEvents((Listener)new PlayerEventos(), (Plugin)this);
        evento.registerEvents((Listener)new DropEventos(), (Plugin)this);
        evento.registerEvents((Listener)new Build(), (Plugin)this);
        evento.registerEvents((Listener)new Admin(), (Plugin)this);
        evento.registerEvents((Listener)new Ajuda(), (Plugin)this);
        evento.registerEvents((Listener)new Congelar(), (Plugin)this);
        evento.registerEvents((Listener)new ClickTest(), (Plugin)this);
        evento.registerEvents((Listener)new Fake(), (Plugin)this);
        evento.registerEvents((Listener)new BarKit(), (Plugin)this);
        evento.registerEvents((Listener)new GuiLoja(), (Plugin)this);
        evento.registerEvents((Listener)new BlocosJump(), (Plugin)this);
        evento.registerEvents((Listener)new PlacaDeRecraft(), (Plugin)this);
        evento.registerEvents((Listener)new PlacaDeSopa(), (Plugin)this);
        evento.registerEvents((Listener)new Chat(), (Plugin)this);
        evento.registerEvents((Listener)new StaffChat(), (Plugin)this);
        evento.registerEvents((Listener)new CombatLog(), (Plugin)this);
        evento.registerEvents((Listener)new Bussola(), (Plugin)this);
        evento.registerEvents(new Plugins(), this);
     
    }
    
    public void Comandos() {
        this.getCommand("fly").setExecutor((CommandExecutor)new Fly());
        this.getCommand("report").setExecutor((CommandExecutor)new Report());
        this.getCommand("status").setExecutor((CommandExecutor)new Status());
        this.getCommand("xp").setExecutor((CommandExecutor)new Xp());
        this.getCommand("score").setExecutor((CommandExecutor)new Score());
        this.getCommand("resetkit").setExecutor((CommandExecutor)new ResetKit());
        this.getCommand("clicktest").setExecutor((CommandExecutor)new ClickTest());
        this.getCommand("gm").setExecutor((CommandExecutor)new Gamemode());
        this.getCommand("gamemode").setExecutor((CommandExecutor)new Gamemode());
        this.getCommand("build").setExecutor((CommandExecutor)new Build());
        this.getCommand("admin").setExecutor((CommandExecutor)new Admin());
        this.getCommand("congelar").setExecutor((CommandExecutor)new Congelar());
        this.getCommand("pvp").setExecutor((CommandExecutor)new TogglePvP());
        this.getCommand("tag").setExecutor((CommandExecutor)new Tag());
        this.getCommand("set").setExecutor((CommandExecutor)new SetWarp());
        this.getCommand("warp").setExecutor((CommandExecutor)new irWarp());
        this.getCommand("aviso").setExecutor((CommandExecutor)new Aviso());
        this.getCommand("cc").setExecutor((CommandExecutor)new ClearChat());
        this.getCommand("fake").setExecutor((CommandExecutor)new Fake());
        this.getCommand("tell").setExecutor((CommandExecutor)new Tell());
        this.getCommand("chat").setExecutor((CommandExecutor)new Chat());
        this.getCommand("aplicar").setExecutor((CommandExecutor)new Aplicar());
        this.getCommand("sc").setExecutor((CommandExecutor)new StaffChat());
        this.getCommand("setarena").setExecutor((CommandExecutor)new SetArena());
        this.getCommand("darkit").setExecutor((CommandExecutor)new DarKit());
        this.getCommand("tp").setExecutor((CommandExecutor)new Tp());
        this.getCommand("tphere").setExecutor((CommandExecutor)new Tp());
        this.getCommand("tpall").setExecutor((CommandExecutor)new Tp());
        this.getCommand("vis").setExecutor((CommandExecutor)new Ver());
        this.getCommand("spawn").setExecutor((CommandExecutor)new Spawn());
        this.getCommand("head").setExecutor((CommandExecutor)new Head());
        this.getCommand("youtuber").setExecutor((CommandExecutor)new Youtuber());
        this.getCommand("uncage").setExecutor(new UnCage());
        this.getCommand("kills").setExecutor(new Kills());
        this.getCommand("ajuda").setExecutor(new Ajuda());
        this.getCommand("sendmsg").setExecutor(new SendMSG());
    }
    
    public void Kits() {
        final PluginManager kits = Bukkit.getPluginManager();
        this.getCommand("kit").setExecutor((CommandExecutor)new Kit());
        kits.registerEvents((Listener)new Bombeiro(), (Plugin)this);
        kits.registerEvents((Listener)new Jumper(), (Plugin)this);
        kits.registerEvents((Listener)new Goku(), (Plugin)this);
        kits.registerEvents((Listener)new Bruxa(), (Plugin)this);
        kits.registerEvents((Listener)new Shooter(), (Plugin)this);
        kits.registerEvents((Listener)new TimeLord(), (Plugin)this);
        kits.registerEvents((Listener)new JellyFish(), (Plugin)this);
        kits.registerEvents((Listener)new Anchor(), (Plugin)this);
        kits.registerEvents((Listener)new FisherMan(), (Plugin)this);
        kits.registerEvents((Listener)new Magma(), (Plugin)this);
        kits.registerEvents((Listener)new Confus\u00e3o(), (Plugin)this);
        kits.registerEvents((Listener)new Gladiator(), (Plugin)this);
        kits.registerEvents((Listener)new HotPotato(), (Plugin)this);
        kits.registerEvents((Listener)new Avatar(), (Plugin)this);
        kits.registerEvents((Listener)new Kangaroo(), (Plugin)this);
        kits.registerEvents((Listener)new Grappler(), (Plugin)this);
        kits.registerEvents((Listener)new Monk(), (Plugin)this);
        kits.registerEvents((Listener)new Stomper(), (Plugin)this);
        kits.registerEvents((Listener)new Thor(), (Plugin)this);
        kits.registerEvents((Listener)new Teleporter(), (Plugin)this);
        kits.registerEvents((Listener)new Gaara(), (Plugin)this);
        kits.registerEvents((Listener)new Infernor(), (Plugin)this);
        kits.registerEvents((Listener)new Poseidon(), (Plugin)this);
        kits.registerEvents((Listener)new Trader(), (Plugin)this);
        kits.registerEvents((Listener)new IronMan(), (Plugin)this);
        kits.registerEvents((Listener)new Phantom(), (Plugin)this);
        kits.registerEvents((Listener)new C4(), (Plugin)this);
        kits.registerEvents((Listener)new Viking(), (Plugin)this);
        kits.registerEvents((Listener)new Gun(), (Plugin)this);
        kits.registerEvents((Listener)new Terrorista(), (Plugin)this);
        kits.registerEvents((Listener)new Flash(), (Plugin)this);
        kits.registerEvents((Listener)new Hack(), (Plugin)this);
        kits.registerEvents((Listener)new FlashBack(), (Plugin)this);
    }
    
    public void Guis() {
        final PluginManager guis = Bukkit.getPluginManager();
        guis.registerEvents((Listener)new EventosGuis(), (Plugin)this);
        guis.registerEvents((Listener)new GuiKits(), (Plugin)this);
        guis.registerEvents((Listener)new GuiWarps(), (Plugin)this);
    }
    
    public static Plugin getPlugin() {
        return Main.plugin;
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
   
    
    public void save() {
        try {
            this.status.save(this.statusfile);
            this.warps.save(this.warpsfile);
            this.arenas.save(this.arenasfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
