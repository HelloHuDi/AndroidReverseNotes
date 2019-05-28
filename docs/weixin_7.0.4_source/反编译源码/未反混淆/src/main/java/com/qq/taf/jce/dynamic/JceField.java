package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JceField {
    private static ZeroField[] zs = new ZeroField[256];
    private int tag;

    JceField(int i) {
        this.tag = i;
    }

    public int getTag() {
        return this.tag;
    }

    public static JceField create(byte b, int i) {
        AppMethodBeat.i(117021);
        ByteField byteField = new ByteField(b, i);
        AppMethodBeat.o(117021);
        return byteField;
    }

    public static JceField create(short s, int i) {
        AppMethodBeat.i(117022);
        ShortField shortField = new ShortField(s, i);
        AppMethodBeat.o(117022);
        return shortField;
    }

    public static JceField create(int i, int i2) {
        AppMethodBeat.i(117023);
        IntField intField = new IntField(i, i2);
        AppMethodBeat.o(117023);
        return intField;
    }

    public static JceField create(long j, int i) {
        AppMethodBeat.i(117024);
        LongField longField = new LongField(j, i);
        AppMethodBeat.o(117024);
        return longField;
    }

    public static JceField create(float f, int i) {
        AppMethodBeat.i(117025);
        FloatField floatField = new FloatField(f, i);
        AppMethodBeat.o(117025);
        return floatField;
    }

    public static JceField create(double d, int i) {
        AppMethodBeat.i(117026);
        DoubleField doubleField = new DoubleField(d, i);
        AppMethodBeat.o(117026);
        return doubleField;
    }

    public static JceField create(String str, int i) {
        AppMethodBeat.i(117027);
        StringField stringField = new StringField(str, i);
        AppMethodBeat.o(117027);
        return stringField;
    }

    public static JceField create(byte[] bArr, int i) {
        AppMethodBeat.i(117028);
        ByteArrayField byteArrayField = new ByteArrayField(bArr, i);
        AppMethodBeat.o(117028);
        return byteArrayField;
    }

    public static JceField createList(JceField[] jceFieldArr, int i) {
        AppMethodBeat.i(117029);
        ListField listField = new ListField(jceFieldArr, i);
        AppMethodBeat.o(117029);
        return listField;
    }

    public static JceField createMap(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i) {
        AppMethodBeat.i(117030);
        MapField mapField = new MapField(jceFieldArr, jceFieldArr2, i);
        AppMethodBeat.o(117030);
        return mapField;
    }

    public static JceField createStruct(JceField[] jceFieldArr, int i) {
        AppMethodBeat.i(117031);
        StructField structField = new StructField(jceFieldArr, i);
        AppMethodBeat.o(117031);
        return structField;
    }

    static {
        AppMethodBeat.i(117020);
        for (int i = 0; i < zs.length; i++) {
            zs[i] = new ZeroField(i);
        }
        AppMethodBeat.o(117020);
    }

    public static JceField createZero(int i) {
        AppMethodBeat.i(117032);
        if (i < 0 || i >= 255) {
            JceDecodeException jceDecodeException = new JceDecodeException("invalid tag: ".concat(String.valueOf(i)));
            AppMethodBeat.o(117032);
            throw jceDecodeException;
        }
        JceField jceField = zs[i];
        AppMethodBeat.o(117032);
        return jceField;
    }
}
