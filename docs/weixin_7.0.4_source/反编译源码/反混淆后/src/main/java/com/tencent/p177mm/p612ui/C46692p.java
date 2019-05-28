package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.p */
public abstract class C46692p<T> extends BaseAdapter implements C4931a, C4937b {
    public Context context;
    protected int count;
    private C7306ak mty = new C7306ak(Looper.getMainLooper());
    protected T ylb;
    private Cursor ylc = null;
    protected Map<Integer, T> yld = null;
    protected C30723a yle;
    private int ylf = 0;
    private int ylg = 0;
    private int ylh = 0;
    private Runnable yli = new C443791();

    /* renamed from: com.tencent.mm.ui.p$a */
    public interface C30723a {
        void apt();
    }

    /* renamed from: com.tencent.mm.ui.p$1 */
    class C443791 implements Runnable {
        C443791() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105984);
            if (C46692p.this.ylf != 0) {
                C4990ab.m7419v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", Integer.valueOf(C46692p.this.ylf), Integer.valueOf(C46692p.m88440b(C46692p.this)));
                C46692p.this.mty.removeCallbacks(C46692p.this.yli);
                if (20 > C46692p.this.ylh) {
                    C46692p.this.mty.postDelayed(C46692p.this.yli, 100);
                    AppMethodBeat.m2505o(105984);
                    return;
                }
                C4990ab.m7421w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", Integer.valueOf(C46692p.this.ylf), Integer.valueOf(C46692p.this.ylh));
            }
            C4990ab.m7410d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
            C46692p.this.ylh = 0;
            C46692p.this.dxQ();
            AppMethodBeat.m2505o(105984);
        }
    }

    /* renamed from: KC */
    public abstract void mo6869KC();

    /* renamed from: KD */
    public abstract void mo6870KD();

    /* renamed from: a */
    public abstract T mo7687a(T t, Cursor cursor);

    /* renamed from: b */
    static /* synthetic */ int m88440b(C46692p c46692p) {
        int i = c46692p.ylh + 1;
        c46692p.ylh = i;
        return i;
    }

    public C46692p(Context context, T t) {
        this.ylb = t;
        this.context = context;
        this.count = -1;
    }

    /* Access modifiers changed, original: protected|final */
    public final Cursor getCursor() {
        if (this.ylc == null || this.ylc.isClosed()) {
            mo6870KD();
            Assert.assertNotNull(this.ylc);
        }
        return this.ylc;
    }

    public final void setCursor(Cursor cursor) {
        this.ylc = cursor;
        this.count = -1;
    }

    /* renamed from: pN */
    public final void mo74996pN(boolean z) {
        if (z) {
            if (this.yld == null) {
                this.yld = new HashMap();
            }
        } else if (this.yld != null) {
            this.yld.clear();
            this.yld = null;
        }
    }

    /* renamed from: a */
    public final void mo74992a(C30723a c30723a) {
        this.yle = c30723a;
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

    /* renamed from: a */
    public void mo10136a(int i, C7298n c7298n, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            return;
        }
        mo5248a((String) obj, null);
    }

    /* renamed from: a */
    public void mo5248a(String str, C4935m c4935m) {
        dxQ();
    }

    private void dxQ() {
        C4990ab.m7418v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        bIf();
        mo6869KC();
        if (this.yle != null) {
            this.yle.apt();
        }
    }

    public T getItem(int i) {
        if (mo10892wK(i)) {
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
            return mo7687a(this.ylb, getCursor());
        }
        t = mo7687a(null, getCursor());
        this.yld.put(Integer.valueOf(i), t);
        return t;
    }

    /* renamed from: wK */
    public boolean mo10892wK(int i) {
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
