package com.tencent.p177mm.plugin.appbrand.p329s.p330a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.model.WMElement;

/* renamed from: com.tencent.mm.plugin.appbrand.s.a.b */
final class C2457b implements C45680e {
    private final IntentFilter bJe = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private final C42675d iRY = new C42675d();
    Intent iRZ = null;
    final C45680e iSa = this;
    private C2458a iSb;
    protected Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.s.a.b$a */
    class C2458a extends BroadcastReceiver {
        private C2458a() {
        }

        /* synthetic */ C2458a(C2457b c2457b, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (C2457b.this.iSa) {
                C2457b.this.iRZ = intent;
            }
        }
    }

    C2457b() {
        AppMethodBeat.m2504i(126653);
        AppMethodBeat.m2505o(126653);
    }

    public final synchronized void init(Context context) {
        AppMethodBeat.m2504i(126654);
        this.iRZ = null;
        this.mContext = context.getApplicationContext();
        AppMethodBeat.m2505o(126654);
    }

    public final synchronized void release() {
        AppMethodBeat.m2504i(126655);
        if (this.mContext != null) {
            if (this.iSb != null) {
                this.mContext.unregisterReceiver(this.iSb);
            }
            this.mContext = null;
        }
        AppMethodBeat.m2505o(126655);
    }

    /* JADX WARNING: Missing block: B:31:0x0082, code skipped:
            if (r4 != 4) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized C45679c aOb() {
        C45679c c45679c;
        boolean z = true;
        int i = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(126656);
            if (this.mContext == null) {
                C4990ab.m7412e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
                c45679c = C2456a.iRV;
                AppMethodBeat.m2505o(126656);
            } else {
                Intent intent;
                Context context = this.mContext;
                if (this.iRZ != null) {
                    intent = this.iRZ;
                } else {
                    this.iSb = new C2458a(this, (byte) 0);
                    Intent registerReceiver = context.getApplicationContext().registerReceiver(this.iSb, this.bJe);
                    this.iRZ = registerReceiver;
                    intent = registerReceiver;
                }
                if (intent == null) {
                    C4990ab.m7412e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
                    c45679c = C2456a.iRV;
                    AppMethodBeat.m2505o(126656);
                } else {
                    c45679c = new C45679c();
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("level", -1);
                        int intExtra2 = intent.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1);
                        if (intExtra2 > 0 && intExtra >= 0) {
                            i = Math.min(Math.max((int) Math.floor((double) ((((float) intExtra) * 100.0f) / ((float) intExtra2))), 0), 100);
                        }
                    }
                    c45679c.iSe = i;
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
                        c45679c.iSd = z;
                        AppMethodBeat.m2505o(126656);
                    }
                    z = false;
                    c45679c.iSd = z;
                    AppMethodBeat.m2505o(126656);
                }
            }
        }
        return c45679c;
    }
}
