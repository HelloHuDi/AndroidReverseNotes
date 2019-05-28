package com.tencent.mm.plugin.downloader_app.detail;

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
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.luggage.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import java.lang.reflect.Field;

public class DownloadDetailUI extends MMActivity {
    private a kOf;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(136033);
        super.onCreate(bundle);
        ab.i("MicroMsg.DownloadDetailUI", "onCreate");
        String stringExtra = getIntent().getStringExtra("rawUrl");
        if (bo.isNullOrNil(stringExtra)) {
            ab.e("MicroMsg.DownloadDetailUI", "url is null");
            AppMethodBeat.o(136033);
            return;
        }
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        setMMTitle(getResources().getString(R.string.dcp));
        xE(getResources().getColor(R.color.ms));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(136031);
                DownloadDetailUI.this.finish();
                AppMethodBeat.o(136031);
                return false;
            }
        });
        int color = getResources().getColor(R.color.ms);
        if (VERSION.SDK_INT >= 21 && getSwipeBackLayout() == null) {
            a.c(this, color, true);
        }
        this.kOf = new a(this);
        setContentView((View) this.kOf.bPj);
        this.kOf.a((j) new j() {
            public final e j(String str, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.i(136032);
                k dC = d.dC(DownloadDetailUI.this);
                String str2 = "MicroMsg.DownloadDetailUI";
                String str3 = "preloadDetail is null ? %b";
                Object[] objArr = new Object[1];
                if (dC != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                ab.i(str2, str3, objArr);
                if (dC == null) {
                    d.IC(str);
                }
                c cVar = new c(DownloadDetailUI.this.kOf.bPq, dC, bundle);
                AppMethodBeat.o(136032);
                return cVar;
            }
        });
        this.kOf.h(stringExtra, getIntent().getExtras());
        AppMethodBeat.o(136033);
    }

    public void onResume() {
        AppMethodBeat.i(136034);
        super.onResume();
        ab.i("MicroMsg.DownloadDetailUI", "onResume");
        this.kOf.onResume();
        AppMethodBeat.o(136034);
    }

    public void onPause() {
        AppMethodBeat.i(136035);
        super.onPause();
        ab.i("MicroMsg.DownloadDetailUI", "onPause");
        this.kOf.onPause();
        AppMethodBeat.o(136035);
    }

    public void onDestroy() {
        AppMethodBeat.i(136036);
        super.onDestroy();
        ab.i("MicroMsg.DownloadDetailUI", "onDestroy");
        this.kOf.destroy();
        ab.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            ab.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak, imm");
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
                    ab.printErrStackTrace("MicroMsg.DownloadDetailUI", th, "", new Object[0]);
                }
            }
        }
        System.gc();
        AppMethodBeat.o(136036);
    }

    public void onBackPressed() {
        AppMethodBeat.i(136037);
        if (!this.kOf.wY()) {
            finish();
        }
        AppMethodBeat.o(136037);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void initSwipeBack() {
        AppMethodBeat.i(136038);
        super.initSwipeBack();
        if (getSwipeBackLayout() == null) {
            AppMethodBeat.o(136038);
            return;
        }
        View childAt = getSwipeBackLayout().getChildAt(0);
        getSwipeBackLayout().removeView(childAt);
        b bVar = new b(this);
        if (childAt instanceof FrameLayout) {
            View childAt2 = ((FrameLayout) childAt).getChildAt(0);
            LayoutParams layoutParams = childAt2.getLayoutParams();
            ((FrameLayout) childAt).removeView(childAt2);
            bVar.addView(childAt2, layoutParams);
        } else {
            bVar.addView(childAt);
        }
        getSwipeBackLayout().addView(bVar);
        getSwipeBackLayout().setContentView(bVar);
        AppMethodBeat.o(136038);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(136039);
        super.onCreateBeforeSetContentView();
        AppMethodBeat.o(136039);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(136040);
        super.onActivityResult(i, i2, intent);
        this.kOf.onActivityResult(i, i2, intent);
        AppMethodBeat.o(136040);
    }
}
