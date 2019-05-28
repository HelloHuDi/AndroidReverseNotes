package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class e {
    com.tencent.mm.plugin.backup.b.e jqR;
    LinkedList<ua> jud;
    String jue;
    private String juf = "";
    private boolean jug = false;
    a juh;
    private ap jui = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(17302);
            e.this.aTr();
            AppMethodBeat.o(17302);
            return true;
        }
    }, true);
    final f juj = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17303);
            b.b(704, e.this.juj);
            ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.backup.e.b bVar = (com.tencent.mm.plugin.backup.e.b) mVar;
                gt gtVar = (gt) bVar.ehh.fsH.fsP;
                b.aSZ().jqO = "";
                b.aSZ().jqP = gtVar.vIW;
                b.aSZ().jqQ = gtVar.vIX;
                b.aSZ().jtg = gtVar.vIS;
                gtVar = (gt) bVar.ehh.fsH.fsP;
                byte[] bufferToBytes = gtVar == null ? null : gtVar.vIT == null ? null : gtVar.vIT.getBufferToBytes();
                if (bufferToBytes != null) {
                    e.this.jqR.jqW = 51;
                    e.this.juh.k(51, bufferToBytes);
                }
                AppMethodBeat.o(17303);
                return;
            }
            ab.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(str)));
            ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i2 == -100) {
                aw.Rg().a(1000, e.this.juk);
                aw.Rg().a(new com.tencent.mm.plugin.backup.e.a(e.this.jud, e.this.jue, b.aSZ().jtg), 0);
                AppMethodBeat.o(17303);
                return;
            }
            e.this.jqR.jqW = -11;
            e.this.juh.k(-11, null);
            AppMethodBeat.o(17303);
        }
    };
    final f juk = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17304);
            b.b(1000, e.this.juk);
            ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                gs gsVar = ((k.b) ((com.tencent.mm.plugin.backup.e.a) mVar).ftU.ZS()).vya;
                String str2 = "MicroMsg.BackupCreateQRCodeOfflineScene";
                String str3 = "onGYNetEnd QRCodeUrl:%s";
                Object[] objArr = new Object[1];
                objArr[0] = gsVar == null ? BuildConfig.COMMAND : gsVar.vIU;
                ab.i(str2, str3, objArr);
                byte[] bufferToBytes = gsVar == null ? null : gsVar.vIT == null ? null : gsVar.vIT.getBufferToBytes();
                if (bufferToBytes != null) {
                    e.this.jqR.jqW = 51;
                    e.this.juh.k(51, bufferToBytes);
                }
                AppMethodBeat.o(17304);
                return;
            }
            ab.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(str)));
            e.this.jqR.jqW = -11;
            e.this.juh.k(-11, null);
            AppMethodBeat.o(17304);
        }
    };

    public interface a {
        void k(int i, byte[] bArr);
    }

    public e(a aVar, com.tencent.mm.plugin.backup.b.e eVar) {
        AppMethodBeat.i(17305);
        this.juh = aVar;
        this.jqR = eVar;
        AppMethodBeat.o(17305);
    }

    public final void start() {
        AppMethodBeat.i(17306);
        ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", Boolean.valueOf(this.jug), Boolean.valueOf(this.jui.doT()), this, bo.dpG());
        if (this.jug) {
            AppMethodBeat.o(17306);
            return;
        }
        this.jug = true;
        if (aTs()) {
            this.juf = null;
            aTr();
        } else {
            this.jqR.jqW = -4;
            this.juh.k(-4, null);
        }
        this.jui.ae(500, 500);
        AppMethodBeat.o(17306);
    }

    public final void stop() {
        AppMethodBeat.i(17307);
        ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
        this.jug = false;
        aw.Rg().b(704, this.juj);
        aw.Rg().b(1000, this.juk);
        this.jui.stopTimer();
        AppMethodBeat.o(17307);
    }

    /* Access modifiers changed, original: final */
    public final void aTr() {
        AppMethodBeat.i(17308);
        String ds = g.ds(ah.getContext());
        ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", ds, this.juf, Boolean.valueOf(aw.RK()), Boolean.valueOf(aw.QT()));
        if (!ds.equals(this.juf)) {
            if (aw.RK()) {
                this.juf = ds;
                if (aTs()) {
                    this.jug = false;
                    if (aw.QT()) {
                        ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
                        aw.Rg().a(1000, this.juk);
                        aw.Rg().a(new com.tencent.mm.plugin.backup.e.a(this.jud, this.jue, b.aSZ().jtg), 0);
                    } else {
                        ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
                        aw.Rg().a(704, this.juj);
                        aw.Rg().a(new com.tencent.mm.plugin.backup.e.b(this.jud, this.jue), 0);
                        AppMethodBeat.o(17308);
                        return;
                    }
                }
                this.jug = false;
                AppMethodBeat.o(17308);
                return;
            }
            AppMethodBeat.o(17308);
            return;
        }
        AppMethodBeat.o(17308);
    }

    private boolean aTs() {
        AppMethodBeat.i(17309);
        this.jud = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        this.jue = g.ds(ah.getContext());
        ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", this.jue);
        if (bo.isNullOrNil(this.jue)) {
            this.jqR.jqW = -4;
            this.juh.k(-4, null);
            this.juf = "";
            AppMethodBeat.o(17309);
            return false;
        } else if (b.aSZ().aTa().a(pString, pInt)) {
            ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", pString.value, Integer.valueOf(pInt.value));
            ua uaVar = new ua();
            uaVar.vYA = pString.value;
            uaVar.wbp = new LinkedList();
            uaVar.wbp.add(Integer.valueOf(pInt.value));
            this.jud.add(uaVar);
            AppMethodBeat.o(17309);
            return true;
        } else {
            this.jqR.jqW = -4;
            this.juh.k(-4, null);
            this.juf = "";
            AppMethodBeat.o(17309);
            return false;
        }
    }
}
