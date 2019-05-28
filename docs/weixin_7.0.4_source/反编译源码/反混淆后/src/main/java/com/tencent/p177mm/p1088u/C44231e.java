package com.tencent.p177mm.p1088u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p634v.C44409b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgTimer;", "", "callback", "Lcom/tencent/mm/engine/ITimerCallback;", "(Lcom/tencent/mm/engine/ITimerCallback;)V", "mCallback", "mQueue", "Lcom/tencent/mm/engine/FunctionMsgQueue;", "add", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "check", "handleTask", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
/* renamed from: com.tencent.mm.u.e */
public final class C44231e {
    public static final C15448a eAL = new C15448a();
    final C15449f eAJ;
    final C44229c eAK = new C44229c(this);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/engine/FunctionMsgTimer$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    /* renamed from: com.tencent.mm.u.e$a */
    public static final class C15448a {
        private C15448a() {
        }

        public /* synthetic */ C15448a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(35473);
        AppMethodBeat.m2505o(35473);
    }

    public C44231e(C15449f c15449f) {
        C25052j.m39376p(c15449f, "callback");
        AppMethodBeat.m2504i(35472);
        this.eAJ = c15449f;
        AppMethodBeat.m2505o(35472);
    }

    /* renamed from: a */
    public final void mo69874a(int i, C32248f c32248f, C44409b c44409b) {
        AppMethodBeat.m2504i(35471);
        C25052j.m39376p(c32248f, "item");
        C25052j.m39376p(c44409b, "executor");
        long currentTimeMillis = System.currentTimeMillis();
        long An = c32248f.mo52939An() - (C1839cb.aaD() / 1000);
        C4990ab.m7417i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", Integer.valueOf(i), Long.valueOf(An), c32248f.mo52934Ai());
        this.eAK.mo69870a(new C44230d(i, c32248f, c44409b));
        C4990ab.m7417i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(35471);
    }
}
