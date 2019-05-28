package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.h;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class b extends p<j> {
    private int itemHeight;
    private int itemWidth;
    a qzA;
    int qzB = R.string.ei4;
    int qzC = 0;
    private int qzD;
    private int qzE;
    private c qzF = new c() {
        public final void r(String str, Bitmap bitmap) {
            AppMethodBeat.i(24996);
            for (e eVar : b.this.qzy) {
                if (eVar.qzO != null && bo.bc(str, "").equals(eVar.qzO.field_fileName)) {
                    eVar.qzM.setThumbBmp(bitmap);
                    break;
                }
            }
            AppMethodBeat.o(24996);
        }
    };
    e qzG;
    a qzv = new a(this, (byte) 0);
    private b qzw = new b(this, (byte) 0);
    private c qzx = new c(this, (byte) 0);
    private Set<e> qzy = new HashSet();
    private d qzz = d.NORMAL;

    class b implements OnLongClickListener {
        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(24999);
            if (view.getTag() instanceof e) {
                e eVar = (e) view.getTag();
                if (eVar.qzO == null) {
                    AppMethodBeat.o(24999);
                } else if (-1 == eVar.qzO.field_fileStatus) {
                    AppMethodBeat.o(24999);
                } else {
                    b.this.a(d.EDIT, true);
                    AppMethodBeat.o(24999);
                }
            } else {
                AppMethodBeat.o(24999);
            }
            return true;
        }
    }

    static final class e {
        View gbS;
        TextView iqU;
        ImageView moR;
        ImageView qpr;
        View qzL;
        com.tencent.mm.plugin.sight.decode.a.a qzM;
        View qzN;
        j qzO;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    class c implements OnClickListener {
        private c() {
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(25000);
            if (view.getTag() instanceof e) {
                b.this.qzv.clw();
                e eVar = (e) view.getTag();
                if (eVar.qzO == null) {
                    ab.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
                    AppMethodBeat.o(25000);
                    return;
                }
                eVar.qzO.field_fileStatus = 6;
                o.alp().c(eVar.qzO, "localId");
                b.this.a(null, null);
                if (b.this.qzA != null) {
                    b.this.qzA;
                }
                AppMethodBeat.o(25000);
                return;
            }
            AppMethodBeat.o(25000);
        }
    }

    public enum d {
        NORMAL,
        EDIT;

        static {
            AppMethodBeat.o(25003);
        }
    }

    class a implements OnClickListener {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.i(24997);
            if (view.getTag() instanceof e) {
                e eVar = (e) view.getTag();
                if (eVar.qzO == null) {
                    ab.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", b.this.qzz);
                    clw();
                    b.this.qzG = null;
                    AppMethodBeat.o(24997);
                    return;
                }
                if (b.this.qzG != eVar) {
                    clw();
                    String tX = k.tX(eVar.qzO.field_fileName);
                    eVar.qzM.setCanPlay(true);
                    eVar.qzM.bf(tX, false);
                    eVar.moR.setBackgroundResource(R.drawable.bht);
                    View view2 = eVar.qzL;
                    if (!(view2 == null || com.tencent.mm.compatible.util.d.fP(11))) {
                        Animator animator = (Animator) view2.getTag(R.id.c8);
                        if (animator != null) {
                            animator.cancel();
                        }
                        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view2.getContext(), R.animator.d);
                        animatorSet.setTarget(view2);
                        animatorSet.start();
                        view2.setTag(R.id.c8, animatorSet);
                    }
                    b.b(b.this, eVar);
                    b.this.qzG = eVar;
                }
                if (b.this.qzA != null) {
                    b.this.qzA.clu();
                }
                AppMethodBeat.o(24997);
                return;
            }
            AppMethodBeat.o(24997);
        }

        public final boolean clw() {
            AppMethodBeat.i(24998);
            if (b.this.qzG != null) {
                b.this.qzG.iqU.setVisibility(8);
                b.this.qzG.qzM.setCanPlay(false);
                b.this.qzG.qzM.bf(null, false);
                b.this.qzG.qzM.setThumbBmp(b.this.qzF.x(b.this.qzG.qzO.field_fileName, k.tY(b.this.qzG.qzO.field_fileName), true));
                b.this.qzG.moR.setBackgroundResource(R.drawable.bhs);
                h.r(b.this.qzG.qzL, 1.0f);
                b.this.qzG = null;
                AppMethodBeat.o(24998);
                return true;
            }
            AppMethodBeat.o(24998);
            return false;
        }
    }

    static final class f {
        List<e> qzP;

        private f() {
            AppMethodBeat.i(25004);
            this.qzP = new LinkedList();
            AppMethodBeat.o(25004);
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    static /* synthetic */ void b(b bVar, e eVar) {
        AppMethodBeat.i(25014);
        bVar.a(eVar);
        AppMethodBeat.o(25014);
    }

    public b(Context context, a aVar) {
        super(context, null);
        AppMethodBeat.i(25005);
        this.qzA = aVar;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.a8j) * 2;
        this.qzD = context.getResources().getDisplayMetrics().widthPixels / 3;
        this.itemWidth = this.qzD - dimensionPixelSize;
        this.itemHeight = (this.itemWidth * 3) / 4;
        this.qzE = dimensionPixelSize + this.itemHeight;
        AppMethodBeat.o(25005);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        AppMethodBeat.i(25006);
        if (view == null) {
            f fVar2 = new f();
            view = new LinearLayout(viewGroup.getContext());
            view.setOrientation(0);
            for (int i2 = 0; i2 < 3; i2++) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.at7, view, false);
                e eVar = new e();
                eVar.gbS = inflate;
                eVar.gbS.setTag(eVar);
                eVar.qzL = inflate.findViewById(R.id.eds);
                eVar.qzM = (com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.id.edt);
                eVar.moR = (ImageView) inflate.findViewById(R.id.edu);
                eVar.qzN = inflate.findViewById(R.id.edw);
                eVar.iqU = (TextView) inflate.findViewById(R.id.edv);
                eVar.iqU.setText(this.qzB);
                eVar.qpr = (ImageView) inflate.findViewById(R.id.edx);
                fVar2.qzP.add(eVar);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.height = this.qzE;
                view.addView(inflate);
                inflate.setOnClickListener(this.qzv);
                eVar.qpr.setTag(eVar);
                eVar.qpr.setOnClickListener(this.qzx);
            }
            view.setTag(fVar2);
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
        }
        for (int i3 = 0; i3 < fVar.qzP.size(); i3++) {
            int i4 = (i * 3) + i3;
            e eVar2 = (e) fVar.qzP.get(i3);
            this.qzy.add(eVar2);
            eVar2.qzN.setVisibility(8);
            eVar2.iqU.setVisibility(8);
            eVar2.moR.setBackgroundResource(R.drawable.bhs);
            eVar2.qzM.bf(null, false);
            eVar2.qzM.setCanPlay(false);
            eVar2.qzM.setForceRecordState(false);
            ((ImageView) eVar2.qzM).setBackgroundResource(0);
            if (i4 >= getRealCount()) {
                eVar2.qzO = null;
                eVar2.gbS.setVisibility(4);
                h.r(eVar2.qzL, 1.0f);
            } else {
                this.qzC--;
                j jVar = (j) getItem(i4);
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    boolean z;
                    eVar2.qzO = jVar;
                    c cVar = this.qzF;
                    String str = jVar.field_fileName;
                    String tY = k.tY(jVar.field_fileName);
                    if (this.qzC <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Bitmap x = cVar.x(str, tY, z);
                    ((ImageView) eVar2.qzM).setScaleType(ScaleType.CENTER_CROP);
                    eVar2.qzM.setThumbBmp(x);
                } else {
                    eVar2.qzO = null;
                    eVar2.qzM.ckX();
                }
                if (d.EDIT == this.qzz) {
                    eVar2.qpr.setVisibility(0);
                    h.r(eVar2.qzL, 0.95f);
                } else {
                    eVar2.qpr.setVisibility(8);
                    h.r(eVar2.qzL, 1.0f);
                }
                eVar2.gbS.setVisibility(0);
            }
        }
        AppMethodBeat.o(25006);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final void a(e eVar) {
        AppMethodBeat.i(25007);
        if (eVar == null) {
            for (e eVar2 : this.qzy) {
                eVar2.qzN.setVisibility(8);
            }
            AppMethodBeat.o(25007);
            return;
        }
        for (e eVar22 : this.qzy) {
            eVar22.qzN.setVisibility(eVar == eVar22 ? 8 : 0);
        }
        AppMethodBeat.o(25007);
    }

    public final boolean a(d dVar, boolean z) {
        AppMethodBeat.i(25008);
        if (dVar == this.qzz) {
            if (z && this.qzA != null) {
                this.qzA.clv();
            }
            AppMethodBeat.o(25008);
            return false;
        }
        this.qzz = dVar;
        this.qzv.clw();
        notifyDataSetChanged();
        if (z && this.qzA != null) {
            this.qzA.clv();
        }
        AppMethodBeat.o(25008);
        return true;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(25009);
        this.qzy.clear();
        super.a(str, mVar);
        AppMethodBeat.o(25009);
    }

    public final void KC() {
        AppMethodBeat.i(25010);
        KD();
        super.notifyDataSetChanged();
        AppMethodBeat.o(25010);
    }

    public final void KD() {
        AppMethodBeat.i(25011);
        setCursor(o.alp().alg());
        AppMethodBeat.o(25011);
    }

    public final int getCount() {
        AppMethodBeat.i(25012);
        int count = (super.getCount() / 3) + 1;
        AppMethodBeat.o(25012);
        return count;
    }
}
