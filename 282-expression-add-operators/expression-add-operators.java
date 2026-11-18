import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        search(num, target, 0, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void search(String num, long target, int index,
                        long value, long lastOperand,
                        StringBuilder expression, List<String> result) {
        if (index == num.length()) {
            if (value == target) {
                result.add(expression.toString());
            }
            return;
        }

        int lengthBefore = expression.length();

        for (int end = index; end < num.length(); end++) {
            // Multi-digit operands cannot start with zero.
            if (end > index && num.charAt(index) == '0') {
                break;
            }

            long current = Long.parseLong(num.substring(index, end + 1));
            String operand = num.substring(index, end + 1);

            if (index == 0) {
                expression.append(operand);
                search(num, target, end + 1, current, current, expression, result);
                expression.setLength(lengthBefore);
            } else {
                expression.append('+').append(operand);
                search(num, target, end + 1, value + current, current, expression, result);
                expression.setLength(lengthBefore);

                expression.append('-').append(operand);
                search(num, target, end + 1, value - current, -current, expression, result);
                expression.setLength(lengthBefore);

                expression.append('*').append(operand);
                long multipliedValue = value - lastOperand + lastOperand * current;
                search(num, target, end + 1, multipliedValue,
                       lastOperand * current, expression, result);
                expression.setLength(lengthBefore);
            }
        }
    }
}