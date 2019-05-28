package com.qq.taf.jce.dynamic;

public final class MapField extends JceField {
    private JceField[] keys;
    private JceField[] values;

    MapField(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i) {
        super(i);
        this.keys = jceFieldArr;
        this.values = jceFieldArr2;
    }

    public final JceField[] getKeys() {
        return this.keys;
    }

    public final JceField[] getValues() {
        return this.values;
    }

    public final int size() {
        return this.keys.length;
    }

    public final JceField getKey(int i) {
        return this.keys[i];
    }

    public final JceField getValue(int i) {
        return this.values[i];
    }

    public final void setKey(int i, JceField jceField) {
        this.keys[i] = jceField;
    }

    public final void setValue(int i, JceField jceField) {
        this.values[i] = jceField;
    }
}
