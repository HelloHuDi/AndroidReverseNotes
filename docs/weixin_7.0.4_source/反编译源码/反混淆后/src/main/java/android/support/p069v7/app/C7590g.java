package android.support.p069v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.C6217e.C6216b;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0607f.C0608a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;

/* renamed from: android.support.v7.app.g */
class C7590g extends AppCompatDelegateImplV9 {
    /* renamed from: UT */
    private int f2124UT = -100;
    /* renamed from: UU */
    private boolean f2125UU;
    /* renamed from: UV */
    boolean f2126UV = true;
    /* renamed from: UW */
    private C0579b f2127UW;

    /* renamed from: android.support.v7.app.g$b */
    final class C0579b {
        /* renamed from: UY */
        C0586n f870UY;
        /* renamed from: UZ */
        boolean f871UZ;
        /* renamed from: Va */
        BroadcastReceiver f872Va;
        /* renamed from: Vb */
        IntentFilter f873Vb;

        /* renamed from: android.support.v7.app.g$b$1 */
        class C05781 extends BroadcastReceiver {
            C05781() {
            }

            public final void onReceive(Context context, Intent intent) {
                C0579b c0579b = C0579b.this;
                boolean fC = c0579b.f870UY.mo1427fC();
                if (fC != c0579b.f871UZ) {
                    c0579b.f871UZ = fC;
                    C7590g.this.mo1401fl();
                }
            }
        }

        C0579b(C0586n c0586n) {
            this.f870UY = c0586n;
            this.f871UZ = c0586n.mo1427fC();
        }

        /* Access modifiers changed, original: final */
        public final void cleanup() {
            if (this.f872Va != null) {
                C7590g.this.mContext.unregisterReceiver(this.f872Va);
                this.f872Va = null;
            }
        }
    }

    /* renamed from: android.support.v7.app.g$a */
    class C7453a extends C6216b {
        C7453a(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (C7590g.this.f2126UV) {
                return mo16367a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final ActionMode mo16367a(ActionMode.Callback callback) {
            C0608a c0608a = new C0608a(C7590g.this.mContext, callback);
            C0604b startSupportActionMode = C7590g.this.startSupportActionMode(c0608a);
            if (startSupportActionMode != null) {
                return c0608a.mo1527b(startSupportActionMode);
            }
            return null;
        }
    }

    C7590g(Context context, Window window, C0575c c0575c) {
        super(context, window, c0575c);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.f2124UT == -100) {
            this.f2124UT = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final View mo16352a(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public Callback mo14031a(Callback callback) {
        return new C7453a(callback);
    }

    /* renamed from: fl */
    public final boolean mo1401fl() {
        int i;
        boolean z;
        if (this.f2124UT != -100) {
            i = this.f2124UT;
        } else {
            i = C0576d.f865UB;
        }
        int bg = mo16927bg(i);
        if (bg != -1) {
            Resources resources = this.mContext.getResources();
            Configuration configuration = resources.getConfiguration();
            int i2 = configuration.uiMode & 48;
            bg = bg == 2 ? 32 : 16;
            if (i2 != bg) {
                if (m13511fq()) {
                    ((Activity) this.mContext).recreate();
                } else {
                    Configuration configuration2 = new Configuration(configuration);
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    configuration2.uiMode = bg | (configuration2.uiMode & -49);
                    resources.updateConfiguration(configuration2, displayMetrics);
                    if (VERSION.SDK_INT < 26) {
                        if (VERSION.SDK_INT >= 24) {
                            C0582k.m1265c(resources);
                        } else if (VERSION.SDK_INT >= 23) {
                            C0582k.m1264b(resources);
                        } else if (VERSION.SDK_INT >= 21) {
                            C0582k.m1263a(resources);
                        }
                    }
                }
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (i == 0) {
            m13510fp();
            C0579b c0579b = this.f2127UW;
            c0579b.cleanup();
            if (c0579b.f872Va == null) {
                c0579b.f872Va = new C05781();
            }
            if (c0579b.f873Vb == null) {
                c0579b.f873Vb = new IntentFilter();
                c0579b.f873Vb.addAction("android.intent.action.TIME_SET");
                c0579b.f873Vb.addAction("android.intent.action.TIMEZONE_CHANGED");
                c0579b.f873Vb.addAction("android.intent.action.TIME_TICK");
            }
            C7590g.this.mContext.registerReceiver(c0579b.f872Va, c0579b.f873Vb);
        }
        this.f2125UU = true;
        return z;
    }

    public final void onStart() {
        super.onStart();
        mo1401fl();
    }

    public final void onStop() {
        super.onStop();
        if (this.f2127UW != null) {
            this.f2127UW.cleanup();
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: bg */
    public int mo16927bg(int i) {
        switch (i) {
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                return -1;
            case 0:
                m13510fp();
                C0579b c0579b = this.f2127UW;
                c0579b.f871UZ = c0579b.f870UY.mo1427fC();
                return c0579b.f871UZ ? 2 : 1;
            default:
                return i;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f2124UT != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f2124UT);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.f2127UW != null) {
            this.f2127UW.cleanup();
        }
    }

    /* renamed from: fp */
    private void m13510fp() {
        if (this.f2127UW == null) {
            this.f2127UW = new C0579b(C0586n.m1269W(this.mContext));
        }
    }

    /* renamed from: fq */
    private boolean m13511fq() {
        if (!this.f2125UU || !(this.mContext instanceof Activity)) {
            return false;
        }
        try {
            if ((this.mContext.getPackageManager().getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 512) == 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return true;
        }
    }
}
