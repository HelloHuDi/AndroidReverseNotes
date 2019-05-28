package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;

public class StructField extends JceField {
    private static final Comparator<JceField> tagComp = new Comparator<JceField>() {
        public int compare(JceField jceField, JceField jceField2) {
            AppMethodBeat.i(117009);
            int tag = jceField.getTag() - jceField2.getTag();
            AppMethodBeat.o(117009);
            return tag;
        }
    };
    private JceField[] data;

    static {
        AppMethodBeat.i(117011);
        AppMethodBeat.o(117011);
    }

    StructField(JceField[] jceFieldArr, int i) {
        super(i);
        this.data = jceFieldArr;
    }

    public JceField[] get() {
        return this.data;
    }

    public boolean setByTag(int i, JceField jceField) {
        AppMethodBeat.i(117012);
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        if (binarySearch >= 0) {
            this.data[binarySearch] = jceField;
            AppMethodBeat.o(117012);
            return true;
        }
        binarySearch = (-binarySearch) - 1;
        JceField[] jceFieldArr = new JceField[(this.data.length + 1)];
        for (int i2 = 0; i2 < binarySearch; i2++) {
            jceFieldArr[i2] = this.data[i2];
        }
        jceFieldArr[binarySearch] = jceField;
        while (binarySearch < this.data.length) {
            jceFieldArr[binarySearch + 1] = this.data[binarySearch];
            binarySearch++;
        }
        AppMethodBeat.o(117012);
        return false;
    }

    public JceField getFieldByTag(int i) {
        AppMethodBeat.i(117013);
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        if (binarySearch >= 0) {
            JceField jceField = this.data[binarySearch];
            AppMethodBeat.o(117013);
            return jceField;
        }
        AppMethodBeat.o(117013);
        return null;
    }
}
