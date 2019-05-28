package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {
    public static final Creator<ShareStoryContent> CREATOR = new Creator<ShareStoryContent>() {
        public final ShareStoryContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97582);
            ShareStoryContent shareStoryContent = new ShareStoryContent(parcel);
            AppMethodBeat.o(97582);
            return shareStoryContent;
        }

        public final ShareStoryContent[] newArray(int i) {
            return new ShareStoryContent[i];
        }
    };
    private final String mAttributionLink;
    private final ShareMedia mBackgroundAsset;
    private final List<String> mBackgroundColorList;
    private final SharePhoto mStickerAsset;

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareStoryContent, Builder> {
        static final String TAG = Builder.class.getSimpleName();
        private String mAttributionLink;
        private ShareMedia mBackgroundAsset;
        private List<String> mBackgroundColorList;
        private SharePhoto mStickerAsset;

        static {
            AppMethodBeat.i(97590);
            AppMethodBeat.o(97590);
        }

        public final Builder setBackgroundAsset(ShareMedia shareMedia) {
            this.mBackgroundAsset = shareMedia;
            return this;
        }

        public final Builder setStickerAsset(SharePhoto sharePhoto) {
            this.mStickerAsset = sharePhoto;
            return this;
        }

        public final Builder setBackgroundColorList(List<String> list) {
            this.mBackgroundColorList = list;
            return this;
        }

        public final Builder setAttributionLink(String str) {
            this.mAttributionLink = str;
            return this;
        }

        public final ShareStoryContent build() {
            AppMethodBeat.i(97585);
            ShareStoryContent shareStoryContent = new ShareStoryContent(this, null);
            AppMethodBeat.o(97585);
            return shareStoryContent;
        }

        public final Builder readFrom(ShareStoryContent shareStoryContent) {
            AppMethodBeat.i(97586);
            if (shareStoryContent == null) {
                AppMethodBeat.o(97586);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareStoryContent)).setBackgroundAsset(shareStoryContent.getBackgroundAsset()).setStickerAsset(shareStoryContent.getStickerAsset()).setBackgroundColorList(shareStoryContent.getBackgroundColorList()).setAttributionLink(shareStoryContent.getAttributionLink());
            AppMethodBeat.o(97586);
            return this;
        }
    }

    /* synthetic */ ShareStoryContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareStoryContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97591);
        this.mBackgroundAsset = builder.mBackgroundAsset;
        this.mStickerAsset = builder.mStickerAsset;
        this.mBackgroundColorList = builder.mBackgroundColorList;
        this.mAttributionLink = builder.mAttributionLink;
        AppMethodBeat.o(97591);
    }

    ShareStoryContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97592);
        this.mBackgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.mStickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.mBackgroundColorList = readUnmodifiableStringList(parcel);
        this.mAttributionLink = parcel.readString();
        AppMethodBeat.o(97592);
    }

    public final ShareMedia getBackgroundAsset() {
        return this.mBackgroundAsset;
    }

    public final SharePhoto getStickerAsset() {
        return this.mStickerAsset;
    }

    public final List<String> getBackgroundColorList() {
        AppMethodBeat.i(97593);
        if (this.mBackgroundColorList == null) {
            AppMethodBeat.o(97593);
            return null;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(this.mBackgroundColorList);
        AppMethodBeat.o(97593);
        return unmodifiableList;
    }

    public final String getAttributionLink() {
        return this.mAttributionLink;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97594);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mBackgroundAsset, 0);
        parcel.writeParcelable(this.mStickerAsset, 0);
        parcel.writeStringList(this.mBackgroundColorList);
        parcel.writeString(this.mAttributionLink);
        AppMethodBeat.o(97594);
    }

    static {
        AppMethodBeat.i(97596);
        AppMethodBeat.o(97596);
    }

    private List<String> readUnmodifiableStringList(Parcel parcel) {
        AppMethodBeat.i(97595);
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(97595);
            return null;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(97595);
        return unmodifiableList;
    }
}
