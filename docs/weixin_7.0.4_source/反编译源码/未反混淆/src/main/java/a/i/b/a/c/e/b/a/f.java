package a.i.b.a.c.e.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class f {

    public static final class b extends f {
        public final String desc;
        public final String name;

        public b(String str, String str2) {
            j.p(str, "name");
            j.p(str2, "desc");
            super();
            AppMethodBeat.i(121315);
            this.name = str;
            this.desc = str2;
            AppMethodBeat.o(121315);
        }

        public final String ehx() {
            return this.desc;
        }

        public final String getName() {
            return this.name;
        }

        public final String pq() {
            AppMethodBeat.i(121314);
            String str = this.name + this.desc;
            AppMethodBeat.o(121314);
            return str;
        }

        public final int hashCode() {
            int hashCode;
            int i = 0;
            AppMethodBeat.i(121316);
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
            AppMethodBeat.o(121316);
            return hashCode;
        }

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.desc, r4.desc) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(121317);
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (j.j(this.name, bVar.name)) {
                    }
                }
                AppMethodBeat.o(121317);
                return false;
            }
            AppMethodBeat.o(121317);
            return true;
        }
    }

    public static final class a extends f {
        public final String desc;
        public final String name;

        public a(String str, String str2) {
            j.p(str, "name");
            j.p(str2, "desc");
            super();
            AppMethodBeat.i(121311);
            this.name = str;
            this.desc = str2;
            AppMethodBeat.o(121311);
        }

        public final String ehx() {
            return this.desc;
        }

        public final String getName() {
            return this.name;
        }

        public final String pq() {
            AppMethodBeat.i(121310);
            String str = this.name + ':' + this.desc;
            AppMethodBeat.o(121310);
            return str;
        }

        public final int hashCode() {
            int hashCode;
            int i = 0;
            AppMethodBeat.i(121312);
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
            AppMethodBeat.o(121312);
            return hashCode;
        }

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.desc, r4.desc) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(121313);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (j.j(this.name, aVar.name)) {
                    }
                }
                AppMethodBeat.o(121313);
                return false;
            }
            AppMethodBeat.o(121313);
            return true;
        }
    }

    public abstract String ehx();

    public abstract String getName();

    public abstract String pq();

    private f() {
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    public final String toString() {
        return pq();
    }
}
