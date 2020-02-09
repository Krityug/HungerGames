package org.pyacademy.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class EarningSystem extends Menu {

    private final Button WRewards,Settings,Forums;

    public EarningSystem() {
        setSize(45);
        setTitle("&8Earning System");

        Forums = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
             new ForumsOptions().displayTo(player);
            }

            @Override
            public ItemStack getItem() {

                ItemStack ForumsLayout = ItemCreator.of(CompMaterial.CRAFTING_TABLE,"&AForums Options",
                        "&8Permission Only","","&7Configure your &Bforums &7options","to connect to our &7forums."
                        ,"","&8MYSQL: &EConnected","","&EClick to manage!")
                        .build().make();

                return ForumsLayout;
            }
        };

        Settings = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
             new SettingsMenu().displayTo(player);
            }

            @Override
            public ItemStack getItem() {

                ItemStack SettingsLayout = ItemCreator.of(CompMaterial.ANVIL,"&ASettings (Earning System)",
                        "&8Permission Only","",
                        "&7Manage &boptions &7for your &7earning","&7system panel to make it your home",
                        "&7panel.","","&8MYSQL: &EConnected",
                        "","&EClick to manage!").build().make();

                return SettingsLayout;
            }
        };

        WRewards = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
            new WeeklyRewards().displayTo(player);
            }

            @Override
            public ItemStack getItem() {

                ItemStack WRewadsLayout = ItemCreator.of(CompMaterial.FURNACE,
                        "&AWeekly Player Rewards",
                        "&8Permission Only","","&7Manage &Bweekly &7player rewards",
                        "via the earning system.","","&8MYSQL: &EConnected", "",
                        "&EClick to open!").hideTags(true)
                        .build().make();

                return WRewadsLayout;
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {

        if (slot == 10)
            return WRewards.getItem();

        if(slot == 13)
            return Settings.getItem();

        if(slot == 16)
            return Forums.getItem();

        return null;
    }

    @Override
    protected String[] getInfo() {
        return null;
    }

    class WeeklyRewards extends Menu {

        public WeeklyRewards() {
            super(EarningSystem.this);
            setSize(45);
            setTitle("&8Weekly Player Rewards");
        }

        @Override
        protected String[] getInfo() {
            return null;
        }
    }

    class SettingsMenu extends Menu {

        private final Button SaveInv;

        public SettingsMenu() {
            super(EarningSystem.this);
            setSize(45);
            setTitle("&8Settings (Earning System)");

            SaveInv = new Button() {
                @Override
                public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                    Common.tell(player,Common.colorize("&AYour Save Inventory option has been successfully enabled!"));
                }

                @Override
                public ItemStack getItem() {

                    ItemStack SaveInvLayout = ItemCreator.of(CompMaterial.CHEST,"&ASave Inventory",
                            "&8Change In Action","","&BSaves &7your inventory on",
                            "&7your death in game.","","&EClick to enable!").build().make();

                    return SaveInvLayout;
                }
            };

        }

        @Override
        public ItemStack getItemAt(int slot) {

            if(slot == 10)
                return SaveInv.getItem();

            return null;
        }

        @Override
        protected String[] getInfo() {
            return null;
        }
    }

    class ForumsOptions extends Menu {

        public ForumsOptions() {
            super(EarningSystem.this);
            setSize(45);
            setTitle("&8Forums Options");
        }

        @Override
        protected String[] getInfo() {
            return null;
        }
    }
}
