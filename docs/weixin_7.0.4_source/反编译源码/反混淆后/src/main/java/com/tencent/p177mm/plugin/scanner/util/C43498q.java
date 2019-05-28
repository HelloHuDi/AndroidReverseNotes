package com.tencent.p177mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.scanner.util.q */
public final class C43498q implements C9791v {
    private String mPicUrl = null;

    public C43498q(String str) {
        this.mPicUrl = str;
    }

    public final String anJ() {
        AppMethodBeat.m2504i(81490);
        String fQ = C43488e.cgy().mo69040fQ(this.mPicUrl, "@S");
        AppMethodBeat.m2505o(81490);
        return fQ;
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
        return false;
    }

    public final boolean anN() {
        return false;
    }

    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        AppMethodBeat.m2504i(81491);
        if (C9793a.NET == c9793a) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(81491);
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
        AppMethodBeat.m2504i(81492);
        if (C4996ah.getContext() == null) {
            AppMethodBeat.m2505o(81492);
            return null;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
        AppMethodBeat.m2505o(81492);
        return decodeResource;
    }

    public final C9792b anI() {
        return null;
    }
}
