package p000a.p051k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p000a.C0220l;
import p000a.C31826o;
import p000a.C44941v;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;
import p000a.p009h.C0016h;
import p000a.p009h.C31599d;
import p000a.p050j.C44937h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
/* renamed from: a.k.e */
final class C41466e implements C44937h<C31599d> {
    final CharSequence BOQ;
    final C31591m<CharSequence, Integer, C31826o<Integer, Integer>> BOR;
    final int jaQ = 0;
    final int limit = 0;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, dWq = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    /* renamed from: a.k.e$a */
    public static final class C8304a implements C41374a, Iterator<C31599d> {
        private int BOS;
        private int BOT;
        private C31599d BOU;
        final /* synthetic */ C41466e BOV;
        private int BOw = -1;
        private int counter;

        public final void remove() {
            AppMethodBeat.m2504i(56264);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.m2505o(56264);
            throw unsupportedOperationException;
        }

        C8304a(C41466e c41466e) {
            this.BOV = c41466e;
            AppMethodBeat.m2504i(56263);
            this.BOS = C0016h.m14aQ(c41466e.jaQ, 0, c41466e.BOQ.length());
            this.BOT = this.BOS;
            AppMethodBeat.m2505o(56263);
        }

        /* JADX WARNING: Missing block: B:6:0x0028, code skipped:
            if (r7.counter < r7.BOV.limit) goto L_0x002a;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void ekK() {
            AppMethodBeat.m2504i(56260);
            if (this.BOT < 0) {
                this.BOw = 0;
                this.BOU = null;
                AppMethodBeat.m2505o(56260);
                return;
            }
            if (this.BOV.limit > 0) {
                this.counter++;
            }
            if (this.BOT <= this.BOV.BOQ.length()) {
                C31826o c31826o = (C31826o) this.BOV.BOR.mo212m(this.BOV.BOQ, Integer.valueOf(this.BOT));
                if (c31826o == null) {
                    this.BOU = new C31599d(this.BOS, C31820v.m51530at(this.BOV.BOQ));
                    this.BOT = -1;
                } else {
                    int intValue = ((Number) c31826o.first).intValue();
                    int intValue2 = ((Number) c31826o.second).intValue();
                    this.BOU = C0016h.m18il(this.BOS, intValue);
                    this.BOS = intValue + intValue2;
                    this.BOT = (intValue2 == 0 ? 1 : 0) + this.BOS;
                }
                this.BOw = 1;
                AppMethodBeat.m2505o(56260);
            }
            this.BOU = new C31599d(this.BOS, C31820v.m51530at(this.BOV.BOQ));
            this.BOT = -1;
            this.BOw = 1;
            AppMethodBeat.m2505o(56260);
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(56262);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 1) {
                AppMethodBeat.m2505o(56262);
                return true;
            }
            AppMethodBeat.m2505o(56262);
            return false;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(56261);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 0) {
                Throwable noSuchElementException = new NoSuchElementException();
                AppMethodBeat.m2505o(56261);
                throw noSuchElementException;
            }
            C31599d c31599d = this.BOU;
            if (c31599d == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.ranges.IntRange");
                AppMethodBeat.m2505o(56261);
                throw c44941v;
            }
            this.BOU = null;
            this.BOw = -1;
            AppMethodBeat.m2505o(56261);
            return c31599d;
        }
    }

    public C41466e(CharSequence charSequence, C31591m<? super CharSequence, ? super Integer, C31826o<Integer, Integer>> c31591m) {
        C25052j.m39376p(charSequence, "input");
        C25052j.m39376p(c31591m, "getNextMatch");
        AppMethodBeat.m2504i(56301);
        this.BOQ = charSequence;
        this.BOR = c31591m;
        AppMethodBeat.m2505o(56301);
    }

    public final Iterator<C31599d> iterator() {
        AppMethodBeat.m2504i(56300);
        Iterator c8304a = new C8304a(this);
        AppMethodBeat.m2505o(56300);
        return c8304a;
    }
}
