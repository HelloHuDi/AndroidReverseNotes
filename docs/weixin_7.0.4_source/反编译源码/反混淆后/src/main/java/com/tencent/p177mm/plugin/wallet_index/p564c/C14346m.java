package com.tencent.p177mm.plugin.wallet_index.p564c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26151he;
import com.tencent.p177mm.p230g.p231a.C26195mf;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.csj;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.tenpay.model.C16089o;
import com.tencent.p177mm.wallet_core.tenpay.model.C36385r;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.m */
public final class C14346m extends C4884c<C32652uv> implements C1202f {
    int tRg;
    int tRh;
    C26151he tRi;
    C26195mf tRj;
    long tRk;
    public C4884c tRl;
    public C4884c<C26195mf> tRm;

    /* renamed from: com.tencent.mm.plugin.wallet_index.c.m$1 */
    class C143471 extends C4884c<C26151he> {
        C143471() {
            AppMethodBeat.m2504i(48195);
            this.xxI = C26151he.class.getName().hashCode();
            AppMethodBeat.m2505o(48195);
        }

        /* renamed from: a */
        private boolean m22532a(C26151he c26151he) {
            int i = 0;
            AppMethodBeat.m2504i(48196);
            C14346m.this.tRi = c26151he;
            String str = C14346m.this.tRi.cBW.result;
            if (C14346m.this.tRi.cBW.cBY != null) {
                C14346m.this.tRh = C14346m.this.tRi.cBW.cBY.getInt("pay_channel", 0);
            }
            switch (C14346m.this.tRi.cBW.actionCode) {
                case 10:
                case 11:
                    C4879a.xxA.mo10052c(C14346m.this);
                    C4990ab.m7410d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(str)));
                    if (str != null) {
                        if (!str.startsWith("weixin://wxpay")) {
                            C14346m.this.tRg = 1;
                            C14346m.m22528a(C14346m.this, str, C14346m.this.tRh);
                        } else if (C5047bp.dpL()) {
                            C4990ab.m7416i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
                            C26195mf c26195mf = new C26195mf();
                            c26195mf.cHZ.url = str;
                            c26195mf.cHZ.scene = 4;
                            c26195mf.cHZ.cIb = 12;
                            c26195mf.cHZ.cvp = 0;
                            c26195mf.cHZ.source = "";
                            c26195mf.cHZ.context = c26151he.cBW.context;
                            C14346m.m22527a(C14346m.this, c26195mf);
                            Toast.makeText(c26151he.cBW.context, "click to do pay test", 1).show();
                        } else {
                            C14346m.this.tRg = 4;
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14539a((int) C31128d.MIC_PTU_MEISHI, C14346m.this);
                            C1207m c6681h = new C6681h(str, C14346m.this.tRi.cBW.username, 4, 0, (int) System.currentTimeMillis(), new byte[0]);
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(c6681h, 0);
                            C14346m.this.tRk = System.currentTimeMillis();
                        }
                        AppMethodBeat.m2505o(48196);
                        return true;
                    }
                    AppMethodBeat.m2505o(48196);
                    return true;
                case 12:
                    C14346m c14346m = C14346m.this;
                    C4990ab.m7410d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = ".concat(String.valueOf(str)));
                    String[] split = str.replace("http://p.weixin.qq.com?", "").split("&");
                    int length = split.length;
                    String str2 = null;
                    str = null;
                    Object obj = null;
                    while (i < length) {
                        String str3 = split[i];
                        if (str3.startsWith("errcode=")) {
                            obj = str3.replace("errcode=", "");
                        } else if (str3.startsWith("errmsg=")) {
                            str = str3.replace("errmsg=", "");
                        } else if (str3.startsWith("importkey=")) {
                            str2 = str3.replace("importkey=", "");
                        }
                        i++;
                    }
                    if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(obj) || C5046bo.isNullOrNil(str2)) {
                        if (C5046bo.isNullOrNil(str)) {
                            str = c14346m.tRi.cBW.context.getString(C25738R.string.fu2);
                        }
                        C30379h.m48438a(c14346m.tRi.cBW.context, str, "", new C143526());
                    } else {
                        Context context = c14346m.tRi.cBW.context;
                        Intent intent = new Intent();
                        intent.putExtra("key_import_key", str2);
                        intent.putExtra("key_bind_scene", 2);
                        intent.putExtra("key_custom_bind_tips", null);
                        C25985d.m41467b(context, "wallet", ".bind.ui.WalletBindUI", intent);
                        if (c14346m.tRi.callback != null) {
                            c14346m.tRi.cBX.ret = 1;
                            c14346m.tRi.callback.run();
                        }
                    }
                    AppMethodBeat.m2505o(48196);
                    return true;
                default:
                    AppMethodBeat.m2505o(48196);
                    return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.c.m$3 */
    class C143483 implements OnClickListener {
        C143483() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48201);
            if (C14346m.this.tRi.callback != null) {
                C14346m.this.tRi.cBX.ret = 1;
                C14346m.this.tRi.callback.run();
            }
            AppMethodBeat.m2505o(48201);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.c.m$2 */
    class C143492 extends C4884c<C26195mf> {
        C143492() {
            AppMethodBeat.m2504i(48198);
            this.xxI = C26195mf.class.getName().hashCode();
            AppMethodBeat.m2505o(48198);
        }

        /* renamed from: a */
        private boolean m22534a(C26195mf c26195mf) {
            AppMethodBeat.m2504i(48199);
            C14346m.m22527a(C14346m.this, c26195mf);
            AppMethodBeat.m2505o(48199);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.c.m$4 */
    class C143504 implements OnClickListener {
        C143504() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48202);
            if (C14346m.this.tRj.callback != null) {
                C14346m.this.tRj.cIa.ret = 1;
                C14346m.this.tRj.callback.run();
            }
            AppMethodBeat.m2505o(48202);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.c.m$5 */
    class C143515 implements OnClickListener {
        C143515() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48203);
            if (C14346m.this.tRi.callback != null) {
                C14346m.this.tRi.cBX.ret = 1;
                C14346m.this.tRi.callback.run();
            }
            AppMethodBeat.m2505o(48203);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.c.m$6 */
    class C143526 implements OnClickListener {
        C143526() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48204);
            if (C14346m.this.tRi.callback != null) {
                C14346m.this.tRi.cBX.ret = 1;
                C14346m.this.tRi.callback.run();
            }
            AppMethodBeat.m2505o(48204);
        }
    }

    public C14346m() {
        AppMethodBeat.m2504i(48205);
        this.tRh = 0;
        this.tRl = new C143471();
        this.tRm = new C143492();
        this.xxI = C32652uv.class.getName().hashCode();
        AppMethodBeat.m2505o(48205);
    }

    /* renamed from: a */
    static /* synthetic */ void m22528a(C14346m c14346m, String str, int i) {
        AppMethodBeat.m2504i(48211);
        c14346m.m22529du(str, i);
        AppMethodBeat.m2505o(48211);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(48209);
        C32652uv c32652uv = (C32652uv) c4883b;
        C36381z.dNW();
        if (c32652uv instanceof C32652uv) {
            C4990ab.m7410d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (c32652uv.cRF.result == -1));
            C4879a.xxA.mo10053d(this);
            if (c32652uv.cRF.result == -1) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                if (c32652uv.cRF.intent == null || c32652uv.cRF.intent.getIntExtra("pay_channel", 0) != 13) {
                    C25985d.m41473f(C4996ah.getContext(), ".ui.LauncherUI", intent);
                } else {
                    C4990ab.m7416i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
                }
            }
            AppMethodBeat.m2505o(48209);
            return true;
        }
        C4990ab.m7414f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        AppMethodBeat.m2505o(48209);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48206);
        if (c1207m instanceof C6681h) {
            long currentTimeMillis = System.currentTimeMillis() - this.tRk;
            C7060h.pYm.mo8381e(11170, Integer.valueOf(C31128d.MIC_PTU_MEISHI), Integer.valueOf(0), Long.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(C5023at.getNetType(C4996ah.getContext())), "");
            m22530i(i, i2, currentTimeMillis);
            C4990ab.m7410d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
            if (i == 0 && i2 == 0) {
                m22529du(((C6681h) c1207m).aiT(), this.tRh);
                AppMethodBeat.m2505o(48206);
                return;
            }
            if (C5046bo.isNullOrNil(str)) {
                str = this.tRi.cBW.context.getString(C25738R.string.fu2);
            }
            C30379h.m48438a(this.tRi.cBW.context, str, "", new C143483());
            AppMethodBeat.m2505o(48206);
        } else if (c1207m instanceof C16089o) {
            C4990ab.m7411d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            if (i == 0 && i2 == 0 && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(((C16089o) c1207m).AgN)) {
                if (this.tRj.callback != null) {
                    this.tRj.cIa.ret = 2;
                    this.tRj.callback.run();
                }
                C44422ad.m80307o(this.tRg, ((C16089o) c1207m).czZ, i2);
                csj csj = ((C16089o) c1207m).tRc;
                C16089o c16089o;
                if (csj == null || C5046bo.isNullOrNil(csj.xpI)) {
                    c16089o = (C16089o) c1207m;
                    PayInfo payInfo = new PayInfo();
                    payInfo.cIf = this.tRg;
                    payInfo.czZ = c16089o.czZ;
                    payInfo.appId = c16089o.appId;
                    payInfo.tRb = c16089o.tRb;
                    payInfo.cwg = c16089o.cwg;
                    payInfo.cIb = c16089o.cIb;
                    C4990ab.m7411d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", payInfo.toString());
                    C35899h.m58853a(this.tRj.cHZ.context, payInfo, 0);
                    if (this.tRj.callback != null) {
                        this.tRj.cIa.ret = 2;
                        this.tRj.callback.run();
                    }
                    AppMethodBeat.m2505o(48206);
                    return;
                }
                c16089o = (C16089o) c1207m;
                Intent intent = new Intent();
                intent.putExtra("prepayId", c16089o.czZ);
                intent.putExtra("is_jsapi_offline_pay", false);
                csj = c16089o.tRc;
                intent.putExtra("pay_gate_url", csj.xpI);
                intent.putExtra("need_dialog", csj.xpK);
                intent.putExtra("dialog_text", csj.xpL);
                intent.putExtra("max_count", csj.xpJ.vRG);
                intent.putExtra("inteval_time", csj.xpJ.vRF);
                intent.putExtra("default_wording", csj.xpJ.vRH);
                C25985d.m41472c((Activity) this.tRj.cHZ.context, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                if (this.tRj.callback != null) {
                    this.tRj.cIa.ret = 2;
                    this.tRj.callback.run();
                }
                C4990ab.m7411d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", this.tRj.cHZ.context);
                AppMethodBeat.m2505o(48206);
                return;
            }
            if (this.tRj.callback != null) {
                this.tRj.cIa.ret = 1;
            }
            if (C5046bo.isNullOrNil(str)) {
                if (C5046bo.isNullOrNil(((C16089o) c1207m).hwA)) {
                    str = this.tRj.cHZ.context.getString(C25738R.string.fu2);
                } else {
                    str = ((C16089o) c1207m).hwA;
                }
            }
            C44422ad.m80307o(this.tRg, "", i2);
            C30379h.m48438a(this.tRj.cHZ.context, str, "", new C143504());
            AppMethodBeat.m2505o(48206);
        } else {
            C4990ab.m7416i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
            AppMethodBeat.m2505o(48206);
        }
    }

    /* renamed from: du */
    private void m22529du(String str, int i) {
        AppMethodBeat.m2504i(48207);
        C4990ab.m7410d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(str)));
        PayInfo payInfo = new PayInfo();
        payInfo.cIf = this.tRg;
        String str2 = null;
        Object obj = null;
        for (String str3 : str.replace("http://p.qq.com?", "").split("&")) {
            if (str3.startsWith("errcode=")) {
                obj = str3.replace("errcode=", "");
            } else if (str3.startsWith("errmsg=")) {
                str2 = str3.replace("errmsg=", "");
            } else if (str3.startsWith("reqkey=")) {
                payInfo.czZ = str3.replace("reqkey=", "");
            } else if (str3.startsWith("uuid=")) {
                payInfo.eCq = str3.replace("uuid=", "");
            } else if (str3.startsWith("appid=")) {
                payInfo.appId = str3.replace("appid=", "");
            } else if (str3.startsWith("appsource=")) {
                payInfo.tRb = str3.replace("appsource=", "");
            } else if (str3.startsWith("productid=")) {
                payInfo.cwg = str3.replace("productid=", "");
            }
        }
        payInfo.cIb = i;
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(obj)) {
            C35899h.m58853a(this.tRi.cBW.context, payInfo, 0);
            if (this.tRi.callback != null) {
                this.tRi.cBX.ret = 1;
                this.tRi.callback.run();
            }
        } else {
            if (C5046bo.isNullOrNil(str2)) {
                str2 = this.tRi.cBW.context.getString(C25738R.string.fu2);
            }
            C30379h.m48438a(this.tRi.cBW.context, str2, "", new C143515());
        }
        if (!TextUtils.isEmpty(obj) && Pattern.compile("[0-9]*").matcher(obj).matches()) {
            m22530i(0, Integer.valueOf(obj).intValue(), 0);
        }
        AppMethodBeat.m2505o(48207);
    }

    /* renamed from: i */
    private void m22530i(int i, int i2, long j) {
        IDKey iDKey;
        AppMethodBeat.m2504i(48208);
        int i3 = 132;
        if (this.tRg == 1) {
            i3 = ErrorCode.STARTDOWNLOAD_4;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i3);
        iDKey2.SetValue(1);
        iDKey2.SetKey(26);
        arrayList.add(iDKey2);
        if (!(i == 0 && i2 == 0)) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            iDKey2.SetKey(8);
            if (i2 < 0) {
                iDKey.SetKey(9);
            } else if (i2 > 0) {
                iDKey.SetKey(10);
            }
        }
        if (this.tRg == 4 && j > 0) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i3);
            iDKey3.SetValue((long) ((int) j));
            iDKey2.SetKey(0);
            if (j <= 1000) {
                iDKey.SetKey(1);
                iDKey3.SetKey(4);
            } else if (j > 1000 && j <= 3000) {
                iDKey.SetKey(2);
                iDKey3.SetKey(5);
            } else if (j > 3000) {
                iDKey.SetKey(3);
                iDKey3.SetKey(6);
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey);
            arrayList.add(iDKey3);
        }
        C7060h.pYm.mo8379b(arrayList, true);
        AppMethodBeat.m2505o(48208);
    }

    /* renamed from: a */
    static /* synthetic */ void m22527a(C14346m c14346m, C26195mf c26195mf) {
        String str;
        C1207m c16089o;
        AppMethodBeat.m2504i(48210);
        c14346m.tRj = c26195mf;
        String str2 = c26195mf.cHZ.url;
        int i = c26195mf.cHZ.scene;
        int i2 = c26195mf.cHZ.cIb;
        int i3 = c26195mf.cHZ.cvp;
        if (c26195mf.cHZ.source == null) {
            str = "";
        } else {
            str = c26195mf.cHZ.source;
        }
        c14346m.tRg = 1;
        C4990ab.m7411d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        int i4 = c14346m.tRg;
        if (C5046bo.isNullOrNil(str2)) {
            c16089o = new C16089o(str2, i, i4, i2, i3, str);
        } else {
            int indexOf = str2.indexOf("/bizpayurl");
            int indexOf2 = str2.indexOf("?");
            if (indexOf < 0 || indexOf2 < 0 || indexOf >= indexOf2) {
                c16089o = new C16089o(str2, i, i4, i2, i3, str);
            } else if (str2.substring(indexOf, indexOf2).equals("/bizpayurl/up")) {
                c16089o = new C36385r(str2, i, i4, i2, i3, str);
            } else {
                c16089o = new C16089o(str2, i, i4, i2, i3, str);
            }
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) c14346m);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c16089o, 0);
        AppMethodBeat.m2505o(48210);
    }
}
