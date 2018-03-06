package wather;

import java.util.Iterator;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

public class testWebService2 {

	public static void main(String[] args) throws Exception {
		// axis2利用网上免费webservice服务一个城市的天气情况
		ServiceClient sender = new ServiceClient();
		Options option = new Options();
		option.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
		option.setAction("http://WebXml.com.cn/getWeather");
		EndpointReference epfs = new EndpointReference(
				"http://www.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl");
		option.setTransportInProtocol(Constants.TRANSPORT_HTTP);
		option.setTo(epfs);
	//	option.setProperty(HTTPConstants.CHUNKED, "false");
		sender.setOptions(option);
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "");
		OMElement data = fac.createOMElement("getWeather", omNs);
		OMElement theCityCode = fac.createOMElement("theCityCode ", omNs);
		OMElement theUserID = fac.createOMElement("theUserID ", omNs);
		theCityCode.setText("北京");
		theUserID.setText("");
		data.addChild(theCityCode);
		data.addChild(theUserID);

		OMElement result = sender.sendReceive(data);
		//System.out.println(result); 
		//----------------
		Iterator in = result.getChildrenWithLocalName("getWeatherResult");
		while(in.hasNext()){
			OMElement om = (OMElement)in.next();
			Iterator in2 = om.getChildElements();
			while(in2.hasNext()){
				//System.out.println(in2.next().toString());
				System.out.println(((OMElement)in2.next()).getText());
			}
		}
	}
}
