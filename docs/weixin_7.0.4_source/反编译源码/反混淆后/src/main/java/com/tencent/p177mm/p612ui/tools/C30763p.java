package com.tencent.p177mm.p612ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.p069v7.app.AppCompatActivity;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.base.MMListPopupWindow;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.tools.p */
public abstract class C30763p implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    private ViewTreeObserver aaM;
    private int acm;
    private int dividerHeight;
    private boolean jia = false;
    private BaseAdapter khG;
    protected Context mContext;
    /* renamed from: pP */
    private View f13757pP;
    private boolean uEM = false;
    private MMListPopupWindow yHM;
    private int yHN = C25738R.style.f10875h8;
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

    /* renamed from: Kw */
    public abstract BaseAdapter mo49180Kw();

    public C30763p(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.acm = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(C25738R.dimen.f9983m9));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.f13757pP = viewGroup.getChildAt(0);
            } else {
                this.f13757pP = viewGroup;
            }
        }
        this.dividerHeight = C4977b.m7371b(this.mContext, 1.0f);
        this.zHQ = resources.getDimensionPixelSize(C25738R.dimen.f9979m4) * 2;
        this.zHR = resources.getDimensionPixelSize(C25738R.dimen.f9781fg);
        this.zHS = C4977b.m7371b(this.mContext, 36.0f);
        this.khG = mo49180Kw();
    }

    /* renamed from: qR */
    public final void mo49188qR(boolean z) {
        this.jia = z;
        if (z) {
            this.yHN = C25738R.style.f10831fs;
        } else {
            this.yHN = C25738R.style.f10875h8;
        }
    }

    /* renamed from: gP */
    public boolean mo49182gP() {
        int height;
        Rect rect = new Rect();
        if (this.mContext instanceof AppCompatActivity) {
            height = ((AppCompatActivity) this.mContext).getSupportActionBar().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                height = C4977b.m7371b(this.mContext, 40.0f);
            } else {
                height = C4977b.m7371b(this.mContext, 49.0f);
            }
        }
        int am = C5229aj.m7981am(this.mContext, C25738R.dimen.f9813gg);
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
        this.yHM.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.bds));
        this.yHM.setAnimationStyle(this.yHN);
        this.yHM.amm = am;
        this.yHM.amx = this.f13757pP;
        if (this.f13757pP != null) {
            boolean z = this.aaM == null;
            this.aaM = this.f13757pP.getViewTreeObserver();
            C4990ab.m7419v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", Boolean.valueOf(z));
            if (z) {
                this.aaM.addOnGlobalLayoutListener(this);
            }
        }
        this.yHM.setVerticalOffset(height);
        this.yHM.jia = this.jia;
        this.yHM.setContentWidth(Math.min(m49096b(this.khG), this.acm));
        this.yHM.mo39308iZ();
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
            C4990ab.m7411d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", Float.valueOf(this.zHT), Float.valueOf(this.zHU), Integer.valueOf(rect2.height()), Integer.valueOf(height3), Integer.valueOf(height4));
            height4 = Math.round((float) (height4 / this.zHR));
            if (height4 <= 0 || this.khG == null) {
                C4990ab.m7412e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                height = (this.zHR * height4) + this.zHQ;
                if (height == 0 || height >= this.khG.getCount() * this.zHR) {
                    C4990ab.m7421w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", Integer.valueOf(height), Integer.valueOf(this.khG.getCount() * this.zHR));
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
                mMListPopupWindow.mo39307iY();
            }
            mMListPopupWindow.amv = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.yHM.amw = this.zHP;
        }
        this.yHM.show();
        this.yHM.yvM.setOnKeyListener(this);
        this.yHM.yvM.setSelector(new ColorDrawable(this.mContext.getResources().getColor(C25738R.color.a3p)));
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

    /* renamed from: b */
    private int m49096b(ListAdapter listAdapter) {
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
                this.aaM = this.f13757pP.getViewTreeObserver();
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
        C4990ab.m7419v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", Boolean.valueOf(isShowing()), Boolean.valueOf(this.f13757pP.isShown()));
        if (isShowing()) {
            View view = this.f13757pP;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.uEM != isLandscape()) {
                this.yHM.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        C4990ab.m7418v("MicroMsg.SubMenuHelperBase", "onKey");
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
