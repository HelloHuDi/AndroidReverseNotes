package com.tencent.mm.compatible.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class q {
    public static o etb = new o();
    public static c etc = new c();
    public static b etd = new b();
    public static x ete = new x();
    public static ac etf = new ac();
    public static s etg = new s();
    public static w eth = new w();
    public static aa eti = new aa();
    public static v etj = new v();
    public static v etk = new v();
    public static a etl = new a();
    private static int etm = -1;
    public static k etn = new k();
    public static p eto = new p();
    private static final au etp = new au("DeviceInfo", TimeUnit.DAYS.toMillis(1));
    private static String etq = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.i(92964);
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                AppMethodBeat.o(92964);
                return true;
            }
            AppMethodBeat.o(92964);
            return false;
        }
    }

    static {
        AppMethodBeat.i(92990);
        AppMethodBeat.o(92990);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void eV(long j) {
        AppMethodBeat.i(92965);
        au auVar = etp;
        String concat = "idkey_1008_".concat(String.valueOf(j));
        if (concat == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("key is null.");
            AppMethodBeat.o(92965);
            throw illegalArgumentException;
        }
        long currentTimeMillis;
        boolean z;
        auVar.dpe();
        if (auVar.xAv) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = SystemClock.elapsedRealtime();
        }
        if (!auVar.xAy.containsKey(concat)) {
            auVar.xAy.put(concat, Long.valueOf(currentTimeMillis));
            auVar.xAx.edit().putLong(concat, currentTimeMillis).apply();
        } else if (currentTimeMillis - ((Long) auVar.xAy.get(concat)).longValue() > auVar.xAz) {
            auVar.xAy.put(concat, Long.valueOf(currentTimeMillis));
            auVar.xAx.edit().putLong(concat, currentTimeMillis).apply();
            z = true;
            if (z) {
                e.pXa.a(1008, j, 1, false);
            }
            AppMethodBeat.o(92965);
        }
        z = false;
        if (z) {
        }
        AppMethodBeat.o(92965);
    }

    @Deprecated
    public static String LK() {
        AppMethodBeat.i(92966);
        eV(11);
        String str = (String) l.Lu().get(d.MIC_PTU_ZIPAI_SAPPORO);
        if (str != null) {
            eV(0);
            if ("1234567890ABCDEF".equals(str)) {
                eV(1);
            } else {
                eV(2);
            }
            AppMethodBeat.o(92966);
        } else {
            str = getDeviceID(ah.getContext());
            if (str == null) {
                eV(4);
                str = "1234567890ABCDEF";
            } else {
                eV(3);
            }
            l.Lu().set(d.MIC_PTU_ZIPAI_SAPPORO, str);
            AppMethodBeat.o(92966);
        }
        return str;
    }

    public static String LL() {
        AppMethodBeat.i(92967);
        eV(12);
        String str = (String) l.Lu().get(d.MIC_PTU_ZIPAI_SAPPORO);
        if (bo.isNullOrNil(str) || "1234567890ABCDEF".equals(str)) {
            as amF = as.amF("sysinfo_258");
            str = amF.getString("k_i_m_e_i", "1234567890ABCDEF");
            if ("1234567890ABCDEF".equals(str)) {
                Context context = ah.getContext();
                if (context == null) {
                    ab.e("MicroMsg.DeviceInfo", "context is null, return fake device id now.");
                    eV(10);
                    str = "1234567890ABCDEF";
                    AppMethodBeat.o(92967);
                    return str;
                }
                str = bo.gN(context);
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.DeviceInfo", "fail to get device id from system, return fake one instead.");
                    eV(10);
                    str = "1234567890ABCDEF";
                    AppMethodBeat.o(92967);
                    return str;
                }
                amF.edit().putString("k_i_m_e_i", str).apply();
                eV(9);
                AppMethodBeat.o(92967);
                return str;
            }
            ab.i("MicroMsg.DeviceInfo", "new cache's device id was chosen to be returned.");
            eV(8);
            AppMethodBeat.o(92967);
            return str;
        }
        ab.w("MicroMsg.DeviceInfo", "old cache's device id was chosen to be returned.");
        eV(7);
        AppMethodBeat.o(92967);
        return str;
    }

    public static String getDeviceID(Context context) {
        AppMethodBeat.i(92968);
        String gN = bo.gN(context);
        if (bo.isNullOrNil(gN)) {
            eV(6);
        } else {
            eV(5);
        }
        AppMethodBeat.o(92968);
        return gN;
    }

    public static String LM() {
        AppMethodBeat.i(92969);
        String bH = bH(false);
        AppMethodBeat.o(92969);
        return bH;
    }

    public static String bH(boolean z) {
        AppMethodBeat.i(92970);
        if (z || etq == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Secure.getString(ah.getContext().getContentResolver(), "android_id"));
            stringBuilder.append(bI(z));
            stringBuilder.append(LO());
            etq = "A" + g.x(stringBuilder.toString().getBytes()).substring(0, 15);
            ab.w("MicroMsg.DeviceInfo", "guid:%s, dev=%s", etq, r0);
        }
        String str = etq;
        AppMethodBeat.o(92970);
        return str;
    }

    public static boolean LN() {
        return etq != null;
    }

    private static String LO() {
        AppMethodBeat.i(92971);
        String str = (String) l.Lu().get(d.MIC_PTU_ZIPAI_MEDSEA);
        if (str != null) {
            ab.d("MicroMsg.DeviceInfo", "getHardWareId from file ".concat(String.valueOf(str)));
            AppMethodBeat.o(92971);
            return str;
        }
        str = Build.MANUFACTURER + Build.MODEL + n.LB();
        l.Lu().set(d.MIC_PTU_ZIPAI_MEDSEA, str);
        ab.d("MicroMsg.DeviceInfo", "getHardWareId ".concat(String.valueOf(str)));
        AppMethodBeat.o(92971);
        return str;
    }

    public static String LP() {
        String macAddress;
        AppMethodBeat.i(92972);
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            macAddress = connectionInfo.getMacAddress();
        } else {
            macAddress = null;
        }
        AppMethodBeat.o(92972);
        return macAddress;
    }

    public static String LQ() {
        AppMethodBeat.i(92973);
        String str = null;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            str = defaultAdapter.getAddress();
        }
        AppMethodBeat.o(92973);
        return str;
    }

    private static String bI(boolean z) {
        String str;
        AppMethodBeat.i(92974);
        if (!z) {
            str = (String) l.Lu().get(256);
            if (str != null) {
                AppMethodBeat.o(92974);
                return str;
            }
        }
        str = LR();
        l.Lu().set(256, str);
        AppMethodBeat.o(92974);
        return str;
    }

    private static String LR() {
        Object obj;
        int i = 0;
        AppMethodBeat.i(92975);
        String gN = bo.gN(ah.getContext());
        if (gN == null || gN.length() <= 0) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            obj = "A";
            while (i < 15) {
                obj = obj + ((char) (random.nextInt(25) + 65));
                i++;
            }
        } else {
            obj = ("A" + gN + "123456789ABCDEF").substring(0, 15);
        }
        ab.w("MicroMsg.DeviceInfo", "generated deviceId=".concat(String.valueOf(obj)));
        AppMethodBeat.o(92975);
        return obj;
    }

    public static void ku(String str) {
        AppMethodBeat.i(92976);
        ab.i("MicroMsg.DeviceInfo", "update deviceInfo %s", str);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(92976);
        } else if (str.hashCode() == etm) {
            AppMethodBeat.o(92976);
        } else {
            etm = str.hashCode();
            etb.reset();
            etc.reset();
            etd.reset();
            etn.reset();
            ete.reset();
            etf.reset();
            s sVar = etg;
            sVar.etr = 0;
            sVar.ets = 0;
            w wVar = eth;
            wVar.etR = "";
            wVar.etS = null;
            aa aaVar = eti;
            aaVar.cOQ = false;
            aaVar.eue = 0;
            aaVar.euf = false;
            etj.reset();
            etk.reset();
            a aVar = etl;
            aVar.epE = false;
            aVar.epF = "";
            r rVar = new r();
            if (r.a(str, etb, etc, etd, etn, ete, etf, etg, eth, eti, etj, etl, etk)) {
                ab.i("MicroMsg.DeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + etc.erz);
                com.tencent.mm.sdk.b.a.xxA.m(new cj());
                AppMethodBeat.o(92976);
                return;
            }
            AppMethodBeat.o(92976);
        }
    }

    public static String LS() {
        return Build.MODEL;
    }

    public static String bB(Context context) {
        AppMethodBeat.i(92977);
        String str;
        try {
            ab.i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", aa.gw(context));
            if (eth == null || eth.etS == null || eth.etS.size() == 0) {
                ab.i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", Build.MANUFACTURER);
                str = Build.MANUFACTURER;
                AppMethodBeat.o(92977);
                return str;
            }
            str = (String) eth.etS.get(".manufacturerName." + aa.gw(context));
            ab.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (bo.isNullOrNil(str)) {
                str = (String) eth.etS.get(".manufacturerName.en");
                ab.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
                if (bo.isNullOrNil(str)) {
                    str = Build.MANUFACTURER;
                    AppMethodBeat.o(92977);
                    return str;
                }
                AppMethodBeat.o(92977);
                return str;
            }
            AppMethodBeat.o(92977);
            return str;
        } catch (Exception e) {
            str = Build.MANUFACTURER;
            AppMethodBeat.o(92977);
            return str;
        }
    }

    public static String bC(Context context) {
        AppMethodBeat.i(92978);
        String simOperatorName;
        try {
            simOperatorName = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            AppMethodBeat.o(92978);
            return simOperatorName;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getMobileSPType", new Object[0]);
            simOperatorName = "";
            AppMethodBeat.o(92978);
            return simOperatorName;
        }
    }

    public static String getSimCountryIso() {
        AppMethodBeat.i(92979);
        TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            ab.i("MicroMsg.DeviceInfo", "get isoCode:[%s]", telephonyManager.getSimCountryIso());
            AppMethodBeat.o(92979);
            return telephonyManager.getSimCountryIso();
        }
        AppMethodBeat.o(92979);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007b A:{SYNTHETIC, Splitter:B:16:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086 A:{SYNTHETIC, Splitter:B:22:0x0086} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String[] LT() {
        Throwable th;
        BufferedReader bufferedReader;
        AppMethodBeat.i(92980);
        String[] strArr = new String[]{"", AppEventsConstants.EVENT_PARAM_VALUE_NO};
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                String[] split = bo.nullAsNil(bufferedReader2.readLine()).split("\\s+");
                for (int i = 2; i < split.length; i++) {
                    strArr[0] = strArr[0] + split[i] + " ";
                }
                strArr[1] = bo.nullAsNil(bufferedReader2.readLine()).split("\\s+")[2];
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                }
            } catch (IOException e2) {
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.o(92980);
                return strArr;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(92980);
                throw th;
            }
        } catch (IOException e3) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e4) {
                }
            }
            AppMethodBeat.o(92980);
            return strArr;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.o(92980);
            throw th;
        }
        AppMethodBeat.o(92980);
        return strArr;
    }

    public static String getAndroidId() {
        AppMethodBeat.i(92981);
        ab.i("MicroMsg.DeviceInfo", "androidid:[%s]", Secure.getString(ah.getContext().getContentResolver(), "android_id"));
        AppMethodBeat.o(92981);
        return Secure.getString(ah.getContext().getContentResolver(), "android_id");
    }

    public static String LU() {
        AppMethodBeat.i(92982);
        String str = null;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                str = defaultAdapter.getAddress();
            }
            str = bo.nullAsNil(str);
            AppMethodBeat.o(92982);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", bo.l(e));
            str = "";
            AppMethodBeat.o(92982);
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    public static String LV() {
        AppMethodBeat.i(92983);
        String str = null;
        try {
            if (VERSION.SDK_INT >= 14) {
                str = Build.getRadioVersion();
            } else {
                str = Build.RADIO;
            }
        } catch (IncompatibleClassChangeError e) {
            ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
            AppMethodBeat.o(92983);
            throw e2;
        } catch (Throwable th) {
        }
        str = bo.nullAsNil(str);
        AppMethodBeat.o(92983);
        return str;
    }

    public static String LW() {
        return VERSION.RELEASE;
    }

    public static String LX() {
        AppMethodBeat.i(92984);
        String nullAsNil;
        try {
            nullAsNil = bo.nullAsNil(((TelephonyManager) ah.getContext().getSystemService("phone")).getSubscriberId());
            AppMethodBeat.o(92984);
            return nullAsNil;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneIMSI", new Object[0]);
            nullAsNil = "";
            AppMethodBeat.o(92984);
            return nullAsNil;
        }
    }

    public static String LY() {
        AppMethodBeat.i(92985);
        String nullAsNil;
        try {
            nullAsNil = bo.nullAsNil(((TelephonyManager) ah.getContext().getSystemService("phone")).getSimSerialNumber());
            AppMethodBeat.o(92985);
            return nullAsNil;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneICCID", new Object[0]);
            nullAsNil = "";
            AppMethodBeat.o(92985);
            return nullAsNil;
        }
    }

    @SuppressLint({"NewApi"})
    public static String LZ() {
        AppMethodBeat.i(92986);
        String str = null;
        if (VERSION.SDK_INT >= 9) {
            str = Build.SERIAL;
        }
        str = bo.nullAsNil(str);
        AppMethodBeat.o(92986);
        return str;
    }

    public static Map<String, String> Ma() {
        Throwable e;
        AppMethodBeat.i(92987);
        HashMap hashMap = new HashMap();
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.trim().equals("")) {
                        String[] split = readLine.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (split.length > 1) {
                            hashMap.put(split[0].trim().toLowerCase(), split[1].trim());
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getInfoMapOfCpu() failed.", new Object[0]);
                        bo.b(bufferedReader);
                        AppMethodBeat.o(92987);
                        return hashMap;
                    } catch (Throwable th) {
                        e = th;
                        bo.b(bufferedReader);
                        AppMethodBeat.o(92987);
                        throw e;
                    }
                }
            }
            bo.b(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getInfoMapOfCpu() failed.", new Object[0]);
            bo.b(bufferedReader);
            AppMethodBeat.o(92987);
            return hashMap;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(92987);
            throw e;
        }
        AppMethodBeat.o(92987);
        return hashMap;
    }

    public static int Mb() {
        AppMethodBeat.i(92988);
        try {
            int length = new File("/sys/devices/system/cpu").listFiles(new a()).length;
            AppMethodBeat.o(92988);
            return length;
        } catch (Exception e) {
            AppMethodBeat.o(92988);
            return 1;
        }
    }

    public static String Mc() {
        AppMethodBeat.i(92989);
        String str = "android-" + Build.MODEL + "-" + VERSION.SDK_INT;
        AppMethodBeat.o(92989);
        return str;
    }
}
