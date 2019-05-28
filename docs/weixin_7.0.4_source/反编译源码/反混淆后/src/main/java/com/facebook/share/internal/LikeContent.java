package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeContent implements ShareModel {
    @Deprecated
    public static final Creator<LikeContent> CREATOR = new C86241();
    private final String objectId;
    private final String objectType;

    @Deprecated
    public static class Builder implements ShareModelBuilder<LikeContent, Builder> {
        private String objectId;
        private String objectType;

        @Deprecated
        public Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        @Deprecated
        public Builder setObjectType(String str) {
            this.objectType = str;
            return this;
        }

        @Deprecated
        public LikeContent build() {
            AppMethodBeat.m2504i(97091);
            LikeContent likeContent = new LikeContent(this, null);
            AppMethodBeat.m2505o(97091);
            return likeContent;
        }

        @Deprecated
        public Builder readFrom(LikeContent likeContent) {
            AppMethodBeat.m2504i(97092);
            if (likeContent == null) {
                AppMethodBeat.m2505o(97092);
                return this;
            }
            this = setObjectId(likeContent.getObjectId()).setObjectType(likeContent.getObjectType());
            AppMethodBeat.m2505o(97092);
            return this;
        }
    }

    /* renamed from: com.facebook.share.internal.LikeContent$1 */
    static class C86241 implements Creator<LikeContent> {
        C86241() {
        }

        public final LikeContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97088);
            LikeContent likeContent = new LikeContent(parcel);
            AppMethodBeat.m2505o(97088);
            return likeContent;
        }

        public final LikeContent[] newArray(int i) {
            return new LikeContent[i];
        }
    }

    /* synthetic */ LikeContent(Builder builder, C86241 c86241) {
        this(builder);
    }

    private LikeContent(Builder builder) {
        AppMethodBeat.m2504i(97095);
        this.objectId = builder.objectId;
        this.objectType = builder.objectType;
        AppMethodBeat.m2505o(97095);
    }

    @Deprecated
    LikeContent(Parcel parcel) {
        AppMethodBeat.m2504i(97096);
        this.objectId = parcel.readString();
        this.objectType = parcel.readString();
        AppMethodBeat.m2505o(97096);
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getObjectType() {
        return this.objectType;
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97097);
        parcel.writeString(this.objectId);
        parcel.writeString(this.objectType);
        AppMethodBeat.m2505o(97097);
    }

    static {
        AppMethodBeat.m2504i(97098);
        AppMethodBeat.m2505o(97098);
    }
}
