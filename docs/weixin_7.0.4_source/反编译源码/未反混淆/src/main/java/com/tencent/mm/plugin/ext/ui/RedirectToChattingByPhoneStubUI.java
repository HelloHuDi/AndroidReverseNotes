package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class RedirectToChattingByPhoneStubUI extends Activity implements f {
    private p lRg = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20435);
        super.onCreate(bundle);
        getString(R.string.un);
        this.lRg = h.b((Context) this, "", false, null);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20434);
                RedirectToChattingByPhoneStubUI.this.hideVKB();
                AppMethodBeat.o(20434);
            }
        }, 500);
        aw.Rg().a(106, (f) this);
        AppMethodBeat.o(20435);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(20436);
        super.onDestroy();
        aw.Rg().b(106, (f) this);
        if (this.lRg != null) {
            this.lRg.dismiss();
            this.lRg = null;
        }
        AppMethodBeat.o(20436);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(20437);
        finish();
        AppMethodBeat.o(20437);
    }

    public final boolean hideVKB() {
        AppMethodBeat.i(20438);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(20438);
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(20438);
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(20438);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            ab.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        ab.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        AppMethodBeat.o(20438);
        return hideSoftInputFromWindow;
    }
}
