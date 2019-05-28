package com.tencent.p177mm.plugin.emoji.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;

/* renamed from: com.tencent.mm.plugin.emoji.model.h */
public final class C42950h implements C1282i {
    public C1282i kVz;

    public C42950h(C1282i c1282i) {
        this.kVz = c1282i;
    }

    /* renamed from: a */
    public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
        AppMethodBeat.m2504i(53053);
        if (this.kVz != null) {
            this.kVz.mo4581a(str, view, bitmap, objArr);
        }
        AppMethodBeat.m2505o(53053);
    }
}
