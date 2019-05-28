package com.b.a.a;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.List;

final class v {
    private static String bs(String str) {
        AppMethodBeat.i(55567);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("trying to manipulate null string");
            AppMethodBeat.o(55567);
            throw nullPointerException;
        }
        Object obj = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ':') {
                obj = new StringBuilder(String.valueOf(obj)).append(str.charAt(i)).toString();
            }
        }
        AppMethodBeat.o(55567);
        return obj;
    }

    static String a(List<ScanResult> list, boolean z) {
        AppMethodBeat.i(55568);
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null) {
            for (ScanResult scanResult : list) {
                if (!(scanResult.capabilities == null || scanResult.capabilities.contains("IBSS"))) {
                    try {
                        String bigInteger = new BigInteger(bs(scanResult.BSSID), 16).toString();
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
        AppMethodBeat.o(55568);
        return stringBuilder2;
    }

    static boolean e(double d, double d2) {
        AppMethodBeat.i(55569);
        if (Math.abs(d) > 90.0d || Math.abs(d2) > 180.0d) {
            AppMethodBeat.o(55569);
            return false;
        }
        AppMethodBeat.o(55569);
        return true;
    }

    static String bt(String str) {
        AppMethodBeat.i(55570);
        if (str == null) {
            AppMethodBeat.o(55570);
            return null;
        }
        String replace = str.replace("&SD=", "|SD,");
        AppMethodBeat.o(55570);
        return replace;
    }

    static String bu(String str) {
        AppMethodBeat.i(55571);
        if (str == null) {
            AppMethodBeat.o(55571);
            return null;
        }
        String replace = str.replace("&GD=", "|GD,");
        AppMethodBeat.o(55571);
        return replace;
    }

    static String b(String str, long j, String str2) {
        AppMethodBeat.i(55572);
        if (str == null || !str.startsWith("|")) {
            AppMethodBeat.o(55572);
            return null;
        }
        String str3 = "&OD[]=ST," + String.valueOf(j) + ',' + str2 + str;
        AppMethodBeat.o(55572);
        return str3;
    }
}
