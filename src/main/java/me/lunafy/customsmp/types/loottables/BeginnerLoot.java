package me.lunafy.customsmp.types.loottables;

import me.lunafy.customsmp.CustomSMP;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;

import java.util.*;

public class BeginnerLoot implements LootTable {
    private final NamespacedKey key = new NamespacedKey(CustomSMP.getInstance(), "BeginnerLoot");

    @Override
    public Collection<ItemStack> populateLoot(Random random, LootContext lootContext) {
        Collection<ItemStack> items = new ArrayList<ItemStack>();

        for(int i = 0; i < random.nextInt(5, 10); i++) {
            items.add(new ItemStack(Material.BREAD));
        }

        for(int i = 0; i < random.nextInt(4, 8); i++) {
            items.add(new ItemStack(Material.EXPERIENCE_BOTTLE));
        }

        List<Material> armourToEnchant = new ArrayList<Material>();
        armourToEnchant.add(Material.LEATHER_BOOTS);
        armourToEnchant.add(Material.LEATHER_LEGGINGS);
        armourToEnchant.add(Material.LEATHER_CHESTPLATE);
        armourToEnchant.add(Material.LEATHER_HELMET);
        armourToEnchant.add(Material.STONE_SWORD);

        for(Material mat : armourToEnchant) {
            ItemStack item = new ItemStack(mat);
            if(mat.getEquipmentSlot() == EquipmentSlot.HAND || mat.getEquipmentSlot() == EquipmentSlot.OFF_HAND) {
                item.addEnchantment(Enchantment.DAMAGE_ALL, 2);
            } else {
                item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
            }


            items.add(item);
        }

        return items;
    }

    @Override
    public void fillInventory(Inventory inventory, Random random, LootContext lootContext) {
        int inventorySize = inventory.getSize();
        List<ItemStack> slots = new ArrayList<ItemStack>();
        List<ItemStack> loot = (List<ItemStack>) populateLoot(random, lootContext);

        for(ItemStack newItem : loot) {
            System.out.println(newItem.getType());
        }

        for(int i = 0; i < inventorySize - loot.size(); i++) {
            slots.add(new ItemStack(Material.AIR));
        }

        slots.addAll(loot);

        Collections.shuffle(slots);

        for(int i = 0; i < inventorySize; i++) {
            System.out.println(slots.get(i));
            inventory.setItem(i, slots.get(i));
        }
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }
}
