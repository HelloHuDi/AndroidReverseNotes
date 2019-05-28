package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoiceaddr.C42236g;
import com.tencent.p177mm.modelvoiceaddr.p1209b.C26504b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18410uc;
import com.tencent.p177mm.p230g.p232b.p233a.C18437az;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C45562b;
import com.tencent.p177mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.p177mm.plugin.report.kvdata.log_13905;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C14949l;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayout;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayout.C35826a;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayout.C35827b;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayoutImpl;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputScrollView;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputUI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.n */
public final class C40482n extends LinearLayout {
    private String cqz = "";
    private Context mContext;
    private Toast mMP;
    private boolean mMX = false;
    private TelephonyManager nva;
    private Button oik;
    private C35826a vjs = new C3686211();
    private MMEditText vjx;
    private C5653c vmV;
    private int vmi = C1338a.fromDPToPix(getContext(), C45562b.CTRL_INDEX);
    private VoiceInputLayout voR;
    private ImageButton voS;
    private Button voT;
    private TextView voU;
    private C40481a voV;
    private MMEditText voW = null;
    private VoiceInputScrollView voX;
    private TextView voY;
    private long voZ = 0;
    private C35827b vpA = new C233003();
    private boolean vpB = true;
    private boolean vpa = false;
    private float vpb = 0.0f;
    private float vpc = 0.0f;
    private boolean vpd = false;
    private boolean vpe = false;
    private boolean vpf = false;
    private int vpg = 300;
    private final String vph = "voiceinput_downdistance_content";
    private boolean vpi = false;
    private boolean vpj = false;
    private long vpk = 0;
    private long vpl = 0;
    private long vpm = 0;
    private boolean vpn = false;
    private boolean vpo = false;
    private final int vpp = 2;
    private boolean vpq = false;
    private String vpr = "";
    private List<String> vps = new ArrayList();
    private C14949l vpt;
    private C4884c<C18410uc> vpu;
    private C26504b vpv;
    private int vpw = 0;
    private ArrayList<String> vpx = new ArrayList();
    private ArrayList<Integer> vpy = new ArrayList();
    C40484b vpz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$10 */
    class C475610 implements OnTouchListener {
        C475610() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27982);
            boolean a = C40482n.m69555a(C40482n.this, view, motionEvent);
            AppMethodBeat.m2505o(27982);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$2 */
    class C232992 extends C4884c<C18410uc> {
        C232992() {
            AppMethodBeat.m2504i(27966);
            this.xxI = C18410uc.class.getName().hashCode();
            AppMethodBeat.m2505o(27966);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(27967);
            C18410uc c18410uc = (C18410uc) c4883b;
            if (!(c18410uc instanceof C18410uc)) {
                C4990ab.m7410d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                AppMethodBeat.m2505o(27967);
                return false;
            } else if (c18410uc == null || c18410uc.cQk == null) {
                C4990ab.m7412e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                AppMethodBeat.m2505o(27967);
                return false;
            } else if (C40482n.this.vpa) {
                C4990ab.m7416i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent fromFullScreen true");
                AppMethodBeat.m2505o(27967);
                return false;
            } else if (c18410uc.cQk.userCode.equalsIgnoreCase(C40482n.this.cqz)) {
                C40482n.this.setToUser(C40482n.this.cqz);
                C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(c18410uc.cQk.action), Integer.valueOf(c18410uc.cQk.cQl));
                if (c18410uc.cQk.action == 2) {
                    if (c18410uc.cQk.cQl == 1) {
                        C40482n.this.vpo = true;
                    } else {
                        C40482n.this.vpo = false;
                    }
                    C40482n.this.vpt.mo27296a(C40482n.this.vjx, c18410uc.cQk.result, false);
                    C40482n.this.vpt.mo27295a(C40482n.this.vjx);
                    C40482n.this.vpt.mo27298b(C40482n.this.vjx);
                    C40482n.m69575m(C40482n.this);
                    C40482n.this.voX.fullScroll(130);
                } else if (c18410uc.cQk.action == 3) {
                    if (C40482n.this.voV != null) {
                        C40482n.this.voV.djr();
                    }
                } else if (c18410uc.cQk.action == 1 || c18410uc.cQk.action == 4) {
                    if (c18410uc.cQk.cQl == 1) {
                        C40482n.this.vpo = true;
                    } else {
                        C40482n.this.vpo = false;
                    }
                    C40482n.this.vpt.mo27296a(C40482n.this.vjx, c18410uc.cQk.result, false);
                    C40482n.this.vpt.mo27295a(C40482n.this.vjx);
                    C40482n.this.vpt.mo27298b(C40482n.this.vjx);
                    C40482n.m69575m(C40482n.this);
                    C40482n.this.voX.fullScroll(130);
                    C40482n.m69553a(C40482n.this, c18410uc.cQk.action);
                } else {
                    C40482n.this.reset();
                }
                AppMethodBeat.m2505o(27967);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                C40482n.this.destroy();
                AppMethodBeat.m2505o(27967);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$3 */
    class C233003 implements C35827b {
        C233003() {
        }

        public final void bBz() {
            AppMethodBeat.m2504i(27968);
            C40482n.this.vpk = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(C40482n.this.vpk));
            C4990ab.m7411d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(C40482n.this.vpk));
            C40482n.this.vpi = false;
            C40482n.this.vpj = true;
            C40482n.this.vpq = true;
            C40482n.this.vpl = 0;
            C40482n.this.vpm = 0;
            C40482n.m69575m(C40482n.this);
            C40482n.this.voY.setVisibility(8);
            C40482n.this.vpj = false;
            C40482n.this.vpt.vjo = 3;
            C40482n.this.vpt.mo27298b(C40482n.this.vjx);
            C40482n.dkP();
            if (C40482n.this.vjx != null) {
                if (C40482n.this.vjx.getText() != null && C40482n.this.vjx.getText().length() > 0) {
                    C40482n.this.vjx.setCursorVisible(true);
                }
                C40482n.this.vjx.requestFocus();
                C5046bo.hideVKB(C40482n.this.voR);
            }
            if (C40482n.this.mContext instanceof Activity) {
                ((Activity) C40482n.this.mContext).getWindow().addFlags(128);
            }
            C40482n.this.oik.setVisibility(4);
            C40482n.this.voS.setVisibility(4);
            C40482n.this.voT.setVisibility(8);
            C40482n.this.vjx.setHint(C40482n.this.getResources().getString(C25738R.string.f29));
            C40482n.this.voV.mo38994oz(true);
            C40482n.this.voU.setVisibility(8);
            C40482n.this.mo64005Lk(1);
            AppMethodBeat.m2505o(27968);
        }

        public final void bBC() {
            int i = 0;
            AppMethodBeat.m2504i(27969);
            C40482n.this.voV.mo38994oz(false);
            C40482n.this.vjx.setHint(null);
            TextView f = C40482n.this.voU;
            if (C40482n.this.vpy.size() < 2 || C40482n.this.vjx.getText().length() > 0) {
                i = 8;
            }
            f.setVisibility(i);
            AppMethodBeat.m2505o(27969);
        }

        public final void bBD() {
            int i;
            AppMethodBeat.m2504i(27970);
            C4990ab.m7416i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            C40482n.m69585w(C40482n.this);
            C40482n.this.vpt.mo27295a(C40482n.this.vjx);
            C40482n.m69575m(C40482n.this);
            if (C40482n.this.mContext instanceof Activity) {
                ((Activity) C40482n.this.mContext).getWindow().clearFlags(128);
            }
            C40482n.m69549Ll(2);
            C40482n.this.voV.mo38994oz(false);
            C40482n.this.vjx.setHint(null);
            TextView f = C40482n.this.voU;
            if (C40482n.this.vpy.size() < 2 || C40482n.this.vjx.getText().length() > 0) {
                i = 8;
            } else {
                i = 0;
            }
            f.setVisibility(i);
            AppMethodBeat.m2505o(27970);
        }

        public final void bBE() {
            AppMethodBeat.m2504i(27971);
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            C40482n.this.vpt.mo27295a(C40482n.this.vjx);
            C40482n.m69575m(C40482n.this);
            if (C40482n.this.mContext instanceof Activity) {
                ((Activity) C40482n.this.mContext).getWindow().clearFlags(128);
            }
            C40482n.m69549Ll(3);
            C40482n.this.voV.mo38994oz(false);
            C40482n.this.vjx.setHint(null);
            AppMethodBeat.m2505o(27971);
        }

        public final void bBF() {
            AppMethodBeat.m2504i(27972);
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            C40482n.m69585w(C40482n.this);
            C40482n.this.vpt.mo27295a(C40482n.this.vjx);
            C40482n.m69575m(C40482n.this);
            if (C40482n.this.mContext instanceof Activity) {
                ((Activity) C40482n.this.mContext).getWindow().clearFlags(128);
            }
            C40482n.m69550Lm(1);
            C40482n.this.voV.mo38994oz(false);
            C40482n.this.vjx.setHint(null);
            AppMethodBeat.m2505o(27972);
        }

        /* renamed from: c */
        public final void mo39028c(String[] strArr, List<String> list) {
            AppMethodBeat.m2504i(138174);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (C40482n.this.vpq) {
                    C40482n.this.vpq = false;
                    C40482n.m69587y(C40482n.this);
                }
                C40482n.this.vpt.mo27296a(C40482n.this.vjx, strArr[0], true);
                if (C40482n.this.vjx.getText().length() != 0) {
                    C40482n.this.vjx.setCursorVisible(true);
                    C40482n.this.vjx.requestFocus();
                    C5046bo.hideVKB(C40482n.this.voR);
                }
                if (!(C40482n.this.vpi || strArr[0].length() == 0)) {
                    C40482n.this.vpi = true;
                    C40482n.this.vpl = System.currentTimeMillis();
                    C4990ab.m7411d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(C40482n.this.vpl - C40482n.this.vpk));
                }
                C40482n.this.vps.addAll(list);
            }
            AppMethodBeat.m2505o(138174);
        }

        /* renamed from: at */
        public final void mo39022at(int i, int i2, int i3) {
            AppMethodBeat.m2504i(27974);
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            C40482n.m69585w(C40482n.this);
            C40482n.this.vpt.mo27295a(C40482n.this.vjx);
            C40482n.m69575m(C40482n.this);
            if (C40482n.this.mContext instanceof Activity) {
                ((Activity) C40482n.this.mContext).getWindow().clearFlags(128);
            }
            C40482n.m69550Lm(i);
            if (i == 12) {
                C40482n.m69563c(C40482n.this, (int) C25738R.string.f2_);
            } else {
                C40482n.m69563c(C40482n.this, (int) C25738R.string.f9111ps);
            }
            C40482n.this.voV.mo38994oz(false);
            C40482n.this.vjx.setHint(null);
            AppMethodBeat.m2505o(27974);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$5 */
    class C233015 implements OnClickListener {
        C233015() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27976);
            C40482n.m69562c(C40482n.this);
            AppMethodBeat.m2505o(27976);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$4 */
    class C301274 implements OnTouchListener {
        C301274() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27975);
            boolean a = C40482n.m69555a(C40482n.this, view, motionEvent);
            AppMethodBeat.m2505o(27975);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$11 */
    class C3686211 implements C35826a {
        C3686211() {
        }

        public final void bBI() {
            AppMethodBeat.m2504i(27983);
            C40482n.m69563c(C40482n.this, (int) C25738R.string.f2a);
            AppMethodBeat.m2505o(27983);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$6 */
    class C404796 implements OnClickListener {
        C404796() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27977);
            C40482n.m69553a(C40482n.this, 2);
            AppMethodBeat.m2505o(27977);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$8 */
    class C404808 implements OnClickListener {

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$8$2 */
        class C301282 implements C5662c {
            C301282() {
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
            }
        }

        C404808() {
        }

        public final void onClick(View view) {
            int size;
            AppMethodBeat.m2504i(27980);
            final C5659a c5659a = new C5659a(C40482n.this.getContext());
            C233021 c233021 = new OnCheckedChangeListener() {
                public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                    AppMethodBeat.m2504i(27979);
                    C40482n.this.vpw = i;
                    C40482n.this.voU.setText((CharSequence) C40482n.this.vpx.get(C40482n.this.vpw));
                    C40482n.this.voR.setLangType(((Integer) C40482n.this.vpy.get(C40482n.this.vpw)).intValue());
                    c5659a.gud.dismiss();
                    C40482n.this.mo64005Lk(2);
                    AppMethodBeat.m2505o(27979);
                }
            };
            C5659a al = c5659a.mo11514al(C40482n.this.getContext().getString(C25738R.string.f25));
            ArrayList e = C40482n.this.vpx;
            int d = C40482n.this.vpw;
            View inflate = View.inflate(al.mContext, 2130969293, null);
            al.zQN = (RadioGroup) inflate.findViewById(2131823310);
            if (e != null) {
                size = e.size();
            } else {
                size = 0;
            }
            for (int i = 0; i < size; i++) {
                RadioButton radioButton = (RadioButton) View.inflate(al.mContext, 2130969292, null);
                radioButton.setId(i);
                if (i == d) {
                    radioButton.setChecked(true);
                }
                radioButton.setText((CharSequence) e.get(i));
                al.zQN.addView(radioButton);
            }
            al.zQN.setOnCheckedChangeListener(c233021);
            al.vkm.mo11479fn(inflate);
            al.mo11526re(true);
            c5659a.mo11512a(new C301282());
            c5659a.show();
            C40482n.this.mo64005Lk(3);
            AppMethodBeat.m2505o(27980);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$a */
    public interface C40481a {
        void ajt(String str);

        void djr();

        /* renamed from: oz */
        void mo38994oz(boolean z);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$1 */
    class C404831 implements OnLongClickListener {
        C404831() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(27965);
            if (C40482n.this.vpf) {
                C40482n.this.mMX = true;
            }
            AppMethodBeat.m2505o(27965);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$b */
    static class C40484b extends PhoneStateListener {
        VoiceInputLayout voR;

        public C40484b(VoiceInputLayout voiceInputLayout) {
            this.voR = voiceInputLayout;
        }

        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.m2504i(27984);
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (this.voR != null) {
                i2 = this.voR.getCurrentState();
                this.voR.amA();
            }
            C4990ab.m7411d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 != 2) {
                AppMethodBeat.m2505o(27984);
            } else {
                AppMethodBeat.m2505o(27984);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$7 */
    class C404857 implements OnClickListener {
        C404857() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27978);
            C40482n.this.reset();
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            voiceInputBehavior.clear = 1;
            C40482n.m69561c(voiceInputBehavior);
            C40482n.this.mo64005Lk(4);
            AppMethodBeat.m2505o(27978);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.n$9 */
    class C404869 implements TextWatcher {
        C404869() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(27981);
            if (C40482n.this.vpy.size() < 2 || ((C40482n.this.vjx.getText() != null && C40482n.this.vjx.getText().length() > 0) || (C40482n.this.vjx.getHint() != null && C40482n.this.vjx.getHint().length() > 0))) {
                C40482n.this.voU.setVisibility(8);
                AppMethodBeat.m2505o(27981);
                return;
            }
            C40482n.this.voU.setVisibility(0);
            AppMethodBeat.m2505o(27981);
        }
    }

    /* renamed from: Ll */
    static /* synthetic */ void m69549Ll(int i) {
        AppMethodBeat.m2504i(28009);
        C40482n.m69548Lj(i);
        AppMethodBeat.m2505o(28009);
    }

    /* renamed from: m */
    static /* synthetic */ void m69575m(C40482n c40482n) {
        AppMethodBeat.m2504i(28006);
        c40482n.dkO();
        AppMethodBeat.m2505o(28006);
    }

    public C40482n(Context context, boolean z, MMEditText mMEditText) {
        super(context);
        AppMethodBeat.m2504i(27985);
        this.mContext = context;
        this.vpa = z;
        this.voW = mMEditText;
        init();
        this.vpt = new C14949l(this.mContext);
        this.cqz = "MicroMsg.VoiceInputPanel" + String.valueOf(System.nanoTime());
        C4990ab.m7417i("MicroMsg.VoiceInputPanel", "mToUser %s", this.cqz);
        dkM();
        int i = C26373g.m41964Nu().getInt("VoiceInputLanguageSupportType", C42236g.gbc);
        if (C4988aa.don()) {
            this.vpx.add(getContext().getString(C25738R.string.f27));
            this.vpy.add(Integer.valueOf(C42236g.gbc));
            if ((C42236g.gbd & i) != 0) {
                this.vpx.add(getContext().getString(C25738R.string.f26));
                this.vpy.add(Integer.valueOf(C42236g.gbd));
            }
            if ((i & C42236g.gbe) != 0) {
                this.vpx.add(getContext().getString(C25738R.string.f28));
                this.vpy.add(Integer.valueOf(C42236g.gbe));
            }
        } else if (C4988aa.dor().equals("en")) {
            this.vpx.add(getContext().getString(C25738R.string.f28));
            this.vpy.add(Integer.valueOf(C42236g.gbe));
            this.vpx.add(getContext().getString(C25738R.string.f27));
            this.vpy.add(Integer.valueOf(C42236g.gbc));
            if ((i & C42236g.gbd) != 0) {
                this.vpx.add(getContext().getString(C25738R.string.f26));
                this.vpy.add(Integer.valueOf(C42236g.gbd));
            }
        }
        this.vpw = 0;
        this.voU.setText((CharSequence) this.vpx.get(this.vpw));
        this.voR.setLangType(((Integer) this.vpy.get(this.vpw)).intValue());
        if (this.vpy.size() < 2) {
            this.voU.setVisibility(8);
        }
        AppMethodBeat.m2505o(27985);
    }

    @TargetApi(16)
    private void init() {
        AppMethodBeat.m2504i(27986);
        C4990ab.m7410d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), 2130971011, this);
        this.voS = (ImageButton) findViewById(2131828450);
        this.voT = (Button) findViewById(2131828451);
        this.voU = (TextView) findViewById(2131828447);
        this.oik = (Button) findViewById(2131828453);
        this.voY = (TextView) findViewById(2131828448);
        if (this.vpa) {
            this.voS.setVisibility(4);
        } else {
            this.voS.setVisibility(0);
        }
        this.oik.setVisibility(4);
        this.voT.setVisibility(8);
        if (!this.vpa || this.voW == null) {
            this.vjx = (MMEditText) findViewById(2131828445);
            this.vjx.setHintTextColor(getResources().getColor(C25738R.color.f12208w0));
            this.vjx.setClickable(true);
            this.vjx.setOnLongClickListener(new C404831());
            this.vjx.setOnTouchListener(new C301274());
        } else {
            this.vjx = this.voW;
        }
        this.voX = (VoiceInputScrollView) findViewById(2131828443);
        this.voS.setOnClickListener(new C233015());
        this.oik.setOnClickListener(new C404796());
        this.voT.setOnClickListener(new C404857());
        this.voU.setOnClickListener(new C404808());
        if ((this.vjx.getText() != null && this.vjx.getText().length() > 0) || (this.vjx.getHint() != null && this.vjx.getHint().length() > 0)) {
            this.voU.setVisibility(8);
        }
        this.vjx.addTextChangedListener(new C404869());
        this.voX.setOnTouchListener(new C475610());
        AppMethodBeat.m2505o(27986);
    }

    public final void dkM() {
        AppMethodBeat.m2504i(27987);
        this.voZ = C5046bo.m7588yz();
        if (this.vpu == null) {
            C4990ab.m7416i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.vpu = new C232992();
            C4879a.xxA.mo10052c(this.vpu);
        }
        if (this.voR == null) {
            this.voR = (VoiceInputLayout) findViewById(2131828452);
            this.voR.setVoiceDetectListener(this.vpA);
            this.voR.setLongClickLisnter(this.vjs);
            this.voR.setFromFullScreen(this.vpa);
        }
        this.voY.setVisibility(0);
        if (this.vpv == null) {
            this.vpv = new C26504b();
        }
        SharedPreferences doB = C4996ah.doB();
        if (doB != null) {
            String string = doB.getString("voiceinput_downdistance_content", "");
            if (!string.equalsIgnoreCase("")) {
                C4990ab.m7411d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", Integer.valueOf(string.length()));
                this.vpt.mo27298b(this.vjx);
                this.vpt.mo27296a(this.vjx, string, false);
                this.vpt.mo27295a(this.vjx);
                this.vpt.mo27298b(this.vjx);
                dkO();
                this.voX.fullScroll(130);
                doB.edit().remove("voiceinput_downdistance_content").apply();
            }
        }
        this.nva = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        if (this.nva != null) {
            if (this.vpz == null) {
                this.vpz = new C40484b(this.voR);
            }
            this.nva.listen(this.vpz, 32);
        }
        AppMethodBeat.m2505o(27987);
    }

    public final void setFullScreenData(String str) {
        AppMethodBeat.m2504i(27988);
        if (str != null) {
            this.vpr = str;
        }
        dkO();
        AppMethodBeat.m2505o(27988);
    }

    public final void setCallback(C40481a c40481a) {
        this.voV = c40481a;
    }

    public final void pause() {
        AppMethodBeat.m2504i(27989);
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
        AppMethodBeat.m2505o(27989);
    }

    public final void reset() {
        AppMethodBeat.m2504i(27990);
        C4990ab.m7416i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.vpo = false;
        this.vps.clear();
        if (this.vjx != null) {
            if (this.vpt != null) {
                this.vpt.mo27298b(this.vjx);
                this.vpt.mo27296a(this.vjx, "", false);
                this.vpt.mo27295a(this.vjx);
                this.vpt.mo27298b(this.vjx);
            }
            dkO();
        }
        AppMethodBeat.m2505o(27990);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(27991);
        C4990ab.m7416i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.vpu != null) {
            C4879a.xxA.mo10053d(this.vpu);
            this.vpu = null;
        }
        if (this.voR != null) {
            this.voR.setVoiceDetectListener(null);
            this.voR = null;
        }
        if (this.vpv != null) {
            this.vpv = null;
        }
        if (!(this.nva == null || this.vpz == null)) {
            this.nva.listen(this.vpz, 0);
            this.vpz.voR = null;
            this.vpz = null;
        }
        this.nva = null;
        this.voW = null;
        if (!this.cqz.startsWith("MicroMsg.VoiceInputPanel")) {
            this.vpt.mo27299ea(this.cqz, ((Integer) this.vpy.get(this.vpw)).intValue());
        }
        VoiceInputLayoutImpl voiceInputLayoutImpl = (VoiceInputLayoutImpl) findViewById(2131828452);
        if (voiceInputLayoutImpl != null) {
            C4990ab.m7416i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
            voiceInputLayoutImpl.bBP();
            voiceInputLayoutImpl.djt();
        }
        AppMethodBeat.m2505o(27991);
    }

    private void dkN() {
        AppMethodBeat.m2504i(27992);
        C4990ab.m7410d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.voV != null) {
            this.vpn = true;
            C4990ab.m7416i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (this.vjx == null || this.vjx.getText() == null || this.vjx.getText().length() <= 0) {
                if (this.vpn) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (this.vpn) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (this.voZ != 0) {
                voiceInputBehavior.voiceInputTime = C5046bo.m7525az(this.voZ);
                this.voZ = 0;
            }
            C40482n.m69552a(voiceInputBehavior);
            this.voV.djr();
        }
        AppMethodBeat.m2505o(27992);
    }

    public final void setPortHeightPX(int i) {
        AppMethodBeat.m2504i(27993);
        C4990ab.m7411d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", Integer.valueOf(this.vmi), Integer.valueOf(i));
        if (this.vmi != i) {
            this.vmi = i;
            this.vpB = true;
        }
        AppMethodBeat.m2505o(27993);
    }

    public final void djT() {
        AppMethodBeat.m2504i(27994);
        C4990ab.m7411d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(this.vmi), Boolean.valueOf(this.vpB));
        if (this.vpB) {
            this.vpB = false;
            View findViewById = findViewById(2131828442);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = this.vmi;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            init();
            dkO();
            requestLayout();
        }
        AppMethodBeat.m2505o(27994);
    }

    public final void setToUser(String str) {
        int i = 0;
        AppMethodBeat.m2504i(27995);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
            AppMethodBeat.m2505o(27995);
            return;
        }
        this.cqz = str;
        this.vpw = 0;
        int aju = this.vpt.aju(str);
        while (true) {
            int i2 = i;
            if (i2 >= this.vpy.size()) {
                break;
            } else if (aju == ((Integer) this.vpy.get(i2)).intValue()) {
                this.vpw = i2;
                this.voU.setText((CharSequence) this.vpx.get(this.vpw));
                this.voR.setLangType(((Integer) this.vpy.get(this.vpw)).intValue());
                if (this.vpy.size() < 2) {
                    this.voU.setVisibility(8);
                    AppMethodBeat.m2505o(27995);
                    return;
                }
            } else {
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(27995);
    }

    private void dkO() {
        AppMethodBeat.m2504i(27996);
        C4990ab.m7410d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.vjx == null || this.vjx.getText() == null || this.vjx.getText().length() != 0) {
            if (this.vjx != null) {
                this.vjx.setCursorVisible(true);
            }
            this.oik.setVisibility(0);
            if (!this.vpa) {
                this.voS.setVisibility(8);
                this.voT.setVisibility(0);
            }
            this.voY.setVisibility(8);
        } else {
            this.vjx.setSelection(0);
            this.vjx.setCursorVisible(false);
            this.oik.setVisibility(4);
            if (!this.vpa) {
                this.voS.setVisibility(0);
            }
            this.voT.setVisibility(8);
            this.voY.setVisibility(0);
        }
        if (this.vpa) {
            if (this.voW == null || this.voW.getText() == null || this.voW.getText().length() != 0) {
                this.oik.setVisibility(0);
            } else {
                this.oik.setVisibility(4);
            }
        }
        if (this.vjx != null) {
            this.vjx.clearFocus();
        }
        C40482n.m69547KY();
        if (!this.vpj) {
            this.vpj = true;
            this.vpm = System.currentTimeMillis();
            C4990ab.m7411d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.vpm), Long.valueOf(this.vpm - this.vpl));
        }
        AppMethodBeat.m2505o(27996);
    }

    /* renamed from: KY */
    private static void m69547KY() {
        AppMethodBeat.m2504i(27997);
        C4990ab.m7416i("MicroMsg.VoiceInputPanel", "resumeMusic");
        C9638aw.m17191ZL().mo4824KY();
        AppMethodBeat.m2505o(27997);
    }

    /* renamed from: a */
    private static void m69552a(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.m2504i(27998);
        C4990ab.m7417i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        C7060h.pYm.mo15417c(13905, log_13905);
        AppMethodBeat.m2505o(27998);
    }

    /* renamed from: Lj */
    private static void m69548Lj(int i) {
        AppMethodBeat.m2504i(27999);
        C4990ab.m7417i("MicroMsg.VoiceInputPanel", "idkReport type = %s", Integer.valueOf(i));
        C7060h.pYm.mo8378a(455, (long) i, 1, false);
        AppMethodBeat.m2505o(27999);
    }

    /* renamed from: Lk */
    public final void mo64005Lk(int i) {
        AppMethodBeat.m2504i(28000);
        C4990ab.m7417i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", Integer.valueOf(i), C4988aa.dor(), ((Integer) this.vpy.get(this.vpw)).toString());
        C18437az c18437az = new C18437az();
        c18437az.daO = (long) i;
        c18437az.mo33691fR(C4988aa.dor()).mo33692fS(((Integer) this.vpy.get(this.vpw)).toString()).ajK();
        AppMethodBeat.m2505o(28000);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m69555a(C40482n c40482n, View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(28001);
        if (motionEvent.getAction() == 0) {
            boolean z;
            if (c40482n.voX.getScrollY() <= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c40482n.vpe = true;
                c40482n.vpb = motionEvent.getRawY();
            }
            c40482n.vpf = true;
        } else if (motionEvent.getAction() == 2) {
            c40482n.vpd = true;
        } else if (motionEvent.getAction() == 1) {
            float f;
            if (c40482n.vpd && c40482n.vpe) {
                c40482n.vpc = motionEvent.getRawY();
                f = c40482n.vpc - c40482n.vpb;
            } else {
                f = 0.0f;
            }
            c40482n.vpf = false;
            c40482n.vpd = false;
            c40482n.vpe = false;
            c40482n.vpc = 0.0f;
            c40482n.vpb = 0.0f;
            if (f > ((float) c40482n.vpg)) {
                if (!(c40482n.vjx == null || c40482n.vjx.getText() == null || c40482n.vjx.getText().length() <= 0)) {
                    SharedPreferences doB = C4996ah.doB();
                    if (doB != null) {
                        doB.edit().putString("voiceinput_downdistance_content", c40482n.vjx.getText().toString()).apply();
                        C4990ab.m7410d("MicroMsg.VoiceInputPanel", "onDownDistance save memory content");
                    }
                }
                c40482n.dkN();
            } else if (c40482n.mMX) {
                c40482n.mMX = false;
            } else if ((view instanceof MMEditText) && c40482n.vjx != null && c40482n.vjx.getText() != null && c40482n.vjx.getText().length() > 0) {
                Spannable newSpannable = Factory.getInstance().newSpannable(((MMEditText) view).getText());
                MMEditText mMEditText = (MMEditText) view;
                motionEvent.getAction();
                int x = (((int) motionEvent.getX()) - mMEditText.getTotalPaddingLeft()) + mMEditText.getScrollX();
                int y = (((int) motionEvent.getY()) - mMEditText.getTotalPaddingTop()) + mMEditText.getScrollY();
                Layout layout = mMEditText.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(view);
                } else {
                    C4990ab.m7417i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", Integer.valueOf(((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY())));
                    if (c40482n.voR != null) {
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        voiceInputBehavior.textClick = c40482n.voR.getCurrentState();
                        C40482n.m69552a(voiceInputBehavior);
                    }
                    Intent intent = new Intent();
                    intent.setClass(c40482n.getContext(), VoiceInputUI.class);
                    intent.putExtra("offset", offsetForHorizontal);
                    intent.putExtra("userCode", c40482n.cqz);
                    if (!(c40482n.vjx == null || c40482n.vjx.getText() == null)) {
                        intent.putExtra("text", c40482n.vjx.getText().toString());
                        if (c40482n.vpt != null) {
                            c40482n.vpt.mo27298b(c40482n.vjx);
                        }
                    }
                    if (c40482n.vpr.equalsIgnoreCase("。") || c40482n.vpr.equalsIgnoreCase(".")) {
                        intent.putExtra("punctuation", c40482n.vpr);
                    }
                    c40482n.vpt.mo27299ea(c40482n.cqz, ((Integer) c40482n.vpy.get(c40482n.vpw)).intValue());
                    c40482n.getContext().startActivity(intent);
                    if (c40482n.voR != null) {
                        C5046bo.hideVKB(c40482n.voR);
                        c40482n.voR.amA();
                    }
                }
            }
            if (view instanceof MMEditText) {
                AppMethodBeat.m2505o(28001);
                return true;
            }
            AppMethodBeat.m2505o(28001);
            return false;
        }
        if (view instanceof MMEditText) {
            AppMethodBeat.m2505o(28001);
            return true;
        }
        AppMethodBeat.m2505o(28001);
        return false;
    }

    static /* synthetic */ void dkP() {
        AppMethodBeat.m2504i(28007);
        C4990ab.m7416i("MicroMsg.VoiceInputPanel", "pauseMusic");
        C9638aw.m17191ZL().mo4823KX();
        AppMethodBeat.m2505o(28007);
    }

    /* renamed from: w */
    static /* synthetic */ void m69585w(C40482n c40482n) {
        AppMethodBeat.m2504i(28008);
        if (!(c40482n.vjx == null || c40482n.vjx.getText() == null)) {
            String obj = c40482n.vjx.getText().toString();
            if (obj.length() > 0 && (!c40482n.vpa || c40482n.vjx.getSelectionStart() >= obj.length())) {
                c40482n.vpr = obj.substring(obj.length() - 1, obj.length());
                C4990ab.m7417i("MicroMsg.VoiceInputPanel", "delPunctuation msg = %s ,msg.length() = %s, punctuation = %s", C5046bo.anv(obj), Integer.valueOf(obj.length()), c40482n.vpr);
                if (c40482n.vpr.equalsIgnoreCase("。") || c40482n.vpr.equalsIgnoreCase(".")) {
                    c40482n.vjx.setText(obj.substring(0, obj.length() - 1));
                }
            }
        }
        AppMethodBeat.m2505o(28008);
    }

    /* renamed from: Lm */
    static /* synthetic */ void m69550Lm(int i) {
        AppMethodBeat.m2504i(28010);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.fail = i;
        C40482n.m69552a(voiceInputBehavior);
        C40482n.m69548Lj(i);
        AppMethodBeat.m2505o(28010);
    }

    /* renamed from: y */
    static /* synthetic */ void m69587y(C40482n c40482n) {
        AppMethodBeat.m2504i(28011);
        if (!(c40482n.vjx == null || c40482n.vjx.getText() == null || c40482n.vjx.getText().length() <= 0)) {
            if (c40482n.vpr.equalsIgnoreCase("。") || c40482n.vpr.equalsIgnoreCase(".")) {
                if (!c40482n.vpa || c40482n.vjx.getSelectionStart() >= c40482n.vjx.getText().length()) {
                    c40482n.vpt.mo27296a(c40482n.vjx, c40482n.vpr, true);
                    c40482n.vpt.mo27298b(c40482n.vjx);
                }
                c40482n.vpr = "";
            }
            String obj = c40482n.vjx.getText().toString();
            C4990ab.m7417i("MicroMsg.VoiceInputPanel", "addPunctuation msg = %s,msg.length() = %s", C5046bo.anv(obj), Integer.valueOf(obj.length()));
        }
        AppMethodBeat.m2505o(28011);
    }
}
