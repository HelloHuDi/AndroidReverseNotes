package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICertData.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesQueryCreator")
public class GoogleCertificatesQuery extends AbstractSafeParcelable {
    public static final Creator<GoogleCertificatesQuery> CREATOR = new GoogleCertificatesQueryCreator();
    @Field(getter = "getCallingPackage", id = 1)
    private final String zzbh;
    @Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    @Nullable
    private final CertData zzbi;
    @Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzbj;

    static {
        AppMethodBeat.m2504i(89389);
        AppMethodBeat.m2505o(89389);
    }

    @Constructor
    GoogleCertificatesQuery(@Param(id = 1) String str, @Param(id = 2) @Nullable IBinder iBinder, @Param(id = 3) boolean z) {
        AppMethodBeat.m2504i(89385);
        this.zzbh = str;
        this.zzbi = zza(iBinder);
        this.zzbj = z;
        AppMethodBeat.m2505o(89385);
    }

    GoogleCertificatesQuery(String str, @Nullable CertData certData, boolean z) {
        this.zzbh = str;
        this.zzbi = certData;
        this.zzbj = z;
    }

    @Nullable
    private static CertData zza(@Nullable IBinder iBinder) {
        AppMethodBeat.m2504i(89388);
        if (iBinder == null) {
            AppMethodBeat.m2505o(89388);
            return null;
        }
        try {
            IObjectWrapper bytesWrapped = Stub.asInterface(iBinder).getBytesWrapped();
            byte[] bArr = bytesWrapped == null ? null : (byte[]) ObjectWrapper.unwrap(bytesWrapped);
            CertData zzb = bArr != null ? new zzb(bArr) : null;
            AppMethodBeat.m2505o(89388);
            return zzb;
        } catch (RemoteException e) {
            AppMethodBeat.m2505o(89388);
            return null;
        }
    }

    public boolean getAllowTestKeys() {
        return this.zzbj;
    }

    @Nullable
    public IBinder getCallingCertificateBinder() {
        AppMethodBeat.m2504i(89386);
        if (this.zzbi == null) {
            AppMethodBeat.m2505o(89386);
            return null;
        }
        IBinder asBinder = this.zzbi.asBinder();
        AppMethodBeat.m2505o(89386);
        return asBinder;
    }

    public String getCallingPackage() {
        return this.zzbh;
    }

    @Nullable
    public CertData getCertificate() {
        return this.zzbi;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(89387);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getCallingPackage(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, getCallingCertificateBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, getAllowTestKeys());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(89387);
    }
}
