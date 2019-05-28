package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.a.c;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e {
    public Context Gn;
    public final HashMap<Long, f> jFA;
    public c jFC;
    public com.tencent.mm.plugin.d.a.b.c.a jFF;
    a jGi;
    public HashSet<Long> jGj;
    final HashMap<Long, Boolean> jGk;
    public com.tencent.mm.plugin.d.a.b.f.a jGl;
    public ak mHandler;
    private ReentrantLock mLock;
    public Runnable mRunnable;

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ long jGq;
        final /* synthetic */ f jGr;

        public AnonymousClass4(long j, f fVar) {
            this.jGq = j;
            this.jGr = fVar;
        }

        public final void run() {
            AppMethodBeat.i(18410);
            e.this.jFA.put(Long.valueOf(this.jGq), this.jGr);
            AppMethodBeat.o(18410);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ long jGq;

        public AnonymousClass5(long j) {
            this.jGq = j;
        }

        public final void run() {
            AppMethodBeat.i(18411);
            f fVar = (f) e.this.jFA.remove(Long.valueOf(this.jGq));
            if (fVar != null) {
                ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", b.ie(fVar.mSessionId), fVar.hGa.getName());
                if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(2))) {
                    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(2));
                }
                e.this.jGk.put(Long.valueOf(this.jGq), Boolean.TRUE);
                AppMethodBeat.o(18411);
                return;
            }
            ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
            AppMethodBeat.o(18411);
        }
    }

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void m(long j, boolean z) {
        }

        public void a(String str, String str2, int i, byte[] bArr) {
        }

        public void aVx() {
        }
    }

    public e(a aVar) {
        AppMethodBeat.i(18412);
        this.Gn = null;
        this.mLock = new ReentrantLock();
        this.mHandler = null;
        this.mRunnable = null;
        this.jFF = new com.tencent.mm.plugin.d.a.b.c.a() {
            public final void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                AppMethodBeat.i(18403);
                long KK = b.KK(bluetoothDevice.getAddress());
                if (!e.this.jGj.contains(Long.valueOf(KK))) {
                    ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(KK), b.aN(bArr));
                    e.this.jGj.add(Long.valueOf(KK));
                    if (c.au(bArr)) {
                        e.this.jGi.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
                    }
                }
                AppMethodBeat.o(18403);
            }

            public final void aVx() {
                AppMethodBeat.i(18404);
                ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
                if (e.this.jGi != null) {
                    e.this.jGi.aVx();
                } else {
                    ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
                }
                e.this.jGj.clear();
                AppMethodBeat.o(18404);
            }
        };
        this.jGj = new HashSet();
        this.jFA = new HashMap();
        this.jGk = new HashMap();
        this.jGl = new com.tencent.mm.plugin.d.a.b.f.a() {
            public final void a(long j, boolean z, long j2) {
                AppMethodBeat.i(18406);
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onConnected. mac = %s, connected = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.ie(j);
                objArr[1] = z ? "true" : "false";
                ab.d(str, str2, objArr);
                final long j3 = j;
                final boolean z2 = z;
                final long j4 = j2;
                e.this.Q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18405);
                        f fVar = (f) e.this.jFA.get(Long.valueOf(j3));
                        Boolean bool = Boolean.FALSE;
                        int i = !z2 ? 1 : 0;
                        if (fVar == null && i == 0) {
                            ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", b.ie(j3));
                        } else {
                            if (e.this.jGi != null) {
                                e.this.jGi.a(j3, z2, j4);
                                if (i != 0) {
                                    ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", b.ie(j3));
                                }
                            }
                            if (i != 0) {
                                ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", b.ie(j3));
                                e.this.jFA.remove(Long.valueOf(j3));
                                e.this.jGk.remove(Long.valueOf(j3));
                                AppMethodBeat.o(18405);
                                return;
                            }
                        }
                        AppMethodBeat.o(18405);
                    }
                });
                ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", Integer.valueOf(e.this.jFA.size()));
                AppMethodBeat.o(18406);
            }

            public final void b(long j, byte[] bArr) {
                AppMethodBeat.i(18407);
                ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", b.ie(j));
                if (e.this.jGi != null) {
                    e.this.jGi.b(j, bArr);
                    AppMethodBeat.o(18407);
                    return;
                }
                ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
                AppMethodBeat.o(18407);
            }

            public final void m(long j, boolean z) {
                AppMethodBeat.i(18408);
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onSend. mac = %s, success = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.ie(j);
                objArr[1] = z ? "true" : "false";
                ab.d(str, str2, objArr);
                if (e.this.jGi != null) {
                    e.this.jGi.m(j, z);
                }
                AppMethodBeat.o(18408);
            }
        };
        this.Gn = ah.getContext();
        this.jGi = aVar;
        this.jFC = c.aVy();
        this.mRunnable = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18409);
                e.this.jFC.a(false, e.this.jFF);
                ab.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
                AppMethodBeat.o(18409);
            }
        };
        this.mHandler = new ak(new al("BluetoothLESimpleManagerThread").oAl.getLooper());
        AppMethodBeat.o(18412);
    }

    public final void Q(Runnable runnable) {
        AppMethodBeat.i(18413);
        this.mLock.lock();
        runnable.run();
        this.mLock.unlock();
        AppMethodBeat.o(18413);
    }

    @TargetApi(18)
    public final boolean aVw() {
        AppMethodBeat.i(18414);
        boolean hasSystemFeature = this.Gn.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        AppMethodBeat.o(18414);
        return hasSystemFeature;
    }
}
