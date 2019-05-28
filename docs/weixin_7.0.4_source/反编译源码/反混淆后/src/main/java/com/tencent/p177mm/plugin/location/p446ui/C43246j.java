package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.location.ui.j */
public final class C43246j {
    /* renamed from: TF */
    TextView f17204TF;
    Context context;
    private String elp;
    C7306ak mHandler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(113521);
            super.handleMessage(message);
            C43246j c43246j;
            Message obtain;
            String mJ;
            switch (message.what) {
                case 1:
                    C43246j.this.f17204TF.setText(C43246j.this.nNj);
                    AppMethodBeat.m2505o(113521);
                    return;
                case 2:
                    C4990ab.m7411d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", Boolean.valueOf(C43246j.this.nMO), Boolean.valueOf(C43246j.this.nNi));
                    if (!(C43246j.this.nMO || C43246j.this.nNi)) {
                        c43246j = C43246j.this;
                        c43246j.f17204TF.setTextColor(c43246j.nNf);
                        c43246j.f17204TF.invalidate();
                        int intValue = ((Integer) message.obj).intValue();
                        if (intValue == 0) {
                            C43246j.this.f17204TF.setText(C43246j.this.context.getString(C25738R.string.exl));
                            AppMethodBeat.m2505o(113521);
                            return;
                        }
                        C43246j.this.f17204TF.setText(C43246j.this.context.getResources().getQuantityString(C25738R.plurals.f9620a7, intValue, new Object[]{Integer.valueOf(intValue)}));
                        AppMethodBeat.m2505o(113521);
                        return;
                    }
                case 3:
                    if (C43246j.this.nNi || C43246j.this.nMO) {
                        removeMessages(3);
                        obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        AppMethodBeat.m2505o(113521);
                        return;
                    }
                    C43246j.this.nNj = C43246j.this.f17204TF.getText().toString();
                    C43246j.m76914a(C43246j.this);
                    mJ = C1854s.m3866mJ((String) message.obj);
                    C43246j.this.f17204TF.setText(C43246j.this.context.getString(C25738R.string.exr, new Object[]{mJ}));
                    if (C43246j.this.nMO || C43246j.this.nNi) {
                        C43246j.m76915b(C43246j.this);
                        AppMethodBeat.m2505o(113521);
                        return;
                    }
                    break;
                case 4:
                    if (C43246j.this.nNi || C43246j.this.nMO) {
                        removeMessages(4);
                        obtain = Message.obtain();
                        obtain.what = 4;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        AppMethodBeat.m2505o(113521);
                        return;
                    }
                    C43246j.this.nNj = C43246j.this.f17204TF.getText().toString();
                    C43246j.m76914a(C43246j.this);
                    mJ = C1854s.m3866mJ((String) message.obj);
                    C43246j.this.f17204TF.setText(C43246j.this.context.getString(C25738R.string.exs, new Object[]{mJ}));
                    if (C43246j.this.nMO || C43246j.this.nNi) {
                        C43246j.m76915b(C43246j.this);
                        AppMethodBeat.m2505o(113521);
                        return;
                    }
                    break;
                case 5:
                    C43246j.this.nNi = true;
                    C43246j.this.nMO = false;
                    C43246j.m76914a(C43246j.this);
                    mJ = C1854s.m3866mJ((String) message.obj);
                    C43246j.this.f17204TF.setText(C43246j.this.context.getString(C25738R.string.ext, new Object[]{mJ}));
                    AppMethodBeat.m2505o(113521);
                    return;
                case 6:
                    C43246j.this.nMO = true;
                    C43246j.this.nNi = false;
                    C43246j.m76914a(C43246j.this);
                    C43246j.this.f17204TF.setText(C43246j.this.context.getString(C25738R.string.exq));
                    AppMethodBeat.m2505o(113521);
                    return;
                case 7:
                    C43246j.this.nNi = true;
                    c43246j = C43246j.this;
                    c43246j.f17204TF.setTextColor(c43246j.nNg);
                    c43246j.f17204TF.invalidate();
                    C43246j.this.f17204TF.setText(C43246j.this.context.getString(C25738R.string.exv));
                    C43246j.this.nNj = C43246j.this.f17204TF.getText().toString();
                    C43246j.m76915b(C43246j.this);
                    AppMethodBeat.m2505o(113521);
                    return;
                case 8:
                    c43246j = C43246j.this;
                    c43246j.f17204TF.setTextColor(c43246j.nNh);
                    c43246j.f17204TF.invalidate();
                    C43246j.this.f17204TF.setText(C43246j.this.context.getString(C25738R.string.exw));
                    AppMethodBeat.m2505o(113521);
                    return;
                case 9:
                    C43246j.this.nMO = false;
                    if (!C43246j.this.nNi) {
                        C43246j.this.mo68769iC(true);
                        AppMethodBeat.m2505o(113521);
                        return;
                    }
                    break;
                case 10:
                    C43246j.this.nNi = false;
                    C43246j.this.mo68769iC(false);
                    break;
            }
            AppMethodBeat.m2505o(113521);
        }
    };
    boolean nMO = false;
    private ViewGroup nMQ;
    ArrayList<String> nMR;
    private final int nMS = 100;
    private final int nMT = 1;
    private final int nMU = 2;
    private final int nMV = 3;
    private final int nMW = 4;
    private final int nMX = 5;
    private final int nMY = 6;
    private final int nMZ = 7;
    private final int nNa = 8;
    private final int nNb = 9;
    private final int nNc = 10;
    boolean nNd = true;
    private int nNe = Color.parseColor("#44FEBB");
    int nNf = Color.parseColor("#FFFFFF");
    int nNg = Color.parseColor("#E54646");
    int nNh = Color.parseColor("#FFC90C");
    boolean nNi = false;
    String nNj = "";

    public C43246j(Context context, ViewGroup viewGroup, String str) {
        AppMethodBeat.m2504i(113522);
        this.context = context;
        this.nMQ = viewGroup;
        this.f17204TF = (TextView) this.nMQ.findViewById(2131820678);
        this.elp = str;
        init();
        AppMethodBeat.m2505o(113522);
    }

    private void init() {
        AppMethodBeat.m2504i(113523);
        C4990ab.m7410d("MicroMsg.ShareHeaderMsgMgr", "init");
        this.f17204TF.invalidate();
        this.nMR = new ArrayList();
        for (String add : C39287l.bJz().mo20564tP(this.elp)) {
            this.nMR.add(add);
        }
        mo68769iC(false);
        AppMethodBeat.m2505o(113523);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: iC */
    public final void mo68769iC(boolean z) {
        AppMethodBeat.m2504i(113524);
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.nMR.size());
        C4990ab.m7411d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", Integer.valueOf(this.nMR.size()), Boolean.valueOf(z));
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
            AppMethodBeat.m2505o(113524);
            return;
        }
        this.mHandler.sendMessage(obtain);
        AppMethodBeat.m2505o(113524);
    }

    /* renamed from: a */
    static /* synthetic */ void m76914a(C43246j c43246j) {
        AppMethodBeat.m2504i(113525);
        c43246j.f17204TF.setTextColor(c43246j.nNe);
        c43246j.f17204TF.invalidate();
        AppMethodBeat.m2505o(113525);
    }

    /* renamed from: b */
    static /* synthetic */ void m76915b(C43246j c43246j) {
        AppMethodBeat.m2504i(113526);
        c43246j.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        c43246j.mHandler.sendMessageDelayed(obtain, 100);
        AppMethodBeat.m2505o(113526);
    }
}
