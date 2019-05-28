package com.tencent.p177mm.p612ui.widget.p633a;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5224ag;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.p627e.C5507a;
import com.tencent.p177mm.p612ui.widget.edittext.PasterEditText;

/* renamed from: com.tencent.mm.ui.widget.a.c */
public class C5653c extends Dialog implements DialogInterface {
    CheckBox aaY;
    private boolean gHY;
    private TextView jao;
    private Button lWE;
    private Context mContext;
    private boolean needEdit = false;
    /* renamed from: sQ */
    private View f1336sQ;
    public Button tJz;
    /* renamed from: tc */
    private EditText f1337tc;
    private LinearLayout ykT;
    public TextView ykU;
    private TextView ykV;
    public LinearLayout ykW;
    private LinearLayout ykX;
    private TextView zPF;
    private TextView zPG;
    private TextView zPH;
    public ImageView zPI;
    private View zPJ;
    private LinearLayout zPK;
    private ViewStub zPL;
    private ViewGroup zPM;
    private ViewGroup zPN;
    private View zPO;
    private boolean zPP = false;
    private Animation zPQ;
    private Animation zPR;
    private Animation zPS;
    private Animation zPT;
    private C5651d zPU;
    public OnDismissListener zPV;

    /* renamed from: com.tencent.mm.ui.widget.a.c$9 */
    class C56479 implements Runnable {
        C56479() {
        }

        public final void run() {
            AppMethodBeat.m2504i(112613);
            C5653c.this.dismiss();
            AppMethodBeat.m2505o(112613);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.a.c$a */
    public static class C5652a {
        public Context mContext;
        public C5636a zQe = new C5636a();

        /* renamed from: com.tencent.mm.ui.widget.a.c$a$a */
        public interface C5648a {
            /* renamed from: u */
            void mo11442u(ImageView imageView, String str);
        }

        /* renamed from: com.tencent.mm.ui.widget.a.c$a$b */
        public interface C5649b {
            void bwF();
        }

        /* renamed from: com.tencent.mm.ui.widget.a.c$a$c */
        public interface C5650c {
            void djv();
        }

        /* renamed from: com.tencent.mm.ui.widget.a.c$a$d */
        public interface C5651d {
            /* renamed from: a */
            CharSequence mo11445a(CharSequence charSequence, float f);
        }

        public C5652a(Context context) {
            AppMethodBeat.m2504i(112614);
            this.mContext = context;
            AppMethodBeat.m2505o(112614);
        }

        public final C5652a asD(String str) {
            this.zQe.title = str;
            return this;
        }

        /* renamed from: ai */
        public final C5652a mo11464ai(CharSequence charSequence) {
            this.zQe.title = charSequence;
            return this;
        }

        /* renamed from: aj */
        public final C5652a mo11465aj(CharSequence charSequence) {
            this.zQe.zOM = charSequence;
            return this;
        }

        /* renamed from: PV */
        public final C5652a mo11446PV(int i) {
            AppMethodBeat.m2504i(112615);
            this.zQe.title = this.mContext.getString(i);
            AppMethodBeat.m2505o(112615);
            return this;
        }

        /* renamed from: PW */
        public final C5652a mo11447PW(int i) {
            this.zQe.vfK = i;
            return this;
        }

        /* renamed from: PX */
        public final C5652a mo11448PX(int i) {
            this.zQe.zPu = i;
            return this;
        }

        /* renamed from: PY */
        public final C5652a mo11449PY(int i) {
            this.zQe.yCn = i;
            return this;
        }

        public final C5652a asE(String str) {
            this.zQe.zPc = str;
            return this;
        }

        /* renamed from: PZ */
        public final C5652a mo11450PZ(int i) {
            AppMethodBeat.m2504i(112616);
            this.zQe.zPc = this.mContext.getString(i);
            AppMethodBeat.m2505o(112616);
            return this;
        }

        /* renamed from: Qa */
        public final C5652a mo11451Qa(int i) {
            this.zQe.zPv = i;
            return this;
        }

        /* renamed from: ak */
        public final C5652a mo11466ak(CharSequence charSequence) {
            this.zQe.zPd = charSequence;
            return this;
        }

        /* renamed from: ra */
        public final C5652a mo11480ra(boolean z) {
            this.zQe.zPl = z;
            return this;
        }

        /* renamed from: a */
        public final C5652a mo11461a(String str, CharSequence charSequence, Boolean bool, C5650c c5650c, C5648a c5648a) {
            AppMethodBeat.m2504i(112617);
            this.zQe.zOR = str;
            this.zQe.zOS = charSequence;
            this.zQe.zOT = bool.booleanValue();
            this.zQe.zOV = c5650c;
            this.zQe.zOW = c5648a;
            AppMethodBeat.m2505o(112617);
            return this;
        }

        /* renamed from: b */
        public final C5652a mo11477b(C5649b c5649b) {
            this.zQe.zOX = c5649b;
            return this;
        }

        /* renamed from: a */
        public final C5652a mo11460a(C5651d c5651d) {
            this.zQe.zOY = c5651d;
            return this;
        }

        /* renamed from: ar */
        public final C5652a mo11467ar(Bitmap bitmap) {
            this.zQe.zPa = bitmap;
            return this;
        }

        public final C5652a asF(String str) {
            this.zQe.thumbPath = str;
            return this;
        }

        /* renamed from: a */
        public final C5652a mo11459a(Bitmap bitmap, boolean z, int i) {
            this.zQe.zPb = bitmap;
            this.zQe.zPm = z;
            this.zQe.zPx = i;
            return this;
        }

        public final C5652a asG(String str) {
            this.zQe.zON = str;
            return this;
        }

        /* renamed from: Qb */
        public final C5652a mo11452Qb(int i) {
            this.zQe.zPw = i;
            return this;
        }

        public final C5652a asH(String str) {
            this.zQe.zOO = str;
            return this;
        }

        public final C5652a asI(String str) {
            this.zQe.zOP = str;
            return this;
        }

        /* renamed from: rb */
        public final C5652a mo11481rb(boolean z) {
            this.zQe.zOQ = z;
            return this;
        }

        /* renamed from: fn */
        public final C5652a mo11479fn(View view) {
            this.zQe.uvN = view;
            return this;
        }

        public final C5652a asJ(String str) {
            this.zQe.zPf = str;
            return this;
        }

        /* renamed from: Qc */
        public final C5652a mo11453Qc(int i) {
            AppMethodBeat.m2504i(112618);
            this.zQe.zPf = this.mContext.getString(i);
            AppMethodBeat.m2505o(112618);
            return this;
        }

        /* renamed from: a */
        public final C5652a mo11457a(OnClickListener onClickListener) {
            this.zQe.zPn = onClickListener;
            return this;
        }

        /* renamed from: a */
        public final C5652a mo11462a(boolean z, OnClickListener onClickListener) {
            this.zQe.zPn = onClickListener;
            this.zQe.zPB = z;
            return this;
        }

        public final C5652a asK(String str) {
            this.zQe.zPg = str;
            return this;
        }

        /* renamed from: Qd */
        public final C5652a mo11454Qd(int i) {
            AppMethodBeat.m2504i(112619);
            this.zQe.zPg = this.mContext.getString(i);
            AppMethodBeat.m2505o(112619);
            return this;
        }

        /* renamed from: Qe */
        public final C5652a mo11455Qe(int i) {
            this.zQe.zPA = i;
            return this;
        }

        /* renamed from: Qf */
        public final C5652a mo11456Qf(int i) {
            this.zQe.zPz = i;
            return this;
        }

        /* renamed from: b */
        public final C5652a mo11476b(OnClickListener onClickListener) {
            this.zQe.zPo = onClickListener;
            return this;
        }

        /* renamed from: f */
        public final C5652a mo11478f(OnCancelListener onCancelListener) {
            this.zQe.f1334Ue = onCancelListener;
            return this;
        }

        /* renamed from: a */
        public final C5652a mo11458a(OnDismissListener onDismissListener) {
            this.zQe.f1335Uf = onDismissListener;
            return this;
        }

        /* renamed from: rc */
        public final C5652a mo11482rc(boolean z) {
            this.zQe.gHY = z;
            return this;
        }

        /* renamed from: rd */
        public final C5652a mo11483rd(boolean z) {
            this.zQe.zPk = z;
            return this;
        }

        public C5653c aMb() {
            AppMethodBeat.m2504i(112620);
            C5653c c5653c = new C5653c(this.mContext);
            c5653c.mo11488a(this.zQe);
            AppMethodBeat.m2505o(112620);
            return c5653c;
        }

        public final void show() {
            AppMethodBeat.m2504i(139030);
            aMb().show();
            AppMethodBeat.m2505o(139030);
        }
    }

    public C5653c(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(112622);
        this.mContext = context;
        this.ykT = (LinearLayout) View.inflate(this.mContext, 2130970091, null);
        this.tJz = (Button) this.ykT.findViewById(2131822912);
        this.lWE = (Button) this.ykT.findViewById(2131822911);
        this.jao = (TextView) this.ykT.findViewById(2131825974);
        this.zPF = (TextView) this.ykT.findViewById(2131825975);
        this.ykU = (TextView) this.ykT.findViewById(2131825979);
        this.ykV = (TextView) this.ykT.findViewById(2131822917);
        this.zPG = (TextView) this.ykT.findViewById(2131822918);
        this.zPH = (TextView) this.ykT.findViewById(2131822924);
        this.f1337tc = (EditText) this.ykT.findViewById(2131822921);
        this.aaY = (CheckBox) this.ykT.findViewById(2131825981);
        this.zPI = (ImageView) this.ykT.findViewById(2131822916);
        this.zPK = (LinearLayout) this.ykT.findViewById(2131825973);
        this.zPL = (ViewStub) this.ykT.findViewById(2131825976);
        this.ykW = (LinearLayout) this.ykT.findViewById(2131824516);
        this.zPM = (ViewGroup) this.ykT.findViewById(2131825982);
        this.zPO = this.ykT.findViewById(2131825983);
        this.ykX = (LinearLayout) this.ykT.findViewById(2131825980);
        this.zPN = (ViewGroup) this.ykT.findViewById(2131825977);
        setCanceledOnTouchOutside(true);
        this.zPQ = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8288n);
        this.zPR = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8288n);
        this.zPS = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8289o);
        this.zPT = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8289o);
        AppMethodBeat.m2505o(112622);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112623);
        super.onCreate(bundle);
        setContentView(this.ykT);
        AppMethodBeat.m2505o(112623);
    }

    public View getContentView() {
        return this.ykT;
    }

    public void setTitle(CharSequence charSequence) {
        AppMethodBeat.m2504i(112624);
        this.zPK.setVisibility(0);
        this.jao.setVisibility(0);
        if (this.zPU != null) {
            charSequence = this.zPU.mo11445a(charSequence.toString(), this.jao.getTextSize());
        }
        this.jao.setMaxLines(2);
        this.jao.setText(charSequence);
        this.jao.getPaint().setFakeBoldText(true);
        dxO();
        AppMethodBeat.m2505o(112624);
    }

    public void setTitle(int i) {
        AppMethodBeat.m2504i(112625);
        this.zPK.setVisibility(0);
        this.jao.setVisibility(0);
        this.jao.setMaxLines(2);
        this.jao.setText(i);
        this.jao.getPaint().setFakeBoldText(true);
        dxO();
        AppMethodBeat.m2505o(112625);
    }

    private void dxO() {
        AppMethodBeat.m2504i(112626);
        if (this.ykU != null) {
            this.ykU.setTextColor(this.ykU.getContext().getResources().getColor(C25738R.color.f11939ma));
        }
        AppMethodBeat.m2505o(112626);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.m2504i(112627);
        this.ykW.setVisibility(0);
        this.ykU.setVisibility(0);
        if (this.zPU != null) {
            C5651d c5651d = this.zPU;
            this.ykU.getContext();
            charSequence = c5651d.mo11445a(charSequence.toString(), this.ykU.getTextSize());
        }
        this.ykU.setText(charSequence);
        AppMethodBeat.m2505o(112627);
    }

    /* renamed from: qY */
    private void m8486qY(boolean z) {
        AppMethodBeat.m2504i(112628);
        if (z) {
            int fromDPToPix = C5229aj.fromDPToPix(this.mContext, 8);
            this.ykW.setVisibility(0);
            this.ykW.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.ykW.setBackgroundResource(C25738R.drawable.f6660ll);
        }
        AppMethodBeat.m2505o(112628);
    }

    public final String dKV() {
        AppMethodBeat.m2504i(112629);
        if (this.f1337tc == null) {
            AppMethodBeat.m2505o(112629);
            return null;
        }
        String obj = this.f1337tc.getText().toString();
        AppMethodBeat.m2505o(112629);
        return obj;
    }

    public final int dKW() {
        AppMethodBeat.m2504i(112630);
        if (this.f1337tc instanceof PasterEditText) {
            int pasterLen = ((PasterEditText) this.f1337tc).getPasterLen();
            AppMethodBeat.m2505o(112630);
            return pasterLen;
        }
        AppMethodBeat.m2505o(112630);
        return 0;
    }

    /* renamed from: PS */
    private void m8476PS(int i) {
        AppMethodBeat.m2504i(112631);
        if (this.ykW != null) {
            this.ykW.setVisibility(i);
        }
        if (this.ykX != null) {
            this.ykX.setVisibility(i);
        }
        if (this.zPH != null && this.zPP) {
            this.zPH.setVisibility(i);
        }
        if (this.f1337tc != null) {
            if (this.needEdit) {
                this.f1337tc.setVisibility(i);
            } else {
                this.f1337tc.setVisibility(8);
                AppMethodBeat.m2505o(112631);
                return;
            }
        }
        AppMethodBeat.m2505o(112631);
    }

    /* renamed from: ao */
    private void m8480ao(View view, int i) {
        AppMethodBeat.m2504i(112632);
        this.f1336sQ = view;
        if (this.f1336sQ != null) {
            this.ykW.setVisibility(0);
            this.ykX.setVisibility(0);
            this.ykX.removeAllViews();
            this.ykX.setGravity(1);
            this.ykX.addView(this.f1336sQ, new LayoutParams(i, i));
        }
        AppMethodBeat.m2505o(112632);
    }

    /* renamed from: a */
    public final void mo11489a(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        AppMethodBeat.m2504i(112633);
        if (this.tJz == null) {
            AppMethodBeat.m2505o(112633);
            return;
        }
        this.tJz.setVisibility(0);
        this.tJz.setText(charSequence);
        this.tJz.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(112608);
                if (onClickListener != null) {
                    onClickListener.onClick(C5653c.this, -1);
                }
                if (z) {
                    C5653c.this.dismiss();
                }
                AppMethodBeat.m2505o(112608);
            }
        });
        AppMethodBeat.m2505o(112633);
    }

    /* renamed from: PT */
    public final void mo11485PT(int i) {
        AppMethodBeat.m2504i(112634);
        this.tJz.setTextColor(i);
        AppMethodBeat.m2505o(112634);
    }

    /* renamed from: PU */
    public final void mo11486PU(int i) {
        AppMethodBeat.m2504i(112635);
        this.lWE.setTextColor(i);
        AppMethodBeat.m2505o(112635);
    }

    /* renamed from: a */
    public final void mo11487a(int i, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(112636);
        mo11489a(this.mContext.getString(i), true, onClickListener);
        AppMethodBeat.m2505o(112636);
    }

    /* renamed from: b */
    public final void mo11491b(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        AppMethodBeat.m2504i(112637);
        if (this.lWE == null) {
            AppMethodBeat.m2505o(112637);
            return;
        }
        this.lWE.setVisibility(0);
        this.lWE.setText(charSequence);
        this.lWE.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(112609);
                if (onClickListener != null) {
                    onClickListener.onClick(C5653c.this, -2);
                }
                if (z) {
                    C5653c.this.cancel();
                }
                AppMethodBeat.m2505o(112609);
            }
        });
        AppMethodBeat.m2505o(112637);
    }

    /* renamed from: b */
    public final void mo11490b(int i, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(112638);
        mo11491b(this.mContext.getString(i), true, onClickListener);
        AppMethodBeat.m2505o(112638);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.m2504i(112639);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.m2505o(112639);
    }

    /* renamed from: qZ */
    public final void mo11498qZ(boolean z) {
        AppMethodBeat.m2504i(112640);
        super.setCancelable(z);
        AppMethodBeat.m2505o(112640);
    }

    public final Button getButton(int i) {
        switch (i) {
            case -2:
                return this.lWE;
            case -1:
                return this.tJz;
            default:
                return null;
        }
    }

    /* renamed from: a */
    private void m8477a(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(112641);
        this.zPO.setVisibility(8);
        this.zPM.removeAllViews();
        this.zPM.addView(view, layoutParams);
        AppMethodBeat.m2505o(112641);
    }

    /* renamed from: a */
    public final void mo11488a(C5636a c5636a) {
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        ImageView imageView;
        TextView textView;
        AppMethodBeat.m2504i(112642);
        if (c5636a.title != null && c5636a.title.length() > 0) {
            i = c5636a.yCn;
            if (this.jao != null) {
                this.jao.setGravity(i);
            }
            setTitle(c5636a.title);
        }
        if (c5636a.zOM != null && c5636a.zOM.length() > 0) {
            charSequence = c5636a.zOM;
            this.zPK.setVisibility(0);
            this.zPF.setVisibility(0);
            if (this.zPU != null) {
                charSequence = this.zPU.mo11445a(charSequence.toString(), this.jao.getTextSize());
            }
            this.zPF.setText(charSequence);
        }
        if (c5636a.vfK != 0) {
            this.jao.setTextColor(ColorStateList.valueOf(c5636a.vfK));
        }
        if (c5636a.zPu != 0) {
            this.jao.setMaxLines(c5636a.zPu);
        }
        if (c5636a.zPv != 0) {
            this.ykU.setMaxLines(c5636a.zPv);
        }
        if (c5636a.uvN != null) {
            m8480ao(c5636a.uvN, -1);
        }
        if (c5636a.zPs != null) {
            LinearLayout linearLayout;
            View view = c5636a.zPs;
            this.zPK.setVisibility(0);
            this.zPL.setLayoutResource(2130969177);
            try {
                linearLayout = (LinearLayout) this.zPL.inflate();
            } catch (Exception e) {
                this.zPL.setVisibility(0);
                linearLayout = null;
            }
            linearLayout.addView(view);
        }
        if (c5636a.zPt != null) {
            this.zPJ = c5636a.zPt;
            if (this.zPJ != null) {
                this.ykW.setVisibility(8);
                this.zPH.setVisibility(8);
                this.f1337tc.setVisibility(8);
                this.zPN.removeAllViews();
                this.zPN.addView(this.zPJ, new LayoutParams(-1, -1));
                this.zPN.setVisibility(8);
            }
        }
        if (c5636a.zOZ != null) {
            Drawable drawable = c5636a.zOZ;
            if (this.f1336sQ == null) {
                this.ykW.setVisibility(0);
                this.zPI.setVisibility(0);
                this.zPI.setBackgroundDrawable(drawable);
            }
        }
        if (c5636a.zPc != null && c5636a.zPc.length() > 0) {
            setMessage(c5636a.zPc);
        }
        m8486qY(c5636a.zPl);
        if (c5636a.thumbPath != null) {
            String str = c5636a.thumbPath;
            int fromDPToPix = C5229aj.fromDPToPix(this.mContext, 120);
            this.ykW.setVisibility(0);
            this.zPI.setVisibility(0);
            if (this.zPI instanceof C5507a) {
                ((C5507a) this.zPI).mo11120am(str, fromDPToPix, fromDPToPix);
            }
            i = c5636a.zPy;
            this.ykW.setVisibility(i);
            this.zPI.setVisibility(i);
        }
        if (!(c5636a.zPC || c5636a.zPD)) {
            if (c5636a.zPc != null && c5636a.zPc.length() > 0) {
                setMessage(c5636a.zPc);
            }
            if (c5636a.zPd == null || c5636a.zPd.length() <= 0) {
                m8486qY(false);
            } else {
                charSequence = c5636a.zPd;
                this.ykW.setVisibility(0);
                this.ykV.setVisibility(0);
                this.ykV.setMaxLines(2);
                this.ykV.setText(charSequence);
            }
            if (c5636a.zPe != null && c5636a.zPe.length() > 0) {
                charSequence = c5636a.zPe;
                if (charSequence != null) {
                    this.ykW.setVisibility(0);
                    this.zPG.setVisibility(0);
                    if (this.zPU != null) {
                        C5651d c5651d = this.zPU;
                        this.zPG.getContext();
                        charSequence = c5651d.mo11445a(charSequence.toString(), this.zPG.getTextSize());
                    }
                    this.zPG.setText(charSequence);
                }
            }
            if (c5636a.zPa != null) {
                Bitmap bitmap = c5636a.zPa;
                if (this.f1336sQ == null) {
                    this.ykW.setVisibility(0);
                    this.zPI.setVisibility(0);
                    this.zPI.setImageBitmap(bitmap);
                }
            }
        }
        Bitmap bitmap2;
        CharSequence charSequence3;
        View inflate;
        if (c5636a.zPC) {
            bitmap2 = c5636a.zPa;
            charSequence2 = c5636a.zPd;
            charSequence3 = c5636a.zPe;
            inflate = View.inflate(this.mContext, 2130969180, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(2131822916);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(2131822917);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.mo11445a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(2131822918);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.mo11445a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            m8480ao(inflate, -1);
        } else if (c5636a.zPD) {
            bitmap2 = c5636a.zPa;
            charSequence2 = c5636a.zPd;
            charSequence3 = c5636a.zPe;
            inflate = View.inflate(this.mContext, 2130969181, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(2131822916);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(2131822917);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.mo11445a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(2131822918);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.mo11445a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            m8480ao(inflate, -1);
        }
        if (!(c5636a.zOR == null && c5636a.zOS == null)) {
            String str2 = c5636a.zOR;
            charSequence2 = c5636a.zOS;
            Boolean valueOf = Boolean.valueOf(c5636a.zOT);
            final C5650c c5650c = c5636a.zOV;
            C5648a c5648a = c5636a.zOW;
            this.zPL.setLayoutResource(2130969190);
            LinearLayout linearLayout2 = null;
            try {
                linearLayout2 = (LinearLayout) this.zPL.inflate();
            } catch (Exception e2) {
                this.zPL.setVisibility(0);
            }
            if (!(linearLayout2 == null || str2 == null)) {
                imageView = (ImageView) linearLayout2.findViewById(2131822937);
                imageView.setVisibility(0);
                if (c5648a != null) {
                    c5648a.mo11442u(imageView, str2);
                }
            }
            if (!(linearLayout2 == null || charSequence2 == null)) {
                textView = (TextView) linearLayout2.findViewById(2131822938);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.mo11445a(charSequence2.toString(), this.jao.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (valueOf.booleanValue() && linearLayout2 != null) {
                imageView = (ImageView) linearLayout2.findViewById(2131822939);
                imageView.setVisibility(0);
                m8476PS(0);
                linearLayout2.setOnClickListener(new View.OnClickListener() {

                    /* renamed from: com.tencent.mm.ui.widget.a.c$1$1 */
                    class C56371 implements AnimationListener {
                        C56371() {
                        }

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.m2504i(112601);
                            C5653c.m8479a(C5653c.this, C5653c.this.zPQ);
                            AppMethodBeat.m2505o(112601);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.m2504i(112602);
                            C5653c.this.zPN.setVisibility(8);
                            C5653c.m8478a(C5653c.this, 0);
                            AppMethodBeat.m2505o(112602);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    }

                    /* renamed from: com.tencent.mm.ui.widget.a.c$1$2 */
                    class C56382 implements AnimationListener {
                        C56382() {
                        }

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.m2504i(112603);
                            C5653c.m8479a(C5653c.this, C5653c.this.zPS);
                            AppMethodBeat.m2505o(112603);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.m2504i(112604);
                            C5653c.this.zPN.setVisibility(0);
                            C5653c.m8478a(C5653c.this, 8);
                            AppMethodBeat.m2505o(112604);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(112605);
                        if (c5650c != null) {
                            c5650c.djv();
                        }
                        if (imageView.isSelected()) {
                            C5653c.this.zPN.startAnimation(C5653c.this.zPT);
                            C5653c.this.zPT.setAnimationListener(new C56371());
                            ObjectAnimator.ofFloat(imageView, "rotation", new float[]{180.0f, 0.0f}).setDuration(200).start();
                            imageView.setSelected(false);
                            AppMethodBeat.m2505o(112605);
                            return;
                        }
                        C5653c.this.zPN.startAnimation(C5653c.this.zPR);
                        C5653c.this.zPR.setAnimationListener(new C56382());
                        ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 180.0f}).setDuration(200).start();
                        imageView.setSelected(true);
                        AppMethodBeat.m2505o(112605);
                    }
                });
            }
        }
        if (c5636a.zOX != null) {
            final C5649b c5649b = c5636a.zOX;
            if (this.ykW != null && this.ykW.getVisibility() == 0) {
                this.ykW.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(112606);
                        if (c5649b != null) {
                            c5649b.bwF();
                        }
                        AppMethodBeat.m2505o(112606);
                    }
                });
            } else if (this.ykX != null) {
                this.ykX.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(112607);
                        if (c5649b != null) {
                            c5649b.bwF();
                        }
                        AppMethodBeat.m2505o(112607);
                    }
                });
            }
        }
        if (!(c5636a.zPb == null || c5636a.zPb.isRecycled())) {
            Bitmap bitmap3 = c5636a.zPb;
            boolean z = c5636a.zPm;
            int i2 = c5636a.zPx;
            if (bitmap3 != null) {
                Bitmap bitmap4;
                m8486qY(false);
                this.ykW.setVisibility(0);
                this.ykW.setGravity(1);
                this.ykW.setPadding(0, 0, 0, 0);
                View inflate2 = View.inflate(this.mContext, 2130969182, null);
                imageView = (ImageView) inflate2.findViewById(2131822916);
                if (z) {
                    bitmap4 = null;
                    float height = ((float) bitmap3.getHeight()) / ((float) bitmap3.getWidth());
                    int i3 = 0;
                    int i4 = 0;
                    int am = C5229aj.m7981am(this.mContext, C25738R.dimen.f9786fl);
                    int am2 = C5229aj.m7981am(this.mContext, C25738R.dimen.f9785fk);
                    int i5 = 0;
                    int i6 = 0;
                    if (height > 0.0f && ((double) height) < 0.5d) {
                        i4 = (int) (((float) am) / height);
                        i6 = am;
                        i5 = am2;
                        i3 = am;
                    } else if (((double) height) >= 0.5d && height < 1.0f) {
                        am = (int) (((float) am2) * height);
                        i6 = am;
                        i5 = am2;
                        i4 = am2;
                        i3 = am;
                    } else if (height >= 1.0f && height < 2.0f) {
                        am = (int) (((float) am2) / height);
                        i6 = am2;
                        i5 = am;
                        i4 = am;
                        i3 = am2;
                    } else if (height >= 2.0f) {
                        i3 = (int) (((float) am) * height);
                        i6 = am2;
                        i5 = am;
                        i4 = am;
                    }
                    if (i3 > 0 && i4 > 0 && bitmap3 != null) {
                        bitmap4 = Bitmap.createScaledBitmap(bitmap3, i4, i3, true);
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(i5, i6));
                    }
                    bitmap4 = C5224ag.m7956d(bitmap4, (float) C5229aj.fromDPToPix(this.mContext, 3));
                } else {
                    bitmap4 = bitmap3;
                }
                imageView.setImageBitmap(bitmap4);
                imageView = (ImageView) inflate2.findViewById(2131822919);
                if (i2 == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    if (i2 == 1) {
                        imageView.setImageResource(C1318a.sight_icon_in_gird);
                    } else if (i2 == 2) {
                        imageView.setImageResource(C1318a.video_icon_in_gird);
                    }
                }
                m8480ao(inflate2, -2);
            }
        }
        if (c5636a.zON != null && c5636a.zON.length() > 0) {
            charSequence = c5636a.zON;
            if (charSequence != null) {
                this.zPH.setVisibility(0);
                this.zPH.setText(charSequence);
            }
            this.zPP = true;
            i = c5636a.zPw;
            if (this.zPH != null) {
                this.zPH.setGravity(i);
            }
        }
        if (c5636a.zOO != null && c5636a.zOO.length() > 0) {
            charSequence = c5636a.zOO;
            this.f1337tc.setVisibility(0);
            this.f1337tc.setHint(charSequence);
        }
        if (c5636a.zOP != null && c5636a.zOP.length() > 0) {
            charSequence = c5636a.zOP;
            this.aaY.setVisibility(0);
            this.aaY.setText(charSequence);
        }
        if (c5636a.zOQ) {
            this.needEdit = c5636a.zOQ;
            if (c5636a.zOQ) {
                this.f1337tc.setVisibility(0);
            } else {
                this.f1337tc.setVisibility(8);
            }
        }
        if (c5636a.zPf != null && c5636a.zPf.length() > 0) {
            mo11489a(c5636a.zPf, c5636a.zPB, c5636a.zPn);
        }
        if (c5636a.zPg != null && c5636a.zPg.length() > 0) {
            mo11491b(c5636a.zPg, true, c5636a.zPo);
        }
        if (c5636a.zPA != 0) {
            mo11485PT(c5636a.zPA);
        }
        if (c5636a.zPz != 0) {
            mo11486PU(c5636a.zPz);
        }
        if (c5636a.f1334Ue != null) {
            setOnCancelListener(c5636a.f1334Ue);
        }
        if (c5636a.f1335Uf != null) {
            this.zPV = c5636a.f1335Uf;
            setOnDismissListener(c5636a.f1335Uf);
        }
        if (c5636a.zOY != null) {
            this.zPU = c5636a.zOY;
        }
        setCancelable(c5636a.gHY);
        this.gHY = c5636a.gHY;
        if (!this.gHY) {
            super.setCancelable(c5636a.zPk);
        }
        if (!(c5636a.zPh == null && c5636a.zPi == null && c5636a.zPj == null)) {
            final C5636a c5636a2;
            View inflate3 = View.inflate(this.mContext, 2130969189, null);
            Button button = (Button) inflate3.findViewById(2131822934);
            Button button2 = (Button) inflate3.findViewById(2131822935);
            Button button3 = (Button) inflate3.findViewById(2131822936);
            if (c5636a.zPh != null) {
                button.setVisibility(0);
                button.setText(c5636a.zPh);
                c5636a2 = c5636a;
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(112610);
                        if (c5636a2.zPp != null) {
                            c5636a2.zPp.onClick(C5653c.this, -1);
                        }
                        C5653c.this.dismiss();
                        AppMethodBeat.m2505o(112610);
                    }
                });
            }
            if (c5636a.zPi != null) {
                button2.setVisibility(0);
                button2.setText(c5636a.zPi);
                c5636a2 = c5636a;
                button2.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(112611);
                        if (c5636a2.zPq != null) {
                            c5636a2.zPq.onClick(C5653c.this, -2);
                        }
                        C5653c.this.dismiss();
                        AppMethodBeat.m2505o(112611);
                    }
                });
            }
            if (c5636a.zPj != null) {
                button3.setVisibility(0);
                button3.setText(c5636a.zPj);
                c5636a2 = c5636a;
                button3.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(112612);
                        if (c5636a2.zPr != null) {
                            c5636a2.zPr.onClick(C5653c.this, -3);
                        }
                        C5653c.this.dismiss();
                        AppMethodBeat.m2505o(112612);
                    }
                });
            }
            m8477a(inflate3, new LayoutParams(-1, -1));
        }
        if (c5636a.zOU) {
            View inflate4 = View.inflate(this.mContext, 2130969176, null);
            this.lWE = (Button) inflate4.findViewById(2131822911);
            this.tJz = (Button) inflate4.findViewById(2131822912);
            if (c5636a.zPA != 0) {
                mo11485PT(c5636a.zPA);
            }
            if (c5636a.zPz != 0) {
                mo11486PU(c5636a.zPz);
            }
            if (c5636a.zPf != null && c5636a.zPf.length() > 0) {
                mo11489a(c5636a.zPf, c5636a.zPB, c5636a.zPn);
            }
            if (c5636a.zPg != null && c5636a.zPg.length() > 0) {
                mo11491b(c5636a.zPg, true, c5636a.zPo);
            }
            m8477a(inflate4, new LayoutParams(-1, -1));
        }
        AppMethodBeat.m2505o(112642);
    }

    public void show() {
        AppMethodBeat.m2504i(112643);
        try {
            super.show();
            AppMethodBeat.m2505o(112643);
        } catch (Exception e) {
            C5227ai.printErrStackTrace("MicroMsg.MMAlertDialog", e, "", new Object[0]);
            AppMethodBeat.m2505o(112643);
        }
    }

    public void dismiss() {
        AppMethodBeat.m2504i(112644);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new C56479());
            C5227ai.m7972e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
            AppMethodBeat.m2505o(112644);
            return;
        }
        try {
            super.dismiss();
            AppMethodBeat.m2505o(112644);
        } catch (Exception e) {
            C5227ai.m7972e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + e.getMessage(), new Object[0]);
            AppMethodBeat.m2505o(112644);
        }
    }
}
