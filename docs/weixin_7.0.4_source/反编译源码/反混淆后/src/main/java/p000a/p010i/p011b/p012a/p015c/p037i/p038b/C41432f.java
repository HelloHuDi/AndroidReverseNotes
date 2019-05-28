package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.i.b.f */
public abstract class C41432f<T> {
    private final T value;

    /* renamed from: b */
    public abstract C46867w mo18011b(C25093y c25093y);

    public C41432f(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        Object obj2 = null;
        if (this != obj) {
            Object value = getValue();
            C41432f c41432f = (C41432f) (!(obj instanceof C41432f) ? null : obj);
            if (c41432f != null) {
                obj2 = c41432f.getValue();
            }
            if (!C25052j.m39373j(value, obj2)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Object value = getValue();
        return value != null ? value.hashCode() : 0;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
