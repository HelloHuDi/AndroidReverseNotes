package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Creator<ShareMediaContent> CREATOR = new C415891();
    private final List<ShareMedia> media;

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia> media = new ArrayList();

        public Builder() {
            AppMethodBeat.m2504i(97437);
            AppMethodBeat.m2505o(97437);
        }

        public Builder addMedium(ShareMedia shareMedia) {
            AppMethodBeat.m2504i(97438);
            if (shareMedia != null) {
                Object build;
                if (shareMedia instanceof SharePhoto) {
                    build = new com.facebook.share.model.SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    build = new com.facebook.share.model.ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                    AppMethodBeat.m2505o(97438);
                    throw illegalArgumentException;
                }
                this.media.add(build);
            }
            AppMethodBeat.m2505o(97438);
            return this;
        }

        public Builder addMedia(List<ShareMedia> list) {
            AppMethodBeat.m2504i(97439);
            if (list != null) {
                for (ShareMedia addMedium : list) {
                    addMedium(addMedium);
                }
            }
            AppMethodBeat.m2505o(97439);
            return this;
        }

        public ShareMediaContent build() {
            AppMethodBeat.m2504i(97440);
            ShareMediaContent shareMediaContent = new ShareMediaContent(this, null);
            AppMethodBeat.m2505o(97440);
            return shareMediaContent;
        }

        public Builder readFrom(ShareMediaContent shareMediaContent) {
            AppMethodBeat.m2504i(97441);
            if (shareMediaContent == null) {
                AppMethodBeat.m2505o(97441);
                return this;
            }
            this = ((Builder) super.readFrom((ShareContent) shareMediaContent)).addMedia(shareMediaContent.getMedia());
            AppMethodBeat.m2505o(97441);
            return this;
        }

        public Builder setMedia(List<ShareMedia> list) {
            AppMethodBeat.m2504i(97442);
            this.media.clear();
            addMedia(list);
            AppMethodBeat.m2505o(97442);
            return this;
        }
    }

    /* renamed from: com.facebook.share.model.ShareMediaContent$1 */
    static class C415891 implements Creator<ShareMediaContent> {
        C415891() {
        }

        public final ShareMediaContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97434);
            ShareMediaContent shareMediaContent = new ShareMediaContent(parcel);
            AppMethodBeat.m2505o(97434);
            return shareMediaContent;
        }

        public final ShareMediaContent[] newArray(int i) {
            return new ShareMediaContent[i];
        }
    }

    /* synthetic */ ShareMediaContent(Builder builder, C415891 c415891) {
        this(builder);
    }

    private ShareMediaContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        AppMethodBeat.m2504i(97446);
        this.media = Collections.unmodifiableList(builder.media);
        AppMethodBeat.m2505o(97446);
    }

    ShareMediaContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(97447);
        this.media = Arrays.asList((ShareMedia[]) parcel.readParcelableArray(ShareMedia.class.getClassLoader()));
        AppMethodBeat.m2505o(97447);
    }

    public final List<ShareMedia> getMedia() {
        return this.media;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97448);
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((ShareMedia[]) this.media.toArray(), i);
        AppMethodBeat.m2505o(97448);
    }

    static {
        AppMethodBeat.m2504i(97449);
        AppMethodBeat.m2505o(97449);
    }
}
