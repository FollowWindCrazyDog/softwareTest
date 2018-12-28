package com.binggo.softwaretest.core;

import com.binggo.softwaretest.bean.InputBean;
import org.junit.Test;

import java.util.Random;

public class JudgeTest {

    Judge judge = new Judge();

    @Test
    public void isTriangle() {
        InputBean inputBean = new InputBean(6, 6, 6);
        InputBean inputBean1 = new InputBean(6, 6, 13);
        System.out.println(inputBean.toString()+Judge.isTriangle(inputBean));
        System.out.println(inputBean1.toString()+Judge.isTriangle(inputBean1));
    }

    @Test
    public void getAngleType() {
    }

    @Test
    public void getEdgeType() {
    }

    @Test
    public void apply() {
        InputBean inputBean = new InputBean(6, 6, 6);
        InputBean inputBean1 = new InputBean(3, 4, 5);
        InputBean inputBean2 = new InputBean(6, 6, 5);
        InputBean inputBean3 = new InputBean(6, 6, 11);
        System.out.println(inputBean.toString() + judge.apply(inputBean));
        System.out.println(inputBean1.toString() + judge.apply(inputBean1));
        System.out.println(inputBean2.toString() + judge.apply(inputBean2));
        System.out.println(inputBean3.toString() + judge.apply(inputBean3));
    }

    @Test
    public void randApply() {
        Random random = new Random();
        for (int i = 0; i < 300; i++) {
            int bound = 5;
            try {
                InputBean inputBean = new InputBean(random.nextInt(bound) + 1, random.nextInt(bound) + 1, random.nextInt(bound) + 1);
                System.out.println(inputBean.toString() + judge.apply(inputBean));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    @Test
    public void badStrongApply() {
        //0,1,2,3,4,5,6
        double[] doubles = {0, 1, 2, 3, 4, 5, 6};
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles.length; j++) {
                for (int k = 0; k < doubles.length; k++) {
                    try {
                        InputBean inputBean = new InputBean(doubles[i], doubles[j], doubles[k]);
                        System.out.println(inputBean.toString() + judge.apply(inputBean));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        InputBean inputBean = new InputBean(6, 6, 6);
        InputBean inputBean1 = new InputBean(3, 4, 5);
        InputBean inputBean2 = new InputBean(6, 6, 5);
        InputBean inputBean3 = new InputBean(6, 6, 11);
        System.out.println(inputBean.toString() + judge.apply(inputBean));
        System.out.println(inputBean1.toString() + judge.apply(inputBean1));
        System.out.println(inputBean2.toString() + judge.apply(inputBean2));
        System.out.println(inputBean3.toString() + judge.apply(inputBean3));
    }
}