package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.plugin.location.model.C28358f;
import com.tencent.p177mm.plugin.location.model.C28360i.C28361a;
import com.tencent.p177mm.plugin.location.model.C39283e;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.plugin.location.model.LocationInfo;
import com.tencent.p177mm.plugin.location.p446ui.impl.TrackPoint;
import com.tencent.p177mm.plugin.location.p446ui.impl.TrackPointAnimAvatar;
import com.tencent.p177mm.plugin.location_soso.ViewManager;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bku;
import com.tencent.p177mm.protocal.protobuf.cie;
import com.tencent.p177mm.protocal.protobuf.cmj;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.location.ui.m */
public final class C28389m {
    private static Object nNN = new Object();
    private C42206a ecy = new C283904();
    private boolean hOy = false;
    Context mContext;
    public cmj nKI;
    private C28361a nKU = new C124015();
    C28354d nLG;
    boolean nLH = false;
    public List<cmj> nNM;
    public TrackPoint nNO;
    TrackPointAnimAvatar nNP;
    boolean nNQ = false;
    public boolean nNR = false;
    public boolean nNS = true;
    public boolean nNT = false;
    public boolean nNU = false;
    public boolean nNV = false;
    public cie nNW;
    public boolean nNX = true;
    public boolean nNY = true;
    private boolean nNZ = false;
    private long nOa = 0;
    private OnTouchListener nOb = new C283911();
    OnClickListener nOc = new C283922();
    OnClickListener nOd = new C124003();
    public C12402a nOe = null;
    protected float neG = 0.0f;
    protected float neH = 0.0f;

    /* renamed from: com.tencent.mm.plugin.location.ui.m$3 */
    class C124003 implements OnClickListener {
        C124003() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113561);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            C28389m.m45028a(C28389m.this, iArr[0], iArr[1]);
            AppMethodBeat.m2505o(113561);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.m$5 */
    class C124015 implements C28361a {
        C124015() {
        }

        /* renamed from: y */
        public final void mo24250y(double d) {
            AppMethodBeat.m2504i(113563);
            if (C28389m.this.nNO != null) {
                C4990ab.m7411d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", Double.valueOf(d));
                C28389m.this.nNO.mo36510z(d);
            }
            AppMethodBeat.m2505o(113563);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.m$a */
    public interface C12402a {
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.m$4 */
    class C283904 implements C42206a {
        C283904() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113562);
            if (z) {
                C28389m c28389m = C28389m.this;
                double d4 = (double) f2;
                double d5 = (double) f;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[refreshMyLocation] ");
                stringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d4), Double.valueOf(d5)}));
                if (c28389m.nKI == null) {
                    c28389m.nKI = new cmj();
                    c28389m.nKI.xkm = new bku();
                    c28389m.nKI.vHl = C1853r.m3846Yz();
                    c28389m.nKI.xkm.vNI = d4;
                    c28389m.nKI.xkm.vNH = d5;
                    if (c28389m.nLH && c28389m.nNQ) {
                        c28389m.bKf();
                    }
                }
                c28389m.nKI.xkm.vNI = d4;
                c28389m.nKI.xkm.vNH = d5;
                Object viewByItag = c28389m.nLG.getViewByItag(c28389m.nKI.vHl);
                if (viewByItag != null) {
                    stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
                } else {
                    TrackPoint trackPoint = new TrackPoint(c28389m.mContext, (ViewManager) c28389m.nLG.getViewManager(), (byte) 0);
                    c28389m.nLG.addView(trackPoint, 0.0d, 0.0d, c28389m.nKI.vHl);
                    trackPoint.mo36504o(d4, d5);
                    if (c28389m.nNV) {
                        trackPoint.setOnAvatarOnClickListener(null);
                        trackPoint.setOnLocationOnClickListener(null);
                        trackPoint.bKE();
                    } else {
                        trackPoint.setOnAvatarOnClickListener(c28389m.nOd);
                        trackPoint.setOnLocationOnClickListener(c28389m.nOc);
                    }
                    trackPoint.setAvatar(c28389m.nKI.vHl);
                    stringBuffer.append("[view is null new one: " + trackPoint.hashCode() + " ] ");
                    c28389m.nNP = new TrackPointAnimAvatar(c28389m.mContext);
                    TrackPoint viewByItag2 = trackPoint;
                }
                C4990ab.m7410d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
                if (viewByItag2 instanceof TrackPoint) {
                    c28389m.nNO = (TrackPoint) viewByItag2;
                    C4990ab.m7410d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
                    c28389m.nNO.mo36503n(d4, d5);
                }
                if (c28389m.nNX) {
                    c28389m.nLG.getIController().setCenter(c28389m.nKI.xkm.vNI, c28389m.nKI.xkm.vNH);
                }
                AppMethodBeat.m2505o(113562);
                return true;
            }
            AppMethodBeat.m2505o(113562);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.m$1 */
    class C283911 implements OnTouchListener {
        C283911() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(113560);
            switch (motionEvent.getAction()) {
                case 0:
                    C28389m.this.neG = motionEvent.getX();
                    C28389m.this.neH = motionEvent.getY();
                    C28389m.this.nOa = System.currentTimeMillis();
                    C28389m.this.hOy = false;
                    break;
                case 1:
                    if (!C28389m.this.hOy && System.currentTimeMillis() - C28389m.this.nOa < 200) {
                        C28389m.m45031c(C28389m.this);
                        break;
                    }
                case 2:
                    if (Math.abs(motionEvent.getX() - C28389m.this.neG) > 10.0f || Math.abs(motionEvent.getY() - C28389m.this.neH) > 10.0f) {
                        C28389m.this.hOy = true;
                        break;
                    }
            }
            AppMethodBeat.m2505o(113560);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.m$2 */
    class C283922 implements OnClickListener {
        C283922() {
        }

        public final void onClick(View view) {
        }
    }

    static {
        AppMethodBeat.m2504i(113576);
        AppMethodBeat.m2505o(113576);
    }

    public C28389m(Context context, C28354d c28354d, boolean z) {
        AppMethodBeat.m2504i(113564);
        this.mContext = context;
        this.nLH = z;
        this.nLG = c28354d;
        this.nNM = new ArrayList();
        c28354d.setMapViewOnTouchListener(this.nOb);
        AppMethodBeat.m2505o(113564);
    }

    /* renamed from: iD */
    public final void mo46369iD(boolean z) {
        AppMethodBeat.m2504i(113565);
        if (z) {
            int i;
            if (this.nNO != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                C7060h.pYm.mo8381e(10997, "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(113565);
        }
        this.nNU = z;
        AppMethodBeat.m2505o(113565);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(113566);
        synchronized (nNN) {
            try {
                if (this.nNM != null) {
                    this.nNM.clear();
                }
                this.nLG.clean();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113566);
            }
        }
    }

    /* renamed from: iE */
    public final void mo46370iE(boolean z) {
        AppMethodBeat.m2504i(113567);
        if (!(!z || this.nNT || this.nLG == null)) {
            for (Object next : this.nLG.getChilds()) {
                if (next instanceof TrackPoint) {
                    ((TrackPoint) next).bKF();
                }
            }
        }
        this.nNT = z;
        AppMethodBeat.m2505o(113567);
    }

    /* renamed from: ci */
    public final void mo46367ci(List<cmj> list) {
        int i;
        AppMethodBeat.m2504i(113568);
        this.nNQ = true;
        int size = this.nNM.size() + 1;
        synchronized (nNN) {
            try {
                this.nNM.clear();
                for (i = 0; i < list.size(); i++) {
                    this.nNM.add(list.get(i));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113568);
            }
        }
        int size2 = this.nNM.size() + 1;
        synchronized (nNN) {
            try {
                Object viewByItag;
                TrackPoint trackPoint;
                Set<String> tags = this.nLG.getTags();
                HashSet hashSet = new HashSet();
                i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.nNM.size()) {
                        break;
                    }
                    hashSet.add(((cmj) this.nNM.get(i2)).vHl);
                    i = i2 + 1;
                }
                LinkedList<String> linkedList = new LinkedList();
                for (String str : tags) {
                    if (!(hashSet.contains(str) || str.endsWith("myAnim"))) {
                        if (this.nNO == null || !this.nNO.equals(this.nLG.getViewByItag(str))) {
                            linkedList.add(str);
                        }
                    }
                }
                for (String str2 : linkedList) {
                    viewByItag = this.nLG.getViewByItag(str2);
                    if (viewByItag instanceof TrackPoint) {
                        trackPoint = (TrackPoint) viewByItag;
                        if (trackPoint.mViewManager != null) {
                            trackPoint.mViewManager.removeView(trackPoint.nRh);
                            trackPoint.mViewManager.removeView(trackPoint.nRi);
                        }
                    }
                    this.nLG.removeViewByTag(str2);
                }
                for (int i3 = 0; i3 < this.nNM.size(); i3++) {
                    cmj cmj = (cmj) this.nNM.get(i3);
                    Object viewByItag2 = this.nLG.getViewByItag(cmj.vHl);
                    C4990ab.m7411d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", Integer.valueOf(i3), cmj.vHl, Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH), Double.valueOf(cmj.xkm.wNP));
                    if (viewByItag2 == null) {
                        TrackPoint trackPoint2 = new TrackPoint(this.mContext, (ViewManager) this.nLG.getViewManager());
                        this.nLG.addView(trackPoint2, cmj.xkm.vNI, cmj.xkm.vNH, cmj.vHl);
                        trackPoint2.mo36504o(cmj.xkm.vNI, cmj.xkm.vNH);
                        trackPoint2.setOnAvatarOnClickListener(this.nOd);
                        trackPoint2.setOnLocationOnClickListener(this.nOc);
                        trackPoint = trackPoint2;
                    } else if (viewByItag2 instanceof TrackPoint) {
                        ((TrackPoint) viewByItag2).mo36503n(cmj.xkm.vNI, cmj.xkm.vNH);
                        viewByItag = viewByItag2;
                    } else {
                        viewByItag = viewByItag2;
                    }
                    if (viewByItag instanceof TrackPoint) {
                        trackPoint = (TrackPoint) viewByItag;
                        trackPoint.setAvatar(cmj.vHl);
                        trackPoint.mo36510z(cmj.xkm.wNP);
                        if (!this.nNT) {
                            trackPoint.bKE();
                        }
                    }
                }
                if (this.nLH && this.nNQ) {
                    if (C1855t.m3896kH(C39287l.bJy().nKN)) {
                        bKf();
                    } else if (this.nNM.size() > 0) {
                        bKf();
                    }
                }
                if (size < 10 && size2 >= 10) {
                    for (Object viewByItag3 : this.nLG.getChilds()) {
                        if (viewByItag3 instanceof TrackPoint) {
                            ((TrackPoint) viewByItag3).bKE();
                        }
                    }
                } else if (size >= 10 && size2 < 10) {
                    for (Object viewByItag32 : this.nLG.getChilds()) {
                        if (viewByItag32 instanceof TrackPoint) {
                            ((TrackPoint) viewByItag32).bKF();
                        }
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(113568);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void bKf() {
        AppMethodBeat.m2504i(113569);
        if (this.nNR) {
            AppMethodBeat.m2505o(113569);
        } else if (this.nKI == null) {
            AppMethodBeat.m2505o(113569);
        } else {
            bKg();
            this.nNR = true;
            AppMethodBeat.m2505o(113569);
        }
    }

    private void bKg() {
        AppMethodBeat.m2504i(113570);
        double d = 0.0d;
        double d2 = 0.0d;
        if (this.nKI == null) {
            AppMethodBeat.m2505o(113570);
            return;
        }
        LocationInfo locationInfo = C39287l.bJy().nKJ;
        if (this.nKI != null && C39283e.m66955j(locationInfo.nJu, locationInfo.nJv)) {
            d = 2.0d * Math.abs(this.nKI.xkm.vNI - locationInfo.nJu);
            d2 = Math.abs(this.nKI.xkm.vNH - locationInfo.nJv) * 2.0d;
        }
        double d3 = d2;
        double d4 = d;
        for (int i = 0; i < this.nNM.size(); i++) {
            cmj cmj = (cmj) this.nNM.get(i);
            if (cmj != null && C39283e.m66955j(cmj.xkm.vNI, cmj.xkm.vNH)) {
                double abs = 2.0d * Math.abs(cmj.xkm.vNI - this.nKI.xkm.vNI);
                d = Math.abs(cmj.xkm.vNH - this.nKI.xkm.vNH) * 2.0d;
                if (abs > d4) {
                    d4 = abs;
                }
                if (d > d3) {
                    d3 = d;
                }
                C4990ab.m7411d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", cmj.vHl, Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH));
            }
        }
        if (Math.abs(d4 - -1000.0d) < 0.5d || Math.abs(d3 - -1000.0d) < 0.5d) {
            AppMethodBeat.m2505o(113570);
            return;
        }
        C4990ab.m7410d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d4) + " maxlng " + (1000000.0d * d3) + " poi " + locationInfo.nJu + " " + locationInfo.nJv);
        if (this.nKI != null) {
            C4990ab.m7411d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", Double.valueOf(this.nKI.xkm.vNI), Double.valueOf(this.nKI.xkm.vNH));
            this.nLG.zoomToSpan(this.nKI.xkm.vNI, this.nKI.xkm.vNH, d4, d3);
            AppMethodBeat.m2505o(113570);
            return;
        }
        if (C39283e.m66955j(locationInfo.nJu, locationInfo.nJv)) {
            this.nLG.zoomToSpan(locationInfo.nJu, locationInfo.nJv, d4, d3);
        }
        AppMethodBeat.m2505o(113570);
    }

    /* renamed from: a */
    public final void mo46365a(C28354d c28354d) {
        AppMethodBeat.m2504i(113571);
        if (this.nKI == null) {
            AppMethodBeat.m2505o(113571);
        } else if (c28354d.getZoomLevel() < 16) {
            c28354d.getIController().animateTo(this.nKI.xkm.vNI, this.nKI.xkm.vNH, 16);
            AppMethodBeat.m2505o(113571);
        } else {
            c28354d.getIController().animateTo(this.nKI.xkm.vNI, this.nKI.xkm.vNH);
            AppMethodBeat.m2505o(113571);
        }
    }

    public final void onResume() {
        AppMethodBeat.m2504i(113572);
        C26443d.agz().mo44207b(this.ecy, true);
        C39287l.bJA().mo46315a(this.nKU);
        AppMethodBeat.m2505o(113572);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(113573);
        C26443d.agz().mo44208c(this.ecy);
        C39287l.bJA().mo46316b(this.nKU);
        AppMethodBeat.m2505o(113573);
    }

    /* renamed from: c */
    static /* synthetic */ void m45031c(C28389m c28389m) {
        boolean z = true;
        AppMethodBeat.m2504i(113574);
        if (c28389m.nNU) {
            c28389m.mo46369iD(false);
        }
        Collection childs = c28389m.nLG.getChilds();
        for (Object next : childs) {
            if (next instanceof TrackPoint) {
                boolean z2;
                if (((TrackPoint) next).nRh.getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            }
        }
        z = false;
        for (Object next2 : childs) {
            if (next2 instanceof TrackPoint) {
                if (z) {
                    ((TrackPoint) next2).bKE();
                } else {
                    ((TrackPoint) next2).bKF();
                }
            }
        }
        AppMethodBeat.m2505o(113574);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m45028a(C28389m c28389m, int i, int i2) {
        AppMethodBeat.m2504i(113575);
        if (c28389m.nNM != null) {
            ArrayList arrayList = new ArrayList();
            float b = (float) C4977b.m7371b(c28389m.mContext, 85.0f);
            for (cmj cmj : c28389m.nNM) {
                Point pointByGeoPoint = c28389m.nLG.getPointByGeoPoint(cmj.xkm.vNI, cmj.xkm.vNH);
                C4990ab.m7411d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y));
                if (C28358f.m44998z(pointByGeoPoint.x, pointByGeoPoint.y, i, i2) < ((double) b)) {
                    arrayList.add(cmj.vHl);
                }
            }
            if (c28389m.nKI != null) {
                Point pointByGeoPoint2 = c28389m.nLG.getPointByGeoPoint(c28389m.nKI.xkm.vNI, c28389m.nKI.xkm.vNH);
                C4990ab.m7411d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(c28389m.nKI.xkm.vNI), Double.valueOf(c28389m.nKI.xkm.vNH), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y));
                if (C28358f.m44998z(pointByGeoPoint2.x, pointByGeoPoint2.y, i, i2) < ((double) b)) {
                    arrayList.add(c28389m.nKI.vHl);
                }
            }
            C4990ab.m7411d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", Integer.valueOf(arrayList.size()));
            if (arrayList.size() > 1) {
                C7060h.pYm.mo8381e(10997, "12", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                C46047b.m85713b(c28389m.mContext, arrayList);
            }
            if (arrayList.size() > 1) {
                AppMethodBeat.m2505o(113575);
                return true;
            }
        }
        AppMethodBeat.m2505o(113575);
        return false;
    }
}
