package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.widget.j;
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
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.al;

public class MMListPopupWindow {
    private ListAdapter Ei;
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
    public o gKG;
    public boolean jia;
    private Context mContext;
    private Handler mHandler;
    private DataSetObserver mObserver;
    private Rect mTempRect;
    private final f yvI;
    private final e yvJ;
    private final d yvK;
    private final b yvL;
    public a yvM;

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(112513);
            MMListPopupWindow.this.clearListSelection();
            AppMethodBeat.o(112513);
        }
    }

    static class a extends ListView {
        private boolean aid;
        private boolean aie;

        /* synthetic */ a(Context context, boolean z, byte b) {
            this(context, z);
        }

        private a(Context context, boolean z) {
            super(context, null, R.attr.fc);
            AppMethodBeat.i(112507);
            this.aie = z;
            setCacheColorHint(0);
            AppMethodBeat.o(112507);
        }

        public final boolean isInTouchMode() {
            AppMethodBeat.i(112508);
            if ((this.aie && this.aid) || super.isInTouchMode()) {
                AppMethodBeat.o(112508);
                return true;
            }
            AppMethodBeat.o(112508);
            return false;
        }

        public final boolean hasWindowFocus() {
            AppMethodBeat.i(112509);
            if (this.aie || super.hasWindowFocus()) {
                AppMethodBeat.o(112509);
                return true;
            }
            AppMethodBeat.o(112509);
            return false;
        }

        public final boolean isFocused() {
            AppMethodBeat.i(112510);
            if (this.aie || super.isFocused()) {
                AppMethodBeat.o(112510);
                return true;
            }
            AppMethodBeat.o(112510);
            return false;
        }

        public final boolean hasFocus() {
            AppMethodBeat.i(112511);
            if (this.aie || super.hasFocus()) {
                AppMethodBeat.o(112511);
                return true;
            }
            AppMethodBeat.o(112511);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final int dt(int i, int i2) {
            AppMethodBeat.i(112512);
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                i2 = listPaddingTop + listPaddingBottom;
                AppMethodBeat.o(112512);
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
                    AppMethodBeat.o(112512);
                    return i2;
                }
                i4++;
                listPaddingBottom = listPaddingTop;
            }
            AppMethodBeat.o(112512);
            return i3;
        }
    }

    class c extends DataSetObserver {
        private c() {
        }

        /* synthetic */ c(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(112514);
            if (MMListPopupWindow.this.gKG.isShowing()) {
                MMListPopupWindow.this.show();
            }
            AppMethodBeat.o(112514);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(112515);
            MMListPopupWindow.this.dismiss();
            AppMethodBeat.o(112515);
        }
    }

    class e implements OnTouchListener {
        private e() {
        }

        /* synthetic */ e(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(112518);
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && MMListPopupWindow.this.gKG != null && MMListPopupWindow.this.gKG.isShowing() && x >= 0 && x < MMListPopupWindow.this.gKG.getWidth() && y >= 0 && y < MMListPopupWindow.this.gKG.getHeight()) {
                MMListPopupWindow.this.mHandler.postDelayed(MMListPopupWindow.this.yvI, 250);
            } else if (action == 1) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.yvI);
            }
            AppMethodBeat.o(112518);
            return false;
        }
    }

    class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(112519);
            if (MMListPopupWindow.this.yvM != null && MMListPopupWindow.this.yvM.getCount() > MMListPopupWindow.this.yvM.getChildCount() && MMListPopupWindow.this.yvM.getChildCount() <= MMListPopupWindow.this.amu) {
                MMListPopupWindow.this.gKG.setInputMethodMode(2);
                MMListPopupWindow.this.show();
            }
            AppMethodBeat.o(112519);
        }
    }

    class d implements OnScrollListener {
        private d() {
        }

        /* synthetic */ d(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.i(112516);
            if (!(MMListPopupWindow.this.yvM == null || MMListPopupWindow.this.amv == null || MMListPopupWindow.this.Ei == null || MMListPopupWindow.this.yvM == null)) {
                if (MMListPopupWindow.this.yvM.getLastVisiblePosition() != MMListPopupWindow.this.Ei.getCount() - 1 || MMListPopupWindow.this.yvM.getChildAt(MMListPopupWindow.this.yvM.getChildCount() - 1) == null || MMListPopupWindow.this.yvM.getChildAt(MMListPopupWindow.this.yvM.getChildCount() - 1).getBottom() > MMListPopupWindow.this.yvM.getHeight()) {
                    MMListPopupWindow.this.amv.setVisibility(0);
                } else {
                    MMListPopupWindow.this.amv.setVisibility(8);
                    AppMethodBeat.o(112516);
                    return;
                }
            }
            AppMethodBeat.o(112516);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(112517);
            if (!(i != 1 || MMListPopupWindow.this.isInputMethodNotNeeded() || MMListPopupWindow.this.gKG.getContentView() == null)) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.yvI);
                MMListPopupWindow.this.yvI.run();
            }
            AppMethodBeat.o(112517);
        }
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.fd);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.i(112520);
        this.yvI = new f(this, (byte) 0);
        this.yvJ = new e(this, (byte) 0);
        this.yvK = new d(this, (byte) 0);
        this.yvL = new b(this, (byte) 0);
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
        this.gKG = new o(context);
        this.gKG.setInputMethodMode(1);
        AppMethodBeat.o(112520);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(112521);
        if (this.mObserver == null) {
            this.mObserver = new c(this, (byte) 0);
        } else if (this.Ei != null) {
            this.Ei.unregisterDataSetObserver(this.mObserver);
        }
        this.Ei = listAdapter;
        if (this.Ei != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.yvM != null) {
            this.yvM.setAdapter(this.Ei);
        }
        AppMethodBeat.o(112521);
    }

    public final void setModal(boolean z) {
        AppMethodBeat.i(112522);
        this.amG = z;
        this.gKG.setFocusable(this.amG);
        AppMethodBeat.o(112522);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(112523);
        this.gKG.setBackgroundDrawable(drawable);
        AppMethodBeat.o(112523);
    }

    public final void setAnimationStyle(int i) {
        AppMethodBeat.i(112524);
        this.gKG.setAnimationStyle(i);
        AppMethodBeat.o(112524);
    }

    public final void setVerticalOffset(int i) {
        this.amn = i;
        this.amp = true;
    }

    public final void setContentWidth(int i) {
        AppMethodBeat.i(112525);
        Drawable background = this.gKG.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.age = (this.mTempRect.left + this.mTempRect.right) + i;
            AppMethodBeat.o(112525);
            return;
        }
        this.age = i;
        AppMethodBeat.o(112525);
    }

    public final void dismiss() {
        AppMethodBeat.i(112527);
        this.gKG.dismiss();
        iY();
        this.gKG.setContentView(null);
        this.yvM = null;
        this.mHandler.removeCallbacks(this.yvI);
        AppMethodBeat.o(112527);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.i(112528);
        this.gKG.setOnDismissListener(onDismissListener);
        AppMethodBeat.o(112528);
    }

    public final void iY() {
        AppMethodBeat.i(112529);
        if (this.amv != null) {
            ViewParent parent = this.amv.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.amv);
            }
        }
        AppMethodBeat.o(112529);
    }

    public final void iZ() {
        AppMethodBeat.i(112530);
        this.gKG.setInputMethodMode(2);
        AppMethodBeat.o(112530);
    }

    public final void clearListSelection() {
        AppMethodBeat.i(112531);
        a aVar = this.yvM;
        if (aVar != null) {
            aVar.aid = true;
            aVar.requestLayout();
        }
        AppMethodBeat.o(112531);
    }

    public final boolean isInputMethodNotNeeded() {
        AppMethodBeat.i(112532);
        if (this.gKG.getInputMethodMode() == 2) {
            AppMethodBeat.o(112532);
            return true;
        }
        AppMethodBeat.o(112532);
        return false;
    }

    public final void show() {
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2 = true;
        int i4 = -1;
        AppMethodBeat.i(112526);
        View frameLayout;
        if (this.yvM == null) {
            Context context = this.mContext;
            this.amF = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(112505);
                    View view = MMListPopupWindow.this.amx;
                    if (!(view == null || view.getWindowToken() == null)) {
                        MMListPopupWindow.this.show();
                    }
                    AppMethodBeat.o(112505);
                }
            };
            this.yvM = new a(context, !this.amG, (byte) 0);
            if (this.amy != null) {
                this.yvM.setSelector(this.amy);
            }
            this.yvM.setAdapter(this.Ei);
            this.yvM.setOnItemClickListener(this.amz);
            this.yvM.setFocusable(true);
            this.yvM.setFocusableInTouchMode(true);
            this.yvM.setDivider(null);
            this.yvM.setDividerHeight(0);
            this.yvM.setOnItemSelectedListener(new OnItemSelectedListener() {
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(112506);
                    if (i != -1) {
                        a a = MMListPopupWindow.this.yvM;
                        if (a != null) {
                            a.aid = false;
                        }
                    }
                    AppMethodBeat.o(112506);
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.yvM.setOnScrollListener(this.yvK);
            if (this.amA != null) {
                this.yvM.setOnItemSelectedListener(this.amA);
            }
            View view = this.yvM;
            View view2 = this.amv;
            if (view2 != null) {
                iY();
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
                        ai.e("ListPopupWindow", "Invalid hint position " + this.amw, new Object[0]);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.age, j.INVALID_ID), 0);
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
            i3 = al.hy(view3.getContext()).y;
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
                    i6 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), j.INVALID_ID);
                    break;
                case -1:
                    i6 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), ErrorDialogData.SUPPRESSED);
                    break;
                default:
                    i6 = MeasureSpec.makeMeasureSpec(this.age, ErrorDialogData.SUPPRESSED);
                    break;
            }
            i3 = this.yvM.dt(i6, i3 - i);
            if (i3 > 0) {
                i += i2;
            }
            i += i3;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        o oVar;
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
                    oVar = this.gKG;
                    if (this.age != -1) {
                        i4 = 0;
                    }
                    oVar.setWindowLayoutMode(i4, 0);
                    i = i3;
                } else {
                    this.gKG.setWindowLayoutMode(this.age == -1 ? -1 : 0, -1);
                    i = i3;
                }
            } else if (this.aml != -2) {
                i = this.aml;
            }
            this.gKG.update(i2, i);
            oVar = this.gKG;
            if (this.amt || this.ams) {
                z2 = false;
            }
            oVar.setOutsideTouchable(z2);
            if (this.jia) {
                this.gKG.showAtLocation(this.amx, 17, 0, 0);
                AppMethodBeat.o(112526);
                return;
            }
            this.gKG.showAtLocation(this.amx, 53, this.amm, this.amn);
            AppMethodBeat.o(112526);
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
        oVar = this.gKG;
        if (this.amt || this.ams) {
            z2 = false;
        }
        oVar.setOutsideTouchable(z2);
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
        AppMethodBeat.o(112526);
    }
}
