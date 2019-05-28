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
import com.tencent.mm.u.e;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/executor/OpUpdateExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class g implements b {
    public static final a eAV = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/executor/OpUpdateExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/executor/OpUpdateExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
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
            AppMethodBeat.i(35492);
            j.p(fVar, "item");
            ab.w("FunctionMsg.OpUpdateExecutor", "[onFailFetch] item:".concat(String.valueOf(fVar)));
            if (fVar.getStatus() == -1) {
                this.eAO.a(-1, fVar, this.eAP.eAI);
            }
            AppMethodBeat.o(35492);
        }

        public final void a(f fVar) {
            AppMethodBeat.i(35493);
            j.p(fVar, "item");
            ab.i("FunctionMsg.OpUpdateExecutor", "[onSuccessFetch] item:".concat(String.valueOf(fVar)));
            if (fVar.An() > cb.aaD() / 1000) {
                this.eAO.a(0, fVar, this.eAP.eAI);
                AppMethodBeat.o(35493);
                return;
            }
            ab.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] to show! id:" + this.eAQ.Ai());
            this.eAR.a(fVar.Ai(), fVar, fVar.Al());
            AppMethodBeat.o(35493);
        }
    }

    static {
        AppMethodBeat.i(35496);
        AppMethodBeat.o(35496);
    }

    public final void a(e eVar, com.tencent.mm.api.l lVar, ba baVar, f fVar, f fVar2, long j) {
        AppMethodBeat.i(35494);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(baVar, "storage");
        j.p(fVar, "newFunctionMsgItem");
        fVar.be(true);
        if (fVar2 == null) {
            ab.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, insert a new one! ".concat(String.valueOf(fVar)));
            baVar.b((c) fVar);
            eVar.a(0, fVar, this);
            AppMethodBeat.o(35494);
        } else if (fVar2.getVersion() < fVar.getVersion()) {
            ab.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, update the exist one! [%s:%s]", fVar, fVar2);
            fVar2.aH(fVar2.getVersion());
            fVar.aH(fVar2.getVersion());
            String Ai = fVar2.Ai();
            j.o(Ai, "oldFunctionMsgItem!!.functionMsgId");
            ba.a(Ai, fVar);
            eVar.a(0, fVar, this);
            AppMethodBeat.o(35494);
        } else {
            if (fVar2.getVersion() >= fVar.getVersion()) {
                ab.e("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor], id:%s old:new [%s:%s]", fVar2.Ai(), Long.valueOf(fVar2.getVersion()), Long.valueOf(fVar.getVersion()));
            }
            AppMethodBeat.o(35494);
        }
    }

    public final void a(e eVar, com.tencent.mm.api.l lVar, d dVar) {
        AppMethodBeat.i(35495);
        j.p(eVar, "timer");
        j.p(lVar, "dispatcher");
        j.p(dVar, "task");
        f fVar = dVar.eAH;
        if (fVar.getStatus() == -1) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(fVar);
            new com.tencent.mm.u.b(linkedList, lVar, new b(eVar, dVar, fVar, lVar)).Pn();
            AppMethodBeat.o(35495);
            return;
        }
        if (fVar.getStatus() == 2 || fVar.getStatus() == -2) {
            ab.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] id" + fVar.Ai() + " actionTime:" + fVar.An());
            if (fVar.An() <= cb.aaD() / 1000) {
                lVar.a(fVar.Ai(), fVar, fVar.Al());
                AppMethodBeat.o(35495);
                return;
            }
            eVar.a(fVar.Ah(), fVar, dVar.eAI);
        }
        AppMethodBeat.o(35495);
    }
}
