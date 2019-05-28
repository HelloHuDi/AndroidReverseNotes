package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.BasePanelKeybordLayout;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44080d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter */
public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    MMActivity crP;
    ChatFooterPanel eAk;
    private MMEditText jZg = null;
    private ImageButton jZh;
    private boolean oin = true;
    SightRangeWidget rwY;
    SightLocationWidget rwZ;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter$3 */
    class C220273 implements Runnable {
        C220273() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39287);
            SnsSightUploadSayFooter.this.jZg.performClick();
            SnsSightUploadSayFooter.this.jZg.requestFocus();
            SnsSightUploadSayFooter.this.crP.showVKB();
            AppMethodBeat.m2505o(39287);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter$4 */
    class C220284 implements OnClickListener {
        C220284() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39288);
            SnsSightUploadSayFooter.m57598d(SnsSightUploadSayFooter.this);
            AppMethodBeat.m2505o(39288);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter$5 */
    class C220295 implements C44073a {
        C220295() {
        }

        public final void aYY() {
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
        }

        public final void aRg() {
            AppMethodBeat.m2504i(39289);
            SnsSightUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            SnsSightUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.m2505o(39289);
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(39290);
            try {
                SnsSightUploadSayFooter.this.jZg.asB(str);
                AppMethodBeat.m2505o(39290);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
                AppMethodBeat.m2505o(39290);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter$1 */
    class C350431 implements OnClickListener {
        C350431() {
        }

        public final void onClick(View view) {
            int i = 0;
            AppMethodBeat.m2504i(39286);
            if (SnsSightUploadSayFooter.this.getVisibility() == 8) {
                SnsSightUploadSayFooter.this.setVisibility(0);
            }
            if (SnsSightUploadSayFooter.this.eAk.getVisibility() == 0) {
                i = 1;
            }
            if (i != 0) {
                SnsSightUploadSayFooter.m57595a(SnsSightUploadSayFooter.this);
            }
            AppMethodBeat.m2505o(39286);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter$2 */
    class C350442 implements OnEditorActionListener {
        C350442() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m57595a(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        AppMethodBeat.m2504i(39296);
        snsSightUploadSayFooter.aRe();
        AppMethodBeat.m2505o(39296);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39291);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) SnsSightUploadSayFooter.inflate(this.crP, 2130970798, this);
        this.jZh = (ImageButton) viewGroup.findViewById(2131825682);
        this.jZh.setOnClickListener(new C220284());
        if (C44081e.vom == null) {
            this.eAk = new C44080d(this.crP);
        } else {
            this.eAk = C44081e.vom.mo35682dF(getContext());
            this.eAk.setEntranceScene(ChatFooterPanel.vhj);
            this.eAk.setVisibility(8);
            ((LinearLayout) findViewById(2131820987)).addView(this.eAk, -1, 0);
            this.eAk.mo11687AD();
            this.eAk.mo11691bf(false);
            this.eAk.setOnTextOperationListener(new C220295());
        }
        this.rwY = (SightRangeWidget) viewGroup.findViewById(2131825683);
        this.rwY.rhg = null;
        this.rwY.style = 1;
        this.rwZ = (SightLocationWidget) viewGroup.findViewById(2131827846);
        AppMethodBeat.m2505o(39291);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.m2504i(39292);
        this.jZg = mMEditText;
        mMEditText.setOnClickListener(new C350431());
        mMEditText.setOnEditorActionListener(new C350442());
        C5004al.m7442n(new C220273(), 200);
        AppMethodBeat.m2505o(39292);
    }

    private void aRe() {
        AppMethodBeat.m2504i(39293);
        this.eAk.onPause();
        this.eAk.setVisibility(8);
        AppMethodBeat.m2505o(39293);
    }

    public List<View> getPanelView() {
        AppMethodBeat.m2504i(39294);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eAk);
        AppMethodBeat.m2505o(39294);
        return arrayList;
    }

    public ayt getLocation() {
        AppMethodBeat.m2504i(39295);
        ayt location = this.rwZ.getLocation();
        AppMethodBeat.m2505o(39295);
        return location;
    }

    /* renamed from: d */
    static /* synthetic */ void m57598d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        AppMethodBeat.m2504i(39297);
        if (snsSightUploadSayFooter.eAk.getVisibility() == 8) {
            snsSightUploadSayFooter.crP.aqX();
            snsSightUploadSayFooter.eAk.onResume();
            snsSightUploadSayFooter.eAk.setVisibility(0);
            snsSightUploadSayFooter.jZg.requestFocus();
            snsSightUploadSayFooter.jZh.setImageResource(C1318a.sight_icon_keyboard);
            snsSightUploadSayFooter.oin = false;
            AppMethodBeat.m2505o(39297);
            return;
        }
        snsSightUploadSayFooter.oin = false;
        snsSightUploadSayFooter.jZg.requestFocus();
        snsSightUploadSayFooter.aRe();
        snsSightUploadSayFooter.crP.showVKB();
        snsSightUploadSayFooter.jZh.setImageResource(C1318a.sight_icon_emoji);
        AppMethodBeat.m2505o(39297);
    }
}
