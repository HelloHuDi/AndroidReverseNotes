package com.google.a.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.view.d;

public final class a {
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

    public final int vc() {
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
        this.bxn = vd();
        if (this.bxn != 0) {
            return this.bxn;
        }
        throw d.vl();
    }

    public final void fm(int i) {
        if (this.bxn != i) {
            throw d.vm();
        }
    }

    public final boolean fn(int i) {
        switch (g.fy(i)) {
            case 0:
                vd();
                return true;
            case 1:
                vh();
                vh();
                vh();
                vh();
                vh();
                vh();
                vh();
                vh();
                return true;
            case 2:
                fs(vd());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                vh();
                vh();
                vh();
                vh();
                return true;
            default:
                throw d.vn();
        }
        int vc;
        do {
            vc = vc();
            if (vc != 0) {
            }
            fm(g.bv(g.fz(i), 4));
            return true;
        } while (fn(vc));
        fm(g.bv(g.fz(i), 4));
        return true;
    }

    public final String readString() {
        int vd = vd();
        if (vd > this.bufferSize - this.bxm || vd <= 0) {
            return new String(fr(vd), "UTF-8");
        }
        String str = new String(this.buffer, this.bxm, vd, "UTF-8");
        this.bxm = vd + this.bxm;
        return str;
    }

    public final void a(e eVar) {
        int vd = vd();
        if (this.bxp >= this.bxq) {
            throw d.vo();
        }
        vd = fo(vd);
        this.bxp++;
        eVar.a(this);
        fm(0);
        this.bxp--;
        fp(vd);
    }

    public final byte[] readBytes() {
        int vd = vd();
        if (vd > this.bufferSize - this.bxm || vd <= 0) {
            return fr(vd);
        }
        byte[] bArr = new byte[vd];
        System.arraycopy(this.buffer, this.bxm, bArr, 0, vd);
        this.bxm = vd + this.bxm;
        return bArr;
    }

    public final int vd() {
        byte vh = vh();
        if (vh >= (byte) 0) {
            return vh;
        }
        int i = vh & d.MIC_SketchMark;
        byte vh2 = vh();
        if (vh2 >= (byte) 0) {
            return i | (vh2 << 7);
        }
        i |= (vh2 & d.MIC_SketchMark) << 7;
        vh2 = vh();
        if (vh2 >= (byte) 0) {
            return i | (vh2 << 14);
        }
        i |= (vh2 & d.MIC_SketchMark) << 14;
        vh2 = vh();
        if (vh2 >= (byte) 0) {
            return i | (vh2 << 21);
        }
        i |= (vh2 & d.MIC_SketchMark) << 21;
        vh2 = vh();
        i |= vh2 << 28;
        if (vh2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (vh() >= (byte) 0) {
                return i;
            }
        }
        throw d.vk();
    }

    public final long ve() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte vh = vh();
            j |= ((long) (vh & d.MIC_SketchMark)) << i;
            if ((vh & 128) == 0) {
                return j;
            }
        }
        throw d.vk();
    }

    a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.bxk = 0;
        this.bufferSize = i + 0;
        this.bxm = 0;
    }

    public final int fo(int i) {
        if (i < 0) {
            throw d.vj();
        }
        int i2 = this.bxm + i;
        int i3 = this.bxo;
        if (i2 > i3) {
            throw d.vi();
        }
        this.bxo = i2;
        vf();
        return i3;
    }

    private void vf() {
        this.bufferSize += this.bxl;
        int i = this.bufferSize;
        if (i > this.bxo) {
            this.bxl = i - this.bxo;
            this.bufferSize -= this.bxl;
            return;
        }
        this.bxl = 0;
    }

    public final void fp(int i) {
        this.bxo = i;
        vf();
    }

    public final int vg() {
        if (this.bxo == BaseClientBuilder.API_PRIORITY_OTHER) {
            return -1;
        }
        return this.bxo - this.bxm;
    }

    public final int getPosition() {
        return this.bxm - this.bxk;
    }

    public final void fq(int i) {
        if (i > this.bxm - this.bxk) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bxm - this.bxk));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position ".concat(String.valueOf(i)));
        } else {
            this.bxm = this.bxk + i;
        }
    }

    private byte vh() {
        if (this.bxm == this.bufferSize) {
            throw d.vi();
        }
        byte[] bArr = this.buffer;
        int i = this.bxm;
        this.bxm = i + 1;
        return bArr[i];
    }

    private byte[] fr(int i) {
        if (i < 0) {
            throw d.vj();
        } else if (this.bxm + i > this.bxo) {
            fs(this.bxo - this.bxm);
            throw d.vi();
        } else if (i <= this.bufferSize - this.bxm) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.bxm, bArr, 0, i);
            this.bxm += i;
            return bArr;
        } else {
            throw d.vi();
        }
    }

    private void fs(int i) {
        if (i < 0) {
            throw d.vj();
        } else if (this.bxm + i > this.bxo) {
            fs(this.bxo - this.bxm);
            throw d.vi();
        } else if (i <= this.bufferSize - this.bxm) {
            this.bxm += i;
        } else {
            throw d.vi();
        }
    }
}
