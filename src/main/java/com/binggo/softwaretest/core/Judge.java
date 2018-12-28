package com.binggo.softwaretest.core;

import com.binggo.softwaretest.bean.InputBean;
import com.binggo.softwaretest.bean.OutputBean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author <a href=mailto:libing22@meituan.com>binggo</a>
 * @since 2018/12/27
 **/
@Component
public class Judge implements Function<InputBean, OutputBean> {
    /**
     * 判断是否是三角形
     *
     * @param inputBean 三角形类型bean
     * @return {@link OutputBean.AngleType}
     */
    public static boolean isTriangle(InputBean inputBean) {
        double[] doubles = inputBeanToDoubles(inputBean);
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] >= doubles[(i + 1) % 3] + doubles[(i + 2) % 3]) {
                return false;
            }
        }
        return true;
    }

    private static double[] inputBeanToDoubles(InputBean inputBean) {
        return new double[]{inputBean.getA(), inputBean.getB(), inputBean.getC()};
    }

    /**
     * 判断三角形角度的类型
     *
     * @param inputBean 三角形类型bean
     * @return {@link OutputBean.AngleType}
     */
    public static OutputBean.AngleType getAngleType(InputBean inputBean) {
        double[] doubles = inputBeanToDoubles(inputBean);
        for (OutputBean.AngleType value : OutputBean.AngleType.values()) {
            if (angleJudge(doubles, value)) {
                return value;
            }
        }
        throw new IllegalArgumentException("There is no suitable triangle type");
    }

    /**
     * 判断三角形边的类型
     *
     * @param inputBean 三角形类型bean
     * @return {@link OutputBean.EdgeType}
     */
    public static OutputBean.EdgeType getEdgeType(InputBean inputBean) {
        double[] doubles = inputBeanToDoubles(inputBean);
        boolean equilateralFlag = true;
        for (int i = 1; i < doubles.length; i++) {
            if (doubles[i] != doubles[0]) {
                equilateralFlag = false;
                break;
            }
        }
        if (equilateralFlag) {
            return OutputBean.EdgeType.EQUILATERAL;
        }
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[(i + 1) % doubles.length] == doubles[(i + 2) % doubles.length]) {
                return OutputBean.EdgeType.ISOSCELES;
            }
        }
        return OutputBean.EdgeType.NO_ISOSCELES;
    }

    private static boolean angleJudge(double[] doubles, OutputBean.AngleType angleType) {
        for (int i = 0; i < doubles.length; i++) {
            switch (angleType) {
                case ACUTE_ANGLE:
                    return (!angleJudge(doubles, OutputBean.AngleType.OBTUSE_ANGLE)) && (!angleJudge(doubles, OutputBean.AngleType.RIGHT_ANGLE));
                case RIGHT_ANGLE:
                    if (squaresSum(doubles, i) - doubles[i] * doubles[i] == 0) {
                        return true;
                    }
                    break;
                case OBTUSE_ANGLE:
                    if (squaresSum(doubles, i) < doubles[i] * doubles[i]) {
                        return true;
                    }
                    break;
                default:
                    break;

            }
        }
        return false;
    }

    private static double squaresSum(double[] doubles, int fromIndex) {
        double ret = 0;
        for (int i = (fromIndex + 1) % doubles.length; i != fromIndex; i = (i + 1) % doubles.length) {
            ret += doubles[i] * doubles[i];
        }
        return ret;
    }

    /**
     * 判断三角形类型
     *
     * @param inputBean 三角形三边参数的 bean
     * @return 如果无法构成三角形返回 null,否则返回表示三角形类型的 OutputBean
     */
    @Override
    public OutputBean apply(InputBean inputBean) {
        if (!isTriangle(inputBean)) {
            return null;
        }
        OutputBean outputBean = new OutputBean();
        outputBean.setAngleType(getAngleType(inputBean));
        outputBean.setEdgeType(getEdgeType(inputBean));
        return outputBean;
    }


}
