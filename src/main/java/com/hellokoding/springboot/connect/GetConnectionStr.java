package com.hellokoding.springboot.connect;

public class GetConnectionStr {
	public String name="root";
	public String pass="0610";
	String sql = String.format(
		        "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
        + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
        "icsse",
        "group14week7:asia-northeast1:content");
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public String getSql() {
		return sql;
	}
}
