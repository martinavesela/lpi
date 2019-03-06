import java.util.Map;

public class Disjunction extends Formula {

    Disjunction(Formula[] disjuncts) {
        for (Formula f: disjuncts) {
            subforms.add(f);
        }
    }

    private Disjunction(Disjunction d) {
        this.subforms = d.subforms;
    }

    public String toString() {
        String res = "(";
        for (Formula f: subforms) {
            res += f.toString() + "|";
        }
        res = res.substring(0, res.length()-1);
        return res + ")";
    }

    Boolean isSatisfied(Map<String, Boolean> v) {
        Boolean res = false;
        for (Formula f: subforms) {
            res = res || f.isSatisfied(v);
        }
        return res;
    }

    @Override Disjunction copy() {
        return new Disjunction(this);
    }

    Formula substitute(Formula what, Formula replacement) {
        if (this.equals(what)) {
            Formula res = replacement.copy();
            return res;
        }
        Formula[] d = new Formula[subforms.size()];
        int i = 0;
        for (Formula f: subforms) {
            Formula f1 = f.substitute(what, replacement);
            d[i] = f1;
            i++;
        }
        Formula res = new Disjunction(d);
        return res;
    }
}
