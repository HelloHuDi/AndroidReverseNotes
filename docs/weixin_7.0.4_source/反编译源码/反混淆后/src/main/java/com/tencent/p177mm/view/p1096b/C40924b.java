package com.tencent.p177mm.view.p1096b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.p226e.C1493a;
import com.tencent.p177mm.p834b.C41784d;
import com.tencent.p177mm.p834b.C41784d.C375032;
import com.tencent.p177mm.p834b.C41784d.C417831;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.model.WMElement;

/* renamed from: com.tencent.mm.view.b.b */
public final class C40924b extends C30844a {
    private C41784d Ach = new C41784d(this);
    private PointF Aci = new PointF();
    private float Acj = 0.0f;
    private float Ack = 0.0f;
    private boolean Acl = false;
    public boolean Acm = false;

    public C40924b(Context context, C18117b c18117b) {
        super(context, c18117b);
        AppMethodBeat.m2504i(116416);
        AppMethodBeat.m2505o(116416);
    }

    public final boolean dMM() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116417);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(getMainMatrix());
        canvas.save();
        canvas.clipRect(getAliveRect());
        Bitmap dlV = getPresenter().dlV();
        if (!(dlV == null || dlV.isRecycled())) {
            canvas.drawBitmap(dlV, 0.0f, 0.0f, null);
        }
        canvas.restore();
        getPresenter().onDraw(canvas);
        AppMethodBeat.m2505o(116417);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: V */
    public final void mo49331V(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116418);
        float x = motionEvent.getX(motionEvent.getPointerCount() - 1);
        float y = motionEvent.getY(motionEvent.getPointerCount() - 1);
        float centerX;
        float minScale;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.Aci.set(x, y);
                this.Acj = 0.0f;
                this.Ack = getCurScale();
                C41784d c41784d = this.Ach;
                C4990ab.m7410d("MicroMsg.StickRoundAnim", "[cancel]");
                if (c41784d.f17165rD != null && (c41784d.f17165rD.isRunning() || c41784d.f17165rD.isStarted())) {
                    c41784d.f17165rD.cancel();
                }
                this.Acm = false;
                break;
            case 1:
                this.Acj = 0.0f;
                if (this.Acm) {
                    C41784d c41784d2 = this.Ach;
                    if (c41784d2.cco) {
                        C4990ab.m7410d("MicroMsg.StickRoundAnim", "[play] start");
                        RectF curImageRect = c41784d2.ccv.getCurImageRect();
                        Rect boardRect = c41784d2.ccv.getBoardRect();
                        c41784d2.ccw = curImageRect.centerX();
                        c41784d2.ccx = curImageRect.centerY();
                        float centerY = ((float) boardRect.centerY()) - curImageRect.centerY();
                        centerX = ((float) boardRect.centerX()) - curImageRect.centerX();
                        float curScale = c41784d2.ccv.getCurScale();
                        float maxScale = c41784d2.ccv.getMaxScale();
                        minScale = c41784d2.ccv.getMinScale();
                        if (curScale > maxScale) {
                            c41784d2.mScale = maxScale;
                            c41784d2.ccy = true;
                        } else if (curScale < minScale) {
                            c41784d2.mScale = minScale;
                            c41784d2.ccy = true;
                        } else {
                            c41784d2.ccy = false;
                        }
                        Object obj = ((float) boardRect.height()) < curImageRect.height() ? 1 : null;
                        Object obj2 = ((float) boardRect.width()) < curImageRect.width() ? 1 : null;
                        if (obj != null) {
                            centerY = 0.0f;
                        }
                        if (obj2 != null) {
                            centerX = 0.0f;
                        }
                        if (curImageRect.top > ((float) boardRect.top) && obj != null) {
                            minScale = ((float) boardRect.top) - curImageRect.top;
                        } else if (curImageRect.bottom >= ((float) boardRect.bottom) || obj == null) {
                            minScale = centerY;
                        } else {
                            minScale = ((float) boardRect.bottom) - curImageRect.bottom;
                        }
                        if (curImageRect.left > ((float) boardRect.left) && obj2 != null) {
                            centerX = ((float) boardRect.left) - curImageRect.left;
                        } else if (curImageRect.right < ((float) boardRect.right) && obj2 != null) {
                            centerX = ((float) boardRect.right) - curImageRect.right;
                        }
                        C4990ab.m7411d("MicroMsg.StickRoundAnim", "%s %s ", Float.valueOf(centerX), Float.valueOf(minScale));
                        if (curScale > maxScale) {
                            c41784d2.ccz = true;
                        } else {
                            c41784d2.ccz = false;
                        }
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, minScale});
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, centerX});
                        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(WMElement.ANIMATE_TYPE_SCALE, new float[]{0.0f, 80.0f});
                        c41784d2.f17165rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3});
                        c41784d2.f17165rD.addUpdateListener(new C417831(curScale));
                        c41784d2.f17165rD.addListener(new C375032());
                        c41784d2.f17165rD.setInterpolator(new LinearInterpolator());
                        c41784d2.f17165rD.setDuration(80);
                        c41784d2.f17165rD.start();
                        break;
                    }
                }
                break;
            case 2:
                if (!this.Acl) {
                    if (motionEvent.getPointerCount() != 2) {
                        if (motionEvent.getPointerCount() == 1 && dML()) {
                            this.Acm = true;
                            this.Ach.cco = true;
                            translate(x, y);
                            postInvalidate();
                            break;
                        }
                    }
                    this.Acm = true;
                    minScale = motionEvent.getX(0) - motionEvent.getX(1);
                    centerX = motionEvent.getY(0) - motionEvent.getY(1);
                    minScale = (float) Math.sqrt((double) ((minScale * minScale) + (centerX * centerX)));
                    if (this.Acj != 0.0f) {
                        minScale = (minScale / this.Acj) * this.Ack;
                        if (this.AbY * 0.5f <= minScale) {
                            if (minScale > this.AbX) {
                                minScale = ((minScale - this.AbX) * 0.2f) + this.AbX;
                            }
                            getMainMatrix().postScale(minScale / getCurScale(), minScale / getCurScale(), x, y);
                        }
                        this.Ach.cco = true;
                        translate(x, y);
                        postInvalidate();
                        break;
                    }
                    this.Acj = minScale;
                    break;
                }
                this.Acl = false;
                AppMethodBeat.m2505o(116418);
                return;
            case 5:
                this.Acj = 0.0f;
                this.Ack = getCurScale();
                break;
            case 6:
                this.Acj = 0.0f;
                this.Acl = true;
                break;
        }
        this.Aci.x = x;
        this.Aci.y = y;
        AppMethodBeat.m2505o(116418);
    }

    private void translate(float f, float f2) {
        AppMethodBeat.m2504i(116419);
        RectF curImageRect = getCurImageRect();
        float f3 = f - this.Aci.x;
        float f4 = f2 - this.Aci.y;
        if (f3 > 0.0f) {
            if (((float) getBoardRect().left) <= curImageRect.left) {
                f3 *= 0.5f;
            } else if (Math.abs(f3) > Math.abs(curImageRect.left - ((float) getBoardRect().left))) {
                f3 = ((float) getBoardRect().left) - curImageRect.left;
            }
        } else if (((float) getBoardRect().right) >= curImageRect.right) {
            f3 *= 0.5f;
        } else if (Math.abs(f3) > Math.abs(((float) getBoardRect().right) - curImageRect.right)) {
            f3 = ((float) getBoardRect().right) - curImageRect.right;
        }
        if (f4 > 0.0f) {
            if (((float) getBoardRect().top) <= curImageRect.top) {
                f4 *= 0.5f;
            } else if (Math.abs(f4) > Math.abs(curImageRect.top - ((float) getBoardRect().top))) {
                f4 = ((float) getBoardRect().top) - curImageRect.top;
            }
        } else if (((float) getBoardRect().bottom) >= curImageRect.bottom) {
            f4 *= 0.5f;
        } else if (Math.abs(f4) > Math.abs(((float) getBoardRect().bottom) - curImageRect.bottom)) {
            f4 = ((float) getBoardRect().bottom) - curImageRect.bottom;
        }
        getMainMatrix().postTranslate(f3, f4);
        AppMethodBeat.m2505o(116419);
    }

    public final float getMinScale() {
        AppMethodBeat.m2504i(116420);
        float width;
        if (getPresenter().dlU().mo4943CG() == C1493a.CROP_PHOTO) {
            width = ((float) getBoardRect().width()) / getCurImageRect().width();
            float height = ((float) getBoardRect().height()) / getCurImageRect().height();
            if (width <= height) {
                width = height;
            }
            width *= getCurScale();
            AppMethodBeat.m2505o(116420);
            return width;
        }
        width = super.getMinScale();
        AppMethodBeat.m2505o(116420);
        return width;
    }
}
