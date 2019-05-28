package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends BaseAdapter {
    private Context context;
    private String ctj = "";
    private LinkedList<a> fjr = new LinkedList();

    public static class a {
        public int actionType;
        public String appId;
        public String description;
        public String nmB;
        public String text;
        public int type;
    }

    static class b {
        TextView gsf;
        ViewGroup nmC;
        TextView nmD;
        TextView nmE;
        ViewGroup nmF;
        TextView nmG;
        ViewGroup nmH;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(112187);
        a wO = wO(i);
        AppMethodBeat.o(112187);
        return wO;
    }

    public s(Context context) {
        AppMethodBeat.i(112182);
        this.context = context;
        AppMethodBeat.o(112182);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(112183);
        a wO = wO(i);
        if (view == null) {
            view = View.inflate(this.context, R.layout.a5o, null);
            b bVar2 = new b();
            bVar2.gsf = (TextView) view.findViewById(R.id.c9a);
            bVar2.nmC = (ViewGroup) bVar2.gsf.getParent();
            bVar2.nmD = (TextView) view.findViewById(R.id.c9b);
            bVar2.nmE = (TextView) view.findViewById(R.id.c9c);
            bVar2.nmF = (ViewGroup) bVar2.nmD.getParent();
            bVar2.nmG = (TextView) view.findViewById(R.id.c9d);
            bVar2.nmH = (ViewGroup) bVar2.nmG.getParent().getParent();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (wO.type) {
            case 1:
                bVar.nmC.setVisibility(0);
                bVar.nmF.setVisibility(8);
                bVar.nmH.setVisibility(8);
                bVar.nmC.setOnClickListener(null);
                bVar.gsf.setText(wO.text);
                break;
            case 2:
                bVar.nmC.setVisibility(8);
                bVar.nmF.setVisibility(0);
                bVar.nmH.setVisibility(8);
                bVar.nmD.setText(wO.text);
                bVar.nmE.setText(wO.description);
                break;
            case 3:
                bVar.nmC.setVisibility(8);
                bVar.nmF.setVisibility(8);
                bVar.nmH.setVisibility(0);
                bVar.nmG.setTextColor(this.context.getResources().getColor(R.color.w4));
                int color = this.context.getResources().getColor(R.color.qw);
                int indexOf = wO.text.indexOf(this.ctj);
                if (indexOf < 0) {
                    bVar.nmG.setText(wO.text);
                    break;
                }
                SpannableString spannableString = new SpannableString(wO.text);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.ctj.length() + indexOf, 33);
                bVar.nmG.setText(spannableString);
                break;
        }
        AppMethodBeat.o(112183);
        return view;
    }

    public final int getCount() {
        AppMethodBeat.i(112184);
        int size = this.fjr.size();
        AppMethodBeat.o(112184);
        return size;
    }

    public final a wO(int i) {
        AppMethodBeat.i(112185);
        a aVar = (a) this.fjr.get(i);
        AppMethodBeat.o(112185);
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void b(String str, String str2, LinkedList<acy> linkedList) {
        AppMethodBeat.i(112186);
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(112186);
            return;
        }
        this.ctj = str;
        this.fjr.clear();
        if (bo.isNullOrNil(str)) {
            a aVar = new a();
            aVar.type = 1;
            if (bo.isNullOrNil(str2)) {
                aVar.text = this.context.getString(R.string.c7w);
            } else {
                aVar.text = str2;
            }
            this.fjr.add(aVar);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            acy acy = (acy) it.next();
            a aVar2 = new a();
            aVar2.type = bo.isNullOrNil(str) ? 2 : 3;
            aVar2.appId = acy.mZr;
            aVar2.text = acy.wkK;
            aVar2.description = acy.vEA;
            aVar2.actionType = acy.wkB;
            aVar2.nmB = acy.wkC;
            this.fjr.add(aVar2);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(112186);
    }
}
