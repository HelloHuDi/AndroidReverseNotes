package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.scanner.p740a.C43482a;
import com.tencent.p177mm.plugin.scanner.p740a.C43482a.C34833a;
import com.tencent.p177mm.plugin.scanner.p740a.C43485i;
import com.tencent.p177mm.plugin.scanner.p740a.C43486j;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI */
public class ProductPurchaseAreaUI extends MMPreference {
    protected C15541f iFE;
    private String kWz;
    private List<C34833a> qcQ;
    private int qcR;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI$1 */
    class C396281 implements OnMenuItemClickListener {
        C396281() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81072);
            ProductPurchaseAreaUI.this.finish();
            AppMethodBeat.m2505o(81072);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(81073);
        super.onCreate(bundle);
        initView();
        C13185a cV = C43486j.m77691cV(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (cV == null || cV.qiL == null) {
            C4990ab.m7420w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
            AppMethodBeat.m2505o(81073);
            return;
        }
        this.kWz = cV.field_productid;
        this.qcR = cV.field_functionType;
        String stringExtra = getIntent().getStringExtra("referkey");
        C4990ab.m7416i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(stringExtra)));
        if (!C5046bo.isNullOrNil(stringExtra)) {
            for (int i2 = 0; i2 < cV.qiL.size(); i2++) {
                if (stringExtra.equals(((C43482a) cV.qiL.get(i2)).pZi)) {
                    this.qcQ = ((C43482a) cV.qiL.get(i2)).fPL;
                    setMMTitle(((C43482a) cV.qiL.get(i2)).title);
                    if (this.qcQ != null) {
                        while (i < this.qcQ.size()) {
                            C34833a c34833a = (C34833a) this.qcQ.get(i);
                            String valueOf = String.valueOf(i);
                            if (c34833a != null) {
                                C13150a c13150a = new C13150a(this);
                                c13150a.setKey(valueOf);
                                c13150a.setTitle((CharSequence) c34833a.name);
                                c13150a.setSummary((CharSequence) c34833a.desc);
                                c13150a.qaJ = c34833a.fjz;
                                this.iFE.mo27713b(c13150a);
                                if (i != this.qcQ.size() - 1) {
                                    this.iFE.mo27713b(new C3763g(this.mController.ylL));
                                }
                            }
                            i++;
                        }
                        this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(81073);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(81073);
    }

    public final void initView() {
        AppMethodBeat.m2504i(81074);
        setBackBtn(new C396281());
        this.iFE = this.yCw;
        AppMethodBeat.m2505o(81074);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(81075);
        if (this.qcQ == null) {
            AppMethodBeat.m2505o(81075);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            if (intValue < 0 || intValue >= this.qcQ.size()) {
                AppMethodBeat.m2505o(81075);
                return false;
            }
            C34833a c34833a = (C34833a) this.qcQ.get(intValue);
            if (c34833a == null) {
                AppMethodBeat.m2505o(81075);
                return false;
            }
            String str = null;
            switch (c34833a.type) {
                case 1:
                    str = c34833a.link;
                    if (!C5046bo.isNullOrNil(c34833a.link)) {
                        ProductPurchaseAreaUI.m81615o(this.mController.ylL, c34833a.link, this.qcR);
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
                    break;
                case 9:
                    str = c34833a.pZp;
                    if (!C5046bo.isNullOrNil(c34833a.pZp)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", c34833a.pZp);
                        intent.putExtra("key_product_scene", 12);
                        C25985d.m41467b((Context) this, "product", ".ui.MallProductUI", intent);
                        break;
                    }
                    break;
                default:
                    C4990ab.m7416i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + c34833a.link);
                    if (!C5046bo.isNullOrNil(c34833a.link)) {
                        ProductPurchaseAreaUI.m81615o(this.mController.ylL, c34833a.link, this.qcR);
                        break;
                    }
                    break;
            }
            C1720g.m3540Rg().mo14541a(new C43485i(this.kWz, c34833a.pZo, c34833a.type, str, this.qcQ.size(), c34833a.showType), 0);
            AppMethodBeat.m2505o(81075);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(81075);
            return false;
        }
    }

    /* renamed from: o */
    private static void m81615o(Context context, String str, int i) {
        AppMethodBeat.m2504i(81076);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", C43486j.m77689BT(i));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(81076);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8527bb;
    }
}
