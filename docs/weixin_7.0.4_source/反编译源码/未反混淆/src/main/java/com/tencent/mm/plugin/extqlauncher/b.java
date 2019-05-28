package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.List;

public final class b implements at {
    private a lRI;
    private b lRJ;
    boolean lRK = false;
    private com.tencent.mm.sdk.e.n.b lRL = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(20473);
            ab.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
            if (b.this.lRK) {
                AppMethodBeat.o(20473);
                return;
            }
            aw.ZK();
            if (nVar != c.XR()) {
                AppMethodBeat.o(20473);
            } else if (nVar == null || obj == null) {
                ab.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
                AppMethodBeat.o(20473);
            } else if (ah.getContext() == null || !aw.RK()) {
                ab.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
                AppMethodBeat.o(20473);
            } else {
                b.this.bsc();
                AppMethodBeat.o(20473);
            }
        }
    };
    boolean lRM = false;
    long lRN = 0;
    private final long lRO = 300000;
    private final long lRP = 4000;
    private final String lRQ = "fun1";
    int lRR = 0;
    private ak lRS = new ak(Looper.getMainLooper()) {
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            AppMethodBeat.i(20476);
            if (ah.getContext() == null || !aw.RK()) {
                ab.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
                AppMethodBeat.o(20476);
                return;
            }
            if (b.a(b.this)) {
                int bsb = b.bsb();
                if (bsb > 0 || bsb < b.this.lRR) {
                    ab.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
                    Intent intent = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
                    intent.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
                    ah.getContext().sendBroadcast(intent);
                    b.this.lRR = bsb;
                }
            }
            AppMethodBeat.o(20476);
        }
    };

    class b extends com.tencent.mm.sdk.b.c<mv> {
        private b() {
            AppMethodBeat.i(20479);
            this.xxI = mv.class.getName().hashCode();
            AppMethodBeat.o(20479);
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
            AppMethodBeat.i(20482);
            this.xxI = mv.class.getName().hashCode();
            AppMethodBeat.o(20482);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(mv mvVar) {
            AppMethodBeat.i(20480);
            if (!b.a(b.this)) {
                ab.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
                AppMethodBeat.o(20480);
                return false;
            } else if (ah.getContext() == null) {
                ab.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
                AppMethodBeat.o(20480);
                return false;
            } else {
                ab.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", Integer.valueOf(mvVar.cIL.bJt), mvVar.cIL.scanResult);
                try {
                    switch (mvVar.cIL.bJt) {
                        case 0:
                            if (!bo.isNullOrNil(mvVar.cIL.scanResult) && mvVar.cIL.scanResult.startsWith("qlauncher://")) {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
                                intent.setData(Uri.parse(mvVar.cIL.scanResult));
                                intent.setFlags(268435456);
                                ah.getContext().startActivity(intent);
                                mvVar.cIM.ret = 1;
                                AppMethodBeat.o(20480);
                                return true;
                            }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", e.getMessage());
                }
                AppMethodBeat.o(20480);
                return false;
            }
        }
    }

    public static class a extends com.tencent.mm.sdk.b.c<fd> {
        public a() {
            AppMethodBeat.i(20477);
            this.xxI = fd.class.getName().hashCode();
            AppMethodBeat.o(20477);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(20478);
            fd fdVar = (fd) bVar;
            if (fdVar instanceof fd) {
                ExtControlProviderQLauncher extControlProviderQLauncher = new ExtControlProviderQLauncher(fdVar.cyw.crW, fdVar.cyw.cyy, fdVar.cyw.context);
                fdVar.cyx.cyz = extControlProviderQLauncher.query(fdVar.cyw.uri, null, null, fdVar.cyw.selectionArgs, null);
                AppMethodBeat.o(20478);
                return true;
            }
            ab.f("MicroMsg.SubCoreExtQLauncher", "mismatched event");
            AppMethodBeat.o(20478);
            return false;
        }
    }

    public b() {
        AppMethodBeat.i(20483);
        AppMethodBeat.o(20483);
    }

    public static b bsa() {
        AppMethodBeat.i(20484);
        aw.ZE();
        b bVar = (b) bw.oJ("plugin.extqlauncher");
        if (bVar == null) {
            bVar = new b();
            aw.ZE().a("plugin.extqlauncher", bVar);
        }
        AppMethodBeat.o(20484);
        return bVar;
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(20485);
        aw.ZK();
        c.XR().a(this.lRL);
        if (this.lRI == null) {
            this.lRI = new a();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.lRI);
        if (this.lRJ == null) {
            this.lRJ = new b(this, (byte) 0);
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.lRJ);
        AppMethodBeat.o(20485);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(20486);
        if (this.lRI != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.lRI);
        }
        if (this.lRJ != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.lRJ);
        }
        aw.ZK();
        c.XR().b(this.lRL);
        this.lRS.removeMessages(0);
        AppMethodBeat.o(20486);
    }

    public static int bsb() {
        AppMethodBeat.i(20487);
        if (aw.RK()) {
            int nR = u.nR(t.fkP);
            int Yv = l.Yv();
            if ((r.YD() & 32768) == 0) {
                nR -= Yv;
            }
            AppMethodBeat.o(20487);
            return nR;
        }
        ab.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
        AppMethodBeat.o(20487);
        return 0;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bsc() {
        AppMethodBeat.i(20488);
        this.lRS.removeMessages(0);
        this.lRS.sendEmptyMessageDelayed(0, 4000);
        AppMethodBeat.o(20488);
    }

    static /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(20489);
        boolean z;
        if (ah.getContext() == null) {
            ab.w("MicroMsg.SubCoreExtQLauncher", "isPluginInstall, ApplicationContext null");
            bVar.lRM = false;
            AppMethodBeat.o(20489);
            return false;
        } else if (System.currentTimeMillis() - bVar.lRN < 300000) {
            z = bVar.lRM;
            AppMethodBeat.o(20489);
            return z;
        } else {
            com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20474);
                    b.this.lRN = System.currentTimeMillis();
                    List installedApplications = ah.getContext().getPackageManager().getInstalledApplications(128);
                    if (installedApplications == null) {
                        ab.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
                        b.this.lRM = false;
                        AppMethodBeat.o(20474);
                        return;
                    }
                    int i = 0;
                    while (i < installedApplications.size()) {
                        try {
                            ApplicationInfo applicationInfo = (ApplicationInfo) installedApplications.get(i);
                            if (applicationInfo != null && ((bo.nullAsNil(applicationInfo.packageName).startsWith("com.tencent.qlauncher") || bo.nullAsNil(applicationInfo.packageName).startsWith("com.tencent.qqlauncher") || bo.nullAsNil(applicationInfo.packageName).startsWith("com.tencent.launcher")) && applicationInfo.metaData != null)) {
                                String string = applicationInfo.metaData.getString("qlauncher_wx_coop");
                                if (string == null || string.length() <= 0) {
                                    ab.w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", applicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - b.this.lRN));
                                    b.this.lRM = false;
                                } else {
                                    String[] split = string.split(",");
                                    if (split != null) {
                                        for (String nullAsNil : split) {
                                            if (bo.nullAsNil(nullAsNil).trim().equalsIgnoreCase("fun1")) {
                                                ab.d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", applicationInfo.packageName);
                                                b.this.lRM = true;
                                                AppMethodBeat.o(20474);
                                                return;
                                            }
                                        }
                                    }
                                    b.this.lRM = false;
                                }
                            }
                            i++;
                        } catch (Exception e) {
                            ab.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", e.getMessage());
                            b.this.lRM = false;
                            AppMethodBeat.o(20474);
                            return;
                        }
                    }
                    ab.d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", Long.valueOf(System.currentTimeMillis() - b.this.lRN));
                    AppMethodBeat.o(20474);
                }

                public final String toString() {
                    AppMethodBeat.i(20475);
                    String str = super.toString() + "|isPluginInstall";
                    AppMethodBeat.o(20475);
                    return str;
                }
            }, "MicroMsg.SubCoreExtQLauncher");
            z = bVar.lRM;
            AppMethodBeat.o(20489);
            return z;
        }
    }
}
