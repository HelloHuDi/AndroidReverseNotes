package com.tencent.mm.ui;

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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.q.AnonymousClass5;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.tools.o;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity extends MMFragmentActivity implements ad {
    private static String ylp;
    String className;
    public a ifE = null;
    public q mController = new q() {
        /* Access modifiers changed, original: protected|final */
        public final int getLayoutId() {
            AppMethodBeat.i(105985);
            int layoutId = MMActivity.this.getLayoutId();
            AppMethodBeat.o(105985);
            return layoutId;
        }

        /* Access modifiers changed, original: protected|final */
        public final void dealContentView(View view) {
            AppMethodBeat.i(105986);
            MMActivity.this.dealContentView(view);
            AppMethodBeat.o(105986);
        }

        /* Access modifiers changed, original: protected|final */
        public final String bJj() {
            AppMethodBeat.i(105987);
            String bJj = MMActivity.this.bJj();
            AppMethodBeat.o(105987);
            return bJj;
        }

        /* Access modifiers changed, original: protected|final */
        public final View getLayoutView() {
            return null;
        }

        public final void onKeyboardStateChanged() {
            AppMethodBeat.i(105988);
            MMActivity.this.onKeyboardStateChanged();
            AppMethodBeat.o(105988);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCreateBeforeSetContentView() {
            AppMethodBeat.i(105989);
            MMActivity.this.onCreateBeforeSetContentView();
            AppMethodBeat.o(105989);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getClassName() {
            AppMethodBeat.i(105990);
            String name = MMActivity.this.getClass().getName();
            AppMethodBeat.o(105990);
            return name;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dxT() {
            AppMethodBeat.i(105991);
            boolean dxT = MMActivity.this.dxT();
            AppMethodBeat.o(105991);
            return dxT;
        }

        public final boolean noActionBar() {
            AppMethodBeat.i(105992);
            boolean noActionBar = MMActivity.this.noActionBar();
            AppMethodBeat.o(105992);
            return noActionBar;
        }

        public final boolean needShowIdcError() {
            AppMethodBeat.i(105993);
            boolean needShowIdcError = MMActivity.this.needShowIdcError();
            AppMethodBeat.o(105993);
            return needShowIdcError;
        }
    };
    public boolean uiu = false;
    protected boolean ylk = false;
    protected boolean yll = false;
    protected boolean ylm = false;
    private ViewGroup yln = null;
    private View ylo;
    private long ylq = 0;
    private long ylr = 0;
    private long yls = 0;

    public interface a {
        void c(int i, int i2, Intent intent);
    }

    public abstract int getLayoutId();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public void initView() {
    }

    public final void setBackGroundColorResource(int i) {
        this.mController.setBackGroundColorResource(i);
    }

    public final q getController() {
        return this.mController;
    }

    public static Locale initLanguage(Context context) {
        return q.initLanguage(context);
    }

    public static Locale bM(Context context, String str) {
        return q.bM(context, str);
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
        this.mController.a(getApplicationContext(), (AppCompatActivity) this);
        initNavigationSwipeBack();
        xE(getResources().getColor(R.color.vy));
        bn(((float) com.tencent.mm.bz.a.am(this, R.dimen.dk)) * com.tencent.mm.bz.a.fY(this));
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
                this.yln = new b(this);
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
            this.ylk = getSharedPreferences(ah.doA(), 0).getBoolean("settings_landscape_mode", false);
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
            ab.printErrStackTrace("MicroMsg.MMActivity", e, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
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
        ac.bL(1, this.className);
        super.onResume();
        ab.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        ab.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
        if (this.ylr > this.ylq) {
            this.yls += this.ylr - this.ylq;
        }
        this.ylq = bo.yz();
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
        this.mController.hq(this);
        this.uiu = true;
    }

    public static void dxV() {
        q.dxV();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        ac.bL(2, this.className);
        super.onPause();
        this.mController.onPause();
        boolean isFinishing = isFinishing();
        ab.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing), Integer.valueOf(hashCode()));
        this.ylr = bo.yz();
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

    public void ta(int i) {
        q qVar = this.mController;
        if (qVar.mActionBar != null) {
            qVar.ylQ.setTextColor(i);
        }
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public void M(CharSequence charSequence) {
        this.mController.M(charSequence);
    }

    public final void setMMTitle(int i) {
        this.mController.setMMTitle(i);
    }

    public final void bn(float f) {
        this.mController.bn(f);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public final void setMMSubTitle(int i) {
        this.mController.setMMSubTitle(i);
    }

    public final void MY(int i) {
        this.mController.ylQ.setVisibility(i);
    }

    public final void dxW() {
        q qVar = this.mController;
        if (VERSION.SDK_INT >= 23) {
            View decorView = qVar.ylL.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }
    }

    public final void MZ(int i) {
        this.mController.setTitleLogo(0, i);
    }

    public final void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public final void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public final void enableOptionMenu(boolean z) {
        this.mController.d(true, -1, z);
    }

    public final void enableOptionMenu(int i, boolean z) {
        this.mController.d(false, i, z);
    }

    public void showOptionMenu(boolean z) {
        this.mController.e(true, -1, z);
    }

    public void showOptionMenu(int i, boolean z) {
        this.mController.e(false, i, z);
    }

    public final boolean dxX() {
        Iterator it = this.mController.yfa.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.q.a aVar = (com.tencent.mm.ui.q.a) it.next();
            if (aVar.yfi == 0) {
                return aVar.enable;
            }
        }
        return false;
    }

    public final boolean dxY() {
        Iterator it = this.mController.yfa.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.q.a aVar = (com.tencent.mm.ui.q.a) it.next();
            if (aVar.yfi == 0) {
                return aVar.aIB;
            }
        }
        return false;
    }

    public final void a(o oVar) {
        this.mController.addSearchMenu(true, oVar);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(String str, int i, OnMenuItemClickListener onMenuItemClickListener) {
        q qVar = this.mController;
        q.b bVar = q.b.NORMAL;
        com.tencent.mm.ui.q.a aVar = new com.tencent.mm.ui.q.a();
        aVar.yfi = 0;
        aVar.text = str;
        aVar.textColor = i;
        aVar.gzB = onMenuItemClickListener;
        aVar.mlV = null;
        aVar.ymr = bVar;
        qVar.Nf(aVar.yfi);
        qVar.yfa.add(aVar);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(106003);
                q.this.supportInvalidateOptionsMenu();
                AppMethodBeat.o(106003);
            }
        }, 200);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, q.b bVar) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener, null, bVar);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        q qVar = this.mController;
        q.b bVar = q.b.NORMAL;
        com.tencent.mm.ui.q.a aVar = new com.tencent.mm.ui.q.a();
        aVar.yfi = i;
        aVar.ymq = drawable;
        aVar.text = str;
        aVar.gzB = onMenuItemClickListener;
        aVar.mlV = null;
        aVar.ymr = bVar;
        qVar.Nf(aVar.yfi);
        qVar.yfa.add(aVar);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(106002);
                q.this.supportInvalidateOptionsMenu();
                AppMethodBeat.o(106002);
            }
        }, 200);
    }

    public final void b(String str, int i, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(0, str, i, onMenuItemClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener);
    }

    public final void a(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(0, i, onMenuItemClickListener, onLongClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener, onLongClickListener);
    }

    public final void Na(int i) {
        this.mController.updateOptionMenuIcon(0, i);
    }

    public final void updateOptionMenuText(int i, String str) {
        this.mController.updateOptionMenuText(i, str);
    }

    public final void a(int i, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.updateOptionMenuListener(i, onMenuItemClickListener, null);
    }

    public final void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    public final void b(Runnable runnable, Runnable runnable2) {
        q qVar = this.mController;
        if (qVar.mActionBar != null) {
            qVar.mActionBar.getCustomView().setOnClickListener(new AnonymousClass5(runnable, runnable2));
        }
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.mController.setBackBtn(onMenuItemClickListener, i);
    }

    public final void dxZ() {
        q qVar = this.mController;
        if (qVar.ylS != null) {
            qVar.ylS.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
    }

    public void xE(int i) {
        this.mController.xE(i);
    }

    public final void dya() {
        q qVar = this.mController;
        if (VERSION.SDK_INT >= 23) {
            View decorView = qVar.ylL.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -17);
        }
    }

    public final void Nb(int i) {
        this.mController.Nb(i);
    }

    public final void pO(boolean z) {
        q qVar = this.mController;
        qVar.qlP = z;
        qVar.dyo();
        qVar.dyn();
    }

    public final void Nc(int i) {
        q qVar = this.mController;
        qVar.ylT = i;
        if (qVar.ylS != null) {
            qVar.ylS.setColorFilter(i, Mode.SRC_ATOP);
        }
        if (qVar.ylQ != null && qVar.ylQ.getVisibility() == 0) {
            qVar.ylQ.setTextColor(i);
        }
        if (qVar.jcI != null && qVar.jcI.getVisibility() == 0) {
            qVar.jcI.setTextColor(i);
        }
        if (qVar.yeP != null && qVar.yeP.getVisibility() == 0) {
            qVar.yeP.getDrawable().setColorFilter(i, Mode.SRC_ATOP);
        } else if (qVar.yeR != null && qVar.yeR.getVisibility() == 0) {
            qVar.yeR.setTextColor(i);
        }
    }

    public final void dyb() {
        q qVar = this.mController;
        if (VERSION.SDK_INT >= 21) {
            qVar.getSupportActionBar().setElevation(0.0f);
        }
    }

    public final void dyc() {
        q qVar = this.mController;
        if (VERSION.SDK_INT >= 21) {
            qVar.getSupportActionBar().setElevation(1.0f);
        }
    }

    public final void x(Drawable drawable) {
        q qVar = this.mController;
        if (qVar.mActionBar != null && qVar.ylS != null && drawable != null) {
            qVar.ylS.setImageDrawable(drawable);
            drawable.invalidateSelf();
        }
    }

    public final void pP(boolean z) {
        q qVar = this.mController;
        if (qVar.ylS == null) {
            return;
        }
        if (z) {
            qVar.ylS.setVisibility(0);
        } else {
            qVar.ylS.setVisibility(8);
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

    public final void Nd(int i) {
        q qVar = this.mController;
        qVar.ylJ = i == 0;
        qVar.dym();
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
        q.showVKB(this.mController.ylL);
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
        int a = w.a(getIntent(), MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        int a2 = w.a(getIntent(), MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        if (a != -1) {
            super.overridePendingTransition(a, a2);
        }
    }

    public final void aA(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void b(a aVar, Intent intent, int i) {
        this.ifE = aVar;
        startActivityForResult(intent, i);
    }

    public final void dye() {
        this.ifE = null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ifE != null) {
            this.ifE.c(i, i2, intent);
        }
        this.ifE = null;
    }

    public final void dyf() {
        q qVar = this.mController;
        qVar.ylS.setVisibility(8);
        qVar.ylR.setVisibility(8);
    }

    public final void Ne(int i) {
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
            ab.i("MicroMsg.MMActivity", "get calling activity, %s", str);
        }
        String str2 = str;
        if (bo.isNullOrNil(str2) && VERSION.SDK_INT >= 22) {
            try {
                Object obj = new c(this, "mReferrer", null).get();
                if (obj != null) {
                    str2 = (String) obj;
                }
                ab.i("MicroMsg.MMActivity", "get referrer, %s", str2);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMActivity", e, "get mReferrer error", new Object[0]);
            }
        }
        if (!bo.isNullOrNil(str2) || VERSION.SDK_INT < 22) {
            return str2;
        }
        Uri referrer = getReferrer();
        if (referrer == null) {
            return str2;
        }
        ab.i("MicroMsg.MMActivity", "get referrer, %s", referrer.getAuthority());
        return referrer.getAuthority();
    }

    public final long dyi() {
        long j;
        if (this.ylr != 0) {
            j = (this.ylr - this.ylq) + this.yls;
        } else {
            j = (bo.yz() - this.ylq) + this.yls;
        }
        if (j < 0) {
            ab.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(this.ylq), Long.valueOf(this.ylr), Long.valueOf(this.yls));
        }
        ab.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", Integer.valueOf(hashCode()), Long.valueOf(j));
        return j;
    }

    public void AM(int i) {
        this.mController.contentView.setVisibility(i);
        if (i == 0) {
            this.mController.showTitleView();
        } else {
            this.mController.hideTitleView();
        }
    }

    public final void dyg() {
        if (ak.hw(this.mController.ylL)) {
            if (this.ylo == null) {
                this.ylo = new View(this.mController.ylL);
                ((ViewGroup) getWindow().getDecorView()).addView(this.ylo);
            }
            LayoutParams layoutParams = new LayoutParams(-1, ak.fr(this.mController.ylL));
            layoutParams.gravity = 80;
            this.ylo.setLayoutParams(layoutParams);
            this.ylo.setBackgroundColor(-637534208);
            this.ylo.setVisibility(8);
            return;
        }
        ab.w("MicroMsg.MMActivity", "has not NavigationBar!");
    }
}
