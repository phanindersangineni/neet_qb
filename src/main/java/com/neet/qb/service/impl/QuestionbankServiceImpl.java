package com.neet.qb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neet.qb.model.Question;
import com.neet.qb.model.SubTopic;
import com.neet.qb.model.Subject;
import com.neet.qb.model.Topic;
import com.neet.qb.repository.CountryRepository;
import com.neet.qb.repository.QuestionRepository;
import com.neet.qb.repository.SubjectRepository;
import com.neet.qb.repository.SubtopicRepository;
import com.neet.qb.repository.TopicRepository;
import com.neet.qb.service.QuestionbankService;

@Service
public class QuestionbankServiceImpl implements QuestionbankService {
	
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(QuestionbankServiceImpl.class);

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private SubtopicRepository subtopicRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	@Override
	public List<Subject> findSubjectById(String name) {
		// TODO Auto-generated method stub
		return subjectRepository.findById(name);
	}

	@Override
	public void createSubject(Subject subject) {
		subjectRepository.save(subject);
		
	}

	@Override
	public void createTopic(Topic topic) {
	   topicRepository.save(topic);
		
	}

	@Override
	public List<Topic> getAllTopics() {
		
		return topicRepository.findAll();
	}

	@Override
	public List<Topic> findTopicsbyId(String name) {
		// TODO Auto-generated method stub
		return topicRepository.findById(name);
	}

	@Override
	public List<SubTopic> findSubtopicsbyTopicId(String name) {
		// TODO Auto-generated method stub
		return subtopicRepository.findByTopicId(name);
	}

	@Override
	public void createsubtopic(SubTopic subtopic) {
		// TODO Auto-generated method stub
		subtopicRepository.save(subtopic);
	}

	@Override
	public List<SubTopic> getAllsubTopics() {
		// TODO Auto-generated method stub
		return subtopicRepository.findAll();
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public List<Question> questionbyId(String name) {
		// TODO Auto-generated method stub
		return questionRepository.findById(name);
	}

	@Override
	public List<Question> questionbyCenter(String name) {
		// TODO Auto-generated method stub
		return questionRepository.findByCenterid(name);
	}

	@Override
	public List<Question> questionbyUser(String name) {
		// TODO Auto-generated method stub
		return questionRepository.findByUserid(name);
	}

	@Override
	public List<Question> questionbybranch(String name) {
		// TODO Auto-generated method stub
		return questionRepository.findByBranchid(name);
	}

	@Override
	public void createquestion(Question question) {
		// TODO Auto-generated method stub
		questionRepository.save(question);
	}

}
