package com.tencent.p177mm.protocal;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.smtt.sdk.TbsDownloader;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.protocal.d */
public final class C7243d extends C4814e {
    public static final String DEVICE_NAME = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static String eSg = ("android-" + VERSION.SDK_INT);
    public static final String vxi = Build.BRAND;
    public static final String vxj = (Build.MODEL + Build.CPU_ABI);
    public static String vxk = ("android-" + VERSION.SDK_INT);
    public static final String vxl = ("android-" + Build.MANUFACTURER);
    public static String vxm = (VERSION.SDK_INT);
    public static long vxn = 0;
    public static int vxo;
    public static boolean vxp = C7243d.dmg();
    public static boolean vxq = C7243d.dmf();
    public static boolean vxr = C7243d.dmd();
    public static boolean vxs = C7243d.dme();
    public static int vxt = 5;
    public static final byte[] vxu = null;
    public static final byte[] vxv = null;
    public static final byte[] vxw = null;

    /* renamed from: Lw */
    public static void m12106Lw(int i) {
        AppMethodBeat.m2504i(58788);
        vxo = i;
        vxr = C7243d.dmd();
        vxp = C7243d.dmg();
        vxq = C7243d.dmf();
        vxs = C7243d.dme();
        AppMethodBeat.m2505o(58788);
    }

    static {
        AppMethodBeat.m2504i(58789);
        vxo = Integer.decode(C5058f.CLIENT_VERSION).intValue();
        Assert.assertNotNull(C5058f.CLIENT_VERSION);
        try {
            int i = C4996ah.getContext().getPackageManager().getApplicationInfo(C4996ah.getPackageName(), 128).metaData.getInt(TbsDownloader.TBS_METADATA);
            if (i > vxo && i - vxo < 255 && (i & 255) >= 48) {
                vxo = i;
            }
        } catch (Exception e) {
            C4990ab.m7408b("MicroMsg.ConstantsProtocal", "", e);
        }
        AppMethodBeat.m2505o(58789);
    }

    private static boolean dmd() {
        return (vxo & 255) >= 0 && (vxo & 255) <= 47;
    }

    private static boolean dme() {
        return (vxo & 255) >= 0 && (vxo & 255) <= 15;
    }

    private static boolean dmf() {
        return (vxo & 255) >= 96 && (vxo & 255) <= 255;
    }

    private static boolean dmg() {
        return (vxo & 255) >= 48 && (vxo & 255) <= 95;
    }
}
