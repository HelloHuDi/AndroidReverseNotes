package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x extends i {
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
    private OnClickListener krr = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(88784);
            if (view.getTag() instanceof r) {
                b bcv = x.this.kqK.bcv();
                x.this.kqK.bcx();
                r rVar = (r) view.getTag();
                if (rVar == null) {
                    AppMethodBeat.o(88784);
                    return;
                } else if (rVar.kfV == null || rVar.kfV.isEmpty()) {
                    AppMethodBeat.o(88784);
                    return;
                } else if (rVar.kfT != null && rVar.kfT.equals(bcv.bab())) {
                    x.this.krp.setVisibility(8);
                    x.this.kqK.bbB();
                    AppMethodBeat.o(88784);
                    return;
                } else if (TextUtils.isEmpty(rVar.kfT) && TextUtils.isEmpty(bcv.bab())) {
                    x.this.krp.setVisibility(8);
                    x.this.kqK.bbB();
                    AppMethodBeat.o(88784);
                    return;
                } else {
                    boolean z;
                    ArrayList GD = com.tencent.mm.plugin.card.sharecard.a.b.GD(rVar.kbU);
                    if (GD == null || GD.size() <= 0) {
                        z = false;
                    } else {
                        z = false;
                        for (int i = 0; i < GD.size(); i++) {
                            r rVar2 = (r) GD.get(i);
                            if ((rVar2.kfT == null || !rVar2.kfT.equals(rVar.kfT)) && !(TextUtils.isEmpty(rVar2.kfT) && TextUtils.isEmpty(rVar.kfT))) {
                                rVar2.kfW = false;
                                GD.set(i, rVar2);
                            } else {
                                rVar2.kfW = true;
                                if (!rVar2.kfX) {
                                    rVar2.kfX = true;
                                    z = true;
                                }
                                GD.set(i, rVar2);
                            }
                        }
                    }
                    ShareCardInfo GK = am.bbe().GK((String) rVar.kfV.get(0));
                    if (GK != null) {
                        x.this.kqK.b(GK);
                    }
                    if (z && x.this.kqK.bcB() != null) {
                        x.this.kqK.bcB().bco();
                    }
                    x.this.krp.setVisibility(8);
                    AppMethodBeat.o(88784);
                    return;
                }
            }
            AppMethodBeat.o(88784);
        }
    };

    public x() {
        AppMethodBeat.i(88785);
        AppMethodBeat.o(88785);
    }

    public final void initView() {
        AppMethodBeat.i(88786);
        this.krj = findViewById(R.id.abr);
        this.krk = findViewById(R.id.ajh);
        this.krl = (ImageView) findViewById(R.id.ajj);
        this.krm = (TextView) findViewById(R.id.ajk);
        this.krn = (TextView) findViewById(R.id.ajl);
        this.kro = (ImageView) findViewById(R.id.ajm);
        this.krj.setVisibility(8);
        this.krp = findViewById(R.id.ajn);
        this.krq = (LinearLayout) findViewById(R.id.ajo);
        this.krp.setVisibility(8);
        this.jiE = this.kqK.bcy();
        AppMethodBeat.o(88786);
    }

    public final void bes() {
        AppMethodBeat.i(88788);
        this.krj.setVisibility(8);
        AppMethodBeat.o(88788);
    }

    public final void update() {
        AppMethodBeat.i(88787);
        b bcv = this.kqK.bcv();
        ArrayList GD = com.tencent.mm.plugin.card.sharecard.a.b.GD(bcv.baa());
        g bcA = this.kqK.bcA();
        CharSequence charSequence;
        if (bcA.bdO()) {
            String str;
            this.krj.setVisibility(0);
            if (com.tencent.mm.plugin.card.sharecard.a.b.GC(bcv.baa()) > 1) {
                this.krk.setOnClickListener(this.kqK.bcz());
            } else {
                this.kro.setVisibility(8);
                this.krp.setVisibility(8);
                this.krq.removeAllViews();
                this.kqK.bcx();
            }
            b bcv2 = this.kqK.bcv();
            if (this.kqK.bcw()) {
                this.krl.setVisibility(8);
                this.krm.setVisibility(8);
                this.krn.setVisibility(0);
                this.kro.setImageResource(R.drawable.azk);
                this.krn.setText(this.jiE.getString(R.string.ahc));
            } else {
                this.krl.setVisibility(0);
                this.krm.setVisibility(0);
                this.krn.setVisibility(8);
                if (com.tencent.mm.plugin.card.sharecard.a.b.GC(bcv2.baa()) <= 1) {
                    this.kro.setVisibility(8);
                } else {
                    this.kro.setVisibility(0);
                    this.kro.setImageResource(R.drawable.azj);
                }
                str = "";
                if (GD != null && GD.size() > 0) {
                    for (int i = 0; i < GD.size(); i++) {
                        r rVar = (r) GD.get(i);
                        if (rVar.kfW) {
                            charSequence = rVar.kfT;
                            break;
                        }
                    }
                }
                Object charSequence2 = str;
                if (TextUtils.isEmpty(charSequence2) && !TextUtils.isEmpty(bcv2.bab())) {
                    charSequence2 = bcv2.bab();
                }
                if (!TextUtils.isEmpty(charSequence2)) {
                    a.b.b(this.krl, charSequence2);
                    this.krm.setText(j.f(this.jiE, this.jiE.getString(R.string.ahh, new Object[]{l.Hp(charSequence2)}), this.jiE.getResources().getDimensionPixelOffset(R.dimen.m5)));
                }
            }
            if (this.kqK.bcw()) {
                this.krp.setVisibility(0);
                r rVar2;
                ImageView imageView;
                if (this.krq.getChildCount() != 0 || GD == null) {
                    for (int i2 = 0; i2 < this.krq.getChildCount(); i2++) {
                        View childAt = this.krq.getChildAt(i2);
                        if (GD == null || GD.size() < this.krq.getChildCount()) {
                            rVar2 = null;
                        } else {
                            rVar2 = (r) GD.get(i2);
                        }
                        ImageView imageView2 = (ImageView) childAt.findViewById(R.id.ed5);
                        imageView = (ImageView) childAt.findViewById(R.id.ed4);
                        if (rVar2 == null || !rVar2.kfW) {
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
                        rVar2 = (r) it.next();
                        View inflate = layoutInflater.inflate(R.layout.asp, this.krq, false);
                        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.ed3);
                        TextView textView = (TextView) inflate.findViewById(R.id.c5a);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.ed6);
                        if (!TextUtils.isEmpty(rVar2.kfT)) {
                            a.b.b(imageView3, rVar2.kfT);
                            str = l.Hp(rVar2.kfT);
                            if (TextUtils.isEmpty(str)) {
                                textView.setText("");
                            } else {
                                textView.setText(j.f(this.jiE, str, this.jiE.getResources().getDimensionPixelOffset(R.dimen.nk)));
                            }
                        }
                        textView2.setText("x " + rVar2.kfU);
                        inflate.setTag(rVar2);
                        inflate.setOnClickListener(this.krr);
                        imageView = (ImageView) inflate.findViewById(R.id.ed5);
                        imageView3 = (ImageView) inflate.findViewById(R.id.ed4);
                        if (rVar2.kfW) {
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
            AppMethodBeat.o(88787);
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
                a.b.b(this.krl, charSequence2);
                this.krm.setText(j.f(this.jiE, this.jiE.getString(R.string.ahh, new Object[]{l.Hp(charSequence2)}), this.jiE.getResources().getDimensionPixelOffset(R.dimen.m5)));
            }
            this.kri = true;
        }
        AppMethodBeat.o(88787);
    }
}
