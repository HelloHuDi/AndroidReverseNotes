package com.tencent.p177mm.plugin.shake.p1296e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p1296e.C43525c.C29005a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.shake.e.b */
public final class C29004b implements C9791v {
    private C29005a qwR = null;
    private String thumburl = "";

    public C29004b(C29005a c29005a) {
        this.qwR = c29005a;
    }

    public C29004b(String str) {
        this.thumburl = str;
    }

    public final String anJ() {
        AppMethodBeat.m2504i(24948);
        String fQ;
        if (this.qwR != null && this.qwR.field_thumburl != null) {
            fQ = C28987m.m46014fQ(this.qwR.field_thumburl, "@S");
            AppMethodBeat.m2505o(24948);
            return fQ;
        } else if (this.thumburl != null) {
            fQ = C28987m.m46014fQ(this.thumburl, "@S");
            AppMethodBeat.m2505o(24948);
            return fQ;
        } else {
            fQ = "";
            AppMethodBeat.m2505o(24948);
            return fQ;
        }
    }

    public final String anK() {
        if (this.qwR == null || this.qwR.field_thumburl == null) {
            return this.thumburl;
        }
        return this.qwR.field_thumburl;
    }

    public final String anL() {
        AppMethodBeat.m2504i(24949);
        String str = anK() + "_tv";
        AppMethodBeat.m2505o(24949);
        return str;
    }

    public final String getCacheKey() {
        AppMethodBeat.m2504i(24950);
        String str = anK() + "_tv";
        AppMethodBeat.m2505o(24950);
        return str;
    }

    public final boolean anM() {
        return false;
    }

    public final boolean anN() {
        return false;
    }

    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        AppMethodBeat.m2504i(24951);
        if (C9793a.NET == c9793a) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.TVImgGetStrategy", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(24951);
        return bitmap;
    }

    public final void anP() {
    }

    /* renamed from: V */
    public final void mo9516V(String str, boolean z) {
    }

    /* renamed from: a */
    public final void mo9518a(C9793a c9793a, String str) {
    }

    public final Bitmap anO() {
        AppMethodBeat.m2504i(24952);
        if (C4996ah.getContext() == null) {
            AppMethodBeat.m2505o(24952);
            return null;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
        AppMethodBeat.m2505o(24952);
        return decodeResource;
    }

    public final C9792b anI() {
        return null;
    }
}
