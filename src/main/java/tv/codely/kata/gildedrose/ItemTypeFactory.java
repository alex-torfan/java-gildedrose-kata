package tv.codely.kata.gildedrose;

import java.util.Collections;
import java.util.Map;

public final class ItemTypeFactory {

	private static final DefaultMutableItem DEFAULT_MUTABLE_ITEM = new DefaultMutableItem();

	private final Map<ItemName, ItemType> itemTypes;

	public ItemTypeFactory(final Map<ItemName, ItemType> itemTypes) {
		this.itemTypes = Collections.unmodifiableMap(itemTypes);
	}

	public ItemType itemType(final ItemName itemName) {
		return this.itemTypes.getOrDefault(itemName, ItemTypeFactory.DEFAULT_MUTABLE_ITEM);
	}
}
