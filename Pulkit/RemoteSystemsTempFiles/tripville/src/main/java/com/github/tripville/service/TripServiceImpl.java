package com.github.tripville.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.tripville.model.Member;
import com.github.tripville.model.Trip;
import com.github.tripville.model.TripReq;
import com.github.tripville.repository.TripRepository;
import com.github.tripville.repository.TripReqRepository;

@Service("tripService")
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private TripReqRepository tripReqRepository;
	
	@Transactional
	public Trip save(Trip tripDetails) {
		return tripRepository.save(tripDetails);
	}

	public String getUserId(String userName) {
		Member member = tripRepository.getUserInfo(userName);
		
		if(member != null){
			return String.valueOf(member.getId());
		}
			
		return null;
	}
	
	public List<Trip> searchTrip(String startpt, String destinationpt) {
		List<Trip> trip = tripRepository.searchTrip(startpt, destinationpt);
		return trip;
	}

	public TripReq save(TripReq tripreq) {
		return tripReqRepository.save(tripreq);
	}
}
