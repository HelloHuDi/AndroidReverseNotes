package com.tencent.p177mm.vending.p635a;

import android.database.Cursor;
import com.tencent.p177mm.vending.base.C40921b;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.vending.a.b */
public abstract class C41350b<_Struct, _Item> extends C40921b<_Struct, Cursor> {
    /* renamed from: JE */
    protected _Item f16585JE;
    protected Map<Integer, _Item> kaV = null;
    protected int mCount;
    public C41351a zXa;
    protected Cursor zXb = null;

    /* renamed from: com.tencent.mm.vending.a.b$a */
    public interface C41351a {
        void cuo();

        void cup();
    }

    /* renamed from: a */
    public abstract _Item mo37605a(_Item _item, Cursor cursor);

    public abstract Cursor cuR();

    public C41350b(_Item _item) {
        this.f16585JE = _item;
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
            return mo37605a(this.f16585JE, getCursor());
        }
        _Item a = mo37605a(null, getCursor());
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
