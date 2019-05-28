package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.me;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;

public class AppAttachDownloadUI extends MMActivity implements f, com.tencent.mm.plugin.record.b.e.a, com.tencent.mm.sdk.e.k.a {
    private String cEV;
    private boolean cHc;
    private String cHr;
    private String cJh;
    private bi cKd;
    private long cvx;
    private int egi;
    private String eov;
    private String eyr;
    private String fileName;
    private TextView grM;
    private int jLX;
    private int jLY;
    private com.tencent.mm.ui.widget.b.a jMO = null;
    private d lCi = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            CharSequence string;
            AppMethodBeat.i(30273);
            ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
            if (AppAttachDownloadUI.this.fileName.equals("")) {
                string = AppAttachDownloadUI.this.getString(R.string.dar);
            } else {
                string = AppAttachDownloadUI.this.fileName;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, string));
            h.bQ(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(R.string.oz));
            AppMethodBeat.o(30273);
        }
    };
    private Button mlE;
    private OnTouchListener mlU = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(30274);
            switch (motionEvent.getAction()) {
                case 0:
                    AppAttachDownloadUI.this.jLX = (int) motionEvent.getRawX();
                    AppAttachDownloadUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(30274);
            return false;
        }
    };
    private OnLongClickListener mlV = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(30275);
            ab.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
            if (AppAttachDownloadUI.this.jMO == null) {
                AppAttachDownloadUI.this.jMO = new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.mController.ylL);
            }
            AppAttachDownloadUI.this.jMO.a(view, AppAttachDownloadUI.this, AppAttachDownloadUI.this.lCi, AppAttachDownloadUI.this.jLX, AppAttachDownloadUI.this.jLY);
            AppMethodBeat.o(30275);
            return true;
        }
    };
    private String nul;
    private e pJg;
    private MMImageView pvR;
    private int scene;
    private RoundProgressBtn yFP;
    private a yFQ;
    private View yFR;
    private TextView yFS;
    private TextView yFT;
    private TextView yFU;
    private g yFV;
    private boolean yFW;
    private b yFX;
    private long yFY;
    private boolean yFZ = false;
    private boolean yGa = false;
    private boolean yGb = true;
    private int yGc = 5000;
    private boolean yGd = false;
    private LinearLayout yGe;
    private LinearLayout yGf;
    private boolean yGg = false;

    class a {
        private TextView exj;
        private Button tOx;

        public a(Button button, TextView textView) {
            AppMethodBeat.i(30276);
            this.tOx = button;
            this.exj = textView;
            if (textView != null) {
                Math.floor((((double) (((long) com.tencent.mm.m.g.Nu().getInt("MsgFileExpiredInterval", 432000)) - cb.fp(AppAttachDownloadUI.this.cKd.field_createTime / 1000))) * 1.0d) / 86400.0d);
                textView.setText("");
            }
            AppMethodBeat.o(30276);
        }

        public final void setVisibility(int i) {
            AppMethodBeat.i(30277);
            if (this.tOx != null) {
                this.tOx.setVisibility(i);
            }
            if (this.exj != null) {
                this.exj.setVisibility(i);
            }
            AppMethodBeat.o(30277);
        }

        public final void dBo() {
            AppMethodBeat.i(30278);
            if (this.tOx != null) {
                this.tOx.setVisibility(4);
            }
            if (this.exj != null) {
                this.exj.setVisibility(0);
                this.exj.setText(R.string.bt0);
                this.exj.setTextColor(AppAttachDownloadUI.this.getResources().getColor(R.color.cv));
                AppAttachDownloadUI.this.grM.setVisibility(8);
                AppAttachDownloadUI.this.yFR.setVisibility(8);
            }
            AppMethodBeat.o(30278);
        }

        public final void setOnClickListener(OnClickListener onClickListener) {
            AppMethodBeat.i(30279);
            this.tOx.setOnClickListener(onClickListener);
            AppMethodBeat.o(30279);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppAttachDownloadUI() {
        AppMethodBeat.i(30280);
        AppMethodBeat.o(30280);
    }

    static /* synthetic */ com.tencent.mm.pluginsdk.model.app.b n(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30325);
        com.tencent.mm.pluginsdk.model.app.b dBi = appAttachDownloadUI.dBi();
        AppMethodBeat.o(30325);
        return dBi;
    }

    static /* synthetic */ boolean o(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30326);
        boolean dBg = appAttachDownloadUI.dBg();
        AppMethodBeat.o(30326);
        return dBg;
    }

    static /* synthetic */ void z(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30329);
        appAttachDownloadUI.dBj();
        AppMethodBeat.o(30329);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30281);
        super.onCreate(bundle);
        init();
        AppMethodBeat.o(30281);
    }

    private void init() {
        AppMethodBeat.i(30282);
        setMMTitle("");
        xE(getResources().getColor(R.color.d4));
        dyb();
        if (dBa()) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.euQ);
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            am.aUq().c(this);
            initView();
            AppMethodBeat.o(30282);
            return;
        }
        finish();
        AppMethodBeat.o(30282);
    }

    private boolean dBa() {
        AppMethodBeat.i(30283);
        this.scene = getIntent().getIntExtra("scene", 0);
        this.cvx = getIntent().getLongExtra("app_msg_id", -1);
        this.yGd = getIntent().getBooleanExtra("choose_way", false);
        if (this.cvx == -1) {
            AppMethodBeat.o(30283);
            return false;
        }
        aw.ZK();
        this.cKd = c.XO().jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId == 0 || this.cKd.field_content == null) {
            AppMethodBeat.o(30283);
            return false;
        }
        this.yFW = t.kH(this.cKd.field_talker);
        this.cJh = this.cKd.field_content;
        if (this.yFW && this.cKd.field_isSend == 0) {
            this.cJh = aqY(this.cKd.field_content);
        }
        this.yFX = b.me(this.cJh);
        if (this.yFX == null) {
            ab.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", this.cJh);
            AppMethodBeat.o(30283);
            return false;
        }
        if (com.tencent.mm.platformtools.ah.isNullOrNil(this.yFX.csD) && !com.tencent.mm.platformtools.ah.isNullOrNil(this.yFX.fgD)) {
            ab.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", this.cJh);
            this.yFX.csD = this.yFX.fgD.hashCode();
        }
        this.egi = this.yFX.type;
        this.cHr = this.yFX.csD;
        this.fileName = com.tencent.mm.platformtools.ah.nullAsNil(this.yFX.title);
        this.eov = com.tencent.mm.platformtools.ah.nullAsNil(this.yFX.fgp).toLowerCase();
        this.yFY = (long) this.yFX.fgo;
        this.nul = com.tencent.mm.platformtools.ah.nullAsNil(this.yFX.filemd5);
        this.cEV = com.tencent.mm.platformtools.ah.nullAsNil(this.yFX.cEV);
        this.eyr = com.tencent.mm.platformtools.ah.nullAsNil(this.yFX.eyr);
        if (com.tencent.mm.platformtools.ah.isNullOrNil(this.eov)) {
            this.eov = com.tencent.mm.vfs.e.cv(this.fileName);
        }
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", Long.valueOf(this.cvx), Integer.valueOf(this.cKd.field_isSend), this.cJh, Integer.valueOf(this.egi), this.cHr, this.fileName);
        com.tencent.mm.pluginsdk.model.app.b dBi = dBi();
        if (dBi == null) {
            ab.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
            this.yGa = false;
        } else {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(dBi.field_fileFullPath);
            if (dBi.field_offset > 0) {
                this.yGa = true;
            } else {
                this.yGa = false;
            }
            ab.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", dBi.field_fileFullPath, Long.valueOf(dBi.field_offset), Boolean.valueOf(this.yGa));
        }
        boolean b;
        if (!c(dBi)) {
            AppMethodBeat.o(30283);
            return true;
        } else if (this.scene == 1) {
            if (this.yGd) {
                b = com.tencent.mm.pluginsdk.ui.tools.a.b(this, dBi.field_fileFullPath, this.eov, 7);
                AppMethodBeat.o(30283);
                return b;
            }
            b = com.tencent.mm.pluginsdk.ui.tools.a.M(dBi.field_fileFullPath, this.eov, 7);
            AppMethodBeat.o(30283);
            return b;
        } else if (this.yGd) {
            b = com.tencent.mm.pluginsdk.ui.tools.a.b(this, dBi.field_fileFullPath, this.eov, 1);
            AppMethodBeat.o(30283);
            return b;
        } else {
            b = com.tencent.mm.pluginsdk.ui.tools.a.M(dBi.field_fileFullPath, this.eov, 1);
            AppMethodBeat.o(30283);
            return b;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(30284);
        am.aUq().d(this);
        super.onDestroy();
        AppMethodBeat.o(30284);
    }

    public void onResume() {
        AppMethodBeat.i(30285);
        super.onResume();
        aw.Rg().a(221, (f) this);
        aw.Rg().a(728, (f) this);
        com.tencent.mm.sdk.b.b meVar = new me();
        meVar.cHX.cHY = true;
        meVar.cHX.talker = this.cKd.field_talker;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, getMainLooper());
        ab.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.mlE.setEnabled(true);
        AppMethodBeat.o(30285);
    }

    public void onPause() {
        AppMethodBeat.i(30286);
        aw.Rg().b(221, (f) this);
        aw.Rg().b(728, (f) this);
        super.onPause();
        com.tencent.mm.sdk.b.b meVar = new me();
        meVar.cHX.cHY = false;
        meVar.cHX.talker = this.cKd.field_talker;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, getMainLooper());
        ab.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
        AppMethodBeat.o(30286);
    }

    public final void initView() {
        AppMethodBeat.i(30287);
        this.pvR = (MMImageView) findViewById(R.id.zf);
        this.yFP = (RoundProgressBtn) findViewById(R.id.baq);
        this.yFQ = new a((Button) findViewById(R.id.bar), (TextView) findViewById(R.id.bas));
        this.mlE = (Button) findViewById(R.id.bat);
        this.yFR = findViewById(R.id.ban);
        this.grM = (TextView) findViewById(R.id.bap);
        this.yFS = (TextView) findViewById(R.id.bao);
        this.yFT = (TextView) findViewById(R.id.bal);
        this.yFU = (TextView) findViewById(R.id.bam);
        this.yGe = (LinearLayout) findViewById(R.id.bak);
        this.yGf = (LinearLayout) findViewById(R.id.bau);
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
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30264);
                if (AppAttachDownloadUI.this.pJg != null) {
                    aw.Rg().c(AppAttachDownloadUI.this.pJg);
                }
                AppAttachDownloadUI.this.finish();
                AppMethodBeat.o(30264);
                return true;
            }
        });
        this.cHc = getIntent().getBooleanExtra("app_show_share", true);
        if (this.cHc) {
            addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(30268);
                    AppAttachDownloadUI.a(AppAttachDownloadUI.this, AppAttachDownloadUI.this.yFZ);
                    AppMethodBeat.o(30268);
                    return false;
                }
            });
        }
        this.yFZ = false;
        if (b(dBi())) {
            ab.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
            if (this.yFY > 0) {
                this.yFU.setVisibility(0);
                this.yFU.setText(getResources().getString(R.string.g7i, new Object[]{com.tencent.mm.platformtools.ah.ga(this.yFY)}));
            } else {
                this.yFU.setVisibility(8);
            }
            this.yFZ = true;
            dBj();
            AppMethodBeat.o(30287);
            return;
        }
        if (this.yFY > 0) {
            this.yFU.setVisibility(0);
            this.yFU.setText(getResources().getString(R.string.g7i, new Object[]{com.tencent.mm.platformtools.ah.ga(this.yFY)}));
        } else {
            this.yFU.setVisibility(8);
        }
        if (this.yFZ) {
            AppMethodBeat.o(30287);
            return;
        }
        dBc();
        start();
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", this.yFV, Boolean.valueOf(this.yFZ), Boolean.valueOf(this.yGa));
        if (this.egi == 2 || !(this.yFZ || this.yGa)) {
            dBf();
        }
        AppMethodBeat.o(30287);
    }

    private boolean b(com.tencent.mm.pluginsdk.model.app.b bVar) {
        AppMethodBeat.i(30288);
        if (bVar == null || !new com.tencent.mm.vfs.b(bVar.field_fileFullPath).exists()) {
            AppMethodBeat.o(30288);
            return false;
        } else if (bVar.bCR() || (this.cKd.field_isSend == 1 && bVar.field_isUpload)) {
            AppMethodBeat.o(30288);
            return true;
        } else {
            AppMethodBeat.o(30288);
            return false;
        }
    }

    private void dBb() {
        AppMethodBeat.i(30289);
        cl clVar = new cl();
        com.tencent.mm.pluginsdk.model.e.d(clVar, this.cKd);
        clVar.cvA.activity = this;
        clVar.cvA.cvH = 39;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        AppMethodBeat.o(30289);
    }

    private String aqY(String str) {
        AppMethodBeat.i(30290);
        if (this.yFW && str != null) {
            str = bf.oz(str);
        }
        AppMethodBeat.o(30290);
        return str;
    }

    private void dBc() {
        AppMethodBeat.i(30291);
        this.yFV = new g() {
            public final void a(int i, int i2, m mVar) {
                float f;
                AppMethodBeat.i(30270);
                if (i2 == 0) {
                    f = 0.0f;
                } else {
                    f = (((float) i) * 100.0f) / ((float) i2);
                }
                if (i < i2 && AppAttachDownloadUI.this.yFP.getVisibility() != 0) {
                    AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
                    AppAttachDownloadUI.this.yFQ.setVisibility(8);
                }
                AppAttachDownloadUI.this.yFP.setProgress((int) f);
                AppMethodBeat.o(30270);
            }
        };
        AppMethodBeat.o(30291);
    }

    private void ccI() {
        AppMethodBeat.i(30292);
        switch (this.egi) {
            case 0:
            case 7:
                if (bo.any(this.eov)) {
                    this.pvR.setImageResource(R.drawable.avp);
                    AppMethodBeat.o(30292);
                    return;
                }
                this.pvR.setImageResource(R.raw.app_attach_file_icon_unknow);
                AppMethodBeat.o(30292);
                return;
            case 2:
                this.pvR.setImageResource(R.drawable.avp);
                AppMethodBeat.o(30292);
                return;
            case 4:
                this.pvR.setImageResource(R.raw.app_attach_file_icon_video);
                AppMethodBeat.o(30292);
                return;
            case 6:
                this.pvR.setImageResource(o.aiD(this.eov));
                AppMethodBeat.o(30292);
                return;
            default:
                this.pvR.setImageResource(R.raw.app_attach_file_icon_unknow);
                AppMethodBeat.o(30292);
                return;
        }
    }

    private void dBd() {
        AppMethodBeat.i(30293);
        this.yFP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30271);
                AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
                AppAttachDownloadUI.this.yFQ.setVisibility(0);
                AppAttachDownloadUI.this.yFR.setVisibility(8);
                ab.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", AppAttachDownloadUI.this.pJg);
                if (AppAttachDownloadUI.this.pJg != null) {
                    AppAttachDownloadUI.this.pJg.a(AppAttachDownloadUI.this);
                    com.tencent.mm.kernel.g.Rg().c(AppAttachDownloadUI.this.pJg);
                    AppMethodBeat.o(30271);
                    return;
                }
                com.tencent.mm.pluginsdk.model.app.b n = AppAttachDownloadUI.n(AppAttachDownloadUI.this);
                if (!(n == null || n.field_status == 199)) {
                    ab.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", Long.valueOf(n.field_status));
                    n.field_status = 102;
                    am.aUq().a(n, new String[0]);
                }
                AppMethodBeat.o(30271);
            }
        });
        AppMethodBeat.o(30293);
    }

    private void dBe() {
        AppMethodBeat.i(30294);
        this.yFQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30272);
                AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
                AppAttachDownloadUI.this.yFQ.setVisibility(8);
                if (AppAttachDownloadUI.o(AppAttachDownloadUI.this)) {
                    com.tencent.mm.pluginsdk.model.app.b n = AppAttachDownloadUI.n(AppAttachDownloadUI.this);
                    if (n != null) {
                        n.field_status = 101;
                        n.field_lastModifyTime = bo.anT();
                        am.aUq().a(n, new String[0]);
                    }
                    AppAttachDownloadUI.this.pJg = new e(AppAttachDownloadUI.this.cvx, AppAttachDownloadUI.this.cHr, AppAttachDownloadUI.this.yFV);
                    aw.Rg().a(AppAttachDownloadUI.this.pJg, 0);
                }
                AppMethodBeat.o(30272);
            }
        });
        AppMethodBeat.o(30294);
    }

    private void dBf() {
        AppMethodBeat.i(30295);
        Ob(0);
        this.yFQ.setVisibility(8);
        if (dBg()) {
            ab.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
            this.pJg = new e(this.cvx, this.cHr, this.yFV);
            aw.Rg().a(this.pJg, 0);
            y.C(this.cKd);
        }
        AppMethodBeat.o(30295);
    }

    private void start() {
        AppMethodBeat.i(30296);
        switch (this.egi) {
            case 0:
            case 6:
                if (this.yGa) {
                    this.yFQ.setVisibility(0);
                } else {
                    this.yFQ.setVisibility(8);
                }
                Ob(8);
                this.yFR.setVisibility(8);
                this.mlE.setVisibility(8);
                dBn();
                this.yFT.setVisibility(0);
                if (this.fileName.equals("")) {
                    this.yFT.setText(getString(R.string.dar));
                } else {
                    this.yFT.setText(this.fileName);
                }
                String mimeType = getMimeType();
                if (mimeType == null || mimeType.equals("")) {
                    this.grM.setText(getString(R.string.b6l));
                } else {
                    this.grM.setText(getString(R.string.b6m));
                }
                if (bo.any(this.eov)) {
                    dBn();
                    AppMethodBeat.o(30296);
                    return;
                }
                break;
            case 2:
                Ob(8);
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
                Ob(8);
                this.yFR.setVisibility(8);
                this.mlE.setVisibility(8);
                this.yFT.setVisibility(8);
                dBn();
                this.grM.setText(getString(R.string.b6m));
                AppMethodBeat.o(30296);
                return;
        }
        AppMethodBeat.o(30296);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(30297);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.oy));
        AppMethodBeat.o(30297);
    }

    private boolean dBg() {
        boolean z;
        int i = -1;
        boolean z2 = true;
        AppMethodBeat.i(30298);
        com.tencent.mm.pluginsdk.model.app.b dBi = dBi();
        String str;
        if (dBi == null) {
            l.s(this.cvx, this.cJh);
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
                ab.i(str2, str, objArr);
                if (this.yFX.fgs != 0 || this.yFX.fgo > 26214400) {
                    boolean z3;
                    if (com.tencent.mm.platformtools.ah.isNullOrNil(dBi.field_signature)) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z2 = z3;
                }
            }
        } else {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(dBi.field_fileFullPath);
            if (dBi.field_status == 199 && !bVar.exists()) {
                ab.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
                l.s(this.cvx, this.cJh);
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
            objArr2[7] = Boolean.valueOf(bVar.exists());
            objArr2[8] = Long.valueOf(dBi.field_status);
            if (dBi.field_signature != null) {
                i = dBi.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i);
            ab.i(str, str3, objArr2);
        }
        if (this.yFX == null || (this.yFX.fgs == 0 && this.yFX.fgo <= 26214400)) {
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            aw.Rg().a(new com.tencent.mm.plugin.record.b.c(dBi, this.eyr, this.nul, this.fileName, this.eov, this.cEV), 0);
        }
        AppMethodBeat.o(30298);
        return z;
    }

    private void dBh() {
        AppMethodBeat.i(30299);
        this.mlE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30265);
                AppAttachDownloadUI.this.yGb = true;
                AppAttachDownloadUI.y(AppAttachDownloadUI.this);
                AppMethodBeat.o(30265);
            }
        });
        AppMethodBeat.o(30299);
    }

    private String getMimeType() {
        AppMethodBeat.i(30300);
        b me = b.me(this.cJh);
        String str = null;
        if (me.fgp != null && me.fgp.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(me.fgp);
        }
        if (str == null || str.length() == 0) {
            ab.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
            str = "*/" + me.fgp;
        }
        AppMethodBeat.o(30300);
        return str;
    }

    private com.tencent.mm.pluginsdk.model.app.b dBi() {
        AppMethodBeat.i(30301);
        com.tencent.mm.pluginsdk.model.app.b lZ = am.aUq().lZ(this.cvx);
        if (lZ != null) {
            ab.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", Long.valueOf(this.cvx), com.tencent.mm.platformtools.ah.anW());
            AppMethodBeat.o(30301);
        } else {
            lZ = l.aiM(this.cHr);
            if (lZ == null) {
                ab.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", com.tencent.mm.platformtools.ah.anW());
                AppMethodBeat.o(30301);
            } else if (lZ.field_msgInfoId == this.cvx || com.tencent.mm.vfs.e.ct(lZ.field_fileFullPath)) {
                AppMethodBeat.o(30301);
            } else {
                l.s(this.cvx, this.cJh);
                final com.tencent.mm.pluginsdk.model.app.b lZ2 = am.aUq().lZ(this.cvx);
                if (lZ2 == null) {
                    ab.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", com.tencent.mm.platformtools.ah.anW());
                    AppMethodBeat.o(30301);
                } else {
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            boolean a;
                            AppMethodBeat.i(30266);
                            long currentTimeMillis = System.currentTimeMillis();
                            long y = com.tencent.mm.vfs.e.y(lZ.field_fileFullPath, lZ2.field_fileFullPath);
                            if (y > 0) {
                                lZ2.field_offset = y;
                                if (AppAttachDownloadUI.d(lZ2)) {
                                    lZ2.field_status = 199;
                                }
                                a = am.aUq().a(lZ2, new String[0]);
                            } else {
                                a = false;
                            }
                            ab.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", Long.valueOf(y), Long.valueOf(lZ.field_msgInfoId), Long.valueOf(lZ2.field_msgInfoId), Boolean.valueOf(a), Long.valueOf(lZ2.field_status), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.o(30266);
                        }
                    }, "copyAttachFromLocal");
                    AppMethodBeat.o(30301);
                }
            }
        }
        return lZ;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(30302);
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, this.yGb, R.string.b6t, R.string.b6u, 1);
        AppMethodBeat.o(30302);
    }

    private void dBj() {
        AppMethodBeat.i(30304);
        switch (this.egi) {
            case 0:
            case 6:
                if (dBk()) {
                    if (bo.any(this.eov)) {
                        dBl();
                        AppMethodBeat.o(30304);
                        return;
                    }
                    String mimeType = getMimeType();
                    ab.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
                    dBn();
                    Ob(8);
                    this.yFR.setVisibility(8);
                    this.yFQ.setVisibility(8);
                    this.yFT.setVisibility(0);
                    if (this.fileName.equals("")) {
                        this.yFT.setText(getString(R.string.dar));
                    } else {
                        this.yFT.setText(this.fileName);
                    }
                    if (mimeType == null || mimeType.equals("")) {
                        this.mlE.setVisibility(8);
                        this.grM.setText(getString(R.string.b6l));
                        AppMethodBeat.o(30304);
                        return;
                    }
                    this.mlE.setVisibility(0);
                    this.grM.setText(getString(R.string.b6m));
                    AppMethodBeat.o(30304);
                    return;
                }
                break;
            case 2:
                if (dBk()) {
                    ccL();
                    AppMethodBeat.o(30304);
                    return;
                }
                break;
            case 7:
                Intent intent = new Intent();
                intent.putExtra("App_MsgId", this.cvx);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(30304);
                return;
            default:
                this.mlE.setVisibility(0);
                Ob(8);
                this.yFR.setVisibility(8);
                break;
        }
        AppMethodBeat.o(30304);
    }

    private boolean dBk() {
        AppMethodBeat.i(30305);
        com.tencent.mm.pluginsdk.model.app.b dBi = dBi();
        if (dBi == null) {
            AppMethodBeat.o(30305);
            return true;
        } else if (com.tencent.mm.vfs.e.ct(dBi.field_fileFullPath)) {
            Ob(8);
            this.yFR.setVisibility(8);
            this.yFQ.setVisibility(8);
            AppMethodBeat.o(30305);
            return true;
        } else {
            Ob(8);
            dBm();
            AppMethodBeat.o(30305);
            return false;
        }
    }

    private void dBl() {
        AppMethodBeat.i(30306);
        com.tencent.mm.pluginsdk.model.app.b dBi = dBi();
        Intent intent = new Intent(this, ShowImageUI.class);
        intent.putExtra("key_message_id", this.cKd.field_msgId);
        intent.putExtra("key_image_path", dBi.field_fileFullPath);
        intent.putExtra("key_favorite", true);
        startActivity(intent);
        finish();
        AppMethodBeat.o(30306);
    }

    private void ccL() {
        AppMethodBeat.i(30307);
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", this.cKd.field_msgId);
        intent.putExtra("img_gallery_talker", this.cKd.field_talker);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(30307);
    }

    public final int getLayoutId() {
        return R.layout.sw;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(30308);
        ab.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        Object[] objArr;
        if (mVar.getType() != 221 && mVar.getType() != 728) {
            AppMethodBeat.o(30308);
        } else if (mVar.getType() == 728 && i == 0 && i2 == 0) {
            com.tencent.mm.pluginsdk.model.app.b dBi = dBi();
            if (dBi == null) {
                ab.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
            } else {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                String str3 = "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach";
                objArr = new Object[1];
                objArr[0] = Integer.valueOf(dBi.field_signature == null ? -1 : dBi.field_signature.length());
                ab.i(str2, str3, objArr);
            }
            if (dBi != null) {
                dBi.field_status = 101;
                dBi.field_lastModifyTime = bo.anT();
                am.aUq().a(dBi, new String[0]);
            }
            this.pJg = new e(this.cvx, this.cHr, this.yFV);
            aw.Rg().a(this.pJg, 0);
            AppMethodBeat.o(30308);
        } else {
            if (this.pJg == null && (mVar instanceof e)) {
                e eVar = (e) mVar;
                com.tencent.mm.pluginsdk.model.app.b dBi2 = dBi();
                if (!(dBi2 == null || com.tencent.mm.platformtools.ah.isNullOrNil(dBi2.field_mediaSvrId) || !dBi2.field_mediaSvrId.equals(eVar.getMediaId()))) {
                    this.pJg = eVar;
                    ab.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", this.pJg, dBi2.field_mediaSvrId);
                }
            }
            com.tencent.mm.plugin.report.service.h hVar;
            int i3;
            if (i == 0 && i2 == 0) {
                hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
                hVar.e(14665, objArr);
                AppMethodBeat.o(30308);
                return;
            }
            if (i2 != 0 && com.tencent.mm.sdk.a.b.dnO()) {
                Toast.makeText(this, "errCode[" + i2 + "]", 0).show();
            }
            if (i2 == -5103059) {
                dBm();
                Ob(8);
                if (this.egi == 6) {
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
                    hVar.e(14665, objArr);
                }
                AppMethodBeat.o(30308);
                return;
            }
            Ob(8);
            this.yFQ.setVisibility(0);
            this.yFR.setVisibility(8);
            ab.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + mVar.getType() + " errType = " + i + ", errCode = " + i2);
            AppMethodBeat.o(30308);
        }
    }

    public final void ceD() {
        AppMethodBeat.i(30309);
        Toast.makeText(this, R.string.b6x, 0).show();
        AppMethodBeat.o(30309);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(30310);
        super.onNewIntent(intent);
        setIntent(intent);
        init();
        AppMethodBeat.o(30310);
    }

    private static boolean c(com.tencent.mm.pluginsdk.model.app.b bVar) {
        AppMethodBeat.i(30311);
        if (bVar == null) {
            AppMethodBeat.o(30311);
            return false;
        }
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(bVar.field_fileFullPath);
        if (bVar2.exists() && bVar2.length() == bVar.field_totalLen) {
            AppMethodBeat.o(30311);
            return true;
        }
        AppMethodBeat.o(30311);
        return false;
    }

    private void Ob(int i) {
        AppMethodBeat.i(30312);
        if (i != this.yFP.getVisibility()) {
            ab.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", Integer.valueOf(i), com.tencent.mm.platformtools.ah.anW());
            this.yFP.setVisibility(i);
        }
        AppMethodBeat.o(30312);
    }

    private void dBm() {
        AppMethodBeat.i(30313);
        this.yGe.setVisibility(0);
        this.yGf.setVisibility(8);
        dBn();
        this.yFQ.dBo();
        AppMethodBeat.o(30313);
    }

    private void dBn() {
        AppMethodBeat.i(30314);
        this.grM.setVisibility(8);
        AppMethodBeat.o(30314);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(30303);
        com.tencent.mm.pluginsdk.model.app.b dBi = dBi();
        if (dBi != null) {
            long j = dBi.field_totalLen;
            long j2 = dBi.field_offset;
            this.yFY = j;
            this.yFS.setText(getString(R.string.b6o, new Object[]{com.tencent.mm.platformtools.ah.ga(j2), com.tencent.mm.platformtools.ah.ga(j)}));
            int i = dBi.field_totalLen == 0 ? 0 : (int) ((dBi.field_offset * 100) / dBi.field_totalLen);
            ab.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + j2 + " totallen:" + j + " status " + dBi.field_status);
            this.yFP.setProgress(i);
            if (dBi.field_status == 199 && i >= 100 && !this.yFZ) {
                this.yFZ = true;
                if (this.yGg) {
                    this.yGg = false;
                    dBb();
                }
                if (dBi != null) {
                    Toast.makeText(this, getString(R.string.b71) + " : " + dBi.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.eSl, com.tencent.mm.compatible.util.e.euO), this.yGc).show();
                    com.tencent.mm.pluginsdk.ui.tools.a.a(this, dBi.field_fileFullPath, this.eov, 1);
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(30267);
                        AppAttachDownloadUI.z(AppAttachDownloadUI.this);
                        AppMethodBeat.o(30267);
                    }
                }, 200);
            }
            if (this.yFP.getVisibility() != 0 && i < 100 && !dBi.field_isUpload && dBi.field_status == 101) {
                ab.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", Integer.valueOf(i));
                Ob(0);
                this.yFQ.setVisibility(8);
            }
        }
        AppMethodBeat.o(30303);
    }

    static /* synthetic */ void e(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30318);
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        appAttachDownloadUI.startActivity(intent);
        com.tencent.mm.plugin.report.service.h.pYm.e(11168, Integer.valueOf(6), Integer.valueOf(1));
        AppMethodBeat.o(30318);
    }

    static /* synthetic */ void f(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30319);
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.cKd.field_msgId);
        appAttachDownloadUI.startActivity(intent);
        AppMethodBeat.o(30319);
    }

    static /* synthetic */ void g(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30320);
        if (appAttachDownloadUI.dBi() != null) {
            ji jiVar = new ji();
            jiVar.cEE.cut = 27;
            jiVar.cEE.cuu = 1;
            if (appAttachDownloadUI.dBi() != null) {
                jiVar.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
            }
            com.tencent.mm.sdk.b.a.xxA.m(jiVar);
            com.tencent.mm.ui.base.t.makeText(ah.getContext(), String.format("current template is %d", new Object[]{Integer.valueOf(aa.HV(0))}), 1).show();
        }
        AppMethodBeat.o(30320);
    }

    static /* synthetic */ void h(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30321);
        com.tencent.mm.g.a.bf bfVar = new com.tencent.mm.g.a.bf();
        bfVar.cus.cut = 35;
        bfVar.cus.cuu = 1;
        if (appAttachDownloadUI.dBi() != null) {
            bfVar.cus.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xxA.m(bfVar);
        com.tencent.mm.ui.base.t.makeText(ah.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(30321);
    }

    static /* synthetic */ void i(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30322);
        ji jiVar = new ji();
        jiVar.cEE.cut = 40;
        jiVar.cEE.cuu = 1;
        if (appAttachDownloadUI.dBi() != null) {
            jiVar.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
            jiVar.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xxA.m(jiVar);
        com.tencent.mm.ui.base.t.makeText(ah.getContext(), String.format("current wxa template is %d", new Object[]{Integer.valueOf(r.aLE())}), 1).show();
        AppMethodBeat.o(30322);
    }

    static /* synthetic */ void j(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30323);
        ji jiVar = new ji();
        jiVar.cEE.cut = 27;
        jiVar.cEE.cuu = 2;
        if (appAttachDownloadUI.dBi() != null) {
            jiVar.cEE.filePath = appAttachDownloadUI.dBi().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xxA.m(jiVar);
        com.tencent.mm.ui.base.t.makeText(ah.getContext(), String.format("current browse template is %d", new Object[]{Integer.valueOf(aa.HV(1))}), 1).show();
        AppMethodBeat.o(30323);
    }

    static /* synthetic */ void y(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(30327);
        com.tencent.mm.pluginsdk.model.app.b dBi = appAttachDownloadUI.dBi();
        if (dBi == null) {
            ab.e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
            AppMethodBeat.o(30327);
        } else if (dBi.field_fileFullPath == null || dBi.field_fileFullPath.length() == 0) {
            ab.e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
            AppMethodBeat.o(30327);
        } else {
            String str = dBi.field_fileFullPath;
            if (appAttachDownloadUI.scene == 1) {
                com.tencent.mm.pluginsdk.ui.tools.a.a(appAttachDownloadUI, str, appAttachDownloadUI.eov, 7);
            } else {
                com.tencent.mm.pluginsdk.ui.tools.a.a(appAttachDownloadUI, str, appAttachDownloadUI.eov, 1);
            }
            appAttachDownloadUI.mlE.setEnabled(false);
            AppMethodBeat.o(30327);
        }
    }
}
