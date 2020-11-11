import java.util.*;

class Assignment implements Comparator<Assignment>{
	int number;
	int weight;
	int deadline;
	
	
	protected Assignment() {
	}
	
	protected Assignment(int number, int weight, int deadline) {
		this.number = number;
		this.weight = weight;
		this.deadline = deadline;
	}
	
	
	
	/**
	 * This method is used to sort to compare assignment objects for sorting. 
	 */
	@Override
	public int compare(Assignment a1, Assignment a2) {
		// TODO Implement this
		
		//check if two assignment have the same due date
		if(a1.deadline == a2.deadline) {
			if(a1.weight > a2.weight) {
				return -1;
			}
			else if (a1.weight < a2.weight){
				return 1;
			}
		}
		else {
			if(a1.deadline < a2.deadline) {
				return -1;
			}
			else if (a1.deadline > a2.deadline){
				return 1;
			}
		}
		return 0;
	}
}

public class HW_Sched {
	ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
	int m;
	int lastDeadline = 0;
	
	protected HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Assignment homework = new Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}
	
	
	/**
	 * 
	 * @return Array where output[i] corresponds to the assignment 
	 * that will be done at time i.
	 */
	public int[] SelectAssignments() {
		//TODO Implement this
		
		//Sort assignments
		//Order will depend on how compare function is implemented
		Collections.sort(Assignments, new Assignment());
		
		// If homeworkPlan[i] has a value -1, it indicates that the 
		// i'th timeslot in the homeworkPlan is empty
		//homeworkPlan contains the homework schedule between now and the last deadline
		int[] homeworkPlan = new int[lastDeadline];
		for (int i=0; i < homeworkPlan.length; ++i) {
			homeworkPlan[i] = -1;
		}
		
		//implement the remaining part of SelectAssignments()
		
		int startIndex = 0;
		for(int i = 0; i < Assignments.size(); i ++) {
			if(Assignments.get(i).deadline > 0 ){
				homeworkPlan[0] = Assignments.get(i).number;
				startIndex = i + 1;
				break;
			}
		}
		
		int pointer = 0;
		for (int i = startIndex ; i < Assignments.size(); i ++) {
			if (Assignments.get(i).deadline > Assignments.get(pointer).deadline) {
				pointer ++;
				if (pointer >= lastDeadline) break;
				homeworkPlan[pointer] = Assignments.get(i).number;
			}
		}
		
	
		
		return homeworkPlan;
	}
}
	



