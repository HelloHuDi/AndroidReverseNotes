package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.a */
public final class C11603a extends BaseAdapter {
    private int iWJ;
    private int iYI;
    List<C40588xx> kSg;
    private int kSw;
    private boolean lgk;
    private LayoutParams lgl;
    private LayoutParams lgm;
    C11601a lgn;
    private Context mContext;
    private int mNumColumns;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.a$a */
    interface C11601a {
        /* renamed from: tY */
        void mo23327tY(int i);
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.a$b */
    class C11602b {
        LinearLayout kSC;

        C11602b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(53847);
        C40588xx uo = mo23333uo(i);
        AppMethodBeat.m2505o(53847);
        return uo;
    }

    public C11603a(Context context) {
        AppMethodBeat.m2504i(53841);
        this.mNumColumns = 3;
        this.lgk = true;
        this.mNumColumns = 3;
        this.mContext = context;
        this.kSw = C1338a.m2868gd(this.mContext);
        this.iYI = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a0k);
        this.iWJ = (int) (((float) (this.kSw - (this.mNumColumns * this.iYI))) / (((float) this.mNumColumns) + 1.0f));
        AppMethodBeat.m2505o(53841);
    }

    /* renamed from: bw */
    public final void mo23328bw(List<C40588xx> list) {
        AppMethodBeat.m2504i(53842);
        if (this.kSg == null) {
            this.kSg = new ArrayList();
        } else {
            this.kSg.clear();
        }
        this.kSg = list;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(53842);
    }

    private int getRealCount() {
        AppMethodBeat.m2504i(53843);
        if (this.kSg == null) {
            AppMethodBeat.m2505o(53843);
            return 0;
        }
        int size = this.kSg.size();
        AppMethodBeat.m2505o(53843);
        return size;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(53844);
        if (this.kSg == null) {
            AppMethodBeat.m2505o(53844);
            return 0;
        }
        int ceil = (int) Math.ceil((double) (((float) this.kSg.size()) / ((float) this.mNumColumns)));
        AppMethodBeat.m2505o(53844);
        return ceil;
    }

    /* renamed from: uo */
    public final C40588xx mo23333uo(int i) {
        AppMethodBeat.m2504i(53845);
        if (i < 0 || i >= getRealCount()) {
            AppMethodBeat.m2505o(53845);
            return null;
        } else if (this.kSg == null) {
            AppMethodBeat.m2505o(53845);
            return null;
        } else {
            C40588xx c40588xx = (C40588xx) this.kSg.get(i);
            AppMethodBeat.m2505o(53845);
            return c40588xx;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C11602b c11602b;
        int i2;
        AppMethodBeat.m2504i(53846);
        if (view == null || view.getTag() == null) {
            view = C5616v.m8409hu(this.mContext).inflate(2130969380, null);
            c11602b = new C11602b();
            c11602b.kSC = (LinearLayout) view.findViewById(2131823473);
            c11602b.kSC.setPadding(0, this.iWJ, 0, 0);
            view.setTag(c11602b);
            for (i2 = 0; i2 < this.mNumColumns; i2++) {
                this.lgm = new LayoutParams(-2, -2);
                this.lgm.leftMargin = this.iWJ;
                this.lgl = new LayoutParams(this.iYI, this.iYI);
                PaddingImageView paddingImageView = new PaddingImageView(this.mContext);
                LayoutParams layoutParams = this.lgl;
                paddingImageView.addView(paddingImageView.ikh, layoutParams);
                paddingImageView.addView(paddingImageView.lgi, layoutParams);
                c11602b.kSC.addView(paddingImageView, i2, this.lgm);
            }
        } else {
            c11602b = (C11602b) view.getTag();
        }
        i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mNumColumns) {
                final int i4 = (this.mNumColumns * i) + i3;
                final PaddingImageView paddingImageView2 = (PaddingImageView) c11602b.kSC.getChildAt(i3);
                if (i4 <= getRealCount() - 1) {
                    C40588xx uo = mo23333uo(i4);
                    if (uo != null) {
                        if (!C5046bo.isNullOrNil(uo.ThumbUrl)) {
                            C32291o.ahp().mo43766a(uo.ThumbUrl, paddingImageView2.getImageView(), C20364g.m31458a(EmojiLogic.m44073L(C2933b.m5221Yb(), "", uo.Md5) + "_cover", this.iYI, new Object[0]));
                        } else if (C5046bo.isNullOrNil(uo.Url)) {
                            C4990ab.m7420w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                        } else {
                            C42952j.bjW().mo43766a(uo.Url, paddingImageView2.getImageView(), C20364g.m31458a(EmojiLogic.m44073L(C2933b.m5221Yb(), "", uo.Md5), this.iYI, new Object[0]));
                        }
                        paddingImageView2.setClickable(true);
                        paddingImageView2.getImageViewFG().setBackgroundResource(C25738R.drawable.emoji_grid_item_seq_fg);
                        paddingImageView2.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(53840);
                                if (C11603a.this.lgn != null) {
                                    C11603a.this.lgn.mo23327tY(i4);
                                }
                                AppMethodBeat.m2505o(53840);
                            }
                        });
                    } else {
                        paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                        C32291o.ahp().mo43765a("", paddingImageView2.getImageView());
                        C4990ab.m7420w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                        paddingImageView2.setClickable(false);
                        paddingImageView2.setOnClickListener(null);
                    }
                } else {
                    paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                    C32291o.ahp().mo43765a("", paddingImageView2.getImageView());
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(53846);
                return view;
            }
        }
    }
}
