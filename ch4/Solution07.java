package Ch4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import Ch4.Solution08.TreeNode;

/*You are given a list of projects and a list of dependencies 
 * (which is a list of pairs of projects, where the first project is dependent on the second project.)
 * All of a project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built. 
 * If there is no valid build order, return an error.*/

public class Solution07 {
	
	
	
public static Stack<Project> findBuildOrder(String[]projects, String[][]dependencies){
	Graph graph=buildGraph(projects, dependencies); //Construct a graph by the condition the question gives.
	return orderProjects(graph.getNodes());
}
public static Stack<Project> orderProjects(ArrayList<Project> projects){
	Stack<Project> stack=new Stack<Project>();
	for(Project project : projects){
		if(project.getState()==Project.State.BLANK){
			if(!doDFS(project,stack)){
				return null;
			}
		}
	}
	return stack;
}
public static boolean doDFS(Project project, Stack<Project> stack){
	if(project.getState()==Project.State.PARTIAL){
		return false; //Cycle
	}
	if(project.getState()==Project.State.BLANK){
		project.setState(Project.State.PARTIAL);
		ArrayList<Project> children=project.getChildren();
		for(Project child:children){
			if(!doDFS(child, stack)){
				return false;
			}
		}
		project.setState(Project.State.COMPLETE);
		stack.push(project);
	}
	return true;
}
public static Graph buildGraph(String[]projects, String[][]dependencies){
	Graph graph=new Graph();
	for(String project: projects){
		graph.getOrCreateNode(project);
	}
	for(String[]dependency: dependencies){
		String first=dependency[0];
		String second=dependency[1];
		graph.addEdge(first, second);
	}
	return graph;
}
public static class Project{
	private ArrayList<Project> children=new ArrayList<Project>();
	private HashMap<String, Project> map=new HashMap<String, Project>();
	private String name;
	private int dependencies=0;
	public Project(String n){
		name=n;
	}
	public void addNeighbor(Project node){
		if(!map.containsKey(node.getName())){
			children.add(node);
			node.incrementDependencies();
		}
	}
	public void incrementDependencies(){
		dependencies++;
	}
	public void decrementDependencies(){
		dependencies--;
	}
	public String getName(){
		return name;
	}
	public ArrayList<Project> getChildren(){
		return children;
	}
	public int getNumberDependencies(){
		return dependencies;
	}
	public enum State {COMPLETE, PARTIAL, BLANK}; 
//complete means visited; partial means visiting; blank means not yet visited
	private State state=State.BLANK;
	public State getState(){
		return state;
	}
	public void setState(State st){
		state=st;
	}
}

public static class Graph{
 private ArrayList<Project> nodes =new ArrayList<Project>();
 private HashMap<String, Project> map=new HashMap<String, Project>();
 
 public Project getOrCreateNode(String name){
	 if(!map.containsKey(name)){
		 Project node=new Project(name);
		 nodes.add(node);
		 map.put(name, node);
	 }
	 return map.get(name);
 }
 public void addEdge(String startName, String endName){
	 Project start=getOrCreateNode(startName);
	 Project end=getOrCreateNode(endName);
	 start.addNeighbor(end);
 }
 public ArrayList<Project> getNodes(){
	 return nodes;
 }
}

public static void main(String[] args) {
	 String[]projects = {"a","b","c","d","e","f"};
	 String[][]dependencies = {{"d","a"},{"b","f"},{"d","b"},{"a","f"},{"c","d"}};
	 Stack<Project> order = Solution07.findBuildOrder(projects, dependencies);
	 for(Project project:order){
		 System.out.print(project.name);
	 }
}

}
