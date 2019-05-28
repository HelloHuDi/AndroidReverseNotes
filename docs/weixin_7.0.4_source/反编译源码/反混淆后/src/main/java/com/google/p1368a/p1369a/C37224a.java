package com.google.p1368a.p1369a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.view.C31128d;

/* renamed from: com.google.a.a.a */
public final class C37224a {
    private final byte[] buffer;
    private int bufferSize;
    private int bxk;
    private int bxl;
    private int bxm;
    private int bxn;
    private int bxo = BaseClientBuilder.API_PRIORITY_OTHER;
    private int bxp;
    private int bxq = 64;
    private int bxr = 67108864;

    /* renamed from: vc */
    public final int mo59453vc() {
        int i;
        if (this.bxm == this.bufferSize) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            this.bxn = 0;
            return 0;
        }
        this.bxn = mo59454vd();
        if (this.bxn != 0) {
            return this.bxn;
        }
        throw C25509d.m40288vl();
    }

    /* renamed from: fm */
    public final void mo59445fm(int i) {
        if (this.bxn != i) {
            throw C25509d.m40289vm();
        }
    }

    /* renamed from: fn */
    public final boolean mo59446fn(int i) {
        switch (C45015g.m82451fy(i)) {
            case 0:
                mo59454vd();
                return true;
            case 1:
                m62378vh();
                m62378vh();
                m62378vh();
                m62378vh();
                m62378vh();
                m62378vh();
                m62378vh();
                m62378vh();
                return true;
            case 2:
                m62376fs(mo59454vd());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m62378vh();
                m62378vh();
                m62378vh();
                m62378vh();
                return true;
            default:
                throw C25509d.m40290vn();
        }
        int vc;
        do {
            vc = mo59453vc();
            if (vc != 0) {
            }
            mo59445fm(C45015g.m82450bv(C45015g.m82452fz(i), 4));
            return true;
        } while (mo59446fn(vc));
        mo59445fm(C45015g.m82450bv(C45015g.m82452fz(i), 4));
        return true;
    }

    public final String readString() {
        int vd = mo59454vd();
        if (vd > this.bufferSize - this.bxm || vd <= 0) {
            return new String(m62375fr(vd), "UTF-8");
        }
        String str = new String(this.buffer, this.bxm, vd, "UTF-8");
        this.bxm = vd + this.bxm;
        return str;
    }

    /* renamed from: a */
    public final void mo59444a(C25510e c25510e) {
        int vd = mo59454vd();
        if (this.bxp >= this.bxq) {
            throw C25509d.m40291vo();
        }
        vd = mo59447fo(vd);
        this.bxp++;
        c25510e.mo11877a(this);
        mo59445fm(0);
        this.bxp--;
        mo59448fp(vd);
    }

    public final byte[] readBytes() {
        int vd = mo59454vd();
        if (vd > this.bufferSize - this.bxm || vd <= 0) {
            return m62375fr(vd);
        }
        byte[] bArr = new byte[vd];
        System.arraycopy(this.buffer, this.bxm, bArr, 0, vd);
        this.bxm = vd + this.bxm;
        return bArr;
    }

    /* renamed from: vd */
    public final int mo59454vd() {
        byte vh = m62378vh();
        if (vh >= (byte) 0) {
            return vh;
        }
        int i = vh & C31128d.MIC_SketchMark;
        byte vh2 = m62378vh();
        if (vh2 >= (byte) 0) {
            return i | (vh2 << 7);
        }
        i |= (vh2 & C31128d.MIC_SketchMark) << 7;
        vh2 = m62378vh();
        if (vh2 >= (byte) 0) {
            return i | (vh2 << 14);
        }
        i |= (vh2 & C31128d.MIC_SketchMark) << 14;
        vh2 = m62378vh();
        if (vh2 >= (byte) 0) {
            return i | (vh2 << 21);
        }
        i |= (vh2 & C31128d.MIC_SketchMark) << 21;
        vh2 = m62378vh();
        i |= vh2 << 28;
        if (vh2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m62378vh() >= (byte) 0) {
                return i;
            }
        }
        throw C25509d.m40287vk();
    }

    /* renamed from: ve */
    public final long mo59455ve() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte vh = m62378vh();
            j |= ((long) (vh & C31128d.MIC_SketchMark)) << i;
            if ((vh & 128) == 0) {
                return j;
            }
        }
        throw C25509d.m40287vk();
    }

    C37224a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.bxk = 0;
        this.bufferSize = i + 0;
        this.bxm = 0;
    }

    /* renamed from: fo */
    public final int mo59447fo(int i) {
        if (i < 0) {
            throw C25509d.m40286vj();
        }
        int i2 = this.bxm + i;
        int i3 = this.bxo;
        if (i2 > i3) {
            throw C25509d.m40285vi();
        }
        this.bxo = i2;
        m62377vf();
        return i3;
    }

    /* renamed from: vf */
    private void m62377vf() {
        this.bufferSize += this.bxl;
        int i = this.bufferSize;
        if (i > this.bxo) {
            this.bxl = i - this.bxo;
            this.bufferSize -= this.bxl;
            return;
        }
        this.bxl = 0;
    }

    /* renamed from: fp */
    public final void mo59448fp(int i) {
        this.bxo = i;
        m62377vf();
    }

    /* renamed from: vg */
    public final int mo59456vg() {
        if (this.bxo == BaseClientBuilder.API_PRIORITY_OTHER) {
            return -1;
        }
        return this.bxo - this.bxm;
    }

    public final int getPosition() {
        return this.bxm - this.bxk;
    }

    /* renamed from: fq */
    public final void mo59449fq(int i) {
        if (i > this.bxm - this.bxk) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bxm - this.bxk));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position ".concat(String.valueOf(i)));
        } else {
            this.bxm = this.bxk + i;
        }
    }

    /* renamed from: vh */
    private byte m62378vh() {
        if (this.bxm == this.bufferSize) {
            throw C25509d.m40285vi();
        }
        byte[] bArr = this.buffer;
        int i = this.bxm;
        this.bxm = i + 1;
        return bArr[i];
    }

    /* renamed from: fr */
    private byte[] m62375fr(int i) {
        if (i < 0) {
            throw C25509d.m40286vj();
        } else if (this.bxm + i > this.bxo) {
            m62376fs(this.bxo - this.bxm);
            throw C25509d.m40285vi();
        } else if (i <= this.bufferSize - this.bxm) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.bxm, bArr, 0, i);
            this.bxm += i;
            return bArr;
        } else {
            throw C25509d.m40285vi();
        }
    }

    /* renamed from: fs */
    private void m62376fs(int i) {
        if (i < 0) {
            throw C25509d.m40286vj();
        } else if (this.bxm + i > this.bxo) {
            m62376fs(this.bxo - this.bxm);
            throw C25509d.m40285vi();
        } else if (i <= this.bufferSize - this.bxm) {
            this.bxm += i;
        } else {
            throw C25509d.m40285vi();
        }
    }
}
