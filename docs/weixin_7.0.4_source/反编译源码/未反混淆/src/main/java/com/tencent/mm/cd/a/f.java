package com.tencent.mm.cd.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f extends AbstractCursor implements d {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.i(59179);
            f fVar = new f(sQLiteCursorDriver, str, (h) sQLiteProgram);
            AppMethodBeat.o(59179);
            return fVar;
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.i(59180);
            h hVar = new h(sQLiteDatabase, str, cancellationSignal);
            AppMethodBeat.o(59180);
            return hVar;
        }
    };
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final Throwable mStackTrace;
    private int pageSize = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private final h ycu;
    public a ycv;
    private boolean ycw;
    private b<a> ycx;
    c ycy;
    private boolean ycz;

    public interface a {
        ArrayList<a> ao(ArrayList<Object> arrayList);

        a dvz();
    }

    public f(SQLiteCursorDriver sQLiteCursorDriver, String str, h hVar) {
        AppMethodBeat.i(59181);
        if (hVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.o(59181);
            throw illegalArgumentException;
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.ycu = hVar;
        this.mColumns = hVar.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        AppMethodBeat.o(59181);
    }

    public final void MH(int i) {
        if (i <= 15000 && i >= 2000) {
            this.pageSize = i;
        }
    }

    public final void pt(boolean z) {
        this.ycw = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onMove(int i, int i2) {
        AppMethodBeat.i(59182);
        if (!this.ycw) {
            boolean z;
            if (this.ycy == null) {
                dvA();
            }
            c cVar = this.ycy;
            int i3 = i2 / cVar.ycn;
            if (cVar.ycm.indexOfKey(i3) >= 0) {
                if (((Object[]) cVar.ycm.get(i3))[(i2 % cVar.ycn) * cVar.columnCount] != null) {
                    z = true;
                    if (!z) {
                        MJ((i2 / this.pageSize) * this.pageSize);
                    }
                    this.ycy.moveToPosition(i2);
                }
            }
            z = false;
            if (z) {
            }
            this.ycy.moveToPosition(i2);
        } else if (this.ycx == null || !this.ycx.MI(i2)) {
            MJ((i2 / this.pageSize) * this.pageSize);
        }
        AppMethodBeat.o(59182);
        return true;
    }

    private void dvA() {
        AppMethodBeat.i(59183);
        if (this.ycy == null) {
            this.ycy = new c(this.mColumns, (byte) 0);
        }
        AppMethodBeat.o(59183);
    }

    public final int getCount() {
        AppMethodBeat.i(59184);
        if (this.mCount == -1) {
            this.mCount = MJ(0);
            if (this.ycx != null) {
                boolean z = this.mCount != -1 && this.mCount == this.ycx.ych.size();
                this.ycz = z;
            }
        }
        int i;
        if (!this.ycw || !this.ycz) {
            i = this.mCount;
            AppMethodBeat.o(59184);
            return i;
        } else if (this.ycx == null) {
            AppMethodBeat.o(59184);
            return 0;
        } else {
            i = this.ycx.ych.size();
            AppMethodBeat.o(59184);
            return i;
        }
    }

    public final void checkPosition() {
        AppMethodBeat.i(59185);
        super.checkPosition();
        AppMethodBeat.o(59185);
    }

    private int MJ(int i) {
        AppMethodBeat.i(59186);
        int a;
        if (this.ycw) {
            if (this.ycx == null) {
                this.ycx = new b<a>() {
                    public final a dvz() {
                        AppMethodBeat.i(59177);
                        f fVar = f.this;
                        if (fVar.ycv != null) {
                            a dvz = fVar.ycv.dvz();
                            AppMethodBeat.o(59177);
                            return dvz;
                        }
                        AppMethodBeat.o(59177);
                        return null;
                    }

                    public final ArrayList<a> ao(ArrayList<Object> arrayList) {
                        AppMethodBeat.i(59178);
                        f fVar = f.this;
                        if (fVar.ycv != null) {
                            ArrayList ao = fVar.ycv.ao(arrayList);
                            AppMethodBeat.o(59178);
                            return ao;
                        }
                        AppMethodBeat.o(59178);
                        return null;
                    }
                };
            }
            this.ycx.mStartPos = i;
            a = this.ycu.a(this.ycx, i, this.pageSize);
            AppMethodBeat.o(59186);
            return a;
        }
        dvA();
        a = this.ycu.a(this.ycy, i, this.pageSize);
        AppMethodBeat.o(59186);
        return a;
    }

    public final int getColumnIndex(String str) {
        int i;
        Object str2;
        AppMethodBeat.i(59187);
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str2.lastIndexOf(46);
        if (i != -1) {
            Exception exception = new Exception();
            Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- ".concat(String.valueOf(str2)), exception);
            str2 = str2.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str2);
        if (num != null) {
            i = num.intValue();
            AppMethodBeat.o(59187);
            return i;
        }
        AppMethodBeat.o(59187);
        return -1;
    }

    public final String[] getColumnNames() {
        return this.mColumns;
    }

    public final void deactivate() {
        AppMethodBeat.i(59188);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.o(59188);
    }

    public final void close() {
        AppMethodBeat.i(59189);
        super.close();
        synchronized (this) {
            try {
                this.ycu.close();
                this.mDriver.cursorClosed();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59189);
            }
        }
    }

    public final boolean requery() {
        boolean z = false;
        AppMethodBeat.i(59190);
        if (isClosed()) {
            AppMethodBeat.o(59190);
        } else {
            synchronized (this) {
                try {
                    if (this.ycu.getDatabase().isOpen()) {
                        if (this.ycx != null) {
                            this.ycx.clearData();
                        }
                        this.mPos = -1;
                        this.mCount = -1;
                        this.mDriver.cursorRequeried(this);
                        try {
                            z = super.requery();
                            AppMethodBeat.o(59190);
                        } catch (IllegalStateException e) {
                            Log.w("WCDB.SQLiteNewCursor", "requery() failed " + e.getMessage(), e);
                            AppMethodBeat.o(59190);
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(59190);
                }
            }
        }
        return z;
    }

    public final void finalize() {
        AppMethodBeat.i(59191);
        try {
            if (this.ycx != null) {
                close();
            }
            super.finalize();
            AppMethodBeat.o(59191);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(59191);
        }
    }

    public final String getString(int i) {
        AppMethodBeat.i(59192);
        if (this.ycw) {
            AppMethodBeat.o(59192);
            return null;
        }
        String string = this.ycy.getString(i);
        AppMethodBeat.o(59192);
        return string;
    }

    public final short getShort(int i) {
        AppMethodBeat.i(59193);
        if (this.ycw) {
            AppMethodBeat.o(59193);
            return (short) 0;
        }
        short s = this.ycy.getShort(i);
        AppMethodBeat.o(59193);
        return s;
    }

    public final int getInt(int i) {
        AppMethodBeat.i(59194);
        if (this.ycw) {
            AppMethodBeat.o(59194);
            return 0;
        }
        int i2 = this.ycy.getInt(i);
        AppMethodBeat.o(59194);
        return i2;
    }

    public final long getLong(int i) {
        AppMethodBeat.i(59195);
        if (this.ycw) {
            AppMethodBeat.o(59195);
            return 0;
        }
        long j = this.ycy.getLong(i);
        AppMethodBeat.o(59195);
        return j;
    }

    public final float getFloat(int i) {
        AppMethodBeat.i(59196);
        if (this.ycw) {
            AppMethodBeat.o(59196);
            return 0.0f;
        }
        float f = this.ycy.getFloat(i);
        AppMethodBeat.o(59196);
        return f;
    }

    public final double getDouble(int i) {
        AppMethodBeat.i(59197);
        if (this.ycw) {
            AppMethodBeat.o(59197);
            return 0.0d;
        }
        double d = this.ycy.getDouble(i);
        AppMethodBeat.o(59197);
        return d;
    }

    public final boolean isNull(int i) {
        AppMethodBeat.i(59198);
        if (this.ycw) {
            AppMethodBeat.o(59198);
            return false;
        }
        boolean isNull = this.ycy.isNull(i);
        AppMethodBeat.o(59198);
        return isNull;
    }

    public final byte[] getBlob(int i) {
        AppMethodBeat.i(59199);
        if (this.ycw) {
            AppMethodBeat.o(59199);
            return null;
        }
        byte[] blob = this.ycy.getBlob(i);
        AppMethodBeat.o(59199);
        return blob;
    }

    public final a MG(int i) {
        a aVar = null;
        int i2 = 0;
        AppMethodBeat.i(59200);
        if (this.ycx != null) {
            b bVar = this.ycx;
            if (bVar.MI(i)) {
                Object obj = bVar.ych.get(i);
                aVar = (a) bVar.ycj.get(obj);
                if (aVar == null) {
                    ab.i("MicroMsg.CursorDataWindow", "get data null %s", obj);
                    if (bVar.yck.size() != 0) {
                        ArrayList ao = bVar.ao(bVar.yck);
                        if (ao != null) {
                            while (i2 < ao.size()) {
                                aVar = (a) ao.get(i2);
                                if (aVar != null) {
                                    bVar.b(aVar.getKey(), aVar);
                                } else {
                                    ab.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                                }
                                i2++;
                            }
                        }
                        bVar.yck.clear();
                    }
                    aVar = (a) bVar.ycj.get(obj);
                    if (aVar == null) {
                        ab.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i);
                    }
                }
            } else {
                ab.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + i + " loaded num :" + bVar.ych.size());
            }
            AppMethodBeat.o(59200);
        } else {
            AppMethodBeat.o(59200);
        }
        return aVar;
    }

    public final boolean a(Object obj, a aVar) {
        AppMethodBeat.i(59201);
        if (!this.ycw || this.ycx == null) {
            if (!this.ycw) {
                c cVar = this.ycy;
                cVar.mPos = 0;
                cVar.ycm.clear();
            }
            AppMethodBeat.o(59201);
        } else {
            if (!this.ycz && (obj instanceof Object[]) && this.ycx.cK(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.pageSize -= ((Object[]) obj).length;
            }
            b bVar = this.ycx;
            if (aVar != null) {
                ab.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + aVar);
                bVar.b(obj, aVar);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object remove : objArr) {
                    bVar.ycj.remove(remove);
                }
                bVar.z(objArr);
            } else {
                if (bVar.yck == null) {
                    bVar.yck = new ArrayList();
                }
                if (!bVar.yck.contains(obj)) {
                    bVar.yck.add(obj);
                    ab.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : ".concat(String.valueOf(obj)));
                }
                bVar.ycj.remove(obj);
            }
            AppMethodBeat.o(59201);
        }
        return false;
    }

    public final boolean dvr() {
        return this.ycz;
    }

    public final boolean MF(int i) {
        if (!this.ycw) {
            return false;
        }
        b bVar = this.ycx;
        if (i > 50) {
            return false;
        }
        if (bVar.yci < 10) {
            return true;
        }
        if (((double) i) / ((double) bVar.yci) < 0.1d) {
            return true;
        }
        return false;
    }

    public final boolean cK(Object obj) {
        AppMethodBeat.i(59202);
        if (!this.ycw) {
            AppMethodBeat.o(59202);
            return false;
        } else if (this.ycx == null) {
            AppMethodBeat.o(59202);
            return false;
        } else {
            boolean cK = this.ycx.cK(obj);
            AppMethodBeat.o(59202);
            return cK;
        }
    }

    public final a cL(Object obj) {
        AppMethodBeat.i(59203);
        if (!this.ycw) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error ".concat(String.valueOf(obj)));
            AppMethodBeat.o(59203);
            return null;
        } else if (this.ycx == null) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            AppMethodBeat.o(59203);
            return null;
        } else {
            b bVar = this.ycx;
            if (bVar.ycj == null) {
                AppMethodBeat.o(59203);
                return null;
            }
            a aVar = (a) bVar.ycj.get(obj);
            AppMethodBeat.o(59203);
            return aVar;
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void a(a aVar) {
        this.ycv = aVar;
    }

    public final SparseArray<Object>[] dvp() {
        if (!this.ycw) {
            return null;
        }
        return new SparseArray[]{this.ycx.ych};
    }

    public final HashMap dvq() {
        return this.ycx.ycj;
    }

    static {
        AppMethodBeat.i(59204);
        AppMethodBeat.o(59204);
    }
}
