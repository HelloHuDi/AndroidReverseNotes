package com.tencent.mm.ui.widget.listview;

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

public class AnimatedExpandableListView extends ExpandableListView {
    private static final String TAG = a.class.getSimpleName();
    private a zQT;

    public static abstract class a extends BaseExpandableListAdapter {
        private SparseArray<d> zQU = new SparseArray();
        private AnimatedExpandableListView zQV;

        public abstract int Ec(int i);

        public abstract View d(int i, int i2, View view);

        private d Qk(int i) {
            d dVar = (d) this.zQU.get(i);
            if (dVar != null) {
                return dVar;
            }
            dVar = new d();
            this.zQU.put(i, dVar);
            return dVar;
        }

        public final void Ql(int i) {
            Qk(i).zRh = -1;
        }

        public final int getChildType(int i, int i2) {
            if (Qk(i).mSe) {
                return 0;
            }
            return 1;
        }

        public final int getChildTypeCount() {
            return 2;
        }

        public final View getChildView(final int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            d Qk = Qk(i);
            if (!Qk.mSe) {
                return d(i, i2, view);
            }
            View view2;
            if (view instanceof b) {
                view2 = view;
            } else {
                view2 = new b(viewGroup.getContext(), (byte) 0);
                view2.setLayoutParams(new LayoutParams(-1, 0));
            }
            if (i2 < Qk.zRg) {
                view2.getLayoutParams().height = 0;
                return view2;
            }
            int i3;
            final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            final b bVar = (b) view2;
            bVar.zRa.clear();
            b.a(bVar, expandableListView.getDivider(), viewGroup.getMeasuredWidth(), expandableListView.getDividerHeight());
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), ErrorDialogData.SUPPRESSED);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int i4 = 0;
            int height = viewGroup.getHeight();
            int Ec = Ec(i);
            for (i3 = Qk.zRg; i3 < Ec; i3++) {
                View d = d(i, i3, null);
                d.measure(makeMeasureSpec, makeMeasureSpec2);
                i4 += d.getMeasuredHeight();
                if (i4 >= height) {
                    bVar.fp(d);
                    i4 += ((Ec - i3) - 1) * (i4 / (i3 + 1));
                    break;
                }
                bVar.fp(d);
            }
            Object tag = bVar.getTag();
            if (tag == null) {
                i3 = 0;
            } else {
                i3 = ((Integer) tag).intValue();
            }
            c cVar;
            if (Qk.zRf && r2 != 1) {
                cVar = new c(bVar, 0, i4, Qk, (byte) 0);
                cVar.setDuration((long) AnimatedExpandableListView.a(this.zQV));
                cVar.setAnimationListener(new AnimationListener() {
                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(112710);
                        a.this.Qk(i).mSe = false;
                        a.this.notifyDataSetChanged();
                        bVar.setTag(Integer.valueOf(0));
                        AppMethodBeat.o(112710);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(1));
                return view2;
            } else if (Qk.zRf || r2 == 2) {
                return view2;
            } else {
                if (Qk.zRh == -1) {
                    Qk.zRh = i4;
                }
                cVar = new c(bVar, Qk.zRh, 0, Qk, (byte) 0);
                cVar.setDuration((long) AnimatedExpandableListView.a(this.zQV));
                Ec = i;
                final d dVar = Qk;
                final b bVar2 = bVar;
                cVar.setAnimationListener(new AnimationListener() {
                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(112711);
                        a.this.Qk(Ec).mSe = false;
                        expandableListView.collapseGroup(Ec);
                        a.this.notifyDataSetChanged();
                        dVar.zRh = -1;
                        bVar2.setTag(Integer.valueOf(0));
                        AppMethodBeat.o(112711);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(2));
                return view2;
            }
        }

        public final int getChildrenCount(int i) {
            d Qk = Qk(i);
            if (Qk.mSe) {
                return Qk.zRg + 1;
            }
            return Ec(i);
        }

        static /* synthetic */ void a(a aVar, int i, int i2) {
            d Qk = aVar.Qk(i);
            Qk.mSe = true;
            Qk.zRg = i2;
            Qk.zRf = false;
        }
    }

    static class b extends View {
        private int dividerHeight;
        private Drawable gAf;
        List<View> zRa;
        private int zRb;

        /* synthetic */ b(Context context, byte b) {
            this(context);
        }

        private b(Context context) {
            super(context);
            AppMethodBeat.i(112712);
            this.zRa = new ArrayList();
            AppMethodBeat.o(112712);
        }

        public final void fp(View view) {
            AppMethodBeat.i(112713);
            view.layout(0, 0, getWidth(), getHeight());
            this.zRa.add(view);
            AppMethodBeat.o(112713);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            AppMethodBeat.i(112714);
            super.onLayout(z, i, i2, i3, i4);
            int size = this.zRa.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((View) this.zRa.get(i5)).layout(i, i2, i3, i4);
            }
            AppMethodBeat.o(112714);
        }

        public final void dispatchDraw(Canvas canvas) {
            AppMethodBeat.i(112715);
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
            AppMethodBeat.o(112715);
        }

        static /* synthetic */ void a(b bVar, Drawable drawable, int i, int i2) {
            AppMethodBeat.i(112716);
            if (drawable != null) {
                bVar.gAf = drawable;
                bVar.zRb = i;
                bVar.dividerHeight = i2;
                drawable.setBounds(0, 0, i, i2);
            }
            AppMethodBeat.o(112716);
        }
    }

    static class c extends Animation {
        private View view;
        private int zRc;
        private int zRd;
        private d zRe;

        /* synthetic */ c(View view, int i, int i2, d dVar, byte b) {
            this(view, i, i2, dVar);
        }

        private c(View view, int i, int i2, d dVar) {
            AppMethodBeat.i(112717);
            this.zRc = i;
            this.zRd = i2 - i;
            this.view = view;
            this.zRe = dVar;
            this.view.getLayoutParams().height = i;
            this.view.requestLayout();
            AppMethodBeat.o(112717);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.i(112718);
            super.applyTransformation(f, transformation);
            int i;
            if (f < 1.0f) {
                i = this.zRc + ((int) (((float) this.zRd) * f));
                this.view.getLayoutParams().height = i;
                this.zRe.zRh = i;
                this.view.requestLayout();
                AppMethodBeat.o(112718);
                return;
            }
            i = this.zRc + this.zRd;
            this.view.getLayoutParams().height = i;
            this.zRe.zRh = i;
            this.view.requestLayout();
            AppMethodBeat.o(112718);
        }
    }

    static class d {
        boolean mSe;
        boolean zRf;
        int zRg;
        int zRh;

        private d() {
            this.mSe = false;
            this.zRf = false;
            this.zRh = -1;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    static /* synthetic */ int a(AnimatedExpandableListView animatedExpandableListView) {
        AppMethodBeat.i(112722);
        int animationDuration = animatedExpandableListView.getAnimationDuration();
        AppMethodBeat.o(112722);
        return animationDuration;
    }

    static {
        AppMethodBeat.i(112723);
        AppMethodBeat.o(112723);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        AppMethodBeat.i(112719);
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof a) {
            this.zQT = (a) expandableListAdapter;
            this.zQT.zQV = this;
            AppMethodBeat.o(112719);
            return;
        }
        ClassCastException classCastException = new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
        AppMethodBeat.o(112719);
        throw classCastException;
    }

    @SuppressLint({"NewApi"})
    public final boolean Qi(int i) {
        boolean expandGroup;
        AppMethodBeat.i(112720);
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < getChildCount() && getChildAt(flatListPosition).getBottom() >= getBottom()) {
                this.zQT.Ql(i);
                expandGroup = expandGroup(i);
                AppMethodBeat.o(112720);
                return expandGroup;
            }
        }
        a.a(this.zQT, i);
        expandGroup = expandGroup(i);
        AppMethodBeat.o(112720);
        return expandGroup;
    }

    public final boolean Qj(int i) {
        boolean collapseGroup;
        AppMethodBeat.i(112721);
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < 0 || flatListPosition >= getChildCount()) {
                collapseGroup = collapseGroup(i);
                AppMethodBeat.o(112721);
                return collapseGroup;
            } else if (getChildAt(flatListPosition).getBottom() >= getBottom()) {
                collapseGroup = collapseGroup(i);
                AppMethodBeat.o(112721);
                return collapseGroup;
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        flatListPosition = getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = getPackedPositionGroup(expandableListPosition);
        if (flatListPosition == -1 || packedPositionGroup != i) {
            flatListPosition = 0;
        }
        a.a(this.zQT, i, flatListPosition);
        this.zQT.notifyDataSetChanged();
        collapseGroup = isGroupExpanded(i);
        AppMethodBeat.o(112721);
        return collapseGroup;
    }

    private int getAnimationDuration() {
        return 150;
    }
}
