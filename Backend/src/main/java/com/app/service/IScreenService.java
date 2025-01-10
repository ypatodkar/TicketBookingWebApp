package com.app.service;

import com.app.dto.NumberOfScreensDto;

public interface IScreenService {
			int updateScreenStatus(String status, int id);
			
			NumberOfScreensDto getScreenNumbersByShowId(int showId);
//			List<ScreenDto> getAllScreens(int ownerId);
}
