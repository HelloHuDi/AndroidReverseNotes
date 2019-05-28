package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareHashtag implements ShareModel {
    public static final Creator<ShareHashtag> CREATOR = new Creator<ShareHashtag>() {
        public final ShareHashtag createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97406);
            ShareHashtag shareHashtag = new ShareHashtag(parcel);
            AppMethodBeat.o(97406);
            return shareHashtag;
        }

        public final ShareHashtag[] newArray(int i) {
            return new ShareHashtag[i];
        }
    };
    private final String hashtag;

    public static class Builder implements ShareModelBuilder<ShareHashtag, Builder> {
        private String hashtag;

        public Builder setHashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public String getHashtag() {
            return this.hashtag;
        }

        public Builder readFrom(ShareHashtag shareHashtag) {
            AppMethodBeat.i(97409);
            if (shareHashtag == null) {
                AppMethodBeat.o(97409);
                return this;
            }
            this = setHashtag(shareHashtag.getHashtag());
            AppMethodBeat.o(97409);
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97410);
            Builder readFrom = readFrom((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
            AppMethodBeat.o(97410);
            return readFrom;
        }

        public ShareHashtag build() {
            AppMethodBeat.i(97411);
            ShareHashtag shareHashtag = new ShareHashtag(this, null);
            AppMethodBeat.o(97411);
            return shareHashtag;
        }
    }

    /* synthetic */ ShareHashtag(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareHashtag(Builder builder) {
        AppMethodBeat.i(97414);
        this.hashtag = builder.hashtag;
        AppMethodBeat.o(97414);
    }

    ShareHashtag(Parcel parcel) {
        AppMethodBeat.i(97415);
        this.hashtag = parcel.readString();
        AppMethodBeat.o(97415);
    }

    public String getHashtag() {
        return this.hashtag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97416);
        parcel.writeString(this.hashtag);
        AppMethodBeat.o(97416);
    }

    static {
        AppMethodBeat.i(97417);
        AppMethodBeat.o(97417);
    }
}
