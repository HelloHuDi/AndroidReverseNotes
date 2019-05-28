package p000a.p010i.p011b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C25046c;
import p000a.C31826o;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25051i;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C36663b;
import p000a.p010i.C44935d;
import p000a.p010i.C8295e;
import p000a.p010i.p011b.p012a.C25070a;
import p000a.p010i.p011b.p012a.C31794j;
import p000a.p010i.p011b.p012a.C8017af;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C31694o;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36999ag;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41421g;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41422h;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41424j;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C0147q;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, dWq = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflect-api"})
/* renamed from: a.i.b.b */
public final class C25267b {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;", "R", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
    /* renamed from: a.i.b.b$a */
    static final class C0209a extends C25051i implements C31591m<C0147q, C31694o, C41397al> {
        public static final C0209a AWd = new C0209a();

        static {
            AppMethodBeat.m2504i(118658);
            AppMethodBeat.m2505o(118658);
        }

        C0209a() {
            super(2);
        }

        public final C44935d dWF() {
            AppMethodBeat.m2504i(118657);
            C36663b aN = C44855v.m82055aN(C0147q.class);
            AppMethodBeat.m2505o(118657);
            return aN;
        }

        public final String due() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        public final String getName() {
            return "loadFunction";
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(118656);
            C0147q c0147q = (C0147q) obj;
            C31694o c31694o = (C31694o) obj2;
            C25052j.m39376p(c0147q, "p1");
            C25052j.m39376p(c31694o, "p2");
            C41397al g = c0147q.mo239g(c31694o);
            AppMethodBeat.m2505o(118656);
            return g;
        }
    }

    /* renamed from: a */
    public static final <R> C8295e<R> m39837a(C25046c<? extends R> c25046c) {
        AppMethodBeat.m2504i(118659);
        C25052j.m39376p(c25046c, "receiver$0");
        C0220l c0220l = (C0220l) c25046c.getClass().getAnnotation(C0220l.class);
        if (c0220l == null) {
            AppMethodBeat.m2505o(118659);
            return null;
        }
        String[] dWp = c0220l.dWp();
        if ((dWp.length == 0 ? 1 : null) != null) {
            dWp = null;
        }
        if (dWp == null) {
            AppMethodBeat.m2505o(118659);
            return null;
        }
        C31826o f = C41424j.m72249f(dWp, c0220l.dWq());
        C41422h c41422h = (C41422h) f.first;
        C31694o c31694o = (C31694o) f.second;
        C41421g c41421g = new C41421g(c0220l.dWo(), (c0220l.dWr() & 8) != 0);
        Class cls = c25046c.getClass();
        C8185q c8185q = c31694o;
        C31702c c31702c = c41422h;
        C36999ag c36999ag = c31694o.BtC;
        C25052j.m39375o(c36999ag, "proto.typeTable");
        C41397al c41397al = (C41397al) C8017af.m14192a(cls, c8185q, c31702c, new C41420h(c36999ag), c41421g, C0209a.AWd);
        if (c41397al == null) {
            AppMethodBeat.m2505o(118659);
            return null;
        }
        C8295e<R> c31794j = new C31794j(C25070a.AWe, c41397al);
        AppMethodBeat.m2505o(118659);
        return c31794j;
    }
}
