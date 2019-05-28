package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.C44329u;
import com.tencent.p177mm.p612ui.chatting.C44329u.C30575a;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;

@C15590a(dFp = C23733z.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ag */
public class C15598ag extends C44291a implements C23733z {
    private C5601o elS = null;
    private ListView yRA;
    private View yRB;
    private C44329u yRC;
    public boolean yRD = false;
    private boolean yRE = true;
    private int yRF = 0;
    private boolean yRG = false;
    private View yRq;
    public boolean yRr = false;
    public boolean yRs = false;
    public boolean yRt = false;
    public boolean yRu = false;
    public boolean yRv = false;
    private long yRw = -1;
    private ArrayList<String> yRx;
    public boolean yRy = false;
    private TextView yRz;

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$1 */
    class C155941 implements Runnable {
        C155941() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31643);
            if (!C15598ag.this.yRG) {
                C15598ag.this.yRG = true;
                C15598ag.this.yRw = -1;
                if (C15598ag.this.cgL != null) {
                    C15598ag.this.cgL.aWv();
                }
                C4990ab.m7416i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
            }
            AppMethodBeat.m2505o(31643);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$2 */
    class C155952 implements OnTouchListener {
        C155952() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(31644);
            C15598ag.this.cgL.aqX();
            AppMethodBeat.m2505o(31644);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$4 */
    class C155964 implements C30575a {
        C155964() {
        }

        /* renamed from: Oo */
        public final void mo27762Oo(int i) {
            AppMethodBeat.m2504i(31645);
            C15598ag.this.mo27764OD(i);
            AppMethodBeat.m2505o(31645);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$3 */
    class C155993 implements OnClickListener {
        C155993() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$5 */
    class C156005 implements OnItemClickListener {
        C156005() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(31646);
            C7620bi c7620bi = (C7620bi) C15598ag.this.yRC.getItem(i);
            if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.field_talker))) {
                C7060h.pYm.mo8381e(10450, Integer.valueOf(1));
                Intent intent = new Intent(C15598ag.this.cgL.yTx.getContext(), ChattingUI.class);
                intent.putExtra("Chat_User", c7620bi.field_talker);
                intent.putExtra("finish_direct", true);
                intent.putExtra("show_search_chat_content_result", false);
                intent.putExtra("msg_local_id", c7620bi.field_msgId);
                intent.putExtra("img_gallery_enter_from_chatting_ui", true);
                C15598ag.this.cgL.yTx.startActivity(intent);
            }
            AppMethodBeat.m2505o(31646);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$10 */
    class C1560110 implements OnItemClickListener {
        C1560110() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(31652);
            C7620bi c7620bi = (C7620bi) C15598ag.this.yRC.getItem(i);
            if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.field_talker))) {
                C15598ag.this.dEP();
                ((C15613i) C15598ag.this.cgL.mo74857aF(C15613i.class)).mo27828bd(c7620bi);
                if (!C15598ag.this.yRy) {
                    C15598ag.this.yRy = true;
                    C15598ag.this.cgL.yTz.setBottomViewVisible(true);
                    C15598ag.this.cgL.yTy.dCC();
                }
                C15598ag.this.cgL.yTz.dCA();
                C15598ag.this.cgL.yTz.setIsBottomShowAll(false);
                ((C15612h) C15598ag.this.cgL.mo74857aF(C15612h.class)).mo27803a(c7620bi.field_msgId, false, C40749a.ACTION_POSITION);
            }
            AppMethodBeat.m2505o(31652);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$7 */
    class C156027 implements C5600b {
        private int yRI = 0;

        /* renamed from: com.tencent.mm.ui.chatting.c.ag$7$1 */
        class C155971 implements Runnable {
            C155971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31648);
                C15598ag.this.cgL.yTx.dBP();
                AppMethodBeat.m2505o(31648);
            }
        }

        C156027() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(31649);
            if (C5046bo.isNullOrNil(str)) {
                this.yRI = 0;
                C15598ag.this.mo27764OD(-1);
                AppMethodBeat.m2505o(31649);
                return;
            }
            if (str.length() > this.yRI) {
                C7060h.pYm.mo8381e(10451, Integer.valueOf(1));
            }
            this.yRI = str.length();
            C7060h.pYm.mo8381e(10456, Integer.valueOf(1));
            C15598ag.this.yRC.mo70200vM(str);
            AppMethodBeat.m2505o(31649);
        }

        public final void apo() {
            AppMethodBeat.m2504i(31650);
            new C7306ak().post(new C155971());
            AppMethodBeat.m2505o(31650);
        }

        public final void app() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$8 */
    class C156038 implements OnClickListener {
        C156038() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$9 */
    class C156049 implements C30575a {
        C156049() {
        }

        /* renamed from: Oo */
        public final void mo27762Oo(int i) {
            AppMethodBeat.m2504i(31651);
            C15598ag.this.mo27764OD(i);
            AppMethodBeat.m2505o(31651);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ag$6 */
    class C156056 implements OnTouchListener {
        C156056() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(31647);
            C15598ag.this.cgL.aqX();
            AppMethodBeat.m2505o(31647);
            return false;
        }
    }

    public final ArrayList<String> dEM() {
        return this.yRx;
    }

    /* renamed from: ng */
    public final boolean mo27776ng(long j) {
        AppMethodBeat.m2504i(31653);
        if (this.yRw != j || !this.yRu || this.yRx == null || this.yRx.size() <= 0) {
            AppMethodBeat.m2505o(31653);
            return false;
        }
        AppMethodBeat.m2505o(31653);
        return true;
    }

    public final boolean dEN() {
        return this.yRt;
    }

    public final void dEO() {
        AppMethodBeat.m2504i(31654);
        String str = "MicroMsg.ChattingUI.SearchComponent";
        String str2 = "enter edit search mode, search stub view is null?%B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.yRq == null);
        C4990ab.m7419v(str, str2, objArr);
        this.yRD = true;
        this.cgL.mo74854Or(8);
        if (this.yRq != null) {
            this.yRq.setVisibility(0);
            if (this.yRC != null) {
                this.yRC.talker = this.cgL.getTalkerUserName();
            }
        } else {
            C40729i.m70424a(this.cgL.yTx, 2131822384);
            this.yRq = this.cgL.findViewById(2131822385);
            this.yRq.setVisibility(0);
            this.yRB = this.cgL.findViewById(2131827269);
            this.cgL.getListView().setFocusable(false);
            this.cgL.getListView().setFocusableInTouchMode(false);
            this.yRB.setOnClickListener(new C156038());
            this.yRB.setVisibility(8);
            this.yRz = (TextView) this.cgL.findViewById(2131822728);
            boolean z = this.cgL.dFw() || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn();
            this.yRC = new C44329u(this.cgL.yTx.getContext(), new C7620bi(), this.cgL.getTalkerUserName(), this.cgL.dFu(), z);
            this.yRC.yKp = new C156049();
            this.yRA = (ListView) this.cgL.findViewById(2131827268);
            this.yRA.setVisibility(0);
            this.yRA.setAdapter(this.yRC);
            this.yRA.setOnItemClickListener(new C1560110());
            this.yRA.setOnTouchListener(new C155952());
        }
        mo27764OD(-1);
        AppMethodBeat.m2505o(31654);
    }

    public final void dEP() {
        AppMethodBeat.m2504i(31655);
        C4990ab.m7418v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
        this.yRD = false;
        this.yRE = true;
        if (this.yRz != null) {
            this.yRz.setVisibility(8);
        }
        if (this.yRB != null) {
            this.yRB.setVisibility(8);
        }
        if (this.yRA != null) {
            this.yRA.setVisibility(8);
        }
        this.cgL.mo74854Or(0);
        this.cgL.aqX();
        AppMethodBeat.m2505o(31655);
    }

    public final boolean dEQ() {
        return this.yRD;
    }

    /* renamed from: OD */
    public final void mo27764OD(int i) {
        AppMethodBeat.m2504i(31656);
        C4990ab.m7417i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", Integer.valueOf(i), Boolean.valueOf(this.yRD), Boolean.valueOf(this.yRE));
        if (this.yRr || this.yRD) {
            if (this.yRE && i >= 0) {
                this.yRE = false;
                C7060h.pYm.mo8381e(10811, Integer.valueOf(2));
            }
            if (i > 0) {
                this.yRA.setVisibility(0);
                this.cgL.mo74854Or(8);
                this.yRz.setVisibility(8);
                this.yRB.setVisibility(8);
                AppMethodBeat.m2505o(31656);
                return;
            } else if (i == 0) {
                this.yRA.setVisibility(8);
                this.cgL.mo74854Or(8);
                this.yRz.setVisibility(0);
                this.yRB.setVisibility(8);
                AppMethodBeat.m2505o(31656);
                return;
            } else {
                this.yRA.setVisibility(8);
                this.cgL.mo74854Or(0);
                this.yRz.setVisibility(8);
                this.yRB.setVisibility(0);
                AppMethodBeat.m2505o(31656);
                return;
            }
        }
        C4990ab.m7410d("MicroMsg.ChattingUI.SearchComponent", "not search now");
        AppMethodBeat.m2505o(31656);
    }

    public final C44329u dER() {
        return this.yRC;
    }

    public final boolean dES() {
        return this.yRs;
    }

    public final boolean dET() {
        return this.yRr;
    }

    public final boolean dEU() {
        return this.yRu;
    }

    public final boolean dEV() {
        return this.yRv;
    }

    public final boolean dEW() {
        return this.yRy;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31657);
        super.onActivityResult(i, i2, intent);
        if (((C15612h) this.cgL.mo74857aF(C15612h.class)).isInEditMode() && this.yRD) {
            dEP();
        }
        AppMethodBeat.m2505o(31657);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31658);
        super.dDh();
        this.yRG = true;
        if (this.yRC != null) {
            this.yRC.bIf();
        }
        if (this.elS != null) {
            this.elS.clearFocus();
        }
        AppMethodBeat.m2505o(31658);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31659);
        this.yRr = this.cgL.yTx.getBooleanExtra("search_chat_content", false).booleanValue();
        this.yRs = this.cgL.yTx.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
        this.yRx = this.cgL.yTx.getStringArrayList("highlight_keyword_list");
        this.yRw = this.cgL.yTx.getLongExtra("msg_local_id", -1);
        this.yRu = this.cgL.yTx.getBooleanExtra("from_global_search", false).booleanValue();
        this.yRv = this.cgL.yTx.getBooleanExtra("from_date_search", false).booleanValue();
        this.yRt = this.cgL.yTx.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
        AppMethodBeat.m2505o(31659);
    }

    public final void dxy() {
        boolean z = true;
        AppMethodBeat.m2504i(31660);
        if (this.yRw >= 0 && !this.yRG) {
            C5004al.m7442n(new C155941(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        if (this.yRr) {
            C4990ab.m7416i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
            C7060h.pYm.mo8378a(219, 11, 1, true);
            C40729i.m70424a(this.cgL.yTx, 2131822384);
            this.yRq = this.cgL.findViewById(2131822385);
            this.yRB = this.cgL.findViewById(2131827269);
            this.cgL.getListView().setFocusable(false);
            this.cgL.getListView().setFocusableInTouchMode(false);
            this.yRB.setOnClickListener(new C155993());
            if (this.yRz == null) {
                C40729i.m70424a(this.cgL.yTx, 2131822380);
                this.yRz = (TextView) this.cgL.findViewById(2131822728);
            }
            boolean z2 = this.cgL.dFw() || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn();
            this.yRC = new C44329u(this.cgL.yTx.getContext(), new C7620bi(), this.cgL.getTalkerUserName(), this.cgL.dFu(), z2);
            this.yRC.yKp = new C155964();
            this.yRA = (ListView) this.cgL.findViewById(2131827268);
            this.yRA.setAdapter(this.yRC);
            this.yRA.setOnItemClickListener(new C156005());
            this.yRA.setOnTouchListener(new C156056());
            this.elS = new C5601o();
            this.elS.zHa = new C156027();
            this.cgL.yTx.addSearchMenu(true, this.elS);
            this.elS.mo11371qQ(true);
        }
        if (this.yRs || this.yRu || this.yRv) {
            long longExtra = this.cgL.yTx.getLongExtra("msg_local_id", -1);
            C15612h c15612h = (C15612h) this.cgL.mo74857aF(C15612h.class);
            if (!this.yRu || this.yRv) {
                z = false;
            }
            c15612h.mo27803a(longExtra, z, C40749a.ACTION_POSITION);
        }
        AppMethodBeat.m2505o(31660);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31661);
        if (this.yRD) {
            dEP();
            ((C15613i) this.cgL.mo74857aF(C15613i.class)).dDO();
        }
        AppMethodBeat.m2505o(31661);
    }
}
