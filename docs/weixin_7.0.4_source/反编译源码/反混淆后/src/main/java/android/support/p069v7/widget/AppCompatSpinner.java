package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0474r;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.C0606d;
import android.support.p069v7.view.menu.C0632s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.AppCompatSpinner */
public class AppCompatSpinner extends Spinner implements C0474r {
    private static final int[] aga = new int[]{16843505};
    private C0687ae aad;
    private final Context acv;
    private final C0713g afh;
    private SpinnerAdapter agb;
    private final boolean agc;
    private C6253b agd;
    private int age;
    private final Rect mTempRect;

    /* renamed from: android.support.v7.widget.AppCompatSpinner$a */
    static class C0645a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter agh;
        private ListAdapter agi;

        public C0645a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.agh = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.agi = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            return this.agh == null ? 0 : this.agh.getCount();
        }

        public final Object getItem(int i) {
            return this.agh == null ? null : this.agh.getItem(i);
        }

        public final long getItemId(int i) {
            return this.agh == null ? -1 : this.agh.getItemId(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.agh == null) {
                return null;
            }
            return this.agh.getDropDownView(i, view, viewGroup);
        }

        public final boolean hasStableIds() {
            return this.agh != null && this.agh.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.agh != null) {
                this.agh.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.agh != null) {
                this.agh.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.agi;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.agi;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* renamed from: android.support.v7.widget.AppCompatSpinner$b */
    class C6253b extends ListPopupWindow {
        /* renamed from: Ei */
        ListAdapter f1940Ei;
        CharSequence agj;
        final Rect agk = new Rect();

        /* renamed from: android.support.v7.widget.AppCompatSpinner$b$2 */
        class C06472 implements OnGlobalLayoutListener {
            C06472() {
            }

            public final void onGlobalLayout() {
                Object obj;
                C6253b c6253b = C6253b.this;
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                if (C0477s.m930av(appCompatSpinner) && appCompatSpinner.getGlobalVisibleRect(c6253b.agk)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    C6253b.this.dismiss();
                    return;
                }
                C6253b.this.mo14369hH();
                super.show();
            }
        }

        public C6253b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.amx = AppCompatSpinner.this;
            setModal(true);
            this.amw = 0;
            this.amz = new OnItemClickListener(AppCompatSpinner.this) {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner.this.setSelection(i);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i, C6253b.this.f1940Ei.getItemId(i));
                    }
                    C6253b.this.dismiss();
                }
            };
        }

        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f1940Ei = listAdapter;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: hH */
        public final void mo14369hH() {
            int i;
            int i2;
            Drawable background = this.amH.getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                if (C0709bk.m1576bW(AppCompatSpinner.this)) {
                    i = AppCompatSpinner.this.mTempRect.right;
                } else {
                    i = -AppCompatSpinner.this.mTempRect.left;
                }
                i2 = i;
            } else {
                Rect b = AppCompatSpinner.this.mTempRect;
                AppCompatSpinner.this.mTempRect.right = 0;
                b.left = 0;
                i2 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.age == -2) {
                int a = AppCompatSpinner.this.mo14347a((SpinnerAdapter) this.f1940Ei, this.amH.getBackground());
                i = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left) - AppCompatSpinner.this.mTempRect.right;
                if (a <= i) {
                    i = a;
                }
                setContentWidth(Math.max(i, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.age == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner.this.age);
            }
            if (C0709bk.m1576bW(AppCompatSpinner.this)) {
                i = ((width - paddingRight) - this.age) + i2;
            } else {
                i = i2 + paddingLeft;
            }
            this.amm = i;
        }

        public final void show() {
            boolean isShowing = this.amH.isShowing();
            mo14369hH();
            mo14390iZ();
            super.show();
            this.amk.setChoiceMode(1);
            int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
            C0681ab c0681ab = this.amk;
            if (this.amH.isShowing() && c0681ab != null) {
                c0681ab.setListSelectionHidden(false);
                c0681ab.setSelection(selectedItemPosition);
                if (c0681ab.getChoiceMode() != 0) {
                    c0681ab.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final C06472 c06472 = new C06472();
                    viewTreeObserver.addOnGlobalLayoutListener(c06472);
                    setOnDismissListener(new OnDismissListener() {
                        public final void onDismiss() {
                            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c06472);
                            }
                        }
                    });
                }
            }
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5709gd);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        Context c0606d;
        AppCompatSpinner appCompatSpinner;
        CharSequence[] textArray;
        Throwable th;
        TypedArray typedArray;
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        C0699bc a = C0699bc.m1555a(context, attributeSet, C0554a.Spinner, i, 0);
        this.afh = new C0713g(this);
        int resourceId = a.getResourceId(4, 0);
        if (resourceId != 0) {
            c0606d = new C0606d(context, resourceId);
            appCompatSpinner = this;
        } else if (VERSION.SDK_INT < 23) {
            c0606d = context;
            appCompatSpinner = this;
        } else {
            c0606d = null;
            appCompatSpinner = this;
        }
        appCompatSpinner.acv = c0606d;
        if (this.acv != null) {
            TypedArray obtainStyledAttributes;
            try {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aga, i, 0);
                try {
                    if (obtainStyledAttributes.hasValue(0)) {
                        i2 = obtainStyledAttributes.getInt(0, 0);
                    }
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                } catch (Exception e) {
                    if (obtainStyledAttributes != null) {
                    }
                    if (i2 == 1) {
                    }
                    textArray = a.atG.getTextArray(0);
                    if (textArray != null) {
                    }
                    a.atG.recycle();
                    this.agc = true;
                    if (this.agb != null) {
                    }
                    this.afh.mo2068a(attributeSet, i);
                } catch (Throwable th2) {
                    th = th2;
                    typedArray = obtainStyledAttributes;
                    if (typedArray != null) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                obtainStyledAttributes = null;
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
                if (i2 == 1) {
                }
                textArray = a.atG.getTextArray(0);
                if (textArray != null) {
                }
                a.atG.recycle();
                this.agc = true;
                if (this.agb != null) {
                }
                this.afh.mo2068a(attributeSet, i);
            } catch (Throwable th3) {
                th = th3;
                typedArray = null;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
            if (i2 == 1) {
                final C6253b c6253b = new C6253b(this.acv, attributeSet, i);
                C0699bc a2 = C0699bc.m1555a(this.acv, attributeSet, C0554a.Spinner, i, 0);
                this.age = a2.getLayoutDimension(3, -2);
                c6253b.setBackgroundDrawable(a2.getDrawable(1));
                c6253b.agj = a.getString(2);
                a2.atG.recycle();
                this.agd = c6253b;
                this.aad = new C0687ae(this) {
                    /* renamed from: gm */
                    public final C0632s mo1948gm() {
                        return c6253b;
                    }

                    /* renamed from: gn */
                    public final boolean mo1949gn() {
                        if (!AppCompatSpinner.this.agd.amH.isShowing()) {
                            AppCompatSpinner.this.agd.show();
                        }
                        return true;
                    }
                };
            }
        }
        textArray = a.atG.getTextArray(0);
        if (textArray != null) {
            SpinnerAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(2130970909);
            setAdapter(arrayAdapter);
        }
        a.atG.recycle();
        this.agc = true;
        if (this.agb != null) {
            setAdapter(this.agb);
            this.agb = null;
        }
        this.afh.mo2068a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.agd != null) {
            return this.acv;
        }
        if (VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.agd != null) {
            this.agd.setBackgroundDrawable(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0589b.m1275g(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.agd != null) {
            return this.agd.amH.getBackground();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.agd != null) {
            this.agd.setVerticalOffset(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.agd != null) {
            return this.agd.getVerticalOffset();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.agd != null) {
            this.agd.amm = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.agd != null) {
            return this.agd.amm;
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.agd != null) {
            this.age = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.agd != null) {
            return this.age;
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.agc) {
            super.setAdapter(spinnerAdapter);
            if (this.agd != null) {
                this.agd.setAdapter(new C0645a(spinnerAdapter, (this.acv == null ? getContext() : this.acv).getTheme()));
                return;
            }
            return;
        }
        this.agb = spinnerAdapter;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.agd != null && this.agd.amH.isShowing()) {
            this.agd.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aad == null || !this.aad.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.agd != null && MeasureSpec.getMode(i) == C8415j.INVALID_ID) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), mo14347a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.agd == null) {
            return super.performClick();
        }
        if (!this.agd.amH.isShowing()) {
            this.agd.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.agd != null) {
            this.agd.agj = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        if (this.agd != null) {
            return this.agd.agj;
        }
        return super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.afh != null) {
            this.afh.mo2069bD(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.afh != null) {
            this.afh.mo2073hz();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.afh != null) {
            this.afh.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.afh != null ? this.afh.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.afh != null) {
            this.afh.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.afh != null ? this.afh.getSupportBackgroundTintMode() : null;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afh != null) {
            this.afh.mo2072hA();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo14347a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        max = 0;
        View view = null;
        int i = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view = null;
            } else {
                itemViewType = max;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.mTempRect);
        return (this.mTempRect.left + this.mTempRect.right) + i;
    }
}
