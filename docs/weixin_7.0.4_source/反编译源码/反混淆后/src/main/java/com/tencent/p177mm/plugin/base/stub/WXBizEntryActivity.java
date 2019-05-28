package com.tencent.p177mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.base.stub.C33716e.C199961;
import com.tencent.p177mm.plugin.base.stub.C38669d.C27497a;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.C14827e.C14831a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.protocal.protobuf.C35913df;
import com.tencent.p177mm.protocal.protobuf.ciq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity */
public class WXBizEntryActivity extends AutoLoginActivity {
    private int jDy;

    /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$4 */
    class C111624 implements C14831a {

        /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$4$1 */
        class C111591 implements OnClickListener {
            C111591() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18139);
                WXBizEntryActivity.m18871b(WXBizEntryActivity.this);
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18139);
            }
        }

        C111624() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18140);
            C4990ab.m7417i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
            if (c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z)) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18140);
                return;
            }
            ciq ajE = ((C26475z) c1207m).ajE();
            if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18140);
                return;
            }
            C30379h.m48447a(WXBizEntryActivity.this, C5046bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(C25738R.string.f9238tz), WXBizEntryActivity.this.getString(C25738R.string.f9187s6), false, new C111591());
            AppMethodBeat.m2505o(18140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$6 */
    class C111636 implements C14831a {
        C111636() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18144);
            C4990ab.m7417i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
            if (c1207m == null || (((z || C5046bo.isNullOrNil(str)) && (i == 0 || i2 == 0)) || !(c1207m instanceof C26475z))) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18144);
                return;
            }
            ciq ajE = ((C26475z) c1207m).ajE();
            if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18144);
                return;
            }
            final String nullAsNil = C5046bo.nullAsNil(C5046bo.m7532bc(ajE.xhy, str));
            C30379h.m48447a(WXBizEntryActivity.this, nullAsNil, WXBizEntryActivity.this.getString(C25738R.string.f9238tz), WXBizEntryActivity.this.getString(C25738R.string.f9187s6), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(18143);
                    WXBizEntryActivity.m18869a(WXBizEntryActivity.this, nullAsNil);
                    WXBizEntryActivity.this.finish();
                    AppMethodBeat.m2505o(18143);
                }
            });
            AppMethodBeat.m2505o(18144);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$7 */
    class C111657 implements C14831a {

        /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$7$1 */
        class C111661 implements OnClickListener {
            C111661() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18145);
                WXBizEntryActivity.m18872c(WXBizEntryActivity.this);
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18145);
            }
        }

        C111657() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18146);
            C4990ab.m7417i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
            if (c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z)) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18146);
                return;
            }
            ciq ajE = ((C26475z) c1207m).ajE();
            if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18146);
                return;
            }
            C30379h.m48447a(WXBizEntryActivity.this, C5046bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(C25738R.string.f9238tz), WXBizEntryActivity.this.getString(C25738R.string.f9187s6), false, new C111661());
            AppMethodBeat.m2505o(18146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$1 */
    class C111671 implements C27497a {
        C111671() {
        }

        /* renamed from: ft */
        public final void mo11382ft(boolean z) {
            AppMethodBeat.m2504i(18135);
            if (z) {
                C25985d.m41472c(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent());
            } else {
                C4990ab.m7412e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
            }
            WXBizEntryActivity.this.finish();
            AppMethodBeat.m2505o(18135);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$3 */
    class C111683 implements C14831a {

        /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$3$1 */
        class C111691 implements OnClickListener {
            C111691() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18137);
                WXBizEntryActivity.m18868a(WXBizEntryActivity.this);
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18137);
            }
        }

        C111683() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18138);
            C4990ab.m7417i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
            if (c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z)) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18138);
                return;
            }
            ciq ajE = ((C26475z) c1207m).ajE();
            if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                WXBizEntryActivity.this.finish();
                AppMethodBeat.m2505o(18138);
                return;
            }
            C30379h.m48447a(WXBizEntryActivity.this, C5046bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(C25738R.string.f9238tz), WXBizEntryActivity.this.getString(C25738R.string.f9187s6), false, new C111691());
            AppMethodBeat.m2505o(18138);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXBizEntryActivity$2 */
    class C111702 implements Runnable {
        C111702() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18136);
            WXBizEntryActivity.this.findViewById(2131821801).setVisibility(8);
            AppMethodBeat.m2505o(18136);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18148);
        super.onCreate(bundle);
        setTitleVisibility(0);
        AppMethodBeat.m2505o(18148);
    }

    public final int getLayoutId() {
        return 2130968856;
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        return true;
    }

    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        Uri uri = null;
        AppMethodBeat.m2504i(18149);
        C4990ab.m7416i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(c4737a)));
        if (getIntent() != null) {
            this.jDy = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (c4737a) {
            case LOGIN_OK:
                C4990ab.m7417i("MicroMsg.WXBizEntryActivity", "req type = %d", Integer.valueOf(this.jDy));
                Intent intent2;
                Uri data;
                switch (this.jDy) {
                    case 7:
                    case 8:
                        intent2 = getIntent();
                        intent2.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
                        startActivity(intent2);
                        finish();
                        AppMethodBeat.m2505o(18149);
                        return;
                    case 9:
                        C25985d.m41472c((Context) this, "card", ".ui.CardAddEntranceUI", getIntent());
                        finish();
                        AppMethodBeat.m2505o(18149);
                        return;
                    case 11:
                        intent2 = getIntent();
                        intent2.putExtra("device_type", 1);
                        C25985d.m41472c((Context) this, "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                        finish();
                        AppMethodBeat.m2505o(18149);
                        return;
                    case 12:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                        }
                        if (uri != null && C14827e.ain(uri.toString())) {
                            C37922v.m64076Zp().mo60674nV("key_data_center_session_id");
                            C14827e.m23070a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new C111683(), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.m2505o(18149);
                            return;
                        }
                    case 13:
                        intent2 = getIntent();
                        intent2.putExtra("key_static_from_scene", 100001);
                        C25985d.m41472c((Context) this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
                        finish();
                        AppMethodBeat.m2505o(18149);
                        return;
                    case 14:
                    case 15:
                        new C2677a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new C111671()).aVi();
                        AppMethodBeat.m2505o(18149);
                        return;
                    case 16:
                        C25985d.m41472c((Context) this, "card", ".ui.CardListSelectedUI", getIntent());
                        finish();
                        AppMethodBeat.m2505o(18149);
                        return;
                    case 17:
                        try {
                            data = getIntent().getData();
                            C111702 c111702 = new C111702();
                            String stringExtra = getIntent().getStringExtra("key_package_name");
                            String stringExtra2 = getIntent().getStringExtra("key_package_signature");
                            int intExtra = getIntent().getIntExtra("translate_link_scene", 1);
                            C4990ab.m7411d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", stringExtra, stringExtra2);
                            if (C5046bo.isNullOrNil(stringExtra) || C5046bo.isNullOrNil(stringExtra2)) {
                                C4990ab.m7412e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
                                AppMethodBeat.m2505o(18149);
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            C35913df c35913df = new C35913df();
                            C4990ab.m7417i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", stringExtra);
                            c35913df.kKO = stringExtra;
                            c35913df.signature = stringExtra2;
                            linkedList.add(c35913df);
                            C1207m c26475z = new C26475z(data.toString(), intExtra, linkedList);
                            C9638aw.m17182Rg().mo14539a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new C199961(this, c111702));
                            C9638aw.m17182Rg().mo14541a(c26475z, 0);
                            AppMethodBeat.m2505o(18149);
                            return;
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", e2.getMessage());
                            AppMethodBeat.m2505o(18149);
                            return;
                        }
                    case 19:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e22) {
                            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", e22.getMessage());
                        }
                        if (uri != null) {
                            final String queryParameter = uri.getQueryParameter("invokeData");
                            C14827e.m23070a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new C14831a() {
                                /* renamed from: a */
                                public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
                                    AppMethodBeat.m2504i(18142);
                                    C4990ab.m7417i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z)) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.m2505o(18142);
                                        return;
                                    }
                                    final ciq ajE = ((C26475z) c1207m).ajE();
                                    if (ajE == null || WXBizEntryActivity.this.isFinishing()) {
                                        WXBizEntryActivity.this.finish();
                                        AppMethodBeat.m2505o(18142);
                                        return;
                                    }
                                    C30379h.m48447a(WXBizEntryActivity.this, C5046bo.nullAsNil(ajE.xhy), WXBizEntryActivity.this.getString(C25738R.string.f9238tz), WXBizEntryActivity.this.getString(C25738R.string.f9187s6), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.m2504i(18141);
                                            WXBizEntryActivity.m18870a(WXBizEntryActivity.this, queryParameter, ajE.xhy);
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.m2505o(18141);
                                        }
                                    });
                                    AppMethodBeat.m2505o(18142);
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.m2505o(18149);
                            return;
                        }
                        break;
                    case 24:
                        try {
                            data = getIntent().getData();
                        } catch (Exception e222) {
                            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", e222.getMessage());
                            data = uri;
                        }
                        if (data != null) {
                            C14827e.m23070a((Context) this, data.toString(), getIntent().getIntExtra("translate_link_scene", 1), new C111657(), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.m2505o(18149);
                            return;
                        }
                        break;
                    case 25:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e2222) {
                            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e2222.getMessage());
                        }
                        if (uri != null && C14827e.aio(uri.toString())) {
                            C37922v.m64076Zp().mo60674nV("key_data_center_session_id");
                            C14827e.m23070a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new C111624(), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.m2505o(18149);
                            return;
                        }
                    case 26:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e22222) {
                            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", e22222.getMessage());
                        }
                        if (uri != null) {
                            C14827e.m23070a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new C111636(), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            AppMethodBeat.m2505o(18149);
                            return;
                        }
                        break;
                    default:
                        finish();
                        break;
                }
                AppMethodBeat.m2505o(18149);
                return;
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                C4990ab.m7412e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(c4737a)));
                break;
            default:
                C4990ab.m7412e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(c4737a)));
                break;
        }
        finish();
        AppMethodBeat.m2505o(18149);
    }

    /* renamed from: a */
    private static void m18867a(Bundle bundle, BaseResp baseResp, C40439f c40439f) {
        AppMethodBeat.m2504i(18150);
        baseResp.toBundle(bundle);
        Args args = new Args();
        args.targetPkgName = c40439f.field_packageName;
        args.bundle = bundle;
        C35799p.m58687at(bundle);
        C35799p.m58688au(bundle);
        MMessageActV2.send(C4996ah.getContext(), args);
        AppMethodBeat.m2505o(18150);
    }

    /* renamed from: dc */
    private static void m18873dc(String str, String str2) {
        AppMethodBeat.m2504i(18151);
        C40439f bT = C46494g.m87739bT(str, true);
        if (bT == null) {
            AppMethodBeat.m2505o(18151);
            return;
        }
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.extInfo = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
        wXMediaMessage.sdkVer = Build.SDK_INT;
        wXMediaMessage.messageExt = str2;
        C46494g.m87727a(C4996ah.getContext(), bT.field_appId, wXMediaMessage, 2, null, null);
        AppMethodBeat.m2505o(18151);
    }

    /* renamed from: a */
    static /* synthetic */ void m18868a(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.m2504i(18152);
        try {
            Uri data = wXBizEntryActivity.getIntent().getData();
            int i = C5046bo.getInt(data.getQueryParameter("type"), 0);
            WXBizEntryActivity.m18873dc(C5046bo.nullAsNil(data.getQueryParameter("appid")), String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", new Object[]{C5046bo.nullAsNil(data.getQueryParameter("appid")), Integer.valueOf(i), Integer.valueOf(-3)}));
            AppMethodBeat.m2505o(18152);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "launchOpenTypeWebView get url from intent failed : %s", e.getMessage());
            AppMethodBeat.m2505o(18152);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m18871b(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.m2504i(18153);
        try {
            Uri data = wXBizEntryActivity.getIntent().getData();
            int i = C5046bo.getInt(data.getQueryParameter("type"), 0);
            WXBizEntryActivity.m18873dc(C5046bo.nullAsNil(data.getQueryParameter("appid")), String.format("%s://openbusinesswebview?type=%d&ret=%d", new Object[]{C5046bo.nullAsNil(data.getQueryParameter("appid")), Integer.valueOf(i), Integer.valueOf(-3)}));
            AppMethodBeat.m2505o(18153);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WXBizEntryActivity", "launchOpenTypeWebView get url from intent failed : %s", e.getMessage());
            AppMethodBeat.m2505o(18153);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m18872c(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.m2504i(18156);
        C4990ab.m7417i("MicroMsg.WXBizEntryActivity", "offlinePayBackToApp: %s", wXBizEntryActivity.getIntent().getStringExtra("key_app_id"));
        C40439f bT = C46494g.m87739bT(r0, true);
        if (bT == null) {
            C4990ab.m7420w("MicroMsg.WXBizEntryActivity", "can not find app info");
            AppMethodBeat.m2505o(18156);
            return;
        }
        Bundle bundle = new Bundle();
        BaseResp resp = new Resp();
        resp.errCode = -3;
        WXBizEntryActivity.m18867a(bundle, resp, bT);
        AppMethodBeat.m2505o(18156);
    }
}
