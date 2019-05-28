package com.tencent.p177mm.p213cd.p214a;

import android.database.CursorIndexOutOfBoundsException;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.p214a.C7594c.C1353a;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectQuery;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

/* renamed from: com.tencent.mm.cd.a.h */
public final class C7596h extends SQLiteDirectQuery {
    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e8 A:{Catch:{ SQLiteException -> 0x006e, all -> 0x00a2 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo16988a(C1352b c1352b, int i, int i2) {
        int step;
        SQLiteException e;
        Object obj = 1;
        AppMethodBeat.m2504i(59207);
        acquireReference();
        c1352b.acquireReference();
        if (i > 0) {
            try {
                step = step(i);
                if (step < i) {
                    Log.m9453w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", Integer.valueOf(i), Integer.valueOf(step));
                    c1352b.releaseReference();
                    releaseReference();
                    AppMethodBeat.m2505o(59207);
                    return step;
                }
            } catch (SQLiteException e2) {
                Log.m9444e("WCDB.SQLiteNewQuery", "exception: " + e2.getMessage() + "; query: " + getSql());
                checkCorruption(e2);
                AppMethodBeat.m2505o(59207);
                throw e2;
            } catch (Throwable th) {
                c1352b.releaseReference();
                releaseReference();
                AppMethodBeat.m2505o(59207);
            }
        }
        int length = getColumnNames().length;
        int i3 = i2 + i;
        step = i;
        while (step < i3) {
            if (step(1) == 1) {
                c1352b.ycl = c1352b.dvz();
                for (int i4 = 0; i4 < length; i4++) {
                    switch (getType(i4)) {
                        case 0:
                            break;
                        case 1:
                            long j = getLong(i4);
                            if (c1352b.ycl == null) {
                                break;
                            }
                            c1352b.ycl.mo4700ag(i4, j);
                            break;
                        case 2:
                            getDouble(i4);
                            break;
                        case 3:
                            String string = getString(i4);
                            if (c1352b.ycl == null) {
                                break;
                            }
                            c1352b.ycl.mo4701bK(i4, string);
                            break;
                        case 4:
                            byte[] blob = getBlob(i4);
                            if (c1352b.ycl == null) {
                                break;
                            }
                            c1352b.ycl.mo4704q(i4, blob);
                            break;
                        default:
                            c1352b.mo4711ha(step, 1);
                            e2 = new SQLiteException("Unknown column type when filling window.");
                            AppMethodBeat.m2505o(59207);
                            throw e2;
                    }
                }
                c1352b.mo4711ha(step, 0);
                step++;
            } else {
                if (obj == null) {
                    step += step(BaseClientBuilder.API_PRIORITY_OTHER);
                }
                reset(true);
                c1352b.releaseReference();
                releaseReference();
                AppMethodBeat.m2505o(59207);
                return step;
            }
        }
        obj = null;
        if (obj == null) {
        }
        reset(true);
        c1352b.releaseReference();
        releaseReference();
        AppMethodBeat.m2505o(59207);
        return step;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0127 A:{Catch:{ SQLiteException -> 0x0093, all -> 0x00c7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo16989a(C7594c c7594c, int i, int i2) {
        int step;
        SQLiteException e;
        Object obj;
        AppMethodBeat.m2504i(59208);
        acquireReference();
        if (i > 0) {
            try {
                step = step(i);
                if (step < i) {
                    Log.m9453w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", Integer.valueOf(i), Integer.valueOf(step));
                    releaseReference();
                    AppMethodBeat.m2505o(59208);
                    return step;
                }
            } catch (SQLiteException e2) {
                Log.m9444e("WCDB.SQLiteNewQuery", "exception: " + e2.getMessage() + "; query: " + getSql());
                checkCorruption(e2);
                AppMethodBeat.m2505o(59208);
                throw e2;
            } catch (Throwable th) {
                releaseReference();
                AppMethodBeat.m2505o(59208);
            }
        }
        int length = getColumnNames().length;
        int i3 = i2 + i;
        int i4 = i;
        while (i4 < i3) {
            if (step(1) == 1) {
                Object[] objArr;
                int i5 = i4 / c7594c.ycn;
                if (c7594c.ycm.indexOfKey(i5) < 0) {
                    Object[] objArr2 = new Object[(c7594c.ycn * c7594c.columnCount)];
                    c7594c.ycm.put(i5, objArr2);
                    objArr = objArr2;
                } else {
                    objArr = (Object[]) c7594c.ycm.get(i5);
                }
                int i6 = c7594c.columnCount * (i4 % c7594c.ycn);
                int i7 = i6 + c7594c.columnCount;
                step = i4 + 1;
                if (step <= c7594c.yco) {
                    step = c7594c.yco;
                }
                c7594c.yco = step;
                C1353a c1353a = new C1353a(i6, i7, objArr);
                for (i5 = 0; i5 < length; i5++) {
                    String str;
                    switch (getType(i5)) {
                        case 0:
                            str = null;
                            break;
                        case 1:
                            str = Long.valueOf(getLong(i5));
                            break;
                        case 2:
                            str = Double.valueOf(getDouble(i5));
                            break;
                        case 3:
                            str = getString(i5);
                            break;
                        case 4:
                            str = getBlob(i5);
                            break;
                        default:
                            e2 = new SQLiteException("Unknown column type when filling window.");
                            AppMethodBeat.m2505o(59208);
                            throw e2;
                    }
                    if (c1353a.index == c1353a.endIndex) {
                        CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("No more columns left.");
                        AppMethodBeat.m2505o(59208);
                        throw cursorIndexOutOfBoundsException;
                    }
                    Object[] objArr3 = c1353a.ycp;
                    i7 = c1353a.index;
                    c1353a.index = i7 + 1;
                    objArr3[i7] = str;
                }
                i4++;
            } else {
                obj = 1;
                if (obj != null) {
                    step = step(BaseClientBuilder.API_PRIORITY_OTHER) + i4;
                } else {
                    step = i4;
                }
                reset(true);
                releaseReference();
                AppMethodBeat.m2505o(59208);
                return step;
            }
        }
        obj = null;
        if (obj != null) {
        }
        reset(true);
        releaseReference();
        AppMethodBeat.m2505o(59208);
        return step;
    }

    C7596h(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
    }

    public final String toString() {
        AppMethodBeat.m2504i(59209);
        String str = "SQLiteNewQuery: " + getSql();
        AppMethodBeat.m2505o(59209);
        return str;
    }
}
