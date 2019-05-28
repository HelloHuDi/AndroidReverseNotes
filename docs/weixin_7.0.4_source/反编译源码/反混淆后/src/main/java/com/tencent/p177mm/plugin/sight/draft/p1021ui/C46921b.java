package com.tencent.p177mm.plugin.sight.draft.p1021ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C1883k;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9716j;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.tools.C5587h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sight.draft.ui.b */
public final class C46921b extends C46692p<C9716j> {
    private int itemHeight;
    private int itemWidth;
    C39714a qzA;
    int qzB = C25738R.string.ei4;
    int qzC = 0;
    private int qzD;
    private int qzE;
    private C34921c qzF = new C133341();
    C21851e qzG;
    C39715a qzv = new C39715a(this, (byte) 0);
    private C21850b qzw = new C21850b(this, (byte) 0);
    private C29019c qzx = new C29019c(this, (byte) 0);
    private Set<C21851e> qzy = new HashSet();
    private C29020d qzz = C29020d.NORMAL;

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$1 */
    class C133341 extends C34921c {
        C133341() {
        }

        /* renamed from: r */
        public final void mo25419r(String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(24996);
            for (C21851e c21851e : C46921b.this.qzy) {
                if (c21851e.qzO != null && C5046bo.m7532bc(str, "").equals(c21851e.qzO.field_fileName)) {
                    c21851e.qzM.setThumbBmp(bitmap);
                    break;
                }
            }
            AppMethodBeat.m2505o(24996);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$b */
    class C21850b implements OnLongClickListener {
        private C21850b() {
        }

        /* synthetic */ C21850b(C46921b c46921b, byte b) {
            this();
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(24999);
            if (view.getTag() instanceof C21851e) {
                C21851e c21851e = (C21851e) view.getTag();
                if (c21851e.qzO == null) {
                    AppMethodBeat.m2505o(24999);
                } else if (-1 == c21851e.qzO.field_fileStatus) {
                    AppMethodBeat.m2505o(24999);
                } else {
                    C46921b.this.mo76132a(C29020d.EDIT, true);
                    AppMethodBeat.m2505o(24999);
                }
            } else {
                AppMethodBeat.m2505o(24999);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$e */
    static final class C21851e {
        View gbS;
        TextView iqU;
        ImageView moR;
        ImageView qpr;
        View qzL;
        C34915a qzM;
        View qzN;
        C9716j qzO;

        private C21851e() {
        }

        /* synthetic */ C21851e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$c */
    class C29019c implements OnClickListener {
        private C29019c() {
        }

        /* synthetic */ C29019c(C46921b c46921b, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25000);
            if (view.getTag() instanceof C21851e) {
                C46921b.this.qzv.clw();
                C21851e c21851e = (C21851e) view.getTag();
                if (c21851e.qzO == null) {
                    C4990ab.m7412e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
                    AppMethodBeat.m2505o(25000);
                    return;
                }
                c21851e.qzO.field_fileStatus = 6;
                C37961o.alp().mo10103c(c21851e.qzO, "localId");
                C46921b.this.mo5248a(null, null);
                if (C46921b.this.qzA != null) {
                    C46921b.this.qzA;
                }
                AppMethodBeat.m2505o(25000);
                return;
            }
            AppMethodBeat.m2505o(25000);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$d */
    public enum C29020d {
        NORMAL,
        EDIT;

        static {
            AppMethodBeat.m2505o(25003);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$a */
    class C39715a implements OnClickListener {
        private C39715a() {
        }

        /* synthetic */ C39715a(C46921b c46921b, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24997);
            if (view.getTag() instanceof C21851e) {
                C21851e c21851e = (C21851e) view.getTag();
                if (c21851e.qzO == null) {
                    C4990ab.m7417i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", C46921b.this.qzz);
                    clw();
                    C46921b.this.qzG = null;
                    AppMethodBeat.m2505o(24997);
                    return;
                }
                if (C46921b.this.qzG != c21851e) {
                    clw();
                    String tX = C1883k.m3987tX(c21851e.qzO.field_fileName);
                    c21851e.qzM.setCanPlay(true);
                    c21851e.qzM.mo8509bf(tX, false);
                    c21851e.moR.setBackgroundResource(C25738R.drawable.bht);
                    View view2 = c21851e.qzL;
                    if (!(view2 == null || C1443d.m3067fP(11))) {
                        Animator animator = (Animator) view2.getTag(2131820652);
                        if (animator != null) {
                            animator.cancel();
                        }
                        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view2.getContext(), C25738R.animator.f8460d);
                        animatorSet.setTarget(view2);
                        animatorSet.start();
                        view2.setTag(2131820652, animatorSet);
                    }
                    C46921b.m89455b(C46921b.this, c21851e);
                    C46921b.this.qzG = c21851e;
                }
                if (C46921b.this.qzA != null) {
                    C46921b.this.qzA.clu();
                }
                AppMethodBeat.m2505o(24997);
                return;
            }
            AppMethodBeat.m2505o(24997);
        }

        public final boolean clw() {
            AppMethodBeat.m2504i(24998);
            if (C46921b.this.qzG != null) {
                C46921b.this.qzG.iqU.setVisibility(8);
                C46921b.this.qzG.qzM.setCanPlay(false);
                C46921b.this.qzG.qzM.mo8509bf(null, false);
                C46921b.this.qzG.qzM.setThumbBmp(C46921b.this.qzF.mo55516x(C46921b.this.qzG.qzO.field_fileName, C1883k.m3988tY(C46921b.this.qzG.qzO.field_fileName), true));
                C46921b.this.qzG.moR.setBackgroundResource(C25738R.drawable.bhs);
                C5587h.m8389r(C46921b.this.qzG.qzL, 1.0f);
                C46921b.this.qzG = null;
                AppMethodBeat.m2505o(24998);
                return true;
            }
            AppMethodBeat.m2505o(24998);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.b$f */
    static final class C43531f {
        List<C21851e> qzP;

        private C43531f() {
            AppMethodBeat.m2504i(25004);
            this.qzP = new LinkedList();
            AppMethodBeat.m2505o(25004);
        }

        /* synthetic */ C43531f(byte b) {
            this();
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m89455b(C46921b c46921b, C21851e c21851e) {
        AppMethodBeat.m2504i(25014);
        c46921b.mo76131a(c21851e);
        AppMethodBeat.m2505o(25014);
    }

    public C46921b(Context context, C39714a c39714a) {
        super(context, null);
        AppMethodBeat.m2504i(25005);
        this.qzA = c39714a;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.a8j) * 2;
        this.qzD = context.getResources().getDisplayMetrics().widthPixels / 3;
        this.itemWidth = this.qzD - dimensionPixelSize;
        this.itemHeight = (this.itemWidth * 3) / 4;
        this.qzE = dimensionPixelSize + this.itemHeight;
        AppMethodBeat.m2505o(25005);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C43531f c43531f;
        AppMethodBeat.m2504i(25006);
        if (view == null) {
            C43531f c43531f2 = new C43531f();
            view = new LinearLayout(viewGroup.getContext());
            view.setOrientation(0);
            for (int i2 = 0; i2 < 3; i2++) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130970686, view, false);
                C21851e c21851e = new C21851e();
                c21851e.gbS = inflate;
                c21851e.gbS.setTag(c21851e);
                c21851e.qzL = inflate.findViewById(2131827565);
                c21851e.qzM = (C34915a) inflate.findViewById(2131827566);
                c21851e.moR = (ImageView) inflate.findViewById(2131827567);
                c21851e.qzN = inflate.findViewById(2131827569);
                c21851e.iqU = (TextView) inflate.findViewById(2131827568);
                c21851e.iqU.setText(this.qzB);
                c21851e.qpr = (ImageView) inflate.findViewById(2131827570);
                c43531f2.qzP.add(c21851e);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.height = this.qzE;
                view.addView(inflate);
                inflate.setOnClickListener(this.qzv);
                c21851e.qpr.setTag(c21851e);
                c21851e.qpr.setOnClickListener(this.qzx);
            }
            view.setTag(c43531f2);
            c43531f = c43531f2;
        } else {
            c43531f = (C43531f) view.getTag();
        }
        for (int i3 = 0; i3 < c43531f.qzP.size(); i3++) {
            int i4 = (i * 3) + i3;
            C21851e c21851e2 = (C21851e) c43531f.qzP.get(i3);
            this.qzy.add(c21851e2);
            c21851e2.qzN.setVisibility(8);
            c21851e2.iqU.setVisibility(8);
            c21851e2.moR.setBackgroundResource(C25738R.drawable.bhs);
            c21851e2.qzM.mo8509bf(null, false);
            c21851e2.qzM.setCanPlay(false);
            c21851e2.qzM.setForceRecordState(false);
            ((ImageView) c21851e2.qzM).setBackgroundResource(0);
            if (i4 >= getRealCount()) {
                c21851e2.qzO = null;
                c21851e2.gbS.setVisibility(4);
                C5587h.m8389r(c21851e2.qzL, 1.0f);
            } else {
                this.qzC--;
                C9716j c9716j = (C9716j) getItem(i4);
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    boolean z;
                    c21851e2.qzO = c9716j;
                    C34921c c34921c = this.qzF;
                    String str = c9716j.field_fileName;
                    String tY = C1883k.m3988tY(c9716j.field_fileName);
                    if (this.qzC <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Bitmap x = c34921c.mo55516x(str, tY, z);
                    ((ImageView) c21851e2.qzM).setScaleType(ScaleType.CENTER_CROP);
                    c21851e2.qzM.setThumbBmp(x);
                } else {
                    c21851e2.qzO = null;
                    c21851e2.qzM.ckX();
                }
                if (C29020d.EDIT == this.qzz) {
                    c21851e2.qpr.setVisibility(0);
                    C5587h.m8389r(c21851e2.qzL, 0.95f);
                } else {
                    c21851e2.qpr.setVisibility(8);
                    C5587h.m8389r(c21851e2.qzL, 1.0f);
                }
                c21851e2.gbS.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(25006);
        return view;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo76131a(C21851e c21851e) {
        AppMethodBeat.m2504i(25007);
        if (c21851e == null) {
            for (C21851e c21851e2 : this.qzy) {
                c21851e2.qzN.setVisibility(8);
            }
            AppMethodBeat.m2505o(25007);
            return;
        }
        for (C21851e c21851e22 : this.qzy) {
            c21851e22.qzN.setVisibility(c21851e == c21851e22 ? 8 : 0);
        }
        AppMethodBeat.m2505o(25007);
    }

    /* renamed from: a */
    public final boolean mo76132a(C29020d c29020d, boolean z) {
        AppMethodBeat.m2504i(25008);
        if (c29020d == this.qzz) {
            if (z && this.qzA != null) {
                this.qzA.clv();
            }
            AppMethodBeat.m2505o(25008);
            return false;
        }
        this.qzz = c29020d;
        this.qzv.clw();
        notifyDataSetChanged();
        if (z && this.qzA != null) {
            this.qzA.clv();
        }
        AppMethodBeat.m2505o(25008);
        return true;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(25009);
        this.qzy.clear();
        super.mo5248a(str, c4935m);
        AppMethodBeat.m2505o(25009);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(25010);
        mo6870KD();
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(25010);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(25011);
        setCursor(C37961o.alp().alg());
        AppMethodBeat.m2505o(25011);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(25012);
        int count = (super.getCount() / 3) + 1;
        AppMethodBeat.m2505o(25012);
        return count;
    }
}
