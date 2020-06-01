package poly.service;

import java.util.List;

import poly.dto.Rank2DTO;
import poly.dto.RankDTO;

public interface IRankService {

	public int collectRank() throws Exception;

	List<RankDTO> getRank() throws Exception;

	public int collectRank2() throws Exception;

	List<Rank2DTO> getRank2() throws Exception;
}
