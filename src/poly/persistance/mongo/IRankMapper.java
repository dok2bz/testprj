package poly.persistance.mongo;

import java.util.List;

import poly.dto.Rank2DTO;
import poly.dto.RankDTO;

public interface IRankMapper {

	/**
	 * MongoDB 컬렉션 생성하기
	 * 
	 * @param colNm 생성하는 컬렉션 이름
	 */
	public boolean createCollection(String colNm) throws Exception;

	/**
	 * MongoDB 데이터 저장하기
	 * 
	 * @param pDTO 저장될 정보
	 */
	public int insertRank(List<RankDTO> pList, String colNm) throws Exception;

	public List<RankDTO> getRank(String colNm) throws Exception;

	public int insertRank2(List<Rank2DTO> pList, String colNm) throws Exception;
	
	public List<Rank2DTO> getRank2(String colNm) throws Exception;

	public boolean createCollection2(String colNm) throws Exception;

}
