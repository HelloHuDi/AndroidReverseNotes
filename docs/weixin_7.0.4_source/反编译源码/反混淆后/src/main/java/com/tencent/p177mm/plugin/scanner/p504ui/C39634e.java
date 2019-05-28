package com.tencent.p177mm.plugin.scanner.p504ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.ui.e */
public final class C39634e extends Preference {
    private Context context;
    private TextView gne;
    private OnTouchListener mNa;
    String mTitle;
    private View mView;
    private TextView pnu;
    private final int qcj = 5;
    private TextView qck;
    public boolean qcl = false;
    public boolean qcm = false;
    private Boolean qcn;
    private OnGlobalLayoutListener qco;
    C13153a qcp;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.e$2 */
    class C37622 implements OnGlobalLayoutListener {
        C37622() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(81019);
            C4990ab.m7410d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + C39634e.this.pnu.getHeight() + ", summaryTv.getLineHeight() = " + C39634e.this.pnu.getLineHeight());
            if (C39634e.this.pnu.getText() != null && C39634e.this.pnu.getHeight() > 0 && C39634e.this.pnu.getLineHeight() > 0 && C39634e.this.qcn == null) {
                if (!(C39634e.this.pnu.getHeight() / C39634e.this.pnu.getLineHeight() <= 5 || C39634e.this.qcm || C39634e.this.qcl)) {
                    C39634e.this.qck.setVisibility(0);
                    C39634e.this.pnu.setMaxLines(5);
                    C39634e.this.qcm = true;
                    if (C39634e.this.qcp != null && C39634e.this.qcp.mo25178Wg(C39634e.this.mKey) == null) {
                        C39634e.this.qcp.mo25179a(C39634e.this.mKey, Boolean.FALSE);
                        C39634e.this.qcp.chl();
                    }
                }
                C4990ab.m7410d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (C39634e.this.pnu.getHeight() / C39634e.this.pnu.getLineHeight()));
            }
            C39634e.this.pnu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AppMethodBeat.m2505o(81019);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.e$a */
    public interface C13153a {
        /* renamed from: Wg */
        Boolean mo25178Wg(String str);

        /* renamed from: a */
        void mo25179a(String str, Boolean bool);

        void chl();
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.e$1 */
    class C396331 implements OnTouchListener {
        C396331() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(81018);
            if (motionEvent.getAction() == 0) {
                C4990ab.m7410d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
                C39634e.this.qck.setVisibility(4);
                C39634e.this.pnu.setMaxLines(2000);
                C39634e.this.qcl = true;
                if (C39634e.this.qcp != null) {
                    C39634e.this.qcp.mo25179a(C39634e.this.mKey, Boolean.TRUE);
                    C39634e.this.qcp.chl();
                }
            }
            AppMethodBeat.m2505o(81018);
            return false;
        }
    }

    public C39634e(Activity activity) {
        super(activity);
        AppMethodBeat.m2504i(81020);
        setLayoutResource(2130970173);
        this.context = activity;
        AppMethodBeat.m2505o(81020);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(81021);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(81021);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81022);
        super.onBindView(view);
        if (this.gne == null) {
            this.gne = (TextView) view.findViewById(16908310);
        }
        if (this.pnu == null) {
            this.pnu = (TextView) view.findViewById(16908304);
        }
        if (this.qck == null) {
            this.qck = (TextView) view.findViewById(2131826055);
        }
        if (this.mNa == null) {
            this.mNa = new C396331();
            this.qck.setOnTouchListener(this.mNa);
        }
        if (this.qcp != null) {
            this.qcn = this.qcp.mo25178Wg(this.mKey);
            if (this.qcn == null) {
                this.qck.setVisibility(8);
                this.pnu.setMaxLines(6);
            } else if (this.qcn.booleanValue()) {
                this.qck.setVisibility(8);
                this.pnu.setMaxLines(2000);
            } else {
                this.qck.setVisibility(0);
                this.pnu.setMaxLines(5);
            }
        } else {
            this.qck.setVisibility(8);
            this.pnu.setMaxLines(6);
        }
        if (this.qco == null) {
            this.qco = new C37622();
            this.pnu.getViewTreeObserver().addOnGlobalLayoutListener(this.qco);
        }
        if (C5046bo.isNullOrNil(this.mTitle)) {
            this.gne.setVisibility(8);
            AppMethodBeat.m2505o(81022);
            return;
        }
        this.gne.setText(this.mTitle);
        this.gne.setVisibility(0);
        AppMethodBeat.m2505o(81022);
    }
}
