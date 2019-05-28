package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    public class RowBuilder {
        private final int endIndex;
        private int index;

        RowBuilder(int i, int i2) {
            this.index = i;
            this.endIndex = i2;
        }

        public RowBuilder add(Object obj) {
            AppMethodBeat.m2504i(12174);
            if (this.index == this.endIndex) {
                CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("No more columns left.");
                AppMethodBeat.m2505o(12174);
                throw cursorIndexOutOfBoundsException;
            }
            Object[] access$000 = MatrixCursor.this.data;
            int i = this.index;
            this.index = i + 1;
            access$000[i] = obj;
            AppMethodBeat.m2505o(12174);
            return this;
        }
    }

    public MatrixCursor(String[] strArr, int i) {
        AppMethodBeat.m2504i(12175);
        this.rowCount = 0;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        if (i <= 0) {
            i = 1;
        }
        this.data = new Object[(this.columnCount * i)];
        AppMethodBeat.m2505o(12175);
    }

    public MatrixCursor(String[] strArr) {
        this(strArr, 16);
    }

    private Object get(int i) {
        AppMethodBeat.m2504i(12176);
        CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException;
        if (i < 0 || i >= this.columnCount) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Requested column: " + i + ", # of columns: " + this.columnCount);
            AppMethodBeat.m2505o(12176);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos < 0) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Before first row.");
            AppMethodBeat.m2505o(12176);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos >= this.rowCount) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("After last row.");
            AppMethodBeat.m2505o(12176);
            throw cursorIndexOutOfBoundsException;
        } else {
            Object obj = this.data[(this.mPos * this.columnCount) + i];
            AppMethodBeat.m2505o(12176);
            return obj;
        }
    }

    public RowBuilder newRow() {
        AppMethodBeat.m2504i(12177);
        this.rowCount++;
        int i = this.rowCount * this.columnCount;
        ensureCapacity(i);
        RowBuilder rowBuilder = new RowBuilder(i - this.columnCount, i);
        AppMethodBeat.m2505o(12177);
        return rowBuilder;
    }

    public void addRow(Object[] objArr) {
        AppMethodBeat.m2504i(12178);
        if (objArr.length != this.columnCount) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
            AppMethodBeat.m2505o(12178);
            throw illegalArgumentException;
        }
        int i = this.rowCount;
        this.rowCount = i + 1;
        i *= this.columnCount;
        ensureCapacity(this.columnCount + i);
        System.arraycopy(objArr, 0, this.data, i, this.columnCount);
        AppMethodBeat.m2505o(12178);
    }

    public void addRow(Iterable<?> iterable) {
        AppMethodBeat.m2504i(12179);
        int i = this.rowCount * this.columnCount;
        int i2 = i + this.columnCount;
        ensureCapacity(i2);
        if (iterable instanceof ArrayList) {
            addRow((ArrayList) iterable, i);
            AppMethodBeat.m2505o(12179);
            return;
        }
        IllegalArgumentException illegalArgumentException;
        Object[] objArr = this.data;
        for (Object next : iterable) {
            if (i == i2) {
                illegalArgumentException = new IllegalArgumentException("columnValues.size() > columnNames.length");
                AppMethodBeat.m2505o(12179);
                throw illegalArgumentException;
            }
            int i3 = i + 1;
            objArr[i] = next;
            i = i3;
        }
        if (i != i2) {
            illegalArgumentException = new IllegalArgumentException("columnValues.size() < columnNames.length");
            AppMethodBeat.m2505o(12179);
            throw illegalArgumentException;
        }
        this.rowCount++;
        AppMethodBeat.m2505o(12179);
    }

    private void addRow(ArrayList<?> arrayList, int i) {
        AppMethodBeat.m2504i(12180);
        int size = arrayList.size();
        if (size != this.columnCount) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + size);
            AppMethodBeat.m2505o(12180);
            throw illegalArgumentException;
        }
        this.rowCount++;
        Object[] objArr = this.data;
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = arrayList.get(i2);
        }
        AppMethodBeat.m2505o(12180);
    }

    private void ensureCapacity(int i) {
        AppMethodBeat.m2504i(12181);
        if (i > this.data.length) {
            Object[] objArr = this.data;
            int length = this.data.length * 2;
            if (length >= i) {
                i = length;
            }
            this.data = new Object[i];
            System.arraycopy(objArr, 0, this.data, 0, objArr.length);
        }
        AppMethodBeat.m2505o(12181);
    }

    public int getCount() {
        return this.rowCount;
    }

    public String[] getColumnNames() {
        return this.columnNames;
    }

    public String getString(int i) {
        AppMethodBeat.m2504i(12182);
        Object obj = get(i);
        if (obj == null) {
            AppMethodBeat.m2505o(12182);
            return null;
        }
        String obj2 = obj.toString();
        AppMethodBeat.m2505o(12182);
        return obj2;
    }

    public short getShort(int i) {
        AppMethodBeat.m2504i(12183);
        Object obj = get(i);
        short shortValue;
        if (obj == null) {
            AppMethodBeat.m2505o(12183);
            return (short) 0;
        } else if (obj instanceof Number) {
            shortValue = ((Number) obj).shortValue();
            AppMethodBeat.m2505o(12183);
            return shortValue;
        } else {
            shortValue = Short.parseShort(obj.toString());
            AppMethodBeat.m2505o(12183);
            return shortValue;
        }
    }

    public int getInt(int i) {
        AppMethodBeat.m2504i(12184);
        Object obj = get(i);
        int intValue;
        if (obj == null) {
            AppMethodBeat.m2505o(12184);
            return 0;
        } else if (obj instanceof Number) {
            intValue = ((Number) obj).intValue();
            AppMethodBeat.m2505o(12184);
            return intValue;
        } else {
            intValue = Integer.parseInt(obj.toString());
            AppMethodBeat.m2505o(12184);
            return intValue;
        }
    }

    public long getLong(int i) {
        AppMethodBeat.m2504i(12185);
        Object obj = get(i);
        long longValue;
        if (obj == null) {
            AppMethodBeat.m2505o(12185);
            return 0;
        } else if (obj instanceof Number) {
            longValue = ((Number) obj).longValue();
            AppMethodBeat.m2505o(12185);
            return longValue;
        } else {
            longValue = Long.parseLong(obj.toString());
            AppMethodBeat.m2505o(12185);
            return longValue;
        }
    }

    public float getFloat(int i) {
        AppMethodBeat.m2504i(12186);
        Object obj = get(i);
        float floatValue;
        if (obj == null) {
            AppMethodBeat.m2505o(12186);
            return 0.0f;
        } else if (obj instanceof Number) {
            floatValue = ((Number) obj).floatValue();
            AppMethodBeat.m2505o(12186);
            return floatValue;
        } else {
            floatValue = Float.parseFloat(obj.toString());
            AppMethodBeat.m2505o(12186);
            return floatValue;
        }
    }

    public double getDouble(int i) {
        AppMethodBeat.m2504i(12187);
        Object obj = get(i);
        double doubleValue;
        if (obj == null) {
            AppMethodBeat.m2505o(12187);
            return 0.0d;
        } else if (obj instanceof Number) {
            doubleValue = ((Number) obj).doubleValue();
            AppMethodBeat.m2505o(12187);
            return doubleValue;
        } else {
            doubleValue = Double.parseDouble(obj.toString());
            AppMethodBeat.m2505o(12187);
            return doubleValue;
        }
    }

    public byte[] getBlob(int i) {
        AppMethodBeat.m2504i(12188);
        byte[] bArr = (byte[]) get(i);
        AppMethodBeat.m2505o(12188);
        return bArr;
    }

    public int getType(int i) {
        AppMethodBeat.m2504i(12189);
        int typeOfObject = DatabaseUtils.getTypeOfObject(get(i));
        AppMethodBeat.m2505o(12189);
        return typeOfObject;
    }

    public boolean isNull(int i) {
        AppMethodBeat.m2504i(12190);
        if (get(i) == null) {
            AppMethodBeat.m2505o(12190);
            return true;
        }
        AppMethodBeat.m2505o(12190);
        return false;
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public void registerContentObserver(ContentObserver contentObserver) {
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
