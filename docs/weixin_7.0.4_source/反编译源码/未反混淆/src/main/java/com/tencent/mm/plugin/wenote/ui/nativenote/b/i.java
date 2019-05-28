package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class i extends a {
    public static float uUN = Resources.getSystem().getDisplayMetrics().density;
    public static int uUO = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int uUP = ((int) ((40.0f * uUN) + 0.5f));
    public ImageView cAw;
    public LinearLayout gCe;
    public OnClickListener nij = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(27168);
            if (i.this.uSJ.uQI == 2) {
                i.this.uSJ.uQw.dfP().deh();
                i.this.uSJ.deV();
            }
            int kj = ((v) view.getTag()).kj();
            ld ldVar = new ld();
            if (c.dem().Ke(kj) == null) {
                ab.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", Integer.valueOf(kj), Integer.valueOf(c.dem().size()));
                AppMethodBeat.o(27168);
            } else if (com.tencent.mm.plugin.wenote.model.c.ddG().uMN == null) {
                ab.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
                AppMethodBeat.o(27168);
            } else {
                ab.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", Integer.valueOf(c.dem().Ke(kj).getType()));
                ldVar.cGU.cGW = ((o) c.dem().Ke(kj)).uOo;
                ldVar.cGU.context = view.getContext();
                ldVar.cGU.type = 1;
                com.tencent.mm.plugin.wenote.model.c.ddG().uMN.b(ldVar);
                AppMethodBeat.o(27168);
            }
        }
    };
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

    public i(View view, k kVar) {
        super(view, kVar);
        this.cAw = (ImageView) view.findViewById(R.id.diw);
        this.uUF = view.findViewById(R.id.dix);
        this.uUB = (LinearLayout) view.findViewById(R.id.diy);
        this.gCe = (LinearLayout) view.findViewById(R.id.dj2);
        this.uUC = (TextView) view.findViewById(R.id.dj0);
        this.uUD = (TextView) view.findViewById(R.id.dj1);
        this.uUE = (ImageView) view.findViewById(R.id.diz);
        this.uUC.setTextSize(16.0f);
        this.uUD.setTextSize(12.0f);
        this.uUG = (LinearLayout) view.findViewById(R.id.dja);
        this.uUG.setVisibility(8);
        this.uUI = (LinearLayout) view.findViewById(R.id.djf);
        this.uUI.setVisibility(8);
        this.uUJ = (LinearLayout) view.findViewById(R.id.djc);
        this.uUJ.setVisibility(8);
        this.uUK = (LinearLayout) view.findViewById(R.id.dji);
        this.uUK.setBackgroundColor(1347529272);
        this.uUK.setVisibility(8);
        this.uUK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27165);
                e.dfb().dff();
                AppMethodBeat.o(27165);
            }
        });
        this.uUL = (LinearLayout) view.findViewById(R.id.dio);
        this.uUL.setBackgroundColor(1347529272);
        this.uUL.setVisibility(4);
        this.uUM = (LinearLayout) view.findViewById(R.id.djj);
        this.uUM.setBackgroundColor(1347529272);
        this.uUM.setVisibility(4);
        this.uUH = (LinearLayout) view.findViewById(R.id.din);
        LayoutParams layoutParams = (LayoutParams) this.uUH.getLayoutParams();
        layoutParams.width = uUO - uUP;
        layoutParams.height = -2;
        this.uUH.setLayoutParams(layoutParams);
        this.uUA = (WXRTEditText) view.findViewById(R.id.djn);
        this.uUz = (WXRTEditText) view.findViewById(R.id.djl);
        ((LinearLayout) view.findViewById(R.id.djm)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27166);
                i.this.uUA.deJ();
                i.this.uUA.requestFocus();
                AppMethodBeat.o(27166);
            }
        });
        ((LinearLayout) view.findViewById(R.id.djk)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27167);
                i.this.uUz.deJ();
                i.this.uUz.requestFocus();
                AppMethodBeat.o(27167);
            }
        });
        this.uUA.setEditTextType(2);
        this.uUz.setEditTextType(1);
        this.uUz.uPS = this;
        this.uUA.uPS = this;
        if (!(kVar.uQI == 2 && this.uSJ.uQJ)) {
            this.uUA.setKeyListener(null);
            this.uUA.setEnabled(false);
            this.uUA.setFocusable(false);
            this.uUz.setKeyListener(null);
            this.uUz.setEnabled(false);
            this.uUz.setFocusable(false);
        }
        this.uSJ.q(this.uUz);
        this.uSJ.q(this.uUA);
    }

    public void a(com.tencent.mm.plugin.wenote.model.a.c cVar, int i, int i2) {
        ab.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + ki());
        this.uUz.setPosInDataList(i);
        this.uUA.setPosInDataList(i);
        if (e.isEnabled()) {
            e.dfb().a(this.uUK, this.uUL, this.uUM, i);
        }
        cVar.uNW = this.uUz;
        cVar.uNX = this.uUA;
        cVar.uNY = null;
        if (!cVar.uNT) {
            if (this.uUz.hasFocus()) {
                this.uUz.clearFocus();
            }
            if (this.uUA.hasFocus()) {
                this.uUA.clearFocus();
            }
        } else if (cVar.uNZ) {
            this.uUz.requestFocus();
        } else {
            this.uUA.requestFocus();
        }
        if (this.uUB.getVisibility() != 0) {
            return;
        }
        if (cVar.uOa) {
            this.uUB.setBackgroundResource(R.drawable.a70);
        } else {
            this.uUB.setBackgroundResource(R.drawable.a6z);
        }
    }
}
