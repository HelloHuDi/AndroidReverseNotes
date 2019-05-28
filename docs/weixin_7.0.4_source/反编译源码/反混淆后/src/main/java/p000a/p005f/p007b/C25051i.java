package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.C44858a;
import p000a.p010i.C8295e;

/* renamed from: a.f.b.i */
public class C25051i extends C41376c implements C17132h, C8295e {
    private final int AVt;

    public C25051i(int i) {
        this.AVt = i;
    }

    public C25051i(Object obj) {
        super(obj);
        this.AVt = 1;
    }

    public final int dWz() {
        return this.AVt;
    }

    /* Access modifiers changed, original: protected|final */
    public final C44858a dWB() {
        AppMethodBeat.m2504i(55883);
        C8295e a = C44855v.m82049a(this);
        AppMethodBeat.m2505o(55883);
        return a;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(55884);
        if (obj == this) {
            AppMethodBeat.m2505o(55884);
            return true;
        } else if (obj instanceof C25051i) {
            C25051i c25051i = (C25051i) obj;
            if (dWF() != null ? dWF().equals(c25051i.dWF()) : c25051i.dWF() == null) {
                if (getName().equals(c25051i.getName()) && due().equals(c25051i.due()) && C25052j.m39373j(dWC(), c25051i.dWC())) {
                    AppMethodBeat.m2505o(55884);
                    return true;
                }
            }
            AppMethodBeat.m2505o(55884);
            return false;
        } else if (obj instanceof C8295e) {
            boolean equals = obj.equals(dWD());
            AppMethodBeat.m2505o(55884);
            return equals;
        } else {
            AppMethodBeat.m2505o(55884);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(55885);
        int hashCode = (((dWF() == null ? 0 : dWF().hashCode() * 31) + getName().hashCode()) * 31) + due().hashCode();
        AppMethodBeat.m2505o(55885);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.m2504i(55886);
        C25051i dWD = dWD();
        String obj;
        if (dWD != this) {
            obj = dWD.toString();
            AppMethodBeat.m2505o(55886);
            return obj;
        } else if ("<init>".equals(getName())) {
            obj = "constructor (Kotlin reflection is not available)";
            AppMethodBeat.m2505o(55886);
            return obj;
        } else {
            obj = "function " + getName() + " (Kotlin reflection is not available)";
            AppMethodBeat.m2505o(55886);
            return obj;
        }
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ C44858a dWE() {
        AppMethodBeat.m2504i(55887);
        C8295e c8295e = (C8295e) super.dWE();
        AppMethodBeat.m2505o(55887);
        return c8295e;
    }
}
