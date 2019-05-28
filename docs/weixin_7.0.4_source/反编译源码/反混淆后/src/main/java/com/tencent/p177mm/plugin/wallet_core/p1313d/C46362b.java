package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22560c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.b */
public final class C46362b {
    private static final String kdH = (C6457e.eSn + "wallet");
    private static Map<String, String> tDM = null;

    static {
        AppMethodBeat.m2504i(47058);
        AppMethodBeat.m2505o(47058);
    }

    public static boolean acL(String str) {
        AppMethodBeat.m2504i(47050);
        try {
            if (tDM == null) {
                tDM = new HashMap();
            }
            C4990ab.m7410d("MicroMsg.WalletBankLogoStorage", "bank logo:".concat(String.valueOf(str)));
            Editor edit = C4996ah.getContext().getSharedPreferences("bank_logo", 0).edit();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("bank_urls_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (C1853r.m3831YM()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                String jSONObject2 = jSONObject.toString();
                if (C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                tDM.put(optString, jSONObject2);
            }
            edit.commit();
            C4990ab.m7410d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            AppMethodBeat.m2505o(47050);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            AppMethodBeat.m2505o(47050);
            return false;
        }
    }

    /* renamed from: av */
    public static boolean m87141av(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(47051);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            if (tDM == null) {
                tDM = new HashMap();
            }
            Editor edit = C4996ah.getContext().getSharedPreferences("bank_logo", 0).edit();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String optString;
                JSONObject jSONObject = new JSONObject((String) linkedList.get(i));
                if (C1853r.m3831YM()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                jSONObject.put(Param.TIMESTAMP, currentTimeMillis);
                String jSONObject2 = jSONObject.toString();
                if (C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                tDM.put(optString, jSONObject2);
            }
            edit.commit();
            C4990ab.m7410d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            AppMethodBeat.m2505o(47051);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            AppMethodBeat.m2505o(47051);
            return false;
        }
    }

    private static void cRa() {
        AppMethodBeat.m2504i(47053);
        tDM = new HashMap();
        for (Entry entry : C4996ah.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet()) {
            tDM.put(entry.getKey(), (String) entry.getValue());
        }
        AppMethodBeat.m2505o(47053);
    }

    /* renamed from: i */
    public static C43807e m87144i(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(47054);
        C43807e c43807e;
        if (z) {
            c43807e = null;
            if ("CITIC_CREDIT".equals(str)) {
                c43807e = new C43807e();
                c43807e.txt = C25738R.drawable.bkz;
                c43807e.txu = C25738R.drawable.bl1;
                C43807e bc = C46362b.m87142bc(context, str);
                if (bc != null) {
                    c43807e.oRi = bc.oRi;
                }
            }
            AppMethodBeat.m2505o(47054);
            return c43807e;
        }
        c43807e = C46362b.m87142bc(context, str);
        AppMethodBeat.m2505o(47054);
        return c43807e;
    }

    /* renamed from: bc */
    private static C43807e m87142bc(Context context, String str) {
        String str2;
        boolean z;
        C43807e c43807e;
        boolean z2 = true;
        AppMethodBeat.m2504i(47055);
        if (tDM == null) {
            C46362b.cRa();
            str2 = (String) tDM.get(str);
        } else {
            str2 = (String) tDM.get(str);
            if (str2 == null) {
                C4990ab.m7417i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", str);
                str2 = C4996ah.getContext().getSharedPreferences("bank_logo", 0).getString(str, "");
                if (str2 != null) {
                    C4990ab.m7421w("MicroMsg.WalletBankLogoStorage", "get from sp %s", str);
                    tDM.put(str, str2);
                }
            }
        }
        if (C5046bo.isNullOrNil(str2)) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().isSDCardAvailable()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(str);
                C1207m c22560c = new C22560c(linkedList);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c22560c, 0);
            }
            C46362b.acL(C46362b.m87143bd(context, "config/bank_logo.xml"));
            if (tDM != null) {
                str2 = (String) tDM.get(str);
                z = true;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if (C5046bo.isNullOrNil(str2)) {
            c43807e = null;
        } else {
            C43807e c43807e2 = new C43807e();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long optLong = jSONObject.optLong(Param.TIMESTAMP, 0);
                c43807e2.oRi = jSONObject.getString("logo2x_url");
                c43807e2.txp = jSONObject.getString("bg2x_url");
                c43807e2.txq = jSONObject.getString("wl2x_url");
                if (!z && (System.currentTimeMillis() / 1000) - optLong <= 7200) {
                    z2 = false;
                }
                c43807e2.bNM = z2;
                c43807e2.txr = C46362b.m87140UK(c43807e2.oRi);
                c43807e2.puh = jSONObject.optString("bank_name_pinyin", "");
                c43807e2.timestamp = optLong;
                c43807e = c43807e2;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
                AppMethodBeat.m2505o(47055);
                return null;
            }
        }
        AppMethodBeat.m2505o(47055);
        return c43807e;
    }

    /* renamed from: bd */
    private static String m87143bd(Context context, String str) {
        AppMethodBeat.m2504i(47056);
        String str2 = "";
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "close", new Object[0]);
                }
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "getFromAssets", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e22) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e22, "close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e222) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e222, "close", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(47056);
        }
        AppMethodBeat.m2505o(47056);
        return str2;
    }

    public static String cRb() {
        return kdH;
    }

    /* renamed from: UK */
    public static String m87140UK(String str) {
        AppMethodBeat.m2504i(47057);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
            AppMethodBeat.m2505o(47057);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{kdH, C1178g.m2591x(str.getBytes())});
        AppMethodBeat.m2505o(47057);
        return format;
    }

    public static C43807e acM(String str) {
        int i;
        AppMethodBeat.m2504i(47052);
        if (tDM == null) {
            C46362b.cRa();
        }
        if (C5046bo.isNullOrNil((String) tDM.get(str))) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.m2505o(47052);
            return null;
        }
        String str2 = (String) tDM.get(str);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(47052);
            return null;
        }
        C43807e c43807e = new C43807e();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            long optLong = jSONObject.optLong(Param.TIMESTAMP, 0);
            c43807e.oRi = jSONObject.getString("logo2x_url");
            c43807e.txp = jSONObject.getString("bg2x_url");
            c43807e.txq = jSONObject.getString("wl2x_url");
            c43807e.bNM = (System.currentTimeMillis() / 1000) - optLong > 7200;
            c43807e.txr = C46362b.m87140UK(c43807e.oRi);
            c43807e.puh = jSONObject.optString("bank_name_pinyin", "");
            c43807e.timestamp = optLong;
            AppMethodBeat.m2505o(47052);
            return c43807e;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            AppMethodBeat.m2505o(47052);
            return null;
        }
    }
}
