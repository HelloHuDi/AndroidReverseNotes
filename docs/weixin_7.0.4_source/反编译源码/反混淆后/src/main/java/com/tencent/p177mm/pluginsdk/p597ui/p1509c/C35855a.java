package com.tencent.p177mm.pluginsdk.p597ui.p1509c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.tools.p632b.C5580a;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.c.a */
public final class C35855a extends C5580a {
    private String ien;
    public int mSize = 104857600;
    private C35854a vpV;

    /* renamed from: com.tencent.mm.pluginsdk.ui.c.a$a */
    public interface C35854a {
    }

    private C35855a(String str) {
        this.ien = str;
    }

    public static C35855a ajK(String str) {
        AppMethodBeat.m2504i(28012);
        C35855a c35855a = new C35855a(str);
        AppMethodBeat.m2505o(28012);
        return c35855a;
    }

    public final int aAa() {
        int shouldRemuxing;
        int i = 10485760;
        AppMethodBeat.m2504i(28013);
        if (C5046bo.isNullOrNil(this.ien)) {
            C4990ab.m7420w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
        }
        boolean is2G = C5023at.is2G(C4996ah.getContext());
        if (C42258c.m74643vC(this.ien)) {
            double d;
            String str = this.ien;
            if (!is2G) {
                i = this.mSize;
            }
            if (is2G) {
                d = 60000.0d;
            } else {
                d = (double) this.mSize;
            }
            shouldRemuxing = SightVideoJNI.shouldRemuxing(str, 660, 500, i, d, 1000000);
        } else {
            if (C1173e.m2560cs(this.ien) > (is2G ? 10485760 : 26214400)) {
                shouldRemuxing = -1;
            } else {
                shouldRemuxing = 1;
            }
        }
        C4990ab.m7417i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", Integer.valueOf(shouldRemuxing), Boolean.valueOf(r10));
        switch (shouldRemuxing) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
                AppMethodBeat.m2505o(28013);
                return 1;
            case -1:
                AppMethodBeat.m2505o(28013);
                return 2;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                AppMethodBeat.m2505o(28013);
                return 0;
            default:
                C4990ab.m7413e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", Integer.valueOf(shouldRemuxing));
                AppMethodBeat.m2505o(28013);
                return 1;
        }
    }

    public final void dkS() {
        AppMethodBeat.m2504i(28014);
        if (this.vpV == null) {
            C4990ab.m7420w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
            AppMethodBeat.m2505o(28014);
            return;
        }
        aAa();
        AppMethodBeat.m2505o(28014);
    }
}
