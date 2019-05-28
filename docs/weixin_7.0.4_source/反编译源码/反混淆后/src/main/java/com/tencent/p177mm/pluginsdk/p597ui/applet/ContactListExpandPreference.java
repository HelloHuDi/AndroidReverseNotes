package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C14929b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C301083;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C301094;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference */
public class ContactListExpandPreference extends Preference {
    private int vlc = -1;
    public C30103i vld;
    public C30106k vle;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference$a */
    public interface C30100a {
        /* renamed from: JT */
        void mo14653JT();

        /* renamed from: iA */
        void mo14654iA(int i);

        /* renamed from: iB */
        void mo14655iB(int i);

        /* renamed from: iC */
        void mo14656iC(int i);
    }

    public ContactListExpandPreference(Context context, int i) {
        super(context);
        AppMethodBeat.m2504i(79763);
        if (i == 0) {
            djE();
        } else if (i == 1) {
            this.vlc = 1;
            this.vle = new C30106k();
        }
        setLayoutResource(2130970141);
        AppMethodBeat.m2505o(79763);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(79764);
        djE();
        setLayoutResource(2130970141);
        AppMethodBeat.m2505o(79764);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(79765);
        djE();
        setLayoutResource(2130970141);
        AppMethodBeat.m2505o(79765);
    }

    private void djE() {
        AppMethodBeat.m2504i(79766);
        this.vlc = 0;
        this.vld = new C30103i(this.mContext);
        AppMethodBeat.m2505o(79766);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(79767);
        if (this.vlc == 1) {
            ViewGroup viewGroup;
            C30106k c30106k = this.vle;
            if (view.getId() == 2131826022) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = (ViewGroup) view.findViewById(2131826022);
            }
            if (c30106k.row == 0) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9957ld), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo));
            } else if (c30106k.row == (c30106k.vkt.getCount() / C14926j.vkC) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9957ld));
            } else {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo));
            }
            if ((c30106k.vkt.vkJ % C14926j.vkC == C14926j.vkC - 1 || c30106k.vkt.vkJ % C14926j.vkC == 0) && c30106k.eic && c30106k.row == (c30106k.vkt.getCount() / C14926j.vkC) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), 0);
            } else if (!c30106k.eic && c30106k.vkt.vkJ % C14926j.vkC == 0 && c30106k.row == (c30106k.vkt.getCount() / C14926j.vkC) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), (int) viewGroup.getContext().getResources().getDimension(C25738R.dimen.f10011nc));
            }
            if (c30106k.vkt != null) {
                viewGroup.setOnClickListener(c30106k.pLd);
                if (viewGroup.getChildCount() > C14926j.vkC) {
                    viewGroup.removeViews(0, viewGroup.getChildCount() - C14926j.vkC);
                    viewGroup.requestLayout();
                }
                for (int i = 0; i < c30106k.vlf; i++) {
                    View inflate;
                    int dimensionPixelSize;
                    if (viewGroup.getChildAt(i) == null) {
                        inflate = View.inflate(viewGroup.getContext(), 2130970531, null);
                        viewGroup.addView(inflate);
                    } else {
                        inflate = viewGroup.getChildAt(i);
                    }
                    LayoutParams layoutParams = new LayoutParams(-2, -2);
                    layoutParams.gravity = 49;
                    if (C14926j.vkC == 4) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    if (!c30106k.vkt.djB() && c30106k.vkt.vkJ == 1) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(C25738R.dimen.f9732dy);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    inflate.setLayoutParams(layoutParams);
                    int i2 = (c30106k.row * c30106k.vlf) + i;
                    c30106k.vkt.getView(i2, inflate, viewGroup);
                    if (c30106k.vkz != null) {
                        inflate.setOnClickListener(new C301083(viewGroup, i2));
                    }
                    if (c30106k.vlg != null) {
                        inflate.setOnLongClickListener(new C301094(viewGroup, i2));
                    }
                }
                if (c30106k.vkt.djB() || c30106k.vkt.vkJ > 1) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else {
                    ((LinearLayout) viewGroup).setGravity(19);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(79767);
    }

    /* renamed from: a */
    public final void mo48357a(C15541f c15541f, String str) {
        AppMethodBeat.m2504i(79768);
        if (this.vld != null) {
            this.vld.mo48373a(c15541f, str);
        }
        AppMethodBeat.m2505o(79768);
    }

    /* renamed from: a */
    public final void mo48356a(C14943d c14943d) {
        if (this.vld != null) {
            this.vld.vkt.vkK = c14943d;
        }
    }

    public final void notifyChanged() {
        AppMethodBeat.m2504i(79769);
        if (this.vld != null) {
            this.vld.aPw();
        }
        AppMethodBeat.m2505o(79769);
    }

    /* renamed from: u */
    public final void mo48371u(String str, List<String> list) {
        AppMethodBeat.m2504i(79770);
        if (this.vld != null) {
            this.vld.mo48377u(str, list);
        }
        AppMethodBeat.m2505o(79770);
    }

    /* renamed from: ag */
    public final void mo48358ag(ArrayList<C7616ad> arrayList) {
        AppMethodBeat.m2504i(79771);
        if (this.vld != null) {
            this.vld.mo48375ag(arrayList);
        }
        AppMethodBeat.m2505o(79771);
    }

    /* renamed from: oB */
    public final void mo48366oB(boolean z) {
        if (this.vld != null) {
            this.vld.vkt.vkG = z;
        }
    }

    /* renamed from: oC */
    public final void mo48367oC(boolean z) {
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

    /* renamed from: KU */
    public final boolean mo48349KU(int i) {
        AppMethodBeat.m2504i(79772);
        if (this.vld != null) {
            boolean KU = this.vld.vkt.mo27251KU(i);
            AppMethodBeat.m2505o(79772);
            return KU;
        }
        AppMethodBeat.m2505o(79772);
        return true;
    }

    /* renamed from: KW */
    public final boolean mo48350KW(int i) {
        AppMethodBeat.m2504i(79773);
        if (this.vld != null) {
            boolean KW = this.vld.vkt.mo27252KW(i);
            AppMethodBeat.m2505o(79773);
            return KW;
        }
        AppMethodBeat.m2505o(79773);
        return false;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(79774);
        if (this.vld == null || !this.vld.vkt.mo27252KW(i)) {
            AppMethodBeat.m2505o(79774);
            return null;
        }
        Object item = this.vld.vkt.getItem(i);
        AppMethodBeat.m2505o(79774);
        return item;
    }

    /* renamed from: KX */
    public final String mo48351KX(int i) {
        AppMethodBeat.m2504i(79775);
        String str;
        if (this.vld == null || !this.vld.vkt.mo27252KW(i)) {
            str = "";
            AppMethodBeat.m2505o(79775);
            return str;
        }
        str = ((C7616ad) this.vld.vkt.getItem(i)).field_username;
        AppMethodBeat.m2505o(79775);
        return str;
    }

    /* renamed from: KY */
    public final String mo48352KY(int i) {
        AppMethodBeat.m2504i(79776);
        String str;
        if (this.vld == null || !this.vld.vkt.mo27252KW(i)) {
            str = "";
            AppMethodBeat.m2505o(79776);
            return str;
        }
        str = ((C7616ad) this.vld.vkt.getItem(i)).field_nickname;
        AppMethodBeat.m2505o(79776);
        return str;
    }

    /* renamed from: KZ */
    public final String mo48353KZ(int i) {
        AppMethodBeat.m2504i(79777);
        String str;
        if (this.vld == null || !this.vld.vkt.mo27252KW(i)) {
            str = "";
            AppMethodBeat.m2505o(79777);
            return str;
        }
        str = ((C7616ad) this.vld.vkt.getItem(i)).field_conRemark;
        AppMethodBeat.m2505o(79777);
        return str;
    }

    public final void djD() {
        AppMethodBeat.m2504i(79778);
        if (this.vld != null) {
            this.vld.vkt.djD();
        }
        AppMethodBeat.m2505o(79778);
    }

    /* renamed from: oD */
    public final ContactListExpandPreference mo48368oD(boolean z) {
        if (this.vld != null) {
            this.vld.vkt.vkM = z;
        }
        return this;
    }

    /* renamed from: oE */
    public final ContactListExpandPreference mo48369oE(boolean z) {
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
        AppMethodBeat.m2504i(79779);
        if (this.vld != null) {
            this.vld.djz();
        }
        AppMethodBeat.m2505o(79779);
    }

    public final void refresh() {
        AppMethodBeat.m2504i(79780);
        if (this.vld != null) {
            this.vld.vkt.mo27253Kh();
        }
        AppMethodBeat.m2505o(79780);
    }

    /* renamed from: ci */
    public final void mo48360ci(List<String> list) {
        AppMethodBeat.m2504i(79781);
        if (this.vld != null) {
            this.vld.vkt.mo27255ci(list);
        }
        AppMethodBeat.m2505o(79781);
    }

    /* renamed from: a */
    public final void mo48355a(C14929b c14929b) {
        if (this.vld != null) {
            this.vld.vku = c14929b;
        }
    }

    /* renamed from: a */
    public final void mo48354a(C30100a c30100a) {
        if (this.vld != null) {
            this.vld.rPU = c30100a;
        }
    }
}
