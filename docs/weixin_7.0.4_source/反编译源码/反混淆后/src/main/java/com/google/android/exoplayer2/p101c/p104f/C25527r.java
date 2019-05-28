package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.r */
public final class C25527r implements C37245v {
    private int bbo;
    private final C17642q bdl;
    private final C32065l bdm = new C32065l(32);
    private int bdn;
    private boolean bdo;
    private boolean bdp;

    public C25527r(C17642q c17642q) {
        AppMethodBeat.m2504i(95157);
        this.bdl = c17642q;
        AppMethodBeat.m2505o(95157);
    }

    /* renamed from: a */
    public final void mo42784a(C45042s c45042s, C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95158);
        this.bdl.mo32324a(c45042s, c8662g, c8661d);
        this.bdp = true;
        AppMethodBeat.m2505o(95158);
    }

    /* renamed from: rn */
    public final void mo42785rn() {
        this.bdp = true;
    }

    /* renamed from: a */
    public final void mo42783a(C32065l c32065l, boolean z) {
        int readUnsignedByte;
        AppMethodBeat.m2504i(95159);
        if (z) {
            readUnsignedByte = c32065l.readUnsignedByte() + c32065l.position;
        } else {
            readUnsignedByte = -1;
        }
        if (this.bdp) {
            if (z) {
                this.bdp = false;
                c32065l.setPosition(readUnsignedByte);
                this.bbo = 0;
            } else {
                AppMethodBeat.m2505o(95159);
                return;
            }
        }
        while (c32065l.mo52382tB() > 0) {
            if (this.bbo < 3) {
                if (this.bbo == 0) {
                    readUnsignedByte = c32065l.readUnsignedByte();
                    c32065l.setPosition(c32065l.position - 1);
                    if (readUnsignedByte == 255) {
                        this.bdp = true;
                        AppMethodBeat.m2505o(95159);
                        return;
                    }
                }
                readUnsignedByte = Math.min(c32065l.mo52382tB(), 3 - this.bbo);
                c32065l.readBytes(this.bdm.data, this.bbo, readUnsignedByte);
                this.bbo = readUnsignedByte + this.bbo;
                if (this.bbo == 3) {
                    this.bdm.reset(3);
                    this.bdm.mo52369eM(1);
                    int readUnsignedByte2 = this.bdm.readUnsignedByte();
                    int readUnsignedByte3 = this.bdm.readUnsignedByte();
                    this.bdo = (readUnsignedByte2 & 128) != 0;
                    this.bdn = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                    if (this.bdm.capacity() < this.bdn) {
                        byte[] bArr = this.bdm.data;
                        this.bdm.reset(Math.min(4098, Math.max(this.bdn, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.bdm.data, 0, 3);
                    }
                }
            } else {
                readUnsignedByte = Math.min(c32065l.mo52382tB(), this.bdn - this.bbo);
                c32065l.readBytes(this.bdm.data, this.bbo, readUnsignedByte);
                this.bbo = readUnsignedByte + this.bbo;
                if (this.bbo != this.bdn) {
                    continue;
                } else {
                    if (!this.bdo) {
                        this.bdm.reset(this.bdn);
                    } else if (C17675v.m27576m(this.bdm.data, this.bdn, -1) != 0) {
                        this.bdp = true;
                        AppMethodBeat.m2505o(95159);
                        return;
                    } else {
                        this.bdm.reset(this.bdn - 4);
                    }
                    this.bdl.mo32325t(this.bdm);
                    this.bbo = 0;
                }
            }
        }
        AppMethodBeat.m2505o(95159);
    }
}
