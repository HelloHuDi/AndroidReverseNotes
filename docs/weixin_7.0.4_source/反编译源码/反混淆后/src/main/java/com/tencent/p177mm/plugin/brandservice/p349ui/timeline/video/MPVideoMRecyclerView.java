package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.plugin.brandservice.p349ui.widget.MPVideoView;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J.\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "animationContainerContainer", "Landroid/view/View;", "canScroll", "", "downY", "", "hasDown", "maxVideoHeight", "", "minVideoHeight", "moveY", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoViewContainer", "Landroid/widget/FrameLayout;", "deltaY", "inScrollRange", "curHeight", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setParam", "", "animationView", "maxHeight", "minHeight", "setVideoHeight", "videoHeight", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoMRecyclerView */
public final class MPVideoMRecyclerView extends MRecyclerView {
    private final String TAG = "MicroMsg.MPVideoMRecyclerView";
    private int bpm;
    private boolean canScroll = true;
    private float hkf;
    private float hkh;
    private int jWw;
    private MPVideoView jXP;
    private FrameLayout jXQ;
    private View jXR;
    private boolean jXS;

    public MPVideoMRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public final void mo68305a(MPVideoView mPVideoView, FrameLayout frameLayout, View view, int i, int i2) {
        AppMethodBeat.m2504i(15269);
        C25052j.m39376p(mPVideoView, "videoView");
        C25052j.m39376p(frameLayout, "videoViewContainer");
        C25052j.m39376p(view, "animationView");
        this.bpm = i;
        this.jWw = i2;
        this.jXP = mPVideoView;
        this.jXQ = frameLayout;
        this.jXR = view;
        AppMethodBeat.m2505o(15269);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(15270);
        FrameLayout frameLayout = this.jXQ;
        if (frameLayout == null) {
            C25052j.avw("videoViewContainer");
        }
        int height = frameLayout.getHeight();
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.hkf = motionEvent.getRawY();
            this.jXS = true;
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (!this.jXS) {
                this.hkf = motionEvent.getRawY();
                this.jXS = true;
            }
            this.hkh = motionEvent.getRawY();
            float f = (this.hkh - this.hkf) * 1.2f;
            height = (int) (((float) height) + f);
            if (f == 0.0f) {
                z = false;
            } else {
                FrameLayout frameLayout2;
                if (f > 0.0f) {
                    frameLayout2 = this.jXQ;
                    if (frameLayout2 == null) {
                        C25052j.avw("videoViewContainer");
                    }
                    if (frameLayout2.getHeight() >= this.bpm) {
                        z = false;
                    }
                }
                if (f < 0.0f) {
                    frameLayout2 = this.jXQ;
                    if (frameLayout2 == null) {
                        C25052j.avw("videoViewContainer");
                    }
                    if (frameLayout2.getHeight() <= this.jWw) {
                        z = false;
                    }
                }
                if (f <= 0.0f || !canScrollVertically(-1)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            this.canScroll = z;
            if (this.canScroll) {
                int i = this.jWw;
                int i2 = this.bpm;
                if (i > height || i2 < height) {
                    z2 = false;
                }
                if (z2) {
                    setVideoHeight(height);
                } else if (height <= this.jWw) {
                    setVideoHeight(this.jWw);
                } else if (height >= this.bpm) {
                    setVideoHeight(this.bpm);
                }
            }
            this.hkf = this.hkh;
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this.jXS = false;
        }
        z = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(15270);
        return z;
    }

    private final void setVideoHeight(int i) {
        AppMethodBeat.m2504i(15271);
        FrameLayout frameLayout = this.jXQ;
        if (frameLayout == null) {
            C25052j.avw("videoViewContainer");
        }
        LayoutParams layoutParams = frameLayout.getLayoutParams();
        C44941v c44941v;
        if (layoutParams == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.m2505o(15271);
            throw c44941v;
        }
        layoutParams.height = i;
        FrameLayout frameLayout2 = this.jXQ;
        if (frameLayout2 == null) {
            C25052j.avw("videoViewContainer");
        }
        frameLayout2.setLayoutParams(layoutParams);
        View view = this.jXR;
        if (view == null) {
            C25052j.avw("animationContainerContainer");
        }
        if (view.getVisibility() == 0) {
            view = this.jXR;
            if (view == null) {
                C25052j.avw("animationContainerContainer");
            }
            layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                AppMethodBeat.m2505o(15271);
                throw c44941v;
            }
            layoutParams.height = i;
            View view2 = this.jXR;
            if (view2 == null) {
                C25052j.avw("animationContainerContainer");
            }
            view2.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(15271);
    }
}
