package com.tencent.p177mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager */
public interface EmojiCaptureUploadManager {

    /* renamed from: com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager$UploadTask */
    public static class UploadTask implements Parcelable {
        public static final Creator<UploadTask> CREATOR = new C277891();
        public String lgZ;
        public EmojiCaptureReporter lha;

        /* renamed from: com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager$UploadTask$1 */
        static class C277891 implements Creator<UploadTask> {
            C277891() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadTask[0];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(57464);
                UploadTask uploadTask = new UploadTask(parcel);
                AppMethodBeat.m2505o(57464);
                return uploadTask;
            }
        }

        public UploadTask(String str, EmojiCaptureReporter emojiCaptureReporter) {
            this.lgZ = str;
            this.lha = emojiCaptureReporter;
        }

        public UploadTask(Parcel parcel) {
            AppMethodBeat.m2504i(57465);
            this.lgZ = parcel.readString();
            this.lha = (EmojiCaptureReporter) parcel.readParcelable(EmojiCaptureReporter.class.getClassLoader());
            AppMethodBeat.m2505o(57465);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(57466);
            parcel.writeString(this.lgZ);
            parcel.writeParcelable(this.lha, i);
            AppMethodBeat.m2505o(57466);
        }

        static {
            AppMethodBeat.m2504i(57467);
            AppMethodBeat.m2505o(57467);
        }
    }

    void bjG();
}
