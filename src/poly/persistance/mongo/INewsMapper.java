package poly.persistance.mongo;

import java.util.List;

import poly.dto.NewsAllDTO;
import poly.dto.NewsDTO;


public interface INewsMapper {

	public boolean createCollection(String colNm) throws Exception;
	
	public int insertNews(List<NewsDTO> pList, String colNm) throws Exception;

	public List<NewsDTO> getNews(String colNm) throws Exception;

	List<NewsAllDTO> getNewsAll(String colNm2) throws Exception;

	int insertNewsAll(List<NewsAllDTO> naList, String colNm2) throws Exception;

	public List<NewsAllDTO> selectNewsAll(String keyword) throws Exception;
}
