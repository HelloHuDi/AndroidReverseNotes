package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

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
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg */
public class RealSetFillStyleActionPatternArg extends RealSetFillStyleActionArg {
    public static final Creator<RealSetFillStyleActionPatternArg> CREATOR = new C170881();
    public String hdc;
    public String path;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg$1 */
    static class C170881 implements Creator<RealSetFillStyleActionPatternArg> {
        C170881() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionPatternArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103380);
            RealSetFillStyleActionPatternArg realSetFillStyleActionPatternArg = new RealSetFillStyleActionPatternArg(parcel);
            AppMethodBeat.m2505o(103380);
            return realSetFillStyleActionPatternArg;
        }
    }

    public RealSetFillStyleActionPatternArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103381);
        if (C5046bo.isNullOrNil(this.path)) {
            AppMethodBeat.m2505o(103381);
            return false;
        }
        C10148a c10148a = c2102d.hcF;
        Bitmap a = c2102d.hcK.mo5910a(c2102d, this.path);
        if (!(a == null || a.isRecycled())) {
            Shader bitmapShader;
            String str = this.hdc;
            int qb = C42668g.m75571qb(a.getWidth());
            int qb2 = C42668g.m75571qb(a.getHeight());
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
            c10148a.setShader(bitmapShader);
        }
        AppMethodBeat.m2505o(103381);
        return true;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103382);
        if (this == obj) {
            AppMethodBeat.m2505o(103382);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionPatternArg)) {
            AppMethodBeat.m2505o(103382);
            return false;
        } else if (super.equals(obj)) {
            RealSetFillStyleActionPatternArg realSetFillStyleActionPatternArg = (RealSetFillStyleActionPatternArg) obj;
            if (Objects.equals(this.path, realSetFillStyleActionPatternArg.path) && Objects.equals(this.hdc, realSetFillStyleActionPatternArg.hdc)) {
                AppMethodBeat.m2505o(103382);
                return true;
            }
            AppMethodBeat.m2505o(103382);
            return false;
        } else {
            AppMethodBeat.m2505o(103382);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103383);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.path, this.hdc});
        AppMethodBeat.m2505o(103383);
        return hash;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103384);
        super.mo5879i(parcel);
        this.path = parcel.readString();
        this.hdc = parcel.readString();
        AppMethodBeat.m2505o(103384);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103385);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.path);
        parcel.writeString(this.hdc);
        AppMethodBeat.m2505o(103385);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public final void mo30544f(JSONArray jSONArray) {
        AppMethodBeat.m2504i(103386);
        super.mo30544f(jSONArray);
        this.path = jSONArray.optString(1);
        this.hdc = jSONArray.optString(2);
        AppMethodBeat.m2505o(103386);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103387);
        super.mo5880j(jSONObject);
        AppMethodBeat.m2505o(103387);
    }

    static {
        AppMethodBeat.m2504i(103388);
        AppMethodBeat.m2505o(103388);
    }
}
