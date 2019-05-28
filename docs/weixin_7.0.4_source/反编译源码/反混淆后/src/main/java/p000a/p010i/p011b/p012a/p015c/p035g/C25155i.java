package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import p000a.p010i.p011b.p012a.p015c.p035g.C0114a.C0115a;
import p000a.p010i.p011b.p012a.p015c.p035g.C17266h.C17267a;
import p000a.p010i.p011b.p012a.p015c.p035g.C17273z.C17274b;
import p000a.p010i.p011b.p012a.p015c.p035g.C17273z.C8190a;
import p000a.p010i.p011b.p012a.p015c.p035g.C31715g.C0119a;
import p000a.p010i.p011b.p012a.p015c.p035g.C44902l.C8184b;
import p000a.p010i.p011b.p012a.p015c.p035g.C8181j.C8182b;
import p000a.p010i.p011b.p012a.p015c.p035g.C8181j.C8183a;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q.C8186a;

/* renamed from: a.i.b.a.c.g.i */
public abstract class C25155i extends C0114a implements Serializable {

    /* renamed from: a.i.b.a.c.g.i$d */
    public interface C8179d extends C17270r {
    }

    /* renamed from: a.i.b.a.c.g.i$f */
    public static class C8180f<ContainingType extends C8185q, Type> {
        final ContainingType BzS;
        final C8185q BzT;
        final C25156e BzU;
        final Class BzV;
        final Method BzW;
        final Type aze;

        C8180f(ContainingType containingType, Type type, C8185q c8185q, C25156e c25156e, Class cls) {
            AppMethodBeat.m2504i(121525);
            IllegalArgumentException illegalArgumentException;
            if (containingType == null) {
                illegalArgumentException = new IllegalArgumentException("Null containingTypeDefaultInstance");
                AppMethodBeat.m2505o(121525);
                throw illegalArgumentException;
            } else if (c25156e.BzP == C8190a.MESSAGE && c8185q == null) {
                illegalArgumentException = new IllegalArgumentException("Null messageDefaultInstance");
                AppMethodBeat.m2505o(121525);
                throw illegalArgumentException;
            } else {
                this.BzS = containingType;
                this.aze = type;
                this.BzT = c8185q;
                this.BzU = c25156e;
                this.BzV = cls;
                if (C8183a.class.isAssignableFrom(cls)) {
                    this.BzW = C25155i.m39623d(cls, "valueOf", Integer.TYPE);
                    AppMethodBeat.m2505o(121525);
                    return;
                }
                this.BzW = null;
                AppMethodBeat.m2505o(121525);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dM */
        public final Object mo17991dM(Object obj) {
            AppMethodBeat.m2504i(121526);
            if (this.BzU.BzP.BBj == C17274b.ENUM) {
                obj = C25155i.m39622d(this.BzW, (Integer) obj);
                AppMethodBeat.m2505o(121526);
                return obj;
            }
            AppMethodBeat.m2505o(121526);
            return obj;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dN */
        public final Object mo17992dN(Object obj) {
            AppMethodBeat.m2504i(121527);
            if (this.BzU.BzP.BBj == C17274b.ENUM) {
                Integer valueOf = Integer.valueOf(((C8183a) obj).edd());
                AppMethodBeat.m2505o(121527);
                return valueOf;
            }
            AppMethodBeat.m2505o(121527);
            return obj;
        }
    }

    /* renamed from: a.i.b.a.c.g.i$e */
    static final class C25156e implements C17267a<C25156e> {
        final C8182b<?> BzO = null;
        final C8190a BzP;
        final boolean BzQ;
        final boolean BzR;
        final int number;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.number - ((C25156e) obj).number;
        }

        C25156e(int i, C8190a c8190a, boolean z) {
            this.number = i;
            this.BzP = c8190a;
            this.BzQ = z;
            this.BzR = false;
        }

        public final int edd() {
            return this.number;
        }

        public final C8190a eik() {
            return this.BzP;
        }

        public final C17274b eil() {
            return this.BzP.BBj;
        }

        public final boolean eim() {
            return this.BzQ;
        }

        public final boolean ein() {
            return this.BzR;
        }

        /* renamed from: a */
        public final C8186a mo31346a(C8186a c8186a, C8185q c8185q) {
            AppMethodBeat.m2504i(121524);
            C25159a a = ((C25159a) c8186a).mo147a((C25155i) c8185q);
            AppMethodBeat.m2505o(121524);
            return a;
        }
    }

    /* renamed from: a.i.b.a.c.g.i$b */
    public static abstract class C25157b<MessageType extends C25158c<MessageType>, BuilderType extends C25157b<MessageType, BuilderType>> extends C25159a<MessageType, BuilderType> implements C8179d<MessageType> {
        protected C17266h<C25156e> BzI = C17266h.eih();
        private boolean BzJ;

        protected C25157b() {
        }

        /* renamed from: edA */
        public BuilderType ecL() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo42015a(MessageType messageType) {
            if (!this.BzJ) {
                this.BzI = this.BzI.eij();
                this.BzJ = true;
            }
            C17266h c17266h = this.BzI;
            C17266h b = messageType.BzI;
            for (int i = 0; i < b.BzC.eiF(); i++) {
                c17266h.mo31340b(b.BzC.mo66067UF(i));
            }
            for (Entry b2 : b.BzC.eiG()) {
                c17266h.mo31340b(b2);
            }
        }
    }

    /* renamed from: a.i.b.a.c.g.i$c */
    public static abstract class C25158c<MessageType extends C25158c<MessageType>> extends C25155i implements C8179d<MessageType> {
        protected final C17266h<C25156e> BzI;

        /* renamed from: a.i.b.a.c.g.i$c$a */
        public class C8178a {
            private final Iterator<Entry<C25156e, Object>> BzK;
            private Entry<C25156e, Object> BzL;
            private final boolean BzM;

            /* synthetic */ C8178a(C25158c c25158c, byte b) {
                this();
            }

            private C8178a() {
                Iterator c8184b;
                AppMethodBeat.m2504i(121522);
                C17266h b = C25158c.this.BzI;
                if (b.BzE) {
                    c8184b = new C8184b(b.BzC.entrySet().iterator());
                } else {
                    c8184b = b.BzC.entrySet().iterator();
                }
                this.BzK = c8184b;
                if (this.BzK.hasNext()) {
                    this.BzL = (Entry) this.BzK.next();
                }
                this.BzM = false;
                AppMethodBeat.m2505o(121522);
            }

            /* renamed from: b */
            public final void mo17990b(int i, C37024f c37024f) {
                AppMethodBeat.m2504i(121523);
                while (this.BzL != null && ((C25156e) this.BzL.getKey()).number < i) {
                    C17267a c17267a = (C25156e) this.BzL.getKey();
                    if (this.BzM && c17267a.BzP.BBj == C17274b.MESSAGE && !c17267a.BzQ) {
                        c37024f.mo59049b(c17267a.number, (C8185q) this.BzL.getValue());
                    } else {
                        C17266h.m26738a(c17267a, this.BzL.getValue(), c37024f);
                    }
                    if (this.BzK.hasNext()) {
                        this.BzL = (Entry) this.BzK.next();
                    } else {
                        this.BzL = null;
                    }
                }
                AppMethodBeat.m2505o(121523);
            }
        }

        protected C25158c() {
            this.BzI = C17266h.eig();
        }

        protected C25158c(C25157b<MessageType, ?> c25157b) {
            this.BzI = C25157b.m39626a((C25157b) c25157b);
        }

        /* renamed from: c */
        public final <Type> boolean mo42017c(C8180f<MessageType, Type> c8180f) {
            m39629b((C8180f) c8180f);
            C17266h c17266h = this.BzI;
            C25156e c25156e = c8180f.BzU;
            if (!c25156e.eim()) {
                return c17266h.BzC.get(c25156e) != null;
            } else {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
        }

        /* renamed from: d */
        public final <Type> int mo42018d(C8180f<MessageType, List<Type>> c8180f) {
            m39629b((C8180f) c8180f);
            C17266h c17266h = this.BzI;
            C17267a c17267a = c8180f.BzU;
            if (c17267a.eim()) {
                Object a = c17266h.mo31337a(c17267a);
                if (a == null) {
                    return 0;
                }
                return ((List) a).size();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        /* renamed from: e */
        public final <Type> Type mo42019e(C8180f<MessageType, Type> c8180f) {
            m39629b((C8180f) c8180f);
            Type a = this.BzI.mo31337a(c8180f.BzU);
            if (a == null) {
                return c8180f.aze;
            }
            if (!c8180f.BzU.BzQ) {
                return c8180f.mo17991dM(a);
            }
            if (c8180f.BzU.BzP.BBj != C17274b.ENUM) {
                return a;
            }
            Type arrayList = new ArrayList();
            for (Object dM : (List) a) {
                arrayList.add(c8180f.mo17991dM(dM));
            }
            return arrayList;
        }

        /* renamed from: a */
        public final <Type> Type mo42016a(C8180f<MessageType, List<Type>> c8180f, int i) {
            m39629b((C8180f) c8180f);
            C17266h c17266h = this.BzI;
            C17267a c17267a = c8180f.BzU;
            if (c17267a.eim()) {
                Object a = c17266h.mo31337a(c17267a);
                if (a != null) {
                    return c8180f.mo17991dM(((List) a).get(i));
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        /* Access modifiers changed, original: protected|final */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00db  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x002d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo42012a(C31713e c31713e, C37024f c37024f, C31715g c31715g, int i) {
            boolean z;
            boolean z2;
            C17266h c17266h = this.BzI;
            C8185q ecE = ecE();
            int fy = C17273z.m26754fy(i);
            C8180f c8180f = (C8180f) c31715g.BzA.get(new C0119a(ecE, C17273z.m26755fz(i)));
            if (c8180f != null) {
                if (fy == C17266h.m26734a(c8180f.BzU.BzP, false)) {
                    z = false;
                    z2 = false;
                } else if (c8180f.BzU.BzQ && c8180f.BzU.BzP.eiN() && fy == C17266h.m26734a(c8180f.BzU.BzP, true)) {
                    z = true;
                    z2 = false;
                }
                if (!z2) {
                    return c31713e.mo51684a(i, c37024f);
                }
                if (z) {
                    fy = c31713e.mo51690fo(c31713e.mo51693vd());
                    if (c8180f.BzU.BzP == C8190a.ENUM) {
                        while (c31713e.mo51695vg() > 0) {
                            C8183a SW = c8180f.BzU.BzO.mo146SW(c31713e.mo51693vd());
                            if (SW == null) {
                                break;
                            }
                            c17266h.mo31339b(c8180f.BzU, c8180f.mo17992dN(SW));
                        }
                    } else {
                        while (c31713e.mo51695vg() > 0) {
                            c17266h.mo31339b(c8180f.BzU, C17266h.m26735a(c31713e, c8180f.BzU.BzP));
                        }
                    }
                    c31713e.mo51691fp(fy);
                } else {
                    Object ecM;
                    int i2;
                    switch (c8180f.BzU.BzP.BBj) {
                        case MESSAGE:
                            C8186a ecC;
                            if (!c8180f.BzU.BzQ) {
                                C8185q c8185q = (C8185q) c17266h.mo31337a(c8180f.BzU);
                                if (c8185q != null) {
                                    ecC = c8185q.ecC();
                                    if (ecC == null) {
                                        ecC = c8180f.BzT.ecD();
                                    }
                                    if (c8180f.BzU.BzP != C8190a.GROUP) {
                                        i2 = c8180f.BzU.number;
                                        if (c31713e.bxp >= c31713e.bxq) {
                                            throw C41425k.eiw();
                                        }
                                        c31713e.bxp++;
                                        ecC.mo150d(c31713e, c31715g);
                                        c31713e.mo51689fm(C17273z.m26753bv(i2, 4));
                                        c31713e.bxp--;
                                    } else {
                                        i2 = c31713e.mo51693vd();
                                        if (c31713e.bxp >= c31713e.bxq) {
                                            throw C41425k.eiw();
                                        }
                                        i2 = c31713e.mo51690fo(i2);
                                        c31713e.bxp++;
                                        ecC.mo150d(c31713e, c31715g);
                                        c31713e.mo51689fm(0);
                                        c31713e.bxp--;
                                        c31713e.mo51691fp(i2);
                                    }
                                    ecM = ecC.ecM();
                                }
                            }
                            ecC = null;
                            if (ecC == null) {
                            }
                            if (c8180f.BzU.BzP != C8190a.GROUP) {
                            }
                            ecM = ecC.ecM();
                        case ENUM:
                            i2 = c31713e.mo51693vd();
                            ecM = c8180f.BzU.BzO.mo146SW(i2);
                            if (ecM == null) {
                                c37024f.mo59058fw(i);
                                c37024f.mo59058fw(i2);
                                break;
                            }
                        default:
                            ecM = C17266h.m26735a(c31713e, c8180f.BzU.BzP);
                    }
                    if (c8180f.BzU.BzQ) {
                        c17266h.mo31339b(c8180f.BzU, c8180f.mo17992dN(ecM));
                    } else {
                        c17266h.mo31338a(c8180f.BzU, c8180f.mo17992dN(ecM));
                    }
                }
                return true;
            }
            z = false;
            z2 = true;
            if (!z2) {
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void eio() {
            this.BzI.eii();
        }

        /* Access modifiers changed, original: protected|final */
        public final C8178a eip() {
            return new C8178a(this, (byte) 0);
        }

        /* renamed from: b */
        private void m39629b(C8180f<MessageType, ?> c8180f) {
            if (c8180f.BzS != ecE()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }
    }

    /* renamed from: a.i.b.a.c.g.i$a */
    public static abstract class C25159a<MessageType extends C25155i, BuilderType extends C25159a> extends C0115a<BuilderType> {
        public C31710d BsB = C31710d.Bzq;

        /* renamed from: a */
        public abstract BuilderType mo147a(MessageType messageType);

        /* renamed from: ecJ */
        public abstract MessageType ecE();

        protected C25159a() {
        }

        /* renamed from: ecK */
        public BuilderType ecL() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    protected C25155i() {
    }

    protected C25155i(byte b) {
    }

    public C25163s<? extends C8185q> ecy() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo42012a(C31713e c31713e, C37024f c37024f, C31715g c31715g, int i) {
        return c31713e.mo51684a(i, c37024f);
    }

    /* Access modifiers changed, original: protected */
    public void eio() {
    }

    /* renamed from: a */
    public static <ContainingType extends C8185q, Type> C8180f<ContainingType, Type> m39621a(ContainingType containingType, Type type, C8185q c8185q, int i, C8190a c8190a, Class cls) {
        return new C8180f(containingType, type, c8185q, new C25156e(i, c8190a, false), cls);
    }

    /* renamed from: a */
    public static <ContainingType extends C8185q, Type> C8180f<ContainingType, Type> m39620a(ContainingType containingType, C8185q c8185q, int i, C8190a c8190a, Class cls) {
        return new C8180f(containingType, Collections.emptyList(), c8185q, new C25156e(i, c8190a, true), cls);
    }

    /* renamed from: d */
    static Method m39623d(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            String valueOf = String.valueOf(String.valueOf(cls.getName()));
            String valueOf2 = String.valueOf(String.valueOf(str));
            throw new RuntimeException(new StringBuilder((valueOf.length() + 45) + valueOf2.length()).append("Generated message class \"").append(valueOf).append("\" missing method \"").append(valueOf2).append("\".").toString(), e);
        }
    }

    /* renamed from: d */
    static Object m39622d(Method method, Object... objArr) {
        try {
            return method.invoke(null, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }
}
