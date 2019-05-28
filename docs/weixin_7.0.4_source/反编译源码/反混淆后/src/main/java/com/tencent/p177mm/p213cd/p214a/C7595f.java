package com.tencent.p177mm.p213cd.p214a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
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

/* renamed from: com.tencent.mm.cd.a.f */
public final class C7595f extends AbstractCursor implements C1354d {
    public static final CursorFactory FACTORY = new C63932();
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final Throwable mStackTrace;
    private int pageSize = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private final C7596h ycu;
    public C1355a ycv;
    private boolean ycw;
    private C1352b<C1351a> ycx;
    C7594c ycy;
    private boolean ycz;

    /* renamed from: com.tencent.mm.cd.a.f$a */
    public interface C1355a {
        /* renamed from: ao */
        ArrayList<C1351a> mo4725ao(ArrayList<Object> arrayList);

        C1351a dvz();
    }

    /* renamed from: com.tencent.mm.cd.a.f$1 */
    class C63921 extends C1352b<C1351a> {
        C63921() {
        }

        public final C1351a dvz() {
            AppMethodBeat.m2504i(59177);
            C7595f c7595f = C7595f.this;
            if (c7595f.ycv != null) {
                C1351a dvz = c7595f.ycv.dvz();
                AppMethodBeat.m2505o(59177);
                return dvz;
            }
            AppMethodBeat.m2505o(59177);
            return null;
        }

        /* renamed from: ao */
        public final ArrayList<C1351a> mo4706ao(ArrayList<Object> arrayList) {
            AppMethodBeat.m2504i(59178);
            C7595f c7595f = C7595f.this;
            if (c7595f.ycv != null) {
                ArrayList ao = c7595f.ycv.mo4725ao(arrayList);
                AppMethodBeat.m2505o(59178);
                return ao;
            }
            AppMethodBeat.m2505o(59178);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.cd.a.f$2 */
    static class C63932 implements CursorFactory {
        C63932() {
        }

        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.m2504i(59179);
            C7595f c7595f = new C7595f(sQLiteCursorDriver, str, (C7596h) sQLiteProgram);
            AppMethodBeat.m2505o(59179);
            return c7595f;
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.m2504i(59180);
            C7596h c7596h = new C7596h(sQLiteDatabase, str, cancellationSignal);
            AppMethodBeat.m2505o(59180);
            return c7596h;
        }
    }

    public C7595f(SQLiteCursorDriver sQLiteCursorDriver, String str, C7596h c7596h) {
        AppMethodBeat.m2504i(59181);
        if (c7596h == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.m2505o(59181);
            throw illegalArgumentException;
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.ycu = c7596h;
        this.mColumns = c7596h.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        AppMethodBeat.m2505o(59181);
    }

    /* renamed from: MH */
    public final void mo4716MH(int i) {
        if (i <= 15000 && i >= 2000) {
            this.pageSize = i;
        }
    }

    /* renamed from: pt */
    public final void mo4724pt(boolean z) {
        this.ycw = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onMove(int i, int i2) {
        AppMethodBeat.m2504i(59182);
        if (!this.ycw) {
            boolean z;
            if (this.ycy == null) {
                dvA();
            }
            C7594c c7594c = this.ycy;
            int i3 = i2 / c7594c.ycn;
            if (c7594c.ycm.indexOfKey(i3) >= 0) {
                if (((Object[]) c7594c.ycm.get(i3))[(i2 % c7594c.ycn) * c7594c.columnCount] != null) {
                    z = true;
                    if (!z) {
                        m13517MJ((i2 / this.pageSize) * this.pageSize);
                    }
                    this.ycy.moveToPosition(i2);
                }
            }
            z = false;
            if (z) {
            }
            this.ycy.moveToPosition(i2);
        } else if (this.ycx == null || !this.ycx.mo4705MI(i2)) {
            m13517MJ((i2 / this.pageSize) * this.pageSize);
        }
        AppMethodBeat.m2505o(59182);
        return true;
    }

    private void dvA() {
        AppMethodBeat.m2504i(59183);
        if (this.ycy == null) {
            this.ycy = new C7594c(this.mColumns, (byte) 0);
        }
        AppMethodBeat.m2505o(59183);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(59184);
        if (this.mCount == -1) {
            this.mCount = m13517MJ(0);
            if (this.ycx != null) {
                boolean z = this.mCount != -1 && this.mCount == this.ycx.ych.size();
                this.ycz = z;
            }
        }
        int i;
        if (!this.ycw || !this.ycz) {
            i = this.mCount;
            AppMethodBeat.m2505o(59184);
            return i;
        } else if (this.ycx == null) {
            AppMethodBeat.m2505o(59184);
            return 0;
        } else {
            i = this.ycx.ych.size();
            AppMethodBeat.m2505o(59184);
            return i;
        }
    }

    public final void checkPosition() {
        AppMethodBeat.m2504i(59185);
        super.checkPosition();
        AppMethodBeat.m2505o(59185);
    }

    /* renamed from: MJ */
    private int m13517MJ(int i) {
        AppMethodBeat.m2504i(59186);
        int a;
        if (this.ycw) {
            if (this.ycx == null) {
                this.ycx = new C63921();
            }
            this.ycx.mStartPos = i;
            a = this.ycu.mo16988a(this.ycx, i, this.pageSize);
            AppMethodBeat.m2505o(59186);
            return a;
        }
        dvA();
        a = this.ycu.mo16989a(this.ycy, i, this.pageSize);
        AppMethodBeat.m2505o(59186);
        return a;
    }

    public final int getColumnIndex(String str) {
        int i;
        Object str2;
        AppMethodBeat.m2504i(59187);
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
            Log.m9445e("WCDB.SQLiteNewCursor", "requesting column name with table name -- ".concat(String.valueOf(str2)), exception);
            str2 = str2.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str2);
        if (num != null) {
            i = num.intValue();
            AppMethodBeat.m2505o(59187);
            return i;
        }
        AppMethodBeat.m2505o(59187);
        return -1;
    }

    public final String[] getColumnNames() {
        return this.mColumns;
    }

    public final void deactivate() {
        AppMethodBeat.m2504i(59188);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.m2505o(59188);
    }

    public final void close() {
        AppMethodBeat.m2504i(59189);
        super.close();
        synchronized (this) {
            try {
                this.ycu.close();
                this.mDriver.cursorClosed();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59189);
            }
        }
    }

    public final boolean requery() {
        boolean z = false;
        AppMethodBeat.m2504i(59190);
        if (isClosed()) {
            AppMethodBeat.m2505o(59190);
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
                            AppMethodBeat.m2505o(59190);
                        } catch (IllegalStateException e) {
                            Log.m9453w("WCDB.SQLiteNewCursor", "requery() failed " + e.getMessage(), e);
                            AppMethodBeat.m2505o(59190);
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(59190);
                }
            }
        }
        return z;
    }

    public final void finalize() {
        AppMethodBeat.m2504i(59191);
        try {
            if (this.ycx != null) {
                close();
            }
            super.finalize();
            AppMethodBeat.m2505o(59191);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(59191);
        }
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(59192);
        if (this.ycw) {
            AppMethodBeat.m2505o(59192);
            return null;
        }
        String string = this.ycy.getString(i);
        AppMethodBeat.m2505o(59192);
        return string;
    }

    public final short getShort(int i) {
        AppMethodBeat.m2504i(59193);
        if (this.ycw) {
            AppMethodBeat.m2505o(59193);
            return (short) 0;
        }
        short s = this.ycy.getShort(i);
        AppMethodBeat.m2505o(59193);
        return s;
    }

    public final int getInt(int i) {
        AppMethodBeat.m2504i(59194);
        if (this.ycw) {
            AppMethodBeat.m2505o(59194);
            return 0;
        }
        int i2 = this.ycy.getInt(i);
        AppMethodBeat.m2505o(59194);
        return i2;
    }

    public final long getLong(int i) {
        AppMethodBeat.m2504i(59195);
        if (this.ycw) {
            AppMethodBeat.m2505o(59195);
            return 0;
        }
        long j = this.ycy.getLong(i);
        AppMethodBeat.m2505o(59195);
        return j;
    }

    public final float getFloat(int i) {
        AppMethodBeat.m2504i(59196);
        if (this.ycw) {
            AppMethodBeat.m2505o(59196);
            return 0.0f;
        }
        float f = this.ycy.getFloat(i);
        AppMethodBeat.m2505o(59196);
        return f;
    }

    public final double getDouble(int i) {
        AppMethodBeat.m2504i(59197);
        if (this.ycw) {
            AppMethodBeat.m2505o(59197);
            return 0.0d;
        }
        double d = this.ycy.getDouble(i);
        AppMethodBeat.m2505o(59197);
        return d;
    }

    public final boolean isNull(int i) {
        AppMethodBeat.m2504i(59198);
        if (this.ycw) {
            AppMethodBeat.m2505o(59198);
            return false;
        }
        boolean isNull = this.ycy.isNull(i);
        AppMethodBeat.m2505o(59198);
        return isNull;
    }

    public final byte[] getBlob(int i) {
        AppMethodBeat.m2504i(59199);
        if (this.ycw) {
            AppMethodBeat.m2505o(59199);
            return null;
        }
        byte[] blob = this.ycy.getBlob(i);
        AppMethodBeat.m2505o(59199);
        return blob;
    }

    /* renamed from: MG */
    public final C1351a mo4715MG(int i) {
        C1351a c1351a = null;
        int i2 = 0;
        AppMethodBeat.m2504i(59200);
        if (this.ycx != null) {
            C1352b c1352b = this.ycx;
            if (c1352b.mo4705MI(i)) {
                Object obj = c1352b.ych.get(i);
                c1351a = (C1351a) c1352b.ycj.get(obj);
                if (c1351a == null) {
                    C4990ab.m7417i("MicroMsg.CursorDataWindow", "get data null %s", obj);
                    if (c1352b.yck.size() != 0) {
                        ArrayList ao = c1352b.mo4706ao(c1352b.yck);
                        if (ao != null) {
                            while (i2 < ao.size()) {
                                c1351a = (C1351a) ao.get(i2);
                                if (c1351a != null) {
                                    c1352b.mo4707b(c1351a.getKey(), c1351a);
                                } else {
                                    C4990ab.m7412e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                                }
                                i2++;
                            }
                        }
                        c1352b.yck.clear();
                    }
                    c1351a = (C1351a) c1352b.ycj.get(obj);
                    if (c1351a == null) {
                        C4990ab.m7412e("MicroMsg.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i);
                    }
                }
            } else {
                C4990ab.m7412e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + i + " loaded num :" + c1352b.ych.size());
            }
            AppMethodBeat.m2505o(59200);
        } else {
            AppMethodBeat.m2505o(59200);
        }
        return c1351a;
    }

    /* renamed from: a */
    public final boolean mo4718a(Object obj, C1351a c1351a) {
        AppMethodBeat.m2504i(59201);
        if (!this.ycw || this.ycx == null) {
            if (!this.ycw) {
                C7594c c7594c = this.ycy;
                c7594c.mPos = 0;
                c7594c.ycm.clear();
            }
            AppMethodBeat.m2505o(59201);
        } else {
            if (!this.ycz && (obj instanceof Object[]) && this.ycx.mo4708cK(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.pageSize -= ((Object[]) obj).length;
            }
            C1352b c1352b = this.ycx;
            if (c1351a != null) {
                C4990ab.m7418v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + c1351a);
                c1352b.mo4707b(obj, c1351a);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object remove : objArr) {
                    c1352b.ycj.remove(remove);
                }
                c1352b.mo4713z(objArr);
            } else {
                if (c1352b.yck == null) {
                    c1352b.yck = new ArrayList();
                }
                if (!c1352b.yck.contains(obj)) {
                    c1352b.yck.add(obj);
                    C4990ab.m7416i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : ".concat(String.valueOf(obj)));
                }
                c1352b.ycj.remove(obj);
            }
            AppMethodBeat.m2505o(59201);
        }
        return false;
    }

    public final boolean dvr() {
        return this.ycz;
    }

    /* renamed from: MF */
    public final boolean mo4714MF(int i) {
        if (!this.ycw) {
            return false;
        }
        C1352b c1352b = this.ycx;
        if (i > 50) {
            return false;
        }
        if (c1352b.yci < 10) {
            return true;
        }
        if (((double) i) / ((double) c1352b.yci) < 0.1d) {
            return true;
        }
        return false;
    }

    /* renamed from: cK */
    public final boolean mo4719cK(Object obj) {
        AppMethodBeat.m2504i(59202);
        if (!this.ycw) {
            AppMethodBeat.m2505o(59202);
            return false;
        } else if (this.ycx == null) {
            AppMethodBeat.m2505o(59202);
            return false;
        } else {
            boolean cK = this.ycx.mo4708cK(obj);
            AppMethodBeat.m2505o(59202);
            return cK;
        }
    }

    /* renamed from: cL */
    public final C1351a mo4720cL(Object obj) {
        AppMethodBeat.m2504i(59203);
        if (!this.ycw) {
            Log.m9444e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error ".concat(String.valueOf(obj)));
            AppMethodBeat.m2505o(59203);
            return null;
        } else if (this.ycx == null) {
            Log.m9444e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            AppMethodBeat.m2505o(59203);
            return null;
        } else {
            C1352b c1352b = this.ycx;
            if (c1352b.ycj == null) {
                AppMethodBeat.m2505o(59203);
                return null;
            }
            C1351a c1351a = (C1351a) c1352b.ycj.get(obj);
            AppMethodBeat.m2505o(59203);
            return c1351a;
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

    /* renamed from: a */
    public final void mo4717a(C1355a c1355a) {
        this.ycv = c1355a;
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
        AppMethodBeat.m2504i(59204);
        AppMethodBeat.m2505o(59204);
    }
}
