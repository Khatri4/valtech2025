package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.vos.WatchVO;

public interface WatchService {

	WatchVO createWatch(WatchVO watch);

	WatchVO updateWatch(long id, WatchVO watch);

	WatchVO getWatch(long id);

	List<WatchVO> getWatches();

	List<WatchVO> getWatchesByBrand(String brand);

}