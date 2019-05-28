package p000a.p051k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C31599d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, dWq = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"})
/* renamed from: a.k.f */
public final class C44938f {
    private final C31599d BOW;
    private final String value;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BOW, r4.BOW) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(56351);
        if (this != obj) {
            if (obj instanceof C44938f) {
                C44938f c44938f = (C44938f) obj;
                if (C25052j.m39373j(this.value, c44938f.value)) {
                }
            }
            AppMethodBeat.m2505o(56351);
            return false;
        }
        AppMethodBeat.m2505o(56351);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(56350);
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        C31599d c31599d = this.BOW;
        if (c31599d != null) {
            i = c31599d.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(56350);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(56349);
        String str = "MatchGroup(value=" + this.value + ", range=" + this.BOW + ")";
        AppMethodBeat.m2505o(56349);
        return str;
    }

    public C44938f(String str, C31599d c31599d) {
        C25052j.m39376p(str, "value");
        C25052j.m39376p(c31599d, "range");
        AppMethodBeat.m2504i(56348);
        this.value = str;
        this.BOW = c31599d;
        AppMethodBeat.m2505o(56348);
    }
}
