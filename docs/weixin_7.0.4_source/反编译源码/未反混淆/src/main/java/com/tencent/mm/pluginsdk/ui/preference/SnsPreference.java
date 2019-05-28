package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.no;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference extends Preference implements g {
    private MMActivity crP;
    private int lXY;
    private List<bau> list;
    private String mTitle;
    private View omq;
    private az qFT;
    private QDisFadeImageView vro;
    private QDisFadeImageView vrp;
    private QDisFadeImageView vrq;
    private QDisFadeImageView vrr;
    private ImageView vrs;
    private ImageView vrt;
    private ImageView vru;
    private ImageView vrv;
    private a vrw;

    static class a extends ColorDrawable {
        public a() {
            super(-7829368);
        }
    }

    public SnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(28117);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(28117);
    }

    public SnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(28118);
        this.mTitle = "";
        this.vro = null;
        this.vrp = null;
        this.vrq = null;
        this.vrr = null;
        this.vrs = null;
        this.vrt = null;
        this.vru = null;
        this.vrv = null;
        this.lXY = 255;
        this.list = new LinkedList();
        this.vrw = new a();
        this.crP = (MMActivity) context;
        this.mTitle = context.getString(R.string.b0b);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(28118);
    }

    private void dld() {
        ImageView imageView;
        int i = 0;
        AppMethodBeat.i(28119);
        if (this.vro != null) {
            this.vro.setImageResource(R.color.a69);
            this.vro.setVisibility(4);
        }
        if (this.vrp != null) {
            this.vrp.setImageResource(R.color.a69);
            this.vrp.setVisibility(4);
        }
        if (this.vrq != null) {
            this.vrq.setImageResource(R.color.a69);
            this.vrq.setVisibility(4);
        }
        if (this.vrr != null) {
            this.vrr.setImageResource(R.color.a69);
            this.vrr.setVisibility(4);
        }
        if (this.vro != null && this.list.size() > 0) {
            int i2;
            ImageView imageView2;
            this.vro.setVisibility(0);
            if (f.Mn()) {
                n.qFx.b((bau) this.list.get(0), this.vro, this.crP.hashCode(), this.qFT);
                imageView = this.vrs;
                if (((bau) this.list.get(0)).jCt == 6) {
                    i2 = 0;
                    imageView.setVisibility(i2);
                } else {
                    imageView2 = imageView;
                }
            } else {
                this.vro.setImageResource(R.drawable.ak9);
                imageView2 = this.vrs;
            }
            i2 = 8;
            imageView = imageView2;
            imageView.setVisibility(i2);
        }
        if (this.vrp != null && this.list.size() >= 2) {
            this.vrp.setVisibility(0);
            if (f.Mn()) {
                n.qFx.b((bau) this.list.get(1), this.vrp, this.crP.hashCode(), this.qFT);
                this.vrt.setVisibility(((bau) this.list.get(1)).jCt == 6 ? 0 : 8);
            } else {
                this.vrp.setImageResource(R.drawable.ak9);
            }
        }
        if (this.vrq != null && this.list.size() >= 3) {
            this.vrq.setVisibility(0);
            if (f.Mn()) {
                n.qFx.b((bau) this.list.get(2), this.vrq, this.crP.hashCode(), this.qFT);
                this.vru.setVisibility(((bau) this.list.get(2)).jCt == 6 ? 0 : 8);
            } else {
                this.vrq.setImageResource(R.drawable.ak9);
            }
        }
        if (this.vrr != null && this.list.size() >= 4) {
            this.vrr.setVisibility(0);
            if (f.Mn()) {
                n.qFx.b((bau) this.list.get(3), this.vrr, this.crP.hashCode(), this.qFT);
                imageView = this.vrv;
                if (((bau) this.list.get(3)).jCt != 6) {
                    i = 8;
                }
                imageView.setVisibility(i);
            } else {
                this.vrr.setImageResource(R.drawable.ak9);
                AppMethodBeat.o(28119);
                return;
            }
        }
        AppMethodBeat.o(28119);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28120);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            layoutInflater.inflate(R.layout.aek, viewGroup2);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.o(28120);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28121);
        super.onBindView(view);
        this.vro = (QDisFadeImageView) view.findViewById(R.id.d_5);
        this.vro.setAlpha(this.lXY);
        this.vro.setImageDrawable(this.vrw);
        this.vrp = (QDisFadeImageView) view.findViewById(R.id.d_7);
        this.vrp.setAlpha(this.lXY);
        this.vrp.setImageDrawable(this.vrw);
        this.vrq = (QDisFadeImageView) view.findViewById(R.id.d_9);
        this.vrq.setAlpha(this.lXY);
        this.vrq.setImageDrawable(this.vrw);
        this.vrr = (QDisFadeImageView) view.findViewById(R.id.d_a);
        this.vrr.setAlpha(this.lXY);
        this.vrr.setImageDrawable(this.vrw);
        TextView textView = (TextView) view.findViewById(R.id.d9v);
        if (!bo.isNullOrNil(this.mTitle)) {
            textView.setText(this.mTitle);
            LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = com.tencent.mm.bz.a.al(this.mContext, R.dimen.i8);
            textView.setLayoutParams(layoutParams);
        }
        this.vrs = (ImageView) view.findViewById(R.id.d_6);
        this.vrt = (ImageView) view.findViewById(R.id.d_8);
        this.vru = (ImageView) view.findViewById(R.id.d__);
        this.vrv = (ImageView) view.findViewById(R.id.d_b);
        this.vrs.setVisibility(8);
        this.vrt.setVisibility(8);
        this.vru.setVisibility(8);
        this.vrv.setVisibility(8);
        dld();
        if (view == null || this.list == null) {
            AppMethodBeat.o(28121);
            return;
        }
        view.setContentDescription(this.mContext.getString(R.string.deu, new Object[]{Integer.valueOf(this.list.size())}));
        AppMethodBeat.o(28121);
    }

    public final void ajO(String str) {
        AppMethodBeat.i(28122);
        if (str == null) {
            AppMethodBeat.o(28122);
            return;
        }
        this.list.clear();
        aw.ZK();
        ad aoO = c.XM().aoO(str);
        if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
            this.qFT = az.xYQ;
        } else if (str.equals(r.Yz())) {
            this.qFT = az.xYQ;
        } else {
            this.qFT = az.xYR;
        }
        no noVar = new no();
        noVar.cJO.username = str;
        com.tencent.mm.sdk.b.a.xxA.m(noVar);
        if (noVar.cJP.cJQ != null) {
            this.list.add(noVar.cJP.cJQ);
        }
        if (noVar.cJP.cJR != null) {
            this.list.add(noVar.cJP.cJR);
        }
        if (noVar.cJP.cJS != null) {
            this.list.add(noVar.cJP.cJS);
        }
        if (noVar.cJP.cJT != null) {
            this.list.add(noVar.cJP.cJT);
        }
        dld();
        AppMethodBeat.o(28122);
    }
}
