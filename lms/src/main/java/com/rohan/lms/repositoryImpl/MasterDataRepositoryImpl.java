package com.rohan.lms.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rohan.lms.join.MasterData;
import com.rohan.lms.model.AddressType;
import com.rohan.lms.model.ClientNature;
import com.rohan.lms.model.Country;
import com.rohan.lms.model.ProfessionType;
import com.rohan.lms.model.Religion;
import com.rohan.lms.repository.MasterDataRepository;
import com.rohan.lms.service.AddressTypeService;
import com.rohan.lms.service.ClientNatureService;
import com.rohan.lms.service.CountryService;
import com.rohan.lms.service.GenderService;
import com.rohan.lms.service.KycTypeService;
import com.rohan.lms.service.ProfessionTypeService;
import com.rohan.lms.service.ReligionService;

@Repository
public class MasterDataRepositoryImpl implements MasterDataRepository {

	@Autowired
	private AddressTypeService ats;
	@Autowired
	private ClientNatureService cns;
	@Autowired
	private CountryService cs;
	@Autowired
	private ReligionService rs;
	@Autowired
	private ProfessionTypeService pts;
	@Autowired
	private GenderService gs;
	@Autowired
	private KycTypeService kts;
	
	@Override
	public MasterData getAll() {
		List<AddressType> addressType = (List<AddressType>) ats.getAll();
		List<ClientNature> clientNature = (List<ClientNature>) cns.getAll();
		List<Country> country = (List<Country>) cs.getAll();
		List<Religion> religion = (List<Religion>) rs.getAll();
		List<ProfessionType> professionTypes = pts.getAll();
		return new MasterData(addressType, clientNature, country, religion,professionTypes, gs.getAll(), kts.getAll());
	}

}
