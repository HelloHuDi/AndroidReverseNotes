package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public abstract class c implements b {
    public static final String xvv = e.eSn;
    private boolean xvA = false;
    protected int xvw;
    public int xvx;
    public int xvy;
    public String xvz;

    public c(int i, String str, int i2, boolean z) {
        this.xvx = i;
        this.xvz = str;
        this.xvw = i2;
        this.xvA = z;
        this.xvy = com.tencent.mm.a.e.cs(alN());
        File file = new File(xvv);
        if (!file.exists()) {
            file.mkdirs();
        }
        ab.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + alN() + " packOffset = " + this.xvy);
    }

    public String alN() {
        return xvv + this.xvz + ".temp";
    }

    public String dne() {
        return xvv + this.xvz + ".apk";
    }

    public final void deleteTempFile() {
        try {
            ab.d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(alN());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            ab.e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean alZ(String str) {
        if (com.tencent.mm.a.e.ct(xvv + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String ama(String str) {
        String str2 = xvv + str + ".apk";
        return (com.tencent.mm.a.e.ct(str2) && a.cM(str2)) ? str2 : null;
    }

    public static String RP(String str) {
        return bY(str, false);
    }

    public static String bY(String str, boolean z) {
        String str2 = xvv + str + ".temp";
        String str3 = xvv + str + ".apk";
        if (com.tencent.mm.a.e.ct(str2) && !z && (a.cM(str2) || str.equalsIgnoreCase(g.cz(str2)))) {
            com.tencent.mm.a.e.h(xvv, str + ".temp", str + ".apk");
            return str3;
        }
        if (com.tencent.mm.a.e.ct(str3)) {
            if (a.cM(str3)) {
                ab.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                return str3;
            }
            str2 = null;
            try {
                str2 = com.tencent.mm.c.c.y(new File(str3));
                if (bo.isNullOrNil(str2)) {
                    h.pYm.a(322, 10, 1, false);
                    h.pYm.e(11098, Integer.valueOf(4010));
                }
            } catch (Exception e) {
                ab.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + e.getMessage());
                h.pYm.a(322, 9, 1, false);
                h.pYm.e(11098, Integer.valueOf(4009), r10.getMessage());
            }
            ab.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
            if (!bo.isNullOrNil(str2)) {
                ab.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, i.dns());
                if (str2.equals(i.dns())) {
                    ab.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                    return str3;
                }
                ab.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                h.pYm.a(322, 11, 1, false);
                h hVar = h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4011);
                objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                hVar.e(11098, objArr);
            } else if (str.equalsIgnoreCase(g.cz(str3))) {
                ab.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                return str3;
            }
            ab.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
            com.tencent.mm.a.e.deleteFile(str3);
        }
        return null;
    }

    public final boolean dnf() {
        if (!this.xvA || at.isWifi(ah.getContext())) {
            return false;
        }
        return true;
    }
}
