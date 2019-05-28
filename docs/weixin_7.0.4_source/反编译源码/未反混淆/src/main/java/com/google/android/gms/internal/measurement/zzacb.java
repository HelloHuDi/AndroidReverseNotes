package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzacb implements Cloneable {
    private Object value;
    private zzabz<?, ?> zzbxe;
    private List<zzacg> zzbxf = new ArrayList();

    zzacb() {
        AppMethodBeat.i(3494);
        AppMethodBeat.o(3494);
    }

    private final byte[] toByteArray() {
        AppMethodBeat.i(3501);
        byte[] bArr = new byte[zza()];
        zza(zzabw.zzj(bArr));
        AppMethodBeat.o(3501);
        return bArr;
    }

    private final zzacb zzvg() {
        int i = 0;
        AppMethodBeat.i(3502);
        zzacb zzacb = new zzacb();
        try {
            zzacb.zzbxe = this.zzbxe;
            if (this.zzbxf == null) {
                zzacb.zzbxf = null;
            } else {
                zzacb.zzbxf.addAll(this.zzbxf);
            }
            if (this.value != null) {
                int i2;
                if (this.value instanceof zzace) {
                    zzacb.value = (zzace) ((zzace) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzacb.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzacb.value = bArr2;
                    for (i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzacb.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzacb.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzacb.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzacb.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzacb.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzace[]) {
                    zzace[] zzaceArr = (zzace[]) this.value;
                    zzace[] zzaceArr2 = new zzace[zzaceArr.length];
                    zzacb.value = zzaceArr2;
                    while (true) {
                        i2 = i;
                        if (i2 >= zzaceArr.length) {
                            break;
                        }
                        zzaceArr2[i2] = (zzace) zzaceArr[i2].clone();
                        i = i2 + 1;
                    }
                }
            }
            AppMethodBeat.o(3502);
            return zzacb;
        } catch (CloneNotSupportedException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.o(3502);
            throw assertionError;
        }
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(3503);
        zzacb zzvg = zzvg();
        AppMethodBeat.o(3503);
        return zzvg;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(3499);
        if (obj == this) {
            AppMethodBeat.o(3499);
            return true;
        } else if (obj instanceof zzacb) {
            zzacb zzacb = (zzacb) obj;
            boolean equals;
            if (this.value == null || zzacb.value == null) {
                if (this.zzbxf == null || zzacb.zzbxf == null) {
                    try {
                        equals = Arrays.equals(toByteArray(), zzacb.toByteArray());
                        AppMethodBeat.o(3499);
                        return equals;
                    } catch (IOException e) {
                        IllegalStateException illegalStateException = new IllegalStateException(e);
                        AppMethodBeat.o(3499);
                        throw illegalStateException;
                    }
                }
                equals = this.zzbxf.equals(zzacb.zzbxf);
                AppMethodBeat.o(3499);
                return equals;
            } else if (this.zzbxe != zzacb.zzbxe) {
                AppMethodBeat.o(3499);
                return false;
            } else if (!this.zzbxe.zzbwx.isArray()) {
                equals = this.value.equals(zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            } else if (this.value instanceof byte[]) {
                equals = Arrays.equals((byte[]) this.value, (byte[]) zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            } else if (this.value instanceof int[]) {
                equals = Arrays.equals((int[]) this.value, (int[]) zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            } else if (this.value instanceof long[]) {
                equals = Arrays.equals((long[]) this.value, (long[]) zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            } else if (this.value instanceof float[]) {
                equals = Arrays.equals((float[]) this.value, (float[]) zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            } else if (this.value instanceof double[]) {
                equals = Arrays.equals((double[]) this.value, (double[]) zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            } else if (this.value instanceof boolean[]) {
                equals = Arrays.equals((boolean[]) this.value, (boolean[]) zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            } else {
                equals = Arrays.deepEquals((Object[]) this.value, (Object[]) zzacb.value);
                AppMethodBeat.o(3499);
                return equals;
            }
        } else {
            AppMethodBeat.o(3499);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(3500);
        try {
            int hashCode = Arrays.hashCode(toByteArray()) + JsApiGetABTestConfig.CTRL_INDEX;
            AppMethodBeat.o(3500);
            return hashCode;
        } catch (IOException e) {
            IllegalStateException illegalStateException = new IllegalStateException(e);
            AppMethodBeat.o(3500);
            throw illegalStateException;
        }
    }

    /* Access modifiers changed, original: final */
    public final int zza() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(3497);
        if (this.value != null) {
            zzabz zzabz = this.zzbxe;
            Object obj = this.value;
            if (zzabz.zzbwy) {
                int length = Array.getLength(obj);
                i = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (Array.get(obj, i3) != null) {
                        i += zzabz.zzv(Array.get(obj, i3));
                    }
                }
            } else {
                i = zzabz.zzv(obj);
            }
        } else {
            for (zzacg zzacg : this.zzbxf) {
                i2 = (zzacg.zzbrc.length + (zzabw.zzas(zzacg.tag) + 0)) + i2;
            }
            i = i2;
        }
        AppMethodBeat.o(3497);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(3498);
        if (this.value != null) {
            zzabz zzabz = this.zzbxe;
            Object obj = this.value;
            if (zzabz.zzbwy) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzabz.zza(obj2, zzabw);
                    }
                }
                AppMethodBeat.o(3498);
                return;
            }
            zzabz.zza(obj, zzabw);
            AppMethodBeat.o(3498);
            return;
        }
        for (zzacg zzacg : this.zzbxf) {
            zzabw.zzar(zzacg.tag);
            zzabw.zzk(zzacg.zzbrc);
        }
        AppMethodBeat.o(3498);
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzacg zzacg) {
        AppMethodBeat.i(3495);
        if (this.zzbxf != null) {
            this.zzbxf.add(zzacg);
            AppMethodBeat.o(3495);
            return;
        }
        Object zzb;
        if (this.value instanceof zzace) {
            byte[] bArr = zzacg.zzbrc;
            zzabv zza = zzabv.zza(bArr, 0, bArr.length);
            int zzuy = zza.zzuy();
            if (zzuy != bArr.length - zzabw.zzao(zzuy)) {
                zzacd zzvh = zzacd.zzvh();
                AppMethodBeat.o(3495);
                throw zzvh;
            }
            zzb = ((zzace) this.value).zzb(zza);
        } else if (this.value instanceof zzace[]) {
            zzace[] zzaceArr = (zzace[]) this.zzbxe.zzi(Collections.singletonList(zzacg));
            zzace[] zzaceArr2 = (zzace[]) this.value;
            zzace[] zzb2 = (zzace[]) Arrays.copyOf(zzaceArr2, zzaceArr2.length + zzaceArr.length);
            System.arraycopy(zzaceArr, 0, zzb2, zzaceArr2.length, zzaceArr.length);
        } else {
            zzb2 = this.zzbxe.zzi(Collections.singletonList(zzacg));
        }
        this.zzbxe = this.zzbxe;
        this.value = zzb2;
        this.zzbxf = null;
        AppMethodBeat.o(3495);
    }

    /* Access modifiers changed, original: final */
    public final <T> T zzb(zzabz<?, T> zzabz) {
        AppMethodBeat.i(3496);
        if (this.value == null) {
            this.zzbxe = zzabz;
            this.value = zzabz.zzi(this.zzbxf);
            this.zzbxf = null;
        } else if (!this.zzbxe.equals(zzabz)) {
            IllegalStateException illegalStateException = new IllegalStateException("Tried to getExtension with a different Extension.");
            AppMethodBeat.o(3496);
            throw illegalStateException;
        }
        Object obj = this.value;
        AppMethodBeat.o(3496);
        return obj;
    }
}
