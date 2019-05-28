package com.tencent.rtmp.ui;

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
import com.tencent.liteav.k;
import com.tencent.liteav.renderer.TXCFocusIndicatorView;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCloudVideoView extends FrameLayout implements OnTouchListener {
    private static final int FOCUS_AREA_SIZE_DP = 70;
    private static final String TAG = "TXCloudVideoView";
    private k mCapture;
    private int mCurrentScale;
    private boolean mFocus;
    private int mFocusAreaSize;
    private TXCFocusIndicatorView mFocusIndicatorView;
    private TXCGLSurfaceView mGLSurfaceView;
    private TXLogView mLogView;
    private ScaleGestureDetector mScaleGestureDetector;
    private OnScaleGestureListener mScaleGestureListener;
    private a mTouchFocusRunnable;
    private TextureView mVideoView;
    private boolean mZoom;

    class a implements Runnable {
        private View b;
        private MotionEvent c;

        private a() {
        }

        /* synthetic */ a(TXCloudVideoView tXCloudVideoView, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(View view) {
            this.b = view;
        }

        public void a(MotionEvent motionEvent) {
            this.c = motionEvent;
        }

        public void run() {
            AppMethodBeat.i(65568);
            if (TXCloudVideoView.this.mCapture != null && TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.mCapture.a(this.c.getX() / ((float) this.b.getWidth()), this.c.getY() / ((float) this.b.getHeight()));
            }
            if (TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.onTouchFocus((int) this.c.getX(), (int) this.c.getY());
            }
            AppMethodBeat.o(65568);
        }
    }

    public TXCloudVideoView(Context context) {
        this(context, null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65570);
        this.mFocusAreaSize = 0;
        this.mFocus = false;
        this.mZoom = false;
        this.mCurrentScale = 1;
        this.mScaleGestureDetector = null;
        this.mScaleGestureListener = new OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float f = 1.1f;
                AppMethodBeat.i(65587);
                int e = TXCloudVideoView.this.mCapture != null ? TXCloudVideoView.this.mCapture.e() : 0;
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
                        TXCloudVideoView.this.mCapture.a(TXCloudVideoView.this.mCurrentScale);
                    }
                }
                AppMethodBeat.o(65587);
                return false;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        };
        this.mTouchFocusRunnable = new a(this, null);
        this.mLogView = new TXLogView(context);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this.mScaleGestureListener);
        AppMethodBeat.o(65570);
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void addVideoView(TXCGLSurfaceView tXCGLSurfaceView) {
        AppMethodBeat.i(65571);
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
        }
        this.mGLSurfaceView = tXCGLSurfaceView;
        addView(this.mGLSurfaceView);
        removeView(this.mLogView);
        addView(this.mLogView);
        AppMethodBeat.o(65571);
    }

    public void addVideoView(TextureView textureView) {
        AppMethodBeat.i(65572);
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
        }
        this.mVideoView = textureView;
        addView(this.mVideoView);
        removeView(this.mLogView);
        addView(this.mLogView);
        AppMethodBeat.o(65572);
    }

    public void removeVideoView() {
        AppMethodBeat.i(65573);
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
            this.mVideoView = null;
        }
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
            this.mGLSurfaceView = null;
        }
        AppMethodBeat.o(65573);
    }

    public void removeFocusIndicatorView() {
        AppMethodBeat.i(65574);
        if (this.mFocusIndicatorView != null) {
            removeView(this.mFocusIndicatorView);
            this.mFocusIndicatorView = null;
        }
        AppMethodBeat.o(65574);
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
        AppMethodBeat.i(65575);
        if (z) {
            setVisibility(8);
        }
        AppMethodBeat.o(65575);
    }

    public void refreshLastFrame() {
    }

    public void setGLOnTouchListener(OnTouchListener onTouchListener) {
    }

    public void onTouchFocus(int i, int i2) {
        AppMethodBeat.i(65576);
        if (this.mGLSurfaceView == null) {
            AppMethodBeat.o(65576);
        } else if (i < 0 || i2 < 0) {
            if (this.mFocusIndicatorView != null) {
                this.mFocusIndicatorView.setVisibility(8);
            }
            AppMethodBeat.o(65576);
        } else {
            if (this.mFocusIndicatorView == null) {
                this.mFocusIndicatorView = new TXCFocusIndicatorView(getContext());
                this.mFocusIndicatorView.setVisibility(0);
                addView(this.mFocusIndicatorView);
            }
            Rect touchRect = getTouchRect(i, i2, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0f);
            this.mFocusIndicatorView.show(touchRect.left, touchRect.top, touchRect.right - touchRect.left);
            AppMethodBeat.o(65576);
        }
    }

    private Rect getTouchRect(int i, int i2, int i3, int i4, float f) {
        AppMethodBeat.i(65577);
        if (this.mFocusAreaSize == 0 && this.mGLSurfaceView != null) {
            this.mFocusAreaSize = (int) ((70.0f * this.mGLSurfaceView.getResources().getDisplayMetrics().density) + 0.5f);
        }
        int intValue = Float.valueOf(((float) this.mFocusAreaSize) * f).intValue();
        int clamp = clamp(i - (intValue / 2), 0, i3 - intValue);
        int clamp2 = clamp(i2 - (intValue / 2), 0, i4 - intValue);
        Rect rect = new Rect(clamp, clamp2, clamp + intValue, intValue + clamp2);
        AppMethodBeat.o(65577);
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
        AppMethodBeat.i(65578);
        this.mLogView.b(z);
        AppMethodBeat.o(65578);
    }

    public void showLog(boolean z) {
        AppMethodBeat.i(65579);
        this.mLogView.a(z);
        AppMethodBeat.o(65579);
    }

    public void clearLog() {
        AppMethodBeat.i(65580);
        this.mLogView.a();
        AppMethodBeat.o(65580);
    }

    public void setLogText(Bundle bundle, Bundle bundle2, int i) {
        AppMethodBeat.i(65581);
        this.mLogView.a(bundle, bundle2, i);
        AppMethodBeat.o(65581);
    }

    public void setLogMargin(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        AppMethodBeat.i(65582);
        ViewGroup.LayoutParams layoutParams2 = this.mLogView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = new LayoutParams(-1, -1);
        }
        layoutParams.leftMargin = TXLogView.a(getContext(), (float) i);
        layoutParams.rightMargin = TXLogView.a(getContext(), (float) i2);
        layoutParams.topMargin = TXLogView.a(getContext(), (float) i3);
        layoutParams.bottomMargin = TXLogView.a(getContext(), (float) i4);
        this.mLogView.setLayoutParams(layoutParams);
        AppMethodBeat.o(65582);
    }

    public void start(boolean z, boolean z2, k kVar) {
        AppMethodBeat.i(65583);
        this.mFocus = z;
        this.mZoom = z2;
        if (this.mFocus || this.mZoom) {
            setOnTouchListener(this);
            this.mCapture = kVar;
        }
        post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65569);
                if (TXCloudVideoView.this.mGLSurfaceView != null) {
                    TXCloudVideoView.this.mGLSurfaceView.setVisibility(0);
                }
                AppMethodBeat.o(65569);
            }
        });
        AppMethodBeat.o(65583);
    }

    public void stop(boolean z) {
        AppMethodBeat.i(65584);
        if (this.mFocus || this.mZoom) {
            setOnTouchListener(null);
        }
        this.mCapture = null;
        if (z) {
            post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65586);
                    if (TXCloudVideoView.this.mGLSurfaceView != null) {
                        TXCloudVideoView.this.mGLSurfaceView.setVisibility(8);
                    }
                    AppMethodBeat.o(65586);
                }
            });
        }
        AppMethodBeat.o(65584);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(65585);
        if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
            this.mTouchFocusRunnable.a(view);
            this.mTouchFocusRunnable.a(motionEvent);
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
        AppMethodBeat.o(65585);
        return z;
    }
}
