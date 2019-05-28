package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import java.util.HashMap;
import java.util.Map;

public final class a implements b {
    j hPs;
    private ListView mListView;
    Map<String, nr> mim = new HashMap();
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(24343);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(24343);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(24344);
            nr nrVar = (nr) bVar;
            a.this.mim.put(nrVar.cJX.filePath, nrVar);
            if (a.this.hPs != null && a.this.hPs.rBk.isShowing()) {
                a.this.mlV.onLongClick(null);
            }
            AppMethodBeat.o(24344);
            return true;
        }
    };
    private OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(24336);
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            switch (bVar.dataType) {
                case 0:
                    intent = new Intent(view.getContext(), RecordMsgImageUI.class);
                    intent.putExtra("message_id", bVar.cvx);
                    intent.putExtra("record_data_id", bVar.cAv.mnd);
                    intent.putExtra("record_xml", bVar.cKa);
                    if ((view.getContext() instanceof Activity) && ((Activity) view.getContext()).getIntent() != null) {
                        Bundle bundleExtra = ((Activity) view.getContext()).getIntent().getBundleExtra("_stat_obj");
                        if (bundleExtra != null) {
                            intent.putExtra("_stat_obj", bundleExtra);
                        }
                    }
                    view.getContext().startActivity(intent);
                    AppMethodBeat.o(24336);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("key_detail_info_id", bVar.mnW.field_localId);
                    intent.putExtra("key_detail_data_id", bVar.cAv.mnd);
                    com.tencent.mm.plugin.fav.a.b.a(view.getContext(), ".ui.FavImgGalleryUI", intent, 1);
                    break;
            }
            AppMethodBeat.o(24336);
        }
    };
    OnLongClickListener mlV = new OnLongClickListener() {
        private Context context;
        private g mgf;
        private com.tencent.mm.plugin.record.ui.a.b pKV;
        private aar pKW;
        private String path;

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(24339);
            if (view != null) {
                this.context = view.getContext();
                this.pKV = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                this.mgf = this.pKV.mnW;
                this.pKW = this.pKV.cAv;
            }
            gh ghVar = new gh();
            ghVar.cAH.type = 2;
            ghVar.cAH.cAJ = this.pKV.cAv;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            this.path = ghVar.cAI.path;
            if (e.ct(this.path)) {
                if (a.this.hPs == null) {
                    a.this.hPs = new j(this.context);
                }
                a.this.hPs.rBl = new n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(24337);
                        if (AnonymousClass2.this.pKW.whh == 0) {
                            if (AnonymousClass2.this.mgf.but()) {
                                lVar.e(2, AnonymousClass2.this.context.getString(R.string.bri));
                            }
                            if (AnonymousClass2.this.mgf.buu()) {
                                lVar.e(1, AnonymousClass2.this.context.getString(R.string.bq_));
                            }
                            lVar.e(3, AnonymousClass2.this.context.getString(R.string.brb));
                            nr nrVar = (nr) a.this.mim.get(AnonymousClass2.this.path);
                            if (nrVar == null) {
                                np npVar = new np();
                                npVar.cJU.filePath = AnonymousClass2.this.path;
                                com.tencent.mm.sdk.b.a.xxA.m(npVar);
                            } else if (!bo.isNullOrNil(nrVar.cJX.result)) {
                                if (com.tencent.mm.plugin.scanner.a.BR(nrVar.cJX.cvn)) {
                                    lVar.e(4, AnonymousClass2.this.context.getString(R.string.diy));
                                    AppMethodBeat.o(24337);
                                    return;
                                } else if (com.tencent.mm.plugin.scanner.a.ba(nrVar.cJX.cvn, nrVar.cJX.result)) {
                                    lVar.e(4, AnonymousClass2.this.context.getString(R.string.diz));
                                    AppMethodBeat.o(24337);
                                    return;
                                } else if (com.tencent.mm.plugin.scanner.a.BQ(nrVar.cJX.cvn)) {
                                    lVar.e(4, AnonymousClass2.this.context.getString(R.string.dix));
                                    AppMethodBeat.o(24337);
                                    return;
                                } else {
                                    lVar.e(4, AnonymousClass2.this.context.getString(R.string.diy));
                                    AppMethodBeat.o(24337);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.o(24337);
                    }
                };
                a.this.hPs.rBm = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(24338);
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 1:
                                intent = new Intent();
                                intent.putExtra("Ksnsupload_type", 0);
                                intent.putExtra("sns_kemdia_path", AnonymousClass2.this.path);
                                String nW = v.nW("fav_");
                                v.Zp().y(nW, true).j("prePublishId", "fav_");
                                intent.putExtra("reportSessionId", nW);
                                com.tencent.mm.bp.d.b(AnonymousClass2.this.context, "sns", ".ui.SnsUploadUI", intent);
                                AppMethodBeat.o(24338);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Retr_File_Name", AnonymousClass2.this.path);
                                intent.putExtra("Retr_Compress_Type", 0);
                                intent.putExtra("Retr_Msg_Type", 0);
                                com.tencent.mm.bp.d.f(AnonymousClass2.this.context, ".ui.transmit.MsgRetransmitUI", intent);
                                AppMethodBeat.o(24338);
                                return;
                            case 3:
                                if (!q.a(AnonymousClass2.this.path, AnonymousClass2.this.context, R.string.b3r)) {
                                    Toast.makeText(AnonymousClass2.this.context, AnonymousClass2.this.context.getString(R.string.bra), 1).show();
                                    AppMethodBeat.o(24338);
                                    return;
                                }
                                break;
                            case 4:
                                nr nrVar = (nr) a.this.mim.get(AnonymousClass2.this.path);
                                if (nrVar != null) {
                                    cf cfVar = new cf();
                                    cfVar.cvm.activity = (Activity) AnonymousClass2.this.context;
                                    cfVar.cvm.ctB = nrVar.cJX.result;
                                    cfVar.cvm.cvn = nrVar.cJX.cvn;
                                    cfVar.cvm.cvo = nrVar.cJX.cvo;
                                    com.tencent.mm.sdk.b.a.xxA.m(cfVar);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(24338);
                    }
                };
                a.this.hPs.cuu();
                AppMethodBeat.o(24339);
            } else {
                ab.w("MicroMsg.ImageViewWrapper", "file not exists");
                AppMethodBeat.o(24339);
            }
            return true;
        }
    };
    int pKT;
    com.tencent.mm.plugin.record.ui.h.a pKt;

    public a(com.tencent.mm.plugin.record.ui.h.a aVar, ListView listView) {
        AppMethodBeat.i(24345);
        this.pKt = aVar;
        this.mListView = listView;
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
        AppMethodBeat.o(24345);
    }

    public final View eK(Context context) {
        AppMethodBeat.i(24346);
        View inflate = View.inflate(context, R.layout.ann, null);
        this.pKT = com.tencent.mm.bz.a.fromDPToPix(context, 200);
        AppMethodBeat.o(24346);
        return inflate;
    }

    public final void a(View view, int i, final com.tencent.mm.plugin.record.ui.a.b bVar) {
        AppMethodBeat.i(24347);
        final ImageView imageView = (ImageView) view.findViewById(R.id.dx0);
        imageView.setTag(bVar);
        imageView.setOnClickListener(this.mjE);
        if (bVar.dataType == 1) {
            imageView.setOnLongClickListener(this.mlV);
        }
        com.tencent.mm.plugin.record.ui.h.a.b bVar2 = new com.tencent.mm.plugin.record.ui.h.a.b();
        if (bVar.dataType == 0) {
            bVar2.pKv = bVar.cvx;
        } else if (bVar.dataType == 1) {
            bVar2.pKv = bVar.mnW.field_localId;
        }
        bVar2.cAv = bVar.cAv;
        bVar2.cAy = true;
        bVar2.maxWidth = this.pKT;
        Bitmap a = this.pKt.a(bVar2);
        if (a != null) {
            ab.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", bVar2.cAv.mnd, a);
            a(imageView, a, R.raw.fav_list_img_default, bVar.cAv.mnd);
            AppMethodBeat.o(24347);
            return;
        }
        com.tencent.mm.sdk.g.d.xDH.ak(new Runnable() {
            public final void run() {
                int i;
                Bitmap a;
                AppMethodBeat.i(24341);
                com.tencent.mm.plugin.record.ui.a.a aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                if (aVar.dataType == 0) {
                    if (com.tencent.mm.plugin.record.b.n.g(aVar.cAv, aVar.cvx)) {
                        i = R.raw.record_errpicture_icon;
                    }
                    i = -1;
                } else {
                    if (aVar.dataType == 1 && bo.isNullOrNil(aVar.cAv.wfZ)) {
                        i = R.raw.record_errpicture_icon;
                    }
                    i = -1;
                }
                final int i2 = i == -1 ? R.raw.fav_list_img_default : i;
                aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                com.tencent.mm.plugin.record.ui.h.a aVar2 = a.this.pKt;
                int i3 = a.this.pKT;
                com.tencent.mm.plugin.record.ui.h.a.b bVar = new com.tencent.mm.plugin.record.ui.h.a.b();
                bVar.cAv = aVar.cAv;
                bVar.cAy = false;
                bVar.maxWidth = i3;
                com.tencent.mm.plugin.record.ui.h.a.c cVar = new com.tencent.mm.plugin.record.ui.h.a.c();
                cVar.cAv = aVar.cAv;
                Bitmap a2;
                if (aVar.dataType == 0) {
                    if (!com.tencent.mm.plugin.record.b.n.g(aVar.cAv, aVar.cvx)) {
                        bVar.pKv = aVar.cvx;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.pKv = aVar.cvx;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                } else {
                    if (aVar.dataType == 1) {
                        bVar.pKv = aVar.mnW.field_localId;
                        bVar.cAz = false;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.pKv = aVar.mnW.field_localId;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(24340);
                        a.this.a(imageView, a, i2, bVar.cAv.mnd);
                        AppMethodBeat.o(24340);
                    }
                });
                AppMethodBeat.o(24341);
            }

            public final String toString() {
                AppMethodBeat.i(24342);
                String str = super.toString() + "|fillView";
                AppMethodBeat.o(24342);
                return str;
            }
        });
        AppMethodBeat.o(24347);
    }

    /* Access modifiers changed, original: final */
    public final void a(ImageView imageView, Bitmap bitmap, int i, String str) {
        AppMethodBeat.i(24348);
        if (!((com.tencent.mm.plugin.record.ui.a.b) imageView.getTag()).cAv.mnd.equals(str)) {
            ab.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", str, imageView.getTag());
            AppMethodBeat.o(24348);
        } else if (bitmap == null) {
            LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = 200;
            layoutParams.width = com.tencent.view.d.MIC_PTU_TRANS_XINXIAN;
            imageView.setImageResource(i);
            imageView.setBackgroundResource(R.color.t0);
            AppMethodBeat.o(24348);
        } else {
            Bitmap createBitmap;
            ab.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight()));
            LayoutParams layoutParams2 = imageView.getLayoutParams();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f;
            float f2;
            if (height >= width) {
                f = ((float) height) / ((float) width);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    width = com.tencent.mm.bz.a.am(imageView.getContext(), R.dimen.eb);
                    height = (int) (((float) width) / f2);
                } else {
                    height = com.tencent.mm.bz.a.am(imageView.getContext(), R.dimen.ed);
                    width = (int) (((float) height) * f2);
                }
            } else {
                f = ((float) width) / ((float) height);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.5f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.5f), bitmap.getHeight());
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    height = com.tencent.mm.bz.a.am(imageView.getContext(), R.dimen.eb);
                    width = (int) (((float) height) / f2);
                } else {
                    width = com.tencent.mm.bz.a.am(imageView.getContext(), R.dimen.ed);
                    height = (int) (((float) width) * f2);
                }
            }
            layoutParams2.width = height;
            layoutParams2.height = width;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.sdk.platformtools.n.w(imageView, height, width);
            if (imageView.getLayerType() == 1) {
                this.mListView.setLayerType(1, null);
            }
            imageView.setImageBitmap(createBitmap);
            imageView.setBackgroundResource(0);
            AppMethodBeat.o(24348);
        }
    }

    public final void destroy() {
        AppMethodBeat.i(24349);
        com.tencent.mm.sdk.b.a.xxA.d(this.mip);
        AppMethodBeat.o(24349);
    }

    public final void pause() {
    }
}
