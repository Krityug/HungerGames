package org.pyacademy.commands;


import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.pyacademy.menus.SlayerQuests;

public class SlayerCommand extends SimpleCommand {
    public SlayerCommand() {
        super("quests");
        setMinArguments(1);
        setUsage("<slayer|normal>");
        setPermission("package.quests.menu.access");
        setPermissionMessage("&8Requires an permission to access! &C(package.quests.menu.access)");
    }

    @Override
    protected void onCommand() {
         checkConsole();
         checkArgs(1, Common.colorize("&CPlease specify more about the command like <slayer>! Or Use /help"));

         if(args.length == 1) {
            new SlayerQuests().displayTo(getPlayer());
         }
    }
}
