package me.justacat.thebloodlinkcult.items;

import me.justacat.thebloodlinkcult.items.armors.*;
import me.justacat.thebloodlinkcult.items.others.Revive;
import me.justacat.thebloodlinkcult.items.others.TheBloodLinkScribes;

public enum RegisteredItems {

    Revive(new Revive()),
    BloodLinkHelmet(new BloodLinkHelmet()),
    BloodLinkChestplate(new BloodLinkChestplate()),
    BloodLinkLeggings(new BloodLinkLeggings()),
    BloodLinkBoots(new BloodLinkBoots()),
    TheRedShield(new TheRedShield()),
    TheBloodLinkScribes(new TheBloodLinkScribes());

    private final CustomItem item;

    RegisteredItems(CustomItem item) {

        this.item = item;

    }


    public CustomItem getItem() {return item;}



}
