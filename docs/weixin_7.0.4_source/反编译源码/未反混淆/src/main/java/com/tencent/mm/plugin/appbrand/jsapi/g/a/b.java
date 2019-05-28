package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;
import java.util.List;

public interface b extends h {

    public interface o {
        void ec(boolean z);
    }

    public interface u {
        void a(p pVar);
    }

    public static class v {
        public int fillColor;
        public List<h> hNV;
        public int strokeColor;
        public int strokeWidth;
        public int zIndex;
    }

    public static class e {
        public String buildingId;
        public String buildingName;
        public List<f> hNP;
        public int hNQ;
    }

    public static class f {
        public String floorName;
    }

    public static class g {
        public int duration;
        public double hNR;
        public double hNS;
        public double latitude;
        public double longitude;
        public float rotate;
    }

    public interface m {
        void Bf(String str);
    }

    public static class x {
        public i hOp;
    }

    public static class d {
        public String hNN;
        double latitude;
        double longitude;
        public float rotate;

        public final void g(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }
    }

    public interface n {
        boolean b(q qVar);
    }

    public static class w {
        public x hOo;
    }

    public static class p {
        public String buildingId;
        public String floorName;
        public double latitude;
        public double longitude;
        public String name;
    }

    public static class a {
        h hNM;
        public float rotate;
        public float skew;
        public float zoom;
    }

    public static class h {
        public double latitude;
        public double longitude;

        public h(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }
    }

    public static class q {
        public String data;
        public r hOa;
    }

    public interface s {
        void a(a aVar);

        void a(a aVar, boolean z);
    }

    public interface t {
        void a(e eVar);
    }

    public static class b {
        public int fillColor;
        public double latitude;
        public double longitude;
        public int radius;
        public int strokeColor;
        public int strokeWidth;
    }

    public static class c {
        public String data;
        public String hNN;
        public boolean hNO;
        public int height;
        public int left;
        public int top;
        public int width;
    }

    public static class i {
        public h hNT;
        public h hNU;
    }

    public static class j {
        public int borderColor;
        public int borderWidth;
        public String buildingId;
        public int color;
        public String floorName;
        public List<h> hNV;
        public boolean hNW;
        public boolean hNX;
        public String hNY;
        public int hNZ;
        public String id;
        public int style;
        public int width;
    }

    public interface k {
        void a(q qVar);
    }

    public interface l {
        void aDL();
    }

    public static class r {
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
        public a hOe;
        public b hOf;
        public double latitude;
        public double longitude;
        public float rotate;
        public String title;
        public int zIndex;

        public static class b {
            int bgColor;
            int borderColor;
            int borderWidth;
            int color;
            String content;
            int hOg;
            int hOh;
            String hdq;
            int padding;
            int x;
            int y;

            public b(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str2, int i9) {
                this.content = str;
                this.color = i;
                this.hOg = i2;
                this.x = i3;
                this.y = i4;
                this.bgColor = i5;
                this.hOh = i6;
                this.borderWidth = i7;
                this.borderColor = i8;
                this.hdq = str2;
                this.padding = i9;
            }
        }

        public static class a {
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

            public a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str2) {
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

        public final void K(float f, float f2) {
            this.bDv = f;
            this.bDw = f2;
        }
    }

    boolean Bg(String str);

    boolean Bi(String str);

    void I(float f, float f2);

    void a(float f, float f2, float f3, float f4, float f5);

    void a(b bVar);

    void a(j jVar, com.tencent.mm.plugin.appbrand.d.a aVar);

    void a(k kVar);

    void a(l lVar);

    void a(n nVar);

    void a(s sVar);

    void a(t tVar);

    void a(u uVar);

    void a(String str, int i, h hVar, boolean z);

    void a(String str, r rVar, com.tencent.mm.plugin.appbrand.d.a aVar);

    void a(String str, LinkedList<g> linkedList, o oVar);

    boolean a(c cVar, m mVar, com.tencent.mm.plugin.appbrand.d.a aVar);

    boolean a(d dVar, com.tencent.mm.plugin.appbrand.d.a aVar);

    boolean a(v vVar);

    w aDQ();

    void aDR();

    float aDS();

    e aDT();

    boolean aDU();

    h aDV();

    void aDW();

    void aDX();

    void aDY();

    void aDZ();

    void aEa();

    void aEb();

    void al(float f);

    void am(float f);

    void an(float f);

    void ci(String str, String str2);

    void ed(boolean z);

    void ee(boolean z);

    void ef(boolean z);

    void eg(boolean z);

    void eh(boolean z);

    void ei(boolean z);

    void ej(boolean z);

    void ek(boolean z);

    void el(boolean z);

    void em(boolean z);

    void en(boolean z);

    float getSkew();

    View getView();

    int getZoomLevel();

    void h(List<h> list, int i);

    void onDestroy();

    void onPause();

    void onResume();

    void onSizeChanged(int i, int i2);

    void onTouchEvent(MotionEvent motionEvent);
}
