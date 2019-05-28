package com.tencent.p177mm.loader.p1197h.p1198a;

/* renamed from: com.tencent.mm.loader.h.a.a */
public final class C42156a<T> {
    protected C18543b eRV;
    protected T value;

    public C42156a(String str) {
        this.value = str;
        this.eRV = C18543b.URI;
    }

    public C42156a(C18544c c18544c) {
        this.value = c18544c;
        this.eRV = C18543b.URI;
    }

    private C42156a(String str, C18543b c18543b) {
        this.value = str;
        this.eRV = c18543b;
    }

    /* renamed from: a */
    public static <T extends String> C42156a<T> m74318a(T t, C18543b c18543b) {
        return new C42156a(t, c18543b);
    }

    public final T value() {
        return this.value;
    }

    /* renamed from: Uf */
    public final C18543b mo67692Uf() {
        return this.eRV;
    }

    /* renamed from: Ug */
    public final boolean mo67693Ug() {
        return this.value != null;
    }

    /* renamed from: Uh */
    public final String mo67694Uh() {
        return this.value.toString();
    }

    public final String toString() {
        if (this.value == null) {
            return "";
        }
        if (this.value instanceof C18544c) {
            return ((C18544c) this.value).mo33795Ui();
        }
        return this.value.toString();
    }

    public final int hashCode() {
        if (this.value != null) {
            return this.value.hashCode();
        }
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this.value == null || !(obj instanceof C42156a)) {
            return super.equals(obj);
        }
        return this.value.equals(((C42156a) obj).value);
    }
}
