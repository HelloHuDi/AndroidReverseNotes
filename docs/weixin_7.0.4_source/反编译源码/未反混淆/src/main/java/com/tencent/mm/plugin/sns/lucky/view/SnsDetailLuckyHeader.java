package com.tencent.mm.plugin.sns.lucky.view;

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
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class SnsDetailLuckyHeader extends LinearLayout {
    private View iym = null;
    private TextView qHh;
    private LinearLayout qHi;
    private LinearLayout qHj;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(35904);
        init();
        AppMethodBeat.o(35904);
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        AppMethodBeat.i(35905);
        init();
        AppMethodBeat.o(35905);
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(35906);
        init();
        AppMethodBeat.o(35906);
    }

    private void init() {
        AppMethodBeat.i(35907);
        View inflate = View.inflate(getContext(), R.layout.aau, this);
        this.iym = inflate.findViewById(R.id.d0s);
        this.qHh = (TextView) inflate.findViewById(R.id.d0t);
        this.qHi = (LinearLayout) inflate.findViewById(R.id.d0v);
        this.qHj = getLinearSeparator();
        AppMethodBeat.o(35907);
    }

    public LinearLayout getLinearSeparator() {
        AppMethodBeat.i(35908);
        b.b(getContext(), 2.0f);
        LayoutParams layoutParams = new LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.drawable.a13);
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.o(35908);
        return linearLayout;
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(35909);
        super.setVisibility(i);
        if (this.iym != null) {
            this.iym.setVisibility(i);
        }
        AppMethodBeat.o(35909);
    }

    public final void a(n nVar, com.tencent.mm.plugin.sns.ui.d.b bVar) {
        AppMethodBeat.i(35910);
        cbf q = aj.q(nVar);
        cbu cbu = q.xaE;
        if (cbu == null || cbu.xbh.size() == 0) {
            setVisibility(8);
            AppMethodBeat.o(35910);
            return;
        }
        setVisibility(0);
        double b = ((double) m.b(nVar, q)) * 1.0d;
        this.qHh.setText(getContext().getString(R.string.emn, new Object[]{Integer.valueOf(q.xaE.xbg), bo.F(b / 100.0d)}));
        this.iym.setTag(nVar);
        this.iym.setOnClickListener(bVar.rJT);
        LinkedList linkedList = cbu.xbh;
        boolean isEmpty = cbu.xbh.isEmpty();
        int b2 = b.b(getContext(), 32.0f);
        int b3 = b.b(getContext(), 6.0f);
        int b4 = b.b(getContext(), 10.0f);
        int b5 = b.b(getContext(), 17.0f);
        if (this.qHi != null) {
            int i;
            LinearLayout linearLayout;
            ab.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", Integer.valueOf(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(R.dimen.m4)));
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
                imageView.setImageResource(R.raw.friendactivity_luckymoney_icon);
                imageView.setPadding(b4, b5, b4, 0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.qHi.addView(imageView);
                b4 = a.fromDPToPix(getContext(), SnsCommentDetailUI.rqk);
                i = ((int) (f - ((float) b4))) / (b3 + b2);
                if (((int) (f - ((float) b4))) % (b3 + b2) > b2) {
                    i++;
                }
                ab.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", Integer.valueOf(i));
                h hVar = new h(getContext());
                hVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                hVar.setLineMaxCounte(i);
                i = 0;
                while (true) {
                    b4 = i;
                    if (b4 >= linkedList.size()) {
                        break;
                    }
                    cbb cbb = (cbb) linkedList.get(b4);
                    TouchImageView touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ScaleType.FIT_XY);
                    touchImageView.setImageResource(R.drawable.oi);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, b2);
                    layoutParams2.setMargins(0, b3, b3, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(cbb.vHl);
                    com.tencent.mm.pluginsdk.ui.a.b.t(touchImageView, cbb.vHl);
                    touchImageView.setOnClickListener(bVar.rJI);
                    hVar.addView(touchImageView);
                    i = b4 + 1;
                }
                this.qHi.addView(hVar);
                linearLayout = this.qHj;
                i = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i);
        }
        AppMethodBeat.o(35910);
    }
}
