package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ui.collection.e;
import com.tencent.mm.plugin.appbrand.ui.recents.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/IFolderActivityContext;", "()V", "mFolderContextImpl", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showListPage", "showList", "Companion", "plugin-appbrand-integration_release"})
@i
public final class AppBrandLauncherFolderUI extends MMActivity implements com.tencent.mm.plugin.appbrand.ui.a.b {
    public static final a iGG = new a();
    private com.tencent.mm.plugin.appbrand.ui.a.a iGF;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001c\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion;", "", "()V", "KEY_MODE_INT", "", "MODE_COLLECTION", "", "MODE_RECENTS", "startCollectionList", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startRecentsList", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX WARNING: Missing block: B:5:0x0022, code skipped:
            if (r0 == null) goto L_0x0024;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void o(Context context, Intent intent) {
            Bundle extras;
            AppMethodBeat.i(134987);
            j.p(context, "context");
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
            AppMethodBeat.o(134987);
        }

        /* JADX WARNING: Missing block: B:5:0x0022, code skipped:
            if (r0 == null) goto L_0x0024;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void p(Context context, Intent intent) {
            Bundle extras;
            AppMethodBeat.i(134988);
            j.p(context, "context");
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
            AppMethodBeat.o(134988);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandLauncherFolderUI iGH;

        b(AppBrandLauncherFolderUI appBrandLauncherFolderUI) {
            this.iGH = appBrandLauncherFolderUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(134989);
            this.iGH.finish();
            AppMethodBeat.o(134989);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ AppBrandLauncherFolderUI iGH;

        c(AppBrandLauncherFolderUI appBrandLauncherFolderUI) {
            this.iGH = appBrandLauncherFolderUI;
        }

        public final void run() {
            AppMethodBeat.i(134990);
            Fragment findFragmentById = this.iGH.getSupportFragmentManager().findFragmentById(16908290);
            if (!(findFragmentById instanceof AppBrandLauncherUI.Fragment)) {
                findFragmentById = null;
            }
            AppBrandLauncherUI.Fragment fragment = (AppBrandLauncherUI.Fragment) findFragmentById;
            if (fragment != null) {
                fragment.aMf();
                AppMethodBeat.o(134990);
                return;
            }
            AppMethodBeat.o(134990);
        }
    }

    static {
        AppMethodBeat.i(134994);
        AppMethodBeat.o(134994);
    }

    public static final void o(Context context, Intent intent) {
        AppMethodBeat.i(134995);
        a.o(context, intent);
        AppMethodBeat.o(134995);
    }

    public static final void p(Context context, Intent intent) {
        AppMethodBeat.i(134996);
        a.p(context, intent);
        AppMethodBeat.o(134996);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(134991);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(134991);
            return;
        }
        com.tencent.mm.plugin.appbrand.ui.a.a oVar;
        if (com.tencent.mm.ui.base.b.aE(getClass())) {
            super.overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.ync, com.tencent.mm.ui.MMFragmentActivity.a.ynd);
        }
        int intExtra = getIntent().getIntExtra("KEY_MODE", 0);
        switch (intExtra) {
            case 1:
                oVar = new o(this);
                break;
            case 2:
                oVar = new e(this);
                break;
            default:
                ab.e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + intExtra + ')');
                finish();
                break;
        }
        this.iGF = oVar;
        xE(-855310);
        getContentView().setBackgroundColor(dyd());
        setBackBtn(new b(this));
        setTitleBarDoubleClickListener(new c(this));
        Lifecycle lifecycle = getLifecycle();
        oVar = this.iGF;
        if (oVar == null) {
            j.dWJ();
        }
        lifecycle.addObserver(oVar);
        AppMethodBeat.o(134991);
    }

    public final void eE(boolean z) {
        AppMethodBeat.i(134992);
        com.tencent.mm.plugin.appbrand.ui.a.a aVar = this.iGF;
        if (aVar != null) {
            aVar.eE(z);
            AppMethodBeat.o(134992);
            return;
        }
        AppMethodBeat.o(134992);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(134993);
        if (isFinishing()) {
            AppMethodBeat.o(134993);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(134993);
        return dispatchTouchEvent;
    }
}
