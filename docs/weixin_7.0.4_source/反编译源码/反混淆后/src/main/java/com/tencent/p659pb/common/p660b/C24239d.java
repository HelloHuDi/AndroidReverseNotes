package com.tencent.p659pb.common.p660b;

import android.os.Handler;
import android.os.Looper;
import com.google.p1368a.p1369a.C25510e;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46730f;

/* renamed from: com.tencent.pb.common.b.d */
public abstract class C24239d implements C30913c {
    public boolean AlL = false;
    C30912b AlM = null;
    protected byte[] AlN = null;
    public Object AlO = null;
    protected int AlP;
    protected int AlQ = 2;
    protected int AlR = 0;
    protected final String TAG2 = getClass().getSimpleName();
    private final long ftT = 60000;
    private Runnable ftX = new C242411();
    boolean jIN = false;
    private int mErrorCode = -999;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.pb.common.b.d$1 */
    class C242411 implements Runnable {
        C242411() {
        }

        public final void run() {
            C24239d.this.jIN = true;
            C44443c.m80389d("MicroMsg.Voip", "NETTASK_RECV TimeOut cmd= ", C24239d.this.dPt());
            C46730f.m88557C(20006, 3, "-1104");
            if (C24239d.this.AlM != null) {
                C24239d.this.AlM.mo41152a(2, -1, "time exceed, force to callback", C24239d.this);
            }
        }
    }

    /* renamed from: ch */
    public abstract Object mo30087ch(byte[] bArr);

    public abstract String dPt();

    public abstract int getType();

    /* renamed from: a */
    public final int mo40008a(C30912b c30912b) {
        if (this.AlN == null) {
            C44443c.m80392w("MicroMsg.Voip", this.TAG2, "dosene reqData is null cmd=" + this.AlP);
            return -1;
        }
        this.AlM = c30912b;
        int a = C44439f.dPx().mo70370a(null, new C44442i(this), this.AlP, dPt(), this.AlN, this.AlR);
        if (a >= 0) {
            this.mHandler.postDelayed(this.ftX, 60000);
        }
        C44443c.m80389d("MicroMsg.Voip", "NETTASK_SEND dosene:cmd ", dPt(), Integer.valueOf(a));
        return a;
    }

    /* renamed from: r */
    public final void mo40010r(final int i, byte[] bArr) {
        int i2 = 2;
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "onResp errcode", Integer.valueOf(i));
        this.mHandler.removeCallbacks(this.ftX);
        C44443c.m80389d("MicroMsg.Voip", "NETTASK_RECV onResp:cmd= ", dPt(), Integer.valueOf(i), Boolean.valueOf(this.jIN));
        if (i != 0) {
            C44443c.m80392w("MicroMsg.Voip", this.TAG2, "getNetworkErrType errcode:".concat(String.valueOf(i)));
            if (i != -1) {
                i2 = i == 6801 ? 10 : 4;
            } else if (C44441h.isNetworkConnected()) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        if (this.jIN) {
            C44443c.m80389d("MicroMsg.Voip", "onResp netscene already canceled, cmd:" + this.AlP);
            return;
        }
        this.mErrorCode = i;
        this.AlO = mo30087ch(bArr);
        this.mHandler.post(new Runnable() {
            public final void run() {
                if (C24239d.this.jIN) {
                    C44443c.m80389d("MicroMsg.Voip", C24239d.this.TAG2, "onResp netscene already canceled, cmd:" + C24239d.this.AlP);
                } else if (C24239d.this.AlM != null) {
                    C24239d.this.AlM.mo41152a(i2, i, "", C24239d.this);
                }
            }
        });
    }

    /* renamed from: c */
    public final void mo40009c(int i, C25510e c25510e) {
        this.AlP = i;
        byte[] bArr = null;
        try {
            bArr = C25510e.m40293b(c25510e);
        } catch (Exception e) {
        }
        this.AlN = bArr;
    }
}
