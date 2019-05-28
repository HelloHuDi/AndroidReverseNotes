package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aa.i;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.im;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;

public class TopStoryCommentFloatDialog extends RelativeLayout implements f, d {
    MMActivity hwd;
    TextView nDX;
    long rCN = 0;
    TextView sCW;
    SnsEditText sCX;
    com.tencent.mm.plugin.topstory.a.c.f sIa;
    View sIk;
    public e sIl;
    boolean sIm = false;
    a sIn;
    TextView sIo;
    private OnClickListener sIp = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(2249);
            if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
                TopStoryCommentFloatDialog.this.hide();
            }
            AppMethodBeat.o(2249);
        }
    };
    p tipDialog = null;

    public interface a {
        void cHi();

        void onDismiss();
    }

    static /* synthetic */ void a(TopStoryCommentFloatDialog topStoryCommentFloatDialog) {
        AppMethodBeat.i(2264);
        topStoryCommentFloatDialog.cFK();
        AppMethodBeat.o(2264);
    }

    static /* synthetic */ void b(TopStoryCommentFloatDialog topStoryCommentFloatDialog) {
        AppMethodBeat.i(2265);
        topStoryCommentFloatDialog.cHt();
        AppMethodBeat.o(2265);
    }

    public TopStoryCommentFloatDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(2250);
        init();
        AppMethodBeat.o(2250);
    }

    public TopStoryCommentFloatDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(2251);
        init();
        AppMethodBeat.o(2251);
    }

    private void init() {
        AppMethodBeat.i(2252);
        inflate(getContext(), R.layout.b00, this);
        this.sIk = findViewById(R.id.ewj);
        this.sCX = (SnsEditText) findViewById(R.id.ewo);
        this.nDX = (TextView) findViewById(R.id.ewn);
        this.sCW = (TextView) findViewById(R.id.ewm);
        AppMethodBeat.o(2252);
    }

    public final void k(final MMActivity mMActivity) {
        AppMethodBeat.i(2253);
        this.hwd = mMActivity;
        this.sIl = new e(mMActivity);
        setOnClickListener(this.sIp);
        findViewById(R.id.ewk).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2243);
                TopStoryCommentFloatDialog.this.hide();
                AppMethodBeat.o(2243);
            }
        });
        this.sIo = (TextView) findViewById(R.id.ewl);
        this.sIo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2244);
                if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.rCN < 500) {
                    AppMethodBeat.o(2244);
                    return;
                }
                TopStoryCommentFloatDialog.this.rCN = System.currentTimeMillis();
                String obj = TopStoryCommentFloatDialog.this.sCX.getText().toString();
                if (obj.length() > 200) {
                    AppMethodBeat.o(2244);
                } else if (obj.length() <= 0 || obj.trim().length() <= 0) {
                    AppMethodBeat.o(2244);
                } else if (TopStoryCommentFloatDialog.bBL()) {
                    TopStoryCommentFloatDialog.this.tipDialog = h.b(mMActivity, mMActivity.getString(R.string.th), false, null);
                    m fVar = new com.tencent.mm.plugin.topstory.a.c.f(TopStoryCommentFloatDialog.this.sIa);
                    ((chp) fVar.ehh.fsG.fsP).ncM = obj;
                    g.Rg().a(fVar, 0);
                    AppMethodBeat.o(2244);
                } else {
                    h.b(mMActivity, mMActivity.getString(R.string.bx9), "", true);
                    AppMethodBeat.o(2244);
                }
            }
        });
        cFK();
        cHt();
        this.sCX.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(2245);
                TopStoryCommentFloatDialog.a(TopStoryCommentFloatDialog.this);
                TopStoryCommentFloatDialog.b(TopStoryCommentFloatDialog.this);
                AppMethodBeat.o(2245);
            }
        });
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2246);
                e eVar = TopStoryCommentFloatDialog.this.sIl;
                if (!(eVar.isShowing() || eVar.sIi.getWindowToken() == null)) {
                    eVar.setBackgroundDrawable(new ColorDrawable(0));
                    eVar.showAtLocation(eVar.sIi, 0, 0, 0);
                }
                AppMethodBeat.o(2246);
            }
        });
        AppMethodBeat.o(2253);
    }

    public final void a(com.tencent.mm.plugin.topstory.a.c.f fVar, a aVar, int i, int i2) {
        AppMethodBeat.i(2254);
        this.sIm = true;
        this.sIa = fVar;
        setVisibility(0);
        this.sCX.requestFocus();
        this.hwd.showVKB();
        this.sIn = aVar;
        chp cFv = fVar.cFv();
        String str = "action=14&channelId=" + i + "&mpScene=0&kykScene=" + cFv.Scene + "&kykSubScene=0&itemType=" + i2 + "&searchId=" + cFv.wDM + "&docId=" + cFv.wUo + "&byPass=" + cFv.xgw;
        com.tencent.mm.plugin.report.service.h.pYm.e(17080, Integer.valueOf(7), Integer.valueOf(2), str);
        AppMethodBeat.o(2254);
    }

    public final void hide() {
        AppMethodBeat.i(2255);
        if (this.sCX.getText().toString().length() > 0) {
            h.a(this.hwd, (int) R.string.g_v, 0, (int) R.string.up, (int) R.string.s2, true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(2248);
                    TopStoryCommentFloatDialog.this.cHs();
                    AppMethodBeat.o(2248);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, (int) R.color.hi);
            AppMethodBeat.o(2255);
            return;
        }
        cHs();
        AppMethodBeat.o(2255);
    }

    public final void cHs() {
        AppMethodBeat.i(2256);
        this.sCX.setText("");
        setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.sIk.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.sIk.setLayoutParams(layoutParams);
        this.hwd.aqX();
        this.sIm = false;
        if (this.sIn != null) {
            this.sIn.onDismiss();
        }
        AppMethodBeat.o(2256);
    }

    public final void onPause() {
        AppMethodBeat.i(2257);
        this.sIl.sIe = null;
        g.Rg().b(2906, (f) this);
        AppMethodBeat.o(2257);
    }

    public final void onResume() {
        AppMethodBeat.i(2258);
        this.sIl.sIe = this;
        g.Rg().a(2906, (f) this);
        AppMethodBeat.o(2258);
    }

    public final void fU(final int i, int i2) {
        AppMethodBeat.i(2259);
        ab.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: " + i + " " + (i2 == 1 ? "portrait" : "landscape"));
        if (this.sIm) {
            this.sIk.setVisibility(0);
            if (((LayoutParams) this.sIk.getLayoutParams()).bottomMargin != i) {
                AnonymousClass5 anonymousClass5 = new Animation() {
                    /* Access modifiers changed, original: protected|final */
                    public final void applyTransformation(float f, Transformation transformation) {
                        AppMethodBeat.i(2247);
                        LayoutParams layoutParams = (LayoutParams) TopStoryCommentFloatDialog.this.sIk.getLayoutParams();
                        layoutParams.bottomMargin = (int) (((float) i) * f);
                        TopStoryCommentFloatDialog.this.sIk.setLayoutParams(layoutParams);
                        AppMethodBeat.o(2247);
                    }
                };
                if (i != 0) {
                    anonymousClass5.setDuration(200);
                } else {
                    anonymousClass5.setDuration(300);
                }
                this.sIk.startAnimation(anonymousClass5);
            }
            this.sCX.requestFocus();
            setVisibility(0);
        }
        AppMethodBeat.o(2259);
    }

    private void cFK() {
        AppMethodBeat.i(2260);
        int length = this.sCX.getText().toString().length();
        if (length < 180) {
            this.nDX.setVisibility(8);
            this.sCW.setVisibility(8);
            AppMethodBeat.o(2260);
            return;
        }
        int color;
        this.nDX.setVisibility(0);
        this.sCW.setVisibility(0);
        if (length <= 200) {
            color = getResources().getColor(R.color.a3f);
        } else {
            color = getResources().getColor(R.color.xy);
        }
        this.nDX.setText(String.valueOf(length));
        this.nDX.setTextColor(color);
        AppMethodBeat.o(2260);
    }

    private void cHt() {
        AppMethodBeat.i(2261);
        int length = this.sCX.getText().toString().length();
        int length2 = this.sCX.getText().toString().trim().length();
        if (length > 200 || length <= 0 || length2 <= 0) {
            this.sIo.setBackgroundResource(R.drawable.a45);
            AppMethodBeat.o(2261);
            return;
        }
        this.sIo.setBackgroundResource(R.drawable.a44);
        AppMethodBeat.o(2261);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(2262);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        boolean z = i == 0 && i2 == 0;
        if (z) {
            cHs();
            if (this.sIn != null) {
                this.sIn.cHi();
            }
            if (mVar instanceof com.tencent.mm.plugin.topstory.a.c.f) {
                com.tencent.mm.plugin.topstory.a.c.f fVar = (com.tencent.mm.plugin.topstory.a.c.f) mVar;
                i iVar = new i();
                try {
                    Object obj;
                    String str2 = b.CONTENT;
                    chp chp = (chp) fVar.ehh.fsG.fsP;
                    if (chp != null) {
                        obj = chp.ncM;
                    } else {
                        obj = "";
                    }
                    iVar.g(str2, obj);
                    iVar.g("id", fVar.cFu().xgx);
                    str2 = "docId";
                    chp = (chp) fVar.ehh.fsG.fsP;
                    if (chp != null) {
                        obj = chp.wUo;
                    } else {
                        obj = "";
                    }
                    iVar.g(str2, obj);
                    iVar.g("opType", "REPLY_ARTICLE_BY_ME");
                    im imVar = new im();
                    imVar.cDD.cDE = iVar.toString();
                    imVar.cDD.cDF = "";
                    com.tencent.mm.sdk.b.a.xxA.m(imVar);
                } catch (com.tencent.mm.aa.g e) {
                    ab.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
                }
            }
            t.makeText(this.hwd, R.string.g_x, 0).show();
            AppMethodBeat.o(2262);
            return;
        }
        h.b(this.hwd, this.hwd.getString(R.string.ps), "", true);
        AppMethodBeat.o(2262);
    }

    protected static boolean bBL() {
        AppMethodBeat.i(2263);
        if (((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
            int acS = g.Rg().acS();
            if (acS == 4 || acS == 6) {
                AppMethodBeat.o(2263);
                return true;
            }
            AppMethodBeat.o(2263);
            return false;
        }
        Object obj;
        if (at.isConnected(ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.o(2263);
            return true;
        }
        AppMethodBeat.o(2263);
        return false;
    }
}
