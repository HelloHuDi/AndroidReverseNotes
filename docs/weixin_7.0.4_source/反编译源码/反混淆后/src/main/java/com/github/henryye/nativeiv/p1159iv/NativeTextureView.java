package com.github.henryye.nativeiv.p1159iv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.github.henryye.nativeiv.iv.NativeTextureView */
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

    /* renamed from: pB */
    public static void m27432pB() {
        AppMethodBeat.m2504i(115771);
        C17837c.m27916i("Ni.NativeTextureView", "hy: clearing native surface", new Object[0]);
        AppMethodBeat.m2505o(115771);
    }
}
