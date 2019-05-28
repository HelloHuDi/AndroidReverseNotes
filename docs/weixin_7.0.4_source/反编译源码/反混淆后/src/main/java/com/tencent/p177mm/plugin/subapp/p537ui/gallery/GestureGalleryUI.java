package com.tencent.p177mm.plugin.subapp.p537ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32803x;
import com.tencent.p177mm.model.C32803x.C26431b;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26097bu;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C41964am;
import com.tencent.p177mm.p230g.p231a.C42019kv;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30744c;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30748b;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.subapp.C24837b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI */
public class GestureGalleryUI extends MMActivity implements C26431b {
    private String flh = "";
    private String flp = null;
    private Bundle jWy;
    private boolean jYD = false;
    private C30759e jYE;
    private ImageView kkl;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private C7306ak mHandler = new C7306ak();
    private C4884c mip = new C293995();
    private String riC;
    private C4884c riJ = new C314516();
    private volatile String riz;
    private int rpA = 0;
    private int rpB = 0;
    private float rpz = 1.0f;
    private C31445a stS;
    MMGestureGallery stT;
    private String stU;
    private C32803x stV;
    private boolean stW = false;
    private boolean stX = false;
    private C36356d stY;
    private volatile boolean stZ;
    private int sua;
    private int sub;
    private int suc;
    private final Set<Integer> sud = new HashSet();
    private final Set<Integer> sue = new HashSet();
    private boolean suf = false;
    private C4884c<C26097bu> sug = new C139111();
    private List<String> suh = new ArrayList();
    private int sui = -1;
    private int suj = -1;
    private boolean suk = false;
    private OnItemSelectedListener sul = new C139124();
    private int type = 0;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$11 */
    class C419311 implements C24051b {

        /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$11$2 */
        class C41942 implements Runnable {
            C41942() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25389);
                GestureGalleryUI.this.finish();
                GestureGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(25389);
            }
        }

        /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$11$1 */
        class C41951 implements Runnable {
            C41951() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25388);
                View cDI = GestureGalleryUI.this.stS.cDI();
                if (cDI instanceof MultiTouchImageView) {
                    ((MultiTouchImageView) cDI).dzA();
                }
                AppMethodBeat.m2505o(25388);
            }
        }

        C419311() {
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(25390);
            GestureGalleryUI.this.suk = true;
            GestureGalleryUI.this.mHandler.postDelayed(new C41951(), 20);
            AppMethodBeat.m2505o(25390);
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(25391);
            GestureGalleryUI.this.mHandler.post(new C41942());
            GestureGalleryUI.this.suk = false;
            AppMethodBeat.m2505o(25391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$12 */
    class C1391012 implements C30748b {
        C1391012() {
        }

        /* renamed from: aa */
        public final void mo26118aa(float f, float f2) {
            float f3 = 1.0f;
            AppMethodBeat.m2504i(25392);
            float height = 1.0f - (f2 / ((float) GestureGalleryUI.this.stT.getHeight()));
            if (height <= 1.0f) {
                f3 = height;
            }
            C4990ab.m7411d("MicroMsg.GestureGalleryUI", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            GestureGalleryUI.this.rpz = f3;
            View cDI = GestureGalleryUI.this.stS.cDI();
            if (cDI != null) {
                cDI.setPivotX((float) (GestureGalleryUI.this.stT.getWidth() / 2));
                cDI.setPivotY((float) (GestureGalleryUI.this.stT.getHeight() / 2));
                cDI.setScaleX(f3);
                cDI.setScaleY(f3);
                cDI.setTranslationX(f);
                cDI.setTranslationY(f2);
                GestureGalleryUI.this.kkl.setAlpha(f3);
                AppMethodBeat.m2505o(25392);
                return;
            }
            C4990ab.m7410d("MicroMsg.GestureGalleryUI", "runDragAnimation contentView is null !!");
            AppMethodBeat.m2505o(25392);
        }

        /* renamed from: ab */
        public final void mo26119ab(float f, float f2) {
            AppMethodBeat.m2504i(25393);
            GestureGalleryUI.this.rpA = (int) f;
            GestureGalleryUI.this.rpB = (int) f2;
            AppMethodBeat.m2505o(25393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$1 */
    class C139111 extends C4884c<C26097bu> {
        C139111() {
            AppMethodBeat.m2504i(25375);
            this.xxI = C26097bu.class.getName().hashCode();
            AppMethodBeat.m2505o(25375);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25376);
            GestureGalleryUI.this.finish();
            AppMethodBeat.m2505o(25376);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$4 */
    class C139124 implements OnItemSelectedListener {
        C139124() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25378);
            GestureGalleryUI.this.sui = i;
            GestureGalleryUI.this.setMMTitle((GestureGalleryUI.this.sui + 1) + " / " + GestureGalleryUI.this.suh.size());
            C4990ab.m7410d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(i)));
            GestureGalleryUI.this.stU = GestureGalleryUI.this.stV.mo53360c((String) GestureGalleryUI.this.suh.get(i), GestureGalleryUI.this.type, i, GestureGalleryUI.this.flp);
            if (C5046bo.isNullOrNil(GestureGalleryUI.this.stU)) {
                GestureGalleryUI.this.stU = (String) GestureGalleryUI.this.suh.get(i);
            }
            GestureGalleryUI.m50858e(GestureGalleryUI.this);
            AppMethodBeat.m2505o(25378);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$2 */
    class C168952 implements C15994a {
        C168952() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$10 */
    class C2939810 implements OnPreDrawListener {
        C2939810() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(25387);
            GestureGalleryUI.this.stT.getViewTreeObserver().removeOnPreDrawListener(this);
            GestureGalleryUI.this.jYE.mo49166a(GestureGalleryUI.this.stT, null, null);
            GestureGalleryUI.m50858e(GestureGalleryUI.this);
            AppMethodBeat.m2505o(25387);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$5 */
    class C293995 extends C4884c<C18346nr> {
        C293995() {
            AppMethodBeat.m2504i(25379);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(25379);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25380);
            C18346nr c18346nr = (C18346nr) c4883b;
            if (c18346nr == null) {
                C4990ab.m7412e("MicroMsg.GestureGalleryUI", "RecogQBarOfImageFileResultEvent is null.");
            } else if (c18346nr == null || c18346nr.cJX.filePath.equals(GestureGalleryUI.this.riz)) {
                C4990ab.m7417i("MicroMsg.GestureGalleryUI", "recog result: %s", c18346nr.cJX.result);
                if (GestureGalleryUI.this.sue.isEmpty() || GestureGalleryUI.this.sue.contains(Integer.valueOf(c18346nr.cJX.cvn))) {
                    GestureGalleryUI.this.sua = c18346nr.cJX.cvn;
                    GestureGalleryUI.this.riC = c18346nr.cJX.result;
                    GestureGalleryUI.this.sub = c18346nr.cJX.cvo;
                    GestureGalleryUI.this.riz = null;
                    if (!C5046bo.isNullOrNil(GestureGalleryUI.this.riC) && GestureGalleryUI.this.stY.isShowing()) {
                        GestureGalleryUI.m50850b(GestureGalleryUI.this);
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.GestureGalleryUI", "Result codeType(%s) error.", Integer.valueOf(c18346nr.cJX.cvn));
                }
            } else {
                C4990ab.m7412e("MicroMsg.GestureGalleryUI", "not same filepath");
            }
            AppMethodBeat.m2505o(25380);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$14 */
    class C3144314 implements C5279d {
        C3144314() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(25395);
            switch (menuItem.getItemId()) {
                case 1:
                    if (C5046bo.isNullOrNil(GestureGalleryUI.this.stU)) {
                        C4990ab.m7420w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
                        AppMethodBeat.m2505o(25395);
                        return;
                    } else if (C5063r.amo(GestureGalleryUI.this.stU)) {
                        EmojiInfo Jd;
                        EmojiInfo Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(C5730e.atg(GestureGalleryUI.this.stU));
                        if (Jd2 == null) {
                            C44795d emojiMgr = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
                            C4996ah.getContext();
                            Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(emojiMgr.mo35598Jf(GestureGalleryUI.this.stU));
                        } else {
                            Jd = Jd2;
                        }
                        long asZ = Jd == null ? 0 : C5730e.asZ(Jd.dve());
                        String c = Jd == null ? GestureGalleryUI.this.stU : Jd.dve();
                        Options options = new Options();
                        options.inJustDecodeBounds = true;
                        int i2;
                        if ((C5056d.decodeFile(c, options) == null || options.outHeight <= C42164b.m74339Na()) && options.outWidth <= C42164b.m74339Na()) {
                            i2 = 0;
                        } else {
                            i2 = true;
                        }
                        if (asZ > ((long) C42164b.m74340Nb()) || i2 != 0) {
                            C30379h.m48443a(GestureGalleryUI.this.mController.ylL, GestureGalleryUI.this.getString(C25738R.string.b9x), "", GestureGalleryUI.this.getString(C25738R.string.cd_), null);
                            AppMethodBeat.m2505o(25395);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Retr_File_Name", Jd == null ? "" : Jd.mo20410Aq());
                        intent.putExtra("Retr_Msg_Type", 5);
                        intent.putExtra("Retr_MsgImgScene", 1);
                        C24837b.gkE.mo38926k(intent, GestureGalleryUI.this.mController.ylL);
                        AppMethodBeat.m2505o(25395);
                        return;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_File_Name", GestureGalleryUI.this.stU);
                        intent2.putExtra("Retr_Compress_Type", 0);
                        intent2.putExtra("Retr_Msg_Type", 0);
                        C24837b.gkE.mo38926k(intent2, GestureGalleryUI.this.mController.ylL);
                        AppMethodBeat.m2505o(25395);
                        return;
                    }
                case 2:
                    if (!(GestureGalleryUI.this.stU == null || GestureGalleryUI.this.stU.equals(""))) {
                        C9638aw.m17190ZK();
                        if (C18628c.isSDCardAvailable()) {
                            C14987n.m23321j(GestureGalleryUI.this.stU, GestureGalleryUI.this);
                            AppMethodBeat.m2505o(25395);
                            return;
                        }
                        C23639t.m36492hO(GestureGalleryUI.this);
                        AppMethodBeat.m2505o(25395);
                        return;
                    }
                case 3:
                    C45316cl c45316cl = new C45316cl();
                    C40443e.m69368a(c45316cl, 1, GestureGalleryUI.this.stU);
                    c45316cl.cvA.activity = GestureGalleryUI.this;
                    c45316cl.cvA.cvH = 32;
                    C4879a.xxA.mo10055m(c45316cl);
                    AppMethodBeat.m2505o(25395);
                    return;
                case 4:
                    C4990ab.m7416i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
                    C26102cf c26102cf = new C26102cf();
                    c26102cf.cvm.activity = GestureGalleryUI.this;
                    c26102cf.cvm.ctB = GestureGalleryUI.this.riC;
                    c26102cf.cvm.cvn = GestureGalleryUI.this.sua;
                    c26102cf.cvm.cvo = GestureGalleryUI.this.sub;
                    c26102cf.cvm.scene = GestureGalleryUI.this.suc;
                    c26102cf.cvm.cvs = GestureGalleryUI.this.getIntent().getBundleExtra("_stat_obj");
                    C4879a.xxA.mo10055m(c26102cf);
                    break;
            }
            AppMethodBeat.m2505o(25395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$7 */
    class C314447 implements OnMenuItemClickListener {
        C314447() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25383);
            GestureGalleryUI.this.bcW();
            AppMethodBeat.m2505o(25383);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$a */
    class C31445a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$a$a */
        class C31446a {
            ProgressBar rte;
            MMAnimateView suq;

            C31446a() {
            }
        }

        public final int getCount() {
            AppMethodBeat.m2504i(25396);
            C4990ab.m7410d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.this.suh.size());
            int size = GestureGalleryUI.this.suh.size();
            AppMethodBeat.m2505o(25396);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(25397);
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.m2505o(25397);
            return valueOf;
        }

        public final View cDI() {
            AppMethodBeat.m2504i(25398);
            View Fp = m50882Fp(GestureGalleryUI.this.stT.getSelectedItemPosition());
            AppMethodBeat.m2505o(25398);
            return Fp;
        }

        /* renamed from: Fp */
        private View m50882Fp(int i) {
            AppMethodBeat.m2504i(25399);
            int firstVisiblePosition = GestureGalleryUI.this.stT.getFirstVisiblePosition();
            int childCount = (GestureGalleryUI.this.stT.getChildCount() + firstVisiblePosition) - 1;
            View view;
            if (i < firstVisiblePosition || i > childCount) {
                view = GestureGalleryUI.this.stT.getAdapter().getView(i, null, GestureGalleryUI.this.stT);
                AppMethodBeat.m2505o(25399);
                return view;
            }
            view = GestureGalleryUI.this.stT.getChildAt(i - firstVisiblePosition);
            AppMethodBeat.m2505o(25399);
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C31446a c31446a;
            AppMethodBeat.m2504i(25400);
            if (view == null) {
                c31446a = new C31446a();
                view = View.inflate(GestureGalleryUI.this, 2130970459, null);
                c31446a.rte = (ProgressBar) view.findViewById(2131821219);
                c31446a.suq = (MMAnimateView) view.findViewById(2131820629);
                view.setTag(c31446a);
            } else {
                c31446a = (C31446a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            String str = (String) GestureGalleryUI.this.suh.get(i);
            if (!C5730e.m8628ct(str)) {
                str = GestureGalleryUI.this.stV.mo53360c(str, GestureGalleryUI.this.type, i, GestureGalleryUI.this.flp);
            }
            if (C5046bo.isNullOrNil(str)) {
                c31446a.rte.setVisibility(0);
                c31446a.suq.setVisibility(8);
                AppMethodBeat.m2505o(25400);
            } else {
                Bitmap bitmap;
                c31446a.rte.setVisibility(8);
                if (str == null) {
                    bitmap = null;
                } else {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(str, options);
                    if (bitmap != null) {
                        C4990ab.m7417i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", bitmap.toString());
                        bitmap.recycle();
                    }
                    bitmap = C5056d.aml(str);
                    if (bitmap == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                        Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
                        String str2 = "MicroMsg.GestureGalleryUI";
                        String str3 = "Progressive jpeg, result isNull:%b";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
                        C4990ab.m7417i(str2, str3, objArr);
                        bitmap = decodeAsBitmap;
                    }
                    if (bitmap == null) {
                        C4990ab.m7412e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                        bitmap = null;
                    }
                }
                if (GestureGalleryUI.this.stX && (bitmap == null || bitmap.isRecycled())) {
                    GestureGalleryUI.this.finish();
                    AppMethodBeat.m2505o(25400);
                } else {
                    int i2;
                    if (bitmap == null || bitmap.isRecycled() || (bitmap.getWidth() <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && bitmap.getHeight() <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0 && C5063r.amo(str)) {
                        if (i == GestureGalleryUI.this.suj) {
                            GestureGalleryUI.this.suf = false;
                        }
                        try {
                            c31446a.suq.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            c31446a.suq.setVisibility(0);
                            c31446a.suq.setImageFilePath(str);
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.GestureGalleryUI", C5046bo.m7574l(e));
                            c31446a.suq.setVisibility(0);
                            c31446a.suq.setImageBitmap(bitmap);
                        }
                        AppMethodBeat.m2505o(25400);
                    } else {
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            c31446a.suq.setVisibility(8);
                            view = new MultiTouchImageView(GestureGalleryUI.this, bitmap.getWidth(), bitmap.getHeight());
                            if (VERSION.SDK_INT == 20) {
                                view.setLayerType(1, null);
                            } else {
                                C46616n.m88171w(view, bitmap.getWidth(), bitmap.getHeight());
                            }
                            view.setEnableHorLongBmpMode(false);
                            view.setLayoutParams(new LayoutParams(-1, -1));
                            view.setImageBitmap(bitmap);
                            AppMethodBeat.m2505o(25400);
                        }
                        AppMethodBeat.m2505o(25400);
                    }
                }
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$8 */
    class C314478 implements C30745f {
        C314478() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(25384);
            GestureGalleryUI.this.bcW();
            AppMethodBeat.m2505o(25384);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$13 */
    class C3145013 implements C36073c {
        C3145013() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(25394);
            c44273l.clear();
            c44273l.mo70072hi(1, C25738R.string.dhh);
            c44273l.mo70072hi(2, C25738R.string.dwx);
            c44273l.mo70072hi(3, C25738R.string.dcq);
            if (GestureGalleryUI.m50863i(GestureGalleryUI.this)) {
                if (C13119a.m21149BR(GestureGalleryUI.this.sua)) {
                    c44273l.mo70068e(4, GestureGalleryUI.this.getString(C25738R.string.diy));
                } else if (C13119a.m21150ba(GestureGalleryUI.this.sua, GestureGalleryUI.this.riC)) {
                    c44273l.mo70068e(4, GestureGalleryUI.this.getString(C25738R.string.diz));
                } else if (C13119a.m21148BQ(GestureGalleryUI.this.sua)) {
                    c44273l.mo70068e(4, GestureGalleryUI.this.getString(C25738R.string.dix));
                } else {
                    c44273l.mo70068e(4, GestureGalleryUI.this.getString(C25738R.string.diy));
                }
            }
            if (GestureGalleryUI.this.stZ && C5046bo.isNullOrNil(GestureGalleryUI.this.riC) && C9638aw.m17182Rg().acS() != 0) {
                C45347np c45347np = new C45347np();
                c45347np.cJU.filePath = GestureGalleryUI.this.stU;
                c45347np.cJU.cJV = new HashSet(GestureGalleryUI.this.sud);
                GestureGalleryUI.this.riz = GestureGalleryUI.this.stU;
                C4879a.xxA.mo10055m(c45347np);
            }
            AppMethodBeat.m2505o(25394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$6 */
    class C314516 extends C4884c<C42019kv> {
        C314516() {
            AppMethodBeat.m2504i(25381);
            this.xxI = C42019kv.class.getName().hashCode();
            AppMethodBeat.m2505o(25381);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25382);
            C42019kv c42019kv = (C42019kv) c4883b;
            if (c42019kv != null) {
                C4990ab.m7417i("MicroMsg.GestureGalleryUI", "notify Event: %d", Integer.valueOf(c42019kv.cGM.cGK));
                if (c42019kv.cGM.activity == GestureGalleryUI.this && c42019kv.cGM.ctB.equals(GestureGalleryUI.this.riC)) {
                    switch (c42019kv.cGM.cGK) {
                        case 3:
                            GestureGalleryUI.this.finish();
                            break;
                    }
                }
                C4990ab.m7412e("MicroMsg.GestureGalleryUI", "not the same");
            } else {
                C4990ab.m7412e("MicroMsg.GestureGalleryUI", "NotifyDealQBarStrResultEvent is null.");
            }
            AppMethodBeat.m2505o(25382);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GestureGalleryUI() {
        AppMethodBeat.m2504i(25401);
        AppMethodBeat.m2505o(25401);
    }

    /* renamed from: d */
    public final void mo44194d(String str, String str2, int i) {
        AppMethodBeat.m2504i(25402);
        if (this.stS != null) {
            if (i == this.stT.getSelectedItemPosition()) {
                this.stU = str2;
                C4990ab.m7411d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", this.stU, str);
            }
            this.stS.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(25402);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25403);
        super.onCreate(bundle);
        this.jWy = bundle;
        this.sug.dnU();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            getWindow().addFlags(67108864);
        }
        fullScreenNoTitleBar(true);
        this.stW = getIntent().getBooleanExtra("isFromWebView", false);
        this.stX = getIntent().getBooleanExtra("isOuntLink", false);
        this.flh = getIntent().getStringExtra("IsFromWebViewReffer");
        this.stZ = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
        this.suf = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
        this.suc = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
        int[] intArrayExtra = getIntent().getIntArrayExtra("scanCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf : intArrayExtra) {
                this.sud.add(Integer.valueOf(valueOf));
            }
        }
        intArrayExtra = getIntent().getIntArrayExtra("scanResultCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf2 : intArrayExtra) {
                this.sue.add(Integer.valueOf(valueOf2));
            }
        }
        this.flp = getIntent().getStringExtra("cookie");
        C4990ab.m7411d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s", Boolean.valueOf(this.stW), this.flh, this.flp);
        this.stV = new C32803x(this.stW, this.flh);
        C32803x c32803x = this.stV;
        C4990ab.m7410d("MicroMsg.GetPicService", "addListener :" + hashCode());
        c32803x.flj = this;
        C4879a.xxA.mo10052c(this.mip);
        C4879a.xxA.mo10052c(this.riJ);
        initView();
        this.suk = false;
        AppMethodBeat.m2505o(25403);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25404);
        super.onDestroy();
        C32803x c32803x = this.stV;
        C4990ab.m7410d("MicroMsg.GetPicService", "removeListener :" + hashCode());
        c32803x.flj = null;
        c32803x = this.stV;
        if (c32803x.flf != null) {
            c32803x.flf.fln = true;
        }
        c32803x.flf = null;
        C4879a.xxA.mo10053d(this.mip);
        C4879a.xxA.mo10053d(this.riJ);
        this.sug.dead();
        GestureGalleryUI.m50859eY(this);
        AppMethodBeat.m2505o(25404);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25405);
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(25405);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25406);
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(25406);
    }

    public void onStop() {
        AppMethodBeat.m2504i(25407);
        super.onStop();
        if (this.riC != null) {
            C41964am c41964am = new C41964am();
            c41964am.ctA.activity = this;
            c41964am.ctA.ctB = this.riC;
            C4879a.xxA.mo10055m(c41964am);
            this.riC = null;
            this.sub = 0;
            this.sua = 0;
        }
        AppMethodBeat.m2505o(25407);
    }

    public final int getLayoutId() {
        return 2130970458;
    }

    public final void initView() {
        int i;
        AppMethodBeat.m2504i(25408);
        String nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("nowUrl"));
        this.type = getIntent().getIntExtra("type", 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            String nullAsNil2 = C5046bo.nullAsNil(getIntent().getStringExtra("htmlData"));
            i = 0;
            while (i >= 0) {
                int indexOf = nullAsNil2.indexOf("weixin://viewimage/", i);
                if (indexOf < 0) {
                    break;
                }
                i = nullAsNil2.indexOf("\"", indexOf);
                if (i < 0) {
                    break;
                }
                String substring = nullAsNil2.substring(indexOf + 19, i);
                C4990ab.m7410d("MicroMsg.GestureGalleryUI", "start:" + indexOf + " end:" + i + " url:" + substring);
                this.suh.add(substring);
            }
        } else {
            this.suh = Arrays.asList(stringArrayExtra);
        }
        for (i = 0; i < this.suh.size(); i++) {
            if (nullAsNil.equals(this.suh.get(i))) {
                this.sui = i;
                break;
            }
        }
        this.suj = this.sui;
        setBackBtn(new C314447());
        this.kkl = (ImageView) findViewById(2131822079);
        this.kkl.setLayerType(2, null);
        this.stS = new C31445a();
        this.stT = (MMGestureGallery) findViewById(2131822081);
        this.stT.setVisibility(0);
        this.stT.setVerticalFadingEdgeEnabled(false);
        this.stT.setHorizontalFadingEdgeEnabled(false);
        this.stT.setAdapter(this.stS);
        this.stT.setSelection(this.sui);
        this.stT.setOnItemSelectedListener(this.sul);
        this.stT.setSingleClickOverListener(new C314478());
        i = getIntent().getIntExtra("nevNext", 1);
        this.stT.setLongClickOverListener(new C30744c() {

            /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$9$1 */
            class C314491 implements C30391c {
                C314491() {
                }

                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    AppMethodBeat.m2504i(25385);
                    switch (i) {
                        case 0:
                            GestureGalleryUI.m50846a(GestureGalleryUI.this, GestureGalleryUI.this.stU);
                            AppMethodBeat.m2505o(25385);
                            return;
                        case 1:
                            GestureGalleryUI gestureGalleryUI = GestureGalleryUI.this;
                            String c = GestureGalleryUI.this.stU;
                            if (c != null && c.length() != 0) {
                                Intent intent = new Intent();
                                intent.putExtra("Retr_File_Name", c);
                                intent.putExtra("Retr_Msg_Type", 0);
                                intent.putExtra("Retr_Compress_Type", 0);
                                C24837b.gkE.mo38926k(intent, gestureGalleryUI.mController.ylL);
                                break;
                            }
                            AppMethodBeat.m2505o(25385);
                            return;
                    }
                    AppMethodBeat.m2505o(25385);
                }
            }

            public final void bvE() {
                AppMethodBeat.m2504i(25386);
                if (1 == i) {
                    C32800b y = C37922v.m64076Zp().mo60676y("basescanui@datacenter", true);
                    y.mo53356j("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.this.stT.getXDown()));
                    y.mo53356j("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.this.stT.getYDown()));
                    GestureGalleryUI.m50850b(GestureGalleryUI.this);
                    AppMethodBeat.m2505o(25386);
                    return;
                }
                if (2 == i) {
                    C30379h.m48424a(GestureGalleryUI.this, null, GestureGalleryUI.this.mController.ylL.getResources().getStringArray(C25738R.array.f12629ag), "", false, new C314491());
                }
                AppMethodBeat.m2505o(25386);
            }
        });
        this.jYE = new C30759e(this);
        AppMethodBeat.m2505o(25408);
    }

    public void onStart() {
        AppMethodBeat.m2504i(25409);
        Bundle bundle = this.jWy;
        if (!this.jYD && this.suf) {
            this.jYD = true;
            this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
            this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
            this.kks = getIntent().getIntExtra("img_gallery_width", 0);
            this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
            this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
            if (bundle == null) {
                this.stT.getViewTreeObserver().addOnPreDrawListener(new C2939810());
            }
        }
        super.onStart();
        AppMethodBeat.m2505o(25409);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(25411);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.m2505o(25411);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(25411);
        return dispatchKeyEvent;
    }

    /* renamed from: eY */
    private static void m50859eY(Context context) {
        AppMethodBeat.m2504i(138616);
        if (VERSION.SDK_INT < 19 || VERSION.SDK_INT > 22) {
            AppMethodBeat.m2505o(138616);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(138616);
            return;
        }
        String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 3; i++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() == context) {
                        declaredField.set(inputMethodManager, null);
                    } else {
                        AppMethodBeat.m2505o(138616);
                        return;
                    }
                }
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.m2505o(138616);
    }

    public final void bcW() {
        AppMethodBeat.m2504i(25410);
        if (this.stT.getSelectedItemPosition() != this.suj || !this.suf) {
            finish();
            overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(25410);
        } else if (this.suk || this.stS == null) {
            C4990ab.m7416i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
            AppMethodBeat.m2505o(25410);
        } else {
            int i;
            C4990ab.m7416i("MicroMsg.GestureGalleryUI", "runExitAnimation");
            int width = this.stT.getWidth();
            int height = this.stT.getHeight();
            int selectedItemPosition = this.stT.getSelectedItemPosition();
            String str = (String) this.suh.get(selectedItemPosition);
            if (!C5730e.m8628ct(str)) {
                str = this.stV.mo53360c(str, this.type, selectedItemPosition, this.flp);
            }
            if (C5046bo.isNullOrNil(str)) {
                i = height;
            } else {
                Options amj = C5056d.amj(str);
                i = (int) (((float) amj.outHeight) * (((float) width) / ((float) amj.outWidth)));
                if (i > this.stT.getHeight()) {
                    if (((double) i) < ((double) this.stT.getHeight()) * 2.5d) {
                        this.kkt = (this.stT.getHeight() * this.kkt) / i;
                    }
                    i = this.stT.getHeight();
                }
            }
            this.jYE.mo49168hw(width, i);
            this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
            if (((double) this.rpz) != 1.0d) {
                this.jYE.zEZ = 1.0f / this.rpz;
                if (!(this.rpA == 0 && this.rpB == 0)) {
                    this.jYE.mo49170hy(((int) (((float) (this.stT.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.stT.getHeight() / 2) + this.rpB)) - (((float) (i / 2)) * this.rpz)));
                }
            }
            this.jYE.mo49167a(this.stT, this.kkl, new C419311(), null);
            AppMethodBeat.m2505o(25410);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m50850b(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.m2504i(25412);
        if (gestureGalleryUI.stY == null) {
            gestureGalleryUI.stY = new C36356d(gestureGalleryUI.mController.ylL, 1, false);
        }
        gestureGalleryUI.stY.rBl = new C3145013();
        gestureGalleryUI.stY.rBm = new C3144314();
        gestureGalleryUI.stY.zQf = new C168952();
        if (!gestureGalleryUI.mController.ylL.isFinishing()) {
            gestureGalleryUI.stY.cpD();
        }
        AppMethodBeat.m2505o(25412);
    }

    /* renamed from: e */
    static /* synthetic */ void m50858e(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.m2504i(25414);
        if (gestureGalleryUI.suf) {
            gestureGalleryUI.stT.setGalleryScaleListener(new C1391012());
        }
        AppMethodBeat.m2505o(25414);
    }

    /* renamed from: i */
    static /* synthetic */ boolean m50863i(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.m2504i(25415);
        if (!gestureGalleryUI.stZ || C5046bo.isNullOrNil(gestureGalleryUI.riC)) {
            AppMethodBeat.m2505o(25415);
            return false;
        }
        AppMethodBeat.m2505o(25415);
        return true;
    }
}
