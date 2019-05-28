package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

public final class i extends a implements a, t.a, ap.a {
    private d iaf;
    private HashMap<String, j.a> yVF;
    private boolean yVG;

    public i(c cVar) {
        super(cVar);
        AppMethodBeat.i(32177);
        this.yVG = false;
        this.yVG = false;
        this.yVF = new HashMap();
        o.all().a(this, Looper.getMainLooper());
        this.iaf = new d();
        AppMethodBeat.o(32177);
    }

    public final boolean a(k kVar, bi biVar, int i) {
        AppMethodBeat.i(32178);
        super.a(kVar, biVar, i);
        o.all();
        Bitmap i2 = b.i(t.ui(biVar.field_imgPath), 1.0f);
        if (this.yVF != null) {
            this.yVF.put(biVar.field_imgPath, new j.a(biVar, i));
        }
        a(kVar, false);
        ((View) kVar.dGG().yXh).setVisibility(8);
        kVar.dGG().yXi.setImageBitmap(i2);
        kVar.dGG().yXi.setVisibility(0);
        kVar.dGG().yXl.setVisibility(8);
        s ut = u.ut(biVar.field_imgPath);
        kVar.yXl.setTag(ut);
        cfh cfh = ut == null ? null : ut.fXm;
        String str;
        if (cfh == null) {
            kVar.mlK.setVisibility(8);
        } else if (ah.isNullOrNil(cfh.fiG)) {
            ab.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            str = cfh.fiJ;
            String str2 = cfh.fiK;
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                kVar.mlK.setVisibility(8);
            } else {
                kVar.mlK.setText(str);
                kVar.mlK.setVisibility(0);
                kVar.mlK.setTag(biVar);
            }
        } else {
            kVar.mlK.setVisibility(0);
            kVar.mlK.setText(this.yTG.yTI.getString(R.string.ej7, new Object[]{Integer.valueOf(cfh.wid)}));
            str = this.yTG.yTI.getString(R.string.ej7);
            if (cfh.wid / 60 > 0) {
                str = str + this.yTG.yTI.getString(R.string.ej9, new Object[]{Integer.valueOf(cfh.wid / 60)});
            }
            if (cfh.wid % 60 > 0) {
                str = str + this.yTG.yTI.getString(R.string.ej_, new Object[]{Integer.valueOf(cfh.wid % 60)});
            }
            kVar.mlK.setText(str + this.yTG.yTI.getString(R.string.ej8));
            kVar.mlK.setTag(biVar);
        }
        if (kVar.dGG().yXh instanceof VideoSightView) {
            p.a(kVar.mlK, (VideoSightView) kVar.dGG().yXh);
        }
        AppMethodBeat.o(32178);
        return true;
    }

    public final void Du() {
        AppMethodBeat.i(32179);
        SparseArray sparseArray = this.yTG.yyL;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                k kVar = (k) ((View) sparseArray.get(keyAt)).getTag();
                if (kVar.yXg != null && kVar.dGG().yXg.getVisibility() == 0) {
                    kVar.dGG().yXh.setVideoCallback(null);
                    if (((View) kVar.dGG().yXh).getVisibility() == 0 && kVar != null) {
                        a(kVar, false);
                        if (kVar.dGG().yXh != null) {
                            kVar.dGG().yXh.stop();
                        }
                        ab.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.iaf.cy(false);
                        this.yTG.yTI.mController.ylL.getWindow().clearFlags(128);
                    }
                }
            }
        }
        AppMethodBeat.o(32179);
    }

    public final void OZ(int i) {
        AppMethodBeat.i(32180);
        bi Ou = this.yTG.Ou(i);
        k OJ = OJ(i);
        if (Ou == null || OJ == null) {
            AppMethodBeat.o(32180);
            return;
        }
        s ut = u.ut(Ou.field_imgPath);
        if (ut != null) {
            if (Ou.field_isSend == 0) {
                if (ut.status == 113 || ut.status == 111 || ut.status == 112) {
                    a(ut, OJ);
                    AppMethodBeat.o(32180);
                    return;
                } else if (ut.status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX) {
                    a(ut, OJ);
                    AppMethodBeat.o(32180);
                    return;
                }
            }
            b(Ou, OJ);
        }
        AppMethodBeat.o(32180);
    }

    private void a(s sVar, k kVar) {
        AppMethodBeat.i(32181);
        if (sVar == null) {
            AppMethodBeat.o(32181);
            return;
        }
        u.ur(sVar.getFileName());
        kVar.dGG().yXk.setVisibility(0);
        kVar.dGG().yXk.setProgress(u.g(sVar));
        o.all().a(this, Looper.getMainLooper());
        AppMethodBeat.o(32181);
    }

    private void b(bi biVar, final k kVar) {
        AppMethodBeat.i(32182);
        if (this.yVG) {
            AppMethodBeat.o(32182);
            return;
        }
        kVar.dGG().yXl.setVisibility(8);
        o.all();
        String uh = t.uh(biVar.field_imgPath);
        if (biVar.dtH()) {
            Toast.makeText(this.yTG.yTI, R.string.f18, 0).show();
            AppMethodBeat.o(32182);
        } else if (uh == null || !e.ct(uh)) {
            Toast.makeText(this.yTG.yTI, R.string.f18, 0).show();
            AppMethodBeat.o(32182);
        } else {
            this.yTG.yTI.mController.ylL.getWindow().addFlags(128);
            Boolean bool = (Boolean) kVar.yXf.get(uh);
            if (bool == null || !bool.booleanValue()) {
                ((View) kVar.dGG().yXh).setTag(uh);
                kVar.dGG().yXj.setVisibility(8);
                kVar.dGG().yXh.stop();
                if (this.yTG.yTI.np(biVar.field_msgId) == 3) {
                    kVar.dGG().yXh.setMute(true);
                } else {
                    kVar.dGG().yXh.setMute(false);
                }
                kVar.dGG().yXh.setVideoPath(uh);
                if (kVar.dGG().yXh.w(this.yTG.yTI.mController.ylL, false)) {
                    ((View) kVar.dGG().yXh).setVisibility(0);
                    kVar.dGG().yXi.setVisibility(8);
                } else {
                    kVar.dGG().yXj.setVisibility(0);
                    kVar.dGG().yXj.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(32176);
                            kVar.dGG().yXh.w(i.this.yTG.yTI.mController.ylL, true);
                            AppMethodBeat.o(32176);
                        }
                    });
                    ((View) kVar.dGG().yXh).setVisibility(8);
                    kVar.dGG().yXi.setVisibility(0);
                }
                ab.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                this.iaf.a(this);
            }
            ((View) kVar.dGG().yXh).setVisibility(0);
            AppMethodBeat.o(32182);
        }
    }

    private static void a(k kVar, boolean z) {
        AppMethodBeat.i(32183);
        if (kVar == null) {
            AppMethodBeat.o(32183);
            return;
        }
        kVar.dGG().yXk.setVisibility(8);
        if (z) {
            kVar.dGG().yXi.setVisibility(8);
            ((View) kVar.dGG().yXh).setVisibility(0);
            AppMethodBeat.o(32183);
            return;
        }
        kVar.dGG().yXi.setVisibility(0);
        ((View) kVar.dGG().yXh).setVisibility(8);
        AppMethodBeat.o(32183);
    }

    public final boolean BI() {
        AppMethodBeat.i(32184);
        if (this.yTG == null) {
            AppMethodBeat.o(32184);
        } else {
            k dFP = this.yTG.dFP();
            if (dFP == null) {
                AppMethodBeat.o(32184);
            } else if (dFP.yXg == null) {
                AppMethodBeat.o(32184);
            } else if (dFP.dGG().yXg.getVisibility() != 0) {
                AppMethodBeat.o(32184);
            } else {
                a(dFP, true);
                AppMethodBeat.o(32184);
            }
        }
        return false;
    }

    private boolean a(j.a aVar) {
        AppMethodBeat.i(32185);
        if (aVar == null) {
            AppMethodBeat.o(32185);
            return false;
        }
        o.all().a(this);
        if (this.yTG.yTI.getCurrentItem() == aVar.pos) {
            k OJ = OJ(aVar.pos);
            if (OJ != null) {
                OJ.dGG().yXk.setVisibility(8);
            }
            AppMethodBeat.o(32185);
            return true;
        }
        this.yTG.OR(aVar.pos);
        AppMethodBeat.o(32185);
        return false;
    }

    public final void detach() {
        AppMethodBeat.i(32186);
        Du();
        this.yTG.yTI.mController.ylL.getWindow().clearFlags(128);
        this.yVG = true;
        super.detach();
        this.yVF.clear();
        this.yVF = null;
        o.all().a(this);
        ab.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.iaf.cy(true);
        AppMethodBeat.o(32186);
    }

    public final void a(t.a.a aVar) {
        AppMethodBeat.i(32187);
        String str = aVar.fileName;
        if (ah.isNullOrNil(str) || this.yVF == null) {
            AppMethodBeat.o(32187);
            return;
        }
        j.a aVar2 = (j.a) this.yVF.get(str);
        if (aVar2 == null) {
            AppMethodBeat.o(32187);
            return;
        }
        bi biVar = aVar2.csG;
        if (biVar == null || biVar.field_imgPath == null || !biVar.field_imgPath.equals(str)) {
            AppMethodBeat.o(32187);
            return;
        }
        s ut = u.ut(biVar.field_imgPath);
        if (ut == null) {
            AppMethodBeat.o(32187);
        } else if (biVar.dtH() || ut.status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX) {
            if (a(aVar2)) {
                Toast.makeText(this.yTG.yTI, R.string.f18, 0).show();
            }
            AppMethodBeat.o(32187);
        } else {
            int g = u.g(ut);
            k OJ = OJ(aVar2.pos);
            if (this.yTG.yTI.getCurrentItem() == aVar2.pos && OJ != null) {
                OJ.dGG().yXk.setVisibility(0);
                OJ.dGG().yXk.setProgress(g);
            } else if (OJ == null) {
                AppMethodBeat.o(32187);
                return;
            }
            if (g < OJ.dGH().yXk.getMax()) {
                AppMethodBeat.o(32187);
                return;
            }
            if (a(aVar2)) {
                b(biVar, OJ);
            }
            AppMethodBeat.o(32187);
        }
    }
}
