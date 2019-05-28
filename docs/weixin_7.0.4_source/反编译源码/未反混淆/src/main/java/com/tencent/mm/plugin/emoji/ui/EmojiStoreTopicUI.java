package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;

public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int gOW;
    private int lbJ;
    private String lbK;
    private String lbL;
    private String lbM;
    private String lbN;
    private String lbO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkL() {
        AppMethodBeat.i(53495);
        super.bkL();
        AppMethodBeat.o(53495);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53496);
        super.onCreate(bundle);
        h.pYm.e(12740, Integer.valueOf(3), "", "", Integer.valueOf(this.lbJ), Integer.valueOf(11), Integer.valueOf(11));
        AppMethodBeat.o(53496);
    }

    public final void initView() {
        AppMethodBeat.i(53497);
        this.lbJ = getIntent().getIntExtra("topic_id", -1);
        this.lbK = getIntent().getStringExtra("topic_name");
        this.lbN = getIntent().getStringExtra("topic_ad_url");
        this.lbL = getIntent().getStringExtra("topic_icon_url");
        this.lbM = getIntent().getStringExtra("topic_desc");
        this.lbO = getIntent().getStringExtra("sns_object_data");
        this.gOW = getIntent().getIntExtra("extra_scence", 0);
        if (!bo.isNullOrNil(this.lbO)) {
            this.lbJ = EmojiLogic.Jv(this.lbO);
            this.lbK = EmojiLogic.Jw(this.lbO);
            this.lbL = EmojiLogic.Jy(this.lbO);
            this.lbM = EmojiLogic.Jx(this.lbO);
            this.lbN = EmojiLogic.Jz(this.lbO);
        }
        setMMTitle(this.lbK);
        super.initView();
        addIconOptionMenu(0, R.raw.ofm_send_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53491);
                ab.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
                if (bo.isNullOrNil(EmojiStoreTopicUI.this.lbK) || bo.isNullOrNil(EmojiStoreTopicUI.this.lbL)) {
                    ab.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
                } else {
                    EmojiStoreTopicUI.c(EmojiStoreTopicUI.this);
                }
                AppMethodBeat.o(53491);
                return true;
            }
        });
        showOptionMenu(0, false);
        JI(this.lbN);
        AppMethodBeat.o(53497);
    }

    /* Access modifiers changed, original: protected|final */
    public final void JI(String str) {
        AppMethodBeat.i(53498);
        if (!(this.kXX == null || this.kXY == null || bo.isNullOrNil(str))) {
            a.getDensity(this);
            EmojiInfo r = EmojiLogic.r("Toptic", 8, str);
            if (r == null) {
                o.ahp().a(str, null, g.j("Toptic", str, "Toptic", "BANNER"), new i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(53492);
                        EmojiStoreTopicUI emojiStoreTopicUI = EmojiStoreTopicUI.this;
                        if (emojiStoreTopicUI.kZl != null) {
                            emojiStoreTopicUI.kZl.sendEmptyMessage(1009);
                        }
                        AppMethodBeat.o(53492);
                    }
                });
                AppMethodBeat.o(53498);
                return;
            }
            this.kXY.setImageFilePath(r.dve());
        }
        AppMethodBeat.o(53498);
    }

    public void onResume() {
        AppMethodBeat.i(53499);
        super.onResume();
        AppMethodBeat.o(53499);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(f fVar, boolean z, boolean z2) {
        AppMethodBeat.i(53500);
        super.a(fVar, z, z2);
        AppMethodBeat.o(53500);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53501);
        blb();
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bo.isNullOrNil(stringExtra)) {
                ab.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(stringExtra)));
                int i3 = this.lbJ;
                String str = this.lbK;
                String str2 = this.lbM;
                String str3 = this.lbL;
                String str4 = this.lbN;
                j.bki();
                l.a(this, stringExtra, 26, i3, str, str2, str3, str4, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(53501);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(boolean z, f fVar, boolean z2, boolean z3) {
        AppMethodBeat.i(53502);
        super.a(z, fVar, z2, z3);
        AppMethodBeat.o(53502);
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
    public final com.tencent.mm.plugin.emoji.a.a.a bkO() {
        AppMethodBeat.i(53503);
        com.tencent.mm.plugin.emoji.a.f fVar = new com.tencent.mm.plugin.emoji.a.f(this.mController.ylL);
        AppMethodBeat.o(53503);
        return fVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkT() {
        AppMethodBeat.i(53504);
        if (bo.isNullOrNil(this.lbN)) {
            AppMethodBeat.o(53504);
            return false;
        }
        AppMethodBeat.o(53504);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkS() {
        return false;
    }

    public final void m(Message message) {
        AppMethodBeat.i(53505);
        super.m(message);
        if (message.what == 1009) {
            JI(this.lbN);
        }
        AppMethodBeat.o(53505);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkM() {
        return 11;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkN() {
        return 14;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53506);
        super.onSceneEnd(i, i2, str, mVar);
        if (this.kYb) {
            showOptionMenu(0, false);
            AppMethodBeat.o(53506);
            return;
        }
        showOptionMenu(0, true);
        AppMethodBeat.o(53506);
    }

    static /* synthetic */ void c(EmojiStoreTopicUI emojiStoreTopicUI) {
        AppMethodBeat.i(53507);
        d dVar = new d(emojiStoreTopicUI.mController.ylL, 1, false);
        dVar.rBl = new c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(53493);
                lVar.a(1001, EmojiStoreTopicUI.this.getString(R.string.ba1), (int) R.raw.bottomsheet_icon_transmit);
                lVar.a(1000, EmojiStoreTopicUI.this.getString(R.string.ba2), (int) R.raw.bottomsheet_icon_moment);
                AppMethodBeat.o(53493);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(53494);
                switch (menuItem.getItemId()) {
                    case 1000:
                        Context context = EmojiStoreTopicUI.this.mController.ylL;
                        String a = EmojiStoreTopicUI.this.lbK;
                        String e = EmojiStoreTopicUI.this.lbM;
                        String b = EmojiStoreTopicUI.this.lbL;
                        j.bki();
                        l.a(context, a, e, b, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreTopicUI.this.lbJ, EmojiStoreTopicUI.this.lbK, EmojiStoreTopicUI.this.lbM, EmojiStoreTopicUI.this.lbL, EmojiStoreTopicUI.this.lbN, 0), 13);
                        h.pYm.e(13224, Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreTopicUI.this.lbJ));
                        break;
                    case 1001:
                        l.dE(EmojiStoreTopicUI.this.mController.ylL);
                        EmojiStoreTopicUI.this.mController.ylL.overridePendingTransition(R.anim.cg, R.anim.b6);
                        h.pYm.e(13224, Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreTopicUI.this.lbJ));
                        AppMethodBeat.o(53494);
                        return;
                }
                AppMethodBeat.o(53494);
            }
        };
        dVar.cpD();
        h.pYm.e(13224, Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(emojiStoreTopicUI.lbJ));
        AppMethodBeat.o(53507);
    }
}
