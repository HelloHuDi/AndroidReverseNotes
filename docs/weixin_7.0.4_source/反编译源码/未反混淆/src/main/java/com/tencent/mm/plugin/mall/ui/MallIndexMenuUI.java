package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MallIndexMenuUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private int okT;
    private List<bjm> omK;
    private HashMap<String, bjl> omL = new HashMap();
    private boolean omM;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallIndexMenuUI() {
        AppMethodBeat.i(43171);
        AppMethodBeat.o(43171);
    }

    public final int JC() {
        return -1;
    }

    public void onDestroy() {
        AppMethodBeat.i(43173);
        super.onDestroy();
        g.Rg().b(1754, (f) this);
        AppMethodBeat.o(43173);
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0414 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43175);
        ab.i("MicroMsg.MallIndexMenuUI", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            int size;
            amf amf = ((com.tencent.mm.plugin.mall.a.g) mVar).okV;
            String str2 = "MicroMsg.MallIndexMenuUI";
            String str3 = "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s";
            Object[] objArr = new Object[3];
            objArr[0] = amf.title;
            objArr[1] = amf.wrk;
            if (amf.wrk != null) {
                size = amf.wrk.size();
            } else {
                size = 0;
            }
            objArr[2] = Integer.valueOf(size);
            ab.i(str2, str3, objArr);
            ab.i("MicroMsg.MallIndexMenuUI", "initPayMenuFromResponse: %s", amf);
            if (amf != null) {
                JSONObject jSONObject;
                Object obj;
                Iterator it;
                int i3;
                this.ehK.removeAll();
                if (!bo.isNullOrNil(amf.title)) {
                    setMMTitle(amf.title);
                }
                JSONObject jSONObject2 = new JSONObject();
                g.RQ();
                String str4 = (String) g.RP().Ry().get(a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, (Object) "");
                if (!bo.isNullOrNil(str4)) {
                    try {
                        jSONObject = new JSONObject(str4);
                    } catch (JSONException e) {
                    }
                    if (amf.wrk != null && amf.wrk.size() > 0) {
                        this.omK = amf.wrk;
                        obj = 1;
                        size = 0;
                        it = amf.wrk.iterator();
                        while (true) {
                            i3 = size;
                            if (!it.hasNext()) {
                                bjm bjm = (bjm) it.next();
                                if (bjm.wMT != null && bjm.wMT.size() > 0) {
                                    if (obj == null && bo.isNullOrNil(bjm.title)) {
                                        this.ehK.b(new PreferenceSmallCategory(this));
                                    }
                                    if (!bo.isNullOrNil(bjm.title)) {
                                        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                                        preferenceTitleCategory.setTitle((CharSequence) bjm.title);
                                        this.ehK.b(preferenceTitleCategory);
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Iterator it2 = bjm.wMT.iterator();
                                    while (it2.hasNext()) {
                                        Object obj2;
                                        bjl bjl = (bjl) it2.next();
                                        ab.i("MicroMsg.MallIndexMenuUI", "label name: %s", bjl.name);
                                        CdnImageIconPreference cdnImageIconPreference = new CdnImageIconPreference(this);
                                        if (!bo.isNullOrNil(bjl.title)) {
                                            cdnImageIconPreference.setTitle((CharSequence) bjl.title);
                                        }
                                        if (!bo.isNullOrNil(bjl.desc)) {
                                            cdnImageIconPreference.NM(0);
                                            cdnImageIconPreference.av(bjl.desc, -1, Color.parseColor("#999999"));
                                        }
                                        if (!bo.isNullOrNil(bjl.kbV)) {
                                            cdnImageIconPreference.iconUrl = bjl.kbV;
                                        }
                                        cdnImageIconPreference.setKey(bjl.name);
                                        long optLong = jSONObject.optLong(String.format("%s_expiretime", new Object[]{bjl.name}), 0);
                                        ab.i("MicroMsg.MallIndexMenuUI", "expireTime: %s", Long.valueOf(optLong));
                                        obj = jSONObject.optInt(bjl.name, 0) == 1 ? 1 : null;
                                        if (obj == null || optLong <= 0 || currentTimeMillis < optLong) {
                                            obj2 = obj;
                                        } else {
                                            ab.i("MicroMsg.MallIndexMenuUI", "reddot expire");
                                            obj2 = null;
                                            try {
                                                jSONObject.put(bjl.name, 0);
                                            } catch (Exception e2) {
                                                ab.printErrStackTrace("MicroMsg.MallIndexMenuUI", e2, "update expire reddot error: %s", e2.getMessage());
                                            }
                                        }
                                        if (obj2 != null) {
                                            if (bjl.wMS != null) {
                                                if ("1".equals(bjl.wMS.type)) {
                                                    cdnImageIconPreference.NM(0);
                                                    cdnImageIconPreference.qh(true);
                                                } else if ("2".equals(bjl.wMS.type)) {
                                                    cdnImageIconPreference.ey(getString(R.string.s0), R.drawable.w3);
                                                    cdnImageIconPreference.NL(0);
                                                } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bjl.wMS.type)) {
                                                    cdnImageIconPreference.ey(bjl.wMS.number, R.drawable.a4f);
                                                    cdnImageIconPreference.NL(0);
                                                }
                                                if (!bo.isNullOrNil(bjl.wMS.cEh)) {
                                                    ab.i("MicroMsg.MallIndexMenuUI", "show red dot wording: %s", bjl.wMS.cEh);
                                                    cdnImageIconPreference.av(bjl.wMS.cEh, -1, Color.parseColor("#999999"));
                                                    cdnImageIconPreference.NM(0);
                                                }
                                            } else {
                                                cdnImageIconPreference.NN(0);
                                            }
                                        }
                                        cdnImageIconPreference.NQ(8);
                                        if (bo.isNullOrNil(bjl.name)) {
                                            this.omL.put(i3 + bjl.name + bjl.ttd + bjl.title, bjl);
                                        } else {
                                            this.omL.put(bjl.name, bjl);
                                        }
                                        this.ehK.b(cdnImageIconPreference);
                                        int i4 = i3 + 1;
                                        h hVar;
                                        Object[] objArr2;
                                        h hVar2;
                                        Object[] objArr3;
                                        switch (bjl.ttd) {
                                            case 1:
                                                hVar = h.pYm;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(1);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = bjl.tte;
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.e(14872, objArr2);
                                                i3 = i4;
                                                break;
                                            case 2:
                                                hVar = h.pYm;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(2);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = "";
                                                objArr2[3] = bjl.tzW;
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.e(14872, objArr2);
                                                i3 = i4;
                                                break;
                                            case 3:
                                                hVar2 = h.pYm;
                                                objArr3 = new Object[5];
                                                objArr3[0] = Integer.valueOf(3);
                                                objArr3[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr3[2] = "";
                                                objArr3[3] = "";
                                                objArr3[4] = Integer.valueOf(1);
                                                hVar2.e(14872, objArr3);
                                                i3 = i4;
                                                break;
                                            case 4:
                                                hVar2 = h.pYm;
                                                objArr3 = new Object[5];
                                                objArr3[0] = Integer.valueOf(4);
                                                objArr3[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr3[2] = "";
                                                objArr3[3] = "";
                                                objArr3[4] = Integer.valueOf(1);
                                                hVar2.e(14872, objArr3);
                                                i3 = i4;
                                                break;
                                            case 5:
                                                hVar2 = h.pYm;
                                                objArr3 = new Object[5];
                                                objArr3[0] = Integer.valueOf(5);
                                                objArr3[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr3[2] = "";
                                                objArr3[3] = "";
                                                objArr3[4] = Integer.valueOf(1);
                                                hVar2.e(14872, objArr3);
                                                i3 = i4;
                                                break;
                                            case 8:
                                                hVar = h.pYm;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(8);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = bjl.tte;
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.e(14872, objArr2);
                                                break;
                                        }
                                        i3 = i4;
                                    }
                                    obj = null;
                                }
                                size = i3;
                            }
                        }
                    }
                    if (jSONObject.length() > 0) {
                        ab.i("MicroMsg.MallIndexMenuUI", "after initPayMenuFromResponse, redDotConfig: %s", jSONObject.toString());
                        g.RQ();
                        g.RP().Ry().set(a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                    }
                }
                jSONObject = jSONObject2;
                this.omK = amf.wrk;
                obj = 1;
                size = 0;
                it = amf.wrk.iterator();
                while (true) {
                    i3 = size;
                    if (!it.hasNext()) {
                    }
                    size = i3;
                }
            }
            AppMethodBeat.o(43175);
            return;
        }
        ab.e("MicroMsg.MallIndexMenuUI", "GetPayMenu error!");
        AppMethodBeat.o(43175);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(43176);
        if (i == 1) {
            g.RQ();
            this.okT = ((Integer) g.RP().Ry().get(a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
            if (i2 == -1) {
                if (r.YN()) {
                    finish();
                    AppMethodBeat.o(43176);
                    return;
                }
                finish();
                on onVar = new on();
                onVar.cKQ.context = this.mController.ylL;
                com.tencent.mm.sdk.b.a.xxA.m(onVar);
            }
        }
        AppMethodBeat.o(43176);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43172);
        this.yll = true;
        super.onCreate(bundle);
        xE(this.mController.dyj());
        this.omM = getIntent().getBooleanExtra("key_default_show_currency", false);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(43170);
                MallIndexMenuUI.this.finish();
                AppMethodBeat.o(43170);
                return true;
            }
        });
        this.ehK = this.yCw;
        setMMTitle((int) R.string.cwp);
        g.Rg().a(1754, (f) this);
        g.Rg().a(new com.tencent.mm.plugin.mall.a.g(), 0);
        AppMethodBeat.o(43172);
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x025b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(43174);
        String str = preference.mKey;
        ab.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", str);
        bjl bjl = (bjl) this.omL.get(str);
        Intent intent;
        bj bjVar;
        if (bjl != null) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            g.RQ();
            str = (String) g.RP().Ry().get(a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, (Object) "");
            if (!bo.isNullOrNil(str)) {
                boolean z;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MallIndexMenuUI", e, "parse redDotConfig json failed: %s", e.getMessage());
                }
                if (jSONObject.optInt(bjl.name, 0) != 1) {
                    jSONObject.remove(bjl.name);
                    jSONObject.remove(String.format("%s_expiretime", new Object[]{bjl.name}));
                    if (jSONObject.length() <= 0) {
                        g.RQ();
                        g.RP().Ry().set(a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, (Object) "");
                    } else {
                        g.RQ();
                        g.RP().Ry().set(a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                    }
                    if (preference instanceof IconPreference) {
                        ((IconPreference) preference).NN(8);
                        ((IconPreference) preference).NL(8);
                        ((IconPreference) preference).NM(8);
                        ((IconPreference) preference).qh(false);
                    }
                    z = true;
                } else {
                    z = false;
                }
                h hVar;
                Object[] objArr;
                switch (bjl.ttd) {
                    case 1:
                        ab.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", bjl.tte);
                        if (!bo.isNullOrNil(bjl.tte)) {
                            e.n(this, bjl.tte, false);
                        }
                        hVar = h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = bjl.tte;
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.e(14872, objArr);
                        break;
                    case 2:
                        ab.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", bjl.tzW, bjl.tzW);
                        if (!bo.isNullOrNil(bjl.tzW)) {
                            se seVar = new se();
                            seVar.cOf.userName = bjl.tzW;
                            seVar.cOf.cOh = bo.bc(bjl.ttg, "");
                            seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
                            seVar.cOf.cOi = 0;
                            com.tencent.mm.sdk.b.a.xxA.m(seVar);
                        }
                        hVar = h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = bjl.tzW;
                        objArr[4] = Integer.valueOf(0);
                        hVar.e(14872, objArr);
                        break;
                    case 3:
                        ab.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
                        d.H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                        hVar = h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(3);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.e(14872, objArr);
                        break;
                    case 4:
                        int i;
                        ab.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
                        intent = new Intent();
                        intent.putExtra("wallet_lock_jsapi_scene", 1);
                        d.b((Context) this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                        hVar = h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(4);
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.e(14872, objArr);
                        bjVar = new bj();
                        break;
                    case 5:
                        ab.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
                        d.c((Context) this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                        hVar = h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(5);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.e(14872, objArr);
                        break;
                    case 8:
                        ab.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
                        d.H(this, "honey_pay", ".ui.HoneyPayMainUI");
                        hVar = h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(8);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.e(14872, objArr);
                        break;
                }
                AppMethodBeat.o(43174);
                return true;
            }
            jSONObject = jSONObject2;
            if (jSONObject.optInt(bjl.name, 0) != 1) {
            }
            switch (bjl.ttd) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 8:
                    break;
            }
            AppMethodBeat.o(43174);
            return true;
        } else if ("pay_my_msg".equals(str)) {
            ab.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", Boolean.valueOf((com.tencent.mm.plugin.wallet_core.model.r.cPI().cQo().tCP & 65536) > 0), Integer.valueOf(com.tencent.mm.plugin.wallet_core.model.r.cPI().cQo().tCP));
            if ((com.tencent.mm.plugin.wallet_core.model.r.cPI().cQo().tCP & 65536) > 0) {
                intent = new Intent();
                intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
                d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                com.tencent.mm.wallet_core.a.b((Activity) this, "ShowOrdersInfoProcess", null);
            }
            e.QS(20);
            AppMethodBeat.o(43174);
            return true;
        } else if ("pay_manage".equals(str)) {
            if (r.YM()) {
                d.H(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
            } else {
                d.H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
            }
            e.QS(21);
            AppMethodBeat.o(43174);
            return true;
        } else {
            if ("pay_security".equals(str)) {
                d.H(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                e.QS(22);
                bjVar = new bj();
                bjVar.cVT = 11;
                bjVar.dcm = 1;
                bjVar.ajK();
            } else if ("pay_help_center".equals(str)) {
                String str2;
                Intent intent2 = new Intent();
                if (r.YM()) {
                    str2 = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";
                } else {
                    str2 = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1";
                }
                intent2.putExtra("rawUrl", str2);
                d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                e.QS(23);
                AppMethodBeat.o(43174);
                return true;
            } else if ("pay_wallet_switch".equals(str)) {
                d.c((Context) this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                AppMethodBeat.o(43174);
                return true;
            }
            AppMethodBeat.o(43174);
            return false;
        }
    }
}
