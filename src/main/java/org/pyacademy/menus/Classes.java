package org.pyacademy.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;


public class Classes extends Menu {

    private final Button Warrior,Ninja;

    public Classes() {
        setSize(45);
        setTitle("&8Classes");

        Ninja = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

                ItemStack NinjaLayout = ItemCreator.of(CompMaterial.IRON_AXE,"&ANinJa Class"
                ,"&8Common Class","",
                        "&BBeginner class &7for players &7who love","&7chopping trees &7and &bselling goods"
                        ,"&7to &BLumberJack Merchant &7in the shops!","",
                        "&D&LUNLOCKED"
                ,"","&EClick to select NinJa!").build().make();

                return NinjaLayout;
            }
        };

        Warrior = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                Common.tell(player,Common.colorize("&AYour class has been successfully updated!"));
            }

            @Override
            public ItemStack getItem() {

                ItemStack WarriorLayout = ItemCreator.of(CompMaterial.DIAMOND_SWORD,
                        "&AWarrior Class","&8Undercover Agent","","&BWarrior Class &7is a special rank",
                        "&7which can be only obtained by","&Bcompleting &7under cover tasks ","&7for staff."
                        ,"","&D&LUNLOCKED","","&EClick to select Warrior!")
                        .build().make();

                return WarriorLayout;
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {

        if(slot == 10)
            return Warrior.getItem();

        if(slot == 13)
            return Ninja.getItem();

        return null;
    }

    @Override
    protected String[] getInfo() {
        return null;
    }
}
