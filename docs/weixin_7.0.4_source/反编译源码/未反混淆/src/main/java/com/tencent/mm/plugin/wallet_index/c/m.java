package com.tencent.mm.plugin.wallet_index.c;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.o;
import com.tencent.mm.wallet_core.tenpay.model.r;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class m extends c<uv> implements f {
    int tRg;
    int tRh;
    he tRi;
    mf tRj;
    long tRk;
    public c tRl;
    public c<mf> tRm;

    public m() {
        AppMethodBeat.i(48205);
        this.tRh = 0;
        this.tRl = new c<he>() {
            {
                AppMethodBeat.i(48195);
                this.xxI = he.class.getName().hashCode();
                AppMethodBeat.o(48195);
            }

            private boolean a(he heVar) {
                int i = 0;
                AppMethodBeat.i(48196);
                m.this.tRi = heVar;
                String str = m.this.tRi.cBW.result;
                if (m.this.tRi.cBW.cBY != null) {
                    m.this.tRh = m.this.tRi.cBW.cBY.getInt("pay_channel", 0);
                }
                switch (m.this.tRi.cBW.actionCode) {
                    case 10:
                    case 11:
                        a.xxA.c(m.this);
                        ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(str)));
                        if (str != null) {
                            if (!str.startsWith("weixin://wxpay")) {
                                m.this.tRg = 1;
                                m.a(m.this, str, m.this.tRh);
                            } else if (bp.dpL()) {
                                ab.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
                                mf mfVar = new mf();
                                mfVar.cHZ.url = str;
                                mfVar.cHZ.scene = 4;
                                mfVar.cHZ.cIb = 12;
                                mfVar.cHZ.cvp = 0;
                                mfVar.cHZ.source = "";
                                mfVar.cHZ.context = heVar.cBW.context;
                                m.a(m.this, mfVar);
                                Toast.makeText(heVar.cBW.context, "click to do pay test", 1).show();
                            } else {
                                m.this.tRg = 4;
                                g.RQ();
                                g.RO().eJo.a((int) d.MIC_PTU_MEISHI, m.this);
                                com.tencent.mm.ai.m hVar = new h(str, m.this.tRi.cBW.username, 4, 0, (int) System.currentTimeMillis(), new byte[0]);
                                g.RQ();
                                g.RO().eJo.a(hVar, 0);
                                m.this.tRk = System.currentTimeMillis();
                            }
                            AppMethodBeat.o(48196);
                            return true;
                        }
                        AppMethodBeat.o(48196);
                        return true;
                    case 12:
                        m mVar = m.this;
                        ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = ".concat(String.valueOf(str)));
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
                        if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(obj) || bo.isNullOrNil(str2)) {
                            if (bo.isNullOrNil(str)) {
                                str = mVar.tRi.cBW.context.getString(R.string.fu2);
                            }
                            com.tencent.mm.ui.base.h.a(mVar.tRi.cBW.context, str, "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(48204);
                                    if (m.this.tRi.callback != null) {
                                        m.this.tRi.cBX.ret = 1;
                                        m.this.tRi.callback.run();
                                    }
                                    AppMethodBeat.o(48204);
                                }
                            });
                        } else {
                            Context context = mVar.tRi.cBW.context;
                            Intent intent = new Intent();
                            intent.putExtra("key_import_key", str2);
                            intent.putExtra("key_bind_scene", 2);
                            intent.putExtra("key_custom_bind_tips", null);
                            com.tencent.mm.bp.d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
                            if (mVar.tRi.callback != null) {
                                mVar.tRi.cBX.ret = 1;
                                mVar.tRi.callback.run();
                            }
                        }
                        AppMethodBeat.o(48196);
                        return true;
                    default:
                        AppMethodBeat.o(48196);
                        return false;
                }
            }
        };
        this.tRm = new c<mf>() {
            {
                AppMethodBeat.i(48198);
                this.xxI = mf.class.getName().hashCode();
                AppMethodBeat.o(48198);
            }

            private boolean a(mf mfVar) {
                AppMethodBeat.i(48199);
                m.a(m.this, mfVar);
                AppMethodBeat.o(48199);
                return false;
            }
        };
        this.xxI = uv.class.getName().hashCode();
        AppMethodBeat.o(48205);
    }

    static /* synthetic */ void a(m mVar, String str, int i) {
        AppMethodBeat.i(48211);
        mVar.du(str, i);
        AppMethodBeat.o(48211);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(48209);
        uv uvVar = (uv) bVar;
        z.dNW();
        if (uvVar instanceof uv) {
            ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (uvVar.cRF.result == -1));
            a.xxA.d(this);
            if (uvVar.cRF.result == -1) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                if (uvVar.cRF.intent == null || uvVar.cRF.intent.getIntExtra("pay_channel", 0) != 13) {
                    com.tencent.mm.bp.d.f(ah.getContext(), ".ui.LauncherUI", intent);
                } else {
                    ab.i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
                }
            }
            AppMethodBeat.o(48209);
            return true;
        }
        ab.f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        AppMethodBeat.o(48209);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(48206);
        if (mVar instanceof h) {
            long currentTimeMillis = System.currentTimeMillis() - this.tRk;
            com.tencent.mm.plugin.report.service.h.pYm.e(11170, Integer.valueOf(d.MIC_PTU_MEISHI), Integer.valueOf(0), Long.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(at.getNetType(ah.getContext())), "");
            i(i, i2, currentTimeMillis);
            ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
            g.RQ();
            g.RO().eJo.b((int) d.MIC_PTU_MEISHI, (f) this);
            if (i == 0 && i2 == 0) {
                du(((h) mVar).aiT(), this.tRh);
                AppMethodBeat.o(48206);
                return;
            }
            if (bo.isNullOrNil(str)) {
                str = this.tRi.cBW.context.getString(R.string.fu2);
            }
            com.tencent.mm.ui.base.h.a(this.tRi.cBW.context, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(48201);
                    if (m.this.tRi.callback != null) {
                        m.this.tRi.cBX.ret = 1;
                        m.this.tRi.callback.run();
                    }
                    AppMethodBeat.o(48201);
                }
            });
            AppMethodBeat.o(48206);
        } else if (mVar instanceof o) {
            ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            g.RQ();
            g.RO().eJo.b(385, (f) this);
            if (i == 0 && i2 == 0 && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(((o) mVar).AgN)) {
                if (this.tRj.callback != null) {
                    this.tRj.cIa.ret = 2;
                    this.tRj.callback.run();
                }
                ad.o(this.tRg, ((o) mVar).czZ, i2);
                csj csj = ((o) mVar).tRc;
                o oVar;
                if (csj == null || bo.isNullOrNil(csj.xpI)) {
                    oVar = (o) mVar;
                    PayInfo payInfo = new PayInfo();
                    payInfo.cIf = this.tRg;
                    payInfo.czZ = oVar.czZ;
                    payInfo.appId = oVar.appId;
                    payInfo.tRb = oVar.tRb;
                    payInfo.cwg = oVar.cwg;
                    payInfo.cIb = oVar.cIb;
                    ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", payInfo.toString());
                    com.tencent.mm.pluginsdk.wallet.h.a(this.tRj.cHZ.context, payInfo, 0);
                    if (this.tRj.callback != null) {
                        this.tRj.cIa.ret = 2;
                        this.tRj.callback.run();
                    }
                    AppMethodBeat.o(48206);
                    return;
                }
                oVar = (o) mVar;
                Intent intent = new Intent();
                intent.putExtra("prepayId", oVar.czZ);
                intent.putExtra("is_jsapi_offline_pay", false);
                csj = oVar.tRc;
                intent.putExtra("pay_gate_url", csj.xpI);
                intent.putExtra("need_dialog", csj.xpK);
                intent.putExtra("dialog_text", csj.xpL);
                intent.putExtra("max_count", csj.xpJ.vRG);
                intent.putExtra("inteval_time", csj.xpJ.vRF);
                intent.putExtra("default_wording", csj.xpJ.vRH);
                com.tencent.mm.bp.d.c((Activity) this.tRj.cHZ.context, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                if (this.tRj.callback != null) {
                    this.tRj.cIa.ret = 2;
                    this.tRj.callback.run();
                }
                ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", this.tRj.cHZ.context);
                AppMethodBeat.o(48206);
                return;
            }
            if (this.tRj.callback != null) {
                this.tRj.cIa.ret = 1;
            }
            if (bo.isNullOrNil(str)) {
                if (bo.isNullOrNil(((o) mVar).hwA)) {
                    str = this.tRj.cHZ.context.getString(R.string.fu2);
                } else {
                    str = ((o) mVar).hwA;
                }
            }
            ad.o(this.tRg, "", i2);
            com.tencent.mm.ui.base.h.a(this.tRj.cHZ.context, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(48202);
                    if (m.this.tRj.callback != null) {
                        m.this.tRj.cIa.ret = 1;
                        m.this.tRj.callback.run();
                    }
                    AppMethodBeat.o(48202);
                }
            });
            AppMethodBeat.o(48206);
        } else {
            ab.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
            AppMethodBeat.o(48206);
        }
    }

    private void du(String str, int i) {
        AppMethodBeat.i(48207);
        ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(str)));
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
            com.tencent.mm.pluginsdk.wallet.h.a(this.tRi.cBW.context, payInfo, 0);
            if (this.tRi.callback != null) {
                this.tRi.cBX.ret = 1;
                this.tRi.callback.run();
            }
        } else {
            if (bo.isNullOrNil(str2)) {
                str2 = this.tRi.cBW.context.getString(R.string.fu2);
            }
            com.tencent.mm.ui.base.h.a(this.tRi.cBW.context, str2, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(48203);
                    if (m.this.tRi.callback != null) {
                        m.this.tRi.cBX.ret = 1;
                        m.this.tRi.callback.run();
                    }
                    AppMethodBeat.o(48203);
                }
            });
        }
        if (!TextUtils.isEmpty(obj) && Pattern.compile("[0-9]*").matcher(obj).matches()) {
            i(0, Integer.valueOf(obj).intValue(), 0);
        }
        AppMethodBeat.o(48207);
    }

    private void i(int i, int i2, long j) {
        IDKey iDKey;
        AppMethodBeat.i(48208);
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
        com.tencent.mm.plugin.report.service.h.pYm.b(arrayList, true);
        AppMethodBeat.o(48208);
    }

    static /* synthetic */ void a(m mVar, mf mfVar) {
        String str;
        com.tencent.mm.ai.m oVar;
        AppMethodBeat.i(48210);
        mVar.tRj = mfVar;
        String str2 = mfVar.cHZ.url;
        int i = mfVar.cHZ.scene;
        int i2 = mfVar.cHZ.cIb;
        int i3 = mfVar.cHZ.cvp;
        if (mfVar.cHZ.source == null) {
            str = "";
        } else {
            str = mfVar.cHZ.source;
        }
        mVar.tRg = 1;
        ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        int i4 = mVar.tRg;
        if (bo.isNullOrNil(str2)) {
            oVar = new o(str2, i, i4, i2, i3, str);
        } else {
            int indexOf = str2.indexOf("/bizpayurl");
            int indexOf2 = str2.indexOf("?");
            if (indexOf < 0 || indexOf2 < 0 || indexOf >= indexOf2) {
                oVar = new o(str2, i, i4, i2, i3, str);
            } else if (str2.substring(indexOf, indexOf2).equals("/bizpayurl/up")) {
                oVar = new r(str2, i, i4, i2, i3, str);
            } else {
                oVar = new o(str2, i, i4, i2, i3, str);
            }
        }
        g.RQ();
        g.RO().eJo.a(385, (f) mVar);
        g.RQ();
        g.RO().eJo.a(oVar, 0);
        AppMethodBeat.o(48210);
    }
}
