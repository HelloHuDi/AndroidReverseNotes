package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.LinkedList;

public final class b implements a, a.a, o {
    private String eFp;
    private int gOW;
    ProgressDialog gqo;
    c iHe;
    String igi;
    ad ldh;
    Context mContext;
    private n vjS;
    f vjT;
    private boolean vjU;

    public b(Context context, String str, n nVar) {
        this(context, str, 0, nVar, true, "");
    }

    public b(Context context, String str, int i, n nVar, String str2) {
        this(context, str, i, nVar, true, str2);
    }

    public b(Context context, String str, int i, n nVar, boolean z, String str2) {
        this.vjT = null;
        this.vjU = true;
        this.mContext = context;
        this.igi = str;
        this.gOW = i;
        this.vjS = nVar;
        this.vjU = z;
        this.eFp = str2;
    }

    public final void show() {
        AppMethodBeat.i(27629);
        g.RQ();
        this.ldh = ((j) g.K(j.class)).XM().aoO(this.igi);
        if (this.ldh != null && ((int) this.ldh.ewQ) <= 0) {
            ab.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", this.igi);
            g.RQ();
            this.ldh = ((j) g.K(j.class)).XM().aoK(this.igi);
        }
        Context context;
        if (this.ldh != null && ((int) this.ldh.ewQ) > 0) {
            ab.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
            if (this.ldh == null) {
                ab.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
                kx(-1);
                AppMethodBeat.o(27629);
                return;
            }
            String str = this.ldh.field_username;
            if (this.ldh.dsf()) {
                if (com.tencent.mm.n.a.jh(this.ldh.field_type)) {
                    h.bQ(this.mContext, this.mContext.getResources().getString(R.string.g2g));
                    kx(-2);
                    AppMethodBeat.o(27629);
                    return;
                }
                U(this.ldh);
                AppMethodBeat.o(27629);
            } else if (((com.tencent.mm.api.j) g.K(com.tencent.mm.api.j.class)).cJ(str)) {
                context = this.mContext;
                this.mContext.getString(R.string.tz);
                this.gqo = h.b(context, this.mContext.getString(R.string.g2d), true, null);
                ajx(str);
                AppMethodBeat.o(27629);
            } else {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.acy);
                if ((this.mContext instanceof MMActivity) && g.a(((MMActivity) this.mContext).mController, decodeResource, this.mContext.getResources().getString(R.string.g2i), new q.a() {
                    public final void a(boolean z, String str, int i) {
                        AppMethodBeat.i(27628);
                        ab.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
                        b.this.kx(-1);
                        AppMethodBeat.o(27628);
                    }
                }) == null) {
                    ab.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
                    kx(-1);
                }
                AppMethodBeat.o(27629);
            }
        } else if (this.mContext == null) {
            AppMethodBeat.o(27629);
        } else {
            context = this.mContext;
            this.mContext.getString(R.string.tz);
            this.gqo = h.b(context, this.mContext.getString(R.string.g2d), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(27624);
                    if (b.this.gqo != null) {
                        b.this.gqo.dismiss();
                        b.this.gqo = null;
                    }
                    AppMethodBeat.o(27624);
                }
            });
            ajx(this.igi);
            AppMethodBeat.o(27629);
        }
    }

    /* Access modifiers changed, original: final */
    public final void U(final ad adVar) {
        AppMethodBeat.i(27630);
        if (adVar == null) {
            ab.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
            kx(-1);
            AppMethodBeat.o(27630);
            return;
        }
        String string = this.mContext.getString(R.string.g2a);
        Bitmap a = com.tencent.mm.ah.b.a(adVar.field_username, false, -1);
        if (a == null) {
            o.acd().a((a) this);
        }
        if (a != null && adVar.dsf()) {
            a = d.a(a, false, (float) (a.getWidth() / 2));
        }
        String str = adVar.field_nickname;
        this.iHe = null;
        if (this.mContext instanceof MMActivity) {
            if (this.vjU) {
                this.iHe = g.a(((MMActivity) this.mContext).mController, string, a, str, "", new q.a() {
                    public final void a(boolean z, String str, int i) {
                        AppMethodBeat.i(27625);
                        if (z) {
                            b.this.V(adVar);
                        } else {
                            b.this.kx(0);
                        }
                        b.this.iHe.dismiss();
                        AppMethodBeat.o(27625);
                    }
                });
            } else {
                V(adVar);
                AppMethodBeat.o(27630);
                return;
            }
        }
        if (this.iHe == null) {
            ab.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
            kx(-1);
        }
        AppMethodBeat.o(27630);
    }

    /* Access modifiers changed, original: final */
    public final void V(ad adVar) {
        AppMethodBeat.i(27631);
        if (this.gqo != null) {
            this.gqo.dismiss();
        }
        Context context = this.mContext;
        this.mContext.getString(R.string.tz);
        this.gqo = h.b(context, this.mContext.getString(R.string.g2d), true, null);
        a aVar = new a(this.mContext, this);
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.gOW));
        aVar.a(adVar.field_username, linkedList, this.eFp);
        AppMethodBeat.o(27631);
    }

    public final void qj(String str) {
        Object obj = 1;
        AppMethodBeat.i(27632);
        if (this.ldh != null) {
            Object obj2 = (this.ldh.field_username == null || !this.ldh.field_username.equals(str)) ? null : 1;
            if (this.ldh.Hq() == null || !this.ldh.Hq().equals(str)) {
                obj = null;
            }
            if (obj2 == null && obj == null) {
                AppMethodBeat.o(27632);
                return;
            }
        } else if (this.igi == null || !this.igi.equals(str)) {
            AppMethodBeat.o(27632);
            return;
        }
        if (this.iHe == null || !this.iHe.isShowing()) {
            AppMethodBeat.o(27632);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27626);
                ImageView imageView = (ImageView) b.this.iHe.getContentView().findViewById(R.id.b0_);
                if (imageView != null) {
                    Bitmap a = com.tencent.mm.ah.b.a(b.this.ldh.field_username, false, -1);
                    if (a != null && b.this.ldh.dsf()) {
                        a = d.a(a, false, (float) (a.getWidth() / 2));
                    }
                    if (!(a == null || a.isRecycled())) {
                        imageView.setImageBitmap(a);
                        imageView.setVisibility(0);
                    }
                }
                AppMethodBeat.o(27626);
            }
        });
        AppMethodBeat.o(27632);
    }

    private void ajx(String str) {
        AppMethodBeat.i(27633);
        ab.i("MicroMsg.AddContactDialog", "searchContact %s", str);
        if (this.vjT == null) {
            this.vjT = new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(27627);
                    if (b.this.gqo != null) {
                        b.this.gqo.dismiss();
                    }
                    if (b.this.vjT != null) {
                        g.RQ();
                        g.RO().eJo.b(106, b.this.vjT);
                    }
                    if (b.this.gqo == null) {
                        ab.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
                        b.this.kx(0);
                        AppMethodBeat.o(27627);
                    } else if (i != 0 || i2 != 0) {
                        ab.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                        b.this.kx(-1);
                        AppMethodBeat.o(27627);
                    } else if (b.this.mContext == null) {
                        ab.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
                        b.this.kx(-1);
                        AppMethodBeat.o(27627);
                    } else if ((b.this.mContext instanceof Activity) && ((Activity) b.this.mContext).isFinishing()) {
                        ab.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
                        b.this.kx(-1);
                        AppMethodBeat.o(27627);
                    } else {
                        buv bOj = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
                        String a = aa.a(bOj.wcB);
                        if (bo.isNullOrNil(a)) {
                            ab.e("MicroMsg.AddContactDialog", "searchContact, user is null");
                            h.bQ(b.this.mContext, b.this.mContext.getResources().getString(R.string.g2c));
                            b.this.kx(-1);
                            AppMethodBeat.o(27627);
                            return;
                        }
                        if (b.this.igi == null || !b.this.igi.equals(a)) {
                            ab.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", b.this.igi, a);
                        }
                        b bVar = b.this;
                        g.RQ();
                        bVar.ldh = ((j) g.K(j.class)).XM().aoO(a);
                        if (b.this.ldh == null || ((int) b.this.ldh.ewQ) == 0) {
                            ab.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + a + ", try get by alias");
                            bVar = b.this;
                            g.RQ();
                            bVar.ldh = ((j) g.K(j.class)).XM().aoK(a);
                            if (b.this.ldh == null || ((int) b.this.ldh.ewQ) == 0) {
                                ab.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
                                b.this.ldh = new ad(a);
                                b.this.ldh.iy(bOj.guS);
                                b.this.ldh.iB(aa.a(bOj.wyX));
                                b.this.ldh.iC(aa.a(bOj.wce));
                                b.this.ldh.iD(aa.a(bOj.wcf));
                                b.this.ldh.hA(bOj.guN);
                                b.this.ldh.iW(RegionCodeDecoder.aC(bOj.guW, bOj.guO, bOj.guP));
                                b.this.ldh.iQ(bOj.guQ);
                                b.this.ldh.hw(bOj.wBT);
                                b.this.ldh.iV(bOj.wBU);
                                b.this.ldh.hv(bOj.wBX);
                                b.this.ldh.iE(bOj.wBW);
                                b.this.ldh.iU(bOj.wBV);
                            }
                        } else {
                            ab.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", a);
                        }
                        b.this.U(b.this.ldh);
                        AppMethodBeat.o(27627);
                    }
                }
            };
        }
        g.RQ();
        g.RO().eJo.a(106, this.vjT);
        m fVar = new com.tencent.mm.plugin.messenger.a.f(str);
        g.RQ();
        g.RO().eJo.a(fVar, 0);
        AppMethodBeat.o(27633);
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        AppMethodBeat.i(27634);
        if (this.gqo != null) {
            this.gqo.dismiss();
        }
        if (z) {
            this.ldh.NB();
            g.RQ();
            ((j) g.K(j.class)).XM().b(this.ldh.field_username, this.ldh);
            h.bQ(this.mContext, this.mContext.getResources().getString(R.string.g2g));
            kx(1);
            AppMethodBeat.o(27634);
            return;
        }
        kx(-1);
        AppMethodBeat.o(27634);
    }

    /* Access modifiers changed, original: final */
    public final void kx(int i) {
        AppMethodBeat.i(27635);
        if (this.vjS != null) {
            this.vjS.nZ(i);
        }
        AppMethodBeat.o(27635);
    }
}
