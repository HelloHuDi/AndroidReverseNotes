package com.tencent.mm.modelstat;

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
import com.tencent.mm.accessibility.AccessibilityCapture;
import com.tencent.mm.accessibility.AccessibilityCapture.APIProvider;
import com.tencent.mm.accessibility.AccessibilityCapture.Event;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.o;
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

public class c implements APIProvider {
    private static c fRx;
    private ArrayList<b> fRA = new ArrayList();
    private String fRB = null;
    private long fRC = 0;
    private ArrayList<c> fRD = new ArrayList();
    private boolean fRE = false;
    private Map<String, Boolean> fRF = new HashMap();
    private long fRG = 0;
    private long fRH = 0;
    private List<d> fRI = new ArrayList();
    private ap fRy = null;
    private final int fRz = 20971520;
    private ak handler = null;

    static class a {
        Map<String, Boolean> fRF = new HashMap();
        long fRG;
        long fRH;
        List<c> fRP = new ArrayList();

        static class a extends Exception {
            a(String str) {
                super(str);
            }

            a(Throwable th) {
                super(th);
            }
        }

        private a() {
            AppMethodBeat.i(78663);
            AppMethodBeat.o(78663);
        }

        public final String toString() {
            AppMethodBeat.i(78664);
            String str = "Config{nextUpdateInterval=" + this.fRG + ", samplePeriod=" + this.fRH + ", eventList=" + this.fRP + '}';
            AppMethodBeat.o(78664);
            return str;
        }

        static a tH(String str) {
            AppMethodBeat.i(78665);
            a aVar = new a();
            try {
                Map z = br.z(str, "eventSampleConf");
                if (z == null) {
                    ab.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", str);
                    a aVar2 = new a("reportConfigMap is null");
                    AppMethodBeat.o(78665);
                    throw aVar2;
                }
                aVar.fRG = bo.getLong((String) z.get(".eventSampleConf.nextUpdateInterval"), 0);
                if (aVar.fRG <= 0 || aVar.fRG > 432000) {
                    aVar.fRG = 432000;
                }
                aVar.fRH = bo.getLong((String) z.get(".eventSampleConf.samplePeriod"), 0);
                int i = 0;
                while (true) {
                    c cVar = new c();
                    String str2 = ".eventSampleConf.events.event" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                    int i2 = i + 1;
                    cVar.id = bo.getInt((String) z.get(str2 + "id"), 0);
                    if (cVar.id > 0) {
                        String str3;
                        int i3;
                        String str4;
                        cVar.fRS = bo.getLong((String) z.get(str2 + "expireTime"), 0);
                        cVar.name = (String) z.get(str2 + "name");
                        cVar.fRT = bo.getFloat((String) z.get(str2 + "rate"), 0.0f);
                        cVar.eBH = bo.getInt((String) z.get(str2 + "logId"), 0);
                        cVar.fRU = (String) z.get(str2 + "pages.$type");
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
                            aVar.fRF.put(str4, Boolean.valueOf(equals));
                            i = i3;
                        }
                        cVar.fRV = arrayList;
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
                        cVar.fRW = arrayList;
                        aVar.fRP.add(cVar);
                        ab.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", cVar);
                        i = i2;
                    } else {
                        ab.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", aVar);
                        AppMethodBeat.o(78665);
                        return aVar;
                    }
                }
            } catch (Exception e) {
                a aVar3 = new a(e);
                AppMethodBeat.o(78665);
                throw aVar3;
            }
        }
    }

    static class c {
        int eBH;
        long fRS;
        float fRT;
        String fRU;
        ArrayList<Pair<String, Boolean>> fRV;
        ArrayList<Pair<String, String>> fRW;
        int id;
        String name;

        private c() {
            AppMethodBeat.i(78667);
            this.fRV = new ArrayList();
            this.fRW = new ArrayList();
            AppMethodBeat.o(78667);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final String toString() {
            Pair pair;
            AppMethodBeat.i(78668);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ReportConfigEvent{");
            stringBuilder.append("id=" + this.id);
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
            AppMethodBeat.o(78668);
            return stringBuilder2;
        }
    }

    static class d implements Serializable, Comparable<d> {
        String fRX = null;
        int left;
        long time = 0;
        int top;
        int type = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((d) obj).time);
        }

        d() {
        }

        public final String toString() {
            AppMethodBeat.i(78669);
            String format = String.format(Locale.getDefault(), "[%s,%s]", new Object[]{this.fRX, c.fR(this.time)});
            AppMethodBeat.o(78669);
            return format;
        }
    }

    static class b implements Serializable, Comparable<b> {
        int czE = 0;
        long elapsedTime = 0;
        List<d> fRI = null;
        String fRQ = null;
        long fRR;
        long time = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((b) obj).time);
        }

        b() {
        }

        public final String toString() {
            AppMethodBeat.i(78666);
            String format = String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[]{this.fRQ, Integer.valueOf(this.czE), c.fR(this.time)});
            AppMethodBeat.o(78666);
            return format;
        }
    }

    static /* synthetic */ String cd(Context context) {
        AppMethodBeat.i(78697);
        String cc = cc(context);
        AppMethodBeat.o(78697);
        return cc;
    }

    static /* synthetic */ String fR(long j) {
        AppMethodBeat.i(78701);
        String fQ = fQ(j);
        AppMethodBeat.o(78701);
        return fQ;
    }

    public static c akc() {
        AppMethodBeat.i(78670);
        if (fRx == null) {
            synchronized (c.class) {
                try {
                    if (fRx == null) {
                        fRx = new c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78670);
                    }
                }
            }
        }
        c cVar = fRx;
        AppMethodBeat.o(78670);
        return cVar;
    }

    public void onEvent(Event event) {
        AppMethodBeat.i(78671);
        if (event == null || event.view == null || event.activity == null) {
            AppMethodBeat.o(78671);
        } else if (event.activity.getComponentName() == null) {
            AppMethodBeat.o(78671);
        } else {
            Object shortClassName = event.activity.getComponentName().getShortClassName();
            if (shortClassName.contains(".")) {
                shortClassName = shortClassName.substring(shortClassName.lastIndexOf(".") + 1);
            }
            if (this.fRE || this.fRF.containsKey(shortClassName)) {
                d dVar = new d();
                long currentTimeMillis = System.currentTimeMillis();
                dVar.fRX = Integer.toHexString(event.view.getId());
                dVar.type = event.event.getEventType();
                dVar.time = event.elapsedTime;
                this.fRI.add(dVar);
                int[] iArr = new int[2];
                event.view.getLocationOnScreen(iArr);
                dVar.left = iArr[0];
                dVar.top = iArr[1];
                ab.d("MicroMsg.ClickFlowStatReceiver", "[oneliang]id:" + dVar.fRX + ",ui:" + event.activity.getComponentName().getShortClassName() + ",left:" + dVar.left + ",top:" + dVar.top + ",time:" + dVar.time + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(78671);
                return;
            }
            AppMethodBeat.o(78671);
        }
    }

    public void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(78672);
        ab.v("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.o(78672);
    }

    public void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(78673);
        ab.d("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.o(78673);
    }

    public void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(78674);
        ab.i("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.o(78674);
    }

    public void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(78675);
        ab.e("MicroMsg.ClickFlowStatReceiver", str2, objArr);
        AppMethodBeat.o(78675);
    }

    public void post(Runnable runnable, String str) {
        AppMethodBeat.i(78676);
        if (this.handler != null) {
            this.handler.post(runnable);
        }
        AppMethodBeat.o(78676);
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(78677);
        ab.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", th, str2, objArr);
        AppMethodBeat.o(78677);
    }

    private c() {
        AppMethodBeat.i(78678);
        if (com.tencent.mm.sdk.a.b.dnO()) {
            Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", ah.bqo());
        }
        HandlerThread anM = com.tencent.mm.sdk.g.d.anM("ClickFlow");
        anM.start();
        this.handler = new ak(anM.getLooper());
        this.fRy = new ap(anM.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(78658);
                ab.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", Boolean.valueOf(o.gl(ah.getContext())), Boolean.valueOf(!bo.isNullOrNil(c.cd(ah.getContext()))), c.cd(ah.getContext()));
                if (o.gl(ah.getContext()) && r0) {
                    AppMethodBeat.o(78658);
                    return true;
                }
                c.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(78657);
                        c.a(c.this);
                        AppMethodBeat.o(78657);
                    }
                });
                AppMethodBeat.o(78658);
                return false;
            }
        }, true);
        AppMethodBeat.o(78678);
    }

    public final void commitNow() {
        AppMethodBeat.i(78679);
        long anU = bo.anU();
        ab.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", (Boolean) new bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(78659);
                c.a(c.this);
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(78659);
                return bool;
            }
        }.b(this.handler), Long.valueOf(bo.gb(anU)));
        AppMethodBeat.o(78679);
    }

    public final void v(final Intent intent) {
        AppMethodBeat.i(78680);
        if (intent == null || !intent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")) {
            AppMethodBeat.o(78680);
            return;
        }
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78660);
                String stringExtra = intent.getStringExtra("ui");
                int intExtra = intent.getIntExtra("uiHashCode", 0);
                int intExtra2 = intent.getIntExtra("opCode", 0);
                ab.d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d, elapsed time:%d", Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Long.valueOf(bo.gb(intent.getLongExtra("nowMilliSecond", 0))), Long.valueOf(intent.getLongExtra("elapsedRealtime", 0)));
                if (2147483632 == intExtra2) {
                    c.a(c.this);
                    AppMethodBeat.o(78660);
                    return;
                }
                c.a(c.this, intExtra2, stringExtra, intExtra, r4, r6);
                AppMethodBeat.o(78660);
            }
        });
        AppMethodBeat.o(78680);
    }

    private static boolean fP(long j) {
        return j == 0;
    }

    private Pair<Integer, ArrayList<b>> h(ArrayList<b> arrayList) {
        AppMethodBeat.i(78681);
        ArrayList arrayList2 = new ArrayList();
        long anU = bo.anU();
        try {
            b bVar;
            ArrayList arrayList3 = new ArrayList();
            long j = 0;
            int i = 0;
            while (i < arrayList.size()) {
                bVar = (b) arrayList.get(i);
                if (bVar.time < 0 || bVar.time > anU || anU - bVar.time > 50400000) {
                    ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", Long.valueOf(bVar.time), Long.valueOf(anU - bVar.time), Integer.valueOf(bVar.czE), bVar.fRQ);
                    AppMethodBeat.o(78681);
                    return null;
                }
                long j2;
                if (bVar.czE == 4) {
                    if (j < bVar.time) {
                        j2 = bVar.time;
                    }
                    j2 = j;
                } else if (bVar.czE != 3) {
                    ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", Integer.valueOf(bVar.czE), bVar.fRQ);
                    AppMethodBeat.o(78681);
                    return null;
                } else {
                    arrayList3.add(bVar);
                    j2 = j;
                }
                i++;
                j = j2;
            }
            if (arrayList3.size() == 0) {
                AppMethodBeat.o(78681);
                return null;
            }
            Collections.sort(arrayList3);
            Collections.sort(this.fRI);
            bVar = new b();
            Iterator it = arrayList3.iterator();
            b bVar2 = bVar;
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (!bVar.fRQ.equals(bVar2.fRQ)) {
                    a(bVar2, bVar.elapsedTime);
                    arrayList2.add(bVar);
                    bVar2.fRR = bVar.time;
                    bVar2 = bVar;
                } else if (bVar.time - bVar2.time > 10800000) {
                    ab.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", Long.valueOf(bVar.time), Long.valueOf(bVar2.time));
                    bVar2.time = bVar.time;
                }
            }
            if (!arrayList2.isEmpty()) {
                a((b) arrayList2.get(arrayList2.size() - 1), j);
            }
            bVar2.fRR = ((b) arrayList.get(arrayList.size() - 1)).time;
            if (((b) arrayList2.get(arrayList2.size() - 1)).time > j) {
                ((b) arrayList2.get(arrayList2.size() - 1)).fRR = anU;
            } else if (j > anU) {
                ((b) arrayList2.get(arrayList2.size() - 1)).fRR = anU;
            }
            if (((b) arrayList2.get(arrayList2.size() - 1)).fRR - ((b) arrayList2.get(0)).time > 50400000) {
                ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
                AppMethodBeat.o(78681);
                return null;
            }
            ab.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", Integer.valueOf(0), Integer.valueOf(arrayList2.size()), Long.valueOf(bo.gb(anU)));
            Pair<Integer, ArrayList<b>> create = Pair.create(Integer.valueOf(0), arrayList2);
            AppMethodBeat.o(78681);
            return create;
        } catch (Exception e) {
            x(15008, bo.l(e));
            ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", bo.l(e));
            AppMethodBeat.o(78681);
            return null;
        }
    }

    private void a(b bVar, long j) {
        AppMethodBeat.i(78682);
        if (bVar.elapsedTime <= 0) {
            AppMethodBeat.o(78682);
            return;
        }
        int i;
        long j2 = bVar.elapsedTime;
        if (this.fRI.isEmpty()) {
            i = 0;
        } else {
            i = this.fRI.size() - 1;
        }
        i = d(j2, 0, i);
        if (i != -1) {
            if (bVar.fRI == null) {
                bVar.fRI = new ArrayList();
            }
            int size = this.fRI.size();
            for (int i2 = i; i2 < size; i2++) {
                d dVar = (d) this.fRI.get(i2);
                if (dVar.time > bVar.elapsedTime && dVar.time <= j) {
                    bVar.fRI.add(dVar);
                }
                if (dVar.time >= j) {
                    break;
                }
            }
        }
        AppMethodBeat.o(78682);
    }

    private int d(long j, int i, int i2) {
        AppMethodBeat.i(78683);
        if (this.fRI == null || this.fRI.isEmpty()) {
            AppMethodBeat.o(78683);
            return -1;
        }
        int i3 = (i + i2) / 2;
        if (i2 - i != 0 && i2 - i != 1) {
            i2 = j < ((d) this.fRI.get(i3)).time ? d(j, i, i3) : j > ((d) this.fRI.get(i3)).time ? d(j, i3, i2) : i3;
        } else if (j < ((d) this.fRI.get(i2)).time) {
            i2 = i;
        }
        AppMethodBeat.o(78683);
        return i2;
    }

    private static void x(int i, String str) {
        AppMethodBeat.i(78684);
        e.pXa.X(13328, i + ",0,0,0,0,0,0,0,0,0,0,0,0," + str);
        AppMethodBeat.o(78684);
    }

    private void a(a aVar) {
        AppMethodBeat.i(78685);
        this.fRG = aVar.fRG;
        if (this.fRG <= 0 || this.fRG > 432000) {
            this.fRG = 432000;
        }
        this.fRH = aVar.fRH;
        this.fRD.clear();
        this.fRD.addAll(aVar.fRP);
        this.fRF.clear();
        this.fRF.putAll(aVar.fRF);
        if (this.fRF.containsKey("*") && ((Boolean) this.fRF.get("*")).booleanValue()) {
            this.fRE = true;
        }
        ab.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", Integer.valueOf(this.fRD.size()), Long.valueOf(this.fRG), Long.valueOf(this.fRH));
        AppMethodBeat.o(78685);
    }

    private static boolean a(long j, float f, long j2) {
        AppMethodBeat.i(78686);
        if (com.tencent.mm.sdk.a.b.dnO()) {
            AppMethodBeat.o(78686);
            return true;
        } else if (f <= 0.0f) {
            AppMethodBeat.o(78686);
            return false;
        } else {
            long j3;
            int i = Downloads.MIN_WAIT_FOR_NETWORK / ((int) (10000.0f * f));
            int i2 = (int) j;
            i2 = (i2 ^ (i2 >> 16)) * 73244475;
            i2 = (i2 ^ (i2 >> 16)) * 73244475;
            int i3 = ((i2 >> 16) ^ i2) % i;
            long anT = bo.anT();
            if (j2 == 0) {
                j3 = 259200;
            } else {
                j3 = j2;
            }
            ab.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", Boolean.valueOf(i3 == ((int) ((anT / j3) % ((long) i)))), Long.valueOf(j), Float.valueOf(f), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(r3), Integer.valueOf(i3), Integer.valueOf((int) ((anT / j3) % ((long) i))));
            AppMethodBeat.o(78686);
            return i3 == ((int) ((anT / j3) % ((long) i)));
        }
    }

    private static void a(List<b> list, c cVar, SparseArray<String> sparseArray) {
        int i = 0;
        AppMethodBeat.i(78687);
        String str = cVar.fRU;
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
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", cVar);
                sparseArray.put(cVar.eBH, bo.nullAsNil((String) sparseArray.get(cVar.eBH)) + cVar.id + ";");
                AppMethodBeat.o(78687);
                return;
            case 1:
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", cVar);
                for (i2 = 0; i2 < list.size(); i2 = i3 + 1) {
                    i4 = 0;
                    i3 = i2;
                    while (i4 < cVar.fRV.size()) {
                        int size;
                        if (((String) ((Pair) cVar.fRV.get(i4)).first).equals(((b) list.get(i3)).fRQ)) {
                            sparseArray.put(cVar.eBH, bo.nullAsNil((String) sparseArray.get(cVar.eBH)) + cVar.id + ";");
                            i4 = cVar.fRV.size();
                            size = list.size();
                        } else {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                }
                AppMethodBeat.o(78687);
                return;
            case 2:
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", cVar);
                if (list.size() >= 2) {
                    if ((cVar.fRV.size() == 2 ? 1 : 0) == 0) {
                        ab.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + cVar.fRV.toString());
                        AppMethodBeat.o(78687);
                        return;
                    }
                    String str2 = (String) ((Pair) cVar.fRV.get(1)).first;
                    if (((b) list.get(0)).fRQ.equals((String) ((Pair) cVar.fRV.get(0)).first) && ((b) list.get(list.size() - 1)).fRQ.equals(str2)) {
                        sparseArray.put(cVar.eBH, bo.nullAsNil((String) sparseArray.get(cVar.eBH)) + cVar.id + ";");
                        AppMethodBeat.o(78687);
                        return;
                    }
                }
                break;
            case 3:
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", cVar);
                ArrayList arrayList = cVar.fRV;
                if (arrayList.size() > 0) {
                    for (i2 = arrayList.size() - 1; i2 < list.size(); i2 = (arrayList.size() - i4) + i3) {
                        i4 = arrayList.size() - 1;
                        i3 = i2;
                        while (((String) ((Pair) arrayList.get(i4)).first).equals(((b) list.get(i3)).fRQ)) {
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
                    sparseArray.put(cVar.eBH, bo.nullAsNil((String) sparseArray.get(cVar.eBH)) + cVar.id + ";");
                    break;
                }
                break;
        }
        AppMethodBeat.o(78687);
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar) {
        c cVar;
        AppMethodBeat.i(78688);
        long j2 = ((b) arrayList.get(0)).time;
        long j3 = ((b) arrayList.get(arrayList.size() - 1)).fRR;
        long anT = bo.anT();
        int i = 0;
        while (i < this.fRD.size()) {
            try {
                if ("app".equals(((c) this.fRD.get(i)).fRU)) {
                    cVar = (c) this.fRD.get(i);
                    break;
                }
                i++;
            } catch (Exception e) {
                x(15004, bo.l(e));
                ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", bo.l(e));
                AppMethodBeat.o(78688);
                return;
            }
        }
        cVar = null;
        if (cVar == null) {
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
            if (fP(j)) {
                a(aVar, 13604, 100001, j2, j3);
                AppMethodBeat.o(78688);
                return;
            }
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
            AppMethodBeat.o(78688);
        } else if (cVar.fRS <= anT || !a(j, cVar.fRT, this.fRH)) {
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", cVar, Long.valueOf(anT));
            AppMethodBeat.o(78688);
        } else {
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", cVar, Long.valueOf(anT));
            a(aVar, cVar.eBH, cVar.id, j2, j3);
            AppMethodBeat.o(78688);
        }
    }

    private static void a(com.tencent.mm.sdk.e.a aVar, int i, int i2, long j, long j2) {
        AppMethodBeat.i(78689);
        long anU = bo.anU();
        if (j > j2 || j < 0 || j2 < 0 || j > anU || j2 > anU) {
            ab.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(anU));
            AppMethodBeat.o(78689);
            return;
        }
        int h = bo.h(aVar.anE("SEQ_".concat(String.valueOf(i))));
        aVar.ej("SEQ_".concat(String.valueOf(i)), h + 1);
        anU = bo.c(aVar.anD("LastQuit_".concat(String.valueOf(i2))));
        aVar.aK("LastQuit_".concat(String.valueOf(i2)), j2);
        if (anU <= 0 || anU > j) {
            anU = j;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", 1).put("tbe", j / 1000).put("ten", j2 / 1000).put("in", (j2 - j) / 1000).put("lten", anU / 1000).put("inbg", (j - anU) / 1000);
        b(i, String.valueOf(i2), h, jSONObject.toString());
        AppMethodBeat.o(78689);
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar, int i) {
        AppMethodBeat.i(78690);
        try {
            int h;
            int i2;
            long anU = bo.anU();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                b bVar = (b) arrayList.get(i3);
                if (bVar.fRR < bVar.time || bVar.time < 0 || bVar.fRR < 0 || bVar.fRR > anU || bVar.time > anU) {
                    ab.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", Long.valueOf(bVar.time), Long.valueOf(bVar.fRR), Long.valueOf(anU));
                    AppMethodBeat.o(78690);
                    return;
                }
                jSONObject.put("p", bVar.fRQ).put("tbe", bVar.time / 1000).put("in", (bVar.fRR - bVar.time) / 1000);
                if (!(bVar.fRI == null || bVar.fRI.isEmpty())) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < bVar.fRI.size(); i4++) {
                        d dVar = (d) bVar.fRI.get(i4);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("w", dVar.fRX).put("t", dVar.type).put("tbp", "{" + dVar.left + ";" + dVar.top + "}");
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("wf", jSONArray2);
                }
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", 2).put("errt", i).put("pf", jSONArray);
            if (fP(j)) {
                h = bo.h(aVar.anE("SEQ_13604"));
                aVar.ej("SEQ_13604", h + 1);
                b(13604, "100002", h, jSONObject3.toString());
            }
            SparseArray sparseArray = new SparseArray();
            if (this.fRD.size() == 0) {
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
            }
            for (i2 = 0; i2 < this.fRD.size(); i2++) {
                c cVar = (c) this.fRD.get(i2);
                if (cVar.fRS > bo.anT()) {
                    if (a(j, cVar.fRT, this.fRH)) {
                        a((List) arrayList, cVar, sparseArray);
                    }
                }
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", cVar, Long.valueOf(bo.anT()));
            }
            h = 0;
            while (true) {
                i2 = h;
                if (i2 < sparseArray.size()) {
                    int keyAt = sparseArray.keyAt(i2);
                    String str = (String) sparseArray.get(keyAt);
                    int h2 = bo.h(aVar.anE("SEQ_".concat(String.valueOf(keyAt))));
                    aVar.ej("SEQ_".concat(String.valueOf(keyAt)), h2 + 1);
                    b(keyAt, str, h2, jSONObject3.toString());
                    h = i2 + 1;
                } else {
                    AppMethodBeat.o(78690);
                    return;
                }
            }
        } catch (Exception e) {
            x(15005, bo.l(e));
            ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", bo.l(e));
            AppMethodBeat.o(78690);
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
            com.tencent.mm.a.e.deleteFile(r17);
            java.lang.System.gc();
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", r4, "OutOfMemoryError", new java.lang.Object[0]);
            x(15010, com.tencent.mm.sdk.platformtools.bo.l(r4));
            com.tencent.matrix.trace.core.AppMethodBeat.o(78691);
     */
    /* JADX WARNING: Missing block: B:139:0x0705, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:142:?, code skipped:
            x(15006, com.tencent.mm.sdk.platformtools.bo.l(r4));
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", com.tencent.mm.sdk.platformtools.bo.l(r4));
     */
    /* JADX WARNING: Missing block: B:190:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar) {
        AppMethodBeat.i(78691);
        long anU = bo.anU();
        long j2 = ((b) arrayList.get(arrayList.size() - 1)).fRR;
        if (j2 <= 0 || j2 > anU) {
            ab.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", Long.valueOf(j2), Long.valueOf(anU));
            AppMethodBeat.o(78691);
            return;
        }
        long anT = bo.anT();
        String str = this.fRB + "stg_20971520_" + j + ".HashMap";
        try {
            HashMap tG = tG(str);
            tG.put(Long.valueOf(j2), arrayList);
            Iterator it = tG.entrySet().iterator();
            while (it.hasNext()) {
                if (((Long) ((Entry) it.next()).getKey()).longValue() + 259200000 < j2) {
                    it.remove();
                }
            }
            a(str, tG);
            long j3 = com.tencent.mm.sdk.a.b.dnO() ? 180000 : 3600000;
            long a = bo.a(aVar.anD("LAST_REPORT_STATISITIC_TIME"), 0);
            if (a + j3 > j2) {
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", Long.valueOf(a), Long.valueOf(j2), Long.valueOf(j3));
                AppMethodBeat.o(78691);
                return;
            }
            int i;
            c cVar;
            aVar.aK("LAST_REPORT_STATISITIC_TIME", j2);
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
                    cVar = null;
                    break;
                } else if ("pagestat".equals(((c) this.fRD.get(i)).fRU)) {
                    cVar = (c) this.fRD.get(i);
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            ab.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", Integer.valueOf(hashMap.size()));
            for (Long l2 : hashMap.keySet()) {
                long longValue;
                if (j4 > l2.longValue()) {
                    longValue = l2.longValue();
                } else {
                    longValue = j4;
                }
                ab.i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", Long.valueOf(longValue), l2);
                ArrayList arrayList2 = (ArrayList) hashMap.get(l2);
                long j5 = a + (((b) arrayList2.get(arrayList2.size() - 1)).fRR - ((b) arrayList2.get(0)).time);
                if (j5 < 0 || j5 > 172800000) {
                    ab.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", Long.valueOf(j5));
                    AppMethodBeat.o(78691);
                    return;
                }
                i = 0;
                b bVar = null;
                while (i < arrayList2.size()) {
                    try {
                        b bVar2 = (b) arrayList2.get(i);
                        r9 = new Object[5];
                        r9[1] = Long.valueOf(bo.c((Long) hashMap2.get(bVar2.fRQ)));
                        r9[2] = Long.valueOf(bVar2.fRR);
                        r9[3] = Long.valueOf(bVar2.time);
                        r9[4] = Long.valueOf(bVar2.fRR - bVar2.time);
                        ab.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", r9);
                        j4 = bVar2.fRR - bVar2.time;
                        if (j4 < 0 || j4 > 86400000) {
                            ab.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", Long.valueOf(bVar2.time), Long.valueOf(bVar2.fRR), Long.valueOf(anU), Long.valueOf(j4));
                            a = 0;
                        } else {
                            a = j4;
                        }
                        hashMap2.put(bVar2.fRQ, Long.valueOf(a + bo.c((Long) hashMap2.get(bVar2.fRQ))));
                        hashMap3.put(bVar2.fRQ, Long.valueOf(bo.c((Long) hashMap3.get(bVar2.fRQ)) + 1));
                        if (bVar != null) {
                            String str2 = bVar.fRQ + "," + bVar2.fRQ;
                            hashMap5.put(str2, Long.valueOf(bo.c((Long) hashMap5.get(str2)) + 1));
                        }
                        if (bVar2.fRI != null) {
                            Map map;
                            if (hashMap6.containsKey(bVar2.fRQ)) {
                                map = (Map) hashMap6.get(bVar2.fRQ);
                            } else {
                                tG = new HashMap();
                                hashMap6.put(bVar2.fRQ, tG);
                                Object map2 = tG;
                            }
                            for (int i3 = 0; i3 < bVar2.fRI.size(); i3++) {
                                d dVar = (d) bVar2.fRI.get(i3);
                                map2.put(dVar.fRX, Long.valueOf(bo.c((Long) map2.get(dVar.fRX)) + 1));
                            }
                        }
                        i++;
                        bVar = bVar2;
                    } catch (Exception e) {
                        x(15007, bo.l(e));
                        ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", bo.l(e));
                        AppMethodBeat.o(78691);
                        return;
                    } catch (OutOfMemoryError e2) {
                    }
                }
                if (cVar != null) {
                    Iterator it2 = cVar.fRW.iterator();
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
            long j6 = ((b) ((ArrayList) hashMap.get(Long.valueOf(j4))).get(0)).time;
            ab.i("MicroMsg.ClickFlowStatReceiver", "min key:%s,tbe:%s", Long.valueOf(j4), Long.valueOf(j6));
            if (j6 > anU || j6 < 0) {
                ab.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", Long.valueOf(j6), Long.valueOf(anU));
                AppMethodBeat.o(78691);
                return;
            }
            int i4;
            c cVar2;
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= this.fRD.size()) {
                    cVar2 = null;
                    break;
                } else if ("appstat".equals(((c) this.fRD.get(i4)).fRU)) {
                    cVar2 = (c) this.fRD.get(i4);
                    break;
                } else {
                    i2 = i4 + 1;
                }
            }
            ab.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", Long.valueOf(j2), Long.valueOf(j6), Long.valueOf(a));
            c cVar3;
            if (cVar2 == null || (j2 - j6) - a < 0) {
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s", cVar2, Long.valueOf((j2 - j6) - a));
                i2 = 0;
                while (true) {
                    i4 = i2;
                    if (i4 >= this.fRD.size()) {
                        cVar3 = null;
                        break;
                    } else if ("pagestat".equals(((c) this.fRD.get(i4)).fRU)) {
                        cVar3 = (c) this.fRD.get(i4);
                        break;
                    } else {
                        i2 = i4 + 1;
                    }
                }
                if (cVar3 != null) {
                    if (cVar3.fRS > anT) {
                        if (a(j, cVar3.fRT, this.fRH)) {
                            ab.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", cVar3, Long.valueOf(anT));
                            int h = bo.h(aVar.anE("SEQ_" + cVar3.eBH));
                            aVar.ej("SEQ_" + cVar3.eBH, h + 1);
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
                            b(cVar3.eBH, cVar3.id, h, jSONObject3.toString());
                            AppMethodBeat.o(78691);
                            return;
                        }
                    }
                    ab.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", cVar3, Long.valueOf(anT));
                    AppMethodBeat.o(78691);
                    return;
                }
                ab.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
                AppMethodBeat.o(78691);
                return;
            }
            if (cVar2.fRS > anT) {
                if (a(j, cVar2.fRT, this.fRH)) {
                    ab.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", cVar2, Long.valueOf(anT));
                    int h2 = bo.h(aVar.anE("SEQ_" + cVar2.eBH));
                    aVar.ej("SEQ_" + cVar2.eBH, h2 + 1);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("t", 5).put("tbe", j6 / 1000).put("ten", j2 / 1000).put("in", a / 1000).put("inbg", ((j2 - j6) - a) / 1000).put("swc", hashMap.size());
                    b(cVar2.eBH, cVar2.id, h2, jSONObject4.toString());
                    i2 = 0;
                    while (true) {
                        i4 = i2;
                        if (i4 >= this.fRD.size()) {
                        }
                        i2 = i4 + 1;
                    }
                    if (cVar3 != null) {
                    }
                }
            }
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", cVar2, Long.valueOf(anT));
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= this.fRD.size()) {
                }
                i2 = i4 + 1;
            }
            if (cVar3 != null) {
            }
        } catch (Exception e3) {
            ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", bo.l(e3));
            AppMethodBeat.o(78691);
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
    private static HashMap<Long, ArrayList<b>> tG(String str) {
        ObjectInputStream objectInputStream;
        Throwable th;
        HashMap<Long, ArrayList<b>> hashMap;
        AppMethodBeat.i(78692);
        long anU = bo.anU();
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                ab.w("MicroMsg.ClickFlowStatReceiver", "readStorage not exist path[%s]", str);
                HashMap hashMap2 = new HashMap();
                AppMethodBeat.o(78692);
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
                AppMethodBeat.o(78692);
                throw th;
            }
            try {
                ab.i("MicroMsg.ClickFlowStatReceiver", "readStorage keys count:%d readTime:%d", Integer.valueOf(((HashMap) objectInputStream.readObject()).size()), Long.valueOf(bo.gb(anU)));
                try {
                    objectInputStream.close();
                } catch (Exception e3) {
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                AppMethodBeat.o(78692);
                return hashMap;
            } catch (Throwable th3) {
                th = th3;
                ab.e("MicroMsg.ClickFlowStatReceiver", "readStorage exception: %s [%s]", th.getMessage(), bo.l(th));
                if (objectInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                hashMap = new HashMap();
                AppMethodBeat.o(78692);
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
            AppMethodBeat.o(78692);
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
    private synchronized void a(String str, HashMap<Long, ArrayList<b>> hashMap) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(78693);
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            long anU = bo.anU();
            fileOutputStream = new FileOutputStream(str);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(hashMap);
                    fileOutputStream.flush();
                    ab.i("MicroMsg.ClickFlowStatReceiver", "writeStorage count:%d time:%d", Integer.valueOf(hashMap.size()), Long.valueOf(bo.gb(anU)));
                    try {
                        objectOutputStream.close();
                    } catch (Exception e2) {
                    }
                    try {
                        fileOutputStream.close();
                        AppMethodBeat.o(78693);
                    } catch (Exception e3) {
                        AppMethodBeat.o(78693);
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        ab.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bo.l(e));
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
                                AppMethodBeat.o(78693);
                            }
                        }
                        AppMethodBeat.o(78693);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(78693);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                objectOutputStream = null;
                ab.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bo.l(e));
                if (objectOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(78693);
                return;
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                if (objectOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(78693);
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            objectOutputStream = null;
            fileOutputStream = null;
            ab.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bo.l(e));
            if (objectOutputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            AppMethodBeat.o(78693);
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
            AppMethodBeat.o(78693);
            throw th;
        }
        return;
    }

    private static void b(int i, String str, int i2, String str2) {
        AppMethodBeat.i(78694);
        try {
            String replace = str2.replace(",", ";");
            int ceil = (int) Math.ceil(((double) replace.length()) / 6000.0d);
            for (int i3 = 0; i3 < ceil; i3++) {
                ab.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", Integer.valueOf(i), str, str + "," + i2 + "," + i3 + "," + ceil + ",0,0,," + replace.substring(i3 * 6000, Math.min((i3 + 1) * 6000, replace.length())));
                e.pXa.a(346, 4, 1, false);
                e.pXa.a(i, r11, true, true);
            }
            AppMethodBeat.o(78694);
        } catch (Exception e) {
            x(15009, bo.l(e));
            ab.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", bo.l(e));
            AppMethodBeat.o(78694);
        }
    }

    private static String fQ(long j) {
        AppMethodBeat.i(78695);
        String format;
        if (j < 100000000000L) {
            format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j * 1000));
            AppMethodBeat.o(78695);
            return format;
        }
        format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j)) + String.format(Locale.getDefault(), ".%03d", new Object[]{Long.valueOf(j % 1000)});
        AppMethodBeat.o(78695);
        return format;
    }

    private static String cc(Context context) {
        int i;
        AppMethodBeat.i(78696);
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
            AppMethodBeat.o(78696);
            return str;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    str = "";
                    AppMethodBeat.o(78696);
                    return str;
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.o(78696);
                        return null;
                    }
                    str = componentName.getClassName();
                    if (str.contains(".")) {
                        str = str.substring(str.lastIndexOf(".") + 1);
                    }
                    AppMethodBeat.o(78696);
                    return str;
                }
                str = "";
                AppMethodBeat.o(78696);
                return str;
            }
            str = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (str.contains(".")) {
                str = str.substring(str.lastIndexOf(".") + 1);
            }
            AppMethodBeat.o(78696);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", e.getMessage(), bo.l(e));
        }
    }

    static /* synthetic */ void a(c cVar, int i, String str, int i2, long j, long j2) {
        AppMethodBeat.i(78699);
        long anU = bo.anU();
        if (TextUtils.isEmpty(str) || j > anU) {
            ab.e("MicroMsg.ClickFlowStatReceiver", "writeToList page:%s  start - time = %d", str, Long.valueOf(anU - j));
            AppMethodBeat.o(78699);
            return;
        }
        b bVar = new b();
        bVar.czE = i;
        bVar.fRQ = str.contains(".") ? str.substring(str.lastIndexOf(".") + 1) : str;
        if (3 == i && ((cVar.fRE || (cVar.fRF.containsKey(bVar.fRQ) && ((Boolean) cVar.fRF.get(bVar.fRQ)).booleanValue())) && !AccessibilityCapture.isEnable())) {
            Object obj = (com.tencent.mm.protocal.d.vxi == null || !com.tencent.mm.protocal.d.vxi.toLowerCase().startsWith("samsung")) ? null : 1;
            if (obj != null) {
                int i3 = 0;
                if (ah.bqo() && g.RQ().eKs && g.RN().QY()) {
                    g.RN();
                    if (!com.tencent.mm.kernel.a.QT()) {
                        g.RN();
                        i3 = com.tencent.mm.kernel.a.QF();
                    }
                }
                if (i3 != 0) {
                    a((long) i3, 0.01f, cVar.fRH);
                }
            }
        }
        if (5 == i || 6 == i) {
            bVar.czE = 4;
        } else if (!(3 == i || 4 == i)) {
            ab.i("MicroMsg.ClickFlowStatReceiver", "writeToList error opCode:%d  (%s)", Integer.valueOf(i), str);
            AppMethodBeat.o(78699);
            return;
        }
        bVar.time = j;
        bVar.elapsedTime = j2;
        cVar.fRA.add(bVar);
        ab.i("MicroMsg.ClickFlowStatReceiver", "ActivityState op:%d time:%s 0x%x %s useTime:%d", Integer.valueOf(bVar.czE), fQ(bVar.time), Integer.valueOf(i2), bVar.fRQ, Long.valueOf(bo.gb(anU)));
        if (bVar.czE == 3) {
            cVar.fRy.stopTimer();
            AppMethodBeat.o(78699);
            return;
        }
        if (bVar.czE == 4) {
            cVar.fRy.stopTimer();
            cVar.fRy.ae(5000, 5000);
        }
        AppMethodBeat.o(78699);
    }
}
