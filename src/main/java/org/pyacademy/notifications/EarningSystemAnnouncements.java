package org.pyacademy.notifications;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.remain.Remain;

import java.util.Arrays;
import java.util.List;

public class EarningSystemAnnouncements extends BukkitRunnable {

    private final List<String> messages = Arrays.asList(
          Common.colorize("&BWeekly &7rewards sent out every first day of the week. Guess what's that day is?"),
          Common.colorize("&FReport &brule breakers &7on our forums or simple use &B/report &7command."),
          Common.colorize("&FSupport the &Bnetwork &Fby purchasing &Eranks, boosters and more!")
    );

    @Override
    public void run() {
        //String Prefix = Common.colorize("&7[&EEarning &FSystem&7]");
        String message = RandomUtil.nextItem(messages);
        for (final Player player : Remain.getOnlinePlayers())
            Common.tell(player,message);
    }
}
