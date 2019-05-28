package com.tencent.filter;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MRect {
    /* renamed from: h */
    int f16886h;
    /* renamed from: w */
    int f16887w;
    /* renamed from: x */
    int f16888x;
    /* renamed from: y */
    int f16889y;

    public MRect(int i, int i2, int i3, int i4) {
        this.f16888x = i;
        this.f16889y = i2;
        this.f16887w = i3;
        this.f16886h = i4;
    }

    public static MRect toMRect(Rect rect) {
        AppMethodBeat.m2504i(86385);
        MRect mRect = new MRect(rect.left, rect.top, rect.width(), rect.height());
        AppMethodBeat.m2505o(86385);
        return mRect;
    }
}
