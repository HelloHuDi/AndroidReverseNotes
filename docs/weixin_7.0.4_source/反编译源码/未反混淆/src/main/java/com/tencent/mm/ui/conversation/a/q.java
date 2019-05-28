package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends b {
    private TextView gnB;
    private ImageView iqT;
    private View jAp = null;
    private boolean zwX = false;
    boolean zxl = false;
    private c zxm;

    public q(Context context) {
        super(context);
        AppMethodBeat.i(34735);
        if (!(this.zwX || this.view == null)) {
            this.jAp = this.view.findViewById(R.id.ezd);
            this.gnB = (TextView) this.view.findViewById(R.id.ezf);
            this.iqT = (ImageView) this.view.findViewById(R.id.eze);
            this.zwX = true;
            this.zxm = new c<iv>() {
                {
                    AppMethodBeat.i(34732);
                    this.xxI = iv.class.getName().hashCode();
                    AppMethodBeat.o(34732);
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(34733);
                    if (((iv) bVar).cDY.cCA) {
                        q.this.zxl = false;
                        q.this.aMN();
                    } else {
                        ab.i("MicroMsg.TryNewInitBanner", "summerinit onSceneEnd -1 show tryNewInitBanner[%s]", q.this);
                        q.this.zxl = true;
                        q.this.aMN();
                    }
                    AppMethodBeat.o(34733);
                    return false;
                }
            };
            a.xxA.c(this.zxm);
        }
        AppMethodBeat.o(34735);
    }

    public final int getLayoutId() {
        return R.layout.b0u;
    }

    public final boolean aMN() {
        AppMethodBeat.i(34736);
        if (!this.zxl) {
            ab.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", Boolean.valueOf(this.zxl));
            this.jAp.setVisibility(8);
            AppMethodBeat.o(34736);
            return false;
        } else if (k.ahT()) {
            boolean z;
            this.gnB.setText(R.string.a5j);
            this.iqT.setVisibility(0);
            this.jAp.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34734);
                    ab.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
                    q.this.setVisibility(8);
                    a.xxA.m(new tl());
                    ab.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
                    AppMethodBeat.o(34734);
                }
            });
            this.jAp.setVisibility(0);
            String str = "MicroMsg.TryNewInitBanner";
            String str2 = "summerinit update set visible [%b]";
            Object[] objArr = new Object[1];
            if (this.jAp.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            AppMethodBeat.o(34736);
            return true;
        } else {
            ab.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
            this.zxl = false;
            this.jAp.setVisibility(8);
            AppMethodBeat.o(34736);
            return false;
        }
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(34737);
        if (this.jAp != null) {
            this.jAp.setVisibility(i);
        }
        AppMethodBeat.o(34737);
    }

    public final void destroy() {
        AppMethodBeat.i(34738);
        a.xxA.d(this.zxm);
        AppMethodBeat.o(34738);
    }
}
