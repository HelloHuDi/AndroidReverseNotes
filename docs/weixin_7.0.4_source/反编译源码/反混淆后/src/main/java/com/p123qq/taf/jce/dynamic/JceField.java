package com.p123qq.taf.jce.dynamic;

import com.p123qq.taf.jce.JceDecodeException;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.qq.taf.jce.dynamic.JceField */
public class JceField {
    /* renamed from: zs */
    private static ZeroField[] f2441zs = new ZeroField[256];
    private int tag;

    JceField(int i) {
        this.tag = i;
    }

    public int getTag() {
        return this.tag;
    }

    public static JceField create(byte b, int i) {
        AppMethodBeat.m2504i(117021);
        ByteField byteField = new ByteField(b, i);
        AppMethodBeat.m2505o(117021);
        return byteField;
    }

    public static JceField create(short s, int i) {
        AppMethodBeat.m2504i(117022);
        ShortField shortField = new ShortField(s, i);
        AppMethodBeat.m2505o(117022);
        return shortField;
    }

    public static JceField create(int i, int i2) {
        AppMethodBeat.m2504i(117023);
        IntField intField = new IntField(i, i2);
        AppMethodBeat.m2505o(117023);
        return intField;
    }

    public static JceField create(long j, int i) {
        AppMethodBeat.m2504i(117024);
        LongField longField = new LongField(j, i);
        AppMethodBeat.m2505o(117024);
        return longField;
    }

    public static JceField create(float f, int i) {
        AppMethodBeat.m2504i(117025);
        FloatField floatField = new FloatField(f, i);
        AppMethodBeat.m2505o(117025);
        return floatField;
    }

    public static JceField create(double d, int i) {
        AppMethodBeat.m2504i(117026);
        DoubleField doubleField = new DoubleField(d, i);
        AppMethodBeat.m2505o(117026);
        return doubleField;
    }

    public static JceField create(String str, int i) {
        AppMethodBeat.m2504i(117027);
        StringField stringField = new StringField(str, i);
        AppMethodBeat.m2505o(117027);
        return stringField;
    }

    public static JceField create(byte[] bArr, int i) {
        AppMethodBeat.m2504i(117028);
        ByteArrayField byteArrayField = new ByteArrayField(bArr, i);
        AppMethodBeat.m2505o(117028);
        return byteArrayField;
    }

    public static JceField createList(JceField[] jceFieldArr, int i) {
        AppMethodBeat.m2504i(117029);
        ListField listField = new ListField(jceFieldArr, i);
        AppMethodBeat.m2505o(117029);
        return listField;
    }

    public static JceField createMap(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i) {
        AppMethodBeat.m2504i(117030);
        MapField mapField = new MapField(jceFieldArr, jceFieldArr2, i);
        AppMethodBeat.m2505o(117030);
        return mapField;
    }

    public static JceField createStruct(JceField[] jceFieldArr, int i) {
        AppMethodBeat.m2504i(117031);
        StructField structField = new StructField(jceFieldArr, i);
        AppMethodBeat.m2505o(117031);
        return structField;
    }

    static {
        AppMethodBeat.m2504i(117020);
        for (int i = 0; i < f2441zs.length; i++) {
            f2441zs[i] = new ZeroField(i);
        }
        AppMethodBeat.m2505o(117020);
    }

    public static JceField createZero(int i) {
        AppMethodBeat.m2504i(117032);
        if (i < 0 || i >= 255) {
            JceDecodeException jceDecodeException = new JceDecodeException("invalid tag: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(117032);
            throw jceDecodeException;
        }
        JceField jceField = f2441zs[i];
        AppMethodBeat.m2505o(117032);
        return jceField;
    }
}
