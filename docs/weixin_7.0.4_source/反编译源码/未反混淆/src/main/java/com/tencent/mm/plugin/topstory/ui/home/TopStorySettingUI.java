package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;

public class TopStorySettingUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private final String sCA = "feedback";
    private IconPreference sCB;
    private IconPreference sCC;
    private int sCD = -1;
    private int sCE = -1;
    private String sCF = "";
    private String sCG = "";
    private int sCH = -1;
    private final String sCy = "unlike";
    private final String sCz = "black";
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.ck;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1627);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.cg));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(1625);
                TopStorySettingUI.this.finish();
                AppMethodBeat.o(1625);
                return true;
            }
        });
        this.ehK = this.yCw;
        this.sCB = (IconPreference) this.ehK.aqO("unlike");
        this.sCC = (IconPreference) this.ehK.aqO("black");
        g.Rg().a(2748, (f) this);
        AppMethodBeat.o(1627);
    }

    public void onResume() {
        AppMethodBeat.i(1628);
        super.onResume();
        this.sCD = -1;
        this.sCE = -1;
        this.sCF = "";
        this.sCG = "";
        cFF();
        m cVar = new c(1);
        m cVar2 = new c(3);
        g.RO().eJo.a(cVar, 0);
        g.RO().eJo.a(cVar2, 0);
        ab.i("MicroMsg.TopStory.TopStorySettingUI", "onResume doscene");
        AppMethodBeat.o(1628);
    }

    public void onDestroy() {
        AppMethodBeat.i(1629);
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        g.Rg().b(2748, (f) this);
        AppMethodBeat.o(1629);
    }

    private void cFF() {
        AppMethodBeat.i(1630);
        ab.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", Integer.valueOf(this.sCD), Integer.valueOf(this.sCE));
        if (this.sCD <= 0) {
            this.sCB.setSummary((CharSequence) "");
        } else {
            this.sCB.setSummary((CharSequence) this.sCD);
        }
        if (this.sCE <= 0) {
            this.sCC.setSummary((CharSequence) "");
        } else {
            this.sCC.setSummary((CharSequence) this.sCE);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(1630);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(1631);
        ab.i("MicroMsg.TopStory.TopStorySettingUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        int i3 = (i == 0 && i2 == 0) ? 1 : 0;
        if (mVar instanceof c) {
            c cVar = (c) mVar;
            int i4 = cVar.type;
            if (i3 == 0) {
                ab.i("MicroMsg.TopStory.TopStorySettingUI", "onSceneEnd fail, type:%s", Integer.valueOf(i4));
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                    h.b((Context) this, getString(R.string.ga6), "", true);
                }
                AppMethodBeat.o(1631);
                return;
            }
            ahn ahn = (ahn) cVar.ehh.fsH.fsP;
            if (ahn.vHk.isEmpty()) {
                if (i4 == 3) {
                    this.sCD = 0;
                } else if (cVar.type == 1) {
                    this.sCE = 0;
                }
                cFF();
                AppMethodBeat.o(1631);
                return;
            }
            StringBuilder stringBuilder;
            Iterator it;
            aho aho;
            if (i4 == 3) {
                stringBuilder = new StringBuilder();
                this.sCD = 0;
                it = ahn.vHk.iterator();
                while (it.hasNext()) {
                    aho = (aho) it.next();
                    this.sCD++;
                    stringBuilder.append(aho.vHl).append(",");
                }
                this.sCF = stringBuilder.toString();
            } else if (i4 == 1) {
                stringBuilder = new StringBuilder();
                this.sCE = 0;
                it = ahn.vHk.iterator();
                while (it.hasNext()) {
                    aho = (aho) it.next();
                    this.sCE++;
                    stringBuilder.append(aho.vHl).append(",");
                }
                this.sCG = stringBuilder.toString();
            }
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
                FB(this.sCH);
            }
            cFF();
        }
        AppMethodBeat.o(1631);
    }

    private boolean FB(int i) {
        AppMethodBeat.i(1632);
        ab.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", Integer.valueOf(i));
        if (i == 1 || i == 2) {
            int i2;
            this.sCH = i;
            if (i == 1) {
                i2 = 1;
            } else {
                boolean i22 = false;
            }
            if ((i22 == 0 || this.sCD >= 0) && (i22 != 0 || this.sCE >= 0)) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                Intent intent = new Intent();
                if (i22 != 0) {
                    intent.putExtra("k_topstory_type", 1);
                    intent.putExtra("k_topstory_user_list", this.sCF);
                    aa.d((Context) this, ".ui.home.TopStorySettingVisibilityDetailUI", intent);
                } else {
                    intent.putExtra("k_topstory_type", 2);
                    intent.putExtra("k_topstory_user_list", this.sCG);
                    aa.d((Context) this, ".ui.home.TopStorySettingVisibilityDetailUI", intent);
                }
                AppMethodBeat.o(1632);
                return true;
            } else if (bBL()) {
                if (i22 != 0) {
                    g.RO().eJo.a(new c(3), 0);
                } else {
                    g.RO().eJo.a(new c(1), 0);
                }
                this.tipDialog = h.b((Context) this, getString(R.string.ga5), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                ab.i("MicroMsg.TopStory.TopStorySettingUI", "wait for data");
                AppMethodBeat.o(1632);
                return false;
            } else {
                h.b((Context) this, getString(R.string.ga6), "", true);
                AppMethodBeat.o(1632);
                return false;
            }
        }
        this.sCH = -1;
        AppMethodBeat.o(1632);
        return false;
    }

    private static boolean bBK() {
        AppMethodBeat.i(1633);
        int acS = g.Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.o(1633);
            return true;
        }
        AppMethodBeat.o(1633);
        return false;
    }

    private static boolean bBL() {
        AppMethodBeat.i(1634);
        if (((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
            boolean bBK = bBK();
            AppMethodBeat.o(1634);
            return bBK;
        }
        Object obj;
        if (at.isConnected(ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.o(1634);
            return true;
        }
        AppMethodBeat.o(1634);
        return false;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(1626);
        String str = preference.mKey;
        boolean FB;
        if ("unlike".equals(str)) {
            com.tencent.mm.plugin.report.service.h.pYm.e(17080, Integer.valueOf(1), Integer.valueOf(2), this.sCD);
            FB = FB(1);
            AppMethodBeat.o(1626);
            return FB;
        } else if ("black".equals(str)) {
            com.tencent.mm.plugin.report.service.h.pYm.e(17080, Integer.valueOf(2), Integer.valueOf(2), this.sCE);
            FB = FB(2);
            AppMethodBeat.o(1626);
            return FB;
        } else if ("feedback".equals(str)) {
            StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
            try {
                stringBuilder.append("&deviceName=").append(q.encode(d.DEVICE_NAME, "UTF-8"));
            } catch (Exception e) {
            }
            stringBuilder.append("&imei=");
            try {
                stringBuilder.append("&deviceBrand=").append(q.encode(Build.BRAND, "UTF-8"));
            } catch (Exception e2) {
            }
            try {
                stringBuilder.append("&deviceModel=").append(q.encode(Build.MODEL, "UTF-8"));
            } catch (Exception e3) {
            }
            stringBuilder.append("&from=settingPage");
            StringBuilder append = stringBuilder.append("&uin=");
            g.RN();
            append.append(a.QG());
            stringBuilder.append("&version=").append(d.vxo);
            try {
                stringBuilder.append("&lang=").append(q.encode(com.tencent.mm.sdk.platformtools.aa.dor(), "UTF-8"));
            } catch (Exception e4) {
            }
            try {
                stringBuilder.append("&ostype=").append(q.encode(d.vxk, "UTF-8"));
            } catch (Exception e5) {
            }
            stringBuilder.append("&scene=32");
            stringBuilder.append("&timeZone=").append(bo.dpA());
            stringBuilder.append("&templateVersion=").append(aa.Id(1));
            stringBuilder.append("#/list/4155");
            ab.i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + stringBuilder.toString());
            String str2 = "wes##2##1";
            Intent intent = new Intent();
            intent.putExtra("rawUrl", stringBuilder.toString());
            intent.putExtra("convertActivityFromTranslucent", false);
            intent.putExtra("customize_status_bar_color", 0);
            intent.putExtra("status_bar_style", null);
            intent.putExtra("prePublishId", str2);
            intent.putExtra("KPublisherId", str2);
            intent.putExtra("preChatTYPE", 10);
            com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(1626);
            return true;
        } else {
            AppMethodBeat.o(1626);
            return false;
        }
    }
}
