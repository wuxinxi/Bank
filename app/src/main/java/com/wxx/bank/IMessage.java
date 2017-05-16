package com.wxx.bank;

import java.util.Map;

public interface IMessage {
	byte[] packeage();
	
	void setFields(Map<Integer, Field> fields);
	Map<Integer,Field> getFields();

	byte[]createbitMap();
	
	void setIsoHeader(String isoHeader);
	String getIsoHeader();
	
	byte[] getBitmap();
	void setBitmap(byte[] bitmap);
	
	void setField(Field field);
	Field getField(int num);
	
}
