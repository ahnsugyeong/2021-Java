import java.util.Scanner;

public class Hw1_4 {
	
	public static void main(String[] args) {
	    int x[][] = new int[4][4];
	    int index_i, index_j;
	    for(int i = 0 ; i < 10; i++) {
		    while(true) {
		    	index_i = (int)(Math.random()*4);
			    index_j = (int)(Math.random()*4);
			    if (x[index_i][index_j] == 0) break;
	    	}
		    x[index_i][index_j] = (int)(Math.random()*10 + 1);
	    }
	    for(int[] i : x) {
	    	for(int j : i) {
	    		System.out.print(j + " ");
	    	}
	    	System.out.println();
	    }
	}
}
/*
 * 처음에 index_i, index_j 그거 숫자를 3으로 했더니 무한 루프에빠져서 자꾸안 됐다 알고보니
 * 그거 범위가 0~2까지만 도는 거여서 당연히 9개밖에 가질 수가 없는데10번을 돌렸
 * 으니까 안 됐음. 그리고 for(int j : x[i]라고 하니까 안 됐음.i 자체가 x
 * 의 그 한 줄 배열 자체여서 i로 써줘야함.
 */