package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31826o;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.C31754k;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.m */
public final class C8207m extends C0132a {
    public static final C8206a BGp = new C8206a();
    private final C17284b BGo;

    /* renamed from: a.i.b.a.c.i.e.m$a */
    public static final class C8206a {
        private C8206a() {
        }

        public /* synthetic */ C8206a(byte b) {
            this();
        }
    }

    /* renamed from: a.i.b.a.c.i.e.m$c */
    static final class C8208c extends C25053k implements C17126b<C41397al, C41397al> {
        public static final C8208c BGr = new C8208c();

        static {
            AppMethodBeat.m2504i(122222);
            AppMethodBeat.m2505o(122222);
        }

        C8208c() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122221);
            C41397al c41397al = (C41397al) obj;
            C25052j.m39376p(c41397al, "receiver$0");
            AppMethodBeat.m2505o(122221);
            return c41397al;
        }
    }

    /* renamed from: a.i.b.a.c.i.e.m$b */
    static final class C8209b extends C25053k implements C17126b<C8045a, C8045a> {
        public static final C8209b BGq = new C8209b();

        static {
            AppMethodBeat.m2504i(122220);
            AppMethodBeat.m2505o(122220);
        }

        C8209b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122219);
            C8045a c8045a = (C8045a) obj;
            C25052j.m39376p(c8045a, "receiver$0");
            AppMethodBeat.m2505o(122219);
            return c8045a;
        }
    }

    /* renamed from: a.i.b.a.c.i.e.m$d */
    static final class C8210d extends C25053k implements C17126b<C31220ah, C31220ah> {
        public static final C8210d BGs = new C8210d();

        static {
            AppMethodBeat.m2504i(122224);
            AppMethodBeat.m2505o(122224);
        }

        C8210d() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122223);
            C31220ah c31220ah = (C31220ah) obj;
            C25052j.m39376p(c31220ah, "receiver$0");
            AppMethodBeat.m2505o(122223);
            return c31220ah;
        }
    }

    static {
        AppMethodBeat.m2504i(122228);
        AppMethodBeat.m2505o(122228);
    }

    private C8207m(C17284b c17284b) {
        this.BGo = c17284b;
    }

    private /* synthetic */ C8207m(C17284b c17284b, byte b) {
        this(c17284b);
    }

    /* renamed from: b */
    public final Collection<C41397al> mo221b(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122225);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection b = C31754k.m51428b(super.mo221b(c37022f, c8085a), C8208c.BGr);
        AppMethodBeat.m2505o(122225);
        return b;
    }

    /* renamed from: a */
    public final Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122226);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection b = C31754k.m51428b(super.mo219a(c37022f, c8085a), C8210d.BGs);
        AppMethodBeat.m2505o(122226);
        return b;
    }

    /* renamed from: a */
    public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(122227);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        Iterable a = super.mo220a(c0136d, (C17126b) c17126b);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : a) {
            if (((C31642l) next) instanceof C8045a) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        C31826o c31826o = new C31826o(arrayList, arrayList2);
        List list = (List) c31826o.first;
        List list2 = (List) c31826o.second;
        if (list == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
            AppMethodBeat.m2505o(122227);
            throw c44941v;
        }
        Collection b = C25035t.m39331b(C31754k.m51428b(list, C8209b.BGq), (Iterable) list2);
        AppMethodBeat.m2505o(122227);
        return b;
    }

    public final /* bridge */ /* synthetic */ C31746h ejA() {
        return this.BGo;
    }

    /* renamed from: a */
    public static final C31746h m14504a(String str, Collection<? extends C46867w> collection) {
        AppMethodBeat.m2504i(122229);
        C25052j.m39376p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        C25052j.m39376p(collection, "types");
        Iterable<C46867w> iterable = collection;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C46867w dXR : iterable) {
            arrayList.add(dXR.dXR());
        }
        C17284b c17284b = new C17284b(str, (List) arrayList);
        C31746h c31746h;
        if (collection.size() <= 1) {
            c31746h = c17284b;
            AppMethodBeat.m2505o(122229);
            return c31746h;
        }
        c31746h = new C8207m(c17284b, (byte) 0);
        AppMethodBeat.m2505o(122229);
        return c31746h;
    }
}
