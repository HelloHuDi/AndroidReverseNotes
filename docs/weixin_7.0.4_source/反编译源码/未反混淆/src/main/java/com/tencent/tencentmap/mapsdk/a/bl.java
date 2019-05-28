package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ic;

public class bl {
    private final String a = "marker_default.png";
    private int b = -1;
    private int c = -1;
    private String d = "";
    private String e = "";
    private String f = "";
    private float g = -1.0f;
    private Bitmap h = null;
    private String i = null;

    public bl(int i) {
        this.b = i;
    }

    public String a() {
        return this.i;
    }

    private String b(Bitmap bitmap) {
        AppMethodBeat.i(100839);
        String obj = bitmap.toString();
        if (obj == null) {
            obj = "";
        }
        obj = obj.replace("android.graphics.Bitmap", "");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        obj = (obj + "@" + bitmap.hashCode() + "@" + width + "@" + height + "@" + bitmap.getRowBytes()) + "@" + bitmap.getPixel(width / 2, height / 2);
        AppMethodBeat.o(100839);
        return obj;
    }

    public Bitmap a(Context context) {
        AppMethodBeat.i(100840);
        Bitmap bitmap;
        if (this.h != null && this.i != null) {
            bitmap = this.h;
            AppMethodBeat.o(100840);
            return bitmap;
        } else if (context == null) {
            AppMethodBeat.o(100840);
            return null;
        } else {
            switch (this.b) {
                case 1:
                    this.i = "res_" + this.c;
                    if (ic.t != null) {
                        this.h = ic.t.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = ic.a(context, this.c);
                        if (!(ic.t == null || this.h == null)) {
                            ic.t.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 2:
                    this.i = "asset_" + this.d;
                    if (ic.t != null) {
                        this.h = ic.t.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = ic.c(context, this.d);
                        if (this.h == null) {
                            this.h = ic.b(context, this.d);
                            if (!(this.h == null || this.d == "color_texture_flat_style.png")) {
                                this.h = ic.b(this.h);
                            }
                        }
                        if (!(ic.t == null || this.h == null)) {
                            ic.t.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.i = "file_" + this.e;
                    if (ic.t != null) {
                        this.h = ic.t.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = ic.a(context, this.e);
                        break;
                    }
                    break;
                case 4:
                    this.i = "path_" + this.f;
                    if (ic.t != null) {
                        this.h = ic.t.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = ic.b(this.f);
                        if (!(ic.t == null || this.h == null)) {
                            ic.t.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 5:
                    this.i = "asset_marker_default.png";
                    if (ic.t != null) {
                        this.h = ic.t.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = ic.b(context, "marker_default.png");
                        if (!(ic.t == null || this.h == null)) {
                            ic.t.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 6:
                    String a = a(this.g);
                    if (a != null) {
                        this.i = "asset_".concat(String.valueOf(a));
                        if (ic.t != null) {
                            this.h = ic.t.a(this.i);
                        }
                        if (this.h == null) {
                            this.h = ic.b(context, a);
                            if (!(ic.t == null || this.h == null)) {
                                ic.t.a(this.i, this.h);
                                break;
                            }
                        }
                    }
                    break;
                case 7:
                    if (this.h != null) {
                        this.i = "bitmap_" + b(this.h);
                        if (!(ic.t == null || this.h == null)) {
                            ic.t.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
            }
            bitmap = this.h;
            AppMethodBeat.o(100840);
            return bitmap;
        }
    }

    private String a(float f) {
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

    public void a(String str) {
        this.d = str;
    }

    public void a(Bitmap bitmap) {
        this.h = bitmap;
    }
}
