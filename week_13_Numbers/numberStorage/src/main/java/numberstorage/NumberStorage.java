package numberstorage;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A float is represented in 32 bits, with 1 sign bit, 8 bits of exponent, and
 * 23 bits of the mantissa, a double is represented in 64 bits, with 1 sign bit,
 * 11 bits of exponent, and 52 bits of mantissa. A float gives you approx. 6-7
 * decimal digits precision while a double gives you approx. 15-16. Also, the
 * range of numbers is larger for a double.
 * 
 * Lesson example showing quasi weird number calculations and explaining storage
 * of numbers in Java.
 *
 * @author Richard van den Ham
 *
 */
public class NumberStorage {

    public static void main(String[] args) {
        
        // Just some examples
        int x = 0b111;
        System.out.println("x = " + x);
        
        int y = 0xF;
        System.out.println("y = " + y);
        
        int z = 077;
        System.out.println("z = " + z);
        
        // <editor-fold defaultstate="collapsed" desc="PART 1: Two's complements integers">
        System.out.println("\n=============================================================");
        System.out.println("PART 1: Two's complements integers");
        System.out.println("=============================================================");

        // Before understanding floating point types, first understand integer 
        // storage...
        // What is the binary representation of an integer?
        System.out.println("2 bit wise = " + Integer.toBinaryString(2));

        // What is the binary representation of a negative integer?
        System.out.println("-2 bit wise = " + Integer.toBinaryString(-2));

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="PART 2: Binary arithmetic">
        System.out.println("\n=============================================================");
        System.out.println("PART 2: Binary arithmetic");
        System.out.println("=============================================================");

        // An integer in java is a so-called "32-bit signed two's complement 
        // integer"
        // First bit is not a sign bit, although being 0 for positive numbers
        // and 1 for negative numbers. Some people call it a sign bit, but 
        // mathematicians don't agree with that.

        // To get the bit representation of a negative number do:
        // 1. Determine the bit representation of the belonging positive number
        // 2. Flip all bits, in other words, replace all zero's by ones and all one's by zero's
        // 3. Add 1 to the result of step 2
        
        // Calculator, NOT USING two's complement: https://www.calculator.net/binary-calculator.html

        // What is the outcome of -3 + 2, binary calculated?
        // 3+2=5 easy
        System.out.println("Binary calculations: 3 + 2 = 5");
        System.out.println("3:  " + Integer.toBinaryString(3));
        System.out.println("2:  " + Integer.toBinaryString(2));
        System.out.println("======+");
        System.out.println("5: " + Integer.toBinaryString(5));
        
        
        // -3+5=2 easy, although the real outcome would be 10000.....101
        // The leading 1 would be the 33rd bit. This one is ignored because of 2's complements.
        System.out.println("\nBinary calculations: -3 + 5 = 2");
        System.out.println("-3: " + Integer.toBinaryString(-3));
        System.out.println(" 5:                              "
                + Integer.toBinaryString(5));
        System.out.println("====================================+");
        System.out.println(" 2:                               " + Integer.toBinaryString(2));
        
        // 0-3=-3 how: -(3 - 0) ->  -(0011) -> 11111111111111111111111111111101 -> using 2's complements
        // https://madformath.com/calculators/digital-systems/binary-arithmetic/binary-subtraction-calculator-with-steps/binary-subtraction-calculator-with-steps
        System.out.println("\nBinary calculations: 0 - 3 = -3");
        System.out.println("Same as -(3 - 0)");
        System.out.println("Same as -(3)");
        System.out.println("Same as -(0011) binary without using 2's complement");
        System.out.println("Same as " + Integer.toBinaryString(-3) + " USING 2s complement like Java does");
                
        // 8-6 = 2 more difficult
        // https://madformath.com/calculators/digital-systems/binary-arithmetic/binary-subtraction-calculator-with-steps/binary-subtraction-calculator-with-steps
        System.out.println("\nBinary calculations: 8 - 6 = 2, more complicated with traditional minus computation -> Borrow needed");
        System.out.println("8: " + Integer.toBinaryString(8));
        System.out.println("6:  " + Integer.toBinaryString(6));
        System.out.println("======= -");
        System.out.println("2:   " + Integer.toBinaryString(2));

        // 8 + (-6) way easier
        System.out.println("\nBinary calculations: 8 + (-6) = 2, -6 in 2's complement");
        System.out.println(" 8:                             "
                + Integer.toBinaryString(8));
        System.out.println("-6: " + Integer.toBinaryString(-6)); 
        System.out.println("====================================+");
        System.out.println(" 2:                               " + Integer.toBinaryString(2));
        System.out.println("Only addition needed. No subtraction with borrow");
        
        
        // -3+2=-1 just another example
        System.out.println("\nBinary calculations: -3 + 2 = -1, just another example");
        System.out.println("-3: " + Integer.toBinaryString(-3));
        System.out.println(" 2:                               "
                + Integer.toBinaryString(2));
        System.out.println("====================================+");
        System.out.println("-1: " + Integer.toBinaryString(-1));
        

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="PART 3: Integer division">
        System.out.println("\n=============================================================");
        System.out.println("PART 3: Integer division");
        System.out.println("=============================================================");

        // what is the outcome of 80 / 4?
        System.out.println("Integer division ?");
        System.out.print(Integer.toBinaryString(80));
        System.out.print(" / ");
        System.out.print(Integer.toBinaryString(4));
        System.out.print(" = ");
        System.out.println(Integer.toBinaryString(20));
        System.out.println();

        // Just to show it on the console...
        System.out.println("Decimal...");
        System.out.println("4 /  80  \\ 20");
        System.out.println("     8.       ");
        System.out.println("     -.       ");
        System.out.println("     00       ");
        System.out.println("      0       ");
        System.out.println("      -       ");
        System.out.println("      0       ");
        System.out.println();

        // Just to show it on the console...
        System.out.println("Binary...");
        System.out.println("100 /  1010000  \\ 10100");
        System.out.println("       100....           ");
        System.out.println("       ---....           ");
        System.out.println("         10...           ");
        System.out.println("         00...           ");
        System.out.println("         --...           ");
        System.out.println("         100..           ");
        System.out.println("         100..           ");
        System.out.println("         ---..           ");
        System.out.println("           00.           ");
        System.out.println("            0.           ");
        System.out.println("            -.           ");
        System.out.println("            00           ");
        System.out.println("             0           ");
        System.out.println("             -           ");
        System.out.println("             0           ");

        // Integer division - What is the outcome of 7 / 2?
        // see http://www.binaryconvert.com for more accurate answers, 
        // choose either float or double
        System.out.println("Integer division:  7 / 2");
        System.out.println("7: " + Integer.toBinaryString(7));
        System.out.println("2: " + Integer.toBinaryString(2));
        System.out.println("Result decimal representation: 7 / 2 = "
                + 7 / 2);
        System.out.println("Result double representation: 7.0 / 2.0 = "
                + 7.0 / 2.0);
        System.out.println("Result binary representation: "
                + Integer.toBinaryString(3));
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="PART 4: Scientific notation">
        System.out.println("\n=============================================================");
        System.out.println("PART 4: Scientific notation");
        System.out.println("=============================================================");

        // Back to doubles...
        // How is 0.1 written in scientific notation?
        // Scientific notation = mantissa * base^exponent
        // In the decimal number system base = 10, mantissa always has
        // exactly 1 digit before the decimal point.
        // See: https://www.youtube.com/watch?v=Dme-G4rc6NI

        // Explain Scientific notation based on decimals


        // What is the bit representation of 0.1?
        // decimal 0.1 = 1/16 + 1/32 + 1/256
        // is binary 0.00011001....
        // these dots express an infinite series of 0 and 1.
        // So not every finite series of decimals can be expressed with a
        // finite series of binaries!
        //
        // sign bit = 0
        // mantissa = 1.1001... and normalized mantissa = 1001..
        // exponent = -4, and biased exponent for double = -4+1023 is
        // decimal 1023 - 4  = binary 01111111111 - 100 = 01111011
        // check this with http://www.binaryconvert.com

        double hundred = 1E2;  // 1 * 10^2, mantissa=1, exponent=2, base=10
        System.out.println("100 = " + hundred);

        //double avogadro = 6.0221413e+23;
        //double number = 602214130000000000000000f;
        //System.out.println("avogadro's number: " + avogadro);
        //System.out.println("avogadro's number: " + number);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="PART 5: Inaccurate double and float calculations">
        System.out.println("=============================================================");
        System.out.println("PART 5: Inaccurate double and float calculations");
        System.out.println("=============================================================");

        // First some questions...
        // Why can't the decimal 0.1 not be stored in a binary exact (finite)
        // way?
        // Maybe difficult..., answer will be given soon.
        // Why can't the fraction 1/3 not be represented in a decimal (finite)
        // exact way? Easier... = 0.3333333......
        // Binary representation of numbers...
        // What is the binary representation of the double 0.1?
        System.out.println("double 0.1 bitwise = "
                + Long.toBinaryString(Double.doubleToLongBits(0.1)));

        // What is the length of this binary string?
        System.out.println("Length of 0.1 bitwise =  "
                + Long.toBinaryString(Double.doubleToLongBits(0.1)).length());
        // Length is not 64 bits as expected, because leading zeros are skipped...

        System.out.println();

        // What is the binary representation of the double -0.1?
        System.out.println("-0.1 bitwise = "
                + Long.toBinaryString(Double.doubleToLongBits(-0.1)));

        // What is the length of this binary string?
        System.out.println("Lenth: "
                + Long.toBinaryString(Double.doubleToLongBits(-0.1)).length());
        // Lenth is now 64 bit, because first bit represents sign and is
        // non-zero (so 1) for negative number

        System.out.println();

        double d1 = 0.1;
        System.out.print("d1 should be 0.1 ==> ");
        System.out.printf("%.20f", d1);
        System.out.println(", that is right");

        float f1 = 0.1f;
        System.out.print("f1 should be 0.1 ==> ");
        System.out.printf("%.20f", f1);
        System.out.println(", what's happening here?");

        for (int i = 1; i < 10000; i++) {
            f1 += 0.1f;
        }
        f1 = f1 / 10000;
        System.out.println("float: (0.1 + 0.1 + .. + 0.1)/10000 = " + f1);
        System.out.println("This is called error propagation");

        for (int i = 1; i < 10000; i++) {
            d1 += 0.1d;
        }
        d1 = d1 / 10000;
        System.out.println("double: (0.1 + 0.1 + .. + 0.1)/10000 = " + d1);
        System.out.println("See the difference in accuracy.");

        double d3 = d1 * 2;
        System.out.println("d3 (d1 * 2) should be 0.2 ==> " + d3);

        double d4 = d1 * 3;
        System.out.println("d4 (d1 * 3) should be 0.3 ==> " + d4);

        double d2 = 5.8;
        System.out.println("d2 should be 5.8 ==> " + d2);

        double d5 = d1 + d2;
        System.out.println("d5 (d1 + d2) should be 5.9 ==> " + d5);
        System.out.printf("d5 formatted but rounded = %.2f%n", d5);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="PART 6: Accurate calculations with big decimals">
        System.out.println("\n=============================================================");
        System.out.println("PART 6: Accurate calculations with big decimals");
        System.out.println("=============================================================");

        // Wrong usage of BigDecimals
        System.out.println("Wrong usage, damage has already been done...");
        BigDecimal bd1 = new BigDecimal(0.1);
        BigDecimal bd2 = new BigDecimal(5.8);

        BigDecimal bd3 = bd1.add(bd2);
        bd3.setScale(2, RoundingMode.UP);
        // But be careful, bd3 itself has not been changed

        System.out.println("bd3 = " + bd3);
        System.out.println("bd3 = " + bd3.setScale(2, RoundingMode.UP));
        System.out.println();

        System.out.println("Correct usage of BigDecimal");
        BigDecimal bd4 = new BigDecimal("0.1");
        BigDecimal bd5 = new BigDecimal("5.8");

        BigDecimal bd6 = bd4.add(bd5);
        System.out.println("bd6 = " + bd6);
        // </editor-fold>
    }
}
