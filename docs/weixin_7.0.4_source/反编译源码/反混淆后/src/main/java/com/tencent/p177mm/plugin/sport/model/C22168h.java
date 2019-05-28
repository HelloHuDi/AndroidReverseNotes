package com.tencent.p177mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.sport.PluginSport;
import com.tencent.p177mm.plugin.sport.p1302a.C39857a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sport.model.h */
public final class C22168h {
    private static C1202f fur = new C221691();
    private static long rPG;
    private static JSONObject rPH;
    private static C13733a rPI;

    /* renamed from: com.tencent.mm.plugin.sport.model.h$a */
    public interface C13733a {
        /* renamed from: Pi */
        void mo25935Pi();
    }

    /* renamed from: com.tencent.mm.plugin.sport.model.h$1 */
    static class C221691 implements C1202f {
        C221691() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(93677);
            if (c1207m instanceof C22165e) {
                C1720g.m3540Rg().mo14546b(1947, C22168h.fur);
                if (i == 0 && i2 == 0) {
                    C4990ab.m7417i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", ((C22165e) c1207m).rPu.vFt);
                    C22168h.m33792ZS(r0.vFt);
                    String jSONObject = C22168h.cwt().toString();
                    C43623k.m78063ZT(jSONObject);
                    ((PluginSport) C1720g.m3530M(PluginSport.class)).getDeviceStepManager().mo74382ZR(jSONObject);
                    if (C22168h.rPI != null) {
                        C22168h.rPI.mo25935Pi();
                    }
                }
            }
            AppMethodBeat.m2505o(93677);
        }
    }

    public static boolean cws() {
        AppMethodBeat.m2504i(93678);
        if (rPG == 0) {
            rPG = C43623k.m78065aa(1, 0);
        }
        if (System.currentTimeMillis() - rPG > 86400000) {
            rPG = System.currentTimeMillis();
            C43623k.m78066ab(1, rPG);
            C4990ab.m7416i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
            C1720g.m3540Rg().mo14539a(1947, fur);
            C1720g.m3540Rg().mo14541a(new C22165e(), 0);
            AppMethodBeat.m2505o(93678);
            return true;
        }
        C4990ab.m7417i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", C22172n.m33800fQ(rPG));
        AppMethodBeat.m2505o(93678);
        return false;
    }

    static {
        AppMethodBeat.m2504i(93683);
        AppMethodBeat.m2505o(93683);
    }

    /* renamed from: lp */
    public static void m33794lp(boolean z) {
        AppMethodBeat.m2504i(93679);
        JSONObject cwt = C22168h.cwt();
        try {
            cwt.put("checkWeSportInstall", z ? 1 : 0);
        } catch (JSONException e) {
        }
        String jSONObject = cwt.toString();
        C43623k.m78063ZT(jSONObject);
        ((PluginSport) C1720g.m3530M(PluginSport.class)).getDeviceStepManager().mo74382ZR(jSONObject);
        if (rPI != null) {
            rPI.mo25935Pi();
        }
        AppMethodBeat.m2505o(93679);
    }

    /* renamed from: ZS */
    public static void m33792ZS(String str) {
        AppMethodBeat.m2504i(93680);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(93680);
            return;
        }
        try {
            rPH = new JSONObject(str);
            AppMethodBeat.m2505o(93680);
        } catch (Exception e) {
            rPH = null;
            AppMethodBeat.m2505o(93680);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static JSONObject cwt() {
        AppMethodBeat.m2504i(93681);
        if (rPH == null) {
            String string;
            String str = "";
            if (C4996ah.bqo()) {
                string = ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportFileStorage().getString(2, str);
            } else {
                string = new C43622j(C39857a.rOY).getString(2, str);
            }
            str = "";
            if (!C5046bo.isNullOrNil(string)) {
                try {
                    rPH = new JSONObject(string);
                    if (C4996ah.bqo()) {
                        rPH.put("checkWeSportInstall", C22172n.cvY() ? 1 : 0);
                    }
                    string = "server config";
                } catch (Exception e) {
                }
                if (rPH == null) {
                    rPH = C22168h.cwu();
                    try {
                        if (C4996ah.bqo()) {
                            int i;
                            JSONObject jSONObject = rPH;
                            String str2 = "checkWeSportInstall";
                            if (C22172n.cvY()) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            jSONObject.put(str2, i);
                        }
                    } catch (Exception e2) {
                    }
                    string = "asset";
                }
                if (rPH == null) {
                    rPH = new JSONObject();
                    string = "new";
                }
                C4990ab.m7417i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", string, rPH.toString());
            }
            string = str;
            if (rPH == null) {
            }
            if (rPH == null) {
            }
            C4990ab.m7417i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", string, rPH.toString());
        }
        JSONObject jSONObject2 = rPH;
        AppMethodBeat.m2505o(93681);
        return jSONObject2;
    }

    private static JSONObject cwu() {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(93682);
        InputStream inputStream = null;
        try {
            inputStream = C4996ah.getContext().getAssets().open("sport_config.json");
            jSONObject = new JSONObject(new String(C1173e.m2574q(inputStream)));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", e2, "get assets sport config json", new Object[0]);
            jSONObject = new JSONObject();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.m2505o(93682);
        }
        AppMethodBeat.m2505o(93682);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m33793a(C13733a c13733a) {
        rPI = c13733a;
    }
}
