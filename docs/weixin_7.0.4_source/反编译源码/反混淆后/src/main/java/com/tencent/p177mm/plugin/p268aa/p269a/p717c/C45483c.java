package com.tencent.p177mm.plugin.p268aa.p269a.p717c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.app.C16025a.C16026a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.a.c.c */
public class C45483c extends C16025a {

    /* renamed from: com.tencent.mm.plugin.aa.a.c.c$a */
    public class C18773a {
        public List<String> ewK;
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.c$1 */
    class C379931 extends C16026a<C18773a> {
        C379931() {
            super();
        }

        public final /* synthetic */ Object aoq() {
            AppMethodBeat.m2504i(40681);
            C18773a a = C45483c.m83813a(C45483c.this);
            AppMethodBeat.m2505o(40681);
            return a;
        }
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(40682);
        super.onCreate();
        mo28387a(C18773a.class, (C16026a) new C379931());
        AppMethodBeat.m2505o(40682);
    }

    /* renamed from: a */
    static /* synthetic */ C18773a m83813a(C45483c c45483c) {
        AppMethodBeat.m2504i(40683);
        String stringExtra = c45483c.zXe.getStringExtra("chatroom");
        if (C5046bo.isNullOrNil(stringExtra)) {
            AppMethodBeat.m2505o(40683);
            return null;
        }
        C18773a c18773a = new C18773a();
        c18773a.ewK = C9797h.m17462vE(stringExtra);
        if (c18773a.ewK != null && c18773a.ewK.size() > 0) {
            c18773a.ewK.remove(C1853r.m3846Yz());
        }
        AppMethodBeat.m2505o(40683);
        return c18773a;
    }
}
