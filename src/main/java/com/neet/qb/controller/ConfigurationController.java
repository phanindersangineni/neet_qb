package com.neet.qb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neet.qb.model.Branch;
import com.neet.qb.model.Center;
import com.neet.qb.model.Country;
import com.neet.qb.model.Features;
import com.neet.qb.model.Lookups;
import com.neet.qb.model.Role;
import com.neet.qb.model.State;
import com.neet.qb.model.User;
import com.neet.qb.service.ConfigurationService;
import com.neet.qb.util.APIEndpoints;
import com.neet.qb.util.AppConstants;
import com.neet.qb.util.SecurityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "configurations", description = "Master APIs")
@RequestMapping(value = APIEndpoints.BASE_API_URL_V1)
public class ConfigurationController extends BaseController {
	
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(ConfigurationController.class);	
	
	@Autowired
	private ConfigurationService configurationService;
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch country", notes = "API to fetch country.",
			response = Country.class)
	@RequestMapping(value = "/country", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> getCountries(@RequestParam(required = false) String name) {
		LOG.info("Fetch countries");
		
		try {
		      List<Country> countries = null;
		      countries=  new ArrayList<Country>();

		      if (name == null)
		      countries = configurationService.getAllCountries();
		      else
		      countries=  configurationService.findByCountryname(name);

		      if (countries.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(countries, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create country.", notes = "API to create or update country.",
			response = Country.class)
	@RequestMapping(value = "/country", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> create(@RequestBody Country country) {
		LOG.info("Create countries");
		
		try {
			configurationService.createCountry(country);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create or update state.", notes = "API to create or update state.",
			response = Country.class)
	@RequestMapping(value = "/state", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<State>> create(@RequestBody State state) {
		LOG.info("Create State");
		
		try {
			configurationService.createState(state);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch states", notes = "API to fetch state.",
			response = State.class)
	@RequestMapping(value = "/state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<State>> getStates(@RequestParam(required = false) String countryid) {
		LOG.info("Fetch state");
		
		try {
		      List<State> states = null;
		      states=  new ArrayList<State>();

		      if (countryid == null)
		    	  states = configurationService.getAllStates();
		      else
		    	  states=  configurationService.findStatesByCountryId(countryid);

		      if (states.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(states, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create or update center.", notes = "API to create or update center.",
			response = Center.class)
	@RequestMapping(value = "/center", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Center>> create(@RequestBody Center center) {
		LOG.info("Create Center");
		
		try {
			configurationService.createCenter(center);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch center", notes = "API to fetch center.",
			response = Center.class)
	@RequestMapping(value = "/center", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Center>> getCenters(@RequestParam(required = false) String stateid) {
		LOG.info("Fetch center");
		
		try {
		      List<Center> centers = null;
		      centers=  new ArrayList<Center>();

		      if (stateid == null)
		    	  centers = configurationService.getAllCenters();
		      else
		    	  centers=  configurationService.findCenterbyStateId(stateid);

		      if (centers.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(centers, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create or update branch.", notes = "API to create or update branch.",
			response = Branch.class)
	@RequestMapping(value = "/branch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Branch>> create(@RequestBody Branch branch) {
		LOG.info("Create Branch");
		
		try {
			configurationService.createBranch(branch);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch branch", notes = "API to fetch branch.",
			response = Branch.class)
	@RequestMapping(value = "/Branch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Branch>> getBranches(@RequestParam(required = false) String branchid) {
		LOG.info("Fetch branch");
		
		try {
		      List<Branch> branches = null;
		      branches=  new ArrayList<Branch>();

		      if (branchid == null)
		    	  branches = configurationService.getAllBranches();
		      else
		    	  branches=  configurationService.findbranchbyCenterId(branchid);

		      if (branches.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(branches, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create or update lookups.", notes = "API to create or update lookups.",
			response = Lookups.class)
	@RequestMapping(value = "/lookups", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lookups>> create(@RequestBody Lookups lookups) {
		LOG.info("Create Lookups");
		
		try {
			configurationService.createLookups(lookups);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		    	e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch Lookups", notes = "API to fetch lookups.",
			response = Lookups.class)
	@RequestMapping(value = "/lookups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lookups>> getLookups(@RequestParam(required = false) String code) {
		LOG.info("Fetch lookup");
		
		try {
		      List<Lookups> lookups = null;
		      lookups=  new ArrayList<Lookups>();

		      if (code == null)
		    	  lookups = configurationService.getLookups();
		      else
		    	  lookups=  configurationService.findlookupCode(code);

		      if (lookups.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(lookups, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create or update features.", notes = "API to create or update features.",
			response = Features.class)
	@RequestMapping(value = "/features", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Features>> create(@RequestBody Features features) {
		LOG.info("Create features");
		
		try {
			configurationService.createFeatures(features);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		    	e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch features", notes = "API to fetch features.",
			response = Features.class)
	@RequestMapping(value = "/features", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Features>> getFeatures(@RequestParam(required = false) String code) {
		LOG.info("Fetch features");
		
		try {
		      List<Features> features = null;
		      features=  new ArrayList<Features>();

		      if (code == null)
		    	  features = configurationService.getFeatures();
		      else
		    	  features=  configurationService.findFeaturesbyCode(code);

		      if (features.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(features, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Create or update roles.", notes = "API to create or update roles.",
			response = Role.class)
	@RequestMapping(value = "/roles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Role>> create(@RequestBody Role role) {
		LOG.info("Create roles");
		
		try {
			configurationService.createRoles(role);
		      return new ResponseEntity<>(HttpStatus.CREATED);
		    } catch (Exception e) {
		    	e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Fetch roles", notes = "API to fetch roles.",
			response = Role.class)
	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Role>> getRoles(@RequestParam(required = false) String code) {
		LOG.info("Fetch roles");
		
		try {
		      List<Role> roles = null;
		      roles=  new ArrayList<Role>();

		      if (code == null)
		    	  roles = configurationService.getRoles();
		      else 
		    	  roles=  configurationService.findbyRoleId(code);
		      if (roles.isEmpty()) {
		    	  roles=  configurationService.findbyRoleCode(code);  
		      }

		      if (roles.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(roles, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
