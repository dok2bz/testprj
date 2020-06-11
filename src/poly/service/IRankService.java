package poly.service;

import java.util.List;

import poly.dto.RankDTO;

public interface IRankService {

	public int collectRank() throws Exception;

	List<RankDTO> getRank() throws Exception;

	public List<String> getEvent() throws Exception;


}
