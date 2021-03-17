package tv.codely.kata.gildedrose;

public final class ConjuredItem extends ItemType {

	@Override
	public void updateQuality(final Item item) {
		this.decreaseQuality(item);
		this.decreaseQuality(item);

		this.decreaseSellIn(item);

		if (this.isOutOfRecommendedSaleDate(item)) {
			this.decreaseQuality(item);
			this.decreaseQuality(item);
		}
	}
}
