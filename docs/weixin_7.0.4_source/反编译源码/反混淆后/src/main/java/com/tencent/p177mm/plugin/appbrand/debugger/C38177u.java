package com.tencent.p177mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.debugger.RemoteDebugMoveView.C21201;
import com.tencent.p177mm.plugin.appbrand.debugger.RemoteDebugMoveView.C21213;
import com.tencent.p177mm.protocal.protobuf.cqm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.debugger.u */
public final class C38177u extends FrameLayout {
    private C42411l hjR;
    ViewGroup hkC;
    RemoteDebugMoveView hkD;
    private LinkedList<String> hkE = new LinkedList();
    TextView hkF;
    TextView hkG;
    TextView hkH;
    TextView hkI;
    TextView hkJ;
    TextView hkK;
    TextView hkL;
    ImageView hkM;
    ImageView hkN;
    View hkO;
    boolean hkP = false;
    private C38180a hkQ;
    private C5653c hkR;
    OnClickListener mOnClickListener = new C331413();

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$2 */
    class C101902 implements Runnable {
        C101902() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101917);
            if (C38177u.this.hkC == null) {
                C4990ab.m7420w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
                AppMethodBeat.m2505o(101917);
            } else if (C38177u.m64618c(C38177u.this)) {
                C38177u.this.setVisibility(0);
                if (C38177u.this.hkC.indexOfChild(C38177u.this) == -1) {
                    C38177u.this.hkC.addView(C38177u.this);
                }
                C38177u.this.hkC.bringChildToFront(C38177u.this);
                C38177u.this.setBackgroundColor(C38177u.this.getContext().getResources().getColor(C25738R.color.f12084rr));
                AppMethodBeat.m2505o(101917);
            } else {
                C38177u.this.setBackgroundColor(C38177u.this.getContext().getResources().getColor(C25738R.color.a3p));
                AppMethodBeat.m2505o(101917);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$4 */
    class C101914 implements DialogInterface.OnClickListener {
        C101914() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(101919);
            if (C38177u.this.hkQ != null) {
                C38177u.this.hkQ.azf();
            }
            AppMethodBeat.m2505o(101919);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$1 */
    class C268531 implements Runnable {
        C268531() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101916);
            RemoteDebugMoveView a = C38177u.this.hkD;
            int width = C38177u.this.getWidth();
            int height = C38177u.this.getHeight();
            a.setLayoutParams(new LayoutParams(-2, -2));
            a.hkc = width;
            a.hkd = height;
            a.post(new C21201());
            C38177u.this.addView(C38177u.this.hkD);
            AppMethodBeat.m2505o(101916);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$3 */
    class C331413 implements OnClickListener {
        C331413() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(101918);
            C38177u c38177u = C38177u.this;
            if (view.getId() == 2131821355) {
                c38177u.hkP = true;
                c38177u.show();
                RemoteDebugMoveView remoteDebugMoveView = c38177u.hkD;
                remoteDebugMoveView.postDelayed(new C21213(), 50);
                AppMethodBeat.m2505o(101918);
            } else if (view.getId() == 2131821364) {
                c38177u.hkP = false;
                c38177u.show();
                AppMethodBeat.m2505o(101918);
            } else {
                if (view.getId() == 2131821363) {
                    c38177u.azu();
                }
                AppMethodBeat.m2505o(101918);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$6 */
    class C381766 implements Runnable {
        C381766() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101921);
            C38177u.m64624i(C38177u.this);
            AppMethodBeat.m2505o(101921);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$7 */
    class C381787 implements Runnable {
        C381787() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101922);
            C38177u.m64623h(C38177u.this);
            C38177u.m64625j(C38177u.this);
            AppMethodBeat.m2505o(101922);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$8 */
    class C381798 implements Runnable {
        final /* synthetic */ int hkT;
        final /* synthetic */ cqm hkU;

        C381798(int i, cqm cqm) {
            this.hkT = i;
            this.hkU = cqm;
        }

        public final void run() {
            AppMethodBeat.m2504i(101923);
            C38177u.m64616a(C38177u.this, "cmdId " + this.hkT + ", errCode " + this.hkU.cyE);
            AppMethodBeat.m2505o(101923);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$a */
    public interface C38180a {
        void azf();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$5 */
    class C381815 implements Runnable {
        C381815() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101920);
            if (C38177u.this.hjR.azb()) {
                C38177u.this.hkN.setImageResource(C25738R.drawable.f6381cb);
                C38177u.this.hkG.setText(C38177u.this.getContext().getString(C25738R.string.f9034n8));
            } else if (C38177u.this.hjR.isReady()) {
                C38177u.this.hkN.setImageResource(C25738R.drawable.f6381cb);
                C38177u.this.hkG.setText(C38177u.this.getContext().getString(C25738R.string.f9035n9));
            } else {
                C38177u.this.hkN.setImageResource(C25738R.drawable.f6380ca);
                C38177u.this.hkG.setText(C38177u.this.getContext().getString(C25738R.string.f9033n7));
            }
            C38177u.m64623h(C38177u.this);
            AppMethodBeat.m2505o(101920);
        }
    }

    /* renamed from: c */
    static /* synthetic */ boolean m64618c(C38177u c38177u) {
        AppMethodBeat.m2504i(101935);
        boolean azt = c38177u.azt();
        AppMethodBeat.m2505o(101935);
        return azt;
    }

    /* renamed from: i */
    static /* synthetic */ void m64624i(C38177u c38177u) {
        AppMethodBeat.m2504i(101937);
        c38177u.azu();
        AppMethodBeat.m2505o(101937);
    }

    public C38177u(Context context, C42411l c42411l, C38180a c38180a) {
        super(context);
        AppMethodBeat.m2504i(101925);
        this.hjR = c42411l;
        this.hkQ = c38180a;
        setLayoutParams(new LayoutParams(-1, -1));
        setBackgroundColor(getContext().getResources().getColor(C25738R.color.a3p));
        setId(2131820551);
        AppMethodBeat.m2505o(101925);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101926);
        if (azt()) {
            AppMethodBeat.m2505o(101926);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(101926);
        return onTouchEvent;
    }

    public final void bringToFront() {
        AppMethodBeat.m2504i(101927);
        if (this.hkC == null) {
            C4990ab.m7420w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
            AppMethodBeat.m2505o(101927);
            return;
        }
        this.hkC.bringChildToFront(this);
        AppMethodBeat.m2505o(101927);
    }

    public final void azs() {
        AppMethodBeat.m2504i(101928);
        C5004al.m7441d(new C101902());
        AppMethodBeat.m2505o(101928);
    }

    private boolean azt() {
        AppMethodBeat.m2504i(101929);
        if (this.hjR.azb() || this.hjR.azc() || this.hjR.azd()) {
            AppMethodBeat.m2505o(101929);
            return true;
        }
        AppMethodBeat.m2505o(101929);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void azu() {
        AppMethodBeat.m2504i(101930);
        if (this.hkR == null || !this.hkR.isShowing()) {
            Context context = getContext();
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                AppMethodBeat.m2505o(101930);
                return;
            }
            this.hkR = new C5652a(context).asD(context.getString(C25738R.string.f9039nc)).asE("").mo11453Qc(C25738R.string.abo).mo11457a(new C101914()).mo11454Qd(C25738R.string.abn).aMb();
            this.hkR.show();
            AppMethodBeat.m2505o(101930);
            return;
        }
        AppMethodBeat.m2505o(101930);
    }

    public final void azv() {
        AppMethodBeat.m2504i(101931);
        C5004al.m7441d(new C381815());
        AppMethodBeat.m2505o(101931);
    }

    public final void show() {
        AppMethodBeat.m2504i(101932);
        if (this.hkP) {
            this.hkO.setVisibility(0);
            if (this.hkE.size() > 0) {
                this.hkL.setVisibility(0);
            } else {
                this.hkL.setVisibility(8);
            }
            this.hkJ.setVisibility(8);
        } else {
            this.hkO.setVisibility(8);
            this.hkL.setVisibility(8);
            this.hkJ.setVisibility(0);
        }
        invalidate();
        AppMethodBeat.m2505o(101932);
    }

    public final void azw() {
        AppMethodBeat.m2504i(101933);
        azs();
        azv();
        AppMethodBeat.m2505o(101933);
    }

    /* renamed from: zQ */
    public final void mo60917zQ(final String str) {
        AppMethodBeat.m2504i(101934);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101934);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(101924);
                C38177u.m64616a(C38177u.this, str);
                AppMethodBeat.m2505o(101924);
            }
        });
        AppMethodBeat.m2505o(101934);
    }

    /* renamed from: h */
    static /* synthetic */ void m64623h(C38177u c38177u) {
        AppMethodBeat.m2504i(101936);
        if (c38177u.hjR.isBusy() || !c38177u.hjR.isReady()) {
            c38177u.hkM.setImageResource(C25738R.drawable.f6380ca);
            c38177u.hkF.setText(c38177u.getContext().getString(C25738R.string.f9040nd));
            AppMethodBeat.m2505o(101936);
            return;
        }
        c38177u.hkM.setImageResource(C25738R.drawable.f6381cb);
        c38177u.hkF.setText(c38177u.getContext().getString(C25738R.string.f9041ne));
        AppMethodBeat.m2505o(101936);
    }

    /* renamed from: j */
    static /* synthetic */ void m64625j(C38177u c38177u) {
        AppMethodBeat.m2504i(101938);
        c38177u.hkH.setText(c38177u.getContext().getString(C25738R.string.f9037na, new Object[]{Integer.valueOf(c38177u.hjR.hjF.size()), Integer.valueOf(c38177u.hjR.hjE.size()), Long.valueOf(c38177u.hjR.hjK)}));
        AppMethodBeat.m2505o(101938);
    }

    /* renamed from: a */
    static /* synthetic */ void m64616a(C38177u c38177u, String str) {
        AppMethodBeat.m2504i(101939);
        c38177u.hkE.add(0, str);
        while (c38177u.hkE.size() > 10) {
            c38177u.hkE.removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = c38177u.hkE.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        c38177u.hkL.setText(stringBuilder.toString());
        if (c38177u.hkP) {
            c38177u.hkL.setVisibility(0);
            AppMethodBeat.m2505o(101939);
            return;
        }
        c38177u.hkL.setVisibility(8);
        AppMethodBeat.m2505o(101939);
    }
}
