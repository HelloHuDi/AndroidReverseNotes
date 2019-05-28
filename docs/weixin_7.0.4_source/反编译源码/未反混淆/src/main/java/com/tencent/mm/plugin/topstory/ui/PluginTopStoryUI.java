package com.tencent.mm.plugin.topstory.ui;

import android.os.Build;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.g.a.im;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.a.a;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.xweb.WebView;
import java.io.File;

public class PluginTopStoryUI extends f implements b, c, a {
    private int sBd = 2;
    private b sBe;
    private d sBf;
    private a sBg;
    private com.tencent.mm.sdk.b.c<im> sBh = new com.tencent.mm.sdk.b.c<im>() {
        {
            AppMethodBeat.i(1521);
            this.xxI = im.class.getName().hashCode();
            AppMethodBeat.o(1521);
        }

        private boolean a(im imVar) {
            AppMethodBeat.i(1522);
            if (imVar.cDD == null) {
                AppMethodBeat.o(1522);
                return false;
            }
            ab.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", imVar.cDD.cDE, imVar.cDD.cDF);
            if (!(bo.isNullOrNil(imVar.cDD.cDE) || PluginTopStoryUI.this.sBg == null)) {
                PluginTopStoryUI.this.sBg.abA(imVar.cDD.cDE);
            }
            if (!bo.isNullOrNil(imVar.cDD.cDF)) {
                try {
                    i iVar = new i(imVar.cDD.cDF);
                    String string = iVar.getString(NativeProtocol.WEB_DIALOG_ACTION);
                    iVar = iVar.lB("params");
                    if (string.equals("updateNumReddot")) {
                        iVar.optString("msgId");
                        int i = iVar.getInt("latestTimeStamp");
                        ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().i((long) i, iVar.getInt("seq"), true);
                    } else if (string.equals("openProfile")) {
                        c.abC(iVar.getString("openId"));
                    } else if (string.equals("openWowColikeSetting")) {
                        c.eZ(ah.getContext());
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
                    ab.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(1522);
            return true;
        }
    };

    public PluginTopStoryUI() {
        AppMethodBeat.i(1524);
        AppMethodBeat.o(1524);
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
        int i = 1;
        AppMethodBeat.i(1525);
        this.sBf = new d();
        this.sBe = new b();
        com.tencent.mm.pluginsdk.cmd.b.a(this.sBe, "//topstory");
        this.sBh.dnU();
        if (System.currentTimeMillis() - g.RP().Ry().a(ac.a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, 0) <= 259200000) {
            ab.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", h.formatTime("yyyy-MM-dd HH:mm:ss", g.RP().Ry().a(ac.a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, 0) / 1000));
            an.Il(23);
        } else {
            i = 0;
        }
        if (i != 0) {
            tryToCreateTopStoryWebView();
        }
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1518);
                long HV = (long) aa.HV(1);
                if (((Long) g.RP().Ry().get(ac.a.USERINFO_TOP_STORY_LAST_REPORT_H5VERSION_TIME_LONG, Long.valueOf(0))).longValue() != HV) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(17040, Integer.valueOf(1), Long.valueOf(HV));
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_LAST_REPORT_H5VERSION_TIME_LONG, Long.valueOf(HV));
                    g.RP().Ry().dsb();
                }
                ((j) g.K(j.class)).XR().aoX("topstoryapp");
                ab.i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
                AppMethodBeat.o(1518);
            }
        }, "TopStory.DeleteTopStoryConversation");
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1519);
                d access$000 = PluginTopStoryUI.this.sBf;
                File file = new File(com.tencent.mm.plugin.topstory.a.g.cFn());
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", file.getAbsolutePath());
                    } else {
                        for (File file2 : listFiles) {
                            int i = bo.getInt(file2.getName(), -1);
                            if (i > 0) {
                                cho cho = new cho();
                                try {
                                    cho.parseFrom(com.tencent.mm.vfs.e.e(file2.getAbsolutePath(), 0, -1));
                                    access$000.sDg.put(Integer.valueOf(i), cho);
                                    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", Integer.valueOf(i), Integer.valueOf(r8.length));
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "loadHomeDataCache %s", file2.getAbsoluteFile());
                                }
                            } else {
                                ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", file2.getAbsolutePath());
                            }
                        }
                    }
                } else {
                    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", file.getAbsolutePath());
                }
                PluginTopStoryUI.this.sBf.cFM();
                AppMethodBeat.o(1519);
            }
        }, "TopStory.LoadHomeCacheData");
        AppMethodBeat.o(1525);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(1526);
        this.sBf = null;
        this.sBe = null;
        this.sBh.dead();
        com.tencent.mm.pluginsdk.cmd.b.N("//topstory");
        AppMethodBeat.o(1526);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public b getTopStoryCommand() {
        return this.sBe;
    }

    public d getWebViewMgr() {
        return this.sBf;
    }

    public int getFirstLoadWebView() {
        return this.sBd;
    }

    public void setFirstLoadWebView(int i) {
        this.sBd = i;
    }

    public void tryToCreateTopStoryWebView() {
        AppMethodBeat.i(1527);
        al.n(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(1520);
                if (PluginTopStoryUI.this.sBd == 2 && ((PluginTopStory) g.M(PluginTopStory.class)).getWebViewType() == WebView.d.WV_KIND_SYS) {
                    int i;
                    String str = Build.BRAND;
                    if (!bo.isNullOrNil(str)) {
                        str = str.toLowerCase();
                        if (str.contains("huawei") || str.contains("honor")) {
                            i = 0;
                            if (i != 0) {
                                if (((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("TopStoryWebViewPreInit", 1) == 0) {
                                    ab.i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("TopStoryWebViewPreInit", 1)));
                                    AppMethodBeat.o(1520);
                                    return;
                                }
                                PluginTopStoryUI.this.sBd = 1;
                                long currentTimeMillis = System.currentTimeMillis();
                                try {
                                    new TopStoryWebView(ah.getContext()).destroy();
                                } catch (Exception e) {
                                }
                                an.Il(26);
                                ab.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        }
                    }
                    i = 1;
                    if (i != 0) {
                    }
                }
                AppMethodBeat.o(1520);
            }
        }, 5000);
        AppMethodBeat.o(1527);
    }

    public void setHaokanEventListener(a aVar) {
        this.sBg = aVar;
    }
}
