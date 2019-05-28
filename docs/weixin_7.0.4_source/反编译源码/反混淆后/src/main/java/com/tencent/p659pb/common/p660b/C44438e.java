package com.tencent.p659pb.common.p660b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.p659pb.common.p1102c.C44443c;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

/* renamed from: com.tencent.pb.common.b.e */
public final class C44438e implements C30912b {
    private static C44438e AlV = null;
    private final SparseArray<Set<C30912b>> AlW = new SparseArray();
    private C24239d AlX = null;
    private Vector<C24239d> ftC = new Vector();
    private Vector<C24239d> ftD = new Vector();
    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            C44438e.this.mo70368a((C24239d) message.obj);
        }
    };

    private C44438e() {
    }

    public static C44438e dPu() {
        if (AlV == null) {
            synchronized (C44438e.class) {
                if (AlV == null) {
                    AlV = new C44438e();
                }
            }
        }
        return AlV;
    }

    /* renamed from: a */
    public final void mo70367a(int i, C30912b c30912b) {
        if (this.AlW.get(i) == null) {
            this.AlW.put(i, new HashSet());
        }
        if (!((Set) this.AlW.get(i)).contains(c30912b)) {
            ((Set) this.AlW.get(i)).add(c30912b);
        }
    }

    /* renamed from: a */
    public final boolean mo70368a(C24239d c24239d) {
        if (!C44441h.isNetworkConnected()) {
            int type = c24239d.getType();
            if (type == 102 || type == 104 || type == 103) {
                C44443c.m80392w("MicroMsg.Voip", "doScene do retain mReissueNetScene");
                this.AlX = c24239d;
            }
        }
        Assert.assertTrue(true);
        if (c24239d == null) {
            return false;
        }
        m80373b(c24239d);
        return true;
    }

    /* renamed from: b */
    private void m80373b(final C24239d c24239d) {
        if (dPv()) {
            this.ftC.add(c24239d);
            if (c24239d.mo40008a(this) < 0) {
                C44443c.m80392w("MicroMsg.Voip", "doSceneImp do scene failed, ret %d,", Integer.valueOf(c24239d.mo40008a(this)));
                this.handler.post(new Runnable() {
                    public final void run() {
                        C44438e.this.ftC.remove(c24239d);
                        C44438e.this.mo41152a(2, -1, "doScene failed", c24239d);
                    }
                });
            }
        } else {
            this.ftD.add(c24239d);
        }
        acX();
    }

    /* renamed from: a */
    public final void mo41152a(int i, int i2, String str, C24239d c24239d) {
        this.ftC.remove(c24239d);
        acX();
        final C24239d c24239d2 = c24239d;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable() {
            public final void run() {
                Set set = (Set) C44438e.this.AlW.get(c24239d2.getType());
                if (set != null && set.size() > 0) {
                    HashSet<C30912b> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (C30912b c30912b : hashSet) {
                        if (c30912b != null && set.contains(c30912b)) {
                            c30912b.mo41152a(i3, i4, str2, c24239d2);
                        }
                    }
                }
            }
        });
    }

    private void acX() {
        if (this.ftD.size() > 0) {
            C24239d c24239d = (C24239d) this.ftD.get(0);
            for (int i = 1; i < this.ftD.size(); i++) {
                this.ftD.get(i);
            }
            if (dPv()) {
                this.ftD.remove(c24239d);
                m80373b(c24239d);
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
