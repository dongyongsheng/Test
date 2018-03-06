package xml;


import javax.xml.parsers.*;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class DomXml {
     public void parsersXml() {
         //ʵ����һ���ĵ�����������
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         try {
             //ͨ���ĵ�������������ȡһ���ĵ�������
             DocumentBuilder db = dbf.newDocumentBuilder();
             //ͨ���ĵ�ͨ���ĵ�����������һ���ĵ�ʵ��
             InputStream in = ReadXmlFile.class.getClassLoader().getResourceAsStream("persons.xml");
             Document doc = db.parse(in);
             //��ȡ��������Ϊ ��person�� �Ľڵ�
             NodeList nl1 = doc.getElementsByTagName("person");
             int size1 = nl1.getLength();
             System.out.println("�����ƵĽڵ㳤��Ϊ��" + size1);
             for (int i = 0; i < size1; i++) {
                 Node n = nl1.item(i);
                 //��ȡ n �ڵ������е��ӽڵ㡣�˴�ֵ��ע�⣬��DOM����ʱ�Ὣ���лس�����Ϊ n �ڵ���ӽڵ㡣
                 NodeList nl2 = n.getChildNodes();
                 //��Ϊ�����ԭ���ڴ����е�һ�� n �ڵ��� 2 ���ӽڵ㣬���ڶ��� n �ڵ����� 5 ���ӽڵ㣨��Ϊ����3���س�����
                 int size2 = nl2.getLength();
                 System.out.println("N�ڵ�ĵ�һ���ӽڵ�ĳ���Ϊ��" + size2);
                 for (int j = 0; j < size2; j++) {
                     Node n2 = nl2.item(j);
                     //������Ϊ�����ԭ�򣬹ʴ�Ҫ���жϵ� n2 �ڵ����ӽڵ��ʱ�������
                     if (n2.hasChildNodes()) {
                         System.out.println(n2.getNodeName() + " = " +
                                            n2.getFirstChild().getNodeValue());
                     }
                 }
             }
         } catch (ParserConfigurationException ex) {
             ex.printStackTrace();
         } catch (IOException ex) {
             ex.printStackTrace();
         } catch (SAXException ex) {
             ex.printStackTrace();
         }
     }
 
     public static void main(String[] args) {
         DomXml domxml = new DomXml();
         domxml.parsersXml();
     }
 }