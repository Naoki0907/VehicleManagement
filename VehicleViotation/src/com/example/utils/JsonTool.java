package com.example.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonTool {
	public final static String STATUS = "status";
	public final static String STATUS_SUCCESS = "success";
	public final static String STATUS_FAIL = "fail";
	public final static String MESSAGE = "message";
	public final static String ACCESS_TOKEN = "access_token";

	JSONObject jsonObject;

	public JsonTool(String response) {
		try {
			jsonObject = new JSONObject(response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public String getStatus() {
		if (jsonObject != null) {
			try {
				return jsonObject.getString(STATUS);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	public String getMessage() {
		if (jsonObject != null) {
			try {
				return jsonObject.getString(MESSAGE);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	public String saveAccess_token() {
		if (jsonObject != null) {
			try {
				if (!jsonObject.getString(ACCESS_TOKEN).isEmpty()) {
					return jsonObject.getString(ACCESS_TOKEN);
				} else {
					return null;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
