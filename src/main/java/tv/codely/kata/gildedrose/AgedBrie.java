package tv.codely.kata.gildedrose;

public final class AgedBrie extends ItemType {

	@Override
	public void updateQuality(final Item item) {
		this.increaseQuality(item);

		this.decreaseSellIn(item);

		if (this.isOutOfRecommendedSaleDate(item)) {
			this.increaseQuality(item);
		}
	}
}
