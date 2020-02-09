package org.pyacademy.packages;

import org.mineacademy.fo.command.SimpleCommand;
import org.pyacademy.database.MysqlManager;

public class MySqlManagerCommand extends SimpleCommand {

    public MySqlManagerCommand() {
        super("mysql");
        setMinArguments(1);
        setUsage("manager");
        setPermission("package.mysql.command.access");
        setPermissionMessage("&8Requires an permission to access &C(package.mysql.command.access)");
    }

    @Override
    protected void onCommand() {
     checkConsole();

     if(args.length == 1){
         new MysqlManager().displayTo(getPlayer());
     }

    }
}
