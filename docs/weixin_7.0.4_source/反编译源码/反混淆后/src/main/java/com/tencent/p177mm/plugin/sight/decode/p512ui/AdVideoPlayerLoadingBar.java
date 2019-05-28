package com.tencent.p177mm.plugin.sight.decode.p512ui;

import android.content.Context;
import android.os.Looper;
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
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar */
public class AdVideoPlayerLoadingBar extends RelativeLayout implements C13333a {
    protected View contentView = null;
    public boolean hOy = false;
    public int mPosition = 0;
    public C3855b qyk = null;
    public ImageView qyl;
    public ImageView qym = null;
    public ImageView qyn = null;
    protected ImageView qyo = null;
    public TextView qyp;
    protected TextView qyq;
    public int qyr = 0;
    private int qys = 0;
    private int qyt = 0;
    public float qyu = 0.0f;
    private int qyv = -1;
    private int qyw = -1;
    private int qyx = -1;
    private int qyy = -1;

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar$3 */
    class C38483 implements Runnable {
        C38483() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117917);
            AdVideoPlayerLoadingBar.this.cll();
            AppMethodBeat.m2505o(117917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar$1 */
    class C133261 implements OnTouchListener {
        C133261() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(117915);
            if (motionEvent.getAction() == 0) {
                C4990ab.m7416i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
                AdVideoPlayerLoadingBar.this.hOy = false;
                AdVideoPlayerLoadingBar.this.qyu = motionEvent.getX();
                if (AdVideoPlayerLoadingBar.this.qyk != null) {
                    AdVideoPlayerLoadingBar.this.qyk.aFw();
                }
            } else if (motionEvent.getAction() == 2) {
                float x = motionEvent.getX();
                LayoutParams layoutParams = (LayoutParams) AdVideoPlayerLoadingBar.this.qyn.getLayoutParams();
                layoutParams.leftMargin = AdVideoPlayerLoadingBar.m33391a(AdVideoPlayerLoadingBar.this, ((int) (x - AdVideoPlayerLoadingBar.this.qyu)) + layoutParams.leftMargin);
                AdVideoPlayerLoadingBar.this.qyn.setLayoutParams(layoutParams);
                int currentTimeByBarPoint = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
                if (AdVideoPlayerLoadingBar.this.qyr > 0) {
                    layoutParams = (LayoutParams) AdVideoPlayerLoadingBar.this.qyl.getLayoutParams();
                    layoutParams.width = (int) (((((double) currentTimeByBarPoint) * 1.0d) / ((double) AdVideoPlayerLoadingBar.this.qyr)) * ((double) AdVideoPlayerLoadingBar.this.getBarLen()));
                    AdVideoPlayerLoadingBar.this.qyl.setLayoutParams(layoutParams);
                }
                AdVideoPlayerLoadingBar.this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(currentTimeByBarPoint / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(currentTimeByBarPoint % 60));
                AdVideoPlayerLoadingBar.this.hOy = true;
            } else if (AdVideoPlayerLoadingBar.this.hOy) {
                int currentTimeByBarPoint2 = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
                if (AdVideoPlayerLoadingBar.this.qyk != null) {
                    C4990ab.m7416i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(currentTimeByBarPoint2)));
                    AdVideoPlayerLoadingBar.this.qyk.mo8552oA(currentTimeByBarPoint2);
                }
                AdVideoPlayerLoadingBar.this.hOy = false;
            }
            AppMethodBeat.m2505o(117915);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar$2 */
    class C133272 implements Runnable {
        C133272() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117916);
            LayoutParams layoutParams = (LayoutParams) AdVideoPlayerLoadingBar.this.qyn.getLayoutParams();
            layoutParams.leftMargin = (((LayoutParams) AdVideoPlayerLoadingBar.this.qym.getLayoutParams()).leftMargin - AdVideoPlayerLoadingBar.this.qyn.getPaddingLeft()) - (((AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.qyn.getPaddingLeft()) - AdVideoPlayerLoadingBar.this.qyn.getPaddingRight()) / 2);
            AdVideoPlayerLoadingBar.this.qyn.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(117916);
        }
    }

    public AdVideoPlayerLoadingBar(Context context) {
        super(context);
        AppMethodBeat.m2504i(117918);
        init();
        AppMethodBeat.m2505o(117918);
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(117919);
        init();
        AppMethodBeat.m2505o(117919);
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(117920);
        init();
        AppMethodBeat.m2505o(117920);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutId() {
        return 2130970990;
    }

    public void setIplaySeekCallback(C3855b c3855b) {
        this.qyk = c3855b;
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        AppMethodBeat.m2504i(117921);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qyl = (ImageView) this.contentView.findViewById(2131821425);
        this.qym = (ImageView) this.contentView.findViewById(2131821423);
        this.qyn = (ImageView) this.contentView.findViewById(2131821426);
        this.qyo = (ImageView) this.contentView.findViewById(2131821279);
        this.qyp = (TextView) this.contentView.findViewById(2131821421);
        this.qyq = (TextView) this.contentView.findViewById(2131821427);
        this.qyn.setOnTouchListener(new C133261());
        this.qyn.post(new C133272());
        LayoutParams layoutParams = (LayoutParams) this.qyl.getLayoutParams();
        layoutParams.width = 0;
        this.qyl.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(117921);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(117922);
        super.onLayout(z, i, i2, i3, i4);
        this.qys = 0;
        if (!(i == this.qyv && i2 == this.qyw && i3 == this.qyx && i4 == this.qyy)) {
            aFQ();
        }
        this.qyv = i;
        this.qyw = i2;
        this.qyx = i3;
        this.qyy = i4;
        AppMethodBeat.m2505o(117922);
    }

    public void setOnPlayButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(117923);
        this.qyo.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(117923);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.m2504i(117924);
        if (z) {
            this.qyo.setImageResource(C1318a.media_player_pause_btn);
            AppMethodBeat.m2505o(117924);
            return;
        }
        this.qyo.setImageResource(C1318a.media_player_play_btn);
        AppMethodBeat.m2505o(117924);
    }

    /* Access modifiers changed, original: protected */
    public int getCurrentTimeByBarPoint() {
        AppMethodBeat.m2504i(117925);
        int max = Math.max(0, (int) (((((double) ((((LayoutParams) this.qyn.getLayoutParams()).leftMargin - (((LayoutParams) this.qym.getLayoutParams()).leftMargin - this.qyn.getPaddingLeft())) + (((getBarPointWidth() - this.qyn.getPaddingLeft()) - this.qyn.getPaddingRight()) / 2))) * 1.0d) / ((double) getBarLen())) * ((double) this.qyr)));
        AppMethodBeat.m2505o(117925);
        return max;
    }

    public void seek(int i) {
        AppMethodBeat.m2504i(117926);
        this.mPosition = i;
        aFQ();
        AppMethodBeat.m2505o(117926);
    }

    public int getmPosition() {
        return this.mPosition;
    }

    public int getVideoTotalTime() {
        return this.qyr;
    }

    public void setVideoTotalTime(int i) {
        AppMethodBeat.m2504i(117927);
        this.qyr = i;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new C38483());
            AppMethodBeat.m2505o(117927);
            return;
        }
        cll();
        AppMethodBeat.m2505o(117927);
    }

    public final void cll() {
        AppMethodBeat.m2504i(117928);
        this.qyq.setText(AdVideoPlayerLoadingBar.m33392oy(this.qyr / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.qyr % 60));
        aFQ();
        AppMethodBeat.m2505o(117928);
    }

    public int getBarLen() {
        AppMethodBeat.m2504i(117929);
        if (this.qys <= 0) {
            this.qys = this.qym.getWidth();
        }
        int i = this.qys;
        AppMethodBeat.m2505o(117929);
        return i;
    }

    public final void clm() {
        this.qys = 0;
    }

    /* Access modifiers changed, original: protected */
    public int getBarPointWidth() {
        AppMethodBeat.m2504i(117930);
        if (this.qyt <= 0) {
            this.qyt = this.qyn.getWidth();
        }
        int i = this.qyt;
        AppMethodBeat.m2505o(117930);
        return i;
    }

    public void aFQ() {
        AppMethodBeat.m2504i(117931);
        if (this.qyr == 0) {
            AppMethodBeat.m2505o(117931);
        } else if (this.hOy) {
            AppMethodBeat.m2505o(117931);
        } else if (this.qyn == null) {
            AppMethodBeat.m2505o(117931);
        } else if (getBarLen() == 0) {
            AppMethodBeat.m2505o(117931);
        } else {
            int barPointWidth = ((getBarPointWidth() - this.qyn.getPaddingLeft()) - this.qyn.getPaddingRight()) / 2;
            this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.qym.getLayoutParams()).leftMargin - this.qyn.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) getBarLen())))) - barPointWidth;
            this.qyn.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) getBarLen()));
            this.qyl.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(117931);
        }
    }

    /* renamed from: oy */
    public static String m33392oy(int i) {
        AppMethodBeat.m2504i(117932);
        String concat;
        if (i < 10) {
            concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
            AppMethodBeat.m2505o(117932);
            return concat;
        }
        concat = String.valueOf(i);
        AppMethodBeat.m2505o(117932);
        return concat;
    }

    /* renamed from: a */
    static /* synthetic */ int m33391a(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar, int i) {
        AppMethodBeat.m2504i(117933);
        int barPointWidth = ((adVideoPlayerLoadingBar.getBarPointWidth() - adVideoPlayerLoadingBar.qyn.getPaddingLeft()) - adVideoPlayerLoadingBar.qyn.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) adVideoPlayerLoadingBar.qym.getLayoutParams();
        if (i < (layoutParams.leftMargin - adVideoPlayerLoadingBar.qyn.getPaddingLeft()) - barPointWidth) {
            i = (layoutParams.leftMargin - adVideoPlayerLoadingBar.qyn.getPaddingLeft()) - barPointWidth;
            AppMethodBeat.m2505o(117933);
            return i;
        } else if (i > ((adVideoPlayerLoadingBar.getBarLen() + layoutParams.leftMargin) - barPointWidth) - adVideoPlayerLoadingBar.qyn.getPaddingLeft()) {
            i = ((layoutParams.leftMargin + adVideoPlayerLoadingBar.getBarLen()) - barPointWidth) - adVideoPlayerLoadingBar.qyn.getPaddingLeft();
            AppMethodBeat.m2505o(117933);
            return i;
        } else {
            AppMethodBeat.m2505o(117933);
            return i;
        }
    }
}
