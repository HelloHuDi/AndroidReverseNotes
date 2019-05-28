package com.tencent.p177mm.plugin.backup.p345d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.plugin.backup.p919e.C11148b;
import com.tencent.p177mm.plugin.backup.p919e.C45744a;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.C30165k.C30166b;
import com.tencent.p177mm.protocal.protobuf.C23394gs;
import com.tencent.p177mm.protocal.protobuf.C30187gt;
import com.tencent.p177mm.protocal.protobuf.C7284ua;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.d.e */
public final class C2651e {
    C42758e jqR;
    LinkedList<C7284ua> jud;
    String jue;
    private String juf = "";
    private boolean jug = false;
    C2655a juh;
    private C7564ap jui = new C7564ap(Looper.getMainLooper(), new C26521(), true);
    final C1202f juj = new C26532();
    final C1202f juk = new C26543();

    /* renamed from: com.tencent.mm.plugin.backup.d.e$1 */
    class C26521 implements C5015a {
        C26521() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(17302);
            C2651e.this.aTr();
            AppMethodBeat.m2505o(17302);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.e$2 */
    class C26532 implements C1202f {
        C26532() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17303);
            C19978b.m30886b(704, C2651e.this.juj);
            C4990ab.m7417i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                C11148b c11148b = (C11148b) c1207m;
                C30187gt c30187gt = (C30187gt) c11148b.ehh.fsH.fsP;
                C41258b.aSZ().jqO = "";
                C41258b.aSZ().jqP = c30187gt.vIW;
                C41258b.aSZ().jqQ = c30187gt.vIX;
                C41258b.aSZ().jtg = c30187gt.vIS;
                c30187gt = (C30187gt) c11148b.ehh.fsH.fsP;
                byte[] bufferToBytes = c30187gt == null ? null : c30187gt.vIT == null ? null : c30187gt.vIT.getBufferToBytes();
                if (bufferToBytes != null) {
                    C2651e.this.jqR.jqW = 51;
                    C2651e.this.juh.mo6718k(51, bufferToBytes);
                }
                AppMethodBeat.m2505o(17303);
                return;
            }
            C4990ab.m7412e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(str)));
            C4990ab.m7417i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i2 == -100) {
                C9638aw.m17182Rg().mo14539a(1000, C2651e.this.juk);
                C9638aw.m17182Rg().mo14541a(new C45744a(C2651e.this.jud, C2651e.this.jue, C41258b.aSZ().jtg), 0);
                AppMethodBeat.m2505o(17303);
                return;
            }
            C2651e.this.jqR.jqW = -11;
            C2651e.this.juh.mo6718k(-11, null);
            AppMethodBeat.m2505o(17303);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.e$3 */
    class C26543 implements C1202f {
        C26543() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17304);
            C19978b.m30886b(1000, C2651e.this.juk);
            C4990ab.m7417i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                C23394gs c23394gs = ((C30166b) ((C45744a) c1207m).ftU.mo5618ZS()).vya;
                String str2 = "MicroMsg.BackupCreateQRCodeOfflineScene";
                String str3 = "onGYNetEnd QRCodeUrl:%s";
                Object[] objArr = new Object[1];
                objArr[0] = c23394gs == null ? BuildConfig.COMMAND : c23394gs.vIU;
                C4990ab.m7417i(str2, str3, objArr);
                byte[] bufferToBytes = c23394gs == null ? null : c23394gs.vIT == null ? null : c23394gs.vIT.getBufferToBytes();
                if (bufferToBytes != null) {
                    C2651e.this.jqR.jqW = 51;
                    C2651e.this.juh.mo6718k(51, bufferToBytes);
                }
                AppMethodBeat.m2505o(17304);
                return;
            }
            C4990ab.m7412e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(str)));
            C2651e.this.jqR.jqW = -11;
            C2651e.this.juh.mo6718k(-11, null);
            AppMethodBeat.m2505o(17304);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.e$a */
    public interface C2655a {
        /* renamed from: k */
        void mo6718k(int i, byte[] bArr);
    }

    public C2651e(C2655a c2655a, C42758e c42758e) {
        AppMethodBeat.m2504i(17305);
        this.juh = c2655a;
        this.jqR = c42758e;
        AppMethodBeat.m2505o(17305);
    }

    public final void start() {
        AppMethodBeat.m2504i(17306);
        C4990ab.m7417i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", Boolean.valueOf(this.jug), Boolean.valueOf(this.jui.doT()), this, C5046bo.dpG());
        if (this.jug) {
            AppMethodBeat.m2505o(17306);
            return;
        }
        this.jug = true;
        if (aTs()) {
            this.juf = null;
            aTr();
        } else {
            this.jqR.jqW = -4;
            this.juh.mo6718k(-4, null);
        }
        this.jui.mo16770ae(500, 500);
        AppMethodBeat.m2505o(17306);
    }

    public final void stop() {
        AppMethodBeat.m2504i(17307);
        C4990ab.m7416i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
        this.jug = false;
        C9638aw.m17182Rg().mo14546b(704, this.juj);
        C9638aw.m17182Rg().mo14546b(1000, this.juk);
        this.jui.stopTimer();
        AppMethodBeat.m2505o(17307);
    }

    /* Access modifiers changed, original: final */
    public final void aTr() {
        AppMethodBeat.m2504i(17308);
        String ds = C38635g.m65526ds(C4996ah.getContext());
        C4990ab.m7417i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", ds, this.juf, Boolean.valueOf(C9638aw.m17179RK()), Boolean.valueOf(C9638aw.m17178QT()));
        if (!ds.equals(this.juf)) {
            if (C9638aw.m17179RK()) {
                this.juf = ds;
                if (aTs()) {
                    this.jug = false;
                    if (C9638aw.m17178QT()) {
                        C4990ab.m7416i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
                        C9638aw.m17182Rg().mo14539a(1000, this.juk);
                        C9638aw.m17182Rg().mo14541a(new C45744a(this.jud, this.jue, C41258b.aSZ().jtg), 0);
                    } else {
                        C4990ab.m7416i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
                        C9638aw.m17182Rg().mo14539a(704, this.juj);
                        C9638aw.m17182Rg().mo14541a(new C11148b(this.jud, this.jue), 0);
                        AppMethodBeat.m2505o(17308);
                        return;
                    }
                }
                this.jug = false;
                AppMethodBeat.m2505o(17308);
                return;
            }
            AppMethodBeat.m2505o(17308);
            return;
        }
        AppMethodBeat.m2505o(17308);
    }

    private boolean aTs() {
        AppMethodBeat.m2504i(17309);
        this.jud = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        this.jue = C38635g.m65526ds(C4996ah.getContext());
        C4990ab.m7417i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", this.jue);
        if (C5046bo.isNullOrNil(this.jue)) {
            this.jqR.jqW = -4;
            this.juh.mo6718k(-4, null);
            this.juf = "";
            AppMethodBeat.m2505o(17309);
            return false;
        } else if (C41258b.aSZ().aTa().mo54233a(pString, pInt)) {
            C4990ab.m7417i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", pString.value, Integer.valueOf(pInt.value));
            C7284ua c7284ua = new C7284ua();
            c7284ua.vYA = pString.value;
            c7284ua.wbp = new LinkedList();
            c7284ua.wbp.add(Integer.valueOf(pInt.value));
            this.jud.add(c7284ua);
            AppMethodBeat.m2505o(17309);
            return true;
        } else {
            this.jqR.jqW = -4;
            this.juh.mo6718k(-4, null);
            this.juf = "";
            AppMethodBeat.m2505o(17309);
            return false;
        }
    }
}
