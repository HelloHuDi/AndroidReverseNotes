package com.tencent.p177mm.plugin.topstory.p541ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C13944f;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C35292i;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C39961b;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C43690a;
import com.tencent.p177mm.plugin.topstory.p541ui.PluginTopStoryUI;
import com.tencent.p177mm.plugin.topstory.p541ui.home.C39969a;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C40190ao;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.cho;
import com.tencent.p177mm.protocal.protobuf.cve;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.util.C6037d;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.ui.webview.c */
public final class C13995c implements C1202f {
    private C39961b sAq;
    public C1202f sEu = new C139972();
    public C1202f sHA = new C139983();
    public C39969a sHt;
    private boolean sHu;
    public C14000b sHv;
    public byte[] sHw;
    byte[] sHx;
    byte[] sHy;
    public C1202f sHz = new C139961();

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.c$1 */
    class C139961 implements C1202f {
        C139961() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(2148);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i2);
                jSONObject.put("errMsg", str);
                if (i == 0 && i2 == 0) {
                    if (C13995c.this.sHt != null) {
                        String str2 = ((C13944f) c1207m).cFu().xgx;
                        String str3 = ((C13944f) c1207m).cFu().xgs;
                        jSONObject.put("commentId", str2);
                        jSONObject.put("requestId", str3);
                    }
                    if (C13995c.this.sHt != null) {
                    }
                    AppMethodBeat.m2505o(2148);
                }
                C4990ab.m7421w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStoryPostComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (C13995c.this.sHt != null) {
                    C13995c.this.sHt.abF(jSONObject.toString());
                }
                AppMethodBeat.m2505o(2148);
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.c$2 */
    class C139972 implements C1202f {
        C139972() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(2149);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i2);
                jSONObject.put("errMsg", str);
                if (i == 0 && i2 == 0) {
                    if (C13995c.this.sHt != null) {
                        jSONObject.put("requestId", ((C35292i) c1207m).cFw().xgs);
                    }
                    if (C13995c.this.sHt != null) {
                    }
                    AppMethodBeat.m2505o(2149);
                }
                C4990ab.m7421w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (C13995c.this.sHt != null) {
                    C13995c.this.sHt.abG(jSONObject.toString());
                }
                AppMethodBeat.m2505o(2149);
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.c$3 */
    class C139983 implements C1202f {
        C139983() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0047  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(2150);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i2);
                jSONObject.put("errMsg", str);
                if (i == 0 && i2 == 0) {
                    if (C13995c.this.sHt != null) {
                        jSONObject.put("commResp", ((C43690a) c1207m).cFs().xrb);
                        jSONObject.put("requestId", ((C43690a) c1207m).cFs().nQB);
                    }
                    if (C13995c.this.sHt != null) {
                    }
                    AppMethodBeat.m2505o(2150);
                }
                C4990ab.m7421w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                jSONObject.put("requestId", ((C43690a) c1207m).nQB);
                if (C13995c.this.sHt != null) {
                    C13995c.this.sHt.abE(jSONObject.toString());
                }
                AppMethodBeat.m2505o(2150);
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.c$a */
    class C13999a implements Runnable {
        private C13999a() {
        }

        /* synthetic */ C13999a(C13995c c13995c, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(2152);
            long currentTimeMillis = System.currentTimeMillis();
            C40190ao HQ = C46400aa.m87300HQ(1);
            String format = String.format("%s/%s", new Object[]{HQ.aLD(), "app.html"});
            String format2 = String.format("%s/%s", new Object[]{HQ.aLD(), "dist/build.js"});
            String format3 = String.format("%s/%s", new Object[]{HQ.aLD(), "dist/style.css"});
            C13995c.this.sHw = C5730e.m8632e(format, 0, -1);
            C13995c.this.sHx = C5730e.m8632e(format2, 0, -1);
            C13995c.this.sHy = C5730e.m8632e(format3, 0, -1);
            String x = C6037d.m9506x(C13995c.this.sHx);
            String cVz = HQ.cVz();
            if (x == null || !x.equals(cVz)) {
                C1173e.m2562cu(HQ.aLD());
                C46400aa.m87326a(new C5728b(HQ.aLD()), 1);
                C13995c.this.sHw = C5730e.m8632e(format, 0, -1);
                C13995c.this.sHx = C5730e.m8632e(format2, 0, -1);
                C13995c.this.sHy = C5730e.m8632e(format3, 0, -1);
                format = C6037d.m9506x(C13995c.this.sHx);
                String cVz2 = HQ.cVz();
                C14423an.m22640Il(21);
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebData", "update template file fileJSMd5 %s configJSMD5 %s", format, cVz2);
                long bl = (C13999a.m22138bl(C13995c.this.sHw) + C13999a.m22138bl(C13995c.this.sHx)) + C13999a.m22138bl(C13995c.this.sHy);
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebData", "loadHtmlDataFromSdcard totalLength: %d usetime: %d fileJSMd5 %s configJSMD5 %s", Long.valueOf(bl), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), format, cVz2);
            }
            AppMethodBeat.m2505o(2152);
        }

        /* renamed from: bl */
        private static long m22138bl(byte[] bArr) {
            return bArr == null ? 0 : (long) bArr.length;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.c$b */
    class C14000b {
        long jKz;
        String sHD;
        chn sHE;

        private C14000b() {
        }

        /* synthetic */ C14000b(C13995c c13995c, byte b) {
            this();
        }
    }

    public C13995c() {
        AppMethodBeat.m2504i(2153);
        AppMethodBeat.m2505o(2153);
    }

    public final void cHl() {
        AppMethodBeat.m2504i(2154);
        C7305d.post(new C13999a(this, (byte) 0), "TopStory.LoadHtmlDataFromSdcardTask");
        AppMethodBeat.m2505o(2154);
    }

    /* renamed from: y */
    public final void mo26229y(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(2155);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(2155);
            return;
        }
        if (this.sHw != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put("newQuery", true);
                jSONObject.put("isCache", true);
                jSONObject.put("recType", z ? 1 : 0);
                if (!C5046bo.isNullOrNil(str2)) {
                    jSONObject.put("filterDocidList", new JSONArray(str2));
                }
            } catch (Exception e) {
            }
            this.sHw = new String(this.sHw).replace("'###preloadObjFeedsData###'", jSONObject.toString() + IOUtils.LINE_SEPARATOR_UNIX).getBytes();
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", Integer.valueOf(this.sHw.length));
        }
        AppMethodBeat.m2505o(2155);
    }

    /* renamed from: a */
    public final void mo26227a(chn chn, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(2156);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", Boolean.valueOf(z2));
        if (z2 || this.sAq == null || !chn.cvF.equals(this.sAq.cPu.cvF)) {
            this.sAq = new C39961b(chn, i);
            C1720g.m3540Rg().mo14539a(1943, (C1202f) this);
            C1720g.m3540Rg().mo14541a(this.sAq, 0);
            this.sHu = z;
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
            AppMethodBeat.m2505o(2156);
            return;
        }
        this.sHu = z;
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
        C46297h.m86861a(chn, "WaitCurrentNetScene", System.currentTimeMillis());
        AppMethodBeat.m2505o(2156);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(2157);
        if (c1207m.equals(this.sAq)) {
            C1720g.m3540Rg().mo14546b(1943, (C1202f) this);
            this.sAq = null;
            C39961b c39961b = (C39961b) c1207m;
            if (i == 0 && i2 == 0) {
                final cve cFt = c39961b.cFt();
                final String str2 = cFt.vOy;
                ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().mo56038lC((long) cFt.xri);
                m22135a(c39961b.cPu, str2, false);
                if (c39961b.cFt().xrh != null && (c39961b.cFt().xrh.wSe == 1 || ((PluginTopStoryUI) C1720g.m3530M(PluginTopStoryUI.class)).getTopStoryCommand().sBl)) {
                    C7305d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(2151);
                            cho cho = new cho();
                            cho.Category = cFt.xrh.Category;
                            cho.xgq = System.currentTimeMillis();
                            cho.wSb = cFt.xrh.wSb;
                            cho.xgr = cFt.xrh.wSc;
                            cho.ncM = str2;
                            cho.wSd = cFt.xrh.wSd;
                            ((PluginTopStoryUI) C1720g.m3530M(PluginTopStoryUI.class)).getWebViewMgr().sDg.put(Integer.valueOf(cho.Category), cho);
                            try {
                                byte[] toByteArray = cho.toByteArray();
                                File file = new File(C39964g.cFn());
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                C5730e.m8624b(C39964g.cFn() + cho.Category, toByteArray, toByteArray.length);
                                C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", Integer.valueOf(cho.Category), Integer.valueOf(toByteArray.length));
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "putHomeDataCache ", new Object[0]);
                            }
                            ((PluginTopStoryUI) C1720g.m3530M(PluginTopStoryUI.class)).getWebViewMgr().mo9148bp(cho.Category, "");
                            AppMethodBeat.m2505o(2151);
                        }
                    }, "TopStory.CacheHomeData");
                }
            } else {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
                m22135a(c39961b.cPu, C13995c.cHm(), true);
                AppMethodBeat.m2505o(2157);
                return;
            }
        }
        AppMethodBeat.m2505o(2157);
    }

    /* renamed from: a */
    private void m22135a(chn chn, String str, boolean z) {
        AppMethodBeat.m2504i(2158);
        if (this.sHu) {
            if (this.sHt != null) {
                this.sHt.abD(str);
            }
            this.sHu = false;
            AppMethodBeat.m2505o(2158);
        } else if (z || chn.cdf != 100) {
            this.sHv = null;
            AppMethodBeat.m2505o(2158);
        } else {
            this.sHv = new C14000b(this, (byte) 0);
            this.sHv.sHE = chn;
            this.sHv.jKz = System.currentTimeMillis();
            this.sHv.sHD = str;
            AppMethodBeat.m2505o(2158);
        }
    }

    private static String cHm() {
        AppMethodBeat.m2504i(2159);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.m2505o(2159);
        return jSONObject2;
    }
}
