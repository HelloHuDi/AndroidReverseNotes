package com.tencent.p177mm.plugin.game.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.game.model.ai */
public final class C16773ai implements C9791v {
    protected String mPicUrl;

    public C16773ai(String str) {
        AppMethodBeat.m2504i(111409);
        this.mPicUrl = str;
        File file = new File(C6457e.euT);
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.m2505o(111409);
    }

    public final C9792b anI() {
        return null;
    }

    public final String anJ() {
        AppMethodBeat.m2504i(111410);
        String str = C6457e.euT + C1178g.m2591x(this.mPicUrl.getBytes());
        AppMethodBeat.m2505o(111410);
        return str;
    }

    public final String anK() {
        return this.mPicUrl;
    }

    public final String anL() {
        AppMethodBeat.m2504i(111411);
        String str = this.mPicUrl.hashCode();
        AppMethodBeat.m2505o(111411);
        return str;
    }

    public final String getCacheKey() {
        AppMethodBeat.m2504i(111412);
        String str = this.mPicUrl.hashCode();
        AppMethodBeat.m2505o(111412);
        return str;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        AppMethodBeat.m2504i(111413);
        Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
        AppMethodBeat.m2505o(111413);
        return decodeResource;
    }

    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        AppMethodBeat.m2504i(111414);
        if (C9793a.DISK == c9793a) {
            AppMethodBeat.m2505o(111414);
        } else {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.GetGamePicStrategy", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(111414);
        }
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
