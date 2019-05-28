package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerMediaTemplateContent extends ShareContent<ShareMessengerMediaTemplateContent, Builder> {
    public static final Creator<ShareMessengerMediaTemplateContent> CREATOR = new C320111();
    private final String attachmentId;
    private final ShareMessengerActionButton button;
    private final MediaType mediaType;
    private final Uri mediaUrl;

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<ShareMessengerMediaTemplateContent, Builder> {
        private String attachmentId;
        private ShareMessengerActionButton button;
        private MediaType mediaType;
        private Uri mediaUrl;

        public Builder setMediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public Builder setAttachmentId(String str) {
            this.attachmentId = str;
            return this;
        }

        public Builder setMediaUrl(Uri uri) {
            this.mediaUrl = uri;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public Builder readFrom(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            AppMethodBeat.m2504i(97480);
            if (shareMessengerMediaTemplateContent == null) {
                AppMethodBeat.m2505o(97480);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareMessengerMediaTemplateContent)).setMediaType(shareMessengerMediaTemplateContent.getMediaType()).setAttachmentId(shareMessengerMediaTemplateContent.getAttachmentId()).setMediaUrl(shareMessengerMediaTemplateContent.getMediaUrl()).setButton(shareMessengerMediaTemplateContent.getButton());
            AppMethodBeat.m2505o(97480);
            return this;
        }

        public ShareMessengerMediaTemplateContent build() {
            AppMethodBeat.m2504i(97481);
            ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent = new ShareMessengerMediaTemplateContent(this, null);
            AppMethodBeat.m2505o(97481);
            return shareMessengerMediaTemplateContent;
        }
    }

    public enum MediaType {
        IMAGE,
        VIDEO;

        static {
            AppMethodBeat.m2505o(97487);
        }
    }

    /* renamed from: com.facebook.share.model.ShareMessengerMediaTemplateContent$1 */
    static class C320111 implements Creator<ShareMessengerMediaTemplateContent> {
        C320111() {
        }

        public final ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97477);
            ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent = new ShareMessengerMediaTemplateContent(parcel);
            AppMethodBeat.m2505o(97477);
            return shareMessengerMediaTemplateContent;
        }

        public final ShareMessengerMediaTemplateContent[] newArray(int i) {
            return new ShareMessengerMediaTemplateContent[i];
        }
    }

    /* synthetic */ ShareMessengerMediaTemplateContent(Builder builder, C320111 c320111) {
        this(builder);
    }

    private ShareMessengerMediaTemplateContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.m2504i(97488);
        this.mediaType = builder.mediaType;
        this.attachmentId = builder.attachmentId;
        this.mediaUrl = builder.mediaUrl;
        this.button = builder.button;
        AppMethodBeat.m2505o(97488);
    }

    ShareMessengerMediaTemplateContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(97489);
        this.mediaType = (MediaType) parcel.readSerializable();
        this.attachmentId = parcel.readString();
        this.mediaUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        AppMethodBeat.m2505o(97489);
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final String getAttachmentId() {
        return this.attachmentId;
    }

    public final Uri getMediaUrl() {
        return this.mediaUrl;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97490);
        parcel.writeSerializable(this.mediaType);
        parcel.writeString(this.attachmentId);
        parcel.writeParcelable(this.mediaUrl, i);
        parcel.writeParcelable(this.button, i);
        AppMethodBeat.m2505o(97490);
    }

    static {
        AppMethodBeat.m2504i(97491);
        AppMethodBeat.m2505o(97491);
    }
}
