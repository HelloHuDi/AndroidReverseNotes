package com.tencent.mm.pluginsdk.ui.chat;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;

public final class n extends LinearLayout {
    private String cqz = "";
    private Context mContext;
    private Toast mMP;
    private boolean mMX = false;
    private TelephonyManager nva;
    private Button oik;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a vjs = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a() {
        public final void bBI() {
            AppMethodBeat.i(27983);
            n.c(n.this, (int) R.string.f2a);
            AppMethodBeat.o(27983);
        }
    };
    private MMEditText vjx;
    private c vmV;
    private int vmi = com.tencent.mm.bz.a.fromDPToPix(getContext(), b.CTRL_INDEX);
    private VoiceInputLayout voR;
    private ImageButton voS;
    private Button voT;
    private TextView voU;
    private a voV;
    private MMEditText voW = null;
    private VoiceInputScrollView voX;
    private TextView voY;
    private long voZ = 0;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b vpA = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b() {
        public final void bBz() {
            AppMethodBeat.i(27968);
            n.this.vpk = System.currentTimeMillis();
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(n.this.vpk));
            ab.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(n.this.vpk));
            n.this.vpi = false;
            n.this.vpj = true;
            n.this.vpq = true;
            n.this.vpl = 0;
            n.this.vpm = 0;
            n.m(n.this);
            n.this.voY.setVisibility(8);
            n.this.vpj = false;
            n.this.vpt.vjo = 3;
            n.this.vpt.b(n.this.vjx);
            n.dkP();
            if (n.this.vjx != null) {
                if (n.this.vjx.getText() != null && n.this.vjx.getText().length() > 0) {
                    n.this.vjx.setCursorVisible(true);
                }
                n.this.vjx.requestFocus();
                bo.hideVKB(n.this.voR);
            }
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().addFlags(128);
            }
            n.this.oik.setVisibility(4);
            n.this.voS.setVisibility(4);
            n.this.voT.setVisibility(8);
            n.this.vjx.setHint(n.this.getResources().getString(R.string.f29));
            n.this.voV.oz(true);
            n.this.voU.setVisibility(8);
            n.this.Lk(1);
            AppMethodBeat.o(27968);
        }

        public final void bBC() {
            int i = 0;
            AppMethodBeat.i(27969);
            n.this.voV.oz(false);
            n.this.vjx.setHint(null);
            TextView f = n.this.voU;
            if (n.this.vpy.size() < 2 || n.this.vjx.getText().length() > 0) {
                i = 8;
            }
            f.setVisibility(i);
            AppMethodBeat.o(27969);
        }

        public final void bBD() {
            int i;
            AppMethodBeat.i(27970);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            n.w(n.this);
            n.this.vpt.a(n.this.vjx);
            n.m(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.Ll(2);
            n.this.voV.oz(false);
            n.this.vjx.setHint(null);
            TextView f = n.this.voU;
            if (n.this.vpy.size() < 2 || n.this.vjx.getText().length() > 0) {
                i = 8;
            } else {
                i = 0;
            }
            f.setVisibility(i);
            AppMethodBeat.o(27970);
        }

        public final void bBE() {
            AppMethodBeat.i(27971);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            n.this.vpt.a(n.this.vjx);
            n.m(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.Ll(3);
            n.this.voV.oz(false);
            n.this.vjx.setHint(null);
            AppMethodBeat.o(27971);
        }

        public final void bBF() {
            AppMethodBeat.i(27972);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            n.w(n.this);
            n.this.vpt.a(n.this.vjx);
            n.m(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.Lm(1);
            n.this.voV.oz(false);
            n.this.vjx.setHint(null);
            AppMethodBeat.o(27972);
        }

        public final void c(String[] strArr, List<String> list) {
            AppMethodBeat.i(138174);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (n.this.vpq) {
                    n.this.vpq = false;
                    n.y(n.this);
                }
                n.this.vpt.a(n.this.vjx, strArr[0], true);
                if (n.this.vjx.getText().length() != 0) {
                    n.this.vjx.setCursorVisible(true);
                    n.this.vjx.requestFocus();
                    bo.hideVKB(n.this.voR);
                }
                if (!(n.this.vpi || strArr[0].length() == 0)) {
                    n.this.vpi = true;
                    n.this.vpl = System.currentTimeMillis();
                    ab.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.this.vpl - n.this.vpk));
                }
                n.this.vps.addAll(list);
            }
            AppMethodBeat.o(138174);
        }

        public final void at(int i, int i2, int i3) {
            AppMethodBeat.i(27974);
            ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            n.w(n.this);
            n.this.vpt.a(n.this.vjx);
            n.m(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.Lm(i);
            if (i == 12) {
                n.c(n.this, (int) R.string.f2_);
            } else {
                n.c(n.this, (int) R.string.ps);
            }
            n.this.voV.oz(false);
            n.this.vjx.setHint(null);
            AppMethodBeat.o(27974);
        }
    };
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
    private l vpt;
    private com.tencent.mm.sdk.b.c<uc> vpu;
    private com.tencent.mm.modelvoiceaddr.b.b vpv;
    private int vpw = 0;
    private ArrayList<String> vpx = new ArrayList();
    private ArrayList<Integer> vpy = new ArrayList();
    b vpz;

    public interface a {
        void ajt(String str);

        void djr();

        void oz(boolean z);
    }

    static class b extends PhoneStateListener {
        VoiceInputLayout voR;

        public b(VoiceInputLayout voiceInputLayout) {
            this.voR = voiceInputLayout;
        }

        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.i(27984);
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (this.voR != null) {
                i2 = this.voR.getCurrentState();
                this.voR.amA();
            }
            ab.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 != 2) {
                AppMethodBeat.o(27984);
            } else {
                AppMethodBeat.o(27984);
            }
        }
    }

    static /* synthetic */ void Ll(int i) {
        AppMethodBeat.i(28009);
        Lj(i);
        AppMethodBeat.o(28009);
    }

    static /* synthetic */ void m(n nVar) {
        AppMethodBeat.i(28006);
        nVar.dkO();
        AppMethodBeat.o(28006);
    }

    public n(Context context, boolean z, MMEditText mMEditText) {
        super(context);
        AppMethodBeat.i(27985);
        this.mContext = context;
        this.vpa = z;
        this.voW = mMEditText;
        init();
        this.vpt = new l(this.mContext);
        this.cqz = "MicroMsg.VoiceInputPanel" + String.valueOf(System.nanoTime());
        ab.i("MicroMsg.VoiceInputPanel", "mToUser %s", this.cqz);
        dkM();
        int i = g.Nu().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.gbc);
        if (aa.don()) {
            this.vpx.add(getContext().getString(R.string.f27));
            this.vpy.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbc));
            if ((com.tencent.mm.modelvoiceaddr.g.gbd & i) != 0) {
                this.vpx.add(getContext().getString(R.string.f26));
                this.vpy.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbd));
            }
            if ((i & com.tencent.mm.modelvoiceaddr.g.gbe) != 0) {
                this.vpx.add(getContext().getString(R.string.f28));
                this.vpy.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbe));
            }
        } else if (aa.dor().equals("en")) {
            this.vpx.add(getContext().getString(R.string.f28));
            this.vpy.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbe));
            this.vpx.add(getContext().getString(R.string.f27));
            this.vpy.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbc));
            if ((i & com.tencent.mm.modelvoiceaddr.g.gbd) != 0) {
                this.vpx.add(getContext().getString(R.string.f26));
                this.vpy.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbd));
            }
        }
        this.vpw = 0;
        this.voU.setText((CharSequence) this.vpx.get(this.vpw));
        this.voR.setLangType(((Integer) this.vpy.get(this.vpw)).intValue());
        if (this.vpy.size() < 2) {
            this.voU.setVisibility(8);
        }
        AppMethodBeat.o(27985);
    }

    @TargetApi(16)
    private void init() {
        AppMethodBeat.i(27986);
        ab.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.layout.b1y, this);
        this.voS = (ImageButton) findViewById(R.id.f1p);
        this.voT = (Button) findViewById(R.id.f1q);
        this.voU = (TextView) findViewById(R.id.f1m);
        this.oik = (Button) findViewById(R.id.f1s);
        this.voY = (TextView) findViewById(R.id.f1n);
        if (this.vpa) {
            this.voS.setVisibility(4);
        } else {
            this.voS.setVisibility(0);
        }
        this.oik.setVisibility(4);
        this.voT.setVisibility(8);
        if (!this.vpa || this.voW == null) {
            this.vjx = (MMEditText) findViewById(R.id.f1k);
            this.vjx.setHintTextColor(getResources().getColor(R.color.w0));
            this.vjx.setClickable(true);
            this.vjx.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(27965);
                    if (n.this.vpf) {
                        n.this.mMX = true;
                    }
                    AppMethodBeat.o(27965);
                    return true;
                }
            });
            this.vjx.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(27975);
                    boolean a = n.a(n.this, view, motionEvent);
                    AppMethodBeat.o(27975);
                    return a;
                }
            });
        } else {
            this.vjx = this.voW;
        }
        this.voX = (VoiceInputScrollView) findViewById(R.id.f1i);
        this.voS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27976);
                n.c(n.this);
                AppMethodBeat.o(27976);
            }
        });
        this.oik.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27977);
                n.a(n.this, 2);
                AppMethodBeat.o(27977);
            }
        });
        this.voT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27978);
                n.this.reset();
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.clear = 1;
                n.c(voiceInputBehavior);
                n.this.Lk(4);
                AppMethodBeat.o(27978);
            }
        });
        this.voU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int size;
                AppMethodBeat.i(27980);
                final com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(n.this.getContext());
                AnonymousClass1 anonymousClass1 = new OnCheckedChangeListener() {
                    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                        AppMethodBeat.i(27979);
                        n.this.vpw = i;
                        n.this.voU.setText((CharSequence) n.this.vpx.get(n.this.vpw));
                        n.this.voR.setLangType(((Integer) n.this.vpy.get(n.this.vpw)).intValue());
                        aVar.gud.dismiss();
                        n.this.Lk(2);
                        AppMethodBeat.o(27979);
                    }
                };
                com.tencent.mm.ui.widget.a.e.a al = aVar.al(n.this.getContext().getString(R.string.f25));
                ArrayList e = n.this.vpx;
                int d = n.this.vpw;
                View inflate = View.inflate(al.mContext, R.layout.sm, null);
                al.zQN = (RadioGroup) inflate.findViewById(R.id.b_r);
                if (e != null) {
                    size = e.size();
                } else {
                    size = 0;
                }
                for (int i = 0; i < size; i++) {
                    RadioButton radioButton = (RadioButton) View.inflate(al.mContext, R.layout.sl, null);
                    radioButton.setId(i);
                    if (i == d) {
                        radioButton.setChecked(true);
                    }
                    radioButton.setText((CharSequence) e.get(i));
                    al.zQN.addView(radioButton);
                }
                al.zQN.setOnCheckedChangeListener(anonymousClass1);
                al.vkm.fn(inflate);
                al.re(true);
                aVar.a(new e.c() {
                    public final void d(boolean z, String str) {
                    }
                });
                aVar.show();
                n.this.Lk(3);
                AppMethodBeat.o(27980);
            }
        });
        if ((this.vjx.getText() != null && this.vjx.getText().length() > 0) || (this.vjx.getHint() != null && this.vjx.getHint().length() > 0)) {
            this.voU.setVisibility(8);
        }
        this.vjx.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(27981);
                if (n.this.vpy.size() < 2 || ((n.this.vjx.getText() != null && n.this.vjx.getText().length() > 0) || (n.this.vjx.getHint() != null && n.this.vjx.getHint().length() > 0))) {
                    n.this.voU.setVisibility(8);
                    AppMethodBeat.o(27981);
                    return;
                }
                n.this.voU.setVisibility(0);
                AppMethodBeat.o(27981);
            }
        });
        this.voX.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(27982);
                boolean a = n.a(n.this, view, motionEvent);
                AppMethodBeat.o(27982);
                return a;
            }
        });
        AppMethodBeat.o(27986);
    }

    public final void dkM() {
        AppMethodBeat.i(27987);
        this.voZ = bo.yz();
        if (this.vpu == null) {
            ab.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.vpu = new com.tencent.mm.sdk.b.c<uc>() {
                {
                    AppMethodBeat.i(27966);
                    this.xxI = uc.class.getName().hashCode();
                    AppMethodBeat.o(27966);
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(27967);
                    uc ucVar = (uc) bVar;
                    if (!(ucVar instanceof uc)) {
                        ab.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        AppMethodBeat.o(27967);
                        return false;
                    } else if (ucVar == null || ucVar.cQk == null) {
                        ab.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        AppMethodBeat.o(27967);
                        return false;
                    } else if (n.this.vpa) {
                        ab.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent fromFullScreen true");
                        AppMethodBeat.o(27967);
                        return false;
                    } else if (ucVar.cQk.userCode.equalsIgnoreCase(n.this.cqz)) {
                        n.this.setToUser(n.this.cqz);
                        ab.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(ucVar.cQk.action), Integer.valueOf(ucVar.cQk.cQl));
                        if (ucVar.cQk.action == 2) {
                            if (ucVar.cQk.cQl == 1) {
                                n.this.vpo = true;
                            } else {
                                n.this.vpo = false;
                            }
                            n.this.vpt.a(n.this.vjx, ucVar.cQk.result, false);
                            n.this.vpt.a(n.this.vjx);
                            n.this.vpt.b(n.this.vjx);
                            n.m(n.this);
                            n.this.voX.fullScroll(130);
                        } else if (ucVar.cQk.action == 3) {
                            if (n.this.voV != null) {
                                n.this.voV.djr();
                            }
                        } else if (ucVar.cQk.action == 1 || ucVar.cQk.action == 4) {
                            if (ucVar.cQk.cQl == 1) {
                                n.this.vpo = true;
                            } else {
                                n.this.vpo = false;
                            }
                            n.this.vpt.a(n.this.vjx, ucVar.cQk.result, false);
                            n.this.vpt.a(n.this.vjx);
                            n.this.vpt.b(n.this.vjx);
                            n.m(n.this);
                            n.this.voX.fullScroll(130);
                            n.a(n.this, ucVar.cQk.action);
                        } else {
                            n.this.reset();
                        }
                        AppMethodBeat.o(27967);
                        return true;
                    } else {
                        ab.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        n.this.destroy();
                        AppMethodBeat.o(27967);
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
            this.voR.setFromFullScreen(this.vpa);
        }
        this.voY.setVisibility(0);
        if (this.vpv == null) {
            this.vpv = new com.tencent.mm.modelvoiceaddr.b.b();
        }
        SharedPreferences doB = ah.doB();
        if (doB != null) {
            String string = doB.getString("voiceinput_downdistance_content", "");
            if (!string.equalsIgnoreCase("")) {
                ab.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", Integer.valueOf(string.length()));
                this.vpt.b(this.vjx);
                this.vpt.a(this.vjx, string, false);
                this.vpt.a(this.vjx);
                this.vpt.b(this.vjx);
                dkO();
                this.voX.fullScroll(130);
                doB.edit().remove("voiceinput_downdistance_content").apply();
            }
        }
        this.nva = (TelephonyManager) ah.getContext().getSystemService("phone");
        if (this.nva != null) {
            if (this.vpz == null) {
                this.vpz = new b(this.voR);
            }
            this.nva.listen(this.vpz, 32);
        }
        AppMethodBeat.o(27987);
    }

    public final void setFullScreenData(String str) {
        AppMethodBeat.i(27988);
        if (str != null) {
            this.vpr = str;
        }
        dkO();
        AppMethodBeat.o(27988);
    }

    public final void setCallback(a aVar) {
        this.voV = aVar;
    }

    public final void pause() {
        AppMethodBeat.i(27989);
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
        AppMethodBeat.o(27989);
    }

    public final void reset() {
        AppMethodBeat.i(27990);
        ab.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.vpo = false;
        this.vps.clear();
        if (this.vjx != null) {
            if (this.vpt != null) {
                this.vpt.b(this.vjx);
                this.vpt.a(this.vjx, "", false);
                this.vpt.a(this.vjx);
                this.vpt.b(this.vjx);
            }
            dkO();
        }
        AppMethodBeat.o(27990);
    }

    public final void destroy() {
        AppMethodBeat.i(27991);
        ab.i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.vpu != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.vpu);
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
            this.vpt.ea(this.cqz, ((Integer) this.vpy.get(this.vpw)).intValue());
        }
        VoiceInputLayoutImpl voiceInputLayoutImpl = (VoiceInputLayoutImpl) findViewById(R.id.f1r);
        if (voiceInputLayoutImpl != null) {
            ab.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
            voiceInputLayoutImpl.bBP();
            voiceInputLayoutImpl.djt();
        }
        AppMethodBeat.o(27991);
    }

    private void dkN() {
        AppMethodBeat.i(27992);
        ab.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.voV != null) {
            this.vpn = true;
            ab.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
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
                voiceInputBehavior.voiceInputTime = bo.az(this.voZ);
                this.voZ = 0;
            }
            a(voiceInputBehavior);
            this.voV.djr();
        }
        AppMethodBeat.o(27992);
    }

    public final void setPortHeightPX(int i) {
        AppMethodBeat.i(27993);
        ab.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", Integer.valueOf(this.vmi), Integer.valueOf(i));
        if (this.vmi != i) {
            this.vmi = i;
            this.vpB = true;
        }
        AppMethodBeat.o(27993);
    }

    public final void djT() {
        AppMethodBeat.i(27994);
        ab.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(this.vmi), Boolean.valueOf(this.vpB));
        if (this.vpB) {
            this.vpB = false;
            View findViewById = findViewById(R.id.f1h);
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
        AppMethodBeat.o(27994);
    }

    public final void setToUser(String str) {
        int i = 0;
        AppMethodBeat.i(27995);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
            AppMethodBeat.o(27995);
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
                    AppMethodBeat.o(27995);
                    return;
                }
            } else {
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(27995);
    }

    private void dkO() {
        AppMethodBeat.i(27996);
        ab.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
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
        KY();
        if (!this.vpj) {
            this.vpj = true;
            this.vpm = System.currentTimeMillis();
            ab.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.vpm), Long.valueOf(this.vpm - this.vpl));
        }
        AppMethodBeat.o(27996);
    }

    private static void KY() {
        AppMethodBeat.i(27997);
        ab.i("MicroMsg.VoiceInputPanel", "resumeMusic");
        aw.ZL().KY();
        AppMethodBeat.o(27997);
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.i(27998);
        ab.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        h.pYm.c(13905, log_13905);
        AppMethodBeat.o(27998);
    }

    private static void Lj(int i) {
        AppMethodBeat.i(27999);
        ab.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", Integer.valueOf(i));
        h.pYm.a(455, (long) i, 1, false);
        AppMethodBeat.o(27999);
    }

    public final void Lk(int i) {
        AppMethodBeat.i(28000);
        ab.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", Integer.valueOf(i), aa.dor(), ((Integer) this.vpy.get(this.vpw)).toString());
        az azVar = new az();
        azVar.daO = (long) i;
        azVar.fR(aa.dor()).fS(((Integer) this.vpy.get(this.vpw)).toString()).ajK();
        AppMethodBeat.o(28000);
    }

    static /* synthetic */ boolean a(n nVar, View view, MotionEvent motionEvent) {
        AppMethodBeat.i(28001);
        if (motionEvent.getAction() == 0) {
            boolean z;
            if (nVar.voX.getScrollY() <= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                nVar.vpe = true;
                nVar.vpb = motionEvent.getRawY();
            }
            nVar.vpf = true;
        } else if (motionEvent.getAction() == 2) {
            nVar.vpd = true;
        } else if (motionEvent.getAction() == 1) {
            float f;
            if (nVar.vpd && nVar.vpe) {
                nVar.vpc = motionEvent.getRawY();
                f = nVar.vpc - nVar.vpb;
            } else {
                f = 0.0f;
            }
            nVar.vpf = false;
            nVar.vpd = false;
            nVar.vpe = false;
            nVar.vpc = 0.0f;
            nVar.vpb = 0.0f;
            if (f > ((float) nVar.vpg)) {
                if (!(nVar.vjx == null || nVar.vjx.getText() == null || nVar.vjx.getText().length() <= 0)) {
                    SharedPreferences doB = ah.doB();
                    if (doB != null) {
                        doB.edit().putString("voiceinput_downdistance_content", nVar.vjx.getText().toString()).apply();
                        ab.d("MicroMsg.VoiceInputPanel", "onDownDistance save memory content");
                    }
                }
                nVar.dkN();
            } else if (nVar.mMX) {
                nVar.mMX = false;
            } else if ((view instanceof MMEditText) && nVar.vjx != null && nVar.vjx.getText() != null && nVar.vjx.getText().length() > 0) {
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
                    ab.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", Integer.valueOf(((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY())));
                    if (nVar.voR != null) {
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        voiceInputBehavior.textClick = nVar.voR.getCurrentState();
                        a(voiceInputBehavior);
                    }
                    Intent intent = new Intent();
                    intent.setClass(nVar.getContext(), VoiceInputUI.class);
                    intent.putExtra("offset", offsetForHorizontal);
                    intent.putExtra("userCode", nVar.cqz);
                    if (!(nVar.vjx == null || nVar.vjx.getText() == null)) {
                        intent.putExtra("text", nVar.vjx.getText().toString());
                        if (nVar.vpt != null) {
                            nVar.vpt.b(nVar.vjx);
                        }
                    }
                    if (nVar.vpr.equalsIgnoreCase("。") || nVar.vpr.equalsIgnoreCase(".")) {
                        intent.putExtra("punctuation", nVar.vpr);
                    }
                    nVar.vpt.ea(nVar.cqz, ((Integer) nVar.vpy.get(nVar.vpw)).intValue());
                    nVar.getContext().startActivity(intent);
                    if (nVar.voR != null) {
                        bo.hideVKB(nVar.voR);
                        nVar.voR.amA();
                    }
                }
            }
            if (view instanceof MMEditText) {
                AppMethodBeat.o(28001);
                return true;
            }
            AppMethodBeat.o(28001);
            return false;
        }
        if (view instanceof MMEditText) {
            AppMethodBeat.o(28001);
            return true;
        }
        AppMethodBeat.o(28001);
        return false;
    }

    static /* synthetic */ void dkP() {
        AppMethodBeat.i(28007);
        ab.i("MicroMsg.VoiceInputPanel", "pauseMusic");
        aw.ZL().KX();
        AppMethodBeat.o(28007);
    }

    static /* synthetic */ void w(n nVar) {
        AppMethodBeat.i(28008);
        if (!(nVar.vjx == null || nVar.vjx.getText() == null)) {
            String obj = nVar.vjx.getText().toString();
            if (obj.length() > 0 && (!nVar.vpa || nVar.vjx.getSelectionStart() >= obj.length())) {
                nVar.vpr = obj.substring(obj.length() - 1, obj.length());
                ab.i("MicroMsg.VoiceInputPanel", "delPunctuation msg = %s ,msg.length() = %s, punctuation = %s", bo.anv(obj), Integer.valueOf(obj.length()), nVar.vpr);
                if (nVar.vpr.equalsIgnoreCase("。") || nVar.vpr.equalsIgnoreCase(".")) {
                    nVar.vjx.setText(obj.substring(0, obj.length() - 1));
                }
            }
        }
        AppMethodBeat.o(28008);
    }

    static /* synthetic */ void Lm(int i) {
        AppMethodBeat.i(28010);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.fail = i;
        a(voiceInputBehavior);
        Lj(i);
        AppMethodBeat.o(28010);
    }

    static /* synthetic */ void y(n nVar) {
        AppMethodBeat.i(28011);
        if (!(nVar.vjx == null || nVar.vjx.getText() == null || nVar.vjx.getText().length() <= 0)) {
            if (nVar.vpr.equalsIgnoreCase("。") || nVar.vpr.equalsIgnoreCase(".")) {
                if (!nVar.vpa || nVar.vjx.getSelectionStart() >= nVar.vjx.getText().length()) {
                    nVar.vpt.a(nVar.vjx, nVar.vpr, true);
                    nVar.vpt.b(nVar.vjx);
                }
                nVar.vpr = "";
            }
            String obj = nVar.vjx.getText().toString();
            ab.i("MicroMsg.VoiceInputPanel", "addPunctuation msg = %s,msg.length() = %s", bo.anv(obj), Integer.valueOf(obj.length()));
        }
        AppMethodBeat.o(28011);
    }
}
