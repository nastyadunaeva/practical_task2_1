package serialization;
/*
 * Сериализуемый класс
 */
public class MyClassToBePersisted {
	private String profile;
	private String group;
	
	public MyClassToBePersisted(String profile, String group) {
		this.profile = profile;
		this.group = group;
	}
	/*
	 * Возвращает профиль
	 */
	public String getProfile() {
		return profile;
	}
	/*
	 * Устанавливает значение профиля
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/*
	 * Возвращает группу
	 */
	public String getGroup() {
		return group;
	}
	/*
	 * Устанавливает значение профиля
	 */
	public void setGroup(String group) {
		this.group = group;
	}
}
