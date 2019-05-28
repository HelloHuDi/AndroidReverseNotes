package com.p123qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.qq.taf.jce.dynamic.StructField */
public class StructField extends JceField {
    private static final Comparator<JceField> tagComp = new C416541();
    private JceField[] data;

    /* renamed from: com.qq.taf.jce.dynamic.StructField$1 */
    class C416541 implements Comparator<JceField> {
        C416541() {
        }

        public int compare(JceField jceField, JceField jceField2) {
            AppMethodBeat.m2504i(117009);
            int tag = jceField.getTag() - jceField2.getTag();
            AppMethodBeat.m2505o(117009);
            return tag;
        }
    }

    static {
        AppMethodBeat.m2504i(117011);
        AppMethodBeat.m2505o(117011);
    }

    StructField(JceField[] jceFieldArr, int i) {
        super(i);
        this.data = jceFieldArr;
    }

    public JceField[] get() {
        return this.data;
    }

    public boolean setByTag(int i, JceField jceField) {
        AppMethodBeat.m2504i(117012);
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        if (binarySearch >= 0) {
            this.data[binarySearch] = jceField;
            AppMethodBeat.m2505o(117012);
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
        AppMethodBeat.m2505o(117012);
        return false;
    }

    public JceField getFieldByTag(int i) {
        AppMethodBeat.m2504i(117013);
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        if (binarySearch >= 0) {
            JceField jceField = this.data[binarySearch];
            AppMethodBeat.m2505o(117013);
            return jceField;
        }
        AppMethodBeat.m2505o(117013);
        return null;
    }
}
