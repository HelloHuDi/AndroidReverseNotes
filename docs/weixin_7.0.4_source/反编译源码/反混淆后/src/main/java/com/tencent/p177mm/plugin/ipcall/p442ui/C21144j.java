package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.ipcall.C28336c;
import com.tencent.p177mm.plugin.ipcall.C34383e;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.C46032c;
import com.tencent.p177mm.plugin.ipcall.p438a.C46037f;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C34367b.C34368a;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C39254a;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C3304a;
import com.tencent.p177mm.plugin.ipcall.p442ui.DialPad.C34384a;
import com.tencent.p177mm.plugin.ipcall.p442ui.IPCallFuncButton.C12266a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.j */
public final class C21144j implements C34368a, C34383e {
    ImageView eks;
    private String gHT;
    private TextView gnh;
    private String nCh;
    private String nCi;
    private String nCj;
    private String nCk;
    private int nCl;
    private int nCm;
    private ImageButton nGA;
    public TextView nGB;
    public View nGC;
    private ImageButton nGD;
    private int nGE = -1;
    String nGF;
    IPCallTalkUI nGG;
    C28336c nGH;
    C21148a nGI;
    private long nGJ;
    long nGK = -1;
    boolean nGL = false;
    boolean nGM = false;
    private AudioManager nGN = null;
    private boolean nGO = false;
    private boolean nGP = true;
    private boolean nGQ = false;
    Bitmap nGl;
    EditText nGu;
    TextView nGv;
    ImageView nGw;
    private IPCallFuncButton nGx;
    private IPCallFuncButton nGy;
    private IPCallFuncButton nGz;
    DialPad nzR;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$4 */
    class C123274 implements OnClickListener {
        C123274() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22402);
            C21144j.this.nGG.finish();
            AppMethodBeat.m2505o(22402);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$2 */
    class C211432 implements C34384a {
        C211432() {
        }

        /* renamed from: OX */
        public final void mo24177OX(String str) {
            AppMethodBeat.m2504i(22400);
            String obj = C21144j.this.nGu.getText().toString();
            if (C5046bo.isNullOrNil(obj)) {
                C21144j.this.nGK = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - C21144j.this.nGK >= 3000) {
                obj = obj + " ";
            }
            obj = obj + str;
            C21144j.this.nGK = currentTimeMillis;
            C21144j.this.mo36471eN(obj, "");
            C28336c.m44955OL(str);
            C7060h.pYm.mo8381e(12057, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            AppMethodBeat.m2505o(22400);
        }

        /* renamed from: OY */
        public final void mo24178OY(String str) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$12 */
    class C2114512 implements View.OnClickListener {
        C2114512() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22410);
            C21144j.m32479b(C21144j.this);
            AppMethodBeat.m2505o(22410);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$3 */
    class C211463 implements OnClickListener {
        C211463() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22401);
            C4990ab.m7416i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
            C21144j.m32479b(C21144j.this);
            AppMethodBeat.m2505o(22401);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$5 */
    class C211475 implements OnClickListener {
        C211475() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22403);
            C21144j.this.nGG.finish();
            AppMethodBeat.m2505o(22403);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$a */
    public interface C21148a {
        /* renamed from: ix */
        void mo24158ix(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$6 */
    class C211496 implements OnClickListener {
        C211496() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22404);
            C21144j.this.nGG.finish();
            C21144j.this.nGG = null;
            AppMethodBeat.m2505o(22404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$7 */
    class C211507 implements OnClickListener {
        C211507() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22405);
            C21144j.this.nGG.finish();
            AppMethodBeat.m2505o(22405);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$9 */
    class C211519 implements C12266a {
        C211519() {
        }

        /* renamed from: iv */
        public final void mo24103iv(boolean z) {
            AppMethodBeat.m2504i(22407);
            C4990ab.m7411d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", Boolean.valueOf(z));
            if (C21088i.bHu().bHl()) {
                C21144j.this.nGL = z;
                C21144j.this.nGM = z;
                C21088i.bHt().mo54898io(z);
                C7060h.pYm.mo8381e(12057, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
                AppMethodBeat.m2505o(22407);
                return;
            }
            if (!(C21088i.bHA().mo38019DB() || C21088i.bHu().bHn())) {
                C21088i.bHA().mo38024mE(z);
            }
            AppMethodBeat.m2505o(22407);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$11 */
    class C2115211 implements C12266a {
        C2115211() {
        }

        /* renamed from: iv */
        public final void mo24103iv(boolean z) {
            AppMethodBeat.m2504i(22409);
            C21144j c21144j;
            if (z) {
                c21144j = C21144j.this;
                if (c21144j.nGl == null) {
                    c21144j.eks.setVisibility(8);
                } else {
                    c21144j.eks.setVisibility(4);
                }
                c21144j.eks.setVisibility(8);
                c21144j.nGw.setVisibility(8);
                c21144j.nGu.setText("");
                c21144j.nGv.setText("");
                c21144j.nzR.setVisibility(0);
            } else {
                c21144j = C21144j.this;
                if (c21144j.nGl != null) {
                    c21144j.eks.setVisibility(0);
                    c21144j.nGw.setVisibility(8);
                } else {
                    c21144j.nGw.setVisibility(0);
                    c21144j.eks.setVisibility(8);
                }
                c21144j.mo36461Pm(c21144j.nGF);
                c21144j.nzR.setVisibility(4);
            }
            C7060h.pYm.mo8381e(12057, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
            AppMethodBeat.m2505o(22409);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$10 */
    class C2115310 implements C12266a {
        C2115310() {
        }

        /* renamed from: iv */
        public final void mo24103iv(boolean z) {
            AppMethodBeat.m2504i(22408);
            if (C21088i.bHu().bHm()) {
                int appCmd;
                C4990ab.m7411d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", Boolean.valueOf(z));
                C3304a bHr = C21088i.bHr();
                if (z) {
                    appCmd = bHr.nxx.setAppCmd(412);
                } else {
                    appCmd = bHr.nxx.setAppCmd(413);
                }
                if (appCmd < 0) {
                    C4990ab.m7412e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(appCmd)));
                }
                C21088i.bHt().nxg.setMute(z);
                C7060h.pYm.mo8381e(12057, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(22408);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$1 */
    class C211541 implements OnClickListener {
        C211541() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22399);
            C21144j.this.nGG.finish();
            AppMethodBeat.m2505o(22399);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.j$8 */
    class C211558 implements View.OnClickListener {
        C211558() {
        }

        /* JADX WARNING: Missing block: B:15:0x0064, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(22406);
     */
        /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            AppMethodBeat.m2504i(22406);
            C28336c bHv = C21088i.bHv();
            synchronized (bHv.meM) {
                try {
                    if (C21088i.bHu().bHk()) {
                        if (bHv.nvf) {
                            bHv.bGS();
                        } else {
                            bHv.nvf = true;
                            Toast.makeText(C4996ah.getContext(), C25738R.string.d2y, 0).show();
                            Intent intent = new Intent();
                            intent.setFlags(268435456);
                            intent.setClass(C4996ah.getContext(), IPCallTalkUI.class);
                            intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
                            C43727b.cIk().mo63354a(intent, bHv.nvg);
                            bHv.bGS();
                            if (bHv.nuX != null) {
                                bHv.nuX.bGZ();
                            }
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(22406);
                }
            }
        }
    }

    public C21144j(IPCallTalkUI iPCallTalkUI) {
        AppMethodBeat.m2504i(22411);
        this.nGG = iPCallTalkUI;
        this.nGH = C21088i.bHv();
        this.nGH.nuX = this;
        AppMethodBeat.m2505o(22411);
    }

    /* renamed from: b */
    public final void mo36462b(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        AppMethodBeat.m2504i(22412);
        this.nGO = this.nGG.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        C4990ab.m7417i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", str, str2, str3, str4, str5, Boolean.valueOf(this.nGO));
        this.nGw = (ImageView) this.nGG.findViewById(2131825098);
        this.eks = (ImageView) this.nGG.findViewById(2131825099);
        this.nGu = (EditText) this.nGG.findViewById(2131825091);
        this.gnh = (TextView) this.nGG.findViewById(2131825088);
        this.nGv = (TextView) this.nGG.findViewById(2131825096);
        this.nGx = (IPCallFuncButton) this.nGG.findViewById(2131825093);
        this.nGy = (IPCallFuncButton) this.nGG.findViewById(2131825094);
        this.nGz = (IPCallFuncButton) this.nGG.findViewById(2131825095);
        this.nGA = (ImageButton) this.nGG.findViewById(2131825100);
        this.nGD = (ImageButton) this.nGG.findViewById(2131825101);
        this.nGB = (TextView) this.nGG.findViewById(2131825090);
        this.nGC = this.nGG.findViewById(2131825089);
        this.nzR = (DialPad) this.nGG.findViewById(2131825087);
        if (this.nGO) {
            bIG();
            bIB();
            bIC();
            bIH();
            AppMethodBeat.m2505o(22412);
        } else if (C21088i.bHu().bHk()) {
            C30379h.m48433a(this.nGG, (int) C25738R.string.cdr, (int) C25738R.string.f9238tz, false, new C211541());
            AppMethodBeat.m2505o(22412);
        } else {
            bIB();
            this.gHT = str;
            this.nCh = str2;
            this.nCi = str3;
            this.nCj = str4;
            this.nCl = i;
            this.nCm = i2;
            if (!C5046bo.isNullOrNil(this.nCh)) {
                this.nCh = C34382c.m56377PA(this.nCh);
            }
            if (C5046bo.isNullOrNil(this.nCj)) {
                if (C46041a.m85635Pu(this.nCh)) {
                    String Ps = C46041a.m85633Ps(this.nCh);
                    if (C5046bo.isNullOrNil(Ps)) {
                        this.nCh = C46041a.m85636Pv(this.nCh);
                    } else {
                        this.nCh = C46041a.m85638Px(this.nCh);
                        this.nCj = Ps;
                    }
                }
                this.nCj = C34382c.bIR();
            }
            C4990ab.m7417i("MicroMsg.TalkUIController", "final mCountryCode: %s", this.nCj);
            C46032c.bHc().mo73922ON(this.nCj);
            if (C5046bo.isNullOrNil(this.gHT)) {
                this.gHT = C46041a.m85641aF(this.nGG, this.nCh);
            }
            this.nCk = str5;
            bIA();
            C4990ab.m7417i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", this.nGF);
            if (C46032c.bHc().mo73925xf(C5046bo.getInt(this.nCj, -1))) {
                bIz();
                AppMethodBeat.m2505o(22412);
            } else if (C5023at.isNetworkConnected(this.nGG)) {
                long j = this.nGG.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
                if (j <= System.currentTimeMillis() || j == -1) {
                    bIC();
                    if (!(this.nGO && C21088i.bHu().bHk())) {
                        bIF();
                    }
                    this.nGQ = false;
                    AppMethodBeat.m2505o(22412);
                    return;
                }
                C4990ab.m7416i("MicroMsg.TalkUIController", "onDisasterHappen");
                C30379h.m48447a(this.nGG, this.nGG.getString(C25738R.string.cgl, new Object[]{String.valueOf(((j - r6) / 1000) + 1)}), this.nGG.getString(C25738R.string.cgb), this.nGG.getString(C25738R.string.cgc), false, new C211475());
                AppMethodBeat.m2505o(22412);
            } else {
                Toast.makeText(this.nGG, C25738R.string.f6c, 1).show();
                this.nGG.finish();
                AppMethodBeat.m2505o(22412);
            }
        }
    }

    private void bIz() {
        AppMethodBeat.m2504i(22413);
        C7060h.pYm.mo8374X(12058, this.nCj);
        C30379h.m48448a(this.nGG, this.nGG.getString(C25738R.string.abs), this.nGG.getString(C25738R.string.abt), false, new C211496());
        AppMethodBeat.m2505o(22413);
    }

    /* renamed from: c */
    private void m32480c(String str, String str2, int i, String str3) {
        String str4;
        AppMethodBeat.m2504i(22414);
        bIK();
        if (!C5046bo.isNullOrNil(str)) {
            str4 = str;
        } else if (C5046bo.isNullOrNil(str3)) {
            str4 = this.nGG.getString(C25738R.string.cgb);
        } else {
            str4 = str3;
        }
        if (2 != i || str2 == null) {
            if (1 == i && str2 != null) {
                C30379h.m48447a(this.nGG, str2, str4, this.nGG.getString(C25738R.string.cgc), false, new C211507());
            }
            AppMethodBeat.m2505o(22414);
            return;
        }
        this.gnh.setText(str2);
        AppMethodBeat.m2505o(22414);
    }

    private void bIA() {
        AppMethodBeat.m2504i(22415);
        if (C5046bo.isNullOrNil(this.nCj) || C46041a.m85635Pu(this.nCh)) {
            this.nGF = this.nCh;
        } else {
            this.nGF = this.nCj + this.nCh;
            if (!this.nGF.startsWith("+")) {
                this.nGF = "+" + this.nGF;
                AppMethodBeat.m2505o(22415);
                return;
            }
        }
        AppMethodBeat.m2505o(22415);
    }

    private void bIB() {
        AppMethodBeat.m2504i(22416);
        C21088i.bHt().crP = this.nGG;
        C21088i.bHt().bHI();
        C21088i.bHt().nxk = this;
        C21088i.bHt().mo54895a(this);
        AppMethodBeat.m2505o(22416);
    }

    private void bIC() {
        AppMethodBeat.m2504i(22417);
        this.nGu.setKeyListener(null);
        this.nGu.setHorizontallyScrolling(true);
        this.nzR.setVisibility(4);
        this.nzR.setTalkUIMode(true);
        bID();
        bIE();
        AppMethodBeat.m2505o(22417);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Pm */
    public final void mo36461Pm(String str) {
        AppMethodBeat.m2504i(22418);
        if (C5046bo.isNullOrNil(this.gHT)) {
            mo36471eN(C46041a.m85637Pw(str), "");
            AppMethodBeat.m2505o(22418);
            return;
        }
        mo36471eN(this.gHT, C46041a.m85637Pw(str));
        AppMethodBeat.m2505o(22418);
    }

    private void bID() {
        AppMethodBeat.m2504i(22419);
        if (!C5046bo.isNullOrNil(this.nGF)) {
            mo36461Pm(this.nGF);
        }
        if (C1443d.m3068iW(16)) {
            this.nGu.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nGv.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!C5046bo.isNullOrNil(this.nCi)) {
            this.nGl = C46041a.m85647g(this.nGG, this.nCi, true);
        }
        if (this.nGl == null && !C5046bo.isNullOrNil(this.nCh) && C46041a.apV()) {
            this.nGl = C46041a.m85644aI(this.nGG, this.nCh);
        }
        if (this.nGl == null && !C5046bo.isNullOrNil(this.nCk)) {
            this.nGl = C41730b.m73493d(this.nCk, 480, 480, 4);
        }
        if (this.nGl == null) {
            this.nGw.setVisibility(0);
            this.eks.setVisibility(8);
        }
        if (this.nGl != null) {
            this.nGw.setVisibility(8);
            this.eks.setVisibility(0);
            this.eks.setImageBitmap(this.nGl);
        }
        this.nGD.setOnClickListener(new C211558());
        this.nGz.setClickCallback(new C211519());
        this.nGx.setClickCallback(new C2115310());
        this.nGy.setClickCallback(new C2115211());
        this.nGA.setOnClickListener(new C2114512());
        AppMethodBeat.m2505o(22419);
    }

    private void bIE() {
        AppMethodBeat.m2504i(22420);
        this.nzR.setDialButtonClickListener(new C211432());
        AppMethodBeat.m2505o(22420);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eN */
    public final void mo36471eN(String str, String str2) {
        AppMethodBeat.m2504i(22421);
        this.nGu.setText(str);
        if (!C5046bo.isNullOrNil(str)) {
            this.nGu.setSelection(this.nGu.getText().length() - 1);
        }
        this.nGv.setText(str2);
        AppMethodBeat.m2505o(22421);
    }

    private void bIF() {
        AppMethodBeat.m2504i(22422);
        this.nGE = C46041a.m85645eO(this.nCi, this.nCh);
        m32481xw(1);
        this.nGH.mo46252a(this.gHT, this.nCh, this.nCk, this.nGF, this.nCi, this.nGE, this.nCl, this.nCm);
        C4990ab.m7417i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", this.nGF);
        C21088i.bHs().setCountryCode(this.nCj);
        AppMethodBeat.m2505o(22422);
    }

    private void bIG() {
        AppMethodBeat.m2504i(22423);
        if (C21088i.bHq().nvN != null) {
            this.gHT = C21088i.bHq().nvN.nickname;
            this.nGF = C21088i.bHq().nvN.nwW;
            this.nCk = C21088i.bHq().nvN.cMr;
            this.nCi = C21088i.bHq().nvN.cOz;
            this.nCh = C21088i.bHq().nvN.nwV;
            this.nGE = C21088i.bHq().nvN.nwY;
            C4990ab.m7417i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", this.gHT, this.nGF, this.nCk, this.nCi, this.nCh, Integer.valueOf(this.nGE));
        }
        AppMethodBeat.m2505o(22423);
    }

    private void bIH() {
        AppMethodBeat.m2504i(22424);
        C21088i.bHu();
        C4990ab.m7416i("MicroMsg.TalkUIController", C46037f.stateToString(C21088i.bHu().mCurrentState));
        m32481xw(C21088i.bHu().mCurrentState);
        bIJ();
        bII();
        AppMethodBeat.m2505o(22424);
    }

    private void bII() {
        AppMethodBeat.m2504i(22425);
        if (C21088i.bHu().bHl()) {
            IPCallFuncButton iPCallFuncButton = this.nGz;
            C21088i.bHt();
            iPCallFuncButton.setChecked(C39254a.m66900KU());
            this.nGx.setChecked(C21088i.bHt().nxg.eif);
        }
        AppMethodBeat.m2505o(22425);
    }

    private void bIJ() {
        AppMethodBeat.m2504i(22426);
        String str = C21088i.bHq().nvN.nwW;
        String str2 = C21088i.bHq().nvN.nwX;
        if (C5046bo.isNullOrNil(str2)) {
            if (!C5046bo.isNullOrNil(str)) {
                mo36461Pm(str);
                this.nGv.setText(C46041a.m85637Pw(str));
            }
            AppMethodBeat.m2505o(22426);
            return;
        }
        mo36461Pm(str2);
        this.nGv.setText(C46041a.m85637Pw(str2));
        AppMethodBeat.m2505o(22426);
    }

    /* renamed from: xw */
    private void m32481xw(int i) {
        AppMethodBeat.m2504i(22427);
        switch (i) {
            case 1:
                AppMethodBeat.m2505o(22427);
                return;
            case 3:
                String xz = C34382c.m56390xz(C21088i.bHq().nvN.nwK);
                if (this.nGE != -1) {
                    String xx = C46041a.m85648xx(this.nGE);
                    this.gnh.setText(xz + this.nGG.getString(C25738R.string.ci3, new Object[]{xx}));
                    AppMethodBeat.m2505o(22427);
                    return;
                }
                this.gnh.setText(xz + this.nGG.getString(C25738R.string.ci2));
                AppMethodBeat.m2505o(22427);
                return;
            case 4:
                AppMethodBeat.m2505o(22427);
                return;
            case 5:
                this.gnh.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(this.nGJ / 60), Long.valueOf(this.nGJ % 60)}));
                AppMethodBeat.m2505o(22427);
                return;
            case 10:
                this.gnh.setText(C25738R.string.ci6);
                break;
        }
        AppMethodBeat.m2505o(22427);
    }

    public final void bGJ() {
        int i = 0;
        AppMethodBeat.m2504i(22428);
        C4990ab.m7416i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = C21088i.bHq().nvN.nwW;
        String str2 = C21088i.bHq().nvN.nwX;
        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || str.equals(str2))) {
            C4990ab.m7417i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", str, str2);
            mo36461Pm(str2);
        }
        C4990ab.m7416i("MicroMsg.TalkUIController", "callFlag:" + C21088i.bHq().nvN.nwK);
        int i2 = C21088i.bHq().nvN.nwK;
        if ((i2 & 1) > 0 && (i2 & 2) > 0 && (i2 & 8) <= 0) {
            i = 1;
        }
        if (i != 0) {
            C4990ab.m7416i("MicroMsg.TalkUIController", "isNotFree");
            C30379h.m48429a(this.nGG, (int) C25738R.string.cih, (int) C25738R.string.cii, (int) C25738R.string.cig, (int) C25738R.string.cif, true, null, new C211463());
        }
        m32481xw(3);
        AppMethodBeat.m2505o(22428);
    }

    public final void bGK() {
        AppMethodBeat.m2504i(22429);
        C4990ab.m7410d("MicroMsg.TalkUIController", "onStartRing");
        if (C21088i.bHu().bHl()) {
            this.nGL = this.nGz.isChecked();
            this.nGM = this.nGz.isChecked();
            C21088i.bHt().mo54898io(this.nGz.isChecked());
        }
        AppMethodBeat.m2505o(22429);
    }

    public final void bGX() {
        AppMethodBeat.m2504i(22430);
        C4990ab.m7410d("MicroMsg.TalkUIController", "onUserAccept");
        if (C21088i.bHu().bHl()) {
            this.nGL = this.nGz.isChecked();
            this.nGM = this.nGz.isChecked();
            C21088i.bHt().mo54898io(this.nGz.isChecked());
        }
        if (C21088i.bHu().bHm()) {
            C21088i.bHt().nxg.setMute(this.nGx.isChecked());
        }
        AppMethodBeat.m2505o(22430);
    }

    public final void bGY() {
        AppMethodBeat.m2504i(22431);
        C4990ab.m7410d("MicroMsg.TalkUIController", "onOthersideShutdown");
        bIK();
        m32481xw(10);
        C9638aw.getNotification().cancel(42);
        if (this.nGI != null) {
            this.nGI.mo24158ix(true);
        }
        AppMethodBeat.m2505o(22431);
    }

    /* renamed from: d */
    public final void mo36470d(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(22432);
        C4990ab.m7411d("MicroMsg.TalkUIController", "onError, error: %d", Integer.valueOf(i));
        if (i2 == 1) {
            this.nGP = false;
        }
        if (i != 8) {
            m32480c(str, str2, i2, null);
        } else if (i2 == 1) {
            String string;
            if (C5046bo.isNullOrNil(str)) {
                string = this.nGG.getString(C25738R.string.cgb);
            } else {
                string = str;
            }
            C30379h.m48447a(this.nGG, str2, string, this.nGG.getString(C25738R.string.cgc), false, new C123274());
        } else {
            m32480c(str, str2, i2, this.nGG.getString(C25738R.string.cga));
        }
        C9638aw.getNotification().cancel(42);
        if (!(this.nGI == null || this.nGQ)) {
            this.nGI.mo24158ix(this.nGP);
        }
        AppMethodBeat.m2505o(22432);
    }

    /* renamed from: ir */
    public final void mo36472ir(boolean z) {
        AppMethodBeat.m2504i(22433);
        C4990ab.m7411d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (C21088i.bHu().bHl()) {
            if (z) {
                C21088i.bHt();
                this.nGL = C39254a.m66900KU();
                C21088i.bHt().mo54898io(false);
                this.nGz.setEnable(false);
                AppMethodBeat.m2505o(22433);
                return;
            }
            C21088i.bHt().mo54898io(this.nGL);
            this.nGz.setEnable(true);
            this.nGz.setChecked(this.nGL);
        }
        AppMethodBeat.m2505o(22433);
    }

    /* renamed from: is */
    public final void mo36473is(boolean z) {
        AppMethodBeat.m2504i(22434);
        C4990ab.m7411d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (C21088i.bHu().bHl()) {
            if (z) {
                C21088i.bHt();
                this.nGM = C39254a.m66900KU();
                C21088i.bHt().mo54898io(false);
                this.nGz.setEnable(false);
                AppMethodBeat.m2505o(22434);
                return;
            }
            C21088i.bHt().mo54898io(this.nGM);
            this.nGz.setEnable(true);
            this.nGz.setChecked(this.nGM);
        }
        AppMethodBeat.m2505o(22434);
    }

    public final void bHa() {
        AppMethodBeat.m2504i(22435);
        this.nGJ = (long) C21088i.bHv().bGU();
        m32481xw(5);
        AppMethodBeat.m2505o(22435);
    }

    public final void bGZ() {
        AppMethodBeat.m2504i(22436);
        this.nGG.finish();
        AppMethodBeat.m2505o(22436);
    }

    public final void bIK() {
        AppMethodBeat.m2504i(22437);
        if (this.nGB != null) {
            this.nGB.setVisibility(4);
        }
        if (this.nGC != null) {
            this.nGC.setVisibility(4);
        }
        AppMethodBeat.m2505o(22437);
    }

    /* renamed from: b */
    static /* synthetic */ void m32479b(C21144j c21144j) {
        AppMethodBeat.m2504i(22438);
        c21144j.nGH.mo46266eo(0, 0);
        C9638aw.getNotification().cancel(42);
        c21144j.nGG.finish();
        AppMethodBeat.m2505o(22438);
    }
}
