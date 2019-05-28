package com.tencent.p177mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18427vl;
import com.tencent.p177mm.protocal.protobuf.cvg;
import com.tencent.p177mm.protocal.protobuf.cvh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.api.ac */
public final class C29736ac {
    private static C1202f fur = new C144211();
    private static HashMap<String, C5127a> uao = new HashMap();
    private static Map<String, JSONObject> uap = new HashMap();
    private static C46404u uaq;
    private static HashMap<String, Long> uar;
    private static String uas = "";

    /* renamed from: com.tencent.mm.plugin.websearch.api.ac$1 */
    static class C144211 implements C1202f {
        C144211() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(124152);
            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (c1207m instanceof C46404u) {
                C1720g.m3540Rg().mo14546b(1948, C29736ac.fur);
                C18427vl c18427vl = new C18427vl();
                if (i == 0 && i2 == 0) {
                    C46404u c46404u = (C46404u) c1207m;
                    cvh cvh = c46404u.tZS;
                    cvg cvg = c46404u.tZR;
                    C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", cvh.vOy);
                    if (C29736ac.m47145gU(cvg.luQ, cvh.vOy) == C29737a.Valid) {
                        c18427vl.cSv.result = 0;
                    } else {
                        c18427vl.cSv.result = -1;
                    }
                } else {
                    c18427vl.cSv.result = -1;
                }
                C4879a.xxA.mo10055m(c18427vl);
            }
            AppMethodBeat.m2505o(124152);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.api.ac$a */
    public enum C29737a {
        Valid,
        Expired,
        Invalid;

        static {
            AppMethodBeat.m2505o(124155);
        }
    }

    /* renamed from: gU */
    static /* synthetic */ C29737a m47145gU(String str, String str2) {
        AppMethodBeat.m2504i(124164);
        C29737a gT = C29736ac.m47144gT(str, str2);
        AppMethodBeat.m2505o(124164);
        return gT;
    }

    static {
        AppMethodBeat.m2504i(124165);
        uao.put("zh_CN", C5127a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING);
        uao.put("zh_HK", C5127a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING);
        uao.put("zh_TW", C5127a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING);
        uao.put("en", C5127a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING);
        uao.put("ar", C5127a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING);
        uao.put("de", C5127a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING);
        uao.put("de_DE", C5127a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING);
        uao.put("es", C5127a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING);
        uao.put("fr", C5127a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING);
        uao.put("he", C5127a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING);
        uao.put("hi", C5127a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING);
        uao.put("id", C5127a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING);
        uao.put("in", C5127a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING);
        uao.put("it", C5127a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING);
        uao.put("iw", C5127a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING);
        uao.put("ja", C5127a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING);
        uao.put("ko", C5127a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING);
        uao.put("lo", C5127a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING);
        uao.put("ms", C5127a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING);
        uao.put("my", C5127a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING);
        uao.put("pl", C5127a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING);
        uao.put("pt", C5127a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING);
        uao.put("ru", C5127a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING);
        uao.put("th", C5127a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING);
        uao.put("tr", C5127a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING);
        uao.put("vi", C5127a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING);
        AppMethodBeat.m2505o(124165);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Ig */
    public static boolean m47143Ig(int i) {
        AppMethodBeat.m2504i(124156);
        if (uar == null) {
            uar = new HashMap();
        }
        String gw = C4988aa.m7403gw(C4996ah.getContext());
        if (uas == null || uas.equalsIgnoreCase(gw)) {
            Long l = (Long) uar.get(gw);
            if (l == null) {
                l = Long.valueOf(0);
            }
            if (System.currentTimeMillis() - l.longValue() < 600000) {
                AppMethodBeat.m2505o(124156);
                return false;
            }
            JSONObject adJ;
            C29737a c29737a;
            uar.put(gw, Long.valueOf(System.currentTimeMillis()));
            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", gw, Integer.valueOf(i), Long.valueOf(0));
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C29736ac.adK(gw), null);
            try {
                if (!C5046bo.isNullOrNil(str)) {
                    adJ = C29736ac.adJ(str);
                    if (adJ != null) {
                        c29737a = C29737a.Invalid;
                    } else if (adJ.optLong("updateTime") + (adJ.optLong("timevalSec") * 1000) < System.currentTimeMillis()) {
                        c29737a = C29737a.Expired;
                    } else {
                        c29737a = C29737a.Valid;
                    }
                    if (c29737a == C29737a.Valid) {
                        AppMethodBeat.m2505o(124156);
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            adJ = null;
            if (adJ != null) {
            }
            if (c29737a == C29737a.Valid) {
            }
        }
        uas = gw;
        if (uaq != null) {
            C1720g.m3540Rg().mo14547c(uaq);
            uaq = null;
        }
        uaq = new C46404u(i);
        C1720g.m3540Rg().mo14539a(1948, fur);
        C1720g.m3540Rg().mo14541a(uaq, 0);
        AppMethodBeat.m2505o(124156);
        return true;
    }

    private static JSONObject adJ(String str) {
        AppMethodBeat.m2504i(124157);
        JSONObject jSONObject;
        if (!uap.containsKey(str) || uap.get(str) == null) {
            try {
                jSONObject = new JSONObject(str);
                uap.put(str, jSONObject);
                AppMethodBeat.m2505o(124157);
                return jSONObject;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(124157);
                return null;
            }
        }
        jSONObject = (JSONObject) uap.get(str);
        AppMethodBeat.m2505o(124157);
        return jSONObject;
    }

    private static C5127a adK(String str) {
        AppMethodBeat.m2504i(124158);
        C5127a c5127a = (C5127a) uao.get(str);
        if (c5127a == null) {
            c5127a = C5127a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING;
        }
        AppMethodBeat.m2505o(124158);
        return c5127a;
    }

    /* renamed from: gT */
    private static C29737a m47144gT(String str, String str2) {
        AppMethodBeat.m2504i(124159);
        C29737a c29737a;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("updateTime", System.currentTimeMillis());
            Object jSONObject2 = jSONObject.toString();
            C1720g.m3536RP().mo5239Ry().set(C29736ac.adK(str), jSONObject2);
            try {
                uap.put(jSONObject2, new JSONObject(jSONObject2));
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, "", new Object[0]);
            }
            c29737a = C29737a.Valid;
            AppMethodBeat.m2505o(124159);
            return c29737a;
        } catch (JSONException e2) {
            c29737a = C29737a.Invalid;
            AppMethodBeat.m2505o(124159);
            return c29737a;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x003f A:{SYNTHETIC, Splitter:B:6:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static JSONObject adL(String str) {
        String str2;
        JSONObject optJSONObject;
        Object obj;
        String obj2;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        AppMethodBeat.m2504i(124160);
        String str3 = "";
        try {
            str2 = (String) C1720g.m3536RP().mo5239Ry().get(C29736ac.adK(C4988aa.m7403gw(C4996ah.getContext())), null);
            if (!C5046bo.isNullOrNil(str2)) {
                jSONObject2 = C29736ac.adJ(str2).optJSONObject("data").optJSONObject(str);
                str2 = "Config Storage";
                if (jSONObject2 == null) {
                    try {
                        str3 = C29736ac.cVj();
                        if (str3 != null) {
                            optJSONObject = new JSONObject(str3).optJSONObject("data").optJSONObject(str);
                            try {
                                str2 = "Asset";
                                obj2 = str2;
                            } catch (Exception e) {
                                jSONObject2 = optJSONObject;
                                obj2 = str2;
                                optJSONObject = jSONObject2;
                                if (optJSONObject == null) {
                                }
                                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                                AppMethodBeat.m2505o(124160);
                                return jSONObject;
                            }
                            if (optJSONObject == null) {
                                jSONObject = new JSONObject();
                            } else {
                                jSONObject = optJSONObject;
                            }
                            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                            AppMethodBeat.m2505o(124160);
                            return jSONObject;
                        }
                    } catch (Exception e2) {
                        obj2 = str2;
                        optJSONObject = jSONObject2;
                        if (optJSONObject == null) {
                        }
                        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                        AppMethodBeat.m2505o(124160);
                        return jSONObject;
                    }
                }
                optJSONObject = jSONObject2;
                obj2 = str2;
                if (optJSONObject == null) {
                }
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                AppMethodBeat.m2505o(124160);
                return jSONObject;
            }
        } catch (Exception e3) {
        }
        str2 = str3;
        if (jSONObject2 == null) {
        }
        optJSONObject = jSONObject2;
        obj2 = str2;
        if (optJSONObject == null) {
        }
        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
        AppMethodBeat.m2505o(124160);
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0034 A:{SYNTHETIC, Splitter:B:6:0x0034} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String adM(String str) {
        String str2;
        JSONObject jSONObject;
        Object obj;
        Object opt;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = null;
        AppMethodBeat.m2504i(124161);
        String str3 = "";
        try {
            str2 = (String) C1720g.m3536RP().mo5239Ry().get(C29736ac.adK(C4988aa.m7403gw(C4996ah.getContext())), null);
            if (!C5046bo.isNullOrNil(str2)) {
                jSONObject3 = C29736ac.adJ(str2);
                str2 = "Config Storage";
                if (jSONObject3 == null) {
                    String cVj;
                    try {
                        cVj = C29736ac.cVj();
                        if (cVj != null) {
                            jSONObject = new JSONObject(cVj);
                            try {
                                str2 = "Asset";
                                obj = str2;
                            } catch (Exception e) {
                                jSONObject3 = jSONObject;
                                cVj = str2;
                                jSONObject = jSONObject3;
                                if (jSONObject == null) {
                                }
                                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
                                opt = jSONObject2.opt(str);
                                if (opt == null) {
                                }
                            }
                            if (jSONObject == null) {
                                jSONObject2 = new JSONObject();
                            } else {
                                jSONObject2 = jSONObject;
                            }
                            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
                            opt = jSONObject2.opt(str);
                            if (opt == null) {
                                str2 = "";
                                AppMethodBeat.m2505o(124161);
                                return str2;
                            }
                            str2 = opt.toString();
                            AppMethodBeat.m2505o(124161);
                            return str2;
                        }
                    } catch (Exception e2) {
                        cVj = str2;
                        jSONObject = jSONObject3;
                        if (jSONObject == null) {
                        }
                        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
                        opt = jSONObject2.opt(str);
                        if (opt == null) {
                        }
                    }
                }
                jSONObject = jSONObject3;
                obj = str2;
                if (jSONObject == null) {
                }
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
                opt = jSONObject2.opt(str);
                if (opt == null) {
                }
            }
        } catch (Exception e3) {
        }
        str2 = str3;
        if (jSONObject3 == null) {
        }
        jSONObject = jSONObject3;
        obj = str2;
        if (jSONObject == null) {
        }
        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
        opt = jSONObject2.opt(str);
        if (opt == null) {
        }
    }

    private static String cVj() {
        Exception e;
        Throwable th;
        String str = null;
        AppMethodBeat.m2504i(124162);
        Closeable open;
        try {
            open = C4996ah.getContext().getAssets().open("webconfig/default.".concat(String.valueOf(C4988aa.m7403gw(C4996ah.getContext()))));
            try {
                str = C5046bo.m7504I(open);
                C5046bo.m7527b(open);
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, e.getMessage(), new Object[0]);
                    C5046bo.m7527b(open);
                    AppMethodBeat.m2505o(124162);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(open);
                    AppMethodBeat.m2505o(124162);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            open = str;
        } catch (Throwable th3) {
            th = th3;
            open = str;
            C5046bo.m7527b(open);
            AppMethodBeat.m2505o(124162);
            throw th;
        }
        AppMethodBeat.m2505o(124162);
        return str;
    }

    public static String adN(String str) {
        AppMethodBeat.m2504i(124163);
        JSONObject adL = C29736ac.adL("entranceWording");
        if (adL != null) {
            String optString = adL.optString(str);
            AppMethodBeat.m2505o(124163);
            return optString;
        }
        AppMethodBeat.m2505o(124163);
        return null;
    }
}
