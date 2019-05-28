package com.tencent.p177mm.plugin.record.p493ui.p494b;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3710b;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3711c;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3713b;
import com.tencent.p177mm.plugin.record.p493ui.RecordMsgImageUI;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C44758a;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.record.ui.b.a */
public final class C41299a implements C3713b {
    C46696j hPs;
    private ListView mListView;
    Map<String, C18346nr> mim = new HashMap();
    private C4884c mip = new C348024();
    private OnClickListener mjE = new C288381();
    OnLongClickListener mlV = new C130162();
    int pKT;
    C3709a pKt;

    /* renamed from: com.tencent.mm.plugin.record.ui.b.a$2 */
    class C130162 implements OnLongClickListener {
        private Context context;
        private C27966g mgf;
        private C43438b pKV;
        private aar pKW;
        private String path;

        /* renamed from: com.tencent.mm.plugin.record.ui.b.a$2$1 */
        class C37051 implements C36073c {
            C37051() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(24337);
                if (C130162.this.pKW.whh == 0) {
                    if (C130162.this.mgf.but()) {
                        c44273l.mo70068e(2, C130162.this.context.getString(C25738R.string.bri));
                    }
                    if (C130162.this.mgf.buu()) {
                        c44273l.mo70068e(1, C130162.this.context.getString(C25738R.string.bq_));
                    }
                    c44273l.mo70068e(3, C130162.this.context.getString(C25738R.string.brb));
                    C18346nr c18346nr = (C18346nr) C41299a.this.mim.get(C130162.this.path);
                    if (c18346nr == null) {
                        C45347np c45347np = new C45347np();
                        c45347np.cJU.filePath = C130162.this.path;
                        C4879a.xxA.mo10055m(c45347np);
                    } else if (!C5046bo.isNullOrNil(c18346nr.cJX.result)) {
                        if (C13119a.m21149BR(c18346nr.cJX.cvn)) {
                            c44273l.mo70068e(4, C130162.this.context.getString(C25738R.string.diy));
                            AppMethodBeat.m2505o(24337);
                            return;
                        } else if (C13119a.m21150ba(c18346nr.cJX.cvn, c18346nr.cJX.result)) {
                            c44273l.mo70068e(4, C130162.this.context.getString(C25738R.string.diz));
                            AppMethodBeat.m2505o(24337);
                            return;
                        } else if (C13119a.m21148BQ(c18346nr.cJX.cvn)) {
                            c44273l.mo70068e(4, C130162.this.context.getString(C25738R.string.dix));
                            AppMethodBeat.m2505o(24337);
                            return;
                        } else {
                            c44273l.mo70068e(4, C130162.this.context.getString(C25738R.string.diy));
                            AppMethodBeat.m2505o(24337);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(24337);
            }
        }

        /* renamed from: com.tencent.mm.plugin.record.ui.b.a$2$2 */
        class C70392 implements C5279d {
            C70392() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(24338);
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 1:
                        intent = new Intent();
                        intent.putExtra("Ksnsupload_type", 0);
                        intent.putExtra("sns_kemdia_path", C130162.this.path);
                        String nW = C37922v.m64078nW("fav_");
                        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "fav_");
                        intent.putExtra("reportSessionId", nW);
                        C25985d.m41467b(C130162.this.context, "sns", ".ui.SnsUploadUI", intent);
                        AppMethodBeat.m2505o(24338);
                        return;
                    case 2:
                        intent = new Intent();
                        intent.putExtra("Retr_File_Name", C130162.this.path);
                        intent.putExtra("Retr_Compress_Type", 0);
                        intent.putExtra("Retr_Msg_Type", 0);
                        C25985d.m41473f(C130162.this.context, ".ui.transmit.MsgRetransmitUI", intent);
                        AppMethodBeat.m2505o(24338);
                        return;
                    case 3:
                        if (!C45477q.m83806a(C130162.this.path, C130162.this.context, C25738R.string.b3r)) {
                            Toast.makeText(C130162.this.context, C130162.this.context.getString(C25738R.string.bra), 1).show();
                            AppMethodBeat.m2505o(24338);
                            return;
                        }
                        break;
                    case 4:
                        C18346nr c18346nr = (C18346nr) C41299a.this.mim.get(C130162.this.path);
                        if (c18346nr != null) {
                            C26102cf c26102cf = new C26102cf();
                            c26102cf.cvm.activity = (Activity) C130162.this.context;
                            c26102cf.cvm.ctB = c18346nr.cJX.result;
                            c26102cf.cvm.cvn = c18346nr.cJX.cvn;
                            c26102cf.cvm.cvo = c18346nr.cJX.cvo;
                            C4879a.xxA.mo10055m(c26102cf);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(24338);
            }
        }

        C130162() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(24339);
            if (view != null) {
                this.context = view.getContext();
                this.pKV = (C43438b) view.getTag();
                this.mgf = this.pKV.mnW;
                this.pKW = this.pKV.cAv;
            }
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 2;
            c37721gh.cAH.cAJ = this.pKV.cAv;
            C4879a.xxA.mo10055m(c37721gh);
            this.path = c37721gh.cAI.path;
            if (C1173e.m2561ct(this.path)) {
                if (C41299a.this.hPs == null) {
                    C41299a.this.hPs = new C46696j(this.context);
                }
                C41299a.this.hPs.rBl = new C37051();
                C41299a.this.hPs.rBm = new C70392();
                C41299a.this.hPs.cuu();
                AppMethodBeat.m2505o(24339);
            } else {
                C4990ab.m7420w("MicroMsg.ImageViewWrapper", "file not exists");
                AppMethodBeat.m2505o(24339);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.b.a$1 */
    class C288381 implements OnClickListener {
        C288381() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24336);
            C43438b c43438b = (C43438b) view.getTag();
            Intent intent;
            switch (c43438b.dataType) {
                case 0:
                    intent = new Intent(view.getContext(), RecordMsgImageUI.class);
                    intent.putExtra("message_id", c43438b.cvx);
                    intent.putExtra("record_data_id", c43438b.cAv.mnd);
                    intent.putExtra("record_xml", c43438b.cKa);
                    if ((view.getContext() instanceof Activity) && ((Activity) view.getContext()).getIntent() != null) {
                        Bundle bundleExtra = ((Activity) view.getContext()).getIntent().getBundleExtra("_stat_obj");
                        if (bundleExtra != null) {
                            intent.putExtra("_stat_obj", bundleExtra);
                        }
                    }
                    view.getContext().startActivity(intent);
                    AppMethodBeat.m2505o(24336);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("key_detail_info_id", c43438b.mnW.field_localId);
                    intent.putExtra("key_detail_data_id", c43438b.cAv.mnd);
                    C39037b.m66352a(view.getContext(), ".ui.FavImgGalleryUI", intent, 1);
                    break;
            }
            AppMethodBeat.m2505o(24336);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.b.a$4 */
    class C348024 extends C4884c<C18346nr> {
        C348024() {
            AppMethodBeat.m2504i(24343);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(24343);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24344);
            C18346nr c18346nr = (C18346nr) c4883b;
            C41299a.this.mim.put(c18346nr.cJX.filePath, c18346nr);
            if (C41299a.this.hPs != null && C41299a.this.hPs.rBk.isShowing()) {
                C41299a.this.mlV.onLongClick(null);
            }
            AppMethodBeat.m2505o(24344);
            return true;
        }
    }

    public C41299a(C3709a c3709a, ListView listView) {
        AppMethodBeat.m2504i(24345);
        this.pKt = c3709a;
        this.mListView = listView;
        C4879a.xxA.mo10052c(this.mip);
        AppMethodBeat.m2505o(24345);
    }

    /* renamed from: eK */
    public final View mo8346eK(Context context) {
        AppMethodBeat.m2504i(24346);
        View inflate = View.inflate(context, 2130970481, null);
        this.pKT = C1338a.fromDPToPix(context, 200);
        AppMethodBeat.m2505o(24346);
        return inflate;
    }

    /* renamed from: a */
    public final void mo8344a(View view, int i, final C43438b c43438b) {
        AppMethodBeat.m2504i(24347);
        final ImageView imageView = (ImageView) view.findViewById(2131826907);
        imageView.setTag(c43438b);
        imageView.setOnClickListener(this.mjE);
        if (c43438b.dataType == 1) {
            imageView.setOnLongClickListener(this.mlV);
        }
        C3710b c3710b = new C3710b();
        if (c43438b.dataType == 0) {
            c3710b.pKv = c43438b.cvx;
        } else if (c43438b.dataType == 1) {
            c3710b.pKv = c43438b.mnW.field_localId;
        }
        c3710b.cAv = c43438b.cAv;
        c3710b.cAy = true;
        c3710b.maxWidth = this.pKT;
        Bitmap a = this.pKt.mo8340a(c3710b);
        if (a != null) {
            C4990ab.m7411d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", c3710b.cAv.mnd, a);
            mo65971a(imageView, a, C1318a.fav_list_img_default, c43438b.cAv.mnd);
            AppMethodBeat.m2505o(24347);
            return;
        }
        C7305d.xDH.mo10142ak(new Runnable() {
            public final void run() {
                int i;
                Bitmap a;
                AppMethodBeat.m2504i(24341);
                C44758a c44758a = (C44758a) c43438b;
                if (c44758a.dataType == 0) {
                    if (C43436n.m77563g(c44758a.cAv, c44758a.cvx)) {
                        i = 2131231863;
                    }
                    i = -1;
                } else {
                    if (c44758a.dataType == 1 && C5046bo.isNullOrNil(c44758a.cAv.wfZ)) {
                        i = 2131231863;
                    }
                    i = -1;
                }
                final int i2 = i == -1 ? C1318a.fav_list_img_default : i;
                c44758a = (C44758a) c43438b;
                C3709a c3709a = C41299a.this.pKt;
                int i3 = C41299a.this.pKT;
                C3710b c3710b = new C3710b();
                c3710b.cAv = c44758a.cAv;
                c3710b.cAy = false;
                c3710b.maxWidth = i3;
                C3711c c3711c = new C3711c();
                c3711c.cAv = c44758a.cAv;
                Bitmap a2;
                if (c44758a.dataType == 0) {
                    if (!C43436n.m77563g(c44758a.cAv, c44758a.cvx)) {
                        c3710b.pKv = c44758a.cvx;
                        a2 = c3709a.mo8340a(c3710b);
                        if (a2 == null) {
                            c3711c.pKv = c44758a.cvx;
                            a = c3709a.mo8341a(c3711c);
                        }
                        a = a2;
                    }
                    a = null;
                } else {
                    if (c44758a.dataType == 1) {
                        c3710b.pKv = c44758a.mnW.field_localId;
                        c3710b.cAz = false;
                        a2 = c3709a.mo8340a(c3710b);
                        if (a2 == null) {
                            c3711c.pKv = c44758a.mnW.field_localId;
                            a = c3709a.mo8341a(c3711c);
                        }
                        a = a2;
                    }
                    a = null;
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(24340);
                        C41299a.this.mo65971a(imageView, a, i2, c43438b.cAv.mnd);
                        AppMethodBeat.m2505o(24340);
                    }
                });
                AppMethodBeat.m2505o(24341);
            }

            public final String toString() {
                AppMethodBeat.m2504i(24342);
                String str = super.toString() + "|fillView";
                AppMethodBeat.m2505o(24342);
                return str;
            }
        });
        AppMethodBeat.m2505o(24347);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo65971a(ImageView imageView, Bitmap bitmap, int i, String str) {
        AppMethodBeat.m2504i(24348);
        if (!((C43438b) imageView.getTag()).cAv.mnd.equals(str)) {
            C4990ab.m7411d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", str, imageView.getTag());
            AppMethodBeat.m2505o(24348);
        } else if (bitmap == null) {
            LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = 200;
            layoutParams.width = C31128d.MIC_PTU_TRANS_XINXIAN;
            imageView.setImageResource(i);
            imageView.setBackgroundResource(C25738R.color.f12118t0);
            AppMethodBeat.m2505o(24348);
        } else {
            Bitmap createBitmap;
            C4990ab.m7411d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight()));
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
                    width = C1338a.m2857am(imageView.getContext(), C25738R.dimen.f9745eb);
                    height = (int) (((float) width) / f2);
                } else {
                    height = C1338a.m2857am(imageView.getContext(), C25738R.dimen.f9747ed);
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
                    height = C1338a.m2857am(imageView.getContext(), C25738R.dimen.f9745eb);
                    width = (int) (((float) height) / f2);
                } else {
                    width = C1338a.m2857am(imageView.getContext(), C25738R.dimen.f9747ed);
                    height = (int) (((float) width) * f2);
                }
            }
            layoutParams2.width = height;
            layoutParams2.height = width;
            imageView.setScaleType(ScaleType.FIT_XY);
            C46616n.m88171w(imageView, height, width);
            if (imageView.getLayerType() == 1) {
                this.mListView.setLayerType(1, null);
            }
            imageView.setImageBitmap(createBitmap);
            imageView.setBackgroundResource(0);
            AppMethodBeat.m2505o(24348);
        }
    }

    public final void destroy() {
        AppMethodBeat.m2504i(24349);
        C4879a.xxA.mo10053d(this.mip);
        AppMethodBeat.m2505o(24349);
    }

    public final void pause() {
    }
}
