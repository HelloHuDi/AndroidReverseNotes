package com.tencent.p177mm.choosemsgfile.compat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.choosemsgfile.compat.MsgFile */
public class MsgFile implements Parcelable {
    public static final Creator<MsgFile> CREATOR = new C92351();
    public String eov;
    public String fileName;
    public String filePath;
    public int fileSize;
    public long timeStamp;
    public String type;

    /* renamed from: com.tencent.mm.choosemsgfile.compat.MsgFile$1 */
    static class C92351 implements Creator<MsgFile> {
        C92351() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MsgFile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(125783);
            MsgFile msgFile = new MsgFile(parcel);
            AppMethodBeat.m2505o(125783);
            return msgFile;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(125784);
        String str = "MsgFile{fileSize=" + this.fileSize + ", filePath='" + this.filePath + '\'' + ", fileName='" + this.fileName + '\'' + ", timeStamp=" + this.timeStamp + ", type='" + this.type + '\'' + ", fileExt='" + this.eov + '\'' + '}';
        AppMethodBeat.m2505o(125784);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(125785);
        parcel.writeInt(this.fileSize);
        parcel.writeString(this.filePath);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.timeStamp);
        parcel.writeString(this.type);
        parcel.writeString(this.eov);
        AppMethodBeat.m2505o(125785);
    }

    protected MsgFile(Parcel parcel) {
        AppMethodBeat.m2504i(125786);
        this.fileSize = parcel.readInt();
        this.filePath = parcel.readString();
        this.fileName = parcel.readString();
        this.timeStamp = parcel.readLong();
        this.type = parcel.readString();
        this.eov = parcel.readString();
        AppMethodBeat.m2505o(125786);
    }

    static {
        AppMethodBeat.m2504i(125787);
        AppMethodBeat.m2505o(125787);
    }
}
