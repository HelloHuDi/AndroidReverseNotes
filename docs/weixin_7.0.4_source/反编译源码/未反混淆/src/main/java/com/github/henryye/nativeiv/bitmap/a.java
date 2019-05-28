package com.github.henryye.nativeiv.bitmap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<ConfType> {
    public boolean aMb;
    public ConfType aMc;
    public long aMd;
    public int height;
    public int width;

    public final String toString() {
        AppMethodBeat.i(115757);
        String str = "DumpInfo{width=" + this.width + ", height=" + this.height + ", isNative=" + this.aMb + ", config=" + this.aMc + ", decodeUsingInMs=" + this.aMd + '}';
        AppMethodBeat.o(115757);
        return str;
    }
}
