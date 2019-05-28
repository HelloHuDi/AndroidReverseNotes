package com.tencent.liteav.basic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a implements Cloneable {
    public int a;
    public int b;
    public int c;
    public int d;
    public long e;
    public byte[] f;

    public Object clone() {
        Object obj;
        AppMethodBeat.i(66081);
        try {
            obj = (a) super.clone();
        } catch (CloneNotSupportedException e) {
            obj = null;
        }
        AppMethodBeat.o(66081);
        return obj;
    }
}
