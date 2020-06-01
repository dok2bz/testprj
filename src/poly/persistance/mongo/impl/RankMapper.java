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

import poly.dto.Rank2DTO;
import poly.dto.RankDTO;
import poly.persistance.mongo.IRankMapper;
import poly.util.CmmUtil;

@Component("RankMapper")
public class RankMapper implements IRankMapper {

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
	public boolean createCollection2(String colNm) throws Exception {

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
	public int insertRank(List<RankDTO> pList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertRank Start!");

		int res = 0;

		if (pList == null) {
			pList = new ArrayList<RankDTO>();
		}

		Iterator<RankDTO> it = pList.iterator();

		while (it.hasNext()) {
			RankDTO pDTO = (RankDTO) it.next();

			if (pDTO == null) {
				pDTO = new RankDTO();
			}

			mongodb.insert(pDTO, colNm);

		}

		res = 1;

		log.info(this.getClass().getName() + ".insertRank End!");

		return res;

	}


	@Override
	public List<RankDTO> getRank(String colNm) {
		DBCollection rCol = mongodb.getCollection(colNm);
		Iterator<DBObject> cursor = rCol.find();
		List<RankDTO> rList = new ArrayList<RankDTO>();
		RankDTO rDTO = null;
		while(cursor.hasNext()) {
			rDTO = new RankDTO();
			final DBObject current = cursor.next();
			
			String collect_time = CmmUtil.nvl((String) current.get("collect_time"));
			String Stringrank = CmmUtil.nvl(String.valueOf(current.get("rank")));
			int rank = Integer.parseInt(Stringrank);
			String name = CmmUtil.nvl((String) current.get("name"));
			String StringplayNm = CmmUtil.nvl(String.valueOf(current.get("playNm")));
			int playNm = Integer.parseInt(StringplayNm);
			String Stringscore = CmmUtil.nvl(String.valueOf(current.get("score")));
			int score = Integer.parseInt(Stringscore);
			String Stringwin = CmmUtil.nvl(String.valueOf(current.get("win")));
			int win = Integer.parseInt(Stringwin);
			String Stringdraw = CmmUtil.nvl(String.valueOf(current.get("draw")));
			int draw = Integer.parseInt(Stringdraw);
			String Stringlose= CmmUtil.nvl(String.valueOf(current.get("lose")));
			int lose = Integer.parseInt(Stringlose);
			String Stringget = CmmUtil.nvl(String.valueOf(current.get("get")));
			int get = Integer.parseInt(Stringget);
			String Stringmiss= CmmUtil.nvl(String.valueOf(current.get("miss")));
			int miss = Integer.parseInt(Stringmiss);
			String Stringdiff= CmmUtil.nvl(String.valueOf(current.get("diff")));
			int diff = Integer.parseInt(Stringdiff);

			rDTO.setCollect_time(collect_time);
			rDTO.setRank(rank);
			rDTO.setName(name);
			rDTO.setDiff(diff);
			rDTO.setDraw(draw);
			rDTO.setGet(get);
			rDTO.setLose(lose);
			rDTO.setMiss(miss);
			rDTO.setPlayNm(playNm);
			rDTO.setScore(score);
			rDTO.setWin(win);
			
			rList.add(rDTO);
			
			rDTO =null;
			
			
			
		}
		return rList;
	}

	@Override
	public int insertRank2(List<Rank2DTO> pList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertRank Start!");

		int res = 0;

		if (pList == null) {
			pList = new ArrayList<Rank2DTO>();
		}

		Iterator<Rank2DTO> it = pList.iterator();

		while (it.hasNext()) {
			Rank2DTO pDTO = (Rank2DTO) it.next();

			if (pDTO == null) {
				pDTO = new Rank2DTO();
			}

			mongodb.insert(pDTO, colNm);

		}

		res = 1;

		log.info(this.getClass().getName() + ".insertRank End!");

		return res;

	}

	@Override
	public List<Rank2DTO> getRank2(String colNm) {
		DBCollection rCol = mongodb.getCollection(colNm);
		Iterator<DBObject> cursor = rCol.find();
		List<Rank2DTO> rList = new ArrayList<Rank2DTO>();
		Rank2DTO rDTO = null;
		while(cursor.hasNext()) {
			rDTO = new Rank2DTO();
			final DBObject current = cursor.next();
			
			String collect_time = CmmUtil.nvl((String) current.get("collect_time"));
			String Stringrank = CmmUtil.nvl(String.valueOf(current.get("rank")));
			int rank = Integer.parseInt(Stringrank);
			String name = CmmUtil.nvl((String) current.get("name"));
			String StringplayNm = CmmUtil.nvl(String.valueOf(current.get("playNm")));
			int playNm = Integer.parseInt(StringplayNm);
			String Stringscore = CmmUtil.nvl(String.valueOf(current.get("score")));
			int score = Integer.parseInt(Stringscore);
			String Stringwin = CmmUtil.nvl(String.valueOf(current.get("win")));
			int win = Integer.parseInt(Stringwin);
			String Stringdraw = CmmUtil.nvl(String.valueOf(current.get("draw")));
			int draw = Integer.parseInt(Stringdraw);
			String Stringlose= CmmUtil.nvl(String.valueOf(current.get("lose")));
			int lose = Integer.parseInt(Stringlose);
			String Stringget = CmmUtil.nvl(String.valueOf(current.get("get")));
			int get = Integer.parseInt(Stringget);
			String Stringmiss= CmmUtil.nvl(String.valueOf(current.get("miss")));
			int miss = Integer.parseInt(Stringmiss);
			String Stringdiff= CmmUtil.nvl(String.valueOf(current.get("diff")));
			int diff = Integer.parseInt(Stringdiff);

			rDTO.setCollect_time(collect_time);
			rDTO.setRank(rank);
			rDTO.setName(name);
			rDTO.setDiff(diff);
			rDTO.setDraw(draw);
			rDTO.setGet(get);
			rDTO.setLose(lose);
			rDTO.setMiss(miss);
			rDTO.setPlayNm(playNm);
			rDTO.setScore(score);
			rDTO.setWin(win);
			
			rList.add(rDTO);
			
			rDTO =null;
			
			
			
		}
		return rList;
	}

}

