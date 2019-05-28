package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.l;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter extends InputPanelLinearLayout implements OnGlobalLayoutListener, com.tencent.mm.pluginsdk.ui.chat.h.a {
    private static int count = 0;
    private static final int[] gcc = new int[]{R.drawable.aab, R.drawable.aac, R.drawable.aad, R.drawable.aae, R.drawable.aaf, R.drawable.aag, R.drawable.aah};
    private static final int[] miN = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private Activity activity;
    public String cEV;
    private Context context;
    private int dj;
    public ChatFooterPanel eAk;
    private View gbS;
    private int jZk;
    private int jZl;
    public final ak mHandler;
    private boolean miB;
    public View miF;
    public View miG;
    private ImageView miH;
    public View miI;
    public View miJ;
    private final ak miO;
    public MMEditText oij;
    public Button oik;
    public o szb;
    private TextView szc;
    private ImageView szd;
    public View sze;
    public String toUser;
    private int ubu;
    f vhg;
    public n viY;
    public boolean vjb;
    private String vmL;
    public AppPanel vmM;
    public TextView vmN;
    private Button vmO;
    public ImageButton vmP;
    public ChatFooterBottom vmQ;
    private TextView vmR;
    public ImageButton vmS;
    public ImageButton vmT;
    public View vmU;
    private com.tencent.mm.ui.widget.a.c vmV;
    private i vmW;
    public m vmX;
    private b vmY;
    private e vmZ;
    private int vnA;
    private final int vnB;
    private final int vnC;
    private final int vnD;
    private final int vnE;
    private final int vnF;
    private final int vnG;
    private final int vnH;
    private final int vnI;
    private int vnJ;
    private int vnK;
    private int vnL;
    private boolean vnM;
    private final int vnN;
    private final int vnO;
    private volatile boolean vnP;
    private ak vnQ;
    private int vnR;
    private int vnS;
    private int vnT;
    private View vnU;
    public boolean vnV;
    private int vnW;
    public final a vna;
    public boolean vnb;
    private boolean vnc;
    private TextView vnd;
    private InputMethodManager vne;
    private int vnf;
    private boolean vng;
    private boolean vnh;
    public boolean vni;
    private boolean vnj;
    com.tencent.mm.g.b.a.b vnk;
    public c vnl;
    public d vnm;
    private com.tencent.mm.pluginsdk.ui.chat.m.a vnn;
    private boolean vno;
    public MMFragment vnp;
    public b vnq;
    private boolean vnr;
    private Animation vns;
    private Animation vnt;
    private com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a vnu;
    private com.tencent.mm.pluginsdk.ui.chat.AppPanel.b vnv;
    public f vnw;
    private int vnx;
    private com.tencent.mm.sdk.b.c vny;
    private boolean vnz;

    public static class a {
        public String voc;
        String vod;
        int voe;
        public HashMap<String, LinkedList<HashMap<String, String>>> vof;

        private a() {
            AppMethodBeat.i(27824);
            this.vof = new HashMap();
            AppMethodBeat.o(27824);
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface b {
        String getTalkerUserName();
    }

    public interface c {
        void a(Boolean bool, Boolean bool2);

        void b(Boolean bool, Boolean bool2);
    }

    public interface d {
        void i(Boolean bool);
    }

    public interface e {
        boolean oS(boolean z);
    }

    public class f implements TextWatcher {
        TextWatcher vog;
        private boolean voh = false;
        private boolean voi = com.tencent.mm.compatible.util.d.fP(11);

        public f(TextWatcher textWatcher) {
            AppMethodBeat.i(27825);
            this.vog = textWatcher;
            AppMethodBeat.o(27825);
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = true;
            AppMethodBeat.i(27826);
            if (ChatFooter.this.vnh && this.voh && editable.length() > 0) {
                this.voh = false;
                ChatFooter.this.oij.setText(editable.subSequence(0, editable.length() - 1));
                if (ChatFooter.this.oij.length() > 0) {
                    ChatFooter.this.oik.performClick();
                    ab.i("MicroMsg.ChatFooter", "enter button, do send");
                }
                ab.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
                AppMethodBeat.o(27826);
                return;
            }
            this.vog.afterTextChanged(editable);
            if (ChatFooter.this.vmN != null) {
                if (ChatFooter.this.oij.getLineCount() > 1) {
                    ChatFooter.this.vmN.setVisibility(0);
                    ChatFooter.this.vmN.setText(editable.length() + "/140");
                } else {
                    ChatFooter.this.vmN.setVisibility(8);
                }
            }
            if (editable.length() <= 0 || editable.toString().trim().length() <= 0) {
                z = false;
            }
            ChatFooter.b(ChatFooter.this, z);
            if (ChatFooter.this.eAk != null) {
                ChatFooter.this.eAk.setSendButtonEnable(z);
            }
            ab.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
            AppMethodBeat.o(27826);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(27827);
            this.vog.beforeTextChanged(charSequence, i, i2, i3);
            ab.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
            AppMethodBeat.o(27827);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(27828);
            if (ChatFooter.this.vnh && i2 == 0 && i == charSequence.length() - 1 && i3 == 1 && charSequence.charAt(charSequence.length() - 1) == 10) {
                ab.i("MicroMsg.ChatFooter", "text changed, enter button");
                this.voh = true;
                AppMethodBeat.o(27828);
                return;
            }
            this.vog.onTextChanged(charSequence, i, i2, i3);
            ChatFooter.this.vnk.cTu++;
            ChatFooter.this.vnk.Fm();
            if (ChatFooter.this.vnk.cTr == 0) {
                ChatFooter.this.vnk.Fl();
            }
            AppMethodBeat.o(27828);
        }
    }

    static /* synthetic */ void C(ChatFooter chatFooter) {
        AppMethodBeat.i(27931);
        chatFooter.Ld(R.drawable.iy);
        AppMethodBeat.o(27931);
    }

    static /* synthetic */ void E(ChatFooter chatFooter) {
        AppMethodBeat.i(27933);
        chatFooter.djq();
        AppMethodBeat.o(27933);
    }

    static /* synthetic */ int dkG() {
        int i = count;
        count = i + 1;
        return i;
    }

    static /* synthetic */ void e(ChatFooter chatFooter, boolean z) {
        AppMethodBeat.i(27934);
        chatFooter.oR(z);
        AppMethodBeat.o(27934);
    }

    static /* synthetic */ void l(ChatFooter chatFooter) {
        AppMethodBeat.i(27928);
        chatFooter.dka();
        AppMethodBeat.o(27928);
    }

    static /* synthetic */ void z(ChatFooter chatFooter) {
        AppMethodBeat.i(27930);
        chatFooter.dkC();
        AppMethodBeat.o(27930);
    }

    public final void dka() {
        AppMethodBeat.i(27829);
        if (this.vnk != null) {
            com.tencent.mm.g.b.a.b bVar = this.vnk;
            bVar.cTv = 0;
            bVar.cTt = 0;
            bVar.cTu = 0;
            bVar.cTw = 0;
            bVar.aM(0).aN(0);
        }
        AppMethodBeat.o(27829);
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooter(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(27830);
        this.gbS = null;
        this.oij = null;
        this.oik = null;
        this.vmN = null;
        this.vmZ = null;
        this.vna = new a();
        this.vnb = false;
        this.vnc = false;
        this.miB = false;
        this.vng = false;
        this.vnh = false;
        this.vni = false;
        this.vjb = false;
        this.vnj = true;
        this.jZk = -1;
        this.jZl = -1;
        this.vnk = new com.tencent.mm.g.b.a.b();
        this.vnn = new com.tencent.mm.pluginsdk.ui.chat.m.a() {
            public final void clear() {
                AppMethodBeat.i(27786);
                ChatFooter chatFooter = ChatFooter.this;
                if (chatFooter.oij != null) {
                    chatFooter.oij.setText("");
                    chatFooter.dka();
                }
                AppMethodBeat.o(27786);
            }
        };
        this.mHandler = new ak() {
            @SuppressLint({"NewApi"})
            @TargetApi(11)
            public final void handleMessage(Message message) {
                AppMethodBeat.i(27799);
                switch (message.what) {
                    case 1002:
                        if (!(ChatFooter.this.oij == null || message.obj == null)) {
                            boolean booleanValue = ((Boolean) message.obj).booleanValue();
                            if (booleanValue) {
                                ChatFooter.this.oij.setAlpha(1.0f);
                            } else {
                                ChatFooter.this.oij.setAlpha(0.5f);
                            }
                            ChatFooter.a(ChatFooter.this, booleanValue);
                            break;
                        }
                }
                AppMethodBeat.o(27799);
            }
        };
        this.vno = false;
        this.vnr = false;
        this.vnu = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void aYY() {
                AppMethodBeat.i(27795);
                ChatFooter.this.vnf = 1;
                ChatFooter.this.vmU.setVisibility(0);
                ChatFooter.this.vmO.setVisibility(8);
                ChatFooter.a(ChatFooter.this, true);
                ChatFooter.C(ChatFooter.this);
                if (ChatFooter.this.oik != null) {
                    ChatFooter.this.oik.performClick();
                }
                AppMethodBeat.o(27795);
            }

            public final void fC(boolean z) {
                AppMethodBeat.i(27796);
                if (ChatFooter.this.vmQ.getVisibility() == 0) {
                    ChatFooter.this.vnf = 1;
                    ChatFooter.this.vmU.setVisibility(0);
                    ChatFooter.this.vmO.setVisibility(8);
                    ChatFooter.C(ChatFooter.this);
                    if (ChatFooter.this.oij != null) {
                        ChatFooter.this.setToSendTextColor(z);
                    }
                }
                AppMethodBeat.o(27796);
            }

            public final void aRg() {
                AppMethodBeat.i(27797);
                ChatFooter.this.vnf = 1;
                ChatFooter.this.vmU.setVisibility(0);
                ChatFooter.this.vmO.setVisibility(8);
                ChatFooter.a(ChatFooter.this, true);
                ChatFooter.C(ChatFooter.this);
                ChatFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                ChatFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                ChatFooter.this.vnk.cTw--;
                AppMethodBeat.o(27797);
            }

            public final void append(String str) {
                AppMethodBeat.i(27798);
                ChatFooter.this.vnf = 1;
                ChatFooter.this.vmU.setVisibility(0);
                ChatFooter.this.vmO.setVisibility(8);
                ChatFooter.a(ChatFooter.this, true);
                ChatFooter.C(ChatFooter.this);
                try {
                    ChatFooter.this.oij.asB(str);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ChatFooter", e, "", new Object[0]);
                }
                ChatFooter.this.vnk.cTw++;
                AppMethodBeat.o(27798);
            }
        };
        this.vnv = new com.tencent.mm.pluginsdk.ui.chat.AppPanel.b() {
            public final void djW() {
                AppMethodBeat.i(27800);
                ab.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.this.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bo.dpG(), ChatFooter.this.activity);
                if (com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.this.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                    int acS = aw.Rg().acS();
                    if (acS == 4 || acS == 6) {
                        ChatFooter.D(ChatFooter.this);
                        AppMethodBeat.o(27800);
                        return;
                    }
                    if (ChatFooter.this.vmV == null || !ChatFooter.this.vmV.isShowing()) {
                        ChatFooter.this.vmV = h.g(ChatFooter.this.getContext(), R.string.f6c, R.string.tz);
                    }
                    AppMethodBeat.o(27800);
                    return;
                }
                AppMethodBeat.o(27800);
            }
        };
        this.miO = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(27804);
                super.handleMessage(message);
                if (ChatFooter.this.szb != null) {
                    ChatFooter.this.szb.dismiss();
                    ChatFooter.this.vmO.setBackgroundDrawable(com.tencent.mm.bz.a.g(ChatFooter.this.getContext(), R.drawable.a7m));
                    ChatFooter.this.vmO.setEnabled(true);
                }
                AppMethodBeat.o(27804);
            }
        };
        this.vnx = 0;
        this.vny = new com.tencent.mm.sdk.b.c<ny>() {
            {
                AppMethodBeat.i(27808);
                this.xxI = ny.class.getName().hashCode();
                AppMethodBeat.o(27808);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(27809);
                if (ChatFooter.this.mHandler != null) {
                    ChatFooter.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(27807);
                            ab.i("MicroMsg.ChatFooter", "reflesh smiley panel.");
                            ChatFooter.this.dkw();
                            AppMethodBeat.o(27807);
                        }
                    });
                }
                AppMethodBeat.o(27809);
                return false;
            }
        };
        this.vnz = false;
        this.vnA = 0;
        this.vnB = 0;
        this.vnC = 1;
        this.vnD = 2;
        this.vnE = 3;
        this.vnF = 20;
        this.vnG = 21;
        this.vnH = 22;
        this.vnI = 23;
        this.vnJ = 0;
        this.vnK = 0;
        this.vnL = -1;
        this.dj = -1;
        this.vnM = false;
        this.vnN = 4097;
        this.vnO = 4098;
        this.vnQ = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(27818);
                super.handleMessage(message);
                switch (message.what) {
                    case 4097:
                        ChatFooter.this.vnP = true;
                        LayoutParams layoutParams = ChatFooter.this.vmQ.getLayoutParams();
                        int bottom = ChatFooter.this.vmQ.getBottom() - ChatFooter.this.vmQ.getTop();
                        if (ChatFooter.this.dky()) {
                            if (ChatFooter.this.eAk != null) {
                                ChatFooter.this.eAk.setVisibility(8);
                            }
                            ChatFooter.this.setAppPanelVisible(8);
                            ChatFooter.this.vmQ.setVisibility(4);
                        }
                        if (bottom > 3) {
                            layoutParams.height = Math.max(bottom - 60, 1);
                            ab.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + layoutParams.height);
                            ChatFooter.this.vmQ.setLayoutParams(layoutParams);
                            ChatFooter.M(ChatFooter.this);
                            break;
                        }
                        ChatFooter.this.vnP = false;
                        ChatFooter.this.vmQ.setVisibility(8);
                        ChatFooter.c(ChatFooter.this, ChatFooter.this.getKeyBordHeightPX());
                        AppMethodBeat.o(27818);
                        return;
                }
                AppMethodBeat.o(27818);
            }
        };
        this.vnR = -1;
        this.vnS = -1;
        this.vnT = -1;
        this.vnU = null;
        this.vnV = true;
        this.vnW = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.vne = (InputMethodManager) context.getSystemService("input_method");
        this.gbS = inflate(context, R.layout.l_, this);
        this.oij = (MMEditText) this.gbS.findViewById(R.id.ami);
        if (ae.dzg()) {
            this.oij.setImeOptions(268435456);
        }
        com.tencent.mm.ui.tools.b.c.d(this.oij).PM(bo.getInt(g.Nu().getValue("InputLimitSessionTextMsg"), Utility.DEFAULT_STREAM_BUFFER_SIZE) * 2).a(null);
        this.oij.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        this.oij.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
            }
        });
        if (com.tencent.mm.compatible.util.d.iW(23)) {
            this.oij.setBreakStrategy(1);
        }
        nz nzVar = new nz();
        nzVar.cKo.cKq = this.oij;
        nzVar.cKo.cKp = new com.tencent.mm.pluginsdk.ui.a.a() {
            public final void ajv(final String str) {
                AppMethodBeat.i(27820);
                ab.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", str);
                if (bo.isNullOrNil(ChatFooter.this.vnq.getTalkerUserName()) || bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.ChatFooter", "onImageReceived, error args");
                    AppMethodBeat.o(27820);
                    return;
                }
                h.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(R.string.bj8), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        int i2 = 1;
                        AppMethodBeat.i(27819);
                        boolean g = r.g(str, ChatFooter.this.vnq.getTalkerUserName(), true);
                        ChatFooter chatFooter = ChatFooter.this;
                        if (!g) {
                            i2 = 0;
                        }
                        ChatFooter.a(chatFooter, i2, str);
                        AppMethodBeat.o(27819);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(27820);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(nzVar);
        this.vmU = this.gbS.findViewById(R.id.amh);
        this.vmQ = (ChatFooterBottom) findViewById(R.id.amq);
        this.vmS = (ImageButton) this.gbS.findViewById(R.id.amo);
        this.oik = (Button) this.gbS.findViewById(R.id.amp);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.oik.setTextSize(0, ((float) com.tencent.mm.bz.a.am(context, R.dimen.kr)) * com.tencent.mm.bz.a.fY(context));
        this.vmO = (Button) this.gbS.findViewById(R.id.amj);
        this.vmP = (ImageButton) findViewById(R.id.amg);
        iP(false);
        dkE();
        this.vmW = new i(getContext(), getRootView(), this, new com.tencent.mm.pluginsdk.ui.chat.i.a() {
            public final void ajI(String str) {
                AppMethodBeat.i(27821);
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                if (ChatFooter.this.cEV != null) {
                    intent.putExtra("GalleryUI_FromUser", ChatFooter.this.cEV);
                }
                if (ChatFooter.this.toUser != null) {
                    intent.putExtra("GalleryUI_ToUser", ChatFooter.this.toUser);
                }
                intent.putExtra("query_source_type", 3);
                intent.putExtra("preview_image", true);
                intent.putStringArrayListExtra("preview_image_list", arrayList);
                intent.putExtra("max_select_count", 1);
                intent.addFlags(67108864);
                if (ChatFooter.this.vnp != null) {
                    com.tencent.mm.bp.d.a(ChatFooter.this.vnp, "gallery", ".ui.GalleryEntryUI", intent, 217);
                    AppMethodBeat.o(27821);
                    return;
                }
                com.tencent.mm.bp.d.b(context, "gallery", ".ui.GalleryEntryUI", intent, 217);
                AppMethodBeat.o(27821);
            }
        });
        this.vmW.vov = this;
        Context context2 = getContext();
        getRootView();
        this.vmX = new m(context2);
        this.vmX.vnn = this.vnn;
        ab.d("MicroMsg.ChatFooter", "send edittext ime option %s", Integer.valueOf(this.oij.getImeOptions()));
        this.oij.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(27822);
                if (i == 4 || (i == 0 && ChatFooter.this.vnh)) {
                    ChatFooter.this.oik.performClick();
                    AppMethodBeat.o(27822);
                    return true;
                }
                AppMethodBeat.o(27822);
                return false;
            }
        });
        this.oij.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(27823);
                ChatFooter.this.setToSendTextColor(true);
                ChatFooter.a(ChatFooter.this, 3);
                if (ChatFooter.this.vmY != null) {
                    ChatFooter.this.vmY.I(motionEvent);
                }
                ChatFooter.j(ChatFooter.this);
                AppMethodBeat.o(27823);
                return false;
            }
        });
        this.oij.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(27787);
                CharSequence dhS = com.tencent.mm.pluginsdk.f.a.dhS();
                com.tencent.mm.plugin.report.service.h.pYm.k(1014, 0, 1);
                com.tencent.mm.plugin.c.a.ask();
                if (com.tencent.mm.plugin.c.a.x(dhS)) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(1014, 1, 1);
                    ab.i("MicroMsg.ChatFooter", "anti paste text %s", dhS);
                    AppMethodBeat.o(27787);
                    return true;
                }
                AppMethodBeat.o(27787);
                return false;
            }
        });
        this.oij.setCustomSelectionActionModeCallback(new Callback() {
            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                AppMethodBeat.i(27788);
                CharSequence dhS = com.tencent.mm.pluginsdk.f.a.dhS();
                com.tencent.mm.plugin.report.service.h.pYm.k(1014, 5, 1);
                com.tencent.mm.plugin.c.a.ask();
                if (com.tencent.mm.plugin.c.a.x(dhS)) {
                    ab.i("MicroMsg.ChatFooter", "anti paste text %s", dhS);
                    com.tencent.mm.plugin.report.service.h.pYm.k(1014, 6, 1);
                    if (menu.size() > 0) {
                        menu.removeItem(16908322);
                        if (com.tencent.mm.compatible.util.d.iW(23)) {
                            menu.removeItem(16908340);
                        }
                    }
                }
                AppMethodBeat.o(27788);
                return true;
            }

            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public final void onDestroyActionMode(ActionMode actionMode) {
            }
        });
        this.oik.setOnClickListener(new View.OnClickListener() {
            public final synchronized void onClick(View view) {
                AppMethodBeat.i(27789);
                String obj = ChatFooter.this.oij.getText().toString();
                ab.i("MicroMsg.ChatFooter", "send msg onClick");
                if (obj.trim().length() != 0 || obj.length() == 0) {
                    ChatFooter.b(ChatFooter.this, obj.length());
                    if (ChatFooter.this.vmY != null && ChatFooter.this.vmY.Qu(obj)) {
                        ChatFooter.this.oij.clearComposingText();
                        ChatFooter.this.oij.setText("");
                        ChatFooter.l(ChatFooter.this);
                    }
                    AppMethodBeat.o(27789);
                } else {
                    ab.d("MicroMsg.ChatFooter", "empty message cant be sent");
                    if (ChatFooter.this.vmV == null || !ChatFooter.this.vmV.isShowing()) {
                        ChatFooter.this.vmV = h.g(ChatFooter.this.getContext(), R.string.akg, R.string.tz);
                        AppMethodBeat.o(27789);
                    }
                    AppMethodBeat.o(27789);
                }
            }
        });
        this.vmO.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(27793);
                if (view != ChatFooter.this.vmO) {
                    AppMethodBeat.o(27793);
                } else {
                    ab.v("RcdBtnEvent", "event.getAction():" + motionEvent.getAction());
                    switch (motionEvent.getAction()) {
                        case 0:
                            ab.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", Integer.valueOf(ChatFooter.count));
                            if (ChatFooter.this.context instanceof Activity) {
                                ((Activity) ChatFooter.this.context).getWindow().addFlags(128);
                            }
                            if (!(ChatFooter.this.miB || ChatFooter.this.vng)) {
                                ChatFooter.this.miB = true;
                                ChatFooter.this.vmO.setBackgroundDrawable(com.tencent.mm.bz.a.g(ChatFooter.this.getContext(), R.drawable.yg));
                                ChatFooter.this.vmO.setText(R.string.ajm);
                                if (ChatFooter.this.vmY != null) {
                                    ChatFooter.this.vmY.bNJ();
                                }
                                ChatFooter.this.vmO.setContentDescription(ChatFooter.this.getContext().getString(R.string.aiy));
                                break;
                            }
                        case 1:
                        case 3:
                            if (ChatFooter.this.context instanceof Activity) {
                                ((Activity) ChatFooter.this.context).getWindow().clearFlags(128);
                            }
                            ab.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.count));
                            ChatFooter.z(ChatFooter.this);
                            ab.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.dkG()));
                            break;
                        case 2:
                            if (ChatFooter.this.miI == null || ChatFooter.this.miJ == null) {
                                ab.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", ChatFooter.this.miI, ChatFooter.this.miJ);
                            }
                            if (motionEvent.getX() > 0.0f && motionEvent.getY() > ((float) ((-ChatFooter.this.vnx) / 2)) && motionEvent.getX() < ((float) ChatFooter.this.vmO.getWidth())) {
                                if (ChatFooter.this.miI != null) {
                                    ChatFooter.this.miI.setVisibility(0);
                                }
                                if (ChatFooter.this.miJ != null) {
                                    ChatFooter.this.vmO.setText(R.string.ajm);
                                    ChatFooter.this.miJ.setVisibility(8);
                                    break;
                                }
                            }
                            ab.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(ChatFooter.this.vnx), Integer.valueOf(ChatFooter.this.vmO.getWidth()), Integer.valueOf(ChatFooter.this.vmO.getHeight()));
                            if (ChatFooter.this.miI != null) {
                                ChatFooter.this.miI.setVisibility(8);
                            }
                            if (ChatFooter.this.miJ != null) {
                                ChatFooter.this.vmO.setText(R.string.aj7);
                                ChatFooter.this.miJ.setVisibility(0);
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(27793);
                }
                return false;
            }
        });
        this.vmO.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(27794);
                switch (keyEvent.getAction()) {
                    case 0:
                        if (!((i != 23 && i != 66) || ChatFooter.this.vng || ChatFooter.this.miB)) {
                            ChatFooter.this.vng = true;
                            ChatFooter.this.vmO.setBackgroundDrawable(com.tencent.mm.bz.a.g(ChatFooter.this.getContext(), R.drawable.yg));
                            ChatFooter.this.vmO.setText(R.string.ajm);
                            if (ChatFooter.this.vmY != null) {
                                ChatFooter.this.vmY.bNJ();
                            }
                            ChatFooter.this.vmO.setContentDescription(ChatFooter.this.getContext().getString(R.string.aiy));
                            break;
                        }
                    case 1:
                        if (i == 23 || i == 66) {
                            ChatFooter.this.vmO.setBackgroundDrawable(com.tencent.mm.bz.a.g(ChatFooter.this.getContext(), R.drawable.a7m));
                            ChatFooter.this.vmO.setText(R.string.ajl);
                            if (ChatFooter.this.vmY != null) {
                                ChatFooter.this.vmY.bNG();
                            }
                            ChatFooter.this.vng = false;
                            break;
                        }
                }
                AppMethodBeat.o(27794);
                return false;
            }
        });
        this.vmP.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27792);
                ChatFooter.r(ChatFooter.this);
                AppMethodBeat.o(27792);
            }
        });
        dkg();
        this.vmS.setVisibility(0);
        this.vmS.setContentDescription(getContext().getString(R.string.air));
        this.vmS.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27790);
                ChatFooter.this.dkc();
                if (r.Zf().booleanValue() && ChatFooter.this.vnl != null) {
                    c cVar = ChatFooter.this.vnl;
                    Boolean bool = Boolean.TRUE;
                    cVar.a(bool, bool);
                }
                AppMethodBeat.o(27790);
            }
        });
        ab.i("MicroMsg.ChatFooter", "[init]");
        Lh(-1);
        findViewById(R.id.amc).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        ab.d("MicroMsg.ChatFooter", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(27830);
    }

    public final void a(Context context, Activity activity) {
        AppMethodBeat.i(27831);
        this.activity = activity;
        dkE();
        if (an.dhQ().vdc) {
            an.dhQ().fL(ah.getContext());
        }
        if (!(this.vmQ.dkH() || this.eAk == null)) {
            this.eAk.onResume();
        }
        if (!this.vno && this.vnh) {
            dkv();
        } else if (this.vno && !this.vnh) {
            dkt();
        }
        if (x.gu(context) != this.vnj) {
            djS();
        }
        if (this.vmM != null) {
            this.vmM.context = context;
        }
        this.context = context;
        this.vmW.vou = false;
        if (!this.vjb) {
            dku();
            this.oij.setVisibility(0);
        }
        dkd();
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27813);
                j.r(ChatFooter.this.activity);
                AppMethodBeat.o(27813);
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.vny);
        AppMethodBeat.o(27831);
    }

    public void setFooterType(int i) {
        AppMethodBeat.i(27832);
        this.ubu = i;
        if (this.eAk != null) {
            this.eAk.setFooterType(i);
        }
        AppMethodBeat.o(27832);
    }

    public final void onPause() {
        AppMethodBeat.i(27833);
        this.vnr = true;
        if (this.eAk != null) {
            this.eAk.onPause();
        }
        if (this.vjb && this.viY != null) {
            this.viY.pause();
        }
        if (this.vmY != null) {
            this.vmY.onPause();
        }
        if (this.vmX != null) {
            this.vmX.hide();
        }
        this.vnV = false;
        com.tencent.mm.sdk.b.a.xxA.d(this.vny);
        AppMethodBeat.o(27833);
    }

    public void setTipsShowCallback(c cVar) {
        this.vnl = cVar;
    }

    public void setVoiceInputShowCallback(d dVar) {
        this.vnm = dVar;
    }

    public final void destroy() {
        AppMethodBeat.i(27834);
        if (this.eAk != null) {
            ab.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
            this.eAk.AC();
            this.eAk.destroy();
            this.eAk = null;
        }
        if (this.viY != null) {
            this.viY.destroy();
            this.viY = null;
            this.vjb = false;
        }
        if (this.vmY != null) {
            this.vmY.release();
        }
        if (this.vmX != null) {
            this.vmX.vnn = null;
            this.vmX.voG = null;
            this.vmX.hide();
        }
        ab.d("MicroMsg.ChatFooter", "jacks destroy");
        AppMethodBeat.o(27834);
    }

    public final void dkb() {
        AppMethodBeat.i(27835);
        if (this.vmM == null) {
            AppMethodBeat.o(27835);
            return;
        }
        this.vmM.djI();
        AppMethodBeat.o(27835);
    }

    private void iP(boolean z) {
        AppMethodBeat.i(27836);
        if (this.vns == null) {
            this.vns = AnimationUtils.loadAnimation(getContext(), R.anim.c4);
            this.vns.setDuration(150);
        }
        if (this.vnt == null) {
            this.vnt = AnimationUtils.loadAnimation(getContext(), R.anim.c9);
            this.vnt.setDuration(150);
        }
        if (this.oik == null || this.vmS == null) {
            AppMethodBeat.o(27836);
        } else if (this.vno) {
            if (this.vmS.getVisibility() != 0) {
                this.vmS.setVisibility(0);
            }
            AppMethodBeat.o(27836);
        } else if (this.oik.getVisibility() == 0 && z) {
            AppMethodBeat.o(27836);
        } else if (this.vmS.getVisibility() != 0 || z) {
            if (z) {
                this.oik.startAnimation(this.vns);
                this.oik.setVisibility(0);
                this.vmS.startAnimation(this.vnt);
                this.vmS.setVisibility(8);
            } else {
                this.vmS.startAnimation(this.vns);
                if (!this.vnc) {
                    this.vmS.setVisibility(0);
                }
                this.oik.startAnimation(this.vnt);
                this.oik.setVisibility(8);
            }
            ab.i("MicroMsg.ChatFooter", "jacks canSend:%B", Boolean.valueOf(z));
            this.oik.getParent().requestLayout();
            AppMethodBeat.o(27836);
        } else {
            AppMethodBeat.o(27836);
        }
    }

    public int getBarGroupHeight() {
        AppMethodBeat.i(27837);
        int height = findViewById(R.id.amc).getHeight();
        AppMethodBeat.o(27837);
        return height;
    }

    public final void dkc() {
        AppMethodBeat.i(27838);
        if (this.vmY != null) {
            this.vmY.bNL();
        }
        ab.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", Integer.valueOf(this.vmM.getVisibility()), Boolean.valueOf(this.vmQ.dkH()));
        if (this.vmM.getVisibility() != 0 || this.vmQ.dkH()) {
            u(2, 22, true);
            if (this.viY != null && this.viY.getVisibility() == 0 && this.vjb) {
                ab.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.viY.setVisibility(8);
                this.vjb = false;
                this.viY.reset();
            }
            an dhQ = an.dhQ();
            Context context = ah.getContext();
            if (com.tencent.mm.kernel.g.RK() && context != null) {
                try {
                    String value = g.Nu().getValue("ShowAPPSuggestion");
                    if (bo.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                        ab.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", value);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", e.getMessage());
                }
                if (dhQ.vcW) {
                    ab.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    ab.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    dhQ.vcW = true;
                    if (System.currentTimeMillis() - dhQ.vcZ < 43200000) {
                        ab.d("MicroMsg.SuggestionAppListLogic", "not now");
                        dhQ.vcW = false;
                    } else {
                        com.tencent.mm.kernel.g.RQ();
                        dhQ.vcZ = com.tencent.mm.kernel.g.RP().Ry().Mm(352275);
                        if (System.currentTimeMillis() - dhQ.vcZ < 43200000) {
                            ab.w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            dhQ.vcW = false;
                        } else {
                            if (dhQ.lang == null) {
                                dhQ.lang = aa.g(context.getSharedPreferences(ah.doA(), 0));
                            }
                            com.tencent.mm.pluginsdk.model.app.x aeVar = new com.tencent.mm.pluginsdk.model.app.ae(dhQ.lang, new LinkedList());
                            com.tencent.mm.plugin.s.a.bYM();
                            com.tencent.mm.pluginsdk.model.app.d.a(4, aeVar);
                        }
                    }
                }
            }
            an.dhQ().fL(ah.getContext());
            AppMethodBeat.o(27838);
        } else if (this.vnf == 1) {
            showVKB();
            AppMethodBeat.o(27838);
        } else {
            u(0, -1, false);
            AppMethodBeat.o(27838);
        }
    }

    public final void dkd() {
        AppMethodBeat.i(27839);
        this.vmT = (ImageButton) this.gbS.findViewById(R.id.amk);
        this.vmT.setVisibility(0);
        if (com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, false)) {
            this.gbS.findViewById(R.id.aml).setVisibility(8);
        } else {
            this.gbS.findViewById(R.id.aml).setVisibility(0);
        }
        this.vmT.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27791);
                if (ChatFooter.this.vmY != null) {
                    ChatFooter.this.vmY.bNK();
                }
                if (ChatFooter.this.vmQ.dkH() || ChatFooter.this.eAk == null || ChatFooter.this.eAk.getVisibility() != 0) {
                    if (ChatFooter.this.vnc) {
                        ChatFooter.this.AD();
                    }
                    ChatFooter.this.dkh();
                    if (!com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, false)) {
                        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, Boolean.TRUE);
                        ChatFooter.this.gbS.findViewById(R.id.aml).setVisibility(8);
                    }
                    AppMethodBeat.o(27791);
                    return;
                }
                ChatFooter.this.showVKB();
                AppMethodBeat.o(27791);
            }
        });
        if (this.vmX != null) {
            this.vmX.voF = this.vmT;
        }
        AppMethodBeat.o(27839);
    }

    public final void oP(boolean z) {
        AppMethodBeat.i(27840);
        if (this.oij == null) {
            AppMethodBeat.o(27840);
        } else if (z) {
            this.oij.requestFocus();
            AppMethodBeat.o(27840);
        } else {
            this.oij.clearFocus();
            AppMethodBeat.o(27840);
        }
    }

    public final void dke() {
        boolean z = true;
        AppMethodBeat.i(27841);
        dkf();
        if (e.vom != null && this.context != null) {
            if (this.eAk != null) {
                this.eAk.destroy();
            }
            this.eAk = e.vom.dF(this.context);
            if (this.eAk != null) {
                this.eAk.setEntranceScene(ChatFooterPanel.vhi);
                if (this.eAk != null) {
                    this.eAk.setVisibility(8);
                }
                if (this.eAk != null) {
                    this.eAk.setFooterType(this.ubu);
                }
                if (this.vmQ != null) {
                    this.vmQ.addView(this.eAk, -1, -2);
                }
                if (this.eAk != null) {
                    this.eAk.setOnTextOperationListener(this.vnu);
                }
                if (this.eAk != null) {
                    ChatFooterPanel chatFooterPanel = this.eAk;
                    if (this.oij.getText().length() <= 0) {
                        z = false;
                    }
                    chatFooterPanel.setSendButtonEnable(z);
                }
                if (this.eAk != null) {
                    if (this.vnq != null) {
                        this.eAk.setTalkerName(this.vnq.getTalkerUserName());
                    }
                    this.eAk.setPortHeightPx(getKeyBordHeightPX());
                    this.eAk.AG();
                    if (!bo.isNullOrNil(this.oij.getText().toString())) {
                        this.eAk.AF();
                    }
                }
                if (this.vni) {
                    AD();
                }
                setSmileyPanelCallback(this.vhg);
            }
            AppMethodBeat.o(27841);
        } else if (this.context == null) {
            ab.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", bo.dpG());
            this.eAk = new d(ah.getContext());
            AppMethodBeat.o(27841);
        } else {
            this.eAk = new d(this.context);
            AppMethodBeat.o(27841);
        }
    }

    public final void dkf() {
        boolean z = true;
        AppMethodBeat.i(27842);
        if (this.context == null) {
            String str = "MicroMsg.ChatFooter";
            String str2 = "[initSmiley] activity = null? %s";
            Object[] objArr = new Object[1];
            if (this.activity != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.e(str, str2, objArr);
            if (this.activity != null) {
                this.context = this.activity.getBaseContext();
                AppMethodBeat.o(27842);
                return;
            }
            this.context = getContext();
        }
        AppMethodBeat.o(27842);
    }

    public final void AD() {
        AppMethodBeat.i(27843);
        this.vni = true;
        if (this.eAk != null) {
            this.eAk.AD();
        }
        AppMethodBeat.o(27843);
    }

    public void setFooterEventListener(b bVar) {
        this.vmY = bVar;
    }

    public void setSmileyPanelCallback(f fVar) {
        AppMethodBeat.i(27844);
        this.vhg = fVar;
        if (this.eAk != null) {
            this.eAk.setCallback(fVar);
        }
        AppMethodBeat.o(27844);
    }

    public f getCallback() {
        return this.vhg;
    }

    public void setSmileyPanelCallback2(j jVar) {
        this.vmX.voG = jVar;
    }

    private void Ld(int i) {
        AppMethodBeat.i(27845);
        if (this.vmP == null) {
            AppMethodBeat.o(27845);
            return;
        }
        int i2;
        if (i == R.drawable.iy) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.vmP != null) {
            if (i2 != 0) {
                this.vmP.setContentDescription(getContext().getString(R.string.aix));
            } else {
                this.vmP.setContentDescription(getContext().getString(R.string.aiw));
            }
        }
        this.vmP.setImageResource(i);
        this.vmP.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(27845);
    }

    private void dkg() {
        AppMethodBeat.i(27846);
        String talkerUserName = this.vnq == null ? this.vmL : this.vnq.getTalkerUserName();
        this.vmM = (AppPanel) findViewById(R.id.amr);
        this.vmM.setOnSwitchPanelListener(this.vnv);
        this.vmM.setPortHeighPx(x.gs(this.context));
        if (t.nI(talkerUserName) || t.nB(talkerUserName)) {
            this.vmM.init(0);
        } else if (t.mZ(talkerUserName)) {
            this.vmM.init(4);
        } else if (t.kH(talkerUserName)) {
            this.vmM.init(2);
        } else {
            this.vmM.init(1);
        }
        this.vmR = (TextView) findViewById(R.id.ams);
        AppMethodBeat.o(27846);
    }

    public void setAppPanelTip(CharSequence charSequence) {
        AppMethodBeat.i(27847);
        if (this.vmR == null || this.vmM == null) {
            AppMethodBeat.o(27847);
            return;
        }
        this.vmR.setText(charSequence);
        if (!bo.ac(charSequence)) {
            setAppPanelTipVisible(this.vmM.getVisibility() == 0);
        }
        AppMethodBeat.o(27847);
    }

    public void setAppPanelTipVisible(boolean z) {
        AppMethodBeat.i(27848);
        if (this.vmR == null) {
            AppMethodBeat.o(27848);
        } else if (TextUtils.isEmpty(this.vmR.getText())) {
            this.vmR.setVisibility(8);
            AppMethodBeat.o(27848);
        } else {
            int i;
            if (z) {
                Context context = this.vmR.getContext();
                this.vmM.getPageMaxRowCount();
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 32);
                LayoutParams layoutParams = this.vmR.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    ((MarginLayoutParams) layoutParams).bottomMargin = fromDPToPix;
                }
            }
            TextView textView = this.vmR;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            AppMethodBeat.o(27848);
        }
    }

    public final void dkh() {
        AppMethodBeat.i(27849);
        this.vnf = 1;
        this.vmU.setVisibility(0);
        this.vmO.setVisibility(8);
        Ld(R.drawable.iy);
        if (this.viY != null) {
            this.viY.setVisibility(8);
            this.vjb = false;
            this.viY.reset();
        }
        u(2, 21, true);
        AppMethodBeat.o(27849);
    }

    public void setDefaultSmileyByDetail(String str) {
        AppMethodBeat.i(27850);
        if (!bo.isNullOrNil(str)) {
            if (this.eAk == null) {
                dke();
            }
            this.eAk.setDefaultEmojiByDetail(str);
        }
        AppMethodBeat.o(27850);
    }

    private void djq() {
        AppMethodBeat.i(27851);
        if (this.vjb) {
            View findViewById = findViewById(R.id.amc);
            this.vjb = false;
            if (this.viY != null) {
                this.viY.destroy();
                this.viY.setVisibility(8);
            }
            findViewById.setVisibility(0);
            this.oij.setVisibility(0);
            this.oij.setText("");
            oP(true);
            dkd();
            u(0, -1, false);
            AppMethodBeat.o(27851);
            return;
        }
        AppMethodBeat.o(27851);
    }

    public void setAtSomebody(String str) {
        this.vna.vod = str;
    }

    public void setLastContent(String str) {
        this.vna.voc = str;
    }

    public final void ax(String str, String str2, String str3) {
        LinkedList linkedList;
        AppMethodBeat.i(27852);
        if (this.vna.vof.containsKey(str)) {
            linkedList = (LinkedList) this.vna.vof.get(str);
        } else {
            linkedList = new LinkedList();
            this.vna.vof.put(str, linkedList);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(str3, str2);
        linkedList.add(hashMap);
        AppMethodBeat.o(27852);
    }

    public void setInsertPos(int i) {
        this.vna.voe = i;
    }

    public String getAtSomebody() {
        return this.vna.vod;
    }

    public final HashMap<String, String> hJ(String str, String str2) {
        AppMethodBeat.i(27853);
        long currentTimeMillis = System.currentTimeMillis();
        if (bo.isNullOrNil(str2)) {
            if (this.vna.vof.containsKey(str)) {
                this.vna.vof.remove(str);
            }
            AppMethodBeat.o(27853);
            return null;
        } else if (!this.vna.vof.containsKey(str) || ((LinkedList) this.vna.vof.get(str)).size() <= 0) {
            AppMethodBeat.o(27853);
            return null;
        } else {
            LinkedList<String> linkedList = new LinkedList();
            int i = 0;
            while (i < str2.length()) {
                i = str2.indexOf("@", i);
                if (i == -1) {
                    break;
                }
                int indexOf = str2.indexOf(8197, i);
                if (indexOf == -1 || indexOf - i > 40) {
                    break;
                }
                linkedList.add(str2.substring(i + 1, indexOf));
                i = indexOf + 1;
            }
            ab.i("MicroMsg.ChatFooter", "after split @ :%s", linkedList);
            if (linkedList.size() <= 0) {
                ((LinkedList) this.vna.vof.get(str)).clear();
                AppMethodBeat.o(27853);
                return null;
            }
            LinkedList linkedList2 = (LinkedList) this.vna.vof.get(str);
            if (linkedList2 == null || linkedList2.size() <= 0) {
                ab.w("MicroMsg.ChatFooter", "list is null or size 0");
                AppMethodBeat.o(27853);
                return null;
            }
            ab.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", Integer.valueOf(linkedList2.size()));
            List linkedList3 = new LinkedList();
            for (String str3 : linkedList) {
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    HashMap hashMap = (HashMap) it.next();
                    if (hashMap.containsKey(str3)) {
                        linkedList3.add(hashMap.get(str3));
                        break;
                    }
                }
            }
            HashMap<String, String> hashMap2 = new HashMap(1);
            ab.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", Integer.valueOf(linkedList3.size()));
            hashMap2.put("atuserlist", "<![CDATA[" + bo.c(linkedList3, ",") + "]]>");
            linkedList2.clear();
            ab.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(27853);
            return hashMap2;
        }
    }

    public String getLastContent() {
        return this.vna.voc;
    }

    public int getInsertPos() {
        return this.vna.voe;
    }

    public final void u(String str, int i, boolean z) {
        AppMethodBeat.i(27855);
        if (z && (str == null || str.length() == 0 || this.oij == null)) {
            this.oij.setText("");
            dka();
            AppMethodBeat.o(27855);
            return;
        }
        this.vnb = true;
        this.oij.setText(com.tencent.mm.pluginsdk.ui.e.j.b(getContext(), (CharSequence) str, this.oij.getTextSize()));
        this.vnb = false;
        if (i < 0 || i > this.oij.getText().length()) {
            this.oij.setSelection(this.oij.getText().length());
            AppMethodBeat.o(27855);
            return;
        }
        this.oij.setSelection(i);
        AppMethodBeat.o(27855);
    }

    public void setHint(String str) {
        AppMethodBeat.i(27856);
        if (this.oij != null) {
            this.oij.setHint(str);
        }
        AppMethodBeat.o(27856);
    }

    public final void ddN() {
        AppMethodBeat.i(27857);
        this.vmO.setEnabled(false);
        this.vmO.setBackgroundDrawable(com.tencent.mm.bz.a.g(getContext(), R.drawable.ye));
        if (this.szb != null) {
            this.miG.setVisibility(0);
            this.miF.setVisibility(8);
            this.sze.setVisibility(8);
            this.szb.update();
        }
        this.miO.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.o(27857);
    }

    public String getLastText() {
        AppMethodBeat.i(27858);
        String str;
        if (this.oij == null) {
            str = "";
            AppMethodBeat.o(27858);
            return str;
        }
        str = this.oij.getText().toString();
        AppMethodBeat.o(27858);
        return str;
    }

    public int getSelectionStart() {
        AppMethodBeat.i(27859);
        int selectionStart = this.oij.getSelectionStart();
        AppMethodBeat.o(27859);
        return selectionStart;
    }

    public char getCharAtCursor() {
        AppMethodBeat.i(27860);
        int selectionStart = getSelectionStart();
        if (selectionStart <= 0) {
            AppMethodBeat.o(27860);
            return 'x';
        }
        char charAt = getLastText().charAt(selectionStart - 1);
        AppMethodBeat.o(27860);
        return charAt;
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(27861);
        this.vnw = new f(textWatcher);
        this.oij.addTextChangedListener(this.vnw);
        AppMethodBeat.o(27861);
    }

    public final void Le(int i) {
        AppMethodBeat.i(27862);
        this.vnx = 0;
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), 180);
        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(getContext(), 50.0f);
        if (i + b < fromDPToPix) {
            this.vnx = -1;
        } else {
            this.vnx = ((i - fromDPToPix) / 2) + b;
        }
        if (this.szb == null) {
            this.szb = new o(View.inflate(getContext(), R.layout.b27, null), -1, -2);
            this.miH = (ImageView) this.szb.getContentView().findViewById(R.id.br_);
            this.miI = this.szb.getContentView().findViewById(R.id.br8);
            this.miJ = this.szb.getContentView().findViewById(R.id.brb);
            this.szc = (TextView) this.szb.getContentView().findViewById(R.id.brd);
            this.szd = (ImageView) this.szb.getContentView().findViewById(R.id.brc);
            this.sze = this.szb.getContentView().findViewById(R.id.f29);
            this.miF = this.szb.getContentView().findViewById(R.id.br7);
            this.miG = this.szb.getContentView().findViewById(R.id.bre);
            this.vnd = (TextView) this.szb.getContentView().findViewById(R.id.f28);
        }
        if (this.vnx != -1) {
            this.miG.setVisibility(8);
            this.miF.setVisibility(8);
            this.sze.setVisibility(0);
            new ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27805);
                    ChatFooter.this.miI.setVisibility(0);
                    AppMethodBeat.o(27805);
                }
            });
            this.szb.showAtLocation(this, 49, 0, this.vnx);
        }
        AppMethodBeat.o(27862);
    }

    public void setRecordNormalWording(String str) {
        AppMethodBeat.i(27863);
        if (str == null || this.vnd == null) {
            AppMethodBeat.o(27863);
            return;
        }
        this.vnd.setText(str);
        AppMethodBeat.o(27863);
    }

    public final void dki() {
        AppMethodBeat.i(27864);
        this.sze.setVisibility(8);
        this.miF.setVisibility(0);
        AppMethodBeat.o(27864);
    }

    public final void bvH() {
        AppMethodBeat.i(27865);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27806);
                if (ChatFooter.this.szb != null) {
                    ChatFooter.this.szb.dismiss();
                    ChatFooter.this.miF.setVisibility(0);
                    ChatFooter.this.sze.setVisibility(8);
                    ChatFooter.this.miG.setVisibility(8);
                    ChatFooter.this.miJ.setVisibility(8);
                    ChatFooter.this.miI.setVisibility(0);
                }
                ChatFooter.this.vmO.setBackgroundDrawable(com.tencent.mm.bz.a.g(ChatFooter.this.getContext(), R.drawable.a7m));
                ChatFooter.this.vmO.setText(R.string.ajl);
                ChatFooter.this.vng = false;
                ChatFooter.this.miB = false;
                AppMethodBeat.o(27806);
            }
        });
        AppMethodBeat.o(27865);
    }

    public final void Lf(int i) {
        AppMethodBeat.i(27866);
        int i2 = 0;
        while (i2 < gcc.length) {
            if (i >= miN[i2] && i < miN[i2 + 1]) {
                this.miH.setBackgroundDrawable(com.tencent.mm.bz.a.g(getContext(), gcc[i2]));
                break;
            }
            i2++;
        }
        if (i == -1 && this.szb != null) {
            this.szb.dismiss();
            this.sze.setVisibility(0);
            this.miF.setVisibility(8);
            this.miG.setVisibility(8);
        }
        AppMethodBeat.o(27866);
    }

    public void setMode(int i) {
        AppMethodBeat.i(27867);
        az(i, true);
        AppMethodBeat.o(27867);
    }

    private void Lg(int i) {
        AppMethodBeat.i(27868);
        this.vnf = i;
        switch (i) {
            case 1:
                this.vmU.setVisibility(0);
                this.vmO.setVisibility(8);
                Ld(R.drawable.iy);
                AppMethodBeat.o(27868);
                return;
            case 2:
                this.vmU.setVisibility(8);
                this.vmO.setVisibility(0);
                Ld(R.drawable.ix);
                if (r.Zf().booleanValue() && this.vnl != null) {
                    c cVar = this.vnl;
                    Boolean bool = Boolean.TRUE;
                    cVar.b(bool, bool);
                    break;
                }
        }
        AppMethodBeat.o(27868);
    }

    public final void az(int i, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(27869);
        Lg(i);
        switch (i) {
            case 1:
                oP(true);
                if (z) {
                    showVKB();
                    if (this.oij.length() <= 0) {
                        z2 = false;
                    }
                    iP(z2);
                    AppMethodBeat.o(27869);
                    return;
                }
                if (this.oij.length() <= 0) {
                    z2 = false;
                }
                iP(z2);
                AppMethodBeat.o(27869);
                return;
            case 2:
                u(0, -1, false);
                iP(false);
                AppMethodBeat.o(27869);
                return;
            default:
                setVisibility(0);
                AppMethodBeat.o(27869);
                return;
        }
    }

    public final void dkj() {
        AppMethodBeat.i(27870);
        this.vmU.setVisibility(0);
        this.vmP.setVisibility(8);
        this.vmO.setVisibility(8);
        AppMethodBeat.o(27870);
    }

    public final void dkk() {
        AppMethodBeat.i(27871);
        if (this.vmP != null) {
            this.vmP.setVisibility(0);
        }
        AppMethodBeat.o(27871);
    }

    public final void dkl() {
        AppMethodBeat.i(27872);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vml.value = false;
        appPanel.djQ();
        AppMethodBeat.o(27872);
    }

    public final void dkm() {
        AppMethodBeat.i(27873);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vmD.value = false;
        appPanel.djQ();
        AppMethodBeat.o(27873);
    }

    public final void dkn() {
        AppMethodBeat.i(27874);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vmm.value = false;
        appPanel.djQ();
        AppMethodBeat.o(27874);
    }

    public final void dko() {
        AppMethodBeat.i(27875);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vmp.value = false;
        appPanel.djQ();
        AppMethodBeat.o(27875);
    }

    public final void ac(boolean z, boolean z2) {
        AppMethodBeat.i(27876);
        this.vmM.oF(z);
        this.vmM.oG(z2);
        AppMethodBeat.o(27876);
    }

    public final void oH(boolean z) {
        AppMethodBeat.i(27877);
        this.vmM.oH(z);
        AppMethodBeat.o(27877);
    }

    public final void oI(boolean z) {
        AppMethodBeat.i(27878);
        this.vmM.oI(z);
        AppMethodBeat.o(27878);
    }

    public final void dkp() {
        AppMethodBeat.i(27879);
        AppPanel appPanel = this.vmM;
        appPanel.vlX = true;
        appPanel.vlP.oN(false);
        appPanel.djQ();
        ab.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", bo.dpG().toString());
        AppMethodBeat.o(27879);
    }

    public final void dkq() {
        AppMethodBeat.i(27880);
        AppPanel appPanel = this.vmM;
        appPanel.vlY = true;
        appPanel.vlP.oK(false);
        appPanel.djQ();
        ab.i("MicroMsg.AppPanel", "disableServiceRemittance %s", bo.dpG().toString());
        AppMethodBeat.o(27880);
    }

    public final void dkr() {
        AppMethodBeat.i(27881);
        if (this.vmT != null) {
            this.vmT.setVisibility(8);
        }
        AppMethodBeat.o(27881);
    }

    public final void dks() {
        AppMethodBeat.i(27882);
        AppPanel appPanel = this.vmM;
        appPanel.vlZ = true;
        appPanel.vlP.oO(false);
        appPanel.djQ();
        AppMethodBeat.o(27882);
    }

    public final void dkt() {
        AppMethodBeat.i(27883);
        ab.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.vnh = true;
        this.oij.setImeOptions(4);
        this.oij.setInputType(this.oij.getInputType() & -65);
        AppMethodBeat.o(27883);
    }

    private void dku() {
        AppMethodBeat.i(27884);
        this.gbS.findViewById(R.id.amm).setVisibility(0);
        AppMethodBeat.o(27884);
    }

    private void dkv() {
        AppMethodBeat.i(27885);
        ab.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
        this.vnh = false;
        this.oij.setImeOptions(0);
        this.oij.setInputType(this.oij.getInputType() | 64);
        AppMethodBeat.o(27885);
    }

    public int getMode() {
        return this.vnf;
    }

    public final void dkw() {
        AppMethodBeat.i(27886);
        if (!(this.vmQ.dkH() || this.eAk == null)) {
            this.eAk.refresh();
        }
        AppMethodBeat.o(27886);
    }

    public void setAppPanelVisible(int i) {
        AppMethodBeat.i(27887);
        if (this.vmM != null) {
            this.vmM.setVisibility(i);
        }
        setAppPanelTipVisible(i == 0);
        AppMethodBeat.o(27887);
    }

    public final void djS() {
        AppMethodBeat.i(27888);
        ab.i("MicroMsg.ChatFooter", "[dealOrientationChange]");
        djq();
        dkB();
        this.vnz = true;
        this.vnj = x.gu(this.context);
        dkw();
        AppMethodBeat.o(27888);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(27889);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s", configuration);
        Lh(getKeyBordHeightPX());
        AppMethodBeat.o(27889);
    }

    public void setBottomPanelVisibility(int i) {
        AppMethodBeat.i(27890);
        if (i == 0) {
            this.vmQ.setVisibility(i);
            AppMethodBeat.o(27890);
            return;
        }
        dkA();
        AppMethodBeat.o(27890);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dkx() {
        AppMethodBeat.i(27891);
        if (this.vnp == null || this.vnp.getView() == null) {
            AppMethodBeat.o(27891);
            return false;
        }
        View findViewById = this.vnp.getView().findViewById(R.id.d88);
        if (findViewById == null) {
            AppMethodBeat.o(27891);
            return false;
        }
        int safeInsetLeft;
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        if (com.tencent.mm.compatible.util.d.iW(28)) {
            DisplayCutout displayCutout = findViewById.getRootWindowInsets().getDisplayCutout();
            if (displayCutout != null) {
                safeInsetLeft = displayCutout.getSafeInsetLeft();
                if (rect.left <= safeInsetLeft) {
                    AppMethodBeat.o(27891);
                    return true;
                }
                AppMethodBeat.o(27891);
                return false;
            }
        }
        safeInsetLeft = 0;
        if (rect.left <= safeInsetLeft) {
        }
    }

    public final boolean dky() {
        AppMethodBeat.i(27892);
        if (this.vmQ.getVisibility() == 0) {
            AppMethodBeat.o(27892);
            return true;
        }
        AppMethodBeat.o(27892);
        return false;
    }

    public void setWordCountLimit(int i) {
        AppMethodBeat.i(27893);
        this.vmN = (TextView) this.gbS.findViewById(R.id.amn);
        this.oij.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.o(27893);
    }

    @TargetApi(11)
    public void setEditTextOnDragListener(OnDragListener onDragListener) {
        AppMethodBeat.i(27894);
        this.oij.setOnDragListener(onDragListener);
        AppMethodBeat.o(27894);
    }

    public void setOnEditFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(27895);
        this.oij.setOnFocusChangeListener(onFocusChangeListener);
        AppMethodBeat.o(27895);
    }

    public void setAppPanelListener(com.tencent.mm.pluginsdk.ui.chat.AppPanel.a aVar) {
        AppMethodBeat.i(27896);
        this.vmM.setAppPanelListener(aVar);
        AppMethodBeat.o(27896);
    }

    public void setSetTolastCustomPage(boolean z) {
    }

    public void setOnFooterSwitchListener(e eVar) {
        AppMethodBeat.i(27897);
        this.vmZ = eVar;
        if (eVar == null) {
            AppMethodBeat.o(27897);
            return;
        }
        View findViewById = findViewById(R.id.amd);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27810);
                if (ChatFooter.this.vmZ != null) {
                    ChatFooter.this.vmZ.oS(false);
                }
                AppMethodBeat.o(27810);
            }
        });
        AppMethodBeat.o(27897);
    }

    public void setSwitchButtonMode(int i) {
        AppMethodBeat.i(27898);
        if (i == this.vnA) {
            AppMethodBeat.o(27898);
            return;
        }
        this.vnA = i;
        ImageView imageView = (ImageView) findViewById(R.id.ame);
        ImageView imageView2 = (ImageView) findViewById(R.id.amf);
        if (this.vnA == 1) {
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            AppMethodBeat.o(27898);
            return;
        }
        imageView.setVisibility(0);
        imageView2.setVisibility(8);
        AppMethodBeat.o(27898);
    }

    public int getSmieyType() {
        return 0;
    }

    @TargetApi(11)
    public void setToSendTextColor(final boolean z) {
        AppMethodBeat.i(27899);
        if (com.tencent.mm.compatible.util.d.iW(11)) {
            com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a() {
                public final void run() {
                    AppMethodBeat.i(27811);
                    Message message = new Message();
                    message.what = 1002;
                    message.obj = Boolean.valueOf(z);
                    ChatFooter.this.mHandler.sendMessage(message);
                    AppMethodBeat.o(27811);
                }
            });
            AppMethodBeat.o(27899);
        } else if (z) {
            this.oij.setTextColor(getResources().getColor(R.color.a7r));
            AppMethodBeat.o(27899);
        } else {
            this.oij.setTextColor(getResources().getColor(R.color.rr));
            oP(false);
            AppMethodBeat.o(27899);
        }
    }

    public final void dkz() {
        AppMethodBeat.i(27900);
        showVKB();
        oP(true);
        AppMethodBeat.o(27900);
    }

    public final void oQ(boolean z) {
        AppMethodBeat.i(27901);
        hideVKB();
        oP(z);
        AppMethodBeat.o(27901);
    }

    public final void dkA() {
        AppMethodBeat.i(27902);
        u(2, 20, false);
        AppMethodBeat.o(27902);
    }

    public final void showVKB() {
        AppMethodBeat.i(27903);
        if (!(this.vnp == null || !this.vnp.isSupportNavigationSwipeBack() || this.vnp.getSwipeBackLayout() == null)) {
            this.vnp.getSwipeBackLayout().setOnceDisEnableGesture(true);
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27814);
                if (ChatFooter.this.dkx()) {
                    ab.i("changelcai", "isScrolling!! pass this event!");
                    AppMethodBeat.o(27814);
                    return;
                }
                ChatFooter.a(ChatFooter.this, 1);
                AppMethodBeat.o(27814);
            }
        });
        AppMethodBeat.o(27903);
    }

    public final boolean hideVKB() {
        AppMethodBeat.i(27904);
        if (getKeyBordHeightPX() / 2 <= getBottom()) {
            boolean hideVKB = bo.hideVKB(this);
            AppMethodBeat.o(27904);
            return hideVKB;
        }
        AppMethodBeat.o(27904);
        return false;
    }

    public final void u(int i, int i2, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(27905);
        if (!z) {
            this.vmS.setContentDescription(getContext().getString(R.string.air));
            switch (i) {
                case 0:
                    hideVKB();
                    oP(false);
                    if (!this.vjb) {
                        dkB();
                        break;
                    }
                    break;
                case 1:
                    hideVKB();
                    break;
                case 2:
                    if (i2 != 20) {
                        if (i2 != 22) {
                            if (i2 != 21) {
                                if (i2 == 23) {
                                    djq();
                                    dkB();
                                    break;
                                }
                            } else if (this.eAk != null) {
                                this.eAk.setVisibility(8);
                                break;
                            }
                        }
                        setAppPanelVisible(8);
                        break;
                    } else if (!this.vjb) {
                        dkB();
                        break;
                    } else {
                        hideVKB();
                        break;
                    }
                    break;
            }
        }
        if (r.Zf().booleanValue() && this.vnl != null) {
            this.vnl.a(Boolean.TRUE, Boolean.FALSE);
            this.vnl.b(Boolean.TRUE, Boolean.FALSE);
        }
        this.vmS.setContentDescription(getContext().getString(R.string.aiq));
        switch (i) {
            case 1:
                getInputPanelHelper().az(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(27815);
                        ChatFooter.this.vmQ.setVisibility(8);
                        AppMethodBeat.o(27815);
                    }
                });
                if (!x.gu(this.context) || isInMultiWindowMode()) {
                    this.vmQ.setVisibility(8);
                }
                oP(true);
                setToSendTextColor(true);
                this.vne.showSoftInput(this.oij, 0);
                break;
            case 2:
                Lh(getKeyBordHeightPX());
                if (i2 == 22) {
                    if (this.vmM == null) {
                        dkg();
                    }
                    this.vmM.djT();
                    if (this.eAk != null) {
                        this.eAk.setVisibility(8);
                    }
                    ab.i("MicroMsg.ChatFooter", "show app panel");
                    setAppPanelVisible(0);
                    this.vmW.dkJ();
                    oP(false);
                    if (this.vnf == 2) {
                        Lg(1);
                    }
                } else if (i2 == 21) {
                    if (this.vmM != null) {
                        setAppPanelVisible(8);
                    }
                    if (this.eAk == null) {
                        dke();
                    }
                    if (this.eAk != null) {
                        this.eAk.setVisibility(0);
                    }
                    oR(true);
                    oP(true);
                }
                if (cth() && x.gu(getContext()) && !isInMultiWindowMode()) {
                    getInputPanelHelper().aA(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(27816);
                            ChatFooter.this.vmQ.setVisibility(0);
                            AppMethodBeat.o(27816);
                        }
                    });
                    ab.i("MicroMsg.ChatFooter", "bottom panel will show lately");
                } else {
                    this.vmQ.setVisibility(0);
                }
                if (!(cth() && x.gu(getContext()))) {
                    LayoutParams layoutParams = this.vmQ.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == 0) {
                        layoutParams.height = x.gs(getContext());
                        ab.e("MicroMsg.ChatFooter", "configPannel():bottomPanel height:" + layoutParams.height);
                        this.vmQ.setLayoutParams(layoutParams);
                    }
                }
                hideVKB();
                break;
            case 3:
                this.vmQ.setIsHide(true);
                if (!x.gu(this.context)) {
                    this.vmQ.setVisibility(8);
                }
                oP(true);
                setToSendTextColor(true);
                break;
            default:
                z = false;
                break;
        }
        if (!((!z || i2 == 21 || this.vmT == null) && (this.vmT == null || z || (i2 != 21 && i2 != 20)))) {
            oR(false);
        }
        if (i != 0 || z) {
            if (z && i2 != 22) {
                if (this.oij.length() <= 0) {
                    z2 = false;
                }
                iP(z2);
            }
            AppMethodBeat.o(27905);
            return;
        }
        oR(false);
        AppMethodBeat.o(27905);
    }

    public final boolean cth() {
        AppMethodBeat.i(27906);
        ab.i("MicroMsg.ChatFooter", "is show key board %d, %d, %d", Integer.valueOf(this.jZl), Integer.valueOf(this.jZk), Integer.valueOf(ae.fr(this.context)));
        if (this.jZl <= 0 || this.jZl >= this.jZk - r2) {
            AppMethodBeat.o(27906);
            return false;
        }
        AppMethodBeat.o(27906);
        return true;
    }

    @TargetApi(24)
    private boolean isInMultiWindowMode() {
        AppMethodBeat.i(27907);
        if ((getContext() instanceof Activity) && com.tencent.mm.compatible.util.d.iW(24)) {
            ab.i("MicroMsg.ChatFooter", "isInMultiWindow %b ", Boolean.valueOf(((Activity) getContext()).isInMultiWindowMode()));
            AppMethodBeat.o(27907);
            return ((Activity) getContext()).isInMultiWindowMode();
        }
        AppMethodBeat.o(27907);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(27908);
        String str = "MicroMsg.ChatFooter";
        String str2 = "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d softInputMode:%s";
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(i4);
        objArr[5] = Integer.valueOf(this.activity == null ? 0 : this.activity.getWindow().getAttributes().softInputMode);
        ab.i(str, str2, objArr);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        if (getTop() != 0) {
            if (getTop() > this.vnK) {
                this.vnK = getTop();
            }
            if (this.vnK - getTop() > 50) {
                if (this.vmY != null) {
                    this.vmY.iS(true);
                }
            } else if (this.vmY != null) {
                this.vmY.iS(false);
            }
        }
        if (z) {
            if (this.vmX != null) {
                m mVar = this.vmX;
                if (mVar.voE.isShowing()) {
                    mVar.voE.dismiss();
                    mVar.dkL();
                }
            }
            AppMethodBeat.o(27908);
            return;
        }
        AppMethodBeat.o(27908);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(27909);
        ab.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", Integer.valueOf(MeasureSpec.getSize(i2)), Integer.valueOf(getMeasuredHeight()));
        super.onMeasure(i, i2);
        ab.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", Integer.valueOf(getMeasuredHeight()));
        AppMethodBeat.o(27909);
    }

    public final void m(boolean z, int i) {
        AppMethodBeat.i(27910);
        super.m(z, i);
        if (this.vnJ != i) {
            this.vnJ = i;
            j.x(getContext(), i);
            Lh(getKeyBordHeightPX());
        }
        AppMethodBeat.o(27910);
    }

    public int getKeyBordHeightPX() {
        AppMethodBeat.i(27911);
        int gs = x.gs(getContext());
        AppMethodBeat.o(27911);
        return gs;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(27912);
        super.onSizeChanged(i, i2, i3, i4);
        ab.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(27912);
    }

    private void oR(boolean z) {
        AppMethodBeat.i(27913);
        if (this.vmT == null) {
            AppMethodBeat.o(27913);
        } else if (this.vnM && z) {
            AppMethodBeat.o(27913);
        } else if (this.vnM || z) {
            this.vnM = z;
            if (z) {
                this.vmT.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ix));
                AppMethodBeat.o(27913);
                return;
            }
            this.vmT.setImageDrawable(getContext().getResources().getDrawable(R.drawable.iv));
            AppMethodBeat.o(27913);
        } else {
            AppMethodBeat.o(27913);
        }
    }

    private void dkB() {
        AppMethodBeat.i(27914);
        this.vmQ.setVisibility(8);
        setAppPanelVisible(8);
        if (this.eAk != null) {
            this.eAk.setVisibility(8);
        }
        oR(false);
        AppMethodBeat.o(27914);
    }

    private void Lh(int i) {
        int e;
        AppMethodBeat.i(27915);
        ab.i("MicroMsg.ChatFooter", "[refreshBootomHeight] keyborPx:%d", Integer.valueOf(i));
        x.dod();
        if (ad.aox(this.vmL) || ad.aoy(this.vmL)) {
            e = x.e(this.context, i, 43);
        } else {
            e = x.at(this.context, i);
        }
        if (e > 0 && this.vmQ != null) {
            ab.d("MicroMsg.ChatFooter", "set bottom panel height: %d", Integer.valueOf(e));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.height = e;
            ab.e("MicroMsg.ChatFooter", "refreshBootomHeight:bottomPanel height:" + layoutParams.height);
            this.vmQ.setLayoutParams(layoutParams);
        }
        if (this.vmM != null) {
            this.vmM.setPortHeighPx(e);
            this.vmM.AG();
        }
        if (this.viY != null) {
            this.viY.setPortHeightPX(e);
            this.viY.djT();
        }
        if (this.eAk != null) {
            if (!(cth() || this.vmQ.dkH())) {
                dkw();
            }
            this.eAk.setPortHeightPx(e);
            this.eAk.AG();
        }
        AppMethodBeat.o(27915);
    }

    public final void dkC() {
        AppMethodBeat.i(27916);
        this.miB = false;
        this.vmO.setBackgroundDrawable(com.tencent.mm.bz.a.g(getContext(), R.drawable.a7m));
        this.vmO.setText(R.string.ajl);
        if (this.vmY != null) {
            if (this.miJ == null || this.miJ.getVisibility() != 0) {
                this.vmY.bNG();
            } else {
                this.vmY.bNI();
                AppMethodBeat.o(27916);
                return;
            }
        }
        AppMethodBeat.o(27916);
    }

    public final boolean dkD() {
        AppMethodBeat.i(27917);
        if (this.vnK - getTop() > 50) {
            AppMethodBeat.o(27917);
            return true;
        }
        AppMethodBeat.o(27917);
        return false;
    }

    public void setUserName(String str) {
        AppMethodBeat.i(27918);
        this.vmL = str;
        if (this.eAk != null) {
            this.eAk.setTalkerName(this.vmL);
        }
        String str2 = "MicroMsg.ChatFooter";
        String str3 = "setusername: %s, %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.vmM != null);
        ab.i(str2, str3, objArr);
        if (this.vmM != null) {
            if (t.nI(this.vmL) || t.nB(this.vmL)) {
                this.vmM.setServiceShowFlag(0);
            } else if (t.mZ(this.vmL)) {
                this.vmM.setServiceShowFlag(4);
            } else if (t.kH(this.vmL)) {
                this.vmM.setServiceShowFlag(2);
            } else {
                this.vmM.setServiceShowFlag(1);
            }
        }
        if (ad.aox(this.vmL) || ad.aoy(this.vmL)) {
            Lh(-1);
        }
        AppMethodBeat.o(27918);
    }

    public final void dkE() {
        AppMethodBeat.i(27919);
        aw.ZK();
        this.vno = ((Boolean) com.tencent.mm.model.c.Ry().get(66832, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(27919);
    }

    public void setCattingRootLayoutId(int i) {
        this.vnU = null;
        this.vnT = i;
    }

    public void onGlobalLayout() {
        AppMethodBeat.i(27920);
        if (this.activity == null || this.activity.getWindow() == null || this.activity.getWindow().getDecorView() == null) {
            AppMethodBeat.o(27920);
        } else if (this.vnT == -1) {
            ab.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
            AppMethodBeat.o(27920);
        } else {
            if (this.vnU == null) {
                this.vnU = this.activity.getWindow().getDecorView().findViewById(this.vnT);
            }
            if (this.vnU == null) {
                ab.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", Integer.valueOf(this.vnT));
                AppMethodBeat.o(27920);
                return;
            }
            int height = this.vnU.getHeight();
            int width = this.vnU.getWidth();
            ab.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", Integer.valueOf(this.vnU.getMeasuredHeight()), Integer.valueOf(height));
            if (this.dj < height) {
                this.dj = height;
            }
            this.vnL = height;
            if (this.vnR <= 0) {
                this.vnR = height;
                AppMethodBeat.o(27920);
            } else if (this.vnS <= 0) {
                this.vnS = width;
                AppMethodBeat.o(27920);
            } else if (this.vnR == height && this.vnS == width) {
                AppMethodBeat.o(27920);
            } else {
                if (cth() && this.vnr) {
                    this.vnr = false;
                    ab.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                    postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(27812);
                            ChatFooter.this.dkA();
                            AppMethodBeat.o(27812);
                        }
                    }, 10);
                }
                ab.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", Integer.valueOf(this.vnR), Integer.valueOf(height));
                int fr = ae.fr(this.context);
                int abs = Math.abs(this.vnR - height);
                if (abs > fr) {
                    this.vnR = height;
                }
                height = Math.abs(this.vnS - width);
                this.vnS = width;
                ab.i("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", Integer.valueOf(height));
                if (this.vnV && height != 0) {
                    if (this.vmM != null) {
                        this.vmM.setNeedRefreshHeight(true);
                        this.vmM.djS();
                    }
                    if (this.eAk != null) {
                        this.eAk.setPortHeightPx(x.gs(this.context));
                        dkw();
                        this.eAk.AG();
                    }
                }
                ab.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: ".concat(String.valueOf(abs)));
                AppMethodBeat.o(27920);
            }
        }
    }

    public int getYFromBottom() {
        AppMethodBeat.i(27921);
        int gs = x.gs(getContext());
        int height = getHeight();
        if (height < gs) {
            height += gs;
            AppMethodBeat.o(27921);
            return height;
        }
        AppMethodBeat.o(27921);
        return height;
    }

    public View getPanel() {
        return this.vmQ;
    }

    public void setLbsMode(boolean z) {
        this.vnc = z;
    }

    public boolean getIsVoiceInputPanleShow() {
        return this.vjb;
    }

    public void setLastText(String str) {
        AppMethodBeat.i(27854);
        u(str, -1, true);
        AppMethodBeat.o(27854);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i, String str) {
        AppMethodBeat.i(27924);
        if (bo.isNullOrNil(chatFooter.vnq.getTalkerUserName())) {
            ab.e("MicroMsg.ChatFooter", "doSendImage : talker is null");
            AppMethodBeat.o(27924);
        } else if (str == null || str.equals("") || !com.tencent.mm.a.e.ct(str)) {
            ab.e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
            AppMethodBeat.o(27924);
        } else {
            aw.Rg().a(new l(4, r.Yz(), chatFooter.vnq.getTalkerUserName(), str, i, null, 0, "", "", true, R.drawable.b0p), 0);
            AppMethodBeat.o(27924);
        }
    }

    static /* synthetic */ void j(ChatFooter chatFooter) {
        AppMethodBeat.i(27926);
        chatFooter.postDelayed(new Runnable() {
            final /* synthetic */ boolean vnZ = false;

            public final void run() {
                AppMethodBeat.i(27817);
                ChatFooter.e(ChatFooter.this, this.vnZ);
                AppMethodBeat.o(27817);
            }
        }, 10);
        AppMethodBeat.o(27926);
    }

    static /* synthetic */ void r(ChatFooter chatFooter) {
        AppMethodBeat.i(27929);
        if (chatFooter.vnf == 1) {
            ab.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bo.dpG(), chatFooter.activity);
            if (com.tencent.mm.pluginsdk.permission.b.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                chatFooter.setMode(2);
                AppMethodBeat.o(27929);
                return;
            }
        }
        chatFooter.setMode(1);
        if (chatFooter.vmY != null) {
            chatFooter.vmY.iS(true);
            chatFooter.vmY.I(null);
        }
        AppMethodBeat.o(27929);
    }

    static /* synthetic */ void D(ChatFooter chatFooter) {
        AppMethodBeat.i(27932);
        if (com.tencent.mm.r.a.bJ(chatFooter.context) || com.tencent.mm.r.a.bH(chatFooter.context)) {
            ab.d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            AppMethodBeat.o(27932);
            return;
        }
        chatFooter.findViewById(R.id.amc).setVisibility(8);
        chatFooter.vnf = 1;
        chatFooter.oij.setVisibility(8);
        chatFooter.vmO.setVisibility(8);
        chatFooter.Ld(R.drawable.iy);
        if (chatFooter.eAk != null) {
            chatFooter.eAk.setVisibility(8);
        }
        chatFooter.setAppPanelVisible(8);
        chatFooter.vmQ.setVisibility(0);
        chatFooter.oP(false);
        if (chatFooter.viY == null) {
            chatFooter.viY = new n(chatFooter.getContext(), false, null);
            chatFooter.vmQ.addView(chatFooter.viY, new LinearLayout.LayoutParams(-1, -1));
            chatFooter.viY.setCallback(new com.tencent.mm.pluginsdk.ui.chat.n.a() {
                public final void djr() {
                    AppMethodBeat.i(27801);
                    ChatFooter.E(ChatFooter.this);
                    AppMethodBeat.o(27801);
                }

                public final void ajt(String str) {
                    AppMethodBeat.i(27802);
                    if (ChatFooter.this.vmY != null) {
                        ChatFooter.this.vmY.Qu(str);
                    } else {
                        ab.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
                    }
                    ChatFooter.this.viY.reset();
                    AppMethodBeat.o(27802);
                }

                public final void oz(boolean z) {
                    AppMethodBeat.i(27803);
                    if (z) {
                        if (ChatFooter.this.vnm != null) {
                            ab.d("MicroMsg.ChatFooter", "onVoiceStart start");
                            ChatFooter.this.vnm.i(Boolean.TRUE);
                            AppMethodBeat.o(27803);
                            return;
                        }
                    } else if (ChatFooter.this.vnm != null) {
                        ab.d("MicroMsg.ChatFooter", "onVoiceStart end");
                        ChatFooter.this.vnm.i(Boolean.FALSE);
                    }
                    AppMethodBeat.o(27803);
                }
            });
            if (chatFooter.vmM.getHeight() > 0) {
                chatFooter.viY.setPortHeightPX(chatFooter.vmM.getHeight());
            } else {
                chatFooter.viY.setPortHeightPX(x.gs(chatFooter.context));
            }
        }
        chatFooter.viY.dkM();
        chatFooter.viY.setToUser(chatFooter.toUser);
        chatFooter.viY.djT();
        chatFooter.viY.setVisibility(0);
        chatFooter.vjb = true;
        AppMethodBeat.o(27932);
    }

    static /* synthetic */ void M(ChatFooter chatFooter) {
        AppMethodBeat.i(27936);
        chatFooter.vnQ.removeMessages(4097);
        chatFooter.vnQ.sendEmptyMessageDelayed(4097, 1);
        AppMethodBeat.o(27936);
    }
}
