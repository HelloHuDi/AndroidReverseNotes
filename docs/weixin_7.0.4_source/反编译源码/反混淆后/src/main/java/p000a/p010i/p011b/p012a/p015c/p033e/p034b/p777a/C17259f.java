package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.e.b.a.f */
public abstract class C17259f {

    /* renamed from: a.i.b.a.c.e.b.a.f$b */
    public static final class C17260b extends C17259f {
        public final String desc;
        public final String name;

        public C17260b(String str, String str2) {
            C25052j.m39376p(str, "name");
            C25052j.m39376p(str2, "desc");
            super();
            AppMethodBeat.m2504i(121315);
            this.name = str;
            this.desc = str2;
            AppMethodBeat.m2505o(121315);
        }

        public final String ehx() {
            return this.desc;
        }

        public final String getName() {
            return this.name;
        }

        /* renamed from: pq */
        public final String mo31321pq() {
            AppMethodBeat.m2504i(121314);
            String str = this.name + this.desc;
            AppMethodBeat.m2505o(121314);
            return str;
        }

        public final int hashCode() {
            int hashCode;
            int i = 0;
            AppMethodBeat.m2504i(121316);
            String str = this.name;
            if (str != null) {
                hashCode = str.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode *= 31;
            String str2 = this.desc;
            if (str2 != null) {
                i = str2.hashCode();
            }
            hashCode += i;
            AppMethodBeat.m2505o(121316);
            return hashCode;
        }

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.desc, r4.desc) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(121317);
            if (this != obj) {
                if (obj instanceof C17260b) {
                    C17260b c17260b = (C17260b) obj;
                    if (C25052j.m39373j(this.name, c17260b.name)) {
                    }
                }
                AppMethodBeat.m2505o(121317);
                return false;
            }
            AppMethodBeat.m2505o(121317);
            return true;
        }
    }

    /* renamed from: a.i.b.a.c.e.b.a.f$a */
    public static final class C17261a extends C17259f {
        public final String desc;
        public final String name;

        public C17261a(String str, String str2) {
            C25052j.m39376p(str, "name");
            C25052j.m39376p(str2, "desc");
            super();
            AppMethodBeat.m2504i(121311);
            this.name = str;
            this.desc = str2;
            AppMethodBeat.m2505o(121311);
        }

        public final String ehx() {
            return this.desc;
        }

        public final String getName() {
            return this.name;
        }

        /* renamed from: pq */
        public final String mo31321pq() {
            AppMethodBeat.m2504i(121310);
            String str = this.name + ':' + this.desc;
            AppMethodBeat.m2505o(121310);
            return str;
        }

        public final int hashCode() {
            int hashCode;
            int i = 0;
            AppMethodBeat.m2504i(121312);
            String str = this.name;
            if (str != null) {
                hashCode = str.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode *= 31;
            String str2 = this.desc;
            if (str2 != null) {
                i = str2.hashCode();
            }
            hashCode += i;
            AppMethodBeat.m2505o(121312);
            return hashCode;
        }

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.desc, r4.desc) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(121313);
            if (this != obj) {
                if (obj instanceof C17261a) {
                    C17261a c17261a = (C17261a) obj;
                    if (C25052j.m39373j(this.name, c17261a.name)) {
                    }
                }
                AppMethodBeat.m2505o(121313);
                return false;
            }
            AppMethodBeat.m2505o(121313);
            return true;
        }
    }

    public abstract String ehx();

    public abstract String getName();

    /* renamed from: pq */
    public abstract String mo31321pq();

    private C17259f() {
    }

    public /* synthetic */ C17259f(byte b) {
        this();
    }

    public final String toString() {
        return mo31321pq();
    }
}
