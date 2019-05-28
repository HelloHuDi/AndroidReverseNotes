package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m {
    private static Object nNN = new Object();
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113562);
            if (z) {
                m mVar = m.this;
                double d4 = (double) f2;
                double d5 = (double) f;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[refreshMyLocation] ");
                stringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d4), Double.valueOf(d5)}));
                if (mVar.nKI == null) {
                    mVar.nKI = new cmj();
                    mVar.nKI.xkm = new bku();
                    mVar.nKI.vHl = r.Yz();
                    mVar.nKI.xkm.vNI = d4;
                    mVar.nKI.xkm.vNH = d5;
                    if (mVar.nLH && mVar.nNQ) {
                        mVar.bKf();
                    }
                }
                mVar.nKI.xkm.vNI = d4;
                mVar.nKI.xkm.vNH = d5;
                Object viewByItag = mVar.nLG.getViewByItag(mVar.nKI.vHl);
                if (viewByItag != null) {
                    stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
                } else {
                    TrackPoint trackPoint = new TrackPoint(mVar.mContext, (ViewManager) mVar.nLG.getViewManager(), (byte) 0);
                    mVar.nLG.addView(trackPoint, 0.0d, 0.0d, mVar.nKI.vHl);
                    trackPoint.o(d4, d5);
                    if (mVar.nNV) {
                        trackPoint.setOnAvatarOnClickListener(null);
                        trackPoint.setOnLocationOnClickListener(null);
                        trackPoint.bKE();
                    } else {
                        trackPoint.setOnAvatarOnClickListener(mVar.nOd);
                        trackPoint.setOnLocationOnClickListener(mVar.nOc);
                    }
                    trackPoint.setAvatar(mVar.nKI.vHl);
                    stringBuffer.append("[view is null new one: " + trackPoint.hashCode() + " ] ");
                    mVar.nNP = new TrackPointAnimAvatar(mVar.mContext);
                    TrackPoint viewByItag2 = trackPoint;
                }
                ab.d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
                if (viewByItag2 instanceof TrackPoint) {
                    mVar.nNO = (TrackPoint) viewByItag2;
                    ab.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
                    mVar.nNO.n(d4, d5);
                }
                if (mVar.nNX) {
                    mVar.nLG.getIController().setCenter(mVar.nKI.xkm.vNI, mVar.nKI.xkm.vNH);
                }
                AppMethodBeat.o(113562);
                return true;
            }
            AppMethodBeat.o(113562);
            return false;
        }
    };
    private boolean hOy = false;
    Context mContext;
    public cmj nKI;
    private com.tencent.mm.plugin.location.model.i.a nKU = new com.tencent.mm.plugin.location.model.i.a() {
        public final void y(double d) {
            AppMethodBeat.i(113563);
            if (m.this.nNO != null) {
                ab.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", Double.valueOf(d));
                m.this.nNO.z(d);
            }
            AppMethodBeat.o(113563);
        }
    };
    d nLG;
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
    private OnTouchListener nOb = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(113560);
            switch (motionEvent.getAction()) {
                case 0:
                    m.this.neG = motionEvent.getX();
                    m.this.neH = motionEvent.getY();
                    m.this.nOa = System.currentTimeMillis();
                    m.this.hOy = false;
                    break;
                case 1:
                    if (!m.this.hOy && System.currentTimeMillis() - m.this.nOa < 200) {
                        m.c(m.this);
                        break;
                    }
                case 2:
                    if (Math.abs(motionEvent.getX() - m.this.neG) > 10.0f || Math.abs(motionEvent.getY() - m.this.neH) > 10.0f) {
                        m.this.hOy = true;
                        break;
                    }
            }
            AppMethodBeat.o(113560);
            return false;
        }
    };
    OnClickListener nOc = new OnClickListener() {
        public final void onClick(View view) {
        }
    };
    OnClickListener nOd = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(113561);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            m.a(m.this, iArr[0], iArr[1]);
            AppMethodBeat.o(113561);
        }
    };
    public a nOe = null;
    protected float neG = 0.0f;
    protected float neH = 0.0f;

    public interface a {
    }

    static {
        AppMethodBeat.i(113576);
        AppMethodBeat.o(113576);
    }

    public m(Context context, d dVar, boolean z) {
        AppMethodBeat.i(113564);
        this.mContext = context;
        this.nLH = z;
        this.nLG = dVar;
        this.nNM = new ArrayList();
        dVar.setMapViewOnTouchListener(this.nOb);
        AppMethodBeat.o(113564);
    }

    public final void iD(boolean z) {
        AppMethodBeat.i(113565);
        if (z) {
            int i;
            if (this.nNO != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                h.pYm.e(10997, "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            AppMethodBeat.o(113565);
        }
        this.nNU = z;
        AppMethodBeat.o(113565);
    }

    public final void destroy() {
        AppMethodBeat.i(113566);
        synchronized (nNN) {
            try {
                if (this.nNM != null) {
                    this.nNM.clear();
                }
                this.nLG.clean();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(113566);
            }
        }
    }

    public final void iE(boolean z) {
        AppMethodBeat.i(113567);
        if (!(!z || this.nNT || this.nLG == null)) {
            for (Object next : this.nLG.getChilds()) {
                if (next instanceof TrackPoint) {
                    ((TrackPoint) next).bKF();
                }
            }
        }
        this.nNT = z;
        AppMethodBeat.o(113567);
    }

    public final void ci(List<cmj> list) {
        int i;
        AppMethodBeat.i(113568);
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
                AppMethodBeat.o(113568);
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
                    ab.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", Integer.valueOf(i3), cmj.vHl, Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH), Double.valueOf(cmj.xkm.wNP));
                    if (viewByItag2 == null) {
                        TrackPoint trackPoint2 = new TrackPoint(this.mContext, (ViewManager) this.nLG.getViewManager());
                        this.nLG.addView(trackPoint2, cmj.xkm.vNI, cmj.xkm.vNH, cmj.vHl);
                        trackPoint2.o(cmj.xkm.vNI, cmj.xkm.vNH);
                        trackPoint2.setOnAvatarOnClickListener(this.nOd);
                        trackPoint2.setOnLocationOnClickListener(this.nOc);
                        trackPoint = trackPoint2;
                    } else if (viewByItag2 instanceof TrackPoint) {
                        ((TrackPoint) viewByItag2).n(cmj.xkm.vNI, cmj.xkm.vNH);
                        viewByItag = viewByItag2;
                    } else {
                        viewByItag = viewByItag2;
                    }
                    if (viewByItag instanceof TrackPoint) {
                        trackPoint = (TrackPoint) viewByItag;
                        trackPoint.setAvatar(cmj.vHl);
                        trackPoint.z(cmj.xkm.wNP);
                        if (!this.nNT) {
                            trackPoint.bKE();
                        }
                    }
                }
                if (this.nLH && this.nNQ) {
                    if (t.kH(l.bJy().nKN)) {
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
                AppMethodBeat.o(113568);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void bKf() {
        AppMethodBeat.i(113569);
        if (this.nNR) {
            AppMethodBeat.o(113569);
        } else if (this.nKI == null) {
            AppMethodBeat.o(113569);
        } else {
            bKg();
            this.nNR = true;
            AppMethodBeat.o(113569);
        }
    }

    private void bKg() {
        AppMethodBeat.i(113570);
        double d = 0.0d;
        double d2 = 0.0d;
        if (this.nKI == null) {
            AppMethodBeat.o(113570);
            return;
        }
        LocationInfo locationInfo = l.bJy().nKJ;
        if (this.nKI != null && e.j(locationInfo.nJu, locationInfo.nJv)) {
            d = 2.0d * Math.abs(this.nKI.xkm.vNI - locationInfo.nJu);
            d2 = Math.abs(this.nKI.xkm.vNH - locationInfo.nJv) * 2.0d;
        }
        double d3 = d2;
        double d4 = d;
        for (int i = 0; i < this.nNM.size(); i++) {
            cmj cmj = (cmj) this.nNM.get(i);
            if (cmj != null && e.j(cmj.xkm.vNI, cmj.xkm.vNH)) {
                double abs = 2.0d * Math.abs(cmj.xkm.vNI - this.nKI.xkm.vNI);
                d = Math.abs(cmj.xkm.vNH - this.nKI.xkm.vNH) * 2.0d;
                if (abs > d4) {
                    d4 = abs;
                }
                if (d > d3) {
                    d3 = d;
                }
                ab.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", cmj.vHl, Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH));
            }
        }
        if (Math.abs(d4 - -1000.0d) < 0.5d || Math.abs(d3 - -1000.0d) < 0.5d) {
            AppMethodBeat.o(113570);
            return;
        }
        ab.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d4) + " maxlng " + (1000000.0d * d3) + " poi " + locationInfo.nJu + " " + locationInfo.nJv);
        if (this.nKI != null) {
            ab.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", Double.valueOf(this.nKI.xkm.vNI), Double.valueOf(this.nKI.xkm.vNH));
            this.nLG.zoomToSpan(this.nKI.xkm.vNI, this.nKI.xkm.vNH, d4, d3);
            AppMethodBeat.o(113570);
            return;
        }
        if (e.j(locationInfo.nJu, locationInfo.nJv)) {
            this.nLG.zoomToSpan(locationInfo.nJu, locationInfo.nJv, d4, d3);
        }
        AppMethodBeat.o(113570);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(113571);
        if (this.nKI == null) {
            AppMethodBeat.o(113571);
        } else if (dVar.getZoomLevel() < 16) {
            dVar.getIController().animateTo(this.nKI.xkm.vNI, this.nKI.xkm.vNH, 16);
            AppMethodBeat.o(113571);
        } else {
            dVar.getIController().animateTo(this.nKI.xkm.vNI, this.nKI.xkm.vNH);
            AppMethodBeat.o(113571);
        }
    }

    public final void onResume() {
        AppMethodBeat.i(113572);
        com.tencent.mm.modelgeo.d.agz().b(this.ecy, true);
        l.bJA().a(this.nKU);
        AppMethodBeat.o(113572);
    }

    public final void onPause() {
        AppMethodBeat.i(113573);
        com.tencent.mm.modelgeo.d.agz().c(this.ecy);
        l.bJA().b(this.nKU);
        AppMethodBeat.o(113573);
    }

    static /* synthetic */ void c(m mVar) {
        boolean z = true;
        AppMethodBeat.i(113574);
        if (mVar.nNU) {
            mVar.iD(false);
        }
        Collection childs = mVar.nLG.getChilds();
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
        AppMethodBeat.o(113574);
    }

    static /* synthetic */ boolean a(m mVar, int i, int i2) {
        AppMethodBeat.i(113575);
        if (mVar.nNM != null) {
            ArrayList arrayList = new ArrayList();
            float b = (float) b.b(mVar.mContext, 85.0f);
            for (cmj cmj : mVar.nNM) {
                Point pointByGeoPoint = mVar.nLG.getPointByGeoPoint(cmj.xkm.vNI, cmj.xkm.vNH);
                ab.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y));
                if (f.z(pointByGeoPoint.x, pointByGeoPoint.y, i, i2) < ((double) b)) {
                    arrayList.add(cmj.vHl);
                }
            }
            if (mVar.nKI != null) {
                Point pointByGeoPoint2 = mVar.nLG.getPointByGeoPoint(mVar.nKI.xkm.vNI, mVar.nKI.xkm.vNH);
                ab.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(mVar.nKI.xkm.vNI), Double.valueOf(mVar.nKI.xkm.vNH), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y));
                if (f.z(pointByGeoPoint2.x, pointByGeoPoint2.y, i, i2) < ((double) b)) {
                    arrayList.add(mVar.nKI.vHl);
                }
            }
            ab.d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", Integer.valueOf(arrayList.size()));
            if (arrayList.size() > 1) {
                h.pYm.e(10997, "12", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                b.b(mVar.mContext, arrayList);
            }
            if (arrayList.size() > 1) {
                AppMethodBeat.o(113575);
                return true;
            }
        }
        AppMethodBeat.o(113575);
        return false;
    }
}
