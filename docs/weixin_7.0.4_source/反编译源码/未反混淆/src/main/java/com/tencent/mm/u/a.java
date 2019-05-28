package com.tencent.mm.u;

import a.f.b.j;
import a.k.v;
import a.l;
import android.os.SystemClock;
import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.api.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ba;
import com.tencent.mm.v.b;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0016J$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a implements m, h, f {
    private static boolean bZi = true;
    private static long cbv;
    public static final a eAA;
    private static long eAw;
    private static final e eAx;
    private static boolean eAy;
    private static final com.tencent.mm.api.l eAz = new com.tencent.mm.s.a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
    static final class a {
        final cm eAB;
        final Map<String, String> values;

        public a(cm cmVar, Map<String, String> map) {
            j.p(cmVar, "addMsg");
            j.p(map, "values");
            AppMethodBeat.i(35458);
            this.eAB = cmVar;
            this.values = map;
            AppMethodBeat.o(35458);
        }
    }

    static {
        AppMethodBeat.i(35463);
        a aVar = new a();
        eAA = aVar;
        eAx = new e(aVar);
        AppMethodBeat.o(35463);
    }

    private a() {
    }

    public final void Pl() {
        AppMethodBeat.i(35459);
        if (bZi) {
            ab.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
            ba baVar = ba.xZa;
            for (f fVar : ba.dtn()) {
                ab.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", fVar);
                if (fVar.Ah() != -1) {
                    com.tencent.mm.v.a aVar = com.tencent.mm.v.a.eAM;
                    b jo = com.tencent.mm.v.a.jo(fVar.Ah());
                    if (jo != null) {
                        eAx.a(fVar.Ah(), fVar, jo);
                    }
                }
            }
            baVar = ba.xZa;
            ba.dto();
            bZi = false;
        }
        ab.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + bZi);
        AppMethodBeat.o(35459);
    }

    public final void a(cm cmVar, Map<String, String> map) {
        AppMethodBeat.i(35461);
        j.p(cmVar, "addMsg");
        j.p(map, "values");
        int i = bo.getInt((String) map.get(".sysmsg.functionmsg.op"), 0);
        ab.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", Integer.valueOf(cmVar.pcX), Integer.valueOf(i));
        eAy = true;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(cmVar, map);
        Map map2 = aVar.values;
        String str = (String) map2.get(".sysmsg.functionmsg.cgi");
        int i2 = bo.getInt((String) map2.get(".sysmsg.functionmsg.cmdid"), 0);
        String str2 = (String) map2.get(".sysmsg.functionmsg.functionmsgid");
        long j = bo.getLong((String) map2.get(".sysmsg.functionmsg.version"), 0);
        int i3 = bo.getInt((String) map2.get(".sysmsg.functionmsg.op"), 0);
        int i4 = bo.getInt((String) map2.get(".sysmsg.functionmsg.retryinterval"), 0);
        int i5 = bo.getInt((String) map2.get(".sysmsg.functionmsg.reportid"), 0);
        int i6 = bo.getInt((String) map2.get(".sysmsg.functionmsg.successkey"), 0);
        int i7 = bo.getInt((String) map2.get(".sysmsg.functionmsg.failkey"), 0);
        int i8 = bo.getInt((String) map2.get(".sysmsg.functionmsg.finalfailkey"), 0);
        String str3 = (String) map2.get(".sysmsg.functionmsg.custombuff");
        long j2 = bo.getLong((String) map2.get(".sysmsg.functionmsg.businessid"), 0);
        String str4 = (String) map2.get(".sysmsg.functionmsg.businessbuff");
        long j3 = bo.getLong((String) map2.get(".sysmsg.functionmsg.actiontime"), 0);
        long j4 = bo.getLong((String) map2.get(".sysmsg.functionmsg.delaytime"), 0);
        int i9 = bo.getInt((String) map2.get(".sysmsg.functionmsg.retrycount"), 0);
        String str5 = "";
        String a = aa.a(aVar.eAB.vED);
        j.o(a, FirebaseAnalytics.b.CONTENT);
        int a2 = v.a((CharSequence) a, "<addmsg>", 0, false, 6);
        int a3 = v.a((CharSequence) a, "</addmsg>", 0, false, 6) + 9;
        if (a3 <= a2 || a3 == -1 || a2 == -1) {
            a = str5;
        } else {
            String substring = a.substring(a2, a3);
            j.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            a = substring;
        }
        ab.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", Integer.valueOf(i3), str, Integer.valueOf(i2), str2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str3, Long.valueOf(j2), str4, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i9));
        f fVar = new f();
        fVar.ga(i3);
        fVar.cD(str);
        fVar.setCmdId(i2);
        if (str2 == null) {
            j.dWJ();
        }
        fVar.cE(str2);
        fVar.aG(j);
        fVar.setRetryInterval(i4);
        fVar.gb(i5);
        fVar.gc(i6);
        fVar.gd(i7);
        fVar.ge(i8);
        fVar.cF(str3);
        fVar.Ao();
        fVar.a(aVar.eAB);
        fVar.cG(a);
        mk mkVar = new mk();
        mkVar.vQj = j2;
        if (!bo.isNullOrNil(str4)) {
            mkVar.vQk = new com.tencent.mm.bt.b(Base64.decode(str4, 0));
        }
        fVar.a(mkVar);
        fVar.aJ(j3);
        fVar.aI(j4);
        fVar.Ap();
        fVar.gf(i9);
        ba baVar = ba.xZa;
        str = fVar.Ai();
        j.o(str, "item.functionMsgId");
        f apy = ba.apy(str);
        if (apy != null) {
            ab.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", apy);
        } else {
            ab.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", fVar.Ai());
        }
        com.tencent.mm.v.a aVar2 = com.tencent.mm.v.a.eAM;
        b jo = com.tencent.mm.v.a.jo(fVar.Ah());
        if (jo != null) {
            jo.a(eAx, eAz, ba.xZa, fVar, apy, (long) cmVar.pcX);
        }
        ab.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35461);
    }

    public final void a(int i, d dVar) {
        AppMethodBeat.i(35462);
        j.p(dVar, "task");
        ab.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + dVar.eAH.Ai() + " op:" + i + " status:" + dVar.eAH.getStatus());
        dVar.eAI.a(eAx, eAz, dVar);
        AppMethodBeat.o(35462);
    }

    public final void Pm() {
        boolean z;
        Object obj;
        AppMethodBeat.i(35460);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        long Mm = RP.Ry().Mm(8196);
        boolean z2 = (7 & Mm) != 0;
        if (eAy || System.currentTimeMillis() - cbv >= 15000) {
            z = true;
        } else {
            z = false;
        }
        ab.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + Mm + ", isContinueSync:" + z2 + ", isNeedCheck:" + z + ", isNeedCheckSoon:" + eAy);
        if (z2) {
            Mm = SystemClock.uptimeMillis();
        } else {
            Mm = 0;
        }
        eAw = Mm;
        if (0 != eAw) {
            Mm = SystemClock.uptimeMillis();
            if (Mm - eAw >= 1800000) {
                com.tencent.mm.plugin.report.service.h.pYm.a(1021, 0, 1, true);
            } else if (Mm - eAw >= 1200000) {
                com.tencent.mm.plugin.report.service.h.pYm.a(1021, 1, 1, true);
            } else if (Mm - eAw >= 600000) {
                com.tencent.mm.plugin.report.service.h.pYm.a(1021, 2, 1, true);
            }
        }
        if (z2 || !z) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            e eVar = eAx;
            Mm = System.currentTimeMillis();
            eVar.eAK.loop();
            ab.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", Long.valueOf(System.currentTimeMillis() - Mm));
            cbv = System.currentTimeMillis();
            eAy = false;
            ab.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(35460);
    }
}
