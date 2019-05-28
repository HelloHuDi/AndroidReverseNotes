package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bl */
public class C5838bl {
    /* renamed from: a */
    private final String f1445a = "marker_default.png";
    /* renamed from: b */
    private int f1446b = -1;
    /* renamed from: c */
    private int f1447c = -1;
    /* renamed from: d */
    private String f1448d = "";
    /* renamed from: e */
    private String f1449e = "";
    /* renamed from: f */
    private String f1450f = "";
    /* renamed from: g */
    private float f1451g = -1.0f;
    /* renamed from: h */
    private Bitmap f1452h = null;
    /* renamed from: i */
    private String f1453i = null;

    public C5838bl(int i) {
        this.f1446b = i;
    }

    /* renamed from: a */
    public String mo12312a() {
        return this.f1453i;
    }

    /* renamed from: b */
    private String m8910b(Bitmap bitmap) {
        AppMethodBeat.m2504i(100839);
        String obj = bitmap.toString();
        if (obj == null) {
            obj = "";
        }
        obj = obj.replace("android.graphics.Bitmap", "");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        obj = (obj + "@" + bitmap.hashCode() + "@" + width + "@" + height + "@" + bitmap.getRowBytes()) + "@" + bitmap.getPixel(width / 2, height / 2);
        AppMethodBeat.m2505o(100839);
        return obj;
    }

    /* renamed from: a */
    public Bitmap mo12311a(Context context) {
        AppMethodBeat.m2504i(100840);
        Bitmap bitmap;
        if (this.f1452h != null && this.f1453i != null) {
            bitmap = this.f1452h;
            AppMethodBeat.m2505o(100840);
            return bitmap;
        } else if (context == null) {
            AppMethodBeat.m2505o(100840);
            return null;
        } else {
            switch (this.f1446b) {
                case 1:
                    this.f1453i = "res_" + this.f1447c;
                    if (C36520ic.f15415t != null) {
                        this.f1452h = C36520ic.f15415t.mo40419a(this.f1453i);
                    }
                    if (this.f1452h == null) {
                        this.f1452h = C36520ic.m60467a(context, this.f1447c);
                        if (!(C36520ic.f15415t == null || this.f1452h == null)) {
                            C36520ic.f15415t.mo40421a(this.f1453i, this.f1452h);
                            break;
                        }
                    }
                    break;
                case 2:
                    this.f1453i = "asset_" + this.f1448d;
                    if (C36520ic.f15415t != null) {
                        this.f1452h = C36520ic.f15415t.mo40419a(this.f1453i);
                    }
                    if (this.f1452h == null) {
                        this.f1452h = C36520ic.m60488c(context, this.f1448d);
                        if (this.f1452h == null) {
                            this.f1452h = C36520ic.m60482b(context, this.f1448d);
                            if (!(this.f1452h == null || this.f1448d == "color_texture_flat_style.png")) {
                                this.f1452h = C36520ic.m60483b(this.f1452h);
                            }
                        }
                        if (!(C36520ic.f15415t == null || this.f1452h == null)) {
                            C36520ic.f15415t.mo40421a(this.f1453i, this.f1452h);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.f1453i = "file_" + this.f1449e;
                    if (C36520ic.f15415t != null) {
                        this.f1452h = C36520ic.f15415t.mo40419a(this.f1453i);
                    }
                    if (this.f1452h == null) {
                        this.f1452h = C36520ic.m60468a(context, this.f1449e);
                        break;
                    }
                    break;
                case 4:
                    this.f1453i = "path_" + this.f1450f;
                    if (C36520ic.f15415t != null) {
                        this.f1452h = C36520ic.f15415t.mo40419a(this.f1453i);
                    }
                    if (this.f1452h == null) {
                        this.f1452h = C36520ic.m60484b(this.f1450f);
                        if (!(C36520ic.f15415t == null || this.f1452h == null)) {
                            C36520ic.f15415t.mo40421a(this.f1453i, this.f1452h);
                            break;
                        }
                    }
                    break;
                case 5:
                    this.f1453i = "asset_marker_default.png";
                    if (C36520ic.f15415t != null) {
                        this.f1452h = C36520ic.f15415t.mo40419a(this.f1453i);
                    }
                    if (this.f1452h == null) {
                        this.f1452h = C36520ic.m60482b(context, "marker_default.png");
                        if (!(C36520ic.f15415t == null || this.f1452h == null)) {
                            C36520ic.f15415t.mo40421a(this.f1453i, this.f1452h);
                            break;
                        }
                    }
                    break;
                case 6:
                    String a = m8909a(this.f1451g);
                    if (a != null) {
                        this.f1453i = "asset_".concat(String.valueOf(a));
                        if (C36520ic.f15415t != null) {
                            this.f1452h = C36520ic.f15415t.mo40419a(this.f1453i);
                        }
                        if (this.f1452h == null) {
                            this.f1452h = C36520ic.m60482b(context, a);
                            if (!(C36520ic.f15415t == null || this.f1452h == null)) {
                                C36520ic.f15415t.mo40421a(this.f1453i, this.f1452h);
                                break;
                            }
                        }
                    }
                    break;
                case 7:
                    if (this.f1452h != null) {
                        this.f1453i = "bitmap_" + m8910b(this.f1452h);
                        if (!(C36520ic.f15415t == null || this.f1452h == null)) {
                            C36520ic.f15415t.mo40421a(this.f1453i, this.f1452h);
                            break;
                        }
                    }
                    break;
            }
            bitmap = this.f1452h;
            AppMethodBeat.m2505o(100840);
            return bitmap;
        }
    }

    /* renamed from: a */
    private String m8909a(float f) {
        if (f < 30.0f) {
            return "RED.png";
        }
        if (f >= 30.0f && f < 60.0f) {
            return "ORANGE.png";
        }
        if (f >= 60.0f && f < 120.0f) {
            return "YELLOW.png";
        }
        if (f >= 120.0f && f < 180.0f) {
            return "GREEN.png";
        }
        if (f >= 180.0f && f < 210.0f) {
            return "CYAN.png";
        }
        if (f >= 210.0f && f < 240.0f) {
            return "AZURE.png";
        }
        if (f >= 240.0f && f < 270.0f) {
            return "BLUE.png";
        }
        if (f >= 270.0f && f < 300.0f) {
            return "VIOLET.png";
        }
        if (f >= 300.0f && f < 330.0f) {
            return "MAGENTAV.png";
        }
        if (f >= 330.0f) {
            return "ROSE.png";
        }
        return null;
    }

    /* renamed from: a */
    public void mo12314a(String str) {
        this.f1448d = str;
    }

    /* renamed from: a */
    public void mo12313a(Bitmap bitmap) {
        this.f1452h = bitmap;
    }
}
