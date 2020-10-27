package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection = "question")
public class Question {
	
	@Id
	@DefaultField
	private String id;
	
     private String questiontype;
     private String difficultlevel;
     private String objective;
     private String relevance;
     private String taxanomy;
     private String conceptlevel;
     private String syllabus;
     private String referencebook;
     private String elaboration;
     private String previousquestion;
     private String referenceid;
     private String referenceIndex;
     private String paragraphtext;
     
     private List<SubQuestions> subquestions = new ArrayList<>();
     
     
     private String correctanswers;
     private String userid;
     private String centerid;
     private String branchid;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getQuestiontype() {
		return questiontype;
	}


	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}


	public String getDifficultlevel() {
		return difficultlevel;
	}


	public void setDifficultlevel(String difficultlevel) {
		this.difficultlevel = difficultlevel;
	}


	public String getObjective() {
		return objective;
	}


	public void setObjective(String objective) {
		this.objective = objective;
	}


	public String getRelevance() {
		return relevance;
	}


	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}


	public String getTaxanomy() {
		return taxanomy;
	}


	public void setTaxanomy(String taxanomy) {
		this.taxanomy = taxanomy;
	}


	public String getConceptlevel() {
		return conceptlevel;
	}


	public void setConceptlevel(String conceptlevel) {
		this.conceptlevel = conceptlevel;
	}


	public String getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}


	public String getReferencebook() {
		return referencebook;
	}


	public void setReferencebook(String referencebook) {
		this.referencebook = referencebook;
	}


	public String getElaboration() {
		return elaboration;
	}


	public void setElaboration(String elaboration) {
		this.elaboration = elaboration;
	}


	public String getPreviousquestion() {
		return previousquestion;
	}


	public void setPreviousquestion(String previousquestion) {
		this.previousquestion = previousquestion;
	}


	public String getReferenceid() {
		return referenceid;
	}


	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}


	public String getReferenceIndex() {
		return referenceIndex;
	}


	public void setReferenceIndex(String referenceIndex) {
		this.referenceIndex = referenceIndex;
	}


	public String getParagraphtext() {
		return paragraphtext;
	}


	public void setParagraphtext(String paragraphtext) {
		this.paragraphtext = paragraphtext;
	}


	public List<SubQuestions> getSubquestions() {
		return subquestions;
	}


	public void setSubquestions(List<SubQuestions> subquestions) {
		this.subquestions = subquestions;
	}


	public String getCorrectanswers() {
		return correctanswers;
	}


	public void setCorrectanswers(String correctanswers) {
		this.correctanswers = correctanswers;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getCenterid() {
		return centerid;
	}


	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}


	public String getBranchid() {
		return branchid;
	}


	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
     
     
     
     

}
