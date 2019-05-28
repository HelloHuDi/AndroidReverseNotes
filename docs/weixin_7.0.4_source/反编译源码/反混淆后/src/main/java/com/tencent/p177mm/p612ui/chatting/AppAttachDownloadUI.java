package com.tencent.p177mm.p612ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p230g.p231a.C18322me;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C37743ji;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.tools.ShowImageUI;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.progress.RoundProgressBtn;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.record.p492b.C43430c;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.plugin.record.p492b.C43432e.C34795a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI */
public class AppAttachDownloadUI extends MMActivity implements C1202f, C34795a, C4931a {
    private String cEV;
    private boolean cHc;
    private String cHr;
    private String cJh;
    private C7620bi cKd;
    private long cvx;
    private int egi;
    private String eov;
    private String eyr;
    private String fileName;
    private TextView grM;
    private int jLX;
    private int jLY;
    private C24088a jMO = null;
    private C5279d lCi = new C4068910();
    private Button mlE;
    private OnTouchListener mlU = new C3041211();
    private OnLongClickListener mlV = new C2365212();
    private String nul;
    private C43432e pJg;
    private MMImageView pvR;
    private int scene;
    private RoundProgressBtn yFP;
    private C40694a yFQ;
    private View yFR;
    private TextView yFS;
    private TextView yFT;
    private TextView yFU;
    private C32231g yFV;
    private boolean yFW;
    private C8910b yFX;
    private long yFY;
    private boolean yFZ = false;
    private boolean yGa = false;
    private boolean yGb = true;
    private int yGc = 5000;
    private boolean yGd = false;
    private LinearLayout yGe;
    private LinearLayout yGf;
    private boolean yGg = false;

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$9 */
    class C155519 implements OnClickListener {
        C155519() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30272);
            AppAttachDownloadUI.m70291a(AppAttachDownloadUI.this, 0);
            AppAttachDownloadUI.this.yFQ.setVisibility(8);
            if (AppAttachDownloadUI.m70311o(AppAttachDownloadUI.this)) {
                C30065b n = AppAttachDownloadUI.m70310n(AppAttachDownloadUI.this);
                if (n != null) {
                    n.field_status = 101;
                    n.field_lastModifyTime = C5046bo.anT();
                    C14877am.aUq().mo48326a(n, new String[0]);
                }
                AppAttachDownloadUI.this.pJg = new C43432e(AppAttachDownloadUI.this.cvx, AppAttachDownloadUI.this.cHr, AppAttachDownloadUI.this.yFV);
                C9638aw.m17182Rg().mo14541a(AppAttachDownloadUI.this.pJg, 0);
            }
            AppMethodBeat.m2505o(30272);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$12 */
    class C2365212 implements OnLongClickListener {
        C2365212() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(30275);
            C4990ab.m7410d("MicroMsg.AppAttachDownloadUI", "onLongClick");
            if (AppAttachDownloadUI.this.jMO == null) {
                AppAttachDownloadUI.this.jMO = new C24088a(AppAttachDownloadUI.this.mController.ylL);
            }
            AppAttachDownloadUI.this.jMO.mo39886a(view, AppAttachDownloadUI.this, AppAttachDownloadUI.this.lCi, AppAttachDownloadUI.this.jLX, AppAttachDownloadUI.this.jLY);
            AppMethodBeat.m2505o(30275);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$1 */
    class C236531 implements OnMenuItemClickListener {
        C236531() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30264);
            if (AppAttachDownloadUI.this.pJg != null) {
                C9638aw.m17182Rg().mo14547c(AppAttachDownloadUI.this.pJg);
            }
            AppAttachDownloadUI.this.finish();
            AppMethodBeat.m2505o(30264);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$7 */
    class C236547 implements C32231g {
        C236547() {
        }

        /* renamed from: a */
        public final void mo8280a(int i, int i2, C1207m c1207m) {
            float f;
            AppMethodBeat.m2504i(30270);
            if (i2 == 0) {
                f = 0.0f;
            } else {
                f = (((float) i) * 100.0f) / ((float) i2);
            }
            if (i < i2 && AppAttachDownloadUI.this.yFP.getVisibility() != 0) {
                AppAttachDownloadUI.m70291a(AppAttachDownloadUI.this, 0);
                AppAttachDownloadUI.this.yFQ.setVisibility(8);
            }
            AppAttachDownloadUI.this.yFP.setProgress((int) f);
            AppMethodBeat.m2505o(30270);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$11 */
    class C3041211 implements OnTouchListener {
        C3041211() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(30274);
            switch (motionEvent.getAction()) {
                case 0:
                    AppAttachDownloadUI.this.jLX = (int) motionEvent.getRawX();
                    AppAttachDownloadUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(30274);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$2 */
    class C304132 implements OnClickListener {
        C304132() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30265);
            AppAttachDownloadUI.this.yGb = true;
            AppAttachDownloadUI.m70321y(AppAttachDownloadUI.this);
            AppMethodBeat.m2505o(30265);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$8 */
    class C304148 implements OnClickListener {
        C304148() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30271);
            AppAttachDownloadUI.m70291a(AppAttachDownloadUI.this, 8);
            AppAttachDownloadUI.this.yFQ.setVisibility(0);
            AppAttachDownloadUI.this.yFR.setVisibility(8);
            C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", AppAttachDownloadUI.this.pJg);
            if (AppAttachDownloadUI.this.pJg != null) {
                AppAttachDownloadUI.this.pJg.mo68987a(AppAttachDownloadUI.this);
                C1720g.m3540Rg().mo14547c(AppAttachDownloadUI.this.pJg);
                AppMethodBeat.m2505o(30271);
                return;
            }
            C30065b n = AppAttachDownloadUI.m70310n(AppAttachDownloadUI.this);
            if (!(n == null || n.field_status == 199)) {
                C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", Long.valueOf(n.field_status));
                n.field_status = 102;
                C14877am.aUq().mo48326a(n, new String[0]);
            }
            AppMethodBeat.m2505o(30271);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$10 */
    class C4068910 implements C5279d {
        C4068910() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            CharSequence string;
            AppMethodBeat.m2504i(30273);
            ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
            if (AppAttachDownloadUI.this.fileName.equals("")) {
                string = AppAttachDownloadUI.this.getString(C25738R.string.dar);
            } else {
                string = AppAttachDownloadUI.this.fileName;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, string));
            C30379h.m48465bQ(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(C25738R.string.f9083oz));
            AppMethodBeat.m2505o(30273);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$5 */
    class C406905 implements OnMenuItemClickListener {
        C406905() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30268);
            AppAttachDownloadUI.m70292a(AppAttachDownloadUI.this, AppAttachDownloadUI.this.yFZ);
            AppMethodBeat.m2505o(30268);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$4 */
    class C406924 implements Runnable {
        C406924() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30267);
            AppAttachDownloadUI.m70322z(AppAttachDownloadUI.this);
            AppMethodBeat.m2505o(30267);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$6 */
    class C406936 implements C30382d {
        C406936() {
        }

        /* renamed from: bV */
        public final void mo4975bV(int i, int i2) {
            AppMethodBeat.m2504i(30269);
            switch (i2) {
                case 0:
                    AppAttachDownloadUI.m70297c(AppAttachDownloadUI.this);
                    AppMethodBeat.m2505o(30269);
                    return;
                case 2:
                    AppAttachDownloadUI.m70299d(AppAttachDownloadUI.this);
                    AppMethodBeat.m2505o(30269);
                    return;
                case 3:
                    AppAttachDownloadUI.m70301e(AppAttachDownloadUI.this);
                    AppMethodBeat.m2505o(30269);
                    return;
                case 4:
                    AppAttachDownloadUI.m70302f(AppAttachDownloadUI.this);
                    AppMethodBeat.m2505o(30269);
                    return;
                case 5:
                    AppAttachDownloadUI.m70303g(AppAttachDownloadUI.this);
                    AppMethodBeat.m2505o(30269);
                    return;
                case 6:
                    AppAttachDownloadUI.m70305i(AppAttachDownloadUI.this);
                    AppMethodBeat.m2505o(30269);
                    return;
                case 7:
                    AppAttachDownloadUI.m70304h(AppAttachDownloadUI.this);
                    AppMethodBeat.m2505o(30269);
                    return;
                case 8:
                    AppAttachDownloadUI.m70306j(AppAttachDownloadUI.this);
                    break;
            }
            AppMethodBeat.m2505o(30269);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachDownloadUI$a */
    class C40694a {
        private TextView exj;
        private Button tOx;

        public C40694a(Button button, TextView textView) {
            AppMethodBeat.m2504i(30276);
            this.tOx = button;
            this.exj = textView;
            if (textView != null) {
                Math.floor((((double) (((long) C26373g.m41964Nu().getInt("MsgFileExpiredInterval", 432000)) - C1839cb.m3786fp(AppAttachDownloadUI.this.cKd.field_createTime / 1000))) * 1.0d) / 86400.0d);
                textView.setText("");
            }
            AppMethodBeat.m2505o(30276);
        }

        public final void setVisibility(int i) {
            AppMethodBeat.m2504i(30277);
            if (this.tOx != null) {
                this.tOx.setVisibility(i);
            }
            if (this.exj != null) {
                this.exj.setVisibility(i);
            }
            AppMethodBeat.m2505o(30277);
        }

        public final void dBo() {
            AppMethodBeat.m2504i(30278);
            if (this.tOx != null) {
                this.tOx.setVisibility(4);
            }
            if (this.exj != null) {
                this.exj.setVisibility(0);
                this.exj.setText(C25738R.string.bt0);
                this.exj.setTextColor(AppAttachDownloadUI.this.getResources().getColor(C25738R.color.f11673cv));
                AppAttachDownloadUI.this.grM.setVisibility(8);
                AppAttachDownloadUI.this.yFR.setVisibility(8);
            }
            AppMethodBeat.m2505o(30278);
        }

        public final void setOnClickListener(OnClickListener onClickListener) {
            AppMethodBeat.m2504i(30279);
            this.tOx.setOnClickListener(onClickListener);
            AppMethodBeat.m2505o(30279);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppAttachDownloadUI() {
        AppMethodBeat.m2504i(30280);
        AppMethodBeat.m2505o(30280);
    }

    /* renamed from: n */
    static /* synthetic */ C30065b m70310n(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30325);
        C30065b dBi = appAttachDownloadUI.dBi();
        AppMethodBeat.m2505o(30325);
        return dBi;
    }

    /* renamed from: o */
    static /* synthetic */ boolean m70311o(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30326);
        boolean dBg = appAttachDownloadUI.dBg();
        AppMethodBeat.m2505o(30326);
        return dBg;
    }

    /* renamed from: z */
    static /* synthetic */ void m70322z(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30329);
        appAttachDownloadUI.dBj();
        AppMethodBeat.m2505o(30329);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30281);
        super.onCreate(bundle);
        init();
        AppMethodBeat.m2505o(30281);
    }

    private void init() {
        AppMethodBeat.m2504i(30282);
        setMMTitle("");
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        dyb();
        if (dBa()) {
            C5728b c5728b = new C5728b(C6457e.euQ);
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            C14877am.aUq().mo10116c(this);
            initView();
            AppMethodBeat.m2505o(30282);
            return;
        }
        finish();
        AppMethodBeat.m2505o(30282);
    }

    private boolean dBa() {
        AppMethodBeat.m2504i(30283);
        this.scene = getIntent().getIntExtra("scene", 0);
        this.cvx = getIntent().getLongExtra("app_msg_id", -1);
        this.yGd = getIntent().getBooleanExtra("choose_way", false);
        if (this.cvx == -1) {
            AppMethodBeat.m2505o(30283);
            return false;
        }
        C9638aw.m17190ZK();
        this.cKd = C18628c.m29080XO().mo15340jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId == 0 || this.cKd.field_content == null) {
            AppMethodBeat.m2505o(30283);
            return false;
        }
        this.yFW = C1855t.m3896kH(this.cKd.field_talker);
        this.cJh = this.cKd.field_content;
        if (this.yFW && this.cKd.field_isSend == 0) {
            this.cJh = aqY(this.cKd.field_content);
        }
        this.yFX = C8910b.m16064me(this.cJh);
        if (this.yFX == null) {
            C4990ab.m7413e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", this.cJh);
            AppMethodBeat.m2505o(30283);
            return false;
        }
        if (C42252ah.isNullOrNil(this.yFX.csD) && !C42252ah.isNullOrNil(this.yFX.fgD)) {
            C4990ab.m7413e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", this.cJh);
            this.yFX.csD = this.yFX.fgD.hashCode();
        }
        this.egi = this.yFX.type;
        this.cHr = this.yFX.csD;
        this.fileName = C42252ah.nullAsNil(this.yFX.title);
        this.eov = C42252ah.nullAsNil(this.yFX.fgp).toLowerCase();
        this.yFY = (long) this.yFX.fgo;
        this.nul = C42252ah.nullAsNil(this.yFX.filemd5);
        this.cEV = C42252ah.nullAsNil(this.yFX.cEV);
        this.eyr = C42252ah.nullAsNil(this.yFX.eyr);
        if (C42252ah.isNullOrNil(this.eov)) {
            this.eov = C5730e.m8630cv(this.fileName);
        }
        C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", Long.valueOf(this.cvx), Integer.valueOf(this.cKd.field_isSend), this.cJh, Integer.valueOf(this.egi), this.cHr, this.fileName);
        C30065b dBi = dBi();
        if (dBi == null) {
            C4990ab.m7416i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
            this.yGa = false;
        } else {
            C5728b c5728b = new C5728b(dBi.field_fileFullPath);
            if (dBi.field_offset > 0) {
                this.yGa = true;
            } else {
                this.yGa = false;
            }
            C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", dBi.field_fileFullPath, Long.valueOf(dBi.field_offset), Boolean.valueOf(this.yGa));
        }
        boolean b;
        if (!AppAttachDownloadUI.m70298c(dBi)) {
            AppMethodBeat.m2505o(30283);
            return true;
        } else if (this.scene == 1) {
            if (this.yGd) {
                b = C44094a.m79370b(this, dBi.field_fileFullPath, this.eov, 7);
                AppMethodBeat.m2505o(30283);
                return b;
            }
            b = C44094a.m79366M(dBi.field_fileFullPath, this.eov, 7);
            AppMethodBeat.m2505o(30283);
            return b;
        } else if (this.yGd) {
            b = C44094a.m79370b(this, dBi.field_fileFullPath, this.eov, 1);
            AppMethodBeat.m2505o(30283);
            return b;
        } else {
            b = C44094a.m79366M(dBi.field_fileFullPath, this.eov, 1);
            AppMethodBeat.m2505o(30283);
            return b;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30284);
        C14877am.aUq().mo10117d(this);
        super.onDestroy();
        AppMethodBeat.m2505o(30284);
    }

    public void onResume() {
        AppMethodBeat.m2504i(30285);
        super.onResume();
        C9638aw.m17182Rg().mo14539a(221, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(728, (C1202f) this);
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = true;
        c18322me.cHX.talker = this.cKd.field_talker;
        C4879a.xxA.mo10048a(c18322me, getMainLooper());
        C4990ab.m7410d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.mlE.setEnabled(true);
        AppMethodBeat.m2505o(30285);
    }

    public void onPause() {
        AppMethodBeat.m2504i(30286);
        C9638aw.m17182Rg().mo14546b(221, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(728, (C1202f) this);
        super.onPause();
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = false;
        c18322me.cHX.talker = this.cKd.field_talker;
        C4879a.xxA.mo10048a(c18322me, getMainLooper());
        C4990ab.m7410d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
        AppMethodBeat.m2505o(30286);
    }

    public final void initView() {
        AppMethodBeat.m2504i(30287);
        this.pvR = (MMImageView) findViewById(2131821523);
        this.yFP = (RoundProgressBtn) findViewById(2131823346);
        this.yFQ = new C40694a((Button) findViewById(2131823347), (TextView) findViewById(2131823348));
        this.mlE = (Button) findViewById(2131823349);
        this.yFR = findViewById(2131823343);
        this.grM = (TextView) findViewById(2131823345);
        this.yFS = (TextView) findViewById(2131823344);
        this.yFT = (TextView) findViewById(2131823341);
        this.yFU = (TextView) findViewById(2131823342);
        this.yGe = (LinearLayout) findViewById(2131823340);
        this.yGf = (LinearLayout) findViewById(2131823350);
        this.yFT.setOnTouchListener(this.mlU);
        this.yFT.setOnLongClickListener(this.mlV);
        if (this.yFT != null) {
            TextPaint paint = this.yFT.getPaint();
            if (paint != null) {
                paint.setFakeBoldText(true);
            }
        }
        dBd();
        dBe();
        dBh();
        ccI();
        setBackBtn(new C236531());
        this.cHc = getIntent().getBooleanExtra("app_show_share", true);
        if (this.cHc) {
            addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C406905());
        }
        this.yFZ = false;
        if (m70294b(dBi())) {
            C4990ab.m7416i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
            if (this.yFY > 0) {
                this.yFU.setVisibility(0);
                this.yFU.setText(getResources().getString(C25738R.string.g7i, new Object[]{C42252ah.m74622ga(this.yFY)}));
            } else {
                this.yFU.setVisibility(8);
            }
            this.yFZ = true;
            dBj();
            AppMethodBeat.m2505o(30287);
            return;
        }
        if (this.yFY > 0) {
            this.yFU.setVisibility(0);
            this.yFU.setText(getResources().getString(C25738R.string.g7i, new Object[]{C42252ah.m74622ga(this.yFY)}));
        } else {
            this.yFU.setVisibility(8);
        }
        if (this.yFZ) {
            AppMethodBeat.m2505o(30287);
            return;
        }
        dBc();
        start();
        C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", this.yFV, Boolean.valueOf(this.yFZ), Boolean.valueOf(this.yGa));
        if (this.egi == 2 || !(this.yFZ || this.yGa)) {
            dBf();
        }
        AppMethodBeat.m2505o(30287);
    }

    /* renamed from: b */
    private boolean m70294b(C30065b c30065b) {
        AppMethodBeat.m2504i(30288);
        if (c30065b == null || !new C5728b(c30065b.field_fileFullPath).exists()) {
            AppMethodBeat.m2505o(30288);
            return false;
        } else if (c30065b.bCR() || (this.cKd.field_isSend == 1 && c30065b.field_isUpload)) {
            AppMethodBeat.m2505o(30288);
            return true;
        } else {
            AppMethodBeat.m2505o(30288);
            return false;
        }
    }

    private void dBb() {
        AppMethodBeat.m2504i(30289);
        C45316cl c45316cl = new C45316cl();
        C40443e.m69377d(c45316cl, this.cKd);
        c45316cl.cvA.activity = this;
        c45316cl.cvA.cvH = 39;
        C4879a.xxA.mo10055m(c45316cl);
        AppMethodBeat.m2505o(30289);
    }

    private String aqY(String str) {
        AppMethodBeat.m2504i(30290);
        if (this.yFW && str != null) {
            str = C1829bf.m3763oz(str);
        }
        AppMethodBeat.m2505o(30290);
        return str;
    }

    private void dBc() {
        AppMethodBeat.m2504i(30291);
        this.yFV = new C236547();
        AppMethodBeat.m2505o(30291);
    }

    private void ccI() {
        AppMethodBeat.m2504i(30292);
        switch (this.egi) {
            case 0:
            case 7:
                if (C5046bo.any(this.eov)) {
                    this.pvR.setImageResource(C25738R.drawable.avp);
                    AppMethodBeat.m2505o(30292);
                    return;
                }
                this.pvR.setImageResource(C1318a.app_attach_file_icon_unknow);
                AppMethodBeat.m2505o(30292);
                return;
            case 2:
                this.pvR.setImageResource(C25738R.drawable.avp);
                AppMethodBeat.m2505o(30292);
                return;
            case 4:
                this.pvR.setImageResource(C1318a.app_attach_file_icon_video);
                AppMethodBeat.m2505o(30292);
                return;
            case 6:
                this.pvR.setImageResource(C44065o.aiD(this.eov));
                AppMethodBeat.m2505o(30292);
                return;
            default:
                this.pvR.setImageResource(C1318a.app_attach_file_icon_unknow);
                AppMethodBeat.m2505o(30292);
                return;
        }
    }

    private void dBd() {
        AppMethodBeat.m2504i(30293);
        this.yFP.setOnClickListener(new C304148());
        AppMethodBeat.m2505o(30293);
    }

    private void dBe() {
        AppMethodBeat.m2504i(30294);
        this.yFQ.setOnClickListener(new C155519());
        AppMethodBeat.m2505o(30294);
    }

    private void dBf() {
        AppMethodBeat.m2504i(30295);
        m70287Ob(0);
        this.yFQ.setVisibility(8);
        if (dBg()) {
            C4990ab.m7416i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
            this.pJg = new C43432e(this.cvx, this.cHr, this.yFV);
            C9638aw.m17182Rg().mo14541a(this.pJg, 0);
            C37951y.m64162C(this.cKd);
        }
        AppMethodBeat.m2505o(30295);
    }

    private void start() {
        AppMethodBeat.m2504i(30296);
        switch (this.egi) {
            case 0:
            case 6:
                if (this.yGa) {
                    this.yFQ.setVisibility(0);
                } else {
                    this.yFQ.setVisibility(8);
                }
                m70287Ob(8);
                this.yFR.setVisibility(8);
                this.mlE.setVisibility(8);
                dBn();
                this.yFT.setVisibility(0);
                if (this.fileName.equals("")) {
                    this.yFT.setText(getString(C25738R.string.dar));
                } else {
                    this.yFT.setText(this.fileName);
                }
                String mimeType = getMimeType();
                if (mimeType == null || mimeType.equals("")) {
                    this.grM.setText(getString(C25738R.string.b6l));
                } else {
                    this.grM.setText(getString(C25738R.string.b6m));
                }
                if (C5046bo.any(this.eov)) {
                    dBn();
                    AppMethodBeat.m2505o(30296);
                    return;
                }
                break;
            case 2:
                m70287Ob(8);
                this.yFR.setVisibility(8);
                if (this.yGa) {
                    this.yFQ.setVisibility(0);
                } else {
                    this.yFQ.setVisibility(8);
                }
                this.mlE.setVisibility(8);
                this.yFT.setVisibility(8);
                dBn();
                break;
            case 7:
                if (this.yGa) {
                    this.yFQ.setVisibility(0);
                } else {
                    this.yFQ.setVisibility(8);
                }
                m70287Ob(8);
                this.yFR.setVisibility(8);
                this.mlE.setVisibility(8);
                this.yFT.setVisibility(8);
                dBn();
                this.grM.setText(getString(C25738R.string.b6m));
                AppMethodBeat.m2505o(30296);
                return;
        }
        AppMethodBeat.m2505o(30296);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(30297);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(C25738R.string.f9082oy));
        AppMethodBeat.m2505o(30297);
    }

    private boolean dBg() {
        boolean z;
        int i = -1;
        boolean z2 = true;
        AppMethodBeat.m2504i(30298);
        C30065b dBi = dBi();
        String str;
        if (dBi == null) {
            C4733l.m7105s(this.cvx, this.cJh);
            dBi = dBi();
            if (dBi != null) {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                str = "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(dBi.xDa);
                objArr[1] = Long.valueOf(dBi.field_totalLen);
                objArr[2] = dBi.field_fileFullPath;
                objArr[3] = Long.valueOf(dBi.field_type);
                objArr[4] = dBi.field_mediaId;
                objArr[5] = Long.valueOf(dBi.field_msgInfoId);
                objArr[6] = Boolean.valueOf(dBi.field_isUpload);
                if (dBi.field_signature != null) {
                    i = dBi.field_signature.length();
                }
                objArr[7] = Integer.valueOf(i);
                C4990ab.m7417i(str2, str, objArr);
                if (this.yFX.fgs != 0 || this.yFX.fgo > 26214400) {
                    boolean z3;
                    if (C42252ah.isNullOrNil(dBi.field_signature)) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z2 = z3;
                }
            }
        } else {
            C5728b c5728b = new C5728b(dBi.field_fileFullPath);
            if (dBi.field_status == 199 && !c5728b.exists()) {
                C4990ab.m7416i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
                C4733l.m7105s(this.cvx, this.cJh);
            }
            str = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(dBi.xDa);
            objArr2[1] = Long.valueOf(dBi.field_totalLen);
            objArr2[2] = dBi.field_fileFullPath;
            objArr2[3] = Long.valueOf(dBi.field_type);
            objArr2[4] = dBi.field_mediaId;
            objArr2[5] = Long.valueOf(dBi.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(dBi.field_isUpload);
            objArr2[7] = Boolean.valueOf(c5728b.exists());
            objArr2[8] = Long.valueOf(dBi.field_status);
            if (dBi.field_signature != null) {
                i = dBi.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i);
            C4990ab.m7417i(str, str3, objArr2);
        }
        if (this.yFX == null || (this.yFX.fgs == 0 && this.yFX.fgo <= 26214400)) {
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            C9638aw.m17182Rg().mo14541a(new C43430c(dBi, this.eyr, this.nul, this.fileName, this.eov, this.cEV), 0);
        }
        AppMethodBeat.m2505o(30298);
        return z;
    }

    private void dBh() {
        AppMethodBeat.m2504i(30299);
        this.mlE.setOnClickListener(new C304132());
        AppMethodBeat.m2505o(30299);
    }

    private String getMimeType() {
        AppMethodBeat.m2504i(30300);
        C8910b me = C8910b.m16064me(this.cJh);
        String str = null;
        if (me.fgp != null && me.fgp.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(me.fgp);
        }
        if (str == null || str.length() == 0) {
            C4990ab.m7420w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
            str = "*/" + me.fgp;
        }
        AppMethodBeat.m2505o(30300);
        return str;
    }

    private C30065b dBi() {
        AppMethodBeat.m2504i(30301);
        C30065b lZ = C14877am.aUq().mo48329lZ(this.cvx);
        if (lZ != null) {
            C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", Long.valueOf(this.cvx), C42252ah.anW());
            AppMethodBeat.m2505o(30301);
        } else {
            lZ = C4733l.aiM(this.cHr);
            if (lZ == null) {
                C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", C42252ah.anW());
                AppMethodBeat.m2505o(30301);
            } else if (lZ.field_msgInfoId == this.cvx || C5730e.m8628ct(lZ.field_fileFullPath)) {
                AppMethodBeat.m2505o(30301);
            } else {
                C4733l.m7105s(this.cvx, this.cJh);
                final C30065b lZ2 = C14877am.aUq().mo48329lZ(this.cvx);
                if (lZ2 == null) {
                    C4990ab.m7421w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", C42252ah.anW());
                    AppMethodBeat.m2505o(30301);
                } else {
                    C7305d.post(new Runnable() {
                        public final void run() {
                            boolean a;
                            AppMethodBeat.m2504i(30266);
                            long currentTimeMillis = System.currentTimeMillis();
                            long y = C5730e.m8644y(lZ.field_fileFullPath, lZ2.field_fileFullPath);
                            if (y > 0) {
                                lZ2.field_offset = y;
                                if (AppAttachDownloadUI.m70300d(lZ2)) {
                                    lZ2.field_status = 199;
                                }
                                a = C14877am.aUq().mo48326a(lZ2, new String[0]);
                            } else {
                                a = false;
                            }
                            C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", Long.valueOf(y), Long.valueOf(lZ.field_msgInfoId), Long.valueOf(lZ2.field_msgInfoId), Boolean.valueOf(a), Long.valueOf(lZ2.field_status), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.m2505o(30266);
                        }
                    }, "copyAttachFromLocal");
                    AppMethodBeat.m2505o(30301);
                }
            }
        }
        return lZ;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(30302);
        super.onActivityResult(i, i2, intent);
        C44094a.m79367a(this, i, i2, intent, this.yGb, C25738R.string.b6t, C25738R.string.b6u, 1);
        AppMethodBeat.m2505o(30302);
    }

    private void dBj() {
        AppMethodBeat.m2504i(30304);
        switch (this.egi) {
            case 0:
            case 6:
                if (dBk()) {
                    if (C5046bo.any(this.eov)) {
                        dBl();
                        AppMethodBeat.m2505o(30304);
                        return;
                    }
                    String mimeType = getMimeType();
                    C4990ab.m7416i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
                    dBn();
                    m70287Ob(8);
                    this.yFR.setVisibility(8);
                    this.yFQ.setVisibility(8);
                    this.yFT.setVisibility(0);
                    if (this.fileName.equals("")) {
                        this.yFT.setText(getString(C25738R.string.dar));
                    } else {
                        this.yFT.setText(this.fileName);
                    }
                    if (mimeType == null || mimeType.equals("")) {
                        this.mlE.setVisibility(8);
                        this.grM.setText(getString(C25738R.string.b6l));
                        AppMethodBeat.m2505o(30304);
                        return;
                    }
                    this.mlE.setVisibility(0);
                    this.grM.setText(getString(C25738R.string.b6m));
                    AppMethodBeat.m2505o(30304);
                    return;
                }
                break;
            case 2:
                if (dBk()) {
                    ccL();
                    AppMethodBeat.m2505o(30304);
                    return;
                }
                break;
            case 7:
                Intent intent = new Intent();
                intent.putExtra("App_MsgId", this.cvx);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(30304);
                return;
            default:
                this.mlE.setVisibility(0);
                m70287Ob(8);
                this.yFR.setVisibility(8);
                break;
        }
        AppMethodBeat.m2505o(30304);
    }

    private boolean dBk() {
        AppMethodBeat.m2504i(30305);
        C30065b dBi = dBi();
        if (dBi == null) {
            AppMethodBeat.m2505o(30305);
            return true;
        } else if (C5730e.m8628ct(dBi.field_fileFullPath)) {
            m70287Ob(8);
            this.yFR.setVisibility(8);
            this.yFQ.setVisibility(8);
            AppMethodBeat.m2505o(30305);
            return true;
        } else {
            m70287Ob(8);
            dBm();
            AppMethodBeat.m2505o(30305);
            return false;
        }
    }

    private void dBl() {
        AppMethodBeat.m2504i(30306);
        C30065b dBi = dBi();
        Intent intent = new Intent(this, ShowImageUI.class);
        intent.putExtra("key_message_id", this.cKd.field_msgId);
        intent.putExtra("key_image_path", dBi.field_fileFullPath);
        intent.putExtra("key_favorite", true);
        startActivity(intent);
        finish();
        AppMethodBeat.m2505o(30306);
    }

    private void ccL() {
        AppMethodBeat.m2504i(30307);
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", this.cKd.field_msgId);
        intent.putExtra("img_gallery_talker", this.cKd.field_talker);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(30307);
    }

    public final int getLayoutId() {
        return 2130969303;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(30308);
        C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        Object[] objArr;
        if (c1207m.getType() != 221 && c1207m.getType() != 728) {
            AppMethodBeat.m2505o(30308);
        } else if (c1207m.getType() == 728 && i == 0 && i2 == 0) {
            C30065b dBi = dBi();
            if (dBi == null) {
                C4990ab.m7416i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
            } else {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                String str3 = "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach";
                objArr = new Object[1];
                objArr[0] = Integer.valueOf(dBi.field_signature == null ? -1 : dBi.field_signature.length());
                C4990ab.m7417i(str2, str3, objArr);
            }
            if (dBi != null) {
                dBi.field_status = 101;
                dBi.field_lastModifyTime = C5046bo.anT();
                C14877am.aUq().mo48326a(dBi, new String[0]);
            }
            this.pJg = new C43432e(this.cvx, this.cHr, this.yFV);
            C9638aw.m17182Rg().mo14541a(this.pJg, 0);
            AppMethodBeat.m2505o(30308);
        } else {
            if (this.pJg == null && (c1207m instanceof C43432e)) {
                C43432e c43432e = (C43432e) c1207m;
                C30065b dBi2 = dBi();
                if (!(dBi2 == null || C42252ah.isNullOrNil(dBi2.field_mediaSvrId) || !dBi2.field_mediaSvrId.equals(c43432e.getMediaId()))) {
                    this.pJg = c43432e;
                    C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", this.pJg, dBi2.field_mediaSvrId);
                }
            }
            C7060h c7060h;
            int i3;
            if (i == 0 && i2 == 0) {
                c7060h = C7060h.pYm;
                objArr = new Object[6];
                objArr[0] = this.yFX.fgD;
                if (this.yFX.fgs == 1) {
                    i3 = 7;
                } else {
                    i3 = 5;
                }
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = Integer.valueOf(this.yFX.fgo);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = Integer.valueOf(0);
                objArr[5] = this.eov;
                c7060h.mo8381e(14665, objArr);
                AppMethodBeat.m2505o(30308);
                return;
            }
            if (i2 != 0 && C4872b.dnO()) {
                Toast.makeText(this, "errCode[" + i2 + "]", 0).show();
            }
            if (i2 == -5103059) {
                dBm();
                m70287Ob(8);
                if (this.egi == 6) {
                    c7060h = C7060h.pYm;
                    objArr = new Object[6];
                    objArr[0] = this.yFX.fgD;
                    if (this.yFX.fgs == 1) {
                        i3 = 7;
                    } else {
                        i3 = 5;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    objArr[2] = Integer.valueOf(this.yFX.fgo);
                    objArr[3] = Integer.valueOf(1);
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = this.eov;
                    c7060h.mo8381e(14665, objArr);
                }
                AppMethodBeat.m2505o(30308);
                return;
            }
            m70287Ob(8);
            this.yFQ.setVisibility(0);
            this.yFR.setVisibility(8);
            C4990ab.m7412e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + c1207m.getType() + " errType = " + i + ", errCode = " + i2);
            AppMethodBeat.m2505o(30308);
        }
    }

    public final void ceD() {
        AppMethodBeat.m2504i(30309);
        Toast.makeText(this, C25738R.string.b6x, 0).show();
        AppMethodBeat.m2505o(30309);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(30310);
        super.onNewIntent(intent);
        setIntent(intent);
        init();
        AppMethodBeat.m2505o(30310);
    }

    /* renamed from: c */
    private static boolean m70298c(C30065b c30065b) {
        AppMethodBeat.m2504i(30311);
        if (c30065b == null) {
            AppMethodBeat.m2505o(30311);
            return false;
        }
        C5728b c5728b = new C5728b(c30065b.field_fileFullPath);
        if (c5728b.exists() && c5728b.length() == c30065b.field_totalLen) {
            AppMethodBeat.m2505o(30311);
            return true;
        }
        AppMethodBeat.m2505o(30311);
        return false;
    }

    /* renamed from: Ob */
    private void m70287Ob(int i) {
        AppMethodBeat.m2504i(30312);
        if (i != this.yFP.getVisibility()) {
            C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", Integer.valueOf(i), C42252ah.anW());
            this.yFP.setVisibility(i);
        }
        AppMethodBeat.m2505o(30312);
    }

    private void dBm() {
        AppMethodBeat.m2504i(30313);
        this.yGe.setVisibility(0);
        this.yGf.setVisibility(8);
        dBn();
        this.yFQ.dBo();
        AppMethodBeat.m2505o(30313);
    }

    private void dBn() {
        AppMethodBeat.m2504i(30314);
        this.grM.setVisibility(8);
        AppMethodBeat.m2505o(30314);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(30303);
        C30065b dBi = dBi();
        if (dBi != null) {
            long j = dBi.field_totalLen;
            long j2 = dBi.field_offset;
            this.yFY = j;
            this.yFS.setText(getString(C25738R.string.b6o, new Object[]{C42252ah.m74622ga(j2), C42252ah.m74622ga(j)}));
            int i = dBi.field_totalLen == 0 ? 0 : (int) ((dBi.field_offset * 100) / dBi.field_totalLen);
            C4990ab.m7418v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + j2 + " totallen:" + j + " status " + dBi.field_status);
            this.yFP.setProgress(i);
            if (dBi.field_status == 199 && i >= 100 && !this.yFZ) {
                this.yFZ = true;
                if (this.yGg) {
                    this.yGg = false;
                    dBb();
                }
                if (dBi != null) {
                    Toast.makeText(this, getString(C25738R.string.b71) + " : " + dBi.field_fileFullPath.replaceFirst(C6457e.eSl, C6457e.euO), this.yGc).show();
                    C44094a.m79368a(this, dBi.field_fileFullPath, this.eov, 1);
                }
                C5004al.m7442n(new C406924(), 200);
            }
            if (this.yFP.getVisibility() != 0 && i < 100 && !dBi.field_isUpload && dBi.field_status == 101) {
                C4990ab.m7417i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", Integer.valueOf(i));
                m70287Ob(0);
                this.yFQ.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(30303);
    }

    /* renamed from: e */
    static /* synthetic */ void m70301e(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30318);
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        appAttachDownloadUI.startActivity(intent);
        C7060h.pYm.mo8381e(11168, Integer.valueOf(6), Integer.valueOf(1));
        AppMethodBeat.m2505o(30318);
    }

    /* renamed from: f */
    static /* synthetic */ void m70302f(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30319);
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.cKd.field_msgId);
        appAttachDownloadUI.startActivity(intent);
        AppMethodBeat.m2505o(30319);
    }

    /* renamed from: g */
    static /* synthetic */ void m70303g(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30320);
        if (appAttachDownloadUI.dBi() != null) {
            C37743ji c37743ji = new C37743ji();
            c37743ji.cEE.cut = 27;
            c37743ji.cEE.cuu = 1;
            if (appAttachDownloadUI.dBi() != null) {
                c37743ji.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
            }
            C4879a.xxA.mo10055m(c37743ji);
            C23639t.makeText(C4996ah.getContext(), String.format("current template is %d", new Object[]{Integer.valueOf(C46400aa.m87305HV(0))}), 1).show();
        }
        AppMethodBeat.m2505o(30320);
    }

    /* renamed from: h */
    static /* synthetic */ void m70304h(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30321);
        C32519bf c32519bf = new C32519bf();
        c32519bf.cus.cut = 35;
        c32519bf.cus.cuu = 1;
        if (appAttachDownloadUI.dBi() != null) {
            c32519bf.cus.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
        }
        C4879a.xxA.mo10055m(c32519bf);
        C23639t.makeText(C4996ah.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.m2505o(30321);
    }

    /* renamed from: i */
    static /* synthetic */ void m70305i(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30322);
        C37743ji c37743ji = new C37743ji();
        c37743ji.cEE.cut = 40;
        c37743ji.cEE.cuu = 1;
        if (appAttachDownloadUI.dBi() != null) {
            c37743ji.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
            c37743ji.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
        }
        C4879a.xxA.mo10055m(c37743ji);
        C23639t.makeText(C4996ah.getContext(), String.format("current wxa template is %d", new Object[]{Integer.valueOf(C27278r.aLE())}), 1).show();
        AppMethodBeat.m2505o(30322);
    }

    /* renamed from: j */
    static /* synthetic */ void m70306j(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30323);
        C37743ji c37743ji = new C37743ji();
        c37743ji.cEE.cut = 27;
        c37743ji.cEE.cuu = 2;
        if (appAttachDownloadUI.dBi() != null) {
            c37743ji.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
        }
        C4879a.xxA.mo10055m(c37743ji);
        C23639t.makeText(C4996ah.getContext(), String.format("current browse template is %d", new Object[]{Integer.valueOf(C46400aa.m87305HV(1))}), 1).show();
        AppMethodBeat.m2505o(30323);
    }

    /* renamed from: y */
    static /* synthetic */ void m70321y(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.m2504i(30327);
        C30065b dBi = appAttachDownloadUI.dBi();
        if (dBi == null) {
            C4990ab.m7412e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
            AppMethodBeat.m2505o(30327);
        } else if (dBi.field_fileFullPath == null || dBi.field_fileFullPath.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
            AppMethodBeat.m2505o(30327);
        } else {
            String str = dBi.field_fileFullPath;
            if (appAttachDownloadUI.scene == 1) {
                C44094a.m79368a(appAttachDownloadUI, str, appAttachDownloadUI.eov, 7);
            } else {
                C44094a.m79368a(appAttachDownloadUI, str, appAttachDownloadUI.eov, 1);
            }
            appAttachDownloadUI.mlE.setEnabled(false);
            AppMethodBeat.m2505o(30327);
        }
    }
}
