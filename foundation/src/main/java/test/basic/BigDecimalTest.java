package test.basic;

import java.math.BigDecimal;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/17 9:25
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1.0);

        BigDecimal b = new BigDecimal("1.0");
        //  A:推荐a的赋值方式
        //  B:推荐b的赋值方式
        //  C:两者均不推荐
    }
}
