package a.f.b;

import a.i.a;
import a.i.k;

public abstract class p extends c implements k {
    /* Access modifiers changed, original: protected|final */
    public final k dWL() {
        return (k) super.dWE();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return obj instanceof k ? obj.equals(dWD()) : false;
        } else {
            p pVar = (p) obj;
            if (dWF().equals(pVar.dWF()) && getName().equals(pVar.getName()) && due().equals(pVar.due()) && j.j(dWC(), pVar.dWC())) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        return (((dWF().hashCode() * 31) + getName().hashCode()) * 31) + due().hashCode();
    }

    public String toString() {
        p dWD = dWD();
        if (dWD != this) {
            return dWD.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ a dWE() {
        return (k) super.dWE();
    }
}
