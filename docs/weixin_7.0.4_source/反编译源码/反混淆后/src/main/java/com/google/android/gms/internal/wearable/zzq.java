package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzq implements Cloneable {
    private Object value;
    private zzo<?, ?> zzhi;
    private List<zzv> zzhj = new ArrayList();

    zzq() {
        AppMethodBeat.m2504i(70759);
        AppMethodBeat.m2505o(70759);
    }

    private final byte[] toByteArray() {
        AppMethodBeat.m2504i(70765);
        byte[] bArr = new byte[zzg()];
        zza(zzl.zzb(bArr));
        AppMethodBeat.m2505o(70765);
        return bArr;
    }

    private final zzq zzt() {
        int i = 0;
        AppMethodBeat.m2504i(70766);
        zzq zzq = new zzq();
        try {
            zzq.zzhi = this.zzhi;
            if (this.zzhj == null) {
                zzq.zzhj = null;
            } else {
                zzq.zzhj.addAll(this.zzhj);
            }
            if (this.value != null) {
                int i2;
                if (this.value instanceof zzt) {
                    zzq.value = (zzt) ((zzt) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzq.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzq.value = bArr2;
                    for (i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzq.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzq.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzq.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzq.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzq.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzt[]) {
                    zzt[] zztArr = (zzt[]) this.value;
                    zzt[] zztArr2 = new zzt[zztArr.length];
                    zzq.value = zztArr2;
                    while (true) {
                        i2 = i;
                        if (i2 >= zztArr.length) {
                            break;
                        }
                        zztArr2[i2] = (zzt) zztArr[i2].clone();
                        i = i2 + 1;
                    }
                }
            }
            AppMethodBeat.m2505o(70766);
            return zzq;
        } catch (CloneNotSupportedException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.m2505o(70766);
            throw assertionError;
        }
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(70767);
        zzq zzt = zzt();
        AppMethodBeat.m2505o(70767);
        return zzt;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70763);
        if (obj == this) {
            AppMethodBeat.m2505o(70763);
            return true;
        } else if (obj instanceof zzq) {
            zzq zzq = (zzq) obj;
            boolean equals;
            if (this.value == null || zzq.value == null) {
                if (this.zzhj == null || zzq.zzhj == null) {
                    try {
                        equals = Arrays.equals(toByteArray(), zzq.toByteArray());
                        AppMethodBeat.m2505o(70763);
                        return equals;
                    } catch (IOException e) {
                        IllegalStateException illegalStateException = new IllegalStateException(e);
                        AppMethodBeat.m2505o(70763);
                        throw illegalStateException;
                    }
                }
                equals = this.zzhj.equals(zzq.zzhj);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else if (this.zzhi != zzq.zzhi) {
                AppMethodBeat.m2505o(70763);
                return false;
            } else if (!this.zzhi.zzhd.isArray()) {
                equals = this.value.equals(zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else if (this.value instanceof byte[]) {
                equals = Arrays.equals((byte[]) this.value, (byte[]) zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else if (this.value instanceof int[]) {
                equals = Arrays.equals((int[]) this.value, (int[]) zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else if (this.value instanceof long[]) {
                equals = Arrays.equals((long[]) this.value, (long[]) zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else if (this.value instanceof float[]) {
                equals = Arrays.equals((float[]) this.value, (float[]) zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else if (this.value instanceof double[]) {
                equals = Arrays.equals((double[]) this.value, (double[]) zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else if (this.value instanceof boolean[]) {
                equals = Arrays.equals((boolean[]) this.value, (boolean[]) zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            } else {
                equals = Arrays.deepEquals((Object[]) this.value, (Object[]) zzq.value);
                AppMethodBeat.m2505o(70763);
                return equals;
            }
        } else {
            AppMethodBeat.m2505o(70763);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70764);
        try {
            int hashCode = Arrays.hashCode(toByteArray()) + JsApiGetABTestConfig.CTRL_INDEX;
            AppMethodBeat.m2505o(70764);
            return hashCode;
        } catch (IOException e) {
            IllegalStateException illegalStateException = new IllegalStateException(e);
            AppMethodBeat.m2505o(70764);
            throw illegalStateException;
        }
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzl zzl) {
        AppMethodBeat.m2504i(70762);
        if (this.value != null) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            AppMethodBeat.m2505o(70762);
            throw noSuchMethodError;
        }
        for (zzv zzv : this.zzhj) {
            zzl.zzl(zzv.tag);
            zzl.zzc(zzv.zzhm);
        }
        AppMethodBeat.m2505o(70762);
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzv zzv) {
        AppMethodBeat.m2504i(70760);
        NoSuchMethodError noSuchMethodError;
        if (this.zzhj != null) {
            this.zzhj.add(zzv);
            AppMethodBeat.m2505o(70760);
        } else if (this.value instanceof zzt) {
            byte[] bArr = zzv.zzhm;
            zzk zza = zzk.zza(bArr, 0, bArr.length);
            int zzk = zza.zzk();
            if (zzk != bArr.length - zzl.zzi(zzk)) {
                zzs zzu = zzs.zzu();
                AppMethodBeat.m2505o(70760);
                throw zzu;
            }
            zzt zza2 = ((zzt) this.value).zza(zza);
            this.zzhi = this.zzhi;
            this.value = zza2;
            this.zzhj = null;
            AppMethodBeat.m2505o(70760);
        } else if (this.value instanceof zzt[]) {
            Collections.singletonList(zzv);
            noSuchMethodError = new NoSuchMethodError();
            AppMethodBeat.m2505o(70760);
            throw noSuchMethodError;
        } else {
            Collections.singletonList(zzv);
            noSuchMethodError = new NoSuchMethodError();
            AppMethodBeat.m2505o(70760);
            throw noSuchMethodError;
        }
    }

    /* Access modifiers changed, original: final */
    public final int zzg() {
        AppMethodBeat.m2504i(70761);
        int i = 0;
        if (this.value != null) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            AppMethodBeat.m2505o(70761);
            throw noSuchMethodError;
        }
        Iterator it = this.zzhj.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                zzv zzv = (zzv) it.next();
                i = (zzv.zzhm.length + (zzl.zzm(zzv.tag) + 0)) + i2;
            } else {
                AppMethodBeat.m2505o(70761);
                return i2;
            }
        }
    }
}
