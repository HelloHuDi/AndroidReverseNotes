package android.support.p069v7.app;

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
import android.support.p057v4.app.C0355t;
import android.support.p057v4.p065f.C0407f;
import android.support.p057v4.view.C0451aa;
import android.support.p057v4.view.C0458e;
import android.support.p057v4.view.C0472o;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0497w;
import android.support.p057v4.view.C6203y;
import android.support.p057v4.widget.C0535n;
import android.support.p069v7.app.C0581j.C0580a;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.view.C0606d;
import android.support.p069v7.view.C6229e;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C0630p;
import android.support.p069v7.view.menu.C6235f;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.widget.ActionBarContextView;
import android.support.p069v7.widget.AppCompatAutoCompleteTextView;
import android.support.p069v7.widget.AppCompatButton;
import android.support.p069v7.widget.AppCompatCheckBox;
import android.support.p069v7.widget.AppCompatCheckedTextView;
import android.support.p069v7.widget.AppCompatEditText;
import android.support.p069v7.widget.AppCompatImageButton;
import android.support.p069v7.widget.AppCompatImageView;
import android.support.p069v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.p069v7.widget.AppCompatRadioButton;
import android.support.p069v7.widget.AppCompatRatingBar;
import android.support.p069v7.widget.AppCompatSeekBar;
import android.support.p069v7.widget.AppCompatSpinner;
import android.support.p069v7.widget.AppCompatTextView;
import android.support.p069v7.widget.C0684ad;
import android.support.p069v7.widget.C0684ad.C0683a;
import android.support.p069v7.widget.C0697az;
import android.support.p069v7.widget.C0706bh;
import android.support.p069v7.widget.C0709bk;
import android.support.p069v7.widget.C0716i;
import android.support.p069v7.widget.C0727w;
import android.support.p069v7.widget.ContentFrameLayout;
import android.support.p069v7.widget.ContentFrameLayout.C0650a;
import android.support.p069v7.widget.Toolbar;
import android.support.p069v7.widget.ViewStubCompat;
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
import com.tencent.p177mm.C25738R;
import com.tencent.view.C31128d;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v7.app.AppCompatDelegateImplV9 */
class AppCompatDelegateImplV9 extends C6217e implements C0623a, Factory2 {
    /* renamed from: Vf */
    private static final boolean f2066Vf = (VERSION.SDK_INT < 21);
    /* renamed from: TF */
    private TextView f2067TF;
    /* renamed from: VA */
    private boolean f2068VA;
    /* renamed from: VB */
    private C0581j f2069VB;
    /* renamed from: Vg */
    private C0727w f2070Vg;
    /* renamed from: Vh */
    private C6209a f2071Vh;
    /* renamed from: Vi */
    private C6213d f2072Vi;
    /* renamed from: Vj */
    C0604b f2073Vj;
    /* renamed from: Vk */
    ActionBarContextView f2074Vk;
    /* renamed from: Vl */
    PopupWindow f2075Vl;
    /* renamed from: Vm */
    Runnable f2076Vm;
    /* renamed from: Vn */
    C0497w f2077Vn = null;
    /* renamed from: Vo */
    private boolean f2078Vo;
    /* renamed from: Vp */
    private ViewGroup f2079Vp;
    /* renamed from: Vq */
    private View f2080Vq;
    /* renamed from: Vr */
    private boolean f2081Vr;
    /* renamed from: Vs */
    private boolean f2082Vs;
    /* renamed from: Vt */
    private boolean f2083Vt;
    /* renamed from: Vu */
    private PanelFeatureState[] f2084Vu;
    /* renamed from: Vv */
    private PanelFeatureState f2085Vv;
    /* renamed from: Vw */
    private boolean f2086Vw;
    /* renamed from: Vx */
    boolean f2087Vx;
    /* renamed from: Vy */
    int f2088Vy;
    /* renamed from: Vz */
    private final Runnable f2089Vz = new C05691();
    /* renamed from: qS */
    private Rect f2090qS;
    /* renamed from: qT */
    private Rect f2091qT;

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$1 */
    class C05691 implements Runnable {
        C05691() {
        }

        public final void run() {
            if ((AppCompatDelegateImplV9.this.f2088Vy & 1) != 0) {
                AppCompatDelegateImplV9.this.mo16356bi(0);
            }
            if ((AppCompatDelegateImplV9.this.f2088Vy & 4096) != 0) {
                AppCompatDelegateImplV9.this.mo16356bi(108);
            }
            AppCompatDelegateImplV9.this.f2087Vx = false;
            AppCompatDelegateImplV9.this.f2088Vy = 0;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$5 */
    class C05705 implements Runnable {

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$5$1 */
        class C05711 extends C6203y {
            C05711() {
            }

            /* renamed from: az */
            public final void mo1166az(View view) {
                AppCompatDelegateImplV9.this.f2074Vk.setVisibility(0);
            }

            /* renamed from: aA */
            public final void mo1164aA(View view) {
                AppCompatDelegateImplV9.this.f2074Vk.setAlpha(1.0f);
                AppCompatDelegateImplV9.this.f2077Vn.mo1153a(null);
                AppCompatDelegateImplV9.this.f2077Vn = null;
            }
        }

        C05705() {
        }

        public final void run() {
            AppCompatDelegateImplV9.this.f2075Vl.showAtLocation(AppCompatDelegateImplV9.this.f2074Vk, 55, 0, 0);
            AppCompatDelegateImplV9.this.mo16360fv();
            if (AppCompatDelegateImplV9.this.mo16359fu()) {
                AppCompatDelegateImplV9.this.f2074Vk.setAlpha(0.0f);
                AppCompatDelegateImplV9.this.f2077Vn = C0477s.m910ab(AppCompatDelegateImplV9.this.f2074Vk).mo1161t(1.0f);
                AppCompatDelegateImplV9.this.f2077Vn.mo1153a(new C05711());
                return;
            }
            AppCompatDelegateImplV9.this.f2074Vk.setAlpha(1.0f);
            AppCompatDelegateImplV9.this.f2074Vk.setVisibility(0);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$PanelFeatureState */
    protected static final class PanelFeatureState {
        /* renamed from: RP */
        boolean f848RP;
        /* renamed from: VG */
        int f849VG;
        /* renamed from: VH */
        ViewGroup f850VH;
        /* renamed from: VI */
        View f851VI;
        /* renamed from: VJ */
        View f852VJ;
        /* renamed from: VK */
        C6236h f853VK;
        /* renamed from: VL */
        C6235f f854VL;
        /* renamed from: VM */
        Context f855VM;
        /* renamed from: VN */
        boolean f856VN;
        /* renamed from: VO */
        boolean f857VO;
        /* renamed from: VP */
        public boolean f858VP;
        /* renamed from: VQ */
        boolean f859VQ = false;
        /* renamed from: VR */
        boolean f860VR;
        /* renamed from: VS */
        Bundle f861VS;
        int background;
        int gravity;
        int windowAnimations;
        /* renamed from: x */
        int f862x;
        /* renamed from: y */
        int f863y;

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$PanelFeatureState$SavedState */
        static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = new C05721();
            /* renamed from: RP */
            boolean f845RP;
            /* renamed from: VG */
            int f846VG;
            /* renamed from: ra */
            Bundle f847ra;

            /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$PanelFeatureState$SavedState$1 */
            static class C05721 implements ClassLoaderCreator<SavedState> {
                C05721() {
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m1246b(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return SavedState.m1246b(parcel, null);
                }
            }

            SavedState() {
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f846VG);
                parcel.writeInt(this.f845RP ? 1 : 0);
                if (this.f845RP) {
                    parcel.writeBundle(this.f847ra);
                }
            }

            /* renamed from: b */
            static SavedState m1246b(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.f846VG = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f845RP = z;
                if (savedState.f845RP) {
                    savedState.f847ra = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }

        PanelFeatureState(int i) {
            this.f849VG = i;
        }

        /* renamed from: fz */
        public final boolean mo1391fz() {
            if (this.f851VI == null) {
                return false;
            }
            if (this.f852VJ != null) {
                return true;
            }
            if (this.f854VL.getAdapter().getCount() > 0) {
                return true;
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: V */
        public final void mo1388V(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C25738R.attr.f5613ds, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C25738R.attr.f5678fj, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C25738R.style.f11239u0, true);
            }
            C0606d c0606d = new C0606d(context, 0);
            c0606d.getTheme().setTo(newTheme);
            this.f855VM = c0606d;
            TypedArray obtainStyledAttributes = c0606d.obtainStyledAttributes(C0554a.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(80, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: e */
        public final void mo1390e(C6236h c6236h) {
            if (c6236h != this.f853VK) {
                if (this.f853VK != null) {
                    this.f853VK.mo14126b(this.f854VL);
                }
                this.f853VK = c6236h;
                if (c6236h != null && this.f854VL != null) {
                    c6236h.mo14114a(this.f854VL);
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final C0630p mo1389b(C0627a c0627a) {
            if (this.f853VK == null) {
                return null;
            }
            if (this.f854VL == null) {
                this.f854VL = new C6235f(this.f855VM);
                this.f854VL.f1908lL = c0627a;
                this.f853VK.mo14114a(this.f854VL);
            }
            return this.f854VL.mo14107f(this.f850VH);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$2 */
    class C62062 implements C0472o {
        C62062() {
        }

        /* renamed from: a */
        public final C0451aa mo1083a(View view, C0451aa c0451aa) {
            int systemWindowInsetTop = c0451aa.getSystemWindowInsetTop();
            int bj = AppCompatDelegateImplV9.this.mo16357bj(systemWindowInsetTop);
            if (systemWindowInsetTop != bj) {
                c0451aa = c0451aa.mo1034f(c0451aa.getSystemWindowInsetLeft(), bj, c0451aa.getSystemWindowInsetRight(), c0451aa.getSystemWindowInsetBottom());
            }
            return C0477s.m900a(view, c0451aa);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$3 */
    class C62073 implements C0683a {
        C62073() {
        }

        /* renamed from: f */
        public final void mo1944f(Rect rect) {
            rect.top = AppCompatDelegateImplV9.this.mo16357bj(rect.top);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$4 */
    class C62084 implements C0650a {
        C62084() {
        }

        public final void onDetachedFromWindow() {
            AppCompatDelegateImplV9.this.mo16362fy();
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$a */
    final class C6209a implements C0627a {
        C6209a() {
        }

        /* renamed from: d */
        public final boolean mo1597d(C6236h c6236h) {
            Callback callback = AppCompatDelegateImplV9.this.f1816Ti.getCallback();
            if (callback != null) {
                callback.onMenuOpened(108, c6236h);
            }
            return true;
        }

        /* renamed from: a */
        public final void mo1596a(C6236h c6236h, boolean z) {
            AppCompatDelegateImplV9.this.mo16358c(c6236h);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$b */
    class C6210b implements C0603a {
        /* renamed from: VE */
        private C0603a f1800VE;

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$b$1 */
        class C62111 extends C6203y {
            C62111() {
            }

            /* renamed from: aA */
            public final void mo1164aA(View view) {
                AppCompatDelegateImplV9.this.f2074Vk.setVisibility(8);
                if (AppCompatDelegateImplV9.this.f2075Vl != null) {
                    AppCompatDelegateImplV9.this.f2075Vl.dismiss();
                } else if (AppCompatDelegateImplV9.this.f2074Vk.getParent() instanceof View) {
                    C0477s.m919ak((View) AppCompatDelegateImplV9.this.f2074Vk.getParent());
                }
                AppCompatDelegateImplV9.this.f2074Vk.removeAllViews();
                AppCompatDelegateImplV9.this.f2077Vn.mo1153a(null);
                AppCompatDelegateImplV9.this.f2077Vn = null;
            }
        }

        public C6210b(C0603a c0603a) {
            this.f1800VE = c0603a;
        }

        /* renamed from: a */
        public final boolean mo1485a(C0604b c0604b, Menu menu) {
            return this.f1800VE.mo1485a(c0604b, menu);
        }

        /* renamed from: b */
        public final boolean mo1487b(C0604b c0604b, Menu menu) {
            return this.f1800VE.mo1487b(c0604b, menu);
        }

        /* renamed from: a */
        public final boolean mo1486a(C0604b c0604b, MenuItem menuItem) {
            return this.f1800VE.mo1486a(c0604b, menuItem);
        }

        /* renamed from: a */
        public final void mo1484a(C0604b c0604b) {
            this.f1800VE.mo1484a(c0604b);
            if (AppCompatDelegateImplV9.this.f2075Vl != null) {
                AppCompatDelegateImplV9.this.f1816Ti.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.f2076Vm);
            }
            if (AppCompatDelegateImplV9.this.f2074Vk != null) {
                AppCompatDelegateImplV9.this.mo16360fv();
                AppCompatDelegateImplV9.this.f2077Vn = C0477s.m910ab(AppCompatDelegateImplV9.this.f2074Vk).mo1161t(0.0f);
                AppCompatDelegateImplV9.this.f2077Vn.mo1153a(new C62111());
            }
            if (AppCompatDelegateImplV9.this.f1819UI != null) {
                AppCompatDelegateImplV9.this.f1819UI.onSupportActionModeFinished(AppCompatDelegateImplV9.this.f2073Vj);
            }
            AppCompatDelegateImplV9.this.f2073Vj = null;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$c */
    class C6212c extends ContentFrameLayout {
        public C6212c(Context context) {
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
                    AppCompatDelegateImplV9.this.mo16361fw();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(C0589b.m1275g(getContext(), i));
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$d */
    final class C6213d implements C0627a {
        C6213d() {
        }

        /* renamed from: a */
        public final void mo1596a(C6236h c6236h, boolean z) {
            Menu c6236h2;
            Menu gE = c6236h2.mo14141gE();
            boolean z2 = gE != c6236h2;
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
            if (z2) {
                c6236h2 = gE;
            }
            PanelFeatureState a = appCompatDelegateImplV9.mo16351a(c6236h2);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV9.this.mo16353a(a.f849VG, a, gE);
                AppCompatDelegateImplV9.this.mo16354a(a, true);
                return;
            }
            AppCompatDelegateImplV9.this.mo16354a(a, z);
        }

        /* renamed from: d */
        public final boolean mo1597d(C6236h c6236h) {
            if (c6236h == null && AppCompatDelegateImplV9.this.f1820UJ) {
                Callback callback = AppCompatDelegateImplV9.this.f1816Ti.getCallback();
                if (!(callback == null || AppCompatDelegateImplV9.this.f1826UP)) {
                    callback.onMenuOpened(108, c6236h);
                }
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV9$6 */
    class C74516 extends C6203y {
        C74516() {
        }

        /* renamed from: az */
        public final void mo1166az(View view) {
            AppCompatDelegateImplV9.this.f2074Vk.setVisibility(0);
            AppCompatDelegateImplV9.this.f2074Vk.sendAccessibilityEvent(32);
            if (AppCompatDelegateImplV9.this.f2074Vk.getParent() instanceof View) {
                C0477s.m919ak((View) AppCompatDelegateImplV9.this.f2074Vk.getParent());
            }
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            AppCompatDelegateImplV9.this.f2074Vk.setAlpha(1.0f);
            AppCompatDelegateImplV9.this.f2077Vn.mo1153a(null);
            AppCompatDelegateImplV9.this.f2077Vn = null;
        }
    }

    AppCompatDelegateImplV9(Context context, Window window, C0575c c0575c) {
        super(context, window, c0575c);
    }

    public void onCreate(Bundle bundle) {
        if ((this.f1817UG instanceof Activity) && C0355t.m585g((Activity) this.f1817UG) != null) {
            ActionBar actionBar = this.mActionBar;
            if (actionBar == null) {
                this.f2068VA = true;
            } else {
                actionBar.mo1331K(true);
            }
        }
    }

    /* renamed from: fj */
    public final void mo1399fj() {
        m12739fr();
    }

    /* renamed from: fn */
    public final void mo14036fn() {
        m12739fr();
        if (this.f1820UJ && this.mActionBar == null) {
            if (this.f1817UG instanceof Activity) {
                this.mActionBar = new C6226o((Activity) this.f1817UG, this.f1821UK);
            } else if (this.f1817UG instanceof Dialog) {
                this.mActionBar = new C6226o((Dialog) this.f1817UG);
            }
            if (this.mActionBar != null) {
                this.mActionBar.mo1331K(this.f2068VA);
            }
        }
    }

    public final void setSupportActionBar(Toolbar toolbar) {
        if (this.f1817UG instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof C6226o) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f1827mY = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                C6223l c6223l = new C6223l(toolbar, ((Activity) this.f1817UG).getTitle(), this.f1818UH);
                this.mActionBar = c6223l;
                this.f1816Ti.setCallback(c6223l.f1835Wm);
            } else {
                this.mActionBar = null;
                this.f1816Ti.setCallback(this.f1818UH);
            }
            invalidateOptionsMenu();
        }
    }

    public final <T extends View> T findViewById(int i) {
        m12739fr();
        return this.f1816Ti.findViewById(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.f1820UJ && this.f2078Vo) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
        C0716i hE = C0716i.m1606hE();
        Context context = this.mContext;
        synchronized (hE.afH) {
            C0407f c0407f = (C0407f) hE.afI.get(context);
            if (c0407f != null) {
                c0407f.clear();
            }
        }
        mo1401fl();
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.mo1332L(false);
        }
    }

    public final void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.mo1332L(true);
        }
    }

    public final void setContentView(View view) {
        m12739fr();
        ViewGroup viewGroup = (ViewGroup) this.f2079Vp.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1817UG.onContentChanged();
    }

    public final void setContentView(int i) {
        m12739fr();
        ViewGroup viewGroup = (ViewGroup) this.f2079Vp.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.f1817UG.onContentChanged();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        m12739fr();
        ViewGroup viewGroup = (ViewGroup) this.f2079Vp.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1817UG.onContentChanged();
    }

    public final void addContentView(View view, LayoutParams layoutParams) {
        m12739fr();
        ((ViewGroup) this.f2079Vp.findViewById(16908290)).addView(view, layoutParams);
        this.f1817UG.onContentChanged();
    }

    public void onDestroy() {
        if (this.f2087Vx) {
            this.f1816Ti.getDecorView().removeCallbacks(this.f2089Vz);
        }
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
    }

    /* renamed from: fr */
    private void m12739fr() {
        if (!this.f2078Vo) {
            this.f2079Vp = m12740fs();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                mo14039k(title);
            }
            m12741ft();
            this.f2078Vo = true;
            PanelFeatureState bh = mo16355bh(0);
            if (!this.f1826UP) {
                if (bh == null || bh.f853VK == null) {
                    invalidatePanelMenu(108);
                }
            }
        }
    }

    /* renamed from: fs */
    private ViewGroup m12740fs() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(C0554a.AppCompatTheme);
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
            this.f1823UM = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            this.f1816Ti.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.mContext);
            ViewGroup viewGroup2;
            if (this.f1824UN) {
                View view;
                if (this.f1822UL) {
                    view = (ViewGroup) from.inflate(2130968605, null);
                } else {
                    view = (ViewGroup) from.inflate(2130968604, null);
                }
                View viewGroup3;
                if (VERSION.SDK_INT >= 21) {
                    C0477s.m906a(view, new C62062());
                    viewGroup3 = view;
                } else {
                    ((C0684ad) view).setOnFitSystemWindowsListener(new C62073());
                    viewGroup3 = view;
                }
            } else if (this.f1823UM) {
                viewGroup2 = (ViewGroup) from.inflate(2130968595, null);
                this.f1821UK = false;
                this.f1820UJ = false;
                viewGroup3 = viewGroup2;
            } else if (this.f1820UJ) {
                Context c0606d;
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(C25738R.attr.f5616dv, typedValue, true);
                if (typedValue.resourceId != 0) {
                    c0606d = new C0606d(this.mContext, typedValue.resourceId);
                } else {
                    c0606d = this.mContext;
                }
                viewGroup2 = (ViewGroup) LayoutInflater.from(c0606d).inflate(2130968606, null);
                this.f2070Vg = (C0727w) viewGroup2.findViewById(2131820939);
                this.f2070Vg.setWindowCallback(this.f1816Ti.getCallback());
                if (this.f1821UK) {
                    this.f2070Vg.mo2132bs(109);
                }
                if (this.f2081Vr) {
                    this.f2070Vg.mo2132bs(2);
                }
                if (this.f2082Vs) {
                    this.f2070Vg.mo2132bs(5);
                }
                viewGroup3 = viewGroup2;
            } else {
                viewGroup3 = null;
            }
            if (viewGroup3 == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f1820UJ + ", windowActionBarOverlay: " + this.f1821UK + ", android:windowIsFloating: " + this.f1823UM + ", windowActionModeOverlay: " + this.f1822UL + ", windowNoTitle: " + this.f1824UN + " }");
            }
            if (this.f2070Vg == null) {
                this.f2067TF = (TextView) viewGroup3.findViewById(2131820678);
            }
            C0709bk.m1577bX(viewGroup3);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup3.findViewById(2131820544);
            ViewGroup viewGroup4 = (ViewGroup) this.f1816Ti.findViewById(16908290);
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
            this.f1816Ti.setContentView(viewGroup3);
            contentFrameLayout.setAttachListener(new C62084());
            return viewGroup3;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: ft */
    private void m12741ft() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f2079Vp.findViewById(16908290);
        View decorView = this.f1816Ti.getDecorView();
        contentFrameLayout.mo1699j(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(C0554a.AppCompatTheme);
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
        int bk = AppCompatDelegateImplV9.m12737bk(i);
        if (this.f1824UN && bk == 108) {
            return false;
        }
        if (this.f1820UJ && bk == 1) {
            this.f1820UJ = false;
        }
        switch (bk) {
            case 1:
                m12742fx();
                this.f1824UN = true;
                return true;
            case 2:
                m12742fx();
                this.f2081Vr = true;
                return true;
            case 5:
                m12742fx();
                this.f2082Vs = true;
                return true;
            case 10:
                m12742fx();
                this.f1822UL = true;
                return true;
            case 108:
                m12742fx();
                this.f1820UJ = true;
                return true;
            case 109:
                m12742fx();
                this.f1821UK = true;
                return true;
            default:
                return this.f1816Ti.requestFeature(bk);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: k */
    public final void mo14039k(CharSequence charSequence) {
        if (this.f2070Vg != null) {
            this.f2070Vg.setWindowTitle(charSequence);
        } else if (this.mActionBar != null) {
            this.mActionBar.setWindowTitle(charSequence);
        } else if (this.f2067TF != null) {
            this.f2067TF.setText(charSequence);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bd */
    public final void mo14033bd(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.mo1333M(false);
            }
        } else if (i == 0) {
            PanelFeatureState bh = mo16355bh(i);
            if (bh.f848RP) {
                mo16354a(bh, false);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: be */
    public final boolean mo14034be(int i) {
        if (i != 108) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return true;
        }
        supportActionBar.mo1333M(true);
        return true;
    }

    /* renamed from: b */
    public final void mo1585b(C6236h c6236h) {
        if (this.f2070Vg == null || !this.f2070Vg.mo2134gV() || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.f2070Vg.mo2135gW())) {
            PanelFeatureState bh = mo16355bh(0);
            bh.f859VQ = true;
            mo16354a(bh, false);
            m12731a(bh, null);
            return;
        }
        Callback callback = this.f1816Ti.getCallback();
        if (this.f2070Vg.isOverflowMenuShowing()) {
            this.f2070Vg.hideOverflowMenu();
            if (!this.f1826UP) {
                callback.onPanelClosed(108, mo16355bh(0).f853VK);
            }
        } else if (callback != null && !this.f1826UP) {
            if (this.f2087Vx && (this.f2088Vy & 1) != 0) {
                this.f1816Ti.getDecorView().removeCallbacks(this.f2089Vz);
                this.f2089Vz.run();
            }
            PanelFeatureState bh2 = mo16355bh(0);
            if (bh2.f853VK != null && !bh2.f860VR && callback.onPreparePanel(0, bh2.f852VJ, bh2.f853VK)) {
                callback.onMenuOpened(108, bh2.f853VK);
                this.f2070Vg.showOverflowMenu();
            }
        }
    }

    public final C0604b startSupportActionMode(C0603a c0603a) {
        if (c0603a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f2073Vj != null) {
            this.f2073Vj.finish();
        }
        C0603a c6210b = new C6210b(c0603a);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.f2073Vj = supportActionBar.mo1334a(c6210b);
            if (!(this.f2073Vj == null || this.f1819UI == null)) {
                this.f1819UI.onSupportActionModeStarted(this.f2073Vj);
            }
        }
        if (this.f2073Vj == null) {
            this.f2073Vj = mo14032b(c6210b);
        }
        return this.f2073Vj;
    }

    public final void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.mo1344fh()) {
            invalidatePanelMenu(0);
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final C0604b mo14032b(C0603a c0603a) {
        C0604b onWindowStartingSupportActionMode;
        mo16360fv();
        if (this.f2073Vj != null) {
            this.f2073Vj.finish();
        }
        if (!(this.f1819UI == null || this.f1826UP)) {
            try {
                onWindowStartingSupportActionMode = this.f1819UI.onWindowStartingSupportActionMode(c0603a);
            } catch (AbstractMethodError e) {
            }
            if (onWindowStartingSupportActionMode == null) {
                this.f2073Vj = onWindowStartingSupportActionMode;
            } else {
                if (this.f2074Vk == null) {
                    if (this.f1823UM) {
                        Context c0606d;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = this.mContext.getTheme();
                        theme.resolveAttribute(C25738R.attr.f5616dv, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = this.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            c0606d = new C0606d(this.mContext, 0);
                            c0606d.getTheme().setTo(newTheme);
                        } else {
                            c0606d = this.mContext;
                        }
                        this.f2074Vk = new ActionBarContextView(c0606d);
                        this.f2075Vl = new PopupWindow(c0606d, null, C25738R.attr.f5635ed);
                        C0535n.m1157a(this.f2075Vl, 2);
                        this.f2075Vl.setContentView(this.f2074Vk);
                        this.f2075Vl.setWidth(-1);
                        c0606d.getTheme().resolveAttribute(C25738R.attr.f5618dx, typedValue, true);
                        this.f2074Vk.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0606d.getResources().getDisplayMetrics()));
                        this.f2075Vl.setHeight(-2);
                        this.f2076Vm = new C05705();
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.f2079Vp.findViewById(2131820937);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(mo14037fo()));
                            this.f2074Vk = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (this.f2074Vk != null) {
                    boolean z;
                    mo16360fv();
                    this.f2074Vk.mo14231gS();
                    Context context = this.f2074Vk.getContext();
                    ActionBarContextView actionBarContextView = this.f2074Vk;
                    if (this.f2075Vl == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    C0604b c6229e = new C6229e(context, actionBarContextView, c0603a, z);
                    if (c0603a.mo1485a(c6229e, c6229e.getMenu())) {
                        c6229e.invalidate();
                        this.f2074Vk.mo14229c(c6229e);
                        this.f2073Vj = c6229e;
                        if (mo16359fu()) {
                            this.f2074Vk.setAlpha(0.0f);
                            this.f2077Vn = C0477s.m910ab(this.f2074Vk).mo1161t(1.0f);
                            this.f2077Vn.mo1153a(new C74516());
                        } else {
                            this.f2074Vk.setAlpha(1.0f);
                            this.f2074Vk.setVisibility(0);
                            this.f2074Vk.sendAccessibilityEvent(32);
                            if (this.f2074Vk.getParent() instanceof View) {
                                C0477s.m919ak((View) this.f2074Vk.getParent());
                            }
                        }
                        if (this.f2075Vl != null) {
                            this.f1816Ti.getDecorView().post(this.f2076Vm);
                        }
                    } else {
                        this.f2073Vj = null;
                    }
                }
            }
            if (!(this.f2073Vj == null || this.f1819UI == null)) {
                this.f1819UI.onSupportActionModeStarted(this.f2073Vj);
            }
            return this.f2073Vj;
        }
        onWindowStartingSupportActionMode = null;
        if (onWindowStartingSupportActionMode == null) {
        }
        this.f1819UI.onSupportActionModeStarted(this.f2073Vj);
        return this.f2073Vj;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fu */
    public final boolean mo16359fu() {
        return this.f2078Vo && this.f2079Vp != null && C0477s.m927as(this.f2079Vp);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fv */
    public final void mo16360fv() {
        if (this.f2077Vn != null) {
            this.f2077Vn.cancel();
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.f2085Vv == null || !m12733a(this.f2085Vv, keyEvent.getKeyCode(), keyEvent)) {
            if (this.f2085Vv == null) {
                PanelFeatureState bh = mo16355bh(0);
                m12736b(bh, keyEvent);
                boolean a = m12733a(bh, keyEvent.getKeyCode(), keyEvent);
                bh.f856VN = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.f2085Vv == null) {
            return true;
        } else {
            this.f2085Vv.f857VO = true;
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.f1817UG.dispatchKeyEvent(keyEvent)) {
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
                    this.f2086Vw = (keyEvent.getFlags() & 128) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState bh = mo16355bh(0);
                    if (bh.f848RP) {
                        return true;
                    }
                    m12736b(bh, keyEvent);
                    return true;
            }
            return false;
        }
        PanelFeatureState bh2;
        switch (keyCode) {
            case 4:
                z = this.f2086Vw;
                this.f2086Vw = false;
                bh2 = mo16355bh(0);
                if (bh2 == null || !bh2.f848RP) {
                    if (this.f2073Vj != null) {
                        this.f2073Vj.finish();
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
                    mo16354a(bh2, true);
                    return true;
                }
                break;
            case 82:
                if (this.f2073Vj != null) {
                    return true;
                }
                bh2 = mo16355bh(0);
                if (this.f2070Vg == null || !this.f2070Vg.mo2134gV() || ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                    if (bh2.f848RP || bh2.f857VO) {
                        z = bh2.f848RP;
                        mo16354a(bh2, true);
                    } else {
                        if (bh2.f856VN) {
                            if (bh2.f860VR) {
                                bh2.f856VN = false;
                                z = m12736b(bh2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                m12731a(bh2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.f2070Vg.isOverflowMenuShowing()) {
                    z = this.f2070Vg.hideOverflowMenu();
                } else {
                    if (!this.f1826UP && m12736b(bh2, keyEvent)) {
                        z = this.f2070Vg.showOverflowMenu();
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
    /* renamed from: a */
    private View m12730a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        Context context2;
        int resourceId;
        int resourceId2;
        Context context3;
        View appCompatTextView;
        View view2;
        int i = 1;
        if (this.f2069VB == null) {
            String string = this.mContext.obtainStyledAttributes(C0554a.AppCompatTheme).getString(C31128d.MIC_AVROUND_BLUR);
            if (string == null || C0581j.class.getName().equals(string)) {
                this.f2069VB = new C0581j();
            } else {
                try {
                    this.f2069VB = (C0581j) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    new StringBuilder("Failed to instantiate custom view inflater ").append(string).append(". Falling back to default.");
                    this.f2069VB = new C0581j();
                }
            }
        }
        if (!f2066Vf) {
            z = false;
        } else if (!(attributeSet instanceof XmlPullParser)) {
            z = m12734a((ViewParent) view);
        } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
            z = true;
        } else {
            z = false;
        }
        C0581j c0581j = this.f2069VB;
        boolean z2 = f2066Vf;
        boolean lw = C0706bh.m1569lw();
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C0554a.View, 0, 0);
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
        if (resourceId2 == 0 || ((context2 instanceof C0606d) && ((C0606d) context2).f942YN == resourceId2)) {
            context3 = context2;
        } else {
            context3 = new C0606d(context2, resourceId2);
        }
        if (lw) {
            context3 = C0697az.m1552ad(context3);
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
            view2 = c0581j.mo1424a(context3, str, attributeSet);
        }
        if (view2 != null) {
            context2 = view2.getContext();
            if ((context2 instanceof ContextWrapper) && (VERSION.SDK_INT < 15 || C0477s.m931aw(view2))) {
                TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, C0581j.f879VU);
                String string2 = obtainStyledAttributes2.getString(0);
                if (string2 != null) {
                    view2.setOnClickListener(new C0580a(view2, string2));
                }
                obtainStyledAttributes2.recycle();
            }
        }
        return view2;
    }

    /* renamed from: a */
    private boolean m12734a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.f1816Ti.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || C0477s.m930av((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    /* renamed from: fk */
    public final void mo1400fk() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            C0458e.m789b(from, this);
        } else {
            from.getFactory2();
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo16352a(str, context, attributeSet);
        return a != null ? a : m12730a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public View mo16352a(String str, Context context, AttributeSet attributeSet) {
        if (this.f1817UG instanceof Factory) {
            View onCreateView = ((Factory) this.f1817UG).onCreateView(str, context, attributeSet);
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
    /* renamed from: a */
    private void m12731a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i = -1;
        if (!panelFeatureState.f848RP && !this.f1826UP) {
            if (panelFeatureState.f849VG == 0) {
                if ((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Callback callback = this.f1816Ti.getCallback();
            if (callback == null || callback.onMenuOpened(panelFeatureState.f849VG, panelFeatureState.f853VK)) {
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null && m12736b(panelFeatureState, keyEvent)) {
                    LayoutParams layoutParams;
                    if (panelFeatureState.f850VH == null || panelFeatureState.f859VQ) {
                        if (panelFeatureState.f850VH == null) {
                            m12732a(panelFeatureState);
                            if (panelFeatureState.f850VH == null) {
                                return;
                            }
                        } else if (panelFeatureState.f859VQ && panelFeatureState.f850VH.getChildCount() > 0) {
                            panelFeatureState.f850VH.removeAllViews();
                        }
                        if (m12738c(panelFeatureState) && panelFeatureState.mo1391fz()) {
                            LayoutParams layoutParams2;
                            layoutParams = panelFeatureState.f851VI.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams2 = new LayoutParams(-2, -2);
                            } else {
                                layoutParams2 = layoutParams;
                            }
                            panelFeatureState.f850VH.setBackgroundResource(panelFeatureState.background);
                            ViewParent parent = panelFeatureState.f851VI.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.f851VI);
                            }
                            panelFeatureState.f850VH.addView(panelFeatureState.f851VI, layoutParams2);
                            if (!panelFeatureState.f851VI.hasFocus()) {
                                panelFeatureState.f851VI.requestFocus();
                            }
                            i = -2;
                        } else {
                            return;
                        }
                    }
                    if (panelFeatureState.f852VJ != null) {
                        layoutParams = panelFeatureState.f852VJ.getLayoutParams();
                        if (layoutParams != null) {
                        }
                    }
                    i = -2;
                    panelFeatureState.f857VO = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f862x, panelFeatureState.f863y, 1002, 8519680, -3);
                    layoutParams3.gravity = panelFeatureState.gravity;
                    layoutParams3.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.f850VH, layoutParams3);
                    panelFeatureState.f848RP = true;
                    return;
                }
                return;
            }
            mo16354a(panelFeatureState, true);
        }
    }

    /* renamed from: a */
    private boolean m12732a(PanelFeatureState panelFeatureState) {
        panelFeatureState.mo1388V(mo14037fo());
        panelFeatureState.f850VH = new C6212c(panelFeatureState.f855VM);
        panelFeatureState.gravity = 81;
        return true;
    }

    /* renamed from: b */
    private boolean m12735b(PanelFeatureState panelFeatureState) {
        Context c0606d;
        C6236h c6236h;
        Context context = this.mContext;
        if ((panelFeatureState.f849VG == 0 || panelFeatureState.f849VG == 108) && this.f2070Vg != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C25738R.attr.f5616dv, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C25738R.attr.f5617dw, typedValue, true);
            } else {
                theme.resolveAttribute(C25738R.attr.f5617dw, typedValue, true);
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
                c0606d = new C0606d(context, 0);
                c0606d.getTheme().setTo(theme3);
                c6236h = new C6236h(c0606d);
                c6236h.mo14113a((C0623a) this);
                panelFeatureState.mo1390e(c6236h);
                return true;
            }
        }
        c0606d = context;
        c6236h = new C6236h(c0606d);
        c6236h.mo14113a((C0623a) this);
        panelFeatureState.mo1390e(c6236h);
        return true;
    }

    /* renamed from: c */
    private boolean m12738c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f852VJ != null) {
            panelFeatureState.f851VI = panelFeatureState.f852VJ;
            return true;
        } else if (panelFeatureState.f853VK == null) {
            return false;
        } else {
            if (this.f2072Vi == null) {
                this.f2072Vi = new C6213d();
            }
            panelFeatureState.f851VI = (View) panelFeatureState.mo1389b(this.f2072Vi);
            return panelFeatureState.f851VI != null;
        }
    }

    /* renamed from: b */
    private boolean m12736b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.f1826UP) {
            return false;
        }
        if (panelFeatureState.f856VN) {
            return true;
        }
        if (!(this.f2085Vv == null || this.f2085Vv == panelFeatureState)) {
            mo16354a(this.f2085Vv, false);
        }
        Callback callback = this.f1816Ti.getCallback();
        if (callback != null) {
            panelFeatureState.f852VJ = callback.onCreatePanelView(panelFeatureState.f849VG);
        }
        boolean z = panelFeatureState.f849VG == 0 || panelFeatureState.f849VG == 108;
        if (z && this.f2070Vg != null) {
            this.f2070Vg.mo2136gX();
        }
        if (panelFeatureState.f852VJ == null && !(z && (this.mActionBar instanceof C6223l))) {
            if (panelFeatureState.f853VK == null || panelFeatureState.f860VR) {
                if (panelFeatureState.f853VK == null) {
                    m12735b(panelFeatureState);
                    if (panelFeatureState.f853VK == null) {
                        return false;
                    }
                }
                if (z && this.f2070Vg != null) {
                    if (this.f2071Vh == null) {
                        this.f2071Vh = new C6209a();
                    }
                    this.f2070Vg.mo2131a(panelFeatureState.f853VK, this.f2071Vh);
                }
                panelFeatureState.f853VK.mo14146gx();
                if (callback.onCreatePanelMenu(panelFeatureState.f849VG, panelFeatureState.f853VK)) {
                    panelFeatureState.f860VR = false;
                } else {
                    panelFeatureState.mo1390e(null);
                    if (!z || this.f2070Vg == null) {
                        return false;
                    }
                    this.f2070Vg.mo2131a(null, this.f2071Vh);
                    return false;
                }
            }
            panelFeatureState.f853VK.mo14146gx();
            if (panelFeatureState.f861VS != null) {
                panelFeatureState.f853VK.mo14134e(panelFeatureState.f861VS);
                panelFeatureState.f861VS = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.f852VJ, panelFeatureState.f853VK)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                panelFeatureState.f858VP = z;
                panelFeatureState.f853VK.setQwertyMode(panelFeatureState.f858VP);
                panelFeatureState.f853VK.mo14147gy();
            } else {
                if (z && this.f2070Vg != null) {
                    this.f2070Vg.mo2131a(null, this.f2071Vh);
                }
                panelFeatureState.f853VK.mo14147gy();
                return false;
            }
        }
        panelFeatureState.f856VN = true;
        panelFeatureState.f857VO = false;
        this.f2085Vv = panelFeatureState;
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo16358c(C6236h c6236h) {
        if (!this.f2083Vt) {
            this.f2083Vt = true;
            this.f2070Vg.mo2133fy();
            Callback callback = this.f1816Ti.getCallback();
            if (!(callback == null || this.f1826UP)) {
                callback.onPanelClosed(108, c6236h);
            }
            this.f2083Vt = false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fw */
    public final void mo16361fw() {
        mo16354a(mo16355bh(0), true);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo16354a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.f849VG == 0 && this.f2070Vg != null && this.f2070Vg.isOverflowMenuShowing()) {
            mo16358c(panelFeatureState.f853VK);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.f848RP || panelFeatureState.f850VH == null)) {
            windowManager.removeView(panelFeatureState.f850VH);
            if (z) {
                mo16353a(panelFeatureState.f849VG, panelFeatureState, null);
            }
        }
        panelFeatureState.f856VN = false;
        panelFeatureState.f857VO = false;
        panelFeatureState.f848RP = false;
        panelFeatureState.f851VI = null;
        panelFeatureState.f859VQ = true;
        if (this.f2085Vv == panelFeatureState) {
            this.f2085Vv = null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo16353a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f2084Vu.length) {
                panelFeatureState = this.f2084Vu[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f853VK;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f848RP) && !this.f1826UP) {
            this.f1817UG.onPanelClosed(i, menu);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final PanelFeatureState mo16351a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f2084Vu;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f853VK == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bh */
    public final PanelFeatureState mo16355bh(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.f2084Vu;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f2084Vu = panelFeatureStateArr2;
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

    /* renamed from: a */
    private boolean m12733a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f856VN || m12736b(panelFeatureState, keyEvent)) && panelFeatureState.f853VK != null) {
            return panelFeatureState.f853VK.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i) {
        this.f2088Vy |= 1 << i;
        if (!this.f2087Vx) {
            C0477s.m934b(this.f1816Ti.getDecorView(), this.f2089Vz);
            this.f2087Vx = true;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bi */
    public final void mo16356bi(int i) {
        PanelFeatureState bh = mo16355bh(i);
        if (bh.f853VK != null) {
            Bundle bundle = new Bundle();
            bh.f853VK.mo14131d(bundle);
            if (bundle.size() > 0) {
                bh.f861VS = bundle;
            }
            bh.f853VK.mo14146gx();
            bh.f853VK.clear();
        }
        bh.f860VR = true;
        bh.f859VQ = true;
        if ((i == 108 || i == 0) && this.f2070Vg != null) {
            bh = mo16355bh(0);
            if (bh != null) {
                bh.f856VN = false;
                m12736b(bh, null);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bj */
    public final int mo16357bj(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f2074Vk == null || !(this.f2074Vk.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            int i6;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f2074Vk.getLayoutParams();
            if (this.f2074Vk.isShown()) {
                if (this.f2090qS == null) {
                    this.f2090qS = new Rect();
                    this.f2091qT = new Rect();
                }
                Rect rect = this.f2090qS;
                Rect rect2 = this.f2091qT;
                rect.set(0, i, 0, 0);
                C0709bk.m1575a(this.f2079Vp, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f2080Vq == null) {
                        this.f2080Vq = new View(this.mContext);
                        this.f2080Vq.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.f11687dl));
                        this.f2079Vp.addView(this.f2080Vq, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f2080Vq.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f2080Vq.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f2080Vq == null) {
                    i3 = 0;
                }
                if (!(this.f1822UL || i3 == 0)) {
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
                this.f2074Vk.setLayoutParams(marginLayoutParams);
            }
            i2 = i6;
        }
        if (this.f2080Vq != null) {
            View view = this.f2080Vq;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    /* renamed from: fx */
    private void m12742fx() {
        if (this.f2078Vo) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: bk */
    private static int m12737bk(int i) {
        if (i == 8) {
            return 108;
        }
        if (i == 9) {
            return 109;
        }
        return i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fy */
    public final void mo16362fy() {
        if (this.f2070Vg != null) {
            this.f2070Vg.mo2133fy();
        }
        if (this.f2075Vl != null) {
            this.f1816Ti.getDecorView().removeCallbacks(this.f2076Vm);
            if (this.f2075Vl.isShowing()) {
                try {
                    this.f2075Vl.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f2075Vl = null;
        }
        mo16360fv();
        PanelFeatureState bh = mo16355bh(0);
        if (bh != null && bh.f853VK != null) {
            bh.f853VK.close();
        }
    }

    /* renamed from: a */
    public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
        Callback callback = this.f1816Ti.getCallback();
        if (!(callback == null || this.f1826UP)) {
            PanelFeatureState a = mo16351a(c6236h.mo14141gE());
            if (a != null) {
                return callback.onMenuItemSelected(a.f849VG, menuItem);
            }
        }
        return false;
    }
}
