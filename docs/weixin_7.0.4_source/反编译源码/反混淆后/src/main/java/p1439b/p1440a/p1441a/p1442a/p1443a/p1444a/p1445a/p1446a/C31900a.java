package p1439b.p1440a.p1441a.p1442a.p1443a.p1444a.p1445a.p1446a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C26275be;
import java.util.HashMap;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lmain/java/com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: b.a.a.a.a.a.a.a.a */
public final class C31900a {
    private static final HashMap<String, C26275be> BTf = new HashMap();
    public static final C31901a BTg = new C31901a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lmain/java/com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter$Companion;", "", "()V", "sMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "Lkotlin/collections/HashMap;", "get", "appId", "init", "", "uninit", "plugin-appbrand-integration_release"})
    /* renamed from: b.a.a.a.a.a.a.a.a$a */
    public static final class C31901a {
        private C31901a() {
        }

        public /* synthetic */ C31901a(byte b) {
            this();
        }

        /* renamed from: Az */
        public final synchronized void mo52012Az(String str) {
            AppMethodBeat.m2504i(135275);
            C25052j.m39376p(str, "appId");
            C31900a.BTf.put(str, new C26275be());
            AppMethodBeat.m2505o(135275);
        }

        public final synchronized C26275be awB(String str) {
            C26275be c26275be;
            AppMethodBeat.m2504i(135276);
            C25052j.m39376p(str, "appId");
            c26275be = (C26275be) C31900a.BTf.get(str);
            AppMethodBeat.m2505o(135276);
            return c26275be;
        }

        public final synchronized void awC(String str) {
            AppMethodBeat.m2504i(135277);
            C25052j.m39376p(str, "appId");
            C31900a.BTf.remove(str);
            AppMethodBeat.m2505o(135277);
        }
    }

    static {
        AppMethodBeat.m2504i(135278);
        AppMethodBeat.m2505o(135278);
    }
}
