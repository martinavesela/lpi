import java.util.Map;

public class Negation extends Formula {

    Negation(Formula originalFormula) {
        subforms.add(originalFormula);
    }

    private Negation (Negation n) {
        this.subforms = n.subforms;
    }

    Formula originalFormula() {
        return subforms.iterator().next();
    }

    public String toString() {
        return "-" + originalFormula().toString();
    }

    Boolean isSatisfied(Map<String, Boolean> v) {
        return !originalFormula().isSatisfied(v);
    }

    @Override Negation copy() {
        return new Negation(this);
    }

    Formula substitute(Formula what, Formula replacement) {
        if (this.equals(what)) {
            Formula res = replacement.copy();
            return res;
        }
        Formula res = new Negation(originalFormula().substitute(what, replacement));
        return res;
    }

}
