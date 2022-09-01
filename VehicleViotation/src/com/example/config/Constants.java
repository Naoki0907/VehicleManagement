package com.example.config;

public class Constants {

	// 鍖呭悕
	public static final String PACKAGENAME = "com.wfeel.decorate";

	// 鍩熷悕鎴栬�呮槸IP(鏃�)

	// public static String AppliactionServerDomain =
	// "http://120.24.183.74/index.php/";

	public static String AppliactionServerIP_Share = "http://www.baidu.com";
	// 鍩熷悕鎴栬�呮槸IP
	public static String AppliactionServerIP = "http://192.168.1.106:8080";
	// public static String AppliactionServerDomain =
	// "http://www.theballer.cn/index.php/";
	public static String AppliactionServerDomain = AppliactionServerIP + "/VehicleViotationServer/";
	// public static String AppliactionServerDomain =
	// "http://210.121.164.111/decorate/";
//	public static String AppliactionServerDomain = "http://192.168.0.101:8080/decorate/";
	public static String SignKey = "dfeb3d35bc3543rdc234";

	public static class Config {
		// 鏄惁澶勪簬寮�鍙戞ā寮�
		public static final boolean DEVELOPER_MODE = true;

		// 鎺ュ彈楠岃瘉鐮佹椂闂翠负120s
		public static int AUTN_CODE_TIME = 120;

		// 鐓х墖缂╁皬姣斾緥
		public static final int SCALE = 5;

		// 鎬诲叡鏈夊灏戦〉
		public static final int NUM_PAGE = 6;

		// 姣忛〉20涓〃鎯�,杩樻湁鏈�鍚庝竴涓垹闄utton
		public static int NUM = 20;

		public static int PAGE_NUM = 20;

		// 鑱婂ぉ姣忔鍒锋柊绾綍鏉℃暟
		public static int LOAD_MESSAGE_COUNT = 20;
	}

	public static class AUTH {
		// -1:鍐荤粨 0娉ㄥ唽 1璁よ瘉 2 鎻愪氦鏈鏍�
		// 鍐荤粨
		public static String AUTH_FROZEN = "-1";
		// 娉ㄥ唽
		public static String AUTH_REG = "0";
		// 璁よ瘉
		public static String AUTH_NEED_SUBMIT = "1";
		// 鎻愪氦鏈鏍�
		public static String AUTH_NEED_CONFIRM = "2";
	}

	public static class WeChatConfig {
		public final static String APP_ID = "wx4a480f3f5a6c4c6c";
		public final static String APP_SECRET = "6809df36797cf90e310833560d3d2c62";
	}

	public static class WeiboConfig {
		public final static String API_KEY = "4169059323";
		public final static String SECRIT_KEY = "9825238066521372a2f776fa08b651e2";

		// public final static String API_KEY = "1143456865";
		// public final static String SECRIT_KEY =
		// "b28fbfc22b29b0e53424b8c2fb283c2e";
	}

	public static class QQConfig {
		public final static String API_KEY = "1104862406";
		public final static String SECRIT_KEY = "VHSnIwPNZJcnMqj7";
		// public final static String API_KEY = "1104913890";
		// public final static String SECRIT_KEY = "9qIl3e9wgCQSgNbL";
	}

	public static class Extra {
		public static final String IMAGES = "com.nostra13.example.universalimageloader.IMAGES";
		public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
	}

}
