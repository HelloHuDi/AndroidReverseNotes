package com.tencent.p177mm.plugin.topstory.p541ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C13994b;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C13995c;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C14002d;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.TopStoryWebView;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.cho;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.topstory.ui.home.d */
public final class C4227d {
    private chn sDb;
    private C13995c sDc;
    private TopStoryWebView sDd;
    private C43702e sDe;
    boolean sDf = false;
    public HashMap<Integer, cho> sDg = new HashMap();
    HashMap<Integer, String> sDh = new HashMap();

    public C4227d() {
        AppMethodBeat.m2504i(1701);
        AppMethodBeat.m2505o(1701);
    }

    /* renamed from: a */
    public final void mo9146a(chn chn, boolean z) {
        AppMethodBeat.m2504i(1702);
        if (!this.sDf) {
            this.sDf = true;
            C4210c.m6561c(chn, "startCreateWB", System.currentTimeMillis());
            this.sDb = chn;
            this.sDc = new C13995c();
            int i = chn.cdf <= 0 ? 100 : chn.cdf;
            String a = m6569a(chn, i, z);
            this.sDd = new TopStoryWebView(C4996ah.getContext());
            C13994b c13994b = new C13994b();
            C14002d c14002d = new C14002d(chn, this.sDc);
            this.sDe = new C43702e(this.sDd, chn, this.sDc);
            this.sDd.mo51379a(c13994b, c14002d);
            this.sDd.addJavascriptInterface(this.sDe, "topStoryJSApi");
            if (this.sDc.sHw != null) {
                this.sDc.mo26229y(a, (String) this.sDh.get(Integer.valueOf(i)), cFL());
                this.sDd.loadDataWithBaseURL(chn.url, new String(this.sDc.sHw), "text/html", ProtocolPackage.ServerEncoding, null);
                this.sDc.sHw = null;
                C4210c.m6561c(chn, "endCreateWBWithLoadData", System.currentTimeMillis());
            } else {
                this.sDd.loadUrl(chn.url);
                C4210c.m6561c(chn, "endCreateWBWithLoadURL", System.currentTimeMillis());
            }
            if (100 == i) {
                this.sDe.abM("");
            }
        }
        AppMethodBeat.m2505o(1702);
    }

    /* renamed from: b */
    public final void mo9147b(C46302b c46302b) {
        AppMethodBeat.m2504i(1703);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", Integer.valueOf(c46302b.hashCode()));
        c46302b.mo74466a(this.sDc, this.sDd, this.sDe, this.sDb);
        this.sDc = null;
        this.sDd = null;
        this.sDe = null;
        this.sDb = null;
        this.sDf = false;
        AppMethodBeat.m2505o(1703);
    }

    /* renamed from: a */
    private String m6569a(chn chn, int i, boolean z) {
        AppMethodBeat.m2504i(1704);
        String str = "";
        if (this.sDg.containsKey(Integer.valueOf(i))) {
            cho cho = (cho) this.sDg.get(Integer.valueOf(i));
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", Long.valueOf(cho.xgq), Integer.valueOf(cho.wSb), Integer.valueOf(cho.xgr), Long.valueOf(System.currentTimeMillis()));
            if (cho.xgq + ((long) (cho.wSb * 1000)) > System.currentTimeMillis()) {
                this.sDc.cHl();
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
                str = cho.ncM;
            } else {
                if (cho.xgq + ((long) (cho.xgr * 1000)) > System.currentTimeMillis()) {
                    this.sDc.cHl();
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
                    str = cho.ncM;
                } else {
                    this.sDc.cHl();
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
                }
                chn.xgp.addAll(cho.wSd);
                if (z) {
                    this.sDc.mo26227a(chn, false, false, 0);
                }
            }
        } else {
            this.sDc.cHl();
            if (z) {
                this.sDc.mo26227a(chn, false, false, 0);
            }
        }
        AppMethodBeat.m2505o(1704);
        return str;
    }

    private boolean cFL() {
        AppMethodBeat.m2504i(1705);
        if (this.sDg.containsKey(Integer.valueOf(100))) {
            cho cho = (cho) this.sDg.get(Integer.valueOf(100));
            if (((long) (cho.wSb * 1000)) + cho.xgq > System.currentTimeMillis()) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
                AppMethodBeat.m2505o(1705);
                return false;
            }
        }
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
        AppMethodBeat.m2505o(1705);
        return true;
    }

    /* renamed from: bp */
    public final void mo9148bp(int i, String str) {
        AppMethodBeat.m2504i(1706);
        this.sDh.put(Integer.valueOf(i), str);
        try {
            byte[] bytes = str.getBytes(ProtocolPackage.ServerEncoding);
            File file = new File(C39964g.cFo());
            if (!file.exists()) {
                file.mkdirs();
            }
            C5730e.m8624b(C39964g.cFo() + i, bytes, bytes.length);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", Integer.valueOf(i), Integer.valueOf(bytes.length));
            AppMethodBeat.m2505o(1706);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "putNegDataCache", new Object[0]);
            AppMethodBeat.m2505o(1706);
        }
    }

    /* renamed from: bq */
    public final synchronized void mo9149bq(final int i, final String str) {
        AppMethodBeat.m2504i(1707);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1707);
        } else {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId begin: %s, %s", Integer.valueOf(i), str);
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1700);
                    try {
                        JSONArray jSONArray;
                        String str = (String) C4227d.this.sDh.get(Integer.valueOf(i));
                        if (C5046bo.isNullOrNil(str)) {
                            jSONArray = new JSONArray();
                        } else {
                            jSONArray = new JSONArray(str);
                        }
                        jSONArray.put(str);
                        C4227d.this.mo9148bp(i, jSONArray.toString());
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId finish: %s, %s", Integer.valueOf(i), str);
                        AppMethodBeat.m2505o(1700);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId, exception: " + e.getMessage());
                        AppMethodBeat.m2505o(1700);
                    }
                }
            }, "addNegDocId");
            AppMethodBeat.m2505o(1707);
        }
    }

    public final void cFM() {
        AppMethodBeat.m2504i(1708);
        File file = new File(C39964g.cFo());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", file.getAbsolutePath());
                AppMethodBeat.m2505o(1708);
                return;
            }
            for (File file2 : listFiles) {
                int i = C5046bo.getInt(file2.getName(), -1);
                if (i > 0) {
                    try {
                        this.sDh.put(Integer.valueOf(i), new String(C5730e.m8632e(file2.getAbsolutePath(), 0, -1), ProtocolPackage.ServerEncoding));
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", Integer.valueOf(i), Integer.valueOf(r6.length));
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "loadNegDataCache %s", file2.getAbsoluteFile());
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", file2.getAbsolutePath());
                }
            }
            AppMethodBeat.m2505o(1708);
            return;
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", file.getAbsolutePath());
        AppMethodBeat.m2505o(1708);
    }
}
