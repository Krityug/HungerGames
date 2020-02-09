package org.pyacademy.menus;


import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class Upgrades extends Menu {

    private final Button FireBall,QuadJumper;

    public Upgrades() {
        setSize(54);
        setTitle("&8Upgrades");

        QuadJumper = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

              ItemStack QuadJumperLayout = ItemCreator.of(CompMaterial.SLIME_BLOCK,"&AQuad Jumper"
              ,"&8Upgrade","",
                      "&BBoost &7your &BJumping &7ability and","&7earn &3extra &Fprestige &7experience"
                      ,"&7whenever &Benchant &7any item","&7with this upgrade.",
                      "",
                      "&EClick to purchase!").build().make();

                return QuadJumperLayout;
            }
        };

        FireBall = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                player.setFireTicks(50);
            }

            @Override
            public ItemStack getItem() {

                ItemStack FireballLayout = ItemCreator.of(CompMaterial.FIRE_CHARGE,"&AFire Ball",
                        "&8Upgrades","",
                        "&BSets &7the user of this upgrade","&7on fire for 50 seconds","",
                        "&EClick to purchase!")
                        .build().make();

                return FireballLayout;
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {

        if(slot == 10)
            return FireBall.getItem();

        if(slot == 11)
            return QuadJumper.getItem();

        return null;
    }

    @Override
    protected String[] getInfo() {
        return null;
    }
}
