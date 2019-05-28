package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView extends LinearLayout {
    private ImageView lnh;
    public FavTagPanel mjS;
    public List<Integer> mlj = new LinkedList();
    private ImageButton mpR;
    public List<String> mpS = new LinkedList();
    public List<String> mpT = new LinkedList();
    public a mpU;

    public interface a {
        void a(String str, List<Integer> list, List<String> list2, List<String> list3);

        void a(List<Integer> list, List<String> list2, List<String> list3, boolean z);

        void app();
    }

    static /* synthetic */ void a(FavSearchActionView favSearchActionView, String str) {
        AppMethodBeat.i(74697);
        favSearchActionView.Mh(str);
        AppMethodBeat.o(74697);
    }

    static /* synthetic */ void c(FavSearchActionView favSearchActionView) {
        AppMethodBeat.i(74698);
        favSearchActionView.bwB();
        AppMethodBeat.o(74698);
    }

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(74689);
        AppMethodBeat.o(74689);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(74690);
        super.onFinishInflate();
        this.mpR = (ImageButton) findViewById(R.id.bri);
        this.mjS = (FavTagPanel) findViewById(R.id.brh);
        this.lnh = (ImageView) findViewById(R.id.l1);
        if (this.mjS != null) {
            this.mjS.setEditTextColor(getResources().getColor(R.color.h7));
            this.mjS.setTagTipsDrawable(0);
            this.mjS.setTagHighlineBG(0);
            this.mjS.setTagSelectedBG(0);
            this.mjS.setTagSelectedTextColorRes(R.color.hi);
            this.mjS.setTagNormalBG(0);
            this.mjS.setTagNormalTextColorRes(R.color.a69);
            this.mjS.setEditHint(getResources().getString(R.string.te));
            this.mjS.qe(true);
            this.mjS.yxn = false;
            this.mjS.yxo = true;
            this.mjS.setCallBack(new com.tencent.mm.plugin.fav.ui.widget.FavTagPanel.a() {
                public final void JR(String str) {
                    AppMethodBeat.i(74682);
                    ab.d("MicroMsg.FavSearchActionView", "unselected tag %s", str);
                    FavSearchActionView.this.mjS.removeTag(str);
                    JT(str);
                    AppMethodBeat.o(74682);
                }

                public final void JS(String str) {
                }

                public final void JT(String str) {
                    AppMethodBeat.i(74683);
                    FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.this.mjS.getEditText());
                    FavSearchActionView.this.mpS.remove(str);
                    FavSearchActionView.c(FavSearchActionView.this);
                    if (FavSearchActionView.this.mpU == null) {
                        AppMethodBeat.o(74683);
                        return;
                    }
                    FavSearchActionView.this.mpU.a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, true);
                    AppMethodBeat.o(74683);
                }

                public final void JU(String str) {
                    AppMethodBeat.i(74684);
                    FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.this.mjS.getEditText());
                    FavSearchActionView.c(FavSearchActionView.this);
                    if (FavSearchActionView.this.mpU == null) {
                        AppMethodBeat.o(74684);
                        return;
                    }
                    FavSearchActionView.this.mpU.a(str, FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS);
                    AppMethodBeat.o(74684);
                }

                public final void JV(String str) {
                    AppMethodBeat.i(74685);
                    FavSearchActionView.a(FavSearchActionView.this, str);
                    FavSearchActionView.this.mpU.a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, false);
                    AppMethodBeat.o(74685);
                }

                public final void bmm() {
                    AppMethodBeat.i(74686);
                    if (FavSearchActionView.this.mpU == null) {
                        AppMethodBeat.o(74686);
                        return;
                    }
                    FavSearchActionView.this.mpU.app();
                    AppMethodBeat.o(74686);
                }

                public final void Mi(String str) {
                    AppMethodBeat.i(74687);
                    ab.d("MicroMsg.FavSearchActionView", "unselected type %s", str);
                    FavSearchActionView.this.mjS;
                    FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.this.mjS.getEditText());
                    FavSearchActionView.this.mlj.remove(FavSearchActionView.ap(FavSearchActionView.this.getContext(), str));
                    FavSearchActionView.c(FavSearchActionView.this);
                    if (FavSearchActionView.this.mpU != null) {
                        FavSearchActionView.this.mpU.a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, true);
                    }
                    AppMethodBeat.o(74687);
                }

                public final void q(boolean z, int i) {
                }
            });
        }
        if (this.mpR != null) {
            this.mpR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74688);
                    if (FavSearchActionView.this.mpU == null) {
                        AppMethodBeat.o(74688);
                        return;
                    }
                    FavSearchActionView.this.mjS.dAg();
                    FavSearchActionView.this.mjS.dAb();
                    FavSearchActionView.this.mpT.clear();
                    FavSearchActionView.this.mpS.clear();
                    FavSearchActionView.this.mpU.a(FavSearchActionView.this.mlj, FavSearchActionView.this.mpT, FavSearchActionView.this.mpS, true);
                    FavSearchActionView.c(FavSearchActionView.this);
                    AppMethodBeat.o(74688);
                }
            });
        }
        AppMethodBeat.o(74690);
    }

    public final void Mh(String str) {
        AppMethodBeat.i(74691);
        this.mpT.clear();
        for (String str2 : bo.bc(str, "").split(" ")) {
            if (!bo.isNullOrNil(str2)) {
                this.mpT.add(str2);
            }
        }
        AppMethodBeat.o(74691);
    }

    public void setOnSearchChangedListener(a aVar) {
        this.mpU = aVar;
    }

    public List<String> getSearchKeys() {
        AppMethodBeat.i(74692);
        if (this.mjS != null) {
            Mh(this.mjS.getEditText());
        }
        List list = this.mpT;
        AppMethodBeat.o(74692);
        return list;
    }

    public List<String> getSearchTags() {
        return this.mpS;
    }

    private void bwB() {
        AppMethodBeat.i(74693);
        if (this.mlj.isEmpty() && this.mpS.isEmpty()) {
            this.mjS.setEditHint(getResources().getString(R.string.te));
            AppMethodBeat.o(74693);
            return;
        }
        this.mjS.setEditHint("");
        AppMethodBeat.o(74693);
    }

    public final void S(int i, boolean z) {
        AppMethodBeat.i(74694);
        this.mlj.clear();
        this.mlj.add(Integer.valueOf(i));
        if (this.mjS == null) {
            AppMethodBeat.o(74694);
            return;
        }
        bwB();
        this.mjS.setType(M(getContext(), i));
        if (this.mpU == null) {
            AppMethodBeat.o(74694);
            return;
        }
        Mh(this.mjS.getEditText());
        if (z) {
            this.mpU.a(this.mlj, this.mpT, this.mpS, false);
        }
        h.pYm.e(11126, Integer.valueOf(1));
        AppMethodBeat.o(74694);
    }

    private static String M(Context context, int i) {
        AppMethodBeat.i(74695);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(74695);
            return str;
        }
        switch (i) {
            case 3:
                str = context.getString(R.string.brw);
                AppMethodBeat.o(74695);
                return str;
            case 5:
                str = context.getString(R.string.bru);
                AppMethodBeat.o(74695);
                return str;
            case 6:
                str = context.getString(R.string.brq);
                AppMethodBeat.o(74695);
                return str;
            case 7:
                str = context.getString(R.string.brr);
                AppMethodBeat.o(74695);
                return str;
            case 8:
                str = context.getString(R.string.brn);
                AppMethodBeat.o(74695);
                return str;
            case 17:
                str = context.getString(R.string.brt);
                AppMethodBeat.o(74695);
                return str;
            case 18:
                str = context.getString(R.string.brs);
                AppMethodBeat.o(74695);
                return str;
            case 21:
                str = context.getString(R.string.brp);
                AppMethodBeat.o(74695);
                return str;
            default:
                str = "";
                AppMethodBeat.o(74695);
                return str;
        }
    }

    public static Integer ap(Context context, String str) {
        AppMethodBeat.i(74696);
        Integer valueOf;
        if (context == null) {
            valueOf = Integer.valueOf(-1);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.brp).equals(str)) {
            valueOf = Integer.valueOf(21);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.bru).equals(str)) {
            valueOf = Integer.valueOf(5);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.brn).equals(str)) {
            valueOf = Integer.valueOf(8);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.brr).equals(str)) {
            valueOf = Integer.valueOf(7);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.brt).equals(str)) {
            valueOf = Integer.valueOf(17);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.brw).equals(str)) {
            valueOf = Integer.valueOf(3);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.brs).equals(str)) {
            valueOf = Integer.valueOf(18);
            AppMethodBeat.o(74696);
            return valueOf;
        } else if (context.getString(R.string.brq).equals(str)) {
            valueOf = Integer.valueOf(6);
            AppMethodBeat.o(74696);
            return valueOf;
        } else {
            valueOf = Integer.valueOf(-1);
            AppMethodBeat.o(74696);
            return valueOf;
        }
    }
}
