package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.support.v7.view.d;
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
import com.tencent.mm.R;

public class AppCompatSpinner extends Spinner implements r {
    private static final int[] aga = new int[]{16843505};
    private ae aad;
    private final Context acv;
    private final g afh;
    private SpinnerAdapter agb;
    private final boolean agc;
    private b agd;
    private int age;
    private final Rect mTempRect;

    static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter agh;
        private ListAdapter agi;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
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

    class b extends ListPopupWindow {
        ListAdapter Ei;
        CharSequence agj;
        final Rect agk = new Rect();

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.amx = AppCompatSpinner.this;
            setModal(true);
            this.amw = 0;
            this.amz = new OnItemClickListener(AppCompatSpinner.this) {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner.this.setSelection(i);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i, b.this.Ei.getItemId(i));
                    }
                    b.this.dismiss();
                }
            };
        }

        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.Ei = listAdapter;
        }

        /* Access modifiers changed, original: final */
        public final void hH() {
            int i;
            int i2;
            Drawable background = this.amH.getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                if (bk.bW(AppCompatSpinner.this)) {
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
                int a = AppCompatSpinner.this.a((SpinnerAdapter) this.Ei, this.amH.getBackground());
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
            if (bk.bW(AppCompatSpinner.this)) {
                i = ((width - paddingRight) - this.age) + i2;
            } else {
                i = i2 + paddingLeft;
            }
            this.amm = i;
        }

        public final void show() {
            boolean isShowing = this.amH.isShowing();
            hH();
            iZ();
            super.show();
            this.amk.setChoiceMode(1);
            int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
            ab abVar = this.amk;
            if (this.amH.isShowing() && abVar != null) {
                abVar.setListSelectionHidden(false);
                abVar.setSelection(selectedItemPosition);
                if (abVar.getChoiceMode() != 0) {
                    abVar.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final AnonymousClass2 anonymousClass2 = new OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            Object obj;
                            b bVar = b.this;
                            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                            if (s.av(appCompatSpinner) && appCompatSpinner.getGlobalVisibleRect(bVar.agk)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                b.this.dismiss();
                                return;
                            }
                            b.this.hH();
                            super.show();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    setOnDismissListener(new OnDismissListener() {
                        public final void onDismiss() {
                            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gd);
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
        Context dVar;
        AppCompatSpinner appCompatSpinner;
        CharSequence[] textArray;
        Throwable th;
        TypedArray typedArray;
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        bc a = bc.a(context, attributeSet, android.support.v7.a.a.a.Spinner, i, 0);
        this.afh = new g(this);
        int resourceId = a.getResourceId(4, 0);
        if (resourceId != 0) {
            dVar = new d(context, resourceId);
            appCompatSpinner = this;
        } else if (VERSION.SDK_INT < 23) {
            dVar = context;
            appCompatSpinner = this;
        } else {
            dVar = null;
            appCompatSpinner = this;
        }
        appCompatSpinner.acv = dVar;
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
                    this.afh.a(attributeSet, i);
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
                this.afh.a(attributeSet, i);
            } catch (Throwable th3) {
                th = th3;
                typedArray = null;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
            if (i2 == 1) {
                final b bVar = new b(this.acv, attributeSet, i);
                bc a2 = bc.a(this.acv, attributeSet, android.support.v7.a.a.a.Spinner, i, 0);
                this.age = a2.getLayoutDimension(3, -2);
                bVar.setBackgroundDrawable(a2.getDrawable(1));
                bVar.agj = a.getString(2);
                a2.atG.recycle();
                this.agd = bVar;
                this.aad = new ae(this) {
                    public final android.support.v7.view.menu.s gm() {
                        return bVar;
                    }

                    public final boolean gn() {
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
            arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a.atG.recycle();
        this.agc = true;
        if (this.agb != null) {
            setAdapter(this.agb);
            this.agb = null;
        }
        this.afh.a(attributeSet, i);
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
        setPopupBackgroundDrawable(android.support.v7.c.a.b.g(getPopupContext(), i));
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
                this.agd.setAdapter(new a(spinnerAdapter, (this.acv == null ? getContext() : this.acv).getTheme()));
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
        if (this.agd != null && MeasureSpec.getMode(i) == j.INVALID_ID) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
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
            this.afh.bD(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.afh != null) {
            this.afh.hz();
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
            this.afh.hA();
        }
    }

    /* Access modifiers changed, original: final */
    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
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
