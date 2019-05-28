package com.tencent.mm.pluginsdk.ui;

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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;

@a(3)
public class VoiceInputUI extends MMActivity {
    private String bzH;
    private Button lcu;
    private int offset;
    private int textChangeCount = 0;
    private String userCode;
    private long vjA = 0;
    private boolean vjB = true;
    private boolean vjC = false;
    private OnTouchListener vjD = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(27607);
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
                    b.viZ.setImageResource(R.drawable.iv);
                }
            }
            AppMethodBeat.o(27607);
            return false;
        }
    };
    private OnMenuItemClickListener vjE = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(27608);
            VoiceInputUI.this.vjx.setText("");
            VoiceInputUI.this.vjC = true;
            VoiceInputUI.this.KP(6);
            AppMethodBeat.o(27608);
            return true;
        }
    };
    private VoiceInputFooter.a vjF = new VoiceInputFooter.a() {
        public final void oA(boolean z) {
            AppMethodBeat.i(27609);
            if (z) {
                VoiceInputUI.this.lcu.setVisibility(4);
                AppMethodBeat.o(27609);
                return;
            }
            VoiceInputUI.this.lcu.setVisibility(0);
            AppMethodBeat.o(27609);
        }

        public final void djs() {
            AppMethodBeat.i(27610);
            VoiceInputUI.this.KP(8);
            AppMethodBeat.o(27610);
        }
    };
    private MMEditText vjx;
    private VoiceInputFooter vjy;
    private String vjz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoiceInputUI() {
        AppMethodBeat.i(27613);
        AppMethodBeat.o(27613);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27614);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        Intent intent = getIntent();
        if (intent != null) {
            this.bzH = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
            this.vjz = intent.getStringExtra("punctuation");
            this.userCode = intent.getStringExtra("userCode");
        }
        this.vjA = bo.yz();
        this.textChangeCount = 0;
        this.vjC = false;
        this.vjB = true;
        this.vjx = (MMEditText) findViewById(R.id.f1u);
        this.lcu = (Button) findViewById(R.id.f1t);
        this.vjx.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(27611);
                ab.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", Boolean.valueOf(VoiceInputUI.this.vjB), Boolean.valueOf(VoiceInputUI.this.vjC));
                if (VoiceInputUI.this.vjB) {
                    VoiceInputUI.this.vjB = false;
                    AppMethodBeat.o(27611);
                    return;
                }
                VoiceInputUI.this.vjC = true;
                VoiceInputUI.this.vjx.requestLayout();
                AppMethodBeat.o(27611);
            }
        });
        this.lcu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27612);
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 3;
                VoiceInputUI.b(voiceInputBehavior);
                VoiceInputUI.this.KP(7);
                AppMethodBeat.o(27612);
            }
        });
        setMMTitle(getString(R.string.f2c));
        enableOptionMenu(true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27606);
                VoiceInputUI.this.KP(1);
                AppMethodBeat.o(27606);
                return true;
            }
        });
        this.vjx.setOnTouchListener(this.vjD);
        this.vjx.asB(this.bzH);
        if (this.offset != -1) {
            this.vjx.setSelection(this.offset);
        }
        this.vjy = (VoiceInputFooter) findViewById(R.id.elg);
        VoiceInputFooter voiceInputFooter = this.vjy;
        MMEditText mMEditText = this.vjx;
        String str = this.vjz;
        String str2 = this.userCode;
        voiceInputFooter.jZg = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27554);
                if (VoiceInputFooter.this.getVisibility() == 8) {
                    VoiceInputFooter.this.setVisibility(0);
                }
                if (VoiceInputFooter.this.djp()) {
                    VoiceInputFooter.a(VoiceInputFooter.this);
                }
                if (VoiceInputFooter.this.aYV()) {
                    VoiceInputFooter.b(VoiceInputFooter.this);
                }
                AppMethodBeat.o(27554);
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        if (voiceInputFooter.viY == null) {
            voiceInputFooter.viY = new n(voiceInputFooter.getContext(), true, voiceInputFooter.jZg);
            voiceInputFooter.viY.setCallback(new n.a() {
                public final void djr() {
                }

                public final void ajt(String str) {
                    AppMethodBeat.i(27559);
                    if (VoiceInputFooter.this.vjf != null) {
                        VoiceInputFooter.this.vjf.djs();
                    }
                    AppMethodBeat.o(27559);
                }

                public final void oz(boolean z) {
                }
            });
            voiceInputFooter.viY.setPortHeightPX(x.gs(voiceInputFooter.getContext()));
        }
        voiceInputFooter.viY.dkM();
        voiceInputFooter.viY.djT();
        voiceInputFooter.viY.setVisibility(8);
        voiceInputFooter.viY.setToUser(str2);
        voiceInputFooter.viY.setFullScreenData(str);
        voiceInputFooter.oDC.addView(voiceInputFooter.viY, -1, 0);
        this.vjy.setVoiceInputFooterListener(this.vjF);
        AppMethodBeat.o(27614);
    }

    public void onResume() {
        AppMethodBeat.i(27615);
        super.onResume();
        this.vjx.requestFocus();
        AppMethodBeat.o(27615);
    }

    public void onPause() {
        AppMethodBeat.i(27616);
        super.onPause();
        AppMethodBeat.o(27616);
    }

    public void onDestroy() {
        AppMethodBeat.i(27617);
        super.onDestroy();
        AppMethodBeat.o(27617);
    }

    public final int getLayoutId() {
        return R.layout.b1z;
    }

    public void onSwipeBack() {
        AppMethodBeat.i(27618);
        KP(3);
        super.onSwipeBack();
        AppMethodBeat.o(27618);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(27619);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            KP(2);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(27619);
        return onKeyDown;
    }

    public final void KP(int i) {
        AppMethodBeat.i(27620);
        ab.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", Integer.valueOf(i), bo.dpG().toString());
        if (i == 8) {
            kT(7);
        } else {
            kT(i);
        }
        uc ucVar = new uc();
        if (i == 7) {
            ucVar.cQk.action = 1;
        } else if (i == 8) {
            ucVar.cQk.action = 4;
        } else {
            ucVar.cQk.action = 2;
        }
        if (this.vjC) {
            ucVar.cQk.cQl = 1;
        } else {
            ucVar.cQk.cQl = 2;
        }
        ucVar.cQk.result = this.vjx.getText().toString();
        ucVar.cQk.userCode = this.userCode;
        if (this.vjy != null) {
            this.vjy.release();
        }
        com.tencent.mm.sdk.b.a.xxA.m(ucVar);
        bo.hideVKB(this.vjx);
        super.finish();
        AppMethodBeat.o(27620);
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.i(27621);
        ab.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        h.pYm.c(13905, log_13905);
        AppMethodBeat.o(27621);
    }

    private void kT(int i) {
        AppMethodBeat.i(27622);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i;
        if (this.vjA != 0) {
            voiceInputBehavior.textChangeTime = bo.az(this.vjA);
            this.vjA = 0;
        }
        a(voiceInputBehavior);
        AppMethodBeat.o(27622);
    }
}
