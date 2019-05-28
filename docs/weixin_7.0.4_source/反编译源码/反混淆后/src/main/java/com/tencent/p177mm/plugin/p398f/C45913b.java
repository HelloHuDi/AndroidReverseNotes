package com.tencent.p177mm.plugin.p398f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.PowerManager;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C6617c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18305ju;
import com.tencent.p177mm.p230g.p231a.C45310bp;
import com.tencent.p177mm.p230g.p231a.C6466ch;
import com.tencent.p177mm.platformtools.C1952t;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.p398f.p1399a.C27910e;
import com.tencent.p177mm.plugin.p398f.p1399a.C27911f;
import com.tencent.p177mm.plugin.p398f.p1399a.C39002b;
import com.tencent.p177mm.plugin.p398f.p1399a.C39003d;
import com.tencent.p177mm.plugin.p398f.p1399a.C45911a;
import com.tencent.p177mm.plugin.p398f.p1399a.C46909c;
import com.tencent.p177mm.plugin.p398f.p1482b.C39005b;
import com.tencent.p177mm.plugin.p398f.p399c.C20617b;
import com.tencent.p177mm.plugin.p398f.p399c.C3013c;
import com.tencent.p177mm.plugin.p398f.p399c.C3013c.C3014a;
import com.tencent.p177mm.plugin.p398f.p399c.C45914a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5729c;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.f.b */
public final class C45913b implements C9562c, C6617c {
    private static HashMap<Integer, C1366d> jZD;
    private static C45913b jZG;
    private C3457a jKo = new C459122();
    private C39005b jZE;
    private C1953a jZF;
    private C5004al jZH;
    private C3013c jZI = null;
    public HashSet<Long> jZJ = new HashSet();
    public boolean jZK = false;
    private boolean jZL = false;
    public C3013c jZM = null;
    C20617b jZN = null;
    private HashMap<Integer, C45911a> jZO = new HashMap();
    private C3014a jZP = new C430218();
    private C3014a jZQ = new C1178513();
    private C4884c<C6466ch> jZR = new C430203();
    private boolean jZS = false;
    private boolean jZT = true;
    private BroadcastReceiver jZU;
    private Runnable jZV;
    private boolean jZW = false;
    private C4884c<C45310bp> jZX = new C206145();

    /* renamed from: com.tencent.mm.plugin.f.b$13 */
    class C1178513 implements C3014a {

        /* renamed from: com.tencent.mm.plugin.f.b$13$1 */
        class C117861 implements Runnable {
            C117861() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18593);
                C45913b.this.jZI = null;
                C45913b.m85170i(C45913b.this);
                AppMethodBeat.m2505o(18593);
            }
        }

        C1178513() {
        }

        public final void finish() {
            AppMethodBeat.m2504i(18594);
            C45913b.m85155a(C45913b.this, new C117861());
            AppMethodBeat.m2505o(18594);
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$11 */
    class C2061111 implements Runnable {
        C2061111() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18591);
            if (!C45913b.m85166e(C45913b.this)) {
                if (C45913b.this.jZI != null) {
                    C45913b.this.jZI.isStop = true;
                    C45913b.this.jZI = null;
                }
                AppMethodBeat.m2505o(18591);
            } else if (C45913b.this.aZg()) {
                C7060h.pYm.mo8378a(664, 3, 1, false);
                AppMethodBeat.m2505o(18591);
            } else if (C45913b.this.jZI != null) {
                AppMethodBeat.m2505o(18591);
            } else {
                C45913b.this.jZI = new C3013c(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, C45913b.aZi(), C45913b.aZj(), C45913b.this.jZQ);
                C45913b.this.jZH.mo10310m(C45913b.this.jZI, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                if (((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(0))).longValue() <= 0) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(C5046bo.anT()));
                }
                AppMethodBeat.m2505o(18591);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$4 */
    class C206124 extends BroadcastReceiver {

        /* renamed from: com.tencent.mm.plugin.f.b$4$1 */
        class C206131 implements Runnable {
            C206131() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18579);
                C45913b.this.aZe();
                C4990ab.m7416i("MicroMsg.CalcWxService", "start to calc");
                if (C45913b.this.aZg()) {
                    C45913b c45913b = C45913b.this;
                    if (C5046bo.m7566gb(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_REPORT_TIME_LONG, Long.valueOf(0))).longValue()) >= 259200000) {
                        if (c45913b.jZN != null) {
                            c45913b.jZN.isStop = true;
                        }
                        c45913b.jZN = new C20617b();
                        c45913b.mo73754f(c45913b.jZN);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_REPORT_TIME_LONG, Long.valueOf(C5046bo.anU()));
                    }
                    AppMethodBeat.m2505o(18579);
                    return;
                }
                C7060h.pYm.mo8378a(664, 1, 1, false);
                C45913b.m85170i(C45913b.this);
                AppMethodBeat.m2505o(18579);
            }
        }

        C206124() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(18580);
            String action = intent.getAction();
            boolean z = true;
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        z = true;
                        break;
                    }
                    break;
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        z = true;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        z = false;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    C45913b.this.jZT = true;
                    break;
                case true:
                    C45913b.this.jZT = false;
                    break;
                case true:
                    C45913b.this.jZS = true;
                    break;
                case true:
                    C45913b.this.jZS = false;
                    break;
            }
            if (!C45913b.this.jZS || C45913b.this.jZT) {
                if (C45913b.this.jZV != null) {
                    C9638aw.m17180RS();
                    C5004al.m7439af(C45913b.this.jZV);
                    C45913b.this.jZV = null;
                }
                C45913b.m85174m(C45913b.this);
            } else {
                C4990ab.m7416i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
                if (C45913b.this.jZV == null) {
                    C45913b.this.jZV = new C206131();
                    C9638aw.m17180RS().mo10310m(C45913b.this.jZV, 300000);
                    AppMethodBeat.m2505o(18580);
                    return;
                }
            }
            AppMethodBeat.m2505o(18580);
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$5 */
    class C206145 extends C4884c<C45310bp> {

        /* renamed from: com.tencent.mm.plugin.f.b$5$1 */
        class C206151 implements Runnable {
            C206151() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18581);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, Long.valueOf(-1));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, Long.valueOf(0));
                C1720g.m3536RP().mo5239Ry().dsb();
                C45913b.aZc().aZd().delete();
                C45913b.this.jZW = false;
                AppMethodBeat.m2505o(18581);
            }
        }

        C206145() {
            AppMethodBeat.m2504i(18582);
            this.xxI = C45310bp.class.getName().hashCode();
            AppMethodBeat.m2505o(18582);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18584);
            boolean aZl = aZl();
            AppMethodBeat.m2505o(18584);
            return aZl;
        }

        private boolean aZl() {
            AppMethodBeat.m2504i(18583);
            C4990ab.m7417i("MicroMsg.CalcWxService", "%s clean wx file index event ", C45913b.this.aZk());
            C45913b.this.jZW = true;
            try {
                C1720g.m3539RS().mo10302aa(new C206151());
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.CalcWxService", e, "%s clean wx file error", C45913b.this.aZk());
            }
            AppMethodBeat.m2505o(18583);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$7 */
    public class C279137 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(18586);
            C45913b.this.jZL = false;
            if (C45913b.this.jZM != null) {
                if (C45913b.this.jZH != null) {
                    C45913b.this.jZH;
                    C5004al.m7439af(C45913b.this.jZM);
                }
                C45913b.this.jZM.isStop = true;
                C45913b.this.jZM = null;
                C7060h.pYm.mo8378a(664, 8, 1, false);
            }
            AppMethodBeat.m2505o(18586);
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$12 */
    class C3409112 implements Runnable {
        C3409112() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18592);
            if (C45913b.this.jZI != null) {
                if (C45913b.this.jZH != null) {
                    C45913b.this.jZH;
                    C5004al.m7439af(C45913b.this.jZI);
                }
                C45913b.this.jZI.isStop = true;
                C45913b.this.jZI = null;
                C7060h.pYm.mo8378a(664, 2, 1, false);
            }
            if (C45913b.this.jZN != null) {
                C45913b.this.jZN.isStop = true;
            }
            AppMethodBeat.m2505o(18592);
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$1 */
    static class C430191 implements C1366d {
        C430191() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39005b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$3 */
    class C430203 extends C4884c<C6466ch> {
        C430203() {
            AppMethodBeat.m2504i(18577);
            this.xxI = C6466ch.class.getName().hashCode();
            AppMethodBeat.m2505o(18577);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18578);
            final C6466ch c6466ch = (C6466ch) c4883b;
            C45913b.m85155a(C45913b.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18576);
                    if (c6466ch == null) {
                        AppMethodBeat.m2505o(18576);
                    } else if (C5046bo.isNullOrNil(c6466ch.cvw.talker)) {
                        AppMethodBeat.m2505o(18576);
                    } else {
                        try {
                            C39005b aZd = C45913b.aZc().aZd();
                            long j = c6466ch.cvw.cvx;
                            String str = c6466ch.cvw.talker;
                            int i = c6466ch.cvw.msgType;
                            String[] strArr = new String[]{String.valueOf(j), String.valueOf(i), str};
                            int delete = aZd.bSd.delete("WxFileIndex2", "msgId=? AND msgType=? AND username=? ", strArr);
                            C4990ab.m7417i("MicroMsg.WxFileIndexStorage", "delete by msg [%d %d %s] result[%d]", Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(delete));
                            AppMethodBeat.m2505o(18576);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
                            C7060h.pYm.mo8378a(664, 6, 1, false);
                            AppMethodBeat.m2505o(18576);
                        }
                    }
                }
            });
            AppMethodBeat.m2505o(18578);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$8 */
    class C430218 implements C3014a {

        /* renamed from: com.tencent.mm.plugin.f.b$8$1 */
        class C117891 implements Runnable {
            C117891() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18587);
                C45913b.this.jZM = null;
                C45913b.this.mo73755fD(false);
                AppMethodBeat.m2505o(18587);
            }
        }

        C430218() {
        }

        public final void finish() {
            AppMethodBeat.m2504i(18588);
            C45913b.m85155a(C45913b.this, new C117891());
            AppMethodBeat.m2505o(18588);
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$9 */
    class C430229 implements C5729c {
        C430229() {
        }

        /* renamed from: f */
        public final boolean mo11676f(C5728b c5728b) {
            AppMethodBeat.m2504i(18589);
            if (c5728b.isDirectory()) {
                AppMethodBeat.m2505o(18589);
                return false;
            } else if (c5728b.getName().endsWith(".apk") || c5728b.getName().endsWith(".temp")) {
                AppMethodBeat.m2505o(18589);
                return true;
            } else {
                AppMethodBeat.m2505o(18589);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.f.b$2 */
    class C459122 implements C3457a {
        C459122() {
        }

        /* renamed from: a */
        public final void mo7913a(C6977h c6977h, final C3460c c3460c) {
            AppMethodBeat.m2504i(18575);
            if (c6977h == null) {
                AppMethodBeat.m2505o(18575);
            } else if (c3460c == null || c3460c.oqK == null) {
                AppMethodBeat.m2505o(18575);
            } else {
                C45913b.m85155a(C45913b.this, new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(18574);
                        C4990ab.m7411d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", c3460c.oqJ, Integer.valueOf(c3460c.oqK.size()));
                        if ("delete".equals(c3460c.oqJ)) {
                            AppMethodBeat.m2505o(18574);
                            return;
                        }
                        int i = "delete".equals(c3460c.oqJ) ? 2 : 1;
                        Iterator it = c3460c.oqK.iterator();
                        while (it.hasNext()) {
                            C7620bi c7620bi = (C7620bi) it.next();
                            if (c7620bi != null) {
                                boolean contains;
                                C45913b c45913b = C45913b.this;
                                long j = c7620bi.field_msgId;
                                if (c45913b.jZK) {
                                    contains = c45913b.jZJ.contains(Long.valueOf(j));
                                } else {
                                    contains = false;
                                }
                                if (contains) {
                                    C4990ab.m7411d("MicroMsg.CalcWxService", "it locked now [%d]", Long.valueOf(c7620bi.field_msgId));
                                } else {
                                    C45913b.this.jZH.mo10302aa(new C45914a(c7620bi, i));
                                }
                            }
                        }
                        AppMethodBeat.m2505o(18574);
                    }
                });
                AppMethodBeat.m2505o(18575);
            }
        }
    }

    public C45913b() {
        AppMethodBeat.m2504i(18595);
        AppMethodBeat.m2505o(18595);
    }

    /* renamed from: m */
    static /* synthetic */ void m85174m(C45913b c45913b) {
        AppMethodBeat.m2504i(18615);
        c45913b.stopScan();
        AppMethodBeat.m2505o(18615);
    }

    static {
        AppMethodBeat.m2504i(18616);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new C430191());
        AppMethodBeat.m2505o(18616);
    }

    public static synchronized C45913b aZc() {
        C45913b c45913b;
        synchronized (C45913b.class) {
            AppMethodBeat.m2504i(18596);
            if (jZG == null) {
                jZG = new C45913b();
            }
            c45913b = jZG;
            AppMethodBeat.m2505o(18596);
        }
        return c45913b;
    }

    public final C39005b aZd() {
        AppMethodBeat.m2504i(18597);
        if (this.jZE == null) {
            this.jZE = new C39005b(this.jZF);
        }
        C39005b c39005b = this.jZE;
        AppMethodBeat.m2505o(18597);
        return c39005b;
    }

    /* renamed from: f */
    public final void mo73754f(Runnable runnable) {
        AppMethodBeat.m2504i(18598);
        try {
            if (this.jZH != null) {
                this.jZH.mo10302aa(runnable);
                AppMethodBeat.m2505o(18598);
                return;
            }
            C4990ab.m7421w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", aZk());
            AppMethodBeat.m2505o(18598);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CalcWxService", e, "post error: [%s]", e.toString());
            AppMethodBeat.m2505o(18598);
        }
    }

    /* renamed from: fD */
    public final void mo73755fD(final boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(18599);
        String str = "MicroMsg.CalcWxService";
        String str2 = "%s manual scan now manualScanTask[%b] uiClick[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = aZk();
        if (this.jZM != null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        mo73754f(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18585);
                if (z) {
                    C45913b.this.jZL = true;
                }
                if (C45913b.this.jZL) {
                    if (C45913b.this.jZM == null) {
                        C18305ju c18305ju = new C18305ju();
                        if (C45913b.this.aZg()) {
                            C45913b.this.jZL = false;
                            c18305ju.cES.cco = true;
                            C4879a.xxA.mo10055m(c18305ju);
                            C7060h.pYm.mo8378a(664, 9, 1, false);
                            AppMethodBeat.m2505o(18585);
                            return;
                        }
                        if (z) {
                            C7060h.pYm.mo8378a(664, 7, 1, false);
                        }
                        c18305ju.cES.progress = C45913b.aZi();
                        c18305ju.cES.cET = C45913b.aZf();
                        c18305ju.cES.cco = false;
                        C4879a.xxA.mo10055m(c18305ju);
                        C45913b.this.jZM = new C3013c(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, C45913b.aZi(), C45913b.aZj(), C45913b.this.jZP);
                        C45913b.this.jZH.mo10302aa(C45913b.this.jZM);
                        if (((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(0))).longValue() <= 0) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(C5046bo.anT()));
                        }
                    }
                    AppMethodBeat.m2505o(18585);
                    return;
                }
                AppMethodBeat.m2505o(18585);
            }
        });
        AppMethodBeat.m2505o(18599);
    }

    public final void aZe() {
        boolean z = false;
        AppMethodBeat.m2504i(18600);
        final C5728b[] a = new C5728b(C6457e.eSn).mo11651a(new C430229());
        if (a != null && a.length > 0) {
            String str = "MicroMsg.CalcWxService";
            String str2 = "%s stop manual scan now manualScanTask[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = aZk();
            if (this.jZM != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            mo73754f(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18590);
                    if (a == null || a.length == 0) {
                        C4990ab.m7412e("MicroMsg.CalcWxService", "apkList is null or 0");
                        AppMethodBeat.m2505o(18590);
                        return;
                    }
                    int i = 0;
                    C5728b c5728b = null;
                    C5728b c5728b2 = null;
                    for (C5728b c5728b3 : a) {
                        if (c5728b3.getName().endsWith(".temp")) {
                            if (C5046bo.m7566gb(c5728b3.lastModified()) > 86400000) {
                                c5728b3.delete();
                            } else if (c5728b == null) {
                                c5728b = c5728b3;
                            } else if (c5728b3.lastModified() > c5728b.lastModified()) {
                                c5728b.delete();
                                c5728b = c5728b3;
                            } else {
                                c5728b3.delete();
                            }
                        } else if (c5728b3.getName().endsWith(".apk")) {
                            PackageInfo packageArchiveInfo = C4996ah.getContext().getPackageManager().getPackageArchiveInfo(C5736j.m8649w(c5728b3.dMD()), 128);
                            if (packageArchiveInfo != null) {
                                if (packageArchiveInfo.packageName == null || packageArchiveInfo.packageName.equals("com.tencent.mm")) {
                                    ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                                        int i2 = applicationInfo.metaData.getInt(TbsDownloader.TBS_METADATA);
                                        C4990ab.m7411d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", Integer.valueOf(i2), Integer.valueOf(C7243d.vxo));
                                        if (i2 <= C7243d.vxo) {
                                            c5728b3.delete();
                                        } else if (c5728b2 == null) {
                                            i = i2;
                                            c5728b2 = c5728b3;
                                        } else if (i2 > i) {
                                            c5728b2.delete();
                                            i = i2;
                                            c5728b2 = c5728b3;
                                        } else {
                                            c5728b3.delete();
                                        }
                                    }
                                } else {
                                    c5728b3.delete();
                                }
                            }
                            if (i != 0) {
                                c5728b3.delete();
                            } else if (c5728b2 == null) {
                                c5728b2 = c5728b3;
                            } else if (c5728b3.lastModified() > c5728b2.lastModified()) {
                                c5728b2.delete();
                                c5728b2 = c5728b3;
                            } else {
                                c5728b3.delete();
                            }
                        }
                    }
                    AppMethodBeat.m2505o(18590);
                }
            });
        }
        AppMethodBeat.m2505o(18600);
    }

    private void stopScan() {
        AppMethodBeat.m2504i(18601);
        mo73754f(new C3409112());
        AppMethodBeat.m2505o(18601);
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(18602);
        C4990ab.m7417i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", aZk());
        if (this.jZH == null) {
            C4990ab.m7417i("MicroMsg.CalcWxService", "%s init calc wx thread", aZk());
            this.jZH = new C5004al("calc-wx");
        }
        this.jZF = C1952t.m4171a(hashCode(), C1720g.m3536RP().cachePath + "WxFileIndex.db", jZD, true);
        this.jZO.put(Integer.valueOf(43), new C27910e());
        this.jZO.put(Integer.valueOf(62), new C27910e());
        this.jZO.put(Integer.valueOf(44), new C27910e());
        this.jZO.put(Integer.valueOf(34), new C27911f());
        this.jZO.put(Integer.valueOf(3), new C39003d());
        this.jZO.put(Integer.valueOf(49), new C46909c());
        this.jZO.put(Integer.valueOf(268435505), new C39002b());
        C45913b.aZf();
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15287a(this.jKo, null);
        C4879a.xxA.mo10051b(this.jZR);
        Context context = C4996ah.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z = intExtra == 2 || intExtra == 5;
            this.jZS = z;
        } else {
            this.jZS = false;
        }
        this.jZT = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.jZU = new C206124();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.jZU, intentFilter);
        C4879a.xxA.mo10051b(this.jZX);
        if (this.jZW) {
            C4879a.xxA.mo10055m(new C45310bp());
        }
        AppMethodBeat.m2505o(18602);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(18603);
        C4990ab.m7416i("MicroMsg.CalcWxService", "CalcWxService Release");
        this.jZJ.clear();
        this.jZK = false;
        if (this.jZF != null) {
            this.jZF.mo5709mJ(hashCode());
            this.jZF = null;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15286a(this.jKo);
        C4879a.xxA.mo10053d(this.jZR);
        this.jZO.clear();
        if (this.jZU != null) {
            C4996ah.getContext().unregisterReceiver(this.jZU);
            this.jZU = null;
        }
        if (this.jZV != null) {
            C9638aw.m17180RS();
            C5004al.m7439af(this.jZV);
            this.jZV = null;
        }
        stopScan();
        if (this.jZH != null) {
            C4990ab.m7417i("MicroMsg.CalcWxService", "%s quit calc wx thread", aZk());
            this.jZH.oAl.quit();
        }
        this.jZH = null;
        C4879a.xxA.mo10053d(this.jZX);
        AppMethodBeat.m2505o(18603);
    }

    public static long aZf() {
        AppMethodBeat.m2504i(18604);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, Long.valueOf(-1))).longValue();
        if (longValue <= -1) {
            longValue = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15271Ry(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, Long.valueOf(longValue));
        }
        AppMethodBeat.m2505o(18604);
        return longValue;
    }

    public final boolean aZg() {
        AppMethodBeat.m2504i(18605);
        boolean z = C45913b.aZi() >= C45913b.aZf();
        C4990ab.m7417i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", Integer.valueOf(hashCode()), Long.valueOf(C45913b.aZf()), Long.valueOf(C45913b.aZi()), Boolean.valueOf(z));
        if (z && ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, Long.valueOf(0))).longValue() <= 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, Long.valueOf(C5046bo.anT()));
        }
        AppMethodBeat.m2505o(18605);
        return z;
    }

    public final void aZh() {
        AppMethodBeat.m2504i(18606);
        this.jZK = false;
        this.jZJ.clear();
        C4990ab.m7411d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", Integer.valueOf(hashCode()), C5046bo.dpG());
        AppMethodBeat.m2505o(18606);
    }

    /* renamed from: O */
    public final void mo73748O(C7620bi c7620bi) {
        AppMethodBeat.m2504i(18607);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(18607);
            return;
        }
        try {
            C45911a c45911a = (C45911a) this.jZO.get(Integer.valueOf(c7620bi.getType()));
            if (c45911a != null) {
                c45911a.mo73747P(c7620bi);
            }
            AppMethodBeat.m2505o(18607);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
            C7060h.pYm.mo8378a(664, 5, 1, false);
            AppMethodBeat.m2505o(18607);
        }
    }

    /* renamed from: C */
    public static void m85153C(int i, long j) {
        int i2;
        int i3 = 30;
        AppMethodBeat.m2504i(18608);
        if (j <= 1000) {
            i2 = i + 5;
        } else {
            i2 = i - 5;
        }
        if (i2 <= 30) {
            i3 = i2;
        }
        if (i3 < 5) {
            i3 = 5;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_STEP_INT, Integer.valueOf(i3));
        C7060h.pYm.mo8378a(664, (long) ((Integer) C7060h.m11789a(i3, new int[]{5, 10, 20, 25, 30}, 10, 15)).intValue(), 1, false);
        AppMethodBeat.m2505o(18608);
    }

    /* renamed from: gS */
    public final void mo73756gS(long j) {
        AppMethodBeat.m2504i(18609);
        C4990ab.m7411d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", Integer.valueOf(hashCode()), Long.valueOf(j));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, Long.valueOf(j));
        AppMethodBeat.m2505o(18609);
    }

    public static long aZi() {
        AppMethodBeat.m2504i(18610);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, Long.valueOf(0))).longValue();
        AppMethodBeat.m2505o(18610);
        return longValue;
    }

    public static int aZj() {
        AppMethodBeat.m2504i(18611);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_STEP_INT, Integer.valueOf(5))).intValue();
        AppMethodBeat.m2505o(18611);
        return intValue;
    }

    public final String aZk() {
        AppMethodBeat.m2504i(18612);
        String str = hashCode();
        AppMethodBeat.m2505o(18612);
        return str;
    }

    /* renamed from: e */
    static /* synthetic */ boolean m85166e(C45913b c45913b) {
        return (c45913b.jZL || !c45913b.jZS || c45913b.jZT) ? false : true;
    }

    /* renamed from: i */
    static /* synthetic */ void m85170i(C45913b c45913b) {
        AppMethodBeat.m2504i(18614);
        c45913b.mo73754f(new C2061111());
        AppMethodBeat.m2505o(18614);
    }
}
