package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.r;
import java.util.List;

public final class k extends RelativeLayout {
    public static Boolean zmx = Boolean.TRUE;
    private Context context = null;
    private View gbS = null;
    private boolean isVisible = true;
    private final ap yNs = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(33712);
            ab.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            k.dHS();
            k.a(k.this);
            AppMethodBeat.o(33712);
            return false;
        }
    }, true);
    private boolean zmA = false;
    private View zmy = null;
    com.tencent.mm.sdk.e.k.a zmz = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            long j;
            AppMethodBeat.i(33713);
            ab.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
            if (!k.this.yNs.doT()) {
                k.this.yNs.stopTimer();
            }
            ap b = k.this.yNs;
            if (k.this.zmA) {
                j = 500;
            } else {
                j = 1000;
            }
            b.ae(j, j);
            AppMethodBeat.o(33713);
        }
    };

    static /* synthetic */ void dHS() {
        AppMethodBeat.i(33726);
        dHQ();
        AppMethodBeat.o(33726);
    }

    public k(Context context) {
        super(context);
        AppMethodBeat.i(33718);
        this.context = context;
        d.akP().c(this.zmz);
        dHQ();
        init();
        AppMethodBeat.o(33718);
    }

    private void init() {
        AppMethodBeat.i(33719);
        List dtb = d.akP().dtb();
        int size = dtb.size();
        ab.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", Integer.valueOf(size));
        removeAllViews();
        if (size <= 0) {
            dHP();
        } else if (size == 1) {
            a((av) dtb.get(0));
        } else {
            fo(dtb);
        }
        View findViewById = this.gbS.findViewById(R.id.bug);
        if (findViewById != null) {
            int i;
            if (this.isVisible) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
        this.zmy.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(33714);
                if (k.this.context instanceof MMActivity) {
                    ((MMActivity) k.this.context).aqX();
                }
                AppMethodBeat.o(33714);
                return false;
            }
        });
        size = d.akP().dtd();
        ab.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", Integer.valueOf(size));
        TextView textView = (TextView) this.gbS.findViewById(R.id.buj);
        textView.setBackgroundResource(r.ik(this.context));
        if (size <= 0) {
            textView.setVisibility(8);
            zmx = Boolean.FALSE;
            AppMethodBeat.o(33719);
            return;
        }
        textView.setVisibility(0);
        zmx = Boolean.TRUE;
        if (size > 99) {
            textView.setText("");
            textView.setBackgroundResource(R.raw.badge_count_more);
            AppMethodBeat.o(33719);
            return;
        }
        textView.setText(String.valueOf(size));
        textView.setBackgroundResource(r.ik(this.context));
        AppMethodBeat.o(33719);
    }

    private void dHP() {
        AppMethodBeat.i(33720);
        if (this.context == null) {
            ab.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            AppMethodBeat.o(33720);
            return;
        }
        this.gbS = View.inflate(this.context, R.layout.a04, this);
        this.zmy = this.gbS.findViewById(R.id.buh);
        LayoutParams layoutParams = this.zmy.getLayoutParams();
        layoutParams.height = (int) (((float) com.tencent.mm.bz.a.am(this.context, R.dimen.f4)) * com.tencent.mm.bz.a.fZ(this.context));
        this.zmy.setLayoutParams(layoutParams);
        this.gbS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33715);
                ab.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
                com.tencent.mm.bp.d.b(k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                AppMethodBeat.o(33715);
            }
        });
        MaskLayout maskLayout = (MaskLayout) this.gbS.findViewById(R.id.bui);
        o.acd();
        ((ImageView) maskLayout.getContentView()).setImageBitmap(com.tencent.mm.ah.d.qh("fmessage"));
        AppMethodBeat.o(33720);
    }

    private void a(av avVar) {
        AppMethodBeat.i(33721);
        if (this.context == null) {
            ab.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            AppMethodBeat.o(33721);
            return;
        }
        if (com.tencent.mm.bz.a.ga(this.context)) {
            this.gbS = View.inflate(this.context, R.layout.a07, this);
        } else {
            this.gbS = View.inflate(this.context, R.layout.a06, this);
        }
        ((TextView) this.gbS.findViewById(R.id.bun)).setText(j.b(this.context, avVar.field_displayName));
        TextView textView = (TextView) this.gbS.findViewById(R.id.buo);
        ax apw = d.akO().apw(avVar.field_talker);
        String a = b.a(this.context, apw.field_type, avVar.field_addScene, apw.field_msgContent, !apw.dtf());
        if (ah.isNullOrNil(a)) {
            textView.setVisibility(8);
        } else {
            textView.setText(a);
        }
        this.zmy = this.gbS.findViewById(R.id.bug);
        this.gbS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33716);
                ab.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
                aw.ZK();
                c.Ry().set(143618, Integer.valueOf(0));
                com.tencent.mm.bp.d.b(k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                AppMethodBeat.o(33716);
            }
        });
        com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) ((MaskLayout) this.gbS.findViewById(R.id.bui)).getContentView(), avVar.field_talker);
        AppMethodBeat.o(33721);
    }

    private void fo(List<av> list) {
        AppMethodBeat.i(33722);
        if (this.context == null) {
            ab.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
            AppMethodBeat.o(33722);
            return;
        }
        this.gbS = View.inflate(this.context, R.layout.a05, this);
        int size = list.size();
        ab.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", Integer.valueOf(size));
        MaskLayout maskLayout = (MaskLayout) this.gbS.findViewById(R.id.bui);
        com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) maskLayout.getContentView(), ((av) list.get(0)).field_talker);
        maskLayout.setVisibility(0);
        maskLayout = (MaskLayout) this.gbS.findViewById(R.id.buk);
        com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) maskLayout.getContentView(), ((av) list.get(1)).field_talker);
        maskLayout.setVisibility(0);
        if (size > 2) {
            maskLayout = (MaskLayout) this.gbS.findViewById(R.id.bul);
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) maskLayout.getContentView(), ((av) list.get(2)).field_talker);
            maskLayout.setVisibility(0);
        }
        if (size > 3) {
            maskLayout = (MaskLayout) this.gbS.findViewById(R.id.bum);
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) maskLayout.getContentView(), ((av) list.get(3)).field_talker);
            maskLayout.setVisibility(0);
        }
        this.zmy = this.gbS.findViewById(R.id.bug);
        this.zmy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33717);
                ab.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
                aw.ZK();
                c.Ry().set(143618, Integer.valueOf(0));
                com.tencent.mm.bp.d.b(k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                AppMethodBeat.o(33717);
            }
        });
        AppMethodBeat.o(33722);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.i(33723);
        ab.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(z)));
        View findViewById = this.gbS.findViewById(R.id.bug);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
        this.isVisible = z;
        AppMethodBeat.o(33723);
    }

    private static void dHQ() {
        AppMethodBeat.i(33724);
        int dtd = d.akP().dtd();
        ab.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", Integer.valueOf(dtd));
        if (dtd > 0) {
            aw.ZK();
            c.Ry().set(143618, Integer.valueOf(dtd));
        }
        AppMethodBeat.o(33724);
    }

    public final void setFrontGround(boolean z) {
        this.zmA = z;
    }

    public static void dHR() {
        AppMethodBeat.i(33725);
        aw.ZK();
        if (c.XI()) {
            aw.ZK();
            if (c.Ry().getInt(143618, 0) > 0) {
                y.ab("fmessage", 2);
            }
        }
        aw.ZK();
        c.Ry().set(143618, Integer.valueOf(0));
        AppMethodBeat.o(33725);
    }
}
