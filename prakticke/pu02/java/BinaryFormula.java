class BinaryFormula extends Formula {

    BinaryFormula(Formula leftSide, Formula rightSide) {
        subforms.add(leftSide);
        subforms.add(rightSide);
    }

    BinaryFormula(BinaryFormula b) {
        this.subforms = b.subforms;
    }

    Formula leftSide() {
        return subforms.iterator().next();
    }

    Formula rightSide() {
        int i = 0;
        for (Formula f: subforms) {
            if (i == 1) {
                return f;
            }
            i++;
        }
        return null;
    }

    @Override BinaryFormula copy() {
        return new BinaryFormula(this);
    }
}
