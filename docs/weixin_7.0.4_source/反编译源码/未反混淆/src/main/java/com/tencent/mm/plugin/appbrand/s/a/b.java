package com.tencent.mm.plugin.appbrand.s.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.model.WMElement;

final class b implements e {
    private final IntentFilter bJe = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private final d iRY = new d();
    Intent iRZ = null;
    final e iSa = this;
    private a iSb;
    protected Context mContext;

    class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (b.this.iSa) {
                b.this.iRZ = intent;
            }
        }
    }

    b() {
        AppMethodBeat.i(126653);
        AppMethodBeat.o(126653);
    }

    public final synchronized void init(Context context) {
        AppMethodBeat.i(126654);
        this.iRZ = null;
        this.mContext = context.getApplicationContext();
        AppMethodBeat.o(126654);
    }

    public final synchronized void release() {
        AppMethodBeat.i(126655);
        if (this.mContext != null) {
            if (this.iSb != null) {
                this.mContext.unregisterReceiver(this.iSb);
            }
            this.mContext = null;
        }
        AppMethodBeat.o(126655);
    }

    /* JADX WARNING: Missing block: B:31:0x0082, code skipped:
            if (r4 != 4) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized c aOb() {
        c cVar;
        boolean z = true;
        int i = -1;
        synchronized (this) {
            AppMethodBeat.i(126656);
            if (this.mContext == null) {
                ab.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
                cVar = a.iRV;
                AppMethodBeat.o(126656);
            } else {
                Intent intent;
                Context context = this.mContext;
                if (this.iRZ != null) {
                    intent = this.iRZ;
                } else {
                    this.iSb = new a(this, (byte) 0);
                    Intent registerReceiver = context.getApplicationContext().registerReceiver(this.iSb, this.bJe);
                    this.iRZ = registerReceiver;
                    intent = registerReceiver;
                }
                if (intent == null) {
                    ab.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
                    cVar = a.iRV;
                    AppMethodBeat.o(126656);
                } else {
                    cVar = new c();
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("level", -1);
                        int intExtra2 = intent.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1);
                        if (intExtra2 > 0 && intExtra >= 0) {
                            i = Math.min(Math.max((int) Math.floor((double) ((((float) intExtra) * 100.0f) / ((float) intExtra2))), 0), 100);
                        }
                    }
                    cVar.iSe = i;
                    if (intent != null) {
                        i = intent.getIntExtra("status", -1);
                        int intExtra3 = intent.getIntExtra("plugged", 0);
                        if (i != 2) {
                            if (intExtra3 != 1) {
                                if (intExtra3 != 2) {
                                    if (VERSION.SDK_INT >= 17) {
                                    }
                                }
                            }
                        }
                        cVar.iSd = z;
                        AppMethodBeat.o(126656);
                    }
                    z = false;
                    cVar.iSd = z;
                    AppMethodBeat.o(126656);
                }
            }
        }
        return cVar;
    }
}
