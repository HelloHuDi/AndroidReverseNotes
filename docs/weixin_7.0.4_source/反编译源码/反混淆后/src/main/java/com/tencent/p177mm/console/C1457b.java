package com.tencent.p177mm.console;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.WorkerProfile;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.console.p845a.C18179g;
import com.tencent.p177mm.console.p845a.C26055a;
import com.tencent.p177mm.console.p845a.C26058b;
import com.tencent.p177mm.console.p845a.C26059h;
import com.tencent.p177mm.console.p845a.C32477k;
import com.tencent.p177mm.console.p845a.C32478l;
import com.tencent.p177mm.console.p845a.C32479m;
import com.tencent.p177mm.console.p845a.C37661c;
import com.tencent.p177mm.console.p845a.C37662e;
import com.tencent.p177mm.console.p845a.C37663n;
import com.tencent.p177mm.console.p845a.C45298d;
import com.tencent.p177mm.console.p845a.C45299f;
import com.tencent.p177mm.console.p845a.C9252i;
import com.tencent.p177mm.console.p845a.C9253j;
import com.tencent.p177mm.console.p845a.p1459a.C32476a;
import com.tencent.p177mm.console.p845a.p1459a.C37660b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C32776be;
import com.tencent.p177mm.model.C37903bd;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.model.p262c.C37915a;
import com.tencent.p177mm.model.p262c.C37915a.C9654a;
import com.tencent.p177mm.modelmulti.C1861q;
import com.tencent.p177mm.modelsimple.C18674i;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.modelstat.C18686e;
import com.tencent.p177mm.modelstat.WatchDogPushReceiver;
import com.tencent.p177mm.modelvoiceaddr.p1208a.C18721c;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.p265a.C18727c;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p210ca.C41917d;
import com.tencent.p177mm.p215cf.C37632b;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C32624qz;
import com.tencent.p177mm.p230g.p231a.C37693be;
import com.tencent.p177mm.p230g.p231a.C37694bo;
import com.tencent.p177mm.p230g.p231a.C37699ci;
import com.tencent.p177mm.p230g.p231a.C37792rc;
import com.tencent.p177mm.p230g.p231a.C37794rn;
import com.tencent.p177mm.p230g.p231a.C41997hb;
import com.tencent.p177mm.p230g.p231a.C42056rt;
import com.tencent.p177mm.p230g.p231a.C42080vq;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p230g.p231a.C6470cp;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p230g.p231a.C9303bm;
import com.tencent.p177mm.p230g.p231a.C9308cn;
import com.tencent.p177mm.p230g.p231a.C9309co;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.p230g.p231a.C9419mz;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.applet.C15497c;
import com.tencent.p177mm.p612ui.applet.C44258d;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C30562p;
import com.tencent.p177mm.p612ui.chatting.ChattingUIFragment;
import com.tencent.p177mm.p612ui.chatting.p616c.C44804ak;
import com.tencent.p177mm.p612ui.conversation.p626a.C17062n;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.platformtools.SpellMap;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C42444a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45628v;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24697ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42524ad;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42526r;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.clean.p362c.C6826j;
import com.tencent.p177mm.plugin.collect.model.voice.C45818a;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.roomexpt.C38991d;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.plugin.game.luggage.C12146d;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.hardwareopt.p981a.p1404a.C28284a;
import com.tencent.p177mm.plugin.kitchen.p733a.C6956a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyNewYearSendUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.plugin.p468n.C12691e;
import com.tencent.p177mm.plugin.report.p499b.C3733f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sns.p520ui.C22067aq;
import com.tencent.p177mm.plugin.voip.C14034e;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.plugin.websearch.api.C43852n;
import com.tencent.p177mm.plugin.websearch.api.C4510aj;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.C44068p.C14896a;
import com.tencent.p177mm.pluginsdk.C44068p.C14898d;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C44057a;
import com.tencent.p177mm.pluginsdk.model.app.C46493an;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44796m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23283u;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.bdi;
import com.tencent.p177mm.protocal.protobuf.bdj;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C30284ar;
import com.tencent.p177mm.sdk.platformtools.C30284ar.C30290a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5034bd.C5033a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C5065t;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5144y;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7578w;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.svg.p611b.C5157b;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5732g;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.console.b */
public final class C1457b {
    private static final HashSet<String> ewd;

    /* renamed from: com.tencent.mm.console.b$13 */
    static class C146413 implements C1835a {
        C146413() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(16094);
            if (c1902e == null) {
                AppMethodBeat.m2505o(16094);
                return;
            }
            int i;
            String[] iPsString = c1902e.getIPsString(true);
            for (i = 0; i < iPsString.length; i++) {
                C4990ab.m7411d("MicroMsg.CommandProcessor", "dkip long:%d  %s", Integer.valueOf(i), iPsString[i]);
                C4990ab.m7411d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), C18727c.m29288vd(iPsString[i]).toString());
            }
            iPsString = c1902e.getIPsString(false);
            for (i = 0; i < iPsString.length; i++) {
                C4990ab.m7411d("MicroMsg.CommandProcessor", "dkip short:%d %s", Integer.valueOf(i), iPsString[i]);
                C4990ab.m7411d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), C18727c.m29288vd(iPsString[i]).toString());
            }
            AppMethodBeat.m2505o(16094);
        }
    }

    /* renamed from: com.tencent.mm.console.b$2 */
    static class C14652 implements Runnable {
        C14652() {
        }

        public final void run() {
            AppMethodBeat.m2504i(16073);
            C4879a.xxA.mo10055m(new C37794rn());
            AppMethodBeat.m2505o(16073);
        }
    }

    /* renamed from: com.tencent.mm.console.b$7 */
    static class C14707 implements C1835a {
        C14707() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(16087);
            if (c1902e == null) {
                AppMethodBeat.m2505o(16087);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C9638aw.m17190ZK();
            adg.mo5482a(bArr, bArr2, bArr3, C18628c.m29064QF());
            AppMethodBeat.m2505o(16087);
        }
    }

    /* renamed from: com.tencent.mm.console.b$10 */
    static class C147110 implements Runnable {

        /* renamed from: com.tencent.mm.console.b$10$1 */
        class C14721 implements C5015a {
            C14721() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7  */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0156 A:{SYNTHETIC, Splitter:B:41:0x0156} */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A:{SYNTHETIC, Splitter:B:20:0x008d} */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: BI */
            public final boolean mo4499BI() {
                Exception e;
                Throwable th;
                AppMethodBeat.m2504i(16090);
                if (C1443d.m3068iW(23)) {
                    C4990ab.m7417i("MicroMsg.CommandProcessor", "gcCount: %s", Debug.getRuntimeStats());
                } else {
                    int globalGcInvocationCount = Debug.getGlobalGcInvocationCount();
                    int threadGcInvocationCount = Debug.getThreadGcInvocationCount();
                    C4990ab.m7417i("MicroMsg.CommandProcessor", "gcCount: %d %d", Integer.valueOf(globalGcInvocationCount), Integer.valueOf(threadGcInvocationCount));
                }
                long pss = Debug.getPss();
                Debug.getMemoryInfo(new MemoryInfo());
                if (C1443d.m3068iW(23)) {
                    C4990ab.m7417i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%s", Long.valueOf(pss), r2.getMemoryStats());
                } else {
                    C4990ab.m7417i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%d", Long.valueOf(pss), Integer.valueOf(r2.nativePss));
                }
                LineNumberReader lineNumberReader;
                try {
                    Process exec = Runtime.getRuntime().exec("top -m 5 -n 1");
                    lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        try {
                            String readLine = lineNumberReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.length() > 0) {
                                C4990ab.m7416i("MicroMsg.CommandProcessor", readLine);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e.getMessage());
                                if (lineNumberReader != null) {
                                }
                                C4990ab.m7417i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                                for (Thread thread : Thread.getAllStackTraces().keySet()) {
                                }
                                AppMethodBeat.m2505o(16090);
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                if (lineNumberReader != null) {
                                    try {
                                        lineNumberReader.close();
                                    } catch (Exception e3) {
                                        C4990ab.m7413e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
                                    }
                                }
                                AppMethodBeat.m2505o(16090);
                                throw th;
                            }
                        }
                    }
                    exec.waitFor();
                    exec.destroy();
                    try {
                        lineNumberReader.close();
                    } catch (Exception e4) {
                        C4990ab.m7413e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e4.getMessage());
                    }
                } catch (Exception e5) {
                    e4 = e5;
                    lineNumberReader = null;
                    C4990ab.m7413e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e4.getMessage());
                    if (lineNumberReader != null) {
                        try {
                            lineNumberReader.close();
                        } catch (Exception e42) {
                            C4990ab.m7413e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e42.getMessage());
                        }
                    }
                    C4990ab.m7417i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                    for (Thread thread2 : Thread.getAllStackTraces().keySet()) {
                    }
                    AppMethodBeat.m2505o(16090);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    lineNumberReader = null;
                    if (lineNumberReader != null) {
                    }
                    AppMethodBeat.m2505o(16090);
                    throw th;
                }
                C4990ab.m7417i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                for (Thread thread22 : Thread.getAllStackTraces().keySet()) {
                    if (thread22.getState() == State.RUNNABLE) {
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", thread22.getName(), C5007an.stackTraceToString((StackTraceElement[]) r1.get(thread22)));
                    }
                }
                AppMethodBeat.m2505o(16090);
                return true;
            }
        }

        C147110() {
        }

        public final void run() {
            AppMethodBeat.m2504i(16091);
            new C7564ap(new C14721(), true).mo16770ae(10000, 10000);
            AppMethodBeat.m2505o(16091);
        }
    }

    /* renamed from: D */
    static /* synthetic */ boolean m3087D(Context context, String str) {
        AppMethodBeat.m2504i(16105);
        boolean C = C1457b.m3086C(context, str);
        AppMethodBeat.m2505o(16105);
        return C;
    }

    static {
        boolean z = true;
        AppMethodBeat.m2504i(16106);
        C45298d.init();
        C9252i.init();
        C9253j.init();
        C18179g.init();
        C37662e.init();
        C45299f.init();
        C26058b.init();
        C37661c.init();
        C32479m.init();
        C26059h.init();
        C32477k.init();
        C37663n.init();
        C32478l.init();
        try {
            Class.forName("com.tencent.mm.console.a.b.a");
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", th, "", new Object[0]);
        }
        C44042b.m79163a(new C32476a(), "//fsd");
        C44042b.m79163a(new C37660b(), "//hcsetting");
        C44042b.m79163a(new C26055a(), "//clearrecent");
        HashSet hashSet = new HashSet();
        ewd = hashSet;
        hashSet.add("//uplog");
        ewd.add("//pullxlog");
        ewd.add("//upcrash");
        ewd.add("//getfpkey");
        ewd.add("//voipdebug");
        ewd.add("//setkey");
        ewd.add("//wxcamera");
        ewd.add("//deletetbs");
        ewd.add("//setNfcOpenUrl");
        if (ewd.size() != 9) {
            z = false;
        }
        Assert.assertTrue(z);
        AppMethodBeat.m2505o(16106);
    }

    /* renamed from: kK */
    private static int m3092kK(String str) {
        AppMethodBeat.m2504i(16097);
        if (!str.startsWith("//") || str.length() <= 2) {
            AppMethodBeat.m2505o(16097);
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            indexOf = C5046bo.getInt(str.substring(2, indexOf), 0);
            int i = C7243d.vxo % 256;
            if (i == 0 || indexOf < i || indexOf % i != 0) {
                AppMethodBeat.m2505o(16097);
                return 0;
            }
            int i2 = indexOf / i;
            AppMethodBeat.m2505o(16097);
            return i2;
        } catch (Exception e) {
            AppMethodBeat.m2505o(16097);
            return 0;
        }
    }

    /* renamed from: kL */
    private static String m3093kL(String str) {
        AppMethodBeat.m2504i(16098);
        int indexOf = str.indexOf(" ");
        String str2;
        if (indexOf < 0) {
            str2 = "";
            AppMethodBeat.m2505o(16098);
            return str2;
        }
        str2 = str.substring(indexOf).trim();
        AppMethodBeat.m2505o(16098);
        return str2;
    }

    /* renamed from: kM */
    private static boolean m3094kM(String str) {
        AppMethodBeat.m2504i(16099);
        Iterator it = ewd.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next())) {
                AppMethodBeat.m2505o(16099);
                return true;
            }
        }
        AppMethodBeat.m2505o(16099);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:362:0x101b  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0fe1  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0fe1  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x101b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public static boolean m3088i(final Context context, final String str, String str2) {
        AppMethodBeat.m2504i(16100);
        String[] split;
        StringBuilder stringBuilder;
        View textView;
        int dimensionPixelSize;
        SharedPreferences sharedPreferences;
        Editor edit;
        if (!str.startsWith("//")) {
            AppMethodBeat.m2505o(16100);
            return false;
        } else if (1 < C4990ab.getLogLevel() && !C1457b.m3094kM(str)) {
            C4990ab.m7417i("MicroMsg.CommandProcessor", "summer processed log level[%s], need open debug ret false", Integer.valueOf(C4990ab.getLogLevel()));
            AppMethodBeat.m2505o(16100);
            return false;
        } else if (C44042b.m79161B(context, str, str2)) {
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.startsWith("//clearWXSNSDB")) {
            C4879a.xxA.mo10055m(new C32624qz());
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.startsWith("//verifytokenerror")) {
            C1947ae.gjr = true;
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.startsWith("//testLqt")) {
            split = str.split(" ");
            if (split.length == 2) {
                if (C5046bo.getInt(split[1], 0) == 1) {
                    C1947ae.gjw = true;
                } else {
                    C1947ae.gjw = false;
                }
            }
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.startsWith("//resetbackupdata")) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.FALSE);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.FALSE);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.FALSE);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.FALSE);
            C9638aw.m17190ZK().mo33889Yq().drx();
            C9638aw.m17190ZK().mo33890Yr().drx();
            C9638aw.m17190ZK().mo33888Yp().drx();
            Toast.makeText(C4996ah.getContext(), "backup data has been reset!", 1).show();
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.startsWith("//threadpool replace")) {
            if (str.startsWith("//threadpool replace false")) {
                C4996ah.doB().edit().putBoolean("REPLACE_WORKER_BOOLEAN", false).commit();
            } else if (str.startsWith("//threadpool replace true")) {
                C4996ah.doB().edit().putBoolean("REPLACE_WORKER_BOOLEAN", true).commit();
            }
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.equalsIgnoreCase("//ftsmsbiz")) {
            bdj cVo = C35573ai.cVo();
            stringBuilder = new StringBuilder();
            Iterator it = cVo.jBw.iterator();
            while (it.hasNext()) {
                bdi bdi = (bdi) it.next();
                stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{C1854s.m3866mJ(bdi.vHl), Double.valueOf(bdi.wHm), C14835h.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, bdi.wHn / 1000)}));
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            textView = new TextView(context);
            textView.setText(stringBuilder.toString());
            textView.setGravity(19);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16711936);
            textView.setTypeface(Typeface.MONOSPACE);
            dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            C30379h.m48435a(context, null, textView, null);
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.startsWith("//cleanww")) {
            ((C32873b) C1720g.m3528K(C32873b.class)).anw();
            AppMethodBeat.m2505o(16100);
            return true;
        } else if (str.startsWith("//setgamejs")) {
            split = str.split(" ");
            if (split.length == 2) {
                if (split[1] == null || split[1].isEmpty() || split[1].endsWith("/")) {
                    C23639t.makeText(context, "param set error, please don't end with /", 0).show();
                } else {
                    sharedPreferences = C4996ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
                    if (sharedPreferences != null) {
                        edit = sharedPreferences.edit();
                        edit.remove("app_brand_game_js_path");
                        edit.commit();
                        if (!split[1].equalsIgnoreCase(BuildConfig.COMMAND)) {
                            edit.putString("app_brand_game_js_path", split[1]);
                            edit.commit();
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(16100);
            return true;
        } else {
            if (C4872b.dnO()) {
                if (str.startsWith("//launchapp clear")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, (Object) "");
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//setsupportwxcode")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.TRUE);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//setnotsupportwxcode")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.FALSE);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//resetsupportwxcode")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, null);
                    AppMethodBeat.m2505o(16100);
                    return true;
                }
            }
            Intent intent;
            if (str.startsWith("//testsightwidget")) {
                intent = new Intent();
                intent.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
                intent.putExtra("KSightThumbPath", "");
                intent.putExtra("sight_md5", C5730e.atg("/mnt/sdcard/tencent/tempvideo4.mp4"));
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", C5046bo.anT());
                intent.putExtra("Ksnsupload_type", 14);
                C25985d.m41467b(context, "sns", ".ui.SnsUploadUI", intent);
                AppMethodBeat.m2505o(16100);
                return true;
            } else if (str.startsWith("//openremitbank")) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(1));
                AppMethodBeat.m2505o(16100);
                return true;
            } else if (str.startsWith("//chatroomdebug ")) {
                if (str.substring(str.indexOf(" ") + 1).equalsIgnoreCase("true")) {
                    ((C6822c) C1720g.m3528K(C6822c.class)).mo15092fN(true);
                } else {
                    ((C6822c) C1720g.m3528K(C6822c.class)).mo15092fN(false);
                }
                AppMethodBeat.m2505o(16100);
                return true;
            } else if (str.startsWith("//angerbag")) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, ((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                AppMethodBeat.m2505o(16100);
                return true;
            } else if (str.startsWith("//clearbag")) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, (Object) "");
                AppMethodBeat.m2505o(16100);
                return true;
            } else if (str.startsWith("//closeremitbank")) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(0));
                AppMethodBeat.m2505o(16100);
                return true;
            } else {
                if (str.startsWith("//ftstemplatetest")) {
                    C32519bf c32519bf = new C32519bf();
                    c32519bf.cus.cut = 27;
                    c32519bf.cus.cut = 1;
                    c32519bf.cus.filePath = "/sdcard/fts_template.zip";
                    C4879a.xxA.mo10055m(c32519bf);
                }
                String str3;
                String[] split2;
                Intent intent2;
                String[] split3;
                int intValue;
                final String gA;
                if (str.startsWith("//sightforward")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.ui.transmit.SightForwardUI");
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//remit")) {
                    C25985d.m41467b(context, "remittance", ".ui.RemittanceBusiUI", new Intent());
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//fixtools")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
                    intent.putExtra("entry_fix_tools", 2);
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//uplog")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI");
                    intent.putExtra("entry_fix_tools_uplog", 5);
                    MMWizardActivity.m23791J(context, intent);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//pullxlog")) {
                    C4990ab.moveLogsFromCacheDirToLogDir();
                    Toast.makeText(context, "move success", 0).show();
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//upcrash")) {
                    str3 = "weixin";
                    if (C9638aw.m17179RK()) {
                        str3 = C1853r.m3846Yz();
                    }
                    split2 = str.split(" ");
                    dimensionPixelSize = 0;
                    if (split2 != null) {
                        if (split2.length > 1) {
                            dimensionPixelSize = C5046bo.getInt(split2[1], 0);
                        }
                        if (split2.length > 2) {
                            str3 = split2[2];
                        }
                    }
                    C9638aw.m17182Rg().mo14552d(new C6668bk(new C1835a() {
                        /* renamed from: a */
                        public final void mo4918a(C1902e c1902e) {
                            AppMethodBeat.m2504i(16072);
                            C9638aw.m17182Rg().mo14540a(3, str3, dimensionPixelSize, C9638aw.m17179RK());
                            AppMethodBeat.m2505o(16072);
                        }
                    }));
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//fixError0831")) {
                    C4990ab.m7416i("MicroMsg.CommandProcessor", "fixError0831");
                    C4879a.xxA.mo10055m(new C9303bm());
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//resetbankremit")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0));
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//busiluck ")) {
                    str3 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=".concat(String.valueOf(str.replace("//busiluck ", "")));
                    intent2 = new Intent();
                    intent2.putExtra("key_way", 5);
                    intent2.putExtra("key_native_url", str3);
                    C25985d.m41467b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//testsoter")) {
                    intent = new Intent();
                    intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//facevideo")) {
                    split = str.split(" ");
                    if (split.length == 3) {
                        C6665av.fly.mo14897ak("imgType", split[1]);
                        C6665av.fly.mo14897ak("depth", split[2]);
                    }
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//alpha")) {
                    split = str.split(" ");
                    if (split.length == 2) {
                        C6665av.fly.mo14897ak("alpha_duration", split[1]);
                    }
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//forceNotifyError")) {
                    split3 = str.split(" ");
                    if (split3.length == 2) {
                        ((C20772b) C1720g.m3528K(C20772b.class)).mo36074hx(split3[1].equalsIgnoreCase("true"));
                    }
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//rectwidth")) {
                    split = str.split(" ");
                    if (split.length == 2) {
                        C6665av.fly.mo14897ak("rect_width", split[1]);
                    }
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//newyearsw ")) {
                    C9638aw.m17190ZK();
                    intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(intValue));
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//commitxlog")) {
                    C9638aw.m17182Rg().mo14540a(1, "", 0, false);
                    C4990ab.dot();
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//open neattextview")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//close neattextview")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//unprint specialtext")) {
                    MMNeat7extView.zMr = false;
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//print specialtext")) {
                    MMNeat7extView.zMr = true;
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else if (str.startsWith("//netstatus")) {
                    gA = C5023at.m7470gA(C4996ah.getContext());
                    C30379h.m48466d(context, gA, "netstatus", context.getString(C25738R.string.f5p), context.getString(C25738R.string.atb), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(16088);
                            ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                            AppMethodBeat.m2505o(16088);
                        }
                    }, null);
                    AppMethodBeat.m2505o(16100);
                    return true;
                } else {
                    long j;
                    if (str.startsWith("//scaninterval ")) {
                        j = -1;
                        try {
                            j = C5046bo.getLong(str.split(" ")[1], -1);
                        } catch (Exception e) {
                        }
                        if (j > 0) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG, Long.valueOf(j));
                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", Long.valueOf(j));
                            AppMethodBeat.m2505o(16100);
                            return true;
                        }
                    }
                    if (str.startsWith("//scanwait ")) {
                        j = -1;
                        try {
                            j = C5046bo.getLong(str.split(" ")[1], -1);
                        } catch (Exception e2) {
                        }
                        if (j > 0) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG, Long.valueOf(j));
                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", Long.valueOf(j));
                            AppMethodBeat.m2505o(16100);
                            return true;
                        }
                    }
                    SharedPreferences doB;
                    boolean z;
                    boolean booleanValue;
                    View textView2;
                    C7616ad aoO;
                    if (str.equalsIgnoreCase("//delayquery")) {
                        C1947ae.gju = !C1947ae.gju;
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//newinit -hard")) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(15, Integer.valueOf(0));
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//websearch-widget-draw ")) {
                        split3 = str.split("\\s+");
                        if (split3.length == 2) {
                            ((C43852n) C1720g.m3528K(C43852n.class)).mo47993HM(C5046bo.ank(split3[1].trim()));
                        }
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//opensearchpreload ")) {
                        split = str.split("\\s+");
                        if (split.length == 2) {
                            if ("1".equals(split[1].trim())) {
                                C4510aj.cVp().mo9582nE(true);
                            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(split[1].trim())) {
                                C4510aj.cVp().mo9582nE(false);
                            }
                        }
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//closesearchhtmlpreload ")) {
                        split = str.split("\\s+");
                        if (split.length == 2) {
                            if ("1".equals(split[1].trim())) {
                                C46400aa.cVb();
                            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(split[1].trim())) {
                                C46400aa.cVb();
                            }
                        }
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.equalsIgnoreCase("//swipe")) {
                        doB = C4996ah.doB();
                        doB.edit().putBoolean("settings_support_swipe", !doB.getBoolean("settings_support_swipe", true)).commit();
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.equalsIgnoreCase("//multiwebview")) {
                        doB = LauncherUI.getInstance().getSharedPreferences(C4996ah.doA(), 0);
                        z = doB.getBoolean("settings_multi_webview", false);
                        if (z) {
                            doB.edit().putBoolean("settings_multi_webview", !z).commit();
                        }
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.equalsIgnoreCase("//sightinfo")) {
                        C9638aw.m17190ZK();
                        booleanValue = ((Boolean) C18628c.m29072Ry().get(344065, Boolean.FALSE)).booleanValue();
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(344065, Boolean.valueOf(!booleanValue));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().dsb();
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//sighttest")) {
                        intValue = C5046bo.ank(str.replace("//sighttest ", ""));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(344066, Integer.valueOf(intValue));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().dsb();
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//wxcamera")) {
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "set param %d", Integer.valueOf(C5046bo.ank(str.replace("//wxcamera ", ""))));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, Integer.valueOf(intValue));
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//printcrash")) {
                        str3 = str.replace("//printcrash ", "");
                        textView2 = new TextView(context);
                        textView2.setText(C1457b.m3089jb(C5046bo.getInt(str3, 0)));
                        textView2.setGravity(19);
                        textView2.setTextSize(1, 8.0f);
                        textView2.setLayoutParams(new LayoutParams(-1, -2));
                        textView2.setTextColor(-16711936);
                        textView2.setTypeface(Typeface.MONOSPACE);
                        intValue = context.getResources().getDimensionPixelSize(C25738R.dimen.f10017nj);
                        textView2.setPadding(intValue, intValue, intValue, intValue);
                        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
                        C30379h.m48435a(context, null, textView2, null);
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//printleak")) {
                        textView = new TextView(context);
                        textView.setText(C1407g.m2954Le());
                        textView.setGravity(19);
                        textView.setTextSize(1, 8.0f);
                        textView.setLayoutParams(new LayoutParams(-1, -2));
                        textView.setTextColor(-16711936);
                        textView.setTypeface(Typeface.MONOSPACE);
                        dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f10017nj);
                        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                        C30379h.m48435a(context, null, textView, null);
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//resetmapcnt")) {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0));
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.equals("//testrsa")) {
                        C4851z.m7216O("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.equals("//testrsabad")) {
                        C4851z.m7216O("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.equals("//walletofflinetest")) {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
                        AppMethodBeat.m2505o(16100);
                        return false;
                    } else if (str.startsWith("//makemsgdata ")) {
                        intValue = C5046bo.getInt(str.split(" ")[1], 0);
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15240P(ChattingUIFragment.xIj, (long) intValue);
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//pullappservice")) {
                        C46493an.dhQ().mo74711fM(C4996ah.getContext());
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//boundaryconfig")) {
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSessionTextMsg"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSNSObjectText"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("SnsCommentMaxSize"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitFavText"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSendEmotionBufSize"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSendEmotionWidth"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitFavImageSize"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitFavVoiceLength"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSessionShortVideoBufSize"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitVideoSize"), 0)));
                        C4990ab.m7417i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitFileSize"), 0)));
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//cleanapk")) {
                        C6826j.bge();
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//whatsnew")) {
                        MMAppMgr.m7901aq((Activity) context);
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//profile ")) {
                        C9638aw.m17190ZK();
                        aoO = C18628c.m29078XM().aoO(str.replace("//profile ", "").trim());
                        if (!(aoO == null || aoO.mo16705Oh() == 0)) {
                            intent2 = new Intent();
                            intent2.putExtra("Contact_User", aoO.getUsername());
                            C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else if (str.startsWith("//minigameupdate")) {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_MINIGAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0));
                        AppMethodBeat.m2505o(16100);
                        return true;
                    } else {
                        if (C4872b.dnO()) {
                            if (str.startsWith("//cs")) {
                                intent = new Intent();
                                intent.putExtra("voipCSBizId", "gh_b35727b00b78");
                                intent.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
                                C25985d.m41467b(C4996ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                AppMethodBeat.m2505o(16100);
                                return true;
                            } else if (str.startsWith("//acs")) {
                                intent = new Intent();
                                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                                C25985d.m41467b(C4996ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                AppMethodBeat.m2505o(16100);
                                return true;
                            } else if (str.startsWith("//wifiset")) {
                                intent = new Intent();
                                intent.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
                                intent.putExtra("free_wifi_passowrd", "WX12345789");
                                C25985d.m41467b(C4996ah.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", intent);
                                AppMethodBeat.m2505o(16100);
                                return true;
                            } else if (str.startsWith("//bcs")) {
                                intent = new Intent();
                                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                                intent.putExtra("voipCSAllowBackCamera", "1");
                                intent.putExtra("voipCSShowOther", "1");
                                intent.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
                                intent.putExtra("voipCSContext", "test");
                                C25985d.m41467b(C4996ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                AppMethodBeat.m2505o(16100);
                                return true;
                            }
                        }
                        String str4;
                        String str5;
                        boolean z2;
                        int tbsSDKVersion;
                        Editor edit2;
                        if (str.startsWith("//getfpkey")) {
                            gA = C7574bs.dut();
                            C30379h.m48466d(context, gA, "Fingerprint Key", context.getString(C25738R.string.f5p), context.getString(C25738R.string.atb), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(16089);
                                    ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                    Toast.makeText(context, C25738R.string.f5q, 0).show();
                                    AppMethodBeat.m2505o(16089);
                                }
                            }, null);
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//commitwd")) {
                            WatchDogPushReceiver.akt();
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//setsnstestenv")) {
                            String str6;
                            split3 = str.split(" +");
                            str4 = null;
                            if (split3.length > 1) {
                                str6 = split3[1];
                                if (C5065t.isIPv4Address(str6) || C5065t.isIPv6Address(str6)) {
                                    if (split3.length > 2) {
                                        str5 = split3[2];
                                        if (C5065t.isIPv4Address(str5) || C5065t.isIPv6Address(str5)) {
                                            if (split3.length > 3) {
                                                gA = split3[3];
                                                str4 = str5;
                                            } else {
                                                gA = null;
                                                str4 = str5;
                                            }
                                            C1947ae.giS = str6 != null;
                                            C1947ae.giJ = str6;
                                            C1947ae.gjl = str4;
                                            C1947ae.gjm = gA;
                                            C37461f.afu().mo60373li(5);
                                            Toast.makeText(context, String.format("%s %s %s", new Object[]{C1947ae.giJ, C1947ae.gjl, C1947ae.gjm}), 1).show();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        }
                                    }
                                    gA = null;
                                    if (str6 != null) {
                                    }
                                    C1947ae.giS = str6 != null;
                                    C1947ae.giJ = str6;
                                    C1947ae.gjl = str4;
                                    C1947ae.gjm = gA;
                                    C37461f.afu().mo60373li(5);
                                    Toast.makeText(context, String.format("%s %s %s", new Object[]{C1947ae.giJ, C1947ae.gjl, C1947ae.gjm}), 1).show();
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                }
                            }
                            gA = null;
                            str6 = null;
                            if (str6 != null) {
                            }
                            C1947ae.giS = str6 != null;
                            C1947ae.giJ = str6;
                            C1947ae.gjl = str4;
                            C1947ae.gjm = gA;
                            C37461f.afu().mo60373li(5);
                            Toast.makeText(context, String.format("%s %s %s", new Object[]{C1947ae.giJ, C1947ae.gjl, C1947ae.gjm}), 1).show();
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//snsvcodec")) {
                            split = str.split(" +");
                            if (split.length > 1) {
                                str3 = split[1];
                                if ("on".equalsIgnoreCase(str3)) {
                                    C1457b.m3090jc(1);
                                    C4990ab.m7416i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
                                } else if ("off".equalsIgnoreCase(str3)) {
                                    C1457b.m3090jc(0);
                                    C4990ab.m7416i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
                                }
                            } else {
                                C1457b.m3090jc(-1);
                                C4990ab.m7416i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
                            }
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//snswxpc")) {
                            split = str.split(" +");
                            if (split.length > 1) {
                                str3 = split[1];
                                if ("on".equalsIgnoreCase(str3)) {
                                    C1457b.m3091jd(1);
                                    C4990ab.m7416i("MicroMsg.CommandProcessor", "snswxpc val: 1");
                                } else if ("off".equalsIgnoreCase(str3)) {
                                    C1457b.m3091jd(0);
                                    C4990ab.m7416i("MicroMsg.CommandProcessor", "snswxpc val: 0");
                                }
                            } else {
                                C1457b.m3091jd(-1);
                                C4990ab.m7416i("MicroMsg.CommandProcessor", "snswxpc val: -1");
                            }
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//mmdumpsys")) {
                            C7305d.xDG.execute(new C147110());
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//remittance reset")) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(327729, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//wv ")) {
                            str3 = str.replace("//wv ", "");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", str3);
                            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//wvjsapi ")) {
                            str3 = str.replace("//wvjsapi ", "");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", str3);
                            C25985d.m41467b(context, "webview", ".ui.tools.WebViewTestUI", intent2);
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//setibeacontabuinopen")) {
                            if (C9638aw.m17179RK()) {
                                C9638aw.m17190ZK();
                                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(1));
                                AppMethodBeat.m2505o(16100);
                                return true;
                            }
                            AppMethodBeat.m2505o(16100);
                            return false;
                        } else if (str.startsWith("//setibeacontabuinclose")) {
                            if (C9638aw.m17179RK()) {
                                C9638aw.m17190ZK();
                                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0));
                                AppMethodBeat.m2505o(16100);
                                return true;
                            }
                            AppMethodBeat.m2505o(16100);
                            return false;
                        } else if (str.startsWith("//setibeaconpushopen")) {
                            if (C9638aw.m17179RK()) {
                                C9638aw.m17190ZK();
                                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.TRUE);
                                AppMethodBeat.m2505o(16100);
                                return true;
                            }
                            AppMethodBeat.m2505o(16100);
                            return false;
                        } else if (str.startsWith("//setibeaconpushclose")) {
                            if (C9638aw.m17179RK()) {
                                C9638aw.m17190ZK();
                                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.FALSE);
                                AppMethodBeat.m2505o(16100);
                                return true;
                            }
                            AppMethodBeat.m2505o(16100);
                            return false;
                        } else if (str.startsWith("//ibeacon")) {
                            booleanValue = false;
                            z = false;
                            if (VERSION.SDK_INT >= 18) {
                                booleanValue = true;
                            }
                            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                            if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                                z = true;
                            }
                            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                            z2 = booleanValue && z && hasSystemFeature;
                            gA = "isNowSupportedIbeacon:" + z2 + "\n\nisSystemSupported:" + booleanValue + "\nisBlueStateOn:" + z + "\nisSupportedBLE:" + hasSystemFeature + "\nSDK:" + VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + C1427q.m3034LS() + "\noperatingSystemInfo:" + C1427q.m3038LW();
                            C30379h.m48466d(context, gA, "TestResult", context.getString(C25738R.string.akc), context.getString(C25738R.string.atb), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(16092);
                                    ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                    AppMethodBeat.m2505o(16092);
                                }
                            }, null);
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//gettbs")) {
                            booleanValue = C1427q.etf.euj;
                            sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                            str4 = sharedPreferences.getString("tbs_download", null);
                            str5 = sharedPreferences.getString("tbs_webview_disable", null);
                            boolean z3 = sharedPreferences.getBoolean("x5_jscore_enabled", false);
                            int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
                            tbsSDKVersion = WebView.getTbsSDKVersion(context);
                            String string = sharedPreferences.getString("tbs_webview_min_sdk_version", null);
                            gA = sharedPreferences.getString("tbs_webview_max_sdk_version", null);
                            Toast.makeText(context, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[]{Boolean.valueOf(booleanValue), str4, str5, string, gA, Integer.valueOf(installedTbsCoreVersion), Integer.valueOf(tbsSDKVersion), Boolean.valueOf(z3)}), 1).show();
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//deletetbs")) {
                            intent = new Intent();
                            intent.setComponent(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            context.sendBroadcast(intent);
                            edit2 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            edit2.putLong("last_check_ts", 0);
                            edit2.apply();
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.FALSE);
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//tbsDisableOverScroll")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            try {
                                str3 = str.substring(str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1);
                            } catch (IndexOutOfBoundsException e3) {
                                str3 = "";
                            }
                            edit.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(str3));
                            edit.apply();
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//enabletbs")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            str4 = str.replace("//enabletbs ", "");
                            edit.putString("tbs_webview_disable", "1".equals(str4) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
                            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str4)) {
                                edit.putString("tbs_webview_min_sdk_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                edit.putString("tbs_webview_max_sdk_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            }
                            edit.apply();
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else if (str.startsWith("//wvsha1")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            try {
                                str3 = str.substring(str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1);
                            } catch (IndexOutOfBoundsException e4) {
                                str3 = "";
                            }
                            edit.putBoolean("wvsha1", Boolean.parseBoolean(str3));
                            edit.apply();
                            AppMethodBeat.m2505o(16100);
                            return true;
                        } else {
                            if (str.startsWith("//channelId")) {
                                C30379h.m48417J(context, C5059g.cdf, DownloadInfoColumns.CHANNELID);
                            }
                            if (str.startsWith("//traceroute")) {
                                C25985d.m41448H(context, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                                AppMethodBeat.m2505o(16100);
                                return true;
                            } else if (str.startsWith("//testoom")) {
                                for (intValue = 0; intValue < 20; intValue++) {
                                    Bitmap.createBitmap(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 1920, Config.ARGB_8888);
                                }
                                if (C1443d.m3068iW(23)) {
                                    Debug.getMemoryInfo(new MemoryInfo());
                                    C4990ab.m7417i("MicroMsg.CommandProcessor", "testoom %s", Long.valueOf(Runtime.getRuntime().totalMemory()), Long.valueOf(Runtime.getRuntime().freeMemory()));
                                }
                                AppMethodBeat.m2505o(16100);
                                return true;
                            } else {
                                if (str.startsWith("//qzone ")) {
                                    new C23283u(context).ajG(str.replace("//qzone ", ""));
                                }
                                int i;
                                StringBuilder stringBuilder2;
                                if (str.startsWith("//dumpcrash")) {
                                    C5730e.m8634is(C6457e.eSj + "crash/", C6457e.eSo);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//dumpanr")) {
                                    C5730e.m8634is("/data/anr/", C6457e.eSo);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//testanr")) {
                                    try {
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e5) {
                                        C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e5, "", new Object[0]);
                                    }
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//opensnsadRightbar")) {
                                    C1947ae.giI = true;
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//setlocation ")) {
                                    split = str.split(" ");
                                    if (split == null || !C4872b.dnO()) {
                                        AppMethodBeat.m2505o(16100);
                                        return false;
                                    }
                                    C1947ae.ghY = true;
                                    if (split.length > 0) {
                                        C1947ae.lat = C5046bo.getDouble(split[1], 0.0d);
                                    }
                                    if (split.length > 1) {
                                        C1947ae.lng = C5046bo.getDouble(split[2], 0.0d);
                                    }
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//switchsdcard")) {
                                    Object obj;
                                    ArrayList dpo = C5034bd.dpo();
                                    int size = dpo.size();
                                    C4990ab.m7416i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = ".concat(String.valueOf(size)));
                                    if (!(size <= 0 || dpo.get(0) == null || C5046bo.isNullOrNil(((C5033a) dpo.get(0)).xBt))) {
                                        for (intValue = 0; intValue < size; intValue++) {
                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "switchsdcard list i = " + intValue + " StatMountParse: " + dpo.get(intValue));
                                        }
                                    }
                                    for (i = 0; i < size; i++) {
                                        if (!((C5033a) dpo.get(i)).xBt.equals(C6457e.eSl)) {
                                            obj = ((C5033a) dpo.get(i)).xBt;
                                            break;
                                        }
                                    }
                                    obj = null;
                                    final Activity activity = (Activity) context;
                                    C4990ab.m7416i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: ".concat(String.valueOf(obj)));
                                    if (C5046bo.isNullOrNil(obj)) {
                                        C30379h.m48463bO(context, context.getString(C25738R.string.eu3));
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    }
                                    C30379h.m48466d(context, context.getString(C25738R.string.eu4), "", context.getString(C25738R.string.f9187s6), context.getString(C25738R.string.f9076or), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.m2504i(16093);
                                            C5144y c5144y = new C5144y(C5128ac.eSj + "SdcardInfo.cfg");
                                            c5144y.set(1, obj);
                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + c5144y.get(1));
                                            C4997aj.amB("welcome_page_show");
                                            C1737l.m3593m(context, true);
                                            C45382z c45382z = new C45382z();
                                            c45382z.csU.csV = false;
                                            C4879a.xxA.mo10055m(c45382z);
                                            WorkerProfile.m16161Ca().cfW.mo38846BV();
                                            C9638aw.getNotification().mo41568IH();
                                            C45287c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                                            if (C40423e.vdx != null) {
                                                C40423e.vdx.mo20426bd(activity);
                                            }
                                            activity.finish();
                                            AppMethodBeat.m2505o(16093);
                                        }
                                    }, null);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//getip")) {
                                    C9638aw.m17182Rg().mo14552d(new C6668bk(new C146413()));
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//localjsapi")) {
                                    C4990ab.m7419v("MicroMsg.CommandProcessor", "alvinluo path: %s", "file://" + C6457e.eSn + "test_jsapi.html");
                                    intent2 = new Intent();
                                    intent2.putExtra("rawUrl", str3);
                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//getlocalkey")) {
                                    gA = C7574bs.dus();
                                    C30379h.m48466d(context, gA, "Fingerprint Key", context.getString(C25738R.string.f5p), context.getString(C25738R.string.atb), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.m2504i(16095);
                                            ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                            Toast.makeText(context, C25738R.string.f5q, 0).show();
                                            AppMethodBeat.m2505o(16095);
                                        }
                                    }, null);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//getdevid")) {
                                    gA = C1427q.m3028LM();
                                    C30379h.m48466d(context, gA, "devid", context.getString(C25738R.string.akc), context.getString(C25738R.string.atb), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.m2504i(16096);
                                            ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                            AppMethodBeat.m2505o(16096);
                                        }
                                    }, null);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//testhtml")) {
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//testlocalhtml ")) {
                                    str3 = str.replace("//testlocalhtml ", "");
                                    intent2 = new Intent();
                                    intent2.putExtra("rawUrl", "file://".concat(String.valueOf(str3)));
                                    intent2.putExtra("neverGetA8Key", true);
                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//setkey")) {
                                    if (C7574bs.apW(str.replace("//setkey", ""))) {
                                        Toast.makeText(context, C25738R.string.f4g, 0).show();
                                    }
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//checkspell")) {
                                    gA = str.replace("//checkspell ", "");
                                    if (C5046bo.isNullOrNil(gA)) {
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    }
                                    stringBuilder2 = new StringBuilder();
                                    for (intValue = 0; intValue < gA.length(); intValue++) {
                                        stringBuilder2.append("[" + gA.charAt(intValue) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + SpellMap.m42342r(gA.charAt(intValue)) + "]");
                                    }
                                    C30379h.m48417J(context, stringBuilder2.toString(), "Check Spell");
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//gallery ")) {
                                    str3 = str.replace("//gallery ", "");
                                    if (C5046bo.isNullOrNil(str3)) {
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    }
                                    context.getSharedPreferences(C4996ah.doA(), 0).edit().putString("gallery", str3).commit();
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//svgtag")) {
                                    str3 = str.replace("//svgtag ", "");
                                    if (str3.equals("on")) {
                                        C41917d.m74027oZ(true);
                                    } else if (str3.equals("off")) {
                                        C41917d.m74027oZ(false);
                                    }
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//svgcode")) {
                                    try {
                                        str3 = str.replace("//svgcode ", "");
                                        if (!str3.equals("on")) {
                                            str3.equals("off");
                                        }
                                        Class cls = Class.forName("com.tencent.mm.BuildConfig");
                                        Field declaredField = cls.getDeclaredField("SVGCode");
                                        declaredField.setAccessible(true);
                                        booleanValue = declaredField.getBoolean(cls);
                                        try {
                                            Toast.makeText(C4996ah.getContext(), "Using SVG Code : " + booleanValue + " " + C5157b.dvK(), 1).show();
                                        } catch (Exception e6) {
                                        }
                                    } catch (ClassNotFoundException e7) {
                                        C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e7, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (NoSuchFieldException e8) {
                                        C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e8, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (IllegalAccessException e9) {
                                        C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e9, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (IllegalArgumentException e10) {
                                        C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e10, "", new Object[0]);
                                        booleanValue = false;
                                    }
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else if (str.startsWith("//testMbanner")) {
                                    try {
                                        split = str.replace("//testMbanner ", "").split(",");
                                        if (split.length >= 2) {
                                            C32776be.m53537ZV().mo53321a(new C37903bd(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), null));
                                        }
                                    } catch (Exception e11) {
                                    }
                                    AppMethodBeat.m2505o(16100);
                                    return true;
                                } else {
                                    if (str.startsWith("//testrsa")) {
                                        C4851z.m7216O("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                                    }
                                    if (str.startsWith("//recomT")) {
                                        try {
                                            C9638aw.m17190ZK().mo33885Yk().mo60657a(str.replace("//recomT ", ""), true, null);
                                        } catch (Exception e12) {
                                        }
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//recomF")) {
                                        try {
                                            C9638aw.m17190ZK().mo33885Yk().mo60657a(str.replace("//recomF ", ""), false, null);
                                        } catch (Exception e13) {
                                        }
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//resetwxpayagree")) {
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE);
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//ffmpeg")) {
                                        try {
                                            intValue = str.indexOf("-r ");
                                            dimensionPixelSize = str.indexOf("-b ");
                                            str3 = str.substring(intValue + 3, dimensionPixelSize);
                                            gA = str.substring(dimensionPixelSize + 3);
                                            float f = C5046bo.getFloat(str3.trim(), 0.0f);
                                            dimensionPixelSize = C5046bo.getInt(gA.trim(), 0);
                                            C29014b.qwZ = dimensionPixelSize;
                                            C29014b.qxa = f;
                                            Toast.makeText(C4996ah.getContext(), "set C2C video encode frame rate " + f + " bitrate " + dimensionPixelSize, 0).show();
                                        } catch (Exception e14) {
                                            Toast.makeText(C4996ah.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                                        }
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//onlinevideo")) {
                                        try {
                                            intValue = C5046bo.getInt(str.replace("//onlinevideo ", ""), 0);
                                            C9638aw.m17190ZK();
                                            C18628c.m29072Ry().set(C5127a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(intValue));
                                            Toast.makeText(C4996ah.getContext(), intValue > 0 ? "online video" : "offline video", 0).show();
                                        } catch (Exception e15) {
                                            C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e15, "", new Object[0]);
                                            Toast.makeText(C4996ah.getContext(), "set online video fail, please ensure your command.", 1).show();
                                        }
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//hevcinfo")) {
                                        str3 = C12691e.bOU();
                                        gA = ChattingUIFragment.xIj;
                                        C7620bi c7620bi = new C7620bi();
                                        c7620bi.mo14794ju(gA);
                                        c7620bi.mo14781hO(2);
                                        c7620bi.setType(1);
                                        c7620bi.mo14775eJ(System.currentTimeMillis());
                                        c7620bi.setContent(str3);
                                        C1829bf.m3752l(c7620bi);
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//presns")) {
                                        C7305d.xDG.mo10159p(new C14652(), 3000);
                                        Toast.makeText(C4996ah.getContext(), "preload sns", 0).show();
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//calcwxdata")) {
                                        C9638aw.m17190ZK();
                                        C18628c.m29072Ry().set(C5127a.USERINFO_BACKGROUND_CALC_TIME_LONG, Long.valueOf(0));
                                        Toast.makeText(C4996ah.getContext(), "calc wx data success", 0).show();
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else if (str.startsWith("//checkspace")) {
                                        try {
                                            intValue = C5046bo.getInt(str.replace("//checkspace ", ""), 0);
                                            C37693be c37693be = new C37693be();
                                            c37693be.cuq.cur = intValue;
                                            C4879a.xxA.mo10055m(c37693be);
                                            Toast.makeText(C4996ah.getContext(), "check space code ".concat(String.valueOf(intValue)), 0).show();
                                        } catch (Exception e152) {
                                            C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e152, "", new Object[0]);
                                            Toast.makeText(C4996ah.getContext(), "check space code fail, please ensure your command.", 1).show();
                                        }
                                        AppMethodBeat.m2505o(16100);
                                        return true;
                                    } else {
                                        if (str.startsWith("//showkv") && C4872b.dnO()) {
                                            try {
                                                intent2 = new Intent();
                                                intent2.addFlags(134217728);
                                                intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                                                ((C6956a) C1720g.m3528K(C6956a.class)).mo15198w(context, intent2);
                                                AppMethodBeat.m2505o(16100);
                                                return true;
                                            } catch (Exception e1522) {
                                                C4990ab.m7413e("MicroMsg.CommandProcessor", "showkv error [%s]", e1522.toString());
                                            }
                                        }
                                        C9497vv c9497vv;
                                        C41997hb c41997hb;
                                        final ArrayList dpo2;
                                        if (str.startsWith("//showexpt") && C4872b.dnO()) {
                                            ((C34069a) C1720g.m3528K(C34069a.class)).mo54615t(context, new Intent());
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//showroomexpt") && C4872b.dnO()) {
                                            ((C38991d) C1720g.m3528K(C38991d.class)).mo45804v(context, new Intent());
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//upfacemodel")) {
                                            C9638aw.m17182Rg().mo14552d(new C44796m(42));
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//facett")) {
                                            C9638aw.m17190ZK();
                                            C18628c.m29072Ry().set(C5127a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.FALSE);
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//startstory")) {
                                            C1947ae.gjz = true;
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//switchpaytype")) {
                                            split = str.split(" ");
                                            if (split == null || split.length < 2) {
                                                AppMethodBeat.m2505o(16100);
                                                return false;
                                            }
                                            try {
                                                intValue = C5046bo.getInt(split[1], 0);
                                                C9638aw.m17190ZK();
                                                C18628c.m29072Ry().set(339975, Integer.valueOf(intValue));
                                                AppMethodBeat.m2505o(16100);
                                                return true;
                                            } catch (Exception e16) {
                                                C4990ab.m7412e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                                                AppMethodBeat.m2505o(16100);
                                                return false;
                                            }
                                        } else if (str.startsWith("//setNfcOpenUrl ")) {
                                            str3 = str.replace("//setNfcOpenUrl ", "");
                                            edit = C4996ah.doC().edit();
                                            if (str3.equalsIgnoreCase(BuildConfig.COMMAND)) {
                                                str3 = "";
                                            }
                                            edit.putString("nfc_open_url", str3);
                                            edit.commit();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//setMBV8Debug ")) {
                                            str3 = str.replace("//setMBV8Debug ", "");
                                            edit = C4996ah.doC().edit();
                                            if (str3.equalsIgnoreCase("true")) {
                                                edit.putBoolean("appbrandgame_open_v8debug", true);
                                            } else {
                                                edit.putBoolean("appbrandgame_open_v8debug", false);
                                            }
                                            edit.commit();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//setWcwss ")) {
                                            str3 = str.replace("//setWcwss ", "");
                                            edit = C4996ah.doC().edit();
                                            if (str3.equalsIgnoreCase(BuildConfig.COMMAND)) {
                                                str3 = "";
                                            }
                                            edit.putString("appbrandgame_open_wcwss", str3);
                                            edit.commit();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//gamecb ")) {
                                            str3 = str.replace("//gamecb ", "").trim();
                                            edit = C4996ah.doC().edit();
                                            intValue = C5046bo.ank(str3);
                                            edit.putInt("appbrandgame_use_commandbuffer", intValue);
                                            Context context2 = C4996ah.getContext();
                                            StringBuilder stringBuilder3 = new StringBuilder("小游戏 CommandBuffer ");
                                            str3 = intValue == 0 ? "关闭" : intValue == -1 ? "默认" : "开启";
                                            Toast.makeText(context2, stringBuilder3.append(str3).toString(), 1).show();
                                            edit.commit();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//setAppBrandActionBar ")) {
                                            str3 = str.replace("//setAppBrandActionBar ", "");
                                            edit = C4996ah.doC().edit();
                                            if (str3.equalsIgnoreCase("new")) {
                                                edit.putBoolean("appbrand_new_actionbar", true);
                                            } else {
                                                edit.putBoolean("appbrand_new_actionbar", false);
                                            }
                                            edit.commit();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//snskvtest ")) {
                                            str3 = str.replace("//snskvtest", "").trim();
                                            if (str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                                C1947ae.gje = false;
                                            } else if (str3.equals("1")) {
                                                C1947ae.gje = true;
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//emoji ")) {
                                            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35607Jo(str.replace("//emoji ", ""));
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//share ")) {
                                            intValue = Integer.valueOf(str.replace("//share ", "")).intValue();
                                            C9638aw.m17190ZK();
                                            C18628c.m29072Ry().set(229635, Integer.valueOf(intValue));
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpappinfoblob ")) {
                                            C40439f aiJ = C14877am.bYJ().aiJ(str.replace("//dumpappinfoblob ", ""));
                                            C30379h.m48417J(context, aiJ.mo44068Hn() + IOUtils.LINE_SEPARATOR_UNIX + aiJ.mo44069Ho() + IOUtils.LINE_SEPARATOR_UNIX + aiJ.mo44070Hp(), "");
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//googleauth ")) {
                                            str3 = str.replace("//googleauth ", "");
                                            if (!TextUtils.isEmpty(str3)) {
                                                if ("webview".equals(str3)) {
                                                    context.getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("googleauth", true).commit();
                                                } else if (ImagesContract.LOCAL.equals(str3)) {
                                                    context.getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("googleauth", false).commit();
                                                }
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//clrgamecache")) {
                                            C43155a bDb = C20928a.bDb();
                                            if (bDb != null) {
                                                bDb.mo36279dV(context);
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//clearwepkg")) {
                                            c9497vv = new C9497vv();
                                            c9497vv.cSX.cuy = 6;
                                            gA = str.replace("//clearwepkg ", "").trim();
                                            if (!(C5046bo.isNullOrNil(gA) || gA.equals("//clearwepkg"))) {
                                                c9497vv.cSX.cSY = gA;
                                            }
                                            C4879a.xxA.mo10055m(c9497vv);
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//disableWePkg")) {
                                            c9497vv = new C9497vv();
                                            c9497vv.cSX.cuy = 7;
                                            C4879a.xxA.mo10055m(c9497vv);
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//updateGameConfig")) {
                                            C9367gu c9367gu = new C9367gu();
                                            c9367gu.cBw.f2862Cn = 5;
                                            C4879a.xxA.mo10055m(c9367gu);
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//clrgsd")) {
                                            c41997hb = new C41997hb();
                                            c41997hb.cBM.cuy = 3;
                                            gA = str.replace("//clrgsd ", "").trim();
                                            if (!(C5046bo.isNullOrNil(gA) || gA.equals("//clrgsd"))) {
                                                c41997hb.cBM.csB = gA;
                                            }
                                            C4879a.xxA.mo10055m(c41997hb);
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//delDownload")) {
                                            c41997hb = new C41997hb();
                                            c41997hb.cBM.cuy = 4;
                                            gA = str.replace("//delDownload ", "").trim();
                                            if (!(C5046bo.isNullOrNil(gA) || gA.equals("//delDownload"))) {
                                                c41997hb.cBM.csB = gA;
                                                C4879a.xxA.mo10055m(c41997hb);
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//googlemap")) {
                                            C1947ae.giH = true;
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//sosomap")) {
                                            C1947ae.giH = false;
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//opentrace")) {
                                            C44258d c44258d = new C44258d();
                                            C44258d.m79916hI(C4996ah.getContext());
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//updateConversation")) {
                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "update all conversation start");
                                            C9638aw.m17190ZK();
                                            for (String str32 : C18628c.m29083XR().dsO()) {
                                                C9638aw.m17190ZK();
                                                C7620bi fa = C18628c.m29080XO().mo15331fa(str32, " and not ( type = 10000 and isSend != 2 ) ");
                                                C9638aw.m17190ZK();
                                                C18628c.m29083XR().mo15801aq(fa);
                                            }
                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "update all conversation end");
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//setshakecarddata")) {
                                            C14896a.dgQ().cjO();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//clearshakecarddata")) {
                                            C14896a.dgQ().cjP();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//pageSize")) {
                                            Context context3 = C4996ah.getContext();
                                            stringBuilder = new StringBuilder("pageSize is ");
                                            C9638aw.m17190ZK();
                                            Toast.makeText(context3, stringBuilder.append(C18628c.m29069Ru().getPageSize()).toString(), 1).show();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//resetDBStatus")) {
                                            C9638aw.m17190ZK();
                                            C5728b c5728b = new C5728b(C18628c.m29071Rw());
                                            try {
                                                stringBuilder = new StringBuilder();
                                                C9638aw.m17190ZK();
                                                C5730e.m8644y(stringBuilder.append(C18628c.m29068Rt()).append(c5728b.getName().replace(".db", ".db.backup")).toString(), c5728b.getPath());
                                                C4990ab.m7417i("MicroMsg.CommandProcessor", "backupPath db path is %s", gA);
                                                C5730e.m8623aQ(c5728b.getPath(), c5728b.getAbsolutePath() + "err" + System.currentTimeMillis());
                                                Toast.makeText(C4996ah.getContext(), "db状态已重置,请重启微信", 1).show();
                                            } catch (Exception e15222) {
                                                C4990ab.m7420w("MicroMsg.CommandProcessor", "delete failed: " + e15222.getMessage());
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//makesnsdata ")) {
                                            C14898d.dgR().mo62939jR((long) C5046bo.getInt(str.replace("//makesnsdata ", ""), 0));
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//setsnsupload ")) {
                                            C1947ae.giR = C5046bo.getInt(str.replace("//setsnsupload ", ""), 0);
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//logsnstable")) {
                                            C4879a.xxA.mo10055m(new C6470cp());
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//resetsnstip")) {
                                            C9638aw.m17190ZK();
                                            C18628c.m29072Ry().set(327776, Integer.valueOf(0));
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//checkcount")) {
                                            C9638aw.m17190ZK();
                                            intValue = C18628c.m29080XO().mo15345oA(ChattingUIFragment.xIj);
                                            C9638aw.m17190ZK();
                                            Toast.makeText(context, "current count :" + intValue + " countAuto :" + C18628c.m29080XO().mo15262Rp(ChattingUIFragment.xIj), 1).show();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//changeframe ")) {
                                            C4996ah.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(str.replace("//changeframe ", "")).floatValue()).commit();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//opendumpview")) {
                                            C15497c c15497c = new C15497c();
                                            C15497c.m23813hH(C4996ah.getContext());
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpmemory")) {
                                            System.gc();
                                            System.gc();
                                            C37632b.dvT();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpsnsfile")) {
                                            C4879a.xxA.mo10055m(new C37792rc());
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//coverage")) {
                                            C3733f.m6039VZ(str.trim().substring(10));
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpthreadpool")) {
                                            C7305d.xDG.dqb();
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//testverifypsw ")) {
                                            str32 = str.replace("//testverifypsw ", "").trim();
                                            if (str32.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                                C1947ae.gjg = false;
                                            } else if (str32.equals("1")) {
                                                C1947ae.gjg = true;
                                            }
                                            C4990ab.m7411d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", str, Boolean.valueOf(C1947ae.gjg));
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//pickpoi")) {
                                            intent = new Intent();
                                            intent.putExtra("map_view_type", 8);
                                            C25985d.m41467b(context, C8741b.LOCATION, ".ui.RedirectUI", intent);
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//configlist")) {
                                            if (str.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                                                List bd = C42252ah.m74608bd(str, "^//configlist set ([\\S]*)=([\\S]*)$");
                                                if (bd != null && bd.size() == 2) {
                                                    C26373g.m41964Nu().put((String) bd.get(0), (String) bd.get(1));
                                                    C4879a.xxA.mo10055m(new C6471cq());
                                                }
                                            } else if (str.matches("^//configlist get ([\\S]*)$")) {
                                                List bd2 = C42252ah.m74608bd(str, "^//configlist get ([\\S]*)$");
                                                if (bd2 != null && bd2.size() == 1) {
                                                    str32 = (String) bd2.get(0);
                                                    Toast.makeText(context, str32 + "=" + C26373g.m41964Nu().getValue(str32), 0).show();
                                                }
                                            } else {
                                                C9638aw.m17190ZK();
                                                str32 = (String) C18628c.m29072Ry().get(278530, (Object) "");
                                                C9638aw.m17190ZK();
                                                gA = (String) C18628c.m29072Ry().get(278529, (Object) "");
                                                str4 = C6457e.eSn + "dynacfg.xml";
                                                C5046bo.m7591z(str4, (str32 + gA).getBytes());
                                                Toast.makeText(context, "output dynacfg xml to ".concat(String.valueOf(str4)), 0).show();
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//security")) {
                                            try {
                                                C9638aw.m17190ZK().mo33886Yl().mo60657a(str.replace("//security ", ""), true, null);
                                            } catch (Exception e17) {
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//updatepackage")) {
                                            try {
                                                C9638aw.m17182Rg().mo14552d(new C45181k(C5046bo.getInt(str.replace("//updatepackage ", "").trim(), 0)));
                                            } catch (Exception e18) {
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//copypackage")) {
                                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", str);
                                            dpo2 = C5034bd.dpo();
                                            tbsSDKVersion = dpo2.size();
                                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", Integer.valueOf(tbsSDKVersion));
                                            if (tbsSDKVersion < 2) {
                                                C30379h.m48463bO(context, context.getString(C25738R.string.b37));
                                            } else {
                                                C30379h.m48466d(context, context.getString(C25738R.string.b39), "", context.getString(C25738R.string.f9187s6), context.getString(C25738R.string.f9076or), new OnClickListener() {

                                                    /* renamed from: com.tencent.mm.console.b$3$1 */
                                                    class C14671 implements Runnable {

                                                        /* renamed from: com.tencent.mm.console.b$3$1$1 */
                                                        class C14681 implements Runnable {
                                                            C14681() {
                                                            }

                                                            public final void run() {
                                                                AppMethodBeat.m2504i(16074);
                                                                C30379h.m48465bQ(context, context.getString(C25738R.string.b38));
                                                                AppMethodBeat.m2505o(16074);
                                                            }
                                                        }

                                                        /* renamed from: com.tencent.mm.console.b$3$1$2 */
                                                        class C14692 implements Runnable {
                                                            C14692() {
                                                            }

                                                            public final void run() {
                                                                AppMethodBeat.m2504i(16075);
                                                                C30379h.m48465bQ(context, context.getString(C25738R.string.b37));
                                                                AppMethodBeat.m2505o(16075);
                                                            }
                                                        }

                                                        C14671() {
                                                        }

                                                        public final void run() {
                                                            AppMethodBeat.m2504i(16076);
                                                            try {
                                                                String str = C6457e.eSl;
                                                                C9638aw.m17190ZK();
                                                                String Yd = C18628c.m29095Yd();
                                                                C9638aw.m17190ZK();
                                                                String XH = C18628c.m29073XH();
                                                                C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", Integer.valueOf(tbsSDKVersion), str, Yd, XH, Yd.substring(str.length()));
                                                                for (int i = 0; i < tbsSDKVersion; i++) {
                                                                    XH = ((C5033a) dpo2.get(i)).xBt;
                                                                    if (!(C5046bo.isNullOrNil(XH) || str.contains(XH))) {
                                                                        C5728b c5728b = new C5728b(XH + r5);
                                                                        if (c5728b.exists() && c5728b.isDirectory()) {
                                                                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", Yd, C5736j.m8649w(c5728b.dMD()), Boolean.valueOf(C5730e.m8634is(C5736j.m8649w(c5728b.dMD()), Yd)));
                                                                            if (C5730e.m8634is(C5736j.m8649w(c5728b.dMD()), Yd)) {
                                                                                new C7306ak(Looper.getMainLooper()).post(new C14681());
                                                                                AppMethodBeat.m2505o(16076);
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                new C7306ak(Looper.getMainLooper()).post(new C14692());
                                                                AppMethodBeat.m2505o(16076);
                                                            } catch (Exception e) {
                                                                C4990ab.m7421w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", e.getMessage());
                                                                AppMethodBeat.m2505o(16076);
                                                            }
                                                        }
                                                    }

                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.m2504i(16077);
                                                        C7305d.post(new C14671(), "copypackage");
                                                        AppMethodBeat.m2505o(16077);
                                                    }
                                                }, null);
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//copy -n ")) {
                                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", str);
                                            dpo2 = C5034bd.dpo();
                                            tbsSDKVersion = dpo2.size();
                                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", Integer.valueOf(tbsSDKVersion));
                                            if (tbsSDKVersion < 2) {
                                                C30379h.m48463bO(context, context.getString(C25738R.string.b37));
                                            } else {
                                                C30379h.m48466d(context, context.getString(C25738R.string.b39), "", context.getString(C25738R.string.f9187s6), context.getString(C25738R.string.f9076or), new OnClickListener() {

                                                    /* renamed from: com.tencent.mm.console.b$4$1 */
                                                    class C14751 implements Runnable {

                                                        /* renamed from: com.tencent.mm.console.b$4$1$2 */
                                                        class C14762 implements Runnable {
                                                            C14762() {
                                                            }

                                                            public final void run() {
                                                                AppMethodBeat.m2504i(16079);
                                                                C30379h.m48465bQ(context, context.getString(C25738R.string.b37));
                                                                AppMethodBeat.m2505o(16079);
                                                            }
                                                        }

                                                        /* renamed from: com.tencent.mm.console.b$4$1$1 */
                                                        class C14771 implements Runnable {
                                                            C14771() {
                                                            }

                                                            public final void run() {
                                                                AppMethodBeat.m2504i(16078);
                                                                C30379h.m48465bQ(context, context.getString(C25738R.string.b38));
                                                                AppMethodBeat.m2505o(16078);
                                                            }
                                                        }

                                                        C14751() {
                                                        }

                                                        public final void run() {
                                                            AppMethodBeat.m2504i(16080);
                                                            try {
                                                                String substring = str.substring(10);
                                                                String str = C6457e.eSl;
                                                                C9638aw.m17190ZK();
                                                                String str2 = C18628c.getAccPath() + substring;
                                                                C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", substring, str, r1, str2, str2.substring(str.length()));
                                                                for (int i = 0; i < tbsSDKVersion; i++) {
                                                                    substring = ((C5033a) dpo2.get(i)).xBt;
                                                                    if (!(C5046bo.isNullOrNil(substring) || str.contains(substring))) {
                                                                        C5728b c5728b = new C5728b(substring + r5);
                                                                        if (c5728b.exists() && c5728b.isDirectory()) {
                                                                            C5728b c5728b2 = new C5728b(str2);
                                                                            if (!c5728b2.exists()) {
                                                                                c5728b2.mkdirs();
                                                                            }
                                                                            C4990ab.m7417i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", C5736j.m8649w(c5728b2.dMD()), C5736j.m8649w(c5728b.dMD()), Boolean.valueOf(C5730e.m8634is(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b2.dMD()))));
                                                                            if (C5730e.m8634is(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b2.dMD()))) {
                                                                                new C7306ak(Looper.getMainLooper()).post(new C14771());
                                                                                AppMethodBeat.m2505o(16080);
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                new C7306ak(Looper.getMainLooper()).post(new C14762());
                                                                AppMethodBeat.m2505o(16080);
                                                            } catch (Exception e) {
                                                                C4990ab.m7421w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", e.getMessage());
                                                                AppMethodBeat.m2505o(16080);
                                                            }
                                                        }
                                                    }

                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.m2504i(16081);
                                                        C7305d.post(new C14751(), "copy -n");
                                                        AppMethodBeat.m2505o(16081);
                                                    }
                                                }, null);
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//deletepackage")) {
                                            try {
                                                str32 = str.replace("//deletepackage ", "");
                                                C37699ci c37699ci = new C37699ci();
                                                c37699ci.cvy.cvz = C5046bo.getInt(str32, 0);
                                                C4879a.xxA.mo10055m(c37699ci);
                                            } catch (Exception e19) {
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//audiowritetofile")) {
                                            C1427q.etd.eql = true;
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else if (str.startsWith("//bankcard")) {
                                            intent = new Intent();
                                            intent.putExtra("BaseScanUI_select_scan_mode", 7);
                                            intent.putExtra("bank_card_owner", "test");
                                            if (!(C14034e.m22169bI(context) || C17981e.m28296bH(context))) {
                                                C25985d.m41467b((Activity) context, "scanner", ".ui.BaseScanUI", intent);
                                            }
                                            AppMethodBeat.m2505o(16100);
                                            return true;
                                        } else {
                                            if (str.startsWith("//banner")) {
                                                Map z4 = C5049br.m7595z("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                                                str32 = (String) z4.get(".sysmsg.mainframebanner.$type");
                                                gA = (String) z4.get(".sysmsg.mainframebanner.showtype");
                                                str4 = (String) z4.get(".sysmsg.mainframebanner.data");
                                                C4990ab.m7411d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", str32, gA, str4);
                                            }
                                            if (str.startsWith("//gamemsg")) {
                                                C9419mz c9419mz = new C9419mz();
                                                c9419mz.cIX.content = str;
                                                C4879a.xxA.mo10055m(c9419mz);
                                                AppMethodBeat.m2505o(16100);
                                                return true;
                                            } else if (str.startsWith("//shortcut#")) {
                                                C42080vq c42080vq = new C42080vq();
                                                c42080vq.cSC.cSD = str;
                                                C4879a.xxA.mo10055m(c42080vq);
                                                AppMethodBeat.m2505o(16100);
                                                return true;
                                            } else if (str.startsWith("//gallerytype")) {
                                                C30562p.yJd = !C30562p.yJd;
                                                AppMethodBeat.m2505o(16100);
                                                return true;
                                            } else {
                                                context.getString(C25738R.string.f7w);
                                                Object replace;
                                                if (str.startsWith("//fullexit")) {
                                                    C4997aj.amB("show_whatsnew");
                                                    C1737l.m3593m(context, true);
                                                    MMAppMgr.m7905bd(context);
                                                    C9638aw.hold();
                                                    C1720g.m3537RQ().mo5257lL("");
                                                    MMAppMgr.aAd();
                                                    AppMethodBeat.m2505o(16100);
                                                    return true;
                                                } else if (str.startsWith("//cleardldb")) {
                                                    C9638aw.m17190ZK();
                                                    C18628c.m29084XS().bit();
                                                    AppMethodBeat.m2505o(16100);
                                                    return true;
                                                } else if (str.startsWith("//setcardlayouttestdata")) {
                                                    replace = str.replace("//setcardlayouttestdata ", "");
                                                    C9638aw.m17190ZK();
                                                    C18628c.m29072Ry().set(C5127a.USERINFO_CARDLAYOUT_TESTDATA_STRING, replace);
                                                    AppMethodBeat.m2505o(16100);
                                                    return true;
                                                } else if (str.startsWith("//delchatroomsysmsg")) {
                                                    str32 = str.replace("//delchatroomsysmsg ", "");
                                                    dimensionPixelSize = str32.indexOf(" ");
                                                    str4 = str32.substring(0, dimensionPixelSize);
                                                    str32 = str32.substring(dimensionPixelSize);
                                                    if (C5046bo.isNullOrNil(str4)) {
                                                        AppMethodBeat.m2505o(16100);
                                                        return false;
                                                    } else if (str32.startsWith("<")) {
                                                        C7620bi c7620bi2 = new C7620bi();
                                                        c7620bi2.mo14775eJ(System.currentTimeMillis());
                                                        c7620bi2.setType(10002);
                                                        c7620bi2.setContent(str32);
                                                        c7620bi2.mo14781hO(0);
                                                        c7620bi2.mo14794ju(str4);
                                                        C1829bf.m3752l(c7620bi2);
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else {
                                                        AppMethodBeat.m2505o(16100);
                                                        return false;
                                                    }
                                                } else {
                                                    if (str.startsWith("//resetcrseq")) {
                                                        split = str.split(" ");
                                                        try {
                                                            long j2 = C5046bo.getLong(split[1], -1);
                                                            long j3 = C5046bo.getLong(split[2], -1);
                                                            long j4 = C5046bo.getLong(split[3], -1);
                                                            intValue = C5046bo.getInt(split[4], -1);
                                                            if (j2 > 0) {
                                                                gA = j2 + "@chatroom";
                                                                C9638aw.m17190ZK();
                                                                C7617ak aoZ = C18628c.m29083XR().aoZ(gA);
                                                                if (aoZ != null) {
                                                                    C4990ab.m7417i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", aoZ.getUsername(), Long.valueOf(aoZ.mo14741Hz()), Long.valueOf(aoZ.mo14739Hx()), Integer.valueOf(aoZ.mo14740Hy()), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(intValue));
                                                                    if (j3 > -1) {
                                                                        aoZ.mo14745eG(j3);
                                                                    }
                                                                    if (j4 > -1) {
                                                                        aoZ.mo14744eF(j4);
                                                                    }
                                                                    if (intValue >= 0) {
                                                                        aoZ.mo14755hT(intValue);
                                                                    }
                                                                    C9638aw.m17190ZK();
                                                                    intValue = C18628c.m29083XR().mo15768a(aoZ, aoZ.getUsername(), false);
                                                                    C4990ab.m7417i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", aoZ.getUsername(), Long.valueOf(aoZ.mo14741Hz()), Long.valueOf(aoZ.mo14739Hx()), Integer.valueOf(aoZ.mo14740Hy()), Integer.valueOf(intValue));
                                                                    AppMethodBeat.m2505o(16100);
                                                                    return true;
                                                                }
                                                            }
                                                        } catch (Exception e152222) {
                                                            C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e152222, "summerbadcr resetcrseq", new Object[0]);
                                                        }
                                                    }
                                                    if (str.startsWith("//printchatroominfo")) {
                                                        str32 = ChattingUIFragment.xIj;
                                                        if (C1855t.m3896kH(str32)) {
                                                            C9638aw.m17190ZK();
                                                            final C7577u oa = C18628c.m29087XV().mo14885oa(str32);
                                                            if (oa == null) {
                                                                C4990ab.m7413e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", str32);
                                                                AppMethodBeat.m2505o(16100);
                                                                return false;
                                                            }
                                                            C7305d.xDG.execute(new Runnable() {
                                                                public final void run() {
                                                                    AppMethodBeat.m2504i(16082);
                                                                    int drT = oa.drT();
                                                                    int i = oa.field_chatroomdataflag;
                                                                    int drV = oa.drV();
                                                                    C7577u c7577u = oa;
                                                                    if (c7577u.mo16794b(c7577u.xIo)) {
                                                                        c7577u.drS();
                                                                    }
                                                                    int i2 = c7577u.xIo.status;
                                                                    int drW = oa.drW();
                                                                    c7577u = oa;
                                                                    if (c7577u.mo16794b(c7577u.xIo)) {
                                                                        c7577u.drS();
                                                                    }
                                                                    String str = c7577u.xIo.eox;
                                                                    List afg = oa.afg();
                                                                    C9638aw.m17190ZK();
                                                                    C7620bi fa = C18628c.m29080XO().mo15331fa(str32, " and msgSeq != 0 and flag & 2 != 0");
                                                                    boolean z = fa != null && fa.field_msgId > 0;
                                                                    C9638aw.m17190ZK();
                                                                    C4990ab.m7417i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", str32, Integer.valueOf(drT), Integer.valueOf(i), Integer.valueOf(drV), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(C18628c.m29080XO().mo15262Rp(str32)), Integer.valueOf(drW), str, Integer.valueOf(afg.size()));
                                                                    StringBuilder stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("---chatroominfo---\nid:").append(str32).append("\nver:").append(drT).append("\nflag:").append(i).append("\ntype:").append(drV).append("\nstatus:").append(i2).append("\nget:").append(z).append("\nmsgCount:").append(r8).append("\nmaxCount:").append(drW).append("\nupgrader:").append(str).append("\nmembersize:").append(afg.size()).append("\nisSilence:").append(((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15216QL(str32)).append("\nsillenceBlock:").append(((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15219QO(str32).toString());
                                                                    int i3 = -1;
                                                                    try {
                                                                        i3 = C5046bo.getInt(str.split(" ")[1], 0);
                                                                    } catch (Exception e) {
                                                                    }
                                                                    if (i3 == -1) {
                                                                        i3 = afg.size();
                                                                    }
                                                                    if (i3 > afg.size()) {
                                                                        i3 = afg.size();
                                                                    }
                                                                    if (i3 > 10) {
                                                                        i = 10;
                                                                    } else {
                                                                        i = i3;
                                                                    }
                                                                    if (i > 0) {
                                                                        stringBuilder.append("\nmember:");
                                                                    }
                                                                    for (drT = 0; drT < i; drT++) {
                                                                        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX).append((String) afg.get(drT));
                                                                    }
                                                                    fa = new C7620bi();
                                                                    fa.mo14794ju(str32);
                                                                    fa.mo14781hO(2);
                                                                    fa.setType(1);
                                                                    fa.mo14775eJ(System.currentTimeMillis());
                                                                    fa.setContent(stringBuilder.toString());
                                                                    C1829bf.m3752l(fa);
                                                                    AppMethodBeat.m2505o(16082);
                                                                }
                                                            });
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        }
                                                        AppMethodBeat.m2505o(16100);
                                                        return false;
                                                    } else if (str.startsWith("//clean chatroomblock")) {
                                                        gA = ChattingUIFragment.xIj;
                                                        C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
                                                        if (str.equals("//clean chatroomblock hard")) {
                                                            Toast.makeText(C4996ah.getContext(), "clean block hard! ret:".concat(String.valueOf(bOm.mo15210QF(gA))), 1).show();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.equals("//clean chatroomblock all")) {
                                                            Toast.makeText(C4996ah.getContext(), "delete table! ret:".concat(String.valueOf(bOm.bOu())), 1).show();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else {
                                                            C7578w QN = bOm.mo15218QN(gA);
                                                            QN.field_lastLocalSeq = QN.field_lastPushSeq;
                                                            QN.field_lastLocalCreateTime = QN.field_lastPushCreateTime;
                                                            if (QN.field_seqBlockInfo != null) {
                                                                QN.field_seqBlockInfo.eoG.clear();
                                                            }
                                                            j = bOm.mo15223b(QN);
                                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "[chatroomblock] ret:".concat(String.valueOf(j)));
                                                            Toast.makeText(C4996ah.getContext(), "clean chatroomblock! ret:".concat(String.valueOf(j)), 1).show();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        }
                                                    } else if (str.equals("//testupdate")) {
                                                        replace = "";
                                                        try {
                                                            replace = C5046bo.convertStreamToString(context.getAssets().open("aplha_update_info.xml"));
                                                        } catch (IOException e20) {
                                                            C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e20, "", new Object[0]);
                                                        }
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(352273, replace);
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(352274, Long.valueOf(System.currentTimeMillis()));
                                                        new C44057a(replace).dhv();
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.equals("//checkUpdate0") || str.equals("//checkUpdate1")) {
                                                        C21429d.bQU().mo36883jd(str.equals("//checkUpdate1"));
                                                        C21429d.oEm = true;
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.equals("//debugsnstimelinestat")) {
                                                        C1947ae.giZ = !C1947ae.giZ;
                                                        Toast.makeText(C4996ah.getContext(), "debugSnsTimelineStat: " + C1947ae.giZ, 0).show();
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//abtestmsg") && C4872b.dnO()) {
                                                        C9654a pb = C37915a.m64038pb(str.replace("//abtestmsg", ""));
                                                        C18624c.abi().mo17132s(pb.items, 0);
                                                        C18624c.abj().mo39178s(pb.foD, 1);
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//triggergetabtest")) {
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(1));
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//vad")) {
                                                        doB = C4996ah.doB();
                                                        if (doB == null) {
                                                            AppMethodBeat.m2505o(16100);
                                                            return false;
                                                        } else if (str.startsWith("//vad get")) {
                                                            C30379h.m48417J(context, C18721c.amz(), "VAD PARAMS").show();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else {
                                                            edit2 = doB.edit();
                                                            if (str.startsWith("//vad sd")) {
                                                                edit2.putInt("s_delay_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            if (str.startsWith("//vad st")) {
                                                                edit2.putInt("sil_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            if (str.startsWith("//vad snr")) {
                                                                edit2.putFloat("s_n_ration", Float.valueOf(str.substring(10).trim()).floatValue());
                                                            }
                                                            if (str.startsWith("//vad sw")) {
                                                                edit2.putInt("s_window", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            if (str.startsWith("//vad sl")) {
                                                                edit2.putInt("s_length", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            edit2.apply();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        }
                                                    } else if (str.startsWith("//dumpabtestrecords")) {
                                                        if (2 < C4990ab.getLogLevel()) {
                                                            AppMethodBeat.m2505o(16100);
                                                            return false;
                                                        }
                                                        CharSequence drt;
                                                        if (str.contains("info")) {
                                                            drt = C18624c.abj().drt();
                                                        } else {
                                                            drt = C18624c.abi().drt();
                                                        }
                                                        textView2 = new TextView(context);
                                                        textView2.setText(drt);
                                                        textView2.setGravity(8388627);
                                                        textView2.setTextSize(1, 10.0f);
                                                        textView2.setLayoutParams(new LayoutParams(-1, -2));
                                                        textView2.setTextColor(-16744704);
                                                        textView2.setTypeface(Typeface.MONOSPACE);
                                                        textView2.setMovementMethod(new ScrollingMovementMethod());
                                                        intValue = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
                                                        textView2.setPadding(intValue, intValue, intValue, intValue);
                                                        C30379h.m48435a(context, null, textView2, null);
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//triggerWebViewCookiesCleanup")) {
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(0));
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//cleanwebcache")) {
                                                        C4879a.xxA.mo10055m(new C37694bo());
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//triggerWebViewCacheCleanup")) {
                                                        C45287c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//dumpsnsabtest")) {
                                                        C4879a.xxA.mo10055m(new C9308cn());
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//dumpsilkvoicefile")) {
                                                        C1947ae.gjd = true;
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//fucktit")) {
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.TRUE);
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//clog ")) {
                                                        C7060h.pYm.mo15418fP(str.substring(7), "test cLog " + System.currentTimeMillis());
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//testformsg") && C4872b.dnO()) {
                                                        str32 = str.substring(12).trim();
                                                        C4990ab.m7416i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + C9638aw.getSysCmdMsgExtension());
                                                        C7254cm c7254cm = new C7254cm();
                                                        c7254cm.vED = C1946aa.m4154vy(str32);
                                                        c7254cm.vEB = C1946aa.m4154vy("weixin");
                                                        c7254cm.vEC = C1946aa.m4154vy(C1853r.m3846Yz());
                                                        c7254cm.vEF = C1946aa.m4155vz("test");
                                                        c7254cm.nao = 10002;
                                                        C9638aw.getSysCmdMsgExtension().mo4453b(new C1197a(c7254cm, false, false, false));
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//canwebviewcachedownload")) {
                                                        booleanValue = C5046bo.getInt(C5046bo.nullAsNil(str.substring(25)).trim(), 1) > 0;
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//canwebviewcacheprepushdownload")) {
                                                        booleanValue = C5046bo.getInt(C5046bo.nullAsNil(str.substring(32)).trim(), 1) > 0;
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//resetsnslukcy")) {
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC, Boolean.FALSE);
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0));
                                                        C9638aw.m17190ZK();
                                                        C18628c.m29072Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0));
                                                        C4879a.xxA.mo10055m(new C42056rt());
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//enablempsp")) {
                                                        C30290a.m48190pi(false);
                                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//disablempsp")) {
                                                        C30290a.m48190pi(true);
                                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//soterpay")) {
                                                        C25985d.m41448H(context, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.SoterPayTestUI");
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith(context.getString(C25738R.string.f5f))) {
                                                        C1947ae.gjk = !C1947ae.gjk;
                                                        Toast.makeText(C4996ah.getContext(), String.format("showVoipDebugLog:%b", new Object[]{Boolean.valueOf(C1947ae.gjk)}), 0).show();
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//getdltaskinfo")) {
                                                        str32 = str.replace("//getdltaskinfo ", "");
                                                        try {
                                                            if (C2895c.m5147hv(C5046bo.getLong(str32, 0)) != null) {
                                                                C4990ab.m7417i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(C2895c.m5147hv(C5046bo.getLong(str32, 0)).field_downloadId), C2895c.m5147hv(C5046bo.getLong(str32, 0)).field_downloadUrl, C2895c.m5147hv(C5046bo.getLong(str32, 0)).field_filePath, C2895c.m5147hv(C5046bo.getLong(str32, 0)).field_md5);
                                                            } else {
                                                                C4990ab.m7416i("getdltaskinfo", "infoID null");
                                                            }
                                                        } catch (Exception e21) {
                                                            if (C2895c.m5143Iq(str32) != null) {
                                                                C4990ab.m7417i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(C2895c.m5143Iq(str32).field_downloadId), C2895c.m5143Iq(str32).field_downloadUrl, C2895c.m5143Iq(str32).field_filePath, C2895c.m5143Iq(str32).field_md5);
                                                            } else {
                                                                C4990ab.m7416i("getdltaskinfo", "infoURL null");
                                                            }
                                                        }
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//testscan ")) {
                                                        split = str.split(" ");
                                                        C1947ae.gjj = C5046bo.getFloat(split[1], 0.0f);
                                                        C1947ae.gji = C5046bo.getFloat(split[2], 0.0f);
                                                        Toast.makeText(C4996ah.getContext(), "mode auto:" + C1947ae.gjj + ",mode continuous:" + C1947ae.gji, 1).show();
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//switchrecordmode")) {
                                                        sharedPreferences = C4996ah.doB();
                                                        z2 = sharedPreferences.getBoolean("settings_voicerecorder_mode", false);
                                                        sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", !z2).commit();
                                                        if (z2) {
                                                            Toast.makeText(C4996ah.getContext(), "Turn off silk record", 1).show();
                                                        } else {
                                                            Toast.makeText(C4996ah.getContext(), "Turn on silk record", 1).show();
                                                        }
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//indoorsensorconfig ")) {
                                                        C18686e.akf().mo33957tI(str.replace("//indoorsensorconfig ", ""));
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//testindoorsensor ")) {
                                                        String[] split4 = str.replace("//testindoorsensor ", "").split(",");
                                                        C18686e.akf().mo33956a(12345, false, split4[0].equals("1"), C5046bo.getFloat(split4[1], 0.0f), C5046bo.getFloat(split4[2], 0.0f), 12);
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//facedebug")) {
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//rstfacett")) {
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//switchjsc")) {
                                                        str32 = str.replace("//switchjsc ", "");
                                                        sharedPreferences = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                                        if ("clear".equals(str32)) {
                                                            sharedPreferences.edit().remove("switch_x5_jscore").apply();
                                                        } else if ("true".equals(str32)) {
                                                            sharedPreferences.edit().putBoolean("switch_x5_jscore", true).apply();
                                                        } else if ("false".equals(str32)) {
                                                            sharedPreferences.edit().putBoolean("switch_x5_jscore", false).apply();
                                                        }
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//rfcdn")) {
                                                        try {
                                                            C37461f.afy().keep_OnRequestDoGetCdnDnsInfo(888);
                                                        } catch (Exception e1522222) {
                                                            C4990ab.m7413e("MicroMsg.CommandProcessor", "rfcdn :%s", C5046bo.m7574l(e1522222));
                                                        }
                                                        AppMethodBeat.m2505o(16100);
                                                        return true;
                                                    } else {
                                                        if (str.startsWith("//testcrscroll ")) {
                                                            split = str.split(" ");
                                                            if (split != null && split.length > 1) {
                                                                C44804ak.yRY = C5046bo.getInt(split[1], 0);
                                                                C4990ab.m7417i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", Integer.valueOf(C44804ak.yRY));
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            }
                                                        }
                                                        if (str.startsWith("//switchx5jscore")) {
                                                            doB = C4996ah.doB();
                                                            doB.edit().putBoolean("switch_x5_jscore", !doB.getBoolean("switch_x5_jscore", true)).apply();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//removeaudioplayer")) {
                                                            split = str.split(" ");
                                                            if (split.length >= 2) {
                                                                intValue = C5046bo.getInt(split[1], 3);
                                                                if (intValue >= 2 && intValue <= 9) {
                                                                    C9638aw.m17190ZK();
                                                                    C18628c.m29072Ry().set(C5127a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(intValue));
                                                                }
                                                            }
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//showaudiotoast")) {
                                                            split = str.split(" ");
                                                            if (split.length >= 2) {
                                                                intValue = C5046bo.getInt(split[1], 0);
                                                                C9638aw.m17190ZK();
                                                                C18628c.m29072Ry().set(C5127a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.valueOf(intValue == 1));
                                                            }
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//openmixaudio")) {
                                                            split = str.split(" ");
                                                            if (split.length >= 2) {
                                                                intValue = C5046bo.getInt(split[1], 0);
                                                                C9638aw.m17190ZK();
                                                                C18628c.m29072Ry().set(C5127a.USERINFO_MUSIC_OPEN_MIX_AUDIO_BOOLEAN_SYNC, Boolean.valueOf(intValue == 1));
                                                            }
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//switchmusicplayer")) {
                                                            C4990ab.m7417i("MicroMsg.CommandProcessor", "msg:%s", str);
                                                            split2 = str.split(" ");
                                                            if (split2.length > 2) {
                                                                Object obj2;
                                                                if (C5046bo.getInt(split2[1], 0) == 0) {
                                                                    obj2 = null;
                                                                } else {
                                                                    dimensionPixelSize = 1;
                                                                }
                                                                int i2 = C5046bo.getInt(split2[2], -1);
                                                                C9638aw.m17190ZK();
                                                                i = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue();
                                                                replace = 1;
                                                                if (i2 == -1) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = 255;
                                                                    } else {
                                                                        dimensionPixelSize = 0;
                                                                    }
                                                                } else if (i2 == 0) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 1;
                                                                    } else {
                                                                        dimensionPixelSize = i & -2;
                                                                    }
                                                                } else if (i2 == 1) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 2;
                                                                    } else {
                                                                        dimensionPixelSize = i & -3;
                                                                    }
                                                                } else if (i2 == 4) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 4;
                                                                    } else {
                                                                        dimensionPixelSize = i & -5;
                                                                    }
                                                                } else if (i2 == 6) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 16;
                                                                    } else {
                                                                        dimensionPixelSize = i & -17;
                                                                    }
                                                                } else if (i2 == 7) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 32;
                                                                    } else {
                                                                        dimensionPixelSize = i & -33;
                                                                    }
                                                                } else if (i2 == 8) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 64;
                                                                    } else {
                                                                        dimensionPixelSize = i & -65;
                                                                    }
                                                                } else if (i2 != 9) {
                                                                    replace = null;
                                                                    dimensionPixelSize = i;
                                                                } else if (obj2 != null) {
                                                                    dimensionPixelSize = i | 128;
                                                                } else {
                                                                    dimensionPixelSize = i & -129;
                                                                }
                                                                if (replace != null) {
                                                                    C9638aw.m17190ZK();
                                                                    C18628c.m29072Ry().set(C5127a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(dimensionPixelSize));
                                                                }
                                                            }
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//testdefaultrsa")) {
                                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                                                            split = str.split(" ");
                                                            booleanValue = split != null && split.length > 1;
                                                            C4851z.m7216O("", "", 0);
                                                            C1902e Rk = C1720g.m3535RO().mo5186Rg().mo14538Rk();
                                                            if (Rk == null) {
                                                                C4990ab.m7420w("MicroMsg.CommandProcessor", "summercert testdefaultrsa push not alive");
                                                                AppMethodBeat.m2505o(16100);
                                                                return false;
                                                            }
                                                            new C6686q("", "", "", 0).ajl().mo4456a(Rk, new C1202f() {

                                                                /* renamed from: com.tencent.mm.console.b$6$1 */
                                                                class C14561 implements Runnable {
                                                                    C14561() {
                                                                    }

                                                                    public final void run() {
                                                                        AppMethodBeat.m2504i(16083);
                                                                        C1457b.m3087D(context, "RSA(req) fatal err, must recheck!!!");
                                                                        AppMethodBeat.m2505o(16083);
                                                                    }
                                                                }

                                                                /* renamed from: com.tencent.mm.console.b$6$2 */
                                                                class C14592 implements C1202f {

                                                                    /* renamed from: com.tencent.mm.console.b$6$2$1 */
                                                                    class C14601 implements Runnable {
                                                                        C14601() {
                                                                        }

                                                                        public final void run() {
                                                                            AppMethodBeat.m2504i(16084);
                                                                            C1457b.m3087D(context, "RSA(base) fatal err, must recheck!!!");
                                                                            AppMethodBeat.m2505o(16084);
                                                                        }
                                                                    }

                                                                    C14592() {
                                                                    }

                                                                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                                                        AppMethodBeat.m2504i(16085);
                                                                        C4990ab.m7417i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                                        if (i == 4 && i2 == ZipJNI.UNZ_PARAMERROR) {
                                                                            C5004al.m7441d(new C14601());
                                                                            AppMethodBeat.m2505o(16085);
                                                                            return;
                                                                        }
                                                                        Toast.makeText(context, "DefaultRSA check pass", 0).show();
                                                                        C1457b.m3087D(context, "");
                                                                        AppMethodBeat.m2505o(16085);
                                                                    }
                                                                }

                                                                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                                                    AppMethodBeat.m2504i(16086);
                                                                    C4990ab.m7417i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                                    if (i != 4 || i2 == ZipJNI.UNZ_PARAMERROR || booleanValue) {
                                                                        new C18674i().mo4456a(C1720g.m3535RO().eJo.ftA, new C14592());
                                                                        AppMethodBeat.m2505o(16086);
                                                                        return;
                                                                    }
                                                                    C5004al.m7441d(new C14561());
                                                                    AppMethodBeat.m2505o(16086);
                                                                }
                                                            });
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//dumpdefaultrsa")) {
                                                            booleanValue = C1457b.m3086C(context, "");
                                                            AppMethodBeat.m2505o(16100);
                                                            return booleanValue;
                                                        } else if (str.startsWith("//hardwareinfo")) {
                                                            ((C28284a) C1720g.m3528K(C28284a.class)).mo46215hX(true);
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//showStringName")) {
                                                            doB = C4996ah.doB();
                                                            doB.edit().putBoolean("ShowStringName", !doB.getBoolean("ShowStringName", false)).commit();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//mmphotoedit")) {
                                                            C25985d.m41467b(context, "mmsight", ".ui.TestVideoEditUI", new Intent());
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//msgDelay")) {
                                                            C17062n.m26378ic(context);
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//cpDelayedMsg")) {
                                                            C17062n.m26379id(context);
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//testhce")) {
                                                            C25985d.m41448H(context, "nfc", ".ui.HceTestUI");
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//debugbigimg")) {
                                                            split = str.split(" ");
                                                            if (split.length == 2) {
                                                                if (split[1].equals("1")) {
                                                                    C4996ah.doB().edit().putBoolean("debug_big_img", true).apply();
                                                                } else {
                                                                    C4996ah.doB().edit().putBoolean("debug_big_img", false).apply();
                                                                }
                                                            }
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//testservice ")) {
                                                            str32 = str.replace("//testservice ", "");
                                                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                                            str4 = "forceTrigger";
                                                            booleanValue = str32 != null && str32.equals("1");
                                                            edit.putBoolean(str4, booleanValue).commit();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//openDetect")) {
                                                            C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().putBoolean("msg_delay_close_detect", false).apply();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//closeDetect")) {
                                                            C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().putBoolean("msg_delay_close_detect", true).apply();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//snsimage")) {
                                                            try {
                                                                intValue = C5046bo.getInt(str.replace("//snsimage ", ""), 0);
                                                                C37461f.afx().mo51226lh(intValue);
                                                                Toast.makeText(C4996ah.getContext(), intValue > 0 ? "tcp sns image download" : "http sns image download", 0).show();
                                                            } catch (Exception e15222222) {
                                                                C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e15222222, "", new Object[0]);
                                                                Toast.makeText(C4996ah.getContext(), "set snsimage fail, please ensure your command.", 1).show();
                                                            }
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//groupdownload")) {
                                                            try {
                                                                intValue = C5046bo.getInt(str.replace("//groupdownload ", ""), 0);
                                                                C22067aq.ruA = intValue;
                                                                Toast.makeText(C4996ah.getContext(), 1 == intValue ? "enable" : "disable", 0).show();
                                                            } catch (Exception e152222222) {
                                                                C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e152222222, "", new Object[0]);
                                                                Toast.makeText(C4996ah.getContext(), "set groupdownload fail, please ensure your command.", 1).show();
                                                            }
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//resetWeishi")) {
                                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(0));
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//clearWxWebCacheAndCookie")) {
                                                            intent = new Intent();
                                                            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                                            intent.putExtra("tools_clean_webview_cache_ignore_cookie", true);
                                                            C45287c.m83504aZ(intent);
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//destroyPreloadGameWebCore")) {
                                                            C12146d.destroy();
                                                            AppMethodBeat.m2505o(16100);
                                                            return true;
                                                        } else {
                                                            if (str.startsWith("//ecdhml ")) {
                                                                try {
                                                                    intValue = C5046bo.getInt(str.replace("//ecdhml ", ""), 0);
                                                                    if (intValue > 0 && intValue < 5) {
                                                                        sharedPreferences = C4996ah.getContext().getSharedPreferences("auth_info_key_prefs", C1448h.m3078Mu());
                                                                        if (intValue < 3) {
                                                                            sharedPreferences.edit().putBoolean("auth_info_prefs_use_new_ecdh", intValue == 1).commit();
                                                                            z = sharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
                                                                            C23639t.makeText(context, "reset ecdh mode " + (C4815f.vxx ? "enable" : "disable") + " to " + (z ? "enable" : "disable"), 0).show();
                                                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "summerauths reset ecdh ".concat(String.valueOf(z)));
                                                                        } else {
                                                                            sharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", intValue == 3).commit();
                                                                            z = sharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", false);
                                                                            stringBuilder2 = new StringBuilder("reset ecdh ml mode ").append(C4815f.vxy ? "enable" : "disable").append(" to ");
                                                                            if (z) {
                                                                                str32 = "enable";
                                                                            } else {
                                                                                str32 = "disable";
                                                                            }
                                                                            C23639t.makeText(context, stringBuilder2.append(str32).toString(), 0).show();
                                                                            C4990ab.m7416i("MicroMsg.CommandProcessor", "summerauths reset ecdh ml".concat(String.valueOf(z)));
                                                                        }
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    }
                                                                } catch (Exception e22) {
                                                                }
                                                            }
                                                            if (str.startsWith("//storyPostThreshold ")) {
                                                                intValue = 0;
                                                                try {
                                                                    intValue = Integer.valueOf(str.substring(21)).intValue();
                                                                } catch (NumberFormatException e23) {
                                                                    C4990ab.m7408b("MicroMsg.CommandProcessor", "NumberFormatException", new Object[0]);
                                                                }
                                                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(intValue));
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//newyearhb")) {
                                                                LuckyMoneyNewYearSendUI.ogj = 1;
                                                                try {
                                                                    LuckyMoneyNewYearSendUI.mState = Integer.valueOf(str.substring(11)).intValue();
                                                                } catch (NumberFormatException e24) {
                                                                }
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//hbemojisw")) {
                                                                C9638aw.m17190ZK();
                                                                intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                                                                C9638aw.m17190ZK();
                                                                C18628c.m29072Ry().set(C5127a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(intValue));
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//addbywework")) {
                                                                C9638aw.m17190ZK();
                                                                intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                                                                C9638aw.m17190ZK();
                                                                C18628c.m29072Ry().set(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_SWITCH_INT, Integer.valueOf(intValue));
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//enableDyBg ")) {
                                                                split = str.split(" ");
                                                                if (split.length == 2) {
                                                                    if (split[1].equals("1")) {
                                                                        C4996ah.doB().edit().putBoolean("enable_dynamic_bg", true).apply();
                                                                    } else {
                                                                        C4996ah.doB().edit().putBoolean("enable_dynamic_bg", false).apply();
                                                                    }
                                                                }
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//setbgfps ")) {
                                                                split = str.split(" ");
                                                                if (split.length == 2) {
                                                                    intValue = Integer.valueOf(split[1]).intValue();
                                                                    if (intValue > 0 && intValue <= 50) {
                                                                        C4996ah.doB().edit().putInt("dynamic_bg_fps", intValue).apply();
                                                                    }
                                                                }
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//offvoicesw")) {
                                                                C45818a.kCR = !C45818a.kCR;
                                                                C4990ab.m7411d("MicroMsg.CommandProcessor", "F2fRcvVoiceOffLineLogic.OFF_LINE:%s", Boolean.valueOf(C45818a.kCR));
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//setoffvoicespeed")) {
                                                                try {
                                                                    C45818a.bgJ().setSpeed(C5046bo.getFloat(str.substring(18), C45818a.kCS));
                                                                    C4990ab.m7411d("MicroMsg.CommandProcessor", "F2fRcvVoiceOffLineLogic.OFF_LINE_SPEED:%s", Float.valueOf(C45818a.kCS));
                                                                } catch (NumberFormatException e25) {
                                                                }
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//setoffvoicevolume")) {
                                                                try {
                                                                    C45818a.bgJ().setVolume(C5046bo.getFloat(str.substring(19), C45818a.kCT));
                                                                    C4990ab.m7411d("MicroMsg.CommandProcessor", "F2fRcvVoiceOffLineLogic.OFF_LINE_VOLUME:%s", Float.valueOf(C45818a.kCT));
                                                                } catch (NumberFormatException e26) {
                                                                }
                                                                AppMethodBeat.m2505o(16100);
                                                                return true;
                                                            } else {
                                                                C4990ab.m7411d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", Integer.valueOf(C1457b.m3092kK(str)));
                                                                switch (C1457b.m3092kK(str)) {
                                                                    case 0:
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return false;
                                                                    case 568:
                                                                        Assert.assertTrue("test errlog", false);
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 569:
                                                                        C9638aw.m17190ZK().mo33884Yj();
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 570:
                                                                        if (C7574bs.apW(C1457b.m3093kL(str))) {
                                                                            Toast.makeText(context, C25738R.string.f4g, 0).show();
                                                                        }
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 571:
                                                                        replace = C1457b.m3093kL(str);
                                                                        C9638aw.m17190ZK();
                                                                        C18628c.m29072Ry().set(8195, replace);
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 572:
                                                                        C5059g.cdh = Integer.valueOf(C1457b.m3093kL(str)).intValue();
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 574:
                                                                        StringBuilder append = new StringBuilder().append(C1427q.m3026LK());
                                                                        C9638aw.m17190ZK();
                                                                        C30379h.m48417J(context, C1178g.m2591x(append.append(C18628c.m29064QF()).toString().getBytes()), "md5");
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case C42524ad.CTRL_INDEX /*579*/:
                                                                        C26417a.m42064Zu().mo20967ai(C1457b.m3093kL(str), "");
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 580:
                                                                        C9638aw.m17182Rg().mo14552d(new C6668bk(new C14707()));
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 581:
                                                                        C14877am.bYI().aiH(C1457b.m3093kL(str));
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case C42526r.CTRL_INDEX /*582*/:
                                                                        str32 = C1457b.m3093kL(str);
                                                                        C9638aw.m17190ZK();
                                                                        aoO = C18628c.m29078XM().aoO(str32);
                                                                        if (aoO == null || aoO.mo16705Oh() == 0) {
                                                                            AppMethodBeat.m2505o(16100);
                                                                            return false;
                                                                        }
                                                                        aoO.mo16676NB();
                                                                        C1855t.m3964u(aoO);
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 583:
                                                                        C9638aw.m17190ZK();
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case C24697ae.CTRL_INDEX /*584*/:
                                                                    case C42444a.CTRL_INDEX /*585*/:
                                                                        C1831bh.m3771oG(C1457b.m3093kL(str));
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 586:
                                                                        split = str.split(" ");
                                                                        if (split != null && split.length == 3) {
                                                                            C1861q.m3975cu(C5046bo.getInt(split[1], 0), C5046bo.getInt(split[2], 0));
                                                                        }
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 587:
                                                                        C4879a.xxA.mo10055m(new C9309co());
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 588:
                                                                        C5730e.m8643tf("/sdcard/tencent/MicroMsg/back");
                                                                        C9638aw.m17190ZK();
                                                                        C5730e.m8634is(C18628c.m29068Rt(), "/sdcard/tencent/MicroMsg/back");
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case C45628v.CTRL_INDEX /*590*/:
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    case 591:
                                                                        try {
                                                                            split = str.split(" ");
                                                                            if (split != null && split.length > 1) {
                                                                                C9638aw.m17190ZK().mo33887Ym().mo73241n(C5049br.m7595z(split[0], "sysmsg"));
                                                                            }
                                                                        } catch (Exception e1522222222) {
                                                                            C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e1522222222, "hy: error occured in commandProcessor", new Object[0]);
                                                                        }
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return true;
                                                                    default:
                                                                        AppMethodBeat.m2505o(16100);
                                                                        return false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: C */
    private static boolean m3086C(Context context, String str) {
        AppMethodBeat.m2504i(16101);
        StringBuffer stringBuffer = new StringBuffer();
        if (!C5046bo.isNullOrNil(str)) {
            stringBuffer.append(str + "\n\n");
        }
        stringBuffer.append("Default RSA Info:\n");
        stringBuffer.append("ClientVersion: " + C5058f.CLIENT_VERSION + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("BASE_RSA_PUBLIC_VERSION = 183\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYN = AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885 len(512)\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
        stringBuffer.append("REQ_RSA_PUBLIC_VERSION = 184\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYN = BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9 len(512)\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
        C4990ab.m7416i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + stringBuffer.toString());
        if (C4872b.dnO()) {
            View textView = new TextView(context);
            textView.setText(stringBuffer.toString());
            textView.setGravity(19);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16711936);
            textView.setTypeface(Typeface.MONOSPACE);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f10017nj);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            C30379h.m48435a(context, null, textView, null);
            if (C4851z.dmz()) {
                Toast.makeText(context, "dump file:" + C6457e.eSn + "DefaultRSA.java", 1).show();
            }
            AppMethodBeat.m2505o(16101);
            return true;
        }
        AppMethodBeat.m2505o(16101);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fa A:{SYNTHETIC, Splitter:B:31:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e8 A:{SYNTHETIC, Splitter:B:22:0x00e8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: jb */
    private static StringBuilder m3089jb(int i) {
        Throwable e;
        AppMethodBeat.m2504i(16102);
        Date date = new Date(C5046bo.anU() - (((long) i) * 86400000));
        String str = C6457e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2;
        if (C5730e.m8628ct(str)) {
            stringBuilder2 = new StringBuilder(" day -" + i + " no crash.");
            AppMethodBeat.m2505o(16102);
            return stringBuilder2;
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new C5732g(str));
            try {
                if (C5046bo.isNullOrNil(bufferedReader.readLine())) {
                    bufferedReader.close();
                    stringBuilder2 = new StringBuilder("read day -" + i + "file failed");
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                    }
                    AppMethodBeat.m2505o(16102);
                    return stringBuilder2;
                }
                while (true) {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(new String(Base64.decode(str.split("error_")[1], 0)).split("#accinfo.uin=")[1]);
                        stringBuilder.append("\n_____________________________________\n");
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    }
                }
                bufferedReader.close();
                AppMethodBeat.m2505o(16102);
                return stringBuilder;
            } catch (Exception e4) {
                e = e4;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(16102);
                    return stringBuilder;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    AppMethodBeat.m2505o(16102);
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            C4990ab.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e7) {
                }
            }
            AppMethodBeat.m2505o(16102);
            return stringBuilder;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(16102);
            throw e;
        }
    }

    /* renamed from: jc */
    private static void m3090jc(int i) {
        AppMethodBeat.m2504i(16103);
        SharedPreferences s = C30284ar.m48183s(C4996ah.getContext(), "sp_sns_dynswitch_stg", 4);
        switch (i) {
            case -1:
                s.edit().remove("st_sw_use_vcodec_img").commit();
                AppMethodBeat.m2505o(16103);
                return;
            case 0:
                s.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                AppMethodBeat.m2505o(16103);
                return;
            case 1:
                s.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                AppMethodBeat.m2505o(16103);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(16103);
                throw illegalArgumentException;
        }
    }

    /* renamed from: jd */
    private static void m3091jd(int i) {
        AppMethodBeat.m2504i(16104);
        SharedPreferences s = C30284ar.m48183s(C4996ah.getContext(), "sp_sns_dynswitch_stg", 4);
        switch (i) {
            case -1:
                s.edit().remove("st_sw_use_wxpc_img").commit();
                AppMethodBeat.m2505o(16104);
                return;
            case 0:
                s.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                AppMethodBeat.m2505o(16104);
                return;
            case 1:
                s.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                AppMethodBeat.m2505o(16104);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(16104);
                throw illegalArgumentException;
        }
    }
}
