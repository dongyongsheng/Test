package FatherAndSon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �����ӽ���븸�ڵ�
 * @author dys
 *
 */
public class fatherandson {
	public static void main(String[] args) {
		//[{parentDeviceID=111, DeviceID=10000}, {parentDeviceID=111, DeviceID=10001}, {parentDeviceID=111, DeviceID=10002}, 
//		{parentDeviceID=111, DeviceID=10003}, {parentDeviceID=111, DeviceID=10004}, {parentDeviceID=111, DeviceID=10005}, 
//		{parentDeviceID=111, DeviceID=10006}, {parentDeviceID=222, DeviceID=10007}, {parentDeviceID=222, DeviceID=10008}, 
//		{parentDeviceID=222, DeviceID=10009}, {parentDeviceID=222, DeviceID=10010}, {parentDeviceID=222, DeviceID=10011}, 
//		{parentDeviceID=222, DeviceID=10012}, {parentDeviceID=222, DeviceID=10013}, {parentDeviceID=333, DeviceID=10014}, 
//		{parentDeviceID=333, DeviceID=10015}, {parentDeviceID=333, DeviceID=10016}, {parentDeviceID=333, DeviceID=10017}, 
//		{parentDeviceID=333, DeviceID=10018}, {parentDeviceID=333, DeviceID=10019}
		
		
//		String sql = "  select distinct parentDeviceID,DeviceID from Device where gcID='SHQPWYS' and deviceTypeID IN (64,65,66)   ";
//		List<Map<String, Object>> msgListSon = simpleJdbcTemplate.queryForList(sql);
//		final Map<Integer, List<Integer>> mapNode = new HashMap<Integer, List<Integer>>();
//		for (Map<String, Object> mapson : msgListSon) {
//			Integer parentDeviceID = (Integer) mapson.get("parentDeviceID");// ���ڵ�ID
//			Integer DeviceID = (Integer) mapson.get("DeviceID");// �ӽڵ�ID
//
//			if (null == parentDeviceID) { // parentDeviceID = null ���ڵ�
//				if (mapNode.containsKey(DeviceID)) {
//					mapNode.put(DeviceID, new ArrayList<Integer>());
//				} else {
//					// �����������Ѵ���
//				}
//			} else { // �ӻ�·
//				List<Integer> parentlist = new ArrayList<Integer>();
//				parentlist = mapNode.get(parentDeviceID);
//
//				if (null == parentlist) { // �����в����ڸ��ڵ㣬��newһ��
//					List<Integer> sonlist = new ArrayList<Integer>();
//					sonlist.add(DeviceID);
//					mapNode.put(parentDeviceID, sonlist);
//				} else {
//					parentlist.add(DeviceID);
//					mapNode.put(parentDeviceID, parentlist);
//				}
//			}
//
//		}
	}
}
