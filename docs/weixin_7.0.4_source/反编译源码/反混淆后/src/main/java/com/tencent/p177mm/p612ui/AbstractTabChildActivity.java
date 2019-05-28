package com.tencent.p177mm.p612ui;

import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.AbstractTabChildActivity */
public abstract class AbstractTabChildActivity extends AppCompatActivity {

    /* renamed from: com.tencent.mm.ui.AbstractTabChildActivity$AbStractTabFragment */
    public static abstract class AbStractTabFragment extends MMFragment implements C15912m {
        private Bundle rnR;
        private boolean ydY;
        private boolean ydZ;
        private boolean yea;
        protected boolean yeb;
        protected boolean yec = false;
        protected boolean yed = false;
        protected boolean yee;
        protected boolean yef = false;

        public abstract void dvY();

        public abstract void dvZ();

        public abstract void dwa();

        public abstract void dwb();

        public abstract void dwc();

        public abstract void dwd();

        public abstract void dwe();

        public abstract void dwf();

        public abstract void dwg();

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.ydZ = true;
            this.rnR = bundle;
        }

        /* Access modifiers changed, original: protected */
        public int getLayoutId() {
            return 0;
        }

        public final void dwh() {
            dwf();
            this.yea = true;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0) {
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }

        public void onResume() {
            super.onResume();
            LauncherUI instance = LauncherUI.getInstance();
            if (instance != null && instance.yjM) {
                this.yec = true;
                if (this.yed) {
                    dwl();
                    this.yed = false;
                }
            }
        }

        public final void dwi() {
        }

        public final void dwj() {
            this.yed = true;
        }

        private void dwk() {
            if (this.ydZ) {
                dvY();
                this.ydZ = false;
            } else if (this.ydY) {
                if (this.yef) {
                    dwd();
                }
                dvY();
                C4990ab.m7418v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
                this.ydY = false;
            }
            this.yef = true;
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
                C4990ab.m7410d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
                this.yeb = false;
                this.yee = false;
                return;
            }
            this.yee = false;
        }

        public final void dwl() {
            if (this.yec) {
                dwk();
                long currentTimeMillis = System.currentTimeMillis();
                if (this.yea) {
                    this.yea = false;
                    dwg();
                }
                dvZ();
                C4990ab.m7410d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
                this.yeb = true;
                this.yec = false;
            }
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
            if (this.yef) {
                dwd();
            }
            super.onDestroy();
        }

        public boolean supportNavigationSwipeBack() {
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
