import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Variable extends Formula {

    private String nameV;

    Variable(String name) {
        nameV = name;
    }

    private Variable(Variable v) {
        this.subforms = v.subforms;
    }

    String name() {
        return nameV;
    }

    Formula[] subf() {
        Formula[] res = {};
        return res;
    }

    public String toString() {
        return nameV;
    }

    Boolean equals(Formula other) {
        return nameV.equals(other.toString());
    }

    int deg() {
        return 0;
    }

    Set<String> vars() {
        Set<String> res = new HashSet<>();
        res.add(nameV);
        return res;
    }

    Boolean isSatisfied(Map<String, Boolean> v) {
        if (!v.containsKey(nameV)) {
            return false;
        }
        return v.get(nameV);
    }

    @Override Variable copy() {
        return new Variable(this);
    }

    Formula substitute(Formula what, Formula replacement) {
        Formula f1 = new Variable(nameV);
        if (this.equals(what)) {
            Formula f2 = new Variable(replacement.toString());
            return f2;
        }
        return f1;
    }
}
