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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Class(creator = "AccountTransferMsgCreator")
public final class zzo extends zzbs {
    public static final Creator<zzo> CREATOR = new zzp();
    private static final HashMap<String, Field<?, ?>> zzbk;
    @Indicator
    private final Set<Integer> zzbl;
    @SafeParcelable.Field(getter = "getAuthenticatorDatas", id = 2)
    private ArrayList<zzu> zzbm;
    @SafeParcelable.Field(getter = "getRequestType", id = 3)
    private int zzbn;
    @SafeParcelable.Field(getter = "getProgress", id = 4)
    private zzr zzbo;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.m2504i(77009);
        HashMap hashMap = new HashMap();
        zzbk = hashMap;
        hashMap.put("authenticatorData", Field.forConcreteTypeArray("authenticatorData", 2, zzu.class));
        zzbk.put("progress", Field.forConcreteType("progress", 4, zzr.class));
        AppMethodBeat.m2505o(77009);
    }

    public zzo() {
        AppMethodBeat.m2504i(77003);
        this.zzbl = new HashSet(1);
        this.zzy = 1;
        AppMethodBeat.m2505o(77003);
    }

    @Constructor
    zzo(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) ArrayList<zzu> arrayList, @Param(id = 3) int i2, @Param(id = 4) zzr zzr) {
        this.zzbl = set;
        this.zzy = i;
        this.zzbm = arrayList;
        this.zzbn = i2;
        this.zzbo = zzr;
    }

    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String str, ArrayList<T> arrayList) {
        AppMethodBeat.m2504i(77007);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbm = arrayList;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.m2505o(77007);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", new Object[]{Integer.valueOf(safeParcelableFieldId), arrayList.getClass().getCanonicalName()}));
                AppMethodBeat.m2505o(77007);
                throw illegalArgumentException;
        }
    }

    public final <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String str, T t) {
        AppMethodBeat.m2504i(77008);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 4:
                this.zzbo = (zzr) t;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.m2505o(77008);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[]{Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()}));
                AppMethodBeat.m2505o(77008);
                throw illegalArgumentException;
        }
    }

    public final /* synthetic */ Map getFieldMappings() {
        return zzbk;
    }

    public final Object getFieldValue(Field field) {
        AppMethodBeat.m2504i(77006);
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                Integer valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.m2505o(77006);
                return valueOf;
            case 2:
                ArrayList arrayList = this.zzbm;
                AppMethodBeat.m2505o(77006);
                return arrayList;
            case 4:
                zzr zzr = this.zzbo;
                AppMethodBeat.m2505o(77006);
                return zzr;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unknown SafeParcelable id=" + field.getSafeParcelableFieldId());
                AppMethodBeat.m2505o(77006);
                throw illegalStateException;
        }
    }

    public final boolean isFieldSet(Field field) {
        AppMethodBeat.m2504i(77005);
        boolean contains = this.zzbl.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        AppMethodBeat.m2505o(77005);
        return contains;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77004);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set set = this.zzbl;
        if (set.contains(Integer.valueOf(1))) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeTypedList(parcel, 2, this.zzbm, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzbn);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzbo, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77004);
    }
}
