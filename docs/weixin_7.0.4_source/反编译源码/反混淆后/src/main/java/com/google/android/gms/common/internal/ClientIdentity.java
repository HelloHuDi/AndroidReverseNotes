package com.google.android.gms.common.internal;

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
import com.tencent.ttpic.util.VideoMaterialUtil;

@Class(creator = "ClientIdentityCreator")
@Reserved({1000})
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Creator<ClientIdentity> CREATOR = new ClientIdentityCreator();
    @Field(defaultValueUnchecked = "null", id = 2)
    public final String packageName;
    @Field(defaultValueUnchecked = "0", id = 1)
    public final int uid;

    static {
        AppMethodBeat.m2504i(61312);
        AppMethodBeat.m2505o(61312);
    }

    @Constructor
    public ClientIdentity(@Param(id = 1) int i, @Param(id = 2) String str) {
        this.uid = i;
        this.packageName = str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(61309);
        if (obj == this) {
            AppMethodBeat.m2505o(61309);
            return true;
        } else if (obj == null || !(obj instanceof ClientIdentity)) {
            AppMethodBeat.m2505o(61309);
            return false;
        } else {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.uid == this.uid && Objects.equal(clientIdentity.packageName, this.packageName)) {
                AppMethodBeat.m2505o(61309);
                return true;
            }
            AppMethodBeat.m2505o(61309);
            return false;
        }
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        AppMethodBeat.m2504i(61310);
        int i = this.uid;
        String str = this.packageName;
        String stringBuilder = new StringBuilder(String.valueOf(str).length() + 12).append(i).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str).toString();
        AppMethodBeat.m2505o(61310);
        return stringBuilder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61311);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.uid);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61311);
    }
}
