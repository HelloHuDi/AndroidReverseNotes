package com.tencent.p177mm.plugin.p369d.p370a.p372b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C2861c.C2862a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C33889f.C11472a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C38826c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.b.e */
public final class C38828e {
    /* renamed from: Gn */
    public Context f16165Gn;
    public final HashMap<Long, C33889f> jFA;
    public C2861c jFC;
    public C2862a jFF;
    C38831a jGi;
    public HashSet<Long> jGj;
    final HashMap<Long, Boolean> jGk;
    public C11472a jGl;
    public C7306ak mHandler;
    private ReentrantLock mLock;
    public Runnable mRunnable;

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$1 */
    class C28711 implements C2862a {
        C28711() {
        }

        /* renamed from: a */
        public final void mo6982a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            AppMethodBeat.m2504i(18403);
            long KK = C42992b.m76346KK(bluetoothDevice.getAddress());
            if (!C38828e.this.jGj.contains(Long.valueOf(KK))) {
                C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(KK), C42992b.m76349aN(bArr));
                C38828e.this.jGj.add(Long.valueOf(KK));
                if (C38826c.m65876au(bArr)) {
                    C38828e.this.jGi.mo54592a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
                }
            }
            AppMethodBeat.m2505o(18403);
        }

        public final void aVx() {
            AppMethodBeat.m2504i(18404);
            C4990ab.m7410d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
            if (C38828e.this.jGi != null) {
                C38828e.this.jGi.aVx();
            } else {
                C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
            }
            C38828e.this.jGj.clear();
            AppMethodBeat.m2505o(18404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$2 */
    class C202892 extends C11472a {
        C202892() {
        }

        /* renamed from: a */
        public final void mo23199a(long j, boolean z, long j2) {
            AppMethodBeat.m2504i(18406);
            String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
            String str2 = "onConnected. mac = %s, connected = %s";
            Object[] objArr = new Object[2];
            objArr[0] = C42992b.m76358ie(j);
            objArr[1] = z ? "true" : "false";
            C4990ab.m7411d(str, str2, objArr);
            final long j3 = j;
            final boolean z2 = z;
            final long j4 = j2;
            C38828e.this.mo61710Q(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18405);
                    C33889f c33889f = (C33889f) C38828e.this.jFA.get(Long.valueOf(j3));
                    Boolean bool = Boolean.FALSE;
                    int i = !z2 ? 1 : 0;
                    if (c33889f == null && i == 0) {
                        C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", C42992b.m76358ie(j3));
                    } else {
                        if (C38828e.this.jGi != null) {
                            C38828e.this.jGi.mo54591a(j3, z2, j4);
                            if (i != 0) {
                                C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", C42992b.m76358ie(j3));
                            }
                        }
                        if (i != 0) {
                            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", C42992b.m76358ie(j3));
                            C38828e.this.jFA.remove(Long.valueOf(j3));
                            C38828e.this.jGk.remove(Long.valueOf(j3));
                            AppMethodBeat.m2505o(18405);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(18405);
                }
            });
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", Integer.valueOf(C38828e.this.jFA.size()));
            AppMethodBeat.m2505o(18406);
        }

        /* renamed from: b */
        public final void mo23200b(long j, byte[] bArr) {
            AppMethodBeat.m2504i(18407);
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", C42992b.m76358ie(j));
            if (C38828e.this.jGi != null) {
                C38828e.this.jGi.mo54594b(j, bArr);
                AppMethodBeat.m2505o(18407);
                return;
            }
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
            AppMethodBeat.m2505o(18407);
        }

        /* renamed from: m */
        public final void mo23201m(long j, boolean z) {
            AppMethodBeat.m2504i(18408);
            String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
            String str2 = "onSend. mac = %s, success = %s";
            Object[] objArr = new Object[2];
            objArr[0] = C42992b.m76358ie(j);
            objArr[1] = z ? "true" : "false";
            C4990ab.m7411d(str, str2, objArr);
            if (C38828e.this.jGi != null) {
                C38828e.this.jGi.mo54595m(j, z);
            }
            AppMethodBeat.m2505o(18408);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$4 */
    public class C388274 implements Runnable {
        final /* synthetic */ long jGq;
        final /* synthetic */ C33889f jGr;

        public C388274(long j, C33889f c33889f) {
            this.jGq = j;
            this.jGr = c33889f;
        }

        public final void run() {
            AppMethodBeat.m2504i(18410);
            C38828e.this.jFA.put(Long.valueOf(this.jGq), this.jGr);
            AppMethodBeat.m2505o(18410);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$3 */
    class C388293 implements Runnable {
        C388293() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18409);
            C38828e.this.jFC.mo6989a(false, C38828e.this.jFF);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
            AppMethodBeat.m2505o(18409);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$5 */
    public class C388305 implements Runnable {
        final /* synthetic */ long jGq;

        public C388305(long j) {
            this.jGq = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(18411);
            C33889f c33889f = (C33889f) C38828e.this.jFA.remove(Long.valueOf(this.jGq));
            if (c33889f != null) {
                C4990ab.m7417i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", C42992b.m76358ie(c33889f.mSessionId), c33889f.hGa.getName());
                if (!c33889f.mHandler.sendMessage(c33889f.mHandler.obtainMessage(2))) {
                    C4990ab.m7413e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(2));
                }
                C38828e.this.jGk.put(Long.valueOf(this.jGq), Boolean.TRUE);
                AppMethodBeat.m2505o(18411);
                return;
            }
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
            AppMethodBeat.m2505o(18411);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.e$a */
    public static abstract class C38831a {
        /* renamed from: a */
        public void mo54591a(long j, boolean z, long j2) {
        }

        /* renamed from: b */
        public void mo54594b(long j, byte[] bArr) {
        }

        /* renamed from: m */
        public void mo54595m(long j, boolean z) {
        }

        /* renamed from: a */
        public void mo54592a(String str, String str2, int i, byte[] bArr) {
        }

        public void aVx() {
        }
    }

    public C38828e(C38831a c38831a) {
        AppMethodBeat.m2504i(18412);
        this.f16165Gn = null;
        this.mLock = new ReentrantLock();
        this.mHandler = null;
        this.mRunnable = null;
        this.jFF = new C28711();
        this.jGj = new HashSet();
        this.jFA = new HashMap();
        this.jGk = new HashMap();
        this.jGl = new C202892();
        this.f16165Gn = C4996ah.getContext();
        this.jGi = c38831a;
        this.jFC = C2861c.aVy();
        this.mRunnable = new C388293();
        this.mHandler = new C7306ak(new C5004al("BluetoothLESimpleManagerThread").oAl.getLooper());
        AppMethodBeat.m2505o(18412);
    }

    /* renamed from: Q */
    public final void mo61710Q(Runnable runnable) {
        AppMethodBeat.m2504i(18413);
        this.mLock.lock();
        runnable.run();
        this.mLock.unlock();
        AppMethodBeat.m2505o(18413);
    }

    @TargetApi(18)
    public final boolean aVw() {
        AppMethodBeat.m2504i(18414);
        boolean hasSystemFeature = this.f16165Gn.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        AppMethodBeat.m2505o(18414);
        return hasSystemFeature;
    }
}
