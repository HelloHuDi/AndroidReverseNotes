package com.tencent.p177mm.p612ui.widget.textview;

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
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.base.C15529c;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.widget.textview.a */
public final class C46708a {
    private boolean aGx = true;
    private OnAttachStateChangeListener aaA;
    private OnGlobalLayoutListener aeL;
    OnTouchListener jZu;
    OnClickListener lDG;
    Context mContext;
    int[] rGg = new int[2];
    int[] yJQ = new int[2];
    /* renamed from: yL */
    private OnPreDrawListener f17926yL;
    boolean zWA = false;
    boolean zWB = false;
    public boolean zWC = true;
    public boolean zWD = true;
    boolean zWE = true;
    boolean zWF = false;
    boolean zWG = false;
    final Runnable zWH = new C160211();
    final Runnable zWI = new C308285();
    public C16022e zWJ;
    ArrayList<C36365c> zWK;
    C46707b zWi;
    private C46707b zWj;
    C5674g zWk = new C5674g();
    public C40916d zWl;
    View zWm;
    public C5673f zWn;
    OnTouchListener zWo;
    private Spannable zWp;
    private C24088a zWq;
    int zWr;
    int zWs;
    private int zWt;
    int zWu;
    int zWv;
    private C15529c zWw;
    int zWx;
    public int zWy;
    private OnScrollChangedListener zWz;

    /* renamed from: com.tencent.mm.ui.widget.textview.a$f */
    public static abstract class C5673f {
        /* renamed from: eQ */
        public void mo11041eQ(View view) {
        }

        public void dismiss() {
        }

        /* renamed from: eR */
        public void mo11042eR(View view) {
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$g */
    class C5674g {
        /* renamed from: Ls */
        int f1339Ls;
        int aqm;
        String zWW;

        C5674g() {
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$10 */
    class C1602010 implements OnTouchListener {
        C1602010() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(113127);
            if (C46708a.this.zWo != null) {
                C46708a.this.zWo.onTouch(view, motionEvent);
            }
            C46708a.this.zWr = (int) motionEvent.getX();
            C46708a.this.zWs = (int) motionEvent.getY();
            AppMethodBeat.m2505o(113127);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$1 */
    class C160211 implements Runnable {
        C160211() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113118);
            if (C46708a.this.zWA) {
                C5227ai.m7971d("SelectableTextHelper", "isReInit, return.", new Object[0]);
                AppMethodBeat.m2505o(113118);
                return;
            }
            C5227ai.m7971d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", Boolean.valueOf(C46708a.this.zWE), Boolean.valueOf(C46708a.this.zWF));
            if (C46708a.this.zWn == null) {
                if (!C46708a.this.zWC) {
                    C46708a.this.dLS();
                }
                if (!C46708a.this.zWD) {
                    C46708a.this.dLO();
                }
            } else if (!C46708a.this.zWE) {
                C46708a.this.zWE = true;
                if (C46708a.this.zWF) {
                    C5227ai.m7971d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", Boolean.valueOf(C46708a.this.zWC), Boolean.valueOf(C46708a.this.zWD));
                    if (!C46708a.this.zWC) {
                        C46708a.this.dLS();
                    }
                    if (!C46708a.this.zWD) {
                        C46708a.this.dLO();
                        C46708a.this.mo75075hH(C46708a.this.zWk.aqm, C46708a.this.zWk.f1339Ls);
                    }
                    if (!(C46708a.this.zWn == null || !C46708a.this.zWC || C46708a.this.zWD)) {
                        C46708a.this.zWn.mo11041eQ(C46708a.this.zWm);
                    }
                }
                C46708a.this.zWF = false;
                AppMethodBeat.m2505o(113118);
                return;
            } else if (C46708a.this.zWG) {
                C46708a.this.zWG = false;
                C5227ai.m7971d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
                if (C46708a.this.zWJ != null) {
                    C46708a.this.zWJ.dHp();
                    AppMethodBeat.m2505o(113118);
                    return;
                }
            } else {
                C5227ai.m7971d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
                AppMethodBeat.m2505o(113118);
                return;
            }
            AppMethodBeat.m2505o(113118);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$e */
    public interface C16022e {
        void dHp();
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$11 */
    class C3082311 implements OnTouchListener {
        C3082311() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(138210);
            C5227ai.m7971d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= C46708a.this.zWi.getWidth() || y < 0 || y >= C46708a.this.zWi.getHeight())) {
                C5227ai.m7971d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
                C46708a.this.zWm.postDelayed(C46708a.this.zWI, 100);
                AppMethodBeat.m2505o(138210);
                return true;
            } else if (motionEvent.getAction() == 4) {
                C5227ai.m7971d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
                C46708a.this.zWm.postDelayed(C46708a.this.zWI, 100);
                AppMethodBeat.m2505o(138210);
                return true;
            } else {
                AppMethodBeat.m2505o(138210);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$12 */
    class C3082412 implements OnDismissListener {
        C3082412() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(138211);
            C46708a.this.zWm.setOnTouchListener(C46708a.this.jZu);
            AppMethodBeat.m2505o(138211);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$2 */
    class C308252 implements OnLongClickListener {
        C308252() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(138207);
            C5227ai.m7971d("SelectableTextHelper", "onLongClick", new Object[0]);
            C46708a.this.zWA = false;
            int i;
            int nextSpanTransition;
            if (C46708a.this.zWn != null) {
                C46708a.this.zWE = true;
                C46708a.this.zWF = false;
                C46708a.this.zWG = false;
                CharSequence fs = C40917b.m70929fs(C46708a.this.zWm);
                if (fs instanceof SpannableString) {
                    C46708a c46708a = C46708a.this;
                    SpannableString spannableString = (SpannableString) fs;
                    c46708a.zWK = new ArrayList();
                    i = 0;
                    while (i < spannableString.length()) {
                        nextSpanTransition = spannableString.nextSpanTransition(i, spannableString.length(), ImageSpan.class);
                        if (1 == ((ImageSpan[]) spannableString.getSpans(i, nextSpanTransition, ImageSpan.class)).length) {
                            C36365c c36365c = new C36365c();
                            c36365c.start = i;
                            c36365c.end = nextSpanTransition;
                            c46708a.zWK.add(c36365c);
                        } else {
                            C5227ai.m7972e("SelectableTextHelper", "other situation occur! length: %d.", Integer.valueOf(((ImageSpan[]) spannableString.getSpans(i, nextSpanTransition, ImageSpan.class)).length));
                        }
                        C5227ai.m7971d("SelectableTextHelper", "spans from %d to %d.", Integer.valueOf(i), Integer.valueOf(nextSpanTransition));
                        i = nextSpanTransition;
                    }
                    C5227ai.m7971d("SelectableTextHelper", c46708a.zWK.toString(), new Object[0]);
                }
                C46708a.this.dLL();
                if (C46708a.this.zWy <= 0 || C46708a.this.zWy >= C40917b.m70929fs(C46708a.this.zWm).length()) {
                    C46708a.m88496a(C46708a.this, C40917b.m70929fs(C46708a.this.zWm).length());
                    C46708a.this.zWC = true;
                    C46708a.this.zWD = false;
                    C46708a.this.dLO();
                    C46708a.this.zWn.mo11042eR(view);
                } else {
                    C46708a.m88496a(C46708a.this, C46708a.this.zWy);
                    C46708a.this.zWC = false;
                    C46708a.this.zWD = false;
                    C46708a.this.dLS();
                    C46708a.this.dLO();
                }
            } else {
                int hQ;
                C46708a.this.zWE = false;
                C46708a c46708a2 = C46708a.this;
                i = C46708a.this.zWr;
                nextSpanTransition = C46708a.this.zWs;
                View view2 = c46708a2.zWm;
                if (view2 instanceof NeatTextView) {
                    C5782a layout = ((NeatTextView) view2).getLayout();
                    if (layout != null) {
                        hQ = layout.mo11847hQ(i, nextSpanTransition);
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
                c46708a2.mo75074hG(hQ, hQ + 1);
                C46708a.this.dLL();
                C46708a.this.zWC = false;
                C46708a.this.zWD = false;
                C46708a.this.dLS();
                C46708a.this.dLO();
            }
            AppMethodBeat.m2505o(138207);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$3 */
    class C308263 implements OnClickListener {
        C308263() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138208);
            C5227ai.m7971d("SelectableTextHelper", "onClick", new Object[0]);
            if (C46708a.this.lDG != null) {
                C46708a.this.lDG.onClick(view);
            }
            C46708a.this.zWC = true;
            C46708a.this.zWD = true;
            C46708a.this.dLL();
            C46708a.this.dLM();
            if (C46708a.this.zWn != null) {
                C46708a.this.zWn.dismiss();
            }
            AppMethodBeat.m2505o(138208);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$4 */
    class C308274 implements OnGlobalLayoutListener {
        C308274() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(138209);
            C46708a.this.zWm.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (C46708a.this.zWn != null) {
                C46708a.this.zWm.getLocationInWindow(C46708a.this.rGg);
                C5227ai.m7971d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", Integer.valueOf(C46708a.this.rGg[0]), Integer.valueOf(C46708a.this.rGg[1]));
            }
            AppMethodBeat.m2505o(138209);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$5 */
    class C308285 implements Runnable {
        C308285() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113121);
            C5227ai.m7971d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
            if (C46708a.this.zWJ != null) {
                C46708a.this.zWJ.dHp();
            }
            AppMethodBeat.m2505o(113121);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$c */
    class C36365c {
        int end;
        int start;

        C36365c() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: vX */
        public final boolean mo57281vX(int i) {
            return i >= this.start && i < this.end;
        }

        public final String toString() {
            AppMethodBeat.m2504i(113142);
            String str = "start: " + this.start + " end: " + this.end;
            AppMethodBeat.m2505o(113142);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$6 */
    class C409136 implements OnAttachStateChangeListener {
        C409136() {
        }

        public final void onViewAttachedToWindow(View view) {
            AppMethodBeat.m2504i(113122);
            C5227ai.m7971d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
            AppMethodBeat.m2505o(113122);
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.m2504i(113123);
            C5227ai.m7971d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
            C46708a.this.destroy();
            AppMethodBeat.m2505o(113123);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$8 */
    class C409148 implements OnScrollChangedListener {
        C409148() {
        }

        public final void onScrollChanged() {
            AppMethodBeat.m2504i(113125);
            if (C46708a.this.zWn != null) {
                C46708a.this.zWm.removeCallbacks(C46708a.this.zWI);
                C46708a.this.zWm.getLocationInWindow(C46708a.this.yJQ);
                C5227ai.m7971d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", Integer.valueOf(C46708a.this.rGg[1]), Integer.valueOf(C46708a.this.yJQ[1]));
                if (C46708a.this.zWE) {
                    if (C46708a.this.zWF || C46708a.this.zWG) {
                        if (C46708a.this.zWG) {
                            C46708a.this.zWG = false;
                            C46708a.this.zWE = false;
                            if (C46708a.this.rGg[1] != C46708a.this.yJQ[1]) {
                                C46708a.this.zWF = true;
                                C5227ai.m7971d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
                            } else {
                                C46708a.this.zWF = false;
                                C5227ai.m7971d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
                            }
                        }
                    } else if (C46708a.this.rGg[1] != C46708a.this.yJQ[1]) {
                        C46708a.this.zWF = true;
                        C46708a.this.zWE = false;
                        C5227ai.m7971d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
                    } else {
                        C46708a.this.zWG = true;
                        C5227ai.m7971d("SelectableTextHelper", "need delay judge.", new Object[0]);
                    }
                }
                C46708a.this.rGg[1] = C46708a.this.yJQ[1];
            }
            if (!(C46708a.this.zWB || (C46708a.this.zWC && C46708a.this.zWD))) {
                C46708a.this.zWB = true;
                C46708a.this.dLL();
            }
            AppMethodBeat.m2505o(113125);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$a */
    public static class C40915a {
        OnClickListener lDG;
        C24088a zWM;
        public int zWN;
        View zWm;
        C5673f zWn;
        OnTouchListener zWo;
        public int zWt;
        public int zWu;

        public C40915a(View view, C24088a c24088a) {
            this.zWu = C25738R.color.f11905l7;
            this.zWt = C25738R.color.f12291z1;
            this.zWN = 0;
            this.zWm = view;
            this.zWM = c24088a;
        }

        public C40915a(View view, C24088a c24088a, C5673f c5673f, OnClickListener onClickListener, OnTouchListener onTouchListener) {
            this(view, c24088a);
            this.zWn = c5673f;
            this.lDG = onClickListener;
            this.zWo = onTouchListener;
        }

        public final C46708a dLT() {
            AppMethodBeat.m2504i(113130);
            C46708a c46708a = new C46708a(this);
            AppMethodBeat.m2505o(113130);
            return c46708a;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$d */
    public interface C40916d {
        /* renamed from: af */
        void mo27955af(CharSequence charSequence);
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$7 */
    class C467057 implements OnPreDrawListener {
        C467057() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(113124);
            if (C46708a.this.zWB) {
                C46708a.this.zWB = false;
                C46708a c46708a = C46708a.this;
                c46708a.zWm.removeCallbacks(c46708a.zWH);
                c46708a.zWm.postDelayed(c46708a.zWH, 100);
            }
            AppMethodBeat.m2505o(113124);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$9 */
    class C467069 implements OnGlobalLayoutListener {
        C467069() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(113126);
            C5227ai.m7971d("SelectableTextHelper", "onGlobalLayout", new Object[0]);
            if (C46708a.this.zWn != null) {
                C46708a.this.dLM();
                C46708a.this.zWC = true;
                C46708a.this.zWD = true;
                C46708a.this.dLL();
            }
            AppMethodBeat.m2505o(113126);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.textview.a$b */
    class C46707b extends View {
        private int eno = 25;
        private int mHeight = (this.uQR * 2);
        private Paint mPaint;
        PopupWindow mPopupWindow;
        int mWidth = (this.uQR * 2);
        private Rect rect = new Rect();
        private int uQR = (C46708a.this.zWv / 2);
        private int[] yJQ = new int[2];
        boolean zWO;
        private int zWP;
        private int zWQ;
        private int zWR;
        private int zWS;
        int[] zWT = new int[2];
        private Point zWU = new Point();
        private boolean zWV = false;

        C46707b(boolean z) {
            super(C46708a.this.mContext);
            AppMethodBeat.m2504i(113131);
            this.zWO = z;
            this.mPaint = new Paint(1);
            this.mPaint.setColor(C46708a.this.mContext.getResources().getColor(C46708a.this.zWu));
            this.mPopupWindow = new PopupWindow(this);
            this.mPopupWindow.setClippingEnabled(false);
            this.mPopupWindow.setWidth(this.mWidth + (this.eno * 2));
            this.mPopupWindow.setHeight(this.mHeight + (this.eno / 2));
            invalidate();
            AppMethodBeat.m2505o(113131);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDraw(Canvas canvas) {
            AppMethodBeat.m2504i(113132);
            if (C46708a.this.zWn != null) {
                int aq;
                int i = this.zWO ? C46708a.this.zWk.aqm : C46708a.this.zWk.f1339Ls;
                TextPaint ft = C40917b.m70930ft(C46708a.this.zWm);
                if (ft != null) {
                    aq = ((int) ft.getFontMetrics().descent) + C40917b.m70919aq(C46708a.this.zWm, C40917b.m70920ar(C46708a.this.zWm, i));
                    i = (int) C40917b.m70921as(C46708a.this.zWm, i);
                } else {
                    i = 0;
                    aq = 0;
                }
                C46708a.this.zWm.getLocationInWindow(this.zWT);
                if (!this.zWO) {
                    aq = mo75061hI(i, aq)[1];
                }
                i = dLX() + aq;
                if (!C46708a.this.zWm.getGlobalVisibleRect(this.rect, this.zWU)) {
                    C5227ai.m7971d("SelectableTextHelper", "view invisible.", new Object[0]);
                    AppMethodBeat.m2505o(113132);
                    return;
                } else if (i >= this.rect.bottom) {
                    if (this.zWO) {
                        C5227ai.m7971d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
                        C46708a.this.dLM();
                        C46708a.this.zWC = true;
                        C46708a.this.zWD = true;
                        C46708a.this.dLL();
                        C46708a.this.zWn.dismiss();
                    }
                    C5227ai.m7971d("SelectableTextHelper", "cursor invisible.", new Object[0]);
                    AppMethodBeat.m2505o(113132);
                    return;
                } else if (i <= this.rect.top) {
                    if (!this.zWO) {
                        C5227ai.m7971d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
                        C46708a.this.dLM();
                        C46708a.this.zWC = true;
                        C46708a.this.zWD = true;
                        C46708a.this.dLL();
                        C46708a.this.zWn.dismiss();
                    }
                    C5227ai.m7971d("SelectableTextHelper", "cursor invisible.", new Object[0]);
                    AppMethodBeat.m2505o(113132);
                    return;
                }
            }
            canvas.drawCircle((float) (this.uQR + this.eno), (float) this.uQR, (float) this.uQR, this.mPaint);
            if (this.zWO) {
                canvas.drawRect((float) (this.uQR + this.eno), 0.0f, (float) ((this.uQR * 2) + this.eno), (float) this.uQR, this.mPaint);
                AppMethodBeat.m2505o(113132);
                return;
            }
            canvas.drawRect((float) this.eno, 0.0f, (float) (this.uQR + this.eno), (float) this.uQR, this.mPaint);
            AppMethodBeat.m2505o(113132);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(113133);
            switch (motionEvent.getAction()) {
                case 0:
                    this.zWR = C46708a.this.zWk.aqm;
                    this.zWS = C46708a.this.zWk.f1339Ls;
                    this.zWP = (int) motionEvent.getX();
                    this.zWQ = (int) motionEvent.getY();
                    this.zWV = false;
                    C46708a.this.zWm.getLocationInWindow(this.yJQ);
                    break;
                case 1:
                case 3:
                    if (C46708a.this.zWn == null || this.zWV) {
                        if (!C46708a.this.zWC) {
                            C46708a.this.dLS();
                            break;
                        }
                    }
                    this.zWV = true;
                    if (C46708a.this.zWk.f1339Ls - C46708a.this.zWk.aqm != C40917b.m70929fs(C46708a.this.zWm).length()) {
                        C46708a.this.zWn.dismiss();
                        C46708a.this.zWC = false;
                        C46708a.this.dLS();
                        break;
                    }
                    C46708a.this.zWn.mo11041eQ(C46708a.this.zWm);
                    C46708a.this.zWC = true;
                    C46708a.this.dLQ();
                    break;
                    break;
                case 2:
                    if (C46708a.this.zWn != null) {
                        C46708a.this.zWn.dismiss();
                    }
                    C46708a.this.dLQ();
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    if (C46708a.this.zWn != null) {
                        update((rawX - this.yJQ[0]) + this.uQR, ((rawY + this.zWQ) - this.mHeight) - C46708a.this.zWx);
                        break;
                    }
                    update(rawX - this.yJQ[0], ((rawY + this.zWQ) - this.mHeight) - C46708a.this.zWx);
                    break;
            }
            AppMethodBeat.m2505o(113133);
            return true;
        }

        private void dLU() {
            AppMethodBeat.m2504i(113134);
            this.zWO = !this.zWO;
            invalidate();
            AppMethodBeat.m2505o(113134);
        }

        private void update(int i, int i2) {
            int i3;
            AppMethodBeat.m2504i(113135);
            C46708a.this.zWm.getLocationInWindow(this.zWT);
            if (this.zWO) {
                i3 = C46708a.this.zWk.aqm;
            } else {
                i3 = C46708a.this.zWk.f1339Ls;
            }
            int d = C40917b.m70928d(C46708a.this.zWm, i, i2 - this.zWT[1], i3);
            if (d != i3) {
                C46708a.this.dLM();
                C46707b a;
                if (this.zWO) {
                    if (d > this.zWS) {
                        a = C46708a.m88494a(C46708a.this, false);
                        dLU();
                        a.dLU();
                        this.zWR = this.zWS;
                        C46708a.this.mo75075hH(this.zWS, d);
                        a.dLV();
                    } else {
                        C46708a.this.mo75075hH(d, -1);
                    }
                    dLV();
                    AppMethodBeat.m2505o(113135);
                    return;
                }
                if (d < this.zWR) {
                    a = C46708a.m88494a(C46708a.this, true);
                    a.dLU();
                    dLU();
                    this.zWS = this.zWR;
                    C46708a.this.mo75075hH(d, this.zWR);
                    a.dLV();
                } else {
                    C46708a.this.mo75075hH(this.zWR, d);
                }
                dLV();
            }
            AppMethodBeat.m2505o(113135);
        }

        private void dLV() {
            AppMethodBeat.m2504i(113136);
            C46708a.this.zWm.getLocationInWindow(this.zWT);
            TextPaint ft = C40917b.m70930ft(C46708a.this.zWm);
            if (ft != null) {
                int i = (int) ft.getFontMetrics().descent;
                if (this.zWO) {
                    this.mPopupWindow.update((((int) C40917b.m70921as(C46708a.this.zWm, C46708a.this.zWk.aqm)) - this.mWidth) + dLW(), (i + C40917b.m70919aq(C46708a.this.zWm, C40917b.m70920ar(C46708a.this.zWm, C46708a.this.zWk.aqm))) + dLX(), -1, -1);
                    AppMethodBeat.m2505o(113136);
                    return;
                }
                int[] hI = mo75061hI((int) C40917b.m70921as(C46708a.this.zWm, C46708a.this.zWk.f1339Ls), i + C40917b.m70919aq(C46708a.this.zWm, C40917b.m70920ar(C46708a.this.zWm, C46708a.this.zWk.f1339Ls)));
                this.mPopupWindow.update(hI[0] + dLW(), hI[1] + dLX(), -1, -1);
            }
            AppMethodBeat.m2505o(113136);
        }

        public final int dLW() {
            AppMethodBeat.m2504i(113137);
            int paddingLeft = (this.zWT[0] - this.eno) + C46708a.this.zWm.getPaddingLeft();
            AppMethodBeat.m2505o(113137);
            return paddingLeft;
        }

        public final int dLX() {
            AppMethodBeat.m2504i(113138);
            int paddingTop = this.zWT[1] + C46708a.this.zWm.getPaddingTop();
            AppMethodBeat.m2505o(113138);
            return paddingTop;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: hI */
        public final int[] mo75061hI(int i, int i2) {
            AppMethodBeat.m2504i(113139);
            int[] iArr = new int[2];
            if (i == 0 && C46708a.this.zWk.f1339Ls > 1) {
                C46708a.this.zWm.getLocationInWindow(this.zWT);
                TextPaint ft = C40917b.m70930ft(C46708a.this.zWm);
                if (ft != null) {
                    int i3 = (int) ft.getFontMetrics().descent;
                    i = (int) C40917b.m70924av(C46708a.this.zWm, C40917b.m70920ar(C46708a.this.zWm, C46708a.this.zWk.f1339Ls - 1));
                    i2 = C40917b.m70919aq(C46708a.this.zWm, C40917b.m70920ar(C46708a.this.zWm, C46708a.this.zWk.f1339Ls - 1)) + i3;
                }
            }
            iArr[0] = i;
            iArr[1] = i2;
            AppMethodBeat.m2505o(113139);
            return iArr;
        }

        public final void dLY() {
            AppMethodBeat.m2504i(113140);
            this.mPopupWindow.setOutsideTouchable(true);
            AppMethodBeat.m2505o(113140);
        }

        public final void setTouchInterceptor(OnTouchListener onTouchListener) {
            AppMethodBeat.m2504i(113141);
            this.mPopupWindow.setTouchInterceptor(onTouchListener);
            AppMethodBeat.m2505o(113141);
        }

        public final void setOnDismissListener(OnDismissListener onDismissListener) {
            AppMethodBeat.m2504i(138212);
            this.mPopupWindow.setOnDismissListener(onDismissListener);
            AppMethodBeat.m2505o(138212);
        }
    }

    public C46708a(C40915a c40915a) {
        AppMethodBeat.m2504i(113143);
        this.zWm = c40915a.zWm;
        this.zWn = c40915a.zWn;
        this.lDG = c40915a.lDG;
        this.zWo = c40915a.zWo;
        this.zWq = c40915a.zWM;
        this.mContext = this.zWm.getContext();
        this.zWt = c40915a.zWt;
        this.zWu = c40915a.zWu;
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
            this.zWv = C5229aj.fromDPToPix(this.mContext, c40915a.zWN);
        }
        this.aaA = new C409136();
        this.f17926yL = new C467057();
        this.zWz = new C409148();
        this.aeL = new C467069();
        this.jZu = new C1602010();
        init();
        AppMethodBeat.m2505o(113143);
    }

    public final void init() {
        AppMethodBeat.m2504i(113144);
        if (this.aGx) {
            C5227ai.m7971d("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
            this.zWA = false;
            this.aGx = false;
            this.zWB = false;
            if (this.zWn == null) {
                C40917b.m70917a(this.zWm, C40917b.m70929fs(this.zWm), BufferType.SPANNABLE);
            }
            this.zWi = new C46707b(true);
            if (this.zWn != null) {
                this.zWi.dLY();
                this.zWi.setTouchInterceptor(new C3082311());
                this.zWi.setOnDismissListener(new C3082412());
            }
            this.zWj = new C46707b(false);
            this.zWm.setOnLongClickListener(new C308252());
            this.zWm.setOnTouchListener(this.jZu);
            this.zWm.setOnClickListener(new C308263());
            this.zWm.addOnAttachStateChangeListener(this.aaA);
            this.zWm.getViewTreeObserver().addOnPreDrawListener(this.f17926yL);
            this.zWm.getViewTreeObserver().addOnScrollChangedListener(this.zWz);
            this.zWm.getViewTreeObserver().addOnGlobalLayoutListener(this.aeL);
            this.zWm.getViewTreeObserver().addOnGlobalLayoutListener(new C308274());
            AppMethodBeat.m2505o(113144);
            return;
        }
        C5227ai.m7971d("SelectableTextHelper", "not destroy, isReInit: %s.", Boolean.valueOf(this.zWA));
        this.zWA = true;
        AppMethodBeat.m2505o(113144);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(113145);
        this.zWA = false;
        this.aGx = true;
        this.zWB = false;
        this.zWm.removeCallbacks(this.zWH);
        this.zWm.getViewTreeObserver().removeOnScrollChangedListener(this.zWz);
        this.zWm.getViewTreeObserver().removeOnPreDrawListener(this.f17926yL);
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
        AppMethodBeat.m2505o(113145);
    }

    public final void dLL() {
        AppMethodBeat.m2504i(113146);
        dLP();
        dLQ();
        if (this.zWn != null) {
            this.zWn.dismiss();
        }
        AppMethodBeat.m2505o(113146);
    }

    public final void dLM() {
        AppMethodBeat.m2504i(113147);
        this.zWk.zWW = null;
        if (!(this.zWp == null || this.zWw == null)) {
            this.zWp.removeSpan(this.zWw);
            this.zWw = null;
        }
        AppMethodBeat.m2505o(113147);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hG */
    public final void mo75074hG(int i, int i2) {
        AppMethodBeat.m2504i(113148);
        dLM();
        if (C40917b.m70929fs(this.zWm) instanceof Spannable) {
            this.zWp = (Spannable) C40917b.m70929fs(this.zWm);
        }
        if (this.zWp == null || i >= C40917b.m70929fs(this.zWm).length()) {
            this.zWk.aqm = 0;
            this.zWk.f1339Ls = 0;
            AppMethodBeat.m2505o(113148);
            return;
        }
        mo75075hH(i, i2);
        AppMethodBeat.m2505o(113148);
    }

    /* renamed from: a */
    private void m88495a(C46707b c46707b) {
        AppMethodBeat.m2504i(113149);
        int i = c46707b.zWO ? this.zWk.aqm : this.zWk.f1339Ls;
        if (i < 0 || i > C40917b.m70929fs(this.zWm).length()) {
            AppMethodBeat.m2505o(113149);
            return;
        }
        int aq;
        TextPaint ft = C40917b.m70930ft(this.zWm);
        if (ft != null) {
            aq = ((int) ft.getFontMetrics().descent) + C40917b.m70919aq(this.zWm, C40917b.m70920ar(this.zWm, i));
            i = (int) C40917b.m70921as(this.zWm, i);
        } else {
            i = 0;
            aq = 0;
        }
        C46708a.this.zWm.getLocationInWindow(c46707b.zWT);
        int i2 = c46707b.zWO ? c46707b.mWidth : 0;
        if (!c46707b.zWO) {
            int[] hI = c46707b.mo75061hI(i, aq);
            i = hI[0];
            aq = hI[1];
        }
        try {
            c46707b.mPopupWindow.showAtLocation(C46708a.this.zWm, 0, (i - i2) + c46707b.dLW(), aq + c46707b.dLX());
            AppMethodBeat.m2505o(113149);
        } catch (Exception e) {
            C5227ai.m7972e("SelectableTextHelper", "error! message: %s.", e.getMessage());
            AppMethodBeat.m2505o(113149);
        }
    }

    private boolean dLN() {
        AppMethodBeat.m2504i(138213);
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            AppMethodBeat.m2505o(138213);
            return true;
        }
        AppMethodBeat.m2505o(138213);
        return false;
    }

    public final void dLO() {
        AppMethodBeat.m2504i(113150);
        if (!dLN()) {
            m88495a(this.zWi);
            m88495a(this.zWj);
        }
        AppMethodBeat.m2505o(113150);
    }

    public final void dLP() {
        AppMethodBeat.m2504i(113151);
        if (this.zWi != null) {
            this.zWi.mPopupWindow.dismiss();
        }
        if (this.zWj != null) {
            this.zWj.mPopupWindow.dismiss();
        }
        AppMethodBeat.m2505o(113151);
    }

    public final void dLQ() {
        AppMethodBeat.m2504i(113152);
        if (this.zWq != null) {
            this.zWq.dBX();
        }
        AppMethodBeat.m2505o(113152);
    }

    public final void dLR() {
        AppMethodBeat.m2504i(113153);
        if (this.zWn != null) {
            this.zWn.mo11041eQ(this.zWm);
        }
        AppMethodBeat.m2505o(113153);
    }

    public final void dLS() {
        int i = 16;
        AppMethodBeat.m2504i(113154);
        if (this.zWq != null) {
            int[] iArr = new int[2];
            this.zWm.getLocationInWindow(iArr);
            int as = ((int) C40917b.m70921as(this.zWm, this.zWk.aqm)) + iArr[0];
            int at = (iArr[1] + C40917b.m70922at(this.zWm, C40917b.m70920ar(this.zWm, this.zWk.aqm))) - 16;
            if (as <= 0) {
                as = 16;
            }
            if (at >= 0) {
                i = at;
            }
            if (as > C40917b.getScreenWidth(this.mContext)) {
                at = C40917b.getScreenWidth(this.mContext) - 16;
            } else {
                at = as;
            }
            this.zWq.mo22431dn(at, i);
        }
        AppMethodBeat.m2505o(113154);
    }

    /* renamed from: hH */
    public final void mo75075hH(int i, int i2) {
        AppMethodBeat.m2504i(113155);
        if (i != -1) {
            this.zWk.aqm = m88497aI(i, true);
        }
        if (i2 != -1) {
            this.zWk.f1339Ls = m88497aI(i2, false);
        }
        if (this.zWk.aqm < 0 || this.zWk.aqm > C40917b.m70929fs(this.zWm).length()) {
            AppMethodBeat.m2505o(113155);
        } else if (this.zWk.f1339Ls < 0 || this.zWk.f1339Ls > C40917b.m70929fs(this.zWm).length()) {
            AppMethodBeat.m2505o(113155);
        } else {
            if (this.zWk.aqm > this.zWk.f1339Ls) {
                int i3 = this.zWk.aqm;
                this.zWk.aqm = this.zWk.f1339Ls;
                this.zWk.f1339Ls = i3;
            }
            if (this.zWp != null) {
                this.zWk.zWW = this.zWp.subSequence(this.zWk.aqm, this.zWk.f1339Ls).toString();
                if (this.zWw != null) {
                    this.zWw.setPosition(this.zWk.aqm, this.zWk.f1339Ls);
                } else {
                    this.zWw = new C15529c(this.zWm, this.mContext.getResources().getColor(this.zWt), this.zWk.aqm, this.zWk.f1339Ls);
                }
                this.zWp.setSpan(this.zWw, C40917b.m70925aw(this.zWm, C40917b.m70920ar(this.zWm, this.zWk.aqm)), this.zWk.f1339Ls, 17);
                if (this.zWl != null) {
                    this.zWl.mo27955af(this.zWk.zWW);
                }
            }
            AppMethodBeat.m2505o(113155);
        }
    }

    /* renamed from: aI */
    private int m88497aI(int i, boolean z) {
        AppMethodBeat.m2504i(113156);
        if (this.zWK != null) {
            Iterator it = this.zWK.iterator();
            while (it.hasNext()) {
                C36365c c36365c = (C36365c) it.next();
                if (c36365c.mo57281vX(i)) {
                    if (z) {
                        i = c36365c.start;
                        AppMethodBeat.m2505o(113156);
                        return i;
                    }
                    i = c36365c.end;
                    AppMethodBeat.m2505o(113156);
                    return i;
                }
            }
        }
        AppMethodBeat.m2505o(113156);
        return i;
    }
}
