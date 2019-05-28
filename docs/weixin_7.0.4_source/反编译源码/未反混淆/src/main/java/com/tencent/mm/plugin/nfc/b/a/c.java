package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c implements d {
    private NfcA oTs;

    public c(Tag tag) {
        AppMethodBeat.i(23044);
        this.oTs = NfcA.get(tag);
        AppMethodBeat.o(23044);
    }

    public final com.tencent.mm.plugin.nfc.a.c a(a aVar) {
        AppMethodBeat.i(23045);
        if (this.oTs == null) {
            ab.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            IllegalStateException illegalStateException = new IllegalStateException("NfcA is null");
            AppMethodBeat.o(23045);
            throw illegalStateException;
        }
        connect();
        com.tencent.mm.plugin.nfc.a.c cVar = null;
        while (true) {
            com.tencent.mm.plugin.nfc.a.c cVar2 = new com.tencent.mm.plugin.nfc.a.c(this.oTs.transceive(aVar.getBytes()));
            if (cVar2.oTb.length != 0) {
                if (cVar2.oTb.length - 2 >= 0) {
                    if (cVar2.bVw() != (short) 108) {
                        if (cVar == null) {
                            cVar = cVar2;
                        } else {
                            cVar.a(cVar2);
                        }
                        if (cVar2.bVw() == (short) 97) {
                            if (cVar2.bVx() == (short) 0) {
                                cVar.oTb[cVar.oTb.length - 1] = (byte) -112;
                                break;
                            }
                            aVar = new a((byte[]) b.oTj.clone());
                        } else {
                            break;
                        }
                    }
                    aVar.Ag(cVar2.bVx());
                } else {
                    cVar = cVar2;
                    break;
                }
            }
            break;
        }
        AppMethodBeat.o(23045);
        return cVar;
    }

    public final boolean connect() {
        AppMethodBeat.i(23046);
        if (!this.oTs.isConnected()) {
            this.oTs.connect();
        }
        AppMethodBeat.o(23046);
        return true;
    }

    public final void close() {
        AppMethodBeat.i(23047);
        if (this.oTs.isConnected()) {
            this.oTs.close();
        }
        AppMethodBeat.o(23047);
    }

    public final boolean isConnected() {
        AppMethodBeat.i(23048);
        boolean isConnected = this.oTs.isConnected();
        AppMethodBeat.o(23048);
        return isConnected;
    }

    public final boolean bVA() {
        AppMethodBeat.i(23049);
        close();
        connect();
        AppMethodBeat.o(23049);
        return true;
    }
}
