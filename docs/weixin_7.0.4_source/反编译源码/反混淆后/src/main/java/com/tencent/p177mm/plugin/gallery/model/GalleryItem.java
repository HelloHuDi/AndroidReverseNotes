package com.tencent.p177mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem */
public final class GalleryItem {

    /* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem$AlbumItem */
    public static class AlbumItem implements Parcelable {
        public static final Creator<AlbumItem> CREATOR = new C32061();
        public int cyR;
        public String mOh;
        public MediaItem oqq;

        /* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem$AlbumItem$1 */
        static class C32061 implements Creator<AlbumItem> {
            C32061() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AlbumItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(21282);
                AlbumItem albumItem = new AlbumItem(parcel);
                AppMethodBeat.m2505o(21282);
                return albumItem;
            }
        }

        public AlbumItem(String str, int i) {
            AppMethodBeat.m2504i(21283);
            this.mOh = C5046bo.nullAsNil(str);
            this.cyR = i;
            AppMethodBeat.m2505o(21283);
        }

        protected AlbumItem(Parcel parcel) {
            AppMethodBeat.m2504i(21284);
            this.mOh = parcel.readString();
            this.cyR = parcel.readInt();
            this.oqq = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
            AppMethodBeat.m2505o(21284);
        }

        static {
            AppMethodBeat.m2504i(21287);
            AppMethodBeat.m2505o(21287);
        }

        /* renamed from: Wy */
        public final String mo7500Wy() {
            AppMethodBeat.m2504i(21285);
            if (this.oqq == null) {
                AppMethodBeat.m2505o(21285);
                return null;
            }
            String Wy = this.oqq.mo7504Wy();
            AppMethodBeat.m2505o(21285);
            return Wy;
        }

        public final long aQI() {
            if (this.oqq == null) {
                return -1;
            }
            return this.oqq.mOk;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(21286);
            parcel.writeString(this.mOh);
            parcel.writeInt(this.cyR);
            parcel.writeParcelable(this.oqq, i);
            AppMethodBeat.m2505o(21286);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem$VideoMediaItem */
    public static class VideoMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new C32071();
        public int eXL = -1;
        public String fPU;
        public String fPV;
        public int fPW = -1;
        public int fPX = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        /* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem$VideoMediaItem$1 */
        static class C32071 implements Creator<MediaItem> {
            C32071() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(21292);
                VideoMediaItem videoMediaItem = new VideoMediaItem();
                videoMediaItem.fPT = parcel.readString();
                videoMediaItem.lZg = parcel.readString();
                videoMediaItem.mOk = parcel.readLong();
                videoMediaItem.mMimeType = parcel.readString();
                videoMediaItem.videoWidth = parcel.readInt();
                videoMediaItem.videoHeight = parcel.readInt();
                videoMediaItem.fPW = parcel.readInt();
                videoMediaItem.fPU = parcel.readString();
                videoMediaItem.fPV = parcel.readString();
                videoMediaItem.fPX = parcel.readInt();
                videoMediaItem.videoFrameRate = parcel.readInt();
                videoMediaItem.videoBitRate = parcel.readInt();
                videoMediaItem.eXL = parcel.readInt();
                AppMethodBeat.m2505o(21292);
                return videoMediaItem;
            }
        }

        public VideoMediaItem(long j) {
            super(j);
        }

        public VideoMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 2;
        }

        /* renamed from: Wy */
        public final String mo7504Wy() {
            AppMethodBeat.m2504i(21293);
            String str;
            if (C5046bo.isNullOrNil(this.lZg)) {
                str = this.fPT;
                AppMethodBeat.m2505o(21293);
                return str;
            }
            str = this.lZg;
            AppMethodBeat.m2505o(21293);
            return str;
        }

        static {
            AppMethodBeat.m2504i(21296);
            AppMethodBeat.m2505o(21296);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(21294);
            parcel.writeString(this.fPT);
            parcel.writeString(this.lZg);
            parcel.writeLong(this.mOk);
            parcel.writeString(this.mMimeType);
            parcel.writeInt(this.videoWidth);
            parcel.writeInt(this.videoHeight);
            parcel.writeInt(this.fPW);
            parcel.writeString(this.fPU);
            parcel.writeString(this.fPV);
            parcel.writeInt(this.fPX);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.videoBitRate);
            parcel.writeInt(this.eXL);
            AppMethodBeat.m2505o(21294);
        }

        public String toString() {
            AppMethodBeat.m2504i(21295);
            String str = "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.fPU + '\'' + ", audioTrackMime='" + this.fPV + '\'' + ", durationMs=" + this.fPW + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.fPX + ", videoFrameRate=" + this.videoFrameRate + '}';
            AppMethodBeat.m2505o(21295);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem */
    public static abstract class MediaItem implements Parcelable, Comparable<MediaItem> {
        public double bDG;
        public double bDH;
        public String fPT;
        public String lZg;
        public String mMimeType;
        public String mOi;
        public String mOj;
        public long mOk;
        public long mOl;
        public long mOm;
        public String mOn;

        /* renamed from: Wy */
        public abstract String mo7504Wy();

        public abstract int getType();

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) ((this.mOl - ((MediaItem) obj).mOl) / 1000);
        }

        public MediaItem() {
            this(0, "", "", "");
        }

        public MediaItem(long j) {
            this(j, "", "", "");
        }

        public MediaItem(long j, String str, String str2, String str3) {
            this.bDH = 91.0d;
            this.bDG = 181.0d;
            this.mOk = j;
            this.fPT = str;
            this.lZg = str2;
            this.mMimeType = str3;
        }

        /* renamed from: a */
        public static MediaItem m5515a(int i, long j, String str, String str2, String str3) {
            if (i == 1) {
                return new ImageMediaItem(j, str, str2, str3);
            }
            return new VideoMediaItem(j, str, str2, str3);
        }

        /* renamed from: N */
        public static MediaItem m5514N(int i, long j) {
            if (i == 1) {
                return new ImageMediaItem(j);
            }
            return new VideoMediaItem(j);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof MediaItem)) {
                return false;
            }
            MediaItem mediaItem = (MediaItem) obj;
            if (this.fPT == null || !this.fPT.equals(mediaItem.fPT)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "MediaItem{mOrignalPath='" + this.fPT + '\'' + ", mThumbPath='" + this.lZg + '\'' + ", origId=" + this.mOk + ", generateDate=" + this.mOl + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.bDH + '\'' + ", mLatitude='" + this.bDG + '\'' + ", mBusinessTag='" + this.mOn + '\'' + '}';
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem$ImageMediaItem */
    public static class ImageMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new C32081();

        /* renamed from: com.tencent.mm.plugin.gallery.model.GalleryItem$ImageMediaItem$1 */
        static class C32081 implements Creator<MediaItem> {
            C32081() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(21288);
                ImageMediaItem imageMediaItem = new ImageMediaItem();
                imageMediaItem.fPT = parcel.readString();
                imageMediaItem.lZg = parcel.readString();
                imageMediaItem.mOk = parcel.readLong();
                imageMediaItem.mOl = parcel.readLong();
                imageMediaItem.mMimeType = parcel.readString();
                AppMethodBeat.m2505o(21288);
                return imageMediaItem;
            }
        }

        public ImageMediaItem(long j) {
            super(j);
        }

        public ImageMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 1;
        }

        /* renamed from: Wy */
        public final String mo7504Wy() {
            AppMethodBeat.m2504i(21289);
            String str;
            if (C5046bo.isNullOrNil(this.lZg)) {
                str = this.fPT;
                AppMethodBeat.m2505o(21289);
                return str;
            }
            str = this.lZg;
            AppMethodBeat.m2505o(21289);
            return str;
        }

        static {
            AppMethodBeat.m2504i(21291);
            AppMethodBeat.m2505o(21291);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(21290);
            parcel.writeString(this.fPT);
            parcel.writeString(this.lZg);
            parcel.writeLong(this.mOk);
            parcel.writeLong(this.mOl);
            parcel.writeString(this.mMimeType);
            AppMethodBeat.m2505o(21290);
        }
    }
}
