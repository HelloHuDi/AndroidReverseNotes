package p000a.p005f.p007b;

import p000a.p010i.C31815k;
import p000a.p010i.C44858a;

/* renamed from: a.f.b.p */
public abstract class C8000p extends C41376c implements C31815k {
    /* Access modifiers changed, original: protected|final */
    public final C31815k dWL() {
        return (C31815k) super.dWE();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C8000p)) {
            return obj instanceof C31815k ? obj.equals(dWD()) : false;
        } else {
            C8000p c8000p = (C8000p) obj;
            if (dWF().equals(c8000p.dWF()) && getName().equals(c8000p.getName()) && due().equals(c8000p.due()) && C25052j.m39373j(dWC(), c8000p.dWC())) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        return (((dWF().hashCode() * 31) + getName().hashCode()) * 31) + due().hashCode();
    }

    public String toString() {
        C8000p dWD = dWD();
        if (dWD != this) {
            return dWD.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ C44858a dWE() {
        return (C31815k) super.dWE();
    }
}
