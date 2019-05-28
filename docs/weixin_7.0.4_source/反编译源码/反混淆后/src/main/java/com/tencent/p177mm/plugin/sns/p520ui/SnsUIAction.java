package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.p069v7.widget.Toolbar.LayoutParams;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.p230g.p231a.C18322me;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5262g;
import com.tencent.p177mm.p612ui.tools.C36338a.C15946a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.SnsCmdList;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29050aw;
import com.tencent.p177mm.plugin.sns.model.C29050aw.C29049a;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsHeader.C13534a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsHeader.C29120b;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.C29169a;
import com.tencent.p177mm.plugin.sns.p520ui.view.SnsStoryHeaderView;
import com.tencent.p177mm.plugin.sns.p520ui.view.SnsStoryHeaderView.C292442;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14988o;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction */
public class SnsUIAction implements C29049a, C43559b {
    private static int rBS = 0;
    private static int rBT = 1;
    private static int rBU = 2;
    private String cvF;
    protected String filePath;
    private String gHT;
    protected View iVh;
    int iZo = 0;
    private String igi;
    protected boolean koC = false;
    private int lastIndex;
    private Activity mActivity;
    private String mSignature;
    protected View miL;
    protected ListView nDp;
    int omW = 0;
    protected MMPullDownView ooW;
    public int qDc = 0;
    private boolean qGc = false;
    protected SnsHeader qQt;
    String qSf;
    protected LoadingMoreView rBL;
    private int rBM = 0;
    private boolean rBN = false;
    public int rBO = 0;
    C13559a rBP;
    View rBQ;
    private LayoutParams rBR;
    private int rBV;
    int rBW = 0;
    float rBX = 1.0f;
    float rBY = 1.0f;
    int rBZ = rBS;
    int rCa = rBS;
    int rCb = 0;
    boolean rCc = false;
    C37952b rCd = null;
    private boolean rjn;
    private String ryC;
    private boolean ryD;
    private int ryE;
    int start = 0;
    protected C44275p tipDialog = null;
    protected String title;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$10 */
    class C1355810 implements C5262g {
        C1355810() {
        }

        public final boolean bhn() {
            AppMethodBeat.m2504i(39649);
            SnsUIAction.this.rBP.cul();
            AppMethodBeat.m2505o(39649);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$a */
    public interface C13559a {
        /* renamed from: Eh */
        void mo25740Eh(int i);

        /* renamed from: ad */
        void mo25741ad(int i, boolean z);

        /* renamed from: b */
        void mo25742b(int i, List<Integer> list, List<Integer> list2);

        void cuh();

        View cui();

        MMPullDownView cuj();

        boolean cuk();

        void cul();

        void cum();

        /* renamed from: fA */
        void mo25749fA(int i, int i2);

        View getMaskView();

        ListView getSnsListView();

        int getType();

        /* renamed from: ln */
        void mo25753ln(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$7 */
    class C135607 implements C13534a {
        C135607() {
        }

        /* renamed from: kH */
        public final boolean mo25710kH(long j) {
            AppMethodBeat.m2504i(39644);
            if (SnsUIAction.this.rjn || SnsUIAction.this.rBP.getType() == 1) {
                SnsUIAction.this.mo25754Em(2);
            } else {
                C46236n c46236n = new C46236n();
                c46236n.field_snsId = j;
                c46236n.field_userName = SnsUIAction.this.igi;
                TimeLineObject ajM = C37953e.ajM();
                ajM.jBB = SnsUIAction.this.igi;
                c46236n.mo74257c(ajM);
                C46236n XX = C34955aj.m57389XX(SnsUIAction.this.igi);
                C4990ab.m7411d("MicroMsg.SnsActivity", "friend like %s", SnsUIAction.this.igi);
                if (XX == null) {
                    C3890a.m6182a(c46236n, 1, "", 0);
                } else if (XX.cqT()) {
                    C3890a.m6182a(c46236n, 1, "", 0);
                } else {
                    C3890a.m6182a(c46236n, 5, "", 0);
                }
                C29097l YX = C13373af.cnJ().mo69179YX(SnsUIAction.this.igi);
                YX.field_local_flag |= 2;
                C13373af.cnJ().mo69182c(YX);
                SnsUIAction.m21755e(SnsUIAction.this);
            }
            AppMethodBeat.m2505o(39644);
            return false;
        }

        public final boolean ctk() {
            AppMethodBeat.m2504i(39645);
            SnsUIAction.this.rBP.cum();
            AppMethodBeat.m2505o(39645);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$11 */
    class C1356211 implements C5258c {
        C1356211() {
        }

        public final boolean bhm() {
            AppMethodBeat.m2504i(39650);
            View childAt = SnsUIAction.this.nDp.getChildAt(SnsUIAction.this.nDp.getChildCount() - 1);
            if (childAt == null || childAt.getBottom() > SnsUIAction.this.nDp.getHeight() || SnsUIAction.this.nDp.getLastVisiblePosition() != SnsUIAction.this.nDp.getAdapter().getCount() - 1) {
                AppMethodBeat.m2505o(39650);
                return false;
            }
            AppMethodBeat.m2505o(39650);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$6 */
    class C135636 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$6$1 */
        class C135641 implements OnDragListener {
            C135641() {
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onDrag(View view, DragEvent dragEvent) {
                int i = 0;
                boolean z = true;
                AppMethodBeat.m2504i(39642);
                switch (dragEvent.getAction()) {
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                        C4990ab.m7417i("MicroMsg.SnsActivity", "ACTION: [%s]", Integer.valueOf(dragEvent.getAction()));
                    case 3:
                        C4990ab.m7416i("MicroMsg.SnsActivity", "ACTION_DROP");
                        ClipData clipData = dragEvent.getClipData();
                        if (clipData != null) {
                            int itemCount = clipData.getItemCount();
                            ArrayList arrayList = new ArrayList();
                            while (i < itemCount) {
                                Item itemAt = clipData.getItemAt(i);
                                if (itemAt == null) {
                                    C4990ab.m7412e("MicroMsg.SnsActivity", "item == null");
                                } else if (itemAt.getIntent() != null) {
                                    SnsUIAction.this.mActivity.startActivity(itemAt.getIntent());
                                } else if (itemAt.getUri() != null) {
                                    C14988o c14988o = new C14988o(SnsUIAction.this.mActivity, itemAt.getUri());
                                    if (c14988o.fileType != 0 && c14988o.filePath != null) {
                                        switch (c14988o.fileType) {
                                            case 3:
                                                arrayList.add(c14988o.filePath);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    C4990ab.m7412e("MicroMsg.SnsActivity", "get file path failed");
                                }
                                i++;
                            }
                            if (arrayList.size() < 0) {
                                C4990ab.m7412e("MicroMsg.SnsActivity", "no image file available");
                                AppMethodBeat.m2505o(39642);
                                break;
                            }
                            Intent intent = new Intent(SnsUIAction.this.mActivity, SnsUploadUI.class);
                            intent.putExtra("KSnsPostManu", true);
                            intent.putExtra("KTouchCameraTime", C5046bo.anT());
                            intent.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
                            intent.setAction("android.intent.action.SEND");
                            intent.addCategory("android.intent.category.DEFAULT");
                            intent.addFlags(268435456);
                            intent.putExtra("android.intent.extra.TEXT", "");
                            intent.putExtra("Ksnsupload_empty_img", true);
                            if (SnsUIAction.this.rjn) {
                                intent.putExtra("Ksnsupload_source", 11);
                            }
                            intent.setType("image/*");
                            SnsUIAction.this.mActivity.startActivity(intent);
                        }
                        break;
                    default:
                        C4990ab.m7412e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
                        z = false;
                }
                AppMethodBeat.m2505o(39642);
                return z;
            }
        }

        C135636() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39643);
            C135641 c135641 = new C135641();
            if (SnsUIAction.this.qQt != null) {
                SnsUIAction.this.qQt.setOnDragListener(c135641);
            }
            AppMethodBeat.m2505o(39643);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$9 */
    class C135659 implements OnScrollListener {
        C135659() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(39647);
            SnsUIAction.this.rBP.mo25740Eh(i);
            if (i == 0) {
                C6550tn c6550tn = new C6550tn();
                c6550tn.cPI.type = 5;
                c6550tn.cPI.cPJ = SnsUIAction.this.nDp.getFirstVisiblePosition();
                c6550tn.cPI.cPK = SnsUIAction.this.nDp.getLastVisiblePosition();
                c6550tn.cPI.cPL = SnsUIAction.this.nDp.getHeaderViewsCount();
                C4879a.xxA.mo10055m(c6550tn);
                if ((SnsUIAction.this.mActivity instanceof SnsTimeLineUI) && ((SnsTimeLineUI) SnsUIAction.this.mActivity).rqn != null) {
                    ((SnsTimeLineUI) SnsUIAction.this.mActivity).rqn.mo25442kH(true);
                }
                if (SnsUIAction.this.qQt != null) {
                    SnsHeader snsHeader = SnsUIAction.this.qQt;
                    if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                        snsHeader.rrU.rsk.cvt();
                    }
                }
            }
            if (i == 2) {
                C37634d.dvV().mo60468ev(SnsUIAction.class.getName() + SnsUIAction.this.rBP.getType() + ".Listview", 4);
                SnsUIAction.this.mo25761ln(true);
                AppMethodBeat.m2505o(39647);
                return;
            }
            SnsUIAction.this.mo25761ln(false);
            AppMethodBeat.m2505o(39647);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(39648);
            System.currentTimeMillis();
            SnsUIAction.this.rBO = (i + i2) - 1;
            if (SnsUIAction.this.nDp.getLastVisiblePosition() == SnsUIAction.this.nDp.getCount() - 1 && SnsUIAction.this.nDp.getCount() != SnsUIAction.this.rBM) {
                C4990ab.m7411d("MicroMsg.SnsActivity", "now refresh count: %s", Integer.valueOf(SnsUIAction.this.nDp.getCount()));
                SnsUIAction.this.rBM = SnsUIAction.this.nDp.getCount();
                SnsUIAction.m21757g(SnsUIAction.this);
            }
            if (absListView.getChildCount() == 0) {
                AppMethodBeat.m2505o(39648);
                return;
            }
            float f;
            MMActivity mMActivity;
            int fromDPToPix = C1338a.fromDPToPix(SnsUIAction.this.mActivity, 20);
            int i4 = 0;
            float f2 = 1.0f;
            float f3 = 1.0f;
            Object obj = 1;
            int i5 = 0;
            if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                i5 = C1338a.fromDPToPix(SnsUIAction.this.mActivity, C31128d.MIC_PTU_ZIPAI_LIGHTWHITE);
            } else if (SnsUIAction.this.mActivity instanceof SnsUserUI) {
                i5 = C1338a.fromDPToPix(SnsUIAction.this.mActivity, 199);
            }
            int fromDPToPix2 = i5 - C1338a.fromDPToPix(SnsUIAction.this.mActivity, 30);
            int fromDPToPix3 = i5 - C1338a.fromDPToPix(SnsUIAction.this.mActivity, 10);
            View childAt = absListView.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            SnsUIAction snsUIAction;
            if (i > SnsUIAction.this.lastIndex) {
                SnsUIAction.this.rBZ = SnsUIAction.rBT;
                if (childAt != null) {
                    snsUIAction = SnsUIAction.this;
                    snsUIAction.iZo += childAt.getHeight();
                }
            } else if (i < SnsUIAction.this.lastIndex) {
                SnsUIAction.this.rBZ = SnsUIAction.rBU;
                if (SnsUIAction.this.iZo >= childAt.getHeight()) {
                    snsUIAction = SnsUIAction.this;
                    snsUIAction.iZo -= childAt.getHeight();
                }
            } else if (Math.abs(top - SnsUIAction.this.rBV) > 1) {
                if (top < SnsUIAction.this.rBV) {
                    SnsUIAction.this.rBZ = SnsUIAction.rBT;
                } else if (top > SnsUIAction.this.rBV) {
                    SnsUIAction.this.rBZ = SnsUIAction.rBU;
                }
            }
            SnsUIAction.this.rCb = (-top) + SnsUIAction.this.iZo;
            SnsUIAction.this.lastIndex = i;
            SnsUIAction.this.rBV = top;
            if (SnsUIAction.this.rCa != SnsUIAction.this.rBZ) {
                SnsUIAction.this.start = SnsUIAction.this.rCb;
                SnsUIAction.this.rCc = false;
            }
            if (i == 0) {
                int i6 = -childAt.getTop();
                SnsUIAction.this.rCb = i6;
                if (i6 >= 0 && i6 <= fromDPToPix2) {
                    f2 = 1.0f;
                } else if (i6 <= fromDPToPix3) {
                    f2 = 1.0f - (((float) (i6 - fromDPToPix2)) / ((float) (fromDPToPix3 - fromDPToPix2)));
                } else if (i6 <= i5 + fromDPToPix) {
                    f2 = (((float) (i6 - i5)) * 1.0f) / ((float) fromDPToPix);
                }
                if (i6 >= 0 && i6 <= i5) {
                    fromDPToPix2 = 0;
                    obj = null;
                    f = 0.0f;
                } else if (i6 <= i5 + fromDPToPix) {
                    i4 = ((i6 - i5) * 100) / fromDPToPix;
                    f = (((float) (i6 - i5)) * 1.0f) / ((float) fromDPToPix);
                    fromDPToPix2 = i4;
                } else {
                    if (i6 > fromDPToPix + i5) {
                        i4 = 100;
                        f3 = 1.0f;
                    }
                    f = f3;
                    fromDPToPix2 = i4;
                }
            } else {
                f = 1.0f;
                fromDPToPix2 = 100;
            }
            if (SnsUIAction.this.iVh != null) {
                C4990ab.m7411d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", Integer.valueOf(SnsUIAction.this.rCb), Integer.valueOf(top), Integer.valueOf(SnsUIAction.this.iZo));
                if (SnsUIAction.this.rCb > i5) {
                    SnsUIAction.this.iVh.setVisibility(8);
                } else {
                    SnsUIAction.this.iVh.setVisibility(0);
                }
            }
            SnsUIAction.this.rBW = SnsUIAction.this.rCb;
            SnsUIAction.this.rCa = SnsUIAction.this.rBZ;
            if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                mMActivity = (SnsTimeLineUI) SnsUIAction.this.mActivity;
            } else if (SnsUIAction.this.mActivity instanceof SnsUserUI) {
                SnsUserUI mMActivity2 = (SnsUserUI) SnsUIAction.this.mActivity;
            } else {
                mMActivity2 = null;
            }
            if (mMActivity2 != null) {
                if (SnsUIAction.this.omW != fromDPToPix2) {
                    if (fromDPToPix2 <= 0) {
                        mMActivity2.mo17446xE(SnsUIAction.this.mActivity.getResources().getColor(C25738R.color.a3p));
                    } else {
                        mMActivity2.mo17446xE(C5225ah.m7960dJ(SnsUIAction.this.mActivity.getResources().getColor(C25738R.color.f12206vy), fromDPToPix2));
                    }
                    if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                        if (obj != null) {
                            mMActivity2.mo17371Na(C1318a.icons_outlined_camera);
                        } else {
                            mMActivity2.mo17371Na(C1318a.icons_filled_camera);
                        }
                    }
                }
                SnsUIAction.this.rBP.mo25749fA(i, fromDPToPix2);
                if (SnsUIAction.this.rBY != f) {
                    C5536q c5536q = mMActivity2.mController;
                    if (c5536q.ylQ != null) {
                        c5536q.ylQ.setAlpha(f);
                    }
                }
                if (SnsUIAction.this.rBX != f2) {
                    C5536q c5536q2 = mMActivity2.mController;
                    if (c5536q2.ylR != null) {
                        c5536q2.ylR.setAlpha(f2);
                        if (f2 == 0.0f) {
                            c5536q2.ylR.setEnabled(false);
                        } else {
                            c5536q2.ylR.setEnabled(true);
                        }
                    }
                    if (c5536q2.yeP != null) {
                        c5536q2.yeP.setAlpha(f2);
                        if (f2 == 0.0f) {
                            c5536q2.yeP.setEnabled(false);
                        } else {
                            c5536q2.yeP.setEnabled(true);
                        }
                    }
                }
            }
            SnsUIAction.this.omW = fromDPToPix2;
            SnsUIAction.this.rBX = f2;
            SnsUIAction.this.rBY = f;
            AppMethodBeat.m2505o(39648);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$8 */
    class C135668 implements C29120b {
        C135668() {
        }

        /* renamed from: aa */
        public final void mo25773aa(Bitmap bitmap) {
            AppMethodBeat.m2504i(39646);
            if (bitmap != null) {
                int fromDPToPix = C1338a.fromDPToPix(SnsUIAction.this.mActivity, 65);
                if (fromDPToPix > bitmap.getHeight()) {
                    fromDPToPix = bitmap.getHeight();
                }
                fromDPToPix = C5222ae.m7936ao(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), fromDPToPix))[0];
                if (SnsUIAction.this.miL != null) {
                    SnsUIAction.this.miL.setBackgroundColor(fromDPToPix);
                }
            }
            AppMethodBeat.m2505o(39646);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$12 */
    class C1356712 implements C5260d {
        C1356712() {
        }

        public final boolean bhl() {
            AppMethodBeat.m2504i(39651);
            View childAt = SnsUIAction.this.nDp.getChildAt(SnsUIAction.this.nDp.getFirstVisiblePosition());
            if (childAt == null || childAt.getTop() != 0) {
                AppMethodBeat.m2505o(39651);
                return false;
            }
            AppMethodBeat.m2505o(39651);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$14 */
    class C1356814 implements Runnable {
        C1356814() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39653);
            C24826a.gkF.mo38845BU();
            AppMethodBeat.m2505o(39653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$3 */
    class C135693 implements Runnable {
        C135693() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39639);
            C24826a.gkF.mo38845BU();
            AppMethodBeat.m2505o(39639);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$1 */
    class C135701 implements Runnable {
        C135701() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39637);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            SnsUIAction.this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            C13373af.cnu();
            C13478s.m21646fs(displayMetrics.widthPixels, displayMetrics.heightPixels);
            AppMethodBeat.m2505o(39637);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$2 */
    class C135712 implements C15946a {
        C135712() {
        }

        /* renamed from: ZB */
        public final String mo25777ZB(String str) {
            AppMethodBeat.m2504i(39638);
            String str2 = C13373af.getAccSnsTmpPath() + C1178g.m2591x((SnsUIAction.this.filePath + System.currentTimeMillis()).getBytes());
            AppMethodBeat.m2505o(39638);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$13 */
    class C1357213 implements C5257e {
        C1357213() {
        }

        public final boolean bhk() {
            AppMethodBeat.m2504i(39652);
            C4990ab.m7412e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + SnsUIAction.this.koC);
            if (!SnsUIAction.this.koC) {
                SnsUIAction.m21757g(SnsUIAction.this);
            }
            AppMethodBeat.m2505o(39652);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUIAction$4 */
    class C135734 implements Runnable {
        C135734() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39640);
            C24826a.gkF.mo38845BU();
            AppMethodBeat.m2505o(39640);
        }
    }

    public SnsUIAction(Activity activity) {
        this.mActivity = activity;
    }

    public final void onCreate() {
        String str;
        AppMethodBeat.m2504i(39654);
        this.qDc = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
        C13373af.cnC().start();
        if (this.rBQ != null) {
            this.rBR = (LayoutParams) this.rBQ.getLayoutParams();
        }
        this.nDp = this.rBP.getSnsListView();
        this.nDp.post(new C135701());
        C4990ab.m7416i("MicroMsg.SnsActivity", "list is null ? " + (this.nDp != null));
        this.nDp.setScrollingCacheEnabled(false);
        this.qQt = new SnsHeader(this.mActivity);
        this.qQt.setSessionId(this.cvF);
        this.qQt.setEnterObjectId(this.qSf);
        this.qQt.setBackClickListener(new C135607());
        this.miL = this.rBP.cui();
        this.iVh = this.rBP.getMaskView();
        this.qQt.setHeadBgListener(new C135668());
        this.rBL = new LoadingMoreView(this.mActivity);
        this.nDp.addHeaderView(this.qQt);
        this.nDp.addFooterView(this.rBL);
        this.nDp.setOnScrollListener(new C135659());
        this.ooW = this.rBP.cuj();
        C4990ab.m7416i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.ooW != null));
        this.ooW.setOnTopLoadDataListener(new C1355810());
        this.ooW.setTopViewVisible(false);
        this.ooW.setIsTopShowAll(false);
        this.ooW.setAtBottomCallBack(new C1356211());
        this.ooW.setAtTopCallBack(new C1356712());
        this.ooW.setIsBottomShowAll(false);
        this.ooW.setOnBottomLoadDataListener(new C1357213());
        this.ooW.setShowBackground(true);
        this.ooW.setBgColor("#f4f4f4");
        this.title = this.mActivity.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.qQt;
        if (C5046bo.isNullOrNil(this.igi)) {
            str = this.ryC;
        } else {
            str = this.igi;
        }
        String str2 = this.ryC;
        String str3 = this.gHT;
        CharSequence charSequence = this.mSignature;
        if (str == null || str2 == null) {
            C4990ab.m7412e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = str.trim();
            snsHeader.ecX = str2.trim();
            snsHeader.czr = str2.equals(str);
            C4990ab.m7410d("MicroMsg.SnsHeader", "userNamelen " + str.length() + "  " + str);
            snsHeader.rrU.jAJ.setText(str);
            if (!(snsHeader.rrU == null || snsHeader.rrU.eks == null)) {
                C40460b.m69439t(snsHeader.rrU.eks, snsHeader.userName);
            }
            if (str != null && str.length() > 0) {
                snsHeader.rrU.jAJ.setText(C44089j.m79292b(snsHeader.context, C29036i.m46075K(str3)));
                snsHeader.rrU.rgK.setText(C44089j.m79293b(snsHeader.context, charSequence, snsHeader.rrU.rgK.getTextSize()));
            }
            snsHeader.rrU.eks.setContentDescription(snsHeader.context.getString(C25738R.string.ejr, new Object[]{snsHeader.rrU.jAJ.getText()}));
        }
        this.qQt.setType(this.rBP.getType());
        this.qQt.cti();
        if (VERSION.SDK_INT < 11) {
            C4990ab.m7410d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
        } else {
            new C135636().run();
        }
        C13373af.cnB().epg.add(this);
        C29050aw.qHB++;
        C13373af.cnA().mo69136a((C43559b) this);
        AppMethodBeat.m2505o(39654);
    }

    /* renamed from: ln */
    public final void mo25761ln(boolean z) {
        AppMethodBeat.m2504i(39655);
        this.rBP.mo25753ln(z);
        AppMethodBeat.m2505o(39655);
    }

    /* renamed from: a */
    public final void mo25755a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this.ryC = str;
        this.igi = str2;
        this.gHT = str3;
        this.mSignature = str4;
        this.ryD = z;
        this.rjn = z2;
        this.ryE = i;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(39656);
        C13373af.cnA().mo69140aa(2, false);
        C14991i.m23324Lt(7);
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = true;
        C4879a.xxA.mo10048a(c18322me, Looper.getMainLooper());
        C4990ab.m7410d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
        if (this.qQt != null) {
            SnsHeader snsHeader = this.qQt;
            if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                SnsStoryHeaderView snsStoryHeaderView = snsHeader.rrU.rsk;
                C4990ab.m7416i("MicroMsg.SnsStoryHeaderView", "resume: ");
                snsStoryHeaderView.cAY = false;
                ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cxd();
                snsStoryHeaderView.post(new C292442());
            }
        }
        AppMethodBeat.m2505o(39656);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(39657);
        C4883b c18322me = new C18322me();
        c18322me.cHX.cHY = false;
        C4879a.xxA.mo10048a(c18322me, Looper.getMainLooper());
        C4990ab.m7410d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
        if (this.qQt != null) {
            SnsHeader snsHeader = this.qQt;
            if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                SnsStoryHeaderView snsStoryHeaderView = snsHeader.rrU.rsk;
                snsStoryHeaderView.rMk = false;
                snsStoryHeaderView.cAY = true;
            }
        }
        AppMethodBeat.m2505o(39657);
    }

    public final void setSessionId(String str) {
        AppMethodBeat.m2504i(39658);
        this.cvF = str;
        if (this.qQt != null) {
            this.qQt.setSessionId(str);
        }
        AppMethodBeat.m2505o(39658);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39659);
        C4990ab.m7416i("MicroMsg.SnsActivity", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            if (i == 5 || i == 2 || i == 4) {
                new C7306ak(Looper.getMainLooper()).post(new C1356814());
            }
            AppMethodBeat.m2505o(39659);
            return;
        }
        int a;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                C1720g.m3537RQ();
                a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68393, null), 0);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(68393, Integer.valueOf(a + 1));
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                C24826a.gkE.mo38891a(this.mActivity, intent, intent2, C13373af.getAccSnsTmpPath(), 4, new C135712());
                AppMethodBeat.m2505o(39659);
                return;
            case 4:
                if (intent == null) {
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                this.filePath = intent.getStringExtra("CropImage_OutputPath");
                m21749ap(intent);
                AppMethodBeat.m2505o(39659);
                return;
            case 5:
                this.filePath = C14987n.m23320h(this.mActivity.getApplicationContext(), intent, C13373af.getAccSnsTmpPath());
                C4990ab.m7410d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_TAKE_PHOTO  filePath" + this.filePath);
                if (this.filePath == null) {
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                C1720g.m3537RQ();
                a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68392, null), 0);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(68392, Integer.valueOf(a + 1));
                this.qGc = true;
                m21749ap(intent);
                AppMethodBeat.m2505o(39659);
                return;
            case 6:
                C4990ab.m7410d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_UPLOAD_MEDIA");
                if (intent == null) {
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                this.rBP.mo25742b(intent.getIntExtra("sns_local_id", -1), null, null);
                C13373af.cnB().cmp();
                AppMethodBeat.m2505o(39659);
                return;
            case 7:
                C4990ab.m7410d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHANGE_BG");
                this.qQt.cti();
                C13373af.cnB().cmp();
                AppMethodBeat.m2505o(39659);
                return;
            case 8:
                if (intent == null) {
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                C4990ab.m7410d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_GALLERY_OP");
                SnsCmdList snsCmdList = (SnsCmdList) intent.getParcelableExtra("sns_cmd_list");
                if (snsCmdList != null) {
                    this.rBP.mo25742b(-1, snsCmdList.qFN, snsCmdList.qFO);
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                break;
            case 9:
                C13373af.cnB().cmp();
                C4978c.m7375a(this.nDp);
                AppMethodBeat.m2505o(39659);
                return;
            case 10:
                if (intent == null) {
                    AppMethodBeat.m2505o(39659);
                    return;
                } else if (i2 == -1) {
                    Cursor managedQuery = this.mActivity.managedQuery(intent.getData(), null, null, null, null);
                    if (managedQuery.moveToFirst()) {
                        this.mActivity.startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))))));
                    }
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                break;
            case 12:
                a = intent.getIntExtra("sns_gallery_op_id", -1);
                if (a > 0) {
                    C4990ab.m7410d("MicroMsg.SnsActivity", "notify cause by del item");
                    SnsCmdList snsCmdList2 = new SnsCmdList();
                    snsCmdList2.mo8581CK(a);
                    this.rBP.mo25742b(-1, snsCmdList2.qFN, snsCmdList2.qFO);
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                break;
            case 13:
                C13373af.cnK().baT();
                AppMethodBeat.m2505o(39659);
                return;
            case 14:
                new C7306ak(Looper.getMainLooper()).post(new C135693());
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && C5046bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                    ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                        C4990ab.m7416i("MicroMsg.SnsActivity", "no image selected");
                        AppMethodBeat.m2505o(39659);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = stringArrayListExtra2.iterator();
                    while (it.hasNext()) {
                        if (Exif.fromFile((String) it.next()).getLocation() != null) {
                            arrayList.add(String.format("%s\n%f\n%f", new Object[]{(String) it.next(), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().latitude), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().longitude)}));
                        }
                    }
                    this.qGc = intent.getBooleanExtra("isTakePhoto", false);
                    Intent intent3 = new Intent(this.mActivity, SnsUploadUI.class);
                    intent3.putExtra("KSnsPostManu", true);
                    intent3.putExtra("KTouchCameraTime", C5046bo.anT());
                    if (this.rCd != null) {
                        this.rCd.mo60717b(intent3, "intent_key_StatisticsOplog");
                        this.rCd = null;
                    }
                    if (this.rjn) {
                        intent3.putExtra("Ksnsupload_source", 11);
                    }
                    int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                    intent3.putExtra("sns_kemdia_path_list", stringArrayListExtra2);
                    intent3.putExtra("KFilterId", intExtra);
                    if (this.qGc) {
                        intent3.putExtra("Kis_take_photo", true);
                    }
                    intent3.putStringArrayListExtra("sns_media_latlong_list", arrayList);
                    C4990ab.m7411d("MicroMsg.SnsActivity", "shared type %d", Integer.valueOf(intent3.getIntExtra("Ksnsupload_type", -1)));
                    this.mActivity.startActivityForResult(intent3, 6);
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                String stringExtra;
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                } else {
                    stringExtra = (String) stringArrayListExtra.get(0);
                }
                String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                if (C5046bo.isNullOrNil(stringExtra2) || !C5730e.m8628ct(stringExtra2)) {
                    stringExtra2 = C13373af.getAccSnsTmpPath() + C5730e.atg(stringExtra);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(stringExtra);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                        if (frameAtTime == null) {
                            C4990ab.m7412e("MicroMsg.SnsActivity", "get bitmap error");
                            try {
                                mediaMetadataRetriever.release();
                                AppMethodBeat.m2505o(39659);
                                return;
                            } catch (Exception e) {
                                AppMethodBeat.m2505o(39659);
                                return;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.SnsActivity", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                        C5056d.m7625a(frameAtTime, 80, CompressFormat.JPEG, stringExtra2, true);
                        Options amj = C5056d.amj(stringExtra2);
                        C4990ab.m7417i("MicroMsg.SnsActivity", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        C4990ab.m7413e("MicroMsg.SnsActivity", "savebitmap error %s", e3.getMessage());
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.m2505o(39659);
                    }
                }
                C4990ab.m7417i("MicroMsg.SnsActivity", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(C5730e.asZ(stringExtra)), Long.valueOf(C5730e.asZ(stringExtra2)));
                Intent intent4 = new Intent();
                intent4.putExtra("KSightPath", stringExtra);
                intent4.putExtra("KSightThumbPath", stringExtra2);
                intent4.putExtra("sight_md5", C5730e.atg(stringExtra));
                intent4.putExtra("KSnsPostManu", true);
                intent4.putExtra("KTouchCameraTime", C5046bo.anT());
                intent4.putExtra("Ksnsupload_type", 14);
                intent4.putExtra("Kis_take_photo", false);
                C25985d.m41467b(this.mActivity, "sns", ".ui.SnsUploadUI", intent4);
                AppMethodBeat.m2505o(39659);
                return;
            case 15:
                AppMethodBeat.m2505o(39659);
                return;
            case 17:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.osA) {
                        this.filePath = sightCaptureResult.osI;
                        if (!C5046bo.isNullOrNil(this.filePath)) {
                            this.qGc = true;
                            m21749ap(intent);
                            AppMethodBeat.m2505o(39659);
                            return;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.SnsActivity", "video path %s thumb path ", sightCaptureResult.osC, sightCaptureResult.osD);
                    Intent intent5 = new Intent();
                    intent5.putExtra("KSightPath", sightCaptureResult.osC);
                    intent5.putExtra("KSightThumbPath", sightCaptureResult.osD);
                    if (C5046bo.isNullOrNil(sightCaptureResult.osF)) {
                        intent5.putExtra("sight_md5", C5730e.atg(sightCaptureResult.osC));
                    } else {
                        intent5.putExtra("sight_md5", sightCaptureResult.osF);
                    }
                    intent5.putExtra("KSnsPostManu", true);
                    intent5.putExtra("KTouchCameraTime", C5046bo.anT());
                    intent5.putExtra("Ksnsupload_type", 14);
                    intent5.putExtra("Kis_take_photo", false);
                    intent5.putExtra("KSessionID", intent.getStringExtra("KSessionID"));
                    try {
                        byte[] toByteArray = sightCaptureResult.osH.toByteArray();
                        if (toByteArray != null) {
                            intent5.putExtra("KMMSightExtInfo", toByteArray);
                        }
                    } catch (Exception e6) {
                        C4990ab.m7417i("MicroMsg.SnsActivity", "put sight extinfo to snsuploadui error: %s", e6.getMessage());
                    }
                    C25985d.m41467b(this.mActivity, "sns", ".ui.SnsUploadUI", intent5);
                    AppMethodBeat.m2505o(39659);
                    return;
                }
                break;
            default:
                C4990ab.m7412e("MicroMsg.SnsActivity", "onActivityResult: not found this requestCode");
                AppMethodBeat.m2505o(39659);
                return;
        }
        AppMethodBeat.m2505o(39659);
    }

    /* renamed from: ap */
    private void m21749ap(Intent intent) {
        AppMethodBeat.m2504i(39660);
        new C7306ak(Looper.getMainLooper()).post(new C135734());
        C4990ab.m7410d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
        C4990ab.m7410d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
        if (this.filePath == null) {
            AppMethodBeat.m2505o(39660);
            return;
        }
        int intExtra;
        String str = "pre_temp_sns_pic" + C1178g.m2591x((this.filePath + System.currentTimeMillis()).getBytes());
        C13478s.m21642aj(C13373af.getAccSnsTmpPath(), this.filePath, str);
        this.filePath = C13373af.getAccSnsTmpPath() + str;
        C4990ab.m7410d("MicroMsg.SnsActivity", "newPath " + this.filePath);
        if (intent != null) {
            intExtra = intent.getIntExtra("CropImage_filterId", 0);
        } else {
            intExtra = 0;
        }
        Intent intent2 = new Intent(this.mActivity, SnsUploadUI.class);
        intent2.putExtra("KSnsPostManu", true);
        intent2.putExtra("KTouchCameraTime", C5046bo.anT());
        if (this.rCd != null) {
            this.rCd.mo60717b(intent2, "intent_key_StatisticsOplog");
            this.rCd = null;
        }
        intent2.putExtra("sns_kemdia_path", this.filePath);
        intent2.putExtra("KFilterId", intExtra);
        if (this.qGc) {
            intent2.putExtra("Kis_take_photo", true);
        }
        if (this.rjn) {
            intent2.putExtra("Ksnsupload_source", 11);
        }
        intent2.putExtra("KSessionID", intent.getStringExtra("KSessionID"));
        this.mActivity.startActivityForResult(intent2, 6);
        this.qGc = false;
        AppMethodBeat.m2505o(39660);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Em */
    public final boolean mo25754Em(final int i) {
        int i2 = 3;
        int i3 = 0;
        AppMethodBeat.m2504i(39661);
        C1720g.m3537RQ();
        if (C1720g.m3536RP().isSDCardAvailable()) {
            C4990ab.m7410d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(i)));
            if (i == 2) {
                Intent intent = new Intent();
                intent.putExtra("username", this.ryC);
                intent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
                this.mActivity.startActivityForResult(intent, 7);
                AppMethodBeat.m2505o(39661);
                return true;
            }
            if (i == 1) {
                C1720g.m3537RQ();
                int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68385, null), 0);
                C1720g.m3537RQ();
                int a2 = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68386, null), 0);
                if (!this.rBN && a < 3 && a2 == 0) {
                    this.rBN = true;
                    C13635ay.m21867b(this.mActivity, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(39641);
                            C1720g.m3537RQ();
                            int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68386, null), 0) + 1;
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(68386, Integer.valueOf(a));
                            SnsUIAction.this.mo25754Em(i);
                            AppMethodBeat.m2505o(39641);
                        }
                    });
                    AppMethodBeat.m2505o(39661);
                    return true;
                } else if (this.mActivity.getSharedPreferences(C4996ah.doA(), 0).getString("gallery", "1").equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    C14987n.m23301a(this.mActivity, 2, null);
                } else {
                    C4990ab.m7417i("MicroMsg.SnsActivity", "takeVideo %d", Integer.valueOf(C26373g.m41964Nu().getInt("SnsCanPickVideoFromAlbum", 1)));
                    if (!C1947ae.gjt) {
                        i3 = a2;
                    }
                    if (i3 != 1 && i3 == 0) {
                        i2 = 1;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_edit_video_max_time_length", C42204d.afF().afI().duration);
                    C14987n.m23295a(this.mActivity, 14, 9, 4, i2, intent2);
                }
            }
            AppMethodBeat.m2505o(39661);
            return true;
        }
        C23639t.m36492hO(this.mActivity);
        AppMethodBeat.m2505o(39661);
        return false;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(39662);
        if (this.qQt != null) {
            SnsHeader snsHeader = this.qQt;
            if (!(snsHeader.rsa == null || snsHeader.rsa.isRecycled())) {
                snsHeader.rsa.recycle();
            }
            if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                SnsStoryHeaderView snsStoryHeaderView = snsHeader.rrU.rsk;
                C4990ab.m7416i("MicroMsg.SnsStoryHeaderView", "destroy: ");
                ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().mo47453b(snsStoryHeaderView);
            }
        }
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C13373af.cnC().mo37452ab(this.mActivity);
            C13373af.cnA().mo69142b((C43559b) this);
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C13373af.cnB().epg.remove(this);
            C29050aw.qHB--;
        }
        this.rBL.setVisibility(8);
        C46247aa.crX();
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C13373af.cnC().start();
        }
        this.nDp.setAdapter(null);
        AppMethodBeat.m2505o(39662);
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
    }

    public final void cmu() {
        AppMethodBeat.m2504i(39663);
        this.qQt.cti();
        AppMethodBeat.m2505o(39663);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: lc */
    public final void mo25760lc(boolean z) {
        AppMethodBeat.m2504i(39664);
        C4990ab.m7410d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
        this.rBL.mo55600lc(z);
        AppMethodBeat.m2505o(39664);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bf */
    public final void mo25757bf(int i, String str) {
        AppMethodBeat.m2504i(138387);
        C4990ab.m7410d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
        this.rBL.mo55599bf(i, str);
        AppMethodBeat.m2505o(138387);
    }

    /* renamed from: ad */
    public final void mo25756ad(int i, boolean z) {
        AppMethodBeat.m2504i(39666);
        this.rBP.mo25741ad(i, z);
        AppMethodBeat.m2505o(39666);
    }

    public final void coo() {
        AppMethodBeat.m2504i(39667);
        if (this.qQt != null) {
            this.qQt.cti();
        }
        AppMethodBeat.m2505o(39667);
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
        AppMethodBeat.m2504i(39668);
        if (this.rBP.getType() == 1 && this.nDp != null && this.nDp.getAdapter() != null && (this.nDp.getAdapter() instanceof C29169a)) {
            ((C29169a) this.nDp.getAdapter()).notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(39668);
    }

    public ListView getSnsListView() {
        AppMethodBeat.m2504i(39669);
        ListView snsListView = this.rBP.getSnsListView();
        AppMethodBeat.m2505o(39669);
        return snsListView;
    }

    /* renamed from: e */
    static /* synthetic */ void m21755e(SnsUIAction snsUIAction) {
        AppMethodBeat.m2504i(39670);
        View inflate = LayoutInflater.from(snsUIAction.mActivity).inflate(2130970786, (ViewGroup) snsUIAction.mActivity.findViewById(2131827816));
        C23639t c23639t = new C23639t(snsUIAction.mActivity);
        c23639t.setGravity(48, 0, C4977b.m7371b(snsUIAction.mActivity, 200.0f));
        c23639t.duration = 1000;
        c23639t.setView(inflate);
        c23639t.cancel();
        c23639t.che.stopTimer();
        c23639t.kmW = ((int) (c23639t.duration / 70)) + 1;
        c23639t.che.mo16770ae(70, 70);
        AppMethodBeat.m2505o(39670);
    }

    /* renamed from: g */
    static /* synthetic */ void m21757g(SnsUIAction snsUIAction) {
        AppMethodBeat.m2504i(39671);
        snsUIAction.rBP.cuh();
        AppMethodBeat.m2505o(39671);
    }
}
