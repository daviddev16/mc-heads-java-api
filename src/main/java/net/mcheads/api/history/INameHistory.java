package net.mcheads.api.history;

import java.util.Vector;
import java.util.stream.Stream;

public interface INameHistory {

	Vector<NameChangeProperty> getNameChangesHistory();

	default String[] getAllNames() {
		Vector<String> names = new Vector<String>();
		stream().forEach(nameChanges -> names.add(nameChanges.getName()));
		return names.toArray(new String[names.size()]);
	}
	default Stream<NameChangeProperty> stream() {
		return getNameChangesHistory().stream();
	}
	default String getNameAt(long date) {
		return getNameChangeProperty(date).getName();
	}
	default NameChangeProperty getNameChangeProperty(String name) {
		return getNameChangesHistory().stream()
				.filter(nc -> nc.getName().equals(name))
				.findFirst().orElse(null);
	}
	default NameChangeProperty getNameChangeProperty(long date) {
		return getNameChangesHistory().stream()
				.filter(nc -> nc.getDate() == date)
				.findFirst().orElse(null);
	}
}
