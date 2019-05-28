package com.tencent.p177mm.p612ui.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.widget.listview.AnimatedExpandableListView */
public class AnimatedExpandableListView extends ExpandableListView {
    private static final String TAG = C16004a.class.getSimpleName();
    private C16004a zQT;

    /* renamed from: com.tencent.mm.ui.widget.listview.AnimatedExpandableListView$a */
    public static abstract class C16004a extends BaseExpandableListAdapter {
        private SparseArray<C24098d> zQU = new SparseArray();
        private AnimatedExpandableListView zQV;

        /* renamed from: Ec */
        public abstract int mo28311Ec(int i);

        /* renamed from: d */
        public abstract View mo28313d(int i, int i2, View view);

        /* renamed from: Qk */
        private C24098d m24306Qk(int i) {
            C24098d c24098d = (C24098d) this.zQU.get(i);
            if (c24098d != null) {
                return c24098d;
            }
            c24098d = new C24098d();
            this.zQU.put(i, c24098d);
            return c24098d;
        }

        /* renamed from: Ql */
        public final void mo28312Ql(int i) {
            m24306Qk(i).zRh = -1;
        }

        public final int getChildType(int i, int i2) {
            if (m24306Qk(i).mSe) {
                return 0;
            }
            return 1;
        }

        public final int getChildTypeCount() {
            return 2;
        }

        public final View getChildView(final int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            C24098d Qk = m24306Qk(i);
            if (!Qk.mSe) {
                return mo28313d(i, i2, view);
            }
            View view2;
            if (view instanceof C24096b) {
                view2 = view;
            } else {
                view2 = new C24096b(viewGroup.getContext(), (byte) 0);
                view2.setLayoutParams(new LayoutParams(-1, 0));
            }
            if (i2 < Qk.zRg) {
                view2.getLayoutParams().height = 0;
                return view2;
            }
            int i3;
            final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            final C24096b c24096b = (C24096b) view2;
            c24096b.zRa.clear();
            C24096b.m37064a(c24096b, expandableListView.getDivider(), viewGroup.getMeasuredWidth(), expandableListView.getDividerHeight());
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), ErrorDialogData.SUPPRESSED);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int i4 = 0;
            int height = viewGroup.getHeight();
            int Ec = mo28311Ec(i);
            for (i3 = Qk.zRg; i3 < Ec; i3++) {
                View d = mo28313d(i, i3, null);
                d.measure(makeMeasureSpec, makeMeasureSpec2);
                i4 += d.getMeasuredHeight();
                if (i4 >= height) {
                    c24096b.mo39904fp(d);
                    i4 += ((Ec - i3) - 1) * (i4 / (i3 + 1));
                    break;
                }
                c24096b.mo39904fp(d);
            }
            Object tag = c24096b.getTag();
            if (tag == null) {
                i3 = 0;
            } else {
                i3 = ((Integer) tag).intValue();
            }
            C24097c c24097c;
            if (Qk.zRf && r2 != 1) {
                c24097c = new C24097c(c24096b, 0, i4, Qk, (byte) 0);
                c24097c.setDuration((long) AnimatedExpandableListView.m37061a(this.zQV));
                c24097c.setAnimationListener(new AnimationListener() {
                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(112710);
                        C16004a.this.m24306Qk(i).mSe = false;
                        C16004a.this.notifyDataSetChanged();
                        c24096b.setTag(Integer.valueOf(0));
                        AppMethodBeat.m2505o(112710);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                c24096b.startAnimation(c24097c);
                c24096b.setTag(Integer.valueOf(1));
                return view2;
            } else if (Qk.zRf || r2 == 2) {
                return view2;
            } else {
                if (Qk.zRh == -1) {
                    Qk.zRh = i4;
                }
                c24097c = new C24097c(c24096b, Qk.zRh, 0, Qk, (byte) 0);
                c24097c.setDuration((long) AnimatedExpandableListView.m37061a(this.zQV));
                Ec = i;
                final C24098d c24098d = Qk;
                final C24096b c24096b2 = c24096b;
                c24097c.setAnimationListener(new AnimationListener() {
                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(112711);
                        C16004a.this.m24306Qk(Ec).mSe = false;
                        expandableListView.collapseGroup(Ec);
                        C16004a.this.notifyDataSetChanged();
                        c24098d.zRh = -1;
                        c24096b2.setTag(Integer.valueOf(0));
                        AppMethodBeat.m2505o(112711);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                c24096b.startAnimation(c24097c);
                c24096b.setTag(Integer.valueOf(2));
                return view2;
            }
        }

        public final int getChildrenCount(int i) {
            C24098d Qk = m24306Qk(i);
            if (Qk.mSe) {
                return Qk.zRg + 1;
            }
            return mo28311Ec(i);
        }

        /* renamed from: a */
        static /* synthetic */ void m24308a(C16004a c16004a, int i, int i2) {
            C24098d Qk = c16004a.m24306Qk(i);
            Qk.mSe = true;
            Qk.zRg = i2;
            Qk.zRf = false;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.listview.AnimatedExpandableListView$b */
    static class C24096b extends View {
        private int dividerHeight;
        private Drawable gAf;
        List<View> zRa;
        private int zRb;

        /* synthetic */ C24096b(Context context, byte b) {
            this(context);
        }

        private C24096b(Context context) {
            super(context);
            AppMethodBeat.m2504i(112712);
            this.zRa = new ArrayList();
            AppMethodBeat.m2505o(112712);
        }

        /* renamed from: fp */
        public final void mo39904fp(View view) {
            AppMethodBeat.m2504i(112713);
            view.layout(0, 0, getWidth(), getHeight());
            this.zRa.add(view);
            AppMethodBeat.m2505o(112713);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(112714);
            super.onLayout(z, i, i2, i3, i4);
            int size = this.zRa.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((View) this.zRa.get(i5)).layout(i, i2, i3, i4);
            }
            AppMethodBeat.m2505o(112714);
        }

        public final void dispatchDraw(Canvas canvas) {
            AppMethodBeat.m2504i(112715);
            canvas.save();
            if (this.gAf != null) {
                this.gAf.setBounds(0, 0, this.zRb, this.dividerHeight);
            }
            int size = this.zRa.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.zRa.get(i);
                view.draw(canvas);
                canvas.translate(0.0f, (float) view.getMeasuredHeight());
                if (this.gAf != null) {
                    this.gAf.draw(canvas);
                    canvas.translate(0.0f, (float) this.dividerHeight);
                }
            }
            canvas.restore();
            AppMethodBeat.m2505o(112715);
        }

        /* renamed from: a */
        static /* synthetic */ void m37064a(C24096b c24096b, Drawable drawable, int i, int i2) {
            AppMethodBeat.m2504i(112716);
            if (drawable != null) {
                c24096b.gAf = drawable;
                c24096b.zRb = i;
                c24096b.dividerHeight = i2;
                drawable.setBounds(0, 0, i, i2);
            }
            AppMethodBeat.m2505o(112716);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.listview.AnimatedExpandableListView$c */
    static class C24097c extends Animation {
        private View view;
        private int zRc;
        private int zRd;
        private C24098d zRe;

        /* synthetic */ C24097c(View view, int i, int i2, C24098d c24098d, byte b) {
            this(view, i, i2, c24098d);
        }

        private C24097c(View view, int i, int i2, C24098d c24098d) {
            AppMethodBeat.m2504i(112717);
            this.zRc = i;
            this.zRd = i2 - i;
            this.view = view;
            this.zRe = c24098d;
            this.view.getLayoutParams().height = i;
            this.view.requestLayout();
            AppMethodBeat.m2505o(112717);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.m2504i(112718);
            super.applyTransformation(f, transformation);
            int i;
            if (f < 1.0f) {
                i = this.zRc + ((int) (((float) this.zRd) * f));
                this.view.getLayoutParams().height = i;
                this.zRe.zRh = i;
                this.view.requestLayout();
                AppMethodBeat.m2505o(112718);
                return;
            }
            i = this.zRc + this.zRd;
            this.view.getLayoutParams().height = i;
            this.zRe.zRh = i;
            this.view.requestLayout();
            AppMethodBeat.m2505o(112718);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.listview.AnimatedExpandableListView$d */
    static class C24098d {
        boolean mSe;
        boolean zRf;
        int zRg;
        int zRh;

        private C24098d() {
            this.mSe = false;
            this.zRf = false;
            this.zRh = -1;
        }

        /* synthetic */ C24098d(byte b) {
            this();
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m37061a(AnimatedExpandableListView animatedExpandableListView) {
        AppMethodBeat.m2504i(112722);
        int animationDuration = animatedExpandableListView.getAnimationDuration();
        AppMethodBeat.m2505o(112722);
        return animationDuration;
    }

    static {
        AppMethodBeat.m2504i(112723);
        AppMethodBeat.m2505o(112723);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        AppMethodBeat.m2504i(112719);
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof C16004a) {
            this.zQT = (C16004a) expandableListAdapter;
            this.zQT.zQV = this;
            AppMethodBeat.m2505o(112719);
            return;
        }
        ClassCastException classCastException = new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
        AppMethodBeat.m2505o(112719);
        throw classCastException;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: Qi */
    public final boolean mo39900Qi(int i) {
        boolean expandGroup;
        AppMethodBeat.m2504i(112720);
        int flatListPosition = getFlatListPosition(AnimatedExpandableListView.getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < getChildCount() && getChildAt(flatListPosition).getBottom() >= getBottom()) {
                this.zQT.mo28312Ql(i);
                expandGroup = expandGroup(i);
                AppMethodBeat.m2505o(112720);
                return expandGroup;
            }
        }
        C16004a.m24307a(this.zQT, i);
        expandGroup = expandGroup(i);
        AppMethodBeat.m2505o(112720);
        return expandGroup;
    }

    /* renamed from: Qj */
    public final boolean mo39901Qj(int i) {
        boolean collapseGroup;
        AppMethodBeat.m2504i(112721);
        int flatListPosition = getFlatListPosition(AnimatedExpandableListView.getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < 0 || flatListPosition >= getChildCount()) {
                collapseGroup = collapseGroup(i);
                AppMethodBeat.m2505o(112721);
                return collapseGroup;
            } else if (getChildAt(flatListPosition).getBottom() >= getBottom()) {
                collapseGroup = collapseGroup(i);
                AppMethodBeat.m2505o(112721);
                return collapseGroup;
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        flatListPosition = AnimatedExpandableListView.getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = AnimatedExpandableListView.getPackedPositionGroup(expandableListPosition);
        if (flatListPosition == -1 || packedPositionGroup != i) {
            flatListPosition = 0;
        }
        C16004a.m24308a(this.zQT, i, flatListPosition);
        this.zQT.notifyDataSetChanged();
        collapseGroup = isGroupExpanded(i);
        AppMethodBeat.m2505o(112721);
        return collapseGroup;
    }

    private int getAnimationDuration() {
        return 150;
    }
}
