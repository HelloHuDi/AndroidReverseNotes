package a.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u000b"}, dWq = {"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
final class e implements Comparator<Comparable<? super Object>> {
    public static final e AUV = new e();

    static {
        AppMethodBeat.i(56017);
        AppMethodBeat.o(56017);
    }

    private e() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(56016);
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        j.p(comparable, "a");
        j.p(comparable2, "b");
        int compareTo = comparable.compareTo(comparable2);
        AppMethodBeat.o(56016);
        return compareTo;
    }

    public final Comparator<Comparable<Object>> reversed() {
        return f.AUW;
    }
}
