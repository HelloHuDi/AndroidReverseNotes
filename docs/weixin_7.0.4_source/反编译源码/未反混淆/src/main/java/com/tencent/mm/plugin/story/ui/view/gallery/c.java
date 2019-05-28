package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.listview.PullDownListView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c extends e {
    private float faK;
    private float faL;
    private float hke;
    private float hkf;
    private VelocityTracker oaQ;
    private int ozo;
    PullDownListView snD;
    View snE;
    private int snF = aj.fromDPToPix(ah.getContext(), 30);
    private boolean snG;
    private int snH;

    public c() {
        AppMethodBeat.i(110709);
        AppMethodBeat.o(110709);
    }

    public final boolean a(MotionEvent motionEvent, boolean z, int i) {
        float f = 0.0f;
        AppMethodBeat.i(110708);
        j.p(motionEvent, "event");
        if (this.oaQ == null) {
            this.oaQ = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.oaQ;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        PullDownListView pullDownListView;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.ozo = motionEvent.getPointerId(0);
                this.hke = motionEvent.getRawX();
                this.hkf = motionEvent.getRawY();
                this.snG = false;
                this.snH = 0;
                break;
            case 1:
            case 3:
                velocityTracker = this.oaQ;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                velocityTracker = this.oaQ;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                this.oaQ = null;
                if (this.snH != 1) {
                    if (this.snH == 2) {
                        pullDownListView = this.snD;
                        if (pullDownListView != null) {
                            pullDownListView.dLf();
                        }
                        Object systemService = ah.getContext().getSystemService("vibrator");
                        if (!(systemService instanceof Vibrator)) {
                            systemService = null;
                        }
                        Vibrator vibrator = (Vibrator) systemService;
                        if (vibrator != null) {
                            vibrator.vibrate(10);
                            break;
                        }
                    }
                }
                pullDownListView = this.snD;
                if (pullDownListView != null) {
                    pullDownListView.dispatchTouchEvent(motionEvent);
                    break;
                }
                break;
            case 2:
                if (z) {
                    this.snH = i;
                    this.faK = motionEvent.getRawX();
                    this.faL = motionEvent.getRawY();
                    float f2 = this.faL - this.hkf;
                    velocityTracker = this.oaQ;
                    if (velocityTracker != null) {
                        velocityTracker.computeCurrentVelocity(1000);
                    }
                    velocityTracker = this.oaQ;
                    float xVelocity = velocityTracker != null ? velocityTracker.getXVelocity(this.ozo) : 0.0f;
                    VelocityTracker velocityTracker2 = this.oaQ;
                    if (velocityTracker2 != null) {
                        f = velocityTracker2.getYVelocity(this.ozo);
                    }
                    if (i != 1) {
                        if (i == 2) {
                            LayoutParams layoutParams;
                            this.snG = true;
                            View view = this.snE;
                            if (view != null) {
                                layoutParams = view.getLayoutParams();
                            } else {
                                layoutParams = null;
                            }
                            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                            if (!(this.snD == null || marginLayoutParams == null)) {
                                marginLayoutParams.topMargin = (int) (f2 / 15.0f);
                                View view2 = this.snE;
                                if (view2 != null) {
                                    view2.setLayoutParams(marginLayoutParams);
                                    break;
                                }
                            }
                        }
                    }
                    this.snG = true;
                    if (Math.abs(f2) > ((float) this.snF) && Math.abs(f) > Math.abs(xVelocity)) {
                        pullDownListView = this.snD;
                        if (pullDownListView != null) {
                            pullDownListView.dispatchTouchEvent(motionEvent);
                            break;
                        }
                    }
                }
                break;
        }
        boolean z2 = this.snG;
        AppMethodBeat.o(110708);
        return z2;
    }

    public final int cCD() {
        return 3;
    }
}
