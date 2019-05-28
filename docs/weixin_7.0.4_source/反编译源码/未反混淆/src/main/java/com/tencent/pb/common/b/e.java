package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.pb.common.c.c;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class e implements b {
    private static e AlV = null;
    private final SparseArray<Set<b>> AlW = new SparseArray();
    private d AlX = null;
    private Vector<d> ftC = new Vector();
    private Vector<d> ftD = new Vector();
    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            e.this.a((d) message.obj);
        }
    };

    private e() {
    }

    public static e dPu() {
        if (AlV == null) {
            synchronized (e.class) {
                if (AlV == null) {
                    AlV = new e();
                }
            }
        }
        return AlV;
    }

    public final void a(int i, b bVar) {
        if (this.AlW.get(i) == null) {
            this.AlW.put(i, new HashSet());
        }
        if (!((Set) this.AlW.get(i)).contains(bVar)) {
            ((Set) this.AlW.get(i)).add(bVar);
        }
    }

    public final boolean a(d dVar) {
        if (!h.isNetworkConnected()) {
            int type = dVar.getType();
            if (type == 102 || type == 104 || type == 103) {
                c.w("MicroMsg.Voip", "doScene do retain mReissueNetScene");
                this.AlX = dVar;
            }
        }
        Assert.assertTrue(true);
        if (dVar == null) {
            return false;
        }
        b(dVar);
        return true;
    }

    private void b(final d dVar) {
        if (dPv()) {
            this.ftC.add(dVar);
            if (dVar.a(this) < 0) {
                c.w("MicroMsg.Voip", "doSceneImp do scene failed, ret %d,", Integer.valueOf(dVar.a(this)));
                this.handler.post(new Runnable() {
                    public final void run() {
                        e.this.ftC.remove(dVar);
                        e.this.a(2, -1, "doScene failed", dVar);
                    }
                });
            }
        } else {
            this.ftD.add(dVar);
        }
        acX();
    }

    public final void a(int i, int i2, String str, d dVar) {
        this.ftC.remove(dVar);
        acX();
        final d dVar2 = dVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable() {
            public final void run() {
                Set set = (Set) e.this.AlW.get(dVar2.getType());
                if (set != null && set.size() > 0) {
                    HashSet<b> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (b bVar : hashSet) {
                        if (bVar != null && set.contains(bVar)) {
                            bVar.a(i3, i4, str2, dVar2);
                        }
                    }
                }
            }
        });
    }

    private void acX() {
        if (this.ftD.size() > 0) {
            d dVar = (d) this.ftD.get(0);
            for (int i = 1; i < this.ftD.size(); i++) {
                this.ftD.get(i);
            }
            if (dPv()) {
                this.ftD.remove(dVar);
                b(dVar);
            }
        }
    }

    private boolean dPv() {
        if (this.ftC.size() >= 20) {
            return false;
        }
        return true;
    }
}
