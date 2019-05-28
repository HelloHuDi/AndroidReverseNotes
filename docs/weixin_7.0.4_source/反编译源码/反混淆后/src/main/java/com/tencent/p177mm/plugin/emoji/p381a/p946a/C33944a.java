package com.tencent.p177mm.plugin.emoji.p381a.p946a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C11558a;
import com.tencent.p177mm.plugin.emoji.p381a.C45843a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f.C11547a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.emoji.a.a.a */
public abstract class C33944a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String euI = "lock";
    public AbsListView kSO;
    public C45842c kSP;
    public C11558a kSQ;
    protected volatile boolean kSR = false;
    private int kSS = 0;
    private int kST = 0;
    private HashMap<String, C45843a> kSz;
    protected Context mContext;

    /* renamed from: b */
    public abstract View mo7106b(int i, View view, ViewGroup viewGroup);

    public abstract int bjw();

    public abstract int bjx();

    public abstract int bjy();

    /* renamed from: d */
    public abstract C45843a mo7110d(Context context, View view);

    /* renamed from: tU */
    public abstract void mo7111tU(int i);

    /* renamed from: tV */
    public abstract void mo7112tV(int i);

    /* renamed from: tW */
    public abstract void mo7113tW(int i);

    public C33944a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.kSz = new HashMap();
        }
    }

    /* renamed from: a */
    public final void mo54488a(C45842c c45842c) {
        if (c45842c != null && this.kSP != c45842c) {
            this.kSP = c45842c.bjC();
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
            C4990ab.m7411d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", objArr);
        }
        objArr = new Object[1];
        i = this.kST;
        this.kST = i + 1;
        objArr[0] = Integer.valueOf(i);
        C4990ab.m7419v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", objArr);
        bjv();
    }

    /* renamed from: b */
    public final void mo54490b(final C20383f c20383f) {
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(52773);
                if (c20383f == null) {
                    AppMethodBeat.m2505o(52773);
                    return;
                }
                C33944a.this.kSP = C33944a.this.mo54487a(c20383f);
                C33944a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(52773);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C45842c mo54487a(C20383f c20383f) {
        return new C45842c(c20383f);
    }

    public int getCount() {
        return this.kSP == null ? 0 : this.kSP.size();
    }

    /* renamed from: tX */
    public C11546f getItem(int i) {
        return this.kSP == null ? null : this.kSP.mo73645ub(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C45843a c45843a = null;
        if (view != null) {
            c45843a = (C45843a) view.getTag();
        }
        C11546f tX = getItem(i);
        if (c45843a == null) {
            c45843a = mo7110d(this.mContext, view);
            view = c45843a.bjt();
            this.kSz.put(C33944a.m55544a(tX), c45843a);
        } else if (!C5046bo.isNullOrNil(C33944a.m55544a(tX))) {
            if (this.kSz.containsValue(c45843a)) {
                this.kSz.remove(c45843a.getProductId());
            }
            this.kSz.put(C33944a.m55544a(tX), c45843a);
        }
        c45843a.mPosition = i;
        c45843a.kRB = tX;
        View b = mo7106b(i, view, viewGroup);
        c45843a.bjs();
        return b;
    }

    /* renamed from: a */
    public static String m55544a(C11546f c11546f) {
        if (c11546f == null) {
            return null;
        }
        if (c11546f.kTa == C11547a.cellset) {
            return c11546f.kTc.f15073ID + "_cell";
        }
        return c11546f.kTb.ProductID;
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

    /* renamed from: bW */
    public void mo54491bW(String str, int i) {
        if (this.kSz != null && this.kSP != null && str != null) {
            C11546f IT = this.kSP.mo73635IT(str);
            if (IT != null) {
                mo54489a(IT, str, i);
            }
            if (!(IT == null || this.kSP == null || IT.mStatus != -1)) {
                C4990ab.m7416i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                IT.mo23260a(this.kSP.kSY, this.kSP.mo73639IX(str), this.kSP.mo73637IV(str));
            }
            C45843a IS = mo54486IS(str);
            if (IS != null) {
                String productId = IS.getProductId() == null ? null : IS.getProductId();
                if (productId != null && productId.equals(str)) {
                    IS.bjs();
                }
            }
        }
    }

    /* renamed from: IS */
    public final C45843a mo54486IS(String str) {
        if (this.kSz == null) {
            return null;
        }
        return (C45843a) this.kSz.get(str);
    }

    /* renamed from: bX */
    public final void mo54492bX(String str, int i) {
        if (this.kSz != null && this.kSP != null && str != null) {
            C11546f IT = this.kSP.mo73635IT(str);
            if (IT != null) {
                if (i >= 0 && i < 100) {
                    mo54489a(IT, str, 6);
                    IT.f2905EV = i;
                }
                if (i >= 100) {
                    mo54489a(IT, str, 7);
                }
            }
            C45843a IS = mo54486IS(str);
            if (IS != null) {
                String productId = IS.getProductId() == null ? null : IS.getProductId();
                if (productId != null && productId.equals(str)) {
                    IS.bjs();
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo54489a(C11546f c11546f, String str, int i) {
        if (c11546f != null && str != null) {
            c11546f.setStatus(i);
            this.kSP.mo73640bY(str, i);
        }
    }

    public final void refreshView() {
        if (this.kSR) {
            super.notifyDataSetChanged();
        }
    }
}
