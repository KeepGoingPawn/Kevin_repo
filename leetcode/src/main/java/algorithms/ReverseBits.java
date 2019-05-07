package algorithms;

/**
 * @Author:Kevin
 * @Description:Notice:an unsigned value
 * @Date: 2019/5/7 10:41
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        //无符号右移 左移不需要
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
    public static void main(String[] args) {
        //    1    2    3    4    5    6    7    8
        //  0001 0010 0011 0100 0101 0110 0111 1000  假设这是我们要反转的二进制数据
        //    5    6    7    8    1    2    3    4   n
        //  1111 1111 0000 0000 1111 1111 0000 0000  0xff00ff00
        //    5    6    0    0    1    2    0    0   n & 0xff00ff00
        //    0    0    5    6    0    0    1    2   >>> 8  假设此数代表的数为：a
        //  0000 0000 1111 1111 0000 0000 1111 1111  0x00ff00ff
        //    0    0    7    8    0    0    3    4   n & 0x00ff00ff
        //    7    8    0    0    3    4    0    0   << 8  假设此数代表的数为：b
        //    7    8    5    6    3    4    1    2   a | b
        //  1111 0000 1111 0000 1111 0000 1111 0000  0xf0f0f0f0
        //    7    0    5    0    3    0    1    0   n & 0x0f0f0f0f
        //    0    7    0    5    0    3    0    1   >>> 4  假设此数代表的数为：c
        //  0000 1111 0000 1111 0000 1111 0000 1111  0x0f0f0f0f
        //    0    8    0    6    0    4    0    2   n & 0xf0f0f0f0
        //    8    0    6    0    4    0    2    0   << 4  假设此数代表的数为：d
        //    8    7    6    5    4    3    2    1   c | d
        //  1000 0111 0110 0101 0100 0011 0010 0001  n
        //  1100 1100 1100 1100 1100 1100 1100 1100  0xcccccccc
        //  1000 0100 0100 0100 0100 0000 0000 0000  n & 0xcccccccc
        //  0010 0001 0001 0001 0001 0000 0000 0000  >>> 2  假设此数代表的数为：e
        //  0011 0011 0011 0011 0011 0011 0011 0011  0x33333333
        //  0000 0011 0010 0001 0000 0011 0010 0001  n & 0x33333333
        //  0000 1100 1000 0100 0000 1100 1000 0100  << 2  假设此数代表的数为：f
        //  0010 1101 1001 0101 0001 1100 1000 0100  e | f
        //  1010 1010 1010 1010 1010 1010 1010 1010  0xaaaaaaaa
        //  0010 1000 1000 0000 0000 1000 1000 0000  n & 0xaaaaaaaa
        //  0001 0100 0100 0000 0000 0100 0100 0000  >>>1  假设此数代表的数为：g
        //  0101 0101 0101 0101 0101 0101 0101 0101  0x55555555
        //  0010 1101 1001 0101 0001 1100 1000 0100
        //  0000 0101 0001 0101 0001 0100 0000 0100  n & 0x55555555
        //  0001 0100 0100 0000 0000 0100 0100 0000
        //  0000 1010 0010 1010 0010 1000 0000 1000  <<1  假设此数代表的数为：h
        //  0001 1110 0110 1010 0010 1100 0100 1000  g|h  最终结果数
        //  0001 0010 0011 0100 0101 0110 0111 1000  原数据
        //  0001 0010 0011 0100 0101 0110 0111 1000  反转的数据
        String str = "01010111111111111111111111111111";
        String res = Integer.toBinaryString((reverseBits(Integer.parseInt(str,2) )));
        System.out.println((reverseBits(Integer.parseInt(str,2) )));
        // -22
        System.out.println(str);
        // 01010111111111111111111111111111
        System.out.println(res);
        // 11111111111111111111111111101010
    }


}
