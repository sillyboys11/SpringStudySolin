package org.example.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author solin
 * @Date 2021/8/14 10:44
 * @content
 */
public class BeanFactoryUtil {
    private static Map<String, Object> singletonObjects = new HashMap<>();

    static {
        //饿汉式初始化对象
        try {
            SAXReader saxReader=new SAXReader();
            Document document = saxReader.read(BeanFactoryUtil.class.getClassLoader()
                    .getResourceAsStream("beans.xml"));
            //获取全部的元素节点
            List<Element> list = document.selectNodes("//bean");
            for (Element element : list) {
                String id = element.attributeValue("id");
                String aClass = element.attributeValue("class");
                Class<?> aClass1 = Class.forName(aClass);
                singletonObjects.put(id,aClass1.newInstance());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    /**
     * 懒汉式获取bean对象
     * @param interfaceClass
     * @param <T>
     * @return
     */
    public static <T> T getInstanceBean(Class<T> interfaceClass){
        String simpleName = interfaceClass.getSimpleName();
        Object o = singletonObjects.get(simpleName);
        if (o==null){
            return newInstance(interfaceClass);
        }
        return (T) o;
    }


    public static <T> T newInstance(Class<T> interfaceClass) {
        try {
            String simpleName = interfaceClass.getSimpleName();
            System.out.println("simpleName：" + simpleName);
            //根据当前接口的名字 找到对应的实现类的全限定名
            String implClassName = findImplClassName(simpleName);
            System.out.println(implClassName);
            Class<?> aClass = Class.forName(implClassName);
            return (T) aClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //读取文件  获取类的全量名
    private static String findImplClassName(String simpleName) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(BeanFactoryUtil.class.getClassLoader().
                    getResourceAsStream("beans.xml"));
            Element node = (Element) document.selectSingleNode("//bean[@id='" + simpleName + "']");
            return node.attributeValue("class");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
