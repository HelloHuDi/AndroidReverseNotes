package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import java.util.Iterator;

public class RecordMsgDetailUI extends RecordMsgBaseUI {
    private boolean cHc = true;
    private String cKa = null;
    private long cvx = -1;
    private p ejZ = null;
    private boolean pKA = false;
    private String pKB = "";
    private String pKC = "";
    private c pKz = null;
    private String title = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void f(RecordMsgDetailUI recordMsgDetailUI) {
        AppMethodBeat.i(24251);
        recordMsgDetailUI.cu();
        AppMethodBeat.o(24251);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24242);
        super.onCreate(bundle);
        AppMethodBeat.o(24242);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceI() {
        AppMethodBeat.i(24243);
        this.cvx = getIntent().getLongExtra("message_id", -1);
        this.cKa = getIntent().getStringExtra("record_xml");
        this.cHc = getIntent().getBooleanExtra("record_show_share", true);
        this.pKA = getIntent().getBooleanExtra("big_appmsg", false);
        this.pKz = n.VI(this.cKa);
        if (this.pKz != null) {
            if (a(this.pKz) != null) {
                this.title = a(this.pKz);
            } else {
                this.title = this.pKz.title;
            }
            if (!bo.ek(this.pKz.fjr)) {
                this.pKB = ((aar) this.pKz.fjr.getFirst()).wgX;
                this.pKC = ((aar) this.pKz.fjr.getLast()).wgX;
            }
        } else {
            aw.ZK();
            bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
            b X = b.X(jf.field_content, jf.field_reserved);
            if (X != null) {
                this.title = X.title;
                this.ejZ = p.b(this, getString(R.string.cn5), true, null);
            }
        }
        if (this.cKa == null || this.pKz == null) {
            ceQ();
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(24234);
                    RecordMsgDetailUI.this.finish();
                    AppMethodBeat.o(24234);
                    return true;
                }
            });
            if (this.pKA && am.aUq().lZ(this.cvx) != null) {
                aw.ZK();
                aw.Rg().a(new e(this.cvx, com.tencent.mm.model.c.XO().jf(this.cvx).field_msgSvrId, new g() {
                    public final void a(int i, int i2, m mVar) {
                        AppMethodBeat.i(24235);
                        if (i == i2) {
                            if (RecordMsgDetailUI.this.ejZ != null) {
                                RecordMsgDetailUI.this.ejZ.dismiss();
                                RecordMsgDetailUI.this.ejZ = null;
                            }
                            aw.ZK();
                            bi jf = com.tencent.mm.model.c.XO().jf(RecordMsgDetailUI.this.cvx);
                            String str = jf.field_content;
                            if (t.kH(jf.field_talker)) {
                                str = bf.oz(jf.field_content);
                            }
                            b me = b.me(str);
                            if (me != null) {
                                RecordMsgDetailUI.this.cKa = me.fgU;
                                RecordMsgDetailUI.this.pKz = n.VI(RecordMsgDetailUI.this.cKa);
                                if (RecordMsgDetailUI.this.pKz != null) {
                                    if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.this.pKz) != null) {
                                        RecordMsgDetailUI.this.title = RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.this.pKz);
                                    } else {
                                        RecordMsgDetailUI.this.title = RecordMsgDetailUI.this.pKz.title;
                                    }
                                    RecordMsgDetailUI.this.pKB = ((aar) RecordMsgDetailUI.this.pKz.fjr.getFirst()).wgX;
                                    RecordMsgDetailUI.this.pKC = ((aar) RecordMsgDetailUI.this.pKz.fjr.getLast()).wgX;
                                }
                                RecordMsgDetailUI.f(RecordMsgDetailUI.this);
                            }
                        }
                        AppMethodBeat.o(24235);
                    }
                }), 0);
            }
            AppMethodBeat.o(24243);
            return;
        }
        cu();
        AppMethodBeat.o(24243);
    }

    private String a(c cVar) {
        String str;
        AppMethodBeat.i(24244);
        if (cVar != null) {
            Iterator it = cVar.fjr.iterator();
            int i = 0;
            Object obj = null;
            String str2 = null;
            str = null;
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (aar.wgT.whw.whU != null) {
                    i = 1;
                    str = this.mController.ylL.getString(R.string.dja);
                } else {
                    String str3;
                    if (aar.wgT.whw.cEV != null) {
                        if (str2 == null) {
                            str2 = aar.wgV;
                        } else if (str2 != aar.wgV) {
                            str3 = aar.wgV;
                            obj = str3;
                        }
                    }
                    str3 = obj;
                    obj = str3;
                }
            }
            if (str2 != null && obj == null && i == 0) {
                str = this.mController.ylL.getString(R.string.bqj, new Object[]{str2});
            } else if (!(str2 == null || obj == null || str2.equals(obj) || i != 0)) {
                str = this.mController.ylL.getString(R.string.bqi, new Object[]{str2, obj});
            }
        } else {
            str = null;
        }
        AppMethodBeat.o(24244);
        return str;
    }

    private void cu() {
        AppMethodBeat.i(24245);
        f fVar = new f();
        fVar.pJZ = this.pKz.fjr;
        fVar.cvx = this.cvx;
        fVar.cKa = this.cKa;
        super.ceI();
        this.pKw.a(fVar);
        ((a) com.tencent.mm.kernel.g.M(a.class)).getRecordMsgCDNStorage().a((e) this.pKw);
        AppMethodBeat.o(24245);
    }

    /* Access modifiers changed, original: protected|final */
    public final h ceJ() {
        AppMethodBeat.i(24246);
        e eVar = new e(this, new g());
        eVar.fromScene = getIntent().getIntExtra("from_scene", 0);
        AppMethodBeat.o(24246);
        return eVar;
    }

    public void onDestroy() {
        AppMethodBeat.i(24247);
        super.onDestroy();
        ((a) com.tencent.mm.kernel.g.M(a.class)).getRecordMsgCDNStorage().b((e) this.pKw);
        AppMethodBeat.o(24247);
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceK() {
        return this.title;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceL() {
        return this.pKB;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceM() {
        return this.pKC;
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceN() {
        AppMethodBeat.i(24248);
        if (this.cHc) {
            addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(24238);
                    d dVar = new d(RecordMsgDetailUI.this.mController.ylL, 1, false);
                    dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(24236);
                            lVar.e(0, RecordMsgDetailUI.this.getString(R.string.bri));
                            if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
                                lVar.e(2, RecordMsgDetailUI.this.getString(R.string.dcq));
                            }
                            AppMethodBeat.o(24236);
                        }
                    };
                    dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(24237);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("select_is_ret", true);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    intent.putExtra("Retr_Msg_Type", 10);
                                    intent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.this.cvx);
                                    com.tencent.mm.bp.d.b(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1001);
                                    AppMethodBeat.o(24237);
                                    return;
                                case 1:
                                    AppMethodBeat.o(24237);
                                    return;
                                case 2:
                                    cl clVar = new cl();
                                    com.tencent.mm.pluginsdk.model.e.a(clVar, RecordMsgDetailUI.this.cvx);
                                    clVar.cvA.cvH = 9;
                                    clVar.cvA.activity = RecordMsgDetailUI.this;
                                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                    break;
                            }
                            AppMethodBeat.o(24237);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(24238);
                    return true;
                }
            });
            AppMethodBeat.o(24248);
            return;
        }
        AppMethodBeat.o(24248);
    }

    /* Access modifiers changed, original: protected|final */
    public final void d(int i, int i2, Intent intent) {
        AppMethodBeat.i(24249);
        if (-1 != i2) {
            ab.e("MicroMsg.RecordMsgDetailUI", "processResult %d", Integer.valueOf(i2));
            AppMethodBeat.o(24249);
        } else if (1001 == i) {
            final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (bo.isNullOrNil(stringExtra)) {
                ab.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
                AppMethodBeat.o(24249);
                return;
            }
            aw.ZK();
            final bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
            if (jf.field_msgId != this.cvx) {
                ab.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
                AppMethodBeat.o(24249);
                return;
            }
            final p b = h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24240);
                    n.a(stringExtra, stringExtra2, jf);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24239);
                            b.dismiss();
                            AppMethodBeat.o(24239);
                        }
                    });
                    AppMethodBeat.o(24240);
                }

                public final String toString() {
                    AppMethodBeat.i(24241);
                    String str = super.toString() + "|onActivityResult";
                    AppMethodBeat.o(24241);
                    return str;
                }
            });
            AppMethodBeat.o(24249);
        } else {
            if (1002 == i && intent.getBooleanExtra("kfavorite", false)) {
                cl clVar = new cl();
                com.tencent.mm.pluginsdk.model.e.a(clVar, intent);
                clVar.cvA.activity = this;
                clVar.cvA.cvH = 8;
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
            }
            AppMethodBeat.o(24249);
        }
    }
}
