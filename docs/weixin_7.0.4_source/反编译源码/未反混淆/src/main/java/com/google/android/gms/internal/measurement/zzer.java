package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@Class(creator = "EventParamsCreator")
@Reserved({1})
public final class zzer extends AbstractSafeParcelable implements Iterable<String> {
    public static final Creator<zzer> CREATOR = new zzet();
    @Field(getter = "z", id = 2)
    private final Bundle zzafy;

    static {
        AppMethodBeat.i(68739);
        AppMethodBeat.o(68739);
    }

    @Constructor
    zzer(@Param(id = 2) Bundle bundle) {
        this.zzafy = bundle;
    }

    /* Access modifiers changed, original: final */
    public final Object get(String str) {
        AppMethodBeat.i(68731);
        Object obj = this.zzafy.get(str);
        AppMethodBeat.o(68731);
        return obj;
    }

    /* Access modifiers changed, original: final */
    public final Long getLong(String str) {
        AppMethodBeat.i(68732);
        Long valueOf = Long.valueOf(this.zzafy.getLong(str));
        AppMethodBeat.o(68732);
        return valueOf;
    }

    /* Access modifiers changed, original: final */
    public final String getString(String str) {
        AppMethodBeat.i(68734);
        String string = this.zzafy.getString(str);
        AppMethodBeat.o(68734);
        return string;
    }

    public final Iterator<String> iterator() {
        AppMethodBeat.i(68738);
        zzes zzes = new zzes(this);
        AppMethodBeat.o(68738);
        return zzes;
    }

    public final int size() {
        AppMethodBeat.i(68735);
        int size = this.zzafy.size();
        AppMethodBeat.o(68735);
        return size;
    }

    public final String toString() {
        AppMethodBeat.i(68736);
        String bundle = this.zzafy.toString();
        AppMethodBeat.o(68736);
        return bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(68730);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzif(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(68730);
    }

    /* Access modifiers changed, original: final */
    public final Double zzbh(String str) {
        AppMethodBeat.i(68733);
        Double valueOf = Double.valueOf(this.zzafy.getDouble(str));
        AppMethodBeat.o(68733);
        return valueOf;
    }

    public final Bundle zzif() {
        AppMethodBeat.i(68737);
        Bundle bundle = new Bundle(this.zzafy);
        AppMethodBeat.o(68737);
        return bundle;
    }
}
