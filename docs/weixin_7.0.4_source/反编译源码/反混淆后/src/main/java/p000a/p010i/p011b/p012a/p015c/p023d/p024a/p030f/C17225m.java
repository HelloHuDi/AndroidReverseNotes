package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p000a.C31826o;
import p000a.C37091y;
import p000a.C8312u;
import p000a.p001a.C25034m;
import p000a.p001a.C31586ag;
import p000a.p001a.C36913i;
import p000a.p001a.C41364y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C0016h;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44898t;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C25176c;

/* renamed from: a.i.b.a.c.d.a.f.m */
final class C17225m {
    final Map<String, C31676j> BqB = new LinkedHashMap();

    /* renamed from: a.i.b.a.c.d.a.f.m$a */
    public final class C17226a {
        final /* synthetic */ C17225m BqC;
        final String className;

        /* renamed from: a.i.b.a.c.d.a.f.m$a$a */
        public final class C17227a {
            private C31826o<String, C17228r> BqD = C8312u.m14628I("V", null);
            final /* synthetic */ C17226a BqE;
            private final String iBt;
            private final List<C31826o<String, C17228r>> parameters = new ArrayList();

            public C17227a(C17226a c17226a, String str) {
                C25052j.m39376p(str, "functionName");
                this.BqE = c17226a;
                AppMethodBeat.m2504i(120183);
                this.iBt = str;
                AppMethodBeat.m2505o(120183);
            }

            /* renamed from: a */
            public final void mo31290a(String str, C8119d... c8119dArr) {
                Object obj;
                AppMethodBeat.m2504i(120179);
                C25052j.m39376p(str, "type");
                C25052j.m39376p(c8119dArr, "qualifiers");
                Collection collection = this.parameters;
                if ((c8119dArr.length == 0 ? 1 : null) != null) {
                    obj = null;
                } else {
                    Iterable S = C36913i.m61686S(c8119dArr);
                    Map linkedHashMap = new LinkedHashMap(C0016h.m19im(C31586ag.m51047SI(C25034m.m39318d(S)), 16));
                    for (Object next : S) {
                        linkedHashMap.put(Integer.valueOf(((C41364y) next).index), (C8119d) ((C41364y) next).value);
                    }
                    C17228r obj2 = new C17228r(linkedHashMap);
                }
                collection.add(C8312u.m14628I(str, obj2));
                AppMethodBeat.m2505o(120179);
            }

            /* renamed from: b */
            public final void mo31291b(String str, C8119d... c8119dArr) {
                AppMethodBeat.m2504i(120180);
                C25052j.m39376p(str, "type");
                C25052j.m39376p(c8119dArr, "qualifiers");
                Iterable S = C36913i.m61686S(c8119dArr);
                Map linkedHashMap = new LinkedHashMap(C0016h.m19im(C31586ag.m51047SI(C25034m.m39318d(S)), 16));
                for (Object next : S) {
                    linkedHashMap.put(Integer.valueOf(((C41364y) next).index), (C8119d) ((C41364y) next).value);
                }
                this.BqD = C8312u.m14628I(str, new C17228r(linkedHashMap));
                AppMethodBeat.m2505o(120180);
            }

            public final C31826o<String, C31676j> eco() {
                AppMethodBeat.m2504i(120182);
                C44898t c44898t = C44898t.BrJ;
                String str = this.BqE.className;
                String str2 = this.iBt;
                Iterable<C31826o> iterable = this.parameters;
                Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
                for (C31826o c31826o : iterable) {
                    arrayList.add((String) c31826o.first);
                }
                str2 = C44898t.m82115iV(str, C44898t.m82114e(str2, (List) arrayList, (String) this.BqD.first));
                C17228r c17228r = (C17228r) this.BqD.second;
                Iterable<C31826o> iterable2 = this.parameters;
                Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable2));
                for (C31826o c31826o2 : iterable2) {
                    arrayList2.add((C17228r) c31826o2.second);
                }
                C31826o c31826o3 = C8312u.m14628I(str2, new C31676j(c17228r, (List) arrayList2));
                AppMethodBeat.m2505o(120182);
                return c31826o3;
            }

            /* renamed from: a */
            public final void mo31289a(C25176c c25176c) {
                AppMethodBeat.m2504i(120181);
                C25052j.m39376p(c25176c, "type");
                this.BqD = C8312u.m14628I(c25176c.desc, null);
                AppMethodBeat.m2505o(120181);
            }
        }

        public C17226a(C17225m c17225m, String str) {
            C25052j.m39376p(str, "className");
            this.BqC = c17225m;
            AppMethodBeat.m2504i(120185);
            this.className = str;
            AppMethodBeat.m2505o(120185);
        }

        /* renamed from: c */
        public final void mo31288c(String str, C17126b<? super C17227a, C37091y> c17126b) {
            AppMethodBeat.m2504i(120184);
            C25052j.m39376p(str, "name");
            C25052j.m39376p(c17126b, "block");
            Map map = this.BqC.BqB;
            C17227a c17227a = new C17227a(this, str);
            c17126b.mo50am(c17227a);
            C31826o eco = c17227a.eco();
            map.put(eco.first, eco.second);
            AppMethodBeat.m2505o(120184);
        }
    }

    public C17225m() {
        AppMethodBeat.m2504i(120186);
        AppMethodBeat.m2505o(120186);
    }
}
