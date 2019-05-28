package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c;
import com.tencent.mm.ui.v;
import java.util.List;

public class RecentAppBrandViewContainer extends LinearLayout {
    RecentAppBrandView iXn;
    private View iYQ;
    Runnable iYR = null;
    boolean iYS = true;
    private OnClickListener iYT = null;
    private Context mContext;

    public RecentAppBrandViewContainer(Context context) {
        super(context);
        AppMethodBeat.i(133953);
        init(context);
        AppMethodBeat.o(133953);
    }

    public RecentAppBrandViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133954);
        init(context);
        AppMethodBeat.o(133954);
    }

    public RecentAppBrandViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(133955);
        init(context);
        AppMethodBeat.o(133955);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(133956);
        if (this.iXn != null) {
            if (this.iXn.getDataCount() > 4) {
                this.iYQ.setVisibility(0);
            } else {
                this.iYQ.setVisibility(4);
            }
            this.iXn.aPw();
        }
        AppMethodBeat.o(133956);
    }

    public void setOnMoreClickListener(OnClickListener onClickListener) {
        this.iYT = onClickListener;
    }

    public void setDataList(List<c> list) {
        AppMethodBeat.i(133957);
        if (this.iXn != null) {
            this.iXn.setDataList(list);
        }
        if (list.size() <= 4) {
            this.iYQ.setVisibility(8);
            AppMethodBeat.o(133957);
            return;
        }
        this.iYQ.setVisibility(0);
        AppMethodBeat.o(133957);
    }

    public void setItemPadding(int i) {
        AppMethodBeat.i(133958);
        if (this.iXn != null) {
            this.iXn.setItemPadding(i);
        }
        if (this.iYQ != null) {
            View view = this.iYQ;
            view.setPadding(i, view.getPaddingTop(), i, this.iYQ.getPaddingBottom());
        }
        AppMethodBeat.o(133958);
    }

    public RecentAppBrandView getRecentView() {
        return this.iXn;
    }

    private void init(Context context) {
        AppMethodBeat.i(133959);
        this.mContext = context;
        View inflate = v.hu(context).inflate(R.layout.bz, this);
        this.iXn = (RecentAppBrandView) inflate.findViewById(R.id.q6);
        this.iYQ = inflate.findViewById(R.id.q7);
        e eVar = new e(this.iYQ);
        int dl = (int) d.dl(getContext());
        eVar.iYe.getLayoutParams().width = ((int) (((float) (a.am(getContext(), R.dimen.nc) * 2)) * d.dm(getContext()))) + dl;
        eVar.iYe.getLayoutParams().height = ((int) (((float) (a.am(getContext(), R.dimen.nc) * 2)) * d.dm(getContext()))) + dl;
        eVar.iqT.getLayoutParams().width = dl;
        eVar.iqT.getLayoutParams().height = dl;
        eVar.iYd.getLayoutParams().width = dl;
        eVar.iYd.getLayoutParams().height = dl;
        eVar.iqT.setImageResource(R.raw.multitask_bar_more_btn);
        eVar.iYf.setVisibility(8);
        eVar.gne.setText("");
        eVar.apJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133951);
                if (RecentAppBrandViewContainer.this.iYT != null) {
                    RecentAppBrandViewContainer.this.iYT.onClick(view);
                }
                AppMethodBeat.o(133951);
            }
        });
        AppMethodBeat.o(133959);
    }

    static /* synthetic */ void a(RecentAppBrandViewContainer recentAppBrandViewContainer) {
        AppMethodBeat.i(133960);
        if (recentAppBrandViewContainer.iYQ != null) {
            recentAppBrandViewContainer.iYQ.animate().scaleX(0.75f).scaleY(0.75f).setDuration(300).setListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133952);
                    RecentAppBrandViewContainer.this.iYQ.setVisibility(8);
                    RecentAppBrandViewContainer.this.iYQ.setScaleX(1.0f);
                    RecentAppBrandViewContainer.this.iYQ.setScaleY(1.0f);
                    if (!(RecentAppBrandViewContainer.this.iXn == null || RecentAppBrandViewContainer.this.iXn.getAdapter() == null || 3 >= RecentAppBrandViewContainer.this.iXn.getDataCount())) {
                        c qn = RecentAppBrandViewContainer.this.iXn.qn(3);
                        if (qn != null) {
                            RecentAppBrandViewContainer.this.iXn.getShowList().add(3, qn);
                            RecentAppBrandViewContainer.this.iXn.getAdapter().ch(3);
                        }
                    }
                    AppMethodBeat.o(133952);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        AppMethodBeat.o(133960);
    }
}
