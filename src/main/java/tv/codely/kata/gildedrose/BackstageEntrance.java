package tv.codely.kata.gildedrose;

public final class BackstageEntrance extends ItemType {

	@Override
	public void updateQuality(final Item item) {
		this.increaseQuality(item);

		if (item.sellIn < 11) {
			this.increaseQuality(item);
		}

		if (item.sellIn < 6) {
			this.increaseQuality(item);
		}

		this.decreaseSellIn(item);

		if (this.isOutOfRecommendedSaleDate(item)) {
			this.resetQuality(item);
		}
	}
}
