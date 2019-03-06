import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Formula {

    Set<Formula> subforms = new LinkedHashSet<Formula>();

    Formula() {
    }

    private Formula(Formula f) {
        this.subforms = f.subforms;
    }

    Formula[] subf() {
        return subforms.toArray(new Formula[0]);
    }

    public String toString() {
        String res = "";
        for (Formula f: subforms) {
            res += f.toString();
        }
        return res;
    }

    Boolean isSatisfied(Map<String,Boolean> v) {
        return false;
    }

    Boolean equals(Formula other) {
        return toString().equals(other.toString());
    }

    int deg() {
        int deg = 1;
        for (Formula f: subforms) {
            deg += f.deg();
        }
        return deg;
    }
    Set<String> vars() {
        Set<String> res = new HashSet<>();
        for (Formula f: subforms) {
            for (String v: f.vars()) {
                res.add(v);
            }
        }
        return res;
    }

    Formula copy() {
        return new Formula(this);
    }

    Formula substitute(Formula what, Formula replacement) {
        return null;
    }
}
