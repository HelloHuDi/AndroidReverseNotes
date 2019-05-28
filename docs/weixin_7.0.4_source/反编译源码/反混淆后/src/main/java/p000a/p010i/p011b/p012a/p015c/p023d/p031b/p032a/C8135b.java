package p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C17230p;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n.C8140d;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n.C8144b;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n.C8145a;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n.C8146c;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a.C8134a.C8132a;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17257d;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.b.a.b */
public final class C8135b implements C8146c {
    private static final boolean Bss = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<C8173a, C8132a> Bst;
    public C17257d Bse = null;
    public String[] Bsf = null;
    public String[] Bsg = null;
    public String Bsh = null;
    public int Bsi = 0;
    public int[] Bsu = null;
    public C8132a Bsv = null;
    public String packageName = null;
    public String[] strings = null;

    /* renamed from: a.i.b.a.c.d.b.a.b$a */
    static abstract class C0068a implements C8144b {
        private final List<String> Bsw = new ArrayList();

        /* renamed from: ae */
        public abstract void mo112ae(String[] strArr);

        /* renamed from: dG */
        public final void mo113dG(Object obj) {
            if (obj instanceof String) {
                this.Bsw.add((String) obj);
            }
        }

        /* renamed from: a */
        public final void mo111a(C8173a c8173a, C37022f c37022f) {
        }

        /* renamed from: a */
        public final void mo110a(C8140d c8140d) {
        }

        /* renamed from: zn */
        public final void mo114zn() {
            mo112ae((String[]) this.Bsw.toArray(new String[this.Bsw.size()]));
        }
    }

    /* renamed from: a.i.b.a.c.d.b.a.b$b */
    class C0069b implements C8145a {

        /* renamed from: a.i.b.a.c.d.b.a.b$b$1 */
        class C00701 extends C0068a {
            C00701() {
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: ae */
            public final void mo112ae(String[] strArr) {
                AppMethodBeat.m2504i(120343);
                C8135b.this.Bsf = strArr;
                AppMethodBeat.m2505o(120343);
            }
        }

        /* renamed from: a.i.b.a.c.d.b.a.b$b$2 */
        class C00712 extends C0068a {
            C00712() {
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: ae */
            public final void mo112ae(String[] strArr) {
                AppMethodBeat.m2504i(120344);
                C8135b.this.strings = strArr;
                AppMethodBeat.m2505o(120344);
            }
        }

        private C0069b() {
        }

        /* synthetic */ C0069b(C8135b c8135b, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo118a(C37022f c37022f, Object obj) {
            AppMethodBeat.m2504i(120345);
            if (c37022f == null) {
                AppMethodBeat.m2505o(120345);
                return;
            }
            String str = c37022f.name;
            if ("k".equals(str)) {
                if (obj instanceof Integer) {
                    C8135b.this.Bsv = C8132a.m14316SO(((Integer) obj).intValue());
                    AppMethodBeat.m2505o(120345);
                    return;
                }
            } else if ("mv".equals(str)) {
                if (obj instanceof int[]) {
                    C8135b.this.Bsu = (int[]) obj;
                    AppMethodBeat.m2505o(120345);
                    return;
                }
            } else if ("bv".equals(str)) {
                if (obj instanceof int[]) {
                    C8135b.this.Bse = new C17257d((int[]) obj);
                    AppMethodBeat.m2505o(120345);
                    return;
                }
            } else if ("xs".equals(str)) {
                if (obj instanceof String) {
                    C8135b.this.Bsh = (String) obj;
                    AppMethodBeat.m2505o(120345);
                    return;
                }
            } else if ("xi".equals(str)) {
                if (obj instanceof Integer) {
                    C8135b.this.Bsi = ((Integer) obj).intValue();
                    AppMethodBeat.m2505o(120345);
                    return;
                }
            } else if ("pn".equals(str) && (obj instanceof String)) {
                C8135b.this.packageName = (String) obj;
            }
            AppMethodBeat.m2505o(120345);
        }

        /* renamed from: a */
        public final void mo116a(C37022f c37022f, C8140d c8140d) {
        }

        /* renamed from: a */
        public final void mo117a(C37022f c37022f, C8173a c8173a, C37022f c37022f2) {
        }

        /* renamed from: a */
        public final C8145a mo115a(C37022f c37022f, C8173a c8173a) {
            return null;
        }

        /* renamed from: zn */
        public final void mo120zn() {
        }

        /* renamed from: o */
        public final C8144b mo119o(C37022f c37022f) {
            AppMethodBeat.m2504i(120346);
            String str = c37022f.name;
            if ("d1".equals(str)) {
                C00701 c00701 = new C00701();
                AppMethodBeat.m2505o(120346);
                return c00701;
            } else if ("d2".equals(str)) {
                C8144b c00712 = new C00712();
                AppMethodBeat.m2505o(120346);
                return c00712;
            } else {
                AppMethodBeat.m2505o(120346);
                return null;
            }
        }
    }

    /* renamed from: a.i.b.a.c.d.b.a.b$c */
    class C8136c implements C8145a {

        /* renamed from: a.i.b.a.c.d.b.a.b$c$1 */
        class C81371 extends C0068a {
            C81371() {
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: ae */
            public final void mo112ae(String[] strArr) {
                AppMethodBeat.m2504i(120347);
                C8135b.this.Bsf = strArr;
                AppMethodBeat.m2505o(120347);
            }
        }

        /* renamed from: a.i.b.a.c.d.b.a.b$c$2 */
        class C81382 extends C0068a {
            C81382() {
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: ae */
            public final void mo112ae(String[] strArr) {
                AppMethodBeat.m2504i(120348);
                C8135b.this.strings = strArr;
                AppMethodBeat.m2505o(120348);
            }
        }

        private C8136c() {
        }

        /* synthetic */ C8136c(C8135b c8135b, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo118a(C37022f c37022f, Object obj) {
            AppMethodBeat.m2504i(120349);
            if (c37022f == null) {
                AppMethodBeat.m2505o(120349);
                return;
            }
            String str = c37022f.name;
            if ("version".equals(str)) {
                if (obj instanceof int[]) {
                    C8135b.this.Bsu = (int[]) obj;
                    if (C8135b.this.Bse == null) {
                        C8135b.this.Bse = new C17257d((int[]) obj);
                        AppMethodBeat.m2505o(120349);
                        return;
                    }
                }
            } else if ("multifileClassName".equals(str)) {
                C8135b.this.Bsh = obj instanceof String ? (String) obj : null;
            }
            AppMethodBeat.m2505o(120349);
        }

        /* renamed from: a */
        public final void mo116a(C37022f c37022f, C8140d c8140d) {
        }

        /* renamed from: a */
        public final void mo117a(C37022f c37022f, C8173a c8173a, C37022f c37022f2) {
        }

        /* renamed from: a */
        public final C8145a mo115a(C37022f c37022f, C8173a c8173a) {
            return null;
        }

        /* renamed from: zn */
        public final void mo120zn() {
        }

        /* renamed from: o */
        public final C8144b mo119o(C37022f c37022f) {
            AppMethodBeat.m2504i(120350);
            String str = c37022f.name;
            if ("data".equals(str) || "filePartClassNames".equals(str)) {
                C81371 c81371 = new C81371();
                AppMethodBeat.m2505o(120350);
                return c81371;
            } else if ("strings".equals(str)) {
                C8144b c81382 = new C81382();
                AppMethodBeat.m2505o(120350);
                return c81382;
            } else {
                AppMethodBeat.m2505o(120350);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(120352);
        HashMap hashMap = new HashMap();
        Bst = hashMap;
        hashMap.put(C8173a.m14427n(new C8174b("kotlin.jvm.internal.KotlinClass")), C8132a.CLASS);
        Bst.put(C8173a.m14427n(new C8174b("kotlin.jvm.internal.KotlinFileFacade")), C8132a.FILE_FACADE);
        Bst.put(C8173a.m14427n(new C8174b("kotlin.jvm.internal.KotlinMultifileClass")), C8132a.MULTIFILE_CLASS);
        Bst.put(C8173a.m14427n(new C8174b("kotlin.jvm.internal.KotlinMultifileClassPart")), C8132a.MULTIFILE_CLASS_PART);
        Bst.put(C8173a.m14427n(new C8174b("kotlin.jvm.internal.KotlinSyntheticClass")), C8132a.SYNTHETIC_CLASS);
        AppMethodBeat.m2505o(120352);
    }

    /* renamed from: a */
    public final C8145a mo17930a(C8173a c8173a, C41398am c41398am) {
        AppMethodBeat.m2504i(120351);
        if (c8173a.ehE().equals(C17230p.Bll)) {
            C0069b c0069b = new C0069b(this, (byte) 0);
            AppMethodBeat.m2505o(120351);
            return c0069b;
        } else if (Bss) {
            AppMethodBeat.m2505o(120351);
            return null;
        } else if (this.Bsv != null) {
            AppMethodBeat.m2505o(120351);
            return null;
        } else {
            C8132a c8132a = (C8132a) Bst.get(c8173a);
            if (c8132a != null) {
                this.Bsv = c8132a;
                C8145a c8136c = new C8136c(this, (byte) 0);
                AppMethodBeat.m2505o(120351);
                return c8136c;
            }
            AppMethodBeat.m2505o(120351);
            return null;
        }
    }

    /* renamed from: zn */
    public final void mo17931zn() {
    }
}
