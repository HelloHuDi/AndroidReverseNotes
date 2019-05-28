package a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0010\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001c"}, dWq = {"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class t<A, B, C> implements Serializable {
    public final C AUw;
    public final A first;
    public final B second;

    /* JADX WARNING: Missing block: B:9:0x002a, code skipped:
            if (a.f.b.j.j(r3.AUw, r4.AUw) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(56024);
        if (this != obj) {
            if (obj instanceof t) {
                t tVar = (t) obj;
                if (j.j(this.first, tVar.first)) {
                    if (j.j(this.second, tVar.second)) {
                    }
                }
            }
            AppMethodBeat.o(56024);
            return false;
        }
        AppMethodBeat.o(56024);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(56023);
        Object obj = this.first;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        obj = this.second;
        int hashCode2 = ((obj != null ? obj.hashCode() : 0) + hashCode) * 31;
        Object obj2 = this.AUw;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        hashCode2 += i;
        AppMethodBeat.o(56023);
        return hashCode2;
    }

    public t(A a, B b, C c) {
        this.first = a;
        this.second = b;
        this.AUw = c;
    }

    public final String toString() {
        AppMethodBeat.i(56022);
        String str = "(" + this.first + ", " + this.second + ", " + this.AUw + ')';
        AppMethodBeat.o(56022);
        return str;
    }
}
