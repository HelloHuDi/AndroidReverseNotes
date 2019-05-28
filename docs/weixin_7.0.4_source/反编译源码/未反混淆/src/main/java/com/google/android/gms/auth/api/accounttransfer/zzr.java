package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.f.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Class(creator = "AccountTransferProgressCreator")
public class zzr extends zzbs {
    public static final Creator<zzr> CREATOR = new zzs();
    private static final a<String, Field<?, ?>> zzbp;
    @SafeParcelable.Field(getter = "getRegisteredAccountTypes", id = 2)
    private List<String> zzbq;
    @SafeParcelable.Field(getter = "getInProgressAccountTypes", id = 3)
    private List<String> zzbr;
    @SafeParcelable.Field(getter = "getSuccessAccountTypes", id = 4)
    private List<String> zzbs;
    @SafeParcelable.Field(getter = "getFailedAccountTypes", id = 5)
    private List<String> zzbt;
    @SafeParcelable.Field(getter = "getEscrowedAccountTypes", id = 6)
    private List<String> zzbu;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(77014);
        a aVar = new a();
        zzbp = aVar;
        aVar.put("registered", Field.forStrings("registered", 2));
        zzbp.put("in_progress", Field.forStrings("in_progress", 3));
        zzbp.put("success", Field.forStrings("success", 4));
        zzbp.put("failed", Field.forStrings("failed", 5));
        zzbp.put("escrowed", Field.forStrings("escrowed", 6));
        AppMethodBeat.o(77014);
    }

    public zzr() {
        this.zzy = 1;
    }

    @Constructor
    zzr(@Param(id = 1) int i, @Param(id = 2) List<String> list, @Param(id = 3) List<String> list2, @Param(id = 4) List<String> list3, @Param(id = 5) List<String> list4, @Param(id = 6) List<String> list5) {
        this.zzy = i;
        this.zzbq = list;
        this.zzbr = list2;
        this.zzbs = list3;
        this.zzbt = list4;
        this.zzbu = list5;
    }

    public Map<String, Field<?, ?>> getFieldMappings() {
        return zzbp;
    }

    public Object getFieldValue(Field field) {
        AppMethodBeat.i(77012);
        List list;
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                Integer valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.o(77012);
                return valueOf;
            case 2:
                list = this.zzbq;
                AppMethodBeat.o(77012);
                return list;
            case 3:
                list = this.zzbr;
                AppMethodBeat.o(77012);
                return list;
            case 4:
                list = this.zzbs;
                AppMethodBeat.o(77012);
                return list;
            case 5:
                list = this.zzbt;
                AppMethodBeat.o(77012);
                return list;
            case 6:
                list = this.zzbu;
                AppMethodBeat.o(77012);
                return list;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unknown SafeParcelable id=" + field.getSafeParcelableFieldId());
                AppMethodBeat.o(77012);
                throw illegalStateException;
        }
    }

    public boolean isFieldSet(Field field) {
        return true;
    }

    public void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(77013);
        switch (field.getSafeParcelableFieldId()) {
            case 2:
                this.zzbq = arrayList;
                AppMethodBeat.o(77013);
                return;
            case 3:
                this.zzbr = arrayList;
                AppMethodBeat.o(77013);
                return;
            case 4:
                this.zzbs = arrayList;
                AppMethodBeat.o(77013);
                return;
            case 5:
                this.zzbt = arrayList;
                AppMethodBeat.o(77013);
                return;
            case 6:
                this.zzbu = arrayList;
                AppMethodBeat.o(77013);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", new Object[]{Integer.valueOf(field.getSafeParcelableFieldId())}));
                AppMethodBeat.o(77013);
                throw illegalArgumentException;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(77011);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzbq, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzbr, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzbs, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzbt, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzbu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(77011);
    }
}
