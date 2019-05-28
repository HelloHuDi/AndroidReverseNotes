package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bt;
import com.tencent.mm.ui.base.h;

public class FMessageListView extends LinearLayout {
    private boolean cPo;
    private Context context;
    private final LayoutParams njH;
    private com.tencent.mm.pluginsdk.ui.preference.a.a vqm;
    private com.tencent.mm.pluginsdk.c.a vqt;
    private com.tencent.mm.sdk.e.k.a vqu;
    private com.tencent.mm.sdk.e.k.a vqv;
    private a vqw;
    private a vqx;
    private TextView vqy;

    static class a extends View {
        public a(Context context) {
            super(context);
            AppMethodBeat.i(28042);
            setLayoutParams(new LayoutParams(-1, 1));
            AppMethodBeat.o(28042);
        }
    }

    public FMessageListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(28043);
        this.vqt = new com.tencent.mm.pluginsdk.c.a() {
            public final void j(b bVar) {
                AppMethodBeat.i(28037);
                if ((bVar instanceof jb) && !FMessageListView.this.cPo) {
                    FMessageListView.a(FMessageListView.this, ((jb) bVar).cEi.ctq);
                }
                AppMethodBeat.o(28037);
            }
        };
        this.vqu = new com.tencent.mm.sdk.e.k.a() {
            public final void a(String str, m mVar) {
                AppMethodBeat.i(28038);
                if (!FMessageListView.this.cPo) {
                    FMessageListView.b(FMessageListView.this, str);
                }
                AppMethodBeat.o(28038);
            }
        };
        this.vqv = new com.tencent.mm.sdk.e.k.a() {
            public final void a(String str, m mVar) {
                AppMethodBeat.i(28039);
                if (!FMessageListView.this.cPo) {
                    FMessageListView.c(FMessageListView.this, str);
                }
                AppMethodBeat.o(28039);
            }
        };
        this.njH = new LayoutParams(-1, -2);
        this.cPo = false;
        this.context = context;
        AppMethodBeat.o(28043);
    }

    public void setFMessageArgs(com.tencent.mm.pluginsdk.ui.preference.a.a aVar) {
        AppMethodBeat.i(28044);
        this.vqm = aVar;
        a.setFMessageArgs(aVar);
        AppMethodBeat.o(28044);
    }

    public void setHide(boolean z) {
        this.cPo = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(28045);
        super.onDetachedFromWindow();
        detach();
        AppMethodBeat.o(28045);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(28046);
        super.onAttachedToWindow();
        d.akO().c(this.vqu);
        com.tencent.mm.pluginsdk.c.a.a(jb.class.getName(), this.vqt);
        d.akQ().c(this.vqu);
        d.akR().c(this.vqv);
        AppMethodBeat.o(28046);
    }

    public final void detach() {
        AppMethodBeat.i(28047);
        d.akO().d(this.vqu);
        d.akQ().d(this.vqu);
        com.tencent.mm.pluginsdk.c.a.b(jb.class.getName(), this.vqt);
        d.akR().d(this.vqv);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                ((a) childAt).detach();
            }
        }
        this.vqw = null;
        this.vqx = null;
        AppMethodBeat.o(28047);
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(28048);
        if (bVar == null) {
            ab.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
            AppMethodBeat.o(28048);
        } else if (bVar.id <= 0) {
            ab.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + bVar.id);
            AppMethodBeat.o(28048);
        } else {
            int i;
            String str;
            int childCount = getChildCount();
            for (i = 1; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(bVar.id))) {
                    ab.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + bVar.id);
                    AppMethodBeat.o(28048);
                    return;
                }
            }
            if (bVar.vqC != null) {
                if (this.vqy == null) {
                    this.vqy = (TextView) findViewById(R.id.b36);
                }
                this.vqy.setText(bVar.vqC);
                this.vqy.setVisibility(0);
            }
            ab.d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(childCount)));
            if (childCount == 6) {
                ab.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                ab.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.vqw = new a(this.context);
                addView(this.vqw);
                this.vqx = new a(this.context);
                this.vqx.setContentText("");
                this.vqx.setBtnVisibility(0);
                addView(this.vqx, this.njH);
                aw.ZK();
                ad aoO = c.XM().aoO(bVar.username);
                if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                    ab.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + bVar.username);
                    this.vqw.setVisibility(0);
                    this.vqx.setVisibility(0);
                } else {
                    ab.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + bVar.username);
                    this.vqw.setVisibility(8);
                    this.vqx.setVisibility(8);
                }
            }
            if (bVar.cRY) {
                String string = this.context.getString(R.string.bwd, new Object[]{bVar.fjz});
                i = 0;
                str = string;
            } else {
                String str2;
                if (bVar.nickname == null || bVar.nickname.length() <= 0) {
                    str2 = bVar.username;
                    aw.ZK();
                    ad aoO2 = c.XM().aoO(bVar.username);
                    if (aoO2 != null && ((int) aoO2.ewQ) > 0) {
                        str2 = aoO2.Oj();
                    }
                } else {
                    str2 = bVar.nickname;
                }
                String str3 = str2 + ": " + bVar.fjz;
                i = 1;
                str = str3;
            }
            a aVar = new a(this.context);
            aVar.setTag(Long.valueOf(bVar.id));
            aVar.setContentText(str);
            aVar.setBtnVisibility(8);
            if (i != 0) {
                aVar.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(28041);
                        ab.d("MicroMsg.FMessageListView", "jacks long click digest");
                        h.a(FMessageListView.this.getContext(), null, new String[]{FMessageListView.this.getContext().getString(R.string.akc)}, new h.c() {
                            public final void iE(int i) {
                                AppMethodBeat.i(28040);
                                switch (i) {
                                    case 0:
                                        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(bVar.fjz);
                                        break;
                                }
                                AppMethodBeat.o(28040);
                            }
                        });
                        AppMethodBeat.o(28041);
                        return true;
                    }
                });
            }
            addView(aVar, getChildCount() - 2, this.njH);
            AppMethodBeat.o(28048);
        }
    }

    public void setReplyBtnVisible(boolean z) {
        int i = 0;
        AppMethodBeat.i(28049);
        int childCount = getChildCount();
        ab.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
        if (childCount <= 2) {
            ab.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(childCount)));
            AppMethodBeat.o(28049);
            return;
        }
        if (this.vqw != null) {
            this.vqw.setVisibility(z ? 0 : 8);
        }
        if (this.vqx != null) {
            a aVar = this.vqx;
            if (!z) {
                i = 8;
            }
            aVar.setVisibility(i);
        }
        AppMethodBeat.o(28049);
    }

    static /* synthetic */ void a(FMessageListView fMessageListView, String str) {
        AppMethodBeat.i(28050);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FMessageListView", "updateLbs, id is null");
            AppMethodBeat.o(28050);
            return;
        }
        long j;
        try {
            j = bo.getLong(str, 0);
        } catch (Exception e) {
            ab.e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            ab.e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            AppMethodBeat.o(28050);
            return;
        }
        ab.d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = ".concat(String.valueOf(j)));
        cp bfVar = new bf();
        if (!d.akQ().b(j, (com.tencent.mm.sdk.e.c) bfVar)) {
            ab.e("MicroMsg.FMessageListView", "updateLbs, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.o(28050);
        } else if (fMessageListView.vqm == null || !fMessageListView.vqm.talker.equals(bfVar.field_sayhiuser)) {
            ab.d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
            AppMethodBeat.o(28050);
        } else {
            if (fMessageListView.vqm.mGZ != null && fMessageListView.vqm.mGZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, bfVar));
            AppMethodBeat.o(28050);
        }
    }

    static /* synthetic */ void b(FMessageListView fMessageListView, String str) {
        AppMethodBeat.i(28051);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            AppMethodBeat.o(28051);
            return;
        }
        long j;
        try {
            j = bo.getLong(str, 0);
        } catch (Exception e) {
            ab.e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            ab.e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            AppMethodBeat.o(28051);
            return;
        }
        ab.d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = ".concat(String.valueOf(j)));
        ax axVar = new ax();
        if (!d.akO().b(j, (com.tencent.mm.sdk.e.c) axVar)) {
            ab.e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.o(28051);
        } else if (fMessageListView.vqm == null || !fMessageListView.vqm.talker.equals(axVar.field_talker)) {
            ab.d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
            AppMethodBeat.o(28051);
        } else {
            if (fMessageListView.vqm.mGZ != null && fMessageListView.vqm.mGZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.b(fMessageListView.context, axVar));
            AppMethodBeat.o(28051);
        }
    }

    static /* synthetic */ void c(FMessageListView fMessageListView, String str) {
        AppMethodBeat.i(28052);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FMessageListView", "updateShake, id is null");
            AppMethodBeat.o(28052);
            return;
        }
        long j;
        try {
            j = bo.getLong(str, 0);
        } catch (Exception e) {
            ab.e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            ab.e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            AppMethodBeat.o(28052);
            return;
        }
        ab.d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = ".concat(String.valueOf(j)));
        bt btVar = new bt();
        if (!d.akR().b(j, (com.tencent.mm.sdk.e.c) btVar)) {
            ab.e("MicroMsg.FMessageListView", "updateShake, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.o(28052);
        } else if (fMessageListView.vqm == null || !fMessageListView.vqm.talker.equals(btVar.field_sayhiuser)) {
            ab.d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
            AppMethodBeat.o(28052);
        } else {
            if (fMessageListView.vqm.mGZ != null && fMessageListView.vqm.mGZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, btVar));
            AppMethodBeat.o(28052);
        }
    }
}
