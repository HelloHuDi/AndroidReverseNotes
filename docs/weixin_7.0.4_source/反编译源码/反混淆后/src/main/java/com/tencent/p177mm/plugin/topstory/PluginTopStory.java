package com.tencent.p177mm.plugin.topstory;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.WebView.C46828c;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.topstory.PluginTopStory */
public class PluginTopStory extends C7597f implements C1655b, C9562c, C13943b {
    private C4204c sAg;
    private C35295b sAh;
    private C41318a sAi;
    private C44570d sAj = C44570d.WV_KIND_SYS;

    /* renamed from: com.tencent.mm.plugin.topstory.PluginTopStory$1 */
    class C294251 implements C46828c {
        C294251() {
        }

        public final void onCoreInitFinished() {
            AppMethodBeat.m2504i(65443);
            C4990ab.m7416i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
            AppMethodBeat.m2505o(65443);
        }

        /* renamed from: BH */
        public final void mo4528BH() {
            AppMethodBeat.m2504i(65444);
            C4990ab.m7416i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
            AppMethodBeat.m2505o(65444);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.PluginTopStory$a */
    class C39959a implements Runnable {
        private C39959a() {
        }

        /* synthetic */ C39959a(PluginTopStory pluginTopStory, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(65445);
            C4990ab.m7417i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", Boolean.valueOf(C1173e.m2562cu(C6457e.eSn + "ftsrecommendVideo/")));
            C4990ab.m7417i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", Boolean.valueOf(C1173e.m2562cu(C6457e.eSn + "topstory/")));
            File file = new File(C39964g.cFl());
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File absolutePath : listFiles) {
                        boolean cu = C1173e.m2562cu(absolutePath.getAbsolutePath());
                        C4990ab.m7417i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", absolutePath.getAbsolutePath(), Boolean.valueOf(cu));
                    }
                }
                C5730e.m8643tf(C39964g.cFl() + ".nomedia/");
            } else {
                C5730e.m8643tf(C39964g.cFl());
                C5730e.m8643tf(C39964g.cFl() + ".nomedia/");
                C4990ab.m7416i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FTS_RECOMMEND_LOCAL_FILE_INDEX_LONG_SYNC, Long.valueOf(0));
            AppMethodBeat.m2505o(65445);
        }
    }

    public void execute(C1681g c1681g) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(65446);
        this.sAg = new C4204c();
        this.sAh = new C35295b();
        this.sAi = new C41318a();
        C7305d.post(new C39959a(this, (byte) 0), "TopStory.InitTopStoryCacheFolderTask");
        preInitXWebView();
        AppMethodBeat.m2505o(65446);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(65447);
        if (this.sAg != null) {
            C4204c c4204c = this.sAg;
            c4204c.sAv.removeCallbacksAndMessages(null);
            c4204c.sAv.getLooper().quit();
            this.sAg = null;
        }
        if (this.sAh != null) {
            C35295b c35295b = this.sAh;
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("mmsearch_reddot_new", c35295b.sAp);
            C4879a.xxA.mo10053d(c35295b.sAt);
            this.sAh = null;
        }
        if (this.sAi != null) {
            this.sAi.sAl.clear();
            this.sAi = null;
        }
        AppMethodBeat.m2505o(65447);
    }

    public void onVideoListUICreate() {
    }

    public void onVideoListUIDestroy(chv chv) {
    }

    public void onVideoListUIPause() {
    }

    public void onVideoListUIResume() {
    }

    public C4204c getReporter() {
        return this.sAg;
    }

    public C35295b getRedDotMgr() {
        return this.sAh;
    }

    public C41318a getPerformTracer() {
        return this.sAi;
    }

    public C44570d getWebViewType() {
        return this.sAj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void preInitXWebView() {
        boolean exists;
        AppMethodBeat.m2504i(65448);
        String str = Build.BRAND;
        String str2 = "";
        if (!C5046bo.isNullOrNil(str)) {
            str = str.toLowerCase();
            File file;
            if (str.contains("xiaomi")) {
                file = new File("/data/system/theme/fonts/", "Roboto-Regular.ttf");
                exists = file.exists();
                str2 = file.getAbsolutePath();
            } else if (str.contains("huawei") || str.contains("honor")) {
                if (C1443d.m3068iW(26)) {
                    exists = true;
                } else {
                    file = new File("/data/skin/fonts/", "DroidSansChinese.ttf");
                    exists = file.exists();
                    str2 = file.getAbsolutePath();
                }
            } else if (str.contains("samsung")) {
                file = new File("/data/app_fonts/0/", "sans.loc");
                exists = C39964g.m68427T(file);
                str2 = file.getAbsolutePath();
                if (!exists) {
                    file = new File("/data/user/0/com.android.settings/app_fonts/", "sans.loc");
                    exists = C39964g.m68427T(file);
                    str2 = file.getAbsolutePath();
                }
            } else if (str.contains("meizu")) {
                file = new File("/data/data/com.meizu.customizecenter/font/", "flymeFont.ttf");
                exists = file.exists();
                str2 = file.getAbsolutePath();
            }
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryApiLogic", "checkNeedXWeb %s %b %s", str, Boolean.valueOf(exists), str2);
            if (exists) {
                C7053e.pXa.mo8378a(649, 25, 1, false);
                this.sAj = C44570d.WV_KIND_CW;
            }
            C45287c.m83503a(this.sAj, new C294251());
            C4990ab.m7417i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", this.sAj.name());
            AppMethodBeat.m2505o(65448);
        }
        exists = false;
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryApiLogic", "checkNeedXWeb %s %b %s", str, Boolean.valueOf(exists), str2);
        if (exists) {
        }
        C45287c.m83503a(this.sAj, new C294251());
        C4990ab.m7417i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", this.sAj.name());
        AppMethodBeat.m2505o(65448);
    }
}
