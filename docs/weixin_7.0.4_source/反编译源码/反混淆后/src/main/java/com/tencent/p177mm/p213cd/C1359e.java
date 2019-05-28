package com.tencent.p177mm.p213cd;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.cd.e */
public final class C1359e extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    private C1359e(String[] strArr) {
        AppMethodBeat.m2504i(59038);
        this.rowCount = 0;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.data = new Object[(this.columnCount * 16)];
        AppMethodBeat.m2505o(59038);
    }

    public C1359e(String[] strArr, byte b) {
        this(strArr);
    }

    private Object get(int i) {
        AppMethodBeat.m2504i(59039);
        CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException;
        if (i < 0 || i >= this.columnCount) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Requested column: " + i + ", # of columns: " + this.columnCount);
            AppMethodBeat.m2505o(59039);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos < 0) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Before first row.");
            AppMethodBeat.m2505o(59039);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos >= this.rowCount) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("After last row.");
            AppMethodBeat.m2505o(59039);
            throw cursorIndexOutOfBoundsException;
        } else {
            Object obj = this.data[(this.mPos * this.columnCount) + i];
            AppMethodBeat.m2505o(59039);
            return obj;
        }
    }

    public final void addRow(Object[] objArr) {
        AppMethodBeat.m2504i(59040);
        if (objArr.length != this.columnCount) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
            AppMethodBeat.m2505o(59040);
            throw illegalArgumentException;
        }
        int i = this.rowCount;
        this.rowCount = i + 1;
        i *= this.columnCount;
        ensureCapacity(this.columnCount + i);
        System.arraycopy(objArr, 0, this.data, i, this.columnCount);
        AppMethodBeat.m2505o(59040);
    }

    private void ensureCapacity(int i) {
        AppMethodBeat.m2504i(59041);
        if (i > this.data.length) {
            Object[] objArr = this.data;
            int length = this.data.length * 2;
            if (length >= i) {
                i = length;
            }
            this.data = new Object[i];
            System.arraycopy(objArr, 0, this.data, 0, objArr.length);
        }
        AppMethodBeat.m2505o(59041);
    }

    public final int getCount() {
        return this.rowCount;
    }

    public final String[] getColumnNames() {
        return this.columnNames;
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(59042);
        Object obj = get(i);
        if (obj == null) {
            AppMethodBeat.m2505o(59042);
            return null;
        }
        String obj2 = obj.toString();
        AppMethodBeat.m2505o(59042);
        return obj2;
    }

    public final short getShort(int i) {
        AppMethodBeat.m2504i(59043);
        Object obj = get(i);
        short shortValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59043);
            return (short) 0;
        } else if (obj instanceof Number) {
            shortValue = ((Number) obj).shortValue();
            AppMethodBeat.m2505o(59043);
            return shortValue;
        } else {
            shortValue = Short.parseShort(obj.toString());
            AppMethodBeat.m2505o(59043);
            return shortValue;
        }
    }

    public final int getInt(int i) {
        AppMethodBeat.m2504i(59044);
        Object obj = get(i);
        int intValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59044);
            return 0;
        } else if (obj instanceof Number) {
            intValue = ((Number) obj).intValue();
            AppMethodBeat.m2505o(59044);
            return intValue;
        } else {
            intValue = C5046bo.getInt(obj.toString(), 0);
            AppMethodBeat.m2505o(59044);
            return intValue;
        }
    }

    public final long getLong(int i) {
        AppMethodBeat.m2504i(59045);
        Object obj = get(i);
        long longValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59045);
            return 0;
        } else if (obj instanceof Number) {
            longValue = ((Number) obj).longValue();
            AppMethodBeat.m2505o(59045);
            return longValue;
        } else {
            longValue = C5046bo.getLong(obj.toString(), 0);
            AppMethodBeat.m2505o(59045);
            return longValue;
        }
    }

    public final float getFloat(int i) {
        AppMethodBeat.m2504i(59046);
        Object obj = get(i);
        float floatValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59046);
            return 0.0f;
        } else if (obj instanceof Number) {
            floatValue = ((Number) obj).floatValue();
            AppMethodBeat.m2505o(59046);
            return floatValue;
        } else {
            floatValue = C5046bo.getFloat(obj.toString(), 0.0f);
            AppMethodBeat.m2505o(59046);
            return floatValue;
        }
    }

    public final double getDouble(int i) {
        AppMethodBeat.m2504i(59047);
        Object obj = get(i);
        double doubleValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59047);
            return 0.0d;
        } else if (obj instanceof Number) {
            doubleValue = ((Number) obj).doubleValue();
            AppMethodBeat.m2505o(59047);
            return doubleValue;
        } else {
            doubleValue = C5046bo.getDouble(obj.toString(), 0.0d);
            AppMethodBeat.m2505o(59047);
            return doubleValue;
        }
    }

    public final byte[] getBlob(int i) {
        AppMethodBeat.m2504i(59048);
        byte[] bArr = (byte[]) get(i);
        AppMethodBeat.m2505o(59048);
        return bArr;
    }

    public final int getType(int i) {
        AppMethodBeat.m2504i(59049);
        int cM = C1359e.m2915cM(get(i));
        AppMethodBeat.m2505o(59049);
        return cM;
    }

    public final boolean isNull(int i) {
        AppMethodBeat.m2504i(59050);
        if (get(i) == null) {
            AppMethodBeat.m2505o(59050);
            return true;
        }
        AppMethodBeat.m2505o(59050);
        return false;
    }

    /* renamed from: cM */
    private static int m2915cM(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            return 1;
        }
        return 3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0058 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fillWindow(int i, CursorWindow cursorWindow) {
        AppMethodBeat.m2504i(59051);
        if (i < 0 || i >= getCount()) {
            AppMethodBeat.m2505o(59051);
            return;
        }
        cursorWindow.acquireReference();
        try {
            int position = getPosition();
            int columnCount = getColumnCount();
            cursorWindow.clear();
            cursorWindow.setStartPosition(i);
            cursorWindow.setNumColumns(columnCount);
            if (moveToPosition(i)) {
                while (cursorWindow.allocRow()) {
                    int i2 = 0;
                    while (i2 < columnCount) {
                        boolean putNull;
                        switch (C1359e.m2915cM(get(i2))) {
                            case 0:
                                putNull = cursorWindow.putNull(i, i2);
                                break;
                            case 1:
                                putNull = cursorWindow.putLong(getLong(i2), i, i2);
                                break;
                            case 2:
                                putNull = cursorWindow.putDouble(getDouble(i2), i, i2);
                                break;
                            case 4:
                                byte[] blob = getBlob(i2);
                                if (blob == null) {
                                    putNull = cursorWindow.putNull(i, i2);
                                    break;
                                } else {
                                    putNull = cursorWindow.putBlob(blob, i, i2);
                                    break;
                                }
                            default:
                                String string = getString(i2);
                                if (string == null) {
                                    putNull = cursorWindow.putNull(i, i2);
                                    break;
                                } else {
                                    putNull = cursorWindow.putString(string, i, i2);
                                    break;
                                }
                        }
                        if (putNull) {
                            i2++;
                        } else {
                            cursorWindow.freeLastRow();
                            i++;
                            if (!moveToNext()) {
                            }
                        }
                    }
                    i++;
                    if (moveToNext()) {
                    }
                }
            }
            moveToPosition(position);
        } catch (IllegalStateException e) {
        } finally {
            cursorWindow.releaseReference();
            AppMethodBeat.m2505o(59051);
        }
    }
}
