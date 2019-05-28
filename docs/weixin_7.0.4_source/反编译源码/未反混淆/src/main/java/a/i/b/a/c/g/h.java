package a.i.b.a.c.g;

import a.i.b.a.c.g.z.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public final class h<FieldDescriptorType extends a<FieldDescriptorType>> {
    private static final h BzF = new h((byte) 0);
    final v<FieldDescriptorType, Object> BzC = v.UE(16);
    private boolean BzD;
    boolean BzE = false;

    public interface a<T extends a<T>> extends Comparable<T> {
        a.i.b.a.c.g.q.a a(a.i.b.a.c.g.q.a aVar, q qVar);

        int edd();

        a.i.b.a.c.g.z.a eik();

        b eil();

        boolean eim();

        boolean ein();
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(121519);
        h eij = eij();
        AppMethodBeat.o(121519);
        return eij;
    }

    private h() {
        AppMethodBeat.i(121498);
        AppMethodBeat.o(121498);
    }

    private h(byte b) {
        AppMethodBeat.i(121499);
        eii();
        AppMethodBeat.o(121499);
    }

    public static <T extends a<T>> h<T> eig() {
        AppMethodBeat.i(121500);
        h hVar = new h();
        AppMethodBeat.o(121500);
        return hVar;
    }

    public static <T extends a<T>> h<T> eih() {
        return BzF;
    }

    static {
        AppMethodBeat.i(121520);
        AppMethodBeat.o(121520);
    }

    public final void eii() {
        AppMethodBeat.i(121501);
        if (this.BzD) {
            AppMethodBeat.o(121501);
            return;
        }
        this.BzC.eii();
        this.BzD = true;
        AppMethodBeat.o(121501);
    }

    public final Object a(FieldDescriptorType fieldDescriptorType) {
        AppMethodBeat.i(121503);
        Object obj = this.BzC.get(fieldDescriptorType);
        if (obj instanceof l) {
            q eiy = ((l) obj).eiy();
            AppMethodBeat.o(121503);
            return eiy;
        }
        AppMethodBeat.o(121503);
        return obj;
    }

    public final void a(FieldDescriptorType fieldDescriptorType, Object obj) {
        AppMethodBeat.i(121504);
        if (!fieldDescriptorType.eim()) {
            a(fieldDescriptorType.eik(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                a(fieldDescriptorType.eik(), a);
            }
            obj = arrayList;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            AppMethodBeat.o(121504);
            throw illegalArgumentException;
        }
        if (obj instanceof l) {
            this.BzE = true;
        }
        this.BzC.a((Comparable) fieldDescriptorType, obj);
        AppMethodBeat.o(121504);
    }

    public final void b(FieldDescriptorType fieldDescriptorType, Object obj) {
        AppMethodBeat.i(121505);
        if (fieldDescriptorType.eim()) {
            List arrayList;
            a(fieldDescriptorType.eik(), obj);
            Object a = a((a) fieldDescriptorType);
            if (a == null) {
                arrayList = new ArrayList();
                this.BzC.a((Comparable) fieldDescriptorType, (Object) arrayList);
            } else {
                arrayList = (List) a;
            }
            arrayList.add(obj);
            AppMethodBeat.o(121505);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        AppMethodBeat.o(121505);
        throw illegalArgumentException;
    }

    private static void a(a.i.b.a.c.g.z.a aVar, Object obj) {
        boolean z = false;
        AppMethodBeat.i(121506);
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(121506);
            throw nullPointerException;
        }
        switch (aVar.BBj) {
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
                if ((obj instanceof d) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof a.i.b.a.c.g.j.a)) {
                    z = true;
                    break;
                }
            case MESSAGE:
                if ((obj instanceof q) || (obj instanceof l)) {
                    z = true;
                    break;
                }
        }
        if (z) {
            AppMethodBeat.o(121506);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.o(121506);
        throw illegalArgumentException;
    }

    public final boolean isInitialized() {
        AppMethodBeat.i(121507);
        int i = 0;
        while (i < this.BzC.eiF()) {
            if (a(this.BzC.UF(i))) {
                i++;
            } else {
                AppMethodBeat.o(121507);
                return false;
            }
        }
        for (Entry a : this.BzC.eiG()) {
            if (!a(a)) {
                AppMethodBeat.o(121507);
                return false;
            }
        }
        AppMethodBeat.o(121507);
        return true;
    }

    private static boolean a(Entry<FieldDescriptorType, Object> entry) {
        AppMethodBeat.i(121508);
        a aVar = (a) entry.getKey();
        if (aVar.eil() == b.MESSAGE) {
            if (aVar.eim()) {
                for (q isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        AppMethodBeat.o(121508);
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof q) {
                if (!((q) value).isInitialized()) {
                    AppMethodBeat.o(121508);
                    return false;
                }
            } else if (value instanceof l) {
                AppMethodBeat.o(121508);
                return true;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                AppMethodBeat.o(121508);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(121508);
        return true;
    }

    static int a(a.i.b.a.c.g.z.a aVar, boolean z) {
        if (z) {
            return 2;
        }
        return aVar.BBk;
    }

    private static Object dL(Object obj) {
        AppMethodBeat.i(121509);
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            Object obj2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj2, 0, bArr.length);
            AppMethodBeat.o(121509);
            return obj2;
        }
        AppMethodBeat.o(121509);
        return obj;
    }

    /* Access modifiers changed, original: final */
    public final void b(Entry<FieldDescriptorType, Object> entry) {
        AppMethodBeat.i(121510);
        Comparable comparable = (a) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof l) {
            value = ((l) value).eiy();
        }
        Object a;
        if (comparable.eim()) {
            a = a((a) comparable);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object dL : (List) value) {
                ((List) a).add(dL(dL));
            }
            this.BzC.a(comparable, a);
            AppMethodBeat.o(121510);
        } else if (comparable.eil() == b.MESSAGE) {
            a = a((a) comparable);
            if (a == null) {
                this.BzC.a(comparable, dL(value));
                AppMethodBeat.o(121510);
                return;
            }
            this.BzC.a(comparable, comparable.a(((q) a).ecC(), (q) value).ecM());
            AppMethodBeat.o(121510);
        } else {
            this.BzC.a(comparable, dL(value));
            AppMethodBeat.o(121510);
        }
    }

    public static Object a(e eVar, a.i.b.a.c.g.z.a aVar) {
        AppMethodBeat.i(121511);
        Object valueOf;
        IllegalArgumentException illegalArgumentException;
        switch (aVar) {
            case DOUBLE:
                Double valueOf2 = Double.valueOf(Double.longBitsToDouble(eVar.eib()));
                AppMethodBeat.o(121511);
                return valueOf2;
            case FLOAT:
                valueOf = Float.valueOf(Float.intBitsToFloat(eVar.eia()));
                AppMethodBeat.o(121511);
                return valueOf;
            case INT64:
                valueOf = Long.valueOf(eVar.ve());
                AppMethodBeat.o(121511);
                return valueOf;
            case UINT64:
                valueOf = Long.valueOf(eVar.ve());
                AppMethodBeat.o(121511);
                return valueOf;
            case INT32:
                valueOf = Integer.valueOf(eVar.vd());
                AppMethodBeat.o(121511);
                return valueOf;
            case FIXED64:
                valueOf = Long.valueOf(eVar.eib());
                AppMethodBeat.o(121511);
                return valueOf;
            case FIXED32:
                valueOf = Integer.valueOf(eVar.eia());
                AppMethodBeat.o(121511);
                return valueOf;
            case BOOL:
                valueOf = Boolean.valueOf(eVar.ehX());
                AppMethodBeat.o(121511);
                return valueOf;
            case STRING:
                int vd = eVar.vd();
                if (vd <= eVar.bufferSize - eVar.bxm && vd > 0) {
                    valueOf = new String(eVar.buffer, eVar.bxm, vd, "UTF-8");
                    eVar.bxm = vd + eVar.bxm;
                    AppMethodBeat.o(121511);
                    return valueOf;
                } else if (vd == 0) {
                    valueOf = "";
                    AppMethodBeat.o(121511);
                    return valueOf;
                } else {
                    valueOf = new String(eVar.Uw(vd), "UTF-8");
                    AppMethodBeat.o(121511);
                    return valueOf;
                }
            case BYTES:
                valueOf = eVar.ehY();
                AppMethodBeat.o(121511);
                return valueOf;
            case UINT32:
                valueOf = Integer.valueOf(eVar.vd());
                AppMethodBeat.o(121511);
                return valueOf;
            case SFIXED32:
                valueOf = Integer.valueOf(eVar.eia());
                AppMethodBeat.o(121511);
                return valueOf;
            case SFIXED64:
                valueOf = Long.valueOf(eVar.eib());
                AppMethodBeat.o(121511);
                return valueOf;
            case SINT32:
                int vd2 = eVar.vd();
                valueOf = Integer.valueOf((-(vd2 & 1)) ^ (vd2 >>> 1));
                AppMethodBeat.o(121511);
                return valueOf;
            case SINT64:
                valueOf = Long.valueOf(e.nS(eVar.ve()));
                AppMethodBeat.o(121511);
                return valueOf;
            case GROUP:
                illegalArgumentException = new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                AppMethodBeat.o(121511);
                throw illegalArgumentException;
            case MESSAGE:
                illegalArgumentException = new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                AppMethodBeat.o(121511);
                throw illegalArgumentException;
            case ENUM:
                illegalArgumentException = new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                AppMethodBeat.o(121511);
                throw illegalArgumentException;
            default:
                RuntimeException runtimeException = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                AppMethodBeat.o(121511);
                throw runtimeException;
        }
    }

    private static void a(f fVar, a.i.b.a.c.g.z.a aVar, int i, Object obj) {
        AppMethodBeat.i(121512);
        if (aVar == a.i.b.a.c.g.z.a.GROUP) {
            q qVar = (q) obj;
            fVar.bu(i, 3);
            qVar.a(fVar);
            fVar.bu(i, 4);
            AppMethodBeat.o(121512);
            return;
        }
        fVar.bu(i, a(aVar, false));
        a(fVar, aVar, obj);
        AppMethodBeat.o(121512);
    }

    private static void a(f fVar, a.i.b.a.c.g.z.a aVar, Object obj) {
        AppMethodBeat.i(121513);
        switch (aVar) {
            case DOUBLE:
                fVar.J(((Double) obj).doubleValue());
                AppMethodBeat.o(121513);
                return;
            case FLOAT:
                fVar.bz(((Float) obj).floatValue());
                AppMethodBeat.o(121513);
                return;
            case INT64:
                fVar.av(((Long) obj).longValue());
                AppMethodBeat.o(121513);
                return;
            case UINT64:
                fVar.av(((Long) obj).longValue());
                AppMethodBeat.o(121513);
                return;
            case INT32:
                fVar.Uy(((Integer) obj).intValue());
                AppMethodBeat.o(121513);
                return;
            case FIXED64:
                fVar.nV(((Long) obj).longValue());
                AppMethodBeat.o(121513);
                return;
            case FIXED32:
                fVar.UA(((Integer) obj).intValue());
                AppMethodBeat.o(121513);
                return;
            case BOOL:
                fVar.rQ(((Boolean) obj).booleanValue());
                AppMethodBeat.o(121513);
                return;
            case STRING:
                fVar.awd((String) obj);
                AppMethodBeat.o(121513);
                return;
            case BYTES:
                if (obj instanceof d) {
                    fVar.b((d) obj);
                    AppMethodBeat.o(121513);
                    return;
                }
                fVar.cy((byte[]) obj);
                AppMethodBeat.o(121513);
                return;
            case UINT32:
                fVar.fw(((Integer) obj).intValue());
                AppMethodBeat.o(121513);
                return;
            case SFIXED32:
                fVar.UA(((Integer) obj).intValue());
                AppMethodBeat.o(121513);
                return;
            case SFIXED64:
                fVar.nV(((Long) obj).longValue());
                AppMethodBeat.o(121513);
                return;
            case SINT32:
                fVar.Uz(((Integer) obj).intValue());
                AppMethodBeat.o(121513);
                return;
            case SINT64:
                fVar.nT(((Long) obj).longValue());
                AppMethodBeat.o(121513);
                return;
            case GROUP:
                ((q) obj).a(fVar);
                AppMethodBeat.o(121513);
                return;
            case MESSAGE:
                fVar.b((q) obj);
                AppMethodBeat.o(121513);
                return;
            case ENUM:
                if (!(obj instanceof a.i.b.a.c.g.j.a)) {
                    fVar.Uy(((Integer) obj).intValue());
                    break;
                }
                fVar.Uy(((a.i.b.a.c.g.j.a) obj).edd());
                AppMethodBeat.o(121513);
                return;
        }
        AppMethodBeat.o(121513);
    }

    public static void a(a<?> aVar, Object obj, f fVar) {
        AppMethodBeat.i(121514);
        a.i.b.a.c.g.z.a eik = aVar.eik();
        int edd = aVar.edd();
        if (aVar.eim()) {
            List<Object> list = (List) obj;
            if (aVar.ein()) {
                fVar.bu(edd, 2);
                edd = 0;
                for (Object b : list) {
                    edd += b(eik, b);
                }
                fVar.fw(edd);
                for (Object a : list) {
                    a(fVar, eik, a);
                }
                AppMethodBeat.o(121514);
                return;
            }
            for (Object b2 : list) {
                a(fVar, eik, edd, b2);
            }
            AppMethodBeat.o(121514);
        } else if (obj instanceof l) {
            a(fVar, eik, edd, ((l) obj).eiy());
            AppMethodBeat.o(121514);
        } else {
            a(fVar, eik, edd, obj);
            AppMethodBeat.o(121514);
        }
    }

    public final int vq() {
        AppMethodBeat.i(121515);
        int i = 0;
        for (int i2 = 0; i2 < this.BzC.eiF(); i2++) {
            Entry UF = this.BzC.UF(i2);
            i += c((a) UF.getKey(), UF.getValue());
        }
        for (Entry entry : this.BzC.eiG()) {
            i += c((a) entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(121515);
        return i;
    }

    private static int a(a.i.b.a.c.g.z.a aVar, int i, Object obj) {
        AppMethodBeat.i(121516);
        int fv = f.fv(i);
        if (aVar == a.i.b.a.c.g.z.a.GROUP) {
            fv *= 2;
        }
        fv += b(aVar, obj);
        AppMethodBeat.o(121516);
        return fv;
    }

    private static int b(a.i.b.a.c.g.z.a aVar, Object obj) {
        AppMethodBeat.i(121517);
        int aw;
        switch (aVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                AppMethodBeat.o(121517);
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                AppMethodBeat.o(121517);
                return 4;
            case INT64:
                aw = f.aw(((Long) obj).longValue());
                AppMethodBeat.o(121517);
                return aw;
            case UINT64:
                aw = f.aw(((Long) obj).longValue());
                AppMethodBeat.o(121517);
                return aw;
            case INT32:
                aw = f.ft(((Integer) obj).intValue());
                AppMethodBeat.o(121517);
                return aw;
            case FIXED64:
                ((Long) obj).longValue();
                AppMethodBeat.o(121517);
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                AppMethodBeat.o(121517);
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                AppMethodBeat.o(121517);
                return 1;
            case STRING:
                aw = f.bf((String) obj);
                AppMethodBeat.o(121517);
                return aw;
            case BYTES:
                if (obj instanceof d) {
                    aw = f.c((d) obj);
                    AppMethodBeat.o(121517);
                    return aw;
                }
                aw = f.cz((byte[]) obj);
                AppMethodBeat.o(121517);
                return aw;
            case UINT32:
                aw = f.fx(((Integer) obj).intValue());
                AppMethodBeat.o(121517);
                return aw;
            case SFIXED32:
                ((Integer) obj).intValue();
                AppMethodBeat.o(121517);
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                AppMethodBeat.o(121517);
                return 8;
            case SINT32:
                aw = f.fx(f.UB(((Integer) obj).intValue()));
                AppMethodBeat.o(121517);
                return aw;
            case SINT64:
                aw = f.aw(f.nW(((Long) obj).longValue()));
                AppMethodBeat.o(121517);
                return aw;
            case GROUP:
                aw = ((q) obj).vq();
                AppMethodBeat.o(121517);
                return aw;
            case MESSAGE:
                if (obj instanceof l) {
                    aw = f.a((l) obj);
                    AppMethodBeat.o(121517);
                    return aw;
                }
                aw = f.c((q) obj);
                AppMethodBeat.o(121517);
                return aw;
            case ENUM:
                if (obj instanceof a.i.b.a.c.g.j.a) {
                    aw = f.ft(((a.i.b.a.c.g.j.a) obj).edd());
                    AppMethodBeat.o(121517);
                    return aw;
                }
                aw = f.ft(((Integer) obj).intValue());
                AppMethodBeat.o(121517);
                return aw;
            default:
                RuntimeException runtimeException = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                AppMethodBeat.o(121517);
                throw runtimeException;
        }
    }

    private static int c(a<?> aVar, Object obj) {
        int i = 0;
        AppMethodBeat.i(121518);
        a.i.b.a.c.g.z.a eik = aVar.eik();
        int edd = aVar.edd();
        if (!aVar.eim()) {
            i = a(eik, edd, obj);
            AppMethodBeat.o(121518);
            return i;
        } else if (aVar.ein()) {
            for (Object b : (List) obj) {
                i += b(eik, b);
            }
            i = f.fx(i) + (f.fv(edd) + i);
            AppMethodBeat.o(121518);
            return i;
        } else {
            for (Object b2 : (List) obj) {
                i += a(eik, edd, b2);
            }
            AppMethodBeat.o(121518);
            return i;
        }
    }

    public final h<FieldDescriptorType> eij() {
        AppMethodBeat.i(121502);
        h hVar = new h();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.BzC.eiF()) {
                break;
            }
            Entry UF = this.BzC.UF(i2);
            hVar.a((a) UF.getKey(), UF.getValue());
            i = i2 + 1;
        }
        for (Entry entry : this.BzC.eiG()) {
            hVar.a((a) entry.getKey(), entry.getValue());
        }
        hVar.BzE = this.BzE;
        AppMethodBeat.o(121502);
        return hVar;
    }
}
