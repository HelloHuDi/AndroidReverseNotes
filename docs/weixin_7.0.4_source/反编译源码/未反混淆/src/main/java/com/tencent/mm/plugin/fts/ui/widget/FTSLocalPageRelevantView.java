package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public class FTSLocalPageRelevantView extends LinearLayout implements OnClickListener {
    public String hlm = null;
    public LinearLayout jbJ;
    private b mMb = null;
    public List<btf> mMc = null;
    public String query = null;

    class a {
        public btf mMe;
        public int position;

        public a(btf btf, int i) {
            this.mMe = btf;
            this.position = i;
        }
    }

    public interface b {
        void a(btf btf, String str, int i);
    }

    public FTSLocalPageRelevantView(Context context) {
        super(context);
        AppMethodBeat.i(62138);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(62136);
                FTSLocalPageRelevantView.a(FTSLocalPageRelevantView.this);
                AppMethodBeat.o(62136);
            }
        });
        AppMethodBeat.o(62138);
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnRelevantClickListener(b bVar) {
        this.mMb = bVar;
    }

    public void onClick(View view) {
        AppMethodBeat.i(62139);
        if (!(this.mMb == null || view.getTag() == null || !(view.getTag() instanceof a))) {
            a aVar = (a) view.getTag();
            this.mMb.a(aVar.mMe, this.hlm, aVar.position);
        }
        AppMethodBeat.o(62139);
    }

    public final void b(List<btf> list, LinearLayout linearLayout) {
        AppMethodBeat.i(62140);
        linearLayout.removeAllViews();
        for (btf btf : list) {
            if (btf != null) {
                Object obj;
                View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.a22, linearLayout, false);
                TextView textView = (TextView) inflate.findViewById(R.id.m5);
                inflate.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(62137);
                        FTSLocalPageRelevantView.this.onClick(view);
                        AppMethodBeat.o(62137);
                    }
                });
                textView.setText(btf.wVl);
                int indexOf = list.indexOf(btf);
                if (list == null || indexOf >= list.size()) {
                    obj = null;
                } else {
                    obj = new a((btf) list.get(indexOf), indexOf + 1);
                }
                inflate.setTag(obj);
                linearLayout.addView(inflate);
            }
        }
        AppMethodBeat.o(62140);
    }

    public static List<btf> ca(List<btf> list) {
        AppMethodBeat.i(62141);
        LinkedList linkedList = new LinkedList();
        for (btf btf : list) {
            if (!bo.isNullOrNil(btf.wVl)) {
                linkedList.add(btf);
            }
        }
        AppMethodBeat.o(62141);
        return linkedList;
    }

    public String getSearchId() {
        return this.hlm != null ? this.hlm : "";
    }

    public String getWordList() {
        AppMethodBeat.i(62142);
        StringBuilder stringBuilder = new StringBuilder("");
        if (this.mMc != null) {
            for (btf btf : this.mMc) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("|");
                }
                stringBuilder.append(btf.wVl);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(62142);
        return stringBuilder2;
    }

    public String getQuery() {
        return this.query != null ? this.query : "";
    }

    static /* synthetic */ void a(FTSLocalPageRelevantView fTSLocalPageRelevantView) {
        int dimensionPixelSize;
        AppMethodBeat.i(62143);
        fTSLocalPageRelevantView.setOrientation(1);
        fTSLocalPageRelevantView.setGravity(16);
        fTSLocalPageRelevantView.setVisibility(8);
        try {
            dimensionPixelSize = fTSLocalPageRelevantView.getResources().getDimensionPixelSize(R.dimen.ho);
        } catch (Exception e) {
            dimensionPixelSize = com.tencent.mm.bz.a.fromDPToPix(fTSLocalPageRelevantView.getContext(), 48);
        }
        fTSLocalPageRelevantView.setMinimumHeight(dimensionPixelSize);
        LayoutParams layoutParams = (LayoutParams) fTSLocalPageRelevantView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        fTSLocalPageRelevantView.setLayoutParams(layoutParams);
        AppMethodBeat.o(62143);
    }
}
