package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "ConverterWrapperCreator")
public class ConverterWrapper extends AbstractSafeParcelable {
    public static final Creator<ConverterWrapper> CREATOR = new ConverterWrapperCreator();
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter zzwd;

    static {
        AppMethodBeat.m2504i(61444);
        AppMethodBeat.m2505o(61444);
    }

    @Constructor
    ConverterWrapper(@Param(id = 1) int i, @Param(id = 2) StringToIntConverter stringToIntConverter) {
        this.zzal = i;
        this.zzwd = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.zzal = 1;
        this.zzwd = stringToIntConverter;
    }

    public static ConverterWrapper wrap(FieldConverter<?, ?> fieldConverter) {
        AppMethodBeat.m2504i(61441);
        if (fieldConverter instanceof StringToIntConverter) {
            ConverterWrapper converterWrapper = new ConverterWrapper((StringToIntConverter) fieldConverter);
            AppMethodBeat.m2505o(61441);
            return converterWrapper;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        AppMethodBeat.m2505o(61441);
        throw illegalArgumentException;
    }

    public FieldConverter<?, ?> unwrap() {
        AppMethodBeat.m2504i(61442);
        if (this.zzwd != null) {
            StringToIntConverter stringToIntConverter = this.zzwd;
            AppMethodBeat.m2505o(61442);
            return stringToIntConverter;
        }
        IllegalStateException illegalStateException = new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        AppMethodBeat.m2505o(61442);
        throw illegalStateException;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61443);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzwd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61443);
    }
}
