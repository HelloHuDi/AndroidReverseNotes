package p000a.p772b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u000b"}, dWq = {"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
/* renamed from: a.b.e */
final class C36926e implements Comparator<Comparable<? super Object>> {
    public static final C36926e AUV = new C36926e();

    static {
        AppMethodBeat.m2504i(56017);
        AppMethodBeat.m2505o(56017);
    }

    private C36926e() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(56016);
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        C25052j.m39376p(comparable, "a");
        C25052j.m39376p(comparable2, "b");
        int compareTo = comparable.compareTo(comparable2);
        AppMethodBeat.m2505o(56016);
        return compareTo;
    }

    public final Comparator<Comparable<Object>> reversed() {
        return C44848f.AUW;
    }
}
