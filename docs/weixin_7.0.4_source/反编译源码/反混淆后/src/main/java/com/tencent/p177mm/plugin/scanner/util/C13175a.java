package com.tencent.p177mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.plugin.scanner.p504ui.ProductUI;
import com.tencent.p177mm.plugin.scanner.p740a.C43483g;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C39641c;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C43495b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35891h;
import com.tencent.p177mm.protocal.protobuf.C30199kx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.scanner.util.a */
public final class C13175a implements C1202f {
    public Bundle cvs;
    public Activity czX;
    public ProgressDialog ehJ;

    /* renamed from: com.tencent.mm.plugin.scanner.util.a$1 */
    public class C131761 implements OnCancelListener {
        final /* synthetic */ C43483g qfq;

        public C131761(C43483g c43483g) {
            this.qfq = c43483g;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(81367);
            C13175a.this.chO();
            C1720g.m3540Rg().mo14547c(this.qfq);
            AppMethodBeat.m2505o(81367);
        }
    }

    /* Access modifiers changed, original: final */
    public final void chO() {
        AppMethodBeat.m2504i(81368);
        C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, (C1202f) this);
        AppMethodBeat.m2505o(81368);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81369);
        C4990ab.m7417i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        chO();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -4) {
            C30379h.m48431a(this.czX, (int) C25738R.string.dgi, (int) C25738R.string.f9238tz, null);
            AppMethodBeat.m2505o(81369);
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (C1720g.m3540Rg().acT()) {
                    C1720g.m3540Rg().getNetworkServerIp();
                    new StringBuilder().append(i2);
                } else if (C32856ab.m53750ch(this.czX)) {
                    C35891h.m58839fR(this.czX);
                } else {
                    Toast.makeText(this.czX, this.czX.getString(C25738R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.czX, this.czX.getString(C25738R.string.bx9), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(81369);
        } else if (i == 4 && i2 == -2004) {
            C30379h.m48467g(this.czX, C25738R.string.dgb, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(81369);
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.czX, this.czX.getString(C25738R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(81369);
        } else if (c1207m.getType() == FilterEnum4Shaka.MIC_WEISHI_QINSHUI) {
            C30199kx cgG = ((C43483g) c1207m).cgG();
            if (cgG == null) {
                C4990ab.m7412e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                AppMethodBeat.m2505o(81369);
                return;
            }
            C4990ab.m7411d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", Integer.valueOf(cgG.jCt));
            if (C5046bo.isNullOrNil(cgG.vNK)) {
                AppMethodBeat.m2505o(81369);
                return;
            }
            int i3 = cgG.jCt;
            Activity activity = this.czX;
            String str2 = cgG.vNK;
            int i4 = ((C43483g) c1207m).cvn;
            int i5 = ((C43483g) c1207m).cvo;
            C46189e c46189e = new C46189e();
            Bundle bundle = this.cvs;
            int Wn = C43494o.m77710Wn(str2);
            C4990ab.m7411d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", Integer.valueOf(Wn));
            Intent intent;
            if (Wn == 1) {
                C39641c Wo = C43494o.m77711Wo(str2);
                if (Wo == null || C5046bo.isNullOrNil(Wo.username)) {
                    C4990ab.m7420w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                    obj = 2;
                } else {
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(Wo.username);
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        c46189e.mo74179a(activity, Wo.username, 2, i4, i5, null, bundle);
                        obj = 1;
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", aoO.field_username);
                        intent.setFlags(65536);
                        C28892c.gkE.mo38912c(intent, activity);
                        obj = null;
                    }
                }
            } else if (Wn == 2) {
                C43495b Wp = C43494o.m77712Wp(str2);
                if (Wp == null || C5046bo.isNullOrNil(Wp.link)) {
                    C4990ab.m7420w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                    obj = 2;
                } else {
                    C4990ab.m7411d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", Wp.link);
                    if (i3 == 5) {
                        ((C42687f) C1720g.m3528K(C42687f.class)).mo68090b(activity, Wp.link, 1031, bundle);
                        obj = null;
                    } else {
                        intent = new Intent();
                        intent.putExtra("rawUrl", Wp.link);
                        intent.setFlags(65536);
                        C28892c.gkE.mo38924i(intent, activity);
                        obj = null;
                    }
                }
            } else if (Wn == 3 || Wn == 4) {
                C4990ab.m7411d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", Integer.valueOf(4), Boolean.TRUE);
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
                C4990ab.m7420w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                C4990ab.m7419v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", str2);
                obj = 2;
            }
            switch (obj) {
                case null:
                    C4990ab.m7416i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                    AppMethodBeat.m2505o(81369);
                    return;
                case 1:
                    C4990ab.m7416i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                    AppMethodBeat.m2505o(81369);
                    return;
                case 2:
                    C4990ab.m7412e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                    break;
            }
            AppMethodBeat.m2505o(81369);
        } else {
            AppMethodBeat.m2505o(81369);
        }
    }
}
