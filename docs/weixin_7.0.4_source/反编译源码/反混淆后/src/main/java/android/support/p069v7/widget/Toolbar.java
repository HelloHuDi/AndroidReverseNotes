package android.support.p069v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0460f;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.app.ActionBar;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.C0605c;
import android.support.p069v7.view.C0611g;
import android.support.p069v7.view.menu.C0628o;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.view.menu.C7459u;
import android.support.p069v7.widget.ActionMenuView.C0643d;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.Toolbar */
public class Toolbar extends ViewGroup {
    /* renamed from: Hu */
    private int f1002Hu;
    /* renamed from: XT */
    private int f1003XT;
    private boolean acA;
    private boolean acB;
    Context acv;
    ActionMenuView acw;
    int adW;
    C0627a adY;
    C0623a adZ;
    TextView atH;
    TextView atI;
    private ImageButton atJ;
    private ImageView atK;
    Drawable atL;
    CharSequence atM;
    ImageButton atN;
    View atO;
    int atP;
    int atQ;
    int atR;
    private int atS;
    private int atT;
    private int atU;
    private int atV;
    private int atW;
    C0691as atX;
    private int atY;
    private int atZ;
    private CharSequence aua;
    private CharSequence aub;
    private int auc;
    private final ArrayList<View> aud;
    final ArrayList<View> aue;
    private final int[] auf;
    C0669b aug;
    private final C0643d auh;
    private C6256bd aui;
    ActionMenuPresenter auj;
    C0671a auk;
    private final Runnable aul;
    /* renamed from: mr */
    private boolean f1004mr;

    /* renamed from: android.support.v7.widget.Toolbar$2 */
    class C06662 implements Runnable {
        C06662() {
        }

        public final void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$3 */
    class C06673 implements OnClickListener {
        C06673() {
        }

        public final void onClick(View view) {
            Toolbar.this.collapseActionView();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$b */
    public interface C0669b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.Toolbar$1 */
    class C06701 implements C0643d {
        C06701() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.aug != null) {
                return Toolbar.this.aug.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$LayoutParams */
    public static class LayoutParams extends android.support.p069v7.app.ActionBar.LayoutParams {
        int auo;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.auo = 0;
        }

        public LayoutParams() {
            this.auo = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.p069v7.app.ActionBar.LayoutParams) layoutParams);
            this.auo = 0;
            this.auo = layoutParams.auo;
        }

        public LayoutParams(android.support.p069v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.auo = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.auo = 0;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.auo = 0;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$SavedState */
    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C06681();
        int aup;
        boolean auq;

        /* renamed from: android.support.v7.widget.Toolbar$SavedState$1 */
        static class C06681 implements ClassLoaderCreator<SavedState> {
            C06681() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.aup = parcel.readInt();
            this.auq = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aup);
            parcel.writeInt(this.auq ? 1 : 0);
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$a */
    class C0671a implements C0628o {
        C6239j aun;
        /* renamed from: lo */
        C6236h f1005lo;

        C0671a() {
        }

        /* renamed from: a */
        public final void mo1598a(Context context, C6236h c6236h) {
            if (!(this.f1005lo == null || this.aun == null)) {
                this.f1005lo.mo14149h(this.aun);
            }
            this.f1005lo = c6236h;
        }

        /* renamed from: n */
        public final void mo1606n(boolean z) {
            Object obj = null;
            if (this.aun != null) {
                if (this.f1005lo != null) {
                    int size = this.f1005lo.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f1005lo.getItem(i) == this.aun) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo1604c(this.aun);
                }
            }
        }

        /* renamed from: a */
        public final void mo1600a(C0627a c0627a) {
        }

        /* renamed from: a */
        public final boolean mo1601a(C7459u c7459u) {
            return false;
        }

        /* renamed from: a */
        public final void mo1599a(C6236h c6236h, boolean z) {
        }

        /* renamed from: bt */
        public final boolean mo1603bt() {
            return false;
        }

        /* renamed from: b */
        public final boolean mo1602b(C6239j c6239j) {
            Toolbar toolbar = Toolbar.this;
            if (toolbar.atN == null) {
                toolbar.atN = new AppCompatImageButton(toolbar.getContext(), null, C25738R.attr.f5656ey);
                toolbar.atN.setImageDrawable(toolbar.atL);
                toolbar.atN.setContentDescription(toolbar.atM);
                LayoutParams layoutParams = new LayoutParams();
                layoutParams.gravity = (toolbar.atR & 112) | 8388611;
                layoutParams.auo = 2;
                toolbar.atN.setLayoutParams(layoutParams);
                toolbar.atN.setOnClickListener(new C06673());
            }
            ViewParent parent = Toolbar.this.atN.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.atN);
                }
                Toolbar.this.addView(Toolbar.this.atN);
            }
            Toolbar.this.atO = c6239j.getActionView();
            this.aun = c6239j;
            parent = Toolbar.this.atO.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.atO);
                }
                LayoutParams lo = Toolbar.m1502lo();
                lo.gravity = (Toolbar.this.atR & 112) | 8388611;
                lo.auo = 2;
                Toolbar.this.atO.setLayoutParams(lo);
                Toolbar.this.addView(Toolbar.this.atO);
            }
            Toolbar toolbar2 = Toolbar.this;
            for (int childCount = toolbar2.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar2.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).auo == 2 || childAt == toolbar2.acw)) {
                    toolbar2.removeViewAt(childCount);
                    toolbar2.aue.add(childAt);
                }
            }
            Toolbar.this.requestLayout();
            c6239j.mo14168Z(true);
            if (Toolbar.this.atO instanceof C0605c) {
                ((C0605c) Toolbar.this.atO).onActionViewExpanded();
            }
            return true;
        }

        /* renamed from: c */
        public final boolean mo1604c(C6239j c6239j) {
            if (Toolbar.this.atO instanceof C0605c) {
                ((C0605c) Toolbar.this.atO).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.atO);
            Toolbar.this.removeView(Toolbar.this.atN);
            Toolbar.this.atO = null;
            Toolbar.this.mo1868lp();
            this.aun = null;
            Toolbar.this.requestLayout();
            c6239j.mo14168Z(false);
            return true;
        }

        public final int getId() {
            return 0;
        }

        public final Parcelable onSaveInstanceState() {
            return null;
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5655ex);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1002Hu = 8388627;
        this.aud = new ArrayList();
        this.aue = new ArrayList();
        this.auf = new int[2];
        this.auh = new C06701();
        this.aul = new C06662();
        C0699bc a = C0699bc.m1555a(getContext(), attributeSet, C0554a.Toolbar, i, 0);
        this.atP = a.getResourceId(12, 0);
        this.atQ = a.getResourceId(13, 0);
        this.f1002Hu = a.getInteger(0, this.f1002Hu);
        this.atR = a.getInteger(21, 48);
        int dimensionPixelOffset = a.getDimensionPixelOffset(14, 0);
        if (a.hasValue(19)) {
            dimensionPixelOffset = a.getDimensionPixelOffset(19, dimensionPixelOffset);
        }
        this.atW = dimensionPixelOffset;
        this.atV = dimensionPixelOffset;
        this.atU = dimensionPixelOffset;
        this.atT = dimensionPixelOffset;
        dimensionPixelOffset = a.getDimensionPixelOffset(15, -1);
        if (dimensionPixelOffset >= 0) {
            this.atT = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(16, -1);
        if (dimensionPixelOffset >= 0) {
            this.atU = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(17, -1);
        if (dimensionPixelOffset >= 0) {
            this.atV = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(18, -1);
        if (dimensionPixelOffset >= 0) {
            this.atW = dimensionPixelOffset;
        }
        this.atS = a.getDimensionPixelSize(20, -1);
        dimensionPixelOffset = a.getDimensionPixelOffset(5, C8415j.INVALID_ID);
        int dimensionPixelOffset2 = a.getDimensionPixelOffset(6, C8415j.INVALID_ID);
        int dimensionPixelSize = a.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = a.getDimensionPixelSize(8, 0);
        mo1869lq();
        C0691as c0691as = this.atX;
        c0691as.aqp = false;
        if (dimensionPixelSize != C8415j.INVALID_ID) {
            c0691as.aqn = dimensionPixelSize;
            c0691as.f1011xJ = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != C8415j.INVALID_ID) {
            c0691as.aqo = dimensionPixelSize2;
            c0691as.f1012xM = dimensionPixelSize2;
        }
        if (!(dimensionPixelOffset == C8415j.INVALID_ID && dimensionPixelOffset2 == C8415j.INVALID_ID)) {
            this.atX.mo2003aI(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.atY = a.getDimensionPixelOffset(9, C8415j.INVALID_ID);
        this.atZ = a.getDimensionPixelOffset(10, C8415j.INVALID_ID);
        this.atL = a.getDrawable(22);
        this.atM = a.getText(23);
        CharSequence text = a.getText(2);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = a.getText(3);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.acv = getContext();
        setPopupTheme(a.getResourceId(11, 0));
        Drawable drawable = a.getDrawable(24);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = a.getText(25);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = a.getDrawable(4);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = a.getText(26);
        if (!TextUtils.isEmpty(text)) {
            setLogoDescription(text);
        }
        if (a.hasValue(27)) {
            setTitleTextColor(a.getColor(27, -1));
        }
        if (a.hasValue(28)) {
            setSubtitleTextColor(a.getColor(28, -1));
        }
        a.atG.recycle();
    }

    public void setPopupTheme(int i) {
        if (this.adW != i) {
            this.adW = i;
            if (i == 0) {
                this.acv = getContext();
            } else {
                this.acv = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.adW;
    }

    public int getTitleMarginStart() {
        return this.atT;
    }

    public void setTitleMarginStart(int i) {
        this.atT = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.atV;
    }

    public void setTitleMarginTop(int i) {
        this.atV = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.atU;
    }

    public void setTitleMarginEnd(int i) {
        this.atU = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.atW;
    }

    public void setTitleMarginBottom(int i) {
        this.atW = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        mo1869lq();
        C0691as c0691as = this.atX;
        if (i != 1) {
            z = false;
        }
        if (z != c0691as.f1010hq) {
            c0691as.f1010hq = z;
            if (!c0691as.aqp) {
                c0691as.f1011xJ = c0691as.aqn;
                c0691as.f1012xM = c0691as.aqo;
            } else if (z) {
                c0691as.f1011xJ = c0691as.f1009Ls != C8415j.INVALID_ID ? c0691as.f1009Ls : c0691as.aqn;
                c0691as.f1012xM = c0691as.aqm != C8415j.INVALID_ID ? c0691as.aqm : c0691as.aqo;
            } else {
                c0691as.f1011xJ = c0691as.aqm != C8415j.INVALID_ID ? c0691as.aqm : c0691as.aqn;
                c0691as.f1012xM = c0691as.f1009Ls != C8415j.INVALID_ID ? c0691as.f1009Ls : c0691as.aqo;
            }
        }
    }

    public void setLogo(int i) {
        setLogo(C0589b.m1275g(getContext(), i));
    }

    public final boolean isOverflowMenuShowing() {
        if (this.acw != null) {
            boolean z;
            ActionMenuView actionMenuView = this.acw;
            if (actionMenuView.adX == null || !actionMenuView.adX.isOverflowMenuShowing()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        if (this.acw != null) {
            boolean z;
            ActionMenuView actionMenuView = this.acw;
            if (actionMenuView.adX == null || !actionMenuView.adX.showOverflowMenu()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m1499lk();
            if (!m1493bT(this.atK)) {
                m1497i(this.atK, true);
            }
        } else if (this.atK != null && m1493bT(this.atK)) {
            removeView(this.atK);
            this.aue.remove(this.atK);
        }
        if (this.atK != null) {
            this.atK.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.atK != null ? this.atK.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1499lk();
        }
        if (this.atK != null) {
            this.atK.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.atK != null ? this.atK.getContentDescription() : null;
    }

    /* renamed from: lk */
    private void m1499lk() {
        if (this.atK == null) {
            this.atK = new AppCompatImageView(getContext());
        }
    }

    public final void collapseActionView() {
        C6239j c6239j = this.auk == null ? null : this.auk.aun;
        if (c6239j != null) {
            c6239j.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.aua;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.atH == null) {
                Context context = getContext();
                this.atH = new AppCompatTextView(context);
                this.atH.setSingleLine();
                this.atH.setEllipsize(TruncateAt.END);
                if (this.atP != 0) {
                    this.atH.setTextAppearance(context, this.atP);
                }
                if (this.f1003XT != 0) {
                    this.atH.setTextColor(this.f1003XT);
                }
            }
            if (!m1493bT(this.atH)) {
                m1497i(this.atH, true);
            }
        } else if (this.atH != null && m1493bT(this.atH)) {
            removeView(this.atH);
            this.aue.remove(this.atH);
        }
        if (this.atH != null) {
            this.atH.setText(charSequence);
        }
        this.aua = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.aub;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.atI == null) {
                Context context = getContext();
                this.atI = new AppCompatTextView(context);
                this.atI.setSingleLine();
                this.atI.setEllipsize(TruncateAt.END);
                if (this.atQ != 0) {
                    this.atI.setTextAppearance(context, this.atQ);
                }
                if (this.auc != 0) {
                    this.atI.setTextColor(this.auc);
                }
            }
            if (!m1493bT(this.atI)) {
                m1497i(this.atI, true);
            }
        } else if (this.atI != null && m1493bT(this.atI)) {
            removeView(this.atI);
            this.aue.remove(this.atI);
        }
        if (this.atI != null) {
            this.atI.setText(charSequence);
        }
        this.aub = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.f1003XT = i;
        if (this.atH != null) {
            this.atH.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.auc = i;
        if (this.atI != null) {
            this.atI.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.atJ != null ? this.atJ.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1501ln();
        }
        if (this.atJ != null) {
            this.atJ.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C0589b.m1275g(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m1501ln();
            if (!m1493bT(this.atJ)) {
                m1497i(this.atJ, true);
            }
        } else if (this.atJ != null && m1493bT(this.atJ)) {
            removeView(this.atJ);
            this.aue.remove(this.atJ);
        }
        if (this.atJ != null) {
            this.atJ.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.atJ != null ? this.atJ.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m1501ln();
        this.atJ.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m1500ll();
        return this.acw.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m1500ll();
        this.acw.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m1500ll();
        return this.acw.getOverflowIcon();
    }

    /* renamed from: ll */
    private void m1500ll() {
        mo1867lm();
        if (this.acw.f1937lo == null) {
            C6236h c6236h = (C6236h) this.acw.getMenu();
            if (this.auk == null) {
                this.auk = new C0671a();
            }
            this.acw.setExpandedActionViewsExclusive(true);
            c6236h.mo14115a(this.auk, this.acv);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: lm */
    public final void mo1867lm() {
        if (this.acw == null) {
            this.acw = new ActionMenuView(getContext());
            this.acw.setPopupTheme(this.adW);
            this.acw.setOnMenuItemClickListener(this.auh);
            this.acw.mo14272a(this.adY, this.adZ);
            LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388613 | (this.atR & 112);
            this.acw.setLayoutParams(layoutParams);
            m1497i(this.acw, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0611g(getContext());
    }

    public void setOnMenuItemClickListener(C0669b c0669b) {
        this.aug = c0669b;
    }

    public int getContentInsetStart() {
        if (this.atX == null) {
            return 0;
        }
        C0691as c0691as = this.atX;
        return c0691as.f1010hq ? c0691as.f1012xM : c0691as.f1011xJ;
    }

    public int getContentInsetEnd() {
        if (this.atX == null) {
            return 0;
        }
        C0691as c0691as = this.atX;
        return c0691as.f1010hq ? c0691as.f1011xJ : c0691as.f1012xM;
    }

    public int getContentInsetLeft() {
        if (this.atX != null) {
            return this.atX.f1011xJ;
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.atX != null) {
            return this.atX.f1012xM;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.atY != C8415j.INVALID_ID) {
            return this.atY;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = C8415j.INVALID_ID;
        }
        if (i != this.atY) {
            this.atY = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.atZ != C8415j.INVALID_ID) {
            return this.atZ;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = C8415j.INVALID_ID;
        }
        if (i != this.atZ) {
            this.atZ = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.atY, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.acw != null) {
            C6236h c6236h = this.acw.f1937lo;
            i = (c6236h == null || !c6236h.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return Math.max(getContentInsetEnd(), Math.max(this.atZ, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (C0477s.m893T(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (C0477s.m893T(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    /* renamed from: ln */
    private void m1501ln() {
        if (this.atJ == null) {
            this.atJ = new AppCompatImageButton(getContext(), null, C25738R.attr.f5656ey);
            LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (this.atR & 112);
            this.atJ.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: i */
    private void m1497i(View view, boolean z) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams2)) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = Toolbar.m1496e(layoutParams2);
        }
        layoutParams.auo = 1;
        if (!z || this.atO == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.aue.add(view);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.auk == null || this.auk.aun == null)) {
            savedState.aup = this.auk.aun.getItemId();
        }
        savedState.auq = isOverflowMenuShowing();
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            Menu menu;
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.f507LC);
            if (this.acw != null) {
                menu = this.acw.f1937lo;
            } else {
                menu = null;
            }
            if (!(savedState.aup == 0 || this.auk == null || menu == null)) {
                MenuItem findItem = menu.findItem(savedState.aup);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (savedState.auq) {
                removeCallbacks(this.aul);
                post(this.aul);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.aul);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.acA = false;
        }
        if (!this.acA) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.acA = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.acA = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.acB = false;
        }
        if (!this.acB) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.acB = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.acB = false;
        }
        return true;
    }

    /* renamed from: l */
    private void m1498l(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = Toolbar.getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = Toolbar.getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != ErrorDialogData.SUPPRESSED && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, ErrorDialogData.SUPPRESSED);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: a */
    private int m1486a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(Toolbar.getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), Toolbar.getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int combineMeasuredStates;
        int i5;
        Object obj;
        int[] iArr = this.auf;
        if (C0709bk.m1576bW(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (m1490bQ(this.atJ)) {
            m1498l(this.atJ, i, 0, i2, this.atS);
            i6 = this.atJ.getMeasuredWidth() + Toolbar.m1491bR(this.atJ);
            max = Math.max(0, this.atJ.getMeasuredHeight() + Toolbar.m1492bS(this.atJ));
            combineMeasuredStates = View.combineMeasuredStates(0, this.atJ.getMeasuredState());
            i5 = max;
        } else {
            combineMeasuredStates = 0;
            i5 = 0;
        }
        if (m1490bQ(this.atN)) {
            m1498l(this.atN, i, 0, i2, this.atS);
            i6 = this.atN.getMeasuredWidth() + Toolbar.m1491bR(this.atN);
            i5 = Math.max(i5, this.atN.getMeasuredHeight() + Toolbar.m1492bS(this.atN));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.atN.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = Math.max(currentContentInsetStart, i6) + 0;
        iArr[i4] = Math.max(0, currentContentInsetStart - i6);
        i6 = 0;
        if (m1490bQ(this.acw)) {
            m1498l(this.acw, i, max2, i2, this.atS);
            i6 = this.acw.getMeasuredWidth() + Toolbar.m1491bR(this.acw);
            i5 = Math.max(i5, this.acw.getMeasuredHeight() + Toolbar.m1492bS(this.acw));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.acw.getMeasuredState());
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i6);
        iArr[i3] = Math.max(0, currentContentInsetStart - i6);
        if (m1490bQ(this.atO)) {
            max2 += m1486a(this.atO, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.atO.getMeasuredHeight() + Toolbar.m1492bS(this.atO));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.atO.getMeasuredState());
        }
        if (m1490bQ(this.atK)) {
            max2 += m1486a(this.atK, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.atK.getMeasuredHeight() + Toolbar.m1492bS(this.atK));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.atK.getMeasuredState());
        }
        i4 = getChildCount();
        i3 = 0;
        int i7 = combineMeasuredStates;
        int i8 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).auo == 0 && m1490bQ(childAt)) {
                max2 += m1486a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + Toolbar.m1492bS(childAt));
                i6 = View.combineMeasuredStates(i7, childAt.getMeasuredState());
                currentContentInsetStart = max;
            } else {
                i6 = i7;
                currentContentInsetStart = i8;
            }
            i3++;
            i7 = i6;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i6 = 0;
        int i9 = this.atV + this.atW;
        max = this.atT + this.atU;
        if (m1490bQ(this.atH)) {
            m1486a(this.atH, i, max2 + max, i2, i9, iArr);
            currentContentInsetStart = Toolbar.m1491bR(this.atH) + this.atH.getMeasuredWidth();
            i6 = this.atH.getMeasuredHeight() + Toolbar.m1492bS(this.atH);
            i7 = View.combineMeasuredStates(i7, this.atH.getMeasuredState());
        }
        if (m1490bQ(this.atI)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, m1486a(this.atI, i, max2 + max, i2, i9 + i6, iArr));
            i6 += this.atI.getMeasuredHeight() + Toolbar.m1492bS(this.atI);
            i7 = View.combineMeasuredStates(i7, this.atI.getMeasuredState());
        }
        currentContentInsetStart += max2;
        i6 = Math.max(i8, i6) + (getPaddingTop() + getPaddingBottom());
        int i10 = i;
        max = View.resolveSizeAndState(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i10, WebView.NIGHT_MODE_COLOR & i7);
        i6 = View.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (this.f1004mr) {
            max2 = getChildCount();
            for (currentContentInsetStart = 0; currentContentInsetStart < max2; currentContentInsetStart++) {
                View childAt2 = getChildAt(currentContentInsetStart);
                if (m1490bQ(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i6 = 0;
        }
        setMeasuredDimension(max, i6);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        LayoutParams layoutParams;
        int measuredHeight;
        int paddingTop;
        int measuredWidth;
        if (C0477s.m893T(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = width - paddingRight;
        int[] iArr = this.auf;
        iArr[1] = 0;
        iArr[0] = 0;
        int aa = C0477s.m909aa(this);
        int min = aa >= 0 ? Math.min(aa, i4 - i2) : 0;
        if (!m1490bQ(this.atJ)) {
            aa = i6;
            i5 = paddingLeft;
        } else if (obj != null) {
            aa = m1488b(this.atJ, i6, iArr, min);
            i5 = paddingLeft;
        } else {
            i5 = m1487a(this.atJ, paddingLeft, iArr, min);
            aa = i6;
        }
        if (m1490bQ(this.atN)) {
            if (obj != null) {
                aa = m1488b(this.atN, aa, iArr, min);
            } else {
                i5 = m1487a(this.atN, i5, iArr, min);
            }
        }
        if (m1490bQ(this.acw)) {
            if (obj != null) {
                i5 = m1487a(this.acw, i5, iArr, min);
            } else {
                aa = m1488b(this.acw, aa, iArr, min);
            }
        }
        i6 = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, i6 - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - aa));
        i6 = Math.max(i5, i6);
        aa = Math.min(aa, (width - paddingRight) - currentContentInsetRight);
        if (m1490bQ(this.atO)) {
            if (obj != null) {
                aa = m1488b(this.atO, aa, iArr, min);
            } else {
                i6 = m1487a(this.atO, i6, iArr, min);
            }
        }
        if (!m1490bQ(this.atK)) {
            i5 = aa;
            currentContentInsetRight = i6;
        } else if (obj != null) {
            i5 = m1488b(this.atK, aa, iArr, min);
            currentContentInsetRight = i6;
        } else {
            i5 = aa;
            currentContentInsetRight = m1487a(this.atK, i6, iArr, min);
        }
        boolean bQ = m1490bQ(this.atH);
        boolean bQ2 = m1490bQ(this.atI);
        i6 = 0;
        if (bQ) {
            layoutParams = (LayoutParams) this.atH.getLayoutParams();
            i6 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.atH.getMeasuredHeight())) + 0;
        }
        if (bQ2) {
            layoutParams = (LayoutParams) this.atI.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.atI.getMeasuredHeight())) + i6;
        } else {
            measuredHeight = i6;
        }
        if (bQ || bQ2) {
            layoutParams = (LayoutParams) (bQ ? this.atH : this.atI).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (bQ2 ? this.atI : this.atH).getLayoutParams();
            Object obj2 = ((!bQ || this.atH.getMeasuredWidth() <= 0) && (!bQ2 || this.atI.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f1002Hu & 112) {
                case 48:
                    paddingTop = (layoutParams.topMargin + getPaddingTop()) + this.atV;
                    break;
                case 80:
                    paddingTop = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.atW) - measuredHeight;
                    break;
                default:
                    paddingTop = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop < layoutParams.topMargin + this.atV) {
                        aa = layoutParams.topMargin + this.atV;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop) - paddingTop2;
                        if (measuredHeight < layoutParams.bottomMargin + this.atW) {
                            aa = Math.max(0, paddingTop - ((layoutParams2.bottomMargin + this.atW) - measuredHeight));
                        } else {
                            aa = paddingTop;
                        }
                    }
                    paddingTop = paddingTop2 + aa;
                    break;
            }
            if (obj != null) {
                aa = (obj2 != null ? this.atT : 0) - iArr[1];
                i6 = i5 - Math.max(0, aa);
                iArr[1] = Math.max(0, -aa);
                if (bQ) {
                    layoutParams = (LayoutParams) this.atH.getLayoutParams();
                    measuredWidth = i6 - this.atH.getMeasuredWidth();
                    i5 = this.atH.getMeasuredHeight() + paddingTop;
                    this.atH.layout(measuredWidth, paddingTop, i6, i5);
                    paddingTop = i5 + layoutParams.bottomMargin;
                    i5 = measuredWidth - this.atU;
                } else {
                    i5 = i6;
                }
                if (bQ2) {
                    layoutParams = (LayoutParams) this.atI.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop;
                    this.atI.layout(i6 - this.atI.getMeasuredWidth(), measuredWidth, i6, this.atI.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i6 - this.atU;
                    aa = layoutParams.bottomMargin;
                    aa = measuredWidth;
                } else {
                    aa = i6;
                }
                if (obj2 != null) {
                    aa = Math.min(i5, aa);
                } else {
                    aa = i6;
                }
                i5 = aa;
            } else {
                aa = (obj2 != null ? this.atT : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, aa);
                iArr[0] = Math.max(0, -aa);
                if (bQ) {
                    layoutParams = (LayoutParams) this.atH.getLayoutParams();
                    i6 = this.atH.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.atH.getMeasuredHeight() + paddingTop;
                    this.atH.layout(currentContentInsetRight, paddingTop, i6, measuredWidth);
                    aa = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i6 + this.atU;
                    paddingTop = aa;
                } else {
                    measuredWidth = currentContentInsetRight;
                }
                if (bQ2) {
                    layoutParams = (LayoutParams) this.atI.getLayoutParams();
                    i6 = layoutParams.topMargin + paddingTop;
                    paddingTop = this.atI.getMeasuredWidth() + currentContentInsetRight;
                    this.atI.layout(currentContentInsetRight, i6, paddingTop, this.atI.getMeasuredHeight() + i6);
                    i6 = this.atU + paddingTop;
                    aa = layoutParams.bottomMargin;
                    aa = i6;
                } else {
                    aa = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, aa);
                }
            }
        }
        m1489b(this.aud, 3);
        int size = this.aud.size();
        measuredWidth = currentContentInsetRight;
        for (i6 = 0; i6 < size; i6++) {
            measuredWidth = m1487a((View) this.aud.get(i6), measuredWidth, iArr, min);
        }
        m1489b(this.aud, 5);
        currentContentInsetRight = this.aud.size();
        i6 = 0;
        measuredHeight = i5;
        while (i6 < currentContentInsetRight) {
            i5 = m1488b((View) this.aud.get(i6), measuredHeight, iArr, min);
            i6++;
            measuredHeight = i5;
        }
        m1489b(this.aud, 1);
        ArrayList arrayList = this.aud;
        size = iArr[0];
        paddingTop = iArr[1];
        paddingTop2 = arrayList.size();
        i5 = 0;
        currentContentInsetRight = 0;
        while (i5 < paddingTop2) {
            View view = (View) arrayList.get(i5);
            layoutParams = (LayoutParams) view.getLayoutParams();
            size = layoutParams.leftMargin - size;
            aa = layoutParams.rightMargin - paddingTop;
            paddingBottom = Math.max(0, size);
            int max = Math.max(0, aa);
            size = Math.max(0, -size);
            paddingTop = Math.max(0, -aa);
            i5++;
            currentContentInsetRight += (view.getMeasuredWidth() + paddingBottom) + max;
        }
        aa = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (currentContentInsetRight / 2);
        i6 = aa + currentContentInsetRight;
        if (aa < measuredWidth) {
            aa = measuredWidth;
        } else if (i6 > measuredHeight) {
            aa -= i6 - measuredHeight;
        }
        i5 = this.aud.size();
        measuredWidth = 0;
        i6 = aa;
        while (measuredWidth < i5) {
            measuredWidth++;
            i6 = m1487a((View) this.aud.get(measuredWidth), i6, iArr, min);
        }
        this.aud.clear();
    }

    /* renamed from: a */
    private int m1487a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m1485B(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    /* renamed from: b */
    private int m1488b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m1485B(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    /* renamed from: B */
    private int m1485B(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m1494cX(layoutParams.gravity)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i3 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    /* renamed from: cX */
    private int m1494cX(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f1002Hu & 112;
        }
    }

    /* renamed from: b */
    private void m1489b(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (C0477s.m893T(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = C0456d.getAbsoluteGravity(i, C0477s.m893T(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.auo == 0 && m1490bQ(childAt) && m1495cY(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.auo == 0 && m1490bQ(childAt2) && m1495cY(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    /* renamed from: cY */
    private int m1495cY(int i) {
        int T = C0477s.m893T(this);
        int absoluteGravity = C0456d.getAbsoluteGravity(i, T) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return T == 1 ? 5 : 3;
        }
    }

    /* renamed from: bQ */
    private boolean m1490bQ(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: bR */
    private static int m1491bR(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0460f.m792b(marginLayoutParams) + C0460f.m791a(marginLayoutParams);
    }

    /* renamed from: bS */
    private static int m1492bS(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    /* renamed from: e */
    private static LayoutParams m1496e(LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* renamed from: lo */
    protected static LayoutParams m1502lo() {
        return new LayoutParams();
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public C0728x getWrapper() {
        if (this.aui == null) {
            this.aui = new C6256bd(this, true);
        }
        return this.aui;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: lp */
    public final void mo1868lp() {
        for (int size = this.aue.size() - 1; size >= 0; size--) {
            addView((View) this.aue.get(size));
        }
        this.aue.clear();
    }

    /* renamed from: bT */
    private boolean m1493bT(View view) {
        return view.getParent() == this || this.aue.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f1004mr = z;
        requestLayout();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: lq */
    public final void mo1869lq() {
        if (this.atX == null) {
            this.atX = new C0691as();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.auj;
    }

    /* Access modifiers changed, original: 0000 */
    public Context getPopupContext() {
        return this.acv;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
