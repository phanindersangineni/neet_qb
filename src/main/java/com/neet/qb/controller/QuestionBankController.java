package com.neet.qb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neet.qb.model.Country;
import com.neet.qb.model.Question;
import com.neet.qb.model.SubTopic;
import com.neet.qb.model.Subject;
import com.neet.qb.model.Topic;
import com.neet.qb.service.ConfigurationService;
import com.neet.qb.service.QuestionbankService;
import com.neet.qb.util.APIEndpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "questionbank", description = "QuestionBank APIs")
@RequestMapping(value = APIEndpoints.BASE_API_URL_V1)
public class QuestionBankController extends BaseController {

	
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(ConfigurationController.class);	
	
	@Autowired
	private QuestionbankService questionbankService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch subject", notes = "API to fetch subject.",
			response = Country.class)
	@RequestMapping(value = "/subject", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Subject>> getSubject(@RequestParam(required = false) String name) {
		LOG.info("Fetch subject");
		
		try {
		      List<Subject> subjects = null;
		      subjects=  new ArrayList<Subject>();

		      if (name == null)
		    	  subjects = questionbankService.getAllSubjects();
		      else
		    	  subjects=  questionbankService.findSubjectById(name);

		      if (subjects.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(subjects, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create subject.", notes = "API to create or update subject.",
			response = Country.class)
	@RequestMapping(value = "/subject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Subject>> create(@RequestBody Subject subject) {
		LOG.info("Create subject");
		
		try {
			questionbankService.createSubject(subject);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch topic", notes = "API to fetch topic.",
			response = Topic.class)
	@RequestMapping(value = "/topic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> getTopic(@RequestParam(required = false) String name) {
		LOG.info("Fetch topics");
		
		try {
		      List<Topic> topics = null;
		      topics=  new ArrayList<Topic>();

		      if (name == null)
		    	  topics = questionbankService.getAllTopics();
		      else
		    	  topics=  questionbankService.findTopicsbyId(name);

		      if (topics.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(topics, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create topic.", notes = "API to create or update topic.",
			response = Topic.class)
	@RequestMapping(value = "/topic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> create(@RequestBody Topic topic) {
		LOG.info("Create topic");
		
		try {
			questionbankService.createTopic(topic);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		    	e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch subtopic", notes = "API to fetch sub topic.",
			response = SubTopic.class)
	@RequestMapping(value = "/subtopic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubTopic>> getSubTopic(@RequestParam(required = false) String name) {
		LOG.info("Fetch subtopics");
		
		try {
		      List<SubTopic> subtopics = null;
		      subtopics=  new ArrayList<SubTopic>();

		      if (name == null)
		    	  subtopics = questionbankService.getAllsubTopics();
		      else
		    	  subtopics=  questionbankService.findSubtopicsbyTopicId(name);

		      if (subtopics.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(subtopics, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create sub topic.", notes = "API to create or update sub topic.",
			response = SubTopic.class)
	@RequestMapping(value = "/subtopic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubTopic>> create(@RequestBody SubTopic subtopic) {
		LOG.info("Create subtopic");
		
		try {
			questionbankService.createsubtopic(subtopic);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		    	e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch questions", notes = "API to fetch questions.",
			response = Question.class)
	@RequestMapping(value = "/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Question>> getQuestions(@RequestParam(required = false) String name,@RequestParam(required = false) String type) {
		LOG.info("Fetch questions");
		
		try {
		      List<Question> questions = null;
		      questions=  new ArrayList<Question>();

		      if (name == null && type ==null)
		    	  questions = questionbankService.getAllQuestions();
		      else if(name !=null && type==null) {
		    	  questions=  questionbankService.questionbyId(name);
		      }else if(name !=null && type =="CENTER") {
		    	  questions=  questionbankService.questionbyCenter(name);  
		      }else if(name !=null && type =="USER") {
		    	  questions=  questionbankService.questionbyUser(name);  
		      }else if(name !=null && type =="BRANCH") {
		    	  questions=  questionbankService.questionbybranch(name);  
		      }

		      if (questions.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(questions, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create questions.", notes = "API to create or update questions.",
			response = Question.class)
	@RequestMapping(value = "/questions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Question>> create(@RequestBody Question question) {
		LOG.info("Create question");
		
		try {
			questionbankService.createquestion(question);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		    	e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
}
