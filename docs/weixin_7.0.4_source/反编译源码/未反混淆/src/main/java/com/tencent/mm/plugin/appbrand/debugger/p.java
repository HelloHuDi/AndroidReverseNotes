package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.r;
import com.tencent.mm.bt.a;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;

public final class p {
    private static final Map<String, String[]> hkk;
    l hjR;
    s hjT;
    u hjW;
    private ae<Integer, Long> hkl = new ae(100);
    private boolean hkm = false;
    private long hkn;
    private LinkedList<o> hko = new LinkedList();
    private final int hkp = 5000;
    private int hkq = 0;
    private long hkr = 0;
    Timer mTimer;

    static {
        AppMethodBeat.i(101889);
        HashMap hashMap = new HashMap();
        hkk = hashMap;
        hashMap.put("publishHandler", new String[]{"String", "String", "String"});
        hkk.put("invokeHandler", new String[]{"String", "String", "Number"});
        AppMethodBeat.o(101889);
    }

    public p() {
        AppMethodBeat.i(101861);
        V8Inspector.setServer(new JsInspectorChannelServer() {
            public final int sendData(long j, String str) {
                AppMethodBeat.i(101858);
                p.a(p.this, j, str);
                AppMethodBeat.o(101858);
                return 0;
            }

            public final int notify(long j, long j2, String str) {
                return 0;
            }
        });
        AppMethodBeat.o(101861);
    }

    public final void a(s sVar, l lVar, u uVar) {
        this.hjT = sVar;
        this.hjR = lVar;
        this.hjW = uVar;
    }

    public static void a(cre cre) {
        AppMethodBeat.i(101862);
        cre.xot = "WeixinJSCore";
        for (String str : hkk.keySet()) {
            if (((String[]) hkk.get(str)).length > 5) {
                ab.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
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
        AppMethodBeat.o(101862);
    }

    private void a(cqo cqo) {
        AppMethodBeat.i(101863);
        ab.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", cqo.xou, Integer.valueOf(cqo.xow));
        String str = cqo.xou;
        LinkedList linkedList = cqo.xov;
        if (hkk.containsKey(str)) {
            String[] strArr = (String[]) hkk.get(str);
            if (linkedList.size() < strArr.length) {
                ab.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
                AppMethodBeat.o(101863);
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
                    this.hjR.hjn.a((String) String.class.cast(linkedList2.get(0)), (String) String.class.cast(linkedList2.get(1)), zL((String) String.class.cast(linkedList2.get(2))));
                    obj = null;
                    break;
                case 1:
                    obj = this.hjR.hjn.n((String) String.class.cast(linkedList2.get(0)), (String) String.class.cast(linkedList2.get(1)), ((Integer) Integer.class.cast(linkedList2.get(2))).intValue());
                    break;
                default:
                    ab.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
                    AppMethodBeat.o(101863);
                    return;
            }
            String valueOf = String.valueOf(obj);
            if (!bo.isNullOrNil(valueOf)) {
                L(cqo.xow, valueOf);
            }
            q.a(str, linkedList, currentTimeMillis, cqo.computeSize(), valueOf == null ? 0 : valueOf.length());
            AppMethodBeat.o(101863);
            return;
        }
        ab.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
        AppMethodBeat.o(101863);
    }

    public final void L(int i, String str) {
        AppMethodBeat.i(101864);
        cqp cqp = new cqp();
        cqp.xow = i;
        cqp.cBp = str;
        a(t.a(cqp, this.hjR, "callInterfaceResult"));
        AppMethodBeat.o(101864);
    }

    private synchronized void azi() {
        AppMethodBeat.i(101865);
        int i = 0;
        while (i < this.hjR.hjH.size()) {
            int ayZ = i == 0 ? this.hjR.ayZ() : ((cqt) this.hjR.hjH.get(i - 1)).fQi;
            int i2 = ((cqt) this.hjR.hjH.get(i)).fQi;
            if (ayZ - i2 != 1) {
                cV(ayZ + 1, i2 - 1);
            }
            i++;
        }
        AppMethodBeat.o(101865);
    }

    public final void cV(int i, int i2) {
        AppMethodBeat.i(101866);
        ab.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i > i2) {
            AppMethodBeat.o(101866);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.hkl.get(Integer.valueOf(i)) == null || currentTimeMillis - ((Long) this.hkl.get(Integer.valueOf(i))).longValue() >= 3000) {
            this.hkl.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            a crq = new crq();
            crq.xoU = this.hjR.hjo;
            crq.xph = i;
            crq.xpi = i2;
            this.hjT.a(t.a(1005, crq));
            this.hjR.hjy = System.currentTimeMillis();
            AppMethodBeat.o(101866);
            return;
        }
        ab.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
        AppMethodBeat.o(101866);
    }

    /* Access modifiers changed, original: final */
    public final void u(LinkedList<cqt> linkedList) {
        AppMethodBeat.i(101867);
        if (bo.ek(linkedList)) {
            ab.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
            AppMethodBeat.o(101867);
            return;
        }
        Iterator it = v(linkedList).iterator();
        while (it.hasNext()) {
            byte[] B;
            cqt cqt = (cqt) it.next();
            if (t.nJ(cqt.wWK)) {
                B = r.B(cqt.wdt.wR);
            } else {
                B = cqt.wdt.wR;
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
                    a((cqo) new cqo().parseFrom(B));
                    break;
                case 1:
                    a((cqy) new cqy().parseFrom(B));
                    break;
                case 2:
                    a((crc) new crc().parseFrom(B));
                    break;
                case 3:
                    a((cqn) new cqn().parseFrom(B));
                    break;
                case 4:
                    a((cqw) new cqw().parseFrom(B));
                    break;
                case 5:
                    a((cqq) new cqq().parseFrom(B));
                    break;
                default:
                    break;
            }
        }
        ab.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.hjR.ayZ()));
        this.hjR.nI(linkedList.size());
        azi();
        AppMethodBeat.o(101867);
    }

    private synchronized LinkedList<cqt> v(LinkedList<cqt> linkedList) {
        LinkedList<cqt> linkedList2;
        AppMethodBeat.i(101868);
        if (linkedList == null) {
            linkedList2 = null;
            AppMethodBeat.o(101868);
        } else {
            LinkedList<cqt> linkedList3 = new LinkedList();
            LinkedList linkedList4 = new LinkedList();
            this.hjR.hjH.addAll(linkedList);
            Collections.sort(this.hjR.hjH, new Comparator<cqt>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    cqt cqt = (cqt) obj;
                    cqt cqt2 = (cqt) obj2;
                    if (cqt == null || cqt2 == null) {
                        return 0;
                    }
                    return cqt.fQi - cqt2.fQi;
                }
            });
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
            this.hjR.nG(i);
            this.hjR.hjH.removeAll(linkedList3);
            this.hjR.hjH.removeAll(linkedList4);
            ab.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", Integer.valueOf(linkedList3.size()));
            AppMethodBeat.o(101868);
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    private void a(cqn cqn) {
        AppMethodBeat.i(101869);
        if (this.hjR.azb() == cqn.xos) {
            AppMethodBeat.o(101869);
            return;
        }
        if (cqn.xos) {
            this.hjR.dK(true);
        } else {
            this.hjR.dK(false);
        }
        this.hjW.azs();
        this.hjW.azv();
        AppMethodBeat.o(101869);
    }

    private void a(cqw cqw) {
        AppMethodBeat.i(101870);
        ab.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
        if (cqw.xoH != this.hjR.hjn.xL().asV().getCurrentPage().getCurrentPageView().hashCode()) {
            ab.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", Integer.valueOf(cqw.xoH), Integer.valueOf(this.hjR.hjn.xL().asV().getCurrentPage().getCurrentPageView().hashCode()));
            AppMethodBeat.o(101870);
            return;
        }
        this.hjR.hjn.a("remoteDebugCommand", cqw.xoG, null);
        AppMethodBeat.o(101870);
    }

    private static void a(cqq cqq) {
        AppMethodBeat.i(101871);
        V8Inspector.onReceiveData(cqq.xox, cqq.wyn);
        AppMethodBeat.o(101871);
    }

    private void a(crc crc) {
        AppMethodBeat.i(101872);
        crd crd = new crd();
        crd.xoL = crc.xoL;
        crd.xoM = q.azq();
        ab.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", Integer.valueOf(crd.xoM));
        a(t.a(crd, this.hjR, "pong"));
        AppMethodBeat.o(101872);
    }

    private void a(cqy cqy) {
        AppMethodBeat.i(101873);
        ab.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", Integer.valueOf(cqy.xoI));
        int i = cqy.xoI;
        String str = cqy.cBp;
        b bVar = (b) this.hjR.hjI.remove(Integer.valueOf(i));
        if (bVar == null) {
            AppMethodBeat.o(101873);
            return;
        }
        ValueCallback valueCallback = bVar.hje;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(str);
        }
        ab.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str);
        q.a(bVar, cqy.computeSize());
        AppMethodBeat.o(101873);
    }

    public final void a(o oVar) {
        AppMethodBeat.i(101874);
        if (!this.hjR.aze()) {
            synchronized (this.hjR.mLock) {
                try {
                    if (System.currentTimeMillis() - this.hjR.hjv <= 16 || this.hkm) {
                        this.hko.add(oVar);
                        azj();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(101874);
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(oVar);
        a(linkedList, true);
        AppMethodBeat.o(101874);
    }

    /* JADX WARNING: Missing block: B:17:0x0035, code skipped:
            r0 = (int) (16 - (java.lang.System.currentTimeMillis() - r9.hjR.hjv));
     */
    /* JADX WARNING: Missing block: B:18:0x0042, code skipped:
            if (r0 <= 0) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:19:0x0044, code skipped:
            com.tencent.mm.plugin.appbrand.s.e.aNS().m(new com.tencent.mm.plugin.appbrand.debugger.p.AnonymousClass3(r9), (long) r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(101875);
     */
    /* JADX WARNING: Missing block: B:24:0x005b, code skipped:
            r0 = 16;
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void azj() {
        AppMethodBeat.i(101875);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hjR.mLock) {
            try {
                if (!this.hkm || currentTimeMillis - this.hkn >= 32) {
                    this.hkn = currentTimeMillis;
                    if (bo.ek(this.hko)) {
                        AppMethodBeat.o(101875);
                        return;
                    }
                    this.hkm = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(101875);
            }
        }
    }

    private synchronized void a(LinkedList<o> linkedList, boolean z) {
        AppMethodBeat.i(101876);
        a((LinkedList) linkedList, z, false);
        AppMethodBeat.o(101876);
    }

    private synchronized void a(LinkedList<o> linkedList, boolean z, boolean z2) {
        AppMethodBeat.i(101877);
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(101877);
        } else {
            a crg = new crg();
            crg.xoU = this.hjR.hjo;
            crg.xoV = this.hjR.ayZ();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                crg.xoJ.add(((o) it.next()).hka);
            }
            cqs a = t.a(1006, crg);
            if (!this.hjR.isBusy() || z2) {
                ab.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", Integer.valueOf(linkedList.size()));
                this.hjT.a(a);
            } else {
                ab.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
            }
            if (z) {
                w(linkedList);
            }
            l lVar = this.hjR;
            lVar.hjv = System.currentTimeMillis();
            lVar.hjx = System.currentTimeMillis();
            if (!this.hjR.isBusy()) {
                this.hkq = 0;
            }
            k kVar = new k();
            kVar.size = a.computeSize();
            kVar.hjf = System.currentTimeMillis();
            this.hjR.hjG.put(a.eCq, kVar);
            AppMethodBeat.o(101877);
        }
    }

    private synchronized void w(LinkedList<o> linkedList) {
        AppMethodBeat.i(101878);
        ab.d("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(101878);
        } else {
            this.hjR.hjF.addAll(linkedList);
            AppMethodBeat.o(101878);
        }
    }

    public final synchronized void azk() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(101879);
            if (this.hjR.isBusy()) {
                AppMethodBeat.o(101879);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                Iterator it = this.hjR.hjF.iterator();
                while (it.hasNext()) {
                    int i2;
                    o oVar = (o) it.next();
                    if (currentTimeMillis - oVar.hjf > 5000) {
                        oVar.hjf = System.currentTimeMillis();
                        linkedList.add(oVar);
                        i2 = oVar.hkb + i;
                        if (((long) i2) >= 65536 || linkedList.size() > 800) {
                            ab.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                            a(linkedList, false);
                            linkedList.clear();
                            break;
                        }
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                if (!bo.ek(linkedList)) {
                    ab.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                    a(linkedList, false);
                }
                AppMethodBeat.o(101879);
            }
        }
    }

    public final synchronized boolean azl() {
        boolean z;
        AppMethodBeat.i(101880);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hkr < ((long) this.hkq)) {
            AppMethodBeat.o(101880);
            z = false;
        } else {
            o oVar;
            this.hkr = currentTimeMillis;
            if (this.hkq < 5000) {
                this.hkq += 1000;
            } else {
                this.hkq = 2000;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.hjR.hjF.iterator();
            while (it.hasNext()) {
                oVar = (o) it.next();
                if (currentTimeMillis - oVar.hjf > 5000) {
                    oVar.hjf = System.currentTimeMillis();
                    linkedList.add(oVar);
                    a(linkedList, false, true);
                    AppMethodBeat.o(101880);
                    z = true;
                    break;
                }
            }
            if (this.hjR.hjF.size() > 0) {
                oVar = (o) this.hjR.hjF.get(0);
                oVar.hjf = System.currentTimeMillis();
                linkedList.add(oVar);
                a(linkedList, false, true);
                AppMethodBeat.o(101880);
                z = true;
            } else {
                AppMethodBeat.o(101880);
                z = false;
            }
        }
        return z;
    }

    public final void quit() {
        AppMethodBeat.i(101881);
        ab.i("MicroMsg.RemoteDebugMsgMrg", "quit");
        a crp = new crp();
        crp.xoU = this.hjR.hjo;
        this.hjT.a(t.a(1004, crp));
        AppMethodBeat.o(101881);
    }

    /* Access modifiers changed, original: final */
    public final void azm() {
        AppMethodBeat.i(101882);
        this.hjR.setStatus(4);
        this.hjT.zN("quit");
        AppMethodBeat.o(101882);
    }

    public final synchronized void cW(int i, int i2) {
        AppMethodBeat.i(101883);
        ab.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList linkedList = new LinkedList();
        Iterator it = this.hjR.hjF.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (oVar.hka == null) {
                linkedList.add(oVar);
            } else if (oVar.hka.fQi >= i && oVar.hka.fQi <= i2) {
                linkedList.add(oVar);
            }
        }
        this.hjR.hjF.removeAll(linkedList);
        AppMethodBeat.o(101883);
    }

    public final synchronized void azn() {
        AppMethodBeat.i(101884);
        ab.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList linkedList = new LinkedList();
        Iterator it = this.hjR.hjF.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (oVar.hka == null) {
                linkedList.add(oVar);
            } else if (oVar.hka.fQi <= this.hjR.aza()) {
                linkedList.add(oVar);
            }
        }
        this.hjR.hjF.removeAll(linkedList);
        AppMethodBeat.o(101884);
    }

    public final void azo() {
        AppMethodBeat.i(101885);
        ab.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        AppMethodBeat.o(101885);
    }

    private static int[] zL(String str) {
        int i = 0;
        AppMethodBeat.i(101886);
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            while (i < jSONArray.length()) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.RemoteDebugMsgMrg", e.getMessage());
        }
        AppMethodBeat.o(101886);
        return iArr;
    }
}
