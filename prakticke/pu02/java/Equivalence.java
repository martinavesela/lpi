import java.util.Map;

public class Equivalence extends BinaryFormula{

    Equivalence(Formula leftSide, Formula rightSide) {
        super(leftSide, rightSide);
    }

    private Equivalence(Equivalence e) {
        super(e);
    }

    public String toString() {
        return "(" + leftSide().toString() + "<->" + rightSide().toString() + ")";
    }

    Boolean isSatisfied(Map<String, Boolean> v) {
        return (((!leftSide().isSatisfied(v)) || rightSide().isSatisfied(v)) && (
                (!rightSide().isSatisfied(v)) || leftSide().isSatisfied(v)));
    }

    @Override Equivalence copy() {
        return new Equivalence(this);
    }

    Formula substitute(Formula what, Formula replacement) {
        if (this.equals(what)) {
            Formula res = replacement.copy();
            return res;
        }
        Formula left = leftSide().substitute(what, replacement);
        Formula right = rightSide().substitute(what, replacement);
        Formula res = new Equivalence(left, right);
        return res;
    }
}
