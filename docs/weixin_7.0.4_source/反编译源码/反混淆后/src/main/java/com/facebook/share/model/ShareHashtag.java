package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareHashtag implements ShareModel {
    public static final Creator<ShareHashtag> CREATOR = new C176211();
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
            AppMethodBeat.m2504i(97409);
            if (shareHashtag == null) {
                AppMethodBeat.m2505o(97409);
                return this;
            }
            this = setHashtag(shareHashtag.getHashtag());
            AppMethodBeat.m2505o(97409);
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.m2504i(97410);
            Builder readFrom = readFrom((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
            AppMethodBeat.m2505o(97410);
            return readFrom;
        }

        public ShareHashtag build() {
            AppMethodBeat.m2504i(97411);
            ShareHashtag shareHashtag = new ShareHashtag(this, null);
            AppMethodBeat.m2505o(97411);
            return shareHashtag;
        }
    }

    /* renamed from: com.facebook.share.model.ShareHashtag$1 */
    static class C176211 implements Creator<ShareHashtag> {
        C176211() {
        }

        public final ShareHashtag createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97406);
            ShareHashtag shareHashtag = new ShareHashtag(parcel);
            AppMethodBeat.m2505o(97406);
            return shareHashtag;
        }

        public final ShareHashtag[] newArray(int i) {
            return new ShareHashtag[i];
        }
    }

    /* synthetic */ ShareHashtag(Builder builder, C176211 c176211) {
        this(builder);
    }

    private ShareHashtag(Builder builder) {
        AppMethodBeat.m2504i(97414);
        this.hashtag = builder.hashtag;
        AppMethodBeat.m2505o(97414);
    }

    ShareHashtag(Parcel parcel) {
        AppMethodBeat.m2504i(97415);
        this.hashtag = parcel.readString();
        AppMethodBeat.m2505o(97415);
    }

    public String getHashtag() {
        return this.hashtag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97416);
        parcel.writeString(this.hashtag);
        AppMethodBeat.m2505o(97416);
    }

    static {
        AppMethodBeat.m2504i(97417);
        AppMethodBeat.m2505o(97417);
    }
}
