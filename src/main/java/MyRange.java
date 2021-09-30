public class MyRange {
    private final String input;
    private final int ASCII_CODE_1 = 48;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean startWithInclude() {
        return input.startsWith("[");
    }

    public int getStart() {
        char start = input.charAt(1);
        if(startWithInclude()) {
            return start - ASCII_CODE_1;
        }
        return start - (ASCII_CODE_1 -1);
    }

    public void validate() {
        if(!input.startsWith("[") && !input.startsWith("(")) {
            throw new InputInvalidException("Input Error");
        }

        //ok

    }
}
