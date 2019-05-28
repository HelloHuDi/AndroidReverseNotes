package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private static final String mVL = (b.eSn + "Game/HvMenu/");

    interface a {
        void onComplete();
    }

    static /* synthetic */ void b(List list, a aVar) {
        AppMethodBeat.i(111243);
        a(list, aVar);
        AppMethodBeat.o(111243);
    }

    static {
        AppMethodBeat.i(111244);
        AppMethodBeat.o(111244);
    }

    public static void a(gu guVar) {
        AppMethodBeat.i(111239);
        ab.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", Integer.valueOf(guVar.cBw.Cn));
        Context context;
        JSONObject jSONObject;
        switch (guVar.cBw.Cn) {
            case 1:
                context = guVar.cBw.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a dX = e.dX(context);
                    if (dX != null) {
                        try {
                            jSONObject.put("gameRegionName", e.a(dX));
                        } catch (JSONException e) {
                        }
                    }
                    guVar.cBx.result = jSONObject.toString();
                }
                AppMethodBeat.o(111239);
                return;
            case 2:
                final String str = guVar.cBw.cBy;
                ab.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", str);
                if (!bo.isNullOrNil(str)) {
                    g.Rg().a(1369, new com.tencent.mm.ai.f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(111236);
                            if (i == 0 && i2 == 0) {
                                ab.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", str);
                                g.Rg().b(1369, (com.tencent.mm.ai.f) this);
                                final asm asm = (asm) ((as) mVar).lty.fsH.fsP;
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(111235);
                                        f.a(asm, str);
                                        AppMethodBeat.o(111235);
                                    }
                                });
                                AppMethodBeat.o(111236);
                                return;
                            }
                            ab.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", str);
                            AppMethodBeat.o(111236);
                        }
                    });
                    g.Rg().a(new as(str), 0);
                }
                AppMethodBeat.o(111239);
                return;
            case 3:
                String str2 = guVar.cBw.cBy;
                ab.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", str2);
                if (!bo.isNullOrNil(str2)) {
                    byte[] NK = ((c) g.K(c.class)).bCZ().NK("pb_game_hv_menu_".concat(String.valueOf(str2)));
                    if (!bo.cb(NK)) {
                        try {
                            guVar.cBx.result = new String(NK, "ISO-8859-1");
                            ab.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", str2);
                            AppMethodBeat.o(111239);
                            return;
                        } catch (UnsupportedEncodingException e2) {
                        }
                    }
                }
                AppMethodBeat.o(111239);
                return;
            case 4:
                b(guVar);
                AppMethodBeat.o(111239);
                return;
            case 5:
                com.tencent.mm.plugin.game.commlib.b.bDn().hI(true);
                break;
            case 10001:
                context = guVar.cBw.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    Object ef = e.ef(context);
                    if (bo.isNullOrNil(ef)) {
                        ef = e.bDS();
                    }
                    try {
                        jSONObject.put("regionCode", ef);
                    } catch (JSONException e3) {
                    }
                    guVar.cBx.result = jSONObject.toString();
                }
                AppMethodBeat.o(111239);
                return;
        }
        AppMethodBeat.o(111239);
    }

    private static void a(final List<bbb> list, final a aVar) {
        AppMethodBeat.i(111240);
        if (bo.ek(list)) {
            if (aVar != null) {
                aVar.onComplete();
            }
            AppMethodBeat.o(111240);
            return;
        }
        final bbb bbb = (bbb) list.remove(0);
        if (bbb == null || bo.isNullOrNil(bbb.ThumbUrl)) {
            ab.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
            AppMethodBeat.o(111240);
            return;
        }
        String str = mVL + com.tencent.mm.a.g.x(bbb.ThumbUrl.getBytes());
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePH = true;
        aVar2.ePJ = str;
        o.ahp().a(bbb.ThumbUrl, aVar2.ahG(), new com.tencent.mm.at.a.c.c() {
            public final void a(boolean z, Object... objArr) {
                AppMethodBeat.i(111238);
                if (z) {
                    ab.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", bbb.ThumbUrl);
                    f.b(list, aVar);
                }
                AppMethodBeat.o(111238);
            }
        });
        AppMethodBeat.o(111240);
    }

    private static void b(gu guVar) {
        AppMethodBeat.i(111241);
        String str = guVar.cBw.cBy;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111241);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = bo.getInt(jSONObject.getString("game_page_report_id"), 0);
            boolean z = jSONObject.getBoolean("game_page_report_instantly");
            str = jSONObject.optString("game_page_report_format_data");
            String optString = jSONObject.optString("game_page_report_tabs_format_data");
            ab.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", Integer.valueOf(i), Boolean.valueOf(z), str, optString);
            if (i == 0) {
                ab.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
                AppMethodBeat.o(111241);
            } else if (bo.isNullOrNil(str)) {
                if (!bo.isNullOrNil(optString)) {
                    try {
                        JSONArray jSONArray = new JSONArray(optString);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            optString = jSONArray.getString(i2);
                            if (!bo.isNullOrNil(optString)) {
                                if (z) {
                                    com.tencent.mm.plugin.game.e.a.aL(i, optString);
                                } else {
                                    h.pYm.X(i, optString);
                                }
                            }
                        }
                        AppMethodBeat.o(111241);
                        return;
                    } catch (JSONException e) {
                        ab.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", e.getMessage());
                    }
                }
                AppMethodBeat.o(111241);
            } else if (z) {
                com.tencent.mm.plugin.game.e.a.aL(i, str);
                AppMethodBeat.o(111241);
            } else {
                h.pYm.X(i, str);
                AppMethodBeat.o(111241);
            }
        } catch (JSONException e2) {
            ab.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", e2.getMessage());
            AppMethodBeat.o(111241);
        }
    }
}
