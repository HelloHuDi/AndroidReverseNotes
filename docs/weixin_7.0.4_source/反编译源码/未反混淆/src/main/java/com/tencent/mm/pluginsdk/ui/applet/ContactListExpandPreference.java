package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.k.AnonymousClass3;
import com.tencent.mm.pluginsdk.ui.applet.k.AnonymousClass4;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference extends Preference {
    private int vlc = -1;
    public i vld;
    public k vle;

    public interface a {
        void JT();

        void iA(int i);

        void iB(int i);

        void iC(int i);
    }

    public ContactListExpandPreference(Context context, int i) {
        super(context);
        AppMethodBeat.i(79763);
        if (i == 0) {
            djE();
        } else if (i == 1) {
            this.vlc = 1;
            this.vle = new k();
        }
        setLayoutResource(R.layout.aeh);
        AppMethodBeat.o(79763);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(79764);
        djE();
        setLayoutResource(R.layout.aeh);
        AppMethodBeat.o(79764);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(79765);
        djE();
        setLayoutResource(R.layout.aeh);
        AppMethodBeat.o(79765);
    }

    private void djE() {
        AppMethodBeat.i(79766);
        this.vlc = 0;
        this.vld = new i(this.mContext);
        AppMethodBeat.o(79766);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(79767);
        if (this.vlc == 1) {
            ViewGroup viewGroup;
            k kVar = this.vle;
            if (view.getId() == R.id.d_3) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = (ViewGroup) view.findViewById(R.id.d_3);
            }
            if (kVar.row == 0) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(R.dimen.ld), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(R.dimen.lo));
            } else if (kVar.row == (kVar.vkt.getCount() / j.vkC) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(R.dimen.ld));
            } else {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(R.dimen.lo), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(R.dimen.lo));
            }
            if ((kVar.vkt.vkJ % j.vkC == j.vkC - 1 || kVar.vkt.vkJ % j.vkC == 0) && kVar.eic && kVar.row == (kVar.vkt.getCount() / j.vkC) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), 0);
            } else if (!kVar.eic && kVar.vkt.vkJ % j.vkC == 0 && kVar.row == (kVar.vkt.getCount() / j.vkC) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), (int) viewGroup.getContext().getResources().getDimension(R.dimen.nc));
            }
            if (kVar.vkt != null) {
                viewGroup.setOnClickListener(kVar.pLd);
                if (viewGroup.getChildCount() > j.vkC) {
                    viewGroup.removeViews(0, viewGroup.getChildCount() - j.vkC);
                    viewGroup.requestLayout();
                }
                for (int i = 0; i < kVar.vlf; i++) {
                    View inflate;
                    int dimensionPixelSize;
                    if (viewGroup.getChildAt(i) == null) {
                        inflate = View.inflate(viewGroup.getContext(), R.layout.ap0, null);
                        viewGroup.addView(inflate);
                    } else {
                        inflate = viewGroup.getChildAt(i);
                    }
                    LayoutParams layoutParams = new LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (j.vkC == 4) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.m4);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.lo);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    if (!kVar.vkt.djB() && kVar.vkt.vkJ == 1) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.dy);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    inflate.setLayoutParams(layoutParams);
                    int i2 = (kVar.row * kVar.vlf) + i;
                    kVar.vkt.getView(i2, inflate, viewGroup);
                    if (kVar.vkz != null) {
                        inflate.setOnClickListener(new AnonymousClass3(viewGroup, i2));
                    }
                    if (kVar.vlg != null) {
                        inflate.setOnLongClickListener(new AnonymousClass4(viewGroup, i2));
                    }
                }
                if (kVar.vkt.djB() || kVar.vkt.vkJ > 1) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else {
                    ((LinearLayout) viewGroup).setGravity(19);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.o(79767);
    }

    public final void a(f fVar, String str) {
        AppMethodBeat.i(79768);
        if (this.vld != null) {
            this.vld.a(fVar, str);
        }
        AppMethodBeat.o(79768);
    }

    public final void a(d dVar) {
        if (this.vld != null) {
            this.vld.vkt.vkK = dVar;
        }
    }

    public final void notifyChanged() {
        AppMethodBeat.i(79769);
        if (this.vld != null) {
            this.vld.aPw();
        }
        AppMethodBeat.o(79769);
    }

    public final void u(String str, List<String> list) {
        AppMethodBeat.i(79770);
        if (this.vld != null) {
            this.vld.u(str, list);
        }
        AppMethodBeat.o(79770);
    }

    public final void ag(ArrayList<ad> arrayList) {
        AppMethodBeat.i(79771);
        if (this.vld != null) {
            this.vld.ag(arrayList);
        }
        AppMethodBeat.o(79771);
    }

    public final void oB(boolean z) {
        if (this.vld != null) {
            this.vld.vkt.vkG = z;
        }
    }

    public final void oC(boolean z) {
        if (this.vld != null) {
            this.vld.vkt.vkF = z;
        }
    }

    public final void djF() {
        if (this.vld != null) {
            this.vld.vkt.vkV = false;
        }
    }

    public final void ajF(String str) {
        if (this.vld != null) {
            this.vld.vkt.vkR = str;
        }
    }

    public final boolean KU(int i) {
        AppMethodBeat.i(79772);
        if (this.vld != null) {
            boolean KU = this.vld.vkt.KU(i);
            AppMethodBeat.o(79772);
            return KU;
        }
        AppMethodBeat.o(79772);
        return true;
    }

    public final boolean KW(int i) {
        AppMethodBeat.i(79773);
        if (this.vld != null) {
            boolean KW = this.vld.vkt.KW(i);
            AppMethodBeat.o(79773);
            return KW;
        }
        AppMethodBeat.o(79773);
        return false;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(79774);
        if (this.vld == null || !this.vld.vkt.KW(i)) {
            AppMethodBeat.o(79774);
            return null;
        }
        Object item = this.vld.vkt.getItem(i);
        AppMethodBeat.o(79774);
        return item;
    }

    public final String KX(int i) {
        AppMethodBeat.i(79775);
        String str;
        if (this.vld == null || !this.vld.vkt.KW(i)) {
            str = "";
            AppMethodBeat.o(79775);
            return str;
        }
        str = ((ad) this.vld.vkt.getItem(i)).field_username;
        AppMethodBeat.o(79775);
        return str;
    }

    public final String KY(int i) {
        AppMethodBeat.i(79776);
        String str;
        if (this.vld == null || !this.vld.vkt.KW(i)) {
            str = "";
            AppMethodBeat.o(79776);
            return str;
        }
        str = ((ad) this.vld.vkt.getItem(i)).field_nickname;
        AppMethodBeat.o(79776);
        return str;
    }

    public final String KZ(int i) {
        AppMethodBeat.i(79777);
        String str;
        if (this.vld == null || !this.vld.vkt.KW(i)) {
            str = "";
            AppMethodBeat.o(79777);
            return str;
        }
        str = ((ad) this.vld.vkt.getItem(i)).field_conRemark;
        AppMethodBeat.o(79777);
        return str;
    }

    public final void djD() {
        AppMethodBeat.i(79778);
        if (this.vld != null) {
            this.vld.vkt.djD();
        }
        AppMethodBeat.o(79778);
    }

    public final ContactListExpandPreference oD(boolean z) {
        if (this.vld != null) {
            this.vld.vkt.vkM = z;
        }
        return this;
    }

    public final ContactListExpandPreference oE(boolean z) {
        if (this.vld != null) {
            this.vld.vkt.vkL = z;
        }
        return this;
    }

    public final ContactListExpandPreference djG() {
        if (this.vld != null) {
            this.vld.vkt.vkN = false;
        }
        return this;
    }

    public final void djz() {
        AppMethodBeat.i(79779);
        if (this.vld != null) {
            this.vld.djz();
        }
        AppMethodBeat.o(79779);
    }

    public final void refresh() {
        AppMethodBeat.i(79780);
        if (this.vld != null) {
            this.vld.vkt.Kh();
        }
        AppMethodBeat.o(79780);
    }

    public final void ci(List<String> list) {
        AppMethodBeat.i(79781);
        if (this.vld != null) {
            this.vld.vkt.ci(list);
        }
        AppMethodBeat.o(79781);
    }

    public final void a(b bVar) {
        if (this.vld != null) {
            this.vld.vku = bVar;
        }
    }

    public final void a(a aVar) {
        if (this.vld != null) {
            this.vld.rPU = aVar;
        }
    }
}
