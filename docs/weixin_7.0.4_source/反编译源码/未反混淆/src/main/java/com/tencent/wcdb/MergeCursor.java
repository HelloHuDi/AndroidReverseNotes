package com.tencent.wcdb;

import android.database.ContentObserver;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MergeCursor extends AbstractCursor {
    private Cursor mCursor;
    private Cursor[] mCursors;
    private DataSetObserver mObserver = new DataSetObserver() {
        public void onChanged() {
            MergeCursor.this.mPos = -1;
        }

        public void onInvalidated() {
            MergeCursor.this.mPos = -1;
        }
    };

    public MergeCursor(Cursor[] cursorArr) {
        int i = 0;
        AppMethodBeat.i(12191);
        this.mCursors = cursorArr;
        this.mCursor = cursorArr[0];
        while (i < this.mCursors.length) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
        AppMethodBeat.o(12191);
    }

    public int getCount() {
        AppMethodBeat.i(12192);
        int length = this.mCursors.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                i += this.mCursors[i2].getCount();
            }
        }
        AppMethodBeat.o(12192);
        return i;
    }

    public boolean onMove(int i, int i2) {
        AppMethodBeat.i(12193);
        this.mCursor = null;
        int length = this.mCursors.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.mCursors[i4] != null) {
                if (i2 < this.mCursors[i4].getCount() + i3) {
                    this.mCursor = this.mCursors[i4];
                    break;
                }
                i3 += this.mCursors[i4].getCount();
            }
        }
        if (this.mCursor != null) {
            boolean moveToPosition = this.mCursor.moveToPosition(i2 - i3);
            AppMethodBeat.o(12193);
            return moveToPosition;
        }
        AppMethodBeat.o(12193);
        return false;
    }

    public String getString(int i) {
        AppMethodBeat.i(12194);
        String string = this.mCursor.getString(i);
        AppMethodBeat.o(12194);
        return string;
    }

    public short getShort(int i) {
        AppMethodBeat.i(12195);
        short s = this.mCursor.getShort(i);
        AppMethodBeat.o(12195);
        return s;
    }

    public int getInt(int i) {
        AppMethodBeat.i(12196);
        int i2 = this.mCursor.getInt(i);
        AppMethodBeat.o(12196);
        return i2;
    }

    public long getLong(int i) {
        AppMethodBeat.i(12197);
        long j = this.mCursor.getLong(i);
        AppMethodBeat.o(12197);
        return j;
    }

    public float getFloat(int i) {
        AppMethodBeat.i(12198);
        float f = this.mCursor.getFloat(i);
        AppMethodBeat.o(12198);
        return f;
    }

    public double getDouble(int i) {
        AppMethodBeat.i(12199);
        double d = this.mCursor.getDouble(i);
        AppMethodBeat.o(12199);
        return d;
    }

    public int getType(int i) {
        AppMethodBeat.i(12200);
        int type = this.mCursor.getType(i);
        AppMethodBeat.o(12200);
        return type;
    }

    public boolean isNull(int i) {
        AppMethodBeat.i(12201);
        boolean isNull = this.mCursor.isNull(i);
        AppMethodBeat.o(12201);
        return isNull;
    }

    public byte[] getBlob(int i) {
        AppMethodBeat.i(12202);
        byte[] blob = this.mCursor.getBlob(i);
        AppMethodBeat.o(12202);
        return blob;
    }

    public String[] getColumnNames() {
        AppMethodBeat.i(12203);
        String[] columnNames;
        if (this.mCursor != null) {
            columnNames = this.mCursor.getColumnNames();
            AppMethodBeat.o(12203);
            return columnNames;
        }
        columnNames = new String[0];
        AppMethodBeat.o(12203);
        return columnNames;
    }

    public void deactivate() {
        AppMethodBeat.i(12204);
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].deactivate();
            }
        }
        super.deactivate();
        AppMethodBeat.o(12204);
    }

    public void close() {
        AppMethodBeat.i(12205);
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].close();
            }
        }
        super.close();
        AppMethodBeat.o(12205);
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(12206);
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(12206);
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(12207);
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].unregisterContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(12207);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(12208);
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(12208);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(12209);
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(12209);
    }

    public boolean requery() {
        AppMethodBeat.i(12210);
        int length = this.mCursors.length;
        int i = 0;
        while (i < length) {
            if (this.mCursors[i] == null || this.mCursors[i].requery()) {
                i++;
            } else {
                AppMethodBeat.o(12210);
                return false;
            }
        }
        AppMethodBeat.o(12210);
        return true;
    }
}
