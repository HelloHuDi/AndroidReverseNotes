package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.os.Looper;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.k */
public class C16728k extends C11376a<C42884n> {
    private String edV;
    private String kuA;
    private C8910b kul;
    public String kuu;
    private String kux;
    private Integer kuy;
    private String kuz;

    /* renamed from: T */
    public final /* synthetic */ void mo23108T(C41531v c41531v) {
        AppMethodBeat.m2504i(54322);
        m25751a((C42884n) c41531v);
        AppMethodBeat.m2505o(54322);
    }

    private C8910b bfv() {
        AppMethodBeat.m2504i(54311);
        if (this.kul == null) {
            this.kul = C8910b.m16064me(this.kua.field_content);
        }
        C8910b c8910b = this.kul;
        AppMethodBeat.m2505o(54311);
        return c8910b;
    }

    public String getUsername() {
        AppMethodBeat.m2504i(54312);
        if (this.edV == null) {
            this.edV = C42887b.m76161b(this.kua, C1855t.m3896kH(this.kuu));
        }
        String str = this.edV;
        AppMethodBeat.m2505o(54312);
        return str;
    }

    public String bfo() {
        AppMethodBeat.m2504i(54313);
        String str;
        if (bfv() != null) {
            str = bfv().fgp;
            AppMethodBeat.m2505o(54313);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(54313);
        return str;
    }

    public int bfw() {
        AppMethodBeat.m2504i(54314);
        if (this.kuy == null) {
            this.kuy = Integer.valueOf(C45932c.m85252LX(bfo()));
        }
        int intValue = this.kuy.intValue();
        AppMethodBeat.m2505o(54314);
        return intValue;
    }

    public String getFileName() {
        AppMethodBeat.m2504i(54315);
        String str;
        if (bfv() != null) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.kuu);
            if (aoO != null) {
                this.kux = aoO.mo16706Oi();
            }
            str = bfv().title;
            AppMethodBeat.m2505o(54315);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(54315);
        return str;
    }

    public int bfp() {
        AppMethodBeat.m2504i(54316);
        if (bfv() != null) {
            int i = bfv().fgo;
            AppMethodBeat.m2505o(54316);
            return i;
        }
        AppMethodBeat.m2505o(54316);
        return 0;
    }

    private String bfx() {
        AppMethodBeat.m2504i(54317);
        if (this.kuz == null) {
            C7577u c7577u = null;
            if (C1855t.m3896kH(this.kuu)) {
                c7577u = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.kuu);
            }
            if (c7577u != null) {
                this.kuz = c7577u.mo16807mJ(getUsername());
            } else {
                this.kuz = "";
            }
        }
        String str = this.kuz;
        AppMethodBeat.m2505o(54317);
        return str;
    }

    /* renamed from: Hr */
    private String m25749Hr() {
        AppMethodBeat.m2504i(54318);
        if (this.kuA == null) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.kuu);
            if (aoO != null) {
                this.kuA = aoO.field_conRemark;
            } else {
                this.kuA = "";
            }
        }
        String str = this.kuA;
        AppMethodBeat.m2505o(54318);
        return str;
    }

    public C16728k(C33817g c33817g, C7620bi c7620bi, String str) {
        super(c33817g, c7620bi);
        this.kuu = str;
    }

    /* renamed from: a */
    public void mo6913a(View view, C11376a c11376a) {
        AppMethodBeat.m2504i(54319);
        if (!(bfn().mo68416gZ(this.kua.field_msgId) || mo23124kq())) {
            if (isEnable()) {
                C42887b.m76164f(getContext(), this.kua.field_msgId);
                AppMethodBeat.m2505o(54319);
                return;
            }
            C42887b.m76153I(getContext(), bfn().mMaxCount);
        }
        AppMethodBeat.m2505o(54319);
    }

    /* renamed from: a */
    private void m25751a(final C42884n c42884n) {
        AppMethodBeat.m2504i(54320);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            m25752b(c42884n);
            AppMethodBeat.m2505o(54320);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(54310);
                C16728k.m25750a(C16728k.this, c42884n);
                AppMethodBeat.m2505o(54310);
            }
        });
        AppMethodBeat.m2505o(54320);
    }

    /* renamed from: b */
    private void m25752b(C42884n c42884n) {
        AppMethodBeat.m2504i(54321);
        switch (this.kuk) {
            case 0:
                c42884n.gtQ.setVisibility(8);
                c42884n.kuH.setVisibility(8);
                c42884n.kuN.setVisibility(0);
                c42884n.kuR.setVisibility(0);
                c42884n.kuN.setChecked(false);
                c42884n.kuP.setVisibility(8);
                break;
            case 1:
                c42884n.gtQ.setVisibility(0);
                c42884n.kuH.setVisibility(8);
                c42884n.kuN.setVisibility(8);
                c42884n.kuR.setVisibility(8);
                c42884n.kuP.setVisibility(8);
                AppMethodBeat.m2505o(54321);
                return;
            case 2:
                c42884n.gtQ.setVisibility(0);
                c42884n.kuH.setVisibility(0);
                c42884n.kuN.setVisibility(8);
                c42884n.kuR.setVisibility(8);
                c42884n.kuP.setVisibility(8);
                if (this.alq > 0) {
                    int i = (int) ((((float) this.f2899Lp) / ((float) this.alq)) * 100.0f);
                    if (i == -1 || i >= 100) {
                        c42884n.kuH.setProgress(100);
                        AppMethodBeat.m2505o(54321);
                        return;
                    }
                    c42884n.kuH.setProgress(i);
                    AppMethodBeat.m2505o(54321);
                    return;
                }
                break;
            case 3:
                c42884n.gtQ.setVisibility(8);
                c42884n.kuH.setVisibility(8);
                c42884n.kuN.setVisibility(0);
                c42884n.kuR.setVisibility(0);
                c42884n.kuP.setVisibility(8);
                AppMethodBeat.m2505o(54321);
                return;
            case 4:
                c42884n.gtQ.setVisibility(8);
                c42884n.kuH.setVisibility(8);
                c42884n.kuN.setVisibility(8);
                c42884n.kuR.setVisibility(8);
                c42884n.kuP.setVisibility(0);
                c42884n.hrg.setText(bfo().toUpperCase() + " " + getContext().getString(C25738R.string.apj));
                AppMethodBeat.m2505o(54321);
                return;
            case 5:
                c42884n.gtQ.setVisibility(8);
                c42884n.kuH.setVisibility(8);
                c42884n.kuN.setVisibility(8);
                c42884n.kuR.setVisibility(8);
                c42884n.kuP.setVisibility(0);
                c42884n.hrg.setText(bfo().toUpperCase() + " " + getContext().getString(C25738R.string.api));
                AppMethodBeat.m2505o(54321);
                return;
        }
        AppMethodBeat.m2505o(54321);
    }

    public int getType() {
        return 1;
    }
}
