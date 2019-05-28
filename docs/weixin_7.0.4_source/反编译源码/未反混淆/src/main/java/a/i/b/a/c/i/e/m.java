package a.i.b.a.c.i.e;

import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.w;
import a.o;
import a.v;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class m extends a {
    public static final a BGp = new a();
    private final b BGo;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class c extends k implements a.f.a.b<al, al> {
        public static final c BGr = new c();

        static {
            AppMethodBeat.i(122222);
            AppMethodBeat.o(122222);
        }

        c() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122221);
            al alVar = (al) obj;
            j.p(alVar, "receiver$0");
            AppMethodBeat.o(122221);
            return alVar;
        }
    }

    static final class b extends k implements a.f.a.b<a.i.b.a.c.b.a, a.i.b.a.c.b.a> {
        public static final b BGq = new b();

        static {
            AppMethodBeat.i(122220);
            AppMethodBeat.o(122220);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122219);
            a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) obj;
            j.p(aVar, "receiver$0");
            AppMethodBeat.o(122219);
            return aVar;
        }
    }

    static final class d extends k implements a.f.a.b<ah, ah> {
        public static final d BGs = new d();

        static {
            AppMethodBeat.i(122224);
            AppMethodBeat.o(122224);
        }

        d() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122223);
            ah ahVar = (ah) obj;
            j.p(ahVar, "receiver$0");
            AppMethodBeat.o(122223);
            return ahVar;
        }
    }

    static {
        AppMethodBeat.i(122228);
        AppMethodBeat.o(122228);
    }

    private m(b bVar) {
        this.BGo = bVar;
    }

    private /* synthetic */ m(b bVar, byte b) {
        this(bVar);
    }

    public final Collection<al> b(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122225);
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        Collection b = a.i.b.a.c.i.k.b(super.b(fVar, aVar), c.BGr);
        AppMethodBeat.o(122225);
        return b;
    }

    public final Collection<ah> a(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122226);
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        Collection b = a.i.b.a.c.i.k.b(super.a(fVar, aVar), d.BGs);
        AppMethodBeat.o(122226);
        return b;
    }

    public final Collection<l> a(d dVar, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(122227);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        Iterable a = super.a(dVar, (a.f.a.b) bVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : a) {
            if (((l) next) instanceof a.i.b.a.c.b.a) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        o oVar = new o(arrayList, arrayList2);
        List list = (List) oVar.first;
        List list2 = (List) oVar.second;
        if (list == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
            AppMethodBeat.o(122227);
            throw vVar;
        }
        Collection b = t.b(a.i.b.a.c.i.k.b(list, b.BGq), (Iterable) list2);
        AppMethodBeat.o(122227);
        return b;
    }

    public final /* bridge */ /* synthetic */ h ejA() {
        return this.BGo;
    }

    public static final h a(String str, Collection<? extends w> collection) {
        AppMethodBeat.i(122229);
        j.p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        j.p(collection, "types");
        Iterable<w> iterable = collection;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (w dXR : iterable) {
            arrayList.add(dXR.dXR());
        }
        b bVar = new b(str, (List) arrayList);
        h hVar;
        if (collection.size() <= 1) {
            hVar = bVar;
            AppMethodBeat.o(122229);
            return hVar;
        }
        hVar = new m(bVar, (byte) 0);
        AppMethodBeat.o(122229);
        return hVar;
    }
}
