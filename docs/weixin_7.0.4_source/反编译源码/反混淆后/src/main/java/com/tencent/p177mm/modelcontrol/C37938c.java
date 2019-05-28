package com.tencent.p177mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* renamed from: com.tencent.mm.modelcontrol.c */
public class C37938c implements C1816at {
    public static synchronized C37938c afC() {
        C37938c c37938c;
        synchronized (C37938c.class) {
            AppMethodBeat.m2504i(78091);
            c37938c = (C37938c) C7485q.m12925Y(C37938c.class);
            AppMethodBeat.m2505o(78091);
        }
        return c37938c;
    }

    /* renamed from: u */
    public static boolean m64122u(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78092);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
            AppMethodBeat.m2505o(78092);
            return false;
        } else if (!c7620bi.drE()) {
            C4990ab.m7420w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
            AppMethodBeat.m2505o(78092);
            return false;
        } else if (C37938c.m64123v(c7620bi)) {
            boolean afD = C37938c.afD();
            AppMethodBeat.m2505o(78092);
            return afD;
        } else {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
            AppMethodBeat.m2505o(78092);
            return false;
        }
    }

    public static boolean afD() {
        AppMethodBeat.m2504i(78093);
        if (C45448b.afz()) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            AppMethodBeat.m2505o(78093);
            return false;
        }
        int i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(78093);
            return false;
        }
        Context context = C4996ah.getContext();
        if (i == 2 && C5023at.isWifi(context)) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            AppMethodBeat.m2505o(78093);
            return true;
        } else if (i == 1 && C5023at.isWifi(context)) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            AppMethodBeat.m2505o(78093);
            return true;
        } else {
            long j = (long) C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ChatImgAutoDownloadMax"), 0);
            long a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long anl = C5046bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
            long a2 = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, null), 0);
            C4990ab.m7410d("MicroMsg.SubCoreAutoDownload", "currentmonth " + anl + " month " + a2 + " maxcount " + j + " current " + a + " downloadMode: " + i);
            if (anl != a2) {
                C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "update month %d ", Long.valueOf(anl));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(0));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
                a2 = 0;
            } else {
                a2 = a;
            }
            if (a2 > j && j > 0) {
                C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + a2 + " C2C image, can not auto download.");
                AppMethodBeat.m2505o(78093);
                return false;
            } else if (i == 1 && (C5023at.isWifi(context) || C5023at.is3G(context) || C5023at.is4G(context))) {
                C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                AppMethodBeat.m2505o(78093);
                return true;
            } else {
                C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                AppMethodBeat.m2505o(78093);
                return false;
            }
        }
    }

    /* renamed from: a */
    public static boolean m64121a(PInt pInt, PInt pInt2, PInt pInt3) {
        AppMethodBeat.m2504i(78095);
        pInt.value = 0;
        int i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            AppMethodBeat.m2505o(78095);
            return false;
        }
        boolean isWifi = C5023at.isWifi(C4996ah.getContext());
        if (i == 2 && !isWifi) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            AppMethodBeat.m2505o(78095);
            return false;
        } else if (C5023at.is2G(C4996ah.getContext())) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            AppMethodBeat.m2505o(78095);
            return false;
        } else {
            String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SnsSightNoAutoDownload");
            if (!C5046bo.isNullOrNil(value)) {
                try {
                    C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(value)));
                    long j = C5046bo.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) C45448b.afB()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j2 = C5046bo.getLong(split[0], 0);
                    if (j <= C5046bo.getLong(split[1], 0) && j >= j2) {
                        C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        AppMethodBeat.m2505o(78095);
                        return false;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", value, e.getMessage());
                }
            }
            String value2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SnsSightNotAutoDownloadTimeRange");
            C4990ab.m7416i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(value2)));
            if (C45448b.m83719rR(value2)) {
                int i2;
                C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                AppMethodBeat.m2505o(78095);
                return false;
            }
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            AppMethodBeat.m2505o(78095);
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m64120a(PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(78096);
        pInt.value = 0;
        int i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            AppMethodBeat.m2505o(78096);
            return false;
        }
        boolean isWifi = C5023at.isWifi(C4996ah.getContext());
        if (i == 2 && !isWifi) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            AppMethodBeat.m2505o(78096);
            return false;
        } else if (C5023at.is2G(C4996ah.getContext())) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            AppMethodBeat.m2505o(78096);
            return false;
        } else {
            String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SnsAdSightNotAutoDownloadTimeRange");
            C4990ab.m7416i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(value)));
            if (C45448b.m83719rR(value)) {
                int i2;
                C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                AppMethodBeat.m2505o(78096);
                return false;
            }
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            AppMethodBeat.m2505o(78096);
            return true;
        }
    }

    /* renamed from: v */
    public static boolean m64123v(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78097);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            AppMethodBeat.m2505o(78097);
            return false;
        }
        C1828b oE = C1829bf.m3758oE(c7620bi.dqJ);
        if (oE == null) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            AppMethodBeat.m2505o(78097);
            return true;
        }
        String str = oE.fmD;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            AppMethodBeat.m2505o(78097);
            return true;
        } else if (C45448b.m83719rR(str)) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(78097);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(78097);
            return true;
        }
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
    }

    public static boolean afE() {
        AppMethodBeat.m2504i(78094);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SnsImgPreLoadingAroundTimeLimit");
        C4990ab.m7416i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(value)));
        if (C45448b.m83719rR(value)) {
            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            AppMethodBeat.m2505o(78094);
            return false;
        }
        C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        AppMethodBeat.m2505o(78094);
        return true;
    }
}
