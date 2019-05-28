package com.tencent.p177mm.p612ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p612ui.chatting.gallery.C15663j.C15682a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C4783p;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoSightView;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.chatting.gallery.i */
public final class C30517i extends C23777a implements C42190a, C9721a, C5015a {
    private C42192d iaf;
    private HashMap<String, C15682a> yVF;
    private boolean yVG;

    public C30517i(C40775c c40775c) {
        super(c40775c);
        AppMethodBeat.m2504i(32177);
        this.yVG = false;
        this.yVG = false;
        this.yVF = new HashMap();
        C37961o.all().mo21053a(this, Looper.getMainLooper());
        this.iaf = new C42192d();
        AppMethodBeat.m2505o(32177);
    }

    /* renamed from: a */
    public final boolean mo27898a(C36180k c36180k, C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(32178);
        super.mo27898a(c36180k, c7620bi, i);
        C37961o.all();
        Bitmap i2 = C4977b.m7374i(C9720t.m17304ui(c7620bi.field_imgPath), 1.0f);
        if (this.yVF != null) {
            this.yVF.put(c7620bi.field_imgPath, new C15682a(c7620bi, i));
        }
        C30517i.m48618a(c36180k, false);
        ((View) c36180k.dGG().yXh).setVisibility(8);
        c36180k.dGG().yXi.setImageBitmap(i2);
        c36180k.dGG().yXi.setVisibility(0);
        c36180k.dGG().yXl.setVisibility(8);
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        c36180k.yXl.setTag(ut);
        cfh cfh = ut == null ? null : ut.fXm;
        String str;
        if (cfh == null) {
            c36180k.mlK.setVisibility(8);
        } else if (C42252ah.isNullOrNil(cfh.fiG)) {
            C4990ab.m7416i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            str = cfh.fiJ;
            String str2 = cfh.fiK;
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                c36180k.mlK.setVisibility(8);
            } else {
                c36180k.mlK.setText(str);
                c36180k.mlK.setVisibility(0);
                c36180k.mlK.setTag(c7620bi);
            }
        } else {
            c36180k.mlK.setVisibility(0);
            c36180k.mlK.setText(this.yTG.yTI.getString(C25738R.string.ej7, new Object[]{Integer.valueOf(cfh.wid)}));
            str = this.yTG.yTI.getString(C25738R.string.ej7);
            if (cfh.wid / 60 > 0) {
                str = str + this.yTG.yTI.getString(C25738R.string.ej9, new Object[]{Integer.valueOf(cfh.wid / 60)});
            }
            if (cfh.wid % 60 > 0) {
                str = str + this.yTG.yTI.getString(C25738R.string.ej_, new Object[]{Integer.valueOf(cfh.wid % 60)});
            }
            c36180k.mlK.setText(str + this.yTG.yTI.getString(C25738R.string.ej8));
            c36180k.mlK.setTag(c7620bi);
        }
        if (c36180k.dGG().yXh instanceof VideoSightView) {
            C4783p.m7142a(c36180k.mlK, (VideoSightView) c36180k.dGG().yXh);
        }
        AppMethodBeat.m2505o(32178);
        return true;
    }

    /* renamed from: Du */
    public final void mo48940Du() {
        AppMethodBeat.m2504i(32179);
        SparseArray sparseArray = this.yTG.yyL;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                C36180k c36180k = (C36180k) ((View) sparseArray.get(keyAt)).getTag();
                if (c36180k.yXg != null && c36180k.dGG().yXg.getVisibility() == 0) {
                    c36180k.dGG().yXh.setVideoCallback(null);
                    if (((View) c36180k.dGG().yXh).getVisibility() == 0 && c36180k != null) {
                        C30517i.m48618a(c36180k, false);
                        if (c36180k.dGG().yXh != null) {
                            c36180k.dGG().yXh.stop();
                        }
                        C4990ab.m7410d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.iaf.mo67733cy(false);
                        this.yTG.yTI.mController.ylL.getWindow().clearFlags(128);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(32179);
    }

    /* renamed from: OZ */
    public final void mo48941OZ(int i) {
        AppMethodBeat.m2504i(32180);
        C7620bi Ou = this.yTG.mo64312Ou(i);
        C36180k OJ = mo39605OJ(i);
        if (Ou == null || OJ == null) {
            AppMethodBeat.m2505o(32180);
            return;
        }
        C26493s ut = C26494u.m42268ut(Ou.field_imgPath);
        if (ut != null) {
            if (Ou.field_isSend == 0) {
                if (ut.status == 113 || ut.status == 111 || ut.status == 112) {
                    m48617a(ut, OJ);
                    AppMethodBeat.m2505o(32180);
                    return;
                } else if (ut.status == C27011o.CTRL_INDEX) {
                    m48617a(ut, OJ);
                    AppMethodBeat.m2505o(32180);
                    return;
                }
            }
            m48620b(Ou, OJ);
        }
        AppMethodBeat.m2505o(32180);
    }

    /* renamed from: a */
    private void m48617a(C26493s c26493s, C36180k c36180k) {
        AppMethodBeat.m2504i(32181);
        if (c26493s == null) {
            AppMethodBeat.m2505o(32181);
            return;
        }
        C26494u.m42266ur(c26493s.getFileName());
        c36180k.dGG().yXk.setVisibility(0);
        c36180k.dGG().yXk.setProgress(C26494u.m42255g(c26493s));
        C37961o.all().mo21053a(this, Looper.getMainLooper());
        AppMethodBeat.m2505o(32181);
    }

    /* renamed from: b */
    private void m48620b(C7620bi c7620bi, final C36180k c36180k) {
        AppMethodBeat.m2504i(32182);
        if (this.yVG) {
            AppMethodBeat.m2505o(32182);
            return;
        }
        c36180k.dGG().yXl.setVisibility(8);
        C37961o.all();
        String uh = C9720t.m17303uh(c7620bi.field_imgPath);
        if (c7620bi.dtH()) {
            Toast.makeText(this.yTG.yTI, C25738R.string.f18, 0).show();
            AppMethodBeat.m2505o(32182);
        } else if (uh == null || !C5730e.m8628ct(uh)) {
            Toast.makeText(this.yTG.yTI, C25738R.string.f18, 0).show();
            AppMethodBeat.m2505o(32182);
        } else {
            this.yTG.yTI.mController.ylL.getWindow().addFlags(128);
            Boolean bool = (Boolean) c36180k.yXf.get(uh);
            if (bool == null || !bool.booleanValue()) {
                ((View) c36180k.dGG().yXh).setTag(uh);
                c36180k.dGG().yXj.setVisibility(8);
                c36180k.dGG().yXh.stop();
                if (this.yTG.yTI.mo64296np(c7620bi.field_msgId) == 3) {
                    c36180k.dGG().yXh.setMute(true);
                } else {
                    c36180k.dGG().yXh.setMute(false);
                }
                c36180k.dGG().yXh.setVideoPath(uh);
                if (c36180k.dGG().yXh.mo27377w(this.yTG.yTI.mController.ylL, false)) {
                    ((View) c36180k.dGG().yXh).setVisibility(0);
                    c36180k.dGG().yXi.setVisibility(8);
                } else {
                    c36180k.dGG().yXj.setVisibility(0);
                    c36180k.dGG().yXj.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(32176);
                            c36180k.dGG().yXh.mo27377w(C30517i.this.yTG.yTI.mController.ylL, true);
                            AppMethodBeat.m2505o(32176);
                        }
                    });
                    ((View) c36180k.dGG().yXh).setVisibility(8);
                    c36180k.dGG().yXi.setVisibility(0);
                }
                C4990ab.m7410d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                this.iaf.mo67732a(this);
            }
            ((View) c36180k.dGG().yXh).setVisibility(0);
            AppMethodBeat.m2505o(32182);
        }
    }

    /* renamed from: a */
    private static void m48618a(C36180k c36180k, boolean z) {
        AppMethodBeat.m2504i(32183);
        if (c36180k == null) {
            AppMethodBeat.m2505o(32183);
            return;
        }
        c36180k.dGG().yXk.setVisibility(8);
        if (z) {
            c36180k.dGG().yXi.setVisibility(8);
            ((View) c36180k.dGG().yXh).setVisibility(0);
            AppMethodBeat.m2505o(32183);
            return;
        }
        c36180k.dGG().yXi.setVisibility(0);
        ((View) c36180k.dGG().yXh).setVisibility(8);
        AppMethodBeat.m2505o(32183);
    }

    /* renamed from: BI */
    public final boolean mo4499BI() {
        AppMethodBeat.m2504i(32184);
        if (this.yTG == null) {
            AppMethodBeat.m2505o(32184);
        } else {
            C36180k dFP = this.yTG.dFP();
            if (dFP == null) {
                AppMethodBeat.m2505o(32184);
            } else if (dFP.yXg == null) {
                AppMethodBeat.m2505o(32184);
            } else if (dFP.dGG().yXg.getVisibility() != 0) {
                AppMethodBeat.m2505o(32184);
            } else {
                C30517i.m48618a(dFP, true);
                AppMethodBeat.m2505o(32184);
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m48619a(C15682a c15682a) {
        AppMethodBeat.m2504i(32185);
        if (c15682a == null) {
            AppMethodBeat.m2505o(32185);
            return false;
        }
        C37961o.all().mo21052a(this);
        if (this.yTG.yTI.getCurrentItem() == c15682a.pos) {
            C36180k OJ = mo39605OJ(c15682a.pos);
            if (OJ != null) {
                OJ.dGG().yXk.setVisibility(8);
            }
            AppMethodBeat.m2505o(32185);
            return true;
        }
        this.yTG.mo64309OR(c15682a.pos);
        AppMethodBeat.m2505o(32185);
        return false;
    }

    public final void detach() {
        AppMethodBeat.m2504i(32186);
        mo48940Du();
        this.yTG.yTI.mController.ylL.getWindow().clearFlags(128);
        this.yVG = true;
        super.detach();
        this.yVF.clear();
        this.yVF = null;
        C37961o.all().mo21052a(this);
        C4990ab.m7410d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.iaf.mo67733cy(true);
        AppMethodBeat.m2505o(32186);
    }

    /* renamed from: a */
    public final void mo11381a(C9718a c9718a) {
        AppMethodBeat.m2504i(32187);
        String str = c9718a.fileName;
        if (C42252ah.isNullOrNil(str) || this.yVF == null) {
            AppMethodBeat.m2505o(32187);
            return;
        }
        C15682a c15682a = (C15682a) this.yVF.get(str);
        if (c15682a == null) {
            AppMethodBeat.m2505o(32187);
            return;
        }
        C7620bi c7620bi = c15682a.csG;
        if (c7620bi == null || c7620bi.field_imgPath == null || !c7620bi.field_imgPath.equals(str)) {
            AppMethodBeat.m2505o(32187);
            return;
        }
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        if (ut == null) {
            AppMethodBeat.m2505o(32187);
        } else if (c7620bi.dtH() || ut.status == C27011o.CTRL_INDEX) {
            if (m48619a(c15682a)) {
                Toast.makeText(this.yTG.yTI, C25738R.string.f18, 0).show();
            }
            AppMethodBeat.m2505o(32187);
        } else {
            int g = C26494u.m42255g(ut);
            C36180k OJ = mo39605OJ(c15682a.pos);
            if (this.yTG.yTI.getCurrentItem() == c15682a.pos && OJ != null) {
                OJ.dGG().yXk.setVisibility(0);
                OJ.dGG().yXk.setProgress(g);
            } else if (OJ == null) {
                AppMethodBeat.m2505o(32187);
                return;
            }
            if (g < OJ.dGH().yXk.getMax()) {
                AppMethodBeat.m2505o(32187);
                return;
            }
            if (m48619a(c15682a)) {
                m48620b(c7620bi, OJ);
            }
            AppMethodBeat.m2505o(32187);
        }
    }
}
