package com.tencent.p177mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C45158c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.plugin.game.commlib.C20945b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p433ui.GameRegionPreference.C3265a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.asm;
import com.tencent.p177mm.protocal.protobuf.bbb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.model.f */
public final class C43189f {
    private static final String mVL = (C1761b.eSn + "Game/HvMenu/");

    /* renamed from: com.tencent.mm.plugin.game.model.f$a */
    interface C12168a {
        void onComplete();
    }

    /* renamed from: b */
    static /* synthetic */ void m76766b(List list, C12168a c12168a) {
        AppMethodBeat.m2504i(111243);
        C43189f.m76764a(list, c12168a);
        AppMethodBeat.m2505o(111243);
    }

    static {
        AppMethodBeat.m2504i(111244);
        AppMethodBeat.m2505o(111244);
    }

    /* renamed from: a */
    public static void m76762a(C9367gu c9367gu) {
        AppMethodBeat.m2504i(111239);
        C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", Integer.valueOf(c9367gu.cBw.f2862Cn));
        Context context;
        JSONObject jSONObject;
        switch (c9367gu.cBw.f2862Cn) {
            case 1:
                context = c9367gu.cBw.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    C3265a dX = C20993e.m32271dX(context);
                    if (dX != null) {
                        try {
                            jSONObject.put("gameRegionName", C20993e.m32261a(dX));
                        } catch (JSONException e) {
                        }
                    }
                    c9367gu.cBx.result = jSONObject.toString();
                }
                AppMethodBeat.m2505o(111239);
                return;
            case 2:
                final String str = c9367gu.cBw.cBy;
                C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", str);
                if (!C5046bo.isNullOrNil(str)) {
                    C1720g.m3540Rg().mo14539a(1369, new C1202f() {
                        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                            AppMethodBeat.m2504i(111236);
                            if (i == 0 && i2 == 0) {
                                C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", str);
                                C1720g.m3540Rg().mo14546b(1369, (C1202f) this);
                                final asm asm = (asm) ((C28222as) c1207m).lty.fsH.fsP;
                                C5004al.m7441d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(111235);
                                        C43189f.m76763a(asm, str);
                                        AppMethodBeat.m2505o(111235);
                                    }
                                });
                                AppMethodBeat.m2505o(111236);
                                return;
                            }
                            C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", str);
                            AppMethodBeat.m2505o(111236);
                        }
                    });
                    C1720g.m3540Rg().mo14541a(new C28222as(str), 0);
                }
                AppMethodBeat.m2505o(111239);
                return;
            case 3:
                String str2 = c9367gu.cBw.cBy;
                C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", str2);
                if (!C5046bo.isNullOrNil(str2)) {
                    byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK("pb_game_hv_menu_".concat(String.valueOf(str2)));
                    if (!C5046bo.m7540cb(NK)) {
                        try {
                            c9367gu.cBx.result = new String(NK, "ISO-8859-1");
                            C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", str2);
                            AppMethodBeat.m2505o(111239);
                            return;
                        } catch (UnsupportedEncodingException e2) {
                        }
                    }
                }
                AppMethodBeat.m2505o(111239);
                return;
            case 4:
                C43189f.m76765b(c9367gu);
                AppMethodBeat.m2505o(111239);
                return;
            case 5:
                C20945b.bDn().mo36287hI(true);
                break;
            case 10001:
                context = c9367gu.cBw.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    Object ef = C20993e.m32279ef(context);
                    if (C5046bo.isNullOrNil(ef)) {
                        ef = C20993e.bDS();
                    }
                    try {
                        jSONObject.put("regionCode", ef);
                    } catch (JSONException e3) {
                    }
                    c9367gu.cBx.result = jSONObject.toString();
                }
                AppMethodBeat.m2505o(111239);
                return;
        }
        AppMethodBeat.m2505o(111239);
    }

    /* renamed from: a */
    private static void m76764a(final List<bbb> list, final C12168a c12168a) {
        AppMethodBeat.m2504i(111240);
        if (C5046bo.m7548ek(list)) {
            if (c12168a != null) {
                c12168a.onComplete();
            }
            AppMethodBeat.m2505o(111240);
            return;
        }
        final bbb bbb = (bbb) list.remove(0);
        if (bbb == null || C5046bo.isNullOrNil(bbb.ThumbUrl)) {
            C4990ab.m7412e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
            AppMethodBeat.m2505o(111240);
            return;
        }
        String str = mVL + C1178g.m2591x(bbb.ThumbUrl.getBytes());
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePJ = str;
        C32291o.ahp().mo43771a(bbb.ThumbUrl, c17927a.ahG(), new C45158c() {
            /* renamed from: a */
            public final void mo15193a(boolean z, Object... objArr) {
                AppMethodBeat.m2504i(111238);
                if (z) {
                    C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", bbb.ThumbUrl);
                    C43189f.m76766b(list, c12168a);
                }
                AppMethodBeat.m2505o(111238);
            }
        });
        AppMethodBeat.m2505o(111240);
    }

    /* renamed from: b */
    private static void m76765b(C9367gu c9367gu) {
        AppMethodBeat.m2504i(111241);
        String str = c9367gu.cBw.cBy;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111241);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = C5046bo.getInt(jSONObject.getString("game_page_report_id"), 0);
            boolean z = jSONObject.getBoolean("game_page_report_instantly");
            str = jSONObject.optString("game_page_report_format_data");
            String optString = jSONObject.optString("game_page_report_tabs_format_data");
            C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", Integer.valueOf(i), Boolean.valueOf(z), str, optString);
            if (i == 0) {
                C4990ab.m7416i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
                AppMethodBeat.m2505o(111241);
            } else if (C5046bo.isNullOrNil(str)) {
                if (!C5046bo.isNullOrNil(optString)) {
                    try {
                        JSONArray jSONArray = new JSONArray(optString);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            optString = jSONArray.getString(i2);
                            if (!C5046bo.isNullOrNil(optString)) {
                                if (z) {
                                    C34276a.m56206aL(i, optString);
                                } else {
                                    C7060h.pYm.mo8374X(i, optString);
                                }
                            }
                        }
                        AppMethodBeat.m2505o(111241);
                        return;
                    } catch (JSONException e) {
                        C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(111241);
            } else if (z) {
                C34276a.m56206aL(i, str);
                AppMethodBeat.m2505o(111241);
            } else {
                C7060h.pYm.mo8374X(i, str);
                AppMethodBeat.m2505o(111241);
            }
        } catch (JSONException e2) {
            C4990ab.m7417i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", e2.getMessage());
            AppMethodBeat.m2505o(111241);
        }
    }
}
