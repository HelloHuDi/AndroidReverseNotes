package com.tencent.p177mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.card.model.m */
public final class C33770m implements C9791v {
    public static final String kdH = (C6457e.eSn + "card");
    public static final String kdI = (kdH + File.separator + "video");
    private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
    private String mPicUrl = null;

    static {
        AppMethodBeat.m2504i(87853);
        AppMethodBeat.m2505o(87853);
    }

    public C33770m(String str) {
        this.mPicUrl = str;
    }

    public final C9792b anI() {
        return null;
    }

    public final String anJ() {
        AppMethodBeat.m2504i(87849);
        String format = String.format("%s/%s", new Object[]{kdH, C1178g.m2591x(this.mPicUrl.getBytes())});
        AppMethodBeat.m2505o(87849);
        return format;
    }

    /* renamed from: Gz */
    public static String m55183Gz(String str) {
        AppMethodBeat.m2504i(87850);
        String format = String.format("%s/%s", new Object[]{kdH, C1178g.m2591x(str.getBytes())});
        AppMethodBeat.m2505o(87850);
        return format;
    }

    public final String anK() {
        return this.mPicUrl;
    }

    public final String anL() {
        return this.mPicUrl;
    }

    public final String getCacheKey() {
        return this.mPicUrl;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        AppMethodBeat.m2504i(87851);
        C4990ab.m7410d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
        AppMethodBeat.m2505o(87851);
        return null;
    }

    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        AppMethodBeat.m2504i(87852);
        if (C9793a.NET == c9793a) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                try {
                    File file = new File(anJ());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    C4990ab.m7420w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", e2, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
                }
            }
        }
        C4990ab.m7411d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", c9793a.toString());
        AppMethodBeat.m2505o(87852);
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
}
