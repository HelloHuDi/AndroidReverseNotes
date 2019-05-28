package com.tencent.mm.plugin.emoji.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.i;

public final class h implements i {
    public i kVz;

    public h(i iVar) {
        this.kVz = iVar;
    }

    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
        AppMethodBeat.i(53053);
        if (this.kVz != null) {
            this.kVz.a(str, view, bitmap, objArr);
        }
        AppMethodBeat.o(53053);
    }
}
