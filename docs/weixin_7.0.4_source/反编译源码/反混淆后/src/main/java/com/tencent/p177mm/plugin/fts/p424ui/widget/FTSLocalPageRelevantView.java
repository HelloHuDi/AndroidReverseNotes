package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.protocal.protobuf.btf;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView */
public class FTSLocalPageRelevantView extends LinearLayout implements OnClickListener {
    public String hlm = null;
    public LinearLayout jbJ;
    private C20895b mMb = null;
    public List<btf> mMc = null;
    public String query = null;

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView$a */
    class C12069a {
        public btf mMe;
        public int position;

        public C12069a(btf btf, int i) {
            this.mMe = btf;
            this.position = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView$2 */
    class C208932 implements OnClickListener {
        C208932() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(62137);
            FTSLocalPageRelevantView.this.onClick(view);
            AppMethodBeat.m2505o(62137);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView$1 */
    class C208941 implements Runnable {
        C208941() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62136);
            FTSLocalPageRelevantView.m32131a(FTSLocalPageRelevantView.this);
            AppMethodBeat.m2505o(62136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView$b */
    public interface C20895b {
        /* renamed from: a */
        void mo7480a(btf btf, String str, int i);
    }

    public FTSLocalPageRelevantView(Context context) {
        super(context);
        AppMethodBeat.m2504i(62138);
        post(new C208941());
        AppMethodBeat.m2505o(62138);
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnRelevantClickListener(C20895b c20895b) {
        this.mMb = c20895b;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(62139);
        if (!(this.mMb == null || view.getTag() == null || !(view.getTag() instanceof C12069a))) {
            C12069a c12069a = (C12069a) view.getTag();
            this.mMb.mo7480a(c12069a.mMe, this.hlm, c12069a.position);
        }
        AppMethodBeat.m2505o(62139);
    }

    /* renamed from: b */
    public final void mo36184b(List<btf> list, LinearLayout linearLayout) {
        AppMethodBeat.m2504i(62140);
        linearLayout.removeAllViews();
        for (btf btf : list) {
            if (btf != null) {
                Object obj;
                View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(2130969644, linearLayout, false);
                TextView textView = (TextView) inflate.findViewById(2131821019);
                inflate.setOnClickListener(new C208932());
                textView.setText(btf.wVl);
                int indexOf = list.indexOf(btf);
                if (list == null || indexOf >= list.size()) {
                    obj = null;
                } else {
                    obj = new C12069a((btf) list.get(indexOf), indexOf + 1);
                }
                inflate.setTag(obj);
                linearLayout.addView(inflate);
            }
        }
        AppMethodBeat.m2505o(62140);
    }

    /* renamed from: ca */
    public static List<btf> m32132ca(List<btf> list) {
        AppMethodBeat.m2504i(62141);
        LinkedList linkedList = new LinkedList();
        for (btf btf : list) {
            if (!C5046bo.isNullOrNil(btf.wVl)) {
                linkedList.add(btf);
            }
        }
        AppMethodBeat.m2505o(62141);
        return linkedList;
    }

    public String getSearchId() {
        return this.hlm != null ? this.hlm : "";
    }

    public String getWordList() {
        AppMethodBeat.m2504i(62142);
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
        AppMethodBeat.m2505o(62142);
        return stringBuilder2;
    }

    public String getQuery() {
        return this.query != null ? this.query : "";
    }

    /* renamed from: a */
    static /* synthetic */ void m32131a(FTSLocalPageRelevantView fTSLocalPageRelevantView) {
        int dimensionPixelSize;
        AppMethodBeat.m2504i(62143);
        fTSLocalPageRelevantView.setOrientation(1);
        fTSLocalPageRelevantView.setGravity(16);
        fTSLocalPageRelevantView.setVisibility(8);
        try {
            dimensionPixelSize = fTSLocalPageRelevantView.getResources().getDimensionPixelSize(C25738R.dimen.f9846ho);
        } catch (Exception e) {
            dimensionPixelSize = C1338a.fromDPToPix(fTSLocalPageRelevantView.getContext(), 48);
        }
        fTSLocalPageRelevantView.setMinimumHeight(dimensionPixelSize);
        LayoutParams layoutParams = (LayoutParams) fTSLocalPageRelevantView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        fTSLocalPageRelevantView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(62143);
    }
}
