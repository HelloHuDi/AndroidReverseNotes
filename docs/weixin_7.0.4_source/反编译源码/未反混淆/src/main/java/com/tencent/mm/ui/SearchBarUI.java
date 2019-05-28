package com.tencent.mm.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.BaseActivity.b;
import com.tencent.mm.ui.BaseActivity.c;
import com.tencent.mm.ui.ab.a;

public abstract class SearchBarUI extends BaseActivity implements a {
    ab ypT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c cVar = c.SEARCH;
        AnonymousClass1 anonymousClass1 = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112457);
                SearchBarUI searchBarUI = SearchBarUI.this;
                if (!searchBarUI.yfa.isEmpty()) {
                    searchBarUI.yfa.clear();
                    searchBarUI.supportInvalidateOptionsMenu();
                }
                searchBarUI.ypT = new ab(searchBarUI);
                searchBarUI.ypT.setSearchViewListener(searchBarUI);
                searchBarUI.ypT.setHint(searchBarUI.getResources().getString(R.string.ey4));
                searchBarUI.getSupportActionBar().setCustomView(searchBarUI.ypT);
                InputMethodManager inputMethodManager = (InputMethodManager) searchBarUI.getSystemService("input_method");
                if (inputMethodManager != null) {
                    View currentFocus = searchBarUI.getCurrentFocus();
                    if (!(currentFocus == null || currentFocus.getWindowToken() == null)) {
                        inputMethodManager.toggleSoftInput(0, 2);
                    }
                }
                AppMethodBeat.o(112457);
                return false;
            }
        };
        String str = "";
        b bVar = new b();
        bVar.yfi = 0;
        bVar.yfj = 0;
        bVar.text = str;
        bVar.gzB = anonymousClass1;
        bVar.mlV = null;
        bVar.yfn = cVar;
        if (bVar.yfj == R.drawable.aut && str.length() <= 0) {
            bVar.text = getString(R.string.c_);
        }
        int i = bVar.yfi;
        for (int i2 = 0; i2 < this.yfa.size(); i2++) {
            if (((b) this.yfa.get(i2)).yfi == i) {
                ai.d("BaseActivity", "match menu, id ：" + i + ", remove it", new Object[0]);
                this.yfa.remove(i2);
                break;
            }
        }
        this.yfa.add(bVar);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(112450);
                BaseActivity.this.supportInvalidateOptionsMenu();
                AppMethodBeat.o(112450);
            }
        }, 200);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112458);
                SearchBarUI.this.finish();
                AppMethodBeat.o(112458);
                return true;
            }
        });
    }

    public void onClickBackBtn(View view) {
        finish();
    }
}
