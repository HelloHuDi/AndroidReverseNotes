package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements d {
    private IsoDep oTr;

    public b(Tag tag) {
        AppMethodBeat.i(23038);
        if (tag == null) {
            ab.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            IllegalStateException illegalStateException = new IllegalStateException("tag is null");
            AppMethodBeat.o(23038);
            throw illegalStateException;
        }
        this.oTr = IsoDep.get(tag);
        AppMethodBeat.o(23038);
    }

    public final boolean connect() {
        AppMethodBeat.i(23039);
        if (!this.oTr.isConnected()) {
            this.oTr.connect();
        }
        AppMethodBeat.o(23039);
        return true;
    }

    public final void close() {
        AppMethodBeat.i(23040);
        if (this.oTr.isConnected()) {
            this.oTr.close();
        }
        AppMethodBeat.o(23040);
    }

    public final boolean isConnected() {
        AppMethodBeat.i(23041);
        boolean isConnected = this.oTr.isConnected();
        AppMethodBeat.o(23041);
        return isConnected;
    }

    public final boolean bVA() {
        AppMethodBeat.i(23042);
        close();
        connect();
        AppMethodBeat.o(23042);
        return true;
    }

    public final c a(a aVar) {
        AppMethodBeat.i(23043);
        if (this.oTr == null) {
            ab.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            IllegalStateException illegalStateException = new IllegalStateException("IsoDep is null");
            AppMethodBeat.o(23043);
            throw illegalStateException;
        }
        connect();
        c cVar = null;
        while (true) {
            c cVar2 = new c(this.oTr.transceive(aVar.getBytes()));
            if (cVar2.oTb.length != 0) {
                if (cVar2.oTb.length - 2 > 0) {
                    if (cVar2.bVw() != (short) 108) {
                        if (cVar == null) {
                            cVar = cVar2;
                        } else {
                            cVar.a(cVar2);
                        }
                        if (cVar2.bVw() != (short) 97) {
                            break;
                        }
                        aVar = new a((byte[]) com.tencent.mm.plugin.nfc.a.b.oTj.clone());
                    } else {
                        aVar.Ag(cVar2.bVx());
                    }
                } else {
                    cVar = cVar2;
                    break;
                }
            }
            break;
        }
        AppMethodBeat.o(23043);
        return cVar;
    }
}
