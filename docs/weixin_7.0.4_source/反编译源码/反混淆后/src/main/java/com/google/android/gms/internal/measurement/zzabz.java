package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzabz<M extends zzaby<M>, T> {
    public final int tag;
    private final int type;
    protected final Class<T> zzbwx;
    protected final boolean zzbwy;
    private final zzzq<?, ?> zzbwz;

    private zzabz(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    private zzabz(int i, Class<T> cls, zzzq<?, ?> zzzq, int i2, boolean z) {
        this.type = i;
        this.zzbwx = cls;
        this.tag = i2;
        this.zzbwy = false;
        this.zzbwz = null;
    }

    public static <M extends zzaby<M>, T extends zzace> zzabz<M, T> zza(int i, Class<T> cls, long j) {
        AppMethodBeat.m2504i(3481);
        zzabz zzabz = new zzabz(11, cls, 810, false);
        AppMethodBeat.m2505o(3481);
        return zzabz;
    }

    private final Object zzf(zzabv zzabv) {
        String valueOf;
        IllegalArgumentException illegalArgumentException;
        AppMethodBeat.m2504i(3484);
        Class componentType = this.zzbwy ? this.zzbwx.getComponentType() : this.zzbwx;
        try {
            Object obj;
            switch (this.type) {
                case 10:
                    obj = (zzace) componentType.newInstance();
                    zzabv.zza(obj, this.tag >>> 3);
                    AppMethodBeat.m2505o(3484);
                    break;
                case 11:
                    zzace obj2 = (zzace) componentType.newInstance();
                    zzabv.zza(obj2);
                    AppMethodBeat.m2505o(3484);
                    break;
                default:
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unknown type " + this.type);
                    AppMethodBeat.m2505o(3484);
                    throw illegalArgumentException2;
            }
            return obj2;
        } catch (InstantiationException e) {
            valueOf = String.valueOf(componentType);
            illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
            AppMethodBeat.m2505o(3484);
            throw illegalArgumentException;
        } catch (IllegalAccessException e2) {
            valueOf = String.valueOf(componentType);
            illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
            AppMethodBeat.m2505o(3484);
            throw illegalArgumentException;
        } catch (IOException e3) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Error reading extension field", e3);
            AppMethodBeat.m2505o(3484);
            throw illegalArgumentException3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzabz)) {
            return false;
        }
        zzabz zzabz = (zzabz) obj;
        return this.type == zzabz.type && this.zzbwx == zzabz.zzbwx && this.tag == zzabz.tag && this.zzbwy == zzabz.zzbwy;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(3482);
        int hashCode = (this.zzbwy ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zzbwx.hashCode()) * 31) + this.tag) * 31);
        AppMethodBeat.m2505o(3482);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(Object obj, zzabw zzabw) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(3485);
        try {
            zzabw.zzar(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag >>> 3;
                    ((zzace) obj).zza(zzabw);
                    zzabw.zzg(i, 4);
                    AppMethodBeat.m2505o(3485);
                    return;
                case 11:
                    zzabw.zzb((zzace) obj);
                    AppMethodBeat.m2505o(3485);
                    return;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown type " + this.type);
                    AppMethodBeat.m2505o(3485);
                    throw illegalArgumentException;
            }
        } catch (IOException e) {
            illegalStateException = new IllegalStateException(e);
            AppMethodBeat.m2505o(3485);
            throw illegalStateException;
        }
        illegalStateException = new IllegalStateException(e);
        AppMethodBeat.m2505o(3485);
        throw illegalStateException;
    }

    /* Access modifiers changed, original: final */
    public final T zzi(List<zzacg> list) {
        int i = 0;
        AppMethodBeat.m2504i(3483);
        Object cast;
        if (list == null) {
            AppMethodBeat.m2505o(3483);
            return null;
        } else if (this.zzbwy) {
            int i2;
            ArrayList arrayList = new ArrayList();
            for (i2 = 0; i2 < list.size(); i2++) {
                zzacg zzacg = (zzacg) list.get(i2);
                if (zzacg.zzbrc.length != 0) {
                    arrayList.add(zzf(zzabv.zzi(zzacg.zzbrc)));
                }
            }
            i2 = arrayList.size();
            if (i2 == 0) {
                AppMethodBeat.m2505o(3483);
                return null;
            }
            cast = this.zzbwx.cast(Array.newInstance(this.zzbwx.getComponentType(), i2));
            while (i < i2) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            AppMethodBeat.m2505o(3483);
            return cast;
        } else if (list.isEmpty()) {
            AppMethodBeat.m2505o(3483);
            return null;
        } else {
            cast = this.zzbwx.cast(zzf(zzabv.zzi(((zzacg) list.get(list.size() - 1)).zzbrc)));
            AppMethodBeat.m2505o(3483);
            return cast;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int zzv(Object obj) {
        AppMethodBeat.m2504i(3486);
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                i = (zzabw.zzaq(i) << 1) + ((zzace) obj).zzvm();
                AppMethodBeat.m2505o(3486);
                return i;
            case 11:
                i = zzabw.zzb(i, (zzace) obj);
                AppMethodBeat.m2505o(3486);
                return i;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown type " + this.type);
                AppMethodBeat.m2505o(3486);
                throw illegalArgumentException;
        }
    }
}
