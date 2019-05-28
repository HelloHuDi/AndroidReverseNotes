package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareMedia.Type;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideo extends ShareMedia {
    public static final Creator<ShareVideo> CREATOR = new Creator<ShareVideo>() {
        public final ShareVideo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97597);
            ShareVideo shareVideo = new ShareVideo(parcel);
            AppMethodBeat.o(97597);
            return shareVideo;
        }

        public final ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    };
    private final Uri localUrl;

    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder<ShareVideo, Builder> {
        private Uri localUrl;

        public final Builder setLocalUrl(Uri uri) {
            this.localUrl = uri;
            return this;
        }

        public final ShareVideo build() {
            AppMethodBeat.i(97600);
            ShareVideo shareVideo = new ShareVideo(this, null);
            AppMethodBeat.o(97600);
            return shareVideo;
        }

        public final Builder readFrom(ShareVideo shareVideo) {
            AppMethodBeat.i(97601);
            if (shareVideo == null) {
                AppMethodBeat.o(97601);
                return this;
            }
            this = ((Builder) super.readFrom((ShareMedia) shareVideo)).setLocalUrl(shareVideo.getLocalUrl());
            AppMethodBeat.o(97601);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97602);
            Builder readFrom = readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
            AppMethodBeat.o(97602);
            return readFrom;
        }
    }

    /* synthetic */ ShareVideo(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareVideo(Builder builder) {
        super((com.facebook.share.model.ShareMedia.Builder) builder);
        AppMethodBeat.i(97606);
        this.localUrl = builder.localUrl;
        AppMethodBeat.o(97606);
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97607);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        AppMethodBeat.o(97607);
    }

    public final Uri getLocalUrl() {
        return this.localUrl;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97608);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
        AppMethodBeat.o(97608);
    }

    static {
        AppMethodBeat.i(97609);
        AppMethodBeat.o(97609);
    }

    public final Type getMediaType() {
        return Type.VIDEO;
    }
}
