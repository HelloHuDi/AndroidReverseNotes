package com.tencent.p177mm.compatible.p221e;

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
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C6467cj;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5024au;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
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

/* renamed from: com.tencent.mm.compatible.e.q */
public final class C1427q {
    public static C1423o etb = new C1423o();
    public static C1418c etc = new C1418c();
    public static C1416b etd = new C1416b();
    public static C1432x ete = new C1432x();
    public static C1415ac etf = new C1415ac();
    public static C1429s etg = new C1429s();
    public static C1431w eth = new C1431w();
    public static C1413aa eti = new C1413aa();
    public static C1430v etj = new C1430v();
    public static C1430v etk = new C1430v();
    public static C1412a etl = new C1412a();
    private static int etm = -1;
    public static C1419k etn = new C1419k();
    public static C1425p eto = new C1425p();
    private static final C5024au etp = new C5024au("DeviceInfo", TimeUnit.DAYS.toMillis(1));
    private static String etq = null;

    /* renamed from: com.tencent.mm.compatible.e.q$a */
    class C1426a implements FileFilter {
        C1426a() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.m2504i(92964);
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                AppMethodBeat.m2505o(92964);
                return true;
            }
            AppMethodBeat.m2505o(92964);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(92990);
        AppMethodBeat.m2505o(92990);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: eV */
    private static void m3049eV(long j) {
        AppMethodBeat.m2504i(92965);
        C5024au c5024au = etp;
        String concat = "idkey_1008_".concat(String.valueOf(j));
        if (concat == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("key is null.");
            AppMethodBeat.m2505o(92965);
            throw illegalArgumentException;
        }
        long currentTimeMillis;
        boolean z;
        c5024au.dpe();
        if (c5024au.xAv) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = SystemClock.elapsedRealtime();
        }
        if (!c5024au.xAy.containsKey(concat)) {
            c5024au.xAy.put(concat, Long.valueOf(currentTimeMillis));
            c5024au.xAx.edit().putLong(concat, currentTimeMillis).apply();
        } else if (currentTimeMillis - ((Long) c5024au.xAy.get(concat)).longValue() > c5024au.xAz) {
            c5024au.xAy.put(concat, Long.valueOf(currentTimeMillis));
            c5024au.xAx.edit().putLong(concat, currentTimeMillis).apply();
            z = true;
            if (z) {
                C7053e.pXa.mo8378a(1008, j, 1, false);
            }
            AppMethodBeat.m2505o(92965);
        }
        z = false;
        if (z) {
        }
        AppMethodBeat.m2505o(92965);
    }

    @Deprecated
    /* renamed from: LK */
    public static String m3026LK() {
        AppMethodBeat.m2504i(92966);
        C1427q.m3049eV(11);
        String str = (String) C1420l.m3008Lu().get(C31128d.MIC_PTU_ZIPAI_SAPPORO);
        if (str != null) {
            C1427q.m3049eV(0);
            if ("1234567890ABCDEF".equals(str)) {
                C1427q.m3049eV(1);
            } else {
                C1427q.m3049eV(2);
            }
            AppMethodBeat.m2505o(92966);
        } else {
            str = C1427q.getDeviceID(C4996ah.getContext());
            if (str == null) {
                C1427q.m3049eV(4);
                str = "1234567890ABCDEF";
            } else {
                C1427q.m3049eV(3);
            }
            C1420l.m3008Lu().set(C31128d.MIC_PTU_ZIPAI_SAPPORO, str);
            AppMethodBeat.m2505o(92966);
        }
        return str;
    }

    /* renamed from: LL */
    public static String m3027LL() {
        AppMethodBeat.m2504i(92967);
        C1427q.m3049eV(12);
        String str = (String) C1420l.m3008Lu().get(C31128d.MIC_PTU_ZIPAI_SAPPORO);
        if (C5046bo.isNullOrNil(str) || "1234567890ABCDEF".equals(str)) {
            C5018as amF = C5018as.amF("sysinfo_258");
            str = amF.getString("k_i_m_e_i", "1234567890ABCDEF");
            if ("1234567890ABCDEF".equals(str)) {
                Context context = C4996ah.getContext();
                if (context == null) {
                    C4990ab.m7412e("MicroMsg.DeviceInfo", "context is null, return fake device id now.");
                    C1427q.m3049eV(10);
                    str = "1234567890ABCDEF";
                    AppMethodBeat.m2505o(92967);
                    return str;
                }
                str = C5046bo.m7552gN(context);
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.DeviceInfo", "fail to get device id from system, return fake one instead.");
                    C1427q.m3049eV(10);
                    str = "1234567890ABCDEF";
                    AppMethodBeat.m2505o(92967);
                    return str;
                }
                amF.edit().putString("k_i_m_e_i", str).apply();
                C1427q.m3049eV(9);
                AppMethodBeat.m2505o(92967);
                return str;
            }
            C4990ab.m7416i("MicroMsg.DeviceInfo", "new cache's device id was chosen to be returned.");
            C1427q.m3049eV(8);
            AppMethodBeat.m2505o(92967);
            return str;
        }
        C4990ab.m7420w("MicroMsg.DeviceInfo", "old cache's device id was chosen to be returned.");
        C1427q.m3049eV(7);
        AppMethodBeat.m2505o(92967);
        return str;
    }

    public static String getDeviceID(Context context) {
        AppMethodBeat.m2504i(92968);
        String gN = C5046bo.m7552gN(context);
        if (C5046bo.isNullOrNil(gN)) {
            C1427q.m3049eV(6);
        } else {
            C1427q.m3049eV(5);
        }
        AppMethodBeat.m2505o(92968);
        return gN;
    }

    /* renamed from: LM */
    public static String m3028LM() {
        AppMethodBeat.m2504i(92969);
        String bH = C1427q.m3047bH(false);
        AppMethodBeat.m2505o(92969);
        return bH;
    }

    /* renamed from: bH */
    public static String m3047bH(boolean z) {
        AppMethodBeat.m2504i(92970);
        if (z || etq == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Secure.getString(C4996ah.getContext().getContentResolver(), "android_id"));
            stringBuilder.append(C1427q.m3048bI(z));
            stringBuilder.append(C1427q.m3030LO());
            etq = "A" + C1178g.m2591x(stringBuilder.toString().getBytes()).substring(0, 15);
            C4990ab.m7421w("MicroMsg.DeviceInfo", "guid:%s, dev=%s", etq, r0);
        }
        String str = etq;
        AppMethodBeat.m2505o(92970);
        return str;
    }

    /* renamed from: LN */
    public static boolean m3029LN() {
        return etq != null;
    }

    /* renamed from: LO */
    private static String m3030LO() {
        AppMethodBeat.m2504i(92971);
        String str = (String) C1420l.m3008Lu().get(C31128d.MIC_PTU_ZIPAI_MEDSEA);
        if (str != null) {
            C4990ab.m7410d("MicroMsg.DeviceInfo", "getHardWareId from file ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(92971);
            return str;
        }
        str = Build.MANUFACTURER + Build.MODEL + C1422n.m3012LB();
        C1420l.m3008Lu().set(C31128d.MIC_PTU_ZIPAI_MEDSEA, str);
        C4990ab.m7410d("MicroMsg.DeviceInfo", "getHardWareId ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(92971);
        return str;
    }

    /* renamed from: LP */
    public static String m3031LP() {
        String macAddress;
        AppMethodBeat.m2504i(92972);
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            macAddress = connectionInfo.getMacAddress();
        } else {
            macAddress = null;
        }
        AppMethodBeat.m2505o(92972);
        return macAddress;
    }

    /* renamed from: LQ */
    public static String m3032LQ() {
        AppMethodBeat.m2504i(92973);
        String str = null;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            str = defaultAdapter.getAddress();
        }
        AppMethodBeat.m2505o(92973);
        return str;
    }

    /* renamed from: bI */
    private static String m3048bI(boolean z) {
        String str;
        AppMethodBeat.m2504i(92974);
        if (!z) {
            str = (String) C1420l.m3008Lu().get(256);
            if (str != null) {
                AppMethodBeat.m2505o(92974);
                return str;
            }
        }
        str = C1427q.m3033LR();
        C1420l.m3008Lu().set(256, str);
        AppMethodBeat.m2505o(92974);
        return str;
    }

    /* renamed from: LR */
    private static String m3033LR() {
        Object obj;
        int i = 0;
        AppMethodBeat.m2504i(92975);
        String gN = C5046bo.m7552gN(C4996ah.getContext());
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
        C4990ab.m7420w("MicroMsg.DeviceInfo", "generated deviceId=".concat(String.valueOf(obj)));
        AppMethodBeat.m2505o(92975);
        return obj;
    }

    /* renamed from: ku */
    public static void m3050ku(String str) {
        AppMethodBeat.m2504i(92976);
        C4990ab.m7417i("MicroMsg.DeviceInfo", "update deviceInfo %s", str);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(92976);
        } else if (str.hashCode() == etm) {
            AppMethodBeat.m2505o(92976);
        } else {
            etm = str.hashCode();
            etb.reset();
            etc.reset();
            etd.reset();
            etn.reset();
            ete.reset();
            etf.reset();
            C1429s c1429s = etg;
            c1429s.etr = 0;
            c1429s.ets = 0;
            C1431w c1431w = eth;
            c1431w.etR = "";
            c1431w.etS = null;
            C1413aa c1413aa = eti;
            c1413aa.cOQ = false;
            c1413aa.eue = 0;
            c1413aa.euf = false;
            etj.reset();
            etk.reset();
            C1412a c1412a = etl;
            c1412a.epE = false;
            c1412a.epF = "";
            C1428r c1428r = new C1428r();
            if (C1428r.m3051a(str, etb, etc, etd, etn, ete, etf, etg, eth, eti, etj, etl, etk)) {
                C4990ab.m7416i("MicroMsg.DeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + etc.erz);
                C4879a.xxA.mo10055m(new C6467cj());
                AppMethodBeat.m2505o(92976);
                return;
            }
            AppMethodBeat.m2505o(92976);
        }
    }

    /* renamed from: LS */
    public static String m3034LS() {
        return Build.MODEL;
    }

    /* renamed from: bB */
    public static String m3045bB(Context context) {
        AppMethodBeat.m2504i(92977);
        String str;
        try {
            C4990ab.m7417i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", C4988aa.m7403gw(context));
            if (eth == null || eth.etS == null || eth.etS.size() == 0) {
                C4990ab.m7417i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", Build.MANUFACTURER);
                str = Build.MANUFACTURER;
                AppMethodBeat.m2505o(92977);
                return str;
            }
            str = (String) eth.etS.get(".manufacturerName." + C4988aa.m7403gw(context));
            C4990ab.m7417i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (C5046bo.isNullOrNil(str)) {
                str = (String) eth.etS.get(".manufacturerName.en");
                C4990ab.m7417i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
                if (C5046bo.isNullOrNil(str)) {
                    str = Build.MANUFACTURER;
                    AppMethodBeat.m2505o(92977);
                    return str;
                }
                AppMethodBeat.m2505o(92977);
                return str;
            }
            AppMethodBeat.m2505o(92977);
            return str;
        } catch (Exception e) {
            str = Build.MANUFACTURER;
            AppMethodBeat.m2505o(92977);
            return str;
        }
    }

    /* renamed from: bC */
    public static String m3046bC(Context context) {
        AppMethodBeat.m2504i(92978);
        String simOperatorName;
        try {
            simOperatorName = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            AppMethodBeat.m2505o(92978);
            return simOperatorName;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getMobileSPType", new Object[0]);
            simOperatorName = "";
            AppMethodBeat.m2505o(92978);
            return simOperatorName;
        }
    }

    public static String getSimCountryIso() {
        AppMethodBeat.m2504i(92979);
        TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            C4990ab.m7417i("MicroMsg.DeviceInfo", "get isoCode:[%s]", telephonyManager.getSimCountryIso());
            AppMethodBeat.m2505o(92979);
            return telephonyManager.getSimCountryIso();
        }
        AppMethodBeat.m2505o(92979);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007b A:{SYNTHETIC, Splitter:B:16:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086 A:{SYNTHETIC, Splitter:B:22:0x0086} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: LT */
    public static String[] m3035LT() {
        Throwable th;
        BufferedReader bufferedReader;
        AppMethodBeat.m2504i(92980);
        String[] strArr = new String[]{"", AppEventsConstants.EVENT_PARAM_VALUE_NO};
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                String[] split = C5046bo.nullAsNil(bufferedReader2.readLine()).split("\\s+");
                for (int i = 2; i < split.length; i++) {
                    strArr[0] = strArr[0] + split[i] + " ";
                }
                strArr[1] = C5046bo.nullAsNil(bufferedReader2.readLine()).split("\\s+")[2];
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                }
            } catch (IOException e2) {
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.m2505o(92980);
                return strArr;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(92980);
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
            AppMethodBeat.m2505o(92980);
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
            AppMethodBeat.m2505o(92980);
            throw th;
        }
        AppMethodBeat.m2505o(92980);
        return strArr;
    }

    public static String getAndroidId() {
        AppMethodBeat.m2504i(92981);
        C4990ab.m7417i("MicroMsg.DeviceInfo", "androidid:[%s]", Secure.getString(C4996ah.getContext().getContentResolver(), "android_id"));
        AppMethodBeat.m2505o(92981);
        return Secure.getString(C4996ah.getContext().getContentResolver(), "android_id");
    }

    /* renamed from: LU */
    public static String m3036LU() {
        AppMethodBeat.m2504i(92982);
        String str = null;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                str = defaultAdapter.getAddress();
            }
            str = C5046bo.nullAsNil(str);
            AppMethodBeat.m2505o(92982);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", C5046bo.m7574l(e));
            str = "";
            AppMethodBeat.m2505o(92982);
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: LV */
    public static String m3037LV() {
        AppMethodBeat.m2504i(92983);
        String str = null;
        try {
            if (VERSION.SDK_INT >= 14) {
                str = Build.getRadioVersion();
            } else {
                str = Build.RADIO;
            }
        } catch (IncompatibleClassChangeError e) {
            C4990ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
            AppMethodBeat.m2505o(92983);
            throw e2;
        } catch (Throwable th) {
        }
        str = C5046bo.nullAsNil(str);
        AppMethodBeat.m2505o(92983);
        return str;
    }

    /* renamed from: LW */
    public static String m3038LW() {
        return VERSION.RELEASE;
    }

    /* renamed from: LX */
    public static String m3039LX() {
        AppMethodBeat.m2504i(92984);
        String nullAsNil;
        try {
            nullAsNil = C5046bo.nullAsNil(((TelephonyManager) C4996ah.getContext().getSystemService("phone")).getSubscriberId());
            AppMethodBeat.m2505o(92984);
            return nullAsNil;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneIMSI", new Object[0]);
            nullAsNil = "";
            AppMethodBeat.m2505o(92984);
            return nullAsNil;
        }
    }

    /* renamed from: LY */
    public static String m3040LY() {
        AppMethodBeat.m2504i(92985);
        String nullAsNil;
        try {
            nullAsNil = C5046bo.nullAsNil(((TelephonyManager) C4996ah.getContext().getSystemService("phone")).getSimSerialNumber());
            AppMethodBeat.m2505o(92985);
            return nullAsNil;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneICCID", new Object[0]);
            nullAsNil = "";
            AppMethodBeat.m2505o(92985);
            return nullAsNil;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: LZ */
    public static String m3041LZ() {
        AppMethodBeat.m2504i(92986);
        String str = null;
        if (VERSION.SDK_INT >= 9) {
            str = Build.SERIAL;
        }
        str = C5046bo.nullAsNil(str);
        AppMethodBeat.m2505o(92986);
        return str;
    }

    /* renamed from: Ma */
    public static Map<String, String> m3042Ma() {
        Throwable e;
        AppMethodBeat.m2504i(92987);
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
                        C4990ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getInfoMapOfCpu() failed.", new Object[0]);
                        C5046bo.m7527b(bufferedReader);
                        AppMethodBeat.m2505o(92987);
                        return hashMap;
                    } catch (Throwable th) {
                        e = th;
                        C5046bo.m7527b(bufferedReader);
                        AppMethodBeat.m2505o(92987);
                        throw e;
                    }
                }
            }
            C5046bo.m7527b(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            C4990ab.printErrStackTrace("MicroMsg.DeviceInfo", e, "getInfoMapOfCpu() failed.", new Object[0]);
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92987);
            return hashMap;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92987);
            throw e;
        }
        AppMethodBeat.m2505o(92987);
        return hashMap;
    }

    /* renamed from: Mb */
    public static int m3043Mb() {
        AppMethodBeat.m2504i(92988);
        try {
            int length = new File("/sys/devices/system/cpu").listFiles(new C1426a()).length;
            AppMethodBeat.m2505o(92988);
            return length;
        } catch (Exception e) {
            AppMethodBeat.m2505o(92988);
            return 1;
        }
    }

    /* renamed from: Mc */
    public static String m3044Mc() {
        AppMethodBeat.m2504i(92989);
        String str = "android-" + Build.MODEL + "-" + VERSION.SDK_INT;
        AppMethodBeat.m2505o(92989);
        return str;
    }
}
