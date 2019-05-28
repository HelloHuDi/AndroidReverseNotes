package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r {
    public static String qiQ = "title";
    public static String qiR = "tip";
    public static String qiS = "buttonTitle";

    public static class a {
        public String cMD;
        public int iAd;
        public String kbU;
    }

    public static int Ws(String str) {
        AppMethodBeat.i(81494);
        if (str == null) {
            AppMethodBeat.o(81494);
            return 0;
        } else if ("EAN-13".equals(str) || "EAN_13".equals(str)) {
            AppMethodBeat.o(81494);
            return 4;
        } else if ("EAN-8".equals(str) || "EAN_8".equals(str)) {
            AppMethodBeat.o(81494);
            return 3;
        } else if ("EAN-2".equals(str)) {
            AppMethodBeat.o(81494);
            return 1;
        } else if ("EAN-5".equals(str)) {
            AppMethodBeat.o(81494);
            return 2;
        } else if ("UPC-A".equals(str) || "UPC_A".equals(str)) {
            AppMethodBeat.o(81494);
            return 5;
        } else if ("UPC-E".equals(str) || "UPC_E".equals(str)) {
            AppMethodBeat.o(81494);
            return 6;
        } else if ("CODE-39".equals(str) || "CODE_39".equals(str)) {
            AppMethodBeat.o(81494);
            return 9;
        } else if ("CODE-93".equals(str) || "CODE_93".equals(str)) {
            AppMethodBeat.o(81494);
            return 10;
        } else if ("CODE-128".equals(str) || "CODE_128".equals(str)) {
            AppMethodBeat.o(81494);
            return 11;
        } else if ("COMPOSITE".equals(str)) {
            AppMethodBeat.o(81494);
            return 12;
        } else if ("I/25".equals(str) || "ITF".equals(str)) {
            AppMethodBeat.o(81494);
            return 13;
        } else if ("DATABAR".equals(str)) {
            AppMethodBeat.o(81494);
            return 7;
        } else if ("DATABAR-EXP".equals(str)) {
            AppMethodBeat.o(81494);
            return 8;
        } else if ("RSS_14".equals(str)) {
            AppMethodBeat.o(81494);
            return 15;
        } else if ("RSS_EXPANDED".equals(str)) {
            AppMethodBeat.o(81494);
            return 16;
        } else if ("MAXICODE".equals(str)) {
            AppMethodBeat.o(81494);
            return 18;
        } else if ("PDF_417".equals(str)) {
            AppMethodBeat.o(81494);
            return 20;
        } else if ("QR_CODE".equals(str)) {
            AppMethodBeat.o(81494);
            return 19;
        } else if ("CODABAR".equals(str)) {
            AppMethodBeat.o(81494);
            return 17;
        } else if ("ISBN10".equals(str)) {
            AppMethodBeat.o(81494);
            return 14;
        } else if ("DATA_MATRIX".equals(str)) {
            AppMethodBeat.o(81494);
            return 21;
        } else if ("WX_CODE".equals(str)) {
            AppMethodBeat.o(81494);
            return 22;
        } else {
            AppMethodBeat.o(81494);
            return 0;
        }
    }

    public static boolean sP(int i) {
        AppMethodBeat.i(81495);
        b bVar = (b) g.K(b.class);
        if (bVar != null) {
            boolean sP = bVar.sP(i);
            AppMethodBeat.o(81495);
            return sP;
        }
        AppMethodBeat.o(81495);
        return false;
    }

    public static a Wt(String str) {
        AppMethodBeat.i(81496);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(81496);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.kbU = jSONObject.optString("card_tp_id");
            aVar.iAd = jSONObject.optInt("card_type");
            aVar.cMD = jSONObject.optString("card_ext");
            AppMethodBeat.o(81496);
            return aVar;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.ScannerUtil", e, "", new Object[0]);
            AppMethodBeat.o(81496);
            return null;
        }
    }

    public static ArrayList<a> Wu(String str) {
        AppMethodBeat.i(81497);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(81497);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                ab.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
                AppMethodBeat.o(81497);
                return null;
            }
            ArrayList<a> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a aVar = new a();
                aVar.kbU = optJSONObject.optString("card_tp_id");
                aVar.iAd = optJSONObject.optInt("card_type");
                aVar.cMD = optJSONObject.optString("card_ext");
                arrayList.add(aVar);
            }
            AppMethodBeat.o(81497);
            return arrayList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.ScannerUtil", e, "", new Object[0]);
            AppMethodBeat.o(81497);
            return null;
        }
    }

    public static boolean Q(ArrayList<a> arrayList) {
        AppMethodBeat.i(81498);
        if (arrayList == null || arrayList.size() == 0) {
            ab.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
            AppMethodBeat.o(81498);
            return false;
        }
        int i = 0;
        while (i < arrayList.size()) {
            a aVar = (a) arrayList.get(i);
            if (aVar == null || !sP(aVar.iAd)) {
                i++;
            } else {
                AppMethodBeat.o(81498);
                return true;
            }
        }
        AppMethodBeat.o(81498);
        return false;
    }

    public static void aQ(Context context, String str) {
        AppMethodBeat.i(81499);
        h.a(context, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(81493);
                dialogInterface.dismiss();
                AppMethodBeat.o(81493);
            }
        });
        AppMethodBeat.o(81499);
    }

    public static String fT(String str, String str2) {
        AppMethodBeat.i(81500);
        String value = com.tencent.mm.m.g.Nu().getValue("ScanBookWording");
        ab.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + bo.nullAsNil(value));
        if (!bo.isNullOrNil(value)) {
            String[] split = value.split("&");
            if (split != null) {
                HashMap hashMap = new HashMap();
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        hashMap.put(split3[0], split3[1]);
                    }
                }
                value = (String) hashMap.get(str);
                if (!bo.isNullOrNil(value)) {
                    str2 = value;
                }
            }
        }
        AppMethodBeat.o(81500);
        return str2;
    }

    public static boolean cio() {
        AppMethodBeat.i(81501);
        int i = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("EnableNewOCRTranslation", 0);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("NewOCRTranslationSupportUserLanguage");
        String str = "MicroMsg.ScannerUtil";
        String str2 = "enable %s, support lang %s, current lang %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(i == 1);
        objArr[1] = value;
        objArr[2] = aa.dor();
        ab.i(str, str2, objArr);
        if (i == 1 && !bo.isNullOrNil(value)) {
            String[] split = value.split(";");
            if (split != null && Arrays.asList(split).contains(aa.dor())) {
                AppMethodBeat.o(81501);
                return true;
            }
        }
        AppMethodBeat.o(81501);
        return false;
    }
}
