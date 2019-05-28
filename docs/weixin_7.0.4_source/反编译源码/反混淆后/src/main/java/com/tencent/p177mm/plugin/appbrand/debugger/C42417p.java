package com.tencent.p177mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.p097v8.V8Inspector;
import com.eclipsesource.p097v8.V8Inspector.JsInspectorChannelServer;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1184r;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.debugger.C38177u.C381787;
import com.tencent.p177mm.protocal.protobuf.cqn;
import com.tencent.p177mm.protocal.protobuf.cqo;
import com.tencent.p177mm.protocal.protobuf.cqp;
import com.tencent.p177mm.protocal.protobuf.cqq;
import com.tencent.p177mm.protocal.protobuf.cqs;
import com.tencent.p177mm.protocal.protobuf.cqt;
import com.tencent.p177mm.protocal.protobuf.cqw;
import com.tencent.p177mm.protocal.protobuf.cqy;
import com.tencent.p177mm.protocal.protobuf.cra;
import com.tencent.p177mm.protocal.protobuf.crc;
import com.tencent.p177mm.protocal.protobuf.crd;
import com.tencent.p177mm.protocal.protobuf.cre;
import com.tencent.p177mm.protocal.protobuf.crg;
import com.tencent.p177mm.protocal.protobuf.crj;
import com.tencent.p177mm.protocal.protobuf.crp;
import com.tencent.p177mm.protocal.protobuf.crq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.p */
public final class C42417p {
    private static final Map<String, String[]> hkk;
    C42411l hjR;
    C10188s hjT;
    C38177u hjW;
    private C4993ae<Integer, Long> hkl = new C4993ae(100);
    private boolean hkm = false;
    private long hkn;
    private LinkedList<C42416o> hko = new LinkedList();
    private final int hkp = 5000;
    private int hkq = 0;
    private long hkr = 0;
    Timer mTimer;

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.p$4 */
    class C21234 extends TimerTask {
        C21234() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101860);
            if (C42417p.this.hjR.isBusy() && C42417p.this.azl()) {
                C4990ab.m7416i("MicroMsg.RemoteDebugMsgMrg", "testServer");
            } else {
                C42417p.this.azk();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - C42417p.this.hjR.hjx >= 10000) {
                    C42417p c42417p = C42417p.this;
                    C1331a crj = new crj();
                    crj.xoU = c42417p.hjR.hjo;
                    crj.xoV = c42417p.hjR.ayZ();
                    c42417p.hjT.mo21583a(C26852t.m42762a(1001, crj));
                }
                if (C42417p.this.hjR.isReady() && currentTimeMillis - C42417p.this.hjR.hjy >= 30000) {
                    C42417p.this.mo67950cV(C42417p.this.hjR.ayZ(), BaseClientBuilder.API_PRIORITY_OTHER);
                }
            }
            C5004al.m7441d(new C381787());
            AppMethodBeat.m2505o(101860);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.p$2 */
    class C191672 implements Comparator<cqt> {
        C191672() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            cqt cqt = (cqt) obj;
            cqt cqt2 = (cqt) obj2;
            if (cqt == null || cqt2 == null) {
                return 0;
            }
            return cqt.fQi - cqt2.fQi;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.p$3 */
    class C331403 implements Runnable {
        C331403() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101859);
            LinkedList linkedList = new LinkedList();
            synchronized (C42417p.this.hjR.mLock) {
                try {
                    linkedList.addAll(C42417p.this.hko);
                    C42417p.this.hko.clear();
                    C42417p.this.hkm = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(101859);
                }
            }
            C42417p.m75108a(C42417p.this, linkedList);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.p$1 */
    class C424181 implements JsInspectorChannelServer {
        C424181() {
        }

        public final int sendData(long j, String str) {
            AppMethodBeat.m2504i(101858);
            C42417p.m75107a(C42417p.this, j, str);
            AppMethodBeat.m2505o(101858);
            return 0;
        }

        public final int notify(long j, long j2, String str) {
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(101889);
        HashMap hashMap = new HashMap();
        hkk = hashMap;
        hashMap.put("publishHandler", new String[]{"String", "String", "String"});
        hkk.put("invokeHandler", new String[]{"String", "String", "Number"});
        AppMethodBeat.m2505o(101889);
    }

    public C42417p() {
        AppMethodBeat.m2504i(101861);
        V8Inspector.setServer(new C424181());
        AppMethodBeat.m2505o(101861);
    }

    /* renamed from: a */
    public final void mo67944a(C10188s c10188s, C42411l c42411l, C38177u c38177u) {
        this.hjT = c10188s;
        this.hjR = c42411l;
        this.hjW = c38177u;
    }

    /* renamed from: a */
    public static void m75115a(cre cre) {
        AppMethodBeat.m2504i(101862);
        cre.xot = "WeixinJSCore";
        for (String str : hkk.keySet()) {
            if (((String[]) hkk.get(str)).length > 5) {
                C4990ab.m7412e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
            } else {
                cra cra = new cra();
                cra.xou = str;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= ((String[]) hkk.get(str)).length) {
                        break;
                    }
                    cra.xov.add(((String[]) hkk.get(str))[i2]);
                    i = i2 + 1;
                }
                cre.xoN.add(cra);
            }
        }
        AppMethodBeat.m2505o(101862);
    }

    /* renamed from: a */
    private void m75110a(cqo cqo) {
        AppMethodBeat.m2504i(101863);
        C4990ab.m7417i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", cqo.xou, Integer.valueOf(cqo.xow));
        String str = cqo.xou;
        LinkedList linkedList = cqo.xov;
        if (hkk.containsKey(str)) {
            String[] strArr = (String[]) hkk.get(str);
            if (linkedList.size() < strArr.length) {
                C4990ab.m7420w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
                AppMethodBeat.m2505o(101863);
                return;
            }
            int i;
            Object obj;
            LinkedList linkedList2 = new LinkedList();
            for (i = 0; i < strArr.length; i++) {
                if ("Number".equals(strArr[i])) {
                    linkedList2.add(Integer.valueOf((String) linkedList.get(i)));
                } else if ("Boolean".equals(strArr[i])) {
                    linkedList2.add(Boolean.valueOf((String) linkedList.get(i)));
                } else {
                    linkedList2.add(linkedList.get(i));
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            i = -1;
            switch (str.hashCode()) {
                case 574772027:
                    if (str.equals("publishHandler")) {
                        i = 0;
                        break;
                    }
                    break;
                case 810169266:
                    if (str.equals("invokeHandler")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    this.hjR.hjn.mo6109a((String) String.class.cast(linkedList2.get(0)), (String) String.class.cast(linkedList2.get(1)), C42417p.m75123zL((String) String.class.cast(linkedList2.get(2))));
                    obj = null;
                    break;
                case 1:
                    obj = this.hjR.hjn.mo53814n((String) String.class.cast(linkedList2.get(0)), (String) String.class.cast(linkedList2.get(1)), ((Integer) Integer.class.cast(linkedList2.get(2))).intValue());
                    break;
                default:
                    C4990ab.m7420w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
                    AppMethodBeat.m2505o(101863);
                    return;
            }
            String valueOf = String.valueOf(obj);
            if (!C5046bo.isNullOrNil(valueOf)) {
                mo67942L(cqo.xow, valueOf);
            }
            C26851q.m42759a(str, linkedList, currentTimeMillis, cqo.computeSize(), valueOf == null ? 0 : valueOf.length());
            AppMethodBeat.m2505o(101863);
            return;
        }
        C4990ab.m7420w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
        AppMethodBeat.m2505o(101863);
    }

    /* renamed from: L */
    public final void mo67942L(int i, String str) {
        AppMethodBeat.m2504i(101864);
        cqp cqp = new cqp();
        cqp.xow = i;
        cqp.cBp = str;
        mo67943a(C26852t.m42761a(cqp, this.hjR, "callInterfaceResult"));
        AppMethodBeat.m2505o(101864);
    }

    private synchronized void azi() {
        AppMethodBeat.m2504i(101865);
        int i = 0;
        while (i < this.hjR.hjH.size()) {
            int ayZ = i == 0 ? this.hjR.ayZ() : ((cqt) this.hjR.hjH.get(i - 1)).fQi;
            int i2 = ((cqt) this.hjR.hjH.get(i)).fQi;
            if (ayZ - i2 != 1) {
                mo67950cV(ayZ + 1, i2 - 1);
            }
            i++;
        }
        AppMethodBeat.m2505o(101865);
    }

    /* renamed from: cV */
    public final void mo67950cV(int i, int i2) {
        AppMethodBeat.m2504i(101866);
        C4990ab.m7417i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i > i2) {
            AppMethodBeat.m2505o(101866);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hkl.get(Integer.valueOf(i)) == null || currentTimeMillis - ((Long) this.hkl.get(Integer.valueOf(i))).longValue() >= 3000) {
            this.hkl.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            C1331a crq = new crq();
            crq.xoU = this.hjR.hjo;
            crq.xph = i;
            crq.xpi = i2;
            this.hjT.mo21583a(C26852t.m42762a(1005, crq));
            this.hjR.hjy = System.currentTimeMillis();
            AppMethodBeat.m2505o(101866);
            return;
        }
        C4990ab.m7416i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
        AppMethodBeat.m2505o(101866);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: u */
    public final void mo67953u(LinkedList<cqt> linkedList) {
        AppMethodBeat.m2504i(101867);
        if (C5046bo.m7548ek(linkedList)) {
            C4990ab.m7420w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
            AppMethodBeat.m2505o(101867);
            return;
        }
        Iterator it = m75121v(linkedList).iterator();
        while (it.hasNext()) {
            byte[] B;
            cqt cqt = (cqt) it.next();
            if (C26852t.m42768nJ(cqt.wWK)) {
                B = C1184r.m2612B(cqt.wdt.f1226wR);
            } else {
                B = cqt.wdt.f1226wR;
            }
            String str = cqt.category;
            int i = -1;
            switch (str.hashCode()) {
                case -1680221061:
                    if (str.equals("callInterface")) {
                        i = 0;
                        break;
                    }
                    break;
                case -217209181:
                    if (str.equals("evaluateJavascriptResult")) {
                        i = 1;
                        break;
                    }
                    break;
                case 3441010:
                    if (str.equals("ping")) {
                        i = 2;
                        break;
                    }
                    break;
                case 52537216:
                    if (str.equals("chromeDevtools")) {
                        i = 5;
                        break;
                    }
                    break;
                case 95766211:
                    if (str.equals("domOp")) {
                        i = 4;
                        break;
                    }
                    break;
                case 1319027697:
                    if (str.equals("breakpoint")) {
                        i = 3;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    m75110a((cqo) new cqo().parseFrom(B));
                    break;
                case 1:
                    m75113a((cqy) new cqy().parseFrom(B));
                    break;
                case 2:
                    m75114a((crc) new crc().parseFrom(B));
                    break;
                case 3:
                    m75109a((cqn) new cqn().parseFrom(B));
                    break;
                case 4:
                    m75112a((cqw) new cqw().parseFrom(B));
                    break;
                case 5:
                    C42417p.m75111a((cqq) new cqq().parseFrom(B));
                    break;
                default:
                    break;
            }
        }
        C4990ab.m7417i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.hjR.ayZ()));
        this.hjR.mo67935nI(linkedList.size());
        azi();
        AppMethodBeat.m2505o(101867);
    }

    /* renamed from: v */
    private synchronized LinkedList<cqt> m75121v(LinkedList<cqt> linkedList) {
        LinkedList<cqt> linkedList2;
        AppMethodBeat.m2504i(101868);
        if (linkedList == null) {
            linkedList2 = null;
            AppMethodBeat.m2505o(101868);
        } else {
            LinkedList<cqt> linkedList3 = new LinkedList();
            LinkedList linkedList4 = new LinkedList();
            this.hjR.hjH.addAll(linkedList);
            Collections.sort(this.hjR.hjH, new C191672());
            int ayZ = this.hjR.ayZ();
            Iterator it = this.hjR.hjH.iterator();
            int i = ayZ;
            while (it.hasNext()) {
                cqt cqt = (cqt) it.next();
                if (cqt != null) {
                    if (cqt.fQi > i) {
                        if (cqt.fQi - i != 1) {
                            break;
                        }
                        linkedList3.add(cqt);
                        i = cqt.fQi;
                    } else {
                        linkedList4.add(cqt);
                    }
                }
            }
            this.hjR.mo67933nG(i);
            this.hjR.hjH.removeAll(linkedList3);
            this.hjR.hjH.removeAll(linkedList4);
            C4990ab.m7411d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", Integer.valueOf(linkedList3.size()));
            AppMethodBeat.m2505o(101868);
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    /* renamed from: a */
    private void m75109a(cqn cqn) {
        AppMethodBeat.m2504i(101869);
        if (this.hjR.azb() == cqn.xos) {
            AppMethodBeat.m2505o(101869);
            return;
        }
        if (cqn.xos) {
            this.hjR.mo67930dK(true);
        } else {
            this.hjR.mo67930dK(false);
        }
        this.hjW.azs();
        this.hjW.azv();
        AppMethodBeat.m2505o(101869);
    }

    /* renamed from: a */
    private void m75112a(cqw cqw) {
        AppMethodBeat.m2504i(101870);
        C4990ab.m7410d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
        if (cqw.xoH != this.hjR.hjn.mo34954xL().asV().getCurrentPage().getCurrentPageView().hashCode()) {
            C4990ab.m7421w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", Integer.valueOf(cqw.xoH), Integer.valueOf(this.hjR.hjn.mo34954xL().asV().getCurrentPage().getCurrentPageView().hashCode()));
            AppMethodBeat.m2505o(101870);
            return;
        }
        this.hjR.hjn.mo6109a("remoteDebugCommand", cqw.xoG, null);
        AppMethodBeat.m2505o(101870);
    }

    /* renamed from: a */
    private static void m75111a(cqq cqq) {
        AppMethodBeat.m2504i(101871);
        V8Inspector.onReceiveData(cqq.xox, cqq.wyn);
        AppMethodBeat.m2505o(101871);
    }

    /* renamed from: a */
    private void m75114a(crc crc) {
        AppMethodBeat.m2504i(101872);
        crd crd = new crd();
        crd.xoL = crc.xoL;
        crd.xoM = C26851q.azq();
        C4990ab.m7417i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", Integer.valueOf(crd.xoM));
        mo67943a(C26852t.m42761a(crd, this.hjR, "pong"));
        AppMethodBeat.m2505o(101872);
    }

    /* renamed from: a */
    private void m75113a(cqy cqy) {
        AppMethodBeat.m2504i(101873);
        C4990ab.m7417i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", Integer.valueOf(cqy.xoI));
        int i = cqy.xoI;
        String str = cqy.cBp;
        C26846b c26846b = (C26846b) this.hjR.hjI.remove(Integer.valueOf(i));
        if (c26846b == null) {
            AppMethodBeat.m2505o(101873);
            return;
        }
        ValueCallback valueCallback = c26846b.hje;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(str);
        }
        C4990ab.m7410d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
        C26851q.m42757a(c26846b, cqy.computeSize());
        AppMethodBeat.m2505o(101873);
    }

    /* renamed from: a */
    public final void mo67943a(C42416o c42416o) {
        AppMethodBeat.m2504i(101874);
        if (!this.hjR.aze()) {
            synchronized (this.hjR.mLock) {
                try {
                    if (System.currentTimeMillis() - this.hjR.hjv <= 16 || this.hkm) {
                        this.hko.add(c42416o);
                        azj();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(101874);
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(c42416o);
        m75116a(linkedList, true);
        AppMethodBeat.m2505o(101874);
    }

    /* JADX WARNING: Missing block: B:17:0x0035, code skipped:
            r0 = (int) (16 - (java.lang.System.currentTimeMillis() - r9.hjR.hjv));
     */
    /* JADX WARNING: Missing block: B:18:0x0042, code skipped:
            if (r0 <= 0) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:19:0x0044, code skipped:
            com.tencent.p177mm.plugin.appbrand.p329s.C42677e.aNS().mo10310m(new com.tencent.p177mm.plugin.appbrand.debugger.C42417p.C331403(r9), (long) r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(101875);
     */
    /* JADX WARNING: Missing block: B:24:0x005b, code skipped:
            r0 = 16;
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void azj() {
        AppMethodBeat.m2504i(101875);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hjR.mLock) {
            try {
                if (!this.hkm || currentTimeMillis - this.hkn >= 32) {
                    this.hkn = currentTimeMillis;
                    if (C5046bo.m7548ek(this.hko)) {
                        AppMethodBeat.m2505o(101875);
                        return;
                    }
                    this.hkm = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(101875);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m75116a(LinkedList<C42416o> linkedList, boolean z) {
        AppMethodBeat.m2504i(101876);
        m75117a((LinkedList) linkedList, z, false);
        AppMethodBeat.m2505o(101876);
    }

    /* renamed from: a */
    private synchronized void m75117a(LinkedList<C42416o> linkedList, boolean z, boolean z2) {
        AppMethodBeat.m2504i(101877);
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(101877);
        } else {
            C1331a crg = new crg();
            crg.xoU = this.hjR.hjo;
            crg.xoV = this.hjR.ayZ();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                crg.xoJ.add(((C42416o) it.next()).hka);
            }
            cqs a = C26852t.m42762a(1006, crg);
            if (!this.hjR.isBusy() || z2) {
                C4990ab.m7411d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", Integer.valueOf(linkedList.size()));
                this.hjT.mo21583a(a);
            } else {
                C4990ab.m7410d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
            }
            if (z) {
                m75122w(linkedList);
            }
            C42411l c42411l = this.hjR;
            c42411l.hjv = System.currentTimeMillis();
            c42411l.hjx = System.currentTimeMillis();
            if (!this.hjR.isBusy()) {
                this.hkq = 0;
            }
            C19166k c19166k = new C19166k();
            c19166k.size = a.computeSize();
            c19166k.hjf = System.currentTimeMillis();
            this.hjR.hjG.put(a.eCq, c19166k);
            AppMethodBeat.m2505o(101877);
        }
    }

    /* renamed from: w */
    private synchronized void m75122w(LinkedList<C42416o> linkedList) {
        AppMethodBeat.m2504i(101878);
        C4990ab.m7410d("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(101878);
        } else {
            this.hjR.hjF.addAll(linkedList);
            AppMethodBeat.m2505o(101878);
        }
    }

    public final synchronized void azk() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(101879);
            if (this.hjR.isBusy()) {
                AppMethodBeat.m2505o(101879);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                Iterator it = this.hjR.hjF.iterator();
                while (it.hasNext()) {
                    int i2;
                    C42416o c42416o = (C42416o) it.next();
                    if (currentTimeMillis - c42416o.hjf > 5000) {
                        c42416o.hjf = System.currentTimeMillis();
                        linkedList.add(c42416o);
                        i2 = c42416o.hkb + i;
                        if (((long) i2) >= 65536 || linkedList.size() > 800) {
                            C4990ab.m7417i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                            m75116a(linkedList, false);
                            linkedList.clear();
                            break;
                        }
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                if (!C5046bo.m7548ek(linkedList)) {
                    C4990ab.m7417i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                    m75116a(linkedList, false);
                }
                AppMethodBeat.m2505o(101879);
            }
        }
    }

    public final synchronized boolean azl() {
        boolean z;
        AppMethodBeat.m2504i(101880);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hkr < ((long) this.hkq)) {
            AppMethodBeat.m2505o(101880);
            z = false;
        } else {
            C42416o c42416o;
            this.hkr = currentTimeMillis;
            if (this.hkq < 5000) {
                this.hkq += 1000;
            } else {
                this.hkq = 2000;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.hjR.hjF.iterator();
            while (it.hasNext()) {
                c42416o = (C42416o) it.next();
                if (currentTimeMillis - c42416o.hjf > 5000) {
                    c42416o.hjf = System.currentTimeMillis();
                    linkedList.add(c42416o);
                    m75117a(linkedList, false, true);
                    AppMethodBeat.m2505o(101880);
                    z = true;
                    break;
                }
            }
            if (this.hjR.hjF.size() > 0) {
                c42416o = (C42416o) this.hjR.hjF.get(0);
                c42416o.hjf = System.currentTimeMillis();
                linkedList.add(c42416o);
                m75117a(linkedList, false, true);
                AppMethodBeat.m2505o(101880);
                z = true;
            } else {
                AppMethodBeat.m2505o(101880);
                z = false;
            }
        }
        return z;
    }

    public final void quit() {
        AppMethodBeat.m2504i(101881);
        C4990ab.m7416i("MicroMsg.RemoteDebugMsgMrg", "quit");
        C1331a crp = new crp();
        crp.xoU = this.hjR.hjo;
        this.hjT.mo21583a(C26852t.m42762a(1004, crp));
        AppMethodBeat.m2505o(101881);
    }

    /* Access modifiers changed, original: final */
    public final void azm() {
        AppMethodBeat.m2504i(101882);
        this.hjR.setStatus(4);
        this.hjT.mo21585zN("quit");
        AppMethodBeat.m2505o(101882);
    }

    /* renamed from: cW */
    public final synchronized void mo67951cW(int i, int i2) {
        AppMethodBeat.m2504i(101883);
        C4990ab.m7410d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList linkedList = new LinkedList();
        Iterator it = this.hjR.hjF.iterator();
        while (it.hasNext()) {
            C42416o c42416o = (C42416o) it.next();
            if (c42416o.hka == null) {
                linkedList.add(c42416o);
            } else if (c42416o.hka.fQi >= i && c42416o.hka.fQi <= i2) {
                linkedList.add(c42416o);
            }
        }
        this.hjR.hjF.removeAll(linkedList);
        AppMethodBeat.m2505o(101883);
    }

    public final synchronized void azn() {
        AppMethodBeat.m2504i(101884);
        C4990ab.m7410d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList linkedList = new LinkedList();
        Iterator it = this.hjR.hjF.iterator();
        while (it.hasNext()) {
            C42416o c42416o = (C42416o) it.next();
            if (c42416o.hka == null) {
                linkedList.add(c42416o);
            } else if (c42416o.hka.fQi <= this.hjR.aza()) {
                linkedList.add(c42416o);
            }
        }
        this.hjR.hjF.removeAll(linkedList);
        AppMethodBeat.m2505o(101884);
    }

    public final void azo() {
        AppMethodBeat.m2504i(101885);
        C4990ab.m7416i("MicroMsg.RemoteDebugMsgMrg", "onClose");
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        AppMethodBeat.m2505o(101885);
    }

    /* renamed from: zL */
    private static int[] m75123zL(String str) {
        int i = 0;
        AppMethodBeat.m2504i(101886);
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            while (i < jSONArray.length()) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.RemoteDebugMsgMrg", e.getMessage());
        }
        AppMethodBeat.m2505o(101886);
        return iArr;
    }
}
