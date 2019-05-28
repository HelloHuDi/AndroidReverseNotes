package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class ProductPurchaseAreaUI extends MMPreference {
    protected f iFE;
    private String kWz;
    private List<a> qcQ;
    private int qcR;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(81073);
        super.onCreate(bundle);
        initView();
        o.a cV = j.cV(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (cV == null || cV.qiL == null) {
            ab.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
            AppMethodBeat.o(81073);
            return;
        }
        this.kWz = cV.field_productid;
        this.qcR = cV.field_functionType;
        String stringExtra = getIntent().getStringExtra("referkey");
        ab.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(stringExtra)));
        if (!bo.isNullOrNil(stringExtra)) {
            for (int i2 = 0; i2 < cV.qiL.size(); i2++) {
                if (stringExtra.equals(((com.tencent.mm.plugin.scanner.a.a) cV.qiL.get(i2)).pZi)) {
                    this.qcQ = ((com.tencent.mm.plugin.scanner.a.a) cV.qiL.get(i2)).fPL;
                    setMMTitle(((com.tencent.mm.plugin.scanner.a.a) cV.qiL.get(i2)).title);
                    if (this.qcQ != null) {
                        while (i < this.qcQ.size()) {
                            a aVar = (a) this.qcQ.get(i);
                            String valueOf = String.valueOf(i);
                            if (aVar != null) {
                                a aVar2 = new a(this);
                                aVar2.setKey(valueOf);
                                aVar2.setTitle((CharSequence) aVar.name);
                                aVar2.setSummary((CharSequence) aVar.desc);
                                aVar2.qaJ = aVar.fjz;
                                this.iFE.b(aVar2);
                                if (i != this.qcQ.size() - 1) {
                                    this.iFE.b(new g(this.mController.ylL));
                                }
                            }
                            i++;
                        }
                        this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(81073);
                    return;
                }
            }
        }
        AppMethodBeat.o(81073);
    }

    public final void initView() {
        AppMethodBeat.i(81074);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(81072);
                ProductPurchaseAreaUI.this.finish();
                AppMethodBeat.o(81072);
                return false;
            }
        });
        this.iFE = this.yCw;
        AppMethodBeat.o(81074);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(81075);
        if (this.qcQ == null) {
            AppMethodBeat.o(81075);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            if (intValue < 0 || intValue >= this.qcQ.size()) {
                AppMethodBeat.o(81075);
                return false;
            }
            a aVar = (a) this.qcQ.get(intValue);
            if (aVar == null) {
                AppMethodBeat.o(81075);
                return false;
            }
            String str = null;
            switch (aVar.type) {
                case 1:
                    str = aVar.link;
                    if (!bo.isNullOrNil(aVar.link)) {
                        o(this.mController.ylL, aVar.link, this.qcR);
                        break;
                    }
                    ab.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
                    break;
                case 9:
                    str = aVar.pZp;
                    if (!bo.isNullOrNil(aVar.pZp)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", aVar.pZp);
                        intent.putExtra("key_product_scene", 12);
                        d.b((Context) this, "product", ".ui.MallProductUI", intent);
                        break;
                    }
                    break;
                default:
                    ab.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + aVar.link);
                    if (!bo.isNullOrNil(aVar.link)) {
                        o(this.mController.ylL, aVar.link, this.qcR);
                        break;
                    }
                    break;
            }
            g.Rg().a(new i(this.kWz, aVar.pZo, aVar.type, str, this.qcQ.size(), aVar.showType), 0);
            AppMethodBeat.o(81075);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", e, "", new Object[0]);
            AppMethodBeat.o(81075);
            return false;
        }
    }

    private static void o(Context context, String str, int i) {
        AppMethodBeat.i(81076);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", j.BT(i));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(81076);
    }

    public final int JC() {
        return R.xml.bb;
    }
}
