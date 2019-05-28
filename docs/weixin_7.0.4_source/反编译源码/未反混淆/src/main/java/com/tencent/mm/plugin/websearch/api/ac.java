package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac {
    private static f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(124152);
            ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (mVar instanceof u) {
                g.Rg().b(1948, ac.fur);
                vl vlVar = new vl();
                if (i == 0 && i2 == 0) {
                    u uVar = (u) mVar;
                    cvh cvh = uVar.tZS;
                    cvg cvg = uVar.tZR;
                    ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", cvh.vOy);
                    if (ac.gU(cvg.luQ, cvh.vOy) == a.Valid) {
                        vlVar.cSv.result = 0;
                    } else {
                        vlVar.cSv.result = -1;
                    }
                } else {
                    vlVar.cSv.result = -1;
                }
                com.tencent.mm.sdk.b.a.xxA.m(vlVar);
            }
            AppMethodBeat.o(124152);
        }
    };
    private static HashMap<String, com.tencent.mm.storage.ac.a> uao = new HashMap();
    private static Map<String, JSONObject> uap = new HashMap();
    private static u uaq;
    private static HashMap<String, Long> uar;
    private static String uas = "";

    public enum a {
        Valid,
        Expired,
        Invalid;

        static {
            AppMethodBeat.o(124155);
        }
    }

    static /* synthetic */ a gU(String str, String str2) {
        AppMethodBeat.i(124164);
        a gT = gT(str, str2);
        AppMethodBeat.o(124164);
        return gT;
    }

    static {
        AppMethodBeat.i(124165);
        uao.put("zh_CN", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING);
        uao.put("zh_HK", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING);
        uao.put("zh_TW", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING);
        uao.put("en", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING);
        uao.put("ar", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING);
        uao.put("de", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING);
        uao.put("de_DE", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING);
        uao.put("es", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING);
        uao.put("fr", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING);
        uao.put("he", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING);
        uao.put("hi", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING);
        uao.put("id", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING);
        uao.put("in", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING);
        uao.put("it", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING);
        uao.put("iw", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING);
        uao.put("ja", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING);
        uao.put("ko", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING);
        uao.put("lo", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING);
        uao.put("ms", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING);
        uao.put("my", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING);
        uao.put("pl", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING);
        uao.put("pt", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING);
        uao.put("ru", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING);
        uao.put("th", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING);
        uao.put("tr", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING);
        uao.put("vi", com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING);
        AppMethodBeat.o(124165);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Ig(int i) {
        AppMethodBeat.i(124156);
        if (uar == null) {
            uar = new HashMap();
        }
        String gw = aa.gw(ah.getContext());
        if (uas == null || uas.equalsIgnoreCase(gw)) {
            Long l = (Long) uar.get(gw);
            if (l == null) {
                l = Long.valueOf(0);
            }
            if (System.currentTimeMillis() - l.longValue() < 600000) {
                AppMethodBeat.o(124156);
                return false;
            }
            JSONObject adJ;
            a aVar;
            uar.put(gw, Long.valueOf(System.currentTimeMillis()));
            ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", gw, Integer.valueOf(i), Long.valueOf(0));
            String str = (String) g.RP().Ry().get(adK(gw), null);
            try {
                if (!bo.isNullOrNil(str)) {
                    adJ = adJ(str);
                    if (adJ != null) {
                        aVar = a.Invalid;
                    } else if (adJ.optLong("updateTime") + (adJ.optLong("timevalSec") * 1000) < System.currentTimeMillis()) {
                        aVar = a.Expired;
                    } else {
                        aVar = a.Valid;
                    }
                    if (aVar == a.Valid) {
                        AppMethodBeat.o(124156);
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            adJ = null;
            if (adJ != null) {
            }
            if (aVar == a.Valid) {
            }
        }
        uas = gw;
        if (uaq != null) {
            g.Rg().c(uaq);
            uaq = null;
        }
        uaq = new u(i);
        g.Rg().a(1948, fur);
        g.Rg().a(uaq, 0);
        AppMethodBeat.o(124156);
        return true;
    }

    private static JSONObject adJ(String str) {
        AppMethodBeat.i(124157);
        JSONObject jSONObject;
        if (!uap.containsKey(str) || uap.get(str) == null) {
            try {
                jSONObject = new JSONObject(str);
                uap.put(str, jSONObject);
                AppMethodBeat.o(124157);
                return jSONObject;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, "", new Object[0]);
                AppMethodBeat.o(124157);
                return null;
            }
        }
        jSONObject = (JSONObject) uap.get(str);
        AppMethodBeat.o(124157);
        return jSONObject;
    }

    private static com.tencent.mm.storage.ac.a adK(String str) {
        AppMethodBeat.i(124158);
        com.tencent.mm.storage.ac.a aVar = (com.tencent.mm.storage.ac.a) uao.get(str);
        if (aVar == null) {
            aVar = com.tencent.mm.storage.ac.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING;
        }
        AppMethodBeat.o(124158);
        return aVar;
    }

    private static a gT(String str, String str2) {
        AppMethodBeat.i(124159);
        a aVar;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("updateTime", System.currentTimeMillis());
            Object jSONObject2 = jSONObject.toString();
            g.RP().Ry().set(adK(str), jSONObject2);
            try {
                uap.put(jSONObject2, new JSONObject(jSONObject2));
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, "", new Object[0]);
            }
            aVar = a.Valid;
            AppMethodBeat.o(124159);
            return aVar;
        } catch (JSONException e2) {
            aVar = a.Invalid;
            AppMethodBeat.o(124159);
            return aVar;
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
        AppMethodBeat.i(124160);
        String str3 = "";
        try {
            str2 = (String) g.RP().Ry().get(adK(aa.gw(ah.getContext())), null);
            if (!bo.isNullOrNil(str2)) {
                jSONObject2 = adJ(str2).optJSONObject("data").optJSONObject(str);
                str2 = "Config Storage";
                if (jSONObject2 == null) {
                    try {
                        str3 = cVj();
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
                                ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                                AppMethodBeat.o(124160);
                                return jSONObject;
                            }
                            if (optJSONObject == null) {
                                jSONObject = new JSONObject();
                            } else {
                                jSONObject = optJSONObject;
                            }
                            ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                            AppMethodBeat.o(124160);
                            return jSONObject;
                        }
                    } catch (Exception e2) {
                        obj2 = str2;
                        optJSONObject = jSONObject2;
                        if (optJSONObject == null) {
                        }
                        ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                        AppMethodBeat.o(124160);
                        return jSONObject;
                    }
                }
                optJSONObject = jSONObject2;
                obj2 = str2;
                if (optJSONObject == null) {
                }
                ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
                AppMethodBeat.o(124160);
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
        ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", r4, str, obj2);
        AppMethodBeat.o(124160);
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
        AppMethodBeat.i(124161);
        String str3 = "";
        try {
            str2 = (String) g.RP().Ry().get(adK(aa.gw(ah.getContext())), null);
            if (!bo.isNullOrNil(str2)) {
                jSONObject3 = adJ(str2);
                str2 = "Config Storage";
                if (jSONObject3 == null) {
                    String cVj;
                    try {
                        cVj = cVj();
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
                                ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
                                opt = jSONObject2.opt(str);
                                if (opt == null) {
                                }
                            }
                            if (jSONObject == null) {
                                jSONObject2 = new JSONObject();
                            } else {
                                jSONObject2 = jSONObject;
                            }
                            ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
                            opt = jSONObject2.opt(str);
                            if (opt == null) {
                                str2 = "";
                                AppMethodBeat.o(124161);
                                return str2;
                            }
                            str2 = opt.toString();
                            AppMethodBeat.o(124161);
                            return str2;
                        }
                    } catch (Exception e2) {
                        cVj = str2;
                        jSONObject = jSONObject3;
                        if (jSONObject == null) {
                        }
                        ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
                        opt = jSONObject2.opt(str);
                        if (opt == null) {
                        }
                    }
                }
                jSONObject = jSONObject3;
                obj = str2;
                if (jSONObject == null) {
                }
                ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
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
        ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", r4, str, obj);
        opt = jSONObject2.opt(str);
        if (opt == null) {
        }
    }

    private static String cVj() {
        Exception e;
        Throwable th;
        String str = null;
        AppMethodBeat.i(124162);
        Closeable open;
        try {
            open = ah.getContext().getAssets().open("webconfig/default.".concat(String.valueOf(aa.gw(ah.getContext()))));
            try {
                str = bo.I(open);
                bo.b(open);
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, e.getMessage(), new Object[0]);
                    bo.b(open);
                    AppMethodBeat.o(124162);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(open);
                    AppMethodBeat.o(124162);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            open = str;
        } catch (Throwable th3) {
            th = th3;
            open = str;
            bo.b(open);
            AppMethodBeat.o(124162);
            throw th;
        }
        AppMethodBeat.o(124162);
        return str;
    }

    public static String adN(String str) {
        AppMethodBeat.i(124163);
        JSONObject adL = adL("entranceWording");
        if (adL != null) {
            String optString = adL.optString(str);
            AppMethodBeat.o(124163);
            return optString;
        }
        AppMethodBeat.o(124163);
        return null;
    }
}
