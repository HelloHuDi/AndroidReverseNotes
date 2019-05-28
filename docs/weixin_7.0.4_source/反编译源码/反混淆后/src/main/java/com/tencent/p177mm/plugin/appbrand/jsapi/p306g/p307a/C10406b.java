package com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b */
public interface C10406b extends C33322h {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$o */
    public interface C10402o {
        /* renamed from: ec */
        void mo6165ec(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$u */
    public interface C10404u {
        /* renamed from: a */
        void mo6230a(C10415p c10415p);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$v */
    public static class C10405v {
        public int fillColor;
        public List<C10417h> hNV;
        public int strokeColor;
        public int strokeWidth;
        public int zIndex;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$e */
    public static class C10407e {
        public String buildingId;
        public String buildingName;
        public List<C10408f> hNP;
        public int hNQ;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$f */
    public static class C10408f {
        public String floorName;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$g */
    public static class C10409g {
        public int duration;
        public double hNR;
        public double hNS;
        public double latitude;
        public double longitude;
        public float rotate;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$m */
    public interface C10410m {
        /* renamed from: Bf */
        void mo21934Bf(String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$x */
    public static class C10411x {
        public C10423i hOp;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$d */
    public static class C10412d {
        public String hNN;
        double latitude;
        double longitude;
        public float rotate;

        /* renamed from: g */
        public final void mo21935g(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$n */
    public interface C10413n {
        /* renamed from: b */
        boolean mo6163b(C10418q c10418q);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$w */
    public static class C10414w {
        public C10411x hOo;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$p */
    public static class C10415p {
        public String buildingId;
        public String floorName;
        public double latitude;
        public double longitude;
        public String name;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$a */
    public static class C10416a {
        C10417h hNM;
        public float rotate;
        public float skew;
        public float zoom;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$h */
    public static class C10417h {
        public double latitude;
        public double longitude;

        public C10417h(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$q */
    public static class C10418q {
        public String data;
        public C10427r hOa;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$s */
    public interface C10419s {
        /* renamed from: a */
        void mo21936a(C10416a c10416a);

        /* renamed from: a */
        void mo21937a(C10416a c10416a, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$t */
    public interface C10420t {
        /* renamed from: a */
        void mo21938a(C10407e c10407e);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$b */
    public static class C10421b {
        public int fillColor;
        public double latitude;
        public double longitude;
        public int radius;
        public int strokeColor;
        public int strokeWidth;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$c */
    public static class C10422c {
        public String data;
        public String hNN;
        public boolean hNO;
        public int height;
        public int left;
        public int top;
        public int width;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$i */
    public static class C10423i {
        public C10417h hNT;
        public C10417h hNU;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$j */
    public static class C10424j {
        public int borderColor;
        public int borderWidth;
        public String buildingId;
        public int color;
        public String floorName;
        public List<C10417h> hNV;
        public boolean hNW;
        public boolean hNX;
        public String hNY;
        public int hNZ;
        /* renamed from: id */
        public String f2876id;
        public int style;
        public int width;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$k */
    public interface C10425k {
        /* renamed from: a */
        void mo21939a(C10418q c10418q);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$l */
    public interface C10426l {
        void aDL();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$r */
    public static class C10427r {
        public float alpha;
        public float bDv;
        public float bDw;
        public String buildingId;
        public String data;
        public String floorName;
        public String hNN;
        public float hOb;
        public float hOc;
        public String hOd;
        public C10428a hOe;
        public C10403b hOf;
        public double latitude;
        public double longitude;
        public float rotate;
        public String title;
        public int zIndex;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$r$b */
        public static class C10403b {
            int bgColor;
            int borderColor;
            int borderWidth;
            int color;
            String content;
            int hOg;
            int hOh;
            String hdq;
            int padding;
            /* renamed from: x */
            int f2874x;
            /* renamed from: y */
            int f2875y;

            public C10403b(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str2, int i9) {
                this.content = str;
                this.color = i;
                this.hOg = i2;
                this.f2874x = i3;
                this.f2875y = i4;
                this.bgColor = i5;
                this.hOh = i6;
                this.borderWidth = i7;
                this.borderColor = i8;
                this.hdq = str2;
                this.padding = i9;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.b$r$a */
        public static class C10428a {
            public static int hOm = 0;
            public static int hOn = 1;
            int bgColor;
            int borderColor;
            int borderWidth;
            int color;
            String content;
            int hOg;
            int hOh;
            int hOi;
            int hOj;
            int hOk;
            public int hOl;
            String hdq;
            int padding;
            int shadowColor;

            public C10428a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str2) {
                this.content = str;
                this.color = i;
                this.hOg = i2;
                this.hOh = i3;
                this.borderWidth = i5;
                this.borderColor = i6;
                this.bgColor = i4;
                this.padding = i7;
                this.shadowColor = i8;
                this.hOi = i9;
                this.hOj = i10;
                this.hOk = i11;
                this.hOl = i12;
                this.hdq = str2;
            }
        }

        /* renamed from: K */
        public final void mo21941K(float f, float f2) {
            this.bDv = f;
            this.bDw = f2;
        }
    }

    /* renamed from: Bg */
    boolean mo21880Bg(String str);

    /* renamed from: Bi */
    boolean mo21881Bi(String str);

    /* renamed from: I */
    void mo21882I(float f, float f2);

    /* renamed from: a */
    void mo21883a(float f, float f2, float f3, float f4, float f5);

    /* renamed from: a */
    void mo21884a(C10421b c10421b);

    /* renamed from: a */
    void mo21885a(C10424j c10424j, C19162a c19162a);

    /* renamed from: a */
    void mo21886a(C10425k c10425k);

    /* renamed from: a */
    void mo21887a(C10426l c10426l);

    /* renamed from: a */
    void mo21888a(C10413n c10413n);

    /* renamed from: a */
    void mo21889a(C10419s c10419s);

    /* renamed from: a */
    void mo21890a(C10420t c10420t);

    /* renamed from: a */
    void mo21891a(C10404u c10404u);

    /* renamed from: a */
    void mo21892a(String str, int i, C10417h c10417h, boolean z);

    /* renamed from: a */
    void mo21893a(String str, C10427r c10427r, C19162a c19162a);

    /* renamed from: a */
    void mo21894a(String str, LinkedList<C10409g> linkedList, C10402o c10402o);

    /* renamed from: a */
    boolean mo21895a(C10422c c10422c, C10410m c10410m, C19162a c19162a);

    /* renamed from: a */
    boolean mo21896a(C10412d c10412d, C19162a c19162a);

    /* renamed from: a */
    boolean mo21897a(C10405v c10405v);

    C10414w aDQ();

    void aDR();

    float aDS();

    C10407e aDT();

    boolean aDU();

    C10417h aDV();

    void aDW();

    void aDX();

    void aDY();

    void aDZ();

    void aEa();

    void aEb();

    /* renamed from: al */
    void mo21910al(float f);

    /* renamed from: am */
    void mo21911am(float f);

    /* renamed from: an */
    void mo21912an(float f);

    /* renamed from: ci */
    void mo21913ci(String str, String str2);

    /* renamed from: ed */
    void mo21914ed(boolean z);

    /* renamed from: ee */
    void mo21915ee(boolean z);

    /* renamed from: ef */
    void mo21916ef(boolean z);

    /* renamed from: eg */
    void mo21917eg(boolean z);

    /* renamed from: eh */
    void mo21918eh(boolean z);

    /* renamed from: ei */
    void mo21919ei(boolean z);

    /* renamed from: ej */
    void mo21920ej(boolean z);

    /* renamed from: ek */
    void mo21921ek(boolean z);

    /* renamed from: el */
    void mo21922el(boolean z);

    /* renamed from: em */
    void mo21923em(boolean z);

    /* renamed from: en */
    void mo21924en(boolean z);

    float getSkew();

    View getView();

    int getZoomLevel();

    /* renamed from: h */
    void mo21928h(List<C10417h> list, int i);

    void onDestroy();

    void onPause();

    void onResume();

    void onSizeChanged(int i, int i2);

    void onTouchEvent(MotionEvent motionEvent);
}
