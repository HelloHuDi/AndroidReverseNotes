package com.tencent.soter.core.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.b;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.soterserver.SoterSignResult;
import com.tencent.soter.soterserver.a.a;
import java.security.Signature;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class d extends b implements b {
    private e AvA = new e();
    private DeathRecipient AvB = new DeathRecipient() {
        public final void binderDied() {
            AppMethodBeat.i(73068);
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: binder died", new Object[0]);
            if (d.this.Avz == null) {
                AppMethodBeat.o(73068);
                return;
            }
            synchronized (d.this.lock) {
                try {
                    d.this.connected = false;
                    d.this.lock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(73068);
                }
            }
            d.this.Avz.asBinder().unlinkToDeath(d.this.AvB, 0);
            d.this.Avz = null;
            d.this.beW();
        }
    };
    private ServiceConnection AvC = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(73069);
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: onServiceConnected", new Object[0]);
            synchronized (d.this.lock) {
                try {
                    d.this.connected = true;
                    d.this.lock.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(73069);
                    }
                }
            }
            try {
                iBinder.linkToDeath(d.this.AvB, 0);
                d.this.Avz = a.O(iBinder);
            } catch (RemoteException e) {
                com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: Binding deathRecipient is error - RemoteException" + e.toString(), new Object[0]);
            }
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: Binding is done - Service connected", new Object[0]);
            d.this.AvA.countDown();
            AppMethodBeat.o(73069);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(73070);
            synchronized (d.this.lock) {
                try {
                    d.this.connected = false;
                    d.this.lock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(73070);
                }
            }
            d.this.Avz = null;
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: unBinding is done - Service disconnected", new Object[0]);
            d.this.AvA.countDown();
            d.this.beW();
        }
    };
    protected com.tencent.soter.soterserver.a Avz;
    private boolean connected = false;
    private final Object lock = new Object();
    private Context mContext;

    public d() {
        AppMethodBeat.i(73072);
        AppMethodBeat.o(73072);
    }

    public final boolean iV(Context context) {
        AppMethodBeat.i(73073);
        this.mContext = context;
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter in", new Object[0]);
        e eVar = this.AvA;
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(73071);
                d.this.dRa();
                com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter binding", new Object[0]);
                AppMethodBeat.o(73071);
            }
        };
        if (eVar.vaN == null) {
            eVar.vaN = new CountDownLatch(1);
        }
        e.d(anonymousClass3);
        if (eVar.vaN != null) {
            try {
                eVar.vaN.await(3000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        if (this.connected) {
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter finish", new Object[0]);
            AppMethodBeat.o(73073);
            return true;
        }
        com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: initSoter error", new Object[0]);
        AppMethodBeat.o(73073);
        return false;
    }

    public final void dRa() {
        AppMethodBeat.i(73074);
        if (!this.connected) {
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindServiceIfNeeded try to bind", new Object[0]);
            beW();
        }
        AppMethodBeat.o(73074);
    }

    public final void beW() {
        AppMethodBeat.i(73075);
        Intent intent = new Intent();
        intent.setAction("com.tencent.soter.soterserver.ISoterService");
        intent.setPackage("com.tencent.soter.soterserver");
        if (this.mContext == null) {
            com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: bindService context is null ", new Object[0]);
            AppMethodBeat.o(73075);
            return;
        }
        this.mContext.bindService(intent, this.AvC, 1);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindService binding is start ", new Object[0]);
        AppMethodBeat.o(73075);
    }

    public final boolean dQN() {
        AppMethodBeat.i(73076);
        if (h.dQY()) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: the device has already triggered OOM. mark as not support", new Object[0]);
            AppMethodBeat.o(73076);
            return false;
        }
        AppMethodBeat.o(73076);
        return true;
    }

    public final f dQO() {
        AppMethodBeat.i(73077);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAppSecureKey in", new Object[0]);
        f fVar;
        if (!dQN()) {
            fVar = new f(4);
            AppMethodBeat.o(73077);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            fVar = new f(4);
            AppMethodBeat.o(73077);
            return fVar;
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                fVar = new f(4);
                AppMethodBeat.o(73077);
                return fVar;
            }
            try {
                if (this.Avz.Re(Process.myUid()) == 0) {
                    fVar = new f(0);
                    AppMethodBeat.o(73077);
                    return fVar;
                }
            } catch (RemoteException e) {
            }
            fVar = new f(4);
            AppMethodBeat.o(73077);
            return fVar;
        }
    }

    public final f dQP() {
        AppMethodBeat.i(73078);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAppGlobalSecureKey in", new Object[0]);
        f fVar;
        if (!dQN()) {
            fVar = new f(5);
            AppMethodBeat.o(73078);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            fVar = new f(5);
            AppMethodBeat.o(73078);
            return fVar;
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                fVar = new f(5);
                AppMethodBeat.o(73078);
                return fVar;
            }
            try {
                if (this.Avz.Rh(Process.myUid()) == 0) {
                    fVar = new f(0);
                    AppMethodBeat.o(73078);
                    return fVar;
                }
            } catch (RemoteException e) {
            }
            fVar = new f(5);
            AppMethodBeat.o(73078);
            return fVar;
        }
    }

    public final boolean dQQ() {
        boolean z = false;
        AppMethodBeat.i(73079);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAppGlobalSecureKey in", new Object[z]);
        if (!dQN()) {
            AppMethodBeat.o(73079);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[z]);
            AppMethodBeat.o(73079);
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[z]);
                AppMethodBeat.o(73079);
            } else {
                try {
                    z = this.Avz.Rg(Process.myUid());
                    AppMethodBeat.o(73079);
                } catch (RemoteException e) {
                    AppMethodBeat.o(73079);
                }
            }
        }
        return z;
    }

    public final boolean dQR() {
        AppMethodBeat.i(73080);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAppGlobalSecureKeyValid in", new Object[0]);
        if (!dQQ() || dQS() == null) {
            AppMethodBeat.o(73080);
            return false;
        }
        AppMethodBeat.o(73080);
        return true;
    }

    public final i dQS() {
        i iVar = null;
        AppMethodBeat.i(73081);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAppGlobalSecureKeyModel in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.o(73081);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(73081);
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(73081);
            } else {
                try {
                    byte[] bArr = this.Avz.Rf(Process.myUid()).AvF;
                    if (bArr == null || bArr.length <= 0) {
                        com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(73081);
                    } else {
                        iVar = b.cp(bArr);
                        AppMethodBeat.o(73081);
                    }
                } catch (RemoteException e) {
                    AppMethodBeat.o(73081);
                }
            }
        }
        return iVar;
    }

    public final f atZ(String str) {
        AppMethodBeat.i(73082);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAuthKey in", new Object[0]);
        f fVar;
        if (!dQN()) {
            fVar = new f(5);
            AppMethodBeat.o(73082);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            fVar = new f(5);
            AppMethodBeat.o(73082);
            return fVar;
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                fVar = new f(5);
                AppMethodBeat.o(73082);
                return fVar;
            }
            try {
                if (this.Avz.bS(Process.myUid(), str) == 0) {
                    fVar = new f(0);
                    AppMethodBeat.o(73082);
                    return fVar;
                }
            } catch (RemoteException e) {
            }
            fVar = new f(5);
            AppMethodBeat.o(73082);
            return fVar;
        }
    }

    public final f cn(String str, boolean z) {
        AppMethodBeat.i(73083);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAuthKey in", new Object[0]);
        f fVar;
        if (!dQN()) {
            fVar = new f(6);
            AppMethodBeat.o(73083);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            fVar = new f(6);
            AppMethodBeat.o(73083);
            return fVar;
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                fVar = new f(6);
                AppMethodBeat.o(73083);
                return fVar;
            }
            int myUid = Process.myUid();
            try {
                if (this.Avz.bT(myUid, str) == 0) {
                    if (!z) {
                        fVar = new f(0);
                        AppMethodBeat.o(73083);
                        return fVar;
                    } else if (this.Avz.Rh(myUid) == 0) {
                        fVar = new f(0);
                        AppMethodBeat.o(73083);
                        return fVar;
                    } else {
                        fVar = new f(5);
                        AppMethodBeat.o(73083);
                        return fVar;
                    }
                }
            } catch (RemoteException e) {
            }
            fVar = new f(6);
            AppMethodBeat.o(73083);
            return fVar;
        }
    }

    public final boolean aub(String str) {
        AppMethodBeat.i(73084);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAuthKeyValid in", new Object[0]);
        if (!aua(str) || auc(str) == null) {
            AppMethodBeat.o(73084);
            return false;
        }
        AppMethodBeat.o(73084);
        return true;
    }

    public final i auc(String str) {
        i iVar = null;
        AppMethodBeat.i(73085);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAuthKeyModel in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.o(73085);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(73085);
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(73085);
            } else {
                try {
                    byte[] bArr = this.Avz.bU(Process.myUid(), str).AvF;
                    if (bArr == null || bArr.length <= 0) {
                        com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(73085);
                    } else {
                        iVar = b.cp(bArr);
                        AppMethodBeat.o(73085);
                    }
                } catch (RemoteException e) {
                    AppMethodBeat.o(73085);
                }
            }
        }
        return iVar;
    }

    public final Signature aud(String str) {
        return null;
    }

    public final boolean aua(String str) {
        boolean z = false;
        AppMethodBeat.i(73086);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAuthKey in", new Object[z]);
        int myUid = Process.myUid();
        if (!dQN()) {
            AppMethodBeat.o(73086);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[z]);
            AppMethodBeat.o(73086);
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[z]);
                AppMethodBeat.o(73086);
            } else {
                try {
                    z = this.Avz.bV(myUid, str);
                    AppMethodBeat.o(73086);
                } catch (RemoteException e) {
                    AppMethodBeat.o(73086);
                }
            }
        }
        return z;
    }

    public final SoterSessionResult iC(String str, String str2) {
        SoterSessionResult soterSessionResult = null;
        AppMethodBeat.i(73087);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSigh in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.o(73087);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(73087);
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(73087);
            } else {
                try {
                    soterSessionResult = this.Avz.O(Process.myUid(), str, str2);
                    AppMethodBeat.o(73087);
                } catch (RemoteException e) {
                    AppMethodBeat.o(73087);
                }
            }
        }
        return soterSessionResult;
    }

    public final byte[] nB(long j) {
        byte[] bArr = null;
        AppMethodBeat.i(73088);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: finishSign in", new Object[0]);
        if (!dQN()) {
            AppMethodBeat.o(73088);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(73088);
        } else {
            dRa();
            if (this.Avz == null) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(73088);
            } else {
                bArr = new byte[0];
                try {
                    SoterSignResult nD = this.Avz.nD(j);
                    bArr = nD.AvF;
                    if (nD.bFZ != 0) {
                        Exception exception = new Exception("finishSign error");
                        AppMethodBeat.o(73088);
                        throw exception;
                    }
                } catch (RemoteException e) {
                }
                AppMethodBeat.o(73088);
            }
        }
        return bArr;
    }
}
