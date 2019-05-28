package com.tencent.p177mm.pluginsdk.p597ui.tools;

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
import com.tencent.p177mm.plugin.sight.decode.p512ui.AdVideoPlayerLoadingBar;
import com.tencent.p177mm.pluginsdk.p597ui.C30135g;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar */
public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements C30135g {
    protected boolean cAW = false;
    private int uck = -1;
    private int ucl = -1;
    private int ucm = -1;
    private PInt vvn = new PInt();

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar$1 */
    class C149711 implements OnTouchListener {
        C149711() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(117962);
            if (motionEvent.getAction() == 0) {
                C4990ab.m7416i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
                VideoPlayerSeekBar.this.hOy = false;
                VideoPlayerSeekBar.this.qyu = motionEvent.getX();
                if (VideoPlayerSeekBar.this.qyk != null) {
                    VideoPlayerSeekBar.this.qyk.aFw();
                }
            } else if (motionEvent.getAction() == 2) {
                float x = motionEvent.getX();
                LayoutParams layoutParams = (LayoutParams) VideoPlayerSeekBar.this.qyn.getLayoutParams();
                int a = VideoPlayerSeekBar.m23258a(VideoPlayerSeekBar.this, ((int) (x - VideoPlayerSeekBar.this.qyu)) + layoutParams.leftMargin, VideoPlayerSeekBar.this.vvn);
                layoutParams.leftMargin = a;
                VideoPlayerSeekBar.this.qyn.setLayoutParams(layoutParams);
                int i = VideoPlayerSeekBar.this.vvn.value;
                if (VideoPlayerSeekBar.this.qyr > 0) {
                    layoutParams = (LayoutParams) VideoPlayerSeekBar.this.qyl.getLayoutParams();
                    layoutParams.width = a;
                    VideoPlayerSeekBar.this.qyl.setLayoutParams(layoutParams);
                }
                VideoPlayerSeekBar.this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(i % 60));
                VideoPlayerSeekBar.this.hOy = true;
            } else {
                int m = VideoPlayerSeekBar.this.mPosition;
                if (VideoPlayerSeekBar.this.hOy) {
                    m = VideoPlayerSeekBar.this.mPosition = VideoPlayerSeekBar.this.vvn.value;
                }
                if (VideoPlayerSeekBar.this.qyk != null) {
                    C4990ab.m7416i("MicroMsg.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(m)));
                    VideoPlayerSeekBar.this.qyk.mo8552oA(m);
                }
                VideoPlayerSeekBar.this.hOy = false;
            }
            AppMethodBeat.m2505o(117962);
            return true;
        }
    }

    public VideoPlayerSeekBar(Context context) {
        super(context);
        AppMethodBeat.m2504i(117963);
        AppMethodBeat.m2505o(117963);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(117964);
        AppMethodBeat.m2505o(117964);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(117965);
        AppMethodBeat.m2505o(117965);
    }

    public void init() {
        AppMethodBeat.m2504i(117966);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qyl = (ImageView) this.contentView.findViewById(2131821425);
        this.qym = (ImageView) this.contentView.findViewById(2131821423);
        this.qyn = (ImageView) this.contentView.findViewById(2131821426);
        this.qyo = (ImageView) this.contentView.findViewById(2131821279);
        this.qyp = (TextView) this.contentView.findViewById(2131821421);
        this.qyq = (TextView) this.contentView.findViewById(2131821427);
        this.qyn.setOnTouchListener(new C149711());
        AppMethodBeat.m2505o(117966);
    }

    public int getBarPointWidth() {
        AppMethodBeat.m2504i(117967);
        if (this.uck == -1) {
            this.uck = this.qyn.getWidth();
        }
        int i = this.uck;
        AppMethodBeat.m2505o(117967);
        return i;
    }

    private int getBarPointPaddingLeft() {
        AppMethodBeat.m2504i(117968);
        if (this.ucl == -1) {
            this.ucl = this.qyn.getPaddingLeft();
        }
        int i = this.ucl;
        AppMethodBeat.m2505o(117968);
        return i;
    }

    private int getBarPointPaddingRight() {
        AppMethodBeat.m2504i(117969);
        if (this.ucm == -1) {
            this.ucm = this.qyn.getPaddingRight();
        }
        int i = this.ucm;
        AppMethodBeat.m2505o(117969);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: gR */
    public final int mo27331gR(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(117970);
        if (i <= 0) {
            this.qym.getLayoutParams();
            i3 = 0;
        } else if (i >= this.qyr) {
            i3 = i2 - (((getBarPointWidth() - getBarPointPaddingLeft()) - getBarPointPaddingRight()) / 2);
        } else {
            i3 = (int) (((((double) i) * 1.0d) / ((double) this.qyr)) * ((double) i2));
        }
        AppMethodBeat.m2505o(117970);
        return i3;
    }

    public int getLayoutId() {
        return 2130970991;
    }

    public ImageView getPlayBtn() {
        return this.qyo;
    }

    public TextView getPlaytimeTv() {
        return this.qyp;
    }

    public void seek(int i) {
        AppMethodBeat.m2504i(117971);
        C4990ab.m7410d("MicroMsg.VideoPlayerSeekBar", "seek position : ".concat(String.valueOf(i)));
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
        AppMethodBeat.m2505o(117971);
    }

    public void setVideoTotalTime(int i) {
        AppMethodBeat.m2504i(117972);
        this.qyr = i;
        this.mPosition = 0;
        this.qyq.setText(AdVideoPlayerLoadingBar.m33392oy(this.qyr / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.qyr % 60));
        aFQ();
        AppMethodBeat.m2505o(117972);
    }

    public void aFQ() {
        AppMethodBeat.m2504i(117973);
        if (this.qyr == 0) {
            AppMethodBeat.m2505o(117973);
        } else if (this.hOy) {
            AppMethodBeat.m2505o(117973);
        } else if (this.qyn == null) {
            AppMethodBeat.m2505o(117973);
        } else if (getBarLen() == 0) {
            AppMethodBeat.m2505o(117973);
        } else {
            this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = mo27331gR(this.mPosition, barLen);
            this.qyn.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) barLen));
            this.qyl.setLayoutParams(layoutParams);
            requestLayout();
            AppMethodBeat.m2505o(117973);
        }
    }

    public void setPlayBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(117974);
        if (this.qyo != null) {
            this.qyo.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(117974);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.m2504i(117975);
        this.cAW = z;
        super.setIsPlay(z);
        AppMethodBeat.m2505o(117975);
    }

    public final boolean buH() {
        return this.cAW;
    }

    /* renamed from: Dq */
    public final void mo27328Dq(int i) {
        AppMethodBeat.m2504i(117976);
        seek(i);
        AppMethodBeat.m2505o(117976);
    }

    /* renamed from: nF */
    public final void mo27337nF(boolean z) {
        AppMethodBeat.m2504i(117977);
        setIsPlay(z);
        AppMethodBeat.m2505o(117977);
    }

    /* renamed from: a */
    static /* synthetic */ int m23258a(VideoPlayerSeekBar videoPlayerSeekBar, int i, PInt pInt) {
        AppMethodBeat.m2504i(117978);
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
        AppMethodBeat.m2505o(117978);
        return barPointPaddingLeft;
    }
}
