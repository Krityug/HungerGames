package org.pyacademy.commands;

import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.Remain;


public class ReloadCommand extends SimpleCommand {

    public ReloadCommand() {
        super("update");
        setPermission("package.reload.access");
        setPermissionMessage("&8Requires an permission to access!");
    }

    @Override
    protected void onCommand() {
     checkConsole();

     try {
         SimplePlugin.getInstance().reload();
         Remain.sendTitle(getPlayer(),20,30,20,"&A&LReload Success",
                 "&FHunger Games has been successfully &Breloaded&F!");
     } catch (Throwable throwable) {
        throwable.printStackTrace();
         Remain.sendTitle(getPlayer(),20,30,20,"&C&LReload Failed",
                 "&FPlease check &Bsettings.yml &Ffor more info!");
     }
    }
}
