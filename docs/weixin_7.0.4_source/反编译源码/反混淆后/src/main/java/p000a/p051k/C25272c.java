package p000a.p051k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\n¨\u0006\b"}, dWq = {"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.k.c */
public class C25272c extends C17354b {
    /* renamed from: a */
    public static final boolean m39838a(char c, char c2, boolean z) {
        AppMethodBeat.m2504i(56297);
        if (c == c2) {
            AppMethodBeat.m2505o(56297);
            return true;
        } else if (!z) {
            AppMethodBeat.m2505o(56297);
            return false;
        } else if (Character.toUpperCase(c) == Character.toUpperCase(c2)) {
            AppMethodBeat.m2505o(56297);
            return true;
        } else if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {
            AppMethodBeat.m2505o(56297);
            return true;
        } else {
            AppMethodBeat.m2505o(56297);
            return false;
        }
    }

    public static final boolean isSurrogate(char c) {
        return 55296 <= c && 57343 >= c;
    }
}
