package kotlinx.coroutines;

import a.c.c;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.n;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0010H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\u0005*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, dWq = {"DEBUG", "", "getDEBUG", "()Z", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "classSimpleName", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class af {
    private static final boolean DEBUG;

    /* JADX WARNING: Missing block: B:7:0x0022, code skipped:
            r0 = new java.lang.IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + r0 + '\'').toString());
            com.tencent.matrix.trace.core.AppMethodBeat.o(118546);
     */
    /* JADX WARNING: Missing block: B:8:0x0046, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:10:0x004e, code skipped:
            if (r0.equals("") != false) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:11:0x0050, code skipped:
            r0 = true;
     */
    /* JADX WARNING: Missing block: B:13:0x0059, code skipped:
            if (r0.equals("auto") != false) goto L_0x000f;
     */
    /* JADX WARNING: Missing block: B:18:0x006e, code skipped:
            if (r0.equals("on") != false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        boolean z;
        AppMethodBeat.i(118546);
        String awA = n.awA("kotlinx.coroutines.debug");
        if (awA != null) {
            switch (awA.hashCode()) {
                case 0:
                    break;
                case 3551:
                    break;
                case 109935:
                    if (awA.equals("off")) {
                        z = false;
                        break;
                    }
                    break;
                case 3005871:
                    break;
            }
        }
        z = aa.class.desiredAssertionStatus();
        DEBUG = z;
        AppMethodBeat.o(118546);
    }

    public static final boolean ela() {
        return DEBUG;
    }

    public static final String ee(Object obj) {
        AppMethodBeat.i(118543);
        j.p(obj, "receiver$0");
        String toHexString = Integer.toHexString(System.identityHashCode(obj));
        j.o(toHexString, "Integer.toHexString(System.identityHashCode(this))");
        AppMethodBeat.o(118543);
        return toHexString;
    }

    public static final String d(c<?> cVar) {
        AppMethodBeat.i(118544);
        j.p(cVar, "receiver$0");
        String obj;
        if (cVar instanceof al) {
            obj = cVar.toString();
            AppMethodBeat.o(118544);
            return obj;
        }
        obj = cVar + '@' + ee(cVar);
        AppMethodBeat.o(118544);
        return obj;
    }

    public static final String ef(Object obj) {
        AppMethodBeat.i(118545);
        j.p(obj, "receiver$0");
        String simpleName = obj.getClass().getSimpleName();
        j.o(simpleName, "this::class.java.simpleName");
        AppMethodBeat.o(118545);
        return simpleName;
    }
}
