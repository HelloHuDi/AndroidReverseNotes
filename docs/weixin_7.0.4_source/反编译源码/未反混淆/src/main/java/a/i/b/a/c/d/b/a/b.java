package a.i.b.a.c.d.b.a;

import a.i.b.a.c.b.am;
import a.i.b.a.c.d.a.p;
import a.i.b.a.c.d.b.n;
import a.i.b.a.c.e.b.a.d;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements a.i.b.a.c.d.b.n.c {
    private static final boolean Bss = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<a.i.b.a.c.f.a, a.i.b.a.c.d.b.a.a.a> Bst;
    public d Bse = null;
    public String[] Bsf = null;
    public String[] Bsg = null;
    public String Bsh = null;
    public int Bsi = 0;
    public int[] Bsu = null;
    public a.i.b.a.c.d.b.a.a.a Bsv = null;
    public String packageName = null;
    public String[] strings = null;

    static abstract class a implements a.i.b.a.c.d.b.n.b {
        private final List<String> Bsw = new ArrayList();

        public abstract void ae(String[] strArr);

        public final void dG(Object obj) {
            if (obj instanceof String) {
                this.Bsw.add((String) obj);
            }
        }

        public final void a(a.i.b.a.c.f.a aVar, f fVar) {
        }

        public final void a(n.d dVar) {
        }

        public final void zn() {
            ae((String[]) this.Bsw.toArray(new String[this.Bsw.size()]));
        }
    }

    class b implements a.i.b.a.c.d.b.n.a {
        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final void a(f fVar, Object obj) {
            AppMethodBeat.i(120345);
            if (fVar == null) {
                AppMethodBeat.o(120345);
                return;
            }
            String str = fVar.name;
            if ("k".equals(str)) {
                if (obj instanceof Integer) {
                    b.this.Bsv = a.i.b.a.c.d.b.a.a.a.SO(((Integer) obj).intValue());
                    AppMethodBeat.o(120345);
                    return;
                }
            } else if ("mv".equals(str)) {
                if (obj instanceof int[]) {
                    b.this.Bsu = (int[]) obj;
                    AppMethodBeat.o(120345);
                    return;
                }
            } else if ("bv".equals(str)) {
                if (obj instanceof int[]) {
                    b.this.Bse = new d((int[]) obj);
                    AppMethodBeat.o(120345);
                    return;
                }
            } else if ("xs".equals(str)) {
                if (obj instanceof String) {
                    b.this.Bsh = (String) obj;
                    AppMethodBeat.o(120345);
                    return;
                }
            } else if ("xi".equals(str)) {
                if (obj instanceof Integer) {
                    b.this.Bsi = ((Integer) obj).intValue();
                    AppMethodBeat.o(120345);
                    return;
                }
            } else if ("pn".equals(str) && (obj instanceof String)) {
                b.this.packageName = (String) obj;
            }
            AppMethodBeat.o(120345);
        }

        public final void a(f fVar, n.d dVar) {
        }

        public final void a(f fVar, a.i.b.a.c.f.a aVar, f fVar2) {
        }

        public final a.i.b.a.c.d.b.n.a a(f fVar, a.i.b.a.c.f.a aVar) {
            return null;
        }

        public final void zn() {
        }

        public final a.i.b.a.c.d.b.n.b o(f fVar) {
            AppMethodBeat.i(120346);
            String str = fVar.name;
            if ("d1".equals(str)) {
                AnonymousClass1 anonymousClass1 = new a() {
                    /* Access modifiers changed, original: protected|final */
                    public final void ae(String[] strArr) {
                        AppMethodBeat.i(120343);
                        b.this.Bsf = strArr;
                        AppMethodBeat.o(120343);
                    }
                };
                AppMethodBeat.o(120346);
                return anonymousClass1;
            } else if ("d2".equals(str)) {
                a.i.b.a.c.d.b.n.b anonymousClass2 = new a() {
                    /* Access modifiers changed, original: protected|final */
                    public final void ae(String[] strArr) {
                        AppMethodBeat.i(120344);
                        b.this.strings = strArr;
                        AppMethodBeat.o(120344);
                    }
                };
                AppMethodBeat.o(120346);
                return anonymousClass2;
            } else {
                AppMethodBeat.o(120346);
                return null;
            }
        }
    }

    class c implements a.i.b.a.c.d.b.n.a {
        private c() {
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final void a(f fVar, Object obj) {
            AppMethodBeat.i(120349);
            if (fVar == null) {
                AppMethodBeat.o(120349);
                return;
            }
            String str = fVar.name;
            if ("version".equals(str)) {
                if (obj instanceof int[]) {
                    b.this.Bsu = (int[]) obj;
                    if (b.this.Bse == null) {
                        b.this.Bse = new d((int[]) obj);
                        AppMethodBeat.o(120349);
                        return;
                    }
                }
            } else if ("multifileClassName".equals(str)) {
                b.this.Bsh = obj instanceof String ? (String) obj : null;
            }
            AppMethodBeat.o(120349);
        }

        public final void a(f fVar, n.d dVar) {
        }

        public final void a(f fVar, a.i.b.a.c.f.a aVar, f fVar2) {
        }

        public final a.i.b.a.c.d.b.n.a a(f fVar, a.i.b.a.c.f.a aVar) {
            return null;
        }

        public final void zn() {
        }

        public final a.i.b.a.c.d.b.n.b o(f fVar) {
            AppMethodBeat.i(120350);
            String str = fVar.name;
            if ("data".equals(str) || "filePartClassNames".equals(str)) {
                AnonymousClass1 anonymousClass1 = new a() {
                    /* Access modifiers changed, original: protected|final */
                    public final void ae(String[] strArr) {
                        AppMethodBeat.i(120347);
                        b.this.Bsf = strArr;
                        AppMethodBeat.o(120347);
                    }
                };
                AppMethodBeat.o(120350);
                return anonymousClass1;
            } else if ("strings".equals(str)) {
                a.i.b.a.c.d.b.n.b anonymousClass2 = new a() {
                    /* Access modifiers changed, original: protected|final */
                    public final void ae(String[] strArr) {
                        AppMethodBeat.i(120348);
                        b.this.strings = strArr;
                        AppMethodBeat.o(120348);
                    }
                };
                AppMethodBeat.o(120350);
                return anonymousClass2;
            } else {
                AppMethodBeat.o(120350);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.i(120352);
        HashMap hashMap = new HashMap();
        Bst = hashMap;
        hashMap.put(a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.internal.KotlinClass")), a.i.b.a.c.d.b.a.a.a.CLASS);
        Bst.put(a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.internal.KotlinFileFacade")), a.i.b.a.c.d.b.a.a.a.FILE_FACADE);
        Bst.put(a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.internal.KotlinMultifileClass")), a.i.b.a.c.d.b.a.a.a.MULTIFILE_CLASS);
        Bst.put(a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a.i.b.a.c.d.b.a.a.a.MULTIFILE_CLASS_PART);
        Bst.put(a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.internal.KotlinSyntheticClass")), a.i.b.a.c.d.b.a.a.a.SYNTHETIC_CLASS);
        AppMethodBeat.o(120352);
    }

    public final a.i.b.a.c.d.b.n.a a(a.i.b.a.c.f.a aVar, am amVar) {
        AppMethodBeat.i(120351);
        if (aVar.ehE().equals(p.Bll)) {
            b bVar = new b(this, (byte) 0);
            AppMethodBeat.o(120351);
            return bVar;
        } else if (Bss) {
            AppMethodBeat.o(120351);
            return null;
        } else if (this.Bsv != null) {
            AppMethodBeat.o(120351);
            return null;
        } else {
            a.i.b.a.c.d.b.a.a.a aVar2 = (a.i.b.a.c.d.b.a.a.a) Bst.get(aVar);
            if (aVar2 != null) {
                this.Bsv = aVar2;
                a.i.b.a.c.d.b.n.a cVar = new c(this, (byte) 0);
                AppMethodBeat.o(120351);
                return cVar;
            }
            AppMethodBeat.o(120351);
            return null;
        }
    }

    public final void zn() {
    }
}
