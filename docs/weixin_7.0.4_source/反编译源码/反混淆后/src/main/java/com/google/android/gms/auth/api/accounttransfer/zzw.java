package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p057v4.p065f.C0402b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Class(creator = "AuthenticatorTransferInfoCreator")
public class zzw extends zzbs {
    public static final Creator<zzw> CREATOR = new zzx();
    private static final HashMap<String, Field<?, ?>> zzbk;
    @Indicator
    private final Set<Integer> zzbl;
    @SafeParcelable.Field(getter = "getAccountType", id = 2)
    private String zzbx;
    @SafeParcelable.Field(getter = "getStatus", id = 3)
    private int zzby;
    @SafeParcelable.Field(getter = "getTransferBytes", id = 4)
    private byte[] zzbz;
    @SafeParcelable.Field(getter = "getPendingIntent", id = 5)
    private PendingIntent zzca;
    @SafeParcelable.Field(getter = "getDeviceMetaData", id = 6)
    private DeviceMetaData zzcb;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.m2504i(77031);
        HashMap hashMap = new HashMap();
        zzbk = hashMap;
        hashMap.put("accountType", Field.forString("accountType", 2));
        zzbk.put("status", Field.forInteger("status", 3));
        zzbk.put("transferBytes", Field.forBase64("transferBytes", 4));
        AppMethodBeat.m2505o(77031);
    }

    public zzw() {
        AppMethodBeat.m2504i(77024);
        this.zzbl = new C0402b(3);
        this.zzy = 1;
        AppMethodBeat.m2505o(77024);
    }

    @Constructor
    zzw(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2, @Param(id = 4) byte[] bArr, @Param(id = 5) PendingIntent pendingIntent, @Param(id = 6) DeviceMetaData deviceMetaData) {
        this.zzbl = set;
        this.zzy = i;
        this.zzbx = str;
        this.zzby = i2;
        this.zzbz = bArr;
        this.zzca = pendingIntent;
        this.zzcb = deviceMetaData;
    }

    public /* synthetic */ Map getFieldMappings() {
        return zzbk;
    }

    public Object getFieldValue(Field field) {
        AppMethodBeat.m2504i(77027);
        Integer valueOf;
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.m2505o(77027);
                return valueOf;
            case 2:
                String str = this.zzbx;
                AppMethodBeat.m2505o(77027);
                return str;
            case 3:
                valueOf = Integer.valueOf(this.zzby);
                AppMethodBeat.m2505o(77027);
                return valueOf;
            case 4:
                byte[] bArr = this.zzbz;
                AppMethodBeat.m2505o(77027);
                return bArr;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unknown SafeParcelable id=" + field.getSafeParcelableFieldId());
                AppMethodBeat.m2505o(77027);
                throw illegalStateException;
        }
    }

    public boolean isFieldSet(Field field) {
        AppMethodBeat.m2504i(77026);
        boolean contains = this.zzbl.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        AppMethodBeat.m2505o(77026);
        return contains;
    }

    public void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        AppMethodBeat.m2504i(77030);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 4:
                this.zzbz = bArr;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.m2505o(77030);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be an byte array.");
                AppMethodBeat.m2505o(77030);
                throw illegalArgumentException;
        }
    }

    public void setIntegerInternal(Field<?, ?> field, String str, int i) {
        AppMethodBeat.m2504i(77029);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 3:
                this.zzby = i;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.m2505o(77029);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be an int.");
                AppMethodBeat.m2505o(77029);
                throw illegalArgumentException;
        }
    }

    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        AppMethodBeat.m2504i(77028);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbx = str2;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.m2505o(77028);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
                AppMethodBeat.m2505o(77028);
                throw illegalArgumentException;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77025);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set set = this.zzbl;
        if (set.contains(Integer.valueOf(1))) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeString(parcel, 2, this.zzbx, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzby);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzbz, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzca, i, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzcb, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77025);
    }
}
