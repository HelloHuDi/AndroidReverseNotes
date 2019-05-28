package com.tencent.p177mm.plugin.talkroom.p538ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p203bg.C32336d;
import com.tencent.p177mm.p230g.p231a.C18322me;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.talkroom.model.C36823c;
import com.tencent.p177mm.plugin.talkroom.model.C39952b;
import com.tencent.p177mm.plugin.talkroom.model.C43685h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.cgm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C35988ay.C30291a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI */
public class TalkRoomUI extends MMBaseActivity implements C1202f, C32336d {
    private List<String> cFX = new LinkedList();
    private C44275p eir;
    private TextView gne;
    private TextView nDX;
    private final C7564ap nNC = new C7564ap(new C716310(), true);
    private boolean nND = true;
    private Chronometer nNI;
    private int nNJ = 0;
    private boolean nNp = true;
    private String nNq;
    private String nNr;
    private boolean nNt = false;
    private int nNu = 0;
    private long nNv = 500;
    private long nNw = 0;
    private C7564ap nNx = new C7564ap(new C352875(), false);
    private C7564ap nNy = new C7564ap(new C294231(), false);
    private C7564ap nNz = new C7564ap(new C71649(), false);
    private float radius = -1.0f;
    private AlphaAnimation szA;
    private AlphaAnimation szB;
    private float szC = -1.0f;
    private float szD = -1.0f;
    private TextView szp;
    private ImageButton szq;
    private Button szr;
    private ImageView szs;
    private TalkRoomVolumeMeter szt;
    private TalkRoomAvatarsFrame szu;
    private C43689a szv;
    private boolean szw = true;
    private int szx = 0;
    private AlphaAnimation szy;
    private AlphaAnimation szz;
    private WakeLock wakeLock;

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$8 */
    class C42018 implements C30291a {
        C42018() {
        }

        /* renamed from: EA */
        public final void mo7762EA() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$10 */
    class C716310 implements C5015a {
        C716310() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            short akx;
            int i = 15;
            boolean z = false;
            AppMethodBeat.m2504i(25914);
            if (TalkRoomUI.this.nNu == 3) {
                akx = C39952b.cEh().akx();
            } else if (C5046bo.isNullOrNil(TalkRoomUI.this.nNr)) {
                TalkRoomUI.m61210d(TalkRoomUI.this);
                AppMethodBeat.m2505o(25914);
                return false;
            } else {
                akx = C39952b.cEh().aky();
            }
            if (akx <= (short) 15) {
                if (!TalkRoomUI.this.szw) {
                    i = 0;
                }
                TalkRoomUI.this.szx = TalkRoomUI.this.szx + 1;
                if (TalkRoomUI.this.szx >= 5) {
                    TalkRoomUI talkRoomUI = TalkRoomUI.this;
                    if (!TalkRoomUI.this.szw) {
                        z = true;
                    }
                    talkRoomUI.szw = z;
                    TalkRoomUI.this.szx = 0;
                }
            } else {
                short s = akx;
            }
            TalkRoomUI.m61210d(TalkRoomUI.this);
            TalkRoomUI.this.szt.setValue(i);
            AppMethodBeat.m2505o(25914);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$9 */
    class C71649 implements C5015a {
        C71649() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25913);
            TalkRoomUI.m61219m(TalkRoomUI.this);
            AppMethodBeat.m2505o(25913);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$11 */
    class C1393611 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$11$1 */
        class C139371 implements DialogInterface.OnClickListener {
            C139371() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(25915);
                TalkRoomUI.this.nND = false;
                C39952b.cEh().cEw();
                TalkRoomUI.this.finish();
                AppMethodBeat.m2505o(25915);
            }
        }

        C1393611() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25916);
            C30379h.m48440a(TalkRoomUI.this, TalkRoomUI.this.getString(C25738R.string.euk), TalkRoomUI.this.getString(C25738R.string.euj), new C139371(), null);
            AppMethodBeat.m2505o(25916);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$12 */
    class C1393812 implements OnClickListener {
        C1393812() {
        }

        public final void onClick(View view) {
            int i;
            AppMethodBeat.m2504i(25917);
            TalkRoomUI talkRoomUI = TalkRoomUI.this;
            C9638aw.m17190ZK();
            if (C5046bo.m7512a((Integer) C18628c.m29072Ry().get(144641, null), 0) > 0) {
                i = 0;
            } else {
                C15532i c15532i = new C15532i(talkRoomUI, C25738R.style.f11418zw);
                LinearLayout linearLayout = (LinearLayout) C5616v.m8409hu(C4996ah.getContext()).inflate(2130970919, null);
                linearLayout.setMinimumWidth(Downloads.MIN_WAIT_FOR_NETWORK);
                Button button = (Button) linearLayout.findViewById(2131828229);
                c15532i.setCanceledOnTouchOutside(true);
                c15532i.setOnDismissListener(new C3682617());
                c15532i.setCancelable(false);
                button.setOnClickListener(new C223982(c15532i));
                c15532i.setContentView(linearLayout);
                c15532i.show();
                boolean i2 = true;
            }
            if (i2 == 0) {
                TalkRoomUI.this.onBackPressed();
            }
            AppMethodBeat.m2505o(25917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13 */
    class C1394013 implements OnTouchListener {

        /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$1 */
        class C139391 implements C30291a {
            C139391() {
            }

            /* renamed from: EA */
            public final void mo7762EA() {
                AppMethodBeat.m2504i(25918);
                C4990ab.m7416i("MicroMsg.TalkRoomUI", "play press sound end");
                AppMethodBeat.m2505o(25918);
            }
        }

        /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$2 */
        class C139412 implements C30291a {
            C139412() {
            }

            /* renamed from: EA */
            public final void mo7762EA() {
                AppMethodBeat.m2504i(25919);
                C4990ab.m7416i("MicroMsg.TalkRoomUI", "play up sound end");
                AppMethodBeat.m2505o(25919);
            }
        }

        C1394013() {
        }

        /* JADX WARNING: Missing block: B:10:0x0077, code skipped:
            if (com.tencent.p177mm.plugin.talkroom.p538ui.TalkRoomUI.m61205a(r6.szE, r8) == false) goto L_0x0079;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(25920);
            switch (motionEvent.getAction()) {
                case 0:
                    TalkRoomUI.this.nNt = TalkRoomUI.m61205a(TalkRoomUI.this, motionEvent);
                    if (TalkRoomUI.this.nNt) {
                        TalkRoomUI.this.szq.setImageResource(C25738R.drawable.apn);
                        C35988ay.m59199a(C4996ah.getContext(), C25738R.string.ev4, new C139391());
                        TalkRoomUI.this.nNu = 1;
                        TalkRoomUI.m61210d(TalkRoomUI.this);
                        C4990ab.m7416i("MicroMsg.TalkRoomUI", "micBtn pressed down");
                        TalkRoomUI.this.nNw = C5046bo.m7588yz();
                        C39952b.cEh().akz();
                        TalkRoomUI.m61219m(TalkRoomUI.this);
                        break;
                    }
                    break;
                case 2:
                    if (TalkRoomUI.this.nNt) {
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (TalkRoomUI.this.nNt) {
                        TalkRoomUI.this.nNt = false;
                        if (TalkRoomUI.this.nNu == 5) {
                            C4990ab.m7416i("MicroMsg.TalkRoomUI", "cancel during seize-success prepare time");
                            TalkRoomUI.this.nNx.stopTimer();
                            TalkRoomUI.this.nNy.stopTimer();
                        }
                        TalkRoomUI.this.szq.setImageResource(C25738R.drawable.apm);
                        TalkRoomUI.this.nNu = 0;
                        TalkRoomUI.m61210d(TalkRoomUI.this);
                        TalkRoomUI.this.nNC.stopTimer();
                        C39952b.cEh().akA();
                        C35988ay.m59199a(C4996ah.getContext(), C25738R.string.ev7, new C139412());
                        TalkRoomUI.m61219m(TalkRoomUI.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(25920);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$2 */
    class C223982 implements OnClickListener {
        final /* synthetic */ C15532i szF;

        C223982(C15532i c15532i) {
            this.szF = c15532i;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25908);
            this.szF.dismiss();
            AppMethodBeat.m2505o(25908);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$1 */
    class C294231 implements C5015a {
        C294231() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25907);
            C4990ab.m7416i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
            TalkRoomUI.m61204a(TalkRoomUI.this);
            AppMethodBeat.m2505o(25907);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$5 */
    class C352875 implements C5015a {
        C352875() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25910);
            C4990ab.m7416i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
            TalkRoomUI.m61224q(TalkRoomUI.this);
            AppMethodBeat.m2505o(25910);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$7 */
    class C352887 implements DialogInterface.OnClickListener {
        C352887() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25912);
            TalkRoomUI.this.finish();
            AppMethodBeat.m2505o(25912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$a */
    abstract class C35289a {
        float hke;
        float hkf;
        long szJ;

        public abstract void cEL();

        private C35289a() {
        }

        /* synthetic */ C35289a(TalkRoomUI talkRoomUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$17 */
    class C3682617 implements OnDismissListener {
        C3682617() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(25924);
            C9638aw.m17190ZK();
            int a = C5046bo.m7512a((Integer) C18628c.m29072Ry().get(144641, null), 0) + 1;
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(144641, Integer.valueOf(a));
            TalkRoomUI.this.onBackPressed();
            AppMethodBeat.m2505o(25924);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$4 */
    class C368274 implements C30291a {
        C368274() {
        }

        /* renamed from: EA */
        public final void mo7762EA() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$6 */
    class C368286 implements C30291a {
        C368286() {
        }

        /* renamed from: EA */
        public final void mo7762EA() {
            AppMethodBeat.m2504i(25911);
            TalkRoomUI.this.nNy.stopTimer();
            TalkRoomUI.m61204a(TalkRoomUI.this);
            AppMethodBeat.m2505o(25911);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$14 */
    class C3682914 extends C35289a {
        C3682914() {
            super(TalkRoomUI.this, (byte) 0);
        }

        public final void cEL() {
            AppMethodBeat.m2504i(25921);
            TalkRoomUI.this.onBackPressed();
            AppMethodBeat.m2505o(25921);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$16 */
    class C3683016 implements OnClickListener {
        C3683016() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25923);
            TalkRoomUI.this.onBackPressed();
            AppMethodBeat.m2505o(25923);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public TalkRoomUI() {
        AppMethodBeat.m2504i(25925);
        AppMethodBeat.m2505o(25925);
    }

    /* renamed from: d */
    static /* synthetic */ void m61210d(TalkRoomUI talkRoomUI) {
        AppMethodBeat.m2504i(25955);
        talkRoomUI.cEH();
        AppMethodBeat.m2505o(25955);
    }

    /* renamed from: m */
    static /* synthetic */ void m61219m(TalkRoomUI talkRoomUI) {
        AppMethodBeat.m2504i(25957);
        talkRoomUI.bKa();
        AppMethodBeat.m2505o(25957);
    }

    /* renamed from: q */
    static /* synthetic */ void m61224q(TalkRoomUI talkRoomUI) {
        AppMethodBeat.m2504i(25958);
        talkRoomUI.bJZ();
        AppMethodBeat.m2505o(25958);
    }

    private void cEH() {
        AppMethodBeat.m2504i(25926);
        if (this.nNu == 3 || this.nNu == 5) {
            this.szt.setShowFlame(true);
            AppMethodBeat.m2505o(25926);
        } else if (C5046bo.isNullOrNil(this.nNr)) {
            this.szt.setShowFlame(false);
            AppMethodBeat.m2505o(25926);
        } else {
            this.szt.setShowFlame(true);
            AppMethodBeat.m2505o(25926);
        }
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25927);
        C4990ab.m7410d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("enter_room_username");
        C4990ab.m7417i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", stringExtra);
        C4990ab.m7411d("MicroMsg.TalkRoomUI", "talkRoomName %s ", stringExtra);
        this.nNq = stringExtra;
        if (C5046bo.isNullOrNil(this.nNq)) {
            abv("");
        } else {
            if (C1855t.m3896kH(stringExtra)) {
                List my = C37921n.m64074my(stringExtra);
                if (my == null) {
                    C26417a.flu.mo20967ai(stringExtra, "");
                } else {
                    this.cFX = my;
                }
            } else {
                this.cFX.clear();
                this.cFX.add(stringExtra);
                this.cFX.add(C1853r.m3846Yz());
            }
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(25909);
                    C39952b.cEh().mo4627ac(stringExtra, 0);
                    AppMethodBeat.m2505o(25909);
                }
            });
        }
        C4990ab.m7410d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(C5616v.m8409hu(C4996ah.getContext()).inflate(2130970914, null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.gne = (TextView) findViewById(2131821185);
        this.szp = (TextView) findViewById(2131828212);
        this.nDX = (TextView) findViewById(2131823158);
        this.szr = (Button) findViewById(2131828208);
        this.nNI = (Chronometer) findViewById(2131826443);
        this.szs = (ImageView) findViewById(2131828213);
        this.szv = new C43689a(this);
        this.szr.setOnClickListener(new C1393611());
        findViewById(2131828209).setOnClickListener(new C1393812());
        this.szq = (ImageButton) findViewById(2131828214);
        this.szq.setEnabled(false);
        this.szq.setImageResource(C25738R.drawable.apo);
        this.szq.setOnTouchListener(new C1394013());
        this.szt = (TalkRoomVolumeMeter) findViewById(2131824679);
        final C3682914 c3682914 = new C3682914();
        findViewById(2131828207).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(25922);
                C35289a c35289a = c3682914;
                int action = motionEvent.getAction();
                if (action == 0) {
                    c35289a.hke = motionEvent.getX();
                    c35289a.hkf = motionEvent.getY();
                    c35289a.szJ = C5046bo.m7588yz();
                    AppMethodBeat.m2505o(25922);
                    return true;
                }
                if (action == 1 || action == 3) {
                    float abs = Math.abs(motionEvent.getX() - c35289a.hke);
                    float y = c35289a.hkf - motionEvent.getY();
                    if (y >= 100.0f && y / abs > 2.0f && y / ((float) C5046bo.m7525az(c35289a.szJ)) > 0.6f) {
                        c35289a.cEL();
                        AppMethodBeat.m2505o(25922);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(25922);
                return false;
            }
        });
        this.szu = (TalkRoomAvatarsFrame) findViewById(2131828210);
        this.gne.setOnClickListener(new C3683016());
        this.szy = new AlphaAnimation(0.0f, 1.0f);
        this.szy.setDuration(300);
        this.szy.setFillAfter(true);
        this.szz = new AlphaAnimation(1.0f, 0.0f);
        this.szz.setDuration(300);
        this.szz.setFillAfter(true);
        this.szA = new AlphaAnimation(0.0f, 1.0f);
        this.szA.setDuration(300);
        this.szA.setFillAfter(true);
        this.szB = new AlphaAnimation(1.0f, 0.0f);
        this.szB.setDuration(300);
        this.szB.setFillAfter(true);
        C9638aw.m17182Rg().mo14539a(364, (C1202f) this);
        C4990ab.m7410d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        C39952b.cEh().mo4626a((C32336d) this);
        C4990ab.m7410d("MicroMsg.TalkRoomUI", "onCreate end");
        AppMethodBeat.m2505o(25927);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25928);
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.acquire();
        this.gne.setText(C44089j.m79293b((Context) this, C43685h.m78271aU(this, this.nNq), this.gne.getTextSize()));
        C39952b.cEg().sxK.sxP = true;
        C39952b.cEg();
        C4990ab.m7418v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        C39952b.cEg();
        C36823c.cEo();
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = true;
        C4879a.xxA.mo10048a(c18322me, getMainLooper());
        C4990ab.m7410d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
        AppMethodBeat.m2505o(25928);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25929);
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.release();
        this.nNC.stopTimer();
        C39952b.cEg().sxK.sxP = false;
        C39952b.cEg();
        C36823c c36823c = C39952b.cEg().sxK;
        if (c36823c.nNp) {
            c36823c.abt(C4996ah.getContext().getString(C25738R.string.euq));
        } else if (C5046bo.isNullOrNil(c36823c.nMN)) {
            c36823c.abt(C43685h.m78271aU(C4996ah.getContext(), C39952b.cEh().syD));
        } else {
            String string = C4996ah.getContext().getString(C25738R.string.euw, new Object[]{C1854s.m3866mJ(c36823c.nMN)});
            C36823c.cEo();
            c36823c.abt(string);
        }
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = false;
        C4879a.xxA.mo10048a(c18322me, getMainLooper());
        C4990ab.m7410d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
        AppMethodBeat.m2505o(25929);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25930);
        C39952b.cEh().mo4634b((C32336d) this);
        C9638aw.m17182Rg().mo14546b(364, (C1202f) this);
        if (this.eir != null && this.eir.isShowing()) {
            this.eir.cancel();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(25930);
    }

    public void finish() {
        AppMethodBeat.m2504i(25931);
        super.finish();
        AppMethodBeat.m2505o(25931);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(25932);
        if (i == 25) {
            C9638aw.m17191ZL().mo4839iK(3);
            AppMethodBeat.m2505o(25932);
            return true;
        } else if (i == 24) {
            C9638aw.m17191ZL().mo4838iJ(3);
            AppMethodBeat.m2505o(25932);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(25932);
            return onKeyDown;
        }
    }

    public final void akC() {
        AppMethodBeat.m2504i(25933);
        this.nNp = false;
        this.szq.setEnabled(true);
        this.szq.setImageResource(C25738R.drawable.apm);
        this.szr.setVisibility(0);
        bKa();
        cEJ();
        cEI();
        AppMethodBeat.m2505o(25933);
    }

    /* renamed from: l */
    public final void mo53061l(String str, int i, int i2) {
        AppMethodBeat.m2504i(25934);
        C4990ab.m7415f("MicroMsg.TalkRoomUI", "onInitFailed %s", str);
        String str2 = "";
        if (i == 4) {
            if (i2 != -1) {
                this.nND = false;
                finish();
                AppMethodBeat.m2505o(25934);
                return;
            }
            str2 = getString(C25738R.string.eun);
        }
        abv(str2);
        AppMethodBeat.m2505o(25934);
    }

    /* renamed from: mk */
    public final void mo53062mk(int i) {
        AppMethodBeat.m2504i(25935);
        C4990ab.m7416i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
        if (i == 340) {
            if (this.nNu != 3) {
                AppMethodBeat.m2505o(25935);
                return;
            }
            this.nNu = 4;
        } else if (this.nNu != 1) {
            AppMethodBeat.m2505o(25935);
            return;
        } else {
            this.nNu = 2;
        }
        cEH();
        bKa();
        C35988ay.m59200a(C4996ah.getContext(), new C368274());
        AppMethodBeat.m2505o(25935);
    }

    public final void akD() {
        AppMethodBeat.m2504i(25936);
        C4990ab.m7416i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.nNu != 1) {
            AppMethodBeat.m2505o(25936);
            return;
        }
        this.nNu = 5;
        if (C5046bo.m7525az(this.nNw) < this.nNv) {
            C4990ab.m7416i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
            long az = this.nNv - C5046bo.m7525az(this.nNw);
            this.nNx.mo16770ae(az, az);
            AppMethodBeat.m2505o(25936);
            return;
        }
        bJZ();
        AppMethodBeat.m2505o(25936);
    }

    private void bJZ() {
        AppMethodBeat.m2504i(25937);
        if (this.nNu != 5) {
            AppMethodBeat.m2505o(25937);
            return;
        }
        this.nNx.stopTimer();
        bKa();
        cEH();
        C35988ay.m59199a(C4996ah.getContext(), C25738R.string.ev0, new C368286());
        this.nNy.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(25937);
    }

    /* renamed from: g */
    public final void mo53060g(int i, int i2, String str) {
        AppMethodBeat.m2504i(25938);
        C4990ab.m7415f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        abv("");
        AppMethodBeat.m2505o(25938);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25939);
        if (c1207m.getType() == 364 && this.eir != null && this.eir.isShowing()) {
            this.eir.cancel();
        }
        AppMethodBeat.m2505o(25939);
    }

    private void abv(String str) {
        AppMethodBeat.m2504i(25940);
        if (this.nND) {
            this.nND = false;
            C39952b.cEh().cEw();
            if (C5046bo.isNullOrNil(str)) {
                if (C5023at.isConnected(getApplication())) {
                    str = getString(C25738R.string.eun);
                } else {
                    str = getString(C25738R.string.euo);
                }
            }
            if (isFinishing()) {
                AppMethodBeat.m2505o(25940);
                return;
            }
            C30379h.m48438a((Context) this, str, "", new C352887());
            AppMethodBeat.m2505o(25940);
            return;
        }
        C4990ab.m7416i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
        AppMethodBeat.m2505o(25940);
    }

    /* renamed from: tO */
    public final void mo53063tO(String str) {
        AppMethodBeat.m2504i(25941);
        C4990ab.m7411d("MicroMsg.TalkRoomUI", "onCurMember %s", str);
        this.nNr = str;
        cEH();
        bKa();
        if (C5046bo.isNullOrNil(str)) {
            this.nNC.stopTimer();
            AppMethodBeat.m2505o(25941);
            return;
        }
        C35988ay.m59199a(C4996ah.getContext(), C25738R.string.ev3, new C42018());
        this.nNC.mo16770ae(100, 100);
        AppMethodBeat.m2505o(25941);
    }

    public final void akE() {
        AppMethodBeat.m2504i(25942);
        if (this.nND) {
            this.nND = false;
            finish();
            AppMethodBeat.m2505o(25942);
            return;
        }
        C4990ab.m7416i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
        AppMethodBeat.m2505o(25942);
    }

    public final void akF() {
        AppMethodBeat.m2504i(25943);
        bKa();
        AppMethodBeat.m2505o(25943);
    }

    public final void akG() {
        AppMethodBeat.m2504i(25944);
        bKa();
        AppMethodBeat.m2505o(25944);
    }

    public final void akH() {
        AppMethodBeat.m2504i(25945);
        m61220m(getString(C25738R.string.eur), C25738R.color.a2o);
        AppMethodBeat.m2505o(25945);
    }

    private void cEI() {
        AppMethodBeat.m2504i(25946);
        List<cgm> bJF = C39952b.cEh().bJF();
        LinkedList linkedList = new LinkedList();
        for (cgm cgm : bJF) {
            linkedList.add(cgm.jBB);
        }
        this.szu.setMembersList(linkedList);
        AppMethodBeat.m2505o(25946);
    }

    /* renamed from: aU */
    public final void mo53053aU(String str, String str2) {
        AppMethodBeat.m2504i(25947);
        C4990ab.m7417i("MicroMsg.TalkRoomUI", "add %s,  del %s", str, str2);
        cEI();
        if (this.nNp) {
            AppMethodBeat.m2505o(25947);
            return;
        }
        cEJ();
        if (!C5046bo.isNullOrNil(str)) {
            abw(getString(C25738R.string.eud, new Object[]{C1854s.m3866mJ(str)}));
            this.nNz.mo16770ae(3000, 3000);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            abw(getString(C25738R.string.eui, new Object[]{C1854s.m3866mJ(str2)}));
            this.nNz.mo16770ae(3000, 3000);
        }
        AppMethodBeat.m2505o(25947);
    }

    private void bKa() {
        AppMethodBeat.m2504i(25948);
        if (this.nNp) {
            AppMethodBeat.m2505o(25948);
        } else if (C39952b.cEh().syR) {
            m61220m(getString(C25738R.string.eup), C25738R.color.a2o);
            this.szu.setCurMemeber(null);
            this.szs.setImageResource(C25738R.drawable.api);
            cEK();
            AppMethodBeat.m2505o(25948);
        } else {
            switch (this.nNu) {
                case 0:
                    if (C5046bo.isNullOrNil(this.nNr)) {
                        CharSequence string;
                        if (C39952b.cEh().bJF().size() == 1) {
                            string = getString(C25738R.string.euy);
                        } else {
                            string = "";
                        }
                        m61220m(string, C25738R.color.a2n);
                        this.szu.setCurMemeber(null);
                        this.szs.setImageResource(C25738R.drawable.api);
                        cEK();
                        AppMethodBeat.m2505o(25948);
                        return;
                    }
                    abw(C1854s.m3866mJ(this.nNr));
                    this.szu.setCurMemeber(this.nNr);
                    this.szs.setImageResource(C25738R.drawable.api);
                    m61201Fw(1);
                    AppMethodBeat.m2505o(25948);
                    return;
                case 1:
                    m61220m(getString(C25738R.string.euc), C25738R.color.a2n);
                    this.szs.setImageResource(C25738R.drawable.apl);
                    AppMethodBeat.m2505o(25948);
                    return;
                case 2:
                    m61220m(getString(C25738R.string.eus), C25738R.color.a2o);
                    this.szs.setImageResource(C25738R.drawable.apk);
                    AppMethodBeat.m2505o(25948);
                    return;
                case 3:
                case 5:
                    m61220m(getString(C25738R.string.eut), C25738R.color.a2n);
                    this.szu.setCurMemeber(C1853r.m3846Yz());
                    this.szs.setImageResource(C25738R.drawable.apj);
                    m61201Fw(2);
                    AppMethodBeat.m2505o(25948);
                    return;
                case 4:
                    m61220m(getString(C25738R.string.euv), C25738R.color.a2o);
                    this.szs.setImageResource(C25738R.drawable.apk);
                    cEK();
                    break;
            }
            AppMethodBeat.m2505o(25948);
        }
    }

    private void cEJ() {
        AppMethodBeat.m2504i(25949);
        C4990ab.m7417i("MicroMsg.TalkRoomUI", "displayCount %d", Integer.valueOf(C39952b.cEh().bJF().size()));
        this.nDX.setText(String.valueOf(r0));
        AppMethodBeat.m2505o(25949);
    }

    private void abw(String str) {
        AppMethodBeat.m2504i(25950);
        m61220m(C44089j.m79293b((Context) this, (CharSequence) str, this.szp.getTextSize()), C25738R.color.a2n);
        AppMethodBeat.m2505o(25950);
    }

    /* renamed from: m */
    private void m61220m(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(25951);
        if (C5046bo.isNullOrNil(charSequence.toString())) {
            this.szp.startAnimation(this.szB);
            AppMethodBeat.m2505o(25951);
            return;
        }
        this.szp.setTextColor(getResources().getColor(i));
        this.szp.setText(charSequence);
        this.szp.startAnimation(this.szA);
        AppMethodBeat.m2505o(25951);
    }

    /* renamed from: Fw */
    private void m61201Fw(int i) {
        AppMethodBeat.m2504i(25952);
        if (i == 0 || this.nNJ != i) {
            this.nNI.setVisibility(0);
            this.nNI.startAnimation(this.szy);
            this.nNI.setBase(C5046bo.m7588yz());
            this.nNI.start();
            this.nNJ = i;
            AppMethodBeat.m2505o(25952);
            return;
        }
        AppMethodBeat.m2505o(25952);
    }

    private void cEK() {
        AppMethodBeat.m2504i(25953);
        if (this.nNJ == 0) {
            AppMethodBeat.m2505o(25953);
            return;
        }
        this.nNI.stop();
        this.nNJ = 0;
        this.nNI.startAnimation(this.szz);
        AppMethodBeat.m2505o(25953);
    }

    /* renamed from: a */
    static /* synthetic */ void m61204a(TalkRoomUI talkRoomUI) {
        AppMethodBeat.m2504i(25954);
        if (talkRoomUI.nNu == 5) {
            talkRoomUI.nNu = 3;
            C39952b.cEh().akw();
            talkRoomUI.nNC.mo16770ae(100, 100);
        }
        AppMethodBeat.m2505o(25954);
    }
}
