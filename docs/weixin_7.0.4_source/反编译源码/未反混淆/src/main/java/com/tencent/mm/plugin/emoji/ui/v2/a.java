package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter {
    private int iWJ;
    private int iYI;
    List<xx> kSg;
    private int kSw;
    private boolean lgk;
    private LayoutParams lgl;
    private LayoutParams lgm;
    a lgn;
    private Context mContext;
    private int mNumColumns;

    interface a {
        void tY(int i);
    }

    class b {
        LinearLayout kSC;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(53847);
        xx uo = uo(i);
        AppMethodBeat.o(53847);
        return uo;
    }

    public a(Context context) {
        AppMethodBeat.i(53841);
        this.mNumColumns = 3;
        this.lgk = true;
        this.mNumColumns = 3;
        this.mContext = context;
        this.kSw = com.tencent.mm.bz.a.gd(this.mContext);
        this.iYI = this.mContext.getResources().getDimensionPixelSize(R.dimen.a0k);
        this.iWJ = (int) (((float) (this.kSw - (this.mNumColumns * this.iYI))) / (((float) this.mNumColumns) + 1.0f));
        AppMethodBeat.o(53841);
    }

    public final void bw(List<xx> list) {
        AppMethodBeat.i(53842);
        if (this.kSg == null) {
            this.kSg = new ArrayList();
        } else {
            this.kSg.clear();
        }
        this.kSg = list;
        notifyDataSetChanged();
        AppMethodBeat.o(53842);
    }

    private int getRealCount() {
        AppMethodBeat.i(53843);
        if (this.kSg == null) {
            AppMethodBeat.o(53843);
            return 0;
        }
        int size = this.kSg.size();
        AppMethodBeat.o(53843);
        return size;
    }

    public final int getCount() {
        AppMethodBeat.i(53844);
        if (this.kSg == null) {
            AppMethodBeat.o(53844);
            return 0;
        }
        int ceil = (int) Math.ceil((double) (((float) this.kSg.size()) / ((float) this.mNumColumns)));
        AppMethodBeat.o(53844);
        return ceil;
    }

    public final xx uo(int i) {
        AppMethodBeat.i(53845);
        if (i < 0 || i >= getRealCount()) {
            AppMethodBeat.o(53845);
            return null;
        } else if (this.kSg == null) {
            AppMethodBeat.o(53845);
            return null;
        } else {
            xx xxVar = (xx) this.kSg.get(i);
            AppMethodBeat.o(53845);
            return xxVar;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        AppMethodBeat.i(53846);
        if (view == null || view.getTag() == null) {
            view = v.hu(this.mContext).inflate(R.layout.uz, null);
            bVar = new b();
            bVar.kSC = (LinearLayout) view.findViewById(R.id.be6);
            bVar.kSC.setPadding(0, this.iWJ, 0, 0);
            view.setTag(bVar);
            for (i2 = 0; i2 < this.mNumColumns; i2++) {
                this.lgm = new LayoutParams(-2, -2);
                this.lgm.leftMargin = this.iWJ;
                this.lgl = new LayoutParams(this.iYI, this.iYI);
                PaddingImageView paddingImageView = new PaddingImageView(this.mContext);
                LayoutParams layoutParams = this.lgl;
                paddingImageView.addView(paddingImageView.ikh, layoutParams);
                paddingImageView.addView(paddingImageView.lgi, layoutParams);
                bVar.kSC.addView(paddingImageView, i2, this.lgm);
            }
        } else {
            bVar = (b) view.getTag();
        }
        i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mNumColumns) {
                final int i4 = (this.mNumColumns * i) + i3;
                final PaddingImageView paddingImageView2 = (PaddingImageView) bVar.kSC.getChildAt(i3);
                if (i4 <= getRealCount() - 1) {
                    xx uo = uo(i4);
                    if (uo != null) {
                        if (!bo.isNullOrNil(uo.ThumbUrl)) {
                            o.ahp().a(uo.ThumbUrl, paddingImageView2.getImageView(), g.a(EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", uo.Md5) + "_cover", this.iYI, new Object[0]));
                        } else if (bo.isNullOrNil(uo.Url)) {
                            ab.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                        } else {
                            j.bjW().a(uo.Url, paddingImageView2.getImageView(), g.a(EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", uo.Md5), this.iYI, new Object[0]));
                        }
                        paddingImageView2.setClickable(true);
                        paddingImageView2.getImageViewFG().setBackgroundResource(R.drawable.emoji_grid_item_seq_fg);
                        paddingImageView2.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(53840);
                                if (a.this.lgn != null) {
                                    a.this.lgn.tY(i4);
                                }
                                AppMethodBeat.o(53840);
                            }
                        });
                    } else {
                        paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                        o.ahp().a("", paddingImageView2.getImageView());
                        ab.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                        paddingImageView2.setClickable(false);
                        paddingImageView2.setOnClickListener(null);
                    }
                } else {
                    paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                    o.ahp().a("", paddingImageView2.getImageView());
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(53846);
                return view;
            }
        }
    }
}
