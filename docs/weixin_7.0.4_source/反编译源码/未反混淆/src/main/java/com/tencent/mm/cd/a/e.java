package com.tencent.mm.cd.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a.f.a;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e extends AbstractCursor implements d {
    private DataSetObserver mObserver = new DataSetObserver() {
        public final void onChanged() {
            AppMethodBeat.i(59146);
            e.this.mPos = -1;
            AppMethodBeat.o(59146);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(59147);
            e.this.mPos = -1;
            AppMethodBeat.o(59147);
        }
    };
    private d ycr;
    public d[] ycs;

    public e(d[] dVarArr) {
        int i = 0;
        AppMethodBeat.i(59148);
        this.ycs = dVarArr;
        this.ycr = dVarArr[0];
        while (i < this.ycs.length) {
            if (this.ycs[i] != null) {
                this.ycs[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
        AppMethodBeat.o(59148);
    }

    public final int getCount() {
        AppMethodBeat.i(59149);
        int length = this.ycs.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.ycs[i2] != null) {
                i += this.ycs[i2].getCount();
            }
        }
        AppMethodBeat.o(59149);
        return i;
    }

    public final boolean onMove(int i, int i2) {
        AppMethodBeat.i(59150);
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
            AppMethodBeat.o(59150);
            return moveToPosition;
        }
        AppMethodBeat.o(59150);
        return false;
    }

    public final String getString(int i) {
        AppMethodBeat.i(59151);
        String string = this.ycr.getString(i);
        AppMethodBeat.o(59151);
        return string;
    }

    public final short getShort(int i) {
        AppMethodBeat.i(59152);
        short s = this.ycr.getShort(i);
        AppMethodBeat.o(59152);
        return s;
    }

    public final int getInt(int i) {
        AppMethodBeat.i(59153);
        int i2 = this.ycr.getInt(i);
        AppMethodBeat.o(59153);
        return i2;
    }

    public final long getLong(int i) {
        AppMethodBeat.i(59154);
        long j = this.ycr.getLong(i);
        AppMethodBeat.o(59154);
        return j;
    }

    public final float getFloat(int i) {
        AppMethodBeat.i(59155);
        float f = this.ycr.getFloat(i);
        AppMethodBeat.o(59155);
        return f;
    }

    public final double getDouble(int i) {
        AppMethodBeat.i(59156);
        double d = this.ycr.getDouble(i);
        AppMethodBeat.o(59156);
        return d;
    }

    public final boolean isNull(int i) {
        AppMethodBeat.i(59157);
        boolean isNull = this.ycr.isNull(i);
        AppMethodBeat.o(59157);
        return isNull;
    }

    public final byte[] getBlob(int i) {
        AppMethodBeat.i(59158);
        byte[] blob = this.ycr.getBlob(i);
        AppMethodBeat.o(59158);
        return blob;
    }

    public final String[] getColumnNames() {
        AppMethodBeat.i(59159);
        String[] columnNames;
        if (this.ycr != null) {
            columnNames = this.ycr.getColumnNames();
            AppMethodBeat.o(59159);
            return columnNames;
        }
        columnNames = new String[0];
        AppMethodBeat.o(59159);
        return columnNames;
    }

    public final void deactivate() {
        AppMethodBeat.i(59160);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].deactivate();
            }
        }
        super.deactivate();
        AppMethodBeat.o(59160);
    }

    public final void close() {
        AppMethodBeat.i(59161);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].close();
            }
        }
        super.close();
        AppMethodBeat.o(59161);
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(59162);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].registerContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(59162);
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(59163);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].unregisterContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(59163);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(59164);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].registerDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(59164);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(59165);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(59165);
    }

    public final boolean requery() {
        AppMethodBeat.i(59166);
        int length = this.ycs.length;
        int i = 0;
        while (i < length) {
            if (this.ycs[i] == null || this.ycs[i].requery()) {
                i++;
            } else {
                AppMethodBeat.o(59166);
                return false;
            }
        }
        AppMethodBeat.o(59166);
        return true;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(59167);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].a(aVar);
            }
        }
        AppMethodBeat.o(59167);
    }

    public final void pt(boolean z) {
        AppMethodBeat.i(59168);
        int length = this.ycs.length;
        for (int i = 0; i < length; i++) {
            if (this.ycs[i] != null) {
                this.ycs[i].pt(z);
            }
        }
        AppMethodBeat.o(59168);
    }

    public final boolean dvr() {
        AppMethodBeat.i(59169);
        int length = this.ycs.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            if (!(this.ycs[i] == null || this.ycs[i].dvr())) {
                z = false;
            }
            i++;
        }
        AppMethodBeat.o(59169);
        return z;
    }

    public final a MG(int i) {
        AppMethodBeat.i(59170);
        int length = this.ycs.length;
        for (int i2 = 0; i2 < length; i2++) {
            int count = this.ycs[i2].getCount();
            if (i < count) {
                a MG = this.ycs[i2].MG(i);
                AppMethodBeat.o(59170);
                return MG;
            }
            i -= count;
        }
        AppMethodBeat.o(59170);
        return null;
    }

    public final boolean a(Object obj, a aVar) {
        AppMethodBeat.i(59171);
        int length = this.ycs.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (this.ycs[i] != null && this.ycs[i].a(obj, aVar)) {
                z = true;
            }
            i++;
        }
        AppMethodBeat.o(59171);
        return z;
    }

    public final SparseArray<Object>[] dvp() {
        AppMethodBeat.i(59172);
        int length = this.ycs.length;
        SparseArray[] sparseArrayArr = new SparseArray[length];
        for (int i = 0; i < length; i++) {
            SparseArray[] dvp = this.ycs[i].dvp();
            sparseArrayArr[i] = dvp != null ? dvp[0] : null;
        }
        AppMethodBeat.o(59172);
        return sparseArrayArr;
    }

    public final HashMap dvq() {
        return null;
    }

    public final boolean MF(int i) {
        AppMethodBeat.i(59173);
        int length = this.ycs.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            if (!(this.ycs[i2] == null || this.ycs[i2].MF(i))) {
                z = false;
            }
            i2++;
        }
        AppMethodBeat.o(59173);
        return z;
    }

    public final boolean cK(Object obj) {
        AppMethodBeat.i(59174);
        int length = this.ycs.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (this.ycs[i] != null && this.ycs[i].cK(obj)) {
                z = true;
            }
            i++;
        }
        AppMethodBeat.o(59174);
        return z;
    }

    public final a cL(Object obj) {
        AppMethodBeat.i(59175);
        a cL = this.ycr.cL(obj);
        AppMethodBeat.o(59175);
        return cL;
    }

    public final void MH(int i) {
        AppMethodBeat.i(59176);
        int length = this.ycs.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.ycs[i2] != null) {
                this.ycs[i2].MH(i);
            }
        }
        AppMethodBeat.o(59176);
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }
}
