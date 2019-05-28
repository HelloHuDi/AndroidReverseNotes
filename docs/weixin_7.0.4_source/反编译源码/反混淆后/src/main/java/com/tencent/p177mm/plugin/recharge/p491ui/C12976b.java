package com.tencent.p177mm.plugin.recharge.p491ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.wallet.p748a.C29528q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.recharge.ui.b */
public final class C12976b extends BaseAdapter {
    ArrayList<C29528q> pGL = null;
    C3696a pGM = null;
    private List<String> pGN = new ArrayList(C5046bo.m7569hT((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PHONE_RECHARGE_RECOMMENDED_LIST_STRING_SYNC, (Object) ""), ","));

    /* renamed from: com.tencent.mm.plugin.recharge.ui.b$a */
    public interface C3696a {
        /* renamed from: a */
        void mo8317a(C29528q c29528q);
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.b$b */
    class C3697b {
        TextView gtb;
        TextView hrg;
        TextView pGR;
        ImageView pGS;

        private C3697b() {
        }

        /* synthetic */ C3697b(C12976b c12976b, byte b) {
            this();
        }
    }

    public C12976b() {
        AppMethodBeat.m2504i(44248);
        AppMethodBeat.m2505o(44248);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44249);
        if (this.pGL == null) {
            AppMethodBeat.m2505o(44249);
            return 0;
        }
        int size = this.pGL.size();
        AppMethodBeat.m2505o(44249);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(44250);
        Object obj = this.pGL.get(i);
        AppMethodBeat.m2505o(44250);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C3697b c3697b;
        AppMethodBeat.m2504i(44251);
        final C29528q c29528q = (C29528q) getItem(i);
        if (view == null) {
            view = C5616v.m8409hu(viewGroup.getContext()).inflate(2130970477, viewGroup, false);
            C3697b c3697b2 = new C3697b(this, (byte) 0);
            c3697b2.hrg = (TextView) view.findViewById(2131821095);
            c3697b2.gtb = (TextView) view.findViewById(2131820735);
            c3697b2.pGR = (TextView) view.findViewById(2131826895);
            c3697b2.pGS = (ImageView) view.findViewById(2131826894);
            view.setTag(c3697b2);
            c3697b = c3697b2;
        } else {
            c3697b = (C3697b) view.getTag();
        }
        c3697b.gtb.setText(c29528q.name);
        if (C5046bo.isNullOrNil(c29528q.desc)) {
            c3697b.hrg.setVisibility(8);
        } else {
            c3697b.hrg.setVisibility(0);
            c3697b.hrg.setText(c29528q.desc);
        }
        if (C5046bo.isNullOrNil(c29528q.tnu)) {
            c3697b.pGR.setVisibility(8);
        } else {
            c3697b.pGR.setVisibility(0);
            c3697b.pGR.setText(c29528q.tnu);
        }
        if (c29528q.status == 1) {
            view.setEnabled(true);
            c3697b.hrg.setEnabled(true);
            c3697b.gtb.setEnabled(true);
        } else {
            view.setEnabled(false);
            c3697b.hrg.setEnabled(false);
            c3697b.gtb.setEnabled(false);
        }
        if (c29528q.tny == 1 && !this.pGN.contains(c29528q.tnz)) {
            C4990ab.m7411d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", c29528q.tnz);
            c3697b.pGS.setVisibility(0);
        }
        if (c29528q.type == 1 && c29528q.tnv.equals("1") && !c29528q.tnw.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Context context = viewGroup.getContext();
            int parseColor = Color.parseColor(c29528q.tnw);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) C1338a.fromDPToPix(context, 2));
            gradientDrawable.setColor(parseColor);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) C1338a.fromDPToPix(context, 2));
            gradientDrawable2.setStroke(2, C1338a.m2872i(context, C25738R.color.f12258xq));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) C1338a.fromDPToPix(context, 2));
            gradientDrawable3.setColor(C1338a.m2872i(context, C25738R.color.f12256xo));
            gradientDrawable3.setStroke(2, parseColor);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            Context context2 = viewGroup.getContext();
            int parseColor2 = Color.parseColor(c29528q.tnw);
            r6 = new int[3][];
            r6[0] = new int[]{16842919};
            r6[1] = new int[]{-16842910};
            r6[2] = new int[0];
            ColorStateList colorStateList = new ColorStateList(r6, new int[]{C1338a.m2872i(context2, C25738R.color.a69), C1338a.m2872i(context2, C25738R.color.f12254xm), parseColor2});
            c3697b.hrg.setTextColor(colorStateList);
            c3697b.gtb.setTextColor(colorStateList);
            view.setBackground(stateListDrawable);
        }
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(44247);
                if (C12976b.this.pGM != null) {
                    if (!C12976b.this.pGN.contains(c29528q.tnz)) {
                        C4990ab.m7417i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", c29528q.tnz);
                        C12976b.this.pGN.add(c29528q.tnz);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PHONE_RECHARGE_RECOMMENDED_LIST_STRING_SYNC, C5046bo.m7536c(C12976b.this.pGN, ","));
                        c3697b.pGS.setVisibility(8);
                    }
                    C12976b.this.pGM.mo8317a(c29528q);
                }
                AppMethodBeat.m2505o(44247);
            }
        });
        AppMethodBeat.m2505o(44251);
        return view;
    }
}
