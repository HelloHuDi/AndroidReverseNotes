package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    private static Map<Integer, c> bXM;
    private int mId;
    private int mSize;

    static {
        bXM = new HashMap();
        c[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            c cVar = values[i];
            bXM.put(Integer.valueOf(cVar.mId), cVar);
            i++;
        }
    }

    private c(int i, int i2) {
        this.mId = i;
        this.mSize = i2;
    }

    public static c fW(int i) {
        return (c) bXM.get(Integer.valueOf(i));
    }

    public final int getSize(int i) {
        return this.mSize != 0 ? this.mSize : i;
    }
}
