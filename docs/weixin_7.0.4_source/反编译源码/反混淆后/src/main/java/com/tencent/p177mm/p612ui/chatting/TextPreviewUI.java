package com.tencent.p177mm.p612ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37950w;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.AllRemindMsgUI;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C46636v;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.CustomScrollView;
import com.tencent.p177mm.p612ui.base.CustomScrollView.C40664a;
import com.tencent.p177mm.p612ui.chatting.view.C30578b;
import com.tencent.p177mm.p612ui.chatting.view.C30578b.C30581a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p612ui.widget.textview.C40917b;
import com.tencent.p177mm.p612ui.widget.textview.C46708a;
import com.tencent.p177mm.p612ui.widget.textview.C46708a.C40915a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44699i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bdl;
import com.tencent.p177mm.protocal.protobuf.bre;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.recovery.p662wx.util.NetUtil;
import java.io.IOException;

@C5271a(3)
/* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI */
public class TextPreviewUI extends MMActivity implements C1202f {
    private int bottom = 0;
    private C7620bi cKd;
    private Animation qzo;
    private Animation qzp;
    /* renamed from: sW */
    private TextView f16210sW = null;
    private CharSequence text = null;
    private boolean vpf = false;
    /* renamed from: yI */
    private int f16211yI;
    private TextView yJL = null;
    private final int yMA = 1;
    private final int yMB = 2;
    private boolean yMC = false;
    private ToolsBar yMD;
    private View yME;
    private C46708a yMs;
    private C24088a yMt;
    private CharSequence yMu;
    private View yMv;
    private View yMw;
    private View yMx;
    private CustomScrollView yMy;
    private final int yMz = 0;

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$11 */
    class C1555911 implements OnClickListener {
        C1555911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31055);
            if (TextPreviewUI.this.yMs == null || (TextPreviewUI.this.yMs.zWC && TextPreviewUI.this.yMs.zWD)) {
                TextPreviewUI.this.finish();
                AppMethodBeat.m2505o(31055);
                return;
            }
            TextPreviewUI.this.yMs.dLM();
            TextPreviewUI.this.yMs.zWC = true;
            TextPreviewUI.this.yMs.zWD = true;
            TextPreviewUI.this.yMs.dLL();
            AppMethodBeat.m2505o(31055);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$13 */
    class C1556013 implements OnClickListener {
        C1556013() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31057);
            Intent intent = new Intent(TextPreviewUI.this, WebViewUI.class);
            intent.putExtra("rawUrl", C1831bh.m3774r(TextPreviewUI.this.cKd));
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            TextPreviewUI.this.startActivity(intent);
            AppMethodBeat.m2505o(31057);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$14 */
    class C1556114 implements OnMenuItemClickListener {
        C1556114() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(31058);
            TextPreviewUI.this.finish();
            AppMethodBeat.m2505o(31058);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$5 */
    class C236875 implements OnClickListener {
        C236875() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31048);
            if (TextPreviewUI.this.cKd != null) {
                TextPreviewUI.m70365e(TextPreviewUI.this.mController.ylL, TextPreviewUI.this.text.toString());
            }
            AppMethodBeat.m2505o(31048);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$12 */
    class C3044112 implements OnClickListener {
        C3044112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31056);
            if (TextPreviewUI.this.yMs == null || (TextPreviewUI.this.yMs.zWC && TextPreviewUI.this.yMs.zWD)) {
                TextPreviewUI.this.finish();
                AppMethodBeat.m2505o(31056);
                return;
            }
            TextPreviewUI.this.yMs.dLM();
            TextPreviewUI.this.yMs.zWC = true;
            TextPreviewUI.this.yMs.zWD = true;
            TextPreviewUI.this.yMs.dLL();
            AppMethodBeat.m2505o(31056);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$6 */
    class C361176 implements OnClickListener {
        C361176() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31049);
            TextPreviewUI.m70373l(TextPreviewUI.this);
            AppMethodBeat.m2505o(31049);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$8 */
    class C361188 implements OnCreateContextMenuListener {
        C361188() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(31051);
            contextMenu.clear();
            contextMenu.add(0, 0, 0, TextPreviewUI.this.getResources().getString(C25738R.string.f9082oy));
            int t = C1831bh.m3776t(TextPreviewUI.this.cKd);
            if (t <= 0 || t >= C40917b.m70929fs(TextPreviewUI.this.f16210sW).length()) {
                contextMenu.add(1, 1, 0, TextPreviewUI.this.getResources().getString(C25738R.string.czl));
            }
            contextMenu.add(1, 2, 0, TextPreviewUI.this.getResources().getString(C25738R.string.czk));
            AppMethodBeat.m2505o(31051);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$9 */
    class C361199 implements C5279d {

        /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$9$1 */
        class C361201 implements Runnable {
            C361201() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31052);
                if (TextPreviewUI.this.yMs != null) {
                    TextPreviewUI.this.yMs.dLS();
                }
                AppMethodBeat.m2505o(31052);
            }
        }

        C361199() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(31053);
            switch (menuItem.getItemId()) {
                case 0:
                    ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.this.yMu, TextPreviewUI.this.yMu));
                    if (TextPreviewUI.this.yMs != null) {
                        TextPreviewUI.this.yMs.dLM();
                        TextPreviewUI.this.yMs.zWC = true;
                        TextPreviewUI.this.yMs.zWD = true;
                        TextPreviewUI.this.yMs.dLL();
                    }
                    Toast.makeText(TextPreviewUI.this.mController.ylL, C25738R.string.f9083oz, 0).show();
                    AppMethodBeat.m2505o(31053);
                    return;
                case 1:
                    if (TextPreviewUI.this.yMs != null) {
                        TextPreviewUI.this.yMs.dLL();
                        TextPreviewUI.this.yMs.dLP();
                        TextPreviewUI.this.yMs.mo75075hH(0, TextPreviewUI.this.f16210sW.getText().length());
                        TextPreviewUI.this.yMs.zWC = false;
                        TextPreviewUI.this.yMs.zWD = false;
                        TextPreviewUI.this.yMs.dLO();
                    }
                    C5004al.m7442n(new C361201(), 100);
                    AppMethodBeat.m2505o(31053);
                    return;
                case 2:
                    TextPreviewUI.m70365e(TextPreviewUI.this.mController.ylL, TextPreviewUI.this.yMu);
                    break;
            }
            AppMethodBeat.m2505o(31053);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$15 */
    class C4070015 implements OnTouchListener {
        C4070015() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(31059);
            switch (motionEvent.getAction()) {
                case 0:
                    TextPreviewUI.this.vpf = true;
                    break;
                case 1:
                    TextPreviewUI.this.vpf = false;
                    TextPreviewUI.this.yMC = false;
                    break;
                case 2:
                    if (!TextPreviewUI.this.yMC) {
                        TextPreviewUI.this.yMC = true;
                        TextPreviewUI.this.vpf = true;
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(31059);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$7 */
    class C407017 implements OnClickListener {
        C407017() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31050);
            TextPreviewUI.m70360b(TextPreviewUI.this, TextPreviewUI.this.cKd);
            AppMethodBeat.m2505o(31050);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$2 */
    class C407022 implements C40664a {
        C407022() {
        }

        /* renamed from: a */
        public final void mo25553a(ScrollView scrollView, int i, int i2) {
            AppMethodBeat.m2504i(31044);
            int i3 = i - i2;
            TextPreviewUI.this.f16211yI;
            if ((scrollView.getChildAt(0).getMeasuredHeight() == scrollView.getHeight() + scrollView.getScrollY() ? 1 : 0) != 0) {
                TextPreviewUI.this.bottom = scrollView.getScrollY();
            }
            if (scrollView.getScrollY() <= 0 || (scrollView.getScrollY() >= TextPreviewUI.this.bottom - 10 && TextPreviewUI.this.bottom > 0)) {
                TextPreviewUI.m70369h(TextPreviewUI.this);
            } else if (TextPreviewUI.this.vpf) {
                if (i2 > i) {
                    TextPreviewUI.m70369h(TextPreviewUI.this);
                } else if (i2 < i) {
                    TextPreviewUI.m70371j(TextPreviewUI.this);
                }
                TextPreviewUI.this.vpf = false;
            }
            TextPreviewUI.this.f16211yI = i3;
            AppMethodBeat.m2505o(31044);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$1 */
    class C407031 implements OnPreDrawListener {
        C407031() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(31043);
            TextPreviewUI.this.f16210sW.getViewTreeObserver().removeOnPreDrawListener(this);
            if (TextPreviewUI.this.f16210sW.getLineCount() == 1) {
                TextPreviewUI.this.f16210sW.setGravity(1);
            }
            AppMethodBeat.m2505o(31043);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.TextPreviewUI$10 */
    class C4070410 implements C46636v {
        C4070410() {
        }

        /* renamed from: af */
        public final void mo27955af(CharSequence charSequence) {
            AppMethodBeat.m2504i(31054);
            TextPreviewUI.this.yMu = charSequence;
            AppMethodBeat.m2505o(31054);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969075;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(31060);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (C1443d.m3068iW(19)) {
            getWindow().setFlags(67109888, 67109888);
        }
        this.yMv = findViewById(2131822632);
        this.text = getIntent().getCharSequenceExtra("key_chat_text");
        long longExtra = getIntent().getLongExtra("Chat_Msg_Id", 0);
        C9638aw.m17190ZK();
        this.cKd = C18628c.m29080XO().mo15340jf(longExtra);
        this.f16210sW = (TextView) findViewById(2131822635);
        this.yJL = (TextView) findViewById(2131822633);
        CharSequence charSequence = this.text;
        TextView textView = this.yJL;
        if (charSequence instanceof SpannableString) {
            textView.setText(((SpannableString) charSequence).toString());
            C44089j.m79307h(textView, 1);
            charSequence = textView.getText();
        }
        this.text = charSequence;
        this.f16210sW.setText(C9212g.dqQ().mo20622b(this.text, this.f16210sW.getTextSize()));
        this.yMw = findViewById(2131822637);
        this.yMx = this.yMw.findViewById(2131822638);
        this.yMy = (CustomScrollView) findViewById(2131822634);
        this.f16210sW.getViewTreeObserver().addOnPreDrawListener(new C407031());
        this.qzp = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8375cg);
        this.qzo = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8373ce);
        this.yMt = new C24088a(this.mController.ylL, this.f16210sW);
        this.yMt.zSa = true;
        this.yMt.zRZ = new C361188();
        this.yMt.rBm = new C361199();
        if (this.yMs == null && !C1831bh.m3770o(this.cKd)) {
            C40915a c40915a = new C40915a(this.f16210sW, this.yMt);
            c40915a.zWt = C25738R.color.f12291z1;
            c40915a.zWu = C25738R.color.f11905l7;
            this.yMs = c40915a.dLT();
            this.yMs.zWl = new C4070410();
        }
        this.yMv.setOnClickListener(new C1555911());
        this.f16210sW.setOnClickListener(new C3044112());
        if (!C5046bo.isNullOrNil(C1831bh.m3774r(this.cKd))) {
            this.yMw.setVisibility(0);
            this.yMx.setOnClickListener(new C1556013());
        } else if (!C1831bh.m3770o(this.cKd)) {
            ViewStub viewStub = (ViewStub) findViewById(2131822636);
            if (viewStub != null) {
                this.yME = viewStub.inflate();
            }
            this.yMD = (ToolsBar) findViewById(2131828247);
            this.yMD.setVisibility(0);
            if (this.yMD != null) {
                this.yMD.mo56995c(0, new C236875());
                this.yMD.mo56995c(1, new C361176());
                this.yMD.mo56995c(2, new C407017());
            }
        }
        setBackBtn(new C1556114());
        this.yMy.setOnTouchListener(new C4070015());
        this.yMy.setOnScrollChangeListener(new C407022());
        C9638aw.m17182Rg().mo14539a((int) C44699i.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31060);
    }

    public void onResume() {
        AppMethodBeat.m2504i(31061);
        super.onResume();
        if (this.yMs != null) {
            if (!this.yMs.zWC) {
                this.yMs.dLS();
            }
            if (!this.yMs.zWD) {
                this.yMs.dLO();
            }
        }
        AppMethodBeat.m2505o(31061);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(31062);
        finish();
        AppMethodBeat.m2505o(31062);
    }

    /* renamed from: ba */
    private void m70362ba(final C7620bi c7620bi) {
        AppMethodBeat.m2504i(31063);
        final C30578b c30578b = new C30578b(this.mController.ylL);
        c30578b.zaY = new C30581a() {
            /* renamed from: ne */
            public final void mo39544ne(long j) {
                AppMethodBeat.m2504i(31046);
                c30578b.hide();
                C7060h.pYm.mo8378a(795, 1, 1, false);
                if (NetUtil.isConnected(TextPreviewUI.this.mController.ylL)) {
                    bre bre = new bre();
                    bre.lvf = (int) (j / 1000);
                    bre.jCt = 1;
                    bre.wOI = 1;
                    try {
                        String str;
                        bdl bdl = new bdl();
                        bdl.jBB = c7620bi.field_talker;
                        bdl.ptF = c7620bi.field_msgSvrId;
                        TextPreviewUI textPreviewUI = TextPreviewUI.this;
                        C7620bi c7620bi = c7620bi;
                        if (c7620bi.isText() || c7620bi.dtz()) {
                            str = c7620bi.field_content;
                            int ox = C1829bf.m3761ox(str);
                            if (ox != -1) {
                                str = str.substring(ox + 1).trim();
                            }
                        } else {
                            str = AllRemindMsgUI.m48280a(textPreviewUI.mController.ylL, c7620bi.getType(), c7620bi.field_content, c7620bi.field_isSend);
                            C4990ab.m7417i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.getType()), str);
                        }
                        bdl.Title = str;
                        bre.wcJ = new C1332b(bdl.toByteArray());
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.TextPreviewUI", "[onOk] %s", e.toString());
                    }
                    C9638aw.m17182Rg().mo14541a(new C37950w(1, bre), 0);
                    AppMethodBeat.m2505o(31046);
                    return;
                }
                C30379h.m48461b(TextPreviewUI.this.mController.ylL, TextPreviewUI.this.getString(C25738R.string.d5l), TextPreviewUI.this.getString(C25738R.string.dna), true);
                AppMethodBeat.m2505o(31046);
            }

            public final void onCancel() {
                AppMethodBeat.m2504i(31047);
                c30578b.hide();
                AppMethodBeat.m2505o(31047);
            }
        };
        c30578b.show();
        AppMethodBeat.m2505o(31063);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(31064);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b((int) C44699i.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31064);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(31065);
        if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case C44699i.CTRL_INDEX /*525*/:
                    C4990ab.m7416i("MicroMsg.TextPreviewUI", "set msg remind!");
                    C5670b.m8517a(this.mController.ylL, this.mController.ylL.getResources().getString(C25738R.string.cbl), "", null);
                    AppMethodBeat.m2505o(31065);
                    return;
                default:
                    AppMethodBeat.m2505o(31065);
                    return;
            }
        }
        if (c1207m.getType() == C44699i.CTRL_INDEX) {
            C4990ab.m7413e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(C44699i.CTRL_INDEX), Integer.valueOf(i2), Integer.valueOf(i), C5046bo.nullAsNil(str));
            Context context = this.mController.ylL;
            if (C5046bo.isNullOrNil(str)) {
                str = getResources().getString(C25738R.string.dn_);
            }
            C30379h.m48461b(context, str, this.mController.ylL.getResources().getString(C25738R.string.dna), true);
            C7060h.pYm.mo8378a(795, 4, 1, false);
        }
        AppMethodBeat.m2505o(31065);
    }

    /* renamed from: e */
    static /* synthetic */ void m70365e(Context context, CharSequence charSequence) {
        AppMethodBeat.m2504i(31066);
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", charSequence);
        intent.putExtra("Retr_Msg_Type", 4);
        context.startActivity(intent);
        AppMethodBeat.m2505o(31066);
    }

    /* renamed from: h */
    static /* synthetic */ void m70369h(TextPreviewUI textPreviewUI) {
        AppMethodBeat.m2504i(31067);
        if (textPreviewUI.yME != null && C5046bo.isNullOrNil(C1831bh.m3774r(textPreviewUI.cKd))) {
            textPreviewUI.yME.setAnimation(textPreviewUI.qzp);
            textPreviewUI.yME.setVisibility(0);
        }
        AppMethodBeat.m2505o(31067);
    }

    /* renamed from: j */
    static /* synthetic */ void m70371j(TextPreviewUI textPreviewUI) {
        AppMethodBeat.m2504i(31068);
        if (textPreviewUI.yME != null) {
            textPreviewUI.yME.setAnimation(textPreviewUI.qzo);
            textPreviewUI.yME.setVisibility(8);
        }
        AppMethodBeat.m2505o(31068);
    }

    /* renamed from: l */
    static /* synthetic */ void m70373l(TextPreviewUI textPreviewUI) {
        AppMethodBeat.m2504i(31070);
        C45316cl c45316cl = new C45316cl();
        C40443e.m69377d(c45316cl, textPreviewUI.cKd);
        c45316cl.cvA.activity = textPreviewUI;
        c45316cl.cvA.cvH = 43;
        C4879a.xxA.mo10055m(c45316cl);
        AppMethodBeat.m2505o(31070);
    }
}
