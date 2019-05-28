package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a */
public final class C39783a {
    public volatile C39782b qHp;
    public volatile boolean qVA;
    private IntentFilter qVB;
    ConcurrentHashMap<String, C29088c> qVC;
    public ConcurrentHashMap<String, C21969d> qVD;
    public C11511k qVE;
    private C7306ak qVF;
    public C39784a qVz;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$d */
    public static class C21969d implements Serializable {
        public String hcx;
        public String qTL;

        public C21969d(String str, String str2) {
            this.qTL = str;
            this.hcx = str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$1 */
    class C290871 implements C11511k {
        C290871() {
        }

        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.m2504i(36920);
            C39783a.this.mo62901Z(1, j);
            AppMethodBeat.m2505o(36920);
        }

        /* renamed from: b */
        public final void mo7665b(long j, String str, boolean z) {
            AppMethodBeat.m2504i(36921);
            if (C39783a.this.qHp != null) {
                C39783a.this.qHp.succeed(j);
            }
            C39783a.this.mo62901Z(3, j);
            AppMethodBeat.m2505o(36921);
        }

        /* renamed from: b */
        public final void mo7664b(long j, int i, boolean z) {
            AppMethodBeat.m2504i(36922);
            if (C39783a.this.qHp != null) {
                C39783a.this.qHp.failed(j);
            }
            C39783a.this.mo62901Z(8, j);
            AppMethodBeat.m2505o(36922);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.m2504i(36923);
            if (C39783a.this.qHp != null) {
                C39783a.this.qHp.stopped(j);
            }
            C39783a.this.mo62901Z(2, j);
            AppMethodBeat.m2505o(36923);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.m2504i(36924);
            if (C39783a.this.qHp != null) {
                C39783a.this.qHp.paused(j);
            }
            C39783a.this.mo62901Z(6, j);
            AppMethodBeat.m2505o(36924);
        }

        /* renamed from: gm */
        public final void mo7667gm(long j) {
            AppMethodBeat.m2504i(36925);
            C4990ab.m7417i("MicroMsg.AdDownloadApkMgr", "%d progress changed", Long.valueOf(j));
            if (C39783a.this.qHp != null) {
                FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(j);
                if (hm.kNr >= 0 && hm.jrb > 0) {
                    C39783a.this.qHp.progress(j, (int) ((hm.kNr * 100) / hm.jrb));
                }
            }
            AppMethodBeat.m2505o(36925);
        }

        /* renamed from: i */
        public final void mo7669i(long j, String str) {
            AppMethodBeat.m2504i(36926);
            if (C39783a.this.qHp != null) {
                C39783a.this.qHp.resumed(j);
            }
            C39783a.this.mo62901Z(7, j);
            AppMethodBeat.m2505o(36926);
        }

        /* renamed from: gn */
        public final void mo7668gn(long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$c */
    public interface C29088c {
        /* renamed from: XA */
        void mo47194XA(String str);

        /* renamed from: Xz */
        void mo47195Xz(String str);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$e */
    public static final class C29089e {
        public static final C39783a qVH = new C39783a();

        static {
            AppMethodBeat.m2504i(36929);
            AppMethodBeat.m2505o(36929);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$b */
    public interface C39782b {
        void failed(long j);

        void paused(long j);

        void progress(long j, int i);

        void resumed(long j);

        void stopped(long j);

        void succeed(long j);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$a */
    class C39784a extends BroadcastReceiver {
        private C39784a() {
        }

        /* synthetic */ C39784a(C39783a c39783a, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(36928);
            if (intent != null) {
                String action = intent.getAction();
                String schemeSpecificPart;
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!C5046bo.isNullOrNil(schemeSpecificPart) && C39783a.this.qVC.containsKey(schemeSpecificPart)) {
                        ((C29088c) C39783a.this.qVC.remove(schemeSpecificPart)).mo47195Xz(schemeSpecificPart);
                    }
                    AppMethodBeat.m2505o(36928);
                    return;
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!C5046bo.isNullOrNil(schemeSpecificPart) && C39783a.this.qVC.containsKey(schemeSpecificPart)) {
                        ((C29088c) C39783a.this.qVC.remove(schemeSpecificPart)).mo47194XA(schemeSpecificPart);
                    }
                }
            }
            AppMethodBeat.m2505o(36928);
        }
    }

    /* synthetic */ C39783a(byte b) {
        this();
    }

    private C39783a() {
        AppMethodBeat.m2504i(36930);
        this.qVC = new ConcurrentHashMap();
        this.qVD = new ConcurrentHashMap();
        this.qVE = new C290871();
        this.qVz = new C39784a(this, (byte) 0);
        this.qVB = new IntentFilter();
        this.qVB.addAction("android.intent.action.PACKAGE_ADDED");
        this.qVB.addAction("android.intent.action.PACKAGE_REMOVED");
        this.qVB.addDataScheme("package");
        this.qVF = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(36927);
                if (message.what == 10008) {
                    C4990ab.m7416i("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
                    C4996ah.getContext().unregisterReceiver(C39783a.this.qVz);
                    C39783a.this.qVA = false;
                }
                AppMethodBeat.m2505o(36927);
            }
        };
        AppMethodBeat.m2505o(36930);
    }

    public static long queryIdByAppid(String str) {
        AppMethodBeat.m2504i(36931);
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir != null) {
            long j = Ir.f16167id;
            AppMethodBeat.m2505o(36931);
            return j;
        }
        AppMethodBeat.m2505o(36931);
        return Long.MAX_VALUE;
    }

    /* renamed from: a */
    public final void mo62902a(String str, C29088c c29088c) {
        AppMethodBeat.m2504i(36932);
        this.qVC.put(str, c29088c);
        C4990ab.m7416i("MicroMsg.AdDownloadApkMgr", "register package receiver");
        C4996ah.getContext().registerReceiver(this.qVz, this.qVB);
        this.qVA = true;
        this.qVF.removeMessages(10008);
        this.qVF.sendEmptyMessageDelayed(10008, 300000);
        AppMethodBeat.m2505o(36932);
    }

    /* renamed from: Z */
    public final void mo62901Z(int i, long j) {
        AppMethodBeat.m2504i(36933);
        C42911a hC = ((C45826d) C1720g.m3528K(C45826d.class)).mo7017XS().mo68444hC(j);
        if (hC == null) {
            AppMethodBeat.m2505o(36933);
            return;
        }
        reportDownloadInfo(i, hC.field_appId);
        AppMethodBeat.m2505o(36933);
    }

    /* renamed from: q */
    private static String m68062q(Object... objArr) {
        AppMethodBeat.m2504i(36934);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(System.currentTimeMillis() / 1000);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(36934);
        return stringBuilder2;
    }

    /* renamed from: f */
    private void m68061f(int i, String str, String str2, String str3) {
        AppMethodBeat.m2504i(36935);
        System.currentTimeMillis();
        C21969d c21969d = (C21969d) this.qVD.get(str);
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("\\.", "_");
        }
        C4990ab.m7417i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", Integer.valueOf(14542), C39783a.m68062q(str, Integer.valueOf(i), str3, c21969d == null ? "" : c21969d.qTL + "." + c21969d.hcx + "." + str2 + ".0.20.0"));
        C4990ab.m7410d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(r0)));
        C7060h.pYm.mo8376a(14542, r1, true, false);
        AppMethodBeat.m2505o(36935);
    }

    public final void reportDownloadInfo(int i, String str) {
        AppMethodBeat.m2504i(36936);
        C42911a In = ((C45826d) C1720g.m3528K(C45826d.class)).mo7017XS().mo68439In(str);
        if (In == null) {
            C4990ab.m7416i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
            AppMethodBeat.m2505o(36936);
            return;
        }
        m68061f(i, str, In.field_packageName, In.field_downloadUrl);
        AppMethodBeat.m2505o(36936);
    }
}
