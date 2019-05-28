package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public volatile b qHp;
    public volatile boolean qVA;
    private IntentFilter qVB;
    ConcurrentHashMap<String, c> qVC;
    public ConcurrentHashMap<String, d> qVD;
    public k qVE;
    private ak qVF;
    public a qVz;

    public static class d implements Serializable {
        public String hcx;
        public String qTL;

        public d(String str, String str2) {
            this.qTL = str;
            this.hcx = str2;
        }
    }

    public interface c {
        void XA(String str);

        void Xz(String str);
    }

    public static final class e {
        public static final a qVH = new a();

        static {
            AppMethodBeat.i(36929);
            AppMethodBeat.o(36929);
        }
    }

    public interface b {
        void failed(long j);

        void paused(long j);

        void progress(long j, int i);

        void resumed(long j);

        void stopped(long j);

        void succeed(long j);
    }

    class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(36928);
            if (intent != null) {
                String action = intent.getAction();
                String schemeSpecificPart;
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!bo.isNullOrNil(schemeSpecificPart) && a.this.qVC.containsKey(schemeSpecificPart)) {
                        ((c) a.this.qVC.remove(schemeSpecificPart)).Xz(schemeSpecificPart);
                    }
                    AppMethodBeat.o(36928);
                    return;
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!bo.isNullOrNil(schemeSpecificPart) && a.this.qVC.containsKey(schemeSpecificPart)) {
                        ((c) a.this.qVC.remove(schemeSpecificPart)).XA(schemeSpecificPart);
                    }
                }
            }
            AppMethodBeat.o(36928);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        AppMethodBeat.i(36930);
        this.qVC = new ConcurrentHashMap();
        this.qVD = new ConcurrentHashMap();
        this.qVE = new k() {
            public final void onTaskStarted(long j, String str) {
                AppMethodBeat.i(36920);
                a.this.Z(1, j);
                AppMethodBeat.o(36920);
            }

            public final void b(long j, String str, boolean z) {
                AppMethodBeat.i(36921);
                if (a.this.qHp != null) {
                    a.this.qHp.succeed(j);
                }
                a.this.Z(3, j);
                AppMethodBeat.o(36921);
            }

            public final void b(long j, int i, boolean z) {
                AppMethodBeat.i(36922);
                if (a.this.qHp != null) {
                    a.this.qHp.failed(j);
                }
                a.this.Z(8, j);
                AppMethodBeat.o(36922);
            }

            public final void onTaskRemoved(long j) {
                AppMethodBeat.i(36923);
                if (a.this.qHp != null) {
                    a.this.qHp.stopped(j);
                }
                a.this.Z(2, j);
                AppMethodBeat.o(36923);
            }

            public final void onTaskPaused(long j) {
                AppMethodBeat.i(36924);
                if (a.this.qHp != null) {
                    a.this.qHp.paused(j);
                }
                a.this.Z(6, j);
                AppMethodBeat.o(36924);
            }

            public final void gm(long j) {
                AppMethodBeat.i(36925);
                ab.i("MicroMsg.AdDownloadApkMgr", "%d progress changed", Long.valueOf(j));
                if (a.this.qHp != null) {
                    FileDownloadTaskInfo hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(j);
                    if (hm.kNr >= 0 && hm.jrb > 0) {
                        a.this.qHp.progress(j, (int) ((hm.kNr * 100) / hm.jrb));
                    }
                }
                AppMethodBeat.o(36925);
            }

            public final void i(long j, String str) {
                AppMethodBeat.i(36926);
                if (a.this.qHp != null) {
                    a.this.qHp.resumed(j);
                }
                a.this.Z(7, j);
                AppMethodBeat.o(36926);
            }

            public final void gn(long j) {
            }
        };
        this.qVz = new a(this, (byte) 0);
        this.qVB = new IntentFilter();
        this.qVB.addAction("android.intent.action.PACKAGE_ADDED");
        this.qVB.addAction("android.intent.action.PACKAGE_REMOVED");
        this.qVB.addDataScheme("package");
        this.qVF = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(36927);
                if (message.what == 10008) {
                    ab.i("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
                    ah.getContext().unregisterReceiver(a.this.qVz);
                    a.this.qVA = false;
                }
                AppMethodBeat.o(36927);
            }
        };
        AppMethodBeat.o(36930);
    }

    public static long queryIdByAppid(String str) {
        AppMethodBeat.i(36931);
        FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
        if (Ir != null) {
            long j = Ir.id;
            AppMethodBeat.o(36931);
            return j;
        }
        AppMethodBeat.o(36931);
        return Long.MAX_VALUE;
    }

    public final void a(String str, c cVar) {
        AppMethodBeat.i(36932);
        this.qVC.put(str, cVar);
        ab.i("MicroMsg.AdDownloadApkMgr", "register package receiver");
        ah.getContext().registerReceiver(this.qVz, this.qVB);
        this.qVA = true;
        this.qVF.removeMessages(10008);
        this.qVF.sendEmptyMessageDelayed(10008, 300000);
        AppMethodBeat.o(36932);
    }

    public final void Z(int i, long j) {
        AppMethodBeat.i(36933);
        com.tencent.mm.plugin.downloader.f.a hC = ((com.tencent.mm.plugin.downloader.a.d) g.K(com.tencent.mm.plugin.downloader.a.d.class)).XS().hC(j);
        if (hC == null) {
            AppMethodBeat.o(36933);
            return;
        }
        reportDownloadInfo(i, hC.field_appId);
        AppMethodBeat.o(36933);
    }

    private static String q(Object... objArr) {
        AppMethodBeat.i(36934);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(System.currentTimeMillis() / 1000);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(36934);
        return stringBuilder2;
    }

    private void f(int i, String str, String str2, String str3) {
        AppMethodBeat.i(36935);
        System.currentTimeMillis();
        d dVar = (d) this.qVD.get(str);
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("\\.", "_");
        }
        ab.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", Integer.valueOf(14542), q(str, Integer.valueOf(i), str3, dVar == null ? "" : dVar.qTL + "." + dVar.hcx + "." + str2 + ".0.20.0"));
        ab.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(r0)));
        h.pYm.a(14542, r1, true, false);
        AppMethodBeat.o(36935);
    }

    public final void reportDownloadInfo(int i, String str) {
        AppMethodBeat.i(36936);
        com.tencent.mm.plugin.downloader.f.a In = ((com.tencent.mm.plugin.downloader.a.d) g.K(com.tencent.mm.plugin.downloader.a.d.class)).XS().In(str);
        if (In == null) {
            ab.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
            AppMethodBeat.o(36936);
            return;
        }
        f(i, str, In.field_packageName, In.field_downloadUrl);
        AppMethodBeat.o(36936);
    }
}
