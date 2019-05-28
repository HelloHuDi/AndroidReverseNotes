package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.c */
public final class C4467c implements C9791v {
    private C9792b kBF = new C44681();
    private String url;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.c$1 */
    class C44681 implements C9792b {
        C44681() {
        }

        /* renamed from: vt */
        public final Bitmap mo9528vt(String str) {
            AppMethodBeat.m2504i(47904);
            Bitmap decodeFile = C5056d.decodeFile(str, null);
            AppMethodBeat.m2505o(47904);
            return decodeFile;
        }
    }

    public C4467c(String str) {
        AppMethodBeat.m2504i(47905);
        this.url = str;
        AppMethodBeat.m2505o(47905);
    }

    public final String anJ() {
        AppMethodBeat.m2504i(47906);
        String UK = C46362b.m87140UK(this.url);
        AppMethodBeat.m2505o(47906);
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
        AppMethodBeat.m2504i(47907);
        if (C9793a.NET == c9793a) {
            if (bitmap == null || bitmap.getNinePatchChunk() == null) {
                try {
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, C46362b.m87140UK(this.url), false);
                } catch (IOException e) {
                    try {
                        C5730e.m8643tf(C46362b.cRb());
                        C4990ab.m7420w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                        C5056d.m7625a(bitmap, 100, CompressFormat.PNG, C46362b.m87140UK(this.url), false);
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                        C4990ab.m7420w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                    }
                }
            } else {
                C4990ab.m7418v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
                C5730e.m8644y(str, C46362b.m87140UK(this.url));
                AppMethodBeat.m2505o(47907);
                return bitmap;
            }
        }
        C4990ab.m7411d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", c9793a.toString());
        AppMethodBeat.m2505o(47907);
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
