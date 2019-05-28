package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.View.OnClickListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18352nz;
import com.tencent.p177mm.p230g.p231a.C45348ny;
import com.tencent.p177mm.p230g.p232b.p233a.C42084b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.InputPanelLinearLayout;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C14883d;
import com.tencent.p177mm.pluginsdk.model.app.C35794ae;
import com.tencent.p177mm.pluginsdk.model.app.C40442x;
import com.tencent.p177mm.pluginsdk.model.app.C46493an;
import com.tencent.p177mm.pluginsdk.p1079f.C14832a;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.AppPanel.C14934a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.AppPanel.C30118b;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23293i.C23292a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C30125h.C23290a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C40482n.C40481a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44084m.C23298a;
import com.tencent.p177mm.pluginsdk.p597ui.p1668a.C46501a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter */
public class ChatFooter extends InputPanelLinearLayout implements OnGlobalLayoutListener, C23290a {
    private static int count = 0;
    private static final int[] gcc = new int[]{C25738R.drawable.aab, C25738R.drawable.aac, C25738R.drawable.aad, C25738R.drawable.aae, C25738R.drawable.aaf, C25738R.drawable.aag, C25738R.drawable.aah};
    private static final int[] miN = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private Activity activity;
    public String cEV;
    private Context context;
    /* renamed from: dj */
    private int f16200dj;
    public ChatFooterPanel eAk;
    private View gbS;
    private int jZk;
    private int jZl;
    public final C7306ak mHandler;
    private boolean miB;
    public View miF;
    public View miG;
    private ImageView miH;
    public View miI;
    public View miJ;
    private final C7306ak miO;
    public MMEditText oij;
    public Button oik;
    public C46633o szb;
    private TextView szc;
    private ImageView szd;
    public View sze;
    public String toUser;
    private int ubu;
    C44082f vhg;
    public C40482n viY;
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
    private C5653c vmV;
    private C23293i vmW;
    public C44084m vmX;
    private C23288b vmY;
    private C35868e vmZ;
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
    private C7306ak vnQ;
    private int vnR;
    private int vnS;
    private int vnT;
    private View vnU;
    public boolean vnV;
    private int vnW;
    public final C4752a vna;
    public boolean vnb;
    private boolean vnc;
    private TextView vnd;
    private InputMethodManager vne;
    private int vnf;
    private boolean vng;
    private boolean vnh;
    public boolean vni;
    private boolean vnj;
    C42084b vnk;
    public C35866c vnl;
    public C35867d vnm;
    private C23298a vnn;
    private boolean vno;
    public MMFragment vnp;
    public C14939b vnq;
    private boolean vnr;
    private Animation vns;
    private Animation vnt;
    private C44073a vnu;
    private C30118b vnv;
    public C35869f vnw;
    private int vnx;
    private C4884c vny;
    private boolean vnz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$13 */
    class C474713 implements C30118b {
        C474713() {
        }

        public final void djW() {
            AppMethodBeat.m2504i(27800);
            C4990ab.m7417i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(ChatFooter.this.activity, "android.permission.RECORD_AUDIO", 80, "", "")), C5046bo.dpG(), ChatFooter.this.activity);
            if (C35805b.m58707a(ChatFooter.this.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                int acS = C9638aw.m17182Rg().acS();
                if (acS == 4 || acS == 6) {
                    ChatFooter.m69475D(ChatFooter.this);
                    AppMethodBeat.m2505o(27800);
                    return;
                }
                if (ChatFooter.this.vmV == null || !ChatFooter.this.vmV.isShowing()) {
                    ChatFooter.this.vmV = C30379h.m48467g(ChatFooter.this.getContext(), C25738R.string.f6c, C25738R.string.f9238tz);
                }
                AppMethodBeat.m2505o(27800);
                return;
            }
            AppMethodBeat.m2505o(27800);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$24 */
    class C474824 implements Runnable {
        C474824() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27815);
            ChatFooter.this.vmQ.setVisibility(8);
            AppMethodBeat.m2505o(27815);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$25 */
    class C474925 implements Runnable {
        C474925() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27816);
            ChatFooter.this.vmQ.setVisibility(0);
            AppMethodBeat.m2505o(27816);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$26 */
    class C475026 implements Runnable {
        final /* synthetic */ boolean vnZ = false;

        C475026() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27817);
            ChatFooter.m69502e(ChatFooter.this, this.vnZ);
            AppMethodBeat.m2505o(27817);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$28 */
    class C475128 implements OnFocusChangeListener {
        C475128() {
        }

        public final void onFocusChange(View view, boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$a */
    public static class C4752a {
        public String voc;
        String vod;
        int voe;
        public HashMap<String, LinkedList<HashMap<String, String>>> vof;

        private C4752a() {
            AppMethodBeat.m2504i(27824);
            this.vof = new HashMap();
            AppMethodBeat.m2505o(27824);
        }

        /* synthetic */ C4752a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$27 */
    class C753027 extends C7306ak {
        C753027() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27818);
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
                        C4990ab.m7412e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + layoutParams.height);
                        ChatFooter.this.vmQ.setLayoutParams(layoutParams);
                        ChatFooter.m69487M(ChatFooter.this);
                        break;
                    }
                    ChatFooter.this.vnP = false;
                    ChatFooter.this.vmQ.setVisibility(8);
                    ChatFooter.m69497c(ChatFooter.this, ChatFooter.this.getKeyBordHeightPX());
                    AppMethodBeat.m2505o(27818);
                    return;
            }
            AppMethodBeat.m2505o(27818);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$11 */
    class C1493511 implements C44073a {
        C1493511() {
        }

        public final void aYY() {
            AppMethodBeat.m2504i(27795);
            ChatFooter.this.vnf = 1;
            ChatFooter.this.vmU.setVisibility(0);
            ChatFooter.this.vmO.setVisibility(8);
            ChatFooter.m69492a(ChatFooter.this, true);
            ChatFooter.m69474C(ChatFooter.this);
            if (ChatFooter.this.oik != null) {
                ChatFooter.this.oik.performClick();
            }
            AppMethodBeat.m2505o(27795);
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
            AppMethodBeat.m2504i(27796);
            if (ChatFooter.this.vmQ.getVisibility() == 0) {
                ChatFooter.this.vnf = 1;
                ChatFooter.this.vmU.setVisibility(0);
                ChatFooter.this.vmO.setVisibility(8);
                ChatFooter.m69474C(ChatFooter.this);
                if (ChatFooter.this.oij != null) {
                    ChatFooter.this.setToSendTextColor(z);
                }
            }
            AppMethodBeat.m2505o(27796);
        }

        public final void aRg() {
            AppMethodBeat.m2504i(27797);
            ChatFooter.this.vnf = 1;
            ChatFooter.this.vmU.setVisibility(0);
            ChatFooter.this.vmO.setVisibility(8);
            ChatFooter.m69492a(ChatFooter.this, true);
            ChatFooter.m69474C(ChatFooter.this);
            ChatFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            ChatFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            ChatFooter.this.vnk.cTw--;
            AppMethodBeat.m2505o(27797);
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(27798);
            ChatFooter.this.vnf = 1;
            ChatFooter.this.vmU.setVisibility(0);
            ChatFooter.this.vmO.setVisibility(8);
            ChatFooter.m69492a(ChatFooter.this, true);
            ChatFooter.m69474C(ChatFooter.this);
            try {
                ChatFooter.this.oij.asB(str);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ChatFooter", e, "", new Object[0]);
            }
            ChatFooter.this.vnk.cTw++;
            AppMethodBeat.m2505o(27798);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$12 */
    class C1493612 extends C7306ak {
        C1493612() {
        }

        @SuppressLint({"NewApi"})
        @TargetApi(11)
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27799);
            switch (message.what) {
                case 1002:
                    if (!(ChatFooter.this.oij == null || message.obj == null)) {
                        boolean booleanValue = ((Boolean) message.obj).booleanValue();
                        if (booleanValue) {
                            ChatFooter.this.oij.setAlpha(1.0f);
                        } else {
                            ChatFooter.this.oij.setAlpha(0.5f);
                        }
                        ChatFooter.m69492a(ChatFooter.this, booleanValue);
                        break;
                    }
            }
            AppMethodBeat.m2505o(27799);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$31 */
    class C1493731 implements OnEditorActionListener {
        C1493731() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(27822);
            if (i == 4 || (i == 0 && ChatFooter.this.vnh)) {
                ChatFooter.this.oik.performClick();
                AppMethodBeat.m2505o(27822);
                return true;
            }
            AppMethodBeat.m2505o(27822);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$4 */
    class C149384 implements OnClickListener {
        C149384() {
        }

        public final synchronized void onClick(View view) {
            AppMethodBeat.m2504i(27789);
            String obj = ChatFooter.this.oij.getText().toString();
            C4990ab.m7416i("MicroMsg.ChatFooter", "send msg onClick");
            if (obj.trim().length() != 0 || obj.length() == 0) {
                ChatFooter.m69494b(ChatFooter.this, obj.length());
                if (ChatFooter.this.vmY != null && ChatFooter.this.vmY.mo38999Qu(obj)) {
                    ChatFooter.this.oij.clearComposingText();
                    ChatFooter.this.oij.setText("");
                    ChatFooter.m69511l(ChatFooter.this);
                }
                AppMethodBeat.m2505o(27789);
            } else {
                C4990ab.m7410d("MicroMsg.ChatFooter", "empty message cant be sent");
                if (ChatFooter.this.vmV == null || !ChatFooter.this.vmV.isShowing()) {
                    ChatFooter.this.vmV = C30379h.m48467g(ChatFooter.this.getContext(), C25738R.string.akg, C25738R.string.f9238tz);
                    AppMethodBeat.m2505o(27789);
                }
                AppMethodBeat.m2505o(27789);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$b */
    public interface C14939b {
        String getTalkerUserName();
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$14 */
    class C2328614 implements C40481a {
        C2328614() {
        }

        public final void djr() {
            AppMethodBeat.m2504i(27801);
            ChatFooter.m69476E(ChatFooter.this);
            AppMethodBeat.m2505o(27801);
        }

        public final void ajt(String str) {
            AppMethodBeat.m2504i(27802);
            if (ChatFooter.this.vmY != null) {
                ChatFooter.this.vmY.mo38999Qu(str);
            } else {
                C4990ab.m7412e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
            }
            ChatFooter.this.viY.reset();
            AppMethodBeat.m2505o(27802);
        }

        /* renamed from: oz */
        public final void mo38994oz(boolean z) {
            AppMethodBeat.m2504i(27803);
            if (z) {
                if (ChatFooter.this.vnm != null) {
                    C4990ab.m7410d("MicroMsg.ChatFooter", "onVoiceStart start");
                    ChatFooter.this.vnm.mo56658i(Boolean.TRUE);
                    AppMethodBeat.m2505o(27803);
                    return;
                }
            } else if (ChatFooter.this.vnm != null) {
                C4990ab.m7410d("MicroMsg.ChatFooter", "onVoiceStart end");
                ChatFooter.this.vnm.mo56658i(Boolean.FALSE);
            }
            AppMethodBeat.m2505o(27803);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$6 */
    class C232876 implements OnClickListener {
        C232876() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27790);
            ChatFooter.this.dkc();
            if (C1853r.m3852Zf().booleanValue() && ChatFooter.this.vnl != null) {
                C35866c c35866c = ChatFooter.this.vnl;
                Boolean bool = Boolean.TRUE;
                c35866c.mo27786a(bool, bool);
            }
            AppMethodBeat.m2505o(27790);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$19 */
    class C3011919 implements OnClickListener {
        C3011919() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27810);
            if (ChatFooter.this.vmZ != null) {
                ChatFooter.this.vmZ.mo48814oS(false);
            }
            AppMethodBeat.m2505o(27810);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$32 */
    class C3012032 implements OnTouchListener {
        C3012032() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27823);
            ChatFooter.this.setToSendTextColor(true);
            ChatFooter.m69490a(ChatFooter.this, 3);
            if (ChatFooter.this.vmY != null) {
                ChatFooter.this.vmY.mo38998I(motionEvent);
            }
            ChatFooter.m69509j(ChatFooter.this);
            AppMethodBeat.m2505o(27823);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$5 */
    class C301215 implements OnTouchListener {
        C301215() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$7 */
    class C301227 implements OnClickListener {
        C301227() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27791);
            if (ChatFooter.this.vmY != null) {
                ChatFooter.this.vmY.bNK();
            }
            if (ChatFooter.this.vmQ.dkH() || ChatFooter.this.eAk == null || ChatFooter.this.eAk.getVisibility() != 0) {
                if (ChatFooter.this.vnc) {
                    ChatFooter.this.mo63900AD();
                }
                ChatFooter.this.dkh();
                if (!C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, false)) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, Boolean.TRUE);
                    ChatFooter.this.gbS.findViewById(2131822417).setVisibility(8);
                }
                AppMethodBeat.m2505o(27791);
                return;
            }
            ChatFooter.this.showVKB();
            AppMethodBeat.m2505o(27791);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$10 */
    class C3585610 implements OnKeyListener {
        C3585610() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(27794);
            switch (keyEvent.getAction()) {
                case 0:
                    if (!((i != 23 && i != 66) || ChatFooter.this.vng || ChatFooter.this.miB)) {
                        ChatFooter.this.vng = true;
                        ChatFooter.this.vmO.setBackgroundDrawable(C1338a.m2864g(ChatFooter.this.getContext(), C25738R.drawable.f7010yg));
                        ChatFooter.this.vmO.setText(C25738R.string.ajm);
                        if (ChatFooter.this.vmY != null) {
                            ChatFooter.this.vmY.bNJ();
                        }
                        ChatFooter.this.vmO.setContentDescription(ChatFooter.this.getContext().getString(C25738R.string.aiy));
                        break;
                    }
                case 1:
                    if (i == 23 || i == 66) {
                        ChatFooter.this.vmO.setBackgroundDrawable(C1338a.m2864g(ChatFooter.this.getContext(), C25738R.drawable.a7m));
                        ChatFooter.this.vmO.setText(C25738R.string.ajl);
                        if (ChatFooter.this.vmY != null) {
                            ChatFooter.this.vmY.bNG();
                        }
                        ChatFooter.this.vng = false;
                        break;
                    }
            }
            AppMethodBeat.m2505o(27794);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$21 */
    class C3585721 implements Runnable {
        C3585721() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27812);
            ChatFooter.this.dkA();
            AppMethodBeat.m2505o(27812);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$22 */
    class C3585822 implements Runnable {
        C3585822() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27813);
            C18175j.m28619r(ChatFooter.this.activity);
            AppMethodBeat.m2505o(27813);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$23 */
    class C3585923 implements Runnable {
        C3585923() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27814);
            if (ChatFooter.this.dkx()) {
                C4990ab.m7416i("changelcai", "isScrolling!! pass this event!");
                AppMethodBeat.m2505o(27814);
                return;
            }
            ChatFooter.m69490a(ChatFooter.this, 1);
            AppMethodBeat.m2505o(27814);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$29 */
    class C3586029 implements C46501a {

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$29$2 */
        class C358622 implements DialogInterface.OnClickListener {
            C358622() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C3586029() {
        }

        public final void ajv(final String str) {
            AppMethodBeat.m2504i(27820);
            C4990ab.m7413e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", str);
            if (C5046bo.isNullOrNil(ChatFooter.this.vnq.getTalkerUserName()) || C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.ChatFooter", "onImageReceived, error args");
                AppMethodBeat.m2505o(27820);
                return;
            }
            C30379h.m48440a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(C25738R.string.bj8), "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    int i2 = 1;
                    AppMethodBeat.m2504i(27819);
                    boolean g = C1853r.m3854g(str, ChatFooter.this.vnq.getTalkerUserName(), true);
                    ChatFooter chatFooter = ChatFooter.this;
                    if (!g) {
                        i2 = 0;
                    }
                    ChatFooter.m69491a(chatFooter, i2, str);
                    AppMethodBeat.m2505o(27819);
                }
            }, new C358622());
            AppMethodBeat.m2505o(27820);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$8 */
    class C358648 implements OnClickListener {
        C358648() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27792);
            ChatFooter.m69518r(ChatFooter.this);
            AppMethodBeat.m2505o(27792);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$9 */
    class C358659 implements OnTouchListener {
        C358659() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27793);
            if (view != ChatFooter.this.vmO) {
                AppMethodBeat.m2505o(27793);
            } else {
                C4990ab.m7418v("RcdBtnEvent", "event.getAction():" + motionEvent.getAction());
                switch (motionEvent.getAction()) {
                    case 0:
                        C4990ab.m7417i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", Integer.valueOf(ChatFooter.count));
                        if (ChatFooter.this.context instanceof Activity) {
                            ((Activity) ChatFooter.this.context).getWindow().addFlags(128);
                        }
                        if (!(ChatFooter.this.miB || ChatFooter.this.vng)) {
                            ChatFooter.this.miB = true;
                            ChatFooter.this.vmO.setBackgroundDrawable(C1338a.m2864g(ChatFooter.this.getContext(), C25738R.drawable.f7010yg));
                            ChatFooter.this.vmO.setText(C25738R.string.ajm);
                            if (ChatFooter.this.vmY != null) {
                                ChatFooter.this.vmY.bNJ();
                            }
                            ChatFooter.this.vmO.setContentDescription(ChatFooter.this.getContext().getString(C25738R.string.aiy));
                            break;
                        }
                    case 1:
                    case 3:
                        if (ChatFooter.this.context instanceof Activity) {
                            ((Activity) ChatFooter.this.context).getWindow().clearFlags(128);
                        }
                        C4990ab.m7417i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.count));
                        ChatFooter.m69526z(ChatFooter.this);
                        C4990ab.m7417i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.dkG()));
                        break;
                    case 2:
                        if (ChatFooter.this.miI == null || ChatFooter.this.miJ == null) {
                            C4990ab.m7413e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", ChatFooter.this.miI, ChatFooter.this.miJ);
                        }
                        if (motionEvent.getX() > 0.0f && motionEvent.getY() > ((float) ((-ChatFooter.this.vnx) / 2)) && motionEvent.getX() < ((float) ChatFooter.this.vmO.getWidth())) {
                            if (ChatFooter.this.miI != null) {
                                ChatFooter.this.miI.setVisibility(0);
                            }
                            if (ChatFooter.this.miJ != null) {
                                ChatFooter.this.vmO.setText(C25738R.string.ajm);
                                ChatFooter.this.miJ.setVisibility(8);
                                break;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(ChatFooter.this.vnx), Integer.valueOf(ChatFooter.this.vmO.getWidth()), Integer.valueOf(ChatFooter.this.vmO.getHeight()));
                        if (ChatFooter.this.miI != null) {
                            ChatFooter.this.miI.setVisibility(8);
                        }
                        if (ChatFooter.this.miJ != null) {
                            ChatFooter.this.vmO.setText(C25738R.string.aj7);
                            ChatFooter.this.miJ.setVisibility(0);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(27793);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$c */
    public interface C35866c {
        /* renamed from: a */
        void mo27786a(Boolean bool, Boolean bool2);

        /* renamed from: b */
        void mo27787b(Boolean bool, Boolean bool2);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$d */
    public interface C35867d {
        /* renamed from: i */
        void mo56658i(Boolean bool);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$e */
    public interface C35868e {
        /* renamed from: oS */
        boolean mo48814oS(boolean z);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$f */
    public class C35869f implements TextWatcher {
        TextWatcher vog;
        private boolean voh = false;
        private boolean voi = C1443d.m3067fP(11);

        public C35869f(TextWatcher textWatcher) {
            AppMethodBeat.m2504i(27825);
            this.vog = textWatcher;
            AppMethodBeat.m2505o(27825);
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = true;
            AppMethodBeat.m2504i(27826);
            if (ChatFooter.this.vnh && this.voh && editable.length() > 0) {
                this.voh = false;
                ChatFooter.this.oij.setText(editable.subSequence(0, editable.length() - 1));
                if (ChatFooter.this.oij.length() > 0) {
                    ChatFooter.this.oik.performClick();
                    C4990ab.m7416i("MicroMsg.ChatFooter", "enter button, do send");
                }
                C4990ab.m7410d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
                AppMethodBeat.m2505o(27826);
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
            ChatFooter.m69495b(ChatFooter.this, z);
            if (ChatFooter.this.eAk != null) {
                ChatFooter.this.eAk.setSendButtonEnable(z);
            }
            C4990ab.m7410d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
            AppMethodBeat.m2505o(27826);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(27827);
            this.vog.beforeTextChanged(charSequence, i, i2, i3);
            C4990ab.m7410d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
            AppMethodBeat.m2505o(27827);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(27828);
            if (ChatFooter.this.vnh && i2 == 0 && i == charSequence.length() - 1 && i3 == 1 && charSequence.charAt(charSequence.length() - 1) == 10) {
                C4990ab.m7416i("MicroMsg.ChatFooter", "text changed, enter button");
                this.voh = true;
                AppMethodBeat.m2505o(27828);
                return;
            }
            this.vog.onTextChanged(charSequence, i, i2, i3);
            ChatFooter.this.vnk.cTu++;
            ChatFooter.this.vnk.mo67642Fm();
            if (ChatFooter.this.vnk.cTr == 0) {
                ChatFooter.this.vnk.mo67641Fl();
            }
            AppMethodBeat.m2505o(27828);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$16 */
    class C4046816 implements Runnable {
        C4046816() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27805);
            ChatFooter.this.miI.setVisibility(0);
            AppMethodBeat.m2505o(27805);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$18 */
    class C4046918 extends C4884c<C45348ny> {

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$18$1 */
        class C404701 implements Runnable {
            C404701() {
            }

            public final void run() {
                AppMethodBeat.m2504i(27807);
                C4990ab.m7416i("MicroMsg.ChatFooter", "reflesh smiley panel.");
                ChatFooter.this.dkw();
                AppMethodBeat.m2505o(27807);
            }
        }

        C4046918() {
            AppMethodBeat.m2504i(27808);
            this.xxI = C45348ny.class.getName().hashCode();
            AppMethodBeat.m2505o(27808);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(27809);
            if (ChatFooter.this.mHandler != null) {
                ChatFooter.this.mHandler.post(new C404701());
            }
            AppMethodBeat.m2505o(27809);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$1 */
    class C404721 implements C23298a {
        C404721() {
        }

        public final void clear() {
            AppMethodBeat.m2504i(27786);
            ChatFooter chatFooter = ChatFooter.this;
            if (chatFooter.oij != null) {
                chatFooter.oij.setText("");
                chatFooter.dka();
            }
            AppMethodBeat.m2505o(27786);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$15 */
    class C4047515 extends C7306ak {
        C4047515() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27804);
            super.handleMessage(message);
            if (ChatFooter.this.szb != null) {
                ChatFooter.this.szb.dismiss();
                ChatFooter.this.vmO.setBackgroundDrawable(C1338a.m2864g(ChatFooter.this.getContext(), C25738R.drawable.a7m));
                ChatFooter.this.vmO.setEnabled(true);
            }
            AppMethodBeat.m2505o(27804);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$17 */
    class C4047617 implements Runnable {
        C4047617() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27806);
            if (ChatFooter.this.szb != null) {
                ChatFooter.this.szb.dismiss();
                ChatFooter.this.miF.setVisibility(0);
                ChatFooter.this.sze.setVisibility(8);
                ChatFooter.this.miG.setVisibility(8);
                ChatFooter.this.miJ.setVisibility(8);
                ChatFooter.this.miI.setVisibility(0);
            }
            ChatFooter.this.vmO.setBackgroundDrawable(C1338a.m2864g(ChatFooter.this.getContext(), C25738R.drawable.a7m));
            ChatFooter.this.vmO.setText(C25738R.string.ajl);
            ChatFooter.this.vng = false;
            ChatFooter.this.miB = false;
            AppMethodBeat.m2505o(27806);
        }
    }

    /* renamed from: C */
    static /* synthetic */ void m69474C(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27931);
        chatFooter.m69484Ld(C25738R.drawable.f6585iy);
        AppMethodBeat.m2505o(27931);
    }

    /* renamed from: E */
    static /* synthetic */ void m69476E(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27933);
        chatFooter.djq();
        AppMethodBeat.m2505o(27933);
    }

    static /* synthetic */ int dkG() {
        int i = count;
        count = i + 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ void m69502e(ChatFooter chatFooter, boolean z) {
        AppMethodBeat.m2504i(27934);
        chatFooter.m69515oR(z);
        AppMethodBeat.m2505o(27934);
    }

    /* renamed from: l */
    static /* synthetic */ void m69511l(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27928);
        chatFooter.dka();
        AppMethodBeat.m2505o(27928);
    }

    /* renamed from: z */
    static /* synthetic */ void m69526z(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27930);
        chatFooter.dkC();
        AppMethodBeat.m2505o(27930);
    }

    public final void dka() {
        AppMethodBeat.m2504i(27829);
        if (this.vnk != null) {
            C42084b c42084b = this.vnk;
            c42084b.cTv = 0;
            c42084b.cTt = 0;
            c42084b.cTu = 0;
            c42084b.cTw = 0;
            c42084b.mo67643aM(0).mo67644aN(0);
        }
        AppMethodBeat.m2505o(27829);
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooter(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27830);
        this.gbS = null;
        this.oij = null;
        this.oik = null;
        this.vmN = null;
        this.vmZ = null;
        this.vna = new C4752a();
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
        this.vnk = new C42084b();
        this.vnn = new C404721();
        this.mHandler = new C1493612();
        this.vno = false;
        this.vnr = false;
        this.vnu = new C1493511();
        this.vnv = new C474713();
        this.miO = new C4047515();
        this.vnx = 0;
        this.vny = new C4046918();
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
        this.f16200dj = -1;
        this.vnM = false;
        this.vnN = 4097;
        this.vnO = 4098;
        this.vnQ = new C753027();
        this.vnR = -1;
        this.vnS = -1;
        this.vnT = -1;
        this.vnU = null;
        this.vnV = true;
        this.vnW = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.vne = (InputMethodManager) context.getSystemService("input_method");
        this.gbS = ChatFooter.inflate(context, 2130969019, this);
        this.oij = (MMEditText) this.gbS.findViewById(2131822414);
        if (C5222ae.dzg()) {
            this.oij.setImeOptions(268435456);
        }
        C7357c.m12555d(this.oij).mo15877PM(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSessionTextMsg"), Utility.DEFAULT_STREAM_BUFFER_SIZE) * 2).mo15879a(null);
        this.oij.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        this.oij.setOnFocusChangeListener(new C475128());
        if (C1443d.m3068iW(23)) {
            this.oij.setBreakStrategy(1);
        }
        C18352nz c18352nz = new C18352nz();
        c18352nz.cKo.cKq = this.oij;
        c18352nz.cKo.cKp = new C3586029();
        C4879a.xxA.mo10055m(c18352nz);
        this.vmU = this.gbS.findViewById(2131822413);
        this.vmQ = (ChatFooterBottom) findViewById(2131822422);
        this.vmS = (ImageButton) this.gbS.findViewById(2131822420);
        this.oik = (Button) this.gbS.findViewById(2131822421);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.oik.setTextSize(0, ((float) C1338a.m2857am(context, C25738R.dimen.f9936kr)) * C1338a.m2862fY(context));
        this.vmO = (Button) this.gbS.findViewById(2131822415);
        this.vmP = (ImageButton) findViewById(2131822412);
        m69508iP(false);
        dkE();
        this.vmW = new C23293i(getContext(), getRootView(), this, new C23292a() {
            public final void ajI(String str) {
                AppMethodBeat.m2504i(27821);
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
                    C25985d.m41458a(ChatFooter.this.vnp, "gallery", ".ui.GalleryEntryUI", intent, 217);
                    AppMethodBeat.m2505o(27821);
                    return;
                }
                C25985d.m41468b(context, "gallery", ".ui.GalleryEntryUI", intent, 217);
                AppMethodBeat.m2505o(27821);
            }
        });
        this.vmW.vov = this;
        Context context2 = getContext();
        getRootView();
        this.vmX = new C44084m(context2);
        this.vmX.vnn = this.vnn;
        C4990ab.m7411d("MicroMsg.ChatFooter", "send edittext ime option %s", Integer.valueOf(this.oij.getImeOptions()));
        this.oij.setOnEditorActionListener(new C1493731());
        this.oij.setOnTouchListener(new C3012032());
        this.oij.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(27787);
                CharSequence dhS = C14832a.dhS();
                C7060h.pYm.mo15419k(1014, 0, 1);
                C20118a.ask();
                if (C20118a.m31114x(dhS)) {
                    C7060h.pYm.mo15419k(1014, 1, 1);
                    C4990ab.m7417i("MicroMsg.ChatFooter", "anti paste text %s", dhS);
                    AppMethodBeat.m2505o(27787);
                    return true;
                }
                AppMethodBeat.m2505o(27787);
                return false;
            }
        });
        this.oij.setCustomSelectionActionModeCallback(new Callback() {
            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                AppMethodBeat.m2504i(27788);
                CharSequence dhS = C14832a.dhS();
                C7060h.pYm.mo15419k(1014, 5, 1);
                C20118a.ask();
                if (C20118a.m31114x(dhS)) {
                    C4990ab.m7417i("MicroMsg.ChatFooter", "anti paste text %s", dhS);
                    C7060h.pYm.mo15419k(1014, 6, 1);
                    if (menu.size() > 0) {
                        menu.removeItem(16908322);
                        if (C1443d.m3068iW(23)) {
                            menu.removeItem(16908340);
                        }
                    }
                }
                AppMethodBeat.m2505o(27788);
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
        this.oik.setOnClickListener(new C149384());
        this.vmO.setOnTouchListener(new C358659());
        this.vmO.setOnKeyListener(new C3585610());
        this.vmP.setOnClickListener(new C358648());
        dkg();
        this.vmS.setVisibility(0);
        this.vmS.setContentDescription(getContext().getString(C25738R.string.air));
        this.vmS.setOnClickListener(new C232876());
        C4990ab.m7416i("MicroMsg.ChatFooter", "[init]");
        m69486Lh(-1);
        findViewById(2131822408).setOnTouchListener(new C301215());
        C4990ab.m7411d("MicroMsg.ChatFooter", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(27830);
    }

    /* renamed from: a */
    public final void mo63903a(Context context, Activity activity) {
        AppMethodBeat.m2504i(27831);
        this.activity = activity;
        dkE();
        if (C46493an.dhQ().vdc) {
            C46493an.dhQ().mo74710fL(C4996ah.getContext());
        }
        if (!(this.vmQ.dkH() || this.eAk == null)) {
            this.eAk.onResume();
        }
        if (!this.vno && this.vnh) {
            dkv();
        } else if (this.vno && !this.vnh) {
            dkt();
        }
        if (C40619x.m70075gu(context) != this.vnj) {
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
        post(new C3585822());
        C4879a.xxA.mo10052c(this.vny);
        AppMethodBeat.m2505o(27831);
    }

    public void setFooterType(int i) {
        AppMethodBeat.m2504i(27832);
        this.ubu = i;
        if (this.eAk != null) {
            this.eAk.setFooterType(i);
        }
        AppMethodBeat.m2505o(27832);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(27833);
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
        C4879a.xxA.mo10053d(this.vny);
        AppMethodBeat.m2505o(27833);
    }

    public void setTipsShowCallback(C35866c c35866c) {
        this.vnl = c35866c;
    }

    public void setVoiceInputShowCallback(C35867d c35867d) {
        this.vnm = c35867d;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(27834);
        if (this.eAk != null) {
            C4990ab.m7416i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
            this.eAk.mo11686AC();
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
        C4990ab.m7410d("MicroMsg.ChatFooter", "jacks destroy");
        AppMethodBeat.m2505o(27834);
    }

    public final void dkb() {
        AppMethodBeat.m2504i(27835);
        if (this.vmM == null) {
            AppMethodBeat.m2505o(27835);
            return;
        }
        this.vmM.djI();
        AppMethodBeat.m2505o(27835);
    }

    /* renamed from: iP */
    private void m69508iP(boolean z) {
        AppMethodBeat.m2504i(27836);
        if (this.vns == null) {
            this.vns = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8362c4);
            this.vns.setDuration(150);
        }
        if (this.vnt == null) {
            this.vnt = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8367c9);
            this.vnt.setDuration(150);
        }
        if (this.oik == null || this.vmS == null) {
            AppMethodBeat.m2505o(27836);
        } else if (this.vno) {
            if (this.vmS.getVisibility() != 0) {
                this.vmS.setVisibility(0);
            }
            AppMethodBeat.m2505o(27836);
        } else if (this.oik.getVisibility() == 0 && z) {
            AppMethodBeat.m2505o(27836);
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
            C4990ab.m7417i("MicroMsg.ChatFooter", "jacks canSend:%B", Boolean.valueOf(z));
            this.oik.getParent().requestLayout();
            AppMethodBeat.m2505o(27836);
        } else {
            AppMethodBeat.m2505o(27836);
        }
    }

    public int getBarGroupHeight() {
        AppMethodBeat.m2504i(27837);
        int height = findViewById(2131822408).getHeight();
        AppMethodBeat.m2505o(27837);
        return height;
    }

    public final void dkc() {
        AppMethodBeat.m2504i(27838);
        if (this.vmY != null) {
            this.vmY.bNL();
        }
        C4990ab.m7417i("MicroMsg.ChatFooter", "click attach btn: %s, %s", Integer.valueOf(this.vmM.getVisibility()), Boolean.valueOf(this.vmQ.dkH()));
        if (this.vmM.getVisibility() != 0 || this.vmQ.dkH()) {
            mo63995u(2, 22, true);
            if (this.viY != null && this.viY.getVisibility() == 0 && this.vjb) {
                C4990ab.m7410d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.viY.setVisibility(8);
                this.vjb = false;
                this.viY.reset();
            }
            C46493an dhQ = C46493an.dhQ();
            Context context = C4996ah.getContext();
            if (C1720g.m3531RK() && context != null) {
                try {
                    String value = C26373g.m41964Nu().getValue("ShowAPPSuggestion");
                    if (C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                        C4990ab.m7421w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", value);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", e.getMessage());
                }
                if (dhQ.vcW) {
                    C4990ab.m7420w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    C4990ab.m7416i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    dhQ.vcW = true;
                    if (System.currentTimeMillis() - dhQ.vcZ < 43200000) {
                        C4990ab.m7410d("MicroMsg.SuggestionAppListLogic", "not now");
                        dhQ.vcW = false;
                    } else {
                        C1720g.m3537RQ();
                        dhQ.vcZ = C1720g.m3536RP().mo5239Ry().mo16813Mm(352275);
                        if (System.currentTimeMillis() - dhQ.vcZ < 43200000) {
                            C4990ab.m7420w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            dhQ.vcW = false;
                        } else {
                            if (dhQ.lang == null) {
                                dhQ.lang = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
                            }
                            C40442x c35794ae = new C35794ae(dhQ.lang, new LinkedList());
                            C34832a.bYM();
                            C14883d.m23149a(4, c35794ae);
                        }
                    }
                }
            }
            C46493an.dhQ().mo74710fL(C4996ah.getContext());
            AppMethodBeat.m2505o(27838);
        } else if (this.vnf == 1) {
            showVKB();
            AppMethodBeat.m2505o(27838);
        } else {
            mo63995u(0, -1, false);
            AppMethodBeat.m2505o(27838);
        }
    }

    public final void dkd() {
        AppMethodBeat.m2504i(27839);
        this.vmT = (ImageButton) this.gbS.findViewById(2131822416);
        this.vmT.setVisibility(0);
        if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, false)) {
            this.gbS.findViewById(2131822417).setVisibility(8);
        } else {
            this.gbS.findViewById(2131822417).setVisibility(0);
        }
        this.vmT.setOnClickListener(new C301227());
        if (this.vmX != null) {
            this.vmX.voF = this.vmT;
        }
        AppMethodBeat.m2505o(27839);
    }

    /* renamed from: oP */
    public final void mo63957oP(boolean z) {
        AppMethodBeat.m2504i(27840);
        if (this.oij == null) {
            AppMethodBeat.m2505o(27840);
        } else if (z) {
            this.oij.requestFocus();
            AppMethodBeat.m2505o(27840);
        } else {
            this.oij.clearFocus();
            AppMethodBeat.m2505o(27840);
        }
    }

    public final void dke() {
        boolean z = true;
        AppMethodBeat.m2504i(27841);
        dkf();
        if (C44081e.vom != null && this.context != null) {
            if (this.eAk != null) {
                this.eAk.destroy();
            }
            this.eAk = C44081e.vom.mo35682dF(this.context);
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
                    this.eAk.mo11690AG();
                    if (!C5046bo.isNullOrNil(this.oij.getText().toString())) {
                        this.eAk.mo11689AF();
                    }
                }
                if (this.vni) {
                    mo63900AD();
                }
                setSmileyPanelCallback(this.vhg);
            }
            AppMethodBeat.m2505o(27841);
        } else if (this.context == null) {
            C4990ab.m7413e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", C5046bo.dpG());
            this.eAk = new C44080d(C4996ah.getContext());
            AppMethodBeat.m2505o(27841);
        } else {
            this.eAk = new C44080d(this.context);
            AppMethodBeat.m2505o(27841);
        }
    }

    public final void dkf() {
        boolean z = true;
        AppMethodBeat.m2504i(27842);
        if (this.context == null) {
            String str = "MicroMsg.ChatFooter";
            String str2 = "[initSmiley] activity = null? %s";
            Object[] objArr = new Object[1];
            if (this.activity != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
            if (this.activity != null) {
                this.context = this.activity.getBaseContext();
                AppMethodBeat.m2505o(27842);
                return;
            }
            this.context = getContext();
        }
        AppMethodBeat.m2505o(27842);
    }

    /* renamed from: AD */
    public final void mo63900AD() {
        AppMethodBeat.m2504i(27843);
        this.vni = true;
        if (this.eAk != null) {
            this.eAk.mo11687AD();
        }
        AppMethodBeat.m2505o(27843);
    }

    public void setFooterEventListener(C23288b c23288b) {
        this.vmY = c23288b;
    }

    public void setSmileyPanelCallback(C44082f c44082f) {
        AppMethodBeat.m2504i(27844);
        this.vhg = c44082f;
        if (this.eAk != null) {
            this.eAk.setCallback(c44082f);
        }
        AppMethodBeat.m2505o(27844);
    }

    public C44082f getCallback() {
        return this.vhg;
    }

    public void setSmileyPanelCallback2(C23297j c23297j) {
        this.vmX.voG = c23297j;
    }

    /* renamed from: Ld */
    private void m69484Ld(int i) {
        AppMethodBeat.m2504i(27845);
        if (this.vmP == null) {
            AppMethodBeat.m2505o(27845);
            return;
        }
        int i2;
        if (i == C25738R.drawable.f6585iy) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.vmP != null) {
            if (i2 != 0) {
                this.vmP.setContentDescription(getContext().getString(C25738R.string.aix));
            } else {
                this.vmP.setContentDescription(getContext().getString(C25738R.string.aiw));
            }
        }
        this.vmP.setImageResource(i);
        this.vmP.setPadding(0, 0, 0, 0);
        AppMethodBeat.m2505o(27845);
    }

    private void dkg() {
        AppMethodBeat.m2504i(27846);
        String talkerUserName = this.vnq == null ? this.vmL : this.vnq.getTalkerUserName();
        this.vmM = (AppPanel) findViewById(2131822423);
        this.vmM.setOnSwitchPanelListener(this.vnv);
        this.vmM.setPortHeighPx(C40619x.m70073gs(this.context));
        if (C1855t.m3923nI(talkerUserName) || C1855t.m3916nB(talkerUserName)) {
            this.vmM.init(0);
        } else if (C1855t.m3913mZ(talkerUserName)) {
            this.vmM.init(4);
        } else if (C1855t.m3896kH(talkerUserName)) {
            this.vmM.init(2);
        } else {
            this.vmM.init(1);
        }
        this.vmR = (TextView) findViewById(2131822424);
        AppMethodBeat.m2505o(27846);
    }

    public void setAppPanelTip(CharSequence charSequence) {
        AppMethodBeat.m2504i(27847);
        if (this.vmR == null || this.vmM == null) {
            AppMethodBeat.m2505o(27847);
            return;
        }
        this.vmR.setText(charSequence);
        if (!C5046bo.m7519ac(charSequence)) {
            setAppPanelTipVisible(this.vmM.getVisibility() == 0);
        }
        AppMethodBeat.m2505o(27847);
    }

    public void setAppPanelTipVisible(boolean z) {
        AppMethodBeat.m2504i(27848);
        if (this.vmR == null) {
            AppMethodBeat.m2505o(27848);
        } else if (TextUtils.isEmpty(this.vmR.getText())) {
            this.vmR.setVisibility(8);
            AppMethodBeat.m2505o(27848);
        } else {
            int i;
            if (z) {
                Context context = this.vmR.getContext();
                this.vmM.getPageMaxRowCount();
                int fromDPToPix = C1338a.fromDPToPix(context, 32);
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
            AppMethodBeat.m2505o(27848);
        }
    }

    public final void dkh() {
        AppMethodBeat.m2504i(27849);
        this.vnf = 1;
        this.vmU.setVisibility(0);
        this.vmO.setVisibility(8);
        m69484Ld(C25738R.drawable.f6585iy);
        if (this.viY != null) {
            this.viY.setVisibility(8);
            this.vjb = false;
            this.viY.reset();
        }
        mo63995u(2, 21, true);
        AppMethodBeat.m2505o(27849);
    }

    public void setDefaultSmileyByDetail(String str) {
        AppMethodBeat.m2504i(27850);
        if (!C5046bo.isNullOrNil(str)) {
            if (this.eAk == null) {
                dke();
            }
            this.eAk.setDefaultEmojiByDetail(str);
        }
        AppMethodBeat.m2505o(27850);
    }

    private void djq() {
        AppMethodBeat.m2504i(27851);
        if (this.vjb) {
            View findViewById = findViewById(2131822408);
            this.vjb = false;
            if (this.viY != null) {
                this.viY.destroy();
                this.viY.setVisibility(8);
            }
            findViewById.setVisibility(0);
            this.oij.setVisibility(0);
            this.oij.setText("");
            mo63957oP(true);
            dkd();
            mo63995u(0, -1, false);
            AppMethodBeat.m2505o(27851);
            return;
        }
        AppMethodBeat.m2505o(27851);
    }

    public void setAtSomebody(String str) {
        this.vna.vod = str;
    }

    public void setLastContent(String str) {
        this.vna.voc = str;
    }

    /* renamed from: ax */
    public final void mo63906ax(String str, String str2, String str3) {
        LinkedList linkedList;
        AppMethodBeat.m2504i(27852);
        if (this.vna.vof.containsKey(str)) {
            linkedList = (LinkedList) this.vna.vof.get(str);
        } else {
            linkedList = new LinkedList();
            this.vna.vof.put(str, linkedList);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(str3, str2);
        linkedList.add(hashMap);
        AppMethodBeat.m2505o(27852);
    }

    public void setInsertPos(int i) {
        this.vna.voe = i;
    }

    public String getAtSomebody() {
        return this.vna.vod;
    }

    /* renamed from: hJ */
    public final HashMap<String, String> mo63953hJ(String str, String str2) {
        AppMethodBeat.m2504i(27853);
        long currentTimeMillis = System.currentTimeMillis();
        if (C5046bo.isNullOrNil(str2)) {
            if (this.vna.vof.containsKey(str)) {
                this.vna.vof.remove(str);
            }
            AppMethodBeat.m2505o(27853);
            return null;
        } else if (!this.vna.vof.containsKey(str) || ((LinkedList) this.vna.vof.get(str)).size() <= 0) {
            AppMethodBeat.m2505o(27853);
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
            C4990ab.m7417i("MicroMsg.ChatFooter", "after split @ :%s", linkedList);
            if (linkedList.size() <= 0) {
                ((LinkedList) this.vna.vof.get(str)).clear();
                AppMethodBeat.m2505o(27853);
                return null;
            }
            LinkedList linkedList2 = (LinkedList) this.vna.vof.get(str);
            if (linkedList2 == null || linkedList2.size() <= 0) {
                C4990ab.m7420w("MicroMsg.ChatFooter", "list is null or size 0");
                AppMethodBeat.m2505o(27853);
                return null;
            }
            C4990ab.m7417i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", Integer.valueOf(linkedList2.size()));
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
            C4990ab.m7417i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", Integer.valueOf(linkedList3.size()));
            hashMap2.put("atuserlist", "<![CDATA[" + C5046bo.m7536c(linkedList3, ",") + "]]>");
            linkedList2.clear();
            C4990ab.m7411d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(27853);
            return hashMap2;
        }
    }

    public String getLastContent() {
        return this.vna.voc;
    }

    public int getInsertPos() {
        return this.vna.voe;
    }

    /* renamed from: u */
    public final void mo63996u(String str, int i, boolean z) {
        AppMethodBeat.m2504i(27855);
        if (z && (str == null || str.length() == 0 || this.oij == null)) {
            this.oij.setText("");
            dka();
            AppMethodBeat.m2505o(27855);
            return;
        }
        this.vnb = true;
        this.oij.setText(C44089j.m79293b(getContext(), (CharSequence) str, this.oij.getTextSize()));
        this.vnb = false;
        if (i < 0 || i > this.oij.getText().length()) {
            this.oij.setSelection(this.oij.getText().length());
            AppMethodBeat.m2505o(27855);
            return;
        }
        this.oij.setSelection(i);
        AppMethodBeat.m2505o(27855);
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(27856);
        if (this.oij != null) {
            this.oij.setHint(str);
        }
        AppMethodBeat.m2505o(27856);
    }

    public final void ddN() {
        AppMethodBeat.m2504i(27857);
        this.vmO.setEnabled(false);
        this.vmO.setBackgroundDrawable(C1338a.m2864g(getContext(), C25738R.drawable.f7008ye));
        if (this.szb != null) {
            this.miG.setVisibility(0);
            this.miF.setVisibility(8);
            this.sze.setVisibility(8);
            this.szb.update();
        }
        this.miO.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.m2505o(27857);
    }

    public String getLastText() {
        AppMethodBeat.m2504i(27858);
        String str;
        if (this.oij == null) {
            str = "";
            AppMethodBeat.m2505o(27858);
            return str;
        }
        str = this.oij.getText().toString();
        AppMethodBeat.m2505o(27858);
        return str;
    }

    public int getSelectionStart() {
        AppMethodBeat.m2504i(27859);
        int selectionStart = this.oij.getSelectionStart();
        AppMethodBeat.m2505o(27859);
        return selectionStart;
    }

    public char getCharAtCursor() {
        AppMethodBeat.m2504i(27860);
        int selectionStart = getSelectionStart();
        if (selectionStart <= 0) {
            AppMethodBeat.m2505o(27860);
            return 'x';
        }
        char charAt = getLastText().charAt(selectionStart - 1);
        AppMethodBeat.m2505o(27860);
        return charAt;
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.m2504i(27861);
        this.vnw = new C35869f(textWatcher);
        this.oij.addTextChangedListener(this.vnw);
        AppMethodBeat.m2505o(27861);
    }

    /* renamed from: Le */
    public final void mo63901Le(int i) {
        AppMethodBeat.m2504i(27862);
        this.vnx = 0;
        int fromDPToPix = C1338a.fromDPToPix(getContext(), 180);
        int b = C4977b.m7371b(getContext(), 50.0f);
        if (i + b < fromDPToPix) {
            this.vnx = -1;
        } else {
            this.vnx = ((i - fromDPToPix) / 2) + b;
        }
        if (this.szb == null) {
            this.szb = new C46633o(View.inflate(getContext(), 2130971021, null), -1, -2);
            this.miH = (ImageView) this.szb.getContentView().findViewById(2131823958);
            this.miI = this.szb.getContentView().findViewById(2131823956);
            this.miJ = this.szb.getContentView().findViewById(2131823960);
            this.szc = (TextView) this.szb.getContentView().findViewById(2131823962);
            this.szd = (ImageView) this.szb.getContentView().findViewById(2131823961);
            this.sze = this.szb.getContentView().findViewById(2131828470);
            this.miF = this.szb.getContentView().findViewById(2131823955);
            this.miG = this.szb.getContentView().findViewById(2131823963);
            this.vnd = (TextView) this.szb.getContentView().findViewById(2131828469);
        }
        if (this.vnx != -1) {
            this.miG.setVisibility(8);
            this.miF.setVisibility(8);
            this.sze.setVisibility(0);
            new C7306ak().post(new C4046816());
            this.szb.showAtLocation(this, 49, 0, this.vnx);
        }
        AppMethodBeat.m2505o(27862);
    }

    public void setRecordNormalWording(String str) {
        AppMethodBeat.m2504i(27863);
        if (str == null || this.vnd == null) {
            AppMethodBeat.m2505o(27863);
            return;
        }
        this.vnd.setText(str);
        AppMethodBeat.m2505o(27863);
    }

    public final void dki() {
        AppMethodBeat.m2504i(27864);
        this.sze.setVisibility(8);
        this.miF.setVisibility(0);
        AppMethodBeat.m2505o(27864);
    }

    public final void bvH() {
        AppMethodBeat.m2504i(27865);
        post(new C4047617());
        AppMethodBeat.m2505o(27865);
    }

    /* renamed from: Lf */
    public final void mo63902Lf(int i) {
        AppMethodBeat.m2504i(27866);
        int i2 = 0;
        while (i2 < gcc.length) {
            if (i >= miN[i2] && i < miN[i2 + 1]) {
                this.miH.setBackgroundDrawable(C1338a.m2864g(getContext(), gcc[i2]));
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
        AppMethodBeat.m2505o(27866);
    }

    public void setMode(int i) {
        AppMethodBeat.m2504i(27867);
        mo63907az(i, true);
        AppMethodBeat.m2505o(27867);
    }

    /* renamed from: Lg */
    private void m69485Lg(int i) {
        AppMethodBeat.m2504i(27868);
        this.vnf = i;
        switch (i) {
            case 1:
                this.vmU.setVisibility(0);
                this.vmO.setVisibility(8);
                m69484Ld(C25738R.drawable.f6585iy);
                AppMethodBeat.m2505o(27868);
                return;
            case 2:
                this.vmU.setVisibility(8);
                this.vmO.setVisibility(0);
                m69484Ld(C25738R.drawable.f6584ix);
                if (C1853r.m3852Zf().booleanValue() && this.vnl != null) {
                    C35866c c35866c = this.vnl;
                    Boolean bool = Boolean.TRUE;
                    c35866c.mo27787b(bool, bool);
                    break;
                }
        }
        AppMethodBeat.m2505o(27868);
    }

    /* renamed from: az */
    public final void mo63907az(int i, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(27869);
        m69485Lg(i);
        switch (i) {
            case 1:
                mo63957oP(true);
                if (z) {
                    showVKB();
                    if (this.oij.length() <= 0) {
                        z2 = false;
                    }
                    m69508iP(z2);
                    AppMethodBeat.m2505o(27869);
                    return;
                }
                if (this.oij.length() <= 0) {
                    z2 = false;
                }
                m69508iP(z2);
                AppMethodBeat.m2505o(27869);
                return;
            case 2:
                mo63995u(0, -1, false);
                m69508iP(false);
                AppMethodBeat.m2505o(27869);
                return;
            default:
                setVisibility(0);
                AppMethodBeat.m2505o(27869);
                return;
        }
    }

    public final void dkj() {
        AppMethodBeat.m2504i(27870);
        this.vmU.setVisibility(0);
        this.vmP.setVisibility(8);
        this.vmO.setVisibility(8);
        AppMethodBeat.m2505o(27870);
    }

    public final void dkk() {
        AppMethodBeat.m2504i(27871);
        if (this.vmP != null) {
            this.vmP.setVisibility(0);
        }
        AppMethodBeat.m2505o(27871);
    }

    public final void dkl() {
        AppMethodBeat.m2504i(27872);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vml.value = false;
        appPanel.djQ();
        AppMethodBeat.m2505o(27872);
    }

    public final void dkm() {
        AppMethodBeat.m2504i(27873);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vmD.value = false;
        appPanel.djQ();
        AppMethodBeat.m2505o(27873);
    }

    public final void dkn() {
        AppMethodBeat.m2504i(27874);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vmm.value = false;
        appPanel.djQ();
        AppMethodBeat.m2505o(27874);
    }

    public final void dko() {
        AppMethodBeat.m2504i(27875);
        AppPanel appPanel = this.vmM;
        appPanel.vlP.vmp.value = false;
        appPanel.djQ();
        AppMethodBeat.m2505o(27875);
    }

    /* renamed from: ac */
    public final void mo63904ac(boolean z, boolean z2) {
        AppMethodBeat.m2504i(27876);
        this.vmM.mo63885oF(z);
        this.vmM.mo63886oG(z2);
        AppMethodBeat.m2505o(27876);
    }

    /* renamed from: oH */
    public final void mo63955oH(boolean z) {
        AppMethodBeat.m2504i(27877);
        this.vmM.mo63887oH(z);
        AppMethodBeat.m2505o(27877);
    }

    /* renamed from: oI */
    public final void mo63956oI(boolean z) {
        AppMethodBeat.m2504i(27878);
        this.vmM.mo63888oI(z);
        AppMethodBeat.m2505o(27878);
    }

    public final void dkp() {
        AppMethodBeat.m2504i(27879);
        AppPanel appPanel = this.vmM;
        appPanel.vlX = true;
        appPanel.vlP.mo48403oN(false);
        appPanel.djQ();
        C4990ab.m7417i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", C5046bo.dpG().toString());
        AppMethodBeat.m2505o(27879);
    }

    public final void dkq() {
        AppMethodBeat.m2504i(27880);
        AppPanel appPanel = this.vmM;
        appPanel.vlY = true;
        appPanel.vlP.mo48400oK(false);
        appPanel.djQ();
        C4990ab.m7417i("MicroMsg.AppPanel", "disableServiceRemittance %s", C5046bo.dpG().toString());
        AppMethodBeat.m2505o(27880);
    }

    public final void dkr() {
        AppMethodBeat.m2504i(27881);
        if (this.vmT != null) {
            this.vmT.setVisibility(8);
        }
        AppMethodBeat.m2505o(27881);
    }

    public final void dks() {
        AppMethodBeat.m2504i(27882);
        AppPanel appPanel = this.vmM;
        appPanel.vlZ = true;
        appPanel.vlP.mo48404oO(false);
        appPanel.djQ();
        AppMethodBeat.m2505o(27882);
    }

    public final void dkt() {
        AppMethodBeat.m2504i(27883);
        C4990ab.m7416i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.vnh = true;
        this.oij.setImeOptions(4);
        this.oij.setInputType(this.oij.getInputType() & -65);
        AppMethodBeat.m2505o(27883);
    }

    private void dku() {
        AppMethodBeat.m2504i(27884);
        this.gbS.findViewById(2131822418).setVisibility(0);
        AppMethodBeat.m2505o(27884);
    }

    private void dkv() {
        AppMethodBeat.m2504i(27885);
        C4990ab.m7416i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
        this.vnh = false;
        this.oij.setImeOptions(0);
        this.oij.setInputType(this.oij.getInputType() | 64);
        AppMethodBeat.m2505o(27885);
    }

    public int getMode() {
        return this.vnf;
    }

    public final void dkw() {
        AppMethodBeat.m2504i(27886);
        if (!(this.vmQ.dkH() || this.eAk == null)) {
            this.eAk.refresh();
        }
        AppMethodBeat.m2505o(27886);
    }

    public void setAppPanelVisible(int i) {
        AppMethodBeat.m2504i(27887);
        if (this.vmM != null) {
            this.vmM.setVisibility(i);
        }
        setAppPanelTipVisible(i == 0);
        AppMethodBeat.m2505o(27887);
    }

    public final void djS() {
        AppMethodBeat.m2504i(27888);
        C4990ab.m7416i("MicroMsg.ChatFooter", "[dealOrientationChange]");
        djq();
        dkB();
        this.vnz = true;
        this.vnj = C40619x.m70075gu(this.context);
        dkw();
        AppMethodBeat.m2505o(27888);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(27889);
        super.onConfigurationChanged(configuration);
        C4990ab.m7417i("MicroMsg.ChatFooter", "onConfigurationChanged: %s", configuration);
        m69486Lh(getKeyBordHeightPX());
        AppMethodBeat.m2505o(27889);
    }

    public void setBottomPanelVisibility(int i) {
        AppMethodBeat.m2504i(27890);
        if (i == 0) {
            this.vmQ.setVisibility(i);
            AppMethodBeat.m2505o(27890);
            return;
        }
        dkA();
        AppMethodBeat.m2505o(27890);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dkx() {
        AppMethodBeat.m2504i(27891);
        if (this.vnp == null || this.vnp.getView() == null) {
            AppMethodBeat.m2505o(27891);
            return false;
        }
        View findViewById = this.vnp.getView().findViewById(2131825953);
        if (findViewById == null) {
            AppMethodBeat.m2505o(27891);
            return false;
        }
        int safeInsetLeft;
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        if (C1443d.m3068iW(28)) {
            DisplayCutout displayCutout = findViewById.getRootWindowInsets().getDisplayCutout();
            if (displayCutout != null) {
                safeInsetLeft = displayCutout.getSafeInsetLeft();
                if (rect.left <= safeInsetLeft) {
                    AppMethodBeat.m2505o(27891);
                    return true;
                }
                AppMethodBeat.m2505o(27891);
                return false;
            }
        }
        safeInsetLeft = 0;
        if (rect.left <= safeInsetLeft) {
        }
    }

    public final boolean dky() {
        AppMethodBeat.m2504i(27892);
        if (this.vmQ.getVisibility() == 0) {
            AppMethodBeat.m2505o(27892);
            return true;
        }
        AppMethodBeat.m2505o(27892);
        return false;
    }

    public void setWordCountLimit(int i) {
        AppMethodBeat.m2504i(27893);
        this.vmN = (TextView) this.gbS.findViewById(2131822419);
        this.oij.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.m2505o(27893);
    }

    @TargetApi(11)
    public void setEditTextOnDragListener(OnDragListener onDragListener) {
        AppMethodBeat.m2504i(27894);
        this.oij.setOnDragListener(onDragListener);
        AppMethodBeat.m2505o(27894);
    }

    public void setOnEditFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.m2504i(27895);
        this.oij.setOnFocusChangeListener(onFocusChangeListener);
        AppMethodBeat.m2505o(27895);
    }

    public void setAppPanelListener(C14934a c14934a) {
        AppMethodBeat.m2504i(27896);
        this.vmM.setAppPanelListener(c14934a);
        AppMethodBeat.m2505o(27896);
    }

    public void setSetTolastCustomPage(boolean z) {
    }

    public void setOnFooterSwitchListener(C35868e c35868e) {
        AppMethodBeat.m2504i(27897);
        this.vmZ = c35868e;
        if (c35868e == null) {
            AppMethodBeat.m2505o(27897);
            return;
        }
        View findViewById = findViewById(2131822409);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new C3011919());
        AppMethodBeat.m2505o(27897);
    }

    public void setSwitchButtonMode(int i) {
        AppMethodBeat.m2504i(27898);
        if (i == this.vnA) {
            AppMethodBeat.m2505o(27898);
            return;
        }
        this.vnA = i;
        ImageView imageView = (ImageView) findViewById(2131822410);
        ImageView imageView2 = (ImageView) findViewById(2131822411);
        if (this.vnA == 1) {
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            AppMethodBeat.m2505o(27898);
            return;
        }
        imageView.setVisibility(0);
        imageView2.setVisibility(8);
        AppMethodBeat.m2505o(27898);
    }

    public int getSmieyType() {
        return 0;
    }

    @TargetApi(11)
    public void setToSendTextColor(final boolean z) {
        AppMethodBeat.m2504i(27899);
        if (C1443d.m3068iW(11)) {
            C41933a.m74069a(11, new C41932a() {
                public final void run() {
                    AppMethodBeat.m2504i(27811);
                    Message message = new Message();
                    message.what = 1002;
                    message.obj = Boolean.valueOf(z);
                    ChatFooter.this.mHandler.sendMessage(message);
                    AppMethodBeat.m2505o(27811);
                }
            });
            AppMethodBeat.m2505o(27899);
        } else if (z) {
            this.oij.setTextColor(getResources().getColor(C25738R.color.a7r));
            AppMethodBeat.m2505o(27899);
        } else {
            this.oij.setTextColor(getResources().getColor(C25738R.color.f12084rr));
            mo63957oP(false);
            AppMethodBeat.m2505o(27899);
        }
    }

    public final void dkz() {
        AppMethodBeat.m2504i(27900);
        showVKB();
        mo63957oP(true);
        AppMethodBeat.m2505o(27900);
    }

    /* renamed from: oQ */
    public final void mo63958oQ(boolean z) {
        AppMethodBeat.m2504i(27901);
        hideVKB();
        mo63957oP(z);
        AppMethodBeat.m2505o(27901);
    }

    public final void dkA() {
        AppMethodBeat.m2504i(27902);
        mo63995u(2, 20, false);
        AppMethodBeat.m2505o(27902);
    }

    public final void showVKB() {
        AppMethodBeat.m2504i(27903);
        if (!(this.vnp == null || !this.vnp.isSupportNavigationSwipeBack() || this.vnp.getSwipeBackLayout() == null)) {
            this.vnp.getSwipeBackLayout().setOnceDisEnableGesture(true);
        }
        post(new C3585923());
        AppMethodBeat.m2505o(27903);
    }

    public final boolean hideVKB() {
        AppMethodBeat.m2504i(27904);
        if (getKeyBordHeightPX() / 2 <= getBottom()) {
            boolean hideVKB = C5046bo.hideVKB(this);
            AppMethodBeat.m2505o(27904);
            return hideVKB;
        }
        AppMethodBeat.m2505o(27904);
        return false;
    }

    /* renamed from: u */
    public final void mo63995u(int i, int i2, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(27905);
        if (!z) {
            this.vmS.setContentDescription(getContext().getString(C25738R.string.air));
            switch (i) {
                case 0:
                    hideVKB();
                    mo63957oP(false);
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
        if (C1853r.m3852Zf().booleanValue() && this.vnl != null) {
            this.vnl.mo27786a(Boolean.TRUE, Boolean.FALSE);
            this.vnl.mo27787b(Boolean.TRUE, Boolean.FALSE);
        }
        this.vmS.setContentDescription(getContext().getString(C25738R.string.aiq));
        switch (i) {
            case 1:
                getInputPanelHelper().mo64518az(new C474824());
                if (!C40619x.m70075gu(this.context) || isInMultiWindowMode()) {
                    this.vmQ.setVisibility(8);
                }
                mo63957oP(true);
                setToSendTextColor(true);
                this.vne.showSoftInput(this.oij, 0);
                break;
            case 2:
                m69486Lh(getKeyBordHeightPX());
                if (i2 == 22) {
                    if (this.vmM == null) {
                        dkg();
                    }
                    this.vmM.djT();
                    if (this.eAk != null) {
                        this.eAk.setVisibility(8);
                    }
                    C4990ab.m7416i("MicroMsg.ChatFooter", "show app panel");
                    setAppPanelVisible(0);
                    this.vmW.dkJ();
                    mo63957oP(false);
                    if (this.vnf == 2) {
                        m69485Lg(1);
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
                    m69515oR(true);
                    mo63957oP(true);
                }
                if (cth() && C40619x.m70075gu(getContext()) && !isInMultiWindowMode()) {
                    getInputPanelHelper().mo64517aA(new C474925());
                    C4990ab.m7416i("MicroMsg.ChatFooter", "bottom panel will show lately");
                } else {
                    this.vmQ.setVisibility(0);
                }
                if (!(cth() && C40619x.m70075gu(getContext()))) {
                    LayoutParams layoutParams = this.vmQ.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == 0) {
                        layoutParams.height = C40619x.m70073gs(getContext());
                        C4990ab.m7412e("MicroMsg.ChatFooter", "configPannel():bottomPanel height:" + layoutParams.height);
                        this.vmQ.setLayoutParams(layoutParams);
                    }
                }
                hideVKB();
                break;
            case 3:
                this.vmQ.setIsHide(true);
                if (!C40619x.m70075gu(this.context)) {
                    this.vmQ.setVisibility(8);
                }
                mo63957oP(true);
                setToSendTextColor(true);
                break;
            default:
                z = false;
                break;
        }
        if (!((!z || i2 == 21 || this.vmT == null) && (this.vmT == null || z || (i2 != 21 && i2 != 20)))) {
            m69515oR(false);
        }
        if (i != 0 || z) {
            if (z && i2 != 22) {
                if (this.oij.length() <= 0) {
                    z2 = false;
                }
                m69508iP(z2);
            }
            AppMethodBeat.m2505o(27905);
            return;
        }
        m69515oR(false);
        AppMethodBeat.m2505o(27905);
    }

    public final boolean cth() {
        AppMethodBeat.m2504i(27906);
        C4990ab.m7417i("MicroMsg.ChatFooter", "is show key board %d, %d, %d", Integer.valueOf(this.jZl), Integer.valueOf(this.jZk), Integer.valueOf(C5222ae.m7944fr(this.context)));
        if (this.jZl <= 0 || this.jZl >= this.jZk - r2) {
            AppMethodBeat.m2505o(27906);
            return false;
        }
        AppMethodBeat.m2505o(27906);
        return true;
    }

    @TargetApi(24)
    private boolean isInMultiWindowMode() {
        AppMethodBeat.m2504i(27907);
        if ((getContext() instanceof Activity) && C1443d.m3068iW(24)) {
            C4990ab.m7417i("MicroMsg.ChatFooter", "isInMultiWindow %b ", Boolean.valueOf(((Activity) getContext()).isInMultiWindowMode()));
            AppMethodBeat.m2505o(27907);
            return ((Activity) getContext()).isInMultiWindowMode();
        }
        AppMethodBeat.m2505o(27907);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(27908);
        String str = "MicroMsg.ChatFooter";
        String str2 = "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d softInputMode:%s";
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(i4);
        objArr[5] = Integer.valueOf(this.activity == null ? 0 : this.activity.getWindow().getAttributes().softInputMode);
        C4990ab.m7417i(str, str2, objArr);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        if (getTop() != 0) {
            if (getTop() > this.vnK) {
                this.vnK = getTop();
            }
            if (this.vnK - getTop() > 50) {
                if (this.vmY != null) {
                    this.vmY.mo39005iS(true);
                }
            } else if (this.vmY != null) {
                this.vmY.mo39005iS(false);
            }
        }
        if (z) {
            if (this.vmX != null) {
                C44084m c44084m = this.vmX;
                if (c44084m.voE.isShowing()) {
                    c44084m.voE.dismiss();
                    c44084m.dkL();
                }
            }
            AppMethodBeat.m2505o(27908);
            return;
        }
        AppMethodBeat.m2505o(27908);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(27909);
        C4990ab.m7411d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", Integer.valueOf(MeasureSpec.getSize(i2)), Integer.valueOf(getMeasuredHeight()));
        super.onMeasure(i, i2);
        C4990ab.m7411d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", Integer.valueOf(getMeasuredHeight()));
        AppMethodBeat.m2505o(27909);
    }

    /* renamed from: m */
    public final void mo39878m(boolean z, int i) {
        AppMethodBeat.m2504i(27910);
        super.mo39878m(z, i);
        if (this.vnJ != i) {
            this.vnJ = i;
            C18175j.m28620x(getContext(), i);
            m69486Lh(getKeyBordHeightPX());
        }
        AppMethodBeat.m2505o(27910);
    }

    public int getKeyBordHeightPX() {
        AppMethodBeat.m2504i(27911);
        int gs = C40619x.m70073gs(getContext());
        AppMethodBeat.m2505o(27911);
        return gs;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(27912);
        super.onSizeChanged(i, i2, i3, i4);
        C4990ab.m7411d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.m2505o(27912);
    }

    /* renamed from: oR */
    private void m69515oR(boolean z) {
        AppMethodBeat.m2504i(27913);
        if (this.vmT == null) {
            AppMethodBeat.m2505o(27913);
        } else if (this.vnM && z) {
            AppMethodBeat.m2505o(27913);
        } else if (this.vnM || z) {
            this.vnM = z;
            if (z) {
                this.vmT.setImageDrawable(getContext().getResources().getDrawable(C25738R.drawable.f6584ix));
                AppMethodBeat.m2505o(27913);
                return;
            }
            this.vmT.setImageDrawable(getContext().getResources().getDrawable(C25738R.drawable.f6583iv));
            AppMethodBeat.m2505o(27913);
        } else {
            AppMethodBeat.m2505o(27913);
        }
    }

    private void dkB() {
        AppMethodBeat.m2504i(27914);
        this.vmQ.setVisibility(8);
        setAppPanelVisible(8);
        if (this.eAk != null) {
            this.eAk.setVisibility(8);
        }
        m69515oR(false);
        AppMethodBeat.m2505o(27914);
    }

    /* renamed from: Lh */
    private void m69486Lh(int i) {
        int e;
        AppMethodBeat.m2504i(27915);
        C4990ab.m7417i("MicroMsg.ChatFooter", "[refreshBootomHeight] keyborPx:%d", Integer.valueOf(i));
        C40619x.dod();
        if (C7616ad.aox(this.vmL) || C7616ad.aoy(this.vmL)) {
            e = C40619x.m70069e(this.context, i, 43);
        } else {
            e = C40619x.m70067at(this.context, i);
        }
        if (e > 0 && this.vmQ != null) {
            C4990ab.m7411d("MicroMsg.ChatFooter", "set bottom panel height: %d", Integer.valueOf(e));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.height = e;
            C4990ab.m7412e("MicroMsg.ChatFooter", "refreshBootomHeight:bottomPanel height:" + layoutParams.height);
            this.vmQ.setLayoutParams(layoutParams);
        }
        if (this.vmM != null) {
            this.vmM.setPortHeighPx(e);
            this.vmM.mo63871AG();
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
            this.eAk.mo11690AG();
        }
        AppMethodBeat.m2505o(27915);
    }

    public final void dkC() {
        AppMethodBeat.m2504i(27916);
        this.miB = false;
        this.vmO.setBackgroundDrawable(C1338a.m2864g(getContext(), C25738R.drawable.a7m));
        this.vmO.setText(C25738R.string.ajl);
        if (this.vmY != null) {
            if (this.miJ == null || this.miJ.getVisibility() != 0) {
                this.vmY.bNG();
            } else {
                this.vmY.bNI();
                AppMethodBeat.m2505o(27916);
                return;
            }
        }
        AppMethodBeat.m2505o(27916);
    }

    public final boolean dkD() {
        AppMethodBeat.m2504i(27917);
        if (this.vnK - getTop() > 50) {
            AppMethodBeat.m2505o(27917);
            return true;
        }
        AppMethodBeat.m2505o(27917);
        return false;
    }

    public void setUserName(String str) {
        AppMethodBeat.m2504i(27918);
        this.vmL = str;
        if (this.eAk != null) {
            this.eAk.setTalkerName(this.vmL);
        }
        String str2 = "MicroMsg.ChatFooter";
        String str3 = "setusername: %s, %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.vmM != null);
        C4990ab.m7417i(str2, str3, objArr);
        if (this.vmM != null) {
            if (C1855t.m3923nI(this.vmL) || C1855t.m3916nB(this.vmL)) {
                this.vmM.setServiceShowFlag(0);
            } else if (C1855t.m3913mZ(this.vmL)) {
                this.vmM.setServiceShowFlag(4);
            } else if (C1855t.m3896kH(this.vmL)) {
                this.vmM.setServiceShowFlag(2);
            } else {
                this.vmM.setServiceShowFlag(1);
            }
        }
        if (C7616ad.aox(this.vmL) || C7616ad.aoy(this.vmL)) {
            m69486Lh(-1);
        }
        AppMethodBeat.m2505o(27918);
    }

    public final void dkE() {
        AppMethodBeat.m2504i(27919);
        C9638aw.m17190ZK();
        this.vno = ((Boolean) C18628c.m29072Ry().get(66832, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(27919);
    }

    public void setCattingRootLayoutId(int i) {
        this.vnU = null;
        this.vnT = i;
    }

    public void onGlobalLayout() {
        AppMethodBeat.m2504i(27920);
        if (this.activity == null || this.activity.getWindow() == null || this.activity.getWindow().getDecorView() == null) {
            AppMethodBeat.m2505o(27920);
        } else if (this.vnT == -1) {
            C4990ab.m7420w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
            AppMethodBeat.m2505o(27920);
        } else {
            if (this.vnU == null) {
                this.vnU = this.activity.getWindow().getDecorView().findViewById(this.vnT);
            }
            if (this.vnU == null) {
                C4990ab.m7413e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", Integer.valueOf(this.vnT));
                AppMethodBeat.m2505o(27920);
                return;
            }
            int height = this.vnU.getHeight();
            int width = this.vnU.getWidth();
            C4990ab.m7411d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", Integer.valueOf(this.vnU.getMeasuredHeight()), Integer.valueOf(height));
            if (this.f16200dj < height) {
                this.f16200dj = height;
            }
            this.vnL = height;
            if (this.vnR <= 0) {
                this.vnR = height;
                AppMethodBeat.m2505o(27920);
            } else if (this.vnS <= 0) {
                this.vnS = width;
                AppMethodBeat.m2505o(27920);
            } else if (this.vnR == height && this.vnS == width) {
                AppMethodBeat.m2505o(27920);
            } else {
                if (cth() && this.vnr) {
                    this.vnr = false;
                    C4990ab.m7410d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                    postDelayed(new C3585721(), 10);
                }
                C4990ab.m7411d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", Integer.valueOf(this.vnR), Integer.valueOf(height));
                int fr = C5222ae.m7944fr(this.context);
                int abs = Math.abs(this.vnR - height);
                if (abs > fr) {
                    this.vnR = height;
                }
                height = Math.abs(this.vnS - width);
                this.vnS = width;
                C4990ab.m7417i("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", Integer.valueOf(height));
                if (this.vnV && height != 0) {
                    if (this.vmM != null) {
                        this.vmM.setNeedRefreshHeight(true);
                        this.vmM.djS();
                    }
                    if (this.eAk != null) {
                        this.eAk.setPortHeightPx(C40619x.m70073gs(this.context));
                        dkw();
                        this.eAk.mo11690AG();
                    }
                }
                C4990ab.m7410d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: ".concat(String.valueOf(abs)));
                AppMethodBeat.m2505o(27920);
            }
        }
    }

    public int getYFromBottom() {
        AppMethodBeat.m2504i(27921);
        int gs = C40619x.m70073gs(getContext());
        int height = getHeight();
        if (height < gs) {
            height += gs;
            AppMethodBeat.m2505o(27921);
            return height;
        }
        AppMethodBeat.m2505o(27921);
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
        AppMethodBeat.m2504i(27854);
        mo63996u(str, -1, true);
        AppMethodBeat.m2505o(27854);
    }

    /* renamed from: a */
    static /* synthetic */ void m69491a(ChatFooter chatFooter, int i, String str) {
        AppMethodBeat.m2504i(27924);
        if (C5046bo.isNullOrNil(chatFooter.vnq.getTalkerUserName())) {
            C4990ab.m7412e("MicroMsg.ChatFooter", "doSendImage : talker is null");
            AppMethodBeat.m2505o(27924);
        } else if (str == null || str.equals("") || !C1173e.m2561ct(str)) {
            C4990ab.m7412e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
            AppMethodBeat.m2505o(27924);
        } else {
            C9638aw.m17182Rg().mo14541a(new C9022l(4, C1853r.m3846Yz(), chatFooter.vnq.getTalkerUserName(), str, i, null, 0, "", "", true, C25738R.drawable.b0p), 0);
            AppMethodBeat.m2505o(27924);
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m69509j(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27926);
        chatFooter.postDelayed(new C475026(), 10);
        AppMethodBeat.m2505o(27926);
    }

    /* renamed from: r */
    static /* synthetic */ void m69518r(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27929);
        if (chatFooter.vnf == 1) {
            C4990ab.m7417i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")), C5046bo.dpG(), chatFooter.activity);
            if (C35805b.m58707a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                chatFooter.setMode(2);
                AppMethodBeat.m2505o(27929);
                return;
            }
        }
        chatFooter.setMode(1);
        if (chatFooter.vmY != null) {
            chatFooter.vmY.mo39005iS(true);
            chatFooter.vmY.mo38998I(null);
        }
        AppMethodBeat.m2505o(27929);
    }

    /* renamed from: D */
    static /* synthetic */ void m69475D(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27932);
        if (C35973a.m59179bJ(chatFooter.context) || C35973a.m59177bH(chatFooter.context)) {
            C4990ab.m7410d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            AppMethodBeat.m2505o(27932);
            return;
        }
        chatFooter.findViewById(2131822408).setVisibility(8);
        chatFooter.vnf = 1;
        chatFooter.oij.setVisibility(8);
        chatFooter.vmO.setVisibility(8);
        chatFooter.m69484Ld(C25738R.drawable.f6585iy);
        if (chatFooter.eAk != null) {
            chatFooter.eAk.setVisibility(8);
        }
        chatFooter.setAppPanelVisible(8);
        chatFooter.vmQ.setVisibility(0);
        chatFooter.mo63957oP(false);
        if (chatFooter.viY == null) {
            chatFooter.viY = new C40482n(chatFooter.getContext(), false, null);
            chatFooter.vmQ.addView(chatFooter.viY, new LinearLayout.LayoutParams(-1, -1));
            chatFooter.viY.setCallback(new C2328614());
            if (chatFooter.vmM.getHeight() > 0) {
                chatFooter.viY.setPortHeightPX(chatFooter.vmM.getHeight());
            } else {
                chatFooter.viY.setPortHeightPX(C40619x.m70073gs(chatFooter.context));
            }
        }
        chatFooter.viY.dkM();
        chatFooter.viY.setToUser(chatFooter.toUser);
        chatFooter.viY.djT();
        chatFooter.viY.setVisibility(0);
        chatFooter.vjb = true;
        AppMethodBeat.m2505o(27932);
    }

    /* renamed from: M */
    static /* synthetic */ void m69487M(ChatFooter chatFooter) {
        AppMethodBeat.m2504i(27936);
        chatFooter.vnQ.removeMessages(4097);
        chatFooter.vnQ.sendEmptyMessageDelayed(4097, 1);
        AppMethodBeat.m2505o(27936);
    }
}
