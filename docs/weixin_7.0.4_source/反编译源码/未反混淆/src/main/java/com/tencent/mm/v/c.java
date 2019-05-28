package com.tencent.mm.v;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c implements b {
    public static final a eAN = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
    public static final class b implements com.tencent.mm.u.b.a {
        final /* synthetic */ e eAO;
        final /* synthetic */ d eAP;
        final /* synthetic */ f eAQ;
        final /* synthetic */ com.tencent.mm.api.l eAR;

        b(e eVar, d dVar, f fVar, com.tencent.mm.api.l lVar) {
            this.eAO = eVar;
            this.eAP = dVar;
            this.eAQ = fVar;
            this.eAR = lVar;
        }

        public final void b(f fVar) {
            AppMethodBeat.i(35476);
            j.p(fVar, "item");
            ab.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(fVar)));
            if (fVar.getStatus() == -1) {
                this.eAO.a(-1, fVar, this.eAP.eAI);
            }
            AppMethodBeat.o(35476);
        }

        public final void a(f fVar) {
            AppMethodBeat.i(35477);
            j.p(fVar, "item");
            ab.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(fVar)));
            if (fVar.An() > cb.aaD() / 1000) {
                this.eAO.a(101, fVar, this.eAP.eAI);
                AppMethodBeat.o(35477);
                return;
            }
            ab.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + this.eAQ.Ai());
            this.eAR.a(fVar.Ai(), fVar, fVar.Al());
            AppMethodBeat.o(35477);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/executor/OpDelayExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(35480);
        AppMethodBeat.o(35480);
    }

    public final void a(e eVar, com.tencent.mm.api.l lVar, ba baVar, f fVar, f fVar2, long j) {
        AppMethodBeat.i(35478);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(baVar, "storage");
        j.p(fVar, "newFunctionMsgItem");
        if (fVar2 != null) {
            fVar.be(true);
            fVar2.aH(fVar2.getVersion());
            fVar2.aG(fVar.getVersion());
            if (0 < fVar.An()) {
                fVar2.aJ(fVar.An() + fVar.Am());
            } else {
                fVar2.aJ(fVar2.An() + fVar.Am());
            }
            fVar2.cF(fVar.Ak());
            String Ai = fVar2.Ai();
            j.o(Ai, "oldFunctionMsgItem!!.functionMsgId");
            ba.a(Ai, fVar2);
            ab.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + fVar.Ai() + ", op delay! update the exist one, new ActionTime:" + fVar.An() + " new delay:" + fVar.Am() + " reslt:" + fVar2);
            eVar.a(101, fVar2, this);
            AppMethodBeat.o(35478);
            return;
        }
        ab.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(fVar)));
        AppMethodBeat.o(35478);
    }

    public final void a(e eVar, com.tencent.mm.api.l lVar, d dVar) {
        AppMethodBeat.i(35479);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(dVar, "task");
        f fVar = dVar.eAH;
        if (fVar.getStatus() == -1) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(fVar);
            new com.tencent.mm.u.b(linkedList, lVar, new b(eVar, dVar, fVar, lVar)).Pn();
            AppMethodBeat.o(35479);
            return;
        }
        if (fVar.getStatus() == 2 || fVar.getStatus() == -2) {
            ab.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + fVar.Ai() + " actionTime:" + fVar.An());
            if (fVar.An() <= cb.aaD() / 1000) {
                lVar.a(fVar.Ai(), fVar, fVar.Al());
                AppMethodBeat.o(35479);
                return;
            }
            eVar.a(fVar.Ah(), fVar, dVar.eAI);
        }
        AppMethodBeat.o(35479);
    }
}
