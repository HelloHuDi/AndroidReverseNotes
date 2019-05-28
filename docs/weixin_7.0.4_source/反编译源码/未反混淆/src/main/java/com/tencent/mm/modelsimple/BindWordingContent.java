package com.tencent.mm.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BindWordingContent implements Parcelable {
    public static final Creator<BindWordingContent> CREATOR = new Creator<BindWordingContent>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BindWordingContent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(123424);
            BindWordingContent bindWordingContent = new BindWordingContent(parcel);
            AppMethodBeat.o(123424);
            return bindWordingContent;
        }
    };
    public Integer bWu = Integer.valueOf(0);
    public String content = "";
    public String title = "";

    public BindWordingContent(String str, String str2) {
        AppMethodBeat.i(123425);
        this.title = str;
        this.content = str2;
        AppMethodBeat.o(123425);
    }

    public BindWordingContent(Parcel parcel) {
        AppMethodBeat.i(123426);
        String[] strArr = new String[2];
        parcel.readStringArray(strArr);
        this.title = strArr[0];
        this.content = strArr[1];
        this.bWu = Integer.valueOf(parcel.readInt());
        AppMethodBeat.o(123426);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(123427);
        parcel.writeStringArray(new String[]{this.title, this.content});
        parcel.writeInt(this.bWu.intValue());
        AppMethodBeat.o(123427);
    }

    static {
        AppMethodBeat.i(123428);
        AppMethodBeat.o(123428);
    }
}
