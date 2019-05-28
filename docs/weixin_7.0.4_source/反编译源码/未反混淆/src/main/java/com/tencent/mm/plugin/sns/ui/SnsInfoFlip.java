package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.re;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip extends FlipView {
    private static int fgI = 0;
    private static int fgJ = 0;
    private Context context;
    private ak handler = new ak();
    List<com.tencent.mm.plugin.sns.h.b> items;
    boolean qFG = false;
    private az qFT = az.xYU;
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
    private c rsM;
    private HashMap<String, n> rsN = new HashMap();
    int rsO = -1;
    private HashSet<String> rsP = new HashSet();
    public int rsQ = 0;
    public int rsR = 0;
    private HashMap<String, a> rsS = new HashMap();
    private com.tencent.mm.ui.base.MultiTouchImageView.a rsT = new com.tencent.mm.ui.base.MultiTouchImageView.a() {
        public final void ctq() {
            AppMethodBeat.i(38972);
            if (SnsInfoFlip.this.rsn.getSelectedItem() == null || SnsInfoFlip.this.rsm == null) {
                AppMethodBeat.o(38972);
                return;
            }
            int selectedItemPosition = SnsInfoFlip.this.rsn.getSelectedItemPosition();
            n YT = af.cnF().YT(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.rsn.getSelectedItem()).qQd);
            if (YT != null) {
                com.tencent.mm.plugin.sns.ui.a.a.d(YT, selectedItemPosition);
            }
            AppMethodBeat.o(38972);
        }

        public final void ctr() {
            AppMethodBeat.i(38973);
            if (SnsInfoFlip.this.rsn.getSelectedItem() == null || SnsInfoFlip.this.rsm == null) {
                AppMethodBeat.o(38973);
                return;
            }
            int selectedItemPosition = SnsInfoFlip.this.rsn.getSelectedItemPosition();
            n YT = af.cnF().YT(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.rsn.getSelectedItem()).qQd);
            if (YT != null) {
                com.tencent.mm.plugin.sns.ui.a.a.e(YT, selectedItemPosition);
            }
            AppMethodBeat.o(38973);
        }
    };
    b rsm;
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

    public interface c {
        void Eb(int i);
    }

    class a {
        int fjN;
        int networkType;
        long qNk = -1;
        int rsW = -1;
        long rsX = -1;
        long rsY = -1;
        String rsZ;

        a() {
        }
    }

    class b extends BaseAdapter {
        private Context context;
        private String fns = "";
        private boolean kNs = true;
        private int rgh = 0;
        private boolean rta = false;
        Map<String, WeakReference<View>> rtb = new HashMap();
        private String rtc;

        public b(Context context) {
            AppMethodBeat.i(38974);
            this.context = context;
            this.rta = f.dzs();
            this.rgh = SnsInfoFlip.this.items.size();
            com.tencent.mm.modelcontrol.c.afC();
            this.kNs = com.tencent.mm.modelcontrol.c.afE();
            AppMethodBeat.o(38974);
        }

        public final int getCount() {
            AppMethodBeat.i(38975);
            if (SnsInfoFlip.this.items == null) {
                AppMethodBeat.o(38975);
                return 0;
            }
            int size = SnsInfoFlip.this.items.size();
            AppMethodBeat.o(38975);
            return size;
        }

        private void DZ(int i) {
            AppMethodBeat.i(38976);
            bau bau = ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).cNr;
            az a = az.a(SnsInfoFlip.this.qFT, ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).fDG);
            if (bau.jCt != 2) {
                AppMethodBeat.o(38976);
                return;
            }
            boolean Zl = v.Zl(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd);
            af.cnC();
            Zl = g.a(bau, a, Zl);
            if (SnsInfoFlip.this.rps && !Zl) {
                SnsInfoFlip.a(SnsInfoFlip.this, bau.Id);
            }
            AppMethodBeat.o(38976);
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(38977);
            if (((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).cNr.jCt == 6) {
                AppMethodBeat.o(38977);
                return 0;
            }
            AppMethodBeat.o(38977);
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
            AppMethodBeat.i(38978);
            if (((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).cNr.jCt == 6) {
                String str = "MicroMsg.SnsInfoFlip";
                String str2 = "fill view online sight %d convert view is null %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(view == null);
                ab.d(str, str2, objArr);
                com.tencent.mm.plugin.sns.h.b bVar = (com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i);
                if (bVar == null) {
                    ab.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
                    AppMethodBeat.o(38978);
                    return view;
                }
                str2 = bVar.qQd;
                if (bo.isNullOrNil(str2)) {
                    ab.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
                    AppMethodBeat.o(38978);
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
                if (bo.isEqual(str2, this.rtc)) {
                    Ea(i);
                }
                ab.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", Integer.valueOf(onlineVideoView.hashCode()), bVar.qQd);
                AppMethodBeat.o(38978);
                return onlineVideoView;
            }
            d dVar;
            Object obj;
            bau bau;
            Bitmap a;
            LayoutParams layoutParams;
            bau bau2 = ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).cNr;
            ab.d("MicroMsg.SnsInfoFlip", "gallery position " + i + " " + this.rgh + " " + bau2.Id);
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, R.layout.av_, null);
                dVar2.rtd = view.findViewById(R.id.ej4);
                dVar2.rte = (ProgressBar) view.findViewById(R.id.rj);
                dVar2.nHi = (TextView) view.findViewById(R.id.ej6);
                dVar2.rtf = (FrameLayout) view.findViewById(R.id.ej5);
                dVar2.cDh = (ImageView) view.findViewById(R.id.bl);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.position = i;
            az a2 = az.a(SnsInfoFlip.this.qFT, ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).fDG);
            view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            dVar.rte.setVisibility(8);
            dVar.nHi.setVisibility(8);
            dVar.rtf.setVisibility(0);
            if (bo.isNullOrNil(SnsInfoFlip.this.rsC) || !SnsInfoFlip.this.rsC.equals(bau2.Id)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (bau2.Id.startsWith("Locall_path") && !bo.isNullOrNil(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd)) {
                n nVar = (n) SnsInfoFlip.this.rsN.get(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd);
                if (nVar == null) {
                    n YT = af.cnF().YT(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd);
                    SnsInfoFlip.this.rsN.put(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd, YT);
                    nVar = YT;
                }
                TimeLineObject cqu = nVar.cqu();
                if (cqu.xfI.wbK.size() > ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQe) {
                    bau = (bau) cqu.xfI.wbK.get(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQe);
                    a = af.cnC().a(bau, dVar.cDh, this.context.hashCode(), obj != null, a2, v.Zl(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd));
                    if (a == null && SnsInfoFlip.this.rps) {
                        SnsInfoFlip.a(SnsInfoFlip.this, bau.Id);
                    }
                    layoutParams = dVar.cDh.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    dVar.cDh.setLayoutParams(layoutParams);
                    if (a != null && bau.Id != null && !bau.Id.startsWith("pre_temp_extend_pic")) {
                        LayoutParams layoutParams2 = dVar.cDh.getLayoutParams();
                        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 160.0f);
                        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 200.0f);
                        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 44.0f);
                        com.tencent.mm.memory.n XK = af.cnC().XK(i.bc(1, bau.Id));
                        if (!i.b(XK)) {
                            XK = null;
                        }
                        if (XK != null) {
                            double width = (double) XK.bitmap.getWidth();
                            double height = (double) XK.bitmap.getHeight();
                            if (width > 0.0d && height > 0.0d) {
                                Math.min(((double) b) / width, ((double) b) / height);
                            }
                        }
                        dVar.cDh.setLayoutParams(layoutParams);
                        dVar.rte.setVisibility(0);
                        dVar.cDh.setVisibility(0);
                        af.cnC().dz(dVar.cDh);
                        af.cnC().b(bau, dVar.cDh, (int) R.drawable.abd, this.context.hashCode(), a2);
                        SnsInfoFlip.fgJ = layoutParams2.width;
                        SnsInfoFlip.fgI = layoutParams2.height;
                        if (obj != null) {
                            dVar.rte.setVisibility(8);
                        }
                    } else if (this.rta) {
                        dVar.rte.setVisibility(8);
                        af.cnC().a(bau, dVar.cDh, this.context.hashCode(), a2, v.Zl(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd));
                        dVar.cDh.setImageBitmap(a);
                        dVar.cDh.setVisibility(0);
                    } else {
                        dVar.rte.setVisibility(8);
                        if (a != null) {
                            if (!SnsInfoFlip.this.rsL) {
                                ab.i("MicroMsg.SnsInfoFlip", "update view ");
                                View multiTouchImageView = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.this.rsT);
                                multiTouchImageView.setEnableHorLongBmpMode(SnsInfoFlip.this.rsw);
                                multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                                af.cnC().a(bau, multiTouchImageView, this.context.hashCode(), a2, v.Zl(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd));
                                multiTouchImageView.setImageBitmap(a);
                                ab.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", bau.Id, SnsInfoFlip.this.rsI.get(bau.Id), Integer.valueOf(multiTouchImageView.getId()));
                                AppMethodBeat.o(38978);
                                return multiTouchImageView;
                            }
                            AppMethodBeat.o(38978);
                            return view;
                        }
                    }
                    if (this.kNs && com.tencent.mm.network.ab.ch(this.context)) {
                        if (i - 1 >= 0) {
                            DZ(i - 1);
                        }
                        if (i + 1 < SnsInfoFlip.this.rsm.getCount()) {
                            DZ(i + 1);
                        }
                    }
                    AppMethodBeat.o(38978);
                    return view;
                }
            }
            bau = bau2;
            if (obj != null) {
            }
            a = af.cnC().a(bau, dVar.cDh, this.context.hashCode(), obj != null, a2, v.Zl(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i)).qQd));
            SnsInfoFlip.a(SnsInfoFlip.this, bau.Id);
            layoutParams = dVar.cDh.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            dVar.cDh.setLayoutParams(layoutParams);
            if (a != null) {
            }
            if (this.rta) {
            }
            if (i - 1 >= 0) {
            }
            if (i + 1 < SnsInfoFlip.this.rsm.getCount()) {
            }
            AppMethodBeat.o(38978);
            return view;
        }

        public final void clear() {
            AppMethodBeat.i(38979);
            ab.i("MicroMsg.SnsInfoFlip", "adapter clear.");
            this.rtb.clear();
            AppMethodBeat.o(38979);
        }

        public final void Ea(int i) {
            AppMethodBeat.i(38980);
            com.tencent.mm.plugin.sns.h.b bVar = (com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.items.get(i);
            if (bVar == null) {
                ab.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
                AppMethodBeat.o(38980);
                return;
            }
            String str = bVar.qQd;
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
                AppMethodBeat.o(38980);
                return;
            }
            ab.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", Integer.valueOf(i), str);
            WeakReference weakReference = (WeakReference) this.rtb.get(str);
            if (weakReference == null) {
                ab.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
                this.rtc = str;
                AppMethodBeat.o(38980);
                return;
            }
            OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
            if (onlineVideoView == null) {
                ab.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", str);
                this.rtc = str;
                AppMethodBeat.o(38980);
                return;
            }
            ab.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", Integer.valueOf(onlineVideoView.hashCode()), str);
            this.rtc = null;
            onlineVideoView.csb();
            onlineVideoView.a(bVar.cNr, bVar.qQd, bVar.fDG);
            re reVar = new re();
            reVar.cNj.cAd = 1;
            reVar.cNj.czD = str;
            com.tencent.mm.sdk.b.a.xxA.m(reVar);
            AppMethodBeat.o(38980);
        }

        public final void cts() {
            AppMethodBeat.i(38981);
            ab.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", bo.dpG());
            re reVar = new re();
            reVar.cNj.context = this.context;
            reVar.cNj.czD = this.rtc;
            reVar.cNj.cAd = 2;
            com.tencent.mm.sdk.b.a.xxA.m(reVar);
            this.rtc = null;
            AppMethodBeat.o(38981);
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(38982);
            if (i >= SnsInfoFlip.this.items.size() || i < 0) {
                AppMethodBeat.o(38982);
                return null;
            }
            Object obj = SnsInfoFlip.this.items.get(i);
            AppMethodBeat.o(38982);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(38983);
            this.rgh = SnsInfoFlip.this.items.size();
            ab.d("MicroMsg.SnsInfoFlip", "items.size:" + SnsInfoFlip.this.items.size());
            SnsInfoFlip.this.invalidate();
            SnsInfoFlip.this.requestLayout();
            super.notifyDataSetChanged();
            if (SnsInfoFlip.this.items.size() <= 0 && SnsInfoFlip.this.rsB != null) {
                SnsInfoFlip.this.rsB.run();
            }
            AppMethodBeat.o(38983);
        }
    }

    static class d {
        ImageView cDh;
        TextView nHi;
        int position;
        View rtd;
        ProgressBar rte;
        FrameLayout rtf;
        String videoPath = "";

        d() {
        }
    }

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, bau bau, int i, String str) {
        AppMethodBeat.i(39009);
        snsInfoFlip.a(bau, i, str);
        AppMethodBeat.o(39009);
    }

    public az getFromScene() {
        return this.qFT;
    }

    public void setFromScene(az azVar) {
        this.qFT = azVar;
    }

    public void setIsAd(boolean z) {
        this.qFG = z;
    }

    public void setOnDeleteAllAction(Runnable runnable) {
        this.rsB = runnable;
    }

    public void setItems(List<com.tencent.mm.plugin.sns.h.b> list) {
        this.items = list;
    }

    public float getWidthModHeight() {
        return this.rsz;
    }

    public void setOnPageSelectListener(c cVar) {
        this.rsM = cVar;
    }

    public SnsInfoFlip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38984);
        init(context);
        AppMethodBeat.o(38984);
    }

    public SnsInfoFlip(Context context) {
        super(context);
        AppMethodBeat.i(38985);
        init(context);
        AppMethodBeat.o(38985);
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
        AppMethodBeat.i(38986);
        this.rsG = System.currentTimeMillis();
        this.context = context;
        View inflate = inflate(context, R.layout.avd, this);
        if (f.dzs()) {
            inflate.findViewById(R.id.ejn).setVisibility(0);
            this.rsn = (Gallery) inflate.findViewById(R.id.ejn);
        } else {
            inflate.findViewById(R.id.ejm).setVisibility(0);
            this.rsn = (Gallery) inflate.findViewById(R.id.ejm);
        }
        if (this.rsn instanceof MMGestureGallery) {
            this.rsn.setSpacing(50);
            ((MMGestureGallery) this.rsn).setSingleClickOverListener(new MMGestureGallery.f() {
                public final void bcX() {
                    AppMethodBeat.i(38967);
                    if (context instanceof SnsBrowseUI) {
                        ((SnsBrowseUI) context).bcW();
                        AppMethodBeat.o(38967);
                    } else if (SnsInfoFlip.this.rsu) {
                        ((MMActivity) context).finish();
                        AppMethodBeat.o(38967);
                    } else {
                        SnsInfoFlip.this.handler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(38966);
                                if (SnsInfoFlip.this.ris != null && SnsInfoFlip.this.rsv) {
                                    SnsInfoFlip.this.ris.crM();
                                }
                                AppMethodBeat.o(38966);
                            }
                        });
                        AppMethodBeat.o(38967);
                    }
                }
            });
            ((MMGestureGallery) this.rsn).setScrollLeftRightListener(new e() {
                public final void ctp() {
                    AppMethodBeat.i(38968);
                    if (SnsInfoFlip.this.ris != null) {
                        SnsInfoFlip.this.ris.crN();
                    }
                    AppMethodBeat.o(38968);
                }
            });
        }
        this.rsA = (MMPageControlView) findViewById(R.id.ejo);
        this.rsA.setIndicatorLayoutRes(R.layout.ax7);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rsA.getLayoutParams();
        layoutParams.bottomMargin += com.tencent.mm.ui.ak.fr(getContext());
        this.rsA.setLayoutParams(layoutParams);
        this.rsI = new HashMap();
        AppMethodBeat.o(38986);
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

    public com.tencent.mm.plugin.sns.h.b getSelectItem() {
        AppMethodBeat.i(38987);
        if (this.rsn == null) {
            AppMethodBeat.o(38987);
            return null;
        }
        com.tencent.mm.plugin.sns.h.b bVar = (com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem();
        AppMethodBeat.o(38987);
        return bVar;
    }

    public String getSelectedMediaId() {
        AppMethodBeat.i(38988);
        if (this.rsn == null) {
            AppMethodBeat.o(38988);
            return null;
        }
        com.tencent.mm.plugin.sns.h.b bVar = (com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem();
        if (bVar == null) {
            AppMethodBeat.o(38988);
            return null;
        }
        String str = bVar.cNr.Id;
        AppMethodBeat.o(38988);
        return str;
    }

    public String getSelectId() {
        AppMethodBeat.i(38989);
        String str;
        if (this.rsn == null) {
            str = "";
            AppMethodBeat.o(38989);
            return str;
        }
        com.tencent.mm.plugin.sns.h.b bVar = (com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem();
        if (bVar == null) {
            str = "";
            AppMethodBeat.o(38989);
            return str;
        }
        str = bVar.qQd;
        AppMethodBeat.o(38989);
        return str;
    }

    private static int b(String str, TimeLineObject timeLineObject) {
        AppMethodBeat.i(38990);
        Iterator it = timeLineObject.xfI.wbK.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (str.equals(((bau) it.next()).Id)) {
                AppMethodBeat.o(38990);
                return i;
            }
        }
        AppMethodBeat.o(38990);
        return 0;
    }

    public final void a(List<com.tencent.mm.plugin.sns.h.b> list, String str, int i, u uVar, com.tencent.mm.plugin.sns.ui.s.a aVar) {
        AppMethodBeat.i(38992);
        af.cnA().a((com.tencent.mm.plugin.sns.model.b.b) this);
        this.items = list;
        this.rsF = this.items.size() > 1;
        aj.XY(str);
        this.rir = uVar;
        this.ris = aVar;
        this.rsm = new b(this.context);
        this.rsn.setAdapter(this.rsm);
        if (i >= 0 && i < this.items.size()) {
            this.rsn.setSelection(i);
            if (this.rsy) {
                this.rsy = false;
                bau bau = ((com.tencent.mm.plugin.sns.h.b) this.items.get(i)).cNr;
                if (bau == null || bau.wEK == null || bau.wEK.wFy <= 0.0f) {
                    this.rsz = 1.0f;
                } else {
                    this.rsz = bau.wEK.wFx / bau.wEK.wFy;
                }
            }
        }
        this.rsn.setFadingEdgeLength(0);
        this.rsn.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(38970);
                if (SnsInfoFlip.this.rsm != null) {
                    if (SnsInfoFlip.this.rss && SnsInfoFlip.this.rsm.getCount() > 1) {
                        SnsInfoFlip.this.rsA.setVisibility(0);
                        SnsInfoFlip.this.rsA.setPage(i);
                    }
                    SnsInfoFlip.a(SnsInfoFlip.this, ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.rsm.getItem(i)).cNr, i, ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.rsm.getItem(i)).qQd);
                    if (view instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) view).dzA();
                    }
                    if ((SnsInfoFlip.this.rsn instanceof MMGestureGallery) && (SnsInfoFlip.this.context instanceof SnsBrowseUI)) {
                        ((SnsBrowseUI) SnsInfoFlip.this.context).csT();
                    }
                }
                AppMethodBeat.o(38970);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        if (this.rso) {
            this.rsn.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(38971);
                    if (SnsInfoFlip.this.rso) {
                        if (SnsInfoFlip.this.rsn instanceof MMGestureGallery) {
                            com.tencent.mm.model.v.b y = com.tencent.mm.model.v.Zp().y("basescanui@datacenter", true);
                            y.j("key_basescanui_screen_x", Integer.valueOf(((MMGestureGallery) SnsInfoFlip.this.rsn).getXDown()));
                            y.j("key_basescanui_screen_y", Integer.valueOf(((MMGestureGallery) SnsInfoFlip.this.rsn).getYDown()));
                        }
                        String str = ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.rsm.getItem(i)).qQd;
                        if (bo.isNullOrNil(str)) {
                            AppMethodBeat.o(38971);
                            return false;
                        }
                        String str2 = ((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.rsm.getItem(i)).cNr.Id;
                        SnsInfoFlip.this.f(an.fZ(af.getAccSnsPath(), str2) + i.l(((com.tencent.mm.plugin.sns.h.b) SnsInfoFlip.this.rsm.getItem(i)).cNr), str, str2, true);
                        AppMethodBeat.o(38971);
                        return true;
                    }
                    AppMethodBeat.o(38971);
                    return true;
                }
            });
        }
        if (this.rss && this.rsm.getCount() > 1) {
            this.rsA.setVisibility(0);
            this.rsA.hj(this.rsm.getCount(), i);
        }
        if (this.rpu && !bo.isNullOrNil(((com.tencent.mm.plugin.sns.h.b) this.rsm.getItem(i)).qQd)) {
            Zs(an.fZ(af.getAccSnsPath(), ((com.tencent.mm.plugin.sns.h.b) this.rsm.getItem(i)).cNr.Id) + i.l(((com.tencent.mm.plugin.sns.h.b) this.rsm.getItem(i)).cNr));
        }
        AppMethodBeat.o(38992);
    }

    public long getSnsId() {
        AppMethodBeat.i(38993);
        com.tencent.mm.plugin.sns.h.b bVar = (com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem();
        String str = bVar == null ? "" : bVar.qQd;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(38993);
            return 0;
        }
        n YT = af.cnF().YT(str);
        if (YT == null) {
            AppMethodBeat.o(38993);
            return 0;
        }
        long j = YT.field_snsId;
        AppMethodBeat.o(38993);
        return j;
    }

    public int getPosition() {
        return this.rsE;
    }

    private void ctl() {
        AppMethodBeat.i(38994);
        if (this.rsn.getSelectedItem() == null || this.rsm == null) {
            AppMethodBeat.o(38994);
            return;
        }
        int selectedItemPosition = this.rsn.getSelectedItemPosition();
        if (this.rss && this.rsm.getCount() > 1) {
            this.rsA.setVisibility(0);
            this.rsA.setPage(selectedItemPosition);
        }
        bau bau = ((com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem()).cNr;
        this.rsP.add(bau.Id);
        String str = ((com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem()).qQd;
        String str2 = bau.Id;
        if (bo.isNullOrNil(this.rsC) || !this.rsC.equals(str2)) {
            this.rsC = "";
        }
        a(bau, selectedItemPosition, str);
        AppMethodBeat.o(38994);
    }

    public final void btt() {
        AppMethodBeat.i(38995);
        if (this.rsm != null) {
            ab.d("MicroMsg.SnsInfoFlip", "onRefresh ");
            this.rsm.notifyDataSetChanged();
            ctl();
        }
        AppMethodBeat.o(38995);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(38996);
        super.onPause();
        if (this.rsm != null) {
            this.rsm.cts();
            this.rsm.clear();
        }
        AppMethodBeat.o(38996);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(38997);
        this.rsL = true;
        super.onMeasure(i, i2);
        AppMethodBeat.o(38997);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38998);
        this.rsL = false;
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(38998);
    }

    public Gallery getGallery() {
        return this.rsn;
    }

    public final void ctm() {
        AppMethodBeat.i(38999);
        ab.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
        if (this.rsm != null) {
            this.rsm.cts();
            this.rsm.clear();
        }
        af.cnA().b((com.tencent.mm.plugin.sns.model.b.b) this);
        AppMethodBeat.o(38999);
    }

    public final int ctn() {
        AppMethodBeat.i(39000);
        if (this.rsn == null) {
            AppMethodBeat.o(39000);
            return -1;
        }
        this.items.remove(this.rsn.getSelectedItemPosition());
        this.rsm.notifyDataSetChanged();
        ctl();
        int count = this.rsm.getCount();
        AppMethodBeat.o(39000);
        return count;
    }

    public int getCount() {
        AppMethodBeat.i(39001);
        if (this.rsm != null) {
            int count = this.rsm.getCount();
            AppMethodBeat.o(39001);
            return count;
        }
        AppMethodBeat.o(39001);
        return 0;
    }

    public bau getCntMedia() {
        AppMethodBeat.i(39002);
        if (this.rsm != null) {
            int selectedItemPosition = this.rsn.getSelectedItemPosition();
            if (this.items != null && selectedItemPosition < this.items.size()) {
                bau bau = ((com.tencent.mm.plugin.sns.h.b) this.items.get(selectedItemPosition)).cNr;
                AppMethodBeat.o(39002);
                return bau;
            }
        }
        AppMethodBeat.o(39002);
        return null;
    }

    public int getSelectCount() {
        AppMethodBeat.i(39003);
        int size = this.rsP.size();
        AppMethodBeat.o(39003);
        return size;
    }

    public int gettotalSuccDownload() {
        return this.rsR;
    }

    public int getNumOfFileExist() {
        AppMethodBeat.i(39004);
        int i = 0;
        int i2 = 0;
        for (com.tencent.mm.plugin.sns.h.b bVar : this.items) {
            af.cnC();
            if (com.tencent.mm.vfs.e.ct(g.C(bVar.cNr))) {
                i2++;
            }
            int i3 = i + 1;
            if (i3 > 9) {
                break;
            }
            i = i3;
        }
        AppMethodBeat.o(39004);
        return i2;
    }

    public final void bj(String str, boolean z) {
        bau bau;
        AppMethodBeat.i(39005);
        if (!(z || this.rsn.getSelectedItem() == null)) {
            bau = ((com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem()).cNr;
            if (!(bau == null || bau.Id == null || !bau.Id.equals(str))) {
                Toast.makeText(this.context, this.context.getString(R.string.ek_), 0).show();
                this.rsC = str;
            }
        }
        this.rsR++;
        if (this.rps) {
            ab.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", str, Boolean.valueOf(z));
            if (z && this.rsS.containsKey(str)) {
                a aVar = (a) this.rsS.get(str);
                aVar.rsY = System.currentTimeMillis();
                aVar.networkType = getReportNetworkType();
                ab.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
                this.rsI.put(str, Boolean.TRUE);
            }
        }
        if (!(this.rsm == null || this.rsn.getSelectedItem() == null)) {
            bau = ((com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem()).cNr;
            if (!(bau == null || bau.Id == null || !bau.Id.equals(str))) {
                this.rsm.notifyDataSetChanged();
                if (this.rpu) {
                    if (bau == null) {
                        AppMethodBeat.o(39005);
                        return;
                    }
                    String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
                    String l = i.l(bau);
                    if (com.tencent.mm.vfs.e.ct(fZ + l)) {
                        l = fZ + l;
                        Intent intent = new Intent();
                        ab.i("MicroMsg.FlipView", "edit image path:%s", l);
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
        AppMethodBeat.o(39005);
    }

    public final void bk(String str, boolean z) {
        AppMethodBeat.i(39006);
        ab.i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z);
        if (!z) {
            bau bau = ((com.tencent.mm.plugin.sns.h.b) this.rsn.getSelectedItem()).cNr;
            if (!(bau == null || bau.Id == null || !bau.Id.equals(str))) {
                Toast.makeText(this.context, this.context.getString(R.string.eka), 0).show();
                this.rsC = str;
            }
        }
        if (this.rsm != null) {
            this.rsm.notifyDataSetChanged();
        }
        AppMethodBeat.o(39006);
    }

    public List<com.tencent.mm.plugin.sns.h.b> getFlipList() {
        return this.items;
    }

    private int getReportNetworkType() {
        AppMethodBeat.i(39007);
        Context context = ah.getContext();
        if (at.is2G(context)) {
            AppMethodBeat.o(39007);
            return 1;
        } else if (at.is3G(context)) {
            AppMethodBeat.o(39007);
            return 2;
        } else if (at.is4G(context)) {
            AppMethodBeat.o(39007);
            return 3;
        } else if (at.isWifi(context)) {
            AppMethodBeat.o(39007);
            return 4;
        } else {
            AppMethodBeat.o(39007);
            return 0;
        }
    }

    public final void cto() {
        AppMethodBeat.i(39008);
        for (a aVar : this.rsS.values()) {
            if (aVar.rsW != -1) {
                h.pYm.e(11601, Integer.valueOf(aVar.fjN), Integer.valueOf(aVar.rsW), Long.valueOf(aVar.qNk), Integer.valueOf(aVar.networkType));
                ab.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(aVar.fjN), Integer.valueOf(aVar.rsW), Long.valueOf(aVar.qNk), Integer.valueOf(aVar.networkType));
            } else if (aVar.rsX != -1) {
                if (aVar.rsY != -1) {
                    aVar.rsW = 1;
                } else {
                    aVar.rsW = 2;
                    aVar.rsY = System.currentTimeMillis();
                }
                aVar.qNk = aVar.rsY - aVar.rsX;
                h.pYm.e(11601, Integer.valueOf(aVar.fjN), Integer.valueOf(aVar.rsW), Long.valueOf(aVar.qNk), Integer.valueOf(aVar.networkType));
                ab.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(aVar.fjN), Integer.valueOf(aVar.rsW), Long.valueOf(aVar.qNk), Integer.valueOf(aVar.networkType));
            }
        }
        this.rsS.clear();
        AppMethodBeat.o(39008);
    }

    private void a(bau bau, int i, String str) {
        String str2;
        long j = 0;
        AppMethodBeat.i(38991);
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
                if (bau.Id.startsWith("Locall_path")) {
                    str2 = an.fZ(af.getAccSnsPath(), bau.Id) + i.m(bau);
                } else {
                    str2 = an.fZ(af.getAccSnsPath(), bau.Id) + i.d(bau);
                }
                Options amj = com.tencent.mm.sdk.platformtools.d.amj(str2);
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
                    ab.d("MicroMsg.SnsInfoFlip", "set on fling false");
                    mMGestureGallery.yyh = false;
                } else {
                    ab.d("MicroMsg.SnsInfoFlip", "set on fling true");
                    mMGestureGallery.yyh = true;
                }
            }
        }
        if (this.rsM != null) {
            this.rsM.Eb(i);
        }
        n YT = af.cnF().YT(str);
        if (YT != null) {
            com.tencent.mm.plugin.sns.ui.a.a.c(YT, i);
        }
        if (this.rsD == -1) {
            this.rsD = i;
        }
        this.rsE = 1;
        String str3 = bau.Id;
        if (bo.isNullOrNil(str)) {
            this.ris.gt((i + 1) + " / " + this.rsm.getCount(), null);
            AppMethodBeat.o(38991);
            return;
        }
        YT = (n) this.rsN.get(str);
        if (YT == null) {
            YT = af.cnF().YT(str);
            this.rsN.put(str, YT);
        }
        n nVar = YT;
        if (nVar == null) {
            AppMethodBeat.o(38991);
            return;
        }
        if (bau.jCt != 2 && (this.rsn instanceof MMGestureGallery)) {
            ((MMGestureGallery) this.rsn).setLoadQuit(true);
        }
        if (bau.jCt != 6) {
            af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38969);
                    SnsInfoFlip.this.rsm.cts();
                    AppMethodBeat.o(38969);
                }
            });
        }
        ab.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + i + " localId " + str);
        if (this.rsO != i) {
            this.rsp.put(Integer.valueOf(i), Integer.valueOf((this.rsp.containsKey(Integer.valueOf(i)) ? ((Integer) this.rsp.get(Integer.valueOf(i))).intValue() : 0) + 1));
            this.rsq.put(Integer.valueOf(i), Long.valueOf(bo.yz()));
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
                    longValue = bo.az(longValue);
                    j += longValue;
                    this.rsr.put(Integer.valueOf(this.rsO), Long.valueOf(j));
                    ab.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.rsO + " curtime " + j + " passtime " + (((double) longValue) / 1000.0d));
                }
            }
            if (this.rps && this.rsm != null) {
                com.tencent.mm.plugin.sns.h.b bVar = (com.tencent.mm.plugin.sns.h.b) this.rsm.getItem(this.rsO);
                if (bVar != null) {
                    str2 = bVar.cNr.Id;
                    ab.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", str2);
                    if (this.rsS.containsKey(str2)) {
                        a aVar = (a) this.rsS.get(str2);
                        aVar.networkType = getReportNetworkType();
                        if (aVar.rsY != -1) {
                            aVar.rsW = 1;
                            aVar.qNk = aVar.rsY - aVar.rsX;
                            ab.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", Long.valueOf(aVar.qNk));
                        } else {
                            aVar.rsW = 2;
                            aVar.rsY = System.currentTimeMillis();
                            aVar.qNk = aVar.rsY - aVar.rsX;
                            ab.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", Long.valueOf(aVar.qNk));
                        }
                    }
                }
            }
        }
        this.rsO = i;
        if (this.rir != null) {
            this.rir.Zv(str);
        }
        int i2 = nVar.field_createTime;
        TimeLineObject cqu = nVar.cqu();
        String m = aw.m(this.context, ((long) i2) * 1000);
        str2 = null;
        if (!(cqu == null || cqu.xfI == null || cqu.xfI.wbK.size() <= 1)) {
            str2 = (((com.tencent.mm.plugin.sns.h.b) this.items.get(i)).qQe + 1) + " / " + cqu.xfI.wbK.size();
            this.rsE = b(str3, cqu);
        }
        this.ris.gt(String.valueOf(m), str2);
        this.ris.dh(str, i);
        if (this.rsm != null) {
            this.rsm.Ea(i);
        }
        AppMethodBeat.o(38991);
    }

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, String str) {
        AppMethodBeat.i(39010);
        ab.d("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", str);
        if (!snsInfoFlip.rsS.containsKey(str)) {
            a aVar = new a();
            aVar.fjN = snsInfoFlip.getCount();
            aVar.networkType = snsInfoFlip.getReportNetworkType();
            aVar.rsX = System.currentTimeMillis();
            aVar.rsZ = str;
            snsInfoFlip.rsS.put(str, aVar);
            ab.d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
        AppMethodBeat.o(39010);
    }
}
