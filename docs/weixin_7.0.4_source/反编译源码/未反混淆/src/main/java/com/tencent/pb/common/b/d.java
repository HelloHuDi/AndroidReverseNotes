package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.e;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.f;

public abstract class d implements c {
    public boolean AlL = false;
    b AlM = null;
    protected byte[] AlN = null;
    public Object AlO = null;
    protected int AlP;
    protected int AlQ = 2;
    protected int AlR = 0;
    protected final String TAG2 = getClass().getSimpleName();
    private final long ftT = 60000;
    private Runnable ftX = new Runnable() {
        public final void run() {
            d.this.jIN = true;
            c.d("MicroMsg.Voip", "NETTASK_RECV TimeOut cmd= ", d.this.dPt());
            f.C(20006, 3, "-1104");
            if (d.this.AlM != null) {
                d.this.AlM.a(2, -1, "time exceed, force to callback", d.this);
            }
        }
    };
    boolean jIN = false;
    private int mErrorCode = -999;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public abstract Object ch(byte[] bArr);

    public abstract String dPt();

    public abstract int getType();

    public final int a(b bVar) {
        if (this.AlN == null) {
            c.w("MicroMsg.Voip", this.TAG2, "dosene reqData is null cmd=" + this.AlP);
            return -1;
        }
        this.AlM = bVar;
        int a = f.dPx().a(null, new i(this), this.AlP, dPt(), this.AlN, this.AlR);
        if (a >= 0) {
            this.mHandler.postDelayed(this.ftX, 60000);
        }
        c.d("MicroMsg.Voip", "NETTASK_SEND dosene:cmd ", dPt(), Integer.valueOf(a));
        return a;
    }

    public final void r(final int i, byte[] bArr) {
        int i2 = 2;
        c.d("MicroMsg.Voip", this.TAG2, "onResp errcode", Integer.valueOf(i));
        this.mHandler.removeCallbacks(this.ftX);
        c.d("MicroMsg.Voip", "NETTASK_RECV onResp:cmd= ", dPt(), Integer.valueOf(i), Boolean.valueOf(this.jIN));
        if (i != 0) {
            c.w("MicroMsg.Voip", this.TAG2, "getNetworkErrType errcode:".concat(String.valueOf(i)));
            if (i != -1) {
                i2 = i == 6801 ? 10 : 4;
            } else if (h.isNetworkConnected()) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        if (this.jIN) {
            c.d("MicroMsg.Voip", "onResp netscene already canceled, cmd:" + this.AlP);
            return;
        }
        this.mErrorCode = i;
        this.AlO = ch(bArr);
        this.mHandler.post(new Runnable() {
            public final void run() {
                if (d.this.jIN) {
                    c.d("MicroMsg.Voip", d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.AlP);
                } else if (d.this.AlM != null) {
                    d.this.AlM.a(i2, i, "", d.this);
                }
            }
        });
    }

    public final void c(int i, e eVar) {
        this.AlP = i;
        byte[] bArr = null;
        try {
            bArr = e.b(eVar);
        } catch (Exception e) {
        }
        this.AlN = bArr;
    }
}
