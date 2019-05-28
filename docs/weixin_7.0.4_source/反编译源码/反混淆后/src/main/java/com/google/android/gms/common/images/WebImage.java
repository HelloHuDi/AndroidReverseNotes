package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "WebImageCreator")
public final class WebImage extends AbstractSafeParcelable {
    public static final Creator<WebImage> CREATOR = new WebImageCreator();
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getWidth", id = 3)
    private final int zzps;
    @Field(getter = "getHeight", id = 4)
    private final int zzpt;
    @Field(getter = "getUrl", id = 2)
    private final Uri zzpu;

    static {
        AppMethodBeat.m2504i(61254);
        AppMethodBeat.m2505o(61254);
    }

    @Constructor
    WebImage(@Param(id = 1) int i, @Param(id = 2) Uri uri, @Param(id = 3) int i2, @Param(id = 4) int i3) {
        this.zzal = i;
        this.zzpu = uri;
        this.zzps = i2;
        this.zzpt = i3;
    }

    public WebImage(Uri uri) {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        AppMethodBeat.m2504i(61246);
        IllegalArgumentException illegalArgumentException;
        if (uri == null) {
            illegalArgumentException = new IllegalArgumentException("url cannot be null");
            AppMethodBeat.m2505o(61246);
            throw illegalArgumentException;
        } else if (i < 0 || i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("width and height must not be negative");
            AppMethodBeat.m2505o(61246);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(61246);
        }
    }

    public WebImage(JSONObject jSONObject) {
        this(zza(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
        AppMethodBeat.m2504i(61247);
        AppMethodBeat.m2505o(61247);
    }

    private static Uri zza(JSONObject jSONObject) {
        AppMethodBeat.m2504i(61248);
        Uri uri = null;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(61248);
        return uri;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(61251);
        if (this == obj) {
            AppMethodBeat.m2505o(61251);
            return true;
        } else if (obj == null || !(obj instanceof WebImage)) {
            AppMethodBeat.m2505o(61251);
            return false;
        } else {
            WebImage webImage = (WebImage) obj;
            if (Objects.equal(this.zzpu, webImage.zzpu) && this.zzps == webImage.zzps && this.zzpt == webImage.zzpt) {
                AppMethodBeat.m2505o(61251);
                return true;
            }
            AppMethodBeat.m2505o(61251);
            return false;
        }
    }

    public final int getHeight() {
        return this.zzpt;
    }

    public final Uri getUrl() {
        return this.zzpu;
    }

    public final int getWidth() {
        return this.zzps;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(61252);
        int hashCode = Objects.hashCode(this.zzpu, Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt));
        AppMethodBeat.m2505o(61252);
        return hashCode;
    }

    public final JSONObject toJson() {
        AppMethodBeat.m2504i(61250);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.zzpu.toString());
            jSONObject.put("width", this.zzps);
            jSONObject.put("height", this.zzpt);
        } catch (JSONException e) {
        }
        AppMethodBeat.m2505o(61250);
        return jSONObject;
    }

    public final String toString() {
        AppMethodBeat.m2504i(61249);
        String format = String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt), this.zzpu.toString()});
        AppMethodBeat.m2505o(61249);
        return format;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61253);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getUrl(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61253);
    }
}
