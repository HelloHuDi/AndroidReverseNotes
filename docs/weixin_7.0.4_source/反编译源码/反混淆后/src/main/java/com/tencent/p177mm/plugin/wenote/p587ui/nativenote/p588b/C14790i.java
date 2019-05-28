package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.content.res.Resources;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.i */
public abstract class C14790i extends C4689a {
    public static float uUN = Resources.getSystem().getDisplayMetrics().density;
    public static int uUO = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int uUP = ((int) ((40.0f * uUN) + 0.5f));
    public ImageView cAw;
    public LinearLayout gCe;
    public OnClickListener nij = new C147944();
    public WXRTEditText uUA;
    public LinearLayout uUB;
    public TextView uUC;
    public TextView uUD;
    public ImageView uUE;
    public View uUF;
    public LinearLayout uUG;
    public LinearLayout uUH;
    public LinearLayout uUI;
    public LinearLayout uUJ;
    public LinearLayout uUK;
    public LinearLayout uUL;
    public LinearLayout uUM;
    public WXRTEditText uUz;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.i$1 */
    class C147911 implements OnClickListener {
        C147911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27165);
            C4675e.dfb().dff();
            AppMethodBeat.m2505o(27165);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.i$2 */
    class C147922 implements OnClickListener {
        C147922() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27166);
            C14790i.this.uUA.deJ();
            C14790i.this.uUA.requestFocus();
            AppMethodBeat.m2505o(27166);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.i$3 */
    class C147933 implements OnClickListener {
        C147933() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27167);
            C14790i.this.uUz.deJ();
            C14790i.this.uUz.requestFocus();
            AppMethodBeat.m2505o(27167);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.i$4 */
    class C147944 implements OnClickListener {
        C147944() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27168);
            if (C14790i.this.uSJ.uQI == 2) {
                C14790i.this.uSJ.uQw.dfP().deh();
                C14790i.this.uSJ.deV();
            }
            int kj = ((C41531v) view.getTag()).mo66454kj();
            C18313ld c18313ld = new C18313ld();
            if (C40380c.dem().mo63750Ke(kj) == null) {
                C4990ab.m7413e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", Integer.valueOf(kj), Integer.valueOf(C40380c.dem().size()));
                AppMethodBeat.m2505o(27168);
            } else if (C46453c.ddG().uMN == null) {
                C4990ab.m7412e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
                AppMethodBeat.m2505o(27168);
            } else {
                C4990ab.m7417i("Micromsg.NoteOtherItemHolder", "click item, type is %d", Integer.valueOf(C40380c.dem().mo63750Ke(kj).getType()));
                c18313ld.cGU.cGW = ((C29978o) C40380c.dem().mo63750Ke(kj)).uOo;
                c18313ld.cGU.context = view.getContext();
                c18313ld.cGU.type = 1;
                C46453c.ddG().uMN.mo63730b(c18313ld);
                AppMethodBeat.m2505o(27168);
            }
        }
    }

    public C14790i(View view, C46457k c46457k) {
        super(view, c46457k);
        this.cAw = (ImageView) view.findViewById(2131826385);
        this.uUF = view.findViewById(2131826386);
        this.uUB = (LinearLayout) view.findViewById(2131826387);
        this.gCe = (LinearLayout) view.findViewById(2131826391);
        this.uUC = (TextView) view.findViewById(2131826389);
        this.uUD = (TextView) view.findViewById(2131826390);
        this.uUE = (ImageView) view.findViewById(2131826388);
        this.uUC.setTextSize(16.0f);
        this.uUD.setTextSize(12.0f);
        this.uUG = (LinearLayout) view.findViewById(2131826400);
        this.uUG.setVisibility(8);
        this.uUI = (LinearLayout) view.findViewById(2131826405);
        this.uUI.setVisibility(8);
        this.uUJ = (LinearLayout) view.findViewById(2131826402);
        this.uUJ.setVisibility(8);
        this.uUK = (LinearLayout) view.findViewById(2131826408);
        this.uUK.setBackgroundColor(1347529272);
        this.uUK.setVisibility(8);
        this.uUK.setOnClickListener(new C147911());
        this.uUL = (LinearLayout) view.findViewById(2131826377);
        this.uUL.setBackgroundColor(1347529272);
        this.uUL.setVisibility(4);
        this.uUM = (LinearLayout) view.findViewById(2131826409);
        this.uUM.setBackgroundColor(1347529272);
        this.uUM.setVisibility(4);
        this.uUH = (LinearLayout) view.findViewById(2131826376);
        LayoutParams layoutParams = (LayoutParams) this.uUH.getLayoutParams();
        layoutParams.width = uUO - uUP;
        layoutParams.height = -2;
        this.uUH.setLayoutParams(layoutParams);
        this.uUA = (WXRTEditText) view.findViewById(2131826413);
        this.uUz = (WXRTEditText) view.findViewById(2131826411);
        ((LinearLayout) view.findViewById(2131826412)).setOnClickListener(new C147922());
        ((LinearLayout) view.findViewById(2131826410)).setOnClickListener(new C147933());
        this.uUA.setEditTextType(2);
        this.uUz.setEditTextType(1);
        this.uUz.uPS = this;
        this.uUA.uPS = this;
        if (!(c46457k.uQI == 2 && this.uSJ.uQJ)) {
            this.uUA.setKeyListener(null);
            this.uUA.setEnabled(false);
            this.uUA.setFocusable(false);
            this.uUz.setKeyListener(null);
            this.uUz.setEnabled(false);
            this.uUz.setFocusable(false);
        }
        this.uSJ.mo74685q(this.uUz);
        this.uSJ.mo74685q(this.uUA);
    }

    /* renamed from: a */
    public void mo9809a(C44001c c44001c, int i, int i2) {
        C4990ab.m7416i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + mo66453ki());
        this.uUz.setPosInDataList(i);
        this.uUA.setPosInDataList(i);
        if (C4675e.isEnabled()) {
            C4675e.dfb().mo9780a(this.uUK, this.uUL, this.uUM, i);
        }
        c44001c.uNW = this.uUz;
        c44001c.uNX = this.uUA;
        c44001c.uNY = null;
        if (!c44001c.uNT) {
            if (this.uUz.hasFocus()) {
                this.uUz.clearFocus();
            }
            if (this.uUA.hasFocus()) {
                this.uUA.clearFocus();
            }
        } else if (c44001c.uNZ) {
            this.uUz.requestFocus();
        } else {
            this.uUA.requestFocus();
        }
        if (this.uUB.getVisibility() != 0) {
            return;
        }
        if (c44001c.uOa) {
            this.uUB.setBackgroundResource(C25738R.drawable.a70);
        } else {
            this.uUB.setBackgroundResource(C25738R.drawable.a6z);
        }
    }
}
