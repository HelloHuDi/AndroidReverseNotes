package kotlinx.coroutines.a;

import a.f.b.j;
import a.k.t;
import a.l;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a,\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001H\u0000\u001a,\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000b2\b\b\u0002\u0010\t\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\f"}, dWq = {"AVAILABLE_PROCESSORS", "", "getAVAILABLE_PROCESSORS", "()I", "systemProp", "", "propertyName", "", "defaultValue", "minValue", "maxValue", "", "kotlinx-coroutines-core"})
public final class n {
    private static final int BRH = Runtime.getRuntime().availableProcessors();

    static {
        AppMethodBeat.i(118445);
        AppMethodBeat.o(118445);
    }

    public static final int elQ() {
        return BRH;
    }

    public static final String awA(String str) {
        String property;
        AppMethodBeat.i(118441);
        j.p(str, "propertyName");
        try {
            property = System.getProperty(str);
        } catch (SecurityException e) {
            property = null;
        }
        AppMethodBeat.o(118441);
        return property;
    }

    public static /* synthetic */ int e(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(118442);
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        j.p(str, "propertyName");
        int d = (int) d(str, (long) i, (long) i2, (long) i3);
        AppMethodBeat.o(118442);
        return d;
    }

    public static /* synthetic */ long aU(String str, long j) {
        AppMethodBeat.i(118444);
        long d = d(str, j, 1, Long.MAX_VALUE);
        AppMethodBeat.o(118444);
        return d;
    }

    private static long d(String str, long j, long j2, long j3) {
        AppMethodBeat.i(118443);
        j.p(str, "propertyName");
        String awA = awA(str);
        if (awA == null) {
            AppMethodBeat.o(118443);
        } else {
            Long awz = t.awz(awA);
            Throwable illegalStateException;
            if (awz != null) {
                j = awz.longValue();
                if (j2 > j || j3 < j) {
                    illegalStateException = new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + j + '\'').toString());
                    AppMethodBeat.o(118443);
                    throw illegalStateException;
                }
                AppMethodBeat.o(118443);
            } else {
                illegalStateException = new IllegalStateException(("System property '" + str + "' has unrecognized value '" + awA + '\'').toString());
                AppMethodBeat.o(118443);
                throw illegalStateException;
            }
        }
        return j;
    }
}
