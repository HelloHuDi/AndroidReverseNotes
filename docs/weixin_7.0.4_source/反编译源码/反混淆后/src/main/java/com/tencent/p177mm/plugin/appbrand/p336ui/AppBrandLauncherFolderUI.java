package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.appbrand.p336ui.collection.C45700e;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C19766b;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C24709a;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C45705o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/IFolderActivityContext;", "()V", "mFolderContextImpl", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showListPage", "showList", "Companion", "plugin-appbrand-integration_release"})
@C18524i
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI */
public final class AppBrandLauncherFolderUI extends MMActivity implements C19766b {
    public static final C2468a iGG = new C2468a();
    private C24709a iGF;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001c\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion;", "", "()V", "KEY_MODE_INT", "", "MODE_COLLECTION", "", "MODE_RECENTS", "startCollectionList", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startRecentsList", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI$a */
    public static final class C2468a {
        private C2468a() {
        }

        public /* synthetic */ C2468a(byte b) {
            this();
        }

        /* JADX WARNING: Missing block: B:5:0x0022, code skipped:
            if (r0 == null) goto L_0x0024;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: o */
        public static void m4706o(Context context, Intent intent) {
            Bundle extras;
            AppMethodBeat.m2504i(134987);
            C25052j.m39376p(context, "context");
            Intent intent2 = new Intent(context, AppBrandLauncherFolderUI.class);
            if (!(context instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (intent != null) {
                extras = intent.getExtras();
            }
            extras = Bundle.EMPTY;
            intent2.putExtras(extras);
            intent2.putExtra("KEY_MODE", 1);
            context.startActivity(intent2);
            AppMethodBeat.m2505o(134987);
        }

        /* JADX WARNING: Missing block: B:5:0x0022, code skipped:
            if (r0 == null) goto L_0x0024;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: p */
        public static void m4707p(Context context, Intent intent) {
            Bundle extras;
            AppMethodBeat.m2504i(134988);
            C25052j.m39376p(context, "context");
            Intent intent2 = new Intent(context, AppBrandLauncherFolderUI.class);
            if (!(context instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (intent != null) {
                extras = intent.getExtras();
            }
            extras = Bundle.EMPTY;
            intent2.putExtras(extras);
            intent2.putExtra("KEY_MODE", 2);
            context.startActivity(intent2);
            AppMethodBeat.m2505o(134988);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI$b */
    static final class C24707b implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandLauncherFolderUI iGH;

        C24707b(AppBrandLauncherFolderUI appBrandLauncherFolderUI) {
            this.iGH = appBrandLauncherFolderUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(134989);
            this.iGH.finish();
            AppMethodBeat.m2505o(134989);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI$c */
    static final class C24708c implements Runnable {
        final /* synthetic */ AppBrandLauncherFolderUI iGH;

        C24708c(AppBrandLauncherFolderUI appBrandLauncherFolderUI) {
            this.iGH = appBrandLauncherFolderUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(134990);
            Fragment findFragmentById = this.iGH.getSupportFragmentManager().findFragmentById(16908290);
            if (!(findFragmentById instanceof AppBrandLauncherUI.Fragment)) {
                findFragmentById = null;
            }
            AppBrandLauncherUI.Fragment fragment = (AppBrandLauncherUI.Fragment) findFragmentById;
            if (fragment != null) {
                fragment.aMf();
                AppMethodBeat.m2505o(134990);
                return;
            }
            AppMethodBeat.m2505o(134990);
        }
    }

    static {
        AppMethodBeat.m2504i(134994);
        AppMethodBeat.m2505o(134994);
    }

    /* renamed from: o */
    public static final void m38572o(Context context, Intent intent) {
        AppMethodBeat.m2504i(134995);
        C2468a.m4706o(context, intent);
        AppMethodBeat.m2505o(134995);
    }

    /* renamed from: p */
    public static final void m38573p(Context context, Intent intent) {
        AppMethodBeat.m2504i(134996);
        C2468a.m4707p(context, intent);
        AppMethodBeat.m2505o(134996);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(134991);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(134991);
            return;
        }
        C24709a c45705o;
        if (C5274b.m8049aE(getClass())) {
            super.overridePendingTransition(C5206a.ync, C5206a.ynd);
        }
        int intExtra = getIntent().getIntExtra("KEY_MODE", 0);
        switch (intExtra) {
            case 1:
                c45705o = new C45705o(this);
                break;
            case 2:
                c45705o = new C45700e(this);
                break;
            default:
                C4990ab.m7412e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + intExtra + ')');
                finish();
                break;
        }
        this.iGF = c45705o;
        mo17446xE(-855310);
        getContentView().setBackgroundColor(dyd());
        setBackBtn(new C24707b(this));
        setTitleBarDoubleClickListener(new C24708c(this));
        Lifecycle lifecycle = getLifecycle();
        c45705o = this.iGF;
        if (c45705o == null) {
            C25052j.dWJ();
        }
        lifecycle.addObserver(c45705o);
        AppMethodBeat.m2505o(134991);
    }

    /* renamed from: eE */
    public final void mo17538eE(boolean z) {
        AppMethodBeat.m2504i(134992);
        C24709a c24709a = this.iGF;
        if (c24709a != null) {
            c24709a.mo17538eE(z);
            AppMethodBeat.m2505o(134992);
            return;
        }
        AppMethodBeat.m2505o(134992);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(134993);
        if (isFinishing()) {
            AppMethodBeat.m2505o(134993);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(134993);
        return dispatchTouchEvent;
    }
}
