package com.tencent.mm.ai;

import com.tencent.mm.model.ax;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class n extends m implements k {
    protected int ftx = 3;
    private boolean fty = false;

    public abstract void a(int i, int i2, String str, q qVar);

    public abstract void acP();

    public abstract f acQ();

    public abstract lm c(q qVar);

    public abstract bdu d(q qVar);

    public abstract ato e(q qVar);

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 4 && i3 == -301) {
            ab.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", Integer.valueOf(this.ftx));
            if (qVar != null) {
                ab.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
                ax.a(true, c(qVar), d(qVar), e(qVar));
            }
            this.ftx--;
            if (this.ftx <= 0) {
                acP();
                this.fty = false;
                return;
            }
            ab.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
            a(this.ftf, acQ());
            return;
        }
        a(i2, i3, str, qVar);
    }
}
