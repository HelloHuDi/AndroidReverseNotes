package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public abstract class SQLiteLintBaseActivity extends Activity {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLintBaseActivity.class.desiredAssertionStatus());
    private Toolbar mToolBar;

    public abstract int getLayoutId();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        onCreateView();
    }

    /* Access modifiers changed, original: protected */
    public void onCreateView() {
        setContentView(R.layout.ap);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.m5);
        LayoutInflater from = LayoutInflater.from(this);
        int layoutId = getLayoutId();
        if ($assertionsDisabled || layoutId != 0) {
            from.inflate(layoutId, frameLayout);
            this.mToolBar = (Toolbar) findViewById(R.id.m4);
            this.mToolBar.setNavigationOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.i(94066);
                    SQLiteLintBaseActivity.this.onBackBtnClick();
                    AppMethodBeat.o(94066);
                }
            });
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
