package com.binggo.softwaretest.bean;

import lombok.Getter;

/**
 * @author <a href=mailto:libing22@meituan.com>binggo</a>
 * @since 2018/12/27
 **/
@Getter
public class InputBean {
    double a;
    double b;
    double c;

    public InputBean(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException(" {"+a+","+b+","+c+"}\t中某一条边长度小于等于0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return " {" +
                a +
                "," + b +
                "," + c +
                '}' + "\t";
    }
}
