package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class j implements com.tencent.mm.plugin.ipcall.a.b.b.a, e {
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
    c nGH;
    a nGI;
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

    public interface a {
        void ix(boolean z);
    }

    public j(IPCallTalkUI iPCallTalkUI) {
        AppMethodBeat.i(22411);
        this.nGG = iPCallTalkUI;
        this.nGH = i.bHv();
        this.nGH.nuX = this;
        AppMethodBeat.o(22411);
    }

    public final void b(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        AppMethodBeat.i(22412);
        this.nGO = this.nGG.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        ab.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", str, str2, str3, str4, str5, Boolean.valueOf(this.nGO));
        this.nGw = (ImageView) this.nGG.findViewById(R.id.cl3);
        this.eks = (ImageView) this.nGG.findViewById(R.id.cl4);
        this.nGu = (EditText) this.nGG.findViewById(R.id.ckw);
        this.gnh = (TextView) this.nGG.findViewById(R.id.ckt);
        this.nGv = (TextView) this.nGG.findViewById(R.id.cl1);
        this.nGx = (IPCallFuncButton) this.nGG.findViewById(R.id.cky);
        this.nGy = (IPCallFuncButton) this.nGG.findViewById(R.id.ckz);
        this.nGz = (IPCallFuncButton) this.nGG.findViewById(R.id.cl0);
        this.nGA = (ImageButton) this.nGG.findViewById(R.id.cl5);
        this.nGD = (ImageButton) this.nGG.findViewById(R.id.cl6);
        this.nGB = (TextView) this.nGG.findViewById(R.id.ckv);
        this.nGC = this.nGG.findViewById(R.id.cku);
        this.nzR = (DialPad) this.nGG.findViewById(R.id.cks);
        if (this.nGO) {
            bIG();
            bIB();
            bIC();
            bIH();
            AppMethodBeat.o(22412);
        } else if (i.bHu().bHk()) {
            h.a(this.nGG, (int) R.string.cdr, (int) R.string.tz, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22399);
                    j.this.nGG.finish();
                    AppMethodBeat.o(22399);
                }
            });
            AppMethodBeat.o(22412);
        } else {
            bIB();
            this.gHT = str;
            this.nCh = str2;
            this.nCi = str3;
            this.nCj = str4;
            this.nCl = i;
            this.nCm = i2;
            if (!bo.isNullOrNil(this.nCh)) {
                this.nCh = com.tencent.mm.plugin.ipcall.b.c.PA(this.nCh);
            }
            if (bo.isNullOrNil(this.nCj)) {
                if (com.tencent.mm.plugin.ipcall.b.a.Pu(this.nCh)) {
                    String Ps = com.tencent.mm.plugin.ipcall.b.a.Ps(this.nCh);
                    if (bo.isNullOrNil(Ps)) {
                        this.nCh = com.tencent.mm.plugin.ipcall.b.a.Pv(this.nCh);
                    } else {
                        this.nCh = com.tencent.mm.plugin.ipcall.b.a.Px(this.nCh);
                        this.nCj = Ps;
                    }
                }
                this.nCj = com.tencent.mm.plugin.ipcall.b.c.bIR();
            }
            ab.i("MicroMsg.TalkUIController", "final mCountryCode: %s", this.nCj);
            com.tencent.mm.plugin.ipcall.a.c.bHc().ON(this.nCj);
            if (bo.isNullOrNil(this.gHT)) {
                this.gHT = com.tencent.mm.plugin.ipcall.b.a.aF(this.nGG, this.nCh);
            }
            this.nCk = str5;
            bIA();
            ab.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", this.nGF);
            if (com.tencent.mm.plugin.ipcall.a.c.bHc().xf(bo.getInt(this.nCj, -1))) {
                bIz();
                AppMethodBeat.o(22412);
            } else if (at.isNetworkConnected(this.nGG)) {
                long j = this.nGG.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
                if (j <= System.currentTimeMillis() || j == -1) {
                    bIC();
                    if (!(this.nGO && i.bHu().bHk())) {
                        bIF();
                    }
                    this.nGQ = false;
                    AppMethodBeat.o(22412);
                    return;
                }
                ab.i("MicroMsg.TalkUIController", "onDisasterHappen");
                h.a(this.nGG, this.nGG.getString(R.string.cgl, new Object[]{String.valueOf(((j - r6) / 1000) + 1)}), this.nGG.getString(R.string.cgb), this.nGG.getString(R.string.cgc), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22403);
                        j.this.nGG.finish();
                        AppMethodBeat.o(22403);
                    }
                });
                AppMethodBeat.o(22412);
            } else {
                Toast.makeText(this.nGG, R.string.f6c, 1).show();
                this.nGG.finish();
                AppMethodBeat.o(22412);
            }
        }
    }

    private void bIz() {
        AppMethodBeat.i(22413);
        com.tencent.mm.plugin.report.service.h.pYm.X(12058, this.nCj);
        h.a(this.nGG, this.nGG.getString(R.string.abs), this.nGG.getString(R.string.abt), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(22404);
                j.this.nGG.finish();
                j.this.nGG = null;
                AppMethodBeat.o(22404);
            }
        });
        AppMethodBeat.o(22413);
    }

    private void c(String str, String str2, int i, String str3) {
        String str4;
        AppMethodBeat.i(22414);
        bIK();
        if (!bo.isNullOrNil(str)) {
            str4 = str;
        } else if (bo.isNullOrNil(str3)) {
            str4 = this.nGG.getString(R.string.cgb);
        } else {
            str4 = str3;
        }
        if (2 != i || str2 == null) {
            if (1 == i && str2 != null) {
                h.a(this.nGG, str2, str4, this.nGG.getString(R.string.cgc), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22405);
                        j.this.nGG.finish();
                        AppMethodBeat.o(22405);
                    }
                });
            }
            AppMethodBeat.o(22414);
            return;
        }
        this.gnh.setText(str2);
        AppMethodBeat.o(22414);
    }

    private void bIA() {
        AppMethodBeat.i(22415);
        if (bo.isNullOrNil(this.nCj) || com.tencent.mm.plugin.ipcall.b.a.Pu(this.nCh)) {
            this.nGF = this.nCh;
        } else {
            this.nGF = this.nCj + this.nCh;
            if (!this.nGF.startsWith("+")) {
                this.nGF = "+" + this.nGF;
                AppMethodBeat.o(22415);
                return;
            }
        }
        AppMethodBeat.o(22415);
    }

    private void bIB() {
        AppMethodBeat.i(22416);
        i.bHt().crP = this.nGG;
        i.bHt().bHI();
        i.bHt().nxk = this;
        i.bHt().a(this);
        AppMethodBeat.o(22416);
    }

    private void bIC() {
        AppMethodBeat.i(22417);
        this.nGu.setKeyListener(null);
        this.nGu.setHorizontallyScrolling(true);
        this.nzR.setVisibility(4);
        this.nzR.setTalkUIMode(true);
        bID();
        bIE();
        AppMethodBeat.o(22417);
    }

    /* Access modifiers changed, original: final */
    public final void Pm(String str) {
        AppMethodBeat.i(22418);
        if (bo.isNullOrNil(this.gHT)) {
            eN(com.tencent.mm.plugin.ipcall.b.a.Pw(str), "");
            AppMethodBeat.o(22418);
            return;
        }
        eN(this.gHT, com.tencent.mm.plugin.ipcall.b.a.Pw(str));
        AppMethodBeat.o(22418);
    }

    private void bID() {
        AppMethodBeat.i(22419);
        if (!bo.isNullOrNil(this.nGF)) {
            Pm(this.nGF);
        }
        if (d.iW(16)) {
            this.nGu.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nGv.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!bo.isNullOrNil(this.nCi)) {
            this.nGl = com.tencent.mm.plugin.ipcall.b.a.g(this.nGG, this.nCi, true);
        }
        if (this.nGl == null && !bo.isNullOrNil(this.nCh) && com.tencent.mm.plugin.ipcall.b.a.apV()) {
            this.nGl = com.tencent.mm.plugin.ipcall.b.a.aI(this.nGG, this.nCh);
        }
        if (this.nGl == null && !bo.isNullOrNil(this.nCk)) {
            this.nGl = b.d(this.nCk, 480, 480, 4);
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
        this.nGD.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Missing block: B:15:0x0064, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(22406);
     */
            /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(View view) {
                AppMethodBeat.i(22406);
                c bHv = i.bHv();
                synchronized (bHv.meM) {
                    try {
                        if (i.bHu().bHk()) {
                            if (bHv.nvf) {
                                bHv.bGS();
                            } else {
                                bHv.nvf = true;
                                Toast.makeText(ah.getContext(), R.string.d2y, 0).show();
                                Intent intent = new Intent();
                                intent.setFlags(268435456);
                                intent.setClass(ah.getContext(), IPCallTalkUI.class);
                                intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
                                com.tencent.mm.plugin.voip.b.cIk().a(intent, bHv.nvg);
                                bHv.bGS();
                                if (bHv.nuX != null) {
                                    bHv.nuX.bGZ();
                                }
                            }
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(22406);
                    }
                }
            }
        });
        this.nGz.setClickCallback(new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a() {
            public final void iv(boolean z) {
                AppMethodBeat.i(22407);
                ab.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", Boolean.valueOf(z));
                if (i.bHu().bHl()) {
                    j.this.nGL = z;
                    j.this.nGM = z;
                    i.bHt().io(z);
                    com.tencent.mm.plugin.report.service.h.pYm.e(12057, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(22407);
                    return;
                }
                if (!(i.bHA().DB() || i.bHu().bHn())) {
                    i.bHA().mE(z);
                }
                AppMethodBeat.o(22407);
            }
        });
        this.nGx.setClickCallback(new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a() {
            public final void iv(boolean z) {
                AppMethodBeat.i(22408);
                if (i.bHu().bHm()) {
                    int appCmd;
                    ab.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", Boolean.valueOf(z));
                    com.tencent.mm.plugin.ipcall.a.c.a bHr = i.bHr();
                    if (z) {
                        appCmd = bHr.nxx.setAppCmd(412);
                    } else {
                        appCmd = bHr.nxx.setAppCmd(413);
                    }
                    if (appCmd < 0) {
                        ab.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(appCmd)));
                    }
                    i.bHt().nxg.setMute(z);
                    com.tencent.mm.plugin.report.service.h.pYm.e(12057, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
                AppMethodBeat.o(22408);
            }
        });
        this.nGy.setClickCallback(new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a() {
            public final void iv(boolean z) {
                AppMethodBeat.i(22409);
                j jVar;
                if (z) {
                    jVar = j.this;
                    if (jVar.nGl == null) {
                        jVar.eks.setVisibility(8);
                    } else {
                        jVar.eks.setVisibility(4);
                    }
                    jVar.eks.setVisibility(8);
                    jVar.nGw.setVisibility(8);
                    jVar.nGu.setText("");
                    jVar.nGv.setText("");
                    jVar.nzR.setVisibility(0);
                } else {
                    jVar = j.this;
                    if (jVar.nGl != null) {
                        jVar.eks.setVisibility(0);
                        jVar.nGw.setVisibility(8);
                    } else {
                        jVar.nGw.setVisibility(0);
                        jVar.eks.setVisibility(8);
                    }
                    jVar.Pm(jVar.nGF);
                    jVar.nzR.setVisibility(4);
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(12057, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                AppMethodBeat.o(22409);
            }
        });
        this.nGA.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22410);
                j.b(j.this);
                AppMethodBeat.o(22410);
            }
        });
        AppMethodBeat.o(22419);
    }

    private void bIE() {
        AppMethodBeat.i(22420);
        this.nzR.setDialButtonClickListener(new com.tencent.mm.plugin.ipcall.ui.DialPad.a() {
            public final void OX(String str) {
                AppMethodBeat.i(22400);
                String obj = j.this.nGu.getText().toString();
                if (bo.isNullOrNil(obj)) {
                    j.this.nGK = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j.this.nGK >= 3000) {
                    obj = obj + " ";
                }
                obj = obj + str;
                j.this.nGK = currentTimeMillis;
                j.this.eN(obj, "");
                c.OL(str);
                com.tencent.mm.plugin.report.service.h.pYm.e(12057, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                AppMethodBeat.o(22400);
            }

            public final void OY(String str) {
            }
        });
        AppMethodBeat.o(22420);
    }

    /* Access modifiers changed, original: final */
    public final void eN(String str, String str2) {
        AppMethodBeat.i(22421);
        this.nGu.setText(str);
        if (!bo.isNullOrNil(str)) {
            this.nGu.setSelection(this.nGu.getText().length() - 1);
        }
        this.nGv.setText(str2);
        AppMethodBeat.o(22421);
    }

    private void bIF() {
        AppMethodBeat.i(22422);
        this.nGE = com.tencent.mm.plugin.ipcall.b.a.eO(this.nCi, this.nCh);
        xw(1);
        this.nGH.a(this.gHT, this.nCh, this.nCk, this.nGF, this.nCi, this.nGE, this.nCl, this.nCm);
        ab.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", this.nGF);
        i.bHs().setCountryCode(this.nCj);
        AppMethodBeat.o(22422);
    }

    private void bIG() {
        AppMethodBeat.i(22423);
        if (i.bHq().nvN != null) {
            this.gHT = i.bHq().nvN.nickname;
            this.nGF = i.bHq().nvN.nwW;
            this.nCk = i.bHq().nvN.cMr;
            this.nCi = i.bHq().nvN.cOz;
            this.nCh = i.bHq().nvN.nwV;
            this.nGE = i.bHq().nvN.nwY;
            ab.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", this.gHT, this.nGF, this.nCk, this.nCi, this.nCh, Integer.valueOf(this.nGE));
        }
        AppMethodBeat.o(22423);
    }

    private void bIH() {
        AppMethodBeat.i(22424);
        i.bHu();
        ab.i("MicroMsg.TalkUIController", f.stateToString(i.bHu().mCurrentState));
        xw(i.bHu().mCurrentState);
        bIJ();
        bII();
        AppMethodBeat.o(22424);
    }

    private void bII() {
        AppMethodBeat.i(22425);
        if (i.bHu().bHl()) {
            IPCallFuncButton iPCallFuncButton = this.nGz;
            i.bHt();
            iPCallFuncButton.setChecked(com.tencent.mm.plugin.ipcall.a.b.a.KU());
            this.nGx.setChecked(i.bHt().nxg.eif);
        }
        AppMethodBeat.o(22425);
    }

    private void bIJ() {
        AppMethodBeat.i(22426);
        String str = i.bHq().nvN.nwW;
        String str2 = i.bHq().nvN.nwX;
        if (bo.isNullOrNil(str2)) {
            if (!bo.isNullOrNil(str)) {
                Pm(str);
                this.nGv.setText(com.tencent.mm.plugin.ipcall.b.a.Pw(str));
            }
            AppMethodBeat.o(22426);
            return;
        }
        Pm(str2);
        this.nGv.setText(com.tencent.mm.plugin.ipcall.b.a.Pw(str2));
        AppMethodBeat.o(22426);
    }

    private void xw(int i) {
        AppMethodBeat.i(22427);
        switch (i) {
            case 1:
                AppMethodBeat.o(22427);
                return;
            case 3:
                String xz = com.tencent.mm.plugin.ipcall.b.c.xz(i.bHq().nvN.nwK);
                if (this.nGE != -1) {
                    String xx = com.tencent.mm.plugin.ipcall.b.a.xx(this.nGE);
                    this.gnh.setText(xz + this.nGG.getString(R.string.ci3, new Object[]{xx}));
                    AppMethodBeat.o(22427);
                    return;
                }
                this.gnh.setText(xz + this.nGG.getString(R.string.ci2));
                AppMethodBeat.o(22427);
                return;
            case 4:
                AppMethodBeat.o(22427);
                return;
            case 5:
                this.gnh.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(this.nGJ / 60), Long.valueOf(this.nGJ % 60)}));
                AppMethodBeat.o(22427);
                return;
            case 10:
                this.gnh.setText(R.string.ci6);
                break;
        }
        AppMethodBeat.o(22427);
    }

    public final void bGJ() {
        int i = 0;
        AppMethodBeat.i(22428);
        ab.i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = i.bHq().nvN.nwW;
        String str2 = i.bHq().nvN.nwX;
        if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str2) || str.equals(str2))) {
            ab.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", str, str2);
            Pm(str2);
        }
        ab.i("MicroMsg.TalkUIController", "callFlag:" + i.bHq().nvN.nwK);
        int i2 = i.bHq().nvN.nwK;
        if ((i2 & 1) > 0 && (i2 & 2) > 0 && (i2 & 8) <= 0) {
            i = 1;
        }
        if (i != 0) {
            ab.i("MicroMsg.TalkUIController", "isNotFree");
            h.a(this.nGG, (int) R.string.cih, (int) R.string.cii, (int) R.string.cig, (int) R.string.cif, true, null, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22401);
                    ab.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
                    j.b(j.this);
                    AppMethodBeat.o(22401);
                }
            });
        }
        xw(3);
        AppMethodBeat.o(22428);
    }

    public final void bGK() {
        AppMethodBeat.i(22429);
        ab.d("MicroMsg.TalkUIController", "onStartRing");
        if (i.bHu().bHl()) {
            this.nGL = this.nGz.isChecked();
            this.nGM = this.nGz.isChecked();
            i.bHt().io(this.nGz.isChecked());
        }
        AppMethodBeat.o(22429);
    }

    public final void bGX() {
        AppMethodBeat.i(22430);
        ab.d("MicroMsg.TalkUIController", "onUserAccept");
        if (i.bHu().bHl()) {
            this.nGL = this.nGz.isChecked();
            this.nGM = this.nGz.isChecked();
            i.bHt().io(this.nGz.isChecked());
        }
        if (i.bHu().bHm()) {
            i.bHt().nxg.setMute(this.nGx.isChecked());
        }
        AppMethodBeat.o(22430);
    }

    public final void bGY() {
        AppMethodBeat.i(22431);
        ab.d("MicroMsg.TalkUIController", "onOthersideShutdown");
        bIK();
        xw(10);
        aw.getNotification().cancel(42);
        if (this.nGI != null) {
            this.nGI.ix(true);
        }
        AppMethodBeat.o(22431);
    }

    public final void d(int i, String str, String str2, int i2) {
        AppMethodBeat.i(22432);
        ab.d("MicroMsg.TalkUIController", "onError, error: %d", Integer.valueOf(i));
        if (i2 == 1) {
            this.nGP = false;
        }
        if (i != 8) {
            c(str, str2, i2, null);
        } else if (i2 == 1) {
            String string;
            if (bo.isNullOrNil(str)) {
                string = this.nGG.getString(R.string.cgb);
            } else {
                string = str;
            }
            h.a(this.nGG, str2, string, this.nGG.getString(R.string.cgc), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22402);
                    j.this.nGG.finish();
                    AppMethodBeat.o(22402);
                }
            });
        } else {
            c(str, str2, i2, this.nGG.getString(R.string.cga));
        }
        aw.getNotification().cancel(42);
        if (!(this.nGI == null || this.nGQ)) {
            this.nGI.ix(this.nGP);
        }
        AppMethodBeat.o(22432);
    }

    public final void ir(boolean z) {
        AppMethodBeat.i(22433);
        ab.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (i.bHu().bHl()) {
            if (z) {
                i.bHt();
                this.nGL = com.tencent.mm.plugin.ipcall.a.b.a.KU();
                i.bHt().io(false);
                this.nGz.setEnable(false);
                AppMethodBeat.o(22433);
                return;
            }
            i.bHt().io(this.nGL);
            this.nGz.setEnable(true);
            this.nGz.setChecked(this.nGL);
        }
        AppMethodBeat.o(22433);
    }

    public final void is(boolean z) {
        AppMethodBeat.i(22434);
        ab.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (i.bHu().bHl()) {
            if (z) {
                i.bHt();
                this.nGM = com.tencent.mm.plugin.ipcall.a.b.a.KU();
                i.bHt().io(false);
                this.nGz.setEnable(false);
                AppMethodBeat.o(22434);
                return;
            }
            i.bHt().io(this.nGM);
            this.nGz.setEnable(true);
            this.nGz.setChecked(this.nGM);
        }
        AppMethodBeat.o(22434);
    }

    public final void bHa() {
        AppMethodBeat.i(22435);
        this.nGJ = (long) i.bHv().bGU();
        xw(5);
        AppMethodBeat.o(22435);
    }

    public final void bGZ() {
        AppMethodBeat.i(22436);
        this.nGG.finish();
        AppMethodBeat.o(22436);
    }

    public final void bIK() {
        AppMethodBeat.i(22437);
        if (this.nGB != null) {
            this.nGB.setVisibility(4);
        }
        if (this.nGC != null) {
            this.nGC.setVisibility(4);
        }
        AppMethodBeat.o(22437);
    }

    static /* synthetic */ void b(j jVar) {
        AppMethodBeat.i(22438);
        jVar.nGH.eo(0, 0);
        aw.getNotification().cancel(42);
        jVar.nGG.finish();
        AppMethodBeat.o(22438);
    }
}
