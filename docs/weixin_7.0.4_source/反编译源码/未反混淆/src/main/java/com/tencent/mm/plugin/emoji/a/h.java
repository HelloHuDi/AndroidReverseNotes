package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class h extends com.tencent.mm.plugin.emoji.a.a.a {
    private int iWJ;
    private int iYI;
    public int kSp = 0;
    private int kSu;
    private int kSv;
    private int kSw;
    private boolean kSx;
    public a kSy;
    private HashMap<String, b> kSz;
    private Context mContext;
    private int mNumColumns = 3;

    public interface a {
        void tY(int i);
    }

    class b {
        LinearLayout kSC;

        b() {
        }
    }

    public h(Context context) {
        super(context);
        AppMethodBeat.i(52757);
        this.mContext = context;
        this.kSx = false;
        this.kSu = this.mContext.getResources().getDimensionPixelSize(R.dimen.m4);
        this.kSv = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds);
        this.iYI = this.mContext.getResources().getDimensionPixelSize(R.dimen.a0k);
        this.kSw = com.tencent.mm.bz.a.gd(this.mContext);
        this.iWJ = (int) (((float) (this.kSw - (this.mNumColumns * this.iYI))) / (((float) this.mNumColumns) + 1.0f));
        AppMethodBeat.o(52757);
    }

    public final int bjB() {
        AppMethodBeat.i(52758);
        int count;
        if (!this.kSx) {
            count = super.getCount();
            AppMethodBeat.o(52758);
            return count;
        } else if (this.kSp == 0) {
            AppMethodBeat.o(52758);
            return 0;
        } else if (this.kSp <= 0 || super.getCount() <= this.kSp) {
            count = super.getCount();
            AppMethodBeat.o(52758);
            return count;
        } else {
            count = this.kSp;
            AppMethodBeat.o(52758);
            return count;
        }
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.i(52759);
        if (!this.kSx) {
            int bjB = bjB();
            if (bjB > this.kSp) {
                i = (int) Math.ceil((double) (((float) (bjB - this.kSp)) / ((float) this.mNumColumns)));
            }
            AppMethodBeat.o(52759);
            return i;
        } else if (this.kSp == 0) {
            AppMethodBeat.o(52759);
            return 0;
        } else if (this.kSp <= 0 || bjB() <= this.kSp) {
            i = (int) Math.ceil((double) (((float) bjB()) / ((float) this.mNumColumns)));
            AppMethodBeat.o(52759);
            return i;
        } else {
            i = (int) Math.ceil((double) (((float) this.kSp) / ((float) this.mNumColumns)));
            AppMethodBeat.o(52759);
            return i;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(52760);
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            view.setBackgroundResource(R.drawable.a8g);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.kSv);
            b bVar2 = new b();
            bVar2.kSC = view;
            view.setTag(bVar2);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = this.iWJ;
                bVar2.kSC.addView(new b(this.mContext).kRR, i2, layoutParams2);
            }
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            int i4;
            if (this.kSx) {
                i4 = this.mNumColumns * i;
            } else {
                i4 = (this.mNumColumns * i) + this.kSp;
            }
            i4 += i3;
            final b bVar3 = new b(this.mContext, bVar.kSC.getChildAt(i3));
            bVar3.kRR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(52756);
                    if (h.this.kSy != null) {
                        h.this.kSy.tY(i4);
                    }
                    AppMethodBeat.o(52756);
                }
            });
            f tX = getItem(i4);
            if (i4 > bjB() - 1 || tX == null) {
                bVar3.kRR.setClickable(false);
                bVar3.kRR.setVisibility(8);
                bVar3.kSb.setBackgroundDrawable(null);
            } else {
                if (this.kSz == null) {
                    this.kSz = new HashMap();
                }
                if (this.kSz.containsValue(bVar3)) {
                    this.kSz.remove(bVar3.kRZ);
                }
                bVar3.kRZ = com.tencent.mm.plugin.emoji.a.a.a.a(tX);
                this.kSz.put(com.tencent.mm.plugin.emoji.a.a.a.a(tX), bVar3);
                bVar3.kRR.setVisibility(0);
                bVar3.klC.setText(tX.kTb.PackName);
                o.ahp().a(tX.kTb.IconUrl, bVar3.kSa, g.dH(tX.kTb.ProductID, tX.kTb.IconUrl));
                bVar3.kSb.setBackgroundResource(R.drawable.emoji_grid_item_fg);
                bVar3.kRR.setClickable(true);
                a(bVar3, tX.mStatus);
            }
        }
        AppMethodBeat.o(52760);
        return view;
    }

    private void a(b bVar, int i) {
        AppMethodBeat.i(52761);
        switch (i) {
            case 7:
                bVar.klC.setTextColor(this.mContext.getResources().getColor(R.color.rr));
                Drawable drawable = this.mContext.getResources().getDrawable(R.raw.emoji_download_finish);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bVar.klC.setCompoundDrawables(null, null, drawable, null);
                AppMethodBeat.o(52761);
                return;
            default:
                bVar.klC.setTextColor(this.mContext.getResources().getColor(R.color.w4));
                bVar.klC.setCompoundDrawables(null, null, null, null);
                ab.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", Integer.valueOf(i));
                AppMethodBeat.o(52761);
                return;
        }
    }

    public final a d(Context context, View view) {
        return null;
    }

    public final int bjw() {
        return this.kSp;
    }

    public final void tU(int i) {
        this.kSp = i;
    }

    public final int bjx() {
        return 0;
    }

    public final void tV(int i) {
    }

    public final int bjy() {
        return 0;
    }

    public final void tW(int i) {
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public final void bW(String str, int i) {
        AppMethodBeat.i(52762);
        if (this.kSz == null) {
            ab.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
            AppMethodBeat.o(52762);
            return;
        }
        b bVar = (b) this.kSz.get(str);
        f IT = this.kSP.IT(str);
        if (IT != null) {
            a(IT, str, i);
        }
        if (!(IT == null || this.kSP == null || IT.mStatus != -1)) {
            ab.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
            IT.a(this.kSP.kSY, this.kSP.IX(str), this.kSP.IV(str));
        }
        if (bVar == null) {
            ab.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
            AppMethodBeat.o(52762);
            return;
        }
        a(bVar, i);
        AppMethodBeat.o(52762);
    }
}
