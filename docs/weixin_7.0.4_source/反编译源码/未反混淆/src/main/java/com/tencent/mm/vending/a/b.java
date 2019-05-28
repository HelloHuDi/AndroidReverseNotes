package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item> extends com.tencent.mm.vending.base.b<_Struct, Cursor> {
    protected _Item JE;
    protected Map<Integer, _Item> kaV = null;
    protected int mCount;
    public a zXa;
    protected Cursor zXb = null;

    public interface a {
        void cuo();

        void cup();
    }

    public abstract _Item a(_Item _item, Cursor cursor);

    public abstract Cursor cuR();

    public b(_Item _item) {
        this.JE = _item;
        this.mCount = -1;
        dLZ();
    }

    private Cursor getCursor() {
        if (this.zXb == null || this.zXb.isClosed()) {
            Assert.assertNotNull(this.zXb);
        }
        return this.zXb;
    }

    public void destroyAsynchronous() {
        bIf();
    }

    public final void bIf() {
        if (this.kaV != null) {
            this.kaV.clear();
        }
        if (this.zXb != null) {
            this.zXb.close();
        }
        this.mCount = -1;
    }

    public final void dLZ() {
        if (this.kaV == null) {
            this.kaV = new HashMap();
        }
    }

    public final int dMa() {
        if (this.mCount < 0) {
            this.mCount = getCursor().getCount();
        }
        return this.mCount;
    }

    public final _Item getItem(int i) {
        if (this.kaV != null) {
            Object obj = this.kaV.get(Integer.valueOf(i));
            if (obj != null) {
                return obj;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.kaV == null) {
            return a(this.JE, getCursor());
        }
        _Item a = a(null, getCursor());
        this.kaV.put(Integer.valueOf(i), a);
        return a;
    }

    public /* synthetic */ Object prepareVendingDataAsynchronous() {
        if (this.zXa != null) {
            this.zXa.cuo();
        }
        Cursor cuR = cuR();
        if (this.zXa != null) {
            this.zXa.cup();
        }
        return cuR;
    }
}
