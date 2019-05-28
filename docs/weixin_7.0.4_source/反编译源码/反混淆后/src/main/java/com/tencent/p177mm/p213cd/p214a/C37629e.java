package com.tencent.p177mm.p213cd.p214a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.p214a.C7595f.C1355a;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

/* renamed from: com.tencent.mm.cd.a.e */
public final class C37629e extends AbstractCursor implements C1354d {
    private DataSetObserver mObserver = new C92131();
    private C1354d ycr;
    public C1354d[] ycs;

    /* renamed from: com.tencent.mm.cd.a.e$1 */
    class C92131 extends DataSetObserver {
        C92131() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(59146);
            C37629e.this.mPos = -1;
            AppMethodBeat.m2505o(59146);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(59147);
            C37629e.this.mPos = -1;
            AppMethodBeat.m2505o(59147);
        }
    }

    public C37629e(C1354d[] c1354dArr) {
        int i = 0;
        AppMethodBeat.m2504i(59148);
        this.ycs = c1354dArr;
        this.ycr = c1354dArr[0];
        while (i < this.ycs.length) {
            if (this.ycs[i] != null) {
                this.ycs[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
        AppMethodBeat.m2505o(59148);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(59149);
        int length = this.ycs.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.ycs[i2] != null) {
                i += this.ycs[i2].getCount();
            }
        }
        AppMethodBeat.m2505o(59149);
        return i;
    }

    public final boolean onMove(int i, int i2) {
        AppMethodBeat.m2504i(59150);
        this.ycr = null;
        int length = this.ycs.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.ycs[i4] != null) {
                if (i2 < this.ycs[i4].getCount() + i3) {
                    this.ycr = this.ycs[i4];
                    break;
                }
                i3 += this.ycs[i4].getCount();
            }
        }
        if (this.ycr != null) {
            boolean moveToPosition = this.ycr.moveToPosition(i2 - i3);
            AppMethodBeat.m2505o(59150);
            return moveToPosition;
        }
        AppMethodBeat.m2505o(59150);
        return false;
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(59151);
        String string = this.ycr.getString(i);
        AppMethodBeat.m2505o(59151);
        return string;
    }

    public final short getShort(int i) {
        AppMethodBeat.m2504i(59152);
        short s = this.ycr.getShort(i);
        AppMethodBeat.m2505o(59152);
        return s;
    }

    public final int getInt(int i) {
        AppMethodBeat.m2504i(59153);
        int i2 = this.ycr.getInt(i);
        AppMethodBeat.m2505o(59153);
        return i2;
    }

    public final long getLong(int i) {
        AppMethodBeat.m2504i(59154);
        long j = this.ycr.getLong(i);
        AppMethodBeat.m2505o(59154);
        return j;
    }

    public final float getFloat(int i) {
        AppMethodBeat.m2504i(59155);
        float f = this.ycr.getFloat(i);
        AppMethodBeat.m2505o(59155);
        return f;
    }

    public final double getDouble(int i) {
        AppMethodBeat.m2504i(59156);
        double d = this.ycr.getDouble(i);
        AppMethodBeat.m2505o(59156);
        return d;
    }

    public final boolean isNull(int i) {
        AppMethodBeat.m2504i(59157);
        boolean isNull = this.ycr.isNull(i);
        AppMethodBeat.m2505o(59157);
        return isNull;
    }

    public final byte[] getBlob(int i) {
        AppMethodBeat.m2504i(59158);
        byte[] blob = this.ycr.getBlob(i);
        AppMethodBeat.m2505o(59158);
        return blob;
    }

    public final String[] getColumnNames() {
        AppMethodBeat.m2504i(59159);
        String[] columnNames;
        if (this.ycr != null) {
            columnNames = this.ycr.getColumnNames();
            AppMethodBeat.m2505o(59159);
            return columnNames;
        }
        columnNames = new String[0];
        AppMethodBeat.m2505o(59159);
        return columnNames;
    }

    public final void deactivate() {
        AppMethodBeat.m2504i(59160);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].deactivate();
            }
        }
        super.deactivate();
        AppMethodBeat.m2505o(59160);
    }

    public final void close() {
        AppMethodBeat.m2504i(59161);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].close();
            }
        }
        super.close();
        AppMethodBeat.m2505o(59161);
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.m2504i(59162);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].registerContentObserver(contentObserver);
            }
        }
        AppMethodBeat.m2505o(59162);
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.m2504i(59163);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].unregisterContentObserver(contentObserver);
            }
        }
        AppMethodBeat.m2505o(59163);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.m2504i(59164);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].registerDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.m2505o(59164);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.m2504i(59165);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.m2505o(59165);
    }

    public final boolean requery() {
        AppMethodBeat.m2504i(59166);
        int length = this.ycs.length;
        int i = 0;
        while (i < length) {
            if (this.ycs[i] == null || this.ycs[i].requery()) {
                i++;
            } else {
                AppMethodBeat.m2505o(59166);
                return false;
            }
        }
        AppMethodBeat.m2505o(59166);
        return true;
    }

    /* renamed from: a */
    public final void mo4717a(C1355a c1355a) {
        AppMethodBeat.m2504i(59167);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].mo4717a(c1355a);
            }
        }
        AppMethodBeat.m2505o(59167);
    }

    /* renamed from: pt */
    public final void mo4724pt(boolean z) {
        AppMethodBeat.m2504i(59168);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].mo4724pt(z);
            }
        }
        AppMethodBeat.m2505o(59168);
    }

    public final boolean dvr() {
        AppMethodBeat.m2504i(59169);
        int length = this.ycs.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            if (!(this.ycs[i] == null || this.ycs[i].dvr())) {
                z = false;
            }
            i++;
        }
        AppMethodBeat.m2505o(59169);
        return z;
    }

    /* renamed from: MG */
    public final C1351a mo4715MG(int i) {
        AppMethodBeat.m2504i(59170);
        int length = this.ycs.length;
        for (int i2 = 0; i2 < length; i2++) {
            int count = this.ycs[i2].getCount();
            if (i < count) {
                C1351a MG = this.ycs[i2].mo4715MG(i);
                AppMethodBeat.m2505o(59170);
                return MG;
            }
            i -= count;
        }
        AppMethodBeat.m2505o(59170);
        return null;
    }

    /* renamed from: a */
    public final boolean mo4718a(Object obj, C1351a c1351a) {
        AppMethodBeat.m2504i(59171);
        int length = this.ycs.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (this.ycs[i] != null && this.ycs[i].mo4718a(obj, c1351a)) {
                z = true;
            }
            i++;
        }
        AppMethodBeat.m2505o(59171);
        return z;
    }

    public final SparseArray<Object>[] dvp() {
        AppMethodBeat.m2504i(59172);
        int length = this.ycs.length;
        SparseArray[] sparseArrayArr = new SparseArray[length];
        for (int i = 0; i < length; i++) {
            SparseArray[] dvp = this.ycs[i].dvp();
            sparseArrayArr[i] = dvp != null ? dvp[0] : null;
        }
        AppMethodBeat.m2505o(59172);
        return sparseArrayArr;
    }

    public final HashMap dvq() {
        return null;
    }

    /* renamed from: MF */
    public final boolean mo4714MF(int i) {
        AppMethodBeat.m2504i(59173);
        int length = this.ycs.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            if (!(this.ycs[i2] == null || this.ycs[i2].mo4714MF(i))) {
                z = false;
            }
            i2++;
        }
        AppMethodBeat.m2505o(59173);
        return z;
    }

    /* renamed from: cK */
    public final boolean mo4719cK(Object obj) {
        AppMethodBeat.m2504i(59174);
        int length = this.ycs.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (this.ycs[i] != null && this.ycs[i].mo4719cK(obj)) {
                z = true;
            }
            i++;
        }
        AppMethodBeat.m2505o(59174);
        return z;
    }

    /* renamed from: cL */
    public final C1351a mo4720cL(Object obj) {
        AppMethodBeat.m2504i(59175);
        C1351a cL = this.ycr.mo4720cL(obj);
        AppMethodBeat.m2505o(59175);
        return cL;
    }

    /* renamed from: MH */
    public final void mo4716MH(int i) {
        AppMethodBeat.m2504i(59176);
        int length = this.ycs.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.ycs[i2] != null) {
                this.ycs[i2].mo4716MH(i);
            }
        }
        AppMethodBeat.m2505o(59176);
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }
}
