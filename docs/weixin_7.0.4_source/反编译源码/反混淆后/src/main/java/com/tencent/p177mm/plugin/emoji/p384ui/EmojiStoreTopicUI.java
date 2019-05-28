package com.tencent.p177mm.plugin.emoji.p384ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p381a.C11548f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.emoji.p947e.C45854l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI */
public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int gOW;
    private int lbJ;
    private String lbK;
    private String lbL;
    private String lbM;
    private String lbN;
    private String lbO;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI$1 */
    class C204031 implements OnMenuItemClickListener {
        C204031() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53491);
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
            if (C5046bo.isNullOrNil(EmojiStoreTopicUI.this.lbK) || C5046bo.isNullOrNil(EmojiStoreTopicUI.this.lbL)) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
            } else {
                EmojiStoreTopicUI.m65999c(EmojiStoreTopicUI.this);
            }
            AppMethodBeat.m2505o(53491);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI$2 */
    class C204042 implements C1282i {
        C204042() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(53492);
            EmojiStoreTopicUI emojiStoreTopicUI = EmojiStoreTopicUI.this;
            if (emojiStoreTopicUI.kZl != null) {
                emojiStoreTopicUI.kZl.sendEmptyMessage(1009);
            }
            AppMethodBeat.m2505o(53492);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI$3 */
    class C204053 implements C36073c {
        C204053() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(53493);
            c44273l.mo70049a(1001, EmojiStoreTopicUI.this.getString(C25738R.string.ba1), (int) C1318a.bottomsheet_icon_transmit);
            c44273l.mo70049a(1000, EmojiStoreTopicUI.this.getString(C25738R.string.ba2), (int) C1318a.bottomsheet_icon_moment);
            AppMethodBeat.m2505o(53493);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI$4 */
    class C388954 implements C5279d {
        C388954() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(53494);
            switch (menuItem.getItemId()) {
                case 1000:
                    Context context = EmojiStoreTopicUI.this.mController.ylL;
                    String a = EmojiStoreTopicUI.this.lbK;
                    String e = EmojiStoreTopicUI.this.lbM;
                    String b = EmojiStoreTopicUI.this.lbL;
                    C42952j.bki();
                    C45854l.m84902a(context, a, e, b, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.m44075a(EmojiStoreTopicUI.this.lbJ, EmojiStoreTopicUI.this.lbK, EmojiStoreTopicUI.this.lbM, EmojiStoreTopicUI.this.lbL, EmojiStoreTopicUI.this.lbN, 0), 13);
                    C7060h.pYm.mo8381e(13224, Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreTopicUI.this.lbJ));
                    break;
                case 1001:
                    C45854l.m84904dE(EmojiStoreTopicUI.this.mController.ylL);
                    EmojiStoreTopicUI.this.mController.ylL.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
                    C7060h.pYm.mo8381e(13224, Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreTopicUI.this.lbJ));
                    AppMethodBeat.m2505o(53494);
                    return;
            }
            AppMethodBeat.m2505o(53494);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkL() {
        AppMethodBeat.m2504i(53495);
        super.bkL();
        AppMethodBeat.m2505o(53495);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53496);
        super.onCreate(bundle);
        C7060h.pYm.mo8381e(12740, Integer.valueOf(3), "", "", Integer.valueOf(this.lbJ), Integer.valueOf(11), Integer.valueOf(11));
        AppMethodBeat.m2505o(53496);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53497);
        this.lbJ = getIntent().getIntExtra("topic_id", -1);
        this.lbK = getIntent().getStringExtra("topic_name");
        this.lbN = getIntent().getStringExtra("topic_ad_url");
        this.lbL = getIntent().getStringExtra("topic_icon_url");
        this.lbM = getIntent().getStringExtra("topic_desc");
        this.lbO = getIntent().getStringExtra("sns_object_data");
        this.gOW = getIntent().getIntExtra("extra_scence", 0);
        if (!C5046bo.isNullOrNil(this.lbO)) {
            this.lbJ = EmojiLogic.m44067Jv(this.lbO);
            this.lbK = EmojiLogic.m44068Jw(this.lbO);
            this.lbL = EmojiLogic.m44070Jy(this.lbO);
            this.lbM = EmojiLogic.m44069Jx(this.lbO);
            this.lbN = EmojiLogic.m44071Jz(this.lbO);
        }
        setMMTitle(this.lbK);
        super.initView();
        addIconOptionMenu(0, C1318a.ofm_send_icon, new C204031());
        showOptionMenu(0, false);
        mo30704JI(this.lbN);
        AppMethodBeat.m2505o(53497);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: JI */
    public final void mo30704JI(String str) {
        AppMethodBeat.m2504i(53498);
        if (!(this.kXX == null || this.kXY == null || C5046bo.isNullOrNil(str))) {
            C1338a.getDensity(this);
            EmojiInfo r = EmojiLogic.m44081r("Toptic", 8, str);
            if (r == null) {
                C32291o.ahp().mo43768a(str, null, C20364g.m31463j("Toptic", str, "Toptic", "BANNER"), new C204042());
                AppMethodBeat.m2505o(53498);
                return;
            }
            this.kXY.setImageFilePath(r.dve());
        }
        AppMethodBeat.m2505o(53498);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53499);
        super.onResume();
        AppMethodBeat.m2505o(53499);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo30706a(C20383f c20383f, boolean z, boolean z2) {
        AppMethodBeat.m2504i(53500);
        super.mo30706a(c20383f, z, z2);
        AppMethodBeat.m2505o(53500);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53501);
        blb();
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7410d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(stringExtra)));
                int i3 = this.lbJ;
                String str = this.lbK;
                String str2 = this.lbM;
                String str3 = this.lbL;
                String str4 = this.lbN;
                C42952j.bki();
                C45854l.m84903a(this, stringExtra, 26, i3, str, str2, str3, str4, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(53501);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo30707a(boolean z, C20383f c20383f, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(53502);
        super.mo30707a(z, c20383f, z2, z3);
        AppMethodBeat.m2505o(53502);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkV() {
        return 7;
    }

    public final int bkW() {
        return this.lbJ;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean blc() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final C33944a bkO() {
        AppMethodBeat.m2504i(53503);
        C11548f c11548f = new C11548f(this.mController.ylL);
        AppMethodBeat.m2505o(53503);
        return c11548f;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkT() {
        AppMethodBeat.m2504i(53504);
        if (C5046bo.isNullOrNil(this.lbN)) {
            AppMethodBeat.m2505o(53504);
            return false;
        }
        AppMethodBeat.m2505o(53504);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkS() {
        return false;
    }

    /* renamed from: m */
    public final void mo30732m(Message message) {
        AppMethodBeat.m2504i(53505);
        super.mo30732m(message);
        if (message.what == 1009) {
            mo30704JI(this.lbN);
        }
        AppMethodBeat.m2505o(53505);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkM() {
        return 11;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkN() {
        return 14;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53506);
        super.onSceneEnd(i, i2, str, c1207m);
        if (this.kYb) {
            showOptionMenu(0, false);
            AppMethodBeat.m2505o(53506);
            return;
        }
        showOptionMenu(0, true);
        AppMethodBeat.m2505o(53506);
    }

    /* renamed from: c */
    static /* synthetic */ void m65999c(EmojiStoreTopicUI emojiStoreTopicUI) {
        AppMethodBeat.m2504i(53507);
        C36356d c36356d = new C36356d(emojiStoreTopicUI.mController.ylL, 1, false);
        c36356d.rBl = new C204053();
        c36356d.rBm = new C388954();
        c36356d.cpD();
        C7060h.pYm.mo8381e(13224, Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(emojiStoreTopicUI.lbJ));
        AppMethodBeat.m2505o(53507);
    }
}
