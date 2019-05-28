package a.i.b.a.c.l;

import a.a.ag;
import a.a.m;
import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.ar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class ao extends as {
    public static final a BJQ = new a();

    public static final class a {

        public static final class a extends ao {
            final /* synthetic */ Map BJR;
            final /* synthetic */ boolean BJS = false;

            a(Map map) {
                this.BJR = map;
            }

            public final ap c(an anVar) {
                AppMethodBeat.i(122650);
                j.p(anVar, "key");
                ap apVar = (ap) this.BJR.get(anVar);
                AppMethodBeat.o(122650);
                return apVar;
            }

            public final boolean isEmpty() {
                AppMethodBeat.i(122651);
                boolean isEmpty = this.BJR.isEmpty();
                AppMethodBeat.o(122651);
                return isEmpty;
            }

            public final boolean eki() {
                return this.BJS;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static ao bf(Map<an, ? extends ap> map) {
            AppMethodBeat.i(122652);
            j.p(map, "map");
            ao aVar = new a(map);
            AppMethodBeat.o(122652);
            return aVar;
        }

        public static as au(w wVar) {
            AppMethodBeat.i(122653);
            j.p(wVar, "kotlinType");
            as a = a(wVar.ejw(), wVar.ejt());
            AppMethodBeat.o(122653);
            return a;
        }

        public static as a(an anVar, List<? extends ap> list) {
            AppMethodBeat.i(122654);
            j.p(anVar, "typeConstructor");
            j.p(list, "arguments");
            List parameters = anVar.getParameters();
            j.o(parameters, "typeConstructor.parameters");
            ar arVar = (ar) t.fM(parameters);
            as bf;
            if (arVar != null ? arVar.dZb() : false) {
                List parameters2 = anVar.getParameters();
                j.o(parameters2, "typeConstructor.parameters");
                Iterable<ar> iterable = parameters2;
                Collection arrayList = new ArrayList(m.d(iterable));
                for (ar arVar2 : iterable) {
                    j.o(arVar2, "it");
                    arrayList.add(arVar2.dXY());
                }
                bf = bf(ag.v(t.a((Iterable) (List) arrayList, (Iterable) list)));
                AppMethodBeat.o(122654);
                return bf;
            }
            bf = new u(parameters, (List) list);
            AppMethodBeat.o(122654);
            return bf;
        }
    }

    public static final as a(an anVar, List<? extends ap> list) {
        return a.a(anVar, list);
    }

    public abstract ap c(an anVar);

    public final ap O(w wVar) {
        j.p(wVar, "key");
        return c(wVar.ejw());
    }

    public static final ao be(Map<an, ? extends ap> map) {
        return a.bf(map);
    }
}
