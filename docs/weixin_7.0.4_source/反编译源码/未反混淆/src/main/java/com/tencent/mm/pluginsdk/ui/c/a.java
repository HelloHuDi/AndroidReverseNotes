package com.tencent.mm.pluginsdk.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends com.tencent.mm.ui.tools.b.a {
    private String ien;
    public int mSize = 104857600;
    private a vpV;

    public interface a {
    }

    private a(String str) {
        this.ien = str;
    }

    public static a ajK(String str) {
        AppMethodBeat.i(28012);
        a aVar = new a(str);
        AppMethodBeat.o(28012);
        return aVar;
    }

    public final int aAa() {
        int shouldRemuxing;
        int i = 10485760;
        AppMethodBeat.i(28013);
        if (bo.isNullOrNil(this.ien)) {
            ab.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
        }
        boolean is2G = at.is2G(ah.getContext());
        if (c.vC(this.ien)) {
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
            if (e.cs(this.ien) > (is2G ? 10485760 : 26214400)) {
                shouldRemuxing = -1;
            } else {
                shouldRemuxing = 1;
            }
        }
        ab.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", Integer.valueOf(shouldRemuxing), Boolean.valueOf(r10));
        switch (shouldRemuxing) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
                AppMethodBeat.o(28013);
                return 1;
            case -1:
                AppMethodBeat.o(28013);
                return 2;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                AppMethodBeat.o(28013);
                return 0;
            default:
                ab.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", Integer.valueOf(shouldRemuxing));
                AppMethodBeat.o(28013);
                return 1;
        }
    }

    public final void dkS() {
        AppMethodBeat.i(28014);
        if (this.vpV == null) {
            ab.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
            AppMethodBeat.o(28014);
            return;
        }
        aAa();
        AppMethodBeat.o(28014);
    }
}
