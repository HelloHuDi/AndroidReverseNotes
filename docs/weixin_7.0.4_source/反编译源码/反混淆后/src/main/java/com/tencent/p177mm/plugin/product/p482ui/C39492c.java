package com.tencent.p177mm.plugin.product.p482ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.product.ui.c */
public final class C39492c implements C9791v {
    private static final String kdH = (C6457e.eSn + "wallet");
    private String url;

    public C39492c(String str) {
        this.url = str;
    }

    public final C9792b anI() {
        return null;
    }

    public final String anJ() {
        AppMethodBeat.m2504i(44045);
        String UK = C39492c.m67475UK(this.url);
        AppMethodBeat.m2505o(44045);
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
        AppMethodBeat.m2504i(44046);
        if (C9793a.NET == c9793a) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, C39492c.m67475UK(this.url), false);
            } catch (IOException e) {
                try {
                    File file = new File(kdH);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    C4990ab.m7420w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, C39492c.m67475UK(this.url), false);
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                }
            }
        }
        C4990ab.m7411d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", c9793a.toString());
        AppMethodBeat.m2505o(44046);
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

    static {
        AppMethodBeat.m2504i(44048);
        AppMethodBeat.m2505o(44048);
    }

    /* renamed from: UK */
    public static String m67475UK(String str) {
        AppMethodBeat.m2504i(44047);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
            AppMethodBeat.m2505o(44047);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{kdH, C1178g.m2591x(str.getBytes())});
        AppMethodBeat.m2505o(44047);
        return format;
    }
}
