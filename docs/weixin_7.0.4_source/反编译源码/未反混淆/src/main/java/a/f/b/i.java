package a.f.b;

import a.i.a;
import a.i.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i extends c implements h, e {
    private final int AVt;

    public i(int i) {
        this.AVt = i;
    }

    public i(Object obj) {
        super(obj);
        this.AVt = 1;
    }

    public final int dWz() {
        return this.AVt;
    }

    /* Access modifiers changed, original: protected|final */
    public final a dWB() {
        AppMethodBeat.i(55883);
        e a = v.a(this);
        AppMethodBeat.o(55883);
        return a;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(55884);
        if (obj == this) {
            AppMethodBeat.o(55884);
            return true;
        } else if (obj instanceof i) {
            i iVar = (i) obj;
            if (dWF() != null ? dWF().equals(iVar.dWF()) : iVar.dWF() == null) {
                if (getName().equals(iVar.getName()) && due().equals(iVar.due()) && j.j(dWC(), iVar.dWC())) {
                    AppMethodBeat.o(55884);
                    return true;
                }
            }
            AppMethodBeat.o(55884);
            return false;
        } else if (obj instanceof e) {
            boolean equals = obj.equals(dWD());
            AppMethodBeat.o(55884);
            return equals;
        } else {
            AppMethodBeat.o(55884);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(55885);
        int hashCode = (((dWF() == null ? 0 : dWF().hashCode() * 31) + getName().hashCode()) * 31) + due().hashCode();
        AppMethodBeat.o(55885);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(55886);
        i dWD = dWD();
        String obj;
        if (dWD != this) {
            obj = dWD.toString();
            AppMethodBeat.o(55886);
            return obj;
        } else if ("<init>".equals(getName())) {
            obj = "constructor (Kotlin reflection is not available)";
            AppMethodBeat.o(55886);
            return obj;
        } else {
            obj = "function " + getName() + " (Kotlin reflection is not available)";
            AppMethodBeat.o(55886);
            return obj;
        }
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ a dWE() {
        AppMethodBeat.i(55887);
        e eVar = (e) super.dWE();
        AppMethodBeat.o(55887);
        return eVar;
    }
}
