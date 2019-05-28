package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelcontrol.C37938c;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p230g.p231a.C37793re;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMNewPhotoEditUI;
import com.tencent.p177mm.p612ui.base.C46631f;
import com.tencent.p177mm.p612ui.base.MMPageControlView;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView.C36063a;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C24029e;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1025h.C34937b;
import com.tencent.p177mm.plugin.sns.p520ui.C29238s.C29239a;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.C29169a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip */
public class SnsInfoFlip extends FlipView {
    private static int fgI = 0;
    private static int fgJ = 0;
    private Context context;
    private C7306ak handler = new C7306ak();
    List<C34937b> items;
    boolean qFG = false;
    private C44222az qFT = C44222az.xYU;
    private boolean rps = false;
    private boolean rpu = false;
    MMPageControlView rsA;
    private Runnable rsB = null;
    private String rsC = "";
    private int rsD = -1;
    private int rsE = -1;
    private boolean rsF = false;
    long rsG = 0;
    private HashSet<String> rsH = new HashSet();
    private Map<String, Boolean> rsI;
    private int rsJ = 0;
    private int rsK = 0;
    private boolean rsL = false;
    private C3981c rsM;
    private HashMap<String, C46236n> rsN = new HashMap();
    int rsO = -1;
    private HashSet<String> rsP = new HashSet();
    public int rsQ = 0;
    public int rsR = 0;
    private HashMap<String, C3983a> rsS = new HashMap();
    private C36063a rsT = new C39846();
    C3985b rsm;
    Gallery rsn;
    private boolean rso = true;
    HashMap<Integer, Integer> rsp = new HashMap();
    HashMap<Integer, Long> rsq = new HashMap();
    HashMap<Integer, Long> rsr = new HashMap();
    private boolean rss = false;
    private boolean rst = false;
    private boolean rsu = false;
    private boolean rsv = false;
    private boolean rsw = false;
    private boolean rsx = true;
    private boolean rsy = true;
    private float rsz = 1.0f;
    public String username;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$3 */
    class C39763 implements Runnable {
        C39763() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38969);
            SnsInfoFlip.this.rsm.cts();
            AppMethodBeat.m2505o(38969);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$2 */
    class C39772 implements C24029e {
        C39772() {
        }

        public final void ctp() {
            AppMethodBeat.m2504i(38968);
            if (SnsInfoFlip.this.ris != null) {
                SnsInfoFlip.this.ris.crN();
            }
            AppMethodBeat.m2505o(38968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$4 */
    class C39804 implements OnItemSelectedListener {
        C39804() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(38970);
            if (SnsInfoFlip.this.rsm != null) {
                if (SnsInfoFlip.this.rss && SnsInfoFlip.this.rsm.getCount() > 1) {
                    SnsInfoFlip.this.rsA.setVisibility(0);
                    SnsInfoFlip.this.rsA.setPage(i);
                }
                SnsInfoFlip.m6349a(SnsInfoFlip.this, ((C34937b) SnsInfoFlip.this.rsm.getItem(i)).cNr, i, ((C34937b) SnsInfoFlip.this.rsm.getItem(i)).qQd);
                if (view instanceof MultiTouchImageView) {
                    ((MultiTouchImageView) view).dzA();
                }
                if ((SnsInfoFlip.this.rsn instanceof MMGestureGallery) && (SnsInfoFlip.this.context instanceof SnsBrowseUI)) {
                    ((SnsBrowseUI) SnsInfoFlip.this.context).csT();
                }
            }
            AppMethodBeat.m2505o(38970);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$c */
    public interface C3981c {
        /* renamed from: Eb */
        void mo8815Eb(int i);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$5 */
    class C39825 implements OnItemLongClickListener {
        C39825() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(38971);
            if (SnsInfoFlip.this.rso) {
                if (SnsInfoFlip.this.rsn instanceof MMGestureGallery) {
                    C32800b y = C37922v.m64076Zp().mo60676y("basescanui@datacenter", true);
                    y.mo53356j("key_basescanui_screen_x", Integer.valueOf(((MMGestureGallery) SnsInfoFlip.this.rsn).getXDown()));
                    y.mo53356j("key_basescanui_screen_y", Integer.valueOf(((MMGestureGallery) SnsInfoFlip.this.rsn).getYDown()));
                }
                String str = ((C34937b) SnsInfoFlip.this.rsm.getItem(i)).qQd;
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(38971);
                    return false;
                }
                String str2 = ((C34937b) SnsInfoFlip.this.rsm.getItem(i)).cNr.f17915Id;
                SnsInfoFlip.this.mo76141f(C3892an.m6198fZ(C13373af.getAccSnsPath(), str2) + C29036i.m46121l(((C34937b) SnsInfoFlip.this.rsm.getItem(i)).cNr), str, str2, true);
                AppMethodBeat.m2505o(38971);
                return true;
            }
            AppMethodBeat.m2505o(38971);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$a */
    class C3983a {
        int fjN;
        int networkType;
        long qNk = -1;
        int rsW = -1;
        long rsX = -1;
        long rsY = -1;
        String rsZ;

        C3983a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$6 */
    class C39846 implements C36063a {
        C39846() {
        }

        public final void ctq() {
            AppMethodBeat.m2504i(38972);
            if (SnsInfoFlip.this.rsn.getSelectedItem() == null || SnsInfoFlip.this.rsm == null) {
                AppMethodBeat.m2505o(38972);
                return;
            }
            int selectedItemPosition = SnsInfoFlip.this.rsn.getSelectedItemPosition();
            C46236n YT = C13373af.cnF().mo62918YT(((C34937b) SnsInfoFlip.this.rsn.getSelectedItem()).qQd);
            if (YT != null) {
                C29169a.m46340d(YT, selectedItemPosition);
            }
            AppMethodBeat.m2505o(38972);
        }

        public final void ctr() {
            AppMethodBeat.m2504i(38973);
            if (SnsInfoFlip.this.rsn.getSelectedItem() == null || SnsInfoFlip.this.rsm == null) {
                AppMethodBeat.m2505o(38973);
                return;
            }
            int selectedItemPosition = SnsInfoFlip.this.rsn.getSelectedItemPosition();
            C46236n YT = C13373af.cnF().mo62918YT(((C34937b) SnsInfoFlip.this.rsn.getSelectedItem()).qQd);
            if (YT != null) {
                C29169a.m46342e(YT, selectedItemPosition);
            }
            AppMethodBeat.m2505o(38973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$b */
    class C3985b extends BaseAdapter {
        private Context context;
        private String fns = "";
        private boolean kNs = true;
        private int rgh = 0;
        private boolean rta = false;
        Map<String, WeakReference<View>> rtb = new HashMap();
        private String rtc;

        public C3985b(Context context) {
            AppMethodBeat.m2504i(38974);
            this.context = context;
            this.rta = C46631f.dzs();
            this.rgh = SnsInfoFlip.this.items.size();
            C37938c.afC();
            this.kNs = C37938c.afE();
            AppMethodBeat.m2505o(38974);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(38975);
            if (SnsInfoFlip.this.items == null) {
                AppMethodBeat.m2505o(38975);
                return 0;
            }
            int size = SnsInfoFlip.this.items.size();
            AppMethodBeat.m2505o(38975);
            return size;
        }

        /* renamed from: DZ */
        private void m6376DZ(int i) {
            AppMethodBeat.m2504i(38976);
            bau bau = ((C34937b) SnsInfoFlip.this.items.get(i)).cNr;
            C44222az a = C44222az.m79813a(SnsInfoFlip.this.qFT, ((C34937b) SnsInfoFlip.this.items.get(i)).fDG);
            if (bau.jCt != 2) {
                AppMethodBeat.m2505o(38976);
                return;
            }
            boolean Zl = C35002v.m57482Zl(((C34937b) SnsInfoFlip.this.items.get(i)).qQd);
            C13373af.cnC();
            Zl = C21925g.m33523a(bau, a, Zl);
            if (SnsInfoFlip.this.rps && !Zl) {
                SnsInfoFlip.m6350a(SnsInfoFlip.this, bau.f17915Id);
            }
            AppMethodBeat.m2505o(38976);
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(38977);
            if (((C34937b) SnsInfoFlip.this.items.get(i)).cNr.jCt == 6) {
                AppMethodBeat.m2505o(38977);
                return 0;
            }
            AppMethodBeat.m2505o(38977);
            return 1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:78:0x03da  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x02a0  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0491  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x03e6  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x03a7  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x03be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(38978);
            if (((C34937b) SnsInfoFlip.this.items.get(i)).cNr.jCt == 6) {
                String str = "MicroMsg.SnsInfoFlip";
                String str2 = "fill view online sight %d convert view is null %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(view == null);
                C4990ab.m7411d(str, str2, objArr);
                C34937b c34937b = (C34937b) SnsInfoFlip.this.items.get(i);
                if (c34937b == null) {
                    C4990ab.m7420w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
                    AppMethodBeat.m2505o(38978);
                    return view;
                }
                str2 = c34937b.qQd;
                if (C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7420w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
                    AppMethodBeat.m2505o(38978);
                    return view;
                }
                View onlineVideoView;
                WeakReference weakReference = (WeakReference) this.rtb.get(str2);
                if (weakReference == null || weakReference.get() == null) {
                    onlineVideoView = new OnlineVideoView(this.context);
                    this.rtb.put(str2, new WeakReference(onlineVideoView));
                } else {
                    onlineVideoView = (OnlineVideoView) weakReference.get();
                }
                if (C5046bo.isEqual(str2, this.rtc)) {
                    mo8819Ea(i);
                }
                C4990ab.m7417i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", Integer.valueOf(onlineVideoView.hashCode()), c34937b.qQd);
                AppMethodBeat.m2505o(38978);
                return onlineVideoView;
            }
            C3986d c3986d;
            Object obj;
            bau bau;
            Bitmap a;
            LayoutParams layoutParams;
            bau bau2 = ((C34937b) SnsInfoFlip.this.items.get(i)).cNr;
            C4990ab.m7410d("MicroMsg.SnsInfoFlip", "gallery position " + i + " " + this.rgh + " " + bau2.f17915Id);
            if (view == null) {
                C3986d c3986d2 = new C3986d();
                view = View.inflate(this.context, 2130970762, null);
                c3986d2.rtd = view.findViewById(2131827762);
                c3986d2.rte = (ProgressBar) view.findViewById(2131821219);
                c3986d2.nHi = (TextView) view.findViewById(2131827764);
                c3986d2.rtf = (FrameLayout) view.findViewById(2131827763);
                c3986d2.cDh = (ImageView) view.findViewById(2131820629);
                view.setTag(c3986d2);
                c3986d = c3986d2;
            } else {
                c3986d = (C3986d) view.getTag();
            }
            c3986d.position = i;
            C44222az a2 = C44222az.m79813a(SnsInfoFlip.this.qFT, ((C34937b) SnsInfoFlip.this.items.get(i)).fDG);
            view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            c3986d.rte.setVisibility(8);
            c3986d.nHi.setVisibility(8);
            c3986d.rtf.setVisibility(0);
            if (C5046bo.isNullOrNil(SnsInfoFlip.this.rsC) || !SnsInfoFlip.this.rsC.equals(bau2.f17915Id)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (bau2.f17915Id.startsWith("Locall_path") && !C5046bo.isNullOrNil(((C34937b) SnsInfoFlip.this.items.get(i)).qQd)) {
                C46236n c46236n = (C46236n) SnsInfoFlip.this.rsN.get(((C34937b) SnsInfoFlip.this.items.get(i)).qQd);
                if (c46236n == null) {
                    C46236n YT = C13373af.cnF().mo62918YT(((C34937b) SnsInfoFlip.this.items.get(i)).qQd);
                    SnsInfoFlip.this.rsN.put(((C34937b) SnsInfoFlip.this.items.get(i)).qQd, YT);
                    c46236n = YT;
                }
                TimeLineObject cqu = c46236n.cqu();
                if (cqu.xfI.wbK.size() > ((C34937b) SnsInfoFlip.this.items.get(i)).qQe) {
                    bau = (bau) cqu.xfI.wbK.get(((C34937b) SnsInfoFlip.this.items.get(i)).qQe);
                    a = C13373af.cnC().mo37435a(bau, c3986d.cDh, this.context.hashCode(), obj != null, a2, C35002v.m57482Zl(((C34937b) SnsInfoFlip.this.items.get(i)).qQd));
                    if (a == null && SnsInfoFlip.this.rps) {
                        SnsInfoFlip.m6350a(SnsInfoFlip.this, bau.f17915Id);
                    }
                    layoutParams = c3986d.cDh.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    c3986d.cDh.setLayoutParams(layoutParams);
                    if (a != null && bau.f17915Id != null && !bau.f17915Id.startsWith("pre_temp_extend_pic")) {
                        LayoutParams layoutParams2 = c3986d.cDh.getLayoutParams();
                        C4977b.m7371b(this.context, 160.0f);
                        int b = C4977b.m7371b(this.context, 200.0f);
                        C4977b.m7371b(this.context, 44.0f);
                        C45434n XK = C13373af.cnC().mo37430XK(C29036i.m46102bc(1, bau.f17915Id));
                        if (!C29036i.m46101b(XK)) {
                            XK = null;
                        }
                        if (XK != null) {
                            double width = (double) XK.bitmap.getWidth();
                            double height = (double) XK.bitmap.getHeight();
                            if (width > 0.0d && height > 0.0d) {
                                Math.min(((double) b) / width, ((double) b) / height);
                            }
                        }
                        c3986d.cDh.setLayoutParams(layoutParams);
                        c3986d.rte.setVisibility(0);
                        c3986d.cDh.setVisibility(0);
                        C13373af.cnC().mo37462dz(c3986d.cDh);
                        C13373af.cnC().mo37457b(bau, c3986d.cDh, (int) C25738R.drawable.abd, this.context.hashCode(), a2);
                        SnsInfoFlip.fgJ = layoutParams2.width;
                        SnsInfoFlip.fgI = layoutParams2.height;
                        if (obj != null) {
                            c3986d.rte.setVisibility(8);
                        }
                    } else if (this.rta) {
                        c3986d.rte.setVisibility(8);
                        C13373af.cnC().mo37434a(bau, c3986d.cDh, this.context.hashCode(), a2, C35002v.m57482Zl(((C34937b) SnsInfoFlip.this.items.get(i)).qQd));
                        c3986d.cDh.setImageBitmap(a);
                        c3986d.cDh.setVisibility(0);
                    } else {
                        c3986d.rte.setVisibility(8);
                        if (a != null) {
                            if (!SnsInfoFlip.this.rsL) {
                                C4990ab.m7416i("MicroMsg.SnsInfoFlip", "update view ");
                                View multiTouchImageView = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.this.rsT);
                                multiTouchImageView.setEnableHorLongBmpMode(SnsInfoFlip.this.rsw);
                                multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                                C13373af.cnC().mo37434a(bau, multiTouchImageView, this.context.hashCode(), a2, C35002v.m57482Zl(((C34937b) SnsInfoFlip.this.items.get(i)).qQd));
                                multiTouchImageView.setImageBitmap(a);
                                C4990ab.m7411d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", bau.f17915Id, SnsInfoFlip.this.rsI.get(bau.f17915Id), Integer.valueOf(multiTouchImageView.getId()));
                                AppMethodBeat.m2505o(38978);
                                return multiTouchImageView;
                            }
                            AppMethodBeat.m2505o(38978);
                            return view;
                        }
                    }
                    if (this.kNs && C32856ab.m53750ch(this.context)) {
                        if (i - 1 >= 0) {
                            m6376DZ(i - 1);
                        }
                        if (i + 1 < SnsInfoFlip.this.rsm.getCount()) {
                            m6376DZ(i + 1);
                        }
                    }
                    AppMethodBeat.m2505o(38978);
                    return view;
                }
            }
            bau = bau2;
            if (obj != null) {
            }
            a = C13373af.cnC().mo37435a(bau, c3986d.cDh, this.context.hashCode(), obj != null, a2, C35002v.m57482Zl(((C34937b) SnsInfoFlip.this.items.get(i)).qQd));
            SnsInfoFlip.m6350a(SnsInfoFlip.this, bau.f17915Id);
            layoutParams = c3986d.cDh.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            c3986d.cDh.setLayoutParams(layoutParams);
            if (a != null) {
            }
            if (this.rta) {
            }
            if (i - 1 >= 0) {
            }
            if (i + 1 < SnsInfoFlip.this.rsm.getCount()) {
            }
            AppMethodBeat.m2505o(38978);
            return view;
        }

        public final void clear() {
            AppMethodBeat.m2504i(38979);
            C4990ab.m7416i("MicroMsg.SnsInfoFlip", "adapter clear.");
            this.rtb.clear();
            AppMethodBeat.m2505o(38979);
        }

        /* renamed from: Ea */
        public final void mo8819Ea(int i) {
            AppMethodBeat.m2504i(38980);
            C34937b c34937b = (C34937b) SnsInfoFlip.this.items.get(i);
            if (c34937b == null) {
                C4990ab.m7420w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
                AppMethodBeat.m2505o(38980);
                return;
            }
            String str = c34937b.qQd;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
                AppMethodBeat.m2505o(38980);
                return;
            }
            C4990ab.m7417i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", Integer.valueOf(i), str);
            WeakReference weakReference = (WeakReference) this.rtb.get(str);
            if (weakReference == null) {
                C4990ab.m7420w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
                this.rtc = str;
                AppMethodBeat.m2505o(38980);
                return;
            }
            OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
            if (onlineVideoView == null) {
                C4990ab.m7421w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", str);
                this.rtc = str;
                AppMethodBeat.m2505o(38980);
                return;
            }
            C4990ab.m7417i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", Integer.valueOf(onlineVideoView.hashCode()), str);
            this.rtc = null;
            onlineVideoView.csb();
            onlineVideoView.mo55602a(c34937b.cNr, c34937b.qQd, c34937b.fDG);
            C37793re c37793re = new C37793re();
            c37793re.cNj.cAd = 1;
            c37793re.cNj.czD = str;
            C4879a.xxA.mo10055m(c37793re);
            AppMethodBeat.m2505o(38980);
        }

        public final void cts() {
            AppMethodBeat.m2504i(38981);
            C4990ab.m7417i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", C5046bo.dpG());
            C37793re c37793re = new C37793re();
            c37793re.cNj.context = this.context;
            c37793re.cNj.czD = this.rtc;
            c37793re.cNj.cAd = 2;
            C4879a.xxA.mo10055m(c37793re);
            this.rtc = null;
            AppMethodBeat.m2505o(38981);
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(38982);
            if (i >= SnsInfoFlip.this.items.size() || i < 0) {
                AppMethodBeat.m2505o(38982);
                return null;
            }
            Object obj = SnsInfoFlip.this.items.get(i);
            AppMethodBeat.m2505o(38982);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.m2504i(38983);
            this.rgh = SnsInfoFlip.this.items.size();
            C4990ab.m7410d("MicroMsg.SnsInfoFlip", "items.size:" + SnsInfoFlip.this.items.size());
            SnsInfoFlip.this.invalidate();
            SnsInfoFlip.this.requestLayout();
            super.notifyDataSetChanged();
            if (SnsInfoFlip.this.items.size() <= 0 && SnsInfoFlip.this.rsB != null) {
                SnsInfoFlip.this.rsB.run();
            }
            AppMethodBeat.m2505o(38983);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$d */
    static class C3986d {
        ImageView cDh;
        TextView nHi;
        int position;
        View rtd;
        ProgressBar rte;
        FrameLayout rtf;
        String videoPath = "";

        C3986d() {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m6349a(SnsInfoFlip snsInfoFlip, bau bau, int i, String str) {
        AppMethodBeat.m2504i(39009);
        snsInfoFlip.m6351a(bau, i, str);
        AppMethodBeat.m2505o(39009);
    }

    public C44222az getFromScene() {
        return this.qFT;
    }

    public void setFromScene(C44222az c44222az) {
        this.qFT = c44222az;
    }

    public void setIsAd(boolean z) {
        this.qFG = z;
    }

    public void setOnDeleteAllAction(Runnable runnable) {
        this.rsB = runnable;
    }

    public void setItems(List<C34937b> list) {
        this.items = list;
    }

    public float getWidthModHeight() {
        return this.rsz;
    }

    public void setOnPageSelectListener(C3981c c3981c) {
        this.rsM = c3981c;
    }

    public SnsInfoFlip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38984);
        init(context);
        AppMethodBeat.m2505o(38984);
    }

    public SnsInfoFlip(Context context) {
        super(context);
        AppMethodBeat.m2504i(38985);
        init(context);
        AppMethodBeat.m2505o(38985);
    }

    public void setIsFromMainTimeline(boolean z) {
        this.rps = z;
    }

    public void setIsSoonEnterPhotoEditUI(boolean z) {
        this.rpu = z;
    }

    public final boolean crK() {
        return this.rps;
    }

    private void init(final Context context) {
        AppMethodBeat.m2504i(38986);
        this.rsG = System.currentTimeMillis();
        this.context = context;
        View inflate = SnsInfoFlip.inflate(context, 2130970766, this);
        if (C46631f.dzs()) {
            inflate.findViewById(2131827782).setVisibility(0);
            this.rsn = (Gallery) inflate.findViewById(2131827782);
        } else {
            inflate.findViewById(2131827781).setVisibility(0);
            this.rsn = (Gallery) inflate.findViewById(2131827781);
        }
        if (this.rsn instanceof MMGestureGallery) {
            this.rsn.setSpacing(50);
            ((MMGestureGallery) this.rsn).setSingleClickOverListener(new C30745f() {

                /* renamed from: com.tencent.mm.plugin.sns.ui.SnsInfoFlip$1$1 */
                class C39791 implements Runnable {
                    C39791() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(38966);
                        if (SnsInfoFlip.this.ris != null && SnsInfoFlip.this.rsv) {
                            SnsInfoFlip.this.ris.crM();
                        }
                        AppMethodBeat.m2505o(38966);
                    }
                }

                public final void bcX() {
                    AppMethodBeat.m2504i(38967);
                    if (context instanceof SnsBrowseUI) {
                        ((SnsBrowseUI) context).bcW();
                        AppMethodBeat.m2505o(38967);
                    } else if (SnsInfoFlip.this.rsu) {
                        ((MMActivity) context).finish();
                        AppMethodBeat.m2505o(38967);
                    } else {
                        SnsInfoFlip.this.handler.post(new C39791());
                        AppMethodBeat.m2505o(38967);
                    }
                }
            });
            ((MMGestureGallery) this.rsn).setScrollLeftRightListener(new C39772());
        }
        this.rsA = (MMPageControlView) findViewById(2131827783);
        this.rsA.setIndicatorLayoutRes(2130970833);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rsA.getLayoutParams();
        layoutParams.bottomMargin += C5230ak.m7988fr(getContext());
        this.rsA.setLayoutParams(layoutParams);
        this.rsI = new HashMap();
        AppMethodBeat.m2505o(38986);
    }

    public void setOreitaion(boolean z) {
    }

    public void setShowPageControl(boolean z) {
        this.rss = z;
    }

    public void setDoubleClick(boolean z) {
        this.rst = z;
    }

    public void setShowTitle(boolean z) {
        this.rsv = z;
    }

    public void setTouchFinish(boolean z) {
        this.rsu = z;
    }

    public void setShowLongClickMenu(boolean z) {
        this.rso = z;
    }

    public void setInfoType(int i) {
        this.infoType = i;
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.rsw = z;
    }

    public C34937b getSelectItem() {
        AppMethodBeat.m2504i(38987);
        if (this.rsn == null) {
            AppMethodBeat.m2505o(38987);
            return null;
        }
        C34937b c34937b = (C34937b) this.rsn.getSelectedItem();
        AppMethodBeat.m2505o(38987);
        return c34937b;
    }

    public String getSelectedMediaId() {
        AppMethodBeat.m2504i(38988);
        if (this.rsn == null) {
            AppMethodBeat.m2505o(38988);
            return null;
        }
        C34937b c34937b = (C34937b) this.rsn.getSelectedItem();
        if (c34937b == null) {
            AppMethodBeat.m2505o(38988);
            return null;
        }
        String str = c34937b.cNr.f17915Id;
        AppMethodBeat.m2505o(38988);
        return str;
    }

    public String getSelectId() {
        AppMethodBeat.m2504i(38989);
        String str;
        if (this.rsn == null) {
            str = "";
            AppMethodBeat.m2505o(38989);
            return str;
        }
        C34937b c34937b = (C34937b) this.rsn.getSelectedItem();
        if (c34937b == null) {
            str = "";
            AppMethodBeat.m2505o(38989);
            return str;
        }
        str = c34937b.qQd;
        AppMethodBeat.m2505o(38989);
        return str;
    }

    /* renamed from: b */
    private static int m6353b(String str, TimeLineObject timeLineObject) {
        AppMethodBeat.m2504i(38990);
        Iterator it = timeLineObject.xfI.wbK.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (str.equals(((bau) it.next()).f17915Id)) {
                AppMethodBeat.m2505o(38990);
                return i;
            }
        }
        AppMethodBeat.m2505o(38990);
        return 0;
    }

    /* renamed from: a */
    public final void mo8770a(List<C34937b> list, String str, int i, C43610u c43610u, C29239a c29239a) {
        AppMethodBeat.m2504i(38992);
        C13373af.cnA().mo69136a((C43559b) this);
        this.items = list;
        this.rsF = this.items.size() > 1;
        C34955aj.m57390XY(str);
        this.rir = c43610u;
        this.ris = c29239a;
        this.rsm = new C3985b(this.context);
        this.rsn.setAdapter(this.rsm);
        if (i >= 0 && i < this.items.size()) {
            this.rsn.setSelection(i);
            if (this.rsy) {
                this.rsy = false;
                bau bau = ((C34937b) this.items.get(i)).cNr;
                if (bau == null || bau.wEK == null || bau.wEK.wFy <= 0.0f) {
                    this.rsz = 1.0f;
                } else {
                    this.rsz = bau.wEK.wFx / bau.wEK.wFy;
                }
            }
        }
        this.rsn.setFadingEdgeLength(0);
        this.rsn.setOnItemSelectedListener(new C39804());
        if (this.rso) {
            this.rsn.setOnItemLongClickListener(new C39825());
        }
        if (this.rss && this.rsm.getCount() > 1) {
            this.rsA.setVisibility(0);
            this.rsA.mo69952hj(this.rsm.getCount(), i);
        }
        if (this.rpu && !C5046bo.isNullOrNil(((C34937b) this.rsm.getItem(i)).qQd)) {
            mo76139Zs(C3892an.m6198fZ(C13373af.getAccSnsPath(), ((C34937b) this.rsm.getItem(i)).cNr.f17915Id) + C29036i.m46121l(((C34937b) this.rsm.getItem(i)).cNr));
        }
        AppMethodBeat.m2505o(38992);
    }

    public long getSnsId() {
        AppMethodBeat.m2504i(38993);
        C34937b c34937b = (C34937b) this.rsn.getSelectedItem();
        String str = c34937b == null ? "" : c34937b.qQd;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(38993);
            return 0;
        }
        C46236n YT = C13373af.cnF().mo62918YT(str);
        if (YT == null) {
            AppMethodBeat.m2505o(38993);
            return 0;
        }
        long j = YT.field_snsId;
        AppMethodBeat.m2505o(38993);
        return j;
    }

    public int getPosition() {
        return this.rsE;
    }

    private void ctl() {
        AppMethodBeat.m2504i(38994);
        if (this.rsn.getSelectedItem() == null || this.rsm == null) {
            AppMethodBeat.m2505o(38994);
            return;
        }
        int selectedItemPosition = this.rsn.getSelectedItemPosition();
        if (this.rss && this.rsm.getCount() > 1) {
            this.rsA.setVisibility(0);
            this.rsA.setPage(selectedItemPosition);
        }
        bau bau = ((C34937b) this.rsn.getSelectedItem()).cNr;
        this.rsP.add(bau.f17915Id);
        String str = ((C34937b) this.rsn.getSelectedItem()).qQd;
        String str2 = bau.f17915Id;
        if (C5046bo.isNullOrNil(this.rsC) || !this.rsC.equals(str2)) {
            this.rsC = "";
        }
        m6351a(bau, selectedItemPosition, str);
        AppMethodBeat.m2505o(38994);
    }

    public final void btt() {
        AppMethodBeat.m2504i(38995);
        if (this.rsm != null) {
            C4990ab.m7410d("MicroMsg.SnsInfoFlip", "onRefresh ");
            this.rsm.notifyDataSetChanged();
            ctl();
        }
        AppMethodBeat.m2505o(38995);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(38996);
        super.onPause();
        if (this.rsm != null) {
            this.rsm.cts();
            this.rsm.clear();
        }
        AppMethodBeat.m2505o(38996);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(38997);
        this.rsL = true;
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(38997);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(38998);
        this.rsL = false;
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(38998);
    }

    public Gallery getGallery() {
        return this.rsn;
    }

    public final void ctm() {
        AppMethodBeat.m2504i(38999);
        C4990ab.m7416i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
        if (this.rsm != null) {
            this.rsm.cts();
            this.rsm.clear();
        }
        C13373af.cnA().mo69142b((C43559b) this);
        AppMethodBeat.m2505o(38999);
    }

    public final int ctn() {
        AppMethodBeat.m2504i(39000);
        if (this.rsn == null) {
            AppMethodBeat.m2505o(39000);
            return -1;
        }
        this.items.remove(this.rsn.getSelectedItemPosition());
        this.rsm.notifyDataSetChanged();
        ctl();
        int count = this.rsm.getCount();
        AppMethodBeat.m2505o(39000);
        return count;
    }

    public int getCount() {
        AppMethodBeat.m2504i(39001);
        if (this.rsm != null) {
            int count = this.rsm.getCount();
            AppMethodBeat.m2505o(39001);
            return count;
        }
        AppMethodBeat.m2505o(39001);
        return 0;
    }

    public bau getCntMedia() {
        AppMethodBeat.m2504i(39002);
        if (this.rsm != null) {
            int selectedItemPosition = this.rsn.getSelectedItemPosition();
            if (this.items != null && selectedItemPosition < this.items.size()) {
                bau bau = ((C34937b) this.items.get(selectedItemPosition)).cNr;
                AppMethodBeat.m2505o(39002);
                return bau;
            }
        }
        AppMethodBeat.m2505o(39002);
        return null;
    }

    public int getSelectCount() {
        AppMethodBeat.m2504i(39003);
        int size = this.rsP.size();
        AppMethodBeat.m2505o(39003);
        return size;
    }

    public int gettotalSuccDownload() {
        return this.rsR;
    }

    public int getNumOfFileExist() {
        AppMethodBeat.m2504i(39004);
        int i = 0;
        int i2 = 0;
        for (C34937b c34937b : this.items) {
            C13373af.cnC();
            if (C5730e.m8628ct(C21925g.m33507C(c34937b.cNr))) {
                i2++;
            }
            int i3 = i + 1;
            if (i3 > 9) {
                break;
            }
            i = i3;
        }
        AppMethodBeat.m2505o(39004);
        return i2;
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
        bau bau;
        AppMethodBeat.m2504i(39005);
        if (!(z || this.rsn.getSelectedItem() == null)) {
            bau = ((C34937b) this.rsn.getSelectedItem()).cNr;
            if (!(bau == null || bau.f17915Id == null || !bau.f17915Id.equals(str))) {
                Toast.makeText(this.context, this.context.getString(C25738R.string.ek_), 0).show();
                this.rsC = str;
            }
        }
        this.rsR++;
        if (this.rps) {
            C4990ab.m7411d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", str, Boolean.valueOf(z));
            if (z && this.rsS.containsKey(str)) {
                C3983a c3983a = (C3983a) this.rsS.get(str);
                c3983a.rsY = System.currentTimeMillis();
                c3983a.networkType = getReportNetworkType();
                C4990ab.m7410d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
                this.rsI.put(str, Boolean.TRUE);
            }
        }
        if (!(this.rsm == null || this.rsn.getSelectedItem() == null)) {
            bau = ((C34937b) this.rsn.getSelectedItem()).cNr;
            if (!(bau == null || bau.f17915Id == null || !bau.f17915Id.equals(str))) {
                this.rsm.notifyDataSetChanged();
                if (this.rpu) {
                    if (bau == null) {
                        AppMethodBeat.m2505o(39005);
                        return;
                    }
                    String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
                    String l = C29036i.m46121l(bau);
                    if (C5730e.m8628ct(fZ + l)) {
                        l = fZ + l;
                        Intent intent = new Intent();
                        C4990ab.m7417i("MicroMsg.FlipView", "edit image path:%s", l);
                        intent.putExtra("raw_photo_path", l);
                        intent.putExtra("from_scene", 293);
                        intent.putExtra("after_photo_edit", "");
                        intent.putExtra("Retr_Compress_Type", 0);
                        intent.putExtra("Retr_Msg_Type", 0);
                        intent.putExtra("Retr_FromMainTimeline", crK());
                        intent.setClass(this.context, MMNewPhotoEditUI.class);
                        this.context.startActivity(intent);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(39005);
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
        AppMethodBeat.m2504i(39006);
        C4990ab.m7416i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z);
        if (!z) {
            bau bau = ((C34937b) this.rsn.getSelectedItem()).cNr;
            if (!(bau == null || bau.f17915Id == null || !bau.f17915Id.equals(str))) {
                Toast.makeText(this.context, this.context.getString(C25738R.string.eka), 0).show();
                this.rsC = str;
            }
        }
        if (this.rsm != null) {
            this.rsm.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(39006);
    }

    public List<C34937b> getFlipList() {
        return this.items;
    }

    private int getReportNetworkType() {
        AppMethodBeat.m2504i(39007);
        Context context = C4996ah.getContext();
        if (C5023at.is2G(context)) {
            AppMethodBeat.m2505o(39007);
            return 1;
        } else if (C5023at.is3G(context)) {
            AppMethodBeat.m2505o(39007);
            return 2;
        } else if (C5023at.is4G(context)) {
            AppMethodBeat.m2505o(39007);
            return 3;
        } else if (C5023at.isWifi(context)) {
            AppMethodBeat.m2505o(39007);
            return 4;
        } else {
            AppMethodBeat.m2505o(39007);
            return 0;
        }
    }

    public final void cto() {
        AppMethodBeat.m2504i(39008);
        for (C3983a c3983a : this.rsS.values()) {
            if (c3983a.rsW != -1) {
                C7060h.pYm.mo8381e(11601, Integer.valueOf(c3983a.fjN), Integer.valueOf(c3983a.rsW), Long.valueOf(c3983a.qNk), Integer.valueOf(c3983a.networkType));
                C4990ab.m7411d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(c3983a.fjN), Integer.valueOf(c3983a.rsW), Long.valueOf(c3983a.qNk), Integer.valueOf(c3983a.networkType));
            } else if (c3983a.rsX != -1) {
                if (c3983a.rsY != -1) {
                    c3983a.rsW = 1;
                } else {
                    c3983a.rsW = 2;
                    c3983a.rsY = System.currentTimeMillis();
                }
                c3983a.qNk = c3983a.rsY - c3983a.rsX;
                C7060h.pYm.mo8381e(11601, Integer.valueOf(c3983a.fjN), Integer.valueOf(c3983a.rsW), Long.valueOf(c3983a.qNk), Integer.valueOf(c3983a.networkType));
                C4990ab.m7411d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(c3983a.fjN), Integer.valueOf(c3983a.rsW), Long.valueOf(c3983a.qNk), Integer.valueOf(c3983a.networkType));
            }
        }
        this.rsS.clear();
        AppMethodBeat.m2505o(39008);
    }

    /* renamed from: a */
    private void m6351a(bau bau, int i, String str) {
        String str2;
        long j = 0;
        AppMethodBeat.m2504i(38991);
        if (this.rsn != null && (this.rsn instanceof MMGestureGallery)) {
            float f;
            float f2;
            if (bau.wEK != null) {
                f = bau.wEK.wFy;
                f2 = bau.wEK.wFx;
            } else {
                f2 = 0.0f;
                f = 0.0f;
            }
            float f3;
            if (f <= 0.0f || f2 <= 0.0f) {
                if (bau.f17915Id.startsWith("Locall_path")) {
                    str2 = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46122m(bau);
                } else {
                    str2 = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46105d(bau);
                }
                Options amj = C5056d.amj(str2);
                if (amj != null) {
                    f = (float) amj.outHeight;
                    f3 = (float) amj.outWidth;
                }
            } else {
                f3 = f2;
            }
            if (f > 0.0f && f3 > 0.0f) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) this.rsn;
                if (!this.rsw || ((double) f3) * 1.0d <= ((double) f) * 2.0d) {
                    C4990ab.m7410d("MicroMsg.SnsInfoFlip", "set on fling false");
                    mMGestureGallery.yyh = false;
                } else {
                    C4990ab.m7410d("MicroMsg.SnsInfoFlip", "set on fling true");
                    mMGestureGallery.yyh = true;
                }
            }
        }
        if (this.rsM != null) {
            this.rsM.mo8815Eb(i);
        }
        C46236n YT = C13373af.cnF().mo62918YT(str);
        if (YT != null) {
            C29169a.m46339c(YT, i);
        }
        if (this.rsD == -1) {
            this.rsD = i;
        }
        this.rsE = 1;
        String str3 = bau.f17915Id;
        if (C5046bo.isNullOrNil(str)) {
            this.ris.mo47407gt((i + 1) + " / " + this.rsm.getCount(), null);
            AppMethodBeat.m2505o(38991);
            return;
        }
        YT = (C46236n) this.rsN.get(str);
        if (YT == null) {
            YT = C13373af.cnF().mo62918YT(str);
            this.rsN.put(str, YT);
        }
        C46236n c46236n = YT;
        if (c46236n == null) {
            AppMethodBeat.m2505o(38991);
            return;
        }
        if (bau.jCt != 2 && (this.rsn instanceof MMGestureGallery)) {
            ((MMGestureGallery) this.rsn).setLoadQuit(true);
        }
        if (bau.jCt != 6) {
            C13373af.bCo().post(new C39763());
        }
        C4990ab.m7410d("MicroMsg.SnsInfoFlip", "onItemSelected  " + i + " localId " + str);
        if (this.rsO != i) {
            this.rsp.put(Integer.valueOf(i), Integer.valueOf((this.rsp.containsKey(Integer.valueOf(i)) ? ((Integer) this.rsp.get(Integer.valueOf(i))).intValue() : 0) + 1));
            this.rsq.put(Integer.valueOf(i), Long.valueOf(C5046bo.m7588yz()));
            if (this.rsO >= 0) {
                long longValue;
                if (this.rsq.containsKey(Integer.valueOf(this.rsO))) {
                    longValue = ((Long) this.rsq.get(Integer.valueOf(this.rsO))).longValue();
                } else {
                    longValue = 0;
                }
                if (longValue > 0) {
                    this.rsq.put(Integer.valueOf(this.rsO), Long.valueOf(0));
                    if (this.rsr.containsKey(Integer.valueOf(this.rsO))) {
                        j = ((Long) this.rsr.get(Integer.valueOf(this.rsO))).longValue();
                    }
                    longValue = C5046bo.m7525az(longValue);
                    j += longValue;
                    this.rsr.put(Integer.valueOf(this.rsO), Long.valueOf(j));
                    C4990ab.m7416i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.rsO + " curtime " + j + " passtime " + (((double) longValue) / 1000.0d));
                }
            }
            if (this.rps && this.rsm != null) {
                C34937b c34937b = (C34937b) this.rsm.getItem(this.rsO);
                if (c34937b != null) {
                    str2 = c34937b.cNr.f17915Id;
                    C4990ab.m7411d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", str2);
                    if (this.rsS.containsKey(str2)) {
                        C3983a c3983a = (C3983a) this.rsS.get(str2);
                        c3983a.networkType = getReportNetworkType();
                        if (c3983a.rsY != -1) {
                            c3983a.rsW = 1;
                            c3983a.qNk = c3983a.rsY - c3983a.rsX;
                            C4990ab.m7411d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", Long.valueOf(c3983a.qNk));
                        } else {
                            c3983a.rsW = 2;
                            c3983a.rsY = System.currentTimeMillis();
                            c3983a.qNk = c3983a.rsY - c3983a.rsX;
                            C4990ab.m7411d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", Long.valueOf(c3983a.qNk));
                        }
                    }
                }
            }
        }
        this.rsO = i;
        if (this.rir != null) {
            this.rir.mo37695Zv(str);
        }
        int i2 = c46236n.field_createTime;
        TimeLineObject cqu = c46236n.cqu();
        String m = C29198aw.m46377m(this.context, ((long) i2) * 1000);
        str2 = null;
        if (!(cqu == null || cqu.xfI == null || cqu.xfI.wbK.size() <= 1)) {
            str2 = (((C34937b) this.items.get(i)).qQe + 1) + " / " + cqu.xfI.wbK.size();
            this.rsE = SnsInfoFlip.m6353b(str3, cqu);
        }
        this.ris.mo47407gt(String.valueOf(m), str2);
        this.ris.mo8728dh(str, i);
        if (this.rsm != null) {
            this.rsm.mo8819Ea(i);
        }
        AppMethodBeat.m2505o(38991);
    }

    /* renamed from: a */
    static /* synthetic */ void m6350a(SnsInfoFlip snsInfoFlip, String str) {
        AppMethodBeat.m2504i(39010);
        C4990ab.m7411d("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", str);
        if (!snsInfoFlip.rsS.containsKey(str)) {
            C3983a c3983a = new C3983a();
            c3983a.fjN = snsInfoFlip.getCount();
            c3983a.networkType = snsInfoFlip.getReportNetworkType();
            c3983a.rsX = System.currentTimeMillis();
            c3983a.rsZ = str;
            snsInfoFlip.rsS.put(str, c3983a);
            C4990ab.m7410d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
        AppMethodBeat.m2505o(39010);
    }
}
