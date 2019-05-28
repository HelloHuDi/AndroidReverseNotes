package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class p<T> extends BaseAdapter implements com.tencent.mm.sdk.e.k.a, b {
    public Context context;
    protected int count;
    private ak mty = new ak(Looper.getMainLooper());
    protected T ylb;
    private Cursor ylc = null;
    protected Map<Integer, T> yld = null;
    protected a yle;
    private int ylf = 0;
    private int ylg = 0;
    private int ylh = 0;
    private Runnable yli = new Runnable() {
        public final void run() {
            AppMethodBeat.i(105984);
            if (p.this.ylf != 0) {
                ab.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", Integer.valueOf(p.this.ylf), Integer.valueOf(p.b(p.this)));
                p.this.mty.removeCallbacks(p.this.yli);
                if (20 > p.this.ylh) {
                    p.this.mty.postDelayed(p.this.yli, 100);
                    AppMethodBeat.o(105984);
                    return;
                }
                ab.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", Integer.valueOf(p.this.ylf), Integer.valueOf(p.this.ylh));
            }
            ab.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
            p.this.ylh = 0;
            p.this.dxQ();
            AppMethodBeat.o(105984);
        }
    };

    public interface a {
        void apt();
    }

    public abstract void KC();

    public abstract void KD();

    public abstract T a(T t, Cursor cursor);

    static /* synthetic */ int b(p pVar) {
        int i = pVar.ylh + 1;
        pVar.ylh = i;
        return i;
    }

    public p(Context context, T t) {
        this.ylb = t;
        this.context = context;
        this.count = -1;
    }

    /* Access modifiers changed, original: protected|final */
    public final Cursor getCursor() {
        if (this.ylc == null || this.ylc.isClosed()) {
            KD();
            Assert.assertNotNull(this.ylc);
        }
        return this.ylc;
    }

    public final void setCursor(Cursor cursor) {
        this.ylc = cursor;
        this.count = -1;
    }

    public final void pN(boolean z) {
        if (z) {
            if (this.yld == null) {
                this.yld = new HashMap();
            }
        } else if (this.yld != null) {
            this.yld.clear();
            this.yld = null;
        }
    }

    public final void a(a aVar) {
        this.yle = aVar;
    }

    public final void dww() {
        this.yle = null;
    }

    public void bIf() {
        if (this.yld != null) {
            this.yld.clear();
        }
        if (this.ylc != null) {
            this.ylc.close();
        }
        this.count = -1;
    }

    public int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count + bFs();
    }

    public final int getRealCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count;
    }

    public long getItemId(int i) {
        return 0;
    }

    public void a(int i, n nVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public void a(String str, m mVar) {
        dxQ();
    }

    private void dxQ() {
        ab.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        bIf();
        KC();
        if (this.yle != null) {
            this.yle.apt();
        }
    }

    public T getItem(int i) {
        if (wK(i)) {
            return bFt();
        }
        T t;
        if (this.yld != null) {
            t = this.yld.get(Integer.valueOf(i));
            if (t != null) {
                return t;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.yld == null) {
            return a(this.ylb, getCursor());
        }
        t = a(null, getCursor());
        this.yld.put(Integer.valueOf(i), t);
        return t;
    }

    public boolean wK(int i) {
        return i >= this.count && i < this.count + bFs();
    }

    /* Access modifiers changed, original: protected */
    public int bFs() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public T bFt() {
        return this.ylb;
    }
}
