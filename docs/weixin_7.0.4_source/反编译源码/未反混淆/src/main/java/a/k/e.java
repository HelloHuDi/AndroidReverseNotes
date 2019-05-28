package a.k;

import a.f.a.m;
import a.f.b.j;
import a.h.d;
import a.j.h;
import a.l;
import a.o;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e implements h<d> {
    final CharSequence BOQ;
    final m<CharSequence, Integer, o<Integer, Integer>> BOR;
    final int jaQ = 0;
    final int limit = 0;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, dWq = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    public static final class a implements a.f.b.a.a, Iterator<d> {
        private int BOS;
        private int BOT;
        private d BOU;
        final /* synthetic */ e BOV;
        private int BOw = -1;
        private int counter;

        public final void remove() {
            AppMethodBeat.i(56264);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(56264);
            throw unsupportedOperationException;
        }

        a(e eVar) {
            this.BOV = eVar;
            AppMethodBeat.i(56263);
            this.BOS = a.h.h.aQ(eVar.jaQ, 0, eVar.BOQ.length());
            this.BOT = this.BOS;
            AppMethodBeat.o(56263);
        }

        /* JADX WARNING: Missing block: B:6:0x0028, code skipped:
            if (r7.counter < r7.BOV.limit) goto L_0x002a;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void ekK() {
            AppMethodBeat.i(56260);
            if (this.BOT < 0) {
                this.BOw = 0;
                this.BOU = null;
                AppMethodBeat.o(56260);
                return;
            }
            if (this.BOV.limit > 0) {
                this.counter++;
            }
            if (this.BOT <= this.BOV.BOQ.length()) {
                o oVar = (o) this.BOV.BOR.m(this.BOV.BOQ, Integer.valueOf(this.BOT));
                if (oVar == null) {
                    this.BOU = new d(this.BOS, v.at(this.BOV.BOQ));
                    this.BOT = -1;
                } else {
                    int intValue = ((Number) oVar.first).intValue();
                    int intValue2 = ((Number) oVar.second).intValue();
                    this.BOU = a.h.h.il(this.BOS, intValue);
                    this.BOS = intValue + intValue2;
                    this.BOT = (intValue2 == 0 ? 1 : 0) + this.BOS;
                }
                this.BOw = 1;
                AppMethodBeat.o(56260);
            }
            this.BOU = new d(this.BOS, v.at(this.BOV.BOQ));
            this.BOT = -1;
            this.BOw = 1;
            AppMethodBeat.o(56260);
        }

        public final boolean hasNext() {
            AppMethodBeat.i(56262);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 1) {
                AppMethodBeat.o(56262);
                return true;
            }
            AppMethodBeat.o(56262);
            return false;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(56261);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 0) {
                Throwable noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(56261);
                throw noSuchElementException;
            }
            d dVar = this.BOU;
            if (dVar == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.ranges.IntRange");
                AppMethodBeat.o(56261);
                throw vVar;
            }
            this.BOU = null;
            this.BOw = -1;
            AppMethodBeat.o(56261);
            return dVar;
        }
    }

    public e(CharSequence charSequence, m<? super CharSequence, ? super Integer, o<Integer, Integer>> mVar) {
        j.p(charSequence, "input");
        j.p(mVar, "getNextMatch");
        AppMethodBeat.i(56301);
        this.BOQ = charSequence;
        this.BOR = mVar;
        AppMethodBeat.o(56301);
    }

    public final Iterator<d> iterator() {
        AppMethodBeat.i(56300);
        Iterator aVar = new a(this);
        AppMethodBeat.o(56300);
        return aVar;
    }
}
