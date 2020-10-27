package com.neet.qb.service;

import java.util.List;

import com.neet.qb.model.Question;
import com.neet.qb.model.SubTopic;
import com.neet.qb.model.Subject;
import com.neet.qb.model.Topic;

public interface QuestionbankService {

	List<Subject> getAllSubjects();

	List<Subject> findSubjectById(String name);

	void createSubject(Subject subject);

	void createTopic(Topic topic);

	List<Topic> getAllTopics();

	List<Topic> findTopicsbyId(String name);

	List<SubTopic> findSubtopicsbyTopicId(String name);

	void createsubtopic(SubTopic subtopic);

	List<SubTopic> getAllsubTopics();

	List<Question> getAllQuestions();

	List<Question> questionbyId(String name);

	List<Question> questionbyCenter(String name);

	List<Question> questionbyUser(String name);

	List<Question> questionbybranch(String name);

	void createquestion(Question question);

}
