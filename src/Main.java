import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        char[][] input = {{'F', 'A', 'C', 'I'},
                         {'O', 'B', 'Q', 'P'},
                         {'A', 'N', 'O', 'B'},
                         {'M', 'A', 'S', 'S'}};

        String str = br.readLine();

        System.out.println(findGivenStringIn2DArray(input,str));

    }

    private static boolean findGivenStringIn2DArray(char[][] input, String str) {
        boolean found = false;
        if(str.length()> input.length && str.length()>input[0].length)
            return false;

        for(int i=0;i< input.length;i++){
            for(int j=0;j<input[0].length;j++){
                if(checkLeftToRight(input,i,j,str)||checkTopToBottom(input,i,j,str))
                    found= true;
            }
        }

        return found;
    }

    private static boolean checkTopToBottom(char[][] input, int i, int j, String str) {
        if(j+str.length()>input[0].length)
            return false;

        for (int c = 0; c < input[i].length; c++)
            if (input[i][j + c] != str.charAt(c))
                return false;

        return true;
    }

    private static boolean checkLeftToRight(char[][] input, int i, int j, String str) {
        if(i+str.length()> input.length)
            return false;

        for (int r = 0; r < input.length; r++)
            if (input[i+r][j ] != str.charAt(r))
                return false;

        return true;
    }
}