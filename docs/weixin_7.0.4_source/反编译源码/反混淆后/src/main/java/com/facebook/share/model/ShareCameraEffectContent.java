package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    public static final Creator<ShareCameraEffectContent> CREATOR = new C176201();
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
            AppMethodBeat.m2504i(97397);
            ShareCameraEffectContent shareCameraEffectContent = new ShareCameraEffectContent(this, null);
            AppMethodBeat.m2505o(97397);
            return shareCameraEffectContent;
        }

        public final Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            AppMethodBeat.m2504i(97398);
            if (shareCameraEffectContent == null) {
                AppMethodBeat.m2505o(97398);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareCameraEffectContent)).setEffectId(this.effectId).setArguments(this.arguments);
            AppMethodBeat.m2505o(97398);
            return this;
        }
    }

    /* renamed from: com.facebook.share.model.ShareCameraEffectContent$1 */
    static class C176201 implements Creator<ShareCameraEffectContent> {
        C176201() {
        }

        public final ShareCameraEffectContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97394);
            ShareCameraEffectContent shareCameraEffectContent = new ShareCameraEffectContent(parcel);
            AppMethodBeat.m2505o(97394);
            return shareCameraEffectContent;
        }

        public final ShareCameraEffectContent[] newArray(int i) {
            return new ShareCameraEffectContent[i];
        }
    }

    /* synthetic */ ShareCameraEffectContent(Builder builder, C176201 c176201) {
        this(builder);
    }

    private ShareCameraEffectContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.m2504i(97402);
        this.effectId = builder.effectId;
        this.arguments = builder.arguments;
        this.textures = builder.textures;
        AppMethodBeat.m2505o(97402);
    }

    ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(97403);
        this.effectId = parcel.readString();
        this.arguments = new com.facebook.share.model.CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new com.facebook.share.model.CameraEffectTextures.Builder().readFrom(parcel).build();
        AppMethodBeat.m2505o(97403);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97404);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.effectId);
        parcel.writeParcelable(this.arguments, 0);
        parcel.writeParcelable(this.textures, 0);
        AppMethodBeat.m2505o(97404);
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
        AppMethodBeat.m2504i(97405);
        AppMethodBeat.m2505o(97405);
    }
}
