package com.tencent.mm.u;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0006\u0010\u0013\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c {
    public static final a eAG = new a();
    private final HashMap<String, d> cS = new HashMap();
    private final LinkedList<d> eAF = new LinkedList();
    private final e eAx;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgQueue$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(35467);
        AppMethodBeat.o(35467);
    }

    public c(e eVar) {
        j.p(eVar, "timer");
        AppMethodBeat.i(35466);
        this.eAx = eVar;
        AppMethodBeat.o(35466);
    }

    public final void a(d dVar) {
        String str;
        String str2;
        Object[] objArr;
        Object[] objArr2;
        String str3;
        Object[] objArr3;
        Map map;
        String Ai;
        AppMethodBeat.i(35464);
        j.p(dVar, "task");
        String str4 = null;
        if (this.cS.containsKey(dVar.eAH.Ai())) {
            str4 = (d) this.cS.remove(dVar.eAH.Ai());
        }
        if (str4 != null) {
            int i = 101 == dVar.czW ? 1 : 1 == dVar.czW ? (str4.eAH.getVersion() < dVar.eAH.getVersion() || dVar.eAH.getVersion() == 0) ? 1 : 0 : str4.eAH.getVersion() < dVar.eAH.getVersion() ? 1 : 0;
            if (i != 0) {
                ab.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", str4);
                this.eAF.remove(str4);
                str = "FunctionMsg.FunctionMsgQueue";
                str2 = "[add] add task[%s] old Task[%s]";
                objArr = new Object[2];
                objArr[0] = dVar;
                if (str4 != null || str4 == null) {
                    objArr2 = objArr;
                    str3 = "@null";
                    objArr3 = objArr;
                } else {
                    str3 = str4;
                    objArr3 = objArr;
                    objArr2 = objArr;
                }
                objArr3[1] = str3;
                ab.i(str, str2, objArr2);
                this.eAF.add(dVar);
                map = this.cS;
                Ai = dVar.eAH.Ai();
                j.o(Ai, "task.mItem.functionMsgId");
                map.put(Ai, dVar);
                AppMethodBeat.o(35464);
            }
        }
        if (str4 != null) {
            ab.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", dVar, str4);
            AppMethodBeat.o(35464);
            return;
        }
        str = "FunctionMsg.FunctionMsgQueue";
        str2 = "[add] add task[%s] old Task[%s]";
        objArr = new Object[2];
        objArr[0] = dVar;
        if (str4 != null) {
        }
        objArr2 = objArr;
        str3 = "@null";
        objArr3 = objArr;
        objArr3[1] = str3;
        ab.i(str, str2, objArr2);
        this.eAF.add(dVar);
        map = this.cS;
        Ai = dVar.eAH.Ai();
        j.o(Ai, "task.mItem.functionMsgId");
        map.put(Ai, dVar);
        AppMethodBeat.o(35464);
    }

    public final void loop() {
        AppMethodBeat.i(35465);
        ab.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.eAF.size());
        ListIterator listIterator = this.eAF.listIterator();
        j.o(listIterator, "mList.listIterator()");
        while (listIterator.hasNext()) {
            Object next = listIterator.next();
            j.o(next, "iterator.next()");
            d dVar = (d) next;
            if (dVar.eAH.An() <= cb.aaD() / 1000) {
                listIterator.remove();
                this.cS.remove(dVar.eAH.Ai());
                e eVar = this.eAx;
                j.p(dVar, "task");
                eVar.eAJ.a(dVar.czW, dVar);
            }
        }
        AppMethodBeat.o(35465);
    }
}
