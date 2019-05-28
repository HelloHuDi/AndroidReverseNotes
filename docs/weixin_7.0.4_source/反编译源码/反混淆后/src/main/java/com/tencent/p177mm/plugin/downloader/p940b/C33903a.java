package com.tencent.p177mm.plugin.downloader.p940b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C18283hg;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.tencent.mm.plugin.downloader.b.a */
public final class C33903a implements C11511k {
    private static Set<C11501b> jfv = new CopyOnWriteArraySet();
    private static C33903a kKh = null;
    private static BroadcastReceiver kKi = null;
    private static C4884c kKj = new C115001();

    /* renamed from: com.tencent.mm.plugin.downloader.b.a$1 */
    static class C115001 extends C4884c<C18283hg> {
        C115001() {
            AppMethodBeat.m2504i(2283);
            this.xxI = C18283hg.class.getName().hashCode();
            AppMethodBeat.m2505o(2283);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(2284);
            C18283hg c18283hg = (C18283hg) c4883b;
            String str = c18283hg.cCb.url;
            if (!C5046bo.isNullOrNil(str)) {
                C42911a Iq = C2895c.m5143Iq(str);
                if (Iq != null) {
                    c18283hg.cCc.csB = Iq.field_appId;
                }
            }
            AppMethodBeat.m2505o(2284);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.b.a$b */
    public interface C11501b {
        /* renamed from: E */
        void mo23220E(int i, long j);
    }

    /* renamed from: com.tencent.mm.plugin.downloader.b.a$a */
    static class C33902a extends BroadcastReceiver {
        private C33902a() {
        }

        /* synthetic */ C33902a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(2285);
            if (context == null || intent == null) {
                AppMethodBeat.m2505o(2285);
                return;
            }
            String action = intent.getAction();
            C4990ab.m7416i("MicroMsg.DownloadEventBus", action);
            if (C5046bo.isNullOrNil(action)) {
                C4990ab.m7412e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
                AppMethodBeat.m2505o(2285);
            } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                action = "";
                try {
                    action = intent.getDataString();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.DownloadEventBus", "%s", C5046bo.m7574l(e));
                }
                C4990ab.m7417i("MicroMsg.DownloadEventBus", "get added package name : %s", action);
                if (C5046bo.isNullOrNil(action)) {
                    C4990ab.m7412e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
                    AppMethodBeat.m2505o(2285);
                    return;
                }
                if (action.startsWith("package:")) {
                    action = action.substring(8);
                }
                if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                    C4990ab.m7412e("MicroMsg.DownloadEventBus", "no user login");
                    AppMethodBeat.m2505o(2285);
                    return;
                }
                C42911a c42911a;
                C42912b XS = C2895c.m5144XS();
                if (XS == null) {
                    c42911a = null;
                } else if (C5046bo.isNullOrNil(action)) {
                    C4990ab.m7412e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                    c42911a = null;
                } else {
                    Cursor rawQuery = XS.rawQuery("select * from FileDownloadInfo where packageName='" + action + "' order by downloadId desc limit 1", new String[0]);
                    if (rawQuery == null) {
                        c42911a = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            c42911a = new C42911a();
                            c42911a.mo8995d(rawQuery);
                        } else {
                            c42911a = null;
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    }
                }
                if (c42911a == null) {
                    AppMethodBeat.m2505o(2285);
                    return;
                }
                C33903a.m55478hk(c42911a.field_downloadId);
                AppMethodBeat.m2505o(2285);
            } else {
                AppMethodBeat.m2505o(2285);
            }
        }
    }

    /* renamed from: hk */
    static /* synthetic */ void m55478hk(long j) {
        AppMethodBeat.m2504i(2299);
        C33903a.m55475D(9, j);
        AppMethodBeat.m2505o(2299);
    }

    static {
        AppMethodBeat.m2504i(2300);
        AppMethodBeat.m2505o(2300);
    }

    /* renamed from: a */
    public static void m55476a(C11501b c11501b) {
        AppMethodBeat.m2504i(2286);
        if (c11501b != null) {
            jfv.add(c11501b);
        }
        AppMethodBeat.m2505o(2286);
    }

    /* renamed from: b */
    public static void m55477b(C11501b c11501b) {
        AppMethodBeat.m2504i(2287);
        if (c11501b != null) {
            jfv.remove(c11501b);
        }
        AppMethodBeat.m2505o(2287);
    }

    public static void bie() {
        AppMethodBeat.m2504i(2288);
        if (kKh == null) {
            kKh = new C33903a();
        }
        if (kKi == null) {
            kKi = new C33902a();
        }
        C2896d.bij();
        C2886b.m5129a(kKh);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        C4996ah.getContext().registerReceiver(kKi, intentFilter);
        C4879a.xxA.mo10052c(kKj);
        AppMethodBeat.m2505o(2288);
    }

    public static void bgr() {
        AppMethodBeat.m2504i(2289);
        C2896d.bij();
        C2886b.m5130b(kKh);
        C4996ah.getContext().unregisterReceiver(kKi);
        kKh = null;
        kKi = null;
        jfv.clear();
        C4879a.xxA.mo10053d(kKj);
        AppMethodBeat.m2505o(2289);
    }

    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.m2504i(2290);
        C33903a.m55475D(1, j);
        AppMethodBeat.m2505o(2290);
    }

    /* renamed from: b */
    public final void mo7665b(long j, String str, boolean z) {
        AppMethodBeat.m2504i(2291);
        C33903a.m55475D(3, j);
        AppMethodBeat.m2505o(2291);
    }

    /* renamed from: b */
    public final void mo7664b(long j, int i, boolean z) {
        AppMethodBeat.m2504i(2292);
        C33903a.m55475D(5, j);
        AppMethodBeat.m2505o(2292);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.m2504i(2293);
        C33903a.m55475D(4, j);
        AppMethodBeat.m2505o(2293);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.m2504i(2294);
        C33903a.m55475D(2, j);
        AppMethodBeat.m2505o(2294);
    }

    /* renamed from: gm */
    public final void mo7667gm(long j) {
        AppMethodBeat.m2504i(2295);
        C33903a.m55475D(6, j);
        AppMethodBeat.m2505o(2295);
    }

    /* renamed from: i */
    public final void mo7669i(long j, String str) {
        AppMethodBeat.m2504i(2296);
        C33903a.m55475D(7, j);
        AppMethodBeat.m2505o(2296);
    }

    /* renamed from: gn */
    public final void mo7668gn(long j) {
        AppMethodBeat.m2504i(2297);
        C33903a.m55475D(8, j);
        AppMethodBeat.m2505o(2297);
    }

    /* renamed from: D */
    private static void m55475D(int i, long j) {
        AppMethodBeat.m2504i(2298);
        C4990ab.m7417i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", Integer.valueOf(i), Long.valueOf(j));
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            AppMethodBeat.m2505o(2298);
            return;
        }
        for (C11501b E : jfv) {
            E.mo23220E(i, hv.field_downloadId);
        }
        AppMethodBeat.m2505o(2298);
    }
}
