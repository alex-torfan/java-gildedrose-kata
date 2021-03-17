package tv.codely.kata.gildedrose;

import java.util.stream.Stream;

class GildedRose {

	private final ItemTypeFactory itemTypeFactory;

	GildedRose(final ItemTypeFactory itemTypeFactory) {
		this.itemTypeFactory = itemTypeFactory;
	}

	public void updateQuality(final Item[] items) {
		Stream.of(items)
				.forEach(this::updateQuality);
	}

	private void updateQuality(final Item item) {
		final ItemType itemType = this.itemTypeFactory.itemType(new ItemName(item.name));
		itemType.updateQuality(item);
	}
}
