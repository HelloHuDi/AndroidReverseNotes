package com.qq.taf.jce.dynamic;

public final class ListField extends JceField {
    private JceField[] data;

    ListField(JceField[] jceFieldArr, int i) {
        super(i);
        this.data = jceFieldArr;
    }

    public final JceField[] get() {
        return this.data;
    }

    public final JceField get(int i) {
        return this.data[i];
    }

    public final void set(int i, JceField jceField) {
        this.data[i] = jceField;
    }

    public final void set(JceField[] jceFieldArr) {
        this.data = jceFieldArr;
    }

    public final int size() {
        return this.data.length;
    }
}
