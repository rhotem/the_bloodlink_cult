package me.justacat.thebloodlinkcult.items;

import me.justacat.thebloodlinkcult.items.armors.*;
import me.justacat.thebloodlinkcult.items.others.*;

public enum RegisteredItems {

    Revive(new Revive()),
    BloodLinkHelmet(new BloodLinkHelmet()),
    BloodLinkChestplate(new BloodLinkChestplate()),
    BloodLinkLeggings(new BloodLinkLeggings()),
    BloodLinkBoots(new BloodLinkBoots()),
    TheRedShield(new TheRedShield()),
    TheBloodLinkScribes(new TheBloodLinkScribes()),
    TheBladeBreaker(new TheBladeBreaker()),
    MagicWand(new MagicWand()),
    TheGodKiller(new TheGodKiller()),
    Teleporter(new Teleporter()),
    TheSacrifice(new TheSacrifice());

    private final CustomItem item;

    RegisteredItems(CustomItem item) {

        this.item = item;

    }


    public CustomItem getItem() {return item;}



}
