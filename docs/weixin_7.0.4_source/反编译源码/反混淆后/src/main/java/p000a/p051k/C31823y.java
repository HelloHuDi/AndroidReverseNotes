package p000a.p051k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
/* renamed from: a.k.y */
final class C31823y {
    public static final C31823y BPp = new C31823y();
    public static final String LINE_SEPARATOR;

    static {
        AppMethodBeat.m2504i(56363);
        String property = System.getProperty("line.separator");
        if (property == null) {
            C25052j.dWJ();
        }
        LINE_SEPARATOR = property;
        AppMethodBeat.m2505o(56363);
    }

    private C31823y() {
    }
}
