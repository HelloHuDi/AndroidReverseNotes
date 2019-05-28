package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
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
    a qcp;

    public interface a {
        Boolean Wg(String str);

        void a(String str, Boolean bool);

        void chl();
    }

    public e(Activity activity) {
        super(activity);
        AppMethodBeat.i(81020);
        setLayoutResource(R.layout.afc);
        this.context = activity;
        AppMethodBeat.o(81020);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(81021);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(81021);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81022);
        super.onBindView(view);
        if (this.gne == null) {
            this.gne = (TextView) view.findViewById(16908310);
        }
        if (this.pnu == null) {
            this.pnu = (TextView) view.findViewById(16908304);
        }
        if (this.qck == null) {
            this.qck = (TextView) view.findViewById(R.id.d_z);
        }
        if (this.mNa == null) {
            this.mNa = new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(81018);
                    if (motionEvent.getAction() == 0) {
                        ab.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
                        e.this.qck.setVisibility(4);
                        e.this.pnu.setMaxLines(2000);
                        e.this.qcl = true;
                        if (e.this.qcp != null) {
                            e.this.qcp.a(e.this.mKey, Boolean.TRUE);
                            e.this.qcp.chl();
                        }
                    }
                    AppMethodBeat.o(81018);
                    return false;
                }
            };
            this.qck.setOnTouchListener(this.mNa);
        }
        if (this.qcp != null) {
            this.qcn = this.qcp.Wg(this.mKey);
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
            this.qco = new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    AppMethodBeat.i(81019);
                    ab.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + e.this.pnu.getHeight() + ", summaryTv.getLineHeight() = " + e.this.pnu.getLineHeight());
                    if (e.this.pnu.getText() != null && e.this.pnu.getHeight() > 0 && e.this.pnu.getLineHeight() > 0 && e.this.qcn == null) {
                        if (!(e.this.pnu.getHeight() / e.this.pnu.getLineHeight() <= 5 || e.this.qcm || e.this.qcl)) {
                            e.this.qck.setVisibility(0);
                            e.this.pnu.setMaxLines(5);
                            e.this.qcm = true;
                            if (e.this.qcp != null && e.this.qcp.Wg(e.this.mKey) == null) {
                                e.this.qcp.a(e.this.mKey, Boolean.FALSE);
                                e.this.qcp.chl();
                            }
                        }
                        ab.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (e.this.pnu.getHeight() / e.this.pnu.getLineHeight()));
                    }
                    e.this.pnu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AppMethodBeat.o(81019);
                }
            };
            this.pnu.getViewTreeObserver().addOnGlobalLayoutListener(this.qco);
        }
        if (bo.isNullOrNil(this.mTitle)) {
            this.gne.setVisibility(8);
            AppMethodBeat.o(81022);
            return;
        }
        this.gne.setText(this.mTitle);
        this.gne.setVisibility(0);
        AppMethodBeat.o(81022);
    }
}
