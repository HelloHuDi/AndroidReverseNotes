package com.tencent.mm.plugin.topstory;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import java.io.File;

public class PluginTopStory extends f implements b, c, com.tencent.mm.plugin.topstory.a.b {
    private c sAg;
    private b sAh;
    private a sAi;
    private d sAj = d.WV_KIND_SYS;

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(PluginTopStory pluginTopStory, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(65445);
            ab.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", Boolean.valueOf(e.cu(com.tencent.mm.compatible.util.e.eSn + "ftsrecommendVideo/")));
            ab.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", Boolean.valueOf(e.cu(com.tencent.mm.compatible.util.e.eSn + "topstory/")));
            File file = new File(g.cFl());
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File absolutePath : listFiles) {
                        boolean cu = e.cu(absolutePath.getAbsolutePath());
                        ab.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", absolutePath.getAbsolutePath(), Boolean.valueOf(cu));
                    }
                }
                com.tencent.mm.vfs.e.tf(g.cFl() + ".nomedia/");
            } else {
                com.tencent.mm.vfs.e.tf(g.cFl());
                com.tencent.mm.vfs.e.tf(g.cFl() + ".nomedia/");
                ab.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
            }
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FTS_RECOMMEND_LOCAL_FILE_INDEX_LONG_SYNC, Long.valueOf(0));
            AppMethodBeat.o(65445);
        }
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(65446);
        this.sAg = new c();
        this.sAh = new b();
        this.sAi = new a();
        com.tencent.mm.sdk.g.d.post(new a(this, (byte) 0), "TopStory.InitTopStoryCacheFolderTask");
        preInitXWebView();
        AppMethodBeat.o(65446);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(65447);
        if (this.sAg != null) {
            c cVar = this.sAg;
            cVar.sAv.removeCallbacksAndMessages(null);
            cVar.sAv.getLooper().quit();
            this.sAg = null;
        }
        if (this.sAh != null) {
            b bVar = this.sAh;
            ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", bVar.sAp);
            com.tencent.mm.sdk.b.a.xxA.d(bVar.sAt);
            this.sAh = null;
        }
        if (this.sAi != null) {
            this.sAi.sAl.clear();
            this.sAi = null;
        }
        AppMethodBeat.o(65447);
    }

    public void onVideoListUICreate() {
    }

    public void onVideoListUIDestroy(chv chv) {
    }

    public void onVideoListUIPause() {
    }

    public void onVideoListUIResume() {
    }

    public c getReporter() {
        return this.sAg;
    }

    public b getRedDotMgr() {
        return this.sAh;
    }

    public a getPerformTracer() {
        return this.sAi;
    }

    public d getWebViewType() {
        return this.sAj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void preInitXWebView() {
        boolean exists;
        AppMethodBeat.i(65448);
        String str = Build.BRAND;
        String str2 = "";
        if (!bo.isNullOrNil(str)) {
            str = str.toLowerCase();
            File file;
            if (str.contains("xiaomi")) {
                file = new File("/data/system/theme/fonts/", "Roboto-Regular.ttf");
                exists = file.exists();
                str2 = file.getAbsolutePath();
            } else if (str.contains("huawei") || str.contains("honor")) {
                if (com.tencent.mm.compatible.util.d.iW(26)) {
                    exists = true;
                } else {
                    file = new File("/data/skin/fonts/", "DroidSansChinese.ttf");
                    exists = file.exists();
                    str2 = file.getAbsolutePath();
                }
            } else if (str.contains("samsung")) {
                file = new File("/data/app_fonts/0/", "sans.loc");
                exists = g.T(file);
                str2 = file.getAbsolutePath();
                if (!exists) {
                    file = new File("/data/user/0/com.android.settings/app_fonts/", "sans.loc");
                    exists = g.T(file);
                    str2 = file.getAbsolutePath();
                }
            } else if (str.contains("meizu")) {
                file = new File("/data/data/com.meizu.customizecenter/font/", "flymeFont.ttf");
                exists = file.exists();
                str2 = file.getAbsolutePath();
            }
            ab.i("MicroMsg.TopStory.TopStoryApiLogic", "checkNeedXWeb %s %b %s", str, Boolean.valueOf(exists), str2);
            if (exists) {
                com.tencent.mm.plugin.report.e.pXa.a(649, 25, 1, false);
                this.sAj = d.WV_KIND_CW;
            }
            com.tencent.mm.cj.c.a(this.sAj, new WebView.c() {
                public final void onCoreInitFinished() {
                    AppMethodBeat.i(65443);
                    ab.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
                    AppMethodBeat.o(65443);
                }

                public final void BH() {
                    AppMethodBeat.i(65444);
                    ab.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
                    AppMethodBeat.o(65444);
                }
            });
            ab.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", this.sAj.name());
            AppMethodBeat.o(65448);
        }
        exists = false;
        ab.i("MicroMsg.TopStory.TopStoryApiLogic", "checkNeedXWeb %s %b %s", str, Boolean.valueOf(exists), str2);
        if (exists) {
        }
        com.tencent.mm.cj.c.a(this.sAj, /* anonymous class already generated */);
        ab.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", this.sAj.name());
        AppMethodBeat.o(65448);
    }
}
