package com.tencent.p177mm.plugin.emoji.p381a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.emoji.a.h */
public final class C45844h extends C33944a {
    private int iWJ;
    private int iYI;
    public int kSp = 0;
    private int kSu;
    private int kSv;
    private int kSw;
    private boolean kSx;
    public C42932a kSy;
    private HashMap<String, C38871b> kSz;
    private Context mContext;
    private int mNumColumns = 3;

    /* renamed from: com.tencent.mm.plugin.emoji.a.h$a */
    public interface C42932a {
        /* renamed from: tY */
        void mo61773tY(int i);
    }

    /* renamed from: com.tencent.mm.plugin.emoji.a.h$b */
    class C42933b {
        LinearLayout kSC;

        C42933b() {
        }
    }

    public C45844h(Context context) {
        super(context);
        AppMethodBeat.m2504i(52757);
        this.mContext = context;
        this.kSx = false;
        this.kSu = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
        this.kSv = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9727ds);
        this.iYI = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a0k);
        this.kSw = C1338a.m2868gd(this.mContext);
        this.iWJ = (int) (((float) (this.kSw - (this.mNumColumns * this.iYI))) / (((float) this.mNumColumns) + 1.0f));
        AppMethodBeat.m2505o(52757);
    }

    public final int bjB() {
        AppMethodBeat.m2504i(52758);
        int count;
        if (!this.kSx) {
            count = super.getCount();
            AppMethodBeat.m2505o(52758);
            return count;
        } else if (this.kSp == 0) {
            AppMethodBeat.m2505o(52758);
            return 0;
        } else if (this.kSp <= 0 || super.getCount() <= this.kSp) {
            count = super.getCount();
            AppMethodBeat.m2505o(52758);
            return count;
        } else {
            count = this.kSp;
            AppMethodBeat.m2505o(52758);
            return count;
        }
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.m2504i(52759);
        if (!this.kSx) {
            int bjB = bjB();
            if (bjB > this.kSp) {
                i = (int) Math.ceil((double) (((float) (bjB - this.kSp)) / ((float) this.mNumColumns)));
            }
            AppMethodBeat.m2505o(52759);
            return i;
        } else if (this.kSp == 0) {
            AppMethodBeat.m2505o(52759);
            return 0;
        } else if (this.kSp <= 0 || bjB() <= this.kSp) {
            i = (int) Math.ceil((double) (((float) bjB()) / ((float) this.mNumColumns)));
            AppMethodBeat.m2505o(52759);
            return i;
        } else {
            i = (int) Math.ceil((double) (((float) this.kSp) / ((float) this.mNumColumns)));
            AppMethodBeat.m2505o(52759);
            return i;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C42933b c42933b;
        AppMethodBeat.m2504i(52760);
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            view.setBackgroundResource(C25738R.drawable.a8g);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.kSv);
            C42933b c42933b2 = new C42933b();
            c42933b2.kSC = view;
            view.setTag(c42933b2);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = this.iWJ;
                c42933b2.kSC.addView(new C38871b(this.mContext).kRR, i2, layoutParams2);
            }
            c42933b = c42933b2;
        } else {
            c42933b = (C42933b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            int i4;
            if (this.kSx) {
                i4 = this.mNumColumns * i;
            } else {
                i4 = (this.mNumColumns * i) + this.kSp;
            }
            i4 += i3;
            final C38871b c38871b = new C38871b(this.mContext, c42933b.kSC.getChildAt(i3));
            c38871b.kRR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(52756);
                    if (C45844h.this.kSy != null) {
                        C45844h.this.kSy.mo61773tY(i4);
                    }
                    AppMethodBeat.m2505o(52756);
                }
            });
            C11546f tX = getItem(i4);
            if (i4 > bjB() - 1 || tX == null) {
                c38871b.kRR.setClickable(false);
                c38871b.kRR.setVisibility(8);
                c38871b.kSb.setBackgroundDrawable(null);
            } else {
                if (this.kSz == null) {
                    this.kSz = new HashMap();
                }
                if (this.kSz.containsValue(c38871b)) {
                    this.kSz.remove(c38871b.kRZ);
                }
                c38871b.kRZ = C33944a.m55544a(tX);
                this.kSz.put(C33944a.m55544a(tX), c38871b);
                c38871b.kRR.setVisibility(0);
                c38871b.klC.setText(tX.kTb.PackName);
                C32291o.ahp().mo43766a(tX.kTb.IconUrl, c38871b.kSa, C20364g.m31459dH(tX.kTb.ProductID, tX.kTb.IconUrl));
                c38871b.kSb.setBackgroundResource(C25738R.drawable.emoji_grid_item_fg);
                c38871b.kRR.setClickable(true);
                m84877a(c38871b, tX.mStatus);
            }
        }
        AppMethodBeat.m2505o(52760);
        return view;
    }

    /* renamed from: a */
    private void m84877a(C38871b c38871b, int i) {
        AppMethodBeat.m2504i(52761);
        switch (i) {
            case 7:
                c38871b.klC.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12084rr));
                Drawable drawable = this.mContext.getResources().getDrawable(C1318a.emoji_download_finish);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                c38871b.klC.setCompoundDrawables(null, null, drawable, null);
                AppMethodBeat.m2505o(52761);
                return;
            default:
                c38871b.klC.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12212w4));
                c38871b.klC.setCompoundDrawables(null, null, null, null);
                C4990ab.m7421w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", Integer.valueOf(i));
                AppMethodBeat.m2505o(52761);
                return;
        }
    }

    /* renamed from: d */
    public final C45843a mo7110d(Context context, View view) {
        return null;
    }

    public final int bjw() {
        return this.kSp;
    }

    /* renamed from: tU */
    public final void mo7111tU(int i) {
        this.kSp = i;
    }

    public final int bjx() {
        return 0;
    }

    /* renamed from: tV */
    public final void mo7112tV(int i) {
    }

    public final int bjy() {
        return 0;
    }

    /* renamed from: tW */
    public final void mo7113tW(int i) {
    }

    /* renamed from: b */
    public final View mo7106b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    /* renamed from: bW */
    public final void mo54491bW(String str, int i) {
        AppMethodBeat.m2504i(52762);
        if (this.kSz == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
            AppMethodBeat.m2505o(52762);
            return;
        }
        C38871b c38871b = (C38871b) this.kSz.get(str);
        C11546f IT = this.kSP.mo73635IT(str);
        if (IT != null) {
            mo54489a(IT, str, i);
        }
        if (!(IT == null || this.kSP == null || IT.mStatus != -1)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
            IT.mo23260a(this.kSP.kSY, this.kSP.mo73639IX(str), this.kSP.mo73637IV(str));
        }
        if (c38871b == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
            AppMethodBeat.m2505o(52762);
            return;
        }
        m84877a(c38871b, i);
        AppMethodBeat.m2505o(52762);
    }
}
