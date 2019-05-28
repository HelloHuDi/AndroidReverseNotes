package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class i extends a implements Serializable {

    public interface d extends r {
    }

    public static class f<ContainingType extends q, Type> {
        final ContainingType BzS;
        final q BzT;
        final e BzU;
        final Class BzV;
        final Method BzW;
        final Type aze;

        f(ContainingType containingType, Type type, q qVar, e eVar, Class cls) {
            AppMethodBeat.i(121525);
            IllegalArgumentException illegalArgumentException;
            if (containingType == null) {
                illegalArgumentException = new IllegalArgumentException("Null containingTypeDefaultInstance");
                AppMethodBeat.o(121525);
                throw illegalArgumentException;
            } else if (eVar.BzP == a.i.b.a.c.g.z.a.MESSAGE && qVar == null) {
                illegalArgumentException = new IllegalArgumentException("Null messageDefaultInstance");
                AppMethodBeat.o(121525);
                throw illegalArgumentException;
            } else {
                this.BzS = containingType;
                this.aze = type;
                this.BzT = qVar;
                this.BzU = eVar;
                this.BzV = cls;
                if (a.i.b.a.c.g.j.a.class.isAssignableFrom(cls)) {
                    this.BzW = i.d(cls, "valueOf", Integer.TYPE);
                    AppMethodBeat.o(121525);
                    return;
                }
                this.BzW = null;
                AppMethodBeat.o(121525);
            }
        }

        /* Access modifiers changed, original: final */
        public final Object dM(Object obj) {
            AppMethodBeat.i(121526);
            if (this.BzU.BzP.BBj == a.i.b.a.c.g.z.b.ENUM) {
                obj = i.d(this.BzW, (Integer) obj);
                AppMethodBeat.o(121526);
                return obj;
            }
            AppMethodBeat.o(121526);
            return obj;
        }

        /* Access modifiers changed, original: final */
        public final Object dN(Object obj) {
            AppMethodBeat.i(121527);
            if (this.BzU.BzP.BBj == a.i.b.a.c.g.z.b.ENUM) {
                Integer valueOf = Integer.valueOf(((a.i.b.a.c.g.j.a) obj).edd());
                AppMethodBeat.o(121527);
                return valueOf;
            }
            AppMethodBeat.o(121527);
            return obj;
        }
    }

    static final class e implements a.i.b.a.c.g.h.a<e> {
        final a.i.b.a.c.g.j.b<?> BzO = null;
        final a.i.b.a.c.g.z.a BzP;
        final boolean BzQ;
        final boolean BzR;
        final int number;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.number - ((e) obj).number;
        }

        e(int i, a.i.b.a.c.g.z.a aVar, boolean z) {
            this.number = i;
            this.BzP = aVar;
            this.BzQ = z;
            this.BzR = false;
        }

        public final int edd() {
            return this.number;
        }

        public final a.i.b.a.c.g.z.a eik() {
            return this.BzP;
        }

        public final a.i.b.a.c.g.z.b eil() {
            return this.BzP.BBj;
        }

        public final boolean eim() {
            return this.BzQ;
        }

        public final boolean ein() {
            return this.BzR;
        }

        public final a.i.b.a.c.g.q.a a(a.i.b.a.c.g.q.a aVar, q qVar) {
            AppMethodBeat.i(121524);
            a a = ((a) aVar).a((i) qVar);
            AppMethodBeat.o(121524);
            return a;
        }
    }

    public static abstract class b<MessageType extends c<MessageType>, BuilderType extends b<MessageType, BuilderType>> extends a<MessageType, BuilderType> implements d<MessageType> {
        protected h<e> BzI = h.eih();
        private boolean BzJ;

        protected b() {
        }

        /* renamed from: edA */
        public BuilderType ecL() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(MessageType messageType) {
            if (!this.BzJ) {
                this.BzI = this.BzI.eij();
                this.BzJ = true;
            }
            h hVar = this.BzI;
            h b = messageType.BzI;
            for (int i = 0; i < b.BzC.eiF(); i++) {
                hVar.b(b.BzC.UF(i));
            }
            for (Entry b2 : b.BzC.eiG()) {
                hVar.b(b2);
            }
        }
    }

    public static abstract class c<MessageType extends c<MessageType>> extends i implements d<MessageType> {
        protected final h<e> BzI;

        public class a {
            private final Iterator<Entry<e, Object>> BzK;
            private Entry<e, Object> BzL;
            private final boolean BzM;

            /* synthetic */ a(c cVar, byte b) {
                this();
            }

            private a() {
                Iterator bVar;
                AppMethodBeat.i(121522);
                h b = c.this.BzI;
                if (b.BzE) {
                    bVar = new b(b.BzC.entrySet().iterator());
                } else {
                    bVar = b.BzC.entrySet().iterator();
                }
                this.BzK = bVar;
                if (this.BzK.hasNext()) {
                    this.BzL = (Entry) this.BzK.next();
                }
                this.BzM = false;
                AppMethodBeat.o(121522);
            }

            public final void b(int i, f fVar) {
                AppMethodBeat.i(121523);
                while (this.BzL != null && ((e) this.BzL.getKey()).number < i) {
                    a.i.b.a.c.g.h.a aVar = (e) this.BzL.getKey();
                    if (this.BzM && aVar.BzP.BBj == a.i.b.a.c.g.z.b.MESSAGE && !aVar.BzQ) {
                        fVar.b(aVar.number, (q) this.BzL.getValue());
                    } else {
                        h.a(aVar, this.BzL.getValue(), fVar);
                    }
                    if (this.BzK.hasNext()) {
                        this.BzL = (Entry) this.BzK.next();
                    } else {
                        this.BzL = null;
                    }
                }
                AppMethodBeat.o(121523);
            }
        }

        protected c() {
            this.BzI = h.eig();
        }

        protected c(b<MessageType, ?> bVar) {
            this.BzI = b.a((b) bVar);
        }

        public final <Type> boolean c(f<MessageType, Type> fVar) {
            b((f) fVar);
            h hVar = this.BzI;
            e eVar = fVar.BzU;
            if (!eVar.eim()) {
                return hVar.BzC.get(eVar) != null;
            } else {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
        }

        public final <Type> int d(f<MessageType, List<Type>> fVar) {
            b((f) fVar);
            h hVar = this.BzI;
            a.i.b.a.c.g.h.a aVar = fVar.BzU;
            if (aVar.eim()) {
                Object a = hVar.a(aVar);
                if (a == null) {
                    return 0;
                }
                return ((List) a).size();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public final <Type> Type e(f<MessageType, Type> fVar) {
            b((f) fVar);
            Type a = this.BzI.a(fVar.BzU);
            if (a == null) {
                return fVar.aze;
            }
            if (!fVar.BzU.BzQ) {
                return fVar.dM(a);
            }
            if (fVar.BzU.BzP.BBj != a.i.b.a.c.g.z.b.ENUM) {
                return a;
            }
            Type arrayList = new ArrayList();
            for (Object dM : (List) a) {
                arrayList.add(fVar.dM(dM));
            }
            return arrayList;
        }

        public final <Type> Type a(f<MessageType, List<Type>> fVar, int i) {
            b((f) fVar);
            h hVar = this.BzI;
            a.i.b.a.c.g.h.a aVar = fVar.BzU;
            if (aVar.eim()) {
                Object a = hVar.a(aVar);
                if (a != null) {
                    return fVar.dM(((List) a).get(i));
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
        public final boolean a(e eVar, f fVar, g gVar, int i) {
            boolean z;
            boolean z2;
            h hVar = this.BzI;
            q ecE = ecE();
            int fy = z.fy(i);
            f fVar2 = (f) gVar.BzA.get(new a(ecE, z.fz(i)));
            if (fVar2 != null) {
                if (fy == h.a(fVar2.BzU.BzP, false)) {
                    z = false;
                    z2 = false;
                } else if (fVar2.BzU.BzQ && fVar2.BzU.BzP.eiN() && fy == h.a(fVar2.BzU.BzP, true)) {
                    z = true;
                    z2 = false;
                }
                if (!z2) {
                    return eVar.a(i, fVar);
                }
                if (z) {
                    fy = eVar.fo(eVar.vd());
                    if (fVar2.BzU.BzP == a.i.b.a.c.g.z.a.ENUM) {
                        while (eVar.vg() > 0) {
                            a.i.b.a.c.g.j.a SW = fVar2.BzU.BzO.SW(eVar.vd());
                            if (SW == null) {
                                break;
                            }
                            hVar.b(fVar2.BzU, fVar2.dN(SW));
                        }
                    } else {
                        while (eVar.vg() > 0) {
                            hVar.b(fVar2.BzU, h.a(eVar, fVar2.BzU.BzP));
                        }
                    }
                    eVar.fp(fy);
                } else {
                    Object ecM;
                    int i2;
                    switch (fVar2.BzU.BzP.BBj) {
                        case MESSAGE:
                            a.i.b.a.c.g.q.a ecC;
                            if (!fVar2.BzU.BzQ) {
                                q qVar = (q) hVar.a(fVar2.BzU);
                                if (qVar != null) {
                                    ecC = qVar.ecC();
                                    if (ecC == null) {
                                        ecC = fVar2.BzT.ecD();
                                    }
                                    if (fVar2.BzU.BzP != a.i.b.a.c.g.z.a.GROUP) {
                                        i2 = fVar2.BzU.number;
                                        if (eVar.bxp >= eVar.bxq) {
                                            throw k.eiw();
                                        }
                                        eVar.bxp++;
                                        ecC.d(eVar, gVar);
                                        eVar.fm(z.bv(i2, 4));
                                        eVar.bxp--;
                                    } else {
                                        i2 = eVar.vd();
                                        if (eVar.bxp >= eVar.bxq) {
                                            throw k.eiw();
                                        }
                                        i2 = eVar.fo(i2);
                                        eVar.bxp++;
                                        ecC.d(eVar, gVar);
                                        eVar.fm(0);
                                        eVar.bxp--;
                                        eVar.fp(i2);
                                    }
                                    ecM = ecC.ecM();
                                }
                            }
                            ecC = null;
                            if (ecC == null) {
                            }
                            if (fVar2.BzU.BzP != a.i.b.a.c.g.z.a.GROUP) {
                            }
                            ecM = ecC.ecM();
                        case ENUM:
                            i2 = eVar.vd();
                            ecM = fVar2.BzU.BzO.SW(i2);
                            if (ecM == null) {
                                fVar.fw(i);
                                fVar.fw(i2);
                                break;
                            }
                        default:
                            ecM = h.a(eVar, fVar2.BzU.BzP);
                    }
                    if (fVar2.BzU.BzQ) {
                        hVar.b(fVar2.BzU, fVar2.dN(ecM));
                    } else {
                        hVar.a(fVar2.BzU, fVar2.dN(ecM));
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
        public final a eip() {
            return new a(this, (byte) 0);
        }

        private void b(f<MessageType, ?> fVar) {
            if (fVar.BzS != ecE()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }
    }

    public static abstract class a<MessageType extends i, BuilderType extends a> extends a.i.b.a.c.g.a.a<BuilderType> {
        public d BsB = d.Bzq;

        public abstract BuilderType a(MessageType messageType);

        /* renamed from: ecJ */
        public abstract MessageType ecE();

        protected a() {
        }

        /* renamed from: ecK */
        public BuilderType ecL() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    protected i() {
    }

    protected i(byte b) {
    }

    public s<? extends q> ecy() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* Access modifiers changed, original: protected */
    public boolean a(e eVar, f fVar, g gVar, int i) {
        return eVar.a(i, fVar);
    }

    /* Access modifiers changed, original: protected */
    public void eio() {
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType containingType, Type type, q qVar, int i, a.i.b.a.c.g.z.a aVar, Class cls) {
        return new f(containingType, type, qVar, new e(i, aVar, false), cls);
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType containingType, q qVar, int i, a.i.b.a.c.g.z.a aVar, Class cls) {
        return new f(containingType, Collections.emptyList(), qVar, new e(i, aVar, true), cls);
    }

    static Method d(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            String valueOf = String.valueOf(String.valueOf(cls.getName()));
            String valueOf2 = String.valueOf(String.valueOf(str));
            throw new RuntimeException(new StringBuilder((valueOf.length() + 45) + valueOf2.length()).append("Generated message class \"").append(valueOf).append("\" missing method \"").append(valueOf2).append("\".").toString(), e);
        }
    }

    static Object d(Method method, Object... objArr) {
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
