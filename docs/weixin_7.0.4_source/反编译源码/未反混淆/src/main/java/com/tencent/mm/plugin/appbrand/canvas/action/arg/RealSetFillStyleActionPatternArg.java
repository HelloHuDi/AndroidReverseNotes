package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionPatternArg extends RealSetFillStyleActionArg {
    public static final Creator<RealSetFillStyleActionPatternArg> CREATOR = new Creator<RealSetFillStyleActionPatternArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionPatternArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103380);
            RealSetFillStyleActionPatternArg realSetFillStyleActionPatternArg = new RealSetFillStyleActionPatternArg(parcel);
            AppMethodBeat.o(103380);
            return realSetFillStyleActionPatternArg;
        }
    };
    public String hdc;
    public String path;

    public RealSetFillStyleActionPatternArg(Parcel parcel) {
        super(parcel);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103381);
        if (bo.isNullOrNil(this.path)) {
            AppMethodBeat.o(103381);
            return false;
        }
        a aVar = dVar.hcF;
        Bitmap a = dVar.hcK.a(dVar, this.path);
        if (!(a == null || a.isRecycled())) {
            Shader bitmapShader;
            String str = this.hdc;
            int qb = g.qb(a.getWidth());
            int qb2 = g.qb(a.getHeight());
            Object obj = -1;
            switch (str.hashCode()) {
                case -934531685:
                    if (str.equals("repeat")) {
                        obj = null;
                        break;
                    }
                    break;
                case -724648153:
                    if (str.equals("no-repeat")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -436782906:
                    if (str.equals("repeat-x")) {
                        obj = 1;
                        break;
                    }
                    break;
                case -436782905:
                    if (str.equals("repeat-y")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            Bitmap createBitmap;
            switch (obj) {
                case null:
                    a = Bitmap.createScaledBitmap(a, qb, qb2, false);
                    TileMode tileMode = TileMode.REPEAT;
                    bitmapShader = new BitmapShader(a, tileMode, tileMode);
                    break;
                case 1:
                    createBitmap = Bitmap.createBitmap(qb, qb2 + 1, Config.ARGB_8888);
                    new Canvas(createBitmap).drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(0.0f, 0.0f, (float) qb, (float) qb2), null);
                    bitmapShader = new BitmapShader(createBitmap, TileMode.REPEAT, TileMode.CLAMP);
                    break;
                case 2:
                    createBitmap = Bitmap.createBitmap(qb + 1, qb2, Config.ARGB_8888);
                    new Canvas(createBitmap).drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(0.0f, 0.0f, (float) qb, (float) qb2), null);
                    bitmapShader = new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.REPEAT);
                    break;
                case 3:
                    createBitmap = Bitmap.createBitmap(qb + 1, qb2 + 1, Config.ARGB_8888);
                    new Canvas(createBitmap).drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(0.0f, 0.0f, (float) qb, (float) qb2), null);
                    TileMode tileMode2 = TileMode.CLAMP;
                    bitmapShader = new BitmapShader(createBitmap, tileMode2, tileMode2);
                    break;
                default:
                    bitmapShader = null;
                    break;
            }
            aVar.setShader(bitmapShader);
        }
        AppMethodBeat.o(103381);
        return true;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103382);
        if (this == obj) {
            AppMethodBeat.o(103382);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionPatternArg)) {
            AppMethodBeat.o(103382);
            return false;
        } else if (super.equals(obj)) {
            RealSetFillStyleActionPatternArg realSetFillStyleActionPatternArg = (RealSetFillStyleActionPatternArg) obj;
            if (Objects.equals(this.path, realSetFillStyleActionPatternArg.path) && Objects.equals(this.hdc, realSetFillStyleActionPatternArg.hdc)) {
                AppMethodBeat.o(103382);
                return true;
            }
            AppMethodBeat.o(103382);
            return false;
        } else {
            AppMethodBeat.o(103382);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103383);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.path, this.hdc});
        AppMethodBeat.o(103383);
        return hash;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103384);
        super.i(parcel);
        this.path = parcel.readString();
        this.hdc = parcel.readString();
        AppMethodBeat.o(103384);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103385);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.path);
        parcel.writeString(this.hdc);
        AppMethodBeat.o(103385);
    }

    public int describeContents() {
        return 0;
    }

    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(103386);
        super.f(jSONArray);
        this.path = jSONArray.optString(1);
        this.hdc = jSONArray.optString(2);
        AppMethodBeat.o(103386);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103387);
        super.j(jSONObject);
        AppMethodBeat.o(103387);
    }

    static {
        AppMethodBeat.i(103388);
        AppMethodBeat.o(103388);
    }
}
