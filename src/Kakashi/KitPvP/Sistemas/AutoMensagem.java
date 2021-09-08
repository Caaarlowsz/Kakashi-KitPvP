package Kakashi.KitPvP.Sistemas;

import org.bukkit.*;

import Kakashi.KitPvP.*;

import java.util.*;

public class AutoMensagem
{
    public static void start() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, (Runnable)new Runnable() {
            String[] msg = { String.valueOf(API.preffix) + API.AutoM1, String.valueOf(API.preffix) + API.AutoM2, String.valueOf(API.preffix) + API.AutoM3, String.valueOf(API.preffix) + API.AutoM4, String.valueOf(API.preffix) + API.AutoM5 };
            
            @Override
            public void run() {
                Bukkit.getServer().broadcastMessage(this.msg[new Random().nextInt(this.msg.length)]);
            }
        }, 0L, 420L);
    }
}
