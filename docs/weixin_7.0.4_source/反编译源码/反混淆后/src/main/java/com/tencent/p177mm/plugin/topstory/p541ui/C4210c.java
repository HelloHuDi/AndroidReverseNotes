package com.tencent.p177mm.plugin.topstory.p541ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout.C8338e;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C9477te;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C27502b;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C22399d;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35892i;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.apv;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.protocal.protobuf.chu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
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

/* renamed from: com.tencent.mm.plugin.topstory.ui.c */
public final class C4210c {
    public static C25814c sBm;
    public static C25814c sBn;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.c$b */
    public static class C4211b {
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
        public C8338e sBy;
        public View sBz;

        /* renamed from: bn */
        public final void mo9129bn(int i, String str) {
            AppMethodBeat.m2504i(1533);
            this.sBv = i;
            this.sBx = str;
            if (this.sBv <= 0) {
                this.sBA.setText("");
                this.sBA.setVisibility(4);
                if (this.sBu > 0) {
                    mo9130bo(this.sBu, this.sBw);
                    AppMethodBeat.m2505o(1533);
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
            AppMethodBeat.m2505o(1533);
        }

        /* renamed from: bo */
        public final void mo9130bo(int i, String str) {
            AppMethodBeat.m2504i(1534);
            this.sBu = i;
            this.sBw = str;
            if (i <= 0) {
                this.sBB.setVisibility(8);
            } else if (this.sBv <= 0) {
                this.sBA.setVisibility(4);
                this.sBB.setVisibility(0);
                AppMethodBeat.m2505o(1534);
                return;
            }
            AppMethodBeat.m2505o(1534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.c$a */
    static class C4212a implements Runnable {
        String sBr;

        public C4212a(String str) {
            this.sBr = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(1532);
            File file = new File(C6457e.eSn + "topstory/trace.info");
            if (file.exists() && file.length() > 2048) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.sBr = "Trace:\n" + C14835h.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000) + IOUtils.LINE_SEPARATOR_UNIX + this.sBr;
            C1173e.m2568e(file.getAbsolutePath(), this.sBr.getBytes());
            AppMethodBeat.m2505o(1532);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.c$3 */
    static class C42143 implements Comparator<chu> {
        C42143() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((chu) obj).timestamp - ((chu) obj2).timestamp);
        }
    }

    static {
        AppMethodBeat.m2504i(1547);
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePG = true;
        c17927a.eQf = true;
        c17927a.ePT = C25738R.drawable.ad2;
        sBm = c17927a.ahG();
        c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePG = true;
        c17927a.ePT = C25738R.drawable.ad2;
        sBn = c17927a.ahG();
        AppMethodBeat.m2505o(1547);
    }

    /* renamed from: an */
    public static void m6558an(String str, String str2, String str3) {
        AppMethodBeat.m2504i(1535);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", str2);
        if (C46494g.m87739bT(str2, true) == null) {
            C35892i.m58841c(str, "", str2, -1, "appinfo error: not found.");
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
            AppMethodBeat.m2505o(1535);
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
            C46400aa.m87335d(C4996ah.getContext(), ".ui.home.TopStoryUploadUI", intent);
            AppMethodBeat.m2505o(1535);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", e, "startTopStoryUploadUI", new Object[0]);
            C35892i.m58841c(str, "", str2, -1, "extInfo error: parse failed.");
            AppMethodBeat.m2505o(1535);
        }
    }

    /* renamed from: W */
    public static void m6554W(Context context, int i) {
        AppMethodBeat.m2504i(1536);
        int HV = C46400aa.m87305HV(1);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", Integer.valueOf(i), Integer.valueOf(HV));
        String str = "";
        int i2 = 0;
        if (((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEN()) {
            cht cEP = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEP();
            str = cEP.cJb;
            i2 = 1;
            C14423an.m22644a(cEP, 102, 1, 0, 0, "");
        }
        int cEU = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEU();
        if (cEU > 0) {
            C14423an.m22644a(((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEW(), 102, 2, cEU, 0, "");
        }
        C9477te c9477te = new C9477te();
        c9477te.cPr.actionType = 1;
        C4879a.xxA.mo10055m(c9477te);
        if (c9477te.cPs.cPt) {
            c9477te = new C9477te();
            c9477te.cPr.actionType = 2;
            C4879a.xxA.mo10055m(c9477te);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = context.getString(C25738R.string.c2a);
        final chn chn = new chn();
        chn.xgj = C4210c.cFx();
        chn.scene = i;
        chn.hlm = "";
        chn.ctj = string;
        chn.cdf = 100;
        chn.sBd = ((PluginTopStoryUI) C1720g.m3530M(PluginTopStoryUI.class)).getFirstLoadWebView();
        String HP = C46400aa.m87299HP(i);
        chn.cvF = HP;
        chn.cIy = HP;
        chn.xgm = string;
        chn.xgl = 1;
        chn.xgn = C46400aa.bVP();
        chn.xgo = ((C13943b) C1720g.m3530M(C13943b.class)).getWebViewType().name();
        C4210c.m6557a(chn.tZG, str, valueOf, true);
        C4210c.m6560b(chn, "clickTopStory", System.currentTimeMillis());
        boolean z = true;
        Intent intent = new Intent();
        try {
            String a;
            intent.putExtra("key_context", chn.toByteArray());
            String str2 = "";
            if (C7243d.vxo >= 654311424 || C7243d.vxs) {
                a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54613a(C11745a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
            } else {
                a = str2;
            }
            List abB = C4210c.abB(a);
            if (abB.isEmpty()) {
                chn.url = C39964g.m68430a(i, HP, string, valueOf, str, "", 0, 0);
                intent.putExtra("key_tabconfig", "");
                intent.putExtra("key_chosetab", 0);
            } else {
                int i3;
                boolean z2;
                if (((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEN() || ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEU() > 0) {
                    i3 = 110;
                } else {
                    i3 = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TOP_STORY_LAST_ENTER_TAB_REC_INT, Integer.valueOf(0))).intValue();
                    if (i3 == 0) {
                        i3 = 110;
                    }
                }
                int i4 = ((C4211b) abB.get(0)).category;
                String str3 = ((C4211b) abB.get(0)).sBt;
                for (int i5 = 0; i5 < abB.size(); i5++) {
                    if (((C4211b) abB.get(i5)).category == i3) {
                        str3 = ((C4211b) abB.get(i5)).sBt;
                        HV = i3;
                        break;
                    }
                }
                HV = i4;
                chn.url = C39964g.m68430a(i, HP, string, valueOf, str, str3, i2, cEU);
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
        C46400aa.m87335d(context, ".ui.home.TopStoryHomeUI", intent);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(1529);
                ((C7612a) C1720g.m3530M(C7612a.class)).getWebViewMgr().mo9146a(chn, z);
                AppMethodBeat.m2505o(1529);
            }
        });
        ((PluginTopStoryUI) C1720g.m3530M(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, Long.valueOf(System.currentTimeMillis()));
        ((C20015c) C1720g.m3528K(C20015c.class)).mo6742dC(C27502b.jJq, 884);
        AppMethodBeat.m2505o(1536);
    }

    public static List<C4211b> abB(String str) {
        AppMethodBeat.m2504i(1537);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("tabs");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C4211b c4211b = new C4211b();
                c4211b.category = jSONObject.getInt("category");
                String dor = C4988aa.dor();
                if (dor.equals("zh_TW")) {
                    c4211b.cEh = jSONObject.getString("wording_tw");
                } else if (dor.equals("zh_HK")) {
                    c4211b.cEh = jSONObject.getString("wording_hk");
                } else if (dor.equals("zh_CN")) {
                    c4211b.cEh = jSONObject.getString("wording_cn");
                } else {
                    c4211b.cEh = jSONObject.getString("wording_en");
                }
                if (C5046bo.isNullOrNil(c4211b.cEh)) {
                    arrayList.clear();
                    AppMethodBeat.m2505o(1537);
                    return arrayList;
                }
                c4211b.sBs = jSONObject.getInt("showWhenRedDot") == 1;
                c4211b.sBt = jSONObject.getString("tabInfo");
                int i2;
                if (c4211b.category == 110) {
                    cht cEW;
                    if (((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEN()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    c4211b.sBu = i2;
                    c4211b.sBv = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEU();
                    if (c4211b.sBv > 0) {
                        cEW = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEW();
                        if (cEW != null) {
                            c4211b.sBx = cEW.cJb;
                        }
                    }
                    if (c4211b.sBu > 0) {
                        cEW = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEP();
                        if (cEW != null) {
                            c4211b.sBw = cEW.cJb;
                        }
                    }
                } else if (c4211b.category == 100) {
                    if (((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFb()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    c4211b.sBu = i2;
                    if (c4211b.sBu > 0) {
                        c4211b.sBw = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFc();
                    }
                }
                arrayList.add(c4211b);
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", e.getMessage());
            arrayList.clear();
        }
        AppMethodBeat.m2505o(1537);
        return arrayList;
    }

    /* renamed from: a */
    public static void m6556a(Context context, final chn chn, String str) {
        AppMethodBeat.m2504i(1538);
        C4210c.m6557a(chn.tZG, "", str, false);
        C4210c.m6560b(chn, "clickTopStory", System.currentTimeMillis());
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", chn.toByteArray());
        } catch (IOException e) {
        }
        C46400aa.m87335d(context, ".ui.home.TopStoryTabHomeUI", intent);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(1530);
                ((C7612a) C1720g.m3530M(C7612a.class)).getWebViewMgr().mo9146a(chn, true);
                AppMethodBeat.m2505o(1530);
            }
        });
        AppMethodBeat.m2505o(1538);
    }

    /* renamed from: au */
    public static final String m6559au(String str, long j) {
        AppMethodBeat.m2504i(1539);
        String str2 = str + "_" + j;
        AppMethodBeat.m2505o(1539);
        return str2;
    }

    /* renamed from: a */
    private static void m6557a(List<C23447tn> list, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(1540);
        C23447tn c23447tn = new C23447tn();
        c23447tn.key = "redPointMsgId";
        c23447tn.waE = String.valueOf(str);
        list.add(c23447tn);
        c23447tn = new C23447tn();
        c23447tn.key = "currentPage";
        c23447tn.waD = 1;
        list.add(c23447tn);
        c23447tn = new C23447tn();
        c23447tn.key = "is_prefetch";
        c23447tn.waD = 0;
        list.add(c23447tn);
        c23447tn = new C23447tn();
        c23447tn.key = "seq";
        c23447tn.waE = str2;
        list.add(c23447tn);
        c23447tn = new C23447tn();
        c23447tn.key = "requestId";
        c23447tn.waE = str2;
        list.add(c23447tn);
        c23447tn = new C23447tn();
        c23447tn.key = "recType";
        c23447tn.waD = 0;
        list.add(c23447tn);
        if (z) {
            c23447tn = new C23447tn();
            c23447tn.key = TencentLocation.EXTRA_DIRECTION;
            c23447tn.waD = 1;
            list.add(c23447tn);
            c23447tn = new C23447tn();
            c23447tn.key = "time_zone_min";
            TimeZone timeZone = TimeZone.getDefault();
            c23447tn.waE = (((0 - timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis())) / 1000) / 60);
            list.add(c23447tn);
        }
        AppMethodBeat.m2505o(1540);
    }

    public static final String cFx() {
        AppMethodBeat.m2504i(1541);
        C9477te c9477te = new C9477te();
        c9477te.cPr.actionType = 3;
        C4879a.xxA.mo10055m(c9477te);
        String str = "";
        if (c9477te.cPs.cPu != null) {
            str = c9477te.cPs.cPu.xgj;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = UUID.randomUUID().toString();
            AppMethodBeat.m2505o(1541);
            return str;
        }
        AppMethodBeat.m2505o(1541);
        return str;
    }

    /* renamed from: b */
    private static void m6560b(chn chn, String str, long j) {
        AppMethodBeat.m2504i(1542);
        C46297h.m86861a(chn, str, j);
        if (chn.xgk.size() != 0) {
            AppMethodBeat.m2505o(1542);
            return;
        }
        chu chu = new chu();
        chu.name = str;
        chu.timestamp = j;
        chn.xgk.add(chu);
        AppMethodBeat.m2505o(1542);
    }

    /* renamed from: c */
    public static final void m6561c(chn chn, String str, long j) {
        AppMethodBeat.m2504i(1543);
        C46297h.m86861a(chn, str, j);
        if (chn.xgk.size() > 0) {
            chu chu = new chu();
            chu.name = str;
            chu.timestamp = j;
            chn.xgk.add(chu);
        }
        AppMethodBeat.m2505o(1543);
    }

    /* renamed from: a */
    public static final String m6555a(chn chn) {
        AppMethodBeat.m2504i(1544);
        Collections.sort(chn.xgk, new C42143());
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
        if (C39964g.cFm()) {
            C7305d.post(new C4212a(stringBuffer.toString()), "TopStory.SaveTraceTask");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(1544);
        return stringBuffer2;
    }

    public static void abC(String str) {
        AppMethodBeat.m2504i(1545);
        final C1207m c22399d = new C22399d(str);
        C1720g.m3540Rg().mo14539a(c22399d.getType(), new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(1531);
                C1720g.m3540Rg().mo14546b(c22399d.getType(), (C1202f) this);
                if (i == 0 && i2 == 0) {
                    String str2 = ((apv) ((C22399d) c1207m).ehh.fsH.fsP).username;
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("Contact_Scene", 3);
                    if (str2 != null && str2.length() > 0) {
                        C25985d.m41467b(C4996ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    AppMethodBeat.m2505o(1531);
                    return;
                }
                C4990ab.m7413e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.m2505o(1531);
            }
        });
        C1720g.m3540Rg().mo14541a(c22399d, 0);
        AppMethodBeat.m2505o(1545);
    }

    /* renamed from: eZ */
    public static void m6562eZ(Context context) {
        AppMethodBeat.m2504i(1546);
        C14423an.m22656l("", 0, 0, 100);
        C46400aa.m87335d(context, ".ui.home.TopStorySettingUI", new Intent());
        AppMethodBeat.m2505o(1546);
    }
}
