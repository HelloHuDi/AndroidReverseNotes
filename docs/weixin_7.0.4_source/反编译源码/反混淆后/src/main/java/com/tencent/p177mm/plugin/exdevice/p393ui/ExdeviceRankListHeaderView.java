package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView */
public class ExdeviceRankListHeaderView extends RelativeLayout {
    private TextView lDF;
    private OnClickListener lDG;
    private Animation lDH;
    private Animation lDI;
    private boolean lDJ;
    private Context mContext;
    private Runnable mHideRunnable;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView$4 */
    class C205924 implements AnimationListener {
        C205924() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(20206);
            ExdeviceRankListHeaderView.this.lDF.setVisibility(0);
            AppMethodBeat.m2505o(20206);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(20207);
            ExdeviceRankListHeaderView.this.lDF.setVisibility(4);
            AppMethodBeat.m2505o(20207);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView$1 */
    class C389781 implements OnClickListener {
        C389781() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20202);
            if (ExdeviceRankListHeaderView.this.lDJ) {
                ExdeviceRankListHeaderView.m66216b(ExdeviceRankListHeaderView.this);
            }
            if (ExdeviceRankListHeaderView.this.lDG != null) {
                ExdeviceRankListHeaderView.this.lDG.onClick(ExdeviceRankListHeaderView.this);
            }
            AppMethodBeat.m2505o(20202);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView$2 */
    class C389792 implements Runnable {
        C389792() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20203);
            ExdeviceRankListHeaderView.this.lDF.startAnimation(ExdeviceRankListHeaderView.this.lDI);
            AppMethodBeat.m2505o(20203);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView$3 */
    class C389803 implements AnimationListener {
        C389803() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(20204);
            ExdeviceRankListHeaderView.this.lDF.setVisibility(0);
            AppMethodBeat.m2505o(20204);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(CdnLogic.MediaTypeFriendsImageThumb);
            ExdeviceRankListHeaderView.this.lDI.reset();
            C5004al.m7442n(ExdeviceRankListHeaderView.this.mHideRunnable, 4000);
            AppMethodBeat.m2505o(CdnLogic.MediaTypeFriendsImageThumb);
        }
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(20208);
        this.lDJ = true;
        m66218cA(context);
        AppMethodBeat.m2505o(20208);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        AppMethodBeat.m2504i(20209);
        this.lDJ = true;
        m66218cA(context);
        AppMethodBeat.m2505o(20209);
    }

    /* renamed from: cA */
    private void m66218cA(Context context) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeAdVideo);
        this.mContext = context;
        this.lDF = (TextView) LayoutInflater.from(this.mContext).inflate(2130969441, this, true).findViewById(2131823709);
        this.lDF.setVisibility(4);
        aOR();
        setOnClickListener(new C389781());
        AppMethodBeat.m2505o(CdnLogic.kMediaTypeAdVideo);
    }

    private void aOR() {
        AppMethodBeat.m2504i(20211);
        this.lDH = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8279a);
        this.lDI = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8280b);
        this.mHideRunnable = new C389792();
        this.lDH.setAnimationListener(new C389803());
        this.lDI.setAnimationListener(new C205924());
        this.lDH.setFillAfter(true);
        this.lDH.setFillEnabled(true);
        this.lDI.setFillAfter(true);
        this.lDI.setFillAfter(true);
        AppMethodBeat.m2505o(20211);
    }

    public void setMotto(String str) {
        AppMethodBeat.m2504i(20212);
        this.lDF.setText(str);
        AppMethodBeat.m2505o(20212);
    }

    public String getMotto() {
        AppMethodBeat.m2504i(20213);
        String bc = C5046bo.m7532bc(this.lDF.getText().toString(), "");
        AppMethodBeat.m2505o(20213);
        return bc;
    }

    public void setOnViewClickListener(OnClickListener onClickListener) {
        this.lDG = onClickListener;
    }

    public void setIsShowTip(boolean z) {
        this.lDJ = z;
    }

    /* renamed from: b */
    static /* synthetic */ void m66216b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        AppMethodBeat.m2504i(20214);
        C5004al.m7439af(exdeviceRankListHeaderView.mHideRunnable);
        if (exdeviceRankListHeaderView.lDF.getVisibility() == 4) {
            exdeviceRankListHeaderView.lDH.reset();
            exdeviceRankListHeaderView.lDF.startAnimation(exdeviceRankListHeaderView.lDH);
            AppMethodBeat.m2505o(20214);
            return;
        }
        exdeviceRankListHeaderView.lDI.reset();
        exdeviceRankListHeaderView.lDF.startAnimation(exdeviceRankListHeaderView.lDI);
        AppMethodBeat.m2505o(20214);
    }
}
