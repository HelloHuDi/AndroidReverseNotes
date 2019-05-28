package com.tencent.p177mm.plugin.card.p355ui.p356v2;

import android.graphics.Matrix;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201J\u001c\u00102\u001a\u00020)2\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u00020\u001aR\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.ui.v2.f */
public final class C20195f extends C41531v {
    public TextView gne;
    public TextView hrg;
    public CdnImageView kqn;
    public MemberCardTopCropImageView kqo;
    public LinearLayout kqp;
    public ImageView kqq;

    public C20195f(View view, int i) {
        C25052j.m39376p(view, "itemView");
        super(view);
        AppMethodBeat.m2504i(89330);
        View findViewById;
        CdnImageView cdnImageView;
        switch (i) {
            case 0:
                findViewById = view.findViewById(2131822212);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.card_list_header_text)");
                this.gne = (TextView) findViewById;
                AppMethodBeat.m2505o(89330);
                return;
            case 1:
                findViewById = view.findViewById(2131822202);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.clni_icon_iv)");
                this.kqn = (CdnImageView) findViewById;
                findViewById = view.findViewById(2131822203);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.clni_title_tv)");
                this.gne = (TextView) findViewById;
                findViewById = view.findViewById(2131822204);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.clni_desc_tv)");
                this.hrg = (TextView) findViewById;
                cdnImageView = this.kqn;
                if (cdnImageView == null) {
                    C25052j.avw("logoIv");
                }
                cdnImageView.setUseSdcardCache(true);
                AppMethodBeat.m2505o(89330);
                return;
            case 2:
                findViewById = view.findViewById(2131822326);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.ctci_logo_iv)");
                this.kqn = (CdnImageView) findViewById;
                findViewById = view.findViewById(2131822327);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.ctci_title_tv)");
                this.gne = (TextView) findViewById;
                findViewById = view.findViewById(2131822328);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.ctci_desc_tv)");
                this.hrg = (TextView) findViewById;
                findViewById = view.findViewById(2131822324);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.ctci_bg_iv)");
                this.kqo = (MemberCardTopCropImageView) findViewById;
                findViewById = view.findViewById(2131822325);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
                this.kqq = (ImageView) findViewById;
                findViewById = view.findViewById(2131822329);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.….ctci_right_label_layout)");
                this.kqp = (LinearLayout) findViewById;
                cdnImageView = this.kqn;
                if (cdnImageView == null) {
                    C25052j.avw("logoIv");
                }
                cdnImageView.setUseSdcardCache(true);
                break;
        }
        AppMethodBeat.m2505o(89330);
    }

    /* renamed from: a */
    public static void m31236a(ImageView imageView, String str) {
        AppMethodBeat.m2504i(89329);
        C25052j.m39376p(imageView, "imageView");
        C25052j.m39376p(str, "url");
        C17927a c17927a = new C17927a();
        c17927a.mo33453sD(C6457e.eSn);
        c17927a.mo33442a(C32291o.ahq());
        c17927a.mo33452sC(C33770m.m55183Gz(str));
        c17927a.ahD();
        c17927a.ahF();
        c17927a.ahC();
        c17927a.mo33451lK(C25738R.drawable.f6514gp);
        c17927a.mo33450lJ(C1338a.fromDPToPix(imageView.getContext(), 84));
        c17927a.mo33449lI(C1338a.m2868gd(imageView.getContext()));
        C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        imageView.setImageMatrix(new Matrix());
        AppMethodBeat.m2505o(89329);
    }
}
