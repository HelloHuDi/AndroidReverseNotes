package a.h;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, dWq = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class d extends b implements a<Integer> {
    private static final d AVP = new d(1, 0);
    public static final a AVQ = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public d(int i, int i2) {
        super(i, i2, 1);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(55989);
        if ((obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.AVJ == ((d) obj).AVJ && this.AVK == ((d) obj).AVK))) {
            AppMethodBeat.o(55989);
            return true;
        }
        AppMethodBeat.o(55989);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(55990);
        if (isEmpty()) {
            AppMethodBeat.o(55990);
            return -1;
        }
        int i = (this.AVJ * 31) + this.AVK;
        AppMethodBeat.o(55990);
        return i;
    }

    public final String toString() {
        AppMethodBeat.i(55991);
        String str = this.AVJ + ".." + this.AVK;
        AppMethodBeat.o(55991);
        return str;
    }

    static {
        AppMethodBeat.i(55992);
        AppMethodBeat.o(55992);
    }

    public final boolean contains(int i) {
        return this.AVJ <= i && i <= this.AVK;
    }

    public final boolean isEmpty() {
        return this.AVJ > this.AVK;
    }
}
