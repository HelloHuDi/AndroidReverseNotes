package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import com.tencent.wxmm.v2helper;

public class EmojiSendDialogUI extends MMBaseActivity implements f {
    private String emojiPath;
    private EmojiInfo exP;
    private boolean lao = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.i(53401);
        overridePendingTransition(-1, -1);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        g.RO().eJo.a((int) v2helper.EMethodSetNgStrength, (f) this);
        this.exP = (EmojiInfo) getIntent().getParcelableExtra("emoji_info");
        EmojiInfo Je = ((d) g.M(d.class)).getProvider().Je(this.exP.field_md5);
        if (Je != null) {
            this.exP = Je;
            this.lao = true;
        }
        this.emojiPath = EmojiLogic.L(b.Yb(), this.exP.field_groupId, this.exP.Aq());
        Je = j.getEmojiStorageMgr().xYn.aqi(this.exP.field_md5);
        if ((Je != null && Je.field_catalog == EmojiInfo.yaB) || bo.isNullOrNil(this.exP.field_groupId) || ((d) g.M(d.class)).getEmojiMgr().Ji(this.exP.field_groupId)) {
            ab.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", this.exP.field_md5, this.exP.field_groupId);
            i = 1;
        } else {
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.g(this.exP.field_groupId, (byte) 0), 0);
            ab.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", this.exP.field_md5, this.exP.field_groupId);
            i = 0;
        }
        if (i != 0) {
            blz();
        }
        AppMethodBeat.o(53401);
    }

    private void blz() {
        AppMethodBeat.i(53402);
        ab.i("MicroMsg.EmojiSendDialogUI", "select contact");
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        if (this.lao) {
            intent.putExtra("Retr_Msg_thumb_path", this.exP.field_md5);
        } else {
            intent.putExtra("image_path", this.emojiPath);
        }
        intent.putExtra("emoji_activity_id", this.exP.field_activityid);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
        com.tencent.mm.bp.d.b((Context) this, ".ui.transmit.SelectConversationUI", intent, 1001);
        overridePendingTransition(R.anim.cg, R.anim.c9);
        AppMethodBeat.o(53402);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53403);
        if (mVar.getType() == v2helper.EMethodSetNgStrength) {
            ab.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", ((com.tencent.mm.plugin.emoji.f.g) mVar).kWz);
            if (bo.isNullOrNil(this.exP.field_groupId)) {
                blz();
                AppMethodBeat.o(53403);
                return;
            } else if (!this.exP.field_groupId.equalsIgnoreCase(r10.kWz)) {
                ab.i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                blz();
                AppMethodBeat.o(53403);
                return;
            } else if (i2 == 4) {
                JN(getString(R.string.b_y));
                AppMethodBeat.o(53403);
                return;
            } else {
                JN(getString(R.string.b_x));
                AppMethodBeat.o(53403);
                return;
            }
        }
        AppMethodBeat.o(53403);
    }

    public void onDestroy() {
        AppMethodBeat.i(53404);
        super.onDestroy();
        g.RO().eJo.b((int) v2helper.EMethodSetNgStrength, (f) this);
        AppMethodBeat.o(53404);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53405);
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            if (i2 == -1) {
                EmojiInfo E;
                ab.i("MicroMsg.EmojiSendDialogUI", "select contact result");
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(this.exP.Aq());
                if (aqi == null) {
                    String L = EmojiLogic.L(b.Yb(), this.exP.field_groupId, this.exP.Aq());
                    if (e.ct(L)) {
                        int i3 = r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR;
                        EmojiInfo emojiInfo = this.exP;
                        emojiInfo.field_catalog = EmojiInfo.yau;
                        emojiInfo.field_type = i3;
                        emojiInfo.field_size = (int) e.asZ(L);
                        emojiInfo.field_temp = 1;
                        E = j.getEmojiStorageMgr().xYn.E(emojiInfo);
                        for (String str : bo.P(bo.bc(stringExtra, "").split(","))) {
                            if (E != null) {
                                j.bki().a(str, E, null);
                                if (!bo.isNullOrNil(stringExtra2)) {
                                    com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str);
                                }
                            }
                        }
                        setResult(-1);
                    }
                }
                E = aqi;
                for (String str2 : bo.P(bo.bc(stringExtra, "").split(","))) {
                }
                setResult(-1);
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.o(53405);
    }

    public void finish() {
        AppMethodBeat.i(53406);
        overridePendingTransition(-1, -1);
        super.finish();
        AppMethodBeat.o(53406);
    }

    private void JN(String str) {
        AppMethodBeat.i(53407);
        if (!isFinishing()) {
            h.b((Context) this, str, "", true).setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(53400);
                    EmojiSendDialogUI.this.setResult(0);
                    EmojiSendDialogUI.this.finish();
                    AppMethodBeat.o(53400);
                }
            });
        }
        AppMethodBeat.o(53407);
    }
}
