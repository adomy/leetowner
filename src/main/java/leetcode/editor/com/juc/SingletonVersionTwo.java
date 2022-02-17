/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package leetcode.editor.com.juc;

/**
 * @author adomyzhao
 * @version $Id: SingletonVersionTwo.java, v 0.1 2022-02-16 16:27 adomyzhao Exp $$
 */
public class SingletonVersionTwo {

    private static volatile SingletonVersionTwo instance;

    public static SingletonVersionTwo getInstance() {
        if (instance == null) {
            synchronized (SingletonVersionTwo.class) {
                if (instance == null) {
                    instance = new SingletonVersionTwo();
                }
            }
        }

        return instance;
    }
}