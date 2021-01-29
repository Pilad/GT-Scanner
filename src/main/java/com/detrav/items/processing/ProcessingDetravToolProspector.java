package com.detrav.items.processing;

import com.detrav.items.DetravMetaGeneratedTool01;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static com.detrav.DetravScannerMod.DEBUGBUILD;

/**
 * Created by wital_000 on 18.03.2016.
 */
public class ProcessingDetravToolProspector implements gregtech.api.interfaces.IOreRecipeRegistrator {			
    public ProcessingDetravToolProspector() {
        OrePrefixes.toolHeadPickaxe.add(this);
        
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
		long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;		
        if(!aPrefix.doGenerateItem(aMaterial)) return;
        if (DEBUGBUILD) return;
		try {
        GT_ModHandler.addCraftingRecipe(DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(100, 1, aMaterial, Materials.Steel, new long[]{100000L, GT_Values.V[1], 1L, -1L}), bits, new Object[]{"EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_LV, 'H', OrePrefixes.toolHeadDrill.get(aMaterial),'E', ItemList.Emitter_LV,'C', OrePrefixes.circuit.get(Materials.Basic), 'P', OrePrefixes.plate.get(Materials.Steel), 'B', ItemList.Battery_RE_LV_Lithium.get(1L)});
        GT_ModHandler.addCraftingRecipe(DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(102, 1, aMaterial, Materials.Aluminium, new long[]{400000L, GT_Values.V[2], 2L, -1L}), bits, new Object[]{"EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_MV, 'H', OrePrefixes.toolHeadDrill.get(aMaterial), 'E', ItemList.Emitter_MV,'C', OrePrefixes.circuit.get(Materials.Good), 'P', OrePrefixes.plate.get(Materials.Aluminium), 'B', ItemList.Battery_RE_MV_Lithium.get(1L)});
        GT_ModHandler.addCraftingRecipe(DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(104, 1, aMaterial, Materials.StainlessSteel, new long[]{1600000L, GT_Values.V[3], 3L, -1L}), bits, new Object[]{"EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_HV, 'H', OrePrefixes.toolHeadDrill.get(aMaterial), 'E', ItemList.Emitter_HV,'C', OrePrefixes.circuit.get(Materials.Advanced), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_HV_Lithium.get(1L)});
        GT_ModHandler.addCraftingRecipe(DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(104, 1, aMaterial, Materials.StainlessSteel, new long[]{1600000L, GT_Values.V[3], 3L, -1L}), bits, new Object[]{"EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_HV, 'H', OrePrefixes.toolHeadDrill.get(aMaterial), 'E', ItemList.Emitter_HV,'C', OrePrefixes.circuit.get(Materials.Advanced), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'B',  OrePrefixes.battery.get(Materials.Elite)});
		GT_ModHandler.addCraftingRecipe(DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(106, 1, aMaterial, Materials.Titanium, new long[]{10000000L, GT_Values.V[4], 4L, -1L}), bits, new Object[]{"EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_EV, 'H', OrePrefixes.toolHeadDrill.get(aMaterial), 'E', ItemList.Emitter_EV,'C', OrePrefixes.circuit.get(Materials.Data), 'P', OrePrefixes.plate.get(Materials.Titanium), 'B', OrePrefixes.battery.get(Materials.Master)});
        } catch (Exception ignored){}		
    }
}
