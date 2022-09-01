package com.wfeel.service;

import java.util.List;
import java.util.Map;

import com.wfeel.dao.DecorateUserDao;
import com.wfeel.dao.ViotationPunishDao;
import com.wfeel.entity.DecorateUser;
import com.wfeel.entity.DecorateViotation;
import com.wfeel.idao.IDecorateUserDao;
import com.wfeel.iservice.IDecorateUserService;

public class ViotationPunishService  {

	private ViotationPunishDao dao = new ViotationPunishDao();

	public List<DecorateViotation> findDecorateViotation(String car_no) {
		// TODO Auto-generated method stub
		return dao.getDecorateViotation(car_no);
	}

	public boolean changePunish(String punish_id) {
		// TODO Auto-generated method stub
		return dao.changeDecorateViotation(punish_id);
	}

	
}
