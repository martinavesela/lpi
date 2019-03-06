import java.util.Map;

public class Implication extends BinaryFormula{

    Implication(Formula leftSide, Formula rightSide) {
        super(leftSide, rightSide);
    }

    private Implication(Implication i) {
        super(i);
    }

    public String toString() {
        return "(" + leftSide().toString() + "->" + rightSide().toString() + ")";
    }

    Boolean isSatisfied(Map<String, Boolean> v) {
        return (!leftSide().isSatisfied(v) || rightSide().isSatisfied(v));
    }

    @Override Implication copy() {
        return new Implication(this);
    }

    Formula substitute(Formula what, Formula replacement) {
        if (this.equals(what)) {
            Formula res = replacement.copy();
            return res;
        }
        Formula left = leftSide().substitute(what, replacement);
        Formula right = rightSide().substitute(what, replacement);
        Formula res = new Implication(left, right);
        return res;
    }
}
