/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package leetcode.editor.com.juc;

/**
 * @author adomyzhao
 * @version $Id: SingletonVersionOne.java, v 0.1 2022-02-16 16:26 adomyzhao Exp $$
 */
public class SingletonVersionOne {

    private static class SingletonVersionOneHolder {
        private static SingletonVersionOne singletonVersionOne = new SingletonVersionOne();

        /**
         * Getter method for property singletonVersionOne.
         *
         * @return property value of singletonVersionOne
         */
        public static SingletonVersionOne getSingletonVersionOne() {
            return singletonVersionOne;
        }
    }

    public static SingletonVersionOne getInstance() {
        return SingletonVersionOneHolder.getSingletonVersionOne();
    }


}