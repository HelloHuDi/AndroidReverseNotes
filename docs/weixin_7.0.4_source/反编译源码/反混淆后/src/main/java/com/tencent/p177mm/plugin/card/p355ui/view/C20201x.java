package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C42867g;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.sharecard.model.C11296r;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.card.ui.view.x */
public final class C20201x extends C45800i {
    MMActivity jiE;
    private boolean kri = false;
    private View krj;
    private View krk;
    private ImageView krl;
    private TextView krm;
    private TextView krn;
    private ImageView kro;
    View krp;
    private LinearLayout krq;
    private OnClickListener krr = new C202021();

    /* renamed from: com.tencent.mm.plugin.card.ui.view.x$1 */
    class C202021 implements OnClickListener {
        C202021() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88784);
            if (view.getTag() instanceof C11296r) {
                C42837b bcv = C20201x.this.kqK.bcv();
                C20201x.this.kqK.bcx();
                C11296r c11296r = (C11296r) view.getTag();
                if (c11296r == null) {
                    AppMethodBeat.m2505o(88784);
                    return;
                } else if (c11296r.kfV == null || c11296r.kfV.isEmpty()) {
                    AppMethodBeat.m2505o(88784);
                    return;
                } else if (c11296r.kfT != null && c11296r.kfT.equals(bcv.bab())) {
                    C20201x.this.krp.setVisibility(8);
                    C20201x.this.kqK.bbB();
                    AppMethodBeat.m2505o(88784);
                    return;
                } else if (TextUtils.isEmpty(c11296r.kfT) && TextUtils.isEmpty(bcv.bab())) {
                    C20201x.this.krp.setVisibility(8);
                    C20201x.this.kqK.bbB();
                    AppMethodBeat.m2505o(88784);
                    return;
                } else {
                    boolean z;
                    ArrayList GD = C42856b.m76074GD(c11296r.kbU);
                    if (GD == null || GD.size() <= 0) {
                        z = false;
                    } else {
                        z = false;
                        for (int i = 0; i < GD.size(); i++) {
                            C11296r c11296r2 = (C11296r) GD.get(i);
                            if ((c11296r2.kfT == null || !c11296r2.kfT.equals(c11296r.kfT)) && !(TextUtils.isEmpty(c11296r2.kfT) && TextUtils.isEmpty(c11296r.kfT))) {
                                c11296r2.kfW = false;
                                GD.set(i, c11296r2);
                            } else {
                                c11296r2.kfW = true;
                                if (!c11296r2.kfX) {
                                    c11296r2.kfX = true;
                                    z = true;
                                }
                                GD.set(i, c11296r2);
                            }
                        }
                    }
                    ShareCardInfo GK = C42852am.bbe().mo35397GK((String) c11296r.kfV.get(0));
                    if (GK != null) {
                        C20201x.this.kqK.mo54333b(GK);
                    }
                    if (z && C20201x.this.kqK.bcB() != null) {
                        C20201x.this.kqK.bcB().bco();
                    }
                    C20201x.this.krp.setVisibility(8);
                    AppMethodBeat.m2505o(88784);
                    return;
                }
            }
            AppMethodBeat.m2505o(88784);
        }
    }

    public C20201x() {
        AppMethodBeat.m2504i(88785);
        AppMethodBeat.m2505o(88785);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88786);
        this.krj = findViewById(2131822016);
        this.krk = findViewById(2131822302);
        this.krl = (ImageView) findViewById(2131822304);
        this.krm = (TextView) findViewById(2131822305);
        this.krn = (TextView) findViewById(2131822306);
        this.kro = (ImageView) findViewById(2131822307);
        this.krj.setVisibility(8);
        this.krp = findViewById(2131822308);
        this.krq = (LinearLayout) findViewById(2131822309);
        this.krp.setVisibility(8);
        this.jiE = this.kqK.bcy();
        AppMethodBeat.m2505o(88786);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88788);
        this.krj.setVisibility(8);
        AppMethodBeat.m2505o(88788);
    }

    public final void update() {
        AppMethodBeat.m2504i(88787);
        C42837b bcv = this.kqK.bcv();
        ArrayList GD = C42856b.m76074GD(bcv.baa());
        C42867g bcA = this.kqK.bcA();
        CharSequence charSequence;
        if (bcA.bdO()) {
            String str;
            this.krj.setVisibility(0);
            if (C42856b.m76073GC(bcv.baa()) > 1) {
                this.krk.setOnClickListener(this.kqK.bcz());
            } else {
                this.kro.setVisibility(8);
                this.krp.setVisibility(8);
                this.krq.removeAllViews();
                this.kqK.bcx();
            }
            C42837b bcv2 = this.kqK.bcv();
            if (this.kqK.bcw()) {
                this.krl.setVisibility(8);
                this.krm.setVisibility(8);
                this.krn.setVisibility(0);
                this.kro.setImageResource(C25738R.drawable.azk);
                this.krn.setText(this.jiE.getString(C25738R.string.ahc));
            } else {
                this.krl.setVisibility(0);
                this.krm.setVisibility(0);
                this.krn.setVisibility(8);
                if (C42856b.m76073GC(bcv2.baa()) <= 1) {
                    this.kro.setVisibility(8);
                } else {
                    this.kro.setVisibility(0);
                    this.kro.setImageResource(C25738R.drawable.azj);
                }
                str = "";
                if (GD != null && GD.size() > 0) {
                    for (int i = 0; i < GD.size(); i++) {
                        C11296r c11296r = (C11296r) GD.get(i);
                        if (c11296r.kfW) {
                            charSequence = c11296r.kfT;
                            break;
                        }
                    }
                }
                Object charSequence2 = str;
                if (TextUtils.isEmpty(charSequence2) && !TextUtils.isEmpty(bcv2.bab())) {
                    charSequence2 = bcv2.bab();
                }
                if (!TextUtils.isEmpty(charSequence2)) {
                    C40460b.m69434b(this.krl, charSequence2);
                    this.krm.setText(C44089j.m79305f(this.jiE, this.jiE.getString(C25738R.string.ahh, new Object[]{C38736l.m65703Hp(charSequence2)}), this.jiE.getResources().getDimensionPixelOffset(C25738R.dimen.f9980m5)));
                }
            }
            if (this.kqK.bcw()) {
                this.krp.setVisibility(0);
                C11296r c11296r2;
                ImageView imageView;
                if (this.krq.getChildCount() != 0 || GD == null) {
                    for (int i2 = 0; i2 < this.krq.getChildCount(); i2++) {
                        View childAt = this.krq.getChildAt(i2);
                        if (GD == null || GD.size() < this.krq.getChildCount()) {
                            c11296r2 = null;
                        } else {
                            c11296r2 = (C11296r) GD.get(i2);
                        }
                        ImageView imageView2 = (ImageView) childAt.findViewById(2131827541);
                        imageView = (ImageView) childAt.findViewById(2131827540);
                        if (c11296r2 == null || !c11296r2.kfW) {
                            imageView2.setVisibility(8);
                            imageView.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            imageView.setVisibility(0);
                        }
                    }
                    this.krq.invalidate();
                } else {
                    LayoutInflater layoutInflater = (LayoutInflater) this.jiE.getSystemService("layout_inflater");
                    Iterator it = GD.iterator();
                    while (it.hasNext()) {
                        c11296r2 = (C11296r) it.next();
                        View inflate = layoutInflater.inflate(2130970668, this.krq, false);
                        ImageView imageView3 = (ImageView) inflate.findViewById(2131827539);
                        TextView textView = (TextView) inflate.findViewById(2131824477);
                        TextView textView2 = (TextView) inflate.findViewById(2131827542);
                        if (!TextUtils.isEmpty(c11296r2.kfT)) {
                            C40460b.m69434b(imageView3, c11296r2.kfT);
                            str = C38736l.m65703Hp(c11296r2.kfT);
                            if (TextUtils.isEmpty(str)) {
                                textView.setText("");
                            } else {
                                textView.setText(C44089j.m79305f(this.jiE, str, this.jiE.getResources().getDimensionPixelOffset(C25738R.dimen.f10018nk)));
                            }
                        }
                        textView2.setText("x " + c11296r2.kfU);
                        inflate.setTag(c11296r2);
                        inflate.setOnClickListener(this.krr);
                        imageView = (ImageView) inflate.findViewById(2131827541);
                        imageView3 = (ImageView) inflate.findViewById(2131827540);
                        if (c11296r2.kfW) {
                            imageView.setVisibility(0);
                            imageView3.setVisibility(0);
                        } else {
                            imageView.setVisibility(8);
                            imageView3.setVisibility(8);
                        }
                        this.krq.addView(inflate);
                    }
                    this.krq.invalidate();
                }
            } else {
                this.krp.setVisibility(8);
                this.krq.removeAllViews();
            }
            this.kri = true;
            AppMethodBeat.m2505o(88787);
            return;
        }
        if (!bcA.bdO()) {
            this.krj.setVisibility(0);
            this.krl.setVisibility(0);
            this.krm.setVisibility(0);
            this.krn.setVisibility(8);
            this.kro.setVisibility(8);
            charSequence2 = "";
            if (TextUtils.isEmpty(charSequence2) && !TextUtils.isEmpty(bcv.bab())) {
                charSequence2 = bcv.bab();
            }
            if (!TextUtils.isEmpty(charSequence2)) {
                C40460b.m69434b(this.krl, charSequence2);
                this.krm.setText(C44089j.m79305f(this.jiE, this.jiE.getString(C25738R.string.ahh, new Object[]{C38736l.m65703Hp(charSequence2)}), this.jiE.getResources().getDimensionPixelOffset(C25738R.dimen.f9980m5)));
            }
            this.kri = true;
        }
        AppMethodBeat.m2505o(88787);
    }
}
