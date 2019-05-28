package b.a.a.a.a.a.a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.be;
import java.util.HashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lmain/java/com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a {
    private static final HashMap<String, be> BTf = new HashMap();
    public static final a BTg = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lmain/java/com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter$Companion;", "", "()V", "sMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "Lkotlin/collections/HashMap;", "get", "appId", "init", "", "uninit", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final synchronized void Az(String str) {
            AppMethodBeat.i(135275);
            j.p(str, "appId");
            a.BTf.put(str, new be());
            AppMethodBeat.o(135275);
        }

        public final synchronized be awB(String str) {
            be beVar;
            AppMethodBeat.i(135276);
            j.p(str, "appId");
            beVar = (be) a.BTf.get(str);
            AppMethodBeat.o(135276);
            return beVar;
        }

        public final synchronized void awC(String str) {
            AppMethodBeat.i(135277);
            j.p(str, "appId");
            a.BTf.remove(str);
            AppMethodBeat.o(135277);
        }
    }

    static {
        AppMethodBeat.i(135278);
        AppMethodBeat.o(135278);
    }
}
