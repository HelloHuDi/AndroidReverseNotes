package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import p000a.p010i.p011b.p012a.p015c.p035g.C17273z.C17274b;
import p000a.p010i.p011b.p012a.p015c.p035g.C17273z.C8190a;
import p000a.p010i.p011b.p012a.p015c.p035g.C8181j.C8183a;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q.C8186a;

/* renamed from: a.i.b.a.c.g.h */
public final class C17266h<FieldDescriptorType extends C17267a<FieldDescriptorType>> {
    private static final C17266h BzF = new C17266h((byte) 0);
    final C41428v<FieldDescriptorType, Object> BzC = C41428v.m72259UE(16);
    private boolean BzD;
    boolean BzE = false;

    /* renamed from: a.i.b.a.c.g.h$a */
    public interface C17267a<T extends C17267a<T>> extends Comparable<T> {
        /* renamed from: a */
        C8186a mo31346a(C8186a c8186a, C8185q c8185q);

        int edd();

        C8190a eik();

        C17274b eil();

        boolean eim();

        boolean ein();
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(121519);
        C17266h eij = eij();
        AppMethodBeat.m2505o(121519);
        return eij;
    }

    private C17266h() {
        AppMethodBeat.m2504i(121498);
        AppMethodBeat.m2505o(121498);
    }

    private C17266h(byte b) {
        AppMethodBeat.m2504i(121499);
        eii();
        AppMethodBeat.m2505o(121499);
    }

    public static <T extends C17267a<T>> C17266h<T> eig() {
        AppMethodBeat.m2504i(121500);
        C17266h c17266h = new C17266h();
        AppMethodBeat.m2505o(121500);
        return c17266h;
    }

    public static <T extends C17267a<T>> C17266h<T> eih() {
        return BzF;
    }

    static {
        AppMethodBeat.m2504i(121520);
        AppMethodBeat.m2505o(121520);
    }

    public final void eii() {
        AppMethodBeat.m2504i(121501);
        if (this.BzD) {
            AppMethodBeat.m2505o(121501);
            return;
        }
        this.BzC.eii();
        this.BzD = true;
        AppMethodBeat.m2505o(121501);
    }

    /* renamed from: a */
    public final Object mo31337a(FieldDescriptorType fieldDescriptorType) {
        AppMethodBeat.m2504i(121503);
        Object obj = this.BzC.get(fieldDescriptorType);
        if (obj instanceof C44902l) {
            C8185q eiy = ((C44902l) obj).eiy();
            AppMethodBeat.m2505o(121503);
            return eiy;
        }
        AppMethodBeat.m2505o(121503);
        return obj;
    }

    /* renamed from: a */
    public final void mo31338a(FieldDescriptorType fieldDescriptorType, Object obj) {
        AppMethodBeat.m2504i(121504);
        if (!fieldDescriptorType.eim()) {
            C17266h.m26739a(fieldDescriptorType.eik(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                C17266h.m26739a(fieldDescriptorType.eik(), a);
            }
            obj = arrayList;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            AppMethodBeat.m2505o(121504);
            throw illegalArgumentException;
        }
        if (obj instanceof C44902l) {
            this.BzE = true;
        }
        this.BzC.mo66068a((Comparable) fieldDescriptorType, obj);
        AppMethodBeat.m2505o(121504);
    }

    /* renamed from: b */
    public final void mo31339b(FieldDescriptorType fieldDescriptorType, Object obj) {
        AppMethodBeat.m2504i(121505);
        if (fieldDescriptorType.eim()) {
            List arrayList;
            C17266h.m26739a(fieldDescriptorType.eik(), obj);
            Object a = mo31337a((C17267a) fieldDescriptorType);
            if (a == null) {
                arrayList = new ArrayList();
                this.BzC.mo66068a((Comparable) fieldDescriptorType, (Object) arrayList);
            } else {
                arrayList = (List) a;
            }
            arrayList.add(obj);
            AppMethodBeat.m2505o(121505);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        AppMethodBeat.m2505o(121505);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    private static void m26739a(C8190a c8190a, Object obj) {
        boolean z = false;
        AppMethodBeat.m2504i(121506);
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(121506);
            throw nullPointerException;
        }
        switch (c8190a.BBj) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if ((obj instanceof C31710d) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof C8183a)) {
                    z = true;
                    break;
                }
            case MESSAGE:
                if ((obj instanceof C8185q) || (obj instanceof C44902l)) {
                    z = true;
                    break;
                }
        }
        if (z) {
            AppMethodBeat.m2505o(121506);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.m2505o(121506);
        throw illegalArgumentException;
    }

    public final boolean isInitialized() {
        AppMethodBeat.m2504i(121507);
        int i = 0;
        while (i < this.BzC.eiF()) {
            if (C17266h.m26740a(this.BzC.mo66067UF(i))) {
                i++;
            } else {
                AppMethodBeat.m2505o(121507);
                return false;
            }
        }
        for (Entry a : this.BzC.eiG()) {
            if (!C17266h.m26740a(a)) {
                AppMethodBeat.m2505o(121507);
                return false;
            }
        }
        AppMethodBeat.m2505o(121507);
        return true;
    }

    /* renamed from: a */
    private static boolean m26740a(Entry<FieldDescriptorType, Object> entry) {
        AppMethodBeat.m2504i(121508);
        C17267a c17267a = (C17267a) entry.getKey();
        if (c17267a.eil() == C17274b.MESSAGE) {
            if (c17267a.eim()) {
                for (C8185q isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        AppMethodBeat.m2505o(121508);
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof C8185q) {
                if (!((C8185q) value).isInitialized()) {
                    AppMethodBeat.m2505o(121508);
                    return false;
                }
            } else if (value instanceof C44902l) {
                AppMethodBeat.m2505o(121508);
                return true;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                AppMethodBeat.m2505o(121508);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(121508);
        return true;
    }

    /* renamed from: a */
    static int m26734a(C8190a c8190a, boolean z) {
        if (z) {
            return 2;
        }
        return c8190a.BBk;
    }

    /* renamed from: dL */
    private static Object m26743dL(Object obj) {
        AppMethodBeat.m2504i(121509);
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            Object obj2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj2, 0, bArr.length);
            AppMethodBeat.m2505o(121509);
            return obj2;
        }
        AppMethodBeat.m2505o(121509);
        return obj;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo31340b(Entry<FieldDescriptorType, Object> entry) {
        AppMethodBeat.m2504i(121510);
        Comparable comparable = (C17267a) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof C44902l) {
            value = ((C44902l) value).eiy();
        }
        Object a;
        if (comparable.eim()) {
            a = mo31337a((C17267a) comparable);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object dL : (List) value) {
                ((List) a).add(C17266h.m26743dL(dL));
            }
            this.BzC.mo66068a(comparable, a);
            AppMethodBeat.m2505o(121510);
        } else if (comparable.eil() == C17274b.MESSAGE) {
            a = mo31337a((C17267a) comparable);
            if (a == null) {
                this.BzC.mo66068a(comparable, C17266h.m26743dL(value));
                AppMethodBeat.m2505o(121510);
                return;
            }
            this.BzC.mo66068a(comparable, comparable.mo31346a(((C8185q) a).ecC(), (C8185q) value).ecM());
            AppMethodBeat.m2505o(121510);
        } else {
            this.BzC.mo66068a(comparable, C17266h.m26743dL(value));
            AppMethodBeat.m2505o(121510);
        }
    }

    /* renamed from: a */
    public static Object m26735a(C31713e c31713e, C8190a c8190a) {
        AppMethodBeat.m2504i(121511);
        Object valueOf;
        IllegalArgumentException illegalArgumentException;
        switch (c8190a) {
            case DOUBLE:
                Double valueOf2 = Double.valueOf(Double.longBitsToDouble(c31713e.eib()));
                AppMethodBeat.m2505o(121511);
                return valueOf2;
            case FLOAT:
                valueOf = Float.valueOf(Float.intBitsToFloat(c31713e.eia()));
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case INT64:
                valueOf = Long.valueOf(c31713e.mo51694ve());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case UINT64:
                valueOf = Long.valueOf(c31713e.mo51694ve());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case INT32:
                valueOf = Integer.valueOf(c31713e.mo51693vd());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case FIXED64:
                valueOf = Long.valueOf(c31713e.eib());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case FIXED32:
                valueOf = Integer.valueOf(c31713e.eia());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case BOOL:
                valueOf = Boolean.valueOf(c31713e.ehX());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case STRING:
                int vd = c31713e.mo51693vd();
                if (vd <= c31713e.bufferSize - c31713e.bxm && vd > 0) {
                    valueOf = new String(c31713e.buffer, c31713e.bxm, vd, "UTF-8");
                    c31713e.bxm = vd + c31713e.bxm;
                    AppMethodBeat.m2505o(121511);
                    return valueOf;
                } else if (vd == 0) {
                    valueOf = "";
                    AppMethodBeat.m2505o(121511);
                    return valueOf;
                } else {
                    valueOf = new String(c31713e.mo51682Uw(vd), "UTF-8");
                    AppMethodBeat.m2505o(121511);
                    return valueOf;
                }
            case BYTES:
                valueOf = c31713e.ehY();
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case UINT32:
                valueOf = Integer.valueOf(c31713e.mo51693vd());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case SFIXED32:
                valueOf = Integer.valueOf(c31713e.eia());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case SFIXED64:
                valueOf = Long.valueOf(c31713e.eib());
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case SINT32:
                int vd2 = c31713e.mo51693vd();
                valueOf = Integer.valueOf((-(vd2 & 1)) ^ (vd2 >>> 1));
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case SINT64:
                valueOf = Long.valueOf(C31713e.m51328nS(c31713e.mo51694ve()));
                AppMethodBeat.m2505o(121511);
                return valueOf;
            case GROUP:
                illegalArgumentException = new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                AppMethodBeat.m2505o(121511);
                throw illegalArgumentException;
            case MESSAGE:
                illegalArgumentException = new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                AppMethodBeat.m2505o(121511);
                throw illegalArgumentException;
            case ENUM:
                illegalArgumentException = new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                AppMethodBeat.m2505o(121511);
                throw illegalArgumentException;
            default:
                RuntimeException runtimeException = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                AppMethodBeat.m2505o(121511);
                throw runtimeException;
        }
    }

    /* renamed from: a */
    private static void m26736a(C37024f c37024f, C8190a c8190a, int i, Object obj) {
        AppMethodBeat.m2504i(121512);
        if (c8190a == C8190a.GROUP) {
            C8185q c8185q = (C8185q) obj;
            c37024f.mo59053bu(i, 3);
            c8185q.mo128a(c37024f);
            c37024f.mo59053bu(i, 4);
            AppMethodBeat.m2505o(121512);
            return;
        }
        c37024f.mo59053bu(i, C17266h.m26734a(c8190a, false));
        C17266h.m26737a(c37024f, c8190a, obj);
        AppMethodBeat.m2505o(121512);
    }

    /* renamed from: a */
    private static void m26737a(C37024f c37024f, C8190a c8190a, Object obj) {
        AppMethodBeat.m2504i(121513);
        switch (c8190a) {
            case DOUBLE:
                c37024f.mo59041J(((Double) obj).doubleValue());
                AppMethodBeat.m2505o(121513);
                return;
            case FLOAT:
                c37024f.mo59054bz(((Float) obj).floatValue());
                AppMethodBeat.m2505o(121513);
                return;
            case INT64:
                c37024f.mo59047av(((Long) obj).longValue());
                AppMethodBeat.m2505o(121513);
                return;
            case UINT64:
                c37024f.mo59047av(((Long) obj).longValue());
                AppMethodBeat.m2505o(121513);
                return;
            case INT32:
                c37024f.mo59043Uy(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121513);
                return;
            case FIXED64:
                c37024f.mo59061nV(((Long) obj).longValue());
                AppMethodBeat.m2505o(121513);
                return;
            case FIXED32:
                c37024f.mo59042UA(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121513);
                return;
            case BOOL:
                c37024f.mo59063rQ(((Boolean) obj).booleanValue());
                AppMethodBeat.m2505o(121513);
                return;
            case STRING:
                c37024f.awd((String) obj);
                AppMethodBeat.m2505o(121513);
                return;
            case BYTES:
                if (obj instanceof C31710d) {
                    c37024f.mo59050b((C31710d) obj);
                    AppMethodBeat.m2505o(121513);
                    return;
                }
                c37024f.mo59055cy((byte[]) obj);
                AppMethodBeat.m2505o(121513);
                return;
            case UINT32:
                c37024f.mo59058fw(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121513);
                return;
            case SFIXED32:
                c37024f.mo59042UA(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121513);
                return;
            case SFIXED64:
                c37024f.mo59061nV(((Long) obj).longValue());
                AppMethodBeat.m2505o(121513);
                return;
            case SINT32:
                c37024f.mo59044Uz(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121513);
                return;
            case SINT64:
                c37024f.mo59060nT(((Long) obj).longValue());
                AppMethodBeat.m2505o(121513);
                return;
            case GROUP:
                ((C8185q) obj).mo128a(c37024f);
                AppMethodBeat.m2505o(121513);
                return;
            case MESSAGE:
                c37024f.mo59051b((C8185q) obj);
                AppMethodBeat.m2505o(121513);
                return;
            case ENUM:
                if (!(obj instanceof C8183a)) {
                    c37024f.mo59043Uy(((Integer) obj).intValue());
                    break;
                }
                c37024f.mo59043Uy(((C8183a) obj).edd());
                AppMethodBeat.m2505o(121513);
                return;
        }
        AppMethodBeat.m2505o(121513);
    }

    /* renamed from: a */
    public static void m26738a(C17267a<?> c17267a, Object obj, C37024f c37024f) {
        AppMethodBeat.m2504i(121514);
        C8190a eik = c17267a.eik();
        int edd = c17267a.edd();
        if (c17267a.eim()) {
            List<Object> list = (List) obj;
            if (c17267a.ein()) {
                c37024f.mo59053bu(edd, 2);
                edd = 0;
                for (Object b : list) {
                    edd += C17266h.m26741b(eik, b);
                }
                c37024f.mo59058fw(edd);
                for (Object a : list) {
                    C17266h.m26737a(c37024f, eik, a);
                }
                AppMethodBeat.m2505o(121514);
                return;
            }
            for (Object b2 : list) {
                C17266h.m26736a(c37024f, eik, edd, b2);
            }
            AppMethodBeat.m2505o(121514);
        } else if (obj instanceof C44902l) {
            C17266h.m26736a(c37024f, eik, edd, ((C44902l) obj).eiy());
            AppMethodBeat.m2505o(121514);
        } else {
            C17266h.m26736a(c37024f, eik, edd, obj);
            AppMethodBeat.m2505o(121514);
        }
    }

    /* renamed from: vq */
    public final int mo31345vq() {
        AppMethodBeat.m2504i(121515);
        int i = 0;
        for (int i2 = 0; i2 < this.BzC.eiF(); i2++) {
            Entry UF = this.BzC.mo66067UF(i2);
            i += C17266h.m26742c((C17267a) UF.getKey(), UF.getValue());
        }
        for (Entry entry : this.BzC.eiG()) {
            i += C17266h.m26742c((C17267a) entry.getKey(), entry.getValue());
        }
        AppMethodBeat.m2505o(121515);
        return i;
    }

    /* renamed from: a */
    private static int m26733a(C8190a c8190a, int i, Object obj) {
        AppMethodBeat.m2504i(121516);
        int fv = C37024f.m61955fv(i);
        if (c8190a == C8190a.GROUP) {
            fv *= 2;
        }
        fv += C17266h.m26741b(c8190a, obj);
        AppMethodBeat.m2505o(121516);
        return fv;
    }

    /* renamed from: b */
    private static int m26741b(C8190a c8190a, Object obj) {
        AppMethodBeat.m2504i(121517);
        int aw;
        switch (c8190a) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                AppMethodBeat.m2505o(121517);
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                AppMethodBeat.m2505o(121517);
                return 4;
            case INT64:
                aw = C37024f.m61944aw(((Long) obj).longValue());
                AppMethodBeat.m2505o(121517);
                return aw;
            case UINT64:
                aw = C37024f.m61944aw(((Long) obj).longValue());
                AppMethodBeat.m2505o(121517);
                return aw;
            case INT32:
                aw = C37024f.m61954ft(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121517);
                return aw;
            case FIXED64:
                ((Long) obj).longValue();
                AppMethodBeat.m2505o(121517);
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                AppMethodBeat.m2505o(121517);
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                AppMethodBeat.m2505o(121517);
                return 1;
            case STRING:
                aw = C37024f.m61946bf((String) obj);
                AppMethodBeat.m2505o(121517);
                return aw;
            case BYTES:
                if (obj instanceof C31710d) {
                    aw = C37024f.m61949c((C31710d) obj);
                    AppMethodBeat.m2505o(121517);
                    return aw;
                }
                aw = C37024f.m61952cz((byte[]) obj);
                AppMethodBeat.m2505o(121517);
                return aw;
            case UINT32:
                aw = C37024f.m61956fx(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121517);
                return aw;
            case SFIXED32:
                ((Integer) obj).intValue();
                AppMethodBeat.m2505o(121517);
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                AppMethodBeat.m2505o(121517);
                return 8;
            case SINT32:
                aw = C37024f.m61956fx(C37024f.m61941UB(((Integer) obj).intValue()));
                AppMethodBeat.m2505o(121517);
                return aw;
            case SINT64:
                aw = C37024f.m61944aw(C37024f.m61959nW(((Long) obj).longValue()));
                AppMethodBeat.m2505o(121517);
                return aw;
            case GROUP:
                aw = ((C8185q) obj).mo144vq();
                AppMethodBeat.m2505o(121517);
                return aw;
            case MESSAGE:
                if (obj instanceof C44902l) {
                    aw = C37024f.m61942a((C44902l) obj);
                    AppMethodBeat.m2505o(121517);
                    return aw;
                }
                aw = C37024f.m61950c((C8185q) obj);
                AppMethodBeat.m2505o(121517);
                return aw;
            case ENUM:
                if (obj instanceof C8183a) {
                    aw = C37024f.m61954ft(((C8183a) obj).edd());
                    AppMethodBeat.m2505o(121517);
                    return aw;
                }
                aw = C37024f.m61954ft(((Integer) obj).intValue());
                AppMethodBeat.m2505o(121517);
                return aw;
            default:
                RuntimeException runtimeException = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                AppMethodBeat.m2505o(121517);
                throw runtimeException;
        }
    }

    /* renamed from: c */
    private static int m26742c(C17267a<?> c17267a, Object obj) {
        int i = 0;
        AppMethodBeat.m2504i(121518);
        C8190a eik = c17267a.eik();
        int edd = c17267a.edd();
        if (!c17267a.eim()) {
            i = C17266h.m26733a(eik, edd, obj);
            AppMethodBeat.m2505o(121518);
            return i;
        } else if (c17267a.ein()) {
            for (Object b : (List) obj) {
                i += C17266h.m26741b(eik, b);
            }
            i = C37024f.m61956fx(i) + (C37024f.m61955fv(edd) + i);
            AppMethodBeat.m2505o(121518);
            return i;
        } else {
            for (Object b2 : (List) obj) {
                i += C17266h.m26733a(eik, edd, b2);
            }
            AppMethodBeat.m2505o(121518);
            return i;
        }
    }

    public final C17266h<FieldDescriptorType> eij() {
        AppMethodBeat.m2504i(121502);
        C17266h c17266h = new C17266h();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.BzC.eiF()) {
                break;
            }
            Entry UF = this.BzC.mo66067UF(i2);
            c17266h.mo31338a((C17267a) UF.getKey(), UF.getValue());
            i = i2 + 1;
        }
        for (Entry entry : this.BzC.eiG()) {
            c17266h.mo31338a((C17267a) entry.getKey(), entry.getValue());
        }
        c17266h.BzE = this.BzE;
        AppMethodBeat.m2505o(121502);
        return c17266h;
    }
}
