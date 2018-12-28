package com.binggo.softwaretest.bean;

import lombok.Data;

/**
 * @author <a href=mailto:libing22@meituan.com>binggo</a>
 * @since 2018/12/27
 **/
@Data
public class OutputBean {
    private AngleType angleType;
    private EdgeType edgeType;

    @Override
    public String toString() {
        return edgeType.getAlias() + angleType.getAlias() + "三角形";
    }

    /**
     * 三角角度的类型
     */
    public enum AngleType {
        /**
         * 锐角
         */
        ACUTE_ANGLE {
            @Override
            public String getAlias() {
                return "锐角";
            }
        },
        /**
         * 直角
         */
        RIGHT_ANGLE {
            @Override
            public String getAlias() {
                return "直角";
            }
        },

        /**
         * 钝角
         */
        OBTUSE_ANGLE {
            @Override
            public String getAlias() {
                return "钝角";
            }
        };

        /**
         * 返回别名
         */
        public abstract String getAlias();
    }

    /**
     * 三角角度的类型
     */
    public enum EdgeType {
        /**
         * 等边
         */
        EQUILATERAL {
            @Override
            public String getAlias() {
                return "等边";
            }
        },
        /**
         * 等腰
         */
        ISOSCELES {
            @Override
            public String getAlias() {
                return "等腰";
            }
        },
        /**
         * 非等腰
         */
        NO_ISOSCELES {
            @Override
            public String getAlias() {
                return "非等腰";
            }
        };

        /**
         * 返回别名
         */
        public abstract String getAlias();
    }
}
