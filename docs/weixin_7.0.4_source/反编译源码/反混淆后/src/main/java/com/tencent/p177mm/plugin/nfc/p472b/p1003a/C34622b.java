package com.tencent.p177mm.plugin.nfc.p472b.p1003a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.nfc.p1002a.C12713b;
import com.tencent.p177mm.plugin.nfc.p1002a.C12714c;
import com.tencent.p177mm.plugin.nfc.p1002a.C34621a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.nfc.b.a.b */
public final class C34622b implements C12715d {
    private IsoDep oTr;

    public C34622b(Tag tag) {
        AppMethodBeat.m2504i(23038);
        if (tag == null) {
            C4990ab.m7412e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            IllegalStateException illegalStateException = new IllegalStateException("tag is null");
            AppMethodBeat.m2505o(23038);
            throw illegalStateException;
        }
        this.oTr = IsoDep.get(tag);
        AppMethodBeat.m2505o(23038);
    }

    public final boolean connect() {
        AppMethodBeat.m2504i(23039);
        if (!this.oTr.isConnected()) {
            this.oTr.connect();
        }
        AppMethodBeat.m2505o(23039);
        return true;
    }

    public final void close() {
        AppMethodBeat.m2504i(23040);
        if (this.oTr.isConnected()) {
            this.oTr.close();
        }
        AppMethodBeat.m2505o(23040);
    }

    public final boolean isConnected() {
        AppMethodBeat.m2504i(23041);
        boolean isConnected = this.oTr.isConnected();
        AppMethodBeat.m2505o(23041);
        return isConnected;
    }

    public final boolean bVA() {
        AppMethodBeat.m2504i(23042);
        close();
        connect();
        AppMethodBeat.m2505o(23042);
        return true;
    }

    /* renamed from: a */
    public final C12714c mo24720a(C34621a c34621a) {
        AppMethodBeat.m2504i(23043);
        if (this.oTr == null) {
            C4990ab.m7412e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            IllegalStateException illegalStateException = new IllegalStateException("IsoDep is null");
            AppMethodBeat.m2505o(23043);
            throw illegalStateException;
        }
        connect();
        C12714c c12714c = null;
        while (true) {
            C12714c c12714c2 = new C12714c(this.oTr.transceive(c34621a.getBytes()));
            if (c12714c2.oTb.length != 0) {
                if (c12714c2.oTb.length - 2 > 0) {
                    if (c12714c2.bVw() != (short) 108) {
                        if (c12714c == null) {
                            c12714c = c12714c2;
                        } else {
                            c12714c.mo24713a(c12714c2);
                        }
                        if (c12714c2.bVw() != (short) 97) {
                            break;
                        }
                        c34621a = new C34621a((byte[]) C12713b.oTj.clone());
                    } else {
                        c34621a.mo55205Ag(c12714c2.bVx());
                    }
                } else {
                    c12714c = c12714c2;
                    break;
                }
            }
            break;
        }
        AppMethodBeat.m2505o(23043);
        return c12714c;
    }
}
