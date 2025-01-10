package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ScreenRepository;
import com.app.dto.NumberOfScreensDto;

@Service
@Transactional
public class ScreenServiceImpl implements IScreenService {
	@Autowired
	private ScreenRepository screenRepo;
	
	@Override
	public int updateScreenStatus(String status, int id) {
		return screenRepo.updateScreenStatus(status, id);
	}

	@Override
	public NumberOfScreensDto getScreenNumbersByShowId(int showId) {
		return screenRepo.getScreenNumbersByShowId(showId);
		 
	}
//
//	@Override
//	public List<ScreenDto> getAllScreens(int ownerId) {
//		// TODO Auto-generated method stub
//		return screenRepo.getAllScreenOfOwner(ownerId);
//	}

}
