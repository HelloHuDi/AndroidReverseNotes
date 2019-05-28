package com.tencent.p177mm.plugin.topstory.p541ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C46296c;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.ahn;
import com.tencent.p177mm.protocal.protobuf.aho;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI */
public class TopStorySettingUI extends MMPreference implements C1202f {
    private C15541f ehK;
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
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI$1 */
    class C42161 implements OnMenuItemClickListener {
        C42161() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(1625);
            TopStorySettingUI.this.finish();
            AppMethodBeat.m2505o(1625);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI$2 */
    class C139472 implements OnCancelListener {
        C139472() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8571ck;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1627);
        super.onCreate(bundle);
        setMMTitle(getString(C25738R.string.f8699cg));
        setBackBtn(new C42161());
        this.ehK = this.yCw;
        this.sCB = (IconPreference) this.ehK.aqO("unlike");
        this.sCC = (IconPreference) this.ehK.aqO("black");
        C1720g.m3540Rg().mo14539a(2748, (C1202f) this);
        AppMethodBeat.m2505o(1627);
    }

    public void onResume() {
        AppMethodBeat.m2504i(1628);
        super.onResume();
        this.sCD = -1;
        this.sCE = -1;
        this.sCF = "";
        this.sCG = "";
        cFF();
        C1207m c46296c = new C46296c(1);
        C1207m c46296c2 = new C46296c(3);
        C1720g.m3535RO().eJo.mo14541a(c46296c, 0);
        C1720g.m3535RO().eJo.mo14541a(c46296c2, 0);
        C4990ab.m7416i("MicroMsg.TopStory.TopStorySettingUI", "onResume doscene");
        AppMethodBeat.m2505o(1628);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1629);
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        C1720g.m3540Rg().mo14546b(2748, (C1202f) this);
        AppMethodBeat.m2505o(1629);
    }

    private void cFF() {
        AppMethodBeat.m2504i(1630);
        C4990ab.m7417i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", Integer.valueOf(this.sCD), Integer.valueOf(this.sCE));
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
        AppMethodBeat.m2505o(1630);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(1631);
        C4990ab.m7416i("MicroMsg.TopStory.TopStorySettingUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        int i3 = (i == 0 && i2 == 0) ? 1 : 0;
        if (c1207m instanceof C46296c) {
            C46296c c46296c = (C46296c) c1207m;
            int i4 = c46296c.type;
            if (i3 == 0) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStorySettingUI", "onSceneEnd fail, type:%s", Integer.valueOf(i4));
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                    C30379h.m48461b((Context) this, getString(C25738R.string.ga6), "", true);
                }
                AppMethodBeat.m2505o(1631);
                return;
            }
            ahn ahn = (ahn) c46296c.ehh.fsH.fsP;
            if (ahn.vHk.isEmpty()) {
                if (i4 == 3) {
                    this.sCD = 0;
                } else if (c46296c.type == 1) {
                    this.sCE = 0;
                }
                cFF();
                AppMethodBeat.m2505o(1631);
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
                m86870FB(this.sCH);
            }
            cFF();
        }
        AppMethodBeat.m2505o(1631);
    }

    /* renamed from: FB */
    private boolean m86870FB(int i) {
        AppMethodBeat.m2504i(1632);
        C4990ab.m7417i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", Integer.valueOf(i));
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
                    C46400aa.m87335d((Context) this, ".ui.home.TopStorySettingVisibilityDetailUI", intent);
                } else {
                    intent.putExtra("k_topstory_type", 2);
                    intent.putExtra("k_topstory_user_list", this.sCG);
                    C46400aa.m87335d((Context) this, ".ui.home.TopStorySettingVisibilityDetailUI", intent);
                }
                AppMethodBeat.m2505o(1632);
                return true;
            } else if (TopStorySettingUI.bBL()) {
                if (i22 != 0) {
                    C1720g.m3535RO().eJo.mo14541a(new C46296c(3), 0);
                } else {
                    C1720g.m3535RO().eJo.mo14541a(new C46296c(1), 0);
                }
                this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.ga5), true, new C139472());
                C4990ab.m7416i("MicroMsg.TopStory.TopStorySettingUI", "wait for data");
                AppMethodBeat.m2505o(1632);
                return false;
            } else {
                C30379h.m48461b((Context) this, getString(C25738R.string.ga6), "", true);
                AppMethodBeat.m2505o(1632);
                return false;
            }
        }
        this.sCH = -1;
        AppMethodBeat.m2505o(1632);
        return false;
    }

    private static boolean bBK() {
        AppMethodBeat.m2504i(1633);
        int acS = C1720g.m3540Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.m2505o(1633);
            return true;
        }
        AppMethodBeat.m2505o(1633);
        return false;
    }

    private static boolean bBL() {
        AppMethodBeat.m2504i(1634);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean bBK = TopStorySettingUI.bBK();
            AppMethodBeat.m2505o(1634);
            return bBK;
        }
        Object obj;
        if (C5023at.isConnected(C4996ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.m2505o(1634);
            return true;
        }
        AppMethodBeat.m2505o(1634);
        return false;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(1626);
        String str = preference.mKey;
        boolean FB;
        if ("unlike".equals(str)) {
            C7060h.pYm.mo8381e(17080, Integer.valueOf(1), Integer.valueOf(2), this.sCD);
            FB = m86870FB(1);
            AppMethodBeat.m2505o(1626);
            return FB;
        } else if ("black".equals(str)) {
            C7060h.pYm.mo8381e(17080, Integer.valueOf(2), Integer.valueOf(2), this.sCE);
            FB = m86870FB(2);
            AppMethodBeat.m2505o(1626);
            return FB;
        } else if ("feedback".equals(str)) {
            StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
            try {
                stringBuilder.append("&deviceName=").append(C18178q.encode(C7243d.DEVICE_NAME, "UTF-8"));
            } catch (Exception e) {
            }
            stringBuilder.append("&imei=");
            try {
                stringBuilder.append("&deviceBrand=").append(C18178q.encode(Build.BRAND, "UTF-8"));
            } catch (Exception e2) {
            }
            try {
                stringBuilder.append("&deviceModel=").append(C18178q.encode(Build.MODEL, "UTF-8"));
            } catch (Exception e3) {
            }
            stringBuilder.append("&from=settingPage");
            StringBuilder append = stringBuilder.append("&uin=");
            C1720g.m3534RN();
            append.append(C1668a.m3384QG());
            stringBuilder.append("&version=").append(C7243d.vxo);
            try {
                stringBuilder.append("&lang=").append(C18178q.encode(C4988aa.dor(), "UTF-8"));
            } catch (Exception e4) {
            }
            try {
                stringBuilder.append("&ostype=").append(C18178q.encode(C7243d.vxk, "UTF-8"));
            } catch (Exception e5) {
            }
            stringBuilder.append("&scene=32");
            stringBuilder.append("&timeZone=").append(C5046bo.dpA());
            stringBuilder.append("&templateVersion=").append(C46400aa.m87313Id(1));
            stringBuilder.append("#/list/4155");
            C4990ab.m7416i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + stringBuilder.toString());
            String str2 = "wes##2##1";
            Intent intent = new Intent();
            intent.putExtra("rawUrl", stringBuilder.toString());
            intent.putExtra("convertActivityFromTranslucent", false);
            intent.putExtra("customize_status_bar_color", 0);
            intent.putExtra("status_bar_style", null);
            intent.putExtra("prePublishId", str2);
            intent.putExtra("KPublisherId", str2);
            intent.putExtra("preChatTYPE", 10);
            C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(1626);
            return true;
        } else {
            AppMethodBeat.m2505o(1626);
            return false;
        }
    }
}
