package other;



/**
 *<p>测试内存溢出</p>
 *<p></p>
 * @author gongzheng
 * @date 2017年9月22日 下午2:18:28
 */
public class TestMain {

	static int num=5;
	
	public static void main(String[] args) {


		int i=1;
		System.out.println(++i);
		System.out.println(i++);
	
	}

	
	
}
