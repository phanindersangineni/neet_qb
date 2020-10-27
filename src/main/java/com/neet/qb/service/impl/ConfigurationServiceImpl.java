package com.neet.qb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neet.qb.model.Branch;
import com.neet.qb.model.Center;
import com.neet.qb.model.Country;
import com.neet.qb.model.Features;
import com.neet.qb.model.LookupValues;
import com.neet.qb.model.Lookups;
import com.neet.qb.model.Role;
import com.neet.qb.model.State;
import com.neet.qb.repository.BranchRepository;
import com.neet.qb.repository.CenterRepository;
import com.neet.qb.repository.CountryRepository;
import com.neet.qb.repository.FeatureRepository;
import com.neet.qb.repository.LookupsRepository;
import com.neet.qb.repository.RoleRepository;
import com.neet.qb.repository.StateRepository;
import com.neet.qb.service.ConfigurationService;

@Service
public class ConfigurationServiceImpl implements ConfigurationService{
	
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(ConfigurationServiceImpl.class);

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private CenterRepository centerRepository;
	
	@Autowired
	private LookupsRepository lookupsRepository;
	
	@Autowired
	private FeatureRepository featureRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public List<Country> findByCountryname(String name) {
		// TODO Auto-generated method stub
		return countryRepository.findByCountryname(name);
	}

	@Override
	public void createCountry(Country country) {
		countryRepository.save(country);
		
	}

	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}

	@Override
	public List<State> findStatesByCountryId(String countryid) {
		// TODO Auto-generated method stub
		return stateRepository.findByCountryId(countryid );
	}

	@Override
	public void createState(State state) {
		
	 stateRepository.save(state);	
		
	}

	@Override
	public List<Center> getAllCenters() {
		return centerRepository.findAll();
	}

	@Override
	public List<Center> findCenterbyStateId(String stateid) {
		return centerRepository.findByStateId(stateid);
	}

	@Override
	public void createCenter(Center center) {
		
		centerRepository.save(center);
		
	}

	@Override
	public void createBranch(Branch branch) {
		branchRepository.save(branch);
		
	}

	@Override
	public List<Branch> getAllBranches() {
		return branchRepository.findAll();
	}

	@Override
	public List<Branch> findbranchbyCenterId(String centerid) {
		// TODO Auto-generated method stub
		return branchRepository.findByCenterId(centerid);
	}

	@Override
	public void createLookups(Lookups lookups) {
		// TODO Auto-generated method stub
		List<LookupValues> lookupse = lookups.getLookupvalues();
		lookups.setLookupvalues(lookupse);
		//lookups.setId(ObjectId.get());
		lookupsRepository.save(lookups);
		
	}

	@Override
	public List<Lookups> findlookupCode(String code) {
		// TODO Auto-generated method stub
		return lookupsRepository.findByLookupCode(code);
	}

	@Override
	public List<Lookups> getLookups() {
		// TODO Auto-generated method stub
		return lookupsRepository.findAll();
	}

	@Override
	public List<Features> getFeatures() {
		// TODO Auto-generated method stub
		return featureRepository.findAll();
	}

	@Override
	public List<Features> findFeaturesbyCode(String code) {
		// TODO Auto-generated method stub
		return featureRepository.findById(code);
	}

	@Override
	public void createFeatures(Features features) {
		 featureRepository.save(features);
		
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public List<Role> findbyRoleId(String code) {
		// TODO Auto-generated method stub
		return roleRepository.findById(code);
	}

	@Override
	public void createRoles(Role role) {
		// TODO Auto-generated method stub
		 roleRepository.save(role);
		
	}

	@Override
	public List<Role> findbyRoleCode(String code) {
		// TODO Auto-generated method stub
		return roleRepository.findByCode(code);
	}

}
