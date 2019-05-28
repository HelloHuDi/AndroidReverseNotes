package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference extends MMPreferenceFragment implements m {
    private Bundle rnR;
    private boolean ydY;
    private boolean ydZ;
    private boolean yea;
    private boolean yeb;
    protected boolean yec = false;
    protected boolean yed = false;
    protected boolean yee;

    public abstract void dvY();

    public abstract void dvZ();

    public abstract void dwa();

    public abstract void dwb();

    public abstract void dwc();

    public abstract void dwd();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.rnR = bundle;
        this.ydZ = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onResume() {
        super.onResume();
        dwi();
        LauncherUI instance = LauncherUI.getInstance();
        if (instance != null && instance.yjM) {
            this.yec = true;
            if (this.yed) {
                dwl();
                this.yed = false;
            }
        }
    }

    public final void dwh() {
        dwf();
        this.yea = true;
    }

    public final void dwl() {
        if (this.yec) {
            dwk();
            long currentTimeMillis = System.currentTimeMillis();
            if (this.yea) {
                dwg();
                this.yea = false;
            }
            dAE();
            dvZ();
            ab.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.yeb = true;
            this.yec = false;
        }
    }

    public final void dwj() {
        this.yed = true;
    }

    private void dwk() {
        if (this.ydZ) {
            dvY();
            this.ydZ = false;
        } else if (this.ydY) {
            dwd();
            dvY();
            ab.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
            this.ydY = false;
        }
    }

    public void onPause() {
        super.onPause();
        this.yee = true;
        if (!this.yee) {
            return;
        }
        if (this.yeb) {
            long currentTimeMillis = System.currentTimeMillis();
            dwb();
            ab.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.yeb = false;
            this.yee = false;
            return;
        }
        this.yee = false;
    }

    public void onStop() {
        super.onStop();
        dwc();
    }

    public void onStart() {
        super.onStart();
        LauncherUI instance = LauncherUI.getInstance();
        if (instance != null && instance.yjM) {
            dwa();
        }
    }

    public void onDestroy() {
        dwd();
        super.onDestroy();
    }
}
