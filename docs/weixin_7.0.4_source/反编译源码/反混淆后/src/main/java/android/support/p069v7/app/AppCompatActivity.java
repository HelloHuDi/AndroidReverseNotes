package android.support.p069v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.app.C0328ae;
import android.support.p057v4.app.C0328ae.C0326a;
import android.support.p057v4.app.C0355t;
import android.support.p057v4.app.C6184a;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.content.C0380b;
import android.support.p069v7.app.C6214a.C0573a;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.widget.C0706bh;
import android.support.p069v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* renamed from: android.support.v7.app.AppCompatActivity */
public class AppCompatActivity extends FragmentActivity implements C0326a, C0575c {
    private C0576d mDelegate;
    private Resources mResources;
    private int mThemeId = 0;

    public void onCreate(Bundle bundle) {
        C0576d delegate = getDelegate();
        delegate.mo1400fk();
        delegate.onCreate(bundle);
        if (delegate.mo1401fl() && this.mThemeId != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.mThemeId, false);
            } else {
                setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    /* Access modifiers changed, original: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().mo1399fj();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    public void setContentView(int i) {
        getDelegate().setContentView(i);
    }

    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().findViewById(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    /* Access modifiers changed, original: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void onSupportActionModeStarted(C0604b c0604b) {
    }

    public void onSupportActionModeFinished(C0604b c0604b) {
    }

    public C0604b onWindowStartingSupportActionMode(C0603a c0603a) {
        return null;
    }

    public C0604b startSupportActionMode(C0603a c0603a) {
        return getDelegate().startSupportActionMode(c0603a);
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    public void onCreateSupportNavigateUpTaskStack(C0328ae c0328ae) {
        Intent f;
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            f = C0355t.m584f(this);
        } else {
            f = supportParentActivityIntent;
        }
        if (f != null) {
            ComponentName component = f.getComponent();
            if (component == null) {
                component = f.resolveActivity(c0328ae.f284Gg.getPackageManager());
            }
            c0328ae.mo519a(component);
            c0328ae.f283Gf.add(f);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(C0328ae c0328ae) {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            C0328ae N = C0328ae.m518N(this);
            onCreateSupportNavigateUpTaskStack(N);
            onPrepareSupportNavigateUpTaskStack(N);
            if (N.f283Gf.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) N.f283Gf.toArray(new Intent[N.f283Gf.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            C0380b.m648a(N.f284Gg, intentArr);
            try {
                C6184a.m9882b(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    public Intent getSupportParentActivityIntent() {
        return C0355t.m584f(this);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public C0573a getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().onSaveInstanceState(bundle);
    }

    public C0576d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0576d.m1253a((Activity) this, (C0575c) this);
        }
        return this.mDelegate;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.mo1335b(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.mResources == null && C0706bh.m1569lw()) {
            this.mResources = new C0706bh(this, super.getResources());
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }

    private boolean performMenuItemShortcut(int i, KeyEvent keyEvent) {
        if (!(VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()))) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.mo1342ff()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.mo1343fg()) {
            super.closeOptionsMenu();
        }
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        if (VERSION.SDK_INT >= 16) {
            return shouldUpRecreateTask(intent);
        }
        String action = getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    public void supportNavigateUpTo(Intent intent) {
        if (VERSION.SDK_INT >= 16) {
            navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }
}
