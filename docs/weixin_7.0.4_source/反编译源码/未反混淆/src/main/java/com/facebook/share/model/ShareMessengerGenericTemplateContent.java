package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Builder> {
    public static final Creator<ShareMessengerGenericTemplateContent> CREATOR = new Creator<ShareMessengerGenericTemplateContent>() {
        public final ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97450);
            ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(parcel);
            AppMethodBeat.o(97450);
            return shareMessengerGenericTemplateContent;
        }

        public final ShareMessengerGenericTemplateContent[] newArray(int i) {
            return new ShareMessengerGenericTemplateContent[i];
        }
    };
    private final ShareMessengerGenericTemplateElement genericTemplateElement;
    private final ImageAspectRatio imageAspectRatio;
    private final boolean isSharable;

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
            AppMethodBeat.i(97453);
            ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(this);
            AppMethodBeat.o(97453);
            return shareMessengerGenericTemplateContent;
        }

        public Builder readFrom(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            AppMethodBeat.i(97454);
            if (shareMessengerGenericTemplateContent == null) {
                AppMethodBeat.o(97454);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareMessengerGenericTemplateContent)).setIsSharable(shareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(shareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement());
            AppMethodBeat.o(97454);
            return this;
        }
    }

    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE;

        static {
            AppMethodBeat.o(97460);
        }
    }

    protected ShareMessengerGenericTemplateContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97461);
        this.isSharable = builder.isSharable;
        this.imageAspectRatio = builder.imageAspectRatio;
        this.genericTemplateElement = builder.genericTemplateElement;
        AppMethodBeat.o(97461);
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97462);
        this.isSharable = parcel.readByte() != (byte) 0;
        this.imageAspectRatio = (ImageAspectRatio) parcel.readSerializable();
        this.genericTemplateElement = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
        AppMethodBeat.o(97462);
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
        AppMethodBeat.i(97463);
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (this.isSharable ? 1 : 0));
        parcel.writeSerializable(this.imageAspectRatio);
        parcel.writeParcelable(this.genericTemplateElement, i);
        AppMethodBeat.o(97463);
    }

    static {
        AppMethodBeat.i(97464);
        AppMethodBeat.o(97464);
    }
}
