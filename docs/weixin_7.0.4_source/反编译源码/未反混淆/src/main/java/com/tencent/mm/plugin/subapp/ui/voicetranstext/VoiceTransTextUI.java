package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class VoiceTransTextUI extends MMActivity implements OnClickListener, f {
    private int AL;
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long edW;
    private ScrollView hJh = null;
    private int itR;
    private View kRR = null;
    private bi kua;
    private Button lWE = null;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25599);
            int i = message.what;
            if (i == 1) {
                VoiceTransTextUI.b(VoiceTransTextUI.this, true);
                AppMethodBeat.o(25599);
                return;
            }
            if (i == 2) {
                VoiceTransTextUI.b(VoiceTransTextUI.this, false);
            }
            AppMethodBeat.o(25599);
        }
    };
    private int mTouchSlop;
    private long pDz = 0;
    private cc srD;
    private a srJ;
    private c srK;
    private b srL;
    private com.tencent.mm.modelvoice.b srM;
    private volatile boolean srO = false;
    private boolean srP = false;
    private ap srQ;
    private View svW = null;
    private View svX = null;
    private LinearLayout svY = null;
    private TextView svZ = null;
    private int swa = 6;
    private boolean swb = false;
    private p swc;
    private c swd;
    private boolean swe = false;
    private boolean swf = false;
    private int swg;
    private OnTouchListener swh;
    private OnClickListener swi = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(25591);
            VoiceTransTextUI.this.finish();
            AppMethodBeat.o(25591);
        }
    };
    private ClipboardManager swj;
    private OnLongClickListener swk = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(25593);
            ab.d("MicroMsg.VoiceTransTextUI", "onLongClick");
            h.a(VoiceTransTextUI.this, "", new String[]{VoiceTransTextUI.this.getString(R.string.oy)}, "", new h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(25592);
                    if (!(i != 0 || VoiceTransTextUI.this.swj == null || VoiceTransTextUI.this.svZ == null)) {
                        VoiceTransTextUI.this.swj.setText(VoiceTransTextUI.this.svZ.getText());
                    }
                    AppMethodBeat.o(25592);
                }
            });
            AppMethodBeat.o(25593);
            return false;
        }
    };

    enum b {
        done,
        loading,
        fail;

        static {
            AppMethodBeat.o(25608);
        }
    }

    enum a {
        CHECK,
        UPLOAD,
        UPLOAD_MORE,
        GET;

        static {
            AppMethodBeat.o(25605);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoiceTransTextUI() {
        AppMethodBeat.i(25609);
        AppMethodBeat.o(25609);
    }

    public void onCreate(Bundle bundle) {
        int i;
        cc ccVar = null;
        AppMethodBeat.i(25610);
        super.onCreate(bundle);
        this.mTouchSlop = ViewConfiguration.get(this.mController.ylL).getScaledTouchSlop();
        this.swj = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        this.kRR = findViewById(R.id.f2j);
        this.svW = findViewById(R.id.f2o);
        this.svX = findViewById(R.id.f2q);
        this.svZ = (TextView) findViewById(R.id.f2n);
        this.lWE = (Button) findViewById(R.id.f2l);
        this.svY = (LinearLayout) findViewById(R.id.f2k);
        this.hJh = (ScrollView) findViewById(R.id.asg);
        this.swh = new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(25594);
                switch (motionEvent.getAction()) {
                    case 0:
                        VoiceTransTextUI.c(VoiceTransTextUI.this);
                        VoiceTransTextUI.this.itR = view.getScrollY();
                        VoiceTransTextUI.this.AL = VoiceTransTextUI.this.itR;
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
                        if (Math.abs(VoiceTransTextUI.this.AL - view.getScrollY()) > VoiceTransTextUI.this.mTouchSlop) {
                            VoiceTransTextUI.this.mHandler.sendMessage(VoiceTransTextUI.this.mHandler.obtainMessage(0, view));
                        }
                        if (VoiceTransTextUI.j(VoiceTransTextUI.this) < 800 && Math.abs(VoiceTransTextUI.this.AL - view.getScrollY()) <= VoiceTransTextUI.this.mTouchSlop && !VoiceTransTextUI.this.swf) {
                            VoiceTransTextUI.this.mHandler.removeMessages(0);
                            VoiceTransTextUI.l(VoiceTransTextUI.this);
                            VoiceTransTextUI.this.finish();
                        }
                        VoiceTransTextUI.this.swf = false;
                        break;
                }
                AppMethodBeat.o(25594);
                return false;
            }
        };
        this.svZ.setOnLongClickListener(this.swk);
        this.svZ.setOnClickListener(this.swi);
        this.edW = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.edW < 0) {
            i = 0;
        } else {
            ab.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", Long.valueOf(this.edW));
            cd amb = m.amb();
            if (this.edW >= 0) {
                cc ccVar2 = new cc();
                Cursor a = amb.bSd.a("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(r6)}, null, null, null, 2);
                if (a.moveToFirst()) {
                    ccVar2.d(a);
                }
                a.close();
                ccVar = ccVar2;
            }
            this.srD = ccVar;
            if (this.srD == null || bo.isNullOrNil(this.srD.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (bo.isNullOrNil(string)) {
                    i = 0;
                } else {
                    this.swc = m.ama().uZ(string);
                    if (this.swc != null) {
                        ab.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        i = 1;
                    } else {
                        aw.ZK();
                        this.kua = com.tencent.mm.model.c.XO().jf(this.edW);
                        if (this.kua != null) {
                            ab.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                }
            } else {
                ab.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                i = 1;
            }
        }
        if (i == 0) {
            ab.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            AppMethodBeat.o(25610);
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        initView();
        AppMethodBeat.o(25610);
    }

    public final int getLayoutId() {
        return R.layout.b2c;
    }

    public final void initView() {
        Object obj;
        AppMethodBeat.i(25611);
        setMMTitle((int) R.string.f3i);
        this.lWE.setOnClickListener(this);
        if (this.srD == null || bo.isNullOrNil(this.srD.field_content)) {
            obj = null;
        } else {
            a(b.done, this.srD.field_content);
            if (!(this.hJh == null || this.svY == null)) {
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(25601);
                        VoiceTransTextUI.this.hJh.setPadding(0, 0, 0, 0);
                        VoiceTransTextUI.this.svY.setGravity(17);
                        AppMethodBeat.o(25601);
                    }
                }, 5);
            }
            obj = 1;
        }
        if (obj != null) {
            AppMethodBeat.o(25611);
            return;
        }
        a(b.loading, null);
        a(a.CHECK);
        AppMethodBeat.o(25611);
    }

    private void a(a aVar) {
        AppMethodBeat.i(25612);
        cDU();
        switch (aVar) {
            case CHECK:
                ab.i("MicroMsg.VoiceTransTextUI", "net check");
                if (HB() > 0) {
                    ab.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", Long.valueOf(HB()));
                    this.srJ = new a(cDV(), cDW(), cDX().getFormat(), HB(), getFileName());
                } else {
                    ab.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", Long.valueOf(HB()));
                    this.srJ = new a(cDV(), cDW(), getFileName());
                }
                aw.Rg().a(this.srJ, 0);
                aw.Rg().a(this.srJ.getType(), (f) this);
                if (this.swd == null) {
                    cDY();
                    AppMethodBeat.o(25612);
                    return;
                }
                break;
            case UPLOAD:
                ab.i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.srJ == null) {
                    ab.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    AppMethodBeat.o(25612);
                    return;
                } else if (cDX() == null) {
                    ab.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
                    AppMethodBeat.o(25612);
                    return;
                } else {
                    this.srK = new c(cDV(), this.srJ.svS, cDX().getFormat(), getFileName());
                    aw.Rg().a(this.srK, 0);
                    aw.Rg().a(this.srK.getType(), (f) this);
                    AppMethodBeat.o(25612);
                    return;
                }
            case UPLOAD_MORE:
                ab.i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.srK == null) {
                    ab.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    AppMethodBeat.o(25612);
                    return;
                }
                this.srK = new c(this.srK);
                aw.Rg().a(this.srK, 0);
                aw.Rg().a(this.srK.getType(), (f) this);
                AppMethodBeat.o(25612);
                return;
            case GET:
                this.swb = false;
                if (!this.srO) {
                    ab.i("MicroMsg.VoiceTransTextUI", "net get");
                    if (this.srJ != null) {
                        this.srO = true;
                        this.srL = new b(cDV());
                        aw.Rg().a(this.srL, 0);
                        aw.Rg().a(this.srL.getType(), (f) this);
                        break;
                    }
                    ab.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                    AppMethodBeat.o(25612);
                    return;
                }
                ab.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                AppMethodBeat.o(25612);
                return;
        }
        AppMethodBeat.o(25612);
    }

    private void a(b bVar, String str) {
        AppMethodBeat.i(25613);
        while (true) {
            switch (bVar) {
                case done:
                    if (!bo.isNullOrNil(str)) {
                        this.svY.setVisibility(0);
                        this.svW.setVisibility(8);
                        this.lWE.setVisibility(4);
                        this.svX.setVisibility(8);
                        this.svZ.setText(str);
                        lZ(true);
                        break;
                    }
                    bVar = b.fail;
                    str = null;
                case loading:
                    this.svY.setVisibility(0);
                    this.svW.setVisibility(0);
                    this.lWE.setVisibility(0);
                    if (str != null) {
                        this.svZ.setText(str);
                        lZ(false);
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
        if (bVar == b.done || bVar == b.fail) {
            this.hJh.setOnTouchListener(this.swh);
            this.kRR.setOnClickListener(this.swi);
            AppMethodBeat.o(25613);
            return;
        }
        this.hJh.setOnTouchListener(null);
        this.kRR.setOnClickListener(null);
        AppMethodBeat.o(25613);
    }

    private void cDU() {
        AppMethodBeat.i(25614);
        ab.d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.srJ != null) {
            aw.Rg().c(this.srJ);
            aw.Rg().b(this.srJ.getType(), (f) this);
        }
        if (this.srK != null) {
            aw.Rg().c(this.srK);
            aw.Rg().b(this.srK.getType(), (f) this);
        }
        if (this.srL != null) {
            aw.Rg().c(this.srL);
            aw.Rg().b(this.srL.getType(), (f) this);
        }
        AppMethodBeat.o(25614);
    }

    private String cDV() {
        AppMethodBeat.i(25615);
        String str;
        if (this.swc != null) {
            str = this.swc.clientId;
            AppMethodBeat.o(25615);
            return str;
        }
        str = this.kua.field_talker + this.kua.field_msgId + "T" + this.kua.field_createTime;
        AppMethodBeat.o(25615);
        return str;
    }

    private cc abi(String str) {
        AppMethodBeat.i(25616);
        cc ccVar = new cc();
        ccVar.field_msgId = this.edW;
        ccVar.aqa(cDV());
        ccVar.field_content = str;
        AppMethodBeat.o(25616);
        return ccVar;
    }

    private int cDW() {
        AppMethodBeat.i(25617);
        int i;
        if (this.swc != null) {
            i = this.swc.frO;
            AppMethodBeat.o(25617);
            return i;
        }
        i = o.uj(this.kua.field_imgPath);
        AppMethodBeat.o(25617);
        return i;
    }

    private long HB() {
        return this.swc == null ? -1 : this.swc.cKK;
    }

    private String getFileName() {
        if (this.swc != null) {
            return this.swc.fileName;
        }
        return this.kua.field_imgPath;
    }

    private com.tencent.mm.modelvoice.b cDX() {
        AppMethodBeat.i(25618);
        if (this.srM == null) {
            if (this.swc != null) {
                this.srM = q.uN(this.swc.fileName);
            } else if (this.kua != null) {
                this.srM = q.uN(this.kua.field_imgPath);
            } else {
                ab.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
        }
        com.tencent.mm.modelvoice.b bVar = this.srM;
        AppMethodBeat.o(25618);
        return bVar;
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        String str2 = null;
        AppMethodBeat.i(25619);
        if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 546:
                    if (this.srJ.mState == a.svQ) {
                        ab.i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.srJ.cDR()) {
                            str2 = this.srJ.svR.xlH;
                        }
                        abs(str2);
                        AppMethodBeat.o(25619);
                        return;
                    } else if (this.srJ.mState == a.svP) {
                        if (this.srJ.svR != null && bo.isNullOrNil(this.srJ.svR.xlH)) {
                            a(b.loading, this.srJ.svR.xlH);
                        }
                        ab.i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        a(a.GET);
                        AppMethodBeat.o(25619);
                        return;
                    } else if (this.srJ.mState == a.svO) {
                        ab.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        a(a.UPLOAD);
                        AppMethodBeat.o(25619);
                        return;
                    } else if (this.srJ.svT != null) {
                        this.swa = this.srJ.svT.wRe;
                        AppMethodBeat.o(25619);
                        return;
                    }
                    break;
                case 547:
                    if (this.srK.cDT()) {
                        ab.i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        a(a.GET);
                        AppMethodBeat.o(25619);
                        return;
                    }
                    ab.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", Integer.valueOf(this.srK.svS.ptx), Integer.valueOf(this.srK.svS.pty));
                    a(a.UPLOAD_MORE);
                    AppMethodBeat.o(25619);
                    return;
                case 548:
                    this.swa = this.srL.svV;
                    this.srO = false;
                    if (!this.srL.isComplete() && this.srL.cDR()) {
                        a(b.loading, this.srL.svR.xlH);
                        ab.d("MicroMsg.VoiceTransTextUI", "result valid:%s", this.srL.svR.xlH);
                    } else if (!this.srL.cDR()) {
                        ab.d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.srL.isComplete()) {
                        ab.i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.srL.cDR()) {
                            str2 = this.srL.svR.xlH;
                        }
                        abs(str2);
                        AppMethodBeat.o(25619);
                        return;
                    } else if (this.swb) {
                        ab.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        a(a.GET);
                        AppMethodBeat.o(25619);
                        return;
                    } else {
                        ab.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", Integer.valueOf(this.swa));
                        final int i3 = this.swa;
                        if (!this.srP) {
                            if (this.srQ == null) {
                                this.srQ = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                                    public final boolean BI() {
                                        AppMethodBeat.i(25595);
                                        if (VoiceTransTextUI.this.srP) {
                                            AppMethodBeat.o(25595);
                                        } else {
                                            ab.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", Integer.valueOf(i3));
                                            VoiceTransTextUI.a(VoiceTransTextUI.this, a.GET);
                                            AppMethodBeat.o(25595);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i3 * 1000);
                            this.srQ.ae(j, j);
                        }
                        AppMethodBeat.o(25619);
                        return;
                    }
                default:
                    AppMethodBeat.o(25619);
                    return;
            }
        }
        this.srP = true;
        a(b.fail, null);
        AppMethodBeat.o(25619);
    }

    private void abs(String str) {
        AppMethodBeat.i(25620);
        this.srP = true;
        if (!bo.isNullOrNil(str)) {
            m.amb().a(abi(str));
        }
        a(b.done, str);
        AppMethodBeat.o(25620);
    }

    public void onDestroy() {
        AppMethodBeat.i(25621);
        cDU();
        if (this.srQ != null) {
            this.srQ.stopTimer();
        }
        if (this.swd != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.swd);
            this.swd = null;
        }
        super.onDestroy();
        AppMethodBeat.o(25621);
    }

    private void cDY() {
        AppMethodBeat.i(25622);
        if (this.swd == null) {
            this.swd = new c<ku>() {
                {
                    AppMethodBeat.i(25597);
                    this.xxI = ku.class.getName().hashCode();
                    AppMethodBeat.o(25597);
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(25598);
                    ku kuVar = (ku) bVar;
                    ab.i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
                    if (VoiceTransTextUI.this.srJ != null && !VoiceTransTextUI.this.srP && (kuVar instanceof ku) && kuVar.cGJ.cGK == VoiceTransTextUI.this.srJ.svU) {
                        ab.i("MicroMsg.VoiceTransTextUI", "");
                        if (VoiceTransTextUI.this.srO) {
                            ab.i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                            VoiceTransTextUI.this.swb = true;
                        } else {
                            new ak(VoiceTransTextUI.this.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(25596);
                                    ab.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
                                    if (VoiceTransTextUI.this.srQ != null) {
                                        VoiceTransTextUI.this.srQ.stopTimer();
                                    }
                                    VoiceTransTextUI.a(VoiceTransTextUI.this, a.GET);
                                    AppMethodBeat.o(25596);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(25598);
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.swd);
        AppMethodBeat.o(25622);
    }

    public void onClick(View view) {
        AppMethodBeat.i(25623);
        finish();
        AppMethodBeat.o(25623);
    }

    private void lZ(final boolean z) {
        AppMethodBeat.i(25624);
        if (this.hJh == null || this.svY == null) {
            AppMethodBeat.o(25624);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25600);
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
                        AppMethodBeat.o(25600);
                        return;
                    }
                }
                AppMethodBeat.o(25600);
            }
        }, 5);
        AppMethodBeat.o(25624);
    }

    static /* synthetic */ void c(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.i(25625);
        voiceTransTextUI.pDz = bo.yz();
        AppMethodBeat.o(25625);
    }

    static /* synthetic */ long j(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.i(25626);
        long yz = bo.yz() - voiceTransTextUI.pDz;
        AppMethodBeat.o(25626);
        return yz;
    }

    static /* synthetic */ void l(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.i(25627);
        voiceTransTextUI.itR = 0;
        voiceTransTextUI.AL = 0;
        voiceTransTextUI.swe = false;
        voiceTransTextUI.swf = false;
        voiceTransTextUI.mHandler.removeMessages(0);
        AppMethodBeat.o(25627);
    }
}
