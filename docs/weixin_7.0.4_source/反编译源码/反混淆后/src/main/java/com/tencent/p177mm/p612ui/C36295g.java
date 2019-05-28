package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C36692b;
import com.tencent.p177mm.p184aj.C41745r;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8927c;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.g */
public final class C36295g {

    /* renamed from: com.tencent.mm.ui.g$2 */
    static class C240042 implements C5662c {
        C240042() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
        }
    }

    /* renamed from: bK */
    public static int m59747bK(Context context, String str) {
        AppMethodBeat.m2504i(29199);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(29199);
            return 0;
        }
        int i;
        C36692b qC = C41747z.afa().mo20347qC(str);
        if (qC == null || (qC.field_userFlag & 2) == 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.m2505o(29199);
            return 0;
        } else if (qC.field_wwExposeTimes < qC.field_wwMaxExposeTimes || C35799p.m58695u(context, "com.tencent.wework")) {
            AppMethodBeat.m2505o(29199);
            return 2;
        } else {
            AppMethodBeat.m2505o(29199);
            return 1;
        }
    }

    /* renamed from: bL */
    public static void m59748bL(Context context, String str) {
        AppMethodBeat.m2504i(29200);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(29200);
            return;
        }
        if (!C35799p.m58695u(context, "com.tencent.wework")) {
            C41747z.afa().mo20350qF(str);
        }
        AppMethodBeat.m2505o(29200);
    }

    /* renamed from: t */
    public static void m59750t(Context context, String str, int i) {
        AppMethodBeat.m2504i(29201);
        if (C35799p.m58695u(context, "com.tencent.wework")) {
            C36295g.m59745as(str, 4, i);
            AppMethodBeat.m2505o(29201);
            return;
        }
        C36295g.m59745as(str, 5, i);
        AppMethodBeat.m2505o(29201);
    }

    /* renamed from: u */
    public static void m59751u(final Context context, final String str, final int i) {
        AppMethodBeat.m2504i(29202);
        C36295g.m59745as(str, 1, i);
        C36295g.m59746at(str, 2, i);
        C36692b qD = C41747z.afa().mo20348qD(str);
        if (C35799p.m58695u(context, "com.tencent.wework")) {
            Intent launchIntentForPackage;
            C36295g.m59745as(str, 2, i);
            PackageInfo packageInfo = C19679b.getPackageInfo(context, "com.tencent.wework");
            if (C5046bo.isNullOrNil(packageInfo.versionName) || packageInfo.versionName.compareTo("1.3.3") < 0) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String str2 = (i == 2 || i == 4 || i == 6) ? "wxwork://createconversation" : "wxwork://conversationlist";
                intent.setData(Uri.parse(str2));
                launchIntentForPackage = intent;
            }
            C26006a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(29198);
                    C46494g.m87736b(context, launchIntentForPackage, context.getString(C25738R.string.be2));
                    AppMethodBeat.m2505o(29198);
                }
            });
            AppMethodBeat.m2505o(29202);
        } else if (qD.field_chatOpen || qD.field_use_preset_banner_tips) {
            C30379h.m48428a(context, (int) C25738R.string.be5, 0, (int) C25738R.string.be4, (int) C25738R.string.f9076or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(29196);
                    C36295g.m59752v(context, str, i);
                    AppMethodBeat.m2505o(29196);
                }
            }, null);
            AppMethodBeat.m2505o(29202);
        } else if (qD.field_show_confirm) {
            C5659a c5659a = new C5659a(context);
            c5659a.zQK = context.getString(C25738R.string.f9076or);
            c5659a.mo11509Qg(C25738R.string.be4);
            C41747z.afa();
            C41747z.afa();
            String lb = C8927c.m16091lb(1);
            if (lb == null) {
                c5659a.asL(context.getString(C25738R.string.be5));
            } else {
                c5659a.asL(lb);
            }
            c5659a.mo11513a(new C240042(), new C5662c() {
                /* renamed from: d */
                public final void mo5699d(boolean z, String str) {
                    AppMethodBeat.m2504i(29197);
                    C36295g.m59752v(context, str, i);
                    AppMethodBeat.m2505o(29197);
                }
            }).show();
            AppMethodBeat.m2505o(29202);
        } else {
            C36295g.m59752v(context, str, i);
            AppMethodBeat.m2505o(29202);
        }
    }

    /* renamed from: v */
    public static void m59752v(Context context, String str, int i) {
        AppMethodBeat.m2504i(29203);
        C36295g.m59745as(str, 3, i);
        C36295g.m59746at(str, 3, i);
        C41747z.aeR();
        String str2 = "https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s";
        Object[] objArr = new Object[1];
        objArr[0] = C5046bo.isNullOrNil(C25764e.m40952qT(str)) ? "off" : "on";
        String format = String.format(str2, objArr);
        FileDownloadTaskInfo Is = C2896d.bij().mo7041Is(format);
        if (Is != null && Is.status == 3 && C5730e.m8628ct(Is.path)) {
            C5730e.deleteFile(Is.path);
        }
        C23639t.makeText(context, context.getString(C25738R.string.be6), 2000).show();
        C2901a c2901a = new C2901a();
        c2901a.mo7055It(format);
        c2901a.mo7057Iv(context.getString(C25738R.string.be2));
        c2901a.mo7069tN(1);
        c2901a.mo7063ga(true);
        C2896d.bij().mo7042a(c2901a.kNl);
        AppMethodBeat.m2505o(29203);
    }

    /* renamed from: as */
    private static int m59745as(String str, int i, int i2) {
        AppMethodBeat.m2504i(29204);
        C16527d qP = C41747z.aeR().mo43729qP(str);
        if (qP.adQ()) {
            str = qP.adX();
        }
        C36692b qC = C41747z.afa().mo20347qC(str);
        int i3 = qC != null ? qC.field_qyUin : 0;
        int i4 = qC != null ? qC.field_userUin : 0;
        long j = qC != null ? qC.field_wwCorpId : 0;
        long j2 = qC != null ? qC.field_wwUserVid : 0;
        C7060h.pYm.mo8381e(13656, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        C4990ab.m7411d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.m2505o(29204);
        return i2;
    }

    /* renamed from: ew */
    public static void m59749ew(String str, int i) {
        AppMethodBeat.m2504i(29205);
        if (i <= 0) {
            AppMethodBeat.m2505o(29205);
            return;
        }
        int i2;
        C36692b qC = C41747z.afa().mo20347qC(str);
        int i3 = qC != null ? qC.field_qyUin : 0;
        if (qC != null) {
            i2 = qC.field_userUin;
        } else {
            i2 = 0;
        }
        C7060h.pYm.mo8381e(13703, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i));
        C4990ab.m7411d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.m2505o(29205);
    }

    /* renamed from: at */
    public static void m59746at(String str, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(29206);
        C16527d qP = C41747z.aeR().mo43729qP(str);
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
        C36692b qC = C41747z.afa().mo20347qC(str);
        C1720g.m3535RO().eJo.mo14541a(new C41745r(qC, i, i3, new Object()), 0);
        int i4 = qC.field_chatOpen ? 1 : 0;
        int i5 = qC.field_show_confirm ? 1 : 0;
        C7060h.pYm.mo8381e(15162, Long.valueOf(qC.field_wwCorpId), Long.valueOf(qC.field_wwUserVid), Integer.valueOf(i4), Integer.valueOf(qC.field_wwUnreadCnt), Integer.valueOf(i5), Integer.valueOf(qC.field_userType), Integer.valueOf(i), Integer.valueOf(i3));
        AppMethodBeat.m2505o(29206);
    }
}
