package com.tencent.p177mm.plugin.nfc.p472b.p1003a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.nfc.p1002a.C12713b;
import com.tencent.p177mm.plugin.nfc.p1002a.C12714c;
import com.tencent.p177mm.plugin.nfc.p1002a.C34621a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.nfc.b.a.c */
public final class C34623c implements C12715d {
    private NfcA oTs;

    public C34623c(Tag tag) {
        AppMethodBeat.m2504i(23044);
        this.oTs = NfcA.get(tag);
        AppMethodBeat.m2505o(23044);
    }

    /* renamed from: a */
    public final C12714c mo24720a(C34621a c34621a) {
        AppMethodBeat.m2504i(23045);
        if (this.oTs == null) {
            C4990ab.m7412e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            IllegalStateException illegalStateException = new IllegalStateException("NfcA is null");
            AppMethodBeat.m2505o(23045);
            throw illegalStateException;
        }
        connect();
        C12714c c12714c = null;
        while (true) {
            C12714c c12714c2 = new C12714c(this.oTs.transceive(c34621a.getBytes()));
            if (c12714c2.oTb.length != 0) {
                if (c12714c2.oTb.length - 2 >= 0) {
                    if (c12714c2.bVw() != (short) 108) {
                        if (c12714c == null) {
                            c12714c = c12714c2;
                        } else {
                            c12714c.mo24713a(c12714c2);
                        }
                        if (c12714c2.bVw() == (short) 97) {
                            if (c12714c2.bVx() == (short) 0) {
                                c12714c.oTb[c12714c.oTb.length - 1] = (byte) -112;
                                break;
                            }
                            c34621a = new C34621a((byte[]) C12713b.oTj.clone());
                        } else {
                            break;
                        }
                    }
                    c34621a.mo55205Ag(c12714c2.bVx());
                } else {
                    c12714c = c12714c2;
                    break;
                }
            }
            break;
        }
        AppMethodBeat.m2505o(23045);
        return c12714c;
    }

    public final boolean connect() {
        AppMethodBeat.m2504i(23046);
        if (!this.oTs.isConnected()) {
            this.oTs.connect();
        }
        AppMethodBeat.m2505o(23046);
        return true;
    }

    public final void close() {
        AppMethodBeat.m2504i(23047);
        if (this.oTs.isConnected()) {
            this.oTs.close();
        }
        AppMethodBeat.m2505o(23047);
    }

    public final boolean isConnected() {
        AppMethodBeat.m2504i(23048);
        boolean isConnected = this.oTs.isConnected();
        AppMethodBeat.m2505o(23048);
        return isConnected;
    }

    public final boolean bVA() {
        AppMethodBeat.m2504i(23049);
        close();
        connect();
        AppMethodBeat.m2505o(23049);
        return true;
    }
}
