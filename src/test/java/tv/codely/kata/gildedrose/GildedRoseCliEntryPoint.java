package tv.codely.kata.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class GildedRoseCliEntryPoint {

	private static final ItemName AGED_BRIE = new ItemName("Aged Brie");
	private static final ItemName BACKSTAGE_PASSES_TO_A_TAFKA_L80ETC_CONCERT = new ItemName("Backstage passes to a TAFKAL80ETC concert");
	private static final ItemName SULFURAS_HAND_OF_RAGNAROS = new ItemName("Sulfuras, Hand of Ragnaros");
	private static final ItemName CONJURED_MANA_CAKE = new ItemName("Conjured Mana Cake");

	private GildedRoseCliEntryPoint() {
	}

	public static void main(final String[] args) {
		System.out.println("OMGHAI!");

		final Item[] items = new Item[]{
				new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 5, 49)};

		final GildedRose app = new GildedRose(GildedRoseCliEntryPoint.createItemTypeFactory());

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (final Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			app.updateQuality(items);
		}
	}

	private static ItemTypeFactory createItemTypeFactory() {
		final Map<ItemName, ItemType> itemTypes = new HashMap<>();
		itemTypes.put(GildedRoseCliEntryPoint.AGED_BRIE, new AgedBrie());
		itemTypes.put(GildedRoseCliEntryPoint.BACKSTAGE_PASSES_TO_A_TAFKA_L80ETC_CONCERT, new BackstageEntrance());
		itemTypes.put(GildedRoseCliEntryPoint.SULFURAS_HAND_OF_RAGNAROS, new InmutableItem());
		itemTypes.put(GildedRoseCliEntryPoint.CONJURED_MANA_CAKE, new ConjuredItem());
		return new ItemTypeFactory(itemTypes);
	}
}
