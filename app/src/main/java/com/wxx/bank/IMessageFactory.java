package com.wxx.bank;

public interface IMessageFactory<T extends IMessage>{
		
	public T createMessage();
	public T createMessage(byte[] data);
	public FieldFactory getFieldFactory();
	public void setFieldFactory(FieldFactory fieldFactory);

}
