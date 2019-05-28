package com.tencent.p177mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p230g.p231a.C42032nv;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.p662wx.WXConstantsRecovery;
import com.tencent.recovery.p662wx.service.WXRecoveryHandleService;
import com.tencent.recovery.p662wx.service.WXRecoveryUploadService;
import com.tencent.recovery.p662wx.util.WXUtil;

/* renamed from: com.tencent.mm.modelrecovery.PluginRecovery */
public class PluginRecovery extends C7597f implements C9562c {
    private C4884c<C42032nv> fMF = new C76291();
    private RecoveryLogImpl fMG = new C66805();
    private BroadcastReceiver receiver = new C76302();

    /* renamed from: com.tencent.mm.modelrecovery.PluginRecovery$5 */
    class C66805 implements RecoveryLogImpl {
        C66805() {
        }

        /* renamed from: d */
        public final void mo11994d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(16529);
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(16529);
        }

        /* renamed from: v */
        public final void mo11998v(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(16530);
            C4990ab.m7419v(str, str2, objArr);
            AppMethodBeat.m2505o(16530);
        }

        /* renamed from: i */
        public final void mo11996i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(16531);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(16531);
        }

        /* renamed from: w */
        public final void mo11999w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(16532);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(16532);
        }

        /* renamed from: e */
        public final void mo11995e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(16533);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(16533);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(16534);
            C4990ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.m2505o(16534);
        }
    }

    /* renamed from: com.tencent.mm.modelrecovery.PluginRecovery$1 */
    class C76291 extends C4884c<C42032nv> {
        C76291() {
            AppMethodBeat.m2504i(16523);
            this.xxI = C42032nv.class.getName().hashCode();
            AppMethodBeat.m2505o(16523);
        }

        /* renamed from: a */
        private static boolean m13604a(C42032nv c42032nv) {
            AppMethodBeat.m2504i(16524);
            Context context;
            Builder builder;
            switch (c42032nv.cKm.action) {
                case 1:
                    context = C4996ah.getContext();
                    builder = new Builder();
                    builder.Aro = WXRecoveryHandleService.class.getName();
                    builder.Arp = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = C5058f.CLIENT_VERSION;
                    builder.Arl = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
                    builder.eCq = WXUtil.m8761iG(context);
                    RecoveryLogic.m8702a(context, builder.dQg(), new RecoveryContext());
                    break;
                case 2:
                    C1864a.aiz();
                    break;
                case 3:
                    context = C4996ah.getContext();
                    builder = new Builder();
                    builder.Aro = WXRecoveryHandleService.class.getName();
                    builder.Arp = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = C5058f.CLIENT_VERSION;
                    builder.Arl = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
                    builder.eCq = WXUtil.m8761iG(context);
                    RecoveryLogic.m8702a(context, builder.dQg(), new RecoveryContext());
                    break;
            }
            AppMethodBeat.m2505o(16524);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelrecovery.PluginRecovery$2 */
    class C76302 extends BroadcastReceiver {
        C76302() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(16526);
            if (intent != null) {
                if ("com.tecent.recovery.intent.action.LOG".equals(intent.getAction())) {
                    PluginRecovery.access$000(PluginRecovery.this);
                    AppMethodBeat.m2505o(16526);
                    return;
                } else if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(intent.getAction())) {
                    PluginRecovery.access$100(PluginRecovery.this);
                }
            }
            AppMethodBeat.m2505o(16526);
        }
    }

    /* renamed from: com.tencent.mm.modelrecovery.PluginRecovery$3 */
    class C76313 implements Runnable {
        C76313() {
        }

        public final void run() {
            AppMethodBeat.m2504i(16527);
            C4990ab.m7416i("MicroMsg.Recovery.PluginRecovery", "postLog");
            C1864a.aiz();
            AppMethodBeat.m2505o(16527);
        }
    }

    /* renamed from: com.tencent.mm.modelrecovery.PluginRecovery$4 */
    class C76324 implements Runnable {
        C76324() {
        }

        public final void run() {
            AppMethodBeat.m2504i(16528);
            C4990ab.m7416i("MicroMsg.Recovery.PluginRecovery", "postReport");
            C1865b.aiA();
            AppMethodBeat.m2505o(16528);
        }
    }

    public PluginRecovery() {
        AppMethodBeat.m2504i(16535);
        AppMethodBeat.m2505o(16535);
    }

    static /* synthetic */ void access$000(PluginRecovery pluginRecovery) {
        AppMethodBeat.m2504i(16541);
        pluginRecovery.postLog();
        AppMethodBeat.m2505o(16541);
    }

    static /* synthetic */ void access$100(PluginRecovery pluginRecovery) {
        AppMethodBeat.m2504i(16542);
        pluginRecovery.postReport();
        AppMethodBeat.m2505o(16542);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(16536);
        RecoveryLog.m8710a(this.fMG);
        if (c1681g.mo5183lQ(":sandbox")) {
            long currentTimeMillis = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tecent.recovery.intent.action.LOG");
            intentFilter.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
            C4996ah.getContext().registerReceiver(this.receiver, intentFilter);
            C5728b c5728b = new C5728b(WXConstantsRecovery.ArA);
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            C5728b c5728b2 = new C5728b(c5728b, "version.info");
            if (c5728b2.exists()) {
                c5728b2.delete();
            }
            try {
                String w = C5736j.m8649w(c5728b2.dMD());
                byte[] bytes = Integer.toHexString(C7243d.vxo).getBytes();
                C5730e.m8624b(w, bytes, bytes.length);
            } catch (Exception e) {
            }
            C4990ab.m7417i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.m2505o(16536);
    }

    public void execute(C1681g c1681g) {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(16537);
        this.fMF.dnU();
        AppMethodBeat.m2505o(16537);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(16538);
        this.fMF.dead();
        AppMethodBeat.m2505o(16538);
    }

    private void postLog() {
        AppMethodBeat.m2504i(16539);
        C7305d.post(new C76313(), "RecoveryWriteLogThread");
        AppMethodBeat.m2505o(16539);
    }

    private void postReport() {
        AppMethodBeat.m2504i(16540);
        C7305d.post(new C76324(), "RecoveryReportStatusThread");
        AppMethodBeat.m2505o(16540);
    }
}
