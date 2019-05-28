package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.cbf;

public final class bd {
    Context mContext;
    int qDY = -1;
    FrameLayout qOM;
    private au qPr;
    SnsCommentShowAbLayout rDJ = null;
    LinearLayout rpT;
    LinearLayout rpU;

    /* renamed from: com.tencent.mm.plugin.sns.ui.bd$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View rDK;
        final /* synthetic */ View val$view;

        AnonymousClass1(View view, View view2) {
            this.val$view = view;
            this.rDK = view2;
        }

        public final void run() {
            AppMethodBeat.i(39881);
            bd.a(bd.this, this.val$view, this.rDK);
            AppMethodBeat.o(39881);
        }
    }

    class a {
        View qCZ = null;
        String qPg;

        public a(String str, View view) {
            this.qPg = str;
            this.qCZ = view;
        }
    }

    public bd(Context context, au auVar, FrameLayout frameLayout) {
        this.mContext = context;
        this.qPr = auVar;
        this.qOM = frameLayout;
    }

    /* Access modifiers changed, original: final */
    public final void dP(final View view) {
        AppMethodBeat.i(39883);
        view.clearAnimation();
        view.startAnimation(this.qPr.rpS);
        this.qPr.rpS.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(39882);
                if (view != null) {
                    view.setVisibility(8);
                    bd.this.crO();
                }
                AppMethodBeat.o(39882);
            }
        });
        AppMethodBeat.o(39883);
    }

    public final boolean crO() {
        AppMethodBeat.i(39884);
        if (this.rDJ != null) {
            this.qOM.removeView(this.rDJ);
            this.rDJ = null;
            AppMethodBeat.o(39884);
            return true;
        }
        AppMethodBeat.o(39884);
        return false;
    }

    static /* synthetic */ void a(bd bdVar, View view, View view2) {
        AppMethodBeat.i(39885);
        BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
        n YT = af.cnF().YT(baseViewHolder.cwT);
        if (YT != null) {
            b lY = b.lY(740);
            cbf q = aj.q(YT);
            lY.tx(i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx(YT.field_userName).mb(q == null ? 0 : q.xao).mb(q == null ? 0 : q.xar);
            lY.ajK();
        }
        view2.setVisibility(0);
        view2.startAnimation(bdVar.qPr.rpR);
        bdVar.rpT = (LinearLayout) view2.findViewById(R.id.ehc);
        bdVar.rpT.setOnClickListener(bdVar.qPr.qOL.rJO);
        bdVar.rpT.setOnTouchListener(bdVar.qPr.riQ);
        bdVar.rpU = (LinearLayout) view2.findViewById(R.id.eh_);
        bdVar.rpU.setOnClickListener(bdVar.qPr.qOL.rJP);
        bdVar.rpU.setOnTouchListener(bdVar.qPr.riQ);
        bdVar.rpU.setTag(baseViewHolder);
        bdVar.rpT.setTag(baseViewHolder);
        ImageView imageView = (ImageView) bdVar.rpU.findViewById(R.id.eha);
        ImageView imageView2 = (ImageView) bdVar.rpT.findViewById(R.id.ehd);
        TextView textView = (TextView) bdVar.rpU.findViewById(R.id.ehb);
        TextView textView2 = (TextView) bdVar.rpT.findViewById(R.id.ehe);
        if (v.Zp(baseViewHolder.cFc)) {
            bdVar.rpT.setEnabled(false);
            bdVar.rpU.setEnabled(false);
            textView2.setTextColor(bdVar.mContext.getResources().getColor(R.color.a0h));
            if (baseViewHolder.klY == 10) {
                imageView.setImageResource(R.raw.friendactivity_comment_likeicon_golden_normal);
                imageView2.setImageResource(R.raw.friendactivity_comment_writeicon_golden_normal);
            } else {
                imageView.setImageResource(R.raw.friendactivity_comment_likeicon_normal);
                imageView2.setImageResource(R.raw.friendactivity_comment_writeicon_normal);
            }
            textView.setText(bdVar.mContext.getString(R.string.em5));
            textView.setTextColor(bdVar.mContext.getResources().getColor(R.color.a0h));
        } else {
            bdVar.rpT.setEnabled(true);
            if (baseViewHolder.klY == 10) {
                imageView.setImageResource(R.drawable.rm);
                imageView2.setImageResource(R.drawable.rn);
                textView.setTextColor(bdVar.mContext.getResources().getColor(R.color.a0q));
                textView2.setTextColor(bdVar.mContext.getResources().getColor(R.color.a0q));
            } else {
                imageView.setImageResource(R.drawable.og);
                textView.setTextColor(bdVar.mContext.getResources().getColor(R.color.a69));
                textView2.setTextColor(bdVar.mContext.getResources().getColor(R.color.a69));
            }
            bdVar.rpU.setEnabled(true);
            if (baseViewHolder.rHu == 0) {
                textView.setText(bdVar.mContext.getString(R.string.em5));
            } else {
                textView.setText(bdVar.mContext.getString(R.string.el4));
            }
        }
        if (baseViewHolder.klY == 10) {
            bdVar.rpU.setBackgroundResource(R.drawable.t5);
            bdVar.rpT.setBackgroundResource(R.drawable.t6);
        }
        AppMethodBeat.o(39885);
    }
}
