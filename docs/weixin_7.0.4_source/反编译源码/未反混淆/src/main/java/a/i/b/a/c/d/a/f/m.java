package a.i.b.a.c.d.a.f;

import a.a.ag;
import a.a.i;
import a.a.y;
import a.f.a.b;
import a.f.b.j;
import a.h.h;
import a.i.b.a.c.d.b.t;
import a.i.b.a.c.i.d.c;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class m {
    final Map<String, j> BqB = new LinkedHashMap();

    public final class a {
        final /* synthetic */ m BqC;
        final String className;

        public final class a {
            private o<String, r> BqD = u.I("V", null);
            final /* synthetic */ a BqE;
            private final String iBt;
            private final List<o<String, r>> parameters = new ArrayList();

            public a(a aVar, String str) {
                j.p(str, "functionName");
                this.BqE = aVar;
                AppMethodBeat.i(120183);
                this.iBt = str;
                AppMethodBeat.o(120183);
            }

            public final void a(String str, d... dVarArr) {
                Object obj;
                AppMethodBeat.i(120179);
                j.p(str, "type");
                j.p(dVarArr, "qualifiers");
                Collection collection = this.parameters;
                if ((dVarArr.length == 0 ? 1 : null) != null) {
                    obj = null;
                } else {
                    Iterable S = i.S(dVarArr);
                    Map linkedHashMap = new LinkedHashMap(h.im(ag.SI(a.a.m.d(S)), 16));
                    for (Object next : S) {
                        linkedHashMap.put(Integer.valueOf(((y) next).index), (d) ((y) next).value);
                    }
                    r obj2 = new r(linkedHashMap);
                }
                collection.add(u.I(str, obj2));
                AppMethodBeat.o(120179);
            }

            public final void b(String str, d... dVarArr) {
                AppMethodBeat.i(120180);
                j.p(str, "type");
                j.p(dVarArr, "qualifiers");
                Iterable S = i.S(dVarArr);
                Map linkedHashMap = new LinkedHashMap(h.im(ag.SI(a.a.m.d(S)), 16));
                for (Object next : S) {
                    linkedHashMap.put(Integer.valueOf(((y) next).index), (d) ((y) next).value);
                }
                this.BqD = u.I(str, new r(linkedHashMap));
                AppMethodBeat.o(120180);
            }

            public final o<String, j> eco() {
                AppMethodBeat.i(120182);
                t tVar = t.BrJ;
                String str = this.BqE.className;
                String str2 = this.iBt;
                Iterable<o> iterable = this.parameters;
                Collection arrayList = new ArrayList(a.a.m.d(iterable));
                for (o oVar : iterable) {
                    arrayList.add((String) oVar.first);
                }
                str2 = t.iV(str, t.e(str2, (List) arrayList, (String) this.BqD.first));
                r rVar = (r) this.BqD.second;
                Iterable<o> iterable2 = this.parameters;
                Collection arrayList2 = new ArrayList(a.a.m.d(iterable2));
                for (o oVar2 : iterable2) {
                    arrayList2.add((r) oVar2.second);
                }
                o oVar3 = u.I(str2, new j(rVar, (List) arrayList2));
                AppMethodBeat.o(120182);
                return oVar3;
            }

            public final void a(c cVar) {
                AppMethodBeat.i(120181);
                j.p(cVar, "type");
                this.BqD = u.I(cVar.desc, null);
                AppMethodBeat.o(120181);
            }
        }

        public a(m mVar, String str) {
            j.p(str, "className");
            this.BqC = mVar;
            AppMethodBeat.i(120185);
            this.className = str;
            AppMethodBeat.o(120185);
        }

        public final void c(String str, b<? super a, a.y> bVar) {
            AppMethodBeat.i(120184);
            j.p(str, "name");
            j.p(bVar, "block");
            Map map = this.BqC.BqB;
            a aVar = new a(this, str);
            bVar.am(aVar);
            o eco = aVar.eco();
            map.put(eco.first, eco.second);
            AppMethodBeat.o(120184);
        }
    }

    public m() {
        AppMethodBeat.i(120186);
        AppMethodBeat.o(120186);
    }
}
