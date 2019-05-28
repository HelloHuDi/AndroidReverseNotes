package com.tencent.mm.v;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f implements b {
    public static final a eAU = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/executor/OpShowExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(35491);
        AppMethodBeat.o(35491);
    }

    public final void a(e eVar, com.tencent.mm.api.l lVar, ba baVar, com.tencent.mm.api.f fVar, com.tencent.mm.api.f fVar2, long j) {
        AppMethodBeat.i(35489);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(baVar, "storage");
        j.p(fVar, "newFunctionMsgItem");
        ab.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(fVar2)));
        fVar.be(true);
        if (fVar2 != null) {
            ab.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show!," + fVar.getVersion() + ", " + fVar2.getVersion() + ',' + (fVar2.Al() == null));
            fVar2.be(true);
            if (fVar2.Al() != null && fVar2.getStatus() == 2) {
                ab.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", Long.valueOf(j));
                cm Al = fVar2.Al();
                if (Al != null) {
                    Al.pcX = (int) (cb.aaD() / 1000);
                }
            }
            fVar2.aJ(fVar.An());
            fVar2.cF(fVar.Ak());
            String Ai = fVar2.Ai();
            j.o(Ai, "oldFunctionMsgItem!!.functionMsgId");
            ba.a(Ai, fVar2);
            eVar.a(3, fVar2, this);
        }
        AppMethodBeat.o(35489);
    }

    public final void a(e eVar, com.tencent.mm.api.l lVar, d dVar) {
        AppMethodBeat.i(35490);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(dVar, "task");
        com.tencent.mm.api.f fVar = dVar.eAH;
        lVar.a(fVar.Ai(), fVar, fVar.Al());
        AppMethodBeat.o(35490);
    }
}
