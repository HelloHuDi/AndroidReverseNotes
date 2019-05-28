package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    ArrayList<q> pGL = null;
    a pGM = null;
    private List<String> pGN = new ArrayList(bo.hT((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_PHONE_RECHARGE_RECOMMENDED_LIST_STRING_SYNC, (Object) ""), ","));

    public interface a {
        void a(q qVar);
    }

    class b {
        TextView gtb;
        TextView hrg;
        TextView pGR;
        ImageView pGS;

        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }
    }

    public b() {
        AppMethodBeat.i(44248);
        AppMethodBeat.o(44248);
    }

    public final int getCount() {
        AppMethodBeat.i(44249);
        if (this.pGL == null) {
            AppMethodBeat.o(44249);
            return 0;
        }
        int size = this.pGL.size();
        AppMethodBeat.o(44249);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(44250);
        Object obj = this.pGL.get(i);
        AppMethodBeat.o(44250);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(44251);
        final q qVar = (q) getItem(i);
        if (view == null) {
            view = v.hu(viewGroup.getContext()).inflate(R.layout.anj, viewGroup, false);
            b bVar2 = new b(this, (byte) 0);
            bVar2.hrg = (TextView) view.findViewById(R.id.o7);
            bVar2.gtb = (TextView) view.findViewById(R.id.eg);
            bVar2.pGR = (TextView) view.findViewById(R.id.dwo);
            bVar2.pGS = (ImageView) view.findViewById(R.id.dwn);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.gtb.setText(qVar.name);
        if (bo.isNullOrNil(qVar.desc)) {
            bVar.hrg.setVisibility(8);
        } else {
            bVar.hrg.setVisibility(0);
            bVar.hrg.setText(qVar.desc);
        }
        if (bo.isNullOrNil(qVar.tnu)) {
            bVar.pGR.setVisibility(8);
        } else {
            bVar.pGR.setVisibility(0);
            bVar.pGR.setText(qVar.tnu);
        }
        if (qVar.status == 1) {
            view.setEnabled(true);
            bVar.hrg.setEnabled(true);
            bVar.gtb.setEnabled(true);
        } else {
            view.setEnabled(false);
            bVar.hrg.setEnabled(false);
            bVar.gtb.setEnabled(false);
        }
        if (qVar.tny == 1 && !this.pGN.contains(qVar.tnz)) {
            ab.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", qVar.tnz);
            bVar.pGS.setVisibility(0);
        }
        if (qVar.type == 1 && qVar.tnv.equals("1") && !qVar.tnw.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Context context = viewGroup.getContext();
            int parseColor = Color.parseColor(qVar.tnw);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) com.tencent.mm.bz.a.fromDPToPix(context, 2));
            gradientDrawable.setColor(parseColor);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) com.tencent.mm.bz.a.fromDPToPix(context, 2));
            gradientDrawable2.setStroke(2, com.tencent.mm.bz.a.i(context, R.color.xq));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) com.tencent.mm.bz.a.fromDPToPix(context, 2));
            gradientDrawable3.setColor(com.tencent.mm.bz.a.i(context, R.color.xo));
            gradientDrawable3.setStroke(2, parseColor);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            Context context2 = viewGroup.getContext();
            int parseColor2 = Color.parseColor(qVar.tnw);
            r6 = new int[3][];
            r6[0] = new int[]{16842919};
            r6[1] = new int[]{-16842910};
            r6[2] = new int[0];
            ColorStateList colorStateList = new ColorStateList(r6, new int[]{com.tencent.mm.bz.a.i(context2, R.color.a69), com.tencent.mm.bz.a.i(context2, R.color.xm), parseColor2});
            bVar.hrg.setTextColor(colorStateList);
            bVar.gtb.setTextColor(colorStateList);
            view.setBackground(stateListDrawable);
        }
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44247);
                if (b.this.pGM != null) {
                    if (!b.this.pGN.contains(qVar.tnz)) {
                        ab.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", qVar.tnz);
                        b.this.pGN.add(qVar.tnz);
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_PHONE_RECHARGE_RECOMMENDED_LIST_STRING_SYNC, bo.c(b.this.pGN, ","));
                        bVar.pGS.setVisibility(8);
                    }
                    b.this.pGM.a(qVar);
                }
                AppMethodBeat.o(44247);
            }
        });
        AppMethodBeat.o(44251);
        return view;
    }
}
