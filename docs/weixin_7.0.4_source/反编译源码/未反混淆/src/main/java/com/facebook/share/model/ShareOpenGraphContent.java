package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new Creator<ShareOpenGraphContent>() {
        public final ShareOpenGraphContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97530);
            ShareOpenGraphContent shareOpenGraphContent = new ShareOpenGraphContent(parcel);
            AppMethodBeat.o(97530);
            return shareOpenGraphContent;
        }

        public final ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    };
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareOpenGraphContent, Builder> {
        private ShareOpenGraphAction action;
        private String previewPropertyName;

        public final Builder setAction(ShareOpenGraphAction shareOpenGraphAction) {
            ShareOpenGraphAction shareOpenGraphAction2;
            AppMethodBeat.i(97533);
            if (shareOpenGraphAction == null) {
                shareOpenGraphAction2 = null;
            } else {
                shareOpenGraphAction2 = new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            }
            this.action = shareOpenGraphAction2;
            AppMethodBeat.o(97533);
            return this;
        }

        public final Builder setPreviewPropertyName(String str) {
            this.previewPropertyName = str;
            return this;
        }

        public final ShareOpenGraphContent build() {
            AppMethodBeat.i(97534);
            ShareOpenGraphContent shareOpenGraphContent = new ShareOpenGraphContent(this, null);
            AppMethodBeat.o(97534);
            return shareOpenGraphContent;
        }

        public final Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            AppMethodBeat.i(97535);
            if (shareOpenGraphContent == null) {
                AppMethodBeat.o(97535);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
            AppMethodBeat.o(97535);
            return this;
        }
    }

    /* synthetic */ ShareOpenGraphContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareOpenGraphContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97539);
        this.action = builder.action;
        this.previewPropertyName = builder.previewPropertyName;
        AppMethodBeat.o(97539);
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97540);
        this.action = new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
        AppMethodBeat.o(97540);
    }

    public final ShareOpenGraphAction getAction() {
        return this.action;
    }

    public final String getPreviewPropertyName() {
        return this.previewPropertyName;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97541);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
        AppMethodBeat.o(97541);
    }

    static {
        AppMethodBeat.i(97542);
        AppMethodBeat.o(97542);
    }
}
