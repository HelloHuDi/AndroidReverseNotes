package com.tencent.p177mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase */
public class AutoFillListPopupWindowBase {
    /* renamed from: Ei */
    ListAdapter f1259Ei;
    int age;
    private OnItemSelectedListener amA;
    private Runnable amF;
    boolean amG;
    PopupWindow amH;
    int aml;
    int amm;
    int amn;
    boolean amp;
    boolean ams;
    boolean amt;
    int amu;
    private View amv;
    private int amw;
    View amx;
    private Drawable amy;
    private OnItemClickListener amz;
    C2564a jhV;
    private final C2569f jhW;
    private final C2571e jhX;
    private final C2570d jhY;
    private final C2566b jhZ;
    private boolean jia;
    private Context mContext;
    private C7306ak mHandler;
    DataSetObserver mObserver;
    private Rect mTempRect;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$a */
    static class C2564a extends ListView {
        private boolean aid;
        private boolean aie;

        public C2564a(Context context, boolean z) {
            super(context, null, C25738R.attr.f5671fc);
            AppMethodBeat.m2504i(123909);
            this.aie = z;
            setCacheColorHint(0);
            AppMethodBeat.m2505o(123909);
        }

        public final boolean isInTouchMode() {
            AppMethodBeat.m2504i(123910);
            if ((this.aie && this.aid) || super.isInTouchMode()) {
                AppMethodBeat.m2505o(123910);
                return true;
            }
            AppMethodBeat.m2505o(123910);
            return false;
        }

        public final boolean hasWindowFocus() {
            AppMethodBeat.m2504i(123911);
            if (this.aie || super.hasWindowFocus()) {
                AppMethodBeat.m2505o(123911);
                return true;
            }
            AppMethodBeat.m2505o(123911);
            return false;
        }

        public final boolean isFocused() {
            AppMethodBeat.m2504i(123912);
            if (this.aie || super.isFocused()) {
                AppMethodBeat.m2505o(123912);
                return true;
            }
            AppMethodBeat.m2505o(123912);
            return false;
        }

        public final boolean hasFocus() {
            AppMethodBeat.m2504i(123913);
            if (this.aie || super.hasFocus()) {
                AppMethodBeat.m2505o(123913);
                return true;
            }
            AppMethodBeat.m2505o(123913);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dt */
        public final int mo6544dt(int i, int i2) {
            AppMethodBeat.m2504i(123914);
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            getListPaddingLeft();
            getListPaddingRight();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                i2 = listPaddingTop + listPaddingBottom;
                AppMethodBeat.m2505o(123914);
                return i2;
            }
            listPaddingBottom += listPaddingTop;
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i3 = 0;
            View view = null;
            for (int i4 = 0; i4 < count; i4++) {
                listPaddingTop = adapter.getItemViewType(i4);
                if (listPaddingTop != i3) {
                    i3 = listPaddingTop;
                    view = null;
                }
                view = adapter.getView(i4, view, this);
                listPaddingTop = view.getLayoutParams().height;
                if (listPaddingTop > 0) {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(listPaddingTop, ErrorDialogData.SUPPRESSED);
                } else {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(i, listPaddingTop);
                if (i4 > 0) {
                    listPaddingTop = listPaddingBottom + dividerHeight;
                } else {
                    listPaddingTop = listPaddingBottom;
                }
                listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
                if (listPaddingBottom >= i2) {
                    AppMethodBeat.m2505o(123914);
                    return i2;
                }
            }
            AppMethodBeat.m2505o(123914);
            return listPaddingBottom;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$c */
    class C2565c extends DataSetObserver {
        private C2565c() {
        }

        /* synthetic */ C2565c(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(123916);
            if (AutoFillListPopupWindowBase.this.amH.isShowing()) {
                AutoFillListPopupWindowBase.this.show();
            }
            AppMethodBeat.m2505o(123916);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(123917);
            AutoFillListPopupWindowBase.this.dismiss();
            AppMethodBeat.m2505o(123917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$b */
    class C2566b implements Runnable {
        private C2566b() {
        }

        /* synthetic */ C2566b(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(123915);
            AutoFillListPopupWindowBase.this.clearListSelection();
            AppMethodBeat.m2505o(123915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$1 */
    class C25671 implements Runnable {
        C25671() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123907);
            View view = AutoFillListPopupWindowBase.this.amx;
            if (!(view == null || view.getWindowToken() == null)) {
                AutoFillListPopupWindowBase.this.show();
            }
            AppMethodBeat.m2505o(123907);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$2 */
    class C25682 implements OnItemSelectedListener {
        C25682() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(123908);
            if (i != -1) {
                C2564a a = AutoFillListPopupWindowBase.this.jhV;
                if (a != null) {
                    a.aid = false;
                }
            }
            AppMethodBeat.m2505o(123908);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$f */
    class C2569f implements Runnable {
        private C2569f() {
        }

        /* synthetic */ C2569f(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(123921);
            if (AutoFillListPopupWindowBase.this.jhV != null && AutoFillListPopupWindowBase.this.jhV.getCount() > AutoFillListPopupWindowBase.this.jhV.getChildCount() && AutoFillListPopupWindowBase.this.jhV.getChildCount() <= AutoFillListPopupWindowBase.this.amu) {
                AutoFillListPopupWindowBase.this.amH.setInputMethodMode(2);
                AutoFillListPopupWindowBase.this.show();
            }
            AppMethodBeat.m2505o(123921);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$d */
    class C2570d implements OnScrollListener {
        private C2570d() {
        }

        /* synthetic */ C2570d(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(123918);
            if (!(AutoFillListPopupWindowBase.this.jhV == null || AutoFillListPopupWindowBase.this.amv == null || AutoFillListPopupWindowBase.this.f1259Ei == null || AutoFillListPopupWindowBase.this.jhV == null)) {
                if (AutoFillListPopupWindowBase.this.jhV.getLastVisiblePosition() != AutoFillListPopupWindowBase.this.f1259Ei.getCount() - 1 || AutoFillListPopupWindowBase.this.jhV.getChildAt(AutoFillListPopupWindowBase.this.jhV.getChildCount() - 1) == null || AutoFillListPopupWindowBase.this.jhV.getChildAt(AutoFillListPopupWindowBase.this.jhV.getChildCount() - 1).getBottom() > AutoFillListPopupWindowBase.this.jhV.getHeight()) {
                    AutoFillListPopupWindowBase.this.amv.setVisibility(0);
                } else {
                    AutoFillListPopupWindowBase.this.amv.setVisibility(8);
                    AppMethodBeat.m2505o(123918);
                    return;
                }
            }
            AppMethodBeat.m2505o(123918);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(123919);
            if (!(i != 1 || AutoFillListPopupWindowBase.this.isInputMethodNotNeeded() || AutoFillListPopupWindowBase.this.amH.getContentView() == null)) {
                AutoFillListPopupWindowBase.this.mHandler.removeCallbacks(AutoFillListPopupWindowBase.this.jhW);
                AutoFillListPopupWindowBase.this.jhW.run();
            }
            AppMethodBeat.m2505o(123919);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase$e */
    class C2571e implements OnTouchListener {
        private C2571e() {
        }

        /* synthetic */ C2571e(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(123920);
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && AutoFillListPopupWindowBase.this.amH != null && AutoFillListPopupWindowBase.this.amH.isShowing() && x >= 0 && x < AutoFillListPopupWindowBase.this.amH.getWidth() && y >= 0 && y < AutoFillListPopupWindowBase.this.amH.getHeight()) {
                AutoFillListPopupWindowBase.this.mHandler.postDelayed(AutoFillListPopupWindowBase.this.jhW, 250);
            } else if (action == 1) {
                AutoFillListPopupWindowBase.this.mHandler.removeCallbacks(AutoFillListPopupWindowBase.this.jhW);
            }
            AppMethodBeat.m2505o(123920);
            return false;
        }
    }

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5672fd);
    }

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.m2504i(123922);
        this.aml = -2;
        this.age = -2;
        this.ams = false;
        this.amt = false;
        this.amu = BaseClientBuilder.API_PRIORITY_OTHER;
        this.amw = 0;
        this.jhW = new C2569f(this, (byte) 0);
        this.jhX = new C2571e(this, (byte) 0);
        this.jhY = new C2570d(this, (byte) 0);
        this.jhZ = new C2566b(this, (byte) 0);
        this.mHandler = new C7306ak();
        this.mTempRect = new Rect();
        this.jia = false;
        this.mContext = context;
        this.amH = new PopupWindow(context);
        this.amH.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
        AppMethodBeat.m2505o(123922);
    }

    public final void setVerticalOffset(int i) {
        this.amn = i;
        this.amp = true;
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(123924);
        this.amH.dismiss();
        m4814iY();
        this.amH.setContentView(null);
        this.jhV = null;
        this.mHandler.removeCallbacks(this.jhW);
        AppMethodBeat.m2505o(123924);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(123925);
        this.amH.setOnDismissListener(onDismissListener);
        AppMethodBeat.m2505o(123925);
    }

    /* renamed from: iY */
    private void m4814iY() {
        AppMethodBeat.m2504i(123926);
        if (this.amv != null) {
            ViewParent parent = this.amv.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.amv);
            }
        }
        AppMethodBeat.m2505o(123926);
    }

    public final void clearListSelection() {
        AppMethodBeat.m2504i(123927);
        C2564a c2564a = this.jhV;
        if (c2564a != null) {
            c2564a.aid = true;
            c2564a.requestLayout();
        }
        AppMethodBeat.m2505o(123927);
    }

    public final boolean isInputMethodNotNeeded() {
        AppMethodBeat.m2504i(123928);
        if (this.amH.getInputMethodMode() == 2) {
            AppMethodBeat.m2505o(123928);
            return true;
        }
        AppMethodBeat.m2505o(123928);
        return false;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2 = true;
        int i4 = -1;
        AppMethodBeat.m2504i(123923);
        View frameLayout;
        if (this.jhV == null) {
            Context context = this.mContext;
            this.amF = new C25671();
            this.jhV = new C2564a(context, !this.amG);
            if (this.amy != null) {
                this.jhV.setSelector(this.amy);
            }
            this.jhV.setAdapter(this.f1259Ei);
            this.jhV.setOnItemClickListener(this.amz);
            this.jhV.setFocusable(true);
            this.jhV.setFocusableInTouchMode(true);
            this.jhV.setDivider(null);
            this.jhV.setDividerHeight(0);
            this.jhV.setOnItemSelectedListener(new C25682());
            this.jhV.setOnScrollListener(this.jhY);
            if (this.amA != null) {
                this.jhV.setOnItemSelectedListener(this.amA);
            }
            View view = this.jhV;
            View view2 = this.amv;
            if (view2 != null) {
                m4814iY();
                frameLayout = new FrameLayout(context);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                switch (this.amw) {
                    case 0:
                        layoutParams2.gravity = 48;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        layoutParams2.gravity = 80;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.amw);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.age, C8415j.INVALID_ID), 0);
            } else {
                frameLayout = view;
            }
            this.amH.setContentView(frameLayout);
            i = 0;
        } else {
            this.amH.getContentView();
            frameLayout = this.amv;
            if (frameLayout != null) {
                i = frameLayout.getMeasuredHeight();
            } else {
                i = 0;
            }
        }
        Drawable background = this.amH.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            i2 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.amp) {
                this.amn = -this.mTempRect.top;
            }
        } else {
            this.mTempRect.setEmpty();
            i2 = 0;
        }
        if (this.amH.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View view3 = this.amx;
        int i5 = this.amn;
        Rect rect = new Rect();
        view3.getWindowVisibleDisplayFrame(rect);
        view3.getLocationOnScreen(new int[2]);
        int i6 = rect.bottom;
        if (z) {
            i3 = view3.getContext().getResources().getDisplayMetrics().heightPixels;
        } else {
            i3 = i6;
        }
        i3 -= i5;
        if (this.amH.getBackground() != null) {
            this.amH.getBackground().getPadding(this.mTempRect);
            i3 -= this.mTempRect.top + this.mTempRect.bottom;
        }
        if (this.ams || this.aml == -1) {
            i = i3 + i2;
        } else {
            switch (this.age) {
                case -2:
                    i6 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), C8415j.INVALID_ID);
                    break;
                case -1:
                    i6 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), ErrorDialogData.SUPPRESSED);
                    break;
                default:
                    i6 = MeasureSpec.makeMeasureSpec(this.age, ErrorDialogData.SUPPRESSED);
                    break;
            }
            i3 = this.jhV.mo6544dt(i6, i3 - i);
            if (i3 > 0) {
                i += i2;
            }
            i += i3;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindow popupWindow;
        if (this.amH.isShowing()) {
            if (this.age == -1) {
                i2 = -1;
            } else if (this.age == -2) {
                i2 = this.amx.getWidth();
            } else {
                i2 = this.age;
            }
            if (this.aml == -1) {
                if (isInputMethodNotNeeded) {
                    i3 = i;
                } else {
                    i3 = -1;
                }
                if (isInputMethodNotNeeded) {
                    popupWindow = this.amH;
                    if (this.age != -1) {
                        i4 = 0;
                    }
                    popupWindow.setWindowLayoutMode(i4, 0);
                    i = i3;
                } else {
                    this.amH.setWindowLayoutMode(this.age == -1 ? -1 : 0, -1);
                    i = i3;
                }
            } else if (this.aml != -2) {
                i = this.aml;
            }
            this.amH.update(i2, i);
            popupWindow = this.amH;
            if (this.amt || this.ams) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            if (this.jia) {
                this.amH.showAtLocation(this.amx, 17, 0, 0);
                AppMethodBeat.m2505o(123923);
                return;
            }
            this.amH.update(this.amx, this.amm, this.amn, this.amH.getWidth(), this.amH.getHeight());
            AppMethodBeat.m2505o(123923);
            return;
        }
        if (this.age == -1) {
            i2 = -1;
        } else if (this.age == -2) {
            this.amH.setWidth(this.amx.getWidth());
            i2 = 0;
        } else {
            this.amH.setWidth(this.age);
            i2 = 0;
        }
        if (this.aml == -1) {
            i = -1;
        } else if (this.aml == -2) {
            this.amH.setHeight(i);
            i = 0;
        } else {
            this.amH.setHeight(this.aml);
            i = 0;
        }
        this.amH.setWindowLayoutMode(i2, i);
        popupWindow = this.amH;
        if (this.amt || this.ams) {
            z2 = false;
        }
        popupWindow.setOutsideTouchable(z2);
        this.amH.setTouchInterceptor(this.jhX);
        if (this.jia) {
            this.amH.showAtLocation(this.amx, 17, 0, 0);
        } else if (VERSION.SDK_INT >= 19) {
            this.amH.showAsDropDown(this.amx, this.amm, this.amn, 53);
        } else {
            this.amH.showAtLocation(this.amx, 53, this.amm, this.amn);
        }
        this.jhV.setSelection(-1);
        if (!this.amG || this.jhV.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.amG) {
            this.mHandler.post(this.jhZ);
        }
        AppMethodBeat.m2505o(123923);
    }
}
