package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201J\u001c\u00102\u001a\u00020)2\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u00020\u001aR\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
public final class f extends v {
    public TextView gne;
    public TextView hrg;
    public CdnImageView kqn;
    public MemberCardTopCropImageView kqo;
    public LinearLayout kqp;
    public ImageView kqq;

    public f(View view, int i) {
        j.p(view, "itemView");
        super(view);
        AppMethodBeat.i(89330);
        View findViewById;
        CdnImageView cdnImageView;
        switch (i) {
            case 0:
                findViewById = view.findViewById(R.id.ah2);
                j.o(findViewById, "itemView.findViewById(R.id.card_list_header_text)");
                this.gne = (TextView) findViewById;
                AppMethodBeat.o(89330);
                return;
            case 1:
                findViewById = view.findViewById(R.id.ags);
                j.o(findViewById, "itemView.findViewById(R.id.clni_icon_iv)");
                this.kqn = (CdnImageView) findViewById;
                findViewById = view.findViewById(R.id.agt);
                j.o(findViewById, "itemView.findViewById(R.id.clni_title_tv)");
                this.gne = (TextView) findViewById;
                findViewById = view.findViewById(R.id.agu);
                j.o(findViewById, "itemView.findViewById(R.id.clni_desc_tv)");
                this.hrg = (TextView) findViewById;
                cdnImageView = this.kqn;
                if (cdnImageView == null) {
                    j.avw("logoIv");
                }
                cdnImageView.setUseSdcardCache(true);
                AppMethodBeat.o(89330);
                return;
            case 2:
                findViewById = view.findViewById(R.id.ak5);
                j.o(findViewById, "itemView.findViewById(R.id.ctci_logo_iv)");
                this.kqn = (CdnImageView) findViewById;
                findViewById = view.findViewById(R.id.ak6);
                j.o(findViewById, "itemView.findViewById(R.id.ctci_title_tv)");
                this.gne = (TextView) findViewById;
                findViewById = view.findViewById(R.id.ak7);
                j.o(findViewById, "itemView.findViewById(R.id.ctci_desc_tv)");
                this.hrg = (TextView) findViewById;
                findViewById = view.findViewById(R.id.ak3);
                j.o(findViewById, "itemView.findViewById(R.id.ctci_bg_iv)");
                this.kqo = (MemberCardTopCropImageView) findViewById;
                findViewById = view.findViewById(R.id.ak4);
                j.o(findViewById, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
                this.kqq = (ImageView) findViewById;
                findViewById = view.findViewById(R.id.ak8);
                j.o(findViewById, "itemView.findViewById(R.….ctci_right_label_layout)");
                this.kqp = (LinearLayout) findViewById;
                cdnImageView = this.kqn;
                if (cdnImageView == null) {
                    j.avw("logoIv");
                }
                cdnImageView.setUseSdcardCache(true);
                break;
        }
        AppMethodBeat.o(89330);
    }

    public static void a(ImageView imageView, String str) {
        AppMethodBeat.i(89329);
        j.p(imageView, "imageView");
        j.p(str, "url");
        a aVar = new a();
        aVar.sD(e.eSn);
        aVar.a(o.ahq());
        aVar.sC(m.Gz(str));
        aVar.ahD();
        aVar.ahF();
        aVar.ahC();
        aVar.lK(R.drawable.gp);
        aVar.lJ(com.tencent.mm.bz.a.fromDPToPix(imageView.getContext(), 84));
        aVar.lI(com.tencent.mm.bz.a.gd(imageView.getContext()));
        o.ahp().a(str, imageView, aVar.ahG());
        imageView.setImageMatrix(new Matrix());
        AppMethodBeat.o(89329);
    }
}
