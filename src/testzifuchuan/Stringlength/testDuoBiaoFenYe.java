package testzifuchuan.Stringlength;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.jdbc.core.RowMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.jdbc.core.JdbcTemplate;


/**
 * 数据库你数据表过多时,或者数据过多时,采用分段查询
 * @author dys
 *
 */



public class testDuoBiaoFenYe {

	/**
	 * 子系统数据库
	 */
	private JdbcTemplate subJdbcTemplate;
	
	

	/**
	 * 云联智达数据库
	 */
	private JdbcTemplate simpleJdbcTemplate;
	
	
	
	public JdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}
	public void setSimpleJdbcTemplate(JdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}
	public JdbcTemplate getSubJdbcTemplate() {
		return subJdbcTemplate;
	}
	public void setSubJdbcTemplate(JdbcTemplate subJdbcTemplate) {
		this.subJdbcTemplate = subJdbcTemplate;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer[]> tablemap = new HashMap<String,Integer[]>();
		Integer sumInteger = 0;
		List<String> list1=new ArrayList<String>();
		List<Object[]> list=new ArrayList<Object[]>();
		List<String> listdata=new ArrayList<String>();
		int beginRow=30;
		int endRow=120;
		list.add(new Object[]{"table1",100});
		list.add(new Object[]{"table2",100});
		list.add(new Object[]{"table3",100});
		list.add(new Object[]{"table4",100});
		list.add(new Object[]{"table5",100});
		list.add(new Object[]{"table6",100});
		list.add(new Object[]{"table7",100});
		list.add(new Object[]{"table8",100});
		list.add(new Object[]{"table9",100});
		for (Object[] map : list) {
			String tableName = (String) map[0];
			int countVal = (Integer) map[1];
			int oldSum = sumInteger;
			sumInteger += countVal;  //累加总数
			if(beginRow >= sumInteger && endRow >= sumInteger){ 
				continue;
			}
			if(beginRow < sumInteger && beginRow >= oldSum && endRow >= oldSum ){
				if (endRow > sumInteger) 
					tablemap.put(tableName, new Integer[]{ beginRow - oldSum, countVal});
				else
					tablemap.put(tableName, new Integer[]{ beginRow - oldSum, endRow - oldSum});
			}else
			if(beginRow < sumInteger && endRow > sumInteger && beginRow-oldSum > 0  ){
				tablemap.put(tableName, new Integer[]{beginRow,countVal});
			}else
			if(endRow > sumInteger && endRow-beginRow>=countVal){
				tablemap.put(tableName, new Integer[]{1,countVal});
			}else
			if(endRow <= sumInteger && endRow-oldSum < countVal ){
				tablemap.put(tableName, new Integer[]{1,endRow - oldSum});
			}
			if(endRow <= sumInteger){ 
				break;
			}
		}
		if (tablemap.size()>0) {
		//	StringBuffer sqlSum = new StringBuffer();
			for (Entry<String, Integer[]> set : tablemap.entrySet()) {
				String tableName = set.getKey();
				Integer[] value = set.getValue();
				Integer beginNum = value[0];
				Integer endNum = value[1];			
				System.out.println("表名： "+tableName+"  开始页："+beginNum+"  结束页："+endNum);
				StringBuffer sqlCou = new StringBuffer("select * from ");
				sqlCou.append("(select  row_number() over (ORDER BY etm.WipeDate desc, em.EmpID asc) AS RowNumber, ");
				sqlCou.append(" * ");
				sqlCou.append("from " + tableName + " etm ");
				sqlCou.append("join KQ_Employee em on em.CardNo = etm.JanEmpCardNo ");
				sqlCou.append("where 1=1 ");
				sqlCou.append(") A where 1=1 ");
				sqlCou.append("and RowNumber >= ").append(beginNum).append(" ").append("and RowNumber <= " + endNum);
				System.out.println(sqlCou);	
				list1.add(sqlCou.toString());
				//sqlSum.append(sqlCou);
			}
			//System.out.println(list1.get(0));	
		}
		StringBuilder sb = new StringBuilder();
		 for(int i=0;  i<list1.size(); i++)  {
			 sb.append(list1.get(i)+" union ");
//			 String sqls =	list1.get(i);		 
//			 System.out.println("LAT...."+sqls);	
//			 	List<String>  listss=new ArrayList<String>();
//			 	listss.add(sqls);
//				listdata.addAll(listss);	
//				System.out.println("LAT...."+listdata);
		}	
		 sb.setLength(sb.length()-7);
		 System.out.println("拼接后的语句....:"+sb.toString());	 
		 
	}
	
}
