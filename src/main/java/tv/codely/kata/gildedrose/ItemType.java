package tv.codely.kata.gildedrose;

public abstract class ItemType {

	public abstract void updateQuality(final Item item);

	public boolean isOutOfRecommendedSaleDate(final Item item) {
		return item.sellIn < 0;
	}

	public void resetQuality(final Item item) {
		item.quality = 0;
	}

	private boolean canIncreaseQuality(final Item item) {
		return item.quality < 50;
	}

	private boolean canDecreaseQuality(final Item item) {
		return item.quality > 0;
	}

	public void increaseQuality(final Item item) {
		if (!this.canIncreaseQuality(item)) {
			return;
		}
		item.quality++;
	}

	public void decreaseQuality(final Item item) {
		if (!this.canDecreaseQuality(item)) {
			return;
		}
		item.quality--;
	}

	public void decreaseSellIn(final Item item) {
		item.sellIn--;
	}
}
