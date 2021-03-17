package tv.codely.kata.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseShould {

	private static final ItemName AGED_BRIE = new ItemName("Aged Brie");
	private static final ItemName BACKSTAGE_PASSES_TO_A_TAFKA_L80ETC_CONCERT = new ItemName("Backstage passes to a TAFKAL80ETC concert");
	private static final ItemName SULFURAS_HAND_OF_RAGNAROS = new ItemName("Sulfuras, Hand of Ragnaros");
	private static final ItemName CONJURED_MANA_CAKE = new ItemName("Conjured Mana Cake");

	private ItemTypeFactory createItemTypeFactory() {
		final Map<ItemName, ItemType> itemTypes = new HashMap<>();
		itemTypes.put(GildedRoseShould.AGED_BRIE, new AgedBrie());
		itemTypes.put(GildedRoseShould.BACKSTAGE_PASSES_TO_A_TAFKA_L80ETC_CONCERT, new BackstageEntrance());
		itemTypes.put(GildedRoseShould.SULFURAS_HAND_OF_RAGNAROS, new InmutableItem());
		itemTypes.put(GildedRoseShould.CONJURED_MANA_CAKE, new ConjuredItem());
		return new ItemTypeFactory(itemTypes);
	}

	private Item[] arrayWith(final Item item) {
		return new Item[]{item};
	}

	@Test
	void testThatSellInValueIsDecreased() {
		final Item whateverItem = new Item("whatever", 10, 0);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(whateverItem));

		assertEquals(9, whateverItem.sellIn);
	}

	@Test
	void testThatQualityValueIsDecreased() {
		final Item whateverItem = new Item("whatever", 1, 10);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(whateverItem));

		assertEquals(9, whateverItem.quality);
	}

	@Test
	void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
		final Item whateverItem = new Item("whatever", 0, 10);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(whateverItem));

		assertEquals(8, whateverItem.quality);
	}

	@Test
	void testThatQualityIsNeverNegative() {
		final Item whateverItem = new Item("whatever", 0, 0);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(whateverItem));

		assertEquals(0, whateverItem.quality);
	}

	@Test
	void testAgedBrieIncreasesQualityWithAge() {
		final Item agedBrie = new Item("Aged Brie", 5, 1);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(agedBrie));

		assertEquals(2, agedBrie.quality);
	}

	@Test
	void testConjuredManaCakeDecreasesQualityDoubleThanNormal() {
		final Item conjuredManaCake = new Item("Conjured Mana Cake", 5, 2);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(conjuredManaCake));

		assertEquals(0, conjuredManaCake.quality);
	}

	@Test
	void testConjuredManaCakeDecreasesQualityDoubleThanNormalWhenOutOfSaleDateRecommended() {
		final Item conjuredManaCake = new Item("Conjured Mana Cake", 0, 6);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(conjuredManaCake));

		assertEquals(2, conjuredManaCake.quality);
	}

	@Test
	void testQualityNeverIncreasesPastFifty() {
		final Item agedBrie = new Item("Aged Brie", 5, 50);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(agedBrie));

		assertEquals(50, agedBrie.quality);
	}

	@Test
	void testSulfurasNeverChanges() {
		final Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(sulfuras));

		assertEquals(25, sulfuras.quality);
		assertEquals(0, sulfuras.sellIn);
	}

	@Test
	void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
		final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(backstagePasses));

		assertEquals(21, backstagePasses.quality);
	}

	@Test
	void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
		final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(backstagePasses));

		assertEquals(22, backstagePasses.quality);
	}

	@Test
	void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
		final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(backstagePasses));

		assertEquals(23, backstagePasses.quality);
	}

	@Test
	void testBackstagePassLosesValueAfterSellByPasses() {
		final Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

		final GildedRose gildedRose = new GildedRose(this.createItemTypeFactory());
		gildedRose.updateQuality(this.arrayWith(backstagePasses));

		assertEquals(0, backstagePasses.quality);
	}
}
