package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerOpenGraphMusicTemplateContent extends ShareContent<ShareMessengerOpenGraphMusicTemplateContent, Builder> {
    public static final Creator<ShareMessengerOpenGraphMusicTemplateContent> CREATOR = new Creator<ShareMessengerOpenGraphMusicTemplateContent>() {
        public final ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97492);
            ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent = new ShareMessengerOpenGraphMusicTemplateContent(parcel);
            AppMethodBeat.o(97492);
            return shareMessengerOpenGraphMusicTemplateContent;
        }

        public final ShareMessengerOpenGraphMusicTemplateContent[] newArray(int i) {
            return new ShareMessengerOpenGraphMusicTemplateContent[i];
        }
    };
    private final ShareMessengerActionButton button;
    private final Uri url;

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<ShareMessengerOpenGraphMusicTemplateContent, Builder> {
        private ShareMessengerActionButton button;
        private Uri url;

        public Builder setUrl(Uri uri) {
            this.url = uri;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public Builder readFrom(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            AppMethodBeat.i(97495);
            if (shareMessengerOpenGraphMusicTemplateContent == null) {
                AppMethodBeat.o(97495);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareMessengerOpenGraphMusicTemplateContent)).setUrl(shareMessengerOpenGraphMusicTemplateContent.getUrl()).setButton(shareMessengerOpenGraphMusicTemplateContent.getButton());
            AppMethodBeat.o(97495);
            return this;
        }

        public ShareMessengerOpenGraphMusicTemplateContent build() {
            AppMethodBeat.i(97496);
            ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent = new ShareMessengerOpenGraphMusicTemplateContent(this, null);
            AppMethodBeat.o(97496);
            return shareMessengerOpenGraphMusicTemplateContent;
        }
    }

    /* synthetic */ ShareMessengerOpenGraphMusicTemplateContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareMessengerOpenGraphMusicTemplateContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97500);
        this.url = builder.url;
        this.button = builder.button;
        AppMethodBeat.o(97500);
    }

    ShareMessengerOpenGraphMusicTemplateContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97501);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        AppMethodBeat.o(97501);
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97502);
        parcel.writeParcelable(this.url, i);
        parcel.writeParcelable(this.button, i);
        AppMethodBeat.o(97502);
    }

    static {
        AppMethodBeat.i(97503);
        AppMethodBeat.o(97503);
    }
}
