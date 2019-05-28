package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.cbf;

/* renamed from: com.tencent.mm.plugin.sns.ui.bd */
public final class C46256bd {
    Context mContext;
    int qDY = -1;
    FrameLayout qOM;
    private C46251au qPr;
    SnsCommentShowAbLayout rDJ = null;
    LinearLayout rpT;
    LinearLayout rpU;

    /* renamed from: com.tencent.mm.plugin.sns.ui.bd$1 */
    class C220771 implements Runnable {
        final /* synthetic */ View rDK;
        final /* synthetic */ View val$view;

        C220771(View view, View view2) {
            this.val$view = view;
            this.rDK = view2;
        }

        public final void run() {
            AppMethodBeat.m2504i(39881);
            C46256bd.m86623a(C46256bd.this, this.val$view, this.rDK);
            AppMethodBeat.m2505o(39881);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bd$a */
    class C22078a {
        View qCZ = null;
        String qPg;

        public C22078a(String str, View view) {
            this.qPg = str;
            this.qCZ = view;
        }
    }

    public C46256bd(Context context, C46251au c46251au, FrameLayout frameLayout) {
        this.mContext = context;
        this.qPr = c46251au;
        this.qOM = frameLayout;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dP */
    public final void mo74361dP(final View view) {
        AppMethodBeat.m2504i(39883);
        view.clearAnimation();
        view.startAnimation(this.qPr.rpS);
        this.qPr.rpS.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(39882);
                if (view != null) {
                    view.setVisibility(8);
                    C46256bd.this.crO();
                }
                AppMethodBeat.m2505o(39882);
            }
        });
        AppMethodBeat.m2505o(39883);
    }

    public final boolean crO() {
        AppMethodBeat.m2504i(39884);
        if (this.rDJ != null) {
            this.qOM.removeView(this.rDJ);
            this.rDJ = null;
            AppMethodBeat.m2505o(39884);
            return true;
        }
        AppMethodBeat.m2505o(39884);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m86623a(C46256bd c46256bd, View view, View view2) {
        AppMethodBeat.m2504i(39885);
        BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
        C46236n YT = C13373af.cnF().mo62918YT(baseViewHolder.cwT);
        if (YT != null) {
            C37952b lY = C37952b.m64170lY(740);
            cbf q = C34955aj.m57409q(YT);
            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(YT.field_userName).mo60720mb(q == null ? 0 : q.xao).mo60720mb(q == null ? 0 : q.xar);
            lY.ajK();
        }
        view2.setVisibility(0);
        view2.startAnimation(c46256bd.qPr.rpR);
        c46256bd.rpT = (LinearLayout) view2.findViewById(2131827697);
        c46256bd.rpT.setOnClickListener(c46256bd.qPr.qOL.rJO);
        c46256bd.rpT.setOnTouchListener(c46256bd.qPr.riQ);
        c46256bd.rpU = (LinearLayout) view2.findViewById(2131827694);
        c46256bd.rpU.setOnClickListener(c46256bd.qPr.qOL.rJP);
        c46256bd.rpU.setOnTouchListener(c46256bd.qPr.riQ);
        c46256bd.rpU.setTag(baseViewHolder);
        c46256bd.rpT.setTag(baseViewHolder);
        ImageView imageView = (ImageView) c46256bd.rpU.findViewById(2131827695);
        ImageView imageView2 = (ImageView) c46256bd.rpT.findViewById(2131827698);
        TextView textView = (TextView) c46256bd.rpU.findViewById(2131827696);
        TextView textView2 = (TextView) c46256bd.rpT.findViewById(2131827699);
        if (C35002v.m57486Zp(baseViewHolder.cFc)) {
            c46256bd.rpT.setEnabled(false);
            c46256bd.rpU.setEnabled(false);
            textView2.setTextColor(c46256bd.mContext.getResources().getColor(C25738R.color.a0h));
            if (baseViewHolder.klY == 10) {
                imageView.setImageResource(C1318a.friendactivity_comment_likeicon_golden_normal);
                imageView2.setImageResource(C1318a.friendactivity_comment_writeicon_golden_normal);
            } else {
                imageView.setImageResource(C1318a.friendactivity_comment_likeicon_normal);
                imageView2.setImageResource(C1318a.friendactivity_comment_writeicon_normal);
            }
            textView.setText(c46256bd.mContext.getString(C25738R.string.em5));
            textView.setTextColor(c46256bd.mContext.getResources().getColor(C25738R.color.a0h));
        } else {
            c46256bd.rpT.setEnabled(true);
            if (baseViewHolder.klY == 10) {
                imageView.setImageResource(C25738R.drawable.f6813rm);
                imageView2.setImageResource(C25738R.drawable.f6814rn);
                textView.setTextColor(c46256bd.mContext.getResources().getColor(C25738R.color.a0q));
                textView2.setTextColor(c46256bd.mContext.getResources().getColor(C25738R.color.a0q));
            } else {
                imageView.setImageResource(C25738R.drawable.f6734og);
                textView.setTextColor(c46256bd.mContext.getResources().getColor(C25738R.color.a69));
                textView2.setTextColor(c46256bd.mContext.getResources().getColor(C25738R.color.a69));
            }
            c46256bd.rpU.setEnabled(true);
            if (baseViewHolder.rHu == 0) {
                textView.setText(c46256bd.mContext.getString(C25738R.string.em5));
            } else {
                textView.setText(c46256bd.mContext.getString(C25738R.string.el4));
            }
        }
        if (baseViewHolder.klY == 10) {
            c46256bd.rpU.setBackgroundResource(C25738R.drawable.f6851t5);
            c46256bd.rpT.setBackgroundResource(C25738R.drawable.f6852t6);
        }
        AppMethodBeat.m2505o(39885);
    }
}
