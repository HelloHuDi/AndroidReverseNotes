package com.tencent.p177mm.p1088u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0006\u0010\u0013\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
/* renamed from: com.tencent.mm.u.c */
public final class C44229c {
    public static final C36005a eAG = new C36005a();
    /* renamed from: cS */
    private final HashMap<String, C44230d> f17243cS = new HashMap();
    private final LinkedList<C44230d> eAF = new LinkedList();
    private final C44231e eAx;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgQueue$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    /* renamed from: com.tencent.mm.u.c$a */
    public static final class C36005a {
        private C36005a() {
        }

        public /* synthetic */ C36005a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(35467);
        AppMethodBeat.m2505o(35467);
    }

    public C44229c(C44231e c44231e) {
        C25052j.m39376p(c44231e, "timer");
        AppMethodBeat.m2504i(35466);
        this.eAx = c44231e;
        AppMethodBeat.m2505o(35466);
    }

    /* renamed from: a */
    public final void mo69870a(C44230d c44230d) {
        String str;
        String str2;
        Object[] objArr;
        Object[] objArr2;
        String str3;
        Object[] objArr3;
        Map map;
        String Ai;
        AppMethodBeat.m2504i(35464);
        C25052j.m39376p(c44230d, "task");
        String str4 = null;
        if (this.f17243cS.containsKey(c44230d.eAH.mo52934Ai())) {
            str4 = (C44230d) this.f17243cS.remove(c44230d.eAH.mo52934Ai());
        }
        if (str4 != null) {
            int i = 101 == c44230d.czW ? 1 : 1 == c44230d.czW ? (str4.eAH.getVersion() < c44230d.eAH.getVersion() || c44230d.eAH.getVersion() == 0) ? 1 : 0 : str4.eAH.getVersion() < c44230d.eAH.getVersion() ? 1 : 0;
            if (i != 0) {
                C4990ab.m7421w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", str4);
                this.eAF.remove(str4);
                str = "FunctionMsg.FunctionMsgQueue";
                str2 = "[add] add task[%s] old Task[%s]";
                objArr = new Object[2];
                objArr[0] = c44230d;
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
                C4990ab.m7417i(str, str2, objArr2);
                this.eAF.add(c44230d);
                map = this.f17243cS;
                Ai = c44230d.eAH.mo52934Ai();
                C25052j.m39375o(Ai, "task.mItem.functionMsgId");
                map.put(Ai, c44230d);
                AppMethodBeat.m2505o(35464);
            }
        }
        if (str4 != null) {
            C4990ab.m7413e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", c44230d, str4);
            AppMethodBeat.m2505o(35464);
            return;
        }
        str = "FunctionMsg.FunctionMsgQueue";
        str2 = "[add] add task[%s] old Task[%s]";
        objArr = new Object[2];
        objArr[0] = c44230d;
        if (str4 != null) {
        }
        objArr2 = objArr;
        str3 = "@null";
        objArr3 = objArr;
        objArr3[1] = str3;
        C4990ab.m7417i(str, str2, objArr2);
        this.eAF.add(c44230d);
        map = this.f17243cS;
        Ai = c44230d.eAH.mo52934Ai();
        C25052j.m39375o(Ai, "task.mItem.functionMsgId");
        map.put(Ai, c44230d);
        AppMethodBeat.m2505o(35464);
    }

    public final void loop() {
        AppMethodBeat.m2504i(35465);
        C4990ab.m7416i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.eAF.size());
        ListIterator listIterator = this.eAF.listIterator();
        C25052j.m39375o(listIterator, "mList.listIterator()");
        while (listIterator.hasNext()) {
            Object next = listIterator.next();
            C25052j.m39375o(next, "iterator.next()");
            C44230d c44230d = (C44230d) next;
            if (c44230d.eAH.mo52939An() <= C1839cb.aaD() / 1000) {
                listIterator.remove();
                this.f17243cS.remove(c44230d.eAH.mo52934Ai());
                C44231e c44231e = this.eAx;
                C25052j.m39376p(c44230d, "task");
                c44231e.eAJ.mo27490a(c44230d.czW, c44230d);
            }
        }
        AppMethodBeat.m2505o(35465);
    }
}
