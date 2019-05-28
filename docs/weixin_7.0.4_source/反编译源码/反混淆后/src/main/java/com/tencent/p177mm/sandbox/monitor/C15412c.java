package com.tencent.p177mm.sandbox.monitor;

import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.p209c.C45275c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sandbox.C35974b;
import com.tencent.p177mm.sandbox.updater.C44212i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.sandbox.monitor.c */
public abstract class C15412c implements C35974b {
    public static final String xvv = C6457e.eSn;
    private boolean xvA = false;
    protected int xvw;
    public int xvx;
    public int xvy;
    public String xvz;

    public C15412c(int i, String str, int i2, boolean z) {
        this.xvx = i;
        this.xvz = str;
        this.xvw = i2;
        this.xvA = z;
        this.xvy = C1173e.m2560cs(alN());
        File file = new File(xvv);
        if (!file.exists()) {
            file.mkdirs();
        }
        C4990ab.m7410d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + alN() + " packOffset = " + this.xvy);
    }

    public String alN() {
        return xvv + this.xvz + ".temp";
    }

    public String dne() {
        return xvv + this.xvz + ".apk";
    }

    public final void deleteTempFile() {
        try {
            C4990ab.m7410d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(alN());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            C4990ab.m7412e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean alZ(String str) {
        if (C1173e.m2561ct(xvv + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String ama(String str) {
        String str2 = xvv + str + ".apk";
        return (C1173e.m2561ct(str2) && C32429a.m53087cM(str2)) ? str2 : null;
    }

    /* renamed from: RP */
    public static String m23693RP(String str) {
        return C15412c.m23694bY(str, false);
    }

    /* renamed from: bY */
    public static String m23694bY(String str, boolean z) {
        String str2 = xvv + str + ".temp";
        String str3 = xvv + str + ".apk";
        if (C1173e.m2561ct(str2) && !z && (C32429a.m53087cM(str2) || str.equalsIgnoreCase(C1178g.m2587cz(str2)))) {
            C1173e.m2572h(xvv, str + ".temp", str + ".apk");
            return str3;
        }
        if (C1173e.m2561ct(str3)) {
            if (C32429a.m53087cM(str3)) {
                C4990ab.m7416i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                return str3;
            }
            str2 = null;
            try {
                str2 = C45275c.m83484y(new File(str3));
                if (C5046bo.isNullOrNil(str2)) {
                    C7060h.pYm.mo8378a(322, 10, 1, false);
                    C7060h.pYm.mo8381e(11098, Integer.valueOf(4010));
                }
            } catch (Exception e) {
                C4990ab.m7420w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + e.getMessage());
                C7060h.pYm.mo8378a(322, 9, 1, false);
                C7060h.pYm.mo8381e(11098, Integer.valueOf(4009), r10.getMessage());
            }
            C4990ab.m7417i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
            if (!C5046bo.isNullOrNil(str2)) {
                C4990ab.m7417i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, C44212i.dns());
                if (str2.equals(C44212i.dns())) {
                    C4990ab.m7416i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                    return str3;
                }
                C4990ab.m7416i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                C7060h.pYm.mo8378a(322, 11, 1, false);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4011);
                objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                c7060h.mo8381e(11098, objArr);
            } else if (str.equalsIgnoreCase(C1178g.m2587cz(str3))) {
                C4990ab.m7416i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                return str3;
            }
            C4990ab.m7412e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
            C1173e.deleteFile(str3);
        }
        return null;
    }

    public final boolean dnf() {
        if (!this.xvA || C5023at.isWifi(C4996ah.getContext())) {
            return false;
        }
        return true;
    }
}
