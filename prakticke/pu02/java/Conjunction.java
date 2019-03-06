import java.util.Map;

public class Conjunction extends Formula {

    Conjunction(Formula[] conjuncts) {
        for (Formula f: conjuncts) {
            subforms.add(f);
        }
    }

    private Conjunction(Conjunction c) {
        this.subforms = c.subforms;
    }

    public String toString() {
        String res = "(";
        for (Formula f: subforms) {
            res += f.toString() + "&";
        }
        res = res.substring(0, res.length()-1);
        return res + ")";
    }

    Boolean isSatisfied(Map<String, Boolean> v) {
        Boolean res = true;
        for (Formula f: subforms) {
            res = res && f.isSatisfied(v);
        }
        return res;
    }

    @Override Conjunction copy() {
        return new Conjunction(this);
    }

    Formula substitute(Formula what, Formula replacement) {
        if (this.equals(what)) {
            Formula res = replacement.copy();
            return res;
        }
        Formula[] c = new Formula[subforms.size()];
        int i = 0;
        for (Formula f: subforms) {
            Formula f1 = f.substitute(what, replacement);
            c[i] = f1;
            i++;
        }
        Formula res = new Conjunction(c);
        return res;
    }
}
