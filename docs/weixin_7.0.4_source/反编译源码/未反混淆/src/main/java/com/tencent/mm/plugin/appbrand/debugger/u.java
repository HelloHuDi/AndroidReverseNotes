package com.tencent.mm.plugin.appbrand.debugger;

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
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class u extends FrameLayout {
    private l hjR;
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
    private a hkQ;
    private c hkR;
    OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(101918);
            u uVar = u.this;
            if (view.getId() == R.id.v8) {
                uVar.hkP = true;
                uVar.show();
                RemoteDebugMoveView remoteDebugMoveView = uVar.hkD;
                remoteDebugMoveView.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(101854);
                        if (RemoteDebugMoveView.this.getY() + ((float) RemoteDebugMoveView.this.getHeight()) > ((float) RemoteDebugMoveView.this.hkd)) {
                            RemoteDebugMoveView.this.setY((float) (RemoteDebugMoveView.this.hkd - RemoteDebugMoveView.this.getHeight()));
                        }
                        AppMethodBeat.o(101854);
                    }
                }, 50);
                AppMethodBeat.o(101918);
            } else if (view.getId() == R.id.vg) {
                uVar.hkP = false;
                uVar.show();
                AppMethodBeat.o(101918);
            } else {
                if (view.getId() == R.id.vf) {
                    uVar.azu();
                }
                AppMethodBeat.o(101918);
            }
        }
    };

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.u$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ int hkT;
        final /* synthetic */ cqm hkU;

        AnonymousClass8(int i, cqm cqm) {
            this.hkT = i;
            this.hkU = cqm;
        }

        public final void run() {
            AppMethodBeat.i(101923);
            u.a(u.this, "cmdId " + this.hkT + ", errCode " + this.hkU.cyE);
            AppMethodBeat.o(101923);
        }
    }

    public interface a {
        void azf();
    }

    static /* synthetic */ boolean c(u uVar) {
        AppMethodBeat.i(101935);
        boolean azt = uVar.azt();
        AppMethodBeat.o(101935);
        return azt;
    }

    static /* synthetic */ void i(u uVar) {
        AppMethodBeat.i(101937);
        uVar.azu();
        AppMethodBeat.o(101937);
    }

    public u(Context context, l lVar, a aVar) {
        super(context);
        AppMethodBeat.i(101925);
        this.hjR = lVar;
        this.hkQ = aVar;
        setLayoutParams(new LayoutParams(-1, -1));
        setBackgroundColor(getContext().getResources().getColor(R.color.a3p));
        setId(R.id.h);
        AppMethodBeat.o(101925);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101926);
        if (azt()) {
            AppMethodBeat.o(101926);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(101926);
        return onTouchEvent;
    }

    public final void bringToFront() {
        AppMethodBeat.i(101927);
        if (this.hkC == null) {
            ab.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
            AppMethodBeat.o(101927);
            return;
        }
        this.hkC.bringChildToFront(this);
        AppMethodBeat.o(101927);
    }

    public final void azs() {
        AppMethodBeat.i(101928);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(101917);
                if (u.this.hkC == null) {
                    ab.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
                    AppMethodBeat.o(101917);
                } else if (u.c(u.this)) {
                    u.this.setVisibility(0);
                    if (u.this.hkC.indexOfChild(u.this) == -1) {
                        u.this.hkC.addView(u.this);
                    }
                    u.this.hkC.bringChildToFront(u.this);
                    u.this.setBackgroundColor(u.this.getContext().getResources().getColor(R.color.rr));
                    AppMethodBeat.o(101917);
                } else {
                    u.this.setBackgroundColor(u.this.getContext().getResources().getColor(R.color.a3p));
                    AppMethodBeat.o(101917);
                }
            }
        });
        AppMethodBeat.o(101928);
    }

    private boolean azt() {
        AppMethodBeat.i(101929);
        if (this.hjR.azb() || this.hjR.azc() || this.hjR.azd()) {
            AppMethodBeat.o(101929);
            return true;
        }
        AppMethodBeat.o(101929);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void azu() {
        AppMethodBeat.i(101930);
        if (this.hkR == null || !this.hkR.isShowing()) {
            Context context = getContext();
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                AppMethodBeat.o(101930);
                return;
            }
            this.hkR = new com.tencent.mm.ui.widget.a.c.a(context).asD(context.getString(R.string.nc)).asE("").Qc(R.string.abo).a(new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(101919);
                    if (u.this.hkQ != null) {
                        u.this.hkQ.azf();
                    }
                    AppMethodBeat.o(101919);
                }
            }).Qd(R.string.abn).aMb();
            this.hkR.show();
            AppMethodBeat.o(101930);
            return;
        }
        AppMethodBeat.o(101930);
    }

    public final void azv() {
        AppMethodBeat.i(101931);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(101920);
                if (u.this.hjR.azb()) {
                    u.this.hkN.setImageResource(R.drawable.cb);
                    u.this.hkG.setText(u.this.getContext().getString(R.string.n8));
                } else if (u.this.hjR.isReady()) {
                    u.this.hkN.setImageResource(R.drawable.cb);
                    u.this.hkG.setText(u.this.getContext().getString(R.string.n9));
                } else {
                    u.this.hkN.setImageResource(R.drawable.ca);
                    u.this.hkG.setText(u.this.getContext().getString(R.string.n7));
                }
                u.h(u.this);
                AppMethodBeat.o(101920);
            }
        });
        AppMethodBeat.o(101931);
    }

    public final void show() {
        AppMethodBeat.i(101932);
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
        AppMethodBeat.o(101932);
    }

    public final void azw() {
        AppMethodBeat.i(101933);
        azs();
        azv();
        AppMethodBeat.o(101933);
    }

    public final void zQ(final String str) {
        AppMethodBeat.i(101934);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101934);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(101924);
                u.a(u.this, str);
                AppMethodBeat.o(101924);
            }
        });
        AppMethodBeat.o(101934);
    }

    static /* synthetic */ void h(u uVar) {
        AppMethodBeat.i(101936);
        if (uVar.hjR.isBusy() || !uVar.hjR.isReady()) {
            uVar.hkM.setImageResource(R.drawable.ca);
            uVar.hkF.setText(uVar.getContext().getString(R.string.nd));
            AppMethodBeat.o(101936);
            return;
        }
        uVar.hkM.setImageResource(R.drawable.cb);
        uVar.hkF.setText(uVar.getContext().getString(R.string.ne));
        AppMethodBeat.o(101936);
    }

    static /* synthetic */ void j(u uVar) {
        AppMethodBeat.i(101938);
        uVar.hkH.setText(uVar.getContext().getString(R.string.na, new Object[]{Integer.valueOf(uVar.hjR.hjF.size()), Integer.valueOf(uVar.hjR.hjE.size()), Long.valueOf(uVar.hjR.hjK)}));
        AppMethodBeat.o(101938);
    }

    static /* synthetic */ void a(u uVar, String str) {
        AppMethodBeat.i(101939);
        uVar.hkE.add(0, str);
        while (uVar.hkE.size() > 10) {
            uVar.hkE.removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = uVar.hkE.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        uVar.hkL.setText(stringBuilder.toString());
        if (uVar.hkP) {
            uVar.hkL.setVisibility(0);
            AppMethodBeat.o(101939);
            return;
        }
        uVar.hkL.setVisibility(8);
        AppMethodBeat.o(101939);
    }
}
