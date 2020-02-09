package org.pyacademy.commands;

import org.mineacademy.fo.command.SimpleCommand;
import org.pyacademy.menus.Upgrades;

public class UpgradesCommand extends SimpleCommand {
    public UpgradesCommand() {
        super("upgrades");
    }

    @Override
    protected void onCommand() {
    checkConsole();
    new Upgrades().displayTo(getPlayer());
    }
}
