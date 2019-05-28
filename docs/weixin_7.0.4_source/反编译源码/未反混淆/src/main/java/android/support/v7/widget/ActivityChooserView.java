package android.support.v7.widget;

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
import android.support.v7.view.menu.s;
import android.support.v7.widget.e.c;
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
import com.tencent.mm.R;
import com.tencent.wcdb.database.SQLiteGlobal;

public class ActivityChooserView extends ViewGroup {
    OnDismissListener aaN;
    final a aeA;
    private final b aeB;
    final View aeC;
    final Drawable aeD;
    final FrameLayout aeE;
    private final ImageView aeF;
    final FrameLayout aeG;
    final ImageView aeH;
    private final int aeI;
    android.support.v4.view.b aeJ;
    final DataSetObserver aeK;
    private final OnGlobalLayoutListener aeL;
    private ListPopupWindow aeM;
    boolean aeN;
    int aeO;
    int aeP;
    private boolean pv;

    class b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        b() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.hr();
                    if (!ActivityChooserView.this.aeN) {
                        if (!ActivityChooserView.this.aeA.aeT) {
                            i++;
                        }
                        Intent bv = ActivityChooserView.this.aeA.aeR.bv(i);
                        if (bv != null) {
                            bv.addFlags(SQLiteGlobal.journalSizeLimit);
                            ActivityChooserView.this.getContext().startActivity(bv);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        e eVar = ActivityChooserView.this.aeA.aeR;
                        synchronized (eVar.aen) {
                            float f;
                            eVar.hj();
                            android.support.v7.widget.e.a aVar = (android.support.v7.widget.e.a) eVar.aeo.get(i);
                            android.support.v7.widget.e.a aVar2 = (android.support.v7.widget.e.a) eVar.aeo.get(0);
                            if (aVar2 != null) {
                                f = (aVar2.weight - aVar.weight) + 5.0f;
                            } else {
                                f = 1.0f;
                            }
                            eVar.a(new c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
                        }
                        return;
                    } else {
                        return;
                    }
                case 1:
                    ActivityChooserView.this.bw(BaseClientBuilder.API_PRIORITY_OTHER);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == ActivityChooserView.this.aeG) {
                ActivityChooserView.this.hr();
                Intent bv = ActivityChooserView.this.aeA.aeR.bv(ActivityChooserView.this.aeA.aeR.a(ActivityChooserView.this.aeA.aeR.hh()));
                if (bv != null) {
                    bv.addFlags(SQLiteGlobal.journalSizeLimit);
                    ActivityChooserView.this.getContext().startActivity(bv);
                }
            } else if (view == ActivityChooserView.this.aeE) {
                ActivityChooserView.this.aeN = false;
                ActivityChooserView.this.bw(ActivityChooserView.this.aeO);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.aeG) {
                if (ActivityChooserView.this.aeA.getCount() > 0) {
                    ActivityChooserView.this.aeN = true;
                    ActivityChooserView.this.bw(ActivityChooserView.this.aeO);
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
                ActivityChooserView.this.aeJ.E(false);
            }
        }
    }

    public static class InnerLayout extends LinearLayout {
        private static final int[] aaV = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            bc a = bc.a(context, attributeSet, aaV);
            setBackgroundDrawable(a.getDrawable(0));
            a.atG.recycle();
        }
    }

    class a extends BaseAdapter {
        e aeR;
        private int aeS = 4;
        boolean aeT;
        private boolean aeU;
        private boolean aeV;

        a() {
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
            int hg = this.aeR.hg();
            if (!(this.aeT || this.aeR.hh() == null)) {
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
                    if (!(this.aeT || this.aeR.hh() == null)) {
                        i++;
                    }
                    return this.aeR.bu(i);
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
                    if (view == null || view.getId() != R.id.ja) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.p, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(R.id.jb)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(R.id.cx)).setText(resolveInfo.loadLabel(packageManager));
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
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.p, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(R.id.cx)).setText(ActivityChooserView.this.getContext().getString(R.string.e));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final int ht() {
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

        public final void bx(int i) {
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

        public final void g(boolean z, boolean z2) {
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
        this.aeK = new DataSetObserver() {
            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.this.aeA.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.aeA.notifyDataSetInvalidated();
            }
        };
        this.aeL = new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (!ActivityChooserView.this.hs()) {
                    return;
                }
                if (ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().show();
                    if (ActivityChooserView.this.aeJ != null) {
                        ActivityChooserView.this.aeJ.E(true);
                        return;
                    }
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().dismiss();
            }
        };
        this.aeO = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.a.ActivityChooserView, i, 0);
        this.aeO = obtainStyledAttributes.getInt(0, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.o, this, true);
        this.aeB = new b();
        this.aeC = findViewById(R.id.j8);
        this.aeD = this.aeC.getBackground();
        this.aeG = (FrameLayout) findViewById(R.id.j_);
        this.aeG.setOnClickListener(this.aeB);
        this.aeG.setOnLongClickListener(this.aeB);
        this.aeH = (ImageView) this.aeG.findViewById(R.id.bl);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.j9);
        frameLayout.setOnClickListener(this.aeB);
        frameLayout.setAccessibilityDelegate(new AccessibilityDelegate() {
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                android.support.v4.view.a.b a = android.support.v4.view.a.b.a(accessibilityNodeInfo);
                if (VERSION.SDK_INT >= 19) {
                    a.NG.setCanOpenPopup(true);
                }
            }
        });
        frameLayout.setOnTouchListener(new ae(frameLayout) {
            public final s gm() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* Access modifiers changed, original: protected|final */
            public final boolean gn() {
                ActivityChooserView.this.hq();
                return true;
            }

            /* Access modifiers changed, original: protected|final */
            public final boolean hc() {
                ActivityChooserView.this.hr();
                return true;
            }
        });
        this.aeE = frameLayout;
        this.aeF = (ImageView) frameLayout.findViewById(R.id.bl);
        this.aeF.setImageDrawable(drawable);
        this.aeA = new a();
        this.aeA.registerDataSetObserver(new DataSetObserver() {
            public final void onChanged() {
                super.onChanged();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (activityChooserView.aeA.getCount() > 0) {
                    activityChooserView.aeE.setEnabled(true);
                } else {
                    activityChooserView.aeE.setEnabled(false);
                }
                int hg = activityChooserView.aeA.aeR.hg();
                int historySize = activityChooserView.aeA.aeR.getHistorySize();
                if (hg == 1 || (hg > 1 && historySize > 0)) {
                    activityChooserView.aeG.setVisibility(0);
                    ResolveInfo hh = activityChooserView.aeA.aeR.hh();
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
        });
        Resources resources = context.getResources();
        this.aeI = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.a6));
    }

    public void setActivityChooserModel(e eVar) {
        a aVar = this.aeA;
        e eVar2 = ActivityChooserView.this.aeA.aeR;
        if (eVar2 != null && ActivityChooserView.this.isShown()) {
            eVar2.unregisterObserver(ActivityChooserView.this.aeK);
        }
        aVar.aeR = eVar;
        if (eVar != null && ActivityChooserView.this.isShown()) {
            eVar.registerObserver(ActivityChooserView.this.aeK);
        }
        aVar.notifyDataSetChanged();
        if (getListPopupWindow().amH.isShowing()) {
            hr();
            hq();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.aeF.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.aeF.setContentDescription(getContext().getString(i));
    }

    public void setProvider(android.support.v4.view.b bVar) {
        this.aeJ = bVar;
    }

    public final boolean hq() {
        if (getListPopupWindow().amH.isShowing() || !this.pv) {
            return false;
        }
        this.aeN = false;
        bw(this.aeO);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void bw(int i) {
        if (this.aeA.aeR == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.aeL);
        boolean z = this.aeG.getVisibility() == 0;
        int hg = this.aeA.aeR.hg();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == BaseClientBuilder.API_PRIORITY_OTHER || hg <= i2 + i) {
            this.aeA.setShowFooterView(false);
            this.aeA.bx(i);
        } else {
            this.aeA.setShowFooterView(true);
            this.aeA.bx(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.amH.isShowing()) {
            if (this.aeN || !z) {
                this.aeA.g(true, z);
            } else {
                this.aeA.g(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.aeA.ht(), this.aeI));
            listPopupWindow.show();
            if (this.aeJ != null) {
                this.aeJ.E(true);
            }
            listPopupWindow.amk.setContentDescription(getContext().getString(R.string.f));
            listPopupWindow.amk.setSelector(new ColorDrawable(0));
        }
    }

    public final boolean hs() {
        return getListPopupWindow().amH.isShowing();
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e eVar = this.aeA.aeR;
        if (eVar != null) {
            eVar.registerObserver(this.aeK);
        }
        this.pv = true;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.aeA.aeR;
        if (eVar != null) {
            eVar.unregisterObserver(this.aeK);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.aeL);
        }
        if (hs()) {
            hr();
        }
        this.pv = false;
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
        if (!hs()) {
            hr();
        }
    }

    public e getDataModel() {
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

    public final boolean hr() {
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
