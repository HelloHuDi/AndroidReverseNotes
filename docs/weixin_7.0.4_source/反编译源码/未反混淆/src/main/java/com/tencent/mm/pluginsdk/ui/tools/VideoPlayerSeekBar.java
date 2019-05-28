package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    protected boolean cAW = false;
    private int uck = -1;
    private int ucl = -1;
    private int ucm = -1;
    private PInt vvn = new PInt();

    public VideoPlayerSeekBar(Context context) {
        super(context);
        AppMethodBeat.i(117963);
        AppMethodBeat.o(117963);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(117964);
        AppMethodBeat.o(117964);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(117965);
        AppMethodBeat.o(117965);
    }

    public void init() {
        AppMethodBeat.i(117966);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qyl = (ImageView) this.contentView.findViewById(R.id.x4);
        this.qym = (ImageView) this.contentView.findViewById(R.id.x2);
        this.qyn = (ImageView) this.contentView.findViewById(R.id.x5);
        this.qyo = (ImageView) this.contentView.findViewById(R.id.t6);
        this.qyp = (TextView) this.contentView.findViewById(R.id.x0);
        this.qyq = (TextView) this.contentView.findViewById(R.id.x6);
        this.qyn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(117962);
                if (motionEvent.getAction() == 0) {
                    ab.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
                    VideoPlayerSeekBar.this.hOy = false;
                    VideoPlayerSeekBar.this.qyu = motionEvent.getX();
                    if (VideoPlayerSeekBar.this.qyk != null) {
                        VideoPlayerSeekBar.this.qyk.aFw();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) VideoPlayerSeekBar.this.qyn.getLayoutParams();
                    int a = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, ((int) (x - VideoPlayerSeekBar.this.qyu)) + layoutParams.leftMargin, VideoPlayerSeekBar.this.vvn);
                    layoutParams.leftMargin = a;
                    VideoPlayerSeekBar.this.qyn.setLayoutParams(layoutParams);
                    int i = VideoPlayerSeekBar.this.vvn.value;
                    if (VideoPlayerSeekBar.this.qyr > 0) {
                        layoutParams = (LayoutParams) VideoPlayerSeekBar.this.qyl.getLayoutParams();
                        layoutParams.width = a;
                        VideoPlayerSeekBar.this.qyl.setLayoutParams(layoutParams);
                    }
                    VideoPlayerSeekBar.this.qyp.setText(AdVideoPlayerLoadingBar.oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(i % 60));
                    VideoPlayerSeekBar.this.hOy = true;
                } else {
                    int m = VideoPlayerSeekBar.this.mPosition;
                    if (VideoPlayerSeekBar.this.hOy) {
                        m = VideoPlayerSeekBar.this.mPosition = VideoPlayerSeekBar.this.vvn.value;
                    }
                    if (VideoPlayerSeekBar.this.qyk != null) {
                        ab.i("MicroMsg.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(m)));
                        VideoPlayerSeekBar.this.qyk.oA(m);
                    }
                    VideoPlayerSeekBar.this.hOy = false;
                }
                AppMethodBeat.o(117962);
                return true;
            }
        });
        AppMethodBeat.o(117966);
    }

    public int getBarPointWidth() {
        AppMethodBeat.i(117967);
        if (this.uck == -1) {
            this.uck = this.qyn.getWidth();
        }
        int i = this.uck;
        AppMethodBeat.o(117967);
        return i;
    }

    private int getBarPointPaddingLeft() {
        AppMethodBeat.i(117968);
        if (this.ucl == -1) {
            this.ucl = this.qyn.getPaddingLeft();
        }
        int i = this.ucl;
        AppMethodBeat.o(117968);
        return i;
    }

    private int getBarPointPaddingRight() {
        AppMethodBeat.i(117969);
        if (this.ucm == -1) {
            this.ucm = this.qyn.getPaddingRight();
        }
        int i = this.ucm;
        AppMethodBeat.o(117969);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int gR(int i, int i2) {
        int i3;
        AppMethodBeat.i(117970);
        if (i <= 0) {
            this.qym.getLayoutParams();
            i3 = 0;
        } else if (i >= this.qyr) {
            i3 = i2 - (((getBarPointWidth() - getBarPointPaddingLeft()) - getBarPointPaddingRight()) / 2);
        } else {
            i3 = (int) (((((double) i) * 1.0d) / ((double) this.qyr)) * ((double) i2));
        }
        AppMethodBeat.o(117970);
        return i3;
    }

    public int getLayoutId() {
        return R.layout.b1e;
    }

    public ImageView getPlayBtn() {
        return this.qyo;
    }

    public TextView getPlaytimeTv() {
        return this.qyp;
    }

    public void seek(int i) {
        AppMethodBeat.i(117971);
        ab.d("MicroMsg.VideoPlayerSeekBar", "seek position : ".concat(String.valueOf(i)));
        if (i < 0) {
            i = 0;
        }
        if (i >= this.qyr) {
            i = this.qyr;
        }
        if (this.mPosition != i) {
            this.mPosition = i;
            aFQ();
        }
        AppMethodBeat.o(117971);
    }

    public void setVideoTotalTime(int i) {
        AppMethodBeat.i(117972);
        this.qyr = i;
        this.mPosition = 0;
        this.qyq.setText(AdVideoPlayerLoadingBar.oy(this.qyr / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(this.qyr % 60));
        aFQ();
        AppMethodBeat.o(117972);
    }

    public void aFQ() {
        AppMethodBeat.i(117973);
        if (this.qyr == 0) {
            AppMethodBeat.o(117973);
        } else if (this.hOy) {
            AppMethodBeat.o(117973);
        } else if (this.qyn == null) {
            AppMethodBeat.o(117973);
        } else if (getBarLen() == 0) {
            AppMethodBeat.o(117973);
        } else {
            this.qyp.setText(AdVideoPlayerLoadingBar.oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = gR(this.mPosition, barLen);
            this.qyn.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) barLen));
            this.qyl.setLayoutParams(layoutParams);
            requestLayout();
            AppMethodBeat.o(117973);
        }
    }

    public void setPlayBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(117974);
        if (this.qyo != null) {
            this.qyo.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(117974);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.i(117975);
        this.cAW = z;
        super.setIsPlay(z);
        AppMethodBeat.o(117975);
    }

    public final boolean buH() {
        return this.cAW;
    }

    public final void Dq(int i) {
        AppMethodBeat.i(117976);
        seek(i);
        AppMethodBeat.o(117976);
    }

    public final void nF(boolean z) {
        AppMethodBeat.i(117977);
        setIsPlay(z);
        AppMethodBeat.o(117977);
    }

    static /* synthetic */ int a(VideoPlayerSeekBar videoPlayerSeekBar, int i, PInt pInt) {
        AppMethodBeat.i(117978);
        int barPointPaddingLeft = ((LayoutParams) videoPlayerSeekBar.qym.getLayoutParams()).leftMargin - videoPlayerSeekBar.getBarPointPaddingLeft();
        pInt.value = (int) (((((double) (i - barPointPaddingLeft)) * 1.0d) / ((double) videoPlayerSeekBar.getBarLen())) * ((double) videoPlayerSeekBar.qyr));
        if (pInt.value <= 0) {
            pInt.value = 0;
            if (i - barPointPaddingLeft > barPointPaddingLeft) {
                barPointPaddingLeft = i - barPointPaddingLeft;
            }
        } else if (pInt.value >= videoPlayerSeekBar.qyr) {
            pInt.value = videoPlayerSeekBar.qyr;
            barPointPaddingLeft = videoPlayerSeekBar.getBarLen() - (((videoPlayerSeekBar.getBarPointWidth() - videoPlayerSeekBar.getBarPointPaddingLeft()) - videoPlayerSeekBar.getBarPointPaddingRight()) / 2);
        } else {
            barPointPaddingLeft = i - barPointPaddingLeft;
        }
        AppMethodBeat.o(117978);
        return barPointPaddingLeft;
    }
}
