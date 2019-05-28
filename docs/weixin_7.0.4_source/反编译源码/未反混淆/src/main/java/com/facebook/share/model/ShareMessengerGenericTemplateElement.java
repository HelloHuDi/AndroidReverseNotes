package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateElement implements ShareModel {
    public static final Creator<ShareMessengerGenericTemplateElement> CREATOR = new Creator<ShareMessengerGenericTemplateElement>() {
        public final ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97465);
            ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement = new ShareMessengerGenericTemplateElement(parcel);
            AppMethodBeat.o(97465);
            return shareMessengerGenericTemplateElement;
        }

        public final ShareMessengerGenericTemplateElement[] newArray(int i) {
            return new ShareMessengerGenericTemplateElement[i];
        }
    };
    private final ShareMessengerActionButton button;
    private final ShareMessengerActionButton defaultAction;
    private final Uri imageUrl;
    private final String subtitle;
    private final String title;

    public static class Builder implements ShareModelBuilder<ShareMessengerGenericTemplateElement, Builder> {
        private ShareMessengerActionButton button;
        private ShareMessengerActionButton defaultAction;
        private Uri imageUrl;
        private String subtitle;
        private String title;

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setSubtitle(String str) {
            this.subtitle = str;
            return this;
        }

        public Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public Builder setDefaultAction(ShareMessengerActionButton shareMessengerActionButton) {
            this.defaultAction = shareMessengerActionButton;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public ShareMessengerGenericTemplateElement build() {
            AppMethodBeat.i(97468);
            ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement = new ShareMessengerGenericTemplateElement(this, null);
            AppMethodBeat.o(97468);
            return shareMessengerGenericTemplateElement;
        }

        public Builder readFrom(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            AppMethodBeat.i(97469);
            if (shareMessengerGenericTemplateElement == null) {
                AppMethodBeat.o(97469);
                return this;
            }
            this = setTitle(shareMessengerGenericTemplateElement.title).setSubtitle(shareMessengerGenericTemplateElement.subtitle).setImageUrl(shareMessengerGenericTemplateElement.imageUrl).setDefaultAction(shareMessengerGenericTemplateElement.defaultAction).setButton(shareMessengerGenericTemplateElement.button);
            AppMethodBeat.o(97469);
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97470);
            Builder readFrom = readFrom((ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader()));
            AppMethodBeat.o(97470);
            return readFrom;
        }
    }

    /* synthetic */ ShareMessengerGenericTemplateElement(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareMessengerGenericTemplateElement(Builder builder) {
        AppMethodBeat.i(97473);
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.imageUrl = builder.imageUrl;
        this.defaultAction = builder.defaultAction;
        this.button = builder.button;
        AppMethodBeat.o(97473);
    }

    ShareMessengerGenericTemplateElement(Parcel parcel) {
        AppMethodBeat.i(97474);
        this.title = parcel.readString();
        this.subtitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.defaultAction = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        AppMethodBeat.o(97474);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final ShareMessengerActionButton getDefaultAction() {
        return this.defaultAction;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97475);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.imageUrl, i);
        parcel.writeParcelable(this.defaultAction, i);
        parcel.writeParcelable(this.button, i);
        AppMethodBeat.o(97475);
    }

    static {
        AppMethodBeat.i(97476);
        AppMethodBeat.o(97476);
    }
}
