package com.tencent.mm.game.report.b;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String eCq = null;

    public static int getNetworkType(Context context) {
        AppMethodBeat.i(59595);
        if (at.is3G(context)) {
            AppMethodBeat.o(59595);
            return 4;
        } else if (at.is4G(context)) {
            AppMethodBeat.o(59595);
            return 5;
        } else {
            switch (at.getNetType(context)) {
                case -1:
                    AppMethodBeat.o(59595);
                    return 255;
                case 0:
                    AppMethodBeat.o(59595);
                    return 1;
                case 5:
                    AppMethodBeat.o(59595);
                    return 2;
                case 6:
                    AppMethodBeat.o(59595);
                    return 3;
                default:
                    AppMethodBeat.o(59595);
                    return 6;
            }
        }
    }

    public static String kY(String str) {
        AppMethodBeat.i(59596);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(59596);
            return str2;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            str2 = "";
            ab.e("MicroMsg.GameReportUtil", exception.getMessage());
        }
        AppMethodBeat.o(59596);
        return str2;
    }

    public static String getDeviceInfo() {
        AppMethodBeat.i(59597);
        String LK = q.LK();
        String LP = q.LP();
        String LU = LU();
        String LX = q.LX();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IMEI", LK);
            jSONObject.put("MAC_ADDRESS", LP);
            jSONObject.put("BLUETOOTH_ADDRESS", LU);
            jSONObject.put("IMSI", LX);
        } catch (JSONException e) {
            ab.e("MicroMsg.GameReportUtil", "getDeviceInfo: " + e.getMessage());
        }
        LK = kY(jSONObject.toString());
        AppMethodBeat.o(59597);
        return LK;
    }

    private static String LU() {
        AppMethodBeat.i(59598);
        String nullAsNil;
        try {
            nullAsNil = bo.nullAsNil(BluetoothAdapter.getDefaultAdapter().getAddress());
            AppMethodBeat.o(59598);
            return nullAsNil;
        } catch (Exception e) {
            ab.e("MicroMsg.GameReportUtil", "getBlueToothAddress failed: %s", bo.l(e));
            nullAsNil = "";
            AppMethodBeat.o(59598);
            return nullAsNil;
        }
    }

    public static String Pv() {
        AppMethodBeat.i(59599);
        if (eCq == null) {
            String LM = q.LM();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < LM.length() - 1; i++) {
                stringBuilder.append(Integer.toHexString(LM.charAt(i)));
            }
            stringBuilder.append("00");
            eCq = stringBuilder.toString();
        }
        String str = eCq;
        AppMethodBeat.o(59599);
        return str;
    }

    public static String fa(long j) {
        AppMethodBeat.i(59601);
        String bigInteger = new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(j)).toString();
        ab.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = ".concat(String.valueOf(bigInteger)));
        AppMethodBeat.o(59601);
        return bigInteger;
    }

    public static int F(Context context, String str) {
        AppMethodBeat.i(59600);
        PackageInfo packageInfo = b.getPackageInfo(context, str);
        if (packageInfo == null) {
            AppMethodBeat.o(59600);
            return 0;
        }
        int i = packageInfo.versionCode;
        AppMethodBeat.o(59600);
        return i;
    }
}
