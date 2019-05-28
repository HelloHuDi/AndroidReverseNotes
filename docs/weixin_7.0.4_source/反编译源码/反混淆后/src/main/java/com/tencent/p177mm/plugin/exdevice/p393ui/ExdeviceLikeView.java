package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView */
public class ExdeviceLikeView extends RelativeLayout {
    private int lBb;
    private C11708a lBc;
    private int lBd;
    private TextView lBe;
    private ImageView lBf;
    private ProgressBar lBg;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView$a */
    public interface C11708a {
        boolean bpL();

        /* renamed from: iE */
        void mo23468iE(int i);
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView$1 */
    class C430121 implements OnClickListener {
        C430121() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19976);
            if (ExdeviceLikeView.this.lBc != null) {
                C11708a a = ExdeviceLikeView.this.lBc;
                ExdeviceLikeView.this.lBd;
                if (!a.bpL() && ExdeviceLikeView.this.lBd == 0) {
                    C4990ab.m7410d("MicroMsg.ExdeviceLikeView", "click listener is not null");
                    ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.m76392uS(ExdeviceLikeView.this.lBd));
                    if (ExdeviceLikeView.this.lBd == 1) {
                        ExdeviceLikeView.m76391c(ExdeviceLikeView.this);
                    }
                    if (ExdeviceLikeView.this.lBc != null) {
                        ExdeviceLikeView.this.lBc.mo23468iE(ExdeviceLikeView.this.lBd);
                        AppMethodBeat.m2505o(19976);
                        return;
                    }
                    AppMethodBeat.m2505o(19976);
                }
            }
            C4990ab.m7410d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
            AppMethodBeat.m2505o(19976);
        }
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(19977);
        this.lBd = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(2130969424, this, true);
        this.lBe = (TextView) inflate.findViewById(2131823663);
        this.lBf = (ImageView) inflate.findViewById(2131823664);
        this.lBg = (ProgressBar) inflate.findViewById(2131823665);
        setOnClickListener(new C430121());
        AppMethodBeat.m2505o(19977);
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setLikeNum(int i) {
        AppMethodBeat.m2504i(19978);
        this.lBb = i;
        CharSequence charSequence = this.lBb;
        if (this.lBb < 0) {
            C4990ab.m7420w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
            charSequence = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (i > 999) {
            C4990ab.m7410d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
            charSequence = "999+";
        }
        if (this.lBb <= 0) {
            this.lBe.setVisibility(8);
        } else {
            this.lBe.setVisibility(0);
        }
        this.lBe.setText(charSequence);
        AppMethodBeat.m2505o(19978);
    }

    public void setSelfLikeState(int i) {
        AppMethodBeat.m2504i(19979);
        this.lBd = i;
        if (this.lBd == 1) {
            this.lBg.setVisibility(8);
            this.lBe.setVisibility(0);
            this.lBf.setVisibility(0);
            this.lBf.setImageResource(C1318a.device_rank_item_liked);
            AppMethodBeat.m2505o(19979);
        } else if (this.lBd == 0) {
            this.lBg.setVisibility(8);
            this.lBe.setVisibility(0);
            this.lBf.setVisibility(0);
            this.lBf.setImageResource(C1318a.device_rank_item_unliked);
            AppMethodBeat.m2505o(19979);
        } else if (this.lBd == 2) {
            this.lBe.setVisibility(8);
            this.lBg.setVisibility(0);
            this.lBf.setVisibility(8);
            AppMethodBeat.m2505o(19979);
        } else {
            C4990ab.m7420w("MicroMsg.ExdeviceLikeView", "hy: error state");
            AppMethodBeat.m2505o(19979);
        }
    }

    public void setOnLikeViewClickListener(C11708a c11708a) {
        this.lBc = c11708a;
    }

    /* renamed from: uS */
    static /* synthetic */ int m76392uS(int i) {
        AppMethodBeat.m2504i(19980);
        switch (i) {
            case 0:
                AppMethodBeat.m2505o(19980);
                return 1;
            case 1:
                AppMethodBeat.m2505o(19980);
                return 0;
            case 2:
                AppMethodBeat.m2505o(19980);
                return 2;
            default:
                C4990ab.m7420w("MicroMsg.ExdeviceLikeView", "hy: state error");
                AppMethodBeat.m2505o(19980);
                return 2;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m76391c(ExdeviceLikeView exdeviceLikeView) {
        AppMethodBeat.m2504i(19981);
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, C25738R.anim.f8345bk);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.lBf.startAnimation(loadAnimation);
        AppMethodBeat.m2505o(19981);
    }
}
