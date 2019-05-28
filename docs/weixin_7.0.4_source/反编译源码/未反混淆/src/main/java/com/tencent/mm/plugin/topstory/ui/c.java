package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout.e;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.te;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static com.tencent.mm.at.a.a.c sBm;
    public static com.tencent.mm.at.a.a.c sBn;

    public static class b {
        public String cEh = "";
        public int category = 0;
        public TextView gne;
        public TextView sBA;
        public View sBB;
        public boolean sBs;
        public String sBt = "";
        public int sBu = 0;
        public int sBv = 0;
        public String sBw = "";
        public String sBx = "";
        public e sBy;
        public View sBz;

        public final void bn(int i, String str) {
            AppMethodBeat.i(1533);
            this.sBv = i;
            this.sBx = str;
            if (this.sBv <= 0) {
                this.sBA.setText("");
                this.sBA.setVisibility(4);
                if (this.sBu > 0) {
                    bo(this.sBu, this.sBw);
                    AppMethodBeat.o(1533);
                    return;
                }
            }
            CharSequence charSequence = this.sBv;
            if (this.sBv > 99) {
                charSequence = "99+";
            }
            this.sBA.setText(charSequence);
            this.sBA.setVisibility(0);
            this.sBB.setVisibility(8);
            AppMethodBeat.o(1533);
        }

        public final void bo(int i, String str) {
            AppMethodBeat.i(1534);
            this.sBu = i;
            this.sBw = str;
            if (i <= 0) {
                this.sBB.setVisibility(8);
            } else if (this.sBv <= 0) {
                this.sBA.setVisibility(4);
                this.sBB.setVisibility(0);
                AppMethodBeat.o(1534);
                return;
            }
            AppMethodBeat.o(1534);
        }
    }

    static class a implements Runnable {
        String sBr;

        public a(String str) {
            this.sBr = str;
        }

        public final void run() {
            AppMethodBeat.i(1532);
            File file = new File(com.tencent.mm.compatible.util.e.eSn + "topstory/trace.info");
            if (file.exists() && file.length() > 2048) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.sBr = "Trace:\n" + h.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000) + IOUtils.LINE_SEPARATOR_UNIX + this.sBr;
            com.tencent.mm.a.e.e(file.getAbsolutePath(), this.sBr.getBytes());
            AppMethodBeat.o(1532);
        }
    }

    static {
        AppMethodBeat.i(1547);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePH = true;
        aVar.ePG = true;
        aVar.eQf = true;
        aVar.ePT = R.drawable.ad2;
        sBm = aVar.ahG();
        aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePH = true;
        aVar.ePG = true;
        aVar.ePT = R.drawable.ad2;
        sBn = aVar.ahG();
        AppMethodBeat.o(1547);
    }

    public static void an(String str, String str2, String str3) {
        AppMethodBeat.i(1535);
        ab.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", str2);
        if (g.bT(str2, true) == null) {
            i.c(str, "", str2, -1, "appinfo error: not found.");
            ab.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
            AppMethodBeat.o(1535);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            JSONObject jSONObject2 = jSONObject.getJSONObject("source");
            String string = jSONObject2.getString("title");
            String optString = jSONObject2.optString("description", "");
            String string2 = jSONObject2.getString("thumbUrl");
            String string3 = jSONObject.getString("appVersion");
            String optString2 = jSONObject2.optString("mediaName", "");
            String optString3 = jSONObject2.optString("mediaHeadUrl", "");
            Intent intent = new Intent();
            intent.putExtra("KEY_BIZTYPE", str);
            intent.putExtra("KEY_APPID", str2);
            intent.putExtra("KEY_EXTINFO", str3);
            intent.putExtra("KEY_TITLE", string);
            intent.putExtra("KEY_DESC", optString);
            intent.putExtra("KEY_THUMBURL", string2);
            intent.putExtra("KEY_APPVERSION", string3);
            intent.putExtra("KEY_MEDIANAME", optString2);
            intent.putExtra("KEY_MEDIAHEADURL", optString3);
            intent.addFlags(268435456).addFlags(32768);
            aa.d(ah.getContext(), ".ui.home.TopStoryUploadUI", intent);
            AppMethodBeat.o(1535);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", e, "startTopStoryUploadUI", new Object[0]);
            i.c(str, "", str2, -1, "extInfo error: parse failed.");
            AppMethodBeat.o(1535);
        }
    }

    public static void W(Context context, int i) {
        AppMethodBeat.i(1536);
        int HV = aa.HV(1);
        ab.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", Integer.valueOf(i), Integer.valueOf(HV));
        String str = "";
        int i2 = 0;
        if (((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEN()) {
            cht cEP = ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEP();
            str = cEP.cJb;
            i2 = 1;
            an.a(cEP, 102, 1, 0, 0, "");
        }
        int cEU = ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEU();
        if (cEU > 0) {
            an.a(((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEW(), 102, 2, cEU, 0, "");
        }
        te teVar = new te();
        teVar.cPr.actionType = 1;
        com.tencent.mm.sdk.b.a.xxA.m(teVar);
        if (teVar.cPs.cPt) {
            teVar = new te();
            teVar.cPr.actionType = 2;
            com.tencent.mm.sdk.b.a.xxA.m(teVar);
            ab.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = context.getString(R.string.c2a);
        final chn chn = new chn();
        chn.xgj = cFx();
        chn.scene = i;
        chn.hlm = "";
        chn.ctj = string;
        chn.cdf = 100;
        chn.sBd = ((PluginTopStoryUI) com.tencent.mm.kernel.g.M(PluginTopStoryUI.class)).getFirstLoadWebView();
        String HP = aa.HP(i);
        chn.cvF = HP;
        chn.cIy = HP;
        chn.xgm = string;
        chn.xgl = 1;
        chn.xgn = aa.bVP();
        chn.xgo = ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
        a(chn.tZG, str, valueOf, true);
        b(chn, "clickTopStory", System.currentTimeMillis());
        boolean z = true;
        Intent intent = new Intent();
        try {
            String a;
            intent.putExtra("key_context", chn.toByteArray());
            String str2 = "";
            if (d.vxo >= 654311424 || d.vxs) {
                a = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
            } else {
                a = str2;
            }
            List abB = abB(a);
            if (abB.isEmpty()) {
                chn.url = com.tencent.mm.plugin.topstory.a.g.a(i, HP, string, valueOf, str, "", 0, 0);
                intent.putExtra("key_tabconfig", "");
                intent.putExtra("key_chosetab", 0);
            } else {
                int i3;
                boolean z2;
                if (((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEN() || ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEU() > 0) {
                    i3 = 110;
                } else {
                    i3 = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_LAST_ENTER_TAB_REC_INT, Integer.valueOf(0))).intValue();
                    if (i3 == 0) {
                        i3 = 110;
                    }
                }
                int i4 = ((b) abB.get(0)).category;
                String str3 = ((b) abB.get(0)).sBt;
                for (int i5 = 0; i5 < abB.size(); i5++) {
                    if (((b) abB.get(i5)).category == i3) {
                        str3 = ((b) abB.get(i5)).sBt;
                        HV = i3;
                        break;
                    }
                }
                HV = i4;
                chn.url = com.tencent.mm.plugin.topstory.a.g.a(i, HP, string, valueOf, str, str3, i2, cEU);
                intent.putExtra("key_tabconfig", a);
                intent.putExtra("key_chosetab", HV);
                if (HV == 110) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z = z2;
            }
        } catch (IOException e) {
        }
        intent.addFlags(67108864);
        aa.d(context, ".ui.home.TopStoryHomeUI", intent);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1529);
                ((a) com.tencent.mm.kernel.g.M(a.class)).getWebViewMgr().a(chn, z);
                AppMethodBeat.o(1529);
            }
        });
        ((PluginTopStoryUI) com.tencent.mm.kernel.g.M(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.boots.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.boots.a.c.class)).dC(com.tencent.mm.plugin.boots.a.b.jJq, 884);
        AppMethodBeat.o(1536);
    }

    public static List<b> abB(String str) {
        AppMethodBeat.i(1537);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("tabs");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                b bVar = new b();
                bVar.category = jSONObject.getInt("category");
                String dor = com.tencent.mm.sdk.platformtools.aa.dor();
                if (dor.equals("zh_TW")) {
                    bVar.cEh = jSONObject.getString("wording_tw");
                } else if (dor.equals("zh_HK")) {
                    bVar.cEh = jSONObject.getString("wording_hk");
                } else if (dor.equals("zh_CN")) {
                    bVar.cEh = jSONObject.getString("wording_cn");
                } else {
                    bVar.cEh = jSONObject.getString("wording_en");
                }
                if (bo.isNullOrNil(bVar.cEh)) {
                    arrayList.clear();
                    AppMethodBeat.o(1537);
                    return arrayList;
                }
                bVar.sBs = jSONObject.getInt("showWhenRedDot") == 1;
                bVar.sBt = jSONObject.getString("tabInfo");
                int i2;
                if (bVar.category == 110) {
                    cht cEW;
                    if (((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEN()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    bVar.sBu = i2;
                    bVar.sBv = ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEU();
                    if (bVar.sBv > 0) {
                        cEW = ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEW();
                        if (cEW != null) {
                            bVar.sBx = cEW.cJb;
                        }
                    }
                    if (bVar.sBu > 0) {
                        cEW = ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEP();
                        if (cEW != null) {
                            bVar.sBw = cEW.cJb;
                        }
                    }
                } else if (bVar.category == 100) {
                    if (((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFb()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    bVar.sBu = i2;
                    if (bVar.sBu > 0) {
                        bVar.sBw = ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFc();
                    }
                }
                arrayList.add(bVar);
            }
        } catch (Exception e) {
            ab.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", e.getMessage());
            arrayList.clear();
        }
        AppMethodBeat.o(1537);
        return arrayList;
    }

    public static void a(Context context, final chn chn, String str) {
        AppMethodBeat.i(1538);
        a(chn.tZG, "", str, false);
        b(chn, "clickTopStory", System.currentTimeMillis());
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", chn.toByteArray());
        } catch (IOException e) {
        }
        aa.d(context, ".ui.home.TopStoryTabHomeUI", intent);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1530);
                ((a) com.tencent.mm.kernel.g.M(a.class)).getWebViewMgr().a(chn, true);
                AppMethodBeat.o(1530);
            }
        });
        AppMethodBeat.o(1538);
    }

    public static final String au(String str, long j) {
        AppMethodBeat.i(1539);
        String str2 = str + "_" + j;
        AppMethodBeat.o(1539);
        return str2;
    }

    private static void a(List<tn> list, String str, String str2, boolean z) {
        AppMethodBeat.i(1540);
        tn tnVar = new tn();
        tnVar.key = "redPointMsgId";
        tnVar.waE = String.valueOf(str);
        list.add(tnVar);
        tnVar = new tn();
        tnVar.key = "currentPage";
        tnVar.waD = 1;
        list.add(tnVar);
        tnVar = new tn();
        tnVar.key = "is_prefetch";
        tnVar.waD = 0;
        list.add(tnVar);
        tnVar = new tn();
        tnVar.key = "seq";
        tnVar.waE = str2;
        list.add(tnVar);
        tnVar = new tn();
        tnVar.key = "requestId";
        tnVar.waE = str2;
        list.add(tnVar);
        tnVar = new tn();
        tnVar.key = "recType";
        tnVar.waD = 0;
        list.add(tnVar);
        if (z) {
            tnVar = new tn();
            tnVar.key = TencentLocation.EXTRA_DIRECTION;
            tnVar.waD = 1;
            list.add(tnVar);
            tnVar = new tn();
            tnVar.key = "time_zone_min";
            TimeZone timeZone = TimeZone.getDefault();
            tnVar.waE = (((0 - timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis())) / 1000) / 60);
            list.add(tnVar);
        }
        AppMethodBeat.o(1540);
    }

    public static final String cFx() {
        AppMethodBeat.i(1541);
        te teVar = new te();
        teVar.cPr.actionType = 3;
        com.tencent.mm.sdk.b.a.xxA.m(teVar);
        String str = "";
        if (teVar.cPs.cPu != null) {
            str = teVar.cPs.cPu.xgj;
        }
        if (bo.isNullOrNil(str)) {
            str = UUID.randomUUID().toString();
            AppMethodBeat.o(1541);
            return str;
        }
        AppMethodBeat.o(1541);
        return str;
    }

    private static void b(chn chn, String str, long j) {
        AppMethodBeat.i(1542);
        com.tencent.mm.plugin.topstory.a.h.a(chn, str, j);
        if (chn.xgk.size() != 0) {
            AppMethodBeat.o(1542);
            return;
        }
        chu chu = new chu();
        chu.name = str;
        chu.timestamp = j;
        chn.xgk.add(chu);
        AppMethodBeat.o(1542);
    }

    public static final void c(chn chn, String str, long j) {
        AppMethodBeat.i(1543);
        com.tencent.mm.plugin.topstory.a.h.a(chn, str, j);
        if (chn.xgk.size() > 0) {
            chu chu = new chu();
            chu.name = str;
            chu.timestamp = j;
            chn.xgk.add(chu);
        }
        AppMethodBeat.o(1543);
    }

    public static final String a(chn chn) {
        AppMethodBeat.i(1544);
        Collections.sort(chn.xgk, new Comparator<chu>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return (int) (((chu) obj).timestamp - ((chu) obj2).timestamp);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= chn.xgk.size()) {
                break;
            }
            stringBuffer.append(((chu) chn.xgk.get(i2 - 1)).name);
            stringBuffer.append("->");
            stringBuffer.append(((chu) chn.xgk.get(i2)).name);
            stringBuffer.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuffer.append(((chu) chn.xgk.get(i2)).timestamp - ((chu) chn.xgk.get(i2 - 1)).timestamp);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            i = i2 + 1;
        }
        if (chn.xgk.size() > 2) {
            stringBuffer.append("TotalUseTime:");
            stringBuffer.append(((chu) chn.xgk.get(chn.xgk.size() - 1)).timestamp - ((chu) chn.xgk.get(0)).timestamp);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        chn.xgk.clear();
        stringBuffer.append("============");
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        if (com.tencent.mm.plugin.topstory.a.g.cFm()) {
            com.tencent.mm.sdk.g.d.post(new a(stringBuffer.toString()), "TopStory.SaveTraceTask");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(1544);
        return stringBuffer2;
    }

    public static void abC(String str) {
        AppMethodBeat.i(1545);
        final m dVar = new com.tencent.mm.plugin.topstory.a.c.d(str);
        com.tencent.mm.kernel.g.Rg().a(dVar.getType(), new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(1531);
                com.tencent.mm.kernel.g.Rg().b(dVar.getType(), (f) this);
                if (i == 0 && i2 == 0) {
                    String str2 = ((apv) ((com.tencent.mm.plugin.topstory.a.c.d) mVar).ehh.fsH.fsP).username;
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("Contact_Scene", 3);
                    if (str2 != null && str2.length() > 0) {
                        com.tencent.mm.bp.d.b(ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    AppMethodBeat.o(1531);
                    return;
                }
                ab.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.o(1531);
            }
        });
        com.tencent.mm.kernel.g.Rg().a(dVar, 0);
        AppMethodBeat.o(1545);
    }

    public static void eZ(Context context) {
        AppMethodBeat.i(1546);
        an.l("", 0, 0, 100);
        aa.d(context, ".ui.home.TopStorySettingUI", new Intent());
        AppMethodBeat.o(1546);
    }
}
