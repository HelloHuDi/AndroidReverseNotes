package com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.p069v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C26497b;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32848o;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37754ku;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C23514cc;
import com.tencent.p177mm.storage.C30300cd;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI */
public class VoiceTransTextUI extends MMActivity implements OnClickListener, C1202f {
    /* renamed from: AL */
    private int f4399AL;
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long edW;
    private ScrollView hJh = null;
    private int itR;
    private View kRR = null;
    private C7620bi kua;
    private Button lWE = null;
    private C7306ak mHandler = new C139226();
    private int mTouchSlop;
    private long pDz = 0;
    private C23514cc srD;
    private C35277a srJ;
    private C35278c srK;
    private C39943b srL;
    private C26497b srM;
    private volatile boolean srO = false;
    private boolean srP = false;
    private C7564ap srQ;
    private View svW = null;
    private View svX = null;
    private LinearLayout svY = null;
    private TextView svZ = null;
    private int swa = 6;
    private boolean swb = false;
    private C32849p swc;
    private C4884c swd;
    private boolean swe = false;
    private boolean swf = false;
    private int swg;
    private OnTouchListener swh;
    private OnClickListener swi = new C223621();
    private ClipboardManager swj;
    private OnLongClickListener swk = new C223632();

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$6 */
    class C139226 extends C7306ak {
        C139226() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(25599);
            int i = message.what;
            if (i == 1) {
                VoiceTransTextUI.m34072b(VoiceTransTextUI.this, true);
                AppMethodBeat.m2505o(25599);
                return;
            }
            if (i == 2) {
                VoiceTransTextUI.m34072b(VoiceTransTextUI.this, false);
            }
            AppMethodBeat.m2505o(25599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$8 */
    class C139248 implements Runnable {
        C139248() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25601);
            VoiceTransTextUI.this.hJh.setPadding(0, 0, 0, 0);
            VoiceTransTextUI.this.svY.setGravity(17);
            AppMethodBeat.m2505o(25601);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$b */
    enum C22361b {
        done,
        loading,
        fail;

        static {
            AppMethodBeat.m2505o(25608);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$1 */
    class C223621 implements OnClickListener {
        C223621() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25591);
            VoiceTransTextUI.this.finish();
            AppMethodBeat.m2505o(25591);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$2 */
    class C223632 implements OnLongClickListener {

        /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$2$1 */
        class C139211 implements C30391c {
            C139211() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(25592);
                if (!(i != 0 || VoiceTransTextUI.this.swj == null || VoiceTransTextUI.this.svZ == null)) {
                    VoiceTransTextUI.this.swj.setText(VoiceTransTextUI.this.svZ.getText());
                }
                AppMethodBeat.m2505o(25592);
            }
        }

        C223632() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(25593);
            C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "onLongClick");
            C30379h.m48422a(VoiceTransTextUI.this, "", new String[]{VoiceTransTextUI.this.getString(C25738R.string.f9082oy)}, "", new C139211());
            AppMethodBeat.m2505o(25593);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$3 */
    class C223653 implements OnTouchListener {
        C223653() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(25594);
            switch (motionEvent.getAction()) {
                case 0:
                    VoiceTransTextUI.m34074c(VoiceTransTextUI.this);
                    VoiceTransTextUI.this.itR = view.getScrollY();
                    VoiceTransTextUI.this.f4399AL = VoiceTransTextUI.this.itR;
                    VoiceTransTextUI.this.mHandler.removeMessages(0);
                    if (VoiceTransTextUI.this.swe) {
                        VoiceTransTextUI.this.swe = false;
                        VoiceTransTextUI.this.swf = true;
                        break;
                    }
                    break;
                case 1:
                case 3:
                case 4:
                    if (Math.abs(VoiceTransTextUI.this.f4399AL - view.getScrollY()) > VoiceTransTextUI.this.mTouchSlop) {
                        VoiceTransTextUI.this.mHandler.sendMessage(VoiceTransTextUI.this.mHandler.obtainMessage(0, view));
                    }
                    if (VoiceTransTextUI.m34081j(VoiceTransTextUI.this) < 800 && Math.abs(VoiceTransTextUI.this.f4399AL - view.getScrollY()) <= VoiceTransTextUI.this.mTouchSlop && !VoiceTransTextUI.this.swf) {
                        VoiceTransTextUI.this.mHandler.removeMessages(0);
                        VoiceTransTextUI.m34083l(VoiceTransTextUI.this);
                        VoiceTransTextUI.this.finish();
                    }
                    VoiceTransTextUI.this.swf = false;
                    break;
            }
            AppMethodBeat.m2505o(25594);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$5 */
    class C223665 extends C4884c<C37754ku> {

        /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$5$1 */
        class C223671 implements Runnable {
            C223671() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25596);
                C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
                if (VoiceTransTextUI.this.srQ != null) {
                    VoiceTransTextUI.this.srQ.stopTimer();
                }
                VoiceTransTextUI.m34068a(VoiceTransTextUI.this, C22368a.GET);
                AppMethodBeat.m2505o(25596);
            }
        }

        C223665() {
            AppMethodBeat.m2504i(25597);
            this.xxI = C37754ku.class.getName().hashCode();
            AppMethodBeat.m2505o(25597);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25598);
            C37754ku c37754ku = (C37754ku) c4883b;
            C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
            if (VoiceTransTextUI.this.srJ != null && !VoiceTransTextUI.this.srP && (c37754ku instanceof C37754ku) && c37754ku.cGJ.cGK == VoiceTransTextUI.this.srJ.svU) {
                C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "");
                if (VoiceTransTextUI.this.srO) {
                    C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                    VoiceTransTextUI.this.swb = true;
                } else {
                    new C7306ak(VoiceTransTextUI.this.getMainLooper()).post(new C223671());
                }
            }
            AppMethodBeat.m2505o(25598);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$a */
    enum C22368a {
        CHECK,
        UPLOAD,
        UPLOAD_MORE,
        GET;

        static {
            AppMethodBeat.m2505o(25605);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VoiceTransTextUI() {
        AppMethodBeat.m2504i(25609);
        AppMethodBeat.m2505o(25609);
    }

    public void onCreate(Bundle bundle) {
        int i;
        C23514cc c23514cc = null;
        AppMethodBeat.m2504i(25610);
        super.onCreate(bundle);
        this.mTouchSlop = ViewConfiguration.get(this.mController.ylL).getScaledTouchSlop();
        this.swj = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        this.kRR = findViewById(2131828481);
        this.svW = findViewById(2131828486);
        this.svX = findViewById(2131828488);
        this.svZ = (TextView) findViewById(2131828485);
        this.lWE = (Button) findViewById(2131828483);
        this.svY = (LinearLayout) findViewById(2131828482);
        this.hJh = (ScrollView) findViewById(2131822634);
        this.swh = new C223653();
        this.svZ.setOnLongClickListener(this.swk);
        this.svZ.setOnClickListener(this.swi);
        this.edW = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.edW < 0) {
            i = 0;
        } else {
            C4990ab.m7417i("MicroMsg.VoiceTransTextUI", "msg Id:%d", Long.valueOf(this.edW));
            C30300cd amb = C26500m.amb();
            if (this.edW >= 0) {
                C23514cc c23514cc2 = new C23514cc();
                Cursor a = amb.bSd.mo10105a("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(r6)}, null, null, null, 2);
                if (a.moveToFirst()) {
                    c23514cc2.mo8995d(a);
                }
                a.close();
                c23514cc = c23514cc2;
            }
            this.srD = c23514cc;
            if (this.srD == null || C5046bo.isNullOrNil(this.srD.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (C5046bo.isNullOrNil(string)) {
                    i = 0;
                } else {
                    this.swc = C26500m.ama().mo33987uZ(string);
                    if (this.swc != null) {
                        C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        i = 1;
                    } else {
                        C9638aw.m17190ZK();
                        this.kua = C18628c.m29080XO().mo15340jf(this.edW);
                        if (this.kua != null) {
                            C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                }
            } else {
                C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                i = 1;
            }
        }
        if (i == 0) {
            C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            AppMethodBeat.m2505o(25610);
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        initView();
        AppMethodBeat.m2505o(25610);
    }

    public final int getLayoutId() {
        return 2130971028;
    }

    public final void initView() {
        Object obj;
        AppMethodBeat.m2504i(25611);
        setMMTitle((int) C25738R.string.f3i);
        this.lWE.setOnClickListener(this);
        if (this.srD == null || C5046bo.isNullOrNil(this.srD.field_content)) {
            obj = null;
        } else {
            m34067a(C22361b.done, this.srD.field_content);
            if (!(this.hJh == null || this.svY == null)) {
                this.mHandler.postDelayed(new C139248(), 5);
            }
            obj = 1;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(25611);
            return;
        }
        m34067a(C22361b.loading, null);
        m34066a(C22368a.CHECK);
        AppMethodBeat.m2505o(25611);
    }

    /* renamed from: a */
    private void m34066a(C22368a c22368a) {
        AppMethodBeat.m2504i(25612);
        cDU();
        switch (c22368a) {
            case CHECK:
                C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "net check");
                if (m34063HB() > 0) {
                    C4990ab.m7417i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", Long.valueOf(m34063HB()));
                    this.srJ = new C35277a(cDV(), cDW(), cDX().getFormat(), m34063HB(), getFileName());
                } else {
                    C4990ab.m7417i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", Long.valueOf(m34063HB()));
                    this.srJ = new C35277a(cDV(), cDW(), getFileName());
                }
                C9638aw.m17182Rg().mo14541a(this.srJ, 0);
                C9638aw.m17182Rg().mo14539a(this.srJ.getType(), (C1202f) this);
                if (this.swd == null) {
                    cDY();
                    AppMethodBeat.m2505o(25612);
                    return;
                }
                break;
            case UPLOAD:
                C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.srJ == null) {
                    C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    AppMethodBeat.m2505o(25612);
                    return;
                } else if (cDX() == null) {
                    C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
                    AppMethodBeat.m2505o(25612);
                    return;
                } else {
                    this.srK = new C35278c(cDV(), this.srJ.svS, cDX().getFormat(), getFileName());
                    C9638aw.m17182Rg().mo14541a(this.srK, 0);
                    C9638aw.m17182Rg().mo14539a(this.srK.getType(), (C1202f) this);
                    AppMethodBeat.m2505o(25612);
                    return;
                }
            case UPLOAD_MORE:
                C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.srK == null) {
                    C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    AppMethodBeat.m2505o(25612);
                    return;
                }
                this.srK = new C35278c(this.srK);
                C9638aw.m17182Rg().mo14541a(this.srK, 0);
                C9638aw.m17182Rg().mo14539a(this.srK.getType(), (C1202f) this);
                AppMethodBeat.m2505o(25612);
                return;
            case GET:
                this.swb = false;
                if (!this.srO) {
                    C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "net get");
                    if (this.srJ != null) {
                        this.srO = true;
                        this.srL = new C39943b(cDV());
                        C9638aw.m17182Rg().mo14541a(this.srL, 0);
                        C9638aw.m17182Rg().mo14539a(this.srL.getType(), (C1202f) this);
                        break;
                    }
                    C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                    AppMethodBeat.m2505o(25612);
                    return;
                }
                C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                AppMethodBeat.m2505o(25612);
                return;
        }
        AppMethodBeat.m2505o(25612);
    }

    /* renamed from: a */
    private void m34067a(C22361b c22361b, String str) {
        AppMethodBeat.m2504i(25613);
        while (true) {
            switch (c22361b) {
                case done:
                    if (!C5046bo.isNullOrNil(str)) {
                        this.svY.setVisibility(0);
                        this.svW.setVisibility(8);
                        this.lWE.setVisibility(4);
                        this.svX.setVisibility(8);
                        this.svZ.setText(str);
                        m34084lZ(true);
                        break;
                    }
                    c22361b = C22361b.fail;
                    str = null;
                case loading:
                    this.svY.setVisibility(0);
                    this.svW.setVisibility(0);
                    this.lWE.setVisibility(0);
                    if (str != null) {
                        this.svZ.setText(str);
                        m34084lZ(false);
                        break;
                    }
                    break;
                case fail:
                    this.svY.setVisibility(8);
                    this.svW.setVisibility(8);
                    this.lWE.setHeight(0);
                    this.lWE.setVisibility(8);
                    this.svX.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        if (c22361b == C22361b.done || c22361b == C22361b.fail) {
            this.hJh.setOnTouchListener(this.swh);
            this.kRR.setOnClickListener(this.swi);
            AppMethodBeat.m2505o(25613);
            return;
        }
        this.hJh.setOnTouchListener(null);
        this.kRR.setOnClickListener(null);
        AppMethodBeat.m2505o(25613);
    }

    private void cDU() {
        AppMethodBeat.m2504i(25614);
        C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.srJ != null) {
            C9638aw.m17182Rg().mo14547c(this.srJ);
            C9638aw.m17182Rg().mo14546b(this.srJ.getType(), (C1202f) this);
        }
        if (this.srK != null) {
            C9638aw.m17182Rg().mo14547c(this.srK);
            C9638aw.m17182Rg().mo14546b(this.srK.getType(), (C1202f) this);
        }
        if (this.srL != null) {
            C9638aw.m17182Rg().mo14547c(this.srL);
            C9638aw.m17182Rg().mo14546b(this.srL.getType(), (C1202f) this);
        }
        AppMethodBeat.m2505o(25614);
    }

    private String cDV() {
        AppMethodBeat.m2504i(25615);
        String str;
        if (this.swc != null) {
            str = this.swc.clientId;
            AppMethodBeat.m2505o(25615);
            return str;
        }
        str = this.kua.field_talker + this.kua.field_msgId + "T" + this.kua.field_createTime;
        AppMethodBeat.m2505o(25615);
        return str;
    }

    private C23514cc abi(String str) {
        AppMethodBeat.m2504i(25616);
        C23514cc c23514cc = new C23514cc();
        c23514cc.field_msgId = this.edW;
        c23514cc.aqa(cDV());
        c23514cc.field_content = str;
        AppMethodBeat.m2505o(25616);
        return c23514cc;
    }

    private int cDW() {
        AppMethodBeat.m2504i(25617);
        int i;
        if (this.swc != null) {
            i = this.swc.frO;
            AppMethodBeat.m2505o(25617);
            return i;
        }
        i = C32848o.m53701uj(this.kua.field_imgPath);
        AppMethodBeat.m2505o(25617);
        return i;
    }

    /* renamed from: HB */
    private long m34063HB() {
        return this.swc == null ? -1 : this.swc.cKK;
    }

    private String getFileName() {
        if (this.swc != null) {
            return this.swc.fileName;
        }
        return this.kua.field_imgPath;
    }

    private C26497b cDX() {
        AppMethodBeat.m2504i(25618);
        if (this.srM == null) {
            if (this.swc != null) {
                this.srM = C32850q.m53727uN(this.swc.fileName);
            } else if (this.kua != null) {
                this.srM = C32850q.m53727uN(this.kua.field_imgPath);
            } else {
                C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
        }
        C26497b c26497b = this.srM;
        AppMethodBeat.m2505o(25618);
        return c26497b;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        String str2 = null;
        AppMethodBeat.m2504i(25619);
        if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 546:
                    if (this.srJ.mState == C35277a.svQ) {
                        C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.srJ.cDR()) {
                            str2 = this.srJ.svR.xlH;
                        }
                        abs(str2);
                        AppMethodBeat.m2505o(25619);
                        return;
                    } else if (this.srJ.mState == C35277a.svP) {
                        if (this.srJ.svR != null && C5046bo.isNullOrNil(this.srJ.svR.xlH)) {
                            m34067a(C22361b.loading, this.srJ.svR.xlH);
                        }
                        C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        m34066a(C22368a.GET);
                        AppMethodBeat.m2505o(25619);
                        return;
                    } else if (this.srJ.mState == C35277a.svO) {
                        C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        m34066a(C22368a.UPLOAD);
                        AppMethodBeat.m2505o(25619);
                        return;
                    } else if (this.srJ.svT != null) {
                        this.swa = this.srJ.svT.wRe;
                        AppMethodBeat.m2505o(25619);
                        return;
                    }
                    break;
                case 547:
                    if (this.srK.cDT()) {
                        C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        m34066a(C22368a.GET);
                        AppMethodBeat.m2505o(25619);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", Integer.valueOf(this.srK.svS.ptx), Integer.valueOf(this.srK.svS.pty));
                    m34066a(C22368a.UPLOAD_MORE);
                    AppMethodBeat.m2505o(25619);
                    return;
                case 548:
                    this.swa = this.srL.svV;
                    this.srO = false;
                    if (!this.srL.isComplete() && this.srL.cDR()) {
                        m34067a(C22361b.loading, this.srL.svR.xlH);
                        C4990ab.m7411d("MicroMsg.VoiceTransTextUI", "result valid:%s", this.srL.svR.xlH);
                    } else if (!this.srL.cDR()) {
                        C4990ab.m7410d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.srL.isComplete()) {
                        C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.srL.cDR()) {
                            str2 = this.srL.svR.xlH;
                        }
                        abs(str2);
                        AppMethodBeat.m2505o(25619);
                        return;
                    } else if (this.swb) {
                        C4990ab.m7416i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        m34066a(C22368a.GET);
                        AppMethodBeat.m2505o(25619);
                        return;
                    } else {
                        C4990ab.m7417i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", Integer.valueOf(this.swa));
                        final int i3 = this.swa;
                        if (!this.srP) {
                            if (this.srQ == null) {
                                this.srQ = new C7564ap(new C5015a() {
                                    /* renamed from: BI */
                                    public final boolean mo4499BI() {
                                        AppMethodBeat.m2504i(25595);
                                        if (VoiceTransTextUI.this.srP) {
                                            AppMethodBeat.m2505o(25595);
                                        } else {
                                            C4990ab.m7411d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", Integer.valueOf(i3));
                                            VoiceTransTextUI.m34068a(VoiceTransTextUI.this, C22368a.GET);
                                            AppMethodBeat.m2505o(25595);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i3 * 1000);
                            this.srQ.mo16770ae(j, j);
                        }
                        AppMethodBeat.m2505o(25619);
                        return;
                    }
                default:
                    AppMethodBeat.m2505o(25619);
                    return;
            }
        }
        this.srP = true;
        m34067a(C22361b.fail, null);
        AppMethodBeat.m2505o(25619);
    }

    private void abs(String str) {
        AppMethodBeat.m2504i(25620);
        this.srP = true;
        if (!C5046bo.isNullOrNil(str)) {
            C26500m.amb().mo48507a(abi(str));
        }
        m34067a(C22361b.done, str);
        AppMethodBeat.m2505o(25620);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25621);
        cDU();
        if (this.srQ != null) {
            this.srQ.stopTimer();
        }
        if (this.swd != null) {
            C4879a.xxA.mo10053d(this.swd);
            this.swd = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(25621);
    }

    private void cDY() {
        AppMethodBeat.m2504i(25622);
        if (this.swd == null) {
            this.swd = new C223665();
        }
        C4879a.xxA.mo10052c(this.swd);
        AppMethodBeat.m2505o(25622);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(25623);
        finish();
        AppMethodBeat.m2505o(25623);
    }

    /* renamed from: lZ */
    private void m34084lZ(final boolean z) {
        AppMethodBeat.m2504i(25624);
        if (this.hJh == null || this.svY == null) {
            AppMethodBeat.m2505o(25624);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(25600);
                if (VoiceTransTextUI.this.hJh.getMeasuredHeight() >= VoiceTransTextUI.this.svY.getMeasuredHeight()) {
                    VoiceTransTextUI.this.hJh.fullScroll(130);
                    int scrollY = VoiceTransTextUI.this.hJh.getScrollY();
                    VoiceTransTextUI.this.swg = VoiceTransTextUI.this.hJh.getPaddingTop();
                    VoiceTransTextUI.this.swg = VoiceTransTextUI.this.swg - scrollY;
                    if (z) {
                        VoiceTransTextUI.this.hJh.setPadding(0, 0, 0, 0);
                        VoiceTransTextUI.this.lWE.setVisibility(8);
                        VoiceTransTextUI.this.lWE.setHeight(0);
                    } else if (VoiceTransTextUI.this.swg > 0) {
                        VoiceTransTextUI.this.hJh.setPadding(0, VoiceTransTextUI.this.swg, 0, 0);
                        AppMethodBeat.m2505o(25600);
                        return;
                    }
                }
                AppMethodBeat.m2505o(25600);
            }
        }, 5);
        AppMethodBeat.m2505o(25624);
    }

    /* renamed from: c */
    static /* synthetic */ void m34074c(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.m2504i(25625);
        voiceTransTextUI.pDz = C5046bo.m7588yz();
        AppMethodBeat.m2505o(25625);
    }

    /* renamed from: j */
    static /* synthetic */ long m34081j(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.m2504i(25626);
        long yz = C5046bo.m7588yz() - voiceTransTextUI.pDz;
        AppMethodBeat.m2505o(25626);
        return yz;
    }

    /* renamed from: l */
    static /* synthetic */ void m34083l(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.m2504i(25627);
        voiceTransTextUI.itR = 0;
        voiceTransTextUI.f4399AL = 0;
        voiceTransTextUI.swe = false;
        voiceTransTextUI.swf = false;
        voiceTransTextUI.mHandler.removeMessages(0);
        AppMethodBeat.m2505o(25627);
    }
}
