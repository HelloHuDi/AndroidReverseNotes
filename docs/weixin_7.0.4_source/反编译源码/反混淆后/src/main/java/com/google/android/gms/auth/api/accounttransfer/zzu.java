package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Class(creator = "AuthenticatorAnnotatedDataCreator")
public class zzu extends zzbs {
    public static final Creator<zzu> CREATOR = new zzv();
    private static final HashMap<String, Field<?, ?>> zzbk;
    @SafeParcelable.Field(getter = "getPackageName", id = 4)
    private String mPackageName;
    @Indicator
    private final Set<Integer> zzbl;
    @SafeParcelable.Field(getter = "getInfo", id = 2)
    private zzw zzbv;
    @SafeParcelable.Field(getter = "getSignature", id = 3)
    private String zzbw;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.m2504i(77022);
        HashMap hashMap = new HashMap();
        zzbk = hashMap;
        hashMap.put("authenticatorInfo", Field.forConcreteType("authenticatorInfo", 2, zzw.class));
        zzbk.put("signature", Field.forString("signature", 3));
        zzbk.put("package", Field.forString("package", 4));
        AppMethodBeat.m2505o(77022);
    }

    public zzu() {
        AppMethodBeat.m2504i(77016);
        this.zzbl = new HashSet(3);
        this.zzy = 1;
        AppMethodBeat.m2505o(77016);
    }

    @Constructor
    zzu(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) zzw zzw, @Param(id = 3) String str, @Param(id = 4) String str2) {
        this.zzbl = set;
        this.zzy = i;
        this.zzbv = zzw;
        this.zzbw = str;
        this.mPackageName = str2;
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String str, T t) {
        AppMethodBeat.m2504i(77021);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbv = (zzw) t;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.m2505o(77021);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[]{Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()}));
                AppMethodBeat.m2505o(77021);
                throw illegalArgumentException;
        }
    }

    public /* synthetic */ Map getFieldMappings() {
        return zzbk;
    }

    public Object getFieldValue(Field field) {
        AppMethodBeat.m2504i(77019);
        String str;
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                Integer valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.m2505o(77019);
                return valueOf;
            case 2:
                zzw zzw = this.zzbv;
                AppMethodBeat.m2505o(77019);
                return zzw;
            case 3:
                str = this.zzbw;
                AppMethodBeat.m2505o(77019);
                return str;
            case 4:
                str = this.mPackageName;
                AppMethodBeat.m2505o(77019);
                return str;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unknown SafeParcelable id=" + field.getSafeParcelableFieldId());
                AppMethodBeat.m2505o(77019);
                throw illegalStateException;
        }
    }

    public boolean isFieldSet(Field field) {
        AppMethodBeat.m2504i(77018);
        boolean contains = this.zzbl.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        AppMethodBeat.m2505o(77018);
        return contains;
    }

    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        AppMethodBeat.m2504i(77020);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 3:
                this.zzbw = str2;
                break;
            case 4:
                this.mPackageName = str2;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
                AppMethodBeat.m2505o(77020);
                throw illegalArgumentException;
        }
        this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
        AppMethodBeat.m2505o(77020);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77017);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set set = this.zzbl;
        if (set.contains(Integer.valueOf(1))) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeParcelable(parcel, 2, this.zzbv, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeString(parcel, 3, this.zzbw, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeString(parcel, 4, this.mPackageName, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77017);
    }
}
