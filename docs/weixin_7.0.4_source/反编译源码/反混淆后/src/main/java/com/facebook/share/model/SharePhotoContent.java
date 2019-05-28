package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Creator<SharePhotoContent> CREATOR = new C320141();
    private final List<SharePhoto> photos;

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<SharePhotoContent, Builder> {
        private final List<SharePhoto> photos = new ArrayList();

        public Builder() {
            AppMethodBeat.m2504i(97569);
            AppMethodBeat.m2505o(97569);
        }

        public Builder addPhoto(SharePhoto sharePhoto) {
            AppMethodBeat.m2504i(97570);
            if (sharePhoto != null) {
                this.photos.add(new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            AppMethodBeat.m2505o(97570);
            return this;
        }

        public Builder addPhotos(List<SharePhoto> list) {
            AppMethodBeat.m2504i(97571);
            if (list != null) {
                for (SharePhoto addPhoto : list) {
                    addPhoto(addPhoto);
                }
            }
            AppMethodBeat.m2505o(97571);
            return this;
        }

        public SharePhotoContent build() {
            AppMethodBeat.m2504i(97572);
            SharePhotoContent sharePhotoContent = new SharePhotoContent(this, null);
            AppMethodBeat.m2505o(97572);
            return sharePhotoContent;
        }

        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            AppMethodBeat.m2504i(97573);
            if (sharePhotoContent == null) {
                AppMethodBeat.m2505o(97573);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
            AppMethodBeat.m2505o(97573);
            return this;
        }

        public Builder setPhotos(List<SharePhoto> list) {
            AppMethodBeat.m2504i(97574);
            this.photos.clear();
            addPhotos(list);
            AppMethodBeat.m2505o(97574);
            return this;
        }
    }

    /* renamed from: com.facebook.share.model.SharePhotoContent$1 */
    static class C320141 implements Creator<SharePhotoContent> {
        C320141() {
        }

        public final SharePhotoContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97566);
            SharePhotoContent sharePhotoContent = new SharePhotoContent(parcel);
            AppMethodBeat.m2505o(97566);
            return sharePhotoContent;
        }

        public final SharePhotoContent[] newArray(int i) {
            return new SharePhotoContent[i];
        }
    }

    /* synthetic */ SharePhotoContent(Builder builder, C320141 c320141) {
        this(builder);
    }

    private SharePhotoContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.m2504i(97578);
        this.photos = Collections.unmodifiableList(builder.photos);
        AppMethodBeat.m2505o(97578);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(97579);
        this.photos = Collections.unmodifiableList(com.facebook.share.model.SharePhoto.Builder.readPhotoListFrom(parcel));
        AppMethodBeat.m2505o(97579);
    }

    public final List<SharePhoto> getPhotos() {
        return this.photos;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97580);
        super.writeToParcel(parcel, i);
        com.facebook.share.model.SharePhoto.Builder.writePhotoListTo(parcel, i, this.photos);
        AppMethodBeat.m2505o(97580);
    }

    static {
        AppMethodBeat.m2504i(97581);
        AppMethodBeat.m2505o(97581);
    }
}
