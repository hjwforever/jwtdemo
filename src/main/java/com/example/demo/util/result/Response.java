package com.example.demo.util.result;

public class Response {
	/** 返回信息码*/
	private String code = "000000";
	/** 返回信息内容*/
	private String msg = "操作成功";

	public Response() {
	}
	
	public Response(ExceptionMsg msg){
		this.code = msg.getCode();
		this.msg = msg.getMsg();
	}
	
	public Response(String rspCode) {
		this.code = rspCode;
		this.msg = "";
	}

	public Response(String rspCode, String rspMsg) {
		this.code = rspCode;
		this.msg = rspMsg;
	}
	public String getRspCode() {
		return code;
	}
	public void setRspCode(String rspCode) {
		this.code = rspCode;
	}
	public String getRspMsg() {
		return msg;
	}
	public void setRspMsg(String rspMsg) {
		this.msg = rspMsg;
	}

	@Override
	public String toString() {
		return "Response{" +
				"rspCode='" + code + '\'' +
				", rspMsg='" + msg + '\'' +
				'}';
	}
}


/*
	public Response regist(User user) {
		try {

			User userNameUser = userRepository.findByName(user.getName());
			AdminUser admingusername = adminUserRepository.findByName(user.getName());
			if (null != userNameUser || null != admingusername) {
				return result(ExceptionMsg.UserNameUsed);
			}*/
