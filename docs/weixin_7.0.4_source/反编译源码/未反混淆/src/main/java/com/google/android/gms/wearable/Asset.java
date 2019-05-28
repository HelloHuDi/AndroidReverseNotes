package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@Class(creator = "AssetCreator")
@Reserved({1})
@VisibleForTesting
public class Asset extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Asset> CREATOR = new zze();
    @Field(getter = "getData", id = 2)
    private byte[] data;
    @Field(id = 5)
    private Uri uri;
    @Field(getter = "getDigest", id = 3)
    private String zze;
    @Field(id = 4)
    private ParcelFileDescriptor zzf;

    static {
        AppMethodBeat.i(70793);
        AppMethodBeat.o(70793);
    }

    @Constructor
    Asset(@Param(id = 2) byte[] bArr, @Param(id = 3) String str, @Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @Param(id = 5) Uri uri) {
        this.data = bArr;
        this.zze = str;
        this.zzf = parcelFileDescriptor;
        this.uri = uri;
    }

    @VisibleForTesting
    public static Asset createFromBytes(byte[] bArr) {
        AppMethodBeat.i(70787);
        Asserts.checkNotNull(bArr);
        Asset asset = new Asset(bArr, null, null, null);
        AppMethodBeat.o(70787);
        return asset;
    }

    @VisibleForTesting
    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(70788);
        Asserts.checkNotNull(parcelFileDescriptor);
        Asset asset = new Asset(null, null, parcelFileDescriptor, null);
        AppMethodBeat.o(70788);
        return asset;
    }

    public static Asset createFromRef(String str) {
        AppMethodBeat.i(70786);
        Asserts.checkNotNull(str);
        Asset asset = new Asset(null, str, null, null);
        AppMethodBeat.o(70786);
        return asset;
    }

    @VisibleForTesting
    public static Asset createFromUri(Uri uri) {
        AppMethodBeat.i(70789);
        Asserts.checkNotNull(uri);
        Asset asset = new Asset(null, null, null, uri);
        AppMethodBeat.o(70789);
        return asset;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(70791);
        if (this == obj) {
            AppMethodBeat.o(70791);
            return true;
        } else if (obj instanceof Asset) {
            Asset asset = (Asset) obj;
            if (Arrays.equals(this.data, asset.data) && Objects.equal(this.zze, asset.zze) && Objects.equal(this.zzf, asset.zzf) && Objects.equal(this.uri, asset.uri)) {
                AppMethodBeat.o(70791);
                return true;
            }
            AppMethodBeat.o(70791);
            return false;
        } else {
            AppMethodBeat.o(70791);
            return false;
        }
    }

    public final byte[] getData() {
        return this.data;
    }

    public String getDigest() {
        return this.zze;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzf;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        AppMethodBeat.i(70790);
        int deepHashCode = Arrays.deepHashCode(new Object[]{this.data, this.zze, this.zzf, this.uri});
        AppMethodBeat.o(70790);
        return deepHashCode;
    }

    public String toString() {
        AppMethodBeat.i(70792);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zze == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.zze);
        }
        if (this.data != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.data.length);
        }
        if (this.zzf != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.zzf);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(70792);
        return stringBuilder2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(70785);
        Asserts.checkNotNull(parcel);
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.data, false);
        SafeParcelWriter.writeString(parcel, 3, getDigest(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzf, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.uri, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(70785);
    }
}
