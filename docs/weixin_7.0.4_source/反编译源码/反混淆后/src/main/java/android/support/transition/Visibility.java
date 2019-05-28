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
import android.support.p057v4.content.p062a.C0379c;
import android.support.transition.C44951b.C25326a;
import android.support.transition.Transition.C31852c;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

public abstract class Visibility extends Transition {
    /* renamed from: xk */
    private static final String[] f3842xk = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    int mMode = 3;

    /* renamed from: android.support.transition.Visibility$b */
    static class C17410b {
        /* renamed from: BH */
        boolean f3843BH;
        /* renamed from: BI */
        boolean f3844BI;
        /* renamed from: BJ */
        int f3845BJ;
        /* renamed from: BK */
        int f3846BK;
        /* renamed from: BL */
        ViewGroup f3847BL;
        /* renamed from: yE */
        ViewGroup f3848yE;

        private C17410b() {
        }

        /* synthetic */ C17410b(byte b) {
            this();
        }
    }

    /* renamed from: android.support.transition.Visibility$a */
    static class C17411a extends AnimatorListenerAdapter implements C31852c, C25326a {
        /* renamed from: BD */
        private final int f3849BD;
        /* renamed from: BE */
        private final ViewGroup f3850BE;
        /* renamed from: BF */
        private final boolean f3851BF;
        /* renamed from: BG */
        private boolean f3852BG;
        private final View mView;
        /* renamed from: xH */
        boolean f3853xH = false;

        C17411a(View view, int i) {
            this.mView = view;
            this.f3849BD = i;
            this.f3850BE = (ViewGroup) view.getParent();
            this.f3851BF = true;
            m27040w(true);
        }

        public final void onAnimationPause(Animator animator) {
            if (!this.f3853xH) {
                C41495au.m72484l(this.mView, this.f3849BD);
            }
        }

        public final void onAnimationResume(Animator animator) {
            if (!this.f3853xH) {
                C41495au.m72484l(this.mView, 0);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f3853xH = true;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            m27039dc();
        }

        /* renamed from: cT */
        public final void mo31631cT() {
        }

        /* renamed from: a */
        public final void mo452a(Transition transition) {
            m27039dc();
            transition.mo42277b((C31852c) this);
        }

        /* renamed from: cO */
        public final void mo18279cO() {
            m27040w(false);
        }

        /* renamed from: cP */
        public final void mo18280cP() {
            m27040w(true);
        }

        /* renamed from: dc */
        private void m27039dc() {
            if (!this.f3853xH) {
                C41495au.m72484l(this.mView, this.f3849BD);
                if (this.f3850BE != null) {
                    this.f3850BE.invalidate();
                }
            }
            m27040w(false);
        }

        /* renamed from: w */
        private void m27040w(boolean z) {
            if (this.f3851BF && this.f3852BG != z && this.f3850BE != null) {
                this.f3852BG = z;
                C44949an.m82225c(this.f3850BE, z);
            }
        }
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15731zA);
        int a = C0379c.m637a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
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
        return f3842xk;
    }

    /* renamed from: c */
    private static void m27032c(C8368ah c8368ah) {
        c8368ah.values.put("android:visibility:visibility", Integer.valueOf(c8368ah.view.getVisibility()));
        c8368ah.values.put("android:visibility:parent", c8368ah.view.getParent());
        int[] iArr = new int[2];
        c8368ah.view.getLocationOnScreen(iArr);
        c8368ah.values.put("android:visibility:screenLocation", iArr);
    }

    /* renamed from: a */
    public void mo410a(C8368ah c8368ah) {
        m27032c(c8368ah);
    }

    /* renamed from: b */
    public void mo411b(C8368ah c8368ah) {
        m27032c(c8368ah);
    }

    /* renamed from: b */
    private static C17410b m27031b(C8368ah c8368ah, C8368ah c8368ah2) {
        C17410b c17410b = new C17410b();
        c17410b.f3843BH = false;
        c17410b.f3844BI = false;
        if (c8368ah == null || !c8368ah.values.containsKey("android:visibility:visibility")) {
            c17410b.f3845BJ = -1;
            c17410b.f3848yE = null;
        } else {
            c17410b.f3845BJ = ((Integer) c8368ah.values.get("android:visibility:visibility")).intValue();
            c17410b.f3848yE = (ViewGroup) c8368ah.values.get("android:visibility:parent");
        }
        if (c8368ah2 == null || !c8368ah2.values.containsKey("android:visibility:visibility")) {
            c17410b.f3846BK = -1;
            c17410b.f3847BL = null;
        } else {
            c17410b.f3846BK = ((Integer) c8368ah2.values.get("android:visibility:visibility")).intValue();
            c17410b.f3847BL = (ViewGroup) c8368ah2.values.get("android:visibility:parent");
        }
        if (c8368ah == null || c8368ah2 == null) {
            if (c8368ah == null && c17410b.f3846BK == 0) {
                c17410b.f3844BI = true;
                c17410b.f3843BH = true;
            } else if (c8368ah2 == null && c17410b.f3845BJ == 0) {
                c17410b.f3844BI = false;
                c17410b.f3843BH = true;
            }
        } else if (c17410b.f3845BJ == c17410b.f3846BK && c17410b.f3848yE == c17410b.f3847BL) {
            return c17410b;
        } else {
            if (c17410b.f3845BJ != c17410b.f3846BK) {
                if (c17410b.f3845BJ == 0) {
                    c17410b.f3844BI = false;
                    c17410b.f3843BH = true;
                } else if (c17410b.f3846BK == 0) {
                    c17410b.f3844BI = true;
                    c17410b.f3843BH = true;
                }
            } else if (c17410b.f3847BL == null) {
                c17410b.f3844BI = false;
                c17410b.f3843BH = true;
            } else if (c17410b.f3848yE == null) {
                c17410b.f3844BI = true;
                c17410b.f3843BH = true;
            }
        }
        return c17410b;
    }

    /* renamed from: a */
    public final Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        C17410b b = m27031b(c8368ah, c8368ah2);
        if (!b.f3843BH || (b.f3848yE == null && b.f3847BL == null)) {
            return null;
        }
        View view;
        if (!b.f3844BI) {
            int i = b.f3846BK;
            if ((this.mMode & 2) == 2) {
                int id;
                View view2 = c8368ah != null ? c8368ah.view : null;
                view = c8368ah2 != null ? c8368ah2.view : null;
                View view3 = null;
                View view4 = null;
                if (view == null || view.getParent() == null) {
                    if (view != null) {
                        view3 = view;
                    } else if (view2 != null) {
                        if (view2.getParent() != null) {
                            if (view2.getParent() instanceof View) {
                                view = (View) view2.getParent();
                                if (m27031b(mo59140b(view, true), mo59143c(view, true)).f3843BH) {
                                    if (view.getParent() == null) {
                                        id = view.getId();
                                        if (!(id == -1 || viewGroup.findViewById(id) == null || !this.f15700Ad)) {
                                            view = view2;
                                            view3 = view;
                                        }
                                    }
                                    view = null;
                                    view3 = view;
                                } else {
                                    Matrix matrix = new Matrix();
                                    matrix.setTranslate((float) (-view.getScrollX()), (float) (-view.getScrollY()));
                                    C41495au.m72479a(view2, matrix);
                                    C41495au.m72481b(viewGroup, matrix);
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
                if (view3 != null && c8368ah != null) {
                    int[] iArr = (int[]) c8368ah.values.get("android:visibility:screenLocation");
                    i2 = iArr[0];
                    id = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    view3.offsetLeftAndRight((i2 - iArr2[0]) - view3.getLeft());
                    view3.offsetTopAndBottom((id - iArr2[1]) - view3.getTop());
                    final C37105am c = C44949an.m82224c(viewGroup);
                    c.add(view3);
                    a = mo18282a(viewGroup, view3, c8368ah);
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
                    C41495au.m72484l(view4, 0);
                    a = mo18282a(viewGroup, view4, c8368ah);
                    if (a != null) {
                        C17411a c17411a = new C17411a(view4, i);
                        a.addListener(c17411a);
                        C37102a.m62100a(a, c17411a);
                        mo42271a((C31852c) c17411a);
                        return a;
                    }
                    C41495au.m72484l(view4, i2);
                    return a;
                }
            }
            return null;
        } else if ((this.mMode & 1) != 1 || c8368ah2 == null) {
            return null;
        } else {
            if (c8368ah == null) {
                view = (View) c8368ah2.view.getParent();
                if (m27031b(mo59143c(view, false), mo59140b(view, false)).f3843BH) {
                    return null;
                }
            }
            return mo18283a(viewGroup, c8368ah2.view, c8368ah, c8368ah2);
        }
    }

    /* renamed from: a */
    public Animator mo18283a(ViewGroup viewGroup, View view, C8368ah c8368ah, C8368ah c8368ah2) {
        return null;
    }

    /* renamed from: a */
    public Animator mo18282a(ViewGroup viewGroup, View view, C8368ah c8368ah) {
        return null;
    }

    /* renamed from: a */
    public final boolean mo31632a(C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null && c8368ah2 == null) {
            return false;
        }
        if (c8368ah != null && c8368ah2 != null && c8368ah2.values.containsKey("android:visibility:visibility") != c8368ah.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        C17410b b = m27031b(c8368ah, c8368ah2);
        if (!b.f3843BH) {
            return false;
        }
        if (b.f3845BJ == 0 || b.f3846BK == 0) {
            return true;
        }
        return false;
    }
}
