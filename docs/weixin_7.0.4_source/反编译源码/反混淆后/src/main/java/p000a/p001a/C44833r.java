package p000a.p001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C0220l;
import p000a.p009h.C31599d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, dWq = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.a.r */
public class C44833r extends C44628q {
    /* renamed from: w */
    public static final /* synthetic */ int m82035w(List list, int i) {
        AppMethodBeat.m2504i(56203);
        int fH = C7987l.m14172fH(list);
        if (i >= 0 && fH >= i) {
            fH = C7987l.m14172fH(list) - i;
            AppMethodBeat.m2505o(56203);
            return fH;
        }
        Throwable indexOutOfBoundsException = new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new C31599d(0, C7987l.m14172fH(list)) + "].");
        AppMethodBeat.m2505o(56203);
        throw indexOutOfBoundsException;
    }
}
