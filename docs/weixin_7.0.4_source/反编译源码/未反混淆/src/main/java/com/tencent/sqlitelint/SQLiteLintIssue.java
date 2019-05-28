package com.tencent.sqlitelint;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SQLiteLintIssue implements Parcelable {
    public static final Creator<SQLiteLintIssue> CREATOR = new Creator<SQLiteLintIssue>() {
        public final SQLiteLintIssue createFromParcel(Parcel parcel) {
            AppMethodBeat.i(94010);
            SQLiteLintIssue sQLiteLintIssue = new SQLiteLintIssue(parcel);
            AppMethodBeat.o(94010);
            return sQLiteLintIssue;
        }

        public final SQLiteLintIssue[] newArray(int i) {
            return new SQLiteLintIssue[i];
        }
    };
    public static final int ERROR = 4;
    public static final int PASS = 0;
    public static final int SUGGESTION = 2;
    public static final int TIPS = 1;
    public static final int WARNING = 3;
    public String advice;
    public long createTime;
    public String dbPath;
    public String desc;
    public String detail;
    public String extInfo;
    public String id;
    public boolean isInMainThread;
    public boolean isNew;
    public int level;
    public String sql;
    public long sqlTimeCost;
    public String table;
    public int type;

    public static String getLevelText(int i, Context context) {
        String string;
        AppMethodBeat.i(94013);
        switch (i) {
            case 1:
                string = context.getString(R.string.g6y);
                break;
            case 2:
                string = context.getString(R.string.g6x);
                break;
            case 3:
                string = context.getString(R.string.g6z);
                break;
            case 4:
                string = context.getString(R.string.g6w);
                break;
            default:
                string = context.getString(R.string.g6x);
                break;
        }
        AppMethodBeat.o(94013);
        return string;
    }

    public SQLiteLintIssue(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, long j, String str8, long j2, boolean z) {
        this.id = str;
        this.dbPath = str2;
        this.level = i;
        this.type = i2;
        this.sql = str3;
        this.table = str4;
        this.desc = str5;
        this.detail = str6;
        this.advice = str7;
        this.createTime = j;
        this.extInfo = str8;
        this.sqlTimeCost = j2;
        this.isInMainThread = z;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(94014);
        if (obj instanceof SQLiteLintIssue) {
            boolean equals = ((SQLiteLintIssue) obj).id.equals(this.id);
            AppMethodBeat.o(94014);
            return equals;
        }
        AppMethodBeat.o(94014);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.i(94015);
        int hashCode = this.id.hashCode();
        AppMethodBeat.o(94015);
        return hashCode;
    }

    protected SQLiteLintIssue(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(94016);
        this.id = parcel.readString();
        this.dbPath = parcel.readString();
        this.level = parcel.readInt();
        this.type = parcel.readInt();
        this.sql = parcel.readString();
        this.table = parcel.readString();
        this.desc = parcel.readString();
        this.detail = parcel.readString();
        this.advice = parcel.readString();
        this.createTime = parcel.readLong();
        this.extInfo = parcel.readString();
        this.sqlTimeCost = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.isInMainThread = z;
        AppMethodBeat.o(94016);
    }

    static {
        AppMethodBeat.i(94018);
        AppMethodBeat.o(94018);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(94017);
        parcel.writeString(this.id);
        parcel.writeString(this.dbPath);
        parcel.writeInt(this.level);
        parcel.writeInt(this.type);
        parcel.writeString(this.sql);
        parcel.writeString(this.table);
        parcel.writeString(this.desc);
        parcel.writeString(this.detail);
        parcel.writeString(this.advice);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.extInfo);
        parcel.writeLong(this.sqlTimeCost);
        parcel.writeInt(this.isInMainThread ? 1 : 0);
        AppMethodBeat.o(94017);
    }
}
