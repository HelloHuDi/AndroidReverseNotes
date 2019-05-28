package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new C176231();
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    /* renamed from: com.facebook.share.model.ShareOpenGraphContent$1 */
    static class C176231 implements Creator<ShareOpenGraphContent> {
        C176231() {
        }

        public final ShareOpenGraphContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97530);
            ShareOpenGraphContent shareOpenGraphContent = new ShareOpenGraphContent(parcel);
            AppMethodBeat.m2505o(97530);
            return shareOpenGraphContent;
        }

        public final ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareOpenGraphContent, Builder> {
        private ShareOpenGraphAction action;
        private String previewPropertyName;

        public final Builder setAction(ShareOpenGraphAction shareOpenGraphAction) {
            ShareOpenGraphAction shareOpenGraphAction2;
            AppMethodBeat.m2504i(97533);
            if (shareOpenGraphAction == null) {
                shareOpenGraphAction2 = null;
            } else {
                shareOpenGraphAction2 = new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            }
            this.action = shareOpenGraphAction2;
            AppMethodBeat.m2505o(97533);
            return this;
        }

        public final Builder setPreviewPropertyName(String str) {
            this.previewPropertyName = str;
            return this;
        }

        public final ShareOpenGraphContent build() {
            AppMethodBeat.m2504i(97534);
            ShareOpenGraphContent shareOpenGraphContent = new ShareOpenGraphContent(this, null);
            AppMethodBeat.m2505o(97534);
            return shareOpenGraphContent;
        }

        public final Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            AppMethodBeat.m2504i(97535);
            if (shareOpenGraphContent == null) {
                AppMethodBeat.m2505o(97535);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
            AppMethodBeat.m2505o(97535);
            return this;
        }
    }

    /* synthetic */ ShareOpenGraphContent(Builder builder, C176231 c176231) {
        this(builder);
    }

    private ShareOpenGraphContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.m2504i(97539);
        this.action = builder.action;
        this.previewPropertyName = builder.previewPropertyName;
        AppMethodBeat.m2505o(97539);
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(97540);
        this.action = new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
        AppMethodBeat.m2505o(97540);
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
        AppMethodBeat.m2504i(97541);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
        AppMethodBeat.m2505o(97541);
    }

    static {
        AppMethodBeat.m2504i(97542);
        AppMethodBeat.m2505o(97542);
    }
}
