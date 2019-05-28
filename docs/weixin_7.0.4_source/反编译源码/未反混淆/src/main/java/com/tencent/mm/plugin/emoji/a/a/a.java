package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public abstract class a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String euI = "lock";
    public AbsListView kSO;
    public c kSP;
    public com.tencent.mm.plugin.emoji.model.i.a kSQ;
    protected volatile boolean kSR = false;
    private int kSS = 0;
    private int kST = 0;
    private HashMap<String, com.tencent.mm.plugin.emoji.a.a> kSz;
    protected Context mContext;

    public abstract View b(int i, View view, ViewGroup viewGroup);

    public abstract int bjw();

    public abstract int bjx();

    public abstract int bjy();

    public abstract com.tencent.mm.plugin.emoji.a.a d(Context context, View view);

    public abstract void tU(int i);

    public abstract void tV(int i);

    public abstract void tW(int i);

    public a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.kSz = new HashMap();
        }
    }

    public final void a(c cVar) {
        if (cVar != null && this.kSP != cVar) {
            this.kSP = cVar.bjC();
            notifyDataSetChanged();
        }
    }

    /* Access modifiers changed, original: protected */
    public void bjv() {
        if (this.kSz != null) {
            this.kSz.clear();
        }
        super.notifyDataSetChanged();
        this.kSR = true;
    }

    public void notifyDataSetChanged() {
        Object[] objArr;
        int i;
        this.kSR = false;
        if (this.kSP != null) {
            this.kSP.notifyDataSetChanged();
            objArr = new Object[1];
            i = this.kSS;
            this.kSS = i + 1;
            objArr[0] = Integer.valueOf(i);
            ab.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", objArr);
        }
        objArr = new Object[1];
        i = this.kST;
        this.kST = i + 1;
        objArr[0] = Integer.valueOf(i);
        ab.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", objArr);
        bjv();
    }

    public final void b(final f fVar) {
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52773);
                if (fVar == null) {
                    AppMethodBeat.o(52773);
                    return;
                }
                a.this.kSP = a.this.a(fVar);
                a.this.notifyDataSetChanged();
                AppMethodBeat.o(52773);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public c a(f fVar) {
        return new c(fVar);
    }

    public int getCount() {
        return this.kSP == null ? 0 : this.kSP.size();
    }

    /* renamed from: tX */
    public f getItem(int i) {
        return this.kSP == null ? null : this.kSP.ub(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.emoji.a.a aVar = null;
        if (view != null) {
            aVar = (com.tencent.mm.plugin.emoji.a.a) view.getTag();
        }
        f tX = getItem(i);
        if (aVar == null) {
            aVar = d(this.mContext, view);
            view = aVar.bjt();
            this.kSz.put(a(tX), aVar);
        } else if (!bo.isNullOrNil(a(tX))) {
            if (this.kSz.containsValue(aVar)) {
                this.kSz.remove(aVar.getProductId());
            }
            this.kSz.put(a(tX), aVar);
        }
        aVar.mPosition = i;
        aVar.kRB = tX;
        View b = b(i, view, viewGroup);
        aVar.bjs();
        return b;
    }

    public static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.kTa == com.tencent.mm.plugin.emoji.a.a.f.a.cellset) {
            return fVar.kTc.ID + "_cell";
        }
        return fVar.kTb.ProductID;
    }

    public void clear() {
        if (this.kSz != null) {
            this.kSz.clear();
            this.kSz = null;
        }
        if (this.kSP != null) {
            this.kSP.clear();
            this.kSP = null;
        }
        this.kSR = false;
    }

    public void bW(String str, int i) {
        if (this.kSz != null && this.kSP != null && str != null) {
            f IT = this.kSP.IT(str);
            if (IT != null) {
                a(IT, str, i);
            }
            if (!(IT == null || this.kSP == null || IT.mStatus != -1)) {
                ab.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                IT.a(this.kSP.kSY, this.kSP.IX(str), this.kSP.IV(str));
            }
            com.tencent.mm.plugin.emoji.a.a IS = IS(str);
            if (IS != null) {
                String productId = IS.getProductId() == null ? null : IS.getProductId();
                if (productId != null && productId.equals(str)) {
                    IS.bjs();
                }
            }
        }
    }

    public final com.tencent.mm.plugin.emoji.a.a IS(String str) {
        if (this.kSz == null) {
            return null;
        }
        return (com.tencent.mm.plugin.emoji.a.a) this.kSz.get(str);
    }

    public final void bX(String str, int i) {
        if (this.kSz != null && this.kSP != null && str != null) {
            f IT = this.kSP.IT(str);
            if (IT != null) {
                if (i >= 0 && i < 100) {
                    a(IT, str, 6);
                    IT.EV = i;
                }
                if (i >= 100) {
                    a(IT, str, 7);
                }
            }
            com.tencent.mm.plugin.emoji.a.a IS = IS(str);
            if (IS != null) {
                String productId = IS.getProductId() == null ? null : IS.getProductId();
                if (productId != null && productId.equals(str)) {
                    IS.bjs();
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(f fVar, String str, int i) {
        if (fVar != null && str != null) {
            fVar.setStatus(i);
            this.kSP.bY(str, i);
        }
    }

    public final void refreshView() {
        if (this.kSR) {
            super.notifyDataSetChanged();
        }
    }
}
