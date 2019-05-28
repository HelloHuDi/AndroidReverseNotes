package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p230g.p231a.C32578jb;
import com.tencent.p177mm.p230g.p711c.C6571cp;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.pluginsdk.p1077c.C40418a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C35883a.C14956a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.FMessageListView */
public class FMessageListView extends LinearLayout {
    private boolean cPo;
    private Context context;
    private final LayoutParams njH;
    private C14956a vqm;
    private C40418a vqt;
    private C4931a vqu;
    private C4931a vqv;
    private C23329a vqw;
    private C35883a vqx;
    private TextView vqy;

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.FMessageListView$2 */
    class C149512 implements C4931a {
        C149512() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(28038);
            if (!FMessageListView.this.cPo) {
                FMessageListView.m35822b(FMessageListView.this, str);
            }
            AppMethodBeat.m2505o(28038);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.FMessageListView$3 */
    class C149523 implements C4931a {
        C149523() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(28039);
            if (!FMessageListView.this.cPo) {
                FMessageListView.m35823c(FMessageListView.this, str);
            }
            AppMethodBeat.m2505o(28039);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.FMessageListView$1 */
    class C233281 extends C40418a {
        C233281() {
        }

        /* renamed from: j */
        public final void mo39062j(C4883b c4883b) {
            AppMethodBeat.m2504i(28037);
            if ((c4883b instanceof C32578jb) && !FMessageListView.this.cPo) {
                FMessageListView.m35820a(FMessageListView.this, ((C32578jb) c4883b).cEi.ctq);
            }
            AppMethodBeat.m2505o(28037);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.FMessageListView$a */
    static class C23329a extends View {
        public C23329a(Context context) {
            super(context);
            AppMethodBeat.m2504i(28042);
            setLayoutParams(new LayoutParams(-1, 1));
            AppMethodBeat.m2505o(28042);
        }
    }

    public FMessageListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(28043);
        this.vqt = new C233281();
        this.vqu = new C149512();
        this.vqv = new C149523();
        this.njH = new LayoutParams(-1, -2);
        this.cPo = false;
        this.context = context;
        AppMethodBeat.m2505o(28043);
    }

    public void setFMessageArgs(C14956a c14956a) {
        AppMethodBeat.m2504i(28044);
        this.vqm = c14956a;
        C35883a.setFMessageArgs(c14956a);
        AppMethodBeat.m2505o(28044);
    }

    public void setHide(boolean z) {
        this.cPo = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(28045);
        super.onDetachedFromWindow();
        detach();
        AppMethodBeat.m2505o(28045);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(28046);
        super.onAttachedToWindow();
        C41789d.akO().mo10116c(this.vqu);
        C40418a.m69321a(C32578jb.class.getName(), this.vqt);
        C41789d.akQ().mo10116c(this.vqu);
        C41789d.akR().mo10116c(this.vqv);
        AppMethodBeat.m2505o(28046);
    }

    public final void detach() {
        AppMethodBeat.m2504i(28047);
        C41789d.akO().mo10117d(this.vqu);
        C41789d.akQ().mo10117d(this.vqu);
        C40418a.m69322b(C32578jb.class.getName(), this.vqt);
        C41789d.akR().mo10117d(this.vqv);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof C35883a) {
                ((C35883a) childAt).detach();
            }
        }
        this.vqw = null;
        this.vqx = null;
        AppMethodBeat.m2505o(28047);
    }

    /* renamed from: a */
    public final void mo39054a(final C14957b c14957b) {
        AppMethodBeat.m2504i(28048);
        if (c14957b == null) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "addItem fail, provider is null");
            AppMethodBeat.m2505o(28048);
        } else if (c14957b.f2975id <= 0) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + c14957b.f2975id);
            AppMethodBeat.m2505o(28048);
        } else {
            int i;
            String str;
            int childCount = getChildCount();
            for (i = 1; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof C35883a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(c14957b.f2975id))) {
                    C4990ab.m7420w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + c14957b.f2975id);
                    AppMethodBeat.m2505o(28048);
                    return;
                }
            }
            if (c14957b.vqC != null) {
                if (this.vqy == null) {
                    this.vqy = (TextView) findViewById(2131823029);
                }
                this.vqy.setText(c14957b.vqC);
                this.vqy.setVisibility(0);
            }
            C4990ab.m7410d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(childCount)));
            if (childCount == 6) {
                C4990ab.m7416i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                C4990ab.m7410d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.vqw = new C23329a(this.context);
                addView(this.vqw);
                this.vqx = new C35883a(this.context);
                this.vqx.setContentText("");
                this.vqx.setBtnVisibility(0);
                addView(this.vqx, this.njH);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(c14957b.username);
                if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                    C4990ab.m7410d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + c14957b.username);
                    this.vqw.setVisibility(0);
                    this.vqx.setVisibility(0);
                } else {
                    C4990ab.m7410d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + c14957b.username);
                    this.vqw.setVisibility(8);
                    this.vqx.setVisibility(8);
                }
            }
            if (c14957b.cRY) {
                String string = this.context.getString(C25738R.string.bwd, new Object[]{c14957b.fjz});
                i = 0;
                str = string;
            } else {
                String str2;
                if (c14957b.nickname == null || c14957b.nickname.length() <= 0) {
                    str2 = c14957b.username;
                    C9638aw.m17190ZK();
                    C7616ad aoO2 = C18628c.m29078XM().aoO(c14957b.username);
                    if (aoO2 != null && ((int) aoO2.ewQ) > 0) {
                        str2 = aoO2.mo16707Oj();
                    }
                } else {
                    str2 = c14957b.nickname;
                }
                String str3 = str2 + ": " + c14957b.fjz;
                i = 1;
                str = str3;
            }
            C35883a c35883a = new C35883a(this.context);
            c35883a.setTag(Long.valueOf(c14957b.f2975id));
            c35883a.setContentText(str);
            c35883a.setBtnVisibility(8);
            if (i != 0) {
                c35883a.setOnLongClickListener(new OnLongClickListener() {

                    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.FMessageListView$4$1 */
                    class C233271 implements C30391c {
                        C233271() {
                        }

                        /* renamed from: iE */
                        public final void mo7700iE(int i) {
                            AppMethodBeat.m2504i(28040);
                            switch (i) {
                                case 0:
                                    ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(c14957b.fjz);
                                    break;
                            }
                            AppMethodBeat.m2505o(28040);
                        }
                    }

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.m2504i(28041);
                        C4990ab.m7410d("MicroMsg.FMessageListView", "jacks long click digest");
                        C30379h.m48421a(FMessageListView.this.getContext(), null, new String[]{FMessageListView.this.getContext().getString(C25738R.string.akc)}, new C233271());
                        AppMethodBeat.m2505o(28041);
                        return true;
                    }
                });
            }
            addView(c35883a, getChildCount() - 2, this.njH);
            AppMethodBeat.m2505o(28048);
        }
    }

    public void setReplyBtnVisible(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(28049);
        int childCount = getChildCount();
        C4990ab.m7410d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
        if (childCount <= 2) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(childCount)));
            AppMethodBeat.m2505o(28049);
            return;
        }
        if (this.vqw != null) {
            this.vqw.setVisibility(z ? 0 : 8);
        }
        if (this.vqx != null) {
            C35883a c35883a = this.vqx;
            if (!z) {
                i = 8;
            }
            c35883a.setVisibility(i);
        }
        AppMethodBeat.m2505o(28049);
    }

    /* renamed from: a */
    static /* synthetic */ void m35820a(FMessageListView fMessageListView, String str) {
        AppMethodBeat.m2504i(28050);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateLbs, id is null");
            AppMethodBeat.m2505o(28050);
            return;
        }
        long j;
        try {
            j = C5046bo.getLong(str, 0);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            AppMethodBeat.m2505o(28050);
            return;
        }
        C4990ab.m7410d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = ".concat(String.valueOf(j)));
        C6571cp c7570bf = new C7570bf();
        if (!C41789d.akQ().mo16761b(j, (C4925c) c7570bf)) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateLbs, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(28050);
        } else if (fMessageListView.vqm == null || !fMessageListView.vqm.talker.equals(c7570bf.field_sayhiuser)) {
            C4990ab.m7410d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
            AppMethodBeat.m2505o(28050);
        } else {
            if (fMessageListView.vqm.mGZ != null && fMessageListView.vqm.mGZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.mo39054a(C14957b.m23237a(fMessageListView.context, c7570bf));
            AppMethodBeat.m2505o(28050);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m35822b(FMessageListView fMessageListView, String str) {
        AppMethodBeat.m2504i(28051);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            AppMethodBeat.m2505o(28051);
            return;
        }
        long j;
        try {
            j = C5046bo.getLong(str, 0);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            AppMethodBeat.m2505o(28051);
            return;
        }
        C4990ab.m7410d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = ".concat(String.valueOf(j)));
        C7569ax c7569ax = new C7569ax();
        if (!C41789d.akO().mo16761b(j, (C4925c) c7569ax)) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(28051);
        } else if (fMessageListView.vqm == null || !fMessageListView.vqm.talker.equals(c7569ax.field_talker)) {
            C4990ab.m7410d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
            AppMethodBeat.m2505o(28051);
        } else {
            if (fMessageListView.vqm.mGZ != null && fMessageListView.vqm.mGZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.mo39054a(C14957b.m23244b(fMessageListView.context, c7569ax));
            AppMethodBeat.m2505o(28051);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m35823c(FMessageListView fMessageListView, String str) {
        AppMethodBeat.m2504i(28052);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateShake, id is null");
            AppMethodBeat.m2505o(28052);
            return;
        }
        long j;
        try {
            j = C5046bo.getLong(str, 0);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            AppMethodBeat.m2505o(28052);
            return;
        }
        C4990ab.m7410d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = ".concat(String.valueOf(j)));
        C41338bt c41338bt = new C41338bt();
        if (!C41789d.akR().mo16761b(j, (C4925c) c41338bt)) {
            C4990ab.m7412e("MicroMsg.FMessageListView", "updateShake, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(28052);
        } else if (fMessageListView.vqm == null || !fMessageListView.vqm.talker.equals(c41338bt.field_sayhiuser)) {
            C4990ab.m7410d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
            AppMethodBeat.m2505o(28052);
        } else {
            if (fMessageListView.vqm.mGZ != null && fMessageListView.vqm.mGZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.mo39054a(C14957b.m23238a(fMessageListView.context, c41338bt));
            AppMethodBeat.m2505o(28052);
        }
    }
}
