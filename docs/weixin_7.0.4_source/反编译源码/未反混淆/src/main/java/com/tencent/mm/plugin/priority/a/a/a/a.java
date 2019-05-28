package com.tencent.mm.plugin.priority.a.a.a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static final boolean UE(String str) {
        boolean z;
        AppMethodBeat.i(97739);
        if (t.mY(str) && t.nN(str)) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (!t.kH(str) || t.nM(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || z2) {
            AppMethodBeat.o(97739);
            return true;
        }
        AppMethodBeat.o(97739);
        return false;
    }

    public static final boolean bZv() {
        AppMethodBeat.i(97740);
        if (!bZw()) {
            AppMethodBeat.o(97740);
            return false;
        } else if (bZx()) {
            AppMethodBeat.o(97740);
            return true;
        } else {
            AppMethodBeat.o(97740);
            return false;
        }
    }

    public static final boolean bZw() {
        AppMethodBeat.i(97741);
        if (b.afz()) {
            AppMethodBeat.o(97741);
            return false;
        }
        AppMethodBeat.o(97741);
        return true;
    }

    public static final boolean bZx() {
        AppMethodBeat.i(97742);
        int i = bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            ab.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
            AppMethodBeat.o(97742);
            return false;
        } else if (i == 2 && !at.isWifi(ah.getContext())) {
            AppMethodBeat.o(97742);
            return false;
        } else if (i != 1) {
            AppMethodBeat.o(97742);
            return false;
        } else if (at.isWifi(ah.getContext())) {
            AppMethodBeat.o(97742);
            return true;
        } else {
            boolean bZy = bZy();
            AppMethodBeat.o(97742);
            return bZy;
        }
    }

    private static boolean bZy() {
        AppMethodBeat.i(97743);
        long j = (long) bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ChatImgAutoDownloadMax"), 0);
        long a = bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
        long anl = bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
        long a2 = bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, null), 0);
        ab.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + anl + " month " + a2 + " maxcount " + j + " current " + a);
        if (anl != a2) {
            ab.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", Long.valueOf(anl));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(0));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
            a = 0;
        }
        if (a <= j || j <= 0) {
            AppMethodBeat.o(97743);
            return true;
        }
        ab.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + a + " C2C image, can not auto download.");
        AppMethodBeat.o(97743);
        return false;
    }
}
