package com.tencent.p177mm.plugin.emoji.p384ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI */
public class EmojiSendDialogUI extends MMBaseActivity implements C1202f {
    private String emojiPath;
    private EmojiInfo exP;
    private boolean lao = false;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI$1 */
    class C29461 implements OnDismissListener {
        C29461() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53400);
            EmojiSendDialogUI.this.setResult(0);
            EmojiSendDialogUI.this.finish();
            AppMethodBeat.m2505o(53400);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.m2504i(53401);
        overridePendingTransition(-1, -1);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        C1720g.m3535RO().eJo.mo14539a((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        this.exP = (EmojiInfo) getIntent().getParcelableExtra("emoji_info");
        EmojiInfo Je = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35597Je(this.exP.field_md5);
        if (Je != null) {
            this.exP = Je;
            this.lao = true;
        }
        this.emojiPath = EmojiLogic.m44073L(C2933b.m5221Yb(), this.exP.field_groupId, this.exP.mo20410Aq());
        Je = C42952j.getEmojiStorageMgr().xYn.aqi(this.exP.field_md5);
        if ((Je != null && Je.field_catalog == EmojiInfo.yaB) || C5046bo.isNullOrNil(this.exP.field_groupId) || ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(this.exP.field_groupId)) {
            C4990ab.m7417i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", this.exP.field_md5, this.exP.field_groupId);
            i = 1;
        } else {
            C1720g.m3535RO().eJo.mo14541a(new C42945g(this.exP.field_groupId, (byte) 0), 0);
            C4990ab.m7417i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", this.exP.field_md5, this.exP.field_groupId);
            i = 0;
        }
        if (i != 0) {
            blz();
        }
        AppMethodBeat.m2505o(53401);
    }

    private void blz() {
        AppMethodBeat.m2504i(53402);
        C4990ab.m7416i("MicroMsg.EmojiSendDialogUI", "select contact");
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
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
        C25985d.m41466b((Context) this, ".ui.transmit.SelectConversationUI", intent, 1001);
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8367c9);
        AppMethodBeat.m2505o(53402);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53403);
        if (c1207m.getType() == v2helper.EMethodSetNgStrength) {
            C4990ab.m7417i("MicroMsg.EmojiSendDialogUI", "exchange end %s", ((C42945g) c1207m).kWz);
            if (C5046bo.isNullOrNil(this.exP.field_groupId)) {
                blz();
                AppMethodBeat.m2505o(53403);
                return;
            } else if (!this.exP.field_groupId.equalsIgnoreCase(r10.kWz)) {
                C4990ab.m7416i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                blz();
                AppMethodBeat.m2505o(53403);
                return;
            } else if (i2 == 4) {
                m44106JN(getString(C25738R.string.b_y));
                AppMethodBeat.m2505o(53403);
                return;
            } else {
                m44106JN(getString(C25738R.string.b_x));
                AppMethodBeat.m2505o(53403);
                return;
            }
        }
        AppMethodBeat.m2505o(53403);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53404);
        super.onDestroy();
        C1720g.m3535RO().eJo.mo14546b((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        AppMethodBeat.m2505o(53404);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53405);
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            if (i2 == -1) {
                EmojiInfo E;
                C4990ab.m7416i("MicroMsg.EmojiSendDialogUI", "select contact result");
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(this.exP.mo20410Aq());
                if (aqi == null) {
                    String L = EmojiLogic.m44073L(C2933b.m5221Yb(), this.exP.field_groupId, this.exP.mo20410Aq());
                    if (C5730e.m8628ct(L)) {
                        int i3 = C5063r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR;
                        EmojiInfo emojiInfo = this.exP;
                        emojiInfo.field_catalog = EmojiInfo.yau;
                        emojiInfo.field_type = i3;
                        emojiInfo.field_size = (int) C5730e.asZ(L);
                        emojiInfo.field_temp = 1;
                        E = C42952j.getEmojiStorageMgr().xYn.mo48553E(emojiInfo);
                        for (String str : C5046bo.m7508P(C5046bo.m7532bc(stringExtra, "").split(","))) {
                            if (E != null) {
                                C42952j.bki().mo35620a(str, E, null);
                                if (!C5046bo.isNullOrNil(stringExtra2)) {
                                    C12519g.bOk().mo46461eZ(stringExtra2, str);
                                }
                            }
                        }
                        setResult(-1);
                    }
                }
                E = aqi;
                for (String str2 : C5046bo.m7508P(C5046bo.m7532bc(stringExtra, "").split(","))) {
                }
                setResult(-1);
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.m2505o(53405);
    }

    public void finish() {
        AppMethodBeat.m2504i(53406);
        overridePendingTransition(-1, -1);
        super.finish();
        AppMethodBeat.m2505o(53406);
    }

    /* renamed from: JN */
    private void m44106JN(String str) {
        AppMethodBeat.m2504i(53407);
        if (!isFinishing()) {
            C30379h.m48461b((Context) this, str, "", true).setOnDismissListener(new C29461());
        }
        AppMethodBeat.m2505o(53407);
    }
}
