package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class SubQuestions {
	
  private String id;
  private String questiontext;
  
  private List<QuestionChoices> questionchoices = new ArrayList<>();
  private List<Questionhints> questionhints = new ArrayList<>();
  private List<QuestionAnswers> questionanswers = new ArrayList<>();
  private List<Solutions>solutions = new ArrayList<>();
  
  
  
public SubQuestions() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getQuestiontext() {
	return questiontext;
}
public void setQuestiontext(String questiontext) {
	this.questiontext = questiontext;
}


public List<QuestionChoices> getQuestionchoices() {
	return questionchoices;
}
public void setQuestionchoices(List<QuestionChoices> questionchoices) {
	this.questionchoices = questionchoices;
}
public List<Questionhints> getQuestionhints() {
	return questionhints;
}
public void setQuestionhints(List<Questionhints> questionhints) {
	this.questionhints = questionhints;
}
public List<QuestionAnswers> getQuestionanswers() {
	return questionanswers;
}
public void setQuestionanswers(List<QuestionAnswers> questionanswers) {
	this.questionanswers = questionanswers;
}
public List<Solutions> getSolutions() {
	return solutions;
}
public void setSolutions(List<Solutions> solutions) {
	this.solutions = solutions;
}
  
  

}
