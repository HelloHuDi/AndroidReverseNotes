package com.tencent.p177mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26310eh;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.SmileyInfo */
public class SmileyInfo extends C26310eh implements Parcelable {
    public static final Creator<SmileyInfo> CREATOR = new C360021();
    protected static C4924a ccO;

    /* renamed from: com.tencent.mm.storage.emotion.SmileyInfo$1 */
    static class C360021 implements Creator<SmileyInfo> {
        C360021() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SmileyInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(62879);
            SmileyInfo smileyInfo = new SmileyInfo(parcel);
            AppMethodBeat.m2505o(62879);
            return smileyInfo;
        }
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    protected SmileyInfo(Parcel parcel) {
        AppMethodBeat.m2504i(62880);
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
        AppMethodBeat.m2505o(62880);
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
        AppMethodBeat.m2504i(62881);
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
        AppMethodBeat.m2505o(62881);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(62882);
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
        AppMethodBeat.m2505o(62882);
    }

    static {
        AppMethodBeat.m2504i(62883);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[10];
        c4924a.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "key";
        c4924a.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "key";
        c4924a.columns[1] = "cnValue";
        c4924a.xDd.put("cnValue", "TEXT");
        stringBuilder.append(" cnValue TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "qqValue";
        c4924a.xDd.put("qqValue", "TEXT");
        stringBuilder.append(" qqValue TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "twValue";
        c4924a.xDd.put("twValue", "TEXT");
        stringBuilder.append(" twValue TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "enValue";
        c4924a.xDd.put("enValue", "TEXT");
        stringBuilder.append(" enValue TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "thValue";
        c4924a.xDd.put("thValue", "TEXT");
        stringBuilder.append(" thValue TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = DownloadInfo.FILENAME;
        c4924a.xDd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "eggIndex";
        c4924a.xDd.put("eggIndex", "INTEGER default '-1' ");
        stringBuilder.append(" eggIndex INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "position";
        c4924a.xDd.put("position", "INTEGER default '-1' ");
        stringBuilder.append(" position INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "flag";
        c4924a.xDd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        c4924a.columns[10] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62883);
    }
}
