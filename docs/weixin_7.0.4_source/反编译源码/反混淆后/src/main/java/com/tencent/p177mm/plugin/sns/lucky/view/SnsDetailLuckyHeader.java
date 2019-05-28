package com.tencent.p177mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C39742m;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.p520ui.C13679h;
import com.tencent.p177mm.plugin.sns.p520ui.SnsCommentDetailUI;
import com.tencent.p177mm.plugin.sns.p520ui.TouchImageView;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.cbb;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbu;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader */
public class SnsDetailLuckyHeader extends LinearLayout {
    private View iym = null;
    private TextView qHh;
    private LinearLayout qHi;
    private LinearLayout qHj;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(35904);
        init();
        AppMethodBeat.m2505o(35904);
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        AppMethodBeat.m2504i(35905);
        init();
        AppMethodBeat.m2505o(35905);
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(35906);
        init();
        AppMethodBeat.m2505o(35906);
    }

    private void init() {
        AppMethodBeat.m2504i(35907);
        View inflate = View.inflate(getContext(), 2130970006, this);
        this.iym = inflate.findViewById(2131825678);
        this.qHh = (TextView) inflate.findViewById(2131825679);
        this.qHi = (LinearLayout) inflate.findViewById(2131825681);
        this.qHj = getLinearSeparator();
        AppMethodBeat.m2505o(35907);
    }

    public LinearLayout getLinearSeparator() {
        AppMethodBeat.m2504i(35908);
        C4977b.m7371b(getContext(), 2.0f);
        LayoutParams layoutParams = new LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(C25738R.drawable.a13);
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(35908);
        return linearLayout;
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(35909);
        super.setVisibility(i);
        if (this.iym != null) {
            this.iym.setVisibility(i);
        }
        AppMethodBeat.m2505o(35909);
    }

    /* renamed from: a */
    public final void mo8593a(C46236n c46236n, C22089b c22089b) {
        AppMethodBeat.m2504i(35910);
        cbf q = C34955aj.m57409q(c46236n);
        cbu cbu = q.xaE;
        if (cbu == null || cbu.xbh.size() == 0) {
            setVisibility(8);
            AppMethodBeat.m2505o(35910);
            return;
        }
        setVisibility(0);
        double b = ((double) C39742m.m67969b(c46236n, q)) * 1.0d;
        this.qHh.setText(getContext().getString(C25738R.string.emn, new Object[]{Integer.valueOf(q.xaE.xbg), C5046bo.m7501F(b / 100.0d)}));
        this.iym.setTag(c46236n);
        this.iym.setOnClickListener(c22089b.rJT);
        LinkedList linkedList = cbu.xbh;
        boolean isEmpty = cbu.xbh.isEmpty();
        int b2 = C4977b.m7371b(getContext(), 32.0f);
        int b3 = C4977b.m7371b(getContext(), 6.0f);
        int b4 = C4977b.m7371b(getContext(), 10.0f);
        int b5 = C4977b.m7371b(getContext(), 17.0f);
        if (this.qHi != null) {
            int i;
            LinearLayout linearLayout;
            C4990ab.m7411d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", Integer.valueOf(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(C25738R.dimen.f9979m4)));
            float f = ((float) i) - (f * 2.0f);
            if (linkedList.size() <= 0) {
                if (this.qHi.getParent() != null) {
                    this.qHi.setVisibility(8);
                }
                this.qHi.removeAllViews();
                this.qHi.setVisibility(8);
                linearLayout = this.qHi;
                i = 8;
            } else {
                this.qHi.getParent();
                this.qHi.removeAllViews();
                this.qHi.setVisibility(0);
                this.qHi.setPadding(0, b3, 0, b3);
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(C1318a.friendactivity_luckymoney_icon);
                imageView.setPadding(b4, b5, b4, 0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.qHi.addView(imageView);
                b4 = C1338a.fromDPToPix(getContext(), SnsCommentDetailUI.rqk);
                i = ((int) (f - ((float) b4))) / (b3 + b2);
                if (((int) (f - ((float) b4))) % (b3 + b2) > b2) {
                    i++;
                }
                C4990ab.m7411d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", Integer.valueOf(i));
                C13679h c13679h = new C13679h(getContext());
                c13679h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                c13679h.setLineMaxCounte(i);
                i = 0;
                while (true) {
                    b4 = i;
                    if (b4 >= linkedList.size()) {
                        break;
                    }
                    cbb cbb = (cbb) linkedList.get(b4);
                    TouchImageView touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ScaleType.FIT_XY);
                    touchImageView.setImageResource(C25738R.drawable.f6736oi);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, b2);
                    layoutParams2.setMargins(0, b3, b3, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(cbb.vHl);
                    C40460b.m69439t(touchImageView, cbb.vHl);
                    touchImageView.setOnClickListener(c22089b.rJI);
                    c13679h.addView(touchImageView);
                    i = b4 + 1;
                }
                this.qHi.addView(c13679h);
                linearLayout = this.qHj;
                i = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i);
        }
        AppMethodBeat.m2505o(35910);
    }
}
