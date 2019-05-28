package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C45618f;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView */
public class WxaScrollView extends FrameLayout implements C38287n, C45592o, C45618f {
    private int eHE;
    private float hIW;
    private int hIX;
    private Paint hIY = new Paint();
    private FrameLayout hJg;
    private ScrollView hJh;
    private C42491m hJi;
    private boolean hJj = true;
    private boolean hJk = true;
    /* renamed from: nJ */
    private float f4351nJ;

    public WxaScrollView(Context context) {
        super(context);
        AppMethodBeat.m2504i(126323);
        init();
        AppMethodBeat.m2505o(126323);
    }

    public WxaScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(126324);
        init();
        AppMethodBeat.m2505o(126324);
    }

    public WxaScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(126325);
        init();
        AppMethodBeat.m2505o(126325);
    }

    private void init() {
        AppMethodBeat.m2504i(126326);
        this.hJh = new ScrollView(getContext()) {
            /* Access modifiers changed, original: protected|final */
            public final void onScrollChanged(int i, int i2, int i3, int i4) {
                AppMethodBeat.m2504i(126321);
                super.onScrollChanged(i, i2, i3, i4);
                if (WxaScrollView.this.hJi != null) {
                    WxaScrollView.this.hJi.mo44686p(WxaScrollView.this, i, i2);
                }
                AppMethodBeat.m2505o(126321);
            }

            public final boolean onTouchEvent(MotionEvent motionEvent) {
                AppMethodBeat.m2504i(126322);
                switch (motionEvent.getAction()) {
                    case 2:
                        if (!WxaScrollView.this.hJj) {
                            C45124d.m82927e("MicroMsg.WxaScrollView", "can not move");
                            AppMethodBeat.m2505o(126322);
                            return false;
                        }
                        break;
                }
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(126322);
                return onTouchEvent;
            }
        };
        this.hJg = new FrameLayout(getContext());
        super.addView(this.hJh, 0, new LayoutParams(-1, -1));
        this.hJh.addView(this.hJg, 0, new LayoutParams(-1, -2));
        this.hIY.setStyle(Style.STROKE);
        this.hIY.setAntiAlias(true);
        setWillNotDraw(false);
        AppMethodBeat.m2505o(126326);
    }

    public void draw(Canvas canvas) {
        Object obj;
        float f = 0.0f;
        AppMethodBeat.m2504i(126327);
        Object obj2 = this.hIW > 0.0f ? 1 : null;
        if (obj2 != null) {
            canvas.save();
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.hIW, this.hIW, Direction.CW);
            canvas.clipPath(path);
        }
        if (this.eHE != 0) {
            canvas.drawColor(this.eHE);
        }
        if (this.f4351nJ > 0.0f) {
            float f2 = this.f4351nJ / 2.0f;
            canvas.drawRoundRect(new RectF(f2, f2, ((float) getWidth()) - f2, ((float) getHeight()) - f2), this.hIW, this.hIW, this.hIY);
            if (obj2 != null) {
                canvas.restore();
            }
            canvas.save();
            Path path2 = new Path();
            if (this.hIW > 0.0f && this.hIW - this.f4351nJ > 0.0f) {
                f = this.hIW - this.f4351nJ;
            }
            path2.addRoundRect(new RectF(this.f4351nJ, this.f4351nJ, ((float) getWidth()) - this.f4351nJ, ((float) getHeight()) - this.f4351nJ), f, f, Direction.CW);
            canvas.clipPath(path2);
            obj = 1;
        } else {
            obj = obj2;
        }
        int save = canvas.save();
        super.draw(canvas);
        canvas.restoreToCount(save);
        if (obj != null) {
            canvas.restore();
        }
        AppMethodBeat.m2505o(126327);
    }

    public ViewGroup getTargetView() {
        return this.hJg;
    }

    public int getTargetViewChildCount() {
        AppMethodBeat.m2504i(126328);
        int childCount = this.hJg.getChildCount();
        AppMethodBeat.m2505o(126328);
        return childCount;
    }

    public void addView(View view, int i) {
        AppMethodBeat.m2504i(126329);
        this.hJg.addView(view, i);
        AppMethodBeat.m2505o(126329);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(126330);
        this.hJg.addView(view, i, layoutParams);
        AppMethodBeat.m2505o(126330);
    }

    public void removeView(View view) {
        AppMethodBeat.m2504i(126331);
        this.hJg.removeView(view);
        AppMethodBeat.m2505o(126331);
    }

    public void setBorderRadius(float f) {
        this.hIW = f;
    }

    public void setBorderColor(int i) {
        AppMethodBeat.m2504i(126332);
        this.hIX = i;
        this.hIY.setColor(i);
        AppMethodBeat.m2505o(126332);
    }

    public void setBorderWidth(float f) {
        AppMethodBeat.m2504i(126333);
        this.f4351nJ = f;
        this.hIY.setStrokeWidth(f);
        AppMethodBeat.m2505o(126333);
    }

    public void setBgColor(int i) {
        this.eHE = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(126334);
        if (motionEvent.getActionMasked() == 0) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.hIW > 0.0f) {
                double pow = Math.pow((double) this.hIW, 2.0d);
                float width = (float) getWidth();
                float height = (float) getHeight();
                if (x < this.hIW) {
                    if (y < this.hIW) {
                        if (Math.pow((double) (this.hIW - y), 2.0d) + Math.pow((double) (this.hIW - x), 2.0d) > pow) {
                            z = false;
                            if (!z) {
                                AppMethodBeat.m2505o(126334);
                                return false;
                            }
                        }
                    } else if (y > height - this.hIW) {
                        if (Math.pow((double) ((this.hIW + y) - height), 2.0d) + Math.pow((double) (this.hIW - x), 2.0d) > pow) {
                            z = false;
                            if (z) {
                            }
                        }
                    }
                } else if (x > width - this.hIW) {
                    if (y < this.hIW) {
                        if (Math.pow((double) (this.hIW - y), 2.0d) + Math.pow((double) ((x + this.hIW) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                            }
                        }
                    } else if (y > height - this.hIW) {
                        if (Math.pow((double) ((this.hIW + y) - height), 2.0d) + Math.pow((double) ((x + this.hIW) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                            }
                        }
                    }
                }
            }
            z = true;
            if (z) {
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(126334);
        return dispatchTouchEvent;
    }

    public void setOnScrollChangedListener(C42491m c42491m) {
        this.hJi = c42491m;
    }

    public void setScrollVertical(boolean z) {
        this.hJj = z;
    }

    public void setScrollHorizontal(boolean z) {
        this.hJk = z;
    }

    public void scrollTo(int i, int i2) {
        AppMethodBeat.m2504i(126335);
        this.hJh.scrollTo(i, i2);
        invalidate();
        AppMethodBeat.m2505o(126335);
    }
}
