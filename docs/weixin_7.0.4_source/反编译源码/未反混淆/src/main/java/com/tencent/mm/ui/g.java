package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.r;
import com.tencent.mm.aj.z;
import com.tencent.mm.ce.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e;

public final class g {
    public static int bK(Context context, String str) {
        AppMethodBeat.i(29199);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(29199);
            return 0;
        }
        int i;
        b qC = z.afa().qC(str);
        if (qC == null || (qC.field_userFlag & 2) == 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.o(29199);
            return 0;
        } else if (qC.field_wwExposeTimes < qC.field_wwMaxExposeTimes || p.u(context, "com.tencent.wework")) {
            AppMethodBeat.o(29199);
            return 2;
        } else {
            AppMethodBeat.o(29199);
            return 1;
        }
    }

    public static void bL(Context context, String str) {
        AppMethodBeat.i(29200);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(29200);
            return;
        }
        if (!p.u(context, "com.tencent.wework")) {
            z.afa().qF(str);
        }
        AppMethodBeat.o(29200);
    }

    public static void t(Context context, String str, int i) {
        AppMethodBeat.i(29201);
        if (p.u(context, "com.tencent.wework")) {
            as(str, 4, i);
            AppMethodBeat.o(29201);
            return;
        }
        as(str, 5, i);
        AppMethodBeat.o(29201);
    }

    public static void u(final Context context, final String str, final int i) {
        AppMethodBeat.i(29202);
        as(str, 1, i);
        at(str, 2, i);
        b qD = z.afa().qD(str);
        if (p.u(context, "com.tencent.wework")) {
            Intent launchIntentForPackage;
            as(str, 2, i);
            PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(context, "com.tencent.wework");
            if (bo.isNullOrNil(packageInfo.versionName) || packageInfo.versionName.compareTo("1.3.3") < 0) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String str2 = (i == 2 || i == 4 || i == 6) ? "wxwork://createconversation" : "wxwork://conversationlist";
                intent.setData(Uri.parse(str2));
                launchIntentForPackage = intent;
            }
            a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29198);
                    com.tencent.mm.pluginsdk.model.app.g.b(context, launchIntentForPackage, context.getString(R.string.be2));
                    AppMethodBeat.o(29198);
                }
            });
            AppMethodBeat.o(29202);
        } else if (qD.field_chatOpen || qD.field_use_preset_banner_tips) {
            h.a(context, (int) R.string.be5, 0, (int) R.string.be4, (int) R.string.or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(29196);
                    g.v(context, str, i);
                    AppMethodBeat.o(29196);
                }
            }, null);
            AppMethodBeat.o(29202);
        } else if (qD.field_show_confirm) {
            e.a aVar = new e.a(context);
            aVar.zQK = context.getString(R.string.or);
            aVar.Qg(R.string.be4);
            z.afa();
            z.afa();
            String lb = c.lb(1);
            if (lb == null) {
                aVar.asL(context.getString(R.string.be5));
            } else {
                aVar.asL(lb);
            }
            aVar.a(new e.c() {
                public final void d(boolean z, String str) {
                }
            }, new e.c() {
                public final void d(boolean z, String str) {
                    AppMethodBeat.i(29197);
                    g.v(context, str, i);
                    AppMethodBeat.o(29197);
                }
            }).show();
            AppMethodBeat.o(29202);
        } else {
            v(context, str, i);
            AppMethodBeat.o(29202);
        }
    }

    public static void v(Context context, String str, int i) {
        AppMethodBeat.i(29203);
        as(str, 3, i);
        at(str, 3, i);
        z.aeR();
        String str2 = "https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s";
        Object[] objArr = new Object[1];
        objArr[0] = bo.isNullOrNil(com.tencent.mm.aj.e.qT(str)) ? "off" : "on";
        String format = String.format(str2, objArr);
        FileDownloadTaskInfo Is = d.bij().Is(format);
        if (Is != null && Is.status == 3 && com.tencent.mm.vfs.e.ct(Is.path)) {
            com.tencent.mm.vfs.e.deleteFile(Is.path);
        }
        t.makeText(context, context.getString(R.string.be6), 2000).show();
        com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar.It(format);
        aVar.Iv(context.getString(R.string.be2));
        aVar.tN(1);
        aVar.ga(true);
        d.bij().a(aVar.kNl);
        AppMethodBeat.o(29203);
    }

    private static int as(String str, int i, int i2) {
        AppMethodBeat.i(29204);
        com.tencent.mm.aj.d qP = z.aeR().qP(str);
        if (qP.adQ()) {
            str = qP.adX();
        }
        b qC = z.afa().qC(str);
        int i3 = qC != null ? qC.field_qyUin : 0;
        int i4 = qC != null ? qC.field_userUin : 0;
        long j = qC != null ? qC.field_wwCorpId : 0;
        long j2 = qC != null ? qC.field_wwUserVid : 0;
        com.tencent.mm.plugin.report.service.h.pYm.e(13656, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        ab.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.o(29204);
        return i2;
    }

    public static void ew(String str, int i) {
        AppMethodBeat.i(29205);
        if (i <= 0) {
            AppMethodBeat.o(29205);
            return;
        }
        int i2;
        b qC = z.afa().qC(str);
        int i3 = qC != null ? qC.field_qyUin : 0;
        if (qC != null) {
            i2 = qC.field_userUin;
        } else {
            i2 = 0;
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(13703, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i));
        ab.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.o(29205);
    }

    public static void at(String str, int i, int i2) {
        int i3;
        AppMethodBeat.i(29206);
        com.tencent.mm.aj.d qP = z.aeR().qP(str);
        if (i2 == 3) {
            i3 = 2;
        } else {
            i3 = i2;
        }
        if (i3 == 4) {
            i3 = 3;
        }
        if (qP.adQ()) {
            str = qP.adX();
        }
        b qC = z.afa().qC(str);
        com.tencent.mm.kernel.g.RO().eJo.a(new r(qC, i, i3, new Object()), 0);
        int i4 = qC.field_chatOpen ? 1 : 0;
        int i5 = qC.field_show_confirm ? 1 : 0;
        com.tencent.mm.plugin.report.service.h.pYm.e(15162, Long.valueOf(qC.field_wwCorpId), Long.valueOf(qC.field_wwUserVid), Integer.valueOf(i4), Integer.valueOf(qC.field_wwUnreadCnt), Integer.valueOf(i5), Integer.valueOf(qC.field_userType), Integer.valueOf(i), Integer.valueOf(i3));
        AppMethodBeat.o(29206);
    }
}
