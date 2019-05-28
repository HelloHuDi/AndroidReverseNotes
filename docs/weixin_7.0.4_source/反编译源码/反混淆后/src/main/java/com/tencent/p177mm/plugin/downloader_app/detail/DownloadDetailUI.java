package com.tencent.p177mm.plugin.downloader_app.detail;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p146d.C37398j;
import com.tencent.luggage.p146d.C8860e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C46417a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI */
public class DownloadDetailUI extends MMActivity {
    private C33939a kOf;

    /* renamed from: com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI$2 */
    class C412642 implements C37398j {
        C412642() {
        }

        /* renamed from: j */
        public final C8860e mo23952j(String str, Bundle bundle) {
            boolean z = true;
            AppMethodBeat.m2504i(136032);
            C32186k dC = C2906d.m5185dC(DownloadDetailUI.this);
            String str2 = "MicroMsg.DownloadDetailUI";
            String str3 = "preloadDetail is null ? %b";
            Object[] objArr = new Object[1];
            if (dC != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str2, str3, objArr);
            if (dC == null) {
                C2906d.m5183IC(str);
            }
            C24746c c24746c = new C24746c(DownloadDetailUI.this.kOf.bPq, dC, bundle);
            AppMethodBeat.m2505o(136032);
            return c24746c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI$1 */
    class C429231 implements OnMenuItemClickListener {
        C429231() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(136031);
            DownloadDetailUI.this.finish();
            AppMethodBeat.m2505o(136031);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(136033);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.DownloadDetailUI", "onCreate");
        String stringExtra = getIntent().getStringExtra("rawUrl");
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7412e("MicroMsg.DownloadDetailUI", "url is null");
            AppMethodBeat.m2505o(136033);
            return;
        }
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        setMMTitle(getResources().getString(C25738R.string.dcp));
        mo17446xE(getResources().getColor(C25738R.color.f11947ms));
        setBackBtn(new C429231());
        int color = getResources().getColor(C25738R.color.f11947ms);
        if (VERSION.SDK_INT >= 21 && getSwipeBackLayout() == null) {
            C46417a.m87416c(this, color, true);
        }
        this.kOf = new C33939a(this);
        setContentView((View) this.kOf.bPj);
        this.kOf.mo67377a((C37398j) new C412642());
        this.kOf.mo60236h(stringExtra, getIntent().getExtras());
        AppMethodBeat.m2505o(136033);
    }

    public void onResume() {
        AppMethodBeat.m2504i(136034);
        super.onResume();
        C4990ab.m7416i("MicroMsg.DownloadDetailUI", "onResume");
        this.kOf.onResume();
        AppMethodBeat.m2505o(136034);
    }

    public void onPause() {
        AppMethodBeat.m2504i(136035);
        super.onPause();
        C4990ab.m7416i("MicroMsg.DownloadDetailUI", "onPause");
        this.kOf.onPause();
        AppMethodBeat.m2505o(136035);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(136036);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.DownloadDetailUI", "onDestroy");
        this.kOf.destroy();
        C4990ab.m7416i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            C4990ab.m7416i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak, imm");
            String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 3; i++) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj != null && (obj instanceof View)) {
                        View view = (View) obj;
                        if (!(view.getContext() instanceof ContextWrapper)) {
                            if (view.getContext() != this) {
                                break;
                            }
                            declaredField.set(inputMethodManager, null);
                        } else if (((ContextWrapper) view.getContext()).getBaseContext() == this) {
                            declaredField.set(inputMethodManager, null);
                        }
                    }
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.DownloadDetailUI", th, "", new Object[0]);
                }
            }
        }
        System.gc();
        AppMethodBeat.m2505o(136036);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(136037);
        if (!this.kOf.mo67382wY()) {
            finish();
        }
        AppMethodBeat.m2505o(136037);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void initSwipeBack() {
        AppMethodBeat.m2504i(136038);
        super.initSwipeBack();
        if (getSwipeBackLayout() == null) {
            AppMethodBeat.m2505o(136038);
            return;
        }
        View childAt = getSwipeBackLayout().getChildAt(0);
        getSwipeBackLayout().removeView(childAt);
        C7355b c7355b = new C7355b(this);
        if (childAt instanceof FrameLayout) {
            View childAt2 = ((FrameLayout) childAt).getChildAt(0);
            LayoutParams layoutParams = childAt2.getLayoutParams();
            ((FrameLayout) childAt).removeView(childAt2);
            c7355b.addView(childAt2, layoutParams);
        } else {
            c7355b.addView(childAt);
        }
        getSwipeBackLayout().addView(c7355b);
        getSwipeBackLayout().setContentView(c7355b);
        AppMethodBeat.m2505o(136038);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(136039);
        super.onCreateBeforeSetContentView();
        AppMethodBeat.m2505o(136039);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(136040);
        super.onActivityResult(i, i2, intent);
        this.kOf.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(136040);
    }
}
