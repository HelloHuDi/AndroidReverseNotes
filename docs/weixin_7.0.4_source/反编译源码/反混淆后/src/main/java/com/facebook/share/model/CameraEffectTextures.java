package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectTextures implements ShareModel {
    public static final Creator<CameraEffectTextures> CREATOR = new C254991();
    private final Bundle textures;

    /* renamed from: com.facebook.share.model.CameraEffectTextures$1 */
    static class C254991 implements Creator<CameraEffectTextures> {
        C254991() {
        }

        public final CameraEffectTextures createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97354);
            CameraEffectTextures cameraEffectTextures = new CameraEffectTextures(parcel);
            AppMethodBeat.m2505o(97354);
            return cameraEffectTextures;
        }

        public final CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    }

    public static class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        private Bundle textures = new Bundle();

        public Builder() {
            AppMethodBeat.m2504i(97357);
            AppMethodBeat.m2505o(97357);
        }

        public Builder putTexture(String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(97358);
            Builder putParcelableTexture = putParcelableTexture(str, bitmap);
            AppMethodBeat.m2505o(97358);
            return putParcelableTexture;
        }

        public Builder putTexture(String str, Uri uri) {
            AppMethodBeat.m2504i(97359);
            Builder putParcelableTexture = putParcelableTexture(str, uri);
            AppMethodBeat.m2505o(97359);
            return putParcelableTexture;
        }

        private Builder putParcelableTexture(String str, Parcelable parcelable) {
            AppMethodBeat.m2504i(97360);
            if (!(Utility.isNullOrEmpty(str) || parcelable == null)) {
                this.textures.putParcelable(str, parcelable);
            }
            AppMethodBeat.m2505o(97360);
            return this;
        }

        public Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            AppMethodBeat.m2504i(97361);
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            AppMethodBeat.m2505o(97361);
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.m2504i(97362);
            Builder readFrom = readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
            AppMethodBeat.m2505o(97362);
            return readFrom;
        }

        public CameraEffectTextures build() {
            AppMethodBeat.m2504i(97363);
            CameraEffectTextures cameraEffectTextures = new CameraEffectTextures(this, null);
            AppMethodBeat.m2505o(97363);
            return cameraEffectTextures;
        }
    }

    /* synthetic */ CameraEffectTextures(Builder builder, C254991 c254991) {
        this(builder);
    }

    private CameraEffectTextures(Builder builder) {
        AppMethodBeat.m2504i(97366);
        this.textures = builder.textures;
        AppMethodBeat.m2505o(97366);
    }

    CameraEffectTextures(Parcel parcel) {
        AppMethodBeat.m2504i(97367);
        this.textures = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.m2505o(97367);
    }

    public Bitmap getTextureBitmap(String str) {
        AppMethodBeat.m2504i(97368);
        Object obj = this.textures.get(str);
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            AppMethodBeat.m2505o(97368);
            return bitmap;
        }
        AppMethodBeat.m2505o(97368);
        return null;
    }

    public Uri getTextureUri(String str) {
        AppMethodBeat.m2504i(97369);
        Object obj = this.textures.get(str);
        if (obj instanceof Uri) {
            Uri uri = (Uri) obj;
            AppMethodBeat.m2505o(97369);
            return uri;
        }
        AppMethodBeat.m2505o(97369);
        return null;
    }

    public Object get(String str) {
        AppMethodBeat.m2504i(97370);
        Object obj = this.textures.get(str);
        AppMethodBeat.m2505o(97370);
        return obj;
    }

    public Set<String> keySet() {
        AppMethodBeat.m2504i(97371);
        Set keySet = this.textures.keySet();
        AppMethodBeat.m2505o(97371);
        return keySet;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97372);
        parcel.writeBundle(this.textures);
        AppMethodBeat.m2505o(97372);
    }

    static {
        AppMethodBeat.m2504i(97373);
        AppMethodBeat.m2505o(97373);
    }
}
