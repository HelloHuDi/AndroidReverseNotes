package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.C19835c;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer */
public class RecentAppBrandViewContainer extends LinearLayout {
    RecentAppBrandView iXn;
    private View iYQ;
    Runnable iYR = null;
    boolean iYS = true;
    private OnClickListener iYT = null;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer$2 */
    class C335992 implements OnClickListener {
        C335992() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133951);
            if (RecentAppBrandViewContainer.this.iYT != null) {
                RecentAppBrandViewContainer.this.iYT.onClick(view);
            }
            AppMethodBeat.m2505o(133951);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer$3 */
    class C336003 implements AnimatorListener {
        C336003() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133952);
            RecentAppBrandViewContainer.this.iYQ.setVisibility(8);
            RecentAppBrandViewContainer.this.iYQ.setScaleX(1.0f);
            RecentAppBrandViewContainer.this.iYQ.setScaleY(1.0f);
            if (!(RecentAppBrandViewContainer.this.iXn == null || RecentAppBrandViewContainer.this.iXn.getAdapter() == null || 3 >= RecentAppBrandViewContainer.this.iXn.getDataCount())) {
                C19835c qn = RecentAppBrandViewContainer.this.iXn.mo22545qn(3);
                if (qn != null) {
                    RecentAppBrandViewContainer.this.iXn.getShowList().add(3, qn);
                    RecentAppBrandViewContainer.this.iXn.getAdapter().mo66317ch(3);
                }
            }
            AppMethodBeat.m2505o(133952);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer$1 */
    class C385751 implements Runnable {
        C385751() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133950);
            RecentAppBrandViewContainer.m65345a(RecentAppBrandViewContainer.this);
            AppMethodBeat.m2505o(133950);
        }
    }

    public RecentAppBrandViewContainer(Context context) {
        super(context);
        AppMethodBeat.m2504i(133953);
        init(context);
        AppMethodBeat.m2505o(133953);
    }

    public RecentAppBrandViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(133954);
        init(context);
        AppMethodBeat.m2505o(133954);
    }

    public RecentAppBrandViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(133955);
        init(context);
        AppMethodBeat.m2505o(133955);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(133956);
        if (this.iXn != null) {
            if (this.iXn.getDataCount() > 4) {
                this.iYQ.setVisibility(0);
            } else {
                this.iYQ.setVisibility(4);
            }
            this.iXn.aPw();
        }
        AppMethodBeat.m2505o(133956);
    }

    public void setOnMoreClickListener(OnClickListener onClickListener) {
        this.iYT = onClickListener;
    }

    public void setDataList(List<C19835c> list) {
        AppMethodBeat.m2504i(133957);
        if (this.iXn != null) {
            this.iXn.setDataList(list);
        }
        if (list.size() <= 4) {
            this.iYQ.setVisibility(8);
            AppMethodBeat.m2505o(133957);
            return;
        }
        this.iYQ.setVisibility(0);
        AppMethodBeat.m2505o(133957);
    }

    public void setItemPadding(int i) {
        AppMethodBeat.m2504i(133958);
        if (this.iXn != null) {
            this.iXn.setItemPadding(i);
        }
        if (this.iYQ != null) {
            View view = this.iYQ;
            view.setPadding(i, view.getPaddingTop(), i, this.iYQ.getPaddingBottom());
        }
        AppMethodBeat.m2505o(133958);
    }

    public RecentAppBrandView getRecentView() {
        return this.iXn;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(133959);
        this.mContext = context;
        View inflate = C5616v.m8409hu(context).inflate(2130968675, this);
        this.iXn = (RecentAppBrandView) inflate.findViewById(2131821168);
        this.iYQ = inflate.findViewById(2131821169);
        C46898e c46898e = new C46898e(this.iYQ);
        int dl = (int) C10969d.m18709dl(getContext());
        c46898e.iYe.getLayoutParams().width = ((int) (((float) (C1338a.m2857am(getContext(), C25738R.dimen.f10011nc) * 2)) * C10969d.m18710dm(getContext()))) + dl;
        c46898e.iYe.getLayoutParams().height = ((int) (((float) (C1338a.m2857am(getContext(), C25738R.dimen.f10011nc) * 2)) * C10969d.m18710dm(getContext()))) + dl;
        c46898e.iqT.getLayoutParams().width = dl;
        c46898e.iqT.getLayoutParams().height = dl;
        c46898e.iYd.getLayoutParams().width = dl;
        c46898e.iYd.getLayoutParams().height = dl;
        c46898e.iqT.setImageResource(C1318a.multitask_bar_more_btn);
        c46898e.iYf.setVisibility(8);
        c46898e.gne.setText("");
        c46898e.apJ.setOnClickListener(new C335992());
        AppMethodBeat.m2505o(133959);
    }

    /* renamed from: a */
    static /* synthetic */ void m65345a(RecentAppBrandViewContainer recentAppBrandViewContainer) {
        AppMethodBeat.m2504i(133960);
        if (recentAppBrandViewContainer.iYQ != null) {
            recentAppBrandViewContainer.iYQ.animate().scaleX(0.75f).scaleY(0.75f).setDuration(300).setListener(new C336003());
        }
        AppMethodBeat.m2505o(133960);
    }
}
