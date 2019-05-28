package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Creator<SharePhotoContent> CREATOR = new Creator<SharePhotoContent>() {
        public final SharePhotoContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97566);
            SharePhotoContent sharePhotoContent = new SharePhotoContent(parcel);
            AppMethodBeat.o(97566);
            return sharePhotoContent;
        }

        public final SharePhotoContent[] newArray(int i) {
            return new SharePhotoContent[i];
        }
    };
    private final List<SharePhoto> photos;

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<SharePhotoContent, Builder> {
        private final List<SharePhoto> photos = new ArrayList();

        public Builder() {
            AppMethodBeat.i(97569);
            AppMethodBeat.o(97569);
        }

        public Builder addPhoto(SharePhoto sharePhoto) {
            AppMethodBeat.i(97570);
            if (sharePhoto != null) {
                this.photos.add(new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            AppMethodBeat.o(97570);
            return this;
        }

        public Builder addPhotos(List<SharePhoto> list) {
            AppMethodBeat.i(97571);
            if (list != null) {
                for (SharePhoto addPhoto : list) {
                    addPhoto(addPhoto);
                }
            }
            AppMethodBeat.o(97571);
            return this;
        }

        public SharePhotoContent build() {
            AppMethodBeat.i(97572);
            SharePhotoContent sharePhotoContent = new SharePhotoContent(this, null);
            AppMethodBeat.o(97572);
            return sharePhotoContent;
        }

        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            AppMethodBeat.i(97573);
            if (sharePhotoContent == null) {
                AppMethodBeat.o(97573);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
            AppMethodBeat.o(97573);
            return this;
        }

        public Builder setPhotos(List<SharePhoto> list) {
            AppMethodBeat.i(97574);
            this.photos.clear();
            addPhotos(list);
            AppMethodBeat.o(97574);
            return this;
        }
    }

    /* synthetic */ SharePhotoContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private SharePhotoContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97578);
        this.photos = Collections.unmodifiableList(builder.photos);
        AppMethodBeat.o(97578);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97579);
        this.photos = Collections.unmodifiableList(com.facebook.share.model.SharePhoto.Builder.readPhotoListFrom(parcel));
        AppMethodBeat.o(97579);
    }

    public final List<SharePhoto> getPhotos() {
        return this.photos;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97580);
        super.writeToParcel(parcel, i);
        com.facebook.share.model.SharePhoto.Builder.writePhotoListTo(parcel, i, this.photos);
        AppMethodBeat.o(97580);
    }

    static {
        AppMethodBeat.i(97581);
        AppMethodBeat.o(97581);
    }
}
