package org.pyacademy.packages;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;
import org.pyacademy.menus.EarningSystem;

public class EarningSystemCommand extends SimpleCommand {
    public EarningSystemCommand() {
        super("earning");
        setMinArguments(1);
        setUsage("system");
        setPermission("package.earning.access");
        setPermissionMessage("&8Requires an permission to access!");
    }

    @Override
    protected void onCommand() {
      checkConsole();
      checkArgs(1,"&AYou have not used the correct command please try again!");

      if(args.length == 1) {
          Player player = getPlayer();
        new EarningSystem().displayTo(player);
      }
    }
}
