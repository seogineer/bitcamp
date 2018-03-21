// 인스턴스 메서드와 클래스 메서드의 활용 - Wrapper 클래스
package step09;

public class Exam02_1 {

    public static void main(String[] args) throws Exception {
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(200);
        Integer i3 = new Integer(300);
        
        System.out.println(i2.compareTo(i1));
        System.out.println(i2.compareTo(i3));
        
        int v1 = i2.intValue();
        System.out.println(v1);
        
        
        // 스태틱 매서드 사용
        int v2 = Integer.parseInt("1280");
        String s1 = Integer.toBinaryString(77);
        String s2 = Integer.toOctalString(77);
        String s3 = Integer.toHexString(77);
        System.out.printf("77 = %s, %s, %s\n", s1, s2, s3);
        
        Integer x1 = Integer.valueOf("44");
        Integer x2 = Integer.valueOf("44", 16);
        System.out.printf("%d, %d\n", x1, x2);
        
        float f = Float.parseFloat("3.14f");
        boolean b = Boolean.parseBoolean("true");
        System.out.printf("%f, %b\n", f, b);
    }

}