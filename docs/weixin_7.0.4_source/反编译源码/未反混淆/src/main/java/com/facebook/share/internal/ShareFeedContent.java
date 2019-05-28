package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    public static final Creator<ShareFeedContent> CREATOR = new Creator<ShareFeedContent>() {
        public final ShareFeedContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97243);
            ShareFeedContent shareFeedContent = new ShareFeedContent(parcel);
            AppMethodBeat.o(97243);
            return shareFeedContent;
        }

        public final ShareFeedContent[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    };
    private final String link;
    private final String linkCaption;
    private final String linkDescription;
    private final String linkName;
    private final String mediaSource;
    private final String picture;
    private final String toId;

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareFeedContent, Builder> {
        private String link;
        private String linkCaption;
        private String linkDescription;
        private String linkName;
        private String mediaSource;
        private String picture;
        private String toId;

        public final Builder setToId(String str) {
            this.toId = str;
            return this;
        }

        public final Builder setLink(String str) {
            this.link = str;
            return this;
        }

        public final Builder setLinkName(String str) {
            this.linkName = str;
            return this;
        }

        public final Builder setLinkCaption(String str) {
            this.linkCaption = str;
            return this;
        }

        public final Builder setLinkDescription(String str) {
            this.linkDescription = str;
            return this;
        }

        public final Builder setPicture(String str) {
            this.picture = str;
            return this;
        }

        public final Builder setMediaSource(String str) {
            this.mediaSource = str;
            return this;
        }

        public final ShareFeedContent build() {
            AppMethodBeat.i(97246);
            ShareFeedContent shareFeedContent = new ShareFeedContent(this, null);
            AppMethodBeat.o(97246);
            return shareFeedContent;
        }

        public final Builder readFrom(ShareFeedContent shareFeedContent) {
            AppMethodBeat.i(97247);
            if (shareFeedContent == null) {
                AppMethodBeat.o(97247);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
            AppMethodBeat.o(97247);
            return this;
        }
    }

    /* synthetic */ ShareFeedContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareFeedContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97251);
        this.toId = builder.toId;
        this.link = builder.link;
        this.linkName = builder.linkName;
        this.linkCaption = builder.linkCaption;
        this.linkDescription = builder.linkDescription;
        this.picture = builder.picture;
        this.mediaSource = builder.mediaSource;
        AppMethodBeat.o(97251);
    }

    ShareFeedContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97252);
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
        AppMethodBeat.o(97252);
    }

    public String getToId() {
        return this.toId;
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public String getLinkCaption() {
        return this.linkCaption;
    }

    public String getLinkDescription() {
        return this.linkDescription;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getMediaSource() {
        return this.mediaSource;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97253);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.toId);
        parcel.writeString(this.link);
        parcel.writeString(this.linkName);
        parcel.writeString(this.linkCaption);
        parcel.writeString(this.linkDescription);
        parcel.writeString(this.picture);
        parcel.writeString(this.mediaSource);
        AppMethodBeat.o(97253);
    }

    static {
        AppMethodBeat.i(97254);
        AppMethodBeat.o(97254);
    }
}
