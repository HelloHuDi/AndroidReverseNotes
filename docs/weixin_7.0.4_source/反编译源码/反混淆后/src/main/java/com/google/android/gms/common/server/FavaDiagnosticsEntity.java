package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<FavaDiagnosticsEntity> CREATOR = new FavaDiagnosticsEntityCreator();
    public static final String EXTRA_NAMESPACE = "namespace";
    public static final String EXTRA_TYPE_NUM = "typeNum";
    @Field(id = 2)
    public final String namespace;
    @Field(id = 3)
    public final int typeNum;
    @VersionField(id = 1)
    private final int zzal;

    static {
        AppMethodBeat.m2504i(61437);
        AppMethodBeat.m2505o(61437);
    }

    @Constructor
    public FavaDiagnosticsEntity(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2) {
        this.zzal = i;
        this.namespace = str;
        this.typeNum = i2;
    }

    public FavaDiagnosticsEntity(String str, int i) {
        this.zzal = 1;
        this.namespace = str;
        this.typeNum = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61436);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeString(parcel, 2, this.namespace, false);
        SafeParcelWriter.writeInt(parcel, 3, this.typeNum);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61436);
    }
}
