package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.imageview.WeImageView;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.nearlife.p1494b.C39460a;
import com.tencent.p177mm.protocal.protobuf.axw;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.b */
public final class C12711b extends C46112a {
    private String color;
    private boolean oRU = true;
    C39460a oSb;
    private C39460a oSc = new C39460a("", new axw());
    String oSd;
    private HashMap<String, Integer> oSe = new HashMap();

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.b$a */
    class C12712a {
        TextView gne;
        TextView hrg;
        TextView nDW;
        String oQU;
        C39460a oSf;
        LinearLayout oSg;
        WeImageView oSh;
        int position;
        int type;

        C12712a() {
        }
    }

    public C12711b(Context context, OnClickListener onClickListener, String str, boolean z, boolean z2, String str2) {
        super(context, onClickListener, str, z2);
        AppMethodBeat.m2504i(22949);
        this.oSc.Title = context.getString(C25738R.string.d4e);
        this.oRU = z;
        this.color = str2;
        this.oSe.put(this.oSc.oQU, Integer.valueOf(2));
        if (!z2 && z) {
            mo74047a(this.oSc, 0);
            notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(22949);
    }

    /* renamed from: fs */
    public final C39460a mo24711fs(String str, String str2) {
        int i = 1;
        AppMethodBeat.m2504i(22950);
        if (this.oSb == null) {
            this.oSb = new C39460a("", new axw());
            this.oSb.oQU = "City";
            this.oSe.put(this.oSb.oQU, Integer.valueOf(1));
            C39460a c39460a = this.oSb;
            if (!this.oRU) {
                i = 0;
            }
            mo74047a(c39460a, i);
        }
        this.oSb.Title = str;
        this.oSb.nQB = str2;
        notifyDataSetChanged();
        C39460a c39460a2 = this.oSb;
        AppMethodBeat.m2505o(22950);
        return c39460a2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C12712a c12712a;
        int intValue;
        AppMethodBeat.m2504i(22951);
        if (view == null) {
            c12712a = new C12712a();
            view = View.inflate(this.mContext, 2130970284, null);
            c12712a.gne = (TextView) view.findViewById(2131826277);
            c12712a.nDW = (TextView) view.findViewById(2131826289);
            c12712a.hrg = (TextView) view.findViewById(2131826290);
            c12712a.oSg = (LinearLayout) view.findViewById(2131826013);
            c12712a.oSh = (WeImageView) view.findViewById(2131826291);
            if (this.color != null) {
                c12712a.oSh.setIconColor(Color.parseColor(this.color));
            }
            c12712a.oSg.setOnClickListener(this.mjE);
            view.setTag(c12712a);
        } else {
            c12712a = (C12712a) view.getTag();
        }
        C39460a Ad = getItem(i);
        if (this.oSe.containsKey(Ad.oQU)) {
            intValue = ((Integer) this.oSe.get(Ad.oQU)).intValue();
        } else {
            intValue = 0;
        }
        c12712a.oSh.setVisibility(8);
        c12712a.type = intValue;
        c12712a.oSf = Ad;
        if (!C5046bo.isNullOrNil(this.oSd) && this.oSd.equals(Ad.oQU)) {
            c12712a.oSh.setVisibility(0);
        }
        switch (intValue) {
            case 0:
                c12712a.gne.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11782h4));
                c12712a.hrg.setVisibility(0);
                break;
            case 1:
                c12712a.gne.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11782h4));
                c12712a.hrg.setVisibility(8);
                break;
            case 2:
                c12712a.hrg.setVisibility(8);
                c12712a.gne.setTextColor(this.mContext.getResources().getColor(C25738R.color.a0k));
                if (C5046bo.isNullOrNil(this.oSd)) {
                    c12712a.oSh.setVisibility(0);
                    break;
                }
                break;
        }
        c12712a.position = i;
        c12712a.oQU = Ad.oQU;
        if (this.oRm) {
            c12712a.gne.setText(m20727Qc(Ad.Title));
            c12712a.hrg.setText(m20727Qc(C46112a.m86043cs(Ad.oQZ)));
        } else {
            c12712a.gne.setText(Ad.Title);
            c12712a.hrg.setText(C46112a.m86043cs(Ad.oQZ));
        }
        c12712a.nDW.setVisibility(8);
        AppMethodBeat.m2505o(22951);
        return view;
    }

    /* renamed from: Qc */
    private Spannable m20727Qc(String str) {
        AppMethodBeat.m2504i(22952);
        Spannable a = C34204f.m56084a((CharSequence) str, this.oRh);
        AppMethodBeat.m2505o(22952);
        return a;
    }
}
