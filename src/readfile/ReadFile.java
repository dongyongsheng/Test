package readfile;

import java.io.File;
/**
 * java�ݹ��ȡĿ¼�µ������ļ�
 * @author dys
 *
 */
public class ReadFile {
	
	public static void traverseFolder2(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("�ļ����ǿյ�!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("�ļ���:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("�ļ�:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("�ļ�������!");
        }
    }
	
	
	public  static  void main(String args[]){
		String path="G:/gcc/docs";
		traverseFolder2(path);
	}
	
	
}
