package com.tencent.mm.plugin.talkroom.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.me;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.v;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI extends MMBaseActivity implements f, d {
    private List<String> cFX = new LinkedList();
    private p eir;
    private TextView gne;
    private TextView nDX;
    private final ap nNC = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            short akx;
            int i = 15;
            boolean z = false;
            AppMethodBeat.i(25914);
            if (TalkRoomUI.this.nNu == 3) {
                akx = b.cEh().akx();
            } else if (bo.isNullOrNil(TalkRoomUI.this.nNr)) {
                TalkRoomUI.d(TalkRoomUI.this);
                AppMethodBeat.o(25914);
                return false;
            } else {
                akx = b.cEh().aky();
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
            TalkRoomUI.d(TalkRoomUI.this);
            TalkRoomUI.this.szt.setValue(i);
            AppMethodBeat.o(25914);
            return true;
        }
    }, true);
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
    private ap nNx = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(25910);
            ab.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
            TalkRoomUI.q(TalkRoomUI.this);
            AppMethodBeat.o(25910);
            return false;
        }
    }, false);
    private ap nNy = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(25907);
            ab.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
            TalkRoomUI.a(TalkRoomUI.this);
            AppMethodBeat.o(25907);
            return false;
        }
    }, false);
    private ap nNz = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(25913);
            TalkRoomUI.m(TalkRoomUI.this);
            AppMethodBeat.o(25913);
            return false;
        }
    }, false);
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
    private a szv;
    private boolean szw = true;
    private int szx = 0;
    private AlphaAnimation szy;
    private AlphaAnimation szz;
    private WakeLock wakeLock;

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ i szF;

        AnonymousClass2(i iVar) {
            this.szF = iVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(25908);
            this.szF.dismiss();
            AppMethodBeat.o(25908);
        }
    }

    abstract class a {
        float hke;
        float hkf;
        long szJ;

        public abstract void cEL();

        private a() {
        }

        /* synthetic */ a(TalkRoomUI talkRoomUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TalkRoomUI() {
        AppMethodBeat.i(25925);
        AppMethodBeat.o(25925);
    }

    static /* synthetic */ void d(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(25955);
        talkRoomUI.cEH();
        AppMethodBeat.o(25955);
    }

    static /* synthetic */ void m(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(25957);
        talkRoomUI.bKa();
        AppMethodBeat.o(25957);
    }

    static /* synthetic */ void q(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(25958);
        talkRoomUI.bJZ();
        AppMethodBeat.o(25958);
    }

    private void cEH() {
        AppMethodBeat.i(25926);
        if (this.nNu == 3 || this.nNu == 5) {
            this.szt.setShowFlame(true);
            AppMethodBeat.o(25926);
        } else if (bo.isNullOrNil(this.nNr)) {
            this.szt.setShowFlame(false);
            AppMethodBeat.o(25926);
        } else {
            this.szt.setShowFlame(true);
            AppMethodBeat.o(25926);
        }
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25927);
        ab.d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("enter_room_username");
        ab.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", stringExtra);
        ab.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", stringExtra);
        this.nNq = stringExtra;
        if (bo.isNullOrNil(this.nNq)) {
            abv("");
        } else {
            if (t.kH(stringExtra)) {
                List my = n.my(stringExtra);
                if (my == null) {
                    com.tencent.mm.model.ao.a.flu.ai(stringExtra, "");
                } else {
                    this.cFX = my;
                }
            } else {
                this.cFX.clear();
                this.cFX.add(stringExtra);
                this.cFX.add(r.Yz());
            }
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(25909);
                    b.cEh().ac(stringExtra, 0);
                    AppMethodBeat.o(25909);
                }
            });
        }
        ab.d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(v.hu(ah.getContext()).inflate(R.layout.azc, null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.gne = (TextView) findViewById(R.id.qm);
        this.szp = (TextView) findViewById(R.id.ev_);
        this.nDX = (TextView) findViewById(R.id.b6n);
        this.szr = (Button) findViewById(R.id.ev6);
        this.nNI = (Chronometer) findViewById(R.id.dkg);
        this.szs = (ImageView) findViewById(R.id.eva);
        this.szv = new a(this);
        this.szr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25916);
                h.a(TalkRoomUI.this, TalkRoomUI.this.getString(R.string.euk), TalkRoomUI.this.getString(R.string.euj), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(25915);
                        TalkRoomUI.this.nND = false;
                        b.cEh().cEw();
                        TalkRoomUI.this.finish();
                        AppMethodBeat.o(25915);
                    }
                }, null);
                AppMethodBeat.o(25916);
            }
        });
        findViewById(R.id.ev7).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i;
                AppMethodBeat.i(25917);
                TalkRoomUI talkRoomUI = TalkRoomUI.this;
                aw.ZK();
                if (bo.a((Integer) c.Ry().get(144641, null), 0) > 0) {
                    i = 0;
                } else {
                    i iVar = new i(talkRoomUI, R.style.zw);
                    LinearLayout linearLayout = (LinearLayout) v.hu(ah.getContext()).inflate(R.layout.azh, null);
                    linearLayout.setMinimumWidth(Downloads.MIN_WAIT_FOR_NETWORK);
                    Button button = (Button) linearLayout.findViewById(R.id.evq);
                    iVar.setCanceledOnTouchOutside(true);
                    iVar.setOnDismissListener(new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(25924);
                            aw.ZK();
                            int a = bo.a((Integer) c.Ry().get(144641, null), 0) + 1;
                            aw.ZK();
                            c.Ry().set(144641, Integer.valueOf(a));
                            TalkRoomUI.this.onBackPressed();
                            AppMethodBeat.o(25924);
                        }
                    });
                    iVar.setCancelable(false);
                    button.setOnClickListener(new AnonymousClass2(iVar));
                    iVar.setContentView(linearLayout);
                    iVar.show();
                    boolean i2 = true;
                }
                if (i2 == 0) {
                    TalkRoomUI.this.onBackPressed();
                }
                AppMethodBeat.o(25917);
            }
        });
        this.szq = (ImageButton) findViewById(R.id.evb);
        this.szq.setEnabled(false);
        this.szq.setImageResource(R.drawable.apo);
        this.szq.setOnTouchListener(new OnTouchListener() {
            /* JADX WARNING: Missing block: B:10:0x0077, code skipped:
            if (com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r6.szE, r8) == false) goto L_0x0079;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(25920);
                switch (motionEvent.getAction()) {
                    case 0:
                        TalkRoomUI.this.nNt = TalkRoomUI.a(TalkRoomUI.this, motionEvent);
                        if (TalkRoomUI.this.nNt) {
                            TalkRoomUI.this.szq.setImageResource(R.drawable.apn);
                            ay.a(ah.getContext(), R.string.ev4, new com.tencent.mm.sdk.platformtools.ay.a() {
                                public final void EA() {
                                    AppMethodBeat.i(25918);
                                    ab.i("MicroMsg.TalkRoomUI", "play press sound end");
                                    AppMethodBeat.o(25918);
                                }
                            });
                            TalkRoomUI.this.nNu = 1;
                            TalkRoomUI.d(TalkRoomUI.this);
                            ab.i("MicroMsg.TalkRoomUI", "micBtn pressed down");
                            TalkRoomUI.this.nNw = bo.yz();
                            b.cEh().akz();
                            TalkRoomUI.m(TalkRoomUI.this);
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
                                ab.i("MicroMsg.TalkRoomUI", "cancel during seize-success prepare time");
                                TalkRoomUI.this.nNx.stopTimer();
                                TalkRoomUI.this.nNy.stopTimer();
                            }
                            TalkRoomUI.this.szq.setImageResource(R.drawable.apm);
                            TalkRoomUI.this.nNu = 0;
                            TalkRoomUI.d(TalkRoomUI.this);
                            TalkRoomUI.this.nNC.stopTimer();
                            b.cEh().akA();
                            ay.a(ah.getContext(), R.string.ev7, new com.tencent.mm.sdk.platformtools.ay.a() {
                                public final void EA() {
                                    AppMethodBeat.i(25919);
                                    ab.i("MicroMsg.TalkRoomUI", "play up sound end");
                                    AppMethodBeat.o(25919);
                                }
                            });
                            TalkRoomUI.m(TalkRoomUI.this);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(25920);
                return false;
            }
        });
        this.szt = (TalkRoomVolumeMeter) findViewById(R.id.c_r);
        final AnonymousClass14 anonymousClass14 = new a() {
            public final void cEL() {
                AppMethodBeat.i(25921);
                TalkRoomUI.this.onBackPressed();
                AppMethodBeat.o(25921);
            }
        };
        findViewById(R.id.ev5).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(25922);
                a aVar = anonymousClass14;
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.hke = motionEvent.getX();
                    aVar.hkf = motionEvent.getY();
                    aVar.szJ = bo.yz();
                    AppMethodBeat.o(25922);
                    return true;
                }
                if (action == 1 || action == 3) {
                    float abs = Math.abs(motionEvent.getX() - aVar.hke);
                    float y = aVar.hkf - motionEvent.getY();
                    if (y >= 100.0f && y / abs > 2.0f && y / ((float) bo.az(aVar.szJ)) > 0.6f) {
                        aVar.cEL();
                        AppMethodBeat.o(25922);
                        return true;
                    }
                }
                AppMethodBeat.o(25922);
                return false;
            }
        });
        this.szu = (TalkRoomAvatarsFrame) findViewById(R.id.ev8);
        this.gne.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25923);
                TalkRoomUI.this.onBackPressed();
                AppMethodBeat.o(25923);
            }
        });
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
        aw.Rg().a(364, (f) this);
        ab.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        b.cEh().a((d) this);
        ab.d("MicroMsg.TalkRoomUI", "onCreate end");
        AppMethodBeat.o(25927);
    }

    public void onResume() {
        AppMethodBeat.i(25928);
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.acquire();
        this.gne.setText(j.b((Context) this, com.tencent.mm.plugin.talkroom.model.h.aU(this, this.nNq), this.gne.getTextSize()));
        b.cEg().sxK.sxP = true;
        b.cEg();
        ab.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.cEg();
        com.tencent.mm.plugin.talkroom.model.c.cEo();
        com.tencent.mm.sdk.b.b meVar = new me();
        meVar.cHX.cHY = true;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, getMainLooper());
        ab.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
        AppMethodBeat.o(25928);
    }

    public void onPause() {
        AppMethodBeat.i(25929);
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.release();
        this.nNC.stopTimer();
        b.cEg().sxK.sxP = false;
        b.cEg();
        com.tencent.mm.plugin.talkroom.model.c cVar = b.cEg().sxK;
        if (cVar.nNp) {
            cVar.abt(ah.getContext().getString(R.string.euq));
        } else if (bo.isNullOrNil(cVar.nMN)) {
            cVar.abt(com.tencent.mm.plugin.talkroom.model.h.aU(ah.getContext(), b.cEh().syD));
        } else {
            String string = ah.getContext().getString(R.string.euw, new Object[]{s.mJ(cVar.nMN)});
            com.tencent.mm.plugin.talkroom.model.c.cEo();
            cVar.abt(string);
        }
        com.tencent.mm.sdk.b.b meVar = new me();
        meVar.cHX.cHY = false;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, getMainLooper());
        ab.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
        AppMethodBeat.o(25929);
    }

    public void onDestroy() {
        AppMethodBeat.i(25930);
        b.cEh().b((d) this);
        aw.Rg().b(364, (f) this);
        if (this.eir != null && this.eir.isShowing()) {
            this.eir.cancel();
        }
        super.onDestroy();
        AppMethodBeat.o(25930);
    }

    public void finish() {
        AppMethodBeat.i(25931);
        super.finish();
        AppMethodBeat.o(25931);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(25932);
        if (i == 25) {
            aw.ZL().iK(3);
            AppMethodBeat.o(25932);
            return true;
        } else if (i == 24) {
            aw.ZL().iJ(3);
            AppMethodBeat.o(25932);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(25932);
            return onKeyDown;
        }
    }

    public final void akC() {
        AppMethodBeat.i(25933);
        this.nNp = false;
        this.szq.setEnabled(true);
        this.szq.setImageResource(R.drawable.apm);
        this.szr.setVisibility(0);
        bKa();
        cEJ();
        cEI();
        AppMethodBeat.o(25933);
    }

    public final void l(String str, int i, int i2) {
        AppMethodBeat.i(25934);
        ab.f("MicroMsg.TalkRoomUI", "onInitFailed %s", str);
        String str2 = "";
        if (i == 4) {
            if (i2 != -1) {
                this.nND = false;
                finish();
                AppMethodBeat.o(25934);
                return;
            }
            str2 = getString(R.string.eun);
        }
        abv(str2);
        AppMethodBeat.o(25934);
    }

    public final void mk(int i) {
        AppMethodBeat.i(25935);
        ab.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
        if (i == 340) {
            if (this.nNu != 3) {
                AppMethodBeat.o(25935);
                return;
            }
            this.nNu = 4;
        } else if (this.nNu != 1) {
            AppMethodBeat.o(25935);
            return;
        } else {
            this.nNu = 2;
        }
        cEH();
        bKa();
        ay.a(ah.getContext(), new com.tencent.mm.sdk.platformtools.ay.a() {
            public final void EA() {
            }
        });
        AppMethodBeat.o(25935);
    }

    public final void akD() {
        AppMethodBeat.i(25936);
        ab.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.nNu != 1) {
            AppMethodBeat.o(25936);
            return;
        }
        this.nNu = 5;
        if (bo.az(this.nNw) < this.nNv) {
            ab.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
            long az = this.nNv - bo.az(this.nNw);
            this.nNx.ae(az, az);
            AppMethodBeat.o(25936);
            return;
        }
        bJZ();
        AppMethodBeat.o(25936);
    }

    private void bJZ() {
        AppMethodBeat.i(25937);
        if (this.nNu != 5) {
            AppMethodBeat.o(25937);
            return;
        }
        this.nNx.stopTimer();
        bKa();
        cEH();
        ay.a(ah.getContext(), R.string.ev0, new com.tencent.mm.sdk.platformtools.ay.a() {
            public final void EA() {
                AppMethodBeat.i(25911);
                TalkRoomUI.this.nNy.stopTimer();
                TalkRoomUI.a(TalkRoomUI.this);
                AppMethodBeat.o(25911);
            }
        });
        this.nNy.ae(1000, 1000);
        AppMethodBeat.o(25937);
    }

    public final void g(int i, int i2, String str) {
        AppMethodBeat.i(25938);
        ab.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        abv("");
        AppMethodBeat.o(25938);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(25939);
        if (mVar.getType() == 364 && this.eir != null && this.eir.isShowing()) {
            this.eir.cancel();
        }
        AppMethodBeat.o(25939);
    }

    private void abv(String str) {
        AppMethodBeat.i(25940);
        if (this.nND) {
            this.nND = false;
            b.cEh().cEw();
            if (bo.isNullOrNil(str)) {
                if (at.isConnected(getApplication())) {
                    str = getString(R.string.eun);
                } else {
                    str = getString(R.string.euo);
                }
            }
            if (isFinishing()) {
                AppMethodBeat.o(25940);
                return;
            }
            h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(25912);
                    TalkRoomUI.this.finish();
                    AppMethodBeat.o(25912);
                }
            });
            AppMethodBeat.o(25940);
            return;
        }
        ab.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
        AppMethodBeat.o(25940);
    }

    public final void tO(String str) {
        AppMethodBeat.i(25941);
        ab.d("MicroMsg.TalkRoomUI", "onCurMember %s", str);
        this.nNr = str;
        cEH();
        bKa();
        if (bo.isNullOrNil(str)) {
            this.nNC.stopTimer();
            AppMethodBeat.o(25941);
            return;
        }
        ay.a(ah.getContext(), R.string.ev3, new com.tencent.mm.sdk.platformtools.ay.a() {
            public final void EA() {
            }
        });
        this.nNC.ae(100, 100);
        AppMethodBeat.o(25941);
    }

    public final void akE() {
        AppMethodBeat.i(25942);
        if (this.nND) {
            this.nND = false;
            finish();
            AppMethodBeat.o(25942);
            return;
        }
        ab.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
        AppMethodBeat.o(25942);
    }

    public final void akF() {
        AppMethodBeat.i(25943);
        bKa();
        AppMethodBeat.o(25943);
    }

    public final void akG() {
        AppMethodBeat.i(25944);
        bKa();
        AppMethodBeat.o(25944);
    }

    public final void akH() {
        AppMethodBeat.i(25945);
        m(getString(R.string.eur), R.color.a2o);
        AppMethodBeat.o(25945);
    }

    private void cEI() {
        AppMethodBeat.i(25946);
        List<cgm> bJF = b.cEh().bJF();
        LinkedList linkedList = new LinkedList();
        for (cgm cgm : bJF) {
            linkedList.add(cgm.jBB);
        }
        this.szu.setMembersList(linkedList);
        AppMethodBeat.o(25946);
    }

    public final void aU(String str, String str2) {
        AppMethodBeat.i(25947);
        ab.i("MicroMsg.TalkRoomUI", "add %s,  del %s", str, str2);
        cEI();
        if (this.nNp) {
            AppMethodBeat.o(25947);
            return;
        }
        cEJ();
        if (!bo.isNullOrNil(str)) {
            abw(getString(R.string.eud, new Object[]{s.mJ(str)}));
            this.nNz.ae(3000, 3000);
        }
        if (!bo.isNullOrNil(str2)) {
            abw(getString(R.string.eui, new Object[]{s.mJ(str2)}));
            this.nNz.ae(3000, 3000);
        }
        AppMethodBeat.o(25947);
    }

    private void bKa() {
        AppMethodBeat.i(25948);
        if (this.nNp) {
            AppMethodBeat.o(25948);
        } else if (b.cEh().syR) {
            m(getString(R.string.eup), R.color.a2o);
            this.szu.setCurMemeber(null);
            this.szs.setImageResource(R.drawable.api);
            cEK();
            AppMethodBeat.o(25948);
        } else {
            switch (this.nNu) {
                case 0:
                    if (bo.isNullOrNil(this.nNr)) {
                        CharSequence string;
                        if (b.cEh().bJF().size() == 1) {
                            string = getString(R.string.euy);
                        } else {
                            string = "";
                        }
                        m(string, R.color.a2n);
                        this.szu.setCurMemeber(null);
                        this.szs.setImageResource(R.drawable.api);
                        cEK();
                        AppMethodBeat.o(25948);
                        return;
                    }
                    abw(s.mJ(this.nNr));
                    this.szu.setCurMemeber(this.nNr);
                    this.szs.setImageResource(R.drawable.api);
                    Fw(1);
                    AppMethodBeat.o(25948);
                    return;
                case 1:
                    m(getString(R.string.euc), R.color.a2n);
                    this.szs.setImageResource(R.drawable.apl);
                    AppMethodBeat.o(25948);
                    return;
                case 2:
                    m(getString(R.string.eus), R.color.a2o);
                    this.szs.setImageResource(R.drawable.apk);
                    AppMethodBeat.o(25948);
                    return;
                case 3:
                case 5:
                    m(getString(R.string.eut), R.color.a2n);
                    this.szu.setCurMemeber(r.Yz());
                    this.szs.setImageResource(R.drawable.apj);
                    Fw(2);
                    AppMethodBeat.o(25948);
                    return;
                case 4:
                    m(getString(R.string.euv), R.color.a2o);
                    this.szs.setImageResource(R.drawable.apk);
                    cEK();
                    break;
            }
            AppMethodBeat.o(25948);
        }
    }

    private void cEJ() {
        AppMethodBeat.i(25949);
        ab.i("MicroMsg.TalkRoomUI", "displayCount %d", Integer.valueOf(b.cEh().bJF().size()));
        this.nDX.setText(String.valueOf(r0));
        AppMethodBeat.o(25949);
    }

    private void abw(String str) {
        AppMethodBeat.i(25950);
        m(j.b((Context) this, (CharSequence) str, this.szp.getTextSize()), R.color.a2n);
        AppMethodBeat.o(25950);
    }

    private void m(CharSequence charSequence, int i) {
        AppMethodBeat.i(25951);
        if (bo.isNullOrNil(charSequence.toString())) {
            this.szp.startAnimation(this.szB);
            AppMethodBeat.o(25951);
            return;
        }
        this.szp.setTextColor(getResources().getColor(i));
        this.szp.setText(charSequence);
        this.szp.startAnimation(this.szA);
        AppMethodBeat.o(25951);
    }

    private void Fw(int i) {
        AppMethodBeat.i(25952);
        if (i == 0 || this.nNJ != i) {
            this.nNI.setVisibility(0);
            this.nNI.startAnimation(this.szy);
            this.nNI.setBase(bo.yz());
            this.nNI.start();
            this.nNJ = i;
            AppMethodBeat.o(25952);
            return;
        }
        AppMethodBeat.o(25952);
    }

    private void cEK() {
        AppMethodBeat.i(25953);
        if (this.nNJ == 0) {
            AppMethodBeat.o(25953);
            return;
        }
        this.nNI.stop();
        this.nNJ = 0;
        this.nNI.startAnimation(this.szz);
        AppMethodBeat.o(25953);
    }

    static /* synthetic */ void a(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(25954);
        if (talkRoomUI.nNu == 5) {
            talkRoomUI.nNu = 3;
            b.cEh().akw();
            talkRoomUI.nNC.ae(100, 100);
        }
        AppMethodBeat.o(25954);
    }
}
