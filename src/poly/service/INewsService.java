package poly.service;

import java.util.ArrayList;
import java.util.List;

import poly.dto.NewsDTO;

public interface INewsService {
	public int collectNews() throws Exception;

	List<NewsDTO> getNews() throws Exception;

	ArrayList<String> getImg(List<NewsDTO> rList) throws Exception;
}
