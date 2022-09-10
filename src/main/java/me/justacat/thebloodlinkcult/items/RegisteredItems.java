package me.justacat.thebloodlinkcult.items;

import me.justacat.thebloodlinkcult.items.armors.TheBladeBreaker;
import me.justacat.thebloodlinkcult.items.armors.TheRedShield;
import me.justacat.thebloodlinkcult.items.armors.knight.BloodLinkBoots;
import me.justacat.thebloodlinkcult.items.armors.knight.BloodLinkChestplate;
import me.justacat.thebloodlinkcult.items.armors.knight.BloodLinkHelmet;
import me.justacat.thebloodlinkcult.items.armors.knight.BloodLinkLeggings;
import me.justacat.thebloodlinkcult.items.armors.priest.PriestBoots;
import me.justacat.thebloodlinkcult.items.armors.priest.PriestChestplate;
import me.justacat.thebloodlinkcult.items.armors.priest.PriestHelmet;
import me.justacat.thebloodlinkcult.items.armors.priest.PriestLeggings;
import me.justacat.thebloodlinkcult.items.others.*;

public enum RegisteredItems {

    Revive(new Revive()),
    BloodLinkHelmet(new BloodLinkHelmet(false)),
    BloodLinkChestplate(new BloodLinkChestplate(false)),
    BloodLinkLeggings(new BloodLinkLeggings(false)),
    BloodLinkBoots(new BloodLinkBoots(false)),
    BloodLinkHelmetPlus(new BloodLinkHelmet(true)),
    BloodLinkChestplatePlus(new BloodLinkChestplate(true)),
    BloodLinkLeggingsPlus(new BloodLinkLeggings(true)),
    BloodLinkBootsPlus(new BloodLinkBoots(true)),
    PriestHelmet(new PriestHelmet()),
    PriestChestplate(new PriestChestplate()),
    PriestLeggings(new PriestLeggings()),
    PriestBoots(new PriestBoots()),
    TheRedShield(new TheRedShield()),
    TheBloodLinkScribes(new TheBloodLinkScribes()),
    TheBladeBreaker(new TheBladeBreaker(true)),
    TheBloodyPainting(new TheBladeBreaker(false)),
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
