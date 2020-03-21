package com.aissms.sfir.JviolajonesFaceDetector.code;


import java.util.LinkedList;
import java.util.List;

public class Stage {
	List<Tree> trees;
float threshold;
	public Stage(float threshold) {
this.threshold=threshold;
trees=new LinkedList<Tree>();
//features = new LinkedList<Feature>();
	}
	
	public void addTree(Tree t)
	{
		trees.add(t);
	}
	
	public boolean pass(int[][] grayImage, int[][] squares, int i, int j, float scale) {
		float sum=0;
		for(Tree t : trees)
		{

			

			sum+=t.getVal(grayImage, squares,i, j, scale);
		}
		
		return sum>threshold;
	}

}
