
public class Tester {
	static int scoreDisjoints = 0;
	
	public static void main(String[] args) {
		//Test the find function in DisjointSets class
		System.out.println("-----Testing the \"find\" function in DisjointSets class-----");
		DisjointSetsTest1();
		DisjointSetsTest2();
		DisjointSetsTest3();
		DisjointSetsTest4();
		DisjointSetsTest5();
		//Test the union function in DisjointSets class
		System.out.println("-----Testing the \"union\" function in DisjointSets class-----");
		DisjointSetsTest6();
		DisjointSetsTest7();
		DisjointSetsTest8();
		DisjointSetsTest9();
		DisjointSetsTest10();
		System.out.println("Completed the tests for DisjointSets Class. Pts[" + scoreDisjoints + " / 10]");
	}
	
	public static void DisjointSetsTest1() {
		int score = 0;
		DisjointSets myset1 = new DisjointSets(6);
		if(myset1.find(1) == 1 && myset1.find(5) == 5 && myset1.find(0) == 0) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test1 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test1 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest2() {
		int score = 0;
		DisjointSets myset2 = new DisjointSets(6);
		myset2.union(3, 4);
		myset2.union(0, 3);
		if(myset2.find(3) == 4 && myset2.find(4) == 4 && myset2.find(0) == 4) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test2 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test2 failed.  Pts[0 / 1]");
		}
	}

	public static void DisjointSetsTest3() {
		int score = 0;
		DisjointSets myset3 = new DisjointSets(10);
		myset3.union(1, 2);
		myset3.union(0, 9);
		myset3.union(0, 2);
		//all equal to 2 since we merge(0,9) to (1,2)
		if(myset3.find(1) == 2 && myset3.find(2) == 2 && 
				myset3.find(0) == 2 && myset3.find(9) == 2) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test3 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test3 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest4() {
		int score = 0;
		DisjointSets myset4 = new DisjointSets(10);
		myset4.union(1, 2);
		myset4.union(0, 9);
		myset4.union(2, 0);
		//all equal to 9 since we merge(1,2) to (0,9)
		if(myset4.find(1) == 9 && myset4.find(2) == 9 && 
				myset4.find(0) == 9 && myset4.find(9) == 9) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test4 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test4 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest5() {
		int score = 0;
		DisjointSets myset5 = new DisjointSets(10);
		myset5.union(1, 2);
		myset5.union(0, 9);
		myset5.union(2, 3);
		myset5.union(0, 3);
		if(myset5.find(1) == 2 && myset5.find(2) == 2 && myset5.find(3) == 2 &&
				myset5.find(0) == 2 && myset5.find(9) == 2) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test5 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test5 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest6() {
		int score = 0;
		DisjointSets myset6 = new DisjointSets(10);
		myset6.union(1, 2);
		myset6.union(0, 9);
		if(myset6.getRank(myset6.find(1)) == 1 && myset6.getRank(myset6.find(2)) == 1 &&
				myset6.getRank(myset6.find(0)) == 1 && myset6.getRank(myset6.find(9)) == 1 &&
				myset6.getPar(1) == 2 && myset6.getPar(2) == 2 &&
				myset6.getPar(0) == 9 && myset6.getPar(9) == 9) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test6 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test6 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest7() {
		int score = 0;
		DisjointSets myset7 = new DisjointSets(4);
		myset7.union(3, 1);
		myset7.union(0, 2);
		if(myset7.getRank(myset7.find(1)) == 1 && myset7.getRank(myset7.find(3)) == 1 &&
				myset7.getRank(myset7.find(0)) == 1 && myset7.getRank(myset7.find(2)) == 1 &&
				myset7.getPar(1) == 1 && myset7.getPar(2) == 2 &&
				myset7.getPar(0) == 2 && myset7.getPar(3) == 1) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test7 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test7 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest8() {
		int score = 0;
		DisjointSets myset8 = new DisjointSets(4);
		myset8.union(3, 1);
		myset8.union(0, 2);
		myset8.union(3, 0);
		if(myset8.getRank(myset8.find(1)) == 3 && myset8.getRank(myset8.find(3)) == 3 &&
				myset8.getRank(myset8.find(0)) == 3 && myset8.getRank(myset8.find(2)) == 3 &&
				myset8.getPar(1) == 2 && myset8.getPar(2) == 2 &&
				myset8.getPar(0) == 2 && myset8.getPar(3) == 2) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test8 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test8 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest9() {
		int score = 0;
		DisjointSets myset9 = new DisjointSets(5);
		myset9.union(3, 1);
		myset9.union(0, 2);
		myset9.union(3, 4);
		if(myset9.getRank(myset9.find(1)) == 2 && myset9.getRank(myset9.find(3)) == 2 &&
				myset9.getRank(myset9.find(0)) == 1 && myset9.getRank(myset9.find(2)) == 1 &&
						myset9.getRank(myset9.find(4)) == 2 &&
				myset9.getPar(1) == 1 && myset9.getPar(2) == 2 &&
				myset9.getPar(0) == 2 && myset9.getPar(3) == 1 && myset9.getPar(4) == 1) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test9 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test9 failed.  Pts[0 / 1]");
		}
	}
	
	public static void DisjointSetsTest10() {
		int score = 0;
		DisjointSets myset10 = new DisjointSets(5);
		myset10.union(3, 1);
		myset10.union(0, 2);
		myset10.union(3, 4);
		myset10.union(4, 0);
		if(myset10.getRank(myset10.find(1)) == 4 && myset10.getRank(myset10.find(3)) == 4 &&
				myset10.getRank(myset10.find(0)) == 4 && myset10.getRank(myset10.find(2)) == 4 &&
						myset10.getRank(myset10.find(4)) == 4 &&
				myset10.getPar(1) == 1 && myset10.getPar(2) == 1 &&
				myset10.getPar(0) == 1 && myset10.getPar(3) == 1 && myset10.getPar(4) == 1) {
			score = 1;
			scoreDisjoints ++;
		}
		if(score == 1) {
			System.out.println("DisjointSets.Test10 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("DisjointSets.Test10 failed.  Pts[0 / 1]");
		}
	}
}
