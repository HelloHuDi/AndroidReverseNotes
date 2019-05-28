package com.tencent.mm.protocal;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.smtt.sdk.TbsDownloader;
import junit.framework.Assert;

public final class d extends e {
    public static final String DEVICE_NAME = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static String eSg = ("android-" + VERSION.SDK_INT);
    public static final String vxi = Build.BRAND;
    public static final String vxj = (Build.MODEL + Build.CPU_ABI);
    public static String vxk = ("android-" + VERSION.SDK_INT);
    public static final String vxl = ("android-" + Build.MANUFACTURER);
    public static String vxm = (VERSION.SDK_INT);
    public static long vxn = 0;
    public static int vxo;
    public static boolean vxp = dmg();
    public static boolean vxq = dmf();
    public static boolean vxr = dmd();
    public static boolean vxs = dme();
    public static int vxt = 5;
    public static final byte[] vxu = null;
    public static final byte[] vxv = null;
    public static final byte[] vxw = null;

    public static void Lw(int i) {
        AppMethodBeat.i(58788);
        vxo = i;
        vxr = dmd();
        vxp = dmg();
        vxq = dmf();
        vxs = dme();
        AppMethodBeat.o(58788);
    }

    static {
        AppMethodBeat.i(58789);
        vxo = Integer.decode(f.CLIENT_VERSION).intValue();
        Assert.assertNotNull(f.CLIENT_VERSION);
        try {
            int i = ah.getContext().getPackageManager().getApplicationInfo(ah.getPackageName(), 128).metaData.getInt(TbsDownloader.TBS_METADATA);
            if (i > vxo && i - vxo < 255 && (i & 255) >= 48) {
                vxo = i;
            }
        } catch (Exception e) {
            ab.b("MicroMsg.ConstantsProtocal", "", e);
        }
        AppMethodBeat.o(58789);
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
