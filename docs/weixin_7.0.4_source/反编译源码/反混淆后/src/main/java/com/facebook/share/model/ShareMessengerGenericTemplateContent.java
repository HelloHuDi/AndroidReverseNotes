package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Builder> {
    public static final Creator<ShareMessengerGenericTemplateContent> CREATOR = new C08171();
    private final ShareMessengerGenericTemplateElement genericTemplateElement;
    private final ImageAspectRatio imageAspectRatio;
    private final boolean isSharable;

    /* renamed from: com.facebook.share.model.ShareMessengerGenericTemplateContent$1 */
    static class C08171 implements Creator<ShareMessengerGenericTemplateContent> {
        C08171() {
        }

        public final ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97450);
            ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(parcel);
            AppMethodBeat.m2505o(97450);
            return shareMessengerGenericTemplateContent;
        }

        public final ShareMessengerGenericTemplateContent[] newArray(int i) {
            return new ShareMessengerGenericTemplateContent[i];
        }
    }

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<ShareMessengerGenericTemplateContent, Builder> {
        private ShareMessengerGenericTemplateElement genericTemplateElement;
        private ImageAspectRatio imageAspectRatio;
        private boolean isSharable;

        public Builder setIsSharable(boolean z) {
            this.isSharable = z;
            return this;
        }

        public Builder setImageAspectRatio(ImageAspectRatio imageAspectRatio) {
            this.imageAspectRatio = imageAspectRatio;
            return this;
        }

        public Builder setGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            this.genericTemplateElement = shareMessengerGenericTemplateElement;
            return this;
        }

        public ShareMessengerGenericTemplateContent build() {
            AppMethodBeat.m2504i(97453);
            ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(this);
            AppMethodBeat.m2505o(97453);
            return shareMessengerGenericTemplateContent;
        }

        public Builder readFrom(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            AppMethodBeat.m2504i(97454);
            if (shareMessengerGenericTemplateContent == null) {
                AppMethodBeat.m2505o(97454);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareMessengerGenericTemplateContent)).setIsSharable(shareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(shareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement());
            AppMethodBeat.m2505o(97454);
            return this;
        }
    }

    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE;

        static {
            AppMethodBeat.m2505o(97460);
        }
    }

    protected ShareMessengerGenericTemplateContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.m2504i(97461);
        this.isSharable = builder.isSharable;
        this.imageAspectRatio = builder.imageAspectRatio;
        this.genericTemplateElement = builder.genericTemplateElement;
        AppMethodBeat.m2505o(97461);
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(97462);
        this.isSharable = parcel.readByte() != (byte) 0;
        this.imageAspectRatio = (ImageAspectRatio) parcel.readSerializable();
        this.genericTemplateElement = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
        AppMethodBeat.m2505o(97462);
    }

    public final boolean getIsSharable() {
        return this.isSharable;
    }

    public final ImageAspectRatio getImageAspectRatio() {
        return this.imageAspectRatio;
    }

    public final ShareMessengerGenericTemplateElement getGenericTemplateElement() {
        return this.genericTemplateElement;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97463);
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (this.isSharable ? 1 : 0));
        parcel.writeSerializable(this.imageAspectRatio);
        parcel.writeParcelable(this.genericTemplateElement, i);
        AppMethodBeat.m2505o(97463);
    }

    static {
        AppMethodBeat.m2504i(97464);
        AppMethodBeat.m2505o(97464);
    }
}
