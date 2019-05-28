package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c implements at {
    public static synchronized c afC() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(78091);
            cVar = (c) q.Y(c.class);
            AppMethodBeat.o(78091);
        }
        return cVar;
    }

    public static boolean u(bi biVar) {
        AppMethodBeat.i(78092);
        if (biVar == null) {
            ab.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
            AppMethodBeat.o(78092);
            return false;
        } else if (!biVar.drE()) {
            ab.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
            AppMethodBeat.o(78092);
            return false;
        } else if (v(biVar)) {
            boolean afD = afD();
            AppMethodBeat.o(78092);
            return afD;
        } else {
            ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
            AppMethodBeat.o(78092);
            return false;
        }
    }

    public static boolean afD() {
        AppMethodBeat.i(78093);
        if (b.afz()) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            AppMethodBeat.o(78093);
            return false;
        }
        int i = bo.getInt(((a) g.K(a.class)).Nu().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            ab.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
            AppMethodBeat.o(78093);
            return false;
        }
        Context context = ah.getContext();
        if (i == 2 && com.tencent.mm.sdk.platformtools.at.isWifi(context)) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            AppMethodBeat.o(78093);
            return true;
        } else if (i == 1 && com.tencent.mm.sdk.platformtools.at.isWifi(context)) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            AppMethodBeat.o(78093);
            return true;
        } else {
            long j = (long) bo.getInt(((a) g.K(a.class)).Nu().getValue("ChatImgAutoDownloadMax"), 0);
            long a = bo.a((Long) g.RP().Ry().get(ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long anl = bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
            long a2 = bo.a((Long) g.RP().Ry().get(ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, null), 0);
            ab.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + anl + " month " + a2 + " maxcount " + j + " current " + a + " downloadMode: " + i);
            if (anl != a2) {
                ab.i("MicroMsg.SubCoreAutoDownload", "update month %d ", Long.valueOf(anl));
                g.RP().Ry().set(ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(0));
                g.RP().Ry().set(ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
                a2 = 0;
            } else {
                a2 = a;
            }
            if (a2 > j && j > 0) {
                ab.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + a2 + " C2C image, can not auto download.");
                AppMethodBeat.o(78093);
                return false;
            } else if (i == 1 && (com.tencent.mm.sdk.platformtools.at.isWifi(context) || com.tencent.mm.sdk.platformtools.at.is3G(context) || com.tencent.mm.sdk.platformtools.at.is4G(context))) {
                ab.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                AppMethodBeat.o(78093);
                return true;
            } else {
                ab.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                AppMethodBeat.o(78093);
                return false;
            }
        }
    }

    public static boolean a(PInt pInt, PInt pInt2, PInt pInt3) {
        AppMethodBeat.i(78095);
        pInt.value = 0;
        int i = bo.getInt(((a) g.K(a.class)).Nu().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            ab.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            AppMethodBeat.o(78095);
            return false;
        }
        boolean isWifi = com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext());
        if (i == 2 && !isWifi) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            AppMethodBeat.o(78095);
            return false;
        } else if (com.tencent.mm.sdk.platformtools.at.is2G(ah.getContext())) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            AppMethodBeat.o(78095);
            return false;
        } else {
            String value = ((a) g.K(a.class)).Nu().getValue("SnsSightNoAutoDownload");
            if (!bo.isNullOrNil(value)) {
                try {
                    ab.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(value)));
                    long j = bo.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) b.afB()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j2 = bo.getLong(split[0], 0);
                    if (j <= bo.getLong(split[1], 0) && j >= j2) {
                        ab.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        AppMethodBeat.o(78095);
                        return false;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", value, e.getMessage());
                }
            }
            String value2 = ((a) g.K(a.class)).Nu().getValue("SnsSightNotAutoDownloadTimeRange");
            ab.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(value2)));
            if (b.rR(value2)) {
                int i2;
                ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                AppMethodBeat.o(78095);
                return false;
            }
            ab.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            AppMethodBeat.o(78095);
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2) {
        AppMethodBeat.i(78096);
        pInt.value = 0;
        int i = bo.getInt(((a) g.K(a.class)).Nu().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            ab.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            AppMethodBeat.o(78096);
            return false;
        }
        boolean isWifi = com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext());
        if (i == 2 && !isWifi) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            AppMethodBeat.o(78096);
            return false;
        } else if (com.tencent.mm.sdk.platformtools.at.is2G(ah.getContext())) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            AppMethodBeat.o(78096);
            return false;
        } else {
            String value = ((a) g.K(a.class)).Nu().getValue("SnsAdSightNotAutoDownloadTimeRange");
            ab.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(value)));
            if (b.rR(value)) {
                int i2;
                ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                AppMethodBeat.o(78096);
                return false;
            }
            ab.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            AppMethodBeat.o(78096);
            return true;
        }
    }

    public static boolean v(bi biVar) {
        AppMethodBeat.i(78097);
        if (biVar == null) {
            ab.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            AppMethodBeat.o(78097);
            return false;
        }
        b oE = bf.oE(biVar.dqJ);
        if (oE == null) {
            ab.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            AppMethodBeat.o(78097);
            return true;
        }
        String str = oE.fmD;
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            AppMethodBeat.o(78097);
            return true;
        } else if (b.rR(str)) {
            ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(str)));
            AppMethodBeat.o(78097);
            return false;
        } else {
            ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(str)));
            AppMethodBeat.o(78097);
            return true;
        }
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
    }

    public static boolean afE() {
        AppMethodBeat.i(78094);
        String value = ((a) g.K(a.class)).Nu().getValue("SnsImgPreLoadingAroundTimeLimit");
        ab.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(value)));
        if (b.rR(value)) {
            ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            AppMethodBeat.o(78094);
            return false;
        }
        ab.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        AppMethodBeat.o(78094);
        return true;
    }
}
