package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.scanner.a.g;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.util.o.b;
import com.tencent.mm.plugin.scanner.util.o.c;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class a implements f {
    public Bundle cvs;
    public Activity czX;
    public ProgressDialog ehJ;

    /* renamed from: com.tencent.mm.plugin.scanner.util.a$1 */
    public class AnonymousClass1 implements OnCancelListener {
        final /* synthetic */ g qfq;

        public AnonymousClass1(g gVar) {
            this.qfq = gVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(81367);
            a.this.chO();
            com.tencent.mm.kernel.g.Rg().c(this.qfq);
            AppMethodBeat.o(81367);
        }
    }

    /* Access modifiers changed, original: final */
    public final void chO() {
        AppMethodBeat.i(81368);
        com.tencent.mm.kernel.g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, (f) this);
        AppMethodBeat.o(81368);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81369);
        ab.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        chO();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -4) {
            h.a(this.czX, (int) R.string.dgi, (int) R.string.tz, null);
            AppMethodBeat.o(81369);
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (com.tencent.mm.kernel.g.Rg().acT()) {
                    com.tencent.mm.kernel.g.Rg().getNetworkServerIp();
                    new StringBuilder().append(i2);
                } else if (com.tencent.mm.network.ab.ch(this.czX)) {
                    com.tencent.mm.pluginsdk.ui.tools.h.fR(this.czX);
                } else {
                    Toast.makeText(this.czX, this.czX.getString(R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.czX, this.czX.getString(R.string.bx9), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            AppMethodBeat.o(81369);
        } else if (i == 4 && i2 == -2004) {
            h.g(this.czX, R.string.dgb, R.string.tz);
            AppMethodBeat.o(81369);
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.czX, this.czX.getString(R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(81369);
        } else if (mVar.getType() == FilterEnum4Shaka.MIC_WEISHI_QINSHUI) {
            kx cgG = ((g) mVar).cgG();
            if (cgG == null) {
                ab.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                AppMethodBeat.o(81369);
                return;
            }
            ab.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", Integer.valueOf(cgG.jCt));
            if (bo.isNullOrNil(cgG.vNK)) {
                AppMethodBeat.o(81369);
                return;
            }
            int i3 = cgG.jCt;
            Activity activity = this.czX;
            String str2 = cgG.vNK;
            int i4 = ((g) mVar).cvn;
            int i5 = ((g) mVar).cvo;
            e eVar = new e();
            Bundle bundle = this.cvs;
            int Wn = o.Wn(str2);
            ab.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", Integer.valueOf(Wn));
            Intent intent;
            if (Wn == 1) {
                c Wo = o.Wo(str2);
                if (Wo == null || bo.isNullOrNil(Wo.username)) {
                    ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                    obj = 2;
                } else {
                    ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(Wo.username);
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        eVar.a(activity, Wo.username, 2, i4, i5, null, bundle);
                        obj = 1;
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", aoO.field_username);
                        intent.setFlags(65536);
                        com.tencent.mm.plugin.scanner.c.gkE.c(intent, activity);
                        obj = null;
                    }
                }
            } else if (Wn == 2) {
                b Wp = o.Wp(str2);
                if (Wp == null || bo.isNullOrNil(Wp.link)) {
                    ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                    obj = 2;
                } else {
                    ab.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", Wp.link);
                    if (i3 == 5) {
                        ((com.tencent.mm.plugin.appbrand.service.f) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.f.class)).b(activity, Wp.link, 1031, bundle);
                        obj = null;
                    } else {
                        intent = new Intent();
                        intent.putExtra("rawUrl", Wp.link);
                        intent.setFlags(65536);
                        com.tencent.mm.plugin.scanner.c.gkE.i(intent, activity);
                        obj = null;
                    }
                }
            } else if (Wn == 3 || Wn == 4) {
                ab.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", Integer.valueOf(4), Boolean.TRUE);
                intent = new Intent();
                intent.setClass(activity, ProductUI.class);
                intent.setFlags(65536);
                intent.putExtra("key_Product_xml", str2);
                intent.putExtra("key_Product_funcType", 4);
                intent.putExtra("key_ProductUI_addToDB", true);
                intent.putExtra("key_need_add_to_history", true);
                intent.putExtra("key_is_from_barcode", true);
                activity.startActivity(intent);
                obj = null;
            } else {
                ab.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                ab.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", str2);
                obj = 2;
            }
            switch (obj) {
                case null:
                    ab.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                    AppMethodBeat.o(81369);
                    return;
                case 1:
                    ab.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                    AppMethodBeat.o(81369);
                    return;
                case 2:
                    ab.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                    break;
            }
            AppMethodBeat.o(81369);
        } else {
            AppMethodBeat.o(81369);
        }
    }
}
