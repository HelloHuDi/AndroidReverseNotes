package android.support.p069v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0455b;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.menu.C0632s;
import android.support.p069v7.widget.C41538e.C31890c;
import android.support.p069v7.widget.C41538e.C37145a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: android.support.v7.widget.ActivityChooserView */
public class ActivityChooserView extends ViewGroup {
    OnDismissListener aaN;
    final C31878a aeA;
    private final C8423b aeB;
    final View aeC;
    final Drawable aeD;
    final FrameLayout aeE;
    private final ImageView aeF;
    final FrameLayout aeG;
    final ImageView aeH;
    private final int aeI;
    C0455b aeJ;
    final DataSetObserver aeK;
    private final OnGlobalLayoutListener aeL;
    private ListPopupWindow aeM;
    boolean aeN;
    int aeO;
    int aeP;
    /* renamed from: pv */
    private boolean f16845pv;

    /* renamed from: android.support.v7.widget.ActivityChooserView$5 */
    class C06445 extends DataSetObserver {
        C06445() {
        }

        public final void onChanged() {
            super.onChanged();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.aeA.getCount() > 0) {
                activityChooserView.aeE.setEnabled(true);
            } else {
                activityChooserView.aeE.setEnabled(false);
            }
            int hg = activityChooserView.aeA.aeR.mo66557hg();
            int historySize = activityChooserView.aeA.aeR.getHistorySize();
            if (hg == 1 || (hg > 1 && historySize > 0)) {
                activityChooserView.aeG.setVisibility(0);
                ResolveInfo hh = activityChooserView.aeA.aeR.mo66558hh();
                PackageManager packageManager = activityChooserView.getContext().getPackageManager();
                activityChooserView.aeH.setImageDrawable(hh.loadIcon(packageManager));
                if (activityChooserView.aeP != 0) {
                    CharSequence loadLabel = hh.loadLabel(packageManager);
                    activityChooserView.aeG.setContentDescription(activityChooserView.getContext().getString(activityChooserView.aeP, new Object[]{loadLabel}));
                }
            } else {
                activityChooserView.aeG.setVisibility(8);
            }
            if (activityChooserView.aeG.getVisibility() == 0) {
                activityChooserView.aeC.setBackgroundDrawable(activityChooserView.aeD);
            } else {
                activityChooserView.aeC.setBackgroundDrawable(null);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$b */
    class C8423b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        C8423b() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C31878a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.mo66271hr();
                    if (!ActivityChooserView.this.aeN) {
                        if (!ActivityChooserView.this.aeA.aeT) {
                            i++;
                        }
                        Intent bv = ActivityChooserView.this.aeA.aeR.mo66555bv(i);
                        if (bv != null) {
                            bv.addFlags(SQLiteGlobal.journalSizeLimit);
                            ActivityChooserView.this.getContext().startActivity(bv);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        C41538e c41538e = ActivityChooserView.this.aeA.aeR;
                        synchronized (c41538e.aen) {
                            float f;
                            c41538e.mo66559hj();
                            C37145a c37145a = (C37145a) c41538e.aeo.get(i);
                            C37145a c37145a2 = (C37145a) c41538e.aeo.get(0);
                            if (c37145a2 != null) {
                                f = (c37145a2.weight - c37145a.weight) + 5.0f;
                            } else {
                                f = 1.0f;
                            }
                            c41538e.mo66553a(new C31890c(new ComponentName(c37145a.resolveInfo.activityInfo.packageName, c37145a.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
                        }
                        return;
                    } else {
                        return;
                    }
                case 1:
                    ActivityChooserView.this.mo66267bw(BaseClientBuilder.API_PRIORITY_OTHER);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == ActivityChooserView.this.aeG) {
                ActivityChooserView.this.mo66271hr();
                Intent bv = ActivityChooserView.this.aeA.aeR.mo66555bv(ActivityChooserView.this.aeA.aeR.mo66552a(ActivityChooserView.this.aeA.aeR.mo66558hh()));
                if (bv != null) {
                    bv.addFlags(SQLiteGlobal.journalSizeLimit);
                    ActivityChooserView.this.getContext().startActivity(bv);
                }
            } else if (view == ActivityChooserView.this.aeE) {
                ActivityChooserView.this.aeN = false;
                ActivityChooserView.this.mo66267bw(ActivityChooserView.this.aeO);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.aeG) {
                if (ActivityChooserView.this.aeA.getCount() > 0) {
                    ActivityChooserView.this.aeN = true;
                    ActivityChooserView.this.mo66267bw(ActivityChooserView.this.aeO);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public final void onDismiss() {
            if (ActivityChooserView.this.aaN != null) {
                ActivityChooserView.this.aaN.onDismiss();
            }
            if (ActivityChooserView.this.aeJ != null) {
                ActivityChooserView.this.aeJ.mo1044E(false);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$1 */
    class C318751 extends DataSetObserver {
        C318751() {
        }

        public final void onChanged() {
            super.onChanged();
            ActivityChooserView.this.aeA.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.aeA.notifyDataSetInvalidated();
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$2 */
    class C318762 implements OnGlobalLayoutListener {
        C318762() {
        }

        public final void onGlobalLayout() {
            if (!ActivityChooserView.this.mo66272hs()) {
                return;
            }
            if (ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.getListPopupWindow().show();
                if (ActivityChooserView.this.aeJ != null) {
                    ActivityChooserView.this.aeJ.mo1044E(true);
                    return;
                }
                return;
            }
            ActivityChooserView.this.getListPopupWindow().dismiss();
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$3 */
    class C318773 extends AccessibilityDelegate {
        C318773() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            C0445b a = C0445b.m771a(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 19) {
                a.f546NG.setCanOpenPopup(true);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$InnerLayout */
    public static class InnerLayout extends LinearLayout {
        private static final int[] aaV = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0699bc a = C0699bc.m1554a(context, attributeSet, aaV);
            setBackgroundDrawable(a.getDrawable(0));
            a.atG.recycle();
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$a */
    class C31878a extends BaseAdapter {
        C41538e aeR;
        private int aeS = 4;
        boolean aeT;
        private boolean aeU;
        private boolean aeV;

        C31878a() {
        }

        public final int getItemViewType(int i) {
            if (this.aeV && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final int getCount() {
            int hg = this.aeR.mo66557hg();
            if (!(this.aeT || this.aeR.mo66558hh() == null)) {
                hg--;
            }
            hg = Math.min(hg, this.aeS);
            if (this.aeV) {
                return hg + 1;
            }
            return hg;
        }

        public final Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.aeT || this.aeR.mo66558hh() == null)) {
                        i++;
                    }
                    return this.aeR.mo66554bu(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != 2131820914) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(2130968591, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(2131820915)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(2131820678)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.aeT && i == 0 && this.aeU) {
                        view.setActivated(true);
                        return view;
                    }
                    view.setActivated(false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(2130968591, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(2131820678)).setText(ActivityChooserView.this.getContext().getString(C25738R.string.f8603e));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: ht */
        public final int mo51939ht() {
            int i = this.aeS;
            this.aeS = BaseClientBuilder.API_PRIORITY_OTHER;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i2 = 0;
            View view = null;
            int i3 = 0;
            while (i2 < count) {
                View view2 = getView(i2, view, null);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view2.getMeasuredWidth());
                i2++;
                view = view2;
            }
            this.aeS = i;
            return i3;
        }

        /* renamed from: bx */
        public final void mo51931bx(int i) {
            if (this.aeS != i) {
                this.aeS = i;
                notifyDataSetChanged();
            }
        }

        public final void setShowFooterView(boolean z) {
            if (this.aeV != z) {
                this.aeV = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: g */
        public final void mo51932g(boolean z, boolean z2) {
            if (this.aeT != z || this.aeU != z2) {
                this.aeT = z;
                this.aeU = z2;
                notifyDataSetChanged();
            }
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeK = new C318751();
        this.aeL = new C318762();
        this.aeO = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.ActivityChooserView, i, 0);
        this.aeO = obtainStyledAttributes.getInt(0, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(2130968590, this, true);
        this.aeB = new C8423b();
        this.aeC = findViewById(2131820911);
        this.aeD = this.aeC.getBackground();
        this.aeG = (FrameLayout) findViewById(2131820913);
        this.aeG.setOnClickListener(this.aeB);
        this.aeG.setOnLongClickListener(this.aeB);
        this.aeH = (ImageView) this.aeG.findViewById(2131820629);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131820912);
        frameLayout.setOnClickListener(this.aeB);
        frameLayout.setAccessibilityDelegate(new C318773());
        frameLayout.setOnTouchListener(new C0687ae(frameLayout) {
            /* renamed from: gm */
            public final C0632s mo1948gm() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: gn */
            public final boolean mo1949gn() {
                ActivityChooserView.this.mo66270hq();
                return true;
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: hc */
            public final boolean mo1950hc() {
                ActivityChooserView.this.mo66271hr();
                return true;
            }
        });
        this.aeE = frameLayout;
        this.aeF = (ImageView) frameLayout.findViewById(2131820629);
        this.aeF.setImageDrawable(drawable);
        this.aeA = new C31878a();
        this.aeA.registerDataSetObserver(new C06445());
        Resources resources = context.getResources();
        this.aeI = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C25738R.dimen.f9648a6));
    }

    public void setActivityChooserModel(C41538e c41538e) {
        C31878a c31878a = this.aeA;
        C41538e c41538e2 = ActivityChooserView.this.aeA.aeR;
        if (c41538e2 != null && ActivityChooserView.this.isShown()) {
            c41538e2.unregisterObserver(ActivityChooserView.this.aeK);
        }
        c31878a.aeR = c41538e;
        if (c41538e != null && ActivityChooserView.this.isShown()) {
            c41538e.registerObserver(ActivityChooserView.this.aeK);
        }
        c31878a.notifyDataSetChanged();
        if (getListPopupWindow().amH.isShowing()) {
            mo66271hr();
            mo66270hq();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.aeF.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.aeF.setContentDescription(getContext().getString(i));
    }

    public void setProvider(C0455b c0455b) {
        this.aeJ = c0455b;
    }

    /* renamed from: hq */
    public final boolean mo66270hq() {
        if (getListPopupWindow().amH.isShowing() || !this.f16845pv) {
            return false;
        }
        this.aeN = false;
        mo66267bw(this.aeO);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bw */
    public final void mo66267bw(int i) {
        if (this.aeA.aeR == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.aeL);
        boolean z = this.aeG.getVisibility() == 0;
        int hg = this.aeA.aeR.mo66557hg();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == BaseClientBuilder.API_PRIORITY_OTHER || hg <= i2 + i) {
            this.aeA.setShowFooterView(false);
            this.aeA.mo51931bx(i);
        } else {
            this.aeA.setShowFooterView(true);
            this.aeA.mo51931bx(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.amH.isShowing()) {
            if (this.aeN || !z) {
                this.aeA.mo51932g(true, z);
            } else {
                this.aeA.mo51932g(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.aeA.mo51939ht(), this.aeI));
            listPopupWindow.show();
            if (this.aeJ != null) {
                this.aeJ.mo1044E(true);
            }
            listPopupWindow.amk.setContentDescription(getContext().getString(C25738R.string.f8604f));
            listPopupWindow.amk.setSelector(new ColorDrawable(0));
        }
    }

    /* renamed from: hs */
    public final boolean mo66272hs() {
        return getListPopupWindow().amH.isShowing();
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C41538e c41538e = this.aeA.aeR;
        if (c41538e != null) {
            c41538e.registerObserver(this.aeK);
        }
        this.f16845pv = true;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C41538e c41538e = this.aeA.aeR;
        if (c41538e != null) {
            c41538e.unregisterObserver(this.aeK);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.aeL);
        }
        if (mo66272hs()) {
            mo66271hr();
        }
        this.f16845pv = false;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        View view = this.aeC;
        if (this.aeG.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), ErrorDialogData.SUPPRESSED);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.aeC.layout(0, 0, i3 - i, i4 - i2);
        if (!mo66272hs()) {
            mo66271hr();
        }
    }

    public C41538e getDataModel() {
        return this.aeA.aeR;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.aaN = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.aeO = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.aeP = i;
    }

    /* Access modifiers changed, original: 0000 */
    public ListPopupWindow getListPopupWindow() {
        if (this.aeM == null) {
            this.aeM = new ListPopupWindow(getContext());
            this.aeM.setAdapter(this.aeA);
            this.aeM.amx = this;
            this.aeM.setModal(true);
            this.aeM.amz = this.aeB;
            this.aeM.setOnDismissListener(this.aeB);
        }
        return this.aeM;
    }

    /* renamed from: hr */
    public final boolean mo66271hr() {
        if (getListPopupWindow().amH.isShowing()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.aeL);
            }
        }
        return true;
    }
}
