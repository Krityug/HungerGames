package org.pyacademy.commands;


import org.mineacademy.fo.command.SimpleCommand;
import org.pyacademy.menus.Classes;

public class ClassesOPCommand extends SimpleCommand {
    public ClassesOPCommand() {
        super("set");

        setMinArguments(1);
        setUsage("<classes>");
    }

    @Override
    protected void onCommand() {
      checkConsole();

      if(args.length == 1) {
           new Classes().displayTo(getPlayer());
      }
    }
}
