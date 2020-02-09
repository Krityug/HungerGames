package org.pyacademy.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;


public class ProfileMenu extends Menu {

    private final Button Boosters,Status,MailBox,Friends,Settings,RemoteS;


    public ProfileMenu() {
        setSize(54);
        setTitle("&8Profile");

        RemoteS = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                player.openWorkbench(null,true);
            }

            @Override
            public ItemStack getItem() {

                ItemStack CraftingLayout = ItemCreator.of(
                        CompMaterial.CRAFTING_TABLE,"&ARemote Crafting",
                        "&7Opens &7remote &Bcrafting table","&7for player!","","&EClick to open!"
                ).build().make();

                return CraftingLayout;
            }
        };

        Settings = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

                ItemStack SettingsLayout = ItemCreator.of(CompMaterial.COMPASS,"&ASettings",
                        "&BConfigure &7your global network","&7settings to gain a better playing",
                        "&Bexperience&7.","","&EClick to manage settings!")
                        .build().make();

                return SettingsLayout;
            }
        };


        Friends = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

                ItemStack FriendsLayout = ItemCreator.of(CompMaterial.PLAYER_HEAD,"&AFriends",
                        "&BView &7and &Bmanage &7your friends","&7globally on the network to get","&7popular",""
                        ,"&8Limited Storage:","&E&LCURRENTLY LIMITED"
                ,"","&EClick to view friends!")
                        .build().make();

                return FriendsLayout;
            }
        };

        MailBox = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

                ItemStack MailBoxLayout = ItemCreator.of(CompMaterial.CHEST,"&APost Office",
                        "&BSend &7and &Breceive &7mails from",
                        "&7friends or anyone on &7the","network!","",
                        "&8Opens In: &E5h 36m 59s","","&EClick to open mailbox!").build().make();

                return MailBoxLayout;
            }
        };

        Status = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

                ItemStack StatusLayout = ItemCreator.of(CompMaterial.MAP,"&AStatus"
                ,"&7Post &Bstatus &7for your friends","&7to see what you doing &7on the","&7network!",""
                        ,"&8Current Status: &BNothing"
                ,"","&EClick to change status!").build().make();

                return StatusLayout;
            }
        };

        Boosters = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {

            }

            @Override
            public ItemStack getItem() {

                ItemStack BoostersLayout = ItemCreator.of(CompMaterial.POTION,"&ABoosters",
                        "&BSupport &7the network as well",
                        "&Bearn &7more &Bexperience","&7by playing games!"
                ,"","&EClick to view boosters!")
                        .build().make();

                return BoostersLayout;
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {

        if(slot == 1)
            return MailBox.getItem();

        if(slot == 2)
            return Boosters.getItem();

        if(slot == 3)
            return Status.getItem();

        if(slot == 4)
            return Friends.getItem();

        if(slot == 5)
            return Settings.getItem();

        if(slot == 6)
            return RemoteS.getItem();

        return null;
    }

    @Override
    protected String[] getInfo() {
        return null;
    }
}
