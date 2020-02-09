package org.pyacademy.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonReturnBack;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import java.util.Collections;


public class SlayerQuests extends Menu {

    private final Button SpecialQ;

    public SlayerQuests() {
        setSize(45);
        setTitle("&8Slayer Quest");

        SpecialQ = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                new SpecialQuests().displayTo(player);
            }

            @Override
            public ItemStack getItem() {

                ItemStack SlayerQuest = ItemCreator.of(CompMaterial.ENDER_EYE,"&5Special &DQuests",
                        "&8Quests Type","","&BComplete &7quests which are &Bspecial",
                        "&7and considered to be the &Bhardest","&7of the whole hunger &7games.","",
                        "&ERequires Warrior Class &b[Tier XX]"
                ,"","&EClick to view quests!")
                        .build().make();

                return SlayerQuest;
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {

        if(slot == 10)
            return SpecialQ.getItem();

        return null;
    }

    @Override
    protected String[] getInfo() {
        return null;
    }

    class SpecialQuests extends Menu {

        private final Button Coop,Undercover;

        public SpecialQuests() {
            super(SlayerQuests.this);
            setSize(45);
            setTitle("&8Special Quests");

            Undercover = new Button() {
                @Override
                public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                 new UnderCoverQuests().displayTo(player);
                }

                @Override
                public ItemStack getItem() {

                    ItemStack UnderCoverLayout = ItemCreator.of(CompMaterial.ENDER_PEARL,
                            "&5UnderCover &DQuests",
                            "&8Package Type","","&BUnfold &7the Secrets &7behind the",
                            "network and also find clues","&7to &Bearn &7points and perks."
                           ,"","&ERequires Warrior Class &B[Tier XXV]",
                            "",
                            "&EClick to view quests!")
                            .build().make();

                    return UnderCoverLayout;
                }
            };

            Coop = new Button() {
                @Override
                public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                new CoopQuests().displayTo(player);
                }

                @Override
                public ItemStack getItem() {

                    ItemStack CoopLayout = ItemCreator.of(CompMaterial.ENDER_CHEST,"&5Coop &DQuests",
                            "&8Quest Type","","&BFinish &7quests with your friends","and earn &Bdouble &7rewards."
                           ,"","&ERequires Warrior Class &B[Tier XXI]"
                    ,"","&EClick to view quests!")
                            .build().make();


                    return CoopLayout;
                }
            };
        }

        @Override
        public ItemStack getItemAt(int slot) {

            if(slot == 10)
                return Coop.getItem();

            if(slot == 13)
                return Undercover.getItem();

            return null;
        }

        @Override
        protected String[] getInfo() {
            return null;
        }
    }

    class CoopQuests extends Menu {

        public CoopQuests() {
            super(SlayerQuests.this);
            setSize(45);
            setTitle("&8Coop Quests");
            ButtonReturnBack.setTitle("&AGo Back");
            ButtonReturnBack.setLore(Collections.singletonList(Common.colorize("&7To Previous Menu")));
        }

        @Override
        protected String[] getInfo() {
            return null;
        }
    }

    class UnderCoverQuests extends Menu {

        public UnderCoverQuests() {
            super(SlayerQuests.this);
            setSize(45);
            setTitle("&8UnderCover Quests");
        }

        @Override
        protected String[] getInfo() {
            return null;
        }
    }
}
