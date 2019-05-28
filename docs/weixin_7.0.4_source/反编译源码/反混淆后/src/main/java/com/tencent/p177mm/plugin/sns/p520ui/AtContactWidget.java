package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.smtt.sdk.WebView;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.AtContactWidget */
public class AtContactWidget extends LinearLayout {
    private View contentView;
    private Activity gNy;
    private TextView iyE;
    private ImageView rhd;
    private TextView rhe;
    private PreviewContactView rhf;
    SnsUploadConfigView rhg;
    private List<String> rhh = new LinkedList();
    private boolean rhi = false;

    /* renamed from: com.tencent.mm.plugin.sns.ui.AtContactWidget$1 */
    class C219961 implements OnClickListener {
        C219961() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38150);
            AtContactWidget.m57494a(AtContactWidget.this);
            AppMethodBeat.m2505o(38150);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.AtContactWidget$2 */
    class C291082 implements Runnable {
        C291082() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38151);
            int i = (int) (C5056d.anS().density * 36.0f);
            if (i != 0) {
                i = (((AtContactWidget.this.contentView.getWidth() - AtContactWidget.this.rhd.getWidth()) - AtContactWidget.this.iyE.getWidth()) - ((int) (C5056d.anS().density * 32.0f))) / i;
                if (i > 0 && i < 5) {
                    AtContactWidget.this.rhf.setLineNum(i);
                    LayoutParams layoutParams = (LayoutParams) AtContactWidget.this.rhf.getLayoutParams();
                    layoutParams.alignWithParent = true;
                    AtContactWidget.this.rhf.setLayoutParams(layoutParams);
                }
            }
            AppMethodBeat.m2505o(38151);
        }
    }

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38152);
        init(context);
        AppMethodBeat.m2505o(38152);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38153);
        init(context);
        AppMethodBeat.m2505o(38153);
    }

    public List<String> getAtList() {
        AppMethodBeat.m2504i(38154);
        if (this.rhh == null) {
            this.rhh = new LinkedList();
        }
        List list = this.rhh;
        AppMethodBeat.m2505o(38154);
        return list;
    }

    public final void crA() {
        AppMethodBeat.m2504i(38155);
        if (this.rhh == null) {
            this.rhh = new LinkedList();
        }
        this.rhh.clear();
        if (this.rhf != null) {
            this.rhf.setList(this.rhh);
        }
        crB();
        if (this.rhe != null) {
            this.rhe.setVisibility(8);
        }
        if (this.iyE != null) {
            this.iyE.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        }
        AppMethodBeat.m2505o(38155);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(38156);
        this.gNy = (Activity) context;
        this.contentView = C5616v.m8409hu(context).inflate(getLayoutResource(), this);
        this.rhf = (PreviewContactView) this.contentView.findViewById(2131821516);
        this.rhd = (ImageView) this.contentView.findViewById(2131821514);
        this.rhe = (TextView) this.contentView.findViewById(2131827564);
        this.iyE = (TextView) this.contentView.findViewById(2131821515);
        this.contentView.setOnClickListener(new C219961());
        this.contentView.post(new C291082());
        AppMethodBeat.m2505o(38156);
    }

    /* renamed from: ao */
    public final boolean mo55583ao(Intent intent) {
        AppMethodBeat.m2504i(38157);
        String stringExtra = intent.getStringExtra("Select_Contact");
        LinkedList linkedList = new LinkedList();
        if (stringExtra == null || stringExtra.equals("")) {
            List linkedList2 = new LinkedList();
        } else {
            Object linkedList22 = C5046bo.m7508P(stringExtra.split(","));
        }
        if (this.rhh == null) {
            this.rhh = new LinkedList();
        }
        this.rhh.clear();
        for (String stringExtra2 : linkedList22) {
            if (!this.rhh.contains(stringExtra2)) {
                this.rhh.add(stringExtra2);
            }
        }
        if (this.rhf != null) {
            this.rhf.setList(this.rhh);
        }
        if (this.iyE != null) {
            this.iyE.setTextColor(getResources().getColor(linkedList22.isEmpty() ? C25738R.color.f12212w4 : C25738R.color.f12069r8));
        }
        if (this.rhi) {
            C4990ab.m7410d("MicroMsg.AtContactWiget", "withList count " + this.rhh.size());
            if (!this.rhi || this.rhe == null || this.rhh.size() <= 0) {
                this.rhe.setVisibility(8);
            } else {
                this.rhe.setVisibility(0);
                if (this.rhh.size() < 100) {
                    this.rhe.setText(this.rhh.size());
                    this.rhe.setBackgroundResource(C44385r.m80243ik(getContext()));
                } else {
                    this.rhe.setText("");
                    this.rhe.setBackgroundResource(C1318a.badge_count_more);
                }
            }
        }
        crB();
        AppMethodBeat.m2505o(38157);
        return true;
    }

    private void crB() {
        AppMethodBeat.m2504i(38158);
        if (this.rhh.size() > 0) {
            this.rhd.setImageDrawable(C5225ah.m7962f(this.gNy, getWithDrawableId(), getContext().getResources().getColor(C25738R.color.a61)));
            AppMethodBeat.m2505o(38158);
            return;
        }
        this.rhd.setImageDrawable(C5225ah.m7962f(this.gNy, getWithEmptyDrawableId(), WebView.NIGHT_MODE_COLOR));
        AppMethodBeat.m2505o(38158);
    }

    public void setShowAtList(boolean z) {
        AppMethodBeat.m2504i(38159);
        if (this.rhf != null) {
            this.rhf.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.m2505o(38159);
    }

    public void setShowAtTips(boolean z) {
        AppMethodBeat.m2504i(38160);
        if (!(this.contentView == null || this.iyE == null)) {
            this.iyE.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.m2505o(38160);
    }

    public void setShowAtNum(boolean z) {
        this.rhi = z;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return 2130968780;
    }

    /* Access modifiers changed, original: protected */
    public int getWithDrawableId() {
        return C1318a.album_mention_icon_pressed;
    }

    /* Access modifiers changed, original: protected */
    public int getWithEmptyDrawableId() {
        return C1318a.album_mention_icon_normal;
    }

    /* renamed from: a */
    static /* synthetic */ void m57494a(AtContactWidget atContactWidget) {
        AppMethodBeat.m2504i(38161);
        if (atContactWidget.rhh == null) {
            atContactWidget.rhh = new LinkedList();
        }
        if (atContactWidget.rhg == null || atContactWidget.rhg.getPrivated() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.gNy.getString(C25738R.string.eqq));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", C1853r.m3846Yz());
            intent.putExtra("Select_Contact", C5046bo.m7536c(atContactWidget.rhh, ","));
            intent.putExtra("sns_address_count", 0);
            C24826a.gkE.mo38896a(intent, atContactWidget.gNy, 6);
            AppMethodBeat.m2505o(38161);
            return;
        }
        C30379h.m48467g(atContactWidget.gNy, C25738R.string.epa, C25738R.string.f9238tz);
        AppMethodBeat.m2505o(38161);
    }
}
