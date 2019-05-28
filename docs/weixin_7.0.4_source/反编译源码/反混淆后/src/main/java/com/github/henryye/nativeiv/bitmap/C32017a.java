package com.github.henryye.nativeiv.bitmap;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.github.henryye.nativeiv.bitmap.a */
public final class C32017a<ConfType> {
    public boolean aMb;
    public ConfType aMc;
    public long aMd;
    public int height;
    public int width;

    public final String toString() {
        AppMethodBeat.m2504i(115757);
        String str = "DumpInfo{width=" + this.width + ", height=" + this.height + ", isNative=" + this.aMb + ", config=" + this.aMc + ", decodeUsingInMs=" + this.aMd + '}';
        AppMethodBeat.m2505o(115757);
        return str;
    }
}
