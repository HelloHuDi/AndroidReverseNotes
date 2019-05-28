package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;

/* renamed from: a.i.b.a.c.l.ao */
public abstract class C25225ao extends C44922as {
    public static final C8238a BJQ = new C8238a();

    /* renamed from: a.i.b.a.c.l.ao$a */
    public static final class C8238a {

        /* renamed from: a.i.b.a.c.l.ao$a$a */
        public static final class C8239a extends C25225ao {
            final /* synthetic */ Map BJR;
            final /* synthetic */ boolean BJS = false;

            C8239a(Map map) {
                this.BJR = map;
            }

            /* renamed from: c */
            public final C41446ap mo18037c(C17313an c17313an) {
                AppMethodBeat.m2504i(122650);
                C25052j.m39376p(c17313an, "key");
                C41446ap c41446ap = (C41446ap) this.BJR.get(c17313an);
                AppMethodBeat.m2505o(122650);
                return c41446ap;
            }

            public final boolean isEmpty() {
                AppMethodBeat.m2504i(122651);
                boolean isEmpty = this.BJR.isEmpty();
                AppMethodBeat.m2505o(122651);
                return isEmpty;
            }

            public final boolean eki() {
                return this.BJS;
            }
        }

        private C8238a() {
        }

        public /* synthetic */ C8238a(byte b) {
            this();
        }

        /* renamed from: bf */
        public static C25225ao m14560bf(Map<C17313an, ? extends C41446ap> map) {
            AppMethodBeat.m2504i(122652);
            C25052j.m39376p(map, "map");
            C25225ao c8239a = new C8239a(map);
            AppMethodBeat.m2505o(122652);
            return c8239a;
        }

        /* renamed from: au */
        public static C44922as m14559au(C46867w c46867w) {
            AppMethodBeat.m2504i(122653);
            C25052j.m39376p(c46867w, "kotlinType");
            C44922as a = C8238a.m14558a(c46867w.ejw(), c46867w.ejt());
            AppMethodBeat.m2505o(122653);
            return a;
        }

        /* renamed from: a */
        public static C44922as m14558a(C17313an c17313an, List<? extends C41446ap> list) {
            AppMethodBeat.m2504i(122654);
            C25052j.m39376p(c17313an, "typeConstructor");
            C25052j.m39376p(list, "arguments");
            List parameters = c17313an.getParameters();
            C25052j.m39375o(parameters, "typeConstructor.parameters");
            C36955ar c36955ar = (C36955ar) C25035t.m39340fM(parameters);
            C44922as bf;
            if (c36955ar != null ? c36955ar.dZb() : false) {
                List parameters2 = c17313an.getParameters();
                C25052j.m39375o(parameters2, "typeConstructor.parameters");
                Iterable<C36955ar> iterable = parameters2;
                Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
                for (C36955ar c36955ar2 : iterable) {
                    C25052j.m39375o(c36955ar2, "it");
                    arrayList.add(c36955ar2.dXY());
                }
                bf = C8238a.m14560bf(C31586ag.m51052v(C25035t.m39325a((Iterable) (List) arrayList, (Iterable) list)));
                AppMethodBeat.m2505o(122654);
                return bf;
            }
            bf = new C46866u(parameters, (List) list);
            AppMethodBeat.m2505o(122654);
            return bf;
        }
    }

    /* renamed from: a */
    public static final C44922as m39757a(C17313an c17313an, List<? extends C41446ap> list) {
        return C8238a.m14558a(c17313an, list);
    }

    /* renamed from: c */
    public abstract C41446ap mo18037c(C17313an c17313an);

    /* renamed from: O */
    public final C41446ap mo31386O(C46867w c46867w) {
        C25052j.m39376p(c46867w, "key");
        return mo18037c(c46867w.ejw());
    }

    /* renamed from: be */
    public static final C25225ao m39758be(Map<C17313an, ? extends C41446ap> map) {
        return C8238a.m14560bf(map);
    }
}
