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
    public static final Creator<CameraEffectTextures> CREATOR = new Creator<CameraEffectTextures>() {
        public final CameraEffectTextures createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97354);
            CameraEffectTextures cameraEffectTextures = new CameraEffectTextures(parcel);
            AppMethodBeat.o(97354);
            return cameraEffectTextures;
        }

        public final CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    };
    private final Bundle textures;

    public static class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        private Bundle textures = new Bundle();

        public Builder() {
            AppMethodBeat.i(97357);
            AppMethodBeat.o(97357);
        }

        public Builder putTexture(String str, Bitmap bitmap) {
            AppMethodBeat.i(97358);
            Builder putParcelableTexture = putParcelableTexture(str, bitmap);
            AppMethodBeat.o(97358);
            return putParcelableTexture;
        }

        public Builder putTexture(String str, Uri uri) {
            AppMethodBeat.i(97359);
            Builder putParcelableTexture = putParcelableTexture(str, uri);
            AppMethodBeat.o(97359);
            return putParcelableTexture;
        }

        private Builder putParcelableTexture(String str, Parcelable parcelable) {
            AppMethodBeat.i(97360);
            if (!(Utility.isNullOrEmpty(str) || parcelable == null)) {
                this.textures.putParcelable(str, parcelable);
            }
            AppMethodBeat.o(97360);
            return this;
        }

        public Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            AppMethodBeat.i(97361);
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            AppMethodBeat.o(97361);
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97362);
            Builder readFrom = readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
            AppMethodBeat.o(97362);
            return readFrom;
        }

        public CameraEffectTextures build() {
            AppMethodBeat.i(97363);
            CameraEffectTextures cameraEffectTextures = new CameraEffectTextures(this, null);
            AppMethodBeat.o(97363);
            return cameraEffectTextures;
        }
    }

    /* synthetic */ CameraEffectTextures(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CameraEffectTextures(Builder builder) {
        AppMethodBeat.i(97366);
        this.textures = builder.textures;
        AppMethodBeat.o(97366);
    }

    CameraEffectTextures(Parcel parcel) {
        AppMethodBeat.i(97367);
        this.textures = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(97367);
    }

    public Bitmap getTextureBitmap(String str) {
        AppMethodBeat.i(97368);
        Object obj = this.textures.get(str);
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            AppMethodBeat.o(97368);
            return bitmap;
        }
        AppMethodBeat.o(97368);
        return null;
    }

    public Uri getTextureUri(String str) {
        AppMethodBeat.i(97369);
        Object obj = this.textures.get(str);
        if (obj instanceof Uri) {
            Uri uri = (Uri) obj;
            AppMethodBeat.o(97369);
            return uri;
        }
        AppMethodBeat.o(97369);
        return null;
    }

    public Object get(String str) {
        AppMethodBeat.i(97370);
        Object obj = this.textures.get(str);
        AppMethodBeat.o(97370);
        return obj;
    }

    public Set<String> keySet() {
        AppMethodBeat.i(97371);
        Set keySet = this.textures.keySet();
        AppMethodBeat.o(97371);
        return keySet;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97372);
        parcel.writeBundle(this.textures);
        AppMethodBeat.o(97372);
    }

    static {
        AppMethodBeat.i(97373);
        AppMethodBeat.o(97373);
    }
}
