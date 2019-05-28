package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface EmojiCaptureUploadManager {

    public static class UploadTask implements Parcelable {
        public static final Creator<UploadTask> CREATOR = new Creator<UploadTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadTask[0];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(57464);
                UploadTask uploadTask = new UploadTask(parcel);
                AppMethodBeat.o(57464);
                return uploadTask;
            }
        };
        public String lgZ;
        public EmojiCaptureReporter lha;

        public UploadTask(String str, EmojiCaptureReporter emojiCaptureReporter) {
            this.lgZ = str;
            this.lha = emojiCaptureReporter;
        }

        public UploadTask(Parcel parcel) {
            AppMethodBeat.i(57465);
            this.lgZ = parcel.readString();
            this.lha = (EmojiCaptureReporter) parcel.readParcelable(EmojiCaptureReporter.class.getClassLoader());
            AppMethodBeat.o(57465);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(57466);
            parcel.writeString(this.lgZ);
            parcel.writeParcelable(this.lha, i);
            AppMethodBeat.o(57466);
        }

        static {
            AppMethodBeat.i(57467);
            AppMethodBeat.o(57467);
        }
    }

    void bjG();
}
