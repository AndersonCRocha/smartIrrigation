package br.com.smartIrrigation.util;

import java.util.List;

public interface GenericService<BEAN, ID> {
	
	public BEAN saveOrUpdate(BEAN bean);
	public List<BEAN> findAll();
	public BEAN findById(ID id);
	public void delete(BEAN bean);
	public void deleteById(ID id);

}
