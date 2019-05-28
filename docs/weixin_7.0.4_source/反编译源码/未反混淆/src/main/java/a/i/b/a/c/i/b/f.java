package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.w;

public abstract class f<T> {
    private final T value;

    public abstract w b(y yVar);

    public f(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        Object obj2 = null;
        if (this != obj) {
            Object value = getValue();
            f fVar = (f) (!(obj instanceof f) ? null : obj);
            if (fVar != null) {
                obj2 = fVar.getValue();
            }
            if (!j.j(value, obj2)) {
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
