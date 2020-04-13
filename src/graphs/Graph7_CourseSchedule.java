package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph7_CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule(2);
        cs.addPreRequisite(1,0);
 //       cs.addPreRequisite(0,1);
        System.out.println(cs.validCourseSchedule());
    }
}

class CourseSchedule{
    int noOfCourse;
    List<Integer> adjList[];
    int[]  visited;
    int[]  arrived;
    int[]  departed;
    int time;

    CourseSchedule(){}
    CourseSchedule(int noOfCourse){
        this.noOfCourse=noOfCourse;
        adjList=new ArrayList[noOfCourse];
        for(int i=0;i<noOfCourse; i++)
            adjList[i]=new ArrayList<>();
        visited=new int[noOfCourse];
        Arrays.fill(visited,-1);

        arrived = new int[noOfCourse];
        Arrays.fill(arrived,-1);

        departed = new int[noOfCourse];
        Arrays.fill(departed, -1);

        time=-1;

    }

    void addPreRequisite(int course, int preCourse){
        adjList[preCourse].add(course);
    }

    boolean validCourseSchedule(){
        for(int i=0;i<noOfCourse;i++){
            if(visited[i]==-1)
                if(cyclePresent(i))
                    return false;
        }
        return true;
    }

    boolean cyclePresent(int courseID){
        arrived[courseID]=time++;
        visited[courseID]=1;
        for(int i:adjList[courseID]){
            if(visited[i]==-1){
                if(cyclePresent(i))
                    return true;
            }else{
                if(departed[i]==-1) //backedge, an edge to ancestor exists ---( <-( ) -> )--
                    return true;
                //if(arrived[courseID]<arrived[i] && departed[i]!=-1)
                    //forwardEdge, means a pointer to an already discovered vertice ---( -> ( ) <- )--
                    // same for treeEdge as well, but treeEdge is node that gets discovered
                //if(arrived[courseID]>arrived[i] && departed[i] != -1)
                    //crossEdge ---() () --
            }

        }
        return false;
    }
}
