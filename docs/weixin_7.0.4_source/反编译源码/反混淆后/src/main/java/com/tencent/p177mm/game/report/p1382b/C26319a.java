package com.tencent.p177mm.game.report.p1382b;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.math.BigInteger;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.game.report.b.a */
public final class C26319a {
    private static String eCq = null;

    public static int getNetworkType(Context context) {
        AppMethodBeat.m2504i(59595);
        if (C5023at.is3G(context)) {
            AppMethodBeat.m2505o(59595);
            return 4;
        } else if (C5023at.is4G(context)) {
            AppMethodBeat.m2505o(59595);
            return 5;
        } else {
            switch (C5023at.getNetType(context)) {
                case -1:
                    AppMethodBeat.m2505o(59595);
                    return 255;
                case 0:
                    AppMethodBeat.m2505o(59595);
                    return 1;
                case 5:
                    AppMethodBeat.m2505o(59595);
                    return 2;
                case 6:
                    AppMethodBeat.m2505o(59595);
                    return 3;
                default:
                    AppMethodBeat.m2505o(59595);
                    return 6;
            }
        }
    }

    /* renamed from: kY */
    public static String m41875kY(String str) {
        AppMethodBeat.m2504i(59596);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(59596);
            return str2;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            str2 = "";
            C4990ab.m7412e("MicroMsg.GameReportUtil", exception.getMessage());
        }
        AppMethodBeat.m2505o(59596);
        return str2;
    }

    public static String getDeviceInfo() {
        AppMethodBeat.m2504i(59597);
        String LK = C1427q.m3026LK();
        String LP = C1427q.m3031LP();
        String LU = C26319a.m41872LU();
        String LX = C1427q.m3039LX();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IMEI", LK);
            jSONObject.put("MAC_ADDRESS", LP);
            jSONObject.put("BLUETOOTH_ADDRESS", LU);
            jSONObject.put("IMSI", LX);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.GameReportUtil", "getDeviceInfo: " + e.getMessage());
        }
        LK = C26319a.m41875kY(jSONObject.toString());
        AppMethodBeat.m2505o(59597);
        return LK;
    }

    /* renamed from: LU */
    private static String m41872LU() {
        AppMethodBeat.m2504i(59598);
        String nullAsNil;
        try {
            nullAsNil = C5046bo.nullAsNil(BluetoothAdapter.getDefaultAdapter().getAddress());
            AppMethodBeat.m2505o(59598);
            return nullAsNil;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.GameReportUtil", "getBlueToothAddress failed: %s", C5046bo.m7574l(e));
            nullAsNil = "";
            AppMethodBeat.m2505o(59598);
            return nullAsNil;
        }
    }

    /* renamed from: Pv */
    public static String m41873Pv() {
        AppMethodBeat.m2504i(59599);
        if (eCq == null) {
            String LM = C1427q.m3028LM();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < LM.length() - 1; i++) {
                stringBuilder.append(Integer.toHexString(LM.charAt(i)));
            }
            stringBuilder.append("00");
            eCq = stringBuilder.toString();
        }
        String str = eCq;
        AppMethodBeat.m2505o(59599);
        return str;
    }

    /* renamed from: fa */
    public static String m41874fa(long j) {
        AppMethodBeat.m2504i(59601);
        String bigInteger = new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(j)).toString();
        C4990ab.m7410d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = ".concat(String.valueOf(bigInteger)));
        AppMethodBeat.m2505o(59601);
        return bigInteger;
    }

    /* renamed from: F */
    public static int m41871F(Context context, String str) {
        AppMethodBeat.m2504i(59600);
        PackageInfo packageInfo = C19679b.getPackageInfo(context, str);
        if (packageInfo == null) {
            AppMethodBeat.m2505o(59600);
            return 0;
        }
        int i = packageInfo.versionCode;
        AppMethodBeat.m2505o(59600);
        return i;
    }
}
