package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(93677);
            if (mVar instanceof e) {
                g.Rg().b(1947, h.fur);
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", ((e) mVar).rPu.vFt);
                    h.ZS(r0.vFt);
                    String jSONObject = h.cwt().toString();
                    k.ZT(jSONObject);
                    ((PluginSport) g.M(PluginSport.class)).getDeviceStepManager().ZR(jSONObject);
                    if (h.rPI != null) {
                        h.rPI.Pi();
                    }
                }
            }
            AppMethodBeat.o(93677);
        }
    };
    private static long rPG;
    private static JSONObject rPH;
    private static a rPI;

    public interface a {
        void Pi();
    }

    public static boolean cws() {
        AppMethodBeat.i(93678);
        if (rPG == 0) {
            rPG = k.aa(1, 0);
        }
        if (System.currentTimeMillis() - rPG > 86400000) {
            rPG = System.currentTimeMillis();
            k.ab(1, rPG);
            ab.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
            g.Rg().a(1947, fur);
            g.Rg().a(new e(), 0);
            AppMethodBeat.o(93678);
            return true;
        }
        ab.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", n.fQ(rPG));
        AppMethodBeat.o(93678);
        return false;
    }

    static {
        AppMethodBeat.i(93683);
        AppMethodBeat.o(93683);
    }

    public static void lp(boolean z) {
        AppMethodBeat.i(93679);
        JSONObject cwt = cwt();
        try {
            cwt.put("checkWeSportInstall", z ? 1 : 0);
        } catch (JSONException e) {
        }
        String jSONObject = cwt.toString();
        k.ZT(jSONObject);
        ((PluginSport) g.M(PluginSport.class)).getDeviceStepManager().ZR(jSONObject);
        if (rPI != null) {
            rPI.Pi();
        }
        AppMethodBeat.o(93679);
    }

    public static void ZS(String str) {
        AppMethodBeat.i(93680);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(93680);
            return;
        }
        try {
            rPH = new JSONObject(str);
            AppMethodBeat.o(93680);
        } catch (Exception e) {
            rPH = null;
            AppMethodBeat.o(93680);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static JSONObject cwt() {
        AppMethodBeat.i(93681);
        if (rPH == null) {
            String string;
            String str = "";
            if (ah.bqo()) {
                string = ((PluginSport) g.M(PluginSport.class)).getSportFileStorage().getString(2, str);
            } else {
                string = new j(com.tencent.mm.plugin.sport.a.a.rOY).getString(2, str);
            }
            str = "";
            if (!bo.isNullOrNil(string)) {
                try {
                    rPH = new JSONObject(string);
                    if (ah.bqo()) {
                        rPH.put("checkWeSportInstall", n.cvY() ? 1 : 0);
                    }
                    string = "server config";
                } catch (Exception e) {
                }
                if (rPH == null) {
                    rPH = cwu();
                    try {
                        if (ah.bqo()) {
                            int i;
                            JSONObject jSONObject = rPH;
                            String str2 = "checkWeSportInstall";
                            if (n.cvY()) {
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
                ab.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", string, rPH.toString());
            }
            string = str;
            if (rPH == null) {
            }
            if (rPH == null) {
            }
            ab.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", string, rPH.toString());
        }
        JSONObject jSONObject2 = rPH;
        AppMethodBeat.o(93681);
        return jSONObject2;
    }

    private static JSONObject cwu() {
        JSONObject jSONObject;
        AppMethodBeat.i(93682);
        InputStream inputStream = null;
        try {
            inputStream = ah.getContext().getAssets().open("sport_config.json");
            jSONObject = new JSONObject(new String(e.q(inputStream)));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", e2, "get assets sport config json", new Object[0]);
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
            AppMethodBeat.o(93682);
        }
        AppMethodBeat.o(93682);
        return jSONObject;
    }

    public static void a(a aVar) {
        rPI = aVar;
    }
}
