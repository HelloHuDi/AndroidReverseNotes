package com.tencent.soter.core.p1425d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C24322h;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C44474b;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C44478f;
import com.tencent.soter.soterserver.C36454a;
import com.tencent.soter.soterserver.C36454a.C36455a;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.soterserver.SoterSignResult;
import java.security.Signature;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.soter.core.d.d */
public final class C41353d extends C40999b implements C44474b {
    private C30975e AvA = new C30975e();
    private DeathRecipient AvB = new C309741();
    private ServiceConnection AvC = new C410002();
    protected C36454a Avz;
    private boolean connected = false;
    private final Object lock = new Object();
    private Context mContext;

    /* renamed from: com.tencent.soter.core.d.d$1 */
    class C309741 implements DeathRecipient {
        C309741() {
        }

        public final void binderDied() {
            AppMethodBeat.m2504i(73068);
            C44476d.m80484i("Soter.SoterCoreTreble", "soter: binder died", new Object[0]);
            if (C41353d.this.Avz == null) {
                AppMethodBeat.m2505o(73068);
                return;
            }
            synchronized (C41353d.this.lock) {
                try {
                    C41353d.this.connected = false;
                    C41353d.this.lock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(73068);
                }
            }
            C41353d.this.Avz.asBinder().unlinkToDeath(C41353d.this.AvB, 0);
            C41353d.this.Avz = null;
            C41353d.this.beW();
        }
    }

    /* renamed from: com.tencent.soter.core.d.d$2 */
    class C410002 implements ServiceConnection {
        C410002() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(73069);
            C44476d.m80484i("Soter.SoterCoreTreble", "soter: onServiceConnected", new Object[0]);
            synchronized (C41353d.this.lock) {
                try {
                    C41353d.this.connected = true;
                    C41353d.this.lock.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(73069);
                    }
                }
            }
            try {
                iBinder.linkToDeath(C41353d.this.AvB, 0);
                C41353d.this.Avz = C36455a.m60228O(iBinder);
            } catch (RemoteException e) {
                C44476d.m80483e("Soter.SoterCoreTreble", "soter: Binding deathRecipient is error - RemoteException" + e.toString(), new Object[0]);
            }
            C44476d.m80484i("Soter.SoterCoreTreble", "soter: Binding is done - Service connected", new Object[0]);
            C41353d.this.AvA.countDown();
            AppMethodBeat.m2505o(73069);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(73070);
            synchronized (C41353d.this.lock) {
                try {
                    C41353d.this.connected = false;
                    C41353d.this.lock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(73070);
                }
            }
            C41353d.this.Avz = null;
            C44476d.m80484i("Soter.SoterCoreTreble", "soter: unBinding is done - Service disconnected", new Object[0]);
            C41353d.this.AvA.countDown();
            C41353d.this.beW();
        }
    }

    /* renamed from: com.tencent.soter.core.d.d$3 */
    class C413543 implements Runnable {
        C413543() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73071);
            C41353d.this.dRa();
            C44476d.m80484i("Soter.SoterCoreTreble", "soter: initSoter binding", new Object[0]);
            AppMethodBeat.m2505o(73071);
        }
    }

    public C41353d() {
        AppMethodBeat.m2504i(73072);
        AppMethodBeat.m2505o(73072);
    }

    /* renamed from: iV */
    public final boolean mo64960iV(Context context) {
        AppMethodBeat.m2504i(73073);
        this.mContext = context;
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: initSoter in", new Object[0]);
        C30975e c30975e = this.AvA;
        C413543 c413543 = new C413543();
        if (c30975e.vaN == null) {
            c30975e.vaN = new CountDownLatch(1);
        }
        C30975e.m49598d(c413543);
        if (c30975e.vaN != null) {
            try {
                c30975e.vaN.await(3000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        if (this.connected) {
            C44476d.m80484i("Soter.SoterCoreTreble", "soter: initSoter finish", new Object[0]);
            AppMethodBeat.m2505o(73073);
            return true;
        }
        C44476d.m80483e("Soter.SoterCoreTreble", "soter: initSoter error", new Object[0]);
        AppMethodBeat.m2505o(73073);
        return false;
    }

    public final void dRa() {
        AppMethodBeat.m2504i(73074);
        if (!this.connected) {
            C44476d.m80484i("Soter.SoterCoreTreble", "soter: bindServiceIfNeeded try to bind", new Object[0]);
            beW();
        }
        AppMethodBeat.m2505o(73074);
    }

    public final void beW() {
        AppMethodBeat.m2504i(73075);
        Intent intent = new Intent();
        intent.setAction("com.tencent.soter.soterserver.ISoterService");
        intent.setPackage("com.tencent.soter.soterserver");
        if (this.mContext == null) {
            C44476d.m80483e("Soter.SoterCoreTreble", "soter: bindService context is null ", new Object[0]);
            AppMethodBeat.m2505o(73075);
            return;
        }
        this.mContext.bindService(intent, this.AvC, 1);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: bindService binding is start ", new Object[0]);
        AppMethodBeat.m2505o(73075);
    }

    public final boolean dQN() {
        AppMethodBeat.m2504i(73076);
        if (C24322h.dQY()) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: the device has already triggered OOM. mark as not support", new Object[0]);
            AppMethodBeat.m2505o(73076);
            return false;
        }
        AppMethodBeat.m2505o(73076);
        return true;
    }

    public final C44478f dQO() {
        AppMethodBeat.m2504i(73077);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: generateAppSecureKey in", new Object[0]);
        C44478f c44478f;
        if (!dQN()) {
            c44478f = new C44478f(4);
            AppMethodBeat.m2505o(73077);
            return c44478f;
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            c44478f = new C44478f(4);
            AppMethodBeat.m2505o(73077);
            return c44478f;
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                c44478f = new C44478f(4);
                AppMethodBeat.m2505o(73077);
                return c44478f;
            }
            try {
                if (this.Avz.mo29031Re(Process.myUid()) == 0) {
                    c44478f = new C44478f(0);
                    AppMethodBeat.m2505o(73077);
                    return c44478f;
                }
            } catch (RemoteException e) {
            }
            c44478f = new C44478f(4);
            AppMethodBeat.m2505o(73077);
            return c44478f;
        }
    }

    public final C44478f dQP() {
        AppMethodBeat.m2504i(73078);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: removeAppGlobalSecureKey in", new Object[0]);
        C44478f c44478f;
        if (!dQN()) {
            c44478f = new C44478f(5);
            AppMethodBeat.m2505o(73078);
            return c44478f;
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            c44478f = new C44478f(5);
            AppMethodBeat.m2505o(73078);
            return c44478f;
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                c44478f = new C44478f(5);
                AppMethodBeat.m2505o(73078);
                return c44478f;
            }
            try {
                if (this.Avz.mo29034Rh(Process.myUid()) == 0) {
                    c44478f = new C44478f(0);
                    AppMethodBeat.m2505o(73078);
                    return c44478f;
                }
            } catch (RemoteException e) {
            }
            c44478f = new C44478f(5);
            AppMethodBeat.m2505o(73078);
            return c44478f;
        }
    }

    public final boolean dQQ() {
        boolean z = false;
        AppMethodBeat.m2504i(73079);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: hasAppGlobalSecureKey in", new Object[z]);
        if (!dQN()) {
            AppMethodBeat.m2505o(73079);
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[z]);
            AppMethodBeat.m2505o(73079);
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[z]);
                AppMethodBeat.m2505o(73079);
            } else {
                try {
                    z = this.Avz.mo29033Rg(Process.myUid());
                    AppMethodBeat.m2505o(73079);
                } catch (RemoteException e) {
                    AppMethodBeat.m2505o(73079);
                }
            }
        }
        return z;
    }

    public final boolean dQR() {
        AppMethodBeat.m2504i(73080);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: isAppGlobalSecureKeyValid in", new Object[0]);
        if (!dQQ() || dQS() == null) {
            AppMethodBeat.m2505o(73080);
            return false;
        }
        AppMethodBeat.m2505o(73080);
        return true;
    }

    public final C30972i dQS() {
        C30972i c30972i = null;
        AppMethodBeat.m2504i(73081);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: getAppGlobalSecureKeyModel in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.m2505o(73081);
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(73081);
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.m2505o(73081);
            } else {
                try {
                    byte[] bArr = this.Avz.mo29032Rf(Process.myUid()).AvF;
                    if (bArr == null || bArr.length <= 0) {
                        C44476d.m80483e("Soter.SoterCoreTreble", "soter: soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.m2505o(73081);
                    } else {
                        c30972i = C40999b.m71103cp(bArr);
                        AppMethodBeat.m2505o(73081);
                    }
                } catch (RemoteException e) {
                    AppMethodBeat.m2505o(73081);
                }
            }
        }
        return c30972i;
    }

    public final C44478f atZ(String str) {
        AppMethodBeat.m2504i(73082);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: generateAuthKey in", new Object[0]);
        C44478f c44478f;
        if (!dQN()) {
            c44478f = new C44478f(5);
            AppMethodBeat.m2505o(73082);
            return c44478f;
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            c44478f = new C44478f(5);
            AppMethodBeat.m2505o(73082);
            return c44478f;
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                c44478f = new C44478f(5);
                AppMethodBeat.m2505o(73082);
                return c44478f;
            }
            try {
                if (this.Avz.mo29036bS(Process.myUid(), str) == 0) {
                    c44478f = new C44478f(0);
                    AppMethodBeat.m2505o(73082);
                    return c44478f;
                }
            } catch (RemoteException e) {
            }
            c44478f = new C44478f(5);
            AppMethodBeat.m2505o(73082);
            return c44478f;
        }
    }

    /* renamed from: cn */
    public final C44478f mo64954cn(String str, boolean z) {
        AppMethodBeat.m2504i(73083);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: removeAuthKey in", new Object[0]);
        C44478f c44478f;
        if (!dQN()) {
            c44478f = new C44478f(6);
            AppMethodBeat.m2505o(73083);
            return c44478f;
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            c44478f = new C44478f(6);
            AppMethodBeat.m2505o(73083);
            return c44478f;
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                c44478f = new C44478f(6);
                AppMethodBeat.m2505o(73083);
                return c44478f;
            }
            int myUid = Process.myUid();
            try {
                if (this.Avz.mo29037bT(myUid, str) == 0) {
                    if (!z) {
                        c44478f = new C44478f(0);
                        AppMethodBeat.m2505o(73083);
                        return c44478f;
                    } else if (this.Avz.mo29034Rh(myUid) == 0) {
                        c44478f = new C44478f(0);
                        AppMethodBeat.m2505o(73083);
                        return c44478f;
                    } else {
                        c44478f = new C44478f(5);
                        AppMethodBeat.m2505o(73083);
                        return c44478f;
                    }
                }
            } catch (RemoteException e) {
            }
            c44478f = new C44478f(6);
            AppMethodBeat.m2505o(73083);
            return c44478f;
        }
    }

    public final boolean aub(String str) {
        AppMethodBeat.m2504i(73084);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: isAuthKeyValid in", new Object[0]);
        if (!aua(str) || auc(str) == null) {
            AppMethodBeat.m2505o(73084);
            return false;
        }
        AppMethodBeat.m2505o(73084);
        return true;
    }

    public final C30972i auc(String str) {
        C30972i c30972i = null;
        AppMethodBeat.m2504i(73085);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: getAuthKeyModel in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.m2505o(73085);
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(73085);
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.m2505o(73085);
            } else {
                try {
                    byte[] bArr = this.Avz.mo29038bU(Process.myUid(), str).AvF;
                    if (bArr == null || bArr.length <= 0) {
                        C44476d.m80483e("Soter.SoterCoreTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.m2505o(73085);
                    } else {
                        c30972i = C40999b.m71103cp(bArr);
                        AppMethodBeat.m2505o(73085);
                    }
                } catch (RemoteException e) {
                    AppMethodBeat.m2505o(73085);
                }
            }
        }
        return c30972i;
    }

    public final Signature aud(String str) {
        return null;
    }

    public final boolean aua(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(73086);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: hasAuthKey in", new Object[z]);
        int myUid = Process.myUid();
        if (!dQN()) {
            AppMethodBeat.m2505o(73086);
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[z]);
            AppMethodBeat.m2505o(73086);
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[z]);
                AppMethodBeat.m2505o(73086);
            } else {
                try {
                    z = this.Avz.mo29039bV(myUid, str);
                    AppMethodBeat.m2505o(73086);
                } catch (RemoteException e) {
                    AppMethodBeat.m2505o(73086);
                }
            }
        }
        return z;
    }

    /* renamed from: iC */
    public final SoterSessionResult mo64959iC(String str, String str2) {
        SoterSessionResult soterSessionResult = null;
        AppMethodBeat.m2504i(73087);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: initSigh in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.m2505o(73087);
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(73087);
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.m2505o(73087);
            } else {
                try {
                    soterSessionResult = this.Avz.mo29030O(Process.myUid(), str, str2);
                    AppMethodBeat.m2505o(73087);
                } catch (RemoteException e) {
                    AppMethodBeat.m2505o(73087);
                }
            }
        }
        return soterSessionResult;
    }

    /* renamed from: nB */
    public final byte[] mo64961nB(long j) {
        byte[] bArr = null;
        AppMethodBeat.m2504i(73088);
        C44476d.m80484i("Soter.SoterCoreTreble", "soter: finishSign in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.m2505o(73088);
        } else if (this.mContext == null) {
            C44476d.m80486w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(73088);
        } else {
            dRa();
            if (this.Avz == null) {
                C44476d.m80486w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.m2505o(73088);
            } else {
                bArr = new byte[0];
                try {
                    SoterSignResult nD = this.Avz.mo29042nD(j);
                    bArr = nD.AvF;
                    if (nD.bFZ != 0) {
                        Exception exception = new Exception("finishSign error");
                        AppMethodBeat.m2505o(73088);
                        throw exception;
                    }
                } catch (RemoteException e) {
                }
                AppMethodBeat.m2505o(73088);
            }
        }
        return bArr;
    }
}
