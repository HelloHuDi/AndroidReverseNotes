package com.tencent.p177mm.plugin.topstory.p541ui;

import android.os.Build;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p230g.p231a.C42007im;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.topstory.PluginTopStory;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p541ui.C7612a.C7613a;
import com.tencent.p177mm.plugin.topstory.p541ui.home.C4227d;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.TopStoryWebView;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.cho;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.xweb.WebView.C44570d;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI */
public class PluginTopStoryUI extends C7597f implements C1655b, C9562c, C7612a {
    private int sBd = 2;
    private C4208b sBe;
    private C4227d sBf;
    private C7613a sBg;
    private C4884c<C42007im> sBh = new C399664();

    /* renamed from: com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI$1 */
    class C294331 implements Runnable {
        C294331() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1518);
            long HV = (long) C46400aa.m87305HV(1);
            if (((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_LAST_REPORT_H5VERSION_TIME_LONG, Long.valueOf(0))).longValue() != HV) {
                C7060h.pYm.mo8381e(17040, Integer.valueOf(1), Long.valueOf(HV));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_LAST_REPORT_H5VERSION_TIME_LONG, Long.valueOf(HV));
                C1720g.m3536RP().mo5239Ry().dsb();
            }
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("topstoryapp");
            C4990ab.m7416i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
            AppMethodBeat.m2505o(1518);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI$2 */
    class C399652 implements Runnable {
        C399652() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1519);
            C4227d access$000 = PluginTopStoryUI.this.sBf;
            File file = new File(C39964g.cFn());
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", file.getAbsolutePath());
                } else {
                    for (File file2 : listFiles) {
                        int i = C5046bo.getInt(file2.getName(), -1);
                        if (i > 0) {
                            cho cho = new cho();
                            try {
                                cho.parseFrom(C5730e.m8632e(file2.getAbsolutePath(), 0, -1));
                                access$000.sDg.put(Integer.valueOf(i), cho);
                                C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", Integer.valueOf(i), Integer.valueOf(r8.length));
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e, "loadHomeDataCache %s", file2.getAbsoluteFile());
                            }
                        } else {
                            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", file2.getAbsolutePath());
                        }
                    }
                }
            } else {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", file.getAbsolutePath());
            }
            PluginTopStoryUI.this.sBf.cFM();
            AppMethodBeat.m2505o(1519);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI$4 */
    class C399664 extends C4884c<C42007im> {
        C399664() {
            AppMethodBeat.m2504i(1521);
            this.xxI = C42007im.class.getName().hashCode();
            AppMethodBeat.m2505o(1521);
        }

        /* renamed from: a */
        private boolean m68438a(C42007im c42007im) {
            AppMethodBeat.m2504i(1522);
            if (c42007im.cDD == null) {
                AppMethodBeat.m2505o(1522);
                return false;
            }
            C4990ab.m7417i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", c42007im.cDD.cDE, c42007im.cDD.cDF);
            if (!(C5046bo.isNullOrNil(c42007im.cDD.cDE) || PluginTopStoryUI.this.sBg == null)) {
                PluginTopStoryUI.this.sBg.abA(c42007im.cDD.cDE);
            }
            if (!C5046bo.isNullOrNil(c42007im.cDD.cDF)) {
                try {
                    C41726i c41726i = new C41726i(c42007im.cDD.cDF);
                    String string = c41726i.getString(NativeProtocol.WEB_DIALOG_ACTION);
                    c41726i = c41726i.mo67478lB("params");
                    if (string.equals("updateNumReddot")) {
                        c41726i.optString("msgId");
                        int i = c41726i.getInt("latestTimeStamp");
                        ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().mo56037i((long) i, c41726i.getInt("seq"), true);
                    } else if (string.equals("openProfile")) {
                        C4210c.abC(c41726i.getString("openId"));
                    } else if (string.equals("openWowColikeSetting")) {
                        C4210c.m6562eZ(C4996ah.getContext());
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
                    C4990ab.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(1522);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI$3 */
    class C399673 implements Runnable {
        C399673() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(1520);
            if (PluginTopStoryUI.this.sBd == 2 && ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getWebViewType() == C44570d.WV_KIND_SYS) {
                int i;
                String str = Build.BRAND;
                if (!C5046bo.isNullOrNil(str)) {
                    str = str.toLowerCase();
                    if (str.contains("huawei") || str.contains("honor")) {
                        i = 0;
                        if (i != 0) {
                            if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("TopStoryWebViewPreInit", 1) == 0) {
                                C4990ab.m7417i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", Integer.valueOf(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("TopStoryWebViewPreInit", 1)));
                                AppMethodBeat.m2505o(1520);
                                return;
                            }
                            PluginTopStoryUI.this.sBd = 1;
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                new TopStoryWebView(C4996ah.getContext()).destroy();
                            } catch (Exception e) {
                            }
                            C14423an.m22640Il(26);
                            C4990ab.m7417i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        }
                    }
                }
                i = 1;
                if (i != 0) {
                }
            }
            AppMethodBeat.m2505o(1520);
        }
    }

    public PluginTopStoryUI() {
        AppMethodBeat.m2504i(1524);
        AppMethodBeat.m2505o(1524);
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(C1705c c1705c) {
        int i = 1;
        AppMethodBeat.m2504i(1525);
        this.sBf = new C4227d();
        this.sBe = new C4208b();
        C44042b.m79163a(this.sBe, "//topstory");
        this.sBh.dnU();
        if (System.currentTimeMillis() - C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, 0) <= 259200000) {
            C4990ab.m7417i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", C14835h.formatTime("yyyy-MM-dd HH:mm:ss", C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, 0) / 1000));
            C14423an.m22640Il(23);
        } else {
            i = 0;
        }
        if (i != 0) {
            tryToCreateTopStoryWebView();
        }
        C7305d.post(new C294331(), "TopStory.DeleteTopStoryConversation");
        C7305d.post(new C399652(), "TopStory.LoadHomeCacheData");
        AppMethodBeat.m2505o(1525);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(1526);
        this.sBf = null;
        this.sBe = null;
        this.sBh.dead();
        C44042b.m79162N("//topstory");
        AppMethodBeat.m2505o(1526);
    }

    public void execute(C1681g c1681g) {
    }

    public C4208b getTopStoryCommand() {
        return this.sBe;
    }

    public C4227d getWebViewMgr() {
        return this.sBf;
    }

    public int getFirstLoadWebView() {
        return this.sBd;
    }

    public void setFirstLoadWebView(int i) {
        this.sBd = i;
    }

    public void tryToCreateTopStoryWebView() {
        AppMethodBeat.m2504i(1527);
        C5004al.m7442n(new C399673(), 5000);
        AppMethodBeat.m2505o(1527);
    }

    public void setHaokanEventListener(C7613a c7613a) {
        this.sBg = c7613a;
    }
}
