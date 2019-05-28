package com.tencent.p177mm.p612ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.BaseActivity.C23528c;
import com.tencent.p177mm.p612ui.BaseActivity.C30321b;
import com.tencent.p177mm.p612ui.BaseActivity.C51716;
import com.tencent.p177mm.p612ui.C15482ab.C15484a;

/* renamed from: com.tencent.mm.ui.SearchBarUI */
public abstract class SearchBarUI extends BaseActivity implements C15484a {
    C15482ab ypT;

    /* renamed from: com.tencent.mm.ui.SearchBarUI$1 */
    class C154781 implements OnMenuItemClickListener {
        C154781() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112457);
            SearchBarUI searchBarUI = SearchBarUI.this;
            if (!searchBarUI.yfa.isEmpty()) {
                searchBarUI.yfa.clear();
                searchBarUI.supportInvalidateOptionsMenu();
            }
            searchBarUI.ypT = new C15482ab(searchBarUI);
            searchBarUI.ypT.setSearchViewListener(searchBarUI);
            searchBarUI.ypT.setHint(searchBarUI.getResources().getString(C25738R.string.ey4));
            searchBarUI.getSupportActionBar().setCustomView(searchBarUI.ypT);
            InputMethodManager inputMethodManager = (InputMethodManager) searchBarUI.getSystemService("input_method");
            if (inputMethodManager != null) {
                View currentFocus = searchBarUI.getCurrentFocus();
                if (!(currentFocus == null || currentFocus.getWindowToken() == null)) {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
            }
            AppMethodBeat.m2505o(112457);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.SearchBarUI$2 */
    class C303512 implements OnMenuItemClickListener {
        C303512() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112458);
            SearchBarUI.this.finish();
            AppMethodBeat.m2505o(112458);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C23528c c23528c = C23528c.SEARCH;
        C154781 c154781 = new C154781();
        String str = "";
        C30321b c30321b = new C30321b();
        c30321b.yfi = 0;
        c30321b.yfj = 0;
        c30321b.text = str;
        c30321b.gzB = c154781;
        c30321b.mlV = null;
        c30321b.yfn = c23528c;
        if (c30321b.yfj == C25738R.drawable.aut && str.length() <= 0) {
            c30321b.text = getString(C25738R.string.f8694c_);
        }
        int i = c30321b.yfi;
        for (int i2 = 0; i2 < this.yfa.size(); i2++) {
            if (((C30321b) this.yfa.get(i2)).yfi == i) {
                C5227ai.m7971d("BaseActivity", "match menu, id ：" + i + ", remove it", new Object[0]);
                this.yfa.remove(i2);
                break;
            }
        }
        this.yfa.add(c30321b);
        new Handler().postDelayed(new C51716(), 200);
        setBackBtn(new C303512());
    }

    public void onClickBackBtn(View view) {
        finish();
    }
}
