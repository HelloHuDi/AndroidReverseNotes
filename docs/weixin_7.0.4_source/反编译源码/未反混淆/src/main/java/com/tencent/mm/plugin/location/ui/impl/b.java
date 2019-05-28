package com.tencent.mm.plugin.location.ui.impl;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b extends a {
    public Activity activity;
    protected d nMj;
    protected float neG = 0.0f;
    protected float neH = 0.0f;
    protected int type = 0;

    public abstract d bKo();

    public b(Activity activity) {
        this.activity = activity;
    }

    public void onCreate(Bundle bundle) {
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(R.layout.akj);
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        ab.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", Integer.valueOf(this.type));
        ((FrameLayout) findViewById(R.id.c_i)).addView(d.ep(this.activity));
        this.nMj = bKo();
        this.nMj.setMapViewOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(113593);
                int action = motionEvent.getAction();
                ab.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(action)));
                switch (action) {
                    case 0:
                        b.this.neG = motionEvent.getX();
                        b.this.neH = motionEvent.getY();
                        break;
                    case 1:
                        if (Math.abs(motionEvent.getX() - b.this.neG) > 10.0f || Math.abs(motionEvent.getY() - b.this.neH) > 10.0f) {
                            b.this.bKp();
                            break;
                        }
                }
                AppMethodBeat.o(113593);
                return false;
            }
        });
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
        ab.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
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
