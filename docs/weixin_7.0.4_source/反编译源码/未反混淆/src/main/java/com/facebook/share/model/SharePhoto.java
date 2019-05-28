package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareMedia.Type;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class SharePhoto extends ShareMedia {
    public static final Creator<SharePhoto> CREATOR = new Creator<SharePhoto>() {
        public final SharePhoto createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97551);
            SharePhoto sharePhoto = new SharePhoto(parcel);
            AppMethodBeat.o(97551);
            return sharePhoto;
        }

        public final SharePhoto[] newArray(int i) {
            return new SharePhoto[i];
        }
    };
    private final Bitmap bitmap;
    private final String caption;
    private final Uri imageUrl;
    private final boolean userGenerated;

    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder<SharePhoto, Builder> {
        private Bitmap bitmap;
        private String caption;
        private Uri imageUrl;
        private boolean userGenerated;

        public final Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public final Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public final Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }

        public final Builder setCaption(String str) {
            this.caption = str;
            return this;
        }

        /* Access modifiers changed, original: final */
        public final Uri getImageUrl() {
            return this.imageUrl;
        }

        /* Access modifiers changed, original: final */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final SharePhoto build() {
            AppMethodBeat.i(97554);
            SharePhoto sharePhoto = new SharePhoto(this, null);
            AppMethodBeat.o(97554);
            return sharePhoto;
        }

        public final Builder readFrom(SharePhoto sharePhoto) {
            AppMethodBeat.i(97555);
            if (sharePhoto == null) {
                AppMethodBeat.o(97555);
                return this;
            }
            this = ((Builder) super.readFrom((ShareMedia) sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
            AppMethodBeat.o(97555);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97556);
            Builder readFrom = readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
            AppMethodBeat.o(97556);
            return readFrom;
        }

        static void writePhotoListTo(Parcel parcel, int i, List<SharePhoto> list) {
            AppMethodBeat.i(97557);
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    shareMediaArr[i3] = (ShareMedia) list.get(i3);
                    i2 = i3 + 1;
                } else {
                    parcel.writeParcelableArray(shareMediaArr, i);
                    AppMethodBeat.o(97557);
                    return;
                }
            }
        }

        static List<SharePhoto> readPhotoListFrom(Parcel parcel) {
            AppMethodBeat.i(97558);
            List<ShareMedia> readListFrom = com.facebook.share.model.ShareMedia.Builder.readListFrom(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : readListFrom) {
                if (shareMedia instanceof SharePhoto) {
                    arrayList.add((SharePhoto) shareMedia);
                }
            }
            AppMethodBeat.o(97558);
            return arrayList;
        }
    }

    /* synthetic */ SharePhoto(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private SharePhoto(Builder builder) {
        super((com.facebook.share.model.ShareMedia.Builder) builder);
        AppMethodBeat.i(97562);
        this.bitmap = builder.bitmap;
        this.imageUrl = builder.imageUrl;
        this.userGenerated = builder.userGenerated;
        this.caption = builder.caption;
        AppMethodBeat.o(97562);
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97563);
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != (byte) 0;
        this.caption = parcel.readString();
        AppMethodBeat.o(97563);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.i(97564);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.imageUrl, 0);
        if (this.userGenerated) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.caption);
        AppMethodBeat.o(97564);
    }

    static {
        AppMethodBeat.i(97565);
        AppMethodBeat.o(97565);
    }

    public final Type getMediaType() {
        return Type.PHOTO;
    }
}
