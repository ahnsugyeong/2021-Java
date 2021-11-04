
abstract class PairMap {
	protected String keyArray [];
	protected String valueArray [];
	abstract String get(String key);
	abstract void put(String key, String value);
	abstract String delete(String key);
	abstract int length();
}
class Dictionary extends PairMap{

	private int len;
	private int max;
	Dictionary(int _max){
		max = _max;
		keyArray = new String[max];
		valueArray = new String[max];
		len = 0;
	}
	String get(String key) {
		int index = -1;
		for(int i =0;i<len;i++) {
			if (key.equals(keyArray[i])) index = i;
		}
		if (index == -1) return null;
		else return valueArray[index];
	}
	void put(String key, String value) {
		if(this.get(key)==null) {
		keyArray[len] = key;
		valueArray[len] = value;
		len++;
		}
		else {
			for(int i =0;i<len;i++) {
				if (key.equals(keyArray[i])) valueArray[i] = value;
			}
		}
	}
	String delete(String key) {
		String value = null;
		boolean flag = false;
		for(int i =0;i<len;i++) {
			if (key.equals(keyArray[i])) {
				if (flag == false) {
				value = valueArray[i];
				flag = true;
				}
				keyArray[i] = keyArray[i+1];
				valueArray[i] = valueArray[i+1];
			}
		}
		return value;
	}
	int length() {
		return len;
	}
}
public class Hw2_2 {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 "+dic.get("이재문"));
		System.out.println("황기태의 값은 "+dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
	}

}
