package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public final class j {
    TextView TF;
    Context context;
    private String elp;
    ak mHandler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(113521);
            super.handleMessage(message);
            j jVar;
            Message obtain;
            String mJ;
            switch (message.what) {
                case 1:
                    j.this.TF.setText(j.this.nNj);
                    AppMethodBeat.o(113521);
                    return;
                case 2:
                    ab.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", Boolean.valueOf(j.this.nMO), Boolean.valueOf(j.this.nNi));
                    if (!(j.this.nMO || j.this.nNi)) {
                        jVar = j.this;
                        jVar.TF.setTextColor(jVar.nNf);
                        jVar.TF.invalidate();
                        int intValue = ((Integer) message.obj).intValue();
                        if (intValue == 0) {
                            j.this.TF.setText(j.this.context.getString(R.string.exl));
                            AppMethodBeat.o(113521);
                            return;
                        }
                        j.this.TF.setText(j.this.context.getResources().getQuantityString(R.plurals.a7, intValue, new Object[]{Integer.valueOf(intValue)}));
                        AppMethodBeat.o(113521);
                        return;
                    }
                case 3:
                    if (j.this.nNi || j.this.nMO) {
                        removeMessages(3);
                        obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        AppMethodBeat.o(113521);
                        return;
                    }
                    j.this.nNj = j.this.TF.getText().toString();
                    j.a(j.this);
                    mJ = s.mJ((String) message.obj);
                    j.this.TF.setText(j.this.context.getString(R.string.exr, new Object[]{mJ}));
                    if (j.this.nMO || j.this.nNi) {
                        j.b(j.this);
                        AppMethodBeat.o(113521);
                        return;
                    }
                    break;
                case 4:
                    if (j.this.nNi || j.this.nMO) {
                        removeMessages(4);
                        obtain = Message.obtain();
                        obtain.what = 4;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        AppMethodBeat.o(113521);
                        return;
                    }
                    j.this.nNj = j.this.TF.getText().toString();
                    j.a(j.this);
                    mJ = s.mJ((String) message.obj);
                    j.this.TF.setText(j.this.context.getString(R.string.exs, new Object[]{mJ}));
                    if (j.this.nMO || j.this.nNi) {
                        j.b(j.this);
                        AppMethodBeat.o(113521);
                        return;
                    }
                    break;
                case 5:
                    j.this.nNi = true;
                    j.this.nMO = false;
                    j.a(j.this);
                    mJ = s.mJ((String) message.obj);
                    j.this.TF.setText(j.this.context.getString(R.string.ext, new Object[]{mJ}));
                    AppMethodBeat.o(113521);
                    return;
                case 6:
                    j.this.nMO = true;
                    j.this.nNi = false;
                    j.a(j.this);
                    j.this.TF.setText(j.this.context.getString(R.string.exq));
                    AppMethodBeat.o(113521);
                    return;
                case 7:
                    j.this.nNi = true;
                    jVar = j.this;
                    jVar.TF.setTextColor(jVar.nNg);
                    jVar.TF.invalidate();
                    j.this.TF.setText(j.this.context.getString(R.string.exv));
                    j.this.nNj = j.this.TF.getText().toString();
                    j.b(j.this);
                    AppMethodBeat.o(113521);
                    return;
                case 8:
                    jVar = j.this;
                    jVar.TF.setTextColor(jVar.nNh);
                    jVar.TF.invalidate();
                    j.this.TF.setText(j.this.context.getString(R.string.exw));
                    AppMethodBeat.o(113521);
                    return;
                case 9:
                    j.this.nMO = false;
                    if (!j.this.nNi) {
                        j.this.iC(true);
                        AppMethodBeat.o(113521);
                        return;
                    }
                    break;
                case 10:
                    j.this.nNi = false;
                    j.this.iC(false);
                    break;
            }
            AppMethodBeat.o(113521);
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

    public j(Context context, ViewGroup viewGroup, String str) {
        AppMethodBeat.i(113522);
        this.context = context;
        this.nMQ = viewGroup;
        this.TF = (TextView) this.nMQ.findViewById(R.id.cx);
        this.elp = str;
        init();
        AppMethodBeat.o(113522);
    }

    private void init() {
        AppMethodBeat.i(113523);
        ab.d("MicroMsg.ShareHeaderMsgMgr", "init");
        this.TF.invalidate();
        this.nMR = new ArrayList();
        for (String add : l.bJz().tP(this.elp)) {
            this.nMR.add(add);
        }
        iC(false);
        AppMethodBeat.o(113523);
    }

    /* Access modifiers changed, original: final */
    public final void iC(boolean z) {
        AppMethodBeat.i(113524);
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.nMR.size());
        ab.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", Integer.valueOf(this.nMR.size()), Boolean.valueOf(z));
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
            AppMethodBeat.o(113524);
            return;
        }
        this.mHandler.sendMessage(obtain);
        AppMethodBeat.o(113524);
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(113525);
        jVar.TF.setTextColor(jVar.nNe);
        jVar.TF.invalidate();
        AppMethodBeat.o(113525);
    }

    static /* synthetic */ void b(j jVar) {
        AppMethodBeat.i(113526);
        jVar.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        jVar.mHandler.sendMessageDelayed(obtain, 100);
        AppMethodBeat.o(113526);
    }
}
