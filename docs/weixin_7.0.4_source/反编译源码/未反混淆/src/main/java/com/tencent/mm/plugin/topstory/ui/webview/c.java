package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.util.d;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements f {
    private com.tencent.mm.plugin.topstory.a.c.b sAq;
    public f sEu = new f() {
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(2149);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i2);
                jSONObject.put("errMsg", str);
                if (i == 0 && i2 == 0) {
                    if (c.this.sHt != null) {
                        jSONObject.put("requestId", ((i) mVar).cFw().xgs);
                    }
                    if (c.this.sHt != null) {
                    }
                    AppMethodBeat.o(2149);
                }
                ab.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (c.this.sHt != null) {
                    c.this.sHt.abG(jSONObject.toString());
                }
                AppMethodBeat.o(2149);
            } catch (JSONException e) {
            }
        }
    };
    public f sHA = new f() {
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0047  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(2150);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i2);
                jSONObject.put("errMsg", str);
                if (i == 0 && i2 == 0) {
                    if (c.this.sHt != null) {
                        jSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a) mVar).cFs().xrb);
                        jSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a) mVar).cFs().nQB);
                    }
                    if (c.this.sHt != null) {
                    }
                    AppMethodBeat.o(2150);
                }
                ab.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                jSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a) mVar).nQB);
                if (c.this.sHt != null) {
                    c.this.sHt.abE(jSONObject.toString());
                }
                AppMethodBeat.o(2150);
            } catch (JSONException e) {
            }
        }
    };
    public com.tencent.mm.plugin.topstory.ui.home.a sHt;
    private boolean sHu;
    public b sHv;
    public byte[] sHw;
    byte[] sHx;
    byte[] sHy;
    public f sHz = new f() {
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(2148);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i2);
                jSONObject.put("errMsg", str);
                if (i == 0 && i2 == 0) {
                    if (c.this.sHt != null) {
                        String str2 = ((com.tencent.mm.plugin.topstory.a.c.f) mVar).cFu().xgx;
                        String str3 = ((com.tencent.mm.plugin.topstory.a.c.f) mVar).cFu().xgs;
                        jSONObject.put("commentId", str2);
                        jSONObject.put("requestId", str3);
                    }
                    if (c.this.sHt != null) {
                    }
                    AppMethodBeat.o(2148);
                }
                ab.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStoryPostComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (c.this.sHt != null) {
                    c.this.sHt.abF(jSONObject.toString());
                }
                AppMethodBeat.o(2148);
            } catch (JSONException e) {
            }
        }
    };

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(2152);
            long currentTimeMillis = System.currentTimeMillis();
            ao HQ = aa.HQ(1);
            String format = String.format("%s/%s", new Object[]{HQ.aLD(), "app.html"});
            String format2 = String.format("%s/%s", new Object[]{HQ.aLD(), "dist/build.js"});
            String format3 = String.format("%s/%s", new Object[]{HQ.aLD(), "dist/style.css"});
            c.this.sHw = e.e(format, 0, -1);
            c.this.sHx = e.e(format2, 0, -1);
            c.this.sHy = e.e(format3, 0, -1);
            String x = d.x(c.this.sHx);
            String cVz = HQ.cVz();
            if (x == null || !x.equals(cVz)) {
                com.tencent.mm.a.e.cu(HQ.aLD());
                aa.a(new com.tencent.mm.vfs.b(HQ.aLD()), 1);
                c.this.sHw = e.e(format, 0, -1);
                c.this.sHx = e.e(format2, 0, -1);
                c.this.sHy = e.e(format3, 0, -1);
                format = d.x(c.this.sHx);
                String cVz2 = HQ.cVz();
                an.Il(21);
                ab.i("MicroMsg.TopStory.TopStoryWebData", "update template file fileJSMd5 %s configJSMD5 %s", format, cVz2);
                long bl = (bl(c.this.sHw) + bl(c.this.sHx)) + bl(c.this.sHy);
                ab.i("MicroMsg.TopStory.TopStoryWebData", "loadHtmlDataFromSdcard totalLength: %d usetime: %d fileJSMd5 %s configJSMD5 %s", Long.valueOf(bl), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), format, cVz2);
            }
            AppMethodBeat.o(2152);
        }

        private static long bl(byte[] bArr) {
            return bArr == null ? 0 : (long) bArr.length;
        }
    }

    class b {
        long jKz;
        String sHD;
        chn sHE;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }

    public c() {
        AppMethodBeat.i(2153);
        AppMethodBeat.o(2153);
    }

    public final void cHl() {
        AppMethodBeat.i(2154);
        com.tencent.mm.sdk.g.d.post(new a(this, (byte) 0), "TopStory.LoadHtmlDataFromSdcardTask");
        AppMethodBeat.o(2154);
    }

    public final void y(String str, String str2, boolean z) {
        AppMethodBeat.i(2155);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(2155);
            return;
        }
        if (this.sHw != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put("newQuery", true);
                jSONObject.put("isCache", true);
                jSONObject.put("recType", z ? 1 : 0);
                if (!bo.isNullOrNil(str2)) {
                    jSONObject.put("filterDocidList", new JSONArray(str2));
                }
            } catch (Exception e) {
            }
            this.sHw = new String(this.sHw).replace("'###preloadObjFeedsData###'", jSONObject.toString() + IOUtils.LINE_SEPARATOR_UNIX).getBytes();
            ab.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", Integer.valueOf(this.sHw.length));
        }
        AppMethodBeat.o(2155);
    }

    public final void a(chn chn, boolean z, boolean z2, int i) {
        AppMethodBeat.i(2156);
        ab.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", Boolean.valueOf(z2));
        if (z2 || this.sAq == null || !chn.cvF.equals(this.sAq.cPu.cvF)) {
            this.sAq = new com.tencent.mm.plugin.topstory.a.c.b(chn, i);
            g.Rg().a(1943, (f) this);
            g.Rg().a(this.sAq, 0);
            this.sHu = z;
            ab.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
            AppMethodBeat.o(2156);
            return;
        }
        this.sHu = z;
        ab.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
        h.a(chn, "WaitCurrentNetScene", System.currentTimeMillis());
        AppMethodBeat.o(2156);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(2157);
        if (mVar.equals(this.sAq)) {
            g.Rg().b(1943, (f) this);
            this.sAq = null;
            com.tencent.mm.plugin.topstory.a.c.b bVar = (com.tencent.mm.plugin.topstory.a.c.b) mVar;
            if (i == 0 && i2 == 0) {
                final cve cFt = bVar.cFt();
                final String str2 = cFt.vOy;
                ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().lC((long) cFt.xri);
                a(bVar.cPu, str2, false);
                if (bVar.cFt().xrh != null && (bVar.cFt().xrh.wSe == 1 || ((PluginTopStoryUI) g.M(PluginTopStoryUI.class)).getTopStoryCommand().sBl)) {
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(2151);
                            cho cho = new cho();
                            cho.Category = cFt.xrh.Category;
                            cho.xgq = System.currentTimeMillis();
                            cho.wSb = cFt.xrh.wSb;
                            cho.xgr = cFt.xrh.wSc;
                            cho.ncM = str2;
                            cho.wSd = cFt.xrh.wSd;
                            ((PluginTopStoryUI) g.M(PluginTopStoryUI.class)).getWebViewMgr().sDg.put(Integer.valueOf(cho.Category), cho);
                            try {
                                byte[] toByteArray = cho.toByteArray();
                                File file = new File(com.tencent.mm.plugin.topstory.a.g.cFn());
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                e.b(com.tencent.mm.plugin.topstory.a.g.cFn() + cho.Category, toByteArray, toByteArray.length);
                                ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", Integer.valueOf(cho.Category), Integer.valueOf(toByteArray.length));
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "putHomeDataCache ", new Object[0]);
                            }
                            ((PluginTopStoryUI) g.M(PluginTopStoryUI.class)).getWebViewMgr().bp(cho.Category, "");
                            AppMethodBeat.o(2151);
                        }
                    }, "TopStory.CacheHomeData");
                }
            } else {
                ab.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
                a(bVar.cPu, cHm(), true);
                AppMethodBeat.o(2157);
                return;
            }
        }
        AppMethodBeat.o(2157);
    }

    private void a(chn chn, String str, boolean z) {
        AppMethodBeat.i(2158);
        if (this.sHu) {
            if (this.sHt != null) {
                this.sHt.abD(str);
            }
            this.sHu = false;
            AppMethodBeat.o(2158);
        } else if (z || chn.cdf != 100) {
            this.sHv = null;
            AppMethodBeat.o(2158);
        } else {
            this.sHv = new b(this, (byte) 0);
            this.sHv.sHE = chn;
            this.sHv.jKz = System.currentTimeMillis();
            this.sHv.sHD = str;
            AppMethodBeat.o(2158);
        }
    }

    private static String cHm() {
        AppMethodBeat.i(2159);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(2159);
        return jSONObject2;
    }
}
