package com.tencent.p177mm.plugin.gallery.p427ui;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.support.p069v7.widget.C31895y;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C25784s;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMNewPhotoEditUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMViewPager;
import com.tencent.p177mm.p612ui.base.MMViewPager.C15525e;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.gallery.model.C20905d.C20907b;
import com.tencent.p177mm.plugin.gallery.model.C20909g;
import com.tencent.p177mm.plugin.gallery.model.C20911m;
import com.tencent.p177mm.plugin.gallery.model.C20911m.C20912a;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.p177mm.plugin.gallery.p1267a.C20902a;
import com.tencent.p177mm.plugin.gallery.p427ui.C39180f.C34256b;
import com.tencent.p177mm.plugin.gallery.stub.C34241a;
import com.tencent.p177mm.plugin.gallery.stub.C34241a.C34242a;
import com.tencent.p177mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.p177mm.plugin.gif.C3276f;
import com.tencent.p177mm.plugin.p468n.C12691e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@C5271a(19)
@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI */
public class ImagePreviewUI extends MMActivity {
    private int gLP;
    private ServiceConnection ktl = new C281691();
    private boolean kvs;
    private C34241a mOG = null;
    private ArrayList<MediaItem> mOH;
    private String mOL;
    private int mPA;
    private long mPF = 0;
    private HashMap<String, Integer> mPN = new HashMap();
    private TextView mPo;
    private boolean mPu = true;
    private C44743c mQS;
    private MMViewPager mQT;
    private RecyclerView mQU;
    private ArrayList<String> mQV;
    private ArrayList<String> mQW;
    private Integer mQX;
    private ImageButton mQY;
    private TextView mQZ;
    private boolean mQm;
    private C7564ap mRa;
    private ImageButton mRb;
    private TextView mRc;
    private ViewGroup mRd;
    private ViewGroup mRe;
    private boolean mRf = true;
    private boolean mRg = true;
    private int mRh = 0;
    private int mRi = 10;
    private TextView mRj;
    private TextView mRk;
    private TextView mRl;
    private TextView mRm;
    private View mRn;
    private TextView mRo;
    private ProgressBar mRp;
    boolean mRq = false;
    private int mRr = 300000;
    private String mRs;
    private HashSet<String> mRt;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$6 */
    class C32116 implements OnClickListener {
        C32116() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21501);
            ImagePreviewUI.m66745o(ImagePreviewUI.this);
            AppMethodBeat.m2505o(21501);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$9 */
    class C32129 implements C34256b {
        C32129() {
        }

        /* renamed from: wC */
        public final void mo7522wC(int i) {
            AppMethodBeat.m2504i(21504);
            C4990ab.m7417i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", Integer.valueOf(i), Boolean.valueOf(ImagePreviewUI.this.mQm));
            ((C39180f) ImagePreviewUI.this.mQU.getAdapter()).mo62083el(i, i);
            ImagePreviewUI.this.mQT.setCurrentItem(i, false);
            if (ImagePreviewUI.this.mQm) {
                C34237e.mNQ = true;
                AppMethodBeat.m2505o(21504);
                return;
            }
            C34237e.mNS = true;
            AppMethodBeat.m2505o(21504);
        }

        /* renamed from: ek */
        public final void mo7521ek(int i, int i2) {
            AppMethodBeat.m2504i(21505);
            C4990ab.m7417i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), ImagePreviewUI.this.mQX);
            AppMethodBeat.m2505o(21505);
        }

        /* renamed from: X */
        public final void mo7520X(int i, int i2, int i3) {
            AppMethodBeat.m2504i(21506);
            C4990ab.m7417i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ImagePreviewUI.this.mQX);
            if (ImagePreviewUI.this.mQm) {
                C20902a.swap(ImagePreviewUI.this.mQW, i, i2);
                C34237e.mNP = true;
                AppMethodBeat.m2505o(21506);
                return;
            }
            C20902a.swap(ImagePreviewUI.this.mQV, i, i2);
            C44743c h = ImagePreviewUI.this.mQS;
            C4990ab.m7417i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ImagePreviewUI.this.mQX.intValue()), Integer.valueOf(i3));
            if (!h.mQm) {
                C20902a.swap(h.mQl, i, i2);
                h.mQo = i3;
                h.mQp = (View) h.yyL.get(r0);
                h.yyJ.remove(h.mQp);
                h.yyK.clear();
                h.yyL.clear();
                h.mQq = true;
                h.notifyDataSetChanged();
            }
            ImagePreviewUI.this.mQT.setCurrentItem(i3, false);
            ((C39180f) ImagePreviewUI.this.mQU.getAdapter()).mo62083el(i3, i3);
            C34237e.mNR = true;
            AppMethodBeat.m2505o(21506);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$25 */
    class C1208725 implements OnClickListener {
        C1208725() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21524);
            ImagePreviewUI.this.mQY.performClick();
            AppMethodBeat.m2505o(21524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$27 */
    class C1208827 implements OnMenuItemClickListener {
        C1208827() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            int i;
            boolean z;
            int i2 = 0;
            AppMethodBeat.m2504i(21528);
            if (ImagePreviewUI.this.mRh == 6) {
                ImagePreviewUI.this.setResult(1);
                ImagePreviewUI.this.finish();
            }
            final Intent intent = new Intent();
            intent.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
            ArrayList l = ImagePreviewUI.m66742l(ImagePreviewUI.this);
            if (l == null || l.size() != 0) {
                i = 0;
            } else {
                MediaItem wz = ImagePreviewUI.this.mQS.mo71817wz(ImagePreviewUI.this.mQX.intValue());
                if (!ImagePreviewUI.this.mPu || ImagePreviewUI.this.mQS == null || wz == null || wz.getType() != 2) {
                    ImagePreviewUI.this.mRb.performClick();
                    i = 300;
                } else {
                    ImagePreviewUI.m66716a(ImagePreviewUI.this, wz.fPT);
                    i = 0;
                }
            }
            if (ImagePreviewUI.this.kvs) {
                z = false;
            } else {
                z = true;
            }
            final boolean m = ImagePreviewUI.this.mPu;
            if (i == 0) {
                ImagePreviewUI.m66714a(ImagePreviewUI.this, intent, m, z);
                AppMethodBeat.m2505o(21528);
            } else {
                C20909g bCa = C34237e.bCa();
                C120891 c120891 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(21526);
                        ImagePreviewUI.m66714a(ImagePreviewUI.this, intent, m, z);
                        AppMethodBeat.m2505o(21526);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(21527);
                        String str = super.toString() + "|addTextOptionMenu";
                        AppMethodBeat.m2505o(21527);
                        return str;
                    }
                };
                if (i >= 0) {
                    i2 = i;
                }
                bCa.bCo().postDelayed(c120891, (long) i2);
                AppMethodBeat.m2505o(21528);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$14 */
    class C2091614 implements C15525e {
        C2091614() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(21513);
            ImagePreviewUI.m66753w(ImagePreviewUI.this);
            AppMethodBeat.m2505o(21513);
        }

        public final void bCN() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$7 */
    class C209187 extends C25373h {
        C209187() {
        }

        /* renamed from: a */
        public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(21502);
            int dimension = (int) C4996ah.getContext().getResources().getDimension(C25738R.dimen.f9948l5);
            rect.left = dimension / 2;
            rect.bottom = dimension;
            rect.top = dimension;
            rect.right = dimension / 2;
            AppMethodBeat.m2505o(21502);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$13 */
    class C2816813 implements OnPageChangeListener {
        C2816813() {
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(21511);
            C34237e.m56159wk(i);
            String item = ImagePreviewUI.this.mQS.getItem(i);
            ImagePreviewUI.m66713a(ImagePreviewUI.this, i, item);
            boolean contains = ImagePreviewUI.this.mQW.contains(item);
            ImagePreviewUI.this.mQX = Integer.valueOf(i);
            ImagePreviewUI.this.mRb.setImageResource(contains ? C1318a.checkbox_selected : C1318a.checkbox_unselected);
            if (ImagePreviewUI.this.kvs) {
                ImagePreviewUI.this.mQY.setImageResource(C1318a.radio_on);
            } else {
                ImagePreviewUI.this.mQY.setImageResource(C1318a.radio_off);
            }
            ImagePreviewUI.this.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(ImagePreviewUI.this.mQS.getCount())}));
            C43150e c43150e = ImagePreviewUI.this.mQS.mQs;
            if (c43150e.aaF == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            c43150e.mo68672wB(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            c43150e.mo68672wB(i - i2);
                        }
                    } else {
                        c43150e.mo68672wB(i);
                    }
                    i2++;
                }
            } else if (c43150e.aaF > i) {
                c43150e.mo68672wB(Math.max(i - 3, 0));
            } else if (c43150e.aaF < i) {
                c43150e.mo68672wB(i + 3);
            }
            c43150e.aaF = i;
            C4990ab.m7410d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(i)));
            MediaItem NB = C34237e.m56156NB(item);
            if (ImagePreviewUI.this.mRd.getVisibility() == 0 || ImagePreviewUI.this.mRe.getVisibility() == 0) {
                ImagePreviewUI.m66717a(ImagePreviewUI.this, item, NB);
                ImagePreviewUI.m66715a(ImagePreviewUI.this, NB);
            }
            AppMethodBeat.m2505o(21511);
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.m2504i(21512);
            if (ImagePreviewUI.this.mQS != null) {
                ImagePreviewUI.this.mQS.mQt.onPageScrollStateChanged(i);
            }
            AppMethodBeat.m2505o(21512);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$1 */
    class C281691 implements ServiceConnection {
        C281691() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(21497);
            C4990ab.m7410d("MicroMsg.ImagePreviewUI", "onServiceConnected");
            ImagePreviewUI.this.mOG = C34242a.m56168B(iBinder);
            AppMethodBeat.m2505o(21497);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(21498);
            C4990ab.m7410d("MicroMsg.ImagePreviewUI", "onServiceDisconnected");
            ImagePreviewUI.this.mOG = null;
            AppMethodBeat.m2505o(21498);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$26 */
    class C2817026 implements OnMenuItemClickListener {
        C2817026() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21525);
            ImagePreviewUI.m66740j(ImagePreviewUI.this);
            AppMethodBeat.m2505o(21525);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$15 */
    class C3424515 implements C5015a {
        C3424515() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            boolean z;
            AppMethodBeat.m2504i(21514);
            ImagePreviewUI imagePreviewUI = ImagePreviewUI.this;
            if (ImagePreviewUI.this.mRg) {
                z = false;
            } else {
                z = true;
            }
            imagePreviewUI.mRg = z;
            ImagePreviewUI.m66719a(ImagePreviewUI.this, ImagePreviewUI.this.mRg);
            AppMethodBeat.m2505o(21514);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$17 */
    class C3424717 implements C20912a {
        C3424717() {
        }

        /* renamed from: a */
        public final void mo36241a(C20911m c20911m) {
            AppMethodBeat.m2504i(21516);
            if (c20911m.position != ImagePreviewUI.this.mQX.intValue()) {
                AppMethodBeat.m2505o(21516);
                return;
            }
            ImagePreviewUI.m66718a(ImagePreviewUI.this, c20911m.path, c20911m.mOA);
            AppMethodBeat.m2505o(21516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$18 */
    class C3424818 implements C20912a {
        C3424818() {
        }

        /* renamed from: a */
        public final void mo36241a(C20911m c20911m) {
            AppMethodBeat.m2504i(21517);
            if (c20911m.position != ImagePreviewUI.this.mQX.intValue()) {
                AppMethodBeat.m2505o(21517);
                return;
            }
            if (c20911m.mOA.fPW >= ImagePreviewUI.this.mRr || (c20911m.mOA.fPW > 0 && c20911m.mOA.fPW < 1000)) {
                ImagePreviewUI.this.mRn.setVisibility(0);
                ImagePreviewUI.this.mRm.setText(c20911m.mOA.fPW >= ImagePreviewUI.this.mRr ? ImagePreviewUI.this.mRs : ImagePreviewUI.this.getString(C25738R.string.c3t));
                ImagePreviewUI.this.mRc.setEnabled(false);
                ImagePreviewUI.this.mRb.setEnabled(false);
                ImagePreviewUI.this.mRc.setTextColor(ImagePreviewUI.this.getResources().getColor(C25738R.color.a6b));
                if (ImagePreviewUI.this.mQW.size() == 0) {
                    ImagePreviewUI.this.enableOptionMenu(false);
                    AppMethodBeat.m2505o(21517);
                    return;
                }
            }
            ImagePreviewUI.this.mRc.setEnabled(true);
            ImagePreviewUI.this.mRb.setEnabled(true);
            ImagePreviewUI.this.mRc.setTextColor(ImagePreviewUI.this.getResources().getColor(C25738R.color.a6a));
            ImagePreviewUI.this.mRn.setVisibility(8);
            AppMethodBeat.m2505o(21517);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$4 */
    class C342504 implements OnClickListener {
        C342504() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$5 */
    class C342515 implements OnClickListener {
        C342515() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$8 */
    class C342528 implements Runnable {
        C342528() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21503);
            int i = ImagePreviewUI.this.getResources().getDisplayMetrics().widthPixels / 7;
            ImagePreviewUI.this.mQU.getLayoutParams().height = (((int) C4996ah.getContext().getResources().getDimension(C25738R.dimen.f9948l5)) * 2) + i;
            ImagePreviewUI.this.mQU.smoothScrollToPosition(ImagePreviewUI.this.mQX.intValue());
            AppMethodBeat.m2505o(21503);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$23 */
    class C3917323 implements OnClickListener {
        C3917323() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21522);
            String item = ImagePreviewUI.this.mQS.getItem(ImagePreviewUI.this.mQX.intValue());
            if (C5046bo.isNullOrNil(item)) {
                C4990ab.m7421w("MicroMsg.ImagePreviewUI", "get path error, position %d", ImagePreviewUI.this.mQX);
                AppMethodBeat.m2505o(21522);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_video_path", item);
            intent.putExtra("key_need_clip_video_first", false);
            if (C34237e.bBZ().hOZ == 14) {
                intent.putExtra("key_need_remux_video", false);
            }
            intent.putExtra("key_max_duration_seconds", ImagePreviewUI.this.mRi);
            C25985d.m41468b(ImagePreviewUI.this.mController.ylL, "mmsight", ".segment.MMSightEditUI", intent, 4370);
            AppMethodBeat.m2505o(21522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$2 */
    class C391742 implements OnClickListener {
        C391742() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21499);
            String item = ImagePreviewUI.this.mQS.getItem(ImagePreviewUI.this.mQX.intValue());
            if (C5046bo.isNullOrNil(item)) {
                C4990ab.m7421w("MicroMsg.ImagePreviewUI", "get path error, position %d", ImagePreviewUI.this.mQX);
                AppMethodBeat.m2505o(21499);
                return;
            }
            ImagePreviewUI.m66716a(ImagePreviewUI.this, item);
            ImagePreviewUI.m66712a(ImagePreviewUI.this, ImagePreviewUI.this.mQX.intValue());
            ImagePreviewUI.this.mPo.setText(ImagePreviewUI.this.mController.ylL.getString(C25738R.string.c3i) + "");
            ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.m66744n(ImagePreviewUI.this));
            AppMethodBeat.m2505o(21499);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$3 */
    class C391753 implements OnClickListener {
        C391753() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21500);
            ImagePreviewUI.this.mRb.performClick();
            AppMethodBeat.m2505o(21500);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$21 */
    class C3917621 implements Runnable {
        C3917621() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21520);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) ImagePreviewUI.this.mRn.getLayoutParams();
            marginLayoutParams.topMargin = (int) (((float) C40619x.m70065al(ImagePreviewUI.this)) + ImagePreviewUI.this.getResources().getDimension(C25738R.dimen.f9778fd));
            ImagePreviewUI.this.mRn.setLayoutParams(marginLayoutParams);
            AppMethodBeat.m2505o(21520);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$22 */
    class C3917722 implements OnClickListener {
        C3917722() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21521);
            ImagePreviewUI.this.kvs = !ImagePreviewUI.this.kvs;
            if (ImagePreviewUI.this.kvs) {
                ImagePreviewUI.this.mQY.setImageResource(C1318a.radio_on);
                if (ImagePreviewUI.this.mQW.size() == 0) {
                    ImagePreviewUI.this.mRb.performClick();
                }
            } else {
                ImagePreviewUI.this.mQY.setImageResource(C1318a.radio_off);
            }
            ImagePreviewUI.this.mPo.setText(ImagePreviewUI.this.mController.ylL.getString(C25738R.string.c3i) + "");
            ImagePreviewUI.m66712a(ImagePreviewUI.this, ImagePreviewUI.this.mQX.intValue());
            AppMethodBeat.m2505o(21521);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$24 */
    class C3917824 implements OnClickListener {
        C3917824() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21523);
            String item = ImagePreviewUI.this.mQS.getItem(ImagePreviewUI.this.mQX.intValue());
            if (C5046bo.isNullOrNil(item)) {
                C4990ab.m7421w("MicroMsg.ImagePreviewUI", "get path error, position %d", ImagePreviewUI.this.mQX);
                AppMethodBeat.m2505o(21523);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_video_path", item);
            intent.putExtra("key_need_clip_video_first", true);
            if (C34237e.bBZ().hOZ == 14) {
                intent.putExtra("key_need_remux_video", false);
            }
            intent.putExtra("key_max_duration_seconds", ImagePreviewUI.this.mRi);
            C25985d.m41468b(ImagePreviewUI.this.mController.ylL, "mmsight", ".segment.MMSightEditUI", intent, 4370);
            AppMethodBeat.m2505o(21523);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ImagePreviewUI() {
        AppMethodBeat.m2504i(21529);
        AppMethodBeat.m2505o(21529);
    }

    /* renamed from: j */
    static /* synthetic */ void m66740j(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.m2504i(21559);
        imagePreviewUI.goBack();
        AppMethodBeat.m2505o(21559);
    }

    /* renamed from: l */
    static /* synthetic */ ArrayList m66742l(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.m2504i(21560);
        ArrayList bCK = imagePreviewUI.bCK();
        AppMethodBeat.m2505o(21560);
        return bCK;
    }

    /* renamed from: n */
    static /* synthetic */ String m66744n(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.m2504i(21563);
        String bCJ = imagePreviewUI.bCJ();
        AppMethodBeat.m2505o(21563);
        return bCJ;
    }

    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21530);
        final long yz = C5046bo.m7588yz();
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        new C7306ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(21510);
                ImagePreviewUI.m66719a(ImagePreviewUI.this, true);
                C34237e.bCa().mo36237wp(-8);
                C4990ab.m7419v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", Long.valueOf(C5046bo.m7525az(yz)));
                AppMethodBeat.m2505o(21510);
            }
        });
        bindService(new Intent(this.mController.ylL, GalleryStubService.class), this.ktl, 1);
        initView();
        C4990ab.m7419v("MicroMsg.ImagePreviewUI", "test oncreate: %d", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(21530);
    }

    public void onResume() {
        AppMethodBeat.m2504i(21531);
        super.onResume();
        AppMethodBeat.m2505o(21531);
    }

    public void onPause() {
        AppMethodBeat.m2504i(21532);
        if (this.mRa != null) {
            this.mRa.stopTimer();
        }
        super.onPause();
        AppMethodBeat.m2505o(21532);
    }

    public final int getLayoutId() {
        return 2130969856;
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(21533);
        if (C37657b.m63682bD(this)) {
            setContentView(view);
            AppMethodBeat.m2505o(21533);
            return;
        }
        C5222ae.m7946h(C5222ae.m7934a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.m2505o(21533);
    }

    /* JADX WARNING: Missing block: B:14:0x00f2, code skipped:
            if (r11.mQX.intValue() < 0) goto L_0x00f4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        AppMethodBeat.m2504i(21534);
        this.mRk = (TextView) findViewById(2131825002);
        this.mRl = (TextView) findViewById(2131825004);
        this.mRm = (TextView) findViewById(2131824994);
        this.mRn = findViewById(2131824993);
        this.mRn.postDelayed(new C3917621(), 100);
        this.mRo = (TextView) findViewById(2131825003);
        this.mRp = (ProgressBar) findViewById(2131824997);
        this.mPA = getIntent().getIntExtra("max_select_count", 9);
        this.mRi = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
        this.mPu = C34237e.bBZ().hOZ == 4;
        Intent intent = getIntent();
        this.mQV = intent.getStringArrayListExtra("preview_image_list");
        this.mQW = new ArrayList();
        if (this.mQV != null) {
            this.mQW.addAll(this.mQV);
        }
        this.mOH = C34237e.bCb();
        boolean booleanExtra = intent.getBooleanExtra("preview_all", false);
        String str = "MicroMsg.ImagePreviewUI";
        String str2 = "preview all[%B] mediaitems is null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(booleanExtra);
        objArr[1] = Boolean.valueOf(this.mOH == null);
        C4990ab.m7417i(str, str2, objArr);
        if (booleanExtra && this.mOH != null) {
            this.mQm = true;
            this.mQX = Integer.valueOf(intent.getIntExtra("preview_position", 0));
            C4990ab.m7417i("MicroMsg.ImagePreviewUI", "start position=%d", this.mQX);
        }
        this.mQX = Integer.valueOf(0);
        C34237e.m56159wk(this.mQX.intValue());
        if (this.mQm || !(this.mQW == null || this.mQW.size() == 0)) {
            final String str3;
            String str4;
            this.mQY = (ImageButton) findViewById(2131822755);
            this.mPo = (TextView) findViewById(2131822756);
            this.mQZ = (TextView) findViewById(2131824996);
            this.kvs = intent.getBooleanExtra("send_raw_img", false);
            this.mRh = intent.getIntExtra("query_source_type", 0);
            if (this.kvs) {
                this.mQY.setImageResource(C1318a.radio_on);
            } else {
                this.mQY.setImageResource(C1318a.radio_off);
            }
            if (this.mQW != null && this.mQW.size() == 1) {
                str3 = (String) this.mQW.get(0);
                if (str3.endsWith(FileUtils.PIC_POSTFIX_JPEG)) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            boolean z = true;
                            AppMethodBeat.m2504i(21507);
                            try {
                                C34241a t = ImagePreviewUI.this.mOG;
                                String str = str3;
                                String stringExtra = ImagePreviewUI.this.getIntent().getStringExtra("GalleryUI_ToUser");
                                if (!ImagePreviewUI.this.mPu) {
                                    if (ImagePreviewUI.this.kvs) {
                                        z = false;
                                    }
                                }
                                t.mo36246a(str, stringExtra, z, 0, true);
                                AppMethodBeat.m2505o(21507);
                            } catch (Exception e) {
                                AppMethodBeat.m2505o(21507);
                            }
                        }
                    });
                }
            }
            this.mPo.setText(this.mController.ylL.getString(C25738R.string.c3i));
            this.mQY.setOnClickListener(new C3917722());
            this.mQZ.setOnClickListener(new C3917323());
            this.mRo.setOnClickListener(new C3917824());
            this.mPo.setOnClickListener(new C1208725());
            setBackBtn(new C2817026());
            this.mOL = intent.getStringExtra("album_business_tag");
            this.gLP = intent.getIntExtra("album_video_max_duration", 10);
            mo17379a(0, bCJ(), (OnMenuItemClickListener) new C1208827(), C5535b.GREEN);
            this.mRb = (ImageButton) findViewById(2131824999);
            this.mRb.setOnClickListener(new C391742());
            this.mRc = (TextView) findViewById(2131824998);
            this.mRc.setOnClickListener(new C391753());
            if (this.mPA == 1) {
                this.mRb.setVisibility(8);
                this.mRc.setVisibility(8);
            }
            this.mRd = (ViewGroup) findViewById(2131823176);
            this.mRe = (ViewGroup) findViewById(2131825001);
            if (this.mRd != null) {
                this.mRd.setVisibility(8);
                this.mRd.setOnClickListener(new C342504());
            }
            if (this.mRe != null) {
                this.mRe.setVisibility(8);
                this.mRe.setOnClickListener(new C342515());
            }
            this.mRj = (TextView) findViewById(2131824995);
            this.mRj.setOnClickListener(new C32116());
            this.mQU = (RecyclerView) findViewById(2131824992);
            this.mQU.getItemAnimator().aov = 66;
            this.mQU.mo66346b(new C209187());
            C34257g c34257g = new C34257g();
            c34257g.setOrientation(0);
            this.mQU.setLayoutManager(c34257g);
            C39180f c39180f = new C39180f(this, this.mQW, getResources().getDisplayMetrics().widthPixels / 7, this.mQm);
            this.mQU.setAdapter(c39180f);
            this.mQU.post(new C342528());
            if (this.mQW.size() > 0) {
                this.mQU.setVisibility(0);
            } else {
                this.mQU.setVisibility(8);
            }
            this.mQU.setItemAnimator(new C31895y());
            c39180f.mRL.mo18502i(this.mQU);
            c39180f.mRF = new C32129();
            this.mQT = (MMViewPager) findViewById(2131822081);
            this.mQT.setVerticalFadingEdgeEnabled(false);
            this.mQT.setHorizontalFadingEdgeEnabled(false);
            this.mQT.setOnPageChangeListener(new C2816813());
            this.mQT.setSingleClickOverListener(new C2091614());
            this.mQS = new C44743c(this);
            ((C39180f) this.mQU.getAdapter()).mRC = this.mQS;
            str3 = "";
            if (this.mQm) {
                C44743c c44743c = this.mQS;
                ArrayList arrayList = this.mOH;
                c44743c.mOH.clear();
                c44743c.mOH.addAll(arrayList);
                c44743c.reset();
                c44743c.notifyDataSetChanged();
                this.mQS.mQm = true;
                if (this.mQX.intValue() >= this.mOH.size()) {
                    this.mQX = Integer.valueOf(0);
                }
                if (this.mOH.size() > 0) {
                    str4 = ((MediaItem) this.mOH.get(this.mQX.intValue())).fPT;
                }
                str4 = str3;
            } else {
                this.mQS.mo71813E(this.mQV);
                this.mQS.mQm = false;
                if (this.mQV.size() > 0) {
                    str4 = (String) this.mQV.get(this.mQX.intValue());
                }
                str4 = str3;
            }
            this.mQT.setAdapter(this.mQS);
            this.mQT.setCurrentItem(this.mQX.intValue());
            ((C39180f) this.mQU.getAdapter()).mo62083el(bCK().indexOf(this.mQS.getItem(this.mQX.intValue())), this.mQX.intValue());
            MediaItem NB = C34237e.m56156NB(str4);
            m66720a(str4, NB);
            m66724b(NB);
            setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(this.mQX.intValue() + 1), Integer.valueOf(this.mQS.getCount())}));
            AppMethodBeat.m2505o(21534);
            return;
        }
        C4990ab.m7412e("MicroMsg.ImagePreviewUI", "not preview all items and imagepaths is null or empty");
        finish();
        AppMethodBeat.m2505o(21534);
    }

    /* renamed from: NE */
    private void m66704NE(String str) {
        AppMethodBeat.m2504i(21535);
        if (this.mQW.contains(str)) {
            this.mRb.setImageResource(C1318a.checkbox_unselected);
            do {
            } while (this.mQW.remove(str));
            m66723b(this.mQW.size(), this.mQX.intValue(), str, 1);
        } else if (this.mQW.size() >= this.mPA) {
            String quantityString = getResources().getQuantityString(C25738R.plurals.f9601m, this.mPA, new Object[]{Integer.valueOf(this.mPA)});
            if (!C5046bo.isNullOrNil(this.mOL) && this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                quantityString = getResources().getQuantityString(C25738R.plurals.f9602n, this.mPA, new Object[]{Integer.valueOf(this.mPA)});
            }
            C30379h.m48465bQ(this.mController.ylL, quantityString);
            this.mRb.setImageResource(C1318a.checkbox_unselected);
        } else {
            MediaItem NB = C34237e.m56156NB(str);
            if (NB != null) {
                if (NB.mMimeType.equalsIgnoreCase("image/gif") && !((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35609Jq(str)) {
                    C30379h.m48465bQ(this, getString(C25738R.string.c3w));
                    AppMethodBeat.m2505o(21535);
                    return;
                } else if (!C5046bo.isNullOrNil(this.mOL) && this.mOL.equals("album_business_bubble_media_by_coordinate") && (NB instanceof VideoMediaItem) && ((VideoMediaItem) NB).fPW >= (this.gLP * 1000) + 500) {
                    C30379h.m48465bQ(this.mController.ylL, this.mController.ylL.getResources().getString(C25738R.string.c4d));
                    AppMethodBeat.m2505o(21535);
                    return;
                }
            }
            this.mQW.add(str);
            this.mRb.setImageResource(C1318a.checkbox_selected);
            m66723b(this.mQW.size(), this.mQX.intValue(), str, 0);
        }
        Iterator it = this.mQW.iterator();
        while (it.hasNext()) {
            if (!C5063r.amo((String) it.next())) {
                AppMethodBeat.m2505o(21535);
                return;
            }
        }
        this.kvs = true;
        AppMethodBeat.m2505o(21535);
    }

    public void onActivityResult(int i, int i2, final Intent intent) {
        AppMethodBeat.m2504i(21536);
        C4990ab.m7416i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i == 4371) {
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.mQW.size() > 0) {
                m66704NE((String) this.mQW.get(0));
            } else {
                C4990ab.m7413e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", Integer.valueOf(this.mQW.size()));
            }
        } else if (i == 4370) {
            if (i2 == -1) {
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        }
        if (i == 4372) {
            if (i2 == -1 && intent != null) {
                this.mRq = true;
                String stringExtra = intent.getStringExtra("raw_photo_path");
                Iterator it = C34237e.bCd().iterator();
                while (it.hasNext()) {
                    if (stringExtra.equals(((Bundle) it.next()).getString("raw_photo_path"))) {
                        it.remove();
                    }
                }
                C34237e.bCd().add(intent.getBundleExtra("report_info"));
                String stringExtra2 = intent.getStringExtra("after_photo_edit");
                String stringExtra3 = intent.getStringExtra("tmp_photo_edit");
                C4990ab.m7417i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", stringExtra, stringExtra2);
                if (this.mQV != null) {
                    this.mQV.clear();
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                    if (stringArrayListExtra != null) {
                        this.mQV.addAll(stringArrayListExtra);
                    }
                    MediaItem wz = this.mQS.mo71817wz(this.mQX.intValue());
                    if (wz == null) {
                        C4990ab.m7413e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", this.mQX, stringExtra, stringExtra2);
                        AppMethodBeat.m2505o(21536);
                        return;
                    }
                    wz.mOi = stringExtra;
                    wz.fPT = stringExtra2;
                    wz.lZg = stringExtra2;
                    wz.mOj = stringExtra3;
                    wz.mMimeType = "edit";
                    C34237e.bCc().add(wz);
                    C34237e.bBY().mo68658a(new C20907b() {
                        /* renamed from: NA */
                        public final void mo23913NA(final String str) {
                            AppMethodBeat.m2504i(21509);
                            new C7306ak(ImagePreviewUI.this.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(21508);
                                    ImagePreviewUI.this.mQS.mo71813E(ImagePreviewUI.this.mQV);
                                    C39180f c39180f = (C39180f) ImagePreviewUI.this.mQU.getAdapter();
                                    ArrayList s = ImagePreviewUI.this.mQV;
                                    c39180f.mRE.clear();
                                    c39180f.mRE.addAll(s);
                                    c39180f.aop.notifyChanged();
                                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_select_image_list");
                                    ImagePreviewUI.this.mQW.clear();
                                    if (stringArrayListExtra != null) {
                                        ImagePreviewUI.this.mQW.addAll(stringArrayListExtra);
                                    }
                                    ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.m66744n(ImagePreviewUI.this));
                                    ImagePreviewUI.this.mPo.setText(ImagePreviewUI.this.mController.ylL.getString(C25738R.string.c3i) + "");
                                    if (!ImagePreviewUI.this.mQW.contains(str)) {
                                        ImagePreviewUI.this.mRb.performClick();
                                    }
                                    AppMethodBeat.m2505o(21508);
                                }
                            });
                            C34237e.bBY().mo68660b((C20907b) this);
                            AppMethodBeat.m2505o(21509);
                        }
                    });
                    C34237e.bBY().mo68659b(stringExtra2, wz.getType(), stringExtra2, wz.mOk);
                    C4990ab.m7416i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
                }
            }
            AppMethodBeat.m2505o(21536);
            return;
        }
        if (intent != null) {
            setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
            finish();
        }
        AppMethodBeat.m2505o(21536);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private String bCJ() {
        AppMethodBeat.m2504i(21537);
        String string;
        switch (C34237e.bBZ().hOZ) {
            case 4:
            case 8:
            case 13:
            case 14:
                if (this.mQW.size() == 0 || this.mPA <= 1) {
                    string = getString(C25738R.string.c3k);
                    AppMethodBeat.m2505o(21537);
                    return string;
                }
                string = getString(C25738R.string.c3k) + "(" + this.mQW.size() + "/" + this.mPA + ")";
                AppMethodBeat.m2505o(21537);
                return string;
            case 7:
                if (C5046bo.isNullOrNil(this.mOL) || !this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                    if (this.mQW.size() == 0 || this.mPA <= 1) {
                        string = getString(C25738R.string.c3k);
                        AppMethodBeat.m2505o(21537);
                        return string;
                    }
                    string = getString(C25738R.string.c3k) + "(" + this.mQW.size() + "/" + this.mPA + ")";
                    AppMethodBeat.m2505o(21537);
                    return string;
                } else if (this.mQW.size() == 0 || this.mPA <= 1) {
                    string = getString(C25738R.string.f9182s1);
                    AppMethodBeat.m2505o(21537);
                    return string;
                } else {
                    string = getString(C25738R.string.f9182s1) + "(" + this.mQW.size() + "/" + this.mPA + ")";
                    AppMethodBeat.m2505o(21537);
                    return string;
                }
            case 11:
                string = getString(C25738R.string.bcc);
                AppMethodBeat.m2505o(21537);
                return string;
            default:
                if (this.mQW.size() == 0 || this.mPA <= 1) {
                    string = getString(C25738R.string.f9221tf);
                    AppMethodBeat.m2505o(21537);
                    return string;
                }
                string = getString(C25738R.string.c3c, new Object[]{Integer.valueOf(this.mQW.size()), Integer.valueOf(this.mPA)});
                AppMethodBeat.m2505o(21537);
                return string;
        }
    }

    private ArrayList<String> bCK() {
        AppMethodBeat.m2504i(21538);
        if (this.mQm) {
            ArrayList arrayList = this.mQW;
            AppMethodBeat.m2505o(21538);
            return arrayList;
        }
        ArrayList<String> arrayList2 = new ArrayList(this.mQW.size());
        Iterator it = this.mQV.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.mQW.contains(str)) {
                arrayList2.add(str);
            }
        }
        AppMethodBeat.m2505o(21538);
        return arrayList2;
    }

    /* renamed from: hF */
    private void m66737hF(boolean z) {
        AppMethodBeat.m2504i(21539);
        if (C34237e.bBZ().hOZ == 4) {
            AppMethodBeat.m2505o(21539);
        } else if (this.mQS == null) {
            C4990ab.m7416i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
            AppMethodBeat.m2505o(21539);
        } else {
            final MediaItem wz = this.mQS.mo71817wz(this.mQX.intValue());
            if (!z || wz == null) {
                this.mRn.setVisibility(8);
                AppMethodBeat.m2505o(21539);
                return;
            }
            this.mRn.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(21515);
                    ImagePreviewUI.m66715a(ImagePreviewUI.this, wz);
                    AppMethodBeat.m2505o(21515);
                }
            }, 400);
            AppMethodBeat.m2505o(21539);
        }
    }

    /* renamed from: hG */
    private void m66738hG(boolean z) {
        View findViewById;
        AppMethodBeat.m2504i(21540);
        C4990ab.m7410d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.mRf);
        if (this.mRf) {
            findViewById = findViewById(2131823176);
        } else {
            findViewById = findViewById(2131825001);
        }
        if (findViewById == null) {
            String str = "MicroMsg.ImagePreviewUI";
            String str2 = "set footer[%s] visibility[%B], but footerbar null";
            Object[] objArr = new Object[2];
            objArr[0] = this.mRf ? "normal" : "edit_tips";
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(21540);
        } else if (!(z && findViewById.getVisibility() == 0) && (z || findViewById.getVisibility() != 8)) {
            if (z) {
                findViewById.setVisibility(0);
                findViewById.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8332b5));
            } else {
                findViewById.setVisibility(8);
                findViewById.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8333b6));
            }
            if (z && this.mQU.getVisibility() == 8 && this.mQW.size() > 0) {
                this.mQU.setVisibility(0);
                this.mQU.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8332b5));
                AppMethodBeat.m2505o(21540);
                return;
            }
            if (!z && this.mQU.getVisibility() == 0) {
                this.mQU.setVisibility(8);
                this.mQU.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8333b6));
            }
            AppMethodBeat.m2505o(21540);
        } else {
            AppMethodBeat.m2505o(21540);
        }
    }

    private void goBack() {
        boolean z = true;
        AppMethodBeat.m2504i(21541);
        Intent intent = new Intent();
        boolean z2 = !this.kvs;
        String str = "CropImage_Compress_Img";
        if (!this.mPu) {
            z = z2;
        }
        intent.putExtra(str, z);
        intent.putStringArrayListExtra("preview_image_list", bCK());
        intent.putExtra("show_photo_edit_tip", this.mRq);
        setResult(0, intent);
        finish();
        AppMethodBeat.m2505o(21541);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21542);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(21542);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(21542);
        return onKeyDown;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21543);
        super.onDestroy();
        if (C34237e.bBZ().hOZ == 3 && getIntent().getBooleanExtra("preview_image", false) && getIntent().getIntExtra("max_select_count", 0) == 1) {
            C4990ab.m7416i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
            C25784s.ccQ.mo33296Ae().mo33291Ad();
        }
        if (this.mQS != null) {
            this.mQS.release();
        }
        C34237e.m56155B(null);
        unbindService(this.ktl);
        AppMethodBeat.m2505o(21543);
    }

    /* renamed from: a */
    private void m66720a(String str, MediaItem mediaItem) {
        AppMethodBeat.m2504i(21544);
        if (mediaItem != null && mediaItem.getType() == 2 && (C34237e.bBZ().hOZ == 4 || C34237e.bBZ().hOZ == 14 || C34237e.bBZ().hOZ == 13)) {
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                this.mRj.setVisibility(8);
            } else {
                this.mRj.setVisibility(0);
            }
            m66705NF(str);
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            enableOptionMenu(false);
            this.mRf = false;
            this.mRd.setVisibility(8);
            this.mRe.setVisibility(0);
            this.mRo.setVisibility(8);
            if (m66706NG(str)) {
                AppMethodBeat.m2505o(21544);
                return;
            } else if (C5046bo.isNullOrNil(videoMediaItem.fPU)) {
                enableOptionMenu(false);
                this.mRf = true;
                this.mRd.setVisibility(0);
                this.mRe.setVisibility(8);
                this.mQZ.setVisibility(8);
                m66725b(str, mediaItem);
                m66708NI(str);
                C20911m c20911m = new C20911m(str, this.mQX.intValue(), videoMediaItem, new C3424717());
                if (C7305d.xDG.mo10150ao(c20911m)) {
                    C4990ab.m7411d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", str);
                    AppMethodBeat.m2505o(21544);
                    return;
                }
                C7305d.post(c20911m, "video_analysis");
                AppMethodBeat.m2505o(21544);
                return;
            } else {
                C4990ab.m7411d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.fPT, Integer.valueOf(videoMediaItem.fPW), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
                m66721a(str, videoMediaItem);
                AppMethodBeat.m2505o(21544);
                return;
            }
        }
        this.mRf = true;
        this.mRd.setVisibility(0);
        this.mRe.setVisibility(8);
        this.mRp.setVisibility(8);
        m66725b(str, mediaItem);
        m66708NI(str);
        enableOptionMenu(true);
        this.mQZ.setVisibility(8);
        if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            boolean booleanExtra = getIntent().getBooleanExtra("preview_image", false);
            C4990ab.m7417i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", Integer.valueOf(C34237e.bBZ().hOZ), Boolean.valueOf(booleanExtra), str);
            if (mediaItem != null || C5046bo.isNullOrNil(str)) {
                this.mRj.setVisibility(8);
            } else {
                this.mRj.setVisibility(0);
            }
        } else {
            this.mRj.setVisibility(0);
        }
        m66705NF(str);
        AppMethodBeat.m2505o(21544);
    }

    /* renamed from: NF */
    private void m66705NF(String str) {
        AppMethodBeat.m2504i(21545);
        if (this.mQW.size() < 9 || this.mQW.contains(str)) {
            this.mRj.setEnabled(true);
            this.mRj.setTextColor(this.mController.ylL.getResources().getColor(C25738R.color.a6a));
            AppMethodBeat.m2505o(21545);
            return;
        }
        this.mRj.setTextColor(this.mController.ylL.getResources().getColor(C25738R.color.a6b));
        this.mRj.setEnabled(false);
        AppMethodBeat.m2505o(21545);
    }

    /* renamed from: a */
    private void m66721a(String str, VideoMediaItem videoMediaItem) {
        AppMethodBeat.m2504i(21546);
        enableOptionMenu(false);
        this.mRf = false;
        this.mRd.setVisibility(8);
        this.mRe.setVisibility(0);
        this.mRo.setVisibility(8);
        if (C34237e.bBZ().hOZ == 13) {
            this.mRe.setVisibility(8);
            this.mRd.setVisibility(8);
            this.mRk.setVisibility(8);
            this.mRl.setVisibility(8);
            enableOptionMenu(true);
            AppMethodBeat.m2505o(21546);
        } else if (m66726b(videoMediaItem)) {
            AppMethodBeat.m2505o(21546);
        } else if (m66730c(videoMediaItem)) {
            AppMethodBeat.m2505o(21546);
        } else if (m66722a(videoMediaItem)) {
            AppMethodBeat.m2505o(21546);
        } else {
            enableOptionMenu(true);
            this.mRf = true;
            this.mRd.setVisibility(0);
            this.mRe.setVisibility(8);
            this.mQZ.setVisibility(0);
            this.mRp.setVisibility(8);
            m66725b(str, (MediaItem) videoMediaItem);
            m66708NI(str);
            AppMethodBeat.m2505o(21546);
        }
    }

    /* renamed from: b */
    private void m66724b(MediaItem mediaItem) {
        AppMethodBeat.m2504i(21547);
        if (mediaItem == null) {
            C4990ab.m7412e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
            AppMethodBeat.m2505o(21547);
        } else if (mediaItem.getType() == 2) {
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            this.mRr = 300000;
            this.mRs = getString(C25738R.string.c3r);
            if (this.mOL != null && this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                this.mRr = (this.gLP * 1000) + 500;
                this.mRs = getString(C25738R.string.c4d, new Object[]{Integer.valueOf(this.gLP)});
            }
            if (C5046bo.isNullOrNil(videoMediaItem.fPU)) {
                C20911m c20911m = new C20911m(mediaItem.fPT, this.mQX.intValue(), videoMediaItem, new C3424818());
                if (C7305d.xDG.mo10150ao(c20911m)) {
                    C4990ab.m7411d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", mediaItem.fPT);
                    AppMethodBeat.m2505o(21547);
                    return;
                }
                C7305d.post(c20911m, "video_analysis");
            } else {
                C4990ab.m7411d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.fPT, Integer.valueOf(videoMediaItem.fPW), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
                if (videoMediaItem.fPW >= this.mRr || (videoMediaItem.fPW > 0 && videoMediaItem.fPW < 1000)) {
                    this.mRn.setVisibility(0);
                    this.mRm.setText(videoMediaItem.fPW >= this.mRr ? this.mRs : getString(C25738R.string.c3t));
                    this.mRc.setEnabled(false);
                    this.mRb.setEnabled(false);
                    this.mRc.setTextColor(getResources().getColor(C25738R.color.a6b));
                    if (this.mQW.size() == 0) {
                        enableOptionMenu(false);
                        AppMethodBeat.m2505o(21547);
                        return;
                    }
                }
                this.mRc.setEnabled(true);
                this.mRb.setEnabled(true);
                this.mRc.setTextColor(getResources().getColor(C25738R.color.a6a));
                this.mRn.setVisibility(8);
                AppMethodBeat.m2505o(21547);
                return;
            }
            AppMethodBeat.m2505o(21547);
        } else if (mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            if (mediaItem.getType() == 1 && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                C3276f c3276f = new C3276f(mediaItem.fPT);
                long asZ = C5730e.asZ(mediaItem.fPT);
                try {
                    if ((!this.mQW.contains(mediaItem.fPT) || asZ == 0 || asZ <= ((long) this.mOG.mo36244Nb())) && c3276f.noD[0] <= this.mOG.mo36243Na() && c3276f.noD[1] <= this.mOG.mo36243Na()) {
                        this.mRc.setTextColor(getResources().getColor(C25738R.color.a6a));
                        this.mRc.setEnabled(true);
                        this.mRb.setEnabled(true);
                        AppMethodBeat.m2505o(21547);
                        return;
                    }
                    this.mRc.setTextColor(getResources().getColor(C25738R.color.a6b));
                    this.mRc.setEnabled(false);
                    this.mRb.setEnabled(false);
                    AppMethodBeat.m2505o(21547);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.ImagePreviewUI", C5046bo.m7574l(e));
                }
            }
            AppMethodBeat.m2505o(21547);
        } else {
            this.mRc.setEnabled(true);
            this.mRb.setEnabled(true);
            this.mRc.setTextColor(getResources().getColor(C25738R.color.a6a));
            if (this.kvs && this.mQW.contains(mediaItem.fPT) && C5730e.asZ(mediaItem.fPT) > 26214400) {
                this.mRn.setVisibility(0);
                this.mRm.setText(getString(C25738R.string.c3y));
                AppMethodBeat.m2505o(21547);
                return;
            }
            this.mRn.setVisibility(8);
            AppMethodBeat.m2505o(21547);
        }
    }

    /* renamed from: NG */
    private boolean m66706NG(String str) {
        AppMethodBeat.m2504i(21548);
        if (C5730e.asZ(str) > 1073741824) {
            this.mRk.setText(getString(C25738R.string.c3q));
            this.mRl.setText(getString(C25738R.string.c3p));
            AppMethodBeat.m2505o(21548);
            return true;
        }
        AppMethodBeat.m2505o(21548);
        return false;
    }

    /* renamed from: a */
    private boolean m66722a(VideoMediaItem videoMediaItem) {
        AppMethodBeat.m2504i(21549);
        C4990ab.m7411d("MicroMsg.ImagePreviewUI", "check duration %d", Integer.valueOf(videoMediaItem.fPW));
        if (C34237e.bBZ().hOZ == 13) {
            AppMethodBeat.m2505o(21549);
            return false;
        } else if (videoMediaItem.fPW <= 1000) {
            this.mRk.setText(getString(C25738R.string.c3u));
            this.mRl.setText(getString(C25738R.string.c3t));
            AppMethodBeat.m2505o(21549);
            return true;
        } else if (videoMediaItem.fPW >= 300000) {
            this.mRk.setText(getString(C25738R.string.c3s));
            this.mRl.setText(getString(C25738R.string.c3r));
            AppMethodBeat.m2505o(21549);
            return true;
        } else if (videoMediaItem.fPW >= (this.mRi * 1000) + 500) {
            this.mRk.setText(getString(C25738R.string.c3h));
            this.mRl.setText(getString(C25738R.string.c3g, new Object[]{Integer.valueOf(this.mRi)}));
            this.mRo.setVisibility(0);
            AppMethodBeat.m2505o(21549);
            return true;
        } else {
            AppMethodBeat.m2505o(21549);
            return false;
        }
    }

    private boolean bCL() {
        AppMethodBeat.m2504i(21550);
        this.mRk.setText(getString(C25738R.string.c3l));
        this.mRl.setText(getString(C25738R.string.c3m));
        AppMethodBeat.m2505o(21550);
        return true;
    }

    /* renamed from: b */
    private boolean m66726b(VideoMediaItem videoMediaItem) {
        AppMethodBeat.m2504i(21551);
        if (videoMediaItem == null || videoMediaItem.videoWidth <= 0 || videoMediaItem.videoHeight <= 0 || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) > 3.0f || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) < 0.3f) {
            if (videoMediaItem != null) {
                C4990ab.m7411d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight));
            }
            this.mRk.setText(getString(C25738R.string.c3n));
            this.mRl.setText(getString(C25738R.string.c3o));
            AppMethodBeat.m2505o(21551);
            return true;
        }
        AppMethodBeat.m2505o(21551);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private boolean m66730c(VideoMediaItem videoMediaItem) {
        int i;
        String str;
        String str2;
        Object[] objArr;
        AppMethodBeat.m2504i(21552);
        C4990ab.m7411d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", videoMediaItem);
        if (videoMediaItem != null) {
            if ("video/hevc".equalsIgnoreCase(videoMediaItem.fPU) && C12691e.bOS()) {
                i = 1;
                if (videoMediaItem != null) {
                }
                str = "MicroMsg.ImagePreviewUI";
                str2 = "check video format failed, dst format [video/avc], video format [%s]";
                objArr = new Object[1];
                if (videoMediaItem == null) {
                }
                objArr[0] = videoMediaItem == null ? null : videoMediaItem.fPU;
                C4990ab.m7411d(str, str2, objArr);
                bCL();
                AppMethodBeat.m2505o(21552);
                return true;
            } else if ("video/avc".equalsIgnoreCase(videoMediaItem.fPU)) {
                i = 1;
                if (videoMediaItem != null || C5046bo.isNullOrNil(videoMediaItem.fPT) || m66707NH(videoMediaItem.fPT) || i == 0 || !(C5046bo.isNullOrNil(videoMediaItem.fPV) || "audio/mp4a-latm".equalsIgnoreCase(videoMediaItem.fPV))) {
                    str = "MicroMsg.ImagePreviewUI";
                    str2 = "check video format failed, dst format [video/avc], video format [%s]";
                    objArr = new Object[1];
                    objArr[0] = videoMediaItem == null ? null : videoMediaItem.fPU;
                    C4990ab.m7411d(str, str2, objArr);
                    bCL();
                    AppMethodBeat.m2505o(21552);
                    return true;
                }
                AppMethodBeat.m2505o(21552);
                return false;
            }
        }
        i = 0;
        if (videoMediaItem != null) {
        }
        str = "MicroMsg.ImagePreviewUI";
        str2 = "check video format failed, dst format [video/avc], video format [%s]";
        objArr = new Object[1];
        if (videoMediaItem == null) {
        }
        objArr[0] = videoMediaItem == null ? null : videoMediaItem.fPU;
        C4990ab.m7411d(str, str2, objArr);
        bCL();
        AppMethodBeat.m2505o(21552);
        return true;
    }

    /* renamed from: NH */
    private boolean m66707NH(String str) {
        AppMethodBeat.m2504i(21553);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(21553);
            return true;
        }
        if (this.mRt == null) {
            this.mRt = new HashSet();
            this.mRt.add(".h264");
            this.mRt.add(".h26l");
            this.mRt.add(".264");
            this.mRt.add(".avc");
            this.mRt.add(".mov");
            this.mRt.add(VideoMaterialUtil.MP4_SUFFIX);
            this.mRt.add(MediaConfig.VIDEO_AAC_FILE_POSTFIX);
            this.mRt.add(".3gp");
            this.mRt.add(".3g2");
            this.mRt.add(".mj2");
            this.mRt.add(".m4v");
        }
        String trim = str.trim();
        int lastIndexOf = trim.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf >= trim.length()) {
            AppMethodBeat.m2505o(21553);
            return true;
        } else if (this.mRt.contains(trim.substring(lastIndexOf))) {
            AppMethodBeat.m2505o(21553);
            return false;
        } else {
            AppMethodBeat.m2505o(21553);
            return true;
        }
    }

    /* renamed from: b */
    private void m66725b(String str, MediaItem mediaItem) {
        AppMethodBeat.m2504i(21554);
        if (mediaItem != null && mediaItem.getType() == 2 && C34237e.bBZ().hOZ == 4) {
            this.mRb.setVisibility(8);
            this.mRc.setVisibility(8);
            AppMethodBeat.m2505o(21554);
            return;
        }
        if (this.mPA == 1) {
            this.mRb.setVisibility(8);
            this.mRc.setVisibility(8);
        } else {
            this.mRb.setVisibility(0);
            this.mRc.setVisibility(0);
        }
        if (this.mQW.contains(str)) {
            this.mRb.setImageResource(C1318a.checkbox_selected);
            AppMethodBeat.m2505o(21554);
            return;
        }
        this.mRb.setImageResource(C1318a.checkbox_unselected);
        AppMethodBeat.m2505o(21554);
    }

    /* renamed from: NI */
    private void m66708NI(String str) {
        AppMethodBeat.m2504i(21555);
        Boolean bool = Boolean.FALSE;
        switch (C34237e.bBZ().hOZ) {
            case 4:
            case 7:
            case 13:
            case 14:
                bool = Boolean.TRUE;
                break;
            default:
                bool = Boolean.FALSE;
                break;
        }
        MediaItem NB = C34237e.m56156NB(str);
        if (NB != null && NB.getType() == 2) {
            bool = Boolean.TRUE;
        }
        if (NB == null && C5063r.amo(str)) {
            bool = Boolean.TRUE;
        } else if (NB != null && NB.mMimeType.equalsIgnoreCase("image/gif")) {
            bool = Boolean.TRUE;
        }
        if (bool.booleanValue()) {
            this.mQY.setVisibility(8);
            this.mPo.setVisibility(8);
            AppMethodBeat.m2505o(21555);
            return;
        }
        this.mQY.setVisibility(0);
        this.mPo.setVisibility(0);
        AppMethodBeat.m2505o(21555);
    }

    /* renamed from: b */
    private void m66723b(int i, int i2, String str, int i3) {
        AppMethodBeat.m2504i(21556);
        C4990ab.m7417i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (-1 != i2 && !this.mQm) {
            this.mQU.getAdapter().mo66312b(i2, Integer.valueOf(i2));
        } else if (-1 != i2) {
            if (i3 == 0 && i > 0) {
                ((C39180f) this.mQU.getAdapter()).addItem(str);
                ((C39180f) this.mQU.getAdapter()).mo62083el(i - 1, this.mQX.intValue());
                this.mQU.getAdapter().mo66317ch(i - 1);
                this.mQU.smoothScrollToPosition(i - 1);
            } else if (i3 == 1) {
                int indexOf = ((C39180f) this.mQU.getAdapter()).indexOf(str);
                if (-1 != indexOf) {
                    ((C39180f) this.mQU.getAdapter()).remove(indexOf);
                    this.mQU.getAdapter().mo66318ci(indexOf);
                }
            }
        }
        int i4;
        if (C34237e.bBZ().hOZ == 13) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        MediaItem wz = this.mQS.mo71817wz(this.mQX.intValue());
        if (i == 0 || ((this.mPu || i4 != 0) && this.mQS != null && wz != null && wz.getType() == 2)) {
            this.mQU.setVisibility(8);
            AppMethodBeat.m2505o(21556);
            return;
        }
        this.mQU.setVisibility(0);
        AppMethodBeat.m2505o(21556);
    }

    /* renamed from: a */
    static /* synthetic */ void m66714a(ImagePreviewUI imagePreviewUI, Intent intent, boolean z, boolean z2) {
        AppMethodBeat.m2504i(21562);
        intent.putExtra("CropImage_Compress_Img", z ? true : z2);
        ArrayList bCK = imagePreviewUI.bCK();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (bCK == null || bCK.size() <= 0) {
            C4990ab.m7416i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
            AppMethodBeat.m2505o(21562);
            return;
        }
        Iterator it = bCK.iterator();
        while (it.hasNext()) {
            Object obj = (String) it.next();
            MediaItem NB = C34237e.m56156NB(obj);
            if (NB == null || NB.getType() != 2) {
                if (!(NB == null || NB.getType() == 2 || !NB.mMimeType.equals("edit") || C5046bo.isNullOrNil(NB.mOj))) {
                    obj = NB.mOj;
                }
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        int i = C34237e.bBZ().hOZ == 14 ? 1 : 0;
        if ((z || i != 0) && arrayList.size() == 0 && arrayList2.size() == 1) {
            MediaItem NB2 = C34237e.m56156NB((String) arrayList2.get(0));
            if (NB2 == null || !(NB2 instanceof VideoMediaItem) || ((VideoMediaItem) NB2).fPW == -1) {
                C4990ab.m7412e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", NB2.fPT);
                intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", NB2.lZg);
                if (z) {
                    C25985d.m41468b((Context) imagePreviewUI, "mmsight", ".segment.VideoCompressUI", intent2, 4371);
                    AppMethodBeat.m2505o(21562);
                    return;
                }
                imagePreviewUI.setResult(-1, intent2);
                imagePreviewUI.finish();
                AppMethodBeat.m2505o(21562);
                return;
            }
        }
        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
        intent.putStringArrayListExtra("key_select_video_list", arrayList2);
        boolean booleanExtra = imagePreviewUI.getIntent().getBooleanExtra("isTakePhoto", false);
        if (booleanExtra && imagePreviewUI.bCK().size() > 0) {
            LatLongData ami = ExifHelper.ami((String) imagePreviewUI.bCK().get(0));
            Intent intent3 = new Intent(imagePreviewUI, ImagePreviewUI.class);
            C4990ab.m7411d("MicroMsg.ImagePreviewUI", "findlatlng %s", r0);
            if (ami != null) {
                C4990ab.m7411d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", Float.valueOf(ami.cEB), Float.valueOf(ami.fFz));
                intent3.putExtra("KlatLng", ami);
            }
        }
        C4990ab.m7411d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", Integer.valueOf(C34237e.bCg()), Boolean.valueOf(imagePreviewUI.mPu), Boolean.valueOf(z), Boolean.valueOf(z2));
        try {
            imagePreviewUI.mOG.mo36247aK(11610, (imagePreviewUI.mPu ? 3 : 2) + "," + C34237e.bCg());
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ImagePreviewUI", "report error, %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ImagePreviewUI", e, "", new Object[0]);
        }
        C34237e.bCf();
        C4990ab.m7410d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + booleanExtra + " | isPreviewPhoto ? " + intent.getBooleanExtra("isPreviewPhoto", false));
        intent.putExtra("isTakePhoto", booleanExtra);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (C5046bo.isNullOrNil(imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser")) || "medianote".equals(stringExtra)) {
            imagePreviewUI.setResult(-1, intent);
            imagePreviewUI.finish();
            AppMethodBeat.m2505o(21562);
        } else if (C5046bo.m7588yz() - imagePreviewUI.mPF < 1000) {
            C4990ab.m7420w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
            AppMethodBeat.m2505o(21562);
        } else {
            imagePreviewUI.mPF = C5046bo.m7588yz();
            C4990ab.m7416i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
            intent.setClassName(imagePreviewUI, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            intent.putExtra("GalleryUI_FromUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser"));
            intent.putExtra("GalleryUI_ToUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser"));
            intent.putExtra("CropImage_limit_Img_Size", 26214400);
            imagePreviewUI.startActivityForResult(intent, 4369);
            AppMethodBeat.m2505o(21562);
        }
    }

    /* renamed from: o */
    static /* synthetic */ void m66745o(ImagePreviewUI imagePreviewUI) {
        String str;
        AppMethodBeat.m2504i(21564);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        C4990ab.m7417i("MicroMsg.ImagePreviewUI", "edit image path:%s mPosition:%s", imagePreviewUI.mQS.getItem(imagePreviewUI.mQX.intValue()), imagePreviewUI.mQX);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", C34237e.bBZ().hOZ);
        intent.putExtra("preview_image_list", ((C39180f) imagePreviewUI.mQU.getAdapter()).mRE);
        if (C34237e.bBZ().hOZ == 4) {
            intent.putExtra("from_scene", C31128d.MIC_PTU_ZIRAN);
        } else if (C34237e.bBZ().hOZ == 3) {
            intent.putExtra("from_scene", 290);
        }
        intent.putExtra("preview_select_image_list", imagePreviewUI.mQW);
        MediaItem wz = imagePreviewUI.mQS.mo71817wz(imagePreviewUI.mQX.intValue());
        if (wz != null) {
            C4990ab.m7417i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] raw:%s orignal:%s", wz.mOi, wz.fPT);
            str = wz.mOi;
            if (C5046bo.isNullOrNil(str)) {
                str = wz.fPT;
                intent.putExtra("after_photo_edit", "");
            } else {
                intent.putExtra("after_photo_edit", wz.fPT);
            }
        } else {
            C4990ab.m7417i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] item == null mPosition:%s", imagePreviewUI.mQX);
            str = imagePreviewUI.mQS.getItem(imagePreviewUI.mQX.intValue());
            wz = MediaItem.m5515a(1, (long) imagePreviewUI.mQX.intValue(), str, str, "edit");
            ArrayList arrayList = new ArrayList();
            arrayList.add(wz);
            C34237e.m56155B(arrayList);
        }
        intent.putExtra("raw_photo_path", str);
        intent.setClass(imagePreviewUI, MMNewPhotoEditUI.class);
        imagePreviewUI.startActivityForResult(intent, 4372);
        AppMethodBeat.m2505o(21564);
    }

    /* renamed from: w */
    static /* synthetic */ void m66753w(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.m2504i(21568);
        if (imagePreviewUI.mRa == null || imagePreviewUI.mRa.doT()) {
            imagePreviewUI.mRa = new C7564ap(new C3424515(), false);
            imagePreviewUI.mRa.mo16770ae(350, 350);
            AppMethodBeat.m2505o(21568);
            return;
        }
        imagePreviewUI.mRa.stopTimer();
        AppMethodBeat.m2505o(21568);
    }
}
