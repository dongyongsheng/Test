package xml;



import java.io.File;   
import java.io.IOException;   
  
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;   
import javax.xml.parsers.DocumentBuilderFactory;   
import javax.xml.parsers.ParserConfigurationException;   
  

import org.w3c.dom.Document;   
import org.w3c.dom.Element;   
import org.w3c.dom.NamedNodeMap;   
import org.w3c.dom.Node;   
import org.w3c.dom.NodeList;   
import org.xml.sax.SAXException;   
  
public class TestXml {   
    public static void main(String[] args) throws ParserConfigurationException,   
            SAXException, IOException {   
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory   
                .newInstance();   
        DocumentBuilder builder = builderFactory.newDocumentBuilder();   
        /*  
         * builder.parse()�����������ļ������ݽ���Ϊһ�� XML �ĵ��� ���ҷ���һ���µ� DOM Document����  
         */  
        InputStream in = ReadXmlFile.class.getClassLoader().getResourceAsStream("books.xml");
        Document document = builder.parse(in);   
        //��ӡdocument�ڵ�   
        printNode(document,0);   
           
        //��ȡ�ĵ��ĸ�Ԫ�أ���ֵ��rootElement����   
        Element rootElement = document.getDocumentElement();   
        //��ȡ��Ԫ�ص�count����   
        int countOfBooks = Integer.parseInt(rootElement.getAttribute("count"));   
        String str = rootElement.getAttribute("xmlns");
        System.out.println(str);
        System.out.println("There are "+countOfBooks+" books , they are ");   
        
        //��ȡrootElement�������ӽڵ㣨���������Խڵ㣩������һ��NodeList����   
        NodeList childNodes = rootElement.getChildNodes();   
        for(int i = 0;i < childNodes.getLength();i++){   
            //��ȡchildNodes�ĵ�i���ڵ�   
            Node childNode = childNodes.item(i);   
            //�ж�childNode�ǲ���һ��Ԫ�ؽڵ㣬�������� nodeName ֵΪbook   
            if(childNode.getNodeType() == Node.ELEMENT_NODE    
                    && childNode.getNodeName().equals("book")){   
                //���ǣ����ȡchildNode�������ӽڵ㣨���������Խڵ㣩������һ��NodeList����   
                NodeList childNodes_2 = childNode.getChildNodes();   
                for(int j = 0;j < childNodes_2.getLength();j++){   
                    //��ȡchildNodes_2�ĵ�j���ڵ�   
                    Node childNode_2 = childNodes_2.item(j);   
                    //�ж�childNode_2�ǲ���һ��Ԫ�ؽڵ㣬�������� nodeName ֵΪname   
                    if(childNode_2.getNodeType() == Node.ELEMENT_NODE    
                            && childNode_2.getNodeName().equals("name")){   
                        //���ǣ����ȡchildNode_2�������ӽڵ㣨���������Խڵ㣩������һ��NodeList����   
                        NodeList childNodes_3 = childNode_2.getChildNodes();   
                        for(int k = 0;k < childNodes_3.getLength();k++){   
                            //��ȡchildNodes_3�ĵ�k���ڵ�   
                            Node childNode_3 = childNodes_3.item(k);   
                            //�ж�childNodes_3�ǲ���һ���ı��ڵ�   
                            if(childNode_3.getNodeType() == Node.TEXT_NODE){   
                                //���ǣ����ӡ�������ı��ڵ��nodeValue   
                                System.out.println("  <<"+childNode_3.getNodeValue()+">>");   
                            }   
                        }   
                    }   
                }   
            }   
        }   
    }   
       
    /*  
     * ��ӡ DOM �ڵ�  
     * �����ʽΪ��  
     *     nodeType(nodeName,nodeValue)  
     *         "ATTRIBUTE"(attributeName=attributeValue)  
     *         ...  
     *         childNodeType[childNodeName,childNodeValue]  
     *         ...  
     */  
    public static void printNode(Node node,int count) {   
        if (node != null) {   
            String tmp = "";   
            for(int i = 0 ; i < count ; i++) tmp += "  ";   
            //��ȡnode�ڵ�Ľڵ����ͣ���ֵ��nodeType����   
            int nodeType = node.getNodeType();   
            switch (nodeType) {   
                case Node.ATTRIBUTE_NODE: tmp += "ATTRIBUTE";break;   
                case Node.CDATA_SECTION_NODE: tmp += "CDATA_SECTION";break;   
                case Node.COMMENT_NODE:tmp += "COMMENT";break;   
                case Node.DOCUMENT_FRAGMENT_NODE:tmp += "DOCUMENT_FRAGMENT";break;   
                case Node.DOCUMENT_NODE:tmp += "DOCUMENT";break;   
                case Node.DOCUMENT_TYPE_NODE:tmp += "DOCUMENT_TYPE";break;   
                case Node.ELEMENT_NODE:tmp += "ELEMENT";break;   
                case Node.ENTITY_NODE:tmp += "ENTITY";break;   
                case Node.ENTITY_REFERENCE_NODE:tmp += "ENTITY_REFERENCE";break;   
                case Node.NOTATION_NODE:tmp += "NOTATION";break;   
                case Node.PROCESSING_INSTRUCTION_NODE:tmp += "PROCESSING_INSTRUCTION";break;   
                case Node.TEXT_NODE:tmp += "TEXT";break;   
                default:return;//invalid node type.   
            }   
               
            System.out.println(tmp+" ("+node.getNodeName()+","+node.getNodeValue()+")");   
            /*  
             * node.getAttributes()��������  
             * ����node�ڵ�����Ե� NamedNodeMap��������� Element��  
             */  
            NamedNodeMap attrs = node.getAttributes();   
            if(attrs != null)   
                for(int i = 0 ; i < attrs.getLength() ; i++){   
                    printNode(attrs.item(i),count+1);   
                }   
            /*  
             * node.getChildNodes()��������  
             * ����node�ڵ�������ӽڵ�� NodeList��  
             */  
            NodeList childNodes = node.getChildNodes();   
            for(int i = 0 ; i < childNodes.getLength() ; i++){   
                printNode(childNodes.item(i),count+1);   
            }   
        }   
    }   
}  
