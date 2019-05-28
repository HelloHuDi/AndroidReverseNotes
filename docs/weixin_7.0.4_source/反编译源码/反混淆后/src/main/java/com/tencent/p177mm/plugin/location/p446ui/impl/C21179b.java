package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.plugin.p443k.C39279a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.b */
public abstract class C21179b extends C39279a {
    public Activity activity;
    protected C28354d nMj;
    protected float neG = 0.0f;
    protected float neH = 0.0f;
    protected int type = 0;

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.b$1 */
    class C33481 implements OnTouchListener {
        C33481() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(113593);
            int action = motionEvent.getAction();
            C4990ab.m7416i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(action)));
            switch (action) {
                case 0:
                    C21179b.this.neG = motionEvent.getX();
                    C21179b.this.neH = motionEvent.getY();
                    break;
                case 1:
                    if (Math.abs(motionEvent.getX() - C21179b.this.neG) > 10.0f || Math.abs(motionEvent.getY() - C21179b.this.neH) > 10.0f) {
                        C21179b.this.bKp();
                        break;
                    }
            }
            AppMethodBeat.m2505o(113593);
            return false;
        }
    }

    public abstract C28354d bKo();

    public C21179b(Activity activity) {
        this.activity = activity;
    }

    public void onCreate(Bundle bundle) {
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(2130970366);
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        C4990ab.m7417i("MicroMsg.MMBaseMapUI", "init oncreate type %d", Integer.valueOf(this.type));
        ((FrameLayout) findViewById(2131824670)).addView(C39293d.m66973ep(this.activity));
        this.nMj = bKo();
        this.nMj.setMapViewOnTouchListener(new C33481());
        this.nMj.setMapAnchor(0.5f, 0.5f);
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    public final void onBackPressed() {
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void bKp() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        C4990ab.m7410d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
        this.activity.finish();
        return true;
    }

    public final boolean bKn() {
        return false;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        this.nMj.destroy();
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqX() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public final void showVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
