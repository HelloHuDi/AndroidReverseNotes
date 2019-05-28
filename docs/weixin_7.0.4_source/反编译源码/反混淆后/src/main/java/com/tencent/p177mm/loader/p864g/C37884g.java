package com.tencent.p177mm.loader.p864g;

import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\bJ.\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0005\u001a\u00028\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/loader/loader/LoaderPair;", "A", "B", "", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "setSecond", "(Ljava/lang/Object;)V", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/loader/loader/LoaderPair;", "equals", "", "other", "hashCode", "", "toString", "", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.g.g */
public final class C37884g<A, B> {
    final A first;
    B second;

    /* JADX WARNING: Missing block: B:6:0x001a, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r2.second, r3.second) != false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C37884g) {
                C37884g c37884g = (C37884g) obj;
                if (C25052j.m39373j(this.first, c37884g.first)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        Object obj = this.first;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.second;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "LoaderPair(first=" + this.first + ", second=" + this.second + ")";
    }

    public C37884g(A a, B b) {
        this.first = a;
        this.second = b;
    }
}
