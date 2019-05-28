package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Creator<ChapterTocFrame> CREATOR = new C176811();
    public final boolean baT;
    private final Id3Frame[] bfr;
    public final String bfs;
    public final boolean bft;
    public final String[] bfu;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.ChapterTocFrame$1 */
    static class C176811 implements Creator<ChapterTocFrame> {
        C176811() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ChapterTocFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95292);
            ChapterTocFrame chapterTocFrame = new ChapterTocFrame(parcel);
            AppMethodBeat.m2505o(95292);
            return chapterTocFrame;
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.bfs = str;
        this.bft = z;
        this.baT = z2;
        this.bfu = strArr;
        this.bfr = id3FrameArr;
    }

    ChapterTocFrame(Parcel parcel) {
        boolean z = true;
        int i = 0;
        super("CTOC");
        AppMethodBeat.m2504i(95293);
        this.bfs = parcel.readString();
        this.bft = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.baT = z;
        this.bfu = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.bfr = new Id3Frame[readInt];
        while (i < readInt) {
            this.bfr[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
            i++;
        }
        AppMethodBeat.m2505o(95293);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95294);
        if (this == obj) {
            AppMethodBeat.m2505o(95294);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95294);
            return false;
        } else {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            if (this.bft == chapterTocFrame.bft && this.baT == chapterTocFrame.baT && C17675v.m27574j(this.bfs, chapterTocFrame.bfs) && Arrays.equals(this.bfu, chapterTocFrame.bfu) && Arrays.equals(this.bfr, chapterTocFrame.bfr)) {
                AppMethodBeat.m2505o(95294);
                return true;
            }
            AppMethodBeat.m2505o(95294);
            return false;
        }
    }

    public final int hashCode() {
        int i;
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.m2504i(95295);
        if (this.bft) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        if (!this.baT) {
            i2 = 0;
        }
        i = (i + i2) * 31;
        if (this.bfs != null) {
            i3 = this.bfs.hashCode();
        }
        i += i3;
        AppMethodBeat.m2505o(95295);
        return i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(95296);
        parcel.writeString(this.bfs);
        if (this.bft) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.baT) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeStringArray(this.bfu);
        parcel.writeInt(this.bfr.length);
        for (Parcelable writeParcelable : this.bfr) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        AppMethodBeat.m2505o(95296);
    }

    static {
        AppMethodBeat.m2504i(95297);
        AppMethodBeat.m2505o(95297);
    }
}
