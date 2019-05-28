package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(SnsAdNativeLandingPagesPreviewUI snsAdNativeLandingPagesPreviewUI, Intent intent, String str) {
        AppMethodBeat.i(38612);
        boolean g = snsAdNativeLandingPagesPreviewUI.g(intent, str);
        AppMethodBeat.o(38612);
        return g;
    }

    static /* synthetic */ boolean h(Intent intent, String str) {
        AppMethodBeat.i(38611);
        boolean f = f(intent, str);
        AppMethodBeat.o(38611);
        return f;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38608);
        super.onCreate(bundle);
        ad.ac(this);
        final Intent intent = getIntent();
        if (intent == null) {
            finish();
            AppMethodBeat.o(38608);
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
                    stringExtra = m.cqn().j(stringExtra2, stringExtra3, 0, 0);
                } else {
                    stringExtra = m.cqn().n(longExtra, 0, 0);
                }
                intent.putExtra("sns_landing_pages_xml", stringExtra);
            }
        } else if (!f(intent, stringExtra)) {
            finish();
            AppMethodBeat.o(38608);
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            b bVar;
            final View findViewById = findViewById(R.id.rj);
            findViewById.setVisibility(0);
            b.a aVar = new b.a();
            b acD;
            if (i == 0 && longExtra > 0) {
                ab.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", Long.valueOf(longExtra));
                aVar.fsJ = new adw();
                aVar.fsK = new adx();
                aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
                aVar.fsI = 1286;
                acD = aVar.acD();
                ((adw) acD.fsG.fsP).wlV = longExtra;
                bVar = acD;
            } else if (i != 1 || bo.isNullOrNil(stringExtra2)) {
                ab.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
                finish();
                AppMethodBeat.o(38608);
                return;
            } else {
                ab.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", stringExtra2);
                aVar.fsJ = new akz();
                aVar.fsK = new ala();
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
                aVar.fsI = 1890;
                acD = aVar.acD();
                akz akz = (akz) acD.fsG.fsP;
                akz.wqx = stringExtra2;
                akz.wqy = stringExtra3;
                bVar = acD;
            }
            w.a(bVar, new w.a() {
                public final int a(int i, int i2, String str, b bVar, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(38607);
                    findViewById.setVisibility(8);
                    if (i == 0 && i2 == 0) {
                        if (i == 1) {
                            String dlY = ((ala) bVar.fsH.fsP).wqz.dlY();
                            ab.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", stringExtra2, stringExtra3, dlY);
                            if (!TextUtils.isEmpty(dlY)) {
                                intent.putExtra("sns_landing_pages_xml", dlY);
                                if (SnsAdNativeLandingPagesPreviewUI.h(intent, dlY)) {
                                    SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, intent, dlY);
                                    m cqn = m.cqn();
                                    String str2 = stringExtra2;
                                    String str3 = stringExtra3;
                                    if (!(TextUtils.isEmpty(dlY) || TextUtils.isEmpty(str2))) {
                                        Object obj;
                                        if (bo.isNullOrNil(str3)) {
                                            String obj2 = str2;
                                        } else {
                                            obj2 = str2 + str3;
                                        }
                                        cqn.reP.put(obj2, dlY);
                                        x xVar = new x();
                                        xVar.field_canvasId = str2;
                                        xVar.field_canvasXml = dlY;
                                        xVar.field_canvasExt = str3;
                                        cqn.reO.a(xVar);
                                    }
                                } else {
                                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                                    AppMethodBeat.o(38607);
                                    return 0;
                                }
                            }
                        }
                        adx adx = (adx) bVar.fsH.fsP;
                        ab.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(longExtra), adx.wlW);
                        if (!TextUtils.isEmpty(adx.wlW)) {
                            intent.putExtra("sns_landing_pages_xml", adx.wlW);
                            if (SnsAdNativeLandingPagesPreviewUI.h(intent, adx.wlW)) {
                                SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, intent, adx.wlW);
                                m.cqn().u(longExtra, adx.wlW);
                            } else {
                                SnsAdNativeLandingPagesPreviewUI.this.finish();
                                AppMethodBeat.o(38607);
                                return 0;
                            }
                        }
                    } else if (i == 1) {
                        ab.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", stringExtra2, stringExtra3, Integer.valueOf(i), Integer.valueOf(i2));
                    } else {
                        ab.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", Long.valueOf(longExtra), Integer.valueOf(i), Integer.valueOf(i2));
                    }
                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                    AppMethodBeat.o(38607);
                    return 0;
                }
            }, false, this);
            AppMethodBeat.o(38608);
        } else if (g(intent, stringExtra)) {
            AppMethodBeat.o(38608);
        } else {
            finish();
            AppMethodBeat.o(38608);
        }
    }

    private static boolean f(Intent intent, String str) {
        AppMethodBeat.i(38609);
        if (!bo.isNullOrNil(str) && ad.YK(str)) {
            String YL = ad.YL(str);
            if (bo.isNullOrNil(YL)) {
                AppMethodBeat.o(38609);
                return false;
            }
            intent.putExtra("sns_landing_pages_xml", "");
            intent.putExtra("sns_landing_pages_too_large_xml_path", YL);
        }
        AppMethodBeat.o(38609);
        return true;
    }

    private boolean g(Intent intent, String str) {
        AppMethodBeat.i(38610);
        if (i.YO(str)) {
            intent.setClass(this, SnsAdNativeLandingPagesUI.class);
            startActivity(intent);
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
            } else {
                overridePendingTransition(R.anim.df, R.anim.dc);
            }
            AppMethodBeat.o(38610);
            return true;
        }
        ab.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(str)));
        int indexOf = str.indexOf("<shareWebUrl>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</shareWebUrl>");
            if (indexOf2 > indexOf + 13) {
                String substring = str.substring(indexOf + 13, indexOf2);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", substring);
                intent2.putExtra("showShare", true);
                d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                finish();
                overridePendingTransition(R.anim.df, R.anim.dc);
                AppMethodBeat.o(38610);
                return true;
            }
        }
        AppMethodBeat.o(38610);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.auh;
    }
}
