package com.tencent.p177mm.plugin.mall.p451ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C6533on;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.mall.p450a.C34507g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.protocal.protobuf.amf;
import com.tencent.p177mm.protocal.protobuf.bjl;
import com.tencent.p177mm.protocal.protobuf.bjm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexMenuUI */
public class MallIndexMenuUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private int okT;
    private List<bjm> omK;
    private HashMap<String, bjl> omL = new HashMap();
    private boolean omM;

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexMenuUI$1 */
    class C212651 implements OnMenuItemClickListener {
        C212651() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(43170);
            MallIndexMenuUI.this.finish();
            AppMethodBeat.m2505o(43170);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MallIndexMenuUI() {
        AppMethodBeat.m2504i(43171);
        AppMethodBeat.m2505o(43171);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43173);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(1754, (C1202f) this);
        AppMethodBeat.m2505o(43173);
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0414 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43175);
        C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            int size;
            amf amf = ((C34507g) c1207m).okV;
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
            C4990ab.m7417i(str2, str3, objArr);
            C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "initPayMenuFromResponse: %s", amf);
            if (amf != null) {
                JSONObject jSONObject;
                Object obj;
                Iterator it;
                int i3;
                this.ehK.removeAll();
                if (!C5046bo.isNullOrNil(amf.title)) {
                    setMMTitle(amf.title);
                }
                JSONObject jSONObject2 = new JSONObject();
                C1720g.m3537RQ();
                String str4 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, (Object) "");
                if (!C5046bo.isNullOrNil(str4)) {
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
                                    if (obj == null && C5046bo.isNullOrNil(bjm.title)) {
                                        this.ehK.mo27713b(new PreferenceSmallCategory(this));
                                    }
                                    if (!C5046bo.isNullOrNil(bjm.title)) {
                                        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                                        preferenceTitleCategory.setTitle((CharSequence) bjm.title);
                                        this.ehK.mo27713b(preferenceTitleCategory);
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Iterator it2 = bjm.wMT.iterator();
                                    while (it2.hasNext()) {
                                        Object obj2;
                                        bjl bjl = (bjl) it2.next();
                                        C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "label name: %s", bjl.name);
                                        CdnImageIconPreference cdnImageIconPreference = new CdnImageIconPreference(this);
                                        if (!C5046bo.isNullOrNil(bjl.title)) {
                                            cdnImageIconPreference.setTitle((CharSequence) bjl.title);
                                        }
                                        if (!C5046bo.isNullOrNil(bjl.desc)) {
                                            cdnImageIconPreference.mo48764NM(0);
                                            cdnImageIconPreference.mo48771av(bjl.desc, -1, Color.parseColor("#999999"));
                                        }
                                        if (!C5046bo.isNullOrNil(bjl.kbV)) {
                                            cdnImageIconPreference.iconUrl = bjl.kbV;
                                        }
                                        cdnImageIconPreference.setKey(bjl.name);
                                        long optLong = jSONObject.optLong(String.format("%s_expiretime", new Object[]{bjl.name}), 0);
                                        C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "expireTime: %s", Long.valueOf(optLong));
                                        obj = jSONObject.optInt(bjl.name, 0) == 1 ? 1 : null;
                                        if (obj == null || optLong <= 0 || currentTimeMillis < optLong) {
                                            obj2 = obj;
                                        } else {
                                            C4990ab.m7416i("MicroMsg.MallIndexMenuUI", "reddot expire");
                                            obj2 = null;
                                            try {
                                                jSONObject.put(bjl.name, 0);
                                            } catch (Exception e2) {
                                                C4990ab.printErrStackTrace("MicroMsg.MallIndexMenuUI", e2, "update expire reddot error: %s", e2.getMessage());
                                            }
                                        }
                                        if (obj2 != null) {
                                            if (bjl.wMS != null) {
                                                if ("1".equals(bjl.wMS.type)) {
                                                    cdnImageIconPreference.mo48764NM(0);
                                                    cdnImageIconPreference.mo48778qh(true);
                                                } else if ("2".equals(bjl.wMS.type)) {
                                                    cdnImageIconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                                                    cdnImageIconPreference.mo48763NL(0);
                                                } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bjl.wMS.type)) {
                                                    cdnImageIconPreference.mo48774ey(bjl.wMS.number, C25738R.drawable.a4f);
                                                    cdnImageIconPreference.mo48763NL(0);
                                                }
                                                if (!C5046bo.isNullOrNil(bjl.wMS.cEh)) {
                                                    C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "show red dot wording: %s", bjl.wMS.cEh);
                                                    cdnImageIconPreference.mo48771av(bjl.wMS.cEh, -1, Color.parseColor("#999999"));
                                                    cdnImageIconPreference.mo48764NM(0);
                                                }
                                            } else {
                                                cdnImageIconPreference.mo48765NN(0);
                                            }
                                        }
                                        cdnImageIconPreference.mo48768NQ(8);
                                        if (C5046bo.isNullOrNil(bjl.name)) {
                                            this.omL.put(i3 + bjl.name + bjl.ttd + bjl.title, bjl);
                                        } else {
                                            this.omL.put(bjl.name, bjl);
                                        }
                                        this.ehK.mo27713b(cdnImageIconPreference);
                                        int i4 = i3 + 1;
                                        C7060h c7060h;
                                        Object[] objArr2;
                                        C7060h c7060h2;
                                        Object[] objArr3;
                                        switch (bjl.ttd) {
                                            case 1:
                                                c7060h = C7060h.pYm;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(1);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = bjl.tte;
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                c7060h.mo8381e(14872, objArr2);
                                                i3 = i4;
                                                break;
                                            case 2:
                                                c7060h = C7060h.pYm;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(2);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = "";
                                                objArr2[3] = bjl.tzW;
                                                objArr2[4] = Integer.valueOf(1);
                                                c7060h.mo8381e(14872, objArr2);
                                                i3 = i4;
                                                break;
                                            case 3:
                                                c7060h2 = C7060h.pYm;
                                                objArr3 = new Object[5];
                                                objArr3[0] = Integer.valueOf(3);
                                                objArr3[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr3[2] = "";
                                                objArr3[3] = "";
                                                objArr3[4] = Integer.valueOf(1);
                                                c7060h2.mo8381e(14872, objArr3);
                                                i3 = i4;
                                                break;
                                            case 4:
                                                c7060h2 = C7060h.pYm;
                                                objArr3 = new Object[5];
                                                objArr3[0] = Integer.valueOf(4);
                                                objArr3[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr3[2] = "";
                                                objArr3[3] = "";
                                                objArr3[4] = Integer.valueOf(1);
                                                c7060h2.mo8381e(14872, objArr3);
                                                i3 = i4;
                                                break;
                                            case 5:
                                                c7060h2 = C7060h.pYm;
                                                objArr3 = new Object[5];
                                                objArr3[0] = Integer.valueOf(5);
                                                objArr3[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr3[2] = "";
                                                objArr3[3] = "";
                                                objArr3[4] = Integer.valueOf(1);
                                                c7060h2.mo8381e(14872, objArr3);
                                                i3 = i4;
                                                break;
                                            case 8:
                                                c7060h = C7060h.pYm;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(8);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = bjl.tte;
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                c7060h.mo8381e(14872, objArr2);
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
                        C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "after initPayMenuFromResponse, redDotConfig: %s", jSONObject.toString());
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
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
            AppMethodBeat.m2505o(43175);
            return;
        }
        C4990ab.m7412e("MicroMsg.MallIndexMenuUI", "GetPayMenu error!");
        AppMethodBeat.m2505o(43175);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(43176);
        if (i == 1) {
            C1720g.m3537RQ();
            this.okT = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
            if (i2 == -1) {
                if (C1853r.m3832YN()) {
                    finish();
                    AppMethodBeat.m2505o(43176);
                    return;
                }
                finish();
                C6533on c6533on = new C6533on();
                c6533on.cKQ.context = this.mController.ylL;
                C4879a.xxA.mo10055m(c6533on);
            }
        }
        AppMethodBeat.m2505o(43176);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43172);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(this.mController.dyj());
        this.omM = getIntent().getBooleanExtra("key_default_show_currency", false);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
        setBackBtn(new C212651());
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.cwp);
        C1720g.m3540Rg().mo14539a(1754, (C1202f) this);
        C1720g.m3540Rg().mo14541a(new C34507g(), 0);
        AppMethodBeat.m2505o(43172);
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
    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(43174);
        String str = preference.mKey;
        C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", str);
        bjl bjl = (bjl) this.omL.get(str);
        Intent intent;
        C42088bj c42088bj;
        if (bjl != null) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            C1720g.m3537RQ();
            str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, (Object) "");
            if (!C5046bo.isNullOrNil(str)) {
                boolean z;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MallIndexMenuUI", e, "parse redDotConfig json failed: %s", e.getMessage());
                }
                if (jSONObject.optInt(bjl.name, 0) != 1) {
                    jSONObject.remove(bjl.name);
                    jSONObject.remove(String.format("%s_expiretime", new Object[]{bjl.name}));
                    if (jSONObject.length() <= 0) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, (Object) "");
                    } else {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                    }
                    if (preference instanceof IconPreference) {
                        ((IconPreference) preference).mo48765NN(8);
                        ((IconPreference) preference).mo48763NL(8);
                        ((IconPreference) preference).mo48764NM(8);
                        ((IconPreference) preference).mo48778qh(false);
                    }
                    z = true;
                } else {
                    z = false;
                }
                C7060h c7060h;
                Object[] objArr;
                switch (bjl.ttd) {
                    case 1:
                        C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", bjl.tte);
                        if (!C5046bo.isNullOrNil(bjl.tte)) {
                            C36391e.m60016n(this, bjl.tte, false);
                        }
                        c7060h = C7060h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = bjl.tte;
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        c7060h.mo8381e(14872, objArr);
                        break;
                    case 2:
                        C4990ab.m7417i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", bjl.tzW, bjl.tzW);
                        if (!C5046bo.isNullOrNil(bjl.tzW)) {
                            C32628se c32628se = new C32628se();
                            c32628se.cOf.userName = bjl.tzW;
                            c32628se.cOf.cOh = C5046bo.m7532bc(bjl.ttg, "");
                            c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
                            c32628se.cOf.cOi = 0;
                            C4879a.xxA.mo10055m(c32628se);
                        }
                        c7060h = C7060h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = bjl.tzW;
                        objArr[4] = Integer.valueOf(0);
                        c7060h.mo8381e(14872, objArr);
                        break;
                    case 3:
                        C4990ab.m7416i("MicroMsg.MallIndexMenuUI", "jump type payment management");
                        C25985d.m41448H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                        c7060h = C7060h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(3);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        c7060h.mo8381e(14872, objArr);
                        break;
                    case 4:
                        int i;
                        C4990ab.m7416i("MicroMsg.MallIndexMenuUI", "jump type payment security");
                        intent = new Intent();
                        intent.putExtra("wallet_lock_jsapi_scene", 1);
                        C25985d.m41467b((Context) this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                        c7060h = C7060h.pYm;
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
                        c7060h.mo8381e(14872, objArr);
                        c42088bj = new C42088bj();
                        break;
                    case 5:
                        C4990ab.m7416i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
                        C25985d.m41471c((Context) this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                        c7060h = C7060h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(5);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        c7060h.mo8381e(14872, objArr);
                        break;
                    case 8:
                        C4990ab.m7416i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
                        C25985d.m41448H(this, "honey_pay", ".ui.HoneyPayMainUI");
                        c7060h = C7060h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(8);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        c7060h.mo8381e(14872, objArr);
                        break;
                }
                AppMethodBeat.m2505o(43174);
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
            AppMethodBeat.m2505o(43174);
            return true;
        } else if ("pay_my_msg".equals(str)) {
            C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", Boolean.valueOf((C14241r.cPI().cQo().tCP & 65536) > 0), Integer.valueOf(C14241r.cPI().cQo().tCP));
            if ((C14241r.cPI().cQo().tCP & 65536) > 0) {
                intent = new Intent();
                intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                C24143a.m37114b((Activity) this, "ShowOrdersInfoProcess", null);
            }
            C36391e.m59978QS(20);
            AppMethodBeat.m2505o(43174);
            return true;
        } else if ("pay_manage".equals(str)) {
            if (C1853r.m3831YM()) {
                C25985d.m41448H(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
            } else {
                C25985d.m41448H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
            }
            C36391e.m59978QS(21);
            AppMethodBeat.m2505o(43174);
            return true;
        } else {
            if ("pay_security".equals(str)) {
                C25985d.m41448H(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                C36391e.m59978QS(22);
                c42088bj = new C42088bj();
                c42088bj.cVT = 11;
                c42088bj.dcm = 1;
                c42088bj.ajK();
            } else if ("pay_help_center".equals(str)) {
                String str2;
                Intent intent2 = new Intent();
                if (C1853r.m3831YM()) {
                    str2 = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";
                } else {
                    str2 = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1";
                }
                intent2.putExtra("rawUrl", str2);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                C36391e.m59978QS(23);
                AppMethodBeat.m2505o(43174);
                return true;
            } else if ("pay_wallet_switch".equals(str)) {
                C25985d.m41471c((Context) this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                AppMethodBeat.m2505o(43174);
                return true;
            }
            AppMethodBeat.m2505o(43174);
            return false;
        }
    }
}
