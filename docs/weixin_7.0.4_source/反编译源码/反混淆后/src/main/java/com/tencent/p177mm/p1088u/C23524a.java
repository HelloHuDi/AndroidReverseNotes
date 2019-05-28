package com.tencent.p177mm.p1088u;

import android.os.SystemClock;
import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.api.C37463m;
import com.tencent.p177mm.api.C45152l;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1343s.C23482a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p634v.C40918a;
import com.tencent.p177mm.p634v.C44409b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C39366h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40545mk;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40626ba;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0016J$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
/* renamed from: com.tencent.mm.u.a */
public final class C23524a implements C37463m, C39366h, C15449f {
    private static boolean bZi = true;
    private static long cbv;
    public static final C23524a eAA;
    private static long eAw;
    private static final C44231e eAx;
    private static boolean eAy;
    private static final C45152l eAz = new C23482a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
    /* renamed from: com.tencent.mm.u.a$a */
    static final class C15447a {
        final C7254cm eAB;
        final Map<String, String> values;

        public C15447a(C7254cm c7254cm, Map<String, String> map) {
            C25052j.m39376p(c7254cm, "addMsg");
            C25052j.m39376p(map, "values");
            AppMethodBeat.m2504i(35458);
            this.eAB = c7254cm;
            this.values = map;
            AppMethodBeat.m2505o(35458);
        }
    }

    static {
        AppMethodBeat.m2504i(35463);
        C23524a c23524a = new C23524a();
        eAA = c23524a;
        eAx = new C44231e(c23524a);
        AppMethodBeat.m2505o(35463);
    }

    private C23524a() {
    }

    /* renamed from: Pl */
    public final void mo39198Pl() {
        AppMethodBeat.m2504i(35459);
        if (bZi) {
            C4990ab.m7416i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
            C40626ba c40626ba = C40626ba.xZa;
            for (C32248f c32248f : C40626ba.dtn()) {
                C4990ab.m7417i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", c32248f);
                if (c32248f.mo52933Ah() != -1) {
                    C40918a c40918a = C40918a.eAM;
                    C44409b jo = C40918a.m70931jo(c32248f.mo52933Ah());
                    if (jo != null) {
                        eAx.mo69874a(c32248f.mo52933Ah(), c32248f, jo);
                    }
                }
            }
            c40626ba = C40626ba.xZa;
            C40626ba.dto();
            bZi = false;
        }
        C4990ab.m7416i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + bZi);
        AppMethodBeat.m2505o(35459);
    }

    /* renamed from: a */
    public final void mo39200a(C7254cm c7254cm, Map<String, String> map) {
        AppMethodBeat.m2504i(35461);
        C25052j.m39376p(c7254cm, "addMsg");
        C25052j.m39376p(map, "values");
        int i = C5046bo.getInt((String) map.get(".sysmsg.functionmsg.op"), 0);
        C4990ab.m7417i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", Integer.valueOf(c7254cm.pcX), Integer.valueOf(i));
        eAy = true;
        long currentTimeMillis = System.currentTimeMillis();
        C15447a c15447a = new C15447a(c7254cm, map);
        Map map2 = c15447a.values;
        String str = (String) map2.get(".sysmsg.functionmsg.cgi");
        int i2 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.cmdid"), 0);
        String str2 = (String) map2.get(".sysmsg.functionmsg.functionmsgid");
        long j = C5046bo.getLong((String) map2.get(".sysmsg.functionmsg.version"), 0);
        int i3 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.op"), 0);
        int i4 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.retryinterval"), 0);
        int i5 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.reportid"), 0);
        int i6 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.successkey"), 0);
        int i7 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.failkey"), 0);
        int i8 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.finalfailkey"), 0);
        String str3 = (String) map2.get(".sysmsg.functionmsg.custombuff");
        long j2 = C5046bo.getLong((String) map2.get(".sysmsg.functionmsg.businessid"), 0);
        String str4 = (String) map2.get(".sysmsg.functionmsg.businessbuff");
        long j3 = C5046bo.getLong((String) map2.get(".sysmsg.functionmsg.actiontime"), 0);
        long j4 = C5046bo.getLong((String) map2.get(".sysmsg.functionmsg.delaytime"), 0);
        int i9 = C5046bo.getInt((String) map2.get(".sysmsg.functionmsg.retrycount"), 0);
        String str5 = "";
        String a = C1946aa.m4148a(c15447a.eAB.vED);
        C25052j.m39375o(a, C8741b.CONTENT);
        int a2 = C31820v.m51518a((CharSequence) a, "<addmsg>", 0, false, 6);
        int a3 = C31820v.m51518a((CharSequence) a, "</addmsg>", 0, false, 6) + 9;
        if (a3 <= a2 || a3 == -1 || a2 == -1) {
            a = str5;
        } else {
            String substring = a.substring(a2, a3);
            C25052j.m39375o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            a = substring;
        }
        C4990ab.m7417i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", Integer.valueOf(i3), str, Integer.valueOf(i2), str2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str3, Long.valueOf(j2), str4, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i9));
        C32248f c32248f = new C32248f();
        c32248f.mo52954ga(i3);
        c32248f.mo52949cD(str);
        c32248f.setCmdId(i2);
        if (str2 == null) {
            C25052j.dWJ();
        }
        c32248f.mo52950cE(str2);
        c32248f.mo52944aG(j);
        c32248f.setRetryInterval(i4);
        c32248f.mo52955gb(i5);
        c32248f.mo52956gc(i6);
        c32248f.mo52957gd(i7);
        c32248f.mo52958ge(i8);
        c32248f.mo52951cF(str3);
        c32248f.mo52940Ao();
        c32248f.mo52942a(c15447a.eAB);
        c32248f.mo52952cG(a);
        C40545mk c40545mk = new C40545mk();
        c40545mk.vQj = j2;
        if (!C5046bo.isNullOrNil(str4)) {
            c40545mk.vQk = new C1332b(Base64.decode(str4, 0));
        }
        c32248f.mo52943a(c40545mk);
        c32248f.mo52947aJ(j3);
        c32248f.mo52946aI(j4);
        c32248f.mo52941Ap();
        c32248f.mo52961gf(i9);
        C40626ba c40626ba = C40626ba.xZa;
        str = c32248f.mo52934Ai();
        C25052j.m39375o(str, "item.functionMsgId");
        C32248f apy = C40626ba.apy(str);
        if (apy != null) {
            C4990ab.m7417i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", apy);
        } else {
            C4990ab.m7417i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", c32248f.mo52934Ai());
        }
        C40918a c40918a = C40918a.eAM;
        C44409b jo = C40918a.m70931jo(c32248f.mo52933Ah());
        if (jo != null) {
            jo.mo39925a(eAx, eAz, C40626ba.xZa, c32248f, apy, (long) c7254cm.pcX);
        }
        C4990ab.m7417i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(35461);
    }

    /* renamed from: a */
    public final void mo27490a(int i, C44230d c44230d) {
        AppMethodBeat.m2504i(35462);
        C25052j.m39376p(c44230d, "task");
        C4990ab.m7416i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + c44230d.eAH.mo52934Ai() + " op:" + i + " status:" + c44230d.eAH.getStatus());
        c44230d.eAI.mo39926a(eAx, eAz, c44230d);
        AppMethodBeat.m2505o(35462);
    }

    /* renamed from: Pm */
    public final void mo39199Pm() {
        boolean z;
        Object obj;
        AppMethodBeat.m2504i(35460);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        long Mm = RP.mo5239Ry().mo16813Mm(8196);
        boolean z2 = (7 & Mm) != 0;
        if (eAy || System.currentTimeMillis() - cbv >= 15000) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7416i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + Mm + ", isContinueSync:" + z2 + ", isNeedCheck:" + z + ", isNeedCheckSoon:" + eAy);
        if (z2) {
            Mm = SystemClock.uptimeMillis();
        } else {
            Mm = 0;
        }
        eAw = Mm;
        if (0 != eAw) {
            Mm = SystemClock.uptimeMillis();
            if (Mm - eAw >= 1800000) {
                C7060h.pYm.mo8378a(1021, 0, 1, true);
            } else if (Mm - eAw >= 1200000) {
                C7060h.pYm.mo8378a(1021, 1, 1, true);
            } else if (Mm - eAw >= 600000) {
                C7060h.pYm.mo8378a(1021, 2, 1, true);
            }
        }
        if (z2 || !z) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            C44231e c44231e = eAx;
            Mm = System.currentTimeMillis();
            c44231e.eAK.loop();
            C4990ab.m7417i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", Long.valueOf(System.currentTimeMillis() - Mm));
            cbv = System.currentTimeMillis();
            eAy = false;
            C4990ab.m7417i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.m2505o(35460);
    }
}
