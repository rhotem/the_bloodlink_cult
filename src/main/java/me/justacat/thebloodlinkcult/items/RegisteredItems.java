package me.justacat.thebloodlinkcult.items;

import me.justacat.thebloodlinkcult.items.armors.*;

public enum RegisteredItems {

    BloodLinkHelmet(new BloodLinkHelmet()),
    BloodLinkChestplate(new BloodLinkChestplate()),
    BloodLinkLeggings(new BloodLinkLeggings()),
    BloodLinkBoots(new BloodLinkBoots()),
    TheRedShield(new TheRedShield());

    private final CustomItem item;

    RegisteredItems(CustomItem item) {

        this.item = item;

    }


    public CustomItem getItem() {return item;}



}
