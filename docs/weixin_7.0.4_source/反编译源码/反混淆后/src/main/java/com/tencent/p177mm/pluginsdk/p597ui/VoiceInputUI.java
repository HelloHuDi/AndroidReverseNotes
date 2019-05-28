package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C18410uc;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.p177mm.plugin.report.kvdata.log_13905;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputFooter.C30097a;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputFooter.C358206;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputFooter.C358211;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputFooter.C358222;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C40482n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputUI */
public class VoiceInputUI extends MMActivity {
    private String bzH;
    private Button lcu;
    private int offset;
    private int textChangeCount = 0;
    private String userCode;
    private long vjA = 0;
    private boolean vjB = true;
    private boolean vjC = false;
    private OnTouchListener vjD = new C149122();
    private OnMenuItemClickListener vjE = new C149133();
    private C30097a vjF = new C149114();
    private MMEditText vjx;
    private VoiceInputFooter vjy;
    private String vjz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputUI$6 */
    class C149096 implements OnClickListener {
        C149096() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27612);
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            voiceInputBehavior.send = 3;
            VoiceInputUI.m23179b(voiceInputBehavior);
            VoiceInputUI.this.mo27230KP(7);
            AppMethodBeat.m2505o(27612);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputUI$1 */
    class C149101 implements OnMenuItemClickListener {
        C149101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(27606);
            VoiceInputUI.this.mo27230KP(1);
            AppMethodBeat.m2505o(27606);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputUI$4 */
    class C149114 implements C30097a {
        C149114() {
        }

        /* renamed from: oA */
        public final void mo27233oA(boolean z) {
            AppMethodBeat.m2504i(27609);
            if (z) {
                VoiceInputUI.this.lcu.setVisibility(4);
                AppMethodBeat.m2505o(27609);
                return;
            }
            VoiceInputUI.this.lcu.setVisibility(0);
            AppMethodBeat.m2505o(27609);
        }

        public final void djs() {
            AppMethodBeat.m2504i(27610);
            VoiceInputUI.this.mo27230KP(8);
            AppMethodBeat.m2505o(27610);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputUI$2 */
    class C149122 implements OnTouchListener {
        C149122() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27607);
            if (motionEvent.getAction() == 0) {
                VoiceInputUI.this.textChangeCount = VoiceInputUI.this.textChangeCount + 1;
            } else if (motionEvent.getAction() == 1) {
                VoiceInputFooter b;
                if (VoiceInputUI.this.vjy.djp()) {
                    b = VoiceInputUI.this.vjy;
                    b.djq();
                    b.setVisibility(8);
                }
                if (VoiceInputUI.this.vjy.aYV()) {
                    b = VoiceInputUI.this.vjy;
                    b.aRe();
                    b.setVisibility(8);
                }
                b = VoiceInputUI.this.vjy;
                b.setVisibility(0);
                if (b.viZ != null) {
                    b.viZ.setImageResource(C25738R.drawable.f6583iv);
                }
            }
            AppMethodBeat.m2505o(27607);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputUI$3 */
    class C149133 implements OnMenuItemClickListener {
        C149133() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(27608);
            VoiceInputUI.this.vjx.setText("");
            VoiceInputUI.this.vjC = true;
            VoiceInputUI.this.mo27230KP(6);
            AppMethodBeat.m2505o(27608);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputUI$5 */
    class C149145 implements TextWatcher {
        C149145() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(27611);
            C4990ab.m7411d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", Boolean.valueOf(VoiceInputUI.this.vjB), Boolean.valueOf(VoiceInputUI.this.vjC));
            if (VoiceInputUI.this.vjB) {
                VoiceInputUI.this.vjB = false;
                AppMethodBeat.m2505o(27611);
                return;
            }
            VoiceInputUI.this.vjC = true;
            VoiceInputUI.this.vjx.requestLayout();
            AppMethodBeat.m2505o(27611);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VoiceInputUI() {
        AppMethodBeat.m2504i(27613);
        AppMethodBeat.m2505o(27613);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(27614);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        Intent intent = getIntent();
        if (intent != null) {
            this.bzH = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
            this.vjz = intent.getStringExtra("punctuation");
            this.userCode = intent.getStringExtra("userCode");
        }
        this.vjA = C5046bo.m7588yz();
        this.textChangeCount = 0;
        this.vjC = false;
        this.vjB = true;
        this.vjx = (MMEditText) findViewById(2131828455);
        this.lcu = (Button) findViewById(2131828454);
        this.vjx.addTextChangedListener(new C149145());
        this.lcu.setOnClickListener(new C149096());
        setMMTitle(getString(C25738R.string.f2c));
        enableOptionMenu(true);
        setBackBtn(new C149101());
        this.vjx.setOnTouchListener(this.vjD);
        this.vjx.asB(this.bzH);
        if (this.offset != -1) {
            this.vjx.setSelection(this.offset);
        }
        this.vjy = (VoiceInputFooter) findViewById(2131827849);
        VoiceInputFooter voiceInputFooter = this.vjy;
        MMEditText mMEditText = this.vjx;
        String str = this.vjz;
        String str2 = this.userCode;
        voiceInputFooter.jZg = mMEditText;
        mMEditText.setOnClickListener(new C358211());
        mMEditText.setOnEditorActionListener(new C358222());
        if (voiceInputFooter.viY == null) {
            voiceInputFooter.viY = new C40482n(voiceInputFooter.getContext(), true, voiceInputFooter.jZg);
            voiceInputFooter.viY.setCallback(new C358206());
            voiceInputFooter.viY.setPortHeightPX(C40619x.m70073gs(voiceInputFooter.getContext()));
        }
        voiceInputFooter.viY.dkM();
        voiceInputFooter.viY.djT();
        voiceInputFooter.viY.setVisibility(8);
        voiceInputFooter.viY.setToUser(str2);
        voiceInputFooter.viY.setFullScreenData(str);
        voiceInputFooter.oDC.addView(voiceInputFooter.viY, -1, 0);
        this.vjy.setVoiceInputFooterListener(this.vjF);
        AppMethodBeat.m2505o(27614);
    }

    public void onResume() {
        AppMethodBeat.m2504i(27615);
        super.onResume();
        this.vjx.requestFocus();
        AppMethodBeat.m2505o(27615);
    }

    public void onPause() {
        AppMethodBeat.m2504i(27616);
        super.onPause();
        AppMethodBeat.m2505o(27616);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(27617);
        super.onDestroy();
        AppMethodBeat.m2505o(27617);
    }

    public final int getLayoutId() {
        return 2130971012;
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(27618);
        mo27230KP(3);
        super.onSwipeBack();
        AppMethodBeat.m2505o(27618);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(27619);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            mo27230KP(2);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(27619);
        return onKeyDown;
    }

    /* renamed from: KP */
    public final void mo27230KP(int i) {
        AppMethodBeat.m2504i(27620);
        C4990ab.m7417i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", Integer.valueOf(i), C5046bo.dpG().toString());
        if (i == 8) {
            m23186kT(7);
        } else {
            m23186kT(i);
        }
        C18410uc c18410uc = new C18410uc();
        if (i == 7) {
            c18410uc.cQk.action = 1;
        } else if (i == 8) {
            c18410uc.cQk.action = 4;
        } else {
            c18410uc.cQk.action = 2;
        }
        if (this.vjC) {
            c18410uc.cQk.cQl = 1;
        } else {
            c18410uc.cQk.cQl = 2;
        }
        c18410uc.cQk.result = this.vjx.getText().toString();
        c18410uc.cQk.userCode = this.userCode;
        if (this.vjy != null) {
            this.vjy.release();
        }
        C4879a.xxA.mo10055m(c18410uc);
        C5046bo.hideVKB(this.vjx);
        super.finish();
        AppMethodBeat.m2505o(27620);
    }

    /* renamed from: a */
    private static void m23177a(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.m2504i(27621);
        C4990ab.m7417i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        C7060h.pYm.mo15417c(13905, log_13905);
        AppMethodBeat.m2505o(27621);
    }

    /* renamed from: kT */
    private void m23186kT(int i) {
        AppMethodBeat.m2504i(27622);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i;
        if (this.vjA != 0) {
            voiceInputBehavior.textChangeTime = C5046bo.m7525az(this.vjA);
            this.vjA = 0;
        }
        VoiceInputUI.m23177a(voiceInputBehavior);
        AppMethodBeat.m2505o(27622);
    }
}
