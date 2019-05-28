package kotlinx.coroutines.p700a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001aI\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, dWq = {"arraycopy", "", "E", "source", "", "srcPos", "", "destination", "destinationStart", "length", "([Ljava/lang/Object;I[Ljava/lang/Object;II)V", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.a */
public final class C16445a {
    /* renamed from: a */
    public static final <E> void m25223a(E[] eArr, int i, E[] eArr2, int i2, int i3) {
        AppMethodBeat.m2504i(118384);
        C25052j.m39376p(eArr, "source");
        C25052j.m39376p(eArr2, "destination");
        System.arraycopy(eArr, i, eArr2, i2, i3);
        AppMethodBeat.m2505o(118384);
    }
}
