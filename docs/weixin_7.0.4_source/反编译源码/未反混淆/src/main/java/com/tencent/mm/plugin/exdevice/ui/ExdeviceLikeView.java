package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class ExdeviceLikeView extends RelativeLayout {
    private int lBb;
    private a lBc;
    private int lBd;
    private TextView lBe;
    private ImageView lBf;
    private ProgressBar lBg;
    private Context mContext;

    public interface a {
        boolean bpL();

        void iE(int i);
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(19977);
        this.lBd = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.w6, this, true);
        this.lBe = (TextView) inflate.findViewById(R.id.bja);
        this.lBf = (ImageView) inflate.findViewById(R.id.bjb);
        this.lBg = (ProgressBar) inflate.findViewById(R.id.bjc);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(19976);
                if (ExdeviceLikeView.this.lBc != null) {
                    a a = ExdeviceLikeView.this.lBc;
                    ExdeviceLikeView.this.lBd;
                    if (!a.bpL() && ExdeviceLikeView.this.lBd == 0) {
                        ab.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
                        ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.uS(ExdeviceLikeView.this.lBd));
                        if (ExdeviceLikeView.this.lBd == 1) {
                            ExdeviceLikeView.c(ExdeviceLikeView.this);
                        }
                        if (ExdeviceLikeView.this.lBc != null) {
                            ExdeviceLikeView.this.lBc.iE(ExdeviceLikeView.this.lBd);
                            AppMethodBeat.o(19976);
                            return;
                        }
                        AppMethodBeat.o(19976);
                    }
                }
                ab.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
                AppMethodBeat.o(19976);
            }
        });
        AppMethodBeat.o(19977);
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setLikeNum(int i) {
        AppMethodBeat.i(19978);
        this.lBb = i;
        CharSequence charSequence = this.lBb;
        if (this.lBb < 0) {
            ab.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
            charSequence = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (i > 999) {
            ab.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
            charSequence = "999+";
        }
        if (this.lBb <= 0) {
            this.lBe.setVisibility(8);
        } else {
            this.lBe.setVisibility(0);
        }
        this.lBe.setText(charSequence);
        AppMethodBeat.o(19978);
    }

    public void setSelfLikeState(int i) {
        AppMethodBeat.i(19979);
        this.lBd = i;
        if (this.lBd == 1) {
            this.lBg.setVisibility(8);
            this.lBe.setVisibility(0);
            this.lBf.setVisibility(0);
            this.lBf.setImageResource(R.raw.device_rank_item_liked);
            AppMethodBeat.o(19979);
        } else if (this.lBd == 0) {
            this.lBg.setVisibility(8);
            this.lBe.setVisibility(0);
            this.lBf.setVisibility(0);
            this.lBf.setImageResource(R.raw.device_rank_item_unliked);
            AppMethodBeat.o(19979);
        } else if (this.lBd == 2) {
            this.lBe.setVisibility(8);
            this.lBg.setVisibility(0);
            this.lBf.setVisibility(8);
            AppMethodBeat.o(19979);
        } else {
            ab.w("MicroMsg.ExdeviceLikeView", "hy: error state");
            AppMethodBeat.o(19979);
        }
    }

    public void setOnLikeViewClickListener(a aVar) {
        this.lBc = aVar;
    }

    static /* synthetic */ int uS(int i) {
        AppMethodBeat.i(19980);
        switch (i) {
            case 0:
                AppMethodBeat.o(19980);
                return 1;
            case 1:
                AppMethodBeat.o(19980);
                return 0;
            case 2:
                AppMethodBeat.o(19980);
                return 2;
            default:
                ab.w("MicroMsg.ExdeviceLikeView", "hy: state error");
                AppMethodBeat.o(19980);
                return 2;
        }
    }

    static /* synthetic */ void c(ExdeviceLikeView exdeviceLikeView) {
        AppMethodBeat.i(19981);
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, R.anim.bk);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.lBf.startAnimation(loadAnimation);
        AppMethodBeat.o(19981);
    }
}
