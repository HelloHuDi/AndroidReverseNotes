package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p002c.C25044a;
import p000a.p002c.C41366e.C36928c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, dWq = {"Lkotlinx/coroutines/CoroutineName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Key", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.ab */
public final class C24583ab extends C25044a {
    public static final C24584a BPM = new C24584a();
    final String name;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"Lkotlinx/coroutines/CoroutineName$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineName;", "()V", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.ab$a */
    public static final class C24584a implements C36928c<C24583ab> {
        private C24584a() {
        }

        public /* synthetic */ C24584a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(118495);
        AppMethodBeat.m2505o(118495);
    }

    /* JADX WARNING: Missing block: B:5:0x0016, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.name, ((kotlinx.coroutines.C24583ab) r4).name) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(118497);
        if (this != obj) {
            if (obj instanceof C24583ab) {
            }
            AppMethodBeat.m2505o(118497);
            return false;
        }
        AppMethodBeat.m2505o(118497);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(118496);
        String str = this.name;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.m2505o(118496);
            return hashCode;
        }
        AppMethodBeat.m2505o(118496);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.m2504i(118494);
        String str = "CoroutineName(" + this.name + ')';
        AppMethodBeat.m2505o(118494);
        return str;
    }
}
