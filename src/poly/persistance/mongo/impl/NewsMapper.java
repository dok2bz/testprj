package poly.persistance.mongo.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import poly.dto.NewsDTO;
import poly.persistance.mongo.INewsMapper;
import poly.util.CmmUtil;

@Component("NewsMapper")
public class NewsMapper implements INewsMapper {

	@Autowired
	private MongoTemplate mongodb;

	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean createCollection(String colNm) throws Exception {

		log.info(this.getClass().getName() + ".createCollection Start!");

		boolean res = false;

		// 기존에 등록된 컬렉션 이름이 존재하는지 체크하고, 존재하면 기존 컬렉션 삭제함
		if (mongodb.collectionExists(colNm)) {
			mongodb.dropCollection(colNm); // 기존 컬렉션 삭제

		}

		// 컬렉션 생성 및 인덱스 생성, MongoDB에서 데이터 가져오는 방식에 맞게 인덱스는 반드시 생성하자!
		// 데이터 양이 많지 않으면 문제되지 않으나, 최소 10만건 이상 데이터 저장시 속도가 약 10배 이상 발생함
		mongodb.createCollection(colNm).createIndex(new BasicDBObject("collect_time", 1).append("rank", 1), "rankIdx");

		res = true;

		log.info(this.getClass().getName() + ".createCollection End!");

		return res;
	}

	@Override
	public int insertNews(List<NewsDTO> pList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertNews Start!");

		int res = 0;

		if (pList == null) {
			pList = new ArrayList<NewsDTO>();
		}

		Iterator<NewsDTO> it = pList.iterator();

		while (it.hasNext()) {
			NewsDTO pDTO = (NewsDTO) it.next();

			if (pDTO == null) {
				pDTO = new NewsDTO();
			}

			mongodb.insert(pDTO, colNm);

		}

		res = 1;

		log.info(this.getClass().getName() + ".insertNews End!");

		return res;

	}
	/*
	 * @Override public List<RankDTO> getRank(String colNm) throws Exception{
	 * 
	 * log.info(this.getClass().getName()+".getRank Start!");
	 * 
	 * DBCollection rCol = mongodb.getCollection(colNm);
	 * 
	 * Iterator<DBObject> cursor = rCol.find();
	 * 
	 * List<RankDTO> rList = new ArrayList<RankDTO>();
	 * 
	 * Rank
	 * 
	 * }
	 */

	@Override
	public List<NewsDTO> getNews(String colNm) throws Exception {

		DBCollection rCol = mongodb.getCollection(colNm);
		Iterator<DBObject> cursor = rCol.find();
		List<NewsDTO> nList = new ArrayList<NewsDTO>();
		NewsDTO nDTO = null;
		while(cursor.hasNext()) {
			nDTO = new NewsDTO();
			final DBObject current = cursor.next();
			
			String collect_time = CmmUtil.nvl((String) current.get("collect_time"));
			String title = CmmUtil.nvl((String) current.get("title"));
			String Stringseq = CmmUtil.nvl(String.valueOf(current.get("seq")));
			int seq = Integer.parseInt(Stringseq);
			nDTO.setCollect_time(collect_time);
			nDTO.setTitle(title);
			nDTO.setSeq(seq);
			
			nList.add(nDTO);
			
			nDTO= null;
		}
		return nList;
	}
	


}

