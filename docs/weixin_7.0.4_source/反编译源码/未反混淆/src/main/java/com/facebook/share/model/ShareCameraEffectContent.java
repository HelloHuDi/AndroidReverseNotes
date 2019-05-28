package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    public static final Creator<ShareCameraEffectContent> CREATOR = new Creator<ShareCameraEffectContent>() {
        public final ShareCameraEffectContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97394);
            ShareCameraEffectContent shareCameraEffectContent = new ShareCameraEffectContent(parcel);
            AppMethodBeat.o(97394);
            return shareCameraEffectContent;
        }

        public final ShareCameraEffectContent[] newArray(int i) {
            return new ShareCameraEffectContent[i];
        }
    };
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareCameraEffectContent, Builder> {
        private CameraEffectArguments arguments;
        private String effectId;
        private CameraEffectTextures textures;

        public final Builder setEffectId(String str) {
            this.effectId = str;
            return this;
        }

        public final Builder setArguments(CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
            return this;
        }

        public final Builder setTextures(CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
            return this;
        }

        public final ShareCameraEffectContent build() {
            AppMethodBeat.i(97397);
            ShareCameraEffectContent shareCameraEffectContent = new ShareCameraEffectContent(this, null);
            AppMethodBeat.o(97397);
            return shareCameraEffectContent;
        }

        public final Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            AppMethodBeat.i(97398);
            if (shareCameraEffectContent == null) {
                AppMethodBeat.o(97398);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareCameraEffectContent)).setEffectId(this.effectId).setArguments(this.arguments);
            AppMethodBeat.o(97398);
            return this;
        }
    }

    /* synthetic */ ShareCameraEffectContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareCameraEffectContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97402);
        this.effectId = builder.effectId;
        this.arguments = builder.arguments;
        this.textures = builder.textures;
        AppMethodBeat.o(97402);
    }

    ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97403);
        this.effectId = parcel.readString();
        this.arguments = new com.facebook.share.model.CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new com.facebook.share.model.CameraEffectTextures.Builder().readFrom(parcel).build();
        AppMethodBeat.o(97403);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97404);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.effectId);
        parcel.writeParcelable(this.arguments, 0);
        parcel.writeParcelable(this.textures, 0);
        AppMethodBeat.o(97404);
    }

    public String getEffectId() {
        return this.effectId;
    }

    public CameraEffectArguments getArguments() {
        return this.arguments;
    }

    public CameraEffectTextures getTextures() {
        return this.textures;
    }

    static {
        AppMethodBeat.i(97405);
        AppMethodBeat.o(97405);
    }
}
