package com.workert.robotics.lists;

import com.workert.robotics.Robotics;
import com.workert.robotics.items.BaseRobotItem;
import com.workert.robotics.items.ExtendOBootsItem;
import com.workert.robotics.items.ModArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;

public class ItemList {
	public static final CreativeModeTab ROBOTICS_TAB = new CreativeModeTab(Robotics.MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemList.BRONZE_INGOT.get());
		}
	};

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Robotics.MOD_ID);

	public static final RegistryObject<Item> TIN_INGOT = registerBasicItem("tin_ingot", Optional.empty());
	public static final RegistryObject<Item> TIN_NUGGET = registerBasicItem("tin_nugget", Optional.empty());
	public static final RegistryObject<Item> RAW_TIN = registerBasicItem("raw_tin", Optional.empty());

	public static final RegistryObject<Item> BRONZE_INGOT = registerBasicItem("bronze_ingot", Optional.empty());
	public static final RegistryObject<Item> BRONZE_NUGGET = registerBasicItem("bronze_nugget", Optional.empty());

	public static final RegistryObject<Item> PROGRAM = registerBasicItem("program",
			Optional.of(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).tab(ROBOTICS_TAB)));

	public static final RegistryObject<Item> CLOCKCOPTER = ITEMS.register("clockcopter",
			() -> new BaseRobotItem(() -> EntityList.CLOCKCOPTER.get(),
					new Item.Properties().tab(ROBOTICS_TAB)));

	public static final RegistryObject<Item> MINER = ITEMS.register("miner",
			() -> new BaseRobotItem(() -> EntityList.MINER.get(),
					new Item.Properties().tab(ROBOTICS_TAB)));

	public static final RegistryObject<Item> CODE_DRONE = ITEMS.register("code_drone",
			() -> new BaseRobotItem(() -> EntityList.CODE_DRONE.get(),
					new Item.Properties().tab(ROBOTICS_TAB)));

	public static final RegistryObject<Item> EXTEND_O_BOOTS = ITEMS.register("extend_o_boots",
			() -> new ExtendOBootsItem(ModArmorMaterials.EXTEND_O_BOOTS, EquipmentSlot.FEET,
					new Item.Properties().tab(ROBOTICS_TAB)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

	public static RegistryObject<Item> registerBasicItem(String id, Optional<Item.Properties> itemProperties) {
		RegistryObject<Item> registyObject = ITEMS.register(id,
				() -> new Item(itemProperties.orElse(new Item.Properties()).tab(ROBOTICS_TAB)));
		return registyObject;
	}
}
