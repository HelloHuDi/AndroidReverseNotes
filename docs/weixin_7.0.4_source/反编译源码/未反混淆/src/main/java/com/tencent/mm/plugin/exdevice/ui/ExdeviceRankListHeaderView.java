package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class ExdeviceRankListHeaderView extends RelativeLayout {
    private TextView lDF;
    private OnClickListener lDG;
    private Animation lDH;
    private Animation lDI;
    private boolean lDJ;
    private Context mContext;
    private Runnable mHideRunnable;

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(20208);
        this.lDJ = true;
        cA(context);
        AppMethodBeat.o(20208);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(20209);
        this.lDJ = true;
        cA(context);
        AppMethodBeat.o(20209);
    }

    private void cA(Context context) {
        AppMethodBeat.i(CdnLogic.kMediaTypeAdVideo);
        this.mContext = context;
        this.lDF = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.wm, this, true).findViewById(R.id.bkj);
        this.lDF.setVisibility(4);
        aOR();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20202);
                if (ExdeviceRankListHeaderView.this.lDJ) {
                    ExdeviceRankListHeaderView.b(ExdeviceRankListHeaderView.this);
                }
                if (ExdeviceRankListHeaderView.this.lDG != null) {
                    ExdeviceRankListHeaderView.this.lDG.onClick(ExdeviceRankListHeaderView.this);
                }
                AppMethodBeat.o(20202);
            }
        });
        AppMethodBeat.o(CdnLogic.kMediaTypeAdVideo);
    }

    private void aOR() {
        AppMethodBeat.i(20211);
        this.lDH = AnimationUtils.loadAnimation(this.mContext, R.anim.a);
        this.lDI = AnimationUtils.loadAnimation(this.mContext, R.anim.b);
        this.mHideRunnable = new Runnable() {
            public final void run() {
                AppMethodBeat.i(20203);
                ExdeviceRankListHeaderView.this.lDF.startAnimation(ExdeviceRankListHeaderView.this.lDI);
                AppMethodBeat.o(20203);
            }
        };
        this.lDH.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(20204);
                ExdeviceRankListHeaderView.this.lDF.setVisibility(0);
                AppMethodBeat.o(20204);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(CdnLogic.MediaTypeFriendsImageThumb);
                ExdeviceRankListHeaderView.this.lDI.reset();
                al.n(ExdeviceRankListHeaderView.this.mHideRunnable, 4000);
                AppMethodBeat.o(CdnLogic.MediaTypeFriendsImageThumb);
            }
        });
        this.lDI.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(20206);
                ExdeviceRankListHeaderView.this.lDF.setVisibility(0);
                AppMethodBeat.o(20206);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(20207);
                ExdeviceRankListHeaderView.this.lDF.setVisibility(4);
                AppMethodBeat.o(20207);
            }
        });
        this.lDH.setFillAfter(true);
        this.lDH.setFillEnabled(true);
        this.lDI.setFillAfter(true);
        this.lDI.setFillAfter(true);
        AppMethodBeat.o(20211);
    }

    public void setMotto(String str) {
        AppMethodBeat.i(20212);
        this.lDF.setText(str);
        AppMethodBeat.o(20212);
    }

    public String getMotto() {
        AppMethodBeat.i(20213);
        String bc = bo.bc(this.lDF.getText().toString(), "");
        AppMethodBeat.o(20213);
        return bc;
    }

    public void setOnViewClickListener(OnClickListener onClickListener) {
        this.lDG = onClickListener;
    }

    public void setIsShowTip(boolean z) {
        this.lDJ = z;
    }

    static /* synthetic */ void b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        AppMethodBeat.i(20214);
        al.af(exdeviceRankListHeaderView.mHideRunnable);
        if (exdeviceRankListHeaderView.lDF.getVisibility() == 4) {
            exdeviceRankListHeaderView.lDH.reset();
            exdeviceRankListHeaderView.lDF.startAnimation(exdeviceRankListHeaderView.lDH);
            AppMethodBeat.o(20214);
            return;
        }
        exdeviceRankListHeaderView.lDI.reset();
        exdeviceRankListHeaderView.lDF.startAnimation(exdeviceRankListHeaderView.lDI);
        AppMethodBeat.o(20214);
    }
}
