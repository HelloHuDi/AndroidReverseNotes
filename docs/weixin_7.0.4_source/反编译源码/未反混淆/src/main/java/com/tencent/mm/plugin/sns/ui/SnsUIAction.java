package com.tencent.mm.plugin.sns.ui;

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
import android.support.v7.widget.Toolbar.LayoutParams;
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
import com.tencent.mm.R;
import com.tencent.mm.cf.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnsUIAction implements com.tencent.mm.plugin.sns.model.aw.a, b {
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
    a rBP;
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
    com.tencent.mm.modelsns.b rCd = null;
    private boolean rjn;
    private String ryC;
    private boolean ryD;
    private int ryE;
    int start = 0;
    protected p tipDialog = null;
    protected String title;

    public interface a {
        void Eh(int i);

        void ad(int i, boolean z);

        void b(int i, List<Integer> list, List<Integer> list2);

        void cuh();

        View cui();

        MMPullDownView cuj();

        boolean cuk();

        void cul();

        void cum();

        void fA(int i, int i2);

        View getMaskView();

        ListView getSnsListView();

        int getType();

        void ln(boolean z);
    }

    public SnsUIAction(Activity activity) {
        this.mActivity = activity;
    }

    public final void onCreate() {
        String str;
        AppMethodBeat.i(39654);
        this.qDc = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
        af.cnC().start();
        if (this.rBQ != null) {
            this.rBR = (LayoutParams) this.rBQ.getLayoutParams();
        }
        this.nDp = this.rBP.getSnsListView();
        this.nDp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39637);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                SnsUIAction.this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                af.cnu();
                s.fs(displayMetrics.widthPixels, displayMetrics.heightPixels);
                AppMethodBeat.o(39637);
            }
        });
        ab.i("MicroMsg.SnsActivity", "list is null ? " + (this.nDp != null));
        this.nDp.setScrollingCacheEnabled(false);
        this.qQt = new SnsHeader(this.mActivity);
        this.qQt.setSessionId(this.cvF);
        this.qQt.setEnterObjectId(this.qSf);
        this.qQt.setBackClickListener(new com.tencent.mm.plugin.sns.ui.SnsHeader.a() {
            public final boolean kH(long j) {
                AppMethodBeat.i(39644);
                if (SnsUIAction.this.rjn || SnsUIAction.this.rBP.getType() == 1) {
                    SnsUIAction.this.Em(2);
                } else {
                    n nVar = new n();
                    nVar.field_snsId = j;
                    nVar.field_userName = SnsUIAction.this.igi;
                    TimeLineObject ajM = e.ajM();
                    ajM.jBB = SnsUIAction.this.igi;
                    nVar.c(ajM);
                    n XX = aj.XX(SnsUIAction.this.igi);
                    ab.d("MicroMsg.SnsActivity", "friend like %s", SnsUIAction.this.igi);
                    if (XX == null) {
                        com.tencent.mm.plugin.sns.model.am.a.a(nVar, 1, "", 0);
                    } else if (XX.cqT()) {
                        com.tencent.mm.plugin.sns.model.am.a.a(nVar, 1, "", 0);
                    } else {
                        com.tencent.mm.plugin.sns.model.am.a.a(nVar, 5, "", 0);
                    }
                    l YX = af.cnJ().YX(SnsUIAction.this.igi);
                    YX.field_local_flag |= 2;
                    af.cnJ().c(YX);
                    SnsUIAction.e(SnsUIAction.this);
                }
                AppMethodBeat.o(39644);
                return false;
            }

            public final boolean ctk() {
                AppMethodBeat.i(39645);
                SnsUIAction.this.rBP.cum();
                AppMethodBeat.o(39645);
                return false;
            }
        });
        this.miL = this.rBP.cui();
        this.iVh = this.rBP.getMaskView();
        this.qQt.setHeadBgListener(new SnsHeader.b() {
            public final void aa(Bitmap bitmap) {
                AppMethodBeat.i(39646);
                if (bitmap != null) {
                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(SnsUIAction.this.mActivity, 65);
                    if (fromDPToPix > bitmap.getHeight()) {
                        fromDPToPix = bitmap.getHeight();
                    }
                    fromDPToPix = ae.ao(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), fromDPToPix))[0];
                    if (SnsUIAction.this.miL != null) {
                        SnsUIAction.this.miL.setBackgroundColor(fromDPToPix);
                    }
                }
                AppMethodBeat.o(39646);
            }
        });
        this.rBL = new LoadingMoreView(this.mActivity);
        this.nDp.addHeaderView(this.qQt);
        this.nDp.addFooterView(this.rBL);
        this.nDp.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(39647);
                SnsUIAction.this.rBP.Eh(i);
                if (i == 0) {
                    tn tnVar = new tn();
                    tnVar.cPI.type = 5;
                    tnVar.cPI.cPJ = SnsUIAction.this.nDp.getFirstVisiblePosition();
                    tnVar.cPI.cPK = SnsUIAction.this.nDp.getLastVisiblePosition();
                    tnVar.cPI.cPL = SnsUIAction.this.nDp.getHeaderViewsCount();
                    com.tencent.mm.sdk.b.a.xxA.m(tnVar);
                    if ((SnsUIAction.this.mActivity instanceof SnsTimeLineUI) && ((SnsTimeLineUI) SnsUIAction.this.mActivity).rqn != null) {
                        ((SnsTimeLineUI) SnsUIAction.this.mActivity).rqn.kH(true);
                    }
                    if (SnsUIAction.this.qQt != null) {
                        SnsHeader snsHeader = SnsUIAction.this.qQt;
                        if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                            snsHeader.rrU.rsk.cvt();
                        }
                    }
                }
                if (i == 2) {
                    d.dvV().ev(SnsUIAction.class.getName() + SnsUIAction.this.rBP.getType() + ".Listview", 4);
                    SnsUIAction.this.ln(true);
                    AppMethodBeat.o(39647);
                    return;
                }
                SnsUIAction.this.ln(false);
                AppMethodBeat.o(39647);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(39648);
                System.currentTimeMillis();
                SnsUIAction.this.rBO = (i + i2) - 1;
                if (SnsUIAction.this.nDp.getLastVisiblePosition() == SnsUIAction.this.nDp.getCount() - 1 && SnsUIAction.this.nDp.getCount() != SnsUIAction.this.rBM) {
                    ab.d("MicroMsg.SnsActivity", "now refresh count: %s", Integer.valueOf(SnsUIAction.this.nDp.getCount()));
                    SnsUIAction.this.rBM = SnsUIAction.this.nDp.getCount();
                    SnsUIAction.g(SnsUIAction.this);
                }
                if (absListView.getChildCount() == 0) {
                    AppMethodBeat.o(39648);
                    return;
                }
                float f;
                MMActivity mMActivity;
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(SnsUIAction.this.mActivity, 20);
                int i4 = 0;
                float f2 = 1.0f;
                float f3 = 1.0f;
                Object obj = 1;
                int i5 = 0;
                if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                    i5 = com.tencent.mm.bz.a.fromDPToPix(SnsUIAction.this.mActivity, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE);
                } else if (SnsUIAction.this.mActivity instanceof SnsUserUI) {
                    i5 = com.tencent.mm.bz.a.fromDPToPix(SnsUIAction.this.mActivity, 199);
                }
                int fromDPToPix2 = i5 - com.tencent.mm.bz.a.fromDPToPix(SnsUIAction.this.mActivity, 30);
                int fromDPToPix3 = i5 - com.tencent.mm.bz.a.fromDPToPix(SnsUIAction.this.mActivity, 10);
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
                    ab.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", Integer.valueOf(SnsUIAction.this.rCb), Integer.valueOf(top), Integer.valueOf(SnsUIAction.this.iZo));
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
                            mMActivity2.xE(SnsUIAction.this.mActivity.getResources().getColor(R.color.a3p));
                        } else {
                            mMActivity2.xE(ah.dJ(SnsUIAction.this.mActivity.getResources().getColor(R.color.vy), fromDPToPix2));
                        }
                        if (SnsUIAction.this.mActivity instanceof SnsTimeLineUI) {
                            if (obj != null) {
                                mMActivity2.Na(R.raw.icons_outlined_camera);
                            } else {
                                mMActivity2.Na(R.raw.icons_filled_camera);
                            }
                        }
                    }
                    SnsUIAction.this.rBP.fA(i, fromDPToPix2);
                    if (SnsUIAction.this.rBY != f) {
                        q qVar = mMActivity2.mController;
                        if (qVar.ylQ != null) {
                            qVar.ylQ.setAlpha(f);
                        }
                    }
                    if (SnsUIAction.this.rBX != f2) {
                        q qVar2 = mMActivity2.mController;
                        if (qVar2.ylR != null) {
                            qVar2.ylR.setAlpha(f2);
                            if (f2 == 0.0f) {
                                qVar2.ylR.setEnabled(false);
                            } else {
                                qVar2.ylR.setEnabled(true);
                            }
                        }
                        if (qVar2.yeP != null) {
                            qVar2.yeP.setAlpha(f2);
                            if (f2 == 0.0f) {
                                qVar2.yeP.setEnabled(false);
                            } else {
                                qVar2.yeP.setEnabled(true);
                            }
                        }
                    }
                }
                SnsUIAction.this.omW = fromDPToPix2;
                SnsUIAction.this.rBX = f2;
                SnsUIAction.this.rBY = f;
                AppMethodBeat.o(39648);
            }
        });
        this.ooW = this.rBP.cuj();
        ab.i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.ooW != null));
        this.ooW.setOnTopLoadDataListener(new g() {
            public final boolean bhn() {
                AppMethodBeat.i(39649);
                SnsUIAction.this.rBP.cul();
                AppMethodBeat.o(39649);
                return true;
            }
        });
        this.ooW.setTopViewVisible(false);
        this.ooW.setIsTopShowAll(false);
        this.ooW.setAtBottomCallBack(new c() {
            public final boolean bhm() {
                AppMethodBeat.i(39650);
                View childAt = SnsUIAction.this.nDp.getChildAt(SnsUIAction.this.nDp.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > SnsUIAction.this.nDp.getHeight() || SnsUIAction.this.nDp.getLastVisiblePosition() != SnsUIAction.this.nDp.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(39650);
                    return false;
                }
                AppMethodBeat.o(39650);
                return true;
            }
        });
        this.ooW.setAtTopCallBack(new MMPullDownView.d() {
            public final boolean bhl() {
                AppMethodBeat.i(39651);
                View childAt = SnsUIAction.this.nDp.getChildAt(SnsUIAction.this.nDp.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    AppMethodBeat.o(39651);
                    return false;
                }
                AppMethodBeat.o(39651);
                return true;
            }
        });
        this.ooW.setIsBottomShowAll(false);
        this.ooW.setOnBottomLoadDataListener(new MMPullDownView.e() {
            public final boolean bhk() {
                AppMethodBeat.i(39652);
                ab.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + SnsUIAction.this.koC);
                if (!SnsUIAction.this.koC) {
                    SnsUIAction.g(SnsUIAction.this);
                }
                AppMethodBeat.o(39652);
                return true;
            }
        });
        this.ooW.setShowBackground(true);
        this.ooW.setBgColor("#f4f4f4");
        this.title = this.mActivity.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.qQt;
        if (bo.isNullOrNil(this.igi)) {
            str = this.ryC;
        } else {
            str = this.igi;
        }
        String str2 = this.ryC;
        String str3 = this.gHT;
        CharSequence charSequence = this.mSignature;
        if (str == null || str2 == null) {
            ab.e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = str.trim();
            snsHeader.ecX = str2.trim();
            snsHeader.czr = str2.equals(str);
            ab.d("MicroMsg.SnsHeader", "userNamelen " + str.length() + "  " + str);
            snsHeader.rrU.jAJ.setText(str);
            if (!(snsHeader.rrU == null || snsHeader.rrU.eks == null)) {
                com.tencent.mm.pluginsdk.ui.a.b.t(snsHeader.rrU.eks, snsHeader.userName);
            }
            if (str != null && str.length() > 0) {
                snsHeader.rrU.jAJ.setText(j.b(snsHeader.context, i.K(str3)));
                snsHeader.rrU.rgK.setText(j.b(snsHeader.context, charSequence, snsHeader.rrU.rgK.getTextSize()));
            }
            snsHeader.rrU.eks.setContentDescription(snsHeader.context.getString(R.string.ejr, new Object[]{snsHeader.rrU.jAJ.getText()}));
        }
        this.qQt.setType(this.rBP.getType());
        this.qQt.cti();
        if (VERSION.SDK_INT < 11) {
            ab.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
        } else {
            new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39643);
                    AnonymousClass1 anonymousClass1 = new OnDragListener() {
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            int i = 0;
                            boolean z = true;
                            AppMethodBeat.i(39642);
                            switch (dragEvent.getAction()) {
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    ab.i("MicroMsg.SnsActivity", "ACTION: [%s]", Integer.valueOf(dragEvent.getAction()));
                                case 3:
                                    ab.i("MicroMsg.SnsActivity", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData != null) {
                                        int itemCount = clipData.getItemCount();
                                        ArrayList arrayList = new ArrayList();
                                        while (i < itemCount) {
                                            Item itemAt = clipData.getItemAt(i);
                                            if (itemAt == null) {
                                                ab.e("MicroMsg.SnsActivity", "item == null");
                                            } else if (itemAt.getIntent() != null) {
                                                SnsUIAction.this.mActivity.startActivity(itemAt.getIntent());
                                            } else if (itemAt.getUri() != null) {
                                                o oVar = new o(SnsUIAction.this.mActivity, itemAt.getUri());
                                                if (oVar.fileType != 0 && oVar.filePath != null) {
                                                    switch (oVar.fileType) {
                                                        case 3:
                                                            arrayList.add(oVar.filePath);
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                }
                                                ab.e("MicroMsg.SnsActivity", "get file path failed");
                                            }
                                            i++;
                                        }
                                        if (arrayList.size() < 0) {
                                            ab.e("MicroMsg.SnsActivity", "no image file available");
                                            AppMethodBeat.o(39642);
                                            break;
                                        }
                                        Intent intent = new Intent(SnsUIAction.this.mActivity, SnsUploadUI.class);
                                        intent.putExtra("KSnsPostManu", true);
                                        intent.putExtra("KTouchCameraTime", bo.anT());
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
                                    ab.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
                                    z = false;
                            }
                            AppMethodBeat.o(39642);
                            return z;
                        }
                    };
                    if (SnsUIAction.this.qQt != null) {
                        SnsUIAction.this.qQt.setOnDragListener(anonymousClass1);
                    }
                    AppMethodBeat.o(39643);
                }
            }.run();
        }
        af.cnB().epg.add(this);
        aw.qHB++;
        af.cnA().a((b) this);
        AppMethodBeat.o(39654);
    }

    public final void ln(boolean z) {
        AppMethodBeat.i(39655);
        this.rBP.ln(z);
        AppMethodBeat.o(39655);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this.ryC = str;
        this.igi = str2;
        this.gHT = str3;
        this.mSignature = str4;
        this.ryD = z;
        this.rjn = z2;
        this.ryE = i;
    }

    public final void onResume() {
        AppMethodBeat.i(39656);
        af.cnA().aa(2, false);
        com.tencent.mm.pluginsdk.wallet.i.Lt(7);
        com.tencent.mm.sdk.b.b meVar = new me();
        meVar.cHX.cHY = true;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, Looper.getMainLooper());
        ab.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
        if (this.qQt != null) {
            SnsHeader snsHeader = this.qQt;
            if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                SnsStoryHeaderView snsStoryHeaderView = snsHeader.rrU.rsk;
                ab.i("MicroMsg.SnsStoryHeaderView", "resume: ");
                snsStoryHeaderView.cAY = false;
                ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().cxd();
                snsStoryHeaderView.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40421);
                        SnsStoryHeaderView.c(SnsStoryHeaderView.this);
                        AppMethodBeat.o(40421);
                    }
                });
            }
        }
        AppMethodBeat.o(39656);
    }

    public final void onPause() {
        AppMethodBeat.i(39657);
        com.tencent.mm.sdk.b.b meVar = new me();
        meVar.cHX.cHY = false;
        com.tencent.mm.sdk.b.a.xxA.a(meVar, Looper.getMainLooper());
        ab.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
        if (this.qQt != null) {
            SnsHeader snsHeader = this.qQt;
            if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                SnsStoryHeaderView snsStoryHeaderView = snsHeader.rrU.rsk;
                snsStoryHeaderView.rMk = false;
                snsStoryHeaderView.cAY = true;
            }
        }
        AppMethodBeat.o(39657);
    }

    public final void setSessionId(String str) {
        AppMethodBeat.i(39658);
        this.cvF = str;
        if (this.qQt != null) {
            this.qQt.setSessionId(str);
        }
        AppMethodBeat.o(39658);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39659);
        ab.i("MicroMsg.SnsActivity", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            if (i == 5 || i == 2 || i == 4) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39653);
                        com.tencent.mm.plugin.sns.c.a.gkF.BU();
                        AppMethodBeat.o(39653);
                    }
                });
            }
            AppMethodBeat.o(39659);
            return;
        }
        int a;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(39659);
                    return;
                }
                com.tencent.mm.kernel.g.RQ();
                a = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68393, null), 0);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(68393, Integer.valueOf(a + 1));
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                com.tencent.mm.plugin.sns.c.a.gkE.a(this.mActivity, intent, intent2, af.getAccSnsTmpPath(), 4, new com.tencent.mm.ui.tools.a.a() {
                    public final String ZB(String str) {
                        AppMethodBeat.i(39638);
                        String str2 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.x((SnsUIAction.this.filePath + System.currentTimeMillis()).getBytes());
                        AppMethodBeat.o(39638);
                        return str2;
                    }
                });
                AppMethodBeat.o(39659);
                return;
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(39659);
                    return;
                }
                this.filePath = intent.getStringExtra("CropImage_OutputPath");
                ap(intent);
                AppMethodBeat.o(39659);
                return;
            case 5:
                this.filePath = com.tencent.mm.pluginsdk.ui.tools.n.h(this.mActivity.getApplicationContext(), intent, af.getAccSnsTmpPath());
                ab.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_TAKE_PHOTO  filePath" + this.filePath);
                if (this.filePath == null) {
                    AppMethodBeat.o(39659);
                    return;
                }
                com.tencent.mm.kernel.g.RQ();
                a = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68392, null), 0);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(68392, Integer.valueOf(a + 1));
                this.qGc = true;
                ap(intent);
                AppMethodBeat.o(39659);
                return;
            case 6:
                ab.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_UPLOAD_MEDIA");
                if (intent == null) {
                    AppMethodBeat.o(39659);
                    return;
                }
                this.rBP.b(intent.getIntExtra("sns_local_id", -1), null, null);
                af.cnB().cmp();
                AppMethodBeat.o(39659);
                return;
            case 7:
                ab.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHANGE_BG");
                this.qQt.cti();
                af.cnB().cmp();
                AppMethodBeat.o(39659);
                return;
            case 8:
                if (intent == null) {
                    AppMethodBeat.o(39659);
                    return;
                }
                ab.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_GALLERY_OP");
                SnsCmdList snsCmdList = (SnsCmdList) intent.getParcelableExtra("sns_cmd_list");
                if (snsCmdList != null) {
                    this.rBP.b(-1, snsCmdList.qFN, snsCmdList.qFO);
                    AppMethodBeat.o(39659);
                    return;
                }
                break;
            case 9:
                af.cnB().cmp();
                BackwardSupportUtil.c.a(this.nDp);
                AppMethodBeat.o(39659);
                return;
            case 10:
                if (intent == null) {
                    AppMethodBeat.o(39659);
                    return;
                } else if (i2 == -1) {
                    Cursor managedQuery = this.mActivity.managedQuery(intent.getData(), null, null, null, null);
                    if (managedQuery.moveToFirst()) {
                        this.mActivity.startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))))));
                    }
                    AppMethodBeat.o(39659);
                    return;
                }
                break;
            case 12:
                a = intent.getIntExtra("sns_gallery_op_id", -1);
                if (a > 0) {
                    ab.d("MicroMsg.SnsActivity", "notify cause by del item");
                    SnsCmdList snsCmdList2 = new SnsCmdList();
                    snsCmdList2.CK(a);
                    this.rBP.b(-1, snsCmdList2.qFN, snsCmdList2.qFO);
                    AppMethodBeat.o(39659);
                    return;
                }
                break;
            case 13:
                af.cnK().baT();
                AppMethodBeat.o(39659);
                return;
            case 14:
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39639);
                        com.tencent.mm.plugin.sns.c.a.gkF.BU();
                        AppMethodBeat.o(39639);
                    }
                });
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && bo.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                    ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                        ab.i("MicroMsg.SnsActivity", "no image selected");
                        AppMethodBeat.o(39659);
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
                    intent3.putExtra("KTouchCameraTime", bo.anT());
                    if (this.rCd != null) {
                        this.rCd.b(intent3, "intent_key_StatisticsOplog");
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
                    ab.d("MicroMsg.SnsActivity", "shared type %d", Integer.valueOf(intent3.getIntExtra("Ksnsupload_type", -1)));
                    this.mActivity.startActivityForResult(intent3, 6);
                    AppMethodBeat.o(39659);
                    return;
                }
                String stringExtra;
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                } else {
                    stringExtra = (String) stringArrayListExtra.get(0);
                }
                String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                if (bo.isNullOrNil(stringExtra2) || !com.tencent.mm.vfs.e.ct(stringExtra2)) {
                    stringExtra2 = af.getAccSnsTmpPath() + com.tencent.mm.vfs.e.atg(stringExtra);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(stringExtra);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                        if (frameAtTime == null) {
                            ab.e("MicroMsg.SnsActivity", "get bitmap error");
                            try {
                                mediaMetadataRetriever.release();
                                AppMethodBeat.o(39659);
                                return;
                            } catch (Exception e) {
                                AppMethodBeat.o(39659);
                                return;
                            }
                        }
                        ab.i("MicroMsg.SnsActivity", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                        com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, stringExtra2, true);
                        Options amj = com.tencent.mm.sdk.platformtools.d.amj(stringExtra2);
                        ab.i("MicroMsg.SnsActivity", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        ab.e("MicroMsg.SnsActivity", "savebitmap error %s", e3.getMessage());
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.o(39659);
                    }
                }
                ab.i("MicroMsg.SnsActivity", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(com.tencent.mm.vfs.e.asZ(stringExtra)), Long.valueOf(com.tencent.mm.vfs.e.asZ(stringExtra2)));
                Intent intent4 = new Intent();
                intent4.putExtra("KSightPath", stringExtra);
                intent4.putExtra("KSightThumbPath", stringExtra2);
                intent4.putExtra("sight_md5", com.tencent.mm.vfs.e.atg(stringExtra));
                intent4.putExtra("KSnsPostManu", true);
                intent4.putExtra("KTouchCameraTime", bo.anT());
                intent4.putExtra("Ksnsupload_type", 14);
                intent4.putExtra("Kis_take_photo", false);
                com.tencent.mm.bp.d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent4);
                AppMethodBeat.o(39659);
                return;
            case 15:
                AppMethodBeat.o(39659);
                return;
            case 17:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.osA) {
                        this.filePath = sightCaptureResult.osI;
                        if (!bo.isNullOrNil(this.filePath)) {
                            this.qGc = true;
                            ap(intent);
                            AppMethodBeat.o(39659);
                            return;
                        }
                    }
                    ab.i("MicroMsg.SnsActivity", "video path %s thumb path ", sightCaptureResult.osC, sightCaptureResult.osD);
                    Intent intent5 = new Intent();
                    intent5.putExtra("KSightPath", sightCaptureResult.osC);
                    intent5.putExtra("KSightThumbPath", sightCaptureResult.osD);
                    if (bo.isNullOrNil(sightCaptureResult.osF)) {
                        intent5.putExtra("sight_md5", com.tencent.mm.vfs.e.atg(sightCaptureResult.osC));
                    } else {
                        intent5.putExtra("sight_md5", sightCaptureResult.osF);
                    }
                    intent5.putExtra("KSnsPostManu", true);
                    intent5.putExtra("KTouchCameraTime", bo.anT());
                    intent5.putExtra("Ksnsupload_type", 14);
                    intent5.putExtra("Kis_take_photo", false);
                    intent5.putExtra("KSessionID", intent.getStringExtra("KSessionID"));
                    try {
                        byte[] toByteArray = sightCaptureResult.osH.toByteArray();
                        if (toByteArray != null) {
                            intent5.putExtra("KMMSightExtInfo", toByteArray);
                        }
                    } catch (Exception e6) {
                        ab.i("MicroMsg.SnsActivity", "put sight extinfo to snsuploadui error: %s", e6.getMessage());
                    }
                    com.tencent.mm.bp.d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent5);
                    AppMethodBeat.o(39659);
                    return;
                }
                break;
            default:
                ab.e("MicroMsg.SnsActivity", "onActivityResult: not found this requestCode");
                AppMethodBeat.o(39659);
                return;
        }
        AppMethodBeat.o(39659);
    }

    private void ap(Intent intent) {
        AppMethodBeat.i(39660);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39640);
                com.tencent.mm.plugin.sns.c.a.gkF.BU();
                AppMethodBeat.o(39640);
            }
        });
        ab.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
        ab.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
        if (this.filePath == null) {
            AppMethodBeat.o(39660);
            return;
        }
        int intExtra;
        String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.x((this.filePath + System.currentTimeMillis()).getBytes());
        s.aj(af.getAccSnsTmpPath(), this.filePath, str);
        this.filePath = af.getAccSnsTmpPath() + str;
        ab.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
        if (intent != null) {
            intExtra = intent.getIntExtra("CropImage_filterId", 0);
        } else {
            intExtra = 0;
        }
        Intent intent2 = new Intent(this.mActivity, SnsUploadUI.class);
        intent2.putExtra("KSnsPostManu", true);
        intent2.putExtra("KTouchCameraTime", bo.anT());
        if (this.rCd != null) {
            this.rCd.b(intent2, "intent_key_StatisticsOplog");
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
        AppMethodBeat.o(39660);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Em(final int i) {
        int i2 = 3;
        int i3 = 0;
        AppMethodBeat.i(39661);
        com.tencent.mm.kernel.g.RQ();
        if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            ab.d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(i)));
            if (i == 2) {
                Intent intent = new Intent();
                intent.putExtra("username", this.ryC);
                intent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
                this.mActivity.startActivityForResult(intent, 7);
                AppMethodBeat.o(39661);
                return true;
            }
            if (i == 1) {
                com.tencent.mm.kernel.g.RQ();
                int a = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68385, null), 0);
                com.tencent.mm.kernel.g.RQ();
                int a2 = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68386, null), 0);
                if (!this.rBN && a < 3 && a2 == 0) {
                    this.rBN = true;
                    ay.b(this.mActivity, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(39641);
                            com.tencent.mm.kernel.g.RQ();
                            int a = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68386, null), 0) + 1;
                            com.tencent.mm.kernel.g.RQ();
                            com.tencent.mm.kernel.g.RP().Ry().set(68386, Integer.valueOf(a));
                            SnsUIAction.this.Em(i);
                            AppMethodBeat.o(39641);
                        }
                    });
                    AppMethodBeat.o(39661);
                    return true;
                } else if (this.mActivity.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA(), 0).getString("gallery", "1").equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    com.tencent.mm.pluginsdk.ui.tools.n.a(this.mActivity, 2, null);
                } else {
                    ab.i("MicroMsg.SnsActivity", "takeVideo %d", Integer.valueOf(com.tencent.mm.m.g.Nu().getInt("SnsCanPickVideoFromAlbum", 1)));
                    if (!com.tencent.mm.platformtools.ae.gjt) {
                        i3 = a2;
                    }
                    if (i3 != 1 && i3 == 0) {
                        i2 = 1;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.afF().afI().duration);
                    com.tencent.mm.pluginsdk.ui.tools.n.a(this.mActivity, 14, 9, 4, i2, intent2);
                }
            }
            AppMethodBeat.o(39661);
            return true;
        }
        t.hO(this.mActivity);
        AppMethodBeat.o(39661);
        return false;
    }

    public final void onDestroy() {
        AppMethodBeat.i(39662);
        if (this.qQt != null) {
            SnsHeader snsHeader = this.qQt;
            if (!(snsHeader.rsa == null || snsHeader.rsa.isRecycled())) {
                snsHeader.rsa.recycle();
            }
            if (!(snsHeader.rrU == null || snsHeader.rrU.rsk == null)) {
                SnsStoryHeaderView snsStoryHeaderView = snsHeader.rrU.rsk;
                ab.i("MicroMsg.SnsStoryHeaderView", "destroy: ");
                ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().b(snsStoryHeaderView);
            }
        }
        com.tencent.mm.kernel.g.RQ();
        if (com.tencent.mm.kernel.g.RN().QY()) {
            af.cnC().ab(this.mActivity);
            af.cnA().b((b) this);
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.kernel.g.RQ();
        if (com.tencent.mm.kernel.g.RN().QY()) {
            af.cnB().epg.remove(this);
            aw.qHB--;
        }
        this.rBL.setVisibility(8);
        aa.crX();
        com.tencent.mm.kernel.g.RQ();
        if (com.tencent.mm.kernel.g.RN().QY()) {
            af.cnC().start();
        }
        this.nDp.setAdapter(null);
        AppMethodBeat.o(39662);
    }

    public final void Xw(String str) {
    }

    public final void bk(String str, boolean z) {
    }

    public final void cmu() {
        AppMethodBeat.i(39663);
        this.qQt.cti();
        AppMethodBeat.o(39663);
    }

    /* Access modifiers changed, original: protected|final */
    public final void lc(boolean z) {
        AppMethodBeat.i(39664);
        ab.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
        this.rBL.lc(z);
        AppMethodBeat.o(39664);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bf(int i, String str) {
        AppMethodBeat.i(138387);
        ab.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
        this.rBL.bf(i, str);
        AppMethodBeat.o(138387);
    }

    public final void ad(int i, boolean z) {
        AppMethodBeat.i(39666);
        this.rBP.ad(i, z);
        AppMethodBeat.o(39666);
    }

    public final void coo() {
        AppMethodBeat.i(39667);
        if (this.qQt != null) {
            this.qQt.cti();
        }
        AppMethodBeat.o(39667);
    }

    public final void bj(String str, boolean z) {
        AppMethodBeat.i(39668);
        if (this.rBP.getType() == 1 && this.nDp != null && this.nDp.getAdapter() != null && (this.nDp.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.a.a)) {
            ((com.tencent.mm.plugin.sns.ui.a.a) this.nDp.getAdapter()).notifyDataSetChanged();
        }
        AppMethodBeat.o(39668);
    }

    public ListView getSnsListView() {
        AppMethodBeat.i(39669);
        ListView snsListView = this.rBP.getSnsListView();
        AppMethodBeat.o(39669);
        return snsListView;
    }

    static /* synthetic */ void e(SnsUIAction snsUIAction) {
        AppMethodBeat.i(39670);
        View inflate = LayoutInflater.from(snsUIAction.mActivity).inflate(R.layout.avx, (ViewGroup) snsUIAction.mActivity.findViewById(R.id.ekk));
        t tVar = new t(snsUIAction.mActivity);
        tVar.setGravity(48, 0, BackwardSupportUtil.b.b(snsUIAction.mActivity, 200.0f));
        tVar.duration = 1000;
        tVar.setView(inflate);
        tVar.cancel();
        tVar.che.stopTimer();
        tVar.kmW = ((int) (tVar.duration / 70)) + 1;
        tVar.che.ae(70, 70);
        AppMethodBeat.o(39670);
    }

    static /* synthetic */ void g(SnsUIAction snsUIAction) {
        AppMethodBeat.i(39671);
        snsUIAction.rBP.cuh();
        AppMethodBeat.o(39671);
    }
}
