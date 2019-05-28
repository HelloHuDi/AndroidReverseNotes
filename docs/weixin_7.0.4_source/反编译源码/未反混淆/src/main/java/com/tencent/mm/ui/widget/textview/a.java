package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.aj;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private boolean aGx = true;
    private OnAttachStateChangeListener aaA;
    private OnGlobalLayoutListener aeL;
    OnTouchListener jZu;
    OnClickListener lDG;
    Context mContext;
    int[] rGg = new int[2];
    int[] yJQ = new int[2];
    private OnPreDrawListener yL;
    boolean zWA = false;
    boolean zWB = false;
    public boolean zWC = true;
    public boolean zWD = true;
    boolean zWE = true;
    boolean zWF = false;
    boolean zWG = false;
    final Runnable zWH = new Runnable() {
        public final void run() {
            AppMethodBeat.i(113118);
            if (a.this.zWA) {
                ai.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
                AppMethodBeat.o(113118);
                return;
            }
            ai.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", Boolean.valueOf(a.this.zWE), Boolean.valueOf(a.this.zWF));
            if (a.this.zWn == null) {
                if (!a.this.zWC) {
                    a.this.dLS();
                }
                if (!a.this.zWD) {
                    a.this.dLO();
                }
            } else if (!a.this.zWE) {
                a.this.zWE = true;
                if (a.this.zWF) {
                    ai.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", Boolean.valueOf(a.this.zWC), Boolean.valueOf(a.this.zWD));
                    if (!a.this.zWC) {
                        a.this.dLS();
                    }
                    if (!a.this.zWD) {
                        a.this.dLO();
                        a.this.hH(a.this.zWk.aqm, a.this.zWk.Ls);
                    }
                    if (!(a.this.zWn == null || !a.this.zWC || a.this.zWD)) {
                        a.this.zWn.eQ(a.this.zWm);
                    }
                }
                a.this.zWF = false;
                AppMethodBeat.o(113118);
                return;
            } else if (a.this.zWG) {
                a.this.zWG = false;
                ai.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
                if (a.this.zWJ != null) {
                    a.this.zWJ.dHp();
                    AppMethodBeat.o(113118);
                    return;
                }
            } else {
                ai.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
                AppMethodBeat.o(113118);
                return;
            }
            AppMethodBeat.o(113118);
        }
    };
    final Runnable zWI = new Runnable() {
        public final void run() {
            AppMethodBeat.i(113121);
            ai.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
            if (a.this.zWJ != null) {
                a.this.zWJ.dHp();
            }
            AppMethodBeat.o(113121);
        }
    };
    public e zWJ;
    ArrayList<c> zWK;
    b zWi;
    private b zWj;
    g zWk = new g();
    public d zWl;
    View zWm;
    public f zWn;
    OnTouchListener zWo;
    private Spannable zWp;
    private com.tencent.mm.ui.widget.b.a zWq;
    int zWr;
    int zWs;
    private int zWt;
    int zWu;
    int zWv;
    private com.tencent.mm.ui.base.c zWw;
    int zWx;
    public int zWy;
    private OnScrollChangedListener zWz;

    public static abstract class f {
        public void eQ(View view) {
        }

        public void dismiss() {
        }

        public void eR(View view) {
        }
    }

    class g {
        int Ls;
        int aqm;
        String zWW;

        g() {
        }
    }

    public interface e {
        void dHp();
    }

    class c {
        int end;
        int start;

        c() {
        }

        /* Access modifiers changed, original: final */
        public final boolean vX(int i) {
            return i >= this.start && i < this.end;
        }

        public final String toString() {
            AppMethodBeat.i(113142);
            String str = "start: " + this.start + " end: " + this.end;
            AppMethodBeat.o(113142);
            return str;
        }
    }

    public static class a {
        OnClickListener lDG;
        com.tencent.mm.ui.widget.b.a zWM;
        public int zWN;
        View zWm;
        f zWn;
        OnTouchListener zWo;
        public int zWt;
        public int zWu;

        public a(View view, com.tencent.mm.ui.widget.b.a aVar) {
            this.zWu = R.color.l7;
            this.zWt = R.color.z1;
            this.zWN = 0;
            this.zWm = view;
            this.zWM = aVar;
        }

        public a(View view, com.tencent.mm.ui.widget.b.a aVar, f fVar, OnClickListener onClickListener, OnTouchListener onTouchListener) {
            this(view, aVar);
            this.zWn = fVar;
            this.lDG = onClickListener;
            this.zWo = onTouchListener;
        }

        public final a dLT() {
            AppMethodBeat.i(113130);
            a aVar = new a(this);
            AppMethodBeat.o(113130);
            return aVar;
        }
    }

    public interface d {
        void af(CharSequence charSequence);
    }

    class b extends View {
        private int eno = 25;
        private int mHeight = (this.uQR * 2);
        private Paint mPaint;
        PopupWindow mPopupWindow;
        int mWidth = (this.uQR * 2);
        private Rect rect = new Rect();
        private int uQR = (a.this.zWv / 2);
        private int[] yJQ = new int[2];
        boolean zWO;
        private int zWP;
        private int zWQ;
        private int zWR;
        private int zWS;
        int[] zWT = new int[2];
        private Point zWU = new Point();
        private boolean zWV = false;

        b(boolean z) {
            super(a.this.mContext);
            AppMethodBeat.i(113131);
            this.zWO = z;
            this.mPaint = new Paint(1);
            this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.zWu));
            this.mPopupWindow = new PopupWindow(this);
            this.mPopupWindow.setClippingEnabled(false);
            this.mPopupWindow.setWidth(this.mWidth + (this.eno * 2));
            this.mPopupWindow.setHeight(this.mHeight + (this.eno / 2));
            invalidate();
            AppMethodBeat.o(113131);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDraw(Canvas canvas) {
            AppMethodBeat.i(113132);
            if (a.this.zWn != null) {
                int aq;
                int i = this.zWO ? a.this.zWk.aqm : a.this.zWk.Ls;
                TextPaint ft = b.ft(a.this.zWm);
                if (ft != null) {
                    aq = ((int) ft.getFontMetrics().descent) + b.aq(a.this.zWm, b.ar(a.this.zWm, i));
                    i = (int) b.as(a.this.zWm, i);
                } else {
                    i = 0;
                    aq = 0;
                }
                a.this.zWm.getLocationInWindow(this.zWT);
                if (!this.zWO) {
                    aq = hI(i, aq)[1];
                }
                i = dLX() + aq;
                if (!a.this.zWm.getGlobalVisibleRect(this.rect, this.zWU)) {
                    ai.d("SelectableTextHelper", "view invisible.", new Object[0]);
                    AppMethodBeat.o(113132);
                    return;
                } else if (i >= this.rect.bottom) {
                    if (this.zWO) {
                        ai.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
                        a.this.dLM();
                        a.this.zWC = true;
                        a.this.zWD = true;
                        a.this.dLL();
                        a.this.zWn.dismiss();
                    }
                    ai.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
                    AppMethodBeat.o(113132);
                    return;
                } else if (i <= this.rect.top) {
                    if (!this.zWO) {
                        ai.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
                        a.this.dLM();
                        a.this.zWC = true;
                        a.this.zWD = true;
                        a.this.dLL();
                        a.this.zWn.dismiss();
                    }
                    ai.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
                    AppMethodBeat.o(113132);
                    return;
                }
            }
            canvas.drawCircle((float) (this.uQR + this.eno), (float) this.uQR, (float) this.uQR, this.mPaint);
            if (this.zWO) {
                canvas.drawRect((float) (this.uQR + this.eno), 0.0f, (float) ((this.uQR * 2) + this.eno), (float) this.uQR, this.mPaint);
                AppMethodBeat.o(113132);
                return;
            }
            canvas.drawRect((float) this.eno, 0.0f, (float) (this.uQR + this.eno), (float) this.uQR, this.mPaint);
            AppMethodBeat.o(113132);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(113133);
            switch (motionEvent.getAction()) {
                case 0:
                    this.zWR = a.this.zWk.aqm;
                    this.zWS = a.this.zWk.Ls;
                    this.zWP = (int) motionEvent.getX();
                    this.zWQ = (int) motionEvent.getY();
                    this.zWV = false;
                    a.this.zWm.getLocationInWindow(this.yJQ);
                    break;
                case 1:
                case 3:
                    if (a.this.zWn == null || this.zWV) {
                        if (!a.this.zWC) {
                            a.this.dLS();
                            break;
                        }
                    }
                    this.zWV = true;
                    if (a.this.zWk.Ls - a.this.zWk.aqm != b.fs(a.this.zWm).length()) {
                        a.this.zWn.dismiss();
                        a.this.zWC = false;
                        a.this.dLS();
                        break;
                    }
                    a.this.zWn.eQ(a.this.zWm);
                    a.this.zWC = true;
                    a.this.dLQ();
                    break;
                    break;
                case 2:
                    if (a.this.zWn != null) {
                        a.this.zWn.dismiss();
                    }
                    a.this.dLQ();
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    if (a.this.zWn != null) {
                        update((rawX - this.yJQ[0]) + this.uQR, ((rawY + this.zWQ) - this.mHeight) - a.this.zWx);
                        break;
                    }
                    update(rawX - this.yJQ[0], ((rawY + this.zWQ) - this.mHeight) - a.this.zWx);
                    break;
            }
            AppMethodBeat.o(113133);
            return true;
        }

        private void dLU() {
            AppMethodBeat.i(113134);
            this.zWO = !this.zWO;
            invalidate();
            AppMethodBeat.o(113134);
        }

        private void update(int i, int i2) {
            int i3;
            AppMethodBeat.i(113135);
            a.this.zWm.getLocationInWindow(this.zWT);
            if (this.zWO) {
                i3 = a.this.zWk.aqm;
            } else {
                i3 = a.this.zWk.Ls;
            }
            int d = b.d(a.this.zWm, i, i2 - this.zWT[1], i3);
            if (d != i3) {
                a.this.dLM();
                b a;
                if (this.zWO) {
                    if (d > this.zWS) {
                        a = a.a(a.this, false);
                        dLU();
                        a.dLU();
                        this.zWR = this.zWS;
                        a.this.hH(this.zWS, d);
                        a.dLV();
                    } else {
                        a.this.hH(d, -1);
                    }
                    dLV();
                    AppMethodBeat.o(113135);
                    return;
                }
                if (d < this.zWR) {
                    a = a.a(a.this, true);
                    a.dLU();
                    dLU();
                    this.zWS = this.zWR;
                    a.this.hH(d, this.zWR);
                    a.dLV();
                } else {
                    a.this.hH(this.zWR, d);
                }
                dLV();
            }
            AppMethodBeat.o(113135);
        }

        private void dLV() {
            AppMethodBeat.i(113136);
            a.this.zWm.getLocationInWindow(this.zWT);
            TextPaint ft = b.ft(a.this.zWm);
            if (ft != null) {
                int i = (int) ft.getFontMetrics().descent;
                if (this.zWO) {
                    this.mPopupWindow.update((((int) b.as(a.this.zWm, a.this.zWk.aqm)) - this.mWidth) + dLW(), (i + b.aq(a.this.zWm, b.ar(a.this.zWm, a.this.zWk.aqm))) + dLX(), -1, -1);
                    AppMethodBeat.o(113136);
                    return;
                }
                int[] hI = hI((int) b.as(a.this.zWm, a.this.zWk.Ls), i + b.aq(a.this.zWm, b.ar(a.this.zWm, a.this.zWk.Ls)));
                this.mPopupWindow.update(hI[0] + dLW(), hI[1] + dLX(), -1, -1);
            }
            AppMethodBeat.o(113136);
        }

        public final int dLW() {
            AppMethodBeat.i(113137);
            int paddingLeft = (this.zWT[0] - this.eno) + a.this.zWm.getPaddingLeft();
            AppMethodBeat.o(113137);
            return paddingLeft;
        }

        public final int dLX() {
            AppMethodBeat.i(113138);
            int paddingTop = this.zWT[1] + a.this.zWm.getPaddingTop();
            AppMethodBeat.o(113138);
            return paddingTop;
        }

        /* Access modifiers changed, original: final */
        public final int[] hI(int i, int i2) {
            AppMethodBeat.i(113139);
            int[] iArr = new int[2];
            if (i == 0 && a.this.zWk.Ls > 1) {
                a.this.zWm.getLocationInWindow(this.zWT);
                TextPaint ft = b.ft(a.this.zWm);
                if (ft != null) {
                    int i3 = (int) ft.getFontMetrics().descent;
                    i = (int) b.av(a.this.zWm, b.ar(a.this.zWm, a.this.zWk.Ls - 1));
                    i2 = b.aq(a.this.zWm, b.ar(a.this.zWm, a.this.zWk.Ls - 1)) + i3;
                }
            }
            iArr[0] = i;
            iArr[1] = i2;
            AppMethodBeat.o(113139);
            return iArr;
        }

        public final void dLY() {
            AppMethodBeat.i(113140);
            this.mPopupWindow.setOutsideTouchable(true);
            AppMethodBeat.o(113140);
        }

        public final void setTouchInterceptor(OnTouchListener onTouchListener) {
            AppMethodBeat.i(113141);
            this.mPopupWindow.setTouchInterceptor(onTouchListener);
            AppMethodBeat.o(113141);
        }

        public final void setOnDismissListener(OnDismissListener onDismissListener) {
            AppMethodBeat.i(138212);
            this.mPopupWindow.setOnDismissListener(onDismissListener);
            AppMethodBeat.o(138212);
        }
    }

    public a(a aVar) {
        AppMethodBeat.i(113143);
        this.zWm = aVar.zWm;
        this.zWn = aVar.zWn;
        this.lDG = aVar.lDG;
        this.zWo = aVar.zWo;
        this.zWq = aVar.zWM;
        this.mContext = this.zWm.getContext();
        this.zWt = aVar.zWt;
        this.zWu = aVar.zWu;
        View view = this.zWm;
        int lineHeight = view instanceof NeatTextView ? ((NeatTextView) view).getLineHeight() : view instanceof TextView ? ((TextView) view).getLineHeight() : 0;
        this.zWx = lineHeight;
        if (this.zWv == 0) {
            float textSize;
            view = this.zWm;
            if (view instanceof NeatTextView) {
                textSize = ((NeatTextView) view).getTextSize();
            } else if (view instanceof TextView) {
                textSize = ((TextView) view).getTextSize();
            } else {
                textSize = 0.0f;
            }
            this.zWv = (int) textSize;
        } else {
            this.zWv = aj.fromDPToPix(this.mContext, aVar.zWN);
        }
        this.aaA = new OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
                AppMethodBeat.i(113122);
                ai.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
                AppMethodBeat.o(113122);
            }

            public final void onViewDetachedFromWindow(View view) {
                AppMethodBeat.i(113123);
                ai.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
                a.this.destroy();
                AppMethodBeat.o(113123);
            }
        };
        this.yL = new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(113124);
                if (a.this.zWB) {
                    a.this.zWB = false;
                    a aVar = a.this;
                    aVar.zWm.removeCallbacks(aVar.zWH);
                    aVar.zWm.postDelayed(aVar.zWH, 100);
                }
                AppMethodBeat.o(113124);
                return true;
            }
        };
        this.zWz = new OnScrollChangedListener() {
            public final void onScrollChanged() {
                AppMethodBeat.i(113125);
                if (a.this.zWn != null) {
                    a.this.zWm.removeCallbacks(a.this.zWI);
                    a.this.zWm.getLocationInWindow(a.this.yJQ);
                    ai.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", Integer.valueOf(a.this.rGg[1]), Integer.valueOf(a.this.yJQ[1]));
                    if (a.this.zWE) {
                        if (a.this.zWF || a.this.zWG) {
                            if (a.this.zWG) {
                                a.this.zWG = false;
                                a.this.zWE = false;
                                if (a.this.rGg[1] != a.this.yJQ[1]) {
                                    a.this.zWF = true;
                                    ai.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
                                } else {
                                    a.this.zWF = false;
                                    ai.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
                                }
                            }
                        } else if (a.this.rGg[1] != a.this.yJQ[1]) {
                            a.this.zWF = true;
                            a.this.zWE = false;
                            ai.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
                        } else {
                            a.this.zWG = true;
                            ai.d("SelectableTextHelper", "need delay judge.", new Object[0]);
                        }
                    }
                    a.this.rGg[1] = a.this.yJQ[1];
                }
                if (!(a.this.zWB || (a.this.zWC && a.this.zWD))) {
                    a.this.zWB = true;
                    a.this.dLL();
                }
                AppMethodBeat.o(113125);
            }
        };
        this.aeL = new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(113126);
                ai.d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
                if (a.this.zWn != null) {
                    a.this.dLM();
                    a.this.zWC = true;
                    a.this.zWD = true;
                    a.this.dLL();
                }
                AppMethodBeat.o(113126);
            }
        };
        this.jZu = new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(113127);
                if (a.this.zWo != null) {
                    a.this.zWo.onTouch(view, motionEvent);
                }
                a.this.zWr = (int) motionEvent.getX();
                a.this.zWs = (int) motionEvent.getY();
                AppMethodBeat.o(113127);
                return false;
            }
        };
        init();
        AppMethodBeat.o(113143);
    }

    public final void init() {
        AppMethodBeat.i(113144);
        if (this.aGx) {
            ai.d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
            this.zWA = false;
            this.aGx = false;
            this.zWB = false;
            if (this.zWn == null) {
                b.a(this.zWm, b.fs(this.zWm), BufferType.SPANNABLE);
            }
            this.zWi = new b(true);
            if (this.zWn != null) {
                this.zWi.dLY();
                this.zWi.setTouchInterceptor(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(138210);
                        ai.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        if (motionEvent.getAction() == 0 && (x < 0 || x >= a.this.zWi.getWidth() || y < 0 || y >= a.this.zWi.getHeight())) {
                            ai.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
                            a.this.zWm.postDelayed(a.this.zWI, 100);
                            AppMethodBeat.o(138210);
                            return true;
                        } else if (motionEvent.getAction() == 4) {
                            ai.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
                            a.this.zWm.postDelayed(a.this.zWI, 100);
                            AppMethodBeat.o(138210);
                            return true;
                        } else {
                            AppMethodBeat.o(138210);
                            return false;
                        }
                    }
                });
                this.zWi.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.i(138211);
                        a.this.zWm.setOnTouchListener(a.this.jZu);
                        AppMethodBeat.o(138211);
                    }
                });
            }
            this.zWj = new b(false);
            this.zWm.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(138207);
                    ai.d("SelectableTextHelper", "onLongClick", new Object[0]);
                    a.this.zWA = false;
                    int i;
                    int nextSpanTransition;
                    if (a.this.zWn != null) {
                        a.this.zWE = true;
                        a.this.zWF = false;
                        a.this.zWG = false;
                        CharSequence fs = b.fs(a.this.zWm);
                        if (fs instanceof SpannableString) {
                            a aVar = a.this;
                            SpannableString spannableString = (SpannableString) fs;
                            aVar.zWK = new ArrayList();
                            i = 0;
                            while (i < spannableString.length()) {
                                nextSpanTransition = spannableString.nextSpanTransition(i, spannableString.length(), ImageSpan.class);
                                if (1 == ((ImageSpan[]) spannableString.getSpans(i, nextSpanTransition, ImageSpan.class)).length) {
                                    c cVar = new c();
                                    cVar.start = i;
                                    cVar.end = nextSpanTransition;
                                    aVar.zWK.add(cVar);
                                } else {
                                    ai.e("SelectableTextHelper", "other situation occur! length: %d.", Integer.valueOf(((ImageSpan[]) spannableString.getSpans(i, nextSpanTransition, ImageSpan.class)).length));
                                }
                                ai.d("SelectableTextHelper", "spans from %d to %d.", Integer.valueOf(i), Integer.valueOf(nextSpanTransition));
                                i = nextSpanTransition;
                            }
                            ai.d("SelectableTextHelper", aVar.zWK.toString(), new Object[0]);
                        }
                        a.this.dLL();
                        if (a.this.zWy <= 0 || a.this.zWy >= b.fs(a.this.zWm).length()) {
                            a.a(a.this, b.fs(a.this.zWm).length());
                            a.this.zWC = true;
                            a.this.zWD = false;
                            a.this.dLO();
                            a.this.zWn.eR(view);
                        } else {
                            a.a(a.this, a.this.zWy);
                            a.this.zWC = false;
                            a.this.zWD = false;
                            a.this.dLS();
                            a.this.dLO();
                        }
                    } else {
                        int hQ;
                        a.this.zWE = false;
                        a aVar2 = a.this;
                        i = a.this.zWr;
                        nextSpanTransition = a.this.zWs;
                        View view2 = aVar2.zWm;
                        if (view2 instanceof NeatTextView) {
                            com.tencent.neattextview.textview.layout.a layout = ((NeatTextView) view2).getLayout();
                            if (layout != null) {
                                hQ = layout.hQ(i, nextSpanTransition);
                            }
                            hQ = 0;
                        } else {
                            if (view2 instanceof TextView) {
                                Layout layout2 = ((TextView) view2).getLayout();
                                if (layout2 != null) {
                                    hQ = layout2.getOffsetForHorizontal(layout2.getLineForVertical(nextSpanTransition), (float) i);
                                    if (((int) layout2.getPrimaryHorizontal(hQ)) > i) {
                                        hQ = layout2.getOffsetToLeftOf(hQ);
                                    }
                                } else {
                                    hQ = -1;
                                }
                            }
                            hQ = 0;
                        }
                        aVar2.hG(hQ, hQ + 1);
                        a.this.dLL();
                        a.this.zWC = false;
                        a.this.zWD = false;
                        a.this.dLS();
                        a.this.dLO();
                    }
                    AppMethodBeat.o(138207);
                    return true;
                }
            });
            this.zWm.setOnTouchListener(this.jZu);
            this.zWm.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(138208);
                    ai.d("SelectableTextHelper", "onClick", new Object[0]);
                    if (a.this.lDG != null) {
                        a.this.lDG.onClick(view);
                    }
                    a.this.zWC = true;
                    a.this.zWD = true;
                    a.this.dLL();
                    a.this.dLM();
                    if (a.this.zWn != null) {
                        a.this.zWn.dismiss();
                    }
                    AppMethodBeat.o(138208);
                }
            });
            this.zWm.addOnAttachStateChangeListener(this.aaA);
            this.zWm.getViewTreeObserver().addOnPreDrawListener(this.yL);
            this.zWm.getViewTreeObserver().addOnScrollChangedListener(this.zWz);
            this.zWm.getViewTreeObserver().addOnGlobalLayoutListener(this.aeL);
            this.zWm.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    AppMethodBeat.i(138209);
                    a.this.zWm.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (a.this.zWn != null) {
                        a.this.zWm.getLocationInWindow(a.this.rGg);
                        ai.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", Integer.valueOf(a.this.rGg[0]), Integer.valueOf(a.this.rGg[1]));
                    }
                    AppMethodBeat.o(138209);
                }
            });
            AppMethodBeat.o(113144);
            return;
        }
        ai.d("SelectableTextHelper", "not destroy, isReInit: %s.", Boolean.valueOf(this.zWA));
        this.zWA = true;
        AppMethodBeat.o(113144);
    }

    public final void destroy() {
        AppMethodBeat.i(113145);
        this.zWA = false;
        this.aGx = true;
        this.zWB = false;
        this.zWm.removeCallbacks(this.zWH);
        this.zWm.getViewTreeObserver().removeOnScrollChangedListener(this.zWz);
        this.zWm.getViewTreeObserver().removeOnPreDrawListener(this.yL);
        this.zWm.getViewTreeObserver().removeOnGlobalLayoutListener(this.aeL);
        this.zWm.removeOnAttachStateChangeListener(this.aaA);
        this.zWC = true;
        this.zWD = true;
        dLL();
        dLM();
        this.zWi = null;
        this.zWj = null;
        if (this.zWn != null) {
            this.zWn.dismiss();
        }
        AppMethodBeat.o(113145);
    }

    public final void dLL() {
        AppMethodBeat.i(113146);
        dLP();
        dLQ();
        if (this.zWn != null) {
            this.zWn.dismiss();
        }
        AppMethodBeat.o(113146);
    }

    public final void dLM() {
        AppMethodBeat.i(113147);
        this.zWk.zWW = null;
        if (!(this.zWp == null || this.zWw == null)) {
            this.zWp.removeSpan(this.zWw);
            this.zWw = null;
        }
        AppMethodBeat.o(113147);
    }

    /* Access modifiers changed, original: final */
    public final void hG(int i, int i2) {
        AppMethodBeat.i(113148);
        dLM();
        if (b.fs(this.zWm) instanceof Spannable) {
            this.zWp = (Spannable) b.fs(this.zWm);
        }
        if (this.zWp == null || i >= b.fs(this.zWm).length()) {
            this.zWk.aqm = 0;
            this.zWk.Ls = 0;
            AppMethodBeat.o(113148);
            return;
        }
        hH(i, i2);
        AppMethodBeat.o(113148);
    }

    private void a(b bVar) {
        AppMethodBeat.i(113149);
        int i = bVar.zWO ? this.zWk.aqm : this.zWk.Ls;
        if (i < 0 || i > b.fs(this.zWm).length()) {
            AppMethodBeat.o(113149);
            return;
        }
        int aq;
        TextPaint ft = b.ft(this.zWm);
        if (ft != null) {
            aq = ((int) ft.getFontMetrics().descent) + b.aq(this.zWm, b.ar(this.zWm, i));
            i = (int) b.as(this.zWm, i);
        } else {
            i = 0;
            aq = 0;
        }
        a.this.zWm.getLocationInWindow(bVar.zWT);
        int i2 = bVar.zWO ? bVar.mWidth : 0;
        if (!bVar.zWO) {
            int[] hI = bVar.hI(i, aq);
            i = hI[0];
            aq = hI[1];
        }
        try {
            bVar.mPopupWindow.showAtLocation(a.this.zWm, 0, (i - i2) + bVar.dLW(), aq + bVar.dLX());
            AppMethodBeat.o(113149);
        } catch (Exception e) {
            ai.e("SelectableTextHelper", "error! message: %s.", e.getMessage());
            AppMethodBeat.o(113149);
        }
    }

    private boolean dLN() {
        AppMethodBeat.i(138213);
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            AppMethodBeat.o(138213);
            return true;
        }
        AppMethodBeat.o(138213);
        return false;
    }

    public final void dLO() {
        AppMethodBeat.i(113150);
        if (!dLN()) {
            a(this.zWi);
            a(this.zWj);
        }
        AppMethodBeat.o(113150);
    }

    public final void dLP() {
        AppMethodBeat.i(113151);
        if (this.zWi != null) {
            this.zWi.mPopupWindow.dismiss();
        }
        if (this.zWj != null) {
            this.zWj.mPopupWindow.dismiss();
        }
        AppMethodBeat.o(113151);
    }

    public final void dLQ() {
        AppMethodBeat.i(113152);
        if (this.zWq != null) {
            this.zWq.dBX();
        }
        AppMethodBeat.o(113152);
    }

    public final void dLR() {
        AppMethodBeat.i(113153);
        if (this.zWn != null) {
            this.zWn.eQ(this.zWm);
        }
        AppMethodBeat.o(113153);
    }

    public final void dLS() {
        int i = 16;
        AppMethodBeat.i(113154);
        if (this.zWq != null) {
            int[] iArr = new int[2];
            this.zWm.getLocationInWindow(iArr);
            int as = ((int) b.as(this.zWm, this.zWk.aqm)) + iArr[0];
            int at = (iArr[1] + b.at(this.zWm, b.ar(this.zWm, this.zWk.aqm))) - 16;
            if (as <= 0) {
                as = 16;
            }
            if (at >= 0) {
                i = at;
            }
            if (as > b.getScreenWidth(this.mContext)) {
                at = b.getScreenWidth(this.mContext) - 16;
            } else {
                at = as;
            }
            this.zWq.dn(at, i);
        }
        AppMethodBeat.o(113154);
    }

    public final void hH(int i, int i2) {
        AppMethodBeat.i(113155);
        if (i != -1) {
            this.zWk.aqm = aI(i, true);
        }
        if (i2 != -1) {
            this.zWk.Ls = aI(i2, false);
        }
        if (this.zWk.aqm < 0 || this.zWk.aqm > b.fs(this.zWm).length()) {
            AppMethodBeat.o(113155);
        } else if (this.zWk.Ls < 0 || this.zWk.Ls > b.fs(this.zWm).length()) {
            AppMethodBeat.o(113155);
        } else {
            if (this.zWk.aqm > this.zWk.Ls) {
                int i3 = this.zWk.aqm;
                this.zWk.aqm = this.zWk.Ls;
                this.zWk.Ls = i3;
            }
            if (this.zWp != null) {
                this.zWk.zWW = this.zWp.subSequence(this.zWk.aqm, this.zWk.Ls).toString();
                if (this.zWw != null) {
                    this.zWw.setPosition(this.zWk.aqm, this.zWk.Ls);
                } else {
                    this.zWw = new com.tencent.mm.ui.base.c(this.zWm, this.mContext.getResources().getColor(this.zWt), this.zWk.aqm, this.zWk.Ls);
                }
                this.zWp.setSpan(this.zWw, b.aw(this.zWm, b.ar(this.zWm, this.zWk.aqm)), this.zWk.Ls, 17);
                if (this.zWl != null) {
                    this.zWl.af(this.zWk.zWW);
                }
            }
            AppMethodBeat.o(113155);
        }
    }

    private int aI(int i, boolean z) {
        AppMethodBeat.i(113156);
        if (this.zWK != null) {
            Iterator it = this.zWK.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.vX(i)) {
                    if (z) {
                        i = cVar.start;
                        AppMethodBeat.o(113156);
                        return i;
                    }
                    i = cVar.end;
                    AppMethodBeat.o(113156);
                    return i;
                }
            }
        }
        AppMethodBeat.o(113156);
        return i;
    }
}
