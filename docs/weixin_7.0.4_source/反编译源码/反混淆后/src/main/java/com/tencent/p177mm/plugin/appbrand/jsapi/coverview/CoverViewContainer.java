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
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C45618f;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer */
public class CoverViewContainer extends AppBrandNativeContainerView implements C45618f {
    private View aph;
    private int eHE;
    private float hIW;
    private int hIX;
    private Paint hIY = new Paint();
    /* renamed from: nJ */
    private float f16149nJ;

    public CoverViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(91049);
        init();
        AppMethodBeat.m2505o(91049);
    }

    public CoverViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(91050);
        init();
        AppMethodBeat.m2505o(91050);
    }

    public void setTargetView(View view) {
        AppMethodBeat.m2504i(91051);
        this.aph = view;
        super.addView(view, 0, new LayoutParams(-1, -1));
        AppMethodBeat.m2505o(91051);
    }

    public CoverViewContainer(Context context, View view) {
        super(context);
        AppMethodBeat.m2504i(91052);
        setTargetView(view);
        init();
        AppMethodBeat.m2505o(91052);
    }

    private void init() {
        AppMethodBeat.m2504i(91053);
        this.hIY.setStyle(Style.STROKE);
        this.hIY.setAntiAlias(true);
        setWillNotDraw(false);
        AppMethodBeat.m2505o(91053);
    }

    public void draw(Canvas canvas) {
        Object obj;
        float f = 0.0f;
        AppMethodBeat.m2504i(91054);
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
        if (this.f16149nJ > 0.0f) {
            float f2 = this.f16149nJ / 2.0f;
            canvas.drawRoundRect(new RectF(f2, f2, ((float) getWidth()) - f2, ((float) getHeight()) - f2), this.hIW, this.hIW, this.hIY);
            if (obj2 != null) {
                canvas.restore();
            }
            canvas.save();
            Path path2 = new Path();
            if (this.hIW > 0.0f && this.hIW - this.f16149nJ > 0.0f) {
                f = this.hIW - this.f16149nJ;
            }
            path2.addRoundRect(new RectF(this.f16149nJ, this.f16149nJ, ((float) getWidth()) - this.f16149nJ, ((float) getHeight()) - this.f16149nJ), f, f, Direction.CW);
            canvas.clipPath(path2);
            obj = 1;
        } else {
            obj = obj2;
        }
        super.draw(canvas);
        if (obj != null) {
            canvas.restore();
        }
        AppMethodBeat.m2505o(91054);
    }

    /* renamed from: ah */
    public final <T> T mo60996ah(Class<T> cls) {
        AppMethodBeat.m2504i(91055);
        try {
            if (cls.isAssignableFrom(this.aph.getClass())) {
                View view = this.aph;
                AppMethodBeat.m2505o(91055);
                return view;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(91055);
        return null;
    }

    public void addView(View view, int i) {
        AppMethodBeat.m2504i(91056);
        if (i < 0) {
            i = 0;
        } else if (i > getChildCount() - 1) {
            i = getChildCount() - 1;
        }
        super.addView(view, i + 1);
        AppMethodBeat.m2505o(91056);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(91057);
        if (i < 0) {
            i = 0;
        } else if (i > getChildCount() - 1) {
            i = getChildCount() - 1;
        }
        super.addView(view, i + 1, layoutParams);
        AppMethodBeat.m2505o(91057);
    }

    public void setBorderRadius(float f) {
        this.hIW = f;
    }

    public void setBorderColor(int i) {
        AppMethodBeat.m2504i(91058);
        this.hIX = i;
        this.hIY.setColor(i);
        AppMethodBeat.m2505o(91058);
    }

    public void setBorderWidth(float f) {
        AppMethodBeat.m2504i(91059);
        this.f16149nJ = f;
        this.hIY.setStrokeWidth(f);
        AppMethodBeat.m2505o(91059);
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
        AppMethodBeat.m2504i(91060);
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
                                AppMethodBeat.m2505o(91060);
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
        AppMethodBeat.m2505o(91060);
        return dispatchTouchEvent;
    }
}
