package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Creator<ChapterFrame> CREATOR = new Creator<ChapterFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ChapterFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95286);
            ChapterFrame chapterFrame = new ChapterFrame(parcel);
            AppMethodBeat.o(95286);
            return chapterFrame;
        }
    };
    public final String bfm;
    public final int bfn;
    public final int bfo;
    public final long bfp;
    public final long bfq;
    private final Id3Frame[] bfr;

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.bfm = str;
        this.bfn = i;
        this.bfo = i2;
        this.bfp = j;
        this.bfq = j2;
        this.bfr = id3FrameArr;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        AppMethodBeat.i(95287);
        this.bfm = parcel.readString();
        this.bfn = parcel.readInt();
        this.bfo = parcel.readInt();
        this.bfp = parcel.readLong();
        this.bfq = parcel.readLong();
        int readInt = parcel.readInt();
        this.bfr = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.bfr[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
        AppMethodBeat.o(95287);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95288);
        if (this == obj) {
            AppMethodBeat.o(95288);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95288);
            return false;
        } else {
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            if (this.bfn == chapterFrame.bfn && this.bfo == chapterFrame.bfo && this.bfp == chapterFrame.bfp && this.bfq == chapterFrame.bfq && v.j(this.bfm, chapterFrame.bfm) && Arrays.equals(this.bfr, chapterFrame.bfr)) {
                AppMethodBeat.o(95288);
                return true;
            }
            AppMethodBeat.o(95288);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(95289);
        int hashCode = (this.bfm != null ? this.bfm.hashCode() : 0) + ((((((((this.bfn + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.bfo) * 31) + ((int) this.bfp)) * 31) + ((int) this.bfq)) * 31);
        AppMethodBeat.o(95289);
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95290);
        parcel.writeString(this.bfm);
        parcel.writeInt(this.bfn);
        parcel.writeInt(this.bfo);
        parcel.writeLong(this.bfp);
        parcel.writeLong(this.bfq);
        parcel.writeInt(this.bfr.length);
        for (Parcelable writeParcelable : this.bfr) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        AppMethodBeat.o(95290);
    }

    public final int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(95291);
        AppMethodBeat.o(95291);
    }
}
