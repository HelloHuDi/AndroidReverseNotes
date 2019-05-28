package com.tencent.tmassistantsdk.downloadclient;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TMAssistantDownloadTaskInfo implements Parcelable {
    public static final Creator<TMAssistantDownloadTaskInfo> CREATOR = new Creator<TMAssistantDownloadTaskInfo>() {
        public final TMAssistantDownloadTaskInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(75675);
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
            AppMethodBeat.o(75675);
            return tMAssistantDownloadTaskInfo;
        }

        public final TMAssistantDownloadTaskInfo[] newArray(int i) {
            return new TMAssistantDownloadTaskInfo[i];
        }
    };
    public String mContentType;
    public long mReceiveDataLen;
    public String mSavePath;
    public int mState;
    public long mTotalDataLen;
    public String mUrl;

    public TMAssistantDownloadTaskInfo(String str, String str2, int i, long j, long j2, String str3) {
        this.mUrl = str;
        this.mSavePath = str2;
        this.mState = i;
        this.mReceiveDataLen = j;
        this.mTotalDataLen = j2;
        this.mContentType = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(75678);
        if (this.mUrl != null) {
            parcel.writeString(this.mUrl);
        } else {
            parcel.writeString("");
        }
        if (this.mSavePath != null) {
            parcel.writeString(this.mSavePath);
        } else {
            parcel.writeString("");
        }
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mReceiveDataLen);
        parcel.writeLong(this.mTotalDataLen);
        parcel.writeString(this.mContentType);
        AppMethodBeat.o(75678);
    }

    static {
        AppMethodBeat.i(75679);
        AppMethodBeat.o(75679);
    }
}
