package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.transition.Transition.c;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

public abstract class Visibility extends Transition {
    private static final String[] xk = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    int mMode = 3;

    static class b {
        boolean BH;
        boolean BI;
        int BJ;
        int BK;
        ViewGroup BL;
        ViewGroup yE;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class a extends AnimatorListenerAdapter implements c, a {
        private final int BD;
        private final ViewGroup BE;
        private final boolean BF;
        private boolean BG;
        private final View mView;
        boolean xH = false;

        a(View view, int i) {
            this.mView = view;
            this.BD = i;
            this.BE = (ViewGroup) view.getParent();
            this.BF = true;
            w(true);
        }

        public final void onAnimationPause(Animator animator) {
            if (!this.xH) {
                au.l(this.mView, this.BD);
            }
        }

        public final void onAnimationResume(Animator animator) {
            if (!this.xH) {
                au.l(this.mView, 0);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.xH = true;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            dc();
        }

        public final void cT() {
        }

        public final void a(Transition transition) {
            dc();
            transition.b((c) this);
        }

        public final void cO() {
            w(false);
        }

        public final void cP() {
            w(true);
        }

        private void dc() {
            if (!this.xH) {
                au.l(this.mView, this.BD);
                if (this.BE != null) {
                    this.BE.invalidate();
                }
            }
            w(false);
        }

        private void w(boolean z) {
            if (this.BF && this.BG != z && this.BE != null) {
                this.BG = z;
                an.c(this.BE, z);
            }
        }
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zA);
        int a = android.support.v4.content.a.c.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (a != 0) {
            setMode(a);
        }
    }

    public final void setMode(int i) {
        if ((i & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i;
    }

    public final String[] getTransitionProperties() {
        return xk;
    }

    private static void c(ah ahVar) {
        ahVar.values.put("android:visibility:visibility", Integer.valueOf(ahVar.view.getVisibility()));
        ahVar.values.put("android:visibility:parent", ahVar.view.getParent());
        int[] iArr = new int[2];
        ahVar.view.getLocationOnScreen(iArr);
        ahVar.values.put("android:visibility:screenLocation", iArr);
    }

    public void a(ah ahVar) {
        c(ahVar);
    }

    public void b(ah ahVar) {
        c(ahVar);
    }

    private static b b(ah ahVar, ah ahVar2) {
        b bVar = new b();
        bVar.BH = false;
        bVar.BI = false;
        if (ahVar == null || !ahVar.values.containsKey("android:visibility:visibility")) {
            bVar.BJ = -1;
            bVar.yE = null;
        } else {
            bVar.BJ = ((Integer) ahVar.values.get("android:visibility:visibility")).intValue();
            bVar.yE = (ViewGroup) ahVar.values.get("android:visibility:parent");
        }
        if (ahVar2 == null || !ahVar2.values.containsKey("android:visibility:visibility")) {
            bVar.BK = -1;
            bVar.BL = null;
        } else {
            bVar.BK = ((Integer) ahVar2.values.get("android:visibility:visibility")).intValue();
            bVar.BL = (ViewGroup) ahVar2.values.get("android:visibility:parent");
        }
        if (ahVar == null || ahVar2 == null) {
            if (ahVar == null && bVar.BK == 0) {
                bVar.BI = true;
                bVar.BH = true;
            } else if (ahVar2 == null && bVar.BJ == 0) {
                bVar.BI = false;
                bVar.BH = true;
            }
        } else if (bVar.BJ == bVar.BK && bVar.yE == bVar.BL) {
            return bVar;
        } else {
            if (bVar.BJ != bVar.BK) {
                if (bVar.BJ == 0) {
                    bVar.BI = false;
                    bVar.BH = true;
                } else if (bVar.BK == 0) {
                    bVar.BI = true;
                    bVar.BH = true;
                }
            } else if (bVar.BL == null) {
                bVar.BI = false;
                bVar.BH = true;
            } else if (bVar.yE == null) {
                bVar.BI = true;
                bVar.BH = true;
            }
        }
        return bVar;
    }

    public final Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        b b = b(ahVar, ahVar2);
        if (!b.BH || (b.yE == null && b.BL == null)) {
            return null;
        }
        View view;
        if (!b.BI) {
            int i = b.BK;
            if ((this.mMode & 2) == 2) {
                int id;
                View view2 = ahVar != null ? ahVar.view : null;
                view = ahVar2 != null ? ahVar2.view : null;
                View view3 = null;
                View view4 = null;
                if (view == null || view.getParent() == null) {
                    if (view != null) {
                        view3 = view;
                    } else if (view2 != null) {
                        if (view2.getParent() != null) {
                            if (view2.getParent() instanceof View) {
                                view = (View) view2.getParent();
                                if (b(b(view, true), c(view, true)).BH) {
                                    if (view.getParent() == null) {
                                        id = view.getId();
                                        if (!(id == -1 || viewGroup.findViewById(id) == null || !this.Ad)) {
                                            view = view2;
                                            view3 = view;
                                        }
                                    }
                                    view = null;
                                    view3 = view;
                                } else {
                                    Matrix matrix = new Matrix();
                                    matrix.setTranslate((float) (-view.getScrollX()), (float) (-view.getScrollY()));
                                    au.a(view2, matrix);
                                    au.b(viewGroup, matrix);
                                    RectF rectF = new RectF(0.0f, 0.0f, (float) view2.getWidth(), (float) view2.getHeight());
                                    matrix.mapRect(rectF);
                                    int round = Math.round(rectF.left);
                                    int round2 = Math.round(rectF.top);
                                    int round3 = Math.round(rectF.right);
                                    int round4 = Math.round(rectF.bottom);
                                    view3 = new ImageView(view2.getContext());
                                    view3.setScaleType(ScaleType.CENTER_CROP);
                                    Bitmap bitmap = null;
                                    int round5 = Math.round(rectF.width());
                                    int round6 = Math.round(rectF.height());
                                    if (round5 > 0 && round6 > 0) {
                                        float min = Math.min(1.0f, 1048576.0f / ((float) (round5 * round6)));
                                        round5 = (int) (((float) round5) * min);
                                        round6 = (int) (((float) round6) * min);
                                        matrix.postTranslate(-rectF.left, -rectF.top);
                                        matrix.postScale(min, min);
                                        bitmap = Bitmap.createBitmap(round5, round6, Config.ARGB_8888);
                                        Canvas canvas = new Canvas(bitmap);
                                        canvas.concat(matrix);
                                        view2.draw(canvas);
                                    }
                                    if (bitmap != null) {
                                        view3.setImageBitmap(bitmap);
                                    }
                                    view3.measure(MeasureSpec.makeMeasureSpec(round3 - round, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(round4 - round2, ErrorDialogData.SUPPRESSED));
                                    view3.layout(round, round2, round3, round4);
                                }
                            }
                        }
                        view3 = view2;
                    }
                } else if (i == 4) {
                    view4 = view;
                } else {
                    if (view2 == view) {
                        view4 = view;
                    }
                    view3 = view2;
                }
                int i2;
                Animator a;
                if (view3 != null && ahVar != null) {
                    int[] iArr = (int[]) ahVar.values.get("android:visibility:screenLocation");
                    i2 = iArr[0];
                    id = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    view3.offsetLeftAndRight((i2 - iArr2[0]) - view3.getLeft());
                    view3.offsetTopAndBottom((id - iArr2[1]) - view3.getTop());
                    final am c = an.c(viewGroup);
                    c.add(view3);
                    a = a(viewGroup, view3, ahVar);
                    if (a == null) {
                        c.remove(view3);
                        return a;
                    }
                    a.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationEnd(Animator animator) {
                            c.remove(view3);
                        }
                    });
                    return a;
                } else if (view4 != null) {
                    i2 = view4.getVisibility();
                    au.l(view4, 0);
                    a = a(viewGroup, view4, ahVar);
                    if (a != null) {
                        a aVar = new a(view4, i);
                        a.addListener(aVar);
                        a.a(a, aVar);
                        a((c) aVar);
                        return a;
                    }
                    au.l(view4, i2);
                    return a;
                }
            }
            return null;
        } else if ((this.mMode & 1) != 1 || ahVar2 == null) {
            return null;
        } else {
            if (ahVar == null) {
                view = (View) ahVar2.view.getParent();
                if (b(c(view, false), b(view, false)).BH) {
                    return null;
                }
            }
            return a(viewGroup, ahVar2.view, ahVar, ahVar2);
        }
    }

    public Animator a(ViewGroup viewGroup, View view, ah ahVar, ah ahVar2) {
        return null;
    }

    public Animator a(ViewGroup viewGroup, View view, ah ahVar) {
        return null;
    }

    public final boolean a(ah ahVar, ah ahVar2) {
        if (ahVar == null && ahVar2 == null) {
            return false;
        }
        if (ahVar != null && ahVar2 != null && ahVar2.values.containsKey("android:visibility:visibility") != ahVar.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b = b(ahVar, ahVar2);
        if (!b.BH) {
            return false;
        }
        if (b.BJ == 0 || b.BK == 0) {
            return true;
        }
        return false;
    }
}
