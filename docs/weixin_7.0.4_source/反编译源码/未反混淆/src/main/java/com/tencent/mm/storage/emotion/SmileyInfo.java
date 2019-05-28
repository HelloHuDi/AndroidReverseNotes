package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class SmileyInfo extends eh implements Parcelable {
    public static final Creator<SmileyInfo> CREATOR = new Creator<SmileyInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SmileyInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(62879);
            SmileyInfo smileyInfo = new SmileyInfo(parcel);
            AppMethodBeat.o(62879);
            return smileyInfo;
        }
    };
    protected static a ccO;

    public final a Ag() {
        return null;
    }

    protected SmileyInfo(Parcel parcel) {
        AppMethodBeat.i(62880);
        this.field_key = parcel.readString();
        this.field_cnValue = parcel.readString();
        this.field_qqValue = parcel.readString();
        this.field_twValue = parcel.readString();
        this.field_enValue = parcel.readString();
        this.field_thValue = parcel.readString();
        this.field_fileName = parcel.readString();
        this.field_position = parcel.readInt();
        this.field_eggIndex = parcel.readInt();
        this.field_flag = parcel.readInt();
        AppMethodBeat.o(62880);
    }

    public SmileyInfo(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.field_key = str;
        this.field_cnValue = str3;
        this.field_qqValue = str2;
        this.field_enValue = str5;
        this.field_thValue = str6;
        this.field_twValue = str4;
        this.field_position = i;
    }

    public SmileyInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.field_key = str;
        this.field_cnValue = str3;
        this.field_qqValue = str2;
        this.field_enValue = str5;
        this.field_thValue = str6;
        this.field_twValue = str4;
        this.field_fileName = str7;
        this.field_eggIndex = i;
    }

    public String toString() {
        AppMethodBeat.i(62881);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key:").append(this.field_key).append("/n");
        stringBuilder.append("cn:").append(this.field_cnValue).append("/n");
        stringBuilder.append("qq:").append(this.field_qqValue).append("/n");
        stringBuilder.append("en:").append(this.field_enValue).append("/n");
        stringBuilder.append("th:").append(this.field_thValue).append("/n");
        stringBuilder.append("tw:").append(this.field_twValue).append("/n");
        stringBuilder.append("position:").append(this.field_position).append("/n");
        stringBuilder.append("file Name:").append(this.field_fileName).append("/n");
        stringBuilder.append("egg index:").append(this.field_eggIndex).append("/n");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(62881);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(62882);
        parcel.writeString(this.field_key);
        parcel.writeString(this.field_cnValue);
        parcel.writeString(this.field_qqValue);
        parcel.writeString(this.field_twValue);
        parcel.writeString(this.field_enValue);
        parcel.writeString(this.field_thValue);
        parcel.writeString(this.field_fileName);
        parcel.writeInt(this.field_position);
        parcel.writeInt(this.field_eggIndex);
        parcel.writeInt(this.field_flag);
        AppMethodBeat.o(62882);
    }

    static {
        AppMethodBeat.i(62883);
        a aVar = new a();
        aVar.xDb = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "key";
        aVar.columns[1] = "cnValue";
        aVar.xDd.put("cnValue", "TEXT");
        stringBuilder.append(" cnValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "qqValue";
        aVar.xDd.put("qqValue", "TEXT");
        stringBuilder.append(" qqValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "twValue";
        aVar.xDd.put("twValue", "TEXT");
        stringBuilder.append(" twValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "enValue";
        aVar.xDd.put("enValue", "TEXT");
        stringBuilder.append(" enValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "thValue";
        aVar.xDd.put("thValue", "TEXT");
        stringBuilder.append(" thValue TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.FILENAME;
        aVar.xDd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "eggIndex";
        aVar.xDd.put("eggIndex", "INTEGER default '-1' ");
        stringBuilder.append(" eggIndex INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "position";
        aVar.xDd.put("position", "INTEGER default '-1' ");
        stringBuilder.append(" position INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "flag";
        aVar.xDd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62883);
    }
}
