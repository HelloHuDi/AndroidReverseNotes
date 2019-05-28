package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C26237rx;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9459ry;
import com.tencent.p177mm.p230g.p231a.C9461rz;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.plugin.sns.p1558j.C39739a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI */
public class SnsSingleTextViewUI extends MMActivity {
    private String czD;
    private C5279d jOb = new C135525();
    private ClipboardManager mmO;
    private C46236n qNM;
    protected int requestType = 0;
    private TextView rxb;
    private String rxc = null;
    private String rxd = null;
    private int rxe;
    private byte[] rxf = null;
    private cat rxg = null;
    private boolean rxh = false;
    private SnsTranslateResultView rxi;
    private C4884c rxj = new C135531();
    private C4884c rxk = new C135542();
    private C4884c rxl = new C135503();
    private String text;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI$3 */
    class C135503 extends C4884c<C9461rz> {
        C135503() {
            AppMethodBeat.m2504i(39302);
            this.xxI = C9461rz.class.getName().hashCode();
            AppMethodBeat.m2505o(39302);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39303);
            C9461rz c9461rz = (C9461rz) c4883b;
            if ((c9461rz instanceof C9461rz) && C5046bo.isEqual(SnsSingleTextViewUI.this.rxd, c9461rz.cNU.f2864id)) {
                C13413ap.m21550da(c9461rz.cNU.f2864id, 8);
                SnsSingleTextViewUI.this.rxi.setVisibility(8);
                SnsSingleTextViewUI.this.rxh = false;
            }
            AppMethodBeat.m2505o(39303);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI$4 */
    class C135514 implements OnMenuItemClickListener {
        C135514() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39304);
            SnsSingleTextViewUI.this.finish();
            AppMethodBeat.m2505o(39304);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI$5 */
    class C135525 implements C5279d {
        C135525() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(39305);
            switch (menuItem.getItemId()) {
                case 0:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        SnsSingleTextViewUI.this.mmO.setText(SnsSingleTextViewUI.this.rxb.getText());
                        C30379h.m48465bQ(SnsSingleTextViewUI.this.mController.ylL, SnsSingleTextViewUI.this.mController.ylL.getString(C25738R.string.f9083oz));
                        if (SnsSingleTextViewUI.this.qNM != null) {
                            C21734a c21734a = C21734a.qjm;
                            C21734a.m33275h(2, C5046bo.m7581mz(SnsSingleTextViewUI.this.qNM.field_snsId), C5046bo.ana(SnsSingleTextViewUI.this.rxb.getText().toString()));
                        }
                    }
                    AppMethodBeat.m2505o(39305);
                    return;
                case 1:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        C45316cl c45316cl = new C45316cl();
                        C39739a.m67962a(c45316cl, SnsSingleTextViewUI.this.czD, SnsSingleTextViewUI.this.rxb.getText());
                        c45316cl.cvA.activity = SnsSingleTextViewUI.this;
                        c45316cl.cvA.cvH = 18;
                        C4879a.xxA.mo10055m(c45316cl);
                    }
                    AppMethodBeat.m2505o(39305);
                    return;
                case 6:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        Intent intent = new Intent();
                        C46236n YT = C13373af.cnF().mo62918YT(SnsSingleTextViewUI.this.czD);
                        intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                        intent.putExtra("k_expose_msg_id", YT == null ? Integer.valueOf(0) : YT.cqA());
                        intent.putExtra("showShare", false);
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        C25985d.m41467b(SnsSingleTextViewUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.m2505o(39305);
                    return;
                case 14:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        C13413ap.m21556r(C13373af.cnF().mo62918YT(SnsSingleTextViewUI.this.czD));
                    }
                    AppMethodBeat.m2505o(39305);
                    return;
                case 15:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        C13413ap.m21543a(new C46922l(null, SnsSingleTextViewUI.this.qNM.cqA(), SnsSingleTextViewUI.this.rxg, null, SnsSingleTextViewUI.this.rxg.ncM, null, 1));
                    }
                    AppMethodBeat.m2505o(39305);
                    return;
                case 16:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        C13413ap.m21557s(C13373af.cnF().mo62918YT(SnsSingleTextViewUI.this.czD));
                    }
                    AppMethodBeat.m2505o(39305);
                    return;
                case 17:
                    if (!(SnsSingleTextViewUI.this.rxb == null || SnsSingleTextViewUI.this.rxb.getText() == null)) {
                        C13413ap.m21546b(new C46922l(null, SnsSingleTextViewUI.this.qNM.cqA(), SnsSingleTextViewUI.this.rxg, null, SnsSingleTextViewUI.this.rxg.ncM, null, 1));
                    }
                    AppMethodBeat.m2505o(39305);
                    return;
                default:
                    AppMethodBeat.m2505o(39305);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI$1 */
    class C135531 extends C4884c<C9459ry> {
        C135531() {
            AppMethodBeat.m2504i(39298);
            this.xxI = C9459ry.class.getName().hashCode();
            AppMethodBeat.m2505o(39298);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39299);
            C9459ry c9459ry = (C9459ry) c4883b;
            if ((c9459ry instanceof C9459ry) && SnsSingleTextViewUI.this.qNM != null && C5046bo.isEqual(SnsSingleTextViewUI.this.rxd, c9459ry.cNT.f2863id)) {
                C13413ap.m21549cZ(SnsSingleTextViewUI.this.rxd, 8);
                SnsSingleTextViewUI.this.rxi.setVisibility(0);
                SnsSingleTextViewUI.this.rxi.mo62985El(SnsSingleTextViewUI.this.rxe);
                SnsSingleTextViewUI.this.rxh = false;
            }
            AppMethodBeat.m2505o(39299);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI$2 */
    class C135542 extends C4884c<C26237rx> {
        C135542() {
            super(0);
            AppMethodBeat.m2504i(39300);
            this.xxI = C26237rx.class.getName().hashCode();
            AppMethodBeat.m2505o(39300);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39301);
            C26237rx c26237rx = (C26237rx) c4883b;
            if ((c26237rx instanceof C26237rx) && SnsSingleTextViewUI.this.qNM != null && C5046bo.isEqual(SnsSingleTextViewUI.this.rxd, c26237rx.cNR.f13666id)) {
                C13413ap.m21549cZ(SnsSingleTextViewUI.this.rxd, 8);
                String str = c26237rx.cNR.result;
                String str2 = c26237rx.cNR.cNS;
                if (C5046bo.isNullOrNil(str)) {
                    SnsSingleTextViewUI.this.rxi.setVisibility(8);
                    C13413ap.m21550da(SnsSingleTextViewUI.this.rxd, 8);
                } else {
                    SnsSingleTextViewUI.this.rxi.setVisibility(0);
                    SnsSingleTextViewUI.this.rxi.mo62986a(null, SnsSingleTextViewUI.this.rxe, str, str2, true);
                    SnsSingleTextViewUI.this.rxh = true;
                }
            }
            AppMethodBeat.m2505o(39301);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsSingleTextViewUI() {
        AppMethodBeat.m2504i(39306);
        AppMethodBeat.m2505o(39306);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39307);
        super.onCreate(bundle);
        this.mmO = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        setMMTitle((int) C25738R.string.ejo);
        setBackBtn(new C135514());
        this.text = getIntent().getStringExtra("sns_text_show");
        this.czD = C5046bo.m7532bc(getIntent().getStringExtra("sns_local_id"), "");
        this.rxf = getIntent().getByteArrayExtra("sns_comment_buf");
        if (this.rxf != null && this.rxf.length > 0) {
            this.rxg = new cat();
            try {
                long j;
                this.rxg.parseFrom(this.rxf);
                StringBuilder stringBuilder = new StringBuilder();
                if (this.rxg.wZG != 0) {
                    j = (long) this.rxg.wZG;
                } else {
                    j = this.rxg.wZJ;
                }
                this.rxc = stringBuilder.append(j).toString();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsSingleTextViewUI", e, "initCommentInfo error.", new Object[0]);
            }
        }
        this.qNM = C13373af.cnF().mo62918YT(this.czD);
        if (C5046bo.isNullOrNil(this.text)) {
            this.text = "";
        }
        this.rxb = (TextView) findViewById(2131827850);
        this.rxb.setText(this.text, BufferType.SPANNABLE);
        C44089j.m79307h(this.rxb, 2);
        this.rxb.setOnTouchListener(new C30132m());
        new C46696j(this).mo75005a(this.rxb, this, this.jOb);
        this.rxi = (SnsTranslateResultView) findViewById(2131827715);
        this.rxi.setResultTextSize(this.rxb.getTextSize());
        if (this.qNM != null) {
            if (ctO()) {
                this.rxd = C13413ap.m21555ga(this.qNM.cqA(), this.rxc);
                this.rxe = 2;
            } else {
                this.rxd = this.qNM.cqA();
                this.rxe = 1;
            }
            if (C13413ap.m21551db(this.rxd, 8)) {
                C13414b Ye = C13413ap.m21540Ye(this.rxd);
                if (Ye != null && Ye.foa) {
                    this.rxi.setVisibility(0);
                    this.rxi.mo62986a(null, this.rxe, Ye.result, Ye.fwM, false);
                    this.rxh = true;
                }
            }
        }
        C4879a.xxA.mo10052c(this.rxj);
        C4879a.xxA.mo10052c(this.rxk);
        C4879a.xxA.mo10052c(this.rxl);
        AppMethodBeat.m2505o(39307);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39308);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.rxj);
        C4879a.xxA.mo10053d(this.rxk);
        C4879a.xxA.mo10053d(this.rxl);
        AppMethodBeat.m2505o(39308);
    }

    public final int getLayoutId() {
        return 2130970801;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        boolean z = true;
        AppMethodBeat.m2504i(39309);
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(C25738R.string.f9082oy));
            if (C25985d.afj("favorite") && !ctO()) {
                contextMenu.add(0, 1, 0, getString(C25738R.string.bnl));
            }
            contextMenu.add(0, 6, 1, getString(C25738R.string.f9113pu));
            if (this.rxh) {
                if (ctO()) {
                    z = false;
                }
                C13413ap.m21544b(contextMenu, z);
            } else {
                if (ctO()) {
                    z = false;
                }
                C13413ap.m21541a(contextMenu, z);
                AppMethodBeat.m2505o(39309);
                return;
            }
        }
        AppMethodBeat.m2505o(39309);
    }

    private boolean ctO() {
        boolean z = false;
        AppMethodBeat.m2504i(39310);
        if (!(this.rxg == null || ((this.rxg.wZG == 0 && this.rxg.wZJ == 0) || C5046bo.isNullOrNil(this.rxg.ncM)))) {
            z = true;
        }
        AppMethodBeat.m2505o(39310);
        return z;
    }
}
