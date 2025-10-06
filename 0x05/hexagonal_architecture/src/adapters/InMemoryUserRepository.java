// Adaptador (Implementação do repositório em memória)
package adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.User;
import ports.UserRepository;

public class InMemoryUserRepository implements UserRepository {
	private final Map<String, User> database = new HashMap<>();

	@Override
	public void save(User user) {
		User findUser = database.get(user.getId());
		if (findUser == null) {
			database.put(user.getId(), user);
		}
	}

	@Override
	public User findById(String id) {
		return database.get(id);
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		for (Map.Entry<String, User> usersdb : database.entrySet()) {
			users.add(new User(usersdb.getKey(), usersdb.getValue().getName()));
		}
		return users;
	}

}