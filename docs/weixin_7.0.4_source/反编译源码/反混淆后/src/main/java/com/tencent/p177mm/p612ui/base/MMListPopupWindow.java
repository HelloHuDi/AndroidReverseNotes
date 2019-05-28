package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
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
import android.widget.PopupWindow.OnDismissListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.C5231al;

/* renamed from: com.tencent.mm.ui.base.MMListPopupWindow */
public class MMListPopupWindow {
    /* renamed from: Ei */
    private ListAdapter f4424Ei;
    private int age;
    private OnItemSelectedListener amA;
    private Runnable amF;
    private boolean amG;
    public int aml;
    public int amm;
    private int amn;
    private boolean amp;
    private boolean ams;
    public boolean amt;
    int amu;
    public View amv;
    public int amw;
    public View amx;
    private Drawable amy;
    public OnItemClickListener amz;
    public C46633o gKG;
    public boolean jia;
    private Context mContext;
    private Handler mHandler;
    private DataSetObserver mObserver;
    private Rect mTempRect;
    private final C23590f yvI;
    private final C23589e yvJ;
    private final C23592d yvK;
    private final C23586b yvL;
    public C23587a yvM;

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$b */
    class C23586b implements Runnable {
        private C23586b() {
        }

        /* synthetic */ C23586b(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(112513);
            MMListPopupWindow.this.clearListSelection();
            AppMethodBeat.m2505o(112513);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$a */
    static class C23587a extends ListView {
        private boolean aid;
        private boolean aie;

        /* synthetic */ C23587a(Context context, boolean z, byte b) {
            this(context, z);
        }

        private C23587a(Context context, boolean z) {
            super(context, null, C25738R.attr.f5671fc);
            AppMethodBeat.m2504i(112507);
            this.aie = z;
            setCacheColorHint(0);
            AppMethodBeat.m2505o(112507);
        }

        public final boolean isInTouchMode() {
            AppMethodBeat.m2504i(112508);
            if ((this.aie && this.aid) || super.isInTouchMode()) {
                AppMethodBeat.m2505o(112508);
                return true;
            }
            AppMethodBeat.m2505o(112508);
            return false;
        }

        public final boolean hasWindowFocus() {
            AppMethodBeat.m2504i(112509);
            if (this.aie || super.hasWindowFocus()) {
                AppMethodBeat.m2505o(112509);
                return true;
            }
            AppMethodBeat.m2505o(112509);
            return false;
        }

        public final boolean isFocused() {
            AppMethodBeat.m2504i(112510);
            if (this.aie || super.isFocused()) {
                AppMethodBeat.m2505o(112510);
                return true;
            }
            AppMethodBeat.m2505o(112510);
            return false;
        }

        public final boolean hasFocus() {
            AppMethodBeat.m2504i(112511);
            if (this.aie || super.hasFocus()) {
                AppMethodBeat.m2505o(112511);
                return true;
            }
            AppMethodBeat.m2505o(112511);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dt */
        public final int mo39318dt(int i, int i2) {
            AppMethodBeat.m2504i(112512);
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                i2 = listPaddingTop + listPaddingBottom;
                AppMethodBeat.m2505o(112512);
                return i2;
            }
            int i3 = listPaddingTop + listPaddingBottom;
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i4 = 0;
            listPaddingBottom = 0;
            View view = null;
            while (i4 < count) {
                listPaddingTop = adapter.getItemViewType(i4);
                if (listPaddingTop != listPaddingBottom) {
                    view = null;
                } else {
                    listPaddingTop = listPaddingBottom;
                }
                view = adapter.getView(i4, view, this);
                listPaddingBottom = view == null ? 0 : view.getLayoutParams().height;
                if (listPaddingBottom > 0) {
                    listPaddingBottom = MeasureSpec.makeMeasureSpec(listPaddingBottom, ErrorDialogData.SUPPRESSED);
                } else {
                    listPaddingBottom = MeasureSpec.makeMeasureSpec(0, 0);
                }
                if (view != null) {
                    view.measure(i, listPaddingBottom);
                }
                if (i4 > 0) {
                    i3 += dividerHeight;
                }
                if (view != null) {
                    i3 += view.getMeasuredHeight();
                }
                if (i3 >= i2) {
                    AppMethodBeat.m2505o(112512);
                    return i2;
                }
                i4++;
                listPaddingBottom = listPaddingTop;
            }
            AppMethodBeat.m2505o(112512);
            return i3;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$c */
    class C23588c extends DataSetObserver {
        private C23588c() {
        }

        /* synthetic */ C23588c(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(112514);
            if (MMListPopupWindow.this.gKG.isShowing()) {
                MMListPopupWindow.this.show();
            }
            AppMethodBeat.m2505o(112514);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(112515);
            MMListPopupWindow.this.dismiss();
            AppMethodBeat.m2505o(112515);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$e */
    class C23589e implements OnTouchListener {
        private C23589e() {
        }

        /* synthetic */ C23589e(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(112518);
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && MMListPopupWindow.this.gKG != null && MMListPopupWindow.this.gKG.isShowing() && x >= 0 && x < MMListPopupWindow.this.gKG.getWidth() && y >= 0 && y < MMListPopupWindow.this.gKG.getHeight()) {
                MMListPopupWindow.this.mHandler.postDelayed(MMListPopupWindow.this.yvI, 250);
            } else if (action == 1) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.yvI);
            }
            AppMethodBeat.m2505o(112518);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$f */
    class C23590f implements Runnable {
        private C23590f() {
        }

        /* synthetic */ C23590f(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(112519);
            if (MMListPopupWindow.this.yvM != null && MMListPopupWindow.this.yvM.getCount() > MMListPopupWindow.this.yvM.getChildCount() && MMListPopupWindow.this.yvM.getChildCount() <= MMListPopupWindow.this.amu) {
                MMListPopupWindow.this.gKG.setInputMethodMode(2);
                MMListPopupWindow.this.show();
            }
            AppMethodBeat.m2505o(112519);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$2 */
    class C235912 implements OnItemSelectedListener {
        C235912() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(112506);
            if (i != -1) {
                C23587a a = MMListPopupWindow.this.yvM;
                if (a != null) {
                    a.aid = false;
                }
            }
            AppMethodBeat.m2505o(112506);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$d */
    class C23592d implements OnScrollListener {
        private C23592d() {
        }

        /* synthetic */ C23592d(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(112516);
            if (!(MMListPopupWindow.this.yvM == null || MMListPopupWindow.this.amv == null || MMListPopupWindow.this.f4424Ei == null || MMListPopupWindow.this.yvM == null)) {
                if (MMListPopupWindow.this.yvM.getLastVisiblePosition() != MMListPopupWindow.this.f4424Ei.getCount() - 1 || MMListPopupWindow.this.yvM.getChildAt(MMListPopupWindow.this.yvM.getChildCount() - 1) == null || MMListPopupWindow.this.yvM.getChildAt(MMListPopupWindow.this.yvM.getChildCount() - 1).getBottom() > MMListPopupWindow.this.yvM.getHeight()) {
                    MMListPopupWindow.this.amv.setVisibility(0);
                } else {
                    MMListPopupWindow.this.amv.setVisibility(8);
                    AppMethodBeat.m2505o(112516);
                    return;
                }
            }
            AppMethodBeat.m2505o(112516);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(112517);
            if (!(i != 1 || MMListPopupWindow.this.isInputMethodNotNeeded() || MMListPopupWindow.this.gKG.getContentView() == null)) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.yvI);
                MMListPopupWindow.this.yvI.run();
            }
            AppMethodBeat.m2505o(112517);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMListPopupWindow$1 */
    class C235931 implements Runnable {
        C235931() {
        }

        public final void run() {
            AppMethodBeat.m2504i(112505);
            View view = MMListPopupWindow.this.amx;
            if (!(view == null || view.getWindowToken() == null)) {
                MMListPopupWindow.this.show();
            }
            AppMethodBeat.m2505o(112505);
        }
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5672fd);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.m2504i(112520);
        this.yvI = new C23590f(this, (byte) 0);
        this.yvJ = new C23589e(this, (byte) 0);
        this.yvK = new C23592d(this, (byte) 0);
        this.yvL = new C23586b(this, (byte) 0);
        this.amu = BaseClientBuilder.API_PRIORITY_OTHER;
        this.aml = -2;
        this.age = -2;
        this.ams = false;
        this.amt = false;
        this.amw = 0;
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.jia = false;
        this.mContext = context;
        this.gKG = new C46633o(context);
        this.gKG.setInputMethodMode(1);
        AppMethodBeat.m2505o(112520);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(112521);
        if (this.mObserver == null) {
            this.mObserver = new C23588c(this, (byte) 0);
        } else if (this.f4424Ei != null) {
            this.f4424Ei.unregisterDataSetObserver(this.mObserver);
        }
        this.f4424Ei = listAdapter;
        if (this.f4424Ei != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.yvM != null) {
            this.yvM.setAdapter(this.f4424Ei);
        }
        AppMethodBeat.m2505o(112521);
    }

    public final void setModal(boolean z) {
        AppMethodBeat.m2504i(112522);
        this.amG = z;
        this.gKG.setFocusable(this.amG);
        AppMethodBeat.m2505o(112522);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(112523);
        this.gKG.setBackgroundDrawable(drawable);
        AppMethodBeat.m2505o(112523);
    }

    public final void setAnimationStyle(int i) {
        AppMethodBeat.m2504i(112524);
        this.gKG.setAnimationStyle(i);
        AppMethodBeat.m2505o(112524);
    }

    public final void setVerticalOffset(int i) {
        this.amn = i;
        this.amp = true;
    }

    public final void setContentWidth(int i) {
        AppMethodBeat.m2504i(112525);
        Drawable background = this.gKG.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.age = (this.mTempRect.left + this.mTempRect.right) + i;
            AppMethodBeat.m2505o(112525);
            return;
        }
        this.age = i;
        AppMethodBeat.m2505o(112525);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(112527);
        this.gKG.dismiss();
        mo39307iY();
        this.gKG.setContentView(null);
        this.yvM = null;
        this.mHandler.removeCallbacks(this.yvI);
        AppMethodBeat.m2505o(112527);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(112528);
        this.gKG.setOnDismissListener(onDismissListener);
        AppMethodBeat.m2505o(112528);
    }

    /* renamed from: iY */
    public final void mo39307iY() {
        AppMethodBeat.m2504i(112529);
        if (this.amv != null) {
            ViewParent parent = this.amv.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.amv);
            }
        }
        AppMethodBeat.m2505o(112529);
    }

    /* renamed from: iZ */
    public final void mo39308iZ() {
        AppMethodBeat.m2504i(112530);
        this.gKG.setInputMethodMode(2);
        AppMethodBeat.m2505o(112530);
    }

    public final void clearListSelection() {
        AppMethodBeat.m2504i(112531);
        C23587a c23587a = this.yvM;
        if (c23587a != null) {
            c23587a.aid = true;
            c23587a.requestLayout();
        }
        AppMethodBeat.m2505o(112531);
    }

    public final boolean isInputMethodNotNeeded() {
        AppMethodBeat.m2504i(112532);
        if (this.gKG.getInputMethodMode() == 2) {
            AppMethodBeat.m2505o(112532);
            return true;
        }
        AppMethodBeat.m2505o(112532);
        return false;
    }

    public final void show() {
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2 = true;
        int i4 = -1;
        AppMethodBeat.m2504i(112526);
        View frameLayout;
        if (this.yvM == null) {
            Context context = this.mContext;
            this.amF = new C235931();
            this.yvM = new C23587a(context, !this.amG, (byte) 0);
            if (this.amy != null) {
                this.yvM.setSelector(this.amy);
            }
            this.yvM.setAdapter(this.f4424Ei);
            this.yvM.setOnItemClickListener(this.amz);
            this.yvM.setFocusable(true);
            this.yvM.setFocusableInTouchMode(true);
            this.yvM.setDivider(null);
            this.yvM.setDividerHeight(0);
            this.yvM.setOnItemSelectedListener(new C235912());
            this.yvM.setOnScrollListener(this.yvK);
            if (this.amA != null) {
                this.yvM.setOnItemSelectedListener(this.amA);
            }
            View view = this.yvM;
            View view2 = this.amv;
            if (view2 != null) {
                mo39307iY();
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
                        C5227ai.m7972e("ListPopupWindow", "Invalid hint position " + this.amw, new Object[0]);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.age, C8415j.INVALID_ID), 0);
            } else {
                frameLayout = view;
            }
            this.gKG.setContentView(frameLayout);
            i = 0;
        } else {
            frameLayout = this.amv;
            if (frameLayout != null) {
                i = frameLayout.getMeasuredHeight();
            } else {
                i = 0;
            }
        }
        Drawable background = this.gKG.getBackground();
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
        if (this.gKG.getInputMethodMode() == 2) {
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
            view3.getContext().getResources();
            i3 = C5231al.m7995hy(view3.getContext()).y;
        } else {
            i3 = i6;
        }
        i3 -= i5;
        if (this.gKG.getBackground() != null) {
            this.gKG.getBackground().getPadding(this.mTempRect);
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
            i3 = this.yvM.mo39318dt(i6, i3 - i);
            if (i3 > 0) {
                i += i2;
            }
            i += i3;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        C46633o c46633o;
        if (this.gKG.isShowing()) {
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
                    c46633o = this.gKG;
                    if (this.age != -1) {
                        i4 = 0;
                    }
                    c46633o.setWindowLayoutMode(i4, 0);
                    i = i3;
                } else {
                    this.gKG.setWindowLayoutMode(this.age == -1 ? -1 : 0, -1);
                    i = i3;
                }
            } else if (this.aml != -2) {
                i = this.aml;
            }
            this.gKG.update(i2, i);
            c46633o = this.gKG;
            if (this.amt || this.ams) {
                z2 = false;
            }
            c46633o.setOutsideTouchable(z2);
            if (this.jia) {
                this.gKG.showAtLocation(this.amx, 17, 0, 0);
                AppMethodBeat.m2505o(112526);
                return;
            }
            this.gKG.showAtLocation(this.amx, 53, this.amm, this.amn);
            AppMethodBeat.m2505o(112526);
            return;
        }
        if (this.age == -1) {
            i2 = -1;
        } else if (this.age == -2) {
            this.gKG.setWidth(this.amx.getWidth());
            i2 = 0;
        } else {
            this.gKG.setWidth(this.age);
            i2 = 0;
        }
        if (this.aml == -1) {
            i = -1;
        } else if (this.aml == -2) {
            this.gKG.setHeight(i);
            i = 0;
        } else {
            this.gKG.setHeight(this.aml);
            i = 0;
        }
        this.gKG.setWindowLayoutMode(i2, i);
        c46633o = this.gKG;
        if (this.amt || this.ams) {
            z2 = false;
        }
        c46633o.setOutsideTouchable(z2);
        this.gKG.setTouchInterceptor(this.yvJ);
        if (this.jia) {
            this.gKG.showAtLocation(this.amx, 17, 0, 0);
        } else {
            this.gKG.showAtLocation(this.amx, 53, this.amm, this.amn);
        }
        this.yvM.setSelection(-1);
        if (!this.amG || this.yvM.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.amG) {
            this.mHandler.post(this.yvL);
        }
        AppMethodBeat.m2505o(112526);
    }
}
