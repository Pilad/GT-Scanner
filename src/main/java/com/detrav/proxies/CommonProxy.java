package com.detrav.proxies;

import com.detrav.DetravScannerMod;
import com.detrav.events.DetravLoginEventHandler;
import com.detrav.gui.DetravScannerGUI;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import com.detrav.gui.containers.DetravPortableChargerContainer;
import com.detrav.gui.DetravPortableChargerGui;
import com.detrav.items.processing.ProcessingDetravPortableCharger;

/**
 * Created by wital_000 on 19.03.2016.
 */
public class CommonProxy implements IGuiHandler {

    public void onLoad() {

    }

    public void onPostLoad() {
        DetravLoginEventHandler.register();
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case DetravScannerGUI.GUI_ID:
                return null;
            case DetravPortableChargerGui.GUI_ID:
                return new DetravPortableChargerContainer(player.inventory,world,player.getCurrentEquippedItem());
				
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case DetravScannerGUI.GUI_ID:
                return new DetravScannerGUI();
            case DetravPortableChargerGui.GUI_ID:
                return new DetravPortableChargerGui(player.inventory,world,player.getCurrentEquippedItem());
				
            default:
                return null;
        }
    }


    public void openProspectorGUI() {
        //just Client code
    }


    public void onPreInit() {

    }

    public void openPortableChargerGui(EntityPlayer player)
    {
        player.openGui(DetravScannerMod.instance, DetravPortableChargerGui.GUI_ID,player.worldObj,(int)player.posX,(int)player.posY,(int)player.posZ);
    }
	
    public void sendPlayerExeption(String s) {

    }
}
