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

/* renamed from: com.tencent.liteav.audio.impl.c */
public class C25642c {
    /* renamed from: a */
    private static final C25642c f5239a = new C25642c();
    /* renamed from: b */
    private ConcurrentHashMap<Integer, WeakReference<C45101e>> f5240b = new ConcurrentHashMap();
    /* renamed from: c */
    private PhoneStateListener f5241c = null;
    /* renamed from: d */
    private Context f5242d;

    /* renamed from: com.tencent.liteav.audio.impl.c$2 */
    class C256432 implements Runnable {
        C256432() {
        }

        public void run() {
            AppMethodBeat.m2504i(66542);
            if (!(C25642c.this.f5241c == null || C25642c.this.f5242d == null)) {
                ((TelephonyManager) C25642c.this.f5242d.getApplicationContext().getSystemService("phone")).listen(C25642c.this.f5241c, 0);
            }
            C25642c.this.f5241c = null;
            AppMethodBeat.m2505o(66542);
        }
    }

    /* renamed from: com.tencent.liteav.audio.impl.c$1 */
    class C256441 implements Runnable {

        /* renamed from: com.tencent.liteav.audio.impl.c$1$1 */
        class C256411 extends PhoneStateListener {
            C256411() {
            }

            public void onCallStateChanged(int i, String str) {
                AppMethodBeat.m2504i(66544);
                super.onCallStateChanged(i, str);
                TXCLog.m15677i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:".concat(String.valueOf(i)));
                C25642c.m40633a(C25642c.this, i);
                AppMethodBeat.m2505o(66544);
            }
        }

        C256441() {
        }

        public void run() {
            AppMethodBeat.m2504i(66636);
            if (C25642c.this.f5241c != null) {
                AppMethodBeat.m2505o(66636);
                return;
            }
            C25642c.this.f5241c = new C256411();
            ((TelephonyManager) C25642c.this.f5242d.getSystemService("phone")).listen(C25642c.this.f5241c, 32);
            AppMethodBeat.m2505o(66636);
        }
    }

    static {
        AppMethodBeat.m2504i(66552);
        AppMethodBeat.m2505o(66552);
    }

    /* renamed from: a */
    public static C25642c m40631a() {
        return f5239a;
    }

    private C25642c() {
        AppMethodBeat.m2504i(66545);
        AppMethodBeat.m2505o(66545);
    }

    /* renamed from: a */
    public synchronized void mo43366a(C45101e c45101e) {
        AppMethodBeat.m2504i(66546);
        if (c45101e == null) {
            AppMethodBeat.m2505o(66546);
        } else {
            this.f5240b.put(Integer.valueOf(c45101e.hashCode()), new WeakReference(c45101e));
            AppMethodBeat.m2505o(66546);
        }
    }

    /* renamed from: b */
    public synchronized void mo43367b(C45101e c45101e) {
        AppMethodBeat.m2504i(66547);
        if (c45101e == null) {
            AppMethodBeat.m2505o(66547);
        } else {
            if (this.f5240b.containsKey(Integer.valueOf(c45101e.hashCode()))) {
                this.f5240b.remove(Integer.valueOf(c45101e.hashCode()));
            }
            AppMethodBeat.m2505o(66547);
        }
    }

    /* renamed from: a */
    private synchronized void m40632a(int i) {
        AppMethodBeat.m2504i(66548);
        Iterator it = this.f5240b.entrySet().iterator();
        while (it.hasNext()) {
            C45101e c45101e = (C45101e) ((WeakReference) ((Entry) it.next()).getValue()).get();
            if (c45101e != null) {
                c45101e.mo3796b(i);
            } else {
                it.remove();
            }
        }
        AppMethodBeat.m2505o(66548);
    }

    /* renamed from: a */
    public void mo43365a(Context context) {
        AppMethodBeat.m2504i(66549);
        if (this.f5241c != null) {
            AppMethodBeat.m2505o(66549);
            return;
        }
        this.f5242d = context.getApplicationContext();
        new Handler(Looper.getMainLooper()).post(new C256441());
        AppMethodBeat.m2505o(66549);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(66550);
        super.finalize();
        if (!(this.f5241c == null || this.f5242d == null)) {
            new Handler(Looper.getMainLooper()).post(new C256432());
        }
        AppMethodBeat.m2505o(66550);
    }
}
