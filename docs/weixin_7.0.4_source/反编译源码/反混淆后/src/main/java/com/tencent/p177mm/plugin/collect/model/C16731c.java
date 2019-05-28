package com.tencent.p177mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.collect.model.c */
public final class C16731c implements C9791v {
    private C9792b kBF = new C167321();
    private String url;

    /* renamed from: com.tencent.mm.plugin.collect.model.c$1 */
    class C167321 implements C9792b {
        C167321() {
        }

        /* renamed from: vt */
        public final Bitmap mo9528vt(String str) {
            AppMethodBeat.m2504i(40922);
            Bitmap decodeFile = C5056d.decodeFile(str, null);
            AppMethodBeat.m2505o(40922);
            return decodeFile;
        }
    }

    public C16731c(String str) {
        AppMethodBeat.m2504i(40923);
        this.url = str;
        AppMethodBeat.m2505o(40923);
    }

    public final String anJ() {
        AppMethodBeat.m2504i(40924);
        String UK = C46362b.m87140UK(this.url);
        AppMethodBeat.m2505o(40924);
        return UK;
    }

    public final String anK() {
        return this.url;
    }

    public final String anL() {
        return this.url;
    }

    public final String getCacheKey() {
        return this.url;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        return null;
    }

    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        AppMethodBeat.m2504i(40925);
        if (C9793a.NET == c9793a) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, C46362b.m87140UK(this.url), false);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(40925);
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

    public final C9792b anI() {
        return this.kBF;
    }
}
