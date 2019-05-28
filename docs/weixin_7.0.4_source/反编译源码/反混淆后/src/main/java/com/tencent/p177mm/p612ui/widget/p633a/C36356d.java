package com.tencent.p177mm.p612ui.widget.p633a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.C24632a;
import android.support.design.widget.C17391c;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C40670b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.plugin.webview.luggage.C40246n.C298082;
import com.tencent.p177mm.plugin.webview.luggage.C40246n.C45501;

/* renamed from: com.tencent.mm.ui.widget.a.d */
public class C36356d implements OnGlobalLayoutListener {
    private ViewTreeObserver aaM;
    private RecyclerView aiB;
    public View iym;
    public Context mContext;
    /* renamed from: nA */
    private BottomSheetBehavior f15094nA;
    public boolean pIf;
    /* renamed from: pP */
    private View f15095pP;
    public C36073c rBl = new C45501();
    public C5279d rBm = new C298082();
    private C44273l rBn;
    private boolean uEM;
    private boolean uEN;
    public boolean uEO;
    public boolean uEP;
    public C36072a zFT;
    public C40670b zFU;
    public int zQA;
    private boolean zQB;
    private int zQC;
    private int zQD;
    public C15994a zQf;
    private Dialog zQg;
    private C5279d zQh;
    private C44273l zQi;
    public Boolean zQj;
    private LinearLayout zQk;
    private LinearLayout zQl;
    private C15995b zQm;
    private boolean zQn;
    private boolean zQo;
    private boolean zQp;
    private int zQq;
    public ImageView zQr;
    private int zQs;
    private int zQt;
    private int zQu;
    private int zQv;
    private boolean zQw;
    private boolean zQx;
    public boolean zQy;
    private boolean zQz;
    private int zaX;

    /* renamed from: com.tencent.mm.ui.widget.a.d$a */
    public interface C15994a {
        void onDismiss();
    }

    /* renamed from: com.tencent.mm.ui.widget.a.d$b */
    public class C15995b extends C41523a<C5654a> {
        OnItemClickListener amz;

        /* renamed from: com.tencent.mm.ui.widget.a.d$b$a */
        public class C5654a extends C41531v implements OnClickListener {
            TextView gsf;
            ImageView iNr;
            TextView qZb;
            RadioButton zQF;
            ImageView zQG;
            LinearLayout zQH;

            public C5654a(View view) {
                super(view);
                AppMethodBeat.m2504i(112651);
                view.setOnClickListener(this);
                this.gsf = (TextView) view.findViewById(2131820678);
                this.iNr = (ImageView) view.findViewById(2131820915);
                this.zQH = (LinearLayout) view.findViewById(2131820987);
                if (C36356d.this.zQo || C36356d.this.zQp) {
                    this.qZb = (TextView) view.findViewById(2131821095);
                    this.zQF = (RadioButton) view.findViewById(2131820934);
                    this.zQG = (ImageView) view.findViewById(2131821128);
                }
                AppMethodBeat.m2505o(112651);
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(112652);
                if (C15995b.this.amz != null) {
                    C15995b.this.amz.onItemClick(null, view, getPosition(), (long) getPosition());
                }
                AppMethodBeat.m2505o(112652);
            }
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(112653);
            int size;
            if (C36356d.this.zQn) {
                size = (C36356d.this.rBn.size() + C36356d.this.zQi.size()) + 1;
                AppMethodBeat.m2505o(112653);
                return size;
            }
            size = C36356d.this.rBn.size() + C36356d.this.zQi.size();
            AppMethodBeat.m2505o(112653);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.a.d$1 */
    class C307991 implements OnItemClickListener {
        C307991() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(112647);
            C44274m c44274m = (C44274m) C36356d.this.rBn.yvT.get(i);
            if (c44274m == null || !c44274m.xeS) {
                if (i < C36356d.this.rBn.size()) {
                    if (C36356d.this.rBm != null) {
                        C36356d.this.rBm.onMMMenuItemSelected(C36356d.this.rBn.getItem(i), i);
                    }
                } else if (C36356d.this.zQi.size() <= 0 || i >= C36356d.this.rBn.size() + C36356d.this.zQi.size()) {
                    C36356d.dKZ();
                } else if (C36356d.this.zQh != null) {
                    C36356d.this.zQh.onMMMenuItemSelected(C36356d.this.zQi.getItem(i - C36356d.this.rBn.size()), i);
                }
                if (!C36356d.this.pIf) {
                    C36356d.this.cpE();
                }
                C36356d.this.zQx = true;
                C36356d.this.zQA = i;
                C36356d.this.zQm.aop.notifyChanged();
                AppMethodBeat.m2505o(112647);
                return;
            }
            AppMethodBeat.m2505o(112647);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.a.d$4 */
    class C363574 implements OnDismissListener {
        C363574() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112650);
            if (!C36356d.this.zQx) {
                C36356d.this.zQf.onDismiss();
            }
            AppMethodBeat.m2505o(112650);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.a.d$2 */
    class C363582 extends C24632a {
        C363582() {
        }

        /* renamed from: O */
        public final void mo31604O(int i) {
        }

        /* renamed from: h */
        public final void mo31605h(float f) {
            AppMethodBeat.m2504i(112648);
            if (!(C36356d.this.zQr == null || C36356d.this.zQz)) {
                if (C36356d.this.aiB.canScrollVertically(-1) && C36356d.this.zQw && f != 0.0f) {
                    C36356d.this.zQr.setVisibility(0);
                    AppMethodBeat.m2505o(112648);
                    return;
                }
                C36356d.this.zQr.setVisibility(4);
            }
            AppMethodBeat.m2505o(112648);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.a.d$3 */
    class C363593 implements OnDismissListener {
        C363593() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112649);
            if (C36356d.this.aaM != null) {
                if (!C36356d.this.aaM.isAlive()) {
                    C36356d.this.aaM = C36356d.this.f15095pP.getViewTreeObserver();
                }
                C36356d.this.aaM.removeGlobalOnLayoutListener(C36356d.this);
                C36356d.this.aaM = null;
            }
            C36356d.this.zQg = null;
            AppMethodBeat.m2505o(112649);
        }
    }

    static /* synthetic */ void dKZ() {
    }

    public C36356d(Context context, int i, boolean z) {
        AppMethodBeat.m2504i(112656);
        this.zQj = Boolean.FALSE;
        this.zQn = false;
        this.zQo = false;
        this.zQp = false;
        this.uEM = false;
        this.zQs = 4;
        this.zQt = this.zQs * 3;
        this.zQu = 6;
        this.pIf = false;
        this.zQx = false;
        this.uEP = false;
        this.zQy = false;
        this.zQz = false;
        this.zQA = 0;
        this.zQB = false;
        this.zQC = 0;
        this.zQD = 0;
        this.zQv = i;
        this.mContext = context;
        this.zQw = z;
        this.zQz = false;
        if (this.mContext instanceof Activity) {
            this.f15095pP = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        m59886cA(this.mContext);
        AppMethodBeat.m2505o(112656);
    }

    public C36356d(Context context) {
        AppMethodBeat.m2504i(112657);
        this.zQj = Boolean.FALSE;
        this.zQn = false;
        this.zQo = false;
        this.zQp = false;
        this.uEM = false;
        this.zQs = 4;
        this.zQt = this.zQs * 3;
        this.zQu = 6;
        this.pIf = false;
        this.zQx = false;
        this.uEP = false;
        this.zQy = false;
        this.zQz = false;
        this.zQA = 0;
        this.zQB = false;
        this.zQC = 0;
        this.zQD = 0;
        this.zQv = 1;
        this.mContext = context;
        this.zQB = true;
        if (this.mContext instanceof Activity) {
            this.f15095pP = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        m59886cA(this.mContext);
        AppMethodBeat.m2505o(112657);
    }

    public void onGlobalLayout() {
        AppMethodBeat.m2504i(112658);
        if (isShowing()) {
            View view = this.f15095pP;
            if (view == null || !view.isShown()) {
                cpE();
                AppMethodBeat.m2505o(112658);
                return;
            } else if (isShowing() && !(this.uEM == isLandscape() && this.zQq == getRotation())) {
                cpE();
            }
        }
        AppMethodBeat.m2505o(112658);
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.m2504i(112659);
        int i = 0;
        if (this.mContext instanceof Activity) {
            i = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.m2505o(112659);
        return i;
    }

    /* renamed from: cA */
    private void m59886cA(Context context) {
        int am;
        AppMethodBeat.m2504i(112660);
        this.rBn = new C44273l(context);
        this.zQi = new C44273l(context);
        if (this.zQB) {
            this.zQg = new C44397b(context);
        } else {
            this.zQg = new C17391c(context);
        }
        this.iym = View.inflate(context, 2130970097, null);
        this.zQk = (LinearLayout) this.iym.findViewById(2131825987);
        this.zQl = (LinearLayout) this.iym.findViewById(2131825990);
        this.zQr = (ImageView) this.iym.findViewById(2131825988);
        this.aiB = (RecyclerView) this.iym.findViewById(2131825989);
        this.aiB.setHasFixedSize(true);
        this.uEM = isLandscape();
        if (this.zQv == 0) {
            if (this.uEM) {
                this.zQs = 7;
                this.zQt = this.zQs * 2;
                this.zaX = C5229aj.m7981am(this.mContext, C25738R.dimen.f9735e1) + C5229aj.m7981am(this.mContext, C25738R.dimen.a2v);
            } else {
                this.zaX = C5229aj.m7981am(this.mContext, C25738R.dimen.f9734e0) + C5229aj.m7981am(this.mContext, C25738R.dimen.a2v);
            }
            if (this.zQw) {
                this.zaX += C5229aj.m7981am(this.mContext, C25738R.dimen.a2v);
            }
        } else if (this.zQv == 2) {
            this.zQo = true;
            am = C5229aj.m7981am(this.mContext, C25738R.dimen.f10219uu);
            if (this.uEM) {
                this.zQu = 2;
                this.zaX = ((int) (((double) am) * 2.5d)) + C5229aj.m7981am(this.mContext, C25738R.dimen.f10215uq);
            } else {
                this.zQu = 3;
                this.zaX = ((int) (((double) am) * 3.5d)) + C5229aj.m7981am(this.mContext, C25738R.dimen.f10215uq);
            }
            if (this.zQw) {
                this.zaX += C5229aj.fromDPToPix(this.mContext, 88);
            }
        } else {
            this.zQp = true;
            am = C5229aj.m7981am(this.mContext, C25738R.dimen.f10222ux);
            if (this.uEM) {
                this.zQu = 4;
                this.zaX = ((int) (((double) am) * 4.5d)) + C5229aj.m7981am(this.mContext, C25738R.dimen.f10215uq);
            } else {
                this.zQu = 6;
                this.zaX = ((int) (((double) am) * 6.5d)) + C5229aj.m7981am(this.mContext, C25738R.dimen.f10215uq);
            }
            if (this.zQw) {
                this.zaX += C5229aj.m7981am(this.mContext, C25738R.dimen.a2v);
            }
            if (this.zQB) {
                am = C5229aj.fromDPToPix(this.mContext, 24);
                this.zQr.setPadding(am, 0, am, 0);
            }
        }
        if (this.zQw && this.zQr != null && this.zQz) {
            this.zQr.setVisibility(0);
        }
        if (this.zQv == 0) {
            this.aiB.setLayoutManager(new GridLayoutManager(this.zQs));
            int am2 = C5229aj.m7981am(this.mContext, C25738R.dimen.a2u);
            am = C5229aj.m7981am(this.mContext, C25738R.dimen.a2v);
            if (this.zQw) {
                am = C5229aj.fromDPToPix(this.mContext, 0);
            }
            this.aiB.setPadding(am2, am, am2, 0);
        } else {
            this.aiB.setLayoutManager(new LinearLayoutManager());
        }
        this.zQm = new C15995b();
        this.zQm.amz = new C307991();
        this.aiB.setAdapter(this.zQm);
        this.aiB.setOverScrollMode(1);
        this.zQg.setContentView(this.iym);
        if (!this.zQB) {
            this.f15094nA = BottomSheetBehavior.m38322j((View) this.iym.getParent());
            this.f15094nA.mo41462K(this.zaX);
            this.f15094nA.f4922ns = new C363582();
        }
        this.zQg.setOnDismissListener(new C363593());
        AppMethodBeat.m2505o(112660);
    }

    /* renamed from: F */
    public final void mo57234F(View view, boolean z) {
        AppMethodBeat.m2504i(112661);
        if (view == null) {
            AppMethodBeat.m2505o(112661);
            return;
        }
        this.zQw = true;
        if (this.zQr != null) {
            this.zQr.setVisibility(z ? 4 : 0);
        }
        if (this.zQk != null) {
            this.zQk.setVisibility(0);
            this.zQk.removeAllViews();
            this.zQk.setGravity(17);
            this.zQk.addView(view, -1, -2);
        }
        AppMethodBeat.m2505o(112661);
    }

    /* renamed from: q */
    public final void mo57242q(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(112662);
        if (this.zQk != null && this.zQw) {
            this.zQk.setVisibility(0);
            this.zQk.removeAllViews();
            this.zQk.setGravity(i);
            View inflate = LayoutInflater.from(this.mContext).inflate(2130970101, null);
            TextView textView = (TextView) inflate.findViewById(2131822938);
            textView.setText(charSequence);
            textView.setGravity(i | 80);
            this.zQk.addView(inflate, -1, -2);
        }
        AppMethodBeat.m2505o(112662);
    }

    @TargetApi(23)
    private void dcd() {
        AppMethodBeat.m2504i(112663);
        if (VERSION.SDK_INT >= 23 && this.zQg != null) {
            this.zQg.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.zQg.getWindow().setStatusBarColor(0);
        }
        AppMethodBeat.m2505o(112663);
    }

    public final void cpD() {
        boolean z = false;
        AppMethodBeat.m2504i(112664);
        this.uEM = isLandscape();
        this.zQq = getRotation();
        if (this.rBl != null) {
            this.rBl.mo5746a(this.rBn);
        }
        if (this.zQg != null) {
            dKY();
            if (!(this.zQi == null || this.zQm == null)) {
                this.zQm.aop.notifyChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.zQg.getWindow().addFlags(C8415j.INVALID_ID);
            }
            if (this.uEN) {
                dcd();
            }
            if (this.uEO) {
                this.zQg.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.uEP) {
                this.zQg.getWindow().setFlags(8, 8);
                this.zQg.getWindow().addFlags(131200);
                this.zQg.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.zQg.getWindow().clearFlags(8);
                this.zQg.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.zQg.getWindow().clearFlags(128);
                this.zQg.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.f15094nA != null) {
                this.f15094nA.f4913nj = false;
            }
            if (this.zQf != null) {
                this.zQg.setOnDismissListener(new C363574());
            }
            if (this.f15095pP != null) {
                if (this.aaM == null) {
                    z = true;
                }
                this.aaM = this.f15095pP.getViewTreeObserver();
                if (z) {
                    this.aaM.addOnGlobalLayoutListener(this);
                }
            }
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
                this.zQg.show();
            }
        }
        AppMethodBeat.m2505o(112664);
    }

    public final void dKX() {
        AppMethodBeat.m2504i(112665);
        if (this.zQg != null) {
            if (!(this.zQi == null || this.zQm == null)) {
                this.zQm.aop.notifyChanged();
            }
            this.zQg.show();
        }
        AppMethodBeat.m2505o(112665);
    }

    public final void cpE() {
        AppMethodBeat.m2504i(112666);
        if (this.zQg != null) {
            if (this.f15094nA != null) {
                this.f15094nA.f4913nj = true;
            }
            this.zQg.dismiss();
        }
        AppMethodBeat.m2505o(112666);
    }

    public final boolean isShowing() {
        AppMethodBeat.m2504i(112667);
        if (this.zQg == null || !this.zQg.isShowing()) {
            AppMethodBeat.m2505o(112667);
            return false;
        }
        AppMethodBeat.m2505o(112667);
        return true;
    }

    private void dKY() {
        int am;
        AppMethodBeat.m2504i(112668);
        LayoutParams layoutParams = (LayoutParams) this.iym.getLayoutParams();
        int size = this.rBn.size();
        if (this.zQn) {
            size++;
        } else if (this.zQi.size() > 0) {
            size += this.zQi.size();
        }
        if (this.zQB) {
            int am2 = C5229aj.m7981am(this.mContext, C25738R.dimen.f10222ux);
            if (this.zQw) {
                am = C5229aj.m7981am(this.mContext, C25738R.dimen.f10225v0);
                if (this.zQC != 0) {
                    am = this.zQC;
                }
                this.zaX = (am + ((int) (((double) am2) * 4.5d))) + C5229aj.m7981am(this.mContext, C25738R.dimen.f10215uq);
            } else {
                this.zaX = (int) (((double) am2) * 6.5d);
            }
        }
        if (this.zQv == 0) {
            if (this.zQm.getItemCount() > this.zQt) {
                layoutParams.height = this.zaX;
            } else {
                layoutParams.height = ((C5229aj.m7981am(this.mContext, C25738R.dimen.f10217us) + C5229aj.m7981am(this.mContext, C25738R.dimen.a2v)) * ((int) Math.ceil((double) (((float) this.zQm.getItemCount()) / ((float) this.zQs))))) + C5230ak.m7988fr(this.mContext);
                if (this.zQw) {
                    layoutParams.height += C5229aj.m7981am(this.mContext, C25738R.dimen.a2v);
                }
            }
        } else if (size > this.zQu) {
            layoutParams.height = this.zaX;
        }
        if (this.uEM && this.f15095pP != null) {
            Rect rect = new Rect();
            this.f15095pP.getWindowVisibleDisplayFrame(rect);
            if (this.zQB) {
                layoutParams.width = (int) ((((float) rect.right) * 1.0f) / 2.0f);
                if (this.zQD != 0) {
                    layoutParams.width = this.zQD;
                }
                if (C5230ak.m7990hG(this.mContext)) {
                    layoutParams.height = rect.bottom - C5230ak.m7989hF(this.mContext);
                } else {
                    layoutParams.height = rect.bottom;
                }
                if (this.zQw) {
                    am = C5229aj.m7981am(this.mContext, C25738R.dimen.f10222ux);
                    if (size <= this.zQu) {
                        size = layoutParams.height - (size * am);
                    } else {
                        size = layoutParams.height - ((int) (((double) ((float) am)) * (((double) this.zQu) + 0.5d)));
                        if (size > C5229aj.fromDPToPix(this.mContext, 150)) {
                            size -= am;
                        }
                    }
                    if (this.zQk != null) {
                        this.zQk.setMinimumHeight(size);
                    }
                }
            } else {
                layoutParams.width = rect.right;
            }
        }
        this.iym.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(112668);
    }

    /* renamed from: a */
    public final void mo57235a(C36073c c36073c) {
        this.rBl = c36073c;
    }

    /* renamed from: a */
    public final void mo57236a(C5279d c5279d) {
        this.rBm = c5279d;
    }

    private boolean isLandscape() {
        AppMethodBeat.m2504i(112669);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.m2505o(112669);
            return true;
        }
        AppMethodBeat.m2505o(112669);
        return false;
    }
}
