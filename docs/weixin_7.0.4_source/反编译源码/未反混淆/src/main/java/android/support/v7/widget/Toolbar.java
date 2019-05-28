package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.f;
import android.support.v4.view.s;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.support.v7.widget.ActionMenuView.d;
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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int Hu;
    private int XT;
    private boolean acA;
    private boolean acB;
    Context acv;
    ActionMenuView acw;
    int adW;
    android.support.v7.view.menu.o.a adY;
    android.support.v7.view.menu.h.a adZ;
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
    as atX;
    private int atY;
    private int atZ;
    private CharSequence aua;
    private CharSequence aub;
    private int auc;
    private final ArrayList<View> aud;
    final ArrayList<View> aue;
    private final int[] auf;
    b aug;
    private final d auh;
    private bd aui;
    ActionMenuPresenter auj;
    a auk;
    private final Runnable aul;
    private boolean mr;

    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
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
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.auo = 0;
            this.auo = layoutParams.auo;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
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

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        int aup;
        boolean auq;

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

    class a implements o {
        j aun;
        h lo;

        a() {
        }

        public final void a(Context context, h hVar) {
            if (!(this.lo == null || this.aun == null)) {
                this.lo.h(this.aun);
            }
            this.lo = hVar;
        }

        public final void n(boolean z) {
            Object obj = null;
            if (this.aun != null) {
                if (this.lo != null) {
                    int size = this.lo.size();
                    for (int i = 0; i < size; i++) {
                        if (this.lo.getItem(i) == this.aun) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    c(this.aun);
                }
            }
        }

        public final void a(android.support.v7.view.menu.o.a aVar) {
        }

        public final boolean a(u uVar) {
            return false;
        }

        public final void a(h hVar, boolean z) {
        }

        public final boolean bt() {
            return false;
        }

        public final boolean b(j jVar) {
            Toolbar toolbar = Toolbar.this;
            if (toolbar.atN == null) {
                toolbar.atN = new AppCompatImageButton(toolbar.getContext(), null, R.attr.ey);
                toolbar.atN.setImageDrawable(toolbar.atL);
                toolbar.atN.setContentDescription(toolbar.atM);
                LayoutParams layoutParams = new LayoutParams();
                layoutParams.gravity = (toolbar.atR & 112) | 8388611;
                layoutParams.auo = 2;
                toolbar.atN.setLayoutParams(layoutParams);
                toolbar.atN.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Toolbar.this.collapseActionView();
                    }
                });
            }
            ViewParent parent = Toolbar.this.atN.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.atN);
                }
                Toolbar.this.addView(Toolbar.this.atN);
            }
            Toolbar.this.atO = jVar.getActionView();
            this.aun = jVar;
            parent = Toolbar.this.atO.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.atO);
                }
                LayoutParams lo = Toolbar.lo();
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
            jVar.Z(true);
            if (Toolbar.this.atO instanceof c) {
                ((c) Toolbar.this.atO).onActionViewExpanded();
            }
            return true;
        }

        public final boolean c(j jVar) {
            if (Toolbar.this.atO instanceof c) {
                ((c) Toolbar.this.atO).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.atO);
            Toolbar.this.removeView(Toolbar.this.atN);
            Toolbar.this.atO = null;
            Toolbar.this.lp();
            this.aun = null;
            Toolbar.this.requestLayout();
            jVar.Z(false);
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
        this(context, attributeSet, R.attr.ex);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Hu = 8388627;
        this.aud = new ArrayList();
        this.aue = new ArrayList();
        this.auf = new int[2];
        this.auh = new d() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.aug != null) {
                    return Toolbar.this.aug.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.aul = new Runnable() {
            public final void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        bc a = bc.a(getContext(), attributeSet, android.support.v7.a.a.a.Toolbar, i, 0);
        this.atP = a.getResourceId(12, 0);
        this.atQ = a.getResourceId(13, 0);
        this.Hu = a.getInteger(0, this.Hu);
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
        dimensionPixelOffset = a.getDimensionPixelOffset(5, android.support.v4.widget.j.INVALID_ID);
        int dimensionPixelOffset2 = a.getDimensionPixelOffset(6, android.support.v4.widget.j.INVALID_ID);
        int dimensionPixelSize = a.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = a.getDimensionPixelSize(8, 0);
        lq();
        as asVar = this.atX;
        asVar.aqp = false;
        if (dimensionPixelSize != android.support.v4.widget.j.INVALID_ID) {
            asVar.aqn = dimensionPixelSize;
            asVar.xJ = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != android.support.v4.widget.j.INVALID_ID) {
            asVar.aqo = dimensionPixelSize2;
            asVar.xM = dimensionPixelSize2;
        }
        if (!(dimensionPixelOffset == android.support.v4.widget.j.INVALID_ID && dimensionPixelOffset2 == android.support.v4.widget.j.INVALID_ID)) {
            this.atX.aI(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.atY = a.getDimensionPixelOffset(9, android.support.v4.widget.j.INVALID_ID);
        this.atZ = a.getDimensionPixelOffset(10, android.support.v4.widget.j.INVALID_ID);
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
        lq();
        as asVar = this.atX;
        if (i != 1) {
            z = false;
        }
        if (z != asVar.hq) {
            asVar.hq = z;
            if (!asVar.aqp) {
                asVar.xJ = asVar.aqn;
                asVar.xM = asVar.aqo;
            } else if (z) {
                asVar.xJ = asVar.Ls != android.support.v4.widget.j.INVALID_ID ? asVar.Ls : asVar.aqn;
                asVar.xM = asVar.aqm != android.support.v4.widget.j.INVALID_ID ? asVar.aqm : asVar.aqo;
            } else {
                asVar.xJ = asVar.aqm != android.support.v4.widget.j.INVALID_ID ? asVar.aqm : asVar.aqn;
                asVar.xM = asVar.Ls != android.support.v4.widget.j.INVALID_ID ? asVar.Ls : asVar.aqo;
            }
        }
    }

    public void setLogo(int i) {
        setLogo(android.support.v7.c.a.b.g(getContext(), i));
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
            lk();
            if (!bT(this.atK)) {
                i(this.atK, true);
            }
        } else if (this.atK != null && bT(this.atK)) {
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
            lk();
        }
        if (this.atK != null) {
            this.atK.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.atK != null ? this.atK.getContentDescription() : null;
    }

    private void lk() {
        if (this.atK == null) {
            this.atK = new AppCompatImageView(getContext());
        }
    }

    public final void collapseActionView() {
        j jVar = this.auk == null ? null : this.auk.aun;
        if (jVar != null) {
            jVar.collapseActionView();
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
                if (this.XT != 0) {
                    this.atH.setTextColor(this.XT);
                }
            }
            if (!bT(this.atH)) {
                i(this.atH, true);
            }
        } else if (this.atH != null && bT(this.atH)) {
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
            if (!bT(this.atI)) {
                i(this.atI, true);
            }
        } else if (this.atI != null && bT(this.atI)) {
            removeView(this.atI);
            this.aue.remove(this.atI);
        }
        if (this.atI != null) {
            this.atI.setText(charSequence);
        }
        this.aub = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.XT = i;
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
            ln();
        }
        if (this.atJ != null) {
            this.atJ.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(android.support.v7.c.a.b.g(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ln();
            if (!bT(this.atJ)) {
                i(this.atJ, true);
            }
        } else if (this.atJ != null && bT(this.atJ)) {
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
        ln();
        this.atJ.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        ll();
        return this.acw.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        ll();
        this.acw.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        ll();
        return this.acw.getOverflowIcon();
    }

    private void ll() {
        lm();
        if (this.acw.lo == null) {
            h hVar = (h) this.acw.getMenu();
            if (this.auk == null) {
                this.auk = new a();
            }
            this.acw.setExpandedActionViewsExclusive(true);
            hVar.a(this.auk, this.acv);
        }
    }

    /* Access modifiers changed, original: final */
    public final void lm() {
        if (this.acw == null) {
            this.acw = new ActionMenuView(getContext());
            this.acw.setPopupTheme(this.adW);
            this.acw.setOnMenuItemClickListener(this.auh);
            this.acw.a(this.adY, this.adZ);
            LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388613 | (this.atR & 112);
            this.acw.setLayoutParams(layoutParams);
            i(this.acw, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    public void setOnMenuItemClickListener(b bVar) {
        this.aug = bVar;
    }

    public int getContentInsetStart() {
        if (this.atX == null) {
            return 0;
        }
        as asVar = this.atX;
        return asVar.hq ? asVar.xM : asVar.xJ;
    }

    public int getContentInsetEnd() {
        if (this.atX == null) {
            return 0;
        }
        as asVar = this.atX;
        return asVar.hq ? asVar.xJ : asVar.xM;
    }

    public int getContentInsetLeft() {
        if (this.atX != null) {
            return this.atX.xJ;
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.atX != null) {
            return this.atX.xM;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.atY != android.support.v4.widget.j.INVALID_ID) {
            return this.atY;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = android.support.v4.widget.j.INVALID_ID;
        }
        if (i != this.atY) {
            this.atY = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.atZ != android.support.v4.widget.j.INVALID_ID) {
            return this.atZ;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = android.support.v4.widget.j.INVALID_ID;
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
            h hVar = this.acw.lo;
            i = (hVar == null || !hVar.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return Math.max(getContentInsetEnd(), Math.max(this.atZ, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (s.T(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (s.T(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ln() {
        if (this.atJ == null) {
            this.atJ = new AppCompatImageButton(getContext(), null, R.attr.ey);
            LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (this.atR & 112);
            this.atJ.setLayoutParams(layoutParams);
        }
    }

    private void i(View view, boolean z) {
        LayoutParams layoutParams;
        android.view.ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams2)) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = e(layoutParams2);
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
            super.onRestoreInstanceState(savedState.LC);
            if (this.acw != null) {
                menu = this.acw.lo;
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

    private void l(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != ErrorDialogData.SUPPRESSED && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, ErrorDialogData.SUPPRESSED);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
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
        if (bk.bW(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (bQ(this.atJ)) {
            l(this.atJ, i, 0, i2, this.atS);
            i6 = this.atJ.getMeasuredWidth() + bR(this.atJ);
            max = Math.max(0, this.atJ.getMeasuredHeight() + bS(this.atJ));
            combineMeasuredStates = View.combineMeasuredStates(0, this.atJ.getMeasuredState());
            i5 = max;
        } else {
            combineMeasuredStates = 0;
            i5 = 0;
        }
        if (bQ(this.atN)) {
            l(this.atN, i, 0, i2, this.atS);
            i6 = this.atN.getMeasuredWidth() + bR(this.atN);
            i5 = Math.max(i5, this.atN.getMeasuredHeight() + bS(this.atN));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.atN.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = Math.max(currentContentInsetStart, i6) + 0;
        iArr[i4] = Math.max(0, currentContentInsetStart - i6);
        i6 = 0;
        if (bQ(this.acw)) {
            l(this.acw, i, max2, i2, this.atS);
            i6 = this.acw.getMeasuredWidth() + bR(this.acw);
            i5 = Math.max(i5, this.acw.getMeasuredHeight() + bS(this.acw));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.acw.getMeasuredState());
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i6);
        iArr[i3] = Math.max(0, currentContentInsetStart - i6);
        if (bQ(this.atO)) {
            max2 += a(this.atO, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.atO.getMeasuredHeight() + bS(this.atO));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.atO.getMeasuredState());
        }
        if (bQ(this.atK)) {
            max2 += a(this.atK, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.atK.getMeasuredHeight() + bS(this.atK));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, this.atK.getMeasuredState());
        }
        i4 = getChildCount();
        i3 = 0;
        int i7 = combineMeasuredStates;
        int i8 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).auo == 0 && bQ(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + bS(childAt));
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
        if (bQ(this.atH)) {
            a(this.atH, i, max2 + max, i2, i9, iArr);
            currentContentInsetStart = bR(this.atH) + this.atH.getMeasuredWidth();
            i6 = this.atH.getMeasuredHeight() + bS(this.atH);
            i7 = View.combineMeasuredStates(i7, this.atH.getMeasuredState());
        }
        if (bQ(this.atI)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, a(this.atI, i, max2 + max, i2, i9 + i6, iArr));
            i6 += this.atI.getMeasuredHeight() + bS(this.atI);
            i7 = View.combineMeasuredStates(i7, this.atI.getMeasuredState());
        }
        currentContentInsetStart += max2;
        i6 = Math.max(i8, i6) + (getPaddingTop() + getPaddingBottom());
        int i10 = i;
        max = View.resolveSizeAndState(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i10, WebView.NIGHT_MODE_COLOR & i7);
        i6 = View.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (this.mr) {
            max2 = getChildCount();
            for (currentContentInsetStart = 0; currentContentInsetStart < max2; currentContentInsetStart++) {
                View childAt2 = getChildAt(currentContentInsetStart);
                if (bQ(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
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
        if (s.T(this) == 1) {
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
        int aa = s.aa(this);
        int min = aa >= 0 ? Math.min(aa, i4 - i2) : 0;
        if (!bQ(this.atJ)) {
            aa = i6;
            i5 = paddingLeft;
        } else if (obj != null) {
            aa = b(this.atJ, i6, iArr, min);
            i5 = paddingLeft;
        } else {
            i5 = a(this.atJ, paddingLeft, iArr, min);
            aa = i6;
        }
        if (bQ(this.atN)) {
            if (obj != null) {
                aa = b(this.atN, aa, iArr, min);
            } else {
                i5 = a(this.atN, i5, iArr, min);
            }
        }
        if (bQ(this.acw)) {
            if (obj != null) {
                i5 = a(this.acw, i5, iArr, min);
            } else {
                aa = b(this.acw, aa, iArr, min);
            }
        }
        i6 = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, i6 - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - aa));
        i6 = Math.max(i5, i6);
        aa = Math.min(aa, (width - paddingRight) - currentContentInsetRight);
        if (bQ(this.atO)) {
            if (obj != null) {
                aa = b(this.atO, aa, iArr, min);
            } else {
                i6 = a(this.atO, i6, iArr, min);
            }
        }
        if (!bQ(this.atK)) {
            i5 = aa;
            currentContentInsetRight = i6;
        } else if (obj != null) {
            i5 = b(this.atK, aa, iArr, min);
            currentContentInsetRight = i6;
        } else {
            i5 = aa;
            currentContentInsetRight = a(this.atK, i6, iArr, min);
        }
        boolean bQ = bQ(this.atH);
        boolean bQ2 = bQ(this.atI);
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
            switch (this.Hu & 112) {
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
        b(this.aud, 3);
        int size = this.aud.size();
        measuredWidth = currentContentInsetRight;
        for (i6 = 0; i6 < size; i6++) {
            measuredWidth = a((View) this.aud.get(i6), measuredWidth, iArr, min);
        }
        b(this.aud, 5);
        currentContentInsetRight = this.aud.size();
        i6 = 0;
        measuredHeight = i5;
        while (i6 < currentContentInsetRight) {
            i5 = b((View) this.aud.get(i6), measuredHeight, iArr, min);
            i6++;
            measuredHeight = i5;
        }
        b(this.aud, 1);
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
            i6 = a((View) this.aud.get(measuredWidth), i6, iArr, min);
        }
        this.aud.clear();
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = B(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = B(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int B(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (cX(layoutParams.gravity)) {
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

    private int cX(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.Hu & 112;
        }
    }

    private void b(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (s.T(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i, s.T(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.auo == 0 && bQ(childAt) && cY(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.auo == 0 && bQ(childAt2) && cY(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int cY(int i) {
        int T = s.T(this);
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i, T) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return T == 1 ? 5 : 3;
        }
    }

    private boolean bQ(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int bR(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return f.b(marginLayoutParams) + f.a(marginLayoutParams);
    }

    private static int bS(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private static LayoutParams e(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams lo() {
        return new LayoutParams();
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public x getWrapper() {
        if (this.aui == null) {
            this.aui = new bd(this, true);
        }
        return this.aui;
    }

    /* Access modifiers changed, original: final */
    public final void lp() {
        for (int size = this.aue.size() - 1; size >= 0; size--) {
            addView((View) this.aue.get(size));
        }
        this.aue.clear();
    }

    private boolean bT(View view) {
        return view.getParent() == this || this.aue.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.mr = z;
        requestLayout();
    }

    /* Access modifiers changed, original: final */
    public final void lq() {
        if (this.atX == null) {
            this.atX = new as();
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
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
