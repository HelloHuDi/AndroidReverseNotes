package com.tencent.p177mm.p612ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5536q.C55285;
import com.tencent.p177mm.p612ui.C5536q.C55317;
import com.tencent.p177mm.p612ui.C5536q.C55328;
import com.tencent.p177mm.p612ui.C5536q.C5534a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.plugin.appbrand.widget.input.C2559ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;

@C5271a(0)
/* renamed from: com.tencent.mm.ui.MMActivity */
public abstract class MMActivity extends MMFragmentActivity implements C2559ad {
    private static String ylp;
    String className;
    public C5186a ifE = null;
    public C5536q mController = new C73151();
    public boolean uiu = false;
    protected boolean ylk = false;
    protected boolean yll = false;
    protected boolean ylm = false;
    private ViewGroup yln = null;
    private View ylo;
    private long ylq = 0;
    private long ylr = 0;
    private long yls = 0;

    /* renamed from: com.tencent.mm.ui.MMActivity$a */
    public interface C5186a {
        /* renamed from: c */
        void mo6069c(int i, int i2, Intent intent);
    }

    /* renamed from: com.tencent.mm.ui.MMActivity$1 */
    class C73151 extends C5536q {
        C73151() {
        }

        /* Access modifiers changed, original: protected|final */
        public final int getLayoutId() {
            AppMethodBeat.m2504i(105985);
            int layoutId = MMActivity.this.getLayoutId();
            AppMethodBeat.m2505o(105985);
            return layoutId;
        }

        /* Access modifiers changed, original: protected|final */
        public final void dealContentView(View view) {
            AppMethodBeat.m2504i(105986);
            MMActivity.this.dealContentView(view);
            AppMethodBeat.m2505o(105986);
        }

        /* Access modifiers changed, original: protected|final */
        public final String bJj() {
            AppMethodBeat.m2504i(105987);
            String bJj = MMActivity.this.bJj();
            AppMethodBeat.m2505o(105987);
            return bJj;
        }

        /* Access modifiers changed, original: protected|final */
        public final View getLayoutView() {
            return null;
        }

        public final void onKeyboardStateChanged() {
            AppMethodBeat.m2504i(105988);
            MMActivity.this.onKeyboardStateChanged();
            AppMethodBeat.m2505o(105988);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCreateBeforeSetContentView() {
            AppMethodBeat.m2504i(105989);
            MMActivity.this.onCreateBeforeSetContentView();
            AppMethodBeat.m2505o(105989);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getClassName() {
            AppMethodBeat.m2504i(105990);
            String name = MMActivity.this.getClass().getName();
            AppMethodBeat.m2505o(105990);
            return name;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dxT() {
            AppMethodBeat.m2504i(105991);
            boolean dxT = MMActivity.this.dxT();
            AppMethodBeat.m2505o(105991);
            return dxT;
        }

        public final boolean noActionBar() {
            AppMethodBeat.m2504i(105992);
            boolean noActionBar = MMActivity.this.noActionBar();
            AppMethodBeat.m2505o(105992);
            return noActionBar;
        }

        public final boolean needShowIdcError() {
            AppMethodBeat.m2504i(105993);
            boolean needShowIdcError = MMActivity.this.needShowIdcError();
            AppMethodBeat.m2505o(105993);
            return needShowIdcError;
        }
    }

    public abstract int getLayoutId();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public void initView() {
    }

    public final void setBackGroundColorResource(int i) {
        this.mController.setBackGroundColorResource(i);
    }

    public final C5536q getController() {
        return this.mController;
    }

    public static Locale initLanguage(Context context) {
        return C5536q.initLanguage(context);
    }

    /* renamed from: bM */
    public static Locale m13632bM(Context context, String str) {
        return C5536q.m8327bM(context, str);
    }

    @Deprecated
    public final void dxR() {
        this.yll = true;
    }

    @Deprecated
    public final void dxS() {
        this.ylm = true;
    }

    /* Access modifiers changed, original: protected */
    public void onCreateBeforeSetContentView() {
    }

    /* Access modifiers changed, original: protected */
    public boolean dxT() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        if (!this.ylm) {
            this.yll = true;
        }
        super.onCreate(bundle);
        if (isHideStatusBar()) {
            this.yll = false;
        }
        this.mController.mo11174a(getApplicationContext(), (AppCompatActivity) this);
        initNavigationSwipeBack();
        mo17446xE(getResources().getColor(C25738R.color.f12206vy));
        mo17395bn(((float) C1338a.m2857am(this, C25738R.dimen.f9720dk)) * C1338a.m2862fY(this));
    }

    /* Access modifiers changed, original: protected */
    public void dealContentView(View view) {
        setContentView(view);
    }

    public boolean noActionBar() {
        return false;
    }

    public void onKeyboardStateChanged() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    public final View getContentView() {
        return this.mController.contentView;
    }

    public void onSwipeBack() {
        if (!apx()) {
            this.mController.callBackMenu();
        }
        super.onSwipeBack();
    }

    /* Access modifiers changed, original: protected */
    public void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            if (this.yll) {
                this.yln = new C7355b(this);
            } else {
                this.yln = new FrameLayout(this);
            }
            this.yln.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.yln);
            getSwipeBackLayout().setContentView(this.yln);
        }
    }

    public boolean apx() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int getForceOrientation() {
        return -1;
    }

    /* Access modifiers changed, original: protected */
    public void aBS() {
        if (getForceOrientation() == -1) {
            this.ylk = getSharedPreferences(C4996ah.doA(), 0).getBoolean("settings_landscape_mode", false);
            if (this.ylk) {
                setRequestedOrientation(-1);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        setRequestedOrientation(getForceOrientation());
    }

    public void onStart() {
        aBS();
        super.onStart();
    }

    @TargetApi(17)
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.mController.onKeyUp(i, keyEvent)) {
            return z;
        }
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMActivity", e, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
            return z;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mController.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean needShowIdcError() {
        return true;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        C5219ac.m7928bL(1, this.className);
        super.onResume();
        C4990ab.m7418v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        C4990ab.m7419v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
        if (this.ylr > this.ylq) {
            this.yls += this.ylr - this.ylq;
        }
        this.ylq = C5046bo.m7588yz();
        this.ylr = 0;
    }

    public void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    public final AppCompatActivity dxU() {
        return this.mController.ylL;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mController.mo11213hq(this);
        this.uiu = true;
    }

    public static void dxV() {
        C5536q.dxV();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        C5219ac.m7928bL(2, this.className);
        super.onPause();
        this.mController.onPause();
        boolean isFinishing = isFinishing();
        C4990ab.m7419v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing), Integer.valueOf(hashCode()));
        this.ylr = C5046bo.m7588yz();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.mController.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    /* Access modifiers changed, original: protected */
    public String bJj() {
        return "";
    }

    public final void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public final void setTitleVisibility(int i) {
        this.mController.setTitleVisibility(i);
    }

    /* renamed from: ta */
    public void mo17443ta(int i) {
        C5536q c5536q = this.mController;
        if (c5536q.mActionBar != null) {
            c5536q.ylQ.setTextColor(i);
        }
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    /* renamed from: M */
    public void mo17368M(CharSequence charSequence) {
        this.mController.mo11169M(charSequence);
    }

    public final void setMMTitle(int i) {
        this.mController.setMMTitle(i);
    }

    /* renamed from: bn */
    public final void mo17395bn(float f) {
        this.mController.mo11190bn(f);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public final void setMMSubTitle(int i) {
        this.mController.setMMSubTitle(i);
    }

    /* renamed from: MY */
    public final void mo17369MY(int i) {
        this.mController.ylQ.setVisibility(i);
    }

    public final void dxW() {
        C5536q c5536q = this.mController;
        if (VERSION.SDK_INT >= 23) {
            View decorView = c5536q.ylL.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }
    }

    /* renamed from: MZ */
    public final void mo17370MZ(int i) {
        this.mController.setTitleLogo(0, i);
    }

    public final void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public final void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public final void enableOptionMenu(boolean z) {
        this.mController.mo11192d(true, -1, z);
    }

    public final void enableOptionMenu(int i, boolean z) {
        this.mController.mo11192d(false, i, z);
    }

    public void showOptionMenu(boolean z) {
        this.mController.mo11200e(true, -1, z);
    }

    public void showOptionMenu(int i, boolean z) {
        this.mController.mo11200e(false, i, z);
    }

    public final boolean dxX() {
        Iterator it = this.mController.yfa.iterator();
        while (it.hasNext()) {
            C5534a c5534a = (C5534a) it.next();
            if (c5534a.yfi == 0) {
                return c5534a.enable;
            }
        }
        return false;
    }

    public final boolean dxY() {
        Iterator it = this.mController.yfa.iterator();
        while (it.hasNext()) {
            C5534a c5534a = (C5534a) it.next();
            if (c5534a.yfi == 0) {
                return c5534a.aIB;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo17380a(C5601o c5601o) {
        this.mController.addSearchMenu(true, c5601o);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    /* renamed from: a */
    public final void mo17382a(String str, int i, OnMenuItemClickListener onMenuItemClickListener) {
        C5536q c5536q = this.mController;
        C5535b c5535b = C5535b.NORMAL;
        C5534a c5534a = new C5534a();
        c5534a.yfi = 0;
        c5534a.text = str;
        c5534a.textColor = i;
        c5534a.gzB = onMenuItemClickListener;
        c5534a.mlV = null;
        c5534a.ymr = c5535b;
        c5536q.mo11171Nf(c5534a.yfi);
        c5536q.yfa.add(c5534a);
        new C7306ak().postDelayed(new C55328(), 200);
    }

    /* renamed from: a */
    public final void mo17379a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, C5535b c5535b) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener, null, c5535b);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    /* renamed from: a */
    public final void mo17378a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        C5536q c5536q = this.mController;
        C5535b c5535b = C5535b.NORMAL;
        C5534a c5534a = new C5534a();
        c5534a.yfi = i;
        c5534a.ymq = drawable;
        c5534a.text = str;
        c5534a.gzB = onMenuItemClickListener;
        c5534a.mlV = null;
        c5534a.ymr = c5535b;
        c5536q.mo11171Nf(c5534a.yfi);
        c5536q.yfa.add(c5534a);
        new C7306ak().postDelayed(new C55317(), 200);
    }

    /* renamed from: b */
    public final void mo17393b(String str, int i, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(0, str, i, onMenuItemClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener);
    }

    /* renamed from: a */
    public final void mo17377a(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(0, i, onMenuItemClickListener, onLongClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener, onLongClickListener);
    }

    /* renamed from: Na */
    public final void mo17371Na(int i) {
        this.mController.updateOptionMenuIcon(0, i);
    }

    public final void updateOptionMenuText(int i, String str) {
        this.mController.updateOptionMenuText(i, str);
    }

    /* renamed from: a */
    public final void mo17376a(int i, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.updateOptionMenuListener(i, onMenuItemClickListener, null);
    }

    public final void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    /* renamed from: b */
    public final void mo17392b(Runnable runnable, Runnable runnable2) {
        C5536q c5536q = this.mController;
        if (c5536q.mActionBar != null) {
            c5536q.mActionBar.getCustomView().setOnClickListener(new C55285(runnable, runnable2));
        }
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.mController.setBackBtn(onMenuItemClickListener, i);
    }

    public final void dxZ() {
        C5536q c5536q = this.mController;
        if (c5536q.ylS != null) {
            c5536q.ylS.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
    }

    /* renamed from: xE */
    public void mo17446xE(int i) {
        this.mController.mo11249xE(i);
    }

    public final void dya() {
        C5536q c5536q = this.mController;
        if (VERSION.SDK_INT >= 23) {
            View decorView = c5536q.ylL.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -17);
        }
    }

    /* renamed from: Nb */
    public final void mo17372Nb(int i) {
        this.mController.mo11170Nb(i);
    }

    /* renamed from: pO */
    public final void mo17426pO(boolean z) {
        C5536q c5536q = this.mController;
        c5536q.qlP = z;
        c5536q.dyo();
        c5536q.dyn();
    }

    /* renamed from: Nc */
    public final void mo17373Nc(int i) {
        C5536q c5536q = this.mController;
        c5536q.ylT = i;
        if (c5536q.ylS != null) {
            c5536q.ylS.setColorFilter(i, Mode.SRC_ATOP);
        }
        if (c5536q.ylQ != null && c5536q.ylQ.getVisibility() == 0) {
            c5536q.ylQ.setTextColor(i);
        }
        if (c5536q.jcI != null && c5536q.jcI.getVisibility() == 0) {
            c5536q.jcI.setTextColor(i);
        }
        if (c5536q.yeP != null && c5536q.yeP.getVisibility() == 0) {
            c5536q.yeP.getDrawable().setColorFilter(i, Mode.SRC_ATOP);
        } else if (c5536q.yeR != null && c5536q.yeR.getVisibility() == 0) {
            c5536q.yeR.setTextColor(i);
        }
    }

    public final void dyb() {
        C5536q c5536q = this.mController;
        if (VERSION.SDK_INT >= 21) {
            c5536q.getSupportActionBar().setElevation(0.0f);
        }
    }

    public final void dyc() {
        C5536q c5536q = this.mController;
        if (VERSION.SDK_INT >= 21) {
            c5536q.getSupportActionBar().setElevation(1.0f);
        }
    }

    /* renamed from: x */
    public final void mo17445x(Drawable drawable) {
        C5536q c5536q = this.mController;
        if (c5536q.mActionBar != null && c5536q.ylS != null && drawable != null) {
            c5536q.ylS.setImageDrawable(drawable);
            drawable.invalidateSelf();
        }
    }

    /* renamed from: pP */
    public final void mo17427pP(boolean z) {
        C5536q c5536q = this.mController;
        if (c5536q.ylS == null) {
            return;
        }
        if (z) {
            c5536q.ylS.setVisibility(0);
        } else {
            c5536q.ylS.setVisibility(8);
        }
    }

    public final void removeAllOptionMenu() {
        this.mController.removeAllOptionMenu();
    }

    public final boolean removeOptionMenu(int i) {
        return this.mController.removeOptionMenu(i);
    }

    public final int dyd() {
        return this.mController.dyj();
    }

    public final void hideTitleView() {
        this.mController.hideTitleView();
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.mController.setTitleMuteIconVisibility(i);
    }

    /* renamed from: Nd */
    public final void mo17374Nd(int i) {
        C5536q c5536q = this.mController;
        c5536q.ylJ = i == 0;
        c5536q.dym();
    }

    public final boolean aRp() {
        return this.mController.hideVKB();
    }

    public void aqX() {
        this.mController.hideVKB();
    }

    public void hideVKB(View view) {
        this.mController.hideVKB(view);
    }

    public void showVKB() {
        C5536q.showVKB(this.mController.ylL);
    }

    public static void showVKB(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void finish() {
        super.finish();
        int a = C5068w.m7682a(getIntent(), MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        int a2 = C5068w.m7682a(getIntent(), MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        if (a != -1) {
            super.overridePendingTransition(a, a2);
        }
    }

    /* renamed from: aA */
    public final void mo17383aA(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    /* renamed from: a */
    public final void mo17381a(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    /* renamed from: b */
    public final void mo17391b(C5186a c5186a, Intent intent, int i) {
        this.ifE = c5186a;
        startActivityForResult(intent, i);
    }

    public final void dye() {
        this.ifE = null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ifE != null) {
            this.ifE.mo6069c(i, i2, intent);
        }
        this.ifE = null;
    }

    public final void dyf() {
        C5536q c5536q = this.mController;
        c5536q.ylS.setVisibility(8);
        c5536q.ylR.setVisibility(8);
    }

    /* renamed from: Ne */
    public final void mo17375Ne(int i) {
        if (this.ylo != null) {
            this.ylo.setVisibility(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                ylp = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable th) {
                ylp = null;
            }
        }
    }

    public final String dyh() {
        String str = "";
        ComponentName callingActivity = getCallingActivity();
        if (callingActivity != null) {
            str = callingActivity.getPackageName();
            C4990ab.m7417i("MicroMsg.MMActivity", "get calling activity, %s", str);
        }
        String str2 = str;
        if (C5046bo.isNullOrNil(str2) && VERSION.SDK_INT >= 22) {
            try {
                Object obj = new C1438c(this, "mReferrer", null).get();
                if (obj != null) {
                    str2 = (String) obj;
                }
                C4990ab.m7417i("MicroMsg.MMActivity", "get referrer, %s", str2);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMActivity", e, "get mReferrer error", new Object[0]);
            }
        }
        if (!C5046bo.isNullOrNil(str2) || VERSION.SDK_INT < 22) {
            return str2;
        }
        Uri referrer = getReferrer();
        if (referrer == null) {
            return str2;
        }
        C4990ab.m7417i("MicroMsg.MMActivity", "get referrer, %s", referrer.getAuthority());
        return referrer.getAuthority();
    }

    public final long dyi() {
        long j;
        if (this.ylr != 0) {
            j = (this.ylr - this.ylq) + this.yls;
        } else {
            j = (C5046bo.m7588yz() - this.ylq) + this.yls;
        }
        if (j < 0) {
            C4990ab.m7421w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(this.ylq), Long.valueOf(this.ylr), Long.valueOf(this.yls));
        }
        C4990ab.m7419v("MicroMsg.MMActivity", "%d get activity browse time [%d]", Integer.valueOf(hashCode()), Long.valueOf(j));
        return j;
    }

    /* renamed from: AM */
    public void mo9439AM(int i) {
        this.mController.contentView.setVisibility(i);
        if (i == 0) {
            this.mController.showTitleView();
        } else {
            this.mController.hideTitleView();
        }
    }

    public final void dyg() {
        if (C5230ak.m7991hw(this.mController.ylL)) {
            if (this.ylo == null) {
                this.ylo = new View(this.mController.ylL);
                ((ViewGroup) getWindow().getDecorView()).addView(this.ylo);
            }
            LayoutParams layoutParams = new LayoutParams(-1, C5230ak.m7988fr(this.mController.ylL));
            layoutParams.gravity = 80;
            this.ylo.setLayoutParams(layoutParams);
            this.ylo.setBackgroundColor(-637534208);
            this.ylo.setVisibility(8);
            return;
        }
        C4990ab.m7420w("MicroMsg.MMActivity", "has not NavigationBar!");
    }
}
