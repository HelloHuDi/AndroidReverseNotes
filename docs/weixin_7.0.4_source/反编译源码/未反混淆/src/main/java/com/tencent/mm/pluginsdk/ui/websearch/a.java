package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.List;

public final class a extends LinearLayout {
    private String cqz = "";
    AudioManager eoY;
    private Context mContext;
    private Toast mMP;
    private boolean mMX = false;
    private TelephonyManager nva;
    PhoneStateListener nvb = new PhoneStateListener() {
        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.i(28243);
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (a.this.voR != null) {
                i2 = a.this.voR.getCurrentState();
            }
            ab.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            a.this.voR;
            if (i2 != 2) {
                AppMethodBeat.o(28243);
                return;
            }
            a.this.pause();
            AppMethodBeat.o(28243);
        }
    };
    private Button oik;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a vjs = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a() {
        public final void bBI() {
            AppMethodBeat.i(28240);
            a.a(a.this, (int) R.string.f2a);
            AppMethodBeat.o(28240);
        }
    };
    private MMEditText vjx;
    public int vmi = com.tencent.mm.bz.a.fromDPToPix(getContext(), d.MIC_PTU_TRANS_XINXIAN);
    private VoiceInputLayout voR;
    private ImageButton voS;
    private Button voT;
    private VoiceInputScrollView voX;
    private TextView voY;
    private long voZ = 0;
    private b vpA = new b() {
        public final void bBz() {
            AppMethodBeat.i(28244);
            a.this.vpk = System.currentTimeMillis();
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(a.this.vpk));
            ab.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(a.this.vpk));
            a.this.vpi = false;
            a.this.vpj = true;
            a.this.vpq = true;
            a.this.vpl = 0;
            a.this.vpm = 0;
            a.d(a.this);
            a.this.voY.setVisibility(8);
            a.this.vpj = false;
            a aVar = a.this;
            if (aVar.eoY != null) {
                aVar.eoY.setStreamMute(3, true);
            }
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().addFlags(128);
            }
            a.this.oik.setVisibility(4);
            a.this.voS.setVisibility(4);
            a.this.voT.setVisibility(8);
            a.this.vjx.setHint(a.this.getResources().getString(R.string.f29));
            a.this.vwc.oz(true);
            AppMethodBeat.o(28244);
        }

        public final void bBC() {
            AppMethodBeat.i(28245);
            a.this.vwc.oz(false);
            a.this.vjx.setHint(null);
            AppMethodBeat.o(28245);
        }

        public final void bBD() {
            AppMethodBeat.i(28246);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.vwc.oz(false);
            a.this.vjx.setHint(null);
            a.b(a.this, 2);
            AppMethodBeat.o(28246);
        }

        public final void bBE() {
            AppMethodBeat.i(28247);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.vwc.oz(false);
            a.this.vjx.setHint(null);
            AppMethodBeat.o(28247);
        }

        public final void bBF() {
            AppMethodBeat.i(28248);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.vwc.oz(false);
            a.this.vjx.setHint(null);
            a.b(a.this, 2);
            AppMethodBeat.o(28248);
        }

        public final void c(String[] strArr, List<String> list) {
            AppMethodBeat.i(138175);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (a.this.vpq) {
                    a.this.vpq = false;
                }
                ab.i("MicroMsg.VoiceInputPanel", "onDetected %s", strArr[0]);
                a.this.vjx.setText(strArr[0]);
                if (!(a.this.vpi || strArr[0].length() == 0)) {
                    a.this.vpi = true;
                    a.this.vpl = System.currentTimeMillis();
                    ab.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.this.vpl - a.this.vpk));
                }
                a.this.vps.addAll(list);
            }
            AppMethodBeat.o(138175);
        }

        public final void at(int i, int i2, int i3) {
            AppMethodBeat.i(28250);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            if (i == 12) {
                a.a(a.this, (int) R.string.f2_);
            } else {
                a.a(a.this, (int) R.string.ps);
            }
            a.this.vwc.oz(false);
            a.this.vjx.setHint(null);
            AppMethodBeat.o(28250);
        }
    };
    public boolean vpB = true;
    private float vpb = 0.0f;
    private float vpc = 0.0f;
    private boolean vpd = false;
    private boolean vpe = false;
    private boolean vpf = false;
    private int vpg = 300;
    private boolean vpi = false;
    private boolean vpj = false;
    private long vpk = 0;
    private long vpl = 0;
    private long vpm = 0;
    private boolean vpn = false;
    private boolean vpo = false;
    private final int vpp = 2;
    private boolean vpq = false;
    private List<String> vps = new ArrayList();
    private c<uc> vpu;
    private a vwc;

    public interface a {
        void ajt(String str);

        void djr();

        void oz(boolean z);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(28261);
        aVar.dkO();
        AppMethodBeat.o(28261);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(28251);
        this.mContext = context;
        ab.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.layout.b74, this);
        this.voS = (ImageButton) findViewById(R.id.f1p);
        this.voT = (Button) findViewById(R.id.f1q);
        this.oik = (Button) findViewById(R.id.f1s);
        this.voY = (TextView) findViewById(R.id.f1n);
        this.voS.setVisibility(0);
        this.oik.setVisibility(4);
        this.voT.setVisibility(8);
        this.vjx = (MMEditText) findViewById(R.id.f1k);
        this.vjx.setHintTextColor(getResources().getColor(R.color.w0));
        this.vjx.setClickable(false);
        this.voX = (VoiceInputScrollView) findViewById(R.id.f1i);
        this.voS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(28239);
                a.a(a.this);
                AppMethodBeat.o(28239);
            }
        });
        this.vjx.clearFocus();
        this.vjx.setFocusable(false);
        this.vjx.setClickable(false);
        this.vjx.setLongClickable(false);
        this.eoY = (AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.cqz = String.valueOf(System.nanoTime());
        ab.i("MicroMsg.VoiceInputPanel", "mToUser %s", this.cqz);
        dkM();
        AppMethodBeat.o(28251);
    }

    public final void dkM() {
        AppMethodBeat.i(28252);
        this.voZ = bo.yz();
        if (this.vpu == null) {
            ab.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.vpu = new c<uc>() {
                {
                    AppMethodBeat.i(28241);
                    this.xxI = uc.class.getName().hashCode();
                    AppMethodBeat.o(28241);
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(28242);
                    uc ucVar = (uc) bVar;
                    if (!(ucVar instanceof uc)) {
                        ab.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        AppMethodBeat.o(28242);
                        return false;
                    } else if (ucVar == null || ucVar.cQk == null) {
                        ab.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        AppMethodBeat.o(28242);
                        return false;
                    } else if (ucVar.cQk.userCode.equalsIgnoreCase(a.this.cqz)) {
                        ab.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(ucVar.cQk.action), Integer.valueOf(ucVar.cQk.cQl));
                        if (ucVar.cQk.action == 2) {
                            if (ucVar.cQk.cQl == 1) {
                                a.this.vpo = true;
                            } else {
                                a.this.vpo = false;
                            }
                            a.this.vjx.setText(ucVar.cQk.result);
                            a.d(a.this);
                        } else if (ucVar.cQk.action == 3) {
                            if (a.this.vwc != null) {
                                a.this.vwc.djr();
                            }
                        } else if (ucVar.cQk.action == 1 || ucVar.cQk.action == 4) {
                            if (ucVar.cQk.cQl == 1) {
                                a.this.vpo = true;
                            } else {
                                a.this.vpo = false;
                            }
                            a.this.vjx.setText(ucVar.cQk.result);
                            a.d(a.this);
                            a.b(a.this, ucVar.cQk.action);
                        } else {
                            a.this.reset();
                        }
                        AppMethodBeat.o(28242);
                        return true;
                    } else {
                        ab.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        a.this.destroy();
                        AppMethodBeat.o(28242);
                        return false;
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xxA.c(this.vpu);
        }
        if (this.voR == null) {
            this.voR = (VoiceInputLayout) findViewById(R.id.f1r);
            this.voR.setVoiceDetectListener(this.vpA);
            this.voR.setLongClickLisnter(this.vjs);
        }
        this.voY.setVisibility(0);
        this.nva = (TelephonyManager) ah.getContext().getSystemService("phone");
        this.nva.listen(this.nvb, 32);
        AppMethodBeat.o(28252);
    }

    public final void setCallback(a aVar) {
        this.vwc = aVar;
    }

    public final void pause() {
        AppMethodBeat.i(28253);
        ab.i("MicroMsg.VoiceInputPanel", "pause");
        if (this.voR != null) {
            this.voR.amA();
        }
        this.vpb = 0.0f;
        this.vpc = 0.0f;
        this.vpd = false;
        this.vpe = false;
        this.mMX = false;
        this.vpf = false;
        this.vpn = false;
        this.vpB = true;
        AppMethodBeat.o(28253);
    }

    public final void reset() {
        AppMethodBeat.i(28254);
        ab.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.vpo = false;
        this.vps.clear();
        if (this.vjx != null) {
            this.vjx.setText("");
            dkO();
        }
        AppMethodBeat.o(28254);
    }

    public final void destroy() {
        AppMethodBeat.i(28255);
        ab.i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.vpu != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.vpu);
            this.vpu = null;
        }
        if (this.voR != null) {
            this.voR.amA();
            this.voR.setVoiceDetectListener(null);
            this.voR.bBP();
            this.voR.djt();
            this.voR = null;
        }
        if (!(this.nva == null || this.nvb == null)) {
            this.nva.listen(this.nvb, 0);
            this.nvb = null;
        }
        this.nva = null;
        AppMethodBeat.o(28255);
    }

    public final void setToUser(String str) {
        AppMethodBeat.i(28256);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
            AppMethodBeat.o(28256);
            return;
        }
        this.cqz = str;
        AppMethodBeat.o(28256);
    }

    public final void dkO() {
        AppMethodBeat.i(28257);
        ab.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.vjx == null || this.vjx.getText() == null || this.vjx.getText().length() != 0) {
            this.voS.setVisibility(4);
            this.voY.setVisibility(8);
        } else {
            this.oik.setVisibility(4);
            this.voS.setVisibility(0);
            this.voT.setVisibility(8);
            this.voY.setVisibility(0);
        }
        KY();
        if (!this.vpj) {
            this.vpj = true;
            this.vpm = System.currentTimeMillis();
            ab.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.vpm), Long.valueOf(this.vpm - this.vpl));
        }
        AppMethodBeat.o(28257);
    }

    private void KY() {
        AppMethodBeat.i(28258);
        if (this.eoY != null) {
            this.eoY.setStreamMute(3, false);
        }
        AppMethodBeat.o(28258);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(28259);
        ab.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (aVar.vwc != null) {
            aVar.vpn = true;
            ab.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (aVar.vjx == null || aVar.vjx.getText() == null || aVar.vjx.getText().length() <= 0) {
                if (aVar.vpn) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (aVar.vpn) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (aVar.voZ != 0) {
                voiceInputBehavior.voiceInputTime = bo.az(aVar.voZ);
                aVar.voZ = 0;
            }
            aVar.vwc.djr();
        }
        AppMethodBeat.o(28259);
    }
}
