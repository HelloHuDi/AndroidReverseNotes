package kotlinx.coroutines.p700a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C0218t;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a,\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001H\u0000\u001a,\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000b2\b\b\u0002\u0010\t\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\f"}, dWq = {"AVAILABLE_PROCESSORS", "", "getAVAILABLE_PROCESSORS", "()I", "systemProp", "", "propertyName", "", "defaultValue", "minValue", "maxValue", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.n */
public final class C41151n {
    private static final int BRH = Runtime.getRuntime().availableProcessors();

    static {
        AppMethodBeat.m2504i(118445);
        AppMethodBeat.m2505o(118445);
    }

    public static final int elQ() {
        return BRH;
    }

    public static final String awA(String str) {
        String property;
        AppMethodBeat.m2504i(118441);
        C25052j.m39376p(str, "propertyName");
        try {
            property = System.getProperty(str);
        } catch (SecurityException e) {
            property = null;
        }
        AppMethodBeat.m2505o(118441);
        return property;
    }

    /* renamed from: e */
    public static /* synthetic */ int m71587e(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(118442);
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        C25052j.m39376p(str, "propertyName");
        int d = (int) C41151n.m71586d(str, (long) i, (long) i2, (long) i3);
        AppMethodBeat.m2505o(118442);
        return d;
    }

    /* renamed from: aU */
    public static /* synthetic */ long m71585aU(String str, long j) {
        AppMethodBeat.m2504i(118444);
        long d = C41151n.m71586d(str, j, 1, Long.MAX_VALUE);
        AppMethodBeat.m2505o(118444);
        return d;
    }

    /* renamed from: d */
    private static long m71586d(String str, long j, long j2, long j3) {
        AppMethodBeat.m2504i(118443);
        C25052j.m39376p(str, "propertyName");
        String awA = C41151n.awA(str);
        if (awA == null) {
            AppMethodBeat.m2505o(118443);
        } else {
            Long awz = C0218t.awz(awA);
            Throwable illegalStateException;
            if (awz != null) {
                j = awz.longValue();
                if (j2 > j || j3 < j) {
                    illegalStateException = new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + j + '\'').toString());
                    AppMethodBeat.m2505o(118443);
                    throw illegalStateException;
                }
                AppMethodBeat.m2505o(118443);
            } else {
                illegalStateException = new IllegalStateException(("System property '" + str + "' has unrecognized value '" + awA + '\'').toString());
                AppMethodBeat.m2505o(118443);
                throw illegalStateException;
            }
        }
        return j;
    }
}
