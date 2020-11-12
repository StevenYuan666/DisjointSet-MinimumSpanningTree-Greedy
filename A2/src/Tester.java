import java.util.Arrays;
import java.util.Collections;

public class Tester {
	static int scoreDisjoints = 0;
	static int scoreKruskal = 0;
	static int scoreHW = 0;
	
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
		//Test the Minimum Spanning Tree
		System.out.println("-----Testing the result of Minimum Spanning Tree in Kruskal class-----");
		KruskalTest1();
		KruskalTest2();
		KruskalTest3();
		KruskalTest4();
		KruskalTest5();
		System.out.println("Completed the tests for DisjointSets Class. Pts[" + scoreKruskal + " / 5]");
		//Test the compare function in HW_Sched class
		System.out.println("-----Testing the \"compare\" function in HW_Sched class-----");
		CompareTest1();
		CompareTest2();
		CompareTest3();
		CompareTest4();
		CompareTest5();
		//Test the SelectAssignments function in HW_Sched class
		System.out.println("-----Testing the \"SelectAssignments\" function in HW_Sched class-----");
		SelectAssignmentsTest1();
		SelectAssignmentsTest2();
		SelectAssignmentsTest3();
		SelectAssignmentsTest4();
		SelectAssignmentsTest5();
		System.out.println("Completed the tests for HW_Sched Class. Pts[" + scoreHW + " / 10]");
		int total = scoreDisjoints + scoreKruskal + scoreHW;
		System.out.println("The tester completed, please check your total score. Pts[" 
		+ total + " / 25]");
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
		myset5.union(2, 0);
		myset5.union(0, 3);
		if(myset5.find(1) == 9 && myset5.find(2) == 9 && myset5.find(3) == 9 &&
				myset5.find(0) == 9 && myset5.find(9) == 9) {
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
		if(myset8.getRank(myset8.find(1)) == 2 && myset8.getRank(myset8.find(3)) == 2 &&
				myset8.getRank(myset8.find(0)) == 2 && myset8.getRank(myset8.find(2)) == 2 &&
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
		if(myset9.getRank(myset9.find(1)) == 1 && myset9.getRank(myset9.find(3)) == 1 &&
				myset9.getRank(myset9.find(0)) == 1 && myset9.getRank(myset9.find(2)) == 1 &&
						myset9.getRank(myset9.find(4)) == 1 &&
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
		if(myset10.getRank(myset10.find(1)) == 2 && myset10.getRank(myset10.find(3)) == 2 &&
				myset10.getRank(myset10.find(0)) == 2 && myset10.getRank(myset10.find(2)) == 2 &&
						myset10.getRank(myset10.find(4)) == 2 &&
				myset10.getPar(1) == 2 && myset10.getPar(2) == 2 &&
				myset10.getPar(0) == 2 && myset10.getPar(3) == 2 && myset10.getPar(4) == 2) {
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
	
	//Test case from the template
	public static void KruskalTest1() {
		//If need, please change to your own absolute directory
		WGraph g1 = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g1.txt");
		WGraph g1Result = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g1Result.txt");
		WGraph myResult = Kruskal.kruskal(g1);
		if(myResult.toString().equals(g1Result.toString())) {
			scoreKruskal ++;
			System.out.println("Kruskal.Test1 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("Kruskal.Test1 failed.  Pts[0 / 1]");
		}
	}
	
	//Test case from example of Kruskal in class
	public static void KruskalTest2() {
		//If need, please change to your own absolute directory
		WGraph g2 = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g2.txt");
		WGraph g2Result = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g2Result.txt");
		WGraph myResult = Kruskal.kruskal(g2);
		if(myResult.toString().equals(g2Result.toString())) {
			scoreKruskal ++;
			System.out.println("Kruskal.Test2 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("Kruskal.Test2 failed.  Pts[0 / 1]");
		}
	}
	
	//Test case from example of Prim in class
	public static void KruskalTest3() {
		//If need, please change to your own absolute directory
		WGraph g3 = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g3.txt");
		WGraph g3Result = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g3Result.txt");
		WGraph myResult = Kruskal.kruskal(g3);
		if(myResult.toString().equals(g3Result.toString())) {
			scoreKruskal ++;
			System.out.println("Kruskal.Test3 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("Kruskal.Test3 failed.  Pts[0 / 1]");
		}
	}
	
	//Test case from the exercise of the second midterm on page 12
	public static void KruskalTest4() {
		//If need, please change to your own absolute directory
		WGraph g4 = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g4.txt");
		WGraph g4Result = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g4Result.txt");
		WGraph myResult = Kruskal.kruskal(g4);
		if(myResult.toString().equals(g4Result.toString())) {
			scoreKruskal ++;
			System.out.println("Kruskal.Test4 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("Kruskal.Test4 failed.  Pts[0 / 1]");
		}
	}
	
	//Test case from the exercise of the second midterm on page 15
	public static void KruskalTest5() {
		//If need, please change to your own absolute directory
		WGraph g5 = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g5.txt");
		WGraph g5Result = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A2/A2/src/g5Result.txt");
		WGraph myResult = Kruskal.kruskal(g5);
		if(myResult.toString().equals(g5Result.toString())) {
			scoreKruskal ++;
			System.out.println("Kruskal.Test5 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("Kruskal.Test5 failed.  Pts[0 / 1]");
		}
	}
	
	public static void CompareTest1() {
		Assignment a1 = new Assignment(1, 50, 2);
		Assignment a2 = new Assignment(4, 50, 2);
		if(a1.compare(a1, a2) == 0) {
			scoreHW ++;
			System.out.println("HW_Sched.Test1 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test1 failed. Pts[0 / 1]");
		}
	}
	
	public static void CompareTest2() {
		Assignment a1 = new Assignment(1, 50, 3);
		Assignment a2 = new Assignment(4, 50, 1);
		if(a1.compare(a1, a2) == 1) {
			scoreHW ++;
			System.out.println("HW_Sched.Test2 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test2 failed. Pts[0 / 1]");
		}
	}
	
	public static void CompareTest3() {
		Assignment a1 = new Assignment(1, 70, 1);
		Assignment a2 = new Assignment(4, 50, 1);
		if(a1.compare(a1, a2) == -1) {
			scoreHW ++;
			System.out.println("HW_Sched.Test3 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test3 failed. Pts[0 / 1]");
		}
	}
	
	public static void CompareTest4() {
		int[] weights = new int[] {23, 60, 14, 25, 7}; 
		int[] deadlines = new int[] {3, 1, 2, 1, 3};
		int m = weights.length;
		HW_Sched schedule =  new HW_Sched(weights, deadlines, m);
		Collections.sort(schedule.Assignments, new Assignment());
		if(schedule.Assignments.get(0).number == 1 && schedule.Assignments.get(1).number == 3 &&
				schedule.Assignments.get(2).number == 2 && schedule.Assignments.get(3).number == 0
				&& schedule.Assignments.get(4).number == 4) {
			scoreHW ++;
			System.out.println("HW_Sched.Test4 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test4 failed. Pts[0 / 1]");
		}
	}
	
	public static void CompareTest5() {
		int[] weights = new int[] {23, 60, 14, 61, 70, 30, 28}; 
		int[] deadlines = new int[] {3, 1, 2, 1, 3, 5, 4};
		int m = weights.length;
		HW_Sched schedule =  new HW_Sched(weights, deadlines, m);
		Collections.sort(schedule.Assignments, new Assignment());
		if(schedule.Assignments.get(0).number == 3 && schedule.Assignments.get(1).number == 1 &&
				schedule.Assignments.get(2).number == 2 && schedule.Assignments.get(3).number == 4
				&& schedule.Assignments.get(4).number == 0 && schedule.Assignments.get(5).number == 6
				&& schedule.Assignments.get(6).number == 5) {
			scoreHW ++;
			System.out.println("HW_Sched.Test5 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test5 failed. Pts[0 / 1]");
		}
	}
	
	public static void SelectAssignmentsTest1() {
		int[] weights = new int[] {23, 60, 14, 25, 7}; 
		int[] deadlines = new int[] {3, 1, 2, 1, 3};
		int m = weights.length;
		HW_Sched schedule =  new HW_Sched(weights, deadlines, m);
		int [] plan = schedule.SelectAssignments();
		int [] result = {1, 2, 0};
		if(Arrays.toString(plan).equals(Arrays.toString(result))) {
			scoreHW ++;
			System.out.println("HW_Sched.Test6 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test6 failed. Pts[0 / 1]");
		}
	}
	
	public static void SelectAssignmentsTest2() {
		int[] weights = new int[] {23, 60, 25, 7}; 
		int[] deadlines = new int[] {3, 1, 1, 3};
		int m = weights.length;
		HW_Sched schedule =  new HW_Sched(weights, deadlines, m);
		int [] plan = schedule.SelectAssignments();
		int [] result = {1, 0, 3};
		if(Arrays.toString(plan).equals(Arrays.toString(result))) {
			scoreHW ++;
			System.out.println("HW_Sched.Test7 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test7 failed. Pts[0 / 1]");
		}
	}
	
	public static void SelectAssignmentsTest3() {
		int[] weights = new int[] {23, 60, 25, 7, 30}; 
		int[] deadlines = new int[] {3, 1, 2, 3, 5};
		int m = weights.length;
		HW_Sched schedule =  new HW_Sched(weights, deadlines, m);
		int [] plan = schedule.SelectAssignments();
		int [] result = {1, 2, 0, 4, -1};
		if(Arrays.toString(plan).equals(Arrays.toString(result))) {
			scoreHW ++;
			System.out.println("HW_Sched.Test8 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test8 failed. Pts[0 / 1]");
		}
	}
	
	public static void SelectAssignmentsTest4() {
		int[] weights = new int[] {10, 40, 80, 60, 70, 20, 100, 30, 50, 90}; 
		int[] deadlines = new int[] {0, 1, 3, 9, 4, 3, 3, 5, 9, 6};
		int m = weights.length;
		HW_Sched schedule =  new HW_Sched(weights, deadlines, m);
		int [] plan = schedule.SelectAssignments();
		int [] result = {1, 6, 2, 4, 7, 9, 3, 8, -1};
		//System.out.println(Arrays.toString(plan));
		if(Arrays.toString(plan).equals(Arrays.toString(result))) {
			scoreHW ++;
			System.out.println("HW_Sched.Test9 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test9 failed. Pts[0 / 1]");
		}
	}
	
	public static void SelectAssignmentsTest5() {
		int[] weights = new int[] {10, 40, 80, 60, 70, 20, 100, 30, 50, 90}; 
		int[] deadlines = new int[] {0, 0, 3, -1, 4, 0, 3, 5, 7, 6};
		int m = weights.length;
		HW_Sched schedule =  new HW_Sched(weights, deadlines, m);
		int [] plan = schedule.SelectAssignments();
		int [] result = {6, 2, 4, 7, 9, 8, -1};
		//System.out.println(Arrays.toString(plan));
		if(Arrays.toString(plan).equals(Arrays.toString(result))) {
			scoreHW ++;
			System.out.println("HW_Sched.Test10 succeed. Pts[1 / 1]");
		}
		else {
			System.out.println("HW_Sched.Test10 failed. Pts[0 / 1]");
		}
	}
}
