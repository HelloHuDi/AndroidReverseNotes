package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class GalleryItem {

    public static class AlbumItem implements Parcelable {
        public static final Creator<AlbumItem> CREATOR = new Creator<AlbumItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AlbumItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(21282);
                AlbumItem albumItem = new AlbumItem(parcel);
                AppMethodBeat.o(21282);
                return albumItem;
            }
        };
        public int cyR;
        public String mOh;
        public MediaItem oqq;

        public AlbumItem(String str, int i) {
            AppMethodBeat.i(21283);
            this.mOh = bo.nullAsNil(str);
            this.cyR = i;
            AppMethodBeat.o(21283);
        }

        protected AlbumItem(Parcel parcel) {
            AppMethodBeat.i(21284);
            this.mOh = parcel.readString();
            this.cyR = parcel.readInt();
            this.oqq = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
            AppMethodBeat.o(21284);
        }

        static {
            AppMethodBeat.i(21287);
            AppMethodBeat.o(21287);
        }

        public final String Wy() {
            AppMethodBeat.i(21285);
            if (this.oqq == null) {
                AppMethodBeat.o(21285);
                return null;
            }
            String Wy = this.oqq.Wy();
            AppMethodBeat.o(21285);
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
            AppMethodBeat.i(21286);
            parcel.writeString(this.mOh);
            parcel.writeInt(this.cyR);
            parcel.writeParcelable(this.oqq, i);
            AppMethodBeat.o(21286);
        }
    }

    public static class VideoMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(21292);
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
                AppMethodBeat.o(21292);
                return videoMediaItem;
            }
        };
        public int eXL = -1;
        public String fPU;
        public String fPV;
        public int fPW = -1;
        public int fPX = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        public VideoMediaItem(long j) {
            super(j);
        }

        public VideoMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 2;
        }

        public final String Wy() {
            AppMethodBeat.i(21293);
            String str;
            if (bo.isNullOrNil(this.lZg)) {
                str = this.fPT;
                AppMethodBeat.o(21293);
                return str;
            }
            str = this.lZg;
            AppMethodBeat.o(21293);
            return str;
        }

        static {
            AppMethodBeat.i(21296);
            AppMethodBeat.o(21296);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(21294);
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
            AppMethodBeat.o(21294);
        }

        public String toString() {
            AppMethodBeat.i(21295);
            String str = "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.fPU + '\'' + ", audioTrackMime='" + this.fPV + '\'' + ", durationMs=" + this.fPW + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.fPX + ", videoFrameRate=" + this.videoFrameRate + '}';
            AppMethodBeat.o(21295);
            return str;
        }
    }

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

        public abstract String Wy();

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

        public static MediaItem a(int i, long j, String str, String str2, String str3) {
            if (i == 1) {
                return new ImageMediaItem(j, str, str2, str3);
            }
            return new VideoMediaItem(j, str, str2, str3);
        }

        public static MediaItem N(int i, long j) {
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

    public static class ImageMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(21288);
                ImageMediaItem imageMediaItem = new ImageMediaItem();
                imageMediaItem.fPT = parcel.readString();
                imageMediaItem.lZg = parcel.readString();
                imageMediaItem.mOk = parcel.readLong();
                imageMediaItem.mOl = parcel.readLong();
                imageMediaItem.mMimeType = parcel.readString();
                AppMethodBeat.o(21288);
                return imageMediaItem;
            }
        };

        public ImageMediaItem(long j) {
            super(j);
        }

        public ImageMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 1;
        }

        public final String Wy() {
            AppMethodBeat.i(21289);
            String str;
            if (bo.isNullOrNil(this.lZg)) {
                str = this.fPT;
                AppMethodBeat.o(21289);
                return str;
            }
            str = this.lZg;
            AppMethodBeat.o(21289);
            return str;
        }

        static {
            AppMethodBeat.i(21291);
            AppMethodBeat.o(21291);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(21290);
            parcel.writeString(this.fPT);
            parcel.writeString(this.lZg);
            parcel.writeLong(this.mOk);
            parcel.writeLong(this.mOl);
            parcel.writeString(this.mMimeType);
            AppMethodBeat.o(21290);
        }
    }
}
