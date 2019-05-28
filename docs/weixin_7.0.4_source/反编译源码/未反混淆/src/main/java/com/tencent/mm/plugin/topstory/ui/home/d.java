package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.b;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.plugin.topstory.ui.webview.e;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;

public final class d {
    private chn sDb;
    private c sDc;
    private TopStoryWebView sDd;
    private e sDe;
    boolean sDf = false;
    public HashMap<Integer, cho> sDg = new HashMap();
    HashMap<Integer, String> sDh = new HashMap();

    public d() {
        AppMethodBeat.i(1701);
        AppMethodBeat.o(1701);
    }

    public final void a(chn chn, boolean z) {
        AppMethodBeat.i(1702);
        if (!this.sDf) {
            this.sDf = true;
            com.tencent.mm.plugin.topstory.ui.c.c(chn, "startCreateWB", System.currentTimeMillis());
            this.sDb = chn;
            this.sDc = new c();
            int i = chn.cdf <= 0 ? 100 : chn.cdf;
            String a = a(chn, i, z);
            this.sDd = new TopStoryWebView(ah.getContext());
            b bVar = new b();
            com.tencent.mm.plugin.topstory.ui.webview.d dVar = new com.tencent.mm.plugin.topstory.ui.webview.d(chn, this.sDc);
            this.sDe = new e(this.sDd, chn, this.sDc);
            this.sDd.a(bVar, dVar);
            this.sDd.addJavascriptInterface(this.sDe, "topStoryJSApi");
            if (this.sDc.sHw != null) {
                this.sDc.y(a, (String) this.sDh.get(Integer.valueOf(i)), cFL());
                this.sDd.loadDataWithBaseURL(chn.url, new String(this.sDc.sHw), "text/html", ProtocolPackage.ServerEncoding, null);
                this.sDc.sHw = null;
                com.tencent.mm.plugin.topstory.ui.c.c(chn, "endCreateWBWithLoadData", System.currentTimeMillis());
            } else {
                this.sDd.loadUrl(chn.url);
                com.tencent.mm.plugin.topstory.ui.c.c(chn, "endCreateWBWithLoadURL", System.currentTimeMillis());
            }
            if (100 == i) {
                this.sDe.abM("");
            }
        }
        AppMethodBeat.o(1702);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(1703);
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", Integer.valueOf(bVar.hashCode()));
        bVar.a(this.sDc, this.sDd, this.sDe, this.sDb);
        this.sDc = null;
        this.sDd = null;
        this.sDe = null;
        this.sDb = null;
        this.sDf = false;
        AppMethodBeat.o(1703);
    }

    private String a(chn chn, int i, boolean z) {
        AppMethodBeat.i(1704);
        String str = "";
        if (this.sDg.containsKey(Integer.valueOf(i))) {
            cho cho = (cho) this.sDg.get(Integer.valueOf(i));
            ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", Long.valueOf(cho.xgq), Integer.valueOf(cho.wSb), Integer.valueOf(cho.xgr), Long.valueOf(System.currentTimeMillis()));
            if (cho.xgq + ((long) (cho.wSb * 1000)) > System.currentTimeMillis()) {
                this.sDc.cHl();
                ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
                str = cho.ncM;
            } else {
                if (cho.xgq + ((long) (cho.xgr * 1000)) > System.currentTimeMillis()) {
                    this.sDc.cHl();
                    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
                    str = cho.ncM;
                } else {
                    this.sDc.cHl();
                    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
                }
                chn.xgp.addAll(cho.wSd);
                if (z) {
                    this.sDc.a(chn, false, false, 0);
                }
            }
        } else {
            this.sDc.cHl();
            if (z) {
                this.sDc.a(chn, false, false, 0);
            }
        }
        AppMethodBeat.o(1704);
        return str;
    }

    private boolean cFL() {
        AppMethodBeat.i(1705);
        if (this.sDg.containsKey(Integer.valueOf(100))) {
            cho cho = (cho) this.sDg.get(Integer.valueOf(100));
            if (((long) (cho.wSb * 1000)) + cho.xgq > System.currentTimeMillis()) {
                ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
                AppMethodBeat.o(1705);
                return false;
            }
        }
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
        AppMethodBeat.o(1705);
        return true;
    }

    public final void bp(int i, String str) {
        AppMethodBeat.i(1706);
        this.sDh.put(Integer.valueOf(i), str);
        try {
            byte[] bytes = str.getBytes(ProtocolPackage.ServerEncoding);
            File file = new File(g.cFo());
            if (!file.exists()) {
                file.mkdirs();
            }
            com.tencent.mm.vfs.e.b(g.cFo() + i, bytes, bytes.length);
            ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", Integer.valueOf(i), Integer.valueOf(bytes.length));
            AppMethodBeat.o(1706);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "putNegDataCache", new Object[0]);
            AppMethodBeat.o(1706);
        }
    }

    public final synchronized void bq(final int i, final String str) {
        AppMethodBeat.i(1707);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1707);
        } else {
            ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId begin: %s, %s", Integer.valueOf(i), str);
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1700);
                    try {
                        JSONArray jSONArray;
                        String str = (String) d.this.sDh.get(Integer.valueOf(i));
                        if (bo.isNullOrNil(str)) {
                            jSONArray = new JSONArray();
                        } else {
                            jSONArray = new JSONArray(str);
                        }
                        jSONArray.put(str);
                        d.this.bp(i, jSONArray.toString());
                        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId finish: %s, %s", Integer.valueOf(i), str);
                        AppMethodBeat.o(1700);
                    } catch (Exception e) {
                        ab.e("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId, exception: " + e.getMessage());
                        AppMethodBeat.o(1700);
                    }
                }
            }, "addNegDocId");
            AppMethodBeat.o(1707);
        }
    }

    public final void cFM() {
        AppMethodBeat.i(1708);
        File file = new File(g.cFo());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", file.getAbsolutePath());
                AppMethodBeat.o(1708);
                return;
            }
            for (File file2 : listFiles) {
                int i = bo.getInt(file2.getName(), -1);
                if (i > 0) {
                    try {
                        this.sDh.put(Integer.valueOf(i), new String(com.tencent.mm.vfs.e.e(file2.getAbsolutePath(), 0, -1), ProtocolPackage.ServerEncoding));
                        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", Integer.valueOf(i), Integer.valueOf(r6.length));
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "loadNegDataCache %s", file2.getAbsoluteFile());
                    }
                } else {
                    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", file2.getAbsolutePath());
                }
            }
            AppMethodBeat.o(1708);
            return;
        }
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", file.getAbsolutePath());
        AppMethodBeat.o(1708);
    }
}
