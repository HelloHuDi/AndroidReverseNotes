package com.tencent.p177mm.app;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i.C14947a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.app.c */
final class C45154c implements C14947a {
    private volatile Bitmap cdX = null;
    C41732d cdY;

    /* renamed from: a */
    public final void mo8230a(C46507i c46507i) {
        AppMethodBeat.m2504i(15368);
        if (c46507i instanceof C8915a) {
            C17884o.acd().mo67498a((C8915a) c46507i);
        }
        AppMethodBeat.m2505o(15368);
    }

    /* renamed from: AZ */
    public final Bitmap mo8229AZ() {
        AppMethodBeat.m2504i(15370);
        if (this.cdX == null) {
            synchronized (this) {
                try {
                    if (this.cdX == null) {
                        this.cdX = C1434a.decodeResource(C4996ah.getContext().getResources(), C1318a.default_avatar);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(15370);
                    }
                }
            }
        }
        Bitmap bitmap = this.cdX;
        AppMethodBeat.m2505o(15370);
        return bitmap;
    }

    /* renamed from: cR */
    public final Bitmap mo8233cR(String str) {
        AppMethodBeat.m2504i(15371);
        if (this.cdY == null) {
            this.cdY = C17884o.acd();
        }
        Bitmap qd = C41732d.m73523qd(str);
        AppMethodBeat.m2505o(15371);
        return qd;
    }

    /* renamed from: b */
    public final Bitmap mo8231b(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(15372);
        Bitmap d = C41730b.m73493d(str, i, i2, i3);
        AppMethodBeat.m2505o(15372);
        return d;
    }

    /* renamed from: cQ */
    public final Bitmap mo8232cQ(String str) {
        AppMethodBeat.m2504i(15369);
        Bitmap a = C41730b.m73490a(str, false, -1);
        AppMethodBeat.m2505o(15369);
        return a;
    }
}
