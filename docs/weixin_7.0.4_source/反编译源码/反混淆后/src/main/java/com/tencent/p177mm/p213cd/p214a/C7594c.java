package com.tencent.p177mm.p213cd.p214a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;

/* renamed from: com.tencent.mm.cd.a.c */
public final class C7594c extends AbstractCursor {
    final int columnCount;
    private final String[] columnNames;
    SparseArray<Object[]> ycm;
    public int ycn;
    int yco;

    /* renamed from: com.tencent.mm.cd.a.c$a */
    public class C1353a {
        final int endIndex;
        int index;
        Object[] ycp;

        C1353a(int i, int i2, Object[] objArr) {
            this.index = i;
            this.endIndex = i2;
            this.ycp = objArr;
        }
    }

    private C7594c(String[] strArr) {
        AppMethodBeat.m2504i(59136);
        this.ycn = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.ycm = new SparseArray();
        AppMethodBeat.m2505o(59136);
    }

    public C7594c(String[] strArr, byte b) {
        this(strArr);
    }

    private Object get(int i) {
        AppMethodBeat.m2504i(59137);
        CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException;
        if (i < 0 || i >= this.columnCount) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Requested column: " + i + ", # of columns: " + this.columnCount);
            AppMethodBeat.m2505o(59137);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos < 0) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Before first row.");
            AppMethodBeat.m2505o(59137);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos >= this.yco) {
            cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("After last row.");
            AppMethodBeat.m2505o(59137);
            throw cursorIndexOutOfBoundsException;
        } else {
            Object obj = ((Object[]) this.ycm.get(this.mPos / this.ycn))[((this.mPos % this.ycn) * this.columnCount) + i];
            AppMethodBeat.m2505o(59137);
            return obj;
        }
    }

    public final int getCount() {
        return this.yco;
    }

    public final String[] getColumnNames() {
        return this.columnNames;
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(59138);
        Object obj = get(i);
        if (obj == null) {
            AppMethodBeat.m2505o(59138);
            return null;
        }
        String obj2 = obj.toString();
        AppMethodBeat.m2505o(59138);
        return obj2;
    }

    public final short getShort(int i) {
        AppMethodBeat.m2504i(59139);
        Object obj = get(i);
        short shortValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59139);
            return (short) 0;
        } else if (obj instanceof Number) {
            shortValue = ((Number) obj).shortValue();
            AppMethodBeat.m2505o(59139);
            return shortValue;
        } else {
            shortValue = Short.parseShort(obj.toString());
            AppMethodBeat.m2505o(59139);
            return shortValue;
        }
    }

    public final int getInt(int i) {
        AppMethodBeat.m2504i(59140);
        Object obj = get(i);
        int intValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59140);
            return 0;
        } else if (obj instanceof Number) {
            intValue = ((Number) obj).intValue();
            AppMethodBeat.m2505o(59140);
            return intValue;
        } else {
            intValue = Integer.parseInt(obj.toString());
            AppMethodBeat.m2505o(59140);
            return intValue;
        }
    }

    public final long getLong(int i) {
        AppMethodBeat.m2504i(59141);
        Object obj = get(i);
        long longValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59141);
            return 0;
        } else if (obj instanceof Number) {
            longValue = ((Number) obj).longValue();
            AppMethodBeat.m2505o(59141);
            return longValue;
        } else {
            longValue = Long.parseLong(obj.toString());
            AppMethodBeat.m2505o(59141);
            return longValue;
        }
    }

    public final float getFloat(int i) {
        AppMethodBeat.m2504i(59142);
        Object obj = get(i);
        float floatValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59142);
            return 0.0f;
        } else if (obj instanceof Number) {
            floatValue = ((Number) obj).floatValue();
            AppMethodBeat.m2505o(59142);
            return floatValue;
        } else {
            floatValue = Float.parseFloat(obj.toString());
            AppMethodBeat.m2505o(59142);
            return floatValue;
        }
    }

    public final double getDouble(int i) {
        AppMethodBeat.m2504i(59143);
        Object obj = get(i);
        double doubleValue;
        if (obj == null) {
            AppMethodBeat.m2505o(59143);
            return 0.0d;
        } else if (obj instanceof Number) {
            doubleValue = ((Number) obj).doubleValue();
            AppMethodBeat.m2505o(59143);
            return doubleValue;
        } else {
            doubleValue = Double.parseDouble(obj.toString());
            AppMethodBeat.m2505o(59143);
            return doubleValue;
        }
    }

    public final boolean isNull(int i) {
        AppMethodBeat.m2504i(59144);
        if (get(i) == null) {
            AppMethodBeat.m2505o(59144);
            return true;
        }
        AppMethodBeat.m2505o(59144);
        return false;
    }

    public final byte[] getBlob(int i) {
        AppMethodBeat.m2504i(59145);
        Object obj = get(i);
        if (obj == null) {
            AppMethodBeat.m2505o(59145);
            return null;
        }
        byte[] bArr = (byte[]) obj;
        AppMethodBeat.m2505o(59145);
        return bArr;
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
