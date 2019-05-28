package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static final String kdH = (e.eSn + "wallet");
    private static Map<String, String> tDM = null;

    static {
        AppMethodBeat.i(47058);
        AppMethodBeat.o(47058);
    }

    public static boolean acL(String str) {
        AppMethodBeat.i(47050);
        try {
            if (tDM == null) {
                tDM = new HashMap();
            }
            ab.d("MicroMsg.WalletBankLogoStorage", "bank logo:".concat(String.valueOf(str)));
            Editor edit = ah.getContext().getSharedPreferences("bank_logo", 0).edit();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("bank_urls_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (r.YM()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                String jSONObject2 = jSONObject.toString();
                if (bo.isNullOrNil(optString) || bo.isNullOrNil(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                tDM.put(optString, jSONObject2);
            }
            edit.commit();
            ab.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            AppMethodBeat.o(47050);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            AppMethodBeat.o(47050);
            return false;
        }
    }

    public static boolean av(LinkedList<String> linkedList) {
        AppMethodBeat.i(47051);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            if (tDM == null) {
                tDM = new HashMap();
            }
            Editor edit = ah.getContext().getSharedPreferences("bank_logo", 0).edit();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String optString;
                JSONObject jSONObject = new JSONObject((String) linkedList.get(i));
                if (r.YM()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                jSONObject.put(Param.TIMESTAMP, currentTimeMillis);
                String jSONObject2 = jSONObject.toString();
                if (bo.isNullOrNil(optString) || bo.isNullOrNil(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                tDM.put(optString, jSONObject2);
            }
            edit.commit();
            ab.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            AppMethodBeat.o(47051);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            AppMethodBeat.o(47051);
            return false;
        }
    }

    private static void cRa() {
        AppMethodBeat.i(47053);
        tDM = new HashMap();
        for (Entry entry : ah.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet()) {
            tDM.put(entry.getKey(), (String) entry.getValue());
        }
        AppMethodBeat.o(47053);
    }

    public static com.tencent.mm.plugin.wallet_core.model.e i(Context context, String str, boolean z) {
        AppMethodBeat.i(47054);
        com.tencent.mm.plugin.wallet_core.model.e eVar;
        if (z) {
            eVar = null;
            if ("CITIC_CREDIT".equals(str)) {
                eVar = new com.tencent.mm.plugin.wallet_core.model.e();
                eVar.txt = R.drawable.bkz;
                eVar.txu = R.drawable.bl1;
                com.tencent.mm.plugin.wallet_core.model.e bc = bc(context, str);
                if (bc != null) {
                    eVar.oRi = bc.oRi;
                }
            }
            AppMethodBeat.o(47054);
            return eVar;
        }
        eVar = bc(context, str);
        AppMethodBeat.o(47054);
        return eVar;
    }

    private static com.tencent.mm.plugin.wallet_core.model.e bc(Context context, String str) {
        String str2;
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.e eVar;
        boolean z2 = true;
        AppMethodBeat.i(47055);
        if (tDM == null) {
            cRa();
            str2 = (String) tDM.get(str);
        } else {
            str2 = (String) tDM.get(str);
            if (str2 == null) {
                ab.i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", str);
                str2 = ah.getContext().getSharedPreferences("bank_logo", 0).getString(str, "");
                if (str2 != null) {
                    ab.w("MicroMsg.WalletBankLogoStorage", "get from sp %s", str);
                    tDM.put(str, str2);
                }
            }
        }
        if (bo.isNullOrNil(str2)) {
            g.RQ();
            if (g.RP().isSDCardAvailable()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(str);
                m cVar = new c(linkedList);
                g.RQ();
                g.RO().eJo.a(cVar, 0);
            }
            acL(bd(context, "config/bank_logo.xml"));
            if (tDM != null) {
                str2 = (String) tDM.get(str);
                z = true;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if (bo.isNullOrNil(str2)) {
            eVar = null;
        } else {
            com.tencent.mm.plugin.wallet_core.model.e eVar2 = new com.tencent.mm.plugin.wallet_core.model.e();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long optLong = jSONObject.optLong(Param.TIMESTAMP, 0);
                eVar2.oRi = jSONObject.getString("logo2x_url");
                eVar2.txp = jSONObject.getString("bg2x_url");
                eVar2.txq = jSONObject.getString("wl2x_url");
                if (!z && (System.currentTimeMillis() / 1000) - optLong <= 7200) {
                    z2 = false;
                }
                eVar2.bNM = z2;
                eVar2.txr = UK(eVar2.oRi);
                eVar2.puh = jSONObject.optString("bank_name_pinyin", "");
                eVar2.timestamp = optLong;
                eVar = eVar2;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
                AppMethodBeat.o(47055);
                return null;
            }
        }
        AppMethodBeat.o(47055);
        return eVar;
    }

    private static String bd(Context context, String str) {
        AppMethodBeat.i(47056);
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
                    ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "close", new Object[0]);
                }
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "getFromAssets", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e22) {
                    ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e22, "close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e222) {
                    ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e222, "close", new Object[0]);
                }
            }
            AppMethodBeat.o(47056);
        }
        AppMethodBeat.o(47056);
        return str2;
    }

    public static String cRb() {
        return kdH;
    }

    public static String UK(String str) {
        AppMethodBeat.i(47057);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
            AppMethodBeat.o(47057);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{kdH, com.tencent.mm.a.g.x(str.getBytes())});
        AppMethodBeat.o(47057);
        return format;
    }

    public static com.tencent.mm.plugin.wallet_core.model.e acM(String str) {
        int i;
        AppMethodBeat.i(47052);
        if (tDM == null) {
            cRa();
        }
        if (bo.isNullOrNil((String) tDM.get(str))) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.o(47052);
            return null;
        }
        String str2 = (String) tDM.get(str);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(47052);
            return null;
        }
        com.tencent.mm.plugin.wallet_core.model.e eVar = new com.tencent.mm.plugin.wallet_core.model.e();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            long optLong = jSONObject.optLong(Param.TIMESTAMP, 0);
            eVar.oRi = jSONObject.getString("logo2x_url");
            eVar.txp = jSONObject.getString("bg2x_url");
            eVar.txq = jSONObject.getString("wl2x_url");
            eVar.bNM = (System.currentTimeMillis() / 1000) - optLong > 7200;
            eVar.txr = UK(eVar.oRi);
            eVar.puh = jSONObject.optString("bank_name_pinyin", "");
            eVar.timestamp = optLong;
            AppMethodBeat.o(47052);
            return eVar;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            AppMethodBeat.o(47052);
            return null;
        }
    }
}
