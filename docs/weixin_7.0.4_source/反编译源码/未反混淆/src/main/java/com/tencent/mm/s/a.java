package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.api.f;
import com.tencent.mm.api.l;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ba;

public final class a implements l {
    public final void a(String str, f fVar, cm cmVar) {
        boolean z = false;
        AppMethodBeat.i(35446);
        if (fVar == null || cmVar == null) {
            String str2 = "FunctionMsg.FunctionMsgDispatcher";
            String str3 = "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(fVar == null);
            if (cmVar == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Integer.valueOf(cmVar.nao);
            ab.e(str2, str3, objArr);
            AppMethodBeat.o(35446);
            return;
        }
        b(cmVar);
        ab.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s", fVar);
        try {
            long aaD;
            b bVar = new b();
            bVar.fsS = fVar.field_businessInfo;
            bVar.fsT = fVar.field_functionmsgid;
            if (fVar.field_actionTime == 0) {
                aaD = cb.aaD() / 1000;
            } else {
                aaD = fVar.field_actionTime;
            }
            cmVar.pcX = (int) aaD;
            fVar.field_status = 100;
            fVar.a(cmVar);
            ba baVar = ba.xZa;
            ba.a(str, fVar);
            d.bg(Integer.valueOf(cmVar.nao)).b(new com.tencent.mm.ai.e.a(cmVar, bVar));
            AppMethodBeat.o(35446);
        } catch (Exception e) {
            ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e, "", new Object[0]);
            AppMethodBeat.o(35446);
        }
    }

    public final void b(String str, f fVar, cm cmVar) {
        AppMethodBeat.i(35447);
        ab.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", fVar);
        try {
            b(cmVar);
            cmVar.pcX = (int) fVar.field_actionTime;
            fVar.a(cmVar);
            fVar.field_status = 100;
            ba baVar = ba.xZa;
            ba.a(str, fVar);
            d.bg(Integer.valueOf(cmVar.nao)).a(new c(cmVar, str));
            AppMethodBeat.o(35447);
        } catch (Exception e) {
            ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e, "", new Object[0]);
            AppMethodBeat.o(35447);
        }
    }

    public final void b(mk mkVar) {
        AppMethodBeat.i(35448);
        try {
            b bVar = new b();
            com.tencent.mm.ai.d.a.bf(Long.valueOf(mkVar.vQj));
            AppMethodBeat.o(35448);
        } catch (Exception e) {
            ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e, "", new Object[0]);
            AppMethodBeat.o(35448);
        }
    }

    private static cm b(cm cmVar) {
        boolean z = true;
        AppMethodBeat.i(35445);
        if (cmVar == null) {
            AppMethodBeat.o(35445);
            return null;
        }
        String str = "FunctionMsg.FunctionMsgDispatcher";
        String str2 = "processAddMsg, fromUser: %s, msgType: %s, content==null: %s";
        Object[] objArr = new Object[3];
        objArr[0] = cmVar.vEB;
        objArr[1] = Integer.valueOf(cmVar.nao);
        if (cmVar.vED != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        String nullAsNil = bo.nullAsNil(aa.a(cmVar.vEB));
        if ("readerapp".equals(nullAsNil)) {
            cmVar.vEB = aa.vy("newsapp");
            cmVar.nao = 12399999;
        }
        if ("blogapp".equals(nullAsNil) || "newsapp".equals(nullAsNil)) {
            cmVar.nao = 12399999;
        }
        AppMethodBeat.o(35445);
        return cmVar;
    }
}
