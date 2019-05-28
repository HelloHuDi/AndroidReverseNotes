package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;

public class PluginRecovery extends f implements c {
    private com.tencent.mm.sdk.b.c<nv> fMF = new com.tencent.mm.sdk.b.c<nv>() {
        {
            AppMethodBeat.i(16523);
            this.xxI = nv.class.getName().hashCode();
            AppMethodBeat.o(16523);
        }

        private static boolean a(nv nvVar) {
            AppMethodBeat.i(16524);
            Context context;
            Builder builder;
            switch (nvVar.cKm.action) {
                case 1:
                    context = ah.getContext();
                    builder = new Builder();
                    builder.Aro = WXRecoveryHandleService.class.getName();
                    builder.Arp = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION;
                    builder.Arl = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
                    builder.eCq = WXUtil.iG(context);
                    RecoveryLogic.a(context, builder.dQg(), new RecoveryContext());
                    break;
                case 2:
                    a.aiz();
                    break;
                case 3:
                    context = ah.getContext();
                    builder = new Builder();
                    builder.Aro = WXRecoveryHandleService.class.getName();
                    builder.Arp = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION;
                    builder.Arl = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
                    builder.eCq = WXUtil.iG(context);
                    RecoveryLogic.a(context, builder.dQg(), new RecoveryContext());
                    break;
            }
            AppMethodBeat.o(16524);
            return false;
        }
    };
    private RecoveryLogImpl fMG = new RecoveryLogImpl() {
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(16529);
            ab.d(str, str2, objArr);
            AppMethodBeat.o(16529);
        }

        public final void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(16530);
            ab.v(str, str2, objArr);
            AppMethodBeat.o(16530);
        }

        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(16531);
            ab.i(str, str2, objArr);
            AppMethodBeat.o(16531);
        }

        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(16532);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(16532);
        }

        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(16533);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(16533);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(16534);
            ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.o(16534);
        }
    };
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(16526);
            if (intent != null) {
                if ("com.tecent.recovery.intent.action.LOG".equals(intent.getAction())) {
                    PluginRecovery.access$000(PluginRecovery.this);
                    AppMethodBeat.o(16526);
                    return;
                } else if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(intent.getAction())) {
                    PluginRecovery.access$100(PluginRecovery.this);
                }
            }
            AppMethodBeat.o(16526);
        }
    };

    public PluginRecovery() {
        AppMethodBeat.i(16535);
        AppMethodBeat.o(16535);
    }

    static /* synthetic */ void access$000(PluginRecovery pluginRecovery) {
        AppMethodBeat.i(16541);
        pluginRecovery.postLog();
        AppMethodBeat.o(16541);
    }

    static /* synthetic */ void access$100(PluginRecovery pluginRecovery) {
        AppMethodBeat.i(16542);
        pluginRecovery.postReport();
        AppMethodBeat.o(16542);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(16536);
        RecoveryLog.a(this.fMG);
        if (gVar.lQ(":sandbox")) {
            long currentTimeMillis = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tecent.recovery.intent.action.LOG");
            intentFilter.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
            ah.getContext().registerReceiver(this.receiver, intentFilter);
            b bVar = new b(WXConstantsRecovery.ArA);
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            b bVar2 = new b(bVar, "version.info");
            if (bVar2.exists()) {
                bVar2.delete();
            }
            try {
                String w = j.w(bVar2.dMD());
                byte[] bytes = Integer.toHexString(d.vxo).getBytes();
                e.b(w, bytes, bytes.length);
            } catch (Exception e) {
            }
            ab.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.o(16536);
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(16537);
        this.fMF.dnU();
        AppMethodBeat.o(16537);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(16538);
        this.fMF.dead();
        AppMethodBeat.o(16538);
    }

    private void postLog() {
        AppMethodBeat.i(16539);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(16527);
                ab.i("MicroMsg.Recovery.PluginRecovery", "postLog");
                a.aiz();
                AppMethodBeat.o(16527);
            }
        }, "RecoveryWriteLogThread");
        AppMethodBeat.o(16539);
    }

    private void postReport() {
        AppMethodBeat.i(16540);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(16528);
                ab.i("MicroMsg.Recovery.PluginRecovery", "postReport");
                b.aiA();
                AppMethodBeat.o(16528);
            }
        }, "RecoveryReportStatusThread");
        AppMethodBeat.o(16540);
    }
}
