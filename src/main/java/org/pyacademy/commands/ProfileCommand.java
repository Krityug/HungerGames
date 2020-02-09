package org.pyacademy.commands;

import org.mineacademy.fo.command.SimpleCommand;
import org.pyacademy.menus.ProfileMenu;

public class ProfileCommand extends SimpleCommand {

    public ProfileCommand() {
        super("profile");
    }

    @Override
    protected void onCommand() {
     checkConsole();
     new ProfileMenu().displayTo(getPlayer());
    }
}
