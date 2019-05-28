package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class TalkRoomPopupNav extends LinearLayout {
    public View miL;
    private a yAE;
    public LinearLayout yAF;
    private LinearLayout yAG;
    private ImageView yAH;
    private ImageView yAI;
    public ScaleAnimation yAJ;
    public Animation yAK;
    public int yAL = 0;
    public int yAM = 0;
    private ScaleAnimation yAN;
    private Animation yAO;
    private AlphaAnimation yAP;
    private AlphaAnimation yAQ;
    public LinearLayout yoK;

    public interface a {
        void dAt();

        void dAu();
    }

    @TargetApi(11)
    public TalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(30016);
        initView();
        AppMethodBeat.o(30016);
    }

    public TalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(30017);
        initView();
        AppMethodBeat.o(30017);
    }

    public void setOnClickListener(a aVar) {
        this.yAE = aVar;
    }

    public void setNavContent(String str) {
        AppMethodBeat.i(30018);
        ((TextView) findViewById(R.id.evj)).setText(str);
        AppMethodBeat.o(30018);
    }

    public void setDialogContent(String str) {
        AppMethodBeat.i(30019);
        ((TextView) findViewById(R.id.evl)).setText(str);
        AppMethodBeat.o(30019);
    }

    public void setBgViewResource(int i) {
        AppMethodBeat.i(30020);
        if (this.miL != null) {
            this.miL.setBackgroundResource(i);
        }
        AppMethodBeat.o(30020);
    }

    public void setIconRes(int i) {
        AppMethodBeat.i(30021);
        if (this.yAH != null) {
            this.yAH.setImageResource(i);
        }
        AppMethodBeat.o(30021);
    }

    public void setIconAnim(int i) {
        AppMethodBeat.i(30022);
        if (i < 0) {
            if (this.yAI != null) {
                this.yAI.setVisibility(8);
            }
            AppMethodBeat.o(30022);
            return;
        }
        if (this.yAI != null) {
            this.yAI.setImageResource(i);
            this.yAI.setVisibility(0);
        }
        AppMethodBeat.o(30022);
    }

    private void initView() {
        AppMethodBeat.i(30023);
        inflate(getContext(), R.layout.azf, this);
        this.yoK = (LinearLayout) findViewById(R.id.evg);
        this.yAF = (LinearLayout) findViewById(R.id.evk);
        this.yAG = (LinearLayout) findViewById(R.id.evm);
        this.miL = findViewById(R.id.evf);
        this.yAH = (ImageView) findViewById(R.id.evh);
        this.yAI = (ImageView) findViewById(R.id.evi);
        this.yAI.setVisibility(8);
        this.yoK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30006);
                if (TalkRoomPopupNav.this.yAE != null) {
                    TalkRoomPopupNav.this.yAE.dAt();
                }
                AppMethodBeat.o(30006);
            }
        });
        ((Button) findViewById(R.id.evn)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30007);
                TalkRoomPopupNav.b(TalkRoomPopupNav.this);
                AppMethodBeat.o(30007);
            }
        });
        ((Button) findViewById(R.id.evo)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30008);
                TalkRoomPopupNav.b(TalkRoomPopupNav.this);
                if (TalkRoomPopupNav.this.yAE != null) {
                    TalkRoomPopupNav.this.yAE.dAu();
                }
                AppMethodBeat.o(30008);
            }
        });
        this.yAL = this.miL.getLayoutParams().height;
        this.yAM = this.yAF.getLayoutParams().height;
        AppMethodBeat.o(30023);
    }

    public final void stop() {
        AppMethodBeat.i(30025);
        if (!(this.yAP == null || this.yAQ == null)) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.a(this.yAI, this.yAP);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.a(this.yAI, this.yAQ);
            this.yAI.clearAnimation();
            this.yAP = null;
            this.yAQ = null;
        }
        AppMethodBeat.o(30025);
    }

    public final void start() {
        AppMethodBeat.i(30024);
        if (this.yAP == null || this.yAQ == null) {
            this.yAP = new AlphaAnimation(0.0f, 1.0f);
            this.yAP.setDuration(1000);
            this.yAP.setStartOffset(0);
            this.yAQ = new AlphaAnimation(1.0f, 0.0f);
            this.yAQ.setDuration(1000);
            this.yAQ.setStartOffset(0);
            this.yAP.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(30014);
                    if (TalkRoomPopupNav.this.yAQ != null) {
                        TalkRoomPopupNav.this.yAI.startAnimation(TalkRoomPopupNav.this.yAQ);
                    }
                    AppMethodBeat.o(30014);
                }
            });
            this.yAQ.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(30015);
                    if (TalkRoomPopupNav.this.yAP != null) {
                        TalkRoomPopupNav.this.yAI.startAnimation(TalkRoomPopupNav.this.yAP);
                    }
                    AppMethodBeat.o(30015);
                }
            });
            this.yAI.startAnimation(this.yAP);
        }
        AppMethodBeat.o(30024);
    }

    static /* synthetic */ void b(TalkRoomPopupNav talkRoomPopupNav) {
        AppMethodBeat.i(30026);
        if (talkRoomPopupNav.yAN == null) {
            talkRoomPopupNav.yAN = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.yAM) * 1.0f) / ((float) talkRoomPopupNav.yAL), 1.0f);
            talkRoomPopupNav.yAN.setDuration(300);
            talkRoomPopupNav.yAN.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(30011);
                    TalkRoomPopupNav.this.yAG.setVisibility(4);
                    AppMethodBeat.o(30011);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(30012);
                    TalkRoomPopupNav.this.yAF.setVisibility(8);
                    TalkRoomPopupNav.this.yoK.setClickable(true);
                    AppMethodBeat.o(30012);
                }
            });
        }
        if (talkRoomPopupNav.yAO == null) {
            talkRoomPopupNav.yAO = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.anim.b6);
            talkRoomPopupNav.yAO.setFillAfter(true);
            talkRoomPopupNav.yAO.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(30013);
                    TalkRoomPopupNav.this.yAG.setVisibility(4);
                    TalkRoomPopupNav.this.yAF.setVisibility(4);
                    AppMethodBeat.o(30013);
                }
            });
        }
        LayoutParams layoutParams = talkRoomPopupNav.miL.getLayoutParams();
        layoutParams.height = talkRoomPopupNav.yAL;
        talkRoomPopupNav.miL.setLayoutParams(layoutParams);
        talkRoomPopupNav.miL.startAnimation(talkRoomPopupNav.yAN);
        talkRoomPopupNav.yAF.startAnimation(talkRoomPopupNav.yAO);
        talkRoomPopupNav.yoK.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.anim.b5));
        talkRoomPopupNav.yoK.setVisibility(0);
        AppMethodBeat.o(30026);
    }
}
