package com.tencent.p177mm.p1343s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.api.C45152l;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p183ai.C37443d.C17888a;
import com.tencent.p177mm.p183ai.C37443d.C37444b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C40545mk;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40626ba;

/* renamed from: com.tencent.mm.s.a */
public final class C23482a implements C45152l {
    /* renamed from: a */
    public final void mo39138a(String str, C32248f c32248f, C7254cm c7254cm) {
        boolean z = false;
        AppMethodBeat.m2504i(35446);
        if (c32248f == null || c7254cm == null) {
            String str2 = "FunctionMsg.FunctionMsgDispatcher";
            String str3 = "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(c32248f == null);
            if (c7254cm == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Integer.valueOf(c7254cm.nao);
            C4990ab.m7413e(str2, str3, objArr);
            AppMethodBeat.m2505o(35446);
            return;
        }
        C23482a.m36312b(c7254cm);
        C4990ab.m7417i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s", c32248f);
        try {
            long aaD;
            C37444b c37444b = new C37444b();
            c37444b.fsS = c32248f.field_businessInfo;
            c37444b.fsT = c32248f.field_functionmsgid;
            if (c32248f.field_actionTime == 0) {
                aaD = C1839cb.aaD() / 1000;
            } else {
                aaD = c32248f.field_actionTime;
            }
            c7254cm.pcX = (int) aaD;
            c32248f.field_status = 100;
            c32248f.mo52942a(c7254cm);
            C40626ba c40626ba = C40626ba.xZa;
            C40626ba.m70154a(str, c32248f);
            C1200d.m2638bg(Integer.valueOf(c7254cm.nao)).mo4453b(new C1197a(c7254cm, c37444b));
            AppMethodBeat.m2505o(35446);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e, "", new Object[0]);
            AppMethodBeat.m2505o(35446);
        }
    }

    /* renamed from: b */
    public final void mo39140b(String str, C32248f c32248f, C7254cm c7254cm) {
        AppMethodBeat.m2504i(35447);
        C4990ab.m7417i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", c32248f);
        try {
            C23482a.m36312b(c7254cm);
            c7254cm.pcX = (int) c32248f.field_actionTime;
            c32248f.mo52942a(c7254cm);
            c32248f.field_status = 100;
            C40626ba c40626ba = C40626ba.xZa;
            C40626ba.m70154a(str, c32248f);
            C1200d.m2638bg(Integer.valueOf(c7254cm.nao)).mo4452a(new C1199c(c7254cm, str));
            AppMethodBeat.m2505o(35447);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e, "", new Object[0]);
            AppMethodBeat.m2505o(35447);
        }
    }

    /* renamed from: b */
    public final void mo39139b(C40545mk c40545mk) {
        AppMethodBeat.m2504i(35448);
        try {
            C37444b c37444b = new C37444b();
            C17888a.m28062bf(Long.valueOf(c40545mk.vQj));
            AppMethodBeat.m2505o(35448);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e, "", new Object[0]);
            AppMethodBeat.m2505o(35448);
        }
    }

    /* renamed from: b */
    private static C7254cm m36312b(C7254cm c7254cm) {
        boolean z = true;
        AppMethodBeat.m2504i(35445);
        if (c7254cm == null) {
            AppMethodBeat.m2505o(35445);
            return null;
        }
        String str = "FunctionMsg.FunctionMsgDispatcher";
        String str2 = "processAddMsg, fromUser: %s, msgType: %s, content==null: %s";
        Object[] objArr = new Object[3];
        objArr[0] = c7254cm.vEB;
        objArr[1] = Integer.valueOf(c7254cm.nao);
        if (c7254cm.vED != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        String nullAsNil = C5046bo.nullAsNil(C1946aa.m4148a(c7254cm.vEB));
        if ("readerapp".equals(nullAsNil)) {
            c7254cm.vEB = C1946aa.m4154vy("newsapp");
            c7254cm.nao = 12399999;
        }
        if ("blogapp".equals(nullAsNil) || "newsapp".equals(nullAsNil)) {
            c7254cm.nao = 12399999;
        }
        AppMethodBeat.m2505o(35445);
        return c7254cm;
    }
}
