package com.tencent.p177mm.p612ui.contact;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7568av;
import com.tencent.p177mm.storage.C7569ax;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.k */
public final class C5458k extends RelativeLayout {
    public static Boolean zmx = Boolean.TRUE;
    private Context context = null;
    private View gbS = null;
    private boolean isVisible = true;
    private final C7564ap yNs = new C7564ap(new C54601(), true);
    private boolean zmA = false;
    private View zmy = null;
    C4931a zmz = new C54612();

    /* renamed from: com.tencent.mm.ui.contact.k$5 */
    class C54575 implements OnClickListener {
        C54575() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33716);
            C4990ab.m7410d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(143618, Integer.valueOf(0));
            C25985d.m41467b(C5458k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
            AppMethodBeat.m2505o(33716);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.k$6 */
    class C54596 implements OnClickListener {
        C54596() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33717);
            C4990ab.m7410d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(143618, Integer.valueOf(0));
            C25985d.m41467b(C5458k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
            AppMethodBeat.m2505o(33717);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.k$1 */
    class C54601 implements C5015a {
        C54601() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(33712);
            C4990ab.m7410d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            C5458k.dHS();
            C5458k.m8266a(C5458k.this);
            AppMethodBeat.m2505o(33712);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.k$2 */
    class C54612 implements C4931a {
        C54612() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            long j;
            AppMethodBeat.m2504i(33713);
            C4990ab.m7410d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
            if (!C5458k.this.yNs.doT()) {
                C5458k.this.yNs.stopTimer();
            }
            C7564ap b = C5458k.this.yNs;
            if (C5458k.this.zmA) {
                j = 500;
            } else {
                j = 1000;
            }
            b.mo16770ae(j, j);
            AppMethodBeat.m2505o(33713);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.k$3 */
    class C54623 implements OnTouchListener {
        C54623() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(33714);
            if (C5458k.this.context instanceof MMActivity) {
                ((MMActivity) C5458k.this.context).aqX();
            }
            AppMethodBeat.m2505o(33714);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.k$4 */
    class C54634 implements OnClickListener {
        C54634() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33715);
            C4990ab.m7410d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
            C25985d.m41467b(C5458k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
            AppMethodBeat.m2505o(33715);
        }
    }

    static /* synthetic */ void dHS() {
        AppMethodBeat.m2504i(33726);
        C5458k.dHQ();
        AppMethodBeat.m2505o(33726);
    }

    public C5458k(Context context) {
        super(context);
        AppMethodBeat.m2504i(33718);
        this.context = context;
        C41789d.akP().mo10116c(this.zmz);
        C5458k.dHQ();
        init();
        AppMethodBeat.m2505o(33718);
    }

    private void init() {
        AppMethodBeat.m2504i(33719);
        List dtb = C41789d.akP().dtb();
        int size = dtb.size();
        C4990ab.m7411d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", Integer.valueOf(size));
        removeAllViews();
        if (size <= 0) {
            dHP();
        } else if (size == 1) {
            m8265a((C7568av) dtb.get(0));
        } else {
            m8270fo(dtb);
        }
        View findViewById = this.gbS.findViewById(2131824076);
        if (findViewById != null) {
            int i;
            if (this.isVisible) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
        this.zmy.setOnTouchListener(new C54623());
        size = C41789d.akP().dtd();
        C4990ab.m7411d("MicroMsg.FMessageContactView", "init totalNewSize = %d", Integer.valueOf(size));
        TextView textView = (TextView) this.gbS.findViewById(2131824079);
        textView.setBackgroundResource(C44385r.m80243ik(this.context));
        if (size <= 0) {
            textView.setVisibility(8);
            zmx = Boolean.FALSE;
            AppMethodBeat.m2505o(33719);
            return;
        }
        textView.setVisibility(0);
        zmx = Boolean.TRUE;
        if (size > 99) {
            textView.setText("");
            textView.setBackgroundResource(C1318a.badge_count_more);
            AppMethodBeat.m2505o(33719);
            return;
        }
        textView.setText(String.valueOf(size));
        textView.setBackgroundResource(C44385r.m80243ik(this.context));
        AppMethodBeat.m2505o(33719);
    }

    private void dHP() {
        AppMethodBeat.m2504i(33720);
        if (this.context == null) {
            C4990ab.m7420w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            AppMethodBeat.m2505o(33720);
            return;
        }
        this.gbS = View.inflate(this.context, 2130969572, this);
        this.zmy = this.gbS.findViewById(2131824077);
        LayoutParams layoutParams = this.zmy.getLayoutParams();
        layoutParams.height = (int) (((float) C1338a.m2857am(this.context, C25738R.dimen.f9768f4)) * C1338a.m2863fZ(this.context));
        this.zmy.setLayoutParams(layoutParams);
        this.gbS.setOnClickListener(new C54634());
        MaskLayout maskLayout = (MaskLayout) this.gbS.findViewById(2131824078);
        C17884o.acd();
        ((ImageView) maskLayout.getContentView()).setImageBitmap(C41732d.m73527qh("fmessage"));
        AppMethodBeat.m2505o(33720);
    }

    /* renamed from: a */
    private void m8265a(C7568av c7568av) {
        AppMethodBeat.m2504i(33721);
        if (this.context == null) {
            C4990ab.m7420w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            AppMethodBeat.m2505o(33721);
            return;
        }
        if (C1338a.m2865ga(this.context)) {
            this.gbS = View.inflate(this.context, 2130969575, this);
        } else {
            this.gbS = View.inflate(this.context, 2130969574, this);
        }
        ((TextView) this.gbS.findViewById(2131824083)).setText(C44089j.m79292b(this.context, c7568av.field_displayName));
        TextView textView = (TextView) this.gbS.findViewById(2131824084);
        C7569ax apw = C41789d.akO().apw(c7568av.field_talker);
        String a = C14957b.m23240a(this.context, apw.field_type, c7568av.field_addScene, apw.field_msgContent, !apw.dtf());
        if (C42252ah.isNullOrNil(a)) {
            textView.setVisibility(8);
        } else {
            textView.setText(a);
        }
        this.zmy = this.gbS.findViewById(2131824076);
        this.gbS.setOnClickListener(new C54575());
        C40460b.m69434b((ImageView) ((MaskLayout) this.gbS.findViewById(2131824078)).getContentView(), c7568av.field_talker);
        AppMethodBeat.m2505o(33721);
    }

    /* renamed from: fo */
    private void m8270fo(List<C7568av> list) {
        AppMethodBeat.m2504i(33722);
        if (this.context == null) {
            C4990ab.m7420w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
            AppMethodBeat.m2505o(33722);
            return;
        }
        this.gbS = View.inflate(this.context, 2130969573, this);
        int size = list.size();
        C4990ab.m7411d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", Integer.valueOf(size));
        MaskLayout maskLayout = (MaskLayout) this.gbS.findViewById(2131824078);
        C40460b.m69434b((ImageView) maskLayout.getContentView(), ((C7568av) list.get(0)).field_talker);
        maskLayout.setVisibility(0);
        maskLayout = (MaskLayout) this.gbS.findViewById(2131824080);
        C40460b.m69434b((ImageView) maskLayout.getContentView(), ((C7568av) list.get(1)).field_talker);
        maskLayout.setVisibility(0);
        if (size > 2) {
            maskLayout = (MaskLayout) this.gbS.findViewById(2131824081);
            C40460b.m69434b((ImageView) maskLayout.getContentView(), ((C7568av) list.get(2)).field_talker);
            maskLayout.setVisibility(0);
        }
        if (size > 3) {
            maskLayout = (MaskLayout) this.gbS.findViewById(2131824082);
            C40460b.m69434b((ImageView) maskLayout.getContentView(), ((C7568av) list.get(3)).field_talker);
            maskLayout.setVisibility(0);
        }
        this.zmy = this.gbS.findViewById(2131824076);
        this.zmy.setOnClickListener(new C54596());
        AppMethodBeat.m2505o(33722);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.m2504i(33723);
        C4990ab.m7410d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(z)));
        View findViewById = this.gbS.findViewById(2131824076);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
        this.isVisible = z;
        AppMethodBeat.m2505o(33723);
    }

    private static void dHQ() {
        AppMethodBeat.m2504i(33724);
        int dtd = C41789d.akP().dtd();
        C4990ab.m7419v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", Integer.valueOf(dtd));
        if (dtd > 0) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(143618, Integer.valueOf(dtd));
        }
        AppMethodBeat.m2505o(33724);
    }

    public final void setFrontGround(boolean z) {
        this.zmA = z;
    }

    public static void dHR() {
        AppMethodBeat.m2504i(33725);
        C9638aw.m17190ZK();
        if (C18628c.m29074XI()) {
            C9638aw.m17190ZK();
            if (C18628c.m29072Ry().getInt(143618, 0) > 0) {
                C37951y.m64163ab("fmessage", 2);
            }
        }
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(143618, Integer.valueOf(0));
        AppMethodBeat.m2505o(33725);
    }
}
