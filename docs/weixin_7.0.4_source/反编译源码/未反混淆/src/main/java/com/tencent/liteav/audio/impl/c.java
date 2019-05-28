package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static final c a = new c();
    private ConcurrentHashMap<Integer, WeakReference<e>> b = new ConcurrentHashMap();
    private PhoneStateListener c = null;
    private Context d;

    static {
        AppMethodBeat.i(66552);
        AppMethodBeat.o(66552);
    }

    public static c a() {
        return a;
    }

    private c() {
        AppMethodBeat.i(66545);
        AppMethodBeat.o(66545);
    }

    public synchronized void a(e eVar) {
        AppMethodBeat.i(66546);
        if (eVar == null) {
            AppMethodBeat.o(66546);
        } else {
            this.b.put(Integer.valueOf(eVar.hashCode()), new WeakReference(eVar));
            AppMethodBeat.o(66546);
        }
    }

    public synchronized void b(e eVar) {
        AppMethodBeat.i(66547);
        if (eVar == null) {
            AppMethodBeat.o(66547);
        } else {
            if (this.b.containsKey(Integer.valueOf(eVar.hashCode()))) {
                this.b.remove(Integer.valueOf(eVar.hashCode()));
            }
            AppMethodBeat.o(66547);
        }
    }

    private synchronized void a(int i) {
        AppMethodBeat.i(66548);
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            e eVar = (e) ((WeakReference) ((Entry) it.next()).getValue()).get();
            if (eVar != null) {
                eVar.b(i);
            } else {
                it.remove();
            }
        }
        AppMethodBeat.o(66548);
    }

    public void a(Context context) {
        AppMethodBeat.i(66549);
        if (this.c != null) {
            AppMethodBeat.o(66549);
            return;
        }
        this.d = context.getApplicationContext();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(66636);
                if (c.this.c != null) {
                    AppMethodBeat.o(66636);
                    return;
                }
                c.this.c = new PhoneStateListener() {
                    public void onCallStateChanged(int i, String str) {
                        AppMethodBeat.i(66544);
                        super.onCallStateChanged(i, str);
                        TXCLog.i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:".concat(String.valueOf(i)));
                        c.a(c.this, i);
                        AppMethodBeat.o(66544);
                    }
                };
                ((TelephonyManager) c.this.d.getSystemService("phone")).listen(c.this.c, 32);
                AppMethodBeat.o(66636);
            }
        });
        AppMethodBeat.o(66549);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(66550);
        super.finalize();
        if (!(this.c == null || this.d == null)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(66542);
                    if (!(c.this.c == null || c.this.d == null)) {
                        ((TelephonyManager) c.this.d.getApplicationContext().getSystemService("phone")).listen(c.this.c, 0);
                    }
                    c.this.c = null;
                    AppMethodBeat.o(66542);
                }
            });
        }
        AppMethodBeat.o(66550);
    }
}
