package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoTransPara implements Parcelable {
    public static final Creator<VideoTransPara> CREATOR = new Creator<VideoTransPara>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VideoTransPara[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(117275);
            VideoTransPara videoTransPara = new VideoTransPara(parcel);
            AppMethodBeat.o(117275);
            return videoTransPara;
        }
    };
    public int audioSampleRate;
    public int duration;
    public int fAf = 0;
    public int fps;
    public int fzS;
    public int fzT;
    public int fzU;
    public int fzV;
    public int height;
    public boolean isDefault;
    public int videoBitrate;
    public int width;

    protected VideoTransPara(Parcel parcel) {
        boolean z = false;
        AppMethodBeat.i(117276);
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.fps = parcel.readInt();
        this.videoBitrate = parcel.readInt();
        this.duration = parcel.readInt();
        this.fzT = parcel.readInt();
        this.fzS = parcel.readInt();
        this.audioSampleRate = parcel.readInt();
        this.fzU = parcel.readInt();
        this.fzV = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        }
        this.isDefault = z;
        this.fAf = parcel.readInt();
        AppMethodBeat.o(117276);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(117277);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.fps);
        parcel.writeInt(this.videoBitrate);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.fzT);
        parcel.writeInt(this.fzS);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.fzU);
        parcel.writeInt(this.fzV);
        parcel.writeInt(this.isDefault ? 1 : 0);
        parcel.writeInt(this.fAf);
        AppMethodBeat.o(117277);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(117279);
        AppMethodBeat.o(117279);
    }

    public String toString() {
        AppMethodBeat.i(117278);
        String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.fzT + " audio bitrate " + this.fzS + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.fzU + " preset index " + this.fzV + " thumbSize " + this.fAf + "]";
        AppMethodBeat.o(117278);
        return str;
    }
}
