package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzzm<FieldDescriptorType extends zzzo<FieldDescriptorType>> {
    private static final zzzm zzbru = new zzzm(true);
    private boolean zzbls;
    private final zzaay<FieldDescriptorType, Object> zzbrs = zzaay.zzag(16);
    private boolean zzbrt = false;

    static {
        AppMethodBeat.m2504i(3580);
        AppMethodBeat.m2505o(3580);
    }

    private zzzm() {
        AppMethodBeat.m2504i(3572);
        AppMethodBeat.m2505o(3572);
    }

    private zzzm(boolean z) {
        AppMethodBeat.m2504i(3573);
        if (!this.zzbls) {
            this.zzbrs.zzrg();
            this.zzbls = true;
        }
        AppMethodBeat.m2505o(3573);
    }

    private static void zza(zzabp zzabp, Object obj) {
        boolean z = false;
        AppMethodBeat.m2504i(3578);
        zzzr.checkNotNull(obj);
        switch (zzabp.zzuv()) {
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
                if ((obj instanceof zzyw) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzzs)) {
                    z = true;
                    break;
                }
            case MESSAGE:
                if ((obj instanceof zzaal) || (obj instanceof zzzu)) {
                    z = true;
                    break;
                }
        }
        if (z) {
            AppMethodBeat.m2505o(3578);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.m2505o(3578);
        throw illegalArgumentException;
    }

    private final void zza(FieldDescriptorType fieldDescriptorType, Object obj) {
        Object obj2;
        AppMethodBeat.m2504i(3577);
        if (!fieldDescriptorType.zztk()) {
            zza(fieldDescriptorType.zztj(), obj);
            obj2 = obj;
        } else if (obj instanceof List) {
            obj2 = new ArrayList();
            obj2.addAll((List) obj);
            ArrayList arrayList = (ArrayList) obj2;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                zza(fieldDescriptorType.zztj(), obj3);
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            AppMethodBeat.m2505o(3577);
            throw illegalArgumentException;
        }
        if (obj2 instanceof zzzu) {
            this.zzbrt = true;
        }
        this.zzbrs.zza((Comparable) fieldDescriptorType, obj2);
        AppMethodBeat.m2505o(3577);
    }

    public static <T extends zzzo<T>> zzzm<T> zzti() {
        return zzbru;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(3579);
        zzzm zzzm = new zzzm();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbrs.zzuj()) {
                break;
            }
            Entry zzah = this.zzbrs.zzah(i2);
            zzzm.zza((zzzo) zzah.getKey(), zzah.getValue());
            i = i2 + 1;
        }
        for (Entry entry : this.zzbrs.zzuk()) {
            zzzm.zza((zzzo) entry.getKey(), entry.getValue());
        }
        zzzm.zzbrt = this.zzbrt;
        AppMethodBeat.m2505o(3579);
        return zzzm;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(3574);
        if (this == obj) {
            AppMethodBeat.m2505o(3574);
            return true;
        } else if (obj instanceof zzzm) {
            boolean equals = this.zzbrs.equals(((zzzm) obj).zzbrs);
            AppMethodBeat.m2505o(3574);
            return equals;
        } else {
            AppMethodBeat.m2505o(3574);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(3575);
        int hashCode = this.zzbrs.hashCode();
        AppMethodBeat.m2505o(3575);
        return hashCode;
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        AppMethodBeat.m2504i(3576);
        if (this.zzbrt) {
            zzzx zzzx = new zzzx(this.zzbrs.entrySet().iterator());
            AppMethodBeat.m2505o(3576);
            return zzzx;
        }
        Iterator it = this.zzbrs.entrySet().iterator();
        AppMethodBeat.m2505o(3576);
        return it;
    }
}
