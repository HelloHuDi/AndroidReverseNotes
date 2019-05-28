package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView extends FrameLayout {
    public static DisplayMetrics ghw;
    private float eX;
    private float eY;
    View gCO;
    GestureDetector lCs = new GestureDetector(new OnGestureListener() {
        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(42239);
            ab.d("ShuffleView", "gesture down");
            switch (ShuffleView.this.nVQ.nWq) {
                case 4:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int i = 0;
                    while (i < ShuffleView.this.nWc) {
                        Rect a = ShuffleView.a(ShuffleView.this, i);
                        if (a == null || !a.contains(x, y)) {
                            i++;
                        } else {
                            View view = (View) ShuffleView.this.nVP.get(i);
                            if (ShuffleView.this.gCO != view && ShuffleView.this.gCO != null) {
                                ShuffleView.m(ShuffleView.this);
                            } else if (ShuffleView.this.gCO == view) {
                                ab.i("ShuffleView", "down on the select card");
                                AppMethodBeat.o(42239);
                                return true;
                            }
                            ShuffleView.b(ShuffleView.this, i);
                            AppMethodBeat.o(42239);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(42239);
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(42240);
            switch (ShuffleView.this.nVQ.nWq) {
                case 4:
                    if (ShuffleView.this.gCO != null) {
                        ab.d("ShuffleView", "click the select card");
                        if (ShuffleView.this.nVW != null) {
                            ShuffleView.this.nVW.es(ShuffleView.this.nVZ, ShuffleView.this.nWc);
                        }
                        ShuffleView.m(ShuffleView.this);
                    }
                    if (ShuffleView.this.nWa != null) {
                        if (ShuffleView.this.nVW != null) {
                            b n = ShuffleView.this.nVW;
                            ShuffleView.this.nWb;
                            n.xL(ShuffleView.this.nWc);
                        }
                        ShuffleView.c(ShuffleView.this, ShuffleView.this.nWb);
                    }
                    AppMethodBeat.o(42240);
                    return true;
                default:
                    AppMethodBeat.o(42240);
                    return false;
            }
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(42241);
            if (motionEvent2.getActionMasked() == 2) {
                int x = (int) motionEvent2.getX();
                int y = (int) motionEvent2.getY();
                switch (ShuffleView.this.nVQ.nWq) {
                    case 4:
                        View view;
                        if (Math.abs(f2) < ((float) ShuffleView.this.nWj)) {
                            for (int i = 0; i < ShuffleView.this.nWc; i++) {
                                Rect a = ShuffleView.a(ShuffleView.this, i);
                                if (a != null && a.contains(x, y)) {
                                    view = (View) ShuffleView.this.nVP.get(i);
                                    if (ShuffleView.this.gCO != view && ShuffleView.this.gCO != null) {
                                        ShuffleView.m(ShuffleView.this);
                                    } else if (ShuffleView.this.gCO == view) {
                                        ab.i("ShuffleView", "scroll on the select card");
                                    }
                                    if (ShuffleView.this.nWa != view) {
                                        ShuffleView.p(ShuffleView.this);
                                        ShuffleView.b(ShuffleView.this, i);
                                    }
                                }
                            }
                        }
                        if (Math.abs(f) < ((float) ShuffleView.this.nWj)) {
                            ab.d("ShuffleView", "scroll distanceY:".concat(String.valueOf(f2)));
                            if (ShuffleView.this.nWa != null) {
                                view = ShuffleView.this.nWa;
                            } else if (ShuffleView.this.gCO != null) {
                                view = ShuffleView.this.gCO;
                            } else {
                                view = null;
                            }
                            if (view != null) {
                                ab.i("ShuffleView", "scroll translationY:" + view.getTranslationY() + "," + (view.getHeight() / 7));
                                if (((int) view.getTranslationY()) <= (-view.getHeight()) / 7) {
                                    if (f2 < 0.0f && Math.abs(f2) > ((float) ShuffleView.this.nWj)) {
                                        if (((int) f2) <= (-view.getHeight()) / 7) {
                                            view.setTranslationY(0.0f);
                                        } else {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                        }
                                        if (view == ShuffleView.this.gCO) {
                                            ShuffleView.this.nWa = ShuffleView.this.gCO;
                                            ShuffleView.this.nWb = ShuffleView.this.nVZ;
                                            if (ShuffleView.this.nVT.isStarted()) {
                                                ab.i("ShuffleView", "scroll when select view is animation");
                                                ShuffleView.this.nVT.cancel();
                                            }
                                            ShuffleView.this.gCO = null;
                                            ShuffleView.this.nVZ = 0;
                                        }
                                    }
                                } else if (view.getTranslationY() == 0.0f) {
                                    if (f2 > 0.0f && Math.abs(f2) > ((float) ShuffleView.this.nWj)) {
                                        if (((int) f2) >= view.getHeight() / 7) {
                                            view.setTranslationY((float) ((-view.getHeight()) / 7));
                                        } else {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                        }
                                    }
                                } else if (f2 < 0.0f) {
                                    if (view.getTranslationY() - f2 >= 0.0f) {
                                        view.setTranslationY(0.0f);
                                    } else {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                    }
                                } else if (((int) (view.getTranslationY() - f2)) <= (-view.getHeight()) / 7) {
                                    view.setTranslationY((float) ((-view.getHeight()) / 7));
                                } else {
                                    view.setTranslationY(view.getTranslationY() - f2);
                                }
                            }
                            AppMethodBeat.o(42241);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(42241);
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(42242);
            ab.i("ShuffleView", "fling up ".concat(String.valueOf(f2)));
            if (f2 < ((float) (-ShuffleView.this.nWk))) {
                switch (ShuffleView.this.nVQ.nWq) {
                    case 4:
                        if (ShuffleView.this.gCO != null) {
                            ShuffleView.m(ShuffleView.this);
                        }
                        if (ShuffleView.this.nWa != null) {
                            if (ShuffleView.this.nVW != null) {
                                b n = ShuffleView.this.nVW;
                                ShuffleView.this.nWb;
                                n.xL(ShuffleView.this.nWc);
                            }
                            ShuffleView.c(ShuffleView.this, ShuffleView.this.nWb);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(42242);
                return true;
            }
            AppMethodBeat.o(42242);
            return false;
        }
    });
    ValueAnimator lgH;
    List<View> nVP = new ArrayList();
    private c nVQ = new c();
    ValueAnimator nVR;
    private ValueAnimator nVS;
    ValueAnimator nVT;
    private a nVU;
    private a nVV;
    private b nVW;
    View nVX;
    private View nVY;
    int nVZ;
    private View nWa;
    private int nWb;
    int nWc;
    private final float nWd = 0.23f;
    private final float nWe = 0.28f;
    private final float nWf = 0.33f;
    private ArrayList<Float> nWg = new ArrayList();
    private ArrayList<Float> nWh = new ArrayList();
    private boolean nWi;
    private int nWj = getResources().getDimensionPixelSize(R.dimen.a4e);
    private int nWk = 2500;

    static class c {
        public int nWp = 1;
        public int nWq = 1;
        public int nWr = 2;
        public int nWs = 200;
        public int nWt = 80;
        public float scaleX = 0.01f;
        public float scaleY = 0.01f;

        c() {
        }
    }

    interface a {
        void a(ValueAnimator valueAnimator, View view);
    }

    interface b {
        void er(int i, int i2);

        void es(int i, int i2);

        void xL(int i);
    }

    static /* synthetic */ void a(ShuffleView shuffleView) {
        AppMethodBeat.i(42260);
        shuffleView.bLl();
        AppMethodBeat.o(42260);
    }

    static /* synthetic */ void c(ShuffleView shuffleView, int i) {
        AppMethodBeat.i(42266);
        shuffleView.xO(i);
        AppMethodBeat.o(42266);
    }

    static /* synthetic */ void f(ShuffleView shuffleView, int i) {
        AppMethodBeat.i(42268);
        shuffleView.xQ(i);
        AppMethodBeat.o(42268);
    }

    static /* synthetic */ float g(ShuffleView shuffleView) {
        AppMethodBeat.i(42261);
        float selectScaleTranslationX = shuffleView.getSelectScaleTranslationX();
        AppMethodBeat.o(42261);
        return selectScaleTranslationX;
    }

    static /* synthetic */ float j(ShuffleView shuffleView) {
        AppMethodBeat.i(42262);
        float touchScaleTranslationX = shuffleView.getTouchScaleTranslationX();
        AppMethodBeat.o(42262);
        return touchScaleTranslationX;
    }

    static /* synthetic */ void m(ShuffleView shuffleView) {
        AppMethodBeat.i(42264);
        shuffleView.bLn();
        AppMethodBeat.o(42264);
    }

    static /* synthetic */ void p(ShuffleView shuffleView) {
        AppMethodBeat.i(42267);
        shuffleView.bLo();
        AppMethodBeat.o(42267);
    }

    static /* synthetic */ int y(ShuffleView shuffleView) {
        AppMethodBeat.i(42269);
        int bLm = shuffleView.bLm();
        AppMethodBeat.o(42269);
        return bLm;
    }

    public ShuffleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42244);
        AppMethodBeat.o(42244);
    }

    public void setShuffleSetting(c cVar) {
        AppMethodBeat.i(42245);
        this.nVQ = cVar;
        this.lgH = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.nWs);
        this.nVT = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.nWt);
        AppMethodBeat.o(42245);
    }

    public void setAllShuffleCards(List<View> list) {
        AppMethodBeat.i(42246);
        this.nVP.clear();
        this.nVP.addAll(list);
        this.nVZ = 0;
        this.gCO = null;
        this.nWb = -1;
        this.nWa = null;
        removeAllViews();
        List list2 = this.nVP;
        if (list2.size() > 100) {
            this.nWc = 100;
        } else {
            this.nWc = list2.size();
            if (this.nWc == 1) {
                ((View) list2.get(0)).findViewById(R.id.cw0).setVisibility(0);
            }
        }
        for (int i = this.nWc - 1; i >= 0; i--) {
            addView((View) list2.get(i));
        }
        addOnLayoutChangeListener(new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.i(42224);
                ShuffleView.a(ShuffleView.this);
                ShuffleView shuffleView = ShuffleView.this;
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < shuffleView.nWc) {
                        shuffleView.W((View) shuffleView.nVP.get(i10), i10);
                        i9 = i10 + 1;
                    } else {
                        ShuffleView.this.removeOnLayoutChangeListener(this);
                        AppMethodBeat.o(42224);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.o(42246);
    }

    private void bLl() {
        AppMethodBeat.i(42247);
        if (this.nWc > 1) {
            ab.d("ShuffleView", "card width: %d,height: %d", Integer.valueOf(((View) this.nVP.get(0)).getWidth()), Integer.valueOf(((View) this.nVP.get(0)).getHeight()));
            if (this.nVQ.nWp == 2) {
                this.eX = (((float) ((View) this.nVP.get(0)).getWidth()) * 1.5f) / ((float) this.nWc);
                if (this.eX > ((float) ((View) this.nVP.get(0)).getWidth()) * 0.23f) {
                    this.eX = ((float) ((View) this.nVP.get(0)).getWidth()) * 0.23f;
                    AppMethodBeat.o(42247);
                    return;
                }
            } else if (this.nVQ.nWp == 1) {
                this.eY = (((float) ((View) this.nVP.get(0)).getHeight()) * 1.0f) / ((float) this.nWc);
                AppMethodBeat.o(42247);
                return;
            }
        }
        this.eX = 0.0f;
        this.eY = 0.0f;
        AppMethodBeat.o(42247);
    }

    /* Access modifiers changed, original: final */
    public final void W(View view, int i) {
        AppMethodBeat.i(42248);
        if (this.nVQ.nWp == 1) {
            view.setScaleX(1.0f - (this.nVQ.scaleX * ((float) i)));
            view.setTranslationY(xN(i));
            AppMethodBeat.o(42248);
            return;
        }
        if (this.nVQ.nWp == 2) {
            view.setScaleY(1.0f - (this.nVQ.scaleY * ((float) i)));
            view.setTranslationX(xM(i));
        }
        AppMethodBeat.o(42248);
    }

    public final float xM(int i) {
        if (this.nVQ.nWp == 2 && this.nWc > 0) {
            if (this.nVQ.nWq == 3) {
                return ((((float) (this.nWc - 1)) * 0.5f) * this.eX) - (this.eX * ((float) i));
            }
            if (this.nVQ.nWq == 4) {
                return (this.eX * ((float) i)) - ((((float) (this.nWc - 1)) * 0.5f) * this.eX);
            }
        }
        return 0.0f;
    }

    public final float xN(int i) {
        if (this.nVQ.nWp == 1) {
            if (this.nVQ.nWq == 1) {
                return ((((float) (this.nWc - 1)) * 0.5f) * this.eY) - (this.eY * ((float) i));
            }
            if (this.nVQ.nWq == 2) {
                return (this.eY * ((float) i)) - ((((float) (this.nWc - 1)) * 0.5f) * this.eY);
            }
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: final */
    public final int bLm() {
        AppMethodBeat.i(42249);
        int random = (int) (Math.random() * ((double) this.nWc));
        AppMethodBeat.o(42249);
        return random;
    }

    private void bLn() {
        AppMethodBeat.i(42250);
        if (this.gCO != null) {
            ab.i("ShuffleView", "selectView != null, cancel select");
            if (this.nVT.isStarted()) {
                this.nVT.cancel();
            }
            this.nVT.removeAllUpdateListeners();
            this.nVT.removeAllListeners();
            switch (this.nVQ.nWq) {
                case 4:
                    if (this.nVZ >= 0) {
                        this.nVT.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                AppMethodBeat.i(42233);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.nWg.clear();
                                    ShuffleView.this.nWh.clear();
                                    while (i < ShuffleView.this.nWc) {
                                        ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                                        ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    AppMethodBeat.o(42233);
                                    return;
                                }
                                while (true) {
                                    int i2 = i;
                                    if (i2 < ShuffleView.this.nWc) {
                                        ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xM(i2) * floatValue));
                                        ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(i2) * floatValue));
                                        i = i2 + 1;
                                    } else {
                                        AppMethodBeat.o(42233);
                                        return;
                                    }
                                }
                            }
                        });
                        break;
                    }
                    break;
            }
            this.gCO = null;
            this.nVZ = 0;
            this.nVT.start();
        }
        AppMethodBeat.o(42250);
    }

    private float getSelectScaleTranslationX() {
        AppMethodBeat.i(42251);
        if (this.gCO != null) {
            float width = (0.33f * ((float) this.gCO.getWidth())) - this.eX;
            int i = this.nVZ - 1;
            int i2 = (this.nWc - 1) - this.nVZ;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                float f = (width * 2.0f) / ((float) i3);
                AppMethodBeat.o(42251);
                return f;
            }
        }
        AppMethodBeat.o(42251);
        return 0.0f;
    }

    /* Access modifiers changed, original: final */
    public final void xO(int i) {
        AppMethodBeat.i(42252);
        if (i >= 0 && i < this.nWc) {
            ab.i("ShuffleView", "select card ".concat(String.valueOf(i)));
            if (this.nVT.isStarted()) {
                this.nVT.cancel();
            }
            this.nVT.removeAllUpdateListeners();
            this.nVT.removeAllListeners();
            this.gCO = (View) this.nVP.get(i);
            this.nVZ = i;
            this.nWa = null;
            this.nWb = -1;
            switch (this.nVQ.nWq) {
                case 4:
                    if (i <= 0) {
                        this.nVT.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                AppMethodBeat.i(42235);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.nWg.clear();
                                    ShuffleView.this.nWh.clear();
                                    while (i < ShuffleView.this.nWc) {
                                        ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                                        ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    AppMethodBeat.o(42235);
                                    return;
                                }
                                ShuffleView.this.gCO.setTranslationY((((Float) ShuffleView.this.nWh.get(0)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.gCO.getHeight()) * floatValue) / 7.0f));
                                int i2 = 1;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 < ShuffleView.this.nWc) {
                                        ((View) ShuffleView.this.nVP.get(i3)).setTranslationX((((Float) ShuffleView.this.nWg.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xM(i3) * floatValue));
                                        ((View) ShuffleView.this.nVP.get(i3)).setTranslationY((((Float) ShuffleView.this.nWh.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(i3) * floatValue));
                                        i2 = i3 + 1;
                                    } else {
                                        AppMethodBeat.o(42235);
                                        return;
                                    }
                                }
                            }
                        });
                        break;
                    }
                    final int i2 = i - 1;
                    final int i3 = (this.nWc - 1) - i;
                    this.nVT.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int i = 0;
                            AppMethodBeat.i(42234);
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (floatValue == 0.0f) {
                                ShuffleView.this.nWg.clear();
                                ShuffleView.this.nWh.clear();
                                while (i < ShuffleView.this.nWc) {
                                    ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                                    ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                                    i++;
                                }
                                AppMethodBeat.o(42234);
                                return;
                            }
                            int i2;
                            if (i2 <= 0) {
                                while (true) {
                                    i2 = i;
                                    if (i2 >= ShuffleView.this.nVZ) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xM(i2) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(i2) * floatValue));
                                    i = i2 + 1;
                                }
                            } else {
                                while (true) {
                                    i2 = i;
                                    if (i2 >= ShuffleView.this.nVZ - 1) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.xM(i2) - (((float) (i2 + 1)) * ShuffleView.g(ShuffleView.this))) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(i2) * floatValue));
                                    i = i2 + 1;
                                }
                                ((View) ShuffleView.this.nVP.get(ShuffleView.this.nVZ - 1)).setTranslationX((((Float) ShuffleView.this.nWg.get(ShuffleView.this.nVZ - 1)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.xM(ShuffleView.this.nVZ - 1) - ((ShuffleView.g(ShuffleView.this) * ((float) i2)) / 2.0f)) * floatValue));
                                ((View) ShuffleView.this.nVP.get(ShuffleView.this.nVZ - 1)).setTranslationY((((Float) ShuffleView.this.nWh.get(ShuffleView.this.nVZ - 1)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(ShuffleView.this.nVZ - 1) * floatValue));
                            }
                            int f;
                            if (i3 <= 0) {
                                f = ShuffleView.this.nVZ;
                                while (true) {
                                    i2 = f;
                                    if (i2 >= ShuffleView.this.nWc) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xM(i2) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(i2) * floatValue));
                                    f = i2 + 1;
                                }
                            } else {
                                ShuffleView.this.gCO.setTranslationX((((Float) ShuffleView.this.nWg.get(ShuffleView.this.nVZ)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.xM(ShuffleView.this.nVZ) + ((ShuffleView.g(ShuffleView.this) * ((float) i3)) / 2.0f)) * floatValue));
                                f = ShuffleView.this.nVZ + 1;
                                while (true) {
                                    i2 = f;
                                    if (i2 >= ShuffleView.this.nWc) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.xM(i2) + (((float) (ShuffleView.this.nWc - i2)) * ShuffleView.g(ShuffleView.this))) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(i2) * floatValue));
                                    f = i2 + 1;
                                }
                            }
                            ShuffleView.this.gCO.setTranslationY((((Float) ShuffleView.this.nWh.get(ShuffleView.this.nVZ)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.gCO.getHeight()) * floatValue) / 7.0f));
                            AppMethodBeat.o(42234);
                        }
                    });
                    break;
            }
            this.nVT.start();
        }
        AppMethodBeat.o(42252);
    }

    private void bLo() {
        AppMethodBeat.i(42253);
        if (this.nWa != null) {
            ab.i("ShuffleView", "touchView != null,cancel touch");
            if (this.nVT.isStarted()) {
                this.nVT.cancel();
            }
            this.nVT.removeAllUpdateListeners();
            this.nVT.removeAllListeners();
            switch (this.nVQ.nWq) {
                case 4:
                    if (this.nWb >= 0) {
                        this.nVT.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                AppMethodBeat.i(42236);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.nWg.clear();
                                    ShuffleView.this.nWh.clear();
                                    while (i < ShuffleView.this.nWc) {
                                        ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                                        ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    AppMethodBeat.o(42236);
                                    return;
                                }
                                while (true) {
                                    int i2 = i;
                                    if (i2 < ShuffleView.this.nWc) {
                                        ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xM(i2) * floatValue));
                                        ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.xN(i2) * floatValue));
                                        i = i2 + 1;
                                    } else {
                                        AppMethodBeat.o(42236);
                                        return;
                                    }
                                }
                            }
                        });
                        break;
                    }
                    break;
            }
            this.nWa = null;
            this.nWb = -1;
            this.nVT.start();
        }
        AppMethodBeat.o(42253);
    }

    private float getTouchScaleTranslationX() {
        AppMethodBeat.i(42254);
        if (this.nWa != null) {
            float width = (0.28f * ((float) this.nWa.getWidth())) - this.eX;
            int i = this.nWb - 1;
            int i2 = (this.nWc - 1) - this.nWb;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                float f = (width * 2.0f) / ((float) i3);
                AppMethodBeat.o(42254);
                return f;
            }
        }
        AppMethodBeat.o(42254);
        return 0.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(42255);
        if (this.nWi) {
            AppMethodBeat.o(42255);
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.nWc <= 0) {
            AppMethodBeat.o(42255);
            return false;
        }
        ab.d("ShuffleView", "y:%d,packet largest:%d", Integer.valueOf(y), Integer.valueOf((getHeight() - ((View) this.nVP.get(0)).getHeight()) - (((View) this.nVP.get(0)).getHeight() / 7)));
        if (y < (getHeight() - ((View) this.nVP.get(0)).getHeight()) - (((View) this.nVP.get(0)).getHeight() / 7)) {
            if (this.gCO != null && motionEvent.getActionMasked() == 0) {
                if (this.nVW != null) {
                    this.nVW.es(this.nVZ, this.nWc);
                }
                bLn();
            } else if (this.nWa != null && this.nWa.getTranslationY() == ((float) ((-this.nWa.getHeight()) / 7))) {
                if (this.nVW != null) {
                    this.nVW.xL(this.nWc);
                }
                xO(this.nWb);
            } else if (this.nWa != null) {
                bLo();
            }
            AppMethodBeat.o(42255);
            return false;
        }
        int i;
        for (i = 0; i < this.nWc; i++) {
            Rect xP = xP(i);
            if (xP != null && xP.contains(x, y)) {
                i = 1;
                break;
            }
        }
        boolean z = false;
        if (i == 0) {
            ab.d("ShuffleView", "event %d out of cards,%d,%d", Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(x), Integer.valueOf(y));
            if (this.gCO != null && motionEvent.getActionMasked() == 0) {
                if (this.nVW != null) {
                    this.nVW.es(this.nVZ, this.nWc);
                }
                bLn();
            } else if (this.nWa != null && this.nWa.getTranslationY() == ((float) ((-this.nWa.getHeight()) / 7))) {
                if (this.nVW != null) {
                    this.nVW.xL(this.nWc);
                }
                xO(this.nWb);
            } else if (this.nWa != null) {
                bLo();
            }
        }
        if (this.nWc <= 1) {
            AppMethodBeat.o(42255);
            return false;
        }
        ab.i("ShuffleView", "ret:%s,action:%s", Boolean.valueOf(this.lCs.onTouchEvent(motionEvent)), Integer.valueOf(motionEvent.getActionMasked()));
        if (!this.lCs.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1) {
            if (this.nWa != null && this.nWa.getTranslationY() == ((float) ((-this.nWa.getHeight()) / 7))) {
                if (this.nVW != null) {
                    this.nVW.xL(this.nWc);
                }
                xO(this.nWb);
            } else if (this.nWa != null) {
                bLo();
            }
        }
        AppMethodBeat.o(42255);
        return true;
    }

    private Rect xP(int i) {
        AppMethodBeat.i(42256);
        if (i >= 0 && i < this.nWc) {
            View view = (View) this.nVP.get(i);
            switch (this.nVQ.nWq) {
                case 4:
                    if (i == 0) {
                        Rect rect = new Rect(view.getLeft() + ((int) view.getTranslationX()), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                        AppMethodBeat.o(42256);
                        return rect;
                    }
                    View view2 = (View) this.nVP.get(i - 1);
                    Rect rect2 = new Rect(((int) view2.getTranslationX()) + view2.getRight(), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                    AppMethodBeat.o(42256);
                    return rect2;
            }
        }
        AppMethodBeat.o(42256);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void xQ(final int i) {
        AppMethodBeat.i(42257);
        this.lgH.removeAllUpdateListeners();
        this.lgH.removeAllListeners();
        if (this.nVP.size() < this.nWc) {
            this.nWc--;
            if (this.nWc == 1) {
                ((View) this.nVP.get(0)).findViewById(R.id.cw0).setVisibility(0);
            }
            bLl();
            this.lgH.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i = 0;
                    AppMethodBeat.i(42243);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue == 0.0f) {
                        ShuffleView.this.nWg.clear();
                        ShuffleView.this.nWh.clear();
                        while (i < ShuffleView.this.nWc) {
                            ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                            ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                            i++;
                        }
                        AppMethodBeat.o(42243);
                        return;
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 < ShuffleView.this.nWc) {
                            View view = (View) ShuffleView.this.nVP.get(i2);
                            if (ShuffleView.this.nVQ.nWp == 1) {
                                view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleX) + (1.0f - (ShuffleView.this.nVQ.scaleX * ((float) (i2 + 1)))));
                                view.setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.xN(i2)));
                            } else if (ShuffleView.this.nVQ.nWp == 2) {
                                view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleY) + (1.0f - (ShuffleView.this.nVQ.scaleY * ((float) (i2 + 1)))));
                                view.setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.xM(i2)));
                            }
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.o(42243);
                            return;
                        }
                    }
                }
            });
            this.lgH.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(42225);
                    ShuffleView.this.nWi = true;
                    AppMethodBeat.o(42225);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(42226);
                    ShuffleView.this.nWi = false;
                    ShuffleView.this.nWa = null;
                    ShuffleView.this.nWb = -1;
                    AppMethodBeat.o(42226);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        } else {
            this.nVY = (View) this.nVP.get(this.nWc - 1);
            W(this.nVY, this.nWc - 1);
            addView(this.nVY, 0);
            if (this.nVS != null) {
                switch (this.nVQ.nWr) {
                    case 1:
                        this.nVY.setTranslationY((float) (-ghw.heightPixels));
                        break;
                    case 2:
                        this.nVY.setTranslationY((float) ghw.heightPixels);
                        break;
                    case 3:
                        this.nVY.setTranslationX((float) (-ghw.widthPixels));
                        break;
                    case 4:
                        this.nVY.setTranslationX((float) ghw.widthPixels);
                        break;
                }
            }
            this.nVY.setVisibility(4);
            this.lgH.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(42227);
                    int i = i;
                    while (true) {
                        int i2 = i;
                        if (i2 < ShuffleView.this.nWc - 1) {
                            View view = (View) ShuffleView.this.nVP.get(i2);
                            if (ShuffleView.this.nVQ.nWp == 1) {
                                view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleX) + (1.0f - (ShuffleView.this.nVQ.scaleX * ((float) (i2 + 1)))));
                                if (ShuffleView.this.nVQ.nWq == 2) {
                                    view.setTranslationY(ShuffleView.this.xN(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.eY));
                                } else if (ShuffleView.this.nVQ.nWq == 1) {
                                    view.setTranslationY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.eY) + ShuffleView.this.xN(i2 + 1));
                                }
                            } else if (ShuffleView.this.nVQ.nWp == 2) {
                                view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleY) + (1.0f - (ShuffleView.this.nVQ.scaleY * ((float) (i2 + 1)))));
                                if (ShuffleView.this.nVQ.nWq == 3) {
                                    view.setTranslationX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.eX) + ShuffleView.this.xM(i2 + 1));
                                } else if (ShuffleView.this.nVQ.nWq == 4) {
                                    view.setTranslationX(ShuffleView.this.xM(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.eX));
                                }
                            }
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.o(42227);
                            return;
                        }
                    }
                }
            });
            this.lgH.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(42228);
                    ShuffleView.this.nWi = true;
                    AppMethodBeat.o(42228);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(42229);
                    ShuffleView.this.nWi = false;
                    ShuffleView.this.nVY.setVisibility(0);
                    if (ShuffleView.this.nVS != null) {
                        ShuffleView.this.nVS.start();
                    }
                    AppMethodBeat.o(42229);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        this.lgH.start();
        AppMethodBeat.o(42257);
    }

    public void setExitAnimator(ValueAnimator valueAnimator) {
        AppMethodBeat.i(42258);
        if (this.nVR != null) {
            this.nVR.removeAllListeners();
            this.nVR.cancel();
        }
        this.nVR = valueAnimator;
        if (this.nVR != null) {
            this.nVR.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(42231);
                    if (ShuffleView.this.nVU != null) {
                        ShuffleView.this.nVU.a(valueAnimator, ShuffleView.this.nVX);
                    }
                    AppMethodBeat.o(42231);
                }
            });
        }
        AppMethodBeat.o(42258);
    }

    public void setEnterAnimator(ValueAnimator valueAnimator) {
        AppMethodBeat.i(42259);
        if (this.nVS != null) {
            this.nVS.removeAllListeners();
            this.nVS.cancel();
        }
        this.nVS = valueAnimator;
        if (this.nVS != null) {
            this.nVS.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(42232);
                    if (ShuffleView.this.nVV != null) {
                        ShuffleView.this.nVV.a(valueAnimator, ShuffleView.this.nVY);
                    }
                    AppMethodBeat.o(42232);
                }
            });
        }
        AppMethodBeat.o(42259);
    }

    public void setExitAnimatorListener(a aVar) {
        this.nVU = aVar;
    }

    public void setEnterAnimatorListener(a aVar) {
        this.nVV = aVar;
    }

    public void setCardListener(b bVar) {
        this.nVW = bVar;
    }

    public View getExitView() {
        return this.nVX;
    }

    public View getEnterView() {
        return this.nVY;
    }
}
