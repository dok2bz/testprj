package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import poly.service.IRankService;
import poly.service.ISchedulerService;

@Component
@Service("SchedulerService")
public class SchedulerService implements ISchedulerService {
	
	private Logger log = Logger.getLogger(getClass());
	
	@Resource(name = "RankService")
	private IRankService rankService;

	@Scheduled(cron = "0/5 * * * * ?")
	@Override	
	public void sTest() throws Exception {
//		rankService.collectRank();
		log.info(this.getClass().getName()+" 크롤링 스케쥴러 작동");
		System.out.println("###############");
		
	}
	
	

}
