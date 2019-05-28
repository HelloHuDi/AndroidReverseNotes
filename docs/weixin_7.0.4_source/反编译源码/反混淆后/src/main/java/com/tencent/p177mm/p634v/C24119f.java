package com.tencent.p177mm.p634v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.api.C45152l;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p1088u.C44230d;
import com.tencent.p177mm.p1088u.C44231e;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C40626ba;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
/* renamed from: com.tencent.mm.v.f */
public final class C24119f implements C44409b {
    public static final C24120a eAU = new C24120a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/executor/OpShowExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    /* renamed from: com.tencent.mm.v.f$a */
    public static final class C24120a {
        private C24120a() {
        }

        public /* synthetic */ C24120a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(35491);
        AppMethodBeat.m2505o(35491);
    }

    /* renamed from: a */
    public final void mo39925a(C44231e c44231e, C45152l c45152l, C40626ba c40626ba, C32248f c32248f, C32248f c32248f2, long j) {
        AppMethodBeat.m2504i(35489);
        C25052j.m39376p(c44231e, "timer");
        C25052j.m39376p(c45152l, "dispatcher");
        C25052j.m39376p(c40626ba, "storage");
        C25052j.m39376p(c32248f, "newFunctionMsgItem");
        C4990ab.m7416i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(c32248f2)));
        c32248f.mo52948be(true);
        if (c32248f2 != null) {
            C4990ab.m7416i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show!," + c32248f.getVersion() + ", " + c32248f2.getVersion() + ',' + (c32248f2.mo52937Al() == null));
            c32248f2.mo52948be(true);
            if (c32248f2.mo52937Al() != null && c32248f2.getStatus() == 2) {
                C4990ab.m7417i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", Long.valueOf(j));
                C7254cm Al = c32248f2.mo52937Al();
                if (Al != null) {
                    Al.pcX = (int) (C1839cb.aaD() / 1000);
                }
            }
            c32248f2.mo52947aJ(c32248f.mo52939An());
            c32248f2.mo52951cF(c32248f.mo52936Ak());
            String Ai = c32248f2.mo52934Ai();
            C25052j.m39375o(Ai, "oldFunctionMsgItem!!.functionMsgId");
            C40626ba.m70154a(Ai, c32248f2);
            c44231e.mo69874a(3, c32248f2, this);
        }
        AppMethodBeat.m2505o(35489);
    }

    /* renamed from: a */
    public final void mo39926a(C44231e c44231e, C45152l c45152l, C44230d c44230d) {
        AppMethodBeat.m2504i(35490);
        C25052j.m39376p(c44231e, "timer");
        C25052j.m39376p(c45152l, "dispatcher");
        C25052j.m39376p(c44230d, "task");
        C32248f c32248f = c44230d.eAH;
        c45152l.mo39138a(c32248f.mo52934Ai(), c32248f, c32248f.mo52937Al());
        AppMethodBeat.m2505o(35490);
    }
}
