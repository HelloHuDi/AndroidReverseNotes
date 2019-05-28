package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Creator<ShareMediaContent> CREATOR = new Creator<ShareMediaContent>() {
        public final ShareMediaContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97434);
            ShareMediaContent shareMediaContent = new ShareMediaContent(parcel);
            AppMethodBeat.o(97434);
            return shareMediaContent;
        }

        public final ShareMediaContent[] newArray(int i) {
            return new ShareMediaContent[i];
        }
    };
    private final List<ShareMedia> media;

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia> media = new ArrayList();

        public Builder() {
            AppMethodBeat.i(97437);
            AppMethodBeat.o(97437);
        }

        public Builder addMedium(ShareMedia shareMedia) {
            AppMethodBeat.i(97438);
            if (shareMedia != null) {
                Object build;
                if (shareMedia instanceof SharePhoto) {
                    build = new com.facebook.share.model.SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    build = new com.facebook.share.model.ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                    AppMethodBeat.o(97438);
                    throw illegalArgumentException;
                }
                this.media.add(build);
            }
            AppMethodBeat.o(97438);
            return this;
        }

        public Builder addMedia(List<ShareMedia> list) {
            AppMethodBeat.i(97439);
            if (list != null) {
                for (ShareMedia addMedium : list) {
                    addMedium(addMedium);
                }
            }
            AppMethodBeat.o(97439);
            return this;
        }

        public ShareMediaContent build() {
            AppMethodBeat.i(97440);
            ShareMediaContent shareMediaContent = new ShareMediaContent(this, null);
            AppMethodBeat.o(97440);
            return shareMediaContent;
        }

        public Builder readFrom(ShareMediaContent shareMediaContent) {
            AppMethodBeat.i(97441);
            if (shareMediaContent == null) {
                AppMethodBeat.o(97441);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareMediaContent)).addMedia(shareMediaContent.getMedia());
            AppMethodBeat.o(97441);
            return this;
        }

        public Builder setMedia(List<ShareMedia> list) {
            AppMethodBeat.i(97442);
            this.media.clear();
            addMedia(list);
            AppMethodBeat.o(97442);
            return this;
        }
    }

    /* synthetic */ ShareMediaContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareMediaContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.i(97446);
        this.media = Collections.unmodifiableList(builder.media);
        AppMethodBeat.o(97446);
    }

    ShareMediaContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(97447);
        this.media = Arrays.asList((ShareMedia[]) parcel.readParcelableArray(ShareMedia.class.getClassLoader()));
        AppMethodBeat.o(97447);
    }

    public final List<ShareMedia> getMedia() {
        return this.media;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97448);
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((ShareMedia[]) this.media.toArray(), i);
        AppMethodBeat.o(97448);
    }

    static {
        AppMethodBeat.i(97449);
        AppMethodBeat.o(97449);
    }
}
