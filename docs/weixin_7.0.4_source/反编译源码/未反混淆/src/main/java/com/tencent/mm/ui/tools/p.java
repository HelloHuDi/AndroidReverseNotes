package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMListPopupWindow;

public abstract class p implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    private ViewTreeObserver aaM;
    private int acm;
    private int dividerHeight;
    private boolean jia = false;
    private BaseAdapter khG;
    protected Context mContext;
    private View pP;
    private boolean uEM = false;
    private MMListPopupWindow yHM;
    private int yHN = R.style.h8;
    private OnCancelListener yes;
    private ViewGroup zHL;
    private OnDismissListener zHM;
    private boolean zHN = true;
    private View zHO;
    private int zHP;
    private int zHQ = 0;
    private int zHR = 0;
    private int zHS = 0;
    private float zHT = 0.0f;
    private float zHU = 0.0f;

    public abstract BaseAdapter Kw();

    public p(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.acm = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(R.dimen.m9));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.pP = viewGroup.getChildAt(0);
            } else {
                this.pP = viewGroup;
            }
        }
        this.dividerHeight = b.b(this.mContext, 1.0f);
        this.zHQ = resources.getDimensionPixelSize(R.dimen.m4) * 2;
        this.zHR = resources.getDimensionPixelSize(R.dimen.fg);
        this.zHS = b.b(this.mContext, 36.0f);
        this.khG = Kw();
    }

    public final void qR(boolean z) {
        this.jia = z;
        if (z) {
            this.yHN = R.style.fs;
        } else {
            this.yHN = R.style.h8;
        }
    }

    public boolean gP() {
        int height;
        Rect rect = new Rect();
        if (this.mContext instanceof AppCompatActivity) {
            height = ((AppCompatActivity) this.mContext).getSupportActionBar().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                height = b.b(this.mContext, 40.0f);
            } else {
                height = b.b(this.mContext, 49.0f);
            }
        }
        int am = aj.am(this.mContext, R.dimen.gg);
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height2 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) this.mContext).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height2 - rect.height() < 0 || iArr[1] <= 200) {
                height += rect.top;
            } else {
                height += height2 - rect.height();
            }
        }
        this.uEM = isLandscape();
        if (this.yHM == null) {
            this.yHM = new MMListPopupWindow(this.mContext, null, 0);
        }
        this.yHM.setOnDismissListener(this);
        this.yHM.amz = this;
        this.yHM.setAdapter(this.khG);
        this.yHM.setModal(true);
        this.yHM.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bds));
        this.yHM.setAnimationStyle(this.yHN);
        this.yHM.amm = am;
        this.yHM.amx = this.pP;
        if (this.pP != null) {
            boolean z = this.aaM == null;
            this.aaM = this.pP.getViewTreeObserver();
            ab.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", Boolean.valueOf(z));
            if (z) {
                this.aaM.addOnGlobalLayoutListener(this);
            }
        }
        this.yHM.setVerticalOffset(height);
        this.yHM.jia = this.jia;
        this.yHM.setContentWidth(Math.min(b(this.khG), this.acm));
        this.yHM.iZ();
        if (!(this.zHT == 0.0f || this.zHU == 0.0f)) {
            int height3;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            height = displayMetrics2.widthPixels > displayMetrics2.heightPixels ? 1 : 0;
            Rect rect2 = new Rect();
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            int height4 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            if (height4 > rect2.height()) {
                height3 = rect2.height();
            } else {
                height3 = height4;
            }
            if (height != 0) {
                height4 = (int) (this.zHU * ((float) height3));
            } else {
                height4 = (int) (this.zHT * ((float) height3));
            }
            ab.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", Float.valueOf(this.zHT), Float.valueOf(this.zHU), Integer.valueOf(rect2.height()), Integer.valueOf(height3), Integer.valueOf(height4));
            height4 = Math.round((float) (height4 / this.zHR));
            if (height4 <= 0 || this.khG == null) {
                ab.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                height = (this.zHR * height4) + this.zHQ;
                if (height == 0 || height >= this.khG.getCount() * this.zHR) {
                    ab.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", Integer.valueOf(height), Integer.valueOf(this.khG.getCount() * this.zHR));
                } else {
                    this.yHM.aml = (((height4 - 1) * this.zHR) + this.zHQ) + this.zHS;
                }
            }
        }
        if (!(this.yHM == null || this.zHO == null)) {
            MMListPopupWindow mMListPopupWindow = this.yHM;
            View view = this.zHO;
            boolean isShowing = mMListPopupWindow.gKG.isShowing();
            if (isShowing) {
                mMListPopupWindow.iY();
            }
            mMListPopupWindow.amv = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.yHM.amw = this.zHP;
        }
        this.yHM.show();
        this.yHM.yvM.setOnKeyListener(this);
        this.yHM.yvM.setSelector(new ColorDrawable(this.mContext.getResources().getColor(R.color.a3p)));
        this.yHM.yvM.setDividerHeight(0);
        this.yHM.yvM.setVerticalScrollBarEnabled(true);
        this.yHM.yvM.setHorizontalScrollBarEnabled(false);
        return true;
    }

    private boolean isLandscape() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.yHM.dismiss();
        }
    }

    private int b(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
            }
            if (this.zHL == null) {
                this.zHL = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view, this.zHL);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onDismiss() {
        if (this.aaM != null) {
            if (!this.aaM.isAlive()) {
                this.aaM = this.pP.getViewTreeObserver();
            }
            this.aaM.removeGlobalOnLayoutListener(this);
            this.aaM = null;
        }
        if (this.yes != null) {
            this.yes.onCancel(null);
        }
        if (this.zHM != null) {
            this.zHM.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.yHM != null && this.yHM.gKG.isShowing();
    }

    public void onGlobalLayout() {
        ab.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", Boolean.valueOf(isShowing()), Boolean.valueOf(this.pP.isShown()));
        if (isShowing()) {
            View view = this.pP;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.uEM != isLandscape()) {
                this.yHM.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        ab.v("MicroMsg.SubMenuHelperBase", "onKey");
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
    }
}
