package com.p123qq.taf.jce.dynamic;

import com.p123qq.taf.jce.JceDecodeException;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceInputStream.HeadData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.qq.taf.jce.dynamic.DynamicInputStream */
public final class DynamicInputStream {
    /* renamed from: bs */
    private ByteBuffer f17725bs;
    private String sServerEncoding = "GBK";

    public DynamicInputStream(ByteBuffer byteBuffer) {
        this.f17725bs = byteBuffer;
    }

    public DynamicInputStream(byte[] bArr) {
        AppMethodBeat.m2504i(117033);
        this.f17725bs = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(117033);
    }

    public final int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public final JceField read() {
        int i = 0;
        AppMethodBeat.m2504i(117034);
        try {
            HeadData headData = new HeadData();
            JceInputStream.readHead(headData, this.f17725bs);
            JceField create;
            int i2;
            switch (headData.type) {
                case (byte) 0:
                    create = JceField.create(this.f17725bs.get(), headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 1:
                    create = JceField.create(this.f17725bs.getShort(), headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 2:
                    create = JceField.create(this.f17725bs.getInt(), headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 3:
                    create = JceField.create(this.f17725bs.getLong(), headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 4:
                    create = JceField.create(this.f17725bs.getFloat(), headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 5:
                    create = JceField.create(this.f17725bs.getDouble(), headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 6:
                    i2 = this.f17725bs.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    create = readString(headData, i2);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 7:
                    create = readString(headData, this.f17725bs.getInt());
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 8:
                    int intValue = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr = new JceField[intValue];
                    JceField[] jceFieldArr2 = new JceField[intValue];
                    for (i2 = 0; i2 < intValue; i2++) {
                        jceFieldArr[i2] = read();
                        jceFieldArr2[i2] = read();
                    }
                    create = JceField.createMap(jceFieldArr, jceFieldArr2, headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 9:
                    i2 = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr3 = new JceField[i2];
                    while (i < i2) {
                        jceFieldArr3[i] = read();
                        i++;
                    }
                    create = JceField.createList(jceFieldArr3, headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 10:
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        JceField read = read();
                        if (read != null) {
                            arrayList.add(read);
                        } else {
                            create = JceField.createStruct((JceField[]) arrayList.toArray(new JceField[0]), headData.tag);
                            AppMethodBeat.m2505o(117034);
                            return create;
                        }
                    }
                case (byte) 11:
                    AppMethodBeat.m2505o(117034);
                    return null;
                case (byte) 12:
                    create = JceField.createZero(headData.tag);
                    AppMethodBeat.m2505o(117034);
                    return create;
                case (byte) 13:
                    i = headData.tag;
                    JceInputStream.readHead(headData, this.f17725bs);
                    if (headData.type != (byte) 0) {
                        JceDecodeException jceDecodeException = new JceDecodeException("type mismatch, simple_list only support byte, tag: " + i + ", type: " + headData.type);
                        AppMethodBeat.m2505o(117034);
                        throw jceDecodeException;
                    }
                    byte[] bArr = new byte[((NumberField) read()).intValue()];
                    this.f17725bs.get(bArr);
                    create = JceField.create(bArr, i);
                    AppMethodBeat.m2505o(117034);
                    return create;
                default:
                    AppMethodBeat.m2505o(117034);
                    return null;
            }
        } catch (BufferUnderflowException e) {
            AppMethodBeat.m2505o(117034);
            return null;
        }
        AppMethodBeat.m2505o(117034);
        return null;
    }

    private JceField readString(HeadData headData, int i) {
        String str;
        AppMethodBeat.m2504i(117035);
        byte[] bArr = new byte[i];
        this.f17725bs.get(bArr);
        try {
            str = new String(bArr, this.sServerEncoding);
        } catch (UnsupportedEncodingException e) {
            str = new String(bArr);
        }
        JceField create = JceField.create(str, headData.tag);
        AppMethodBeat.m2505o(117035);
        return create;
    }
}
