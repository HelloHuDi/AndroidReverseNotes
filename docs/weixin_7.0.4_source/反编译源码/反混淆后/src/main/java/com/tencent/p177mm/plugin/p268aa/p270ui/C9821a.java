package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;

/* renamed from: com.tencent.mm.plugin.aa.ui.a */
public final class C9821a extends C23322n {
    private C9822a gmZ;

    /* renamed from: com.tencent.mm.plugin.aa.ui.a$a */
    public interface C9822a {
        void aos();
    }

    public C9821a(C9822a c9822a) {
        super(2, null);
        this.gmZ = c9822a;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(40707);
        if (this.gmZ != null) {
            this.gmZ.aos();
        }
        AppMethodBeat.m2505o(40707);
    }
}
