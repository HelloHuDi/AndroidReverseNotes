package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r implements v {
    private int bbo;
    private final q bdl;
    private final l bdm = new l(32);
    private int bdn;
    private boolean bdo;
    private boolean bdp;

    public r(q qVar) {
        AppMethodBeat.i(95157);
        this.bdl = qVar;
        AppMethodBeat.o(95157);
    }

    public final void a(s sVar, g gVar, d dVar) {
        AppMethodBeat.i(95158);
        this.bdl.a(sVar, gVar, dVar);
        this.bdp = true;
        AppMethodBeat.o(95158);
    }

    public final void rn() {
        this.bdp = true;
    }

    public final void a(l lVar, boolean z) {
        int readUnsignedByte;
        AppMethodBeat.i(95159);
        if (z) {
            readUnsignedByte = lVar.readUnsignedByte() + lVar.position;
        } else {
            readUnsignedByte = -1;
        }
        if (this.bdp) {
            if (z) {
                this.bdp = false;
                lVar.setPosition(readUnsignedByte);
                this.bbo = 0;
            } else {
                AppMethodBeat.o(95159);
                return;
            }
        }
        while (lVar.tB() > 0) {
            if (this.bbo < 3) {
                if (this.bbo == 0) {
                    readUnsignedByte = lVar.readUnsignedByte();
                    lVar.setPosition(lVar.position - 1);
                    if (readUnsignedByte == 255) {
                        this.bdp = true;
                        AppMethodBeat.o(95159);
                        return;
                    }
                }
                readUnsignedByte = Math.min(lVar.tB(), 3 - this.bbo);
                lVar.readBytes(this.bdm.data, this.bbo, readUnsignedByte);
                this.bbo = readUnsignedByte + this.bbo;
                if (this.bbo == 3) {
                    this.bdm.reset(3);
                    this.bdm.eM(1);
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
                readUnsignedByte = Math.min(lVar.tB(), this.bdn - this.bbo);
                lVar.readBytes(this.bdm.data, this.bbo, readUnsignedByte);
                this.bbo = readUnsignedByte + this.bbo;
                if (this.bbo != this.bdn) {
                    continue;
                } else {
                    if (!this.bdo) {
                        this.bdm.reset(this.bdn);
                    } else if (v.m(this.bdm.data, this.bdn, -1) != 0) {
                        this.bdp = true;
                        AppMethodBeat.o(95159);
                        return;
                    } else {
                        this.bdm.reset(this.bdn - 4);
                    }
                    this.bdl.t(this.bdm);
                    this.bbo = 0;
                }
            }
        }
        AppMethodBeat.o(95159);
    }
}
