package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar extends RelativeLayout implements a {
    private boolean cAW = false;
    private View contentView = null;
    private boolean hOy = false;
    private int mPosition = 0;
    private b qyk = null;
    private ImageView qyl;
    private ImageView qym = null;
    private ImageView qyn = null;
    private ImageView qyo = null;
    private TextView qyp;
    private TextView qyq;
    private int qyr = 0;
    private int qys = 0;
    private float qyu = 0.0f;
    private int qyv = -1;
    private int qyw = -1;
    private int qyx = -1;
    private int qyy = -1;

    static /* synthetic */ int d(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        AppMethodBeat.i(70307);
        int currentTimeByBarPoint = snsAdNativeLandingPagesVideoPlayerLoadingBar.getCurrentTimeByBarPoint();
        AppMethodBeat.o(70307);
        return currentTimeByBarPoint;
    }

    static /* synthetic */ int g(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        AppMethodBeat.i(70308);
        int barLen = snsAdNativeLandingPagesVideoPlayerLoadingBar.getBarLen();
        AppMethodBeat.o(70308);
        return barLen;
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context) {
        super(context);
        AppMethodBeat.i(70293);
        init();
        AppMethodBeat.o(70293);
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(70294);
        init();
        AppMethodBeat.o(70294);
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(70295);
        init();
        AppMethodBeat.o(70295);
    }

    public void setIplaySeekCallback(b bVar) {
        this.qyk = bVar;
    }

    private void init() {
        AppMethodBeat.i(70296);
        this.contentView = View.inflate(getContext(), R.layout.auk, this);
        this.qyl = (ImageView) this.contentView.findViewById(R.id.x4);
        this.qym = (ImageView) this.contentView.findViewById(R.id.x2);
        this.qyn = (ImageView) this.contentView.findViewById(R.id.x5);
        this.qyo = (ImageView) this.contentView.findViewById(R.id.t6);
        this.qyp = (TextView) this.contentView.findViewById(R.id.x0);
        this.qyq = (TextView) this.contentView.findViewById(R.id.x6);
        this.qyn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(70291);
                if (motionEvent.getAction() == 0) {
                    ab.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.hOy = false;
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyu = motionEvent.getX();
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyk != null) {
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyk.aFw();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyn.getLayoutParams();
                    layoutParams.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, ((int) (x - SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyu)) + layoutParams.leftMargin);
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyn.setLayoutParams(layoutParams);
                    int d = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyr > 0) {
                        layoutParams = (LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyl.getLayoutParams();
                        layoutParams.width = (int) (((((double) d) * 1.0d) / ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyr)) * ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.g(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this)));
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyl.setLayoutParams(layoutParams);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyp.setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.oy(d / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + SnsAdNativeLandingPagesVideoPlayerLoadingBar.oy(d % 60));
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.hOy = true;
                } else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.hOy) {
                    int d2 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyk != null) {
                        ab.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(d2)));
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qyk.oA(d2);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.hOy = false;
                }
                AppMethodBeat.o(70291);
                return true;
            }
        });
        AppMethodBeat.o(70296);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(70297);
        super.onLayout(z, i, i2, i3, i4);
        if (!(i == this.qyv && i2 == this.qyw && i3 == this.qyx && i4 == this.qyy)) {
            aFQ();
        }
        this.qyv = i;
        this.qyw = i2;
        this.qyx = i3;
        this.qyy = i4;
        AppMethodBeat.o(70297);
    }

    public void setOnPlayButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(70298);
        this.qyo.setOnClickListener(onClickListener);
        AppMethodBeat.o(70298);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.i(70299);
        this.cAW = z;
        if (z) {
            this.qyo.setImageResource(R.raw.media_player_pause_btn);
            AppMethodBeat.o(70299);
            return;
        }
        this.qyo.setImageResource(R.raw.media_player_play_btn);
        AppMethodBeat.o(70299);
    }

    public boolean getIsPlay() {
        return this.cAW;
    }

    private int getCurrentTimeByBarPoint() {
        AppMethodBeat.i(70300);
        int paddingLeft = (int) (((((double) (((LayoutParams) this.qyn.getLayoutParams()).leftMargin - (((LayoutParams) this.qym.getLayoutParams()).leftMargin - this.qyn.getPaddingLeft()))) * 1.0d) / ((double) getBarLen())) * ((double) this.qyr));
        if (paddingLeft < 0) {
            paddingLeft = 0;
        }
        AppMethodBeat.o(70300);
        return paddingLeft;
    }

    public final void seek(int i) {
        AppMethodBeat.i(70301);
        this.mPosition = i;
        aFQ();
        AppMethodBeat.o(70301);
    }

    public int getVideoTotalTime() {
        return this.qyr;
    }

    public void setVideoTotalTime(final int i) {
        AppMethodBeat.i(70302);
        if (this.qyn.isShown() && this.qyn.getWidth() == 0) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(70292);
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.setVideoTotalTime(i);
                    AppMethodBeat.o(70292);
                }
            });
            AppMethodBeat.o(70302);
            return;
        }
        this.qyr = i;
        this.mPosition = 0;
        this.qyq.setText(oy(this.qyr / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + oy(this.qyr % 60));
        aFQ();
        AppMethodBeat.o(70302);
    }

    private int getBarLen() {
        AppMethodBeat.i(70303);
        this.qys = this.qym.getWidth();
        int i = this.qys;
        AppMethodBeat.o(70303);
        return i;
    }

    public final void clm() {
        this.qys = 0;
    }

    private void aFQ() {
        AppMethodBeat.i(70304);
        if (this.qyr == 0) {
            AppMethodBeat.o(70304);
        } else if (this.hOy) {
            AppMethodBeat.o(70304);
        } else if (this.qyn == null) {
            AppMethodBeat.o(70304);
        } else if (getBarLen() == 0) {
            AppMethodBeat.o(70304);
        } else {
            int width = ((this.qyn.getWidth() - this.qyn.getPaddingLeft()) - this.qyn.getPaddingRight()) / 2;
            this.qyp.setText(oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + oy(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.qym.getLayoutParams()).leftMargin - this.qyn.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) getBarLen())))) - width;
            this.qyn.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) getBarLen()));
            this.qyl.setLayoutParams(layoutParams);
            AppMethodBeat.o(70304);
        }
    }

    public static String oy(int i) {
        AppMethodBeat.i(70305);
        String concat;
        if (i < 10) {
            concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
            AppMethodBeat.o(70305);
            return concat;
        }
        concat = String.valueOf(i);
        AppMethodBeat.o(70305);
        return concat;
    }
}
