package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

public class WXBizEntryActivity extends AutoLoginActivity {
    private int jDy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18148);
        super.onCreate(bundle);
        setTitleVisibility(0);
        AppMethodBeat.o(18148);
    }

    public final int getLayoutId() {
        return R.layout.gv;
    }

    public final boolean O(Intent intent) {
        return true;
    }

    public final void a(a aVar, Intent intent) {
        Uri uri = null;
        AppMethodBeat.i(18149);
        ab.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(aVar)));
        if (getIntent() != null) {
            this.jDy = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (aVar) {
            case LOGIN_OK:
                ab.i("MicroMsg.WXBizEntryActivity", "req type = %d", Integer.valueOf(this.jDy));
                Intent intent2;
                Uri data;
                switch (this.jDy) {
                    case 7:
                    case 8:
                        intent2 = getIntent();
                        intent2.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
                        startActivity(intent2);
                        finish();
                        AppMethodBeat.o(18149);
                        return;
                    case 9:
                        d.c((Context) this, "card", ".ui.CardAddEntranceUI", getIntent());
                        finish();
                        AppMethodBeat.o(18149);
                        return;
                    case 11:
                        intent2 = getIntent();
                        intent2.putExtra("device_type", 1);
                        d.c((Context) this, "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                        finish();
                        AppMethodBeat.o(18149);
                        return;
                    case 12:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e) {
                            ab.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                        }
                        if (uri != null && e.ain(uri.toString())) {
                            v.Zp().nV("key_data_center_session_id");
                            e.a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18138);
                                    ab.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (mVar == null || i == 0 || i2 == 0 || !(mVar instanceof z)) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18138);
                                        return;
                                    }
                                    ciq ajE = ((z) mVar).ajE();
                                    if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18138);
                                        return;
                                    }
                                    h.a(WXBizEntryActivity.this, bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(R.string.tz), WXBizEntryActivity.this.getString(R.string.s6), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(18137);
                                            WXBizEntryActivity.a(WXBizEntryActivity.this);
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(18137);
                                        }
                                    });
                                    AppMethodBeat.o(18138);
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.o(18149);
                            return;
                        }
                    case 13:
                        intent2 = getIntent();
                        intent2.putExtra("key_static_from_scene", 100001);
                        d.c((Context) this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
                        finish();
                        AppMethodBeat.o(18149);
                        return;
                    case 14:
                    case 15:
                        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a() {
                            public final void ft(boolean z) {
                                AppMethodBeat.i(18135);
                                if (z) {
                                    d.c(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent());
                                } else {
                                    ab.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
                                }
                                WXBizEntryActivity.this.finish();
                                AppMethodBeat.o(18135);
                            }
                        }).aVi();
                        AppMethodBeat.o(18149);
                        return;
                    case 16:
                        d.c((Context) this, "card", ".ui.CardListSelectedUI", getIntent());
                        finish();
                        AppMethodBeat.o(18149);
                        return;
                    case 17:
                        try {
                            data = getIntent().getData();
                            AnonymousClass2 anonymousClass2 = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(18136);
                                    WXBizEntryActivity.this.findViewById(R.id.a6y).setVisibility(8);
                                    AppMethodBeat.o(18136);
                                }
                            };
                            String stringExtra = getIntent().getStringExtra("key_package_name");
                            String stringExtra2 = getIntent().getStringExtra("key_package_signature");
                            int intExtra = getIntent().getIntExtra("translate_link_scene", 1);
                            ab.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", stringExtra, stringExtra2);
                            if (bo.isNullOrNil(stringExtra) || bo.isNullOrNil(stringExtra2)) {
                                ab.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
                                AppMethodBeat.o(18149);
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            df dfVar = new df();
                            ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", stringExtra);
                            dfVar.kKO = stringExtra;
                            dfVar.signature = stringExtra2;
                            linkedList.add(dfVar);
                            m zVar = new z(data.toString(), intExtra, linkedList);
                            aw.Rg().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new com.tencent.mm.plugin.base.stub.e.AnonymousClass1(this, anonymousClass2));
                            aw.Rg().a(zVar, 0);
                            AppMethodBeat.o(18149);
                            return;
                        } catch (Exception e2) {
                            ab.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", e2.getMessage());
                            AppMethodBeat.o(18149);
                            return;
                        }
                    case 19:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e22) {
                            ab.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", e22.getMessage());
                        }
                        if (uri != null) {
                            final String queryParameter = uri.getQueryParameter("invokeData");
                            e.a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18142);
                                    ab.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (mVar == null || i == 0 || i2 == 0 || !(mVar instanceof z)) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18142);
                                        return;
                                    }
                                    final ciq ajE = ((z) mVar).ajE();
                                    if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18142);
                                        return;
                                    }
                                    h.a(WXBizEntryActivity.this, bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(R.string.tz), WXBizEntryActivity.this.getString(R.string.s6), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(18141);
                                            WXBizEntryActivity.a(WXBizEntryActivity.this, queryParameter, ajE.xhy);
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(18141);
                                        }
                                    });
                                    AppMethodBeat.o(18142);
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.o(18149);
                            return;
                        }
                        break;
                    case 24:
                        try {
                            data = getIntent().getData();
                        } catch (Exception e222) {
                            ab.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", e222.getMessage());
                            data = uri;
                        }
                        if (data != null) {
                            e.a((Context) this, data.toString(), getIntent().getIntExtra("translate_link_scene", 1), new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18146);
                                    ab.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (mVar == null || i == 0 || i2 == 0 || !(mVar instanceof z)) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18146);
                                        return;
                                    }
                                    ciq ajE = ((z) mVar).ajE();
                                    if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18146);
                                        return;
                                    }
                                    h.a(WXBizEntryActivity.this, bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(R.string.tz), WXBizEntryActivity.this.getString(R.string.s6), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(18145);
                                            WXBizEntryActivity.c(WXBizEntryActivity.this);
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(18145);
                                        }
                                    });
                                    AppMethodBeat.o(18146);
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.o(18149);
                            return;
                        }
                        break;
                    case 25:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e2222) {
                            ab.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e2222.getMessage());
                        }
                        if (uri != null && e.aio(uri.toString())) {
                            v.Zp().nV("key_data_center_session_id");
                            e.a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18140);
                                    ab.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (mVar == null || i == 0 || i2 == 0 || !(mVar instanceof z)) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18140);
                                        return;
                                    }
                                    ciq ajE = ((z) mVar).ajE();
                                    if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18140);
                                        return;
                                    }
                                    h.a(WXBizEntryActivity.this, bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(R.string.tz), WXBizEntryActivity.this.getString(R.string.s6), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(18139);
                                            WXBizEntryActivity.b(WXBizEntryActivity.this);
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(18139);
                                        }
                                    });
                                    AppMethodBeat.o(18140);
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.o(18149);
                            return;
                        }
                    case 26:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e22222) {
                            ab.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", e22222.getMessage());
                        }
                        if (uri != null) {
                            e.a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18144);
                                    ab.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (mVar == null || (((z || bo.isNullOrNil(str)) && (i == 0 || i2 == 0)) || !(mVar instanceof z))) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18144);
                                        return;
                                    }
                                    ciq ajE = ((z) mVar).ajE();
                                    if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.o(18144);
                                        return;
                                    }
                                    final String nullAsNil = bo.nullAsNil(bo.bc(ajE.xhy, str));
                                    h.a(WXBizEntryActivity.this, nullAsNil, WXBizEntryActivity.this.getString(R.string.tz), WXBizEntryActivity.this.getString(R.string.s6), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(18143);
                                            WXBizEntryActivity.a(WXBizEntryActivity.this, nullAsNil);
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(18143);
                                        }
                                    });
                                    AppMethodBeat.o(18144);
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.o(18149);
                            return;
                        }
                        break;
                    default:
                        finish();
                        break;
                }
                AppMethodBeat.o(18149);
                return;
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                ab.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                break;
            default:
                ab.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(aVar)));
                break;
        }
        finish();
        AppMethodBeat.o(18149);
    }

    private static void a(Bundle bundle, BaseResp baseResp, f fVar) {
        AppMethodBeat.i(18150);
        baseResp.toBundle(bundle);
        Args args = new Args();
        args.targetPkgName = fVar.field_packageName;
        args.bundle = bundle;
        p.at(bundle);
        p.au(bundle);
        MMessageActV2.send(ah.getContext(), args);
        AppMethodBeat.o(18150);
    }

    private static void dc(String str, String str2) {
        AppMethodBeat.i(18151);
        f bT = g.bT(str, true);
        if (bT == null) {
            AppMethodBeat.o(18151);
            return;
        }
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.extInfo = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
        wXMediaMessage.sdkVer = Build.SDK_INT;
        wXMediaMessage.messageExt = str2;
        g.a(ah.getContext(), bT.field_appId, wXMediaMessage, 2, null, null);
        AppMethodBeat.o(18151);
    }

    static /* synthetic */ void a(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.i(18152);
        try {
            Uri data = wXBizEntryActivity.getIntent().getData();
            int i = bo.getInt(data.getQueryParameter("type"), 0);
            dc(bo.nullAsNil(data.getQueryParameter("appid")), String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", new Object[]{bo.nullAsNil(data.getQueryParameter("appid")), Integer.valueOf(i), Integer.valueOf(-3)}));
            AppMethodBeat.o(18152);
        } catch (Exception e) {
            ab.e("MicroMsg.WXBizEntryActivity", "launchOpenTypeWebView get url from intent failed : %s", e.getMessage());
            AppMethodBeat.o(18152);
        }
    }

    static /* synthetic */ void b(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.i(18153);
        try {
            Uri data = wXBizEntryActivity.getIntent().getData();
            int i = bo.getInt(data.getQueryParameter("type"), 0);
            dc(bo.nullAsNil(data.getQueryParameter("appid")), String.format("%s://openbusinesswebview?type=%d&ret=%d", new Object[]{bo.nullAsNil(data.getQueryParameter("appid")), Integer.valueOf(i), Integer.valueOf(-3)}));
            AppMethodBeat.o(18153);
        } catch (Exception e) {
            ab.e("MicroMsg.WXBizEntryActivity", "launchOpenTypeWebView get url from intent failed : %s", e.getMessage());
            AppMethodBeat.o(18153);
        }
    }

    static /* synthetic */ void c(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.i(18156);
        ab.i("MicroMsg.WXBizEntryActivity", "offlinePayBackToApp: %s", wXBizEntryActivity.getIntent().getStringExtra("key_app_id"));
        f bT = g.bT(r0, true);
        if (bT == null) {
            ab.w("MicroMsg.WXBizEntryActivity", "can not find app info");
            AppMethodBeat.o(18156);
            return;
        }
        Bundle bundle = new Bundle();
        BaseResp resp = new Resp();
        resp.errCode = -3;
        a(bundle, resp, bT);
        AppMethodBeat.o(18156);
    }
}
