import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

  /**
   * Complete the cipher function below. Parse the cipher from left to right.
   */
  static String cipher(int k, String s) {

    // **** compute number of bits in plain text ****
    int n = s.length() - k + 1;

    // **** array to hold cipher and plain text ****
    int[] cipher = new int[n];
    int[] plain = new int[n];

    // **** process the first n characters in the string ****
    for (int i = 0; i < n; i++) {

      // **** populate the cipher element ****
      cipher[i] = s.charAt(i) - '0';

      // **** compute the value for the plain text element ****
      if (i == 0) {
        plain[i] = cipher[i];

        // ???? ????
        System.out.println("cipher <<< plain[0]: " + plain[i] + " cipher[0]: " + cipher[i]);

      } else if (i < k) {
        plain[i] = cipher[i - 1] ^ cipher[i];

        // ???? ????
        System.out.println("cipher <<< plain[" + i + "]: " + plain[i] + " cipher[" + (i - 1) + "]: " + cipher[i - 1]
            + " ^ cipher[" + i + "]: " + cipher[i]);

      } else {
        plain[i] = cipher[i - 1] ^ cipher[i] ^ plain[i - k];

        // ???? ????
        System.out.println("cipher <<< plain[" + i + "]: " + plain[i] + " cipher[" + (i - 1) + "]: " + cipher[i - 1]
            + " ^ cipher[" + i + "]: " + cipher[i] + " ^ plain[" + (i - k) + "]: " + plain[i - k]);

      }

    }

    // **** populate string builder with contents of the plain text array ****
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(plain[i]);
    }

    // **** return string with the plain text ****
    return sb.toString();
  }

  // **** open scanner ****
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Test scaffolidng.
   */
  public static void main(String[] args) throws IOException {

    // **** open buffered writer ****
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    // **** read next line and split ****
    String[] nk = scanner.nextLine().split(" ");

    // **** extract binary values for n and k ****
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);

    // **** read the next line ****
    String s = scanner.nextLine();

    // **** ****
    String result = cipher(k, s);

    // **** display result ****
    bufferedWriter.write(result);
    bufferedWriter.newLine();

    // **** close buffered writer ****
    bufferedWriter.close();

    // **** close scanner ****
    scanner.close();
  }
}