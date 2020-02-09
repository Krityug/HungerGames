package org.pyacademy.database;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class MysqlManager extends Menu {

    private final Button Input;

    public MysqlManager() {
        setSize(45);
        setTitle("&8MYSQL Manager");

        Input = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

                ItemStack InputLayout = ItemCreator.of(CompMaterial.CRAFTING_TABLE,"&AInput Credentials",
                        "&8Verified Access","","&7Enter credentials for your","&BMySQL &7database to connect","",
                        "&EClick to input!")
                        .build().make();

                return InputLayout;
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {

        if(slot == 10)
            return Input.getItem();

        return null;
    }

    @Override
    protected String[] getInfo() {
        return null;
    }
}
