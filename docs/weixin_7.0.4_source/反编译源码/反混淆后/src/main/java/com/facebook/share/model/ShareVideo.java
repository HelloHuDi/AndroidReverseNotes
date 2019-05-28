package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareMedia.Type;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideo extends ShareMedia {
    public static final Creator<ShareVideo> CREATOR = new C320151();
    private final Uri localUrl;

    /* renamed from: com.facebook.share.model.ShareVideo$1 */
    static class C320151 implements Creator<ShareVideo> {
        C320151() {
        }

        public final ShareVideo createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97597);
            ShareVideo shareVideo = new ShareVideo(parcel);
            AppMethodBeat.m2505o(97597);
            return shareVideo;
        }

        public final ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder<ShareVideo, Builder> {
        private Uri localUrl;

        public final Builder setLocalUrl(Uri uri) {
            this.localUrl = uri;
            return this;
        }

        public final ShareVideo build() {
            AppMethodBeat.m2504i(97600);
            ShareVideo shareVideo = new ShareVideo(this, null);
            AppMethodBeat.m2505o(97600);
            return shareVideo;
        }

        public final Builder readFrom(ShareVideo shareVideo) {
            AppMethodBeat.m2504i(97601);
            if (shareVideo == null) {
                AppMethodBeat.m2505o(97601);
                return this;
            }
            this = ((Builder) super.readFrom((ShareMedia) shareVideo)).setLocalUrl(shareVideo.getLocalUrl());
            AppMethodBeat.m2505o(97601);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.m2504i(97602);
            Builder readFrom = readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
            AppMethodBeat.m2505o(97602);
            return readFrom;
        }
    }

    /* synthetic */ ShareVideo(Builder builder, C320151 c320151) {
        this(builder);
    }

    private ShareVideo(Builder builder) {
        super((com.facebook.share.model.ShareMedia.Builder) builder);
        AppMethodBeat.m2504i(97606);
        this.localUrl = builder.localUrl;
        AppMethodBeat.m2505o(97606);
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(97607);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        AppMethodBeat.m2505o(97607);
    }

    public final Uri getLocalUrl() {
        return this.localUrl;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97608);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
        AppMethodBeat.m2505o(97608);
    }

    static {
        AppMethodBeat.m2504i(97609);
        AppMethodBeat.m2505o(97609);
    }

    public final Type getMediaType() {
        return Type.VIDEO;
    }
}
