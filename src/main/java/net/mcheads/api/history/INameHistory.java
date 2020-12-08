package net.mcheads.api.history;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public interface INameHistory {

	List<NameChangeProperty> getNameChangesHistory();

	default String[] getAllNames() {
		List<String> names = new ArrayList<String>();
		stream().forEach(nameChanges -> names.add(nameChanges.getName()));
		return names.toArray(new String[names.size()]);
	}

	default Stream<NameChangeProperty> stream() {
		return getNameChangesHistory().parallelStream();
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
