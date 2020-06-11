package poly.dto;

public class RankDTO {

		private int rank; //순위
		private String name; // 클럽명
		private int playNm; // 경기 수
		private int score; // 승점
		private int win; // 승
		private int draw; // 무
		private int lose; // 패
		private int get; // 득점 
		private int miss; // 실점
		private int diff; // 득실
		private String collect_time; //수집시간
		
		
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPlayNm() {
			return playNm;
		}
		public void setPlayNm(int playNm) {
			this.playNm = playNm;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public int getWin() {
			return win;
		}
		public void setWin(int win) {
			this.win = win;
		}
		public int getDraw() {
			return draw;
		}
		public void setDraw(int draw) {
			this.draw = draw;
		}
		public int getLose() {
			return lose;
		}
		public void setLose(int lose) {
			this.lose = lose;
		}
		public int getGet() {
			return get;
		}
		public void setGet(int get) {
			this.get = get;
		}
		public int getMiss() {
			return miss;
		}
		public void setMiss(int miss) {
			this.miss = miss;
		}
		public int getDiff() {
			return diff;
		}
		public void setDiff(int diff) {
			this.diff = diff;
		}
		public String getCollect_time() {
			return collect_time;
		}
		public void setCollect_time(String collect_time) {
			this.collect_time = collect_time;
		}
		
		
		
}
