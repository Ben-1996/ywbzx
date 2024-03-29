package com.fc.v2.service.auto;

import com.fc.v2.mapper.auto.TSysDictDataMapper;
import com.fc.v2.model.auto.TSysDictData;
import com.fc.v2.model.auto.TSysDictDataExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("dict")
public class DictService {
	@Autowired
	private TSysDictDataMapper tSysDictDataMapper;

	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return 参数键值
	 */
	public List<TSysDictData> getType(String dictType) {
		TSysDictDataExample example=new TSysDictDataExample();
		if(dictType!=null) {
			example.createCriteria().andDictTypeEqualTo(dictType);
			return tSysDictDataMapper.selectByExample(example);
		}
		 return new ArrayList<TSysDictData>();
	}

	/**
	 * 根据字典类型和字典键值查询字典数据信息
	 * 
	 * @param dictType
	 *            字典类型
	 * @param dictValue
	 *            字典键值
	 * @return 字典标签
	 */
	public String getLabel(String dictType, String dictValue) {
		
		TSysDictDataExample example=new TSysDictDataExample();
		if(dictType!=null&&dictValue!=null) {
			example.createCriteria().andDictTypeEqualTo(dictType).andDictValueEqualTo(dictValue);
			List<TSysDictData> dictDatas=tSysDictDataMapper.selectByExample(example);
			if(dictDatas.size()>0) {
				return dictDatas.get(0).getDictLabel();
			}
		}
		return "";
	}
}
