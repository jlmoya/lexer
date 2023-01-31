package lexer;

/**
 * @author Jose Luis Moya Sobrado
 */
public class Parser {

    /**
     * Holds the string to process
     */
    private final String str;

    /**
     * Keeps track of the current position in the string
     */
    private int pos = -1;

    /**
     * Holds the current character
     */
    private int ch;

    /**
     * Constructor
     */
    public Parser(String str) {
        this.str = str;
    }

    /**
     * Advances pos and ch to the next character
     */
    private void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    /**
     * @return true if the next character is the one to lookup, skips spaces
     */
    private boolean lookup(int charToLookup) {
        while (ch == ' ') {
            nextChar();
        }
        if (ch == charToLookup) {
            nextChar();
            return true;
        }
        return false;
    }

    /**
     * @return the result of the evaluation
     */
    private Double parse() {
        nextChar();
        Double x = parseExpression();
        if (pos < str.length()) {
            return null;
        }
        return x;
    }

    /**
     * @return the result of the evaluation
     */
    private Double parseExpression() {
        Double x = parseTerm();
        for (; ; ) {
            if (lookup('+')) {
                x += parseTerm(); // addition
            } else if (lookup('-')) {
                x -= parseTerm(); // subtraction
            } else {
                return x;
            }
        }
    }

    /**
     * @return the result of the evaluation
     */
    private Double parseTerm() {
        Double x = parseFactor();
        for (; ; ) {
            if (lookup('*')) {
                x *= parseFactor(); // multiplication
            } else if (lookup('/')) {
                x /= parseFactor(); // division
            } else {
                return x;
            }
        }
    }

    /**
     * @return the result of the evaluation
     */
    private Double parseFactor() {
        if (lookup('+')) {
            return +parseFactor(); // unary plus
        }
        if (lookup('-')) {
            return -parseFactor(); // unary minus
        }

        int startPos = this.pos;
        if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') {
                nextChar();
            }
        } else if (ch >= 'a' && ch <= 'z') { // skip non-supported characters
            while (ch >= 'a' && ch <= 'z') {
                nextChar();
            }
            return null;
        }
        return Double.parseDouble(str.substring(startPos, this.pos));
    }

    /**
     * @return the result of the evaluation to the caller
     */
    public Double eval() {
        pos = -1;
        return parse();
    }

    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }
}
