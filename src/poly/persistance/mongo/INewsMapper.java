package poly.persistance.mongo;

import java.util.List;

import poly.dto.NewsDTO;


public interface INewsMapper {

	public boolean createCollection(String colNm) throws Exception;
	
	public int insertNews(List<NewsDTO> pList, String colNm) throws Exception;

	public List<NewsDTO> getNews(String colNm) throws Exception;
}
