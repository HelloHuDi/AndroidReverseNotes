package com.tencent.rtmp.p1423ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.liteav.C45108k;
import com.tencent.liteav.renderer.TXCFocusIndicatorView;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.rtmp.ui.TXCloudVideoView */
public class TXCloudVideoView extends FrameLayout implements OnTouchListener {
    private static final int FOCUS_AREA_SIZE_DP = 70;
    private static final String TAG = "TXCloudVideoView";
    private C45108k mCapture;
    private int mCurrentScale;
    private boolean mFocus;
    private int mFocusAreaSize;
    private TXCFocusIndicatorView mFocusIndicatorView;
    private TXCGLSurfaceView mGLSurfaceView;
    private TXLogView mLogView;
    private ScaleGestureDetector mScaleGestureDetector;
    private OnScaleGestureListener mScaleGestureListener;
    private C30937a mTouchFocusRunnable;
    private TextureView mVideoView;
    private boolean mZoom;

    /* renamed from: com.tencent.rtmp.ui.TXCloudVideoView$a */
    class C30937a implements Runnable {
        /* renamed from: b */
        private View f13837b;
        /* renamed from: c */
        private MotionEvent f13838c;

        private C30937a() {
        }

        /* synthetic */ C30937a(TXCloudVideoView tXCloudVideoView, C409641 c409641) {
            this();
        }

        /* renamed from: a */
        public void mo49643a(View view) {
            this.f13837b = view;
        }

        /* renamed from: a */
        public void mo49642a(MotionEvent motionEvent) {
            this.f13838c = motionEvent;
        }

        public void run() {
            AppMethodBeat.m2504i(65568);
            if (TXCloudVideoView.this.mCapture != null && TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.mCapture.mo43391a(this.f13838c.getX() / ((float) this.f13837b.getWidth()), this.f13838c.getY() / ((float) this.f13837b.getHeight()));
            }
            if (TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.onTouchFocus((int) this.f13838c.getX(), (int) this.f13838c.getY());
            }
            AppMethodBeat.m2505o(65568);
        }
    }

    /* renamed from: com.tencent.rtmp.ui.TXCloudVideoView$1 */
    class C409641 implements Runnable {
        C409641() {
        }

        public void run() {
            AppMethodBeat.m2504i(65569);
            if (TXCloudVideoView.this.mGLSurfaceView != null) {
                TXCloudVideoView.this.mGLSurfaceView.setVisibility(0);
            }
            AppMethodBeat.m2505o(65569);
        }
    }

    /* renamed from: com.tencent.rtmp.ui.TXCloudVideoView$2 */
    class C409652 implements Runnable {
        C409652() {
        }

        public void run() {
            AppMethodBeat.m2504i(65586);
            if (TXCloudVideoView.this.mGLSurfaceView != null) {
                TXCloudVideoView.this.mGLSurfaceView.setVisibility(8);
            }
            AppMethodBeat.m2505o(65586);
        }
    }

    /* renamed from: com.tencent.rtmp.ui.TXCloudVideoView$3 */
    class C409663 implements OnScaleGestureListener {
        C409663() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f = 1.1f;
            AppMethodBeat.m2504i(65587);
            int e = TXCloudVideoView.this.mCapture != null ? TXCloudVideoView.this.mCapture.mo43408e() : 0;
            if (e > 0) {
                int access$200;
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (scaleFactor > 1.0f) {
                    float access$2002 = ((0.2f / ((float) e)) * ((float) (e - TXCloudVideoView.this.mCurrentScale))) + 1.0f;
                    if (access$2002 > 1.1f) {
                        f = access$2002;
                    }
                } else if (scaleFactor < 1.0f) {
                    f = 1.0f - ((0.2f / ((float) e)) * ((float) TXCloudVideoView.this.mCurrentScale));
                    if (f >= 0.9f) {
                        f = 0.9f;
                    }
                } else {
                    f = scaleFactor;
                }
                int round = Math.round(((float) TXCloudVideoView.this.mCurrentScale) * f);
                if (round == TXCloudVideoView.this.mCurrentScale) {
                    if (f > 1.0f) {
                        round++;
                    } else if (f < 1.0f) {
                        round--;
                    }
                }
                if (round >= e) {
                    round = e;
                }
                if (round <= 1) {
                    round = 1;
                }
                if (f > 1.0f) {
                    if (round < TXCloudVideoView.this.mCurrentScale) {
                        access$200 = TXCloudVideoView.this.mCurrentScale;
                    }
                    access$200 = round;
                } else {
                    if (f < 1.0f && round > TXCloudVideoView.this.mCurrentScale) {
                        access$200 = TXCloudVideoView.this.mCurrentScale;
                    }
                    access$200 = round;
                }
                TXCloudVideoView.this.mCurrentScale = access$200;
                if (TXCloudVideoView.this.mCapture != null) {
                    TXCloudVideoView.this.mCapture.mo43398a(TXCloudVideoView.this.mCurrentScale);
                }
            }
            AppMethodBeat.m2505o(65587);
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public TXCloudVideoView(Context context) {
        this(context, null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(65570);
        this.mFocusAreaSize = 0;
        this.mFocus = false;
        this.mZoom = false;
        this.mCurrentScale = 1;
        this.mScaleGestureDetector = null;
        this.mScaleGestureListener = new C409663();
        this.mTouchFocusRunnable = new C30937a(this, null);
        this.mLogView = new TXLogView(context);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this.mScaleGestureListener);
        AppMethodBeat.m2505o(65570);
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void addVideoView(TXCGLSurfaceView tXCGLSurfaceView) {
        AppMethodBeat.m2504i(65571);
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
        }
        this.mGLSurfaceView = tXCGLSurfaceView;
        addView(this.mGLSurfaceView);
        removeView(this.mLogView);
        addView(this.mLogView);
        AppMethodBeat.m2505o(65571);
    }

    public void addVideoView(TextureView textureView) {
        AppMethodBeat.m2504i(65572);
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
        }
        this.mVideoView = textureView;
        addView(this.mVideoView);
        removeView(this.mLogView);
        addView(this.mLogView);
        AppMethodBeat.m2505o(65572);
    }

    public void removeVideoView() {
        AppMethodBeat.m2504i(65573);
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
            this.mVideoView = null;
        }
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
            this.mGLSurfaceView = null;
        }
        AppMethodBeat.m2505o(65573);
    }

    public void removeFocusIndicatorView() {
        AppMethodBeat.m2504i(65574);
        if (this.mFocusIndicatorView != null) {
            removeView(this.mFocusIndicatorView);
            this.mFocusIndicatorView = null;
        }
        AppMethodBeat.m2505o(65574);
    }

    public void onDestroy() {
    }

    public void setStreamUrl(String str) {
    }

    public TextureView getVideoView() {
        return this.mVideoView;
    }

    public TXCGLSurfaceView getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public void setUseBeautyView(boolean z) {
    }

    public void enableHardwareDecode(boolean z) {
    }

    public void setRenderMode(int i) {
    }

    public void setRenderRotation(int i) {
    }

    public TextureView getHWVideoView() {
        return this.mVideoView;
    }

    public void setSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
    }

    public void adjustVideoSize() {
    }

    public void clearLastFrame(boolean z) {
        AppMethodBeat.m2504i(65575);
        if (z) {
            setVisibility(8);
        }
        AppMethodBeat.m2505o(65575);
    }

    public void refreshLastFrame() {
    }

    public void setGLOnTouchListener(OnTouchListener onTouchListener) {
    }

    public void onTouchFocus(int i, int i2) {
        AppMethodBeat.m2504i(65576);
        if (this.mGLSurfaceView == null) {
            AppMethodBeat.m2505o(65576);
        } else if (i < 0 || i2 < 0) {
            if (this.mFocusIndicatorView != null) {
                this.mFocusIndicatorView.setVisibility(8);
            }
            AppMethodBeat.m2505o(65576);
        } else {
            if (this.mFocusIndicatorView == null) {
                this.mFocusIndicatorView = new TXCFocusIndicatorView(getContext());
                this.mFocusIndicatorView.setVisibility(0);
                addView(this.mFocusIndicatorView);
            }
            Rect touchRect = getTouchRect(i, i2, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0f);
            this.mFocusIndicatorView.show(touchRect.left, touchRect.top, touchRect.right - touchRect.left);
            AppMethodBeat.m2505o(65576);
        }
    }

    private Rect getTouchRect(int i, int i2, int i3, int i4, float f) {
        AppMethodBeat.m2504i(65577);
        if (this.mFocusAreaSize == 0 && this.mGLSurfaceView != null) {
            this.mFocusAreaSize = (int) ((70.0f * this.mGLSurfaceView.getResources().getDisplayMetrics().density) + 0.5f);
        }
        int intValue = Float.valueOf(((float) this.mFocusAreaSize) * f).intValue();
        int clamp = clamp(i - (intValue / 2), 0, i3 - intValue);
        int clamp2 = clamp(i2 - (intValue / 2), 0, i4 - intValue);
        Rect rect = new Rect(clamp, clamp2, clamp + intValue, intValue + clamp2);
        AppMethodBeat.m2505o(65577);
        return rect;
    }

    private int clamp(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    public void setMirror(boolean z) {
    }

    public void disableLog(boolean z) {
        AppMethodBeat.m2504i(65578);
        this.mLogView.mo75196b(z);
        AppMethodBeat.m2505o(65578);
    }

    public void showLog(boolean z) {
        AppMethodBeat.m2504i(65579);
        this.mLogView.mo75195a(z);
        AppMethodBeat.m2505o(65579);
    }

    public void clearLog() {
        AppMethodBeat.m2504i(65580);
        this.mLogView.mo75192a();
        AppMethodBeat.m2505o(65580);
    }

    public void setLogText(Bundle bundle, Bundle bundle2, int i) {
        AppMethodBeat.m2504i(65581);
        this.mLogView.mo75194a(bundle, bundle2, i);
        AppMethodBeat.m2505o(65581);
    }

    public void setLogMargin(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(65582);
        ViewGroup.LayoutParams layoutParams2 = this.mLogView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = new LayoutParams(-1, -1);
        }
        layoutParams.leftMargin = TXLogView.m88565a(getContext(), (float) i);
        layoutParams.rightMargin = TXLogView.m88565a(getContext(), (float) i2);
        layoutParams.topMargin = TXLogView.m88565a(getContext(), (float) i3);
        layoutParams.bottomMargin = TXLogView.m88565a(getContext(), (float) i4);
        this.mLogView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(65582);
    }

    public void start(boolean z, boolean z2, C45108k c45108k) {
        AppMethodBeat.m2504i(65583);
        this.mFocus = z;
        this.mZoom = z2;
        if (this.mFocus || this.mZoom) {
            setOnTouchListener(this);
            this.mCapture = c45108k;
        }
        post(new C409641());
        AppMethodBeat.m2505o(65583);
    }

    public void stop(boolean z) {
        AppMethodBeat.m2504i(65584);
        if (this.mFocus || this.mZoom) {
            setOnTouchListener(null);
        }
        this.mCapture = null;
        if (z) {
            post(new C409652());
        }
        AppMethodBeat.m2505o(65584);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(65585);
        if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
            this.mTouchFocusRunnable.mo49643a(view);
            this.mTouchFocusRunnable.mo49642a(motionEvent);
            postDelayed(this.mTouchFocusRunnable, 100);
        } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            removeCallbacks(this.mTouchFocusRunnable);
            onTouchFocus(-1, -1);
            if (this.mScaleGestureDetector != null && this.mZoom) {
                this.mScaleGestureDetector.onTouchEvent(motionEvent);
            }
        }
        if (this.mZoom && motionEvent.getAction() == 0) {
            performClick();
        }
        boolean z = this.mZoom;
        AppMethodBeat.m2505o(65585);
        return z;
    }
}
