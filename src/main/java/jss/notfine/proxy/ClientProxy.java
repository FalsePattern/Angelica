package jss.notfine.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import jss.notfine.config.NotFineConfig;
import jss.notfine.core.Settings;
import jss.notfine.core.SettingsManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        if(!NotFineConfig.allowAdvancedOpenGL) {
            Minecraft.getMinecraft().gameSettings.advancedOpengl = false;
        }
        if(!NotFineConfig.allowToggle3DAnaglyph) {
            Minecraft.getMinecraft().gameSettings.anaglyph = false;
        }
        if(!NotFineConfig.allowToggleFBO) {
            Minecraft.getMinecraft().gameSettings.fboEnable = true;
        }

        for(Settings setting : Settings.values()) {
            setting.ready();
        }
    }

    @Override
    public void init(FMLInitializationEvent event) { }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        SettingsManager.settingsFile.loadSettings();
    }

}
