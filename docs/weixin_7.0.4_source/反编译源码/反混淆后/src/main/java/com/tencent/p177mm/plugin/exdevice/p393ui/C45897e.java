package com.tencent.p177mm.plugin.exdevice.p393ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34029d;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.e */
final class C45897e {
    int auo;
    C34029d lFy;
    int lFz;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.e$a */
    static class C45896a {
        int auo;
        String lCH;
        C34029d lFy = null;
        int lFz;
        String username;

        public final C45897e bqg() {
            AppMethodBeat.m2504i(20234);
            C45897e c45897e = new C45897e(this.auo, this.lFz, this.lCH, this.username, this.lFy, (byte) 0);
            AppMethodBeat.m2505o(20234);
            return c45897e;
        }
    }

    /* synthetic */ C45897e(int i, int i2, String str, String str2, C34029d c34029d, byte b) {
        this(i, i2, str, str2, c34029d);
    }

    private C45897e(int i, int i2, String str, String str2, C34029d c34029d) {
        AppMethodBeat.m2504i(20235);
        this.auo = i;
        this.lFz = i2;
        if (i != 0) {
            if (c34029d != null) {
                this.lFy = c34029d;
                AppMethodBeat.m2505o(20235);
                return;
            }
            C34029d c34029d2 = new C34029d();
            c34029d2.field_username = str2;
            c34029d2.field_appusername = str;
            c34029d2.field_ranknum = 0;
            c34029d2.field_selfLikeState = 0;
            c34029d2.field_rankID = "";
            c34029d2.field_likecount = 0;
            c34029d2.field_score = 0;
            this.lFy = c34029d2;
        }
        AppMethodBeat.m2505o(20235);
    }

    public final String toString() {
        AppMethodBeat.m2504i(20236);
        String str = "{ view type: " + this.auo + " display flag: " + this.lFz;
        if (this.lFy != null) {
            str = str + this.lFy.toString();
        } else {
            str = str + " mExdeviceRankInfo is null";
        }
        str = str + "}";
        AppMethodBeat.m2505o(20236);
        return str;
    }
}
