package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@Class(creator = "ProxyRequestCreator")
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zzd();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    @Field(id = 4)
    public final byte[] body;
    @Field(id = 2)
    public final int httpMethod;
    @Field(id = 3)
    public final long timeoutMillis;
    @Field(id = 1)
    public final String url;
    @VersionField(id = 1000)
    private final int versionCode;
    @Field(id = 5)
    private Bundle zzdw;

    @KeepForSdkWithMembers
    public static class Builder {
        private String zzdx;
        private int zzdy = ProxyRequest.HTTP_METHOD_GET;
        private long zzdz = 3000;
        private byte[] zzea = null;
        private Bundle zzeb = new Bundle();

        public Builder(String str) {
            AppMethodBeat.m2504i(77035);
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zzdx = str;
                AppMethodBeat.m2505o(77035);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 51).append("The supplied url [ ").append(str).append("] is not match Patterns.WEB_URL!").toString());
            AppMethodBeat.m2505o(77035);
            throw illegalArgumentException;
        }

        public ProxyRequest build() {
            AppMethodBeat.m2504i(77039);
            if (this.zzea == null) {
                this.zzea = new byte[0];
            }
            ProxyRequest proxyRequest = new ProxyRequest(2, this.zzdx, this.zzdy, this.zzdz, this.zzea, this.zzeb);
            AppMethodBeat.m2505o(77039);
            return proxyRequest;
        }

        public Builder putHeader(String str, String str2) {
            AppMethodBeat.m2504i(77038);
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zzeb;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            AppMethodBeat.m2505o(77038);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzea = bArr;
            return this;
        }

        public Builder setHttpMethod(int i) {
            AppMethodBeat.m2504i(77036);
            boolean z = i >= 0 && i <= ProxyRequest.LAST_CODE;
            Preconditions.checkArgument(z, "Unrecognized http method code.");
            this.zzdy = i;
            AppMethodBeat.m2505o(77036);
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            AppMethodBeat.m2504i(77037);
            Preconditions.checkArgument(j >= 0, "The specified timeout must be non-negative.");
            this.zzdz = j;
            AppMethodBeat.m2505o(77037);
            return this;
        }
    }

    static {
        AppMethodBeat.m2504i(77043);
        AppMethodBeat.m2505o(77043);
    }

    @Constructor
    ProxyRequest(@Param(id = 1000) int i, @Param(id = 1) String str, @Param(id = 2) int i2, @Param(id = 3) long j, @Param(id = 4) byte[] bArr, @Param(id = 5) Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzdw = bundle;
    }

    public Map<String, String> getHeaderMap() {
        AppMethodBeat.m2504i(77040);
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzdw.size());
        for (String str : this.zzdw.keySet()) {
            linkedHashMap.put(str, this.zzdw.getString(str));
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        AppMethodBeat.m2505o(77040);
        return unmodifiableMap;
    }

    public String toString() {
        AppMethodBeat.m2504i(77041);
        String str = this.url;
        str = new StringBuilder(String.valueOf(str).length() + 42).append("ProxyRequest[ url: ").append(str).append(", method: ").append(this.httpMethod).append(" ]").toString();
        AppMethodBeat.m2505o(77041);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77042);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzdw, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77042);
    }
}
