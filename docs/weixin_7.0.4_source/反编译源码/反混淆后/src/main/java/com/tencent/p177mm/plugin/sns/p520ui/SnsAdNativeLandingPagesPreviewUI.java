package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29064ad;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39787m;
import com.tencent.p177mm.plugin.sns.storage.C43574x;
import com.tencent.p177mm.protocal.protobuf.adw;
import com.tencent.p177mm.protocal.protobuf.adx;
import com.tencent.p177mm.protocal.protobuf.akz;
import com.tencent.p177mm.protocal.protobuf.ala;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI */
public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m77962a(SnsAdNativeLandingPagesPreviewUI snsAdNativeLandingPagesPreviewUI, Intent intent, String str) {
        AppMethodBeat.m2504i(38612);
        boolean g = snsAdNativeLandingPagesPreviewUI.m77964g(intent, str);
        AppMethodBeat.m2505o(38612);
        return g;
    }

    /* renamed from: h */
    static /* synthetic */ boolean m77965h(Intent intent, String str) {
        AppMethodBeat.m2504i(38611);
        boolean f = SnsAdNativeLandingPagesPreviewUI.m77963f(intent, str);
        AppMethodBeat.m2505o(38611);
        return f;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38608);
        super.onCreate(bundle);
        C29064ad.m46205ac(this);
        final Intent intent = getIntent();
        if (intent == null) {
            finish();
            AppMethodBeat.m2505o(38608);
            return;
        }
        CharSequence stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        final int i = intent.hasExtra("sns_landing_pages_canvasid") ? 1 : 0;
        final long longExtra = intent.getLongExtra("sns_landing_pages_pageid", 0);
        final String stringExtra2 = intent.getStringExtra("sns_landing_pages_canvasid");
        final String stringExtra3 = intent.getStringExtra("sns_landing_pages_canvas_ext");
        if (TextUtils.isEmpty(stringExtra)) {
            if (intent.getIntExtra("sns_landing_pages_no_store", 0) != 1) {
                if (i == 1) {
                    stringExtra = C39787m.cqn().mo62907j(stringExtra2, stringExtra3, 0, 0);
                } else {
                    stringExtra = C39787m.cqn().mo62908n(longExtra, 0, 0);
                }
                intent.putExtra("sns_landing_pages_xml", stringExtra);
            }
        } else if (!SnsAdNativeLandingPagesPreviewUI.m77963f(intent, stringExtra)) {
            finish();
            AppMethodBeat.m2505o(38608);
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            C7472b c7472b;
            final View findViewById = findViewById(2131821219);
            findViewById.setVisibility(0);
            C1196a c1196a = new C1196a();
            C7472b acD;
            if (i == 0 && longExtra > 0) {
                C4990ab.m7417i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", Long.valueOf(longExtra));
                c1196a.fsJ = new adw();
                c1196a.fsK = new adx();
                c1196a.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
                c1196a.fsI = 1286;
                acD = c1196a.acD();
                ((adw) acD.fsG.fsP).wlV = longExtra;
                c7472b = acD;
            } else if (i != 1 || C5046bo.isNullOrNil(stringExtra2)) {
                C4990ab.m7412e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
                finish();
                AppMethodBeat.m2505o(38608);
                return;
            } else {
                C4990ab.m7417i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", stringExtra2);
                c1196a.fsJ = new akz();
                c1196a.fsK = new ala();
                c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
                c1196a.fsI = 1890;
                acD = c1196a.acD();
                akz akz = (akz) acD.fsG.fsP;
                akz.wqx = stringExtra2;
                akz.wqy = stringExtra3;
                c7472b = acD;
            }
            C1226w.m2656a(c7472b, new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(38607);
                    findViewById.setVisibility(8);
                    if (i == 0 && i2 == 0) {
                        if (i == 1) {
                            String dlY = ((ala) c7472b.fsH.fsP).wqz.dlY();
                            C4990ab.m7417i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", stringExtra2, stringExtra3, dlY);
                            if (!TextUtils.isEmpty(dlY)) {
                                intent.putExtra("sns_landing_pages_xml", dlY);
                                if (SnsAdNativeLandingPagesPreviewUI.m77965h(intent, dlY)) {
                                    SnsAdNativeLandingPagesPreviewUI.m77962a(SnsAdNativeLandingPagesPreviewUI.this, intent, dlY);
                                    C39787m cqn = C39787m.cqn();
                                    String str2 = stringExtra2;
                                    String str3 = stringExtra3;
                                    if (!(TextUtils.isEmpty(dlY) || TextUtils.isEmpty(str2))) {
                                        Object obj;
                                        if (C5046bo.isNullOrNil(str3)) {
                                            String obj2 = str2;
                                        } else {
                                            obj2 = str2 + str3;
                                        }
                                        cqn.reP.put(obj2, dlY);
                                        C43574x c43574x = new C43574x();
                                        c43574x.field_canvasId = str2;
                                        c43574x.field_canvasXml = dlY;
                                        c43574x.field_canvasExt = str3;
                                        cqn.reO.mo55582a(c43574x);
                                    }
                                } else {
                                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                                    AppMethodBeat.m2505o(38607);
                                    return 0;
                                }
                            }
                        }
                        adx adx = (adx) c7472b.fsH.fsP;
                        C4990ab.m7417i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(longExtra), adx.wlW);
                        if (!TextUtils.isEmpty(adx.wlW)) {
                            intent.putExtra("sns_landing_pages_xml", adx.wlW);
                            if (SnsAdNativeLandingPagesPreviewUI.m77965h(intent, adx.wlW)) {
                                SnsAdNativeLandingPagesPreviewUI.m77962a(SnsAdNativeLandingPagesPreviewUI.this, intent, adx.wlW);
                                C39787m.cqn().mo62909u(longExtra, adx.wlW);
                            } else {
                                SnsAdNativeLandingPagesPreviewUI.this.finish();
                                AppMethodBeat.m2505o(38607);
                                return 0;
                            }
                        }
                    } else if (i == 1) {
                        C4990ab.m7413e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", stringExtra2, stringExtra3, Integer.valueOf(i), Integer.valueOf(i2));
                    } else {
                        C4990ab.m7413e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", Long.valueOf(longExtra), Integer.valueOf(i), Integer.valueOf(i2));
                    }
                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                    AppMethodBeat.m2505o(38607);
                    return 0;
                }
            }, false, this);
            AppMethodBeat.m2505o(38608);
        } else if (m77964g(intent, stringExtra)) {
            AppMethodBeat.m2505o(38608);
        } else {
            finish();
            AppMethodBeat.m2505o(38608);
        }
    }

    /* renamed from: f */
    private static boolean m77963f(Intent intent, String str) {
        AppMethodBeat.m2504i(38609);
        if (!C5046bo.isNullOrNil(str) && C29064ad.m46201YK(str)) {
            String YL = C29064ad.m46202YL(str);
            if (C5046bo.isNullOrNil(YL)) {
                AppMethodBeat.m2505o(38609);
                return false;
            }
            intent.putExtra("sns_landing_pages_xml", "");
            intent.putExtra("sns_landing_pages_too_large_xml_path", YL);
        }
        AppMethodBeat.m2505o(38609);
        return true;
    }

    /* renamed from: g */
    private boolean m77964g(Intent intent, String str) {
        AppMethodBeat.m2504i(38610);
        if (C3953i.m6288YO(str)) {
            intent.setClass(this, SnsAdNativeLandingPagesUI.class);
            startActivity(intent);
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
            } else {
                overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
            }
            AppMethodBeat.m2505o(38610);
            return true;
        }
        C4990ab.m7416i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(str)));
        int indexOf = str.indexOf("<shareWebUrl>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</shareWebUrl>");
            if (indexOf2 > indexOf + 13) {
                String substring = str.substring(indexOf + 13, indexOf2);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", substring);
                intent2.putExtra("showShare", true);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                finish();
                overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                AppMethodBeat.m2505o(38610);
                return true;
            }
        }
        AppMethodBeat.m2505o(38610);
        return false;
    }

    public final int getLayoutId() {
        return 2130970734;
    }
}
