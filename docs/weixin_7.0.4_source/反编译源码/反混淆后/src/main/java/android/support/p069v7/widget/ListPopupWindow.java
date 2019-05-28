package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C0535n;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.menu.C0632s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.ListPopupWindow */
public class ListPopupWindow implements C0632s {
    private static Method amh;
    private static Method ami;
    private static Method amj;
    /* renamed from: Ei */
    private ListAdapter f1941Ei;
    public int aaD;
    public Rect ach;
    private boolean afP;
    public int age;
    private OnItemSelectedListener amA;
    final C0664e amB;
    private final C0663d amC;
    private final C0662c amD;
    private final C0660a amE;
    private Runnable amF;
    public boolean amG;
    public PopupWindow amH;
    public C0681ab amk;
    private int aml;
    public int amm;
    private int amn;
    private int amo;
    private boolean amp;
    private boolean amq;
    private boolean amr;
    private boolean ams;
    private boolean amt;
    int amu;
    private View amv;
    int amw;
    public View amx;
    private Drawable amy;
    public OnItemClickListener amz;
    private Context mContext;
    final Handler mHandler;
    private DataSetObserver mObserver;
    private final Rect mTempRect;

    /* renamed from: android.support.v7.widget.ListPopupWindow$1 */
    class C06581 implements Runnable {
        C06581() {
        }

        public final void run() {
            View view = ListPopupWindow.this.amx;
            if (view != null && view.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$2 */
    class C06592 implements OnItemSelectedListener {
        C06592() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                C0681ab c0681ab = ListPopupWindow.this.amk;
                if (c0681ab != null) {
                    c0681ab.setListSelectionHidden(false);
                }
            }
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$a */
    class C0660a implements Runnable {
        C0660a() {
        }

        public final void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$b */
    class C0661b extends DataSetObserver {
        C0661b() {
        }

        public final void onChanged() {
            if (ListPopupWindow.this.amH.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$c */
    class C0662c implements OnScrollListener {
        C0662c() {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.amH.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.amB);
                ListPopupWindow.this.amB.run();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$d */
    class C0663d implements OnTouchListener {
        C0663d() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.amH != null && ListPopupWindow.this.amH.isShowing() && x >= 0 && x < ListPopupWindow.this.amH.getWidth() && y >= 0 && y < ListPopupWindow.this.amH.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.amB, 250);
            } else if (action == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.amB);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$e */
    class C0664e implements Runnable {
        C0664e() {
        }

        public final void run() {
            if (ListPopupWindow.this.amk != null && C0477s.m930av(ListPopupWindow.this.amk) && ListPopupWindow.this.amk.getCount() > ListPopupWindow.this.amk.getChildCount() && ListPopupWindow.this.amk.getChildCount() <= ListPopupWindow.this.amu) {
                ListPopupWindow.this.amH.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        try {
            amh = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            ami = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
        try {
            amj = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, C25738R.attr.f5672fd);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5672fd);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.aml = -2;
        this.age = -2;
        this.amo = 1002;
        this.amq = true;
        this.aaD = 0;
        this.ams = false;
        this.amt = false;
        this.amu = BaseClientBuilder.API_PRIORITY_OTHER;
        this.amw = 0;
        this.amB = new C0664e();
        this.amC = new C0663d();
        this.amD = new C0662c();
        this.amE = new C0660a();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.ListPopupWindow, i, i2);
        this.amm = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        this.amn = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        if (this.amn != 0) {
            this.amp = true;
        }
        obtainStyledAttributes.recycle();
        this.amH = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.amH.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new C0661b();
        } else if (this.f1941Ei != null) {
            this.f1941Ei.unregisterDataSetObserver(this.mObserver);
        }
        this.f1941Ei = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.amk != null) {
            this.amk.setAdapter(this.f1941Ei);
        }
    }

    public final void setModal(boolean z) {
        this.amG = z;
        this.amH.setFocusable(z);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.amH.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i) {
        this.amH.setAnimationStyle(i);
    }

    public final int getVerticalOffset() {
        if (this.amp) {
            return this.amn;
        }
        return 0;
    }

    public final void setVerticalOffset(int i) {
        this.amn = i;
        this.amp = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.amH.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.age = (this.mTempRect.left + this.mTempRect.right) + i;
            return;
        }
        this.age = i;
    }

    public final void setHeight(int i) {
        if (i >= 0 || -2 == i || -1 == i) {
            this.aml = i;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void show() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int makeMeasureSpec;
        boolean z2 = true;
        LayoutParams layoutParams;
        if (this.amk == null) {
            Context context = this.mContext;
            this.amF = new C06581();
            this.amk = mo14388g(context, !this.amG);
            if (this.amy != null) {
                this.amk.setSelector(this.amy);
            }
            this.amk.setAdapter(this.f1941Ei);
            this.amk.setOnItemClickListener(this.amz);
            this.amk.setFocusable(true);
            this.amk.setFocusableInTouchMode(true);
            this.amk.setOnItemSelectedListener(new C06592());
            this.amk.setOnScrollListener(this.amD);
            if (this.amA != null) {
                this.amk.setOnItemSelectedListener(this.amA);
            }
            View view = this.amk;
            View view2 = this.amv;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.amw) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.amw);
                        break;
                }
                if (this.age >= 0) {
                    i = this.age;
                    i2 = C8415j.INVALID_ID;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                i = (view2.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.amH.setContentView(view);
            i3 = i;
        } else {
            this.amH.getContentView();
            View view3 = this.amv;
            if (view3 != null) {
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i3 = (view3.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.amH.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            i2 = this.mTempRect.top + this.mTempRect.bottom;
            if (this.amp) {
                i4 = i2;
            } else {
                this.amn = -this.mTempRect.top;
                i4 = i2;
            }
        } else {
            this.mTempRect.setEmpty();
            i4 = 0;
        }
        if (this.amH.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        i = getMaxAvailableHeight(this.amx, this.amn, z);
        if (this.ams || this.aml == -1) {
            i2 = i + i4;
        } else {
            switch (this.age) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), C8415j.INVALID_ID);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), ErrorDialogData.SUPPRESSED);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.age, ErrorDialogData.SUPPRESSED);
                    break;
            }
            i2 = this.amk.mo1932d(makeMeasureSpec, 0, -1, i - i3, -1);
            if (i2 > 0) {
                i3 += (this.amk.getPaddingTop() + this.amk.getPaddingBottom()) + i4;
            }
            i2 += i3;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        C0535n.m1157a(this.amH, this.amo);
        PopupWindow popupWindow;
        if (!this.amH.isShowing()) {
            if (this.age == -1) {
                makeMeasureSpec = -1;
            } else if (this.age == -2) {
                makeMeasureSpec = this.amx.getWidth();
            } else {
                makeMeasureSpec = this.age;
            }
            if (this.aml == -1) {
                i2 = -1;
            } else if (this.aml != -2) {
                i2 = this.aml;
            }
            this.amH.setWidth(makeMeasureSpec);
            this.amH.setHeight(i2);
            if (amh != null) {
                try {
                    amh.invoke(this.amH, new Object[]{Boolean.TRUE});
                } catch (Exception e) {
                }
            }
            popupWindow = this.amH;
            if (this.amt || this.ams) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.amH.setTouchInterceptor(this.amC);
            if (this.amr) {
                C0535n.m1159a(this.amH, this.afP);
            }
            if (amj != null) {
                try {
                    amj.invoke(this.amH, new Object[]{this.ach});
                } catch (Exception e2) {
                }
            }
            C0535n.m1158a(this.amH, this.amx, this.amm, this.amn, this.aaD);
            this.amk.setSelection(-1);
            if (!this.amG || this.amk.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.amG) {
                this.mHandler.post(this.amE);
            }
        } else if (C0477s.m930av(this.amx)) {
            int i5;
            if (this.age == -1) {
                i = -1;
            } else if (this.age == -2) {
                i = this.amx.getWidth();
            } else {
                i = this.age;
            }
            if (this.aml == -1) {
                if (isInputMethodNotNeeded) {
                    makeMeasureSpec = i2;
                } else {
                    makeMeasureSpec = -1;
                }
                PopupWindow popupWindow2;
                if (isInputMethodNotNeeded) {
                    popupWindow2 = this.amH;
                    if (this.age == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow2.setWidth(i2);
                    this.amH.setHeight(0);
                    i5 = makeMeasureSpec;
                } else {
                    popupWindow2 = this.amH;
                    if (this.age == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow2.setWidth(i2);
                    this.amH.setHeight(-1);
                    i5 = makeMeasureSpec;
                }
            } else if (this.aml != -2) {
                i5 = this.aml;
            } else {
                i5 = i2;
            }
            popupWindow = this.amH;
            if (this.amt || this.ams) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.amH;
            View view4 = this.amx;
            int i6 = this.amm;
            int i7 = this.amn;
            if (i < 0) {
                i = -1;
            }
            if (i5 < 0) {
                i5 = -1;
            }
            popupWindow.update(view4, i6, i7, i, i5);
        }
    }

    public final void dismiss() {
        this.amH.dismiss();
        m10191iY();
        this.amH.setContentView(null);
        this.amk = null;
        this.mHandler.removeCallbacks(this.amB);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.amH.setOnDismissListener(onDismissListener);
    }

    /* renamed from: iY */
    private void m10191iY() {
        if (this.amv != null) {
            ViewParent parent = this.amv.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.amv);
            }
        }
    }

    /* renamed from: iZ */
    public final void mo14390iZ() {
        this.amH.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        C0681ab c0681ab = this.amk;
        if (c0681ab != null) {
            c0681ab.setListSelectionHidden(true);
            c0681ab.requestLayout();
        }
    }

    public final boolean isShowing() {
        return this.amH.isShowing();
    }

    public final boolean isInputMethodNotNeeded() {
        return this.amH.getInputMethodMode() == 2;
    }

    public final ListView getListView() {
        return this.amk;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public C0681ab mo14388g(Context context, boolean z) {
        return new C0681ab(context, z);
    }

    /* renamed from: ja */
    public final void mo14392ja() {
        this.amr = true;
        this.afP = true;
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (ami != null) {
            try {
                return ((Integer) ami.invoke(this.amH, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
            }
        }
        return this.amH.getMaxAvailableHeight(view, i);
    }
}
