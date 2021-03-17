package tv.codely.kata.gildedrose;

import java.util.Objects;

public final class ItemName {

	private final String value;

	public ItemName(final String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !this.getClass().equals(o.getClass())) {
			return false;
		}
		final ItemName itemName = (ItemName) o;
		return this.value.equals(itemName.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}
}
