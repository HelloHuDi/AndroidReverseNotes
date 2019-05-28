package com.tencent.matrix.resource.p164c.p165a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.matrix.resource.c.a.c */
public enum C1102c {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    private static Map<Integer, C1102c> bXM;
    private int mId;
    private int mSize;

    static {
        bXM = new HashMap();
        C1102c[] values = C1102c.values();
        int length = values.length;
        int i;
        while (i < length) {
            C1102c c1102c = values[i];
            bXM.put(Integer.valueOf(c1102c.mId), c1102c);
            i++;
        }
    }

    private C1102c(int i, int i2) {
        this.mId = i;
        this.mSize = i2;
    }

    /* renamed from: fW */
    public static C1102c m2413fW(int i) {
        return (C1102c) bXM.get(Integer.valueOf(i));
    }

    public final int getSize(int i) {
        return this.mSize != 0 ? this.mSize : i;
    }
}
