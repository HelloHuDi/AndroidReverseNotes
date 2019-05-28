package com.tencent.mm.ui.widget.a;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class c extends Dialog implements DialogInterface {
    CheckBox aaY;
    private boolean gHY;
    private TextView jao;
    private Button lWE;
    private Context mContext;
    private boolean needEdit = false;
    private View sQ;
    public Button tJz;
    private EditText tc;
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
    private d zPU;
    public OnDismissListener zPV;

    public static class a {
        public Context mContext;
        public a zQe = new a();

        public interface a {
            void u(ImageView imageView, String str);
        }

        public interface b {
            void bwF();
        }

        public interface c {
            void djv();
        }

        public interface d {
            CharSequence a(CharSequence charSequence, float f);
        }

        public a(Context context) {
            AppMethodBeat.i(112614);
            this.mContext = context;
            AppMethodBeat.o(112614);
        }

        public final a asD(String str) {
            this.zQe.title = str;
            return this;
        }

        public final a ai(CharSequence charSequence) {
            this.zQe.title = charSequence;
            return this;
        }

        public final a aj(CharSequence charSequence) {
            this.zQe.zOM = charSequence;
            return this;
        }

        public final a PV(int i) {
            AppMethodBeat.i(112615);
            this.zQe.title = this.mContext.getString(i);
            AppMethodBeat.o(112615);
            return this;
        }

        public final a PW(int i) {
            this.zQe.vfK = i;
            return this;
        }

        public final a PX(int i) {
            this.zQe.zPu = i;
            return this;
        }

        public final a PY(int i) {
            this.zQe.yCn = i;
            return this;
        }

        public final a asE(String str) {
            this.zQe.zPc = str;
            return this;
        }

        public final a PZ(int i) {
            AppMethodBeat.i(112616);
            this.zQe.zPc = this.mContext.getString(i);
            AppMethodBeat.o(112616);
            return this;
        }

        public final a Qa(int i) {
            this.zQe.zPv = i;
            return this;
        }

        public final a ak(CharSequence charSequence) {
            this.zQe.zPd = charSequence;
            return this;
        }

        public final a ra(boolean z) {
            this.zQe.zPl = z;
            return this;
        }

        public final a a(String str, CharSequence charSequence, Boolean bool, c cVar, a aVar) {
            AppMethodBeat.i(112617);
            this.zQe.zOR = str;
            this.zQe.zOS = charSequence;
            this.zQe.zOT = bool.booleanValue();
            this.zQe.zOV = cVar;
            this.zQe.zOW = aVar;
            AppMethodBeat.o(112617);
            return this;
        }

        public final a b(b bVar) {
            this.zQe.zOX = bVar;
            return this;
        }

        public final a a(d dVar) {
            this.zQe.zOY = dVar;
            return this;
        }

        public final a ar(Bitmap bitmap) {
            this.zQe.zPa = bitmap;
            return this;
        }

        public final a asF(String str) {
            this.zQe.thumbPath = str;
            return this;
        }

        public final a a(Bitmap bitmap, boolean z, int i) {
            this.zQe.zPb = bitmap;
            this.zQe.zPm = z;
            this.zQe.zPx = i;
            return this;
        }

        public final a asG(String str) {
            this.zQe.zON = str;
            return this;
        }

        public final a Qb(int i) {
            this.zQe.zPw = i;
            return this;
        }

        public final a asH(String str) {
            this.zQe.zOO = str;
            return this;
        }

        public final a asI(String str) {
            this.zQe.zOP = str;
            return this;
        }

        public final a rb(boolean z) {
            this.zQe.zOQ = z;
            return this;
        }

        public final a fn(View view) {
            this.zQe.uvN = view;
            return this;
        }

        public final a asJ(String str) {
            this.zQe.zPf = str;
            return this;
        }

        public final a Qc(int i) {
            AppMethodBeat.i(112618);
            this.zQe.zPf = this.mContext.getString(i);
            AppMethodBeat.o(112618);
            return this;
        }

        public final a a(OnClickListener onClickListener) {
            this.zQe.zPn = onClickListener;
            return this;
        }

        public final a a(boolean z, OnClickListener onClickListener) {
            this.zQe.zPn = onClickListener;
            this.zQe.zPB = z;
            return this;
        }

        public final a asK(String str) {
            this.zQe.zPg = str;
            return this;
        }

        public final a Qd(int i) {
            AppMethodBeat.i(112619);
            this.zQe.zPg = this.mContext.getString(i);
            AppMethodBeat.o(112619);
            return this;
        }

        public final a Qe(int i) {
            this.zQe.zPA = i;
            return this;
        }

        public final a Qf(int i) {
            this.zQe.zPz = i;
            return this;
        }

        public final a b(OnClickListener onClickListener) {
            this.zQe.zPo = onClickListener;
            return this;
        }

        public final a f(OnCancelListener onCancelListener) {
            this.zQe.Ue = onCancelListener;
            return this;
        }

        public final a a(OnDismissListener onDismissListener) {
            this.zQe.Uf = onDismissListener;
            return this;
        }

        public final a rc(boolean z) {
            this.zQe.gHY = z;
            return this;
        }

        public final a rd(boolean z) {
            this.zQe.zPk = z;
            return this;
        }

        public c aMb() {
            AppMethodBeat.i(112620);
            c cVar = new c(this.mContext);
            cVar.a(this.zQe);
            AppMethodBeat.o(112620);
            return cVar;
        }

        public final void show() {
            AppMethodBeat.i(139030);
            aMb().show();
            AppMethodBeat.o(139030);
        }
    }

    public c(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(112622);
        this.mContext = context;
        this.ykT = (LinearLayout) View.inflate(this.mContext, R.layout.ad5, null);
        this.tJz = (Button) this.ykT.findViewById(R.id.b00);
        this.lWE = (Button) this.ykT.findViewById(R.id.azz);
        this.jao = (TextView) this.ykT.findViewById(R.id.d8s);
        this.zPF = (TextView) this.ykT.findViewById(R.id.d8t);
        this.ykU = (TextView) this.ykT.findViewById(R.id.d8x);
        this.ykV = (TextView) this.ykT.findViewById(R.id.b05);
        this.zPG = (TextView) this.ykT.findViewById(R.id.b06);
        this.zPH = (TextView) this.ykT.findViewById(R.id.b0b);
        this.tc = (EditText) this.ykT.findViewById(R.id.b09);
        this.aaY = (CheckBox) this.ykT.findViewById(R.id.d8z);
        this.zPI = (ImageView) this.ykT.findViewById(R.id.b04);
        this.zPK = (LinearLayout) this.ykT.findViewById(R.id.d8r);
        this.zPL = (ViewStub) this.ykT.findViewById(R.id.d8u);
        this.ykW = (LinearLayout) this.ykT.findViewById(R.id.c6c);
        this.zPM = (ViewGroup) this.ykT.findViewById(R.id.d90);
        this.zPO = this.ykT.findViewById(R.id.d91);
        this.ykX = (LinearLayout) this.ykT.findViewById(R.id.d8y);
        this.zPN = (ViewGroup) this.ykT.findViewById(R.id.d8v);
        setCanceledOnTouchOutside(true);
        this.zPQ = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.zPR = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.zPS = AnimationUtils.loadAnimation(this.mContext, R.anim.o);
        this.zPT = AnimationUtils.loadAnimation(this.mContext, R.anim.o);
        AppMethodBeat.o(112622);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112623);
        super.onCreate(bundle);
        setContentView(this.ykT);
        AppMethodBeat.o(112623);
    }

    public View getContentView() {
        return this.ykT;
    }

    public void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(112624);
        this.zPK.setVisibility(0);
        this.jao.setVisibility(0);
        if (this.zPU != null) {
            charSequence = this.zPU.a(charSequence.toString(), this.jao.getTextSize());
        }
        this.jao.setMaxLines(2);
        this.jao.setText(charSequence);
        this.jao.getPaint().setFakeBoldText(true);
        dxO();
        AppMethodBeat.o(112624);
    }

    public void setTitle(int i) {
        AppMethodBeat.i(112625);
        this.zPK.setVisibility(0);
        this.jao.setVisibility(0);
        this.jao.setMaxLines(2);
        this.jao.setText(i);
        this.jao.getPaint().setFakeBoldText(true);
        dxO();
        AppMethodBeat.o(112625);
    }

    private void dxO() {
        AppMethodBeat.i(112626);
        if (this.ykU != null) {
            this.ykU.setTextColor(this.ykU.getContext().getResources().getColor(R.color.ma));
        }
        AppMethodBeat.o(112626);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(112627);
        this.ykW.setVisibility(0);
        this.ykU.setVisibility(0);
        if (this.zPU != null) {
            d dVar = this.zPU;
            this.ykU.getContext();
            charSequence = dVar.a(charSequence.toString(), this.ykU.getTextSize());
        }
        this.ykU.setText(charSequence);
        AppMethodBeat.o(112627);
    }

    private void qY(boolean z) {
        AppMethodBeat.i(112628);
        if (z) {
            int fromDPToPix = aj.fromDPToPix(this.mContext, 8);
            this.ykW.setVisibility(0);
            this.ykW.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.ykW.setBackgroundResource(R.drawable.ll);
        }
        AppMethodBeat.o(112628);
    }

    public final String dKV() {
        AppMethodBeat.i(112629);
        if (this.tc == null) {
            AppMethodBeat.o(112629);
            return null;
        }
        String obj = this.tc.getText().toString();
        AppMethodBeat.o(112629);
        return obj;
    }

    public final int dKW() {
        AppMethodBeat.i(112630);
        if (this.tc instanceof PasterEditText) {
            int pasterLen = ((PasterEditText) this.tc).getPasterLen();
            AppMethodBeat.o(112630);
            return pasterLen;
        }
        AppMethodBeat.o(112630);
        return 0;
    }

    private void PS(int i) {
        AppMethodBeat.i(112631);
        if (this.ykW != null) {
            this.ykW.setVisibility(i);
        }
        if (this.ykX != null) {
            this.ykX.setVisibility(i);
        }
        if (this.zPH != null && this.zPP) {
            this.zPH.setVisibility(i);
        }
        if (this.tc != null) {
            if (this.needEdit) {
                this.tc.setVisibility(i);
            } else {
                this.tc.setVisibility(8);
                AppMethodBeat.o(112631);
                return;
            }
        }
        AppMethodBeat.o(112631);
    }

    private void ao(View view, int i) {
        AppMethodBeat.i(112632);
        this.sQ = view;
        if (this.sQ != null) {
            this.ykW.setVisibility(0);
            this.ykX.setVisibility(0);
            this.ykX.removeAllViews();
            this.ykX.setGravity(1);
            this.ykX.addView(this.sQ, new LayoutParams(i, i));
        }
        AppMethodBeat.o(112632);
    }

    public final void a(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        AppMethodBeat.i(112633);
        if (this.tJz == null) {
            AppMethodBeat.o(112633);
            return;
        }
        this.tJz.setVisibility(0);
        this.tJz.setText(charSequence);
        this.tJz.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112608);
                if (onClickListener != null) {
                    onClickListener.onClick(c.this, -1);
                }
                if (z) {
                    c.this.dismiss();
                }
                AppMethodBeat.o(112608);
            }
        });
        AppMethodBeat.o(112633);
    }

    public final void PT(int i) {
        AppMethodBeat.i(112634);
        this.tJz.setTextColor(i);
        AppMethodBeat.o(112634);
    }

    public final void PU(int i) {
        AppMethodBeat.i(112635);
        this.lWE.setTextColor(i);
        AppMethodBeat.o(112635);
    }

    public final void a(int i, OnClickListener onClickListener) {
        AppMethodBeat.i(112636);
        a(this.mContext.getString(i), true, onClickListener);
        AppMethodBeat.o(112636);
    }

    public final void b(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        AppMethodBeat.i(112637);
        if (this.lWE == null) {
            AppMethodBeat.o(112637);
            return;
        }
        this.lWE.setVisibility(0);
        this.lWE.setText(charSequence);
        this.lWE.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112609);
                if (onClickListener != null) {
                    onClickListener.onClick(c.this, -2);
                }
                if (z) {
                    c.this.cancel();
                }
                AppMethodBeat.o(112609);
            }
        });
        AppMethodBeat.o(112637);
    }

    public final void b(int i, OnClickListener onClickListener) {
        AppMethodBeat.i(112638);
        b(this.mContext.getString(i), true, onClickListener);
        AppMethodBeat.o(112638);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(112639);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.o(112639);
    }

    public final void qZ(boolean z) {
        AppMethodBeat.i(112640);
        super.setCancelable(z);
        AppMethodBeat.o(112640);
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

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(112641);
        this.zPO.setVisibility(8);
        this.zPM.removeAllViews();
        this.zPM.addView(view, layoutParams);
        AppMethodBeat.o(112641);
    }

    public final void a(a aVar) {
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        ImageView imageView;
        TextView textView;
        AppMethodBeat.i(112642);
        if (aVar.title != null && aVar.title.length() > 0) {
            i = aVar.yCn;
            if (this.jao != null) {
                this.jao.setGravity(i);
            }
            setTitle(aVar.title);
        }
        if (aVar.zOM != null && aVar.zOM.length() > 0) {
            charSequence = aVar.zOM;
            this.zPK.setVisibility(0);
            this.zPF.setVisibility(0);
            if (this.zPU != null) {
                charSequence = this.zPU.a(charSequence.toString(), this.jao.getTextSize());
            }
            this.zPF.setText(charSequence);
        }
        if (aVar.vfK != 0) {
            this.jao.setTextColor(ColorStateList.valueOf(aVar.vfK));
        }
        if (aVar.zPu != 0) {
            this.jao.setMaxLines(aVar.zPu);
        }
        if (aVar.zPv != 0) {
            this.ykU.setMaxLines(aVar.zPv);
        }
        if (aVar.uvN != null) {
            ao(aVar.uvN, -1);
        }
        if (aVar.zPs != null) {
            LinearLayout linearLayout;
            View view = aVar.zPs;
            this.zPK.setVisibility(0);
            this.zPL.setLayoutResource(R.layout.ph);
            try {
                linearLayout = (LinearLayout) this.zPL.inflate();
            } catch (Exception e) {
                this.zPL.setVisibility(0);
                linearLayout = null;
            }
            linearLayout.addView(view);
        }
        if (aVar.zPt != null) {
            this.zPJ = aVar.zPt;
            if (this.zPJ != null) {
                this.ykW.setVisibility(8);
                this.zPH.setVisibility(8);
                this.tc.setVisibility(8);
                this.zPN.removeAllViews();
                this.zPN.addView(this.zPJ, new LayoutParams(-1, -1));
                this.zPN.setVisibility(8);
            }
        }
        if (aVar.zOZ != null) {
            Drawable drawable = aVar.zOZ;
            if (this.sQ == null) {
                this.ykW.setVisibility(0);
                this.zPI.setVisibility(0);
                this.zPI.setBackgroundDrawable(drawable);
            }
        }
        if (aVar.zPc != null && aVar.zPc.length() > 0) {
            setMessage(aVar.zPc);
        }
        qY(aVar.zPl);
        if (aVar.thumbPath != null) {
            String str = aVar.thumbPath;
            int fromDPToPix = aj.fromDPToPix(this.mContext, 120);
            this.ykW.setVisibility(0);
            this.zPI.setVisibility(0);
            if (this.zPI instanceof com.tencent.mm.ui.e.a) {
                ((com.tencent.mm.ui.e.a) this.zPI).am(str, fromDPToPix, fromDPToPix);
            }
            i = aVar.zPy;
            this.ykW.setVisibility(i);
            this.zPI.setVisibility(i);
        }
        if (!(aVar.zPC || aVar.zPD)) {
            if (aVar.zPc != null && aVar.zPc.length() > 0) {
                setMessage(aVar.zPc);
            }
            if (aVar.zPd == null || aVar.zPd.length() <= 0) {
                qY(false);
            } else {
                charSequence = aVar.zPd;
                this.ykW.setVisibility(0);
                this.ykV.setVisibility(0);
                this.ykV.setMaxLines(2);
                this.ykV.setText(charSequence);
            }
            if (aVar.zPe != null && aVar.zPe.length() > 0) {
                charSequence = aVar.zPe;
                if (charSequence != null) {
                    this.ykW.setVisibility(0);
                    this.zPG.setVisibility(0);
                    if (this.zPU != null) {
                        d dVar = this.zPU;
                        this.zPG.getContext();
                        charSequence = dVar.a(charSequence.toString(), this.zPG.getTextSize());
                    }
                    this.zPG.setText(charSequence);
                }
            }
            if (aVar.zPa != null) {
                Bitmap bitmap = aVar.zPa;
                if (this.sQ == null) {
                    this.ykW.setVisibility(0);
                    this.zPI.setVisibility(0);
                    this.zPI.setImageBitmap(bitmap);
                }
            }
        }
        Bitmap bitmap2;
        CharSequence charSequence3;
        View inflate;
        if (aVar.zPC) {
            bitmap2 = aVar.zPa;
            charSequence2 = aVar.zPd;
            charSequence3 = aVar.zPe;
            inflate = View.inflate(this.mContext, R.layout.pk, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(R.id.b04);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(R.id.b05);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(R.id.b06);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            ao(inflate, -1);
        } else if (aVar.zPD) {
            bitmap2 = aVar.zPa;
            charSequence2 = aVar.zPd;
            charSequence3 = aVar.zPe;
            inflate = View.inflate(this.mContext, R.layout.pl, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(R.id.b04);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(R.id.b05);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(R.id.b06);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            ao(inflate, -1);
        }
        if (!(aVar.zOR == null && aVar.zOS == null)) {
            String str2 = aVar.zOR;
            charSequence2 = aVar.zOS;
            Boolean valueOf = Boolean.valueOf(aVar.zOT);
            final c cVar = aVar.zOV;
            a aVar2 = aVar.zOW;
            this.zPL.setLayoutResource(R.layout.pu);
            LinearLayout linearLayout2 = null;
            try {
                linearLayout2 = (LinearLayout) this.zPL.inflate();
            } catch (Exception e2) {
                this.zPL.setVisibility(0);
            }
            if (!(linearLayout2 == null || str2 == null)) {
                imageView = (ImageView) linearLayout2.findViewById(R.id.b0o);
                imageView.setVisibility(0);
                if (aVar2 != null) {
                    aVar2.u(imageView, str2);
                }
            }
            if (!(linearLayout2 == null || charSequence2 == null)) {
                textView = (TextView) linearLayout2.findViewById(R.id.b0p);
                textView.setVisibility(0);
                if (this.zPU != null) {
                    charSequence2 = this.zPU.a(charSequence2.toString(), this.jao.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (valueOf.booleanValue() && linearLayout2 != null) {
                imageView = (ImageView) linearLayout2.findViewById(R.id.b0q);
                imageView.setVisibility(0);
                PS(0);
                linearLayout2.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(112605);
                        if (cVar != null) {
                            cVar.djv();
                        }
                        if (imageView.isSelected()) {
                            c.this.zPN.startAnimation(c.this.zPT);
                            c.this.zPT.setAnimationListener(new AnimationListener() {
                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.i(112601);
                                    c.a(c.this, c.this.zPQ);
                                    AppMethodBeat.o(112601);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(112602);
                                    c.this.zPN.setVisibility(8);
                                    c.a(c.this, 0);
                                    AppMethodBeat.o(112602);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView, "rotation", new float[]{180.0f, 0.0f}).setDuration(200).start();
                            imageView.setSelected(false);
                            AppMethodBeat.o(112605);
                            return;
                        }
                        c.this.zPN.startAnimation(c.this.zPR);
                        c.this.zPR.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                                AppMethodBeat.i(112603);
                                c.a(c.this, c.this.zPS);
                                AppMethodBeat.o(112603);
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(112604);
                                c.this.zPN.setVisibility(0);
                                c.a(c.this, 8);
                                AppMethodBeat.o(112604);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 180.0f}).setDuration(200).start();
                        imageView.setSelected(true);
                        AppMethodBeat.o(112605);
                    }
                });
            }
        }
        if (aVar.zOX != null) {
            final b bVar = aVar.zOX;
            if (this.ykW != null && this.ykW.getVisibility() == 0) {
                this.ykW.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(112606);
                        if (bVar != null) {
                            bVar.bwF();
                        }
                        AppMethodBeat.o(112606);
                    }
                });
            } else if (this.ykX != null) {
                this.ykX.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(112607);
                        if (bVar != null) {
                            bVar.bwF();
                        }
                        AppMethodBeat.o(112607);
                    }
                });
            }
        }
        if (!(aVar.zPb == null || aVar.zPb.isRecycled())) {
            Bitmap bitmap3 = aVar.zPb;
            boolean z = aVar.zPm;
            int i2 = aVar.zPx;
            if (bitmap3 != null) {
                Bitmap bitmap4;
                qY(false);
                this.ykW.setVisibility(0);
                this.ykW.setGravity(1);
                this.ykW.setPadding(0, 0, 0, 0);
                View inflate2 = View.inflate(this.mContext, R.layout.pm, null);
                imageView = (ImageView) inflate2.findViewById(R.id.b04);
                if (z) {
                    bitmap4 = null;
                    float height = ((float) bitmap3.getHeight()) / ((float) bitmap3.getWidth());
                    int i3 = 0;
                    int i4 = 0;
                    int am = aj.am(this.mContext, R.dimen.fl);
                    int am2 = aj.am(this.mContext, R.dimen.fk);
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
                    bitmap4 = ag.d(bitmap4, (float) aj.fromDPToPix(this.mContext, 3));
                } else {
                    bitmap4 = bitmap3;
                }
                imageView.setImageBitmap(bitmap4);
                imageView = (ImageView) inflate2.findViewById(R.id.b07);
                if (i2 == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    if (i2 == 1) {
                        imageView.setImageResource(R.raw.sight_icon_in_gird);
                    } else if (i2 == 2) {
                        imageView.setImageResource(R.raw.video_icon_in_gird);
                    }
                }
                ao(inflate2, -2);
            }
        }
        if (aVar.zON != null && aVar.zON.length() > 0) {
            charSequence = aVar.zON;
            if (charSequence != null) {
                this.zPH.setVisibility(0);
                this.zPH.setText(charSequence);
            }
            this.zPP = true;
            i = aVar.zPw;
            if (this.zPH != null) {
                this.zPH.setGravity(i);
            }
        }
        if (aVar.zOO != null && aVar.zOO.length() > 0) {
            charSequence = aVar.zOO;
            this.tc.setVisibility(0);
            this.tc.setHint(charSequence);
        }
        if (aVar.zOP != null && aVar.zOP.length() > 0) {
            charSequence = aVar.zOP;
            this.aaY.setVisibility(0);
            this.aaY.setText(charSequence);
        }
        if (aVar.zOQ) {
            this.needEdit = aVar.zOQ;
            if (aVar.zOQ) {
                this.tc.setVisibility(0);
            } else {
                this.tc.setVisibility(8);
            }
        }
        if (aVar.zPf != null && aVar.zPf.length() > 0) {
            a(aVar.zPf, aVar.zPB, aVar.zPn);
        }
        if (aVar.zPg != null && aVar.zPg.length() > 0) {
            b(aVar.zPg, true, aVar.zPo);
        }
        if (aVar.zPA != 0) {
            PT(aVar.zPA);
        }
        if (aVar.zPz != 0) {
            PU(aVar.zPz);
        }
        if (aVar.Ue != null) {
            setOnCancelListener(aVar.Ue);
        }
        if (aVar.Uf != null) {
            this.zPV = aVar.Uf;
            setOnDismissListener(aVar.Uf);
        }
        if (aVar.zOY != null) {
            this.zPU = aVar.zOY;
        }
        setCancelable(aVar.gHY);
        this.gHY = aVar.gHY;
        if (!this.gHY) {
            super.setCancelable(aVar.zPk);
        }
        if (!(aVar.zPh == null && aVar.zPi == null && aVar.zPj == null)) {
            final a aVar3;
            View inflate3 = View.inflate(this.mContext, R.layout.pt, null);
            Button button = (Button) inflate3.findViewById(R.id.b0l);
            Button button2 = (Button) inflate3.findViewById(R.id.b0m);
            Button button3 = (Button) inflate3.findViewById(R.id.b0n);
            if (aVar.zPh != null) {
                button.setVisibility(0);
                button.setText(aVar.zPh);
                aVar3 = aVar;
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(112610);
                        if (aVar3.zPp != null) {
                            aVar3.zPp.onClick(c.this, -1);
                        }
                        c.this.dismiss();
                        AppMethodBeat.o(112610);
                    }
                });
            }
            if (aVar.zPi != null) {
                button2.setVisibility(0);
                button2.setText(aVar.zPi);
                aVar3 = aVar;
                button2.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(112611);
                        if (aVar3.zPq != null) {
                            aVar3.zPq.onClick(c.this, -2);
                        }
                        c.this.dismiss();
                        AppMethodBeat.o(112611);
                    }
                });
            }
            if (aVar.zPj != null) {
                button3.setVisibility(0);
                button3.setText(aVar.zPj);
                aVar3 = aVar;
                button3.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(112612);
                        if (aVar3.zPr != null) {
                            aVar3.zPr.onClick(c.this, -3);
                        }
                        c.this.dismiss();
                        AppMethodBeat.o(112612);
                    }
                });
            }
            a(inflate3, new LayoutParams(-1, -1));
        }
        if (aVar.zOU) {
            View inflate4 = View.inflate(this.mContext, R.layout.pg, null);
            this.lWE = (Button) inflate4.findViewById(R.id.azz);
            this.tJz = (Button) inflate4.findViewById(R.id.b00);
            if (aVar.zPA != 0) {
                PT(aVar.zPA);
            }
            if (aVar.zPz != 0) {
                PU(aVar.zPz);
            }
            if (aVar.zPf != null && aVar.zPf.length() > 0) {
                a(aVar.zPf, aVar.zPB, aVar.zPn);
            }
            if (aVar.zPg != null && aVar.zPg.length() > 0) {
                b(aVar.zPg, true, aVar.zPo);
            }
            a(inflate4, new LayoutParams(-1, -1));
        }
        AppMethodBeat.o(112642);
    }

    public void show() {
        AppMethodBeat.i(112643);
        try {
            super.show();
            AppMethodBeat.o(112643);
        } catch (Exception e) {
            ai.printErrStackTrace("MicroMsg.MMAlertDialog", e, "", new Object[0]);
            AppMethodBeat.o(112643);
        }
    }

    public void dismiss() {
        AppMethodBeat.i(112644);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(112613);
                    c.this.dismiss();
                    AppMethodBeat.o(112613);
                }
            });
            ai.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
            AppMethodBeat.o(112644);
            return;
        }
        try {
            super.dismiss();
            AppMethodBeat.o(112644);
        } catch (Exception e) {
            ai.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + e.getMessage(), new Object[0]);
            AppMethodBeat.o(112644);
        }
    }
}
