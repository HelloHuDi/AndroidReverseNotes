package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32250j;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.b */
public final class C35835b implements C8915a, C14917a, C40462o {
    private String eFp;
    private int gOW;
    ProgressDialog gqo;
    C5653c iHe;
    String igi;
    C7616ad ldh;
    Context mContext;
    private C40461n vjS;
    C1202f vjT;
    private boolean vjU;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.b$4 */
    class C72414 implements C1202f {
        C72414() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(27627);
            if (C35835b.this.gqo != null) {
                C35835b.this.gqo.dismiss();
            }
            if (C35835b.this.vjT != null) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14546b(106, C35835b.this.vjT);
            }
            if (C35835b.this.gqo == null) {
                C4990ab.m7412e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
                C35835b.this.mo56632kx(0);
                AppMethodBeat.m2505o(27627);
            } else if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                C35835b.this.mo56632kx(-1);
                AppMethodBeat.m2505o(27627);
            } else if (C35835b.this.mContext == null) {
                C4990ab.m7412e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
                C35835b.this.mo56632kx(-1);
                AppMethodBeat.m2505o(27627);
            } else if ((C35835b.this.mContext instanceof Activity) && ((Activity) C35835b.this.mContext).isFinishing()) {
                C4990ab.m7412e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
                C35835b.this.mo56632kx(-1);
                AppMethodBeat.m2505o(27627);
            } else {
                buv bOj = ((C12518f) c1207m).bOj();
                String a = C1946aa.m4148a(bOj.wcB);
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7412e("MicroMsg.AddContactDialog", "searchContact, user is null");
                    C30379h.m48465bQ(C35835b.this.mContext, C35835b.this.mContext.getResources().getString(C25738R.string.g2c));
                    C35835b.this.mo56632kx(-1);
                    AppMethodBeat.m2505o(27627);
                    return;
                }
                if (C35835b.this.igi == null || !C35835b.this.igi.equals(a)) {
                    C4990ab.m7421w("MicroMsg.AddContactDialog", "user not the same, %s, %s", C35835b.this.igi, a);
                }
                C35835b c35835b = C35835b.this;
                C1720g.m3537RQ();
                c35835b.ldh = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(a);
                if (C35835b.this.ldh == null || ((int) C35835b.this.ldh.ewQ) == 0) {
                    C4990ab.m7416i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + a + ", try get by alias");
                    c35835b = C35835b.this;
                    C1720g.m3537RQ();
                    c35835b.ldh = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(a);
                    if (C35835b.this.ldh == null || ((int) C35835b.this.ldh.ewQ) == 0) {
                        C4990ab.m7416i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
                        C35835b.this.ldh = new C7616ad(a);
                        C35835b.this.ldh.mo14728iy(bOj.guS);
                        C35835b.this.ldh.mo14703iB(C1946aa.m4148a(bOj.wyX));
                        C35835b.this.ldh.mo14704iC(C1946aa.m4148a(bOj.wce));
                        C35835b.this.ldh.mo14705iD(C1946aa.m4148a(bOj.wcf));
                        C35835b.this.ldh.mo14685hA(bOj.guN);
                        C35835b.this.ldh.mo14724iW(RegionCodeDecoder.m7796aC(bOj.guW, bOj.guO, bOj.guP));
                        C35835b.this.ldh.mo14718iQ(bOj.guQ);
                        C35835b.this.ldh.mo14698hw(bOj.wBT);
                        C35835b.this.ldh.mo14723iV(bOj.wBU);
                        C35835b.this.ldh.mo14697hv(bOj.wBX);
                        C35835b.this.ldh.mo14706iE(bOj.wBW);
                        C35835b.this.ldh.mo14722iU(bOj.wBV);
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", a);
                }
                C35835b.this.mo56630U(C35835b.this.ldh);
                AppMethodBeat.m2505o(27627);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.b$5 */
    class C232695 implements C30111a {
        C232695() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(27628);
            C4990ab.m7412e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
            C35835b.this.mo56632kx(-1);
            AppMethodBeat.m2505o(27628);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.b$1 */
    class C358321 implements OnCancelListener {
        C358321() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(27624);
            if (C35835b.this.gqo != null) {
                C35835b.this.gqo.dismiss();
                C35835b.this.gqo = null;
            }
            AppMethodBeat.m2505o(27624);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.b$3 */
    class C358343 implements Runnable {
        C358343() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27626);
            ImageView imageView = (ImageView) C35835b.this.iHe.getContentView().findViewById(2131822922);
            if (imageView != null) {
                Bitmap a = C41730b.m73490a(C35835b.this.ldh.field_username, false, -1);
                if (a != null && C35835b.this.ldh.dsf()) {
                    a = C5056d.m7616a(a, false, (float) (a.getWidth() / 2));
                }
                if (!(a == null || a.isRecycled())) {
                    imageView.setImageBitmap(a);
                    imageView.setVisibility(0);
                }
            }
            AppMethodBeat.m2505o(27626);
        }
    }

    public C35835b(Context context, String str, C40461n c40461n) {
        this(context, str, 0, c40461n, true, "");
    }

    public C35835b(Context context, String str, int i, C40461n c40461n, String str2) {
        this(context, str, i, c40461n, true, str2);
    }

    public C35835b(Context context, String str, int i, C40461n c40461n, boolean z, String str2) {
        this.vjT = null;
        this.vjU = true;
        this.mContext = context;
        this.igi = str;
        this.gOW = i;
        this.vjS = c40461n;
        this.vjU = z;
        this.eFp = str2;
    }

    public final void show() {
        AppMethodBeat.m2504i(27629);
        C1720g.m3537RQ();
        this.ldh = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.igi);
        if (this.ldh != null && ((int) this.ldh.ewQ) <= 0) {
            C4990ab.m7417i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", this.igi);
            C1720g.m3537RQ();
            this.ldh = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(this.igi);
        }
        Context context;
        if (this.ldh != null && ((int) this.ldh.ewQ) > 0) {
            C4990ab.m7416i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
            if (this.ldh == null) {
                C4990ab.m7412e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
                mo56632kx(-1);
                AppMethodBeat.m2505o(27629);
                return;
            }
            String str = this.ldh.field_username;
            if (this.ldh.dsf()) {
                if (C7486a.m12942jh(this.ldh.field_type)) {
                    C30379h.m48465bQ(this.mContext, this.mContext.getResources().getString(C25738R.string.g2g));
                    mo56632kx(-2);
                    AppMethodBeat.m2505o(27629);
                    return;
                }
                mo56630U(this.ldh);
                AppMethodBeat.m2505o(27629);
            } else if (((C32250j) C1720g.m3528K(C32250j.class)).mo20993cJ(str)) {
                context = this.mContext;
                this.mContext.getString(C25738R.string.f9238tz);
                this.gqo = C30379h.m48458b(context, this.mContext.getString(C25738R.string.g2d), true, null);
                ajx(str);
                AppMethodBeat.m2505o(27629);
            } else {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), C25738R.drawable.acy);
                if ((this.mContext instanceof MMActivity) && C35844g.m58757a(((MMActivity) this.mContext).mController, decodeResource, this.mContext.getResources().getString(C25738R.string.g2i), new C232695()) == null) {
                    C4990ab.m7412e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
                    mo56632kx(-1);
                }
                AppMethodBeat.m2505o(27629);
            }
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(27629);
        } else {
            context = this.mContext;
            this.mContext.getString(C25738R.string.f9238tz);
            this.gqo = C30379h.m48458b(context, this.mContext.getString(C25738R.string.g2d), true, new C358321());
            ajx(this.igi);
            AppMethodBeat.m2505o(27629);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: U */
    public final void mo56630U(final C7616ad c7616ad) {
        AppMethodBeat.m2504i(27630);
        if (c7616ad == null) {
            C4990ab.m7412e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
            mo56632kx(-1);
            AppMethodBeat.m2505o(27630);
            return;
        }
        String string = this.mContext.getString(C25738R.string.g2a);
        Bitmap a = C41730b.m73490a(c7616ad.field_username, false, -1);
        if (a == null) {
            C17884o.acd().mo67498a((C8915a) this);
        }
        if (a != null && c7616ad.dsf()) {
            a = C5056d.m7616a(a, false, (float) (a.getWidth() / 2));
        }
        String str = c7616ad.field_nickname;
        this.iHe = null;
        if (this.mContext instanceof MMActivity) {
            if (this.vjU) {
                this.iHe = C35844g.m58762a(((MMActivity) this.mContext).mController, string, a, str, "", new C30111a() {
                    /* renamed from: a */
                    public final void mo6399a(boolean z, String str, int i) {
                        AppMethodBeat.m2504i(27625);
                        if (z) {
                            C35835b.this.mo56631V(c7616ad);
                        } else {
                            C35835b.this.mo56632kx(0);
                        }
                        C35835b.this.iHe.dismiss();
                        AppMethodBeat.m2505o(27625);
                    }
                });
            } else {
                mo56631V(c7616ad);
                AppMethodBeat.m2505o(27630);
                return;
            }
        }
        if (this.iHe == null) {
            C4990ab.m7412e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
            mo56632kx(-1);
        }
        AppMethodBeat.m2505o(27630);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: V */
    public final void mo56631V(C7616ad c7616ad) {
        AppMethodBeat.m2504i(27631);
        if (this.gqo != null) {
            this.gqo.dismiss();
        }
        Context context = this.mContext;
        this.mContext.getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b(context, this.mContext.getString(C25738R.string.g2d), true, null);
        C14916a c14916a = new C14916a(this.mContext, this);
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.gOW));
        c14916a.mo27240a(c7616ad.field_username, linkedList, this.eFp);
        AppMethodBeat.m2505o(27631);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        Object obj = 1;
        AppMethodBeat.m2504i(27632);
        if (this.ldh != null) {
            Object obj2 = (this.ldh.field_username == null || !this.ldh.field_username.equals(str)) ? null : 1;
            if (this.ldh.mo14673Hq() == null || !this.ldh.mo14673Hq().equals(str)) {
                obj = null;
            }
            if (obj2 == null && obj == null) {
                AppMethodBeat.m2505o(27632);
                return;
            }
        } else if (this.igi == null || !this.igi.equals(str)) {
            AppMethodBeat.m2505o(27632);
            return;
        }
        if (this.iHe == null || !this.iHe.isShowing()) {
            AppMethodBeat.m2505o(27632);
            return;
        }
        C5004al.m7441d(new C358343());
        AppMethodBeat.m2505o(27632);
    }

    private void ajx(String str) {
        AppMethodBeat.m2504i(27633);
        C4990ab.m7417i("MicroMsg.AddContactDialog", "searchContact %s", str);
        if (this.vjT == null) {
            this.vjT = new C72414();
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(106, this.vjT);
        C1207m c12518f = new C12518f(str);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c12518f, 0);
        AppMethodBeat.m2505o(27633);
    }

    /* renamed from: a */
    public final void mo5739a(boolean z, boolean z2, String str, String str2) {
        AppMethodBeat.m2504i(27634);
        if (this.gqo != null) {
            this.gqo.dismiss();
        }
        if (z) {
            this.ldh.mo16676NB();
            C1720g.m3537RQ();
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(this.ldh.field_username, this.ldh);
            C30379h.m48465bQ(this.mContext, this.mContext.getResources().getString(C25738R.string.g2g));
            mo56632kx(1);
            AppMethodBeat.m2505o(27634);
            return;
        }
        mo56632kx(-1);
        AppMethodBeat.m2505o(27634);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kx */
    public final void mo56632kx(int i) {
        AppMethodBeat.m2504i(27635);
        if (this.vjS != null) {
            this.vjS.mo6042nZ(i);
        }
        AppMethodBeat.m2505o(27635);
    }
}
