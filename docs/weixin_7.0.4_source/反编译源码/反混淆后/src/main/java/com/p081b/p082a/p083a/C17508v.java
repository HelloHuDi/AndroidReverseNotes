package com.p081b.p082a.p083a;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.List;

/* renamed from: com.b.a.a.v */
final class C17508v {
    /* renamed from: bs */
    private static String m27332bs(String str) {
        AppMethodBeat.m2504i(55567);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("trying to manipulate null string");
            AppMethodBeat.m2505o(55567);
            throw nullPointerException;
        }
        Object obj = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ':') {
                obj = new StringBuilder(String.valueOf(obj)).append(str.charAt(i)).toString();
            }
        }
        AppMethodBeat.m2505o(55567);
        return obj;
    }

    /* renamed from: a */
    static String m27330a(List<ScanResult> list, boolean z) {
        AppMethodBeat.m2504i(55568);
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null) {
            for (ScanResult scanResult : list) {
                if (!(scanResult.capabilities == null || scanResult.capabilities.contains("IBSS"))) {
                    try {
                        String bigInteger = new BigInteger(C17508v.m27332bs(scanResult.BSSID), 16).toString();
                        String valueOf = String.valueOf(scanResult.level);
                        String str = "";
                        stringBuilder.append(z ? "&WD[]=" : "|WD,");
                        stringBuilder.append(bigInteger);
                        stringBuilder.append(',');
                        stringBuilder.append(valueOf);
                        stringBuilder.append(',');
                        stringBuilder.append(valueOf);
                        stringBuilder.append(',');
                        stringBuilder.append(valueOf);
                        stringBuilder.append(',');
                        stringBuilder.append(1);
                        stringBuilder.append(',');
                        stringBuilder.append(1);
                        stringBuilder.append(',');
                        stringBuilder.append(0);
                        stringBuilder.append(',');
                        stringBuilder.append(str);
                    } catch (NullPointerException e) {
                    } catch (NumberFormatException e2) {
                    } catch (Error e3) {
                    }
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(55568);
        return stringBuilder2;
    }

    /* renamed from: e */
    static boolean m27335e(double d, double d2) {
        AppMethodBeat.m2504i(55569);
        if (Math.abs(d) > 90.0d || Math.abs(d2) > 180.0d) {
            AppMethodBeat.m2505o(55569);
            return false;
        }
        AppMethodBeat.m2505o(55569);
        return true;
    }

    /* renamed from: bt */
    static String m27333bt(String str) {
        AppMethodBeat.m2504i(55570);
        if (str == null) {
            AppMethodBeat.m2505o(55570);
            return null;
        }
        String replace = str.replace("&SD=", "|SD,");
        AppMethodBeat.m2505o(55570);
        return replace;
    }

    /* renamed from: bu */
    static String m27334bu(String str) {
        AppMethodBeat.m2504i(55571);
        if (str == null) {
            AppMethodBeat.m2505o(55571);
            return null;
        }
        String replace = str.replace("&GD=", "|GD,");
        AppMethodBeat.m2505o(55571);
        return replace;
    }

    /* renamed from: b */
    static String m27331b(String str, long j, String str2) {
        AppMethodBeat.m2504i(55572);
        if (str == null || !str.startsWith("|")) {
            AppMethodBeat.m2505o(55572);
            return null;
        }
        String str3 = "&OD[]=ST," + String.valueOf(j) + ',' + str2 + str;
        AppMethodBeat.m2505o(55572);
        return str3;
    }
}
