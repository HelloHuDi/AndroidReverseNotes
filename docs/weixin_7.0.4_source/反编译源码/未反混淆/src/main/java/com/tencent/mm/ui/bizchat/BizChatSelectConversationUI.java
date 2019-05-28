package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.v;
import java.util.HashMap;

@a(19)
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements n {
    private String jMp = null;
    private int scene = 0;
    private p tipDialog = null;
    j yEk;
    private TextView yFh;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(30180);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        aWh();
        String cI = z.aeV().cI(this.jMp);
        this.yEk = z.aeV().cH(cI);
        String str = "MicroMsg.BizChatSelectConversationUI";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.jMp;
        objArr[1] = cI;
        if (this.yEk == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (bo.isNullOrNil(cI) || this.yEk == null || this.yEk.afh() || bo.isNullOrNil(this.yEk.field_addMemberUrl)) {
            z.aeZ();
            h.a(this.jMp, (n) this);
            Context activity = getActivity();
            getString(R.string.tz);
            this.tipDialog = com.tencent.mm.ui.base.h.b(activity, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(30179);
                    BizChatSelectConversationUI.this.finish();
                    AppMethodBeat.o(30179);
                }
            });
        }
        AppMethodBeat.o(30180);
    }

    public void onDestroy() {
        AppMethodBeat.i(30181);
        super.onDestroy();
        AppMethodBeat.o(30181);
    }

    private void aWh() {
        AppMethodBeat.i(30182);
        if (bo.isNullOrNil(this.jMp)) {
            this.jMp = getIntent().getStringExtra("enterprise_biz_name");
            if (bo.isNullOrNil(this.jMp)) {
                ab.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
        AppMethodBeat.o(30182);
    }

    public final o aoz() {
        AppMethodBeat.i(30183);
        aWh();
        d dVar = new d(this, this.jMp);
        AppMethodBeat.o(30183);
        return dVar;
    }

    public final m aoA() {
        AppMethodBeat.i(30184);
        aWh();
        com.tencent.mm.ui.contact.p pVar = new com.tencent.mm.ui.contact.p(this, this.jMp);
        AppMethodBeat.o(30184);
        return pVar;
    }

    public final void a(ListView listView, int i) {
        AppMethodBeat.i(30185);
        super.a(listView, i);
        if (this.yFh == null) {
            AnonymousClass1 anonymousClass1 = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(30174);
                    BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
                    AppMethodBeat.o(30174);
                }
            };
            String string = getString(R.string.e1s);
            View inflate = v.hu(this).inflate(R.layout.a6i, null);
            inflate.setOnClickListener(anonymousClass1);
            TextView textView = (TextView) inflate.findViewById(R.id.b14);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.yFh = textView;
        }
        this.yFh.setVisibility(i);
        AppMethodBeat.o(30185);
    }

    public final void bMQ() {
        AppMethodBeat.i(30186);
        super.bMQ();
        AppMethodBeat.o(30186);
    }

    public final void mO(int i) {
        AppMethodBeat.i(30187);
        if (i < getContentLV().getHeaderViewsCount()) {
            ab.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
            AppMethodBeat.o(30187);
        } else if (getContentLV().getAdapter().getItem(i) instanceof a) {
            a aVar = (a) getContentLV().getAdapter().getItem(i);
            if (aVar == null) {
                AppMethodBeat.o(30187);
                return;
            }
            String str = aVar.username;
            long j = aVar.jMj;
            if (str == null || j == -1) {
                ab.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", str, Long.valueOf(j));
                AppMethodBeat.o(30187);
                return;
            }
            a(str, j, aVar.gnx);
            AppMethodBeat.o(30187);
        } else {
            ab.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
            AppMethodBeat.o(30187);
        }
    }

    private void a(String str, long j, CharSequence charSequence) {
        AppMethodBeat.i(30188);
        ab.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", str);
        if (this.scene != 2) {
            if (this.scene == 1) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
                String str2 = (String) hashMap.get("desc");
                a((String) hashMap.get("title"), str2, (String) hashMap.get("img_url"), str, j);
            }
            AppMethodBeat.o(30188);
        } else if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
            q(str, String.valueOf(charSequence), j);
            AppMethodBeat.o(30188);
        } else {
            r(str, String.valueOf(charSequence), j);
            AppMethodBeat.o(30188);
        }
    }

    private void q(final String str, String str2, final long j) {
        AppMethodBeat.i(30189);
        g.a(this.mController, j, getString(R.string.dr7), str2, getString(R.string.tf), new q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(30175);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str);
                    intent.putExtra("key_biz_chat_id", j);
                    intent.putExtra("key_is_biz_chat", true);
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.o(30175);
            }
        });
        AppMethodBeat.o(30189);
    }

    private void r(final String str, String str2, final long j) {
        AppMethodBeat.i(30190);
        g.a(this.mController, j, getString(R.string.dr7), str2, getString(R.string.tf), new q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(30176);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str);
                    intent.putExtra("key_biz_chat_id", j);
                    intent.putExtra("key_is_biz_chat", true);
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.o(30176);
            }
        });
        AppMethodBeat.o(30190);
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.i(30192);
        String mJ = s.mJ(this.jMp);
        AppMethodBeat.o(30192);
        return mJ;
    }

    public final boolean aow() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(30193);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(30193);
            return;
        }
        switch (i) {
            case 1:
                boolean z;
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    ab.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                    String string = bundleExtra.getString("enterprise_members");
                    acr acr = new acr();
                    c cVar = new c();
                    cVar.field_addMemberUrl = this.yEk != null ? this.yEk.field_addMemberUrl : null;
                    cVar.field_brandUserName = this.jMp;
                    if (!e.a(cVar, string, null, acr)) {
                        z = false;
                    } else if (cVar.field_bizChatLocalId != -1) {
                        a(this.jMp, cVar.field_bizChatLocalId, cVar.field_chatName);
                        z = true;
                    } else {
                        z.aeZ();
                        final com.tencent.mm.aj.a.n a = h.a(this.jMp, acr, (n) this);
                        getString(R.string.tz);
                        this.tipDialog = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.db), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(30178);
                                aw.Rg().c(a);
                                AppMethodBeat.o(30178);
                            }
                        });
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(30193);
                    return;
                }
                Toast.makeText(this, getString(R.string.drn), 0).show();
                AppMethodBeat.o(30193);
                return;
            default:
                AppMethodBeat.o(30193);
                return;
        }
    }

    public final void a(int i, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(30194);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (mVar.getType() == 1355) {
            c rq = z.aeT().rq(((com.tencent.mm.aj.a.n) mVar).afm().wcb.wku.vMV);
            if (rq == null) {
                Toast.makeText(ah.getContext(), getString(R.string.drn), 0).show();
                AppMethodBeat.o(30194);
                return;
            }
            a(this.jMp, rq.field_bizChatLocalId, rq.field_chatName);
        }
        AppMethodBeat.o(30194);
    }

    private com.tencent.mm.ui.widget.a.c a(String str, String str2, String str3, final String str4, final long j) {
        AppMethodBeat.i(30191);
        com.tencent.mm.ui.widget.a.c a = g.a(this.mController, str, str3, str2, true, getResources().getString(R.string.tf), new q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(30177);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str4);
                    intent.putExtra("key_biz_chat_id", j);
                    intent.putExtra("key_is_biz_chat", true);
                    if (!bo.isNullOrNil(str)) {
                        intent.putExtra("enterprise_share_append_text", str);
                    }
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.o(30177);
            }
        });
        AppMethodBeat.o(30191);
        return a;
    }

    static /* synthetic */ void a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        AppMethodBeat.i(30195);
        bizChatSelectConversationUI.yEk = z.aeV().cH(z.aeV().cI(bizChatSelectConversationUI.jMp));
        if (bizChatSelectConversationUI.yEk == null || bo.isNullOrNil(bizChatSelectConversationUI.yEk.field_addMemberUrl)) {
            String str = "MicroMsg.BizChatSelectConversationUI";
            String str2 = "field_addMemberUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.yEk != null ? bizChatSelectConversationUI.yEk.field_addMemberUrl : null;
            ab.i(str, str2, objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(R.string.a_o), 0).show();
            AppMethodBeat.o(30195);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.yEk.field_addMemberUrl);
        ab.i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", bizChatSelectConversationUI.yEk.field_addMemberUrl);
        intent.putExtra("useJs", true);
        d.b(bizChatSelectConversationUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.o(30195);
    }
}
