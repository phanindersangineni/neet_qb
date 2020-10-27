package com.neet.qb.service;

import java.util.List;

import com.neet.qb.model.Branch;
import com.neet.qb.model.Center;
import com.neet.qb.model.Country;
import com.neet.qb.model.Features;
import com.neet.qb.model.Lookups;
import com.neet.qb.model.Role;
import com.neet.qb.model.State;

public interface ConfigurationService {

	List<Country> getAllCountries();

	List<Country> findByCountryname(String name);

	void createCountry(Country country);

	List<State> getAllStates();

	List<State> findStatesByCountryId(String countryid);

	void createState(State state);

	List<Center> getAllCenters();

	List<Center> findCenterbyStateId(String stateid);

	void createCenter(Center center);

	void createBranch(Branch branch);

	List<Branch> getAllBranches();

	List<Branch> findbranchbyCenterId(String centerid);

	void createLookups(Lookups lookups);

	List<Lookups> findlookupCode(String code);

	List<Lookups> getLookups();

	List<Features> getFeatures();

	
	List<Features> findFeaturesbyCode(String code);

	void createFeatures(Features features);

	List<Role> getRoles();

	List<Role> findbyRoleId(String code);

	void createRoles(Role role);

	List<Role> findbyRoleCode(String code);


}
