package lexer;

public class Parser {

    private final String str;

    private int pos = -1;
    private int ch;

    public Parser(String str) {
        this.str = str;
    }

    private void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    private boolean eat(int charToEat) {
        while (ch == ' ') {
            nextChar();
        }
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    private Double parse() {
        nextChar();
        Double x = parseExpression();
        if (pos < str.length()) {
            return null;
        }
        return x;
    }

    /**
     * Grammar:
     * expression = term | expression `+` term | expression `-` term
     * term = factor | term `*` factor | term `/` factor
     * factor = `+` factor | `-` factor | number
     */
    private Double parseExpression() {
        Double x = parseTerm();
        for (; ; ) {
            if (eat('+')) {
                x += parseTerm(); // addition
            } else if (eat('-')) {
                x -= parseTerm(); // subtraction
            } else {
                return x;
            }
        }
    }

    private Double parseTerm() {
        Double x = parseFactor();
        for (; ; ) {
            if (eat('*')) {
                x *= parseFactor(); // multiplication
            } else if (eat('/')) {
                x /= parseFactor(); // division
            } else {
                return x;
            }
        }
    }

    private Double parseFactor() {
        if (eat('+')) {
            return +parseFactor(); // unary plus
        }
        if (eat('-')) {
            return -parseFactor(); // unary minus
        }

        double x;
        int startPos = this.pos;
        if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') {
                nextChar();
            }
        } else if (ch >= 'a' && ch <= 'z') { // functions
            while (ch >= 'a' && ch <= 'z') {
                nextChar();
            }
            return null;
        }
        return Double.parseDouble(str.substring(startPos, this.pos));
    }

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
