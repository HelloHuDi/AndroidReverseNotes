package com.tencent.p177mm.modelstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.accessibility.AccessibilityCapture;
import com.tencent.p177mm.accessibility.AccessibilityCapture.APIProvider;
import com.tencent.p177mm.accessibility.AccessibilityCapture.Event;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C4894a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C40618o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.modelstat.c */
public class C37957c implements APIProvider {
    private static C37957c fRx;
    private ArrayList<C37956b> fRA = new ArrayList();
    private String fRB = null;
    private long fRC = 0;
    private ArrayList<C32834c> fRD = new ArrayList();
    private boolean fRE = false;
    private Map<String, Boolean> fRF = new HashMap();
    private long fRG = 0;
    private long fRH = 0;
    private List<C32835d> fRI = new ArrayList();
    private C7564ap fRy = null;
    private final int fRz = 20971520;
    private C7306ak handler = null;

    /* renamed from: com.tencent.mm.modelstat.c$a */
    static class C26482a {
        Map<String, Boolean> fRF = new HashMap();
        long fRG;
        long fRH;
        List<C32834c> fRP = new ArrayList();

        /* renamed from: com.tencent.mm.modelstat.c$a$a */
        static class C26481a extends Exception {
            C26481a(String str) {
                super(str);
            }

            C26481a(Throwable th) {
                super(th);
            }
        }

        private C26482a() {
            AppMethodBeat.m2504i(78663);
            AppMethodBeat.m2505o(78663);
        }

        public final String toString() {
            AppMethodBeat.m2504i(78664);
            String str = "Config{nextUpdateInterval=" + this.fRG + ", samplePeriod=" + this.fRH + ", eventList=" + this.fRP + '}';
            AppMethodBeat.m2505o(78664);
            return str;
        }

        /* renamed from: tH */
        static C26482a m42194tH(String str) {
            AppMethodBeat.m2504i(78665);
            C26482a c26482a = new C26482a();
            try {
                Map z = C5049br.m7595z(str, "eventSampleConf");
                if (z == null) {
                    C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", str);
                    C26481a c26481a = new C26481a("reportConfigMap is null");
                    AppMethodBeat.m2505o(78665);
                    throw c26481a;
                }
                c26482a.fRG = C5046bo.getLong((String) z.get(".eventSampleConf.nextUpdateInterval"), 0);
                if (c26482a.fRG <= 0 || c26482a.fRG > 432000) {
                    c26482a.fRG = 432000;
                }
                c26482a.fRH = C5046bo.getLong((String) z.get(".eventSampleConf.samplePeriod"), 0);
                int i = 0;
                while (true) {
                    C32834c c32834c = new C32834c();
                    String str2 = ".eventSampleConf.events.event" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                    int i2 = i + 1;
                    c32834c.f15022id = C5046bo.getInt((String) z.get(str2 + "id"), 0);
                    if (c32834c.f15022id > 0) {
                        String str3;
                        int i3;
                        String str4;
                        c32834c.fRS = C5046bo.getLong((String) z.get(str2 + "expireTime"), 0);
                        c32834c.name = (String) z.get(str2 + "name");
                        c32834c.fRT = C5046bo.getFloat((String) z.get(str2 + "rate"), 0.0f);
                        c32834c.eBH = C5046bo.getInt((String) z.get(str2 + "logId"), 0);
                        c32834c.fRU = (String) z.get(str2 + "pages.$type");
                        ArrayList arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "pages.page" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                            i3 = i + 1;
                            str4 = (String) z.get(str3 + "$id");
                            if (str4 == null) {
                                break;
                            }
                            boolean equals = ((String) z.get(str3 + "$action")).equals("true");
                            arrayList.add(new Pair(str4, Boolean.valueOf(equals)));
                            c26482a.fRF.put(str4, Boolean.valueOf(equals));
                            i = i3;
                        }
                        c32834c.fRV = arrayList;
                        arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "specialPVPages.pageItem" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                            i3 = i + 1;
                            str4 = (String) z.get(str3 + "$prePage");
                            if (str4 == null) {
                                break;
                            }
                            arrayList.add(new Pair(str4, (String) z.get(str3 + "$page")));
                            i = i3;
                        }
                        c32834c.fRW = arrayList;
                        c26482a.fRP.add(c32834c);
                        C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", c32834c);
                        i = i2;
                    } else {
                        C4990ab.m7419v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", c26482a);
                        AppMethodBeat.m2505o(78665);
                        return c26482a;
                    }
                }
            } catch (Exception e) {
                C26481a c26481a2 = new C26481a(e);
                AppMethodBeat.m2505o(78665);
                throw c26481a2;
            }
        }
    }

    /* renamed from: com.tencent.mm.modelstat.c$c */
    static class C32834c {
        int eBH;
        long fRS;
        float fRT;
        String fRU;
        ArrayList<Pair<String, Boolean>> fRV;
        ArrayList<Pair<String, String>> fRW;
        /* renamed from: id */
        int f15022id;
        String name;

        private C32834c() {
            AppMethodBeat.m2504i(78667);
            this.fRV = new ArrayList();
            this.fRW = new ArrayList();
            AppMethodBeat.m2505o(78667);
        }

        /* synthetic */ C32834c(byte b) {
            this();
        }

        public final String toString() {
            Pair pair;
            AppMethodBeat.m2504i(78668);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ReportConfigEvent{");
            stringBuilder.append("id=" + this.f15022id);
            stringBuilder.append(", name='" + this.name + "'");
            stringBuilder.append(", expireTime=" + this.fRS);
            stringBuilder.append(", rate=" + this.fRT);
            stringBuilder.append(", logId=" + this.eBH);
            stringBuilder.append(", pagesType='" + this.fRU + "'");
            stringBuilder.append(", pageList=[");
            Iterator it = this.fRV.iterator();
            while (it.hasNext()) {
                pair = (Pair) it.next();
                stringBuilder.append("{" + ((String) pair.first) + "," + pair.second + "}");
                stringBuilder.append(",");
            }
            stringBuilder.append("]");
            stringBuilder.append(", specialPVPages=[");
            it = this.fRW.iterator();
            while (it.hasNext()) {
                pair = (Pair) it.next();
                stringBuilder.append("{" + ((String) pair.first) + "," + ((String) pair.second) + "}");
                stringBuilder.append(",");
            }
            stringBuilder.append("]}");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(78668);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.c$d */
    static class C32835d implements Serializable, Comparable<C32835d> {
        String fRX = null;
        int left;
        long time = 0;
        int top;
        int type = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((C32835d) obj).time);
        }

        C32835d() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(78669);
            String format = String.format(Locale.getDefault(), "[%s,%s]", new Object[]{this.fRX, C37957c.m64210fR(this.time)});
            AppMethodBeat.m2505o(78669);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.c$b */
    static class C37956b implements Serializable, Comparable<C37956b> {
        int czE = 0;
        long elapsedTime = 0;
        List<C32835d> fRI = null;
        String fRQ = null;
        long fRR;
        long time = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((C37956b) obj).time);
        }

        C37956b() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(78666);
            String format = String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[]{this.fRQ, Integer.valueOf(this.czE), C37957c.m64210fR(this.time)});
            AppMethodBeat.m2505o(78666);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.c$1 */
    class C379581 implements C5015a {

        /* renamed from: com.tencent.mm.modelstat.c$1$1 */
        class C186821 implements Runnable {
            C186821() {
            }

            public final void run() {
                AppMethodBeat.m2504i(78657);
                C37957c.m64195a(C37957c.this);
                AppMethodBeat.m2505o(78657);
            }
        }

        C379581() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78658);
            C4990ab.m7411d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", Boolean.valueOf(C40618o.m70062gl(C4996ah.getContext())), Boolean.valueOf(!C5046bo.isNullOrNil(C37957c.m64206cd(C4996ah.getContext()))), C37957c.m64206cd(C4996ah.getContext()));
            if (C40618o.m70062gl(C4996ah.getContext()) && r0) {
                AppMethodBeat.m2505o(78658);
                return true;
            }
            C37957c.this.handler.post(new C186821());
            AppMethodBeat.m2505o(78658);
            return false;
        }
    }

    /* renamed from: cd */
    static /* synthetic */ String m64206cd(Context context) {
        AppMethodBeat.m2504i(78697);
        String cc = C37957c.m64205cc(context);
        AppMethodBeat.m2505o(78697);
        return cc;
    }

    /* renamed from: fR */
    static /* synthetic */ String m64210fR(long j) {
        AppMethodBeat.m2504i(78701);
        String fQ = C37957c.m64209fQ(j);
        AppMethodBeat.m2505o(78701);
        return fQ;
    }

    public static C37957c akc() {
        AppMethodBeat.m2504i(78670);
        if (fRx == null) {
            synchronized (C37957c.class) {
                try {
                    if (fRx == null) {
                        fRx = new C37957c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78670);
                    }
                }
            }
        }
        C37957c c37957c = fRx;
        AppMethodBeat.m2505o(78670);
        return c37957c;
    }

    public void onEvent(Event event) {
        AppMethodBeat.m2504i(78671);
        if (event == null || event.view == null || event.activity == null) {
            AppMethodBeat.m2505o(78671);
        } else if (event.activity.getComponentName() == null) {
            AppMethodBeat.m2505o(78671);
        } else {
            Object shortClassName = event.activity.getComponentName().getShortClassName();
            if (shortClassName.contains(".")) {
                shortClassName = shortClassName.substring(shortClassName.lastIndexOf(".") + 1);
            }
            if (this.fRE || this.fRF.containsKey(shortClassName)) {
                C32835d c32835d = new C32835d();
                long currentTimeMillis = System.currentTimeMillis();
                c32835d.fRX = Integer.toHexString(event.view.getId());
                c32835d.type = event.event.getEventType();
                c32835d.time = event.elapsedTime;
                this.fRI.add(c32835d);
                int[] iArr = new int[2];
                event.view.getLocationOnScreen(iArr);
                c32835d.left = iArr[0];
                c32835d.top = iArr[1];
                C4990ab.m7410d("MicroMsg.ClickFlowStatReceiver", "[oneliang]id:" + c32835d.fRX + ",ui:" + event.activity.getComponentName().getShortClassName() + ",left:" + c32835d.left + ",top:" + c32835d.top + ",time:" + c32835d.time + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(78671);
                return;
            }
            AppMethodBeat.m2505o(78671);
        }
    }

    /* renamed from: v */
    public void mo20327v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(78672);
        C4990ab.m7419v("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.m2505o(78672);
    }

    /* renamed from: d */
    public void mo20321d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(78673);
        C4990ab.m7411d("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.m2505o(78673);
    }

    /* renamed from: i */
    public void mo20323i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(78674);
        C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.m2505o(78674);
    }

    /* renamed from: e */
    public void mo20322e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(78675);
        C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.m2505o(78675);
    }

    public void post(Runnable runnable, String str) {
        AppMethodBeat.m2504i(78676);
        if (this.handler != null) {
            this.handler.post(runnable);
        }
        AppMethodBeat.m2505o(78676);
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(78677);
        C4990ab.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", th, str2, objArr);
        AppMethodBeat.m2505o(78677);
    }

    private C37957c() {
        AppMethodBeat.m2504i(78678);
        if (C4872b.dnO()) {
            Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", C4996ah.bqo());
        }
        HandlerThread anM = C7305d.anM("ClickFlow");
        anM.start();
        this.handler = new C7306ak(anM.getLooper());
        this.fRy = new C7564ap(anM.getLooper(), new C379581(), true);
        AppMethodBeat.m2505o(78678);
    }

    public final void commitNow() {
        AppMethodBeat.m2504i(78679);
        long anU = C5046bo.anU();
        C4990ab.m7421w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", (Boolean) new C5039bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(78659);
                C37957c.m64195a(C37957c.this);
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.m2505o(78659);
                return bool;
            }
        }.mo10372b(this.handler), Long.valueOf(C5046bo.m7566gb(anU)));
        AppMethodBeat.m2505o(78679);
    }

    /* renamed from: v */
    public final void mo60731v(final Intent intent) {
        AppMethodBeat.m2504i(78680);
        if (intent == null || !intent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")) {
            AppMethodBeat.m2505o(78680);
            return;
        }
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78660);
                String stringExtra = intent.getStringExtra("ui");
                int intExtra = intent.getIntExtra("uiHashCode", 0);
                int intExtra2 = intent.getIntExtra("opCode", 0);
                C4990ab.m7411d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d, elapsed time:%d", Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Long.valueOf(C5046bo.m7566gb(intent.getLongExtra("nowMilliSecond", 0))), Long.valueOf(intent.getLongExtra("elapsedRealtime", 0)));
                if (2147483632 == intExtra2) {
                    C37957c.m64195a(C37957c.this);
                    AppMethodBeat.m2505o(78660);
                    return;
                }
                C37957c.m64196a(C37957c.this, intExtra2, stringExtra, intExtra, r4, r6);
                AppMethodBeat.m2505o(78660);
            }
        });
        AppMethodBeat.m2505o(78680);
    }

    /* renamed from: fP */
    private static boolean m64208fP(long j) {
        return j == 0;
    }

    /* renamed from: h */
    private Pair<Integer, ArrayList<C37956b>> m64211h(ArrayList<C37956b> arrayList) {
        AppMethodBeat.m2504i(78681);
        ArrayList arrayList2 = new ArrayList();
        long anU = C5046bo.anU();
        try {
            C37956b c37956b;
            ArrayList arrayList3 = new ArrayList();
            long j = 0;
            int i = 0;
            while (i < arrayList.size()) {
                c37956b = (C37956b) arrayList.get(i);
                if (c37956b.time < 0 || c37956b.time > anU || anU - c37956b.time > 50400000) {
                    C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", Long.valueOf(c37956b.time), Long.valueOf(anU - c37956b.time), Integer.valueOf(c37956b.czE), c37956b.fRQ);
                    AppMethodBeat.m2505o(78681);
                    return null;
                }
                long j2;
                if (c37956b.czE == 4) {
                    if (j < c37956b.time) {
                        j2 = c37956b.time;
                    }
                    j2 = j;
                } else if (c37956b.czE != 3) {
                    C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", Integer.valueOf(c37956b.czE), c37956b.fRQ);
                    AppMethodBeat.m2505o(78681);
                    return null;
                } else {
                    arrayList3.add(c37956b);
                    j2 = j;
                }
                i++;
                j = j2;
            }
            if (arrayList3.size() == 0) {
                AppMethodBeat.m2505o(78681);
                return null;
            }
            Collections.sort(arrayList3);
            Collections.sort(this.fRI);
            c37956b = new C37956b();
            Iterator it = arrayList3.iterator();
            C37956b c37956b2 = c37956b;
            while (it.hasNext()) {
                c37956b = (C37956b) it.next();
                if (!c37956b.fRQ.equals(c37956b2.fRQ)) {
                    m64194a(c37956b2, c37956b.elapsedTime);
                    arrayList2.add(c37956b);
                    c37956b2.fRR = c37956b.time;
                    c37956b2 = c37956b;
                } else if (c37956b.time - c37956b2.time > 10800000) {
                    C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", Long.valueOf(c37956b.time), Long.valueOf(c37956b2.time));
                    c37956b2.time = c37956b.time;
                }
            }
            if (!arrayList2.isEmpty()) {
                m64194a((C37956b) arrayList2.get(arrayList2.size() - 1), j);
            }
            c37956b2.fRR = ((C37956b) arrayList.get(arrayList.size() - 1)).time;
            if (((C37956b) arrayList2.get(arrayList2.size() - 1)).time > j) {
                ((C37956b) arrayList2.get(arrayList2.size() - 1)).fRR = anU;
            } else if (j > anU) {
                ((C37956b) arrayList2.get(arrayList2.size() - 1)).fRR = anU;
            }
            if (((C37956b) arrayList2.get(arrayList2.size() - 1)).fRR - ((C37956b) arrayList2.get(0)).time > 50400000) {
                C4990ab.m7412e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
                AppMethodBeat.m2505o(78681);
                return null;
            }
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", Integer.valueOf(0), Integer.valueOf(arrayList2.size()), Long.valueOf(C5046bo.m7566gb(anU)));
            Pair<Integer, ArrayList<C37956b>> create = Pair.create(Integer.valueOf(0), arrayList2);
            AppMethodBeat.m2505o(78681);
            return create;
        } catch (Exception e) {
            C37957c.m64213x(15008, C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(78681);
            return null;
        }
    }

    /* renamed from: a */
    private void m64194a(C37956b c37956b, long j) {
        AppMethodBeat.m2504i(78682);
        if (c37956b.elapsedTime <= 0) {
            AppMethodBeat.m2505o(78682);
            return;
        }
        int i;
        long j2 = c37956b.elapsedTime;
        if (this.fRI.isEmpty()) {
            i = 0;
        } else {
            i = this.fRI.size() - 1;
        }
        i = m64207d(j2, 0, i);
        if (i != -1) {
            if (c37956b.fRI == null) {
                c37956b.fRI = new ArrayList();
            }
            int size = this.fRI.size();
            for (int i2 = i; i2 < size; i2++) {
                C32835d c32835d = (C32835d) this.fRI.get(i2);
                if (c32835d.time > c37956b.elapsedTime && c32835d.time <= j) {
                    c37956b.fRI.add(c32835d);
                }
                if (c32835d.time >= j) {
                    break;
                }
            }
        }
        AppMethodBeat.m2505o(78682);
    }

    /* renamed from: d */
    private int m64207d(long j, int i, int i2) {
        AppMethodBeat.m2504i(78683);
        if (this.fRI == null || this.fRI.isEmpty()) {
            AppMethodBeat.m2505o(78683);
            return -1;
        }
        int i3 = (i + i2) / 2;
        if (i2 - i != 0 && i2 - i != 1) {
            i2 = j < ((C32835d) this.fRI.get(i3)).time ? m64207d(j, i, i3) : j > ((C32835d) this.fRI.get(i3)).time ? m64207d(j, i3, i2) : i3;
        } else if (j < ((C32835d) this.fRI.get(i2)).time) {
            i2 = i;
        }
        AppMethodBeat.m2505o(78683);
        return i2;
    }

    /* renamed from: x */
    private static void m64213x(int i, String str) {
        AppMethodBeat.m2504i(78684);
        C7053e.pXa.mo8374X(13328, i + ",0,0,0,0,0,0,0,0,0,0,0,0," + str);
        AppMethodBeat.m2505o(78684);
    }

    /* renamed from: a */
    private void m64193a(C26482a c26482a) {
        AppMethodBeat.m2504i(78685);
        this.fRG = c26482a.fRG;
        if (this.fRG <= 0 || this.fRG > 432000) {
            this.fRG = 432000;
        }
        this.fRH = c26482a.fRH;
        this.fRD.clear();
        this.fRD.addAll(c26482a.fRP);
        this.fRF.clear();
        this.fRF.putAll(c26482a.fRF);
        if (this.fRF.containsKey("*") && ((Boolean) this.fRF.get("*")).booleanValue()) {
            this.fRE = true;
        }
        C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", Integer.valueOf(this.fRD.size()), Long.valueOf(this.fRG), Long.valueOf(this.fRH));
        AppMethodBeat.m2505o(78685);
    }

    /* renamed from: a */
    private static boolean m64201a(long j, float f, long j2) {
        AppMethodBeat.m2504i(78686);
        if (C4872b.dnO()) {
            AppMethodBeat.m2505o(78686);
            return true;
        } else if (f <= 0.0f) {
            AppMethodBeat.m2505o(78686);
            return false;
        } else {
            long j3;
            int i = Downloads.MIN_WAIT_FOR_NETWORK / ((int) (10000.0f * f));
            int i2 = (int) j;
            i2 = (i2 ^ (i2 >> 16)) * 73244475;
            i2 = (i2 ^ (i2 >> 16)) * 73244475;
            int i3 = ((i2 >> 16) ^ i2) % i;
            long anT = C5046bo.anT();
            if (j2 == 0) {
                j3 = 259200;
            } else {
                j3 = j2;
            }
            C4990ab.m7419v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", Boolean.valueOf(i3 == ((int) ((anT / j3) % ((long) i)))), Long.valueOf(j), Float.valueOf(f), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(r3), Integer.valueOf(i3), Integer.valueOf((int) ((anT / j3) % ((long) i))));
            AppMethodBeat.m2505o(78686);
            return i3 == ((int) ((anT / j3) % ((long) i)));
        }
    }

    /* renamed from: a */
    private static void m64200a(List<C37956b> list, C32834c c32834c, SparseArray<String> sparseArray) {
        int i = 0;
        AppMethodBeat.m2504i(78687);
        String str = c32834c.fRU;
        int i2 = -1;
        switch (str.hashCode()) {
            case -929554094:
                if (str.equals("respective")) {
                    i2 = 1;
                    break;
                }
                break;
            case 3117816:
                if (str.equals("ends")) {
                    i2 = 2;
                    break;
                }
                break;
            case 3433103:
                if (str.equals("page")) {
                    i2 = 0;
                    break;
                }
                break;
            case 379114255:
                if (str.equals("continuous")) {
                    i2 = 3;
                    break;
                }
                break;
        }
        int i3;
        int i4;
        switch (i2) {
            case 0:
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", c32834c);
                sparseArray.put(c32834c.eBH, C5046bo.nullAsNil((String) sparseArray.get(c32834c.eBH)) + c32834c.f15022id + ";");
                AppMethodBeat.m2505o(78687);
                return;
            case 1:
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", c32834c);
                for (i2 = 0; i2 < list.size(); i2 = i3 + 1) {
                    i4 = 0;
                    i3 = i2;
                    while (i4 < c32834c.fRV.size()) {
                        int size;
                        if (((String) ((Pair) c32834c.fRV.get(i4)).first).equals(((C37956b) list.get(i3)).fRQ)) {
                            sparseArray.put(c32834c.eBH, C5046bo.nullAsNil((String) sparseArray.get(c32834c.eBH)) + c32834c.f15022id + ";");
                            i4 = c32834c.fRV.size();
                            size = list.size();
                        } else {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                }
                AppMethodBeat.m2505o(78687);
                return;
            case 2:
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", c32834c);
                if (list.size() >= 2) {
                    if ((c32834c.fRV.size() == 2 ? 1 : 0) == 0) {
                        C4990ab.m7412e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + c32834c.fRV.toString());
                        AppMethodBeat.m2505o(78687);
                        return;
                    }
                    String str2 = (String) ((Pair) c32834c.fRV.get(1)).first;
                    if (((C37956b) list.get(0)).fRQ.equals((String) ((Pair) c32834c.fRV.get(0)).first) && ((C37956b) list.get(list.size() - 1)).fRQ.equals(str2)) {
                        sparseArray.put(c32834c.eBH, C5046bo.nullAsNil((String) sparseArray.get(c32834c.eBH)) + c32834c.f15022id + ";");
                        AppMethodBeat.m2505o(78687);
                        return;
                    }
                }
                break;
            case 3:
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", c32834c);
                ArrayList arrayList = c32834c.fRV;
                if (arrayList.size() > 0) {
                    for (i2 = arrayList.size() - 1; i2 < list.size(); i2 = (arrayList.size() - i4) + i3) {
                        i4 = arrayList.size() - 1;
                        i3 = i2;
                        while (((String) ((Pair) arrayList.get(i4)).first).equals(((C37956b) list.get(i3)).fRQ)) {
                            if (i4 == 0) {
                                i = 1;
                            } else {
                                i4--;
                                i3--;
                            }
                        }
                    }
                }
                if (i != 0) {
                    sparseArray.put(c32834c.eBH, C5046bo.nullAsNil((String) sparseArray.get(c32834c.eBH)) + c32834c.f15022id + ";");
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(78687);
    }

    /* renamed from: a */
    private void m64191a(long j, ArrayList<C37956b> arrayList, C4894a c4894a) {
        C32834c c32834c;
        AppMethodBeat.m2504i(78688);
        long j2 = ((C37956b) arrayList.get(0)).time;
        long j3 = ((C37956b) arrayList.get(arrayList.size() - 1)).fRR;
        long anT = C5046bo.anT();
        int i = 0;
        while (i < this.fRD.size()) {
            try {
                if ("app".equals(((C32834c) this.fRD.get(i)).fRU)) {
                    c32834c = (C32834c) this.fRD.get(i);
                    break;
                }
                i++;
            } catch (Exception e) {
                C37957c.m64213x(15004, C5046bo.m7574l(e));
                C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(78688);
                return;
            }
        }
        c32834c = null;
        if (c32834c == null) {
            C4990ab.m7416i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
            if (C37957c.m64208fP(j)) {
                C37957c.m64198a(c4894a, 13604, 100001, j2, j3);
                AppMethodBeat.m2505o(78688);
                return;
            }
            C4990ab.m7416i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
            AppMethodBeat.m2505o(78688);
        } else if (c32834c.fRS <= anT || !C37957c.m64201a(j, c32834c.fRT, this.fRH)) {
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", c32834c, Long.valueOf(anT));
            AppMethodBeat.m2505o(78688);
        } else {
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", c32834c, Long.valueOf(anT));
            C37957c.m64198a(c4894a, c32834c.eBH, c32834c.f15022id, j2, j3);
            AppMethodBeat.m2505o(78688);
        }
    }

    /* renamed from: a */
    private static void m64198a(C4894a c4894a, int i, int i2, long j, long j2) {
        AppMethodBeat.m2504i(78689);
        long anU = C5046bo.anU();
        if (j > j2 || j < 0 || j2 < 0 || j > anU || j2 > anU) {
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(anU));
            AppMethodBeat.m2505o(78689);
            return;
        }
        int h = C5046bo.m7567h(c4894a.anE("SEQ_".concat(String.valueOf(i))));
        c4894a.mo10095ej("SEQ_".concat(String.valueOf(i)), h + 1);
        anU = C5046bo.m7534c(c4894a.anD("LastQuit_".concat(String.valueOf(i2))));
        c4894a.mo10092aK("LastQuit_".concat(String.valueOf(i2)), j2);
        if (anU <= 0 || anU > j) {
            anU = j;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", 1).put("tbe", j / 1000).put("ten", j2 / 1000).put("in", (j2 - j) / 1000).put("lten", anU / 1000).put("inbg", (j - anU) / 1000);
        C37957c.m64203b(i, String.valueOf(i2), h, jSONObject.toString());
        AppMethodBeat.m2505o(78689);
    }

    /* renamed from: a */
    private void m64192a(long j, ArrayList<C37956b> arrayList, C4894a c4894a, int i) {
        AppMethodBeat.m2504i(78690);
        try {
            int h;
            int i2;
            long anU = C5046bo.anU();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                C37956b c37956b = (C37956b) arrayList.get(i3);
                if (c37956b.fRR < c37956b.time || c37956b.time < 0 || c37956b.fRR < 0 || c37956b.fRR > anU || c37956b.time > anU) {
                    C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", Long.valueOf(c37956b.time), Long.valueOf(c37956b.fRR), Long.valueOf(anU));
                    AppMethodBeat.m2505o(78690);
                    return;
                }
                jSONObject.put("p", c37956b.fRQ).put("tbe", c37956b.time / 1000).put("in", (c37956b.fRR - c37956b.time) / 1000);
                if (!(c37956b.fRI == null || c37956b.fRI.isEmpty())) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < c37956b.fRI.size(); i4++) {
                        C32835d c32835d = (C32835d) c37956b.fRI.get(i4);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("w", c32835d.fRX).put("t", c32835d.type).put("tbp", "{" + c32835d.left + ";" + c32835d.top + "}");
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("wf", jSONArray2);
                }
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", 2).put("errt", i).put("pf", jSONArray);
            if (C37957c.m64208fP(j)) {
                h = C5046bo.m7567h(c4894a.anE("SEQ_13604"));
                c4894a.mo10095ej("SEQ_13604", h + 1);
                C37957c.m64203b(13604, "100002", h, jSONObject3.toString());
            }
            SparseArray sparseArray = new SparseArray();
            if (this.fRD.size() == 0) {
                C4990ab.m7416i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
            }
            for (i2 = 0; i2 < this.fRD.size(); i2++) {
                C32834c c32834c = (C32834c) this.fRD.get(i2);
                if (c32834c.fRS > C5046bo.anT()) {
                    if (C37957c.m64201a(j, c32834c.fRT, this.fRH)) {
                        C37957c.m64200a((List) arrayList, c32834c, sparseArray);
                    }
                }
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", c32834c, Long.valueOf(C5046bo.anT()));
            }
            h = 0;
            while (true) {
                i2 = h;
                if (i2 < sparseArray.size()) {
                    int keyAt = sparseArray.keyAt(i2);
                    String str = (String) sparseArray.get(keyAt);
                    int h2 = C5046bo.m7567h(c4894a.anE("SEQ_".concat(String.valueOf(keyAt))));
                    c4894a.mo10095ej("SEQ_".concat(String.valueOf(keyAt)), h2 + 1);
                    C37957c.m64203b(keyAt, str, h2, jSONObject3.toString());
                    h = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(78690);
                    return;
                }
            }
        } catch (Exception e) {
            C37957c.m64213x(15005, C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(78690);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:183:0x07c7 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x05a0 A:{Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x07b6 A:{Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x05c2 A:{Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x05a0 A:{Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x07c7 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x05c2 A:{Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x07b6 A:{Catch:{ Exception -> 0x06c3, OutOfMemoryError -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0149 A:{Splitter:B:57:0x025c, ExcHandler: OutOfMemoryError (r4_141 'e' java.lang.OutOfMemoryError)} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0149 A:{Splitter:B:57:0x025c, ExcHandler: OutOfMemoryError (r4_141 'e' java.lang.OutOfMemoryError)} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0149 A:{Splitter:B:57:0x025c, ExcHandler: OutOfMemoryError (r4_141 'e' java.lang.OutOfMemoryError)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:33:0x0149, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:34:0x014a, code skipped:
            com.tencent.p177mm.p178a.C1173e.deleteFile(r17);
            java.lang.System.gc();
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", r4, "OutOfMemoryError", new java.lang.Object[0]);
            com.tencent.p177mm.modelstat.C37957c.m64213x(15010, com.tencent.p177mm.sdk.platformtools.C5046bo.m7574l(r4));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(78691);
     */
    /* JADX WARNING: Missing block: B:139:0x0705, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:142:?, code skipped:
            com.tencent.p177mm.modelstat.C37957c.m64213x(15006, com.tencent.p177mm.sdk.platformtools.C5046bo.m7574l(r4));
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", com.tencent.p177mm.sdk.platformtools.C5046bo.m7574l(r4));
     */
    /* JADX WARNING: Missing block: B:190:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m64204b(long j, ArrayList<C37956b> arrayList, C4894a c4894a) {
        AppMethodBeat.m2504i(78691);
        long anU = C5046bo.anU();
        long j2 = ((C37956b) arrayList.get(arrayList.size() - 1)).fRR;
        if (j2 <= 0 || j2 > anU) {
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", Long.valueOf(j2), Long.valueOf(anU));
            AppMethodBeat.m2505o(78691);
            return;
        }
        long anT = C5046bo.anT();
        String str = this.fRB + "stg_20971520_" + j + ".HashMap";
        try {
            HashMap tG = C37957c.m64212tG(str);
            tG.put(Long.valueOf(j2), arrayList);
            Iterator it = tG.entrySet().iterator();
            while (it.hasNext()) {
                if (((Long) ((Entry) it.next()).getKey()).longValue() + 259200000 < j2) {
                    it.remove();
                }
            }
            m64199a(str, tG);
            long j3 = C4872b.dnO() ? 180000 : 3600000;
            long a = C5046bo.m7514a(c4894a.anD("LAST_REPORT_STATISITIC_TIME"), 0);
            if (a + j3 > j2) {
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", Long.valueOf(a), Long.valueOf(j2), Long.valueOf(j3));
                AppMethodBeat.m2505o(78691);
                return;
            }
            int i;
            C32834c c32834c;
            c4894a.mo10092aK("LAST_REPORT_STATISITIC_TIME", j2);
            HashMap hashMap = new HashMap();
            for (Long l : tG.keySet()) {
                if (l.longValue() > a) {
                    hashMap.put(l, tG.get(l));
                }
            }
            a = 0;
            long j4 = Long.MAX_VALUE;
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            HashMap hashMap6 = new HashMap();
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.fRD.size()) {
                    c32834c = null;
                    break;
                } else if ("pagestat".equals(((C32834c) this.fRD.get(i)).fRU)) {
                    c32834c = (C32834c) this.fRD.get(i);
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", Integer.valueOf(hashMap.size()));
            for (Long l2 : hashMap.keySet()) {
                long longValue;
                if (j4 > l2.longValue()) {
                    longValue = l2.longValue();
                } else {
                    longValue = j4;
                }
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", Long.valueOf(longValue), l2);
                ArrayList arrayList2 = (ArrayList) hashMap.get(l2);
                long j5 = a + (((C37956b) arrayList2.get(arrayList2.size() - 1)).fRR - ((C37956b) arrayList2.get(0)).time);
                if (j5 < 0 || j5 > 172800000) {
                    C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", Long.valueOf(j5));
                    AppMethodBeat.m2505o(78691);
                    return;
                }
                i = 0;
                C37956b c37956b = null;
                while (i < arrayList2.size()) {
                    try {
                        C37956b c37956b2 = (C37956b) arrayList2.get(i);
                        r9 = new Object[5];
                        r9[1] = Long.valueOf(C5046bo.m7534c((Long) hashMap2.get(c37956b2.fRQ)));
                        r9[2] = Long.valueOf(c37956b2.fRR);
                        r9[3] = Long.valueOf(c37956b2.time);
                        r9[4] = Long.valueOf(c37956b2.fRR - c37956b2.time);
                        C4990ab.m7419v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", r9);
                        j4 = c37956b2.fRR - c37956b2.time;
                        if (j4 < 0 || j4 > 86400000) {
                            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", Long.valueOf(c37956b2.time), Long.valueOf(c37956b2.fRR), Long.valueOf(anU), Long.valueOf(j4));
                            a = 0;
                        } else {
                            a = j4;
                        }
                        hashMap2.put(c37956b2.fRQ, Long.valueOf(a + C5046bo.m7534c((Long) hashMap2.get(c37956b2.fRQ))));
                        hashMap3.put(c37956b2.fRQ, Long.valueOf(C5046bo.m7534c((Long) hashMap3.get(c37956b2.fRQ)) + 1));
                        if (c37956b != null) {
                            String str2 = c37956b.fRQ + "," + c37956b2.fRQ;
                            hashMap5.put(str2, Long.valueOf(C5046bo.m7534c((Long) hashMap5.get(str2)) + 1));
                        }
                        if (c37956b2.fRI != null) {
                            Map map;
                            if (hashMap6.containsKey(c37956b2.fRQ)) {
                                map = (Map) hashMap6.get(c37956b2.fRQ);
                            } else {
                                tG = new HashMap();
                                hashMap6.put(c37956b2.fRQ, tG);
                                Object map2 = tG;
                            }
                            for (int i3 = 0; i3 < c37956b2.fRI.size(); i3++) {
                                C32835d c32835d = (C32835d) c37956b2.fRI.get(i3);
                                map2.put(c32835d.fRX, Long.valueOf(C5046bo.m7534c((Long) map2.get(c32835d.fRX)) + 1));
                            }
                        }
                        i++;
                        c37956b = c37956b2;
                    } catch (Exception e) {
                        C37957c.m64213x(15007, C5046bo.m7574l(e));
                        C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", C5046bo.m7574l(e));
                        AppMethodBeat.m2505o(78691);
                        return;
                    } catch (OutOfMemoryError e2) {
                    }
                }
                if (c32834c != null) {
                    Iterator it2 = c32834c.fRW.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        String str3 = ((String) pair.first) + "," + ((String) pair.second);
                        if (hashMap5.containsKey(str3)) {
                            hashMap4.put(pair.second, hashMap5.get(str3));
                        }
                    }
                }
                j4 = longValue;
                a = j5;
            }
            long j6 = ((C37956b) ((ArrayList) hashMap.get(Long.valueOf(j4))).get(0)).time;
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "min key:%s,tbe:%s", Long.valueOf(j4), Long.valueOf(j6));
            if (j6 > anU || j6 < 0) {
                C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", Long.valueOf(j6), Long.valueOf(anU));
                AppMethodBeat.m2505o(78691);
                return;
            }
            int i4;
            C32834c c32834c2;
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= this.fRD.size()) {
                    c32834c2 = null;
                    break;
                } else if ("appstat".equals(((C32834c) this.fRD.get(i4)).fRU)) {
                    c32834c2 = (C32834c) this.fRD.get(i4);
                    break;
                } else {
                    i2 = i4 + 1;
                }
            }
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", Long.valueOf(j2), Long.valueOf(j6), Long.valueOf(a));
            C32834c c32834c3;
            if (c32834c2 == null || (j2 - j6) - a < 0) {
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s", c32834c2, Long.valueOf((j2 - j6) - a));
                i2 = 0;
                while (true) {
                    i4 = i2;
                    if (i4 >= this.fRD.size()) {
                        c32834c3 = null;
                        break;
                    } else if ("pagestat".equals(((C32834c) this.fRD.get(i4)).fRU)) {
                        c32834c3 = (C32834c) this.fRD.get(i4);
                        break;
                    } else {
                        i2 = i4 + 1;
                    }
                }
                if (c32834c3 != null) {
                    if (c32834c3.fRS > anT) {
                        if (C37957c.m64201a(j, c32834c3.fRT, this.fRH)) {
                            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", c32834c3, Long.valueOf(anT));
                            int h = C5046bo.m7567h(c4894a.anE("SEQ_" + c32834c3.eBH));
                            c4894a.mo10095ej("SEQ_" + c32834c3.eBH, h + 1);
                            JSONArray jSONArray = new JSONArray();
                            for (String str4 : hashMap2.keySet()) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("p", str4).put("in", ((Long) hashMap2.get(str4)).longValue() / 1000).put("c", hashMap3.get(str4)).put("c2", hashMap4.get(str4));
                                if (hashMap6.containsKey(str4)) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    Map map3 = (Map) hashMap6.get(str4);
                                    for (String str42 : map3.keySet()) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("w", str42).put("c", map3.get(str42));
                                        jSONArray2.put(jSONObject2);
                                    }
                                    jSONObject.put("wa", jSONArray2);
                                }
                                jSONArray.put(jSONObject);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("t", 6).put("tbe", j6 / 1000).put("ten", j2 / 1000).put("pa", jSONArray);
                            C37957c.m64203b(c32834c3.eBH, c32834c3.f15022id, h, jSONObject3.toString());
                            AppMethodBeat.m2505o(78691);
                            return;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", c32834c3, Long.valueOf(anT));
                    AppMethodBeat.m2505o(78691);
                    return;
                }
                C4990ab.m7416i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
                AppMethodBeat.m2505o(78691);
                return;
            }
            if (c32834c2.fRS > anT) {
                if (C37957c.m64201a(j, c32834c2.fRT, this.fRH)) {
                    C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", c32834c2, Long.valueOf(anT));
                    int h2 = C5046bo.m7567h(c4894a.anE("SEQ_" + c32834c2.eBH));
                    c4894a.mo10095ej("SEQ_" + c32834c2.eBH, h2 + 1);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("t", 5).put("tbe", j6 / 1000).put("ten", j2 / 1000).put("in", a / 1000).put("inbg", ((j2 - j6) - a) / 1000).put("swc", hashMap.size());
                    C37957c.m64203b(c32834c2.eBH, c32834c2.f15022id, h2, jSONObject4.toString());
                    i2 = 0;
                    while (true) {
                        i4 = i2;
                        if (i4 >= this.fRD.size()) {
                        }
                        i2 = i4 + 1;
                    }
                    if (c32834c3 != null) {
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", c32834c2, Long.valueOf(anT));
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= this.fRD.size()) {
                }
                i2 = i4 + 1;
            }
            if (c32834c3 != null) {
            }
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", C5046bo.m7574l(e3));
            AppMethodBeat.m2505o(78691);
        } catch (OutOfMemoryError e22) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a9 A:{SYNTHETIC, Splitter:B:33:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae A:{SYNTHETIC, Splitter:B:36:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A:{SYNTHETIC, Splitter:B:24:0x0093} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098 A:{SYNTHETIC, Splitter:B:27:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a9 A:{SYNTHETIC, Splitter:B:33:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae A:{SYNTHETIC, Splitter:B:36:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A:{SYNTHETIC, Splitter:B:24:0x0093} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098 A:{SYNTHETIC, Splitter:B:27:0x0098} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @SuppressLint({"UseSparseArrays"})
    /* renamed from: tG */
    private static HashMap<Long, ArrayList<C37956b>> m64212tG(String str) {
        ObjectInputStream objectInputStream;
        Throwable th;
        HashMap<Long, ArrayList<C37956b>> hashMap;
        AppMethodBeat.m2504i(78692);
        long anU = C5046bo.anU();
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                C4990ab.m7421w("MicroMsg.ClickFlowStatReceiver", "readStorage not exist path[%s]", str);
                HashMap hashMap2 = new HashMap();
                AppMethodBeat.m2505o(78692);
                return hashMap2;
            }
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.m2505o(78692);
                throw th;
            }
            try {
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "readStorage keys count:%d readTime:%d", Integer.valueOf(((HashMap) objectInputStream.readObject()).size()), Long.valueOf(C5046bo.m7566gb(anU)));
                try {
                    objectInputStream.close();
                } catch (Exception e3) {
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                AppMethodBeat.m2505o(78692);
                return hashMap;
            } catch (Throwable th3) {
                th = th3;
                C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "readStorage exception: %s [%s]", th.getMessage(), C5046bo.m7574l(th));
                if (objectInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                hashMap = new HashMap();
                AppMethodBeat.m2505o(78692);
                return hashMap;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            fileInputStream = null;
            if (objectInputStream != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(78692);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A:{SYNTHETIC, Splitter:B:32:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A:{SYNTHETIC, Splitter:B:35:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A:{SYNTHETIC, Splitter:B:32:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A:{SYNTHETIC, Splitter:B:35:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092 A:{SYNTHETIC, Splitter:B:45:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0097 A:{SYNTHETIC, Splitter:B:48:0x0097} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092 A:{SYNTHETIC, Splitter:B:45:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0097 A:{SYNTHETIC, Splitter:B:48:0x0097} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private synchronized void m64199a(String str, HashMap<Long, ArrayList<C37956b>> hashMap) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(78693);
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            long anU = C5046bo.anU();
            fileOutputStream = new FileOutputStream(str);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(hashMap);
                    fileOutputStream.flush();
                    C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "writeStorage count:%d time:%d", Integer.valueOf(hashMap.size()), Long.valueOf(C5046bo.m7566gb(anU)));
                    try {
                        objectOutputStream.close();
                    } catch (Exception e2) {
                    }
                    try {
                        fileOutputStream.close();
                        AppMethodBeat.m2505o(78693);
                    } catch (Exception e3) {
                        AppMethodBeat.m2505o(78693);
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), C5046bo.m7574l(e));
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                                AppMethodBeat.m2505o(78693);
                            }
                        }
                        AppMethodBeat.m2505o(78693);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(78693);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                objectOutputStream = null;
                C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), C5046bo.m7574l(e));
                if (objectOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(78693);
                return;
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                if (objectOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(78693);
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            objectOutputStream = null;
            fileOutputStream = null;
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), C5046bo.m7574l(e));
            if (objectOutputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(78693);
            return;
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream = null;
            fileOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e9) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e10) {
                }
            }
            AppMethodBeat.m2505o(78693);
            throw th;
        }
        return;
    }

    /* renamed from: b */
    private static void m64203b(int i, String str, int i2, String str2) {
        AppMethodBeat.m2504i(78694);
        try {
            String replace = str2.replace(",", ";");
            int ceil = (int) Math.ceil(((double) replace.length()) / 6000.0d);
            for (int i3 = 0; i3 < ceil; i3++) {
                C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", Integer.valueOf(i), str, str + "," + i2 + "," + i3 + "," + ceil + ",0,0,," + replace.substring(i3 * 6000, Math.min((i3 + 1) * 6000, replace.length())));
                C7053e.pXa.mo8378a(346, 4, 1, false);
                C7053e.pXa.mo8376a(i, r11, true, true);
            }
            AppMethodBeat.m2505o(78694);
        } catch (Exception e) {
            C37957c.m64213x(15009, C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(78694);
        }
    }

    /* renamed from: fQ */
    private static String m64209fQ(long j) {
        AppMethodBeat.m2504i(78695);
        String format;
        if (j < 100000000000L) {
            format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j * 1000));
            AppMethodBeat.m2505o(78695);
            return format;
        }
        format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j)) + String.format(Locale.getDefault(), ".%03d", new Object[]{Long.valueOf(j % 1000)});
        AppMethodBeat.m2505o(78695);
        return format;
    }

    /* renamed from: cc */
    private static String m64205cc(Context context) {
        int i;
        AppMethodBeat.m2504i(78696);
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools") || runningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp"))) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        String str;
        if (i == 0) {
            str = "";
            AppMethodBeat.m2505o(78696);
            return str;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    str = "";
                    AppMethodBeat.m2505o(78696);
                    return str;
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.m2505o(78696);
                        return null;
                    }
                    str = componentName.getClassName();
                    if (str.contains(".")) {
                        str = str.substring(str.lastIndexOf(".") + 1);
                    }
                    AppMethodBeat.m2505o(78696);
                    return str;
                }
                str = "";
                AppMethodBeat.m2505o(78696);
                return str;
            }
            str = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (str.contains(".")) {
                str = str.substring(str.lastIndexOf(".") + 1);
            }
            AppMethodBeat.m2505o(78696);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", e.getMessage(), C5046bo.m7574l(e));
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m64196a(C37957c c37957c, int i, String str, int i2, long j, long j2) {
        AppMethodBeat.m2504i(78699);
        long anU = C5046bo.anU();
        if (TextUtils.isEmpty(str) || j > anU) {
            C4990ab.m7413e("MicroMsg.ClickFlowStatReceiver", "writeToList page:%s  start - time = %d", str, Long.valueOf(anU - j));
            AppMethodBeat.m2505o(78699);
            return;
        }
        C37956b c37956b = new C37956b();
        c37956b.czE = i;
        c37956b.fRQ = str.contains(".") ? str.substring(str.lastIndexOf(".") + 1) : str;
        if (3 == i && ((c37957c.fRE || (c37957c.fRF.containsKey(c37956b.fRQ) && ((Boolean) c37957c.fRF.get(c37956b.fRQ)).booleanValue())) && !AccessibilityCapture.isEnable())) {
            Object obj = (C7243d.vxi == null || !C7243d.vxi.toLowerCase().startsWith("samsung")) ? null : 1;
            if (obj != null) {
                int i3 = 0;
                if (C4996ah.bqo() && C1720g.m3537RQ().eKs && C1720g.m3534RN().mo5161QY()) {
                    C1720g.m3534RN();
                    if (!C1668a.m3393QT()) {
                        C1720g.m3534RN();
                        i3 = C1668a.m3383QF();
                    }
                }
                if (i3 != 0) {
                    C37957c.m64201a((long) i3, 0.01f, c37957c.fRH);
                }
            }
        }
        if (5 == i || 6 == i) {
            c37956b.czE = 4;
        } else if (!(3 == i || 4 == i)) {
            C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "writeToList error opCode:%d  (%s)", Integer.valueOf(i), str);
            AppMethodBeat.m2505o(78699);
            return;
        }
        c37956b.time = j;
        c37956b.elapsedTime = j2;
        c37957c.fRA.add(c37956b);
        C4990ab.m7417i("MicroMsg.ClickFlowStatReceiver", "ActivityState op:%d time:%s 0x%x %s useTime:%d", Integer.valueOf(c37956b.czE), C37957c.m64209fQ(c37956b.time), Integer.valueOf(i2), c37956b.fRQ, Long.valueOf(C5046bo.m7566gb(anU)));
        if (c37956b.czE == 3) {
            c37957c.fRy.stopTimer();
            AppMethodBeat.m2505o(78699);
            return;
        }
        if (c37956b.czE == 4) {
            c37957c.fRy.stopTimer();
            c37957c.fRy.mo16770ae(5000, 5000);
        }
        AppMethodBeat.m2505o(78699);
    }
}
