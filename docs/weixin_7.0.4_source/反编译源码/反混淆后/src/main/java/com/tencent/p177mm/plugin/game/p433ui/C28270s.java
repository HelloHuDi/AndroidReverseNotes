package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.protocal.protobuf.acy;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.s */
public final class C28270s extends BaseAdapter {
    private Context context;
    private String ctj = "";
    private LinkedList<C12208a> fjr = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.game.ui.s$a */
    public static class C12208a {
        public int actionType;
        public String appId;
        public String description;
        public String nmB;
        public String text;
        public int type;
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.s$b */
    static class C28271b {
        TextView gsf;
        ViewGroup nmC;
        TextView nmD;
        TextView nmE;
        ViewGroup nmF;
        TextView nmG;
        ViewGroup nmH;

        private C28271b() {
        }

        /* synthetic */ C28271b(byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(112187);
        C12208a wO = mo46163wO(i);
        AppMethodBeat.m2505o(112187);
        return wO;
    }

    public C28270s(Context context) {
        AppMethodBeat.m2504i(112182);
        this.context = context;
        AppMethodBeat.m2505o(112182);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C28271b c28271b;
        AppMethodBeat.m2504i(112183);
        C12208a wO = mo46163wO(i);
        if (view == null) {
            view = View.inflate(this.context, 2130969778, null);
            C28271b c28271b2 = new C28271b();
            c28271b2.gsf = (TextView) view.findViewById(2131824625);
            c28271b2.nmC = (ViewGroup) c28271b2.gsf.getParent();
            c28271b2.nmD = (TextView) view.findViewById(2131824626);
            c28271b2.nmE = (TextView) view.findViewById(2131824627);
            c28271b2.nmF = (ViewGroup) c28271b2.nmD.getParent();
            c28271b2.nmG = (TextView) view.findViewById(2131824628);
            c28271b2.nmH = (ViewGroup) c28271b2.nmG.getParent().getParent();
            view.setTag(c28271b2);
            c28271b = c28271b2;
        } else {
            c28271b = (C28271b) view.getTag();
        }
        switch (wO.type) {
            case 1:
                c28271b.nmC.setVisibility(0);
                c28271b.nmF.setVisibility(8);
                c28271b.nmH.setVisibility(8);
                c28271b.nmC.setOnClickListener(null);
                c28271b.gsf.setText(wO.text);
                break;
            case 2:
                c28271b.nmC.setVisibility(8);
                c28271b.nmF.setVisibility(0);
                c28271b.nmH.setVisibility(8);
                c28271b.nmD.setText(wO.text);
                c28271b.nmE.setText(wO.description);
                break;
            case 3:
                c28271b.nmC.setVisibility(8);
                c28271b.nmF.setVisibility(8);
                c28271b.nmH.setVisibility(0);
                c28271b.nmG.setTextColor(this.context.getResources().getColor(C25738R.color.f12212w4));
                int color = this.context.getResources().getColor(C25738R.color.f12057qw);
                int indexOf = wO.text.indexOf(this.ctj);
                if (indexOf < 0) {
                    c28271b.nmG.setText(wO.text);
                    break;
                }
                SpannableString spannableString = new SpannableString(wO.text);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.ctj.length() + indexOf, 33);
                c28271b.nmG.setText(spannableString);
                break;
        }
        AppMethodBeat.m2505o(112183);
        return view;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(112184);
        int size = this.fjr.size();
        AppMethodBeat.m2505o(112184);
        return size;
    }

    /* renamed from: wO */
    public final C12208a mo46163wO(int i) {
        AppMethodBeat.m2504i(112185);
        C12208a c12208a = (C12208a) this.fjr.get(i);
        AppMethodBeat.m2505o(112185);
        return c12208a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: b */
    public final void mo46158b(String str, String str2, LinkedList<acy> linkedList) {
        AppMethodBeat.m2504i(112186);
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(112186);
            return;
        }
        this.ctj = str;
        this.fjr.clear();
        if (C5046bo.isNullOrNil(str)) {
            C12208a c12208a = new C12208a();
            c12208a.type = 1;
            if (C5046bo.isNullOrNil(str2)) {
                c12208a.text = this.context.getString(C25738R.string.c7w);
            } else {
                c12208a.text = str2;
            }
            this.fjr.add(c12208a);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            acy acy = (acy) it.next();
            C12208a c12208a2 = new C12208a();
            c12208a2.type = C5046bo.isNullOrNil(str) ? 2 : 3;
            c12208a2.appId = acy.mZr;
            c12208a2.text = acy.wkK;
            c12208a2.description = acy.vEA;
            c12208a2.actionType = acy.wkB;
            c12208a2.nmB = acy.wkC;
            this.fjr.add(c12208a2);
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(112186);
    }
}
