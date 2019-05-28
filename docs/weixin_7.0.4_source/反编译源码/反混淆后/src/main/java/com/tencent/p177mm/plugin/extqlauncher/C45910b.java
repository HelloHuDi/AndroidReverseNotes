package com.tencent.p177mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.p802jg.EType;
import com.p802jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37920l;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32550fd;
import com.tencent.p177mm.p230g.p231a.C45345mv;
import com.tencent.p177mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.extqlauncher.b */
public final class C45910b implements C1816at {
    private C39001a lRI;
    private C27909b lRJ;
    boolean lRK = false;
    private C4937b lRL = new C206101();
    boolean lRM = false;
    long lRN = 0;
    private final long lRO = 300000;
    private final long lRP = 4000;
    private final String lRQ = "fun1";
    int lRR = 0;
    private C7306ak lRS = new C7306ak(Looper.getMainLooper()) {
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(20476);
            if (C4996ah.getContext() == null || !C9638aw.m17179RK()) {
                C4990ab.m7420w("MicroMsg.SubCoreExtQLauncher", "wrong status");
                AppMethodBeat.m2505o(20476);
                return;
            }
            if (C45910b.m85142a(C45910b.this)) {
                int bsb = C45910b.bsb();
                if (bsb > 0 || bsb < C45910b.this.lRR) {
                    C4990ab.m7410d("MicroMsg.SubCoreExtQLauncher", "notify unread");
                    Intent intent = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
                    intent.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
                    C4996ah.getContext().sendBroadcast(intent);
                    C45910b.this.lRR = bsb;
                }
            }
            AppMethodBeat.m2505o(20476);
        }
    };

    /* renamed from: com.tencent.mm.plugin.extqlauncher.b$1 */
    class C206101 implements C4937b {
        C206101() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(20473);
            C4990ab.m7410d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
            if (C45910b.this.lRK) {
                AppMethodBeat.m2505o(20473);
                return;
            }
            C9638aw.m17190ZK();
            if (c7298n != C18628c.m29083XR()) {
                AppMethodBeat.m2505o(20473);
            } else if (c7298n == null || obj == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
                AppMethodBeat.m2505o(20473);
            } else if (C4996ah.getContext() == null || !C9638aw.m17179RK()) {
                C4990ab.m7420w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
                AppMethodBeat.m2505o(20473);
            } else {
                C45910b.this.bsc();
                AppMethodBeat.m2505o(20473);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.extqlauncher.b$b */
    class C27909b extends C4884c<C45345mv> {
        private C27909b() {
            AppMethodBeat.m2504i(20479);
            this.xxI = C45345mv.class.getName().hashCode();
            AppMethodBeat.m2505o(20479);
        }

        /* synthetic */ C27909b(C45910b c45910b, byte b) {
            this();
            AppMethodBeat.m2504i(20482);
            this.xxI = C45345mv.class.getName().hashCode();
            AppMethodBeat.m2505o(20482);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private boolean m44389a(C45345mv c45345mv) {
            AppMethodBeat.m2504i(20480);
            if (!C45910b.m85142a(C45910b.this)) {
                C4990ab.m7412e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
                AppMethodBeat.m2505o(20480);
                return false;
            } else if (C4996ah.getContext() == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
                AppMethodBeat.m2505o(20480);
                return false;
            } else {
                C4990ab.m7411d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", Integer.valueOf(c45345mv.cIL.bJt), c45345mv.cIL.scanResult);
                try {
                    switch (c45345mv.cIL.bJt) {
                        case 0:
                            if (!C5046bo.isNullOrNil(c45345mv.cIL.scanResult) && c45345mv.cIL.scanResult.startsWith("qlauncher://")) {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
                                intent.setData(Uri.parse(c45345mv.cIL.scanResult));
                                intent.setFlags(268435456);
                                C4996ah.getContext().startActivity(intent);
                                c45345mv.cIM.ret = 1;
                                AppMethodBeat.m2505o(20480);
                                return true;
                            }
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", e.getMessage());
                }
                AppMethodBeat.m2505o(20480);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.extqlauncher.b$a */
    public static class C39001a extends C4884c<C32550fd> {
        public C39001a() {
            AppMethodBeat.m2504i(20477);
            this.xxI = C32550fd.class.getName().hashCode();
            AppMethodBeat.m2505o(20477);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20478);
            C32550fd c32550fd = (C32550fd) c4883b;
            if (c32550fd instanceof C32550fd) {
                ExtControlProviderQLauncher extControlProviderQLauncher = new ExtControlProviderQLauncher(c32550fd.cyw.crW, c32550fd.cyw.cyy, c32550fd.cyw.context);
                c32550fd.cyx.cyz = extControlProviderQLauncher.query(c32550fd.cyw.uri, null, null, c32550fd.cyw.selectionArgs, null);
                AppMethodBeat.m2505o(20478);
                return true;
            }
            C4990ab.m7414f("MicroMsg.SubCoreExtQLauncher", "mismatched event");
            AppMethodBeat.m2505o(20478);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.extqlauncher.b$2 */
    class C459092 implements Runnable {
        C459092() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20474);
            C45910b.this.lRN = System.currentTimeMillis();
            List installedApplications = C4996ah.getContext().getPackageManager().getInstalledApplications(128);
            if (installedApplications == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
                C45910b.this.lRM = false;
                AppMethodBeat.m2505o(20474);
                return;
            }
            int i = 0;
            while (i < installedApplications.size()) {
                try {
                    ApplicationInfo applicationInfo = (ApplicationInfo) installedApplications.get(i);
                    if (applicationInfo != null && ((C5046bo.nullAsNil(applicationInfo.packageName).startsWith("com.tencent.qlauncher") || C5046bo.nullAsNil(applicationInfo.packageName).startsWith("com.tencent.qqlauncher") || C5046bo.nullAsNil(applicationInfo.packageName).startsWith("com.tencent.launcher")) && applicationInfo.metaData != null)) {
                        String string = applicationInfo.metaData.getString("qlauncher_wx_coop");
                        if (string == null || string.length() <= 0) {
                            C4990ab.m7421w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", applicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - C45910b.this.lRN));
                            C45910b.this.lRM = false;
                        } else {
                            String[] split = string.split(",");
                            if (split != null) {
                                for (String nullAsNil : split) {
                                    if (C5046bo.nullAsNil(nullAsNil).trim().equalsIgnoreCase("fun1")) {
                                        C4990ab.m7411d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", applicationInfo.packageName);
                                        C45910b.this.lRM = true;
                                        AppMethodBeat.m2505o(20474);
                                        return;
                                    }
                                }
                            }
                            C45910b.this.lRM = false;
                        }
                    }
                    i++;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", e.getMessage());
                    C45910b.this.lRM = false;
                    AppMethodBeat.m2505o(20474);
                    return;
                }
            }
            C4990ab.m7411d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", Long.valueOf(System.currentTimeMillis() - C45910b.this.lRN));
            AppMethodBeat.m2505o(20474);
        }

        public final String toString() {
            AppMethodBeat.m2504i(20475);
            String str = super.toString() + "|isPluginInstall";
            AppMethodBeat.m2505o(20475);
            return str;
        }
    }

    public C45910b() {
        AppMethodBeat.m2504i(20483);
        AppMethodBeat.m2505o(20483);
    }

    public static C45910b bsa() {
        AppMethodBeat.m2504i(20484);
        C9638aw.m17184ZE();
        C45910b c45910b = (C45910b) C45439bw.m83697oJ("plugin.extqlauncher");
        if (c45910b == null) {
            c45910b = new C45910b();
            C9638aw.m17184ZE().mo73244a("plugin.extqlauncher", c45910b);
        }
        AppMethodBeat.m2505o(20484);
        return c45910b;
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(20485);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10118a(this.lRL);
        if (this.lRI == null) {
            this.lRI = new C39001a();
        }
        C4879a.xxA.mo10052c(this.lRI);
        if (this.lRJ == null) {
            this.lRJ = new C27909b(this, (byte) 0);
        }
        C4879a.xxA.mo10052c(this.lRJ);
        AppMethodBeat.m2505o(20485);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(20486);
        if (this.lRI != null) {
            C4879a.xxA.mo10053d(this.lRI);
        }
        if (this.lRJ != null) {
            C4879a.xxA.mo10053d(this.lRJ);
        }
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10121b(this.lRL);
        this.lRS.removeMessages(0);
        AppMethodBeat.m2505o(20486);
    }

    public static int bsb() {
        AppMethodBeat.m2504i(20487);
        if (C9638aw.m17179RK()) {
            int nR = C32798u.m53585nR(C1855t.fkP);
            int Yv = C37920l.m64042Yv();
            if ((C1853r.m3822YD() & 32768) == 0) {
                nR -= Yv;
            }
            AppMethodBeat.m2505o(20487);
            return nR;
        }
        C4990ab.m7420w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
        AppMethodBeat.m2505o(20487);
        return 0;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    public final void bsc() {
        AppMethodBeat.m2504i(20488);
        this.lRS.removeMessages(0);
        this.lRS.sendEmptyMessageDelayed(0, 4000);
        AppMethodBeat.m2505o(20488);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m85142a(C45910b c45910b) {
        AppMethodBeat.m2504i(20489);
        boolean z;
        if (C4996ah.getContext() == null) {
            C4990ab.m7420w("MicroMsg.SubCoreExtQLauncher", "isPluginInstall, ApplicationContext null");
            c45910b.lRM = false;
            AppMethodBeat.m2505o(20489);
            return false;
        } else if (System.currentTimeMillis() - c45910b.lRN < 300000) {
            z = c45910b.lRM;
            AppMethodBeat.m2505o(20489);
            return z;
        } else {
            C7305d.xDH.mo10140a(new C459092(), "MicroMsg.SubCoreExtQLauncher");
            z = c45910b.lRM;
            AppMethodBeat.m2505o(20489);
            return z;
        }
    }
}
