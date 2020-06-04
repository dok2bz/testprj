package poly.service;

import java.util.List;

import poly.dto.NewsDTO;

public interface INewsService {
	public int collectNews() throws Exception;

	List<NewsDTO> getNews() throws Exception;
}
