package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BulkCursorDescriptor implements Parcelable {
    public static final Creator<BulkCursorDescriptor> CREATOR = new C245051();
    public String[] columnNames;
    public int count;
    public IBulkCursor cursor;
    public boolean wantsAllOnMoveCalls;
    public CursorWindow window;

    /* renamed from: com.tencent.wcdb.BulkCursorDescriptor$1 */
    static class C245051 implements Creator<BulkCursorDescriptor> {
        C245051() {
        }

        public final BulkCursorDescriptor createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(11960);
            BulkCursorDescriptor bulkCursorDescriptor = new BulkCursorDescriptor();
            bulkCursorDescriptor.readFromParcel(parcel);
            AppMethodBeat.m2505o(11960);
            return bulkCursorDescriptor;
        }

        public final BulkCursorDescriptor[] newArray(int i) {
            return new BulkCursorDescriptor[i];
        }
    }

    static {
        AppMethodBeat.m2504i(11966);
        AppMethodBeat.m2505o(11966);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(11963);
        parcel.writeStrongBinder(this.cursor.asBinder());
        parcel.writeStringArray(this.columnNames);
        parcel.writeInt(this.wantsAllOnMoveCalls ? 1 : 0);
        parcel.writeInt(this.count);
        if (this.window != null) {
            parcel.writeInt(1);
            this.window.writeToParcel(parcel, i);
            AppMethodBeat.m2505o(11963);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(11963);
    }

    public final String[] readStringArray(Parcel parcel) {
        AppMethodBeat.m2504i(11964);
        String[] strArr = null;
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            strArr = new String[readInt];
            for (int i = 0; i < readInt; i++) {
                strArr[i] = parcel.readString();
            }
        }
        AppMethodBeat.m2505o(11964);
        return strArr;
    }

    public final void readFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(11965);
        this.cursor = BulkCursorNative.asInterface(parcel.readStrongBinder());
        this.columnNames = readStringArray(parcel);
        this.wantsAllOnMoveCalls = parcel.readInt() != 0;
        this.count = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.window = (CursorWindow) CursorWindow.CREATOR.createFromParcel(parcel);
        }
        AppMethodBeat.m2505o(11965);
    }
}
