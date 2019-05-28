package com.tencent.p177mm.pluginsdk.p597ui.websearch;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18410uc;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayout;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayout.C35826a;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayout.C35827b;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputScrollView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a */
public final class C23358a extends LinearLayout {
    private String cqz = "";
    AudioManager eoY;
    private Context mContext;
    private Toast mMP;
    private boolean mMX = false;
    private TelephonyManager nva;
    PhoneStateListener nvb = new C233614();
    private Button oik;
    private C35826a vjs = new C233572();
    private MMEditText vjx;
    public int vmi = C1338a.fromDPToPix(getContext(), C31128d.MIC_PTU_TRANS_XINXIAN);
    private VoiceInputLayout voR;
    private ImageButton voS;
    private Button voT;
    private VoiceInputScrollView voX;
    private TextView voY;
    private long voZ = 0;
    private C35827b vpA = new C233595();
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
    private C4884c<C18410uc> vpu;
    private C23362a vwc;

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a$1 */
    class C233561 implements OnClickListener {
        C233561() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28239);
            C23358a.m35876a(C23358a.this);
            AppMethodBeat.m2505o(28239);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a$2 */
    class C233572 implements C35826a {
        C233572() {
        }

        public final void bBI() {
            AppMethodBeat.m2504i(28240);
            C23358a.m35877a(C23358a.this, (int) C25738R.string.f2a);
            AppMethodBeat.m2505o(28240);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a$5 */
    class C233595 implements C35827b {
        C233595() {
        }

        public final void bBz() {
            AppMethodBeat.m2504i(28244);
            C23358a.this.vpk = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(C23358a.this.vpk));
            C4990ab.m7411d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(C23358a.this.vpk));
            C23358a.this.vpi = false;
            C23358a.this.vpj = true;
            C23358a.this.vpq = true;
            C23358a.this.vpl = 0;
            C23358a.this.vpm = 0;
            C23358a.m35885d(C23358a.this);
            C23358a.this.voY.setVisibility(8);
            C23358a.this.vpj = false;
            C23358a c23358a = C23358a.this;
            if (c23358a.eoY != null) {
                c23358a.eoY.setStreamMute(3, true);
            }
            if (C23358a.this.mContext instanceof Activity) {
                ((Activity) C23358a.this.mContext).getWindow().addFlags(128);
            }
            C23358a.this.oik.setVisibility(4);
            C23358a.this.voS.setVisibility(4);
            C23358a.this.voT.setVisibility(8);
            C23358a.this.vjx.setHint(C23358a.this.getResources().getString(C25738R.string.f29));
            C23358a.this.vwc.mo28249oz(true);
            AppMethodBeat.m2505o(28244);
        }

        public final void bBC() {
            AppMethodBeat.m2504i(28245);
            C23358a.this.vwc.mo28249oz(false);
            C23358a.this.vjx.setHint(null);
            AppMethodBeat.m2505o(28245);
        }

        public final void bBD() {
            AppMethodBeat.m2504i(28246);
            C4990ab.m7416i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            C23358a.m35885d(C23358a.this);
            if (C23358a.this.mContext instanceof Activity) {
                ((Activity) C23358a.this.mContext).getWindow().clearFlags(128);
            }
            C23358a.this.vwc.mo28249oz(false);
            C23358a.this.vjx.setHint(null);
            C23358a.m35881b(C23358a.this, 2);
            AppMethodBeat.m2505o(28246);
        }

        public final void bBE() {
            AppMethodBeat.m2504i(28247);
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            C23358a.m35885d(C23358a.this);
            if (C23358a.this.mContext instanceof Activity) {
                ((Activity) C23358a.this.mContext).getWindow().clearFlags(128);
            }
            C23358a.this.vwc.mo28249oz(false);
            C23358a.this.vjx.setHint(null);
            AppMethodBeat.m2505o(28247);
        }

        public final void bBF() {
            AppMethodBeat.m2504i(28248);
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            C23358a.m35885d(C23358a.this);
            if (C23358a.this.mContext instanceof Activity) {
                ((Activity) C23358a.this.mContext).getWindow().clearFlags(128);
            }
            C23358a.this.vwc.mo28249oz(false);
            C23358a.this.vjx.setHint(null);
            C23358a.m35881b(C23358a.this, 2);
            AppMethodBeat.m2505o(28248);
        }

        /* renamed from: c */
        public final void mo39028c(String[] strArr, List<String> list) {
            AppMethodBeat.m2504i(138175);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (C23358a.this.vpq) {
                    C23358a.this.vpq = false;
                }
                C4990ab.m7417i("MicroMsg.VoiceInputPanel", "onDetected %s", strArr[0]);
                C23358a.this.vjx.setText(strArr[0]);
                if (!(C23358a.this.vpi || strArr[0].length() == 0)) {
                    C23358a.this.vpi = true;
                    C23358a.this.vpl = System.currentTimeMillis();
                    C4990ab.m7411d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(C23358a.this.vpl - C23358a.this.vpk));
                }
                C23358a.this.vps.addAll(list);
            }
            AppMethodBeat.m2505o(138175);
        }

        /* renamed from: at */
        public final void mo39022at(int i, int i2, int i3) {
            AppMethodBeat.m2504i(28250);
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            C23358a.m35885d(C23358a.this);
            if (C23358a.this.mContext instanceof Activity) {
                ((Activity) C23358a.this.mContext).getWindow().clearFlags(128);
            }
            if (i == 12) {
                C23358a.m35877a(C23358a.this, (int) C25738R.string.f2_);
            } else {
                C23358a.m35877a(C23358a.this, (int) C25738R.string.f9111ps);
            }
            C23358a.this.vwc.mo28249oz(false);
            C23358a.this.vjx.setHint(null);
            AppMethodBeat.m2505o(28250);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a$3 */
    class C233603 extends C4884c<C18410uc> {
        C233603() {
            AppMethodBeat.m2504i(28241);
            this.xxI = C18410uc.class.getName().hashCode();
            AppMethodBeat.m2505o(28241);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(28242);
            C18410uc c18410uc = (C18410uc) c4883b;
            if (!(c18410uc instanceof C18410uc)) {
                C4990ab.m7410d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                AppMethodBeat.m2505o(28242);
                return false;
            } else if (c18410uc == null || c18410uc.cQk == null) {
                C4990ab.m7412e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                AppMethodBeat.m2505o(28242);
                return false;
            } else if (c18410uc.cQk.userCode.equalsIgnoreCase(C23358a.this.cqz)) {
                C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(c18410uc.cQk.action), Integer.valueOf(c18410uc.cQk.cQl));
                if (c18410uc.cQk.action == 2) {
                    if (c18410uc.cQk.cQl == 1) {
                        C23358a.this.vpo = true;
                    } else {
                        C23358a.this.vpo = false;
                    }
                    C23358a.this.vjx.setText(c18410uc.cQk.result);
                    C23358a.m35885d(C23358a.this);
                } else if (c18410uc.cQk.action == 3) {
                    if (C23358a.this.vwc != null) {
                        C23358a.this.vwc.djr();
                    }
                } else if (c18410uc.cQk.action == 1 || c18410uc.cQk.action == 4) {
                    if (c18410uc.cQk.cQl == 1) {
                        C23358a.this.vpo = true;
                    } else {
                        C23358a.this.vpo = false;
                    }
                    C23358a.this.vjx.setText(c18410uc.cQk.result);
                    C23358a.m35885d(C23358a.this);
                    C23358a.m35881b(C23358a.this, c18410uc.cQk.action);
                } else {
                    C23358a.this.reset();
                }
                AppMethodBeat.m2505o(28242);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                C23358a.this.destroy();
                AppMethodBeat.m2505o(28242);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a$4 */
    class C233614 extends PhoneStateListener {
        C233614() {
        }

        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.m2504i(28243);
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (C23358a.this.voR != null) {
                i2 = C23358a.this.voR.getCurrentState();
            }
            C4990ab.m7411d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            C23358a.this.voR;
            if (i2 != 2) {
                AppMethodBeat.m2505o(28243);
                return;
            }
            C23358a.this.pause();
            AppMethodBeat.m2505o(28243);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a$a */
    public interface C23362a {
        void ajt(String str);

        void djr();

        /* renamed from: oz */
        void mo28249oz(boolean z);
    }

    /* renamed from: d */
    static /* synthetic */ void m35885d(C23358a c23358a) {
        AppMethodBeat.m2504i(28261);
        c23358a.dkO();
        AppMethodBeat.m2505o(28261);
    }

    public C23358a(Context context) {
        super(context);
        AppMethodBeat.m2504i(28251);
        this.mContext = context;
        C4990ab.m7410d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), 2130971204, this);
        this.voS = (ImageButton) findViewById(2131828450);
        this.voT = (Button) findViewById(2131828451);
        this.oik = (Button) findViewById(2131828453);
        this.voY = (TextView) findViewById(2131828448);
        this.voS.setVisibility(0);
        this.oik.setVisibility(4);
        this.voT.setVisibility(8);
        this.vjx = (MMEditText) findViewById(2131828445);
        this.vjx.setHintTextColor(getResources().getColor(C25738R.color.f12208w0));
        this.vjx.setClickable(false);
        this.voX = (VoiceInputScrollView) findViewById(2131828443);
        this.voS.setOnClickListener(new C233561());
        this.vjx.clearFocus();
        this.vjx.setFocusable(false);
        this.vjx.setClickable(false);
        this.vjx.setLongClickable(false);
        this.eoY = (AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.cqz = String.valueOf(System.nanoTime());
        C4990ab.m7417i("MicroMsg.VoiceInputPanel", "mToUser %s", this.cqz);
        dkM();
        AppMethodBeat.m2505o(28251);
    }

    public final void dkM() {
        AppMethodBeat.m2504i(28252);
        this.voZ = C5046bo.m7588yz();
        if (this.vpu == null) {
            C4990ab.m7416i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.vpu = new C233603();
            C4879a.xxA.mo10052c(this.vpu);
        }
        if (this.voR == null) {
            this.voR = (VoiceInputLayout) findViewById(2131828452);
            this.voR.setVoiceDetectListener(this.vpA);
            this.voR.setLongClickLisnter(this.vjs);
        }
        this.voY.setVisibility(0);
        this.nva = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        this.nva.listen(this.nvb, 32);
        AppMethodBeat.m2505o(28252);
    }

    public final void setCallback(C23362a c23362a) {
        this.vwc = c23362a;
    }

    public final void pause() {
        AppMethodBeat.m2504i(28253);
        C4990ab.m7416i("MicroMsg.VoiceInputPanel", "pause");
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
        AppMethodBeat.m2505o(28253);
    }

    public final void reset() {
        AppMethodBeat.m2504i(28254);
        C4990ab.m7416i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.vpo = false;
        this.vps.clear();
        if (this.vjx != null) {
            this.vjx.setText("");
            dkO();
        }
        AppMethodBeat.m2505o(28254);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(28255);
        C4990ab.m7416i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.vpu != null) {
            C4879a.xxA.mo10053d(this.vpu);
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
        AppMethodBeat.m2505o(28255);
    }

    public final void setToUser(String str) {
        AppMethodBeat.m2504i(28256);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
            AppMethodBeat.m2505o(28256);
            return;
        }
        this.cqz = str;
        AppMethodBeat.m2505o(28256);
    }

    public final void dkO() {
        AppMethodBeat.m2504i(28257);
        C4990ab.m7410d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.vjx == null || this.vjx.getText() == null || this.vjx.getText().length() != 0) {
            this.voS.setVisibility(4);
            this.voY.setVisibility(8);
        } else {
            this.oik.setVisibility(4);
            this.voS.setVisibility(0);
            this.voT.setVisibility(8);
            this.voY.setVisibility(0);
        }
        m35874KY();
        if (!this.vpj) {
            this.vpj = true;
            this.vpm = System.currentTimeMillis();
            C4990ab.m7411d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.vpm), Long.valueOf(this.vpm - this.vpl));
        }
        AppMethodBeat.m2505o(28257);
    }

    /* renamed from: KY */
    private void m35874KY() {
        AppMethodBeat.m2504i(28258);
        if (this.eoY != null) {
            this.eoY.setStreamMute(3, false);
        }
        AppMethodBeat.m2505o(28258);
    }

    /* renamed from: a */
    static /* synthetic */ void m35876a(C23358a c23358a) {
        AppMethodBeat.m2504i(28259);
        C4990ab.m7410d("MicroMsg.VoiceInputPanel", "closePanel");
        if (c23358a.vwc != null) {
            c23358a.vpn = true;
            C4990ab.m7416i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (c23358a.vjx == null || c23358a.vjx.getText() == null || c23358a.vjx.getText().length() <= 0) {
                if (c23358a.vpn) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (c23358a.vpn) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (c23358a.voZ != 0) {
                voiceInputBehavior.voiceInputTime = C5046bo.m7525az(c23358a.voZ);
                c23358a.voZ = 0;
            }
            c23358a.vwc.djr();
        }
        AppMethodBeat.m2505o(28259);
    }
}
