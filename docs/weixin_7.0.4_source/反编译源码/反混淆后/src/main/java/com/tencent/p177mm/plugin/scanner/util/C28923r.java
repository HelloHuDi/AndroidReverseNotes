package com.tencent.p177mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.card.p1243c.C33762b;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.scanner.util.r */
public final class C28923r {
    public static String qiQ = "title";
    public static String qiR = "tip";
    public static String qiS = "buttonTitle";

    /* renamed from: com.tencent.mm.plugin.scanner.util.r$a */
    public static class C3773a {
        public String cMD;
        public int iAd;
        public String kbU;
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.r$1 */
    static class C289241 implements OnClickListener {
        C289241() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(81493);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(81493);
        }
    }

    /* renamed from: Ws */
    public static int m45942Ws(String str) {
        AppMethodBeat.m2504i(81494);
        if (str == null) {
            AppMethodBeat.m2505o(81494);
            return 0;
        } else if ("EAN-13".equals(str) || "EAN_13".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 4;
        } else if ("EAN-8".equals(str) || "EAN_8".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 3;
        } else if ("EAN-2".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 1;
        } else if ("EAN-5".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 2;
        } else if ("UPC-A".equals(str) || "UPC_A".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 5;
        } else if ("UPC-E".equals(str) || "UPC_E".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 6;
        } else if ("CODE-39".equals(str) || "CODE_39".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 9;
        } else if ("CODE-93".equals(str) || "CODE_93".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 10;
        } else if ("CODE-128".equals(str) || "CODE_128".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 11;
        } else if ("COMPOSITE".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 12;
        } else if ("I/25".equals(str) || "ITF".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 13;
        } else if ("DATABAR".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 7;
        } else if ("DATABAR-EXP".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 8;
        } else if ("RSS_14".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 15;
        } else if ("RSS_EXPANDED".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 16;
        } else if ("MAXICODE".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 18;
        } else if ("PDF_417".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 20;
        } else if ("QR_CODE".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 19;
        } else if ("CODABAR".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 17;
        } else if ("ISBN10".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 14;
        } else if ("DATA_MATRIX".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 21;
        } else if ("WX_CODE".equals(str)) {
            AppMethodBeat.m2505o(81494);
            return 22;
        } else {
            AppMethodBeat.m2505o(81494);
            return 0;
        }
    }

    /* renamed from: sP */
    public static boolean m45947sP(int i) {
        AppMethodBeat.m2504i(81495);
        C33762b c33762b = (C33762b) C1720g.m3528K(C33762b.class);
        if (c33762b != null) {
            boolean sP = c33762b.mo35386sP(i);
            AppMethodBeat.m2505o(81495);
            return sP;
        }
        AppMethodBeat.m2505o(81495);
        return false;
    }

    /* renamed from: Wt */
    public static C3773a m45943Wt(String str) {
        AppMethodBeat.m2504i(81496);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(81496);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C3773a c3773a = new C3773a();
            c3773a.kbU = jSONObject.optString("card_tp_id");
            c3773a.iAd = jSONObject.optInt("card_type");
            c3773a.cMD = jSONObject.optString("card_ext");
            AppMethodBeat.m2505o(81496);
            return c3773a;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ScannerUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(81496);
            return null;
        }
    }

    /* renamed from: Wu */
    public static ArrayList<C3773a> m45944Wu(String str) {
        AppMethodBeat.m2504i(81497);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(81497);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
                AppMethodBeat.m2505o(81497);
                return null;
            }
            ArrayList<C3773a> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                C3773a c3773a = new C3773a();
                c3773a.kbU = optJSONObject.optString("card_tp_id");
                c3773a.iAd = optJSONObject.optInt("card_type");
                c3773a.cMD = optJSONObject.optString("card_ext");
                arrayList.add(c3773a);
            }
            AppMethodBeat.m2505o(81497);
            return arrayList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ScannerUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(81497);
            return null;
        }
    }

    /* renamed from: Q */
    public static boolean m45941Q(ArrayList<C3773a> arrayList) {
        AppMethodBeat.m2504i(81498);
        if (arrayList == null || arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
            AppMethodBeat.m2505o(81498);
            return false;
        }
        int i = 0;
        while (i < arrayList.size()) {
            C3773a c3773a = (C3773a) arrayList.get(i);
            if (c3773a == null || !C28923r.m45947sP(c3773a.iAd)) {
                i++;
            } else {
                AppMethodBeat.m2505o(81498);
                return true;
            }
        }
        AppMethodBeat.m2505o(81498);
        return false;
    }

    /* renamed from: aQ */
    public static void m45945aQ(Context context, String str) {
        AppMethodBeat.m2504i(81499);
        C30379h.m48448a(context, str, null, false, new C289241());
        AppMethodBeat.m2505o(81499);
    }

    /* renamed from: fT */
    public static String m45946fT(String str, String str2) {
        AppMethodBeat.m2504i(81500);
        String value = C26373g.m41964Nu().getValue("ScanBookWording");
        C4990ab.m7416i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + C5046bo.nullAsNil(value));
        if (!C5046bo.isNullOrNil(value)) {
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
                if (!C5046bo.isNullOrNil(value)) {
                    str2 = value;
                }
            }
        }
        AppMethodBeat.m2505o(81500);
        return str2;
    }

    public static boolean cio() {
        AppMethodBeat.m2504i(81501);
        int i = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("EnableNewOCRTranslation", 0);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("NewOCRTranslationSupportUserLanguage");
        String str = "MicroMsg.ScannerUtil";
        String str2 = "enable %s, support lang %s, current lang %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(i == 1);
        objArr[1] = value;
        objArr[2] = C4988aa.dor();
        C4990ab.m7417i(str, str2, objArr);
        if (i == 1 && !C5046bo.isNullOrNil(value)) {
            String[] split = value.split(";");
            if (split != null && Arrays.asList(split).contains(C4988aa.dor())) {
                AppMethodBeat.m2505o(81501);
                return true;
            }
        }
        AppMethodBeat.m2505o(81501);
        return false;
    }
}
