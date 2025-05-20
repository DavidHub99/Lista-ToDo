import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Teclado {
    private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public static String getUmString() {
        String ret = null;

        try {
            ret = teclado.readLine();
        } catch (IOException erro) {
            
            System.err.println("Erro ao ler a entrada: " + erro.getMessage());
        }

        return ret;
    }

    public static byte getUmByte() throws Exception {
        return parseValue(Byte::parseByte, "Byte inválido!");
    }

    public static short getUmShort() throws Exception {
        return parseValue(Short::parseShort, "Short inválido!");
    }

    public static int getUmInt() throws Exception {
        return parseValue(Integer::parseInt, "Int inválido!");
    }

    public static long getUmLong() throws Exception {
        return parseValue(Long::parseLong, "Long inválido!");
    }

    public static float getUmFloat() throws Exception {
        return parseValue(Float::parseFloat, "Float inválido!");
    }

    public static double getUmDouble() throws Exception {
        return parseValue(Double::parseDouble, "Double inválido!");
    }

    public static char getUmChar() throws Exception {
        String str = getUmString();
        if (str == null || str.length() != 1) {
            throw new Exception("Char inválido!");
        }
        return str.charAt(0);
    }

    public static boolean getUmBoolean() throws Exception {
        String str = getUmString();
        if (str == null || (!str.equals("true") && !str.equals("false"))) {
            throw new Exception("Boolean inválido!");
        }
        return Boolean.parseBoolean(str);
    }

    
    private static <T> T parseValue(ValueParser<T> parser, String errorMessage) throws Exception {
        try {
            String input = teclado.readLine();
            return parser.parse(input);
        } catch (IOException erro) {
            
            System.err.println("Erro ao ler a entrada: " + erro.getMessage());
            return null; 
        } catch (NumberFormatException erro) {
            throw new Exception(errorMessage);
        }
    }

    
    @FunctionalInterface
    private interface ValueParser<T> {
        T parse(String value) throws NumberFormatException;
    }
}
