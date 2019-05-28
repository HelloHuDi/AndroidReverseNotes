package com.github.henryye.nativeiv.iv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeTextureView extends TextureView {
    public NativeTextureView(Context context) {
        this(context, null);
    }

    public NativeTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public NativeTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static void pB() {
        AppMethodBeat.i(115771);
        c.i("Ni.NativeTextureView", "hy: clearing native surface", new Object[0]);
        AppMethodBeat.o(115771);
    }
}
