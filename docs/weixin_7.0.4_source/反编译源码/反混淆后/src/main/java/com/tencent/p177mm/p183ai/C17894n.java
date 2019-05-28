package com.tencent.p177mm.p183ai;

import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.protocal.protobuf.C7270lm;
import com.tencent.p177mm.protocal.protobuf.ato;
import com.tencent.p177mm.protocal.protobuf.bdu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ai.n */
public abstract class C17894n extends C1207m implements C1918k {
    protected int ftx = 3;
    private boolean fty = false;

    /* renamed from: a */
    public abstract void mo33414a(int i, int i2, String str, C1929q c1929q);

    public abstract void acP();

    public abstract C1202f acQ();

    /* renamed from: c */
    public abstract C7270lm mo33417c(C1929q c1929q);

    /* renamed from: d */
    public abstract bdu mo33418d(C1929q c1929q);

    /* renamed from: e */
    public abstract ato mo33419e(C1929q c1929q);

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        if (i2 == 4 && i3 == -301) {
            C4990ab.m7417i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", Integer.valueOf(this.ftx));
            if (c1929q != null) {
                C4990ab.m7416i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
                C7484ax.m12918a(true, mo33417c(c1929q), mo33418d(c1929q), mo33419e(c1929q));
            }
            this.ftx--;
            if (this.ftx <= 0) {
                acP();
                this.fty = false;
                return;
            }
            C4990ab.m7410d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
            mo4456a(this.ftf, acQ());
            return;
        }
        mo33414a(i2, i3, str, c1929q);
    }
}
