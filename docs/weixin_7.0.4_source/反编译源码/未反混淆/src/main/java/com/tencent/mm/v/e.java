package com.tencent.mm.v;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.d;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e implements b {
    public static final a eAT = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/executor/OpNoShowExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
    public static final class b implements com.tencent.mm.u.b.a {
        final /* synthetic */ com.tencent.mm.u.e eAO;
        final /* synthetic */ d eAP;

        b(com.tencent.mm.u.e eVar, d dVar) {
            this.eAO = eVar;
            this.eAP = dVar;
        }

        public final void b(f fVar) {
            AppMethodBeat.i(35484);
            j.p(fVar, "item");
            ab.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(fVar)));
            if (fVar.getStatus() == -1) {
                this.eAO.a(-1, fVar, this.eAP.eAI);
            }
            AppMethodBeat.o(35484);
        }

        public final void a(f fVar) {
            AppMethodBeat.i(35485);
            j.p(fVar, "item");
            ab.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(fVar)));
            if (fVar.An() > cb.aaD() / 1000) {
                this.eAO.a(2, fVar, this.eAP.eAI);
            }
            AppMethodBeat.o(35485);
        }
    }

    static {
        AppMethodBeat.i(35488);
        AppMethodBeat.o(35488);
    }

    public final void a(com.tencent.mm.u.e eVar, com.tencent.mm.api.l lVar, ba baVar, f fVar, f fVar2, long j) {
        AppMethodBeat.i(35486);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(baVar, "storage");
        j.p(fVar, "newFunctionMsgItem");
        fVar.be(false);
        if (fVar2 == null) {
            this = this;
            ab.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", fVar);
            baVar.b((c) fVar);
            eVar.a(2, fVar, this);
            AppMethodBeat.o(35486);
        } else if (fVar2.getVersion() < fVar.getVersion()) {
            ab.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", Long.valueOf(fVar2.Aj()), fVar2);
            fVar2.aH(fVar2.getVersion());
            fVar.aH(fVar2.getVersion());
            fVar2.aJ(fVar.An());
            fVar2.cF(fVar.Ak());
            String Ai = fVar2.Ai();
            j.o(Ai, "oldFunctionMsgItem!!.functionMsgId");
            ba.a(Ai, fVar);
            eVar.a(2, fVar, this);
            AppMethodBeat.o(35486);
        } else {
            ab.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
            AppMethodBeat.o(35486);
        }
    }

    public final void a(com.tencent.mm.u.e eVar, com.tencent.mm.api.l lVar, d dVar) {
        AppMethodBeat.i(35487);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(dVar, "task");
        f fVar = dVar.eAH;
        if (fVar.getStatus() == -1) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(fVar);
            new com.tencent.mm.u.b(linkedList, lVar, new b(eVar, dVar)).Pn();
        }
        AppMethodBeat.o(35487);
    }
}
