package com.tencent.mm.loader.h.a;

public final class a<T> {
    protected b eRV;
    protected T value;

    public a(String str) {
        this.value = str;
        this.eRV = b.URI;
    }

    public a(c cVar) {
        this.value = cVar;
        this.eRV = b.URI;
    }

    private a(String str, b bVar) {
        this.value = str;
        this.eRV = bVar;
    }

    public static <T extends String> a<T> a(T t, b bVar) {
        return new a(t, bVar);
    }

    public final T value() {
        return this.value;
    }

    public final b Uf() {
        return this.eRV;
    }

    public final boolean Ug() {
        return this.value != null;
    }

    public final String Uh() {
        return this.value.toString();
    }

    public final String toString() {
        if (this.value == null) {
            return "";
        }
        if (this.value instanceof c) {
            return ((c) this.value).Ui();
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
        if (this.value == null || !(obj instanceof a)) {
            return super.equals(obj);
        }
        return this.value.equals(((a) obj).value);
    }
}
