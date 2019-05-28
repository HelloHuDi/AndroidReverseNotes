package com.tencent.p177mm.plugin.topstory.p541ui.widget;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42007im;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p520ui.SnsEditText;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C13944f;
import com.tencent.p177mm.protocal.protobuf.chp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog */
public class TopStoryCommentFloatDialog extends RelativeLayout implements C1202f, C46313d {
    MMActivity hwd;
    TextView nDX;
    long rCN = 0;
    TextView sCW;
    SnsEditText sCX;
    C13944f sIa;
    View sIk;
    public C22426e sIl;
    boolean sIm = false;
    C14003a sIn;
    TextView sIo;
    private OnClickListener sIp = new C353198();
    C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog$6 */
    class C42496 implements DialogInterface.OnClickListener {
        C42496() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(2248);
            TopStoryCommentFloatDialog.this.cHs();
            AppMethodBeat.m2505o(2248);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog$7 */
    class C42507 implements DialogInterface.OnClickListener {
        C42507() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog$a */
    public interface C14003a {
        void cHi();

        void onDismiss();
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog$4 */
    class C224234 implements Runnable {
        C224234() {
        }

        public final void run() {
            AppMethodBeat.m2504i(2246);
            C22426e c22426e = TopStoryCommentFloatDialog.this.sIl;
            if (!(c22426e.isShowing() || c22426e.sIi.getWindowToken() == null)) {
                c22426e.setBackgroundDrawable(new ColorDrawable(0));
                c22426e.showAtLocation(c22426e.sIi, 0, 0, 0);
            }
            AppMethodBeat.m2505o(2246);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog$1 */
    class C353161 implements OnClickListener {
        C353161() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2243);
            TopStoryCommentFloatDialog.this.hide();
            AppMethodBeat.m2505o(2243);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog$8 */
    class C353198 implements OnClickListener {
        C353198() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2249);
            if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
                TopStoryCommentFloatDialog.this.hide();
            }
            AppMethodBeat.m2505o(2249);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog$3 */
    class C437043 implements TextWatcher {
        C437043() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(2245);
            TopStoryCommentFloatDialog.m78310a(TopStoryCommentFloatDialog.this);
            TopStoryCommentFloatDialog.m78311b(TopStoryCommentFloatDialog.this);
            AppMethodBeat.m2505o(2245);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m78310a(TopStoryCommentFloatDialog topStoryCommentFloatDialog) {
        AppMethodBeat.m2504i(2264);
        topStoryCommentFloatDialog.cFK();
        AppMethodBeat.m2505o(2264);
    }

    /* renamed from: b */
    static /* synthetic */ void m78311b(TopStoryCommentFloatDialog topStoryCommentFloatDialog) {
        AppMethodBeat.m2504i(2265);
        topStoryCommentFloatDialog.cHt();
        AppMethodBeat.m2505o(2265);
    }

    public TopStoryCommentFloatDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(2250);
        init();
        AppMethodBeat.m2505o(2250);
    }

    public TopStoryCommentFloatDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(2251);
        init();
        AppMethodBeat.m2505o(2251);
    }

    private void init() {
        AppMethodBeat.m2504i(2252);
        TopStoryCommentFloatDialog.inflate(getContext(), 2130970939, this);
        this.sIk = findViewById(2131828259);
        this.sCX = (SnsEditText) findViewById(2131828264);
        this.nDX = (TextView) findViewById(2131828263);
        this.sCW = (TextView) findViewById(2131828262);
        AppMethodBeat.m2505o(2252);
    }

    /* renamed from: k */
    public final void mo69382k(final MMActivity mMActivity) {
        AppMethodBeat.m2504i(2253);
        this.hwd = mMActivity;
        this.sIl = new C22426e(mMActivity);
        setOnClickListener(this.sIp);
        findViewById(2131828260).setOnClickListener(new C353161());
        this.sIo = (TextView) findViewById(2131828261);
        this.sIo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(2244);
                if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.rCN < 500) {
                    AppMethodBeat.m2505o(2244);
                    return;
                }
                TopStoryCommentFloatDialog.this.rCN = System.currentTimeMillis();
                String obj = TopStoryCommentFloatDialog.this.sCX.getText().toString();
                if (obj.length() > 200) {
                    AppMethodBeat.m2505o(2244);
                } else if (obj.length() <= 0 || obj.trim().length() <= 0) {
                    AppMethodBeat.m2505o(2244);
                } else if (TopStoryCommentFloatDialog.bBL()) {
                    TopStoryCommentFloatDialog.this.tipDialog = C30379h.m48458b(mMActivity, mMActivity.getString(C25738R.string.f9222th), false, null);
                    C1207m c13944f = new C13944f(TopStoryCommentFloatDialog.this.sIa);
                    ((chp) c13944f.ehh.fsG.fsP).ncM = obj;
                    C1720g.m3540Rg().mo14541a(c13944f, 0);
                    AppMethodBeat.m2505o(2244);
                } else {
                    C30379h.m48461b(mMActivity, mMActivity.getString(C25738R.string.bx9), "", true);
                    AppMethodBeat.m2505o(2244);
                }
            }
        });
        cFK();
        cHt();
        this.sCX.addTextChangedListener(new C437043());
        post(new C224234());
        AppMethodBeat.m2505o(2253);
    }

    /* renamed from: a */
    public final void mo69378a(C13944f c13944f, C14003a c14003a, int i, int i2) {
        AppMethodBeat.m2504i(2254);
        this.sIm = true;
        this.sIa = c13944f;
        setVisibility(0);
        this.sCX.requestFocus();
        this.hwd.showVKB();
        this.sIn = c14003a;
        chp cFv = c13944f.cFv();
        String str = "action=14&channelId=" + i + "&mpScene=0&kykScene=" + cFv.Scene + "&kykSubScene=0&itemType=" + i2 + "&searchId=" + cFv.wDM + "&docId=" + cFv.wUo + "&byPass=" + cFv.xgw;
        C7060h.pYm.mo8381e(17080, Integer.valueOf(7), Integer.valueOf(2), str);
        AppMethodBeat.m2505o(2254);
    }

    public final void hide() {
        AppMethodBeat.m2504i(2255);
        if (this.sCX.getText().toString().length() > 0) {
            C30379h.m48430a(this.hwd, (int) C25738R.string.g_v, 0, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, true, new C42496(), new C42507(), (int) C25738R.color.f11795hi);
            AppMethodBeat.m2505o(2255);
            return;
        }
        cHs();
        AppMethodBeat.m2505o(2255);
    }

    public final void cHs() {
        AppMethodBeat.m2504i(2256);
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
        AppMethodBeat.m2505o(2256);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(2257);
        this.sIl.sIe = null;
        C1720g.m3540Rg().mo14546b(2906, (C1202f) this);
        AppMethodBeat.m2505o(2257);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(2258);
        this.sIl.sIe = this;
        C1720g.m3540Rg().mo14539a(2906, (C1202f) this);
        AppMethodBeat.m2505o(2258);
    }

    /* renamed from: fU */
    public final void mo69380fU(final int i, int i2) {
        AppMethodBeat.m2504i(2259);
        C4990ab.m7416i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: " + i + " " + (i2 == 1 ? "portrait" : "landscape"));
        if (this.sIm) {
            this.sIk.setVisibility(0);
            if (((LayoutParams) this.sIk.getLayoutParams()).bottomMargin != i) {
                C353185 c353185 = new Animation() {
                    /* Access modifiers changed, original: protected|final */
                    public final void applyTransformation(float f, Transformation transformation) {
                        AppMethodBeat.m2504i(2247);
                        LayoutParams layoutParams = (LayoutParams) TopStoryCommentFloatDialog.this.sIk.getLayoutParams();
                        layoutParams.bottomMargin = (int) (((float) i) * f);
                        TopStoryCommentFloatDialog.this.sIk.setLayoutParams(layoutParams);
                        AppMethodBeat.m2505o(2247);
                    }
                };
                if (i != 0) {
                    c353185.setDuration(200);
                } else {
                    c353185.setDuration(300);
                }
                this.sIk.startAnimation(c353185);
            }
            this.sCX.requestFocus();
            setVisibility(0);
        }
        AppMethodBeat.m2505o(2259);
    }

    private void cFK() {
        AppMethodBeat.m2504i(2260);
        int length = this.sCX.getText().toString().length();
        if (length < 180) {
            this.nDX.setVisibility(8);
            this.sCW.setVisibility(8);
            AppMethodBeat.m2505o(2260);
            return;
        }
        int color;
        this.nDX.setVisibility(0);
        this.sCW.setVisibility(0);
        if (length <= 200) {
            color = getResources().getColor(C25738R.color.a3f);
        } else {
            color = getResources().getColor(C25738R.color.f12266xy);
        }
        this.nDX.setText(String.valueOf(length));
        this.nDX.setTextColor(color);
        AppMethodBeat.m2505o(2260);
    }

    private void cHt() {
        AppMethodBeat.m2504i(2261);
        int length = this.sCX.getText().toString().length();
        int length2 = this.sCX.getText().toString().trim().length();
        if (length > 200 || length <= 0 || length2 <= 0) {
            this.sIo.setBackgroundResource(C25738R.drawable.a45);
            AppMethodBeat.m2505o(2261);
            return;
        }
        this.sIo.setBackgroundResource(C25738R.drawable.a44);
        AppMethodBeat.m2505o(2261);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(2262);
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
            if (c1207m instanceof C13944f) {
                C13944f c13944f = (C13944f) c1207m;
                C41726i c41726i = new C41726i();
                try {
                    Object obj;
                    String str2 = C8741b.CONTENT;
                    chp chp = (chp) c13944f.ehh.fsG.fsP;
                    if (chp != null) {
                        obj = chp.ncM;
                    } else {
                        obj = "";
                    }
                    c41726i.mo67475g(str2, obj);
                    c41726i.mo67475g("id", c13944f.cFu().xgx);
                    str2 = "docId";
                    chp = (chp) c13944f.ehh.fsG.fsP;
                    if (chp != null) {
                        obj = chp.wUo;
                    } else {
                        obj = "";
                    }
                    c41726i.mo67475g(str2, obj);
                    c41726i.mo67475g("opType", "REPLY_ARTICLE_BY_ME");
                    C42007im c42007im = new C42007im();
                    c42007im.cDD.cDE = c41726i.toString();
                    c42007im.cDD.cDF = "";
                    C4879a.xxA.mo10055m(c42007im);
                } catch (C41724g e) {
                    C4990ab.m7412e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
                }
            }
            C23639t.makeText(this.hwd, C25738R.string.g_x, 0).show();
            AppMethodBeat.m2505o(2262);
            return;
        }
        C30379h.m48461b(this.hwd, this.hwd.getString(C25738R.string.f9111ps), "", true);
        AppMethodBeat.m2505o(2262);
    }

    protected static boolean bBL() {
        AppMethodBeat.m2504i(2263);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            int acS = C1720g.m3540Rg().acS();
            if (acS == 4 || acS == 6) {
                AppMethodBeat.m2505o(2263);
                return true;
            }
            AppMethodBeat.m2505o(2263);
            return false;
        }
        Object obj;
        if (C5023at.isConnected(C4996ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.m2505o(2263);
            return true;
        }
        AppMethodBeat.m2505o(2263);
        return false;
    }
}
