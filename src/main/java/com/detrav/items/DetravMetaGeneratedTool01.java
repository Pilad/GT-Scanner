package com.detrav.items;

import java.util.List;

import com.detrav.DetravScannerMod;
import com.detrav.enums.DetravToolDictNames;
import com.detrav.items.tools.*;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.IToolStats;
import gregtech.api.items.GT_MetaGenerated_Tool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

/**
 * Created by wital_000 on 19.03.2016.
 */
public class DetravMetaGeneratedTool01 extends GT_MetaGenerated_Tool {
    public static DetravMetaGeneratedTool01 INSTANCE;

    public DetravMetaGeneratedTool01() {
        super("detrav.metatool.01");
        INSTANCE = this;
        addTool(100, "Electric Prospector's Scanner (LV)", "", new DetravToolElectricProspector(6), DetravToolDictNames.craftingToolElectricProspector);
        addTool(102, "Electric Prospector's Scanner (MV)", "", new DetravToolElectricProspector(7), DetravToolDictNames.craftingToolElectricProspector);
        addTool(104, "Electric Prospector's Scanner (HV)", "", new DetravToolElectricProspector(8), DetravToolDictNames.craftingToolElectricProspector);
        addTool(106, "Electric Prospector's Scanner (EV)", "", new DetravToolElectricProspector(9), DetravToolDictNames.craftingToolElectricProspector);
		addTool(108, "Portable Battery Charger",           "", new DetravToolPortableCharger(), DetravToolDictNames.craftingToolPortableCharger);

        setCreativeTab(DetravScannerMod.TAB_DETRAV);
    }
	
    @SuppressWarnings("unchecked")
    public void addAdditionalToolTips(List aList, ItemStack aStack, EntityPlayer aPlayer) {
        long tMaxDamage = getToolMaxDamage(aStack);
        Materials tMaterial = getPrimaryMaterial(aStack);
        IToolStats tStats = getToolStats(aStack);
        int tOffset = aList.size(); 
        if (tStats != null) {
            String name = aStack.getUnlocalizedName();
            String num = name.substring("gt.detrav.metatool.01.".length());
            int meta = Integer.parseInt(num);
            int range = getHarvestLevel(aStack, "")/2+(meta/4);
            if ((range % 2) == 0 ) {
                range += 1;
            }
            if (meta >=100 && meta<=106) {
                    aList.add(tOffset + 0, EnumChatFormatting.WHITE + "Durability: " + EnumChatFormatting.GREEN + (tMaxDamage - getToolDamage(aStack)) + " / " + tMaxDamage + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 1, EnumChatFormatting.WHITE + tMaterial.mDefaultLocalName + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 2, EnumChatFormatting.WHITE + "Chunks: " + EnumChatFormatting.YELLOW + (getHarvestLevel(aStack, "") * 2 + 1) + "x" + (getHarvestLevel(aStack, "") * 2 + 1) + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 3, EnumChatFormatting.ITALIC+ "Right click on rock for prospecting current chunk!");
                    aList.add(tOffset + 4, EnumChatFormatting.ITALIC+ "Right click on bedrock for prospecting oil!");
                    aList.add(tOffset + 5, EnumChatFormatting.ITALIC+ "Right click for scanning!");
            }
			if (meta >=108) {
                    aList.add(tOffset + 0, EnumChatFormatting.WHITE + "Loss/Tick EU: " + EnumChatFormatting.GREEN + getElectricStatsLoss(aStack) + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 1, EnumChatFormatting.WHITE + "Durability: " + EnumChatFormatting.GREEN + (tMaxDamage - getToolDamage(aStack)) + " / " + tMaxDamage + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 2, "Can use as normal battery");
                    aList.add(tOffset + 3, "x4 charge speed for tools");
                    aList.add(tOffset + 4, "Right click to open GUI");
            }
        }
    }

    public Long getElectricStatsLoss(ItemStack aStack) {
        NBTTagCompound aNBT = aStack.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null && aNBT.getBoolean("Electric"))
                return aNBT.getLong("Loss");
        }
        return 0L;
    }

    public final ItemStack getToolWithStatsPlus(int aToolID, int aAmount, Materials aPrimaryMaterial, Materials aSecondaryMaterial, long[] aElectricArray, long aLoss) {
        return getToolWithStatsPlus(aToolID, aAmount, aPrimaryMaterial, aSecondaryMaterial, aElectricArray, aLoss, 10000L);
    }

    public final ItemStack getToolWithStatsPlus(int aToolID, int aAmount, Materials aPrimaryMaterial, Materials aSecondaryMaterial, long[] aElectricArray, long aLoss, long durability) {
        ItemStack result = getToolWithStats(aToolID, aAmount, aPrimaryMaterial, aSecondaryMaterial, aElectricArray);
        NBTTagCompound aNBT = result.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null && aNBT.getBoolean("Electric")) {
                aNBT.setLong("Loss", aLoss);
            }
            aNBT.setLong("MaxDamage", durability);
        }
        return result;
    }

    public Long getToolGTDetravData(ItemStack aStack) {
        NBTTagCompound aNBT = aStack.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null)
                return aNBT.getLong("DetravData");
        }
        return 0L;
    }

    public boolean setToolGTDetravData(ItemStack aStack, long data) {
        NBTTagCompound aNBT = aStack.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null) {
                aNBT.setLong("DetravData", data);
                return true;
            }
        }
        return false;
    }
 
    @SuppressWarnings("unchecked")
    public void getDetravSubItems(Item item, CreativeTabs detravCreativeTab, List list) {
        ItemStack dStack;
        //Electric Scanners 
        dStack = getToolWithStats(100, 1, Materials.Steel, Materials.Steel, new long[]{100000L, GT_Values.V[1], 1L, -1L});
        setCharge(dStack,100000L);
        list.add(dStack);
        dStack = getToolWithStats(102, 1, Materials.Aluminium, Materials.Aluminium, new long[]{400000L, GT_Values.V[2], 2L, -1L});
        setCharge(dStack,400000L);
        list.add(dStack);
		dStack = getToolWithStats(104, 1, Materials.StainlessSteel, Materials.StainlessSteel, new long[]{1600000L, GT_Values.V[3], 3L, -1L});
		setCharge(dStack, 1600000L);
		list.add(dStack);
		dStack = getToolWithStats(106, 1, Materials.Titanium, Materials.Titanium, new long[]{10000000L, GT_Values.V[4], 4L, -1L});
		setCharge(dStack, 10000000L);
		list.add(dStack);
		
        dStack = getToolWithStatsPlus(108, 1, Materials.Steel, Materials.Steel, new long[]{4 * 100000L, 32L, 1L, -3L}, 1);
        setCharge(dStack,4 * 100000L);
        list.add(dStack);

        dStack = getToolWithStatsPlus(108, 1, Materials.Aluminium, Materials.Aluminium, new long[]{4 * 400000L, 128L, 2L, -3L}, 1);
        setCharge(dStack,4 * 400000L);
        list.add(dStack);

        dStack = getToolWithStatsPlus(108, 1, Materials.StainlessSteel, Materials.StainlessSteel, new long[]{4 * 1600000L, 512L, 3L, -3L}, 1);
        setCharge(dStack,4 * 1600000L);
        list.add(dStack);
		
        dStack = getToolWithStatsPlus(108, 1, Materials.Titanium, Materials.Titanium, new long[]{4 * 10000000L, 2048L, 4L, -3L}, 1);
        setCharge(dStack,4 * 10000000L);
        list.add(dStack);		

    }

}
