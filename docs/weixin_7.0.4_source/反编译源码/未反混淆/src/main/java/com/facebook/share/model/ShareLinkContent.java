package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Creator<ShareLinkContent> CREATOR = new Creator<ShareLinkContent>() {
        public final ShareLinkContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97418);
            ShareLinkContent shareLinkContent = new ShareLinkContent(parcel);
            AppMethodBeat.o(97418);
            return shareLinkContent;
        }

        public final ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    };
    @Deprecated
    private final String contentDescription;
    @Deprecated
    private final String contentTitle;
    @Deprecated
    private final Uri imageUrl;
    private final String quote;

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareLinkContent, Builder> {
        static final String TAG = Builder.class.getSimpleName();
        @Deprecated
        private String contentDescription;
        @Deprecated
        private String contentTitle;
        @Deprecated
        private Uri imageUrl;
        private String quote;

        static {
            AppMethodBeat.i(97426);
            AppMethodBeat.o(97426);
        }

        @Deprecated
        public final Builder setContentDescription(String str) {
            return this;
        }

        @Deprecated
        public final Builder setContentTitle(String str) {
            return this;
        }

        @Deprecated
        public final Builder setImageUrl(Uri uri) {
            return this;
        }

        public final Builder setQuote(String str) {
            this.quote = str;
            return this;
        }

        public final ShareLinkContent build() {
            AppMethodBeat.i(97421);
            ShareLinkContent shareLinkContent = new ShareLinkContent(this, null);
            AppMethodBeat.o(97421);
            return shareLinkContent;
        }

        public final Builder readFrom(ShareLinkContent shareLinkContent) {
            AppMethodBeat.i(97422);
            if (shareLinkContent == null) {
                AppMethodBeat.o(97422);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
            AppMethodBeat.o(97422);
            return this;
        }
    }

    /* synthetic */ ShareLinkContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareLinkContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97427);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
        this.quote = builder.quote;
        AppMethodBeat.o(97427);
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97428);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
        AppMethodBeat.o(97428);
    }

    @Deprecated
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @Deprecated
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @Deprecated
    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final String getQuote() {
        return this.quote;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97429);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
        AppMethodBeat.o(97429);
    }

    static {
        AppMethodBeat.i(97430);
        AppMethodBeat.o(97430);
    }
}
