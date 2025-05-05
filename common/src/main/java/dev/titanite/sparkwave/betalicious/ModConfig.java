package dev.titanite.sparkwave.betalicious;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "betalicious")
class ModConfig implements ConfigData {
    /*
    boolean disableDownload = false;
    boolean disableSlicing = false;
    boolean useLocalTerrainPNG = false;
    String imageLocation = "https://static.wikia.nocookie.net/minecraft_gamepedia/images/a/a0/201007301722_terrain.png";
    */
    @Comment
    boolean timeMachineHasDurability = true;
    @Comment
    int timeMachineUses = 64;

    public static void init(){
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
    }

    public void validatePostLoad(){
        /*
        if (imageLocation.isEmpty()){
            disableDownload = true;
        }
        */
    }
}