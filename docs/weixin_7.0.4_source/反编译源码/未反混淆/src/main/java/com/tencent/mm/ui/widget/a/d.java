package com.tencent.mm.ui.widget.a;

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
import android.support.v4.widget.j;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;

public class d implements OnGlobalLayoutListener {
    private ViewTreeObserver aaM;
    private RecyclerView aiB;
    public View iym;
    public Context mContext;
    private BottomSheetBehavior nA;
    public boolean pIf;
    private View pP;
    public c rBl = new c() {
        public final void a(l lVar) {
            AppMethodBeat.i(6219);
            n nVar = n.this;
            nVar.ujb.b(nVar.uiI.mContext, nVar.uiI, lVar);
            AppMethodBeat.o(6219);
        }
    };
    public com.tencent.mm.ui.base.n.d rBm = new com.tencent.mm.ui.base.n.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(6220);
            n nVar = n.this;
            nVar.ujb.a(nVar.uiI.mContext, nVar.uiI, menuItem);
            n.this.ujs.cpE();
            AppMethodBeat.o(6220);
        }
    };
    private l rBn;
    private boolean uEM;
    private boolean uEN;
    public boolean uEO;
    public boolean uEP;
    public com.tencent.mm.ui.base.n.a zFT;
    public com.tencent.mm.ui.base.n.b zFU;
    public int zQA;
    private boolean zQB;
    private int zQC;
    private int zQD;
    public a zQf;
    private Dialog zQg;
    private com.tencent.mm.ui.base.n.d zQh;
    private l zQi;
    public Boolean zQj;
    private LinearLayout zQk;
    private LinearLayout zQl;
    private b zQm;
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

    public interface a {
        void onDismiss();
    }

    public class b extends android.support.v7.widget.RecyclerView.a<a> {
        OnItemClickListener amz;

        public class a extends v implements OnClickListener {
            TextView gsf;
            ImageView iNr;
            TextView qZb;
            RadioButton zQF;
            ImageView zQG;
            LinearLayout zQH;

            public a(View view) {
                super(view);
                AppMethodBeat.i(112651);
                view.setOnClickListener(this);
                this.gsf = (TextView) view.findViewById(R.id.cx);
                this.iNr = (ImageView) view.findViewById(R.id.jb);
                this.zQH = (LinearLayout) view.findViewById(R.id.l_);
                if (d.this.zQo || d.this.zQp) {
                    this.qZb = (TextView) view.findViewById(R.id.o7);
                    this.zQF = (RadioButton) view.findViewById(R.id.ju);
                    this.zQG = (ImageView) view.findViewById(R.id.p3);
                }
                AppMethodBeat.o(112651);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112652);
                if (b.this.amz != null) {
                    b.this.amz.onItemClick(null, view, getPosition(), (long) getPosition());
                }
                AppMethodBeat.o(112652);
            }
        }

        public final int getItemCount() {
            AppMethodBeat.i(112653);
            int size;
            if (d.this.zQn) {
                size = (d.this.rBn.size() + d.this.zQi.size()) + 1;
                AppMethodBeat.o(112653);
                return size;
            }
            size = d.this.rBn.size() + d.this.zQi.size();
            AppMethodBeat.o(112653);
            return size;
        }
    }

    static /* synthetic */ void dKZ() {
    }

    public d(Context context, int i, boolean z) {
        AppMethodBeat.i(112656);
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
            this.pP = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        cA(this.mContext);
        AppMethodBeat.o(112656);
    }

    public d(Context context) {
        AppMethodBeat.i(112657);
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
            this.pP = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
        }
        cA(this.mContext);
        AppMethodBeat.o(112657);
    }

    public void onGlobalLayout() {
        AppMethodBeat.i(112658);
        if (isShowing()) {
            View view = this.pP;
            if (view == null || !view.isShown()) {
                cpE();
                AppMethodBeat.o(112658);
                return;
            } else if (isShowing() && !(this.uEM == isLandscape() && this.zQq == getRotation())) {
                cpE();
            }
        }
        AppMethodBeat.o(112658);
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.i(112659);
        int i = 0;
        if (this.mContext instanceof Activity) {
            i = ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(112659);
        return i;
    }

    private void cA(Context context) {
        int am;
        AppMethodBeat.i(112660);
        this.rBn = new l(context);
        this.zQi = new l(context);
        if (this.zQB) {
            this.zQg = new b(context);
        } else {
            this.zQg = new android.support.design.widget.c(context);
        }
        this.iym = View.inflate(context, R.layout.ada, null);
        this.zQk = (LinearLayout) this.iym.findViewById(R.id.d95);
        this.zQl = (LinearLayout) this.iym.findViewById(R.id.d98);
        this.zQr = (ImageView) this.iym.findViewById(R.id.d96);
        this.aiB = (RecyclerView) this.iym.findViewById(R.id.d97);
        this.aiB.setHasFixedSize(true);
        this.uEM = isLandscape();
        if (this.zQv == 0) {
            if (this.uEM) {
                this.zQs = 7;
                this.zQt = this.zQs * 2;
                this.zaX = aj.am(this.mContext, R.dimen.e1) + aj.am(this.mContext, R.dimen.a2v);
            } else {
                this.zaX = aj.am(this.mContext, R.dimen.e0) + aj.am(this.mContext, R.dimen.a2v);
            }
            if (this.zQw) {
                this.zaX += aj.am(this.mContext, R.dimen.a2v);
            }
        } else if (this.zQv == 2) {
            this.zQo = true;
            am = aj.am(this.mContext, R.dimen.uu);
            if (this.uEM) {
                this.zQu = 2;
                this.zaX = ((int) (((double) am) * 2.5d)) + aj.am(this.mContext, R.dimen.uq);
            } else {
                this.zQu = 3;
                this.zaX = ((int) (((double) am) * 3.5d)) + aj.am(this.mContext, R.dimen.uq);
            }
            if (this.zQw) {
                this.zaX += aj.fromDPToPix(this.mContext, 88);
            }
        } else {
            this.zQp = true;
            am = aj.am(this.mContext, R.dimen.ux);
            if (this.uEM) {
                this.zQu = 4;
                this.zaX = ((int) (((double) am) * 4.5d)) + aj.am(this.mContext, R.dimen.uq);
            } else {
                this.zQu = 6;
                this.zaX = ((int) (((double) am) * 6.5d)) + aj.am(this.mContext, R.dimen.uq);
            }
            if (this.zQw) {
                this.zaX += aj.am(this.mContext, R.dimen.a2v);
            }
            if (this.zQB) {
                am = aj.fromDPToPix(this.mContext, 24);
                this.zQr.setPadding(am, 0, am, 0);
            }
        }
        if (this.zQw && this.zQr != null && this.zQz) {
            this.zQr.setVisibility(0);
        }
        if (this.zQv == 0) {
            this.aiB.setLayoutManager(new GridLayoutManager(this.zQs));
            int am2 = aj.am(this.mContext, R.dimen.a2u);
            am = aj.am(this.mContext, R.dimen.a2v);
            if (this.zQw) {
                am = aj.fromDPToPix(this.mContext, 0);
            }
            this.aiB.setPadding(am2, am, am2, 0);
        } else {
            this.aiB.setLayoutManager(new LinearLayoutManager());
        }
        this.zQm = new b();
        this.zQm.amz = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(112647);
                m mVar = (m) d.this.rBn.yvT.get(i);
                if (mVar == null || !mVar.xeS) {
                    if (i < d.this.rBn.size()) {
                        if (d.this.rBm != null) {
                            d.this.rBm.onMMMenuItemSelected(d.this.rBn.getItem(i), i);
                        }
                    } else if (d.this.zQi.size() <= 0 || i >= d.this.rBn.size() + d.this.zQi.size()) {
                        d.dKZ();
                    } else if (d.this.zQh != null) {
                        d.this.zQh.onMMMenuItemSelected(d.this.zQi.getItem(i - d.this.rBn.size()), i);
                    }
                    if (!d.this.pIf) {
                        d.this.cpE();
                    }
                    d.this.zQx = true;
                    d.this.zQA = i;
                    d.this.zQm.aop.notifyChanged();
                    AppMethodBeat.o(112647);
                    return;
                }
                AppMethodBeat.o(112647);
            }
        };
        this.aiB.setAdapter(this.zQm);
        this.aiB.setOverScrollMode(1);
        this.zQg.setContentView(this.iym);
        if (!this.zQB) {
            this.nA = BottomSheetBehavior.j((View) this.iym.getParent());
            this.nA.K(this.zaX);
            this.nA.ns = new android.support.design.widget.BottomSheetBehavior.a() {
                public final void O(int i) {
                }

                public final void h(float f) {
                    AppMethodBeat.i(112648);
                    if (!(d.this.zQr == null || d.this.zQz)) {
                        if (d.this.aiB.canScrollVertically(-1) && d.this.zQw && f != 0.0f) {
                            d.this.zQr.setVisibility(0);
                            AppMethodBeat.o(112648);
                            return;
                        }
                        d.this.zQr.setVisibility(4);
                    }
                    AppMethodBeat.o(112648);
                }
            };
        }
        this.zQg.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(112649);
                if (d.this.aaM != null) {
                    if (!d.this.aaM.isAlive()) {
                        d.this.aaM = d.this.pP.getViewTreeObserver();
                    }
                    d.this.aaM.removeGlobalOnLayoutListener(d.this);
                    d.this.aaM = null;
                }
                d.this.zQg = null;
                AppMethodBeat.o(112649);
            }
        });
        AppMethodBeat.o(112660);
    }

    public final void F(View view, boolean z) {
        AppMethodBeat.i(112661);
        if (view == null) {
            AppMethodBeat.o(112661);
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
        AppMethodBeat.o(112661);
    }

    public final void q(CharSequence charSequence, int i) {
        AppMethodBeat.i(112662);
        if (this.zQk != null && this.zQw) {
            this.zQk.setVisibility(0);
            this.zQk.removeAllViews();
            this.zQk.setGravity(i);
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ade, null);
            TextView textView = (TextView) inflate.findViewById(R.id.b0p);
            textView.setText(charSequence);
            textView.setGravity(i | 80);
            this.zQk.addView(inflate, -1, -2);
        }
        AppMethodBeat.o(112662);
    }

    @TargetApi(23)
    private void dcd() {
        AppMethodBeat.i(112663);
        if (VERSION.SDK_INT >= 23 && this.zQg != null) {
            this.zQg.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.zQg.getWindow().setStatusBarColor(0);
        }
        AppMethodBeat.o(112663);
    }

    public final void cpD() {
        boolean z = false;
        AppMethodBeat.i(112664);
        this.uEM = isLandscape();
        this.zQq = getRotation();
        if (this.rBl != null) {
            this.rBl.a(this.rBn);
        }
        if (this.zQg != null) {
            dKY();
            if (!(this.zQi == null || this.zQm == null)) {
                this.zQm.aop.notifyChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.zQg.getWindow().addFlags(j.INVALID_ID);
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
            if (this.nA != null) {
                this.nA.nj = false;
            }
            if (this.zQf != null) {
                this.zQg.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(112650);
                        if (!d.this.zQx) {
                            d.this.zQf.onDismiss();
                        }
                        AppMethodBeat.o(112650);
                    }
                });
            }
            if (this.pP != null) {
                if (this.aaM == null) {
                    z = true;
                }
                this.aaM = this.pP.getViewTreeObserver();
                if (z) {
                    this.aaM.addOnGlobalLayoutListener(this);
                }
            }
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
                this.zQg.show();
            }
        }
        AppMethodBeat.o(112664);
    }

    public final void dKX() {
        AppMethodBeat.i(112665);
        if (this.zQg != null) {
            if (!(this.zQi == null || this.zQm == null)) {
                this.zQm.aop.notifyChanged();
            }
            this.zQg.show();
        }
        AppMethodBeat.o(112665);
    }

    public final void cpE() {
        AppMethodBeat.i(112666);
        if (this.zQg != null) {
            if (this.nA != null) {
                this.nA.nj = true;
            }
            this.zQg.dismiss();
        }
        AppMethodBeat.o(112666);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(112667);
        if (this.zQg == null || !this.zQg.isShowing()) {
            AppMethodBeat.o(112667);
            return false;
        }
        AppMethodBeat.o(112667);
        return true;
    }

    private void dKY() {
        int am;
        AppMethodBeat.i(112668);
        LayoutParams layoutParams = (LayoutParams) this.iym.getLayoutParams();
        int size = this.rBn.size();
        if (this.zQn) {
            size++;
        } else if (this.zQi.size() > 0) {
            size += this.zQi.size();
        }
        if (this.zQB) {
            int am2 = aj.am(this.mContext, R.dimen.ux);
            if (this.zQw) {
                am = aj.am(this.mContext, R.dimen.v0);
                if (this.zQC != 0) {
                    am = this.zQC;
                }
                this.zaX = (am + ((int) (((double) am2) * 4.5d))) + aj.am(this.mContext, R.dimen.uq);
            } else {
                this.zaX = (int) (((double) am2) * 6.5d);
            }
        }
        if (this.zQv == 0) {
            if (this.zQm.getItemCount() > this.zQt) {
                layoutParams.height = this.zaX;
            } else {
                layoutParams.height = ((aj.am(this.mContext, R.dimen.us) + aj.am(this.mContext, R.dimen.a2v)) * ((int) Math.ceil((double) (((float) this.zQm.getItemCount()) / ((float) this.zQs))))) + ak.fr(this.mContext);
                if (this.zQw) {
                    layoutParams.height += aj.am(this.mContext, R.dimen.a2v);
                }
            }
        } else if (size > this.zQu) {
            layoutParams.height = this.zaX;
        }
        if (this.uEM && this.pP != null) {
            Rect rect = new Rect();
            this.pP.getWindowVisibleDisplayFrame(rect);
            if (this.zQB) {
                layoutParams.width = (int) ((((float) rect.right) * 1.0f) / 2.0f);
                if (this.zQD != 0) {
                    layoutParams.width = this.zQD;
                }
                if (ak.hG(this.mContext)) {
                    layoutParams.height = rect.bottom - ak.hF(this.mContext);
                } else {
                    layoutParams.height = rect.bottom;
                }
                if (this.zQw) {
                    am = aj.am(this.mContext, R.dimen.ux);
                    if (size <= this.zQu) {
                        size = layoutParams.height - (size * am);
                    } else {
                        size = layoutParams.height - ((int) (((double) ((float) am)) * (((double) this.zQu) + 0.5d)));
                        if (size > aj.fromDPToPix(this.mContext, 150)) {
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
        AppMethodBeat.o(112668);
    }

    public final void a(c cVar) {
        this.rBl = cVar;
    }

    public final void a(com.tencent.mm.ui.base.n.d dVar) {
        this.rBm = dVar;
    }

    private boolean isLandscape() {
        AppMethodBeat.i(112669);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(112669);
            return true;
        }
        AppMethodBeat.o(112669);
        return false;
    }
}
