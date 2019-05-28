package android.support.v7.app;

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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;

class g extends AppCompatDelegateImplV9 {
    private int UT = -100;
    private boolean UU;
    boolean UV = true;
    private b UW;

    final class b {
        n UY;
        boolean UZ;
        BroadcastReceiver Va;
        IntentFilter Vb;

        b(n nVar) {
            this.UY = nVar;
            this.UZ = nVar.fC();
        }

        /* Access modifiers changed, original: final */
        public final void cleanup() {
            if (this.Va != null) {
                g.this.mContext.unregisterReceiver(this.Va);
                this.Va = null;
            }
        }
    }

    class a extends b {
        a(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (g.this.UV) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* Access modifiers changed, original: final */
        public final ActionMode a(ActionMode.Callback callback) {
            android.support.v7.view.f.a aVar = new android.support.v7.view.f.a(g.this.mContext, callback);
            android.support.v7.view.b startSupportActionMode = g.this.startSupportActionMode(aVar);
            if (startSupportActionMode != null) {
                return aVar.b(startSupportActionMode);
            }
            return null;
        }
    }

    g(Context context, Window window, c cVar) {
        super(context, window, cVar);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.UT == -100) {
            this.UT = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* Access modifiers changed, original: final */
    public final View a(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public Callback a(Callback callback) {
        return new a(callback);
    }

    public final boolean fl() {
        int i;
        boolean z;
        if (this.UT != -100) {
            i = this.UT;
        } else {
            i = d.UB;
        }
        int bg = bg(i);
        if (bg != -1) {
            Resources resources = this.mContext.getResources();
            Configuration configuration = resources.getConfiguration();
            int i2 = configuration.uiMode & 48;
            bg = bg == 2 ? 32 : 16;
            if (i2 != bg) {
                if (fq()) {
                    ((Activity) this.mContext).recreate();
                } else {
                    Configuration configuration2 = new Configuration(configuration);
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    configuration2.uiMode = bg | (configuration2.uiMode & -49);
                    resources.updateConfiguration(configuration2, displayMetrics);
                    if (VERSION.SDK_INT < 26) {
                        if (VERSION.SDK_INT >= 24) {
                            k.c(resources);
                        } else if (VERSION.SDK_INT >= 23) {
                            k.b(resources);
                        } else if (VERSION.SDK_INT >= 21) {
                            k.a(resources);
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
            fp();
            b bVar = this.UW;
            bVar.cleanup();
            if (bVar.Va == null) {
                bVar.Va = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        b bVar = b.this;
                        boolean fC = bVar.UY.fC();
                        if (fC != bVar.UZ) {
                            bVar.UZ = fC;
                            g.this.fl();
                        }
                    }
                };
            }
            if (bVar.Vb == null) {
                bVar.Vb = new IntentFilter();
                bVar.Vb.addAction("android.intent.action.TIME_SET");
                bVar.Vb.addAction("android.intent.action.TIMEZONE_CHANGED");
                bVar.Vb.addAction("android.intent.action.TIME_TICK");
            }
            g.this.mContext.registerReceiver(bVar.Va, bVar.Vb);
        }
        this.UU = true;
        return z;
    }

    public final void onStart() {
        super.onStart();
        fl();
    }

    public final void onStop() {
        super.onStop();
        if (this.UW != null) {
            this.UW.cleanup();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int bg(int i) {
        switch (i) {
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                return -1;
            case 0:
                fp();
                b bVar = this.UW;
                bVar.UZ = bVar.UY.fC();
                return bVar.UZ ? 2 : 1;
            default:
                return i;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.UT != -100) {
            bundle.putInt("appcompat:local_night_mode", this.UT);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.UW != null) {
            this.UW.cleanup();
        }
    }

    private void fp() {
        if (this.UW == null) {
            this.UW = new b(n.W(this.mContext));
        }
    }

    private boolean fq() {
        if (!this.UU || !(this.mContext instanceof Activity)) {
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
