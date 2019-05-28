package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.app.t;
import android.support.v4.view.aa;
import android.support.v4.view.o;
import android.support.v4.view.s;
import android.support.v4.view.y;
import android.support.v4.widget.n;
import android.support.v7.view.e;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ad;
import android.support.v7.widget.az;
import android.support.v7.widget.bh;
import android.support.v7.widget.bk;
import android.support.v7.widget.i;
import android.support.v7.widget.w;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImplV9 extends e implements android.support.v7.view.menu.h.a, Factory2 {
    private static final boolean Vf = (VERSION.SDK_INT < 21);
    private TextView TF;
    private boolean VA;
    private j VB;
    private w Vg;
    private a Vh;
    private d Vi;
    android.support.v7.view.b Vj;
    ActionBarContextView Vk;
    PopupWindow Vl;
    Runnable Vm;
    android.support.v4.view.w Vn = null;
    private boolean Vo;
    private ViewGroup Vp;
    private View Vq;
    private boolean Vr;
    private boolean Vs;
    private boolean Vt;
    private PanelFeatureState[] Vu;
    private PanelFeatureState Vv;
    private boolean Vw;
    boolean Vx;
    int Vy;
    private final Runnable Vz = new Runnable() {
        public final void run() {
            if ((AppCompatDelegateImplV9.this.Vy & 1) != 0) {
                AppCompatDelegateImplV9.this.bi(0);
            }
            if ((AppCompatDelegateImplV9.this.Vy & 4096) != 0) {
                AppCompatDelegateImplV9.this.bi(108);
            }
            AppCompatDelegateImplV9.this.Vx = false;
            AppCompatDelegateImplV9.this.Vy = 0;
        }
    };
    private Rect qS;
    private Rect qT;

    protected static final class PanelFeatureState {
        boolean RP;
        int VG;
        ViewGroup VH;
        View VI;
        View VJ;
        h VK;
        f VL;
        Context VM;
        boolean VN;
        boolean VO;
        public boolean VP;
        boolean VQ = false;
        boolean VR;
        Bundle VS;
        int background;
        int gravity;
        int windowAnimations;
        int x;
        int y;

        static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.b(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return SavedState.b(parcel, null);
                }
            };
            boolean RP;
            int VG;
            Bundle ra;

            SavedState() {
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.VG);
                parcel.writeInt(this.RP ? 1 : 0);
                if (this.RP) {
                    parcel.writeBundle(this.ra);
                }
            }

            static SavedState b(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.VG = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.RP = z;
                if (savedState.RP) {
                    savedState.ra = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }

        PanelFeatureState(int i) {
            this.VG = i;
        }

        public final boolean fz() {
            if (this.VI == null) {
                return false;
            }
            if (this.VJ != null) {
                return true;
            }
            if (this.VL.getAdapter().getCount() > 0) {
                return true;
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        public final void V(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.ds, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.fj, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.u0, true);
            }
            android.support.v7.view.d dVar = new android.support.v7.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.VM = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(80, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
        }

        /* Access modifiers changed, original: final */
        public final void e(h hVar) {
            if (hVar != this.VK) {
                if (this.VK != null) {
                    this.VK.b(this.VL);
                }
                this.VK = hVar;
                if (hVar != null && this.VL != null) {
                    hVar.a(this.VL);
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final p b(android.support.v7.view.menu.o.a aVar) {
            if (this.VK == null) {
                return null;
            }
            if (this.VL == null) {
                this.VL = new f(this.VM);
                this.VL.lL = aVar;
                this.VK.a(this.VL);
            }
            return this.VL.f(this.VH);
        }
    }

    final class a implements android.support.v7.view.menu.o.a {
        a() {
        }

        public final boolean d(h hVar) {
            Callback callback = AppCompatDelegateImplV9.this.Ti.getCallback();
            if (callback != null) {
                callback.onMenuOpened(108, hVar);
            }
            return true;
        }

        public final void a(h hVar, boolean z) {
            AppCompatDelegateImplV9.this.c(hVar);
        }
    }

    class b implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a VE;

        public b(android.support.v7.view.b.a aVar) {
            this.VE = aVar;
        }

        public final boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.VE.a(bVar, menu);
        }

        public final boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.VE.b(bVar, menu);
        }

        public final boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.VE.a(bVar, menuItem);
        }

        public final void a(android.support.v7.view.b bVar) {
            this.VE.a(bVar);
            if (AppCompatDelegateImplV9.this.Vl != null) {
                AppCompatDelegateImplV9.this.Ti.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.Vm);
            }
            if (AppCompatDelegateImplV9.this.Vk != null) {
                AppCompatDelegateImplV9.this.fv();
                AppCompatDelegateImplV9.this.Vn = s.ab(AppCompatDelegateImplV9.this.Vk).t(0.0f);
                AppCompatDelegateImplV9.this.Vn.a(new y() {
                    public final void aA(View view) {
                        AppCompatDelegateImplV9.this.Vk.setVisibility(8);
                        if (AppCompatDelegateImplV9.this.Vl != null) {
                            AppCompatDelegateImplV9.this.Vl.dismiss();
                        } else if (AppCompatDelegateImplV9.this.Vk.getParent() instanceof View) {
                            s.ak((View) AppCompatDelegateImplV9.this.Vk.getParent());
                        }
                        AppCompatDelegateImplV9.this.Vk.removeAllViews();
                        AppCompatDelegateImplV9.this.Vn.a(null);
                        AppCompatDelegateImplV9.this.Vn = null;
                    }
                });
            }
            if (AppCompatDelegateImplV9.this.UI != null) {
                AppCompatDelegateImplV9.this.UI.onSupportActionModeFinished(AppCompatDelegateImplV9.this.Vj);
            }
            AppCompatDelegateImplV9.this.Vj = null;
        }
    }

    class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV9.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                boolean z;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AppCompatDelegateImplV9.this.fw();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(android.support.v7.c.a.b.g(getContext(), i));
        }
    }

    final class d implements android.support.v7.view.menu.o.a {
        d() {
        }

        public final void a(h hVar, boolean z) {
            Menu hVar2;
            Menu gE = hVar2.gE();
            boolean z2 = gE != hVar2;
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
            if (z2) {
                hVar2 = gE;
            }
            PanelFeatureState a = appCompatDelegateImplV9.a(hVar2);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV9.this.a(a.VG, a, gE);
                AppCompatDelegateImplV9.this.a(a, true);
                return;
            }
            AppCompatDelegateImplV9.this.a(a, z);
        }

        public final boolean d(h hVar) {
            if (hVar == null && AppCompatDelegateImplV9.this.UJ) {
                Callback callback = AppCompatDelegateImplV9.this.Ti.getCallback();
                if (!(callback == null || AppCompatDelegateImplV9.this.UP)) {
                    callback.onMenuOpened(108, hVar);
                }
            }
            return true;
        }
    }

    AppCompatDelegateImplV9(Context context, Window window, c cVar) {
        super(context, window, cVar);
    }

    public void onCreate(Bundle bundle) {
        if ((this.UG instanceof Activity) && t.g((Activity) this.UG) != null) {
            ActionBar actionBar = this.mActionBar;
            if (actionBar == null) {
                this.VA = true;
            } else {
                actionBar.K(true);
            }
        }
    }

    public final void fj() {
        fr();
    }

    public final void fn() {
        fr();
        if (this.UJ && this.mActionBar == null) {
            if (this.UG instanceof Activity) {
                this.mActionBar = new o((Activity) this.UG, this.UK);
            } else if (this.UG instanceof Dialog) {
                this.mActionBar = new o((Dialog) this.UG);
            }
            if (this.mActionBar != null) {
                this.mActionBar.K(this.VA);
            }
        }
    }

    public final void setSupportActionBar(Toolbar toolbar) {
        if (this.UG instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof o) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.mY = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                l lVar = new l(toolbar, ((Activity) this.UG).getTitle(), this.UH);
                this.mActionBar = lVar;
                this.Ti.setCallback(lVar.Wm);
            } else {
                this.mActionBar = null;
                this.Ti.setCallback(this.UH);
            }
            invalidateOptionsMenu();
        }
    }

    public final <T extends View> T findViewById(int i) {
        fr();
        return this.Ti.findViewById(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.UJ && this.Vo) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
        i hE = i.hE();
        Context context = this.mContext;
        synchronized (hE.afH) {
            android.support.v4.f.f fVar = (android.support.v4.f.f) hE.afI.get(context);
            if (fVar != null) {
                fVar.clear();
            }
        }
        fl();
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.L(false);
        }
    }

    public final void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.L(true);
        }
    }

    public final void setContentView(View view) {
        fr();
        ViewGroup viewGroup = (ViewGroup) this.Vp.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.UG.onContentChanged();
    }

    public final void setContentView(int i) {
        fr();
        ViewGroup viewGroup = (ViewGroup) this.Vp.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.UG.onContentChanged();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        fr();
        ViewGroup viewGroup = (ViewGroup) this.Vp.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.UG.onContentChanged();
    }

    public final void addContentView(View view, LayoutParams layoutParams) {
        fr();
        ((ViewGroup) this.Vp.findViewById(16908290)).addView(view, layoutParams);
        this.UG.onContentChanged();
    }

    public void onDestroy() {
        if (this.Vx) {
            this.Ti.getDecorView().removeCallbacks(this.Vz);
        }
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
    }

    private void fr() {
        if (!this.Vo) {
            this.Vp = fs();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                k(title);
            }
            ft();
            this.Vo = true;
            PanelFeatureState bh = bh(0);
            if (!this.UP) {
                if (bh == null || bh.VK == null) {
                    invalidatePanelMenu(108);
                }
            }
        }
    }

    private ViewGroup fs() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(2)) {
            ViewGroup viewGroup;
            if (obtainStyledAttributes.getBoolean(3, false)) {
                requestWindowFeature(1);
            } else if (obtainStyledAttributes.getBoolean(2, false)) {
                requestWindowFeature(108);
            }
            if (obtainStyledAttributes.getBoolean(4, false)) {
                requestWindowFeature(109);
            }
            if (obtainStyledAttributes.getBoolean(5, false)) {
                requestWindowFeature(10);
            }
            this.UM = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            this.Ti.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.mContext);
            ViewGroup viewGroup2;
            if (this.UN) {
                View view;
                if (this.UL) {
                    view = (ViewGroup) from.inflate(R.layout.a3, null);
                } else {
                    view = (ViewGroup) from.inflate(R.layout.a2, null);
                }
                View viewGroup3;
                if (VERSION.SDK_INT >= 21) {
                    s.a(view, new o() {
                        public final aa a(View view, aa aaVar) {
                            int systemWindowInsetTop = aaVar.getSystemWindowInsetTop();
                            int bj = AppCompatDelegateImplV9.this.bj(systemWindowInsetTop);
                            if (systemWindowInsetTop != bj) {
                                aaVar = aaVar.f(aaVar.getSystemWindowInsetLeft(), bj, aaVar.getSystemWindowInsetRight(), aaVar.getSystemWindowInsetBottom());
                            }
                            return s.a(view, aaVar);
                        }
                    });
                    viewGroup3 = view;
                } else {
                    ((ad) view).setOnFitSystemWindowsListener(new android.support.v7.widget.ad.a() {
                        public final void f(Rect rect) {
                            rect.top = AppCompatDelegateImplV9.this.bj(rect.top);
                        }
                    });
                    viewGroup3 = view;
                }
            } else if (this.UM) {
                viewGroup2 = (ViewGroup) from.inflate(R.layout.t, null);
                this.UK = false;
                this.UJ = false;
                viewGroup3 = viewGroup2;
            } else if (this.UJ) {
                Context dVar;
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.dv, typedValue, true);
                if (typedValue.resourceId != 0) {
                    dVar = new android.support.v7.view.d(this.mContext, typedValue.resourceId);
                } else {
                    dVar = this.mContext;
                }
                viewGroup2 = (ViewGroup) LayoutInflater.from(dVar).inflate(R.layout.a4, null);
                this.Vg = (w) viewGroup2.findViewById(R.id.jz);
                this.Vg.setWindowCallback(this.Ti.getCallback());
                if (this.UK) {
                    this.Vg.bs(109);
                }
                if (this.Vr) {
                    this.Vg.bs(2);
                }
                if (this.Vs) {
                    this.Vg.bs(5);
                }
                viewGroup3 = viewGroup2;
            } else {
                viewGroup3 = null;
            }
            if (viewGroup3 == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.UJ + ", windowActionBarOverlay: " + this.UK + ", android:windowIsFloating: " + this.UM + ", windowActionModeOverlay: " + this.UL + ", windowNoTitle: " + this.UN + " }");
            }
            if (this.Vg == null) {
                this.TF = (TextView) viewGroup3.findViewById(R.id.cx);
            }
            bk.bX(viewGroup3);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup3.findViewById(R.id.a);
            ViewGroup viewGroup4 = (ViewGroup) this.Ti.findViewById(16908290);
            if (viewGroup4 != null) {
                while (viewGroup4.getChildCount() > 0) {
                    View childAt = viewGroup4.getChildAt(0);
                    viewGroup4.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup4.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup4 instanceof FrameLayout) {
                    ((FrameLayout) viewGroup4).setForeground(null);
                }
            }
            this.Ti.setContentView(viewGroup3);
            contentFrameLayout.setAttachListener(new android.support.v7.widget.ContentFrameLayout.a() {
                public final void onDetachedFromWindow() {
                    AppCompatDelegateImplV9.this.fy();
                }
            });
            return viewGroup3;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void ft() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.Vp.findViewById(16908290);
        View decorView = this.Ti.getDecorView();
        contentFrameLayout.j(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
        obtainStyledAttributes.getValue(10, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(11, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(6)) {
            obtainStyledAttributes.getValue(6, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(8)) {
            obtainStyledAttributes.getValue(8, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(9)) {
            obtainStyledAttributes.getValue(9, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(7)) {
            obtainStyledAttributes.getValue(7, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final boolean requestWindowFeature(int i) {
        int bk = bk(i);
        if (this.UN && bk == 108) {
            return false;
        }
        if (this.UJ && bk == 1) {
            this.UJ = false;
        }
        switch (bk) {
            case 1:
                fx();
                this.UN = true;
                return true;
            case 2:
                fx();
                this.Vr = true;
                return true;
            case 5:
                fx();
                this.Vs = true;
                return true;
            case 10:
                fx();
                this.UL = true;
                return true;
            case 108:
                fx();
                this.UJ = true;
                return true;
            case 109:
                fx();
                this.UK = true;
                return true;
            default:
                return this.Ti.requestFeature(bk);
        }
    }

    /* Access modifiers changed, original: final */
    public final void k(CharSequence charSequence) {
        if (this.Vg != null) {
            this.Vg.setWindowTitle(charSequence);
        } else if (this.mActionBar != null) {
            this.mActionBar.setWindowTitle(charSequence);
        } else if (this.TF != null) {
            this.TF.setText(charSequence);
        }
    }

    /* Access modifiers changed, original: final */
    public final void bd(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.M(false);
            }
        } else if (i == 0) {
            PanelFeatureState bh = bh(i);
            if (bh.RP) {
                a(bh, false);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean be(int i) {
        if (i != 108) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return true;
        }
        supportActionBar.M(true);
        return true;
    }

    public final void b(h hVar) {
        if (this.Vg == null || !this.Vg.gV() || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.Vg.gW())) {
            PanelFeatureState bh = bh(0);
            bh.VQ = true;
            a(bh, false);
            a(bh, null);
            return;
        }
        Callback callback = this.Ti.getCallback();
        if (this.Vg.isOverflowMenuShowing()) {
            this.Vg.hideOverflowMenu();
            if (!this.UP) {
                callback.onPanelClosed(108, bh(0).VK);
            }
        } else if (callback != null && !this.UP) {
            if (this.Vx && (this.Vy & 1) != 0) {
                this.Ti.getDecorView().removeCallbacks(this.Vz);
                this.Vz.run();
            }
            PanelFeatureState bh2 = bh(0);
            if (bh2.VK != null && !bh2.VR && callback.onPreparePanel(0, bh2.VJ, bh2.VK)) {
                callback.onMenuOpened(108, bh2.VK);
                this.Vg.showOverflowMenu();
            }
        }
    }

    public final android.support.v7.view.b startSupportActionMode(android.support.v7.view.b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.Vj != null) {
            this.Vj.finish();
        }
        android.support.v7.view.b.a bVar = new b(aVar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.Vj = supportActionBar.a(bVar);
            if (!(this.Vj == null || this.UI == null)) {
                this.UI.onSupportActionModeStarted(this.Vj);
            }
        }
        if (this.Vj == null) {
            this.Vj = b(bVar);
        }
        return this.Vj;
    }

    public final void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.fh()) {
            invalidatePanelMenu(0);
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.support.v7.view.b b(android.support.v7.view.b.a aVar) {
        android.support.v7.view.b onWindowStartingSupportActionMode;
        fv();
        if (this.Vj != null) {
            this.Vj.finish();
        }
        if (!(this.UI == null || this.UP)) {
            try {
                onWindowStartingSupportActionMode = this.UI.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError e) {
            }
            if (onWindowStartingSupportActionMode == null) {
                this.Vj = onWindowStartingSupportActionMode;
            } else {
                if (this.Vk == null) {
                    if (this.UM) {
                        Context dVar;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = this.mContext.getTheme();
                        theme.resolveAttribute(R.attr.dv, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = this.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            dVar = new android.support.v7.view.d(this.mContext, 0);
                            dVar.getTheme().setTo(newTheme);
                        } else {
                            dVar = this.mContext;
                        }
                        this.Vk = new ActionBarContextView(dVar);
                        this.Vl = new PopupWindow(dVar, null, R.attr.ed);
                        n.a(this.Vl, 2);
                        this.Vl.setContentView(this.Vk);
                        this.Vl.setWidth(-1);
                        dVar.getTheme().resolveAttribute(R.attr.dx, typedValue, true);
                        this.Vk.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                        this.Vl.setHeight(-2);
                        this.Vm = new Runnable() {
                            public final void run() {
                                AppCompatDelegateImplV9.this.Vl.showAtLocation(AppCompatDelegateImplV9.this.Vk, 55, 0, 0);
                                AppCompatDelegateImplV9.this.fv();
                                if (AppCompatDelegateImplV9.this.fu()) {
                                    AppCompatDelegateImplV9.this.Vk.setAlpha(0.0f);
                                    AppCompatDelegateImplV9.this.Vn = s.ab(AppCompatDelegateImplV9.this.Vk).t(1.0f);
                                    AppCompatDelegateImplV9.this.Vn.a(new y() {
                                        public final void az(View view) {
                                            AppCompatDelegateImplV9.this.Vk.setVisibility(0);
                                        }

                                        public final void aA(View view) {
                                            AppCompatDelegateImplV9.this.Vk.setAlpha(1.0f);
                                            AppCompatDelegateImplV9.this.Vn.a(null);
                                            AppCompatDelegateImplV9.this.Vn = null;
                                        }
                                    });
                                    return;
                                }
                                AppCompatDelegateImplV9.this.Vk.setAlpha(1.0f);
                                AppCompatDelegateImplV9.this.Vk.setVisibility(0);
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.Vp.findViewById(R.id.jx);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(fo()));
                            this.Vk = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (this.Vk != null) {
                    boolean z;
                    fv();
                    this.Vk.gS();
                    Context context = this.Vk.getContext();
                    ActionBarContextView actionBarContextView = this.Vk;
                    if (this.Vl == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    android.support.v7.view.b eVar = new e(context, actionBarContextView, aVar, z);
                    if (aVar.a(eVar, eVar.getMenu())) {
                        eVar.invalidate();
                        this.Vk.c(eVar);
                        this.Vj = eVar;
                        if (fu()) {
                            this.Vk.setAlpha(0.0f);
                            this.Vn = s.ab(this.Vk).t(1.0f);
                            this.Vn.a(new y() {
                                public final void az(View view) {
                                    AppCompatDelegateImplV9.this.Vk.setVisibility(0);
                                    AppCompatDelegateImplV9.this.Vk.sendAccessibilityEvent(32);
                                    if (AppCompatDelegateImplV9.this.Vk.getParent() instanceof View) {
                                        s.ak((View) AppCompatDelegateImplV9.this.Vk.getParent());
                                    }
                                }

                                public final void aA(View view) {
                                    AppCompatDelegateImplV9.this.Vk.setAlpha(1.0f);
                                    AppCompatDelegateImplV9.this.Vn.a(null);
                                    AppCompatDelegateImplV9.this.Vn = null;
                                }
                            });
                        } else {
                            this.Vk.setAlpha(1.0f);
                            this.Vk.setVisibility(0);
                            this.Vk.sendAccessibilityEvent(32);
                            if (this.Vk.getParent() instanceof View) {
                                s.ak((View) this.Vk.getParent());
                            }
                        }
                        if (this.Vl != null) {
                            this.Ti.getDecorView().post(this.Vm);
                        }
                    } else {
                        this.Vj = null;
                    }
                }
            }
            if (!(this.Vj == null || this.UI == null)) {
                this.UI.onSupportActionModeStarted(this.Vj);
            }
            return this.Vj;
        }
        onWindowStartingSupportActionMode = null;
        if (onWindowStartingSupportActionMode == null) {
        }
        this.UI.onSupportActionModeStarted(this.Vj);
        return this.Vj;
    }

    /* Access modifiers changed, original: final */
    public final boolean fu() {
        return this.Vo && this.Vp != null && s.as(this.Vp);
    }

    /* Access modifiers changed, original: final */
    public final void fv() {
        if (this.Vn != null) {
            this.Vn.cancel();
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.Vv == null || !a(this.Vv, keyEvent.getKeyCode(), keyEvent)) {
            if (this.Vv == null) {
                PanelFeatureState bh = bh(0);
                b(bh, keyEvent);
                boolean a = a(bh, keyEvent.getKeyCode(), keyEvent);
                bh.VN = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.Vv == null) {
            return true;
        } else {
            this.Vv.VO = true;
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.UG.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case 4:
                    this.Vw = (keyEvent.getFlags() & 128) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState bh = bh(0);
                    if (bh.RP) {
                        return true;
                    }
                    b(bh, keyEvent);
                    return true;
            }
            return false;
        }
        PanelFeatureState bh2;
        switch (keyCode) {
            case 4:
                z = this.Vw;
                this.Vw = false;
                bh2 = bh(0);
                if (bh2 == null || !bh2.RP) {
                    if (this.Vj != null) {
                        this.Vj.finish();
                        z = true;
                    } else {
                        ActionBar supportActionBar = getSupportActionBar();
                        if (supportActionBar == null || !supportActionBar.collapseActionView()) {
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(bh2, true);
                    return true;
                }
                break;
            case 82:
                if (this.Vj != null) {
                    return true;
                }
                bh2 = bh(0);
                if (this.Vg == null || !this.Vg.gV() || ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                    if (bh2.RP || bh2.VO) {
                        z = bh2.RP;
                        a(bh2, true);
                    } else {
                        if (bh2.VN) {
                            if (bh2.VR) {
                                bh2.VN = false;
                                z = b(bh2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(bh2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.Vg.isOverflowMenuShowing()) {
                    z = this.Vg.hideOverflowMenu();
                } else {
                    if (!this.UP && b(bh2, keyEvent)) {
                        z = this.Vg.showOverflowMenu();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager == null) {
                    return true;
                }
                audioManager.playSoundEffect(0);
                return true;
        }
        return false;
    }

    /* JADX WARNING: Missing block: B:58:0x00f8, code skipped:
            if (r11.equals("ImageView") != false) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        Context context2;
        int resourceId;
        int resourceId2;
        Context context3;
        View appCompatTextView;
        View view2;
        int i = 1;
        if (this.VB == null) {
            String string = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme).getString(com.tencent.view.d.MIC_AVROUND_BLUR);
            if (string == null || j.class.getName().equals(string)) {
                this.VB = new j();
            } else {
                try {
                    this.VB = (j) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    new StringBuilder("Failed to instantiate custom view inflater ").append(string).append(". Falling back to default.");
                    this.VB = new j();
                }
            }
        }
        if (!Vf) {
            z = false;
        } else if (!(attributeSet instanceof XmlPullParser)) {
            z = a((ViewParent) view);
        } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
            z = true;
        } else {
            z = false;
        }
        j jVar = this.VB;
        boolean z2 = Vf;
        boolean lw = bh.lw();
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, android.support.v7.a.a.a.View, 0, 0);
        if (z2) {
            resourceId = obtainStyledAttributes.getResourceId(0, 0);
        } else {
            resourceId = 0;
        }
        if (resourceId == 0) {
            resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
        } else {
            resourceId2 = resourceId;
        }
        obtainStyledAttributes.recycle();
        if (resourceId2 == 0 || ((context2 instanceof android.support.v7.view.d) && ((android.support.v7.view.d) context2).YN == resourceId2)) {
            context3 = context2;
        } else {
            context3 = new android.support.v7.view.d(context2, resourceId2);
        }
        if (lw) {
            context3 = az.ad(context3);
        }
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    i = 11;
                    break;
                }
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    i = 8;
                    break;
                }
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    i = 10;
                    break;
                }
            case -938935918:
                if (str.equals("TextView")) {
                    i = 0;
                    break;
                }
            case -937446323:
                if (str.equals("ImageButton")) {
                    i = 5;
                    break;
                }
            case -658531749:
                if (str.equals("SeekBar")) {
                    i = 12;
                    break;
                }
            case -339785223:
                if (str.equals("Spinner")) {
                    i = 4;
                    break;
                }
            case 776382189:
                if (str.equals("RadioButton")) {
                    i = 7;
                    break;
                }
            case 1125864064:
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    i = 9;
                    break;
                }
            case 1601505219:
                if (str.equals("CheckBox")) {
                    i = 6;
                    break;
                }
            case 1666676343:
                if (str.equals("EditText")) {
                    i = 3;
                    break;
                }
            case 2001146706:
                if (str.equals("Button")) {
                    i = 2;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
                appCompatTextView = new AppCompatTextView(context3, attributeSet);
                break;
            case 1:
                appCompatTextView = new AppCompatImageView(context3, attributeSet);
                break;
            case 2:
                appCompatTextView = new AppCompatButton(context3, attributeSet);
                break;
            case 3:
                appCompatTextView = new AppCompatEditText(context3, attributeSet);
                break;
            case 4:
                appCompatTextView = new AppCompatSpinner(context3, attributeSet);
                break;
            case 5:
                appCompatTextView = new AppCompatImageButton(context3, attributeSet);
                break;
            case 6:
                appCompatTextView = new AppCompatCheckBox(context3, attributeSet);
                break;
            case 7:
                appCompatTextView = new AppCompatRadioButton(context3, attributeSet);
                break;
            case 8:
                appCompatTextView = new AppCompatCheckedTextView(context3, attributeSet);
                break;
            case 9:
                appCompatTextView = new AppCompatAutoCompleteTextView(context3, attributeSet);
                break;
            case 10:
                appCompatTextView = new AppCompatMultiAutoCompleteTextView(context3, attributeSet);
                break;
            case 11:
                appCompatTextView = new AppCompatRatingBar(context3, attributeSet);
                break;
            case 12:
                appCompatTextView = new AppCompatSeekBar(context3, attributeSet);
                break;
            default:
                appCompatTextView = null;
                break;
        }
        if (appCompatTextView != null || context == context3) {
            view2 = appCompatTextView;
        } else {
            view2 = jVar.a(context3, str, attributeSet);
        }
        if (view2 != null) {
            context2 = view2.getContext();
            if ((context2 instanceof ContextWrapper) && (VERSION.SDK_INT < 15 || s.aw(view2))) {
                TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, j.VU);
                String string2 = obtainStyledAttributes2.getString(0);
                if (string2 != null) {
                    view2.setOnClickListener(new a(view2, string2));
                }
                obtainStyledAttributes2.recycle();
            }
        }
        return view2;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.Ti.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || s.av((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    public final void fk() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            android.support.v4.view.e.b(from, this);
        } else {
            from.getFactory2();
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = a(str, context, attributeSet);
        return a != null ? a : a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* Access modifiers changed, original: 0000 */
    public View a(String str, Context context, AttributeSet attributeSet) {
        if (this.UG instanceof Factory) {
            View onCreateView = ((Factory) this.UG).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:55:0x00ee, code skipped:
            if (r0.width == -1) goto L_0x00ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i = -1;
        if (!panelFeatureState.RP && !this.UP) {
            if (panelFeatureState.VG == 0) {
                if ((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Callback callback = this.Ti.getCallback();
            if (callback == null || callback.onMenuOpened(panelFeatureState.VG, panelFeatureState.VK)) {
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    LayoutParams layoutParams;
                    if (panelFeatureState.VH == null || panelFeatureState.VQ) {
                        if (panelFeatureState.VH == null) {
                            a(panelFeatureState);
                            if (panelFeatureState.VH == null) {
                                return;
                            }
                        } else if (panelFeatureState.VQ && panelFeatureState.VH.getChildCount() > 0) {
                            panelFeatureState.VH.removeAllViews();
                        }
                        if (c(panelFeatureState) && panelFeatureState.fz()) {
                            LayoutParams layoutParams2;
                            layoutParams = panelFeatureState.VI.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams2 = new LayoutParams(-2, -2);
                            } else {
                                layoutParams2 = layoutParams;
                            }
                            panelFeatureState.VH.setBackgroundResource(panelFeatureState.background);
                            ViewParent parent = panelFeatureState.VI.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.VI);
                            }
                            panelFeatureState.VH.addView(panelFeatureState.VI, layoutParams2);
                            if (!panelFeatureState.VI.hasFocus()) {
                                panelFeatureState.VI.requestFocus();
                            }
                            i = -2;
                        } else {
                            return;
                        }
                    }
                    if (panelFeatureState.VJ != null) {
                        layoutParams = panelFeatureState.VJ.getLayoutParams();
                        if (layoutParams != null) {
                        }
                    }
                    i = -2;
                    panelFeatureState.VO = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                    layoutParams3.gravity = panelFeatureState.gravity;
                    layoutParams3.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.VH, layoutParams3);
                    panelFeatureState.RP = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.V(fo());
        panelFeatureState.VH = new c(panelFeatureState.VM);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context dVar;
        h hVar;
        Context context = this.mContext;
        if ((panelFeatureState.VG == 0 || panelFeatureState.VG == 108) && this.Vg != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.dv, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.dw, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.dw, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                dVar = new android.support.v7.view.d(context, 0);
                dVar.getTheme().setTo(theme3);
                hVar = new h(dVar);
                hVar.a((android.support.v7.view.menu.h.a) this);
                panelFeatureState.e(hVar);
                return true;
            }
        }
        dVar = context;
        hVar = new h(dVar);
        hVar.a((android.support.v7.view.menu.h.a) this);
        panelFeatureState.e(hVar);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.VJ != null) {
            panelFeatureState.VI = panelFeatureState.VJ;
            return true;
        } else if (panelFeatureState.VK == null) {
            return false;
        } else {
            if (this.Vi == null) {
                this.Vi = new d();
            }
            panelFeatureState.VI = (View) panelFeatureState.b(this.Vi);
            return panelFeatureState.VI != null;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.UP) {
            return false;
        }
        if (panelFeatureState.VN) {
            return true;
        }
        if (!(this.Vv == null || this.Vv == panelFeatureState)) {
            a(this.Vv, false);
        }
        Callback callback = this.Ti.getCallback();
        if (callback != null) {
            panelFeatureState.VJ = callback.onCreatePanelView(panelFeatureState.VG);
        }
        boolean z = panelFeatureState.VG == 0 || panelFeatureState.VG == 108;
        if (z && this.Vg != null) {
            this.Vg.gX();
        }
        if (panelFeatureState.VJ == null && !(z && (this.mActionBar instanceof l))) {
            if (panelFeatureState.VK == null || panelFeatureState.VR) {
                if (panelFeatureState.VK == null) {
                    b(panelFeatureState);
                    if (panelFeatureState.VK == null) {
                        return false;
                    }
                }
                if (z && this.Vg != null) {
                    if (this.Vh == null) {
                        this.Vh = new a();
                    }
                    this.Vg.a(panelFeatureState.VK, this.Vh);
                }
                panelFeatureState.VK.gx();
                if (callback.onCreatePanelMenu(panelFeatureState.VG, panelFeatureState.VK)) {
                    panelFeatureState.VR = false;
                } else {
                    panelFeatureState.e(null);
                    if (!z || this.Vg == null) {
                        return false;
                    }
                    this.Vg.a(null, this.Vh);
                    return false;
                }
            }
            panelFeatureState.VK.gx();
            if (panelFeatureState.VS != null) {
                panelFeatureState.VK.e(panelFeatureState.VS);
                panelFeatureState.VS = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.VJ, panelFeatureState.VK)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                panelFeatureState.VP = z;
                panelFeatureState.VK.setQwertyMode(panelFeatureState.VP);
                panelFeatureState.VK.gy();
            } else {
                if (z && this.Vg != null) {
                    this.Vg.a(null, this.Vh);
                }
                panelFeatureState.VK.gy();
                return false;
            }
        }
        panelFeatureState.VN = true;
        panelFeatureState.VO = false;
        this.Vv = panelFeatureState;
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void c(h hVar) {
        if (!this.Vt) {
            this.Vt = true;
            this.Vg.fy();
            Callback callback = this.Ti.getCallback();
            if (!(callback == null || this.UP)) {
                callback.onPanelClosed(108, hVar);
            }
            this.Vt = false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void fw() {
        a(bh(0), true);
    }

    /* Access modifiers changed, original: final */
    public final void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.VG == 0 && this.Vg != null && this.Vg.isOverflowMenuShowing()) {
            c(panelFeatureState.VK);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.RP || panelFeatureState.VH == null)) {
            windowManager.removeView(panelFeatureState.VH);
            if (z) {
                a(panelFeatureState.VG, panelFeatureState, null);
            }
        }
        panelFeatureState.VN = false;
        panelFeatureState.VO = false;
        panelFeatureState.RP = false;
        panelFeatureState.VI = null;
        panelFeatureState.VQ = true;
        if (this.Vv == panelFeatureState) {
            this.Vv = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.Vu.length) {
                panelFeatureState = this.Vu[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.VK;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.RP) && !this.UP) {
            this.UG.onPanelClosed(i, menu);
        }
    }

    /* Access modifiers changed, original: final */
    public final PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Vu;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.VK == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final PanelFeatureState bh(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.Vu;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.Vu = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.VN || b(panelFeatureState, keyEvent)) && panelFeatureState.VK != null) {
            return panelFeatureState.VK.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i) {
        this.Vy |= 1 << i;
        if (!this.Vx) {
            s.b(this.Ti.getDecorView(), this.Vz);
            this.Vx = true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void bi(int i) {
        PanelFeatureState bh = bh(i);
        if (bh.VK != null) {
            Bundle bundle = new Bundle();
            bh.VK.d(bundle);
            if (bundle.size() > 0) {
                bh.VS = bundle;
            }
            bh.VK.gx();
            bh.VK.clear();
        }
        bh.VR = true;
        bh.VQ = true;
        if ((i == 108 || i == 0) && this.Vg != null) {
            bh = bh(0);
            if (bh != null) {
                bh.VN = false;
                b(bh, null);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final int bj(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.Vk == null || !(this.Vk.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            int i6;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.Vk.getLayoutParams();
            if (this.Vk.isShown()) {
                if (this.qS == null) {
                    this.qS = new Rect();
                    this.qT = new Rect();
                }
                Rect rect = this.qS;
                Rect rect2 = this.qT;
                rect.set(0, i, 0, 0);
                bk.a(this.Vp, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.Vq == null) {
                        this.Vq = new View(this.mContext);
                        this.Vq.setBackgroundColor(this.mContext.getResources().getColor(R.color.dl));
                        this.Vp.addView(this.Vq, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.Vq.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.Vq.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.Vq == null) {
                    i3 = 0;
                }
                if (!(this.UL || i3 == 0)) {
                    i = 0;
                }
                i6 = i3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 1;
                i6 = 0;
            } else {
                i5 = 0;
                i6 = 0;
            }
            if (i5 != 0) {
                this.Vk.setLayoutParams(marginLayoutParams);
            }
            i2 = i6;
        }
        if (this.Vq != null) {
            View view = this.Vq;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void fx() {
        if (this.Vo) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private static int bk(int i) {
        if (i == 8) {
            return 108;
        }
        if (i == 9) {
            return 109;
        }
        return i;
    }

    /* Access modifiers changed, original: final */
    public final void fy() {
        if (this.Vg != null) {
            this.Vg.fy();
        }
        if (this.Vl != null) {
            this.Ti.getDecorView().removeCallbacks(this.Vm);
            if (this.Vl.isShowing()) {
                try {
                    this.Vl.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.Vl = null;
        }
        fv();
        PanelFeatureState bh = bh(0);
        if (bh != null && bh.VK != null) {
            bh.VK.close();
        }
    }

    public final boolean a(h hVar, MenuItem menuItem) {
        Callback callback = this.Ti.getCallback();
        if (!(callback == null || this.UP)) {
            PanelFeatureState a = a(hVar.gE());
            if (a != null) {
                return callback.onMenuItemSelected(a.VG, menuItem);
            }
        }
        return false;
    }
}
