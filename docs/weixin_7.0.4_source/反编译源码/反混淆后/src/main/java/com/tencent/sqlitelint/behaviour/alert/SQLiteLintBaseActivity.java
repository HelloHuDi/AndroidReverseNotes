package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p069v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class SQLiteLintBaseActivity extends Activity {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLintBaseActivity.class.desiredAssertionStatus());
    private Toolbar mToolBar;

    /* renamed from: com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity$1 */
    class C58341 implements OnClickListener {
        C58341() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(94066);
            SQLiteLintBaseActivity.this.onBackBtnClick();
            AppMethodBeat.m2505o(94066);
        }
    }

    public abstract int getLayoutId();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        onCreateView();
    }

    /* Access modifiers changed, original: protected */
    public void onCreateView() {
        setContentView(2130968628);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131821019);
        LayoutInflater from = LayoutInflater.from(this);
        int layoutId = getLayoutId();
        if ($assertionsDisabled || layoutId != 0) {
            from.inflate(layoutId, frameLayout);
            this.mToolBar = (Toolbar) findViewById(2131821018);
            this.mToolBar.setNavigationOnClickListener(new C58341());
            Drawable logo = this.mToolBar.getLogo();
            if (logo != null) {
                logo.setVisible(false, true);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* Access modifiers changed, original: protected */
    public void setTitle(String str) {
        this.mToolBar.setTitle((CharSequence) str);
    }

    /* Access modifiers changed, original: protected */
    public void onBackBtnClick() {
        finish();
    }
}
